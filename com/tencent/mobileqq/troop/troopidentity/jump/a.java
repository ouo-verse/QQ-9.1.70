package com.tencent.mobileqq.troop.troopidentity.jump;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/jump/a;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends ax {
    static IPatchRedirector $redirector_;

    public a(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        QLog.i("[TroopIdentityWearJumpAction]", 1, "[doAction] context = " + this.f307437b + " attr = " + this.f307441f);
        if (this.f307437b == null || (str = this.f307441f.get("troop_uin")) == null) {
            return false;
        }
        String str2 = this.f307441f.get("member_uin");
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        QRouteApi api = QRoute.api(ITroopIdentityApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopIdentityApi::class.java)");
        Context context = this.f307437b;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ITroopIdentityApi.a.a((ITroopIdentityApi) api, context, str, str3, null, 8, null);
        return super.b();
    }
}
