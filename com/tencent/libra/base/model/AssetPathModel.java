package com.tencent.libra.base.model;

import android.app.Application;
import android.graphics.ImageDecoder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u01.a;
import u01.c;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0011\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/libra/base/model/AssetPathModel;", "Lcom/tencent/libra/base/model/Model;", "", "Landroid/graphics/ImageDecoder$Source;", "b", "Ljava/io/InputStream;", "c", "Lu01/c;", "e", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "path", "<init>", "(Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "libra-extension-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class AssetPathModel extends Model<String> {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/libra/base/model/AssetPathModel$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/libra/base/model/AssetPathModel;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/libra/base/model/AssetPathModel;", "<init>", "()V", "libra-extension-base_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.libra.base.model.AssetPathModel$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion implements Parcelable.Creator<AssetPathModel> {
        Companion() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AssetPathModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AssetPathModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AssetPathModel[] newArray(int size) {
            return new AssetPathModel[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetPathModel(@NotNull String path) {
        super(path);
        Intrinsics.checkNotNullParameter(path, "path");
    }

    @Override // com.tencent.libra.base.model.Model
    @RequiresApi(29)
    @NotNull
    public ImageDecoder.Source b() {
        ImageDecoder.Source createSource;
        Application application = RFWApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
        createSource = ImageDecoder.createSource(application.getAssets(), a());
        Intrinsics.checkNotNullExpressionValue(createSource, "ImageDecoder.createSourc\u2026lication().assets, get())");
        return createSource;
    }

    @Override // com.tencent.libra.base.model.Model
    @NotNull
    public InputStream c() {
        return new a(a()).a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.libra.base.model.Model
    @NotNull
    public c e() {
        return new a(a());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(a());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AssetPathModel(@NotNull Parcel parcel) {
        this(r2);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        Intrinsics.checkNotNullExpressionValue(readString, "parcel.readString()!!");
    }
}
