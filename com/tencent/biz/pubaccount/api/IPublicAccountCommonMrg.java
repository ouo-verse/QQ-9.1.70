package com.tencent.biz.pubaccount.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J*\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0013H&J\u001a\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001fH&J\b\u0010!\u001a\u00020\u0006H&\u00a8\u0006#"}, d2 = {"Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "peerUid", "Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg$a;", "callback", "", "asyncGetUnReadCnt4PA", "Lcom/tencent/qqnt/kernel/nativeinterface/IClearMsgRecordsCallback;", "cb", "clearMsgRecords4PA", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "deleteRecentContact4PA", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "recentContactInfo", "markRead4PA", "isShowSmallRedPoint", "", "peerUin", "", "isTop", "result", "setTop", "getTopState", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "getDefaultPAUnsubscribeMenuUseCase", "showRedDot", "initSubscribeFolderRedDotStyle", "info", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "asyncGetLastMsgRecord", "doInit", "a", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountCommonMrg extends QRouteApi {
    void asyncGetLastMsgRecord(@NotNull RecentContactInfo info, @Nullable IMsgOperateCallback result);

    void asyncGetUnReadCnt4PA(@NotNull String peerUid, @NotNull a callback);

    void clearMsgRecords4PA(@NotNull String peerUid, @Nullable IClearMsgRecordsCallback cb5);

    void deleteRecentContact4PA(@NotNull RecentContactInfo recentContactInfo, @Nullable IOperateCallback cb5);

    void deleteRecentContact4PA(@NotNull String peerUid, @Nullable IOperateCallback cb5);

    void doInit();

    @NotNull
    com.tencent.qqnt.chats.main.vm.usecase.meun.a getDefaultPAUnsubscribeMenuUseCase(@NotNull IRecentContactRepo recentContactRepo);

    void getTopState(@NotNull String peerUid, @NotNull a callback);

    void initSubscribeFolderRedDotStyle(boolean showRedDot);

    void isShowSmallRedPoint(@NotNull String peerUid, @NotNull a callback);

    void markRead4PA(@NotNull String peerUid, @Nullable IOperateCallback callback);

    void setTop(long peerUin, @NotNull String peerUid, boolean isTop, @Nullable IOperateCallback result);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg$a;", "", "", QzoneIPCModule.RESULT_CODE, "", "isTop", "", "b", ViewStickEventHelper.IS_SHOW, "a", "", "unreadCnt", "c", "<init>", "()V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static class a {
        public void a(int resultCode, boolean isShow) {
        }

        public void b(int resultCode, boolean isTop) {
        }

        public void c(int resultCode, long unreadCnt) {
        }
    }
}
