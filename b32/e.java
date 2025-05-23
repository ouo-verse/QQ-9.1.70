package b32;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface e {
    void onRoomClose(@NonNull QQLiveRoomStatusInfo qQLiveRoomStatusInfo);

    void onRoomOpen(@NonNull QQLiveRoomStatusInfo qQLiveRoomStatusInfo);

    void onRoomPause(@NonNull QQLiveRoomStatusInfo qQLiveRoomStatusInfo);

    void onRoomResume(@NonNull QQLiveRoomStatusInfo qQLiveRoomStatusInfo);
}
