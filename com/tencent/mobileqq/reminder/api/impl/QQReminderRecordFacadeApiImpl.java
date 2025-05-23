package com.tencent.mobileqq.reminder.api.impl;

import androidx.fragment.app.Fragment;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade;
import com.tencent.mobileqq.reminder.db.toogle.ToggleKitKt;
import com.tencent.mobileqq.vip.IGameCardManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b@\u0010AJ*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J1\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\rH\u0016JD\u0010%\u001a\u00028\u0000\"\b\b\u0000\u0010\u001f*\u00020\b2\u0006\u0010 \u001a\u00020\u00062!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b( \u0012\u0004\u0012\u00028\u00000!H\u0016\u00a2\u0006\u0004\b%\u0010&J8\u0010)\u001a\u00020\r\"\u0004\b\u0000\u0010'2\u0006\u0010\u0003\u001a\u00020\b2 \u0010$\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010!j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`(H\u0016J8\u0010*\u001a\u00020\r\"\u0004\b\u0000\u0010'2\u0006\u0010\u0003\u001a\u00020\b2 \u0010$\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010!j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`(H\u0016J8\u0010+\u001a\u00020\r\"\u0004\b\u0000\u0010'2\u0006\u0010\u0003\u001a\u00020\b2 \u0010$\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010!j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`(H\u0016J+\u0010-\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b-\u0010.J%\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b0\u00101J1\u00105\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u00022\b\u00103\u001a\u0004\u0018\u00010\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000604H\u0016\u00a2\u0006\u0004\b5\u00106J#\u00107\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b7\u00108J\u0010\u0010;\u001a\u00020\r2\u0006\u0010:\u001a\u000209H\u0016R\u0014\u0010?\u001a\u00020<8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/reminder/api/impl/QQReminderRecordFacadeApiImpl;", "Lcom/tencent/mobileqq/reminder/db/real/RealQQReminderRecordFacade;", "", "msg", "msgId", "friendUin", "", "isTroop", "Lcom/tencent/mobileqq/reminder/db/b;", "constructMessageForText", "", "list", "account", "", "isBackgroundStop", "", "addMessage", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "size", "needSoundVibrationsTip", "isOnline", "handleReceivedMessage", "activateFriendsUin", "uinTypeActivateFriends", "getMsgList", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "messageRecord", "", "getMsgUinSeq", "b", "removeMsgByMessageRecord", "T", QQBrowserActivity.KEY_MSG_TYPE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delegate", "createQQReminderRecordByType", "(ILkotlin/jvm/functions/Function1;)Lcom/tencent/mobileqq/reminder/db/b;", "MessageRecord", "Lcom/tencent/mobileqq/reminder/api/OptDelegate;", "checkIsForReminder", "checkIsForActivateFriends", "checkIsMessageForText", "uniseq", "removeMsgByUniseq", "(Ljava/lang/String;Ljava/lang/Integer;J)V", "Lcom/tencent/mobileqq/reminder/db/entity/b;", "getLastMessage", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/tencent/mobileqq/reminder/db/entity/b;", "uin", "type", "Lkotlin/Function0;", "getUnreadCount", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)I", "setReaded", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Landroidx/fragment/app/Fragment;", IGameCardManager.VISITOR, "isNewEngine", "Lcom/tencent/mobileqq/msg/api/IMessageFacade;", "getMessageFacade", "()Lcom/tencent/mobileqq/msg/api/IMessageFacade;", "messageFacade", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QQReminderRecordFacadeApiImpl extends RealQQReminderRecordFacade {
    static IPatchRedirector $redirector_;

    public QQReminderRecordFacadeApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IMessageFacade getMessageFacade() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ssConstant.MAIN\n        )");
        return (IMessageFacade) runtimeService;
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi, cm2.a
    public void addMessage(@NotNull List<? extends com.tencent.mobileqq.reminder.db.b> list, @Nullable String account, @Nullable Boolean isBackgroundStop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, account, isBackgroundStop);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        if (ToggleKitKt.a()) {
            super.addMessage(list, account, isBackgroundStop);
            return;
        }
        IMessageFacade messageFacade = getMessageFacade();
        Intrinsics.checkNotNull(isBackgroundStop);
        messageFacade.addMessage((List<MessageRecord>) list, account, isBackgroundStop.booleanValue());
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public <MessageRecord> boolean checkIsForActivateFriends(@NotNull com.tencent.mobileqq.reminder.db.b msg2, @Nullable Function1<? super MessageRecord, Boolean> delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) msg2, (Object) delegate)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (ToggleKitKt.a()) {
            return super.checkIsForActivateFriends(msg2, delegate);
        }
        if (delegate != null) {
            return delegate.invoke(msg2).booleanValue();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public <MessageRecord> boolean checkIsForReminder(@NotNull com.tencent.mobileqq.reminder.db.b msg2, @Nullable Function1<? super MessageRecord, Boolean> delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) msg2, (Object) delegate)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (ToggleKitKt.a()) {
            return super.checkIsForReminder(msg2, delegate);
        }
        if (delegate != null) {
            return delegate.invoke(msg2).booleanValue();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public <MessageRecord> boolean checkIsMessageForText(@NotNull com.tencent.mobileqq.reminder.db.b msg2, @Nullable Function1<? super MessageRecord, Boolean> delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) msg2, (Object) delegate)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (ToggleKitKt.a()) {
            return super.checkIsMessageForText(msg2, delegate);
        }
        if (delegate != null) {
            return delegate.invoke(msg2).booleanValue();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    @NotNull
    public com.tencent.mobileqq.reminder.db.b constructMessageForText(@Nullable String msg2, @NotNull String msgId, @NotNull String friendUin, int isTroop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.reminder.db.b) iPatchRedirector.redirect((short) 2, this, msg2, msgId, friendUin, Integer.valueOf(isTroop));
        }
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        if (ToggleKitKt.a()) {
            return super.constructMessageForText(msg2, msgId, friendUin, isTroop);
        }
        Object constructMessageForText = getMessageFacade().constructMessageForText(msg2, msgId, friendUin, isTroop);
        Intrinsics.checkNotNull(constructMessageForText, "null cannot be cast to non-null type com.tencent.mobileqq.reminder.db.IReminderRecord");
        return (com.tencent.mobileqq.reminder.db.b) constructMessageForText;
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    @NotNull
    public <T extends com.tencent.mobileqq.reminder.db.b> T createQQReminderRecordByType(int msgType, @NotNull Function1<? super Integer, ? extends T> delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, (Object) this, msgType, (Object) delegate);
        }
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (ToggleKitKt.a()) {
            return (T) super.createQQReminderRecordByType(msgType, delegate);
        }
        return delegate.invoke(Integer.valueOf(msgType));
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi, cm2.a
    @Nullable
    public com.tencent.mobileqq.reminder.db.entity.b getLastMessage(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mobileqq.reminder.db.entity.b) iPatchRedirector.redirect((short) 13, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
        }
        if (ToggleKitKt.a()) {
            return super.getLastMessage(activateFriendsUin, uinTypeActivateFriends);
        }
        IMessageFacade messageFacade = getMessageFacade();
        Intrinsics.checkNotNull(uinTypeActivateFriends);
        Message lastMessage = messageFacade.getLastMessage(activateFriendsUin, uinTypeActivateFriends.intValue());
        Intrinsics.checkNotNullExpressionValue(lastMessage, "messageFacade.getLastMes\u2026uinTypeActivateFriends!!)");
        return com.tencent.mobileqq.reminder.db.a.f(lastMessage);
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi, cm2.a
    @NotNull
    public List<com.tencent.mobileqq.reminder.db.b> getMsgList(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
        }
        if (ToggleKitKt.a()) {
            return super.getMsgList(activateFriendsUin, uinTypeActivateFriends);
        }
        IMessageFacade messageFacade = getMessageFacade();
        Intrinsics.checkNotNull(uinTypeActivateFriends);
        List msgList = messageFacade.getMsgList(activateFriendsUin, uinTypeActivateFriends.intValue());
        Intrinsics.checkNotNull(msgList, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.reminder.db.IReminderRecord>");
        return msgList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public long getMsgUinSeq(@NotNull com.tencent.mobileqq.reminder.db.b messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageRecord)).longValue();
        }
        Intrinsics.checkNotNullParameter(messageRecord, "messageRecord");
        if (ToggleKitKt.a()) {
            return super.getMsgUinSeq(messageRecord);
        }
        return getMessageFacade().getMsgUinSeq((MessageRecord) messageRecord);
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public int getUnreadCount(@Nullable String uin, @Nullable Integer type, @NotNull Function0<Integer> delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, this, uin, type, delegate)).intValue();
        }
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (ToggleKitKt.a()) {
            return super.getUnreadCount(uin, type, delegate);
        }
        return delegate.invoke().intValue();
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public void handleReceivedMessage(final int size, final boolean needSoundVibrationsTip, final boolean isOnline) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(size), Boolean.valueOf(needSoundVibrationsTip), Boolean.valueOf(isOnline));
        } else {
            ToggleKitKt.b(new Function0<Unit>(size, needSoundVibrationsTip, isOnline) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderRecordFacadeApiImpl$handleReceivedMessage$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isOnline;
                final /* synthetic */ boolean $needSoundVibrationsTip;
                final /* synthetic */ int $size;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$size = size;
                    this.$needSoundVibrationsTip = needSoundVibrationsTip;
                    this.$isOnline = isOnline;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQReminderRecordFacadeApiImpl.this, Integer.valueOf(size), Boolean.valueOf(needSoundVibrationsTip), Boolean.valueOf(isOnline));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        super/*com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade*/.handleReceivedMessage(this.$size, this.$needSoundVibrationsTip, this.$isOnline);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, new Function0<Unit>(size, needSoundVibrationsTip, isOnline) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderRecordFacadeApiImpl$handleReceivedMessage$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isOnline;
                final /* synthetic */ boolean $needSoundVibrationsTip;
                final /* synthetic */ int $size;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$size = size;
                    this.$needSoundVibrationsTip = needSoundVibrationsTip;
                    this.$isOnline = isOnline;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQReminderRecordFacadeApiImpl.this, Integer.valueOf(size), Boolean.valueOf(needSoundVibrationsTip), Boolean.valueOf(isOnline));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IMessageFacade messageFacade;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        messageFacade = QQReminderRecordFacadeApiImpl.this.getMessageFacade();
                        messageFacade.handleReceivedMessage(this.$size, this.$needSoundVibrationsTip, this.$isOnline);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public boolean isNewEngine(@NotNull Fragment visitor) {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) visitor)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        String name = visitor.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "visitor.javaClass.name");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "QQReminderDebugFragment", false, 2, (Object) null);
        if (contains$default) {
            return ToggleKitKt.a();
        }
        throw new RuntimeException(visitor + " can not visit this api");
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi
    public void removeMsgByMessageRecord(@NotNull final com.tencent.mobileqq.reminder.db.b messageRecord, final boolean b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, messageRecord, Boolean.valueOf(b16));
        } else {
            Intrinsics.checkNotNullParameter(messageRecord, "messageRecord");
            ToggleKitKt.b(new Function0<Unit>(messageRecord, b16) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderRecordFacadeApiImpl$removeMsgByMessageRecord$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $b;
                final /* synthetic */ com.tencent.mobileqq.reminder.db.b $messageRecord;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$messageRecord = messageRecord;
                    this.$b = b16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQReminderRecordFacadeApiImpl.this, messageRecord, Boolean.valueOf(b16));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        super/*com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade*/.removeMsgByMessageRecord(this.$messageRecord, this.$b);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, new Function0<Unit>(messageRecord, b16) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderRecordFacadeApiImpl$removeMsgByMessageRecord$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $b;
                final /* synthetic */ com.tencent.mobileqq.reminder.db.b $messageRecord;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$messageRecord = messageRecord;
                    this.$b = b16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQReminderRecordFacadeApiImpl.this, messageRecord, Boolean.valueOf(b16));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IMessageFacade messageFacade;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    messageFacade = QQReminderRecordFacadeApiImpl.this.getMessageFacade();
                    Object obj = this.$messageRecord;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageRecord");
                    messageFacade.removeMsgByMessageRecord((MessageRecord) obj, this.$b);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi, cm2.a
    public void removeMsgByUniseq(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends, long uniseq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, activateFriendsUin, uinTypeActivateFriends, Long.valueOf(uniseq));
        } else {
            if (ToggleKitKt.a()) {
                super.removeMsgByUniseq(activateFriendsUin, uinTypeActivateFriends, uniseq);
                return;
            }
            IMessageFacade messageFacade = getMessageFacade();
            Intrinsics.checkNotNull(uinTypeActivateFriends);
            messageFacade.removeMsgByUniseq(activateFriendsUin, uinTypeActivateFriends.intValue(), uniseq);
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade, com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi, cm2.a
    public void setReaded(@Nullable final String activateFriendsUin, @Nullable final Integer uinTypeActivateFriends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
        } else {
            ToggleKitKt.b(new Function0<Unit>(activateFriendsUin, uinTypeActivateFriends) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderRecordFacadeApiImpl$setReaded$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $activateFriendsUin;
                final /* synthetic */ Integer $uinTypeActivateFriends;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$activateFriendsUin = activateFriendsUin;
                    this.$uinTypeActivateFriends = uinTypeActivateFriends;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQReminderRecordFacadeApiImpl.this, activateFriendsUin, uinTypeActivateFriends);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        super/*com.tencent.mobileqq.reminder.db.real.RealQQReminderRecordFacade*/.setReaded(this.$activateFriendsUin, this.$uinTypeActivateFriends);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, new Function0<Unit>(activateFriendsUin, uinTypeActivateFriends) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderRecordFacadeApiImpl$setReaded$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $activateFriendsUin;
                final /* synthetic */ Integer $uinTypeActivateFriends;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$activateFriendsUin = activateFriendsUin;
                    this.$uinTypeActivateFriends = uinTypeActivateFriends;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQReminderRecordFacadeApiImpl.this, activateFriendsUin, uinTypeActivateFriends);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IMessageFacade messageFacade;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    messageFacade = QQReminderRecordFacadeApiImpl.this.getMessageFacade();
                    String str = this.$activateFriendsUin;
                    Integer num = this.$uinTypeActivateFriends;
                    Intrinsics.checkNotNull(num);
                    messageFacade.setReaded(str, num.intValue());
                }
            });
        }
    }
}
