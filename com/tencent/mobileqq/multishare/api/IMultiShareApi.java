package com.tencent.mobileqq.multishare.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.multishare.action.b;
import com.tencent.mobileqq.multishare.config.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import j92.c;
import j92.d;
import j92.e;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = false)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0004H&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&J\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H&J\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/multishare/api/IMultiShareApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/multishare/config/a;", DownloadInfo.spKey_Config, "", "createPanel", "Landroid/content/Context;", "context", "showPanel", "", "isShowing", "dismissPanel", "Landroid/content/Intent;", "forwardIntent", "setForwardIntent", "Lj92/c;", "previewCreator", "setPreviewInterface", "Lj92/d;", "titleCreator", "setCustomTitleInterface", "", "index", "", "Lcom/tencent/mobileqq/multishare/action/b;", "actions", "updateActionSheet", "Lj92/e;", "sorter", "Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "recentContactListener", "getRecentUserList", "qqmultishare-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMultiShareApi extends QRouteApi {
    void createPanel(@NotNull a config);

    void dismissPanel();

    void getRecentUserList(@Nullable e sorter, @NotNull RecentContactListener recentContactListener);

    boolean isShowing();

    void setCustomTitleInterface(@NotNull d titleCreator);

    void setForwardIntent(@NotNull Intent forwardIntent);

    void setPreviewInterface(@NotNull c previewCreator);

    void showPanel(@NotNull Context context);

    void updateActionSheet(int index, @NotNull List<? extends b> actions);
}
