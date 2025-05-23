package o51;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.minibox.common.log.LogUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u00062\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010*\u001a\u00020\u0007\u0012\u0006\u0010+\u001a\u00020\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010+\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006."}, d2 = {"Lo51/b;", "", "Lorg/json/JSONObject;", "configJson", "", "g", h.F, "", "envName", "Lorg/json/JSONArray;", "configDataJsonArray", "a", "grayConfig", "", "f", "toString", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setDexMD5", "(Ljava/lang/String;)V", "dexMD5", "b", "d", "setDexVersion", "dexVersion", "setDexDownloadUrl", "dexDownloadUrl", "", "I", "e", "()I", "setRetCode", "(I)V", "retCode", "", "J", "getUpdateTime", "()J", "i", "(J)V", "updateTime", "uin", "configStr", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: o51.b, reason: from toString */
/* loaded from: classes9.dex */
public final class RainbowPluginConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String dexMD5;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String dexVersion;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String dexDownloadUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int retCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long updateTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String uin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String configStr;

    public RainbowPluginConfig(@NotNull String uin, @NotNull String configStr) {
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        Intrinsics.checkParameterIsNotNull(configStr, "configStr");
        this.uin = uin;
        this.configStr = configStr;
        this.dexMD5 = "";
        this.dexVersion = "";
        this.dexDownloadUrl = "";
        JSONObject h16 = h();
        if (h16 != null) {
            g(h16);
        } else {
            this.retCode = -1;
        }
    }

    private final JSONObject a(String envName, JSONArray configDataJsonArray) {
        int length = configDataJsonArray.length();
        int i3 = 0;
        while (true) {
            String str = null;
            if (i3 >= length) {
                return null;
            }
            JSONObject optJSONObject = configDataJsonArray.optJSONObject(i3);
            if (optJSONObject != null) {
                str = optJSONObject.optString(MosaicConstants$JsProperty.PROP_ENV);
            }
            if (Intrinsics.areEqual(envName, str)) {
                return optJSONObject;
            }
            i3++;
        }
    }

    private final boolean f(JSONObject grayConfig) {
        boolean z16;
        boolean z17;
        List split$default;
        boolean endsWith$default;
        List split$default2;
        String whiteListStr = grayConfig.optString("whiteList", "");
        Intrinsics.checkExpressionValueIsNotNull(whiteListStr, "whiteListStr");
        if (whiteListStr.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) whiteListStr, new String[]{","}, false, 0, 6, (Object) null);
            Iterator it = split$default2.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(this.uin, (String) it.next())) {
                    return true;
                }
            }
        }
        String tailNumStr = grayConfig.optString("tailNum", "");
        Intrinsics.checkExpressionValueIsNotNull(tailNumStr, "tailNumStr");
        if (tailNumStr.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) tailNumStr, new String[]{","}, false, 0, 6, (Object) null);
            Iterator it5 = split$default.iterator();
            while (it5.hasNext()) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(this.uin, (String) it5.next(), false, 2, null);
                if (endsWith$default) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private final void g(JSONObject configJson) {
        try {
            JSONObject jSONObject = new JSONObject(configJson.getString("dexConfig"));
            String string = jSONObject.getString("dexDownloadUrl");
            Intrinsics.checkExpressionValueIsNotNull(string, "dexJson.getString(KEY_DEX_DOWNLOAD_URL)");
            this.dexDownloadUrl = string;
            String string2 = jSONObject.getString("dexMD5");
            Intrinsics.checkExpressionValueIsNotNull(string2, "dexJson.getString(KEY_DEX_MD5)");
            this.dexMD5 = string2;
            String string3 = jSONObject.getString("dexVersion");
            Intrinsics.checkExpressionValueIsNotNull(string3, "dexJson.getString(KEY_DEX_VERSION)");
            this.dexVersion = string3;
        } catch (Exception e16) {
            LogUtils.e("RainbowPluginConfig", "parseDexConfig: exception", e16);
        }
    }

    private final JSONObject h() {
        JSONObject jSONObject = new JSONObject(this.configStr);
        int i3 = jSONObject.getInt("code");
        this.retCode = i3;
        if (i3 != 0) {
            LogUtils.e("RainbowPluginConfig", "configStr is invalid=" + this.configStr);
            return null;
        }
        JSONArray configDataJsonArray = jSONObject.getJSONArray("data");
        LogUtils.i("RainbowPluginConfig", "configDataJsonArray length=" + configDataJsonArray.length());
        if (configDataJsonArray.length() == 0) {
            LogUtils.e("RainbowPluginConfig", "configDataJsonArray is empty, check rainbow config.");
            return null;
        }
        if (configDataJsonArray.length() == 1) {
            JSONObject jSONObject2 = configDataJsonArray.getJSONObject(0);
            LogUtils.i("RainbowPluginConfig", "env=" + jSONObject2.getString(MosaicConstants$JsProperty.PROP_ENV));
            return jSONObject2;
        }
        Intrinsics.checkExpressionValueIsNotNull(configDataJsonArray, "configDataJsonArray");
        JSONObject a16 = a("gray", configDataJsonArray);
        if (a16 != null && f(a16)) {
            return a16;
        }
        JSONObject a17 = a("release", configDataJsonArray);
        if (a17 == null) {
            LogUtils.e("RainbowPluginConfig", "release config is null!");
        }
        return a17;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDexDownloadUrl() {
        return this.dexDownloadUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDexMD5() {
        return this.dexMD5;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDexVersion() {
        return this.dexVersion;
    }

    /* renamed from: e, reason: from getter */
    public final int getRetCode() {
        return this.retCode;
    }

    public final void i(long j3) {
        this.updateTime = j3;
    }

    @NotNull
    public String toString() {
        return "RainbowPluginConfig(dexVersion='" + this.dexVersion + "')";
    }
}
