package com.tencent.qqnt.aio.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/utils/r;", "", "", "text", "", "a", "", "b", "I", "lenLimit", "c", "charLenLimit", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "d", "Ljava/util/HashSet;", "chars", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class r {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f352313a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int lenLimit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int charLenLimit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<Character> chars;

    static {
        int checkRadix;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47941);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f352313a = new r();
        lenLimit = -1;
        charLenLimit = -1;
        chars = new HashSet<>();
        try {
            String loadConfigAsString = FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("disable_long_press_config", "");
            QLog.d("LongPressConfig", 1, "LongPressConfig: " + loadConfigAsString);
            JSONObject jSONObject = new JSONObject(loadConfigAsString);
            lenLimit = jSONObject.optInt(com.tencent.luggage.wxa.c8.c.E, -1);
            charLenLimit = jSONObject.optInt("char_len", -1);
            JSONArray jSONArray = jSONObject.getJSONArray(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                HashSet<Character> hashSet = chars;
                String string = jSONArray.getString(i3);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                hashSet.add(Character.valueOf((char) Integer.parseInt(string, checkRadix)));
            }
        } catch (NumberFormatException | JSONException unused) {
        }
    }

    r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(@NotNull CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) text)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(text, "text");
        int i3 = lenLimit;
        if (i3 == -1 && charLenLimit == -1) {
            return true;
        }
        if (i3 != -1 && text.length() > lenLimit) {
            return false;
        }
        if (charLenLimit == -1 || text.length() <= charLenLimit) {
            return true;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < text.length(); i17++) {
            if (chars.contains(Character.valueOf(text.charAt(i17)))) {
                i16++;
            }
        }
        if (i16 <= charLenLimit) {
            return true;
        }
        return false;
    }
}
