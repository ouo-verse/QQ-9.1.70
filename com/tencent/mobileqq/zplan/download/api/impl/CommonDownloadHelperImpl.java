package com.tencent.mobileqq.zplan.download.api.impl;

import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tH\u0096\u0001J'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0011H\u0096\u0001J'\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00040\u0016H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0096\u0001\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/impl/CommonDownloadHelperImpl;", "Lcom/tencent/mobileqq/zplan/download/api/ICommonDownloadHelper;", "Lbh3/c;", "listenerWrapper", "", "addDownloadListener", "Lpb3/a;", "listener", "addManagerListener", "Lbh3/b;", "createCommonDownloadListenerWrapper", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadReq;", "param", "Lqb3/b;", "", "skipLog", "downloadResByPath", "", "getCurrentDownloadCount", "getDownloadingCount", "", "id", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "callback", "getZootopiaResInfo", "pause", "removeDownloadListener", "removeManagerListener", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaDownloadParams;", "downloadParams", "startDownload", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CommonDownloadHelperImpl implements ICommonDownloadHelper {
    private final /* synthetic */ CommonDownloadHelper $$delegate_0 = CommonDownloadHelper.INSTANCE;

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void addDownloadListener(bh3.c listenerWrapper) {
        Intrinsics.checkNotNullParameter(listenerWrapper, "listenerWrapper");
        this.$$delegate_0.addDownloadListener(listenerWrapper);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void addManagerListener(pb3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.$$delegate_0.addManagerListener(listener);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public bh3.c createCommonDownloadListenerWrapper(bh3.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.$$delegate_0.createCommonDownloadListenerWrapper(listener);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void downloadResByPath(ZPlanResDownloadReq param, qb3.b listener, boolean skipLog) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.$$delegate_0.downloadResByPath(param, listener, skipLog);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public int getCurrentDownloadCount() {
        return this.$$delegate_0.getCurrentDownloadCount();
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public int getDownloadingCount() {
        return this.$$delegate_0.getDownloadingCount();
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void getZootopiaResInfo(String id5, Function1<? super ZootopiaResData, Unit> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.$$delegate_0.getZootopiaResInfo(id5, callback);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void pause(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.$$delegate_0.pause(id5);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void removeDownloadListener(bh3.c listenerWrapper) {
        Intrinsics.checkNotNullParameter(listenerWrapper, "listenerWrapper");
        this.$$delegate_0.removeDownloadListener(listenerWrapper);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void removeManagerListener(pb3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.$$delegate_0.removeManagerListener(listener);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void startDownload(ZootopiaDownloadParams downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        this.$$delegate_0.startDownload(downloadParams);
    }
}
