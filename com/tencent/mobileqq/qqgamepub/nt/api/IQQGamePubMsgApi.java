package com.tencent.mobileqq.qqgamepub.nt.api;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0003\u001a\u001b\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH&J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000eH&J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H&J0\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H&J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0017H&J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0017H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "title", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "listener", "", SmsPlugin.API_SEND_SMS, "setMsgRead", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$c;", "getUnreadCnt", "", "limitSize", "initMsgSize", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$b;", "getMsgList", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$a;", "from", "getBusinessMsgList", "", "msgId", "getBusinessMsgListByMsgId", "deleteMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "addMsgListener", "removeMsgListener", "a", "b", "c", "qqgamepubaccount-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGamePubMsgApi extends QRouteApi {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqgamepub/data/QQGameMsgInfo;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "qqgamepubaccount-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void onSuccess(@NotNull ArrayList<QQGameMsgInfo> msgList);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$b;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "qqgamepubaccount-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface b {
        void onSuccess(@NotNull ArrayList<MsgRecord> msgList);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$c;", "", "", "unreadCnt", "", "onSuccess", "qqgamepubaccount-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface c {
        void onSuccess(int unreadCnt);
    }

    void addMsgListener(@NotNull IKernelMsgListener listener);

    void deleteMsg(long msgId);

    void getBusinessMsgList(int limitSize, int initMsgSize, @NotNull a listener, @NotNull String from);

    void getBusinessMsgListByMsgId(long msgId, int limitSize, int initMsgSize, @NotNull a listener, @NotNull String from);

    void getMsgList(int limitSize, int initMsgSize, @NotNull b listener);

    void getUnreadCnt(@NotNull c listener);

    void removeMsgListener(@NotNull IKernelMsgListener listener);

    void sendMsg(@NotNull String title, @Nullable IOperateCallback listener);

    void setMsgRead();
}
