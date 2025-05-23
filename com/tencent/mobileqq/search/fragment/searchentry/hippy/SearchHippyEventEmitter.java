package com.tencent.mobileqq.search.fragment.searchentry.hippy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.cw;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchHippyEventEmitter implements cw.b {
    private static final String MODULE_KEYBOARD_CHANGE = "@search:keyboardEvent";
    private static final String MODULE_SEARCH_COMMON_EVENT = "@search:commonEvent";

    @NonNull
    private final HippyQQEngine engine;

    @NonNull
    private final SearchHotwordHandler hotwordHandler;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public enum CommonEvent {
        RequestHistory,
        HomepageShow,
        HomepageExpose,
        EntryIDUpdate,
        HotwordChanged,
        SmartBoxInput,
        SearchUnitWillHide
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private enum KeyboardAction {
        show,
        hide
    }

    public SearchHippyEventEmitter(@NonNull HippyQQEngine hippyQQEngine, @NonNull SearchHotwordHandler searchHotwordHandler) {
        this.engine = hippyQQEngine;
        this.hotwordHandler = searchHotwordHandler;
        cw.b(this);
    }

    public static String mapToJsonStr(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        try {
            return new JSONObject(map).toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private void sendSoftKeyboardEvent(int i3, String str) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("action", str);
        hippyMap.pushString("height", i3 + "");
        this.engine.sendEvent(MODULE_KEYBOARD_CHANGE, hippyMap);
    }

    public void destroy() {
        cw.k(this);
    }

    @Override // com.tencent.mobileqq.app.cw.b
    public void onHistoryChanged() {
        sendCommonEvent(CommonEvent.RequestHistory, null);
    }

    public void sendActiveEvent(boolean z16, String str, Map<String, Object> map) {
        String str2;
        HashMap hashMap = new HashMap();
        if (z16) {
            str2 = OperateCustomButton.OPERATE_CREATE;
        } else {
            str2 = "other";
        }
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, str2);
        hashMap.put(JumpGuildParam.EXTRA_KEY_OPEN_FROM, str);
        hashMap.putAll(map);
        sendCommonEvent(CommonEvent.HomepageShow, hashMap);
        sendCommonEvent(CommonEvent.HomepageExpose, hashMap);
    }

    public void sendCommonEvent(@NonNull CommonEvent commonEvent, @Nullable Map<String, Object> map) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("cmd", commonEvent.name());
        if (map == null) {
            hippyMap.pushString("data", "");
        } else {
            hippyMap.pushString("data", mapToJsonStr(map));
        }
        this.engine.sendEvent(MODULE_SEARCH_COMMON_EVENT, hippyMap);
    }

    public void sendSoftKeyboardHideEvent() {
        sendSoftKeyboardEvent(0, KeyboardAction.hide.name());
    }

    public void sendSoftKeyboardShowEvent(int i3) {
        sendSoftKeyboardEvent(i3, KeyboardAction.show.name());
    }

    public void sendTextChangedEvent(@NonNull String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("word", str);
        hashMap.put("inputTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("type", 1);
        sendCommonEvent(CommonEvent.SmartBoxInput, hashMap);
    }
}
