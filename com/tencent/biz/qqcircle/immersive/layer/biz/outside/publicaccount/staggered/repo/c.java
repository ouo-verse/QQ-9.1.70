package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo;

import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001fB\u0011\b\u0002\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\f\u0010\b\u001a\u00020\u0004*\u00020\u0007H\u0002J\f\u0010\n\u001a\u00020\t*\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007J\u001e\u0010\u0017\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0010J\u0016\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0007J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0007R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0014\u0010$\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0014\u0010%\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010)R.\u00100\u001a\u0004\u0018\u00010\u00022\b\u0010+\u001a\u0004\u0018\u00010\u00028B@BX\u0082\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010,\u001a\u0004\b\f\u0010-\"\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/c;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "j", "f", "Lfeedcloud/FeedCloudRead$StGetFeedListRsp;", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "e", "i", "rsp", DomainData.DOMAIN_NAME, "", "redDotFeedId", "c", "", "feeds", "", com.tencent.luggage.wxa.c8.c.G, "b", "feedId", "", "g", "feedIdList", tl.h.F, "d", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/Scene;", "a", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/Scene;", "scene", "Ljava/lang/String;", "logTag", "lastCachedKey", "lastRedDotFeedKey", "Lfeedcloud/FeedCloudRead$StGetFeedListRsp;", "currentCached", "", "Ljava/util/List;", "currentCachedFeedIdList", "value", "Lfeedcloud/FeedCloudMeta$StFeed;", "()Lfeedcloud/FeedCloudMeta$StFeed;", "l", "(Lfeedcloud/FeedCloudMeta$StFeed;)V", "lastRedDotFeed", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/Scene;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<Scene, c> f86977i = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Scene scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String lastCachedKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String lastRedDotFeedKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudRead$StGetFeedListRsp currentCached;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> currentCachedFeedIdList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed lastRedDotFeed;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/c$a;", "", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/Scene;", "scene", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/c;", "a", "", "b", "", "LAST_CACHED_KEY", "Ljava/lang/String;", "LAST_RED_DOT_FEED_KEY", "", "MAX_CACHED_SIZE", "I", "Ljava/util/concurrent/ConcurrentHashMap;", "instanceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.c$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final c a(@NotNull Scene scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            c cVar = (c) c.f86977i.get(scene);
            if (cVar != null) {
                return cVar;
            }
            synchronized (c.class) {
                c cVar2 = (c) c.f86977i.get(scene);
                if (cVar2 == null) {
                    c cVar3 = new c(scene, null);
                    c.f86977i.put(scene, cVar3);
                    return cVar3;
                }
                Intrinsics.checkNotNullExpressionValue(cVar2, "instanceMap[scene]\n     \u2026 it\n                    }");
                return cVar2;
            }
        }

        public final void b() {
            synchronized (c.class) {
                c.f86977i.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        Companion() {
        }
    }

    public /* synthetic */ c(Scene scene, DefaultConstructorMarker defaultConstructorMarker) {
        this(scene);
    }

    private final FeedCloudMeta$StFeed e() {
        if (this.lastRedDotFeed == null) {
            this.lastRedDotFeed = f();
        }
        return this.lastRedDotFeed;
    }

    private final FeedCloudMeta$StFeed f() {
        try {
            return new FeedCloudMeta$StFeed().mergeFrom(uq3.k.a().d(this.lastRedDotFeedKey, new byte[0]));
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(this.logTag, 1, "parse last red dot feed failed, e=" + e16.getMessage(), e16);
            return null;
        }
    }

    private final void i(Throwable e16) {
        String stackTraceToString;
        HashMap<String, String> hashMapOf;
        String str;
        QLog.e(this.logTag, 1, "toByteArraySafely, e=" + e16.getMessage(), e16);
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("error_tag", this.logTag);
        stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
        pairArr[1] = TuplesKt.to("error_msg", stackTraceToString);
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (account == null) {
            account = "";
        }
        pairArr[2] = TuplesKt.to("uin", account);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        StatisticCollector statisticCollector = StatisticCollector.getInstance(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getApplicationContext());
        String account2 = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (account2 == null) {
            str = "";
        } else {
            str = account2;
        }
        statisticCollector.collectPerformance("0DOU0QDD2U4LOCOP", str, "ec_quality_error_log", true, -1L, -1L, hashMapOf, (String) null, true);
    }

    private final void j(FeedCloudMeta$StFeed feed) {
        try {
            uq3.k.a().k(this.lastRedDotFeedKey, feed.toByteArray());
        } catch (Throwable th5) {
            QLog.e(this.logTag, 1, "save last red dot feed failed, e=" + th5.getMessage(), th5);
        }
    }

    private final void k(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        synchronized (feedCloudRead$StGetFeedListRsp) {
            uq3.k.a().k(this.lastCachedKey, m(feedCloudRead$StGetFeedListRsp));
            n(feedCloudRead$StGetFeedListRsp);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void l(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.lastRedDotFeed = feedCloudMeta$StFeed;
        if (feedCloudMeta$StFeed != null) {
            j(feedCloudMeta$StFeed);
        }
    }

    private final byte[] m(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        try {
            int serializedSize = feedCloudRead$StGetFeedListRsp.getSerializedSize();
            byte[] bArr = new byte[serializedSize];
            CodedOutputStreamMicro newInstance = CodedOutputStreamMicro.newInstance(bArr, 0, serializedSize);
            feedCloudRead$StGetFeedListRsp.writeTo(newInstance);
            newInstance.checkNoSpaceLeft();
            return bArr;
        } catch (Throwable th5) {
            i(th5);
            return new byte[0];
        }
    }

    private final void n(FeedCloudRead$StGetFeedListRsp rsp) {
        PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField;
        List<FeedCloudMeta$StFeed> list;
        this.currentCached = rsp;
        this.currentCachedFeedIdList.clear();
        if (rsp != null && (pBRepeatMessageField = rsp.vecFeed) != null && (list = pBRepeatMessageField.get()) != null) {
            for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
                List<String> list2 = this.currentCachedFeedIdList;
                String str = feedCloudMeta$StFeed.f398449id.get();
                Intrinsics.checkNotNullExpressionValue(str, "it.id.get()");
                list2.add(str);
            }
        }
    }

    @WorkerThread
    public final void b(@NotNull List<FeedCloudMeta$StFeed> feeds, int pos) {
        List<FeedCloudMeta$StFeed> take;
        Intrinsics.checkNotNullParameter(feeds, "feeds");
        synchronized (this) {
            FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = this.currentCached;
            if (feedCloudRead$StGetFeedListRsp == null && (feedCloudRead$StGetFeedListRsp = d()) == null) {
                return;
            }
            List<FeedCloudMeta$StFeed> oldList = feedCloudRead$StGetFeedListRsp.vecFeed.get();
            if (pos >= 0 && pos <= oldList.size()) {
                oldList.addAll(pos, feeds);
                Intrinsics.checkNotNullExpressionValue(oldList, "oldList");
                take = CollectionsKt___CollectionsKt.take(oldList, 16);
                feedCloudRead$StGetFeedListRsp.vecFeed.set(take);
                k(feedCloudRead$StGetFeedListRsp);
                Unit unit = Unit.INSTANCE;
                return;
            }
            QLog.i(this.logTag, 1, "addFeedsToCached failed, indexOutOfBounds pos=" + pos + " size=" + oldList.size());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055 A[Catch: all -> 0x00b5, TryCatch #0 {, blocks: (B:4:0x0007, B:5:0x0019, B:7:0x001f, B:11:0x0038, B:13:0x003e, B:20:0x004f, B:22:0x0055, B:23:0x00ae, B:29:0x005b, B:33:0x0072, B:34:0x0083, B:36:0x0089, B:41:0x00a1, B:38:0x009d), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(@NotNull FeedCloudRead$StGetFeedListRsp rsp, @Nullable String redDotFeedId) {
        Object obj;
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        synchronized (this) {
            List<FeedCloudMeta$StFeed> list = rsp.vecFeed.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.vecFeed.get()");
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    FeedCloudMeta$StFeed it5 = (FeedCloudMeta$StFeed) obj;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    if (Intrinsics.areEqual(com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.c(it5), redDotFeedId)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) obj;
            if (redDotFeedId != null && redDotFeedId.length() != 0) {
                z16 = false;
                if (z16 && feedCloudMeta$StFeed != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                FeedCloudMeta$StFeed e16 = e();
                if (!z17) {
                    l(feedCloudMeta$StFeed);
                } else if (e16 != null) {
                    String str = e16.f398449id.get();
                    Intrinsics.checkNotNullExpressionValue(str, "feed.id.get()");
                    if (str.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        List<FeedCloudMeta$StFeed> list2 = rsp.vecFeed.get();
                        Intrinsics.checkNotNullExpressionValue(list2, "rsp.vecFeed.get()");
                        Iterator<FeedCloudMeta$StFeed> it6 = list2.iterator();
                        int i3 = 0;
                        while (true) {
                            if (it6.hasNext()) {
                                FeedCloudMeta$StFeed it7 = it6.next();
                                Intrinsics.checkNotNullExpressionValue(it7, "it");
                                if (!com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.e(it7)) {
                                    break;
                                } else {
                                    i3++;
                                }
                            } else {
                                i3 = -1;
                                break;
                            }
                        }
                        rsp.vecFeed.get().add(Math.max(i3, 0), e16);
                    }
                }
                k(rsp);
                Unit unit = Unit.INSTANCE;
            }
            z16 = true;
            if (z16) {
            }
            z17 = false;
            FeedCloudMeta$StFeed e162 = e();
            if (!z17) {
            }
            k(rsp);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @WorkerThread
    @Nullable
    public final FeedCloudRead$StGetFeedListRsp d() {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp;
        synchronized (this) {
            try {
                feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp().mergeFrom(uq3.k.a().d(this.lastCachedKey, new byte[0]));
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(this.logTag, 1, "fetchLastCached failed, e=" + e16.getMessage(), e16);
                feedCloudRead$StGetFeedListRsp = null;
            }
            n(feedCloudRead$StGetFeedListRsp);
        }
        return feedCloudRead$StGetFeedListRsp;
    }

    public final boolean g(@NotNull String feedId) {
        boolean contains;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        synchronized (this) {
            contains = this.currentCachedFeedIdList.contains(feedId);
        }
        return contains;
    }

    @WorkerThread
    public final void h(@NotNull List<String> feedIdList) {
        String str;
        boolean contains;
        Intrinsics.checkNotNullParameter(feedIdList, "feedIdList");
        synchronized (this) {
            FeedCloudMeta$StFeed e16 = e();
            if (e16 != null) {
                str = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.c(e16);
            } else {
                str = null;
            }
            contains = CollectionsKt___CollectionsKt.contains(feedIdList, str);
            if (contains) {
                l(null);
            }
            FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = this.currentCached;
            if (feedCloudRead$StGetFeedListRsp == null && (feedCloudRead$StGetFeedListRsp = d()) == null) {
                return;
            }
            List<FeedCloudMeta$StFeed> oldList = feedCloudRead$StGetFeedListRsp.vecFeed.get();
            Intrinsics.checkNotNullExpressionValue(oldList, "oldList");
            ArrayList arrayList = new ArrayList();
            for (Object obj : oldList) {
                if (!feedIdList.contains(((FeedCloudMeta$StFeed) obj).f398449id.get())) {
                    arrayList.add(obj);
                }
            }
            feedCloudRead$StGetFeedListRsp.vecFeed.set(arrayList);
            k(feedCloudRead$StGetFeedListRsp);
            Unit unit = Unit.INSTANCE;
        }
    }

    c(Scene scene) {
        String str;
        String str2;
        this.scene = scene;
        this.logTag = scene + "_QFSPublicAccountStaggeredCachedManager";
        Scene scene2 = Scene.Q_CIRCLE_PUBLIC_ACCOUNT_MSG_TAG;
        if (scene == scene2) {
            str = "GetStaggeredListReq.lastCachedMMKVKey";
        } else {
            str = scene.name() + "_GetStaggeredListReq.lastCachedMMKVKey";
        }
        this.lastCachedKey = str;
        if (scene == scene2) {
            str2 = "GetStaggeredListReq.lastRedDotFeedKey";
        } else {
            str2 = scene.name() + "_GetStaggeredListReq.lastRedDotFeedKey";
        }
        this.lastRedDotFeedKey = str2;
        this.currentCachedFeedIdList = new ArrayList();
    }
}
