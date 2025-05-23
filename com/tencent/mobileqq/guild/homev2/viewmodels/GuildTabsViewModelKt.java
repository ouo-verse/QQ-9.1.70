package com.tencent.mobileqq.guild.homev2.viewmodels;

import com.tencent.mobileqq.guild.util.ay;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildHomeSections;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildHomeSections;", "", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildTabsViewModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(IGProGuildHomeSections iGProGuildHomeSections) {
        String joinToString$default;
        String joinToString$default2;
        int size = iGProGuildHomeSections.getCommonCategories().size();
        ArrayList<IGProCategoryChannelInfoList> commonCategories = iGProGuildHomeSections.getCommonCategories();
        Intrinsics.checkNotNullExpressionValue(commonCategories, "commonCategories");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(commonCategories, null, null, null, 0, null, new Function1<IGProCategoryChannelInfoList, CharSequence>() { // from class: com.tencent.mobileqq.guild.homev2.viewmodels.GuildTabsViewModelKt$logString$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(IGProCategoryChannelInfoList iGProCategoryChannelInfoList) {
                return "[id=" + iGProCategoryChannelInfoList.getCategoryId() + ", name=" + ay.a(iGProCategoryChannelInfoList.getCategoryName()) + "]";
            }
        }, 31, null);
        int size2 = iGProGuildHomeSections.getFeedChannels().size();
        ArrayList<IGProChannel> feedChannels = iGProGuildHomeSections.getFeedChannels();
        Intrinsics.checkNotNullExpressionValue(feedChannels, "feedChannels");
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(feedChannels, null, null, null, 0, null, new Function1<IGProChannel, CharSequence>() { // from class: com.tencent.mobileqq.guild.homev2.viewmodels.GuildTabsViewModelKt$logString$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(IGProChannel iGProChannel) {
                return "[id=" + iGProChannel.getChannelId() + ", name=" + ay.a(iGProChannel.getChannelName()) + "]";
            }
        }, 31, null);
        return "IGProGuildHomeSections(commonCategories=" + size + "{" + joinToString$default + ", feedChannels=" + size2 + "){" + joinToString$default2 + "}";
    }
}
