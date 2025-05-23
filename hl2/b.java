package hl2;

import android.os.Bundle;
import com.qwallet.protocol.Wallet.pb.pet.PetSsoGateway$SsoLcPetRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.observer.BusinessObserver;
import pl2.o;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ o f405252d;

    public b(o oVar) {
        this.f405252d = oVar;
    }

    @Override // mqq.observer.BusinessObserver
    public final void onReceive(int i3, boolean z16, Bundle bundle) {
        int i16;
        String str;
        if (bundle != null) {
            i16 = bundle.getInt("rsp_code");
        } else {
            i16 = 1001;
        }
        if (bundle != null) {
            str = bundle.getString("rsp_msg");
        } else {
            str = null;
        }
        if (z16) {
            try {
                MessageMicro rsp = ((MessageMicro) PetSsoGateway$SsoLcPetRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                o oVar = this.f405252d;
                if (oVar != null) {
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    oVar.onSuccess((o) rsp);
                    return;
                }
                return;
            } catch (Exception unused) {
                QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + PetSsoGateway$SsoLcPetRsp.class + " failed.");
                o oVar2 = this.f405252d;
                if (oVar2 != null) {
                    oVar2.onFail(i16, p.INSTANCE.a());
                    return;
                }
                return;
            }
        }
        o oVar3 = this.f405252d;
        if (oVar3 != null) {
            if (str == null) {
                str = "empty bundle";
            }
            oVar3.onFail(i16, str);
        }
    }
}
