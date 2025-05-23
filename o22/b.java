package o22;

import android.content.Intent;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.icgame.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\rH&J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u001a\u001a\u00020\u0019H&J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0004H&J\b\u0010\u001d\u001a\u00020\u0004H&J\b\u0010\u001e\u001a\u00020\u0004H&\u00a8\u0006\u001f"}, d2 = {"Lo22/b;", "", "Landroid/content/Intent;", "o", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/icgame/data/room/LiveInfo;", "liveInfo", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/icgame/data/anchor/room/QQLiveAnchorRoomInfo;", "getAnchorRoomInfo", "", "roomId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getRoomId", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extra", "f", "k", "", WebAccelerateHelper.KEY_PRELOAD_URL, "r", "a", "", "getRoomType", "show", "e", "j", "c", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface b {
    @Nullable
    String a();

    boolean c();

    void e(boolean show);

    void f(@Nullable LiveRoomExtraInfo extra);

    @Nullable
    QQLiveAnchorRoomInfo getAnchorRoomInfo();

    long getRoomId();

    int getRoomType();

    boolean j();

    @Nullable
    LiveRoomExtraInfo k();

    void m(long roomId);

    void n(@NotNull LiveInfo liveInfo);

    @Nullable
    Intent o();

    @Nullable
    LiveInfo q();

    void r(@Nullable String preloadUrl);

    boolean s();
}
