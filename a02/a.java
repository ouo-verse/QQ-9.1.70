package a02;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&\u00a8\u0006\r"}, d2 = {"La02/a;", "", "Lcom/tencent/common/app/AppInterface;", "getAppInterface", "Landroidx/lifecycle/LifecycleOwner;", "getViewLifecycleOwner", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getHostActivity", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "memberList", "", "U3", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface a {
    void U3(@NotNull List<? extends IGProUserInfo> memberList);

    @NotNull
    AppInterface getAppInterface();

    @NotNull
    QBaseActivity getHostActivity();

    @NotNull
    LifecycleOwner getViewLifecycleOwner();
}
