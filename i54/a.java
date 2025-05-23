package i54;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.robot.share.layer.RobotLayerShareActionManager;
import com.tencent.robot.share.layer.RobotLayerShareContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\b\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000f"}, d2 = {"Li54/a;", "", "Lcom/tencent/robot/share/layer/f;", "shareContext", "", "d", "", "", "c", "Lcom/tencent/robot/share/layer/RobotLayerShareActionManager$ShareLine;", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: i54.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C10507a {
        public static boolean a(@NotNull a aVar, @NotNull RobotLayerShareContext shareContext) {
            Intrinsics.checkNotNullParameter(shareContext, "shareContext");
            return true;
        }
    }

    @NotNull
    RobotLayerShareActionManager.ShareLine a();

    void b(@NotNull RobotLayerShareContext shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item);

    @NotNull
    List<Integer> c();

    boolean d(@NotNull RobotLayerShareContext shareContext);
}
