package gs3;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.common.config.AppSetting;
import com.tencent.minibox.common.exception.AttaAppInfo;
import com.tencent.minibox.common.exception.AttaEventType;
import com.tencent.minibox.common.exception.AttaReportItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.MiniBoxAppInterface;
import com.tencent.qq.minibox.exception.MiniBoxExceptionDetail;
import com.tencent.util.AbiUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IAppRuntime;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rs3.h;
import us3.m;
import us3.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\n\u001a\u00020\tH\u0002J \u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J`\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J%\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010$2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002H\u0002JF\u0010&\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002J\u001e\u0010)\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'J\u0016\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020-2\u0006\u0010\u0003\u001a\u00020\u0002J\"\u00100\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\u0002\u00a8\u00063"}, d2 = {"Lgs3/c;", "", "", "appId", "appVersion", "", "launchTime", "", "o", "Lcom/tencent/minibox/common/exception/a;", "e", "crashTime", ReportConstant.COSTREPORT_PREFIX, "", "isNativeCrashed", "crashType", "crashAddress", "crashStack", "", "nativeSICODE", "processName", "r", "Lcom/tencent/qq/minibox/exception/MiniBoxExceptionDetail;", "detail", DomainData.DOMAIN_NAME, "t", "regexString", HippyControllerProps.STRING, "d", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "Lgs3/d;", TransferConfig.ExtendParamFloats.KEY_RULE, "k", "f", "crashInfo", "dexVersion", "", "g", "l", "Lqs3/a;", "reqCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "i", "Lkotlin/Pair;", "j", "oldDexVersion", "c", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f403270a = new c();

    c() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Boolean d(String regexString, String string) {
        boolean z16;
        boolean isBlank;
        boolean z17 = true;
        if (regexString != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(regexString);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return null;
                }
                Regex regex = new Regex(regexString);
                if (string == null) {
                    string = "";
                }
                if (Regex.find$default(regex, string, 0, 2, null) == null) {
                    z17 = false;
                }
                return Boolean.valueOf(z17);
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final AttaAppInfo e() {
        return new AttaAppInfo(AppSetting.f99551k, ah.F(), ah.t(), ((IAppRuntime) QRoute.api(IAppRuntime.class)).getAccount());
    }

    private final int f(String appId) {
        String c16 = q.f440003a.c(appId);
        QLog.d("MiniBoxExceptionHandler", 4, "getCrashCountFromSP: crashedInfo=" + c16);
        List h16 = h(this, appId, c16, null, 4, null);
        if (h16 != null) {
            return h16.size();
        }
        return 0;
    }

    private final List<Long> g(String appId, String crashInfo, String dexVersion) {
        boolean z16;
        List split$default;
        boolean z17;
        boolean endsWith$default;
        String str;
        boolean isBlank;
        Long longOrNull;
        boolean z18 = true;
        if (crashInfo != null && crashInfo.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) crashInfo, new String[]{";"}, false, 0, 6, (Object) null);
            if (split$default.isEmpty()) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb5 = new StringBuilder();
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
                if (longOrNull != null && currentTimeMillis - longOrNull.longValue() < 3600000) {
                    arrayList.add(longOrNull);
                    sb5.append(longOrNull.longValue());
                    sb5.append(";");
                }
            }
            if (sb5.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) sb5, (CharSequence) ";", false, 2, (Object) null);
                if (endsWith$default) {
                    String savedInfo = sb5.substring(0, sb5.length() - 1);
                    if (dexVersion != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(dexVersion);
                        if (!isBlank) {
                            z18 = false;
                        }
                    }
                    if (!z18) {
                        str = "dex_" + appId;
                        savedInfo = dexVersion + util.base64_pad_url + savedInfo;
                    } else {
                        str = appId;
                    }
                    q qVar = q.f440003a;
                    Intrinsics.checkNotNullExpressionValue(savedInfo, "savedInfo");
                    qVar.n(str, savedInfo);
                }
            }
            return arrayList;
        }
        return null;
    }

    static /* synthetic */ List h(c cVar, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = null;
        }
        return cVar.g(str, str2, str3);
    }

    private final boolean k(MiniBoxExceptionReportRule rule, MiniBoxExceptionDetail detail) {
        List listOfNotNull;
        boolean z16;
        try {
            listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new Boolean[]{d(rule.getAppIdRule(), detail.getAppId()), d(rule.getCrashTypeRule(), detail.getCrashType()), d(rule.getCrashAddressRule(), detail.getCrashAddress()), d(rule.getCrashStackRule(), detail.getCrashStack()), d(rule.getProcessNameRule(), detail.getProcessName()), d(rule.getDexVersionRule(), detail.getDexVersion())});
            Iterator it = listOfNotNull.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    boolean booleanValue = ((Boolean) it.next()).booleanValue();
                    if (((Boolean) next).booleanValue() && booleanValue) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    next = Boolean.valueOf(z16);
                }
                return ((Boolean) next).booleanValue();
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        } catch (Throwable th5) {
            QLog.e("MiniBoxExceptionHandler", 1, "needReportCrashDetail regex find throw:", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(AttaReportItem reportItem) {
        Intrinsics.checkNotNullParameter(reportItem, "$reportItem");
        com.tencent.minibox.common.exception.b.f151630a.c(reportItem, f403270a.e());
    }

    private final void n(MiniBoxExceptionDetail detail) {
        QLog.e("MiniBoxExceptionHandler", 1, "start reportCrashDetail " + detail.getCrashAddress());
        t(detail);
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_crash_detail", detail);
        Unit unit = Unit.INSTANCE;
        qIPCClientHelper.callServer("minibox_qipc_module", "action_va_not_available", bundle);
        QLog.e("MiniBoxExceptionHandler", 1, "end reportCrashDetail " + detail.getCrashAddress());
    }

    @JvmStatic
    public static final void o(@NotNull String appId, @NotNull String appVersion, long launchTime) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        m mVar = m.f439991a;
        mVar.o("last_app_id", appId);
        mVar.o(SPKey.KEY_LAST_APP_VERSION, appVersion);
        mVar.n("last_launch_time", launchTime);
        final AttaReportItem attaReportItem = new AttaReportItem(AttaEventType.LAUNCH, appId, appVersion, launchTime, launchTime, null, 32, null);
        ThreadManagerV2.excute(new Runnable() { // from class: gs3.a
            @Override // java.lang.Runnable
            public final void run() {
                c.p(AttaReportItem.this);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AttaReportItem reportItem) {
        Intrinsics.checkNotNullParameter(reportItem, "$reportItem");
        com.tencent.minibox.common.exception.b.f151630a.c(reportItem, f403270a.e());
    }

    private final void r(String appId, String appVersion, long launchTime, boolean isNativeCrashed, String crashType, String crashAddress, String crashStack, int nativeSICODE, long crashTime, String processName) {
        boolean isBlank;
        MiniBoxExceptionReportRule miniBoxExceptionReportRule;
        MiniBoxAppInterface miniBoxAppInterface;
        String str = "";
        String d16 = q.f440003a.d();
        isBlank = StringsKt__StringsJVMKt.isBlank(d16);
        if (isBlank) {
            miniBoxExceptionReportRule = new MiniBoxExceptionReportRule(null, null, null, null, null, null, 0, 127, null);
        } else {
            try {
                miniBoxExceptionReportRule = (MiniBoxExceptionReportRule) new Gson().fromJson(d16, MiniBoxExceptionReportRule.class);
            } catch (Throwable th5) {
                QLog.e("MiniBoxExceptionHandler", 1, "format rule failed", th5);
                miniBoxExceptionReportRule = new MiniBoxExceptionReportRule(null, null, null, null, null, null, 0, 127, null);
            }
        }
        MiniBoxExceptionReportRule rule = miniBoxExceptionReportRule;
        QLog.i("MiniBoxExceptionHandler", 2, "saveAndReportCrashDetail rule: " + rule);
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof MiniBoxAppInterface) {
                miniBoxAppInterface = (MiniBoxAppInterface) peekAppRuntime;
            } else {
                miniBoxAppInterface = null;
            }
            if (miniBoxAppInterface != null) {
                String g16 = miniBoxAppInterface.g();
                if (g16 != null) {
                    str = g16;
                }
            }
        } catch (Throwable th6) {
            QLog.w("MiniBoxExceptionHandler", 1, "getDexVersion throw:", th6);
        }
        MiniBoxExceptionDetail miniBoxExceptionDetail = new MiniBoxExceptionDetail(appId, appVersion, launchTime, isNativeCrashed, crashType, crashAddress, crashStack, nativeSICODE, crashTime, processName, str, rule.getStackReportMaxLine());
        Intrinsics.checkNotNullExpressionValue(rule, "rule");
        if (!k(rule, miniBoxExceptionDetail)) {
            QLog.w("MiniBoxExceptionHandler", 1, "no need to report detail, processName:" + processName + ", address:" + crashAddress);
            return;
        }
        n(miniBoxExceptionDetail);
    }

    private final void s(String appId, long launchTime, long crashTime) {
        boolean z16;
        List split$default;
        Long longOrNull;
        if (crashTime - launchTime > 60000) {
            return;
        }
        String valueOf = String.valueOf(crashTime);
        String k3 = m.f439991a.k(appId);
        if (k3.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(String.valueOf(crashTime));
            long currentTimeMillis = System.currentTimeMillis();
            split$default = StringsKt__StringsKt.split$default((CharSequence) k3, new String[]{";"}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
                if (longOrNull != null && currentTimeMillis - longOrNull.longValue() < 3600000) {
                    sb5.append(";");
                    sb5.append(longOrNull.longValue());
                }
            }
            valueOf = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(valueOf, "strBuilder.toString()");
        }
        QLog.d("MiniBoxExceptionHandler", 4, "saveCrash2SP: saveCrashInfo=" + valueOf);
        q.f440003a.n(appId, valueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x008e, code lost:
    
        r6 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r11, new java.lang.String[]{";"}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void t(MiniBoxExceptionDetail detail) {
        boolean z16;
        List split$default;
        Object firstOrNull;
        Object lastOrNull;
        List split$default2;
        Long longOrNull;
        if (detail.getAppId() == null) {
            return;
        }
        String str = detail.getDexVersion() + util.base64_pad_url + detail.getCrashTime();
        String str2 = "dex_" + detail.getAppId();
        String c16 = q.f440003a.c(str2);
        if (c16.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) c16, new String[]{"_"}, false, 0, 6, (Object) null);
            if (split$default.size() == 2) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) split$default);
                if (Intrinsics.areEqual((String) firstOrNull, detail.getDexVersion())) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(String.valueOf(detail.getCrashTime()));
                    long currentTimeMillis = System.currentTimeMillis();
                    lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) split$default);
                    String str3 = (String) lastOrNull;
                    if (str3 != null && split$default2 != null) {
                        Iterator it = split$default2.iterator();
                        while (it.hasNext()) {
                            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
                            if (longOrNull != null && currentTimeMillis - longOrNull.longValue() < 3600000) {
                                sb5.append(";");
                                sb5.append(longOrNull.longValue());
                            }
                        }
                    }
                    str = detail.getDexVersion() + util.base64_pad_url + ((Object) sb5);
                }
            }
        }
        QLog.d("MiniBoxExceptionHandler", 1, "saveDexCrash2MMKV: saveCrashInfo=" + str);
        q.f440003a.n(str2, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(@Nullable Context context, @NotNull String appId, @Nullable String oldDexVersion) {
        String str;
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (context == null) {
            QLog.e("MiniBoxExceptionHandler", 1, "checkAndClearDexCrashRecord context invalid");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    QLog.e("MiniBoxExceptionHandler", 1, "checkAndClearDexCrashRecord uin invalid");
                    return;
                }
                String b16 = o51.a.f422110b.b(context, str, oldDexVersion, true);
                if (!Intrinsics.areEqual(b16, oldDexVersion)) {
                    QLog.i("MiniBoxExceptionHandler", 1, "config dexVersion:" + b16 + " oldDexVersion:" + oldDexVersion + " not match, remove dex crash info");
                    q qVar = q.f440003a;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("dex_");
                    sb5.append(appId);
                    qVar.i(sb5.toString());
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final boolean i(@NotNull Context context, @NotNull String appId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (!AbiUtil.isArm64Runtime(context)) {
            QLog.i("MiniBoxExceptionHandler", 1, "isBlockApp: true, do not support by 32bit qq.");
            return true;
        }
        int f16 = f(appId);
        QLog.i("MiniBoxExceptionHandler", 1, "isBlockApp: appId=" + appId + ", crashCount=" + f16);
        if (f16 >= 3) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Pair<Boolean, String> j(@NotNull String appId) {
        boolean isBlank;
        List split$default;
        Object firstOrNull;
        Object lastOrNull;
        int i3;
        Object firstOrNull2;
        Intrinsics.checkNotNullParameter(appId, "appId");
        String str = "dex_" + appId;
        q qVar = q.f440003a;
        String c16 = qVar.c(str);
        QLog.d("MiniBoxExceptionHandler", 2, "getCrashCountFromSP: crashedInfo=" + c16);
        isBlank = StringsKt__StringsJVMKt.isBlank(c16);
        if (!isBlank) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) c16, new String[]{"_"}, false, 0, 6, (Object) null);
            boolean z16 = true;
            if (split$default.size() == 2) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) split$default);
                String str2 = (String) firstOrNull;
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) split$default);
                List<Long> g16 = g(appId, (String) lastOrNull, str2);
                if (g16 != null) {
                    i3 = g16.size();
                } else {
                    i3 = 0;
                }
                QLog.i("MiniBoxExceptionHandler", 1, "isDexBlockApp: crashCount=" + i3 + ", dex ver:" + str2);
                if (i3 < 3) {
                    z16 = false;
                }
                Boolean valueOf = Boolean.valueOf(z16);
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) split$default);
                return TuplesKt.to(valueOf, firstOrNull2);
            }
            QLog.e("MiniBoxExceptionHandler", 1, "isDexBlockApp crashedInfo invalid, " + c16);
            qVar.i(str);
            return TuplesKt.to(Boolean.FALSE, null);
        }
        return TuplesKt.to(Boolean.FALSE, null);
    }

    public final void l(boolean isNativeCrashed, @Nullable String crashType, @Nullable String crashAddress, @Nullable String crashStack, int nativeSICODE, long crashTime, @Nullable String processName) {
        boolean z16;
        m mVar = m.f439991a;
        String k3 = mVar.k("last_app_id");
        if (k3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("MiniBoxExceptionHandler", 1, "reportCrash: last appId is null");
            return;
        }
        String k16 = mVar.k(SPKey.KEY_LAST_APP_VERSION);
        long i3 = mVar.i("last_launch_time");
        final AttaReportItem attaReportItem = new AttaReportItem(AttaEventType.CRASH, k3, k16, i3, crashTime, null, 32, null);
        ThreadManagerV2.excute(new Runnable() { // from class: gs3.b
            @Override // java.lang.Runnable
            public final void run() {
                c.m(AttaReportItem.this);
            }
        }, 128, null, false);
        s(k3, i3, crashTime);
        r(k3, k16, i3, isNativeCrashed, crashType, crashAddress, crashStack, nativeSICODE, crashTime, processName);
    }

    public final void q(@NotNull String appId, @NotNull String appVersion, @NotNull qs3.a reqCallback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(reqCallback, "reqCallback");
        qs3.c.f429464a.d(new h(appId, appVersion), reqCallback);
    }
}
