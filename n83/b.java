package n83;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import com.tencent.smtt.utils.Md5Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020\u0002\u00a2\u0006\u0004\b?\u0010@R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010#\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\u0017\u0010&\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u0017\u0010)\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006R\u0017\u00102\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00108\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u0010;\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u00107R\u0017\u0010>\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\u00a8\u0006A"}, d2 = {"Ln83/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "E", "Landroid/view/View;", "l", "()Landroid/view/View;", "cardView", "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "magicStudioItemVideoPreviewContainer", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "G", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "o", "()Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "magicStudioItemBaseVideoView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "u", "()Landroid/widget/TextView;", "magicStudioItemStyleNameView", "I", "w", "magicStudioItemUseCountView", "Lcom/airbnb/lottie/LottieAnimationView;", "J", "Lcom/airbnb/lottie/LottieAnimationView;", "r", "()Lcom/airbnb/lottie/LottieAnimationView;", "magicStudioItemLottieAnimationView", "K", "t", "magicStudioItemNextBtnTextView", "L", ReportConstant.COSTREPORT_PREFIX, "magicStudioItemNextBtnClickArea", "M", "v", "magicStudioItemTopClickView", "N", "p", "magicStudioItemHistoryContainer", "Landroidx/recyclerview/widget/RecyclerView;", "P", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroidx/recyclerview/widget/RecyclerView;", "magicStudioItemHistoryRecyclerView", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", HippyTKDListViewAdapter.X, "()Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "nextBtnBlurView", BdhLogUtil.LogTag.Tag_Req, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "historyBgBlurView", ExifInterface.LATITUDE_SOUTH, "y", "shareBtn", "<init>", "(Landroid/view/View;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View cardView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout magicStudioItemVideoPreviewContainer;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final BaseVideoView magicStudioItemBaseVideoView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView magicStudioItemStyleNameView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView magicStudioItemUseCountView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LottieAnimationView magicStudioItemLottieAnimationView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final TextView magicStudioItemNextBtnTextView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final View magicStudioItemNextBtnClickArea;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final View magicStudioItemTopClickView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final View magicStudioItemHistoryContainer;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final RecyclerView magicStudioItemHistoryRecyclerView;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final QQBlurViewWrapper nextBtnBlurView;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final QQBlurViewWrapper historyBgBlurView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final View shareBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View v3) {
        super(v3);
        float f16;
        float f17;
        Intrinsics.checkNotNullParameter(v3, "v");
        View findViewById = v3.findViewById(R.id.f123167fx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById<View>(R.i\u2026k_magic_studio_item_card)");
        this.cardView = findViewById;
        View findViewById2 = v3.findViewById(R.id.f123267g7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "v.findViewById<FrameLayo\u2026_video_preview_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById2;
        this.magicStudioItemVideoPreviewContainer = frameLayout;
        IBaseVideoView createBaseVideoViewFS = QQVideoViewFactory.createBaseVideoViewFS(this.itemView.getContext(), 153L, null, null);
        Intrinsics.checkNotNull(createBaseVideoViewFS, "null cannot be cast to non-null type com.tencent.mobileqq.videoplatform.view.BaseVideoView");
        BaseVideoView baseVideoView = (BaseVideoView) createBaseVideoViewFS;
        frameLayout.addView(baseVideoView, new FrameLayout.LayoutParams(-1, -1));
        this.magicStudioItemBaseVideoView = baseVideoView;
        View findViewById3 = v3.findViewById(R.id.f123197g0);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "v.findViewById(R.id.wink_magic_studio_item_name)");
        this.magicStudioItemStyleNameView = (TextView) findViewById3;
        View findViewById4 = v3.findViewById(R.id.f123257g6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "v.findViewById(R.id.wink\u2026ic_studio_item_use_count)");
        this.magicStudioItemUseCountView = (TextView) findViewById4;
        View findViewById5 = v3.findViewById(R.id.f123157fw);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById5;
        lottieAnimationView.setAnimationFromUrl("https://downv6.qq.com/shadow_qqcamera/magicstudio/qzone_magicstudio_btn_lottie_animation.zip", Md5Utils.getMD5("https://downv6.qq.com/shadow_qqcamera/magicstudio/qzone_magicstudio_btn_lottie_animation.zip"));
        Intrinsics.checkNotNullExpressionValue(findViewById5, "v.findViewById<LottieAni\u2026)\n            )\n        }");
        this.magicStudioItemLottieAnimationView = lottieAnimationView;
        View findViewById6 = v3.findViewById(R.id.f123227g3);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "v.findViewById(R.id.wink\u2026tudio_item_next_btn_text)");
        this.magicStudioItemNextBtnTextView = (TextView) findViewById6;
        View findViewById7 = v3.findViewById(R.id.f123217g2);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "v.findViewById(R.id.wink\u2026_item_next_btn_container)");
        this.magicStudioItemNextBtnClickArea = findViewById7;
        View findViewById8 = v3.findViewById(R.id.f123247g5);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "v.findViewById(R.id.wink\u2026tudio_item_top_container)");
        this.magicStudioItemTopClickView = findViewById8;
        View findViewById9 = v3.findViewById(R.id.f123177fy);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "v.findViewById(R.id.wink\u2026o_item_history_container)");
        this.magicStudioItemHistoryContainer = findViewById9;
        View findViewById10 = v3.findViewById(R.id.f123187fz);
        RecyclerView recyclerView = (RecyclerView) findViewById10;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        Intrinsics.checkNotNullExpressionValue(findViewById10, "v.findViewById<RecyclerV\u2026IZONTAL, false)\n        }");
        this.magicStudioItemHistoryRecyclerView = recyclerView;
        View findViewById11 = v3.findViewById(R.id.f123207g1);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "v.findViewById<QQBlurVie\u2026_item_next_btn_blur_view)");
        QQBlurViewWrapper qQBlurViewWrapper = (QQBlurViewWrapper) findViewById11;
        this.nextBtnBlurView = qQBlurViewWrapper;
        View findViewById12 = v3.findViewById(R.id.f123127ft);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "v.findViewById<QQBlurVie\u2026istory_item_bg_blur_view)");
        QQBlurViewWrapper qQBlurViewWrapper2 = (QQBlurViewWrapper) findViewById12;
        this.historyBgBlurView = qQBlurViewWrapper2;
        View findViewById13 = v3.findViewById(R.id.f123237g4);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "v.findViewById(R.id.wink\u2026ic_studio_item_share_btn)");
        this.shareBtn = findViewById13;
        c cVar = c.f326233a;
        boolean b16 = cVar.b();
        if (cVar.b()) {
            f16 = ViewUtils.dpToPx(20.0f);
        } else {
            f16 = 0.0f;
        }
        f.a aVar = new f.a(b16, f16, frameLayout, 0, new ColorDrawable(0), Integer.valueOf(R.drawable.m5g));
        aVar.l(true);
        qQBlurViewWrapper.a(aVar);
        qQBlurViewWrapper.setEnableBlur(cVar.b());
        boolean b17 = cVar.b();
        if (cVar.b()) {
            f17 = ViewUtils.dpToPx(20.0f);
        } else {
            f17 = 0.0f;
        }
        f.a aVar2 = new f.a(b17, f17, frameLayout, 0, qQBlurViewWrapper2.getContext().getDrawable(R.drawable.m5f), Integer.valueOf(R.drawable.m5j));
        aVar2.l(true);
        qQBlurViewWrapper2.a(aVar2);
        qQBlurViewWrapper2.setEnableBlur(cVar.b());
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final View getCardView() {
        return this.cardView;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final QQBlurViewWrapper getHistoryBgBlurView() {
        return this.historyBgBlurView;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final BaseVideoView getMagicStudioItemBaseVideoView() {
        return this.magicStudioItemBaseVideoView;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final View getMagicStudioItemHistoryContainer() {
        return this.magicStudioItemHistoryContainer;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final RecyclerView getMagicStudioItemHistoryRecyclerView() {
        return this.magicStudioItemHistoryRecyclerView;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final LottieAnimationView getMagicStudioItemLottieAnimationView() {
        return this.magicStudioItemLottieAnimationView;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final View getMagicStudioItemNextBtnClickArea() {
        return this.magicStudioItemNextBtnClickArea;
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final TextView getMagicStudioItemNextBtnTextView() {
        return this.magicStudioItemNextBtnTextView;
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final TextView getMagicStudioItemStyleNameView() {
        return this.magicStudioItemStyleNameView;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final View getMagicStudioItemTopClickView() {
        return this.magicStudioItemTopClickView;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final TextView getMagicStudioItemUseCountView() {
        return this.magicStudioItemUseCountView;
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final QQBlurViewWrapper getNextBtnBlurView() {
        return this.nextBtnBlurView;
    }

    @NotNull
    /* renamed from: y, reason: from getter */
    public final View getShareBtn() {
        return this.shareBtn;
    }
}
