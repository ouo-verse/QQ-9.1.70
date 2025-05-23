package com.tencent.state.square.resource;

import com.tencent.state.square.data.Resource;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"toRecordRequest", "Lcom/tencent/state/square/resource/RecordRequest;", "Lcom/tencent/state/square/data/Resource;", "extra", "", "appId", "", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MeResourceRecorderKt {
    public static final RecordRequest toRecordRequest(Resource resource, Object obj, int i3) {
        return new RecordRequest(resource, obj, i3);
    }

    public static /* synthetic */ RecordRequest toRecordRequest$default(Resource resource, Object obj, int i3, int i16, Object obj2) {
        if ((i16 & 1) != 0) {
            obj = null;
        }
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return toRecordRequest(resource, obj, i3);
    }
}
