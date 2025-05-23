package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import f62.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J0\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoR5BuilderFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "md5", IPublicAccountBrowser.KEY_PUB_UIN, "vid", "aid", "Lf62/c;", OperateCustomButton.OPERATE_CREATE, "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVideoR5BuilderFactory extends QRouteApi {
    @NotNull
    c create(@Nullable String md5, @Nullable String puin, @Nullable String vid, @Nullable String aid);
}
