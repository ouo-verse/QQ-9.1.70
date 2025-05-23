package com.tencent.mobileqq.minigame.utils;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010!\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\bJ\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0006\u0010$\u001a\u00020#J2\u0010%\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\bJ\u001c\u0010&\u001a\u00020#2\b\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010\bH\u0002J>\u0010(\u001a\u00020#2\u001a\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\t0\u00072\u001a\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\t0\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\t\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b \u0011*\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\t\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/minigame/utils/PluginLogger;", "", "()V", "gApiCount", "", "gUniKeyPrev", "mBlackList", "", "", "", "mCallbackID2EventMap", "Ljava/util/HashMap;", "mCallbackID2StartTimeMap", "", "mFailAPIList", "", "", "kotlin.jvm.PlatformType", "mWhiteList", "changeCallbackId", "callbackId", "cutString", "str", "extractState", "data", "getKey", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", AdMetricTag.EVENT_NAME, "jsonParams", "isApiFailed", "", "result", "isEnableLog", "printEndLog", "", "printFailedApi", "printStartLog", "recordApiIfFailed", "detail", "setConfig", "whiteList", "blackList", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PluginLogger {
    private static final int MAX_CALLBACKID = 1048576;
    private static final int MAX_UNIKEYID = 1024;
    private static final int RESERVER_BIT = 11;
    private static final String TAG = "<API>";
    private int gApiCount;
    private int gUniKeyPrev;
    private Map<String, ? extends Set<String>> mBlackList;
    private final HashMap<Integer, String> mCallbackID2EventMap = new HashMap<>();
    private final HashMap<Integer, Long> mCallbackID2StartTimeMap = new HashMap<>();
    private final List<String> mFailAPIList = Collections.synchronizedList(new ArrayList());
    private Map<String, ? extends Set<String>> mWhiteList;
    private static final Pattern STATE_PATTERN = Pattern.compile("(?<=state\":\")\\w+");
    private static final Pattern FAIL_PATTERN = Pattern.compile("\"(errMsg|state)\":\".*(fail|error|exception).*\"");

    private final String extractState(String data) {
        if (!TextUtils.isEmpty(data)) {
            Matcher matcher = STATE_PATTERN.matcher(data);
            Intrinsics.checkNotNullExpressionValue(matcher, "STATE_PATTERN.matcher(data)");
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }

    private final boolean isApiFailed(String result) {
        if (TextUtils.isEmpty(result)) {
            return false;
        }
        return FAIL_PATTERN.matcher(result).find();
    }

    private final boolean isEnableLog(String eventName, String data) {
        if (TextUtils.isEmpty(eventName)) {
            return false;
        }
        Map<String, ? extends Set<String>> map = this.mWhiteList;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            if (map.containsKey(eventName)) {
                String extractState = extractState(data);
                if (!TextUtils.isEmpty(extractState)) {
                    Map<String, ? extends Set<String>> map2 = this.mWhiteList;
                    Intrinsics.checkNotNull(map2);
                    Set<String> set = map2.get(eventName);
                    if (set != null) {
                        return set.contains(extractState);
                    }
                }
                return true;
            }
        }
        Map<String, ? extends Set<String>> map3 = this.mBlackList;
        if (map3 != null) {
            Intrinsics.checkNotNull(map3);
            if (map3.containsKey(eventName)) {
                if (!TextUtils.isEmpty(extractState(data))) {
                    Map<String, ? extends Set<String>> map4 = this.mBlackList;
                    Intrinsics.checkNotNull(map4);
                    if (map4.get(eventName) != null) {
                        return !r4.contains(r5);
                    }
                }
                return false;
            }
        }
        return true;
    }

    private final void recordApiIfFailed(String result, String detail) {
        if (isApiFailed(result)) {
            this.mFailAPIList.add(detail);
        }
    }

    public final String getKey(ScriptContextType contextType, String eventName, String jsonParams) {
        Intrinsics.checkNotNullParameter(contextType, "contextType");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(contextType);
        sb5.append(" api(");
        int i3 = this.gApiCount;
        this.gApiCount = i3 + 1;
        sb5.append(i3);
        sb5.append(") : eventName=[");
        sb5.append(eventName);
        sb5.append("] Params=[");
        sb5.append(cutString(jsonParams));
        sb5.append("]");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    public final int printEndLog(int callbackId, String result) {
        String str;
        if (this.mCallbackID2EventMap.containsKey(Integer.valueOf(callbackId))) {
            String remove = this.mCallbackID2EventMap.remove(Integer.valueOf(callbackId));
            Long remove2 = this.mCallbackID2StartTimeMap.remove(Integer.valueOf(callbackId));
            StringBuffer stringBuffer = new StringBuffer("end ");
            if (remove2 == null || remove2.longValue() <= 0) {
                str = "";
            } else {
                str = "cost:" + (System.currentTimeMillis() - remove2.longValue()) + "ms ";
            }
            stringBuffer.append(str);
            stringBuffer.append(remove);
            stringBuffer.append(" R=[");
            stringBuffer.append(cutString(result));
            stringBuffer.append("]");
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "sb.toString()");
            GameLog.getInstance().i(TAG, stringBuffer2);
            recordApiIfFailed(result, stringBuffer2);
        }
        return callbackId >> 11;
    }

    public final void printFailedApi() {
        ArrayList arrayList = new ArrayList(this.mFailAPIList);
        this.mFailAPIList.clear();
        GameLog.getInstance().e(TAG, "==================== printFailLog start, total:" + arrayList.size() + " ====================");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            GameLog gameLog = GameLog.getInstance();
            Intrinsics.checkNotNull(str);
            gameLog.e(TAG, str);
        }
        GameLog.getInstance().e(TAG, "==================== printFailLog end ====================");
    }

    public final void printStartLog(ScriptContextType contextType, String eventName, String jsonParams, int callbackId, String result) {
        String str;
        Intrinsics.checkNotNullParameter(contextType, "contextType");
        Intrinsics.checkNotNullParameter(result, "result");
        if (isEnableLog(eventName, null)) {
            String key = getKey(contextType, eventName, jsonParams);
            StringBuilder sb5 = new StringBuilder("start ");
            sb5.append(key);
            if (!Intrinsics.areEqual("{}", result) && !Intrinsics.areEqual("", result)) {
                str = " R=[" + cutString(result) + "]";
            } else {
                str = " ###NEED CALLBACK###";
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            GameLog.getInstance().i(TAG, sb6);
            this.mCallbackID2EventMap.put(Integer.valueOf(callbackId), key);
            this.mCallbackID2StartTimeMap.put(Integer.valueOf(callbackId), Long.valueOf(System.currentTimeMillis()));
            recordApiIfFailed(result, sb6);
        }
    }

    public final void setConfig(Map<String, ? extends Set<String>> whiteList, Map<String, ? extends Set<String>> blackList) {
        Intrinsics.checkNotNullParameter(whiteList, "whiteList");
        Intrinsics.checkNotNullParameter(blackList, "blackList");
        this.mWhiteList = whiteList;
        this.mBlackList = blackList;
    }

    private final String cutString(String str) {
        if (str == null || str.length() < 256) {
            return str;
        }
        String substring = str.substring(0, 256);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public final int changeCallbackId(int callbackId) {
        if (callbackId < 1048576) {
            int i3 = this.gUniKeyPrev;
            int i16 = i3 + 1;
            this.gUniKeyPrev = i16;
            callbackId = (callbackId << 11) + i3;
            if (i16 > 1024) {
                this.gUniKeyPrev = 0;
            }
        } else {
            GameLog.getInstance().e(TAG, "callbackId is toooo large, start vs end might not match");
        }
        return callbackId;
    }

    public final void printEndLog(String eventName, String data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (isEnableLog(eventName, data)) {
            String cutString = cutString("eventName:" + eventName + ", Params:" + data);
            if (!TextUtils.isEmpty(cutString)) {
                GameLog.getInstance().i(TAG, "end subscribeJS():" + cutString);
            }
            recordApiIfFailed(data, cutString);
        }
    }
}
