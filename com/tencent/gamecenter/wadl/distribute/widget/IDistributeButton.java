package com.tencent.gamecenter.wadl.distribute.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.distribute.data.ButtonDataBuilder;
import com.tencent.gamecenter.wadl.distribute.data.ButtonStatus;
import com.tencent.gamecenter.wadl.distribute.data.ButtonUiBuilder;
import com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J\b\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH'J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020#H&J\b\u0010$\u001a\u00020\u0003H&J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H&\u00a8\u0006&"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/widget/IDistributeButton;", "", "addEventListener", "", "listener", "Lcom/tencent/gamecenter/wadl/distribute/listener/IButtonEventListener;", "getBgView", "Landroid/view/ViewGroup;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonStatus;", "getTipsView", "Landroid/widget/TextView;", "isKuiklyViewDetach", "", "isKuiklyWidget", "onKuiklyDownloadTaskStatusChange", "appId", "", "progress", "", "taskStatus", "", "onKuiklyFollowOrSubscribeStatusChange", "followStatus", "subscribeStatus", "onKuiklyWidgetClick", "view", "Landroid/view/View;", "removeEventListener", "removeEventListeners", "removeKuiklyView", "setDataBuilder", "builder", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonDataBuilder;", "setUiBuilder", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder;", "update", "updateWithInitStatus", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface IDistributeButton {
    void addEventListener(@NotNull IButtonEventListener listener);

    @Deprecated(message = "\u5df2\u5e9f\u5f03\uff0cKuikly\u7248\u672c\u7ec4\u4ef6\u8fd4\u56de\u7a7a\uff0c\u8bf7\u52ff\u4f7f\u7528")
    @Nullable
    ViewGroup getBgView();

    @NotNull
    ButtonStatus getStatus();

    @Deprecated(message = "\u5df2\u5e9f\u5f03\uff0cKuikly\u7248\u672c\u7ec4\u4ef6\u8fd4\u56de\u7a7a\uff0c\u8bf7\u52ff\u4f7f\u7528")
    @Nullable
    TextView getTipsView();

    boolean isKuiklyViewDetach();

    boolean isKuiklyWidget();

    void onKuiklyDownloadTaskStatusChange(@NotNull String appId, float progress, int taskStatus);

    void onKuiklyFollowOrSubscribeStatusChange(@NotNull String appId, int followStatus, int subscribeStatus);

    void onKuiklyWidgetClick(@NotNull View view);

    void removeEventListener(@NotNull IButtonEventListener listener);

    void removeEventListeners();

    void removeKuiklyView();

    void setDataBuilder(@NotNull ButtonDataBuilder builder);

    void setUiBuilder(@NotNull ButtonUiBuilder builder);

    void update();

    void updateWithInitStatus(int followStatus, int subscribeStatus);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class a {
        public static void a(@NotNull IDistributeButton iDistributeButton, @NotNull String appId, float f16, int i3) {
            Intrinsics.checkNotNullParameter(appId, "appId");
        }

        public static void b(@NotNull IDistributeButton iDistributeButton, @NotNull String appId, int i3, int i16) {
            Intrinsics.checkNotNullParameter(appId, "appId");
        }

        public static void c(@NotNull IDistributeButton iDistributeButton, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public static void d(@NotNull IDistributeButton iDistributeButton) {
        }
    }
}
