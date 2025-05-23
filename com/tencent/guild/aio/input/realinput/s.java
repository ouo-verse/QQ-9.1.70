package com.tencent.guild.aio.input.realinput;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.input.IGuildInputBarApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/realinput/s;", "", "Landroid/content/Context;", "context", "Landroid/content/res/ColorStateList;", "b", "", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f111173a = new s();

    s() {
    }

    public final int a() {
        if (UIUtil.f112434a.A()) {
            return ((IGuildInputBarApi) QRoute.api(IGuildInputBarApi.class)).getSkinAioInputBg();
        }
        return R.drawable.qui_common_bg_nav_bottom_aio_bg;
    }

    @NotNull
    public final ColorStateList b(@NotNull Context context) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (UIUtil.f112434a.A()) {
            i3 = R.color.skin_input_theme_version2;
        } else {
            i3 = R.color.qui_common_text_primary;
        }
        ColorStateList colorStateList = context.getColorStateList(i3);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.getColorStateLis\u2026n_text_primary\n        })");
        return colorStateList;
    }
}
