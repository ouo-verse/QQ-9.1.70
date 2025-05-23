package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInit;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ck {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    HashMap<String, GProChannelInfo> f265871a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    b f265872b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    List<b> f265873c;

    public ck(GProGuildInit gProGuildInit) {
        com.tencent.mobileqq.qqguildsdk.util.h.i("GuildInitInfo", true, "system convert", "GuildInitInfo guildID :" + gProGuildInit.getGuildId());
        this.f265871a = com.tencent.mobileqq.qqguildsdk.util.g.p(gProGuildInit.getChannelMap());
        this.f265872b = com.tencent.mobileqq.qqguildsdk.util.g.f(gProGuildInit.getUncategorizedChannels());
        this.f265873c = com.tencent.mobileqq.qqguildsdk.util.g.g(gProGuildInit.getCategoryList());
        com.tencent.mobileqq.qqguildsdk.util.h.i("GuildInitInfo", false, "system convert", "GuildInitInfo mUncategorizedChannels :" + this.f265872b.e().size() + MsgSummary.STR_COLON + this.f265872b);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GuildInitInfo mCategoryList :");
        sb5.append(this.f265873c.size());
        com.tencent.mobileqq.qqguildsdk.util.h.i("GuildInitInfo", false, "system convert", sb5.toString());
        com.tencent.mobileqq.qqguildsdk.util.h.u("GuildInitInfo", true, "system convert", "______init:" + gProGuildInit);
    }

    @NonNull
    public List<b> a() {
        return this.f265873c;
    }

    @NonNull
    public HashMap<String, GProChannelInfo> b() {
        return this.f265871a;
    }

    @NonNull
    public b c() {
        return this.f265872b;
    }

    public boolean d() {
        if (this.f265871a.isEmpty()) {
            return true;
        }
        if (this.f265872b.e().isEmpty() && this.f265873c.isEmpty()) {
            return true;
        }
        return false;
    }
}
