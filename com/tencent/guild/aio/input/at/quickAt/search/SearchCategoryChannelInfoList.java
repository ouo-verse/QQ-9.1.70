package com.tencent.guild.aio.input.at.quickAt.search;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/input/at/quickAt/search/SearchCategoryChannelInfoList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "categoryName", "", "categoryId", "", "categoryType", "", "channelList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;JILjava/util/ArrayList;)V", "getCategoryAlias", "getCategoryId", "getCategoryType", "getChannelInfoList", "getCloseSwitch", "", "getFolded", "getName", "getNavigation", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationV2Info;", "getUrl", "getUrlType", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SearchCategoryChannelInfoList implements IGProCategoryChannelInfoList {
    private final long categoryId;

    @NotNull
    private final String categoryName;
    private final int categoryType;

    @NotNull
    private final ArrayList<IGProChannel> channelList;

    public SearchCategoryChannelInfoList(@NotNull String categoryName, long j3, int i3, @NotNull ArrayList<IGProChannel> channelList) {
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(channelList, "channelList");
        this.categoryName = categoryName;
        this.categoryId = j3;
        this.categoryType = i3;
        this.channelList = channelList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    @NotNull
    public String getCategoryAlias() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public long getCategoryId() {
        return this.categoryId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public int getCategoryType() {
        return this.categoryType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    @NotNull
    public ArrayList<IGProChannel> getChannelInfoList() {
        return this.channelList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public boolean getCloseSwitch() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public boolean getFolded() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    @NotNull
    /* renamed from: getName, reason: from getter */
    public String getCategoryName() {
        return this.categoryName;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    @NotNull
    public IGProNavigationV2Info getNavigation() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    @NotNull
    public String getUrl() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public int getUrlType() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
