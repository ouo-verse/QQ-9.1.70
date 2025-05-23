package com.tencent.mobileqq.qwallet.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qwallet.pet.QWalletPetFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "Landroid/os/Bundle;", "bundle", "", "b", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f278002a = new a();

    a() {
    }

    public final boolean a(@Nullable Activity activity) {
        Intent intent;
        Bundle extras;
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null || !Intrinsics.areEqual(extras.get("fragmentClass"), QWalletPetFragment.class)) {
            return false;
        }
        return true;
    }

    public final void b(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.remove("fragmentClass");
        }
        if (bundle != null) {
            bundle.remove("isTransparentTitle");
        }
        if (bundle != null) {
            bundle.remove("url");
        }
    }
}
