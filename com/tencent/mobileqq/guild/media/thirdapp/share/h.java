package com.tencent.mobileqq.guild.media.thirdapp.share;

import com.tencent.mobileqq.guild.share.y;
import com.tencent.mobileqq.guild.usecases.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/share/h;", "Lcom/tencent/mobileqq/guild/share/y;", "", "title", "fileId", "", "H", "l", "Ljava/lang/String;", "customTitle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "previewFileId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/usecases/b$c;", "shareInfo", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lcom/tencent/mobileqq/guild/usecases/b$c;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h extends y {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String customTitle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String previewFileId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, @NotNull b.c shareInfo) {
        super(guildInfo, channelInfo, shareInfo);
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        this.customTitle = "";
        this.previewFileId = "";
    }

    public final void H(@NotNull String title, @NotNull String fileId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        this.customTitle = title;
        this.previewFileId = fileId;
    }
}
