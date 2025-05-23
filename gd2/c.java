package gd2;

import android.content.DialogInterface;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.tool.AppInfoUtil;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lgd2/c;", "", "", "stage", "zipPath", "", "f", "", "c", "d", "status", "e", "", "b", "[Ljava/lang/String;", "dialogStages", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f401962a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] dialogStages = {"com.tencent.biz.qqcircle"};

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(QQCustomDialog dialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        f401962a.e(false);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(QQCustomDialog dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final boolean c(@NotNull String stage) {
        boolean z16;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(stage, "stage");
        if (!d() || AppSetting.isUiTest() || !AppInfoUtil.f258158a.a()) {
            return false;
        }
        String[] strArr = dialogStages;
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(stage, strArr[i3], false, 2, null);
                if (startsWith$default) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    public final boolean d() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("rmonitor_leak_mem_dialog_switch", true);
    }

    public final void e(boolean status) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("rmonitor_leak_mem_dialog_switch", status);
    }

    public final void f(@NotNull String stage, @NotNull String zipPath) {
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        final QQCustomDialog qQCustomDialog = new QQCustomDialog(MobileQQ.sMobileQQ.getResumeActivity(), R.style.aym);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setTitle("\u5185\u5b58\u6cc4\u6f0f\u63d0\u9192");
        qQCustomDialog.getMessageTextView().setText(stage + " \u573a\u666f\u53d1\u751f\u4e86\u5185\u5b58\u6cc4\u6f0f\uff0c\u7a0d\u540e\u53ef\u5230 RMonitor \u5e73\u53f0\u8fdb\u884c\u8fc7\u6ee4\u67e5\u8be2\n\u82e5\u8fd8\u672a\u4e0a\u62a5\u53ef\u5728\u672c\u5730\u7684" + zipPath + " \u83b7\u53d6 hprof \u8fdb\u884c\u5206\u6790");
        qQCustomDialog.getBtnLeft().setText("\u4e0d\u518d\u63d0\u9192");
        qQCustomDialog.getBtnLeft().setVisibility(0);
        qQCustomDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: gd2.a
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                c.g(QQCustomDialog.this, dialogInterface);
            }
        });
        qQCustomDialog.getBtnight().setText("\u4e86\u89e3");
        qQCustomDialog.getBtnight().setVisibility(0);
        qQCustomDialog.getBtnight().setOnClickListener(new View.OnClickListener() { // from class: gd2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.h(QQCustomDialog.this, view);
            }
        });
        qQCustomDialog.show();
    }
}
