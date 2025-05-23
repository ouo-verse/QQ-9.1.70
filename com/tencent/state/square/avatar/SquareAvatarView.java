package com.tencent.state.square.avatar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.ye.m;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.service.ImageService;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.avatar.IAvatarAnimView;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.utils.AnimationUtils;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0012\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002RSB/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0001J\u0017\u0010\u001d\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fH\u0096\u0001J\"\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u001a\u0010$\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\u0012\u0010'\u001a\u00020\u001a2\b\b\u0002\u0010(\u001a\u00020#H\u0002J\u0010\u0010)\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010\u0010J\b\u0010+\u001a\u00020\u001aH\u0002J\t\u0010,\u001a\u00020\u001aH\u0096\u0001J\b\u0010-\u001a\u00020\u001aH\u0016J\u001a\u0010.\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u000100H\u0096\u0001J\u0006\u00101\u001a\u00020#J\t\u00102\u001a\u000203H\u0096\u0001J\t\u00104\u001a\u00020#H\u0096\u0001J\b\u00105\u001a\u00020\u001aH\u0016J\u0011\u00106\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J\b\u00107\u001a\u00020\u001aH\u0016J\"\u00108\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00109\u001a\u00020#H\u0016J\u0010\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020#H\u0016J\u0010\u0010<\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020#H\u0016J\u0010\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020#H\u0016J\u0006\u0010D\u001a\u00020\u001aJ\u001a\u0010E\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010F\u001a\u00020#H\u0016J\u0010\u0010G\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020#H\u0016J\t\u0010H\u001a\u00020\u001aH\u0096\u0001J*\u0010I\u001a\u00020\u001a2\u0006\u0010J\u001a\u0002032\u0006\u0010A\u001a\u00020#2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010LH\u0002J\b\u0010M\u001a\u00020\u001aH\u0016J\b\u0010N\u001a\u00020#H\u0002J\u0010\u0010O\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0010H\u0016J\u000e\u0010P\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\u0018R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006T"}, d2 = {"Lcom/tencent/state/square/avatar/SquareAvatarView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/square/avatar/IAvatarAnimView;", "Lcom/tencent/state/square/avatar/ISquareAvatarView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "delegate", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/state/square/avatar/IAvatarAnimView;)V", "avatarContainer", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/avatar/AvatarAnimConfig;", "currentSource", "Lcom/tencent/state/square/media/MapPlayableSource;", "errorShowStaticListener", "com/tencent/state/square/avatar/SquareAvatarView$errorShowStaticListener$1", "Lcom/tencent/state/square/avatar/SquareAvatarView$errorShowStaticListener$1;", "staticImageView", "Lcom/tencent/state/view/SquareImageView;", "tempAvatarDelegate", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "", "addListener", "", "listener", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "addListeners", "listeners", "", "changeSourceWithAnim", "source", "needCleanAll", "", "checkAndDoChangeAnimation", "checkAndNewInstanceTempAvatarDelegate", "checkAndRemoveTempView", "checkIfNeedReplaceDelegate", "ignoreVisibility", "checkIsChange", "newSource", "checkVideoViewVisible", "clearListeners", "destroy", "doChangeSourceAnim", "getListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "getLoopPlay", "getView", "Landroid/view/View;", "isPlaying", "pause", "removeListener", "resume", "setAnimSource", "needAnim", "setAutoShowStatic", "autoStatic", "setConfig", "setData", "data", "Lcom/tencent/state/map/MapPlayableItem;", "setImageViewVisibility", ViewStickEventHelper.IS_SHOW, "setLoopPlay", "isLoop", "setNonSource", "setStaticSource", NodeProps.VISIBLE, "setVideoViewVisibility", "start", "startAlphaAnimation", "view", "animationEnd", "Lkotlin/Function0;", "stop", "supportFilament", "updateAnimSource", m.NAME, "path", "Companion", "PlayerListener", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAvatarView extends FrameLayout implements IAvatarAnimView, ISquareAvatarView {
    private static final int AVATAR_CONTAINER_MAX_CHILD = 2;
    private static final String TAG = "SquareAvatarView";
    private final /* synthetic */ IAvatarAnimView $$delegate_0;
    private final FrameLayout avatarContainer;
    private AvatarAnimConfig config;
    private MapPlayableSource currentSource;
    private IAvatarAnimView delegate;
    private final SquareAvatarView$errorShowStaticListener$1 errorShowStaticListener;
    private final SquareImageView staticImageView;
    private IAvatarAnimView tempAvatarDelegate;
    private String uniqueId;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\t\u0010\u000e\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0007H\u0096\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/avatar/SquareAvatarView$PlayerListener;", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "source", "Lcom/tencent/state/square/media/MapPlayableSource;", "listener", "(Lcom/tencent/state/square/avatar/SquareAvatarView;Lcom/tencent/state/square/media/MapPlayableSource;Lcom/tencent/state/square/avatar/IAvatarAnimListener;)V", "onFirstFrame", "", HippyQQPagView.EventName.ON_PLAY_END, "onPlayError", "errorCode", "", HippyQQPagView.EventName.ON_PLAY_START, "onRemovedListener", "onStaticFailed", "onStaticSuccess", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public class PlayerListener implements IAvatarAnimListener {
        private final /* synthetic */ IAvatarAnimListener $$delegate_0;
        private final IAvatarAnimListener listener;
        private final MapPlayableSource source;
        final /* synthetic */ SquareAvatarView this$0;

        public PlayerListener(SquareAvatarView squareAvatarView, MapPlayableSource source, IAvatarAnimListener iAvatarAnimListener) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.this$0 = squareAvatarView;
            this.$$delegate_0 = iAvatarAnimListener != null ? iAvatarAnimListener : new EmptyAnimListener();
            this.source = source;
            this.listener = iAvatarAnimListener;
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onFirstFrame() {
            this.this$0.setImageViewVisibility(false);
            IAvatarAnimListener iAvatarAnimListener = this.listener;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onFirstFrame();
            }
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayEnd() {
            SquareBaseKt.getSquareLog().i(SquareAvatarView.TAG, "PlayerListener onPlayEnd " + this.source);
            IAvatarAnimListener iAvatarAnimListener = this.listener;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onPlayEnd();
            }
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayError(int errorCode) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), SquareAvatarView.TAG, "onPlayError: " + errorCode + ", " + this.source, null, 4, null);
            IAvatarAnimListener iAvatarAnimListener = this.listener;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onPlayError(errorCode);
            }
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayStart() {
            this.this$0.setVideoViewVisibility(true);
            IAvatarAnimListener iAvatarAnimListener = this.listener;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onPlayStart();
            }
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onRemovedListener() {
            IAvatarAnimListener iAvatarAnimListener = this.listener;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onRemovedListener();
            }
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onStaticFailed() {
            this.$$delegate_0.onStaticFailed();
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onStaticSuccess() {
            this.$$delegate_0.onStaticSuccess();
        }
    }

    public SquareAvatarView(Context context) {
        this(context, null, 0, null, 14, null);
    }

    private final void checkAndDoChangeAnimation(MapPlayableSource source, IAvatarAnimListener listener) {
        View view;
        SquareBaseKt.getSquareLog().i(TAG, "checkAndDoChangeAnimation " + source + ", tempAvatarDelegate:" + this.tempAvatarDelegate);
        synchronized (this) {
            IAvatarAnimView iAvatarAnimView = this.tempAvatarDelegate;
            if (iAvatarAnimView != null) {
                Object tag = (iAvatarAnimView == null || (view = iAvatarAnimView.getView()) == null) ? null : view.getTag();
                if (!(tag instanceof ObjectAnimator)) {
                    tag = null;
                }
                ObjectAnimator objectAnimator = (ObjectAnimator) tag;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                Object tag2 = this.delegate.getView().getTag();
                if (!(tag2 instanceof ObjectAnimator)) {
                    tag2 = null;
                }
                ObjectAnimator objectAnimator2 = (ObjectAnimator) tag2;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
                checkIfNeedReplaceDelegate$default(this, false, 1, null);
                if (this.tempAvatarDelegate != null) {
                    setVideoViewVisibility(true);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        doChangeSourceAnim(source, listener);
    }

    private final boolean checkAndNewInstanceTempAvatarDelegate() {
        SquareBaseKt.getSquareLog().i(TAG, "checkAndNewInstanceTempAvatarDelegate " + this.avatarContainer.getChildCount() + " tempAvatarDelegate:" + this.tempAvatarDelegate);
        if (this.tempAvatarDelegate != null) {
            return false;
        }
        synchronized (this) {
            if (this.tempAvatarDelegate == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                PlayerAvatarView playerAvatarView = new PlayerAvatarView(context);
                this.tempAvatarDelegate = playerAvatarView;
                playerAvatarView.setConfig(this.config);
                if (this.avatarContainer.getChildCount() > 2) {
                    this.avatarContainer.removeViewAt(1);
                }
                if (!supportFilament()) {
                    this.avatarContainer.addView(playerAvatarView.getView(), new FrameLayout.LayoutParams(-1, -1));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return true;
    }

    private final void checkAndRemoveTempView() {
        IAvatarAnimView iAvatarAnimView = this.tempAvatarDelegate;
        if (iAvatarAnimView != null) {
            this.avatarContainer.removeView(iAvatarAnimView.getView());
            this.tempAvatarDelegate = null;
        }
    }

    private final void checkIfNeedReplaceDelegate(boolean ignoreVisibility) {
        SquareBaseKt.getSquareLog().d(TAG, "checkIfNeedReplaceDelegate");
        synchronized (this) {
            IAvatarAnimView iAvatarAnimView = this.tempAvatarDelegate;
            if (iAvatarAnimView != null) {
                CopyOnWriteArraySet<IAvatarAnimListener> listeners = this.delegate.getListeners();
                if (listeners != null) {
                    iAvatarAnimView.addListeners(listeners);
                }
                this.delegate.clearListeners();
                this.avatarContainer.removeView(this.delegate.getView());
                this.delegate.destroy();
                this.delegate = iAvatarAnimView;
                iAvatarAnimView.setConfig(this.config);
                if (!ignoreVisibility) {
                    setVideoViewVisibility(true);
                }
                this.tempAvatarDelegate = null;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void checkVideoViewVisible() {
        if (supportFilament() || this.delegate.getView().getVisibility() == 0) {
            return;
        }
        this.delegate.getView().setAlpha(0.0f);
        this.delegate.getView().setVisibility(0);
    }

    private final void doChangeSourceAnim(final MapPlayableSource source, final IAvatarAnimListener listener) {
        SquareBaseKt.getSquareLog().i(TAG, "doChangeSourceAnim " + getChildCount() + ", " + source + ", tempAvatarDelegate:" + this.tempAvatarDelegate);
        checkAndNewInstanceTempAvatarDelegate();
        final IAvatarAnimView iAvatarAnimView = this.tempAvatarDelegate;
        if (iAvatarAnimView != null) {
            SquareBaseKt.getSquareLog().i(TAG, "changeSource set tempAvatarDelegate:" + iAvatarAnimView);
            iAvatarAnimView.getView().setAlpha(0.0f);
            iAvatarAnimView.getView().setVisibility(0);
            iAvatarAnimView.updateAnimSource(source);
            iAvatarAnimView.addListener(new IAvatarAnimListener() { // from class: com.tencent.state.square.avatar.SquareAvatarView$doChangeSourceAnim$$inlined$let$lambda$1
                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onFirstFrame() {
                    IAvatarAnimView iAvatarAnimView2;
                    SquareBaseKt.getSquareLog().i("SquareAvatarView", "changeSourceWithAnim onFirstFrame: " + source);
                    this.setImageViewVisibility(false);
                    SquareAvatarView.startAlphaAnimation$default(this, IAvatarAnimView.this.getView(), true, null, 4, null);
                    SquareAvatarView squareAvatarView = this;
                    iAvatarAnimView2 = squareAvatarView.delegate;
                    squareAvatarView.startAlphaAnimation(iAvatarAnimView2.getView(), false, new Function0<Unit>() { // from class: com.tencent.state.square.avatar.SquareAvatarView$doChangeSourceAnim$$inlined$let$lambda$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            SquareAvatarView.checkIfNeedReplaceDelegate$default(this, false, 1, null);
                        }
                    });
                    IAvatarAnimListener iAvatarAnimListener = listener;
                    if (iAvatarAnimListener != null) {
                        iAvatarAnimListener.onFirstFrame();
                    }
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onPlayEnd() {
                    IAvatarAnimListener.DefaultImpls.onPlayEnd(this);
                    SquareBaseKt.getSquareLog().i("SquareAvatarView", "changeSourceWithAnim onPlayEnd: " + source);
                    this.tempAvatarDelegate = null;
                    IAvatarAnimListener iAvatarAnimListener = listener;
                    if (iAvatarAnimListener != null) {
                        iAvatarAnimListener.onPlayEnd();
                    }
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onPlayError(int errorCode) {
                    SquareBaseKt.getSquareLog().i("SquareAvatarView", "changeSourceWithAnim onPlayError: " + source);
                    this.setImageViewVisibility(true);
                    SquareAvatarView.checkIfNeedReplaceDelegate$default(this, false, 1, null);
                    this.setVideoViewVisibility(false);
                    this.setStaticSource(source, true);
                    IAvatarAnimListener iAvatarAnimListener = listener;
                    if (iAvatarAnimListener != null) {
                        iAvatarAnimListener.onPlayError(errorCode);
                    }
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onPlayStart() {
                    IAvatarAnimListener iAvatarAnimListener = listener;
                    if (iAvatarAnimListener != null) {
                        iAvatarAnimListener.onPlayStart();
                    }
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onRemovedListener() {
                    IAvatarAnimListener iAvatarAnimListener = listener;
                    if (iAvatarAnimListener != null) {
                        iAvatarAnimListener.onRemovedListener();
                    }
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onStaticFailed() {
                    IAvatarAnimListener.DefaultImpls.onStaticFailed(this);
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onStaticSuccess() {
                    IAvatarAnimListener.DefaultImpls.onStaticSuccess(this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAlphaAnimation(final View view, final boolean isShow, final Function0<Unit> animationEnd) {
        Object tag = view.getTag();
        if (!(tag instanceof ObjectAnimator)) {
            tag = null;
        }
        ObjectAnimator objectAnimator = (ObjectAnimator) tag;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        view.setTag(AnimationUtils.INSTANCE.startAlphaAnimation(view, isShow, 400L, new AnimatorListenerAdapter() { // from class: com.tencent.state.square.avatar.SquareAvatarView$startAlphaAnimation$alpha$1
            private boolean isCancel;

            /* renamed from: isCancel, reason: from getter */
            public final boolean getIsCancel() {
                return this.isCancel;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (this.isCancel) {
                    return;
                }
                view.setTag(null);
                Function0 function0 = animationEnd;
                if (function0 != null) {
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                view.setAlpha(isShow ? 0.0f : 1.0f);
                this.isCancel = false;
            }

            public final void setCancel(boolean z16) {
                this.isCancel = z16;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                this.isCancel = true;
                view.setTag(null);
            }
        }));
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (com.tencent.state.utils.SquareSwitchUtils.INSTANCE.enableFilamentIndex() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean supportFilament() {
        boolean z16;
        MapPlayableSource mapPlayableSource = this.currentSource;
        if (mapPlayableSource != null) {
            z16 = true;
            if (mapPlayableSource.getSupportFilament()) {
            }
        }
        z16 = false;
        if (z16) {
            ViewExtensionsKt.setVisibility(this.delegate.getView(), false);
        }
        return z16;
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void addListener(IAvatarAnimListener listener) {
        this.$$delegate_0.addListener(listener);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void addListeners(Set<? extends IAvatarAnimListener> listeners) {
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.$$delegate_0.addListeners(listeners);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void changeSourceWithAnim(final MapPlayableSource source, final IAvatarAnimListener listener, boolean needCleanAll) {
        SquareImageView squareImageView;
        Intrinsics.checkNotNullParameter(source, "source");
        this.currentSource = source;
        if (listener != null) {
            this.delegate.clearListeners();
        }
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("changeSourceWithAnim, hasTemp:");
        sb5.append(this.tempAvatarDelegate != null);
        sb5.append(", ");
        sb5.append(source);
        squareLog.i(TAG, sb5.toString());
        final WeakReference weakReference = new WeakReference(this.staticImageView);
        SquareImageView squareImageView2 = (SquareImageView) weakReference.get();
        if (squareImageView2 != null && squareImageView2.getVisibility() == 0 && ((squareImageView = (SquareImageView) weakReference.get()) == null || squareImageView.getAlpha() != 0.0f)) {
            SquareBaseKt.getSquareLog().i(TAG, "setAnimSource with anim from image: " + source);
            this.delegate.addListener(new IAvatarAnimListener() { // from class: com.tencent.state.square.avatar.SquareAvatarView$changeSourceWithAnim$playerListener$1
                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onFirstFrame() {
                    IAvatarAnimView iAvatarAnimView;
                    SquareBaseKt.getSquareLog().i("SquareAvatarView", "setAnimSource onFirstFrame: " + source);
                    SquareAvatarView squareAvatarView = SquareAvatarView.this;
                    iAvatarAnimView = squareAvatarView.delegate;
                    SquareAvatarView.startAlphaAnimation$default(squareAvatarView, iAvatarAnimView.getView(), true, null, 4, null);
                    SquareImageView it = (SquareImageView) weakReference.get();
                    if (it != null) {
                        SquareAvatarView squareAvatarView2 = SquareAvatarView.this;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        SquareAvatarView.startAlphaAnimation$default(squareAvatarView2, it, false, null, 4, null);
                    }
                    IAvatarAnimListener iAvatarAnimListener = listener;
                    if (iAvatarAnimListener != null) {
                        iAvatarAnimListener.onFirstFrame();
                    }
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onPlayEnd() {
                    SquareBaseKt.getSquareLog().i("SquareAvatarView", "setAnimSource onPlayEnd " + source);
                    IAvatarAnimListener iAvatarAnimListener = listener;
                    if (iAvatarAnimListener != null) {
                        iAvatarAnimListener.onPlayEnd();
                    }
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onPlayError(int errorCode) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareAvatarView", "setAnimSource onPlayError: " + errorCode + ", " + source, null, 4, null);
                    SquareAvatarView.this.setImageViewVisibility(true);
                    SquareAvatarView.this.setVideoViewVisibility(false);
                    IAvatarAnimListener iAvatarAnimListener = listener;
                    if (iAvatarAnimListener != null) {
                        iAvatarAnimListener.onPlayError(errorCode);
                    }
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onPlayStart() {
                    IAvatarAnimListener iAvatarAnimListener = listener;
                    if (iAvatarAnimListener != null) {
                        iAvatarAnimListener.onPlayStart();
                    }
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onRemovedListener() {
                    IAvatarAnimListener iAvatarAnimListener = listener;
                    if (iAvatarAnimListener != null) {
                        iAvatarAnimListener.onRemovedListener();
                    }
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onStaticFailed() {
                    IAvatarAnimListener.DefaultImpls.onStaticFailed(this);
                }

                @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                public void onStaticSuccess() {
                    IAvatarAnimListener.DefaultImpls.onStaticSuccess(this);
                }
            });
            this.delegate.addListener(this.errorShowStaticListener);
            this.delegate.updateAnimSource(source);
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "setAnimSource with anim from video frame" + source);
        checkAndDoChangeAnimation(source, listener);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void clearListeners() {
        this.$$delegate_0.clearListeners();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void destroy() {
        this.staticImageView.setImageDrawable(null);
        setVideoViewVisibility(false);
        this.currentSource = null;
        this.delegate.destroy();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public CopyOnWriteArraySet<IAvatarAnimListener> getListeners() {
        return this.$$delegate_0.getListeners();
    }

    public final boolean getLoopPlay() {
        return this.config.getPlayConfig().getIsLoop();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public View getView() {
        return this.$$delegate_0.getView();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public boolean isPlaying() {
        return this.$$delegate_0.isPlaying();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void pause() {
        this.delegate.pause();
        IAvatarAnimView iAvatarAnimView = this.tempAvatarDelegate;
        if (iAvatarAnimView != null) {
            iAvatarAnimView.pause();
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void removeListener(IAvatarAnimListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.$$delegate_0.removeListener(listener);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void resume() {
        this.delegate.resume();
        IAvatarAnimView iAvatarAnimView = this.tempAvatarDelegate;
        if (iAvatarAnimView != null) {
            iAvatarAnimView.resume();
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setAnimSource(MapPlayableSource source, IAvatarAnimListener listener, boolean needAnim) {
        Intrinsics.checkNotNullParameter(source, "source");
        SquareBaseKt.getSquareLog().i(TAG, "setAnimSource: " + this.delegate.getView().getVisibility() + ", " + this.delegate.getView().getAlpha() + ", " + source);
        checkIfNeedReplaceDelegate$default(this, false, 1, null);
        String remoteUrl = source.getRemoteUrl();
        MapPlayableSource mapPlayableSource = this.currentSource;
        boolean z16 = !Intrinsics.areEqual(remoteUrl, mapPlayableSource != null ? mapPlayableSource.getRemoteUrl() : null);
        this.currentSource = source;
        checkVideoViewVisible();
        if (supportFilament()) {
            return;
        }
        if (needAnim && z16) {
            SquareBaseKt.getSquareLog().i(TAG, "setAnimSource do changeSourceWithAnim: " + this.delegate.getView().getVisibility() + ", " + this.delegate.getView().getAlpha() + ", " + source);
            IAvatarAnimView.DefaultImpls.changeSourceWithAnim$default(this, source, listener, false, 4, null);
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "setAnimSource do setAnimSource: " + this.delegate.getView().getVisibility() + ", " + this.delegate.getView().getAlpha() + ", " + source);
        IAvatarAnimView.DefaultImpls.setAnimSource$default(this.delegate, source, new PlayerListener(this, source, listener), false, 4, null);
        this.delegate.addListener(this.errorShowStaticListener);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setAutoShowStatic(boolean autoStatic) {
        this.config.setAutoShowStaticWhenError(autoStatic);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setConfig(AvatarAnimConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.delegate.setConfig(config);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setData(MapPlayableItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.delegate.setData(data);
        this.uniqueId = data.getTroopName() + '(' + data.getUin() + ')';
    }

    @Override // com.tencent.state.square.avatar.ISquareAvatarView
    public void setImageViewVisibility(boolean isShow) {
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().i(TAG, "setImageViewVisibility: " + this.uniqueId + TokenParser.SP + isShow);
        }
        this.staticImageView.setVisibility(isShow ? 0 : 4);
        this.staticImageView.setAlpha(isShow ? 1.0f : 0.0f);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setLoopPlay(boolean isLoop) {
        this.config.getPlayConfig().setLoop(isLoop);
        if (isLoop) {
            this.config.getPlayConfig().setLoopCount(-1);
        }
        this.delegate.setLoopPlay(isLoop);
    }

    public final void setNonSource() {
        this.staticImageView.setImageDrawable(null);
        this.delegate.stop();
        checkIfNeedReplaceDelegate$default(this, false, 1, null);
        IAvatarAnimView iAvatarAnimView = this.tempAvatarDelegate;
        if (iAvatarAnimView != null) {
            iAvatarAnimView.stop();
        }
    }

    @Override // com.tencent.state.square.avatar.ISquareAvatarView
    public void setStaticSource(MapPlayableSource source, boolean visible) {
        this.currentSource = source;
        setImageViewVisibility(visible);
        setVideoViewVisibility(!visible);
        this.delegate.stop();
        checkAndRemoveTempView();
        PlayerSourceHelper.INSTANCE.setStaticImage(this.staticImageView, source, this.uniqueId);
    }

    @Override // com.tencent.state.square.avatar.ISquareAvatarView
    public void setVideoViewVisibility(boolean isShow) {
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().i(TAG, "setVideoViewVisibility: " + isShow);
        }
        Object tag = this.delegate.getView().getTag();
        if (!(tag instanceof ObjectAnimator)) {
            tag = null;
        }
        ObjectAnimator objectAnimator = (ObjectAnimator) tag;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            SquareBaseKt.getSquareLog().w(TAG, "setVideoViewVisibility but animator is running, skip");
            return;
        }
        this.delegate.getView().setAlpha(isShow ? 1.0f : 0.0f);
        if (isShow) {
            ViewExtensionsKt.setVisibility(this.delegate.getView(), true);
        }
        if (supportFilament()) {
            ViewExtensionsKt.setVisibility(this.delegate.getView(), false);
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void start() {
        this.$$delegate_0.start();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void stop() {
        this.delegate.stop();
        IAvatarAnimView iAvatarAnimView = this.tempAvatarDelegate;
        if (iAvatarAnimView != null) {
            iAvatarAnimView.stop();
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void updateAnimSource(MapPlayableSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        SquareBaseKt.getSquareLog().i(TAG, "updateAnimSource: " + source);
        this.currentSource = source;
        this.delegate.updateAnimSource(source);
        checkAndRemoveTempView();
    }

    public final void updateImageView(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (this.staticImageView.getDrawable() != null) {
            this.staticImageView.setImageDrawable(null);
        }
        ImageService.Companion.removeMemoryCache$default(ImageService.INSTANCE, path, new ImageViewAware(this.staticImageView), null, 4, null);
        ViewExtensionsKt.setUri(this.staticImageView, path);
    }

    public SquareAvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
    }

    public SquareAvatarView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, 8, null);
    }

    public /* synthetic */ SquareAvatarView(Context context, AttributeSet attributeSet, int i3, IAvatarAnimView iAvatarAnimView, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? new PlayerAvatarView(context) : iAvatarAnimView);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.tencent.state.square.avatar.SquareAvatarView$errorShowStaticListener$1] */
    public SquareAvatarView(Context context, AttributeSet attributeSet, int i3, IAvatarAnimView delegate) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.$$delegate_0 = delegate;
        this.delegate = delegate;
        SquareImageView squareImageView = new SquareImageView(context);
        this.staticImageView = squareImageView;
        FrameLayout frameLayout = new FrameLayout(context);
        this.avatarContainer = frameLayout;
        this.errorShowStaticListener = new IAvatarAnimListener() { // from class: com.tencent.state.square.avatar.SquareAvatarView$errorShowStaticListener$1
            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onFirstFrame() {
                IAvatarAnimListener.DefaultImpls.onFirstFrame(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayEnd() {
                IAvatarAnimListener.DefaultImpls.onPlayEnd(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayError(int errorCode) {
                MapPlayableSource mapPlayableSource;
                AvatarAnimConfig avatarAnimConfig;
                mapPlayableSource = SquareAvatarView.this.currentSource;
                if (mapPlayableSource != null) {
                    avatarAnimConfig = SquareAvatarView.this.config;
                    if (!avatarAnimConfig.getAutoShowStaticWhenError() || mapPlayableSource.getDefaultResourceId() == 0) {
                        return;
                    }
                    SquareAvatarView.this.setStaticSource(mapPlayableSource, true);
                }
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayStart() {
                IAvatarAnimListener.DefaultImpls.onPlayStart(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onRemovedListener() {
                IAvatarAnimListener.DefaultImpls.onRemovedListener(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticFailed() {
                IAvatarAnimListener.DefaultImpls.onStaticFailed(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticSuccess() {
                IAvatarAnimListener.DefaultImpls.onStaticSuccess(this);
            }
        };
        this.config = new AvatarAnimConfig(false, null, null, false, 15, null);
        this.uniqueId = "";
        addView(squareImageView, new FrameLayout.LayoutParams(-1, -1));
        if (!supportFilament()) {
            frameLayout.addView(this.delegate.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.delegate.getView().setVisibility(4);
    }

    public final boolean checkIsChange(MapPlayableSource newSource) {
        if (newSource == null) {
            return true;
        }
        return !Intrinsics.areEqual(this.currentSource != null ? r1.getFilamentUrl() : null, newSource.getFilamentUrl());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void checkIfNeedReplaceDelegate$default(SquareAvatarView squareAvatarView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        squareAvatarView.checkIfNeedReplaceDelegate(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startAlphaAnimation$default(SquareAvatarView squareAvatarView, View view, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        squareAvatarView.startAlphaAnimation(view, z16, function0);
    }
}
