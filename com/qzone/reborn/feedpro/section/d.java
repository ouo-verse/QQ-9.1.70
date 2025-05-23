package com.qzone.reborn.feedpro.section;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellBigTail;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.QZoneShareManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00152\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u001e\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J,\u0010\u001b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0014J\b\u0010\u001d\u001a\u00020\bH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0013H\u0014J\u0012\u0010\"\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0018\u0010 \u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010$\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/feedpro/section/d;", "Lne/a;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "", "I", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellBigTail;", "cellBigTail", "", "maxTextNum", "marginStartDp", "J", "Landroid/widget/LinearLayout;", "bigTailRoot", "M", "", "", "", "H", "Landroid/view/View;", "view", "G", "Landroid/widget/ImageView;", "leftIconIv", "K", "Landroid/widget/TextView;", "rightTextTv", "L", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "E", "Landroid/view/View;", UserInfo.SEX_FEMALE, "bigTailContainer", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends ne.a {

    /* renamed from: E, reason: from kotlin metadata */
    private View containerView;

    /* renamed from: F, reason: from kotlin metadata */
    private View bigTailContainer;

    private final void G(View view, CommonCellBigTail cellBigTail) {
        fo.c.o(view, "em_qz_feed_big_tail", new fo.b().l(H(cellBigTail)).i(CommonFeedExtKt.getFeedUniqueKey(getMFeedData())).k(ExposurePolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_NONE));
    }

    private final Map<String, Object> H(CommonCellBigTail cellBigTail) {
        String desc;
        Integer type;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("macrotail_type", Integer.valueOf((cellBigTail == null || (type = cellBigTail.getType()) == null) ? 0 : type.intValue()));
        String str = "";
        linkedHashMap.put(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, "");
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, eo.c.f396879a.c());
        if (cellBigTail != null && (desc = cellBigTail.getDesc()) != null) {
            str = desc;
        }
        linkedHashMap.put("literal_text", str);
        return linkedHashMap;
    }

    private final void J(CommonCellBigTail cellBigTail, int maxTextNum, int marginStartDp) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f1298072, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.f20789b);
        TextView textView = (TextView) linearLayout.findViewById(R.id.f20799c);
        com.qzone.reborn.feedpro.utils.aa.g(com.qzone.reborn.feedpro.utils.aa.f54263a, linearLayout, getActivity(), 0, false, 6, null);
        M(cellBigTail, linearLayout);
        K(cellBigTail, imageView);
        L(cellBigTail, linearLayout, textView, maxTextNum);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ef.d.b(25));
        layoutParams.setMarginStart(marginStartDp);
        View view = this.bigTailContainer;
        if (view != null) {
            ((ViewGroup) view).addView(linearLayout, layoutParams);
        }
        G(linearLayout, cellBigTail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(d this$0, CommonCellBigTail commonCellBigTail, LinearLayout bigTailRoot, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bigTailRoot, "$bigTailRoot");
        ho.i.q(this$0.getActivity(), commonCellBigTail.getActionUrl());
        fo.c.b("dt_clck", bigTailRoot, "em_qz_feed_big_tail", new fo.b().l(this$0.H(commonCellBigTail)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedBigTailSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.nnx;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        View view = this.bigTailContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.bigTailContainer;
        if (view2 != null) {
            ((ViewGroup) view2).removeAllViews();
        }
        I(feedData);
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.containerView = containerView;
        this.bigTailContainer = containerView.findViewById(R.id.mw8);
    }

    private final void I(CommonFeed feedData) {
        List<CommonCellBigTail> rptCellBigTail = feedData != null ? feedData.getRptCellBigTail() : null;
        if (ArrayUtils.isOutOfArrayIndex(0, rptCellBigTail)) {
            View view = this.bigTailContainer;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        Intrinsics.checkNotNull(rptCellBigTail);
        if (rptCellBigTail.size() > 1) {
            J(je.a.r(rptCellBigTail), 10, 0);
            J(je.a.s(rptCellBigTail), 10, ef.d.b(6));
        } else {
            J(rptCellBigTail.get(0), 15, 0);
        }
        View view2 = this.bigTailContainer;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(0);
    }

    private final void K(CommonCellBigTail cellBigTail, ImageView leftIconIv) {
        if (leftIconIv != null) {
            String str = null;
            if (com.qzone.reborn.util.k.f59549a.f()) {
                if (cellBigTail != null) {
                    str = cellBigTail.getDarkIcon();
                }
            } else if (cellBigTail != null) {
                str = cellBigTail.getBrightIcon();
            }
            if (TextUtils.isEmpty(str)) {
                leftIconIv.setVisibility(8);
                return;
            }
            leftIconIv.setVisibility(0);
            QLog.i("QzoneFeedBigTailSection", 2, "icon url is " + str);
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(str).setRequestWidth(ef.d.b(14)).setRequestHeight(ef.d.b(14)).setTargetView(leftIconIv));
        }
    }

    private final void M(final CommonCellBigTail cellBigTail, final LinearLayout bigTailRoot) {
        String actionUrl;
        boolean z16 = false;
        if (cellBigTail != null && (actionUrl = cellBigTail.getActionUrl()) != null) {
            if (actionUrl.length() > 0) {
                z16 = true;
            }
        }
        if (z16) {
            bigTailRoot.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.N(d.this, cellBigTail, bigTailRoot, view);
                }
            });
        } else {
            bigTailRoot.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.O(view);
                }
            });
        }
    }

    private final void L(CommonCellBigTail cellBigTail, LinearLayout bigTailRoot, TextView rightTextTv, int maxTextNum) {
        String str;
        if (rightTextTv != null) {
            if (cellBigTail == null || (str = cellBigTail.getDesc()) == null) {
                str = "";
            }
            QLog.i("QzoneFeedBigTailSection", 2, "big tail desc is " + str);
            if (str.length() == 0) {
                bigTailRoot.setVisibility(8);
                return;
            }
            rightTextTv.setMaxEms(maxTextNum);
            rightTextTv.setEllipsize(TextUtils.TruncateAt.END);
            rightTextTv.setText(str);
            bigTailRoot.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(View view) {
    }
}
