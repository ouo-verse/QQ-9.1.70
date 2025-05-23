package com.tencent.mobileqq.qqecommerce.base.offline;

import com.tencent.ecommerce.base.offline.api.IECOfflineManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B,\u0012#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016R4\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/offline/b;", "Lcom/tencent/biz/common/offline/a;", "", "param", "", "code", "", "loaded", "progress", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$OfflineDownloadState;", "Lkotlin/ParameterName;", "name", "downloadState", "d", "Lkotlin/jvm/functions/Function1;", "getResultBlock", "()Lkotlin/jvm/functions/Function1;", "resultBlock", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
final class b implements com.tencent.biz.common.offline.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function1<IECOfflineManager.OfflineDownloadState, Unit> resultBlock;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super IECOfflineManager.OfflineDownloadState, Unit> function1) {
        this.resultBlock = function1;
    }

    @Override // com.tencent.biz.common.offline.a
    public void loaded(String param, int code) {
        boolean contains$default;
        if (code != 0) {
            Function1<IECOfflineManager.OfflineDownloadState, Unit> function1 = this.resultBlock;
            if (function1 != null) {
                function1.invoke(IECOfflineManager.OfflineDownloadState.STATE_DOWNLOAD_FAIL);
            }
            QLog.w("ECOfflineManager", 1, "ECOffline: download error: " + code);
            return;
        }
        if (param != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) param, (CharSequence) "url", false, 2, (Object) null);
            if (contains$default) {
                QLog.i("ECOfflineManager", 1, "wait for biz bundle");
                return;
            }
            Function1<IECOfflineManager.OfflineDownloadState, Unit> function12 = this.resultBlock;
            if (function12 != null) {
                function12.invoke(IECOfflineManager.OfflineDownloadState.STATE_NO_UPDATE);
            }
            QLog.i("ECOfflineManager", 1, "ECOffline: no update");
            return;
        }
        Function1<IECOfflineManager.OfflineDownloadState, Unit> function13 = this.resultBlock;
        if (function13 != null) {
            function13.invoke(IECOfflineManager.OfflineDownloadState.STATE_DOWNLOAD_SUCCESS);
        }
    }

    @Override // com.tencent.biz.common.offline.a
    public void progress(int progress) {
    }
}
