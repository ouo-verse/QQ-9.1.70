package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.navigation.Navigator;

/* compiled from: P */
@Navigator.Name(NotificationCompat.CATEGORY_NAVIGATION)
/* loaded from: classes.dex */
public class NavGraphNavigator extends Navigator<NavGraph> {
    private final NavigatorProvider mNavigatorProvider;

    public NavGraphNavigator(@NonNull NavigatorProvider navigatorProvider) {
        this.mNavigatorProvider = navigatorProvider;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        return true;
    }

    @Override // androidx.navigation.Navigator
    @NonNull
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    @Override // androidx.navigation.Navigator
    @Nullable
    public NavDestination navigate(@NonNull NavGraph navGraph, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        int startDestination = navGraph.getStartDestination();
        if (startDestination != 0) {
            NavDestination findNode = navGraph.findNode(startDestination, false);
            if (findNode != null) {
                return this.mNavigatorProvider.getNavigator(findNode.getNavigatorName()).navigate(findNode, findNode.addInDefaultArgs(bundle), navOptions, extras);
            }
            throw new IllegalArgumentException("navigation destination " + navGraph.getStartDestDisplayName() + " is not a direct child of this NavGraph");
        }
        throw new IllegalStateException("no start destination defined via app:startDestination for " + navGraph.getDisplayName());
    }
}
