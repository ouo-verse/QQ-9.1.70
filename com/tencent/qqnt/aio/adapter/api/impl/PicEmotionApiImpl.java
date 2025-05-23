package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.api.IHotPicPageApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IPicEmotionApi;
import com.tencent.qqnt.aio.adapter.api.impl.PicEmotionApiImpl;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchEmojiInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001e\u0010\u000f\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\r\u001a\u00020\fH\u0002J&\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/PicEmotionApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IPicEmotionApi;", "Lcom/tencent/mobileqq/hotpic/HotPicData;", "hotPicData", "", "getDiskPath", "Lkotlin/Function1;", "", "callback", "startDownload", "Lkotlin/Function0;", "block", "", "timeout", "Lcom/tencent/qqnt/aio/adapter/api/impl/PicEmotionApiImpl$b;", "startTimeout", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicSearchEmojiInfo;", "emojiInfo", "downloadPicEmotion", "<init>", "()V", "Companion", "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PicEmotionApiImpl implements IPicEmotionApi {
    private static final String TAG = "PicEmotionApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/PicEmotionApiImpl$b;", "", "", "a", "Z", "b", "()Z", "d", "(Z)V", "isTimeout", "c", "isCancel", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isTimeout;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isCancel;

        /* renamed from: a, reason: from getter */
        public final boolean getIsCancel() {
            return this.isCancel;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsTimeout() {
            return this.isTimeout;
        }

        public final void c(boolean z16) {
            this.isCancel = z16;
        }

        public final void d(boolean z16) {
            this.isTimeout = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadPicEmotion$lambda$0(PicEmotionApiImpl this$0, EmotionSearchItem searchItem, Function1 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(searchItem, "$searchItem");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.startDownload(searchItem, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDiskPath(HotPicData hotPicData) {
        File diskFile;
        File diskFile2;
        String str = hotPicData.originalUrl;
        if (!(str == null || str.length() == 0) && (diskFile2 = com.tencent.mobileqq.hotpic.b.getDiskFile(hotPicData.originalUrl)) != null && FileUtils.fileExistsAndNotEmpty(diskFile2.getAbsolutePath())) {
            return diskFile2.getAbsolutePath();
        }
        String str2 = hotPicData.url;
        if ((str2 == null || str2.length() == 0) || (diskFile = com.tencent.mobileqq.hotpic.b.getDiskFile(hotPicData.url)) == null || !FileUtils.fileExistsAndNotEmpty(diskFile.getAbsolutePath())) {
            return null;
        }
        return diskFile.getAbsolutePath();
    }

    private final void startDownload(final HotPicData hotPicData, final Function1<? super String, Unit> callback) {
        URLDrawable uRLDrawable;
        try {
            uRLDrawable = ((IHotPicPageApi) QRoute.api(IHotPicPageApi.class)).getHotPicDrawable(hotPicData);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getHotPicDrawable error:", e16);
            uRLDrawable = null;
        }
        if (uRLDrawable == null) {
            QLog.e(TAG, 1, "drawable is null");
            callback.invoke(null);
        } else {
            uRLDrawable.setDownloadListener(new c(hotPicData, startTimeout(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.PicEmotionApiImpl$startDownload$timeoutTask$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QLog.e("PicEmotionApiImpl", 1, "download timeout " + HotPicData.this.url);
                    callback.invoke(null);
                }
            }, 10000L), this, callback));
            uRLDrawable.startDownload(false);
        }
    }

    private final b startTimeout(final Function0<Unit> block, long timeout) {
        final b bVar = new b();
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.aw
            @Override // java.lang.Runnable
            public final void run() {
                PicEmotionApiImpl.startTimeout$lambda$1(PicEmotionApiImpl.b.this, block);
            }
        }, 16, null, false, timeout);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTimeout$lambda$1(b timeoutTask, Function0 block) {
        Intrinsics.checkNotNullParameter(timeoutTask, "$timeoutTask");
        Intrinsics.checkNotNullParameter(block, "$block");
        if (timeoutTask.getIsCancel()) {
            return;
        }
        timeoutTask.d(true);
        block.invoke();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPicEmotionApi
    public void downloadPicEmotion(EmojiHotPicSearchEmojiInfo emojiInfo, final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(emojiInfo, "emojiInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final EmotionSearchItem searchInfoToSearchItem = ((IHotPicPageApi) QRoute.api(IHotPicPageApi.class)).searchInfoToSearchItem(emojiInfo);
        String diskPath = getDiskPath(searchInfoToSearchItem);
        if (!(diskPath == null || diskPath.length() == 0)) {
            callback.invoke(diskPath);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ax
                @Override // java.lang.Runnable
                public final void run() {
                    PicEmotionApiImpl.downloadPicEmotion$lambda$0(PicEmotionApiImpl.this, searchInfoToSearchItem, callback);
                }
            }, 16, null, false);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/PicEmotionApiImpl$c", "Lcom/tencent/image/URLDrawable$DownloadListener;", "", "a", "onFileDownloadStarted", "", "fileSize", "onFileDownloadSucceed", "", "errorCode", "onFileDownloadFailed", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements URLDrawable.DownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HotPicData f348579d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f348580e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PicEmotionApiImpl f348581f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f348582h;

        /* JADX WARN: Multi-variable type inference failed */
        c(HotPicData hotPicData, b bVar, PicEmotionApiImpl picEmotionApiImpl, Function1<? super String, Unit> function1) {
            this.f348579d = hotPicData;
            this.f348580e = bVar;
            this.f348581f = picEmotionApiImpl;
            this.f348582h = function1;
        }

        private final void a() {
            if (this.f348580e.getIsTimeout() || this.f348580e.getIsCancel()) {
                return;
            }
            this.f348580e.c(true);
            this.f348582h.invoke(this.f348581f.getDiskPath(this.f348579d));
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int errorCode) {
            QLog.d(PicEmotionApiImpl.TAG, 1, "onFileDownloadFailed errorCode=" + errorCode + " " + this.f348579d.url);
            a();
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long fileSize) {
            QLog.d(PicEmotionApiImpl.TAG, 1, "onFileDownloadSucceed " + this.f348579d.url);
            a();
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
        }
    }
}
