package com.tencent.mobileqq.guild.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.api.IGuildColorQRCodeApi;
import com.tencent.mobileqq.guild.util.GuildBannerPalette;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pr1.VisitorColorPicker;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildColorQRCodeApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildColorQRCodeApi;", "()V", "isLightColor", "", "color", "", "isNightTheme", "isVasTheme", "obtainColor", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildColorQRCodeApiImpl implements IGuildColorQRCodeApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildColorQRCodeApi
    public boolean isLightColor(int color) {
        return VisitorColorPicker.INSTANCE.b(color);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildColorQRCodeApi
    public boolean isNightTheme() {
        if (!QQTheme.isNowThemeIsNight() && !QQTheme.isNowThemeSimpleNight()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildColorQRCodeApi
    public boolean isVasTheme() {
        return QQTheme.isVasTheme();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildColorQRCodeApi
    public int obtainColor(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return GuildBannerPalette.e(bitmap);
    }
}
