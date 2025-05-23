package com.tencent.mobileqq.guild.media.widget;

import android.widget.PopupWindow;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildMediaRankingUserCase$stopShowGuideFunc$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ GuildMediaRankingUserCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaRankingUserCase$stopShowGuideFunc$2(GuildMediaRankingUserCase guildMediaRankingUserCase) {
        super(0);
        this.this$0 = guildMediaRankingUserCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildMediaRankingUserCase this$0) {
        PopupWindow popupWindow;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        popupWindow = this$0.mIconBtnBubbleTip;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this$0.mIconBtnBubbleTip = null;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Runnable invoke() {
        final GuildMediaRankingUserCase guildMediaRankingUserCase = this.this$0;
        return new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.w
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaRankingUserCase$stopShowGuideFunc$2.b(GuildMediaRankingUserCase.this);
            }
        };
    }
}
