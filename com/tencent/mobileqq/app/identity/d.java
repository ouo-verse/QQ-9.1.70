package com.tencent.mobileqq.app.identity;

import QQService.SvcRspGetDevLoginInfo;
import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface d {
    void onDelDevResult(boolean z16, String str, byte[] bArr);

    void onGetRecentLoginAndLoginDevResult(boolean z16, SvcRspGetDevLoginInfo svcRspGetDevLoginInfo);

    void onRenameAuthDev(boolean z16, int i3, byte[] bArr, String str);

    void onWXSyncQQMsgOption(int i3, Bundle bundle);
}
