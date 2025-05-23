package com.tencent.av.gaudio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVObserver implements Observer {
    public static final String TAG = "GAudioObserver";
    Handler mHandler = null;

    void onUpdate(Object obj) {
        Object[] objArr = (Object[]) obj;
        int intValue = ((Integer) objArr[0]).intValue();
        if (intValue != 28) {
            if (intValue != 29) {
                if (intValue != 32) {
                    if (intValue != 33) {
                        if (intValue != 36) {
                            if (intValue != 37) {
                                if (intValue != 800) {
                                    switch (intValue) {
                                        case 21:
                                            onMemberInfo(((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue());
                                            return;
                                        case 22:
                                            onMemberJoin(((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue());
                                            return;
                                        case 23:
                                            onMemberQuit(((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue());
                                            return;
                                        default:
                                            int intValue2 = ((Integer) objArr[1]).intValue();
                                            long longValue = ((Long) objArr[2]).longValue();
                                            long longValue2 = ((Long) objArr[3]).longValue();
                                            if (QLog.isDevelopLevel()) {
                                                QLog.w(TAG, 1, "onUpdate, relationType[" + intValue2 + "], discussId[" + longValue + "], memberUin[" + longValue2 + "], msg[" + intValue + "]");
                                            }
                                            onMemberInfo(intValue2, longValue, longValue2);
                                            return;
                                    }
                                }
                                onSmallScreenStateChange((String) objArr[1]);
                                return;
                            }
                            onMeetingCancel(((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue());
                            return;
                        }
                        onMeetingReady(((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue());
                        return;
                    }
                    onGroupSecurityLimit(((Long) objArr[2]).longValue(), ((Integer) objArr[1]).intValue(), ((Long) objArr[3]).longValue(), (String) objArr[4]);
                    return;
                }
                onManagerForbiddenOpenRoom(((Long) objArr[2]).longValue(), ((Integer) objArr[1]).intValue(), ((Long) objArr[3]).longValue(), ((Integer) objArr[4]).intValue());
                return;
            }
            onUpdateTime((String) objArr[2], (String) objArr[3]);
            return;
        }
        onAudioChatting(((Integer) objArr[1]).intValue(), (String) objArr[2], (String) objArr[3]);
    }

    @Override // java.util.Observer
    public void update(Observable observable, final Object obj) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(mainLooper);
            }
            this.mHandler.post(new Runnable() { // from class: com.tencent.av.gaudio.AVObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    AVObserver.this.onUpdate(obj);
                }
            });
            return;
        }
        onUpdate(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSmallScreenStateChange(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMeetingCancel(int i3, long j3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMeetingReady(int i3, long j3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUpdateTime(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAudioChatting(int i3, String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMemberInfo(int i3, long j3, long j16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMemberJoin(int i3, long j3, long j16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMemberQuit(int i3, long j3, long j16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGroupSecurityLimit(long j3, int i3, long j16, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onManagerForbiddenOpenRoom(long j3, int i3, long j16, int i16) {
    }
}
