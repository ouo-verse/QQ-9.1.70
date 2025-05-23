package com.tencent.mobileqq.qqlive.player;

import android.util.Size;
import android.view.View;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import mi2.c;
import mi2.d;
import mi2.e;
import mi2.f;
import mi2.g;
import mi2.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u00011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\rH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001fH&J\u0012\u0010!\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001fH&J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\"H&J\u0012\u0010$\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\"H&J\u0012\u0010&\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010%H&J\u0012\u0010'\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010%H&J\u0012\u0010)\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010(H&J\u0012\u0010*\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010(H&J\u0012\u0010,\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010+H&J\u0012\u0010-\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010+H&J\u0012\u0010/\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010.H&J\u0012\u00100\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010.H&\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "", "prepare", "startPlay", "pause", "replay", "stop", "release", "url", "switchStream", "", "isOutputMute", "mute", "setOutputMute", "isPlaying", "Landroid/util/Size;", "getVideoSize", "Landroid/view/View;", "getVideoView", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;", "axis", "setXYAxis", "Lcom/tencent/mobileqq/qqlive/sail/model/player/a;", "getPlayerQuality", "Lmi2/g;", "listener", "registerVideoPreparedListener", "unRegisterVideoPreparedListener", "Lmi2/d;", "registerFirstFrameRenderedListener", "unRegisterFirstFrameRenderedListener", "Lmi2/h;", "registerVideoSizeChangedListener", "unRegisterVideoSizeChangedListener", "Lmi2/c;", "registerErrorListener", "unRegisterErrorListener", "Lmi2/a;", "registerBufferListener", "unRegisterBufferListener", "Lmi2/f;", "registerSwitchDefinitionListener", "unRegisterSwitchDefinitionListener", "Lmi2/e;", "registerSeiInfoListener", "unRegisterSeiInfoListener", "XYAxis", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface IQQLivePlayer {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "ORIGINAL_RATIO", "BOTH_FULLSCREEN", "ORIGINAL_FULLSCREEN", "ORIGINAL_RATIO_SQUARE", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class XYAxis {
        private static final /* synthetic */ XYAxis[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final XYAxis BOTH_FULLSCREEN;
        public static final XYAxis ORIGINAL_FULLSCREEN;
        public static final XYAxis ORIGINAL_RATIO;
        public static final XYAxis ORIGINAL_RATIO_SQUARE;
        private final int value;

        private static final /* synthetic */ XYAxis[] $values() {
            return new XYAxis[]{ORIGINAL_RATIO, BOTH_FULLSCREEN, ORIGINAL_FULLSCREEN, ORIGINAL_RATIO_SQUARE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30691);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            ORIGINAL_RATIO = new XYAxis("ORIGINAL_RATIO", 0, 0);
            BOTH_FULLSCREEN = new XYAxis("BOTH_FULLSCREEN", 1, 1);
            ORIGINAL_FULLSCREEN = new XYAxis("ORIGINAL_FULLSCREEN", 2, 2);
            ORIGINAL_RATIO_SQUARE = new XYAxis("ORIGINAL_RATIO_SQUARE", 3, 3);
            $VALUES = $values();
        }

        XYAxis(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static XYAxis valueOf(String str) {
            return (XYAxis) Enum.valueOf(XYAxis.class, str);
        }

        public static XYAxis[] values() {
            return (XYAxis[]) $VALUES.clone();
        }

        public final int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    @Nullable
    com.tencent.mobileqq.qqlive.sail.model.player.a getPlayerQuality();

    @Nullable
    Size getVideoSize();

    @Nullable
    View getVideoView();

    boolean isOutputMute();

    boolean isPlaying();

    void pause();

    void prepare(@NotNull String videoUrl);

    void registerBufferListener(@Nullable mi2.a listener);

    void registerErrorListener(@Nullable c listener);

    void registerFirstFrameRenderedListener(@Nullable d listener);

    void registerSeiInfoListener(@Nullable e listener);

    void registerSwitchDefinitionListener(@Nullable f listener);

    void registerVideoPreparedListener(@Nullable g listener);

    void registerVideoSizeChangedListener(@Nullable h listener);

    void release();

    void replay();

    void setOutputMute(boolean mute);

    void setXYAxis(@NotNull XYAxis axis);

    void startPlay(@Nullable String videoUrl);

    void stop();

    void switchStream(@NotNull String url);

    void unRegisterBufferListener(@Nullable mi2.a listener);

    void unRegisterErrorListener(@Nullable c listener);

    void unRegisterFirstFrameRenderedListener(@Nullable d listener);

    void unRegisterSeiInfoListener(@Nullable e listener);

    void unRegisterSwitchDefinitionListener(@Nullable f listener);

    void unRegisterVideoPreparedListener(@Nullable g listener);

    void unRegisterVideoSizeChangedListener(@Nullable h listener);
}
