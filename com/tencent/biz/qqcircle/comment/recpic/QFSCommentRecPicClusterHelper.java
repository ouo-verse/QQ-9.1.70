package com.tencent.biz.qqcircle.comment.recpic;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.aw;
import com.tencent.biz.qqcircle.comment.recpic.QFSCommentRecPicClusterHelper;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.biz.qqcircle.events.QFSKMeansResultEvent;
import com.tencent.biz.qqcircle.events.QFSRecPicStateEvent;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wink.api.IWinkWeClipApi;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.model.MediaScanForwardResult;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.BitmapUtil;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.Embedding;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001mB\t\b\u0002\u00a2\u0006\u0004\bk\u0010lJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0016\u0010\u0012\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002JP\u0010!\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001b2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u001fH\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J$\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u001fH\u0002J\u001a\u0010*\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u000bH\u0002J&\u0010.\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u00028\u00000+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0002J\u0016\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00100\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00101\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u00102\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u00103\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00104\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00105\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004J\u0006\u00107\u001a\u00020\u000bJ\u0006\u00108\u001a\u00020\u000bJ\u0010\u00109\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u000bJ\u0010\u0010<\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010'J\u0010\u0010=\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010'J$\u0010A\u001a\u00020\u00072\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010@\u001a\u00020?J(\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0\u0004J\u0006\u0010F\u001a\u00020\u0007J\u001a\u0010K\u001a\u00020J2\b\u0010H\u001a\u0004\u0018\u00010G2\b\u0010I\u001a\u0004\u0018\u00010GR\u0016\u0010M\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u00104R\u0016\u0010O\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u00104R\u0016\u0010Q\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u00104R&\u0010T\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00100U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u00100R\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010i\u00a8\u0006n"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/QFSCommentRecPicClusterHelper;", "", "", "feedId", "", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/c;", "dataList", "", ExifInterface.LATITUDE_SOUTH, "", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "", "L", "Lt20/a;", "scanListener", "T", "Lcom/tencent/biz/qqcircle/comment/recpic/aj;", "safePicList", "l0", "Ljava/lang/ref/WeakReference;", "scanListenerWrf", "P", "D", "safeCount", "unsafeCount", "", "scanStartTime", "", "unsafeIds", "", "unsafeSimilarity", "", "feedMatchInfo", "b0", "Landroid/app/Activity;", "H", "Lcom/tencent/mobileqq/wink/model/MediaScanForwardResult;", "result", "c0", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "isTestDomain", "d0", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/Observer;", "observer", BdhLogUtil.LogTag.Tag_Req, "G", "J", BdhLogUtil.LogTag.Tag_Conn, HippyTKDListViewAdapter.X, UserInfo.SEX_FEMALE, "Z", "X", "I", "K", "M", "O", QQPermissionConstants.Permission.AUIDO_GROUP, "j0", "i0", "g0", "cmtPicList", "Lcom/tencent/biz/qqcircle/comment/recpic/b;", "reportBean", "f0", "picInfoList", "Lcom/tencent/biz/qqcircle/comment/recpic/QFSCommentRecPicClusterHelper$a;", Constants.Configs.CONFIGS, "N", "B", "", "feature1", "feature2", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "b", "isMediaScanning", "c", "isMediaScanned", "d", "isForwarding", "e", "Ljava/util/Map;", "candidatePicMap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", "localPicCacheList", "Lcom/tencent/mobileqq/wink/api/IWinkWeClipApi;", "g", "Lcom/tencent/mobileqq/wink/api/IWinkWeClipApi;", "winkApi", "Li83/h;", tl.h.F, "Li83/h;", "forwardResultListener", "Lcom/tencent/biz/qqcircle/comment/recpic/db/a;", "i", "Lcom/tencent/biz/qqcircle/comment/recpic/db/a;", "picInfoRepository", "j", "startForwardTime", "Lcom/tencent/biz/qqcircle/comment/recpic/e;", "k", "Lcom/tencent/biz/qqcircle/comment/recpic/e;", "clipServiceHelper", "<init>", "()V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSCommentRecPicClusterHelper {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isMediaScanning;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isMediaScanned;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isForwarding;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IWinkWeClipApi winkApi;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static i83.h forwardResultListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.biz.qqcircle.comment.recpic.db.a picInfoRepository;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static long startForwardTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.biz.qqcircle.comment.recpic.e clipServiceHelper;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSCommentRecPicClusterHelper f83716a = new QFSCommentRecPicClusterHelper();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, List<StrategyImage>> candidatePicMap = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<QFSRecPicInfo> localPicCacheList = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/comment/recpic/QFSCommentRecPicClusterHelper$b", "Li83/c;", "Lcom/tencent/mobileqq/wink/model/MediaScanForwardResult;", "result", "", "a", "", "msg", "onError", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements i83.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<Double> f83732a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f83733b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map<String, Integer> f83734c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f83735d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeakReference<t20.a> f83736e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f83737f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ RFWThreadManager f83738g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f83739h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f83740i;

        b(List<Double> list, List<String> list2, Map<String, Integer> map, Ref.IntRef intRef, WeakReference<t20.a> weakReference, Ref.IntRef intRef2, RFWThreadManager rFWThreadManager, long j3, int i3) {
            this.f83732a = list;
            this.f83733b = list2;
            this.f83734c = map;
            this.f83735d = intRef;
            this.f83736e = weakReference;
            this.f83737f = intRef2;
            this.f83738g = rFWThreadManager;
            this.f83739h = j3;
            this.f83740i = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c() {
            QFSCommentRecPicClusterHelper.isMediaScanning = false;
            QFSCommentRecPicClusterHelper.isMediaScanned = true;
        }

        @Override // i83.c
        public void a(@NotNull MediaScanForwardResult result) {
            List<MediaScanForwardResult> listOf;
            Intrinsics.checkNotNullParameter(result, "result");
            z zVar = z.f83900a;
            if (zVar.f(result, this.f83732a, this.f83733b)) {
                if (QFSCommentRecPicClusterHelper.f83716a.c0(result, this.f83734c)) {
                    this.f83735d.element++;
                }
                t20.a aVar = this.f83736e.get();
                if (aVar != null) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(result);
                    aVar.R(listOf);
                }
            } else {
                this.f83737f.element++;
            }
            if (!result.isLast() && QFSCommentRecPicClusterHelper.isMediaScanning) {
                if (zVar.h(this.f83740i, this.f83739h)) {
                    QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
                    qFSCommentRecPicClusterHelper.j0(true);
                    qFSCommentRecPicClusterHelper.b0(this.f83735d.element, this.f83737f.element, this.f83739h, this.f83733b, this.f83732a, this.f83734c);
                    return;
                }
                return;
            }
            QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper2 = QFSCommentRecPicClusterHelper.f83716a;
            qFSCommentRecPicClusterHelper2.D();
            QFSCommentRecPicClusterHelper.winkApi.stopScan();
            this.f83738g.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.r
                @Override // java.lang.Runnable
                public final void run() {
                    QFSCommentRecPicClusterHelper.b.c();
                }
            });
            qFSCommentRecPicClusterHelper2.b0(this.f83735d.element, this.f83737f.element, this.f83739h, this.f83733b, this.f83732a, this.f83734c);
        }

        @Override // i83.c
        public void onError(@NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/comment/recpic/QFSCommentRecPicClusterHelper$c", "Landroidx/lifecycle/Observer;", "t", "", "onChanged", "(Ljava/lang/Object;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c<T> implements Observer<T> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Observer<T> f83741d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LiveData<T> f83742e;

        c(Observer<T> observer, LiveData<T> liveData) {
            this.f83741d = observer;
            this.f83742e = liveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable T t16) {
            this.f83741d.onChanged(t16);
            this.f83742e.removeObserver(this);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qqcircle/comment/recpic/QFSCommentRecPicClusterHelper$d", "Li83/h;", "", "Lkotlin/Pair;", "", "", com.tencent.rmonitor.base.config.data.k.FEATURES_KEY, "", "onSuccess", "onFail", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements i83.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList<QFSRecPicInfo> f83743a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CmtClusterBean f83744b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f83745c;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(-((QFSRecPicInfo) t16).g().get(0).floatValue()), Float.valueOf(-((QFSRecPicInfo) t17).g().get(0).floatValue()));
                return compareValues;
            }
        }

        d(CopyOnWriteArrayList<QFSRecPicInfo> copyOnWriteArrayList, CmtClusterBean cmtClusterBean, String str) {
            this.f83743a = copyOnWriteArrayList;
            this.f83744b = cmtClusterBean;
            this.f83745c = str;
        }

        @Override // i83.h
        public void onFail() {
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[startAnalyseCmtPic] onFail");
            QFSCommentRecPicClusterHelper.isForwarding = false;
        }

        @Override // i83.h
        public void onSuccess(@NotNull List<Pair<String, float[]>> features) {
            List<QFSRecPicInfo> mutableList;
            int i3;
            Object last;
            float[] floatArray;
            float[] floatArray2;
            double[] doubleArray;
            Intrinsics.checkNotNullParameter(features, "features");
            QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "cmt pics forward cost: " + (System.currentTimeMillis() - QFSCommentRecPicClusterHelper.startForwardTime) + " ms");
            for (Pair<String, float[]> pair : features) {
                Iterator<QFSRecPicInfo> it = this.f83743a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        QFSRecPicInfo next = it.next();
                        if (Intrinsics.areEqual(next.getPath(), pair.getFirst())) {
                            QLog.d("QFSCommentRecPicClusterHelper", 1, "match path: " + ((Object) pair.getFirst()));
                            next.k(pair.getSecond());
                            break;
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.f83743a);
            ArrayList arrayList = new ArrayList();
            Iterator<QFSRecPicInfo> it5 = mutableList.iterator();
            while (true) {
                i3 = 0;
                if (!it5.hasNext()) {
                    break;
                }
                QFSRecPicInfo next2 = it5.next();
                if (next2.getImageFeature() == null) {
                    QLog.e("QFSCommentRecPicClusterHelper", 1, "image feature is null");
                    it5.remove();
                } else {
                    float[] imageFeature = next2.getImageFeature();
                    if (imageFeature != null) {
                        ArrayList arrayList2 = new ArrayList(imageFeature.length);
                        int length = imageFeature.length;
                        while (i3 < length) {
                            arrayList2.add(Double.valueOf(imageFeature[i3]));
                            i3++;
                        }
                        doubleArray = CollectionsKt___CollectionsKt.toDoubleArray(arrayList2);
                        arrayList.add(doubleArray);
                    }
                }
            }
            ah ahVar = ah.f83774a;
            if (ahVar.c(mutableList, arrayList) == null) {
                QLog.d("QFSCommentRecPicClusterHelper", 1, "[startAnalyseCmtPic] cecentroids is empty");
                return;
            }
            double[] b16 = ahVar.b(arrayList);
            if (b16 == null) {
                return;
            }
            QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "finish k cluster, cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            for (QFSRecPicInfo qFSRecPicInfo : mutableList) {
                qFSRecPicInfo.i().add("KMeans");
                List<Float> g16 = qFSRecPicInfo.g();
                QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
                ArrayList arrayList3 = new ArrayList(b16.length);
                for (double d16 : b16) {
                    arrayList3.add(Float.valueOf((float) d16));
                }
                floatArray2 = CollectionsKt___CollectionsKt.toFloatArray(arrayList3);
                g16.add(Float.valueOf(qFSCommentRecPicClusterHelper.A(floatArray2, qFSRecPicInfo.getImageFeature())));
            }
            if (mutableList.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, new a());
            }
            QFSCommentRecPicClusterHelper.isForwarding = false;
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) mutableList);
            double doubleValue = ((QFSRecPicInfo) last).g().get(0).doubleValue() * z.f83900a.m().getWeight();
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            float f16 = (float) doubleValue;
            ArrayList arrayList4 = new ArrayList(b16.length);
            int length2 = b16.length;
            while (i3 < length2) {
                arrayList4.add(Float.valueOf((float) b16[i3]));
                i3++;
            }
            floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList4);
            CmtClusterBean cmtClusterBean = this.f83744b;
            cmtClusterBean.c(this.f83743a.size());
            cmtClusterBean.e(doubleValue);
            Unit unit = Unit.INSTANCE;
            simpleEventBus.dispatchEvent(new QFSKMeansResultEvent(f16, floatArray, cmtClusterBean, this.f83745c));
        }
    }

    static {
        QRouteApi api = QRoute.api(IWinkWeClipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkWeClipApi::class.java)");
        winkApi = (IWinkWeClipApi) api;
        Application application = RFWApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        clipServiceHelper = new com.tencent.biz.qqcircle.comment.recpic.e(application);
    }

    QFSCommentRecPicClusterHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.p
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentRecPicClusterHelper.E();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E() {
        com.tencent.biz.qqcircle.comment.recpic.db.a aVar = picInfoRepository;
        if (aVar != null) {
            aVar.a();
        }
        picInfoRepository = null;
    }

    private final Activity H(t20.a scanListener) {
        if (scanListener instanceof aw) {
            return ((aw) scanListener).getActivity();
        }
        return null;
    }

    private final boolean L(int strategy) {
        if (strategy != 5 && strategy != 4 && strategy != 6) {
            return false;
        }
        return true;
    }

    private final void P(final WeakReference<t20.a> scanListenerWrf) {
        if (!isMediaScanning) {
            QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 4, "[mediaScanAfterReadDb] media scan pause.");
            D();
            return;
        }
        final RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
        final long currentTimeMillis = System.currentTimeMillis();
        final int size = localPicCacheList.size();
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        rFWThreadManager.execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.l
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentRecPicClusterHelper.Q(arrayList, arrayList2, linkedHashMap, intRef, scanListenerWrf, intRef2, rFWThreadManager, currentTimeMillis, size);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(List unsafeSimilarity, List unsafeIds, Map feedMatchInfo, Ref.IntRef safeCount, WeakReference scanListenerWrf, Ref.IntRef unsafeCount, RFWThreadManager rFWThreadManager, long j3, int i3) {
        Intrinsics.checkNotNullParameter(unsafeSimilarity, "$unsafeSimilarity");
        Intrinsics.checkNotNullParameter(unsafeIds, "$unsafeIds");
        Intrinsics.checkNotNullParameter(feedMatchInfo, "$feedMatchInfo");
        Intrinsics.checkNotNullParameter(safeCount, "$safeCount");
        Intrinsics.checkNotNullParameter(scanListenerWrf, "$scanListenerWrf");
        Intrinsics.checkNotNullParameter(unsafeCount, "$unsafeCount");
        winkApi.mediaScan(new b(unsafeSimilarity, unsafeIds, feedMatchInfo, safeCount, scanListenerWrf, unsafeCount, rFWThreadManager, j3, i3));
    }

    private final <T> void R(LiveData<T> liveData, Observer<T> observer) {
        liveData.observeForever(new c(observer, liveData));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x015f, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.plus((java.util.Collection) r1, (java.lang.Iterable) r12);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void S(String feedId, List<StrategyImage> dataList) {
        Boolean bool;
        boolean z16;
        List emptyList;
        boolean z17;
        List emptyList2;
        boolean z18;
        List<StrategyImage> plus;
        List emptyList3;
        boolean z19;
        if (dataList.isEmpty()) {
            return;
        }
        int strategy = dataList.get(0).getStrategy();
        Object obj = dataList.get(0).b().get("from_scan");
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        } else {
            bool = null;
        }
        if (bool != null) {
            z16 = bool.booleanValue();
        } else {
            z16 = false;
        }
        if (strategy == 3 && !z16) {
            List<StrategyImage> list = candidatePicMap.get(feedId);
            if (list == null) {
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList3 = new ArrayList();
                for (Object obj2 : list) {
                    if (((StrategyImage) obj2).getStrategy() != 3) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        emptyList3.add(obj2);
                    }
                }
            }
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[preProcessDataList] filter comment cluster pic, size: " + emptyList3.size());
            candidatePicMap.put(feedId, emptyList3);
        } else if (L(strategy)) {
            List<StrategyImage> list2 = candidatePicMap.get(feedId);
            if (list2 == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList2 = new ArrayList();
                for (Object obj3 : list2) {
                    StrategyImage strategyImage = (StrategyImage) obj3;
                    if (strategyImage.getStrategy() != 2 && strategyImage.getStrategy() != 3 && strategyImage.getStrategy() != 1 && strategyImage.getStrategy() != 7) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (z18) {
                        emptyList2.add(obj3);
                    }
                }
            }
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[preProcessDataList] filter input pic, size: " + emptyList2.size());
            candidatePicMap.put(feedId, emptyList2);
        } else if (strategy == 1) {
            List<StrategyImage> list3 = candidatePicMap.get(feedId);
            if (list3 == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList = new ArrayList();
                for (Object obj4 : list3) {
                    if (((StrategyImage) obj4).getStrategy() != 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        emptyList.add(obj4);
                    }
                }
            }
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[preProcessDataList] filter video frame pic, size: " + emptyList.size());
            candidatePicMap.put(feedId, emptyList);
        }
        Map<String, List<StrategyImage>> map = candidatePicMap;
        List<StrategyImage> list4 = map.get(feedId);
        if (list4 != null && plus != null) {
            dataList = plus;
        }
        map.put(feedId, dataList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.ref.WeakReference] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    private final void T(final t20.a scanListener) {
        LiveData<List<QFSRecPicInfo>> d16;
        String str = "[readFromDb] allRecPicInfo is null";
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                Application application = RFWApplication.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
                com.tencent.biz.qqcircle.comment.recpic.db.a aVar = new com.tencent.biz.qqcircle.comment.recpic.db.a(application);
                picInfoRepository = aVar;
                d16 = aVar.d();
            } catch (Exception e16) {
                QLog.e("QFSCommentRecPicClusterHelper", 1, "readFromDb error, " + e16);
                QLog.d("QFSCommentRecPicClusterHelper", 1, "[readFromDb] allRecPicInfo is null");
                str = new WeakReference(scanListener);
            }
            if (d16 == null) {
                QLog.d("QFSCommentRecPicClusterHelper", 1, "[readFromDb] allRecPicInfo is null");
                str = new WeakReference(scanListener);
                P(str);
                return;
            }
            R(d16, new Observer() { // from class: com.tencent.biz.qqcircle.comment.recpic.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QFSCommentRecPicClusterHelper.U(currentTimeMillis, scanListener, (List) obj);
                }
            });
        } catch (Throwable th5) {
            QLog.d("QFSCommentRecPicClusterHelper", 1, str);
            P(new WeakReference(scanListener));
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(final long j3, final t20.a aVar, final List list) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.m
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentRecPicClusterHelper.V(list, j3, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(List list, long j3, final t20.a aVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            QFSRecPicInfo qFSRecPicInfo = (QFSRecPicInfo) it.next();
            if (new File(qFSRecPicInfo.getPath()).exists()) {
                arrayList.add(qFSRecPicInfo);
            } else {
                com.tencent.biz.qqcircle.comment.recpic.db.a aVar2 = picInfoRepository;
                if (aVar2 != null) {
                    aVar2.c(qFSRecPicInfo.getPath());
                }
                arrayList2.add(qFSRecPicInfo);
            }
        }
        final ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList) {
            if (z.f83900a.g(winkApi.loadImageFeature(((QFSRecPicInfo) obj).getPhotoId()))) {
                arrayList3.add(obj);
            }
        }
        f83716a.l0(arrayList3);
        long currentTimeMillis = System.currentTimeMillis() - j3;
        QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "[readFromDb] allRecPicInfo size: " + list.size() + ", real size: " + arrayList.size() + ", invalid size: " + arrayList2.size() + ", cost: " + currentTimeMillis + " ms");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.g
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentRecPicClusterHelper.W(arrayList3, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(List safePicList, t20.a aVar) {
        Intrinsics.checkNotNullParameter(safePicList, "$safePicList");
        localPicCacheList.addAll(safePicList);
        f83716a.P(new WeakReference<>(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        SimpleEventBus.getInstance().dispatchEvent(new QFSRecPicStateEvent(2, feedId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        SimpleEventBus.getInstance().dispatchEvent(new QFSRecPicStateEvent(2, feedId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(int safeCount, int unsafeCount, long scanStartTime, List<String> unsafeIds, List<Double> unsafeSimilarity, Map<String, Integer> feedMatchInfo) {
        long j3;
        long currentTimeMillis = System.currentTimeMillis() - scanStartTime;
        int i3 = safeCount + unsafeCount;
        if (i3 == 0) {
            j3 = 0;
        } else {
            j3 = currentTimeMillis / i3;
        }
        QLog.e(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "[mediaScan] total cost: " + currentTimeMillis + ", total count: " + i3 + ", average time: " + j3);
        ak.f83788a.n(new ScanReportBean(currentTimeMillis, i3, unsafeCount, unsafeSimilarity, unsafeIds, feedMatchInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c0(MediaScanForwardResult result, Map<String, Integer> feedMatchInfo) {
        int collectionSizeOrDefault;
        int i3;
        if (!result.isPic()) {
            return false;
        }
        CopyOnWriteArrayList<QFSRecPicInfo> copyOnWriteArrayList = localPicCacheList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(copyOnWriteArrayList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(((QFSRecPicInfo) it.next()).getPath());
        }
        if (arrayList.contains(result.getPath())) {
            return false;
        }
        QFSRecPicInfo qFSRecPicInfo = new QFSRecPicInfo(result.getPath(), result.getPhotoId(), 0, result.getMediaWidth(), result.getMediaHeight(), null, null, 100, null);
        for (QFSFeedCategoryConfig qFSFeedCategoryConfig : z.f83900a.j()) {
            Iterator<float[]> it5 = qFSFeedCategoryConfig.b().iterator();
            int i16 = 0;
            while (it5.hasNext()) {
                int i17 = i16 + 1;
                float A = A(it5.next(), result.getImageFeature());
                if (A > qFSFeedCategoryConfig.getThresholds()[i16]) {
                    qFSRecPicInfo.g().add(Float.valueOf(A));
                    qFSRecPicInfo.i().add(qFSFeedCategoryConfig.getSubCategory() + i16);
                    Integer num = feedMatchInfo.get(qFSFeedCategoryConfig.getSubCategory());
                    if (num != null) {
                        i3 = num.intValue();
                    } else {
                        i3 = 0;
                    }
                    feedMatchInfo.put(qFSFeedCategoryConfig.getSubCategory(), Integer.valueOf(i3 + 1));
                }
                i16 = i17;
            }
        }
        localPicCacheList.add(qFSRecPicInfo);
        com.tencent.biz.qqcircle.comment.recpic.db.a aVar = picInfoRepository;
        if (aVar != null) {
            aVar.f(qFSRecPicInfo);
        }
        return true;
    }

    private final void d0(FeedCloudMeta$StFeed feed, boolean isTestDomain) {
        if (feed != null) {
            String desc = feed.content.get();
            String str = feed.f398449id.get();
            ag agVar = new ag();
            LiveData<UIStateData<List<Embedding>>> Q1 = agVar.Q1();
            final QFSCommentRecPicClusterHelper$sendFeedDescRequest$1$1 qFSCommentRecPicClusterHelper$sendFeedDescRequest$1$1 = new QFSCommentRecPicClusterHelper$sendFeedDescRequest$1$1(str);
            Q1.observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.comment.recpic.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QFSCommentRecPicClusterHelper.e0(Function1.this, obj);
                }
            });
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[sendFeedDescRequest] desc: " + desc + ", isTestDomain: " + isTestDomain);
            if (isTestDomain) {
                Intrinsics.checkNotNullExpressionValue(desc, "desc");
                agVar.T1(desc);
            } else {
                Intrinsics.checkNotNullExpressionValue(desc, "desc");
                agVar.S1(desc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(boolean z16) {
        isMediaScanning = false;
        QLog.d("QFSCommentRecPicClusterHelper", 1, "[mediaScan] stop scan. record: " + z16);
        if (z16) {
            uq3.k.a().n("stop_scan_timestamp", System.currentTimeMillis());
        }
    }

    private final void l0(List<QFSRecPicInfo> safePicList) {
        for (QFSRecPicInfo qFSRecPicInfo : safePicList) {
            float[] loadImageFeature = winkApi.loadImageFeature(qFSRecPicInfo.getPhotoId());
            if (loadImageFeature != null) {
                qFSRecPicInfo.g().clear();
                qFSRecPicInfo.i().clear();
                for (QFSFeedCategoryConfig qFSFeedCategoryConfig : z.f83900a.j()) {
                    Iterator<float[]> it = qFSFeedCategoryConfig.b().iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        int i16 = i3 + 1;
                        float A = A(it.next(), loadImageFeature);
                        if (A > qFSFeedCategoryConfig.getThresholds()[i3]) {
                            qFSRecPicInfo.g().add(Float.valueOf(A));
                            qFSRecPicInfo.i().add(qFSFeedCategoryConfig.getSubCategory() + i3);
                        }
                        i3 = i16;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final String feedId, List dataList) {
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        List<StrategyImage> list = candidatePicMap.get(feedId);
        if (list != null) {
            dataList = list;
        }
        final List<StrategyImage> i3 = new com.tencent.biz.qqcircle.comment.recpic.sorter.a(dataList, z.f83900a.v()).i();
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.q
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentRecPicClusterHelper.z(feedId, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(String feedId, List sortResult) {
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        Intrinsics.checkNotNullParameter(sortResult, "$sortResult");
        candidatePicMap.put(feedId, sortResult);
        SimpleEventBus.getInstance().dispatchEvent(new QFSRecPicStateEvent(2, feedId));
    }

    public final float A(@Nullable float[] feature1, @Nullable float[] feature2) {
        boolean z16;
        boolean z17;
        float f16 = 0.0f;
        if (feature1 != null && feature2 != null) {
            if (feature1.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (feature2.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    if (feature1.length != feature2.length) {
                        QLog.e("QFSCommentRecPicClusterHelper", 1, "<compareSimilarityFromVisualCosine>, can not get similarity, feature len is diff, feature1 len is " + feature1.length + ", feature2 len is " + feature2.length);
                        return 0.0f;
                    }
                    int length = feature1.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        f16 += feature1[i3] * feature2[i3];
                    }
                    return f16 * 100;
                }
            }
            QLog.e("QFSCommentRecPicClusterHelper", 1, "<compareSimilarityFromVisualCosine>, can not get similarity, feature is empty, feature1 len is " + feature1.length + ", feature2 len is " + feature2.length);
            return 0.0f;
        }
        QLog.e("QFSCommentRecPicClusterHelper", 1, "<compareSimilarityFromVisualCosine>, can not get similarity, one or both features are null");
        return 0.0f;
    }

    public final void B() {
        isMediaScanned = false;
        isMediaScanning = false;
        uq3.k.a().n("stop_scan_timestamp", 0L);
        localPicCacheList.clear();
        candidatePicMap.clear();
        winkApi.stopScan();
    }

    public final void C(@NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        candidatePicMap.remove(feedId);
    }

    public final boolean F(@NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        List<StrategyImage> G = G(feedId);
        if (RFSafeListUtils.isEmpty(G)) {
            return false;
        }
        Intrinsics.checkNotNull(G);
        if (G.get(0).getStrategy() != 1) {
            return false;
        }
        return true;
    }

    @Nullable
    public final List<StrategyImage> G(@NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        return candidatePicMap.get(feedId);
    }

    @NotNull
    public final List<QFSRecPicInfo> I() {
        int s16 = z.f83900a.s();
        CopyOnWriteArrayList<QFSRecPicInfo> copyOnWriteArrayList = localPicCacheList;
        if (copyOnWriteArrayList.size() > s16) {
            return new CopyOnWriteArrayList(copyOnWriteArrayList.subList(0, s16));
        }
        return copyOnWriteArrayList;
    }

    public final boolean J(@NotNull String feedId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        List<StrategyImage> G = G(feedId);
        if (G != null && !G.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    public final boolean K() {
        return isMediaScanned;
    }

    public final boolean M() {
        return isMediaScanning;
    }

    @NotNull
    public final List<StrategyImage> N(@NotNull List<QFSRecPicInfo> picInfoList, @NotNull List<StrategyConfig> configs) {
        Object valueOf;
        Object valueOf2;
        Intrinsics.checkNotNullParameter(picInfoList, "picInfoList");
        Intrinsics.checkNotNullParameter(configs, "configs");
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        long j16 = 0;
        for (QFSRecPicInfo qFSRecPicInfo : picInfoList) {
            long currentTimeMillis = System.currentTimeMillis();
            float[] loadImageFeature = winkApi.loadImageFeature(qFSRecPicInfo.getPhotoId());
            j3 += System.currentTimeMillis() - currentTimeMillis;
            if (loadImageFeature == null) {
                QLog.e("QFSCommentRecPicClusterHelper", 1, "[matchLocalPic] can not load cache imageFeature. ");
                return arrayList;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            Iterator<StrategyConfig> it = configs.iterator();
            while (true) {
                if (it.hasNext()) {
                    StrategyConfig next = it.next();
                    float A = A(loadImageFeature, next.getFeature());
                    if (A > next.getThreshold()) {
                        StrategyImage strategyImage = new StrategyImage(qFSRecPicInfo.getPath(), next.getSource(), A, qFSRecPicInfo.getPath(), null, 16, null);
                        strategyImage.b().put("w", Integer.valueOf(qFSRecPicInfo.getMediaWidth()));
                        strategyImage.b().put(tl.h.F, Integer.valueOf(qFSRecPicInfo.getMediaHeight()));
                        strategyImage.b().put("hashId", next.getHashId());
                        arrayList.add(strategyImage);
                        break;
                    }
                }
            }
            j16 += System.currentTimeMillis() - currentTimeMillis2;
        }
        if (picInfoList.isEmpty()) {
            valueOf = 0;
        } else {
            valueOf = Float.valueOf((((float) j3) / picInfoList.size()) * 1000);
        }
        if (picInfoList.isEmpty()) {
            valueOf2 = 0;
        } else {
            valueOf2 = Float.valueOf((((float) j16) / picInfoList.size()) * 1000);
        }
        QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "[matchLocalPics] pic size: " + picInfoList.size() + ", load feature cost: " + j3 + " ms, avg cost: " + valueOf + " ms, cul similarity cost: " + j16 + " ms, avg cost: " + valueOf2 + " ms, strategy size: " + configs.size());
        return arrayList;
    }

    public final void O(@Nullable t20.a scanListener) {
        if (!aa.f83750a.E(H(scanListener))) {
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[mediaScan] has no permission. ");
            return;
        }
        if (isMediaScanning) {
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[mediaScan] is scanning. ");
            return;
        }
        if (isMediaScanned) {
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[mediaScan] is scan finish. ");
            return;
        }
        if (!z.f83900a.x()) {
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[mediaScan] is config parsing...");
            return;
        }
        if (System.currentTimeMillis() - uq3.k.a().f("tab_unselect_stop_scan_timestamp", 0L) < uq3.o.a0()) {
            QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "can not start media scan");
            return;
        }
        isMediaScanning = true;
        uq3.k.a().n("tab_unselect_stop_scan_timestamp", System.currentTimeMillis());
        QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "[mediaScan] start. ");
        T(scanListener);
    }

    public final void X(@NotNull final String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        List<StrategyImage> list = candidatePicMap.get(feedId);
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        Intrinsics.checkNotNull(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!f83716a.L(((StrategyImage) obj).getStrategy())) {
                arrayList.add(obj);
            }
        }
        candidatePicMap.put(feedId, arrayList);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.o
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentRecPicClusterHelper.Y(feedId);
            }
        });
    }

    public final void Z(@NotNull final String feedId) {
        Integer num;
        List<StrategyImage> emptyList;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Map<String, List<StrategyImage>> map = candidatePicMap;
        List<StrategyImage> list = map.get(feedId);
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        Intrinsics.checkNotNull(list);
        boolean z16 = false;
        StrategyImage strategyImage = list.get(0);
        if (strategyImage.getStrategy() == 1 && Intrinsics.areEqual(strategyImage.b().get("type"), (Object) 1)) {
            z16 = true;
        }
        if (z16) {
            if (list.size() == 1) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                map.put(feedId, emptyList);
            } else {
                map.put(feedId, list.subList(1, list.size()));
            }
        }
        List<StrategyImage> list2 = map.get(feedId);
        if (list2 != null) {
            num = Integer.valueOf(list2.size());
        } else {
            num = null;
        }
        QLog.d("QFSCommentRecPicClusterHelper", 1, "[removePauseVideoFrame] hasPauseFrame: " + z16 + ", candidate size: " + num);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.i
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentRecPicClusterHelper.a0(feedId);
            }
        });
    }

    public final void f0(@NotNull List<QFSRecPicInfo> cmtPicList, @NotNull String feedId, @NotNull CmtClusterBean reportBean) {
        int collectionSizeOrDefault;
        boolean z16;
        Intrinsics.checkNotNullParameter(cmtPicList, "cmtPicList");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(reportBean, "reportBean");
        QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "[startAnalyseCmtPic] cmtPic size: " + cmtPicList.size());
        CopyOnWriteArrayList<QFSRecPicInfo> copyOnWriteArrayList = new CopyOnWriteArrayList(cmtPicList);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(copyOnWriteArrayList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (QFSRecPicInfo qFSRecPicInfo : copyOnWriteArrayList) {
            arrayList.add(new Pair(qFSRecPicInfo.getPath(), qFSRecPicInfo));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((QFSRecPicInfo) ((Pair) obj).getSecond()).getImageFeature() == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[startAnalyseCmtPic] needForwardList is null. ");
        } else {
            if (isForwarding) {
                QLog.d("QFSCommentRecPicClusterHelper", 1, "[startAnalyseCmtPic] is forwarding. ");
                return;
            }
            isForwarding = true;
            forwardResultListener = new d(copyOnWriteArrayList, reportBean, feedId);
            winkApi.preDownloadWeClipModel(new e(arrayList2));
        }
    }

    public final void g0(@Nullable FeedCloudMeta$StFeed feed) {
        if (aa.f83750a.y() && feed != null) {
            String feedId = feed.f398449id.get();
            ag agVar = new ag();
            LiveData<UIStateData<List<Embedding>>> Q1 = agVar.Q1();
            final QFSCommentRecPicClusterHelper$startAnalyseFeed$1$1 qFSCommentRecPicClusterHelper$startAnalyseFeed$1$1 = new QFSCommentRecPicClusterHelper$startAnalyseFeed$1$1(feedId);
            Q1.observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.comment.recpic.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QFSCommentRecPicClusterHelper.h0(Function1.this, obj);
                }
            });
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[startAnalyseFeed] feedId: " + feedId);
            Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
            agVar.W1(feedId);
        }
    }

    public final void i0(@Nullable FeedCloudMeta$StFeed feed) {
        if (com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_REC_PIC_SWITCH_DOMAIN, 0)) {
            d0(feed, true);
        } else {
            d0(feed, false);
        }
    }

    public final void j0(final boolean record) {
        winkApi.stopScan();
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.h
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentRecPicClusterHelper.k0(record);
            }
        });
    }

    public final void x(@NotNull final String feedId, @NotNull final List<StrategyImage> dataList) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (dataList.isEmpty()) {
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[addCandidatePicList] dataList is empty.");
        } else {
            S(feedId, dataList);
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.n
                @Override // java.lang.Runnable
                public final void run() {
                    QFSCommentRecPicClusterHelper.y(feedId, dataList);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/QFSCommentRecPicClusterHelper$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "feedId", "I", "d", "()I", "source", "", "c", "[F", "()[F", "feature", "", UserInfo.SEX_FEMALE, "e", "()F", "threshold", "setHashId", "(Ljava/lang/String;)V", "hashId", "<init>", "(Ljava/lang/String;I[FFLjava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.comment.recpic.QFSCommentRecPicClusterHelper$a, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class StrategyConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int source;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final float[] feature;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final float threshold;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String hashId;

        public StrategyConfig(@NotNull String feedId, int i3, @NotNull float[] feature, float f16, @NotNull String hashId) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(feature, "feature");
            Intrinsics.checkNotNullParameter(hashId, "hashId");
            this.feedId = feedId;
            this.source = i3;
            this.feature = feature;
            this.threshold = f16;
            this.hashId = hashId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final float[] getFeature() {
            return this.feature;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getHashId() {
            return this.hashId;
        }

        /* renamed from: d, reason: from getter */
        public final int getSource() {
            return this.source;
        }

        /* renamed from: e, reason: from getter */
        public final float getThreshold() {
            return this.threshold;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StrategyConfig)) {
                return false;
            }
            StrategyConfig strategyConfig = (StrategyConfig) other;
            if (Intrinsics.areEqual(this.feedId, strategyConfig.feedId) && this.source == strategyConfig.source && Intrinsics.areEqual(this.feature, strategyConfig.feature) && Float.compare(this.threshold, strategyConfig.threshold) == 0 && Intrinsics.areEqual(this.hashId, strategyConfig.hashId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.feedId.hashCode() * 31) + this.source) * 31) + Arrays.hashCode(this.feature)) * 31) + Float.floatToIntBits(this.threshold)) * 31) + this.hashId.hashCode();
        }

        @NotNull
        public String toString() {
            return "StrategyConfig(feedId=" + this.feedId + ", source=" + this.source + ", feature=" + Arrays.toString(this.feature) + ", threshold=" + this.threshold + ", hashId=" + this.hashId + ")";
        }

        public /* synthetic */ StrategyConfig(String str, int i3, float[] fArr, float f16, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, fArr, f16, (i16 & 16) != 0 ? "" : str2);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/comment/recpic/QFSCommentRecPicClusterHelper$e", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<Pair<String, QFSRecPicInfo>> f83746a;

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002 \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00030\u0001J9\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0003\"\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u00020\u000b2\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/qqcircle/comment/recpic/QFSCommentRecPicClusterHelper$e$a", "Lcom/tencent/biz/qqcircle/utils/QFSAsyncUtils$Callback;", "Ljava/lang/Void;", "", "Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", "param", "a", "([Ljava/lang/Void;)[Lkotlin/Pair;", "result", "", "b", "([Lkotlin/Pair;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes4.dex */
        public static final class a extends QFSAsyncUtils.Callback<Void, Pair<? extends String, ? extends Bitmap>[]> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List<String> f83747a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ List<String> f83748b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Ref.LongRef f83749c;

            a(List<String> list, List<String> list2, Ref.LongRef longRef) {
                this.f83747a = list;
                this.f83748b = list2;
                this.f83749c = longRef;
            }

            @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Pair<String, Bitmap>[] doBackgroundAction(@NotNull Void... param) {
                boolean z16;
                boolean z17;
                Intrinsics.checkNotNullParameter(param, "param");
                ArrayList arrayList = new ArrayList();
                long currentTimeMillis = System.currentTimeMillis();
                int i3 = 0;
                for (String str : this.f83747a) {
                    int i16 = i3 + 1;
                    String str2 = this.f83748b.get(i3);
                    Bitmap decodeFile = BitmapUtil.decodeFile(str);
                    if (str2.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        if (str.length() > 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17 && decodeFile != null && decodeFile.getWidth() > 0 && decodeFile.getHeight() > 0) {
                            arrayList.add(new Pair(str2, Bitmap.createScaledBitmap(decodeFile, 224, 224, true)));
                            i3 = i16;
                        }
                    }
                    QLog.e("QFSCommentRecPicClusterHelper", 1, "[startAnalyseCmtPic] bitmap is null");
                    i3 = i16;
                }
                this.f83749c.element = System.currentTimeMillis() - currentTimeMillis;
                QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "decode pic bitmap cost: " + this.f83749c.element);
                Object[] array = arrayList.toArray(new Pair[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                return (Pair[]) array;
            }

            @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void doMainAction(@NotNull Pair<String, Bitmap>[] result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
                QFSCommentRecPicClusterHelper.startForwardTime = System.currentTimeMillis();
                IWinkWeClipApi iWinkWeClipApi = QFSCommentRecPicClusterHelper.winkApi;
                i83.h hVar = QFSCommentRecPicClusterHelper.forwardResultListener;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forwardResultListener");
                    hVar = null;
                }
                iWinkWeClipApi.doClipForward(result, hVar);
            }
        }

        e(List<Pair<String, QFSRecPicInfo>> list) {
            this.f83746a = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(List localPathList, List picUrlList, List needForwardList, long j3, LoadState loadState, Option option) {
            boolean z16;
            Intrinsics.checkNotNullParameter(localPathList, "$localPathList");
            Intrinsics.checkNotNullParameter(picUrlList, "$picUrlList");
            Intrinsics.checkNotNullParameter(needForwardList, "$needForwardList");
            if (loadState.isDownloadSuccess()) {
                String localPath = option.getLocalPath();
                Intrinsics.checkNotNullExpressionValue(localPath, "opt.localPath");
                localPathList.add(localPath);
                String url = option.getUrl();
                Intrinsics.checkNotNullExpressionValue(url, "opt.url");
                picUrlList.add(url);
                if (needForwardList.size() == localPathList.size()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    Ref.LongRef longRef = new Ref.LongRef();
                    long currentTimeMillis = System.currentTimeMillis() - j3;
                    longRef.element = currentTimeMillis;
                    QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "download pic cost: " + currentTimeMillis);
                    QFSAsyncUtils.executeSub(new a(localPathList, picUrlList, longRef), new Void[0]);
                }
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            final long currentTimeMillis = System.currentTimeMillis();
            Iterator<Pair<String, QFSRecPicInfo>> it = this.f83746a.iterator();
            while (it.hasNext()) {
                Option requestHeight = Option.obtain().setUrl(it.next().getFirst()).setRequestWidth(224).setRequestHeight(224);
                QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
                final List<Pair<String, QFSRecPicInfo>> list = this.f83746a;
                g16.download(requestHeight, new IPicLoadStateListener() { // from class: com.tencent.biz.qqcircle.comment.recpic.u
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option) {
                        QFSCommentRecPicClusterHelper.e.b(arrayList, arrayList2, list, currentTimeMillis, loadState, option);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }
}
