package com.tencent.karaoke.audiobasesdk.dnn;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0007H\u00c6\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u00c6\u0003JA\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001J\b\u0010%\u001a\u00020&H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006'"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/dnn/DnnUnitJob;", "", "buffer", "", "reallen", "", "type", "Lcom/tencent/karaoke/audiobasesdk/dnn/DnnUnitType;", "callback", "Lkotlin/Function1;", "", "", "([BILcom/tencent/karaoke/audiobasesdk/dnn/DnnUnitType;Lkotlin/jvm/functions/Function1;)V", "getBuffer", "()[B", "setBuffer", "([B)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", IECSearchBar.METHOD_SET_CALLBACK, "(Lkotlin/jvm/functions/Function1;)V", "getReallen", "()I", "setReallen", "(I)V", "getType", "()Lcom/tencent/karaoke/audiobasesdk/dnn/DnnUnitType;", "setType", "(Lcom/tencent/karaoke/audiobasesdk/dnn/DnnUnitType;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final /* data */ class DnnUnitJob {

    @Nullable
    private byte[] buffer;

    @Nullable
    private Function1<? super Boolean, Unit> callback;
    private int reallen;

    @NotNull
    private DnnUnitType type;

    public DnnUnitJob(@Nullable byte[] bArr, int i3, @NotNull DnnUnitType type, @Nullable Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.buffer = bArr;
        this.reallen = i3;
        this.type = type;
        this.callback = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* synthetic */ DnnUnitJob copy$default(DnnUnitJob dnnUnitJob, byte[] bArr, int i3, DnnUnitType dnnUnitType, Function1 function1, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            bArr = dnnUnitJob.buffer;
        }
        if ((i16 & 2) != 0) {
            i3 = dnnUnitJob.reallen;
        }
        if ((i16 & 4) != 0) {
            dnnUnitType = dnnUnitJob.type;
        }
        if ((i16 & 8) != 0) {
            function1 = dnnUnitJob.callback;
        }
        return dnnUnitJob.copy(bArr, i3, dnnUnitType, function1);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final byte[] getBuffer() {
        return this.buffer;
    }

    /* renamed from: component2, reason: from getter */
    public final int getReallen() {
        return this.reallen;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final DnnUnitType getType() {
        return this.type;
    }

    @Nullable
    public final Function1<Boolean, Unit> component4() {
        return this.callback;
    }

    @NotNull
    public final DnnUnitJob copy(@Nullable byte[] buffer, int reallen, @NotNull DnnUnitType type, @Nullable Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        return new DnnUnitJob(buffer, reallen, type, callback);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        if (this != other) {
            if (other instanceof DnnUnitJob) {
                DnnUnitJob dnnUnitJob = (DnnUnitJob) other;
                if (Intrinsics.areEqual(this.buffer, dnnUnitJob.buffer)) {
                    if (this.reallen == dnnUnitJob.reallen) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 || !Intrinsics.areEqual(this.type, dnnUnitJob.type) || !Intrinsics.areEqual(this.callback, dnnUnitJob.callback)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final byte[] getBuffer() {
        return this.buffer;
    }

    @Nullable
    public final Function1<Boolean, Unit> getCallback() {
        return this.callback;
    }

    public final int getReallen() {
        return this.reallen;
    }

    @NotNull
    public final DnnUnitType getType() {
        return this.type;
    }

    public int hashCode() {
        int i3;
        int i16;
        byte[] bArr = this.buffer;
        int i17 = 0;
        if (bArr != null) {
            i3 = Arrays.hashCode(bArr);
        } else {
            i3 = 0;
        }
        int i18 = ((i3 * 31) + this.reallen) * 31;
        DnnUnitType dnnUnitType = this.type;
        if (dnnUnitType != null) {
            i16 = dnnUnitType.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        Function1<? super Boolean, Unit> function1 = this.callback;
        if (function1 != null) {
            i17 = function1.hashCode();
        }
        return i19 + i17;
    }

    public final void setBuffer(@Nullable byte[] bArr) {
        this.buffer = bArr;
    }

    public final void setCallback(@Nullable Function1<? super Boolean, Unit> function1) {
        this.callback = function1;
    }

    public final void setReallen(int i3) {
        this.reallen = i3;
    }

    public final void setType(@NotNull DnnUnitType dnnUnitType) {
        Intrinsics.checkParameterIsNotNull(dnnUnitType, "<set-?>");
        this.type = dnnUnitType;
    }

    @NotNull
    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("DnnUnitJob(bufferSize=");
        byte[] bArr = this.buffer;
        if (bArr != null) {
            i3 = bArr.length;
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(", reallen=");
        sb5.append(this.reallen);
        sb5.append(", type=");
        sb5.append(this.type);
        sb5.append(')');
        return sb5.toString();
    }

    public /* synthetic */ DnnUnitJob(byte[] bArr, int i3, DnnUnitType dnnUnitType, Function1 function1, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? DnnUnitType.Write : dnnUnitType, (i16 & 8) != 0 ? new Function1<Boolean, Unit>() { // from class: com.tencent.karaoke.audiobasesdk.dnn.DnnUnitJob.1
            public final void invoke(boolean z16) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        } : function1);
    }
}
