package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends bs {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s() {
        new com.tencent.biz.qqcircle.comment.recpic.db.a(RFWApplication.getApplication()).b();
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return "QCircleClearLocalCacheController";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return "\u662f\u5426\u6e05\u9664\u77ed\u77ed\u63a8\u56fe\u672c\u5730\u7f13\u5b58";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        if (q() != i3) {
            com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.I();
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.debug.controller.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.s();
                }
            });
        }
        super.g(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }
}
