package com.tencent.qqnt.qbasealbum.datahub;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.cache.api.collection.QQCopyOnWriteArrayList;
import com.tencent.cache.api.collection.QQHashMap;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.qqnt.qbasealbum.album.repository.PickerVideoCursor;
import com.tencent.qqnt.qbasealbum.coroutine.QAlbumCoroutineScopes;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import com.tencent.qqnt.qbasealbum.filter.QAlbumMediaFilterListener;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.query.MediaQueryHelper;
import com.tencent.qqnt.qbasealbum.utils.InitDataUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u0083\u00012\u00020\u0001:\u0001EB\b\u00a2\u0006\u0005\b\u0082\u0001\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0007J<\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\r2\"\u0010\u001e\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u001cj\b\u0012\u0004\u0012\u00020\u0004`\u001d\u0012\u0004\u0012\u00020\u000f0\u001bJ(\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001cj\b\u0012\u0004\u0012\u00020\u0004`\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u0018\u0010#\u001a\u00020\u000f2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0!H\u0007J\u0006\u0010$\u001a\u00020\u000fJ\u0006\u0010%\u001a\u00020\u000fJ\u0006\u0010&\u001a\u00020\u000fJ\u0006\u0010'\u001a\u00020\u000fJ\u000f\u0010(\u001a\u00020\u000fH\u0000\u00a2\u0006\u0004\b(\u0010)J\u0006\u0010*\u001a\u00020\u000fJ\u0006\u0010+\u001a\u00020\u000fJ\u0016\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020\u0007J\u0012\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\u0002H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u00102\u001a\u00020\u0004H\u0002J\u001a\u00104\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u0002H\u0002J\u001e\u00107\u001a\u00020\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001b\u00109\u001a\u00020\u000f2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0019H\u0002\u00a2\u0006\u0004\b9\u0010:J\u0012\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010;\u001a\u00020\u0002H\u0002J\u0014\u0010@\u001a\u00020\u000f2\n\u0010?\u001a\u00060=j\u0002`>H\u0002J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004H\u0002J\u001a\u0010C\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0007H\u0002R&\u0010G\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004050D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR \u0010O\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00040L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020Q0U8\u0006\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R*\u0010h\u001a\u00020\u00022\u0006\u0010b\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u00107\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010`R \u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010u\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010{\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010tR\u0014\u0010}\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010]R\u0014\u0010\u007f\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010]R\u0016\u0010\u0081\u0001\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010t\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/datahub/LocalMediaDataHub;", "", "", "a0", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "t0", "", TtmlNode.ATTR_TTS_ORIGIN, QCircleDaTongConstant.ElementParamValue.NEW, UserInfo.SEX_FEMALE, "D", "E", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "filter", "", "Y", "albumId", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "", "U", "v0", "path", "T", "", "count", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onResult", "g0", "h0", "Lkotlin/Function0;", "onComplete", "l0", "j0", "f0", "m0", "e0", "p0", "()V", "d0", "K", "", "id", "u0", "k0", "J", "q0", "L", "isAppend", "P", "", "list", "Z", "limit", "X", "(Ljava/lang/Integer;)V", "isPreload", "b0", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "n0", "localMediaInfo", ExifInterface.LATITUDE_SOUTH, "N", "Lcom/tencent/cache/api/collection/QQConcurrentHashMap;", "a", "Lcom/tencent/cache/api/collection/QQConcurrentHashMap;", "albumToLocalMedia", "Lcom/tencent/cache/api/collection/QQCopyOnWriteArrayList;", "b", "Lcom/tencent/cache/api/collection/QQCopyOnWriteArrayList;", "localMedias", "Lcom/tencent/cache/api/collection/QQHashMap;", "c", "Lcom/tencent/cache/api/collection/QQHashMap;", "idToLocalMedia", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/qqnt/qbasealbum/datahub/a;", "d", "Landroidx/lifecycle/MutableLiveData;", "_mediaUpdateLiveData", "Landroidx/lifecycle/LiveData;", "e", "Landroidx/lifecycle/LiveData;", "V", "()Landroidx/lifecycle/LiveData;", "mediaUpdateLiveData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasTrim", "g", "I", "preloadLimit", "value", tl.h.F, "W", "()Z", "o0", "(Z)V", "traversalDone", "i", "updateMediaIndex", "Ljava/util/concurrent/ConcurrentHashMap;", "j", "Ljava/util/concurrent/ConcurrentHashMap;", "needReplaceMap", "k", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "mediaFilter", "Ljava/lang/Object;", "l", "Ljava/lang/Object;", "mediaFilterInitLock", "Lcom/tencent/qqnt/qbasealbum/query/MediaQueryHelper;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/qbasealbum/query/MediaQueryHelper;", "mainQueryHelper", DomainData.DOMAIN_NAME, "queryHelperLock", "o", "interrupted", "p", ToastView.ICON_LOADING, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mediaLock", "<init>", "r", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class LocalMediaDataHub {
    static IPatchRedirector $redirector_;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: s, reason: collision with root package name */
    private static final int f361107s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private static final Lazy<LocalMediaDataHub> f361108t;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQConcurrentHashMap<String, List<LocalMediaInfo>> albumToLocalMedia;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQCopyOnWriteArrayList<LocalMediaInfo> localMedias;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQHashMap<Long, LocalMediaInfo> idToLocalMedia;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<a> _mediaUpdateLiveData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<a> mediaUpdateLiveData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean hasTrim;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int preloadLimit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean traversalDone;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile int updateMediaIndex;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<LocalMediaInfo, LocalMediaInfo> needReplaceMap;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile MediaFilter mediaFilter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mediaFilterInitLock;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MediaQueryHelper mainQueryHelper;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object queryHelperLock;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean interrupted;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean loading;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mediaLock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/datahub/LocalMediaDataHub$a;", "", "Lcom/tencent/qqnt/qbasealbum/datahub/LocalMediaDataHub;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/qbasealbum/datahub/LocalMediaDataHub;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "CACHE_SIZE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final LocalMediaDataHub a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LocalMediaDataHub) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (LocalMediaDataHub) LocalMediaDataHub.f361108t.getValue();
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361126a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36192);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[PageType.values().length];
            try {
                iArr[PageType.LOCAL_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageType.LOCAL_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f361126a = iArr;
        }
    }

    static {
        Lazy<LocalMediaDataHub> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36385);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
            return;
        }
        INSTANCE = new Companion(null);
        f361107s = com.tencent.qqnt.qbasealbum.inject.g.f361234b.r();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) LocalMediaDataHub$Companion$instance$2.INSTANCE);
        f361108t = lazy;
    }

    public LocalMediaDataHub() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        Business business = Business.Album;
        QQConcurrentHashMap<String, List<LocalMediaInfo>> qQConcurrentHashMap = new QQConcurrentHashMap<>(business, "albumToLocalMedia");
        this.albumToLocalMedia = qQConcurrentHashMap;
        QQCopyOnWriteArrayList<LocalMediaInfo> qQCopyOnWriteArrayList = new QQCopyOnWriteArrayList<>(business, "localMedias");
        this.localMedias = qQCopyOnWriteArrayList;
        QQHashMap<Long, LocalMediaInfo> qQHashMap = new QQHashMap<>(business, "idToLocalMedia");
        this.idToLocalMedia = qQHashMap;
        MutableLiveData<a> mutableLiveData = new MutableLiveData<>();
        this._mediaUpdateLiveData = mutableLiveData;
        this.mediaUpdateLiveData = mutableLiveData;
        this.hasTrim = new AtomicBoolean(false);
        this.preloadLimit = InitDataUtil.f361625a.b();
        com.tencent.cache.api.c cVar = new com.tencent.cache.api.c() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$clearListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaDataHub.this);
                }
            }

            @Override // com.tencent.cache.api.c
            public void onClearEnd() {
                AtomicBoolean atomicBoolean;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                    return;
                }
                ox3.a.c("QBaseAlbum.LocalMediaDataHub", LocalMediaDataHub$clearListener$1$onClearEnd$1.INSTANCE);
                atomicBoolean = LocalMediaDataHub.this.hasTrim;
                if (!atomicBoolean.get()) {
                    LocalMediaDataHub.this.p0();
                }
            }

            @Override // com.tencent.cache.api.c
            public void onClearStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        qQConcurrentHashMap.setCacheListener(cVar);
        qQCopyOnWriteArrayList.setCacheListener(cVar);
        qQHashMap.setCacheListener(cVar);
        this.needReplaceMap = new ConcurrentHashMap<>();
        this.mediaFilterInitLock = new Object();
        this.queryHelperLock = new Object();
        this.interrupted = new AtomicBoolean(false);
        this.loading = new AtomicBoolean(false);
        this.mediaLock = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(LocalMediaDataHub this$0, LocalMediaInfo originInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(originInfo, "$originInfo");
        this$0._mediaUpdateLiveData.setValue(new q(originInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(LocalMediaDataHub this$0, LocalMediaInfo originInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(originInfo, "$originInfo");
        this$0._mediaUpdateLiveData.setValue(new q(originInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(LocalMediaDataHub this$0, LocalMediaInfo originInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(originInfo, "$originInfo");
        this$0._mediaUpdateLiveData.setValue(new q(originInfo));
    }

    private final boolean J() {
        if (!this.traversalDone && this.loading.get()) {
            return true;
        }
        return false;
    }

    private final LocalMediaInfo L() {
        ox3.a.k("QBaseAlbum.LocalMediaDataHub", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$doDelete$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaDataHub.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                i3 = LocalMediaDataHub.this.updateMediaIndex;
                return "delete index:" + i3;
            }
        });
        final LocalMediaInfo result = this.localMedias.get(this.updateMediaIndex);
        QQConcurrentHashMap<String, List<LocalMediaInfo>> qQConcurrentHashMap = this.albumToLocalMedia;
        Intrinsics.checkNotNullExpressionValue(result, "result");
        List<LocalMediaInfo> list = qQConcurrentHashMap.get(com.tencent.qqnt.qbasealbum.ktx.b.c(result));
        if (list != null) {
            list.remove(result);
        }
        List<LocalMediaInfo> list2 = this.albumToLocalMedia.get(com.tencent.qqnt.qbasealbum.model.a.f361348a.b());
        if (list2 != null) {
            list2.remove(result);
        }
        this.localMedias.remove(this.updateMediaIndex);
        n0(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.datahub.i
            @Override // java.lang.Runnable
            public final void run() {
                LocalMediaDataHub.M(LocalMediaDataHub.this, result);
            }
        });
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(LocalMediaDataHub this$0, LocalMediaInfo result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MutableLiveData<a> mutableLiveData = this$0._mediaUpdateLiveData;
        Intrinsics.checkNotNullExpressionValue(result, "result");
        mutableLiveData.setValue(new p(result));
    }

    private final void N(final LocalMediaInfo info, final String path) {
        String str;
        if (new File(path).length() != 0) {
            return;
        }
        ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>(path) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$doDelete0B$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $path;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$path = path;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) path);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "delete 0B in incremental updating, path: " + this.$path;
            }
        });
        this.localMedias.remove(info);
        boolean z16 = false;
        if (info != null && com.tencent.qqnt.qbasealbum.ktx.b.o(info)) {
            z16 = true;
        }
        if (z16) {
            List<LocalMediaInfo> list = this.albumToLocalMedia.get(com.tencent.qqnt.qbasealbum.model.a.f361348a.b());
            if (list != null) {
                list.remove(info);
            }
        } else {
            QQConcurrentHashMap<String, List<LocalMediaInfo>> qQConcurrentHashMap = this.albumToLocalMedia;
            if (info != null) {
                str = com.tencent.qqnt.qbasealbum.ktx.b.c(info);
            } else {
                str = null;
            }
            List<LocalMediaInfo> list2 = qQConcurrentHashMap.get(str);
            if (list2 != null) {
                TypeIntrinsics.asMutableCollection(list2).remove(info);
            }
        }
        if (info != null) {
            n0(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.datahub.k
                @Override // java.lang.Runnable
                public final void run() {
                    LocalMediaDataHub.O(LocalMediaDataHub.this, info);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(LocalMediaDataHub this$0, LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._mediaUpdateLiveData.setValue(new p(localMediaInfo));
    }

    private final void P(final LocalMediaInfo info, boolean isAppend) {
        List<LocalMediaInfo> list;
        final int i3;
        List<LocalMediaInfo> putIfAbsent;
        List<LocalMediaInfo> putIfAbsent2;
        this.idToLocalMedia.put(Long.valueOf(info.get_id()), info);
        QQConcurrentHashMap<String, List<LocalMediaInfo>> qQConcurrentHashMap = this.albumToLocalMedia;
        String c16 = com.tencent.qqnt.qbasealbum.ktx.b.c(info);
        Intrinsics.checkNotNull(c16);
        List<LocalMediaInfo> list2 = qQConcurrentHashMap.get(c16);
        if (list2 == null && (putIfAbsent2 = qQConcurrentHashMap.putIfAbsent(c16, (list2 = Collections.synchronizedList(new ArrayList())))) != null) {
            list2 = putIfAbsent2;
        }
        List<LocalMediaInfo> albumList = list2;
        if (com.tencent.qqnt.qbasealbum.ktx.b.o(info)) {
            QQConcurrentHashMap<String, List<LocalMediaInfo>> qQConcurrentHashMap2 = this.albumToLocalMedia;
            String b16 = com.tencent.qqnt.qbasealbum.model.a.f361348a.b();
            List<LocalMediaInfo> list3 = qQConcurrentHashMap2.get(b16);
            if (list3 == null && (putIfAbsent = qQConcurrentHashMap2.putIfAbsent(b16, (list3 = Collections.synchronizedList(new ArrayList())))) != null) {
                list3 = putIfAbsent;
            }
            list = list3;
        } else {
            list = null;
        }
        if (isAppend) {
            this.localMedias.add(this.updateMediaIndex, info);
            albumList.add(info);
            if (list != null) {
                list.add(info);
                return;
            }
            return;
        }
        Intrinsics.checkNotNullExpressionValue(albumList, "albumList");
        final int Z = Z(albumList, info);
        if (list != null) {
            i3 = Z(list, info);
        } else {
            i3 = -1;
        }
        this.localMedias.add(this.updateMediaIndex, info);
        final int i16 = this.updateMediaIndex;
        if (Z != -1) {
            if (!com.tencent.qqnt.qbasealbum.ktx.b.o(info) || i3 != -1) {
                final int i17 = i3;
                n0(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.datahub.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocalMediaDataHub.R(LocalMediaDataHub.this, i16, i17, Z, info);
                    }
                });
                ox3.a.k("QBaseAlbum.LocalMediaDataHub", new Function0<String>(i3, Z) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$doInsert$3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int $oldIndexInAlbum;
                    final /* synthetic */ int $oldIndexInVideo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$oldIndexInVideo = i3;
                        this.$oldIndexInAlbum = Z;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, LocalMediaDataHub.this, Integer.valueOf(i3), Integer.valueOf(Z));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        int i18;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        i18 = LocalMediaDataHub.this.updateMediaIndex;
                        return "insert recentIndex:" + i18 + ", videoIndex:" + this.$oldIndexInVideo + ", albumIndex:" + this.$oldIndexInAlbum;
                    }
                });
            }
        }
    }

    static /* synthetic */ void Q(LocalMediaDataHub localMediaDataHub, LocalMediaInfo localMediaInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        localMediaDataHub.P(localMediaInfo, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(LocalMediaDataHub this$0, int i3, int i16, int i17, LocalMediaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        this$0._mediaUpdateLiveData.setValue(new o(i3, i16, i17, info));
    }

    private final LocalMediaInfo S(LocalMediaInfo localMediaInfo) {
        localMediaInfo.setThumbWidth(300);
        localMediaInfo.setThumbHeight(300);
        return localMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(final Integer limit) {
        ArrayList arrayListOf;
        if (this.mainQueryHelper != null) {
            return;
        }
        if (com.tencent.qqnt.qbasealbum.inject.g.f361234b.k()) {
            ox3.a.f("QBaseAlbum.LocalMediaDataHub", LocalMediaDataHub$initMainQueryHelper$1.INSTANCE);
            return;
        }
        Context a16 = com.tencent.qqnt.qbasealbum.inject.a.f361230a.a();
        com.tencent.qqnt.qbasealbum.model.a aVar = com.tencent.qqnt.qbasealbum.model.a.f361348a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.qqnt.qbasealbum.album.repository.a(a16, aVar.a()), new PickerVideoCursor(a16, aVar.a()));
        MediaQueryHelper.a f16 = new MediaQueryHelper.a().e(aVar.a()).h(100).c(true).d(true).f(arrayListOf);
        MediaFilter.Companion companion = MediaFilter.INSTANCE;
        MediaQueryHelper.a g16 = f16.g(new QAlbumMediaFilterListener(new MediaFilter.a().a()));
        if (limit != null) {
            g16.i(limit.intValue());
        }
        ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>(limit) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$initMainQueryHelper$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ Integer $limit;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$limit = limit;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) limit);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "create media query helper, limit: " + this.$limit;
            }
        });
        this.mainQueryHelper = MediaQueryHelper.a.b(g16, null, 1, null);
    }

    private final int Z(List<LocalMediaInfo> list, LocalMediaInfo info) {
        boolean z16;
        boolean z17;
        Object obj;
        boolean z18;
        List<LocalMediaInfo> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (((LocalMediaInfo) it.next()).get_id() == info.get_id()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (z17) {
            return -1;
        }
        Iterator<T> it5 = list2.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj = it5.next();
                if (((LocalMediaInfo) obj).getModifiedDate() <= info.getModifiedDate()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
        if (localMediaInfo != null) {
            int indexOf = list.indexOf(localMediaInfo);
            list.add(indexOf, info);
            return indexOf;
        }
        list.add(info);
        return list.size() - 1;
    }

    private final void b0(boolean isPreload) {
        if (!com.tencent.qqnt.qbasealbum.utils.i.f361663a.a(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a())) {
            return;
        }
        ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$loadMediaData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaDataHub.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                atomicBoolean = LocalMediaDataHub.this.loading;
                atomicBoolean2 = LocalMediaDataHub.this.interrupted;
                return "loadMediaData, loading: " + atomicBoolean + ", interrupted: " + atomicBoolean2;
            }
        });
        if (!this.interrupted.get() && this.loading.get()) {
            return;
        }
        this.loading.set(true);
        this.hasTrim.set(false);
        o0(false);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QAlbumCoroutineScopes.f361069a.d()), null, null, new LocalMediaDataHub$loadMediaData$2(isPreload, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c0(LocalMediaDataHub localMediaDataHub, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        localMediaDataHub.b0(z16);
    }

    public static /* synthetic */ ArrayList i0(LocalMediaDataHub localMediaDataHub, int i3, MediaFilter mediaFilter, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            MediaFilter.Companion companion = MediaFilter.INSTANCE;
            mediaFilter = new MediaFilter.a().a();
        }
        return localMediaDataHub.h0(i3, mediaFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(LocalMediaDataHub this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._mediaUpdateLiveData.setValue(r.f361169a);
    }

    private final LocalMediaInfo k0(String path) {
        Object obj;
        Set<Map.Entry<LocalMediaInfo, LocalMediaInfo>> entrySet = this.needReplaceMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "needReplaceMap.entries");
        Iterator<T> it = entrySet.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((LocalMediaInfo) ((Map.Entry) obj).getKey()).getPath(), path)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return null;
        }
        return (LocalMediaInfo) entry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(LocalMediaDataHub this$0, int i3, int i16, ArrayList medias) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(medias, "$medias");
        this$0._mediaUpdateLiveData.setValue(new n(i3, i16, medias));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(Runnable task) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            task.run();
        } else {
            new Handler(Looper.getMainLooper()).post(task);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        if (r5 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o0(boolean z16) {
        String str;
        List<LocalMediaInfo> list;
        this.traversalDone = z16;
        if (!z16) {
            return;
        }
        if (this.updateMediaIndex >= this.localMedias.size()) {
            n0(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.datahub.e
                @Override // java.lang.Runnable
                public final void run() {
                    LocalMediaDataHub.k(LocalMediaDataHub.this);
                }
            });
            return;
        }
        final int size = this.localMedias.size();
        List<LocalMediaInfo> subList = this.localMedias.subList(this.updateMediaIndex, size);
        Intrinsics.checkNotNullExpressionValue(subList, "localMedias.subList(updateMediaIndex, originSize)");
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = this.updateMediaIndex;
        for (LocalMediaInfo it : subList) {
            QQConcurrentHashMap<String, List<LocalMediaInfo>> qQConcurrentHashMap = this.albumToLocalMedia;
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                str = com.tencent.qqnt.qbasealbum.ktx.b.c(it);
            }
            str = "";
            List<LocalMediaInfo> list2 = qQConcurrentHashMap.get(str);
            if (list2 != null) {
                list2.remove(it);
            }
            if (com.tencent.qqnt.qbasealbum.ktx.b.o(it) && (list = this.albumToLocalMedia.get(com.tencent.qqnt.qbasealbum.model.a.f361348a.b())) != null) {
                list.remove(it);
            }
            ox3.a.k("QBaseAlbum.LocalMediaDataHub", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$traversalDone$2$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) Ref.IntRef.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    Ref.IntRef intRef2 = Ref.IntRef.this;
                    int i3 = intRef2.element;
                    intRef2.element = i3 + 1;
                    return "cutoff, index:" + i3;
                }
            });
        }
        final ArrayList arrayList = new ArrayList(subList);
        subList.clear();
        final int i3 = this.updateMediaIndex;
        n0(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.datahub.f
            @Override // java.lang.Runnable
            public final void run() {
                LocalMediaDataHub.l(LocalMediaDataHub.this, i3, size, arrayList);
            }
        });
    }

    private final LocalMediaInfo q0(final LocalMediaInfo info) {
        Object orNull;
        LocalMediaInfo localMediaInfo;
        List<LocalMediaInfo> putIfAbsent;
        boolean equals$default;
        if (this.interrupted.get()) {
            return null;
        }
        MediaFilter mediaFilter = this.mediaFilter;
        if (mediaFilter != null && !new QAlbumMediaFilterListener(mediaFilter).a(info)) {
            return null;
        }
        if (this.updateMediaIndex >= this.localMedias.size()) {
            if (!TextUtils.isEmpty(info.getPath())) {
                info = S(info);
            }
            if (info.getPath() != null) {
                String path = info.getPath();
                Intrinsics.checkNotNull(path);
                LocalMediaInfo k06 = k0(path);
                if (k06 != null) {
                    info.setPicPathBeforeEdit(info.getPath());
                    info.copyForEdit(k06);
                }
            }
            P(info, true);
            this.updateMediaIndex++;
            return info;
        }
        if (this.localMedias.get(this.updateMediaIndex).get_id() == info.get_id()) {
            final LocalMediaInfo result = this.localMedias.get(this.updateMediaIndex);
            if (result.getPathHash() == info.getPathHash()) {
                Intrinsics.checkNotNullExpressionValue(result, "result");
                if (Intrinsics.areEqual(com.tencent.qqnt.qbasealbum.ktx.b.c(result), com.tencent.qqnt.qbasealbum.ktx.b.c(info))) {
                    if (!TextUtils.isEmpty(result.getMMimeType()) && !TextUtils.isEmpty(info.getMMimeType())) {
                        equals$default = StringsKt__StringsJVMKt.equals$default(result.getMMimeType(), info.getMMimeType(), false, 2, null);
                        if (!equals$default) {
                            result.setMMimeType(info.getMMimeType());
                        }
                    }
                    this.updateMediaIndex++;
                    return result;
                }
            }
            Intrinsics.checkNotNullExpressionValue(result, "result");
            if (com.tencent.qqnt.qbasealbum.ktx.b.j(result) && Intrinsics.areEqual(result.getPicPathBeforeEdit(), info.getPath())) {
                ox3.a.a("QBaseAlbum.LocalMediaDataHub", LocalMediaDataHub$updateLocalMedia$2.INSTANCE);
                n0(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.datahub.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocalMediaDataHub.r0(LocalMediaDataHub.this, result);
                    }
                });
            } else if (!Intrinsics.areEqual(com.tencent.qqnt.qbasealbum.ktx.b.c(result), com.tencent.qqnt.qbasealbum.ktx.b.c(info))) {
                ox3.a.a("QBaseAlbum.LocalMediaDataHub", LocalMediaDataHub$updateLocalMedia$4.INSTANCE);
                LocalMediaInfo localMediaInfo2 = this.localMedias.get(this.updateMediaIndex);
                Intrinsics.checkNotNullExpressionValue(localMediaInfo2, "localMedias[updateMediaIndex]");
                final String c16 = com.tencent.qqnt.qbasealbum.ktx.b.c(localMediaInfo2);
                com.tencent.qqnt.qbasealbum.ktx.b.q(result, com.tencent.qqnt.qbasealbum.ktx.b.c(info));
                result.setPathHash(info.getPathHash());
                result.setPath(info.getPath());
                List<LocalMediaInfo> list = this.albumToLocalMedia.get(c16);
                if (list != null) {
                    list.remove(result);
                }
                QQConcurrentHashMap<String, List<LocalMediaInfo>> qQConcurrentHashMap = this.albumToLocalMedia;
                String c17 = com.tencent.qqnt.qbasealbum.ktx.b.c(result);
                Intrinsics.checkNotNull(c17);
                List<LocalMediaInfo> list2 = qQConcurrentHashMap.get(c17);
                if (list2 == null && (putIfAbsent = qQConcurrentHashMap.putIfAbsent(c17, (list2 = Collections.synchronizedList(new ArrayList())))) != null) {
                    list2 = putIfAbsent;
                }
                List<LocalMediaInfo> albumList = list2;
                Intrinsics.checkNotNullExpressionValue(albumList, "albumList");
                final int Z = Z(albumList, info);
                if (Z != -1) {
                    n0(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.datahub.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocalMediaDataHub.s0(LocalMediaInfo.this, c16, info, Z, this);
                        }
                    });
                }
            } else {
                ox3.a.f("QBaseAlbum.LocalMediaDataHub", new Function0<String>(info) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$updateLocalMedia$6
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ LocalMediaInfo $info;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$info = info;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this, (Object) info);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        return "find other case, oldPath:" + LocalMediaInfo.this.getPath() + ", newPath:" + this.$info.getPath();
                    }
                });
                result.setPath(info.getPath());
            }
            this.updateMediaIndex++;
            return result;
        }
        if (this.localMedias.get(this.updateMediaIndex).getModifiedDate() > info.getModifiedDate()) {
            LocalMediaInfo localMediaInfo3 = this.localMedias.get(this.updateMediaIndex);
            do {
                L();
                orNull = CollectionsKt___CollectionsKt.getOrNull(this.localMedias, this.updateMediaIndex);
                localMediaInfo = (LocalMediaInfo) orNull;
                if (localMediaInfo == null) {
                    break;
                }
            } while (localMediaInfo.getModifiedDate() > info.getModifiedDate());
            q0(info);
            return localMediaInfo3;
        }
        if (this.localMedias.get(this.updateMediaIndex).getModifiedDate() < info.getModifiedDate()) {
            String path2 = info.getPath();
            Intrinsics.checkNotNull(path2);
            if (!new File(path2).exists()) {
                return null;
            }
            if (!TextUtils.isEmpty(info.getPath())) {
                info = S(info);
            }
            if (info.getPath() != null) {
                String path3 = info.getPath();
                Intrinsics.checkNotNull(path3);
                LocalMediaInfo k07 = k0(path3);
                if (k07 != null) {
                    info.setPicPathBeforeEdit(info.getPath());
                    info.copyForEdit(k07);
                }
            }
            Q(this, info, false, 2, null);
            this.updateMediaIndex++;
            return info;
        }
        throw new RuntimeException("WTF");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LocalMediaDataHub this$0, LocalMediaInfo result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MutableLiveData<a> mutableLiveData = this$0._mediaUpdateLiveData;
        Intrinsics.checkNotNullExpressionValue(result, "result");
        mutableLiveData.setValue(new q(result));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LocalMediaInfo result, String str, LocalMediaInfo info, int i3, LocalMediaDataHub this$0) {
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        Intrinsics.checkNotNull(str);
        String c16 = com.tencent.qqnt.qbasealbum.ktx.b.c(info);
        Intrinsics.checkNotNull(c16);
        this$0._mediaUpdateLiveData.setValue(new m(result, str, c16, i3));
    }

    @Nullable
    public final LocalMediaInfo D(@NotNull final String origin, @NotNull LocalMediaInfo r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 7, (Object) this, (Object) origin, (Object) r56);
        }
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(r56, "new");
        final LocalMediaInfo T = T(origin);
        if (T == null) {
            return null;
        }
        if (!com.tencent.qqnt.qbasealbum.ktx.b.j(T)) {
            this.needReplaceMap.put(com.tencent.qqnt.qbasealbum.ktx.b.b(T), T);
            T.setPicPathBeforeEdit(origin);
        }
        T.copyForEdit(r56);
        n0(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.datahub.g
            @Override // java.lang.Runnable
            public final void run() {
                LocalMediaDataHub.H(LocalMediaDataHub.this, T);
            }
        });
        ox3.a.a("QBaseAlbum.MediaEdit", new Function0<String>(origin) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$addReplaceEntry$4
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $origin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$origin = origin;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this, (Object) origin);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                String picPathBeforeEdit = LocalMediaInfo.this.getPicPathBeforeEdit();
                if (picPathBeforeEdit == null) {
                    picPathBeforeEdit = this.$origin;
                }
                return "addReplaceEntry! " + picPathBeforeEdit + " ---> " + LocalMediaInfo.this.getPath();
            }
        });
        return T;
    }

    @Nullable
    public final String E(@NotNull LocalMediaInfo origin, @NotNull LocalMediaInfo r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) origin, (Object) r56);
        }
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(r56, "new");
        String path = origin.getPath();
        Intrinsics.checkNotNull(path);
        final LocalMediaInfo T = T(path);
        if (T == null) {
            return null;
        }
        if (!com.tencent.qqnt.qbasealbum.ktx.b.j(T)) {
            this.needReplaceMap.put(com.tencent.qqnt.qbasealbum.ktx.b.b(T), T);
            T.setPicPathBeforeEdit(origin.getPath());
        }
        T.copyForEdit(r56);
        n0(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.datahub.b
            @Override // java.lang.Runnable
            public final void run() {
                LocalMediaDataHub.I(LocalMediaDataHub.this, T);
            }
        });
        final String picPathBeforeEdit = T.getPicPathBeforeEdit();
        if (picPathBeforeEdit == null) {
            picPathBeforeEdit = T.getPath();
            Intrinsics.checkNotNull(picPathBeforeEdit);
        }
        ox3.a.a("QBaseAlbum.MediaEdit", new Function0<String>(picPathBeforeEdit, T) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$addReplaceEntry$6
            static IPatchRedirector $redirector_;
            final /* synthetic */ LocalMediaInfo $originInfo;
            final /* synthetic */ String $originPath;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$originPath = picPathBeforeEdit;
                this.$originInfo = T;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) picPathBeforeEdit, (Object) T);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "addReplaceEntry! " + this.$originPath + " ---> " + this.$originInfo.getPath();
            }
        });
        return picPathBeforeEdit;
    }

    @Nullable
    public final String F(@NotNull final String origin, @NotNull String r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) origin, (Object) r56);
        }
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(r56, "new");
        final LocalMediaInfo T = T(origin);
        if (T == null) {
            return null;
        }
        if (!com.tencent.qqnt.qbasealbum.ktx.b.j(T)) {
            this.needReplaceMap.put(com.tencent.qqnt.qbasealbum.ktx.b.b(T), T);
            com.tencent.qqnt.qbasealbum.ktx.b.r(T, true);
            T.setSystemMeidaStore(false);
            T.setPicPathBeforeEdit(origin);
        }
        T.setPath(r56);
        n0(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.datahub.h
            @Override // java.lang.Runnable
            public final void run() {
                LocalMediaDataHub.G(LocalMediaDataHub.this, T);
            }
        });
        String picPathBeforeEdit = T.getPicPathBeforeEdit();
        if (picPathBeforeEdit != null) {
            origin = picPathBeforeEdit;
        }
        ox3.a.a("QBaseAlbum.MediaEdit", new Function0<String>(origin, T) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$addReplaceEntry$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ LocalMediaInfo $originInfo;
            final /* synthetic */ String $originPath;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$originPath = origin;
                this.$originInfo = T;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) origin, (Object) T);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "addReplaceEntry! " + this.$originPath + " ---> " + this.$originInfo.getPath();
            }
        });
        return origin;
    }

    public final void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        ox3.a.c("QBaseAlbum.LocalMediaDataHub", LocalMediaDataHub$clearCache$1.INSTANCE);
        this.albumToLocalMedia.clear();
        this.localMedias.clear();
    }

    @Nullable
    public final LocalMediaInfo T(@NotNull String path) {
        Object obj;
        Object obj2;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 12, (Object) this, (Object) path);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Iterator it = new ArrayList(this.localMedias).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
                if (localMediaInfo != null) {
                    str2 = localMediaInfo.getPath();
                } else {
                    str2 = null;
                }
                if (Intrinsics.areEqual(str2, path)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) obj;
        while (localMediaInfo2 == null && J()) {
            v0();
            Iterator it5 = new ArrayList(this.localMedias).iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj2 = it5.next();
                    LocalMediaInfo localMediaInfo3 = (LocalMediaInfo) obj2;
                    if (localMediaInfo3 != null) {
                        str = localMediaInfo3.getPath();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, path)) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            localMediaInfo2 = (LocalMediaInfo) obj2;
        }
        return localMediaInfo2;
    }

    @NotNull
    public final List<LocalMediaInfo> U(@NotNull String albumId, @NotNull PageType pageType) {
        List list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, (Object) albumId, (Object) pageType);
        }
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        if (Intrinsics.areEqual(albumId, com.tencent.qqnt.qbasealbum.model.a.f361348a.a())) {
            list = this.localMedias;
        } else {
            list = this.albumToLocalMedia.get(albumId);
            if (list == null) {
                list = new ArrayList();
            }
        }
        int i3 = b.f361126a[pageType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                ArrayList arrayList = new ArrayList(list);
                list = new ArrayList();
                for (Object obj : arrayList) {
                    if (com.tencent.qqnt.qbasealbum.ktx.b.o((LocalMediaInfo) obj)) {
                        list.add(obj);
                    }
                }
            }
        } else {
            ArrayList arrayList2 = new ArrayList(list);
            list = new ArrayList();
            for (Object obj2 : arrayList2) {
                if (com.tencent.qqnt.qbasealbum.ktx.b.n((LocalMediaInfo) obj2)) {
                    list.add(obj2);
                }
            }
        }
        return list;
    }

    @NotNull
    public final LiveData<a> V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mediaUpdateLiveData;
    }

    public final boolean W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.traversalDone;
    }

    public final void Y(@NotNull MediaFilter filter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) filter);
            return;
        }
        Intrinsics.checkNotNullParameter(filter, "filter");
        synchronized (this.mediaFilterInitLock) {
            this.mediaFilter = filter;
            for (Map.Entry<String, List<LocalMediaInfo>> entry : this.albumToLocalMedia.entrySet()) {
                Iterator it = new ArrayList(entry.getValue()).iterator();
                Intrinsics.checkNotNullExpressionValue(it, "tempList.iterator()");
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    LocalMediaInfo mediaInfo = (LocalMediaInfo) it.next();
                    QAlbumMediaFilterListener qAlbumMediaFilterListener = new QAlbumMediaFilterListener(filter);
                    Intrinsics.checkNotNullExpressionValue(mediaInfo, "mediaInfo");
                    if (!qAlbumMediaFilterListener.a(mediaInfo)) {
                        arrayList.add(mediaInfo);
                        this.localMedias.remove(mediaInfo);
                    }
                }
                List<LocalMediaInfo> list = this.albumToLocalMedia.get(entry.getKey());
                if (list != null) {
                    list.removeAll(arrayList);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.loading.get();
    }

    public final void d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else if (com.tencent.qqnt.qbasealbum.inject.g.f361234b.e()) {
            p0();
        }
    }

    public final void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            m0();
        }
    }

    public final void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (!this.loading.get()) {
            if (this.localMedias.size() == 0 || this.hasTrim.compareAndSet(true, false)) {
                ox3.a.c("QBaseAlbum.LocalMediaDataHub", LocalMediaDataHub$preloadMediaData$1.INSTANCE);
                b0(true);
            }
        }
    }

    public final void g0(final int count, @NotNull final MediaFilter filter, @NotNull final Function1<? super ArrayList<LocalMediaInfo>, Unit> onResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(count), filter, onResult);
            return;
        }
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        l0(new Function0<Unit>(count, onResult, filter) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$queryMedia$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $count;
            final /* synthetic */ MediaFilter $filter;
            final /* synthetic */ Function1<ArrayList<LocalMediaInfo>, Unit> $onResult;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$queryMedia$2$1", f = "LocalMediaDataHub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$queryMedia$2$1, reason: invalid class name */
            /* loaded from: classes25.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $count;
                final /* synthetic */ MediaFilter $filter;
                final /* synthetic */ Function1<ArrayList<LocalMediaInfo>, Unit> $onResult;
                int label;
                final /* synthetic */ LocalMediaDataHub this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LocalMediaDataHub localMediaDataHub, int i3, Function1<? super ArrayList<LocalMediaInfo>, Unit> function1, MediaFilter mediaFilter, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = localMediaDataHub;
                    this.$count = i3;
                    this.$onResult = function1;
                    this.$filter = mediaFilter;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, localMediaDataHub, Integer.valueOf(i3), function1, mediaFilter, continuation);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                    }
                    return new AnonymousClass1(this.this$0, this.$count, this.$onResult, this.$filter, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    MediaQueryHelper mediaQueryHelper;
                    MediaQueryHelper mediaQueryHelper2;
                    QQCopyOnWriteArrayList qQCopyOnWriteArrayList;
                    int coerceAtMost;
                    MediaQueryHelper mediaQueryHelper3;
                    AtomicBoolean atomicBoolean;
                    int coerceAtMost2;
                    QQCopyOnWriteArrayList qQCopyOnWriteArrayList2;
                    int coerceAtMost3;
                    int coerceAtMost4;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            long currentTimeMillis = System.currentTimeMillis();
                            this.this$0.X(Boxing.boxInt(this.$count));
                            mediaQueryHelper = this.this$0.mainQueryHelper;
                            if (mediaQueryHelper != null) {
                                mediaQueryHelper2 = this.this$0.mainQueryHelper;
                                Intrinsics.checkNotNull(mediaQueryHelper2);
                                boolean h16 = MediaQueryHelper.h(mediaQueryHelper2, 0, 1, null);
                                if (h16) {
                                    this.this$0.o0(true);
                                }
                                qQCopyOnWriteArrayList = this.this$0.localMedias;
                                ArrayList arrayList = new ArrayList(qQCopyOnWriteArrayList);
                                ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>(arrayList, h16) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub.queryMedia.2.1.2
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ boolean $lessThanOnePage;
                                    final /* synthetic */ ArrayList<LocalMediaInfo> $sourceData;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                        this.$sourceData = arrayList;
                                        this.$lessThanOnePage = h16;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, arrayList, Boolean.valueOf(h16));
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    @NotNull
                                    public final String invoke() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                                        }
                                        return "queryMedia, validSize:" + this.$sourceData.size() + ", lessThanOnPage: " + this.$lessThanOnePage;
                                    }
                                });
                                coerceAtMost = RangesKt___RangesKt.coerceAtMost(100, arrayList.size());
                                List subList = arrayList.subList(0, coerceAtMost);
                                Intrinsics.checkNotNullExpressionValue(subList, "sourceData.subList(0, MI\u2026eAtMost(sourceData.size))");
                                mediaQueryHelper3 = this.this$0.mainQueryHelper;
                                if (mediaQueryHelper3 != null) {
                                    mediaQueryHelper3.c();
                                }
                                this.this$0.mainQueryHelper = null;
                                ox3.a.c("QBaseAlbum.LocalMediaDataHub", AnonymousClass3.INSTANCE);
                                this.this$0.updateMediaIndex = 0;
                                atomicBoolean = this.this$0.interrupted;
                                atomicBoolean.set(false);
                                ox3.a.h(new Function0<String>(currentTimeMillis) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub.queryMedia.2.1.4
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ long $start;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                        this.$start = currentTimeMillis;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, currentTimeMillis);
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    @NotNull
                                    public final String invoke() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                                        }
                                        return "query media finish, cost:" + (System.currentTimeMillis() - this.$start);
                                    }
                                });
                                MediaFilter mediaFilter = this.$filter;
                                ArrayList arrayList2 = new ArrayList();
                                for (Object obj2 : subList) {
                                    LocalMediaInfo it = (LocalMediaInfo) obj2;
                                    QAlbumMediaFilterListener qAlbumMediaFilterListener = new QAlbumMediaFilterListener(mediaFilter);
                                    Intrinsics.checkNotNullExpressionValue(it, "it");
                                    if (qAlbumMediaFilterListener.a(it)) {
                                        arrayList2.add(obj2);
                                    }
                                }
                                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(this.$count, arrayList2.size());
                                this.$onResult.invoke(new ArrayList<>(arrayList2.subList(0, coerceAtMost2)));
                                return Unit.INSTANCE;
                            }
                            ox3.a.c("QBaseAlbum.LocalMediaDataHub", C96821.INSTANCE);
                            qQCopyOnWriteArrayList2 = this.this$0.localMedias;
                            ArrayList arrayList3 = new ArrayList(qQCopyOnWriteArrayList2);
                            coerceAtMost3 = RangesKt___RangesKt.coerceAtMost(100, arrayList3.size());
                            List subList2 = arrayList3.subList(0, coerceAtMost3);
                            Intrinsics.checkNotNullExpressionValue(subList2, "sourceData.subList(0, MI\u2026eAtMost(sourceData.size))");
                            MediaFilter mediaFilter2 = this.$filter;
                            ArrayList arrayList4 = new ArrayList();
                            for (Object obj3 : subList2) {
                                LocalMediaInfo it5 = (LocalMediaInfo) obj3;
                                QAlbumMediaFilterListener qAlbumMediaFilterListener2 = new QAlbumMediaFilterListener(mediaFilter2);
                                Intrinsics.checkNotNullExpressionValue(it5, "it");
                                if (qAlbumMediaFilterListener2.a(it5)) {
                                    arrayList4.add(obj3);
                                }
                            }
                            Function1<ArrayList<LocalMediaInfo>, Unit> function1 = this.$onResult;
                            coerceAtMost4 = RangesKt___RangesKt.coerceAtMost(this.$count, arrayList4.size());
                            function1.invoke(new ArrayList<>(arrayList4.subList(0, coerceAtMost4)));
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$count = count;
                this.$onResult = onResult;
                this.$filter = filter;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, LocalMediaDataHub.this, Integer.valueOf(count), onResult, filter);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (com.tencent.qqnt.qbasealbum.utils.i.f361663a.a(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a())) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QAlbumCoroutineScopes.f361069a.d()), null, null, new AnonymousClass1(LocalMediaDataHub.this, this.$count, this.$onResult, this.$filter, null), 3, null);
                }
            }
        });
    }

    @NotNull
    public final ArrayList<LocalMediaInfo> h0(int count, @NotNull MediaFilter filter) {
        final int i3;
        int coerceAtMost;
        ArrayList arrayList;
        int coerceAtMost2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ArrayList) iPatchRedirector.redirect((short) 14, (Object) this, count, (Object) filter);
        }
        Intrinsics.checkNotNullParameter(filter, "filter");
        while (true) {
            if (this.updateMediaIndex == 0) {
                i3 = this.localMedias.size();
            } else {
                i3 = this.updateMediaIndex;
            }
            ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>(i3) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$queryMediaCache$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $validIndex;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$validIndex = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaDataHub.this, i3);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    int i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    i16 = LocalMediaDataHub.this.updateMediaIndex;
                    return "updateMediaIndex:" + i16 + ", validIndex:" + this.$validIndex;
                }
            });
            ArrayList arrayList2 = new ArrayList(this.localMedias);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, arrayList2.size());
            List subList = arrayList2.subList(0, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(subList, "sourceData.subList(0, va\u2026eAtMost(sourceData.size))");
            arrayList = new ArrayList();
            for (Object obj : subList) {
                LocalMediaInfo it = (LocalMediaInfo) obj;
                QAlbumMediaFilterListener qAlbumMediaFilterListener = new QAlbumMediaFilterListener(filter);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (qAlbumMediaFilterListener.a(it)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.size() >= count || !J()) {
                break;
            }
            v0();
        }
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(count, arrayList.size());
        return new ArrayList<>(arrayList.subList(0, coerceAtMost2));
    }

    public final void j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            ox3.a.c("QBaseAlbum.LocalMediaDataHub", LocalMediaDataHub$reloadMediaData$1.INSTANCE);
            l0(new Function0<Unit>() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$reloadMediaData$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaDataHub.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        LocalMediaDataHub.c0(LocalMediaDataHub.this, false, 1, null);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @MainThread
    public final void l0(@NotNull Function0<Unit> onComplete) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) onComplete);
            return;
        }
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        if (!this.loading.get()) {
            onComplete.invoke();
        } else {
            this.interrupted.set(true);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QAlbumCoroutineScopes.f361069a.d()), null, null, new LocalMediaDataHub$reset$2(this, onComplete, null), 3, null);
        }
    }

    public final void m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        Iterator<Map.Entry<LocalMediaInfo, LocalMediaInfo>> it = this.needReplaceMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<LocalMediaInfo, LocalMediaInfo> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            Map.Entry<LocalMediaInfo, LocalMediaInfo> entry = next;
            entry.getValue().setPicPathBeforeEdit(null);
            LocalMediaInfo value = entry.getValue();
            LocalMediaInfo key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "info.key");
            value.copyForEditRestore(key);
            it.remove();
        }
    }

    public final void p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QAlbumCoroutineScopes.f361069a.d()), null, null, new LocalMediaDataHub$trimCache$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    @Nullable
    public final LocalMediaInfo t0(@NotNull LocalMediaInfo info) {
        LocalMediaInfo q06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) info);
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (this.mediaFilter == null) {
            return q0(info);
        }
        synchronized (this.mediaFilterInitLock) {
            q06 = q0(info);
        }
        return q06;
    }

    public final void u0(long id5, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Long.valueOf(id5), path);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        LocalMediaInfo localMediaInfo = this.idToLocalMedia.get(Long.valueOf(id5));
        if (localMediaInfo != null) {
            localMediaInfo.setPath(path);
        }
        if (localMediaInfo != null) {
            localMediaInfo.initExtData();
        }
        this.idToLocalMedia.remove(Long.valueOf(id5));
        if (InitDataUtil.f361625a.a()) {
            N(localMediaInfo, path);
        }
    }

    public final void v0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        try {
            synchronized (this.mediaLock) {
                this.mediaLock.wait(200L);
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e16) {
            ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$waitForNewMedia$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Exception $exception;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$exception = e16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "waitForNewMedia exception: " + this.$exception.getMessage();
                }
            });
        }
    }
}
