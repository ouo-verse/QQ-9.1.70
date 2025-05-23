package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.manager.VoIPManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.annotation.JsonORM;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xd32$XmitInfo;

@JsPlugin
/* loaded from: classes23.dex */
public class VoIPJsPlugin extends BaseJsPlugin {
    private static final String API_EXIT_VOIP_CHAT = "exitVoIPChat";
    private static final String API_JOIN_VOIP_CHAT = "joinVoIPChat";
    private static final String API_ON_VOIP_CHAT_INTERRUPTED = "onVoIPChatInterrupted";
    private static final String API_ON_VOIP_CHAT_MEMBER_CHANGED = "onVoIPChatMembersChanged";
    private static final String API_ON_VOIP_CHAT_SPEAKERS_CHANGED = "onVoIPChatSpeakersChanged";
    private static final String API_UPDATE_VOIP_CHAT_MUTE_CONFIG = "updateVoIPChatMuteConfig";
    public static final String TAG = "[mini] VoIPJsPlugin";
    private volatile boolean mJoinRoomAllowed = true;

    private byte[] getSig(String str, VoIPManager.RoomConfig roomConfig) {
        oidb_0xd32$XmitInfo oidb_0xd32_xmitinfo = new oidb_0xd32$XmitInfo();
        oidb_0xd32_xmitinfo.str_appid.set(str);
        oidb_0xd32_xmitinfo.str_groupid.set(roomConfig.groupId);
        oidb_0xd32_xmitinfo.str_nonce.set(roomConfig.nonceStr);
        oidb_0xd32_xmitinfo.uint32_timestamp.set(roomConfig.timeStamp);
        oidb_0xd32_xmitinfo.str_signature.set(roomConfig.signature);
        return oidb_0xd32_xmitinfo.toByteArray();
    }

    private boolean isRoomConfigValid(VoIPManager.RoomConfig roomConfig) {
        if (!TextUtils.isEmpty(roomConfig.nonceStr) && !TextUtils.isEmpty(roomConfig.groupId) && !TextUtils.isEmpty(roomConfig.signature) && roomConfig.timeStamp > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void joinRoom(VoIPManager.IdResult idResult, VoIPManager.RoomConfig roomConfig, final RequestEvent requestEvent) {
        if (!this.mJoinRoomAllowed) {
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null, "not allow to joinRoom when pausing").toString());
        } else {
            VoIPManager.getInstance().joinRoom(idResult, roomConfig.muteConfig, getSig(this.mMiniAppContext.getMiniAppInfo().appId, roomConfig), new VoIPManager.JoinRoomListener() { // from class: com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.3
                @Override // com.tencent.qqmini.sdk.core.manager.VoIPManager.JoinRoomListener
                public void onError(int i3) {
                    QMLog.e(VoIPJsPlugin.TAG, "onError errCode:" + i3);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i3);
                        jSONObject.put("errMsg", i3);
                    } catch (JSONException e16) {
                        QMLog.e(VoIPJsPlugin.TAG, "JSONException", e16);
                    }
                    RequestEvent requestEvent2 = requestEvent;
                    requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, ApiUtil.wrapCallbackFail(requestEvent2.event, jSONObject).toString());
                }

                @Override // com.tencent.qqmini.sdk.core.manager.VoIPManager.JoinRoomListener
                public void onJoinRoom(JSONArray jSONArray) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("openIdList", jSONArray);
                        jSONObject.put("errCode", 0);
                    } catch (JSONException e16) {
                        QMLog.e(VoIPJsPlugin.TAG, "JSONException", e16);
                    }
                    RequestEvent requestEvent2 = requestEvent;
                    requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, ApiUtil.wrapCallbackOk(requestEvent2.event, jSONObject).toString());
                    VoIPManager.getInstance().setEventListener(new VoIPManager.EventListener() { // from class: com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.3.1
                        @Override // com.tencent.qqmini.sdk.core.manager.VoIPManager.EventListener
                        public void onInterrupt(int i3, String str) {
                            QMLog.e(VoIPJsPlugin.TAG, "onInterrupt errCode:" + i3 + ", errMsg:" + str);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("errCode", i3);
                                jSONObject2.put("errMsg", str);
                            } catch (JSONException e17) {
                                QMLog.e(VoIPJsPlugin.TAG, "JSONException", e17);
                            }
                            requestEvent.jsService.evaluateSubscribeJS(VoIPJsPlugin.API_ON_VOIP_CHAT_INTERRUPTED, jSONObject2.toString(), 0);
                        }

                        @Override // com.tencent.qqmini.sdk.core.manager.VoIPManager.EventListener
                        public void onRoomMemberChange(JSONArray jSONArray2) {
                            QMLog.d(VoIPJsPlugin.TAG, "RoomMemberChange:" + jSONArray2.toString());
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("openIdList", jSONArray2);
                                jSONObject2.put("errCode", 0);
                            } catch (JSONException e17) {
                                QMLog.e(VoIPJsPlugin.TAG, "JSONException", e17);
                            }
                            requestEvent.jsService.evaluateSubscribeJS(VoIPJsPlugin.API_ON_VOIP_CHAT_MEMBER_CHANGED, jSONObject2.toString(), 0);
                        }

                        @Override // com.tencent.qqmini.sdk.core.manager.VoIPManager.EventListener
                        public void onRoomMemberSpeaking(JSONArray jSONArray2) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("openIdList", jSONArray2);
                                jSONObject2.put("errCode", 0);
                            } catch (JSONException e17) {
                                QMLog.e(VoIPJsPlugin.TAG, "JSONException", e17);
                            }
                            requestEvent.jsService.evaluateSubscribeJS(VoIPJsPlugin.API_ON_VOIP_CHAT_SPEAKERS_CHANGED, jSONObject2.toString(), 0);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VoIPManager.IdResult parseIdResult(JSONObject jSONObject) {
        return (VoIPManager.IdResult) new JSONParser().parse(jSONObject, VoIPManager.IdResult.class);
    }

    private VoIPManager.RoomConfig parseRoomConfig(String str) {
        return (VoIPManager.RoomConfig) new JSONParser().parse(str, VoIPManager.RoomConfig.class);
    }

    private void transForRoodId(final RequestEvent requestEvent, final VoIPManager.RoomConfig roomConfig, String str) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).transForRoomId(this.mMiniAppContext.getMiniAppInfo().appId, str, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                String str2;
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(z16);
                String str3 = "";
                if (jSONObject == null) {
                    str2 = "";
                } else {
                    str2 = jSONObject.toString();
                }
                objArr[1] = str2;
                QMLog.i(VoIPJsPlugin.TAG, String.format("succ: %s ret:%s", objArr));
                String str4 = VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_INTERNAL_ERROR;
                if (z16) {
                    VoIPManager.IdResult parseIdResult = VoIPJsPlugin.this.parseIdResult(jSONObject);
                    if (parseIdResult == null) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("idResult null ");
                        if (jSONObject != null) {
                            str3 = jSONObject.toString();
                        }
                        sb5.append(str3);
                        QMLog.e(VoIPJsPlugin.TAG, sb5.toString());
                        try {
                            new JSONObject().put("errCode", -1000);
                        } catch (JSONException e16) {
                            QMLog.e(VoIPJsPlugin.TAG, "JSONException", e16);
                        }
                        RequestEvent requestEvent2 = requestEvent;
                        IJsService iJsService = requestEvent2.jsService;
                        int i3 = requestEvent2.callbackId;
                        String str5 = requestEvent2.event;
                        if (jSONObject != null) {
                            str4 = jSONObject.optString("errMsg", "idResult failed");
                        }
                        iJsService.evaluateCallbackJs(i3, ApiUtil.wrapCallbackFail(str5, null, str4).toString());
                        return;
                    }
                    VoIPManager.RoomConfig roomConfig2 = roomConfig;
                    if (roomConfig2.muteConfig != null) {
                        VoIPJsPlugin.this.joinRoom(parseIdResult, roomConfig2, requestEvent);
                        return;
                    }
                    QMLog.e(VoIPJsPlugin.TAG, "muteConfig null " + requestEvent.jsonParams);
                    try {
                        new JSONObject().put("errCode", -1000);
                    } catch (JSONException e17) {
                        QMLog.e(VoIPJsPlugin.TAG, "JSONException", e17);
                    }
                    RequestEvent requestEvent3 = requestEvent;
                    IJsService iJsService2 = requestEvent3.jsService;
                    int i16 = requestEvent3.callbackId;
                    String str6 = requestEvent3.event;
                    if (jSONObject != null) {
                        str4 = jSONObject.optString("errMsg", "muteConfig failed");
                    }
                    iJsService2.evaluateCallbackJs(i16, ApiUtil.wrapCallbackFail(str6, null, str4).toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("errCode", -1000);
                } catch (JSONException e18) {
                    QMLog.e(VoIPJsPlugin.TAG, "JSONException", e18);
                }
                RequestEvent requestEvent4 = requestEvent;
                IJsService iJsService3 = requestEvent4.jsService;
                int i17 = requestEvent4.callbackId;
                String str7 = requestEvent4.event;
                if (jSONObject != null) {
                    str4 = jSONObject.optString("errMsg", "transfer roomId err");
                }
                iJsService3.evaluateCallbackJs(i17, ApiUtil.wrapCallbackFail(str7, jSONObject2, str4).toString());
            }
        });
    }

    @JsEvent({API_EXIT_VOIP_CHAT})
    public String exitVoIPChat(RequestEvent requestEvent) {
        VoIPManager.getInstance().exitRoom();
        requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(requestEvent.event, new JSONObject()).toString());
        return "";
    }

    @JsEvent({"joinVoIPChat"})
    public String joinVoIPChat(RequestEvent requestEvent) {
        VoIPManager.RoomConfig parseRoomConfig;
        try {
            parseRoomConfig = parseRoomConfig(requestEvent.jsonParams);
        } catch (Throwable th5) {
            QMLog.e(TAG, "joinVoIPChat internal error", th5);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", -1000);
            } catch (JSONException e16) {
                QMLog.e(TAG, "JSONException", e16);
            }
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_INTERNAL_ERROR).toString());
        }
        if (parseRoomConfig == null) {
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null, "param error").toString());
            return "";
        }
        if (!isRoomConfigValid(parseRoomConfig)) {
            QMLog.e(TAG, "isRoomConfigValid false");
            try {
                new JSONObject().put("errCode", -5);
            } catch (JSONException e17) {
                QMLog.e(TAG, "JSONException", e17);
            }
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null, "invalid parameters").toString());
            return "";
        }
        transForRoodId(requestEvent, parseRoomConfig, parseRoomConfig.groupId);
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        this.mJoinRoomAllowed = false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onPause() {
        this.mJoinRoomAllowed = false;
        if (VoIPManager.getInstance().isInRoom()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", 2);
                jSONObject.put("errMsg", "\u8fdb\u5165\u540e\u53f0\u6216\u5173\u95ed");
            } catch (JSONException e16) {
                QMLog.e(TAG, "JSONException", e16);
            }
            sendSubscribeEvent(API_ON_VOIP_CHAT_INTERRUPTED, jSONObject.toString());
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                VoIPManager.getInstance().exitRoom();
                VoIPManager.getInstance().setEventListener(null);
            }
        });
        super.onPause();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onResume() {
        super.onResume();
        this.mJoinRoomAllowed = true;
    }

    @JsEvent({API_UPDATE_VOIP_CHAT_MUTE_CONFIG})
    public String updateVoIPChatMuteConfig(final RequestEvent requestEvent) {
        VoIPManager.RoomConfig parseRoomConfig = parseRoomConfig(requestEvent.jsonParams);
        final JSONObject jSONObject = new JSONObject();
        if (parseRoomConfig != null && parseRoomConfig.muteConfig != null) {
            VoIPManager.getInstance().updateMuteConfig(parseRoomConfig.muteConfig, new VoIPManager.MuteConfigListener() { // from class: com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.1
                @Override // com.tencent.qqmini.sdk.core.manager.VoIPManager.MuteConfigListener
                public void onFail(int i3) {
                    try {
                        jSONObject.put("errCode", i3);
                    } catch (JSONException e16) {
                        QMLog.e(VoIPJsPlugin.TAG, "\u53c2\u6570\u9519\u8bef " + requestEvent.jsonParams, e16);
                    }
                    RequestEvent requestEvent2 = requestEvent;
                    requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, ApiUtil.wrapCallbackFail(requestEvent2.event, jSONObject, "\u72b6\u6001\u9519\u8bef").toString());
                }

                @Override // com.tencent.qqmini.sdk.core.manager.VoIPManager.MuteConfigListener
                public void onSuccess() {
                    try {
                        jSONObject.put("muteMicrophone", VoIPManager.getInstance().isMicMute());
                        jSONObject.put("muteEarphone", VoIPManager.getInstance().isEarPhoneMute());
                    } catch (JSONException e16) {
                        QMLog.e(VoIPJsPlugin.TAG, "\u53c2\u6570\u9519\u8bef " + requestEvent.jsonParams, e16);
                    }
                    RequestEvent requestEvent2 = requestEvent;
                    requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, ApiUtil.wrapCallbackOk(requestEvent2.event, jSONObject).toString());
                }
            });
            return "";
        }
        requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR).toString());
        QMLog.e(TAG, "\u53c2\u6570\u9519\u8bef " + requestEvent.jsonParams);
        return "";
    }

    /* loaded from: classes23.dex */
    public static class JSONParser<T> {
        public T parse(String str, Class<T> cls) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    try {
                        return (T) JsonORM.parseFrom(new JSONObject(str), cls);
                    } catch (Exception e16) {
                        QMLog.e(VoIPJsPlugin.TAG, "JSONParser error! failed parse to " + cls, e16);
                    }
                } catch (JSONException e17) {
                    QMLog.e(VoIPJsPlugin.TAG, "JSONParser error! not a valid JSON " + str, e17);
                    return null;
                }
            } else {
                QMLog.e(VoIPJsPlugin.TAG, "JSON is empty");
            }
            return null;
        }

        public T parse(JSONObject jSONObject, Class<T> cls) {
            if (jSONObject != null) {
                try {
                    return (T) JsonORM.parseFrom(jSONObject, cls);
                } catch (Exception e16) {
                    QMLog.e(VoIPJsPlugin.TAG, "JsonORM error! failed parse to " + cls, e16);
                    return null;
                }
            }
            QMLog.e(VoIPJsPlugin.TAG, "JSON obj is empty");
            return null;
        }
    }
}
