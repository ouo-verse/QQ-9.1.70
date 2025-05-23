package com.tencent.mobileqq.guild.theme;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/theme/h;", "Lcom/tencent/mobileqq/guild/theme/b;", "Landroid/widget/ImageView;", "imageView", "", "drawableRes", "", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h implements b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f235304a = new h();

    h() {
    }

    @Override // com.tencent.mobileqq.guild.theme.b
    public void a(@NotNull ImageView imageView, int drawableRes) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (QQTheme.isVasTheme()) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
            imageView.setImageDrawable(GuildUIUtils.w(context, drawableRes, Integer.valueOf(R.color.qui_common_text_primary)));
            return;
        }
        imageView.setImageResource(drawableRes);
    }
}
