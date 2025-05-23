package com.tencent.mobileqq.wink.publish.base;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/base/PublishSettingItem;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "NULL", "TROOP", "PROMOTION", "SCHOOL", "LOCATION", "SHARE_SOURCE", "LABEL", "AT_FRIEND", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum PublishSettingItem {
    NULL(""),
    TROOP("QQ\u7fa4"),
    PROMOTION("\u5546\u54c1"),
    SCHOOL("\u5b66\u6821"),
    LOCATION("\u4f4d\u7f6e"),
    SHARE_SOURCE("\u6765\u6e90"),
    LABEL("\u6807\u7b7e"),
    AT_FRIEND("@\u597d\u53cb\u5217\u8868");


    @NotNull
    private final String text;

    PublishSettingItem(String str) {
        this.text = str;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }
}
