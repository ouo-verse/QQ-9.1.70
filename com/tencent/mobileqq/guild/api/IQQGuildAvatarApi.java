package com.tencent.mobileqq.guild.api;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IQQGuildAvatarApi extends IRuntimeService {
    public static final String COMMON_GUILD_ID = "0";

    Drawable getAvatarDrawable(String str, int i3, int i16, String str2);

    Drawable getAvatarDrawable(String str, int i3, int i16, String str2, boolean z16);

    Drawable getAvatarDrawable(String str, int i3, boolean z16, String str2);

    Drawable getAvatarDrawable(AppRuntime appRuntime, String str, String str2);

    @Nullable
    String getAvatarUrl(AppRuntime appRuntime, String str, String str2);

    Drawable getDefaultFaceDrawable(boolean z16);

    void loadCommonPic(String str, int i3, int i16, GuildLevelRoleView.a aVar);

    void loadCommonPic(String str, ImageView imageView);

    void loadCommonPic(String str, ImageView imageView, boolean z16, Drawable drawable);
}
