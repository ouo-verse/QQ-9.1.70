package com.tencent.biz.qqcircle.immersive.personal.part;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalHintViewChangeEvent;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\b\u0010\f\u001a\u00020\u0004H\u0014J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010\"R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/part/QFSPersonalFeedUrgeCardFrameLayout;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Ljava/util/Objects;", "Landroid/view/View$OnClickListener;", "", "o0", "q0", "n0", "initView", "Lcom/tencent/biz/qqcircle/immersive/personal/data/w;", "userInfoData", "l0", NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "m0", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mFeedUrgeCardLinearLayout", "e", "Lcom/tencent/biz/qqcircle/immersive/personal/data/w;", "mUserInfoData", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "mFeedUrgeBtnLL", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mUrgeTextView", "Lcom/tencent/biz/qqcircle/widgets/QFSPagAnimView;", "i", "Lcom/tencent/biz/qqcircle/widgets/QFSPagAnimView;", "mPAGView", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mIvQCircleIconView", BdhLogUtil.LogTag.Tag_Conn, "mTvHint", "", "D", "Z", "mIsUrged", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalFeedUrgeCardFrameLayout extends QCircleBaseWidgetView<Objects> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mTvHint;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsUrged;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mFeedUrgeCardLinearLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.data.w mUserInfoData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mFeedUrgeBtnLL;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mUrgeTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QFSPagAnimView mPAGView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvQCircleIconView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalFeedUrgeCardFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    private final void n0() {
        com.tencent.biz.qqcircle.immersive.personal.request.b.r(this.mUserInfoData, 2);
    }

    private final void o0() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.t
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalFeedUrgeCardFrameLayout.p0(QFSPersonalFeedUrgeCardFrameLayout.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(QFSPersonalFeedUrgeCardFrameLayout this$0) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout linearLayout = this$0.mFeedUrgeBtnLL;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedUrgeBtnLL");
            linearLayout = null;
        }
        VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_INVITE_WORK_BUTTON);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        if (this$0.mIsUrged) {
            str = QCircleDaTongConstant.ElementParamValue.INVITED;
        } else {
            str = QCircleDaTongConstant.ElementParamValue.TO_INVITE;
        }
        params.put("xsj_status", str);
        LinearLayout linearLayout3 = this$0.mFeedUrgeBtnLL;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedUrgeBtnLL");
        } else {
            linearLayout2 = linearLayout3;
        }
        VideoReport.setElementParams(linearLayout2, params);
    }

    private final void q0() {
        if (this.mFeedUrgeCardLinearLayout == null) {
            return;
        }
        int d16 = QFSQUIUtilsKt.d(getContext(), R.color.qui_button_bg_primary_default);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{QFSQUIUtilsKt.a(d16, 0.05f), QFSQUIUtilsKt.a(d16, 0.15f)});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(cx.a(8.0f));
        gradientDrawable.setStroke(cx.a(1.0f), QFSQUIUtilsKt.a(d16, 0.15f));
        FrameLayout frameLayout = this.mFeedUrgeCardLinearLayout;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{QFSQUIUtilsKt.a(d16, 1.0f), QFSQUIUtilsKt.a(d16, 0.5f)});
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(cx.a(21.0f));
        QFSPagAnimView qFSPagAnimView = this.mPAGView;
        if (qFSPagAnimView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPAGView");
            qFSPagAnimView = null;
        }
        qFSPagAnimView.setBackground(gradientDrawable2);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gm9;
    }

    public final void initView() {
        this.mFeedUrgeCardLinearLayout = (FrameLayout) findViewById(R.id.f488020z);
        View findViewById = findViewById(R.id.f46291u7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_ll_urge)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.mFeedUrgeBtnLL = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedUrgeBtnLL");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        View findViewById2 = findViewById(R.id.f56682l_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_tv_urge)");
        this.mUrgeTextView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f44671pt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_iv_urge_icon)");
        this.mPAGView = (QFSPagAnimView) findViewById3;
        View findViewById4 = findViewById(R.id.f348510_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_circle_icon)");
        this.mIvQCircleIconView = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.f56692la);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qfs_tv_urge_hint)");
        this.mTvHint = (TextView) findViewById5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v14, types: [android.widget.LinearLayout] */
    public final void l0(@Nullable com.tencent.biz.qqcircle.immersive.personal.data.w userInfoData) {
        if (userInfoData != null && userInfoData.n()) {
            this.mUserInfoData = userInfoData;
            SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalHintViewChangeEvent(1));
            q0();
            Option obtain = Option.obtain();
            ImageView imageView = this.mIvQCircleIconView;
            TextView textView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvQCircleIconView");
                imageView = null;
            }
            Option requestWidth = obtain.setRequestWidth(imageView.getWidth());
            ImageView imageView2 = this.mIvQCircleIconView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvQCircleIconView");
                imageView2 = null;
            }
            Option loadingDrawable = requestWidth.setRequestHeight(imageView2.getHeight()).setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_cuifa_bg_anwen")).setLoadingDrawable(new ColorDrawable(0));
            ImageView imageView3 = this.mIvQCircleIconView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvQCircleIconView");
                imageView3 = null;
            }
            QCircleFeedPicLoader.g().loadImage(loadingDrawable.setTargetView(imageView3));
            int i3 = userInfoData.e().urgeStatus.get();
            if (i3 != 0 && i3 != 1) {
                if (i3 == 2) {
                    TextView textView2 = this.mUrgeTextView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mUrgeTextView");
                        textView2 = null;
                    }
                    textView2.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194014ar));
                    TextView textView3 = this.mTvHint;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTvHint");
                        textView3 = null;
                    }
                    textView3.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194044au));
                    ?? r75 = this.mFeedUrgeBtnLL;
                    if (r75 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFeedUrgeBtnLL");
                    } else {
                        textView = r75;
                    }
                    textView.setAlpha(0.5f);
                    this.mIsUrged = true;
                }
            } else {
                TextView textView4 = this.mUrgeTextView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUrgeTextView");
                    textView4 = null;
                }
                textView4.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194024as));
                TextView textView5 = this.mTvHint;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvHint");
                } else {
                    textView = textView5;
                }
                textView.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194034at));
                this.mIsUrged = false;
            }
            o0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QFSPagAnimView qFSPagAnimView = this.mPAGView;
        QFSPagAnimView qFSPagAnimView2 = null;
        if (qFSPagAnimView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPAGView");
            qFSPagAnimView = null;
        }
        qFSPagAnimView.setRepeatTimes(Integer.MAX_VALUE);
        QFSPagAnimView qFSPagAnimView3 = this.mPAGView;
        if (qFSPagAnimView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPAGView");
        } else {
            qFSPagAnimView2 = qFSPagAnimView3;
        }
        qFSPagAnimView2.M(QCircleSkinHelper.getInstance().getUrl("qvideo_cuifa_icon_dt"));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        LinearLayout linearLayout = this.mFeedUrgeBtnLL;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedUrgeBtnLL");
            linearLayout = null;
        }
        linearLayout.setAlpha(0.5f);
        n0();
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(@Nullable Objects objData, int pos) {
    }
}
