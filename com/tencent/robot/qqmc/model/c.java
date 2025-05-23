package com.tencent.robot.qqmc.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/qqmc/model/c;", "", "", "toString", "", "cropSize", "I", "b", "()I", "setCropSize", "(I)V", "compressQuality", "a", "setCompressQuality", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {

    @SerializedName("crop_size")
    private int cropSize = 640;

    @SerializedName("compress_quality")
    private int compressQuality = 70;

    /* renamed from: a, reason: from getter */
    public final int getCompressQuality() {
        return this.compressQuality;
    }

    /* renamed from: b, reason: from getter */
    public final int getCropSize() {
        return this.cropSize;
    }

    @NotNull
    public String toString() {
        return "cropSize=" + this.cropSize + ", compressQuality=" + this.compressQuality;
    }
}
