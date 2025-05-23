package com.tencent.mobileqq.wink.editor.music.vo;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/vo/a;", "", "", "xsjQueryText", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setXsjQueryText", "(Ljava/lang/String;)V", "", "xsjQuerySource", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setXsjQuerySource", "(Ljava/lang/Integer;)V", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    @SerializedName("xsjQueryText")
    @Nullable
    private String xsjQueryText = "";

    @SerializedName("xsjMusicSearchQuerySource")
    @Nullable
    private Integer xsjQuerySource = -1;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getXsjQuerySource() {
        return this.xsjQuerySource;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getXsjQueryText() {
        return this.xsjQueryText;
    }
}
