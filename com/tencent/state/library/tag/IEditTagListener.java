package com.tencent.state.library.tag;

import com.tencent.state.common.tag.CommonTagInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/library/tag/IEditTagListener;", "", "onEditTagFailed", "", "errCode", "", "errMsg", "", "onEditTagSuccess", "uin", "deskMateTag", "Lcom/tencent/state/common/tag/CommonTagInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IEditTagListener {
    void onEditTagFailed(int errCode, String errMsg);

    void onEditTagSuccess(String uin, CommonTagInfo deskMateTag);
}
