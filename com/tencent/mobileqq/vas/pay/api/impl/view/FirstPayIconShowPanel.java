package com.tencent.mobileqq.vas.pay.api.impl.view;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import g23.b;
import java.util.HashMap;
import mqq.util.WeakReference;

/* loaded from: classes20.dex */
public class FirstPayIconShowPanel implements IVasNativePayManager, View.OnClickListener, PopupWindow.OnDismissListener, Application.ActivityLifecycleCallbacks {
    private static final int PAY_LAYOUT_HEIGHT_NO_BANNER_DP = 200;
    private WeakReference<Activity> mActivity;
    private Button mButtonFirstShow;
    private String mCurrentActivityClassName;
    private ImageView mFirstPayImg;
    public PopupWindow mFirstPayPanel;
    private TextView mFirstPayTxt;
    private View mFirstShowView;
    private View mRootView;
    private boolean mIsNight = QQTheme.isNowThemeIsNight();
    private String offerIdB = VasNativePayManagerImpl.OFFER_ID_B_DEFAULT;
    private boolean mIsBCoin = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FirstPayIconShowPanel.this.hidePayPanel();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void handleWindowAnimationOff() {
        PopupWindow popupWindow = this.mFirstPayPanel;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mFirstPayPanel.getContentView().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.FirstPayIconShowPanel.3
                @Override // java.lang.Runnable
                public void run() {
                    FirstPayIconShowPanel.this.mFirstPayPanel.setAnimationStyle(0);
                    FirstPayIconShowPanel.this.mFirstPayPanel.update();
                }
            });
        }
    }

    private void handleWindowAnimationOn() {
        PopupWindow popupWindow = this.mFirstPayPanel;
        if (popupWindow != null) {
            popupWindow.getContentView().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.FirstPayIconShowPanel.4
                @Override // java.lang.Runnable
                public void run() {
                    FirstPayIconShowPanel.this.mFirstPayPanel.setAnimationStyle(R.style.f173923av4);
                    FirstPayIconShowPanel.this.mFirstPayPanel.update();
                }
            }, 200L);
        }
    }

    private boolean initPanelView(Activity activity, b.a aVar) {
        String str;
        int i3;
        int i16;
        int i17;
        Bitmap bitmap;
        if (this.mIsNight) {
            str = aVar.f401121b;
        } else {
            str = aVar.f401120a;
        }
        URLDrawable drawable = URLDrawable.getDrawable(str);
        if (drawable == null) {
            return true;
        }
        LayoutInflater from = LayoutInflater.from(activity);
        if (this.mIsNight) {
            i3 = R.layout.hgj;
        } else {
            i3 = R.layout.hgi;
        }
        this.mRootView = from.inflate(i3, (ViewGroup) null);
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        Drawable currDrawable = drawable.getCurrDrawable();
        if ((currDrawable instanceof RegionDrawable) && (bitmap = ((RegionDrawable) currDrawable).getBitmap()) != null) {
            int screenWidth = ViewUtils.getScreenWidth();
            int screenHeight = ViewUtils.getScreenHeight();
            if (screenWidth >= screenHeight) {
                screenWidth = screenHeight;
            }
            i16 = screenWidth - this.mRootView.getPaddingLeft();
            i17 = (bitmap.getHeight() * i16) / bitmap.getWidth();
        } else {
            i16 = 0;
            i17 = 0;
        }
        if (i16 == 0 || i17 == 0) {
            return true;
        }
        int applyDimension = ((int) TypedValue.applyDimension(1, 200.0f, displayMetrics)) + i17;
        this.mFirstShowView = this.mRootView.findViewById(R.id.f72603ra);
        this.mFirstPayImg = (ImageView) this.mRootView.findViewById(R.id.dhp);
        this.mFirstPayTxt = (TextView) this.mRootView.findViewById(R.id.f113346qd);
        Button button = (Button) this.mRootView.findViewById(R.id.an_);
        this.mButtonFirstShow = button;
        button.setOnClickListener(new a());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFirstPayImg.getLayoutParams();
        layoutParams.width = i16;
        layoutParams.height = i17;
        this.mFirstPayImg.setLayoutParams(layoutParams);
        this.mFirstPayImg.setImageDrawable(drawable);
        this.mFirstPayTxt.setText(aVar.f401122c);
        PopupWindow popupWindow = new PopupWindow(this.mRootView, -1, applyDimension);
        this.mFirstPayPanel = popupWindow;
        popupWindow.setAnimationStyle(R.style.f173923av4);
        this.mFirstPayPanel.setBackgroundDrawable(new ColorDrawable(0));
        this.mFirstPayPanel.setFocusable(true);
        this.mFirstPayPanel.setOutsideTouchable(true);
        this.mFirstPayPanel.update();
        this.mFirstPayPanel.setOnDismissListener(this);
        return false;
    }

    private void reportShowFirstPayPanel(IVasNativePayManager.ReportData reportData) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06MK9E48EOTF");
        hashMap.put("huobi_sdkversion", VasNativePayManagerImpl.PAY_VERSION);
        if (this.mIsBCoin) {
            str = this.offerIdB;
        } else {
            str = VasNativePayManagerImpl.OFFER_ID_C;
        }
        hashMap.put("huobi_extra_param", str);
        hashMap.put("pgid", "pg_huobi_new_user_guidance");
        for (String str2 : reportData.mDtData.keySet()) {
            hashMap.put(str2, reportData.mDtData.get(str2));
        }
        VideoReport.setPageParams(this.mFirstShowView, new PageParams(hashMap));
        VideoReport.setPageId(this.mFirstShowView, "pg_huobi_new_user_guidance");
        VideoReport.reportEvent("pgin", this.mFirstShowView, hashMap);
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager
    public void hidePayPanel() {
        PopupWindow popupWindow = this.mFirstPayPanel;
        if (popupWindow != null && popupWindow.getContentView() != null) {
            this.mFirstPayPanel.getContentView().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.FirstPayIconShowPanel.2
                @Override // java.lang.Runnable
                public void run() {
                    FirstPayIconShowPanel.this.mFirstPayPanel.dismiss();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager
    public IVasNativePayManager initAndShowPayPanel(Activity activity, String str, String str2, IVasNativePayManager.ReportData reportData, IVasNativePayManager.PayObserver payObserver) {
        return null;
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager
    public boolean isSwitchEnable() {
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        this.mFirstPayPanel.setFocusable(false);
        if (activity.getComponentName().getClassName().equals(this.mCurrentActivityClassName)) {
            handleWindowAnimationOff();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        this.mFirstPayPanel.setFocusable(true);
        if (activity.getComponentName().getClassName().equals(this.mCurrentActivityClassName)) {
            handleWindowAnimationOn();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        hidePayPanel();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        WeakReference<Activity> weakReference;
        if (this.mFirstPayPanel != null && (weakReference = this.mActivity) != null && weakReference.get() != null && Build.VERSION.SDK_INT >= 26) {
            try {
                ((Application) this.mActivity.get().getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public boolean showFirstPayIconShowPanel(Activity activity, IVasNativePayManager.ReportData reportData, b.a aVar, boolean z16) {
        if (activity == null || reportData == null || aVar == null) {
            return false;
        }
        this.mIsBCoin = z16;
        this.mActivity = new WeakReference<>(activity);
        this.mCurrentActivityClassName = activity.getComponentName().getClassName();
        if (initPanelView(activity, aVar)) {
            return false;
        }
        this.mFirstPayPanel.showAtLocation(activity.getWindow().getDecorView(), 85, 0, 0);
        reportShowFirstPayPanel(reportData);
        return true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager
    public void directdPay(Activity activity, int i3, IVasNativePayManager.ReportData reportData, IVasNativePayManager.PayObserver payObserver) {
    }
}
