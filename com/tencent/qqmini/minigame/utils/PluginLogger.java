package com.tencent.qqmini.minigame.utils;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\bJ\u0012\u0010$\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010&\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\bJ\u0018\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\bJ\u0006\u0010)\u001a\u00020(J2\u0010*\u001a\u00020(2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\bJ\u001c\u0010+\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010,\u001a\u0004\u0018\u00010\bH\u0002J>\u0010-\u001a\u00020(2\u001a\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\t0\u00072\u001a\u0010/\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\t0\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\t\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b \u0011*\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\t\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tencent/qqmini/minigame/utils/PluginLogger;", "", "()V", "gApiCount", "", "gUniKeyPrev", "mBlackList", "", "", "", "mCallbackID2EventMap", "Ljava/util/HashMap;", "mCallbackID2StartTimeMap", "", "mFailAPIList", "", "", "kotlin.jvm.PlatformType", "mIsDebug", "", "getMIsDebug", "()Z", "mIsDebug$delegate", "Lkotlin/Lazy;", "mWhiteList", "changeCallbackId", "callbackId", "cutString", "str", "extractState", "data", "getKey", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", AdMetricTag.EVENT_NAME, "jsonParams", "isApiFailed", "result", "isEnableLog", "printEndLog", "", "printFailedApi", "printStartLog", "recordApiIfFailed", "detail", "setConfig", "whiteList", "blackList", "Companion", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class PluginLogger {
    private static final int LOG_THRESHOLD = 20;
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

    /* renamed from: mIsDebug$delegate, reason: from kotlin metadata */
    private final Lazy mIsDebug;
    private Map<String, ? extends Set<String>> mWhiteList;
    private static final Pattern STATE_PATTERN = Pattern.compile("(?<=state\":\")\\w+");
    private static final Pattern FAIL_PATTERN = Pattern.compile("\"(errMsg|state)\":\".*(fail|error|exception).*\"");

    public PluginLogger() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqmini.minigame.utils.PluginLogger$mIsDebug$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                return miniAppProxy != null && miniAppProxy.isDebugVersion();
            }
        });
        this.mIsDebug = lazy;
    }

    private final String cutString(String str) {
        if (str != null && str.length() >= 256) {
            String substring = str.substring(0, 256);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    private final String extractState(String data) {
        if (!TextUtils.isEmpty(data)) {
            Matcher matcher = STATE_PATTERN.matcher(data);
            Intrinsics.checkExpressionValueIsNotNull(matcher, "STATE_PATTERN.matcher(data)");
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }

    private final boolean getMIsDebug() {
        return ((Boolean) this.mIsDebug.getValue()).booleanValue();
    }

    private final boolean isApiFailed(String result) {
        if (TextUtils.isEmpty(result)) {
            return false;
        }
        return FAIL_PATTERN.matcher(result).find();
    }

    private final boolean isEnableLog(String eventName, String data) {
        if (!getMIsDebug() || TextUtils.isEmpty(eventName)) {
            return false;
        }
        Map<String, ? extends Set<String>> map = this.mWhiteList;
        if (map != null) {
            if (map == null) {
                Intrinsics.throwNpe();
            }
            if (map != null) {
                if (map.containsKey(eventName)) {
                    String extractState = extractState(data);
                    if (!TextUtils.isEmpty(extractState)) {
                        Map<String, ? extends Set<String>> map2 = this.mWhiteList;
                        if (map2 == null) {
                            Intrinsics.throwNpe();
                        }
                        Set<String> set = map2.get(eventName);
                        if (set != null) {
                            return set.contains(extractState);
                        }
                    }
                    return true;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
        }
        Map<String, ? extends Set<String>> map3 = this.mBlackList;
        if (map3 != null) {
            if (map3 == null) {
                Intrinsics.throwNpe();
            }
            if (map3 != null) {
                if (map3.containsKey(eventName)) {
                    if (!TextUtils.isEmpty(extractState(data))) {
                        Map<String, ? extends Set<String>> map4 = this.mBlackList;
                        if (map4 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (map4.get(eventName) != null) {
                            return !r5.contains(r6);
                        }
                    }
                    return false;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
        }
        return true;
    }

    private final void recordApiIfFailed(String result, String detail) {
        if (getMIsDebug() && isApiFailed(result)) {
            this.mFailAPIList.add(detail);
        }
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
            GameLog.getInstance().e(TAG, "callbackId is too large, start vs end might not match");
        }
        return callbackId;
    }

    @NotNull
    public final String getKey(@NotNull ScriptContextType contextType, @Nullable String eventName, @Nullable String jsonParams) {
        Intrinsics.checkParameterIsNotNull(contextType, "contextType");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(contextType);
        sb5.append(" api(");
        Intrinsics.checkExpressionValueIsNotNull(sb5, "StringBuilder().append(c\u2026textType).append(\" api(\")");
        int i3 = this.gApiCount;
        this.gApiCount = i3 + 1;
        sb5.append(i3);
        sb5.append(") : eventName=[");
        sb5.append(eventName);
        sb5.append("] Params=[");
        sb5.append(cutString(jsonParams));
        sb5.append("]");
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "sb.toString()");
        return sb6;
    }

    public final int printEndLog(int callbackId, @Nullable String result) {
        String str;
        if (getMIsDebug() && this.mCallbackID2EventMap.containsKey(Integer.valueOf(callbackId))) {
            String remove = this.mCallbackID2EventMap.remove(Integer.valueOf(callbackId));
            Long remove2 = this.mCallbackID2StartTimeMap.remove(Integer.valueOf(callbackId));
            long currentTimeMillis = (remove2 == null || remove2.longValue() <= 0) ? 0L : System.currentTimeMillis() - remove2.longValue();
            StringBuffer stringBuffer = new StringBuffer("end ");
            if (currentTimeMillis > 0) {
                str = "cost:" + currentTimeMillis + " ms ";
            } else {
                str = "";
            }
            stringBuffer.append(str);
            stringBuffer.append(remove);
            stringBuffer.append(" R=[");
            stringBuffer.append(cutString(result));
            stringBuffer.append("]");
            Intrinsics.checkExpressionValueIsNotNull(stringBuffer, "StringBuffer(\"end \")\n   \u2026             .append(\"]\")");
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "sb.toString()");
            if (getMIsDebug()) {
                GameLog.getInstance().i(TAG, stringBuffer2);
            } else if (currentTimeMillis > 20) {
                GameLog.getInstance().w(TAG, stringBuffer2);
            }
            recordApiIfFailed(result, stringBuffer2);
        }
        return callbackId >> 11;
    }

    public final void printFailedApi() {
        if (!getMIsDebug()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mFailAPIList);
        this.mFailAPIList.clear();
        GameLog.getInstance().e(TAG, "==================== printFailLog start, total:" + arrayList.size() + " ====================");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            GameLog gameLog = GameLog.getInstance();
            if (str == null) {
                Intrinsics.throwNpe();
            }
            gameLog.e(TAG, str);
        }
        GameLog.getInstance().e(TAG, "==================== printFailLog end ====================");
    }

    public final void printStartLog(@NotNull ScriptContextType contextType, @Nullable String eventName, @Nullable String jsonParams, int callbackId, @NotNull String result) {
        String str;
        Intrinsics.checkParameterIsNotNull(contextType, "contextType");
        Intrinsics.checkParameterIsNotNull(result, "result");
        if (!isEnableLog(eventName, null)) {
            return;
        }
        String key = getKey(contextType, eventName, jsonParams);
        StringBuilder sb5 = new StringBuilder("start ");
        sb5.append(key);
        if (!Intrinsics.areEqual("{}", result) && !Intrinsics.areEqual("", result)) {
            str = " R=[" + cutString(result) + "]";
        } else {
            str = " ###NEED CALLBACK###";
        }
        sb5.append(str);
        Intrinsics.checkExpressionValueIsNotNull(sb5, "StringBuilder(\"start \")\n\u2026 cutString(result) + \"]\")");
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "sb.toString()");
        if (getMIsDebug()) {
            GameLog.getInstance().i(TAG, sb6);
        }
        this.mCallbackID2EventMap.put(Integer.valueOf(callbackId), key);
        this.mCallbackID2StartTimeMap.put(Integer.valueOf(callbackId), Long.valueOf(System.currentTimeMillis()));
        recordApiIfFailed(result, sb6);
    }

    public final void setConfig(@NotNull Map<String, ? extends Set<String>> whiteList, @NotNull Map<String, ? extends Set<String>> blackList) {
        Intrinsics.checkParameterIsNotNull(whiteList, "whiteList");
        Intrinsics.checkParameterIsNotNull(blackList, "blackList");
        this.mWhiteList = whiteList;
        this.mBlackList = blackList;
    }

    public final void printEndLog(@NotNull String eventName, @Nullable String data) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        if (isEnableLog(eventName, data)) {
            String cutString = cutString("eventName:" + eventName + ", Params:" + data);
            if (getMIsDebug() && !TextUtils.isEmpty(cutString)) {
                GameLog.getInstance().i(TAG, "end subscribeJS():" + cutString);
            }
            recordApiIfFailed(data, cutString);
        }
    }
}
