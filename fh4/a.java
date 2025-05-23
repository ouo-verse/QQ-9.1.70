package fh4;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0006"}, d2 = {"Lfh4/a;", "", "Landroid/content/res/Resources;", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f398752a = new a();

    a() {
    }

    @Nullable
    public final Resources a() {
        Resources resources = BaseApplication.getContext().getResources();
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(GlobalDisplayMetricsManager.sQQDisplayMetrics);
            resources.updateConfiguration(configuration, displayMetrics);
        }
        return resources;
    }
}
