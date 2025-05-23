package com.tencent.mobileqq.qqlive.api.room.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveRoomDataPreloadApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import et3.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nn3.d;
import nn3.e;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R0\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/impl/QQLiveRoomDataPreloadApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/room/IQQLiveRoomDataPreloadApi;", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "getLiveSdk", "liveSdk", "", QAdLoginDefine$LoginStatus.IS_LOGIN, "", "roomId", "", "roomType", "", "preloadData", "Ljava/util/HashMap;", "Lnn3/d;", "Lkotlin/collections/HashMap;", "roomPreloads", "Ljava/util/HashMap;", "<init>", "()V", "Companion", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveRoomDataPreloadApiImpl implements IQQLiveRoomDataPreloadApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final Companion Companion;

    @Deprecated
    @NotNull
    private static final String TAG = "QQLiveRoomDataPreloadApi";

    @NotNull
    private final HashMap<Integer, d> roomPreloads;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/impl/QQLiveRoomDataPreloadApiImpl$Companion;", "", "()V", "TAG", "", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    private static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21943);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            Companion = new Companion(null);
        }
    }

    public QQLiveRoomDataPreloadApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashMap<Integer, d> hashMap = new HashMap<>();
        this.roomPreloads = hashMap;
        hashMap.put(2, e.f420547a);
    }

    private final IQQLiveSDK getLiveSdk() {
        return ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
    }

    private final boolean isLogin(IQQLiveSDK liveSdk) {
        return liveSdk.getLoginModule().isLogined();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IQQLiveRoomDataPreloadApi
    public void preloadData(long roomId, int roomType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(roomId), Integer.valueOf(roomType));
            return;
        }
        d dVar = this.roomPreloads.get(Integer.valueOf(roomType));
        if (dVar == null) {
            return;
        }
        if (dVar.b(roomId)) {
            c.a().i(TAG, 1, "isPreloading > " + roomId);
            return;
        }
        IQQLiveSDK liveSdk = getLiveSdk();
        if (liveSdk == null) {
            c.a().i(TAG, 1, "liveSdk is null");
        }
        Intrinsics.checkNotNull(liveSdk);
        if (liveSdk.isInited() && !liveSdk.isDestroyed()) {
            if (!isLogin(liveSdk)) {
                c.a().i(TAG, 1, "liveSdk is not login");
                return;
            } else {
                dVar.a(liveSdk, roomId);
                return;
            }
        }
        c.a().i(TAG, 1, "liveSdk is not init");
    }
}
