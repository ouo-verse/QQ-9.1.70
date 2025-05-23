package com.tencent.mobileqq.activity.aio.drawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.av;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DrawerOnlineStatusView extends FrameLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private TextView f178604d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f178605e;

    /* renamed from: f, reason: collision with root package name */
    private int f178606f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f178607h;

    /* renamed from: i, reason: collision with root package name */
    private av f178608i;

    /* renamed from: m, reason: collision with root package name */
    private AccountObserver f178609m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends av {
        a() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void f(boolean z16, Bundle bundle) {
            super.f(z16, bundle);
            if (!z16) {
                return;
            }
            DrawerOnlineStatusView drawerOnlineStatusView = DrawerOnlineStatusView.this;
            drawerOnlineStatusView.f(drawerOnlineStatusView.getContext());
            QLog.i("DrawerOnlineStatusView", 1, "updateOnlineStatus");
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends AccountObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mqq.observer.AccountObserver
        public void onOnlineStatusPush(AppRuntime.Status status, long j3) {
            super.onOnlineStatusPush(status, j3);
            DrawerOnlineStatusView drawerOnlineStatusView = DrawerOnlineStatusView.this;
            drawerOnlineStatusView.f(drawerOnlineStatusView.getContext());
            QLog.i("DrawerOnlineStatusView", 1, "onOnlineStatusPush");
        }
    }

    public DrawerOnlineStatusView(@NonNull Context context) {
        this(context, null);
    }

    private void c() {
        VideoReport.reportEvent("imp", this, null);
    }

    private au d(AppRuntime appRuntime) {
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "");
        return ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(iOnlineStatusService.getOnlineStatus(), iOnlineStatusService.getExtOnlineStatus(), false);
    }

    private com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c e() {
        String currentUid;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (currentUid = peekAppRuntime.getCurrentUid()) == null || currentUid.isEmpty()) {
            return null;
        }
        return ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(currentUid, "DrawerOnlineStatusView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(@Nullable Context context) {
        AppRuntime peekAppRuntime;
        if (context == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        au d16 = d(peekAppRuntime);
        i(context, d16.f255494g, d16.f255489b, d16, e());
    }

    private void g() {
        VideoReport.setElementId(this, "em_bas_status");
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_NONE);
    }

    private void h(@Nullable Context context, @Nullable AppRuntime appRuntime) {
        if (appRuntime != null && context != null) {
            setOnClickListener(this);
            au d16 = d(appRuntime);
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c e16 = e();
            TextView textView = new TextView(context);
            this.f178604d = textView;
            textView.setGravity(16);
            this.f178604d.setTextColor(ContextCompat.getColor(context, R.color.qui_common_text_allwhite_primary));
            this.f178604d.setCompoundDrawablePadding(ViewUtils.dip2px(6.0f));
            this.f178604d.setSingleLine();
            this.f178604d.setTextSize(14.0f);
            this.f178604d.setPadding(ViewUtils.dip2px(10.0f), ViewUtils.dip2px(6.0f), ViewUtils.dip2px(10.0f), ViewUtils.dip2px(6.0f));
            i(context, d16.f255494g, d16.f255489b, d16, e16);
            addView(this.f178604d, new FrameLayout.LayoutParams(-2, -2));
            g();
        }
    }

    private void i(@Nullable Context context, AppRuntime.Status status, long j3, @Nullable au auVar, @Nullable com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        Drawable selfStatusDrawable;
        String str;
        if (cVar != null && auVar != null && context != null) {
            if ((status == AppRuntime.Status.online && j3 <= 0) || status == AppRuntime.Status.invisiable) {
                str = context.getString(R.string.f201494uy);
                selfStatusDrawable = ContextCompat.getDrawable(context, R.drawable.qui_add_emoji_icon_white);
                if (selfStatusDrawable != null) {
                    int dip2px = ViewUtils.dip2px(24.0f);
                    selfStatusDrawable.setBounds(0, 0, dip2px, dip2px);
                }
                this.f178606f = 0;
            } else {
                selfStatusDrawable = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSelfStatusDrawable(j3, status, 1, cVar, 0);
                str = auVar.f255490c;
                if (j3 == 2000) {
                    str = cVar.v();
                }
                this.f178606f = 1;
            }
            this.f178607h = selfStatusDrawable;
            if (str != null && str.length() > 8) {
                str = str.substring(0, 8) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            this.f178604d.setText(str);
            this.f178604d.setCompoundDrawables(selfStatusDrawable, null, null, null);
            k(str);
            if (!this.f178605e) {
                j("0X800C464");
                c();
                this.f178605e = true;
            }
        }
    }

    private void j(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.drawer.DrawerOnlineStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                ReportController.o(null, "dc00898", "", "", str2, str2, 0, 0, String.valueOf(DrawerOnlineStatusView.this.f178606f), "", "", "");
            }
        }, 64, null, true);
    }

    private void k(String str) {
        AccessibilityUtil.s(this, str);
        AccessibilityUtil.n(this, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            ((QQAppInterface) peekAppRuntime).addObserver(this.f178608i);
            peekAppRuntime.registObserver(this.f178609m);
        }
        f(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y newAccountPanel;
        EventCollector.getInstance().onViewClickedBefore(view);
        Context context = getContext();
        if (!(context instanceof BaseActivity)) {
            QLog.d("DrawerOnlineStatusView", 1, "onClick !(context instanceof BaseActivity)");
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
                FrameHelperActivity ji5 = FrameHelperActivity.ji((BaseActivity) context);
                if (ji5 == null) {
                    QLog.d("DrawerOnlineStatusView", 1, "helperActivity == null");
                } else {
                    if (OnlineStatusToggleUtils.e()) {
                        newAccountPanel = iOnlineStatusService.newAccountPanel((QBaseActivity) context, 10);
                        newAccountPanel.Pc(new FrameHelperActivity.o(ji5));
                    } else {
                        y yVar = ji5.H;
                        if (yVar == null || !yVar.isShowing()) {
                            y yVar2 = ji5.H;
                            if (yVar2 != null) {
                                newAccountPanel = yVar2;
                            } else {
                                newAccountPanel = iOnlineStatusService.newAccountPanel((QBaseActivity) context, 10);
                            }
                        }
                    }
                    newAccountPanel.show();
                    j("0X800C465");
                    VideoReport.reportEvent("clck", view, null);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            ((QQAppInterface) peekAppRuntime).removeObserver(this.f178608i);
            peekAppRuntime.unRegistObserver(this.f178609m);
        }
        this.f178605e = false;
    }

    public void setDrawablePadding(int i3) {
        this.f178604d.setCompoundDrawablePadding(ViewUtils.dip2px(i3));
    }

    @SuppressLint({"ResourceAsColor"})
    public void setOnlineTextColor(@ColorRes int i3) {
        if (this.f178606f == 0) {
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            Drawable drawable = this.f178607h;
            if (drawable != null) {
                drawable.setColorFilter(ContextCompat.getColor(getContext(), i3), mode);
            }
            this.f178604d.setCompoundDrawables(this.f178607h, null, null, null);
        }
        this.f178604d.setTextColor(ContextCompat.getColor(getContext(), i3));
    }

    public DrawerOnlineStatusView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerOnlineStatusView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        this.f178608i = new a();
        this.f178609m = new b();
        h(getContext(), MobileQQ.sMobileQQ.peekAppRuntime());
    }
}
