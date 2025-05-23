package com.tencent.libra.download;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LoadContext;
import com.tencent.libra.LoadState;
import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.request.Option;
import com.tencent.libra.task.LibraBaseTask;
import com.tencent.libra.util.LibraLogUtil;

/* loaded from: classes7.dex */
public class LibraPicDownLoadTask extends LibraBaseTask {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraPicDownLoadTask");
    private final ILibraDownloader mDownloader;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a extends ILibraDownloader.PicDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f118649a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Option option, long j3) {
            super(option);
            this.f118649a = j3;
        }

        @Override // com.tencent.libra.download.ILibraDownloader.PicDownLoadListener
        public void onResult(boolean z16, int i3) {
            if (z16) {
                LibraPicDownLoadTask.this.mPicLoader.afterDownload(this.mOption, this.f118649a, true, 0);
            } else {
                LibraPicDownLoadTask.this.mPicLoader.afterDownload(this.mOption, this.f118649a, false, i3);
                LibraPicDownLoadTask.this.mPicLoader.onLoadResult(this.mOption, 1);
            }
        }
    }

    public LibraPicDownLoadTask(LoadContext loadContext, ILibraDownloader iLibraDownloader) {
        super(loadContext);
        this.mDownloader = iLibraDownloader;
    }

    private void doRealDownLoad(long j3) {
        ILibraDownloader iLibraDownloader = this.mDownloader;
        Option option = this.mOption;
        iLibraDownloader.downLoad(option, new a(option, j3));
    }

    @Override // com.tencent.libra.task.ILibraTask
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.libra.task.ILibraTask, java.lang.Runnable
    public void run() {
        if (this.mStatus == LoadState.STATE_CANCEL) {
            return;
        }
        this.mStatus = LoadState.STATE_DOWNLOADING;
        long currentTimeMillis = System.currentTimeMillis();
        LibraLogUtil libraLogUtil = LibraLogUtil.INSTANCE;
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        Option option = this.mOption;
        libraLogUtil.i(logTag, i3, option, "[run] download start cost in queue:", Long.valueOf(currentTimeMillis - option.mDownLoadStartTime.longValue()));
        doRealDownLoad(currentTimeMillis);
    }

    @Override // com.tencent.libra.task.LibraBaseTask
    public void onCancel() {
    }
}
