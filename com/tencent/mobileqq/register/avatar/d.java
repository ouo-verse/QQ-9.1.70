package com.tencent.mobileqq.register.avatar;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.register.bean.ZPlanAvatarInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000e\u001a\u00020\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/register/avatar/d;", "", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "avatarInfo", "Landroid/net/Uri;", "avatarUri", "", "uin", "", "d", "c", "a", "b", "", "e", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "zPlanAvatarInfo", "Landroid/net/Uri;", "avatarInfoUri", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f280340a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ZPlanAvatarInfo zPlanAvatarInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Uri avatarInfoUri;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String uin;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f280340a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final synchronized Uri a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Uri) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return avatarInfoUri;
    }

    @Nullable
    public final synchronized String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return uin;
    }

    @Nullable
    public final synchronized ZPlanAvatarInfo c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ZPlanAvatarInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return zPlanAvatarInfo;
    }

    public final synchronized void d(@Nullable ZPlanAvatarInfo avatarInfo, @Nullable Uri avatarUri, @Nullable String uin2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, avatarInfo, avatarUri, uin2);
            return;
        }
        zPlanAvatarInfo = avatarInfo;
        avatarInfoUri = avatarUri;
        uin = uin2;
    }

    public final synchronized boolean e() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (zPlanAvatarInfo == null && avatarInfoUri == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        return z16;
    }
}
