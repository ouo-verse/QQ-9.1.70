package com.tencent.guild.aio.msglist.text.util;

import android.graphics.Bitmap;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public /* synthetic */ class GuildCombineUtil$handleMixBubbleCombineMsgBg$1 extends FunctionReferenceImpl implements Function2<GuildMsgItem, View, Observer<Bitmap>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildCombineUtil$handleMixBubbleCombineMsgBg$1(Object obj) {
        super(2, obj, GuildCombineUtil.class, "getMixBubbleBackgroundColorResObserver", "getMixBubbleBackgroundColorResObserver(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Landroid/view/View;)Landroidx/lifecycle/Observer;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final Observer<Bitmap> invoke(@NotNull GuildMsgItem p06, @NotNull View p16) {
        Observer<Bitmap> o16;
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        o16 = ((GuildCombineUtil) this.receiver).o(p06, p16);
        return o16;
    }
}
