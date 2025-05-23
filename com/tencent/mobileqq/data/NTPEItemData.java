package com.tencent.mobileqq.data;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/data/NTPEItemData;", "", "", "pokeEmoId", "I", "getPokeEmoId", "()I", "setPokeEmoId", "(I)V", "", "localPath", "Ljava/lang/String;", "getLocalPath", "()Ljava/lang/String;", "setLocalPath", "(Ljava/lang/String;)V", "<init>", "()V", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class NTPEItemData {

    @Nullable
    private String localPath;
    private int pokeEmoId;

    @Nullable
    public final String getLocalPath() {
        return this.localPath;
    }

    public final int getPokeEmoId() {
        return this.pokeEmoId;
    }

    public final void setLocalPath(@Nullable String str) {
        this.localPath = str;
    }

    public final void setPokeEmoId(int i3) {
        this.pokeEmoId = i3;
    }
}
