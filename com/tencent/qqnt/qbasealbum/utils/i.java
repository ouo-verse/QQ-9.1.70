package com.tencent.qqnt.qbasealbum.utils;

import android.content.Context;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/utils/i;", "", "Landroid/content/Context;", "context", "", "a", "", "", "b", "[Ljava/lang/String;", "PERMS", "c", "Z", "sHasStoragePermission", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f361663a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] PERMS;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean sHasStoragePermission;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45288);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f361663a = new i();
            PERMS = new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, DeviceInfoUtil.PERMISSION_READ_PHONE};
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
        }
        boolean z16 = sHasStoragePermission;
        if (!z16) {
            boolean z17 = false;
            if (context != null && context.checkSelfPermission(PERMS[0]) == 0) {
                z17 = true;
            }
            if (z17) {
                sHasStoragePermission = true;
                return true;
            }
            return z16;
        }
        return z16;
    }
}
