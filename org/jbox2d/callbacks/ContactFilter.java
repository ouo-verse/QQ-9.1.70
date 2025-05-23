package org.jbox2d.callbacks;

import org.jbox2d.dynamics.Filter;
import org.jbox2d.dynamics.Fixture;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ContactFilter {
    public boolean shouldCollide(Fixture fixture, Fixture fixture2) {
        Filter filterData = fixture.getFilterData();
        Filter filterData2 = fixture2.getFilterData();
        int i3 = filterData.groupIndex;
        if (i3 == filterData2.groupIndex && i3 != 0) {
            if (i3 > 0) {
                return true;
            }
            return false;
        }
        if ((filterData.maskBits & filterData2.categoryBits) != 0 && (filterData.categoryBits & filterData2.maskBits) != 0) {
            return true;
        }
        return false;
    }
}
