package com.tencent.android.androidbypass.richui.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/android/androidbypass/richui/utils/a;", "", "Lorg/json/JSONObject;", "jsonObject", "dataJson", "", "key", "b", "a", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final a f72343a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18638);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f72343a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull JSONObject jsonObject, @NotNull JSONObject dataJson, @NotNull String key) {
        boolean contains$default;
        List split$default;
        boolean startsWith$default;
        String removePrefix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, jsonObject, dataJson, key);
        }
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        Intrinsics.checkNotNullParameter(key, "key");
        String content = jsonObject.optString(key);
        Intrinsics.checkNotNullExpressionValue(content, "content");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) "%", false, 2, (Object) null);
        if (contains$default) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) content, new String[]{"%"}, false, 0, 6, (Object) null);
            if (split$default.isEmpty()) {
                return b(jsonObject, dataJson, key);
            }
            StringBuilder sb5 = new StringBuilder();
            int size = split$default.size();
            for (int i3 = 0; i3 < size; i3++) {
                String str = (String) split$default.get(i3);
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "$$", false, 2, null);
                if (startsWith$default) {
                    removePrefix = StringsKt__StringsKt.removePrefix(str, (CharSequence) "$$");
                    str = dataJson.optString(removePrefix);
                    Intrinsics.checkNotNullExpressionValue(str, "dataJson.optString(subSt\u2026emovePrefix(DATA_PREFIX))");
                }
                sb5.append(str);
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
            return sb6;
        }
        return b(jsonObject, dataJson, key);
    }

    @NotNull
    public final String b(@NotNull JSONObject jsonObject, @NotNull JSONObject dataJson, @NotNull String key) {
        boolean startsWith$default;
        String removePrefix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, this, jsonObject, dataJson, key);
        }
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        Intrinsics.checkNotNullParameter(key, "key");
        String content = jsonObject.optString(key);
        Intrinsics.checkNotNullExpressionValue(content, "content");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(content, "$$", false, 2, null);
        if (startsWith$default) {
            removePrefix = StringsKt__StringsKt.removePrefix(content, (CharSequence) "$$");
            content = dataJson.optString(removePrefix);
        }
        Intrinsics.checkNotNullExpressionValue(content, "content");
        return content;
    }
}
