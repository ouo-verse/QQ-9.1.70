package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.tencent.biz.qqcircle.beans.QCircleFirstInteractMsgArrayBean;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cf {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f86058a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private List<String> f86059b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<String> f86060c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private boolean f86061d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends TypeToken<List<QCircleFirstInteractMsgArrayBean>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends TypeToken<List<QCircleFirstInteractMsgArrayBean>> {
        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        static cf f86064a = new cf();
    }

    private void a(List<QCircleFirstInteractMsgArrayBean> list, String str, List<String> list2) {
        if (list != null && list2 != null) {
            for (QCircleFirstInteractMsgArrayBean qCircleFirstInteractMsgArrayBean : list) {
                if (qCircleFirstInteractMsgArrayBean != null && TextUtils.equals(qCircleFirstInteractMsgArrayBean.f82687id, str)) {
                    list2.addAll(qCircleFirstInteractMsgArrayBean.message);
                    if (QLog.isColorLevel()) {
                        QLog.d("QFSFeedFirstCommentAndPushManager", 2, str + Arrays.toString(list2.toArray()));
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static cf b() {
        return c.f86064a;
    }

    private void c() {
        this.f86061d = true;
        List<QCircleFirstInteractMsgArrayBean> list = (List) com.tencent.biz.qqcircle.utils.bv.a(QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_first_push_and_comment_message_json", " [{\n        \"id\": \"push\",\n                \"message\": [\"\u8c22\u8c22\uff0c\u4f60\u7684\u9996\u63a8\u5bf9\u4f5c\u8005\u5f88\u91cd\u8981\", \"\u80fd\u88ab\u4f60\u9996\u63a8\u7684\u89c6\u9891\u4e00\u5b9a\u5f88\u6709\u8da3\u5427\", \"\u611f\u8c22\u9996\u63a8\uff0c\u706b\u4e86\u6709\u4f60\u4e00\u4efd\u529f\u52b3\", \"\u8c22\u8c22\u4f60\u7684\u9996\u63a8\uff0c\u8fd9\u5fc5\u662f\u5b9d\u85cf\u89c6\u9891\"]\n    }, {\n        \"id\": \"comment\",\n                \"message\": [\"\u8c22\u8c22\uff0c\u4f60\u7684\u9996\u8bc4\u662f\u4f5c\u8005\u7684\u65e0\u9650\u52a8\u529b\", \"\u80fd\u88ab\u4f60\u9996\u8bc4\u7684\u89c6\u9891\u4e00\u5b9a\u5f88\u6709\u8da3\u5427\", \"\u611f\u8c22\u9996\u8bc4\uff0c\u706b\u4e86\u6709\u4f60\u4e00\u4efd\u529f\u52b3\", \"\u8c22\u8c22\u4f60\u7684\u9996\u8bc4\uff0c\u8fd9\u5fc5\u662f\u5b9d\u85cf\u89c6\u9891\"]\n    }]"), new a().getType());
        List<QCircleFirstInteractMsgArrayBean> list2 = (List) com.tencent.biz.qqcircle.utils.bv.a(" [{\n        \"id\": \"comment\",\n                \"message\": [\"\u8c22\u8c22\uff0c\u4f60\u7684\u8bc4\u8bba\u662f\u4f5c\u8005\u7684\u65e0\u9650\u52a8\u529b\", \"\u80fd\u88ab\u4f60\u8bc4\u8bba\u7684\u89c6\u9891\u4e00\u5b9a\u5f88\u6709\u8da3\u5427\", \"\u611f\u8c22\u8bc4\u8bba\uff0c\u706b\u4e86\u6709\u4f60\u4e00\u4efd\u529f\u52b3\", \"\u8c22\u8c22\u4f60\u7684\u8bc4\u8bba\uff0c\u8fd9\u5fc5\u662f\u5b9d\u85cf\u89c6\u9891\"]\n    }]", new b().getType());
        if (list != null) {
            a(list, "push", this.f86058a);
            a(list, "comment", this.f86059b);
        } else {
            QLog.d("QFSFeedFirstCommentAndPushManager", 1, "firstFeedBackCopyWritingList is null");
        }
        a(list2, "comment", this.f86060c);
    }

    public void d() {
        if (!this.f86061d) {
            c();
        }
        List<String> list = this.f86059b;
        if (list != null && list.size() != 0) {
            Collections.shuffle(this.f86059b);
            QCircleToast.l(QCircleToast.f91646f, this.f86059b.get(0), 1, true, true);
        }
    }

    public void e() {
        if (!uq3.c.I6()) {
            return;
        }
        if (!this.f86061d) {
            c();
        }
        h(this.f86059b);
    }

    public void f() {
        if (!this.f86061d) {
            c();
        }
        h(this.f86058a);
    }

    public void g() {
        if (!this.f86061d) {
            c();
        }
        h(this.f86060c);
    }

    public void h(List<String> list) {
        if (list != null && list.size() > 0) {
            String str = list.get(new SecureRandom().nextInt(list.size()));
            if (!TextUtils.isEmpty(str)) {
                QCircleToast.l(QCircleToast.f91646f, str, 1, true, false);
            }
        }
    }
}
