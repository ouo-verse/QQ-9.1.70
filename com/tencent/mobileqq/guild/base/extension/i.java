package com.tencent.mobileqq.guild.base.extension;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u00012\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Landroid/widget/ImageView;", "", "drawableRes", "filterColor", "", "a", "(Landroid/widget/ImageView;ILjava/lang/Integer;)V", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class i {
    public static final void a(@NotNull ImageView imageView, @DrawableRes int i3, @ColorRes @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        int hash = Objects.hash(QQTheme.getCurrentThemeId(), Integer.valueOf(i3), num);
        Object tag = imageView.getTag(R.id.w7f);
        if (tag == null) {
            tag = 0;
        }
        if (!Intrinsics.areEqual(tag, Integer.valueOf(hash))) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            imageView.setImageDrawable(GuildUIUtils.w(context, i3, num));
            imageView.setTag(R.id.w7f, Integer.valueOf(hash));
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("ImageViewEx", "setSkinDrawable: already set " + hash);
        }
    }
}
