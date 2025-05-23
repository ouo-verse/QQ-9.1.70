package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0004H&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H&J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IGuildTroopApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "fetchGuildTroopTitleData", "", "", "", "getAvatarDrawable", "Landroid/graphics/drawable/Drawable;", "url", "width", "", "height", "getFeedFragment", "Landroidx/fragment/app/Fragment;", "troopUin", "getLoadingView", "Landroid/view/View;", "context", "Landroid/content/Context;", "isGuildTroop", "", "isNeedHideTroopGuildEntrance", "startLoadingAnim", "", "view", "stopLoadingAnim", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IGuildTroopApi extends QRouteApi {
    @NotNull
    Map<String, Object> fetchGuildTroopTitleData();

    @Nullable
    Drawable getAvatarDrawable(@NotNull String url, int width, int height);

    @Nullable
    Fragment getFeedFragment(@NotNull String troopUin);

    @Nullable
    View getLoadingView(@NotNull Context context);

    boolean isGuildTroop(@NotNull String troopUin);

    boolean isNeedHideTroopGuildEntrance();

    void startLoadingAnim(@NotNull View view);

    void stopLoadingAnim(@NotNull View view);
}
