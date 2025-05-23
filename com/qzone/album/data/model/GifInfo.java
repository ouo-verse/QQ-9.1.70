package com.qzone.album.data.model;

import android.os.Environment;
import android.text.TextUtils;
import com.qzone.util.image.c;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GifInfo implements Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final String f43878d = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/DCIM/Qzone_gif/");
    public int delay;
    public boolean isBaseGif;
    public String mCombineImagePath;
    public String mDestPath;
    public String mDoodlePath;
    public String mOrignPath;
    public String mSavePath;
    public ArrayList<String> picsOrignPath;

    public GifInfo(String str, ArrayList<String> arrayList, String str2, String str3, int i3, boolean z16) {
        this.isBaseGif = true;
        this.mOrignPath = str;
        this.picsOrignPath = arrayList;
        this.mDoodlePath = str2;
        this.mCombineImagePath = str3;
        this.delay = i3;
        if (TextUtils.isEmpty(str) && arrayList != null && arrayList.size() > 0) {
            if (QZLog.isColorLevel()) {
                QZLog.d("GifInfo", 2, "picsOrignPath:" + arrayList.get(0) + "replace gifOrignPath:" + str);
            }
            this.mOrignPath = arrayList.get(0);
            this.isBaseGif = false;
        } else {
            this.mOrignPath = str;
            this.isBaseGif = true;
        }
        String str4 = f43878d;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (z16 && arrayList != null) {
            this.mSavePath = str4 + c.z(arrayList) + QzoneEmotionUtils.SIGN_ICON_URL_END;
        } else {
            this.mSavePath = str4 + System.currentTimeMillis() + QzoneEmotionUtils.SIGN_ICON_URL_END;
        }
        if (QZLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("gifOrignPath:");
            sb5.append(str);
            sb5.append(" doodlePath:");
            sb5.append(str2);
            sb5.append(" mCombineImagePath:");
            sb5.append(this.mCombineImagePath);
            sb5.append(" delay:");
            sb5.append(i3);
            sb5.append(" picsOrignPath size:");
            sb5.append(arrayList != null ? arrayList.size() : 0);
            QZLog.d("GifInfo", 2, sb5.toString());
        }
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            return (GifInfo) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
