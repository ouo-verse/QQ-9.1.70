package com.tencent.mobileqq.qwallet.hb.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001WB\u001f\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020\"\u00a2\u0006\u0004\bU\u0010VJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0004J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0007R\u001a\u0010!\u001a\u00020\u001c8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010'\u001a\u00020\"8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010-\u001a\u00020(8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00102\u001a\u00020.8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b0\u00101R\u0014\u00104\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010/R\"\u0010:\u001a\u0002058\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b\u001e\u00108\"\u0004\b3\u00109R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010<R\u0016\u0010F\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010\u001eR\u0016\u0010J\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010<R\"\u0010N\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010<\u001a\u0004\b\u001d\u0010L\"\u0004\b#\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/CoverStoryVideoViewHolder;", "Lcom/tencent/mobileqq/qwallet/hb/detail/CoverStoryBaseViewHolder;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "hbSkinData", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "storyRes", "", "w", "", "mute", "M", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinState;", "state", ReportConstant.COSTREPORT_PREFIX, "", "scrollOffset", "intermediateOffset", "totalScrollRange", "t", com.tencent.luggage.wxa.c8.c.f123400v, "r", "isVisible", "onVisibilityChanged", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "J", "I", "E", "()I", "skinId", "", "K", "Ljava/lang/String;", "H", "()Ljava/lang/String;", "uniqueSkinId", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbDetailVideoController;", "L", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbDetailVideoController;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/qwallet/hb/detail/HbDetailVideoController;", "controller", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "D", "()Landroid/widget/ImageView;", "muteVideoImg", "N", "previewImg", "Landroid/view/ViewGroup;", "P", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "videoItemRoot", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "isVisibled", BdhLogUtil.LogTag.Tag_Req, "isExpanded", ExifInterface.LATITUDE_SOUTH, "isInAutoState", "T", "isInAutoStatePlaying", "U", UserInfo.SEX_FEMALE, "currentAlpha", "V", "lastOffset", "W", "isOnPauseView", "X", "()Z", "(Z)V", "isCurrentMute", "Ljava/lang/Runnable;", "Y", "Ljava/lang/Runnable;", "autoPlayRunnable", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;ILjava/lang/String;)V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class CoverStoryVideoViewHolder extends CoverStoryBaseViewHolder {

    /* renamed from: J, reason: from kotlin metadata */
    private final int skinId;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final String uniqueSkinId;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final HbDetailVideoController controller;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final ImageView muteVideoImg;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final ImageView previewImg;

    /* renamed from: P, reason: from kotlin metadata */
    protected ViewGroup videoItemRoot;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isVisibled;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isExpanded;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isInAutoState;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isInAutoStatePlaying;

    /* renamed from: U, reason: from kotlin metadata */
    private float currentAlpha;

    /* renamed from: V, reason: from kotlin metadata */
    private int lastOffset;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isOnPauseView;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isCurrentMute;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Runnable autoPlayRunnable;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f277287a;

        static {
            int[] iArr = new int[HbSkinState.values().length];
            try {
                iArr[HbSkinState.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HbSkinState.EXPANDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HbSkinState.INTERMEDIATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HbSkinState.COLLAPSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f277287a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverStoryVideoViewHolder(@NotNull final View itemView, int i3, @NotNull String uniqueSkinId) {
        super(itemView, i3);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(uniqueSkinId, "uniqueSkinId");
        this.skinId = i3;
        this.uniqueSkinId = uniqueSkinId;
        Context context = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        HbDetailVideoController hbDetailVideoController = new HbDetailVideoController(context, i3, uniqueSkinId);
        this.controller = hbDetailVideoController;
        this.isCurrentMute = true;
        this.autoPlayRunnable = new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.detail.e
            @Override // java.lang.Runnable
            public final void run() {
                CoverStoryVideoViewHolder.B(CoverStoryVideoViewHolder.this, itemView);
            }
        };
        ViewGroup viewGroup = (ViewGroup) itemView.findViewById(R.id.f167092kq3);
        Object videoView = hbDetailVideoController.getVideoView();
        Intrinsics.checkNotNull(videoView, "null cannot be cast to non-null type android.view.View");
        viewGroup.addView((View) videoView);
        View findViewById = itemView.findViewById(R.id.f11768724);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.video_item_root)");
        N((ViewGroup) findViewById);
        View findViewById2 = itemView.findViewById(R.id.zkp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.mute_video_img)");
        this.muteVideoImg = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f27270fs);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.preview_image_view)");
        this.previewImg = (ImageView) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(CoverStoryVideoViewHolder this$0, View itemView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        QLog.d("CoverStoryVideoViewHolder", 4, "autoPlayRunnable run");
        this$0.isInAutoStatePlaying = true;
        if (this$0.isVisibled && !this$0.controller.j()) {
            this$0.controller.m();
        }
        this$0.I().setAlpha(1.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(this$0.currentAlpha, 1.0f);
        alphaAnimation.setDuration(500L);
        this$0.I().startAnimation(alphaAnimation);
        itemView.scrollTo(0, this$0.lastOffset / 2);
        this$0.isCurrentMute = true;
        this$0.M(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(CoverStoryVideoViewHolder this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = !this$0.controller.i();
        this$0.isCurrentMute = z16;
        this$0.M(z16);
        String valueOf = String.valueOf(this$0.skinId);
        if (this$0.isCurrentMute) {
            str = "1";
        } else {
            str = "0";
        }
        HbDetailModule.l("redpacket.voice.click", valueOf, str, this$0.uniqueSkinId);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: C, reason: from getter */
    public final HbDetailVideoController getController() {
        return this.controller;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: D, reason: from getter */
    public final ImageView getMuteVideoImg() {
        return this.muteVideoImg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E, reason: from getter */
    public final int getSkinId() {
        return this.skinId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: H, reason: from getter */
    public final String getUniqueSkinId() {
        return this.uniqueSkinId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ViewGroup I() {
        ViewGroup viewGroup = this.videoItemRoot;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoItemRoot");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: J, reason: from getter */
    public final boolean getIsCurrentMute() {
        return this.isCurrentMute;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(boolean z16) {
        this.isCurrentMute = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M(boolean mute) {
        this.controller.o(mute);
        this.muteVideoImg.setSelected(mute);
    }

    protected final void N(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.videoItemRoot = viewGroup;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        QLog.d("CoverStoryVideoViewHolder", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.controller.n();
        this.isCurrentMute = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.controller.j()) {
            this.controller.l();
            this.isOnPauseView = true;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.isOnPauseView) {
            this.controller.m();
        }
        this.isOnPauseView = false;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.CoverStoryBaseViewHolder
    public void onVisibilityChanged(boolean isVisible) {
        super.onVisibilityChanged(isVisible);
        if (isVisible) {
            if (this.isExpanded && !this.controller.j()) {
                this.controller.m();
            }
            M(this.isCurrentMute);
        } else if (this.controller.j()) {
            this.controller.l();
        }
        this.isVisibled = isVisible;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.CoverStoryBaseViewHolder
    public void r(float alpha) {
        if (this.isInAutoStatePlaying) {
            I().setAlpha(1.0f);
            this.currentAlpha = 1.0f;
        } else {
            I().setAlpha(alpha);
            this.currentAlpha = alpha;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.CoverStoryBaseViewHolder
    public void s(@NotNull HbSkinState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.s(state);
        this.isExpanded = false;
        QLog.d("CoverStoryVideoViewHolder", 4, "state = " + state);
        int i3 = b.f277287a[state.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        this.isInAutoState = false;
                        this.isInAutoStatePlaying = false;
                        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.autoPlayRunnable);
                        if (this.controller.j()) {
                            this.controller.l();
                        }
                        I().setAlpha(0.0f);
                        return;
                    }
                    return;
                }
                this.isInAutoState = false;
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.autoPlayRunnable);
                if (!this.isInAutoStatePlaying && this.controller.j()) {
                    this.controller.l();
                    return;
                }
                return;
            }
            this.isExpanded = true;
            if (this.isVisibled && !this.controller.j()) {
                this.controller.m();
            }
            M(this.isCurrentMute);
            this.isInAutoState = false;
            this.isInAutoStatePlaying = false;
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.autoPlayRunnable);
            return;
        }
        this.isInAutoState = true;
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.autoPlayRunnable, 2000L);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.CoverStoryBaseViewHolder
    public void t(float scrollOffset, float intermediateOffset, float totalScrollRange) {
        boolean z16;
        super.t(scrollOffset, intermediateOffset, totalScrollRange);
        boolean z17 = true;
        if (scrollOffset == intermediateOffset) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && this.isInAutoState) {
            this.isInAutoState = false;
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.autoPlayRunnable);
        }
        int i3 = (int) (scrollOffset - totalScrollRange);
        this.lastOffset = i3;
        this.itemView.scrollTo(0, i3 / 2);
        if (this.previewImg.getAlpha() != 1.0f) {
            z17 = false;
        }
        if (!z17) {
            this.previewImg.setAlpha(1.0f);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.CoverStoryBaseViewHolder
    public void w(@Nullable HbSkinData hbSkinData, @NotNull HbSkinData.StoryRes storyRes) {
        Intrinsics.checkNotNullParameter(storyRes, "storyRes");
        QLog.d("CoverStoryVideoViewHolder", 4, "setItem");
        I().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CoverStoryVideoViewHolder.L(CoverStoryVideoViewHolder.this, view);
            }
        });
        String videoUrl = storyRes.getVideoUrl();
        if (videoUrl != null) {
            this.controller.q(videoUrl);
        } else {
            QLog.e("CoverStoryVideoViewHolder", 1, "story video url is empty as " + storyRes);
        }
        Uri.Builder appendQueryParameter = Uri.parse(storyRes.getImgUrl()).buildUpon().appendQueryParameter("qyf", "blur");
        URLDrawable netDrawableForQWallet = QWalletPicHelper.getNetDrawableForQWallet(appendQueryParameter.build().toString());
        netDrawableForQWallet.setDecodeHandler(com.tencent.mobileqq.qwallet.utils.b.f279250a.a());
        ((ImageView) I().findViewById(R.id.t6_)).setImageDrawable(netDrawableForQWallet);
        Bundle bundle = new Bundle();
        bundle.putBoolean(VasApngUtil.KEY_PLAY_APNG, false);
        this.previewImg.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(appendQueryParameter.build().toString(), bundle));
        this.itemView.setAlpha(1.0f);
    }
}
