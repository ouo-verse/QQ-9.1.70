package com.tencent.mobileqq.guild.feed.launcher.parser;

import android.content.Context;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedSchemeBean;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class a {
    /* JADX INFO: Access modifiers changed from: protected */
    public String a(HashMap hashMap, String str) {
        if (hashMap.containsKey(str) && (hashMap.get(str) instanceof String)) {
            return (String) hashMap.get(str);
        }
        return "";
    }

    public abstract void b(Context context, GuildFeedSchemeBean guildFeedSchemeBean);
}
