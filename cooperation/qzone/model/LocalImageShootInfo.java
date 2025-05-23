package cooperation.qzone.model;

import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.tencent.image.JpegExifReader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LocalImageShootInfo implements Parcelable {
    public static final Parcelable.Creator<LocalImageShootInfo> CREATOR;
    private static final String TAG = "LocalImageShootInfo";
    private static final Map<String, Function<String, String>> videoTimePattern;
    public long captureTime;
    public String captureTimeString;
    public GpsInfo4LocalImage gpsInfo;
    public long modifyTime;
    public String path;

    static {
        HashMap hashMap = new HashMap();
        videoTimePattern = hashMap;
        hashMap.put("yyyyMMdd'T'HHmmss.SSSZ", new Function<String, String>() { // from class: cooperation.qzone.model.LocalImageShootInfo.1
            @Override // androidx.arch.core.util.Function
            public String apply(String str) {
                return str.replaceAll("Z$", "+0000");
            }
        });
        hashMap.put("yyyyMMdd'T'HHmmss", null);
        hashMap.put("yyyy MM dd", null);
        CREATOR = new Parcelable.Creator<LocalImageShootInfo>() { // from class: cooperation.qzone.model.LocalImageShootInfo.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LocalImageShootInfo[] newArray(int i3) {
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LocalImageShootInfo createFromParcel(Parcel parcel) {
                return new LocalImageShootInfo(parcel);
            }
        };
    }

    public LocalImageShootInfo() {
    }

    public static boolean appendCaptureDate(LocalImageShootInfo localImageShootInfo, boolean z16) {
        boolean z17 = false;
        if (localImageShootInfo == null) {
            return false;
        }
        try {
            if (JpegExifReader.isCrashJpeg(localImageShootInfo.path)) {
                localImageShootInfo.captureTime = new File(localImageShootInfo.path).lastModified();
                QLog.d(TAG, 4, "LocalImageShootInfo#appendCaptureDate photo exif date info parse exception, now use last modified time.");
            } else {
                String attribute = new ExifInterface(localImageShootInfo.path).getAttribute("DateTime");
                if (attribute != null) {
                    localImageShootInfo.captureTimeString = attribute;
                    Date parse = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(attribute);
                    if (parse != null) {
                        localImageShootInfo.captureTime = parse.getTime();
                        z17 = true;
                    }
                } else if (z16) {
                    localImageShootInfo.captureTime = new File(localImageShootInfo.path).lastModified();
                    QLog.d(TAG, 4, "LocalImageShootInfo#appendCaptureDate photo exif date info parse exception, now use last modified time.");
                }
            }
        } catch (Exception e16) {
            if (z16) {
                localImageShootInfo.captureTime = new File(localImageShootInfo.path).lastModified();
                QLog.d(TAG, 4, "LocalImageShootInfo#appendCaptureDate photo exif date info parse exception, now use last modified time.", e16);
            }
        }
        return z17;
    }

    public static boolean appendGpsInfo(LocalImageShootInfo localImageShootInfo) {
        if (localImageShootInfo == null) {
            return false;
        }
        if (localImageShootInfo.gpsInfo != null) {
            return true;
        }
        try {
            if (JpegExifReader.isCrashJpeg(localImageShootInfo.path)) {
                return false;
            }
            float[] fArr = new float[2];
            if (!new ExifInterface(localImageShootInfo.path).getLatLong(fArr)) {
                return false;
            }
            GpsInfo4LocalImage gpsInfo4LocalImage = new GpsInfo4LocalImage(fArr[0], fArr[1]);
            if (gpsInfo4LocalImage.latitude == 0.0f && gpsInfo4LocalImage.longtitude == 0.0f) {
                return false;
            }
            localImageShootInfo.gpsInfo = gpsInfo4LocalImage;
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static LocalImageShootInfo createFrom(String str, boolean z16) {
        LocalImageShootInfo localImageShootInfo = null;
        if (str != null && str.length() != 0) {
            try {
                localImageShootInfo = new LocalImageShootInfo(str);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (localImageShootInfo != null) {
                appendCaptureDate(localImageShootInfo, z16);
                appendGpsInfo(localImageShootInfo);
            }
        }
        return localImageShootInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00e4 A[Catch: all -> 0x015d, TRY_LEAVE, TryCatch #4 {all -> 0x015d, blocks: (B:7:0x0013, B:41:0x001e, B:43:0x0033, B:53:0x0046, B:58:0x0051, B:60:0x008e, B:61:0x006d, B:63:0x0071, B:65:0x0077, B:66:0x008b, B:69:0x0091, B:71:0x0097, B:72:0x00a6, B:74:0x00ac, B:10:0x00cf, B:12:0x00e4, B:14:0x00ea, B:16:0x00f0, B:17:0x00fd, B:22:0x0125, B:25:0x0134, B:26:0x013a, B:28:0x0145, B:30:0x0149, B:32:0x0157, B:38:0x0119, B:80:0x00cb), top: B:6:0x0013, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0123 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0145 A[Catch: all -> 0x015d, TryCatch #4 {all -> 0x015d, blocks: (B:7:0x0013, B:41:0x001e, B:43:0x0033, B:53:0x0046, B:58:0x0051, B:60:0x008e, B:61:0x006d, B:63:0x0071, B:65:0x0077, B:66:0x008b, B:69:0x0091, B:71:0x0097, B:72:0x00a6, B:74:0x00ac, B:10:0x00cf, B:12:0x00e4, B:14:0x00ea, B:16:0x00f0, B:17:0x00fd, B:22:0x0125, B:25:0x0134, B:26:0x013a, B:28:0x0145, B:30:0x0149, B:32:0x0157, B:38:0x0119, B:80:0x00cb), top: B:6:0x0013, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0149 A[Catch: all -> 0x015d, TryCatch #4 {all -> 0x015d, blocks: (B:7:0x0013, B:41:0x001e, B:43:0x0033, B:53:0x0046, B:58:0x0051, B:60:0x008e, B:61:0x006d, B:63:0x0071, B:65:0x0077, B:66:0x008b, B:69:0x0091, B:71:0x0097, B:72:0x00a6, B:74:0x00ac, B:10:0x00cf, B:12:0x00e4, B:14:0x00ea, B:16:0x00f0, B:17:0x00fd, B:22:0x0125, B:25:0x0134, B:26:0x013a, B:28:0x0145, B:30:0x0149, B:32:0x0157, B:38:0x0119, B:80:0x00cb), top: B:6:0x0013, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0157 A[Catch: all -> 0x015d, TRY_LEAVE, TryCatch #4 {all -> 0x015d, blocks: (B:7:0x0013, B:41:0x001e, B:43:0x0033, B:53:0x0046, B:58:0x0051, B:60:0x008e, B:61:0x006d, B:63:0x0071, B:65:0x0077, B:66:0x008b, B:69:0x0091, B:71:0x0097, B:72:0x00a6, B:74:0x00ac, B:10:0x00cf, B:12:0x00e4, B:14:0x00ea, B:16:0x00f0, B:17:0x00fd, B:22:0x0125, B:25:0x0134, B:26:0x013a, B:28:0x0145, B:30:0x0149, B:32:0x0157, B:38:0x0119, B:80:0x00cb), top: B:6:0x0013, inners: #0, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LocalImageShootInfo createFromForVideo(String str, boolean z16) {
        GpsInfo4LocalImage gpsInfo4LocalImage;
        GpsInfo4LocalImage gpsInfo4LocalImage2;
        Iterator<String> it;
        String str2;
        Long l3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(23);
            if (extractMetadata != null) {
                try {
                    ArrayList arrayList = new ArrayList(3);
                    StringBuilder sb5 = new StringBuilder();
                    int i3 = 0;
                    for (char c16 : extractMetadata.toCharArray()) {
                        if (i3 >= 2) {
                            break;
                        }
                        if (c16 != '+' && c16 != '-' && c16 != '\n' && c16 != 0) {
                            if (!Character.isDigit(c16) && c16 != '.') {
                                QLog.e(TAG, 2, "Can not under stand the location string: " + extractMetadata + " !");
                            }
                            sb5.append(c16);
                        }
                        if (sb5.length() > 0) {
                            arrayList.add(Double.valueOf(Double.parseDouble(sb5.toString())));
                            sb5.setLength(0);
                            i3++;
                        }
                        sb5.append(c16);
                    }
                    if (sb5.length() > 0) {
                        arrayList.add(Double.valueOf(Double.parseDouble(sb5.toString())));
                    }
                    if (arrayList.size() >= 2) {
                        gpsInfo4LocalImage = new GpsInfo4LocalImage(((Double) arrayList.get(0)).floatValue(), ((Double) arrayList.get(1)).floatValue());
                    } else {
                        gpsInfo4LocalImage = null;
                    }
                    gpsInfo4LocalImage2 = gpsInfo4LocalImage;
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                }
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(5);
                Map<String, Function<String, String>> map = videoTimePattern;
                it = map.keySet().iterator();
                if (it.hasNext()) {
                    String next = it.next();
                    try {
                        if (map.get(next) != null) {
                            extractMetadata2 = map.get(next).apply(extractMetadata2);
                        }
                        Date parse = new SimpleDateFormat(next, Locale.getDefault()).parse(extractMetadata2);
                        Objects.requireNonNull(parse);
                        str2 = extractMetadata2;
                        l3 = Long.valueOf(parse.getTime());
                    } catch (Exception e17) {
                        QLog.e(TAG, 2, "createFromForVideo error parsing date: ", e17);
                    }
                    if (l3 == null && z16) {
                        try {
                            l3 = Long.valueOf(new File(str).lastModified());
                        } catch (Exception e18) {
                            QLog.e(TAG, 2, "createFromForVideo error parsing lastModified date: ", e18);
                        }
                    }
                    LocalImageShootInfo localImageShootInfo = new LocalImageShootInfo();
                    if (!TextUtils.isEmpty(str2)) {
                        localImageShootInfo.captureTimeString = str2;
                    }
                    if (l3 != null) {
                        localImageShootInfo.captureTime = l3.longValue();
                        localImageShootInfo.modifyTime = l3.longValue();
                    }
                    if (gpsInfo4LocalImage2 != null) {
                        localImageShootInfo.gpsInfo = gpsInfo4LocalImage2;
                    }
                    return localImageShootInfo;
                }
                str2 = extractMetadata2;
                l3 = null;
                if (l3 == null) {
                    l3 = Long.valueOf(new File(str).lastModified());
                }
                LocalImageShootInfo localImageShootInfo2 = new LocalImageShootInfo();
                if (!TextUtils.isEmpty(str2)) {
                }
                if (l3 != null) {
                }
                if (gpsInfo4LocalImage2 != null) {
                }
                return localImageShootInfo2;
            }
            gpsInfo4LocalImage2 = null;
            String extractMetadata22 = mediaMetadataRetriever.extractMetadata(5);
            Map<String, Function<String, String>> map2 = videoTimePattern;
            it = map2.keySet().iterator();
            if (it.hasNext()) {
            }
            str2 = extractMetadata22;
            l3 = null;
            if (l3 == null) {
            }
            LocalImageShootInfo localImageShootInfo22 = new LocalImageShootInfo();
            if (!TextUtils.isEmpty(str2)) {
            }
            if (l3 != null) {
            }
            if (gpsInfo4LocalImage2 != null) {
            }
            return localImageShootInfo22;
        } catch (Throwable th5) {
            try {
                QLog.e(TAG, 2, "createFromForVideo fail : " + th5.getMessage());
                return null;
            } finally {
                mediaMetadataRetriever.release();
            }
        }
    }

    public static GpsInfo4LocalImage getGpsInfoForVideo(MediaMetadataRetriever mediaMetadataRetriever, String str) {
        if (mediaMetadataRetriever == null || str == null) {
            return null;
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(23);
            if (extractMetadata != null) {
                try {
                    ArrayList arrayList = new ArrayList(3);
                    StringBuilder sb5 = new StringBuilder();
                    int i3 = 0;
                    for (char c16 : extractMetadata.toCharArray()) {
                        if (i3 >= 2) {
                            break;
                        }
                        if (c16 != '+' && c16 != '-' && c16 != '\n' && c16 != 0) {
                            if (!Character.isDigit(c16) && c16 != '.') {
                                QLog.e(TAG, 2, "Can not under stand the location string: " + extractMetadata + " !");
                            }
                            sb5.append(c16);
                        }
                        if (sb5.length() > 0) {
                            arrayList.add(Double.valueOf(Double.parseDouble(sb5.toString())));
                            sb5.setLength(0);
                            i3++;
                        }
                        sb5.append(c16);
                    }
                    if (sb5.length() > 0) {
                        arrayList.add(Double.valueOf(Double.parseDouble(sb5.toString())));
                    }
                    if (arrayList.size() >= 2) {
                        return new GpsInfo4LocalImage(((Double) arrayList.get(0)).floatValue(), ((Double) arrayList.get(1)).floatValue());
                    }
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                }
            }
        } finally {
            try {
            } finally {
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalImageShootInfo)) {
            return false;
        }
        LocalImageShootInfo localImageShootInfo = (LocalImageShootInfo) obj;
        if (this.captureTime != localImageShootInfo.captureTime || !this.gpsInfo.equals(localImageShootInfo)) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.captureTime);
        parcel.writeLong(this.modifyTime);
        parcel.writeString(this.path);
        parcel.writeString(this.captureTimeString);
        if (this.gpsInfo != null) {
            parcel.writeInt(1);
            this.gpsInfo.writeToParcel(parcel, i3);
        } else {
            parcel.writeInt(0);
        }
    }

    LocalImageShootInfo(String str) throws Exception {
        if (!TextUtils.isEmpty(str) && str.startsWith("file:///")) {
            str = str.replaceFirst("file://", "");
        }
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            this.path = file.getAbsolutePath();
            this.modifyTime = file.lastModified();
            return;
        }
        throw new Exception();
    }

    public static LocalImageShootInfo createFrom(String str) {
        return createFrom(str, true);
    }

    public LocalImageShootInfo(Parcel parcel) {
        this.captureTime = parcel.readLong();
        this.modifyTime = parcel.readLong();
        this.path = parcel.readString();
        this.captureTimeString = parcel.readString();
        if (parcel.readInt() != 0) {
            this.gpsInfo = new GpsInfo4LocalImage(parcel);
        }
    }
}
