package e54;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.utils.ax;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Le54/b;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "jumpParserResult", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "cc", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/app/parser/JumpParserResult;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends ax {

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private final JumpParserResult jumpParserResult;

    public b(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context, @Nullable JumpParserResult jumpParserResult) {
        super(baseQQAppInterface, context);
        this.jumpParserResult = jumpParserResult;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        String str;
        c cVar = c.f395725a;
        JumpParserResult jumpParserResult = this.jumpParserResult;
        if (jumpParserResult != null) {
            str = jumpParserResult.getAction();
        } else {
            str = null;
        }
        a a16 = cVar.a(str);
        if (a16 != null) {
            return a16.a(this);
        }
        return false;
    }
}
