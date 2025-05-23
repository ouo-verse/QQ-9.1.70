package com.tencent.mobileqq.activity.home.chats;

import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.search.util.y;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\rR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/c;", "", "", "g", "f", "Landroid/graphics/drawable/Drawable;", "a", "c", "b", "e", "d", "", h.F, "Landroid/graphics/drawable/Drawable;", "commonTopListDrawable", "commonListDrawable", "quiTopBgDrawable", "simpleTopDrawable", "Ljava/lang/Boolean;", "isUseQui", "isSimpleMode", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f182991a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Drawable commonTopListDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Drawable commonListDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Drawable quiTopBgDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Drawable simpleTopDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Boolean isUseQui;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Boolean isSimpleMode;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50668);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f182991a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final Drawable a() {
        Drawable drawable = commonListDrawable;
        if (drawable == null) {
            Drawable drawable2 = ContextCompat.getDrawable(MobileQQ.sMobileQQ, R.drawable.f160540jm);
            commonListDrawable = drawable2;
            return drawable2;
        }
        return drawable;
    }

    @JvmStatic
    @Nullable
    public static final Drawable b() {
        Drawable drawable = commonTopListDrawable;
        if (drawable == null) {
            Drawable drawable2 = ContextCompat.getDrawable(MobileQQ.sMobileQQ, R.drawable.f160541jn);
            commonTopListDrawable = drawable2;
            return drawable2;
        }
        return drawable;
    }

    @JvmStatic
    @Nullable
    public static final Drawable c() {
        c cVar = f182991a;
        if (cVar.g()) {
            return d();
        }
        if (cVar.f()) {
            return e();
        }
        return b();
    }

    @JvmStatic
    @Nullable
    public static final Drawable d() {
        Drawable drawable = quiTopBgDrawable;
        if (drawable == null) {
            Drawable drawable2 = ContextCompat.getDrawable(MobileQQ.sMobileQQ, R.drawable.qui_common_fill_light_primary_overlay_light_bg);
            quiTopBgDrawable = drawable2;
            return drawable2;
        }
        return drawable;
    }

    @JvmStatic
    @Nullable
    public static final Drawable e() {
        Drawable drawable = simpleTopDrawable;
        if (drawable == null) {
            Drawable drawable2 = ContextCompat.getDrawable(MobileQQ.sMobileQQ, R.drawable.lm9);
            simpleTopDrawable = drawable2;
            return drawable2;
        }
        return drawable;
    }

    private final boolean f() {
        Boolean bool = isSimpleMode;
        if (bool == null) {
            bool = Boolean.valueOf(SimpleModeHelper.B());
            isSimpleMode = bool;
        }
        return bool.booleanValue();
    }

    private final boolean g() {
        boolean z16;
        Boolean bool = isUseQui;
        if (bool == null) {
            if (y.e() && !QQTheme.isVasTheme() && !QQTheme.isSimpleWhite()) {
                z16 = true;
            } else {
                z16 = false;
            }
            bool = Boolean.valueOf(z16);
            isUseQui = bool;
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static final void h() {
        commonTopListDrawable = null;
        commonListDrawable = null;
        quiTopBgDrawable = null;
        simpleTopDrawable = null;
        isUseQui = null;
        isSimpleMode = null;
    }
}
