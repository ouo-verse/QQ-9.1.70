package com.tencent.libra.decode;

import android.widget.ImageView;
import com.tencent.libra.cache.Key;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraRequestKey implements Key {
    private final boolean mExplicitSize;
    private final int mHeight;
    private final boolean mIsNinePatch;
    private final Key mPathKey;
    private final ImageView.ScaleType mRegionScaleType;
    private final int mWith;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class Builder {
        private int mBitmapHeight;
        private int mBitmapWith;
        private boolean mExplicitSize;
        private boolean mIsNinePatch;
        private final Key mPathKey;
        private ImageView.ScaleType mRegionScaleType;

        public Builder(Key key) {
            this.mPathKey = key;
        }

        public LibraRequestKey build() {
            return new LibraRequestKey(this);
        }

        public Builder setExplicitSize(boolean z16) {
            this.mExplicitSize = z16;
            return this;
        }

        public Builder setNinePatch(boolean z16) {
            this.mIsNinePatch = z16;
            return this;
        }

        public Builder setRegionScaleType(ImageView.ScaleType scaleType) {
            this.mRegionScaleType = scaleType;
            return this;
        }

        public Builder setRequestHeight(int i3) {
            this.mBitmapHeight = i3;
            return this;
        }

        public Builder setRequestWith(int i3) {
            this.mBitmapWith = i3;
            return this;
        }
    }

    @Override // com.tencent.libra.cache.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LibraRequestKey libraRequestKey = (LibraRequestKey) obj;
        if (this.mExplicitSize == libraRequestKey.mExplicitSize && this.mWith == libraRequestKey.mWith && this.mHeight == libraRequestKey.mHeight && this.mIsNinePatch == libraRequestKey.mIsNinePatch && Objects.equals(this.mPathKey, libraRequestKey.mPathKey) && this.mRegionScaleType == libraRequestKey.mRegionScaleType) {
            return true;
        }
        return false;
    }

    public int getBitmapHeight() {
        return this.mHeight;
    }

    public int getBitmapWith() {
        return this.mWith;
    }

    public Key getPathKey() {
        return this.mPathKey;
    }

    public ImageView.ScaleType getRegionScaleType() {
        return this.mRegionScaleType;
    }

    @Override // com.tencent.libra.cache.Key
    public int hashCode() {
        return Objects.hash(this.mPathKey, Boolean.valueOf(this.mExplicitSize), Integer.valueOf(this.mWith), Integer.valueOf(this.mHeight), this.mRegionScaleType, Boolean.valueOf(this.mIsNinePatch));
    }

    public boolean isNinePatch() {
        return this.mIsNinePatch;
    }

    public String toString() {
        return "LibraRequestKey{mPathKey=" + this.mPathKey + ", mExplicitSize=" + this.mExplicitSize + ", mWith=" + this.mWith + ", mHeight=" + this.mHeight + ", mRegionScaleType=" + this.mRegionScaleType + ", mIsNinePatch=" + this.mIsNinePatch + "}";
    }

    LibraRequestKey(Builder builder) {
        this.mPathKey = builder.mPathKey;
        this.mExplicitSize = builder.mExplicitSize;
        this.mWith = builder.mBitmapWith;
        this.mHeight = builder.mBitmapHeight;
        this.mRegionScaleType = builder.mRegionScaleType;
        this.mIsNinePatch = builder.mIsNinePatch;
    }
}
