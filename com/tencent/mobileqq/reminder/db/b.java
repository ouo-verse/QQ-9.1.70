package com.tencent.mobileqq.reminder.db;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface b {
    @Nullable
    String getExtInfoFromExtStr(@NonNull String str);

    int getExtLong();

    @Nullable
    String getExtStr();

    @Nullable
    String getFrienduin();

    long getId();

    boolean getIsread();

    int getIstroop();

    @Nullable
    JSONObject getMExJsonObject();

    @Nullable
    String getMsg();

    @Nullable
    byte[] getMsgData();

    int getMsgtype();

    @NonNull
    String getSelfuin();

    @Nullable
    String getSenderuin();

    long getTime();

    long getUniseq();

    void saveExtInfoToExtStr(@NonNull String str, @Nullable String str2);

    void setFrienduin(@Nullable String str);

    void setIsread(boolean z16);

    void setIstroop(int i3);

    void setMsg(@Nullable String str);

    void setMsgData(@Nullable byte[] bArr);

    void setSelfuin(@NonNull String str);

    void setSenderuin(@Nullable String str);

    void setTime(long j3);
}
