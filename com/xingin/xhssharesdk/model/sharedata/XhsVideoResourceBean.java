package com.xingin.xhssharesdk.model.sharedata;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
@Keep
/* loaded from: classes28.dex */
public class XhsVideoResourceBean implements Parcelable {
    public static final Parcelable.Creator<XhsVideoResourceBean> CREATOR = new a();
    private static final String TAG = "XhsShare_XhsVideoResourceBean";

    @Nullable
    private String networkUrl;
    private Uri uri;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements Parcelable.Creator<XhsVideoResourceBean> {
        @Override // android.os.Parcelable.Creator
        public final XhsVideoResourceBean createFromParcel(Parcel parcel) {
            return new XhsVideoResourceBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final XhsVideoResourceBean[] newArray(int i3) {
            return new XhsVideoResourceBean[0];
        }
    }

    public XhsVideoResourceBean(Uri uri) {
        this.uri = uri;
    }

    public static XhsVideoResourceBean fromUrl(String str) {
        if (XhsShareSdkTools.isNetworkUrl(str)) {
            return new XhsVideoResourceBean(str);
        }
        return new XhsVideoResourceBean(new File(str));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getNetworkUrl() {
        return this.networkUrl;
    }

    public Uri getUri() {
        return this.uri;
    }

    public boolean isValid() {
        if (this.uri == null && TextUtils.isEmpty(this.networkUrl)) {
            return false;
        }
        return true;
    }

    public JSONObject toJsonForDeeplink() {
        JSONObject jSONObject = new JSONObject();
        Uri uri = this.uri;
        if (uri != null) {
            jSONObject.putOpt(LayoutAttrDefine.CLICK_URI, uri.toString());
        }
        if (!TextUtils.isEmpty(this.networkUrl)) {
            jSONObject.putOpt("url", this.networkUrl);
        }
        return jSONObject;
    }

    public String toString() {
        return "XhsVideoResourceBean{uri=" + this.uri + ", networkUrl='" + this.networkUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeParcelable(this.uri, i3);
        parcel.writeString(this.networkUrl);
    }

    public XhsVideoResourceBean(Parcel parcel) {
        try {
            this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.networkUrl = parcel.readString();
        } catch (Throwable th5) {
            XhsShareSdk.c(TAG, "XhsVideoResourceBean from Parcel error!", th5);
        }
    }

    public XhsVideoResourceBean(File file) {
        this.uri = Uri.fromFile(file);
    }

    XhsVideoResourceBean(String str) {
        this.networkUrl = str;
    }
}
