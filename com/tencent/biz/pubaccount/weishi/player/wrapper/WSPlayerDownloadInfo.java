package com.tencent.biz.pubaccount.weishi.player.wrapper;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\bX\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\"\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u001d\u0010\u000bR\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u000e\u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\"\u0010+\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0003\u001a\u0004\b)\u0010\t\"\u0004\b*\u0010\u000bR\"\u0010,\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0003\u001a\u0004\b\u0007\u0010\t\"\u0004\b\u000f\u0010\u000bR\"\u0010/\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u000f\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0013R\"\u00102\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u000f\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R\"\u00106\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u000f\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010\u0013R\"\u0010:\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u000f\u001a\u0004\b8\u0010\u0011\"\u0004\b9\u0010\u0013R\"\u0010>\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u000f\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0013R\"\u0010B\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u000f\u001a\u0004\b@\u0010\u0011\"\u0004\bA\u0010\u0013R\"\u0010F\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u000f\u001a\u0004\bD\u0010\u0011\"\u0004\bE\u0010\u0013R\"\u0010I\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010\u0003\u001a\u0004\b3\u0010\t\"\u0004\bH\u0010\u000bR\"\u0010K\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0003\u001a\u0004\bC\u0010\t\"\u0004\bJ\u0010\u000bR\"\u0010N\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u0003\u001a\u0004\b;\u0010\t\"\u0004\bM\u0010\u000bR\"\u0010P\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011\"\u0004\bO\u0010\u0013R\"\u0010R\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\u0003\u001a\u0004\b%\u0010\t\"\u0004\bQ\u0010\u000bR\"\u0010V\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010\u0003\u001a\u0004\bT\u0010\t\"\u0004\bU\u0010\u000bR\"\u0010Y\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0003\u001a\u0004\bW\u0010\t\"\u0004\bX\u0010\u000bR\"\u0010[\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010\u0003\u001a\u0004\bS\u0010\t\"\u0004\bZ\u0010\u000bR\"\u0010^\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010\u0003\u001a\u0004\b\u001c\u0010\t\"\u0004\b]\u0010\u000bR\"\u0010a\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010\u0003\u001a\u0004\bL\u0010\t\"\u0004\b`\u0010\u000bR\"\u0010e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010 \u001a\u0004\bc\u0010!\"\u0004\bd\u0010#R2\u0010l\u001a\u0012\u0012\u0004\u0012\u00020\u00060fj\b\u0012\u0004\u0012\u00020\u0006`g8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010h\u001a\u0004\b7\u0010i\"\u0004\bj\u0010kR2\u0010n\u001a\u0012\u0012\u0004\u0012\u00020\u00060fj\b\u0012\u0004\u0012\u00020\u0006`g8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010h\u001a\u0004\bG\u0010i\"\u0004\bm\u0010kR2\u0010p\u001a\u0012\u0012\u0004\u0012\u00020\u00060fj\b\u0012\u0004\u0012\u00020\u0006`g8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010h\u001a\u0004\b?\u0010i\"\u0004\bo\u0010kR\"\u0010s\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010\u0003\u001a\u0004\bq\u0010\t\"\u0004\br\u0010\u000bR\"\u0010y\u001a\u00020t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010`\u001a\u0004\bb\u0010v\"\u0004\bw\u0010xR\"\u0010{\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0003\u001a\u0004\b_\u0010\t\"\u0004\bz\u0010\u000bR\"\u0010}\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0003\u001a\u0004\b\\\u0010\t\"\u0004\b|\u0010\u000bR7\u0010\u0084\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00060~j\b\u0012\u0004\u0012\u00020\u0006`\u007f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0003\u0010\u0080\u0001\u001a\u0005\bu\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001\u00a8\u0006\u0087\u0001"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/player/wrapper/i;", "", "", "I", "", "toString", "", "a", "d", "()I", "M", "(I)V", "downloadSpeedKBps", "", "b", "J", "H", "()J", "n0", "(J)V", "totalSizeBytes", "c", "r", "Y", "localCacheSize", tl.h.F, BdhLogUtil.LogTag.Tag_Req, "hitDownloaded", "e", "L", "codeRate", "f", "Ljava/lang/String;", "()Ljava/lang/String;", "K", "(Ljava/lang/String;)V", "cdnIP", "g", "i", ExifInterface.LATITUDE_SOUTH, "httpAvgSpeedKB", "G", "m0", "totalDuration", "actualFileSize", "j", "T", "httpDownloadSize", "k", "U", "httpRepeatedSize", "l", "w", "d0", "pcdnDownloadSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "B", "i0", "pcdnRepeatedSize", DomainData.DOMAIN_NAME, "t", "a0", "p2pDownloadSize", "o", "u", "b0", "p2pRepeatedSize", "p", "D", "k0", "pcdnRequestSize", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "V", "lastHttpSpeed", "X", "lastPcdnSpeed", ReportConstant.COSTREPORT_PREFIX, "W", "lastP2PSpeed", "P", "globalP2PUploadBytes", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "globalP2PUploadSpeed", "v", BdhLogUtil.LogTag.Tag_Conn, "j0", "pcdnRequestCount", HippyTKDListViewAdapter.X, "e0", "pcdnDownloadSuccessCount", "c0", "pcdnDownloadFailCount", "y", "N", "enableP2P", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Z", "maxP2PUploadSpeed", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getFileId", "O", "fileId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setLastHttpSpeedList", "(Ljava/util/ArrayList;)V", "lastHttpSpeedList", "setLastPcdnSpeedList", "lastPcdnSpeedList", "setLastP2PSpeedList", "lastP2PSpeedList", "E", "l0", "pcdnStopReason", "", UserInfo.SEX_FEMALE, "()Z", "h0", "(Z)V", "pcdnIsError", "g0", "pcdnErrorSize", "f0", "pcdnErrorCount", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "()Ljava/util/HashSet;", "setPcdnStopReasonSet", "(Ljava/util/HashSet;)V", "pcdnStopReasonSet", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.pubaccount.weishi.player.wrapper.i, reason: from toString */
/* loaded from: classes32.dex */
public final class WSPlayerDownloadInfo {

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private int pcdnStopReason;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private boolean pcdnIsError;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private int pcdnErrorSize;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    private int pcdnErrorCount;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int downloadSpeedKBps;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long totalSizeBytes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long localCacheSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int hitDownloaded;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int codeRate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int httpAvgSpeedKB;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int totalDuration;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int actualFileSize;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private long httpDownloadSize;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private long httpRepeatedSize;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private long pcdnDownloadSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private long pcdnRepeatedSize;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private long p2pDownloadSize;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private long p2pRepeatedSize;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private long pcdnRequestSize;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private int lastHttpSpeed;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private int lastPcdnSpeed;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private int lastP2PSpeed;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private long globalP2PUploadBytes;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    private int globalP2PUploadSpeed;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    private int pcdnRequestCount;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    private int pcdnDownloadSuccessCount;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    private int pcdnDownloadFailCount;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata and from toString */
    private int enableP2P;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata and from toString */
    private int maxP2PUploadSpeed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String cdnIP = "";

    /* renamed from: A, reason: from kotlin metadata and from toString */
    private String fileId = "";

    /* renamed from: B, reason: from kotlin metadata */
    private ArrayList<Integer> lastHttpSpeedList = new ArrayList<>();

    /* renamed from: C, reason: from kotlin metadata */
    private ArrayList<Integer> lastPcdnSpeedList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    private ArrayList<Integer> lastP2PSpeedList = new ArrayList<>();

    /* renamed from: I, reason: from kotlin metadata */
    private HashSet<Integer> pcdnStopReasonSet = new HashSet<>();

    /* renamed from: A, reason: from getter */
    public final boolean getPcdnIsError() {
        return this.pcdnIsError;
    }

    /* renamed from: B, reason: from getter */
    public final long getPcdnRepeatedSize() {
        return this.pcdnRepeatedSize;
    }

    /* renamed from: C, reason: from getter */
    public final int getPcdnRequestCount() {
        return this.pcdnRequestCount;
    }

    /* renamed from: D, reason: from getter */
    public final long getPcdnRequestSize() {
        return this.pcdnRequestSize;
    }

    /* renamed from: E, reason: from getter */
    public final int getPcdnStopReason() {
        return this.pcdnStopReason;
    }

    public final HashSet<Integer> F() {
        return this.pcdnStopReasonSet;
    }

    /* renamed from: G, reason: from getter */
    public final int getTotalDuration() {
        return this.totalDuration;
    }

    /* renamed from: H, reason: from getter */
    public final long getTotalSizeBytes() {
        return this.totalSizeBytes;
    }

    public final void J(int i3) {
        this.actualFileSize = i3;
    }

    public final void K(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cdnIP = str;
    }

    public final void L(int i3) {
        this.codeRate = i3;
    }

    public final void M(int i3) {
        this.downloadSpeedKBps = i3;
    }

    public final void N(int i3) {
        this.enableP2P = i3;
    }

    public final void O(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fileId = str;
    }

    public final void P(long j3) {
        this.globalP2PUploadBytes = j3;
    }

    public final void Q(int i3) {
        this.globalP2PUploadSpeed = i3;
    }

    public final void R(int i3) {
        this.hitDownloaded = i3;
    }

    public final void S(int i3) {
        this.httpAvgSpeedKB = i3;
    }

    public final void T(long j3) {
        this.httpDownloadSize = j3;
    }

    public final void U(long j3) {
        this.httpRepeatedSize = j3;
    }

    public final void V(int i3) {
        this.lastHttpSpeed = i3;
    }

    public final void W(int i3) {
        this.lastP2PSpeed = i3;
    }

    public final void X(int i3) {
        this.lastPcdnSpeed = i3;
    }

    public final void Y(long j3) {
        this.localCacheSize = j3;
    }

    public final void Z(int i3) {
        this.maxP2PUploadSpeed = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getActualFileSize() {
        return this.actualFileSize;
    }

    public final void a0(long j3) {
        this.p2pDownloadSize = j3;
    }

    /* renamed from: b, reason: from getter */
    public final String getCdnIP() {
        return this.cdnIP;
    }

    public final void b0(long j3) {
        this.p2pRepeatedSize = j3;
    }

    /* renamed from: c, reason: from getter */
    public final int getCodeRate() {
        return this.codeRate;
    }

    public final void c0(int i3) {
        this.pcdnDownloadFailCount = i3;
    }

    /* renamed from: d, reason: from getter */
    public final int getDownloadSpeedKBps() {
        return this.downloadSpeedKBps;
    }

    public final void d0(long j3) {
        this.pcdnDownloadSize = j3;
    }

    /* renamed from: e, reason: from getter */
    public final int getEnableP2P() {
        return this.enableP2P;
    }

    public final void e0(int i3) {
        this.pcdnDownloadSuccessCount = i3;
    }

    /* renamed from: f, reason: from getter */
    public final long getGlobalP2PUploadBytes() {
        return this.globalP2PUploadBytes;
    }

    public final void f0(int i3) {
        this.pcdnErrorCount = i3;
    }

    /* renamed from: g, reason: from getter */
    public final int getGlobalP2PUploadSpeed() {
        return this.globalP2PUploadSpeed;
    }

    public final void g0(int i3) {
        this.pcdnErrorSize = i3;
    }

    /* renamed from: h, reason: from getter */
    public final int getHitDownloaded() {
        return this.hitDownloaded;
    }

    public final void h0(boolean z16) {
        this.pcdnIsError = z16;
    }

    /* renamed from: i, reason: from getter */
    public final int getHttpAvgSpeedKB() {
        return this.httpAvgSpeedKB;
    }

    public final void i0(long j3) {
        this.pcdnRepeatedSize = j3;
    }

    /* renamed from: j, reason: from getter */
    public final long getHttpDownloadSize() {
        return this.httpDownloadSize;
    }

    public final void j0(int i3) {
        this.pcdnRequestCount = i3;
    }

    /* renamed from: k, reason: from getter */
    public final long getHttpRepeatedSize() {
        return this.httpRepeatedSize;
    }

    public final void k0(long j3) {
        this.pcdnRequestSize = j3;
    }

    /* renamed from: l, reason: from getter */
    public final int getLastHttpSpeed() {
        return this.lastHttpSpeed;
    }

    public final void l0(int i3) {
        this.pcdnStopReason = i3;
    }

    public final ArrayList<Integer> m() {
        return this.lastHttpSpeedList;
    }

    public final void m0(int i3) {
        this.totalDuration = i3;
    }

    /* renamed from: n, reason: from getter */
    public final int getLastP2PSpeed() {
        return this.lastP2PSpeed;
    }

    public final void n0(long j3) {
        this.totalSizeBytes = j3;
    }

    public final ArrayList<Integer> o() {
        return this.lastP2PSpeedList;
    }

    /* renamed from: p, reason: from getter */
    public final int getLastPcdnSpeed() {
        return this.lastPcdnSpeed;
    }

    public final ArrayList<Integer> q() {
        return this.lastPcdnSpeedList;
    }

    /* renamed from: r, reason: from getter */
    public final long getLocalCacheSize() {
        return this.localCacheSize;
    }

    /* renamed from: s, reason: from getter */
    public final int getMaxP2PUploadSpeed() {
        return this.maxP2PUploadSpeed;
    }

    /* renamed from: t, reason: from getter */
    public final long getP2pDownloadSize() {
        return this.p2pDownloadSize;
    }

    /* renamed from: u, reason: from getter */
    public final long getP2pRepeatedSize() {
        return this.p2pRepeatedSize;
    }

    /* renamed from: v, reason: from getter */
    public final int getPcdnDownloadFailCount() {
        return this.pcdnDownloadFailCount;
    }

    /* renamed from: w, reason: from getter */
    public final long getPcdnDownloadSize() {
        return this.pcdnDownloadSize;
    }

    /* renamed from: x, reason: from getter */
    public final int getPcdnDownloadSuccessCount() {
        return this.pcdnDownloadSuccessCount;
    }

    /* renamed from: y, reason: from getter */
    public final int getPcdnErrorCount() {
        return this.pcdnErrorCount;
    }

    /* renamed from: z, reason: from getter */
    public final int getPcdnErrorSize() {
        return this.pcdnErrorSize;
    }

    public final void I() {
        this.downloadSpeedKBps = 0;
        this.totalSizeBytes = 0L;
        this.localCacheSize = 0L;
        this.hitDownloaded = 0;
        this.codeRate = 0;
        this.cdnIP = "";
        this.httpAvgSpeedKB = 0;
        this.totalDuration = 0;
        this.actualFileSize = 0;
        this.httpDownloadSize = 0L;
        this.httpRepeatedSize = 0L;
        this.pcdnDownloadSize = 0L;
        this.pcdnRepeatedSize = 0L;
        this.p2pDownloadSize = 0L;
        this.p2pRepeatedSize = 0L;
        this.pcdnRequestSize = 0L;
        this.lastHttpSpeed = 0;
        this.lastPcdnSpeed = 0;
        this.lastP2PSpeed = 0;
        this.globalP2PUploadBytes = 0L;
        this.globalP2PUploadSpeed = 0;
        this.pcdnRequestCount = 0;
        this.pcdnDownloadSuccessCount = 0;
        this.pcdnDownloadFailCount = 0;
        this.enableP2P = 0;
        this.maxP2PUploadSpeed = 0;
        this.fileId = "";
        this.lastHttpSpeedList.clear();
        this.lastPcdnSpeedList.clear();
        this.lastP2PSpeedList.clear();
        this.pcdnStopReason = 0;
        this.pcdnIsError = false;
        this.pcdnErrorSize = 0;
        this.pcdnErrorCount = 0;
        this.pcdnStopReasonSet.clear();
    }

    public String toString() {
        return "WSPlayerDownloadInfo(downloadSpeedKBps=" + this.downloadSpeedKBps + ", totalSizeBytes=" + this.totalSizeBytes + ", localCacheSize=" + this.localCacheSize + ", hitDownloaded=" + this.hitDownloaded + ", codeRate=" + this.codeRate + ", cdnIP='" + this.cdnIP + "', httpAvgSpeedKB=" + this.httpAvgSpeedKB + ", totalDuration=" + this.totalDuration + ", actualFileSize=" + this.actualFileSize + ", httpDownloadSize=" + this.httpDownloadSize + ", httpRepeatedSize=" + this.httpRepeatedSize + ", pcdnDownloadSize=" + this.pcdnDownloadSize + ", pcdnRepeatedSize=" + this.pcdnRepeatedSize + ", p2pDownloadSize=" + this.p2pDownloadSize + ", p2pRepeatedSize=" + this.p2pRepeatedSize + ", pcdnRequestSize=" + this.pcdnRequestSize + ", lastHttpSpeed=" + this.lastHttpSpeed + ", lastPcdnSpeed=" + this.lastPcdnSpeed + ", lastP2PSpeed=" + this.lastP2PSpeed + ", globalP2PUploadBytes=" + this.globalP2PUploadBytes + ", globalP2PUploadSpeed=" + this.globalP2PUploadSpeed + ", pcdnRequestCount=" + this.pcdnRequestCount + ", pcdnDownloadSuccessCount=" + this.pcdnDownloadSuccessCount + ", pcdnDownloadFailCount=" + this.pcdnDownloadFailCount + ", enableP2P=" + this.enableP2P + ", maxP2PUploadSpeed=" + this.maxP2PUploadSpeed + ", fileId='" + this.fileId + "', pcdnErrorSize=" + this.pcdnErrorSize + ", pcdnIsError=" + this.pcdnIsError + ", pcdnStopReason=" + this.pcdnStopReason + ", pcdnErrorCount=" + this.pcdnErrorCount + ")";
    }
}
