package com.tencent.mobileqq.troop.report.addfriend;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.ActionSheet;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007JF\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042,\b\u0002\u0010\r\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bj\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/report/addfriend/a;", "", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "", "troopUin", "", "d", "Landroid/view/View;", "view", "elementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "a", "c", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f298280a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54776);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f298280a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(View view, String elementId, HashMap<String, Object> params) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.reportEvent("dt_imp", view, params);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void b(a aVar, View view, String str, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            hashMap = null;
        }
        aVar.a(view, str, hashMap);
    }

    @JvmStatic
    public static final void c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.reportEvent("dt_clck", view, null);
    }

    @JvmStatic
    public static final void d(@NotNull ActionSheet actionSheet, @NotNull String troopUin) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(actionSheet, "actionSheet");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        VideoReport.setPageParams(actionSheet.getRootView(), "group_id", troopUin);
        VideoReport.setPageId(actionSheet.getRootView(), "pg_group_member_list");
        View findViewById = actionSheet.findViewById(R.id.f163931ct);
        if (!(findViewById instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View item = viewGroup.getChildAt(i3);
            TextView textView = (TextView) item.findViewById(R.id.action_sheet_button);
            if (textView != null) {
                CharSequence text = textView.getText();
                if (Intrinsics.areEqual(text, "\u7fa4\u6210\u5458\u5206\u5e03")) {
                    str = "em_group_member_distribution";
                } else if (Intrinsics.areEqual(text, "\u6279\u91cf\u52a0\u597d\u53cb")) {
                    str = "em_group_batch_add_friends";
                } else if (Intrinsics.areEqual(text, "\u9080\u8bf7\u65b0\u6210\u5458")) {
                    str = "em_group_invite_new_member";
                } else if (Intrinsics.areEqual(text, "\u5220\u9664\u7fa4\u6210\u5458")) {
                    str = "em_group_delete_member";
                } else {
                    str = "";
                }
                String str2 = str;
                if (str2.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    a aVar = f298280a;
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    b(aVar, item, str2, null, 4, null);
                }
            }
        }
        View findViewById2 = actionSheet.findViewById(R.id.action_sheet_btnCancel);
        if (findViewById2 != null) {
            VideoReport.setElementId(findViewById2, "em_group_cancel_btn");
            VideoReport.setElementClickPolicy(findViewById2, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(findViewById2, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(findViewById2, EndExposurePolicy.REPORT_ALL);
        }
    }
}
