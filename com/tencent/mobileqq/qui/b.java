package com.tencent.mobileqq.qui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J+\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0007J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0012\u001a\u00020\rH\u0007J\u001e\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J\u0010\u0010\u001b\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J(\u0010 \u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eJ\u0010\u0010\"\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0012\u0010$\u001a\u00020#2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0006\u0010%\u001a\u00020#J\u0010\u0010'\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\u0002R\u0016\u0010*\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/qui/b;", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarImmersiveDelegate;", "Landroid/view/Window;", "window", "", "l", "Landroid/view/View;", "view", "", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$ImmersiveType;", "type", "a", "(Landroid/view/View;[Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$ImmersiveType;)V", "", "heightWithoutNavigationBarHeight", "c", "paddingBottomWithoutNavigationBarHeight", "f", "marginBottomWithoutNavigationBarHeight", "e", "Landroid/view/ViewGroup;", "parentView", "Landroid/graphics/drawable/Drawable;", "drawable", "g", "Landroid/content/Context;", "context", h.F, "Landroidx/lifecycle/LifecycleOwner;", "lifecycle", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarHeightChangeCallback;", "callback", "k", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "i", "detectWindow", "j", "b", "Z", "needInitOpen", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b implements RFWNavigationBarImmersiveHelper.NavigationBarImmersiveDelegate {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f276860a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean needInitOpen;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isOpen;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36974);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
            return;
        }
        b bVar = new b();
        f276860a = bVar;
        needInitOpen = true;
        RFWNavigationBarImmersiveHelper.INSTANCE.setNaviBarImmersiveDelegate(bVar);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void d(b bVar, View view, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        bVar.c(view, i3);
    }

    public final void a(@Nullable View view, @NotNull RFWNavigationBarImmersiveHelper.ImmersiveType... type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) type);
        } else {
            Intrinsics.checkNotNullParameter(type, "type");
            RFWNavigationBarImmersiveHelper.INSTANCE.adjustView(view, (RFWNavigationBarImmersiveHelper.ImmersiveType[]) Arrays.copyOf(type, type.length));
        }
    }

    @JvmOverloads
    public final void b(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else {
            d(this, view, 0, 2, null);
        }
    }

    @JvmOverloads
    public final void c(@Nullable View view, int heightWithoutNavigationBarHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, heightWithoutNavigationBarHeight);
        } else {
            RFWNavigationBarImmersiveHelper.INSTANCE.adjustViewHeight(view, heightWithoutNavigationBarHeight);
        }
    }

    @JvmOverloads
    public final void e(@Nullable View view, int marginBottomWithoutNavigationBarHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, marginBottomWithoutNavigationBarHeight);
        } else {
            RFWNavigationBarImmersiveHelper.INSTANCE.adjustViewMarginBottom(view, marginBottomWithoutNavigationBarHeight);
        }
    }

    @JvmOverloads
    public final void f(@Nullable View view, int paddingBottomWithoutNavigationBarHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, paddingBottomWithoutNavigationBarHeight);
        } else {
            RFWNavigationBarImmersiveHelper.INSTANCE.adjustViewPaddingBottom(view, paddingBottomWithoutNavigationBarHeight);
        }
    }

    @JvmOverloads
    public final void g(@Nullable ViewGroup parentView, @Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) parentView, (Object) drawable);
        } else {
            RFWNavigationBarImmersiveHelper.INSTANCE.fillNavigationBarBackgroundView(parentView, drawable);
        }
    }

    public final int h(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context)).intValue();
        }
        return RFWNavigationBarImmersiveHelper.INSTANCE.getCurrentNavigationBarHeight(context);
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(RFWApplication.getApplication(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(RFWApplication.getA\u2026), QMMKVFile.FILE_COMMON)");
        return from.decodeBool("key_navigation_bar_immersive_switch", true);
    }

    @Override // com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper.NavigationBarImmersiveDelegate
    public boolean isOpen(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) context)).booleanValue();
        }
        boolean z16 = !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isSplitViewMode(context);
        if (!((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion() && ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion()) {
            if (needInitOpen) {
                needInitOpen = false;
                isOpen = com.tencent.mobileqq.immersive.a.f();
            }
            if (z16 && isOpen) {
                return true;
            }
            return false;
        }
        if (z16 && i()) {
            return true;
        }
        return false;
    }

    public final boolean j(@Nullable Window detectWindow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) detectWindow)).booleanValue();
        }
        return RFWNavigationBarImmersiveHelper.INSTANCE.hadSetNavigationBarImmersive(detectWindow);
    }

    public final void k(@Nullable Context context, @Nullable LifecycleOwner lifecycle, @Nullable RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, lifecycle, callback);
        } else {
            RFWNavigationBarImmersiveHelper.INSTANCE.registerNavigationBarCallBack(context, lifecycle, callback);
        }
    }

    public final void l(@Nullable Window window) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) window);
        } else {
            RFWNavigationBarImmersiveHelper.INSTANCE.setNavigationBarImmersive(window);
        }
    }

    public final void m(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            RFWNavigationBarImmersiveHelper.INSTANCE.tryRequestFitSystemWindows(view);
        }
    }

    public final void n(@NotNull RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            RFWNavigationBarImmersiveHelper.INSTANCE.unregisterNavigationBarHeightCallBack(callback);
        }
    }
}
