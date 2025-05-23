package com.tencent.mobileqq.qwallet;

import android.content.BroadcastReceiver;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0005R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00018\u00008\u00000\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/WeakFragmentReceiver;", UserInfo.SEX_FEMALE, "Landroidx/fragment/app/Fragment;", "Landroid/content/BroadcastReceiver;", "fragment", "(Landroidx/fragment/app/Fragment;)V", "fragmentRef", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "getFragmentRef", "()Lmqq/util/WeakReference;", "qwallet-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public abstract class WeakFragmentReceiver<F extends Fragment> extends BroadcastReceiver {

    @NotNull
    private final WeakReference<F> fragmentRef;

    public WeakFragmentReceiver(@NotNull F fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragmentRef = new WeakReference<>(fragment);
    }

    @NotNull
    public final WeakReference<F> getFragmentRef() {
        return this.fragmentRef;
    }
}
