package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.flash.VipFlashNickNameView;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.mobileqq.vip.api.VipInfoForBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSVipNickNameAndIconView extends QCircleBaseWidgetView implements View.OnClickListener {
    private boolean C;
    private int D;
    private int E;
    private int F;
    private a G;
    private int H;
    private FeedCloudMeta$StUser I;
    private FeedCloudMeta$StFeed J;
    private FeedCloudMeta$StComment K;
    private FeedCloudMeta$StReply L;
    private int M;
    private Map<String, Object> N;

    /* renamed from: d, reason: collision with root package name */
    private VipFlashNickNameView f93456d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f93457e;

    /* renamed from: f, reason: collision with root package name */
    private int f93458f;

    /* renamed from: h, reason: collision with root package name */
    private int f93459h;

    /* renamed from: i, reason: collision with root package name */
    private int f93460i;

    /* renamed from: m, reason: collision with root package name */
    private int f93461m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private FeedCloudMeta$StFeed f93465a;

        /* renamed from: b, reason: collision with root package name */
        private FeedCloudMeta$StComment f93466b;

        /* renamed from: c, reason: collision with root package name */
        private FeedCloudMeta$StReply f93467c;

        /* renamed from: d, reason: collision with root package name */
        private int f93468d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, Object> f93469e;

        public b f(FeedCloudMeta$StComment feedCloudMeta$StComment) {
            this.f93466b = feedCloudMeta$StComment;
            return this;
        }

        public b g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f93465a = feedCloudMeta$StFeed;
            return this;
        }

        public b h(int i3) {
            this.f93468d = i3;
            return this;
        }

        public b i(Map<String, Object> map) {
            this.f93469e = map;
            return this;
        }

        public b j(FeedCloudMeta$StReply feedCloudMeta$StReply) {
            this.f93467c = feedCloudMeta$StReply;
            return this;
        }

        public b k(String str) {
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -2105274315:
                    if (str.equals(QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE)) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -1360558221:
                    if (str.equals("pg_xsj_explore_page")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -690880139:
                    if (str.equals(QCircleDaTongConstant.PageId.PG_XSJ_LAYER_PAGE)) {
                        c16 = 2;
                        break;
                    }
                    break;
                case 2026435707:
                    if (str.equals("pg_xsj_friendtab_explore_page")) {
                        c16 = 3;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    this.f93468d = 91;
                    return this;
                case 1:
                    this.f93468d = 92;
                    return this;
                case 2:
                    this.f93468d = 94;
                    return this;
                case 3:
                    this.f93468d = 93;
                    return this;
                default:
                    return this;
            }
        }
    }

    public QFSVipNickNameAndIconView(Context context) {
        this(context, null);
    }

    private void l0(String str, VipInfoForBusiness vipInfoForBusiness, Drawable drawable) {
        int i3;
        v0(str);
        int updateColorNameByVipBusiness = ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByVipBusiness(this.f93456d, vipInfoForBusiness);
        this.H = updateColorNameByVipBusiness;
        s0(updateColorNameByVipBusiness);
        if (drawable != null && (i3 = this.f93459h) != 99) {
            this.f93456d.setMaxEms(i3);
        } else {
            this.f93456d.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        }
        int i16 = this.f93460i;
        if (i16 != 0) {
            this.f93456d.setMaxLines(i16);
        }
        HashMap hashMap = new HashMap();
        int i17 = this.H;
        if (i17 != 0) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQ_VIP_TEXT_TYPE, Integer.valueOf(i17));
        }
        n0(this.f93456d, "em_xsj_author_name", hashMap);
    }

    private void m0(Drawable drawable) {
        ImageView imageView = this.f93457e;
        if (imageView == null) {
            QLog.e("QFSVipNickNameAndIconView", 1, "[addVipIcon] mVipIcon should not vip");
            return;
        }
        if (drawable == null) {
            QLog.e("QFSVipNickNameAndIconView", 4, "[addVipIcon] drawable is null");
            y0(this.f93457e, 8);
            return;
        }
        y0(imageView, 0);
        int i3 = (int) (this.E * 3.3333333f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, this.E);
        layoutParams.leftMargin = this.D;
        this.f93457e.setLayoutParams(layoutParams);
        this.f93457e.setImageDrawable(drawable);
        QLog.d("QFSVipNickNameAndIconView", 4, "[addVipIcon] drawable width = " + i3);
        n0(this.f93457e, QCircleDaTongConstant.ElementId.EM_XSJ_QQ_VIP_NAME_PLATE, null);
    }

    private void n0(View view, String str, Map<String, Object> map) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, p0(map));
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void o0(final View view, final String str, final Map<String, Object> map) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView.1
            @Override // java.lang.Runnable
            public void run() {
                QFSVipNickNameAndIconView.this.r0(view, str, map);
            }
        });
    }

    private Map<String, Object> p0(Map<String, Object> map) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.J;
        if (feedCloudMeta$StFeed != null) {
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.I;
        if (feedCloudMeta$StUser != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StUser.f398463id.get());
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.K;
        if (feedCloudMeta$StComment != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, feedCloudMeta$StComment.f398447id.get());
        } else {
            FeedCloudMeta$StReply feedCloudMeta$StReply = this.L;
            if (feedCloudMeta$StReply != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, feedCloudMeta$StReply.f398460id.get());
            }
        }
        Map<String, Object> map2 = this.N;
        if (map2 != null && map2.size() > 0) {
            buildElementParams.putAll(this.N);
        }
        if (map != null && map.size() > 0) {
            buildElementParams.putAll(map);
        }
        return buildElementParams;
    }

    private void q0() {
        HashMap hashMap = new HashMap();
        int i3 = this.H;
        if (i3 != 0) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQ_VIP_TEXT_TYPE, Integer.valueOf(i3));
        }
        o0(this.f93456d, "em_xsj_author_name", hashMap);
        int i16 = this.H;
        if (i16 != 1) {
            if (i16 != 2) {
                int color = QCircleSkinHelper.getInstance().getColor(this.f93461m);
                VipFlashNickNameView vipFlashNickNameView = this.f93456d;
                if (color == 0) {
                    color = this.f93461m;
                }
                vipFlashNickNameView.setTextColor(color);
                return;
            }
            if (this.I != null) {
                ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(this.f93456d, this.I.f398463id.get(), true);
                o0(this.f93457e, QCircleDaTongConstant.ElementId.EM_XSJ_QQ_VIP_NAME_PLATE, null);
                return;
            }
            return;
        }
        this.f93456d.setTextColor(getContext().getResources().getColor(R.color.f157733cc4));
        o0(this.f93457e, QCircleDaTongConstant.ElementId.EM_XSJ_QQ_VIP_NAME_PLATE, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(View view, String str, Map<String, Object> map) {
        String str2;
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        if (getReportBean() != null && getReportBean().getDtPageId() != null) {
            str2 = getReportBean().getDtPageId();
        } else {
            str2 = QCircleDaTongConstant.PageId.BASE;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("dt_pgid", str2);
        VideoReport.reportEvent("dt_imp", view, p0(map));
    }

    private void s0(int i3) {
        int i16 = 1;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    QLog.d("QFSVipNickNameAndIconView", 1, "[onSetColorName]");
                    return;
                }
                return;
            } else {
                QLog.d("QFSVipNickNameAndIconView", 1, "[onSetRedName]");
                this.f93456d.setTextColor(getContext().getResources().getColor(R.color.f157733cc4));
                return;
            }
        }
        ((IVipColorName) QRoute.api(IVipColorName.class)).clearTextColorGradient(this.f93456d);
        int color = QCircleSkinHelper.getInstance().getColor(this.f93461m);
        VipFlashNickNameView vipFlashNickNameView = this.f93456d;
        if (color == 0) {
            color = this.f93461m;
        }
        vipFlashNickNameView.setTextColor(color);
        VipFlashNickNameView vipFlashNickNameView2 = this.f93456d;
        if (!this.C) {
            i16 = 0;
        }
        vipFlashNickNameView2.setTypeface(Typeface.defaultFromStyle(i16));
    }

    private void u0(Context context, View view, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.f449713k7);
        if (obtainStyledAttributes != null) {
            this.f93458f = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449788q7, 16);
            this.f93459h = obtainStyledAttributes.getInt(y91.a.f449762o7, 99);
            this.f93461m = obtainStyledAttributes.getResourceId(y91.a.f449749n7, R.color.cla);
            this.f93460i = obtainStyledAttributes.getInt(y91.a.f449775p7, 0);
            this.C = obtainStyledAttributes.getBoolean(y91.a.f449737m7, false);
            this.D = (int) obtainStyledAttributes.getDimension(y91.a.f449725l7, 4.0f);
            this.E = (int) obtainStyledAttributes.getDimension(y91.a.f449801r7, 11.0f);
            obtainStyledAttributes.recycle();
        }
        this.f93456d = (VipFlashNickNameView) view.findViewById(R.id.f47881yh);
        this.f93457e = (ImageView) view.findViewById(R.id.f57332n1);
        this.f93456d.setOnClickListener(this);
        this.f93457e.setOnClickListener(this);
    }

    private void v0(String str) {
        Typeface defaultFromStyle;
        this.f93456d.setTextSize(0, this.f93458f);
        VipFlashNickNameView vipFlashNickNameView = this.f93456d;
        if (this.C) {
            defaultFromStyle = Typeface.defaultFromStyle(1);
        } else {
            defaultFromStyle = Typeface.defaultFromStyle(0);
        }
        vipFlashNickNameView.setTypeface(defaultFromStyle);
        this.f93456d.setText(str);
    }

    private void y0(View view, int i3) {
        if (view == null) {
            QLog.e("QFSVipNickNameAndIconView", 1, "[updateViewVisible] view is null");
        } else if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gtu;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f93456d == null) {
            QLog.e("QFSVipNickNameAndIconView", 1, "[onAttachedToWindow] mNickName should not be null");
        } else {
            q0();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i3);
        if (this.F > 0 && this.f93456d != null && QLog.isDevelopLevel()) {
            QLog.d("QFSVipNickNameAndIconView", 1, "[updateAuthorRemainedView] [onMeasure] measuredWidth =" + cx.j(size) + ", mMaxWidth = " + cx.j(this.F) + ", text = " + ((Object) this.f93456d.getText()));
        }
        int i17 = this.F;
        if (i17 > 0 && i17 < size) {
            i3 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
        }
        super.onMeasure(i3, i16);
    }

    public void setMaxWidth(int i3) {
        this.F = i3;
    }

    public void setNickNameClickListener(a aVar) {
        this.G = aVar;
    }

    public void setNickNameTextSize(float f16) {
        this.f93458f = cx.a(f16);
        this.f93456d.setTextSize(f16);
    }

    public void setNormalLevelTextColor(int i3) {
        this.f93461m = i3;
        s0(this.H);
    }

    public void setReportData(b bVar) {
        if (bVar == null) {
            QLog.e("QFSVipNickNameAndIconView", 1, "ReportDataBuilder == null");
            return;
        }
        this.J = bVar.f93465a;
        this.K = bVar.f93466b;
        this.L = bVar.f93467c;
        this.M = bVar.f93468d;
        this.N = bVar.f93469e;
    }

    public void setUser(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.I = feedCloudMeta$StUser;
    }

    public boolean w0(String str) {
        Drawable drawable;
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.I;
        if (feedCloudMeta$StUser == null) {
            QLog.e("QFSVipNickNameAndIconView", 1, "[setText] mStUser should be null");
            return false;
        }
        VipInfoForBusiness vipInfoForBusiness = new VipInfoForBusiness(feedCloudMeta$StUser.f398463id.get());
        vipInfoForBusiness.fromBuffer(this.I.qq_vip.get().toByteArray());
        if (vipInfoForBusiness.isValid()) {
            drawable = ((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getVipIconDrawable(this.f93457e.getResources(), vipInfoForBusiness);
        } else {
            drawable = null;
        }
        QLog.d("QFSVipNickNameAndIconView", 4, "[setText] nickName = " + str);
        m0(drawable);
        l0(str, vipInfoForBusiness, drawable);
        if (drawable == null) {
            return false;
        }
        return true;
    }

    public void x0(int i3) {
        this.f93459h = i3;
    }

    public QFSVipNickNameAndIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSVipNickNameAndIconView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        u0(context, this, attributeSet);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
