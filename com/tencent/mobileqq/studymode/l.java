package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002PQB\u000f\u0012\u0006\u0010)\u001a\u00020'\u00a2\u0006\u0004\bN\u0010OJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J&\u0010\u001b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0002J\u0010\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u001f\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020$J\b\u0010&\u001a\u00020\bH\u0016R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010(R\u0014\u0010+\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010*R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010-R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00100\u001a\u0004\b5\u00102\"\u0004\b6\u00104R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\"\u0010?\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010C\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\u0016\u0010E\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010:R\u0016\u0010G\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u00100R\u0016\u0010I\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00100R\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/studymode/l;", "Lmqq/manager/Manager;", "", "bPref", "targetType", "oldType", "", "bSwitchElsePref", "", "k", "isSuc", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "message", "p", "j", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/studymode/l$b;", "i", "f", "e", "l", "bChangeTheme", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "u", "Lcom/tencent/mobileqq/studymode/l$a;", "onModeChangeResultCallback", "d", "v", "isStudy", "t", "isStudent", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/app/BaseActivity;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/app/QQAppInterface;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Ljava/lang/String;", "tag", "", "Ljava/util/List;", "onModeChangeResultCallbacks", tl.h.F, "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "setTargetType", "(I)V", "getOldType", HippyTKDListViewAdapter.X, "getBPref", "w", BdhLogUtil.LogTag.Tag_Conn, "Z", "o", "()Z", "y", "(Z)V", "isSwitching", "D", "getFromElder", "setFromElder", "fromElder", "E", "needCheckShowModeSwitchDialog", UserInfo.SEX_FEMALE, "studyModePullStatus", "G", "studentFlagPullStatus", "Lcom/tencent/mobileqq/simpleui/f;", "H", "Lcom/tencent/mobileqq/simpleui/f;", "simpleUIObserver", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class l implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isSwitching;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean fromElder;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean needCheckShowModeSwitchDialog;

    /* renamed from: F, reason: from kotlin metadata */
    private int studyModePullStatus;

    /* renamed from: G, reason: from kotlin metadata */
    private int studentFlagPullStatus;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.simpleui.f simpleUIObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQAppInterface app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> onModeChangeResultCallbacks;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int targetType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int oldType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int bPref;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/studymode/l$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isSwitching", "b", "I", "()I", "targetMode", "oldMode", "<init>", "(ZII)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSwitching;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int targetMode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int oldMode;

        public b() {
            this(false, 0, 0, 7, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                return;
            }
            iPatchRedirector.redirect((short) 13, (Object) this);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.oldMode;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.targetMode;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isSwitching;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.isSwitching == bVar.isSwitching && this.targetMode == bVar.targetMode && this.oldMode == bVar.oldMode) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            boolean z16 = this.isSwitching;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.targetMode) * 31) + this.oldMode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "SwitchingStatus(isSwitching=" + this.isSwitching + ", targetMode=" + this.targetMode + ", oldMode=" + this.oldMode + ")";
        }

        public b(boolean z16, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.isSwitching = z16;
            this.targetMode = i3;
            this.oldMode = i16;
        }

        public /* synthetic */ b(boolean z16, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J(\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/studymode/l$c", "Lcom/tencent/mobileqq/simpleui/f;", "", "isSuc", "", "params", "", "c", "bChangeTheme", "bSwitchElsePref", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "e", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends com.tencent.mobileqq.simpleui.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.mobileqq.simpleui.f
        protected void c(boolean isSuc, @NotNull Object params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuc), params);
                return;
            }
            Intrinsics.checkNotNullParameter(params, "params");
            Iterator it = l.this.onModeChangeResultCallbacks.iterator();
            while (it.hasNext()) {
                ((a) it.next()).C6(isSuc, params);
            }
        }

        @Override // com.tencent.mobileqq.simpleui.f
        protected void e(boolean isSuc, boolean bChangeTheme, boolean bSwitchElsePref, int statusCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuc), Boolean.valueOf(bChangeTheme), Boolean.valueOf(bSwitchElsePref), Integer.valueOf(statusCode));
                return;
            }
            l.this.y(false);
            if (StudyModeManager.i()) {
                l.this.u(isSuc, bChangeTheme, bSwitchElsePref, statusCode);
                return;
            }
            Iterator it = l.this.onModeChangeResultCallbacks.iterator();
            while (it.hasNext()) {
                ((a) it.next()).wa(isSuc, bChangeTheme, bSwitchElsePref, statusCode);
            }
        }
    }

    public l(@NotNull QQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
            return;
        }
        this.app = app;
        this.tag = "GeneralModeSwitcherManager";
        this.onModeChangeResultCallbacks = new ArrayList();
        this.targetType = -1;
        this.oldType = -1;
        this.bPref = -1;
        this.needCheckShowModeSwitchDialog = true;
        c cVar = new c();
        this.simpleUIObserver = cVar;
        app.addObserver(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(l this$0, int i3, int i16, int i17, boolean z16, DialogInterface dialogInterface, int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dialogInterface instanceof QQCustomDialog) {
            ((QQCustomDialog) dialogInterface).setOnDismissListener(null);
        }
        this$0.k(i3, i16, i17, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(l this$0, int i3, int i16, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.onModeChangeResultCallbacks.iterator();
        while (it.hasNext()) {
            ((a) it.next()).W1(i3, i16);
        }
    }

    private final void j() {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "checkAndReportStockStudyMode -> studyModePullStatus : " + this.studyModePullStatus + ", studentFlagPullStatus : " + this.studentFlagPullStatus);
        }
        if (this.studyModePullStatus == 1 && this.studentFlagPullStatus != 0) {
            boolean i16 = StudyModeManager.i();
            boolean n3 = n();
            if (QLog.isColorLevel()) {
                QLog.d(this.tag, 2, "checkAndReportStockStudyMode -> configSwitch : " + i16 + ", isSameDay \uff1a " + n3);
            }
            if (i16 && !n3) {
                if (this.studentFlagPullStatus == 1) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(this.tag, 2, "checkAndReportStockStudyMode ReportController 0X800AD6C \uff0c identity \uff1a " + i3);
                }
                com.tencent.mobileqq.utils.p.g(BaseApplication.context, this.app.getCurrentAccountUin(), true, AppConstants.Preferences.KEY_STUDY_MODE_LAST_LOGIN_REPORT_TIME, new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE).format(new Date()));
                ReportController.o(this.app, "dc00898", "", "", "0X800AD6C", "0X800AD6C", 0, i3, "", "", "", "");
            }
        }
    }

    private final void k(int bPref, int targetType, int oldType, boolean bSwitchElsePref) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (!ElderModeManager.j()) {
            this.isSwitching = true;
        }
        BusinessHandler businessHandler = this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
        SimpleUIHandler simpleUIHandler = (SimpleUIHandler) businessHandler;
        if (targetType == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (targetType == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (targetType == 3) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!simpleUIHandler.j3(z16, bPref, bSwitchElsePref, z17, z18)) {
            QLog.d(this.tag, 1, "doChangeMode switching");
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.f173120hi3, 0).show();
            if (this.isSwitching) {
                Iterator<T> it = this.onModeChangeResultCallbacks.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).ed(this.targetType, this.oldType);
                }
                return;
            }
            return;
        }
        if (ElderModeManager.j()) {
            this.isSwitching = true;
        }
        QLog.d(this.tag, 1, "doChangeMode switch start");
        this.targetType = targetType;
        this.oldType = oldType;
        this.bPref = bPref;
        Iterator<T> it5 = this.onModeChangeResultCallbacks.iterator();
        while (it5.hasNext()) {
            ((a) it5.next()).Aa(targetType, oldType);
        }
    }

    private final boolean n() {
        String str = (String) com.tencent.mobileqq.utils.p.a(BaseApplication.context, this.app.getCurrentAccountUin(), AppConstants.Preferences.KEY_STUDY_MODE_LAST_LOGIN_REPORT_TIME, "");
        if (!TextUtils.isEmpty(str)) {
            Date parse = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE).parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            if (calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
                return true;
            }
        }
        return false;
    }

    private final void p(boolean isSuc, String message) {
        for (a aVar : this.onModeChangeResultCallbacks) {
            int i3 = this.targetType;
            if (i3 == -1) {
                i3 = this.oldType;
            }
            aVar.j7(isSuc, i3, this.oldType, message);
        }
        if (isSuc) {
            if (this.targetType == 2 || this.oldType == 2) {
                com.tencent.mobileqq.utils.p.g(BaseApplication.context, this.app.getCurrentAccountUin(), true, AppConstants.Preferences.KEY_STUDY_MODE_HAS_CHANGE, Boolean.TRUE);
            }
        }
    }

    private final void q(boolean isSuc) {
        if (!isSuc) {
            String string = BaseApplication.getContext().getString(R.string.f168042ek);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026mode_operation_open_fail)");
            p(false, string);
        } else {
            String string2 = BaseApplication.getContext().getString(R.string.f1379608_);
            Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026mode_switch_successfully)");
            p(true, string2);
        }
    }

    private final void r(boolean isSuc) {
        int d16;
        String string;
        int i3 = this.targetType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    d16 = r.b();
                } else {
                    d16 = R.string.f167902e7;
                }
            } else {
                d16 = R.string.f170988wk0;
            }
        } else {
            d16 = r.d();
        }
        String qqStr = HardCodeUtil.qqStr(d16);
        if (isSuc) {
            if (this.targetType == 0 && this.oldType == 3 && this.fromElder) {
                string = BaseApplication.getContext().getString(R.string.f168012eh, HardCodeUtil.qqStr(R.string.f167902e7));
            } else {
                string = BaseApplication.getContext().getString(R.string.f168032ej, qqStr);
            }
        } else if (this.fromElder && this.oldType == 3) {
            string = BaseApplication.getContext().getString(R.string.f168022ei, HardCodeUtil.qqStr(R.string.f167902e7));
        } else {
            string = BaseApplication.getContext().getString(R.string.f168052el, qqStr);
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (isSuc) {\n           \u2026)\n            }\n        }");
        int i16 = this.targetType;
        if (i16 == 3 && !this.fromElder) {
            string = "";
        }
        this.fromElder = false;
        if (isSuc && i16 != 2) {
            StudyModeManager.O(i16);
        }
        p(isSuc, string);
    }

    public final void d(@Nullable a onModeChangeResultCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onModeChangeResultCallback);
        } else if (onModeChangeResultCallback != null && !this.onModeChangeResultCallbacks.contains(onModeChangeResultCallback)) {
            this.onModeChangeResultCallbacks.add(onModeChangeResultCallback);
        }
    }

    @NotNull
    public final b e(int oldType, int targetType, int bPref, boolean bSwitchElsePref) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (b) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(oldType), Integer.valueOf(targetType), Integer.valueOf(bPref), Boolean.valueOf(bSwitchElsePref));
        }
        this.fromElder = false;
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "changeMode targetType: " + targetType + ", bPref : " + bPref + ", isSwitching : " + this.isSwitching);
        }
        boolean z16 = this.isSwitching;
        if (!z16 && (oldType != targetType || bPref != this.bPref)) {
            if (!AppNetConnInfo.isNetSupport()) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.cjm, 0).show();
                Iterator<T> it = this.onModeChangeResultCallbacks.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).W1(targetType, oldType);
                }
                return new b(false, targetType, oldType);
            }
            k(bPref, targetType, oldType, bSwitchElsePref);
            return new b(true, targetType, oldType);
        }
        return new b(z16, targetType, oldType);
    }

    @NotNull
    public final b f(@NotNull Activity activity, final int targetType, final int bPref, final boolean bSwitchElsePref) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (b) iPatchRedirector.redirect((short) 13, this, activity, Integer.valueOf(targetType), Integer.valueOf(bPref), Boolean.valueOf(bSwitchElsePref));
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.fromElder = false;
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "changeMode targetType: " + targetType + ", bPref : " + bPref + ", isSwitching : " + this.isSwitching);
        }
        final int a16 = g.a();
        boolean z16 = this.isSwitching;
        if (!z16 && (a16 != targetType || bPref != this.bPref)) {
            if (!AppNetConnInfo.isNetSupport()) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.cjm, 0).show();
                Iterator<T> it = this.onModeChangeResultCallbacks.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).W1(targetType, a16);
                }
                return new b(false, targetType, a16);
            }
            if (targetType == 1) {
                SharedPreferences uinThemePreferences = ThemeUtil.getUinThemePreferences(this.app);
                if (uinThemePreferences.getBoolean(ThemeConstants.KEY_SIMPLE_SHOULD_SHOW_SWITCH_DIALOG, true)) {
                    uinThemePreferences.edit().putBoolean(ThemeConstants.KEY_SIMPLE_SHOULD_SHOW_SWITCH_DIALOG, false).apply();
                    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.studymode.j
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            l.g(l.this, bPref, targetType, a16, bSwitchElsePref, dialogInterface, i3);
                        }
                    };
                    String string = BaseApplication.getContext().getString(R.string.hhy, BaseApplication.getContext().getString(r.d()));
                    Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026ils.getSimpleModeName()))");
                    QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(activity, string, 0, R.string.vrh, onClickListener, null);
                    createNoTitleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.studymode.k
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            l.h(l.this, targetType, a16, dialogInterface);
                        }
                    });
                    createNoTitleDialog.show();
                } else {
                    k(bPref, targetType, a16, bSwitchElsePref);
                }
            } else {
                k(bPref, targetType, a16, bSwitchElsePref);
            }
            return new b(true, targetType, a16);
        }
        return new b(z16, targetType, a16);
    }

    @NotNull
    public final b i(@NotNull Activity activity, int targetType, int bPref, boolean bSwitchElsePref) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (b) iPatchRedirector.redirect((short) 12, this, activity, Integer.valueOf(targetType), Integer.valueOf(bPref), Boolean.valueOf(bSwitchElsePref));
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        b f16 = f(activity, targetType, bPref, bSwitchElsePref);
        this.fromElder = true;
        return f16;
    }

    public final void l(int bPref, int targetType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(bPref), Integer.valueOf(targetType));
            return;
        }
        this.targetType = targetType;
        this.bPref = bPref;
        this.isSwitching = false;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.targetType;
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isSwitching;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.app.removeObserver(this.simpleUIObserver);
        this.onModeChangeResultCallbacks.clear();
        this.targetType = -1;
        this.oldType = -1;
        this.isSwitching = false;
        this.needCheckShowModeSwitchDialog = false;
        this.fromElder = false;
        this.studyModePullStatus = 0;
        this.studentFlagPullStatus = 0;
    }

    public final void s(boolean isStudent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, isStudent);
            return;
        }
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "onStudentFlagPullComplete isStudent : " + isStudent);
        }
        if (isStudent) {
            i3 = 1;
        }
        this.studentFlagPullStatus = i3;
        j();
    }

    public final void t(boolean isStudy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, isStudy);
            return;
        }
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "onStudyModePullComplete isStudy : " + isStudy);
        }
        if (isStudy) {
            i3 = 1;
        }
        this.studyModePullStatus = i3;
        j();
        StudyModeManager.J();
        IRuntimeService runtimeService = this.app.getRuntimeService(IOnlineStatusManagerService.class, "");
        Intrinsics.checkNotNull(runtimeService, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService");
        ((com.tencent.mobileqq.onlinestatus.manager.f) ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.f.class)).b(isStudy);
    }

    public final void u(boolean isSuc, boolean bChangeTheme, boolean bSwitchElsePref, int statusCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(isSuc), Boolean.valueOf(bChangeTheme), Boolean.valueOf(bSwitchElsePref), Integer.valueOf(statusCode));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "onSwitchUICallBack targetType : " + this.targetType + ", isSuc : " + isSuc + " , bChangeTheme : " + bChangeTheme + ", bSwitchElsePref : " + bSwitchElsePref + " , statusCode : " + statusCode);
        }
        if (bSwitchElsePref) {
            r(isSuc);
        } else {
            q(isSuc);
        }
    }

    public final void v(@Nullable a onModeChangeResultCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) onModeChangeResultCallback);
        } else if (onModeChangeResultCallback != null && this.onModeChangeResultCallbacks.contains(onModeChangeResultCallback)) {
            this.onModeChangeResultCallbacks.remove(onModeChangeResultCallback);
        }
    }

    public final void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.bPref = i3;
        }
    }

    public final void x(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.oldType = i3;
        }
    }

    public final void y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.isSwitching = z16;
        }
    }

    public final void z(@NotNull BaseActivity activity) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "showModeSwitchDialog studyModePullStatus : " + this.studyModePullStatus + " , studentFlagPullStatus : " + this.studentFlagPullStatus);
        }
        if (this.needCheckShowModeSwitchDialog) {
            int i3 = this.studyModePullStatus;
            if (i3 != 0 && this.studentFlagPullStatus != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.needCheckShowModeSwitchDialog = z16;
            if (i3 == 2 && this.studentFlagPullStatus == 1 && StudyModeManager.s()) {
                String currentAccountUin = this.app.getCurrentAccountUin();
                Boolean bool = Boolean.FALSE;
                if (!((Boolean) com.tencent.mobileqq.utils.p.a(activity, currentAccountUin, AppConstants.Preferences.KEY_STUDY_MODE_HAS_CHANGE, bool)).booleanValue() && !((Boolean) com.tencent.mobileqq.utils.p.a(activity, this.app.getCurrentAccountUin(), AppConstants.Preferences.KEY_STUDY_MODE_CHANGE_DIALOG_HAS_SHOW, bool)).booleanValue()) {
                    new StudyModeSwitchDialog(activity).show();
                    com.tencent.mobileqq.utils.p.g(BaseApplication.context, this.app.getCurrentAccountUin(), true, AppConstants.Preferences.KEY_STUDY_MODE_CHANGE_DIALOG_HAS_SHOW, Boolean.TRUE);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0016J(\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/studymode/l$a;", "", "", "targetType", "oldType", "", "Aa", "", "isSuccess", "", "message", "j7", "W1", "ed", "isSuc", "param", "C6", "bChangeTheme", "bSwitchElsePref", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "wa", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface a {
        void Aa(int targetType, int oldType);

        void C6(boolean isSuc, @NotNull Object param);

        void W1(int targetType, int oldType);

        void ed(int targetType, int oldType);

        void j7(boolean isSuccess, int targetType, int oldType, @NotNull String message);

        void wa(boolean isSuc, boolean bChangeTheme, boolean bSwitchElsePref, int statusCode);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.studymode.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static final class C8630a {
            public static void a(@NotNull a aVar, boolean z16, @NotNull Object param) {
                Intrinsics.checkNotNullParameter(param, "param");
            }

            public static void b(@NotNull a aVar, boolean z16, boolean z17, boolean z18, int i3) {
            }
        }
    }
}
