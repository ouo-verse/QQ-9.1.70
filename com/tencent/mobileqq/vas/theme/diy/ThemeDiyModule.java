package com.tencent.mobileqq.vas.theme.diy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.theme.JSONResult;
import com.tencent.mobileqq.vas.theme.ThemeIPCModule;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeDiyModule {
    static final int BG_DEFAULT_POSITION = 1;
    static final int BG_UPLOAD_POSITION = 0;
    public static String[] BUNDLE_PAGE_KEY = {ThemeConstants.BUNDLE_KEY_PAGE_DRAWER, ThemeConstants.BUNDLE_KEY_PAGE_MESSAGE, ThemeConstants.BUNDLE_KEY_PAGE_AIO, ThemeConstants.BUNDLE_KEY_PAGE_FRIEND, ThemeConstants.BUNDLE_KEY_PAGE_DYNAMIC};
    static final String KEY_FCID = "fcID";
    static final String KEY_TYPE = "funcType";
    static final String KEY_URL = "url";
    public static final int PAGE_AIO = 2;
    public static final int PAGE_DYNAMIC = 4;
    public static final int PAGE_FRIEND = 3;
    public static final int PAGE_MSG = 1;
    public static final int PAGE_SETTING = 0;
    static final int TAB_POSITION_BG = 1;
    static final int TAB_POSITION_STYLE = 3;
    private static final String TAG = "ThemeDiyModule";
    static final int THEME_DEFAULT_POSITION = 0;
    static final int TYPE_SVIP = 2;
    static final int TYPE_VIP = 1;
    private AppInterface app;
    private Context context;
    private JSONObject mStyle;
    private ThemeDiyImpl mThemeDiyImpl;
    private SparseArray<String> mPageIndexBgMap = new SparseArray<>();
    private ThemeDIYData[] mThemeDIYData = getDiyData();
    private int mAlbumPageIndex = 0;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface ThemeDiyImpl {
        void callJs(String str, String... strArr);

        void diyThemeSetup(JSONObject jSONObject, String str);

        void downloadBgPic(String str, int i3);

        void startDownload(JSONObject jSONObject, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements QueryCallback<ThemeLocator> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f310929a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f310930b;

        a(JSONObject jSONObject, String str) {
            this.f310929a = jSONObject;
            this.f310930b = str;
        }

        @Override // com.tencent.mobileqq.vas.theme.api.QueryCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void postQuery(ThemeLocator themeLocator) {
            if (themeLocator != null && themeLocator.isUnzipDirExist()) {
                if (ThemeDiyModule.this.mThemeDiyImpl != null) {
                    ThemeDiyModule.this.mThemeDiyImpl.diyThemeSetup(this.f310929a, this.f310930b);
                }
            } else if (ThemeDiyModule.this.mThemeDiyImpl != null) {
                ThemeDiyModule.this.mThemeDiyImpl.startDownload(this.f310929a, this.f310930b);
            }
        }
    }

    public ThemeDiyModule(Context context, AppInterface appInterface) {
        this.context = context;
        this.app = appInterface;
    }

    private static ThemeDIYData[] getDiyData() {
        return new ThemeDIYData[]{new ThemeDIYData(R.drawable.qq_setting_me_bg, AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH, R.color.a5r, AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG, -50, 0), new ThemeDIYData(R.drawable.f162146hb1, AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH, R.color.a5t, AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH_PNG, 50, 1), new ThemeDIYData(R.drawable.skin_chat_background, AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, 0, AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, 0, 2), new ThemeDIYData(R.drawable.f162146hb1, AppConstants.Preferences.THEME_DIY_BG_FRIEND_PATH, R.color.a5t, AppConstants.Preferences.THEME_DIY_BG_FRIEND_PATH_PNG, 50, 3), new ThemeDIYData(R.drawable.skin_chat_background, AppConstants.Preferences.THEME_DIY_BG_DYNAMIC_PATH, R.color.a5t, AppConstants.Preferences.THEME_DIY_BG_DYNAMIC_PATH_PNG, 50, 4)};
    }

    private JSONObject getDiyThemePath(int i3, String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        String str3 = null;
        String str4 = "100";
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
            try {
                jSONObject.put("bgId", "100");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject;
        }
        Object obj = "null";
        String string = ThemeBackground.getSharedPreferences(this.context, this.app.getAccount(), 4).getString(str, "null");
        String str5 = "";
        if (AppConstants.Preferences.THEME_DIY_BG_AIO_PATH.equals(str)) {
            string = ChatBackgroundUtil.getChatBackgroundPath(this.context, this.app.getAccount(), "");
        }
        if ("null".equals(string)) {
            str2 = "100";
        } else {
            str3 = imageFile2Base64(string);
            str2 = ChatBackgroundUtil.getId(string);
        }
        if ("custom".equals(str2) || ThemeBackground.DIY_UPLOAD_BG_ID.equals(str2)) {
            this.mPageIndexBgMap.put(i3, string);
        }
        if ("custom".equals(str2)) {
            str2 = ThemeBackground.DIY_UPLOAD_BG_ID;
        }
        if (!"null".equals(str2)) {
            str4 = str2;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getDiyThemePath id:");
            sb5.append(str4);
            sb5.append(" path:");
            sb5.append(string);
            sb5.append(" base64:");
            if (str3 != null) {
                obj = Integer.valueOf(str3.length());
            }
            sb5.append(obj);
            QLog.i(TAG, 2, sb5.toString());
        }
        try {
            try {
                jSONObject.put("bgId", Integer.parseInt(str4));
            } catch (NumberFormatException e17) {
                e17.fillInStackTrace();
                jSONObject.put("bgId", 100);
            }
            if (str3 != null) {
                str5 = str3;
            }
            jSONObject.put("bgImg", str5);
        } catch (JSONException e18) {
            e18.printStackTrace();
        }
        return jSONObject;
    }

    private static String imageFile2Base64(String str) {
        String str2;
        if (str != null && new File(str).exists()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int width = decodeFile.getWidth() / 180;
            if (width < 1) {
                width = 1;
            }
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(decodeFile, decodeFile.getWidth() / width, decodeFile.getHeight() / width);
            extractThumbnail.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
            decodeFile.recycle();
            extractThumbnail.recycle();
            str2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } else {
            str2 = null;
        }
        if (str2 != null) {
            return "data:image/jpg;base64," + str2;
        }
        return "";
    }

    private void saveTheme(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString("id");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "saveTheme  themeId:" + optString);
        }
        ThemeIPCModule.queryThemeLocation(optString, new a(jSONObject, str));
    }

    private void setDIYData(int i3, String str, String str2, String str3) {
        if (i3 < this.mThemeDIYData.length && i3 >= 0) {
            if (!"100".equals(str) && !ThemeBackground.DIY_UPLOAD_BG_ID.equals(str) && str2 != null && !new File(str2).exists()) {
                this.mThemeDIYData[i3].mSaveStatus = 0;
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "setDIYData download  id:" + str);
                }
                Bundle bundle = new Bundle();
                bundle.putString("id", str);
                bundle.putString("name", String.valueOf(i3));
                bundle.putString("url", str2);
                ThemeDiyImpl themeDiyImpl = this.mThemeDiyImpl;
                if (themeDiyImpl != null) {
                    themeDiyImpl.downloadBgPic(str3, Integer.parseInt(str));
                }
            } else {
                this.mThemeDIYData[i3].mSaveStatus = 5;
            }
            ThemeDIYData themeDIYData = this.mThemeDIYData[i3];
            if (themeDIYData.tryOnBgBigRD == null) {
                themeDIYData.tryOnBgBigRD = new ResData();
            }
            ThemeDIYData themeDIYData2 = this.mThemeDIYData[i3];
            ResData resData = themeDIYData2.tryOnBgBigRD;
            resData.state = 5;
            resData.f310908id = str;
            resData.path = str2;
            if (themeDIYData2.tryOnBgBigOrgRD == null) {
                themeDIYData2.tryOnBgBigOrgRD = new ResData();
            }
            ResData resData2 = this.mThemeDIYData[i3].tryOnBgBigOrgRD;
            resData2.f310908id = str;
            resData2.path = str2;
        }
    }

    public static void setSpThemeBackground(Context context, String str, ThemeDIYData themeDIYData) {
        if (themeDIYData == null) {
            QLog.e(TAG, 1, "sData is null");
            return;
        }
        ResData resData = themeDIYData.tryOnBgBigOrgRD;
        if (resData != null && themeDIYData.tryOnBgBigRD != null && !"100".equals(resData.f310908id)) {
            String str2 = themeDIYData.orgSpKey;
            ResData resData2 = themeDIYData.tryOnBgBigOrgRD;
            ThemeBackground.setThemeBackgroundPic(context, str2, str, resData2.path, resData2.url, resData2.f310908id, "", 1, null, true);
            if (!themeDIYData.orgSpKey.equals(themeDIYData.dealSpkey)) {
                ResData resData3 = themeDIYData.tryOnBgBigRD;
                if (resData3 != null && resData3.state == 5) {
                    String str3 = themeDIYData.dealSpkey;
                    String str4 = resData3.path;
                    ResData resData4 = themeDIYData.tryOnBgBigOrgRD;
                    ThemeBackground.setThemeBackgroundPic(context, str3, str, str4, resData4.url, resData4.f310908id, "", 1, null, true);
                } else {
                    String str5 = themeDIYData.dealSpkey;
                    ResData resData5 = themeDIYData.tryOnBgBigOrgRD;
                    ThemeBackground.setThemeBackgroundPic(context, str5, str, resData5.path, resData5.url, resData5.f310908id, "", 1, null, true);
                }
            }
            if (themeDIYData.position == 2) {
                ChatBackgroundUtil.setChatBackground(context, str, null, themeDIYData.tryOnBgBigOrgRD.path);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setSpThemeBackground sData.tryOnBgBigOrgRD=");
            sb5.append(themeDIYData.tryOnBgBigOrgRD);
            sb5.append(", sData.tryOnBgBigRD=");
            sb5.append(themeDIYData.tryOnBgBigRD);
            sb5.append(", id=");
            ResData resData6 = themeDIYData.tryOnBgBigOrgRD;
            sb5.append(resData6 == null ? "-" : resData6.f310908id);
            sb5.append(", pageIndex:");
            sb5.append(themeDIYData.position);
            QLog.d(TAG, 2, sb5.toString());
        }
        ThemeBackground.setThemeBackgroundPic(context, themeDIYData.dealSpkey, str, "", "", "", "", 1, null, true);
        if (themeDIYData.position == 2) {
            ChatBackgroundUtil.setChatBackground(context, str, null, "null");
        }
    }

    public void albumCallback(String str, String str2) {
        int i3;
        String imageFile2Base64 = imageFile2Base64(str);
        String str3 = "";
        if (imageFile2Base64.equals("")) {
            str3 = HardCodeUtil.qqStr(R.string.u4d);
            i3 = -1;
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "albumCallback path:" + str + " imageBase64:" + imageFile2Base64.length());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i3);
            jSONObject.put("msg", str3);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("image", imageFile2Base64);
            jSONObject2.put("bgPath", str);
            jSONObject2.put("imageSize", imageFile2Base64.length());
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        this.mPageIndexBgMap.put(this.mAlbumPageIndex, str);
        ThemeDiyImpl themeDiyImpl = this.mThemeDiyImpl;
        if (themeDiyImpl != null) {
            themeDiyImpl.callJs(str2, jSONObject.toString());
        }
    }

    public Bundle getAuthReqBundle(String str, String str2) {
        String str3;
        Bundle bundle = new Bundle();
        bundle.putInt("nowOperate", 16);
        bundle.putInt("nextOperate", 10);
        bundle.putString("key_from", ThemeReporter.FROM_DIY);
        int i3 = 0;
        while (true) {
            ThemeDIYData[] themeDIYDataArr = this.mThemeDIYData;
            if (i3 >= themeDIYDataArr.length) {
                break;
            }
            ResData resData = themeDIYDataArr[i3].tryOnBgBigRD;
            if (resData != null) {
                str3 = resData.f310908id;
            } else {
                str3 = "100";
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "backgroundSave, bg save : index = " + i3 + ",id=" + str3);
            }
            if (str3.equals("custom")) {
                str3 = ThemeBackground.DIY_UPLOAD_BG_ID;
            }
            bundle.putString(BUNDLE_PAGE_KEY[i3], str3);
            i3++;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "backgroundSave to save server2.");
        }
        bundle.putString("themeId", str);
        bundle.putString("version", str2);
        return bundle;
    }

    public JSONObject getDiyCurThemeInfo() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("styleId", ThemeUtil.getUserCurrentThemeId(null));
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(getDiyThemePath(0, AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG));
            jSONArray.mo162put(getDiyThemePath(1, AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH_PNG));
            jSONArray.mo162put(getDiyThemePath(2, AppConstants.Preferences.THEME_DIY_BG_AIO_PATH));
            jSONArray.mo162put(getDiyThemePath(3, AppConstants.Preferences.THEME_DIY_BG_FRIEND_PATH_PNG));
            jSONArray.mo162put(getDiyThemePath(4, AppConstants.Preferences.THEME_DIY_BG_DYNAMIC_PATH_PNG));
            jSONObject2.put("bgInfos", jSONArray);
            jSONObject.put("result", 0);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public void openAlbum(Intent intent, Activity activity, int i3, int i16) {
        String account;
        String str;
        this.mAlbumPageIndex = i3;
        AppInterface appInterface = this.app;
        if (appInterface == null) {
            account = "0";
        } else {
            account = appInterface.getAccount();
        }
        String str2 = "99." + i3 + "." + System.currentTimeMillis();
        if (ThemeDiyStyleLogic.isNewCustomBackground) {
            str = ThemeDiyStyleLogic.getNewCustomBackgroundPath();
        } else {
            str = ThemeDiyStyleLogic.getDataDIYDir() + DiySecureFileHelper.secureUin(account) + "/org/" + str2;
        }
        String str3 = str;
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        int width = rect.width();
        int height = rect.height();
        if (i3 != 2) {
            width = (width * 3) / 4;
            height = (height * 3) / 4;
        }
        ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).startPhotoListEditForResult(intent, activity, activity.getClass().getName(), (rect.width() * 4) / 5, (rect.height() * 4) / 5, width, height, str3, i16);
    }

    public void saveDiyTheme(JSONObject jSONObject, String str) {
        String str2;
        String shopBgPath;
        JSONArray optJSONArray = jSONObject.optJSONArray("bgInfos");
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        this.mStyle = optJSONObject;
        if (optJSONObject == null) {
            this.mStyle = new JSONObject();
        }
        if (TextUtils.isEmpty(this.mStyle.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY))) {
            String optString = jSONObject.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    this.mStyle.putOpt(VasCommonJsbProxy.JSON_KEY_SET_KEY, optString);
                } catch (JSONException e16) {
                    QLog.w(TAG, 1, "put setKey fail", e16);
                }
            }
        }
        if (optJSONArray == null) {
            ThemeDiyImpl themeDiyImpl = this.mThemeDiyImpl;
            if (themeDiyImpl != null) {
                themeDiyImpl.callJs(str, new JSONResult(-1, "bginfos is null").toJsonString());
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            try {
                str2 = optJSONArray.getJSONObject(i3).optString("bgId");
            } catch (JSONException e17) {
                e17.printStackTrace();
                str2 = null;
            }
            if (ThemeBackground.DIY_UPLOAD_BG_ID.equals(str2)) {
                shopBgPath = this.mPageIndexBgMap.get(i3);
            } else {
                shopBgPath = ChatBackgroundUtil.getShopBgPath(str2);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "saveDiyTheme  bgId:" + str2 + " bgPath:" + shopBgPath);
            }
            setDIYData(i3, str2, shopBgPath, str);
        }
        trySaveDefineImage(str);
    }

    public void setThemeDiyImpl(ThemeDiyImpl themeDiyImpl) {
        this.mThemeDiyImpl = themeDiyImpl;
    }

    public void trySaveDefineImage(String str) {
        if (str == null) {
            return;
        }
        for (ThemeDIYData themeDIYData : this.mThemeDIYData) {
            ResData resData = themeDIYData.tryOnBgBigRD;
            if (resData != null && themeDIYData.mSaveStatus == 0) {
                String shopBgPath = ChatBackgroundUtil.getShopBgPath(resData.f310908id);
                if (FileUtils.fileExists(shopBgPath)) {
                    themeDIYData.mSaveStatus = 5;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "RES_DATA_STATE_DEALED saveDiyTheme  bgId:" + themeDIYData.tryOnBgBigRD.f310908id + " bgPath:" + shopBgPath);
                        return;
                    }
                    return;
                }
            }
        }
        JSONObject jSONObject = this.mStyle;
        if (jSONObject != null) {
            saveTheme(jSONObject, str);
        }
    }

    public void setSpThemeBackground() {
        try {
            for (ThemeDIYData themeDIYData : this.mThemeDIYData) {
                if (VasNormalToggle.BUG_115132569.isEnable(true)) {
                    VasUtil.getService().getJsbCallManager().setDiyThemeBackground(this.app.getAccount(), themeDIYData);
                } else {
                    setSpThemeBackground(this.context, this.app.getAccount(), themeDIYData);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, QLog.getStackTraceString(e16));
            }
        }
    }
}
