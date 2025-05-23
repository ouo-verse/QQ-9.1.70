package com.tencent.mobileqq.ecshop.api;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqshop.api.d;
import com.tencent.mobileqq.qqshop.message.e;
import com.tencent.mobileqq.qqshop.publicaccount.adapter.AdVideoCardHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "lastMsgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class QQShopModule$startQQShop$2 extends Lambda implements Function1<MsgRecord, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $entrance;
    final /* synthetic */ boolean $hasRedPoint;
    final /* synthetic */ String $qggExt;
    final /* synthetic */ long $userClickTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQShopModule$startQQShop$2(String str, int i3, boolean z16, long j3, Context context) {
        super(1);
        this.$qggExt = str;
        this.$entrance = i3;
        this.$hasRedPoint = z16;
        this.$userClickTime = j3;
        this.$context = context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String qggExt, int i3, boolean z16, long j3, MsgRecord msgRecord, String str, Context context) {
        Intrinsics.checkNotNullParameter(qggExt, "$qggExt");
        Intrinsics.checkNotNullParameter(context, "$context");
        new d(com.tencent.mobileqq.ecshop.utils.c.f203952a.b(qggExt), i3, z16, j3, msgRecord, str).c(context);
        AdVideoCardHolder.INSTANCE.d();
        if (z16) {
            QQShopModule.f203940a.g(context, msgRecord);
        }
        if (msgRecord != null) {
            if (QLog.isColorLevel()) {
                e.INSTANCE.a("QQShopModule startQQShop", msgRecord);
                QLog.i("QQShopModule", 2, "startQQShop " + msgRecord);
                return;
            }
            return;
        }
        QLog.i("QQShopModule", 1, "startQQShop lastMsgRecord = null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MsgRecord msgRecord) {
        invoke2(msgRecord);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final MsgRecord msgRecord) {
        final String e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgRecord);
            return;
        }
        com.tencent.mobileqq.qqshop.abtest.a.f274440a.b();
        com.tencent.mobileqq.qqshop.publicaccount.d dVar = com.tencent.mobileqq.qqshop.publicaccount.d.f274576a;
        dVar.a();
        dVar.o();
        com.tencent.mobileqq.qqshop.message.a.f274473a.u(msgRecord, false);
        e16 = QQShopModule.f203940a.e(msgRecord);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final String str = this.$qggExt;
        final int i3 = this.$entrance;
        final boolean z16 = this.$hasRedPoint;
        final long j3 = this.$userClickTime;
        final Context context = this.$context;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ecshop.api.c
            @Override // java.lang.Runnable
            public final void run() {
                QQShopModule$startQQShop$2.b(str, i3, z16, j3, msgRecord, e16, context);
            }
        });
    }
}
