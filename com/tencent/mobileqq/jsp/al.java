package com.tencent.mobileqq.jsp;

import android.graphics.Color;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/jsp/al;", "", "", "b", "param", "c", "argbStr", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class al {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final al f238846a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f238846a = new al();
        }
    }

    al() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a(String argbStr) throws Exception {
        String replace$default;
        char last;
        int parseColor = Color.parseColor(argbStr);
        int alpha = Color.alpha(parseColor);
        int red = Color.red(parseColor);
        int green = Color.green(parseColor);
        int blue = Color.blue(parseColor);
        if (alpha == 255) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("#%02X%02X%02X", Arrays.copyOf(new Object[]{Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(alpha / 255.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        replace$default = StringsKt__StringsJVMKt.replace$default(format2, "0.", ".", false, 4, (Object) null);
        if (!Intrinsics.areEqual(replace$default, ".00")) {
            last = StringsKt___StringsKt.last(replace$default);
            if (last == '0') {
                String substring = replace$default.substring(0, 2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String format3 = String.format("rgba(%d, %d, %d, %s)", Arrays.copyOf(new Object[]{Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue), substring}, 4));
                Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
                return format3;
            }
            String format4 = String.format("rgba(%d, %d, %d, %s)", Arrays.copyOf(new Object[]{Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue), replace$default}, 4));
            Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
            return format4;
        }
        String format5 = String.format("rgba(%d, %d, %d, 0)", Arrays.copyOf(new Object[]{Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue)}, 3));
        Intrinsics.checkNotNullExpressionValue(format5, "format(format, *args)");
        return format5;
    }

    @JvmStatic
    @NotNull
    public static final String b() {
        String joinToString$default;
        String str;
        boolean contains$default;
        Map<String, String> currentTokenMap = QUIUtil.getCurrentTokenMap();
        Intrinsics.checkNotNullExpressionValue(currentTokenMap, "getCurrentTokenMap()");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : currentTokenMap.entrySet()) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) entry.getValue().toString(), (CharSequence) ",", false, 2, (Object) null);
            if (!contains$default) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            try {
                al alVar = f238846a;
                Object value = entry2.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "it.value");
                str = alVar.a((String) value);
            } catch (Exception e16) {
                QLog.e("WebQUITokenHelper", 1, "getQUITokenCssString parse [" + entry2.getValue() + "] for [" + entry2.getKey() + "] exception. ", e16);
                str = "#000000";
            }
            arrayList.add("--" + entry2.getKey() + MsgSummary.STR_COLON + str + ";");
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null);
        String str2 = ":root {\n" + joinToString$default + "\n}";
        if (QLog.isColorLevel()) {
            QLog.d("WebQUITokenHelper", 2, "getQUITokenCssString colorMap.size=" + linkedHashMap.size() + ", size: " + str2.length());
        }
        return str2;
    }

    @JvmStatic
    @NotNull
    public static final String c(@Nullable String param) {
        boolean z16;
        int collectionSizeOrDefault;
        String joinToString$default;
        String str;
        boolean contains$default;
        if (param != null) {
            if (param.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Map<String, String> currentTokenMap = QUIUtil.getCurrentTokenMap();
                Intrinsics.checkNotNullExpressionValue(currentTokenMap, "getCurrentTokenMap()");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, String> entry : currentTokenMap.entrySet()) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) entry.getValue().toString(), (CharSequence) ",", false, 2, (Object) null);
                    if (!contains$default) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                List<String> split = new Regex("\\|").split(param, 0);
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(split, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (String str2 : split) {
                    String substring = str2.substring(2);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    String str3 = (String) linkedHashMap.get(substring);
                    if (str3 != null) {
                        try {
                            str = f238846a.a(str3);
                        } catch (Exception e16) {
                            QLog.e("WebQUITokenHelper", 1, "getTokensBatch parse [" + str3 + "] for [" + str2 + "] exception. ", e16);
                            str = "#000000";
                        }
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                    str = "";
                    arrayList.add(str);
                }
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "|", null, null, 0, null, null, 62, null);
                if (QLog.isColorLevel()) {
                    QLog.d("WebQUITokenHelper", 2, "getTokensBatch result: " + joinToString$default + ", param: " + param);
                }
                return joinToString$default;
            }
        }
        return "";
    }
}
