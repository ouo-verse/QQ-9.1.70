package mb3;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lmb3/a;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "registerModule", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "", "e", "Z", "sInRegister", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    public static final a f416521d = new a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean sInRegister;

    a() {
        super("wxa_qipc_module");
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String action, Bundle params, int callbackId) {
        d.f416525a.e(action, params, callbackId);
        EIPCResult createResult = EIPCResult.createResult(0, null);
        Intrinsics.checkNotNullExpressionValue(createResult, "createResult(0, null)");
        return createResult;
    }

    public final void registerModule() {
        if (sInRegister) {
            return;
        }
        try {
            QIPCClientHelper.getInstance().register(this);
            sInRegister = true;
        } catch (Exception e16) {
            QLog.e("[wxa-q]WxaIPCModule", 1, "registerModule failed, e=", e16);
        }
    }
}
