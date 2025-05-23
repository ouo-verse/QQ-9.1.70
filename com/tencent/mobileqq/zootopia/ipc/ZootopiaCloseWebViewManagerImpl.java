package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.zplan.web.impl.CloseWebViewEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaCloseWebViewManagerImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/j;", "", "closeWebView", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaCloseWebViewManagerImpl implements j {
    public static final String TAG = "ZootopiaCloseWebViewManagerImpl";

    @Override // com.tencent.mobileqq.zootopia.ipc.j
    public void closeWebView() {
        SimpleEventBus.getInstance().dispatchEvent(new CloseWebViewEvent());
        QLog.i(TAG, 1, "closeWebView");
    }
}
