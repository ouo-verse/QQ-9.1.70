package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import l62.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IMsgLayoutHelperFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/view/View;", "root", "Landroid/view/View$OnClickListener;", "listener", "Ll62/b;", OperateCustomButton.OPERATE_CREATE, "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMsgLayoutHelperFactory extends QRouteApi {
    @NotNull
    b create(@NotNull View root, @Nullable View.OnClickListener listener);
}
