package com.tencent.open.virtual;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.open.agent.util.t;
import com.tencent.qqnt.avatar.meta.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\"\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J$\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/open/virtual/f;", "", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "proAvatarView", "", "uin", "", "size", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "imageView", "l", "", "enableZplanOutbound", "Lcom/tencent/qqnt/avatar/fetch/c;", "f", "Landroid/view/View;", "faceIcon", "i", tl.h.F, "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f341779a = new f();

    f() {
    }

    private final com.tencent.qqnt.avatar.fetch.c f(String uin, int size, boolean enableZplanOutbound) {
        Drawable drawable;
        boolean z16;
        Resources resources = MobileQQ.sMobileQQ.getResources();
        if (resources == null || (drawable = resources.getDrawable(R.drawable.csy)) == null) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        Drawable drawable2 = drawable;
        Setting n3 = com.tencent.mobileqq.avatar.utils.c.n(uin);
        t.f("OpenSdkVirtualAvatarUtils", "loadUserAvatar setting: " + n3);
        if (n3 != null && !TextUtils.isEmpty(n3.url)) {
            b.a a16 = new b.a(1, uin, size, false, 8, null).a(FaceConstant.ProAvatarBeanKeys.USE_LOCAL_AVATAR_INFO, n3);
            if (enableZplanOutbound) {
                a16.a(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.TRUE).a("KEY_BEAN_KEY_SUFFIX", "sz_local_" + n3.headImgTimestamp);
            }
            return new com.tencent.qqnt.avatar.fetch.c(a16.b(), null, drawable2, null, false, null, 58, null);
        }
        String url = com.tencent.mobileqq.avatar.utils.c.c(uin);
        t.f("OpenSdkVirtualAvatarUtils", "loadUserAvatar url: " + url);
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        Uri parse = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
        b.a aVar = new b.a(parse, false);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return new com.tencent.qqnt.avatar.fetch.c(aVar.a("KEY_BEAN_KEY_SUFFIX", url).b(), null, drawable2, null, false, null, 58, null);
    }

    static /* synthetic */ com.tencent.qqnt.avatar.fetch.c g(f fVar, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        return fVar.f(str, i3, z16);
    }

    private final boolean h() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("open_load_avatar_in_sub_thread_switch", true);
    }

    private final void i(final String uin, final View faceIcon) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.virtual.d
            @Override // java.lang.Runnable
            public final void run() {
                f.j(uin, faceIcon);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final String uin, final View faceIcon) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(faceIcon, "$faceIcon");
        final Bitmap i3 = OpenSdkVirtualUtil.i(uin, 58, true);
        faceIcon.post(new Runnable() { // from class: com.tencent.open.virtual.e
            @Override // java.lang.Runnable
            public final void run() {
                f.k(i3, uin, faceIcon);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Bitmap bitmap, String uin, View faceIcon) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(faceIcon, "$faceIcon");
        if (bitmap != null) {
            t.b("OpenSdkVirtualAvatarUtils", "loadLocalBitmap success = " + com.tencent.open.agent.util.g.C(uin));
            if (faceIcon instanceof ImageView) {
                ((ImageView) faceIcon).setImageBitmap(bitmap);
                return;
            } else {
                if (faceIcon instanceof QQProAvatarView) {
                    ((QQProAvatarView) faceIcon).setImageBitmap(bitmap);
                    return;
                }
                return;
            }
        }
        try {
            t.b("OpenSdkVirtualAvatarUtils", "loadLocalBitmap use default uin = " + com.tencent.open.agent.util.g.C(uin));
            if (faceIcon instanceof ImageView) {
                ((ImageView) faceIcon).setImageResource(R.drawable.csy);
            } else if (faceIcon instanceof QQProAvatarView) {
                ((QQProAvatarView) faceIcon).setImageResource(R.drawable.csy);
            }
        } catch (OutOfMemoryError unused) {
            t.e("OpenSdkVirtualAvatarUtils", "-->loadLocalBitmap oom uin = " + com.tencent.open.agent.util.g.C(uin));
        }
    }

    @JvmStatic
    public static final void l(@NotNull final ImageView imageView, @NotNull final String uin, final int size) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Runnable runnable = new Runnable() { // from class: com.tencent.open.virtual.b
            @Override // java.lang.Runnable
            public final void run() {
                f.o(uin, size, imageView);
            }
        };
        if (f341779a.h()) {
            ThreadManagerV2.excute(runnable, 32, null, false);
        } else {
            runnable.run();
        }
    }

    @JvmStatic
    public static final void m(@NotNull final QQProAvatarView proAvatarView, @NotNull final String uin, final int size) {
        Intrinsics.checkNotNullParameter(proAvatarView, "proAvatarView");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Runnable runnable = new Runnable() { // from class: com.tencent.open.virtual.a
            @Override // java.lang.Runnable
            public final void run() {
                f.n(uin, size, proAvatarView);
            }
        };
        if (f341779a.h()) {
            ThreadManagerV2.excute(runnable, 32, null, false);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String uin, int i3, QQProAvatarView proAvatarView) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(proAvatarView, "$proAvatarView");
        f fVar = f341779a;
        com.tencent.qqnt.avatar.fetch.c g16 = g(fVar, uin, i3, false, 4, null);
        t.f("OpenSdkVirtualAvatarUtils", "loadUserAvatar request: " + g16);
        if (g16 != null) {
            proAvatarView.z(g16, false);
        } else {
            fVar.i(uin, proAvatarView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String uin, int i3, final ImageView imageView) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        f fVar = f341779a;
        com.tencent.qqnt.avatar.fetch.c f16 = fVar.f(uin, i3, false);
        if (f16 == null) {
            fVar.i(uin, imageView);
            return;
        }
        if (imageView.getDrawable() instanceof QQProAvatarDrawable) {
            Drawable drawable = imageView.getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.tencent.mobileqq.proavatar.QQProAvatarDrawable");
            ((QQProAvatarDrawable) drawable).y(imageView.getContext(), f16);
        } else {
            final QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
            qQProAvatarDrawable.y(imageView.getContext(), f16);
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                imageView.setImageDrawable(qQProAvatarDrawable);
            } else {
                imageView.post(new Runnable() { // from class: com.tencent.open.virtual.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.p(imageView, qQProAvatarDrawable);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ImageView imageView, QQProAvatarDrawable qqProAvatarDrawable) {
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(qqProAvatarDrawable, "$qqProAvatarDrawable");
        imageView.setImageDrawable(qqProAvatarDrawable);
    }
}
