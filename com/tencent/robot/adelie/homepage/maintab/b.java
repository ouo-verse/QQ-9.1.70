package com.tencent.robot.adelie.homepage.maintab;

import android.content.Context;
import android.view.KeyEvent;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/adelie/homepage/maintab/b;", "", "", "selected", "", "setTabSelected", "Landroid/content/Context;", "context", "a", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "fragment", "", "getDesc", "()Ljava/lang/String;", "desc", "z4", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface b {

    /* renamed from: z4, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f366406a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/adelie/homepage/maintab/b$a;", "", "Lcom/google/android/material/tabs/TabLayout$g;", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.maintab.b$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f366406a = new Companion();

        Companion() {
        }

        @NotNull
        public final String a(@NotNull TabLayout.g gVar) {
            b bVar;
            String desc;
            Intrinsics.checkNotNullParameter(gVar, "<this>");
            KeyEvent.Callback e16 = gVar.e();
            if (e16 instanceof b) {
                bVar = (b) e16;
            } else {
                bVar = null;
            }
            if (bVar == null || (desc = bVar.getDesc()) == null) {
                return gVar.toString();
            }
            return desc;
        }
    }

    @CallSuper
    void a(@NotNull Context context);

    @NotNull
    String getDesc();

    @Nullable
    Fragment getFragment();

    void setTabSelected(boolean selected);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.robot.adelie.homepage.maintab.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9756b {
        @CallSuper
        public static void b(@NotNull b bVar, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            QLog.i("AdelieHomeMainFragment_MainTab", 1, bVar.getDesc() + " tab onClick");
        }

        public static void a(@NotNull b bVar) {
        }

        public static void c(@NotNull b bVar, boolean z16) {
        }
    }
}
