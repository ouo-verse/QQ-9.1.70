package com.tencent.timi.game.liveroom.impl.room.toparea;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.liveroom.impl.room.preload.PreloadSwitch;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/toparea/c;", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel;", "", "roomId", "anchorId", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "callback", "", "c", "preload", "o", "", "needReport", "a", "b", BdhLogUtil.LogTag.Tag_Req, "T", "V", "U", ExifInterface.LATITUDE_SOUTH, "<init>", "()V", "L", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c extends TopAreaViewModel {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/c$b", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IQQLiveCheckFollowCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f378550b;

        b(boolean z16) {
            this.f378550b = z16;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            if (this.f378550b) {
                c.this.p0(false);
            }
            c.this.getAegisLog().e("OdTopAreaViewModel", 1, "handleFollowState#onFail errCode:" + errCode + ", errMsg:" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            boolean z16;
            if (isFollow == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            c.this.getAegisLog().i("OdTopAreaViewModel", 1, "checkFollowAnchor followed=" + z16);
            c.this.X(z16, this.f378550b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/c$c", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.toparea.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9955c implements IQQLiveFollowCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveFollowCallback f378551a;

        C9955c(IQQLiveFollowCallback iQQLiveFollowCallback) {
            this.f378551a = iQQLiveFollowCallback;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            IQQLiveFollowCallback iQQLiveFollowCallback = this.f378551a;
            if (iQQLiveFollowCallback != null) {
                iQQLiveFollowCallback.onFail(errCode, errMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            IQQLiveFollowCallback iQQLiveFollowCallback = this.f378551a;
            if (iQQLiveFollowCallback != null) {
                iQQLiveFollowCallback.onSuccess();
            }
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.TopAreaViewModel
    public boolean R() {
        return false;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.TopAreaViewModel
    public boolean S() {
        return false;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.TopAreaViewModel
    public boolean T() {
        return false;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.TopAreaViewModel
    public boolean U() {
        return false;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.TopAreaViewModel
    public boolean V() {
        return true;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.a
    public void a(boolean needReport) {
        TGLiveFollowManager.f377684a.g(getRoomId(), new b(needReport));
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.a
    public boolean b() {
        return TGLiveFollowManager.f377684a.r(getRoomId());
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.a
    public void c(long roomId, long anchorId, @Nullable IQQLiveFollowCallback callback) {
        TGLiveFollowManager.f377684a.j(roomId, new C9955c(callback));
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.TopAreaViewModel
    public void o() {
        boolean isBlank;
        super.o();
        String C = com.tencent.mobileqq.qqlive.sail.c.C(com.tencent.mobileqq.qqlive.sail.c.f272176a, getRoomId(), 0, 2, null);
        isBlank = StringsKt__StringsJVMKt.isBlank(C);
        if (!isBlank) {
            g0(C);
        } else {
            g0("\u672a\u547d\u540d");
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.toparea.a
    public void preload() {
        if (!PreloadSwitch.INSTANCE.c()) {
            a(false);
        }
        g0("\u672a\u547d\u540d");
    }
}
