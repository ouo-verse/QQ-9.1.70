package com.tencent.mobileqq.guild.feed.gallery.comment.part;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import el1.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class GuildFeedGalleryCommentInputPart$getSpeakPermissionAsync$1 extends Lambda implements Function1<IGProGuildInfo, Unit> {
    final /* synthetic */ Function1<SpeakPermissionType, Unit> $block;
    final /* synthetic */ GuildFeedGalleryCommentInputPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildFeedGalleryCommentInputPart$getSpeakPermissionAsync$1(GuildFeedGalleryCommentInputPart guildFeedGalleryCommentInputPart, Function1<? super SpeakPermissionType, Unit> function1) {
        super(1);
        this.this$0 = guildFeedGalleryCommentInputPart;
        this.$block = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(IGProGuildInfo iGProGuildInfo, GuildFeedGalleryCommentInputPart this$0, Function1 block) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(block, "$block");
        if (Intrinsics.areEqual(iGProGuildInfo.getGuildID(), this$0.getGuildId())) {
            SpeakPermissionType b16 = new el1.a(new a.Companion.Args(this$0.getGuildId(), this$0.getChannelId())).b(iGProGuildInfo);
            block.invoke(b16);
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentInputPart", 1, "updateSpeakPermission newSpeakPermission = " + b16);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
        invoke2(iGProGuildInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null) {
            QLog.e("Guild_Feed_GAL_GuildFeedGalleryCommentInputPart", 1, "fetchGuildInfoAnyway guildInfo is null.");
            return;
        }
        RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
        final GuildFeedGalleryCommentInputPart guildFeedGalleryCommentInputPart = this.this$0;
        final Function1<SpeakPermissionType, Unit> function1 = this.$block;
        rFWThreadManager.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.j
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryCommentInputPart$getSpeakPermissionAsync$1.b(IGProGuildInfo.this, guildFeedGalleryCommentInputPart, function1);
            }
        });
    }
}
