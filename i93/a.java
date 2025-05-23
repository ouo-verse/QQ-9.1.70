package i93;

import android.content.Intent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.publish.part.PublishJurisdictionPart;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"Li93/a;", "Lj93/b;", "Landroid/content/Intent;", "intent", "", "d", "", "", "e", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends j93.b {
    @Override // j93.b
    public boolean d(@NotNull Intent intent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(intent, "intent");
        String p16 = WinkContext.INSTANCE.d().p(QCircleScheme.AttrQQPublish.HIDE_PUBLISH_PERMISSION);
        if (p16 != null && p16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    @Override // j93.b
    @NotNull
    protected List<String> e(@NotNull Intent intent) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(intent, "intent");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(PublishJurisdictionPart.INSTANCE.a());
        return listOf;
    }
}
