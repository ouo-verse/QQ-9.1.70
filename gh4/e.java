package gh4;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rr1.i;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0006H&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0010H&J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\rH&J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\rH&J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0010H&J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0010H&J\b\u0010\u001b\u001a\u00020\tH&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&J\u0012\u0010 \u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\u0012\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!H&J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H&J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H&J\b\u0010+\u001a\u00020*H&J\b\u0010,\u001a\u00020\u0006H&\u00a8\u0006-"}, d2 = {"Lgh4/e;", "Lfm4/f;", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "O", "Lgh4/d;", "m0", "", "Kc", "Fa", "", "ue", "", "o1", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", ICustomDataEditor.STRING_PARAM_4, Constants.BASE_IN_HOTFIX, "", "t2", "w1", "y4", "uid", "f5", "Rg", "keepInRoom", "ha", "notifyPageClose", "Ig", "P8", "Ltrpc/yes/wuji/WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;", "m7", "Landroid/view/MotionEvent;", "event", "Ke", "Lrr1/i;", "notifyData", ICustomDataEditor.NUMBER_PARAM_7, "", "channelUin", "Zg", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "Gb", "Landroid/view/ViewGroup;", "S1", "ug", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface e extends fm4.f {
    void D4();

    void Fa();

    void Gb(@NotNull YoloRoomOuterClass$YoloRoomInfo roomInfo);

    void Ig(boolean notifyPageClose);

    void Kc();

    boolean Ke(@Nullable MotionEvent event);

    @Override // fm4.f
    @NotNull
    ExpandHallLaunchParam O();

    long P8();

    boolean Rg(@NotNull CommonOuterClass$QQUserId uid);

    @NotNull
    ViewGroup S1();

    void Zg(@NotNull String channelUin);

    boolean f5(@NotNull CommonOuterClass$QQUserId uid);

    void ha(boolean keepInRoom);

    @NotNull
    d m0();

    @Nullable
    WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf m7();

    void n7(@Nullable i notifyData);

    int o1();

    @NotNull
    CommonOuterClass$QQUserId s4();

    boolean t2();

    long ue();

    void ug();

    boolean w1();

    boolean y4();
}
