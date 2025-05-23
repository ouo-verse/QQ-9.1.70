package com.tencent.mobileqq.selectfriend.api.impl;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.selectfriend.api.IMyNodeApi;
import com.tencent.mobileqq.selectfriend.eventbus.event.MyEventClickEvent;
import com.tencent.mobileqq.selectfriend.part.adapter.MyDefaultNodeAdapter;
import com.tencent.mobileqq.selectfriend.part.adapter.MyPCAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/api/impl/MyNodeApiImpl;", "Lcom/tencent/mobileqq/selectfriend/api/IMyNodeApi;", "Landroid/view/View;", "v", "", "uin", "", "uinType", "forwardAbility", "", "forwardRecentItemViewOnClick", "myNodeType", "Ljava/lang/Class;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getMyNodeAdapter", "<init>", "()V", "Companion", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MyNodeApiImpl implements IMyNodeApi {
    private static final String TAG = "MyNodeApiImpl";

    @Override // com.tencent.mobileqq.selectfriend.api.IMyNodeApi
    public void forwardRecentItemViewOnClick(View v3, String uin, int uinType, int forwardAbility) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(uin, "uin");
        SimpleEventBus.getInstance().dispatchEvent(new MyEventClickEvent(v3, uin, uinType, forwardAbility));
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IMyNodeApi
    public Class<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getMyNodeAdapter(int myNodeType) {
        if (myNodeType == 10000) {
            return MyPCAdapter.class;
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("myNodeType = %s getForwardContentProcessor is null", Arrays.copyOf(new Object[]{Integer.valueOf(myNodeType)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d(TAG, 2, format);
            return MyDefaultNodeAdapter.class;
        }
        return MyDefaultNodeAdapter.class;
    }
}
