package com.tencent.mobileqq.guild.api.impl;

import android.widget.ImageView;
import com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildQCircleAvatarApiImpl implements IGuildQCircleAvatarApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi
    public void loadAvatarByTinyId(String str, String str2, int i3, ImageView imageView) {
        com.tencent.mobileqq.guild.u.h(str, str2, i3, imageView);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi
    public void loadAvatarByTinyIdAndAvatarMeta(String str, String str2, String str3, int i3, ImageView imageView) {
        com.tencent.mobileqq.guild.u.i(str, str2, str3, i3, imageView);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi
    public void loadAvatarByUrl(String str, ImageView imageView) {
        com.tencent.mobileqq.guild.u.l(imageView, str, null);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi
    public void loadPendantByAvatarPendant(String str, ImageView imageView) {
        com.tencent.mobileqq.guild.avatar.b.e(str, imageView);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi
    public void loadPendantByTinyId(String str, ImageView imageView) {
        com.tencent.mobileqq.guild.avatar.b.f(str, imageView);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi
    public void loadPendantByUrl(String str, ImageView imageView) {
        com.tencent.mobileqq.guild.avatar.b.g(str, imageView);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi
    public void loadAvatarByUrl(String str, ImageView imageView, int i3, int i16) {
        com.tencent.mobileqq.guild.u.k(imageView, str, i3, i16, null);
    }
}
