package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVHostCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes33.dex */
public class IVCommonInterfaceImpl {
    private static final String TAG = "IVCommonInterfaceImpl";
    private static final IVCommonInterfaceImpl sInstance = new IVCommonInterfaceImpl();
    private IVHostCallback mIVHostCallback;

    IVCommonInterfaceImpl() {
    }

    public static IVCommonInterfaceImpl getInstance() {
        return sInstance;
    }

    public void onHostActivityBackPress() {
        IVHostCallback iVHostCallback = this.mIVHostCallback;
        if (iVHostCallback != null) {
            iVHostCallback.onHostActivityBackPress();
        }
    }

    public void onHostActivityDestroy() {
        IVHostCallback iVHostCallback = this.mIVHostCallback;
        if (iVHostCallback != null) {
            iVHostCallback.onHostActivityDestroy();
        }
    }

    public void onHostActivityNewIntent(Intent intent) {
        IVHostCallback iVHostCallback = this.mIVHostCallback;
        if (iVHostCallback != null) {
            iVHostCallback.onHostActivityNewIntent(intent);
        }
    }

    public void onHostActivityPause() {
        IVHostCallback iVHostCallback = this.mIVHostCallback;
        if (iVHostCallback != null) {
            iVHostCallback.onHostActivityPause();
        }
    }

    public void onHostActivityResult(int i3, int i16, Intent intent) {
        IVHostCallback iVHostCallback = this.mIVHostCallback;
        if (iVHostCallback != null) {
            iVHostCallback.onHostActivityResult(i3, i16, intent);
        }
    }

    public void onHostActivityResume() {
        IVHostCallback iVHostCallback = this.mIVHostCallback;
        if (iVHostCallback != null) {
            iVHostCallback.onHostActivityResume();
        }
    }

    public void onHostActivityStop() {
        IVHostCallback iVHostCallback = this.mIVHostCallback;
        if (iVHostCallback != null) {
            iVHostCallback.onHostActivityStop();
        }
    }

    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        IVHostCallback iVHostCallback = this.mIVHostCallback;
        if (iVHostCallback != null) {
            iVHostCallback.onRequestPermissionsResult(i3, strArr, iArr);
        }
    }

    public void setHostActivityCallback(IVHostCallback iVHostCallback) {
        this.mIVHostCallback = iVHostCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dealLocationStr(String str) {
        return (str == null || "Unknown".equals(str)) ? "" : str;
    }

    public Future<Bundle> getLocation(final String str) {
        return ThreadManagerExecutor.getExecutorService(16).submit(new Callable<Bundle>() { // from class: com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Bundle call() throws Exception {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final Bundle[] bundleArr = new Bundle[1];
                ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new LbsManagerServiceOnLocationChangeListener(str) { // from class: com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl.1.1
                    @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
                    public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                        SosoLocation sosoLocation;
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("onLocationFinish code : ");
                            sb5.append(i3);
                            sb5.append(" info : ");
                            sb5.append(sosoLbsInfo == null ? null : sosoLbsInfo.mLocation);
                            QLog.i(IVCommonInterfaceImpl.TAG, 2, sb5.toString());
                        }
                        Bundle bundle = new Bundle();
                        if (sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
                            bundle.putDouble(QCircleSchemeAttr.Polymerize.LAT, sosoLocation.mLat02);
                            bundle.putDouble("lon", sosoLbsInfo.mLocation.mLon02);
                            bundle.putString("nation", IVCommonInterfaceImpl.this.dealLocationStr(sosoLbsInfo.mLocation.nation));
                            bundle.putString("province", IVCommonInterfaceImpl.this.dealLocationStr(sosoLbsInfo.mLocation.province));
                            bundle.putString("city", IVCommonInterfaceImpl.this.dealLocationStr(sosoLbsInfo.mLocation.city));
                        }
                        bundle.putInt("code", i3);
                        bundleArr[0] = bundle;
                        countDownLatch.countDown();
                    }
                });
                countDownLatch.await();
                return bundleArr[0];
            }
        });
    }
}
