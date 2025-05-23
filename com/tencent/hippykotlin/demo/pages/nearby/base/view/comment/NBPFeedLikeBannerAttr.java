package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPFeedLikeBannerAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedLikeBannerAttr.class, MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "getLikeCount()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedLikeBannerAttr.class, "likeUserNicks", "getLikeUserNicks()Ljava/util/List;", 0)};
    public final ReadWriteProperty likeCount$delegate = c.a(0);
    public final ReadWriteProperty likeUserNicks$delegate;

    public NBPFeedLikeBannerAttr() {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.likeUserNicks$delegate = c.a(emptyList);
    }
}
