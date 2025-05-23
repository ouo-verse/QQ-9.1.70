package com.tencent.robot.qqmc.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/qqmc/model/a;", "", "", "b", "c", "a", "", "fullFilling", "Ljava/lang/String;", "getFullFilling", "()Ljava/lang/String;", "setFullFilling", "(Ljava/lang/String;)V", "polishContent", "getPolishContent", "setPolishContent", "pictureGenerate", "getPictureGenerate", "setPictureGenerate", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    @SerializedName("enable_full_filling")
    @NotNull
    private String fullFilling = "true";

    @SerializedName("enable_polish_content")
    @NotNull
    private String polishContent = "true";

    @SerializedName("enable_picture_genarate")
    @NotNull
    private String pictureGenerate = "true";

    public final boolean a() {
        return Intrinsics.areEqual(this.pictureGenerate, "true");
    }

    public final boolean b() {
        return Intrinsics.areEqual(this.fullFilling, "true");
    }

    public final boolean c() {
        return Intrinsics.areEqual(this.polishContent, "true");
    }
}
