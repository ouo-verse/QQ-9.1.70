package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WalletHomeReq extends BaseReq {
    public static final int RED_TOUCH_GET = 1;
    public static final int RED_TOUCH_REPORT = 2;
    private static final String TAG = "WalletHomeReq";
    public boolean isAppLoadFinished;
    public String redTouchPath;
    public ArrayList<String> redTouchPaths;
    public int type;

    private static String getContentByAppInfo(BusinessInfoCheckUpdate.AppInfo appInfo) {
        JSONObject jSONObject;
        if (appInfo == null) {
            return "";
        }
        String str = appInfo.buffer.get();
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("msg");
            if (optJSONObject == null) {
                return "";
            }
            Iterator keys = optJSONObject.keys();
            JSONObject jSONObject2 = null;
            String str2 = null;
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                if (!TextUtils.isEmpty(str3) && (jSONObject = optJSONObject.getJSONObject(str3)) != null) {
                    if (str2 != null) {
                        try {
                            if (Integer.valueOf(str3).intValue() > Integer.valueOf(str2).intValue()) {
                            }
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
                            if (str3.length() <= str2.length() && str3.compareTo(str2) <= 0) {
                            }
                        }
                    }
                    str2 = str3;
                    jSONObject2 = jSONObject;
                }
            }
            if (jSONObject2 == null) {
                return "";
            }
            return jSONObject2.optString("content");
        } catch (JSONException e17) {
            QLog.e(TAG, 1, "error msg in qqpay-api module: ", e17);
            return "";
        }
    }

    private static int getRedType(BusinessInfoCheckUpdate.AppInfo appInfo) {
        int i3;
        if (appInfo == null) {
            return -1;
        }
        List<BusinessInfoCheckUpdate.RedTypeInfo> list = appInfo.red_display_info.red_type_info.get();
        if (list.size() <= 0) {
            return -1;
        }
        int i16 = -1;
        for (int i17 = 0; i17 < list.size(); i17++) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = list.get(i17);
            if (redTypeInfo != null && (((i3 = redTypeInfo.red_type.get()) == 3 || i3 == 4 || i3 == 0 || i3 == 15) && (i16 == -1 || i3 == 3 || (i3 == 4 && i16 != 3)))) {
                i16 = i3;
            }
        }
        return i16;
    }

    private JSONObject parseSiteAndAppId(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return new JSONObject();
        }
        String str = appInfo.buffer.get();
        if (str != null && !str.isEmpty()) {
            try {
                return new JSONObject(str);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "parseSiteAndAppId: ", e16);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseReq, cooperation.qwallet.plugin.ipc.BaseIpc
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        int i3 = bundle.getInt("_qwallet_ipc_WalletHomeReq_Type");
        this.type = i3;
        if (i3 == 2) {
            this.redTouchPath = bundle.getString("_qwallet_ipc_WalletHomeReq_RedTouchPath");
        } else {
            this.redTouchPaths = bundle.getStringArrayList("_qwallet_ipc_WalletHomeReq_RedTouchPaths");
        }
        this.isAppLoadFinished = bundle.getBoolean("_qwallet_ipc_WalletHomeReq_isAppLoadFinished");
    }

    protected void getRedTouch(AppRuntime appRuntime) {
        String str;
        String str2;
        IRedTouchManager iRedTouchManager = (IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "");
        ArrayList<QWalletRedTouchInfo> arrayList = new ArrayList<>();
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = iRedTouchManager.getLocalTimeRspBody();
        if (localTimeRspBody == null) {
            onGetRedTouch(null);
            return;
        }
        for (BusinessInfoCheckUpdate.AppInfo appInfo : localTimeRspBody.rptMsgAppInfo.get()) {
            Iterator<String> it = this.redTouchPaths.iterator();
            while (it.hasNext()) {
                if (appInfo.path.get().equals(it.next()) && appInfo.iNewFlag.get() != 0) {
                    int redType = getRedType(appInfo);
                    if (redType == 3 || redType == 5 || redType == 4 || redType == 15) {
                        List<BusinessInfoCheckUpdate.RedTypeInfo> list = appInfo.red_display_info.red_type_info.get();
                        if (list.size() > 0) {
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = list.get(i3);
                                if (redTypeInfo != null && (redTypeInfo.red_type.get() == 3 || redTypeInfo.red_type.get() == 5 || redTypeInfo.red_type.get() == 4 || redType == 15)) {
                                    str = redTypeInfo.red_desc.get();
                                    str2 = redTypeInfo.red_content.get();
                                    break;
                                }
                            }
                        }
                    }
                    str = null;
                    str2 = null;
                    JSONObject parseSiteAndAppId = parseSiteAndAppId(appInfo);
                    arrayList.add(new QWalletRedTouchInfo(appInfo.path.get(), redType, parseSiteAndAppId.optInt("ad_id"), getContentByAppInfo(appInfo), str, str2, parseSiteAndAppId.optInt("site"), parseSiteAndAppId.optInt("appid"), parseSiteAndAppId.optInt("type"), parseSiteAndAppId.optString("content"), parseSiteAndAppId.optString("changeIconUrl"), parseSiteAndAppId.toString()));
                }
            }
        }
        int numRedNumByPath = iRedTouchManager.getNumRedNumByPath("100007.102000", 100);
        if (numRedNumByPath > 0) {
            arrayList.add(new QWalletRedTouchInfo("100007.102000", 5, null, null, numRedNumByPath + ""));
        }
        if (arrayList.size() == 0) {
            onGetRedTouch(null);
        } else {
            onGetRedTouch(arrayList);
        }
    }

    protected void onGetRedTouch(ArrayList<QWalletRedTouchInfo> arrayList) {
        WalletHomeResp walletHomeResp = new WalletHomeResp();
        walletHomeResp.resp = arrayList;
        walletHomeResp.type = this.type;
        walletHomeResp.isAppLoadFinished = this.isAppLoadFinished;
        Bundle bundle = new Bundle();
        walletHomeResp.toBundle(bundle);
        super.doCallback(bundle);
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseReq
    public void onReceive() {
        AppRuntime runtime = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getRuntime();
        if (runtime == null) {
            onGetRedTouch(null);
            return;
        }
        int i3 = this.type;
        if (i3 != 1) {
            if (i3 != 2) {
                onGetRedTouch(null);
                return;
            } else {
                reportRedTouch(runtime);
                return;
            }
        }
        getRedTouch(runtime);
    }

    protected void reportRedTouch(AppRuntime appRuntime) {
        if (appRuntime != null) {
            ((IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(this.redTouchPath);
        }
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseReq, cooperation.qwallet.plugin.ipc.BaseIpc
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putInt("_qwallet_ipc_WalletHomeReq_Type", this.type);
        bundle.putString("_qwallet_ipc_WalletHomeReq_RedTouchPath", this.redTouchPath);
        bundle.putStringArrayList("_qwallet_ipc_WalletHomeReq_RedTouchPaths", this.redTouchPaths);
        bundle.putBoolean("_qwallet_ipc_WalletHomeReq_isAppLoadFinished", this.isAppLoadFinished);
    }
}
