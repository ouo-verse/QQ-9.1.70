package com.tencent.mobileqq.selectfriend.api.impl;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.selectfriend.api.ISelectNodeApi;
import com.tencent.mobileqq.selectfriend.part.adapter.SelectDefaultEnterAdapter;
import com.tencent.mobileqq.selectfriend.part.adapter.SelectFriendEnterAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/api/impl/SelectNodeApiApiImpl;", "Lcom/tencent/mobileqq/selectfriend/api/ISelectNodeApi;", "", "selectEnterType", "Ljava/lang/Class;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getSelectEnterAdapter", "<init>", "()V", "Companion", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SelectNodeApiApiImpl implements ISelectNodeApi {
    private static final String TAG = "SelectNodeApiApiImpl";

    @Override // com.tencent.mobileqq.selectfriend.api.ISelectNodeApi
    public Class<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getSelectEnterAdapter(int selectEnterType) {
        if (selectEnterType == 1) {
            return SelectFriendEnterAdapter.class;
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("selectEnterType = %s getForwardContentProcessor is null", Arrays.copyOf(new Object[]{Integer.valueOf(selectEnterType)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d(TAG, 2, format);
            return SelectDefaultEnterAdapter.class;
        }
        return SelectDefaultEnterAdapter.class;
    }
}
