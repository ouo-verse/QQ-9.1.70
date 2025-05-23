package com.qq.e.tg.tangram.action;

import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.constants.LoginType;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.qq.e.comm.pi.ADPLI;
import com.qq.e.comm.pi.TADLDI;
import com.qq.e.comm.pi.TangramHippyCallback;
import com.qq.e.comm.pi.UTI;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.JSONUtilStub;
import com.qq.e.tg.cfg.VideoOption;
import com.qq.e.tg.tangram.ad.TAdRequest;
import com.qq.e.tg.tangram.ad.TangramAdListener;
import com.qq.e.tg.tangram.ad.TangramAdLoader;
import com.qq.e.tg.tangram.module.TangramAd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TangramHippyActionTrigger {

    /* renamed from: a, reason: collision with root package name */
    private TangramAdLoader f40873a;

    /* renamed from: b, reason: collision with root package name */
    private TangramAdActionTrigger f40874b;

    /* renamed from: c, reason: collision with root package name */
    private ADPLI f40875c;

    public TangramHippyActionTrigger(TADLDI tadldi, UTI uti, ADPLI adpli) {
        this.f40873a = new TangramAdLoader(tadldi);
        this.f40874b = new TangramAdActionTrigger(uti);
        this.f40875c = adpli;
    }

    private static LoadAdParams a(JSONObject jSONObject) {
        LoginType loginType;
        if (!JSONUtilStub.notNull(jSONObject)) {
            return null;
        }
        LoadAdParams loadAdParams = new LoadAdParams();
        int optInt = jSONObject.optInt(TangramHippyConstants.LOGIN_TYPE);
        if (optInt == 1) {
            loginType = LoginType.WeiXin;
        } else if (optInt == 2) {
            loginType = LoginType.QQ;
        } else {
            loginType = LoginType.Unknow;
        }
        loadAdParams.setLoginType(loginType);
        loadAdParams.setLoginAppId(jSONObject.optString(TangramHippyConstants.LOGIN_APP_ID));
        loadAdParams.setLoginOpenid(jSONObject.optString(TangramHippyConstants.LOGIN_OPEN_ID));
        loadAdParams.setUin(jSONObject.optString("uin"));
        loadAdParams.setBlockEffectValue(jSONObject.optInt(TangramHippyConstants.BLOCK_EFFECT));
        loadAdParams.setUid(jSONObject.optString(TangramHippyConstants.LOGIN_UID));
        loadAdParams.setExperimentType(jSONObject.optInt(TangramHippyConstants.EXP_TYPE));
        JSONArray optJSONArray = jSONObject.optJSONArray(TangramHippyConstants.EXP_ID);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            String[] strArr = new String[optJSONArray.length()];
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                strArr[i3] = optJSONArray.optString(i3);
            }
            loadAdParams.setExperimentId(strArr);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(TangramHippyConstants.DICTIONARY);
        if (!JSONObject.NULL.equals(optJSONObject)) {
            HashMap hashMap = new HashMap();
            try {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    hashMap.put(obj, optJSONObject.opt(obj));
                }
                loadAdParams.setPassThroughInfo(hashMap);
            } catch (Exception e16) {
                GDTLogger.d(e16.getMessage());
            }
        }
        return loadAdParams;
    }

    public void clickAD(Map<String, Object> map, TangramHippyCallback tangramHippyCallback) {
        JSONObject jSONObject;
        View view;
        TangramAdActionParams tangramAdActionParams;
        if (map.get("params") instanceof JSONObject) {
            jSONObject = (JSONObject) map.get("params");
        } else {
            jSONObject = null;
        }
        if (map.get("view") instanceof View) {
            view = (View) map.get("view");
        } else {
            view = null;
        }
        boolean z16 = false;
        if (jSONObject != null) {
            Object obj = JSONObject.NULL;
            if (!obj.equals(jSONObject) && view != null) {
                String optString = jSONObject.optString(TangramHippyConstants.POSID);
                JSONObject optJSONObject = jSONObject.optJSONObject(TangramHippyConstants.AD_DATA);
                if (!TextUtils.isEmpty(optString) && optJSONObject != null && !obj.equals(optJSONObject)) {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject(TangramHippyConstants.CLICK_CONFIG);
                    if (optJSONObject2 != null && !obj.equals(optJSONObject2)) {
                        tangramAdActionParams = new TangramAdActionParams();
                        VideoOption.Builder builder = new VideoOption.Builder();
                        if (optJSONObject2.optInt(TangramHippyConstants.VIDEO_MUTED) == 1) {
                            z16 = true;
                        }
                        builder.setDetailPageMuted(z16);
                        builder.setCurrentPlayTime(optJSONObject2.optInt(TangramHippyConstants.SEEK_TO_TIME) * 1000);
                        tangramAdActionParams.setVideoOption(builder.build());
                        tangramAdActionParams.setClickPos(optJSONObject2.optInt(TangramHippyConstants.FEEDS_INDEX));
                    } else {
                        tangramAdActionParams = null;
                    }
                    this.f40874b.doClick(optJSONObject.toString(), optString, view, tangramAdActionParams);
                    tangramHippyCallback.onActionSuccess(2, null);
                    return;
                }
                tangramHippyCallback.onActionFailed(2, new Object[]{new AdError(302, "action params are illegal")});
                return;
            }
        }
        GDTLogger.e("get params failed in click ad");
        tangramHippyCallback.onActionFailed(2, new Object[]{new AdError(301, "get params failed")});
    }

    public void handleHippyAction(int i3, Map<String, Object> map, final TangramHippyCallback tangramHippyCallback) {
        JSONObject jSONObject;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    clickAD(map, tangramHippyCallback);
                    return;
                }
                return;
            }
            String str = null;
            if (map.get("params") instanceof JSONObject) {
                jSONObject = (JSONObject) map.get("params");
            } else {
                jSONObject = null;
            }
            if (map.get("appId") instanceof String) {
                str = (String) map.get("appId");
            }
            if (jSONObject != null && !JSONObject.NULL.equals(jSONObject) && !TextUtils.isEmpty(str)) {
                String optString = jSONObject.optString(TangramHippyConstants.POSID);
                int optInt = jSONObject.optInt("count");
                if (TextUtils.isEmpty(optString) || optInt == 0) {
                    GDTLogger.e("params are illegal, appId or posId is empty");
                    tangramHippyCallback.onActionFailed(1, new Object[]{new AdError(202, "appId or posId is empty")});
                }
                this.f40873a.asyncLoad(new TAdRequest.Builder().setAppId(str).setAdCount(optInt).setPosId(optString).setLoadAdParams(a(jSONObject.optJSONObject(TangramHippyConstants.LOAD_AD_PARAMS))).build(), new TangramAdListener() { // from class: com.qq.e.tg.tangram.action.TangramHippyActionTrigger.1
                    @Override // com.qq.e.tg.tangram.ad.TangramAdListener
                    public void onADLoaded(List<TangramAd> list) {
                        GDTLogger.d("onADLoaded");
                        if (list != null && list.size() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            Iterator<TangramAd> it = list.iterator();
                            while (it.hasNext()) {
                                jSONArray.mo162put(it.next().getJsonData());
                            }
                            tangramHippyCallback.onActionSuccess(1, new Object[]{jSONArray});
                        }
                    }

                    @Override // com.qq.e.tg.tangram.ad.TangramAdListener
                    public void onNoAd(AdError adError) {
                        tangramHippyCallback.onActionFailed(1, new Object[]{adError});
                    }

                    @Override // com.qq.e.comm.adevent.ADListener
                    public void onADEvent(ADEvent aDEvent) {
                    }

                    @Override // com.qq.e.tg.tangram.ad.TangramAdListener
                    public void onADStatusChanged(TangramAd tangramAd) {
                    }
                });
                return;
            }
            GDTLogger.e("get params failed in preload ad");
            tangramHippyCallback.onActionFailed(1, new Object[]{new AdError(201, "get params failed")});
            return;
        }
        preloadAD(map, tangramHippyCallback);
    }

    public void preloadAD(Map<String, Object> map, TangramHippyCallback tangramHippyCallback) {
        JSONObject jSONObject;
        if (map.get("params") instanceof JSONObject) {
            jSONObject = (JSONObject) map.get("params");
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            Object obj = JSONObject.NULL;
            if (!obj.equals(jSONObject)) {
                String optString = jSONObject.optString(TangramHippyConstants.POSID);
                JSONObject optJSONObject = jSONObject.optJSONObject(TangramHippyConstants.AD_DATA);
                if (!obj.equals(optJSONObject) && !TextUtils.isEmpty(optString)) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.mo162put(optJSONObject);
                    this.f40875c.preloadAfterAdLoaded(jSONArray, optString);
                    tangramHippyCallback.onActionSuccess(0, null);
                    return;
                }
                GDTLogger.e("preloadAfterAdLoaded params invalid. adData or posId is null");
                tangramHippyCallback.onActionFailed(0, new Object[]{new AdError(102, "adData or posId is null")});
                return;
            }
        }
        GDTLogger.e("get params failed in preload ad");
        tangramHippyCallback.onActionFailed(0, new Object[]{new AdError(101, "get params failed")});
    }
}
