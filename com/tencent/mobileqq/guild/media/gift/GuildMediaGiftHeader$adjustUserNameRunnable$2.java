package com.tencent.mobileqq.guild.media.gift;

import android.widget.TextView;
import com.tencent.mobileqq.guild.media.core.data.p;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildMediaGiftHeader$adjustUserNameRunnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ GuildMediaGiftHeader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaGiftHeader$adjustUserNameRunnable$2(GuildMediaGiftHeader guildMediaGiftHeader) {
        super(0);
        this.this$0 = guildMediaGiftHeader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildMediaGiftHeader this$0) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mUserTinyId == 0) {
            return;
        }
        List<p> list = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "getDataHub().userInfoList.anchors");
        for (p pVar : list) {
            if (Intrinsics.areEqual(pVar.f228093a, String.valueOf(this$0.mUserTinyId))) {
                String str = pVar.f228094b;
                textView = this$0.mUserNameTv;
                if (!Intrinsics.areEqual(str, textView.getText())) {
                    String str2 = pVar.f228094b;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.name");
                    this$0.V0(str2);
                }
            }
        }
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Runnable invoke() {
        final GuildMediaGiftHeader guildMediaGiftHeader = this.this$0;
        return new Runnable() { // from class: com.tencent.mobileqq.guild.media.gift.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaGiftHeader$adjustUserNameRunnable$2.b(GuildMediaGiftHeader.this);
            }
        };
    }
}
