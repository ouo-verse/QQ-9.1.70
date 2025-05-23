package com.tencent.qcircle.weseevideo.model.resource;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qcircle.weseevideo.model.utils.FileUtils;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0013J\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020\u0000J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0007H\u00c6\u0003J\t\u0010G\u001a\u00020\u0007H\u00c6\u0003J\t\u0010H\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\t\u0010J\u001a\u00020\u0005H\u00c2\u0003J\t\u0010K\u001a\u00020\u0007H\u00c6\u0003J\t\u0010L\u001a\u00020\u0005H\u00c6\u0003J\t\u0010M\u001a\u00020\u0005H\u00c6\u0003J\t\u0010N\u001a\u00020\u0005H\u00c6\u0003J\t\u0010O\u001a\u00020\u0005H\u00c6\u0003J\t\u0010P\u001a\u00020\u0005H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0005H\u00c6\u0003J\u008f\u0001\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00c6\u0001J\u0010\u0010S\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0013\u0010T\u001a\u00020C2\b\u0010U\u001a\u0004\u0018\u00010VH\u00d6\u0003J\u0006\u0010W\u001a\u00020\u0005J\t\u0010X\u001a\u00020\u0007H\u00d6\u0001J\u000e\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u0005J\t\u0010\\\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R&\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b+\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u0011\u0010.\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\u0011\u00102\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b3\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R\u0011\u00106\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b7\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R\u0011\u0010:\u001a\u00020;8F\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010!\"\u0004\b?\u0010#R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010!\"\u0004\bA\u0010#\u00a8\u0006]"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;", "Ljava/io/Serializable;", "path", "", "scaleDuration", "", "type", "", "sourceTimeStartUs", "sourceTimeDurationUs", "selectTimeStartUs", "selectTimeDurationUs", "cutTimeStart", "cutTimeDuration", "width", "height", CanvasView.ACTION_ROTATE, QQBrowserActivity.APP_PARAM, "Lcom/tencent/qcircle/weseevideo/model/resource/ResourceExtra;", "(Ljava/lang/String;JIJJJJJJIIILcom/tencent/qcircle/weseevideo/model/resource/ResourceExtra;)V", "getCutTimeDuration", "()J", "setCutTimeDuration", "(J)V", "getCutTimeStart", "setCutTimeStart", "extraParams$annotations", "()V", "getExtraParams", "()Lcom/tencent/qcircle/weseevideo/model/resource/ResourceExtra;", "setExtraParams", "(Lcom/tencent/qcircle/weseevideo/model/resource/ResourceExtra;)V", "getHeight", "()I", "setHeight", "(I)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getRotate", "setRotate", "selectTimeDuration", "getSelectTimeDuration", "getSelectTimeDurationUs", "setSelectTimeDurationUs", "selectTimeStart", "getSelectTimeStart", "getSelectTimeStartUs", "setSelectTimeStartUs", "sourceTimeDuration", "getSourceTimeDuration", "getSourceTimeDurationUs", "setSourceTimeDurationUs", "sourceTimeStart", "getSourceTimeStart", "getSourceTimeStartUs", "setSourceTimeStartUs", "speed", "", "getSpeed", "()F", "getType", "setType", "getWidth", "setWidth", "checkEffective", "", "clone", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copyBy", "equals", "other", "", "getScaleDuration", "hashCode", "setScaleDuration", "", "duration", "toString", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class VideoResourceModel implements Serializable {
    private long cutTimeDuration;
    private long cutTimeStart;

    @Nullable
    private transient ResourceExtra extraParams;
    private int height;

    @Nullable
    private String path;
    private int rotate;
    private long scaleDuration;
    private long selectTimeDurationUs;
    private long selectTimeStartUs;
    private long sourceTimeDurationUs;
    private long sourceTimeStartUs;
    private int type;
    private int width;

    public VideoResourceModel() {
        this(null, 0L, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, InitSkin.DRAWABLE_COUNT, null);
    }

    /* renamed from: component2, reason: from getter */
    private final long getScaleDuration() {
        return this.scaleDuration;
    }

    public static /* synthetic */ VideoResourceModel copy$default(VideoResourceModel videoResourceModel, String str, long j3, int i3, long j16, long j17, long j18, long j19, long j26, long j27, int i16, int i17, int i18, ResourceExtra resourceExtra, int i19, Object obj) {
        return videoResourceModel.copy((i19 & 1) != 0 ? videoResourceModel.path : str, (i19 & 2) != 0 ? videoResourceModel.scaleDuration : j3, (i19 & 4) != 0 ? videoResourceModel.type : i3, (i19 & 8) != 0 ? videoResourceModel.sourceTimeStartUs : j16, (i19 & 16) != 0 ? videoResourceModel.sourceTimeDurationUs : j17, (i19 & 32) != 0 ? videoResourceModel.selectTimeStartUs : j18, (i19 & 64) != 0 ? videoResourceModel.selectTimeDurationUs : j19, (i19 & 128) != 0 ? videoResourceModel.cutTimeStart : j26, (i19 & 256) != 0 ? videoResourceModel.cutTimeDuration : j27, (i19 & 512) != 0 ? videoResourceModel.width : i16, (i19 & 1024) != 0 ? videoResourceModel.height : i17, (i19 & 2048) != 0 ? videoResourceModel.rotate : i18, (i19 & 4096) != 0 ? videoResourceModel.extraParams : resourceExtra);
    }

    public final boolean checkEffective() {
        if (!TextUtils.isEmpty(this.path) && FileUtils.exists(this.path)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final VideoResourceModel clone() {
        return copy$default(this, null, 0L, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, InitSkin.DRAWABLE_COUNT, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component10, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component11, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component12, reason: from getter */
    public final int getRotate() {
        return this.rotate;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final ResourceExtra getExtraParams() {
        return this.extraParams;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSourceTimeStartUs() {
        return this.sourceTimeStartUs;
    }

    /* renamed from: component5, reason: from getter */
    public final long getSourceTimeDurationUs() {
        return this.sourceTimeDurationUs;
    }

    /* renamed from: component6, reason: from getter */
    public final long getSelectTimeStartUs() {
        return this.selectTimeStartUs;
    }

    /* renamed from: component7, reason: from getter */
    public final long getSelectTimeDurationUs() {
        return this.selectTimeDurationUs;
    }

    /* renamed from: component8, reason: from getter */
    public final long getCutTimeStart() {
        return this.cutTimeStart;
    }

    /* renamed from: component9, reason: from getter */
    public final long getCutTimeDuration() {
        return this.cutTimeDuration;
    }

    @NotNull
    public final VideoResourceModel copy(@Nullable String path, long scaleDuration, int type, long sourceTimeStartUs, long sourceTimeDurationUs, long selectTimeStartUs, long selectTimeDurationUs, long cutTimeStart, long cutTimeDuration, int width, int height, int rotate, @Nullable ResourceExtra extraParams) {
        return new VideoResourceModel(path, scaleDuration, type, sourceTimeStartUs, sourceTimeDurationUs, selectTimeStartUs, selectTimeDurationUs, cutTimeStart, cutTimeDuration, width, height, rotate, extraParams);
    }

    @NotNull
    public final VideoResourceModel copyBy(@Nullable String path) {
        return copy$default(this, path, 0L, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, 8190, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof VideoResourceModel) {
                VideoResourceModel videoResourceModel = (VideoResourceModel) other;
                if (!Intrinsics.areEqual(this.path, videoResourceModel.path) || this.scaleDuration != videoResourceModel.scaleDuration || this.type != videoResourceModel.type || this.sourceTimeStartUs != videoResourceModel.sourceTimeStartUs || this.sourceTimeDurationUs != videoResourceModel.sourceTimeDurationUs || this.selectTimeStartUs != videoResourceModel.selectTimeStartUs || this.selectTimeDurationUs != videoResourceModel.selectTimeDurationUs || this.cutTimeStart != videoResourceModel.cutTimeStart || this.cutTimeDuration != videoResourceModel.cutTimeDuration || this.width != videoResourceModel.width || this.height != videoResourceModel.height || this.rotate != videoResourceModel.rotate || !Intrinsics.areEqual(this.extraParams, videoResourceModel.extraParams)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getCutTimeDuration() {
        return this.cutTimeDuration;
    }

    public final long getCutTimeStart() {
        return this.cutTimeStart;
    }

    @Nullable
    public final ResourceExtra getExtraParams() {
        return this.extraParams;
    }

    public final int getHeight() {
        return this.height;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    public final int getRotate() {
        return this.rotate;
    }

    public final long getScaleDuration() {
        long j3 = this.scaleDuration;
        if (j3 == 0) {
            return getSelectTimeDuration();
        }
        return j3;
    }

    public final long getSelectTimeDuration() {
        return this.selectTimeDurationUs / 1000;
    }

    public final long getSelectTimeDurationUs() {
        return this.selectTimeDurationUs;
    }

    public final long getSelectTimeStart() {
        return this.selectTimeStartUs / 1000;
    }

    public final long getSelectTimeStartUs() {
        return this.selectTimeStartUs;
    }

    public final long getSourceTimeDuration() {
        return this.sourceTimeDurationUs / 1000;
    }

    public final long getSourceTimeDurationUs() {
        return this.sourceTimeDurationUs;
    }

    public final long getSourceTimeStart() {
        return this.sourceTimeStartUs / 1000;
    }

    public final long getSourceTimeStartUs() {
        return this.sourceTimeStartUs;
    }

    public final float getSpeed() {
        if (getScaleDuration() == 0) {
            return 1.0f;
        }
        return ((float) getSelectTimeDuration()) / ((float) getScaleDuration());
    }

    public final int getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i3;
        String str = this.path;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        long j3 = this.scaleDuration;
        int i17 = ((((i3 * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.type) * 31;
        long j16 = this.sourceTimeStartUs;
        int i18 = (i17 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.sourceTimeDurationUs;
        int i19 = (i18 + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        long j18 = this.selectTimeStartUs;
        int i26 = (i19 + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        long j19 = this.selectTimeDurationUs;
        int i27 = (i26 + ((int) (j19 ^ (j19 >>> 32)))) * 31;
        long j26 = this.cutTimeStart;
        int i28 = (i27 + ((int) (j26 ^ (j26 >>> 32)))) * 31;
        long j27 = this.cutTimeDuration;
        int i29 = (((((((i28 + ((int) (j27 ^ (j27 >>> 32)))) * 31) + this.width) * 31) + this.height) * 31) + this.rotate) * 31;
        ResourceExtra resourceExtra = this.extraParams;
        if (resourceExtra != null) {
            i16 = resourceExtra.hashCode();
        }
        return i29 + i16;
    }

    public final void setCutTimeDuration(long j3) {
        this.cutTimeDuration = j3;
    }

    public final void setCutTimeStart(long j3) {
        this.cutTimeStart = j3;
    }

    public final void setExtraParams(@Nullable ResourceExtra resourceExtra) {
        this.extraParams = resourceExtra;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setPath(@Nullable String str) {
        this.path = str;
    }

    public final void setRotate(int i3) {
        this.rotate = i3;
    }

    public final void setScaleDuration(long duration) {
        this.scaleDuration = duration;
    }

    public final void setSelectTimeDurationUs(long j3) {
        this.selectTimeDurationUs = j3;
    }

    public final void setSelectTimeStartUs(long j3) {
        this.selectTimeStartUs = j3;
    }

    public final void setSourceTimeDurationUs(long j3) {
        this.sourceTimeDurationUs = j3;
    }

    public final void setSourceTimeStartUs(long j3) {
        this.sourceTimeStartUs = j3;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    @NotNull
    public String toString() {
        return "VideoResourceModel(path=" + this.path + ", scaleDuration=" + this.scaleDuration + ", type=" + this.type + ", sourceTimeStartUs=" + this.sourceTimeStartUs + ", sourceTimeDurationUs=" + this.sourceTimeDurationUs + ", selectTimeStartUs=" + this.selectTimeStartUs + ", selectTimeDurationUs=" + this.selectTimeDurationUs + ", cutTimeStart=" + this.cutTimeStart + ", cutTimeDuration=" + this.cutTimeDuration + ", width=" + this.width + ", height=" + this.height + ", rotate=" + this.rotate + ", extraParams=" + this.extraParams + ")";
    }

    public VideoResourceModel(@Nullable String str, long j3, int i3, long j16, long j17, long j18, long j19, long j26, long j27, int i16, int i17, int i18, @Nullable ResourceExtra resourceExtra) {
        this.path = str;
        this.scaleDuration = j3;
        this.type = i3;
        this.sourceTimeStartUs = j16;
        this.sourceTimeDurationUs = j17;
        this.selectTimeStartUs = j18;
        this.selectTimeDurationUs = j19;
        this.cutTimeStart = j26;
        this.cutTimeDuration = j27;
        this.width = i16;
        this.height = i17;
        this.rotate = i18;
        this.extraParams = resourceExtra;
    }

    public /* synthetic */ VideoResourceModel(String str, long j3, int i3, long j16, long j17, long j18, long j19, long j26, long j27, int i16, int i17, int i18, ResourceExtra resourceExtra, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? "" : str, (i19 & 2) != 0 ? 0L : j3, (i19 & 4) != 0 ? 1 : i3, (i19 & 8) != 0 ? 0L : j16, (i19 & 16) != 0 ? 0L : j17, (i19 & 32) != 0 ? 0L : j18, (i19 & 64) != 0 ? 0L : j19, (i19 & 128) != 0 ? 0L : j26, (i19 & 256) != 0 ? 0L : j27, (i19 & 512) != 0 ? 0 : i16, (i19 & 1024) != 0 ? 0 : i17, (i19 & 2048) != 0 ? 0 : i18, (i19 & 4096) != 0 ? null : resourceExtra);
    }

    @Deprecated(message = "")
    public static /* synthetic */ void extraParams$annotations() {
    }
}
