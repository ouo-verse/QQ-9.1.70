package com.tencent.qqnt.chats.biz.hiddenchat;

import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H&J \u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&J\"\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/chats/biz/hiddenchat/IHiddenChatApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/chats/data/d;", "Lkotlin/collections/ArrayList;", "hiddenChatList", "", "delHiddenChat", "uid", "", "unReadNumSwitch", "setShowUnReadNum", "Lcom/tencent/qqnt/chats/biz/hiddenchat/d;", "ntHiddenChatAsync", "", "unReadNum", "Landroid/widget/TextView;", "unReadMsg", "getShowUnReadNum", "setHiddenChat", "getAllHiddenChat", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IHiddenChatApi extends QRouteApi {
    void delHiddenChat(@NotNull String uin, @NotNull ArrayList<com.tencent.qqnt.chats.data.d> hiddenChatList);

    void getAllHiddenChat(@NotNull d ntHiddenChatAsync);

    void getShowUnReadNum(@NotNull d ntHiddenChatAsync, int unReadNum, @Nullable TextView unReadMsg);

    void setHiddenChat(@NotNull String uin, @NotNull ArrayList<com.tencent.qqnt.chats.data.d> hiddenChatList);

    void setShowUnReadNum(@NotNull String uid, @NotNull String uin, boolean unReadNumSwitch);
}
