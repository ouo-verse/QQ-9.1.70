package com.tencent.mobileqq.friend.contact.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0007H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/friend/contact/api/IContactExpandBannerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Landroid/view/View;", "context", "Landroid/content/Context;", "hasConfigChanged", "", "initView", "", "parentView", "Landroid/view/ViewGroup;", "isEnable", "qqfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IContactExpandBannerApi extends QRouteApi {
    @Nullable
    View createView(@NotNull Context context);

    boolean hasConfigChanged();

    void initView(@Nullable ViewGroup parentView);

    boolean isEnable();
}
