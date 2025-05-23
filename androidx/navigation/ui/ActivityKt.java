package androidx.navigation.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.ui.AppBarConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"setupActionBarWithNavController", "", "Landroidx/appcompat/app/AppCompatActivity;", "navController", "Landroidx/navigation/NavController;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "navigation-ui-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ActivityKt {
    public static final void setupActionBarWithNavController(@NotNull AppCompatActivity setupActionBarWithNavController, @NotNull NavController navController, @Nullable DrawerLayout drawerLayout) {
        Intrinsics.checkParameterIsNotNull(setupActionBarWithNavController, "$this$setupActionBarWithNavController");
        Intrinsics.checkParameterIsNotNull(navController, "navController");
        NavGraph graph = navController.getGraph();
        Intrinsics.checkExpressionValueIsNotNull(graph, "navController.graph");
        AppBarConfigurationKt$AppBarConfiguration$1 appBarConfigurationKt$AppBarConfiguration$1 = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
        AppBarConfiguration.Builder openableLayout = new AppBarConfiguration.Builder(graph).setOpenableLayout(drawerLayout);
        Object obj = appBarConfigurationKt$AppBarConfiguration$1;
        if (appBarConfigurationKt$AppBarConfiguration$1 != null) {
            obj = new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(appBarConfigurationKt$AppBarConfiguration$1);
        }
        AppBarConfiguration build = openableLayout.setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener) obj).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil\u2026eUpListener)\n    .build()");
        NavigationUI.setupActionBarWithNavController(setupActionBarWithNavController, navController, build);
    }

    public static /* synthetic */ void setupActionBarWithNavController$default(AppCompatActivity appCompatActivity, NavController navController, AppBarConfiguration appBarConfiguration, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            NavGraph graph = navController.getGraph();
            Intrinsics.checkExpressionValueIsNotNull(graph, "navController.graph");
            AppBarConfigurationKt$AppBarConfiguration$1 appBarConfigurationKt$AppBarConfiguration$1 = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
            AppBarConfiguration.Builder openableLayout = new AppBarConfiguration.Builder(graph).setOpenableLayout(null);
            Object obj2 = appBarConfigurationKt$AppBarConfiguration$1;
            if (appBarConfigurationKt$AppBarConfiguration$1 != null) {
                obj2 = new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(appBarConfigurationKt$AppBarConfiguration$1);
            }
            appBarConfiguration = openableLayout.setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener) obj2).build();
            Intrinsics.checkExpressionValueIsNotNull(appBarConfiguration, "AppBarConfiguration.Buil\u2026eUpListener)\n    .build()");
        }
        setupActionBarWithNavController(appCompatActivity, navController, appBarConfiguration);
    }

    public static final void setupActionBarWithNavController(@NotNull AppCompatActivity setupActionBarWithNavController, @NotNull NavController navController, @NotNull AppBarConfiguration configuration) {
        Intrinsics.checkParameterIsNotNull(setupActionBarWithNavController, "$this$setupActionBarWithNavController");
        Intrinsics.checkParameterIsNotNull(navController, "navController");
        Intrinsics.checkParameterIsNotNull(configuration, "configuration");
        NavigationUI.setupActionBarWithNavController(setupActionBarWithNavController, navController, configuration);
    }
}
