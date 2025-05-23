package k22;

import android.util.Size;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lk22/e;", "", "Landroid/util/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "", "c", "", MiniChatConstants.MINI_APP_LANDSCAPE, "a", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface e {
    void a(boolean isLandscape);

    void c(@NotNull Size videoSize);
}
