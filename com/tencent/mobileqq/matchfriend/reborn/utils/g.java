package com.tencent.mobileqq.matchfriend.reborn.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.matchfriend.reborn.api.impl.QQStrangerEntryApiImpl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/utils/g;", "", "Landroid/content/Intent;", "intent", "", "a", "", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "c", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f245479a = new g();

    g() {
    }

    public final String a(Intent intent) {
        Bundle extras;
        String string = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString(QQStrangerEntryApiImpl.QQSTRANGER_FORWARD_URI_FROM_HOME, "");
        return string == null ? "" : string;
    }

    public final boolean b(Intent intent) {
        boolean equals$default;
        String a16 = a(intent);
        if (a16.length() == 0) {
            return false;
        }
        equals$default = StringsKt__StringsJVMKt.equals$default(Uri.parse(a16).getQueryParameter("auto_register"), "1", false, 2, null);
        return equals$default;
    }

    public final boolean c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = activity.getIntent();
        return intent != null && a(intent).length() > 0;
    }
}
