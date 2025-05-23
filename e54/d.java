package e54;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.utils.ax;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ0\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Le54/d;", "Lcom/tencent/mobileqq/app/parser/av;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", ZPlanPublishSource.FROM_SCHEME, "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "jumpParserResult", "Lcom/tencent/mobileqq/utils/ax;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends av {
    @Override // com.tencent.mobileqq.app.parser.av
    @NotNull
    public ax a(@Nullable BaseQQAppInterface app, @Nullable Context context, @Nullable String scheme, @Nullable JumpParserResult jumpParserResult) {
        String str;
        String str2;
        b bVar = new b(app, context, jumpParserResult);
        HashMap<String, String> hashMap = null;
        if (jumpParserResult != null) {
            str = jumpParserResult.getServer();
        } else {
            str = null;
        }
        bVar.f307439d = str;
        if (jumpParserResult != null) {
            str2 = jumpParserResult.getAction();
        } else {
            str2 = null;
        }
        bVar.f307440e = str2;
        if (jumpParserResult != null) {
            hashMap = jumpParserResult.getParamMap();
        }
        bVar.f307441f = hashMap;
        return bVar;
    }
}
