package com.tencent.mobileqq.qwallet.hb.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.os.Handler;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import androidx.core.os.HandlerCompat;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi;
import com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager;
import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinRepository;
import com.tencent.mobileqq.qwallet.hb.view.FestivalHbPagView;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.libpag.PAGView;
import org.light.LightEngine;
import tk2.FestivalHbData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 K2\u00020\u0001:\u0002LMB\u0007\u00a2\u0006\u0004\bI\u0010JJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\fH\u0002J3\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001c\u0010!\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u001a\u0010!\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J5\u0010(\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022#\u0010'\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00070\u000fH\u0016J\u0010\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020\u0004H\u0016J \u0010/\u001a\u00020\u00072\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020*0,j\b\u0012\u0004\u0012\u00020*`-H\u0016J\n\u00101\u001a\u0004\u0018\u000100H\u0016J!\u00105\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u00010\u00022\u0006\u00104\u001a\u000203H\u0016\u00a2\u0006\u0004\b5\u00106J \u0010:\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u000207H\u0016J\b\u0010;\u001a\u00020\u0007H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016J\b\u0010=\u001a\u00020\u0018H\u0016J\u0018\u0010A\u001a\u00020\u00072\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020>H\u0016J\b\u0010B\u001a\u00020\u0002H\u0016R\u0018\u0010C\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001e\u0010F\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u001e\u0010H\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010G\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/impl/QWalletFestivalHbApiImpl;", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "", "skinId", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "it", "from", "", "notifySkinReceivers", "", "skinIdList", "forceUpdateSkinDataList", "Ltk2/a$b;", "checkIfPlayAnim", "anim", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "method", "fadeOrJustRunAnim", "playBgAndFgAnim", "playBgAnim", "playFgAnim", "playFgLoopAnim", "", "isDisableLoadLightSdk", "isAllAnimResReady", "isBgResExists", "isFgEnterResExists", "isFgLoopResExists", "", WadlProxyConsts.RES_URL, "suffix", "getResPath", "Lcom/tencent/mobileqq/qwallet/preload/DownloadParam;", "params", "Lcom/tencent/mobileqq/qwallet/preload/IPreloadService$c;", "listener", "hbSkinData", "receiver", "getSkinData", "skinData", "Ltk2/a;", "convertHbData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "preDownloadSkinRes", "Lorg/json/JSONObject;", "getFestivalHbPanelConfig", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "panelData", "verifyPanelData", "(Ljava/lang/Integer;Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;)Z", "Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView;", "animBgView", "animFgView", "playPagAnim", "releasePagAnim", "checkIfNeedLoadLightSdk", "checkIfDisablePag", "Landroid/widget/ImageView;", "ivOutClose", "ivInClose", "adjustClosePosition", "getCurrentScreenWidth", "currentAnim", "Ltk2/a$b;", "Ljava/lang/ref/WeakReference;", "animBgRef", "Ljava/lang/ref/WeakReference;", "animFgRef", "<init>", "()V", "Companion", "a", "b", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletFestivalHbApiImpl implements IQWalletFestivalHbApi {
    private static final int NOTIFY_SKIN_RECEIVERS_FROM_RESPONSE = 0;
    private static final int NOTIFY_SKIN_RECEIVERS_FROM_TIMEOUT = 1;
    private static final long REQ_SKIN_TIMEOUT_DELAY = 10000;

    @NotNull
    private static final String TAG = "QWallet.Festival.QWalletFestivalHbApiImpl";
    private static boolean isLightSdkInit;

    @Nullable
    private WeakReference<FestivalHbPagView> animBgRef;

    @Nullable
    private WeakReference<FestivalHbPagView> animFgRef;

    @Nullable
    private FestivalHbData.Anim currentAnim;
    private static long FADE_ANIM_DURATION_FG = 300;

    @NotNull
    private static final Object skinReceiversLock = new Object();

    @NotNull
    private static HashMap<Integer, ArrayList<Function1<HbSkinData, Unit>>> skinReceiversMap = new HashMap<>();

    @NotNull
    private static final Handler commonHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/impl/QWalletFestivalHbApiImpl$b;", "Lcom/tencent/mobileqq/qwallet/preload/IPreloadService$c;", "", "resCode", "Lcom/tencent/mobileqq/qwallet/preload/IPreloadService$PathResult;", "pathRes", "", "onResult", "Ltk2/a$b;", "a", "Ltk2/a$b;", "getAnim", "()Ltk2/a$b;", "anim", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/impl/QWalletFestivalHbApiImpl;Ltk2/a$b;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public final class b implements IPreloadService.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FestivalHbData.Anim anim;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QWalletFestivalHbApiImpl f277487b;

        public b(@NotNull QWalletFestivalHbApiImpl qWalletFestivalHbApiImpl, FestivalHbData.Anim anim) {
            Intrinsics.checkNotNullParameter(anim, "anim");
            this.f277487b = qWalletFestivalHbApiImpl;
            this.anim = anim;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QWalletFestivalHbApiImpl this$0, b this$1) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.checkIfPlayAnim(this$1.anim);
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
        public void onResult(int resCode, @Nullable IPreloadService.PathResult pathRes) {
            if (resCode == 0 && pathRes != null && Intrinsics.areEqual(this.f277487b.currentAnim, this.anim)) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final QWalletFestivalHbApiImpl qWalletFestivalHbApiImpl = this.f277487b;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.impl.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        QWalletFestivalHbApiImpl.b.b(QWalletFestivalHbApiImpl.this, this);
                    }
                });
            }
            QLog.i(QWalletFestivalHbApiImpl.TAG, 1, "download resCode:" + resCode + ",currentAnim:" + this.f277487b.currentAnim + ",anim:" + this.anim);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/impl/QWalletFestivalHbApiImpl$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<FestivalHbData.Anim, Unit> f277488d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FestivalHbData.Anim f277489e;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super FestivalHbData.Anim, Unit> function1, FestivalHbData.Anim anim) {
            this.f277488d = function1;
            this.f277489e = anim;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f277488d.invoke(this.f277489e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void adjustClosePosition$lambda$21(ImageView ivOutClose, ImageView ivInClose) {
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(ivOutClose, "$ivOutClose");
        Intrinsics.checkNotNullParameter(ivInClose, "$ivInClose");
        Rect rect = new Rect();
        boolean globalVisibleRect = ivOutClose.getGlobalVisibleRect(rect);
        float dimension = ivOutClose.getResources().getDimension(R.dimen.cay);
        if (globalVisibleRect) {
            int height = rect.height();
            roundToInt2 = MathKt__MathJVMKt.roundToInt(dimension);
            if (height >= roundToInt2) {
                ivOutClose.setVisibility(0);
                int height2 = rect.height();
                roundToInt = MathKt__MathJVMKt.roundToInt(dimension);
                QLog.i(TAG, 1, "visibleRect:" + globalVisibleRect + ",rectHeight:" + height2 + ",height:" + roundToInt);
            }
        }
        ivOutClose.setVisibility(4);
        ivInClose.setVisibility(0);
        ivInClose.setColorFilter(ivInClose.getResources().getColor(R.color.c_y));
        int height22 = rect.height();
        roundToInt = MathKt__MathJVMKt.roundToInt(dimension);
        QLog.i(TAG, 1, "visibleRect:" + globalVisibleRect + ",rectHeight:" + height22 + ",height:" + roundToInt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkIfPlayAnim(FestivalHbData.Anim it) {
        if (isAllAnimResReady(it)) {
            fadeOrJustRunAnim(it, new QWalletFestivalHbApiImpl$checkIfPlayAnim$1(this));
        }
    }

    private final void fadeOrJustRunAnim(FestivalHbData.Anim anim, Function1<? super FestivalHbData.Anim, Unit> method) {
        FestivalHbPagView festivalHbPagView;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        FestivalHbPagView festivalHbPagView2;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator alpha2;
        ViewPropertyAnimator duration2;
        ViewPropertyAnimator listener;
        FestivalHbPagView festivalHbPagView3;
        WeakReference<FestivalHbPagView> weakReference = this.animFgRef;
        boolean z16 = false;
        if (weakReference != null && (festivalHbPagView3 = weakReference.get()) != null && festivalHbPagView3.j()) {
            z16 = true;
        }
        if (z16) {
            WeakReference<FestivalHbPagView> weakReference2 = this.animFgRef;
            if (weakReference2 != null && (festivalHbPagView2 = weakReference2.get()) != null && (animate2 = festivalHbPagView2.animate()) != null && (alpha2 = animate2.alpha(0.0f)) != null && (duration2 = alpha2.setDuration(FADE_ANIM_DURATION_FG)) != null && (listener = duration2.setListener(new c(method, anim))) != null) {
                listener.start();
            }
            WeakReference<FestivalHbPagView> weakReference3 = this.animBgRef;
            if (weakReference3 != null && (festivalHbPagView = weakReference3.get()) != null && (animate = festivalHbPagView.animate()) != null && (alpha = animate.alpha(0.0f)) != null && (duration = alpha.setDuration(FADE_ANIM_DURATION_FG - 100)) != null) {
                duration.start();
                return;
            }
            return;
        }
        method.invoke(anim);
    }

    private final void forceUpdateSkinDataList(final List<Integer> skinIdList) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                QWalletFestivalHbApiImpl.forceUpdateSkinDataList$lambda$7(skinIdList);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forceUpdateSkinDataList$lambda$7(List skinIdList) {
        Intrinsics.checkNotNullParameter(skinIdList, "$skinIdList");
        HbSkinRepository.f277840a.j(skinIdList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000f, B:6:0x001f, B:11:0x002b, B:16:0x0051, B:17:0x0056), top: B:3:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void getSkinData$lambda$4(final int i3, Function1 receiver, final QWalletFestivalHbApiImpl this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (skinReceiversLock) {
            ArrayList<Function1<HbSkinData, Unit>> arrayList = skinReceiversMap.get(Integer.valueOf(i3));
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
                if (z16) {
                    arrayList.add(receiver);
                    QLog.i(TAG, 2, "[getSkinData] skinId:" + i3 + " is requesting");
                    return;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(receiver);
                skinReceiversMap.put(Integer.valueOf(i3), arrayList);
                HandlerCompat.postDelayed(commonHandler, new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.impl.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        QWalletFestivalHbApiImpl.getSkinData$lambda$4$lambda$3$lambda$2(QWalletFestivalHbApiImpl.this, i3);
                    }
                }, arrayList, 10000L);
                QLog.i(TAG, 1, "[getSkinData] from repository,skinId:" + i3 + ",token:" + arrayList.hashCode());
                Unit unit = Unit.INSTANCE;
                HbSkinRepository.f277840a.d(i3, "", 0, new Function1<HbSkinData, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl$getSkinData$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                        invoke2(hbSkinData);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable HbSkinData hbSkinData) {
                        QWalletFestivalHbApiImpl.this.notifySkinReceivers(i3, hbSkinData, 0);
                    }
                });
                return;
            }
            z16 = true;
            if (z16) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSkinData$lambda$4$lambda$3$lambda$2(QWalletFestivalHbApiImpl this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifySkinReceivers(i3, null, 1);
    }

    private final boolean isDisableLoadLightSdk() {
        return ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_DISABLE_LIGHT_SDK_LOAD, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySkinReceivers(int skinId, HbSkinData it, int from) {
        int i3;
        synchronized (skinReceiversLock) {
            ArrayList<Function1<HbSkinData, Unit>> arrayList = skinReceiversMap.get(Integer.valueOf(skinId));
            if (arrayList != null) {
                commonHandler.removeCallbacksAndMessages(arrayList);
                i3 = arrayList.size();
                Iterator<Function1<HbSkinData, Unit>> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    it5.next().invoke(it);
                }
                arrayList.clear();
            } else {
                i3 = 0;
            }
            QLog.i(TAG, 2, "[notifySkinReceivers] skinId:" + skinId + ",from:" + from + ",listSize:" + i3 + ",token:" + hashCode() + "," + it);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playBgAndFgAnim(FestivalHbData.Anim it) {
        playBgAnim(it);
        playFgAnim(it);
    }

    private final void playBgAnim(final FestivalHbData.Anim anim) {
        FestivalHbPagView festivalHbPagView;
        FestivalHbPagView k3;
        FestivalHbPagView i3;
        QLog.i(TAG, 1, "[playBgAnim]");
        WeakReference<FestivalHbPagView> weakReference = this.animBgRef;
        if (weakReference != null && (festivalHbPagView = weakReference.get()) != null && (k3 = festivalHbPagView.k()) != null && (i3 = k3.i()) != null) {
            i3.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl$playBgAnim$1$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/impl/QWalletFestivalHbApiImpl$playBgAnim$1$1$a", "Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView$a;", "Lorg/libpag/PAGView;", "pagView", "", "onAnimationEnd", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes16.dex */
                public static final class a extends FestivalHbPagView.a {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ QWalletFestivalHbApiImpl f277490d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ PAGView f277491e;

                    a(QWalletFestivalHbApiImpl qWalletFestivalHbApiImpl, PAGView pAGView) {
                        this.f277490d = qWalletFestivalHbApiImpl;
                        this.f277491e = pAGView;
                    }

                    @Override // org.libpag.PAGView.PAGViewListener
                    public void onAnimationEnd(@Nullable PAGView pagView) {
                        WeakReference weakReference;
                        FestivalHbPagView festivalHbPagView;
                        weakReference = this.f277490d.animBgRef;
                        if (weakReference != null) {
                            festivalHbPagView = (FestivalHbPagView) weakReference.get();
                        } else {
                            festivalHbPagView = null;
                        }
                        if (festivalHbPagView != null) {
                            festivalHbPagView.setVisibility(4);
                        }
                        this.f277491e.removeListener(this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                    invoke2(pAGView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PAGView it) {
                    WeakReference weakReference2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    QWalletFestivalHbApiImpl qWalletFestivalHbApiImpl = QWalletFestivalHbApiImpl.this;
                    FestivalHbData.Anim anim2 = anim;
                    it.setPath(qWalletFestivalHbApiImpl.getResPath(anim2.getBgUrl(), anim2.getBgSuffix()));
                    weakReference2 = qWalletFestivalHbApiImpl.animBgRef;
                    FestivalHbPagView festivalHbPagView2 = weakReference2 != null ? (FestivalHbPagView) weakReference2.get() : null;
                    if (festivalHbPagView2 != null) {
                        festivalHbPagView2.setVisibility(0);
                    }
                    it.addListener(new a(qWalletFestivalHbApiImpl, it));
                    it.setRepeatCount(1);
                    it.play();
                }
            });
        }
    }

    private final void playFgAnim(final FestivalHbData.Anim anim) {
        FestivalHbPagView festivalHbPagView;
        FestivalHbPagView k3;
        FestivalHbPagView i3;
        QLog.i(TAG, 1, "[playFgAnim]");
        WeakReference<FestivalHbPagView> weakReference = this.animFgRef;
        if (weakReference != null && (festivalHbPagView = weakReference.get()) != null && (k3 = festivalHbPagView.k()) != null && (i3 = k3.i()) != null) {
            i3.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl$playFgAnim$1$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/impl/QWalletFestivalHbApiImpl$playFgAnim$1$1$a", "Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView$a;", "Lorg/libpag/PAGView;", "pagView", "", "onAnimationEnd", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes16.dex */
                public static final class a extends FestivalHbPagView.a {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ PAGView f277492d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ QWalletFestivalHbApiImpl f277493e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ FestivalHbData.Anim f277494f;

                    a(PAGView pAGView, QWalletFestivalHbApiImpl qWalletFestivalHbApiImpl, FestivalHbData.Anim anim) {
                        this.f277492d = pAGView;
                        this.f277493e = qWalletFestivalHbApiImpl;
                        this.f277494f = anim;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void c(QWalletFestivalHbApiImpl this$0, FestivalHbData.Anim anim) {
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        Intrinsics.checkNotNullParameter(anim, "$anim");
                        this$0.playFgLoopAnim(anim);
                    }

                    @Override // org.libpag.PAGView.PAGViewListener
                    public void onAnimationEnd(@Nullable PAGView pagView) {
                        this.f277492d.removeListener(this);
                        if (Intrinsics.areEqual(this.f277493e.currentAnim, this.f277494f)) {
                            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                            final QWalletFestivalHbApiImpl qWalletFestivalHbApiImpl = this.f277493e;
                            final FestivalHbData.Anim anim = this.f277494f;
                            uIHandlerV2.post(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0020: INVOKE 
                                  (r4v6 'uIHandlerV2' android.os.Handler)
                                  (wrap:java.lang.Runnable:0x001d: CONSTRUCTOR 
                                  (r0v2 'qWalletFestivalHbApiImpl' com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl A[DONT_INLINE])
                                  (r1v1 'anim' tk2.a$b A[DONT_INLINE])
                                 A[MD:(com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl, tk2.a$b):void (m), WRAPPED] (LINE:30) call: com.tencent.mobileqq.qwallet.hb.impl.j.<init>(com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl, tk2.a$b):void type: CONSTRUCTOR)
                                 VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (c)] (LINE:33) in method: com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl$playFgAnim$1$1.a.onAnimationEnd(org.libpag.PAGView):void, file: classes16.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.qwallet.hb.impl.j, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 21 more
                                */
                            /*
                                this = this;
                                org.libpag.PAGView r4 = r3.f277492d
                                r4.removeListener(r3)
                                com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl r4 = r3.f277493e
                                tk2.a$b r4 = com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl.access$getCurrentAnim$p(r4)
                                tk2.a$b r0 = r3.f277494f
                                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r0)
                                if (r4 == 0) goto L23
                                android.os.Handler r4 = com.tencent.mobileqq.app.ThreadManagerV2.getUIHandlerV2()
                                com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl r0 = r3.f277493e
                                tk2.a$b r1 = r3.f277494f
                                com.tencent.mobileqq.qwallet.hb.impl.j r2 = new com.tencent.mobileqq.qwallet.hb.impl.j
                                r2.<init>(r0, r1)
                                r4.post(r2)
                            L23:
                                r4 = 1
                                java.lang.String r0 = "[playFgAnim] onAnimationEnd"
                                java.lang.String r1 = "QWallet.Festival.QWalletFestivalHbApiImpl"
                                com.tencent.qphone.base.util.QLog.i(r1, r4, r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl$playFgAnim$1$1.a.onAnimationEnd(org.libpag.PAGView):void");
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                        invoke2(pAGView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull PAGView it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        QWalletFestivalHbApiImpl qWalletFestivalHbApiImpl = QWalletFestivalHbApiImpl.this;
                        FestivalHbData.Anim anim2 = anim;
                        it.setPath(qWalletFestivalHbApiImpl.getResPath(anim2.getFgUrl(), anim2.getFgEnterSuffix()));
                        it.setRepeatCount(1);
                        it.addListener(new a(it, qWalletFestivalHbApiImpl, anim2));
                        it.play();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void playFgLoopAnim(final FestivalHbData.Anim anim) {
            FestivalHbPagView festivalHbPagView;
            WeakReference<FestivalHbPagView> weakReference = this.animFgRef;
            if (weakReference != null && (festivalHbPagView = weakReference.get()) != null) {
                festivalHbPagView.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.impl.QWalletFestivalHbApiImpl$playFgLoopAnim$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                        invoke2(pAGView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull PAGView it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        QWalletFestivalHbApiImpl qWalletFestivalHbApiImpl = QWalletFestivalHbApiImpl.this;
                        FestivalHbData.Anim anim2 = anim;
                        it.setPath(qWalletFestivalHbApiImpl.getResPath(anim2.getFgUrl(), anim2.getFgLoopSuffix()));
                        it.setRepeatCount(0);
                        it.play();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void playPagAnim$lambda$15(QWalletFestivalHbApiImpl this$0, FestivalHbData.Anim anim) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(anim, "$anim");
            this$0.checkIfPlayAnim(anim);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void preDownloadSkinRes$lambda$10(ArrayList list) {
            boolean z16;
            boolean z17;
            boolean contains;
            boolean contains2;
            boolean contains3;
            Intrinsics.checkNotNullParameter(list, "$list");
            final ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                FestivalHbData.Anim anim = ((FestivalHbData) it.next()).getAnim();
                String fgUrl = anim.getFgUrl();
                boolean z18 = false;
                if (fgUrl != null && fgUrl.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    contains3 = CollectionsKt___CollectionsKt.contains(arrayList, anim.getFgUrl());
                    if (!contains3) {
                        String fgUrl2 = anim.getFgUrl();
                        Intrinsics.checkNotNull(fgUrl2);
                        arrayList.add(fgUrl2);
                    }
                }
                String bgUrl = anim.getBgUrl();
                if (bgUrl != null && bgUrl.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    contains2 = CollectionsKt___CollectionsKt.contains(arrayList, anim.getBgUrl());
                    if (!contains2) {
                        String bgUrl2 = anim.getBgUrl();
                        Intrinsics.checkNotNull(bgUrl2);
                        arrayList.add(bgUrl2);
                    }
                }
                String aioUrl = anim.getAioUrl();
                if (aioUrl == null || aioUrl.length() == 0) {
                    z18 = true;
                }
                if (!z18) {
                    contains = CollectionsKt___CollectionsKt.contains(arrayList, anim.getAioUrl());
                    if (!contains) {
                        String aioUrl2 = anim.getAioUrl();
                        Intrinsics.checkNotNull(aioUrl2);
                        arrayList.add(aioUrl2);
                    }
                }
            }
            com.tencent.mobileqq.qwallet.preload.a.h().downloadUrls(arrayList, new IPreloadService.c() { // from class: com.tencent.mobileqq.qwallet.hb.impl.g
                @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
                public final void onResult(int i3, IPreloadService.PathResult pathResult) {
                    QWalletFestivalHbApiImpl.preDownloadSkinRes$lambda$10$lambda$9(arrayList, i3, pathResult);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void preDownloadSkinRes$lambda$10$lambda$9(ArrayList urlList, int i3, IPreloadService.PathResult pathResult) {
            Intrinsics.checkNotNullParameter(urlList, "$urlList");
            QLog.i(TAG, 1, "[preDownloadFestivalRes] result:" + pathResult + ",urlListSize:" + urlList.size());
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public void adjustClosePosition(@NotNull final ImageView ivOutClose, @NotNull final ImageView ivInClose) {
            Intrinsics.checkNotNullParameter(ivOutClose, "ivOutClose");
            Intrinsics.checkNotNullParameter(ivInClose, "ivInClose");
            ivOutClose.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletFestivalHbApiImpl.adjustClosePosition$lambda$21(ivOutClose, ivInClose);
                }
            });
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public boolean checkIfDisablePag() {
            JSONArray optJSONArray;
            String s16 = ah.s();
            JSONObject jSONObject = ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).getJSONObject(IQWalletFeatureApi.QWALLET_PAG_ANIM_STRATEGY);
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("disableDeviceList")) != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    if (optJSONArray.optString(i3).equals(s16)) {
                        QLog.i(TAG, 1, "isInDisablePagDevicesList true,model" + s16);
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public void checkIfNeedLoadLightSdk() {
            boolean z16;
            if (isLightSdkInit) {
                QLog.i(TAG, 1, "[checkIfLoadLightSdkSo] already init");
                return;
            }
            if (!checkIfDisablePag() && !isDisableLoadLightSdk()) {
                long currentTimeMillis = System.currentTimeMillis();
                QRouteApi api = QRoute.api(IAEResUtil.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IAEResUtil::class.java)");
                IAEResUtil iAEResUtil = (IAEResUtil) api;
                boolean z17 = false;
                if (iAEResUtil.isLightSDKResExist()) {
                    try {
                        z16 = iAEResUtil.loadLightSdk();
                        if (z16) {
                            try {
                                LightEngine.init();
                                isLightSdkInit = true;
                            } catch (Exception e16) {
                                e = e16;
                                QLog.e(TAG, 1, e, new Object[0]);
                                z17 = z16;
                                QLog.i(TAG, 1, "[checkIfLoadLightSdkSo] loadSuccess:" + z17 + ",isLightSDKResExist:" + iAEResUtil.isLightSDKResExist() + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
                                return;
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        z16 = false;
                    }
                    z17 = z16;
                }
                QLog.i(TAG, 1, "[checkIfLoadLightSdkSo] loadSuccess:" + z17 + ",isLightSDKResExist:" + iAEResUtil.isLightSDKResExist() + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            QLog.i(TAG, 1, "[checkIfLoadLightSdkSo] disable load");
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        @NotNull
        public FestivalHbData convertHbData(@NotNull HbSkinData skinData) {
            Intrinsics.checkNotNullParameter(skinData, "skinData");
            return new FestivalHbData(skinData.getSkinId(), new FestivalHbData.BaseInfo(skinData.getTitle(), skinData.getPrice(), skinData.getTail().getWord()), new FestivalHbData.Extra(skinData.getActivityEntryName(), skinData.getActivityUrl(), skinData.getActivityIcon()), new FestivalHbData.Anim(skinData.getDefaultSkinUrl(), skinData.getPopResUrl(), skinData.getAioResUrl()));
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public int getCurrentScreenWidth() {
            return BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        @Nullable
        public JSONObject getFestivalHbPanelConfig() {
            try {
                return RedPacketManager.f(18);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                return null;
            }
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        @Nullable
        public String getResPath(@Nullable String resUrl, @NotNull String suffix) {
            Intrinsics.checkNotNullParameter(suffix, "suffix");
            if (resUrl == null) {
                return null;
            }
            IPreloadStaticApi iPreloadStaticApi = (IPreloadStaticApi) QRoute.api(IPreloadStaticApi.class);
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.url = resUrl;
            IPreloadService.PathResult resPathSync = iPreloadStaticApi.getResPathSync(downloadParam);
            if (resPathSync != null) {
                String str = resPathSync.folderPath + "/" + suffix;
                if (!FileUtils.isEmptyFile(str)) {
                    return str;
                }
            }
            QLog.i(TAG, 1, "[getResPath] path is empty,url:" + resUrl + ",suffix" + suffix);
            return null;
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public void getSkinData(final int skinId, @NotNull final Function1<? super HbSkinData, Unit> receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.impl.h
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletFestivalHbApiImpl.getSkinData$lambda$4(skinId, receiver, this);
                }
            }, 128, null, false);
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public boolean isAllAnimResReady(@NotNull FestivalHbData.Anim anim) {
            Intrinsics.checkNotNullParameter(anim, "anim");
            if (isBgResExists(anim) && isFgEnterResExists(anim) && isFgLoopResExists(anim)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public boolean isBgResExists(@NotNull FestivalHbData.Anim anim) {
            boolean z16;
            Intrinsics.checkNotNullParameter(anim, "anim");
            String resPath = getResPath(anim.getBgUrl(), anim.getBgSuffix());
            if (resPath == null) {
                return false;
            }
            if (resPath.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public boolean isFgEnterResExists(@NotNull FestivalHbData.Anim anim) {
            boolean z16;
            Intrinsics.checkNotNullParameter(anim, "anim");
            String resPath = getResPath(anim.getFgUrl(), anim.getFgEnterSuffix());
            if (resPath == null) {
                return false;
            }
            if (resPath.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public boolean isFgLoopResExists(@NotNull FestivalHbData.Anim anim) {
            boolean z16;
            Intrinsics.checkNotNullParameter(anim, "anim");
            String resPath = getResPath(anim.getFgUrl(), anim.getFgLoopSuffix());
            if (resPath == null) {
                return false;
            }
            if (resPath.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public void playPagAnim(@NotNull final FestivalHbData.Anim anim, @NotNull FestivalHbPagView animBgView, @NotNull FestivalHbPagView animFgView) {
            Intrinsics.checkNotNullParameter(anim, "anim");
            Intrinsics.checkNotNullParameter(animBgView, "animBgView");
            Intrinsics.checkNotNullParameter(animFgView, "animFgView");
            if (checkIfDisablePag()) {
                return;
            }
            this.animBgRef = new WeakReference<>(animBgView);
            this.animFgRef = new WeakReference<>(animFgView);
            this.currentAnim = anim;
            if (!isBgResExists(anim)) {
                IPreloadServiceAbs h16 = com.tencent.mobileqq.qwallet.preload.a.h();
                DownloadParam downloadParam = new DownloadParam();
                downloadParam.url = anim.getBgUrl();
                h16.getResPath(downloadParam, new b(this, anim));
            }
            if (!isFgEnterResExists(anim) || !isFgLoopResExists(anim)) {
                IPreloadServiceAbs h17 = com.tencent.mobileqq.qwallet.preload.a.h();
                DownloadParam downloadParam2 = new DownloadParam();
                downloadParam2.url = anim.getFgUrl();
                h17.getResPath(downloadParam2, new b(this, anim));
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletFestivalHbApiImpl.playPagAnim$lambda$15(QWalletFestivalHbApiImpl.this, anim);
                }
            });
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public void preDownloadSkinRes(@NotNull final ArrayList<FestivalHbData> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletFestivalHbApiImpl.preDownloadSkinRes$lambda$10(list);
                }
            }, 128, null, false);
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public void releasePagAnim() {
            FestivalHbPagView festivalHbPagView;
            FestivalHbPagView festivalHbPagView2;
            WeakReference<FestivalHbPagView> weakReference = this.animBgRef;
            if (weakReference != null && (festivalHbPagView2 = weakReference.get()) != null) {
                festivalHbPagView2.m();
            }
            WeakReference<FestivalHbPagView> weakReference2 = this.animFgRef;
            if (weakReference2 != null && (festivalHbPagView = weakReference2.get()) != null) {
                festivalHbPagView.m();
            }
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public boolean verifyPanelData(@Nullable Integer sessionType, @NotNull PanelEntryData panelData) {
            JSONArray jSONArray;
            Intrinsics.checkNotNullParameter(panelData, "panelData");
            if (sessionType != null && sessionType.intValue() == 0) {
                JSONObject params = panelData.getParams();
                if (params != null) {
                    jSONArray = params.optJSONArray("skinIDList");
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        int optInt = jSONArray.optInt(i3);
                        HbSkinData f16 = HbSkinRepository.f(HbSkinRepository.f277840a, optInt, null, 0, 6, null);
                        if (f16 != null) {
                            if (f16.getPrice() != 0) {
                                arrayList.add(f16);
                            } else {
                                QLog.i(TAG, 1, "skin price is invalid,skinId:" + optInt);
                            }
                        } else {
                            QLog.i(TAG, 1, "get cache SkinData failed:" + optInt);
                            arrayList2.add(Integer.valueOf(optInt));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        return true;
                    }
                    forceUpdateSkinDataList(arrayList2);
                    QLog.i(TAG, 1, "[verifyFestivalRedPkg] no local skin data");
                    return false;
                }
                QLog.i(TAG, 1, "[verifyFestivalRedPkg] skinIDList is empty");
            }
            return false;
        }

        @Override // com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi
        public void getResPath(@NotNull DownloadParam params, @Nullable IPreloadService.c listener) {
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.mobileqq.qwallet.preload.a.h().getResPath(params, listener);
        }
    }
