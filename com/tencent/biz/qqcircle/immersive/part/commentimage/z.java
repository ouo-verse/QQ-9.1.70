package com.tencent.biz.qqcircle.immersive.part.commentimage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.events.QFSCommentEmotionRedPointEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.an;
import com.tencent.biz.qqcircle.utils.cm;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0016\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0002R$\u0010)\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0004\u0018\u0001058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u0004\u0018\u00010=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010;R\u0016\u0010B\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010;R\u0016\u0010D\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010;R\u0016\u0010G\u001a\u0004\u0018\u00010E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010FR\u0016\u0010K\u001a\u0004\u0018\u00010H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u0004\u0018\u00010L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010MR\u0016\u0010P\u001a\u0004\u0018\u00010E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010FR\u0016\u0010R\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010;R\u0016\u0010U\u001a\u0004\u0018\u00010S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010TR\u0016\u0010W\u001a\u0004\u0018\u00010S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010TR\u0016\u0010X\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010;R\u0016\u0010Z\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010;R\u0014\u0010]\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b[\u0010\\\u00a8\u0006`"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/z;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", BdhLogUtil.LogTag.Tag_Req, "O", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "info", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "B", "L", "E", "P", "y", "", "content", "avatar", "", "U", "M", "Landroid/view/View;", "view", "b0", "W", "countStr", "Landroid/text/Spannable;", "a0", HippyTKDListViewAdapter.X, "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/b;", "listener", "c0", "f0", "e0", "drawable", "d0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "Y", "()Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "setImageInfo", "(Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;)V", "imageInfo", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/d;", "avatarLoader", "G", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/b;", "onOpListener", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "H", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "refOpListener", "Lcom/tencent/biz/qqcircle/widgets/multitouchimg/QCircleMultiTouchImageView;", "I", "Lcom/tencent/biz/qqcircle/widgets/multitouchimg/QCircleMultiTouchImageView;", "imageView", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "labelView", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "K", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "inputTextView", "inputAtIcon", "inputEmojiIcon", "N", "inputImageIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "postPicView", "Lcom/tencent/biz/qqcircle/widgets/QFSExpandableAsyncTextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/biz/qqcircle/widgets/QFSExpandableAsyncTextView;", "descTextView", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "likeIconView", ExifInterface.LATITUDE_SOUTH, "likeNumView", "T", "quitScaleView", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "inputBar", "V", "loadingBar", "loadingIcon", "X", "emojiRedDot", "Z", "()Ljava/lang/String;", "likeAnimUrl", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class z extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QFSCommentImageInfo imageInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private d avatarLoader;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.part.commentimage.b onOpListener;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.meta.refresh.c<com.tencent.biz.qqcircle.immersive.part.commentimage.b> refOpListener;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final QCircleMultiTouchImageView imageView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final ImageView labelView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private final QCircleAsyncTextView inputTextView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private final ImageView inputAtIcon;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private final ImageView inputEmojiIcon;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private final ImageView inputImageIcon;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private final TextView postPicView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private final QFSExpandableAsyncTextView descTextView;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private final LottieAnimationView likeIconView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private final TextView likeNumView;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private final ImageView quitScaleView;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private final ViewGroup inputBar;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private final ViewGroup loadingBar;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private final ImageView loadingIcon;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private final ImageView emojiRedDot;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/commentimage/z$a", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            ViewGroup viewGroup;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state == LoadState.STATE_DOWNLOADING) {
                ViewGroup viewGroup2 = z.this.loadingBar;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(0);
                }
            } else if (state == LoadState.STATE_SUCCESS && (viewGroup = z.this.loadingBar) != null) {
                viewGroup.setVisibility(8);
            }
            if (state.isFinishError()) {
                QCircleToast.h(R.string.f184153l4, 0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/commentimage/z$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            z.this.likeIconView.setImageResource(QFSCommentImageInfo.INSTANCE.a());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.imageView = (QCircleMultiTouchImageView) this.itemView.findViewById(R.id.f356912j);
        this.labelView = (ImageView) this.itemView.findViewById(R.id.f357512p);
        this.inputTextView = (QCircleAsyncTextView) this.itemView.findViewById(R.id.f357612q);
        this.inputAtIcon = (ImageView) this.itemView.findViewById(R.id.f357012k);
        this.inputEmojiIcon = (ImageView) this.itemView.findViewById(R.id.f357212m);
        this.inputImageIcon = (ImageView) this.itemView.findViewById(R.id.f357412o);
        this.postPicView = (TextView) this.itemView.findViewById(R.id.f3586130);
        this.descTextView = (QFSExpandableAsyncTextView) this.itemView.findViewById(R.id.f356812i);
        this.likeIconView = (LottieAnimationView) this.itemView.findViewById(R.id.f358212w);
        this.likeNumView = (TextView) this.itemView.findViewById(R.id.f358312x);
        this.quitScaleView = (ImageView) this.itemView.findViewById(R.id.f3587131);
        this.inputBar = (ViewGroup) this.itemView.findViewById(R.id.f357112l);
        this.loadingBar = (ViewGroup) this.itemView.findViewById(R.id.f358412y);
        this.loadingIcon = (ImageView) this.itemView.findViewById(R.id.f358512z);
        this.emojiRedDot = (ImageView) this.itemView.findViewById(R.id.f357312n);
    }

    private final void B(QFSCommentImageInfo info, Drawable loadingDrawable) {
        String str;
        PBStringField pBStringField;
        FeedCloudMeta$StImage stImage = info.getStImage();
        if (stImage != null && (pBStringField = stImage.picUrl) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        LibraGroupKey libraGroupKey = new LibraGroupKey(str);
        libraGroupKey.setCacheStrategy(LibraGroupKey.CacheStrategy.HIGHEST);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setTargetView(this.imageView).setFailDrawable(com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.naw)).setLoadingDrawable(loadingDrawable).setRequestWidth(cx.g()).setRequestHeight(cx.f() - cx.a(56.0f)).setGroupKey(libraGroupKey), new a());
        QCircleMultiTouchImageView qCircleMultiTouchImageView = this.imageView;
        if (qCircleMultiTouchImageView != null) {
            qCircleMultiTouchImageView.setOnScaleChangeListener(new com.tencent.biz.qqcircle.widgets.multitouchimg.k() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.t
                @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.k
                public final void a(float f16, float f17, float f18, float f19) {
                    z.C(z.this, f16, f17, f18, f19);
                }
            });
        }
        QCircleMultiTouchImageView qCircleMultiTouchImageView2 = this.imageView;
        if (qCircleMultiTouchImageView2 != null) {
            qCircleMultiTouchImageView2.setOnViewTapListener(new com.tencent.biz.qqcircle.widgets.multitouchimg.o() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.u
                @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.o
                public final void onViewTap(View view, float f16, float f17) {
                    z.D(z.this, view, f16, f17);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(z this$0, float f16, float f17, float f18, float f19) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (f19 - 1.0f > 0.05f) {
            this$0.imageView.setAllowParentInterceptOnEdge(false);
            ImageView imageView = this$0.quitScaleView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ViewGroup viewGroup = this$0.inputBar;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            TextView textView = this$0.likeNumView;
            if (textView != null) {
                textView.setVisibility(8);
            }
            LottieAnimationView lottieAnimationView = this$0.likeIconView;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(8);
            }
            TextView textView2 = this$0.postPicView;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            QFSExpandableAsyncTextView qFSExpandableAsyncTextView = this$0.descTextView;
            if (qFSExpandableAsyncTextView != null) {
                qFSExpandableAsyncTextView.setVisibility(8);
            }
            ImageView imageView2 = this$0.labelView;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                return;
            }
            return;
        }
        this$0.imageView.setAllowParentInterceptOnEdge(true);
        ImageView imageView3 = this$0.quitScaleView;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        ViewGroup viewGroup2 = this$0.inputBar;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        TextView textView3 = this$0.likeNumView;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView2 = this$0.likeIconView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
        }
        TextView textView4 = this$0.postPicView;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView2 = this$0.descTextView;
        if (qFSExpandableAsyncTextView2 != null) {
            qFSExpandableAsyncTextView2.setVisibility(0);
        }
        this$0.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(z this$0, View view, float f16, float f17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.B6();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void E(QFSCommentImageInfo info) {
        String str;
        boolean z16;
        boolean isBlank;
        an E = QFSCommentHelper.L().E(info.j(), info.getStComment(), info.getStReply());
        if (E != null) {
            str = E.f();
            if (!TextUtils.isEmpty(E.e())) {
                str = ((Object) str) + QCircleApplication.APP.getResources().getString(R.string.image);
            }
            if (!TextUtils.isEmpty(E.d())) {
                str = ((Object) str) + QCircleApplication.APP.getResources().getString(R.string.f182983hy);
            }
        } else {
            str = null;
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.inputTextView;
        if (qCircleAsyncTextView != null) {
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        str = info.m();
                    }
                    qCircleAsyncTextView.setText(str);
                }
            }
            z16 = true;
            if (z16) {
            }
            qCircleAsyncTextView.setText(str);
        }
        QCircleAsyncTextView qCircleAsyncTextView2 = this.inputTextView;
        if (qCircleAsyncTextView2 != null) {
            qCircleAsyncTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.J(z.this, view);
                }
            });
        }
        ImageView imageView = this.inputAtIcon;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.K(z.this, view);
                }
            });
        }
        ImageView imageView2 = this.inputAtIcon;
        if (imageView2 != null) {
            VideoReport.setElementId(imageView2, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_A_ITEM);
            VideoReport.setElementClickPolicy(imageView2, ClickPolicy.REPORT_NONE);
        }
        ImageView imageView3 = this.inputEmojiIcon;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.H(z.this, view);
                }
            });
        }
        ImageView imageView4 = this.inputImageIcon;
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.I(z.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(z this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ud2.a.f438849a.g();
        ImageView imageView = this$0.emojiRedDot;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.d3(2);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSCommentEmotionRedPointEvent());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(z this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.d3(3);
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CMTBOX_VIDEO_ICON);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_UI_MODULE, "image");
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view, params);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(z this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.d3(0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(z this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.d3(1);
        }
        VideoReport.reportEvent("clck", view, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L() {
        FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
        if (m3.is_e_da_xia.get()) {
            cm.c(this.labelView, m3);
            return;
        }
        if (m3.label.get() == 1) {
            cm.d(null, this.labelView, m3);
            return;
        }
        ImageView imageView = this.labelView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private final void M(final QFSCommentImageInfo info) {
        LottieAnimationView lottieAnimationView = this.likeIconView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setImageResource(info.o());
        }
        LottieAnimationView lottieAnimationView2 = this.likeIconView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.N(z.this, info, view);
                }
            });
        }
        String countStr = com.tencent.biz.qqcircle.immersive.utils.r.f(info.n());
        TextView textView = this.likeNumView;
        if (textView != null) {
            Intrinsics.checkNotNullExpressionValue(countStr, "countStr");
            textView.setText(a0(countStr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(z this$0, QFSCommentImageInfo info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        this$0.W(info);
        this$0.b0(view, info);
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.e7(info);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O() {
        Drawable loadingDrawable = LoadingUtil.getLoadingDrawable(this.itemView.getContext(), 2);
        ImageView imageView = this.loadingIcon;
        if (imageView != null) {
            imageView.setImageDrawable(loadingDrawable);
        }
    }

    private final void P() {
        Drawable drawable = this.itemView.getContext().getDrawable(R.drawable.qui_add_icon_white);
        int a16 = cx.a(12.0f);
        if (drawable != null) {
            drawable.setBounds(0, 0, a16, a16);
        }
        TextView textView = this.postPicView;
        if (textView != null) {
            textView.setCompoundDrawables(drawable, null, null, null);
        }
        TextView textView2 = this.postPicView;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.Q(z.this, view);
                }
            });
        }
        TextView textView3 = this.postPicView;
        if (textView3 != null) {
            VideoReport.setElementId(textView3, QCircleDaTongConstant.ElementId.EM_XSJ_SEND_PICTURES_BUTTON);
            VideoReport.setElementClickPolicy(textView3, ClickPolicy.REPORT_NONE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(z this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.c8();
        }
        VideoReport.reportEvent("clck", view, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R() {
        ImageView imageView = this.quitScaleView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.T(z.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(z this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleMultiTouchImageView qCircleMultiTouchImageView = this$0.imageView;
        if (qCircleMultiTouchImageView != null) {
            qCircleMultiTouchImageView.setScale(1.0f, true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final CharSequence U(String content, Drawable avatar) {
        String str;
        boolean isBlank;
        String str2;
        QFSCommentImageInfo qFSCommentImageInfo = this.imageInfo;
        if (qFSCommentImageInfo == null || (str = qFSCommentImageInfo.p()) == null) {
            str = "";
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(content);
        if (!isBlank) {
            str2 = str + "\uff1a" + content;
        } else {
            str2 = str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int a16 = cx.a(20.0f);
        int a17 = cx.a(6.0f);
        if (avatar != null) {
            avatar.setBounds(0, 0, a16, a16);
        }
        QCircleAsyncTextView.f(spannableStringBuilder, 0, avatar, 0, a17);
        spannableStringBuilder.setSpan(new com.tencent.biz.qqcircle.immersive.part.commentimage.a(this.refOpListener, this.imageInfo), 0, str.length() + 1, 33);
        return spannableStringBuilder;
    }

    private final void W(QFSCommentImageInfo info) {
        long n3 = info.n();
        if (info.u()) {
            LottieAnimationView lottieAnimationView = this.likeIconView;
            if (lottieAnimationView != null) {
                lottieAnimationView.cancelAnimation();
            }
            LottieAnimationView lottieAnimationView2 = this.likeIconView;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setImageResource(QFSCommentImageInfo.INSTANCE.b());
            }
            TextView textView = this.likeNumView;
            if (textView != null) {
                textView.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(n3 - 1));
                return;
            }
            return;
        }
        LottieAnimationView lottieAnimationView3 = this.likeIconView;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.addAnimatorListener(new b());
        }
        LottieAnimationView lottieAnimationView4 = this.likeIconView;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.setAnimationFromUrl(Z());
        }
        LottieAnimationView lottieAnimationView5 = this.likeIconView;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.playAnimation();
        }
        TextView textView2 = this.likeNumView;
        if (textView2 != null) {
            textView2.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(n3 + 1));
        }
    }

    private final String Z() {
        return "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_comment_like_lo.json";
    }

    private final Spannable a0(String countStr) {
        Character lastOrNull;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(countStr);
        lastOrNull = StringsKt___StringsKt.lastOrNull(countStr);
        if (lastOrNull != null && lastOrNull.charValue() == '\u4e07') {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(11, true), countStr.length() - 1, countStr.length(), 17);
        }
        return spannableStringBuilder;
    }

    private final void b0(View view, QFSCommentImageInfo info) {
        String str;
        String str2;
        PBStringField pBStringField;
        if (view != null) {
            Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
            if (info.u()) {
                str = "cancel";
            } else {
                str = "like";
            }
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("xsj_action_type", str);
            params.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_ID, info.getStComment().f398447id.get());
            FeedCloudMeta$StReply stReply = info.getStReply();
            if (stReply != null && (pBStringField = stReply.f398460id) != null) {
                str2 = pBStringField.get();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "info.stReply?.id?.get() ?: \"\"");
            }
            params.put(QCircleDaTongConstant.ElementParamKey.XSJ_REPLY_ID, str2);
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_LIKE_CMT_BUTTON);
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_CMTREPLY_LIKE_ACTION, view, params);
        }
    }

    private final void y(QFSCommentImageInfo info) {
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView = this.descTextView;
        if (qFSExpandableAsyncTextView != null) {
            qFSExpandableAsyncTextView.setText("");
        }
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView2 = this.descTextView;
        if (qFSExpandableAsyncTextView2 != null) {
            qFSExpandableAsyncTextView2.setExactWidth(cx.g() - cx.a(90.0f));
            qFSExpandableAsyncTextView2.setNeedSpecialAreaBold(true);
            qFSExpandableAsyncTextView2.setSpecialClickAreaColor(R.color.f158017al3);
            qFSExpandableAsyncTextView2.setExpandTextColor(R.color.f158017al3);
            qFSExpandableAsyncTextView2.setCollapseTextColor(R.color.f158017al3);
            qFSExpandableAsyncTextView2.setText(U(info.g(), RFWApplication.getApplication().getDrawable(R.drawable.f160830com)));
            qFSExpandableAsyncTextView2.setVisibility(0);
            qFSExpandableAsyncTextView2.setOnClickAtTextListener(new RFWAsyncRichTextView.OnClickAtTextListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.x
                @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
                public final void onClick(String str) {
                    z.z(z.this, str);
                }
            });
        }
        d dVar = new d(this, info.l());
        this.avatarLoader = dVar;
        dVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(z this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(str);
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.L5(feedCloudMeta$StUser);
        }
    }

    public final void A() {
        if (ud2.a.f438849a.b()) {
            ImageView imageView = this.emojiRedDot;
            if (imageView != null) {
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        ImageView imageView2 = this.emojiRedDot;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    @Nullable
    /* renamed from: Y, reason: from getter */
    public final QFSCommentImageInfo getImageInfo() {
        return this.imageInfo;
    }

    public final void c0(@Nullable com.tencent.biz.qqcircle.immersive.part.commentimage.b listener) {
        this.onOpListener = listener;
        if (listener == null) {
            this.refOpListener = null;
        } else {
            this.refOpListener = new com.tencent.qqnt.avatar.meta.refresh.c<>(listener);
        }
    }

    public final void d0(@NotNull Drawable drawable) {
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        QFSCommentImageInfo qFSCommentImageInfo = this.imageInfo;
        if (qFSCommentImageInfo != null && (qFSExpandableAsyncTextView = this.descTextView) != null) {
            qFSExpandableAsyncTextView.setText(U(qFSCommentImageInfo.g(), drawable));
        }
    }

    public final void e0() {
        QFSCommentImageInfo qFSCommentImageInfo = this.imageInfo;
        if (qFSCommentImageInfo != null) {
            E(qFSCommentImageInfo);
        }
    }

    public final void f0() {
        QFSCommentImageInfo qFSCommentImageInfo = this.imageInfo;
        if (qFSCommentImageInfo != null) {
            M(qFSCommentImageInfo);
        }
    }

    public final void x(@NotNull QFSCommentImageInfo info, @NotNull Drawable loadingDrawable) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(loadingDrawable, "loadingDrawable");
        this.imageInfo = info;
        d dVar = this.avatarLoader;
        if (dVar != null) {
            dVar.d();
        }
        O();
        B(info, loadingDrawable);
        R();
        L();
        E(info);
        P();
        y(info);
        M(info);
        A();
    }
}
