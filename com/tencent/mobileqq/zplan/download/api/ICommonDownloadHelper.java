package com.tencent.mobileqq.zplan.download.api;

import bh3.c;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qb3.b;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0015\u001a\u00020\u0013H&J&\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00070\u0016H&J&\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/ICommonDownloadHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lbh3/b;", "listener", "Lbh3/c;", "createCommonDownloadListenerWrapper", "listenerWrapper", "", "addDownloadListener", "removeDownloadListener", "Lpb3/a;", "addManagerListener", "removeManagerListener", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaDownloadParams;", "downloadParams", "startDownload", "", "id", "pause", "", "getDownloadingCount", "getCurrentDownloadCount", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "callback", "getZootopiaResInfo", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadReq;", "param", "Lqb3/b;", "", "skipLog", "downloadResByPath", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface ICommonDownloadHelper extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(ICommonDownloadHelper iCommonDownloadHelper, ZPlanResDownloadReq zPlanResDownloadReq, b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    bVar = null;
                }
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                iCommonDownloadHelper.downloadResByPath(zPlanResDownloadReq, bVar, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadResByPath");
        }
    }

    void addDownloadListener(@NotNull c listenerWrapper);

    void addManagerListener(@NotNull pb3.a listener);

    @NotNull
    c createCommonDownloadListenerWrapper(@NotNull bh3.b listener);

    void downloadResByPath(@NotNull ZPlanResDownloadReq param, @Nullable b listener, boolean skipLog);

    int getCurrentDownloadCount();

    int getDownloadingCount();

    void getZootopiaResInfo(@NotNull String id5, @NotNull Function1<? super ZootopiaResData, Unit> callback);

    void pause(@NotNull String id5);

    void removeDownloadListener(@NotNull c listenerWrapper);

    void removeManagerListener(@NotNull pb3.a listener);

    void startDownload(@NotNull ZootopiaDownloadParams downloadParams);
}
