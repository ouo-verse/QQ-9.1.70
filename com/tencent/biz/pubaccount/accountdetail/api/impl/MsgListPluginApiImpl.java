package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.entity.MsgListPluginEntity;
import com.tencent.biz.pubaccount.accountdetail.activity.MsgListPluginSetFragment;
import com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi;
import com.tencent.biz.pubaccount.util.MsgListPluginDataManager;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/pubaccount/accountdetail/api/impl/MsgListPluginApiImpl;", "Lcom/tencent/biz/pubaccount/accountdetail/api/IMsgListPluginApi;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "params", "", "startMsgListPluginSettingPage", "", "from", "", "uin", "Lcom/tencent/biz/entity/MsgListPluginEntity;", "getEntityByUin", "data", "updateData", "Lux/a;", "listener", "addPluginListListener", "removePluginListListener", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class MsgListPluginApiImpl implements IMsgListPluginApi {
    @Override // com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi
    public void addPluginListListener(String from, ux.a listener) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MsgListPluginDataManager.f80156a.g(from, listener);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi
    public MsgListPluginEntity getEntityByUin(String from, long uin) {
        Intrinsics.checkNotNullParameter(from, "from");
        return MsgListPluginDataManager.f80156a.i(from, uin);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi
    public void removePluginListListener(String from, ux.a listener) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MsgListPluginDataManager.f80156a.p(from, listener);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi
    public void startMsgListPluginSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (params == null) {
            params = new Intent();
        }
        QPublicFragmentActivity.start(context, params, MsgListPluginSetFragment.class);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi
    public void updateData(String from, MsgListPluginEntity data) {
        Intrinsics.checkNotNullParameter(from, "from");
        MsgListPluginDataManager.f80156a.t(from, data);
    }
}
