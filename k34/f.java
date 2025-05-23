package k34;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lk34/f;", "Lk34/d;", "", "getItemType", "", "getItemId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "g", "()Ljava/lang/String;", "keyWord", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;", IRobotUtilApi.MMKV_SCENE_ID, "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f extends d {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String keyWord;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull String troopUin, @NotNull GroupRobot robot, @NotNull String keyWord) {
        super(troopUin, robot, 0, null, false, 28, null);
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(robot, "robot");
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        this.keyWord = keyWord;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getKeyWord() {
        return this.keyWord;
    }

    @Override // k34.d, k34.a
    @NotNull
    public String getItemId() {
        return getTroopUin() + "-" + getCom.tencent.mobileqq.troop.robot.api.IRobotUtilApi.MMKV_SCENE_ID java.lang.String().baseInfo.robotUin;
    }

    @Override // k34.d, k34.a
    public int getItemType() {
        return 4;
    }
}
