package com.tencent.mobileqq.config.aio;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.activity.aio.item.l;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.poke.f;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import ma1.c;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/config/aio/PokeItemConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lma1/c;", "", "configString", "", "e", "b", "", "content", "d", DownloadInfo.spKey_Config, "c", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class PokeItemConfigParser extends BaseConfigParser<c> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0a39  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0ab3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0b3e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0aae  */
    /* JADX WARN: Type inference failed for: r0v46, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r0v47, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v11, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v13, types: [int] */
    /* JADX WARN: Type inference failed for: r9v134 */
    /* JADX WARN: Type inference failed for: r9v135 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(String configString) {
        String str;
        String str2;
        int i3;
        int i16;
        int i17;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        boolean z29;
        String str8;
        String str9;
        long j3;
        String str10;
        boolean z36;
        boolean z37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        boolean z38;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        boolean z39;
        boolean z46;
        int i49;
        int i56;
        String str16;
        int i57;
        List take;
        String[] strArr;
        int length;
        int i58;
        long j16;
        int i59;
        String str17;
        int i65;
        int i66;
        int i67;
        boolean contains$default;
        List take2;
        String str18;
        boolean contains$default2;
        boolean contains$default3;
        List emptyList;
        boolean contains$default4;
        boolean contains$default5;
        boolean contains$default6;
        boolean contains$default7;
        int i68;
        boolean contains$default8;
        int i69;
        boolean contains$default9;
        boolean contains$default10;
        int i75;
        boolean contains$default11;
        List emptyList2;
        int i76;
        int i77;
        List emptyList3;
        List emptyList4;
        List take3;
        List emptyList5;
        List emptyList6;
        List take4;
        List emptyList7;
        List emptyList8;
        String str19 = "this as java.lang.String\u2026ing(startIndex, endIndex)";
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        int i78 = -1;
        int i79 = 2;
        int i85 = 0;
        long j17 = -1;
        int i86 = 50;
        try {
            List<String> split = new Regex("\\|").split(configString, 0);
            if (!split.isEmpty()) {
                try {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (!(listIterator.previous().length() == 0)) {
                            take = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                } catch (Exception e16) {
                    e = e16;
                    str = "";
                    str2 = str;
                    i3 = -1;
                    i16 = -1;
                    i17 = -1;
                    z16 = false;
                    z17 = false;
                    z18 = false;
                    z19 = false;
                    z26 = false;
                    z27 = false;
                    z28 = false;
                    i18 = 0;
                    i19 = 0;
                    i26 = 0;
                    i27 = 0;
                    i28 = 0;
                    i29 = 0;
                    i36 = 0;
                    i37 = 0;
                    z29 = false;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    str6 = null;
                    str7 = null;
                }
            }
            take = CollectionsKt__CollectionsKt.emptyList();
            Object[] array = take.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            strArr = (String[]) array;
            length = strArr.length;
            str = "";
            str2 = str;
            i58 = 0;
            z16 = false;
            z17 = false;
            z18 = false;
            z19 = false;
            z26 = false;
            z27 = false;
            z28 = false;
            i18 = 0;
            i19 = 0;
            i26 = 0;
            i27 = 0;
            i28 = 0;
            i29 = 0;
            i36 = 0;
            i37 = 0;
            z29 = false;
            j16 = -1;
            i59 = 50;
            str17 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            i65 = -1;
            i66 = -1;
            i67 = -1;
        } catch (Exception e17) {
            e = e17;
            str = "";
            str2 = str;
            i3 = -1;
            i16 = -1;
            i17 = -1;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            z16 = false;
            z17 = false;
            z18 = false;
            z19 = false;
            z26 = false;
            z27 = false;
            z28 = false;
            i18 = 0;
            i19 = 0;
            i26 = 0;
            i27 = 0;
            i28 = 0;
            i29 = 0;
            i36 = 0;
            i37 = 0;
            z29 = false;
        }
        while (i58 < length) {
            try {
                String str20 = strArr[i58];
                int i87 = i78;
                try {
                    contains$default = StringsKt__StringsKt.contains$default(str20, AppConstants.Preferences.AIO_PE_VIEW_TYPE, (boolean) i85, i79, (Object) null);
                    if (!contains$default) {
                        i3 = i65;
                        try {
                            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str20, (CharSequence) "aio_entry_type", false, 2, (Object) null);
                            if (!contains$default2) {
                                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) str20, (CharSequence) "aio_panel_pe", false, 2, (Object) null);
                                if (!contains$default3) {
                                    contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) str20, (CharSequence) AppConstants.Preferences.POKE_STRENGTH_RULE, false, 2, (Object) null);
                                    if (contains$default4) {
                                        List<String> split2 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str20, 0);
                                        if (!split2.isEmpty()) {
                                            ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                                            while (listIterator2.hasPrevious()) {
                                                if (!(listIterator2.previous().length() == 0)) {
                                                    emptyList7 = CollectionsKt___CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                                                    break;
                                                }
                                            }
                                        }
                                        emptyList7 = CollectionsKt__CollectionsKt.emptyList();
                                        Object[] array2 = emptyList7.toArray(new String[0]);
                                        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                        String str21 = ((String[]) array2)[1];
                                        int length2 = str21.length() - 1;
                                        str18 = str19;
                                        int i88 = 0;
                                        boolean z47 = false;
                                        while (true) {
                                            i16 = i66;
                                            if (i88 > length2) {
                                                i17 = i67;
                                                break;
                                            }
                                            try {
                                                i17 = i67;
                                            } catch (Exception e18) {
                                                e = e18;
                                                i17 = i67;
                                                i78 = i87;
                                                j17 = j16;
                                                i86 = i59;
                                                str3 = str17;
                                                QLog.e("PokeMsg", 1, "PokeMsgConfig parse erro.fight " + e);
                                                str11 = str3;
                                                str8 = str;
                                                z38 = z16;
                                                i38 = i18;
                                                i48 = i19;
                                                str15 = str4;
                                                str14 = str5;
                                                str13 = str6;
                                                str12 = str7;
                                                i39 = i3;
                                                str9 = "";
                                                j3 = j17;
                                                str10 = str2;
                                                z37 = z27;
                                                z36 = z28;
                                                i47 = i16;
                                                i46 = i17;
                                                boolean z48 = z19;
                                                boolean z49 = z26;
                                                boolean z55 = z17;
                                                z39 = z18;
                                                if (z29) {
                                                }
                                                if (!z39) {
                                                }
                                                i56 = i27;
                                                if (z46) {
                                                }
                                                l.v(i56);
                                            }
                                            try {
                                                boolean z56 = Intrinsics.compare((int) str21.charAt(!z47 ? i88 : length2), 32) <= 0;
                                                if (z47) {
                                                    if (!z56) {
                                                        break;
                                                    } else {
                                                        length2--;
                                                    }
                                                } else if (z56) {
                                                    i88++;
                                                } else {
                                                    i66 = i16;
                                                    i67 = i17;
                                                    z47 = true;
                                                }
                                                i66 = i16;
                                                i67 = i17;
                                            } catch (Exception e19) {
                                                e = e19;
                                                i78 = i87;
                                                j17 = j16;
                                                i86 = i59;
                                                str3 = str17;
                                                QLog.e("PokeMsg", 1, "PokeMsgConfig parse erro.fight " + e);
                                                str11 = str3;
                                                str8 = str;
                                                z38 = z16;
                                                i38 = i18;
                                                i48 = i19;
                                                str15 = str4;
                                                str14 = str5;
                                                str13 = str6;
                                                str12 = str7;
                                                i39 = i3;
                                                str9 = "";
                                                j3 = j17;
                                                str10 = str2;
                                                z37 = z27;
                                                z36 = z28;
                                                i47 = i16;
                                                i46 = i17;
                                                boolean z482 = z19;
                                                boolean z492 = z26;
                                                boolean z552 = z17;
                                                z39 = z18;
                                                if (z29) {
                                                }
                                                if (!z39) {
                                                }
                                                i56 = i27;
                                                if (z46) {
                                                }
                                                l.v(i56);
                                            }
                                        }
                                        Long valueOf = Long.valueOf(str21.subSequence(i88, length2 + 1).toString());
                                        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(temp[1].trim { it <= ' ' })");
                                        j17 = valueOf.longValue();
                                        z16 = true;
                                    } else {
                                        str18 = str19;
                                        i16 = i66;
                                        i17 = i67;
                                        j17 = j16;
                                    }
                                    try {
                                        contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) str20, (CharSequence) AppConstants.Preferences.POKE_NEW_RES_URL, false, 2, (Object) null);
                                        if (contains$default5) {
                                            List<String> split3 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str20, 0);
                                            if (!split3.isEmpty()) {
                                                try {
                                                    ListIterator<String> listIterator3 = split3.listIterator(split3.size());
                                                    while (listIterator3.hasPrevious()) {
                                                        if (!(listIterator3.previous().length() == 0)) {
                                                            take4 = CollectionsKt___CollectionsKt.take(split3, listIterator3.nextIndex() + 1);
                                                            break;
                                                        }
                                                    }
                                                } catch (Exception e26) {
                                                    e = e26;
                                                    i78 = i87;
                                                    i86 = i59;
                                                    str3 = str17;
                                                    QLog.e("PokeMsg", 1, "PokeMsgConfig parse erro.fight " + e);
                                                    str11 = str3;
                                                    str8 = str;
                                                    z38 = z16;
                                                    i38 = i18;
                                                    i48 = i19;
                                                    str15 = str4;
                                                    str14 = str5;
                                                    str13 = str6;
                                                    str12 = str7;
                                                    i39 = i3;
                                                    str9 = "";
                                                    j3 = j17;
                                                    str10 = str2;
                                                    z37 = z27;
                                                    z36 = z28;
                                                    i47 = i16;
                                                    i46 = i17;
                                                    boolean z4822 = z19;
                                                    boolean z4922 = z26;
                                                    boolean z5522 = z17;
                                                    z39 = z18;
                                                    if (z29) {
                                                    }
                                                    if (!z39) {
                                                    }
                                                    i56 = i27;
                                                    if (z46) {
                                                    }
                                                    l.v(i56);
                                                }
                                            }
                                            take4 = CollectionsKt__CollectionsKt.emptyList();
                                            Object[] array3 = take4.toArray(new String[0]);
                                            Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                            String str22 = ((String[]) array3)[1];
                                            int length3 = str22.length() - 1;
                                            boolean z57 = false;
                                            int i89 = 0;
                                            while (true) {
                                                j16 = j17;
                                                if (i89 > length3) {
                                                    break;
                                                }
                                                boolean z58 = Intrinsics.compare((int) str22.charAt(!z57 ? i89 : length3), 32) <= 0;
                                                if (z57) {
                                                    if (!z58) {
                                                        break;
                                                    } else {
                                                        length3--;
                                                    }
                                                } else if (z58) {
                                                    i89++;
                                                } else {
                                                    j17 = j16;
                                                    z57 = true;
                                                }
                                                j17 = j16;
                                            }
                                            str = str22.subSequence(i89, length3 + 1).toString();
                                            z17 = true;
                                        } else {
                                            j16 = j17;
                                        }
                                        contains$default6 = StringsKt__StringsKt.contains$default((CharSequence) str20, (CharSequence) AppConstants.Preferences.POKE_NEW_RES_MD5, false, 2, (Object) null);
                                        if (contains$default6) {
                                            List<String> split4 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str20, 0);
                                            if (!split4.isEmpty()) {
                                                ListIterator<String> listIterator4 = split4.listIterator(split4.size());
                                                while (listIterator4.hasPrevious()) {
                                                    if (!(listIterator4.previous().length() == 0)) {
                                                        emptyList6 = CollectionsKt___CollectionsKt.take(split4, listIterator4.nextIndex() + 1);
                                                        break;
                                                    }
                                                }
                                            }
                                            emptyList6 = CollectionsKt__CollectionsKt.emptyList();
                                            Object[] array4 = emptyList6.toArray(new String[0]);
                                            Intrinsics.checkNotNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                            String str23 = ((String[]) array4)[1];
                                            int length4 = str23.length() - 1;
                                            boolean z59 = false;
                                            int i95 = 0;
                                            while (i95 <= length4) {
                                                boolean z65 = Intrinsics.compare((int) str23.charAt(!z59 ? i95 : length4), 32) <= 0;
                                                if (z59) {
                                                    if (!z65) {
                                                        break;
                                                    } else {
                                                        length4--;
                                                    }
                                                } else if (z65) {
                                                    i95++;
                                                } else {
                                                    z59 = true;
                                                }
                                            }
                                            str2 = str23.subSequence(i95, length4 + 1).toString();
                                        }
                                        contains$default7 = StringsKt__StringsKt.contains$default((CharSequence) str20, (CharSequence) "aio_bar_poke", false, 2, (Object) null);
                                        if (contains$default7) {
                                            List<String> split5 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str20, 0);
                                            if (!split5.isEmpty()) {
                                                ListIterator<String> listIterator5 = split5.listIterator(split5.size());
                                                while (listIterator5.hasPrevious()) {
                                                    if (!(listIterator5.previous().length() == 0)) {
                                                        emptyList5 = CollectionsKt___CollectionsKt.take(split5, listIterator5.nextIndex() + 1);
                                                        break;
                                                    }
                                                }
                                            }
                                            emptyList5 = CollectionsKt__CollectionsKt.emptyList();
                                            Object[] array5 = emptyList5.toArray(new String[0]);
                                            Intrinsics.checkNotNull(array5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                            String str24 = ((String[]) array5)[1];
                                            int length5 = str24.length() - 1;
                                            boolean z66 = false;
                                            int i96 = 0;
                                            while (i96 <= length5) {
                                                boolean z67 = Intrinsics.compare((int) str24.charAt(!z66 ? i96 : length5), 32) <= 0;
                                                if (z66) {
                                                    if (!z67) {
                                                        break;
                                                    } else {
                                                        length5--;
                                                    }
                                                } else if (z67) {
                                                    i96++;
                                                } else {
                                                    z66 = true;
                                                }
                                            }
                                            Integer valueOf2 = Integer.valueOf(str24.subSequence(i96, length5 + 1).toString());
                                            Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(temp[1].trim { it <= ' ' })");
                                            i68 = valueOf2.intValue();
                                            if (i68 != 0 && i68 != 1 && i68 != 2) {
                                                if (i68 != 3 && i68 != 4) {
                                                    try {
                                                        Unit unit = Unit.INSTANCE;
                                                        i68 = 0;
                                                        z18 = true;
                                                    } catch (Exception e27) {
                                                        e = e27;
                                                        j17 = j16;
                                                        i86 = i59;
                                                        str3 = str17;
                                                        i78 = 0;
                                                    }
                                                }
                                            }
                                            Unit unit2 = Unit.INSTANCE;
                                            z18 = true;
                                        } else {
                                            i68 = i87;
                                        }
                                        try {
                                            contains$default8 = StringsKt__StringsKt.contains$default((CharSequence) str20, (CharSequence) "aio_pad_poke", false, 2, (Object) null);
                                            if (contains$default8) {
                                                List<String> split6 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str20, 0);
                                                if (!split6.isEmpty()) {
                                                    try {
                                                        ListIterator<String> listIterator6 = split6.listIterator(split6.size());
                                                        while (listIterator6.hasPrevious()) {
                                                            if (!(listIterator6.previous().length() == 0)) {
                                                                take3 = CollectionsKt___CollectionsKt.take(split6, listIterator6.nextIndex() + 1);
                                                                break;
                                                            }
                                                        }
                                                    } catch (Exception e28) {
                                                        e = e28;
                                                        i78 = i68;
                                                    }
                                                }
                                                take3 = CollectionsKt__CollectionsKt.emptyList();
                                                Object[] array6 = take3.toArray(new String[0]);
                                                Intrinsics.checkNotNull(array6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                String str25 = ((String[]) array6)[1];
                                                int length6 = str25.length() - 1;
                                                boolean z68 = false;
                                                int i97 = 0;
                                                while (true) {
                                                    if (i97 > length6) {
                                                        i69 = i68;
                                                        break;
                                                    }
                                                    i69 = i68;
                                                    boolean z69 = Intrinsics.compare((int) str25.charAt(!z68 ? i97 : length6), 32) <= 0;
                                                    if (z68) {
                                                        if (!z69) {
                                                            break;
                                                        } else {
                                                            length6--;
                                                        }
                                                    } else if (z69) {
                                                        i97++;
                                                    } else {
                                                        i68 = i69;
                                                        z68 = true;
                                                    }
                                                    i68 = i69;
                                                }
                                                Integer valueOf3 = Integer.valueOf(str25.subSequence(i97, length6 + 1).toString());
                                                Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(temp[1].trim { it <= ' ' })");
                                                int intValue = valueOf3.intValue();
                                                if (intValue != 0 && intValue != 1 && intValue != 2) {
                                                    try {
                                                        Unit unit3 = Unit.INSTANCE;
                                                        intValue = 0;
                                                    } catch (Exception e29) {
                                                        e = e29;
                                                        i78 = i69;
                                                        j17 = j16;
                                                        i86 = i59;
                                                        str3 = str17;
                                                        i3 = 0;
                                                    }
                                                } else {
                                                    try {
                                                        Unit unit4 = Unit.INSTANCE;
                                                    } catch (Exception e36) {
                                                        e = e36;
                                                        i78 = i69;
                                                        i3 = intValue;
                                                    }
                                                }
                                                i3 = intValue;
                                                z19 = true;
                                            } else {
                                                i69 = i68;
                                            }
                                            contains$default9 = StringsKt__StringsKt.contains$default((CharSequence) str20, (CharSequence) AppConstants.Preferences.POKE_SEND_COUNTS_LIMITED, false, 2, (Object) null);
                                            if (contains$default9) {
                                                List<String> split7 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str20, 0);
                                                if (!split7.isEmpty()) {
                                                    ListIterator<String> listIterator7 = split7.listIterator(split7.size());
                                                    while (listIterator7.hasPrevious()) {
                                                        if (!(listIterator7.previous().length() == 0)) {
                                                            emptyList4 = CollectionsKt___CollectionsKt.take(split7, listIterator7.nextIndex() + 1);
                                                            break;
                                                        }
                                                    }
                                                }
                                                emptyList4 = CollectionsKt__CollectionsKt.emptyList();
                                                Object[] array7 = emptyList4.toArray(new String[0]);
                                                Intrinsics.checkNotNull(array7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                String str26 = ((String[]) array7)[1];
                                                int length7 = str26.length() - 1;
                                                boolean z75 = false;
                                                int i98 = 0;
                                                while (i98 <= length7) {
                                                    boolean z76 = Intrinsics.compare((int) str26.charAt(!z75 ? i98 : length7), 32) <= 0;
                                                    if (z75) {
                                                        if (!z76) {
                                                            break;
                                                        } else {
                                                            length7--;
                                                        }
                                                    } else if (z76) {
                                                        i98++;
                                                    } else {
                                                        z75 = true;
                                                    }
                                                }
                                                Integer valueOf4 = Integer.valueOf(str26.subSequence(i98, length7 + 1).toString());
                                                Intrinsics.checkNotNullExpressionValue(valueOf4, "valueOf(temp[1].trim { it <= ' ' })");
                                                int intValue2 = valueOf4.intValue();
                                                if (intValue2 <= 0) {
                                                    try {
                                                        intValue2 = l.C;
                                                    } catch (Exception e37) {
                                                        e = e37;
                                                        i78 = i69;
                                                        i16 = intValue2;
                                                    }
                                                }
                                                i16 = intValue2;
                                                z26 = true;
                                            }
                                            contains$default10 = StringsKt__StringsKt.contains$default((CharSequence) str20, (CharSequence) AppConstants.Preferences.POKE_SEND_TIME_LIMITED, false, 2, (Object) null);
                                            if (contains$default10) {
                                                List<String> split8 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str20, 0);
                                                if (!split8.isEmpty()) {
                                                    ListIterator<String> listIterator8 = split8.listIterator(split8.size());
                                                    while (listIterator8.hasPrevious()) {
                                                        if (!(listIterator8.previous().length() == 0)) {
                                                            emptyList3 = CollectionsKt___CollectionsKt.take(split8, listIterator8.nextIndex() + 1);
                                                            break;
                                                        }
                                                    }
                                                }
                                                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                                                Object[] array8 = emptyList3.toArray(new String[0]);
                                                Intrinsics.checkNotNull(array8, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                String str27 = ((String[]) array8)[1];
                                                int length8 = str27.length() - 1;
                                                boolean z77 = false;
                                                int i99 = 0;
                                                while (i99 <= length8) {
                                                    boolean z78 = Intrinsics.compare((int) str27.charAt(!z77 ? i99 : length8), 32) <= 0;
                                                    if (z77) {
                                                        if (!z78) {
                                                            break;
                                                        } else {
                                                            length8--;
                                                        }
                                                    } else if (z78) {
                                                        i99++;
                                                    } else {
                                                        z77 = true;
                                                    }
                                                }
                                                Integer valueOf5 = Integer.valueOf(str27.subSequence(i99, length8 + 1).toString());
                                                Intrinsics.checkNotNullExpressionValue(valueOf5, "valueOf(temp[1].trim { it <= ' ' })");
                                                i75 = valueOf5.intValue();
                                                if (i75 <= 0) {
                                                    try {
                                                        i75 = l.D;
                                                    } catch (Exception e38) {
                                                        e = e38;
                                                        i17 = i75;
                                                        j17 = j16;
                                                        i86 = i59;
                                                        str3 = str17;
                                                        i78 = i69;
                                                        QLog.e("PokeMsg", 1, "PokeMsgConfig parse erro.fight " + e);
                                                        str11 = str3;
                                                        str8 = str;
                                                        z38 = z16;
                                                        i38 = i18;
                                                        i48 = i19;
                                                        str15 = str4;
                                                        str14 = str5;
                                                        str13 = str6;
                                                        str12 = str7;
                                                        i39 = i3;
                                                        str9 = "";
                                                        j3 = j17;
                                                        str10 = str2;
                                                        z37 = z27;
                                                        z36 = z28;
                                                        i47 = i16;
                                                        i46 = i17;
                                                        boolean z48222 = z19;
                                                        boolean z49222 = z26;
                                                        boolean z55222 = z17;
                                                        z39 = z18;
                                                        if (z29) {
                                                        }
                                                        if (!z39) {
                                                        }
                                                        i56 = i27;
                                                        if (z46) {
                                                        }
                                                        l.v(i56);
                                                    }
                                                }
                                                z27 = true;
                                            } else {
                                                i75 = i17;
                                            }
                                            contains$default11 = StringsKt__StringsKt.contains$default((CharSequence) str20, (CharSequence) "aio_panel", false, 2, (Object) null);
                                            if (contains$default11) {
                                                List<String> split9 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str20, 0);
                                                if (!split9.isEmpty()) {
                                                    ListIterator<String> listIterator9 = split9.listIterator(split9.size());
                                                    while (listIterator9.hasPrevious()) {
                                                        if (!(listIterator9.previous().length() == 0)) {
                                                            emptyList2 = CollectionsKt___CollectionsKt.take(split9, listIterator9.nextIndex() + 1);
                                                            break;
                                                        }
                                                    }
                                                }
                                                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                                                Object[] array9 = emptyList2.toArray(new String[0]);
                                                Intrinsics.checkNotNull(array9, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                String[] strArr2 = (String[]) array9;
                                                str3 = l.p(strArr2[1]);
                                                try {
                                                    int r16 = l.r(strArr2[1]);
                                                    try {
                                                        int q16 = l.q(strArr2[1]);
                                                        try {
                                                            int o16 = l.o(strArr2[1]);
                                                            if (r16 != 1 && r16 != 2) {
                                                                r16 = 0;
                                                            }
                                                            if (r16 != 0) {
                                                                try {
                                                                    int s16 = l.s(strArr2[1]);
                                                                    i76 = (s16 <= 0 || s16 > 6) ? 1 : s16;
                                                                    i77 = 1;
                                                                } catch (Exception e39) {
                                                                    e = e39;
                                                                    i17 = i75;
                                                                    i18 = r16;
                                                                    i26 = q16;
                                                                    i27 = o16;
                                                                    j17 = j16;
                                                                    i86 = i59;
                                                                    i78 = i69;
                                                                    QLog.e("PokeMsg", 1, "PokeMsgConfig parse erro.fight " + e);
                                                                    str11 = str3;
                                                                    str8 = str;
                                                                    z38 = z16;
                                                                    i38 = i18;
                                                                    i48 = i19;
                                                                    str15 = str4;
                                                                    str14 = str5;
                                                                    str13 = str6;
                                                                    str12 = str7;
                                                                    i39 = i3;
                                                                    str9 = "";
                                                                    j3 = j17;
                                                                    str10 = str2;
                                                                    z37 = z27;
                                                                    z36 = z28;
                                                                    i47 = i16;
                                                                    i46 = i17;
                                                                    boolean z482222 = z19;
                                                                    boolean z492222 = z26;
                                                                    boolean z552222 = z17;
                                                                    z39 = z18;
                                                                    if (z29) {
                                                                    }
                                                                    if (!z39) {
                                                                    }
                                                                    i56 = i27;
                                                                    if (z46) {
                                                                    }
                                                                    l.v(i56);
                                                                }
                                                            } else {
                                                                i77 = 1;
                                                                i76 = i19;
                                                            }
                                                            if (q16 != i77) {
                                                                q16 = 0;
                                                            }
                                                            if (o16 <= 0) {
                                                                o16 = 3;
                                                            }
                                                            try {
                                                                if (QLog.isColorLevel()) {
                                                                    QLog.d("PokeItemConfigParser", 2, "[parsed value] pokePanelInfo:" + str3 + " showUniquePokeFlag:" + r16 + " showUniquePokeType:" + i76 + " touchEffect:" + q16 + " comboNum:" + o16);
                                                                }
                                                                i19 = i76;
                                                                str17 = str3;
                                                                i67 = i75;
                                                                i18 = r16;
                                                                i26 = q16;
                                                                i27 = o16;
                                                                i65 = i3;
                                                                i66 = i16;
                                                                z28 = true;
                                                            } catch (Exception e46) {
                                                                e = e46;
                                                                i19 = i76;
                                                                i17 = i75;
                                                                i18 = r16;
                                                                i26 = q16;
                                                                i27 = o16;
                                                                j17 = j16;
                                                                i86 = i59;
                                                                z28 = true;
                                                                i78 = i69;
                                                                QLog.e("PokeMsg", 1, "PokeMsgConfig parse erro.fight " + e);
                                                                str11 = str3;
                                                                str8 = str;
                                                                z38 = z16;
                                                                i38 = i18;
                                                                i48 = i19;
                                                                str15 = str4;
                                                                str14 = str5;
                                                                str13 = str6;
                                                                str12 = str7;
                                                                i39 = i3;
                                                                str9 = "";
                                                                j3 = j17;
                                                                str10 = str2;
                                                                z37 = z27;
                                                                z36 = z28;
                                                                i47 = i16;
                                                                i46 = i17;
                                                                boolean z4822222 = z19;
                                                                boolean z4922222 = z26;
                                                                boolean z5522222 = z17;
                                                                z39 = z18;
                                                                if (z29) {
                                                                }
                                                                if (!z39) {
                                                                }
                                                                i56 = i27;
                                                                if (z46) {
                                                                }
                                                                l.v(i56);
                                                            }
                                                        } catch (Exception e47) {
                                                            e = e47;
                                                            i17 = i75;
                                                            i18 = r16;
                                                            i26 = q16;
                                                        }
                                                    } catch (Exception e48) {
                                                        e = e48;
                                                        i17 = i75;
                                                        i18 = r16;
                                                    }
                                                } catch (Exception e49) {
                                                    e = e49;
                                                    i17 = i75;
                                                }
                                            } else {
                                                i67 = i75;
                                                i65 = i3;
                                                i66 = i16;
                                            }
                                            i78 = i69;
                                            i58++;
                                            str19 = str18;
                                            i79 = 2;
                                            i85 = 0;
                                        } catch (Exception e56) {
                                            e = e56;
                                            i87 = i68;
                                            i78 = i87;
                                            j17 = j16;
                                            i86 = i59;
                                            str3 = str17;
                                            QLog.e("PokeMsg", 1, "PokeMsgConfig parse erro.fight " + e);
                                            str11 = str3;
                                            str8 = str;
                                            z38 = z16;
                                            i38 = i18;
                                            i48 = i19;
                                            str15 = str4;
                                            str14 = str5;
                                            str13 = str6;
                                            str12 = str7;
                                            i39 = i3;
                                            str9 = "";
                                            j3 = j17;
                                            str10 = str2;
                                            z37 = z27;
                                            z36 = z28;
                                            i47 = i16;
                                            i46 = i17;
                                            boolean z48222222 = z19;
                                            boolean z49222222 = z26;
                                            boolean z55222222 = z17;
                                            z39 = z18;
                                            if (z29) {
                                            }
                                            if (!z39) {
                                            }
                                            i56 = i27;
                                            if (z46) {
                                            }
                                            l.v(i56);
                                        }
                                    } catch (Exception e57) {
                                        e = e57;
                                    }
                                } else {
                                    try {
                                        List<String> split10 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str20, 0);
                                        if (!split10.isEmpty()) {
                                            ListIterator<String> listIterator10 = split10.listIterator(split10.size());
                                            while (listIterator10.hasPrevious()) {
                                                if (!(listIterator10.previous().length() == 0)) {
                                                    emptyList = CollectionsKt___CollectionsKt.take(split10, listIterator10.nextIndex() + 1);
                                                    break;
                                                }
                                            }
                                        }
                                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                                        Object[] array10 = emptyList.toArray(new String[0]);
                                        Intrinsics.checkNotNull(array10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                        JSONObject jSONObject = new JSONObject(((String[]) array10)[1]);
                                        str4 = jSONObject.optString("pe_res_url");
                                        str5 = jSONObject.optString("pe_res_md5");
                                        String optString = jSONObject.optString("pe_surprise_indexes");
                                        try {
                                            String optString2 = jSONObject.optString("pe_orders");
                                            try {
                                                String substring = optString.substring(1, optString.length() - 1);
                                                Intrinsics.checkNotNullExpressionValue(substring, str19);
                                                try {
                                                    String substring2 = optString2.substring(1, optString2.length() - 1);
                                                    Intrinsics.checkNotNullExpressionValue(substring2, str19);
                                                    try {
                                                        i28 = jSONObject.optInt(AppConstants.Preferences.AIO_PE_INPUT_SWITCH);
                                                        i29 = jSONObject.optInt(AppConstants.Preferences.AIO_PE_FEED_BACK_SWITCH);
                                                        i59 = jSONObject.optInt(AppConstants.Preferences.AIO_PE_BUBBLE_LIMIT_COUNT);
                                                        str7 = substring2;
                                                        str6 = substring;
                                                        z29 = true;
                                                    } catch (Exception e58) {
                                                        e = e58;
                                                        str7 = substring2;
                                                        str6 = substring;
                                                        QLog.e("PokeItemConfigParser", 1, "aio_panel_pe " + e);
                                                        i78 = i87;
                                                        str18 = str19;
                                                        i65 = i3;
                                                        i58++;
                                                        str19 = str18;
                                                        i79 = 2;
                                                        i85 = 0;
                                                    }
                                                } catch (Exception e59) {
                                                    e = e59;
                                                    str7 = optString2;
                                                }
                                            } catch (Exception e65) {
                                                e = e65;
                                                str6 = optString;
                                                str7 = optString2;
                                            }
                                        } catch (Exception e66) {
                                            e = e66;
                                            str6 = optString;
                                        }
                                    } catch (Exception e67) {
                                        e = e67;
                                    }
                                }
                            } else {
                                List<String> split11 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str20, 0);
                                if (!split11.isEmpty()) {
                                    ListIterator<String> listIterator11 = split11.listIterator(split11.size());
                                    while (listIterator11.hasPrevious()) {
                                        if (!(listIterator11.previous().length() == 0)) {
                                            emptyList8 = CollectionsKt___CollectionsKt.take(split11, listIterator11.nextIndex() + 1);
                                            break;
                                        }
                                    }
                                }
                                emptyList8 = CollectionsKt__CollectionsKt.emptyList();
                                Object[] array11 = emptyList8.toArray(new String[0]);
                                Intrinsics.checkNotNull(array11, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                String str28 = ((String[]) array11)[1];
                                int length9 = str28.length() - 1;
                                boolean z79 = false;
                                int i100 = 0;
                                while (i100 <= length9) {
                                    boolean z85 = Intrinsics.compare((int) str28.charAt(!z79 ? i100 : length9), 32) <= 0;
                                    if (z79) {
                                        if (!z85) {
                                            break;
                                        } else {
                                            length9--;
                                        }
                                    } else if (z85) {
                                        i100++;
                                    } else {
                                        z79 = true;
                                    }
                                }
                                String obj = str28.subSequence(i100, length9 + 1).toString();
                                if (!TextUtils.isEmpty(obj)) {
                                    try {
                                        i36 = Integer.parseInt(obj);
                                    } catch (Exception e68) {
                                        QLog.e("PokeItemConfigParser", 1, "aio_entry_type " + e68);
                                    }
                                }
                            }
                            i78 = i87;
                            str18 = str19;
                            i65 = i3;
                            i58++;
                            str19 = str18;
                            i79 = 2;
                            i85 = 0;
                        } catch (Exception e69) {
                            e = e69;
                            i16 = i66;
                            i17 = i67;
                            i78 = i87;
                            j17 = j16;
                            i86 = i59;
                            str3 = str17;
                            QLog.e("PokeMsg", 1, "PokeMsgConfig parse erro.fight " + e);
                            str11 = str3;
                            str8 = str;
                            z38 = z16;
                            i38 = i18;
                            i48 = i19;
                            str15 = str4;
                            str14 = str5;
                            str13 = str6;
                            str12 = str7;
                            i39 = i3;
                            str9 = "";
                            j3 = j17;
                            str10 = str2;
                            z37 = z27;
                            z36 = z28;
                            i47 = i16;
                            i46 = i17;
                            boolean z482222222 = z19;
                            boolean z492222222 = z26;
                            boolean z552222222 = z17;
                            z39 = z18;
                            if (z29) {
                            }
                            if (!z39) {
                            }
                            i56 = i27;
                            if (z46) {
                            }
                            l.v(i56);
                        }
                    } else {
                        try {
                            List<String> split12 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str20, i85);
                            if (!split12.isEmpty()) {
                                try {
                                    ListIterator<String> listIterator12 = split12.listIterator(split12.size());
                                    while (listIterator12.hasPrevious()) {
                                        if (!(listIterator12.previous().length() == 0 ? true : i85)) {
                                            take2 = CollectionsKt___CollectionsKt.take(split12, listIterator12.nextIndex() + 1);
                                            break;
                                        }
                                    }
                                } catch (Exception e75) {
                                    e = e75;
                                    i78 = i87;
                                    i3 = i65;
                                    i16 = i66;
                                    i17 = i67;
                                    j17 = j16;
                                    i86 = i59;
                                    str3 = str17;
                                    QLog.e("PokeMsg", 1, "PokeMsgConfig parse erro.fight " + e);
                                    str11 = str3;
                                    str8 = str;
                                    z38 = z16;
                                    i38 = i18;
                                    i48 = i19;
                                    str15 = str4;
                                    str14 = str5;
                                    str13 = str6;
                                    str12 = str7;
                                    i39 = i3;
                                    str9 = "";
                                    j3 = j17;
                                    str10 = str2;
                                    z37 = z27;
                                    z36 = z28;
                                    i47 = i16;
                                    i46 = i17;
                                    boolean z4822222222 = z19;
                                    boolean z4922222222 = z26;
                                    boolean z5522222222 = z17;
                                    z39 = z18;
                                    if (z29) {
                                    }
                                    if (!z39) {
                                    }
                                    i56 = i27;
                                    if (z46) {
                                    }
                                    l.v(i56);
                                }
                            }
                            take2 = CollectionsKt__CollectionsKt.emptyList();
                            Object[] array12 = take2.toArray(new String[i85]);
                            Intrinsics.checkNotNull(array12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            ?? r06 = ((String[]) array12)[1];
                            int length10 = r06.length() - 1;
                            boolean z86 = i85;
                            while (true) {
                                if (i85 > length10) {
                                    i3 = i65;
                                    break;
                                }
                                i3 = i65;
                                try {
                                    boolean z87 = Intrinsics.compare((int) r06.charAt(!z86 ? i85 : length10), 32) <= 0;
                                    if (z86) {
                                        if (!z87) {
                                            break;
                                        }
                                        length10--;
                                        i85 = i85;
                                    } else if (z87) {
                                        i85++;
                                    } else {
                                        i65 = i3;
                                        z86 = true;
                                    }
                                    i65 = i3;
                                } catch (Exception e76) {
                                    e = e76;
                                }
                            }
                            String obj2 = r06.subSequence(i85, length10 + 1).toString();
                            if (!TextUtils.isEmpty(obj2)) {
                                try {
                                    i37 = Integer.parseInt(obj2);
                                } catch (Exception e77) {
                                    QLog.e("PokeItemConfigParser", 1, "aio_pe_view_type " + e77);
                                }
                            }
                            i78 = i87;
                            str18 = str19;
                            i65 = i3;
                            i58++;
                            str19 = str18;
                            i79 = 2;
                            i85 = 0;
                        } catch (Exception e78) {
                            e = e78;
                            i3 = i65;
                        }
                    }
                    e = e76;
                    i78 = i87;
                } catch (Exception e79) {
                    e = e79;
                    i3 = i65;
                }
            } catch (Exception e85) {
                e = e85;
            }
            i16 = i66;
            i17 = i67;
            j17 = j16;
            i86 = i59;
            str3 = str17;
            QLog.e("PokeMsg", 1, "PokeMsgConfig parse erro.fight " + e);
            str11 = str3;
            str8 = str;
            z38 = z16;
            i38 = i18;
            i48 = i19;
            str15 = str4;
            str14 = str5;
            str13 = str6;
            str12 = str7;
            i39 = i3;
            str9 = "";
            j3 = j17;
            str10 = str2;
            z37 = z27;
            z36 = z28;
            i47 = i16;
            i46 = i17;
            boolean z48222222222 = z19;
            boolean z49222222222 = z26;
            boolean z55222222222 = z17;
            z39 = z18;
            if (z29) {
                if (QLog.isColorLevel()) {
                    i57 = i38;
                    StringBuilder sb5 = new StringBuilder();
                    z46 = z38;
                    sb5.append("PokeEmoConfig.got.the value is ");
                    sb5.append(str15);
                    sb5.append(", ");
                    sb5.append(str14);
                    sb5.append(", ");
                    sb5.append(str13);
                    sb5.append(", ");
                    sb5.append(str12);
                    QLog.d("PokeItemConfigParser", 2, sb5.toString());
                } else {
                    z46 = z38;
                    i57 = i38;
                }
                BaseApplication app = qQAppInterface.getApp();
                String account = qQAppInterface.getAccount();
                Intrinsics.checkNotNullExpressionValue(account, "app.account");
                i49 = i57;
                com.tencent.mobileqq.poke.utils.c.d(app, account, i36, str15, str14, str13, str12, i28, i29, i86, i37);
                f.r(i36, str15, str14, str13, str12, i28, i86, i37);
                f.q(i29);
            } else {
                z46 = z38;
                i49 = i38;
            }
            if (!z39 && z48222222222 && z49222222222 && z37 && z36) {
                SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "app.app.getSharedPrefere\u2026in, Context.MODE_PRIVATE)");
                sharedPreferences.edit().putBoolean("chat_tool_poke_clicked", false).commit();
                l.w(qQAppInterface, false);
                l.A(qQAppInterface, false);
                l.x(i78, i39, i47, i46);
                ea.w4(qQAppInterface.getApp(), qQAppInterface.getAccount(), 0, true, i78, i39, i47, i46);
                f.s(str11);
                ea.x4(qQAppInterface.getApp(), qQAppInterface.getAccount(), 0, str11);
                l.y(i26);
                ea.c5(qQAppInterface.getApp(), qQAppInterface.getAccount(), 0, i26);
                l.v(i27);
                i56 = i27;
                ea.H3(qQAppInterface.getApp(), qQAppInterface.getAccount(), 0, i56);
                l.z(i49, i48);
                ea.h5(qQAppInterface.getApp(), qQAppInterface.getAccount(), 0, i49, i48);
            } else {
                i56 = i27;
            }
            if (z46 && z55222222222 && z55222222222) {
                String string = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp()).getString(qQAppInterface.getAccount() + "_aio_poke_res_url", str9);
                com.tencent.mobileqq.poke.utils.c cVar = com.tencent.mobileqq.poke.utils.c.f259091a;
                BaseApplication app2 = qQAppInterface.getApp();
                String account2 = qQAppInterface.getAccount();
                Intrinsics.checkNotNullExpressionValue(account2, "app.account");
                str16 = str8;
                cVar.c(app2, account2, j3, str16, str10);
                if (str16 != null && !Intrinsics.areEqual(str16, string)) {
                    l.u(qQAppInterface);
                }
            }
            l.v(i56);
        }
        int i101 = i67;
        i86 = i59;
        str8 = str;
        str11 = str17;
        z38 = z16;
        i38 = i18;
        i48 = i19;
        str15 = str4;
        str14 = str5;
        str13 = str6;
        str12 = str7;
        i39 = i65;
        i47 = i66;
        i46 = i101;
        str9 = "";
        j3 = j16;
        str10 = str2;
        z37 = z27;
        z36 = z28;
        boolean z482222222222 = z19;
        boolean z492222222222 = z26;
        boolean z552222222222 = z17;
        z39 = z18;
        if (z29) {
        }
        if (!z39) {
        }
        i56 = i27;
        if (z46) {
            String string2 = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp()).getString(qQAppInterface.getAccount() + "_aio_poke_res_url", str9);
            com.tencent.mobileqq.poke.utils.c cVar2 = com.tencent.mobileqq.poke.utils.c.f259091a;
            BaseApplication app22 = qQAppInterface.getApp();
            String account22 = qQAppInterface.getAccount();
            Intrinsics.checkNotNullExpressionValue(account22, "app.account");
            str16 = str8;
            cVar2.c(app22, account22, j3, str16, str10);
            if (str16 != null) {
                l.u(qQAppInterface);
            }
        }
        l.v(i56);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c defaultConfig() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable c config) {
        super.doOnConfigUpdate(config);
        if (config != null && !TextUtils.isEmpty(config.getConfigString())) {
            e(config.getConfigString());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(content, UTF_8);
        QLog.d("PokeItemConfigParser", 1, "config " + str);
        c cVar = new c();
        cVar.b(str);
        if (!TextUtils.isEmpty(str)) {
            e(str);
        }
        return cVar;
    }
}
