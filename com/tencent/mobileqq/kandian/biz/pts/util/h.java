package com.tencent.mobileqq.kandian.biz.pts.util;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h implements CustomMethodsRegister.CustomMethodInterface {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, CustomMethodsRegister.CustomMethodInterface> f239413a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b implements CustomMethodsRegister.CustomMethodInterface {
        b() {
        }

        private static boolean a(View view, String str, boolean z16) {
            return false;
        }

        private static boolean b(String str, boolean z16) {
            return false;
        }

        private static boolean c(View view, String str, boolean z16) {
            return false;
        }

        private static boolean d(String str, boolean z16) {
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object invoke(String str, Object... objArr) {
            View view;
            boolean c16;
            if (objArr != null && objArr.length >= 1) {
                Object obj = objArr[0];
                QLog.d("RIJProteusMethod", 1, "MethodHyperLink invoke,s=" + str + " firstObject=" + obj);
                String valueOf = String.valueOf(obj);
                if (objArr.length >= 2) {
                    Object obj2 = objArr[1];
                    if (obj2 instanceof View) {
                        view = (View) obj2;
                        boolean b16 = false | b(valueOf, false);
                        boolean d16 = b16 | d(valueOf, b16);
                        c16 = d16 | c(view, valueOf, d16);
                        if (!(a(view, valueOf, c16) | c16)) {
                            ((IRIJJumpUtils) QRoute.api(IRIJJumpUtils.class)).jumpToUrl(BaseApplication.getContext(), valueOf);
                        }
                    }
                }
                view = null;
                boolean b162 = false | b(valueOf, false);
                boolean d162 = b162 | d(valueOf, b162);
                c16 = d162 | c(view, valueOf, d162);
                if (!(a(view, valueOf, c16) | c16)) {
                }
            }
            return null;
        }
    }

    public h() {
        a();
    }

    private void a() {
        b(CustomMethodsRegister.CMD_HYPER_LINK_CLICK, new b());
    }

    public void b(String str, CustomMethodsRegister.CustomMethodInterface customMethodInterface) {
        if (!TextUtils.isEmpty(str) && customMethodInterface != null) {
            this.f239413a.put(str, customMethodInterface);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface
    public Object invoke(String str, Object... objArr) {
        QLog.d("RIJProteusMethod", 1, "invoke,s=" + str);
        if (this.f239413a.containsKey(str)) {
            return this.f239413a.get(str).invoke(str, objArr);
        }
        return null;
    }
}
