package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildItemInfo implements ISSOReqModel, ISSORspModel<GuildItemInfo> {
    public final String appIcon;
    public final long audienceCount;
    public final List<GuildAudienceInfo> audienceInfos;
    public final String channelCreatorHead;
    public final String channelIcon;
    public final long channelId;
    public final String channelName;
    public final String coverUrl;
    public final String extension;
    public final long guildId;
    public final long guildOwner;
    public final String liveInfo;
    public final long roomId;
    public final String subChannelName;
    public final String title;
    public final int type;

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("title", this.title);
        eVar.t("type", this.type);
        eVar.u("audience_count", this.audienceCount);
        b bVar = new b();
        List<GuildAudienceInfo> list = this.audienceInfos;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((GuildAudienceInfo) it.next()).encode());
            }
        }
        eVar.v("audience_infos", bVar);
        eVar.v("sub_channel_name", this.subChannelName);
        eVar.v("channel_name", this.channelName);
        eVar.v("channel_icon", this.channelIcon);
        eVar.v("cover_url", this.coverUrl);
        eVar.v("live_info", this.liveInfo);
        eVar.v(MiniConst.WxMiniAppInfoConst.EXTRA_ICON, this.appIcon);
        eVar.v(MimeTypeParser.ATTR_EXTENSION, this.extension);
        eVar.u("guild_id", this.guildId);
        eVar.u("channel_id", this.channelId);
        eVar.u("guild_owner", this.guildOwner);
        eVar.u("roomId", this.roomId);
        eVar.v("channel_creator_head", this.channelCreatorHead);
        return eVar;
    }

    public GuildItemInfo(String str, int i3, long j3, List<GuildAudienceInfo> list, String str2, String str3, String str4, String str5, String str6, String str7, String str8, long j16, long j17, long j18, long j19, String str9) {
        this.title = str;
        this.type = i3;
        this.audienceCount = j3;
        this.audienceInfos = list;
        this.subChannelName = str2;
        this.channelName = str3;
        this.channelIcon = str4;
        this.coverUrl = str5;
        this.liveInfo = str6;
        this.appIcon = str7;
        this.extension = str8;
        this.guildId = j16;
        this.channelId = j17;
        this.guildOwner = j18;
        this.roomId = j19;
        this.channelCreatorHead = str9;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GuildItemInfo decode(e eVar) {
        ArrayList arrayList;
        List list;
        List list2;
        ArrayList arrayList2;
        String q16 = eVar.q("title", "");
        int k3 = eVar.k("type", 0);
        long j3 = 0;
        long o16 = eVar.o("audience_count", 0L);
        b l3 = eVar.l("audience_infos");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            int i3 = 0;
            while (i3 < c16) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    GuildAudienceInfo guildAudienceInfo = new GuildAudienceInfo(eVar2.o("uin", j3), eVar2.q("icon", ""), eVar2.k("sex", 0));
                    arrayList2 = arrayList;
                    arrayList2.add(guildAudienceInfo);
                } else {
                    arrayList2 = arrayList;
                }
                i3++;
                arrayList = arrayList2;
                j3 = 0;
            }
        } else {
            arrayList = null;
        }
        String q17 = eVar.q("sub_channel_name", "");
        String q18 = eVar.q("channel_name", "");
        String q19 = eVar.q("channel_icon", "");
        String q26 = eVar.q("cover_url", "");
        String q27 = eVar.q("live_info", "");
        String q28 = eVar.q(MiniConst.WxMiniAppInfoConst.EXTRA_ICON, "");
        String q29 = eVar.q(MimeTypeParser.ATTR_EXTENSION, "");
        long o17 = eVar.o("guild_id", 0L);
        long o18 = eVar.o("channel_id", 0L);
        long o19 = eVar.o("guild_owner", 0L);
        long o26 = eVar.o("roomId", 0L);
        String q36 = eVar.q("channel_creator_head", "");
        if (arrayList != null) {
            list2 = CollectionsKt___CollectionsKt.toList(arrayList);
            list = list2;
        } else {
            list = null;
        }
        return new GuildItemInfo(q16, k3, o16, list, q17, q18, q19, q26, q27, q28, q29, o17, o18, o19, o26, q36);
    }
}
