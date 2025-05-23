package com.tencent.mobileqq.guild.feed.gallery.presenter;

import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedGalleryBottomPresenter$getSpeakPermissionAsync$1 extends Lambda implements Function1<IGProGuildInfo, Unit> {
    final /* synthetic */ Function1<SpeakPermissionType, Unit> $block;
    final /* synthetic */ String $guildId;
    final /* synthetic */ GuildFeedGalleryBottomPresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildFeedGalleryBottomPresenter$getSpeakPermissionAsync$1(String str, GuildFeedGalleryBottomPresenter guildFeedGalleryBottomPresenter, Function1<? super SpeakPermissionType, Unit> function1) {
        super(1);
        this.$guildId = str;
        this.this$0 = guildFeedGalleryBottomPresenter;
        this.$block = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String str, GuildFeedGalleryBottomPresenter this$0, IGProGuildInfo iGProGuildInfo, Function1 block) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean3;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(block, "$block");
        guildFeedGalleryInitBean = this$0.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        if (Intrinsics.areEqual(str, guildFeedGalleryInitBean.getGuildId())) {
            guildFeedGalleryInitBean3 = this$0.initBean;
            Intrinsics.checkNotNull(guildFeedGalleryInitBean3);
            String guildId = guildFeedGalleryInitBean3.getGuildId();
            String str2 = "";
            if (guildId == null) {
                guildId = "";
            }
            guildFeedGalleryInitBean4 = this$0.initBean;
            Intrinsics.checkNotNull(guildFeedGalleryInitBean4);
            String channelId = guildFeedGalleryInitBean4.getChannelId();
            if (channelId != null) {
                str2 = channelId;
            }
            SpeakPermissionType b16 = new el1.a(new a.Companion.Args(guildId, str2)).b(iGProGuildInfo);
            block.invoke(b16);
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "updateSpeakPermission newSpeakPermission = " + b16);
            return;
        }
        guildFeedGalleryInitBean2 = this$0.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean2);
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "updateSpeakPermission oldGuildId = " + str + " newGuildId = " + guildFeedGalleryInitBean2.getGuildId());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
        invoke2(iGProGuildInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null) {
            QLog.e("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "fetchGuildInfoAnyway guildInfo is null.");
            return;
        }
        RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
        final String str = this.$guildId;
        final GuildFeedGalleryBottomPresenter guildFeedGalleryBottomPresenter = this.this$0;
        final Function1<SpeakPermissionType, Unit> function1 = this.$block;
        rFWThreadManager.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.k
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryBottomPresenter$getSpeakPermissionAsync$1.b(str, guildFeedGalleryBottomPresenter, iGProGuildInfo, function1);
            }
        });
    }
}
