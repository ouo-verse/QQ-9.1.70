package com.tencent.mobileqq.qqgamepub.nt.api;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0002\u000b\fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/api/IGameMallNtApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "limitSize", "initMsgSize", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IGameMallNtApi$b;", "listener", "", "getMsgList", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IGameMallNtApi$a;", "getBusinessMsgList", "a", "b", "qqgamepubaccount-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IGameMallNtApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/api/IGameMallNtApi$a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqgamepub/data/QQGameMsgInfo;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "qqgamepubaccount-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void onSuccess(@NotNull ArrayList<QQGameMsgInfo> msgList);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/api/IGameMallNtApi$b;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "qqgamepubaccount-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface b {
        void onSuccess(@NotNull ArrayList<MsgRecord> msgList);
    }

    void getBusinessMsgList(int limitSize, int initMsgSize, @NotNull a listener);

    void getMsgList(int limitSize, int initMsgSize, @NotNull b listener);
}
