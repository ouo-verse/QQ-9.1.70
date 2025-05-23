package com.tencent.state.square.api;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.zplan.meme.model.MemeResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J*\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/api/RecordSuccessListener;", "", "onCloudRecordSuccess", "", "actionId", "", "recordIdentifier", "Lcom/tencent/state/square/record/RecordIdentifier;", "cover", "Lcom/tencent/state/square/data/RecordSource;", "mp4", "onLocalRecordSuccess", "onRecordDone", "success", "", "result", "Lcom/tencent/zplan/meme/model/MemeResult;", IECDtReport.ACTION_IDENTIFIER, "onRecordError", "type", "errorCode", "onUploadSuccess", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface RecordSuccessListener {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static void onRecordDone(@NotNull RecordSuccessListener recordSuccessListener, boolean z16, @NotNull MemeResult result, @NotNull RecordIdentifier identifier) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(identifier, "identifier");
        }
    }

    void onCloudRecordSuccess(int actionId, @NotNull RecordIdentifier recordIdentifier, @NotNull RecordSource cover, @Nullable RecordSource mp42);

    void onLocalRecordSuccess(int actionId, @NotNull RecordIdentifier recordIdentifier, @NotNull RecordSource cover, @Nullable RecordSource mp42);

    void onRecordDone(boolean success, @NotNull MemeResult result, @NotNull RecordIdentifier identifier);

    void onRecordError(int actionId, int type, int errorCode, @NotNull RecordIdentifier recordIdentifier);

    void onUploadSuccess(int actionId, @NotNull RecordIdentifier recordIdentifier, @NotNull RecordSource cover, @Nullable RecordSource mp42);
}
