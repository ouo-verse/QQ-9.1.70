package com.qzone.reborn.feedx.itemview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.reborn.util.h;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ac;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ho.i;

/* loaded from: classes37.dex */
public class QZoneFeedxEmptyPageView extends QZoneBaseWidgetView {
    private static final int E = ViewUtils.dip2px(176.0f);
    private static final int F = ViewUtils.dip2px(132.0f);
    private TextView C;
    private a D;

    /* renamed from: e, reason: collision with root package name */
    private Context f54820e;

    /* renamed from: f, reason: collision with root package name */
    private View f54821f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f54822h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f54823i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f54824m;

    /* loaded from: classes37.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f54825a = true;

        /* renamed from: b, reason: collision with root package name */
        private String f54826b = "\u5728\u8fd9\u91cc\uff0c\u5f00\u59cb\u8fde\u8f7d\u4f60\u7684\u751f\u6d3b";

        /* renamed from: c, reason: collision with root package name */
        private String f54827c = "";

        /* renamed from: d, reason: collision with root package name */
        private boolean f54828d = false;

        /* renamed from: e, reason: collision with root package name */
        private String f54829e = "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png";

        /* renamed from: f, reason: collision with root package name */
        private boolean f54830f = true;

        /* renamed from: g, reason: collision with root package name */
        private boolean f54831g = false;

        /* renamed from: h, reason: collision with root package name */
        private boolean f54832h = false;

        public a i(String str) {
            this.f54829e = str;
            return this;
        }

        public a j(boolean z16) {
            this.f54832h = z16;
            return this;
        }

        public a k(boolean z16) {
            this.f54831g = z16;
            return this;
        }

        public a l(boolean z16) {
            this.f54830f = z16;
            return this;
        }

        public a m(boolean z16) {
            this.f54828d = z16;
            return this;
        }

        public a n(String str) {
            this.f54826b = str;
            return this;
        }

        public a o(boolean z16) {
            this.f54825a = z16;
            return this;
        }

        public a p(String str) {
            this.f54827c = str;
            return this;
        }
    }

    public QZoneFeedxEmptyPageView(Context context) {
        super(context);
        this.f54820e = context;
    }

    private void n0() {
        ImageView imageView = this.f54822h;
        if (imageView != null && (imageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f54822h.getLayoutParams();
            layoutParams.topMargin = ViewUtils.dip2px(o0());
            this.f54822h.setLayoutParams(layoutParams);
        }
    }

    private int o0() {
        if (this.D == null) {
            return 100;
        }
        if (s0()) {
            return this.D.f54831g ? 20 : 45;
        }
        if (this.D.f54831g) {
            return 67;
        }
        return this.D.f54832h ? 189 : 100;
    }

    private void p0() {
        a aVar;
        if (this.f54824m == null || (aVar = this.D) == null) {
            return;
        }
        this.f54824m.setText(aVar.f54826b);
    }

    private void q0() {
        a aVar;
        if (this.C == null || (aVar = this.D) == null) {
            return;
        }
        if (!aVar.f54828d) {
            this.C.setVisibility(8);
        } else {
            this.C.setText(this.D.f54827c);
            this.C.setVisibility(0);
        }
    }

    private boolean s0() {
        return ac.b(LoginData.getInstance().getUinString());
    }

    private void u0() {
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(0);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.C0("shuoshuoPlus");
        qZonePublishMoodInitBean.O0(21);
        qZonePublishMoodInitBean.G0(Boolean.TRUE);
        qZonePublishMoodInitBean.v0(bool);
        i.w().c(this.f54820e, qZonePublishMoodInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        u0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void w0() {
        a aVar;
        if (this.f54822h == null || (aVar = this.D) == null) {
            return;
        }
        String str = aVar.f54829e;
        n0();
        h.i(this.f54820e, this.f54822h, str, E, F);
    }

    private void x0() {
        a aVar;
        TextView textView = this.f54823i;
        if (textView == null || (aVar = this.D) == null) {
            return;
        }
        textView.setVisibility(aVar.f54825a ? 0 : 8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    public void setEmptyPageContainerVisibility(boolean z16) {
        View view = this.f54821f;
        if (view == null || this.D == null) {
            return;
        }
        view.setVisibility(z16 ? 0 : 8);
        boolean unused = this.D.f54830f;
    }

    public void y0(boolean z16) {
        View view = this.f54821f;
        if (view == null) {
            return;
        }
        view.setBackgroundResource(z16 ? R.drawable.lvj : R.drawable.qui_common_bg_bottom_light_bg);
    }

    public void setEmptyPageViewBuilder(a aVar, View view) {
        if (aVar == null) {
            QLog.e("BaseWidgetView", 1, "builder is null");
        } else {
            this.D = aVar;
            r0(view);
        }
    }

    private void r0(View view) {
        if (view == null) {
            return;
        }
        this.f54821f = view.findViewById(R.id.f20528m);
        this.f54822h = (ImageView) view.findViewById(R.id.mzc);
        TextView textView = (TextView) view.findViewById(R.id.f20538n);
        this.f54823i = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.itemview.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZoneFeedxEmptyPageView.this.v0(view2);
            }
        });
        this.f54824m = (TextView) view.findViewById(R.id.f162824mu0);
        this.C = (TextView) view.findViewById(R.id.f162825mu1);
        w0();
        p0();
        q0();
        x0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
