package com.tencent.mobileqq.troop.qrcode;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/aj;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class aj extends ax {
    public aj(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        QLog.i("TroopQRCodeShareJumpAction", 1, "[doAction] attrs = " + this.f307441f);
        String str = this.f307441f.get("troop_uin");
        if (str == null && (str = this.f307441f.get("group_id")) == null) {
            str = "";
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return false;
        }
        new TroopQRCodeShareHelper(topActivity).s(str);
        return true;
    }
}
