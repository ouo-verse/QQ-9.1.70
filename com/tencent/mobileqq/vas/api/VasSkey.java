package com.tencent.mobileqq.vas.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasSkey {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f308455a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f308456b;

        a(String str, StringBuilder sb5) {
            this.f308455a = str;
            this.f308456b = sb5;
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            QLog.e("VasSkey", 1, this.f308455a + " getPsKey Failed errMsg:" + str);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            String str = map.get(this.f308455a);
            if (TextUtils.isEmpty(str)) {
                QLog.e("VasSkey", 1, this.f308455a + " getPsKey empty");
                return;
            }
            this.f308456b.append(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f308457a;

        b(c cVar) {
            this.f308457a = cVar;
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            c cVar = this.f308457a;
            if (cVar != null) {
                cVar.onFail(str);
            }
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            c cVar = this.f308457a;
            if (cVar != null) {
                cVar.onSuccess(map);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void onFail(@NonNull String str);

        void onSuccess(@NonNull Map<String, String> map);
    }

    @Nullable
    public static String getPSkey(AppRuntime appRuntime, String str) {
        StringBuilder sb5 = new StringBuilder();
        ((IPskeyManager) appRuntime.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{str}, new a(str, sb5));
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(sb6)) {
            return null;
        }
        return sb6;
    }

    public static String getSkey(TicketManager ticketManager, String str) {
        if (VasNormalToggle.VAS_FEATURE_SKEY.isEnable(true)) {
            return "";
        }
        return ticketManager.getSkey(str);
    }

    public static void getPSkey(AppRuntime appRuntime, String str, c cVar) {
        ((IPskeyManager) appRuntime.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{str}, new b(cVar));
    }
}
