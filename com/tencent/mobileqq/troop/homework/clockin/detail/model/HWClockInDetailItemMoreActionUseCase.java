package com.tencent.mobileqq.troop.homework.clockin.detail.model;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.submit.HWSubmitClockInFragment;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R'\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/HWClockInDetailItemMoreActionUseCase;", "", "", "e", "c", "d", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "getClockInId", "clockInId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "items", "", "J", "getDate", "()J", "date", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;J)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInDetailItemMoreActionUseCase {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String clockInId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<BaseItem> items;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long date;

    public HWClockInDetailItemMoreActionUseCase(@NotNull Activity activity, @NotNull String troopUin, @NotNull String clockInId, @NotNull ArrayList<BaseItem> items, long j3) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(clockInId, "clockInId");
        Intrinsics.checkNotNullParameter(items, "items");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, troopUin, clockInId, items, Long.valueOf(j3));
            return;
        }
        this.activity = activity;
        this.troopUin = troopUin;
        this.clockInId = clockInId;
        this.items = items;
        this.date = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        HWSubmitClockInFragment.INSTANCE.a(this.troopUin, this.clockInId, this.date, false, this.items, new WeakReference<>(this.activity.getWindow().getDecorView()));
    }

    private final void e() {
        Dialog createDialog = ActionSheetHelper.createDialog(this.activity, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        final ArrayList arrayList = new ArrayList();
        actionSheet.addButton("\u4fee\u6539\u5185\u5bb9");
        arrayList.add(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailItemMoreActionUseCase$showActionSheet$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInDetailItemMoreActionUseCase.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    HWClockInDetailItemMoreActionUseCase.this.c();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                HWClockInDetailItemMoreActionUseCase.f(ActionSheet.this, arrayList, view, i3);
            }
        });
        actionSheet.addCancelButton("\u53d6\u6d88");
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ActionSheet actionSheet, ArrayList actions, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(actions, "$actions");
        actionSheet.dismiss();
        if (actions.size() > i3) {
            ((Function0) actions.get(i3)).invoke();
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            e();
        }
    }
}
