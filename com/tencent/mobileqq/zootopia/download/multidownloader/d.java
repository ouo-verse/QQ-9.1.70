package com.tencent.mobileqq.zootopia.download.multidownloader;

import com.tencent.multidownloader.IMDDownloadLogProxy;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/multidownloader/d;", "Lcom/tencent/multidownloader/IMDDownloadLogProxy;", "", "tag", "msg", "", "d", "i", "w", "e", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d implements IMDDownloadLogProxy {
    @Override // com.tencent.multidownloader.IMDDownloadLogProxy
    public void e(String tag, String msg2) {
        QLog.e("ZPlanMultiDownloader_Log_" + tag, 1, msg2);
    }

    @Override // com.tencent.multidownloader.IMDDownloadLogProxy
    public void i(String tag, String msg2) {
        QLog.i("ZPlanMultiDownloader_Log_" + tag, 1, msg2);
    }

    @Override // com.tencent.multidownloader.IMDDownloadLogProxy
    public void w(String tag, String msg2) {
        QLog.w("ZPlanMultiDownloader_Log_" + tag, 1, msg2);
    }

    @Override // com.tencent.multidownloader.IMDDownloadLogProxy
    public void d(String tag, String msg2) {
    }
}
