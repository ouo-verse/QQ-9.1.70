package com.tencent.component.network.downloader.strategy;

import com.tencent.component.network.downloader.common.IPInfo;
import java.util.List;

/* loaded from: classes5.dex */
public interface IPStrategy {
    boolean isIPValid(String str, String str2);

    void onIPAccessResult(String str, String str2, boolean z16);

    String resolveIP(String str);

    String resolveIP(String str, int i3);

    List<IPInfo> resolveVideoIP(String str);
}
