package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ0\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/app/parser/cd;", "Lcom/tencent/mobileqq/app/parser/av;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", ZPlanPublishSource.FROM_SCHEME, "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "jumpParserResult", "Lcom/tencent/mobileqq/utils/ax;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class cd extends av {
    static IPatchRedirector $redirector_;

    public cd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    @NotNull
    public com.tencent.mobileqq.utils.ax a(@Nullable BaseQQAppInterface app, @Nullable Context context, @Nullable String scheme, @Nullable JumpParserResult jumpParserResult) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 2, this, app, context, scheme, jumpParserResult);
        }
        cc ccVar = new cc(app, context, scheme, jumpParserResult);
        HashMap<String, String> hashMap = null;
        if (jumpParserResult != null) {
            str = jumpParserResult.getServer();
        } else {
            str = null;
        }
        ccVar.f307439d = str;
        if (jumpParserResult != null) {
            str2 = jumpParserResult.getAction();
        } else {
            str2 = null;
        }
        ccVar.f307440e = str2;
        if (jumpParserResult != null) {
            hashMap = jumpParserResult.getParamMap();
        }
        ccVar.f307441f = hashMap;
        return ccVar;
    }
}
