package com.tencent.biz.pubaccount.weishi.player.wrapper;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005R0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/player/wrapper/j;", "", "", "videoFileId", "b", "Lcom/tencent/biz/pubaccount/weishi/player/wrapper/i;", "a", "", "e", "info", "f", "targetInfo", "srcInfo", "c", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "preLoaderInfoMap", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f81226a = new j();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, WSPlayerDownloadInfo> preLoaderInfoMap = new HashMap<>();

    j() {
    }

    public final WSPlayerDownloadInfo a(String videoFileId) {
        Intrinsics.checkNotNullParameter(videoFileId, "videoFileId");
        HashMap<String, WSPlayerDownloadInfo> hashMap = preLoaderInfoMap;
        WSPlayerDownloadInfo wSPlayerDownloadInfo = hashMap.get(videoFileId);
        if (wSPlayerDownloadInfo != null) {
            return wSPlayerDownloadInfo;
        }
        WSPlayerDownloadInfo wSPlayerDownloadInfo2 = new WSPlayerDownloadInfo();
        hashMap.put(videoFileId, wSPlayerDownloadInfo2);
        return wSPlayerDownloadInfo2;
    }

    public final String b(String videoFileId) {
        Intrinsics.checkNotNullParameter(videoFileId, "videoFileId");
        return f(a(videoFileId));
    }

    public final void c(WSPlayerDownloadInfo targetInfo, WSPlayerDownloadInfo srcInfo) {
        Intrinsics.checkNotNullParameter(targetInfo, "targetInfo");
        Intrinsics.checkNotNullParameter(srcInfo, "srcInfo");
        targetInfo.M(Math.max(targetInfo.getDownloadSpeedKBps(), srcInfo.getDownloadSpeedKBps()));
        targetInfo.n0(Math.max(targetInfo.getTotalSizeBytes(), srcInfo.getTotalSizeBytes()));
        targetInfo.Y(Math.max(targetInfo.getLocalCacheSize(), srcInfo.getLocalCacheSize()));
        targetInfo.R(srcInfo.getHitDownloaded());
        targetInfo.L(srcInfo.getCodeRate());
        targetInfo.K(srcInfo.getCdnIP());
        targetInfo.S(srcInfo.getHttpAvgSpeedKB());
        targetInfo.m0(srcInfo.getTotalDuration());
        targetInfo.J(srcInfo.getActualFileSize());
        targetInfo.T(Math.max(targetInfo.getHttpDownloadSize(), srcInfo.getHttpDownloadSize()));
        targetInfo.U(Math.max(targetInfo.getHttpRepeatedSize(), srcInfo.getHttpRepeatedSize()));
        targetInfo.d0(Math.max(targetInfo.getPcdnDownloadSize(), srcInfo.getPcdnDownloadSize()));
        targetInfo.i0(Math.max(targetInfo.getPcdnRepeatedSize(), srcInfo.getPcdnRepeatedSize()));
        targetInfo.a0(Math.max(targetInfo.getP2pDownloadSize(), srcInfo.getP2pDownloadSize()));
        targetInfo.b0(Math.max(targetInfo.getP2pRepeatedSize(), srcInfo.getP2pRepeatedSize()));
        targetInfo.k0(Math.max(targetInfo.getPcdnRequestSize(), srcInfo.getPcdnRequestSize()));
        if (srcInfo.getLastHttpSpeed() > 0) {
            targetInfo.m().add(Integer.valueOf(srcInfo.getLastHttpSpeed()));
        }
        if (srcInfo.getLastPcdnSpeed() > 0) {
            targetInfo.q().add(Integer.valueOf(srcInfo.getLastPcdnSpeed()));
        }
        if (srcInfo.getLastP2PSpeed() > 0) {
            targetInfo.o().add(Integer.valueOf(srcInfo.getLastP2PSpeed()));
        }
        targetInfo.P(Math.max(targetInfo.getGlobalP2PUploadBytes(), srcInfo.getGlobalP2PUploadBytes()));
        targetInfo.Q(Math.max(targetInfo.getGlobalP2PUploadSpeed(), srcInfo.getGlobalP2PUploadSpeed()));
        targetInfo.j0(Math.max(targetInfo.getPcdnRequestCount(), srcInfo.getPcdnRequestCount()));
        targetInfo.e0(Math.max(targetInfo.getPcdnDownloadSuccessCount(), srcInfo.getPcdnDownloadSuccessCount()));
        targetInfo.c0(Math.max(targetInfo.getPcdnDownloadFailCount(), srcInfo.getPcdnDownloadFailCount()));
        targetInfo.N(srcInfo.getEnableP2P());
        targetInfo.Z(Math.max(targetInfo.getMaxP2PUploadSpeed(), srcInfo.getMaxP2PUploadSpeed()));
    }

    public final void d(WSPlayerDownloadInfo targetInfo, WSPlayerDownloadInfo srcInfo) {
        Intrinsics.checkNotNullParameter(targetInfo, "targetInfo");
        Intrinsics.checkNotNullParameter(srcInfo, "srcInfo");
        if (srcInfo.getPcdnErrorSize() > 0) {
            targetInfo.F().add(Integer.valueOf(srcInfo.getPcdnStopReason()));
            if (srcInfo.getPcdnIsError()) {
                targetInfo.g0(targetInfo.getPcdnErrorSize() + srcInfo.getPcdnErrorSize());
                targetInfo.f0(targetInfo.getPcdnErrorCount() + 1);
            }
        }
    }

    public final void e(String videoFileId) {
        Intrinsics.checkNotNullParameter(videoFileId, "videoFileId");
        preLoaderInfoMap.remove(videoFileId);
    }

    public final String f(WSPlayerDownloadInfo info) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(info, "info");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("http_download_size", Long.valueOf(info.getHttpDownloadSize())), TuplesKt.to("http_repeated_size", Long.valueOf(info.getHttpRepeatedSize())), TuplesKt.to("pcdn_download_size", Long.valueOf(info.getPcdnDownloadSize())), TuplesKt.to("pcdn_repeated_size", Long.valueOf(info.getPcdnRepeatedSize())), TuplesKt.to("p2p_download_size", Long.valueOf(info.getP2pDownloadSize())), TuplesKt.to("p2p_repeated_size", Long.valueOf(info.getP2pRepeatedSize())), TuplesKt.to("avg_http_speed", Integer.valueOf(com.tencent.biz.pubaccount.weishi.player.i.d(info.m()))), TuplesKt.to("avg_pcdn_speed", Integer.valueOf(com.tencent.biz.pubaccount.weishi.player.i.d(info.q()))), TuplesKt.to("avg_p2p_speed", Integer.valueOf(com.tencent.biz.pubaccount.weishi.player.i.d(info.o()))), TuplesKt.to("pcdn_request_count", Integer.valueOf(info.getPcdnRequestCount())), TuplesKt.to("pcdn_download_success_count", Integer.valueOf(info.getPcdnDownloadSuccessCount())), TuplesKt.to("pcdn_download_fail_count", Integer.valueOf(info.getPcdnDownloadFailCount())), TuplesKt.to("pcdn_request_size", Long.valueOf(info.getPcdnRequestSize())), TuplesKt.to("enable_p2p", Integer.valueOf(info.getEnableP2P())), TuplesKt.to("cdn_ip", info.getCdnIP()), TuplesKt.to("pcdn_error_size", Integer.valueOf(info.getPcdnErrorSize())), TuplesKt.to("pcdn_error_count", Integer.valueOf(info.getPcdnErrorCount())), TuplesKt.to("pcdn_stop_reason", com.tencent.biz.pubaccount.weishi.player.i.J(info.F())));
        String jSONObject = new JSONObject(mapOf).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(map).toString()");
        return jSONObject;
    }
}
