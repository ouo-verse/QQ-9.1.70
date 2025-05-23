package com.tencent.gdtad.aditem;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.raft.codegenmeta.utils.Constants;
import cooperation.qzone.util.QZLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtBaseAdItem implements Parcelable {
    public static final Parcelable.Creator<GdtBaseAdItem> CREATOR = new a();
    public static final String NEED_AUTO_DOWNLOAD = "1";
    public boolean autoDownLoad;

    @Nullable
    public Class clz;

    @Nullable
    public String deepLinkUrl;

    @Nullable
    public String downloadScheme;

    @Nullable
    public Bundle extra;
    public boolean openmain;

    @Nullable
    public String packageName;

    @Nullable
    public String productId;

    @Nullable
    public String traceId;

    @Nullable
    public String urlForClick;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<GdtBaseAdItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GdtBaseAdItem createFromParcel(@NonNull Parcel parcel) {
            return new GdtBaseAdItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GdtBaseAdItem[] newArray(int i3) {
            return new GdtBaseAdItem[i3];
        }
    }

    public GdtBaseAdItem(String str, String str2, String str3, String str4, String str5, boolean z16, Class cls, boolean z17, Bundle bundle) {
        this.openmain = false;
        this.packageName = str;
        this.downloadScheme = str2;
        this.deepLinkUrl = str3;
        this.traceId = str4;
        this.productId = str5;
        this.autoDownLoad = z16;
        this.clz = cls;
        this.extra = bundle;
    }

    @NonNull
    public static GdtBaseAdItem obtain(@NonNull String str) {
        Class<?> cls;
        GdtBaseAdItem gdtBaseAdItem = new GdtBaseAdItem();
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                cls = Class.forName(jSONObject.optString(Constants.Service.CLASS));
            } catch (Exception e16) {
                QZLog.w(e16);
                cls = null;
            }
            gdtBaseAdItem.setPackageName(jSONObject.optString("packageName")).setTraceId(jSONObject.optString("traceId")).setDeepLinkUrl(jSONObject.optString("invokeUrl")).setDownloadScheme(jSONObject.optString("appDownloadSchema")).setProductId(jSONObject.optString("productId")).setClz(cls).setUrlForClick(jSONObject.optString("urlForClick")).setAutoDownLoad("1".equals(jSONObject.optString(VirtualAppProxy.KEY_AUTO_DOWNLOAD)));
            String optString = jSONObject.optString("pkg_name");
            if (!TextUtils.isEmpty(optString)) {
                gdtBaseAdItem.setPackageName(optString);
            }
        } catch (Exception unused) {
        }
        return gdtBaseAdItem;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public GdtBaseAdItem setAutoDownLoad(boolean z16) {
        this.autoDownLoad = z16;
        return this;
    }

    @NonNull
    public GdtBaseAdItem setClz(Class cls) {
        this.clz = cls;
        return this;
    }

    @NonNull
    public GdtBaseAdItem setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
        return this;
    }

    @NonNull
    public GdtBaseAdItem setDownloadScheme(String str) {
        this.downloadScheme = str;
        return this;
    }

    @NonNull
    public GdtBaseAdItem setExtra(Bundle bundle) {
        this.extra = bundle;
        return this;
    }

    @NonNull
    public GdtBaseAdItem setPackageName(String str) {
        this.packageName = str;
        return this;
    }

    @NonNull
    public GdtBaseAdItem setProductId(String str) {
        this.productId = str;
        return this;
    }

    @NonNull
    public GdtBaseAdItem setTraceId(String str) {
        this.traceId = str;
        return this;
    }

    @NonNull
    public GdtBaseAdItem setUrlForClick(String str) {
        this.urlForClick = str;
        return this;
    }

    @NonNull
    public String toString() {
        return "GdtBaseAdItem|" + this.packageName + "\n" + this.downloadScheme + "\n" + this.deepLinkUrl + "\n" + this.traceId + "\n" + this.productId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeString(this.packageName);
        parcel.writeString(this.downloadScheme);
        parcel.writeString(this.deepLinkUrl);
        parcel.writeString(this.traceId);
        parcel.writeString(this.productId);
        parcel.writeByte(this.autoDownLoad ? (byte) 1 : (byte) 0);
        parcel.writeSerializable(this.clz);
        parcel.writeByte(this.openmain ? (byte) 1 : (byte) 0);
        parcel.writeString(this.urlForClick);
        parcel.writeBundle(this.extra);
    }

    GdtBaseAdItem() {
        this.openmain = false;
    }

    protected GdtBaseAdItem(@NonNull Parcel parcel) {
        this.openmain = false;
        this.packageName = parcel.readString();
        this.downloadScheme = parcel.readString();
        this.deepLinkUrl = parcel.readString();
        this.traceId = parcel.readString();
        this.productId = parcel.readString();
        this.autoDownLoad = parcel.readByte() != 0;
        this.clz = (Class) parcel.readSerializable();
        this.openmain = parcel.readByte() != 0;
        this.urlForClick = parcel.readString();
        this.extra = parcel.readBundle(GdtBaseAdItem.class.getClassLoader());
    }

    @NonNull
    public static GdtBaseAdItem obtain() {
        return new GdtBaseAdItem();
    }
}
