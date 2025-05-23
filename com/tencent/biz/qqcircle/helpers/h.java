package com.tencent.biz.qqcircle.helpers;

import com.tencent.biz.qqcircle.manager.diffres.beans.QFSCommentFeedbackResPackage;
import com.tencent.qphone.base.util.QLog;
import fa0.d;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h implements d.a {

    /* renamed from: e, reason: collision with root package name */
    private static volatile h f84622e;

    /* renamed from: d, reason: collision with root package name */
    private final fa0.d<QFSCommentFeedbackResPackage> f84623d = new fa0.d<>(new QFSCommentFeedbackResPackage());

    h() {
    }

    public static h a() {
        if (f84622e == null) {
            synchronized (r.class) {
                if (f84622e == null) {
                    f84622e = new h();
                }
            }
        }
        return f84622e;
    }

    @Override // fa0.d.a
    public void A2() {
        QLog.d("QFSCommentFeedbackResLoadHelper", 1, "onPreloadSucceed");
    }

    public String b(String str) {
        return this.f84623d.n(QFSCommentFeedbackResPackage.DOWNLOAD_ZIP_URL, "animation", str);
    }

    public boolean c() {
        return this.f84623d.r();
    }

    public void d() {
        if (!this.f84623d.r()) {
            QLog.d("QFSCommentFeedbackResLoadHelper", 1, "[preLoadRes]");
            this.f84623d.x(this);
            this.f84623d.v();
            return;
        }
        QLog.d("QFSCommentFeedbackResLoadHelper", 1, "[preLoadRes] has loaded");
    }

    @Override // fa0.d.a
    public void h4() {
        QLog.e("QFSCommentFeedbackResLoadHelper", 1, "onPreloadError");
    }
}
