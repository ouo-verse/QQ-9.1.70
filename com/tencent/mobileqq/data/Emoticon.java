package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "eId,epId")
/* loaded from: classes10.dex */
public class Emoticon extends Entity implements Serializable {
    public static final int JOB_H5_MAGIC = 4;
    public static final int JOB_MAGIC = 2;
    public static final int JOB_NORMAL = 0;
    public static final int JOB_QFACE = 1;
    public static final int JOB_SMALL = 3;
    public static final int MEDIA_TYPE_H5_MAGIC = 3;
    public static final int MEDIA_TYPE_QFACE = 2;
    public static final int MEDIA_TYPE_SOUND = 1;
    private static final long serialVersionUID = 2994277280135415857L;
    public String backColor;
    public String businessExtra;
    public String character;
    public int clickNum;
    public String eId;
    public String encryptKey;
    public String epId;
    public int exposeNum;
    public int extensionHeight;
    public int extensionWidth;
    public int height;
    public String ipsiteName;
    public String ipsiteUrl;
    public boolean isAPNG = false;
    public boolean isSound;
    public int jobType;
    public String keyword;
    public String keywords;
    public String magicValue;
    public String name;
    public boolean value;
    public String voicePrint;

    @notColumn
    public List<Integer> voicePrintItems;
    public String volumeColor;
    public int width;

    public boolean equals(Object obj) {
        Emoticon emoticon;
        String str;
        String str2;
        if (obj == null || !(obj instanceof Emoticon) || (str = (emoticon = (Emoticon) obj).eId) == null || !str.equals(this.eId) || (str2 = emoticon.epId) == null || !str2.equals(this.epId)) {
            return false;
        }
        return true;
    }

    public String getMapKey() {
        return this.epId + "_" + this.eId;
    }

    public boolean hasEncryptKey() {
        return !TextUtils.isEmpty(this.encryptKey);
    }

    public void increaseClickNum() {
        int i3 = this.clickNum;
        if (i3 == Integer.MAX_VALUE) {
            return;
        }
        this.clickNum = i3 + 1;
    }

    public void increaseExposeNum() {
        int i3 = this.exposeNum;
        if (i3 == Integer.MAX_VALUE) {
            return;
        }
        this.exposeNum = i3 + 1;
    }

    public boolean isNewSoundEmoticon() {
        if (parseSoundPrintString() != null && !parseSoundPrintString().isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Integer> parseSoundPrintString() {
        List<Integer> list = this.voicePrintItems;
        if (list != null) {
            return list;
        }
        if (TextUtils.isEmpty(this.voicePrint)) {
            return null;
        }
        try {
            String[] split = this.voicePrint.split("\\|");
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
            this.voicePrintItems = arrayList;
            return arrayList;
        } catch (Exception e16) {
            QLog.e("Emoticon", 2, e16, new Object[0]);
            return null;
        }
    }

    public String toSoundPrintString() {
        if (!TextUtils.isEmpty(this.voicePrint)) {
            return this.voicePrint;
        }
        List<Integer> list = this.voicePrintItems;
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.voicePrintItems.size(); i3++) {
                sb5.append(this.voicePrintItems.get(i3));
                if (i3 != this.voicePrintItems.size() - 1) {
                    sb5.append("|");
                }
            }
            String sb6 = sb5.toString();
            this.voicePrint = sb6;
            return sb6;
        }
        return null;
    }
}
