package com.tencent.qcircle.weseevideo.model.effect;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00138\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00198\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\nR\u0016\u0010\u001e\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\n\u00a8\u0006!"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/effect/StickerConfigModel;", "", "()V", AIInput.KEY_FRAME, "Lcom/tencent/qcircle/weseevideo/model/effect/FrameModel;", "getFrame", "()Lcom/tencent/qcircle/weseevideo/model/effect/FrameModel;", "id", "", "getId", "()Ljava/lang/String;", "limitArea", "Lcom/tencent/qcircle/weseevideo/model/effect/StickerModel$LimitArea;", "Lcom/tencent/qcircle/weseevideo/model/effect/StickerModel;", "getLimitArea", "()Lcom/tencent/qcircle/weseevideo/model/effect/StickerModel$LimitArea;", "setLimitArea", "(Lcom/tencent/qcircle/weseevideo/model/effect/StickerModel$LimitArea;)V", "loopEnd", "", "getLoopEnd", "()J", "loopStart", "getLoopStart", "loopType", "", "getLoopType", "()I", "minVersion", "getMinVersion", "type", "getType", "Companion", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public class StickerConfigModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName(AIInput.KEY_FRAME)
    @Nullable
    private final FrameModel frame;

    @SerializedName("limitArea")
    @Nullable
    private StickerModel.LimitArea limitArea;

    @SerializedName("loopEnd")
    private final long loopEnd;

    @SerializedName("loopStart")
    private final long loopStart;

    @SerializedName("loopType")
    private final int loopType;

    @SerializedName("id")
    @NotNull
    private final String id = "";

    @SerializedName("type")
    @NotNull
    private final String type = "";

    @SerializedName("minVersion")
    @NotNull
    private final String minVersion = "";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/effect/StickerConfigModel$Companion;", "", "()V", "fromJson", "Lcom/tencent/qcircle/weseevideo/model/effect/StickerConfigModel;", "str", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final StickerConfigModel fromJson(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "str");
            try {
                return (StickerConfigModel) new Gson().fromJson(str, StickerConfigModel.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    public final FrameModel getFrame() {
        return this.frame;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final StickerModel.LimitArea getLimitArea() {
        return this.limitArea;
    }

    public final long getLoopEnd() {
        return this.loopEnd;
    }

    public final long getLoopStart() {
        return this.loopStart;
    }

    public final int getLoopType() {
        return this.loopType;
    }

    @NotNull
    public final String getMinVersion() {
        return this.minVersion;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final void setLimitArea(@Nullable StickerModel.LimitArea limitArea) {
        this.limitArea = limitArea;
    }
}
