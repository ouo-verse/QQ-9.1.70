package com.tencent.ecommerce.base.ui.refreshview;

import com.heytap.databaseengine.apiv3.data.Element;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/base/ui/refreshview/OnRefreshListener;", "", "onPullDownDistance", "", Element.ELEMENT_NAME_DISTANCE, "", "onRefreshFinish", "isSucceeded", "", "tag", "", "onRefreshIdle", "onRefreshPrepare", "onRefreshing", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface OnRefreshListener {
    void onPullDownDistance(float distance);

    void onRefreshFinish(boolean isSucceeded, int tag);

    boolean onRefreshIdle();

    boolean onRefreshPrepare();

    boolean onRefreshing(int tag);
}
