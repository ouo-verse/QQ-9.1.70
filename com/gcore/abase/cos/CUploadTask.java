package com.gcore.abase.cos;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CUploadTask {
    private long mCListener;
    private long mCTask;
    private CosUploadTask task = new CosUploadTask();

    public native void nativeOnUploadFinished(long j3, long j16, int i3);

    public void upload(String str, String str2, long j3, String str3, long j16, long j17, String str4) {
        this.mCListener = j16;
        this.mCTask = j17;
        this.task.setCredentialInfo(str3);
        this.task.setResultListener(new CosResultListener() { // from class: com.gcore.abase.cos.CUploadTask.1
            @Override // com.gcore.abase.cos.CosResultListener
            public void onFinished(int i3) {
                CUploadTask cUploadTask = CUploadTask.this;
                cUploadTask.nativeOnUploadFinished(cUploadTask.mCTask, CUploadTask.this.mCListener, i3);
            }
        });
        this.task.upload(str, str2, j3, str4);
    }
}
