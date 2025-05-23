package com.tencent.mobileqq.selectfriend.part.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.api.IMyNodeApi;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.selectmember.ResultRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB#\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/MyPCAdapter;", "Lcom/tencent/mobileqq/selectfriend/part/adapter/MyBaseAdapter;", "Landroid/view/View;", "v", "", "forwardRecentItemViewOnClick", "", "supportMsgToNodeUinType", "getNodeType", "", "isSupportShow", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "getResultRecord", "()Lcom/tencent/mobileqq/selectmember/ResultRecord;", "resultRecord", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "Landroid/os/Bundle;", "fsForwardData", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;)V", "Companion", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MyPCAdapter extends MyBaseAdapter {
    private static final String TAG = "ForwardFriend.MyPCAdapter";

    public MyPCAdapter(Context context, FSForwardData<Bundle> fSForwardData) {
        super(context, fSForwardData);
    }

    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public void forwardRecentItemViewOnClick(View v3) {
        if (FastClickUtils.isFastDoubleClick(TAG)) {
            return;
        }
        IMyNodeApi iMyNodeApi = (IMyNodeApi) QRoute.api(IMyNodeApi.class);
        Intrinsics.checkNotNull(v3);
        String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
        Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
        Integer FORWARD_ABILITY_TYPE_DATALINE = com.tencent.mobileqq.forward.e.S3;
        Intrinsics.checkNotNullExpressionValue(FORWARD_ABILITY_TYPE_DATALINE, "FORWARD_ABILITY_TYPE_DATALINE");
        iMyNodeApi.forwardRecentItemViewOnClick(v3, DATALINE_PC_UIN, 6000, FORWARD_ABILITY_TYPE_DATALINE.intValue());
    }

    @Override // com.tencent.mobileqq.selectfriend.part.adapter.MyBaseAdapter
    protected Drawable getDrawable() {
        Resources resources;
        Context mContext = getMContext();
        if (mContext == null || (resources = mContext.getResources()) == null) {
            return null;
        }
        return resources.getDrawable(R.drawable.qfile_dataline_pc_recent);
    }

    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public int getNodeType() {
        return 10000;
    }

    @Override // com.tencent.mobileqq.selectfriend.part.adapter.MyBaseAdapter
    protected ResultRecord getResultRecord() {
        return new ResultRecord(AppConstants.DATALINE_PC_UIN, HardCodeUtil.qqStr(R.string.cf5), 6000, "", "");
    }

    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public boolean isSupportShow() {
        return true;
    }

    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public int supportMsgToNodeUinType() {
        return com.tencent.mobileqq.selectfriend.constant.a.INSTANCE.a();
    }
}
