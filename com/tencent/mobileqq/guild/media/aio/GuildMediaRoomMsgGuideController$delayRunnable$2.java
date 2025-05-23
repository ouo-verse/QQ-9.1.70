package com.tencent.mobileqq.guild.media.aio;

import android.view.View;
import com.tencent.mobileqq.guild.media.widget.GuildFadeOutTextView;
import com.tencent.mobileqq.guild.media.widget.GuildMediaRoomMsgGuideView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildMediaRoomMsgGuideController$delayRunnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ GuildMediaRoomMsgGuideController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaRoomMsgGuideController$delayRunnable$2(GuildMediaRoomMsgGuideController guildMediaRoomMsgGuideController) {
        super(0);
        this.this$0 = guildMediaRoomMsgGuideController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildMediaRoomMsgGuideController this$0) {
        View view;
        GuildMediaRoomMsgGuideView guildMediaRoomMsgGuideView;
        GuildFadeOutTextView guildFadeOutTextView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GMediaRMsgGuideContainer", 1, "delayRunnable run ");
        view = this$0.guideContainerView;
        if (view != null) {
            view.setVisibility(0);
        }
        guildMediaRoomMsgGuideView = this$0.guideAnimView;
        if (guildMediaRoomMsgGuideView != null) {
            guildMediaRoomMsgGuideView.u();
        }
        guildFadeOutTextView = this$0.guideTextView;
        if (guildFadeOutTextView != null) {
            guildFadeOutTextView.h();
        }
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Runnable invoke() {
        final GuildMediaRoomMsgGuideController guildMediaRoomMsgGuideController = this.this$0;
        return new Runnable() { // from class: com.tencent.mobileqq.guild.media.aio.aa
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaRoomMsgGuideController$delayRunnable$2.b(GuildMediaRoomMsgGuideController.this);
            }
        };
    }
}
