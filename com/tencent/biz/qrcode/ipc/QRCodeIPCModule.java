package com.tencent.biz.qrcode.ipc;

import android.os.Bundle;
import com.tencent.biz.qrcode.mgr.MyQRCodeManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qrcode/ipc/QRCodeIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "()V", "onCall", "Leipc/EIPCResult;", "action", "", "params", "Landroid/os/Bundle;", "callbackId", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class QRCodeIPCModule extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final QRCodeIPCModule f94940d = new QRCodeIPCModule();

    QRCodeIPCModule() {
        super("QRCodeIPCModule");
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, final int callbackId) {
        String str;
        String str2;
        String str3;
        boolean z16;
        if (Intrinsics.areEqual(action, "action_set_my_aigc_qrcode")) {
            MyQRCodeManager.f94961a.J(new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qrcode.ipc.QRCodeIPCModule$onCall$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17) {
                    if (z17) {
                        QRCodeIPCModule.f94940d.callbackResult(callbackId, EIPCResult.createSuccessResult(new Bundle()));
                    } else {
                        QRCodeIPCModule.f94940d.callbackResult(callbackId, EIPCResult.createResult(-1, new Bundle()));
                    }
                }
            });
        } else if (Intrinsics.areEqual(action, "action_set_troop_aigc_qrcode")) {
            QLog.i("QRCodeIPCModule", 1, "[onCall], action = " + action + ", params = " + params + ", callbackId = " + callbackId);
            if (params != null) {
                str = params.getString("groupId");
            } else {
                str = null;
            }
            if (params != null) {
                str2 = params.getString(WadlProxyConsts.CHANNEL);
            } else {
                str2 = null;
            }
            if (params != null) {
                str3 = params.getString("downloadUrl");
            } else {
                str3 = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.i("QRCodeIPCModule", 1, "[onCall], groupId = " + str);
                callbackResult(callbackId, EIPCResult.createResult(-1, new Bundle()));
                return null;
            }
            QRDisplayTroopCardManager.INSTANCE.a(str, str2, str3, new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qrcode.ipc.QRCodeIPCModule$onCall$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17) {
                    if (z17) {
                        QLog.i("QRCodeIPCModule", 1, "[ACTION_SET_TROOP_AIGC_QRCODE] success = true");
                        QRCodeIPCModule.f94940d.callbackResult(callbackId, EIPCResult.createSuccessResult(new Bundle()));
                    } else {
                        QLog.i("QRCodeIPCModule", 1, "[ACTION_SET_TROOP_AIGC_QRCODE] success = false");
                        QRCodeIPCModule.f94940d.callbackResult(callbackId, EIPCResult.createResult(-1, new Bundle()));
                    }
                }
            });
        }
        return null;
    }
}
