package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/home/ITabFrameCreator;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "buildFrameByKey", "Lcom/tencent/mobileqq/app/Frame;", "key", "", "fragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "QQActivity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes10.dex */
public interface ITabFrameCreator extends QRouteApi {
    @Nullable
    Frame buildFrameByKey(@NotNull String key, @NotNull FrameFragment fragment);
}
