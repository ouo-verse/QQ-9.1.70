package com.tencent.qqnt.qbasealbum.inject;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.IPicLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\t\b\u0002\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\fH\u0016J \u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\fH\u0016J\"\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010+\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010*\u001a\u00020)H\u0016J0\u00101\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/\u0018\u00010.j\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/\u0018\u0001`02\u0006\u0010-\u001a\u00020,H\u0016J\u0012\u00102\u001a\u0004\u0018\u00010/2\u0006\u0010-\u001a\u00020,H\u0016J\u0012\u00103\u001a\u0004\u0018\u00010/2\u0006\u0010-\u001a\u00020,H\u0016J*\u00109\u001a\u00020\u000e2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u0010H\u0016J*\u0010:\u001a\u00020\u000e2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010=\u001a\u00020\u000e2\u0006\u00105\u001a\u0002042\u0006\u0010<\u001a\u00020;H\u0016J \u0010A\u001a\u00020\u000e2\u0006\u00105\u001a\u0002042\u0006\u0010>\u001a\u00020\u00102\u0006\u0010@\u001a\u00020?H\u0016J\n\u0010C\u001a\u0004\u0018\u00010BH\u0016J\n\u0010E\u001a\u0004\u0018\u00010DH\u0016J\b\u0010F\u001a\u00020\u0007H\u0016J\b\u0010G\u001a\u00020\fH\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010\u00192\u0006\u0010>\u001a\u00020\u0010H\u0016J\n\u0010J\u001a\u0004\u0018\u00010IH\u0016\u00a8\u0006M"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/inject/g;", "Lcom/tencent/qqnt/qbasealbum/inject/b;", "Lcom/tencent/qqnt/qbasealbum/inject/e;", "Lcom/tencent/qqnt/qbasealbum/inject/IPreference;", "Lcom/tencent/qqnt/qbasealbum/inject/f;", "Lcom/tencent/qqnt/qbasealbum/inject/d;", "Lcom/tencent/qqnt/qbasealbum/inject/c;", "", "isPublicVersion", "isDebugVersion", "Ljava/lang/Runnable;", "runnable", "", "type", "", "execute", "", "key", "defValue", "mode", "getBoolean", "value", "putBoolean", "Landroid/content/Context;", "context", "", "msg", "duration", UIJsPlugin.EVENT_SHOW_TOAST, "isNowThemeIsNight", "o", "getStatusBarHeight", "isCameraResReady", "", "getServerTimeMillis", "k", "e", "r", "a", "Landroid/graphics/drawable/Drawable;", "j", "Landroid/view/View;", "view", "f", "Landroid/content/Intent;", "intent", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "localMediaInfo", "qualityRaw", "business", "l", "i", "Landroid/os/Bundle;", "data", DomainData.DOMAIN_NAME, "comment", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/a;", "listener", tl.h.F, "Lcom/tencent/libra/IPicLoader;", "getPicLoader", "Lcom/tencent/biz/richframework/part/Part;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isSupportMagnifyLongPic", "g", "p", "Landroid/content/ComponentName;", "b", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g implements b, e, IPreference, f, d, c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final g f361234b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 39)) {
            redirector.redirect((short) 39);
        } else {
            f361234b = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        try {
            return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().a();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    @Nullable
    public ComponentName b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (ComponentName) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().b();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.c
    @Nullable
    public LocalMediaInfo c(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 25, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().b().c(intent);
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.c
    @Nullable
    public LocalMediaInfo d(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 26, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().b().d(intent);
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().e();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.e
    public void execute(@NotNull Runnable runnable, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable, type);
        } else {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            com.tencent.qqnt.qbasealbum.a.f360732a.b().f().execute(runnable, type);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public void f(@NotNull Context context, @NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) context, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.qqnt.qbasealbum.a.f360732a.b().c().f(context, view);
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().g();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.IPreference
    public boolean getBoolean(@NotNull String key, boolean defValue, int mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, key, Boolean.valueOf(defValue), Integer.valueOf(mode))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().d().getBoolean(key, defValue, mode);
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    @Nullable
    public IPicLoader getPicLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (IPicLoader) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().getPicLoader();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public long getServerTimeMillis() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().getServerTimeMillis();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public int getStatusBarHeight(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().getStatusBarHeight(context);
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.c
    public void h(@NotNull Activity activity, @NotNull String comment, @NotNull com.tencent.qqnt.qbasealbum.preview.fragment.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, activity, comment, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.qqnt.qbasealbum.a.f360732a.b().b().h(activity, comment, listener);
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.c
    public void i(@NotNull Activity activity, @NotNull LocalMediaInfo localMediaInfo, boolean qualityRaw, @Nullable String business) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, activity, localMediaInfo, Boolean.valueOf(qualityRaw), business);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        com.tencent.qqnt.qbasealbum.a.f360732a.b().b().i(activity, localMediaInfo, qualityRaw, business);
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public boolean isCameraResReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().isCameraResReady();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.b
    public boolean isDebugVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().a().isDebugVersion();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public boolean isNowThemeIsNight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().isNowThemeIsNight();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.b
    public boolean isPublicVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().a().isPublicVersion();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public boolean isSupportMagnifyLongPic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().isSupportMagnifyLongPic();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    @Nullable
    public Drawable j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Drawable) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().j();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().k();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.c
    public void l(@NotNull Activity activity, @NotNull LocalMediaInfo localMediaInfo, boolean qualityRaw, @Nullable String business) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, activity, localMediaInfo, Boolean.valueOf(qualityRaw), business);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        com.tencent.qqnt.qbasealbum.a.f360732a.b().b().l(activity, localMediaInfo, qualityRaw, business);
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.c
    @Nullable
    public HashMap<String, LocalMediaInfo> m(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (HashMap) iPatchRedirector.redirect((short) 24, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().b().m(intent);
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.c
    public void n(@NotNull Activity activity, @NotNull Bundle data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) activity, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.qqnt.qbasealbum.a.f360732a.b().b().n(activity, data);
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().o();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    @Nullable
    public CharSequence p(@NotNull String comment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (CharSequence) iPatchRedirector.redirect((short) 36, (Object) this, (Object) comment);
        }
        Intrinsics.checkNotNullParameter(comment, "comment");
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().p(comment);
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.IPreference
    public void putBoolean(@NotNull String key, boolean value, int mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, key, Boolean.valueOf(value), Integer.valueOf(mode));
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            com.tencent.qqnt.qbasealbum.a.f360732a.b().d().putBoolean(key, value, mode);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    @Nullable
    public Part q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Part) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().q();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.d
    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return com.tencent.qqnt.qbasealbum.a.f360732a.b().c().r();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.f
    public void showToast(@NotNull Context context, @Nullable CharSequence msg2, int duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, msg2, Integer.valueOf(duration));
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            com.tencent.qqnt.qbasealbum.a.f360732a.b().g().showToast(context, msg2, duration);
        }
    }
}
