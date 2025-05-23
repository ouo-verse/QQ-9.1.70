package com.tencent.mobileqq.zootopia.download;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class DownloadDialogUtils$askNeed4gDownload$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2<Boolean, Boolean, Unit> $callback;
    final /* synthetic */ String $content;
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadDialogUtils$askNeed4gDownload$1(Context context, String str, Function2<? super Boolean, ? super Boolean, Unit> function2) {
        super(0);
        this.$context = context;
        this.$content = str;
        this.$callback = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(boolean z16, Map reportMap, Function2 callback, DialogInterface dialogInterface, int i3) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16) {
            DownloadDialogUtils downloadDialogUtils = DownloadDialogUtils.f327978a;
            Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
            downloadDialogUtils.r(((QQCustomDialog) dialogInterface).getBtnight(), "em_zplan_floating_pop_download", reportMap);
        }
        mb4.c cVar = mb4.c.f416532a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, "1"));
        mb4.c.c(cVar, "e_zplan_download_mobile_remind_click", hashMapOf, false, 4, null);
        Boolean bool = Boolean.TRUE;
        QQCustomDialog qQCustomDialog = dialogInterface instanceof QQCustomDialog ? (QQCustomDialog) dialogInterface : null;
        callback.invoke(bool, Boolean.valueOf(qQCustomDialog != null ? qQCustomDialog.getCheckBoxState() : false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(boolean z16, Map reportMap, Function2 callback, DialogInterface dialogInterface, int i3) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16) {
            DownloadDialogUtils downloadDialogUtils = DownloadDialogUtils.f327978a;
            Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
            downloadDialogUtils.r(((QQCustomDialog) dialogInterface).getBtnLeft(), "em_zplan_floating_pop_wifi_download", reportMap);
        }
        mb4.c cVar = mb4.c.f416532a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, "0"));
        mb4.c.c(cVar, "e_zplan_download_mobile_remind_click", hashMapOf, false, 4, null);
        Boolean bool = Boolean.FALSE;
        QQCustomDialog qQCustomDialog = dialogInterface instanceof QQCustomDialog ? (QQCustomDialog) dialogInterface : null;
        callback.invoke(bool, Boolean.valueOf(qQCustomDialog != null ? qQCustomDialog.getCheckBoxState() : false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(boolean z16, QQCustomDialog qQCustomDialog, Map reportMap, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        if (z16) {
            DownloadDialogUtils downloadDialogUtils = DownloadDialogUtils.f327978a;
            downloadDialogUtils.s(qQCustomDialog.getRootView(), "em_zplan_floating_wifi_pop", reportMap);
            downloadDialogUtils.s(qQCustomDialog.getBtnight(), "em_zplan_floating_pop_download", reportMap);
            downloadDialogUtils.s(qQCustomDialog.getBtnLeft(), "em_zplan_floating_pop_wifi_download", reportMap);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Resources resources = this.$context.getResources();
        String str = this.$content;
        if (str.length() == 0) {
            str = resources.getString(R.string.xia);
            Intrinsics.checkNotNullExpressionValue(str, "res.getString(R.string.z\u2026_download_ask_4g_content)");
        }
        String str2 = str;
        final boolean isFloat = ((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).isFloat();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        Context context = this.$context;
        String string = resources.getString(R.string.xic);
        String string2 = resources.getString(R.string.f169774xj1);
        String string3 = resources.getString(R.string.f169768xi0);
        String string4 = resources.getString(R.string.xis);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DownloadDialogUtils$askNeed4gDownload$1.e(dialogInterface, i3);
            }
        };
        final Function2<Boolean, Boolean, Unit> function2 = this.$callback;
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DownloadDialogUtils$askNeed4gDownload$1.f(isFloat, linkedHashMap, function2, dialogInterface, i3);
            }
        };
        final Function2<Boolean, Boolean, Unit> function22 = this.$callback;
        final QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(context, 0, string, str2, string2, false, string3, string4, onClickListener, onClickListener2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DownloadDialogUtils$askNeed4gDownload$1.g(isFloat, linkedHashMap, function22, dialogInterface, i3);
            }
        });
        View findViewById = createDialogWithCheckBox.findViewById(R.id.e2z);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.gravity = 16;
        }
        findViewById.setLayoutParams(layoutParams);
        createDialogWithCheckBox.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.zootopia.download.j
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DownloadDialogUtils$askNeed4gDownload$1.h(isFloat, createDialogWithCheckBox, linkedHashMap, dialogInterface);
            }
        });
        createDialogWithCheckBox.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(DialogInterface dialogInterface, int i3) {
    }
}
