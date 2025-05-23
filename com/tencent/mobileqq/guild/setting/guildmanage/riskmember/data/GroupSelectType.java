package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/GroupSelectType;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "EMPTY_SELECT", "SELECT_ALL", "CANCEL_SELECT_ALL", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum GroupSelectType {
    EMPTY_SELECT(""),
    SELECT_ALL("\u5168\u9009"),
    CANCEL_SELECT_ALL("\u5168\u4e0d\u9009");


    @NotNull
    private final String text;

    GroupSelectType(String str) {
        this.text = str;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }
}
