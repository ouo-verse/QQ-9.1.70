package com.tencent.mobileqq.reminder.api;

import androidx.fragment.app.Fragment;
import cm2.a;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.reminder.db.b;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$MsgBody;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\nH&JD\u0010\u001b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0015*\u00020\n2\u0006\u0010\u0016\u001a\u00020\b2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00028\u00000\u0017H&\u00a2\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\u001f\u001a\u00020\r\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0005\u001a\u00020\n2 \u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001eH&J8\u0010 \u001a\u00020\r\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0005\u001a\u00020\n2 \u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001eH&J8\u0010!\u001a\u00020\r\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0005\u001a\u00020\n2 \u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001eH&\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/reminder/api/IQQReminderRecordFacadeApi;", "Lmqq/app/api/IRuntimeService;", "Lcm2/a;", "", "", "msg", "msgId", "friendUin", "", "isTroop", "Lcom/tencent/mobileqq/reminder/db/b;", "constructMessageForText", "size", "", "needSoundVibrationsTip", "isOnline", "", "handleReceivedMessage", "messageRecord", "", "getMsgUinSeq", "T", QQBrowserActivity.KEY_MSG_TYPE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delegate", "createQQReminderRecordByType", "(ILkotlin/jvm/functions/Function1;)Lcom/tencent/mobileqq/reminder/db/b;", "MessageRecord", "Lcom/tencent/mobileqq/reminder/api/OptDelegate;", "checkIsForReminder", "checkIsForActivateFriends", "checkIsMessageForText", "qqreminder-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface IQQReminderRecordFacadeApi extends IRuntimeService, a {
    @Override // cm2.a
    /* synthetic */ void addMessage(@NotNull List<? extends b> list, @Nullable String str, @Nullable Boolean bool);

    <MessageRecord> boolean checkIsForActivateFriends(@NotNull b msg2, @Nullable Function1<? super MessageRecord, Boolean> delegate);

    <MessageRecord> boolean checkIsForReminder(@NotNull b msg2, @Nullable Function1<? super MessageRecord, Boolean> delegate);

    <MessageRecord> boolean checkIsMessageForText(@NotNull b msg2, @Nullable Function1<? super MessageRecord, Boolean> delegate);

    @NotNull
    b constructMessageForText(@Nullable String msg2, @NotNull String msgId, @NotNull String friendUin, int isTroop);

    @NotNull
    <T extends b> T createQQReminderRecordByType(int msgType, @NotNull Function1<? super Integer, ? extends T> delegate);

    @Override // cm2.a
    @Nullable
    /* synthetic */ com.tencent.mobileqq.reminder.db.entity.b getLastMessage(@Nullable String str, @Nullable Integer num);

    @NotNull
    /* synthetic */ String getMessageDescrpition(@NotNull SubMsgType0x76$MsgBody subMsgType0x76$MsgBody);

    @Override // cm2.a
    @NotNull
    /* synthetic */ List<b> getMsgList(@Nullable String str, @Nullable Integer num);

    long getMsgUinSeq(@NotNull b messageRecord);

    /* synthetic */ int getUnreadCount(@Nullable String str, @Nullable Integer num, @NotNull Function0<Integer> function0);

    void handleReceivedMessage(int size, boolean needSoundVibrationsTip, boolean isOnline);

    /* synthetic */ boolean isNewEngine(@NotNull Fragment fragment);

    @Deprecated(message = "\u53ea\u4e3a\u9002\u914d\u8001\u4ee3\u7801, \u7981\u6b62\u4f7f\u7528", replaceWith = @ReplaceWith(expression = "removeMsgByUniseq(activateFriendsUin: String, uinTypeActivateFriends: Int, uniseq: Long)", imports = {}))
    /* synthetic */ void removeMsgByMessageRecord(@NotNull b bVar, boolean z16);

    @Override // cm2.a
    /* synthetic */ void removeMsgByUniseq(@Nullable String str, @Nullable Integer num, long j3);

    @Override // cm2.a
    /* synthetic */ void setReaded(@Nullable String str, @Nullable Integer num);
}
