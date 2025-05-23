package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSFriendCommentGuideUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f92603a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f92604b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static boolean f92605c = false;

    /* renamed from: d, reason: collision with root package name */
    private static long f92606d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static int f92607e = -1;

    public static void c(String str) {
        List<String> list = f92603a;
        if (list.contains(str)) {
            return;
        }
        if (list.size() < 3) {
            list.add(str);
        }
        if (list.size() == 3) {
            f92605c = true;
        }
        f92607e++;
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.QFSFriendCommentGuideUtil.1
            @Override // java.lang.Runnable
            public void run() {
                int e16 = uq3.k.a().e("friend_comment_guide_show_times", 0);
                if (e16 >= 3) {
                    QFSFriendCommentGuideUtil.f92605c = true;
                    return;
                }
                uq3.k.a().m("friend_comment_guide_show_times", e16 + 1);
                QFSFriendCommentGuideUtil.l();
            }
        });
    }

    private static void d() {
        List<String> list = f92604b;
        if (list.size() != 0) {
            return;
        }
        String h16 = uq3.k.a().h("friend_comment_guide_has_cmt_list", "");
        if (TextUtils.isEmpty(h16)) {
            return;
        }
        list.addAll(Arrays.asList(h16.split(",")));
    }

    private static void e() {
        f92604b.clear();
        uq3.k.a().p("friend_comment_guide_has_cmt_list", "");
    }

    public static void f(String str) {
        List<String> list = f92603a;
        if (!list.contains(str)) {
            return;
        }
        list.remove(str);
        m(str);
    }

    private static long g() {
        long j3 = f92606d;
        if (j3 > 0) {
            return j3;
        }
        return uq3.k.a().f("friend_comment_guide_show_date", 0L);
    }

    private static long h() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - ((TimeZone.getDefault().getRawOffset() + currentTimeMillis) % 86400000);
    }

    public static boolean i(String str) {
        if (j()) {
            f92603a.clear();
            e();
            k();
        }
        boolean z16 = false;
        if (f92603a.contains(str)) {
            return false;
        }
        d();
        if (f92604b.contains(str)) {
            return true;
        }
        if (f92607e < 0) {
            f92607e = uq3.k.a().e("friend_comment_guide_show_times", 0);
        }
        if (f92607e >= 3) {
            z16 = true;
        }
        f92605c = z16;
        return z16;
    }

    public static boolean j() {
        if (h() - g() >= 86400000) {
            return true;
        }
        return false;
    }

    public static void k() {
        f92607e = 0;
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.QFSFriendCommentGuideUtil.2
            @Override // java.lang.Runnable
            public void run() {
                uq3.k.a().m("friend_comment_guide_show_times", 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        f92606d = h();
        uq3.k.a().n("friend_comment_guide_show_date", f92606d);
    }

    private static void m(String str) {
        List<String> list = f92604b;
        list.add(str);
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(',');
        }
        uq3.k.a().p("friend_comment_guide_has_cmt_list", sb5.toString());
    }
}
