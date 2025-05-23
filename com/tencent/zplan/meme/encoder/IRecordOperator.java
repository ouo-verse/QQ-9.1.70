package com.tencent.zplan.meme.encoder;

import com.tencent.zplan.meme.IZPlanRecordCallback;
import com.tencent.zplan.meme.model.MemeRecordParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/zplan/meme/encoder/IRecordOperator;", "Lcom/tencent/zplan/meme/IZPlanRecordCallback;", "params", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "getParams", "()Lcom/tencent/zplan/meme/model/MemeRecordParams;", "asBinder", "", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface IRecordOperator extends IZPlanRecordCallback {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        @Nullable
        public static Void a(@NotNull IRecordOperator iRecordOperator) {
            return null;
        }
    }

    @Override // android.os.IInterface
    @Nullable
    Void asBinder();

    @NotNull
    MemeRecordParams getParams();
}
