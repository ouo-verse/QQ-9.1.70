package com.tencent.mobileqq.activity.about;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.about.modelviewer.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rainbow.api.IRainbowApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentLoadSoUtil;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.util.AbiUtil;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0002R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R+\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00040\u001c0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u001f\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/activity/about/c;", "Landroidx/lifecycle/ViewModel;", "", "T1", "", "filePath", "Ljava/nio/ByteBuffer;", "g2", "Landroid/content/Context;", "context", "b2", "addObserver", "removeObserver", "e2", "f2", "", IProfileCardConst.KEY_FROM_TYPE, "baseUrl", "c2", "X1", "i", "Ljava/lang/String;", "officialWebVersion", "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", "mWrapper", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "d2", "()Landroidx/lifecycle/MutableLiveData;", "versionInfoData", "D", "U1", "filamentData", "E", "W1", "fixToolData", "Lcom/tencent/mobileqq/app/h;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/app/h;", "configObserver", "Lcom/tencent/mobileqq/rainbow/a;", "G", "Lcom/tencent/mobileqq/rainbow/a;", "rainbowObserver", "<init>", "()V", "H", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class c extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<UpgradeDetailWrapper, String>> versionInfoData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ByteBuffer> filamentData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Unit> fixToolData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.app.h configObserver;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.rainbow.a rainbowObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String officialWebVersion;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UpgradeDetailWrapper mWrapper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/activity/about/c$a;", "", "", "ENTER_FEEDBACK_TYPE", "I", "ENTER_HELPER_TYPE", "ENTER_INTRODUCTION_TYPE", "", "TAG", "Ljava/lang/String;", "UC_CONFIG_FIX_TOOL", "URL_FEEDBACK_TAG", "VERSION32", "VERSION64", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.about.c$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/about/c$b", "Lcom/tencent/mobileqq/app/h;", "", "isSuccess", "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", "wrapper", "", "p", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b extends com.tencent.mobileqq.app.h {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.h
        public void p(boolean isSuccess, @NotNull UpgradeDetailWrapper wrapper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), wrapper);
                return;
            }
            Intrinsics.checkNotNullParameter(wrapper, "wrapper");
            c.this.mWrapper = wrapper;
            c.this.d2().postValue(new Pair<>(c.this.mWrapper, c.this.officialWebVersion));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/about/c$c", "Lcom/tencent/mobileqq/activity/about/modelviewer/c$a;", "", "modelPath", "", "b", "errorMsg", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.about.c$c, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C7117c implements c.a {
        static IPatchRedirector $redirector_;

        C7117c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.about.modelviewer.c.a
        public void a(@NotNull String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            QLog.e("AboutDetailViewModel", 1, "filament loadFail errorMsg: " + errorMsg);
        }

        @Override // com.tencent.mobileqq.activity.about.modelviewer.c.a
        public void b(@NotNull String modelPath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelPath);
                return;
            }
            Intrinsics.checkNotNullParameter(modelPath, "modelPath");
            QLog.i("AboutDetailViewModel", 2, "filament environment and model loadSuccess");
            ByteBuffer g26 = c.this.g2(modelPath);
            if (g26 == null) {
                QLog.e("AboutDetailViewModel", 1, "load Model Success but read failed");
            } else {
                c.this.U1().postValue(g26);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/activity/about/c$d", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class d implements gl0.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // gl0.b
        public void a(boolean isSuccess, boolean downloadSo, int errCode, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Boolean.valueOf(downloadSo), Integer.valueOf(errCode), errMsg);
                return;
            }
            if (isSuccess) {
                c.this.T1();
                return;
            }
            QLog.e("AboutDetailViewModel", 1, "downLoad So failed errCode: " + errCode + " errMsg: " + errMsg + " ");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/activity/about/c$e", "Lcom/tencent/mobileqq/rainbow/a;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class e extends com.tencent.mobileqq.rainbow.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        @SuppressLint({"SuspiciousIndentation"})
        public void onUpdate(int type, boolean isSuccess, @NotNull Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            if (type == 1 && (data instanceof JSONObject)) {
                try {
                    if (((JSONObject) data).has("version64")) {
                        c cVar = c.this;
                        String string = ((JSONObject) data).getString("version64");
                        Intrinsics.checkNotNullExpressionValue(string, "data.getString(VERSION64)");
                        cVar.officialWebVersion = string;
                    } else if (((JSONObject) data).has("version32")) {
                        c cVar2 = c.this;
                        String string2 = ((JSONObject) data).getString("version32");
                        Intrinsics.checkNotNullExpressionValue(string2, "data.getString(VERSION32)");
                        cVar2.officialWebVersion = string2;
                    }
                    c.this.d2().postValue(new Pair<>(c.this.mWrapper, c.this.officialWebVersion));
                } catch (JSONException e16) {
                    QLog.e("AboutDetailViewModel", 1, "rainbowobserver jaon error", e16);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23069);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.officialWebVersion = AEResManagerConfigBean.DEFAULT_VERSION;
        this.versionInfoData = new MutableLiveData<>();
        this.filamentData = new MutableLiveData<>();
        this.fixToolData = new MutableLiveData<>();
        this.configObserver = new b();
        this.rainbowObserver = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1() {
        QLog.i("AboutDetailViewModel", 2, "start downFilamentModels");
        com.tencent.mobileqq.activity.about.modelviewer.c.f177734a.i(new C7117c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(w msgService, final c this$0) {
        Intrinsics.checkNotNullParameter(msgService, "$msgService");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        msgService.isMqqDataImportFinished(new IOperateCallback() { // from class: com.tencent.mobileqq.activity.about.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                c.a2(c.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(c this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            QLog.d("AboutDetailViewModel", 1, "isMqqDataImportFinished result: " + i3 + ", errMsg: " + str);
            return;
        }
        this$0.fixToolData.postValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ByteBuffer g2(String filePath) {
        try {
            File file = new File(filePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bArr = new byte[(int) file.length()];
            bufferedInputStream.read(bArr);
            bufferedInputStream.close();
            return ByteBuffer.wrap(bArr);
        } catch (Exception e16) {
            QLog.e("AboutDetailViewModel", 1, "readFile failed filePath: " + filePath + ", error: " + e16);
            return null;
        }
    }

    @NotNull
    public final MutableLiveData<ByteBuffer> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.filamentData;
    }

    @NotNull
    public final MutableLiveData<Unit> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.fixToolData;
    }

    public final void X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fix_tool_storage_clean_switch", false);
        QLog.d("AboutDetailViewModel", 1, "handleFixToolButton fix_tool_storage_clean_switch: " + isSwitchOn);
        if (!isSwitchOn) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        final w msgService = ((IKernelService) ((QQAppInterface) peekAppRuntime).getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.about.a
            @Override // java.lang.Runnable
            public final void run() {
                c.Z1(w.this, this);
            }
        }, 32, null, true);
    }

    public final void addObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        try {
            qQAppInterface.addObserver(this.configObserver);
            qQAppInterface.addObserver(this.rainbowObserver);
        } catch (Error e16) {
            QLog.e("AboutDetailViewModel", 1, "addObserver error: " + e16 + " ");
        }
    }

    public final void b2(@NotNull Context context) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (AbiUtil.isArm64Runtime(context)) {
            str = "version64";
        } else {
            str = "version32";
        }
        ((IRainbowApi) QRoute.api(IRainbowApi.class)).getCmdRainbowData("versionData", str, 1);
    }

    @NotNull
    public final String c2(int fromType, @NotNull String baseUrl) {
        String str;
        String str2;
        String replace;
        boolean endsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, fromType, (Object) baseUrl);
        }
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        String str3 = "version=" + AppSetting.f99554n + "&appid=" + AppSetting.f() + "&QUA=" + QZoneHelper.getQUA();
        if (fromType == 1 || fromType == 2) {
            str3 = str3 + "&adtag=" + AppSetting.f99542b;
        }
        if (fromType == 1) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(baseUrl, "#_rc=mqq_faq_feedback", false, 2, null);
            if (endsWith$default) {
                baseUrl = baseUrl.substring(0, baseUrl.length() - 21);
                Intrinsics.checkNotNullExpressionValue(baseUrl, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            str = ContainerUtils.FIELD_DELIMITER + str3;
        } else {
            str = ContainerUtils.FIELD_DELIMITER + str3;
        }
        String str4 = baseUrl + str;
        if (fromType == 1 || fromType == 2) {
            if (QLog.isColorLevel()) {
                if (fromType == 1) {
                    QLog.i("About-Feedback", 2, "feedfack before: url = " + str4);
                } else {
                    QLog.i("About-Help", 2, "help before: url = " + str4);
                }
            }
            String model = DeviceInfoMonitor.getModel();
            String str5 = "";
            if (model == null || (str2 = new Regex(" ").replace(model, "_")) == null) {
                str2 = "";
            }
            int qzonePatchTag = StatisticCollector.getQzonePatchTag();
            if (qzonePatchTag > 0) {
                str2 = str2 + "_qzpatch" + qzonePatchTag;
            }
            String str6 = Build.MANUFACTURER;
            if (str6 != null && (replace = new Regex(" ").replace(str6, "_")) != null) {
                str5 = replace;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str4);
            sb5.append("&model=");
            sb5.append(str2);
            sb5.append("&manufacture=");
            sb5.append(str5);
            sb5.append("&cpunum=");
            sb5.append(ah.n());
            sb5.append("&cpurate=");
            sb5.append(ah.l());
            sb5.append("&mem=");
            long j3 = 1024;
            sb5.append((com.tencent.mobileqq.utils.m.c() / j3) / j3);
            sb5.append("&amem=");
            sb5.append((ah.X() / j3) / j3);
            sb5.append("&w=");
            sb5.append(ah.x());
            sb5.append("&h=");
            sb5.append(ah.w());
            sb5.append("&pss=");
            sb5.append((sy3.b.d(Process.myPid()) / j3) / j3);
            sb5.append("&heapmax=");
            sb5.append((Runtime.getRuntime().maxMemory() / j3) / j3);
            sb5.append("&heapsize=");
            sb5.append(((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / j3) / j3);
            sb5.append("&sysver=");
            sb5.append(Build.VERSION.RELEASE);
            sb5.append("&user_tag=");
            sb5.append(QLog.getReportLevel(QLog.getUIN_REPORTLOG_LEVEL()));
            str4 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(str4, "sb.toString()");
            if (fromType == 1) {
                str4 = str4 + "#_rc=mqq_faq_feedback";
                if (4 != QLog.getUIN_REPORTLOG_LEVEL()) {
                    QLog.setUIN_REPORTLOG_LEVEL(4);
                    NativeConfigStore nativeConfigStore = MsfStore.getNativeConfigStore();
                    if (nativeConfigStore != null) {
                        nativeConfigStore.setConfig(QLog.logLevelHead, "4");
                        long currentTimeMillis = System.currentTimeMillis();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(currentTimeMillis);
                        nativeConfigStore.setConfig(QLog.logLevelTime, sb6.toString());
                    }
                }
            }
            if (QLog.isColorLevel()) {
                if (fromType == 1) {
                    QLog.i("About-Feedback", 2, "feedfack after: url = " + str4);
                } else {
                    QLog.i("About-Help", 2, "help after: url = " + str4);
                }
            }
        }
        return str4;
    }

    @NotNull
    public final MutableLiveData<Pair<UpgradeDetailWrapper, String>> d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.versionInfoData;
    }

    public final void e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            QLog.d("AboutDetailViewModel", 2, "start initFilamentEnvironment");
            ((IZPlanFilamentLoadSoUtil) QRoute.api(IZPlanFilamentLoadSoUtil.class)).downloadAndLoadSo(new d());
        }
    }

    public final void f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        UpgradeDetailWrapper j3 = com.tencent.mobileqq.upgrade.k.i().j();
        this.mWrapper = j3;
        this.versionInfoData.postValue(new Pair<>(j3, this.officialWebVersion));
    }

    public final void removeObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        try {
            qQAppInterface.removeObserver(this.configObserver);
            qQAppInterface.removeObserver(this.rainbowObserver);
        } catch (Error e16) {
            QLog.e("AboutDetailViewModel", 1, "removeObserver error: " + e16 + " ");
        }
    }
}
