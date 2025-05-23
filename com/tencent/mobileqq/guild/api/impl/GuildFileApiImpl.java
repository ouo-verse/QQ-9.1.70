package com.tencent.mobileqq.guild.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.guild.api.IGuildFileApi;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildFileApiImpl implements IGuildFileApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildFileApi
    public boolean isLegalForSelectedFileName(String str) {
        if (!TextUtils.isEmpty(str) && !QQEmojiUtil.containsEmoji(str)) {
            return true;
        }
        return false;
    }
}
