package com.tencent.qqnt.avatar;

import android.app.Application;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.avatar.cache.AvatarInfoCache;
import com.tencent.qqnt.avatar.core.ResourceOrganizer;
import com.tencent.qqnt.avatar.meta.resource.AvatarResourceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u001a\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007J\u0016\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0007J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0007J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0007J\b\u0010$\u001a\u00020\u0004H\u0007J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%J\u001a\u0010,\u001a\u00020\u00042\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-J\u000e\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u000200J\u0006\u00103\u001a\u000200J\u000e\u00104\u001a\u00020\u00042\u0006\u00101\u001a\u000200J\u0006\u00105\u001a\u000200J\u0006\u00106\u001a\u00020\u0004R$\u0010&\u001a\u0004\u0018\u00010%8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010=\u001a\u0002008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010<R$\u0010C\u001a\u00020>2\u0006\u0010?\u001a\u00020>8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bA\u0010BR\"\u0010H\u001a\u0002008\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010<\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010K\u001a\u0002008\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010<\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR$\u0010\"\u001a\u0004\u0018\u00010!8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U\u00a8\u0006X"}, d2 = {"Lcom/tencent/qqnt/avatar/g;", "", "Lcom/tencent/qqnt/avatar/meta/info/d;", "handler", "", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/avatar/meta/info/e;", "avatarInfoBuilder", "k", "Lcom/tencent/qqnt/avatar/meta/resource/b;", "resourceHelper", "r", "", "Lcom/tencent/qqnt/avatar/meta/transform/b;", "handlers", "a", "", "type", "Lcom/tencent/qqnt/avatar/dynamic/drawable/a;", "factory", "b", "Lcom/tencent/qqnt/avatar/meta/info/f;", "helper", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/avatar/meta/cache/b;", "cacheHelper", "l", "Lcom/tencent/qqnt/avatar/util/a;", "logger", "o", "Lcom/tencent/qqnt/avatar/util/c;", "unitedData", "t", "Lcom/tencent/qqnt/avatar/util/b;", "reporter", "p", "d", "Landroid/app/Application;", "application", "j", "", "", "Lcom/tencent/qqnt/avatar/core/a;", "resourceFetcherMap", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/avatar/core/b;", "organizer", ReportConstant.COSTREPORT_PREFIX, "", "switchOn", HippyTKDListViewAdapter.X, "v", "w", "u", "c", "Landroid/app/Application;", "e", "()Landroid/app/Application;", "setApplication$avatar_util_kit_release", "(Landroid/app/Application;)V", "Z", "DEBUG", "", "<set-?>", "J", "f", "()J", "infoCheckTime", "g", "()Z", "setRefreshCallbackRegisterFix$avatar_util_kit_release", "(Z)V", "refreshCallbackRegisterFix", "getOrganizerWeakSwitch$avatar_util_kit_release", "setOrganizerWeakSwitch$avatar_util_kit_release", "organizerWeakSwitch", "Lcom/tencent/qqnt/avatar/util/b;", tl.h.F, "()Lcom/tencent/qqnt/avatar/util/b;", "setReporter$avatar_util_kit_release", "(Lcom/tencent/qqnt/avatar/util/b;)V", "Lcom/tencent/qqnt/avatar/util/c;", "i", "()Lcom/tencent/qqnt/avatar/util/c;", "setUnitedData$avatar_util_kit_release", "(Lcom/tencent/qqnt/avatar/util/c;)V", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f352801a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Application application;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean DEBUG;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long infoCheckTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean refreshCallbackRegisterFix;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean organizerWeakSwitch;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.qqnt.avatar.util.b reporter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.qqnt.avatar.util.c unitedData;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38926);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
            return;
        }
        f352801a = new g();
        infoCheckTime = 86400000L;
        refreshCallbackRegisterFix = true;
        organizerWeakSwitch = true;
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull List<com.tencent.qqnt.avatar.meta.transform.b> handlers) {
        Intrinsics.checkNotNullParameter(handlers, "handlers");
        com.tencent.qqnt.avatar.util.d.f352991a.e("ProAvatarCompose", "addAvatarTransformHandlers handlers size " + handlers.size());
        com.tencent.qqnt.avatar.meta.transform.a.f352982a.a().addAll(handlers);
    }

    @JvmStatic
    public static final void b(@NotNull String type, @NotNull com.tencent.qqnt.avatar.dynamic.drawable.a factory) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(factory, "factory");
        com.tencent.qqnt.avatar.dynamic.drawable.b.f352782a.b().put(type, factory);
    }

    @JvmStatic
    public static final void d() {
        com.tencent.qqnt.avatar.cache.e.f352705a.e(20);
    }

    @JvmStatic
    public static final void k(@NotNull com.tencent.qqnt.avatar.meta.info.e avatarInfoBuilder) {
        Intrinsics.checkNotNullParameter(avatarInfoBuilder, "avatarInfoBuilder");
        com.tencent.qqnt.avatar.meta.info.c.f352932a.d(avatarInfoBuilder);
    }

    @JvmStatic
    public static final void l(@NotNull com.tencent.qqnt.avatar.meta.cache.b cacheHelper) {
        Intrinsics.checkNotNullParameter(cacheHelper, "cacheHelper");
        com.tencent.qqnt.avatar.meta.cache.a.f352913a.b(cacheHelper);
    }

    @JvmStatic
    public static final void m(@NotNull com.tencent.qqnt.avatar.meta.info.f helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        com.tencent.qqnt.avatar.meta.info.c.f352932a.f(helper);
    }

    @JvmStatic
    public static final void n(@NotNull com.tencent.qqnt.avatar.meta.info.d handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        com.tencent.qqnt.avatar.meta.info.c.f352932a.e(handler);
    }

    @JvmStatic
    public static final void o(@NotNull com.tencent.qqnt.avatar.util.a logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        com.tencent.qqnt.avatar.util.d.f352991a.f(logger);
    }

    @JvmStatic
    public static final void p(@NotNull com.tencent.qqnt.avatar.util.b reporter2) {
        Intrinsics.checkNotNullParameter(reporter2, "reporter");
        reporter = reporter2;
    }

    @JvmStatic
    public static final void r(@NotNull com.tencent.qqnt.avatar.meta.resource.b resourceHelper) {
        Intrinsics.checkNotNullParameter(resourceHelper, "resourceHelper");
        AvatarResourceManager.f352954a.j(resourceHelper);
    }

    @JvmStatic
    public static final void t(@NotNull com.tencent.qqnt.avatar.util.c unitedData2) {
        Intrinsics.checkNotNullParameter(unitedData2, "unitedData");
        unitedData = unitedData2;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            AvatarInfoCache.f352688a.b();
            com.tencent.qqnt.avatar.cache.e.f352705a.b();
        }
    }

    @Nullable
    public final Application e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Application) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return application;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return infoCheckTime;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return refreshCallbackRegisterFix;
    }

    @Nullable
    public final com.tencent.qqnt.avatar.util.b h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.qqnt.avatar.util.b) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return reporter;
    }

    @Nullable
    public final com.tencent.qqnt.avatar.util.c i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.qqnt.avatar.util.c) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return unitedData;
    }

    public final void j(@NotNull Application application2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) application2);
            return;
        }
        Intrinsics.checkNotNullParameter(application2, "application");
        application = application2;
        com.tencent.qqnt.avatar.cache.c.f352703a.a(application2);
    }

    public final void q(@NotNull Map<Integer, ? extends com.tencent.qqnt.avatar.core.a> resourceFetcherMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) resourceFetcherMap);
        } else {
            Intrinsics.checkNotNullParameter(resourceFetcherMap, "resourceFetcherMap");
            ResourceOrganizer.INSTANCE.f(resourceFetcherMap);
        }
    }

    public final void s(@NotNull com.tencent.qqnt.avatar.core.b organizer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) organizer);
        } else {
            Intrinsics.checkNotNullParameter(organizer, "organizer");
            ResourceOrganizer.INSTANCE.h(organizer);
        }
    }

    public final boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return organizerWeakSwitch;
    }

    public final boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return refreshCallbackRegisterFix;
    }

    public final void w(boolean switchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, switchOn);
        } else {
            organizerWeakSwitch = switchOn;
        }
    }

    public final void x(boolean switchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, switchOn);
        } else {
            refreshCallbackRegisterFix = switchOn;
        }
    }
}
