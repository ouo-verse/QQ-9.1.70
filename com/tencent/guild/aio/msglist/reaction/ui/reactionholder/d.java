package com.tencent.guild.aio.msglist.reaction.ui.reactionholder;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import gq0.EmojiReactionItem;
import gq0.EmojiTaskItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH&J\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;", "", "", "emojiId", "emojiType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "", "t", "Lgq0/b;", "emojiItem", "Lkotlin/Function0;", "updateUI", "G", "Lgq0/c;", HippyTKDListViewAdapter.X, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface d {
    void G(@NotNull EmojiReactionItem emojiItem, @NotNull Function0<Unit> updateUI);

    void t(int emojiId, int emojiType, @NotNull MsgRecord msg2);

    void x(@NotNull EmojiTaskItem emojiItem, @NotNull Function0<Unit> updateUI);
}
