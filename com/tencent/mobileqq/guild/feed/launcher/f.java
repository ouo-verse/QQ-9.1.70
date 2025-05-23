package com.tencent.mobileqq.guild.feed.launcher;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.feed.launcher.parser.GuildFeedNativeEditorParser;
import com.tencent.mobileqq.guild.feed.launcher.parser.g;
import com.tencent.mobileqq.guild.feed.launcher.parser.i;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, com.tencent.mobileqq.guild.feed.launcher.parser.a> f220078a;

    static {
        HashMap hashMap = new HashMap();
        f220078a = hashMap;
        hashMap.put("openfeeddetail", new com.tencent.mobileqq.guild.feed.launcher.parser.e());
        hashMap.put("openfeedlist", new g());
        hashMap.put("openfeedpublish", new i());
        hashMap.put("openfeededitor", new GuildFeedNativeEditorParser());
    }

    public static void a(Context context, GuildFeedSchemeBean guildFeedSchemeBean) {
        com.tencent.mobileqq.guild.feed.launcher.parser.a aVar;
        String schemeAction = guildFeedSchemeBean.getSchemeAction();
        QLog.d("GuildFeedSchemeLauncher", 1, "launchGuildByScheme actionName" + schemeAction);
        if (TextUtils.isEmpty(schemeAction) || (aVar = f220078a.get(schemeAction)) == null) {
            return;
        }
        aVar.b(context, guildFeedSchemeBean);
    }

    public static boolean b(String str) {
        return f220078a.containsKey(str);
    }
}
