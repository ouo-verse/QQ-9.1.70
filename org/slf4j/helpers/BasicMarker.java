package org.slf4j.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.httpcore.message.TokenParser;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BasicMarker implements Marker {
    private static String CLOSE = " ]";
    private static String OPEN = "[ ";
    private static String SEP = ", ";
    private static final long serialVersionUID = -2849567615646933777L;
    private final String name;
    private List<Marker> referenceList = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicMarker(String str) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new IllegalArgumentException("A marker name cannot be null");
    }

    @Override // org.slf4j.Marker
    public void add(Marker marker) {
        if (marker != null) {
            if (contains(marker) || marker.contains(this)) {
                return;
            }
            this.referenceList.add(marker);
            return;
        }
        throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
    }

    @Override // org.slf4j.Marker
    public boolean contains(Marker marker) {
        if (marker != null) {
            if (equals(marker)) {
                return true;
            }
            if (!hasReferences()) {
                return false;
            }
            Iterator<Marker> it = this.referenceList.iterator();
            while (it.hasNext()) {
                if (it.next().contains(marker)) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Other cannot be null");
    }

    @Override // org.slf4j.Marker
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Marker)) {
            return false;
        }
        return this.name.equals(((Marker) obj).getName());
    }

    @Override // org.slf4j.Marker
    public String getName() {
        return this.name;
    }

    @Override // org.slf4j.Marker
    public boolean hasChildren() {
        return hasReferences();
    }

    @Override // org.slf4j.Marker
    public boolean hasReferences() {
        if (this.referenceList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // org.slf4j.Marker
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // org.slf4j.Marker
    public Iterator<Marker> iterator() {
        return this.referenceList.iterator();
    }

    @Override // org.slf4j.Marker
    public boolean remove(Marker marker) {
        return this.referenceList.remove(marker);
    }

    public String toString() {
        if (!hasReferences()) {
            return getName();
        }
        Iterator<Marker> it = iterator();
        StringBuilder sb5 = new StringBuilder(getName());
        sb5.append(TokenParser.SP);
        sb5.append(OPEN);
        while (it.hasNext()) {
            sb5.append(it.next().getName());
            if (it.hasNext()) {
                sb5.append(SEP);
            }
        }
        sb5.append(CLOSE);
        return sb5.toString();
    }

    @Override // org.slf4j.Marker
    public boolean contains(String str) {
        if (str != null) {
            if (this.name.equals(str)) {
                return true;
            }
            if (!hasReferences()) {
                return false;
            }
            Iterator<Marker> it = this.referenceList.iterator();
            while (it.hasNext()) {
                if (it.next().contains(str)) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Other cannot be null");
    }
}
