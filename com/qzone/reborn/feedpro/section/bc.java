package com.qzone.reborn.feedpro.section;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellPermission;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellVisitor;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001f\u00a8\u0006,"}, d2 = {"Lcom/qzone/reborn/feedpro/section/bc;", "Lne/a;", "Landroidx/lifecycle/Observer;", "Lzd/d;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "", "J", "", "H", "initBeforeText", "I", "commonFeed", "M", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "permissionInfoBean", "L", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "subSmallTailContainer", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "visitNumTv", "G", "dotTv", "rightRoot", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "rightIv", "rightTv", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class bc extends ne.a implements Observer<zd.d> {

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout subSmallTailContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView visitNumTv;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView dotTv;

    /* renamed from: H, reason: from kotlin metadata */
    private LinearLayout rightRoot;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView rightIv;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView rightTv;

    private final void H() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("feedid", CommonFeedExtKt.getFeedUniqueKey(getMFeedData()));
        fo.c.o(this.visitNumTv, "em_qz_feed_views", new fo.b().l(linkedHashMap).i(CommonFeedExtKt.getFeedUniqueKey(getMFeedData())).k(ExposurePolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_NONE));
    }

    private final boolean I(CommonFeed feedData, boolean initBeforeText) {
        String str;
        CommonCellPermission cellPermission;
        String icon;
        CommonCellPermission cellPermission2;
        String str2 = "";
        if (feedData == null || (cellPermission2 = feedData.getCellPermission()) == null || (str = cellPermission2.getDesc()) == null) {
            str = "";
        }
        if (feedData != null && (cellPermission = feedData.getCellPermission()) != null && (icon = cellPermission.getIcon()) != null) {
            str2 = icon;
        }
        QLog.i("QzoneFeedProRightSection", 1, "feed summary is " + CommonFeedDataUtilKt.getFeedContentSummary(feedData) + ", permission desc is " + str);
        if (TextUtils.isEmpty(str)) {
            TextView textView = this.dotTv;
            if (textView != null) {
                textView.setVisibility(8);
            }
            LinearLayout linearLayout = this.rightRoot;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            return false;
        }
        TextView textView2 = this.dotTv;
        if (textView2 != null) {
            textView2.setVisibility(initBeforeText ? 0 : 8);
        }
        TextView textView3 = this.rightTv;
        if (textView3 != null) {
            textView3.setText(str);
        }
        LinearLayout linearLayout2 = this.rightRoot;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        M(feedData);
        ImageView imageView = this.rightIv;
        if (imageView != null) {
            if (TextUtils.isEmpty(str2)) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                com.tencent.mobileqq.qzone.picload.c.a().j(imageView, new c.C8489c().h(str2).e(R.color.qui_common_icon_secondary));
                com.qzone.reborn.feedpro.utils.aa.c(com.qzone.reborn.feedpro.utils.aa.f54263a, imageView, 0.0f, 1, null);
            }
        }
        return true;
    }

    private final boolean J(final CommonFeed feedData) {
        CommonCellVisitor cellVisitor;
        if (!xd.c.u(feedData)) {
            TextView textView = this.visitNumTv;
            if (textView != null) {
                textView.setVisibility(8);
            }
            return false;
        }
        if (com.qzone.reborn.feedpro.utils.ap.f54313a.b(n())) {
            TextView textView2 = this.visitNumTv;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            return false;
        }
        TextView textView3 = this.visitNumTv;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.az
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bc.K(CommonFeed.this, this, view);
                }
            });
            int viewNum = (feedData == null || (cellVisitor = feedData.getCellVisitor()) == null) ? 0 : cellVisitor.getViewNum();
            if (viewNum > 0) {
                textView3.setText("\u6d4f\u89c8" + viewNum);
                textView3.setVisibility(0);
                return true;
            }
            textView3.setVisibility(8);
            return false;
        }
        H();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(CommonFeed commonFeed, bc this$0, View view) {
        CommonCellVisitor cellVisitor;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String actionUrl = (commonFeed == null || (cellVisitor = commonFeed.getCellVisitor()) == null) ? null : cellVisitor.getActionUrl();
        boolean z16 = true;
        QLog.i("QzoneFeedProRightSection", 1, "action url is " + actionUrl);
        if (actionUrl != null && actionUrl.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ho.i.q(this$0.getActivity(), actionUrl);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("feedid", CommonFeedExtKt.getFeedUniqueKey(this$0.getMFeedData()));
        fo.c.b("dt_clck", this$0.visitNumTv, "em_qz_feed_views", new fo.b().l(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(bc this$0, CommonFeed commonFeed, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNull(commonFeed);
        CommonCellPermission cellPermission = commonFeed.getCellPermission();
        Intrinsics.checkNotNull(cellPermission);
        ho.i.q(activity, cellPermission.getActionUrl());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProRightSection";
    }

    @Override // ne.a
    protected int q() {
        return R.id.noa;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        boolean J = J(feedData);
        boolean I = I(feedData, J);
        if (!J && !I) {
            LinearLayout linearLayout = this.subSmallTailContainer;
            if (linearLayout != null) {
                linearLayout.setPadding(0, 0, 0, 0);
            }
        } else {
            LinearLayout linearLayout2 = this.subSmallTailContainer;
            if (linearLayout2 != null) {
                linearLayout2.setPadding(0, ef.d.b(4), 0, 0);
            }
        }
        if (TextUtils.isEmpty(CommonFeedExtKt.getFeedUniqueKey(feedData))) {
            return;
        }
        QLog.i("QzoneFeedProRightSection", 1, "observePermissionData, dataId: " + CommonFeedExtKt.getFeedUniqueKey(feedData));
        int i3 = RFWLog.DEV;
        Object[] objArr = new Object[1];
        objArr[0] = "observe data, feedsKey: " + CommonFeedExtKt.getFeedUniqueKey(feedData) + ", permission: " + (feedData != null ? feedData.getCellPermission() : null) + ", section: " + this;
        RFWLog.d("QzoneFeedProRightSection", i3, objArr);
        ze.a.a().observerGlobalState(new zd.d(CommonFeedExtKt.getFeedUniqueKey(feedData), feedData != null ? feedData.getCellPermission() : null), this);
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.subSmallTailContainer = (LinearLayout) containerView.findViewById(R.id.ewk);
        this.visitNumTv = (TextView) containerView.findViewById(R.id.eif);
        this.dotTv = (TextView) containerView.findViewById(R.id.dx9);
        this.rightRoot = (LinearLayout) containerView.findViewById(R.id.clf);
        this.rightIv = (ImageView) containerView.findViewById(R.id.cp6);
        this.rightTv = (TextView) containerView.findViewById(R.id.clu);
        TextView textView = this.visitNumTv;
        if (textView != null) {
            com.qzone.reborn.feedpro.utils.aa.e(com.qzone.reborn.feedpro.utils.aa.f54263a, textView, 0.0f, 1, null);
        }
        TextView textView2 = this.rightTv;
        if (textView2 != null) {
            com.qzone.reborn.feedpro.utils.aa.e(com.qzone.reborn.feedpro.utils.aa.f54263a, textView2, 0.0f, 1, null);
        }
    }

    private final void M(final CommonFeed commonFeed) {
        CommonCellPermission cellPermission;
        String actionUrl = (commonFeed == null || (cellPermission = commonFeed.getCellPermission()) == null) ? null : cellPermission.getActionUrl();
        if (actionUrl == null || actionUrl.length() == 0) {
            LinearLayout linearLayout = this.rightRoot;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.ba
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        bc.N(view);
                    }
                });
            }
            LinearLayout linearLayout2 = this.rightRoot;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setEnabled(false);
            return;
        }
        LinearLayout linearLayout3 = this.rightRoot;
        if (linearLayout3 != null) {
            linearLayout3.setEnabled(true);
        }
        LinearLayout linearLayout4 = this.rightRoot;
        if (linearLayout4 != null) {
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.bb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bc.O(bc.this, commonFeed, view);
                }
            });
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void onChanged(zd.d permissionInfoBean) {
        if (permissionInfoBean == null || !TextUtils.equals(permissionInfoBean.getFeedUniKey(), CommonFeedExtKt.getFeedUniqueKey(getMFeedData()))) {
            return;
        }
        RFWLog.d(getTAG(), RFWLog.CLR, "permission onChanged, feedsKey:" + permissionInfoBean.getFeedUniKey() + ", permission:" + permissionInfoBean.getCellPermission());
        CommonFeed mFeedData = getMFeedData();
        if (mFeedData != null) {
            mFeedData.setCellPermission(permissionInfoBean.getCellPermission());
        }
        x(getMFeedData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(View view) {
    }
}
