package cooperation.qzone.provider;

import android.text.TextUtils;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes28.dex */
public class LocalPhotoGroupData implements Serializable {
    private static final String KEY_LIST = "QzoneMsg_recommand_photo_list_";
    private static final String KEY_TITLE = "QzoneMsg_recommand_photo_key_";
    private static final String TAG = "[PhotoAlbum]LocalPhotoGroupData";
    public String capTime;
    public ArrayList<String> pathList = new ArrayList<>();
    public long startTime;
    public String title;
    public String unikey;

    public static LocalPhotoGroupData getLocalPhotoGroupDataFromSp(long j3) {
        QZLog.d(TAG, 1, "getLocalPhotoGroupDataFromSp... pushTime:", Long.valueOf(j3));
        String string = LocalMultiProcConfig.getString(KEY_TITLE + j3, "");
        String string2 = LocalMultiProcConfig.getString(KEY_LIST + j3, "");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            String[] split = string.split(";");
            if (split.length != 3) {
                QZLog.e(TAG, 1, "getLocalPhotoGroupDataFromSp... list.length != 3");
                return null;
            }
            LocalPhotoGroupData localPhotoGroupData = new LocalPhotoGroupData();
            localPhotoGroupData.unikey = split[0];
            localPhotoGroupData.title = split[1];
            localPhotoGroupData.capTime = split[2];
            String[] split2 = string2.split(";");
            for (int i3 = 0; i3 < split2.length; i3++) {
                if (new File(split2[i3]).exists()) {
                    localPhotoGroupData.pathList.add(split2[i3]);
                } else {
                    QZLog.w(TAG, 1, "getLocalPhotoGroupDataFromSp... not exist !! i:", Integer.valueOf(i3), " path:", split2[i3]);
                }
            }
            if (localPhotoGroupData.pathList.size() != 0) {
                QZLog.d(TAG, 1, "getLocalPhotoGroupDataFromSp... return localPhotoGroupData:", localPhotoGroupData.toString());
                return localPhotoGroupData;
            }
            QZLog.w(TAG, 1, "getLocalPhotoGroupDataFromSp... no photos");
            return null;
        }
        QZLog.e(TAG, 1, "getLocalPhotoGroupDataFromSp... key:", string, " pathlist:", string2);
        return null;
    }

    public void saveSp(long j3) {
        QZLog.d(TAG, 1, "saveSp... pushTime:", Long.valueOf(j3));
        if (j3 == 0) {
            QZLog.e(TAG, 1, "saveSp... pushTime == 0");
        }
        LocalMultiProcConfig.putString(KEY_TITLE + j3, this.unikey + ";" + this.title + ";" + this.capTime);
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.pathList.size(); i3++) {
            if (i3 == this.pathList.size() - 1) {
                sb5.append(this.pathList.get(i3));
            } else {
                sb5.append(this.pathList.get(i3));
                sb5.append(";");
            }
        }
        LocalMultiProcConfig.putString(KEY_LIST + j3, sb5.toString());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("LocalPhotoGroupData{");
        stringBuffer.append("unikey='");
        stringBuffer.append(this.unikey);
        stringBuffer.append('\'');
        stringBuffer.append(", title='");
        stringBuffer.append(this.title);
        stringBuffer.append('\'');
        stringBuffer.append(", capTime='");
        stringBuffer.append(this.capTime);
        stringBuffer.append('\'');
        stringBuffer.append(", startTime=");
        stringBuffer.append(this.startTime);
        stringBuffer.append(", pathList=");
        stringBuffer.append(this.pathList);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
