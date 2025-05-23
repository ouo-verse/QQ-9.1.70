package com.tencent.qqnt.chats.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\"\u001a\u0010\u0005\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\b\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\u0004\"\u001a\u0010\n\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u001a\u0010\f\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0002\u001a\u0004\b\u0001\u0010\u0004\"\u001a\u0010\u000f\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0004\"\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0017\u0010\u0018\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"", "a", "I", "getMINS_TIME", "()I", "MINS_TIME", "b", "getNOW_TIME", "NOW_TIME", "c", "ONE_HOUR", "d", "ONE_DAY", "e", "getMID_DAY", "MID_DAY", "Ljava/text/SimpleDateFormat;", "f", "Ljava/text/SimpleDateFormat;", "getDAY_FORRMAT", "()Ljava/text/SimpleDateFormat;", "DAY_FORRMAT", "g", "getMONTH_FORRMAT", "MONTH_FORRMAT", "chats_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final int f354741a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f354742b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f354743c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f354744d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f354745e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final SimpleDateFormat f354746f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final SimpleDateFormat f354747g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39970);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f354741a = 60000;
        f354742b = 60000 * 2;
        int i3 = 60000 * 60;
        f354743c = i3;
        f354744d = i3 * 24;
        f354745e = i3 * 12;
        f354746f = new SimpleDateFormat("d");
        f354747g = new SimpleDateFormat("MM");
    }

    public static final int a() {
        return f354744d;
    }

    public static final int b() {
        return f354743c;
    }
}
