package com.tencent.qqnt.qwallet.aio.hb;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.db.HbCommandEntity;
import com.tencent.qqnt.qwallet.db.HbStateEntity;
import com.tencent.qqnt.qwallet.db.QWalletDBManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/h;", "Lcom/tencent/qqnt/qwallet/aio/hb/j;", "", "b2", "O1", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h extends j {
    private final void b2() {
        if (T1()) {
            QLog.d(getTAG(), 1, "saveCommand: hb expired " + M1().m() + ", " + M1().getTitle() + " ");
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.hb.g
            @Override // java.lang.Runnable
            public final void run() {
                h.c2(h.this);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0048, code lost:
    
        if (r0 == true) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c2(h this$0) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String c16 = com.tencent.mobileqq.base.a.c();
        QWalletDBManager qWalletDBManager = QWalletDBManager.f361825a;
        HbStateEntity y16 = qWalletDBManager.y(this$0.M1().m(), c16);
        if (y16 != null) {
            str = y16.getText();
        } else {
            str = null;
        }
        boolean z17 = true;
        QLog.d(this$0.getTAG(), 1, "queryHbStateEntity: " + str);
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        z17 = false;
        if (z17) {
            return;
        }
        qWalletDBManager.g(new HbCommandEntity(this$0.M1().m(), this$0.M1().getTitle(), this$0.M1().f(), this$0.M1().getSenderUin(), this$0.M1().getPeerUin(), this$0.M1().e(), this$0.M1().getChatType(), this$0.M1().n(), this$0.M1().h().uint32_pay_flag.get(), this$0.M1().h().uint32_hb_flag.get(), this$0.M1().l().uint32_resource_type.get(), this$0.M1().l().uint32_hb_from.get()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.j, com.tencent.qqnt.qwallet.aio.hb.c, com.tencent.qqnt.qwallet.aio.c
    public void O1() {
        super.O1();
        b2();
    }
}
