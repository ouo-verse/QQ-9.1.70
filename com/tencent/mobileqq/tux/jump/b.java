package com.tencent.mobileqq.tux.jump;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ2\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/tux/jump/b;", "Lcom/tencent/mobileqq/app/parser/av;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", "jump", "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "jumpParserResult", "Lcom/tencent/mobileqq/utils/ax;", "a", "<init>", "()V", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends av {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    @Nullable
    public ax a(@Nullable BaseQQAppInterface app, @Nullable Context context, @Nullable String jump, @Nullable JumpParserResult jumpParserResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ax) iPatchRedirector.redirect((short) 2, this, app, context, jump, jumpParserResult);
        }
        if (app != null && jump != null && jumpParserResult != null) {
            a aVar = new a(app, context);
            aVar.f307438c = jump;
            aVar.f307439d = jumpParserResult.getServer();
            aVar.f307440e = jumpParserResult.getAction();
            aVar.s(jumpParserResult.getParamMap());
            if (QLog.isColorLevel()) {
                QLog.d("TuxSdkHelper", 2, "parse, jumpParserResult=" + jumpParserResult);
            }
            return aVar;
        }
        QLog.e("TuxSdkHelper", 1, "parse, invalid arguments, app=" + app + ", context=" + context + " jump=" + jump + " jumpParserResult=" + jumpParserResult);
        return null;
    }
}
