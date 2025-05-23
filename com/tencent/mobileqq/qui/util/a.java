package com.tencent.mobileqq.qui.util;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.profileskin.c;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u0001\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qui/util/a;", "", "", PoiListCacheRecord.TIMESTAMP_TYPE, "", "b", "", WadlProxyConsts.PARAM_FILENAME, "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/qui/profileskin/c;", "a", HippyControllerProps.STRING, "d", "color", "c", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f276940a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37118);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f276940a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int b(long r102) {
        return ((int) (r102 & 255)) | (((int) ((4294967295L & r102) >> 24)) << 24) | (((int) ((16777215 & r102) >> 16)) << 16) | (((int) ((WebSocketProtocol.PAYLOAD_SHORT_MAX & r102) >> 8)) << 8);
    }

    @NotNull
    public final Map<String, Pair<c, c>> a(@NotNull String fileName) {
        boolean z16;
        JSONObject optJSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this, (Object) fileName);
        }
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String u16 = Utils.u(BaseApplication.context, fileName);
        if (u16 != null && u16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return linkedHashMap;
        }
        try {
            optJSONObject = new JSONObject(u16).optJSONObject("colorful_theme");
        } catch (JSONException e16) {
            QLog.e("QUITokenMapConfigUtil", 1, "generateTokenMappingConfig error. ", e16);
        }
        if (optJSONObject == null) {
            return linkedHashMap;
        }
        Iterator keys = optJSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "colorfulTheme.keys()");
        while (keys.hasNext()) {
            String token = (String) keys.next();
            JSONArray optJSONArray = optJSONObject.optJSONArray(token);
            if (optJSONArray == null) {
                QLog.i("QUITokenMapConfigUtil", 1, "token=" + token + ", colors is null");
            } else {
                Object obj = optJSONArray.get(0);
                Intrinsics.checkNotNullExpressionValue(obj, "colors[0]");
                c c16 = c(obj);
                if (c16 == null) {
                    QLog.i("QUITokenMapConfigUtil", 1, "token=" + token + ", lightValue is null");
                } else {
                    Object obj2 = optJSONArray.get(1);
                    Intrinsics.checkNotNullExpressionValue(obj2, "colors[1]");
                    c c17 = c(obj2);
                    if (c17 == null) {
                        QLog.i("QUITokenMapConfigUtil", 1, "token=" + token + ", darkValue is null");
                    } else {
                        Intrinsics.checkNotNullExpressionValue(token, "token");
                        linkedHashMap.put(token, new Pair(c16, c17));
                    }
                }
            }
        }
        return linkedHashMap;
    }

    @Nullable
    public final c c(@NotNull Object color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this, color);
        }
        Intrinsics.checkNotNullParameter(color, "color");
        if (color instanceof Long) {
            return new c.a(b(((Number) color).longValue()));
        }
        if (color instanceof Integer) {
            return new c.a(((Number) color).intValue());
        }
        if (color instanceof String) {
            return d((String) color);
        }
        return null;
    }

    @NotNull
    public final c d(@NotNull String string) {
        boolean contains$default;
        boolean endsWith$default;
        List split$default;
        int lastIndex;
        boolean contains$default2;
        List split$default2;
        List split$default3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) string);
        }
        Intrinsics.checkNotNullParameter(string, "string");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) "_", false, 2, (Object) null);
        if (!contains$default) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(string, "%", false, 2, null);
            if (endsWith$default) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{" "}, false, 0, 6, (Object) null);
                int parseColor = Color.parseColor((String) split$default.get(0));
                String str = (String) split$default.get(1);
                lastIndex = StringsKt__StringsKt.getLastIndex((CharSequence) split$default.get(1));
                Intrinsics.checkNotNullExpressionValue(str.substring(0, lastIndex), "this as java.lang.String\u2026ing(startIndex, endIndex)");
                return new c.a(ColorUtils.setAlphaComponent(parseColor, (int) (Integer.parseInt(r14) * 0.01d * 255)));
            }
            return new c.a(Color.parseColor(string));
        }
        float f16 = 1.0f;
        Float valueOf = Float.valueOf(1.0f);
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) string, '*', false, 2, (Object) null);
        if (contains$default2) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) string, new char[]{'*'}, false, 0, 6, (Object) null);
            if (split$default2.size() > 1) {
                split$default3 = StringsKt__StringsKt.split$default((CharSequence) string, new char[]{'*'}, false, 0, 6, (Object) null);
                String str2 = (String) split$default3.get(0);
                valueOf = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull((String) split$default3.get(1));
                string = str2;
            }
        }
        if (valueOf != null) {
            f16 = valueOf.floatValue();
        }
        return new c.b(string, f16);
    }
}
