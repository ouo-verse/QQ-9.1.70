package com.tencent.timi.game.liveroom.impl.room.toparea;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/toparea/b;", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel;", "", "preload", "", "roomId", "anchorId", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "callback", "c", "", "needReport", "a", "b", "<init>", "()V", "L", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b extends TopAreaViewModel {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/b$b", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.toparea.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9954b implements IQQLiveCheckFollowCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f378547b;

        C9954b(boolean z16) {
            this.f378547b = z16;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            if (this.f378547b) {
                b.this.p0(false);
            }
            b.this.getAegisLog().e("NormalTopAreaViewModel", 1, "handleFollowState#onFail errCode:" + errCode + ", errMsg:" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            boolean z16;
            if (isFollow == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            b.this.getAegisLog().i("NormalTopAreaViewModel", 1, "checkFollowAnchor followed=" + z16);
            b.this.X(z16, this.f378547b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/b$c", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IQQLiveFollowCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveFollowCallback f378548a;

        c(IQQLiveFollowCallback iQQLiveFollowCallback) {
            this.f378548a = iQQLiveFollowCallback;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            IQQLiveFollowCallback iQQLiveFollowCallback = this.f378548a;
            if (iQQLiveFollowCallback != null) {
                iQQLiveFollowCallback.onFail(errCode, errMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            IQQLiveFollowCallback iQQLiveFollowCallback = this.f378548a;
            if (iQQLiveFollowCallback != null) {
                iQQLiveFollowCallback.onSuccess();
            }
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.a
    public void a(boolean needReport) {
        long j3;
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(QQLiveBusinessConfig.QQLIVE_APP_ID, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo != null) {
            j3 = loginInfo.q();
        } else {
            j3 = 0;
        }
        if (getAnchorId() == j3) {
            X(true, needReport);
        } else {
            TGLiveFollowManager.f377684a.f(null, getAnchorId(), new C9954b(needReport));
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.a
    public boolean b() {
        return TGLiveFollowManager.f377684a.n(getAnchorId());
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.a
    public void c(long roomId, long anchorId, @Nullable IQQLiveFollowCallback callback) {
        TGLiveFollowManager.f377684a.h(null, anchorId, roomId, new c(callback));
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.a
    public void preload() {
    }
}
