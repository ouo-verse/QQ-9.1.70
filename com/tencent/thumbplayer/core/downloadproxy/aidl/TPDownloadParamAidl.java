package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPDownloadParamAidl implements Parcelable {
    public static final Parcelable.Creator<TPDownloadParamAidl> CREATOR = new Parcelable.Creator<TPDownloadParamAidl>() { // from class: com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TPDownloadParamAidl createFromParcel(Parcel parcel) {
            return new TPDownloadParamAidl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TPDownloadParamAidl[] newArray(int i3) {
            return new TPDownloadParamAidl[i3];
        }
    };
    private int dlType;
    private Map<String, Object> extInfoMap;
    private ArrayList<String> urlList;

    public TPDownloadParamAidl(ArrayList<String> arrayList, int i3, Map<String, Object> map) {
        this.urlList = arrayList;
        this.dlType = i3;
        this.extInfoMap = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDlType() {
        return this.dlType;
    }

    public Map<String, Object> getExtInfoMap() {
        return this.extInfoMap;
    }

    public ArrayList<String> getUrlList() {
        return this.urlList;
    }

    public void setDlType(int i3) {
        this.dlType = i3;
    }

    public void setExtInfoMap(Map<String, Object> map) {
        this.extInfoMap = map;
    }

    public void setUrlList(ArrayList<String> arrayList) {
        this.urlList = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeStringList(this.urlList);
        parcel.writeInt(this.dlType);
        parcel.writeMap(this.extInfoMap);
    }

    protected TPDownloadParamAidl(Parcel parcel) {
        try {
            this.urlList = parcel.createStringArrayList();
            this.dlType = parcel.readInt();
            this.extInfoMap = parcel.readHashMap(TPDownloadParamAidl.class.getClassLoader());
        } catch (Throwable th5) {
            TPDLProxyLog.e("TPDownloadParamAidl", 0, ITPDLProxyLogListener.COMMON_TAG, th5.toString());
            this.urlList = new ArrayList<>();
            this.dlType = 0;
            this.extInfoMap = new HashMap();
        }
    }
}
