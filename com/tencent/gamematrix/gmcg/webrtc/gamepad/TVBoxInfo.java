package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.os.Build;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TVBoxInfo {
    private int mBuildVersionSdk = Build.VERSION.SDK_INT;
    private String mBuildProduct = Build.PRODUCT;
    private String mProductModel = DeviceInfoMonitor.getModel();
    private String mProductBrand = Build.BRAND;
    private String mProductDevice = Build.DEVICE;
    private String mProductManufacturer = Build.MANUFACTURER;
    private String mSystemVerSion = Build.VERSION.RELEASE;

    public String getBuildProduct() {
        return this.mBuildProduct;
    }

    public int getBuildVersionSdk() {
        return this.mBuildVersionSdk;
    }

    public String getProductBrand() {
        return this.mProductBrand;
    }

    public String getProductDevice() {
        return this.mProductDevice;
    }

    public String getProductManufacturer() {
        return this.mProductManufacturer;
    }

    public String getProductModel() {
        return this.mProductModel;
    }

    public String getSystemVerSion() {
        return this.mSystemVerSion;
    }

    public void showTVBoxInformation() {
        Log.i("TVBoxInformation", "SDK = " + this.mBuildVersionSdk + " product = " + this.mBuildProduct + " brand = " + this.mProductBrand + " device = " + this.mProductDevice);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("model = ");
        sb5.append(this.mProductModel);
        sb5.append(" manufacturer = ");
        sb5.append(this.mProductManufacturer);
        sb5.append(" systemVersion = ");
        sb5.append(this.mSystemVerSion);
        Log.i("TVBoxInformation", sb5.toString());
    }
}
