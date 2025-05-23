package com.tencent.mobileqq.forward;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface al {
    public static final IPatchRedirector $redirector_ = null;

    void a(@NonNull Activity activity, String str, int i3, @Nullable com.tencent.mobileqq.guild.feed.api.g gVar);

    boolean b();

    @Nullable
    SharePublishGuildFeedParam c();
}
