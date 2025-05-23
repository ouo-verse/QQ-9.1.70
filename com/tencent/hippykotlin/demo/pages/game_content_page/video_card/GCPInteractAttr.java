package com.tencent.hippykotlin.demo.pages.game_content_page.video_card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameFeedModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPInteractAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPInteractAttr.class, "likeAnimationFlag", "getLikeAnimationFlag()I", 0)};
    public GameFeedModel gameFeedModel;
    public final ReadWriteProperty likeAnimationFlag$delegate = c.a(0);

    public final GameFeedModel getGameFeedModel() {
        GameFeedModel gameFeedModel = this.gameFeedModel;
        if (gameFeedModel != null) {
            return gameFeedModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameFeedModel");
        return null;
    }

    public final int getLikeAnimationFlag() {
        return ((Number) this.likeAnimationFlag$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final void setLikeAnimationFlag(int i3) {
        this.likeAnimationFlag$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }
}
