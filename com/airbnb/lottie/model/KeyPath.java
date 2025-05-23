package com.airbnb.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");
    private final List<String> keys;

    @Nullable
    private KeyPathElement resolvedElement;

    public KeyPath(String... strArr) {
        this.keys = Arrays.asList(strArr);
    }

    private boolean endsWithGlobstar() {
        return this.keys.get(r0.size() - 1).equals("**");
    }

    private boolean isContainer(String str) {
        return "__container".equals(str);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath addKey(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.keys.add(str);
        return keyPath;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyPath keyPath = (KeyPath) obj;
        if (!this.keys.equals(keyPath.keys)) {
            return false;
        }
        KeyPathElement keyPathElement = this.resolvedElement;
        KeyPathElement keyPathElement2 = keyPath.resolvedElement;
        if (keyPathElement != null) {
            return keyPathElement.equals(keyPathElement2);
        }
        if (keyPathElement2 == null) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean fullyResolvesTo(String str, int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (i3 >= this.keys.size()) {
            return false;
        }
        if (i3 == this.keys.size() - 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = this.keys.get(i3);
        if (!str2.equals("**")) {
            if (!str2.equals(str) && !str2.equals("*")) {
                z18 = false;
            } else {
                z18 = true;
            }
            if ((!z16 && (i3 != this.keys.size() - 2 || !endsWithGlobstar())) || !z18) {
                return false;
            }
            return true;
        }
        if (!z16 && this.keys.get(i3 + 1).equals(str)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (i3 != this.keys.size() - 2 && (i3 != this.keys.size() - 3 || !endsWithGlobstar())) {
                return false;
            }
            return true;
        }
        if (z16) {
            return true;
        }
        int i16 = i3 + 1;
        if (i16 < this.keys.size() - 1) {
            return false;
        }
        return this.keys.get(i16).equals(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    public int hashCode() {
        int i3;
        int hashCode = this.keys.hashCode() * 31;
        KeyPathElement keyPathElement = this.resolvedElement;
        if (keyPathElement != null) {
            i3 = keyPathElement.hashCode();
        } else {
            i3 = 0;
        }
        return hashCode + i3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int incrementDepthBy(String str, int i3) {
        if (isContainer(str)) {
            return 0;
        }
        if (!this.keys.get(i3).equals("**")) {
            return 1;
        }
        if (i3 == this.keys.size() - 1 || !this.keys.get(i3 + 1).equals(str)) {
            return 0;
        }
        return 2;
    }

    public String keysToString() {
        return this.keys.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean matches(String str, int i3) {
        if (isContainer(str)) {
            return true;
        }
        if (i3 >= this.keys.size()) {
            return false;
        }
        if (this.keys.get(i3).equals(str) || this.keys.get(i3).equals("**") || this.keys.get(i3).equals("*")) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean propagateToChildren(String str, int i3) {
        if ("__container".equals(str) || i3 < this.keys.size() - 1 || this.keys.get(i3).equals("**")) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.resolvedElement = keyPathElement;
        return keyPath;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("KeyPath{keys=");
        sb5.append(this.keys);
        sb5.append(",resolved=");
        if (this.resolvedElement != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append('}');
        return sb5.toString();
    }

    KeyPath(KeyPath keyPath) {
        this.keys = new ArrayList(keyPath.keys);
        this.resolvedElement = keyPath.resolvedElement;
    }
}
