package com.tencent.mobileqq.opr.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u00c6\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0007J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/opr/model/ModelConfig;", "", "modelId", "", "unShuffleFactor", "", "upscaleFactor", "tileLength", "enableLocalNPU", "", "enableLocalCPUAndGPU", "(Ljava/lang/String;IIIZZ)V", "getEnableLocalCPUAndGPU", "()Z", "getEnableLocalNPU", "getModelId", "()Ljava/lang/String;", "getTileLength", "()I", "getUnShuffleFactor", "getUpscaleFactor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "desc", "equals", "other", "hashCode", "toString", "opr_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class ModelConfig {
    static IPatchRedirector $redirector_;

    @SerializedName("enableLocalCPUAndGPU")
    private final boolean enableLocalCPUAndGPU;

    @SerializedName("enableLocalNPU")
    private final boolean enableLocalNPU;

    @SerializedName("modelId")
    @NotNull
    private final String modelId;

    @SerializedName("tileLength")
    private final int tileLength;

    @SerializedName("unShuffleFactor")
    private final int unShuffleFactor;

    @SerializedName("upscaleFactor")
    private final int upscaleFactor;

    public ModelConfig(@NotNull String modelId, int i3, int i16, int i17, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, modelId, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.modelId = modelId;
        this.unShuffleFactor = i3;
        this.upscaleFactor = i16;
        this.tileLength = i17;
        this.enableLocalNPU = z16;
        this.enableLocalCPUAndGPU = z17;
    }

    public static /* synthetic */ ModelConfig copy$default(ModelConfig modelConfig, String str, int i3, int i16, int i17, boolean z16, boolean z17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            str = modelConfig.modelId;
        }
        if ((i18 & 2) != 0) {
            i3 = modelConfig.unShuffleFactor;
        }
        int i19 = i3;
        if ((i18 & 4) != 0) {
            i16 = modelConfig.upscaleFactor;
        }
        int i26 = i16;
        if ((i18 & 8) != 0) {
            i17 = modelConfig.tileLength;
        }
        int i27 = i17;
        if ((i18 & 16) != 0) {
            z16 = modelConfig.enableLocalNPU;
        }
        boolean z18 = z16;
        if ((i18 & 32) != 0) {
            z17 = modelConfig.enableLocalCPUAndGPU;
        }
        return modelConfig.copy(str, i19, i26, i27, z18, z17);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.modelId;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.unShuffleFactor;
    }

    public final int component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.upscaleFactor;
    }

    public final int component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.tileLength;
    }

    public final boolean component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.enableLocalNPU;
    }

    public final boolean component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.enableLocalCPUAndGPU;
    }

    @NotNull
    public final ModelConfig copy(@NotNull String modelId, int unShuffleFactor, int upscaleFactor, int tileLength, boolean enableLocalNPU, boolean enableLocalCPUAndGPU) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ModelConfig) iPatchRedirector.redirect((short) 16, this, modelId, Integer.valueOf(unShuffleFactor), Integer.valueOf(upscaleFactor), Integer.valueOf(tileLength), Boolean.valueOf(enableLocalNPU), Boolean.valueOf(enableLocalCPUAndGPU));
        }
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return new ModelConfig(modelId, unShuffleFactor, upscaleFactor, tileLength, enableLocalNPU, enableLocalCPUAndGPU);
    }

    @NativeMethodProxy(enabled = false)
    @NotNull
    public final String desc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "shuffle:" + this.unShuffleFactor + ", upscale:" + this.upscaleFactor + ", tile:" + this.tileLength;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelConfig)) {
            return false;
        }
        ModelConfig modelConfig = (ModelConfig) other;
        if (Intrinsics.areEqual(this.modelId, modelConfig.modelId) && this.unShuffleFactor == modelConfig.unShuffleFactor && this.upscaleFactor == modelConfig.upscaleFactor && this.tileLength == modelConfig.tileLength && this.enableLocalNPU == modelConfig.enableLocalNPU && this.enableLocalCPUAndGPU == modelConfig.enableLocalCPUAndGPU) {
            return true;
        }
        return false;
    }

    public final boolean getEnableLocalCPUAndGPU() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.enableLocalCPUAndGPU;
    }

    public final boolean getEnableLocalNPU() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.enableLocalNPU;
    }

    @NotNull
    public final String getModelId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.modelId;
    }

    public final int getTileLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.tileLength;
    }

    public final int getUnShuffleFactor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.unShuffleFactor;
    }

    public final int getUpscaleFactor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.upscaleFactor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        int hashCode = ((((((this.modelId.hashCode() * 31) + this.unShuffleFactor) * 31) + this.upscaleFactor) * 31) + this.tileLength) * 31;
        boolean z16 = this.enableLocalNPU;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.enableLocalCPUAndGPU;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "ModelConfig(modelId=" + this.modelId + ", unShuffleFactor=" + this.unShuffleFactor + ", upscaleFactor=" + this.upscaleFactor + ", tileLength=" + this.tileLength + ", enableLocalNPU=" + this.enableLocalNPU + ", enableLocalCPUAndGPU=" + this.enableLocalCPUAndGPU + ')';
    }

    public /* synthetic */ ModelConfig(String str, int i3, int i16, int i17, boolean z16, boolean z17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i16, i17, (i18 & 16) != 0 ? true : z16, (i18 & 32) != 0 ? false : z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i18), defaultConstructorMarker);
    }
}
