package com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class a {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8543a extends b {

        @SerializedName("page_posx")
        public int pagePosX;

        @SerializedName("page_posy")
        public int pagePosY;

        @SerializedName("posx")
        public int posX;

        @SerializedName("posy")
        public int posY;

        @SerializedName("screenx")
        public int screenX;

        @SerializedName("screeny")
        public int screenY;

        public C8543a(Context context) {
            super(context);
            this.posX = 0;
            this.posY = 0;
            this.screenX = 0;
            this.screenY = 0;
            this.pagePosX = 0;
            this.pagePosY = 0;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.a.b
        public /* bridge */ /* synthetic */ JsonObject a() {
            return super.a();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.a.b
        @NonNull
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static abstract class b {

        @SerializedName("screen_height")
        private final int mScreenHeight;

        @SerializedName("screen_width")
        private final int mScreenWidth;

        @SerializedName("ad_width")
        public int adWidth = 0;

        @SerializedName("ad_height")
        public int adHeight = 0;

        @SerializedName("search_timestamp")
        public long searchTimestamp = 0;

        @SerializedName("result_num")
        public int resultNum = 0;

        @SerializedName("input_manually")
        public int inputManually = 0;

        @SerializedName("ad_position_on_page")
        public int adPositionOnPage = 0;

        @SerializedName("query_result_page")
        public int queryResultPage = 0;

        @SerializedName("scroll_top")
        public int scrollTop = 0;

        @SerializedName("platform")
        private final String mPlatform = "android";

        @SerializedName(AppConstants.Preferences.QQ_VERSION)
        private final String mQQVersion = AppSetting.f99551k;

        @SerializedName("device_brand")
        private final String mDeviceBrand = Build.BRAND;

        @SerializedName("device_model")
        private final String mDeviceModel = DeviceInfoMonitor.getModel();

        public b(Context context) {
            this.mScreenWidth = a.d(context);
            this.mScreenHeight = a.c(context);
        }

        public JsonObject a() {
            return op2.a.d(this, null);
        }

        @NonNull
        public String toString() {
            return op2.a.e(this, "{}");
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class c extends b {

        @SerializedName("exp_timestamp")
        private final long mExpTimestamp;

        public c(Context context) {
            super(context);
            this.mExpTimestamp = System.currentTimeMillis();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.a.b
        public /* bridge */ /* synthetic */ JsonObject a() {
            return super.a();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.a.b
        @NonNull
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class d extends b {
        public d(Context context) {
            super(context);
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.a.b
        public /* bridge */ /* synthetic */ JsonObject a() {
            return super.a();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.a.b
        @NonNull
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(Context context) {
        Resources resources;
        DisplayMetrics displayMetrics = null;
        if (context != null) {
            resources = context.getResources();
        } else {
            resources = null;
        }
        if (resources != null) {
            displayMetrics = resources.getDisplayMetrics();
        }
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(Context context) {
        Resources resources;
        DisplayMetrics displayMetrics = null;
        if (context != null) {
            resources = context.getResources();
        } else {
            resources = null;
        }
        if (resources != null) {
            displayMetrics = resources.getDisplayMetrics();
        }
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
    }
}
