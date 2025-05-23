package com.tencent.smtt.services;

import android.os.ParcelFileDescriptor;

/* loaded from: classes23.dex */
public interface ChildProcessDelegate {
    void onReceiveCrashRecordFileDescriptors(ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2);
}
