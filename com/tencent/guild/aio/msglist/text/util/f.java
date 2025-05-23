package com.tencent.guild.aio.msglist.text.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0007J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\u0006\u0010\u0015\u001a\u00020\u0006J*\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/util/f;", "", "Landroid/content/Context;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isVasTheme", DomainData.DOMAIN_NAME, "Landroid/content/res/ColorStateList;", "j", "k", "g", tl.h.F, "d", "e", "isSelf", "p", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "b", "isHost", "Landroidx/lifecycle/LiveData;", "Landroid/graphics/Bitmap;", "c", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/Observer;", "observer", "Lcom/tencent/guild/aio/msglist/text/util/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a */
    @NotNull
    public static final f f111944a = new f();

    f() {
    }

    public static /* synthetic */ int f(f fVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = UIUtil.f112434a.A();
        }
        return fVar.e(z16);
    }

    public static /* synthetic */ int i(f fVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = UIUtil.f112434a.A();
        }
        return fVar.h(z16);
    }

    public static /* synthetic */ int l(f fVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = UIUtil.f112434a.A();
        }
        return fVar.k(z16);
    }

    public static /* synthetic */ int o(f fVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = UIUtil.f112434a.A();
        }
        return fVar.n(z16);
    }

    public static final void r(LiveData it, Observer observer) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        it.removeObserver(observer);
    }

    @ColorInt
    public final int b(@NotNull Resources r36, boolean isVasTheme) {
        Intrinsics.checkNotNullParameter(r36, "resources");
        if (isVasTheme) {
            return GuildUIUtils.f235378a.E(ResourcesCompat.getColor(r36, R.color.skin_chat_buble, null), 0.5f);
        }
        return ResourcesCompat.getColor(r36, R.color.qui_common_bubble_guest_text_secondary, null);
    }

    @NotNull
    public final LiveData<Bitmap> c(boolean isHost) {
        return ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).obtainBubbleDrawableBitmap(p(isHost));
    }

    @NotNull
    public final ColorStateList d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList colorStateList = context.getColorStateList(f(this, false, 1, null));
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.getColorStateList(getGuestLinkColorRes())");
        return colorStateList;
    }

    @ColorRes
    public final int e(boolean isVasTheme) {
        if (isVasTheme) {
            return R.color.skin_chat_buble_link;
        }
        return R.color.qui_common_text_link;
    }

    public final int g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getColor(i(this, false, 1, null));
    }

    @ColorRes
    public final int h(boolean z16) {
        if (z16) {
            return R.color.skin_chat_buble;
        }
        return R.color.qui_common_bubble_guest_text_primary;
    }

    @NotNull
    public final ColorStateList j(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList colorStateList = context.getColorStateList(l(this, false, 1, null));
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.getColorStateList(getHostLinkColorRes())");
        return colorStateList;
    }

    @ColorRes
    public final int k(boolean isVasTheme) {
        if (isVasTheme) {
            return R.color.skin_chat_buble_link_mine;
        }
        return R.color.qui_common_bubble_host_text_link;
    }

    public final int m(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getColor(o(this, false, 1, null));
    }

    @ColorRes
    public final int n(boolean z16) {
        if (z16) {
            return R.color.skin_chat_buble_mine;
        }
        return R.color.qui_common_bubble_host_text_primary;
    }

    @DrawableRes
    public final int p(boolean isSelf) {
        if (isSelf) {
            return R.drawable.skin_aio_user_bubble_nor;
        }
        return R.drawable.skin_aio_friend_bubble_nor;
    }

    @NotNull
    public final c q(boolean z16, @Nullable LifecycleOwner lifecycleOwner, @NotNull final Observer<Bitmap> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        final LiveData<Bitmap> c16 = c(z16);
        if (lifecycleOwner != null) {
            c16.observe(lifecycleOwner, observer);
        } else {
            c16.observeForever(observer);
        }
        return new c() { // from class: com.tencent.guild.aio.msglist.text.util.e
            @Override // com.tencent.guild.aio.msglist.text.util.c
            public final void detach() {
                f.r(LiveData.this, observer);
            }
        };
    }
}
