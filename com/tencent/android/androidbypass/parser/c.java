package com.tencent.android.androidbypass.parser;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/android/androidbypass/parser/c;", "", "", "markdown", "Lcom/tencent/android/androidbypass/parser/b;", "a", "", "b", "Ljava/util/regex/Pattern;", "Ljava/util/regex/Pattern;", "getSInfoPattern", "()Ljava/util/regex/Pattern;", "sInfoPattern", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final Pattern sInfoPattern;

    /* renamed from: b, reason: collision with root package name */
    public static final c f72297b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18240);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f72297b = new c();
            sInfoPattern = Pattern.compile("(^\\[\\]\\((.+?)\\))[\\s\\S]*");
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final b a(@Nullable String markdown) {
        Matcher matcher;
        String group;
        if (TextUtils.isEmpty(markdown)) {
            return null;
        }
        Pattern pattern = sInfoPattern;
        if (pattern != null) {
            matcher = pattern.matcher(markdown);
        } else {
            matcher = null;
        }
        if (matcher != null && matcher.matches() && (group = matcher.group(1)) != null) {
            try {
                return new b(new JSONObject(URLDecoder.decode(matcher.group(2), "utf-8")), group.length(), markdown);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return new b(null, 0, markdown);
    }

    @JvmStatic
    public static final boolean b(@Nullable String markdown) {
        int i3;
        boolean z16;
        b a16 = a(markdown);
        if (a16 != null) {
            JSONObject a17 = a16.a();
            if (a17 != null) {
                i3 = a17.optInt("version", 0);
            } else {
                i3 = 0;
            }
            if (i3 <= 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }
}
