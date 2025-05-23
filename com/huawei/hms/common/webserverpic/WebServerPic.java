package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* loaded from: classes2.dex */
public class WebServerPic {
    public static final Parcelable.Creator<WebServerPic> CREATOR = new WebServerPicCreator();

    /* renamed from: a, reason: collision with root package name */
    private final Uri f36896a;

    /* renamed from: b, reason: collision with root package name */
    private final int f36897b;

    /* renamed from: c, reason: collision with root package name */
    private final int f36898c;

    public WebServerPic(Uri uri, int i3, int i16) throws IllegalArgumentException {
        this.f36896a = uri;
        this.f36897b = i3;
        this.f36898c = i16;
        if (uri == null) {
            throw new IllegalArgumentException("url is not able to be null");
        }
        if (i3 < 0 || i16 < 0) {
            throw new IllegalArgumentException("width and height should be positive or 0");
        }
    }

    public final int getHeight() {
        return this.f36898c;
    }

    public final Uri getUrl() {
        return this.f36896a;
    }

    public final int getWidth() {
        return this.f36897b;
    }

    public final String toString() {
        return String.format(Locale.ENGLISH, "Image %dx%d %s", Integer.valueOf(this.f36897b), Integer.valueOf(this.f36898c), this.f36896a.toString());
    }

    public final void writeToParcel(Parcel parcel, int i3) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUrl(), i3, false);
        SafeParcelWriter.writeInt(parcel, 2, getWidth());
        SafeParcelWriter.writeInt(parcel, 3, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public WebServerPic(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }
}
