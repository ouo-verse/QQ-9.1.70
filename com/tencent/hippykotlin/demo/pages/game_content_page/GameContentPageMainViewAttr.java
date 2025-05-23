package com.tencent.hippykotlin.demo.pages.game_content_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.TopBannerItem;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GetFeedRsp;
import com.tencent.kuikly.core.base.k;
import java.util.List;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GameContentPageMainViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewAttr.class, "tabItems", "getTabItems()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewAttr.class, "viewModel", "getViewModel()Lcom/tencent/hippykotlin/demo/pages/game_content_page/GameContentPageMainViewModel;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewAttr.class, "pageDidAppearTimes", "getPageDidAppearTimes()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewAttr.class, "currentTabIndex", "getCurrentTabIndex()I", 0)};
    public List<TopBannerItem> bannerData;
    public GetFeedRsp data;
    public final ReadWriteProperty tabItems$delegate = c.b();
    public final ReadWriteProperty viewModel$delegate = c.a(new GameContentPageMainViewModel(new GameTab(null, null, false, 7, null)));
    public final ReadWriteProperty pageDidAppearTimes$delegate = c.a(0);
    public final ReadWriteProperty currentTabIndex$delegate = c.a(0);

    public final int getPageDidAppearTimes() {
        return ((Number) this.pageDidAppearTimes$delegate.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<GameTab> getTabItems() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tabItems$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final GameContentPageMainViewModel getViewModel() {
        return (GameContentPageMainViewModel) this.viewModel$delegate.getValue(this, $$delegatedProperties[1]);
    }
}
