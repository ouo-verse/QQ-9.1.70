package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ad.tangram.lbs.AdLocation;
import com.tencent.ad.tangram.lbs.AdLocationManager;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtDeviceDemoFragment extends QPublicBaseFragment {
    private static final String TAG = "GdtDeviceDemoFragment";
    private TextView textView;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtDeviceDemoFragment.this.showMessage(String.format("getLocationCache %s", AdLocationManager.getInstance().getLocationCache(GdtDeviceDemoFragment.this.getActivity())));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtDeviceDemoFragment.this.showMessage(String.format("getLocationCacheOnCurrentProcess %s", GdtDeviceDemoFragment.toLocation(((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("gdt_tangram"))));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class a extends LbsManagerServiceOnLocationChangeListener {
            a(String str, boolean z16) {
                super(str, z16);
            }

            @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
            public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                GdtDeviceDemoFragment.this.showMessage(String.format("LbsManagerService.startLocation end errCode:%d %s", Integer.valueOf(i3), GdtDeviceDemoFragment.toLocation(sosoLbsInfo)));
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtDeviceDemoFragment.this.showMessage("LbsManagerService.startLocation start");
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new a("gdt_tangram", true));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMessage(final String str) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment.5
            @Override // java.lang.Runnable
            public void run() {
                GdtDeviceDemoFragment.this.textView.setText(String.format("%s\n%s", GdtDeviceDemoFragment.this.textView.getText(), str));
            }
        }, 0);
    }

    public static void start(Activity activity, Class<? extends QPublicFragmentActivity> cls) {
        GdtLog.i(TAG, "start");
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        QPublicFragmentActivity.b.b(activity, intent, cls, GdtDeviceDemoFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static AdLocation toLocation(@Nullable SosoLbsInfo sosoLbsInfo) {
        if (sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
            AdLocation adLocation = new AdLocation();
            SosoLocation sosoLocation = sosoLbsInfo.mLocation;
            adLocation.latitude = sosoLocation.mLat02;
            adLocation.longitude = sosoLocation.mLon02;
            adLocation.timeMillis = sosoLocation.locationTime;
            return adLocation;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity == null) {
            return;
        }
        activity.getWindow().addFlags(1024);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(getContext(), new InitGdtContextParams());
        this.textView = new TextView(getActivity());
        showMessage(String.format("processName:%s", AdProcessManager.getInstance().getCurrentProcessName(getActivity())));
        Button button = new Button(getActivity());
        button.setText("getDeviceInfo");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(GdtDeviceDemoFragment.this.getActivity(), new GdtDeviceInfoHelper.Params());
                        if (create != null) {
                            Object pbToJson = GdtJsonPbUtil.pbToJson(create.deviceInfo);
                            if (pbToJson != null) {
                                str = pbToJson.toString();
                            } else {
                                str = "";
                            }
                        } else {
                            str = null;
                        }
                        GdtDeviceDemoFragment.this.showMessage(String.format("getDeviceInfo %s", str));
                    }
                }, 3);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        Button button2 = new Button(getActivity());
        button2.setText("AdLocationManager.getLocationCache");
        button2.setOnClickListener(new a());
        Button button3 = new Button(getActivity());
        button3.setText("LbsManagerService.getCachedLbsInfo");
        button3.setOnClickListener(new b());
        Button button4 = new Button(getActivity());
        button4.setText("LbsManagerService.startLocation");
        button4.setOnClickListener(new c());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setBackgroundColor(Color.parseColor("#DBDBDB"));
        linearLayout.setOrientation(1);
        linearLayout.addView(button);
        linearLayout.addView(button2);
        linearLayout.addView(button3);
        linearLayout.addView(button4);
        linearLayout.addView(this.textView);
        ScrollView scrollView = new ScrollView(getActivity());
        scrollView.addView(linearLayout);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, scrollView);
        return scrollView;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
