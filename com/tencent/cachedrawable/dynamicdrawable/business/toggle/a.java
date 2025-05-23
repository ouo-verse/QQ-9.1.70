package com.tencent.cachedrawable.dynamicdrawable.business.toggle;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import u03.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010 \u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\"\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\t\u0010\u0013R\u0017\u0010#\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010$\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010&\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010'\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u0017\u0010(\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b!\u0010\u0013R\u0017\u0010*\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013\u00a8\u0006-"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/business/toggle/a;", "Lcom/tencent/cachedrawable/dynamicdrawable/business/toggle/b;", "", DomainData.DOMAIN_NAME, "", "title", "", "default", "a", "b", "Lcom/tencent/cachedrawable/dynamicdrawable/business/toggle/b;", "getSInstance", "()Lcom/tencent/cachedrawable/dynamicdrawable/business/toggle/b;", "setSInstance", "(Lcom/tencent/cachedrawable/dynamicdrawable/business/toggle/b;)V", "sInstance", "c", "Z", h.F, "()Z", "DISABLE_HARDWARE_SWITCH", "d", "CACHE_SWITCH", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "STATE_CACHE_SWITCH", "f", "j", "FRAME_CACHE_SWITCH", "g", "k", "FRAME_FILE_CACHE_SWITCH", "ANDROID_O_FD_SWITCH", "i", "ADVANCE_TREATMENT_HARDWARE_BITMAP", "ASYNC_HANDLE_HARDWARE_BITMAP", "CACHE_BITMAP_WEBP_LOSSLESS_QUALITY", "l", "CACHE_BITMAP_PNG_QUALITY_100", "REMOVE_ALIKE_KEY", "FILE_READABLE_SWITCH", "o", "DESTROY_CACHE_IMAGE", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f98868a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/DynamicDrawable/Inject_DynamicToggle.yml", version = 1)
    @Nullable
    private static b sInstance;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final boolean DISABLE_HARDWARE_SWITCH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final boolean CACHE_SWITCH;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final boolean STATE_CACHE_SWITCH;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final boolean FRAME_CACHE_SWITCH;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final boolean FRAME_FILE_CACHE_SWITCH;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final boolean ANDROID_O_FD_SWITCH;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final boolean ADVANCE_TREATMENT_HARDWARE_BITMAP;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final boolean ASYNC_HANDLE_HARDWARE_BITMAP;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final boolean CACHE_BITMAP_WEBP_LOSSLESS_QUALITY;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final boolean CACHE_BITMAP_PNG_QUALITY_100;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static final boolean REMOVE_ALIKE_KEY;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static final boolean FILE_READABLE_SWITCH;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static final boolean DESTROY_CACHE_IMAGE;

    /* renamed from: p, reason: collision with root package name */
    private static ArrayList f98883p;

    static {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8139);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f98883p = arrayList;
        arrayList.add(f.class);
        a aVar = new a();
        f98868a = aVar;
        aVar.n();
        DISABLE_HARDWARE_SWITCH = aVar.a("dynamic_disable_hardware_switch", true);
        boolean a16 = aVar.a("dynamic_cache_switch", true);
        CACHE_SWITCH = a16;
        if (aVar.a("dynamic_state_cache_switch", true) && a16) {
            z16 = true;
        } else {
            z16 = false;
        }
        STATE_CACHE_SWITCH = z16;
        if (aVar.a("dynamic_frame_cache_switch", true) && a16) {
            z17 = true;
        } else {
            z17 = false;
        }
        FRAME_CACHE_SWITCH = z17;
        if (aVar.a("dynamic_frame_file_cache_switch", true) && a16) {
            z18 = true;
        } else {
            z18 = false;
        }
        FRAME_FILE_CACHE_SWITCH = z18;
        ANDROID_O_FD_SWITCH = aVar.a("dynamic_android_o_fd_switch", true);
        ADVANCE_TREATMENT_HARDWARE_BITMAP = aVar.a("dynamic_advance_treatment_hardware_bitmap", true);
        ASYNC_HANDLE_HARDWARE_BITMAP = aVar.a("dynamic_async_handle_hardware_bitmap", true);
        CACHE_BITMAP_WEBP_LOSSLESS_QUALITY = aVar.a("dynamic_cache_bitmap_webp_lossless_quality", true);
        CACHE_BITMAP_PNG_QUALITY_100 = aVar.a("dynamic_cache_bitmap_png_quality_100", true);
        REMOVE_ALIKE_KEY = aVar.a("vas_dynamic_remove_alike_key", true);
        FILE_READABLE_SWITCH = aVar.a("vas_file_readable_switch", true);
        DESTROY_CACHE_IMAGE = aVar.a("vas_destroy_cache_image", false);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.toggle.b
    public boolean a(@NotNull String title, boolean r75) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, title, Boolean.valueOf(r75))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(title, "title");
        b bVar = sInstance;
        if (bVar == null || !bVar.a(title, r75)) {
            return false;
        }
        return true;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return ADVANCE_TREATMENT_HARDWARE_BITMAP;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return ANDROID_O_FD_SWITCH;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return ASYNC_HANDLE_HARDWARE_BITMAP;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return CACHE_BITMAP_PNG_QUALITY_100;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return CACHE_BITMAP_WEBP_LOSSLESS_QUALITY;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return DESTROY_CACHE_IMAGE;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return DISABLE_HARDWARE_SWITCH;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return FILE_READABLE_SWITCH;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return FRAME_CACHE_SWITCH;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return FRAME_FILE_CACHE_SWITCH;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return REMOVE_ALIKE_KEY;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return STATE_CACHE_SWITCH;
    }

    @QAutoInitMethod
    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            sInstance = (b) com.tencent.mobileqq.qroute.utils.b.a(f98883p);
        }
    }
}
