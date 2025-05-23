package com.qzone.reborn.part.publish.common.draft;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/part/publish/common/draft/QZonePublishAtFriendBean;", "Ljava/io/Serializable;", "", "uin", "J", "getUin", "()J", "setUin", "(J)V", "", "nickname", "Ljava/lang/String;", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePublishAtFriendBean implements Serializable {
    public static final long serialVersionUID = 2;
    private String nickname = "";
    private long uin;

    public final String getNickname() {
        return this.nickname;
    }

    public final long getUin() {
        return this.uin;
    }

    public final void setNickname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickname = str;
    }

    public final void setUin(long j3) {
        this.uin = j3;
    }
}
