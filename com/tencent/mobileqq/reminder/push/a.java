package com.tencent.mobileqq.reminder.push;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.List;
import kotlin.Metadata;
import msf.msgcomm.nt_msg_common$Msg;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J0\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/reminder/push/a;", "", "", "", "b", "", "businessType", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "", TPReportKeys.Common.COMMON_ONLINE, "Lmsf/msgcomm/nt_msg_common$Msg;", "msg", "", "a", "qqreminder-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {
    void a(int businessType, long msgType, long msgSubType, boolean online, @NotNull nt_msg_common$Msg msg2);

    @NotNull
    List<Long> b();
}
