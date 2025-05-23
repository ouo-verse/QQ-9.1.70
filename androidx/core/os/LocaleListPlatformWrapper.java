package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;

@RequiresApi(24)
/* loaded from: classes.dex */
final class LocaleListPlatformWrapper implements LocaleListInterface {
    private final LocaleList mLocaleList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocaleListPlatformWrapper(LocaleList localeList) {
        this.mLocaleList = localeList;
    }

    public boolean equals(Object obj) {
        boolean equals;
        equals = this.mLocaleList.equals(((LocaleListInterface) obj).getLocaleList());
        return equals;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i3) {
        Locale locale;
        locale = this.mLocaleList.get(i3);
        return locale;
    }

    @Override // androidx.core.os.LocaleListInterface
    @Nullable
    public Locale getFirstMatch(@NonNull String[] strArr) {
        Locale firstMatch;
        firstMatch = this.mLocaleList.getFirstMatch(strArr);
        return firstMatch;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return this.mLocaleList;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.mLocaleList.hashCode();
        return hashCode;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale locale) {
        int indexOf;
        indexOf = this.mLocaleList.indexOf(locale);
        return indexOf;
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        boolean isEmpty;
        isEmpty = this.mLocaleList.isEmpty();
        return isEmpty;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        int size;
        size = this.mLocaleList.size();
        return size;
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        String languageTags;
        languageTags = this.mLocaleList.toLanguageTags();
        return languageTags;
    }

    public String toString() {
        String localeList;
        localeList = this.mLocaleList.toString();
        return localeList;
    }
}
