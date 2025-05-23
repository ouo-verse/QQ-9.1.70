package com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IBaseVideoItemDelegateProxyFactory;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l62.c;
import l62.d;
import l62.f;
import m62.b;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/impl/BaseVideoItemDelegateProxyFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IBaseVideoItemDelegateProxyFactory;", "Lm62/b;", "videoHolder", "Ll62/f;", "presenter", "Ll62/c;", "adapter", "Ll62/d;", OperateCustomButton.OPERATE_CREATE, "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class BaseVideoItemDelegateProxyFactoryImpl implements IBaseVideoItemDelegateProxyFactory {

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/kandian/biz/video/playfeeds/api/impl/BaseVideoItemDelegateProxyFactoryImpl$a", "Ll62/d;", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements d {
        a() {
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IBaseVideoItemDelegateProxyFactory
    public d create(b videoHolder, f presenter, c adapter) {
        Intrinsics.checkNotNullParameter(videoHolder, "videoHolder");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        return new a();
    }
}
