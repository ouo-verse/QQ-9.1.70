package com.tencent.state.status;

import com.tencent.state.square.data.BaseResourceInfo;
import com.tencent.state.square.data.OnlineStatus;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/status/ISelectedChangedListener;", "", "onSelectChanged", "", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "resourceInfo", "Lcom/tencent/state/square/data/BaseResourceInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISelectedChangedListener {
    void onSelectChanged(OnlineStatus status, BaseResourceInfo resourceInfo);
}
