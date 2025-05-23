package com.tencent.mobileqq.avatar.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.qqnt.avatar.meta.b;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0007J\b\u0010\b\u001a\u00020\u0002H\u0007J\b\u0010\t\u001a\u00020\u0002H\u0007J`\u0010\u0018\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J\b\u0010\u001a\u001a\u00020\u0019H\u0007R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/avatar/utils/ProAvatarComponentUtils;", "", "", "f", "l", h.F, "i", "j", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "", "type", "", "uin", "highPriority", "", "vipPendantId", "pendantTargetId", "enableDynamicAvatar", "dynamicAvatarSource", "Landroid/graphics/drawable/Drawable;", "oldDrawable", "d", "", "g", "Lkotlin/Lazy;", "b", "Lkotlin/Lazy;", "useProAvatarComponent", "c", "isProAvatarDebug", "qZoneAvatarBugfix", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ProAvatarComponentUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final ProAvatarComponentUtils f200135a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final Lazy<Boolean> useProAvatarComponent;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static final Lazy<Boolean> isProAvatarDebug;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private static final Lazy<Boolean> qZoneAvatarBugfix;

    static {
        Lazy<Boolean> lazy;
        Lazy<Boolean> lazy2;
        Lazy<Boolean> lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29873);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f200135a = new ProAvatarComponentUtils();
        lazy = LazyKt__LazyJVMKt.lazy(ProAvatarComponentUtils$useProAvatarComponent$1.INSTANCE);
        useProAvatarComponent = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ProAvatarComponentUtils$isProAvatarDebug$1.INSTANCE);
        isProAvatarDebug = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(ProAvatarComponentUtils$qZoneAvatarBugfix$1.INSTANCE);
        qZoneAvatarBugfix = lazy3;
    }

    ProAvatarComponentUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0121  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Drawable d(@Nullable Context context, int type, @NotNull String uin, boolean highPriority, long vipPendantId, int pendantTargetId, boolean enableDynamicAvatar, int dynamicAvatarSource, @Nullable Drawable oldDrawable) {
        int i3;
        boolean z16;
        ArrayList arrayList;
        b.a aVar;
        int i16;
        boolean z17;
        int i17;
        QQProAvatarDrawable qQProAvatarDrawable;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (type == 113) {
            i3 = 4;
        } else {
            i3 = type;
        }
        b.a aVar2 = new b.a(i3, uin, 140, highPriority);
        if (!QQTheme.isNowThemeIsSuperTheme() && 1 == i3 && !((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(uin)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && dynamicAvatarSource != 0) {
            aVar2.a(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.TRUE);
            aVar2.a("KEY_BEAN_KEY_SUFFIX", "sz");
        }
        aVar2.a(FaceConstant.VAS_SPECIAL_SHAPE_MASK, Integer.valueOf(((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(uin).getSpecialAvatarId()));
        ArrayList arrayList2 = new ArrayList();
        if (vipPendantId > 0) {
            aVar = aVar2;
            arrayList = arrayList2;
            arrayList.add(new f(i3, uin, 140, vipPendantId, 0, null, pendantTargetId, null, null, false, 0, 1920, null));
        } else {
            arrayList = arrayList2;
            aVar = aVar2;
        }
        if (enableDynamicAvatar) {
            z17 = true;
            if (type == 1) {
                i17 = 140;
                arrayList.add(new com.tencent.qqnt.avatar.dynamic.a(1, type, uin, 140));
                if (((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).isEnableMp4Avatar()) {
                    com.tencent.mobileqq.proavatar.a aVar3 = new com.tencent.mobileqq.proavatar.a(type, uin, 100);
                    i16 = dynamicAvatarSource;
                    aVar3.g(i16);
                    arrayList.add(aVar3);
                } else {
                    i16 = dynamicAvatarSource;
                }
                com.tencent.qqnt.avatar.fetch.c cVar = new com.tencent.qqnt.avatar.fetch.c(aVar.b(), arrayList, BaseImageUtil.getDefaultFaceDrawable(), null, false, null, 56, null);
                if (!(oldDrawable instanceof QQProAvatarDrawable) && vipPendantId <= 0) {
                    qQProAvatarDrawable = (QQProAvatarDrawable) oldDrawable;
                } else {
                    qQProAvatarDrawable = new QQProAvatarDrawable();
                }
                qQProAvatarDrawable.y(context, cVar);
                if (i16 != 0) {
                    z18 = false;
                } else {
                    z18 = z17;
                }
                e.a m3 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(i17).e(z18).m(9);
                if (type != z17) {
                    z19 = z17;
                } else {
                    z19 = false;
                }
                e.a b16 = m3.b(z19);
                if (type != z17) {
                    z17 = false;
                }
                qQProAvatarDrawable.x(b16.j(z17).p(i16).a());
                return qQProAvatarDrawable;
            }
            i16 = dynamicAvatarSource;
        } else {
            i16 = dynamicAvatarSource;
            z17 = true;
        }
        i17 = 140;
        com.tencent.qqnt.avatar.fetch.c cVar2 = new com.tencent.qqnt.avatar.fetch.c(aVar.b(), arrayList, BaseImageUtil.getDefaultFaceDrawable(), null, false, null, 56, null);
        if (!(oldDrawable instanceof QQProAvatarDrawable)) {
        }
        qQProAvatarDrawable = new QQProAvatarDrawable();
        qQProAvatarDrawable.y(context, cVar2);
        if (i16 != 0) {
        }
        e.a m36 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(i17).e(z18).m(9);
        if (type != z17) {
        }
        e.a b162 = m36.b(z19);
        if (type != z17) {
        }
        qQProAvatarDrawable.x(b162.j(z17).p(i16).a());
        return qQProAvatarDrawable;
    }

    public static /* synthetic */ Drawable e(Context context, int i3, String str, boolean z16, long j3, int i16, boolean z17, int i17, Drawable drawable, int i18, Object obj) {
        boolean z18;
        long j16;
        int i19;
        boolean z19;
        int i26;
        Drawable drawable2;
        if ((i18 & 8) != 0) {
            z18 = false;
        } else {
            z18 = z16;
        }
        if ((i18 & 16) != 0) {
            j16 = 0;
        } else {
            j16 = j3;
        }
        if ((i18 & 32) != 0) {
            i19 = 0;
        } else {
            i19 = i16;
        }
        if ((i18 & 64) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        if ((i18 & 128) != 0) {
            i26 = 0;
        } else {
            i26 = i17;
        }
        if ((i18 & 256) != 0) {
            drawable2 = null;
        } else {
            drawable2 = drawable;
        }
        return d(context, i3, str, z18, j16, i19, z19, i26, drawable2);
    }

    public final boolean f() {
        return ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).getComponentSwitch();
    }

    @JvmStatic
    public static final void g() {
        ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).initProAvatarComponent();
    }

    public final boolean h() {
        return ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).isProAvatarDebug();
    }

    public final boolean i() {
        return ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).isQZoneAvatarBugfixSwitchOn();
    }

    @JvmStatic
    public static final boolean j() {
        return isProAvatarDebug.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean k() {
        return qZoneAvatarBugfix.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean l() {
        return useProAvatarComponent.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean m() {
        return true;
    }
}
