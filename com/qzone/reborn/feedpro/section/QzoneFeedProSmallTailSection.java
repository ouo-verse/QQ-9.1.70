package com.qzone.reborn.feedpro.section;

import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.widget.countdown.QzoneFeedProTimeCountDownView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellSmallTail;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDeleteManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \b2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0014J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0014J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedpro/section/QzoneFeedProSmallTailSection;", "Lne/a;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "", "L", "H", "initBeforeText", "I", "Landroid/view/View;", "view", "", "G", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "timeTv", "Lcom/qzone/reborn/feedpro/widget/countdown/QzoneFeedProTimeCountDownView;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/widget/countdown/QzoneFeedProTimeCountDownView;", "countDownView", "dotTv", "smallTailTv", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProSmallTailSection extends ne.a {

    /* renamed from: E, reason: from kotlin metadata */
    private TextView timeTv;

    /* renamed from: F, reason: from kotlin metadata */
    private QzoneFeedProTimeCountDownView countDownView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView dotTv;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView smallTailTv;

    private final void G(View view) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("feedid", CommonFeedExtKt.getFeedUniqueKey(getMFeedData()));
        fo.c.o(view, "em_qz_feed_location", new fo.b().l(linkedHashMap).i(CommonFeedExtKt.getFeedUniqueKey(getMFeedData())).k(ExposurePolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_NONE));
    }

    private final boolean H(final CommonFeed feedData) {
        if (xd.c.u(feedData) && xd.c.n(feedData)) {
            QzoneFeedProTimeCountDownView qzoneFeedProTimeCountDownView = this.countDownView;
            if (qzoneFeedProTimeCountDownView != null) {
                qzoneFeedProTimeCountDownView.setVisibility(0);
            }
            QzoneFeedProTimeCountDownView qzoneFeedProTimeCountDownView2 = this.countDownView;
            if (qzoneFeedProTimeCountDownView2 != null) {
                qzoneFeedProTimeCountDownView2.setData(feedData);
            }
            QzoneFeedProTimeCountDownView qzoneFeedProTimeCountDownView3 = this.countDownView;
            if (qzoneFeedProTimeCountDownView3 == null) {
                return true;
            }
            qzoneFeedProTimeCountDownView3.setOnDeleteFeed(new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.section.QzoneFeedProSmallTailSection$initCountDownView$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    CommonFeed commonFeed = CommonFeed.this;
                    if (commonFeed != null) {
                        new QzoneFeedDeleteManager().removeFeedFromList(commonFeed);
                    }
                }
            });
            return true;
        }
        QzoneFeedProTimeCountDownView qzoneFeedProTimeCountDownView4 = this.countDownView;
        if (qzoneFeedProTimeCountDownView4 != null) {
            qzoneFeedProTimeCountDownView4.setOnDeleteFeed(null);
        }
        QzoneFeedProTimeCountDownView qzoneFeedProTimeCountDownView5 = this.countDownView;
        if (qzoneFeedProTimeCountDownView5 != null) {
            qzoneFeedProTimeCountDownView5.setVisibility(8);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean I(final CommonFeed feedData, boolean initBeforeText) {
        String str;
        String str2;
        TextView textView;
        CommonCellSmallTail cellSmallTail;
        CommonCellSmallTail cellSmallTail2;
        CommonCellSmallTail cellSmallTail3;
        CommonCellLBS cellLbs;
        CommonLBS lbs;
        final TextView textView2 = this.smallTailTv;
        if (textView2 == null) {
            return false;
        }
        String str3 = "";
        if (feedData == null || (cellLbs = feedData.getCellLbs()) == null || (lbs = cellLbs.getLbs()) == null || (str = lbs.getLocation()) == null) {
            str = "";
        }
        if (feedData == null || (cellSmallTail3 = feedData.getCellSmallTail()) == null || (str2 = cellSmallTail3.getDesc()) == null) {
            str2 = "";
        }
        if (str.length() > 0) {
            str3 = str;
        } else {
            if (str2.length() > 0) {
                str3 = str2;
            }
        }
        if (str3.length() == 0) {
            TextView textView3 = this.dotTv;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            textView2.setVisibility(8);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.ax
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QzoneFeedProSmallTailSection.J(view);
                }
            });
            return false;
        }
        textView2.setText(str3);
        textView2.setVisibility(0);
        String actionUrl = (feedData == null || (cellSmallTail2 = feedData.getCellSmallTail()) == null) ? null : cellSmallTail2.getActionUrl();
        if (!(actionUrl == null || actionUrl.length() == 0)) {
            String desc = (feedData == null || (cellSmallTail = feedData.getCellSmallTail()) == null) ? null : cellSmallTail.getDesc();
            if (!(desc == null || desc.length() == 0)) {
                textView2.setEnabled(true);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.ay
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QzoneFeedProSmallTailSection.K(QzoneFeedProSmallTailSection.this, feedData, textView2, view);
                    }
                });
                textView = this.dotTv;
                if (textView != null) {
                    textView.setVisibility(initBeforeText ? 0 : 8);
                }
                G(textView2);
                return true;
            }
        }
        textView2.setEnabled(false);
        textView2.setOnClickListener(null);
        textView = this.dotTv;
        if (textView != null) {
        }
        G(textView2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(QzoneFeedProSmallTailSection this$0, CommonFeed commonFeed, TextView tailTextView, View view) {
        CommonCellSmallTail cellSmallTail;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tailTextView, "$tailTextView");
        ho.i.q(this$0.getActivity(), (commonFeed == null || (cellSmallTail = commonFeed.getCellSmallTail()) == null) ? null : cellSmallTail.getActionUrl());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("feedid", CommonFeedExtKt.getFeedUniqueKey(this$0.getMFeedData()));
        fo.c.b("dt_clck", tailTextView, "em_qz_feed_location", new fo.b().l(linkedHashMap));
    }

    private final boolean L(CommonFeed feedData) {
        String formatTimestamp;
        CommonCellCommon cellCommon;
        CommonCellCommon cellCommon2;
        if (H(feedData)) {
            TextView textView = this.timeTv;
            if (textView != null) {
                textView.setVisibility(8);
            }
            return true;
        }
        TextView textView2 = this.timeTv;
        if (textView2 == null) {
            return false;
        }
        long j3 = 0;
        long time = (feedData == null || (cellCommon2 = feedData.getCellCommon()) == null) ? 0L : cellCommon2.getTime();
        if (time == 0) {
            xd.c.C(textView2);
            return false;
        }
        if (xd.c.o(feedData)) {
            if (feedData != null && (cellCommon = feedData.getCellCommon()) != null) {
                j3 = cellCommon.getUtime();
            }
            formatTimestamp = "\u7f16\u8f91\u4e8e" + CommonFeedDataUtilKt.formatTimestamp(j3);
        } else {
            formatTimestamp = CommonFeedDataUtilKt.formatTimestamp(time);
        }
        textView2.setText(formatTimestamp);
        textView2.setVisibility(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProSmallTailSection";
    }

    @Override // ne.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        QzoneFeedProTimeCountDownView qzoneFeedProTimeCountDownView = this.countDownView;
        if (qzoneFeedProTimeCountDownView != null) {
            qzoneFeedProTimeCountDownView.f();
        }
    }

    @Override // ne.a
    protected int q() {
        return R.id.no_;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        I(feedData, L(feedData));
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.timeTv = (TextView) containerView.findViewById(R.id.eib);
        this.countDownView = (QzoneFeedProTimeCountDownView) containerView.findViewById(R.id.eia);
        this.dotTv = (TextView) containerView.findViewById(R.id.dx9);
        TextView textView = (TextView) containerView.findViewById(R.id.eeq);
        this.smallTailTv = textView;
        if (textView != null) {
            com.qzone.reborn.feedpro.utils.aa.e(com.qzone.reborn.feedpro.utils.aa.f54263a, textView, 0.0f, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(View view) {
    }
}
