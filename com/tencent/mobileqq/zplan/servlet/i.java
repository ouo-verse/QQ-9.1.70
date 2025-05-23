package com.tencent.mobileqq.zplan.servlet;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/i;", "", "", "overwriteAppearanceKey", "", "zips", "updatedExpirationTime", "Lmu4/c;", "c", "errMsg", "Lnk3/g;", "callback", "", "b", "appearanceKey", "e", "", "overWriteTime", "f", "reqEggName", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f335409a = new i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/i$b", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ nk3.g f335410d;

        b(nk3.g gVar) {
            this.f335410d = gVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            List<String> mutableList;
            List<String> mutableList2;
            QLog.w("ZPlanEasterEggAvatarRequest", 1, "request requestGetEasterEggAvatar onUpdate, type " + type + ", success: " + isSuccess);
            if (!isSuccess) {
                i.f335409a.b("request ZPLAN_EASTER_EGG_AVATAR_GET failed.", this.f335410d);
                return;
            }
            try {
                mu4.b c16 = mu4.b.c(data instanceof byte[] ? (byte[]) data : null);
                nk3.g gVar = this.f335410d;
                String str = c16.f417640b;
                if (str == null || str.length() == 0) {
                    QLog.e("ZPlanEasterEggAvatarRequest", 1, "expirationTimestamp info from remote null or empty!");
                    String[] strArr = c16.f417639a;
                    Intrinsics.checkNotNullExpressionValue(strArr, "this.avatarEasterEggZips");
                    mutableList2 = ArraysKt___ArraysKt.toMutableList(strArr);
                    gVar.a(mutableList2, 0L);
                    return;
                }
                String[] strArr2 = c16.f417639a;
                Intrinsics.checkNotNullExpressionValue(strArr2, "this.avatarEasterEggZips");
                mutableList = ArraysKt___ArraysKt.toMutableList(strArr2);
                String str2 = c16.f417640b;
                Intrinsics.checkNotNullExpressionValue(str2, "this.expirationTimestamp");
                gVar.a(mutableList, Long.parseLong(str2));
                QLog.w("ZPlanEasterEggAvatarRequest", 1, "request requestGetEasterEggAvatar, zipList:" + c16.f417639a);
            } catch (Exception e16) {
                i.f335409a.b("request requestGetEasterEggAvatar failed, exception: " + e16, this.f335410d);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/i$c", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zplan.servlet.b {
        c() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            QLog.w("ZPlanEasterEggAvatarRequest", 1, "request requestOverwriteEasterEggAvatar onUpdate, type:" + type + ", success: " + isSuccess);
            if (isSuccess) {
                try {
                    mu4.d.c(data instanceof byte[] ? (byte[]) data : null);
                    QLog.w("ZPlanEasterEggAvatarRequest", 1, "request requestOverwriteEasterEggAvatar parse");
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.w("ZPlanEasterEggAvatarRequest", 1, "request requestOverwriteEasterEggAvatar failed.", e16);
                }
            }
        }
    }

    i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String errMsg, nk3.g callback) {
        QLog.w("ZPlanEasterEggAvatarRequest", 1, errMsg);
        callback.onError(errMsg);
    }

    private final mu4.c c(String overwriteAppearanceKey, List<String> zips, String updatedExpirationTime) {
        mu4.c cVar = new mu4.c();
        cVar.f417641a = overwriteAppearanceKey;
        Object[] array = zips.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        cVar.f417642b = (String[]) array;
        cVar.f417643c = updatedExpirationTime;
        return cVar;
    }

    public final void d(String reqEggName) {
        Intrinsics.checkNotNullParameter(reqEggName, "reqEggName");
        QLog.i("ZPlanEasterEggAvatarRequest", 1, "do reportEasterEgg, name: " + reqEggName);
        a aVar = new a();
        mu4.e eVar = new mu4.e();
        eVar.f417644a = reqEggName;
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("trpc.zplan.avatar_easter_egg.Handle.SsoReportEgg", MessageNano.toByteArray(eVar), aVar);
        }
    }

    public final void e(String appearanceKey, nk3.g callback) {
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b bVar = new b(callback);
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            mu4.a aVar = new mu4.a();
            aVar.f417638a = appearanceKey;
            Unit unit = Unit.INSTANCE;
            a16.request("trpc.zplan.avatar_easter_egg.Handle.SsoGetAvatarEasterEgg", MessageNano.toByteArray(aVar), bVar);
        }
    }

    public final void f(String appearanceKey, List<String> zips, long overWriteTime) {
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        Intrinsics.checkNotNullParameter(zips, "zips");
        c cVar = new c();
        mu4.c c16 = c(appearanceKey, zips, String.valueOf(overWriteTime));
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("trpc.zplan.avatar_easter_egg.Handle.SsoOverwriteAvatarEasterEgg", MessageNano.toByteArray(c16), cVar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/i$a", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mobileqq.zplan.servlet.b {
        a() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
        }
    }
}
