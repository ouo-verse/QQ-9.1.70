package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.o;
import com.tencent.mobileqq.guild.data.p;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$serviceListener$2;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.feed.util.bg;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ij1.GuildMediaUploadTaskInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0013*\u0002z~\u0018\u0000 \u008f\u00012\u00020\u0001:\u0001RB$\u0012\u0007\u0010\u008c\u0001\u001a\u00020\u0012\u0012\u0006\u0010T\u001a\u00020Q\u0012\b\b\u0002\u0010Y\u001a\u00020%\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005H\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J&\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J6\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u0002J,\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00122\n\u0010\u001c\u001a\u00060\u0013j\u0002`\u0014H\u0002J\"\u0010\"\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010!\u001a\f\u0012\b\u0012\u00060\u001fj\u0002` 0\u001eH\u0002J \u0010$\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u001b\u001a\u00020\u00122\n\u0010#\u001a\u00060\u0013j\u0002`\u0014H\u0002J\u0018\u0010(\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0002J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0002J \u0010,\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010+\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020'H\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J \u0010/\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0018\u00102\u001a\u0004\u0018\u00010\u000b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b00H\u0002J\u0018\u00103\u001a\u00020\u0012*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020*0\u0011H\u0002J\u0010\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020%H\u0002J\b\u00106\u001a\u00020\u0007H\u0002J\u0012\u00109\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u000107H\u0002J\b\u0010:\u001a\u00020\u0007H\u0002J\u001c\u0010>\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00122\n\u0010=\u001a\u00060;j\u0002`<H\u0016J,\u0010B\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00122\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u00060;j\u0002`<0\u0011j\u0002`@H\u0016J\u001a\u0010D\u001a\u00020\u00072\u0010\u0010C\u001a\f\u0012\b\u0012\u00060\u001fj\u0002` 0\u001eH\u0016J\u0018\u0010G\u001a\u00020\u00072\u000e\u00108\u001a\n\u0018\u00010Ej\u0004\u0018\u0001`FH\u0016J#\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010L\u001a\u00020\u00072\u0006\u0010K\u001a\u00020JH\u0016J\u001b\u0010N\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020%H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bN\u0010OJ\b\u0010P\u001a\u00020\u0007H\u0016R\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\"\u0010Y\u001a\u00020%8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u0010\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010\\\u001a\u00020%8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010\u0010\u001a\u0004\b[\u0010V\"\u0004\bR\u0010XR\u0014\u0010^\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010]R\u0014\u0010a\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010`R \u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020*0b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010cR\u0014\u0010g\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010fR\u0016\u0010h\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010\u0010R\u0014\u0010k\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010jR\u001b\u0010q\u001a\u00020l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\u001e\u0010s\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010rR\u001e\u0010v\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010y\u001a\u00020w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010\rR\u0014\u0010}\u001a\u00020z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u001e\u0010\u0082\u0001\u001a\u00020~8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b\u007f\u0010n\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0085\u0001\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001d\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00168BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R&\u0010\u008a\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00118VX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\bZ\u0010\u0089\u0001R\u0015\u0010\u008b\u0001\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bm\u0010V\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0090\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/FeedMediaUploadTask;", "Lin1/c;", "", "seq", "Lcom/tencent/mobileqq/guild/data/o;", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediumUploadTaskInfo;", "taskInfo", "", "N", "K", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/h;", "continuation", "J", "Lkotlin/coroutines/Continuation;", "mediaUploadResult", "Z", "", "", "Lcom/tencent/mobileqq/guild/data/g;", "Lcom/tencent/mobileqq/guild/feed/publish/api/InternalLocalMediumModel;", "added", "", "removed", "I", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedMediaUploadServiceApi;", "service", "fileId", "mediumModel", "W", "", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/j;", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediumUploadRestoreInfo;", "restoreList", "Y", "model", "U", "", "isRetryFail", "Lkotlinx/coroutines/Job;", "e0", "f0", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/i;", "wrapper", "a0", "X", "M", "g0", "Lkotlinx/coroutines/Deferred;", "deferred", "P", "d0", "parentTaskAllowPreUpload", "b0", "c0", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "V", "L", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/feed/publish/api/QQAlbumMediumModel;", "medium", "f", "source", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediaSelected;", "mediaSelected", tl.h.F, "restoreInfoList", "e", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancel", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/api/h;", "listener", "b", "retryIfFailNow", "k", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/ParentTaskContext;", "a", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/ParentTaskContext;", "parentTaskContext", "i", "()Z", "g", "(Z)V", "isEnablePreUpload", "c", "T", "isPreUploadGuardByNetworkCondition", "Ljava/lang/String;", "logTag", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "opSeq", "Ljava/util/concurrent/ConcurrentMap;", "Ljava/util/concurrent/ConcurrentMap;", "taskInfoWrapperMap", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/e;", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/e;", "notifier", "notifyCanceled", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "serialDispatcher", "Lkotlinx/coroutines/CoroutineScope;", "j", "Lkotlin/Lazy;", BdhLogUtil.LogTag.Tag_Req, "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/Deferred;", "deferredResult", "l", "Lkotlinx/coroutines/CancellableContinuation;", "awaitContinuation", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "startTime", "com/tencent/mobileqq/guild/feed/publish/publishV2/taskx/FeedMediaUploadTask$b", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/FeedMediaUploadTask$b;", "netStateListener", "com/tencent/mobileqq/guild/feed/publish/publishV2/taskx/FeedMediaUploadTask$serviceListener$2$1", "o", ExifInterface.LATITUDE_SOUTH, "()Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/FeedMediaUploadTask$serviceListener$2$1;", "serviceListener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Ljava/lang/String;", "parentId", "O", "()Ljava/util/Set;", "mediaIds", "()Ljava/util/Map;", "taskInfoMap", "isAwaiting", "moduleLogTag", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/ParentTaskContext;Z)V", "p", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedMediaUploadTask implements in1.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ParentTaskContext parentTaskContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isEnablePreUpload;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isPreUploadGuardByNetworkCondition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger opSeq;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentMap<String, i> taskInfoWrapperMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e notifier;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean notifyCanceled;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineDispatcher serialDispatcher;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scope;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Deferred<h> deferredResult;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile CancellableContinuation<? super h> awaitContinuation;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b netStateListener;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy serviceListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\u0006\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/publish/publishV2/taskx/FeedMediaUploadTask$b", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/m;", "", "b", "a", "", "d", "Z", "c", "()Z", "(Z)V", "isRegistered", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends m {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isRegistered;

        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.m
        public void a() {
            boolean j3 = FeedMediaUploadTask.this.j();
            QLog.d(FeedMediaUploadTask.this.logTag, 4, "[onMobileNetworkConnected]: " + FeedMediaUploadTask.this.Q() + " isPreUploadGuardByNetworkCondition=" + FeedMediaUploadTask.this.getIsPreUploadGuardByNetworkCondition() + " isAwaiting=" + j3);
            if (!j3 && FeedMediaUploadTask.this.getIsEnablePreUpload() && FeedMediaUploadTask.this.getIsPreUploadGuardByNetworkCondition()) {
                FeedMediaUploadTask.this.X();
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.m
        public void b() {
            boolean j3 = FeedMediaUploadTask.this.j();
            int andIncrement = FeedMediaUploadTask.this.opSeq.getAndIncrement();
            QLog.d(FeedMediaUploadTask.this.logTag, 1, "[onWifiConnected](" + andIncrement + "): " + FeedMediaUploadTask.this.Q() + ", isPreUploadGuardByNetworkCondition=" + FeedMediaUploadTask.this.getIsPreUploadGuardByNetworkCondition() + " isAwaiting=" + j3);
            if (!j3 && FeedMediaUploadTask.this.getIsEnablePreUpload()) {
                FeedMediaUploadTask.this.e0(andIncrement, false);
            }
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsRegistered() {
            return this.isRegistered;
        }

        public final void d(boolean z16) {
            this.isRegistered = z16;
        }
    }

    public FeedMediaUploadTask(@NotNull String moduleLogTag, @NotNull ParentTaskContext parentTaskContext, boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(moduleLogTag, "moduleLogTag");
        Intrinsics.checkNotNullParameter(parentTaskContext, "parentTaskContext");
        this.parentTaskContext = parentTaskContext;
        this.isEnablePreUpload = z16;
        this.isPreUploadGuardByNetworkCondition = true;
        String str = moduleLogTag + ".MediaUploadTask";
        this.logTag = str;
        this.opSeq = new AtomicInteger(0);
        this.taskInfoWrapperMap = new ConcurrentHashMap();
        e eVar = new e(str, Q());
        eVar.i(new f(parentTaskContext));
        this.notifier = eVar;
        this.notifyCanceled = true;
        this.serialDispatcher = ae.b(ae.a().c());
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$scope$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineScope invoke() {
                CoroutineDispatcher coroutineDispatcher;
                coroutineDispatcher = FeedMediaUploadTask.this.serialDispatcher;
                final CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
                final FeedMediaUploadTask feedMediaUploadTask = FeedMediaUploadTask.this;
                SupervisorJob$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$scope$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Throwable th5) {
                        if (CompletableJob.this.isCancelled()) {
                            feedMediaUploadTask.V(th5);
                        }
                    }
                });
                return CoroutineScopeKt.CoroutineScope(coroutineDispatcher.plus(SupervisorJob$default));
            }
        });
        this.scope = lazy;
        this.netStateListener = new b();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FeedMediaUploadTask$serviceListener$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$serviceListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$serviceListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                return new com.tencent.mobileqq.guild.feed.api.h() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$serviceListener$2.1

                    /* renamed from: a, reason: collision with root package name */
                    private final /* synthetic */ e f223108a;

                    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
                    @NotNull
                    private final Channel<o> taskInfoChangeChannel;

                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$serviceListener$2$1$1", f = "FeedMediaUploadTask.kt", i = {0}, l = {979}, m = "invokeSuspend", n = {"$this$consume$iv$iv"}, s = {"L$1"})
                    /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$serviceListener$2$1$1, reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes13.dex */
                    static final class C77761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        int label;
                        final /* synthetic */ FeedMediaUploadTask this$1;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C77761(FeedMediaUploadTask feedMediaUploadTask, Continuation<? super C77761> continuation) {
                            super(2, continuation);
                            this.this$1 = feedMediaUploadTask;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new C77761(this.this$1, continuation);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:11:0x0058 A[Catch: all -> 0x00dd, TryCatch #2 {all -> 0x00dd, blocks: (B:9:0x0050, B:11:0x0058, B:13:0x0074, B:21:0x00bc, B:23:0x00c5, B:24:0x00c8), top: B:8:0x0050 }] */
                        /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[RETURN] */
                        /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
                        /* JADX WARN: Removed duplicated region for block: B:25:0x00d6  */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0049 -> B:8:0x0050). Please report as a decompilation issue!!! */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended;
                            ReceiveChannel receiveChannel;
                            ChannelIterator it;
                            FeedMediaUploadTask feedMediaUploadTask;
                            C77761 c77761;
                            Object hasNext;
                            Set O;
                            e eVar;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i3 = this.label;
                            try {
                                if (i3 != 0) {
                                    if (i3 == 1) {
                                        ChannelIterator channelIterator = (ChannelIterator) this.L$2;
                                        ReceiveChannel receiveChannel2 = (ReceiveChannel) this.L$1;
                                        FeedMediaUploadTask feedMediaUploadTask2 = (FeedMediaUploadTask) this.L$0;
                                        ResultKt.throwOnFailure(obj);
                                        FeedMediaUploadTask feedMediaUploadTask3 = feedMediaUploadTask2;
                                        ReceiveChannel receiveChannel3 = receiveChannel2;
                                        ChannelIterator channelIterator2 = channelIterator;
                                        Object obj2 = coroutine_suspended;
                                        C77761 c777612 = this;
                                        try {
                                            if (!((Boolean) obj).booleanValue()) {
                                                o oVar = (o) channelIterator2.next();
                                                int andIncrement = feedMediaUploadTask3.opSeq.getAndIncrement();
                                                O = feedMediaUploadTask3.O();
                                                if (!O.contains(oVar.getFileId())) {
                                                    QLog.w(feedMediaUploadTask3.logTag, 4, "[onTaskChange](" + andIncrement + "): parentId=" + feedMediaUploadTask3.Q() + ", mediumId=" + oVar.getFileId() + ", info=" + p.a(oVar) + " isn't exist in upload collection record, ignore notification");
                                                } else {
                                                    feedMediaUploadTask3.N(andIncrement, oVar);
                                                    if (feedMediaUploadTask3.j()) {
                                                        feedMediaUploadTask3.K(andIncrement, oVar);
                                                    }
                                                    eVar = feedMediaUploadTask3.notifier;
                                                    eVar.a(oVar);
                                                }
                                                c77761 = c777612;
                                                coroutine_suspended = obj2;
                                                it = channelIterator2;
                                                receiveChannel = receiveChannel3;
                                                feedMediaUploadTask = feedMediaUploadTask3;
                                                c77761.L$0 = feedMediaUploadTask;
                                                c77761.L$1 = receiveChannel;
                                                c77761.L$2 = it;
                                                c77761.label = 1;
                                                hasNext = it.hasNext(c77761);
                                                if (hasNext != coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                Object obj3 = coroutine_suspended;
                                                c777612 = c77761;
                                                obj = hasNext;
                                                feedMediaUploadTask3 = feedMediaUploadTask;
                                                receiveChannel3 = receiveChannel;
                                                channelIterator2 = it;
                                                obj2 = obj3;
                                                if (!((Boolean) obj).booleanValue()) {
                                                    ChannelsKt.cancelConsumed(receiveChannel3, null);
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            receiveChannel = receiveChannel3;
                                            try {
                                                throw th;
                                            } catch (Throwable th6) {
                                                ChannelsKt.cancelConsumed(receiveChannel, th);
                                                throw th6;
                                            }
                                        }
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                    receiveChannel = AnonymousClass1.this.taskInfoChangeChannel;
                                    FeedMediaUploadTask feedMediaUploadTask4 = this.this$1;
                                    it = receiveChannel.iterator();
                                    feedMediaUploadTask = feedMediaUploadTask4;
                                    c77761 = this;
                                    c77761.L$0 = feedMediaUploadTask;
                                    c77761.L$1 = receiveChannel;
                                    c77761.L$2 = it;
                                    c77761.label = 1;
                                    hasNext = it.hasNext(c77761);
                                    if (hasNext != coroutine_suspended) {
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((C77761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    {
                        e eVar2;
                        CoroutineScope R;
                        eVar2 = FeedMediaUploadTask.this.notifier;
                        this.f223108a = eVar2;
                        this.taskInfoChangeChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, new Function1<o, Unit>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$serviceListener$2$1$taskInfoChangeChannel$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(o oVar) {
                                invoke2(oVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull o it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.w(FeedMediaUploadTask.this.logTag, 1, "[onUndeliveredElement]: " + FeedMediaUploadTask.this.Q() + ", info=" + p.a(it));
                            }
                        }, 2, null);
                        R = FeedMediaUploadTask.this.R();
                        BuildersKt__Builders_commonKt.launch$default(R, null, null, new C77761(FeedMediaUploadTask.this, null), 3, null);
                    }

                    @Override // com.tencent.mobileqq.guild.feed.api.h, com.tencent.mobileqq.guild.feed.api.f
                    public void a(@NotNull o info) {
                        Intrinsics.checkNotNullParameter(info, "info");
                        if (p.c(info)) {
                            QLog.d(FeedMediaUploadTask.this.logTag, 1, "[onTaskChange]: parentId=" + FeedMediaUploadTask.this.Q() + ", info=" + p.a(info));
                        }
                        Object mo2003trySendJP2dKIU = this.taskInfoChangeChannel.mo2003trySendJP2dKIU(info);
                        FeedMediaUploadTask feedMediaUploadTask = FeedMediaUploadTask.this;
                        if (mo2003trySendJP2dKIU instanceof ChannelResult.Failed) {
                            Throwable m2012exceptionOrNullimpl = ChannelResult.m2012exceptionOrNullimpl(mo2003trySendJP2dKIU);
                            QLog.w(feedMediaUploadTask.logTag, 4, "[onTaskChange]: parentId=" + feedMediaUploadTask.Q() + ", trySend failure, info.id=" + info.getFileId() + " throwable=" + m2012exceptionOrNullimpl);
                        }
                    }

                    @Override // com.tencent.mobileqq.guild.feed.api.h
                    public void b(@NotNull String mediumId, @NotNull o info) {
                        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
                        Intrinsics.checkNotNullParameter(info, "info");
                        this.f223108a.b(mediumId, info);
                    }

                    @Override // com.tencent.mobileqq.guild.feed.api.h
                    public void c(@NotNull String mediumId, long uploadedSize, long totalSize, @NotNull o info) {
                        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
                        Intrinsics.checkNotNullParameter(info, "info");
                        this.f223108a.c(mediumId, uploadedSize, totalSize, info);
                    }

                    @Override // com.tencent.mobileqq.guild.feed.api.h
                    public void d(@NotNull String mediumId, @NotNull o info) {
                        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
                        Intrinsics.checkNotNullParameter(info, "info");
                        this.f223108a.d(mediumId, info);
                    }

                    @Override // com.tencent.mobileqq.guild.feed.api.h
                    public void e(@NotNull String mediumId, @NotNull o info) {
                        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
                        Intrinsics.checkNotNullParameter(info, "info");
                        this.f223108a.e(mediumId, info);
                    }

                    @Override // com.tencent.mobileqq.guild.feed.api.h
                    public void f(@NotNull String mediumId, @NotNull o info) {
                        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
                        Intrinsics.checkNotNullParameter(info, "info");
                        this.f223108a.f(mediumId, info);
                    }

                    @Override // com.tencent.mobileqq.guild.feed.api.h
                    public void g(@NotNull String mediumId, @NotNull o info) {
                        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
                        Intrinsics.checkNotNullParameter(info, "info");
                        this.f223108a.g(mediumId, info);
                    }

                    @Override // com.tencent.mobileqq.guild.feed.api.h
                    public void h(@NotNull String mediumId, @Nullable o info) {
                        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
                        this.f223108a.h(mediumId, info);
                    }
                };
            }
        });
        this.serviceListener = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(int seq, Map<String, com.tencent.mobileqq.guild.data.g> added, Set<String> removed) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        o oVar;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGuildFeedMediaUploadServiceApi.class, "");
        } else {
            iRuntimeService = null;
        }
        IGuildFeedMediaUploadServiceApi iGuildFeedMediaUploadServiceApi = (IGuildFeedMediaUploadServiceApi) iRuntimeService;
        if (iGuildFeedMediaUploadServiceApi == null) {
            return;
        }
        for (Map.Entry<String, com.tencent.mobileqq.guild.data.g> entry : added.entrySet()) {
            if (entry.getValue().getPath().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && iGuildFeedMediaUploadServiceApi.createUploadMediaTask(entry.getKey(), entry.getValue())) {
                W(seq, iGuildFeedMediaUploadServiceApi, entry.getKey(), entry.getValue());
            } else {
                String str = this.logTag;
                String Q = Q();
                String key = entry.getKey();
                QLog.e(str, 1, "[batchUpdateMediaSelected](" + seq + "): parentId=" + Q + " create or reuse task failed, mediumId=" + ((Object) key) + ", len(path)=" + entry.getValue().getPath().length());
            }
        }
        for (String str2 : removed) {
            if (!iGuildFeedMediaUploadServiceApi.removeUploadMediaTask(str2)) {
                QLog.e(this.logTag, 1, "[batchUpdateMediaSelected](" + seq + "): parentId=" + Q() + " remove task failed, mediumId=" + str2);
            } else {
                iGuildFeedMediaUploadServiceApi.unsubscribeTaskChangeListener(S(), str2);
                e eVar = this.notifier;
                i iVar = this.taskInfoWrapperMap.get(str2);
                if (iVar != null) {
                    oVar = iVar.getReferent();
                } else {
                    oVar = null;
                }
                eVar.h(str2, oVar);
                this.taskInfoWrapperMap.remove(str2);
            }
        }
        QLog.i(this.logTag, 1, "[batchSubmitMediaSelectedInternal](" + seq + "): added.size=" + added.size() + ", removed.size=" + removed.size() + " parentId=" + Q() + " after.size=" + O().size());
    }

    private final void J(int seq, CancellableContinuation<? super h> continuation) {
        int i3;
        int i16;
        int mapCapacity;
        Map map;
        i iVar;
        String str;
        int mapCapacity2;
        int i17;
        o referent;
        String fileId;
        o referent2;
        o referent3;
        i iVar2;
        int mapCapacity3;
        Map map2;
        ConcurrentMap<String, i> concurrentMap = this.taskInfoWrapperMap;
        if (concurrentMap.isEmpty()) {
            i3 = 0;
        } else {
            Iterator<Map.Entry<String, i>> it = concurrentMap.entrySet().iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().getValue().getReferent().e()) {
                    i3++;
                }
            }
        }
        ConcurrentMap<String, i> concurrentMap2 = this.taskInfoWrapperMap;
        if (concurrentMap2.isEmpty()) {
            i16 = 0;
        } else {
            Iterator<Map.Entry<String, i>> it5 = concurrentMap2.entrySet().iterator();
            i16 = 0;
            while (it5.hasNext()) {
                if (it5.next().getValue().getReferent().j()) {
                    i16++;
                }
            }
        }
        if (i3 == this.taskInfoWrapperMap.size()) {
            ConcurrentMap<String, i> concurrentMap3 = this.taskInfoWrapperMap;
            mapCapacity3 = MapsKt__MapsJVMKt.mapCapacity(concurrentMap3.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity3);
            Iterator<T> it6 = concurrentMap3.entrySet().iterator();
            while (it6.hasNext()) {
                Map.Entry entry = (Map.Entry) it6.next();
                linkedHashMap.put(entry.getKey(), ((i) entry.getValue()).getReferent());
            }
            map2 = MapsKt__MapsKt.toMap(linkedHashMap);
            Z(seq, continuation, new h(0, "", map2, 0, null, 16, null));
            return;
        }
        i iVar3 = null;
        if (i16 > 0) {
            Iterator<Map.Entry<String, i>> it7 = this.taskInfoWrapperMap.entrySet().iterator();
            while (true) {
                if (!it7.hasNext()) {
                    break;
                }
                Map.Entry<String, i> next = it7.next();
                if (next.getValue().getReferent().j()) {
                    iVar2 = next.getValue();
                } else {
                    iVar2 = null;
                }
                if (iVar2 != null) {
                    iVar3 = iVar2;
                    break;
                }
            }
            String str2 = "";
            if (iVar3 == null || (referent3 = iVar3.getReferent()) == null || (str = referent3.getErrMsg()) == null) {
                str = "";
            }
            ConcurrentMap<String, i> concurrentMap4 = this.taskInfoWrapperMap;
            mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(concurrentMap4.size());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity2);
            Iterator<T> it8 = concurrentMap4.entrySet().iterator();
            while (it8.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it8.next();
                linkedHashMap2.put(entry2.getKey(), ((i) entry2.getValue()).getReferent());
                str2 = str2;
            }
            String str3 = str2;
            if (iVar3 != null && (referent2 = iVar3.getReferent()) != null) {
                i17 = referent2.getErrCode();
            } else {
                i17 = 0;
            }
            if (iVar3 != null && (referent = iVar3.getReferent()) != null && (fileId = referent.getFileId()) != null) {
                str3 = fileId;
            }
            h hVar = new h(1, str, linkedHashMap2, i17, str3);
            hVar.h("seq=" + seq + ", successCount=" + i3 + ", failCount=" + i16 + ", summary={" + d0(this.taskInfoWrapperMap) + "}");
            Unit unit = Unit.INSTANCE;
            Z(seq, continuation, hVar);
            return;
        }
        Iterator<Map.Entry<String, i>> it9 = this.taskInfoWrapperMap.entrySet().iterator();
        while (true) {
            if (!it9.hasNext()) {
                break;
            }
            Map.Entry<String, i> next2 = it9.next();
            if (next2.getValue().getIsInconsistent()) {
                iVar = next2.getValue();
            } else {
                iVar = null;
            }
            if (iVar != null) {
                iVar3 = iVar;
                break;
            }
        }
        if (iVar3 != null) {
            String inconsistencyMessage = iVar3.getInconsistencyMessage();
            ConcurrentMap<String, i> concurrentMap5 = this.taskInfoWrapperMap;
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(concurrentMap5.size());
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(mapCapacity);
            Iterator<T> it10 = concurrentMap5.entrySet().iterator();
            while (it10.hasNext()) {
                Map.Entry entry3 = (Map.Entry) it10.next();
                linkedHashMap3.put(entry3.getKey(), ((i) entry3.getValue()).getReferent());
            }
            map = MapsKt__MapsKt.toMap(linkedHashMap3);
            h hVar2 = new h(2, inconsistencyMessage, map, 0, iVar3.getReferent().getFileId());
            hVar2.i(iVar3.getReferent());
            hVar2.h("seq=" + seq + ", successCount=" + i3 + ", failCount=" + i16 + ", summary={" + d0(this.taskInfoWrapperMap) + "}");
            Unit unit2 = Unit.INSTANCE;
            Z(seq, continuation, hVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        if (r1 != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(int seq, o taskInfo) {
        boolean z16;
        i iVar;
        int mapCapacity;
        Map map;
        CancellableContinuation<? super h> cancellableContinuation = this.awaitContinuation;
        boolean z17 = false;
        if (cancellableContinuation != null && cancellableContinuation.isActive()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.w(this.logTag, 1, "[fuseTaskChange](" + seq + "): parentId=" + Q() + ", awaitContinuation is not active, but current state is awaiting");
            return;
        }
        if (taskInfo != null) {
            o oVar = null;
            if (!taskInfo.j()) {
                iVar = this.taskInfoWrapperMap.get(taskInfo.getFileId());
                if (iVar != null && iVar.getIsInconsistent()) {
                    z17 = true;
                }
            } else {
                iVar = null;
            }
            String errMsg = taskInfo.getErrMsg();
            ConcurrentMap<String, i> concurrentMap = this.taskInfoWrapperMap;
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(concurrentMap.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            Iterator<T> it = concurrentMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), ((i) entry.getValue()).getReferent());
            }
            map = MapsKt__MapsKt.toMap(linkedHashMap);
            h hVar = new h(1, errMsg, map, taskInfo.getErrCode(), taskInfo.getFileId());
            if (iVar != null) {
                oVar = iVar.getReferent();
            }
            hVar.i(oVar);
            hVar.h("{" + d0(this.taskInfoWrapperMap) + "}");
            Unit unit = Unit.INSTANCE;
            Z(seq, cancellableContinuation, hVar);
            return;
        }
        J(seq, cancellableContinuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        this.deferredResult = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGuildFeedMediaUploadServiceApi.class, "");
        }
        IGuildFeedMediaUploadServiceApi iGuildFeedMediaUploadServiceApi = (IGuildFeedMediaUploadServiceApi) iRuntimeService;
        if (iGuildFeedMediaUploadServiceApi == null) {
            return;
        }
        Iterator<Map.Entry<String, i>> it = this.taskInfoWrapperMap.entrySet().iterator();
        while (it.hasNext()) {
            String fileId = it.next().getKey();
            Intrinsics.checkNotNullExpressionValue(fileId, "fileId");
            if (!iGuildFeedMediaUploadServiceApi.removeUploadMediaTask(fileId)) {
                QLog.w(this.logTag, 1, "[clearTaskInfoMapBothSelfAndService]: remove " + fileId + " failed!");
            }
        }
        this.taskInfoWrapperMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(int seq, o taskInfo) {
        boolean z16;
        if (taskInfo.isCancelled()) {
            QLog.w(this.logTag, 1, "[fuseTaskChangeInfo](" + seq + "): fileId=" + taskInfo.getFileId() + ", task is cancelled");
        }
        i iVar = (i) this.taskInfoWrapperMap.get(taskInfo.getFileId());
        String str = "fuseTaskChange -> task is cancelled";
        if (iVar == null) {
            ConcurrentMap concurrentMap = this.taskInfoWrapperMap;
            String fileId = taskInfo.getFileId();
            i iVar2 = new i(taskInfo);
            iVar2.f(taskInfo.isCancelled());
            if (!iVar2.getIsInconsistent()) {
                str = "";
            }
            iVar2.e(str);
            concurrentMap.put(fileId, iVar2);
        } else {
            iVar.g(taskInfo);
            iVar.f(taskInfo.isCancelled());
            if (!iVar.getIsInconsistent()) {
                str = "";
            }
            iVar.e(str);
        }
        ConcurrentMap<String, i> concurrentMap2 = this.taskInfoWrapperMap;
        if (!concurrentMap2.isEmpty()) {
            Iterator<Map.Entry<String, i>> it = concurrentMap2.entrySet().iterator();
            while (it.hasNext()) {
                if (!it.next().getValue().getReferent().isCompleted()) {
                    z16 = false;
                    break;
                }
            }
        }
        z16 = true;
        if (z16) {
            QLog.i(this.logTag, 1, "[fuseTaskChange](" + seq + "): all tasks are completed,  cost=" + (SystemClock.elapsedRealtime() - this.startTime) + " ms, count=" + this.taskInfoWrapperMap.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> O() {
        return this.taskInfoWrapperMap.keySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h P(Deferred<h> deferred) {
        Object m476constructorimpl;
        Object obj = null;
        if (!deferred.isCancelled() && !deferred.isCompleted()) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(deferred.getCompleted());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (!Result.m482isFailureimpl(m476constructorimpl)) {
            obj = m476constructorimpl;
        }
        return (h) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Q() {
        return this.parentTaskContext.getParentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope R() {
        return (CoroutineScope) this.scope.getValue();
    }

    private final FeedMediaUploadTask$serviceListener$2.AnonymousClass1 S() {
        return (FeedMediaUploadTask$serviceListener$2.AnonymousClass1) this.serviceListener.getValue();
    }

    private final o U(String fileId, com.tencent.mobileqq.guild.data.g model) {
        long j3;
        int i3;
        long j16 = 0;
        if (model.getFileSize() != 0) {
            j3 = model.getFileSize();
        } else {
            try {
                j16 = new File(model.getPath()).length();
            } catch (Exception unused) {
            }
            j3 = j16;
        }
        com.tencent.mobileqq.guild.util.i iVar = com.tencent.mobileqq.guild.util.i.f235563a;
        if (iVar.f(model)) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        int i16 = i3;
        String a16 = bg.f223884a.a(model.getPath());
        if (a16 == null) {
            a16 = "";
        }
        return new GuildMediaUploadTaskInfo(fileId, -1000, i16, null, null, 0, null, 0, null, 0L, null, 0, null, null, 0L, 0L, 0L, j3, a16, model.getIsRaw(), iVar.d(model), model, 131064, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(Throwable cause) {
        AppInterface appInterface;
        QLog.i(this.logTag, 1, "[onCancelCleanUp]: parentId=" + Q() + ", cause=" + cause + " notifyCanceled=" + this.notifyCanceled);
        c0();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGuildFeedMediaUploadServiceApi.class, "");
        }
        IGuildFeedMediaUploadServiceApi iGuildFeedMediaUploadServiceApi = (IGuildFeedMediaUploadServiceApi) iRuntimeService;
        if (iGuildFeedMediaUploadServiceApi != null) {
            iGuildFeedMediaUploadServiceApi.unsubscribeAllTaskChangeListener(S());
            Iterator<T> it = O().iterator();
            while (it.hasNext()) {
                iGuildFeedMediaUploadServiceApi.removeUploadMediaTask((String) it.next());
            }
        }
        if (this.notifyCanceled && (!O().isEmpty()) && this.notifier.j() && !(cause instanceof PassiveCancellationException)) {
            for (Map.Entry<String, i> entry : this.taskInfoWrapperMap.entrySet()) {
                String id5 = entry.getKey();
                i value = entry.getValue();
                e eVar = this.notifier;
                Intrinsics.checkNotNullExpressionValue(id5, "id");
                eVar.h(id5, value.getReferent());
            }
        }
    }

    private final void W(int seq, IGuildFeedMediaUploadServiceApi service, String fileId, com.tencent.mobileqq.guild.data.g mediumModel) {
        service.subscribeTaskChangeListener(S(), fileId);
        this.taskInfoWrapperMap.put(fileId, new i(U(fileId, mediumModel)));
        g0(seq, service, fileId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job X() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(R(), null, null, new FeedMediaUploadTask$pauseAllTask$1(this, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(int seq, List<MediumUploadStateRestoreInfo> restoreList) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        String str;
        QLog.i(this.logTag, 1, "[restoreMediaSelectedInternal](" + seq + "):parentId=" + Q() + ", restoreList=" + restoreList.size());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGuildFeedMediaUploadServiceApi.class, "");
        } else {
            iRuntimeService = null;
        }
        IGuildFeedMediaUploadServiceApi iGuildFeedMediaUploadServiceApi = (IGuildFeedMediaUploadServiceApi) iRuntimeService;
        if (iGuildFeedMediaUploadServiceApi == null) {
            return;
        }
        for (MediumUploadStateRestoreInfo mediumUploadStateRestoreInfo : restoreList) {
            if (!iGuildFeedMediaUploadServiceApi.restoreUploadMediaTask(mediumUploadStateRestoreInfo.getFileId(), mediumUploadStateRestoreInfo.getLocalMediumInfo(), mediumUploadStateRestoreInfo.getMetaPersistentObject())) {
                String str2 = this.logTag;
                String Q = Q();
                String fileId = mediumUploadStateRestoreInfo.getFileId();
                o taskInfo = mediumUploadStateRestoreInfo.getTaskInfo();
                if (taskInfo != null) {
                    str = p.a(taskInfo);
                } else {
                    str = null;
                }
                QLog.e(str2, 1, "[restoreMediaSelectedInternal](" + seq + "): restore failed parentId=" + Q + ", fileId=" + fileId + ", taskInfo=" + str);
            }
            W(seq, iGuildFeedMediaUploadServiceApi, mediumUploadStateRestoreInfo.getFileId(), mediumUploadStateRestoreInfo.getLocalMediumInfo());
        }
    }

    private final void Z(int seq, Continuation<? super h> continuation, h mediaUploadResult) {
        QLog.i(this.logTag, 1, "[resumeAwait](" + seq + "): result=" + mediaUploadResult);
        continuation.resumeWith(Result.m476constructorimpl(mediaUploadResult));
        this.awaitContinuation = null;
    }

    private final void a0(int seq, IGuildFeedMediaUploadServiceApi service, i wrapper) {
        int i3;
        String str;
        o referent = wrapper.getReferent();
        String fileId = referent.getFileId();
        com.tencent.mobileqq.guild.data.g localMediaInfo = referent.getLocalMediaInfo();
        if (service.removeUploadMediaTask(fileId)) {
            if (localMediaInfo != null && service.createUploadMediaTask(fileId, localMediaInfo)) {
                ConcurrentMap<String, i> concurrentMap = this.taskInfoWrapperMap;
                wrapper.g(U(fileId, localMediaInfo));
                concurrentMap.put(fileId, wrapper);
                if (!service.resumeUploadMediaTask(fileId)) {
                    wrapper.f(true);
                    wrapper.e("retryTaskInternal(" + seq + ") -> resume task failed");
                    i3 = 2;
                } else {
                    wrapper.d();
                    i3 = 3;
                }
            } else {
                wrapper.f(true);
                wrapper.e("retryTaskInternal(" + seq + ") -> create task failed, localMedia=" + localMediaInfo);
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        StringBuilder sb5 = new StringBuilder("[retryTask](" + seq + "): parentId=" + Q() + ", ");
        sb5.append("fileId=" + referent.getFileId() + ", execStep=" + i3 + ", ");
        boolean isInconsistent = wrapper.getIsInconsistent();
        StringBuilder sb6 = new StringBuilder();
        sb6.append("wrapper.isInconsistent=");
        sb6.append(isInconsistent);
        sb6.append(", ");
        sb5.append(sb6.toString());
        sb5.append("wrapper.inconsistencyMessage=" + wrapper.getInconsistencyMessage());
        if (3 != i3) {
            String str2 = this.logTag;
            sb5.append(", localMedia=" + localMediaInfo);
            QLog.e(str2, 1, sb5);
            return;
        }
        String str3 = this.logTag;
        if (localMediaInfo != null) {
            str = localMediaInfo.getPath();
        } else {
            str = null;
        }
        sb5.append(", path=" + str);
        QLog.i(str3, 1, sb5.toString());
    }

    private final void b0(boolean parentTaskAllowPreUpload) {
        if (!getIsEnablePreUpload() || !getIsPreUploadGuardByNetworkCondition() || !parentTaskAllowPreUpload || this.netStateListener.getIsRegistered()) {
            return;
        }
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.context, this.netStateListener);
        this.netStateListener.d(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        if (!this.netStateListener.getIsRegistered()) {
            return;
        }
        AppNetConnInfo.unregisterNetInfoHandler(this.netStateListener);
        this.netStateListener.d(false);
    }

    private final String d0(Map<String, i> map) {
        String joinToString$default;
        String joinToString$default2;
        if (map.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, i> entry : map.entrySet()) {
            arrayList.add(Integer.valueOf(entry.getValue().getReferent().getState()));
            arrayList2.add(entry.getKey());
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, "[", "]", 0, null, null, 57, null);
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, null, "[", "]", 0, null, null, 57, null);
        return "states=" + joinToString$default + ", fileIds=" + joinToString$default2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job e0(int seq, boolean isRetryFail) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(R(), null, null, new FeedMediaUploadTask$triggerAllPendingTask$1(this, seq, isRetryFail, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(int seq, boolean isRetryFail) {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGuildFeedMediaUploadServiceApi.class, "");
        }
        IGuildFeedMediaUploadServiceApi iGuildFeedMediaUploadServiceApi = (IGuildFeedMediaUploadServiceApi) iRuntimeService;
        if (iGuildFeedMediaUploadServiceApi == null) {
            return;
        }
        for (String str : O()) {
            i iVar = this.taskInfoWrapperMap.get(str);
            if (iVar == null) {
                QLog.e(this.logTag, 1, "[triggerAllPendingTask](" + seq + "): parentId=" + Q() + ", taskInfo of fileId=" + str + " not found, inconsistency error happen!");
            } else if ((iVar.getReferent().j() || iVar.getIsInconsistent()) && isRetryFail) {
                a0(seq, iGuildFeedMediaUploadServiceApi, iVar);
            } else {
                if (!iGuildFeedMediaUploadServiceApi.resumeUploadMediaTask(str)) {
                    QLog.e(this.logTag, 1, "[triggerAllPendingTask](" + seq + "): resume task[" + str + "] failed");
                    iVar.f(true);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("triggerAllPendingTask(");
                    sb5.append(seq);
                    sb5.append(") -> resume failed");
                    iVar.e(sb5.toString());
                }
                iVar.d();
            }
        }
    }

    private final void g0(int seq, IGuildFeedMediaUploadServiceApi service, String fileId) {
        boolean j3 = j();
        boolean booleanValue = this.parentTaskContext.a().invoke().booleanValue();
        QLog.d(this.logTag, 1, "[triggerResumeIfNeeded](" + seq + "): parentId=" + Q() + ", fileId=" + fileId + ", parentTaskAllowPreUploadNow=" + booleanValue);
        if (!j3) {
            if (getIsEnablePreUpload()) {
                if ((getIsPreUploadGuardByNetworkCondition() && (!getIsPreUploadGuardByNetworkCondition() || !NetworkUtil.isWifiConnected(null))) || !booleanValue) {
                    return;
                }
            } else {
                return;
            }
        }
        b0(booleanValue);
        if (!service.resumeUploadMediaTask(fileId)) {
            QLog.e(this.logTag, 1, "[triggerResumeIfNeeded](" + seq + "): resume failed parentId=" + Q() + ", fileId=" + fileId);
        }
        if (this.startTime == 0) {
            this.startTime = SystemClock.elapsedRealtime();
        }
    }

    /* renamed from: T, reason: from getter */
    public boolean getIsPreUploadGuardByNetworkCondition() {
        return this.isPreUploadGuardByNetworkCondition;
    }

    @Override // in1.c
    public void a(boolean z16) {
        this.isPreUploadGuardByNetworkCondition = z16;
    }

    @Override // in1.c
    public void b(@NotNull com.tencent.mobileqq.guild.feed.api.h listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.notifier.i(listener);
    }

    @Override // in1.c
    @NotNull
    public Map<String, o> c() {
        int mapCapacity;
        ConcurrentMap<String, i> concurrentMap = this.taskInfoWrapperMap;
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(concurrentMap.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = concurrentMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((i) entry.getValue()).getReferent());
        }
        return linkedHashMap;
    }

    @Override // in1.c
    public void cancel(@Nullable CancellationException cause) {
        String str;
        String str2 = this.logTag;
        int andIncrement = this.opSeq.getAndIncrement();
        String Q = Q();
        if (cause != null) {
            str = cause.getMessage();
        } else {
            str = null;
        }
        QLog.i(str2, 1, "[cancel](" + andIncrement + "): parentId=" + Q + ", message=" + str);
        CoroutineScopeKt.cancel(R(), cause);
    }

    @Override // in1.c
    @Nullable
    public Object d(@NotNull Continuation<? super Map<String, ? extends o>> continuation) {
        return BuildersKt.withContext(R().getCoroutineContext(), new FeedMediaUploadTask$getTaskInfoMap$2(this, null), continuation);
    }

    @Override // in1.c
    public void e(@NotNull List<MediumUploadStateRestoreInfo> restoreInfoList) {
        Intrinsics.checkNotNullParameter(restoreInfoList, "restoreInfoList");
        boolean isActive = CoroutineScopeKt.isActive(R());
        int andIncrement = this.opSeq.getAndIncrement();
        QLog.i(this.logTag, 1, "[restoreMediaSelected](" + andIncrement + "): parentId=" + Q() + " restoreInfoList.size=" + restoreInfoList.size() + ", before.size=" + O().size() + ", scope.isActive=" + isActive);
        if (isActive) {
            BuildersKt__Builders_commonKt.launch$default(R(), null, null, new FeedMediaUploadTask$restoreMediaSelected$1(this, andIncrement, restoreInfoList, null), 3, null);
        }
    }

    @Override // in1.c
    public void f(@NotNull String fileId, @NotNull LocalMediaInfo medium) {
        boolean z16;
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(medium, "medium");
        int andIncrement = this.opSeq.getAndIncrement();
        QLog.i(this.logTag, 1, "[submitSingleMedium](" + andIncrement + "): parentId=" + Q() + ", fileId=" + fileId + ", medium.path=" + medium.path + " before.size=" + O().size() + ", scope.isActive=" + CoroutineScopeKt.isActive(R()));
        String str = medium.path;
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (fileId.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                BuildersKt__Builders_commonKt.launch$default(R(), null, null, new FeedMediaUploadTask$submitSingleMedium$1(this, fileId, andIncrement, medium, null), 3, null);
                return;
            }
        }
        QLog.e(this.logTag, 1, "[submitSingleMedium](" + andIncrement + "): fileId=" + fileId + ", medium.path is null!");
    }

    @Override // in1.c
    public void g(boolean z16) {
        this.isEnablePreUpload = z16;
    }

    @Override // in1.c
    public void h(@NotNull String source, @NotNull Map<String, ? extends LocalMediaInfo> mediaSelected) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(mediaSelected, "mediaSelected");
        boolean isActive = CoroutineScopeKt.isActive(R());
        int andIncrement = this.opSeq.getAndIncrement();
        QLog.i(this.logTag, 1, "[batchSubmitMediaSelected](" + andIncrement + "): parentId=" + Q() + ", source=" + source + ", select.size=" + mediaSelected.size() + ", before.size=" + O().size() + ", scope.isActive=" + isActive);
        if (isActive) {
            BuildersKt__Builders_commonKt.launch$default(R(), null, null, new FeedMediaUploadTask$batchSubmitMediaSelected$1(mediaSelected, this, andIncrement, null), 3, null);
        }
    }

    @Override // in1.c
    /* renamed from: i, reason: from getter */
    public boolean getIsEnablePreUpload() {
        return this.isEnablePreUpload;
    }

    @Override // in1.c
    public boolean j() {
        Deferred<h> deferred = this.deferredResult;
        if (deferred == null || deferred.isCompleted() || deferred.isCancelled()) {
            return false;
        }
        return true;
    }

    @Override // in1.c
    @Nullable
    public Object k(boolean z16, @NotNull Continuation<? super h> continuation) {
        return BuildersKt.withContext(R().getCoroutineContext(), new FeedMediaUploadTask$awaitAll$2(this, z16, null), continuation);
    }

    @Override // in1.c
    public void release() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGuildFeedMediaUploadServiceApi.class, "");
        }
        IGuildFeedMediaUploadServiceApi iGuildFeedMediaUploadServiceApi = (IGuildFeedMediaUploadServiceApi) iRuntimeService;
        if (iGuildFeedMediaUploadServiceApi != null) {
            iGuildFeedMediaUploadServiceApi.unsubscribeAllTaskChangeListener(S());
        }
        this.notifyCanceled = false;
        cancel(new CancellationException("release"));
    }
}
