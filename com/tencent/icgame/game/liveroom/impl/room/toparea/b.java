package com.tencent.icgame.game.liveroom.impl.room.toparea;

import com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.mobileqq.icgame.api.login.ILiveLoginApi;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/toparea/b;", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/e;", "", "preload", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "callback", "b", "", "needReport", "a", "<init>", "()V", "B", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b extends e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/toparea/b$b", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.toparea.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5842b implements IQQLiveCheckFollowCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f115655b;

        C5842b(boolean z16) {
            this.f115655b = z16;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            if (this.f115655b) {
                b.this.L(false);
            }
            b.this.getAegisLog().e("ICGameNormalTopAreaViewModel", 1, "handleFollowState#onFail errCode:" + errCode + ", errMsg:" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            boolean z16;
            if (isFollow == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            b.this.getAegisLog().i("ICGameNormalTopAreaViewModel", 1, "checkFollowAnchor followed=" + z16);
            b.this.A(z16, this.f115655b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/toparea/b$c", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements IQQLiveFollowCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveFollowCallback f115656a;

        c(IQQLiveFollowCallback iQQLiveFollowCallback) {
            this.f115656a = iQQLiveFollowCallback;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            IQQLiveFollowCallback iQQLiveFollowCallback = this.f115656a;
            if (iQQLiveFollowCallback != null) {
                iQQLiveFollowCallback.onFail(errCode, errMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            IQQLiveFollowCallback iQQLiveFollowCallback = this.f115656a;
            if (iQQLiveFollowCallback != null) {
                iQQLiveFollowCallback.onSuccess();
            }
        }
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.toparea.a
    public void a(boolean needReport) {
        long j3;
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo("1078", ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo != null) {
            j3 = loginInfo.getUid();
        } else {
            j3 = 0;
        }
        if (getAnchorId() == j3) {
            A(true, needReport);
        } else {
            TGLiveFollowManager.f115307a.e(null, getAnchorId(), new C5842b(needReport));
        }
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.toparea.a
    public void b(@Nullable IQQLiveFollowCallback callback) {
        TGLiveFollowManager.f115307a.h(null, getAnchorId(), getRoomId(), new c(callback));
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.toparea.a
    public void preload() {
    }
}
