package com.tencent.mobileqq.tbstool.gray;

import android.text.TextUtils;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.perf.report.PerfFeature;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tbstool.adapter.c;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.tool.TbsToolEntrance;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00042\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/tbstool/gray/a;", "", "", "b", "c", "Lcom/tencent/mobileqq/tbstool/adapter/b;", "a", "", "Ljava/lang/String;", "getSuffix", "()Ljava/lang/String;", "suffix", "Ljava/lang/Boolean;", "newTBSViewSwitch", "<init>", "(Ljava/lang/String;)V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final c f291446d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final com.tencent.mobileqq.tbstool.adapter.a f291447e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String suffix;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean newTBSViewSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/tbstool/gray/a$a;", "", "", "KEY_TBS_OFFICE_PLUGIN", "Ljava/lang/String;", "KEY_TBS_PDF_PLUGIN", "TAG", "Lcom/tencent/mobileqq/tbstool/adapter/a;", "defaultLocalTbsViewManager", "Lcom/tencent/mobileqq/tbstool/adapter/a;", "Lcom/tencent/mobileqq/tbstool/adapter/c;", "tbsToolLocalTbsViewManager", "Lcom/tencent/mobileqq/tbstool/adapter/c;", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tbstool.gray.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23650);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        f291446d = new c();
        f291447e = new com.tencent.mobileqq.tbstool.adapter.a();
    }

    public a(@NotNull String suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) suffix);
        } else {
            this.suffix = suffix;
        }
    }

    private final boolean b() {
        return TextUtils.equals(this.suffix, FileReaderHelper.PDF_EXT);
    }

    @NotNull
    public final synchronized com.tencent.mobileqq.tbstool.adapter.b a() {
        com.tencent.mobileqq.tbstool.adapter.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.tbstool.adapter.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (c()) {
            bVar = f291446d;
        } else {
            bVar = f291447e;
        }
        return bVar;
    }

    public final synchronized boolean c() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean z17 = false;
        if (this.newTBSViewSwitch == null) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102937", false);
            boolean isSupportCquatre = TbsToolEntrance.getInstance().isSupportCquatre(this.suffix);
            if (isSwitchOn && isSupportCquatre) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.newTBSViewSwitch = Boolean.valueOf(z16);
            QLog.d("GrayStrategy", 1, "useNewTBSView real get uniteSwitch: " + isSwitchOn + ", isSupportCquatre: " + isSupportCquatre + ", suffix: " + this.suffix);
            if (Intrinsics.areEqual(this.newTBSViewSwitch, Boolean.TRUE)) {
                MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE);
                Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE)");
                if (b()) {
                    PerfFeature.a(PerfFeature.CustomFlag.TBSToolPDF);
                    CrashReport.putUserData(BaseApplication.getContext(), "tbsToolPDF", "true");
                    QLog.d("GrayStrategy", 1, "useNewTBSView add pdf flag");
                    fromV2.putBoolean("key_tbs_pdf_plugin", true);
                } else {
                    PerfFeature.a(PerfFeature.CustomFlag.TBSToolOffice);
                    CrashReport.putUserData(BaseApplication.getContext(), "tbsToolOffice", "true");
                    QLog.d("GrayStrategy", 1, "useNewTBSView add office flag");
                    fromV2.putBoolean("key_tbs_office_plugin", true);
                }
            }
        }
        Boolean bool = this.newTBSViewSwitch;
        if (bool != null) {
            z17 = bool.booleanValue();
        }
        return z17;
    }
}
