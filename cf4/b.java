package cf4;

import af4.OperationItem;
import android.content.Context;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView;
import com.tencent.timi.game.ad.ui.view.BatteryItemView;
import com.tencent.timi.game.ad.ui.view.TianShuItemView;
import com.tencent.timi.game.ad.ui.view.TimiRedPocketItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcf4/b;", "", "Landroid/content/Context;", "context", "Laf4/d;", "data", "", MiniChatConstants.MINI_APP_LANDSCAPE, "Lcom/tencent/timi/game/ad/ui/view/BaseOperationSingleItemView;", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f30784a = new b();

    b() {
    }

    @NotNull
    public final BaseOperationSingleItemView a(@NotNull Context context, @NotNull OperationItem data, boolean isLandscape) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        int operationType = data.getOperationType();
        if (operationType != 1) {
            if (operationType != 2) {
                if (operationType != 3) {
                    TianShuItemView tianShuItemView = new TianShuItemView(context, null, 0, isLandscape, 6, null);
                    tianShuItemView.k(data);
                    return tianShuItemView;
                }
                BatteryItemView batteryItemView = new BatteryItemView(context, null, 0, isLandscape, 6, null);
                batteryItemView.k(data);
                return batteryItemView;
            }
            TimiRedPocketItemView timiRedPocketItemView = new TimiRedPocketItemView(context, null, 0, isLandscape, 6, null);
            timiRedPocketItemView.k(data);
            return timiRedPocketItemView;
        }
        TianShuItemView tianShuItemView2 = new TianShuItemView(context, null, 0, isLandscape, 6, null);
        tianShuItemView2.k(data);
        return tianShuItemView2;
    }
}
