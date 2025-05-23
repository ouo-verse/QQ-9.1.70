package com.tencent.mobileqq.app.message.cleanup;

import android.os.SystemClock;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.cleanup.tool.ABTestCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.ADCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.AELightCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.BeaconCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.ChatFileCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.CommonCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.CrashCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.ECommerceCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.FTSCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.FileTableCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.FoundationCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.FressiaCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.GameCenterCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.GuildCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.HippyCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.LoginCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.MapCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.MiniAppCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.MiniAppScanCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.MiniBoxCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.PluginCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.ProfileCardCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.QAVCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.QConfigCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.QFixCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.QLiveCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.QLogCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.QQFavCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.QQGameCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.QZoneCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.RelativeShipCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.RichMediaCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.RobotCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.SafeCenterCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.ShareCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.TBSCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.TXLibCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.ThemeCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.TicketCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.TuringFDCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.VASCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.VFSCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.WalletCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.WebViewCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.WeiYunCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.ZPlanCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.flashtransfer.FlashTransferCleanUpThoroughCacheTool;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nativefilescan.Callback;
import com.tencent.mobileqq.nativefilescan.DirSizeData;
import com.tencent.mobileqq.nativefilescan.FileScanCore;
import com.tencent.mobileqq.pymk.PYMKCleanUpThoroughCacheTool;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVCleanUpThoroughCacheTool;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.clean.VasMMKVCleanUpThoroughCacheTool;
import com.tencent.mobileqq.wink.cleanup.WinkCleanUpThoroughBusinessCacheTool;
import com.tencent.mobileqq.wxmini.clean.WxMiniCleanUpThoroughCacheTool;
import com.tencent.qcircle.storage.QCircleCleanUpThoroughCacheTool;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\bV\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002JB\u0010\u0011\u001a\u00020\u000228\u0010\u0010\u001a4\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000bj\u001e\u0012\u0004\u0012\u00020\f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\rj\b\u0012\u0004\u0012\u00020\f`\u000f`\u000eH\u0002J\u0094\u0001\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u001228\u0010\u0014\u001a4\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000bj\u001e\u0012\u0004\u0012\u00020\f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\rj\b\u0012\u0004\u0012\u00020\f`\u000f`\u000e28\u0010\u0015\u001a4\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000bj\u001e\u0012\u0004\u0012\u00020\f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\rj\b\u0012\u0004\u0012\u00020\f`\u000f`\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0094\u0001\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u001228\u0010\u0014\u001a4\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000bj\u001e\u0012\u0004\u0012\u00020\f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\rj\b\u0012\u0004\u0012\u00020\f`\u000f`\u000e28\u0010\u0015\u001a4\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000bj\u001e\u0012\u0004\u0012\u00020\f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\rj\b\u0012\u0004\u0012\u00020\f`\u000f`\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J \u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JR\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u001228\u0010\u001c\u001a4\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000bj\u001e\u0012\u0004\u0012\u00020\f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\rj\b\u0012\u0004\u0012\u00020\f`\u000f`\u000eH\u0002JR\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u001228\u0010\u001e\u001a4\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000bj\u001e\u0012\u0004\u0012\u00020\f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\rj\b\u0012\u0004\u0012\u00020\f`\u000f`\u000eH\u0002J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JB\u0010&\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010)\u001a\u0004\u0018\u00010\u00172\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0006H\u0002J\u000f\u0010*\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020,2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020,H\u0000\u00a2\u0006\u0004\b/\u00100J\u0016\u00101\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR$\u00104\u001a\u0012\u0012\u0004\u0012\u00020!0\rj\b\u0012\u0004\u0012\u00020!`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R$\u00106\u001a\u0012\u0012\u0004\u0012\u00020\f0\rj\b\u0012\u0004\u0012\u00020\f`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0014\u00109\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0014\u0010=\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00108R\u0014\u0010?\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u00108R$\u0010A\u001a\u0012\u0012\u0004\u0012\u00020!0\rj\b\u0012\u0004\u0012\u00020!`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u00103R$\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\f0\rj\b\u0012\u0004\u0012\u00020\f`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u00103R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010FR\u0016\u0010I\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010FR\u0016\u0010J\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010FR\u0016\u0010M\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010PR\u0014\u0010U\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010T\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/CleanUpThoroughManager;", "", "", "l", "Lcom/tencent/mobileqq/nativefilescan/FileScanCore;", "scanCore", "", "isOptimizeStorageUI", "Lcom/tencent/mobileqq/nativefilescan/DirSizeData;", "data", "k", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "deleteList", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", "configWhiteList", "configDeleteWhiteList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/message/cleanup/tree/b;", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "o", "E", "reportChildList", "w", "reportAllChildFileList", "u", "G", "Ljava/io/File;", "file", "whiteListTree", "publicDirTree", "ignoreCase", "B", "root", "nodeName", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "()V", "", "y", "(Z)J", "r", "()J", "j", "a", "Ljava/util/ArrayList;", "toDeleteFile", "b", "toDeleteDir", "c", "Ljava/lang/Object;", "FILE_LOCK", "d", "DIR_LOCK", "e", "RESERVE_FILE_LOCK", "f", "RESERVE_DIR_LOCK", "g", "toReserveFile", tl.h.F, "toReserveDir", "Ljava/util/concurrent/atomic/AtomicLong;", "i", "Ljava/util/concurrent/atomic/AtomicLong;", "canDeleteSize", "canDeleteSystemSize", "canDeleteBusinessSize", "reserveFileSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isCleaning", "Ljava/util/concurrent/atomic/AtomicBoolean;", DomainData.DOMAIN_NAME, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFileScanning", "isClickBefore", "Lcom/tencent/mobileqq/nativefilescan/Callback;", "Lcom/tencent/mobileqq/nativefilescan/Callback;", "fileInfoCallback", "<init>", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CleanUpThoroughManager {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: r, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/StorageImpl/Inject_business_cleanup_thorough_cache_tool_map.yml")
    @NotNull
    private static final HashMap<String, Class<? extends y>> f195901r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private static final Lazy<HashMap<String, y>> f195902s;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<File> toDeleteFile;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> toDeleteDir;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object FILE_LOCK;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object DIR_LOCK;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object RESERVE_FILE_LOCK;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object RESERVE_DIR_LOCK;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<File> toReserveFile;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> toReserveDir;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicLong canDeleteSize;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicLong canDeleteSystemSize;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicLong canDeleteBusinessSize;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicLong reserveFileSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isCleaning;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isFileScanning;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isClickBefore;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Callback fileInfoCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\fRL\u0010\u0007\u001a.\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0002j\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004`\u00068\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR7\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005`\u00068@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/CleanUpThoroughManager$a;", "", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "Lkotlin/collections/HashMap;", "cacheToolClassMap", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "getCacheToolClassMap$annotations", "()V", "cacheToolMap$delegate", "Lkotlin/Lazy;", "b", "cacheToolMap", "", "CLEANUP_TASK_NUMBER", "I", "REPORT_ALL_CHILD_FILE_NAME", "Ljava/lang/String;", "REPORT_CHILD_BUSINESS_NAME", "SCAN_TASK_NUMBER", "TAG", "<init>", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.message.cleanup.CleanUpThoroughManager$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final HashMap<String, Class<? extends y>> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return CleanUpThoroughManager.f195901r;
            }
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final HashMap<String, y> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return (HashMap) CleanUpThoroughManager.f195902s.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JC\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/app/message/cleanup/CleanUpThoroughManager$b", "Lcom/tencent/mobileqq/nativefilescan/a;", "", "", "dirArray", "nameArray", "", "accessTimeArray", "sizeArray", "", "lastIndex", "", "onDirInfoAvailable", "([Ljava/lang/String;[Ljava/lang/String;[J[JI)V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends com.tencent.mobileqq.nativefilescan.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.nativefilescan.a, com.tencent.mobileqq.nativefilescan.Callback
        public void onDirInfoAvailable(@NotNull String[] dirArray, @NotNull String[] nameArray, @NotNull long[] accessTimeArray, @NotNull long[] sizeArray, int lastIndex) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, dirArray, nameArray, accessTimeArray, sizeArray, Integer.valueOf(lastIndex));
                return;
            }
            Intrinsics.checkNotNullParameter(dirArray, "dirArray");
            Intrinsics.checkNotNullParameter(nameArray, "nameArray");
            Intrinsics.checkNotNullParameter(accessTimeArray, "accessTimeArray");
            Intrinsics.checkNotNullParameter(sizeArray, "sizeArray");
            int length = sizeArray.length;
            for (int i3 = 0; i3 < length && i3 <= lastIndex; i3++) {
                if (sizeArray[i3] >= 5242880) {
                    QLog.d("CleanUpThoroughManager", 1, "--scan qq-- file path: " + dirArray[i3] + '/' + nameArray[i3] + " ,size: " + sizeArray[i3] + " ,name: " + nameArray[i3] + " ,accessTime: " + accessTimeArray[i3]);
                }
                if (sizeArray[i3] >= QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT) {
                    h.f195951a.g(dirArray[i3] + '/' + nameArray[i3], sizeArray[i3], nameArray[i3], accessTimeArray[i3]);
                } else {
                    if (((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).isFileUnderPublicDir(dirArray[i3] + '/' + nameArray[i3])) {
                        h.f195951a.g(dirArray[i3] + '/' + nameArray[i3], sizeArray[i3], nameArray[i3], accessTimeArray[i3]);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JC\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/app/message/cleanup/CleanUpThoroughManager$c", "Lcom/tencent/mobileqq/nativefilescan/a;", "", "", "dirArray", "nameArray", "", "accessTimeArray", "sizeArray", "", "lastIndex", "", "onDirInfoAvailable", "([Ljava/lang/String;[Ljava/lang/String;[J[JI)V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends com.tencent.mobileqq.nativefilescan.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.nativefilescan.a, com.tencent.mobileqq.nativefilescan.Callback
        public void onDirInfoAvailable(@NotNull String[] dirArray, @NotNull String[] nameArray, @NotNull long[] accessTimeArray, @NotNull long[] sizeArray, int lastIndex) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, dirArray, nameArray, accessTimeArray, sizeArray, Integer.valueOf(lastIndex));
                return;
            }
            Intrinsics.checkNotNullParameter(dirArray, "dirArray");
            Intrinsics.checkNotNullParameter(nameArray, "nameArray");
            Intrinsics.checkNotNullParameter(accessTimeArray, "accessTimeArray");
            Intrinsics.checkNotNullParameter(sizeArray, "sizeArray");
            if (lastIndex < 0) {
                return;
            }
            while (true) {
                h.f(h.f195951a, dirArray[i3] + File.separator + nameArray[i3], sizeArray[i3], true, true, false, "report_all_child_file", 0L, 0L, 192, null);
                if (i3 != lastIndex) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    static {
        Lazy<HashMap<String, y>> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18803);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        HashMap<String, Class<? extends y>> hashMap = new HashMap<>();
        f195901r = hashMap;
        hashMap.put("wxMini", WxMiniCleanUpThoroughCacheTool.class);
        hashMap.put("FlashTransfer", FlashTransferCleanUpThoroughCacheTool.class);
        hashMap.put("Wink", WinkCleanUpThoroughBusinessCacheTool.class);
        hashMap.put("QCircle", QCircleCleanUpThoroughCacheTool.class);
        hashMap.put("TBS", TBSCleanUpThoroughCacheTool.class);
        hashMap.put("mmkv", MMKVCleanUpThoroughCacheTool.class);
        hashMap.put("QQGame", QQGameCleanUpThoroughCacheTool.class);
        hashMap.put("QConfig", QConfigCleanUpThoroughCacheTool.class);
        hashMap.put("SafeCenter", SafeCenterCleanUpThoroughCacheTool.class);
        hashMap.put("TXLib", TXLibCleanUpThoroughCacheTool.class);
        hashMap.put("FTS", FTSCleanUpThoroughCacheTool.class);
        hashMap.put("Fressia", FressiaCleanUpThoroughCacheTool.class);
        hashMap.put(AegisLogger.LOGIN, LoginCleanUpThoroughCacheTool.class);
        hashMap.put("Common", CommonCleanUpThoroughCacheTool.class);
        hashMap.put("Robot", RobotCleanUpThoroughCacheTool.class);
        hashMap.put("ZPlan", ZPlanCleanUpThoroughCacheTool.class);
        hashMap.put("WeiYun", WeiYunCleanUpThoroughCacheTool.class);
        hashMap.put("WebView", WebViewCleanUpThoroughCacheTool.class);
        hashMap.put("Wallet", WalletCleanUpThoroughCacheTool.class);
        hashMap.put("VFS", VFSCleanUpThoroughCacheTool.class);
        hashMap.put("VAS_MMKV", VasMMKVCleanUpThoroughCacheTool.class);
        hashMap.put("THEME", ThemeCleanUpThoroughCacheTool.class);
        hashMap.put("VAS", VASCleanUpThoroughCacheTool.class);
        hashMap.put("TuringFD", TuringFDCleanUpThoroughCacheTool.class);
        hashMap.put(AegisLogger.SHARE, ShareCleanUpThoroughCacheTool.class);
        hashMap.put("RichMedia", RichMediaCleanUpThoroughCacheTool.class);
        hashMap.put("RelativeShip", RelativeShipCleanUpThoroughCacheTool.class);
        hashMap.put("QZone", QZoneCleanUpThoroughCacheTool.class);
        hashMap.put("QQFav", QQFavCleanUpThoroughCacheTool.class);
        hashMap.put("QLive", QLiveCleanUpThoroughCacheTool.class);
        hashMap.put(RFixPatchInfo.PATCH_TYPE_QFIX, QFixCleanUpThoroughCacheTool.class);
        hashMap.put("QAV", QAVCleanUpThoroughCacheTool.class);
        hashMap.put("ProfileCard", ProfileCardCleanUpThoroughCacheTool.class);
        hashMap.put("Plugin", PluginCleanUpThoroughCacheTool.class);
        hashMap.put("MiniBox", MiniBoxCleanUpThoroughCacheTool.class);
        hashMap.put("MiniAppScan", MiniAppScanCleanUpThoroughCacheTool.class);
        hashMap.put("MiniApp", MiniAppCleanUpThoroughCacheTool.class);
        hashMap.put("Map", MapCleanUpThoroughCacheTool.class);
        hashMap.put(HippyQQConstants.HIPPY_TAG, HippyCleanUpThoroughCacheTool.class);
        hashMap.put("Guild", GuildCleanUpThoroughCacheTool.class);
        hashMap.put("GameCenter", GameCenterCleanUpThoroughCacheTool.class);
        hashMap.put("ECommerce", ECommerceCleanUpThoroughCacheTool.class);
        hashMap.put("Crash", CrashCleanUpThoroughCacheTool.class);
        hashMap.put("Beacon", BeaconCleanUpThoroughCacheTool.class);
        hashMap.put("AELight", AELightCleanUpThoroughCacheTool.class);
        hashMap.put("AD", ADCleanUpThoroughCacheTool.class);
        hashMap.put("ABTest", ABTestCleanUpThoroughCacheTool.class);
        hashMap.put("ChatFile", ChatFileCleanUpThoroughCacheTool.class);
        hashMap.put("PYMK", PYMKCleanUpThoroughCacheTool.class);
        hashMap.put("FileTable", FileTableCleanUpThoroughCacheTool.class);
        hashMap.put("Ticket", TicketCleanUpThoroughCacheTool.class);
        hashMap.put("QLog", QLogCleanUpThoroughCacheTool.class);
        hashMap.put("Foundation", FoundationCleanUpThoroughCacheTool.class);
        lazy = LazyKt__LazyJVMKt.lazy(CleanUpThoroughManager$Companion$cacheToolMap$2.INSTANCE);
        f195902s = lazy;
    }

    public CleanUpThoroughManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.toDeleteFile = new ArrayList<>();
        this.toDeleteDir = new ArrayList<>();
        this.FILE_LOCK = new Object();
        this.DIR_LOCK = new Object();
        this.RESERVE_FILE_LOCK = new Object();
        this.RESERVE_DIR_LOCK = new Object();
        this.toReserveFile = new ArrayList<>();
        this.toReserveDir = new ArrayList<>();
        this.canDeleteSize = new AtomicLong(0L);
        this.canDeleteSystemSize = new AtomicLong(0L);
        this.canDeleteBusinessSize = new AtomicLong(0L);
        this.reserveFileSize = new AtomicLong(0L);
        this.isFileScanning = new AtomicBoolean(false);
        this.isClickBefore = new AtomicBoolean(false);
        this.fileInfoCallback = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(HashMap configWhiteList, HashMap configDeleteWhiteList, CleanUpThoroughManager this$0, FileScanCore scanCore, boolean z16, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(configWhiteList, "$configWhiteList");
        Intrinsics.checkNotNullParameter(configDeleteWhiteList, "$configDeleteWhiteList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scanCore, "$scanCore");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        long uptimeMillis = SystemClock.uptimeMillis();
        com.tencent.mobileqq.app.message.cleanup.tree.a aVar = com.tencent.mobileqq.app.message.cleanup.tree.a.f195961a;
        com.tencent.mobileqq.app.message.filescan.d dVar = com.tencent.mobileqq.app.message.filescan.d.f195978a;
        this$0.B(new File(dVar.d()), aVar.a(dVar.d(), configWhiteList, configDeleteWhiteList, INSTANCE.b()), this$0.o(), scanCore, true, new DirSizeData(0L, 0, 0, 7, null), z16);
        QLog.d("CleanUpThoroughManager", 1, "scanExternalPrivateData complete external private data scan cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
        countDownLatch.countDown();
    }

    private final void B(File file, com.tencent.mobileqq.app.message.cleanup.tree.b whiteListTree, com.tencent.mobileqq.app.message.cleanup.tree.b publicDirTree, FileScanCore scanCore, boolean ignoreCase, DirSizeData data, boolean isOptimizeStorageUI) {
        com.tencent.mobileqq.app.message.cleanup.tree.b q16;
        if (whiteListTree.c()) {
            if (isOptimizeStorageUI) {
                synchronized (this.RESERVE_DIR_LOCK) {
                    this.toReserveDir.add(file.getAbsolutePath());
                }
                return;
            }
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            scanCore.d(absolutePath, false, true, data, null);
            h hVar = h.f195951a;
            String absolutePath2 = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "file.absolutePath");
            h.f(hVar, absolutePath2, data.getTotalSize(), false, true, false, null, 0L, 0L, 224, null);
            return;
        }
        String[] list = file.list();
        if (list == null) {
            return;
        }
        for (String childFileName : list) {
            Intrinsics.checkNotNullExpressionValue(childFileName, "childFileName");
            com.tencent.mobileqq.app.message.cleanup.tree.b q17 = q(whiteListTree, childFileName, ignoreCase);
            File file2 = new File(file, childFileName);
            if (file2.isFile()) {
                if (publicDirTree != null) {
                    if (isOptimizeStorageUI) {
                        synchronized (this.RESERVE_FILE_LOCK) {
                            this.toReserveFile.add(file2);
                        }
                    }
                    h hVar2 = h.f195951a;
                    String absolutePath3 = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath3, "curFile.absolutePath");
                    h.f(hVar2, absolutePath3, file2.length(), true, false, true, null, 0L, 0L, 224, null);
                } else if (q17 != null) {
                    if (isOptimizeStorageUI) {
                        synchronized (this.RESERVE_FILE_LOCK) {
                            this.toReserveFile.add(file2);
                        }
                    }
                    h hVar3 = h.f195951a;
                    String absolutePath4 = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath4, "curFile.absolutePath");
                    h.f(hVar3, absolutePath4, file2.length(), true, true, false, null, 0L, 0L, 224, null);
                } else {
                    synchronized (this.FILE_LOCK) {
                        this.toDeleteFile.add(file2);
                    }
                    if (!isOptimizeStorageUI) {
                        this.canDeleteSize.addAndGet(file2.length());
                    }
                    QLog.d("CleanUpThoroughManager", 1, "deleteDirWithTreeNode file canDeleteSize add size: " + file2.length() + ", path: " + file2.getAbsolutePath());
                    h hVar4 = h.f195951a;
                    String absolutePath5 = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath5, "curFile.absolutePath");
                    h.f(hVar4, absolutePath5, file2.length(), true, false, false, null, 0L, 0L, 224, null);
                }
            } else if (q17 != null) {
                if (publicDirTree == null) {
                    q16 = null;
                } else {
                    q16 = q(publicDirTree, childFileName, ignoreCase);
                }
                B(file2, q17, q16, scanCore, ignoreCase, data, isOptimizeStorageUI);
            } else {
                synchronized (this.DIR_LOCK) {
                    this.toDeleteDir.add(file2.getAbsolutePath());
                }
                if (!isOptimizeStorageUI) {
                    String absolutePath6 = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath6, "curFile.absolutePath");
                    scanCore.d(absolutePath6, false, true, data, null);
                    h hVar5 = h.f195951a;
                    String absolutePath7 = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath7, "curFile.absolutePath");
                    h.f(hVar5, absolutePath7, data.getTotalSize(), false, false, false, null, 0L, 0L, 224, null);
                    this.canDeleteSize.addAndGet(data.getTotalSize());
                    QLog.d("CleanUpThoroughManager", 1, "deleteDirWithTreeNode dir canDeleteSize add size: " + data.getTotalSize() + ", path: " + file2.getAbsolutePath());
                }
            }
        }
    }

    private final void C(final FileScanCore scanCore, final CountDownLatch countDownLatch, final HashMap<String, ArrayList<String>> configWhiteList, final HashMap<String, ArrayList<String>> configDeleteWhiteList, final boolean isOptimizeStorageUI) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.message.cleanup.d
            @Override // java.lang.Runnable
            public final void run() {
                CleanUpThoroughManager.D(configWhiteList, configDeleteWhiteList, this, scanCore, isOptimizeStorageUI, countDownLatch);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(HashMap configWhiteList, HashMap configDeleteWhiteList, CleanUpThoroughManager this$0, FileScanCore scanCore, boolean z16, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(configWhiteList, "$configWhiteList");
        Intrinsics.checkNotNullParameter(configDeleteWhiteList, "$configDeleteWhiteList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scanCore, "$scanCore");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        long uptimeMillis = SystemClock.uptimeMillis();
        com.tencent.mobileqq.app.message.cleanup.tree.a aVar = com.tencent.mobileqq.app.message.cleanup.tree.a.f195961a;
        com.tencent.mobileqq.app.message.filescan.d dVar = com.tencent.mobileqq.app.message.filescan.d.f195978a;
        this$0.B(new File(dVar.a()), aVar.a(dVar.a(), configWhiteList, configDeleteWhiteList, INSTANCE.b()), this$0.p(), scanCore, false, new DirSizeData(0L, 0, 0, 7, null), z16);
        QLog.d("CleanUpThoroughManager", 1, "scanInnerData complete inner data scan cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
        countDownLatch.countDown();
    }

    private final void E(final FileScanCore scanCore, final CountDownLatch countDownLatch, final boolean isOptimizeStorageUI) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.message.cleanup.c
            @Override // java.lang.Runnable
            public final void run() {
                CleanUpThoroughManager.F(isOptimizeStorageUI, this, scanCore, countDownLatch);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(boolean z16, CleanUpThoroughManager this$0, FileScanCore scanCore, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scanCore, "$scanCore");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        if (!z16) {
            this$0.G(scanCore, z16);
        }
        countDownLatch.countDown();
    }

    private final void G(FileScanCore scanCore, boolean isOptimizeStorageUI) {
        DirSizeData dirSizeData = new DirSizeData(0L, 0, 0, 7, null);
        long uptimeMillis = SystemClock.uptimeMillis();
        Collection<y> values = INSTANCE.b().values();
        Intrinsics.checkNotNullExpressionValue(values, "cacheToolMap.values");
        for (y yVar : values) {
            Iterator<T> it = yVar.getWhiteList().iterator();
            long j3 = 0;
            while (it.hasNext()) {
                scanCore.d((String) it.next(), false, true, dirSizeData, null);
                j3 += dirSizeData.getTotalSize();
            }
            long clearSize = yVar.getClearSize();
            long j16 = j3 - clearSize;
            if (isOptimizeStorageUI) {
                this.canDeleteBusinessSize.addAndGet(clearSize);
                this.canDeleteSize.addAndGet(clearSize);
            } else {
                this.canDeleteSize.addAndGet(clearSize);
            }
            h hVar = h.f195951a;
            String simpleName = yVar.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "it.javaClass.simpleName");
            hVar.e("cleanup_tool", clearSize, false, true, false, simpleName, j3, j16);
        }
        QLog.d("CleanUpThoroughManager", 1, "scanOther complete cache tool cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
        for (String str : com.tencent.mobileqq.app.message.filescan.d.f195978a.m()) {
            scanCore.d(str, false, true, dirSizeData, null);
            if (isOptimizeStorageUI) {
                this.canDeleteSystemSize.addAndGet(dirSizeData.getTotalSize());
            } else {
                this.canDeleteSize.addAndGet(dirSizeData.getTotalSize());
            }
            QLog.d("CleanUpThoroughManager", 1, "scanOther system cache clear size: " + dirSizeData.getTotalSize() + ", path: " + str);
        }
        QLog.d("CleanUpThoroughManager", 1, "scanOther complete system cache cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
    }

    private final void k(FileScanCore scanCore, boolean isOptimizeStorageUI, DirSizeData data) {
        boolean z16 = false;
        for (File file : this.toReserveFile) {
            if (!z16 && this.isClickBefore.get()) {
                l();
                QLog.d("CleanUpThoroughManager", 1, "celWhiteListSize toReserveFile cleanUp");
                z16 = true;
            }
            this.reserveFileSize.addAndGet(file.length());
        }
        for (String str : this.toReserveDir) {
            if (!z16 && this.isClickBefore.get()) {
                l();
                QLog.d("CleanUpThoroughManager", 1, "celWhiteListSize toReserveDir cleanUp");
                z16 = true;
            }
            scanCore.d(str, false, true, data, this.fileInfoCallback);
            this.reserveFileSize.addAndGet(data.getTotalSize());
            h.f(h.f195951a, str, data.getTotalSize(), false, true, false, null, 0L, 0L, 224, null);
            QLog.d("CleanUpThoroughManager", 1, "white list leaf node . left dir: " + str + ", size: " + data.getTotalSize());
        }
        G(scanCore, isOptimizeStorageUI);
        QLog.d("CleanUpThoroughManager", 1, "before scanReserveFile complete reserveFileSize: " + this.reserveFileSize.get() + ", canDeleteBusinessSize: " + this.canDeleteBusinessSize.get() + ", canDeleteSystemSize: " + this.canDeleteSystemSize.get());
        this.reserveFileSize.addAndGet(-this.canDeleteBusinessSize.get());
        this.reserveFileSize.addAndGet(-this.canDeleteSystemSize.get());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("scanReserveFile complete reserveFileSize: ");
        sb5.append(this.reserveFileSize.get());
        QLog.d("CleanUpThoroughManager", 1, sb5.toString());
    }

    private final void l() {
        if (this.isCleaning) {
            QLog.d("CleanUpThoroughManager", 1, "cleanUp cleaning, stop from cleaning");
            return;
        }
        this.isCleaning = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Collection<y> values = INSTANCE.b().values();
        Intrinsics.checkNotNullExpressionValue(values, "cacheToolMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((y) it.next()).clearCache();
        }
        QLog.d("CleanUpThoroughManager", 1, "cleanUp cache tool clean cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.message.cleanup.f
            @Override // java.lang.Runnable
            public final void run() {
                CleanUpThoroughManager.m(CleanUpThoroughManager.this, countDownLatch);
            }
        }, 64, null, true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.message.cleanup.g
            @Override // java.lang.Runnable
            public final void run() {
                CleanUpThoroughManager.n(CleanUpThoroughManager.this, countDownLatch);
            }
        }, 64, null, true);
        countDownLatch.await();
        QLog.d("CleanUpThoroughManager", 1, "cleanUp complete");
        this.toDeleteFile.clear();
        this.toDeleteDir.clear();
        this.canDeleteSize.set(0L);
        this.canDeleteSystemSize.set(0L);
        this.canDeleteBusinessSize.set(0L);
        this.isClickBefore.set(false);
        this.isCleaning = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(CleanUpThoroughManager this$0, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        long uptimeMillis = SystemClock.uptimeMillis();
        Iterator<T> it = this$0.toDeleteFile.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
        countDownLatch.countDown();
        QLog.d("CleanUpThoroughManager", 1, "cleanUp complete file clean cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(CleanUpThoroughManager this$0, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        QRouteApi api = QRoute.api(IStorageFileHelperApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IStorageFileHelperApi::class.java)");
        IStorageFileHelperApi iStorageFileHelperApi = (IStorageFileHelperApi) api;
        long uptimeMillis = SystemClock.uptimeMillis();
        Iterator<T> it = this$0.toDeleteDir.iterator();
        while (it.hasNext()) {
            iStorageFileHelperApi.deleteFilesInDirectory((String) it.next());
        }
        countDownLatch.countDown();
        QLog.d("CleanUpThoroughManager", 1, "cleanUp complete dir clean cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
    }

    private final com.tencent.mobileqq.app.message.cleanup.tree.b o() {
        com.tencent.mobileqq.app.message.cleanup.tree.b bVar = new com.tencent.mobileqq.app.message.cleanup.tree.b(com.tencent.mobileqq.app.message.filescan.d.f195978a.d(), null, 2, null);
        ArrayList<com.tencent.mobileqq.app.message.cleanup.tree.b> a16 = bVar.a();
        com.tencent.mobileqq.app.message.cleanup.tree.b bVar2 = new com.tencent.mobileqq.app.message.cleanup.tree.b("files", null, 2, null);
        ArrayList<com.tencent.mobileqq.app.message.cleanup.tree.b> a17 = bVar2.a();
        com.tencent.mobileqq.app.message.cleanup.tree.b bVar3 = new com.tencent.mobileqq.app.message.cleanup.tree.b("tencent", null, 2, null);
        bVar3.a().add(new com.tencent.mobileqq.app.message.cleanup.tree.b("MobileQQ", null, 2, null));
        a17.add(bVar3);
        a16.add(bVar2);
        ArrayList<com.tencent.mobileqq.app.message.cleanup.tree.b> a18 = bVar.a();
        com.tencent.mobileqq.app.message.cleanup.tree.b bVar4 = new com.tencent.mobileqq.app.message.cleanup.tree.b("Tencent", null, 2, null);
        bVar4.a().add(new com.tencent.mobileqq.app.message.cleanup.tree.b("MobileQQ", null, 2, null));
        a18.add(bVar4);
        return bVar;
    }

    private final com.tencent.mobileqq.app.message.cleanup.tree.b p() {
        com.tencent.mobileqq.app.message.cleanup.tree.b bVar = new com.tencent.mobileqq.app.message.cleanup.tree.b(com.tencent.mobileqq.app.message.filescan.d.f195978a.a(), null, 2, null);
        bVar.a().add(new com.tencent.mobileqq.app.message.cleanup.tree.b("files", null, 2, null));
        return bVar;
    }

    private final com.tencent.mobileqq.app.message.cleanup.tree.b q(com.tencent.mobileqq.app.message.cleanup.tree.b root, String nodeName, boolean ignoreCase) {
        boolean equals;
        for (com.tencent.mobileqq.app.message.cleanup.tree.b bVar : root.a()) {
            equals = StringsKt__StringsJVMKt.equals(nodeName, bVar.b(), ignoreCase);
            if (equals) {
                return bVar;
            }
        }
        return null;
    }

    private final void s(HashMap<String, ArrayList<String>> deleteList) {
        List<String> flatten;
        Collection<ArrayList<String>> values = deleteList.values();
        Intrinsics.checkNotNullExpressionValue(values, "deleteList.values");
        flatten = CollectionsKt__IterablesKt.flatten(values);
        for (String str : flatten) {
            File file = new File(str);
            if (!file.exists()) {
                QLog.d("CleanUpThoroughManager", 1, "handleDeleteList file path: " + str + " not exist");
            } else {
                if (file.isFile()) {
                    this.toDeleteFile.add(file);
                } else {
                    this.toDeleteDir.add(str);
                }
                QLog.d("CleanUpThoroughManager", 1, "handleDeleteList file path: " + str);
            }
        }
    }

    private final void u(final FileScanCore scanCore, final CountDownLatch countDownLatch, final HashMap<String, ArrayList<String>> reportAllChildFileList) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.message.cleanup.b
            @Override // java.lang.Runnable
            public final void run() {
                CleanUpThoroughManager.v(reportAllChildFileList, countDownLatch, scanCore);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(HashMap reportAllChildFileList, CountDownLatch countDownLatch, FileScanCore scanCore) {
        List<String> flatten;
        Intrinsics.checkNotNullParameter(reportAllChildFileList, "$reportAllChildFileList");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        Intrinsics.checkNotNullParameter(scanCore, "$scanCore");
        DirSizeData dirSizeData = new DirSizeData(0L, 0, 0, 7, null);
        Collection values = reportAllChildFileList.values();
        Intrinsics.checkNotNullExpressionValue(values, "reportAllChildFileList.values");
        flatten = CollectionsKt__IterablesKt.flatten(values);
        for (String str : flatten) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                scanCore.d(str, false, true, dirSizeData, new c());
            } else {
                QLog.d("CleanUpThoroughManager", 1, "reportAllSubFile file path: " + str + " not valid");
            }
        }
        countDownLatch.countDown();
    }

    private final void w(final FileScanCore scanCore, final CountDownLatch countDownLatch, final HashMap<String, ArrayList<String>> reportChildList) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.message.cleanup.a
            @Override // java.lang.Runnable
            public final void run() {
                CleanUpThoroughManager.x(reportChildList, countDownLatch, scanCore);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(HashMap reportChildList, CountDownLatch countDownLatch, FileScanCore scanCore) {
        List<String> flatten;
        long totalSize;
        Intrinsics.checkNotNullParameter(reportChildList, "$reportChildList");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        Intrinsics.checkNotNullParameter(scanCore, "$scanCore");
        DirSizeData dirSizeData = new DirSizeData(0L, 0, 0, 7, null);
        Collection values = reportChildList.values();
        Intrinsics.checkNotNullExpressionValue(values, "reportChildList.values");
        flatten = CollectionsKt__IterablesKt.flatten(values);
        for (String str : flatten) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            totalSize = file2.length();
                        } else {
                            String absolutePath = file2.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                            scanCore.d(absolutePath, false, true, dirSizeData, null);
                            totalSize = dirSizeData.getTotalSize();
                        }
                        long j3 = totalSize;
                        h hVar = h.f195951a;
                        String absolutePath2 = file2.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath2, "it.absolutePath");
                        h.f(hVar, absolutePath2, j3, file2.isFile(), true, false, "report_child_path", j3, 0L, 128, null);
                    }
                }
            } else {
                QLog.d("CleanUpThoroughManager", 1, "reportSubBusiness file path: " + str + " not valid");
            }
        }
        countDownLatch.countDown();
    }

    private final void z(final FileScanCore scanCore, final CountDownLatch countDownLatch, final HashMap<String, ArrayList<String>> configWhiteList, final HashMap<String, ArrayList<String>> configDeleteWhiteList, final boolean isOptimizeStorageUI) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.message.cleanup.e
            @Override // java.lang.Runnable
            public final void run() {
                CleanUpThoroughManager.A(configWhiteList, configDeleteWhiteList, this, scanCore, isOptimizeStorageUI, countDownLatch);
            }
        }, 64, null, true);
    }

    public final void j(@NotNull FileScanCore scanCore, @NotNull DirSizeData data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) scanCore, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(scanCore, "scanCore");
        Intrinsics.checkNotNullParameter(data, "data");
        for (File file : this.toDeleteFile) {
            if (this.isClickBefore.get()) {
                l();
                QLog.d("CleanUpThoroughManager", 1, "calCacheFileSize toDeleteFile cleanUp");
                return;
            }
            this.canDeleteSize.addAndGet(file.length());
        }
        for (String str : this.toDeleteDir) {
            if (this.isClickBefore.get()) {
                l();
                QLog.d("CleanUpThoroughManager", 1, "calCacheFileSize toDeleteDir cleanUp");
                return;
            }
            scanCore.d(str, false, true, data, null);
            this.canDeleteSize.addAndGet(data.getTotalSize());
            h.f(h.f195951a, str, data.getTotalSize(), false, false, false, null, 0L, 0L, 224, null);
            QLog.d("CleanUpThoroughManager", 1, "deleteDirWithTreeNode dir canDeleteSize add size: " + data.getTotalSize() + ", path: " + str);
        }
    }

    public final long r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.reserveFileSize.get();
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.isFileScanning.get()) {
            this.isClickBefore.set(true);
        } else {
            l();
        }
    }

    public final long y(boolean isOptimizeStorageUI) {
        HashMap<String, ArrayList<String>> hashMap;
        HashMap<String, ArrayList<String>> hashMap2;
        HashMap<String, ArrayList<String>> hashMap3;
        HashMap<String, ArrayList<String>> hashMap4;
        HashMap<String, ArrayList<String>> hashMap5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, isOptimizeStorageUI)).longValue();
        }
        if (isOptimizeStorageUI) {
            this.isFileScanning.set(true);
            this.reserveFileSize.set(0L);
            this.canDeleteSystemSize.set(0L);
            this.canDeleteBusinessSize.set(0L);
            this.toReserveDir.clear();
            this.toReserveFile.clear();
        }
        h hVar = h.f195951a;
        hVar.b();
        this.toDeleteFile.clear();
        this.toDeleteDir.clear();
        this.canDeleteSize.set(0L);
        com.tencent.mobileqq.app.message.cleanup.config.a aVar = (com.tencent.mobileqq.app.message.cleanup.config.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("clean_up_thorough");
        if (aVar == null || (hashMap = aVar.g()) == null) {
            hashMap = new HashMap<>();
        }
        if (aVar == null || (hashMap2 = aVar.d()) == null) {
            hashMap2 = new HashMap<>();
        }
        HashMap<String, ArrayList<String>> hashMap6 = hashMap2;
        if (aVar == null || (hashMap3 = aVar.c()) == null) {
            hashMap3 = new HashMap<>();
        }
        s(hashMap3);
        this.toDeleteDir.addAll(com.tencent.mobileqq.app.message.filescan.d.f195978a.m());
        FileScanCore a16 = FileScanCore.INSTANCE.a(new j());
        CountDownLatch countDownLatch = new CountDownLatch(5);
        HashMap<String, ArrayList<String>> hashMap7 = hashMap;
        C(a16, countDownLatch, hashMap7, hashMap6, isOptimizeStorageUI);
        z(a16, countDownLatch, hashMap7, hashMap6, isOptimizeStorageUI);
        E(a16, countDownLatch, isOptimizeStorageUI);
        if (aVar == null || (hashMap4 = aVar.f()) == null) {
            hashMap4 = new HashMap<>();
        }
        w(a16, countDownLatch, hashMap4);
        if (aVar == null || (hashMap5 = aVar.e()) == null) {
            hashMap5 = new HashMap<>();
        }
        u(a16, countDownLatch, hashMap5);
        countDownLatch.await();
        QLog.d("CleanUpThoroughManager", 1, "scanCacheFile complete canDeleteSize: " + this.canDeleteSize.get() + ", isOptimizeStorageUI: " + isOptimizeStorageUI);
        if (isOptimizeStorageUI) {
            DirSizeData dirSizeData = new DirSizeData(0L, 0, 0, 7, null);
            this.isFileScanning.set(false);
            k(a16, isOptimizeStorageUI, dirSizeData);
            j(a16, dirSizeData);
            QLog.d("CleanUpThoroughManager", 1, "isOptimizeStorageUI is true, scanCacheFile complete canDeleteSize: " + this.canDeleteSize.get());
        }
        hVar.a();
        return this.canDeleteSize.get();
    }
}
