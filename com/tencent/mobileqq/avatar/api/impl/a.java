package com.tencent.mobileqq.avatar.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.MetaResourceFetcher;
import com.tencent.qqnt.avatar.meta.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/impl/a;", "", "", "faceType", "", "uin", "a", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f199939a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17274);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f199939a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final String a(int faceType, @NotNull String uin) {
        int i3;
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (faceType == 113) {
            i3 = 4;
        } else {
            i3 = faceType;
        }
        com.tencent.qqnt.avatar.meta.b b16 = new b.a(i3, uin, 140, false, 8, null).b();
        MetaResourceFetcher metaResourceFetcher = MetaResourceFetcher.f352881b;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        String i16 = metaResourceFetcher.i(applicationContext, b16);
        QLog.d("QQAvatarBroadcastServiceUtils", 4, "getAvatarPath [" + faceType + "-" + uin + "]: " + i16);
        return i16;
    }
}
