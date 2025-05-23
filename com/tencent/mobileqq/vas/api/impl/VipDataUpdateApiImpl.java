package com.tencent.mobileqq.vas.api.impl;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDataHelperApi;
import com.tencent.mobileqq.vas.api.IVipDataUpdateApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VipDataUpdateApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi;", "", "uin", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$RequestResultCallback;", "callback", "", "requestAvatarPendantInfoChanged", "", "fixRequestFrequency", "Z", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipDataUpdateApiImpl implements IVipDataUpdateApi {

    @NotNull
    private static final String TAG = "VipDataUpdateApiImpl";
    private final boolean fixRequestFrequency = com.tencent.mobileqq.vas.ar.INSTANCE.b("shouyouye", "2024-12-12", "vas_bug_fix_request_avatar_pendant_frequency").isEnable(true);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VipDataUpdateApiImpl$b", "Lcom/tencent/mobileqq/vas/api/IVasDataHelperApi$RequestCallback;", "", "callbackKey", "", "avatarId", "", "pendantId", "pendantDiyId", "", "call", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IVasDataHelperApi.RequestCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IVipDataUpdateApi.RequestResultCallback f308554a;

        b(IVipDataUpdateApi.RequestResultCallback requestResultCallback) {
            this.f308554a = requestResultCallback;
        }

        @Override // com.tencent.mobileqq.vas.api.IVasDataHelperApi.RequestCallback
        public void call(@NotNull String callbackKey, int avatarId, long pendantId, int pendantDiyId) {
            Intrinsics.checkNotNullParameter(callbackKey, "callbackKey");
            this.f308554a.callback(new IVipDataUpdateApi.AvatarPendantInfo(avatarId, pendantId, pendantDiyId));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VipDataUpdateApiImpl$c", "Lcom/tencent/mobileqq/vas/api/IVasDataHelperApi$RequestCallback;", "", "callbackKey", "", "avatarId", "", "pendantId", "pendantDiyId", "", "call", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements IVasDataHelperApi.RequestCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IVipDataUpdateApi.RequestResultCallback f308555a;

        c(IVipDataUpdateApi.RequestResultCallback requestResultCallback) {
            this.f308555a = requestResultCallback;
        }

        @Override // com.tencent.mobileqq.vas.api.IVasDataHelperApi.RequestCallback
        public void call(@NotNull String callbackKey, int avatarId, long pendantId, int pendantDiyId) {
            Intrinsics.checkNotNullParameter(callbackKey, "callbackKey");
            this.f308555a.callback(new IVipDataUpdateApi.AvatarPendantInfo(avatarId, pendantId, pendantDiyId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestAvatarPendantInfoChanged$lambda$0(String uin, IVipDataUpdateApi.RequestResultCallback callback) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ((IVasDataHelperApi) QRoute.api(IVasDataHelperApi.class)).requestFaceId(uin, uin, "VipDataUpdateApiImpl 2", new c(callback));
    }

    @Override // com.tencent.mobileqq.vas.api.IVipDataUpdateApi
    public void requestAvatarPendantInfoChanged(@NotNull final String uin, @NotNull final IVipDataUpdateApi.RequestResultCallback callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.fixRequestFrequency && !Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            ((IVasDataHelperApi) QRoute.api(IVasDataHelperApi.class)).requestFaceId(uin, uin, "VipDataUpdateApiImpl 1", new b(callback));
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.aw
                @Override // java.lang.Runnable
                public final void run() {
                    VipDataUpdateApiImpl.requestAvatarPendantInfoChanged$lambda$0(uin, callback);
                }
            }, 16, null, false);
        }
    }
}
