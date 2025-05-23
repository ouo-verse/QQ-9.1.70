package com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist.headerbars.utils;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/rightlist/headerbars/utils/GuildNavigationConvertHelper;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationV2Info;", "navigationInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationInfo;", "a", "<init>", "()V", "GProNavigationV2InfoWrapper", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildNavigationConvertHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildNavigationConvertHelper f227675a = new GuildNavigationConvertHelper();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/rightlist/headerbars/utils/GuildNavigationConvertHelper$GProNavigationV2InfoWrapper;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationInfo;", "navigationInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationV2Info;", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationV2Info;)V", "getBubbleDesc", "", "getIconUrl", "getJumpUrl", "getJumpUrlType", "", "getShowBubble", "", "getTitle", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class GProNavigationV2InfoWrapper implements IGProNavigationInfo {

        @NotNull
        private final IGProNavigationV2Info navigationInfo;

        public GProNavigationV2InfoWrapper(@NotNull IGProNavigationV2Info navigationInfo) {
            Intrinsics.checkNotNullParameter(navigationInfo, "navigationInfo");
            this.navigationInfo = navigationInfo;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
        @NotNull
        /* renamed from: getBubbleDesc */
        public String getGetBubbleDesc() {
            String bubbleDesc = this.navigationInfo.getBubbleDesc();
            Intrinsics.checkNotNullExpressionValue(bubbleDesc, "navigationInfo.bubbleDesc");
            return bubbleDesc;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
        @NotNull
        public String getIconUrl() {
            String iconUrl = this.navigationInfo.getIconUrl();
            Intrinsics.checkNotNullExpressionValue(iconUrl, "navigationInfo.iconUrl");
            return iconUrl;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
        @NotNull
        public String getJumpUrl() {
            String jumpUrl = this.navigationInfo.getJumpUrl();
            Intrinsics.checkNotNullExpressionValue(jumpUrl, "navigationInfo.jumpUrl");
            return jumpUrl;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
        public int getJumpUrlType() {
            return this.navigationInfo.getJumpUrlType();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
        public boolean getShowBubble() {
            return this.navigationInfo.getShowBubble();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
        @NotNull
        public String getTitle() {
            String title = this.navigationInfo.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "navigationInfo.title");
            return title;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
        @NotNull
        public String toString() {
            return this.navigationInfo.toString();
        }
    }

    GuildNavigationConvertHelper() {
    }

    @NotNull
    public final IGProNavigationInfo a(@NotNull IGProNavigationV2Info navigationInfo) {
        Intrinsics.checkNotNullParameter(navigationInfo, "navigationInfo");
        return new GProNavigationV2InfoWrapper(navigationInfo);
    }
}
