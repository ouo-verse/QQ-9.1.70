package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.SystemProperties;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.upstream.DataSource;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.PermissionMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Util {
    private static final int[] CRC32_BYTES_MSBF;
    public static final String DEVICE;
    public static final String DEVICE_DEBUG_INFO;
    private static final Pattern ESCAPED_CHARACTER_PATTERN;
    public static final String MANUFACTURER;
    public static final String MODEL;
    public static final int SDK_INT;
    private static final String TAG = "Util";
    private static final Pattern XS_DATE_TIME_PATTERN;
    private static final Pattern XS_DURATION_PATTERN;

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') {
            i3 = 26;
        }
        SDK_INT = i3;
        String str = Build.DEVICE;
        DEVICE = str;
        String str2 = Build.MANUFACTURER;
        MANUFACTURER = str2;
        String model = DeviceInfoMonitor.getModel();
        MODEL = model;
        DEVICE_DEBUG_INFO = str + ", " + model + ", " + str2 + ", " + i3;
        XS_DATE_TIME_PATTERN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        ESCAPED_CHARACTER_PATTERN = Pattern.compile("%([A-Fa-f0-9]{2})");
        CRC32_BYTES_MSBF = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    }

    Util() {
    }

    public static long addWithOverflowDefault(long j3, long j16, long j17) {
        long j18 = j3 + j16;
        if (((j3 ^ j18) & (j16 ^ j18)) < 0) {
            return j17;
        }
        return j18;
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int binarySearchCeil(long[] jArr, long j3, boolean z16, boolean z17) {
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

    /* JADX WARN: Removed duplicated region for block: B:5:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int binarySearchFloor(int[] iArr, int i3, boolean z16, boolean z17) {
        int i16;
        int binarySearch = Arrays.binarySearch(iArr, i3);
        if (binarySearch < 0) {
            i16 = -(binarySearch + 2);
            return !z17 ? Math.max(0, i16) : i16;
        }
        do {
            binarySearch--;
            if (binarySearch < 0) {
                break;
            }
        } while (iArr[binarySearch] == i3);
        i16 = z16 ? binarySearch + 1 : binarySearch;
        if (!z17) {
        }
    }

    public static int ceilDivide(int i3, int i16) {
        return ((i3 + i16) - 1) / i16;
    }

    public static void closeQuietly(DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int compareLong(long j3, long j16) {
        if (j3 < j16) {
            return -1;
        }
        if (j3 == j16) {
            return 0;
        }
        return 1;
    }

    public static int constrainValue(int i3, int i16, int i17) {
        return Math.max(i16, Math.min(i3, i17));
    }

    public static boolean contains(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (areEqual(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static int crc(byte[] bArr, int i3, int i16, int i17) {
        while (i3 < i16) {
            i17 = CRC32_BYTES_MSBF[((i17 >>> 24) ^ (bArr[i3] & 255)) & 255] ^ (i17 << 8);
            i3++;
        }
        return i17;
    }

    public static File createTempDirectory(Context context, String str) throws IOException {
        File createTempFile = createTempFile(context, str);
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    public static File createTempFile(Context context, String str) throws IOException {
        return File.createTempFile(str, null, context.getCacheDir());
    }

    public static String escapeFileName(String str) {
        int length = str.length();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            if (shouldEscapeCharacter(str.charAt(i17))) {
                i16++;
            }
        }
        if (i16 == 0) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder((i16 * 2) + length);
        while (i16 > 0) {
            int i18 = i3 + 1;
            char charAt = str.charAt(i3);
            if (shouldEscapeCharacter(charAt)) {
                sb5.append('%');
                sb5.append(Integer.toHexString(charAt));
                i16--;
            } else {
                sb5.append(charAt);
            }
            i3 = i18;
        }
        if (i3 < length) {
            sb5.append((CharSequence) str, i3, length);
        }
        return sb5.toString();
    }

    public static String fromUtf8Bytes(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public static int getAudioContentTypeForStreamType(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1 || i3 == 2 || i3 == 4 || i3 == 5 || i3 == 8) {
            return 4;
        }
        return 2;
    }

    public static int getAudioUsageForStreamType(int i3) {
        if (i3 == 0) {
            return 2;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                int i16 = 4;
                if (i3 != 4) {
                    i16 = 5;
                    if (i3 != 5) {
                        if (i3 != 8) {
                            return 1;
                        }
                        return 3;
                    }
                }
                return i16;
            }
            return 6;
        }
        return 13;
    }

    public static byte[] getBytesFromHexString(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            bArr[i3] = (byte) ((Character.digit(str.charAt(i16), 16) << 4) + Character.digit(str.charAt(i16 + 1), 16));
        }
        return bArr;
    }

    public static String getCodecsOfType(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.trim().split("(\\s*,\\s*)");
        StringBuilder sb5 = new StringBuilder();
        for (String str2 : split) {
            if (i3 == MimeTypes.getTrackTypeOfCodec(str2)) {
                if (sb5.length() > 0) {
                    sb5.append(",");
                }
                sb5.append(str2);
            }
        }
        if (sb5.length() <= 0) {
            return null;
        }
        return sb5.toString();
    }

    public static String getCommaDelimitedSimpleClassNames(Object[] objArr) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < objArr.length; i3++) {
            sb5.append(objArr[i3].getClass().getSimpleName());
            if (i3 < objArr.length - 1) {
                sb5.append(", ");
            }
        }
        return sb5.toString();
    }

    public static int getDefaultBufferSize(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 || i3 == 4) {
                        return 131072;
                    }
                    throw new IllegalStateException();
                }
                return C.DEFAULT_VIDEO_BUFFER_SIZE;
            }
            return C.DEFAULT_AUDIO_BUFFER_SIZE;
        }
        return 16777216;
    }

    @TargetApi(16)
    private static void getDisplaySizeV16(Display display, Point point) {
        display.getSize(point);
    }

    @TargetApi(17)
    private static void getDisplaySizeV17(Display display, Point point) {
        display.getRealSize(point);
    }

    @TargetApi(23)
    private static void getDisplaySizeV23(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    private static void getDisplaySizeV9(Display display, Point point) {
        point.x = display.getWidth();
        point.y = display.getHeight();
    }

    public static UUID getDrmUuid(String str) {
        String lowerInvariant = toLowerInvariant(str);
        lowerInvariant.hashCode();
        char c16 = '\uffff';
        switch (lowerInvariant.hashCode()) {
            case -1860423953:
                if (lowerInvariant.equals("playready")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1400551171:
                if (lowerInvariant.equals("widevine")) {
                    c16 = 1;
                    break;
                }
                break;
            case 790309106:
                if (lowerInvariant.equals("clearkey")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return C.PLAYREADY_UUID;
            case 1:
                return C.WIDEVINE_UUID;
            case 2:
                return C.CLEARKEY_UUID;
            default:
                try {
                    return UUID.fromString(str);
                } catch (RuntimeException unused) {
                    return null;
                }
        }
    }

    public static int getIntegerCodeForString(String str) {
        boolean z16;
        int length = str.length();
        if (length <= 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            i3 = (i3 << 8) | str.charAt(i16);
        }
        return i3;
    }

    public static long getMediaDurationForPlayoutDuration(long j3, float f16) {
        if (f16 == 1.0f) {
            return j3;
        }
        return Math.round(j3 * f16);
    }

    public static int getPcmEncoding(int i3) {
        if (i3 != 8) {
            if (i3 != 16) {
                if (i3 != 24) {
                    if (i3 != 32) {
                        return 0;
                    }
                    return 1073741824;
                }
                return Integer.MIN_VALUE;
            }
            return 2;
        }
        return 3;
    }

    public static int getPcmFrameSize(int i3, int i16) {
        if (i3 != Integer.MIN_VALUE) {
            if (i3 != 1073741824) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            throw new IllegalArgumentException();
                        }
                    } else {
                        return i16;
                    }
                } else {
                    return i16 * 2;
                }
            }
            return i16 * 4;
        }
        return i16 * 3;
    }

    public static Point getPhysicalDisplaySize(Context context) {
        return getPhysicalDisplaySize(context, ((WindowManager) context.getSystemService("window")).getDefaultDisplay());
    }

    public static long getPlayoutDurationForMediaDuration(long j3, float f16) {
        if (f16 == 1.0f) {
            return j3;
        }
        return Math.round(j3 / f16);
    }

    public static int getStreamTypeForAudioUsage(int i3) {
        if (i3 != 13) {
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
        return 1;
    }

    public static String getStringForTime(StringBuilder sb5, Formatter formatter, long j3) {
        if (j3 == -9223372036854775807L) {
            j3 = 0;
        }
        long j16 = (j3 + 500) / 1000;
        long j17 = j16 % 60;
        long j18 = (j16 / 60) % 60;
        long j19 = j16 / 3600;
        sb5.setLength(0);
        if (j19 > 0) {
            return formatter.format("%d:%02d:%02d", Long.valueOf(j19), Long.valueOf(j18), Long.valueOf(j17)).toString();
        }
        return formatter.format("%02d:%02d", Long.valueOf(j18), Long.valueOf(j17)).toString();
    }

    public static String getUserAgent(Context context, String str) {
        String str2;
        try {
            str2 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") " + ExoPlayerLibraryInfo.VERSION_SLASHY;
    }

    public static byte[] getUtf8Bytes(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static int inferContentType(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return inferContentType(path);
    }

    public static boolean isEncodingHighResolutionIntegerPcm(int i3) {
        if (i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            return false;
        }
        return true;
    }

    public static boolean isLinebreak(int i3) {
        if (i3 != 10 && i3 != 13) {
            return false;
        }
        return true;
    }

    public static boolean isLocalFileUri(Uri uri) {
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && !scheme.equals("file")) {
            return false;
        }
        return true;
    }

    @TargetApi(23)
    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, Uri... uriArr) {
        if (SDK_INT < 23) {
            return false;
        }
        int length = uriArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (isLocalFileUri(uriArr[i3])) {
                if (activity.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) != 0) {
                    PermissionMonitor.requestPermissions(activity, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE}, 0);
                    return true;
                }
            } else {
                i3++;
            }
        }
        return false;
    }

    public static ExecutorService newSingleThreadExecutor(final String str) {
        return ProxyExecutors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.google.android.exoplayer2.util.Util.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new BaseThread(runnable, str);
            }
        });
    }

    public static String normalizeLanguageCode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Locale(str).getISO3Language();
        } catch (MissingResourceException unused) {
            return toLowerInvariant(str);
        }
    }

    public static long parseXsDateTime(String str) throws ParserException {
        Matcher matcher = XS_DATE_TIME_PATTERN.matcher(str);
        if (matcher.matches()) {
            int i3 = 0;
            if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
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
        throw new ParserException("Invalid date/time format: " + str);
    }

    public static long parseXsDuration(String str) {
        double d16;
        double d17;
        double d18;
        double d19;
        double d26;
        Matcher matcher = XS_DURATION_PATTERN.matcher(str);
        if (matcher.matches()) {
            boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
            String group = matcher.group(3);
            double d27 = 0.0d;
            if (group != null) {
                d16 = Double.parseDouble(group) * 3.1556908E7d;
            } else {
                d16 = 0.0d;
            }
            String group2 = matcher.group(5);
            if (group2 != null) {
                d17 = Double.parseDouble(group2) * 2629739.0d;
            } else {
                d17 = 0.0d;
            }
            double d28 = d16 + d17;
            String group3 = matcher.group(7);
            if (group3 != null) {
                d18 = Double.parseDouble(group3) * 86400.0d;
            } else {
                d18 = 0.0d;
            }
            double d29 = d28 + d18;
            String group4 = matcher.group(10);
            if (group4 != null) {
                d19 = Double.parseDouble(group4) * 3600.0d;
            } else {
                d19 = 0.0d;
            }
            double d36 = d29 + d19;
            String group5 = matcher.group(12);
            if (group5 != null) {
                d26 = Double.parseDouble(group5) * 60.0d;
            } else {
                d26 = 0.0d;
            }
            double d37 = d36 + d26;
            String group6 = matcher.group(14);
            if (group6 != null) {
                d27 = Double.parseDouble(group6);
            }
            long j3 = (long) ((d37 + d27) * 1000.0d);
            if (isEmpty) {
                return -j3;
            }
            return j3;
        }
        return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
    }

    public static void recursiveDelete(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                recursiveDelete(file2);
            }
        }
        file.delete();
    }

    public static <T> void removeRange(List<T> list, int i3, int i16) {
        list.subList(i3, i16).clear();
    }

    public static long resolveSeekPositionUs(long j3, SeekParameters seekParameters, long j16, long j17) {
        boolean z16;
        if (SeekParameters.EXACT.equals(seekParameters)) {
            return j3;
        }
        long subtractWithOverflowDefault = subtractWithOverflowDefault(j3, seekParameters.toleranceBeforeUs, Long.MIN_VALUE);
        long addWithOverflowDefault = addWithOverflowDefault(j3, seekParameters.toleranceAfterUs, Long.MAX_VALUE);
        boolean z17 = true;
        if (subtractWithOverflowDefault <= j16 && j16 <= addWithOverflowDefault) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (subtractWithOverflowDefault > j17 || j17 > addWithOverflowDefault) {
            z17 = false;
        }
        if (z16 && z17) {
            if (Math.abs(j16 - j3) <= Math.abs(j17 - j3)) {
                return j16;
            }
            return j17;
        }
        if (z16) {
            return j16;
        }
        if (z17) {
            return j17;
        }
        return subtractWithOverflowDefault;
    }

    public static long scaleLargeTimestamp(long j3, long j16, long j17) {
        if (j17 >= j16 && j17 % j16 == 0) {
            return j3 / (j17 / j16);
        }
        if (j17 < j16 && j16 % j17 == 0) {
            return j3 * (j16 / j17);
        }
        return (long) (j3 * (j16 / j17));
    }

    public static long[] scaleLargeTimestamps(List<Long> list, long j3, long j16) {
        int size = list.size();
        long[] jArr = new long[size];
        int i3 = 0;
        if (j16 >= j3 && j16 % j3 == 0) {
            long j17 = j16 / j3;
            while (i3 < size) {
                jArr[i3] = list.get(i3).longValue() / j17;
                i3++;
            }
        } else if (j16 < j3 && j3 % j16 == 0) {
            long j18 = j3 / j16;
            while (i3 < size) {
                jArr[i3] = list.get(i3).longValue() * j18;
                i3++;
            }
        } else {
            double d16 = j3 / j16;
            while (i3 < size) {
                jArr[i3] = (long) (list.get(i3).longValue() * d16);
                i3++;
            }
        }
        return jArr;
    }

    public static void scaleLargeTimestampsInPlace(long[] jArr, long j3, long j16) {
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

    private static boolean shouldEscapeCharacter(char c16) {
        if (c16 != '\"' && c16 != '%' && c16 != '*' && c16 != '/' && c16 != ':' && c16 != '<' && c16 != '\\' && c16 != '|' && c16 != '>' && c16 != '?') {
            return false;
        }
        return true;
    }

    public static void sneakyThrow(Throwable th5) {
        sneakyThrowInternal(th5);
    }

    public static long subtractWithOverflowDefault(long j3, long j16, long j17) {
        long j18 = j3 - j16;
        if (((j3 ^ j18) & (j16 ^ j3)) < 0) {
            return j17;
        }
        return j18;
    }

    public static int[] toArray(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = list.get(i3).intValue();
        }
        return iArr;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String toLowerInvariant(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.US);
    }

    public static String unescapeFileName(String str) {
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
        Matcher matcher = ESCAPED_CHARACTER_PATTERN.matcher(str);
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

    public static long ceilDivide(long j3, long j16) {
        return ((j3 + j16) - 1) / j16;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long constrainValue(long j3, long j16, long j17) {
        return Math.max(j16, Math.min(j3, j17));
    }

    public static float constrainValue(float f16, float f17, float f18) {
        return Math.max(f17, Math.min(f16, f18));
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0078, code lost:
    
        if (r6.equals("TPM171E") == false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Point getPhysicalDisplaySize(Context context, Display display) {
        String str;
        if (SDK_INT < 25 && display.getDisplayId() == 0) {
            String str2 = MANUFACTURER;
            if ("Sony".equals(str2) && MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
            if (!"NVIDIA".equals(str2) || !MODEL.contains("SHIELD")) {
                if ("philips".equals(toLowerInvariant(str2))) {
                    String str3 = MODEL;
                    if (!str3.startsWith("QM1")) {
                        if (!str3.equals("QV151E")) {
                        }
                    }
                }
            }
            try {
                str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "sys.display-size");
            } catch (Exception e16) {
                Log.e(TAG, "Failed to read sys.display-size", e16);
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] split = str.trim().split(HippyTKDListViewAdapter.X);
                    if (split.length == 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                Log.e(TAG, "Invalid sys.display-size: " + str);
            }
        }
        Point point = new Point();
        int i3 = SDK_INT;
        if (i3 >= 23) {
            getDisplaySizeV23(display, point);
        } else if (i3 >= 17) {
            getDisplaySizeV17(display, point);
        } else if (i3 >= 16) {
            getDisplaySizeV16(display, point);
        } else {
            getDisplaySizeV9(display, point);
        }
        return point;
    }

    public static int inferContentType(String str) {
        String lowerInvariant = toLowerInvariant(str);
        if (lowerInvariant.endsWith(".mpd")) {
            return 0;
        }
        if (lowerInvariant.endsWith(".m3u8")) {
            return 2;
        }
        return lowerInvariant.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?") ? 1 : 3;
    }

    public static <T> int binarySearchCeil(List<? extends Comparable<? super T>> list, T t16, boolean z16, boolean z17) {
        int i3;
        int binarySearch = Collections.binarySearch(list, t16);
        if (binarySearch < 0) {
            i3 = ~binarySearch;
        } else {
            int size = list.size();
            do {
                binarySearch++;
                if (binarySearch >= size) {
                    break;
                }
            } while (list.get(binarySearch).compareTo(t16) == 0);
            i3 = z16 ? binarySearch - 1 : binarySearch;
        }
        return z17 ? Math.min(list.size() - 1, i3) : i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int binarySearchFloor(long[] jArr, long j3, boolean z16, boolean z17) {
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

    /* JADX WARN: Removed duplicated region for block: B:5:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> int binarySearchFloor(List<? extends Comparable<? super T>> list, T t16, boolean z16, boolean z17) {
        int i3;
        int binarySearch = Collections.binarySearch(list, t16);
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
            return !z17 ? Math.max(0, i3) : i3;
        }
        do {
            binarySearch--;
            if (binarySearch < 0) {
                break;
            }
        } while (list.get(binarySearch).compareTo(t16) == 0);
        i3 = z16 ? binarySearch + 1 : binarySearch;
        if (!z17) {
        }
    }

    private static <T extends Throwable> void sneakyThrowInternal(Throwable th5) throws Throwable {
        throw th5;
    }
}
