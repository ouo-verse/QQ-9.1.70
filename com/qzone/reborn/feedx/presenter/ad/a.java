package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.util.ad.QZoneAdStyleManager;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.util.ar;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u0003*\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0014J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR(\u0010!\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001dj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010&\u00a8\u00066"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/a;", "Lvg/a;", "Landroid/view/View$OnClickListener;", "", "I", "Landroid/widget/TextView;", "", "text", "K", "", "index", "", "isShowTextAndLabel", "J", "k", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "v", NodeProps.ON_CLICK, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mAdBottomLeftText", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "G", "Ljava/util/ArrayList;", "mAdBottomLabelList", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "mAdBottomLabelLayout", "Landroid/widget/TextView;", "mAdBottomLabel1", "mAdBottomLabel2", "mAdBottomLabel3", "L", "mVisitLayout", "Landroid/widget/ImageView;", "M", "Landroid/widget/ImageView;", "mIconVisitCount", "N", "mAttachVisitCount", "<init>", "()V", "P", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends vg.a implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneRichTextView mAdBottomLeftText;

    /* renamed from: G, reason: from kotlin metadata */
    private final ArrayList<TextView> mAdBottomLabelList = new ArrayList<>();

    /* renamed from: H, reason: from kotlin metadata */
    private LinearLayout mAdBottomLabelLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mAdBottomLabel1;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mAdBottomLabel2;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView mAdBottomLabel3;

    /* renamed from: L, reason: from kotlin metadata */
    private LinearLayout mVisitLayout;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView mIconVisitCount;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView mAttachVisitCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/a$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f55437e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f55438f;

        b(String str, float f16) {
            this.f55437e = str;
            this.f55438f = f16;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            QZoneRichTextView qZoneRichTextView = a.this.mAdBottomLeftText;
            if (qZoneRichTextView != null && (viewTreeObserver = qZoneRichTextView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            if (qZoneAdFeedUtils.w().containsKey(this.f55437e)) {
                return;
            }
            if (this.f55438f > (a.this.mAdBottomLeftText != null ? r2.getWidth() : 0)) {
                QZoneRichTextView qZoneRichTextView2 = a.this.mAdBottomLeftText;
                if (qZoneRichTextView2 != null) {
                    qZoneRichTextView2.setVisibility(8);
                }
                qZoneAdFeedUtils.w().put(this.f55437e, Boolean.FALSE);
                return;
            }
            QZoneRichTextView qZoneRichTextView3 = a.this.mAdBottomLeftText;
            if (qZoneRichTextView3 != null) {
                qZoneRichTextView3.setVisibility(0);
            }
            qZoneAdFeedUtils.w().put(this.f55437e, Boolean.TRUE);
        }
    }

    private final void I() {
        int nextInt;
        if (QZoneAdFeedUtils.f55717a.i(this.f441565h)) {
            LinearLayout linearLayout = this.mVisitLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            QZoneAdFeedData adData = this.f441565h.getAdData();
            if (this.f441565h.getAdData().getVisitCount() != 0) {
                nextInt = this.f441565h.getAdData().getVisitCount();
            } else {
                nextInt = Random.INSTANCE.nextInt(50, 100);
            }
            adData.setVisitCount(nextInt);
            TextView textView = this.mAttachVisitCount;
            if (textView != null) {
                textView.setText("\u6d4f\u89c8" + this.f441565h.getAdData().getVisitCount() + "\u6b21");
            }
            com.tencent.mobileqq.qzone.picload.c.a().j(this.mIconVisitCount, new c.C8489c().h("qui_eye_on").e(R.color.qui_common_text_secondary));
            return;
        }
        LinearLayout linearLayout2 = this.mVisitLayout;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setVisibility(8);
    }

    @Override // vg.a
    protected void C(View containerView) {
        this.mAdBottomLeftText = (QZoneRichTextView) this.f441562d.findViewById(R.id.mly);
        this.mAdBottomLabelLayout = (LinearLayout) this.f441562d.findViewById(R.id.mlw);
        this.mAdBottomLabelList.clear();
        this.mAdBottomLabel1 = (TextView) this.f441562d.findViewById(R.id.mlt);
        this.mAdBottomLabel2 = (TextView) this.f441562d.findViewById(R.id.mlu);
        this.mAdBottomLabel3 = (TextView) this.f441562d.findViewById(R.id.mlv);
        GdtUIUtils.setViewRadius(this.mAdBottomLabel1, 2.0f);
        GdtUIUtils.setViewRadius(this.mAdBottomLabel2, 2.0f);
        GdtUIUtils.setViewRadius(this.mAdBottomLabel3, 2.0f);
        this.mAdBottomLabelList.add(this.mAdBottomLabel1);
        this.mAdBottomLabelList.add(this.mAdBottomLabel2);
        this.mAdBottomLabelList.add(this.mAdBottomLabel3);
        this.mVisitLayout = (LinearLayout) this.f441562d.findViewById(R.id.mma);
        this.mAttachVisitCount = (TextView) this.f441562d.findViewById(R.id.mm_);
        this.mIconVisitCount = (ImageView) this.f441562d.findViewById(R.id.mm9);
        QZoneRichTextView qZoneRichTextView = this.mAdBottomLeftText;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setOnClickListener(this);
        }
        LinearLayout linearLayout = this.mAdBottomLabelLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        for (TextView textView : this.mAdBottomLabelList) {
            if (textView != null) {
                textView.setOnClickListener(this);
            }
        }
        if (containerView != null) {
            int color = containerView.getResources().getColor(R.color.qui_common_text_secondary);
            QZoneRichTextView qZoneRichTextView2 = this.mAdBottomLeftText;
            if (qZoneRichTextView2 != null) {
                qZoneRichTextView2.setTextColor(color);
            }
            TextView textView2 = this.mAdBottomLabel1;
            if (textView2 != null) {
                textView2.setTextColor(color);
            }
            TextView textView3 = this.mAdBottomLabel2;
            if (textView3 != null) {
                textView3.setTextColor(color);
            }
            TextView textView4 = this.mAdBottomLabel3;
            if (textView4 != null) {
                textView4.setTextColor(color);
            }
            TextView textView5 = this.mAttachVisitCount;
            if (textView5 != null) {
                textView5.setTextColor(color);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdFeedBottomLeftPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int i3;
        int i16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            FeedElement feedElement = FeedElement.RECOMM_ACTION_LEFT_TEXT;
            switch (v3.getId()) {
                case R.id.mlt /* 1745224412 */:
                case R.id.mlu /* 1745224413 */:
                case R.id.mlv /* 1745224414 */:
                    if (QZoneAdFeedDataExtKt.isHitLeftTextAndLabelExp(this.f441565h)) {
                        i3 = 10071;
                        break;
                    }
                    i16 = 7;
                    break;
                case R.id.mlw /* 1745224415 */:
                case R.id.mlx /* 1745224416 */:
                default:
                    i3 = 1000;
                    break;
                case R.id.mly /* 1745224417 */:
                    if (QZoneAdFeedDataExtKt.isHitLeftTextAndLabelExp(this.f441565h)) {
                        i3 = 10072;
                        break;
                    }
                    i16 = 7;
                    break;
            }
            i16 = i3;
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            Activity mActivity = this.C;
            Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
            BusinessFeedData mFeedData = this.f441565h;
            Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
            qZoneAdFeedUtils.H(mActivity, v3, mFeedData, feedElement, i16, this.f441567m, null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmk;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private final void J(TextView textView, int i3, boolean z16) {
        if (!z16) {
            Activity activity = this.C;
            if (activity != null) {
                textView.setBackgroundColor(activity.getColor(R.color.qui_common_fill_standard_primary));
                textView.setTextColor(activity.getColor(R.color.qui_common_text_secondary));
                return;
            }
            return;
        }
        textView.setBackgroundColor(Color.parseColor("#1A0099FF"));
        textView.setTextColor(Color.parseColor("#0099FF"));
    }

    private final void K(TextView textView, String str) {
        if (str == null || str.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        ViewTreeObserver viewTreeObserver;
        String str;
        if (feedData == null) {
            return;
        }
        View view = this.f441562d;
        ViewGroup viewGroup = (ViewGroup) (view != null ? view.getParent() : null);
        if (!QZoneAdStyleManager.f55731a.a(1L, feedData)) {
            QLog.d("QZoneAdFeedBottomLeftPresenter", 2, "[onBindData] don't show default button");
            if (viewGroup == null) {
                return;
            }
            viewGroup.setVisibility(8);
            return;
        }
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        if (qZoneAdFeedUtils.V(feedData)) {
            if (viewGroup == null) {
                return;
            }
            viewGroup.setVisibility(8);
            return;
        }
        int i3 = 0;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        View view2 = this.f441562d;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        LinearLayout linearLayout = this.mVisitLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (qZoneAdFeedUtils.k(feedData)) {
            I();
        }
        ArrayList<String> labelsContentFromCurrencyPassFieldSafely = QZoneAdFeedDataExtKt.getLabelsContentFromCurrencyPassFieldSafely(feedData);
        if (labelsContentFromCurrencyPassFieldSafely.isEmpty()) {
            labelsContentFromCurrencyPassFieldSafely = QZoneAdFeedDataExtKt.getLabelsContentFromExtendInfoSafely(feedData);
        }
        boolean z16 = !labelsContentFromCurrencyPassFieldSafely.isEmpty();
        boolean isHitLeftTextAndLabelExp = QZoneAdFeedDataExtKt.isHitLeftTextAndLabelExp(this.f441565h);
        LinearLayout linearLayout2 = this.mAdBottomLabelLayout;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(z16 ? 0 : 8);
        }
        QZoneRichTextView qZoneRichTextView = this.mAdBottomLeftText;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setVisibility((!z16 || isHitLeftTextAndLabelExp) ? 0 : 8);
        }
        String str2 = feedData.getRecommAction().remark;
        QZoneRichTextView qZoneRichTextView2 = this.mAdBottomLeftText;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setText(str2);
        }
        if (!isHitLeftTextAndLabelExp) {
            QZoneRichTextView qZoneRichTextView3 = this.mAdBottomLeftText;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) (qZoneRichTextView3 != null ? qZoneRichTextView3.getLayoutParams() : null);
            if (layoutParams != null) {
                layoutParams.removeRule(1);
            }
            if (layoutParams != null) {
                layoutParams.setMarginStart(ar.e(0.0f));
            }
        } else {
            QZoneRichTextView qZoneRichTextView4 = this.mAdBottomLeftText;
            Paint paint = qZoneRichTextView4 != null ? qZoneRichTextView4.getPaint() : null;
            float measureText = paint != null ? paint.measureText(str2) : 0.0f;
            String traceId = QZoneAdFeedDataExtKt.getTraceId(this.f441565h);
            if (qZoneAdFeedUtils.w().containsKey(traceId)) {
                QZoneRichTextView qZoneRichTextView5 = this.mAdBottomLeftText;
                if (qZoneRichTextView5 != null) {
                    qZoneRichTextView5.setVisibility(Intrinsics.areEqual(qZoneAdFeedUtils.w().get(traceId), Boolean.TRUE) ? 0 : 8);
                }
            } else {
                QZoneRichTextView qZoneRichTextView6 = this.mAdBottomLeftText;
                if (qZoneRichTextView6 != null && (viewTreeObserver = qZoneRichTextView6.getViewTreeObserver()) != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(new b(traceId, measureText));
                }
                QZoneRichTextView qZoneRichTextView7 = this.mAdBottomLeftText;
                if (qZoneRichTextView7 != null) {
                    qZoneRichTextView7.setVisibility(4);
                }
            }
            QZoneRichTextView qZoneRichTextView8 = this.mAdBottomLeftText;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) (qZoneRichTextView8 != null ? qZoneRichTextView8.getLayoutParams() : null);
            if (layoutParams2 != null) {
                layoutParams2.addRule(1, R.id.mlw);
            }
            if (layoutParams2 != null) {
                layoutParams2.setMarginStart(ar.e(8.0f));
            }
        }
        if (z16) {
            for (Object obj : this.mAdBottomLabelList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (i3 < labelsContentFromCurrencyPassFieldSafely.size()) {
                    str = labelsContentFromCurrencyPassFieldSafely.get(i3);
                } else {
                    str = "";
                }
                Intrinsics.checkNotNullExpressionValue(str, "if (index < labelTextLis\u2026elTextList[index] else \"\"");
                TextView textView = this.mAdBottomLabelList.get(i3);
                if (textView != null) {
                    Intrinsics.checkNotNullExpressionValue(textView, "mAdBottomLabelList[index]");
                    J(textView, i3, isHitLeftTextAndLabelExp);
                }
                TextView textView2 = this.mAdBottomLabelList.get(i3);
                if (textView2 != null) {
                    Intrinsics.checkNotNullExpressionValue(textView2, "mAdBottomLabelList[index]");
                    K(textView2, str);
                }
                i3 = i16;
            }
        }
    }
}
