package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/utils/ab;", "", "Landroid/content/Context;", "context", "", "troopUin", "", "b", "c", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class ab {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ab f301992a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62042);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301992a = new ab();
        }
    }

    ab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void b(@Nullable Context context, @Nullable String troopUin) {
        QLog.i("TroopBlockUtils", 1, "[goToAppealForTempBlock] troopUin:" + troopUin + ", context:" + context);
        if (troopUin != null && context != null) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, "mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pkgOther%2Fpages%2Fscene_dismissed%2Findex&_vt=3&via=tencent_csd&_sig=2171357820&_nq=type%3Dpermanent_block%26function_type%3D1%26group_code%3D" + troopUin, 2010, null);
        }
    }

    @JvmStatic
    public static final void c(@Nullable final Context context) {
        com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.aa
            @Override // java.lang.Runnable
            public final void run() {
                ab.d(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context) {
        QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.bnu), 0).show();
    }
}
