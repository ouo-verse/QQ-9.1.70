package com.heytap.databaseengine.apiv2.common;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class HRunnable implements Runnable {
    public abstract void realRun() throws Exception;

    @Override // java.lang.Runnable
    public void run() {
        try {
            realRun();
        } catch (Exception e16) {
            onException(e16);
        }
    }

    public void onException(Exception exc) {
    }
}
