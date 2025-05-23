package com.tencent.robot.qqmc.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/qqmc/model/e;", "", "", "toString", "subText", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setSubText", "(Ljava/lang/String;)V", "title", "b", "setTitle", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e {

    @SerializedName("sub_text")
    @NotNull
    private String subText = "\u6d4b\u8bd5\u7248";

    @SerializedName("title")
    @NotNull
    private String title = "QQ\u667a\u80fd\u4f53";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getSubText() {
        return this.subText;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public String toString() {
        return "subText=" + this.subText;
    }
}
