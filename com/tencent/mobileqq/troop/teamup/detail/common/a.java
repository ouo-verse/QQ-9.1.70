package com.tencent.mobileqq.troop.teamup.detail.common;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/common/a;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "troopUin", "teamId", "", "templateId", "", "e", "Landroid/view/View;", "view", "b", "action", "a", "toUin", "d", "c", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f298875a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55385);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f298875a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull View view, @NotNull String action) {
        Map mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(action, "action");
        VideoReport.setElementId(view, "em_group_btn");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("btn_state", action));
        VideoReport.setElementParams(view, mutableMapOf);
    }

    public final void b(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            VideoReport.setElementId(view, "em_group_already_regist");
        }
    }

    public final void c(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            VideoReport.setElementId(view, "em_group_more_btn");
        }
    }

    public final void d(@NotNull View view, @NotNull String toUin) {
        Map mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) toUin);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(toUin, "toUin");
        VideoReport.setElementId(view, "em_group_nickname");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", toUin));
        VideoReport.setElementParams(view, mutableMapOf);
    }

    public final void e(@NotNull Fragment fragment, @NotNull String troopUin, @NotNull String teamId, int templateId) {
        Map mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, fragment, troopUin, teamId, Integer.valueOf(templateId));
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(teamId, "teamId");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(activity.getWindow().getDecorView(), "pg_group_teamup_detail");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("group_id", troopUin), TuplesKt.to("teamup_id", teamId), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, String.valueOf(templateId)));
        VideoReport.setPageParams(activity.getWindow().getDecorView(), new PageParams((Map<String, ?>) mutableMapOf));
    }
}
