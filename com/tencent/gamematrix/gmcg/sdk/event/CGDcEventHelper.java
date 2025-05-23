package com.tencent.gamematrix.gmcg.sdk.event;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequestAck;
import com.tencent.gamematrix.gmcg.api.GmCgEventShareInfoType;
import com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameShareInfo;
import com.tencent.gamematrix.gmcg.base.helper.CGPersistHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAppLaunchParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAppMonitorRequest;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAppStatusParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventCommonNotifyParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventEnterRoomRequest;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventGameChapterParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventGameLoginStateRequest;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventGameScreenRotateParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventLoginRequestParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventLoginResultParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventObtainMidasConfigRequest;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventPlayerConnectParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventRefreshGameRequest;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventRestartGameRequest;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventSceneCheckParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventSceneCheckRequest;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventSceneMonitorParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventShareInfoParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventSwitchInfoLayerRequest;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGDcEventKingsHonorMidAckRequest;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGDcEventKingsHonorMidResponseParser;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGKingsHonorMidAbnormalResponse;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGKingsHonorMidAckMessage;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGKingsHonorMidBeginRequester;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGKingsHonorMidEndResponse;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGKingsHonorMidGameConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDcEventHelper implements CGDcEventAppStatusParser.ResultListener, CGDcEventAppLaunchParser.ResultListener, CGDcEventSceneCheckParser.ResultListener, CGDcEventCommonNotifyParser.ResultListener, CGDcEventLoginRequestParser.ResultListener, CGDcEventLoginResultParser.ResultListener, CGDcEventAndroidEventParser.ResultListener, CGDcEventPlayerConnectParser.ResultListener, CGDcEventGameScreenRotateParser.ResultListener, CGDcEventKingsHonorMidResponseParser.ResultListener, CGKingsHonorMidBeginRequester.ResultListener, CGDcEventGameChapterParser.ResultListener, CGDcEventShareInfoParser.ResultListener {
    private static final String KEY_PERSIST_PENDING_CHANNEL_DATA = ".key.persist.pending.channel.data";
    private final DcEventRawSendAction mDcEventRawSendAction;
    private final GmCgPlayDcEventListener mPlayDcEventListener;
    private GmCgDeviceInfo mPlayDeviceInfo;
    private int mSendEventSeq;

    @NonNull
    private final Map<String, List<GmCgDcEventParser>> mDcEventParsers = new HashMap();
    private final CGKingsHonorMidBeginRequester mKingsHonorMidBeginRequester = new CGKingsHonorMidBeginRequester(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Ack {
        String device_id;
        String fail_pos;
        String res;
        int seq;

        Ack() {
        }

        static String toJsonString(String str, int i3) {
            Ack ack = new Ack();
            ack.device_id = str;
            ack.seq = i3;
            ack.res = "SUCCESS";
            ack.fail_pos = "";
            return new Gson().toJson(ack);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface DcEventRawSendAction {
        void onPlayDcEventAppStatus(String str);

        void onPlayDcEventTGPAScene(String str);

        void sendPlayDcEventRawAck(String str);

        void sendPlayDcEventRawData(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Event {
        String body;
        String device_id;
        int seq;

        Event() {
        }

        static String toJsonString(String str, int i3, String str2) {
            Event event = new Event();
            event.device_id = str;
            event.seq = i3;
            event.body = str2;
            return new Gson().toJson(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class PendingData {
        String channelData;
        String deviceId;
        String gameTag;
        String identity;

        PendingData() {
        }

        public static PendingData fromJsonString(String str) {
            return (PendingData) new Gson().fromJson(str, PendingData.class);
        }

        String toJsonString() {
            return new Gson().toJson(this);
        }
    }

    public CGDcEventHelper(DcEventRawSendAction dcEventRawSendAction, GmCgPlayDcEventListener gmCgPlayDcEventListener) {
        this.mDcEventRawSendAction = dcEventRawSendAction;
        this.mPlayDcEventListener = gmCgPlayDcEventListener;
    }

    private void clearPendingChannelData() {
        CGPersistHelper.removeKV(KEY_PERSIST_PENDING_CHANNEL_DATA);
    }

    private int getSendEventSeq() {
        int i3 = this.mSendEventSeq + 1;
        this.mSendEventSeq = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSessionConnected$0(PendingData pendingData) {
        sendPlayChannelData(pendingData.channelData);
    }

    private void sendPlayChannelData(String str) {
        sendPlayChannelData(str, getSendEventSeq());
    }

    public void addDcEventParser(GmCgDcEventParser gmCgDcEventParser) {
        if (gmCgDcEventParser != null && CGStringUtil.notEmpty(gmCgDcEventParser.provideDcEventCmd())) {
            CGLog.i("addDcEventParser name: " + gmCgDcEventParser.provideDcEventCmd());
            List<GmCgDcEventParser> list = this.mDcEventParsers.get(gmCgDcEventParser.provideDcEventCmd());
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(gmCgDcEventParser);
            this.mDcEventParsers.put(gmCgDcEventParser.provideDcEventCmd(), list);
        }
    }

    public PendingData getPendingChannelData() {
        String kVasString = CGPersistHelper.getKVasString(KEY_PERSIST_PENDING_CHANNEL_DATA, "");
        if (CGStringUtil.notEmpty(kVasString)) {
            return PendingData.fromJsonString(kVasString);
        }
        return null;
    }

    public void onEventChannelAck(String str) {
        CGLog.i("CGDcEventHelper onEventChannelAck: " + str);
        GmCgDcEventRequestAck gmCgDcEventRequestAck = new GmCgDcEventRequestAck();
        JSONObject jsonObjectFromString = CGJsonUtil.getJsonObjectFromString(str);
        if (jsonObjectFromString != null) {
            gmCgDcEventRequestAck.seq = CGJsonUtil.getIntFromJsonObject(jsonObjectFromString, "seq", -1);
            gmCgDcEventRequestAck.res = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString, "res", "");
        }
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventAck(gmCgDcEventRequestAck);
        }
    }

    public void onEventChannelData(String str) {
        boolean z16;
        CGLog.i("CGDcEventHelper onEventChannelData: " + str);
        if (CGStringUtil.isEmpty(str)) {
            CGLog.w("onEventChannelData is empty");
            return;
        }
        try {
            Event event = (Event) new Gson().fromJson(str, Event.class);
            DcEventRawSendAction dcEventRawSendAction = this.mDcEventRawSendAction;
            if (dcEventRawSendAction != null) {
                dcEventRawSendAction.sendPlayDcEventRawAck(Ack.toJsonString(event.device_id, event.seq));
            }
            List<GmCgDcEventParser> list = this.mDcEventParsers.get(CGJsonUtil.getStringFromJsonObject(CGJsonUtil.getJsonObjectFromString(event.body), "cmd", ""));
            if (list != null) {
                Iterator<GmCgDcEventParser> it = list.iterator();
                while (it.hasNext()) {
                    it.next().parseDcEventDataFromReceive(event.body);
                }
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("not find event parser, listener is null = ");
            if (this.mPlayDcEventListener == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            CGLog.w(sb5.toString());
            GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
            if (gmCgPlayDcEventListener != null) {
                gmCgPlayDcEventListener.onGmCgPlayDcEventUnknown(event.body);
            }
        } catch (JsonSyntaxException e16) {
            CGLog.e("CGDcEventHelper onEventChannelData: unknown data syntax");
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventAllAndroidEvent(String str) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventAllAndroidEvent(str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAppLaunchParser.ResultListener
    public void onGmCgDcEventAppLaunch() {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventAppLaunch();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAppStatusParser.ResultListener
    public void onGmCgDcEventAppStatus(String str) {
        DcEventRawSendAction dcEventRawSendAction = this.mDcEventRawSendAction;
        if (dcEventRawSendAction != null) {
            dcEventRawSendAction.onPlayDcEventAppStatus(str);
        }
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventAppStatus(str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventCommonNotifyParser.ResultListener
    public void onGmCgDcEventCommonNotify(String str, String str2) {
        if (this.mPlayDcEventListener != null) {
            CGLog.i("onGmCgPlayDcEventCommonNotify");
            this.mPlayDcEventListener.onGmCgPlayDcEventCommonNotify(str, str2);
        } else {
            CGLog.i("onGmCgDcEventCommonNotify listener is null");
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventDownloadGame(String str, String str2) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgDcEventDownloadGame(str, str2);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventGameChapterParser.ResultListener
    public void onGmCgDcEventGameChapter(@Nullable Integer num) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayEventGameChapter(num);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGDcEventKingsHonorMidResponseParser.ResultListener
    public void onGmCgDcEventKingsHonorMidGameAbnormal(CGKingsHonorMidAbnormalResponse cGKingsHonorMidAbnormalResponse) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayEventKingsHonorMidGameAbnormal(cGKingsHonorMidAbnormalResponse.getErrorCode());
        }
        if (this.mPlayDeviceInfo != null) {
            sendDcEventRequest(new CGDcEventKingsHonorMidAckRequest(new CGKingsHonorMidAckMessage(cGKingsHonorMidAbnormalResponse.seq, this.mKingsHonorMidBeginRequester.getRetryTimes())));
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGDcEventKingsHonorMidResponseParser.ResultListener
    public void onGmCgDcEventKingsHonorMidGameAck(CGKingsHonorMidAckMessage cGKingsHonorMidAckMessage) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener;
        if (this.mKingsHonorMidBeginRequester.receiveBeginRequestAck(cGKingsHonorMidAckMessage) != null && (gmCgPlayDcEventListener = this.mPlayDcEventListener) != null) {
            gmCgPlayDcEventListener.onGmCgPlayEventKingsHonorMidGameBeginNormal();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGDcEventKingsHonorMidResponseParser.ResultListener
    public void onGmCgDcEventKingsHonorMidGameEnd(@NonNull CGKingsHonorMidEndResponse cGKingsHonorMidEndResponse) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayEventKingsHonorMidGameEnd(cGKingsHonorMidEndResponse.isPass(), cGKingsHonorMidEndResponse.getMissionCode(), cGKingsHonorMidEndResponse.getResultTitle(), cGKingsHonorMidEndResponse.getConditionResults(), cGKingsHonorMidEndResponse.getVid(), cGKingsHonorMidEndResponse.getFailCount());
        }
        if (this.mPlayDeviceInfo != null) {
            sendDcEventRequest(new CGDcEventKingsHonorMidAckRequest(new CGKingsHonorMidAckMessage(cGKingsHonorMidEndResponse.seq, this.mKingsHonorMidBeginRequester.getRetryTimes())));
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventLoginRequestParser.ResultListener
    public void onGmCgDcEventLoginRequest(int i3) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventLoginRequest(i3);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventLoginResultParser.ResultListener
    public void onGmCgDcEventLoginResult(String str, int i3, boolean z16) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventLoginResult(str, i3, z16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventOpenAssistScreen(String str, String str2, String str3) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgDcEventOpenAssistScreen(str, str2, str3);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventOpenOuterScreen(String str, String str2) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgDcEventOpenOuterScreen(str, str2);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventPlayerConnectParser.ResultListener
    public void onGmCgDcEventPlayerConnect(int i3, int i16) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgDcEventPlayerConnect(i3, i16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventPowerSaveModeStatusChange(boolean z16) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgDcEventPowerSaveModeStatusChange(z16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventQQIntentForward(Intent intent) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventQQIntentForward(intent);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventSDKScence(int i3, boolean z16) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmcgSDKScene(i3, z16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventSceneCheckParser.ResultListener
    public void onGmCgDcEventSceneCheck(boolean z16, int i3, long j3) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventSceneCheck(z16, i3, j3);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventShareInfoParser.ResultListener
    public void onGmCgDcEventShareInfo(@GmCgEventShareInfoType int i3, GmCgGameShareInfo gmCgGameShareInfo) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventShareInfoEvent(i3, gmCgGameShareInfo);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventShopInject(String str) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgDcEventShopInject(str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventTGPAAction(String str, String str2) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventTGPAAction(str, str2);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventTGPAScene(String str, String str2) {
        DcEventRawSendAction dcEventRawSendAction = this.mDcEventRawSendAction;
        if (dcEventRawSendAction != null) {
            dcEventRawSendAction.onPlayDcEventTGPAScene(str2);
        }
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventTGPAScene(str, str2);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventUnknownAndroidEvent(String str) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventUnknownAndroidEvent(str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventAndroidEventParser.ResultListener
    public void onGmCgDcEventWXFaceIdentify(String str) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventWXFaceIdentify(str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGKingsHonorMidBeginRequester.ResultListener
    public void onKingsHonorMidGameBeginTimeout() {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayEventKingsHonorMidGameAbnormal(-100);
        }
    }

    public void onSessionConnected() {
        CGLog.i("CGDcEventHelper onSessionConnected");
        final PendingData pendingChannelData = getPendingChannelData();
        if (pendingChannelData != null && this.mPlayDeviceInfo != null) {
            CGLog.i("CGDcEventHelper onSessionConnected: has pending data: " + pendingChannelData.toJsonString());
            if (this.mPlayDeviceInfo.getIdentity().equals(pendingChannelData.identity) && this.mPlayDeviceInfo.getDeviceID().equals(pendingChannelData.deviceId)) {
                CGLog.i("CGDcEventHelper onSessionConnected: need send pending data");
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.event.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        CGDcEventHelper.this.lambda$onSessionConnected$0(pendingChannelData);
                    }
                }, 1000L);
            } else {
                clearPendingChannelData();
            }
        }
    }

    public void onSessionDeviceEnsured(@NonNull GmCgDeviceInfo gmCgDeviceInfo) {
        this.mPlayDeviceInfo = gmCgDeviceInfo;
        this.mDcEventParsers.clear();
        addDcEventParser(new CGDcEventAppStatusParser(this));
        addDcEventParser(new CGDcEventAppLaunchParser(this.mPlayDeviceInfo.getGamePackageName(), this));
        addDcEventParser(new CGDcEventSceneCheckParser(this));
        addDcEventParser(new CGDcEventCommonNotifyParser(this));
        addDcEventParser(new CGDcEventAndroidEventParser(this.mPlayDeviceInfo.getGamePackageName(), this));
        addDcEventParser(new CGDcEventLoginRequestParser(this));
        addDcEventParser(new CGDcEventLoginResultParser(this));
        addDcEventParser(new CGDcEventPlayerConnectParser(this));
        addDcEventParser(new CGDcEventSceneMonitorParser(this.mPlayDeviceInfo.getGamePackageName()));
        addDcEventParser(new CGDcEventGameScreenRotateParser(this));
        addDcEventParser(new CGDcEventKingsHonorMidResponseParser(this));
        addDcEventParser(new CGDcEventShareInfoParser(this));
        addDcEventParser(new CGDcEventGameChapterParser(this));
    }

    public void sendAppMonitorReq(int i3) {
        GmCgDeviceInfo gmCgDeviceInfo = this.mPlayDeviceInfo;
        if (gmCgDeviceInfo != null) {
            sendDcEventRequest(new CGDcEventAppMonitorRequest(gmCgDeviceInfo.getGamePackageName(), i3));
        }
    }

    public void sendDcEventRequest(GmCgDcEventRequest gmCgDcEventRequest) {
        if (gmCgDcEventRequest != null && CGStringUtil.notEmpty(gmCgDcEventRequest.provideDcEventCmd())) {
            if (gmCgDcEventRequest.provideDcEventSeq() > 0) {
                sendPlayChannelData(gmCgDcEventRequest.generateDcEventDataToSend(), gmCgDcEventRequest.provideDcEventSeq());
            } else {
                sendPlayChannelData(gmCgDcEventRequest.generateDcEventDataToSend());
            }
        }
    }

    public void sendEnterRoomReq(String str, String str2, String str3) {
        if (this.mPlayDeviceInfo != null) {
            sendDcEventRequest(new CGDcEventEnterRoomRequest(str, str2, str3));
        }
    }

    public void sendGameLoginStaterReq(int i3) {
        if (this.mPlayDeviceInfo != null) {
            sendDcEventRequest(new CGDcEventGameLoginStateRequest(i3));
        }
    }

    public void sendKingsHonorMidGameBeginReq(@NonNull CGKingsHonorMidGameConfig cGKingsHonorMidGameConfig) {
        if (this.mPlayDeviceInfo != null) {
            this.mKingsHonorMidBeginRequester.sendBeginRequest(this, cGKingsHonorMidGameConfig);
        }
    }

    public void sendObtainMidasConfigReq() {
        if (this.mPlayDeviceInfo != null) {
            sendDcEventRequest(new CGDcEventObtainMidasConfigRequest());
        }
    }

    public void sendRefreshGameReq() {
        if (this.mPlayDeviceInfo != null) {
            sendDcEventRequest(new CGDcEventRefreshGameRequest());
        }
    }

    public void sendRestartGameReq() {
        if (this.mPlayDeviceInfo != null) {
            sendDcEventRequest(new CGDcEventRestartGameRequest());
        }
    }

    public void sendSceneCheckReq(String str) {
        GmCgDeviceInfo gmCgDeviceInfo = this.mPlayDeviceInfo;
        if (gmCgDeviceInfo != null) {
            sendDcEventRequest(new CGDcEventSceneCheckRequest(gmCgDeviceInfo.getGamePackageName(), str));
        }
    }

    public void sendSwitchInfoLayerReq() {
        GmCgDeviceInfo gmCgDeviceInfo = this.mPlayDeviceInfo;
        if (gmCgDeviceInfo != null) {
            sendDcEventRequest(new CGDcEventSwitchInfoLayerRequest(gmCgDeviceInfo.getGamePackageName()));
        }
    }

    public void setPendingChannelData(String str) {
        CGLog.i("CGDcEventHelper setPendingChannelData");
        if (this.mPlayDeviceInfo == null) {
            return;
        }
        PendingData pendingData = new PendingData();
        pendingData.identity = this.mPlayDeviceInfo.getIdentity();
        pendingData.deviceId = this.mPlayDeviceInfo.getDeviceID();
        pendingData.gameTag = this.mPlayDeviceInfo.getDeviceTag();
        pendingData.channelData = str;
        CGPersistHelper.putKVasString(KEY_PERSIST_PENDING_CHANNEL_DATA, pendingData.toJsonString());
    }

    private void sendPlayChannelData(String str, int i3) {
        DcEventRawSendAction dcEventRawSendAction;
        CGLog.i("CGDcEventHelper sendPlayChannelData: " + str);
        GmCgDeviceInfo gmCgDeviceInfo = this.mPlayDeviceInfo;
        if (gmCgDeviceInfo == null || (dcEventRawSendAction = this.mDcEventRawSendAction) == null) {
            return;
        }
        dcEventRawSendAction.sendPlayDcEventRawData(Event.toJsonString(gmCgDeviceInfo.getDeviceID(), i3, str));
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventGameScreenRotateParser.ResultListener
    public void onGmCgDcEventAppStatus(int i3) {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcEventScreenRotate(i3);
        }
    }
}
