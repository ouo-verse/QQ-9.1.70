package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/soload/api/impl/l;", "Lcom/tencent/mobileqq/soload/api/impl/e;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/soload/biz/entity/SoLoadInfo;", "i", "Lcom/tencent/mobileqq/soload/biz/entity/SoLocalInfo;", "localInfo", "l", "Lcom/tencent/mobileqq/soload/entity/a;", "soCrashInfo", "", tl.h.F, "Lcom/tencent/mobileqq/soload/biz/entity/LoadParam;", "k", "Lcom/tencent/mobileqq/soload/biz/entity/LoadParam;", "getLoadParam", "()Lcom/tencent/mobileqq/soload/biz/entity/LoadParam;", "setLoadParam", "(Lcom/tencent/mobileqq/soload/biz/entity/LoadParam;)V", "loadParam", "Lcom/tencent/mobileqq/soload/biz/entity/LoadParam$LoadItem;", "Lcom/tencent/mobileqq/soload/biz/entity/LoadParam$LoadItem;", "getLoadItem", "()Lcom/tencent/mobileqq/soload/biz/entity/LoadParam$LoadItem;", "setLoadItem", "(Lcom/tencent/mobileqq/soload/biz/entity/LoadParam$LoadItem;)V", "loadItem", "<init>", "(Lcom/tencent/mobileqq/soload/biz/entity/LoadParam;Lcom/tencent/mobileqq/soload/biz/entity/LoadParam$LoadItem;)V", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class l extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LoadParam loadParam;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LoadParam.LoadItem loadItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/soload/api/impl/l$a", "Liz3/e;", "", "reason", "", "onFail", "onSuccess", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements iz3.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // iz3.e, iz3.m
        public /* synthetic */ void a(List list, List list2, List list3) {
            iz3.d.a(this, list, list2, list3);
        }

        @Override // iz3.m
        public void onFail(@NotNull String reason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) reason);
                return;
            }
            Intrinsics.checkNotNullParameter(reason, "reason");
            if (QLog.isColorLevel()) {
                QLog.i(l.this.m(), 2, "fetchNewConfig so = " + l.this.f288549b.name + ", onFail " + reason);
            }
        }

        @Override // iz3.e
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(l.this.m(), 2, "fetchNewConfig so = " + l.this.f288549b.name + ", onSuccess");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull LoadParam loadParam, @NotNull LoadParam.LoadItem loadItem) {
        super(loadParam, loadItem);
        Intrinsics.checkNotNullParameter(loadParam, "loadParam");
        Intrinsics.checkNotNullParameter(loadItem, "loadItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) loadParam, (Object) loadItem);
        } else {
            this.loadParam = loadParam;
            this.loadItem = loadItem;
        }
    }

    @Override // com.tencent.mobileqq.soload.api.impl.e
    protected void h(@Nullable com.tencent.mobileqq.soload.entity.a soCrashInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) soCrashInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(m(), 2, "fetchNewConfig so = " + this.f288549b.name + ", soCrashInfo = " + soCrashInfo);
        }
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance().g(new a());
    }

    @Override // com.tencent.mobileqq.soload.api.impl.e
    @NotNull
    public SoLoadInfo i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SoLoadInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i(m(), 2, "getLoadInfo getLatest so = " + this.f288549b.name);
        }
        com.tencent.rdelivery.reshub.api.i resHubInstance = ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance();
        String str = this.f288549b.name;
        Intrinsics.checkNotNullExpressionValue(str, "mLoadItem.name");
        com.tencent.rdelivery.reshub.api.g q16 = resHubInstance.q(str, false);
        if (q16 == null) {
            SoLoadInfo n3 = n(2);
            Intrinsics.checkNotNullExpressionValue(n3, "onSoResult(OnLoadListener.RES_CODE_NO_SO_CONFIG)");
            return n3;
        }
        SoDetailInfo b16 = m.f288614a.b(q16);
        this.f288555h = b16;
        SoLoadInfo k3 = k(com.tencent.mobileqq.soload.util.f.i(this.f288549b.name, b16.ver));
        if (k3 != null) {
            return k3;
        }
        SoLocalInfo soLocalInfo = com.tencent.mobileqq.soload.util.f.o(this.f288549b, this.f288555h);
        soLocalInfo.mSoPath = q16.e();
        Intrinsics.checkNotNullExpressionValue(soLocalInfo, "soLocalInfo");
        return l(soLocalInfo);
    }

    @Override // com.tencent.mobileqq.soload.api.impl.e
    @NotNull
    protected SoLoadInfo l(@NotNull SoLocalInfo localInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SoLoadInfo) iPatchRedirector.redirect((short) 8, (Object) this, (Object) localInfo);
        }
        Intrinsics.checkNotNullParameter(localInfo, "localInfo");
        boolean g16 = g(localInfo);
        boolean f16 = com.tencent.mobileqq.soload.api.impl.a.f(localInfo, this.f288555h);
        if ((this.f288549b.lops.flag & 4) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(m(), 2, "[getSoLoadInfoBySoLocalInfo] isSoExist=" + g16 + ",isRFReady=" + f16 + ",isWeak:" + z16);
        }
        if (!g16) {
            SoLoadInfo n3 = n(3);
            Intrinsics.checkNotNullExpressionValue(n3, "onSoResult(OnLoadListene\u2026ES_CODE_DOWNLOAD_SO_FAIL)");
            return n3;
        }
        if (!f16 && !z16) {
            SoLoadInfo n16 = n(11);
            Intrinsics.checkNotNullExpressionValue(n16, "onSoResult(OnLoadListene\u2026WNLOAD_RELATED_FILE_FAIL)");
            return n16;
        }
        this.f288552e = false;
        String str = localInfo.mSoPath;
        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(MobileQQ.sMobileQQ, str);
        this.f288553f = str;
        if (f16) {
            this.f288554g = localInfo.mRFileFolder;
        }
        SoLoadInfo n17 = n(0);
        Intrinsics.checkNotNullExpressionValue(n17, "onSoResult(OnLoadListener.RES_CODE_SUCC)");
        return n17;
    }

    @Override // com.tencent.mobileqq.soload.api.impl.e
    @NotNull
    protected String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "SoLoadWidget.ShiplyGetSoTaskSync";
    }
}
