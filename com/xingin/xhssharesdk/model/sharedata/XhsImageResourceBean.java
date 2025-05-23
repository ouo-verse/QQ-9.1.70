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
public class XhsImageResourceBean implements Parcelable {
    public static final Parcelable.Creator<XhsImageResourceBean> CREATOR = new a();
    private static final String TAG = "XhsShare_XhsImageResourceBean";

    @Nullable
    private String networkUrl;

    @Nullable
    private Uri uri;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements Parcelable.Creator<XhsImageResourceBean> {
        @Override // android.os.Parcelable.Creator
        public final XhsImageResourceBean createFromParcel(Parcel parcel) {
            return new XhsImageResourceBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final XhsImageResourceBean[] newArray(int i3) {
            return new XhsImageResourceBean[i3];
        }
    }

    public XhsImageResourceBean(@Nullable Uri uri) {
        this.uri = uri;
    }

    public static XhsImageResourceBean fromUrl(String str) {
        if (XhsShareSdkTools.isNetworkUrl(str)) {
            return new XhsImageResourceBean(str);
        }
        return new XhsImageResourceBean(new File(str));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getNetworkUrl() {
        return this.networkUrl;
    }

    @Nullable
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
        return "XhsImageResourceBean{uri=" + this.uri + ", networkUrl='" + this.networkUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeParcelable(this.uri, i3);
        parcel.writeString(this.networkUrl);
    }

    public XhsImageResourceBean(Parcel parcel) {
        try {
            this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.networkUrl = parcel.readString();
        } catch (Throwable th5) {
            XhsShareSdk.c(TAG, "XhsImageResourceBean from Parcel error!", th5);
        }
    }

    public XhsImageResourceBean(File file) {
        this(Uri.fromFile(file));
    }

    XhsImageResourceBean(String str) {
        this.networkUrl = str;
    }
}
