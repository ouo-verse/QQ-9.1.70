package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelDirectSessionListener {
    void onCreateDirectSession(DirectSessionInfo directSessionInfo, int i3);

    void onDirectSessionListChanged(ArrayList<String> arrayList, ArrayList<DirectSessionInfo> arrayList2, ArrayList<String> arrayList3, boolean z16);

    void onDirectSwitchStatus(int i3);

    void onSetDirectSessionBlackStatus(DirectSessionInfo directSessionInfo, int i3);
}
