package org.jf.dexlib2;

import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum HiddenApiRestriction {
    WHITELIST(0, "whitelist", false),
    GREYLIST(1, "greylist", false),
    BLACKLIST(2, "blacklist", false),
    GREYLIST_MAX_O(3, "greylist-max-o", false),
    GREYLIST_MAX_P(4, "greylist-max-p", false),
    GREYLIST_MAX_Q(5, "greylist-max-q", false),
    CORE_PLATFORM_API(8, "core-platform-api", true),
    TEST_API(16, "test-api", true);

    private static final int HIDDENAPI_FLAG_MASK = 7;
    private static final HiddenApiRestriction[] domainSpecificApiFlags;
    private static final HiddenApiRestriction[] hiddenApiFlags;
    private static final Map<String, HiddenApiRestriction> hiddenApiRestrictionsByName;
    private final boolean isDomainSpecificApiFlag;
    private final String name;
    private final int value;

    static {
        HiddenApiRestriction hiddenApiRestriction = WHITELIST;
        HiddenApiRestriction hiddenApiRestriction2 = GREYLIST;
        HiddenApiRestriction hiddenApiRestriction3 = BLACKLIST;
        HiddenApiRestriction hiddenApiRestriction4 = GREYLIST_MAX_O;
        HiddenApiRestriction hiddenApiRestriction5 = GREYLIST_MAX_P;
        HiddenApiRestriction hiddenApiRestriction6 = GREYLIST_MAX_Q;
        HiddenApiRestriction hiddenApiRestriction7 = CORE_PLATFORM_API;
        HiddenApiRestriction hiddenApiRestriction8 = TEST_API;
        hiddenApiFlags = new HiddenApiRestriction[]{hiddenApiRestriction, hiddenApiRestriction2, hiddenApiRestriction3, hiddenApiRestriction4, hiddenApiRestriction5, hiddenApiRestriction6};
        domainSpecificApiFlags = new HiddenApiRestriction[]{hiddenApiRestriction7, hiddenApiRestriction8};
        hiddenApiRestrictionsByName = new HashMap();
        for (HiddenApiRestriction hiddenApiRestriction9 : values()) {
            hiddenApiRestrictionsByName.put(hiddenApiRestriction9.toString(), hiddenApiRestriction9);
        }
    }

    HiddenApiRestriction(int i3, String str, boolean z16) {
        this.value = i3;
        this.name = str;
        this.isDomainSpecificApiFlag = z16;
    }

    public static int combineFlags(Iterable<HiddenApiRestriction> iterable) {
        int i3 = 0;
        boolean z16 = false;
        for (HiddenApiRestriction hiddenApiRestriction : iterable) {
            if (hiddenApiRestriction.isDomainSpecificApiFlag) {
                i3 += hiddenApiRestriction.value;
            } else if (!z16) {
                i3 += hiddenApiRestriction.value;
                z16 = true;
            } else {
                throw new IllegalArgumentException("Cannot combine multiple flags for hidden api restrictions");
            }
        }
        return i3;
    }

    public static HiddenApiRestriction forName(String str) {
        return hiddenApiRestrictionsByName.get(str);
    }

    public static String formatHiddenRestrictions(int i3) {
        String stringJoiner;
        StringJoiner stringJoiner2 = new StringJoiner("|");
        Iterator<HiddenApiRestriction> it = getAllFlags(i3).iterator();
        while (it.hasNext()) {
            stringJoiner2.add(it.next().toString());
        }
        stringJoiner = stringJoiner2.toString();
        return stringJoiner;
    }

    public static Set<HiddenApiRestriction> getAllFlags(int i3) {
        HiddenApiRestriction hiddenApiRestriction = hiddenApiFlags[i3 & 7];
        if ((i3 & (-8)) == 0) {
            return ImmutableSet.of(hiddenApiRestriction);
        }
        ImmutableSet.a builder = ImmutableSet.builder();
        builder.a(hiddenApiRestriction);
        for (HiddenApiRestriction hiddenApiRestriction2 : domainSpecificApiFlags) {
            if (hiddenApiRestriction2.isSet(i3)) {
                builder.a(hiddenApiRestriction2);
            }
        }
        return builder.l();
    }

    public int getValue() {
        return this.value;
    }

    public boolean isDomainSpecificApiFlag() {
        return this.isDomainSpecificApiFlag;
    }

    public boolean isSet(int i3) {
        if (this.isDomainSpecificApiFlag) {
            if ((i3 & this.value) != 0) {
                return true;
            }
            return false;
        }
        if ((i3 & 7) == this.value) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
