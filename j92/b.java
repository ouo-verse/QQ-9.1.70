package j92;

import android.app.Activity;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H&J\u001e\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH&J\u0016\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\u0015"}, d2 = {"Lj92/b;", "", "Lcom/tencent/mobileqq/multishare/action/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "f", "Lcom/tencent/mobileqq/multishare/action/c;", "", "isSelected", "a", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "sendUsers", "", "leaveMsg", "e", "chosenUsers", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "b", "qqmultishare-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static void a(@NotNull b bVar, @NotNull Activity activity, @NotNull com.tencent.mobileqq.multishare.action.c item) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(item, "item");
        }
    }

    void a(@NotNull com.tencent.mobileqq.multishare.action.c item, boolean isSelected);

    void b(@NotNull Activity activity, @NotNull com.tencent.mobileqq.multishare.action.c item);

    void d(@NotNull List<? extends ResultRecord> chosenUsers);

    void e(@NotNull List<? extends ResultRecord> sendUsers, @NotNull String leaveMsg);

    void f(@NotNull com.tencent.mobileqq.multishare.action.b item);
}
