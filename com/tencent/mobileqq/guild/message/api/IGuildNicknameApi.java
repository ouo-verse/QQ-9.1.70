package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildNicknameApi extends QRouteApi {
    int emojiCount(String str);

    String getCutoffCompatibleEmoji(String str, int i3);

    String getDisplayName(AppRuntime appRuntime, String str, String str2, MessageRecord messageRecord);

    String getDisplayNameForSummary(AppRuntime appRuntime, String str, String str2, MessageRecord messageRecord);

    String removeIncompleteEmoji(String str, int i3);
}
