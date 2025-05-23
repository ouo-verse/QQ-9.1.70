package com.tencent.sqshow.zootopia.data;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 ~2\u00020\u0001:\u0001\nB\u00ed\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040$\u0012\u0006\u0010*\u001a\u00020\u0004\u0012\u0006\u0010,\u001a\u00020\u0006\u0012\u0006\u00102\u001a\u00020-\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u00109\u001a\u000207\u0012\u0006\u0010<\u001a\u00020\u0006\u0012\u0006\u0010>\u001a\u00020\u0006\u0012\u0006\u0010A\u001a\u000203\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040$\u0012\u0006\u0010E\u001a\u00020\u0006\u0012\u0006\u0010H\u001a\u000203\u0012\u0006\u0010J\u001a\u000203\u0012\b\u0010P\u001a\u0004\u0018\u00010K\u0012\f\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0$\u0012\u0006\u0010T\u001a\u00020\u0006\u0012\u0006\u0010X\u001a\u00020\u0002\u0012\u0006\u0010Z\u001a\u00020\u0006\u0012\u0006\u0010\\\u001a\u00020\u0006\u0012\u0006\u0010]\u001a\u00020\u0004\u0012\u0006\u0010_\u001a\u00020\u0004\u0012\u0006\u0010`\u001a\u00020\u0004\u0012\u0006\u0010b\u001a\u00020\u0004\u0012\b\b\u0002\u0010c\u001a\u00020\u0002\u0012\f\u0010e\u001a\b\u0012\u0004\u0012\u00020d0$\u0012\b\u0010i\u001a\u0004\u0018\u00010f\u0012\b\u0010j\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010k\u0012\b\b\u0002\u0010q\u001a\u00020\u0006\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010r\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010w\u00a2\u0006\u0004\b|\u0010}J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u0017\u0010\u001f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010*\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u0017\u0010,\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u00102\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00106\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b\u000b\u00105R\u0017\u00109\u001a\u0002078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b4\u00108R\u0017\u0010<\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u0017\u0010>\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b=\u0010\rR\u0017\u0010A\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b?\u00104\u001a\u0004\b@\u00105R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0006\u00a2\u0006\f\n\u0004\bB\u0010%\u001a\u0004\b:\u0010'R\u0017\u0010E\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\bD\u0010\u000b\u001a\u0004\b.\u0010\rR\u0017\u0010H\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\bF\u00104\u001a\u0004\bG\u00105R\u0017\u0010J\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\bI\u00105R\u0019\u0010P\u001a\u0004\u0018\u00010K8\u0006\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0$8\u0006\u00a2\u0006\f\n\u0004\b;\u0010%\u001a\u0004\b \u0010'R\u0017\u0010T\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u000b\u001a\u0004\bS\u0010\rR\u0017\u0010X\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b@\u0010U\u001a\u0004\bV\u0010WR\u0017\u0010Z\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\bY\u0010\u000b\u001a\u0004\bY\u0010\rR\u0017\u0010\\\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b[\u0010\u000b\u001a\u0004\bL\u0010\rR\u0017\u0010]\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\bS\u0010\u0010\u001a\u0004\bB\u0010\u0012R\u0017\u0010_\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\bV\u0010\u0010\u001a\u0004\b^\u0010\u0012R\u0017\u0010`\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\n\u0010\u0012R\u0017\u0010b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b^\u0010\u0010\u001a\u0004\ba\u0010\u0012R\u0017\u0010c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010U\u001a\u0004\b+\u0010WR\u001d\u0010e\u001a\b\u0012\u0004\u0012\u00020d0$8\u0006\u00a2\u0006\f\n\u0004\bN\u0010%\u001a\u0004\bF\u0010'R\u0019\u0010i\u001a\u0004\u0018\u00010f8\u0006\u00a2\u0006\f\n\u0004\ba\u0010g\u001a\u0004\b[\u0010hR\u0019\u0010j\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R$\u0010p\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010l\u001a\u0004\b\u001d\u0010m\"\u0004\bn\u0010oR\u0017\u0010q\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\bD\u0010\rR\u0019\u0010v\u001a\u0004\u0018\u00010r8\u0006\u00a2\u0006\f\n\u0004\bs\u0010t\u001a\u0004\b?\u0010uR\u0019\u0010{\u001a\u0004\u0018\u00010w8\u0006\u00a2\u0006\f\n\u0004\bx\u0010y\u001a\u0004\b)\u0010z\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/m;", "", "", "K", "", "toString", "", "hashCode", "other", "equals", "a", "I", DomainData.DOMAIN_NAME, "()I", "id", "b", "Ljava/lang/String;", "D", "()Ljava/lang/String;", "title", "c", tl.h.F, "desc", "d", "i", "descDetail", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "icon", "f", "u", "mapType", "g", UserInfo.SEX_FEMALE, "typeText", "buttonText", "", "Ljava/util/List;", "p", "()Ljava/util/List;", "labels", "j", "background", "k", "bgType", "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "l", "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "modVersionSimpleData", "", "J", "()J", "visitorCount", "", "()F", "visitorWeight", "o", "w", "memberCount", "getShowOrder", "showOrder", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", "onlineDuration", "r", "imageList", ReportConstant.COSTREPORT_PREFIX, "galleryType", "t", "getStartTime", "startTime", "getEndTime", "endTime", "Lcom/tencent/sqshow/zootopia/data/ab;", "v", "Lcom/tencent/sqshow/zootopia/data/ab;", "G", "()Lcom/tencent/sqshow/zootopia/data/ab;", "versionUpdate", "Lcom/tencent/sqshow/zootopia/data/l;", "comments", "B", "sceneType", "Z", BdhLogUtil.LogTag.Tag_Conn, "()Z", "showGameHealthyLoading", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qqVersionTipsCode", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mapVersionTipsCode", "mapProjName", "E", "typeIcon", "backColor", "H", AppConstants.Key.KEY_QZONE_VIDEO_URL, "fromSimpleData", "Lcom/tencent/sqshow/zootopia/data/n;", "mapTabList", "Lpv4/j;", "Lpv4/j;", "()Lpv4/j;", "reserveItem", "beforeOnlineToast", "Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "()Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "setCloudGameInfo", "(Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;)V", "cloudGameInfo", "mapStatus", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "L", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "loadingParams", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "M", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "()Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "diffPatchInfo", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;JFIIJLjava/util/List;IJJLcom/tencent/sqshow/zootopia/data/ab;Ljava/util/List;IZIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Lpv4/j;Ljava/lang/String;Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;ILcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;)V", "N", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.m, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaMapDetail {

    /* renamed from: N, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata and from toString */
    private final int mapVersionTipsCode;

    /* renamed from: B, reason: from kotlin metadata and from toString */
    private final String mapProjName;

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private final String typeIcon;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private final String backColor;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private final String videoUrl;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private final boolean fromSimpleData;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private final List<ZootopiaMapTab> mapTabList;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    private final pv4.j reserveItem;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    private final String beforeOnlineToast;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    private ZPlanCloudGameInfo cloudGameInfo;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    private final int mapStatus;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    private final ZootopiaMapLoadingParams loadingParams;

    /* renamed from: M, reason: from kotlin metadata and from toString */
    private final ZPlanMapDiffPatchInfo diffPatchInfo;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String desc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String descDetail;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String icon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int mapType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final String typeText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final String buttonText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> labels;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final String background;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final int bgType;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanModVersionSimpleData modVersionSimpleData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final long visitorCount;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private final float visitorWeight;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private final int memberCount;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private final int showOrder;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private final long onlineDuration;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> imageList;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private final int galleryType;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private final long startTime;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    private final long endTime;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaVersionUpdateInfo versionUpdate;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ZootopiaMapComment> comments;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sceneType;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean showGameHealthyLoading;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata and from toString */
    private final int qqVersionTipsCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/m$a;", "", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "info", "Lcom/tencent/sqshow/zootopia/data/m;", "a", "", "TYPE_GAME", "I", "TYPE_WORLD", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.m$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaMapDetail a(ZootopiaMapSimpleInfo info) {
            List emptyList;
            List emptyList2;
            List emptyList3;
            Intrinsics.checkNotNullParameter(info, "info");
            int mapID = info.getMapID();
            int type = info.getType();
            String typeName = info.getTypeName();
            String name = info.getName();
            String desc = info.getDesc();
            String desc2 = info.getDesc();
            String background = info.getBackground();
            int backgroundType = info.getBackgroundType();
            ArrayList<String> labels = info.getLabels();
            String button = info.getButton();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            String barPic = info.getBarPic();
            int sceneType = info.getSceneType();
            boolean showGameHealthyLoading = info.getShowGameHealthyLoading();
            ZPlanModVersionSimpleData modVersionSimpleData = info.getSimpleVerInfo().getModVersionSimpleData();
            int qqVerTip = info.getSimpleVerInfo().getQqVerTip();
            int mapVerTip = info.getSimpleVerInfo().getMapVerTip();
            String mapProjName = info.getMapProjName();
            String typeIcon = info.getTypeIcon();
            String backColor = info.getBackColor();
            String videoUrl = info.getVideoUrl();
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            return new ZootopiaMapDetail(mapID, name, desc, desc2, barPic, type, typeName, button, labels, background, backgroundType, modVersionSimpleData, 0L, 0.0f, 0, 0, 0L, emptyList, 0, 0L, 0L, null, emptyList2, sceneType, showGameHealthyLoading, qqVerTip, mapVerTip, mapProjName, typeIcon, backColor, videoUrl, true, emptyList3, info.getReserveItem(), info.getBeforeOnlineToast(), info.getSimpleVerInfo().getCloudGameInfo(), 0, info.getLoadingParams(), info.getSimpleVerInfo().getDiffPatchInfo(), 0, 16, null);
        }

        Companion() {
        }
    }

    public ZootopiaMapDetail(int i3, String title, String desc, String descDetail, String icon, int i16, String typeText, String buttonText, List<String> labels, String background, int i17, ZPlanModVersionSimpleData modVersionSimpleData, long j3, float f16, int i18, int i19, long j16, List<String> imageList, int i26, long j17, long j18, ZootopiaVersionUpdateInfo zootopiaVersionUpdateInfo, List<ZootopiaMapComment> comments, int i27, boolean z16, int i28, int i29, String mapProjName, String typeIcon, String backColor, String videoUrl, boolean z17, List<ZootopiaMapTab> mapTabList, pv4.j jVar, String str, ZPlanCloudGameInfo zPlanCloudGameInfo, int i36, ZootopiaMapLoadingParams zootopiaMapLoadingParams, ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(descDetail, "descDetail");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(typeText, "typeText");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(labels, "labels");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(modVersionSimpleData, "modVersionSimpleData");
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        Intrinsics.checkNotNullParameter(comments, "comments");
        Intrinsics.checkNotNullParameter(mapProjName, "mapProjName");
        Intrinsics.checkNotNullParameter(typeIcon, "typeIcon");
        Intrinsics.checkNotNullParameter(backColor, "backColor");
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        Intrinsics.checkNotNullParameter(mapTabList, "mapTabList");
        this.id = i3;
        this.title = title;
        this.desc = desc;
        this.descDetail = descDetail;
        this.icon = icon;
        this.mapType = i16;
        this.typeText = typeText;
        this.buttonText = buttonText;
        this.labels = labels;
        this.background = background;
        this.bgType = i17;
        this.modVersionSimpleData = modVersionSimpleData;
        this.visitorCount = j3;
        this.visitorWeight = f16;
        this.memberCount = i18;
        this.showOrder = i19;
        this.onlineDuration = j16;
        this.imageList = imageList;
        this.galleryType = i26;
        this.startTime = j17;
        this.endTime = j18;
        this.versionUpdate = zootopiaVersionUpdateInfo;
        this.comments = comments;
        this.sceneType = i27;
        this.showGameHealthyLoading = z16;
        this.qqVersionTipsCode = i28;
        this.mapVersionTipsCode = i29;
        this.mapProjName = mapProjName;
        this.typeIcon = typeIcon;
        this.backColor = backColor;
        this.videoUrl = videoUrl;
        this.fromSimpleData = z17;
        this.mapTabList = mapTabList;
        this.reserveItem = jVar;
        this.beforeOnlineToast = str;
        this.cloudGameInfo = zPlanCloudGameInfo;
        this.mapStatus = i36;
        this.loadingParams = zootopiaMapLoadingParams;
        this.diffPatchInfo = zPlanMapDiffPatchInfo;
    }

    /* renamed from: A, reason: from getter */
    public final pv4.j getReserveItem() {
        return this.reserveItem;
    }

    /* renamed from: B, reason: from getter */
    public final int getSceneType() {
        return this.sceneType;
    }

    /* renamed from: C, reason: from getter */
    public final boolean getShowGameHealthyLoading() {
        return this.showGameHealthyLoading;
    }

    /* renamed from: D, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: E, reason: from getter */
    public final String getTypeIcon() {
        return this.typeIcon;
    }

    /* renamed from: F, reason: from getter */
    public final String getTypeText() {
        return this.typeText;
    }

    /* renamed from: G, reason: from getter */
    public final ZootopiaVersionUpdateInfo getVersionUpdate() {
        return this.versionUpdate;
    }

    /* renamed from: H, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* renamed from: I, reason: from getter */
    public final long getVisitorCount() {
        return this.visitorCount;
    }

    /* renamed from: J, reason: from getter */
    public final float getVisitorWeight() {
        return this.visitorWeight;
    }

    public final boolean K() {
        return this.mapType == 2;
    }

    /* renamed from: a, reason: from getter */
    public final String getBackColor() {
        return this.backColor;
    }

    /* renamed from: b, reason: from getter */
    public final String getBackground() {
        return this.background;
    }

    /* renamed from: c, reason: from getter */
    public final String getBeforeOnlineToast() {
        return this.beforeOnlineToast;
    }

    /* renamed from: d, reason: from getter */
    public final int getBgType() {
        return this.bgType;
    }

    /* renamed from: e, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    /* renamed from: f, reason: from getter */
    public final ZPlanCloudGameInfo getCloudGameInfo() {
        return this.cloudGameInfo;
    }

    public final List<ZootopiaMapComment> g() {
        return this.comments;
    }

    /* renamed from: h, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((((((this.id * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.descDetail.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.mapType) * 31) + this.typeText.hashCode()) * 31) + this.buttonText.hashCode()) * 31) + this.labels.hashCode()) * 31) + this.background.hashCode()) * 31) + this.bgType) * 31) + this.modVersionSimpleData.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.visitorCount)) * 31) + Float.floatToIntBits(this.visitorWeight)) * 31) + this.memberCount) * 31) + this.showOrder) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.onlineDuration)) * 31) + this.imageList.hashCode()) * 31) + this.galleryType) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.startTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.endTime)) * 31;
        ZootopiaVersionUpdateInfo zootopiaVersionUpdateInfo = this.versionUpdate;
        int hashCode2 = (((((hashCode + (zootopiaVersionUpdateInfo == null ? 0 : zootopiaVersionUpdateInfo.hashCode())) * 31) + this.comments.hashCode()) * 31) + this.sceneType) * 31;
        boolean z16 = this.showGameHealthyLoading;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode3 = (((((((((((((hashCode2 + i3) * 31) + this.qqVersionTipsCode) * 31) + this.mapVersionTipsCode) * 31) + this.mapProjName.hashCode()) * 31) + this.typeIcon.hashCode()) * 31) + this.backColor.hashCode()) * 31) + this.videoUrl.hashCode()) * 31;
        boolean z17 = this.fromSimpleData;
        int hashCode4 = (((hashCode3 + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.mapTabList.hashCode()) * 31;
        pv4.j jVar = this.reserveItem;
        int hashCode5 = (hashCode4 + (jVar == null ? 0 : jVar.hashCode())) * 31;
        String str = this.beforeOnlineToast;
        int hashCode6 = (hashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        ZPlanCloudGameInfo zPlanCloudGameInfo = this.cloudGameInfo;
        int hashCode7 = (((hashCode6 + (zPlanCloudGameInfo == null ? 0 : zPlanCloudGameInfo.hashCode())) * 31) + this.mapStatus) * 31;
        ZootopiaMapLoadingParams zootopiaMapLoadingParams = this.loadingParams;
        int hashCode8 = (hashCode7 + (zootopiaMapLoadingParams == null ? 0 : zootopiaMapLoadingParams.hashCode())) * 31;
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo = this.diffPatchInfo;
        return hashCode8 + (zPlanMapDiffPatchInfo != null ? zPlanMapDiffPatchInfo.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getDescDetail() {
        return this.descDetail;
    }

    /* renamed from: j, reason: from getter */
    public final ZPlanMapDiffPatchInfo getDiffPatchInfo() {
        return this.diffPatchInfo;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getFromSimpleData() {
        return this.fromSimpleData;
    }

    /* renamed from: l, reason: from getter */
    public final int getGalleryType() {
        return this.galleryType;
    }

    /* renamed from: m, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: n, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final List<String> o() {
        return this.imageList;
    }

    public final List<String> p() {
        return this.labels;
    }

    /* renamed from: q, reason: from getter */
    public final ZootopiaMapLoadingParams getLoadingParams() {
        return this.loadingParams;
    }

    /* renamed from: r, reason: from getter */
    public final String getMapProjName() {
        return this.mapProjName;
    }

    /* renamed from: s, reason: from getter */
    public final int getMapStatus() {
        return this.mapStatus;
    }

    public final List<ZootopiaMapTab> t() {
        return this.mapTabList;
    }

    /* renamed from: u, reason: from getter */
    public final int getMapType() {
        return this.mapType;
    }

    /* renamed from: v, reason: from getter */
    public final int getMapVersionTipsCode() {
        return this.mapVersionTipsCode;
    }

    /* renamed from: w, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    /* renamed from: x, reason: from getter */
    public final ZPlanModVersionSimpleData getModVersionSimpleData() {
        return this.modVersionSimpleData;
    }

    /* renamed from: y, reason: from getter */
    public final long getOnlineDuration() {
        return this.onlineDuration;
    }

    /* renamed from: z, reason: from getter */
    public final int getQqVersionTipsCode() {
        return this.qqVersionTipsCode;
    }

    public String toString() {
        return "ZootopiaMapDetail(id=" + this.id + ", title=" + this.title + ", desc=" + this.desc + ", descDetail=" + this.descDetail + ", icon=" + this.icon + ", mapType=" + this.mapType + ", typeText=" + this.typeText + ", buttonText=" + this.buttonText + ", labels=" + this.labels + ", background=" + this.background + ", bgType=" + this.bgType + ", modVersionSimpleData=" + this.modVersionSimpleData + ", visitorCount=" + this.visitorCount + ", visitorWeight=" + this.visitorWeight + ", memberCount=" + this.memberCount + ", showOrder=" + this.showOrder + ", onlineDuration=" + this.onlineDuration + ", imageList=" + this.imageList + ", galleryType=" + this.galleryType + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", versionUpdate=" + this.versionUpdate + ", comments=" + this.comments + ", sceneType=" + this.sceneType + ", showGameHealthyLoading=" + this.showGameHealthyLoading + ", qqVersionTipsCode=" + this.qqVersionTipsCode + ", mapVersionTipsCode=" + this.mapVersionTipsCode + ", mapProjName=" + this.mapProjName + ", typeIcon=" + this.typeIcon + ", backColor=" + this.backColor + ", videoUrl=" + this.videoUrl + ", fromSimpleData=" + this.fromSimpleData + ", mapTabList=" + this.mapTabList + ", reserveItem=" + this.reserveItem + ", beforeOnlineToast=" + this.beforeOnlineToast + ", cloudGameInfo=" + this.cloudGameInfo + ", mapStatus=" + this.mapStatus + ", loadingParams=" + this.loadingParams + ", diffPatchInfo=" + this.diffPatchInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaMapDetail)) {
            return false;
        }
        ZootopiaMapDetail zootopiaMapDetail = (ZootopiaMapDetail) other;
        return this.id == zootopiaMapDetail.id && Intrinsics.areEqual(this.title, zootopiaMapDetail.title) && Intrinsics.areEqual(this.desc, zootopiaMapDetail.desc) && Intrinsics.areEqual(this.descDetail, zootopiaMapDetail.descDetail) && Intrinsics.areEqual(this.icon, zootopiaMapDetail.icon) && this.mapType == zootopiaMapDetail.mapType && Intrinsics.areEqual(this.typeText, zootopiaMapDetail.typeText) && Intrinsics.areEqual(this.buttonText, zootopiaMapDetail.buttonText) && Intrinsics.areEqual(this.labels, zootopiaMapDetail.labels) && Intrinsics.areEqual(this.background, zootopiaMapDetail.background) && this.bgType == zootopiaMapDetail.bgType && Intrinsics.areEqual(this.modVersionSimpleData, zootopiaMapDetail.modVersionSimpleData) && this.visitorCount == zootopiaMapDetail.visitorCount && Float.compare(this.visitorWeight, zootopiaMapDetail.visitorWeight) == 0 && this.memberCount == zootopiaMapDetail.memberCount && this.showOrder == zootopiaMapDetail.showOrder && this.onlineDuration == zootopiaMapDetail.onlineDuration && Intrinsics.areEqual(this.imageList, zootopiaMapDetail.imageList) && this.galleryType == zootopiaMapDetail.galleryType && this.startTime == zootopiaMapDetail.startTime && this.endTime == zootopiaMapDetail.endTime && Intrinsics.areEqual(this.versionUpdate, zootopiaMapDetail.versionUpdate) && Intrinsics.areEqual(this.comments, zootopiaMapDetail.comments) && this.sceneType == zootopiaMapDetail.sceneType && this.showGameHealthyLoading == zootopiaMapDetail.showGameHealthyLoading && this.qqVersionTipsCode == zootopiaMapDetail.qqVersionTipsCode && this.mapVersionTipsCode == zootopiaMapDetail.mapVersionTipsCode && Intrinsics.areEqual(this.mapProjName, zootopiaMapDetail.mapProjName) && Intrinsics.areEqual(this.typeIcon, zootopiaMapDetail.typeIcon) && Intrinsics.areEqual(this.backColor, zootopiaMapDetail.backColor) && Intrinsics.areEqual(this.videoUrl, zootopiaMapDetail.videoUrl) && this.fromSimpleData == zootopiaMapDetail.fromSimpleData && Intrinsics.areEqual(this.mapTabList, zootopiaMapDetail.mapTabList) && Intrinsics.areEqual(this.reserveItem, zootopiaMapDetail.reserveItem) && Intrinsics.areEqual(this.beforeOnlineToast, zootopiaMapDetail.beforeOnlineToast) && Intrinsics.areEqual(this.cloudGameInfo, zootopiaMapDetail.cloudGameInfo) && this.mapStatus == zootopiaMapDetail.mapStatus && Intrinsics.areEqual(this.loadingParams, zootopiaMapDetail.loadingParams) && Intrinsics.areEqual(this.diffPatchInfo, zootopiaMapDetail.diffPatchInfo);
    }

    public /* synthetic */ ZootopiaMapDetail(int i3, String str, String str2, String str3, String str4, int i16, String str5, String str6, List list, String str7, int i17, ZPlanModVersionSimpleData zPlanModVersionSimpleData, long j3, float f16, int i18, int i19, long j16, List list2, int i26, long j17, long j18, ZootopiaVersionUpdateInfo zootopiaVersionUpdateInfo, List list3, int i27, boolean z16, int i28, int i29, String str8, String str9, String str10, String str11, boolean z17, List list4, pv4.j jVar, String str12, ZPlanCloudGameInfo zPlanCloudGameInfo, int i36, ZootopiaMapLoadingParams zootopiaMapLoadingParams, ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo, int i37, int i38, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, str3, str4, i16, str5, str6, list, str7, i17, zPlanModVersionSimpleData, j3, f16, i18, i19, j16, list2, i26, j17, j18, zootopiaVersionUpdateInfo, list3, i27, z16, i28, i29, str8, str9, str10, str11, (i37 & Integer.MIN_VALUE) != 0 ? false : z17, list4, jVar, str12, (i38 & 8) != 0 ? null : zPlanCloudGameInfo, (i38 & 16) != 0 ? 0 : i36, (i38 & 32) != 0 ? null : zootopiaMapLoadingParams, (i38 & 64) != 0 ? null : zPlanMapDiffPatchInfo);
    }
}
