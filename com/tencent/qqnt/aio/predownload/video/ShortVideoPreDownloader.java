package com.tencent.qqnt.aio.predownload.video;

import android.os.Handler;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Service(process = {"all"})
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 72\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\bz\u0010{J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0016\u0010\u0019\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016J\u0006\u0010%\u001a\u00020\u0002J\b\u0010&\u001a\u00020\u0002H\u0016R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R.\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R(\u0010;\u001a\b\u0012\u0004\u0012\u00020\r048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010?\u001a\b\u0012\u0004\u0012\u00020\r048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u00106\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R(\u0010C\u001a\b\u0012\u0004\u0012\u00020\r048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u00106\u001a\u0004\bA\u00108\"\u0004\bB\u0010:R(\u0010G\u001a\b\u0012\u0004\u0012\u00020\r048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u00106\u001a\u0004\bE\u00108\"\u0004\bF\u0010:R(\u0010N\u001a\b\u0012\u0004\u0012\u00020\r0H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\"0O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\"\u0010Y\u001a\u00020S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010a\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010g\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010k\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010b\u001a\u0004\bi\u0010d\"\u0004\bj\u0010fR\u001b\u0010p\u001a\u00020l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010m\u001a\u0004\bn\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010w\u001a\u0004\u0018\u00010\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bu\u0010vR\u0014\u0010y\u001a\u00020,8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\br\u0010x\u00a8\u0006|"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/video/ShortVideoPreDownloader;", "Lkv3/a;", "", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "msgItem", "B", "", "priority", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/tencent/qqnt/aio/predownload/video/req/a;", ReportConstant.COSTREPORT_PREFIX, "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", "isScreenOn", "onScreenStateChange", "onProcessForeground", "onProcessBackground", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "onMsgReceive", "onNetworkConnected", "onGetOfflineMessageFinish", "k", "w", "i", "videoDownloadReq", HippyTKDListViewAdapter.X, "u", "Lcom/tencent/qqnt/aio/predownload/video/req/b;", "thumbDownloadReq", "y", "g", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mLocalVideoPreDownloadSwitch", "", "", "b", "Ljava/util/Map;", "getMVideoDownloadPriorityMap", "()Ljava/util/Map;", "setMVideoDownloadPriorityMap", "(Ljava/util/Map;)V", "mVideoDownloadPriorityMap", "", "c", "Ljava/util/List;", "o", "()Ljava/util/List;", "setMAIOVideoDownloadRequests", "(Ljava/util/List;)V", "mAIOVideoDownloadRequests", "d", "p", "setMC2CVideoDownloadRequests", "mC2CVideoDownloadRequests", "e", "r", "setMGroupVideoDownloadRequests", "mGroupVideoDownloadRequests", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setMDiscussionVideoDownloadRequests", "mDiscussionVideoDownloadRequests", "Ljava/util/concurrent/PriorityBlockingQueue;", "Ljava/util/concurrent/PriorityBlockingQueue;", "getMHandlingVideoDownloadQueue", "()Ljava/util/concurrent/PriorityBlockingQueue;", "setMHandlingVideoDownloadQueue", "(Ljava/util/concurrent/PriorityBlockingQueue;)V", "mHandlingVideoDownloadQueue", "Ljava/util/concurrent/LinkedBlockingDeque;", tl.h.F, "Ljava/util/concurrent/LinkedBlockingDeque;", "mPendingThumbDownloadQueue", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "getMHandlingNum", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setMHandlingNum", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "mHandlingNum", "Landroid/os/Handler;", "j", "Landroid/os/Handler;", "getMSubHandler", "()Landroid/os/Handler;", "setMSubHandler", "(Landroid/os/Handler;)V", "mSubHandler", "Z", "getMIsScreenOn", "()Z", "setMIsScreenOn", "(Z)V", "mIsScreenOn", "l", "getMIsForeground", "setMIsForeground", "mIsForeground", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Lazy;", "getMMainScope", "()Lkotlinx/coroutines/CoroutineScope;", "mMainScope", "Ljava/lang/Runnable;", DomainData.DOMAIN_NAME, "Ljava/lang/Runnable;", "mOpenVideoPreDownloadRunnable", "t", "()Lcom/tencent/qqnt/aio/predownload/video/req/a;", "shortVideoDownloadRequest", "()Ljava/lang/String;", "logTag", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class ShortVideoPreDownloader implements kv3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean mLocalVideoPreDownloadSwitch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, Integer> mVideoDownloadPriorityMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.qqnt.aio.predownload.video.req.a> mAIOVideoDownloadRequests;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.qqnt.aio.predownload.video.req.a> mC2CVideoDownloadRequests;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.qqnt.aio.predownload.video.req.a> mGroupVideoDownloadRequests;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.qqnt.aio.predownload.video.req.a> mDiscussionVideoDownloadRequests;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PriorityBlockingQueue<com.tencent.qqnt.aio.predownload.video.req.a> mHandlingVideoDownloadQueue;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedBlockingDeque<com.tencent.qqnt.aio.predownload.video.req.b> mPendingThumbDownloadQueue;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger mHandlingNum;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Handler mSubHandler;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean mIsScreenOn;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean mIsForeground;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMainScope;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable mOpenVideoPreDownloadRunnable;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/video/ShortVideoPreDownloader$a;", "", "", "TAG", "Ljava/lang/String;", "", "VIDEO_PRE_DOWNLOAD_CLOSE_DURATION_IN_MILLIS", "J", "", "VIDEO_PRE_DOWNLOAD_MAX_HANDLING_THREADS", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.predownload.video.ShortVideoPreDownloader$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/predownload/video/ShortVideoPreDownloader$b", "Lcom/tencent/qqnt/aio/predownload/video/strategy/c;", "", "preDownload", "", "onResult", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.qqnt.aio.predownload.video.strategy.c {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortVideoMsgItem f351825b;

        b(ShortVideoMsgItem shortVideoMsgItem) {
            this.f351825b = shortVideoMsgItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShortVideoPreDownloader.this, (Object) shortVideoMsgItem);
            }
        }

        @Override // com.tencent.qqnt.aio.predownload.video.strategy.c
        public void onResult(boolean preDownload) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, preDownload);
            } else if (preDownload) {
                ShortVideoPreDownloader.this.k(this.f351825b);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/predownload/video/ShortVideoPreDownloader$c", "Lcom/tencent/qqnt/aio/predownload/video/strategy/a;", "", "preDownloadVideo", "", "onResult", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements com.tencent.qqnt.aio.predownload.video.strategy.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortVideoMsgItem f351827b;

        c(ShortVideoMsgItem shortVideoMsgItem) {
            this.f351827b = shortVideoMsgItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShortVideoPreDownloader.this, (Object) shortVideoMsgItem);
            }
        }

        @Override // com.tencent.qqnt.aio.predownload.video.strategy.a
        public void onResult(boolean preDownloadVideo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, preDownloadVideo);
            } else if (preDownloadVideo) {
                ShortVideoPreDownloader.this.w(this.f351827b, 1);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65598);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ShortVideoPreDownloader() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLocalVideoPreDownloadSwitch = new AtomicBoolean(true);
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "synchronizedMap(HashMap())");
        this.mVideoDownloadPriorityMap = synchronizedMap;
        List<com.tencent.qqnt.aio.predownload.video.req.a> synchronizedList = Collections.synchronizedList(new LinkedList());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(LinkedList())");
        this.mAIOVideoDownloadRequests = synchronizedList;
        List<com.tencent.qqnt.aio.predownload.video.req.a> synchronizedList2 = Collections.synchronizedList(new LinkedList());
        Intrinsics.checkNotNullExpressionValue(synchronizedList2, "synchronizedList(LinkedList())");
        this.mC2CVideoDownloadRequests = synchronizedList2;
        List<com.tencent.qqnt.aio.predownload.video.req.a> synchronizedList3 = Collections.synchronizedList(new LinkedList());
        Intrinsics.checkNotNullExpressionValue(synchronizedList3, "synchronizedList(LinkedList())");
        this.mGroupVideoDownloadRequests = synchronizedList3;
        List<com.tencent.qqnt.aio.predownload.video.req.a> synchronizedList4 = Collections.synchronizedList(new LinkedList());
        Intrinsics.checkNotNullExpressionValue(synchronizedList4, "synchronizedList(LinkedList())");
        this.mDiscussionVideoDownloadRequests = synchronizedList4;
        this.mHandlingVideoDownloadQueue = new PriorityBlockingQueue<>();
        this.mPendingThumbDownloadQueue = new LinkedBlockingDeque<>();
        this.mHandlingNum = new AtomicInteger();
        this.mIsScreenOn = true;
        this.mIsForeground = true;
        lazy = LazyKt__LazyJVMKt.lazy(ShortVideoPreDownloader$mMainScope$2.INSTANCE);
        this.mMainScope = lazy;
        this.mOpenVideoPreDownloadRunnable = new Runnable() { // from class: com.tencent.qqnt.aio.predownload.video.c
            @Override // java.lang.Runnable
            public final void run() {
                ShortVideoPreDownloader.z(ShortVideoPreDownloader.this);
            }
        };
    }

    private final void A() {
        this.mLocalVideoPreDownloadSwitch.set(true);
        QLog.d(n(), 1, "[openVideoPreDownload]");
        i();
    }

    private final void B(ShortVideoMsgItem msgItem) {
        if (QLog.isColorLevel()) {
            QLog.d(n(), 2, "[productFromMsg] msgId=" + msgItem.getMsgId() + " md5=" + msgItem.H2());
        }
        com.tencent.qqnt.aio.predownload.video.strategy.g gVar = com.tencent.qqnt.aio.predownload.video.strategy.g.f351871a;
        gVar.f(msgItem, false, new b(msgItem));
        gVar.c(msgItem, false, new c(msgItem));
    }

    private final void C() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.predownload.video.b
            @Override // java.lang.Runnable
            public final void run() {
                ShortVideoPreDownloader.D(ShortVideoPreDownloader.this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(ShortVideoPreDownloader this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!TextUtils.isEmpty(MobileQQ.sMobileQQ.peekAppRuntime().getAccount())) {
            this$0.g();
            this$0.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ShortVideoPreDownloader this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<com.tencent.qqnt.aio.predownload.video.req.b> it = this$0.mPendingThumbDownloadQueue.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.aio.predownload.video.req.b thumbDownloadReq = it.next();
            Intrinsics.checkNotNullExpressionValue(thumbDownloadReq, "thumbDownloadReq");
            this$0.y(thumbDownloadReq);
        }
        this$0.mPendingThumbDownloadQueue.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ShortVideoPreDownloader this$0, com.tencent.qqnt.aio.predownload.video.req.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        if (QLog.isColorLevel()) {
            QLog.d(this$0.n(), 2, "[consumeShortVideo] msgId=" + it.m().getMsgId() + " start pre download short video.");
        }
        this$0.x(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ShortVideoPreDownloader this$0, ShortVideoMsgItem msgItem, com.tencent.qqnt.aio.predownload.video.req.b thumbDownloadReq) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(thumbDownloadReq, "$thumbDownloadReq");
        if (QLog.isColorLevel()) {
            QLog.d(this$0.n(), 2, "[consumeShortVideoThumb] msgId=" + msgItem.getMsgId() + " start download thumb");
        }
        this$0.y(thumbDownloadReq);
    }

    private final boolean m(ShortVideoMsgItem msgItem, int priority) {
        com.tencent.qqnt.aio.predownload.video.req.a aVar;
        Collection<com.tencent.qqnt.aio.predownload.video.req.a> s16;
        if (QLog.isColorLevel()) {
            QLog.d(n(), 2, "[filterShortVideo] msgId=" + msgItem.getMsgId() + " priority= " + priority);
        }
        Integer num = this.mVideoDownloadPriorityMap.get(msgItem.G2());
        boolean z16 = false;
        if (num == null) {
            if (QLog.isColorLevel()) {
                QLog.d(n(), 2, "[filterShortVideo] msgId=" + msgItem.getMsgId() + " msgItem cannot be found in the PriorityMap");
            }
            return false;
        }
        Collection<com.tencent.qqnt.aio.predownload.video.req.a> s17 = s(num.intValue());
        if (s17 == null) {
            if (QLog.isColorLevel()) {
                QLog.d(n(), 2, "[filterShortVideo] msgId=" + msgItem.getMsgId() + " originalRequests == null");
            }
            return false;
        }
        synchronized (s17) {
            aVar = null;
            for (com.tencent.qqnt.aio.predownload.video.req.a aVar2 : s17) {
                if (aVar2.l() == msgItem.getMsgId()) {
                    z16 = true;
                    aVar = aVar2;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z16 && priority > num.intValue()) {
            if (aVar != null && (s16 = s(priority)) != null) {
                aVar.s(aVar.n());
                aVar.t(priority);
                s17.remove(aVar);
                s16.add(aVar);
                this.mVideoDownloadPriorityMap.put(msgItem.G2(), Integer.valueOf(priority));
                if (QLog.isColorLevel()) {
                    QLog.d(n(), 2, "[filterShortVideo] msgId=" + msgItem.getMsgId() + " Updated the short video request");
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(n(), 2, "[filterShortVideo] msgId=" + msgItem.getMsgId() + " No need to update the short video request");
        }
        return z16;
    }

    private final Collection<com.tencent.qqnt.aio.predownload.video.req.a> s(int priority) {
        if (priority != 2) {
            if (priority != 3) {
                if (priority != 5) {
                    if (priority != 6) {
                        if (priority != 7) {
                            return null;
                        }
                        return this.mHandlingVideoDownloadQueue;
                    }
                    return this.mAIOVideoDownloadRequests;
                }
                return this.mC2CVideoDownloadRequests;
            }
            return this.mDiscussionVideoDownloadRequests;
        }
        return this.mGroupVideoDownloadRequests;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ShortVideoPreDownloader this$0, com.tencent.qqnt.aio.predownload.video.req.a videoDownloadReq) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoDownloadReq, "$videoDownloadReq");
        if (this$0.mHandlingVideoDownloadQueue.contains(videoDownloadReq)) {
            this$0.mHandlingVideoDownloadQueue.remove(videoDownloadReq);
            this$0.mHandlingNum.decrementAndGet();
            this$0.mVideoDownloadPriorityMap.remove(videoDownloadReq.i());
            if (QLog.isColorLevel()) {
                QLog.d(this$0.n(), 2, "[preDownloadNextVideo] msgId=" + videoDownloadReq.l() + " ,curHandingNum = " + this$0.mHandlingNum.get());
            }
            this$0.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ShortVideoPreDownloader this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.mLocalVideoPreDownloadSwitch.get()) {
            this$0.mLocalVideoPreDownloadSwitch.set(true);
            if (QLog.isColorLevel()) {
                QLog.d(this$0.n(), 2, "[OpenVideoPreDownloadRunnable]");
            }
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(n(), 2, "[consumeAllThumbsInPendingQueue] isScreenOn=" + this.mIsScreenOn + " mIsForeground=" + this.mIsForeground);
        }
        if (this.mIsScreenOn && this.mIsForeground) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.predownload.video.d
                @Override // java.lang.Runnable
                public final void run() {
                    ShortVideoPreDownloader.h(ShortVideoPreDownloader.this);
                }
            }, 5, null, false);
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (!this.mLocalVideoPreDownloadSwitch.get()) {
            QLog.d(n(), 1, "[consumeShortVideo] mLocalVideoPreDownloadSwitch is close.");
            return;
        }
        if (this.mIsScreenOn && this.mIsForeground) {
            int i3 = this.mHandlingNum.get();
            if (i3 >= 1) {
                if (QLog.isColorLevel()) {
                    QLog.d(n(), 2, "[consumeShortVideo] handlingNum(" + i3 + ") >= MAX_HANDLING_THREADS(1)");
                    return;
                }
                return;
            }
            final com.tencent.qqnt.aio.predownload.video.req.a t16 = t();
            if (t16 != null) {
                this.mVideoDownloadPriorityMap.remove(t16.i());
                this.mHandlingVideoDownloadQueue.add(t16);
                t16.s(t16.n());
                t16.t(7);
                this.mVideoDownloadPriorityMap.put(t16.i(), 7);
                this.mHandlingNum.addAndGet(1);
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.predownload.video.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ShortVideoPreDownloader.j(ShortVideoPreDownloader.this, t16);
                    }
                }, 5, null, false);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(n(), 2, "[consumeShortVideo] no need to preDownload. mIsScreenOn=" + this.mIsScreenOn + ", mIsForeground= " + this.mIsForeground);
        }
    }

    public final void k(@NotNull final ShortVideoMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String D2 = msgItem.D2();
        if (FileUtils.fileExistsAndNotEmpty(D2)) {
            if (QLog.isColorLevel()) {
                QLog.d(n(), 2, "[consumeShortVideoThumb] msgId=" + msgItem.getMsgId() + " " + D2 + " exists");
                return;
            }
            return;
        }
        final com.tencent.qqnt.aio.predownload.video.req.b bVar = new com.tencent.qqnt.aio.predownload.video.req.b(msgItem);
        if (this.mIsScreenOn && this.mIsForeground) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.predownload.video.e
                @Override // java.lang.Runnable
                public final void run() {
                    ShortVideoPreDownloader.l(ShortVideoPreDownloader.this, msgItem, bVar);
                }
            }, 5, null, false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(n(), 2, "[consumeShortVideoThumb] msgId=" + msgItem.getMsgId() + " no need to preDownload. mIsScreenOn=" + this.mIsScreenOn + ", mIsForeground= " + this.mIsForeground);
        }
        this.mPendingThumbDownloadQueue.add(bVar);
    }

    @NotNull
    public String n() {
        throw null;
    }

    @NotNull
    public final List<com.tencent.qqnt.aio.predownload.video.req.a> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mAIOVideoDownloadRequests;
    }

    @Override // kv3.a
    public void onCreate(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) appRuntime);
        } else {
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            com.tencent.qqnt.aio.predownload.video.strategy.g.f351871a.e();
        }
    }

    @Override // kv3.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(n(), 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY, (Throwable) null);
        }
        Handler handler = this.mSubHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mOpenVideoPreDownloadRunnable);
            this.mSubHandler = null;
        }
    }

    @Override // kv3.a
    public void onGetOfflineMessageFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            A();
        }
    }

    @Override // kv3.a
    public void onMsgReceive(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) msgList);
            return;
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        ArrayList<com.tencent.aio.data.msglist.a> arrayList = new ArrayList();
        Iterator<T> it = msgList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) next;
            if (!(aVar instanceof ShortVideoMsgItem) || ((ShortVideoMsgItem) aVar).getMsgRecord().msgType != 7) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            if (QLog.isColorLevel()) {
                QLog.d(n(), 2, "[onMsgReceive] size=" + arrayList.size());
            }
            for (com.tencent.aio.data.msglist.a aVar2 : arrayList) {
                Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.ShortVideoMsgItem");
                B((ShortVideoMsgItem) aVar2);
            }
        }
    }

    @Override // kv3.a
    public void onNetworkConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        }
    }

    @Override // kv3.a
    public void onProcessBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NT_ShortVideoPreDownloader", 2, "onProcessBackground");
        }
        this.mIsForeground = false;
    }

    @Override // kv3.a
    public void onProcessForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NT_ShortVideoPreDownloader", 2, "onProcessForeground");
        }
        this.mIsForeground = true;
        C();
    }

    @Override // kv3.a
    public void onScreenStateChange(boolean isScreenOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, isScreenOn);
            return;
        }
        this.mIsScreenOn = isScreenOn;
        if (isScreenOn) {
            C();
        }
    }

    @NotNull
    public final List<com.tencent.qqnt.aio.predownload.video.req.a> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mC2CVideoDownloadRequests;
    }

    @NotNull
    public final List<com.tencent.qqnt.aio.predownload.video.req.a> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mDiscussionVideoDownloadRequests;
    }

    @NotNull
    public final List<com.tencent.qqnt.aio.predownload.video.req.a> r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mGroupVideoDownloadRequests;
    }

    @Nullable
    public com.tencent.qqnt.aio.predownload.video.req.a t() {
        throw null;
    }

    public void u(@NotNull final com.tencent.qqnt.aio.predownload.video.req.a videoDownloadReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) videoDownloadReq);
        } else {
            Intrinsics.checkNotNullParameter(videoDownloadReq, "videoDownloadReq");
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.predownload.video.f
                @Override // java.lang.Runnable
                public final void run() {
                    ShortVideoPreDownloader.v(ShortVideoPreDownloader.this, videoDownloadReq);
                }
            }, 8, null, false);
        }
    }

    public final void w(@NotNull ShortVideoMsgItem msgItem, int priority) {
        boolean z16;
        List<com.tencent.qqnt.aio.predownload.video.req.a> list;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) msgItem, priority);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (QLog.isColorLevel()) {
            QLog.d(n(), 2, "[handleShortVideo] msgId=" + msgItem.getMsgId() + " START priority=" + priority);
        }
        if (FileUtils.fileExistsAndNotEmpty(msgItem.I2())) {
            if (QLog.isColorLevel()) {
                QLog.d(n(), 2, "[handleShortVideo] msgId=" + msgItem.getMsgId() + " Video has already existed.");
                return;
            }
            return;
        }
        if (m(msgItem, priority)) {
            if (QLog.isColorLevel()) {
                QLog.d(n(), 2, "[handleShortVideo] msgId=" + msgItem.getMsgId() + " skip priority=" + priority);
                return;
            }
            return;
        }
        com.tencent.qqnt.aio.predownload.video.req.a aVar = new com.tencent.qqnt.aio.predownload.video.req.a(msgItem);
        if (msgItem.E2().busiType != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.v(z16);
        int p06 = msgItem.p0();
        if (priority != 1) {
            if (priority != 6) {
                list = null;
                str = "";
            } else {
                list = this.mAIOVideoDownloadRequests;
                aVar.t(6);
                if (p06 != 1) {
                    if (p06 != 3) {
                        aVar.s(2);
                    } else {
                        aVar.s(3);
                    }
                } else {
                    aVar.s(5);
                }
                str = "AIOVideoDownloadRequests";
            }
        } else if (p06 != 1) {
            if (p06 != 3) {
                list = this.mGroupVideoDownloadRequests;
                aVar.t(2);
                aVar.s(aVar.n());
                str = "GroupVideoDownloadRequests";
            } else {
                list = this.mDiscussionVideoDownloadRequests;
                aVar.t(3);
                aVar.s(aVar.n());
                str = "DiscussionVideoDownloadRequests";
            }
        } else {
            list = this.mC2CVideoDownloadRequests;
            aVar.t(5);
            aVar.s(aVar.n());
            str = "C2CVideoDownloadRequests";
        }
        QLog.d(n(), 1, "[handleShortVideo] msgId=" + msgItem.getMsgId() + " try to add the short video request to " + str);
        if (list != null) {
            list.add(aVar);
            this.mVideoDownloadPriorityMap.put(aVar.i(), Integer.valueOf(aVar.n()));
        }
        i();
    }

    public void x(@NotNull com.tencent.qqnt.aio.predownload.video.req.a videoDownloadReq) {
        throw null;
    }

    public void y(@NotNull com.tencent.qqnt.aio.predownload.video.req.b thumbDownloadReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) thumbDownloadReq);
            return;
        }
        Intrinsics.checkNotNullParameter(thumbDownloadReq, "thumbDownloadReq");
        if (QLog.isColorLevel()) {
            QLog.d("NT_ShortVideoPreDownloader", 2, "[launchShortVideoThumbDownloadRequest] msgId=" + thumbDownloadReq.a());
        }
        thumbDownloadReq.b().r2(false);
    }
}
