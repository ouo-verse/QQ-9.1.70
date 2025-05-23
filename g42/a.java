package g42;

import android.os.Bundle;
import com.tencent.mobileqq.icgame.base.room.multipage.api.SwitchPageInfo;
import com.tencent.mobileqq.icgame.room.frame.page.ICGamePageFragment;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lg42/a;", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/b;", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;", "switchInfo", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/a;", "a", "", "Ljava/lang/String;", "TAG", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements com.tencent.mobileqq.icgame.base.room.multipage.api.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "ICGameLivePageCreator";

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.b
    @NotNull
    public com.tencent.mobileqq.icgame.base.room.multipage.api.a a(@NotNull SwitchPageInfo switchInfo) {
        Integer num;
        Intrinsics.checkNotNullParameter(switchInfo, "switchInfo");
        Bundle extraData = switchInfo.getExtraData();
        if (extraData != null) {
            num = Integer.valueOf(extraData.getInt("ext_enter_room_room_type", 0));
        } else {
            num = null;
        }
        QLog.i(this.TAG, 1, "createPage roomType = " + num);
        if (num != null && num.intValue() == 0) {
            return new ICGamePageFragment();
        }
        return new ICGamePageFragment();
    }
}
