package com.tencent.mobileqq.guild.home.viewmodels.header.uidata;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/GuildNavigationInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationInfo;", "iconUrl", "", "title", WadlProxyConsts.KEY_JUMP_URL, "jumpUrlType", "", "showBubble", "", "getBubbleDesc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V", "getIconUrl", "getJumpUrl", "getJumpUrlType", "getShowBubble", "getTitle", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildNavigationInfo implements IGProNavigationInfo {

    @NotNull
    private final String getBubbleDesc;

    @NotNull
    private final String iconUrl;

    @NotNull
    private final String jumpUrl;
    private final int jumpUrlType;
    private final boolean showBubble;

    @NotNull
    private final String title;

    public GuildNavigationInfo(@NotNull String iconUrl, @NotNull String title, @NotNull String jumpUrl, int i3, boolean z16, @NotNull String getBubbleDesc) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(getBubbleDesc, "getBubbleDesc");
        this.iconUrl = iconUrl;
        this.title = title;
        this.jumpUrl = jumpUrl;
        this.jumpUrlType = i3;
        this.showBubble = z16;
        this.getBubbleDesc = getBubbleDesc;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    @NotNull
    /* renamed from: getBubbleDesc, reason: from getter */
    public String getGetBubbleDesc() {
        return this.getBubbleDesc;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    @NotNull
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    @NotNull
    public String getJumpUrl() {
        return this.jumpUrl;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    public int getJumpUrlType() {
        return this.jumpUrlType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    public boolean getShowBubble() {
        return this.showBubble;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    @NotNull
    public String getTitle() {
        return this.title;
    }
}
