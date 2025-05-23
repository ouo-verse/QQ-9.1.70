package com.tencent.luggage.wxa.n0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public static final int f135103a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f135104b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f135105c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f135106d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f135107e;

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f135108f;

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f135109g;

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f135110h;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f135111i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f135112a;

        public a(String str) {
            this.f135112a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new BaseThread(runnable, this.f135112a);
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') {
            i3 = 26;
        }
        f135103a = i3;
        String str = Build.DEVICE;
        f135104b = str;
        String str2 = Build.MANUFACTURER;
        f135105c = str2;
        String model = DeviceInfoMonitor.getModel();
        f135106d = model;
        f135107e = str + ", " + model + ", " + str2 + ", " + i3;
        f135108f = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f135109g = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f135110h = Pattern.compile("%([A-Fa-f0-9]{2})");
        f135111i = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    }

    public static boolean a(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || scheme.equals("file");
    }

    public static int b(int i3) {
        if (i3 == 8) {
            return 3;
        }
        if (i3 == 16) {
            return 2;
        }
        if (i3 != 24) {
            return i3 != 32 ? 0 : 1073741824;
        }
        return Integer.MIN_VALUE;
    }

    public static int c(int i3) {
        if (i3 == 13) {
            return 1;
        }
        switch (i3) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static boolean d(int i3) {
        return i3 == 10 || i3 == 13;
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return new Locale(str).getLanguage();
    }

    public static long f(String str) {
        int i3;
        Matcher matcher = f135108f.matcher(str);
        if (matcher.matches()) {
            if (matcher.group(9) == null || matcher.group(9).equalsIgnoreCase("Z")) {
                i3 = 0;
            } else {
                i3 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                if (matcher.group(11).equals("-")) {
                    i3 *= -1;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            if (i3 != 0) {
                return timeInMillis - (i3 * 60000);
            }
            return timeInMillis;
        }
        throw new com.tencent.luggage.wxa.m.o("Invalid date/time format: " + str);
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.US);
    }

    public static String h(String str) {
        int length = str.length();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            if (str.charAt(i17) == '%') {
                i16++;
            }
        }
        if (i16 == 0) {
            return str;
        }
        int i18 = length - (i16 * 2);
        StringBuilder sb5 = new StringBuilder(i18);
        Matcher matcher = f135110h.matcher(str);
        while (i16 > 0 && matcher.find()) {
            char parseInt = (char) Integer.parseInt(matcher.group(1), 16);
            sb5.append((CharSequence) str, i3, matcher.start());
            sb5.append(parseInt);
            i3 = matcher.end();
            i16--;
        }
        if (i3 < length) {
            sb5.append((CharSequence) str, i3, length);
        }
        if (sb5.length() != i18) {
            return null;
        }
        return sb5.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(long[] jArr, long j3, boolean z16, boolean z17) {
        int i3;
        int binarySearch = Arrays.binarySearch(jArr, j3);
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
            return !z17 ? Math.max(0, i3) : i3;
        }
        do {
            binarySearch--;
            if (binarySearch < 0) {
                break;
            }
        } while (jArr[binarySearch] == j3);
        i3 = z16 ? binarySearch + 1 : binarySearch;
        if (!z17) {
        }
    }

    public static byte[] c(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static ExecutorService d(String str) {
        return ProxyExecutors.newSingleThreadExecutor(new a(str));
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void a(com.tencent.luggage.wxa.l0.g gVar) {
        if (gVar != null) {
            try {
                gVar.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long b(long j3, long j16, long j17) {
        if (j17 >= j16 && j17 % j16 == 0) {
            return j3 / (j17 / j16);
        }
        if (j17 < j16 && j16 % j17 == 0) {
            return j3 * (j16 / j17);
        }
        return (long) (j3 * (j16 / j17));
    }

    public static int a(int i3, int i16) {
        return ((i3 + i16) - 1) / i16;
    }

    public static int a(int i3, int i16, int i17) {
        return Math.max(i16, Math.min(i3, i17));
    }

    public static long a(long j3, long j16, long j17) {
        return Math.max(j16, Math.min(j3, j17));
    }

    public static float a(float f16, float f17, float f18) {
        return Math.max(f17, Math.min(f16, f18));
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(long[] jArr, long j3, boolean z16, boolean z17) {
        int i3;
        int binarySearch = Arrays.binarySearch(jArr, j3);
        if (binarySearch < 0) {
            i3 = ~binarySearch;
            return !z17 ? Math.min(jArr.length - 1, i3) : i3;
        }
        do {
            binarySearch++;
            if (binarySearch >= jArr.length) {
                break;
            }
        } while (jArr[binarySearch] == j3);
        i3 = z16 ? binarySearch - 1 : binarySearch;
        if (!z17) {
        }
    }

    public static int b(String str) {
        int length = str.length();
        com.tencent.luggage.wxa.n0.a.a(length <= 4);
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            i3 = (i3 << 8) | str.charAt(i16);
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(List list, Object obj, boolean z16, boolean z17) {
        int i3;
        int binarySearch = Collections.binarySearch(list, obj);
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
            return !z17 ? Math.max(0, i3) : i3;
        }
        do {
            binarySearch--;
            if (binarySearch < 0) {
                break;
            }
        } while (((Comparable) list.get(binarySearch)).compareTo(obj) == 0);
        i3 = z16 ? binarySearch + 1 : binarySearch;
        if (!z17) {
        }
    }

    public static int b(int i3, int i16) {
        if (i3 == Integer.MIN_VALUE) {
            return i16 * 3;
        }
        if (i3 == 1073741824) {
            return i16 * 4;
        }
        if (i3 == 2) {
            return i16 * 2;
        }
        if (i3 == 3) {
            return i16;
        }
        throw new IllegalArgumentException();
    }

    public static void b(Throwable th5) {
        throw th5;
    }

    public static void a(long[] jArr, long j3, long j16) {
        int i3 = 0;
        if (j16 >= j3 && j16 % j3 == 0) {
            long j17 = j16 / j3;
            while (i3 < jArr.length) {
                jArr[i3] = jArr[i3] / j17;
                i3++;
            }
            return;
        }
        if (j16 < j3 && j3 % j16 == 0) {
            long j18 = j3 / j16;
            while (i3 < jArr.length) {
                jArr[i3] = jArr[i3] * j18;
                i3++;
            }
            return;
        }
        double d16 = j3 / j16;
        while (i3 < jArr.length) {
            jArr[i3] = (long) (jArr[i3] * d16);
            i3++;
        }
    }

    public static int[] a(List list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = ((Integer) list.get(i3)).intValue();
        }
        return iArr;
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            bArr[i3] = (byte) ((Character.digit(str.charAt(i16), 16) << 4) + Character.digit(str.charAt(i16 + 1), 16));
        }
        return bArr;
    }

    public static String a(Object[] objArr) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < objArr.length; i3++) {
            sb5.append(objArr[i3].getClass().getSimpleName());
            if (i3 < objArr.length - 1) {
                sb5.append(", ");
            }
        }
        return sb5.toString();
    }

    public static String a(Context context, String str) {
        String str2;
        try {
            str2 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.5.4";
    }

    public static int a(int i3) {
        if (i3 == 0) {
            return 16777216;
        }
        if (i3 == 1) {
            return C.DEFAULT_AUDIO_BUFFER_SIZE;
        }
        if (i3 == 2) {
            return C.DEFAULT_VIDEO_BUFFER_SIZE;
        }
        if (i3 == 3 || i3 == 4) {
            return 131072;
        }
        throw new IllegalStateException();
    }

    public static void a(Throwable th5) {
        b(th5);
    }

    public static int a(byte[] bArr, int i3, int i16, int i17) {
        while (i3 < i16) {
            i17 = f135111i[((i17 >>> 24) ^ (bArr[i3] & 255)) & 255] ^ (i17 << 8);
            i3++;
        }
        return i17;
    }
}
