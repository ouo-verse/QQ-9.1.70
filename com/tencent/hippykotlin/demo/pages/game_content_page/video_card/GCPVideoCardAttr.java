package com.tencent.hippykotlin.demo.pages.game_content_page.video_card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayControl;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameFeedModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPVideoCardAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPVideoCardAttr.class, "playControl", "getPlayControl()Lcom/tencent/hippykotlin/demo/pages/base/QVideoPlayControl;", 0)};
    public int feedIndex;
    public GameFeedModel gameFeedModel;
    public GameTab gameTab;
    public final ReadWriteProperty playControl$delegate = c.a(QVideoPlayControl.NONE);

    public final GameFeedModel getGameFeedModel() {
        GameFeedModel gameFeedModel = this.gameFeedModel;
        if (gameFeedModel != null) {
            return gameFeedModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameFeedModel");
        return null;
    }
}
