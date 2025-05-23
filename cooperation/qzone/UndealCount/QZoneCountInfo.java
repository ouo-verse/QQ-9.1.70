package cooperation.qzone.UndealCount;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneCountInfo {
    private static final String TAG = "QZoneCountInfo";
    public String actPageAttach;
    public long cTime;
    public int countId;
    public boolean existDL;
    public long expireTime;
    public Map<String, String> ext;
    public ArrayList<QZoneCountUserInfo> friendList;
    public String friendMsg;
    public ArrayList<Long> friendUinList;
    public boolean hasShow;
    public int iControl;
    public int iShowLevel;
    public String iconUrl;
    public String pushMesssage;
    public String reportValue;
    public String schema;
    public String strShowMsg;
    public byte[] tianshuTrans;
    public int totalFriendUnread;
    public String trace_info;
    public long uCount;

    public QZoneCountInfo() {
        this(0, 0, new ArrayList(), "", "");
    }

    public static HashMap<Integer, QZoneCountInfo> createFromCursor(Cursor cursor) {
        boolean z16;
        boolean z17;
        Parcel obtain;
        if (cursor != null && !cursor.isClosed()) {
            HashMap<Integer, QZoneCountInfo> hashMap = new HashMap<>();
            while (cursor.moveToNext()) {
                QZoneCountInfo qZoneCountInfo = new QZoneCountInfo();
                int columnIndex = cursor.getColumnIndex("type");
                if (columnIndex >= 0) {
                    int i3 = cursor.getInt(columnIndex);
                    qZoneCountInfo.iControl = getIntSafely(cursor, "icontrol");
                    qZoneCountInfo.friendMsg = getStringSafely(cursor, "friendMsg");
                    qZoneCountInfo.uCount = getIntSafely(cursor, "ucount");
                    qZoneCountInfo.trace_info = getStringSafely(cursor, "trace_info");
                    qZoneCountInfo.totalFriendUnread = getIntSafely(cursor, "friendsNum");
                    qZoneCountInfo.friendList = new ArrayList<>();
                    byte[] blobSafely = getBlobSafely(cursor, "frienduins");
                    if (blobSafely != null && blobSafely.length != 0) {
                        obtain = Parcel.obtain();
                        try {
                            obtain.unmarshall(blobSafely, 0, blobSafely.length);
                            obtain.setDataPosition(0);
                            Parcelable[] readParcelableArray = obtain.readParcelableArray(QZoneCountUserInfo.class.getClassLoader());
                            if (readParcelableArray != null) {
                                for (Parcelable parcelable : readParcelableArray) {
                                    qZoneCountInfo.friendList.add((QZoneCountUserInfo) parcelable);
                                }
                            }
                        } finally {
                            try {
                                OaidMonitor.parcelRecycle(obtain);
                            } finally {
                            }
                        }
                        OaidMonitor.parcelRecycle(obtain);
                    }
                    if (getIntSafely(cursor, "existDL") == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    qZoneCountInfo.existDL = z16;
                    qZoneCountInfo.pushMesssage = getStringSafely(cursor, "pushMsg");
                    qZoneCountInfo.schema = getStringSafely(cursor, QZoneDTLoginReporter.SCHEMA);
                    qZoneCountInfo.iconUrl = getStringSafely(cursor, "iconUrl");
                    qZoneCountInfo.reportValue = getStringSafely(cursor, "reportValue");
                    qZoneCountInfo.strShowMsg = getStringSafely(cursor, "showMsg");
                    qZoneCountInfo.countId = getIntSafely(cursor, "countID");
                    qZoneCountInfo.cTime = getLongSafely(cursor, "cTime");
                    qZoneCountInfo.iShowLevel = getIntSafely(cursor, "iShowLevel");
                    if (getIntSafely(cursor, "hasShow") == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    qZoneCountInfo.hasShow = z17;
                    qZoneCountInfo.actPageAttach = getStringSafely(cursor, "actPageAttach");
                    qZoneCountInfo.tianshuTrans = getBlobSafely(cursor, "tianshuTrans");
                    qZoneCountInfo.expireTime = getLongSafely(cursor, "expireTime");
                    byte[] blobSafely2 = getBlobSafely(cursor, "ext");
                    if (blobSafely2 != null && blobSafely2.length != 0) {
                        obtain = Parcel.obtain();
                        try {
                            obtain.unmarshall(blobSafely2, 0, blobSafely2.length);
                            obtain.setDataPosition(0);
                            HashMap hashMap2 = new HashMap();
                            obtain.readMap(hashMap2, QZoneCountInfo.class.getClassLoader());
                            qZoneCountInfo.ext = hashMap2;
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                    hashMap.put(Integer.valueOf(i3), qZoneCountInfo);
                }
            }
            return hashMap;
        }
        return null;
    }

    private static byte[] getBlobSafely(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return cursor.getBlob(columnIndex);
        }
        return null;
    }

    private static int getIntSafely(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return cursor.getInt(columnIndex);
        }
        return 0;
    }

    private static long getLongSafely(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return cursor.getLong(columnIndex);
        }
        return 0L;
    }

    private static String getStringSafely(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }

    public ContentValues convertToContentValues() {
        byte[] bArr;
        ContentValues contentValues = new ContentValues(9);
        contentValues.put("icontrol", Integer.valueOf(this.iControl));
        contentValues.put("ucount", Long.valueOf(this.uCount));
        contentValues.put("friendsNum", Integer.valueOf(this.totalFriendUnread));
        Parcel obtain = Parcel.obtain();
        ArrayList<QZoneCountUserInfo> arrayList = this.friendList;
        if (arrayList != null) {
            obtain.writeParcelableArray((QZoneCountUserInfo[]) this.friendList.toArray(new QZoneCountUserInfo[arrayList.size()]), 0);
            bArr = obtain.marshall();
        } else {
            bArr = null;
        }
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put("frienduins", bArr);
        contentValues.put("friendMsg", this.friendMsg);
        contentValues.put("trace_info", this.trace_info);
        contentValues.put("existDL", Integer.valueOf(this.existDL ? 1 : 0));
        contentValues.put("pushMsg", this.pushMesssage);
        contentValues.put(QZoneDTLoginReporter.SCHEMA, this.schema);
        contentValues.put("iconUrl", this.iconUrl);
        contentValues.put("showMsg", this.strShowMsg);
        contentValues.put("reportValue", this.reportValue);
        contentValues.put("cTime", Long.valueOf(this.cTime));
        contentValues.put("iShowLevel", Integer.valueOf(this.iShowLevel));
        contentValues.put("hasShow", Integer.valueOf(this.hasShow ? 1 : 0));
        contentValues.put("actPageAttach", this.actPageAttach);
        contentValues.put("tianshuTrans", this.tianshuTrans);
        contentValues.put("expireTime", Long.valueOf(this.expireTime));
        if (this.ext != null) {
            Parcel obtain2 = Parcel.obtain();
            obtain2.writeMap(this.ext);
            contentValues.put("ext", obtain2.marshall());
            OaidMonitor.parcelRecycle(obtain2);
        }
        return contentValues;
    }

    public boolean equals(QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo == null) {
            return false;
        }
        String str = this.trace_info;
        if (str != null && !str.equals(qZoneCountInfo.trace_info)) {
            return false;
        }
        String str2 = qZoneCountInfo.trace_info;
        if (str2 != null && !str2.equals(this.trace_info)) {
            return false;
        }
        String str3 = this.pushMesssage;
        if (str3 != null && !str3.equals(qZoneCountInfo.pushMesssage)) {
            return false;
        }
        if (this.pushMesssage == null && qZoneCountInfo.pushMesssage != null) {
            return false;
        }
        String str4 = this.schema;
        if (str4 != null && !str4.equals(qZoneCountInfo.schema)) {
            return false;
        }
        if ((this.schema == null && qZoneCountInfo.schema != null) || this.countId != qZoneCountInfo.countId || !String.valueOf(this.actPageAttach).equals(String.valueOf(qZoneCountInfo.actPageAttach)) || !String.valueOf(this.iconUrl).equals(String.valueOf(qZoneCountInfo.iconUrl)) || !String.valueOf(this.strShowMsg).equals(String.valueOf(qZoneCountInfo.strShowMsg)) || !String.valueOf(this.reportValue).equals(String.valueOf(this.reportValue)) || this.cTime != qZoneCountInfo.cTime || this.uCount != qZoneCountInfo.uCount || !this.friendList.equals(qZoneCountInfo.friendList)) {
            return false;
        }
        return true;
    }

    public QZoneCountInfo(int i3, int i16, ArrayList<QZoneCountUserInfo> arrayList, String str, String str2) {
        this.schema = "";
        this.pushMesssage = "";
        this.cTime = 0L;
        this.iShowLevel = 0;
        this.hasShow = false;
        this.actPageAttach = "";
        this.tianshuTrans = null;
        this.expireTime = 0L;
        this.ext = null;
        this.uCount = i3;
        this.iControl = i16;
        this.friendList = arrayList;
        this.friendMsg = str;
        this.totalFriendUnread = 0;
        this.trace_info = str2;
    }

    public QZoneCountInfo(QZoneCountInfo qZoneCountInfo) {
        this.uCount = 0L;
        this.iControl = 0;
        this.schema = "";
        this.pushMesssage = "";
        this.cTime = 0L;
        this.iShowLevel = 0;
        this.hasShow = false;
        this.actPageAttach = "";
        this.tianshuTrans = null;
        this.expireTime = 0L;
        this.ext = null;
        this.uCount = qZoneCountInfo.uCount;
        this.iControl = qZoneCountInfo.iControl;
        ArrayList<QZoneCountUserInfo> arrayList = new ArrayList<>();
        this.friendList = arrayList;
        ArrayList<QZoneCountUserInfo> arrayList2 = qZoneCountInfo.friendList;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        this.friendMsg = qZoneCountInfo.friendMsg;
        this.totalFriendUnread = 0;
        this.pushMesssage = qZoneCountInfo.pushMesssage;
        this.schema = qZoneCountInfo.schema;
        this.trace_info = qZoneCountInfo.trace_info;
        this.iconUrl = qZoneCountInfo.iconUrl;
        this.countId = qZoneCountInfo.countId;
        this.actPageAttach = qZoneCountInfo.actPageAttach;
        this.tianshuTrans = qZoneCountInfo.tianshuTrans;
        this.expireTime = qZoneCountInfo.expireTime;
        this.strShowMsg = qZoneCountInfo.strShowMsg;
        this.reportValue = qZoneCountInfo.reportValue;
        this.cTime = qZoneCountInfo.cTime;
        this.iShowLevel = qZoneCountInfo.iShowLevel;
        this.hasShow = qZoneCountInfo.hasShow;
    }
}
