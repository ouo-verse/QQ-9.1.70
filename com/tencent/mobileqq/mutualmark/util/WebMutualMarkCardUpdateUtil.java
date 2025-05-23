package com.tencent.mobileqq.mutualmark.util;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.widget.detailcard.MutualMarkDetailListHelper;
import com.tencent.mobileqq.mutualmark.widget.util.MutualMarkDialogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class WebMutualMarkCardUpdateUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    MutualMarkDetailListHelper f252260a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final WebMutualMarkCardUpdateUtil f252261a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33280);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f252261a = new WebMutualMarkCardUpdateUtil();
            }
        }
    }

    WebMutualMarkCardUpdateUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f252260a = null;
        }
    }

    public static WebMutualMarkCardUpdateUtil b() {
        return a.f252261a;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f252260a = null;
        }
    }

    public void c(MutualMarkDetailListHelper mutualMarkDetailListHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mutualMarkDetailListHelper);
        } else {
            this.f252260a = mutualMarkDetailListHelper;
        }
    }

    public void d(long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16));
            return;
        }
        if (this.f252260a == null) {
            return;
        }
        ArrayList<MutualMarkModel> arrayList = new ArrayList<>(this.f252260a.m());
        if (arrayList.size() == 1 && arrayList.get(0).D == j3) {
            MutualMarkModel mutualMarkModel = arrayList.get(0);
            String str = "";
            for (MutualMarkModel.Button button : mutualMarkModel.Z) {
                if (!button.f252166i && !TextUtils.isEmpty(button.f252165h)) {
                    str = button.f252165h;
                    button.f252166i = true;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (MutualMarkModel.Button button2 : mutualMarkModel.Z) {
                if (str.equals(button2.f252162d)) {
                    button2.f252166i = false;
                }
            }
            if (z16) {
                mutualMarkModel.M = !mutualMarkModel.M;
            } else {
                mutualMarkModel.M = false;
                mutualMarkModel.N = true;
                mutualMarkModel.H = 0L;
                mutualMarkModel.f252159h = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getIconUrlFormat(mutualMarkModel);
            }
            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isValidUin(String.valueOf(j16), "WebMutualMarkCardUpdateUtil")) {
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isNewIcon(true, String.valueOf(j16), mutualMarkModel);
            }
            this.f252260a.r(arrayList);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                MutualMarkDialogUtil.c(true);
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.util.WebMutualMarkCardUpdateUtil.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebMutualMarkCardUpdateUtil.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            MutualMarkDialogUtil.c(true);
                        }
                    }
                });
            }
        }
    }
}
