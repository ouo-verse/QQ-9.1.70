package com.tencent.mobileqq.guild.quiprofile;

import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/quiprofile/e;", "", "", "colorValue", "a", "", "", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f231945a = new e();

    e() {
    }

    private final String a(String colorValue) {
        CharSequence trim;
        boolean z16;
        CharSequence trim2;
        List split$default;
        String str;
        boolean endsWith$default;
        String removeSuffix;
        int roundToInt;
        trim = StringsKt__StringsKt.trim((CharSequence) colorValue);
        if (trim.toString().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            trim2 = StringsKt__StringsKt.trim((CharSequence) colorValue);
            split$default = StringsKt__StringsKt.split$default((CharSequence) trim2.toString(), new String[]{" "}, false, 0, 6, (Object) null);
            String str2 = (String) split$default.get(0);
            if (split$default.size() > 1) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default((String) split$default.get(1), "%", false, 2, null);
                if (endsWith$default) {
                    removeSuffix = StringsKt__StringsKt.removeSuffix((String) split$default.get(1), (CharSequence) "%");
                    roundToInt = MathKt__MathJVMKt.roundToInt((Float.parseFloat(removeSuffix) / 100.0f) * 255);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    str = String.format("%02X", Arrays.copyOf(new Object[]{Integer.valueOf(roundToInt)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    return "#" + str + str2;
                }
            }
            str = "FF";
            return "#" + str + str2;
        }
        return "";
    }

    @NotNull
    public final Map<String, List<String>> b() {
        boolean z16;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String u16 = Utils.u(BaseApplication.context, "guild_token_mapping_config.json");
        if (u16 != null && u16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return linkedHashMap;
        }
        try {
            jSONObject = new JSONObject(u16);
            optJSONObject = jSONObject.optJSONObject("colorful_theme");
        } catch (JSONException e16) {
            s.e("Guild.GuildThemeConfigParser", "parseThemeJson error. ", e16);
        }
        if (optJSONObject == null) {
            return linkedHashMap;
        }
        int optInt = jSONObject.optInt("palette_count");
        Iterator keys = optJSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "colorfulTheme.keys()");
        while (keys.hasNext()) {
            String token = (String) keys.next();
            JSONArray optJSONArray = optJSONObject.optJSONArray(token);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                if (length == optInt) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < length; i3++) {
                        arrayList.add(a(optJSONArray.get(i3).toString()));
                    }
                    Intrinsics.checkNotNullExpressionValue(token, "token");
                    linkedHashMap.put(token, arrayList);
                } else {
                    throw new JSONException("colors length is not " + optInt);
                }
            } else {
                throw new JSONException("colors is null");
            }
        }
        return linkedHashMap;
    }
}
