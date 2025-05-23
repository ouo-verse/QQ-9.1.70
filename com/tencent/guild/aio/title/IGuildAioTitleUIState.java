package com.tencent.guild.aio.title;

import com.tencent.aio.base.mvi.part.TitleUIState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u000eR\u001c\u0010\u0007\u001a\u00020\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "", "getResult", "()Z", "setResult", "(Z)V", "result", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "getType", "()Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "setType", "(Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;)V", "type", "TYPE", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface IGuildAioTitleUIState extends TitleUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "", "(Ljava/lang/String;I)V", "TITLE", "GUILDNAMETITLE", "UNREADMSGCNT", "AVATAR", "DETAIL", "MULTISELECT", "BACKBTN", "EMPTY_DATA", "LOAD_DATA", "MEDAL", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum TYPE {
        TITLE,
        GUILDNAMETITLE,
        UNREADMSGCNT,
        AVATAR,
        DETAIL,
        MULTISELECT,
        BACKBTN,
        EMPTY_DATA,
        LOAD_DATA,
        MEDAL
    }

    boolean getResult();

    @NotNull
    TYPE getType();
}
