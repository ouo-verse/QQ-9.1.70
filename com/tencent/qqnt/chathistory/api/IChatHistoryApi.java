package com.tencent.qqnt.chathistory.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J(\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/IChatHistoryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/chathistory/api/IHistoryForwardApi;", "", "getTroopMemberHistoryFragmentClassName", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chathistory/api/a;", SessionDbHelper.SESSION_ID, "", "jumpChatHistoryActivity", "jumpChatHistoryCategoryActivity", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "chatType", "peerId", "showSearchDialogFragment", "Landroid/os/Bundle;", "bundle", "", "checkFromChatHistory", "clearChatHistoryBundle", "chathistory_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IChatHistoryApi extends QRouteApi, IHistoryForwardApi {
    boolean checkFromChatHistory(@NotNull Bundle bundle);

    void clearChatHistoryBundle(@NotNull Bundle bundle);

    @NotNull
    String getTroopMemberHistoryFragmentClassName();

    void jumpChatHistoryActivity(@NotNull Context context, @NotNull a session);

    void jumpChatHistoryCategoryActivity(@NotNull Context context, @NotNull a session);

    @Override // com.tencent.qqnt.chathistory.api.IHistoryForwardApi
    /* synthetic */ void jumpHistoryTab(@NotNull Context context, @NotNull a aVar, int i3, @Nullable Bundle bundle);

    void showSearchDialogFragment(@NotNull Activity activity, int requestCode, int chatType, @NotNull String peerId);
}
