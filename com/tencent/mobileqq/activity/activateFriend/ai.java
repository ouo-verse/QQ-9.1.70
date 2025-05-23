package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.content.Context;
import com.tencent.mobileqq.activity.activateFriend.qqlive.QQLiveReminderCardItemPage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqlive.api.reminder.IQQLiveReminderApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "LWallet/AcsMsg;", "acsMsg", "Lcom/tencent/mobileqq/activity/activateFriend/ReminderCardItemPage;", "b", "", "", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class ai {
    @NotNull
    public static final Map<String, String> a(@Nullable AcsMsg acsMsg) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        IQQLiveReminderApi iQQLiveReminderApi = (IQQLiveReminderApi) QRoute.api(IQQLiveReminderApi.class);
        String str3 = null;
        if (acsMsg != null) {
            str = acsMsg.busi_id;
        } else {
            str = null;
        }
        if (acsMsg != null) {
            str2 = acsMsg.msg_id;
        } else {
            str2 = null;
        }
        if (iQQLiveReminderApi.isQQLiveReminder(str, str2)) {
            IQQLiveReminderApi iQQLiveReminderApi2 = (IQQLiveReminderApi) QRoute.api(IQQLiveReminderApi.class);
            if (acsMsg != null) {
                str3 = acsMsg.extend_field;
            }
            return ((IQQLiveReminderApi) QRoute.api(IQQLiveReminderApi.class)).createReportParams(iQQLiveReminderApi2.parseQQLiveNoticeInfo(str3));
        }
        return hashMap;
    }

    @NotNull
    public static final ReminderCardItemPage b(@NotNull Context context, @NotNull QQAppInterface app, @Nullable AcsMsg acsMsg) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        IQQLiveReminderApi iQQLiveReminderApi = (IQQLiveReminderApi) QRoute.api(IQQLiveReminderApi.class);
        String str2 = null;
        if (acsMsg != null) {
            str = acsMsg.busi_id;
        } else {
            str = null;
        }
        if (acsMsg != null) {
            str2 = acsMsg.msg_id;
        }
        if (iQQLiveReminderApi.isQQLiveReminder(str, str2)) {
            return new QQLiveReminderCardItemPage(context, app);
        }
        return new ReminderCardItemPage(context, app);
    }
}
