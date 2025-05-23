package com.tencent.hippykotlin.demo.pages.game_content_page.repo;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayControl;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeed;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameFeedModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameFeedModel.class, "playControl", "getPlayControl()Lcom/tencent/hippykotlin/demo/pages/base/QVideoPlayControl;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameFeedModel.class, "feedCardHeight", "getFeedCardHeight()F", 0)};
    public GameFeed gameFeed;
    public boolean hasDCReported;
    public InteractViewModel interactViewModel;
    public float videoAppearPercentage;
    public final ReadWriteProperty playControl$delegate = c.a(QVideoPlayControl.NONE);
    public final ReadWriteProperty feedCardHeight$delegate = c.a(Float.valueOf(0.0f));

    public GameFeedModel(GameFeed gameFeed) {
        this.gameFeed = gameFeed;
        this.interactViewModel = new InteractViewModel(gameFeed);
    }

    public final QVideoPlayControl getPlayControl() {
        return (QVideoPlayControl) this.playControl$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setPlayControl(QVideoPlayControl qVideoPlayControl) {
        this.playControl$delegate.setValue(this, $$delegatedProperties[0], qVideoPlayControl);
    }
}
