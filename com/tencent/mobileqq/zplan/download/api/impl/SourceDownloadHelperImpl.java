package com.tencent.mobileqq.zplan.download.api.impl;

import com.tencent.mobileqq.zplan.download.SourceDownloadUtils;
import com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0019\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0019\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/impl/SourceDownloadHelperImpl;", "Lcom/tencent/mobileqq/zplan/download/api/ISourceDownloadHelper;", "()V", "downloadSource", "", "sourceUrl", "", "category", "", "getFileByUrl", "getFilePath", "isSourceExit", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SourceDownloadHelperImpl implements ISourceDownloadHelper {
    private final /* synthetic */ SourceDownloadUtils $$delegate_0 = SourceDownloadUtils.INSTANCE;

    @Override // com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper
    public void downloadSource(String sourceUrl, int category) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        this.$$delegate_0.downloadSource(sourceUrl, category);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper
    public void getFileByUrl(String sourceUrl, int category) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        this.$$delegate_0.getFileByUrl(sourceUrl, category);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper
    public void getFilePath(String sourceUrl, int category) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        this.$$delegate_0.getFilePath(sourceUrl, category);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper
    public String isSourceExit(String sourceUrl, int category) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        return this.$$delegate_0.isSourceExit(sourceUrl, category);
    }
}
