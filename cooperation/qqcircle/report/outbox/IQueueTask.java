package cooperation.qqcircle.report.outbox;

import com.tencent.smartparcelable.a;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface IQueueTask extends a {
    void clear();

    String getCacheKey();

    long getResultCode();

    String getResultMsg();

    int getRetryNum();

    int getState();

    long getTaskId();

    long getTime();

    boolean isNullTask();

    void onRemove();

    void onRestore();

    void onResume();

    void setResultCode(long j3);

    void setResultMsg(String str);

    void setState(int i3);

    void setTime(long j3);
}
