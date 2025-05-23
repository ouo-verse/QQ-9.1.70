package com.tencent.soter.core.sotercore;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface SoterCoreTrebleServiceListener {
    void onNoServiceWhenCalling();

    void onServiceBinderDied();

    void onServiceConnected();

    void onServiceDisconnected();

    void onStartServiceConnecting();
}
