package ot2;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ2\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lot2/b;", "Lcom/tencent/mobileqq/app/parser/av;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", "jump", "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "jumpParserResult", "Lcom/tencent/mobileqq/utils/ax;", "a", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends av {
    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface app, Context context, String jump, JumpParserResult jumpParserResult) {
        if (app != null && context != null) {
            a aVar = new a(app, context);
            if (jumpParserResult != null) {
                aVar.f307439d = jumpParserResult.getServer();
                aVar.f307440e = jumpParserResult.getAction();
                aVar.s(jumpParserResult.getParamMap());
            }
            return aVar;
        }
        QLog.e("TroopNotificationJumpParser", 1, "[parse] failed. app = " + app + ", context = " + context);
        return null;
    }
}
