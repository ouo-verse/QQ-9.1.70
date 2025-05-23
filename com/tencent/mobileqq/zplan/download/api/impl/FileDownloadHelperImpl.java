package com.tencent.mobileqq.zplan.download.api.impl;

import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/impl/FileDownloadHelperImpl;", "Lcom/tencent/mobileqq/zplan/download/api/IFileDownloadHelper;", "Lbh3/f;", "listenerWrapper", "", "addFileDownloadListener", "Lbh3/e;", "listener", "createFileDownloadListenerWrapper", "Lcom/tencent/mobileqq/z1/download/ZPlanFileCategory;", "category", "", "url", "Lkotlin/Function0;", "callback", "delete", "download", "removeFileDownloadListener", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FileDownloadHelperImpl implements IFileDownloadHelper {
    private final /* synthetic */ FileDownloadHelper $$delegate_0 = FileDownloadHelper.INSTANCE;

    @Override // com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper
    public void addFileDownloadListener(bh3.f listenerWrapper) {
        Intrinsics.checkNotNullParameter(listenerWrapper, "listenerWrapper");
        this.$$delegate_0.addFileDownloadListener(listenerWrapper);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper
    public bh3.f createFileDownloadListenerWrapper(bh3.e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.$$delegate_0.createFileDownloadListenerWrapper(listener);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper
    public void delete(ZPlanFileCategory category, String url, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.$$delegate_0.delete(category, url, callback);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper
    public void download(ZPlanFileCategory category, String url) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(url, "url");
        this.$$delegate_0.download(category, url);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper
    public void removeFileDownloadListener(bh3.f listenerWrapper) {
        Intrinsics.checkNotNullParameter(listenerWrapper, "listenerWrapper");
        this.$$delegate_0.removeFileDownloadListener(listenerWrapper);
    }
}
