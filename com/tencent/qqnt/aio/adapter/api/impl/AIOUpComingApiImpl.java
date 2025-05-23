package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqnt.aio.adapter.api.IAIOUpComingApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOUpComingApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOUpComingApi;", "()V", "onMenuItemClick", "", "context", "Landroid/content/Context;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioNick", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIOUpComingApiImpl implements IAIOUpComingApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOUpComingApi
    public void onMenuItemClick(Context context, AIOMsgItem msgItem, String aioNick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(aioNick, "aioNick");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        Manager manager = ((QQAppInterface) runtime).getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager");
        ((z61.d) manager).v(context, msgItem, aioNick);
    }
}
