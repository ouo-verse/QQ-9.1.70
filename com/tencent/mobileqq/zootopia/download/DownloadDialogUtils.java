package com.tencent.mobileqq.zootopia.download;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Looper;
import android.view.View;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.api.ICommonApi;
import com.tencent.mobileqq.zootopia.api.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J.\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J.\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J2\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00042\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000eJ\"\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0012JH\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00172\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0012JH\u0010\u001b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00172\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b0\u0012J\u001a\u0010\u001e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ=\u0010!\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0 \u00a2\u0006\u0004\b!\u0010\"J\u0014\u0010$\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0 J8\u0010&\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0012R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/DownloadDialogUtils;", "", "Landroid/view/View;", "view", "", AdMetricTag.EVENT_NAME, "", "reportMap", "", "r", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "context", "content", "Lkotlin/Function2;", "", "callback", "f", "Lkotlin/Function1;", tl.h.F, "modName", "", "cacheSize", "", "j", "totalSize", "", "i", "Landroid/content/DialogInterface$OnDismissListener;", "onDismissListener", DomainData.DOMAIN_NAME, "contentResId", "Lkotlin/Function0;", "p", "(Landroid/content/Context;Ljava/lang/Integer;Landroid/content/DialogInterface$OnDismissListener;Lkotlin/jvm/functions/Function0;)V", "runnable", "t", "hintTxt", "k", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "b", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "dtViewReporter", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class DownloadDialogUtils {

    /* renamed from: a */
    public static final DownloadDialogUtils f327978a = new DownloadDialogUtils();

    /* renamed from: b, reason: from kotlin metadata */
    private static final ZplanViewReportHelper dtViewReporter = new ZplanViewReportHelper();

    DownloadDialogUtils() {
    }

    public static final void l(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.TRUE);
    }

    public static final void m(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.FALSE);
    }

    public static final void u(Function0 runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        try {
            runnable.invoke();
        } catch (Throwable th5) {
            QLog.e("DownloadDialogUtils", 1, "showDialog error", th5);
        }
    }

    public final void f(Context context, String content, Function2<? super Boolean, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(callback, "callback");
        t(new DownloadDialogUtils$askNeed4gDownload$1(context, content, callback));
    }

    public final void h(Context context, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        t(new DownloadDialogUtils$askNeedCancelDownload$1(context, callback));
    }

    public final void i(Context context, long totalSize, long cacheSize, Map<String, String> reportMap, Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        Intrinsics.checkNotNullParameter(callback, "callback");
        t(new DownloadDialogUtils$askNeedDeleteDownload$1(context, totalSize, cacheSize, callback, reportMap));
    }

    public final void j(Context context, String modName, long cacheSize, Map<String, String> reportMap, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(modName, "modName");
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        Intrinsics.checkNotNullParameter(callback, "callback");
        t(new DownloadDialogUtils$askNeedDeleteModCacheOnly$1(context, modName, cacheSize, callback, reportMap));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(Context context, String modName, String hintTxt, final Function1<? super Boolean, Unit> callback) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Resources resources = context.getResources();
        if (hintTxt != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(hintTxt);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    hintTxt = resources.getString(R.string.xid, modName);
                }
                String str = hintTxt;
                Intrinsics.checkNotNullExpressionValue(str, "if(hintTxt.isNullOrBlank\u2026ame)\n        else hintTxt");
                com.tencent.mobileqq.zootopia.api.f dialogHandler = ((ICommonApi) QRoute.api(ICommonApi.class)).getDialogHandler();
                String string = resources.getString(R.string.f169768xi0);
                Intrinsics.checkNotNullExpressionValue(string, "res.getString(com.tencen\u2026R.string.zootopia_cancel)");
                String string2 = resources.getString(R.string.xkd);
                Intrinsics.checkNotNullExpressionValue(string2, "res.getString(com.tencen\u2026l.R.string.zootopia_sure)");
                f.a.a(dialogHandler, null, str, string, string2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.d
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        DownloadDialogUtils.l(Function1.this, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.e
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        DownloadDialogUtils.m(Function1.this, dialogInterface, i3);
                    }
                }, null, 64, null);
            }
        }
        z16 = true;
        if (z16) {
        }
        String str2 = hintTxt;
        Intrinsics.checkNotNullExpressionValue(str2, "if(hintTxt.isNullOrBlank\u2026ame)\n        else hintTxt");
        com.tencent.mobileqq.zootopia.api.f dialogHandler2 = ((ICommonApi) QRoute.api(ICommonApi.class)).getDialogHandler();
        String string3 = resources.getString(R.string.f169768xi0);
        Intrinsics.checkNotNullExpressionValue(string3, "res.getString(com.tencen\u2026R.string.zootopia_cancel)");
        String string22 = resources.getString(R.string.xkd);
        Intrinsics.checkNotNullExpressionValue(string22, "res.getString(com.tencen\u2026l.R.string.zootopia_sure)");
        f.a.a(dialogHandler2, null, str2, string3, string22, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DownloadDialogUtils.l(Function1.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DownloadDialogUtils.m(Function1.this, dialogInterface, i3);
            }
        }, null, 64, null);
    }

    public final void n(Context context, DialogInterface.OnDismissListener onDismissListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        t(new DownloadDialogUtils$notifyDownloadMemoryLacking$1(context, onDismissListener));
    }

    public final void p(Context context, Integer contentResId, DialogInterface.OnDismissListener onDismissListener, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        t(new DownloadDialogUtils$notifyNetError$2(context, contentResId, onDismissListener, callback));
    }

    public final void t(final Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            try {
                runnable.invoke();
                return;
            } catch (Throwable th5) {
                QLog.e("DownloadDialogUtils", 1, "showDialog error", th5);
                return;
            }
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.f
            @Override // java.lang.Runnable
            public final void run() {
                DownloadDialogUtils.u(Function0.this);
            }
        });
    }

    public final void r(View view, String r36, Map<String, String> reportMap) {
        if (view == null) {
            return;
        }
        dtViewReporter.e(view, r36, reportMap);
    }

    public final void s(View view, String str, Map<String, String> map) {
        if (view == null) {
            return;
        }
        dtViewReporter.g(view, str, (r16 & 4) != 0 ? null : map, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    public static /* synthetic */ void g(DownloadDialogUtils downloadDialogUtils, Context context, String str, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        downloadDialogUtils.f(context, str, function2);
    }

    public static /* synthetic */ void o(DownloadDialogUtils downloadDialogUtils, Context context, DialogInterface.OnDismissListener onDismissListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            onDismissListener = null;
        }
        downloadDialogUtils.n(context, onDismissListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void q(DownloadDialogUtils downloadDialogUtils, Context context, Integer num, DialogInterface.OnDismissListener onDismissListener, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        if ((i3 & 4) != 0) {
            onDismissListener = null;
        }
        if ((i3 & 8) != 0) {
            function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.DownloadDialogUtils$notifyNetError$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        downloadDialogUtils.p(context, num, onDismissListener, function0);
    }
}
