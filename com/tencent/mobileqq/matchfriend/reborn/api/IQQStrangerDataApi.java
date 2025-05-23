package com.tencent.mobileqq.matchfriend.reborn.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H&J \u0010\b\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H&J \u0010\t\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H&J \u0010\n\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/api/IQQStrangerDataApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "handleNT0x166MsgPush", "", "buff", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "handleNT0x167MsgPush", "handleNT0x16fMsgPush", "handleNTOx16eMsgPush", "hasSaveMiniUserInfo", "", "updateLiteActionLatestUnread", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IQQStrangerDataApi extends QRouteApi {
    void handleNT0x166MsgPush(@NotNull ArrayList<Byte> buff);

    void handleNT0x167MsgPush(@NotNull ArrayList<Byte> buff);

    void handleNT0x16fMsgPush(@NotNull ArrayList<Byte> buff);

    void handleNTOx16eMsgPush(@NotNull ArrayList<Byte> buff);

    boolean hasSaveMiniUserInfo();

    void updateLiteActionLatestUnread();
}
