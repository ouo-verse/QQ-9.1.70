package com.tencent.mobileqq.guild.feed.picshare.restorer;

import com.tencent.ark.ark;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.feed.picshare.restorer.media.MediaType;
import com.tencent.mobileqq.guild.feed.picshare.restorer.media.d;
import com.tencent.mobileqq.guild.feed.picshare.restorer.text.ChannelInfoParser;
import com.tencent.qphone.base.util.QLog;
import en1.a;
import fn1.b;
import fn1.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/picshare/restorer/FeedDetailJsonParser;", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser;", "", ark.ARKMETADATA_JSON, "", "parser", "", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "getMediaInfoList", "getFeedId", "", "getContentData", "getTitleData", "getGuildId", "getChannelId", "getAnchorUid", "getAnchorNick", "", "getCreateTime", "Len1/a$a;", "parseResult", "Len1/a$a;", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/text/ChannelInfoParser;", "channelInfoParser", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/text/ChannelInfoParser;", "Lfn1/b;", "feedOtherInfoParser", "Lfn1/b;", "Len1/a;", "parserList", "Ljava/util/List;", "<init>", "()V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedDetailJsonParser implements IFeedDetailDataParser {

    @NotNull
    public static final String TAG = "FeedDetailJsonParser";

    @NotNull
    private final List<a> parserList;

    @NotNull
    private final a.C10251a parseResult = new a.C10251a(null, null, 3, null);

    @NotNull
    private ChannelInfoParser channelInfoParser = new ChannelInfoParser();

    @NotNull
    private b feedOtherInfoParser = new b();

    public FeedDetailJsonParser() {
        List<a> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new g(), new d(), this.channelInfoParser, this.feedOtherInfoParser});
        this.parserList = listOf;
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public String getAnchorNick() {
        return this.channelInfoParser.getAnchorInfo().getNick();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public String getAnchorUid() {
        return this.channelInfoParser.getAnchorInfo().getAnchorUid();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public String getChannelId() {
        return this.channelInfoParser.getChannelInfo().getChannelId();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public CharSequence getContentData() {
        return this.parseResult.getTextContent();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    public long getCreateTime() {
        return this.feedOtherInfoParser.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public String getFeedId() {
        return this.channelInfoParser.getFeedID();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public String getGuildId() {
        return this.channelInfoParser.getChannelInfo().getGuildID();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public List<IFeedDetailDataParser.MediaInfo> getMediaInfoList() {
        int collectionSizeOrDefault;
        int i3;
        List<com.tencent.mobileqq.guild.feed.picshare.restorer.media.b> a16 = this.parseResult.a();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (com.tencent.mobileqq.guild.feed.picshare.restorer.media.b bVar : a16) {
            if (bVar.getType() == MediaType.IMAGE) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            arrayList.add(new IFeedDetailDataParser.MediaInfo(bVar.getImageUrl(), i3, bVar.getDuration(), bVar.getWidth(), bVar.getHeight(), 0, 32, null));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public CharSequence getTitleData() {
        return "";
    }

    public final void parser(@Nullable String json) {
        boolean z16;
        if (json != null && json.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.i(TAG, 1, "parser fail, json empty");
            return;
        }
        JSONObject jSONObject = new JSONObject(json);
        Iterator<T> it = this.parserList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(jSONObject, this.parseResult);
        }
    }
}
