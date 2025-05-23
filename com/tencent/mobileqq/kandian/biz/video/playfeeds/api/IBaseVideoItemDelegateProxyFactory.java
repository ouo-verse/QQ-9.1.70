package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import l62.c;
import l62.d;
import l62.f;
import m62.b;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IBaseVideoItemDelegateProxyFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lm62/b;", "videoHolder", "Ll62/f;", "presenter", "Ll62/c;", "adapter", "Ll62/d;", OperateCustomButton.OPERATE_CREATE, "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IBaseVideoItemDelegateProxyFactory extends QRouteApi {
    @NotNull
    d create(@NotNull b videoHolder, @NotNull f presenter, @NotNull c adapter);
}
