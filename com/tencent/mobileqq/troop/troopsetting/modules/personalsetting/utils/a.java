package com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.utils;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/personalsetting/utils/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "troopUin", "", "d", "entryView", "e", "f", "c", "a", "b", "g", h.F, "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f301221a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60463);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f301221a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull View entryView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) entryView);
        } else {
            Intrinsics.checkNotNullParameter(entryView, "entryView");
            VideoReport.setElementId(entryView, "em_group_chat_background");
        }
    }

    public final void b(@NotNull View entryView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) entryView);
        } else {
            Intrinsics.checkNotNullParameter(entryView, "entryView");
            VideoReport.setElementId(entryView, "em_group_enter_visual");
        }
    }

    public final void c(@NotNull View entryView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) entryView);
        } else {
            Intrinsics.checkNotNullParameter(entryView, "entryView");
            VideoReport.setElementId(entryView, "em_group_luck_character");
        }
    }

    public final void d(@NotNull Activity activity, @NotNull View rootView, @NotNull String troopUin) {
        Map mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, rootView, troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(rootView, "pg_group_person_setting");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group_id", troopUin));
        VideoReport.setPageParams(rootView, new PageParams((Map<String, ?>) mapOf));
    }

    public final void e(@NotNull View entryView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) entryView);
        } else {
            Intrinsics.checkNotNullParameter(entryView, "entryView");
            VideoReport.setElementId(entryView, "em_group_honor");
        }
    }

    public final void f(@NotNull View entryView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) entryView);
        } else {
            Intrinsics.checkNotNullParameter(entryView, "entryView");
            VideoReport.setElementId(entryView, "em_group_titles_logo");
        }
    }

    public final void g(@NotNull View entryView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) entryView);
        } else {
            Intrinsics.checkNotNullParameter(entryView, "entryView");
            VideoReport.setElementId(entryView, "em_group_reminder_words");
        }
    }

    public final void h(@NotNull View entryView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) entryView);
        } else {
            Intrinsics.checkNotNullParameter(entryView, "entryView");
            VideoReport.setElementId(entryView, "em_group_nickname_decoration");
        }
    }
}
