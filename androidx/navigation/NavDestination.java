package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDeepLink;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class NavDestination {
    private static final HashMap<String, Class<?>> sClasses = new HashMap<>();
    private SparseArrayCompat<NavAction> mActions;
    private HashMap<String, NavArgument> mArguments;
    private ArrayList<NavDeepLink> mDeepLinks;
    private int mId;
    private String mIdName;
    private CharSequence mLabel;
    private final String mNavigatorName;
    private NavGraph mParent;

    /* compiled from: P */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ClassType {
        Class<?> value();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class DeepLinkMatch implements Comparable<DeepLinkMatch> {

        @NonNull
        private final NavDestination mDestination;
        private final boolean mHasMatchingAction;
        private final boolean mIsExactDeepLink;

        @Nullable
        private final Bundle mMatchingArgs;
        private final int mMimeTypeMatchLevel;

        DeepLinkMatch(@NonNull NavDestination navDestination, @Nullable Bundle bundle, boolean z16, boolean z17, int i3) {
            this.mDestination = navDestination;
            this.mMatchingArgs = bundle;
            this.mIsExactDeepLink = z16;
            this.mHasMatchingAction = z17;
            this.mMimeTypeMatchLevel = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public NavDestination getDestination() {
            return this.mDestination;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public Bundle getMatchingArgs() {
            return this.mMatchingArgs;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull DeepLinkMatch deepLinkMatch) {
            boolean z16 = this.mIsExactDeepLink;
            if (z16 && !deepLinkMatch.mIsExactDeepLink) {
                return 1;
            }
            if (!z16 && deepLinkMatch.mIsExactDeepLink) {
                return -1;
            }
            Bundle bundle = this.mMatchingArgs;
            if (bundle != null && deepLinkMatch.mMatchingArgs == null) {
                return 1;
            }
            if (bundle == null && deepLinkMatch.mMatchingArgs != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - deepLinkMatch.mMatchingArgs.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z17 = this.mHasMatchingAction;
            if (z17 && !deepLinkMatch.mHasMatchingAction) {
                return 1;
            }
            if (z17 || !deepLinkMatch.mHasMatchingAction) {
                return this.mMimeTypeMatchLevel - deepLinkMatch.mMimeTypeMatchLevel;
            }
            return -1;
        }
    }

    public NavDestination(@NonNull Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.getNameForNavigator(navigator.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static String getDisplayName(@NonNull Context context, int i3) {
        if (i3 <= 16777215) {
            return Integer.toString(i3);
        }
        try {
            return context.getResources().getResourceName(i3);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i3);
        }
    }

    @NonNull
    protected static <C> Class<? extends C> parseClassFromName(@NonNull Context context, @NonNull String str, @NonNull Class<? extends C> cls) {
        if (str.charAt(0) == '.') {
            str = context.getPackageName() + str;
        }
        HashMap<String, Class<?>> hashMap = sClasses;
        Class<? extends C> cls2 = (Class<? extends C>) hashMap.get(str);
        if (cls2 == null) {
            try {
                cls2 = (Class<? extends C>) Class.forName(str, true, context.getClassLoader());
                hashMap.put(str, cls2);
            } catch (ClassNotFoundException e16) {
                throw new IllegalArgumentException(e16);
            }
        }
        if (cls.isAssignableFrom(cls2)) {
            return cls2;
        }
        throw new IllegalArgumentException(str + " must be a subclass of " + cls);
    }

    public final void addArgument(@NonNull String str, @NonNull NavArgument navArgument) {
        if (this.mArguments == null) {
            this.mArguments = new HashMap<>();
        }
        this.mArguments.put(str, navArgument);
    }

    public final void addDeepLink(@NonNull String str) {
        addDeepLink(new NavDeepLink.Builder().setUriPattern(str).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Bundle addInDefaultArgs(@Nullable Bundle bundle) {
        HashMap<String, NavArgument> hashMap;
        if (bundle == null && ((hashMap = this.mArguments) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, NavArgument> hashMap2 = this.mArguments;
        if (hashMap2 != null) {
            for (Map.Entry<String, NavArgument> entry : hashMap2.entrySet()) {
                entry.getValue().putDefaultValue(entry.getKey(), bundle2);
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, NavArgument> hashMap3 = this.mArguments;
            if (hashMap3 != null) {
                for (Map.Entry<String, NavArgument> entry2 : hashMap3.entrySet()) {
                    if (!entry2.getValue().verify(entry2.getKey(), bundle)) {
                        throw new IllegalArgumentException("Wrong argument type for '" + entry2.getKey() + "' in argument bundle. " + entry2.getValue().getType().getName() + " expected.");
                    }
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public int[] buildDeepLinkIds() {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavDestination navDestination = this;
        while (true) {
            NavGraph parent = navDestination.getParent();
            if (parent == null || parent.getStartDestination() != navDestination.getId()) {
                arrayDeque.addFirst(navDestination);
            }
            if (parent == null) {
                break;
            }
            navDestination = parent;
        }
        int[] iArr = new int[arrayDeque.size()];
        Iterator it = arrayDeque.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = ((NavDestination) it.next()).getId();
            i3++;
        }
        return iArr;
    }

    @Nullable
    public final NavAction getAction(@IdRes int i3) {
        NavAction navAction;
        SparseArrayCompat<NavAction> sparseArrayCompat = this.mActions;
        if (sparseArrayCompat == null) {
            navAction = null;
        } else {
            navAction = sparseArrayCompat.get(i3);
        }
        if (navAction != null) {
            return navAction;
        }
        if (getParent() == null) {
            return null;
        }
        return getParent().getAction(i3);
    }

    @NonNull
    public final Map<String, NavArgument> getArguments() {
        HashMap<String, NavArgument> hashMap = this.mArguments;
        if (hashMap == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(hashMap);
    }

    @IdRes
    public final int getId() {
        return this.mId;
    }

    @Nullable
    public final CharSequence getLabel() {
        return this.mLabel;
    }

    @NonNull
    public final String getNavigatorName() {
        return this.mNavigatorName;
    }

    @Nullable
    public final NavGraph getParent() {
        return this.mParent;
    }

    public boolean hasDeepLink(@NonNull Uri uri) {
        return hasDeepLink(new NavDeepLinkRequest(uri, null, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public DeepLinkMatch matchDeepLink(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        Bundle bundle;
        boolean z16;
        int i3;
        ArrayList<NavDeepLink> arrayList = this.mDeepLinks;
        if (arrayList == null) {
            return null;
        }
        Iterator<NavDeepLink> it = arrayList.iterator();
        DeepLinkMatch deepLinkMatch = null;
        while (it.hasNext()) {
            NavDeepLink next = it.next();
            Uri uri = navDeepLinkRequest.getUri();
            if (uri != null) {
                bundle = next.getMatchingArguments(uri, getArguments());
            } else {
                bundle = null;
            }
            String action = navDeepLinkRequest.getAction();
            if (action != null && action.equals(next.getAction())) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z17 = z16;
            String mimeType = navDeepLinkRequest.getMimeType();
            if (mimeType != null) {
                i3 = next.getMimeTypeMatchRating(mimeType);
            } else {
                i3 = -1;
            }
            if (bundle != null || z17 || i3 > -1) {
                DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, bundle, next.isExactDeepLink(), z17, i3);
                if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                    deepLinkMatch = deepLinkMatch2;
                }
            }
        }
        return deepLinkMatch;
    }

    @CallSuper
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.Navigator);
        setId(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.Navigator_android_id, 0));
        this.mIdName = getDisplayName(context, this.mId);
        setLabel(obtainAttributes.getText(androidx.navigation.common.R.styleable.Navigator_android_label));
        obtainAttributes.recycle();
    }

    public final void putAction(@IdRes int i3, @IdRes int i16) {
        putAction(i3, new NavAction(i16));
    }

    public final void removeAction(@IdRes int i3) {
        SparseArrayCompat<NavAction> sparseArrayCompat = this.mActions;
        if (sparseArrayCompat == null) {
            return;
        }
        sparseArrayCompat.remove(i3);
    }

    public final void removeArgument(@NonNull String str) {
        HashMap<String, NavArgument> hashMap = this.mArguments;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    public final void setId(@IdRes int i3) {
        this.mId = i3;
        this.mIdName = null;
    }

    public final void setLabel(@Nullable CharSequence charSequence) {
        this.mLabel = charSequence;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setParent(NavGraph navGraph) {
        this.mParent = navGraph;
    }

    boolean supportsActions() {
        return true;
    }

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getClass().getSimpleName());
        sb5.append("(");
        String str = this.mIdName;
        if (str == null) {
            sb5.append(RelationNTPushServiceImpl.PRE_HEX_STRING);
            sb5.append(Integer.toHexString(this.mId));
        } else {
            sb5.append(str);
        }
        sb5.append(")");
        if (this.mLabel != null) {
            sb5.append(" label=");
            sb5.append(this.mLabel);
        }
        return sb5.toString();
    }

    public NavDestination(@NonNull String str) {
        this.mNavigatorName = str;
    }

    public final void addDeepLink(@NonNull NavDeepLink navDeepLink) {
        if (this.mDeepLinks == null) {
            this.mDeepLinks = new ArrayList<>();
        }
        this.mDeepLinks.add(navDeepLink);
    }

    public boolean hasDeepLink(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        return matchDeepLink(navDeepLinkRequest) != null;
    }

    public final void putAction(@IdRes int i3, @NonNull NavAction navAction) {
        if (supportsActions()) {
            if (i3 != 0) {
                if (this.mActions == null) {
                    this.mActions = new SparseArrayCompat<>();
                }
                this.mActions.put(i3, navAction);
                return;
            }
            throw new IllegalArgumentException("Cannot have an action with actionId 0");
        }
        throw new UnsupportedOperationException("Cannot add action " + i3 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getDisplayName() {
        if (this.mIdName == null) {
            this.mIdName = Integer.toString(this.mId);
        }
        return this.mIdName;
    }
}
