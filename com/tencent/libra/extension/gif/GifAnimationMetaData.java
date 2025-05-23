package com.tencent.libra.extension.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.tencent.libra.extension.gif.annotations.Beta;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Locale;
import kotlin.jvm.internal.CharCompanionObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GifAnimationMetaData implements Serializable, Parcelable {
    public static final Parcelable.Creator<GifAnimationMetaData> CREATOR = new a();
    private static final long serialVersionUID = 5692363926580237325L;
    private final int mDuration;
    private final int mHeight;
    private final int mImageCount;
    private final int mLoopCount;
    private final long mMetadataBytesCount;
    private final long mPixelsBytesCount;
    private final int mWidth;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Parcelable.Creator<GifAnimationMetaData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GifAnimationMetaData createFromParcel(Parcel parcel) {
            return new GifAnimationMetaData(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GifAnimationMetaData[] newArray(int i3) {
            return new GifAnimationMetaData[i3];
        }
    }

    /* synthetic */ GifAnimationMetaData(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getAllocationByteCount() {
        return this.mPixelsBytesCount;
    }

    @Beta
    public long getDrawableAllocationByteCount(@Nullable GifDrawable gifDrawable, @IntRange(from = 1, to = 65535) int i3) {
        int i16;
        if (i3 >= 1 && i3 <= 65535) {
            int i17 = i3 * i3;
            if (gifDrawable != null && !gifDrawable.f118727m.isRecycled()) {
                i16 = gifDrawable.f118727m.getAllocationByteCount();
            } else {
                i16 = ((this.mWidth * this.mHeight) * 4) / i17;
            }
            return (this.mPixelsBytesCount / i17) + i16;
        }
        throw new IllegalStateException("Sample size " + i3 + " out of range <1, " + CharCompanionObject.MAX_VALUE + ">");
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public long getMetadataAllocationByteCount() {
        return this.mMetadataBytesCount;
    }

    public int getNumberOfFrames() {
        return this.mImageCount;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isAnimated() {
        if (this.mImageCount > 1 && this.mDuration > 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        String num;
        int i3 = this.mLoopCount;
        if (i3 == 0) {
            num = "Infinity";
        } else {
            num = Integer.toString(i3);
        }
        String format = String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, loops: %s, duration: %d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mImageCount), num, Integer.valueOf(this.mDuration));
        if (isAnimated()) {
            return "Animated " + format;
        }
        return format;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mLoopCount);
        parcel.writeInt(this.mDuration);
        parcel.writeInt(this.mHeight);
        parcel.writeInt(this.mWidth);
        parcel.writeInt(this.mImageCount);
        parcel.writeLong(this.mMetadataBytesCount);
        parcel.writeLong(this.mPixelsBytesCount);
    }

    public GifAnimationMetaData(@NonNull Resources resources, @DrawableRes @RawRes int i3) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i3));
    }

    public GifAnimationMetaData(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public GifAnimationMetaData(@NonNull String str) throws IOException {
        this(new GifInfoHandle(str));
    }

    public GifAnimationMetaData(@NonNull File file) throws IOException {
        this(file.getPath());
    }

    public GifAnimationMetaData(@NonNull InputStream inputStream) throws IOException {
        this(new GifInfoHandle(inputStream));
    }

    public GifAnimationMetaData(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor));
    }

    public GifAnimationMetaData(@NonNull FileDescriptor fileDescriptor) throws IOException {
        this(new GifInfoHandle(fileDescriptor));
    }

    public GifAnimationMetaData(@NonNull byte[] bArr) throws IOException {
        this(new GifInfoHandle(bArr));
    }

    public GifAnimationMetaData(@NonNull ByteBuffer byteBuffer) throws IOException {
        this(new GifInfoHandle(byteBuffer));
    }

    public GifAnimationMetaData(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.u(contentResolver, uri));
    }

    GifAnimationMetaData(GifInfoHandle gifInfoHandle) {
        this.mLoopCount = gifInfoHandle.i();
        this.mDuration = gifInfoHandle.f();
        this.mWidth = gifInfoHandle.q();
        this.mHeight = gifInfoHandle.h();
        this.mImageCount = gifInfoHandle.m();
        this.mMetadataBytesCount = gifInfoHandle.j();
        this.mPixelsBytesCount = gifInfoHandle.b();
        gifInfoHandle.w();
    }

    GifAnimationMetaData(Parcel parcel) {
        this.mLoopCount = parcel.readInt();
        this.mDuration = parcel.readInt();
        this.mHeight = parcel.readInt();
        this.mWidth = parcel.readInt();
        this.mImageCount = parcel.readInt();
        this.mMetadataBytesCount = parcel.readLong();
        this.mPixelsBytesCount = parcel.readLong();
    }
}
