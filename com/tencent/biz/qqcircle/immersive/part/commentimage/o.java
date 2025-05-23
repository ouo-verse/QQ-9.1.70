package com.tencent.biz.qqcircle.immersive.part.commentimage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StReply;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00108\u001a\u00020\u000b\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0016\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u0004\u0018\u00010$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010%R\u0016\u0010'\u001a\u0004\u0018\u00010$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u0004\u0018\u00010/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u0004\u0018\u00010$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010%R\u0014\u00107\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106\u00a8\u0006;"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/o;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "B", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "info", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", HippyTKDListViewAdapter.X, "t", "v", "Landroid/view/View;", "view", "", "eid", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "H", BdhLogUtil.LogTag.Tag_Conn, "countStr", "Landroid/text/Spannable;", "E", ReportConstant.COSTREPORT_PREFIX, "J", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/b;", "listener", "I", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/b;", "onOpListener", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "imageInfo", "Lcom/tencent/biz/qqcircle/widgets/multitouchimg/QCircleMultiTouchImageView;", "G", "Lcom/tencent/biz/qqcircle/widgets/multitouchimg/QCircleMultiTouchImageView;", "imageView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "addEmojiIcon", "downloadIcon", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "likeIconView", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "likeNumView", "Landroid/view/ViewGroup;", "L", "Landroid/view/ViewGroup;", "loadingBar", "M", "loadingIcon", "D", "()Ljava/lang/String;", "likeAnimUrl", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class o extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.part.commentimage.b onOpListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QFSCommentImageInfo imageInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private final QCircleMultiTouchImageView imageView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private final ImageView addEmojiIcon;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final ImageView downloadIcon;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final LottieAnimationView likeIconView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private final TextView likeNumView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private final ViewGroup loadingBar;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private final ImageView loadingIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/commentimage/o$a", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
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
                ViewGroup viewGroup2 = o.this.loadingBar;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(0);
                }
            } else if (state == LoadState.STATE_SUCCESS && (viewGroup = o.this.loadingBar) != null) {
                viewGroup.setVisibility(8);
            }
            if (state.isFinishError()) {
                QCircleToast.h(R.string.f184153l4, 0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/commentimage/o$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            o.this.likeIconView.setImageResource(QFSCommentImageInfo.INSTANCE.a());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.imageView = (QCircleMultiTouchImageView) itemView.findViewById(R.id.f357912t);
        this.addEmojiIcon = (ImageView) itemView.findViewById(R.id.f357812s);
        this.downloadIcon = (ImageView) itemView.findViewById(R.id.f357712r);
        this.likeIconView = (LottieAnimationView) itemView.findViewById(R.id.f358012u);
        this.likeNumView = (TextView) itemView.findViewById(R.id.f358112v);
        this.loadingBar = (ViewGroup) itemView.findViewById(R.id.f358412y);
        this.loadingIcon = (ImageView) itemView.findViewById(R.id.f358512z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(o this$0, QFSCommentImageInfo info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        this$0.C(info);
        this$0.H(view, info);
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.e7(info);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void B() {
        Drawable loadingDrawable = LoadingUtil.getLoadingDrawable(this.itemView.getContext(), 2);
        ImageView imageView = this.loadingIcon;
        if (imageView != null) {
            imageView.setImageDrawable(loadingDrawable);
        }
    }

    private final void C(QFSCommentImageInfo info) {
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
            lottieAnimationView4.setAnimationFromUrl(D());
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

    private final String D() {
        return "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_comment_like_lo.json";
    }

    private final Spannable E(String countStr) {
        Character lastOrNull;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(countStr);
        lastOrNull = StringsKt___StringsKt.lastOrNull(countStr);
        if (lastOrNull != null && lastOrNull.charValue() == '\u4e07') {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), countStr.length() - 1, countStr.length(), 17);
        }
        return spannableStringBuilder;
    }

    private final void H(View view, QFSCommentImageInfo info) {
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

    private final void r(View view, String eid) {
        if (view != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            VideoReport.setElementId(view, eid);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        }
    }

    private final void t() {
        ImageView imageView = this.downloadIcon;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.u(o.this, view);
                }
            });
        }
        r(this.downloadIcon, "em_xsj_save_button");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.onSave();
        }
        VideoReport.reportEvent("clck", view, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v() {
        ImageView imageView = this.addEmojiIcon;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.w(o.this, view);
                }
            });
        }
        r(this.addEmojiIcon, QCircleDaTongConstant.ElementId.EM_XSJ_ADD_EMOJI_BUTTON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.l7();
        }
        VideoReport.reportEvent("clck", view, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x(QFSCommentImageInfo info, Drawable loadingDrawable) {
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
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setTargetView(this.imageView).setFailDrawable(com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.naw)).setLoadingDrawable(loadingDrawable).setRequestWidth(cx.g()).setRequestHeight(cx.f()).setGroupKey(libraGroupKey), new a());
        QCircleMultiTouchImageView qCircleMultiTouchImageView = this.imageView;
        if (qCircleMultiTouchImageView != null) {
            qCircleMultiTouchImageView.setOnViewTapListener(new com.tencent.biz.qqcircle.widgets.multitouchimg.o() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.l
                @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.o
                public final void onViewTap(View view, float f16, float f17) {
                    o.y(o.this, view, f16, f17);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(o this$0, View view, float f16, float f17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.part.commentimage.b bVar = this$0.onOpListener;
        if (bVar != null) {
            bVar.B6();
        }
    }

    private final void z(final QFSCommentImageInfo info) {
        LottieAnimationView lottieAnimationView = this.likeIconView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setImageResource(info.o());
        }
        LottieAnimationView lottieAnimationView2 = this.likeIconView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.A(o.this, info, view);
                }
            });
        }
        String countStr = com.tencent.biz.qqcircle.immersive.utils.r.f(info.n());
        TextView textView = this.likeNumView;
        if (textView != null) {
            Intrinsics.checkNotNullExpressionValue(countStr, "countStr");
            textView.setText(E(countStr));
        }
    }

    public final void I(@Nullable com.tencent.biz.qqcircle.immersive.part.commentimage.b listener) {
        this.onOpListener = listener;
    }

    public final void J() {
        QFSCommentImageInfo qFSCommentImageInfo = this.imageInfo;
        if (qFSCommentImageInfo != null) {
            z(qFSCommentImageInfo);
        }
    }

    public final void s(@NotNull QFSCommentImageInfo info, @NotNull Drawable loadingDrawable) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(loadingDrawable, "loadingDrawable");
        B();
        z(info);
        x(info, loadingDrawable);
        t();
        v();
    }
}
