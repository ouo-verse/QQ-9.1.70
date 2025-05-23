package com.tencent.filament.zplan.data;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.autotemplate.extra.PreDetect;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JP\u0010.\u001a\u00020/2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\"\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020&X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001e\u00a8\u00060"}, d2 = {"Lcom/tencent/filament/zplan/data/AvatarAIInfo;", "", "()V", "applyTimestamp", "", "getApplyTimestamp", "()J", "setApplyTimestamp", "(J)V", "body", "", "getBody", "()[B", "setBody", "([B)V", LinkReportConstant$GlobalKey.EVENTS, "", "", "getEvents", "()Ljava/util/Map;", "setEvents", "(Ljava/util/Map;)V", PreDetect.FACE_DETECT, "getFace", "setFace", "frameId", "", "getFrameId", "()I", "setFrameId", "(I)V", "originPts", "getOriginPts", "setOriginPts", "pts", "getPts", "setPts", "skyBoxTransform", "", "getSkyBoxTransform", "()[F", "setSkyBoxTransform", "([F)V", "version", "getVersion", "setVersion", "AvatarAIInfo", "", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class AvatarAIInfo {
    private long applyTimestamp = -1;

    @Nullable
    private byte[] body;

    @Nullable
    private Map<String, String> events;

    @Nullable
    private byte[] face;
    private int frameId;
    private long originPts;
    private long pts;
    public float[] skyBoxTransform;
    private int version;

    public final void AvatarAIInfo(int version, int frameId, @NotNull float[] skyBoxTransform, @Nullable byte[] face2, @Nullable byte[] body, @Nullable Map<String, String> events, long pts) {
        Intrinsics.checkNotNullParameter(skyBoxTransform, "skyBoxTransform");
        this.version = version;
        this.frameId = frameId;
        this.skyBoxTransform = skyBoxTransform;
        this.face = face2;
        this.body = body;
        this.events = events;
        this.pts = pts;
    }

    public final long getApplyTimestamp() {
        return this.applyTimestamp;
    }

    @Nullable
    public final byte[] getBody() {
        return this.body;
    }

    @Nullable
    public final Map<String, String> getEvents() {
        return this.events;
    }

    @Nullable
    public final byte[] getFace() {
        return this.face;
    }

    public final int getFrameId() {
        return this.frameId;
    }

    public final long getOriginPts() {
        return this.originPts;
    }

    public final long getPts() {
        return this.pts;
    }

    @NotNull
    public final float[] getSkyBoxTransform() {
        float[] fArr = this.skyBoxTransform;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skyBoxTransform");
        }
        return fArr;
    }

    public final int getVersion() {
        return this.version;
    }

    public final void setApplyTimestamp(long j3) {
        this.applyTimestamp = j3;
    }

    public final void setBody(@Nullable byte[] bArr) {
        this.body = bArr;
    }

    public final void setEvents(@Nullable Map<String, String> map) {
        this.events = map;
    }

    public final void setFace(@Nullable byte[] bArr) {
        this.face = bArr;
    }

    public final void setFrameId(int i3) {
        this.frameId = i3;
    }

    public final void setOriginPts(long j3) {
        this.originPts = j3;
    }

    public final void setPts(long j3) {
        this.pts = j3;
    }

    public final void setSkyBoxTransform(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.skyBoxTransform = fArr;
    }

    public final void setVersion(int i3) {
        this.version = i3;
    }
}
