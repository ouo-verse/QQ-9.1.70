package com.tencent.mobileqq.guild.share;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;", "", "tName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTName", "()Ljava/lang/String;", "Contact", "TuWen", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum ArkTemplateStr {
    Contact("ark_contact"),
    TuWen("ark_tuwen");


    @NotNull
    private final String tName;

    ArkTemplateStr(String str) {
        this.tName = str;
    }

    @NotNull
    public final String getTName() {
        return this.tName;
    }
}
