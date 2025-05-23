package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.manager.d;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleStatusView extends QCircleBaseWidgetView implements View.OnClickListener, IStatusViewProvider {

    /* renamed from: d, reason: collision with root package name */
    private View.OnClickListener f93159d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleReportBean f93160e;

    /* renamed from: f, reason: collision with root package name */
    protected QUIEmptyState f93161f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f93162h;

    /* renamed from: i, reason: collision with root package name */
    protected QUIEmptyState.Builder f93163i;

    /* renamed from: m, reason: collision with root package name */
    private HashMap<Long, Integer> f93164m;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.widgets.QCircleStatusView$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f93165d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f93166e;
        final /* synthetic */ QCircleStatusView this$0;

        @Override // java.lang.Runnable
        public void run() {
            d.b bVar = new d.b();
            bVar.h(this.f93165d);
            bVar.j(this.f93166e);
            bVar.i(true);
            com.tencent.biz.qqcircle.immersive.manager.d.c().h(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f93168d;

        b(String str) {
            this.f93168d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), com.tencent.biz.qqcircle.immersive.utils.ae.b(this.f93168d));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QCircleStatusView(Context context) {
        this(context, false);
    }

    private void k0() {
        QUIEmptyState.Builder builder = this.f93163i;
        if (builder == null) {
            return;
        }
        QUIEmptyState build = builder.build();
        this.f93161f = build;
        build.setOnClickListener(new a());
        addView(this.f93161f, new ViewGroup.LayoutParams(-1, -1));
    }

    private int m0(long j3) {
        HashMap<Long, Integer> hashMap = this.f93164m;
        if (hashMap != null && hashMap.containsKey(Long.valueOf(j3))) {
            return this.f93164m.get(Long.valueOf(j3)).intValue();
        }
        if (QCirclePluginUtil.isRequestSecurityHit(j3)) {
            return 1;
        }
        return 16;
    }

    private void n0() {
        this.f93163i.setImageType(5);
        this.f93163i.setDesc(uq3.c.N3());
        s0();
    }

    private void p0() {
        setClickable(true);
        o0();
    }

    private void u0(String str) {
        this.f93163i.setTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.f194924d8));
        CharSequence a16 = com.tencent.biz.qqcircle.immersive.utils.ae.a(str);
        if (!TextUtils.isEmpty(a16)) {
            this.f93163i.setDesc(a16.toString());
        }
        this.f93163i.setImageType(13);
        this.f93163i.setButton(com.tencent.biz.qqcircle.utils.h.a(R.string.f1915044z), new b(str));
        s0();
        v0(true);
    }

    private void v0(boolean z16) {
        if (!z16 && getVisibility() == 0) {
            setVisibility(8);
        }
        if (z16 && getVisibility() == 8) {
            setVisibility(0);
        }
    }

    public void A0(String str, boolean z16, long j3) {
        if (QCirclePluginUtil.isRequestSecurityHit(j3) && !TextUtils.isEmpty(str)) {
            u0(str);
        } else {
            z0(str, z16, m0(j3));
        }
    }

    public void B0(String str) {
        C0(str, true);
    }

    public void C0(String str, boolean z16) {
        D0(str, z16, 5);
    }

    public void D0(String str, boolean z16, int i3) {
        z0(str, z16, i3);
        l0();
    }

    public void E0(String str, boolean z16, long j3) {
        if (QCirclePluginUtil.isRequestSecurityHit(j3) && !TextUtils.isEmpty(str)) {
            u0(str);
        } else {
            D0(str, z16, m0(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F0() {
        this.f93163i.setButton(getContext().getString(R.string.f183003i0), this);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleStatusView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public int getPageId() {
        return QCircleReportBean.getPageId(getLogTag(), this.f93160e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l0() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.topMargin = -ImmersiveUtils.dpToPx(30.0f);
        setLayoutParams(marginLayoutParams);
    }

    public void o0() {
        v0(false);
    }

    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        r0(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void q0(Context context) {
        if (this.f93162h) {
            this.f93163i.setThemeType(2);
            this.f93163i.setBackgroundColorType(0);
        }
        this.f93163i.setImageType(16);
        k0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r0(View view) {
        View.OnClickListener onClickListener = this.f93159d;
        if (onClickListener == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s0() {
        QUIEmptyState qUIEmptyState = this.f93161f;
        if (qUIEmptyState != null) {
            removeView(qUIEmptyState);
        }
        k0();
    }

    public void setBackgroundColorType(int i3) {
        this.f93163i.setBackgroundColorType(i3);
    }

    public void setOnRetryClickListener(View.OnClickListener onClickListener) {
        this.f93159d = onClickListener;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(QCircleReportBean qCircleReportBean) {
        super.setReportBean(qCircleReportBean);
    }

    public void setTokenByErrorCode(long j3, int i3) {
        if (this.f93164m == null) {
            this.f93164m = new HashMap<>();
        }
        this.f93164m.put(Long.valueOf(j3), Integer.valueOf(i3));
    }

    @Override // com.tencent.biz.richframework.part.IStatusViewProvider
    public void showErrorView(int i3, String str) {
        A0(str, true, i3);
    }

    public void w0() {
        x0(null);
        l0();
    }

    public void x0(String str) {
        y0(str, true);
    }

    public void y0(String str, boolean z16) {
        z0(str, z16, 5);
    }

    public void z0(String str, boolean z16, int i3) {
        QLog.d("QCircleStatusView", 1, "[showErrorView] errorMsg: " + str + " | isShowAction: " + z16 + " | imageType: " + i3, new Exception());
        if (!HostNetworkUtils.isNetworkAvailable()) {
            n0();
        } else {
            this.f93163i.setImageType(i3);
            if (!TextUtils.isEmpty(str)) {
                String[] f16 = cu.f(str, "\n");
                if (f16.length >= 2) {
                    this.f93163i.setTitle(f16[0]);
                    this.f93163i.setDesc(f16[1]);
                } else {
                    this.f93163i.setTitle(f16[0]);
                }
            } else {
                this.f93163i.setDesc(uq3.c.c4());
            }
        }
        if (z16) {
            F0();
        }
        s0();
        v0(true);
    }

    public QCircleStatusView(Context context, boolean z16) {
        this(context, null, z16);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        return QCircleReportBean.getReportBean(getLogTag(), this.f93160e);
    }

    public QCircleStatusView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    public QCircleStatusView(@NonNull Context context, @Nullable AttributeSet attributeSet, boolean z16) {
        super(context, attributeSet);
        this.f93162h = false;
        this.f93163i = new QUIEmptyState.Builder(getContext());
        this.f93164m = new HashMap<>();
        this.f93162h = z16;
        q0(context);
        p0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    @Override // com.tencent.biz.richframework.part.IStatusViewProvider
    public View getStatusView() {
        return this;
    }

    public void showEmptyView(String str) {
    }

    @Override // com.tencent.biz.richframework.part.IStatusViewProvider
    public void showHintView(String str) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
