package com.tencent.guild.aio.input.at.trooptag.dialogui.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "", "title", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "Troop_Page", "Channel_Page", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public enum HashTagPageType {
    Troop_Page("\u6dfb\u52a0\u7fa4\u804a"),
    Channel_Page("\u6dfb\u52a0\u7248\u5757/\u5b50\u9891\u9053");


    @NotNull
    private final String title;

    HashTagPageType(String str) {
        this.title = str;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
