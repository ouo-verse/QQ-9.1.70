package com.tencent.mobileqq.aio.notification.render;

import android.content.Context;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/render/d;", "", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroidx/viewbinding/ViewBinding;", "b", "Landroid/content/Context;", "context", "", "c", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "uiModel", "viewBinding", "", "isExpandDialogState", "isMultiFoldMode", "", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface d {
    void a(@NotNull IAIONotificationUIModel uiModel, @NotNull ViewBinding viewBinding, boolean isExpandDialogState, boolean isMultiFoldMode);

    @NotNull
    ViewBinding b(@NotNull ViewGroup container);

    float c(@NotNull Context context);
}
