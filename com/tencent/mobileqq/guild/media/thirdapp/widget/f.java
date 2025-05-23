package com.tencent.mobileqq.guild.media.thirdapp.widget;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0002H&J\b\u0010\u0016\u001a\u00020\u0002H&J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H&J\b\u0010\u0019\u001a\u00020\u0002H&J\b\u0010\u001a\u001a\u00020\u0002H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/widget/f;", "", "", "c", "", "d", "width", "height", "setThirdAppSize", "", "show", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyAppInfo;", "appInfo", "setThirdAppInfo", "Lcom/tencent/mobileqq/guild/media/thirdapp/e;", "appPreloadInfo", "setThirdAppPreloadInfo", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/g;", "listener", "setThirdAppClickListener", "a", "setPortraitFullUI", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SCREEN_MODE, "setResetUI", "setLandFullUI", "setHorizontalMarginGone", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface f {
    void a();

    void b(boolean show);

    void c();

    int d();

    void setHorizontalMarginGone();

    void setLandFullUI();

    void setPortraitFullUI();

    void setResetUI(int screenMode);

    void setThirdAppClickListener(@NotNull g listener);

    void setThirdAppInfo(@NotNull IGProLobbyAppInfo appInfo);

    void setThirdAppPreloadInfo(@NotNull com.tencent.mobileqq.guild.media.thirdapp.e appPreloadInfo);

    void setThirdAppSize(int width, int height);
}
