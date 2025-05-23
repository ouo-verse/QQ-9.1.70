package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.QFSPublicAccountStaggeredRepo;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.b;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.c;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J.\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0016\u0010\u0012\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\u0010j\u0002`\u0011J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010!R*\u0010\u0012\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0006\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R<\u0010*\u001a\u001c\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0018\u0012\u0004\u0012\u00020\u000b\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010&\u001a\u0004\b'\u0010(\"\u0004\b#\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/QFSPublicAccountStaggerPositiveActionCollector;", "", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "", "enterFeedId", "", "Le30/b;", "feeds", "", com.tencent.luggage.wxa.c8.c.G, "", "g", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "curPos", "Lkotlin/Function0;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewmodel/CurrentFeedIds;", "currentFeedIds", "c", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/b$c;", "positiveAction", "e", "d", "Lcom/tencent/richframework/data/base/UIStateData;", "b", "Lcom/tencent/richframework/data/base/UIStateData;", "insertData", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo;", "repo", "Lfeedcloud/FeedCloudMeta$StFeed;", "enterImmersiveFeed", "I", "enterImmersiveFeedPos", "f", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getOnLeaveImmersiveCallback", "()Lkotlin/jvm/functions/Function1;", "(Lkotlin/jvm/functions/Function1;)V", "onLeaveImmersiveCallback", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggerPositiveActionCollector {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSPublicAccountStaggerPositiveActionCollector f86891a = new QFSPublicAccountStaggerPositiveActionCollector();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static UIStateData<List<e30.b>> insertData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final QFSPublicAccountStaggeredRepo repo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static FeedCloudMeta$StFeed enterImmersiveFeed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int enterImmersiveFeedPos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function0<? extends List<String>> currentFeedIds;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function1<? super UIStateData<List<e30.b>>, Unit> onLeaveImmersiveCallback;

    static {
        UIStateData<List<e30.b>> obtainEmpty = UIStateData.obtainEmpty();
        Intrinsics.checkNotNullExpressionValue(obtainEmpty, "obtainEmpty()");
        insertData = obtainEmpty;
        repo = new QFSPublicAccountStaggeredRepo();
        enterImmersiveFeedPos = -1;
    }

    QFSPublicAccountStaggerPositiveActionCollector() {
    }

    private final void g(QCircleInitBean initBean, String enterFeedId, List<e30.b> feeds, int pos) {
        int collectionSizeOrDefault;
        c.Companion companion = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.c.INSTANCE;
        if (!companion.a(com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.c(initBean)).g(enterFeedId)) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.c a16 = companion.a(com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.c(initBean));
        List<e30.b> list = feeds;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((e30.b) it.next()).g().get());
        }
        a16.b(arrayList, pos);
    }

    public final void c(@NotNull FeedCloudMeta$StFeed feed, int curPos, @NotNull Function0<? extends List<String>> currentFeedIds2) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(currentFeedIds2, "currentFeedIds");
        QLog.i("QFSPublicAccountPositiveAction.Staggered", 1, "onEnterImmersivePage, feed=" + feed.f398449id.get() + " curPos=" + curPos);
        enterImmersiveFeed = feed;
        enterImmersiveFeedPos = curPos;
        currentFeedIds = currentFeedIds2;
        UIStateData<List<e30.b>> obtainEmpty = UIStateData.obtainEmpty();
        Intrinsics.checkNotNullExpressionValue(obtainEmpty, "obtainEmpty()");
        insertData = obtainEmpty;
    }

    public final void d(@NotNull QCircleInitBean initBean) {
        String str;
        String str2;
        String str3;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = enterImmersiveFeed;
        if (feedCloudMeta$StFeed != null && (pBStringField2 = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        int i3 = enterImmersiveFeedPos;
        List<e30.b> data = insertData.getData();
        if (data != null) {
            str2 = CollectionsKt___CollectionsKt.joinToString$default(data, null, null, null, 0, null, new Function1<e30.b, CharSequence>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerPositiveActionCollector$onLeaveImmersivePage$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull e30.b it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String str4 = it.g().f398449id.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "it.sourceData.id.get()");
                    return str4;
                }
            }, 31, null);
        } else {
            str2 = null;
        }
        boolean z16 = true;
        QLog.i("QFSPublicAccountPositiveAction.Staggered", 1, "onLeaveImmersivePage, feed=" + str + " curPos=" + i3 + " insertData=" + str2);
        List<e30.b> data2 = insertData.getData();
        if (data2 != null && !data2.isEmpty()) {
            z16 = false;
        }
        if (!z16) {
            UIStateData uiStateData = UIStateData.obtainInsert(insertData.getPos()).setDataList(insertData.getData()).setFinish(false);
            Function1<? super UIStateData<List<e30.b>>, Unit> function1 = onLeaveImmersiveCallback;
            if (function1 != null) {
                Intrinsics.checkNotNullExpressionValue(uiStateData, "uiStateData");
                function1.invoke(uiStateData);
            }
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = enterImmersiveFeed;
            if (feedCloudMeta$StFeed2 != null && (pBStringField = feedCloudMeta$StFeed2.f398449id) != null) {
                str3 = pBStringField.get();
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = "";
            }
            List<e30.b> data3 = insertData.getData();
            Intrinsics.checkNotNullExpressionValue(data3, "insertData.data");
            g(initBean, str3, data3, insertData.getPos());
        }
        UIStateData<List<e30.b>> obtainEmpty = UIStateData.obtainEmpty();
        Intrinsics.checkNotNullExpressionValue(obtainEmpty, "obtainEmpty()");
        insertData = obtainEmpty;
        enterImmersiveFeed = null;
        enterImmersiveFeedPos = -1;
        currentFeedIds = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.removePrefix(r0, (java.lang.CharSequence) "share_fake_");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(@NotNull b.PositiveAction positiveAction) {
        PBStringField pBStringField;
        String removePrefix;
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(positiveAction, "positiveAction");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = enterImmersiveFeed;
        if (feedCloudMeta$StFeed == null || (pBStringField = feedCloudMeta$StFeed.f398449id) == null || (r0 = pBStringField.get()) == null || removePrefix == null || enterImmersiveFeedPos == -1 || !Intrinsics.areEqual(removePrefix, positiveAction.getFeed().f398449id.get())) {
            return;
        }
        Function0<? extends List<String>> function0 = currentFeedIds;
        if (function0 == null || (emptyList = function0.invoke()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        repo.A(positiveAction.getFeed(), 74, positiveAction.getActionType(), emptyList, new Function1<QFSPublicAccountStaggeredRepo.GetFeedResult, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerPositiveActionCollector$onTriggerPositiveAction$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSPublicAccountStaggeredRepo.GetFeedResult getFeedResult) {
                invoke2(getFeedResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QFSPublicAccountStaggeredRepo.GetFeedResult result) {
                int i3;
                Intrinsics.checkNotNullParameter(result, "result");
                i3 = QFSPublicAccountStaggerPositiveActionCollector.enterImmersiveFeedPos;
                UIStateData uiStateData = UIStateData.obtainInsert(i3 + 1).setDataList(result.c()).setFinish(false);
                Intrinsics.checkNotNullExpressionValue(uiStateData, "uiStateData");
                QFSPublicAccountStaggerPositiveActionCollector.insertData = uiStateData;
            }
        });
    }

    public final void f(@Nullable Function1<? super UIStateData<List<e30.b>>, Unit> function1) {
        onLeaveImmersiveCallback = function1;
    }
}
