package com.tencent.mobileqq.troop.troopmemberlist;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 JP\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J9\u0010\u0018\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00050\u0005 \u0017*\u0012\u0012\u000e\b\u0001\u0012\n \u0017*\u0004\u0018\u00010\u00050\u00050\u00040\u00042\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0018\u0010\u0019J9\u0010\u001a\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00050\u0005 \u0017*\u0012\u0012\u000e\b\u0001\u0012\n \u0017*\u0004\u0018\u00010\u00050\u00050\u00040\u00042\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001a\u0010\u0019J\u0016\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0012J\u0016\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0012\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmemberlist/g;", "", "Landroid/content/Context;", "context", "", "", "sortActions", "", "sortIndex", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "onItemClickAction", "Lcom/tencent/widget/ActionSheet;", "b", "(Landroid/content/Context;[Ljava/lang/String;ILkotlin/jvm/functions/Function1;)Lcom/tencent/widget/ActionSheet;", "", "startTimeSec", "d", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "kotlin.jvm.PlatformType", "e", "(Lcom/tencent/mobileqq/app/QBaseActivity;)[Ljava/lang/String;", "g", "lastActiveTime", h.F, "addTroopTime", "f", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f300632a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58576);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f300632a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final ActionSheet b(@NotNull Context context, @NotNull String[] sortActions, int sortIndex, @NotNull final Function1<? super Integer, Unit> onItemClickAction) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sortActions, "sortActions");
        Intrinsics.checkNotNullParameter(onItemClickAction, "onItemClickAction");
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        int length = sortActions.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            String str = sortActions[i3];
            int i17 = i16 + 1;
            if (i16 == sortIndex) {
                z16 = true;
            } else {
                z16 = false;
            }
            actionSheet.addRadioButton(str, z16);
            i3++;
            i16 = i17;
        }
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.troopmemberlist.f
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i18) {
                g.c(Function1.this, actionSheet, view, i18);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        return actionSheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 onItemClickAction, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(onItemClickAction, "$onItemClickAction");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        onItemClickAction.invoke(Integer.valueOf(i3));
        actionSheet.dismiss();
    }

    private final long d(long startTimeSec) {
        long serverTime = NetConnInfoCenter.getServerTime() - startTimeSec;
        long j3 = 60;
        return ((serverTime / j3) / j3) / 24;
    }

    @NotNull
    public final String[] e(@NotNull QBaseActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        String[] stringArray = activity.getResources().getStringArray(R.array.f155251c2);
        Intrinsics.checkNotNullExpressionValue(stringArray, "activity.resources.getSt\u2026ber_list_active_date_seg)");
        return stringArray;
    }

    @NotNull
    public final String f(@NotNull QBaseActivity activity, long addTroopTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, activity, Long.valueOf(addTroopTime));
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        String[] g16 = g(activity);
        if (addTroopTime <= 0) {
            addTroopTime = 1338480000;
        }
        long d16 = d(addTroopTime);
        if (d16 <= 0) {
            return g16[0];
        }
        if (d16 <= 7) {
            return g16[1];
        }
        if (d16 <= 30) {
            return g16[2];
        }
        if (d16 <= 90) {
            return g16[3];
        }
        if (d16 <= 180) {
            return g16[4];
        }
        if (d16 <= 365) {
            return g16[5];
        }
        if (d16 <= 730) {
            return g16[6];
        }
        if (d16 <= QzoneConfig.DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS) {
            return g16[7];
        }
        if (d16 <= 1825) {
            return g16[8];
        }
        if (d16 <= 2555) {
            return g16[9];
        }
        if (d16 <= 3650) {
            return g16[10];
        }
        return g16[11];
    }

    @NotNull
    public final String[] g(@NotNull QBaseActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        String[] stringArray = activity.getResources().getStringArray(R.array.f155252c3);
        Intrinsics.checkNotNullExpressionValue(stringArray, "activity.resources.getSt\u2026member_list_add_date_seg)");
        return stringArray;
    }

    @NotNull
    public final String h(@NotNull QBaseActivity activity, long lastActiveTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, activity, Long.valueOf(lastActiveTime));
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        String[] e16 = e(activity);
        Calendar.getInstance().setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000);
        if (lastActiveTime == 0) {
            return e16[7];
        }
        long d16 = d(lastActiveTime);
        if (d16 <= 0) {
            return e16[0];
        }
        if (d16 <= 7) {
            return e16[1];
        }
        if (d16 <= 30) {
            return e16[2];
        }
        if (d16 <= 90) {
            return e16[3];
        }
        if (d16 <= 180) {
            return e16[4];
        }
        if (d16 <= 365) {
            return e16[5];
        }
        return e16[6];
    }
}
