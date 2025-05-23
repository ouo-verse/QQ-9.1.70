package d54;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.ax;
import com.tencent.robot.adelie.homepage.create.AdelieEditFragment;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ld54/c;", "Ld54/h;", "Lcom/tencent/mobileqq/utils/ax;", "jumpAction", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements h {
    @Override // d54.h
    public boolean a(@NotNull ax jumpAction) {
        Intrinsics.checkNotNullParameter(jumpAction, "jumpAction");
        Intent intent = new Intent();
        HashMap<String, String> hashMap = jumpAction.f307441f;
        Intrinsics.checkNotNullExpressionValue(hashMap, "jumpAction.attrs");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            intent.putExtra(entry.getKey(), entry.getValue());
        }
        AdelieEditFragment.Companion companion = AdelieEditFragment.INSTANCE;
        Context context = jumpAction.f307437b;
        Intrinsics.checkNotNullExpressionValue(context, "jumpAction.context");
        companion.a(context, intent);
        return true;
    }
}
