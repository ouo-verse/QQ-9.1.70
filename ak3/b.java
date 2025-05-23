package ak3;

import com.epicgames.ue4.ZPlanVersion;
import com.google.protobuf.nano.MessageNano;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qu4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J-\u0010\u0011\u001a\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lak3/b;", "", "", "", "uins", "scene", "Ls45/a;", "b", "([Ljava/lang/String;Ljava/lang/String;)Ls45/a;", "Ls45/b;", "rsp", "", "Ldw4/b;", "d", "Lak3/a;", "listener", "", "c", "([Ljava/lang/String;Lak3/a;Ljava/lang/String;)V", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f26251a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"ak3/b$a", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ak3.a f26252d;

        a(ak3.a aVar) {
            this.f26252d = aVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            QLog.i("ZPlanAvatarDressInfoHelper", 1, "getOtherDressInfo request service done, isSuccess: " + isSuccess);
            if (isSuccess && data != null) {
                s45.b c16 = s45.b.c((byte[]) data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data as ByteArray)");
                List<dw4.b> d16 = b.f26251a.d(c16);
                if (d16.isEmpty()) {
                    QLog.e("ZPlanAvatarDressInfoHelper", 1, "getOtherDressInfo failed, dressInfoRsp empty.");
                    this.f26252d.onError("getOtherDressInfo failed, rsp empty.");
                    return;
                } else {
                    this.f26252d.onSuccess(d16);
                    return;
                }
            }
            QLog.e("ZPlanAvatarDressInfoHelper", 1, "request service failed, isSuccess: " + isSuccess + ", callback emptyData: " + (data == null));
            this.f26252d.onError("request service failed.");
        }
    }

    b() {
    }

    private final s45.a b(String[] uins, String scene) {
        QLog.i("ZPlanAvatarDressInfoHelper", 1, "create getAvatarDressInfoReq, ueVersion: " + ZPlanVersion.ZPlanVersion + ", uins size: " + uins.length);
        s45.a aVar = new s45.a();
        n nVar = new n();
        nVar.f429622a = ZPlanVersion.ZPlanVersion;
        aVar.f433316c = nVar;
        aVar.f433317d = uins;
        aVar.f433314a = Intrinsics.areEqual(scene, "login") ? 1 : 100;
        aVar.f433318e = true;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<dw4.b> d(s45.b rsp) {
        dw4.b[] bVarArr = rsp.f433322a;
        ArrayList arrayList = new ArrayList();
        if (bVarArr != null) {
            for (dw4.b it : bVarArr) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(it);
            }
        }
        return arrayList;
    }

    public final void c(String[] uins, ak3.a listener, String scene) {
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!(uins.length == 0) && uins.length <= 10) {
            s45.a b16 = b(uins, scene);
            ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
            if (a16 != null) {
                a16.request("trpc.zplan.dressup_info.dressupInfo.SsoGetAvatarDressInfo", MessageNano.toByteArray(b16), new a(listener));
                return;
            }
            return;
        }
        QLog.e("ZPlanAvatarDressInfoHelper", 1, "getOtherDressInfo failed, uin array invalid, size: " + uins.length + ".");
        listener.onError("uin array invalid.");
    }
}
