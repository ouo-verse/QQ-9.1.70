package com.tencent.mobileqq.reminder.db.entity;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0001H&R\u0014\u0010\u0006\u001a\u00020\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\f\u001a\u00020\u00078&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\r8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\u00020\u00038&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0005\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\r8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001c\u0010\u001c\u001a\u00020\u00078&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/entity/b;", "", "a", "", "getMsgType", "()I", QQBrowserActivity.KEY_MSG_TYPE, "", "getUniseq", "()J", "setUniseq", "(J)V", "uniseq", "", "getFrienduin", "()Ljava/lang/String;", "setFrienduin", "(Ljava/lang/String;)V", "frienduin", "getIstroop", "setIstroop", "(I)V", AppConstants.Key.COLUMN_IS_TROOP, "getMsg", "setMsg", "msg", "getTime", "setTime", "time", "qqreminder-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface b {
    @NotNull
    Object a();

    @Nullable
    String getFrienduin();

    int getIstroop();

    @Nullable
    String getMsg();

    int getMsgType();

    long getTime();

    long getUniseq();
}
