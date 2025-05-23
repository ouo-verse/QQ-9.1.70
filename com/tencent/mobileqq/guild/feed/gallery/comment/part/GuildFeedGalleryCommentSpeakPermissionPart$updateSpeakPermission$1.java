package com.tencent.mobileqq.guild.feed.gallery.comment.part;

import com.tencent.mobileqq.guild.feed.gallery.data.GuildGalleryCommentPanelParams;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedGalleryCommentSpeakPermissionPart$updateSpeakPermission$1 extends Lambda implements Function1<IGProGuildInfo, Unit> {
    final /* synthetic */ GuildGalleryCommentPanelParams $initBean;
    final /* synthetic */ GuildFeedGalleryCommentSpeakPermissionPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryCommentSpeakPermissionPart$updateSpeakPermission$1(GuildGalleryCommentPanelParams guildGalleryCommentPanelParams, GuildFeedGalleryCommentSpeakPermissionPart guildFeedGalleryCommentSpeakPermissionPart) {
        super(1);
        this.$initBean = guildGalleryCommentPanelParams;
        this.this$0 = guildFeedGalleryCommentSpeakPermissionPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildFeedGalleryCommentSpeakPermissionPart this$0, IGProGuildInfo iGProGuildInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9(iGProGuildInfo);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
        invoke2(iGProGuildInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final IGProGuildInfo iGProGuildInfo) {
        if (!(this.$initBean.getGuildId().length() == 0)) {
            if (!(this.$initBean.getChannelId().length() == 0) && iGProGuildInfo != null) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final GuildFeedGalleryCommentSpeakPermissionPart guildFeedGalleryCommentSpeakPermissionPart = this.this$0;
                rFWThreadManager.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFeedGalleryCommentSpeakPermissionPart$updateSpeakPermission$1.b(GuildFeedGalleryCommentSpeakPermissionPart.this, iGProGuildInfo);
                    }
                });
                return;
            }
        }
        QLog.e("Guild_Feed_GAL_GuildFeedGalleryCommentSpeakPermissionPart", 1, "fetchGuildInfoAnyway guildInfo is null.");
    }
}
