package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NavArgument {

    @Nullable
    private final Object mDefaultValue;
    private final boolean mDefaultValuePresent;
    private final boolean mIsNullable;

    @NonNull
    private final NavType mType;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class Builder {

        @Nullable
        private Object mDefaultValue;

        @Nullable
        private NavType<?> mType;
        private boolean mIsNullable = false;
        private boolean mDefaultValuePresent = false;

        @NonNull
        public NavArgument build() {
            if (this.mType == null) {
                this.mType = NavType.inferFromValueType(this.mDefaultValue);
            }
            return new NavArgument(this.mType, this.mIsNullable, this.mDefaultValue, this.mDefaultValuePresent);
        }

        @NonNull
        public Builder setDefaultValue(@Nullable Object obj) {
            this.mDefaultValue = obj;
            this.mDefaultValuePresent = true;
            return this;
        }

        @NonNull
        public Builder setIsNullable(boolean z16) {
            this.mIsNullable = z16;
            return this;
        }

        @NonNull
        public Builder setType(@NonNull NavType<?> navType) {
            this.mType = navType;
            return this;
        }
    }

    NavArgument(@NonNull NavType<?> navType, boolean z16, @Nullable Object obj, boolean z17) {
        if (!navType.isNullableAllowed() && z16) {
            throw new IllegalArgumentException(navType.getName() + " does not allow nullable values");
        }
        if (!z16 && z17 && obj == null) {
            throw new IllegalArgumentException("Argument with type " + navType.getName() + " has null value but is not nullable.");
        }
        this.mType = navType;
        this.mIsNullable = z16;
        this.mDefaultValue = obj;
        this.mDefaultValuePresent = z17;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NavArgument.class != obj.getClass()) {
            return false;
        }
        NavArgument navArgument = (NavArgument) obj;
        if (this.mIsNullable != navArgument.mIsNullable || this.mDefaultValuePresent != navArgument.mDefaultValuePresent || !this.mType.equals(navArgument.mType)) {
            return false;
        }
        Object obj2 = this.mDefaultValue;
        if (obj2 != null) {
            return obj2.equals(navArgument.mDefaultValue);
        }
        if (navArgument.mDefaultValue == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public Object getDefaultValue() {
        return this.mDefaultValue;
    }

    @NonNull
    public NavType<?> getType() {
        return this.mType;
    }

    public int hashCode() {
        int i3;
        int hashCode = ((((this.mType.hashCode() * 31) + (this.mIsNullable ? 1 : 0)) * 31) + (this.mDefaultValuePresent ? 1 : 0)) * 31;
        Object obj = this.mDefaultValue;
        if (obj != null) {
            i3 = obj.hashCode();
        } else {
            i3 = 0;
        }
        return hashCode + i3;
    }

    public boolean isDefaultValuePresent() {
        return this.mDefaultValuePresent;
    }

    public boolean isNullable() {
        return this.mIsNullable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putDefaultValue(@NonNull String str, @NonNull Bundle bundle) {
        if (this.mDefaultValuePresent) {
            this.mType.put(bundle, str, this.mDefaultValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean verify(@NonNull String str, @NonNull Bundle bundle) {
        if (!this.mIsNullable && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.mType.get(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }
}
