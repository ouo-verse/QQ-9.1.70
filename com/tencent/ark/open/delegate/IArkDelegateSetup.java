package com.tencent.ark.open.delegate;

import com.tencent.ark.data.ArkAppElement;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IArkDelegateSetup {
    List<ArkAppElement> getPredownloadApp();

    void setupArkEnvironment(boolean z16);
}
