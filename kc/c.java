package kc;

import android.content.SharedPreferences;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueueStrategy;
import com.tencent.biz.richframework.queue.RFWDownloadTaskLocalStorageDelegate;
import cooperation.qzone.LocalMultiProcConfig;
import kj.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lkc/c;", "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueStrategy;", "", "getBusinessKey", "getDownloadRootPath", "Landroid/content/SharedPreferences;", "getSP", "", "supportUnZipFile", "supportBreakPointDownload", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskLocalStorageDelegate;", "getTaskLocalStorageDelegate", "", "getRunMaxCount", "isSupplementFileExtensionName", "allowGeneratedNoMedia", "supportSaveToSystemAlbum", "Lcom/tencent/biz/richframework/queue/DownloadState;", "state", "supportClearByTaskState", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends RFWDownloadQueueStrategy {
    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean allowGeneratedNoMedia() {
        return false;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public String getBusinessKey() {
        return "qzone_albumx";
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public String getDownloadRootPath() {
        return eb.a.f396056a.a();
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueStrategy
    public int getRunMaxCount() {
        return 3;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public SharedPreferences getSP() {
        SharedPreferences preferences = LocalMultiProcConfig.getPreferences(LocalMultiProcConfig.PREFS_NAME_RFW_DOWNLOAD_MEDIA_SETTING);
        Intrinsics.checkNotNullExpressionValue(preferences, "getPreferences(LocalMult\u2026W_DOWNLOAD_MEDIA_SETTING)");
        return preferences;
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueStrategy
    public RFWDownloadTaskLocalStorageDelegate getTaskLocalStorageDelegate() {
        return new e();
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean isSupplementFileExtensionName() {
        return true;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean supportBreakPointDownload() {
        return true;
    }

    @Override // com.tencent.biz.richframework.queue.RFWTaskClearStrategy
    public boolean supportClearByTaskState(DownloadState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return state == DownloadState.STATE_SUCCESS || state == DownloadState.STATE_CANCEL;
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueStrategy
    public boolean supportSaveToSystemAlbum() {
        return true;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean supportUnZipFile() {
        return true;
    }
}
