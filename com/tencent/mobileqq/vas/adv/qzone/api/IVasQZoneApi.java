package com.tencent.mobileqq.vas.adv.qzone.api;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaParam;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController;
import java.util.HashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import oz2.a;
import qz2.VasAdMetaReportParamNew;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000fH&J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH&J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\bH&J\u0018\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0015j\b\u0012\u0004\u0012\u00020\b`\u0016H&J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001cH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/adv/qzone/api/IVasQZoneApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaParam;", "param", "Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "callback", "", "requestAdvAsync", "", "posId", "Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;", "Loz2/a;", "requestFeedAdvAsync", "Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaReportParam;", "reportAdvAsync", "Lqz2/a;", "reportAdvAsyncNew", "id", "addReportId", "", "containsReportId", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getReportIdSet", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAdVideoViewController;", "createAdVideoViewController", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAlbumRecommendAdvController;", "createAlbumAdvViewController", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasQZoneApi extends QRouteApi {
    void addReportId(@NotNull String id5);

    boolean containsReportId(@NotNull String id5);

    @NotNull
    IAdVideoViewController createAdVideoViewController(@NotNull Context context);

    @NotNull
    IAlbumRecommendAdvController createAlbumAdvViewController(@NotNull Context context, @NotNull ViewGroup viewGroup);

    @NotNull
    HashSet<String> getReportIdSet();

    void reportAdvAsync(@NotNull VasAdMetaReportParam param);

    void reportAdvAsyncNew(@NotNull VasAdMetaReportParamNew param);

    void requestAdvAsync(@NotNull VasAdMetaParam param, @NotNull VasAdMetaCallback callback);

    void requestAdvAsync(@NotNull String posId, @NotNull VasAdMetaCallback callback);

    void requestFeedAdvAsync(@NotNull VasNewAdParams param, @NotNull a callback);
}
