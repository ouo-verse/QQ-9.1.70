package com.tencent.mobileqq.guild.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.guild.api.IGuildUIApi;
import com.tencent.mobileqq.guild.discovery.widget.detail.DetailMediaMusicDrawable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildUIApiImpl implements IGuildUIApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildUIApi
    public Drawable getMixBackgroundDrawable(String str) {
        DetailMediaMusicDrawable detailMediaMusicDrawable = new DetailMediaMusicDrawable();
        detailMediaMusicDrawable.e(str);
        return detailMediaMusicDrawable;
    }
}
