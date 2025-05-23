package com.tencent.mobileqq.forward;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.feed.api.IGuildShareToFeedApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes12.dex */
public final /* synthetic */ class ak {
    public static void a(al alVar, @NonNull Activity activity, String str, int i3, @Nullable com.tencent.mobileqq.guild.feed.api.g gVar) {
        IPatchRedirector iPatchRedirector = al.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, alVar, activity, str, Integer.valueOf(i3), gVar);
            return;
        }
        SharePublishGuildFeedParam c16 = alVar.c();
        if (c16 != null && c16.isValid()) {
            ((IGuildShareToFeedApi) QRoute.api(IGuildShareToFeedApi.class)).shareToFeedPostAwareForbidden(activity, str, c16, i3, gVar);
        } else if (gVar != null) {
            gVar.a(false);
        }
    }

    public static boolean b(al alVar) {
        IPatchRedirector iPatchRedirector = al.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) alVar)).booleanValue();
        }
        SharePublishGuildFeedParam c16 = alVar.c();
        if (c16 != null && c16.isValid()) {
            return true;
        }
        return false;
    }
}
