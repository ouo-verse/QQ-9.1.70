package com.tencent.state.common.record;

import com.tencent.state.service.ResultCallback;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/common/record/IRecordDataProvider;", "", "getInteractionRecord", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "", "Lcom/tencent/state/common/record/RecordData;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IRecordDataProvider {
    void getInteractionRecord(ResultCallback<List<RecordData>> callback);
}
