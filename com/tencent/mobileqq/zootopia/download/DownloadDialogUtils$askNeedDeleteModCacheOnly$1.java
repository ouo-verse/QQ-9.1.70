package com.tencent.mobileqq.zootopia.download;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class DownloadDialogUtils$askNeedDeleteModCacheOnly$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $cacheSize;
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $modName;
    final /* synthetic */ Map<String, String> $reportMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadDialogUtils$askNeedDeleteModCacheOnly$1(Context context, String str, long j3, Function1<? super Boolean, Unit> function1, Map<String, String> map) {
        super(0);
        this.$context = context;
        this.$modName = str;
        this.$cacheSize = j3;
        this.$callback = function1;
        this.$reportMap = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Map reportMap, Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        DownloadDialogUtils downloadDialogUtils = DownloadDialogUtils.f327978a;
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
        downloadDialogUtils.r(((QQCustomDialog) dialogInterface).getBtnight(), "em_zplan_clear_cache_win_confirm", reportMap);
        callback.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Map reportMap, Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        DownloadDialogUtils downloadDialogUtils = DownloadDialogUtils.f327978a;
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
        downloadDialogUtils.r(((QQCustomDialog) dialogInterface).getBtnLeft(), "em_zplan_clear_cache_win_cancel", reportMap);
        callback.invoke(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(QQCustomDialog qQCustomDialog, Map reportMap, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        DownloadDialogUtils downloadDialogUtils = DownloadDialogUtils.f327978a;
        downloadDialogUtils.s(qQCustomDialog.getBtnight(), "em_zplan_clear_cache_win_confirm", reportMap);
        downloadDialogUtils.s(qQCustomDialog.getBtnLeft(), "em_zplan_clear_cache_win_cancel", reportMap);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String str;
        Resources resources = this.$context.getResources();
        if (TextUtils.isEmpty(this.$modName)) {
            str = "";
        } else {
            str = "\u3010" + this.$modName + "\u3011";
        }
        String str2 = str + resources.getString(R.string.xig, com.tencent.mobileqq.zootopia.space.j.f329276a.e(this.$cacheSize));
        Context context = this.$context;
        String string = resources.getString(R.string.xih);
        String string2 = resources.getString(R.string.f169768xi0);
        String string3 = resources.getString(R.string.xkd);
        final Map<String, String> map = this.$reportMap;
        final Function1<Boolean, Unit> function1 = this.$callback;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DownloadDialogUtils$askNeedDeleteModCacheOnly$1.d(map, function1, dialogInterface, i3);
            }
        };
        final Map<String, String> map2 = this.$reportMap;
        final Function1<Boolean, Unit> function12 = this.$callback;
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, string, str2, string2, string3, onClickListener, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DownloadDialogUtils$askNeedDeleteModCacheOnly$1.e(map2, function12, dialogInterface, i3);
            }
        });
        final Map<String, String> map3 = this.$reportMap;
        createCustomDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.zootopia.download.r
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DownloadDialogUtils$askNeedDeleteModCacheOnly$1.f(QQCustomDialog.this, map3, dialogInterface);
            }
        });
        Context context2 = this.$context;
        Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
        if ((activity == null || activity.isFinishing()) ? false : true) {
            createCustomDialog.show();
        } else {
            this.$callback.invoke(Boolean.FALSE);
        }
    }
}
