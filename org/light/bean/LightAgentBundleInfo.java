package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightAgentBundleInfo implements Parcelable {
    public static final Parcelable.Creator<LightAgentBundleInfo> CREATOR = new Parcelable.Creator<LightAgentBundleInfo>() { // from class: org.light.bean.LightAgentBundleInfo.1
        @Override // android.os.Parcelable.Creator
        public LightAgentBundleInfo createFromParcel(Parcel parcel) {
            return new LightAgentBundleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightAgentBundleInfo[] newArray(int i3) {
            return new LightAgentBundleInfo[i3];
        }
    };
    public String agentType;
    public String level;
    public Map<String, String> subAgentFolderConfigs;
    public Map<String, String> subAgentLevels;

    public LightAgentBundleInfo(String str, String str2, Object obj, Object obj2) {
        this.agentType = str;
        this.level = str2;
        this.subAgentFolderConfigs = (Map) obj;
        this.subAgentLevels = (Map) obj2;
    }

    public boolean containsAgentType(String str) {
        Map<String, String> map;
        if (!this.agentType.equals(str) && ((map = this.subAgentLevels) == null || !map.containsKey(str))) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAgentLevel(String str) {
        Map<String, String> map = this.subAgentLevels;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public boolean notValid() {
        return TextUtils.isEmpty(this.agentType);
    }

    public void setAgentLevel(String str, String str2) {
        if (this.agentType.equals(str)) {
            this.level = str2;
        }
        Map<String, String> map = this.subAgentLevels;
        if (map != null && map.containsKey(str)) {
            this.subAgentLevels.put(str, str2);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.agentType);
        parcel.writeString(this.level);
        parcel.writeMap(this.subAgentFolderConfigs);
        parcel.writeMap(this.subAgentLevels);
    }

    protected LightAgentBundleInfo(Parcel parcel) {
        this.agentType = parcel.readString();
        this.level = parcel.readString();
        this.subAgentFolderConfigs = parcel.readHashMap(getClass().getClassLoader());
        this.subAgentLevels = parcel.readHashMap(getClass().getClassLoader());
    }
}
