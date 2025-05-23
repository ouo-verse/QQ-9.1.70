package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BlockAdManager {
    private static final String ORIENTATION_LANDSCAPE = "landscape";
    private static final String ORIENTATION_VERTICAL = "vertical";
    private static final String TAG = "BlockAdManager";
    private static BlockAdManager mInstance;
    private WeakHashMap<Integer, BlockAdView> blockAdViewMap = new WeakHashMap<>();
    private HashMap<Integer, BlockAdInfo> blockAdInfoHashMap = new HashMap<>();
    private float mGameDensity = -1.0f;
    private int mGameWidth = 0;
    private int mGameHeight = 0;

    BlockAdManager() {
    }

    public static BlockAdManager getInstance() {
        if (mInstance == null) {
            mInstance = new BlockAdManager();
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public LifecycleOwner getLifecycleOwner(Context context) {
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        return null;
    }

    public void destroyBlockAdView(int i3) {
        if (getBlockAdView(i3) != null) {
            this.blockAdViewMap.remove(Integer.valueOf(i3));
        }
        if (getBlockAdInfo(i3) != null) {
            this.blockAdInfoHashMap.remove(Integer.valueOf(i3));
        }
    }

    public int gameDpTopx(float f16) {
        float f17 = this.mGameDensity;
        if (f17 > 0.0f) {
            return Math.round(f16 * f17);
        }
        return Math.round(f16 * getDensity());
    }

    public BlockAdInfo getBlockAdInfo(int i3) {
        return this.blockAdInfoHashMap.get(Integer.valueOf(i3));
    }

    public BlockAdView getBlockAdView(int i3) {
        WeakHashMap<Integer, BlockAdView> weakHashMap = this.blockAdViewMap;
        if (weakHashMap == null || !weakHashMap.containsKey(Integer.valueOf(i3)) || this.blockAdViewMap.get(Integer.valueOf(i3)) == null) {
            return null;
        }
        return this.blockAdViewMap.get(Integer.valueOf(i3));
    }

    public float getDensity() {
        if (this.mGameDensity == -1.0f) {
            this.mGameDensity = ViewUtils.getDensity();
        }
        return this.mGameDensity;
    }

    public int getGameHeight() {
        if (this.mGameHeight == 0) {
            this.mGameHeight = ViewUtils.getScreenHeight();
        }
        return this.mGameHeight;
    }

    public int getGameWidth() {
        if (this.mGameWidth == 0) {
            this.mGameWidth = ViewUtils.getScreenWidth();
        }
        return this.mGameWidth;
    }

    public ArrayList<String> getReportUrlList(List<GdtAd> list) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        PBStringField pBStringField;
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (GdtAd gdtAd : list) {
                if (gdtAd != null && (adInfo = gdtAd.info) != null && (reportInfo = adInfo.report_info) != null && (pBStringField = reportInfo.exposure_url) != null) {
                    arrayList.add(pBStringField.get());
                }
            }
        }
        return arrayList;
    }

    public void hideAllBlockAdView() {
        Iterator<BlockAdView> it = this.blockAdViewMap.values().iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        this.blockAdViewMap.clear();
        this.blockAdInfoHashMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroy() {
        QLog.d(TAG, 1, "destroy");
        WeakHashMap<Integer, BlockAdView> weakHashMap = this.blockAdViewMap;
        if (weakHashMap != null) {
            for (Map.Entry<Integer, BlockAdView> entry : weakHashMap.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().destroy();
                }
            }
            this.blockAdViewMap.clear();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:5|(8:6|7|9|10|12|13|15|16)|(1:18)(2:35|(1:37)(5:38|20|21|22|(2:30|31)(2:28|29)))|19|20|21|22|(0)|30|31) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BlockAdInfo parseBlockAdInfoFromJson(String str) {
        int i3;
        int i16;
        int i17;
        int i18;
        String str2;
        JSONObject jSONObject;
        String optString;
        int i19;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = "";
        int i26 = -1;
        try {
            jSONObject = new JSONObject(str);
            str3 = jSONObject.getString("adUnitId");
            i16 = jSONObject.getJSONObject("style").getInt("left");
            try {
                i3 = jSONObject.getJSONObject("style").getInt("top");
                try {
                    i17 = jSONObject.optInt("size", 1);
                    try {
                        optString = jSONObject.optString("orientation", "landscape");
                    } catch (Exception e16) {
                        e = e16;
                        i18 = -1;
                    }
                } catch (Exception e17) {
                    e = e17;
                    i17 = -1;
                    i18 = i17;
                    QLog.i(TAG, 2, "parseBannerAdPosInfoFromJson error " + str, e);
                    int i27 = i3;
                    str2 = str3;
                    int i28 = i16;
                    int i29 = i17;
                    int i36 = i18;
                    if (TextUtils.isEmpty(str2)) {
                    }
                    return null;
                }
            } catch (Exception e18) {
                e = e18;
                i3 = -1;
                i17 = -1;
            }
        } catch (Exception e19) {
            e = e19;
            i3 = -1;
            i16 = -1;
            i17 = -1;
        }
        if ("landscape".equals(optString)) {
            i19 = 90;
        } else {
            if (!"vertical".equals(optString)) {
                i18 = -1;
                i26 = jSONObject.getInt("compId");
                int i272 = i3;
                str2 = str3;
                int i282 = i16;
                int i292 = i17;
                int i362 = i18;
                if (!TextUtils.isEmpty(str2) || i282 < 0 || i272 < 0 || i26 < 0 || i362 < 0) {
                    return null;
                }
                BlockAdInfo blockAdInfo = new BlockAdInfo(str2, i282, i272, i292, i362, i26);
                this.blockAdInfoHashMap.put(Integer.valueOf(i26), blockAdInfo);
                return blockAdInfo;
            }
            i19 = 0;
        }
        i18 = i19;
        i26 = jSONObject.getInt("compId");
        int i2722 = i3;
        str2 = str3;
        int i2822 = i16;
        int i2922 = i17;
        int i3622 = i18;
        if (TextUtils.isEmpty(str2)) {
        }
        return null;
    }

    public void initActivitySize(Activity activity) {
        if (activity == null) {
            return;
        }
        if (this.mGameDensity <= 0.0f || this.mGameWidth <= 0 || this.mGameHeight <= 0) {
            activity.getResources().getDisplayMetrics();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            this.mGameDensity = displayMetrics.density;
            this.mGameWidth = displayMetrics.widthPixels;
            this.mGameHeight = displayMetrics.heightPixels;
            if (activity.getResources().getConfiguration().orientation == 2) {
                int i3 = this.mGameHeight;
                int i16 = this.mGameWidth;
                if (i3 > i16) {
                    this.mGameHeight = i16;
                    this.mGameWidth = i3;
                }
            } else {
                int i17 = this.mGameWidth;
                int i18 = this.mGameHeight;
                if (i17 > i18) {
                    this.mGameHeight = i17;
                    this.mGameWidth = i18;
                }
            }
            QLog.i(TAG, 1, "density = " + displayMetrics.density + ", ViewUtils.density = " + ViewUtils.getDensity() + ", screenW = " + this.mGameWidth + ", screenH = " + this.mGameHeight);
        }
    }

    public BlockAdView genarateBlockAdView(final Context context, BlockAdInfo blockAdInfo) {
        if (blockAdInfo == null) {
            return null;
        }
        BlockAdView blockAdView = new BlockAdView(context, blockAdInfo.getOri() == 90);
        blockAdView.setData(blockAdInfo);
        this.blockAdViewMap.put(Integer.valueOf(blockAdInfo.getCompId()), blockAdView);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.BlockAdManager.1
            @Override // java.lang.Runnable
            public void run() {
                LifecycleOwner lifecycleOwner = BlockAdManager.this.getLifecycleOwner(context);
                if (lifecycleOwner != null) {
                    lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.mobileqq.minigame.manager.BlockAdManager.1.1
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public void onDestroy() {
                            BlockAdManager.this.destroy();
                        }
                    });
                }
            }
        });
        return blockAdView;
    }
}
