package com.tencent.mobileqq.multishare.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J4\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\"\u0010\u0014\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J6\u0010\u0017\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0012R0\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/multishare/util/d;", "", "", "uin", "", "uinType", "b", "Landroid/content/Context;", "context", "loadScene", "faceType", "Lcom/tencent/mobileqq/armap/e;", "faceObserver", "Landroid/graphics/Bitmap;", "e", "guildId", "Landroid/widget/ImageView;", "avatarView", "", "d", "g", "userUin", "userUinType", "c", "f", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/armap/f;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "avatarLoaders", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f251801a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, com.tencent.mobileqq.armap.f> avatarLoaders;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/multishare/util/d$a", "Lcom/tencent/mobileqq/armap/e;", "", "uin", "headPath", "Landroid/graphics/Bitmap;", "head", "", h.F, "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mobileqq.armap.e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f251803d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f251804e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f251805f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f251806h;

        a(String str, ImageView imageView, String str2, int i3) {
            this.f251803d = str;
            this.f251804e = imageView;
            this.f251805f = str2;
            this.f251806h = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, imageView, str2, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.armap.e
        public void h(@Nullable String uin, @Nullable String headPath, @Nullable Bitmap head) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, uin, headPath, head);
            } else {
                if (!TextUtils.equals(this.f251803d, uin)) {
                    return;
                }
                this.f251804e.setImageDrawable(new BitmapDrawable(head));
                d.f251801a.g(this.f251805f, this.f251806h, this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43343);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f251801a = new d();
            avatarLoaders = new HashMap<>();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int b(String uin, int uinType) {
        int i3;
        if (uinType == 0) {
            return 1;
        }
        if (uinType != 1) {
            if (uinType == 1000 || uinType == 1004 || uinType == 1006) {
                return 1;
            }
            if (uinType != 3000) {
                if (uinType == 6000) {
                    return -1;
                }
                if (uinType == 10008 || uinType == 10010) {
                    return 1;
                }
                return -1;
            }
            return 101;
        }
        if (!((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(uin)) {
            i3 = 113;
        } else {
            i3 = 4;
        }
        return i3;
    }

    private final void d(String guildId, ImageView avatarView) {
        String guildAvatarUrlIPC;
        String str;
        if (MobileQQ.sProcessId == 1) {
            guildAvatarUrlIPC = "";
            IGProGuildInfo guildInfo = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getGuildInfo(guildId);
            if (guildInfo != null) {
                str = guildInfo.getAvatarUrl(100);
            } else {
                str = null;
            }
            if (str != null) {
                guildAvatarUrlIPC = str;
            }
        } else {
            guildAvatarUrlIPC = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildAvatarUrlIPC(guildId, 100);
        }
        Drawable guildFaceIcon = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildFaceIcon(guildAvatarUrlIPC, 100, BaseImageUtil.getDefaultFaceDrawable(false), true);
        if (guildFaceIcon != null) {
            avatarView.setImageDrawable(guildFaceIcon);
        }
    }

    private final Bitmap e(Context context, String loadScene, int faceType, String uin, com.tencent.mobileqq.armap.e faceObserver) {
        String str = loadScene + faceType;
        HashMap<String, com.tencent.mobileqq.armap.f> hashMap = avatarLoaders;
        com.tencent.mobileqq.armap.f fVar = hashMap.get(str);
        if (fVar == null) {
            fVar = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(context, faceType);
            fVar.e((byte) 3);
            fVar.init();
            hashMap.put(str, fVar);
        }
        if (faceObserver != null) {
            fVar.a(faceObserver);
        }
        return fVar.b(uin, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String loadScene, int faceType, com.tencent.mobileqq.armap.e faceObserver) {
        com.tencent.mobileqq.armap.f fVar = avatarLoaders.get(loadScene + faceType);
        if (fVar != null) {
            fVar.f(faceObserver);
        }
    }

    public final void c(@NotNull Context context, @NotNull String userUin, int userUinType, @NotNull String guildId, @NotNull ImageView avatarView, @NotNull String loadScene) {
        Bitmap e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, userUin, Integer.valueOf(userUinType), guildId, avatarView, loadScene);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userUin, "userUin");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(loadScene, "loadScene");
        if (userUinType == 10027) {
            d(guildId, avatarView);
            return;
        }
        int b16 = b(userUin, userUinType);
        if (b16 != -1 && (e16 = e(context, loadScene, b16, userUin, new a(userUin, avatarView, loadScene, b16))) != null) {
            avatarView.setImageDrawable(new BitmapDrawable(e16));
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Iterator<com.tencent.mobileqq.armap.f> it = avatarLoaders.values().iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        avatarLoaders.clear();
    }
}
