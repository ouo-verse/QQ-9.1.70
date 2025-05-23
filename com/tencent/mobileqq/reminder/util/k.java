package com.tencent.mobileqq.reminder.util;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJX\u0010\t\u001a\u00020\b2N\u0010\u0007\u001aJ\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0018\u00010\u0002j,\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0018\u0001`\u0006H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/reminder/util/k;", "Lcom/tencent/qqnt/msg/i;", "Ljava/util/HashMap;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "Lkotlin/collections/HashMap;", "newUnreadCntInfos", "", "onContactUnreadCntUpdate", "", "e", "Z", "mHasSetRead", "<init>", "()V", "f", "a", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
final class k extends com.tencent.qqnt.msg.i {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mHasSetRead;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/util/k$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.util.k$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30745);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onContactUnreadCntUpdate(@Nullable HashMap<Integer, HashMap<String, UnreadCntInfo>> newUnreadCntInfos) {
        HashMap<String, UnreadCntInfo> hashMap;
        UnreadCntInfo unreadCntInfo;
        IQQReminderRecordFacadeApi iQQReminderRecordFacadeApi;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) newUnreadCntInfos);
            return;
        }
        if (newUnreadCntInfos != null && (hashMap = newUnreadCntInfos.get(132)) != null && (unreadCntInfo = hashMap.get(AppConstants.ACTIVATE_FRIENDS_UIN)) != null) {
            if (unreadCntInfo.showUnreadCnt.cnt != 0) {
                this.mHasSetRead = false;
                return;
            }
            if (this.mHasSetRead) {
                return;
            }
            QLog.d("QQReminderMsgListener", 1, "onContactUnreadCntUpdate set QQReminder Read!");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iQQReminderRecordFacadeApi = com.tencent.mobileqq.reminder.db.d.a(peekAppRuntime);
            } else {
                iQQReminderRecordFacadeApi = null;
            }
            if (iQQReminderRecordFacadeApi != null) {
                iQQReminderRecordFacadeApi.setReaded(QQConstants.ACTIVATE_FRIENDS_UIN, 9002);
            }
            this.mHasSetRead = true;
        }
    }
}
