package com.tencent.mobileqq.search.rich;

import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ArkAppModule extends ArkAppQQModuleBase {

    /* renamed from: l, reason: collision with root package name */
    private WeakReference<a> f283719l;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(long j3, String str);

        void b(long j3, String str, String str2);
    }

    public ArkAppModule(ark.Application application, int i3) {
        super(application, i3);
    }

    private int s(ark.VariantWrapper variantWrapper, int i3) {
        if (variantWrapper == null) {
            return i3;
        }
        int GetType = variantWrapper.GetType();
        if (GetType == 4) {
            return (int) variantWrapper.GetDouble();
        }
        if (GetType == 3) {
            return variantWrapper.GetInt();
        }
        return i3;
    }

    private long t(ark.VariantWrapper variantWrapper, long j3) {
        if (variantWrapper == null) {
            return j3;
        }
        int GetType = variantWrapper.GetType();
        if (GetType == 4) {
            return (long) variantWrapper.GetDouble();
        }
        if (GetType == 3) {
            return variantWrapper.GetInt();
        }
        return j3;
    }

    private String u(ark.VariantWrapper variantWrapper, String str) {
        if (variantWrapper == null) {
            return str;
        }
        int GetType = variantWrapper.GetType();
        if (GetType == 5) {
            return variantWrapper.GetString();
        }
        if (GetType == 6) {
            return variantWrapper.GetTableAsJsonString();
        }
        return str;
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        super.Destruct();
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "QQSearch";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        if (str.equals("Report")) {
            return true;
        }
        if (str.equals("GetContainerInfo")) {
            return false;
        }
        if (str.equals("SetTalkBackText") || str.equals("Notify")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (!c(str)) {
            return false;
        }
        if (str.equals("Report")) {
            return x(variantWrapperArr, variantWrapper);
        }
        if (str.equals("SetTalkBackText")) {
            return y(variantWrapperArr, variantWrapper);
        }
        if (!str.equals("Notify")) {
            return false;
        }
        return w(variantWrapperArr, variantWrapper);
    }

    @Override // com.tencent.mobileqq.ark.module.b
    protected com.tencent.mobileqq.ark.module.e[] e() {
        return null;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean n() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean o() {
        return true;
    }

    public void v(a aVar) {
        this.f283719l = new WeakReference<>(aVar);
    }

    protected boolean w(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (variantWrapperArr != null && variantWrapperArr.length > 3 && variantWrapperArr[1].IsString() && variantWrapperArr[3].IsView()) {
            final String GetString = variantWrapperArr[1].GetString();
            final String u16 = u(variantWrapperArr[2], null);
            final long GetView = variantWrapperArr[3].GetView();
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.search.rich.ArkAppModule.2
                @Override // java.lang.Runnable
                public void run() {
                    a aVar;
                    if (ArkAppModule.this.f283719l != null && (aVar = (a) ArkAppModule.this.f283719l.get()) != null) {
                        aVar.b(GetView, GetString, u16);
                    }
                }
            });
        }
        return true;
    }

    protected boolean x(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        String b16;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
        if (qQAppInterface == null) {
            return false;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        String GetString = variantWrapperArr[0].GetString();
        int i3 = 0;
        int i16 = 0;
        String GetString2 = variantWrapperArr[1].GetString();
        String str = "";
        long j3 = 0;
        long j16 = 0;
        String str2 = GetString;
        String str3 = str;
        for (int i17 = 0; i17 < variantWrapperArr.length; i17++) {
            if (i17 == 0) {
                str2 = variantWrapperArr[0].GetString();
            } else if (i17 == 1) {
                GetString2 = variantWrapperArr[1].GetString();
            } else if (i17 == 2) {
                i3 = s(variantWrapperArr[2], 0);
            } else if (i17 == 3) {
                i16 = s(variantWrapperArr[3], 0);
            } else if (i17 == 4) {
                j3 = t(variantWrapperArr[4], 0L);
            } else if (i17 == 5) {
                j16 = t(variantWrapperArr[5], 0L);
            } else if (i17 == 6) {
                str = variantWrapperArr[6].GetString();
            } else if (i17 == 7) {
                str3 = variantWrapperArr[7].GetString();
            }
        }
        if (!"0X8009D41".equals(GetString2) && !"0X8009D2D".equals(GetString2)) {
            b16 = str3;
        } else {
            b16 = com.tencent.mobileqq.search.report.b.b();
        }
        ReportController.o(qQAppInterface, "CliOper", "", currentAccountUin, str2, GetString2, i3, i16, String.valueOf(j3), String.valueOf(j16), str, b16);
        return true;
    }

    protected boolean y(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (variantWrapperArr != null && variantWrapperArr.length >= 2 && variantWrapperArr[0].IsString() && variantWrapperArr[1].IsView()) {
            final String GetString = variantWrapperArr[0].GetString();
            final long GetView = variantWrapperArr[1].GetView();
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.search.rich.ArkAppModule.1
                @Override // java.lang.Runnable
                public void run() {
                    a aVar;
                    if (ArkAppModule.this.f283719l != null && (aVar = (a) ArkAppModule.this.f283719l.get()) != null) {
                        aVar.a(GetView, GetString);
                    }
                }
            });
        }
        return true;
    }
}
