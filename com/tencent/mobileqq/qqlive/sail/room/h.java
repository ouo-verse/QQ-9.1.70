package com.tencent.mobileqq.qqlive.sail.room;

import android.util.Size;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0014\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\tH&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u001a\u001a\u00020\u0004H&J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001fH&J\u0012\u0010!\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001fH&J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\"H&J\u0012\u0010$\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\"H&J\u0012\u0010&\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010%H&J\u0012\u0010'\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010%H&J\u0012\u0010)\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010(H&J\u0012\u0010*\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010(H&J\u0012\u0010,\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010+H&J\u0012\u0010-\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010+H&J\u0012\u0010/\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010.H&J\u0012\u00100\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010.H&\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/h;", "", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "newPlayer", "", DomainData.DOMAIN_NAME, "", "url", "prepare", "", "isPlaying", "switchStream", "k", "pauseVideo", "stopVideo", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;", "axis", "setXYAxis", "mute", "y", "Landroid/util/Size;", "getVideoSize", "Landroid/view/View;", "getVideoView", "Lcom/tencent/mobileqq/qqlive/sail/model/player/a;", "getPlayerQuality", "a", "Lmi2/h;", "listener", "registerVideoSizeChangedListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmi2/c;", HippyTKDListViewAdapter.X, "r", "Lmi2/d;", "registerFirstFrameRenderedListener", "u", "Lmi2/f;", "registerSwitchDefinitionListener", ReportConstant.COSTREPORT_PREFIX, "Lmi2/a;", "registerBufferListener", "w", "Lmi2/g;", "registerVideoPreparedListener", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lmi2/e;", "registerSeiInfoListener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface h {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class a {
        public static /* synthetic */ void a(h hVar, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = null;
                }
                hVar.k(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playVideo");
        }
    }

    void A(@Nullable mi2.e listener);

    void a();

    @Nullable
    com.tencent.mobileqq.qqlive.sail.model.player.a getPlayerQuality();

    @Nullable
    Size getVideoSize();

    @Nullable
    View getVideoView();

    boolean isPlaying();

    void k(@Nullable String url);

    void m(@Nullable mi2.h listener);

    void n(@Nullable IQQLivePlayer newPlayer);

    void pauseVideo();

    void prepare(@NotNull String url);

    void r(@Nullable mi2.c listener);

    void registerBufferListener(@Nullable mi2.a listener);

    void registerFirstFrameRenderedListener(@Nullable mi2.d listener);

    void registerSeiInfoListener(@Nullable mi2.e listener);

    void registerSwitchDefinitionListener(@Nullable mi2.f listener);

    void registerVideoPreparedListener(@Nullable mi2.g listener);

    void registerVideoSizeChangedListener(@Nullable mi2.h listener);

    void s(@Nullable mi2.f listener);

    void setXYAxis(@NotNull IQQLivePlayer.XYAxis axis);

    void stopVideo();

    void switchStream(@NotNull String url);

    void u(@Nullable mi2.d listener);

    void w(@Nullable mi2.a listener);

    void x(@Nullable mi2.c listener);

    void y(boolean mute);

    void z(@Nullable mi2.g listener);
}
