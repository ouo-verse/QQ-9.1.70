package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kn1.FeedPublishStateV2;
import kn1.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0005B\u00b3\u0001\u0012\u0019\u0010\u001d\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019\u00a2\u0006\u0002\b\u001b\u0012\u001d\u0010!\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b0\u001e\u00a2\u0006\u0002\b\u001b\u0012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00028\u00000\u0019\u0012-\u0010(\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0012\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00070\u0019\u0012-\u0010)\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0012\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u0019\u00a2\u0006\u0004\b1\u00102J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007*\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\t\u001a\u00020\bH\u0002J\u001b\u0010\f\u001a\u00020\u000b*\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0016\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0002J\u0016\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0002J\u0016\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0002J\u0016\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0002J\u0014\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012R'\u0010\u001d\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019\u00a2\u0006\u0002\b\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR+\u0010!\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b0\u001e\u00a2\u0006\u0002\b\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010 R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00028\u00000\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001cR;\u0010(\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0012\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00070\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001cR;\u0010)\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0012\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010*R\u0016\u0010,\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010*R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010-R\u0017\u00100\u001a\u0004\u0018\u00010\u001a*\u00028\u00008F\u00a2\u0006\u0006\u001a\u0004\b'\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/k;", "T", "", "Lkn1/b;", "stateV2", "a", "(Lkn1/b;)Ljava/lang/Object;", "", "", QAdRewardDefine$VideoParams.ISCACHE, "c", "", "i", "(Ljava/lang/Object;Lkn1/b;)V", "", "b", "time", "k", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/d;", "args", "e", "g", tl.h.F, "f", "j", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function1;", "stFeedGetter", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "Lkotlin/jvm/functions/Function2;", "taskProgressStateSetter", "constructT", "Lkotlin/ParameterName;", "name", "argus", "Lkn1/a$b;", "d", "finishedFeedGetter", "failStateV2Getter", "J", "lastFillCreateTimeNs", "lastFillCreateTimeNsCache", "Z", "hasActivePublishingFeed", "(Ljava/lang/Object;)Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "sourceData", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<T, GProStFeed> stFeedGetter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<T, GuildTaskProgressState, Unit> taskProgressStateSetter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<GProStFeed, T> constructT;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<d<T>, List<a.FeedPublishFinish>> finishedFeedGetter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<d<T>, List<FeedPublishStateV2>> failStateV2Getter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastFillCreateTimeNs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long lastFillCreateTimeNsCache;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasActivePublishingFeed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((FeedPublishStateV2) t17).getStFeed().createTimeNs), Long.valueOf(((FeedPublishStateV2) t16).getStFeed().createTimeNs));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((GProStFeed) t16).createTimeNs), Long.valueOf(((GProStFeed) t17).createTimeNs));
            return compareValues;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@NotNull Function1<? super T, GProStFeed> stFeedGetter, @NotNull Function2<? super T, ? super GuildTaskProgressState, Unit> taskProgressStateSetter, @NotNull Function1<? super GProStFeed, ? extends T> constructT, @NotNull Function1<? super d<T>, ? extends List<a.FeedPublishFinish>> finishedFeedGetter, @NotNull Function1<? super d<T>, ? extends List<FeedPublishStateV2>> failStateV2Getter) {
        Intrinsics.checkNotNullParameter(stFeedGetter, "stFeedGetter");
        Intrinsics.checkNotNullParameter(taskProgressStateSetter, "taskProgressStateSetter");
        Intrinsics.checkNotNullParameter(constructT, "constructT");
        Intrinsics.checkNotNullParameter(finishedFeedGetter, "finishedFeedGetter");
        Intrinsics.checkNotNullParameter(failStateV2Getter, "failStateV2Getter");
        this.stFeedGetter = stFeedGetter;
        this.taskProgressStateSetter = taskProgressStateSetter;
        this.constructT = constructT;
        this.finishedFeedGetter = finishedFeedGetter;
        this.failStateV2Getter = failStateV2Getter;
        this.lastFillCreateTimeNs = Long.MAX_VALUE;
        this.lastFillCreateTimeNsCache = Long.MAX_VALUE;
    }

    private final T a(FeedPublishStateV2 stateV2) {
        T invoke = this.constructT.invoke(stateV2.getStFeed());
        this.taskProgressStateSetter.invoke(invoke, stateV2.getTaskState());
        return invoke;
    }

    private final long b(boolean isCache) {
        if (isCache) {
            return this.lastFillCreateTimeNsCache;
        }
        return this.lastFillCreateTimeNs;
    }

    private final List<FeedPublishStateV2> c(List<FeedPublishStateV2> list, boolean z16) {
        boolean z17;
        ArrayList arrayList = new ArrayList();
        for (T t16 : list) {
            if (((FeedPublishStateV2) t16).getStFeed().createTimeNs < b(z16)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList.add(t16);
            }
        }
        return arrayList;
    }

    private final void e(d<T> args) {
        if (args.getIsSquare() && !args.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String() && !args.getIsCache() && !this.hasActivePublishingFeed) {
            this.hasActivePublishingFeed = true;
            ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).activePublishingFeed(args.getGuildId());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016f A[EDGE_INSN: B:72:0x016f->B:73:0x016f BREAK  A[LOOP:4: B:45:0x010e->B:86:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[LOOP:4: B:45:0x010e->B:86:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f(d<T> args) {
        List sortedWith;
        int collectionSizeOrDefault;
        T t16;
        Long l3;
        GProStChannelInfo gProStChannelInfo;
        GProStChannelSign gProStChannelSign;
        String str;
        ListIterator<T> listIterator;
        long j3;
        T t17;
        String str2;
        boolean z16;
        boolean z17;
        String str3;
        String clientTaskId;
        boolean z18;
        GProStUser gProStUser;
        List<FeedPublishStateV2> invoke = this.failStateV2Getter.invoke(args);
        if (!invoke.isEmpty()) {
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(invoke, new b());
            if (!args.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String()) {
                k(args.getIsCache(), Long.MAX_VALUE);
            }
            List list = sortedWith;
            List<FeedPublishStateV2> arrayList = new ArrayList<>();
            for (T t18 : list) {
                if (com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(((FeedPublishStateV2) t18).getStFeed())) {
                    arrayList.add(t18);
                }
            }
            List<FeedPublishStateV2> c16 = c(arrayList, args.getIsCache());
            ArrayList<FeedPublishStateV2> arrayList2 = new ArrayList();
            for (T t19 : list) {
                if (!com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(((FeedPublishStateV2) t19).getStFeed())) {
                    arrayList2.add(t19);
                }
            }
            Logger.f235387a.d().i("GuildFillPublishFeedHelper", 1, "handleFillFakeFeeds localPublishFeedSize:" + c16.size() + " normalPublishFeed:" + arrayList2.size());
            for (FeedPublishStateV2 feedPublishStateV2 : c16) {
                ListIterator<T> listIterator2 = args.b().listIterator();
                int i3 = 0;
                while (true) {
                    if (listIterator2.hasNext()) {
                        T next = listIterator2.next();
                        long j16 = feedPublishStateV2.getStFeed().createTimeNs;
                        GProStFeed d16 = d(next);
                        if (d16 != null) {
                            listIterator = listIterator2;
                            j3 = d16.createTimeNs;
                        } else {
                            listIterator = listIterator2;
                            j3 = Long.MAX_VALUE;
                        }
                        if (j16 >= j3) {
                            Iterator<T> it = args.b().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    t17 = it.next();
                                    GProStFeed d17 = d(t17);
                                    if (d17 != null && (gProStUser = d17.poster) != null) {
                                        str2 = gProStUser.idd;
                                    } else {
                                        str2 = null;
                                    }
                                    if (Intrinsics.areEqual(str2, feedPublishStateV2.getStFeed().poster.idd)) {
                                        GProStFeed d18 = d(t17);
                                        if (d18 != null && (clientTaskId = d18.clientTaskId) != null) {
                                            Intrinsics.checkNotNullExpressionValue(clientTaskId, "clientTaskId");
                                            if (clientTaskId.length() > 0) {
                                                z18 = true;
                                            } else {
                                                z18 = false;
                                            }
                                            if (z18) {
                                                z17 = true;
                                                if (z17) {
                                                    GProStFeed d19 = d(t17);
                                                    if (d19 != null) {
                                                        str3 = d19.clientTaskId;
                                                    } else {
                                                        str3 = null;
                                                    }
                                                    if (Intrinsics.areEqual(str3, feedPublishStateV2.getTaskId())) {
                                                        z16 = true;
                                                        if (!z16) {
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        z17 = false;
                                        if (z17) {
                                        }
                                    }
                                    z16 = false;
                                    if (!z16) {
                                    }
                                } else {
                                    t17 = null;
                                    break;
                                }
                            }
                            if (t17 == null) {
                                args.b().add(i3, a(feedPublishStateV2));
                            } else {
                                Logger logger = Logger.f235387a;
                                Logger.b bVar = new Logger.b();
                                String str4 = "handleFillFakeFeeds addLocalPublishFeed find match taskId:" + feedPublishStateV2.getTaskId();
                                if (str4 instanceof String) {
                                    bVar.a().add(str4);
                                }
                                Iterator<T> it5 = bVar.a().iterator();
                                while (it5.hasNext()) {
                                    Logger.f235387a.d().e("GuildFillPublishFeedHelper", 1, (String) it5.next(), null);
                                }
                            }
                            k(args.getIsCache(), feedPublishStateV2.getStFeed().createTimeNs);
                            Logger.f235387a.d().i("GuildFillPublishFeedHelper", 1, "handleFillFakeFeeds addLocalPublishFeed:" + feedPublishStateV2.getStFeed().idd + " createTimeNs:" + feedPublishStateV2.getStFeed().createTimeNs + " findIndex:" + i3);
                        } else {
                            i3++;
                            listIterator2 = listIterator;
                        }
                    }
                }
            }
            for (FeedPublishStateV2 feedPublishStateV22 : arrayList2) {
                Iterator<T> it6 = args.b().iterator();
                while (true) {
                    if (it6.hasNext()) {
                        t16 = it6.next();
                        GProStFeed d26 = d(t16);
                        if (d26 != null) {
                            str = d26.idd;
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(str, feedPublishStateV22.getStFeed().idd)) {
                            break;
                        }
                    } else {
                        t16 = null;
                        break;
                    }
                }
                if (t16 != null) {
                    long j17 = feedPublishStateV22.getStFeed().channelInfo.sign.channelId;
                    GProStFeed d27 = d(t16);
                    if (d27 != null && (gProStChannelInfo = d27.channelInfo) != null && (gProStChannelSign = gProStChannelInfo.sign) != null) {
                        l3 = Long.valueOf(gProStChannelSign.channelId);
                    } else {
                        l3 = null;
                    }
                    if (l3 != null && l3.longValue() == j17) {
                        i(t16, feedPublishStateV22);
                        Logger.f235387a.d().i("GuildFillPublishFeedHelper", 1, "handleFillFakeFeeds modifySvrPublishFeed:" + feedPublishStateV22.getStFeed().idd + " createTimeNs:" + feedPublishStateV22.getStFeed().createTimeNs);
                    } else {
                        Logger logger2 = Logger.f235387a;
                        Logger.b bVar2 = new Logger.b();
                        String str5 = "handleFillFakeFeeds modifySvrPublishFeed channelId not match svrFeedChannelId:" + l3 + " publishChannelId:" + j17;
                        if (str5 instanceof String) {
                            bVar2.a().add(str5);
                        }
                        Iterator<T> it7 = bVar2.a().iterator();
                        while (it7.hasNext()) {
                            Logger.f235387a.d().e("GuildFillPublishFeedHelper", 1, (String) it7.next(), null);
                        }
                    }
                }
            }
            if (args.getIsFinish()) {
                List<FeedPublishStateV2> c17 = c(c16, args.getIsCache());
                if (!c17.isEmpty()) {
                    List<T> b16 = args.b();
                    List<FeedPublishStateV2> list2 = c17;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it8 = list2.iterator();
                    while (it8.hasNext()) {
                        arrayList3.add(a((FeedPublishStateV2) it8.next()));
                    }
                    b16.addAll(arrayList3);
                    k(args.getIsCache(), 0L);
                    Logger.f235387a.d().i("GuildFillPublishFeedHelper", 1, "handleFillFakeFeeds add when isFinish localPublishFeedSize:" + c17.size());
                    return;
                }
                return;
            }
            return;
        }
        Logger.f235387a.d().i("GuildFillPublishFeedHelper", 1, "handleFillFakeFeeds end publishFeeds isEmpty");
    }

    private final void g(d<T> args) {
        if (args.getSortMode() != 3) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Logger logger = Logger.f235387a;
        logger.d().i("GuildFillPublishFeedHelper", 1, "handleFillFeed begin args:" + args);
        h(args);
        f(args);
        logger.d().i("GuildFillPublishFeedHelper", 1, "handleFillFeed end cost(ms):" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h(d<T> args) {
        int collectionSizeOrDefault;
        List<GProStFeed> sortedWith;
        Object firstOrNull;
        long j3;
        Object obj;
        GProStFeed d16;
        if (!args.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String()) {
            List<a.FeedPublishFinish> invoke = this.finishedFeedGetter.invoke(args);
            ArrayList arrayList = new ArrayList();
            for (T t16 : invoke) {
                if (true ^ ((a.FeedPublishFinish) t16).getState().getTaskState().isEdit()) {
                    arrayList.add(t16);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((a.FeedPublishFinish) it.next()).getState().getStFeed());
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new c());
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) args.b());
            if (firstOrNull != null && (d16 = d(firstOrNull)) != null) {
                j3 = d16.createTimeNs;
            } else {
                j3 = 0;
            }
            Logger.f235387a.d().i("GuildFillPublishFeedHelper", 1, "handleFillTempFinishedFeeds finishedFeedsStateSize:" + invoke.size() + " finishedFeedsSize:" + sortedWith.size() + " maxSvrFeedCreateTime:" + j3);
            for (GProStFeed gProStFeed : sortedWith) {
                if (gProStFeed.createTimeNs > j3) {
                    Iterator<T> it5 = args.b().iterator();
                    while (true) {
                        obj = null;
                        if (!it5.hasNext()) {
                            break;
                        }
                        T next = it5.next();
                        GProStFeed d17 = d(next);
                        if (d17 != null) {
                            obj = d17.idd;
                        }
                        if (Intrinsics.areEqual(obj, gProStFeed.idd)) {
                            obj = next;
                            break;
                        }
                    }
                    if (obj == null) {
                        args.b().add(0, this.constructT.invoke(gProStFeed));
                        Logger.f235387a.d().i("GuildFillPublishFeedHelper", 1, "handleFillTempFinishedFeeds add finishedFeed id:" + gProStFeed.idd + " createTimeNs:" + gProStFeed.createTimeNs + " maxSvrFeedCreateTime:" + j3);
                    }
                }
            }
        }
    }

    private final void i(T t16, FeedPublishStateV2 feedPublishStateV2) {
        GProStFeed d16 = d(t16);
        if (d16 != null) {
            com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.m(d16, feedPublishStateV2.getStFeed());
        }
        this.taskProgressStateSetter.invoke(t16, feedPublishStateV2.getTaskState());
    }

    private final void k(boolean isCache, long time) {
        Logger.f235387a.d().i("GuildFillPublishFeedHelper", 1, "handleFillFakeFeeds setLastFillCreateTimeNs isCache:" + isCache + " time:" + time);
        if (isCache) {
            this.lastFillCreateTimeNsCache = time;
        } else {
            this.lastFillCreateTimeNs = time;
        }
    }

    @Nullable
    public final GProStFeed d(T t16) {
        return this.stFeedGetter.invoke(t16);
    }

    public final void j(@NotNull d<T> args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (ch.j0(args.getGuildId())) {
            Logger.f235387a.d().i("GuildFillPublishFeedHelper", 1, "onSvrFeedsRsp isGuest");
        } else {
            g(args);
            e(args);
        }
    }
}
