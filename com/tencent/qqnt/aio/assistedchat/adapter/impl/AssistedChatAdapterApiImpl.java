package com.tencent.qqnt.aio.assistedchat.adapter.impl;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vu3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/adapter/impl/AssistedChatAdapterApiImpl;", "Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatAdapterApi;", "", "chatType", "", "isExperiment", "isReplySuggestionExperiment", "", "reportExpExposure", "Landroid/view/View;", "view", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "setDtReportPageInfo", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AssistedChatAdapterApiImpl implements IAssistedChatAdapterApi {
    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi
    public boolean isExperiment(int chatType) {
        return b.f443544a.b(chatType);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi
    public boolean isReplySuggestionExperiment(int chatType) {
        return b.f443544a.d(chatType);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi
    public void reportExpExposure(int chatType) {
        b.f443544a.e(chatType);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi
    public void setDtReportPageInfo(View view, a aioContext) {
        String str;
        Map mapOf;
        FragmentActivity activity;
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (aioContext.g().r().c().e() == 104) {
            VideoReport.setPageId(view, "pg_kl_new_chat_page");
            Fragment c16 = aioContext.c();
            if (c16 == null || (activity = c16.getActivity()) == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("recom_trace")) == null) {
                str = "";
            }
            Pair[] pairArr = new Pair[3];
            String selfOpenId = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId();
            if (selfOpenId == null) {
                selfOpenId = "";
            }
            pairArr[0] = TuplesKt.to("kl_new_from_openid", selfOpenId);
            String friendOpenId = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getFriendOpenId();
            pairArr[1] = TuplesKt.to("kl_new_to_openid", friendOpenId != null ? friendOpenId : "");
            pairArr[2] = TuplesKt.to("recom_trace", str);
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            VideoReport.setPageParams(view, new PageParams((Map<String, ?>) mapOf));
        }
    }
}
