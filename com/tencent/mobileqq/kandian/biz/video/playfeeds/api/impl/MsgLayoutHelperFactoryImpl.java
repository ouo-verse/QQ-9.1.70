package com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.a;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelperFactory;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l62.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/impl/MsgLayoutHelperFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IMsgLayoutHelperFactory;", "Landroid/view/View;", "root", "Landroid/view/View$OnClickListener;", "listener", "Ll62/b;", OperateCustomButton.OPERATE_CREATE, "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MsgLayoutHelperFactoryImpl implements IMsgLayoutHelperFactory {
    @Override // com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelperFactory
    public b create(View root, View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(root, "root");
        return new a(root, listener);
    }
}
