package com.tencent.mobileqq.troop.exp.viewmodel;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$FirstShow;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JZ\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/exp/viewmodel/e;", "", "", "isSuccess", "", "itemType", "", "keyWord", "serverPageID", "isEnd", "", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "dataList", "Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;", "firstShow", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "sessionInfo", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface e {
    void a(boolean isSuccess, int itemType, @Nullable String keyWord, int serverPageID, boolean isEnd, @Nullable List<? extends RecommendTroopItem> dataList, @NotNull guildSearchRecommendSvr$FirstShow firstShow, @NotNull ByteStringMicro sessionInfo, boolean isLoadMore);
}
