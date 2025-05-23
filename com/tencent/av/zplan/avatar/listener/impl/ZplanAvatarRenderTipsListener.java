package com.tencent.av.zplan.avatar.listener.impl;

import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.zplan.avatar.utils.f;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import cw.e;
import cx.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001*B\u0019\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0006\u0010\f\u001a\u00020\u0004R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u001eR$\u0010$\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00048B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010!\"\u0004\b\"\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/av/zplan/avatar/listener/impl/ZplanAvatarRenderTipsListener;", "Lcx/a;", "", "id", "", h.F, "e", "", "uin", "status", "", "a", "f", "Lcom/tencent/av/zplan/avatar/listener/impl/ZplanAvatarRenderTipsListener$State;", "Lcom/tencent/av/zplan/avatar/listener/impl/ZplanAvatarRenderTipsListener$State;", "mSelfState", "b", "mPeerState", "Lmqq/util/WeakReference;", "Lcom/tencent/av/app/VideoAppInterface;", "c", "Lmqq/util/WeakReference;", "mAppRef", "", "d", "J", "mLoadingTimeStamp", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mMMKVOptionEntity", "()Ljava/lang/String;", "selfUin", "value", "()Z", "g", "(Z)V", "hasUseCameraTipsShow", "Landroid/content/Context;", "context", "videoApp", "<init>", "(Landroid/content/Context;Lcom/tencent/av/app/VideoAppInterface;)V", "State", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class ZplanAvatarRenderTipsListener implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private State mSelfState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private State mPeerState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<VideoAppInterface> mAppRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long mLoadingTimeStamp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MMKVOptionEntity mMMKVOptionEntity;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/av/zplan/avatar/listener/impl/ZplanAvatarRenderTipsListener$State;", "", "(Ljava/lang/String;I)V", "Unknown", "Loading", "Success", "Fail", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum State {
        Unknown,
        Loading,
        Success,
        Fail
    }

    public ZplanAvatarRenderTipsListener(@NotNull Context context, @Nullable VideoAppInterface videoAppInterface) {
        Intrinsics.checkNotNullParameter(context, "context");
        State state = State.Unknown;
        this.mSelfState = state;
        this.mPeerState = state;
        this.mLoadingTimeStamp = -1L;
        this.mAppRef = new WeakReference<>(videoAppInterface);
        MMKVOptionEntity from = QMMKV.from(context, QMMKVFile.FILE_QAV);
        Intrinsics.checkNotNullExpressionValue(from, "from(context, QMMKVFile.FILE_QAV)");
        this.mMMKVOptionEntity = from;
    }

    private final boolean c() {
        return this.mMMKVOptionEntity.decodeBool("key_has_show_use_camera_tips_" + d(), false);
    }

    private final String d() {
        AppRuntime peekAppRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            return peekAppRuntime.getCurrentAccountUin();
        }
        return null;
    }

    private final boolean e(final int id5) {
        return f.h(new Function0<Unit>() { // from class: com.tencent.av.zplan.avatar.listener.impl.ZplanAvatarRenderTipsListener$hideTips$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WeakReference weakReference;
                weakReference = ZplanAvatarRenderTipsListener.this.mAppRef;
                e.d((VideoAppInterface) weakReference.get(), id5);
            }
        });
    }

    private final void g(boolean z16) {
        this.mMMKVOptionEntity.encodeBool("key_has_show_use_camera_tips_" + d(), z16);
    }

    private final boolean h(final int id5) {
        return f.h(new Function0<Unit>() { // from class: com.tencent.av.zplan.avatar.listener.impl.ZplanAvatarRenderTipsListener$showTips$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WeakReference weakReference;
                weakReference = ZplanAvatarRenderTipsListener.this.mAppRef;
                e.n((VideoAppInterface) weakReference.get(), id5);
            }
        });
    }

    @Override // cx.a
    public void a(@Nullable String uin, int status) {
        boolean z16;
        State state;
        VideoAppInterface videoAppInterface;
        VideoAppInterface videoAppInterface2;
        VideoAppInterface videoAppInterface3;
        VideoAppInterface videoAppInterface4;
        State state2;
        QLog.d("ZplanAvatarRenderTipsListener", 1, "onNotifyRenderEvent uin: " + uin + " status: " + status);
        boolean areEqual = Intrinsics.areEqual(d(), uin);
        Integer valueOf = Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_START);
        if (status == 4) {
            if (areEqual) {
                this.mSelfState = State.Loading;
                VideoAppInterface videoAppInterface5 = this.mAppRef.get();
                if (videoAppInterface5 != null) {
                    videoAppInterface5.k0(new Object[]{valueOf, Boolean.TRUE, Boolean.FALSE});
                }
                if (!ea.i2(d())) {
                    ea.P2(d(), true);
                }
            } else {
                this.mPeerState = State.Loading;
                h(LaunchScene.LAUNCH_SCENE_BOTTOM_GUID);
            }
            VideoAppInterface videoAppInterface6 = this.mAppRef.get();
            if (videoAppInterface6 != null) {
                videoAppInterface6.k0(new Integer[]{535});
            }
            if (this.mLoadingTimeStamp < 0) {
                this.mLoadingTimeStamp = System.currentTimeMillis();
                return;
            }
            return;
        }
        if (status != 7 && status != 6 && status != 2 && status != 5) {
            return;
        }
        if (status != 5 && status != 7) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (areEqual) {
            if (z16) {
                state2 = State.Success;
            } else {
                state2 = State.Fail;
            }
            this.mSelfState = state2;
        } else {
            if (z16) {
                state = State.Success;
            } else {
                state = State.Fail;
            }
            this.mPeerState = state;
        }
        State state3 = this.mSelfState;
        State state4 = State.Loading;
        if (state3 != state4 && (videoAppInterface4 = this.mAppRef.get()) != null) {
            Boolean bool = Boolean.FALSE;
            videoAppInterface4.k0(new Object[]{valueOf, bool, bool});
        }
        if (this.mPeerState != state4) {
            e(LaunchScene.LAUNCH_SCENE_BOTTOM_GUID);
        }
        if (this.mPeerState != state4 && this.mSelfState != state4) {
            if (status != 7) {
                long currentTimeMillis = System.currentTimeMillis() - this.mLoadingTimeStamp;
                this.mLoadingTimeStamp = -1L;
                ReportController.o(null, "dc00898", "", "", "0X800C43E", "0X800C43E", 0, 0, String.valueOf((int) currentTimeMillis), "", "", "");
            } else {
                this.mLoadingTimeStamp = -1L;
            }
        }
        if (areEqual && this.mSelfState == State.Success && !c()) {
            h(3027);
            ReportController.o(null, "dc00898", "", "", "0X800C43B", "0X800C43B", 0, 0, "", "", "", "");
            g(true);
        }
        if (!areEqual && this.mPeerState == State.Success && (videoAppInterface3 = this.mAppRef.get()) != null) {
            videoAppInterface3.k0(new Integer[]{534});
        }
        State state5 = this.mPeerState;
        State state6 = State.Success;
        if (state5 == state6 && this.mSelfState == state6 && (videoAppInterface2 = this.mAppRef.get()) != null) {
            videoAppInterface2.k0(new Integer[]{535});
        }
        if ((this.mPeerState == state6 || this.mSelfState == state6) && (videoAppInterface = this.mAppRef.get()) != null) {
            videoAppInterface.k0(new Object[]{Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_DETECTED_MULTI_NETWORK_CARD_AND_LOW_SPEED), Boolean.FALSE});
        }
    }

    public final boolean f() {
        State state = this.mPeerState;
        State state2 = State.Success;
        if (state == state2 && this.mSelfState == state2) {
            return true;
        }
        return false;
    }
}
