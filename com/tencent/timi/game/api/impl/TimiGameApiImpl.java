package com.tencent.timi.game.api.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.MainThread;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.auth.AuthScene;
import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.impl.TimiGameApiImpl;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.impl.ExpandHallFragment;
import com.tencent.timi.game.gift.impl.timi.TimiGiftPanel;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveClientQIPCModule;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import com.tencent.timi.game.utils.w;
import fm4.g;
import java.util.HashMap;
import jg4.e;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.UStringsKt;
import mf4.p;
import mqq.util.WeakReference;
import nf4.h;
import ni4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import po4.k;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 K2\u00020\u0001:\u0002LMB\u0007\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0017J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\"\u0010\u0016\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010%\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u00020\u0002H\u0016J\b\u00104\u001a\u000203H\u0016J\u0010\u00107\u001a\u00020\u00022\u0006\u00106\u001a\u000205H\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0017H\u0016J\b\u0010;\u001a\u00020:H\u0016J\b\u0010=\u001a\u00020<H\u0016J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>H\u0016R\"\u0010A\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\b\u0003\u0010ER\"\u0010F\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010B\u001a\u0004\bG\u0010D\"\u0004\bH\u0010E\u00a8\u0006N"}, d2 = {"Lcom/tencent/timi/game/api/impl/TimiGameApiImpl;", "Lcom/tencent/timi/game/api/ITimiGameApi;", "", "setHasCalledBusiness", "", "loginOrReconnect", "doWhenQQLogin", "doWhenQQLogout", "Landroid/content/Context;", "context", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "expandHallOpenParam", "openExpandHall", "openTimiGameTestPage", "", "testParam", "openTimiGameTmpDebugTestPage", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "getExpandHallFragment", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "listener", "createExpandHallFragment", "", "jumpLink", "buildLaunchParamFromLink", "initLiveModule", "Lcom/tencent/mobileqq/qqlive/data/anchor/camera/QQLiveAnchorStreamRecordType;", "type", "Lnf4/b;", "startGameLive", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "resumeRoomInfo", "reConnectObsPushRoom", "", "roomId", "programId", "resumeGameLive", "openAnchorRoomPage", "Lnf4/e;", "oneKeyLiveHandler", "Lnf4/d;", "getLiveReportUtil", "subSceneId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "openGiftPanelFragmentFromActivity", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "roomExtraInfo", "recordLiveRoomExtraData", "registerTGLiveQIPCModule", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getTimiApiProvider", "Lqf4/a;", "param", "openNearbyProfile", "moduleName", "isTimiModule", "Lnf4/h;", "getTimiLiveApi", "Ljf4/a;", "getGameRoomHandler", "Lcom/tencent/timi/game/api/auth/AuthScene;", "authScene", "needRealNameAuth", "hasCalledBusiness", "Z", "getHasCalledBusiness", "()Z", "(Z)V", "hasInitLiveModule", "getHasInitLiveModule", "setHasInitLiveModule", "<init>", "()V", "Companion", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiGameApiImpl implements ITimiGameApi {

    @NotNull
    public static final String TAG = "unknown|TimiGameApiImpl_";
    private boolean hasCalledBusiness;
    private boolean hasInitLiveModule;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/timi/game/api/impl/TimiGameApiImpl$b;", "Ljg4/e;", "", "isSuccess", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataBase;", "result", "Landroid/view/View;", "videoView", "", "i", "", "step", "errorCode", "", "errorDisplayMsg", "c", "Lmqq/util/WeakReference;", "Lnf4/b;", "a", "Lmqq/util/WeakReference;", "listenerRef", "listener", "<init>", "(Lnf4/b;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WeakReference<nf4.b> listenerRef;

        public b(@Nullable nf4.b bVar) {
            WeakReference<nf4.b> weakReference;
            if (bVar != null) {
                weakReference = new WeakReference<>(bVar);
            } else {
                weakReference = null;
            }
            this.listenerRef = weakReference;
        }

        @Override // jg4.g
        public void c(int step, int errorCode, @Nullable String errorDisplayMsg) {
            nf4.b bVar;
            WeakReference<nf4.b> weakReference = this.listenerRef;
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.onFailed(errorCode, errorDisplayMsg);
            }
        }

        @Override // jg4.g
        public void i(boolean isSuccess, @Nullable QQLiveAnchorDataBase result, @Nullable View videoView) {
            nf4.b bVar;
            if (isSuccess) {
                ((a) mm4.b.b(a.class)).openAnchorRoomPage(BaseApplication.context, 2, null);
                WeakReference<nf4.b> weakReference = this.listenerRef;
                if (weakReference != null && (bVar = weakReference.get()) != null) {
                    bVar.onSuccess();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/timi/game/api/impl/TimiGameApiImpl$c", "Ljg4/e;", "", "isSuccess", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataInit;", "result", "", "j", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataBase;", "Landroid/view/View;", "videoView", "i", "", "step", "errorCode", "", "errorDisplayMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorRoomInfo f376287a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ nf4.b f376288b;

        c(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, nf4.b bVar) {
            this.f376287a = qQLiveAnchorRoomInfo;
            this.f376288b = bVar;
        }

        @Override // jg4.g
        public void c(int step, int errorCode, @Nullable String errorDisplayMsg) {
            nf4.b bVar = this.f376288b;
            if (bVar != null) {
                bVar.onFailed(errorCode, errorDisplayMsg);
            }
        }

        @Override // jg4.g
        public void i(boolean isSuccess, @Nullable QQLiveAnchorDataBase result, @Nullable View videoView) {
            if (isSuccess) {
                ((a) mm4.b.b(a.class)).openAnchorRoomPage(BaseApplication.context, 2, null);
                nf4.b bVar = this.f376288b;
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            l.i(TimiGameApiImpl.TAG, "reConnectObsPushRoom onFinalLiveStreamResult fail");
        }

        @Override // jg4.e, jg4.g
        public void j(boolean isSuccess, @Nullable QQLiveAnchorDataInit result) {
            if (isSuccess) {
                ((jg4.b) mm4.b.b(jg4.b.class)).y2(this.f376287a);
            } else {
                l.i(TimiGameApiImpl.TAG, "reConnectObsPushRoom onCreateRoomInitResult fail");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/timi/game/api/impl/TimiGameApiImpl$d", "Ljg4/e;", "", "isSuccess", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataBase;", "result", "Landroid/view/View;", "videoView", "", "i", "", "step", "errorCode", "", "errorDisplayMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d extends e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ nf4.b f376289a;

        d(nf4.b bVar) {
            this.f376289a = bVar;
        }

        @Override // jg4.g
        public void c(int step, int errorCode, @Nullable String errorDisplayMsg) {
            nf4.b bVar = this.f376289a;
            if (bVar != null) {
                bVar.onFailed(errorCode, errorDisplayMsg);
            }
        }

        @Override // jg4.g
        public void i(boolean isSuccess, @Nullable QQLiveAnchorDataBase result, @Nullable View videoView) {
            if (isSuccess) {
                ((a) mm4.b.b(a.class)).openAnchorRoomPage(BaseApplication.context, 2, null);
                nf4.b bVar = this.f376289a;
                if (bVar != null) {
                    bVar.onSuccess();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doWhenQQLogin$lambda$0(boolean z16) {
        ((g) mm4.b.b(g.class)).U1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLiveModule$lambda$4() {
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: mf4.d
            @Override // hi4.a
            public final void a(boolean z16) {
                TimiGameApiImpl.initLiveModule$lambda$4$lambda$3(Ref.LongRef.this, z16);
            }
        });
        TGLiveClientQIPCModule.INSTANCE.c().registerModule();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLiveModule$lambda$4$lambda$3(Ref.LongRef startTime, boolean z16) {
        Intrinsics.checkNotNullParameter(startTime, "$startTime");
        l.i(TAG, "initLiveModule syncEnsureInit costTime = " + (System.currentTimeMillis() - startTime.element));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openNearbyProfile$lambda$9(final QBaseActivity qBaseActivity, final qf4.a param, final CommonOuterClass$QQUserId userId, boolean z16) {
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(userId, "$userId");
        qBaseActivity.runOnUiThread(new Runnable() { // from class: mf4.b
            @Override // java.lang.Runnable
            public final void run() {
                TimiGameApiImpl.openNearbyProfile$lambda$9$lambda$8(qf4.a.this, qBaseActivity, userId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openNearbyProfile$lambda$9$lambda$8(qf4.a param, QBaseActivity qBaseActivity, CommonOuterClass$QQUserId userId) {
        long j3;
        int i3;
        int i16;
        int i17;
        ULong uLongOrNull;
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(userId, "$userId");
        String currentYesUid = param.getCurrentYesUid();
        if (currentYesUid != null && (uLongOrNull = UStringsKt.toULongOrNull(currentYesUid)) != null) {
            j3 = uLongOrNull.getData();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        ql4.a aVar = (ql4.a) mm4.b.b(ql4.a.class);
        Integer num = param.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_GAME_ID java.lang.String();
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        Integer subId = param.getSubId();
        if (subId != null) {
            i16 = subId.intValue();
        } else {
            i16 = 0;
        }
        Integer num2 = param.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String();
        if (num2 != null) {
            i17 = num2.intValue();
        } else {
            i17 = 0;
        }
        aVar.F2(qBaseActivity, userId, i3, j16, true, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openTimiGameTestPage$lambda$1(boolean z16) {
        ((hn4.a) mm4.b.b(hn4.a.class)).openTimiGameTestPage();
        ((hi4.b) mm4.b.b(hi4.b.class)).c0(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openTimiGameTmpDebugTestPage$lambda$2(int i3, boolean z16) {
        ((hn4.a) mm4.b.b(hn4.a.class)).openTimiGameTmpDebugTestPage(i3);
        ((hi4.b) mm4.b.b(hi4.b.class)).c0(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reConnectObsPushRoom$lambda$6(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, nf4.b bVar, boolean z16) {
        ((jg4.b) mm4.b.b(jg4.b.class)).F0(true, new c(qQLiveAnchorRoomInfo, bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resumeGameLive$lambda$7(long j3, String str, nf4.b bVar, boolean z16) {
        ((jg4.b) mm4.b.b(jg4.b.class)).H0(j3, str, new d(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startGameLive$lambda$5(QQLiveAnchorStreamRecordType type, nf4.b bVar, boolean z16) {
        Intrinsics.checkNotNullParameter(type, "$type");
        ((jg4.b) mm4.b.b(jg4.b.class)).p3(type, true, new b(bVar));
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    @NotNull
    public ExpandHallLaunchParam buildLaunchParamFromLink(@NotNull Context context, @NotNull String jumpLink) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpLink, "jumpLink");
        ax a16 = new com.tencent.timi.game.jump.api.impl.c().a((BaseQQAppInterface) vf4.a.a(), context, jumpLink, null);
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.timi.game.jump.api.impl.TimiGameJumpAction");
        ExpandHallLaunchParam expandHallLaunchParam = new ExpandHallLaunchParam();
        ((com.tencent.timi.game.jump.api.impl.b) a16).H(expandHallLaunchParam);
        return expandHallLaunchParam;
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    @NotNull
    public QPublicBaseFragment createExpandHallFragment(@NotNull Context context, @NotNull ExpandHallLaunchParam expandHallOpenParam, @Nullable ExpandHallListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(expandHallOpenParam, "expandHallOpenParam");
        return p.f416710a.g(context, expandHallOpenParam, listener);
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void doWhenQQLogin(boolean loginOrReconnect) {
        l.e("YesApiImpl", "doWhenQQLogin START - " + loginOrReconnect);
        if (rm4.a.b("tg_rooms_exist", false)) {
            setHasCalledBusiness();
            l.i("YesApiImpl", "doWhenQQLogin#Logic_Room resume");
            ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: mf4.f
                @Override // hi4.a
                public final void a(boolean z16) {
                    TimiGameApiImpl.doWhenQQLogin$lambda$0(z16);
                }
            });
        }
        l.i("YesApiImpl", "doWhenQQLogin END");
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void doWhenQQLogout() {
        l.e("YesApiImpl", "doWhenQQLogout, hasCalledBiz = " + this.hasCalledBusiness);
        if (this.hasCalledBusiness) {
            ((hi4.b) mm4.b.b(hi4.b.class)).w();
        }
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    @NotNull
    public Class<? extends QPublicBaseFragment> getExpandHallFragment() {
        return ExpandHallFragment.class;
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    @NotNull
    public jf4.a getGameRoomHandler() {
        jf4.a gameRoomHandler = ((bi4.a) mm4.b.b(bi4.a.class)).getGameRoomHandler();
        Intrinsics.checkNotNullExpressionValue(gameRoomHandler, "getService(IGuildRoomSer\u2026ass.java).gameRoomHandler");
        return gameRoomHandler;
    }

    public final boolean getHasCalledBusiness() {
        return this.hasCalledBusiness;
    }

    public final boolean getHasInitLiveModule() {
        return this.hasInitLiveModule;
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    @NotNull
    public nf4.d getLiveReportUtil() {
        return ((ug4.a) mm4.b.b(ug4.a.class)).u();
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    @NotNull
    public HippyAPIProvider getTimiApiProvider() {
        return new k();
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    @NotNull
    public h getTimiLiveApi() {
        h D1 = ((a) mm4.b.b(a.class)).D1();
        Intrinsics.checkNotNullExpressionValue(D1, "getService(IAnchorRoomSe\u2026class.java).timiLiveApi()");
        return D1;
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void initLiveModule(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        l.i(TAG, "initLiveModule - " + context + " - " + this.hasInitLiveModule);
        if (this.hasInitLiveModule) {
            return;
        }
        this.hasInitLiveModule = true;
        w.a(new Runnable() { // from class: mf4.e
            @Override // java.lang.Runnable
            public final void run() {
                TimiGameApiImpl.initLiveModule$lambda$4();
            }
        });
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public boolean isTimiModule(@NotNull String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        return TextUtils.equals(moduleName, HippyQQConstants.ModuleName.QQ_NEARBY_GAME);
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public boolean needRealNameAuth(@NotNull AuthScene authScene) {
        Intrinsics.checkNotNullParameter(authScene, "authScene");
        return !zh4.d.f452579a.j(authScene);
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    @NotNull
    public nf4.e oneKeyLiveHandler() {
        nf4.e b06 = ((a) mm4.b.b(a.class)).b0();
        Intrinsics.checkNotNullExpressionValue(b06, "getService(IAnchorRoomSe\u2026:class.java).oneKeyLive()");
        return b06;
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void openAnchorRoomPage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((a) mm4.b.b(a.class)).openAnchorRoomPage(context, 1, null);
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    @MainThread
    public void openExpandHall(@NotNull Context context, @NotNull ExpandHallLaunchParam expandHallOpenParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(expandHallOpenParam, "expandHallOpenParam");
        if (o.d("unknown|TimiGameApiImpl_openExpandHall", 500)) {
            l.i(TAG, "openExpandHall doubleClick");
        } else {
            setHasCalledBusiness();
            p.f416710a.j(context, expandHallOpenParam);
        }
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void openGiftPanelFragmentFromActivity(int subSceneId, @NotNull Activity activity) {
        String str;
        Object obj;
        String str2;
        long j3;
        String str3;
        String str4;
        String str5;
        HashMap<String, String> l3;
        String str6;
        String b16;
        String j16;
        String m3;
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        com.tencent.mobileqq.qqlive.sail.room.e k3 = cVar.m().k();
        if (k3 == null) {
            AegisLogger.INSTANCE.w(TAG, "openGiftPanel", "no room");
            return;
        }
        if (!k3.b().y()) {
            AegisLogger.INSTANCE.w(TAG, "init", "anchor is not QQAnchor");
            gt3.a.b(gt3.a.INSTANCE.a(), "\u5916\u90e8\u5185\u5bb9\u6e90\u623f\u95f4\u4e0d\u652f\u6301\u9001\u793c", 0, null, 4, null);
            return;
        }
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        ILiveLoginApi iLiveLoginApi = (ILiveLoginApi) QRoute.api(ILiveLoginApi.class);
        String str7 = QQLiveBusinessConfig.QQLIVE_APP_ID;
        LiveLoginInfo loginInfo = iLiveLoginApi.getLoginInfo(str7, account);
        if (loginInfo == null || (m3 = loginInfo.m()) == null) {
            str = "";
        } else {
            str = m3;
        }
        if (loginInfo == null) {
            obj = "";
        } else {
            obj = Long.valueOf(loginInfo.q());
        }
        if (loginInfo == null || (j16 = loginInfo.j()) == null) {
            str2 = "";
        } else {
            str2 = j16;
        }
        String str8 = obj + "_" + k3.b().getRoomId() + "_" + k3.b().n();
        int sceneId = QQLiveSDKConfigHelper.getSceneId();
        TimiGiftPanel.Companion companion = TimiGiftPanel.INSTANCE;
        long roomId = k3.b().getRoomId();
        int roomType = k3.b().getRoomType();
        long G = cVar.G();
        UserInfo k16 = k3.b().k();
        if (k16 != null) {
            j3 = k16.f();
        } else {
            j3 = 0;
        }
        UserInfo k17 = k3.b().k();
        if (k17 == null || (b16 = k17.b()) == null) {
            str3 = "";
        } else {
            str3 = b16;
        }
        UserInfo k18 = k3.b().k();
        if (k18 == null || (str4 = k18.a()) == null) {
            str4 = "";
        }
        String programId = k3.b().getProgramId();
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(str7);
        if (c16 == null || (l3 = c16.l()) == null || (str6 = l3.get("rcmd_context")) == null) {
            str5 = "";
        } else {
            str5 = str6;
        }
        companion.g(activity, (r58 & 2) != 0 ? false : false, sceneId, roomId, roomType, G, str, str2, j3, str3, str4, str7, "0", programId, str7, str5, "0", 1, (r58 & 262144) != 0 ? 0 : subSceneId, str8, "1", "\u793c\u7269", "QQ\u5a31\u4e50", (r58 & 8388608) != 0 ? null : null);
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void openNearbyProfile(@NotNull final qf4.a param) {
        long j3;
        ULong uLongOrNull;
        Intrinsics.checkNotNullParameter(param, "param");
        final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        l.b(TAG, "openNearbyProfile " + qBaseActivity);
        if (qBaseActivity != null) {
            final CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
            String yesId = param.getYesId();
            if (yesId != null && (uLongOrNull = UStringsKt.toULongOrNull(yesId)) != null) {
                j3 = uLongOrNull.getData();
            } else {
                j3 = 0;
            }
            commonOuterClass$QQUserId.yes_uid.set(j3);
            commonOuterClass$QQUserId.user_from.set(4);
            ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: mf4.c
                @Override // hi4.a
                public final void a(boolean z16) {
                    TimiGameApiImpl.openNearbyProfile$lambda$9(QBaseActivity.this, param, commonOuterClass$QQUserId, z16);
                }
            });
        }
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void openTimiGameTestPage() {
        setHasCalledBusiness();
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: mf4.g
            @Override // hi4.a
            public final void a(boolean z16) {
                TimiGameApiImpl.openTimiGameTestPage$lambda$1(z16);
            }
        });
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void openTimiGameTmpDebugTestPage(final int testParam) {
        setHasCalledBusiness();
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: mf4.h
            @Override // hi4.a
            public final void a(boolean z16) {
                TimiGameApiImpl.openTimiGameTmpDebugTestPage$lambda$2(testParam, z16);
            }
        });
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void reConnectObsPushRoom(@Nullable final QQLiveAnchorRoomInfo resumeRoomInfo, @Nullable final nf4.b listener) {
        setHasCalledBusiness();
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: mf4.i
            @Override // hi4.a
            public final void a(boolean z16) {
                TimiGameApiImpl.reConnectObsPushRoom$lambda$6(QQLiveAnchorRoomInfo.this, listener, z16);
            }
        });
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void recordLiveRoomExtraData(@NotNull LiveRoomExtraInfo roomExtraInfo) {
        Intrinsics.checkNotNullParameter(roomExtraInfo, "roomExtraInfo");
        ((jg4.b) mm4.b.b(jg4.b.class)).f2(roomExtraInfo);
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void registerTGLiveQIPCModule() {
        TGLiveClientQIPCModule.INSTANCE.c().registerModule();
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void resumeGameLive(final long roomId, @Nullable final String programId, @Nullable final nf4.b listener) {
        setHasCalledBusiness();
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: mf4.j
            @Override // hi4.a
            public final void a(boolean z16) {
                TimiGameApiImpl.resumeGameLive$lambda$7(roomId, programId, listener, z16);
            }
        });
    }

    public final void setHasCalledBusiness(boolean z16) {
        this.hasCalledBusiness = z16;
    }

    public final void setHasInitLiveModule(boolean z16) {
        this.hasInitLiveModule = z16;
    }

    @Override // com.tencent.timi.game.api.ITimiGameApi
    public void startGameLive(@NotNull final QQLiveAnchorStreamRecordType type, @Nullable final nf4.b listener) {
        Intrinsics.checkNotNullParameter(type, "type");
        setHasCalledBusiness();
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: mf4.a
            @Override // hi4.a
            public final void a(boolean z16) {
                TimiGameApiImpl.startGameLive$lambda$5(QQLiveAnchorStreamRecordType.this, listener, z16);
            }
        });
    }

    private final void setHasCalledBusiness() {
        this.hasCalledBusiness = true;
    }
}
