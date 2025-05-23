package com.tencent.mobileqq.guild.quicksearch;

import com.tencent.guild.aio.util.y;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedSearchApi;
import com.tencent.mobileqq.guild.quicksearch.e;
import com.tencent.mobileqq.guild.quicksearch.model.GuildSearchActionSource;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchNewSearchRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.dj;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/e;", "Lcom/tencent/mobileqq/mvvm/a;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchNewSearchRsp;", "searchRsp", "", "needRemoveAiCard", "Lcom/tencent/mobileqq/guild/quicksearch/model/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/quicksearch/model/a;", "searchParam", "Lcom/tencent/mobileqq/guild/quicksearch/model/GuildSearchActionSource;", "source", "Lcom/tencent/mobileqq/guild/quicksearch/e$a;", "callback", "", "k", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f231611a = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/e$a;", "T", "", "", "errCode", "", "errMsg", "result", "", "a", "(ILjava/lang/String;Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface a<T> {
        void a(int errCode, @Nullable String errMsg, T result);
    }

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(a callback, com.tencent.mobileqq.guild.quicksearch.model.a searchParam, GuildSearchActionSource source, int i3, String str, IGProGuildSearchNewSearchRsp searchRsp) {
        IGProGuildSearchUnionResult iGProGuildSearchUnionResult;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(searchParam, "$searchParam");
        Intrinsics.checkNotNullParameter(source, "$source");
        if (!y.b(i3)) {
            Logger.f235387a.d().w("QQGuildInSearchTag.GuildQuickSearchRepo", 1, "loadData(" + source + ", " + searchParam + ") failed: " + i3 + " - " + str);
            callback.a(i3, str, new com.tencent.mobileqq.guild.quicksearch.model.c());
            return;
        }
        if (searchRsp != null) {
            iGProGuildSearchUnionResult = searchRsp.getUnionResult();
        } else {
            iGProGuildSearchUnionResult = null;
        }
        if (iGProGuildSearchUnionResult == null) {
            Logger.f235387a.d().w("QQGuildInSearchTag.GuildQuickSearchRepo", 1, "loadData(" + source + ", " + searchParam + ") Success. but unionResult is empty");
            callback.a(0, "", new com.tencent.mobileqq.guild.quicksearch.model.c());
            return;
        }
        e eVar = f231611a;
        Intrinsics.checkNotNullExpressionValue(searchRsp, "searchRsp");
        com.tencent.mobileqq.guild.quicksearch.model.c m3 = eVar.m(searchRsp, searchParam.g());
        callback.a(0, "", m3);
        Logger.f235387a.d().i("QQGuildInSearchTag.GuildQuickSearchRepo", 1, "loadData(" + source + ", " + searchParam + "): " + m3);
    }

    private final com.tencent.mobileqq.guild.quicksearch.model.c m(IGProGuildSearchNewSearchRsp searchRsp, boolean needRemoveAiCard) {
        GProStFeed gProStFeed;
        boolean z16;
        kw1.a aVar = kw1.a.f413327a;
        String b16 = aVar.b();
        com.tencent.mobileqq.guild.quicksearch.model.c cVar = new com.tencent.mobileqq.guild.quicksearch.model.c();
        ArrayList<String> highlightWords = searchRsp.getHighlightWords();
        Intrinsics.checkNotNullExpressionValue(highlightWords, "searchRsp.highlightWords");
        cVar.k(highlightWords);
        if (searchRsp.getAiSearchInfo() != null) {
            String searchKey = searchRsp.getAiSearchInfo().getSearchKey();
            Intrinsics.checkNotNullExpressionValue(searchKey, "searchRsp.aiSearchInfo.searchKey");
            if (searchKey.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !needRemoveAiCard) {
                cVar.f(searchRsp.getAiSearchInfo());
            }
        }
        aVar.d(cVar, b16);
        IGProGuildSearchUnionResult unionResult = searchRsp.getUnionResult();
        if (unionResult == null) {
            return cVar;
        }
        o feedService = ((IGProSession) ch.R0(IGProSession.class)).getFeedService();
        if (feedService == null) {
            QLog.e("QQGuildInSearchTag.GuildQuickSearchRepo", 1, "feedService is null");
            Unit unit = Unit.INSTANCE;
        }
        ArrayList<IGProGuildSearchGuildFeed> guildFeeds = unionResult.getGuildFeeds();
        Intrinsics.checkNotNullExpressionValue(guildFeeds, "result.guildFeeds");
        ArrayList arrayList = new ArrayList();
        for (IGProGuildSearchGuildFeed iGProGuildSearchGuildFeed : guildFeeds) {
            zg1.a aVar2 = null;
            if (feedService != null) {
                gProStFeed = feedService.decodeStFeed(iGProGuildSearchGuildFeed.getOriContents());
            } else {
                gProStFeed = null;
            }
            if (gProStFeed != null) {
                aVar2 = ((IGuildFeedSearchApi) QRoute.api(IGuildFeedSearchApi.class)).convertToFeedItem(gProStFeed, searchRsp.getHighlightWords(), b16);
            }
            if (aVar2 != null) {
                arrayList.add(aVar2);
            }
        }
        cVar.i(arrayList);
        cVar.j(unionResult.getFeedTotal());
        cVar.l(unionResult.getFeedIsEnd());
        cVar.h(unionResult.getFeedCookie());
        ArrayList<IGProGuildSearchFeedGroupInfo> feedGroupList = unionResult.getFeedGroupList();
        for (IGProGuildSearchFeedGroupInfo it : feedGroupList) {
            kw1.a aVar3 = kw1.a.f413327a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            aVar3.d(it, b16);
        }
        Intrinsics.checkNotNullExpressionValue(feedGroupList, "result.feedGroupList.onE\u2026= searchTraceId\n        }");
        cVar.g(feedGroupList);
        return cVar;
    }

    public final void k(@NotNull final com.tencent.mobileqq.guild.quicksearch.model.a searchParam, @NotNull final GuildSearchActionSource source, @NotNull final a<com.tencent.mobileqq.guild.quicksearch.model.c> callback) {
        Intrinsics.checkNotNullParameter(searchParam, "searchParam");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IGPSService) ch.R0(IGPSService.class)).searchGuildContent(searchParam.a(), new dj() { // from class: com.tencent.mobileqq.guild.quicksearch.d
            @Override // wh2.dj
            public final void a(int i3, String str, IGProGuildSearchNewSearchRsp iGProGuildSearchNewSearchRsp) {
                e.l(e.a.this, searchParam, source, i3, str, iGProGuildSearchNewSearchRsp);
            }
        });
    }
}
