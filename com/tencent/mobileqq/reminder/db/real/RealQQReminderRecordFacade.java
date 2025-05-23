package com.tencent.mobileqq.reminder.db.real;

import androidx.fragment.app.Fragment;
import cm2.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi;
import com.tencent.mobileqq.reminder.db.b;
import com.tencent.mobileqq.reminder.db.entity.ReminderRecord;
import com.tencent.mobileqq.reminder.db.entity.c;
import com.tencent.mobileqq.reminder.db.real.engine.CacheDataEngine;
import com.tencent.mobileqq.reminder.db.real.engine.DbDataEngine;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$MsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ6\u0010\f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0001\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J2\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0096\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096\u0001J\u0019\u0010!\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\tH\u0097\u0001J0\u0010$\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\"H\u0096\u0001\u00a2\u0006\u0004\b$\u0010%J$\u0010&\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0001\u00a2\u0006\u0004\b&\u0010'J\u0011\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0096\u0001J*\u0010/\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH\u0016J \u00103\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\tH\u0016J\u0010\u00104\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016JD\u0010:\u001a\u00028\u0000\"\b\b\u0000\u00105*\u00020\u00052\u0006\u00106\u001a\u00020\u000f2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(6\u0012\u0004\u0012\u00028\u000007H\u0016\u00a2\u0006\u0004\b:\u0010;J;\u0010>\u001a\u00020\t\"\u0004\b\u0000\u0010<2\u0006\u0010+\u001a\u00020\u00052#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\t\u0018\u000107H\u0016J;\u0010?\u001a\u00020\t\"\u0004\b\u0000\u0010<2\u0006\u0010+\u001a\u00020\u00052#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\t\u0018\u000107H\u0016J;\u0010@\u001a\u00020\t\"\u0004\b\u0000\u0010<2\u0006\u0010+\u001a\u00020\u00052#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\t\u0018\u000107H\u0016J\u0010\u0010C\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020\u000bH\u0016\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/real/RealQQReminderRecordFacade;", "Lcom/tencent/mobileqq/reminder/api/IQQReminderRecordFacadeApi;", "Lcm2/a;", "", "", "Lcom/tencent/mobileqq/reminder/db/b;", "list", "", "account", "", "isBackgroundStop", "", "addMessage", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "activateFriendsUin", "", "uinTypeActivateFriends", "Lcom/tencent/mobileqq/reminder/db/entity/b;", "getLastMessage", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/tencent/mobileqq/reminder/db/entity/b;", "getMsgList", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "uin", "type", "Lkotlin/Function0;", "delegate", "getUnreadCount", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)I", "Landroidx/fragment/app/Fragment;", IGameCardManager.VISITOR, "isNewEngine", "messageRecord", "b", "removeMsgByMessageRecord", "", "uniseq", "removeMsgByUniseq", "(Ljava/lang/String;Ljava/lang/Integer;J)V", "setReaded", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Ltencent/im/s2c/msgtype0x210/submsgtype0x76/SubMsgType0x76$MsgBody;", "body", "getMessageDescrpition", "msg", "msgId", "friendUin", "isTroop", "constructMessageForText", "size", "needSoundVibrationsTip", "isOnline", "handleReceivedMessage", "getMsgUinSeq", "T", QQBrowserActivity.KEY_MSG_TYPE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "createQQReminderRecordByType", "(ILkotlin/jvm/functions/Function1;)Lcom/tencent/mobileqq/reminder/db/b;", "MessageRecord", "rel", "checkIsForReminder", "checkIsForActivateFriends", "checkIsMessageForText", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "Companion", "a", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class RealQQReminderRecordFacade implements IQQReminderRecordFacadeApi, cm2.a {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final a Companion;

    @Deprecated
    public static final int MSG_TYPE_ACTIVATE_FRIENDS = -5003;

    @Deprecated
    public static final int MSG_TYPE_PUSH_REMINDER = -7090;

    @Deprecated
    @NotNull
    public static final String TAG = "RealQQReminderRecordFacade";
    private final /* synthetic */ CacheDataEngine $$delegate_0;
    private final /* synthetic */ com.tencent.mobileqq.reminder.db.entity.a $$delegate_1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/real/RealQQReminderRecordFacade$a;", "", "", "MSG_TYPE_ACTIVATE_FRIENDS", "I", "MSG_TYPE_PUSH_REMINDER", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27100);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            Companion = new a(null);
        }
    }

    public RealQQReminderRecordFacade() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = new CacheDataEngine(new DbDataEngine());
            this.$$delegate_1 = com.tencent.mobileqq.reminder.db.entity.a.f281039a;
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi, cm2.a
    public void addMessage(@NotNull List<? extends b> list, @Nullable String account, @Nullable Boolean isBackgroundStop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, account, isBackgroundStop);
        } else {
            Intrinsics.checkNotNullParameter(list, "list");
            this.$$delegate_0.addMessage(list, account, isBackgroundStop);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public <MessageRecord> boolean checkIsForActivateFriends(@NotNull b msg2, @Nullable Function1<? super MessageRecord, Boolean> delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) msg2, (Object) delegate)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.getMsgtype() == -5003) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public <MessageRecord> boolean checkIsForReminder(@NotNull b msg2, @Nullable Function1<? super MessageRecord, Boolean> delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) msg2, (Object) delegate)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.getMsgtype() == -7090) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public <MessageRecord> boolean checkIsMessageForText(@NotNull b msg2, @Nullable Function1<? super MessageRecord, Boolean> delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) msg2, (Object) delegate)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.getMsgtype() != -7090 && msg2.getMsgtype() != -5003) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    @NotNull
    public b constructMessageForText(@Nullable String msg2, @NotNull String msgId, @NotNull String friendUin, int isTroop) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (b) iPatchRedirector.redirect((short) 11, this, msg2, msgId, friendUin, Integer.valueOf(isTroop));
        }
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        QLog.d(TAG, 1, "constructMessageForText");
        ReminderRecord reminderRecord = new ReminderRecord();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (str = peekAppRuntime.getCurrentAccountUin()) == null) {
            str = "";
        }
        reminderRecord.selfuin = str;
        reminderRecord.frienduin = friendUin;
        reminderRecord.istroop = isTroop;
        reminderRecord.senderuin = "";
        reminderRecord.time = NetConnInfoCenter.getServerTime();
        reminderRecord.f281037msg = msg2;
        reminderRecord.uniseq = msgId.hashCode();
        return reminderRecord;
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    @NotNull
    public <T extends b> T createQQReminderRecordByType(int msgType, @NotNull Function1<? super Integer, ? extends T> delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (T) iPatchRedirector.redirect((short) 14, (Object) this, msgType, (Object) delegate);
        }
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        ReminderRecord b16 = c.b(c.f281040a, msgType, null, 2, null);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type T of com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade.createQQReminderRecordByType");
        return b16;
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi, cm2.a
    @Nullable
    public com.tencent.mobileqq.reminder.db.entity.b getLastMessage(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.reminder.db.entity.b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
        }
        return this.$$delegate_0.getLastMessage(activateFriendsUin, uinTypeActivateFriends);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    @NotNull
    public String getMessageDescrpition(@NotNull SubMsgType0x76$MsgBody body) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) body);
        }
        Intrinsics.checkNotNullParameter(body, "body");
        return this.$$delegate_1.a(body);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi, cm2.a
    @NotNull
    public List<b> getMsgList(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
        }
        return this.$$delegate_0.getMsgList(activateFriendsUin, uinTypeActivateFriends);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public long getMsgUinSeq(@NotNull b messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, (Object) messageRecord)).longValue();
        }
        Intrinsics.checkNotNullParameter(messageRecord, "messageRecord");
        return messageRecord.getUniseq();
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public int getUnreadCount(@Nullable String uin, @Nullable Integer type, @NotNull Function0<Integer> delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, uin, type, delegate)).intValue();
        }
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return this.$$delegate_0.getUnreadCount(uin, type, delegate);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public void handleReceivedMessage(int size, boolean needSoundVibrationsTip, boolean isOnline) {
        Object a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(size), Boolean.valueOf(needSoundVibrationsTip), Boolean.valueOf(isOnline));
            return;
        }
        QLog.d(TAG, 1, "handleReceivedMessage.... size " + size + "  needSoundVibrationsTip " + needSoundVibrationsTip + " isOnline " + isOnline);
        com.tencent.mobileqq.reminder.db.entity.b a17 = a.C0203a.a(this, null, null, 3, null);
        if (a17 != null && (a16 = a17.a()) != null) {
            ReminderRecord reminderRecord = (ReminderRecord) a16;
            Message message = new Message();
            String str = reminderRecord.selfuin;
            message.selfuin = str;
            String str2 = reminderRecord.frienduin;
            if (str2 == null) {
                str2 = "";
            }
            message.frienduin = str2;
            message.istroop = reminderRecord.istroop;
            message.selfuin = str;
            message.time = reminderRecord.time;
            message.uniseq = reminderRecord.uniseq;
            message.msgData = reminderRecord.msgData;
            message.f203106msg = reminderRecord.f281037msg;
            message.extLong = reminderRecord.extLong;
            message.extStr = reminderRecord.extStr;
            message.mExJsonObject = reminderRecord.mExJsonObject;
            message.msgtype = reminderRecord.msgtype;
            message.isread = reminderRecord.isread;
            message.shmsgseq = reminderRecord.shmsgseq;
            message.isValid = reminderRecord.isValid;
            message.extInt = reminderRecord.extInt;
            message.extraflag = reminderRecord.extraflag;
            message.issend = reminderRecord.issend;
            message.longMsgIndex = reminderRecord.longMsgIndex;
            message.longMsgCount = reminderRecord.longMsgCount;
            message.longMsgId = reminderRecord.longMsgId;
            message.msgId = reminderRecord.msgId;
            message.msgUid = reminderRecord.msgUid;
            message.sendFailCode = reminderRecord.sendFailCode;
            message.versionCode = reminderRecord.versionCode;
            message.vipBubbleID = reminderRecord.vipBubbleID;
            ((IMessageFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "")).handleReceivedMessage(size, needSoundVibrationsTip, isOnline, message);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public boolean isNewEngine(@NotNull Fragment visitor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) visitor)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        return this.$$delegate_0.isNewEngine(visitor);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) appRuntime);
        } else {
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    @Deprecated(message = "\u53ea\u4e3a\u9002\u914d\u8001\u4ee3\u7801, \u7981\u6b62\u4f7f\u7528", replaceWith = @ReplaceWith(expression = "removeMsgByUniseq(activateFriendsUin: String, uinTypeActivateFriends: Int, uniseq: Long)", imports = {}))
    public void removeMsgByMessageRecord(@NotNull b messageRecord, boolean b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, messageRecord, Boolean.valueOf(b16));
        } else {
            Intrinsics.checkNotNullParameter(messageRecord, "messageRecord");
            this.$$delegate_0.removeMsgByMessageRecord(messageRecord, b16);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi, cm2.a
    public void removeMsgByUniseq(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends, long uniseq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activateFriendsUin, uinTypeActivateFriends, Long.valueOf(uniseq));
        } else {
            this.$$delegate_0.removeMsgByUniseq(activateFriendsUin, uinTypeActivateFriends, uniseq);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi, cm2.a
    public void setReaded(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
        } else {
            this.$$delegate_0.setReaded(activateFriendsUin, uinTypeActivateFriends);
        }
    }
}
