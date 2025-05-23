package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.beans.QFSMessageLightInteractInfo;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.theme.SkinnableView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00101\u001a\u00020\f\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0014J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010!R\u0016\u0010.\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010!\u00a8\u00064"}, d2 = {"Lcom/tencent/biz/qqcircle/fragments/message/item/QFSUrgeCardItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseLightInteractWidget;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/theme/SkinnableView;", "Landroid/view/View;", "view", "", "m0", "Lcom/tencent/biz/qqcircle/beans/QFSMessageLightInteractInfo;", "info", "n0", "p0", "", "getLayoutId", "", "objData", c.G, "bindData", "v", NodeProps.ON_CLICK, "onThemeChanged", "", "i", "Ljava/lang/String;", "mPublishUrl", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mTvTitle", BdhLogUtil.LogTag.Tag_Conn, "mTvHint", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "mIvCover", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "mLLPublish", "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "mFLBg", "G", "mIvIcon", "H", "mIvMask", "Landroid/content/Context;", "context", "viewType", "<init>", "(Landroid/content/Context;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSUrgeCardItemView extends QCircleBaseLightInteractWidget implements View.OnClickListener, SkinnableView {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mTvHint;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mIvCover;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout mLLPublish;

    /* renamed from: F, reason: from kotlin metadata */
    private FrameLayout mFLBg;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mIvIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView mIvMask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mPublishUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mTvTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSUrgeCardItemView(@NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        m0(this);
    }

    private final void m0(View view) {
        View findViewById = view.findViewById(R.id.f56712lc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qfs_tv_urge_title)");
        this.mTvTitle = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.f56692la);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.qfs_tv_urge_hint)");
        this.mTvHint = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f44661ps);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.qfs_iv_urge_cover)");
        this.mIvCover = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f46291u7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.qfs_ll_urge)");
        this.mLLPublish = (LinearLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.f41891ia);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.qfs_fl_urge)");
        this.mFLBg = (FrameLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.f44671pt);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.qfs_iv_urge_icon)");
        this.mIvIcon = (ImageView) findViewById6;
        View findViewById7 = view.findViewById(R.id.f44451p8);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.qfs_iv_mask)");
        this.mIvMask = (ImageView) findViewById7;
        LinearLayout linearLayout = this.mLLPublish;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLLPublish");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        p0();
    }

    private final void n0(final QFSMessageLightInteractInfo info) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.item.a
            @Override // java.lang.Runnable
            public final void run() {
                QFSUrgeCardItemView.o0(QFSUrgeCardItemView.this, info);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(QFSUrgeCardItemView this$0, QFSMessageLightInteractInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        LinearLayout linearLayout = this$0.mLLPublish;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLLPublish");
            linearLayout = null;
        }
        VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_PUBLISH_BY_REQUEST);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_WAITING_FOR_UPDATE_FANS_NUM, info.getFansReminderNum());
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_STYLE, "top");
        LinearLayout linearLayout3 = this$0.mLLPublish;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLLPublish");
        } else {
            linearLayout2 = linearLayout3;
        }
        VideoReport.setElementParams(linearLayout2, params);
    }

    private final void p0() {
        if (this.mFLBg == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFLBg");
        }
        int d16 = QFSQUIUtilsKt.d(getContext(), R.color.qui_button_bg_primary_default);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{QFSQUIUtilsKt.a(d16, 0.15f), QFSQUIUtilsKt.a(d16, 0.05f)});
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(cx.a(1.0f), QFSQUIUtilsKt.a(d16, 0.15f));
        gradientDrawable.setCornerRadius(cx.a(8.0f));
        FrameLayout frameLayout = this.mFLBg;
        ImageView imageView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFLBg");
            frameLayout = null;
        }
        frameLayout.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{QFSQUIUtilsKt.a(d16, 1.0f), QFSQUIUtilsKt.a(d16, 0.5f)});
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(cx.a(10.0f));
        ImageView imageView2 = this.mIvIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvIcon");
        } else {
            imageView = imageView2;
        }
        imageView.setBackground(gradientDrawable2);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(@Nullable Object objData, int pos) {
        if (objData instanceof QFSMessageLightInteractInfo) {
            QFSMessageLightInteractInfo qFSMessageLightInteractInfo = (QFSMessageLightInteractInfo) objData;
            if (qFSMessageLightInteractInfo.getStUnifiedTagPageData() != null) {
                TextView textView = this.mTvTitle;
                ImageView imageView = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
                    textView = null;
                }
                textView.setText(qFSMessageLightInteractInfo.getStUnifiedTagPageData().title.get());
                TextView textView2 = this.mTvHint;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvHint");
                    textView2 = null;
                }
                textView2.setText(qFSMessageLightInteractInfo.getStUnifiedTagPageData().desc.get());
                Option obtain = Option.obtain();
                ImageView imageView2 = this.mIvCover;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvCover");
                    imageView2 = null;
                }
                Option requestWidth = obtain.setRequestWidth(imageView2.getWidth());
                ImageView imageView3 = this.mIvCover;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvCover");
                    imageView3 = null;
                }
                Option url = requestWidth.setRequestHeight(imageView3.getHeight()).setUrl(qFSMessageLightInteractInfo.getStUnifiedTagPageData().pageIcon.picUrl.get());
                ImageView imageView4 = this.mIvCover;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvCover");
                    imageView4 = null;
                }
                QCircleFeedPicLoader.g().loadImage(url.setTargetView(imageView4));
                this.mPublishUrl = qFSMessageLightInteractInfo.getStUnifiedTagPageData().publishSchema.get();
                Option obtain2 = Option.obtain();
                ImageView imageView5 = this.mIvMask;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvMask");
                    imageView5 = null;
                }
                Option requestWidth2 = obtain2.setRequestWidth(imageView5.getWidth());
                ImageView imageView6 = this.mIvMask;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvMask");
                    imageView6 = null;
                }
                Option url2 = requestWidth2.setRequestHeight(imageView6.getHeight()).setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_cuifa_yingyao_bg_anwen"));
                ImageView imageView7 = this.mIvMask;
                if (imageView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvMask");
                } else {
                    imageView = imageView7;
                }
                QCircleFeedPicLoader.g().loadImage(url2.setTargetView(imageView));
                n0(qFSMessageLightInteractInfo);
            }
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168714gj4;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        boolean z16 = false;
        if (v3 != null && v3.getId() == R.id.f46291u7) {
            z16 = true;
        }
        if (z16) {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.mPublishUrl);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        p0();
    }
}
