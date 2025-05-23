package androidx.core.os;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes.dex */
final class LocaleListCompatWrapper implements LocaleListInterface {
    private final Locale[] mList;

    @NonNull
    private final String mStringRepresentation;
    private static final Locale[] sEmptyList = new Locale[0];
    private static final Locale LOCALE_EN_XA = new Locale("en", "XA");
    private static final Locale LOCALE_AR_XB = new Locale("ar", "XB");
    private static final Locale EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocaleListCompatWrapper(@NonNull Locale... localeArr) {
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            this.mStringRepresentation = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < localeArr.length; i3++) {
            Locale locale = localeArr[i3];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    toLanguageTag(sb5, locale2);
                    if (i3 < localeArr.length - 1) {
                        sb5.append(',');
                    }
                    hashSet.add(locale2);
                }
            } else {
                throw new NullPointerException("list[" + i3 + "] is null");
            }
        }
        this.mList = (Locale[]) arrayList.toArray(new Locale[arrayList.size()]);
        this.mStringRepresentation = sb5.toString();
    }

    private Locale computeFirstMatch(Collection<String> collection, boolean z16) {
        int computeFirstMatchIndex = computeFirstMatchIndex(collection, z16);
        if (computeFirstMatchIndex == -1) {
            return null;
        }
        return this.mList[computeFirstMatchIndex];
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
    
        if (r6 < Integer.MAX_VALUE) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int computeFirstMatchIndex(Collection<String> collection, boolean z16) {
        int i3;
        Locale[] localeArr = this.mList;
        if (localeArr.length == 1) {
            return 0;
        }
        if (localeArr.length == 0) {
            return -1;
        }
        if (z16) {
            i3 = findFirstMatchIndex(EN_LATN);
            if (i3 == 0) {
                return 0;
            }
        }
        i3 = Integer.MAX_VALUE;
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            int findFirstMatchIndex = findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat(it.next()));
            if (findFirstMatchIndex == 0) {
                return 0;
            }
            if (findFirstMatchIndex < i3) {
                i3 = findFirstMatchIndex;
            }
        }
        if (i3 == Integer.MAX_VALUE) {
            return 0;
        }
        return i3;
    }

    private int findFirstMatchIndex(Locale locale) {
        int i3 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i3 < localeArr.length) {
                if (matchScore(locale, localeArr[i3]) > 0) {
                    return i3;
                }
                i3++;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    private static String getLikelyScript(Locale locale) {
        String script = locale.getScript();
        if (!script.isEmpty()) {
            return script;
        }
        return "";
    }

    private static boolean isPseudoLocale(Locale locale) {
        if (!LOCALE_EN_XA.equals(locale) && !LOCALE_AR_XB.equals(locale)) {
            return false;
        }
        return true;
    }

    @IntRange(from = 0, to = 1)
    private static int matchScore(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || isPseudoLocale(locale) || isPseudoLocale(locale2)) {
            return 0;
        }
        String likelyScript = getLikelyScript(locale);
        if (!likelyScript.isEmpty()) {
            return likelyScript.equals(getLikelyScript(locale2)) ? 1 : 0;
        }
        String country = locale.getCountry();
        if (country.isEmpty() || country.equals(locale2.getCountry())) {
            return 1;
        }
        return 0;
    }

    @VisibleForTesting
    static void toLanguageTag(StringBuilder sb5, Locale locale) {
        sb5.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb5.append('-');
            sb5.append(locale.getCountry());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).mList;
        if (this.mList.length != localeArr.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            Locale[] localeArr2 = this.mList;
            if (i3 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i3].equals(localeArr[i3])) {
                return false;
            }
            i3++;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i3) {
        if (i3 >= 0) {
            Locale[] localeArr = this.mList;
            if (i3 < localeArr.length) {
                return localeArr[i3];
            }
        }
        return null;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(@NonNull String[] strArr) {
        return computeFirstMatch(Arrays.asList(strArr), false);
    }

    @Override // androidx.core.os.LocaleListInterface
    @Nullable
    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        int i3 = 1;
        int i16 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i16 < localeArr.length) {
                i3 = (i3 * 31) + localeArr[i16].hashCode();
                i16++;
            } else {
                return i3;
            }
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale locale) {
        int i3 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i3 < localeArr.length) {
                if (localeArr[i3].equals(locale)) {
                    return i3;
                }
                i3++;
            } else {
                return -1;
            }
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        if (this.mList.length == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.mList.length;
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        int i3 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i3 < localeArr.length) {
                sb5.append(localeArr[i3]);
                if (i3 < this.mList.length - 1) {
                    sb5.append(',');
                }
                i3++;
            } else {
                sb5.append("]");
                return sb5.toString();
            }
        }
    }
}
