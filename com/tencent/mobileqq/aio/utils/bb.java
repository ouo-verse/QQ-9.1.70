package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b \b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/utils/bb;", "", "", "b", "I", "getC2C_ZPLAN_DESTROY", "()I", "C2C_ZPLAN_DESTROY", "c", "d", "C2C_ZPLAN_SET_ON_CLICK_LISTENER", "e", "C2C_ZPLAN_SET_VISIABLE", "g", "C2C_ZPLAN_UPDATE_ICON", "f", "C2C_ZPLAN_SET_IMAGE_RESOURCE", "getC2C_ZPLAN_HIDE_PANELS_OF_ALL", "C2C_ZPLAN_HIDE_PANELS_OF_ALL", tl.h.F, "getC2C_ZPLAN_UPDATE_ZPLAN_GREEN_DOT", "C2C_ZPLAN_UPDATE_ZPLAN_GREEN_DOT", "i", "getC2C_ZPLAN_CLEAR_RED_TOUCH", "C2C_ZPLAN_CLEAR_RED_TOUCH", "j", "C2C_ZPLAN_SHOW_SMALL_HOME_TIPS_UI", "k", "a", "C2C_ZPLAN_HANDLE_RED_TOUCH_EVENT", "l", "C2C_ZPLAN_REFRESH_RED_TOUCH", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class bb {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bb f194129a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int C2C_ZPLAN_DESTROY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int C2C_ZPLAN_SET_ON_CLICK_LISTENER;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int C2C_ZPLAN_SET_VISIABLE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final int C2C_ZPLAN_UPDATE_ICON;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final int C2C_ZPLAN_SET_IMAGE_RESOURCE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final int C2C_ZPLAN_HIDE_PANELS_OF_ALL;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final int C2C_ZPLAN_UPDATE_ZPLAN_GREEN_DOT;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final int C2C_ZPLAN_CLEAR_RED_TOUCH;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final int C2C_ZPLAN_SHOW_SMALL_HOME_TIPS_UI;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final int C2C_ZPLAN_HANDLE_RED_TOUCH_EVENT;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final int C2C_ZPLAN_REFRESH_RED_TOUCH;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f194129a = new bb();
        C2C_ZPLAN_DESTROY = 1;
        C2C_ZPLAN_SET_ON_CLICK_LISTENER = 2;
        C2C_ZPLAN_SET_VISIABLE = 3;
        C2C_ZPLAN_UPDATE_ICON = 4;
        C2C_ZPLAN_SET_IMAGE_RESOURCE = 5;
        C2C_ZPLAN_HIDE_PANELS_OF_ALL = 6;
        C2C_ZPLAN_UPDATE_ZPLAN_GREEN_DOT = 7;
        C2C_ZPLAN_CLEAR_RED_TOUCH = 8;
        C2C_ZPLAN_SHOW_SMALL_HOME_TIPS_UI = 9;
        C2C_ZPLAN_HANDLE_RED_TOUCH_EVENT = 101;
        C2C_ZPLAN_REFRESH_RED_TOUCH = 102;
    }

    bb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return C2C_ZPLAN_HANDLE_RED_TOUCH_EVENT;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return C2C_ZPLAN_REFRESH_RED_TOUCH;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return C2C_ZPLAN_SET_IMAGE_RESOURCE;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return C2C_ZPLAN_SET_ON_CLICK_LISTENER;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return C2C_ZPLAN_SET_VISIABLE;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return C2C_ZPLAN_SHOW_SMALL_HOME_TIPS_UI;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return C2C_ZPLAN_UPDATE_ICON;
    }
}
