package com.tenpay.sdk.FingerNet;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.wrapper.wrap_net.ISoterNetCallback;
import com.tencent.soter.wrapper.wrap_net.IWrapGetSupportNet;
import com.tenpay.api.QFuncProxy;
import com.tenpay.impl.ApiFingerImpl;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.paynet.Net;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.util.MD5;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GetSupportSoterNet extends FingerNetBase implements IWrapGetSupportNet {
    private static final String TAG = "GetSupportSoterNet";
    public static SoterSupportRes sSupportResCache;
    private ISoterNetCallback<IWrapGetSupportNet.GetSupportResult> mCallback;
    private String mUin;
    private JSONObject netData;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SoterSupportRes {
        public int soter_open_busi_type;
        public String soter_suggest_info;
        public String soter_suggest_title;
        public List<Integer> supportTypes;

        public SoterSupportRes(String str, String str2, List<Integer> list, int i3) {
            this.soter_suggest_title = str;
            this.soter_suggest_info = str2;
            this.supportTypes = list;
            this.soter_open_busi_type = i3;
        }
    }

    public GetSupportSoterNet(Context context, Map<String, String> map) {
        super(context, map);
        this.mCallback = null;
    }

    private static String getSuggestTitle(List<Integer> list) {
        StringBuilder sb5 = new StringBuilder();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                String nameByBusiType = QWSoterConstans.getNameByBusiType(list.get(i3).intValue());
                if (!TextUtils.isEmpty(nameByBusiType)) {
                    if (i3 != 0) {
                        sb5.append("/");
                    }
                    sb5.append(nameByBusiType);
                }
            }
        }
        if (!TextUtils.isEmpty(sb5.toString())) {
            sb5.append("\u652f\u4ed8");
        }
        return sb5.toString();
    }

    private List<Integer> getSupportTypes(String str) {
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split("\\|")) {
                try {
                    int parseInt = Integer.parseInt(str2);
                    if (SoterCore.isSupportBiometric(this.mContext, QWSoterConstans.getBiometricType(parseInt))) {
                        linkedList.add(Integer.valueOf(parseInt));
                    }
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "", th5);
                }
            }
        }
        return linkedList;
    }

    private boolean isOpenTypeValid(List<Integer> list, int i3, int i16) {
        if (i3 == i16 && SoterCore.isSystemHasBiometric(this.mContext, QWSoterConstans.getBiometricType(i16)) && list != null) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                if (i3 == it.next().intValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSopportSoter(JSONObject jSONObject) {
        boolean z16;
        boolean z17;
        boolean z18;
        jSONObject.optString("soter_suggest_title");
        String optString = jSONObject.optString("soter_suggest_info");
        String optString2 = jSONObject.optString("soter_support_type");
        int optInt = jSONObject.optInt("soter_open_busi_type");
        int optInt2 = jSONObject.optInt("soter_state");
        List<Integer> supportTypes = getSupportTypes(optString2);
        boolean isSupportTypeValid = isSupportTypeValid(supportTypes);
        int curSoterBusiType = SharedHelper.getCurSoterBusiType(this.mUin);
        boolean z19 = false;
        if (isSupportTypeValid && isOpenTypeValid(supportTypes, optInt, curSoterBusiType)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (optInt2 != 0 && optInt2 != 1 && optInt2 != 2 && optInt2 != 5 && optInt2 != 6 && optInt2 != 7) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (isSupportTypeValid && z16 && !z17) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            new ApiFingerImpl().closeFingerPay(this.mContext, this.mUin);
        }
        if (isSupportTypeValid && optInt2 != 1 && optInt2 != 0 && optInt2 != 5) {
            z19 = true;
        }
        if (z19) {
            sSupportResCache = new SoterSupportRes(getSuggestTitle(supportTypes), optString, supportTypes, optInt);
        }
        QLog.i(TAG, 1, "GetSupportSoterNet isSupportSoter - ,isInitSucc=" + z19 + ",isSupportTypeValid=" + isSupportTypeValid + ",curLocalOpenType=" + curSoterBusiType + ",isOpenTypeValid=" + z16 + ",isCanNotSoterPayState=" + z17 + ",isNeedCloseSoterPay=" + z18 + ",supportTypes=" + supportTypes);
        return z19;
    }

    private boolean isSupportTypeValid(List<Integer> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (!QWSoterConstans.isValidBusiType(it.next().intValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tenpay.sdk.FingerNet.FingerNetBase, com.tencent.soter.wrapper.wrap_net.ISoterNetBaseWrapper
    public void execute() {
        JSONObject jSONObject = this.netData;
        if (jSONObject == null) {
            super.execute();
            return;
        }
        ISoterNetCallback<IWrapGetSupportNet.GetSupportResult> iSoterNetCallback = this.mCallback;
        if (iSoterNetCallback != null) {
            iSoterNetCallback.onNetEnd(new IWrapGetSupportNet.GetSupportResult(isSopportSoter(jSONObject)));
        }
    }

    @Override // com.tenpay.sdk.FingerNet.FingerNetBase
    protected String getNetUrl() {
        return Cgi.URI_Soter_FINGER_PAY_CHECK;
    }

    @Override // com.tenpay.sdk.FingerNet.FingerNetBase, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        ISoterNetCallback<IWrapGetSupportNet.GetSupportResult> iSoterNetCallback = this.mCallback;
        if (iSoterNetCallback != null) {
            iSoterNetCallback.onNetEnd(new IWrapGetSupportNet.GetSupportResult(false));
        }
    }

    @Override // com.tenpay.sdk.FingerNet.FingerNetBase, com.tenpay.sdk.paynet.Net.NetListener
    public void onError(String str, JSONObject jSONObject) {
        ISoterNetCallback<IWrapGetSupportNet.GetSupportResult> iSoterNetCallback = this.mCallback;
        if (iSoterNetCallback != null) {
            iSoterNetCallback.onNetEnd(new IWrapGetSupportNet.GetSupportResult(false));
        }
        super.onError(str, jSONObject);
    }

    @Override // com.tenpay.sdk.FingerNet.FingerNetBase, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        ISoterNetCallback<IWrapGetSupportNet.GetSupportResult> iSoterNetCallback = this.mCallback;
        if (iSoterNetCallback != null) {
            iSoterNetCallback.onNetEnd(new IWrapGetSupportNet.GetSupportResult(isSopportSoter(jSONObject)));
        }
        super.onSuccess(str, jSONObject);
    }

    @Override // com.tencent.soter.wrapper.wrap_net.ISoterNetBaseWrapper
    public void setCallback(ISoterNetCallback<IWrapGetSupportNet.GetSupportResult> iSoterNetCallback) {
        this.mCallback = iSoterNetCallback;
    }

    @Override // com.tencent.soter.wrapper.wrap_net.ISoterNetBaseWrapper
    public void setRequest(IWrapGetSupportNet.GetSupportRequest getSupportRequest) {
        Map<String, String> map = this.mRequestMap;
        if (map != null) {
            String str = map.get("uin");
            this.mUin = str;
            if (SharedHelper.soterOpen(str)) {
                this.mRequestMap.put(QWSoterConstans.CGI_KEY_BUSI_TYPE, SharedHelper.getCurSoterBusiType(this.mUin) + "");
            }
            this.mRequestMap.put("device_id", MD5.hexdigest(QFuncProxy.getDeviceId(this.mContext)));
            this.mRequestMap.put("model_xml", getSupportRequest.requestJson);
        }
    }

    public GetSupportSoterNet(Context context, Map<String, String> map, WeakReference<Net.NetListener> weakReference) {
        super(context, map, weakReference);
        this.mCallback = null;
    }

    public GetSupportSoterNet(Context context, String str, JSONObject jSONObject) {
        super(context);
        this.mCallback = null;
        this.netData = jSONObject;
        this.mUin = str;
    }
}
