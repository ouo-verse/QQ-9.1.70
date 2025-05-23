package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGameGiftInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFeedGuildInfo;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildLabel;", "Lkotlin/collections/ArrayList;", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendGuild;", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendFeedsGuildTitleSectionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final IGProContentRecommendGuild b(final IGProFeedGuildInfo iGProFeedGuildInfo, final ArrayList<IGProGuildLabel> arrayList) {
        return new IGProContentRecommendGuild() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendFeedsGuildTitleSectionKt$toIGProContentRecommendGuild$1
            @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
            @NotNull
            public String getCover() {
                return "";
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
            @Nullable
            public IGProGameGiftInfo getGiftInfo() {
                return null;
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
            @NotNull
            public String getGuildAvatar() {
                String guildIcon = IGProFeedGuildInfo.this.getGuildIcon();
                Intrinsics.checkNotNullExpressionValue(guildIcon, "feedGuild.guildIcon");
                return guildIcon;
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
            public long getGuildId() {
                return IGProFeedGuildInfo.this.getGuildId();
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
            @NotNull
            public String getGuildIntro() {
                return "";
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
            @NotNull
            public String getGuildName() {
                String guildName = IGProFeedGuildInfo.this.getGuildName();
                Intrinsics.checkNotNullExpressionValue(guildName, "feedGuild.guildName");
                return guildName;
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
            @NotNull
            public String getGuildProfile() {
                return "";
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
            @NotNull
            public byte[] getJoinSig() {
                String joinGuildSig = IGProFeedGuildInfo.this.getJoinGuildSig();
                Intrinsics.checkNotNullExpressionValue(joinGuildSig, "feedGuild.joinGuildSig");
                byte[] bytes = joinGuildSig.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                return bytes;
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
            @NotNull
            public ArrayList<IGProMedalInfo> getMedals() {
                ArrayList<IGProMedalInfo> medals = IGProFeedGuildInfo.this.getMedals();
                Intrinsics.checkNotNullExpressionValue(medals, "feedGuild.medals");
                return medals;
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
            @NotNull
            public ArrayList<IGProGuildLabel> getTagList() {
                return arrayList;
            }
        };
    }
}
