package cooperation.qzone.statistic.serverip;

import android.os.Parcel;
import android.os.Parcelable;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WebAppIpRecord implements Parcelable {
    public static final Parcelable.Creator<WebAppIpRecord> CREATOR = new Parcelable.Creator<WebAppIpRecord>() { // from class: cooperation.qzone.statistic.serverip.WebAppIpRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WebAppIpRecord createFromParcel(Parcel parcel) {
            return new WebAppIpRecord(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WebAppIpRecord[] newArray(int i3) {
            return new WebAppIpRecord[i3];
        }
    };
    public long serverChangeTime;
    public FixedSizeLinkedHashMap<Integer, Long> serverIpMap;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private static int MAX_ENTRIES = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_LATEST_WEBAPP_IP_COUNT, 3);
        private static final long serialVersionUID = 6918023506928428613L;

        public static int getMAX_ENTRIES() {
            return MAX_ENTRIES;
        }

        public static void setMAX_ENTRIES(int i3) {
            MAX_ENTRIES = i3;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            if (size() > MAX_ENTRIES) {
                return true;
            }
            return false;
        }
    }

    public WebAppIpRecord() {
    }

    public void addIpAdress(int i3) {
        if (i3 == 0) {
            return;
        }
        if (this.serverIpMap == null) {
            this.serverIpMap = new FixedSizeLinkedHashMap<>();
        }
        this.serverIpMap.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.serverChangeTime);
        parcel.writeMap(this.serverIpMap);
    }

    public WebAppIpRecord(Parcel parcel) {
        this.serverChangeTime = parcel.readLong();
        HashMap readHashMap = parcel.readHashMap(getClass().getClassLoader());
        FixedSizeLinkedHashMap<Integer, Long> fixedSizeLinkedHashMap = new FixedSizeLinkedHashMap<>();
        this.serverIpMap = fixedSizeLinkedHashMap;
        fixedSizeLinkedHashMap.putAll(readHashMap);
    }
}
