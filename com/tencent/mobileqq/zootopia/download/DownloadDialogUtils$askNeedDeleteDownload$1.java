package com.tencent.mobileqq.zootopia.download;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
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
public final class DownloadDialogUtils$askNeedDeleteDownload$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $cacheSize;
    final /* synthetic */ Function1<Integer, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ Map<String, String> $reportMap;
    final /* synthetic */ long $totalSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadDialogUtils$askNeedDeleteDownload$1(Context context, long j3, long j16, Function1<? super Integer, Unit> function1, Map<String, String> map) {
        super(0);
        this.$context = context;
        this.$totalSize = j3;
        this.$cacheSize = j16;
        this.$callback = function1;
        this.$reportMap = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Map reportMap, Function1 callback, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 == 0) {
            DownloadDialogUtils.f327978a.r(view, "em_zplan_select_clear_win_all", reportMap);
            callback.invoke(Integer.valueOf(i3));
            actionSheet.dismiss();
        } else {
            if (i3 != 1) {
                return;
            }
            DownloadDialogUtils.f327978a.r(view, "em_zplan_select_clear_win_cache", reportMap);
            callback.invoke(Integer.valueOf(i3));
            actionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Map reportMap, Function1 callback, ActionSheet actionSheet, View view) {
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        DownloadDialogUtils.f327978a.r(view, "em_zplan_select_clear_win_cancel", reportMap);
        callback.invoke(100);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ActionSheet actionSheet, Map reportMap, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        DownloadDialogUtils downloadDialogUtils = DownloadDialogUtils.f327978a;
        ActionSheet.ItemViewHolder itemViewById = actionSheet.getItemViewById(0);
        downloadDialogUtils.s(itemViewById != null ? itemViewById.titleTv : null, "em_zplan_select_clear_win_all", reportMap);
        ActionSheet.ItemViewHolder itemViewById2 = actionSheet.getItemViewById(1);
        downloadDialogUtils.s(itemViewById2 != null ? itemViewById2.titleTv : null, "em_zplan_select_clear_win_cache", reportMap);
        downloadDialogUtils.s(actionSheet.mContentContainer.findViewById(R.id.action_sheet_btnCancel), "em_zplan_select_clear_win_cancel", reportMap);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Context context = this.$context;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if ((activity == null || activity.isFinishing()) ? false : true) {
            Dialog createDialog = ActionSheetHelper.createDialog(this.$context, null);
            Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
            final ActionSheet actionSheet = (ActionSheet) createDialog;
            Resources resources = ((Activity) this.$context).getResources();
            actionSheet.setMainTitle(R.string.xim);
            com.tencent.mobileqq.zootopia.space.j jVar = com.tencent.mobileqq.zootopia.space.j.f329276a;
            actionSheet.addButton(resources.getString(R.string.xij, jVar.e(this.$totalSize)));
            actionSheet.addButton(resources.getString(R.string.xil, jVar.e(this.$cacheSize)));
            actionSheet.addCancelButton(R.string.xik);
            final Map<String, String> map = this.$reportMap;
            final Function1<Integer, Unit> function1 = this.$callback;
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.zootopia.download.m
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    DownloadDialogUtils$askNeedDeleteDownload$1.d(map, function1, actionSheet, view, i3);
                }
            });
            final Map<String, String> map2 = this.$reportMap;
            final Function1<Integer, Unit> function12 = this.$callback;
            actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadDialogUtils$askNeedDeleteDownload$1.e(map2, function12, actionSheet, view);
                }
            });
            final Map<String, String> map3 = this.$reportMap;
            actionSheet.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.zootopia.download.o
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    DownloadDialogUtils$askNeedDeleteDownload$1.f(ActionSheet.this, map3, dialogInterface);
                }
            });
            actionSheet.show();
            return;
        }
        this.$callback.invoke(100);
    }
}
