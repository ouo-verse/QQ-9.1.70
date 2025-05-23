package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0017\u0010\n\u001a\u0004\u0018\u00010\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007\"\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000b*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u000f*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/richframework/part/Part;", "Landroidx/lifecycle/LifecycleOwner;", "c", "(Lcom/tencent/biz/richframework/part/Part;)Landroidx/lifecycle/LifecycleOwner;", "hostLifecycleOwner", "Landroidx/lifecycle/LifecycleCoroutineScope;", "d", "(Lcom/tencent/biz/richframework/part/Part;)Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "e", "nullableLifecycleScope", "Landroid/os/Bundle;", "b", "(Lcom/tencent/biz/richframework/part/Part;)Landroid/os/Bundle;", "fragmentArgument", "Landroid/content/Intent;", "a", "(Lcom/tencent/biz/richframework/part/Part;)Landroid/content/Intent;", "activityIntent", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    @Nullable
    public static final Intent a(@NotNull Part part) {
        Activity hostActivity;
        Intrinsics.checkNotNullParameter(part, "<this>");
        IPartHost partHost = part.getPartHost();
        if (partHost != null && (hostActivity = partHost.getHostActivity()) != null) {
            return hostActivity.getIntent();
        }
        return null;
    }

    @Nullable
    public static final Bundle b(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        Fragment hostFragment = part.getHostFragment();
        if (hostFragment != null) {
            return hostFragment.getArguments();
        }
        return null;
    }

    @NotNull
    public static final LifecycleOwner c(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        LifecycleOwner hostLifecycleOwner = part.getPartHost().getHostLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner, "partHost.hostLifecycleOwner");
        return hostLifecycleOwner;
    }

    @NotNull
    public static final LifecycleCoroutineScope d(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        return LifecycleOwnerKt.getLifecycleScope(c(part));
    }

    @Nullable
    public static final LifecycleCoroutineScope e(@NotNull Part part) {
        LiveData<LifecycleOwner> viewLifecycleOwnerLiveData;
        LifecycleOwner value;
        Intrinsics.checkNotNullParameter(part, "<this>");
        Fragment hostFragment = part.getHostFragment();
        if (hostFragment != null && (viewLifecycleOwnerLiveData = hostFragment.getViewLifecycleOwnerLiveData()) != null && (value = viewLifecycleOwnerLiveData.getValue()) != null) {
            return LifecycleOwnerKt.getLifecycleScope(value);
        }
        return null;
    }
}
