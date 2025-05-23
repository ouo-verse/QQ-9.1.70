package com.tencent.mobileqq.wink.newalbum.director.datasource;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumProcessorManager;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumGenerator;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bJ\u0010KJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\bH\u0003J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0002J\u0013\u0010\u0012\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0014\u0010\u0017\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fJ\b\u0010\u0018\u001a\u00020\bH\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001fR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001f\u001a\u0004\b&\u0010'R \u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u000f0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010*R#\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u000f0,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u00140)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00140,8\u0006\u00a2\u0006\f\n\u0004\b4\u0010.\u001a\u0004\b5\u00100R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010H\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/director/datasource/WinkAlbumDataSource;", "Lx83/a;", "Lkotlinx/coroutines/channels/Channel;", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ls53/a;", "y", "newAlbumResult", "", "E", "(Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memoryAlbumResult", "D", "(Ls53/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", "", "memoryAlbums", UserInfo.SEX_FEMALE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "g", "newAlbumResults", BdhLogUtil.LogTag.Tag_Conn, "f", "", "b", "Ljava/lang/String;", "TAG", "", "c", "Ljava/util/List;", "memoryAlbumSourceDataList", "d", "newAlbumSourceDataList", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/data/a;", "e", "_allAlbumDataTypeDataList", HippyTKDListViewAdapter.X, "()Ljava/util/List;", "allAlbumDataTypeDataList", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "_allAlbumDataTypeData", "Landroidx/lifecycle/LiveData;", h.F, "Landroidx/lifecycle/LiveData;", "w", "()Landroidx/lifecycle/LiveData;", "allAlbumDataTypeData", "i", "_allAlbumDataLoadFinished", "j", "v", "allAlbumDataLoadFinished", "Lkotlinx/coroutines/CoroutineScope;", "k", "Lkotlinx/coroutines/CoroutineScope;", "normalScope", "Lkotlinx/coroutines/Job;", "l", "Lkotlinx/coroutines/Job;", "consumerJob", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/channels/Channel;", "channelMemoryAlbum", DomainData.DOMAIN_NAME, "channelNewAlbum", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", "o", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", "winkNewAlbumDatabaseImp", "()Ljava/lang/String;", "logTag", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAlbumDataSource extends x83.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkAlbumDataSource f324204a = new WinkAlbumDataSource();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "WinkNewAlbum_WinkAlbumDataSource";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<s53.a> memoryAlbumSourceDataList = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WinkNewMemoryAlbumResult> newAlbumSourceDataList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WinkAlbumItemWrapper> _allAlbumDataTypeDataList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WinkAlbumItemWrapper> allAlbumDataTypeDataList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<List<WinkAlbumItemWrapper>> _allAlbumDataTypeData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LiveData<List<WinkAlbumItemWrapper>> allAlbumDataTypeData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Boolean> _allAlbumDataLoadFinished;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LiveData<Boolean> allAlbumDataLoadFinished;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CoroutineScope normalScope;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Job consumerJob;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Channel<s53.a> channelMemoryAlbum;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Channel<WinkNewMemoryAlbumResult> channelNewAlbum;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static WinkNewAlbumDatabaseImp winkNewAlbumDatabaseImp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/newalbum/director/datasource/WinkAlbumDataSource$a", "Lcom/tencent/mobileqq/wink/newalbum/director/datasource/a;", "Ls53/a;", "", "datas", "", "b", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements com.tencent.mobileqq.wink.newalbum.director.datasource.a<s53.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Channel<s53.a> f324219a;

        a(Channel<s53.a> channel) {
            this.f324219a = channel;
        }

        @Override // com.tencent.mobileqq.wink.newalbum.director.datasource.a
        public void a() {
            QLog.d(WinkAlbumDataSource.TAG, 1, "onProducedEnd, memory album ");
            SendChannel.DefaultImpls.close$default(this.f324219a, null, 1, null);
        }

        @Override // com.tencent.mobileqq.wink.newalbum.director.datasource.a
        public void b(@NotNull List<? extends s53.a> datas) {
            Intrinsics.checkNotNullParameter(datas, "datas");
            if (this.f324219a.isClosedForSend()) {
                QLog.d(WinkAlbumDataSource.TAG, 1, "onDataProduced, channelMemoryAlbum is closed for send ");
                return;
            }
            Channel<s53.a> channel = this.f324219a;
            Iterator<T> it = datas.iterator();
            while (it.hasNext()) {
                channel.mo2003trySendJP2dKIU((s53.a) it.next());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/newalbum/director/datasource/WinkAlbumDataSource$b", "Lcom/tencent/mobileqq/wink/newalbum/director/datasource/a;", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "", "datas", "", "b", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements com.tencent.mobileqq.wink.newalbum.director.datasource.a<WinkNewMemoryAlbumResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Channel<WinkNewMemoryAlbumResult> f324220a;

        b(Channel<WinkNewMemoryAlbumResult> channel) {
            this.f324220a = channel;
        }

        @Override // com.tencent.mobileqq.wink.newalbum.director.datasource.a
        public void a() {
            QLog.d(WinkAlbumDataSource.TAG, 1, "onProducedEnd, new album ");
            SendChannel.DefaultImpls.close$default(this.f324220a, null, 1, null);
        }

        @Override // com.tencent.mobileqq.wink.newalbum.director.datasource.a
        public void b(@NotNull List<? extends WinkNewMemoryAlbumResult> datas) {
            Intrinsics.checkNotNullParameter(datas, "datas");
            Channel<WinkNewMemoryAlbumResult> channel = this.f324220a;
            for (WinkNewMemoryAlbumResult winkNewMemoryAlbumResult : datas) {
                if (channel.isClosedForSend()) {
                    QLog.d(WinkAlbumDataSource.TAG, 1, "onDataProduced, channelNewAlbum is closed for send ");
                    return;
                }
                channel.mo2003trySendJP2dKIU(winkNewMemoryAlbumResult);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            QLog.e(WinkAlbumDataSource.TAG, 1, "consume album result error", exception);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((WinkNewMemoryAlbumResult) t17).l()), Long.valueOf(((WinkNewMemoryAlbumResult) t16).l()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Double) ((Pair) t16).getSecond(), (Double) ((Pair) t17).getSecond());
            return compareValues;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        _allAlbumDataTypeDataList = arrayList;
        allAlbumDataTypeDataList = arrayList;
        MutableLiveData<List<WinkAlbumItemWrapper>> mutableLiveData = new MutableLiveData<>();
        _allAlbumDataTypeData = mutableLiveData;
        allAlbumDataTypeData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        _allAlbumDataLoadFinished = mutableLiveData2;
        allAlbumDataLoadFinished = mutableLiveData2;
        normalScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.d()));
        winkNewAlbumDatabaseImp = new WinkNewAlbumDatabaseImp();
    }

    WinkAlbumDataSource() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object A(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WinkAlbumDataSource$notifyDataFinished$2(null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void B() {
        String c16 = c();
        List<WinkAlbumItemWrapper> list = _allAlbumDataTypeDataList;
        QLog.d(c16, 1, "onAllAlbumDataTypeDataChanged, size:" + list.size() + " ");
        Set<String> o16 = y83.b.f449557a.o();
        for (WinkAlbumItemWrapper winkAlbumItemWrapper : list) {
            s53.a winkMemoryAlbum = winkAlbumItemWrapper.getWinkMemoryAlbum();
            if (winkMemoryAlbum != null) {
                winkMemoryAlbum.r(o16.contains(winkMemoryAlbum.getId()));
            }
            WinkNewMemoryAlbumResult winkNewAlbum = winkAlbumItemWrapper.getWinkNewAlbum();
            if (winkNewAlbum != null) {
                winkNewAlbum.E(o16.contains(winkNewAlbum.getAlbumID()));
            }
        }
        _allAlbumDataTypeData.setValue(_allAlbumDataTypeDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object D(s53.a aVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WinkAlbumDataSource$onMemoryAlbumProduced$2(aVar, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object E(WinkNewMemoryAlbumResult winkNewMemoryAlbumResult, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WinkAlbumDataSource$onNewAlbumProduced$2(winkNewMemoryAlbumResult, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<WinkNewMemoryAlbumResult> F(List<WinkNewMemoryAlbumResult> memoryAlbums) {
        List sortedWith;
        int collectionSizeOrDefault;
        List sortedWith2;
        int collectionSizeOrDefault2;
        int i3;
        if (memoryAlbums.size() > 1) {
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(memoryAlbums, new d());
            List list = sortedWith;
            Iterator it = list.iterator();
            if (it.hasNext()) {
                int exposeTimes = ((WinkNewMemoryAlbumResult) it.next()).getExposeTimes();
                while (it.hasNext()) {
                    int exposeTimes2 = ((WinkNewMemoryAlbumResult) it.next()).getExposeTimes();
                    if (exposeTimes < exposeTimes2) {
                        exposeTimes = exposeTimes2;
                    }
                }
                Iterator it5 = list.iterator();
                if (it5.hasNext()) {
                    int exposeTimes3 = ((WinkNewMemoryAlbumResult) it5.next()).getExposeTimes();
                    while (it5.hasNext()) {
                        int exposeTimes4 = ((WinkNewMemoryAlbumResult) it5.next()).getExposeTimes();
                        if (exposeTimes3 > exposeTimes4) {
                            exposeTimes3 = exposeTimes4;
                        }
                    }
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    int i16 = 0;
                    for (Object obj : list) {
                        int i17 = i16 + 1;
                        if (i16 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        WinkNewMemoryAlbumResult winkNewMemoryAlbumResult = (WinkNewMemoryAlbumResult) obj;
                        double size = i16 / (sortedWith.size() - 1);
                        if (exposeTimes != exposeTimes3) {
                            i3 = (winkNewMemoryAlbumResult.getExposeTimes() - exposeTimes3) / (exposeTimes - exposeTimes3);
                        } else {
                            i3 = 1;
                        }
                        double E = w83.b.f445025a.E();
                        if (E > 1.0d || E < 0.0d) {
                            E = 0.9d;
                        }
                        arrayList.add(new Pair(winkNewMemoryAlbumResult, Double.valueOf((size * E) + (i3 * (1 - E)))));
                        i16 = i17;
                    }
                    sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(arrayList, new e());
                    List list2 = sortedWith2;
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                    Iterator it6 = list2.iterator();
                    while (it6.hasNext()) {
                        arrayList2.add((WinkNewMemoryAlbumResult) ((Pair) it6.next()).getFirst());
                    }
                    return arrayList2;
                }
                throw new NoSuchElementException();
            }
            throw new NoSuchElementException();
        }
        return memoryAlbums;
    }

    private final Channel<s53.a> y() {
        Channel<s53.a> channel = channelMemoryAlbum;
        if (channel != null) {
            SendChannel.DefaultImpls.close$default(channel, null, 1, null);
        }
        Channel<s53.a> Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        MemoryAlbumGenerator.f326501a.l0(new a(Channel$default));
        Channel$default.invokeOnClose(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.newalbum.director.datasource.WinkAlbumDataSource$initMemoryAlbumChannel$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                QLog.d(WinkAlbumDataSource.TAG, 1, "invokeOnClose, channelMemoryAlbum closed ", th5);
            }
        });
        channelMemoryAlbum = Channel$default;
        return Channel$default;
    }

    private final Channel<WinkNewMemoryAlbumResult> z() {
        Channel<WinkNewMemoryAlbumResult> channel = channelNewAlbum;
        if (channel != null) {
            SendChannel.DefaultImpls.close$default(channel, null, 1, null);
        }
        Channel<WinkNewMemoryAlbumResult> Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        WinkNewAlbumProcessorManager.f324234a.t(new b(Channel$default));
        Channel$default.invokeOnClose(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.newalbum.director.datasource.WinkAlbumDataSource$initNewAlbumChannel$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                QLog.d(WinkAlbumDataSource.TAG, 1, "invokeOnClose, channelNewAlbum closed ", th5);
            }
        });
        channelNewAlbum = Channel$default;
        return Channel$default;
    }

    public final void C(@NotNull List<WinkNewMemoryAlbumResult> newAlbumResults) {
        Intrinsics.checkNotNullParameter(newAlbumResults, "newAlbumResults");
        BuildersKt__Builders_commonKt.launch$default(normalScope, null, null, new WinkAlbumDataSource$onCacheAlbumLoaded$1(newAlbumResults, null), 3, null);
    }

    @Override // x83.a
    @NotNull
    public String c() {
        return TAG;
    }

    @Override // x83.a
    public void f() {
        List<WinkAlbumItemWrapper> emptyList;
        QLog.d(c(), 1, "onDestroyProcess ");
        WinkNewAlbumProcessorManager.f324234a.t(null);
        MemoryAlbumGenerator.f326501a.l0(null);
        Job job = consumerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Channel<s53.a> channel = channelMemoryAlbum;
        if (channel != null) {
            SendChannel.DefaultImpls.close$default(channel, null, 1, null);
        }
        channelMemoryAlbum = null;
        Channel<WinkNewMemoryAlbumResult> channel2 = channelNewAlbum;
        if (channel2 != null) {
            SendChannel.DefaultImpls.close$default(channel2, null, 1, null);
        }
        channelNewAlbum = null;
        memoryAlbumSourceDataList.clear();
        newAlbumSourceDataList.clear();
        _allAlbumDataTypeDataList.clear();
        MutableLiveData<List<WinkAlbumItemWrapper>> mutableLiveData = _allAlbumDataTypeData;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.postValue(emptyList);
        _allAlbumDataLoadFinished.postValue(Boolean.FALSE);
    }

    @Override // x83.a
    public boolean g() {
        Job launch$default;
        QLog.d(c(), 1, "onStartProcess ");
        launch$default = BuildersKt__Builders_commonKt.launch$default(normalScope, new c(CoroutineExceptionHandler.INSTANCE), null, new WinkAlbumDataSource$onStartProcess$2(y(), z(), null), 2, null);
        consumerJob = launch$default;
        return true;
    }

    @NotNull
    public final LiveData<Boolean> v() {
        return allAlbumDataLoadFinished;
    }

    @NotNull
    public final LiveData<List<WinkAlbumItemWrapper>> w() {
        return allAlbumDataTypeData;
    }

    @NotNull
    public final List<WinkAlbumItemWrapper> x() {
        return allAlbumDataTypeDataList;
    }
}
