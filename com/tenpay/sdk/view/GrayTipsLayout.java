package com.tenpay.sdk.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tenpay.api.QFuncProxy;
import com.tenpay.sdk.activity.TenpayUtilActivity;
import com.tenpay.sdk.util.ImageDownLoader;
import com.tenpay.sdk.util.OnGetResult;
import com.tenpay.sdk.util.UinConfigManager;
import com.tenpay.util.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GrayTipsLayout extends RelativeLayout {
    private boolean isClickDestroy;
    private String mADS_ID;
    private String mAllConfigname;
    private ImageView mArrowView;
    private ImageView mLeftImageView;
    private Context mOutActivity;
    private TextView mText;
    private int mUIMode;
    private String mUin;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class GetImageTask implements OnGetResult, Runnable {
        private Bitmap mBitmap;
        private WeakReference<GrayTipsLayout> mLayoutRef;

        public GetImageTask(GrayTipsLayout grayTipsLayout) {
            this.mLayoutRef = new WeakReference<>(grayTipsLayout);
        }

        @Override // com.tenpay.sdk.util.OnGetResult
        public void getResult(Object obj) {
            GrayTipsLayout grayTipsLayout;
            if (obj != null && (obj instanceof Bitmap) && (grayTipsLayout = this.mLayoutRef.get()) != null) {
                this.mBitmap = (Bitmap) obj;
                grayTipsLayout.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            GrayTipsLayout grayTipsLayout = this.mLayoutRef.get();
            if (grayTipsLayout != null && (bitmap = this.mBitmap) != null) {
                grayTipsLayout.setBitmapImage(bitmap);
            }
        }
    }

    public GrayTipsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isClickDestroy = false;
        this.mUIMode = 0;
        initView(context);
    }

    private void displayUI(JSONObject jSONObject, String str, String str2, Activity activity) {
        String optString = jSONObject.optString("id");
        setADS_ID(optString);
        this.mUin = str2;
        String optString2 = jSONObject.optString("title");
        if (!TextUtils.isEmpty(optString2)) {
            this.mText.setText(optString2);
        }
        String optString3 = jSONObject.optString("url");
        setClickDestroy(false);
        if (!TextUtils.isEmpty(optString3)) {
            setUrl(optString3, activity);
            if (jSONObject.optInt(UinConfigManager.KEY_ADS_HB_CLICK_DISAPPEAR) == 1) {
                setClickDestroy(true);
            }
        } else {
            setUrl(null, null);
        }
        if (1 == this.mUIMode) {
            String optString4 = jSONObject.optString("image");
            if (!TextUtils.isEmpty(optString4)) {
                this.mLeftImageView.setVisibility(4);
                new ImageDownLoader(getContext()).setImage(optString4, new GetImageTask(this));
            }
            this.mArrowView.setVisibility(8);
        }
        UinConfigManager.incDispCount(getContext(), str, str2, optString);
    }

    private JSONObject getAvailItem(List<JSONObject> list, String str, String str2) {
        int size = list.size();
        long currentTimeMillis = System.currentTimeMillis();
        for (int i3 = 0; i3 < size; i3++) {
            JSONObject jSONObject = list.get(i3);
            if (currentTimeMillis >= jSONObject.optLong("start_time") * 1000 && currentTimeMillis <= jSONObject.optLong("end_time") * 1000) {
                String optString = jSONObject.optString("id");
                if (UinConfigManager.getIsClickDisappeared(getContext(), str, str2, optString)) {
                    continue;
                } else {
                    if (UinConfigManager.getDispCount(getContext(), str, str2, optString) >= jSONObject.optInt(UinConfigManager.KEY_ADS_HB_DAILY_NUM)) {
                        continue;
                    } else {
                        String optString2 = jSONObject.optString("url");
                        if (TextUtils.isEmpty(optString2) || UinConfigManager.isTrustDomain(optString2)) {
                            return jSONObject;
                        }
                    }
                }
            }
        }
        return null;
    }

    private ArrayList<JSONObject> getRightAdsItems(List<JSONObject> list, String str, String str2) throws Exception {
        JSONArray jSONArray;
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        Iterator<JSONObject> it = list.iterator();
        while (it.hasNext()) {
            JSONObject optJSONObject = it.next().optJSONObject(str);
            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray(str2)) != null) {
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(jSONArray.getJSONObject(i3));
                }
            }
        }
        return arrayList;
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.ae7, (ViewGroup) this, true);
        setClickable(true);
        this.mText = (TextView) findViewById(R.id.f165739db1);
        this.mArrowView = (ImageView) findViewById(R.id.daz);
        this.mLeftImageView = (ImageView) findViewById(R.id.j6w);
        setBackgroundColor(-1718447470);
        setPadding(Utils.dp2Px(context, 10.0f), 0, Utils.dp2Px(context, 10.0f), 0);
    }

    public String getADS_ID() {
        return this.mADS_ID;
    }

    public boolean handleHbAdsConfig(List<JSONObject> list, String str, String str2, TenpayUtilActivity tenpayUtilActivity) throws Exception {
        ArrayList<JSONObject> rightAdsItems = getRightAdsItems(list, UinConfigManager.KEY_ADS, UinConfigManager.KEY_HB);
        if (rightAdsItems.size() == 0) {
            return false;
        }
        this.mAllConfigname = str;
        JSONObject availItem = getAvailItem(rightAdsItems, str, str2);
        if (availItem == null) {
            return false;
        }
        displayUI(availItem, str, str2, tenpayUtilActivity.getActivity());
        return true;
    }

    public boolean handleQrcodeAdsConfig(List<JSONObject> list, String str, String str2, Activity activity) throws Exception {
        ArrayList<JSONObject> rightAdsItems = getRightAdsItems(list, UinConfigManager.KEY_ADS, UinConfigManager.KEY_QRCODE);
        if (rightAdsItems.size() == 0) {
            return false;
        }
        this.mAllConfigname = str;
        JSONObject availItem = getAvailItem(rightAdsItems, str, str2);
        if (availItem == null) {
            return false;
        }
        displayUI(availItem, str, str2, activity);
        return true;
    }

    public void initUIMode(int i3) {
        if (1 == i3) {
            Context applicationContext = getContext().getApplicationContext();
            this.mText.setTextSize(14.0f);
            setBackgroundColor(0);
            setPadding(Utils.dp2Px(applicationContext, 15.0f), 0, Utils.dp2Px(applicationContext, 15.0f), 0);
        }
        this.mUIMode = i3;
    }

    @Override // android.view.View
    public boolean performClick() {
        Context context;
        if (this.isClickDestroy) {
            UinConfigManager.setIsClickDisappeared(getContext(), this.mAllConfigname, this.mUin, this.mADS_ID);
            setVisibility(8);
        }
        String str = this.mUrl;
        if (str != null && (context = this.mOutActivity) != null) {
            QFuncProxy.gotoH5(context, str, true, true);
        }
        return super.performClick();
    }

    public void setADS_ID(String str) {
        this.mADS_ID = str;
    }

    public void setBitmapImage(Bitmap bitmap) {
        this.mLeftImageView.setVisibility(0);
        this.mLeftImageView.setImageBitmap(bitmap);
    }

    public void setClickDestroy(boolean z16) {
        this.isClickDestroy = z16;
    }

    public void setMarginTop(int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(0, i3, 0, 0);
        setLayoutParams(layoutParams);
    }

    public void setTitle(String str) {
        this.mText.setText(str);
    }

    public void setUrl(String str, Context context) {
        this.mOutActivity = context;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = null;
            this.mArrowView.setVisibility(8);
        } else {
            this.mUrl = str;
            this.mArrowView.setVisibility(0);
        }
    }

    public GrayTipsLayout(Context context) {
        super(context);
        this.isClickDestroy = false;
        this.mUIMode = 0;
        initView(context);
    }
}
