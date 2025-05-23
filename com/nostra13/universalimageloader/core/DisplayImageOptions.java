package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DisplayImageOptions {
    private final boolean cacheInMemory;
    private final boolean cacheOnDisk;
    private final boolean considerExifParams;
    private final BitmapFactory.Options decodingOptions;
    private final int delayBeforeLoading;
    private final BitmapDisplayer displayer;
    private final Object extraForDownloader;
    private final Handler handler;
    private final Drawable imageForEmptyUri;
    private final Drawable imageOnFail;
    private final Drawable imageOnLoading;
    private final int imageResForEmptyUri;
    private final int imageResOnFail;
    private final int imageResOnLoading;
    private final ImageScaleType imageScaleType;
    private final boolean isSyncLoading;
    private final BitmapProcessor postProcessor;
    private final BitmapProcessor preProcessor;
    private final boolean resetViewBeforeLoading;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private int imageResOnLoading = 0;
        private int imageResForEmptyUri = 0;
        private int imageResOnFail = 0;
        private Drawable imageOnLoading = null;
        private Drawable imageForEmptyUri = null;
        private Drawable imageOnFail = null;
        private boolean resetViewBeforeLoading = false;
        private boolean cacheInMemory = false;
        private boolean cacheOnDisk = false;
        private ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
        private int delayBeforeLoading = 0;
        private boolean considerExifParams = false;
        private Object extraForDownloader = null;
        private BitmapProcessor preProcessor = null;
        private BitmapProcessor postProcessor = null;
        private BitmapDisplayer displayer = DefaultConfigurationFactory.createBitmapDisplayer();
        private Handler handler = null;
        private boolean isSyncLoading = false;

        public Builder bitmapConfig(Bitmap.Config config) {
            if (config != null) {
                this.decodingOptions.inPreferredConfig = config;
                return this;
            }
            throw new IllegalArgumentException("bitmapConfig can't be null");
        }

        public DisplayImageOptions build() {
            return new DisplayImageOptions(this);
        }

        @Deprecated
        public Builder cacheInMemory() {
            this.cacheInMemory = true;
            return this;
        }

        @Deprecated
        public Builder cacheOnDisc() {
            return cacheOnDisk(true);
        }

        public Builder cacheOnDisk(boolean z16) {
            this.cacheOnDisk = z16;
            return this;
        }

        public Builder cloneFrom(DisplayImageOptions displayImageOptions) {
            this.imageResOnLoading = displayImageOptions.imageResOnLoading;
            this.imageResForEmptyUri = displayImageOptions.imageResForEmptyUri;
            this.imageResOnFail = displayImageOptions.imageResOnFail;
            this.imageOnLoading = displayImageOptions.imageOnLoading;
            this.imageForEmptyUri = displayImageOptions.imageForEmptyUri;
            this.imageOnFail = displayImageOptions.imageOnFail;
            this.resetViewBeforeLoading = displayImageOptions.resetViewBeforeLoading;
            this.cacheInMemory = displayImageOptions.cacheInMemory;
            this.cacheOnDisk = displayImageOptions.cacheOnDisk;
            this.imageScaleType = displayImageOptions.imageScaleType;
            this.decodingOptions = displayImageOptions.decodingOptions;
            this.delayBeforeLoading = displayImageOptions.delayBeforeLoading;
            this.considerExifParams = displayImageOptions.considerExifParams;
            this.extraForDownloader = displayImageOptions.extraForDownloader;
            this.preProcessor = displayImageOptions.preProcessor;
            this.postProcessor = displayImageOptions.postProcessor;
            this.displayer = displayImageOptions.displayer;
            this.handler = displayImageOptions.handler;
            this.isSyncLoading = displayImageOptions.isSyncLoading;
            return this;
        }

        public Builder considerExifParams(boolean z16) {
            this.considerExifParams = z16;
            return this;
        }

        public Builder decodingOptions(BitmapFactory.Options options) {
            if (options != null) {
                this.decodingOptions = options;
                return this;
            }
            throw new IllegalArgumentException("decodingOptions can't be null");
        }

        public Builder delayBeforeLoading(int i3) {
            this.delayBeforeLoading = i3;
            return this;
        }

        public Builder displayer(BitmapDisplayer bitmapDisplayer) {
            if (bitmapDisplayer != null) {
                this.displayer = bitmapDisplayer;
                return this;
            }
            throw new IllegalArgumentException("displayer can't be null");
        }

        public Builder extraForDownloader(Object obj) {
            this.extraForDownloader = obj;
            return this;
        }

        public Builder handler(Handler handler) {
            this.handler = handler;
            return this;
        }

        public Builder imageScaleType(ImageScaleType imageScaleType) {
            this.imageScaleType = imageScaleType;
            return this;
        }

        public Builder postProcessor(BitmapProcessor bitmapProcessor) {
            this.postProcessor = bitmapProcessor;
            return this;
        }

        public Builder preProcessor(BitmapProcessor bitmapProcessor) {
            this.preProcessor = bitmapProcessor;
            return this;
        }

        public Builder resetViewBeforeLoading() {
            this.resetViewBeforeLoading = true;
            return this;
        }

        public Builder showImageForEmptyUri(int i3) {
            this.imageResForEmptyUri = i3;
            return this;
        }

        public Builder showImageOnFail(int i3) {
            this.imageResOnFail = i3;
            return this;
        }

        public Builder showImageOnLoading(int i3) {
            this.imageResOnLoading = i3;
            return this;
        }

        @Deprecated
        public Builder showStubImage(int i3) {
            this.imageResOnLoading = i3;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder syncLoading(boolean z16) {
            this.isSyncLoading = z16;
            return this;
        }

        public Builder cacheInMemory(boolean z16) {
            this.cacheInMemory = z16;
            return this;
        }

        @Deprecated
        public Builder cacheOnDisc(boolean z16) {
            return cacheOnDisk(z16);
        }

        public Builder resetViewBeforeLoading(boolean z16) {
            this.resetViewBeforeLoading = z16;
            return this;
        }

        public Builder showImageForEmptyUri(Drawable drawable) {
            this.imageForEmptyUri = drawable;
            return this;
        }

        public Builder showImageOnFail(Drawable drawable) {
            this.imageOnFail = drawable;
            return this;
        }

        public Builder showImageOnLoading(Drawable drawable) {
            this.imageOnLoading = drawable;
            return this;
        }
    }

    public static DisplayImageOptions createSimple() {
        return new Builder().build();
    }

    public BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }

    public int getDelayBeforeLoading() {
        return this.delayBeforeLoading;
    }

    public BitmapDisplayer getDisplayer() {
        return this.displayer;
    }

    public Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public Drawable getImageForEmptyUri(Resources resources) {
        int i3 = this.imageResForEmptyUri;
        if (i3 != 0) {
            return resources.getDrawable(i3);
        }
        return this.imageForEmptyUri;
    }

    public Drawable getImageOnFail(Resources resources) {
        int i3 = this.imageResOnFail;
        if (i3 != 0) {
            return resources.getDrawable(i3);
        }
        return this.imageOnFail;
    }

    public Drawable getImageOnLoading(Resources resources) {
        int i3 = this.imageResOnLoading;
        if (i3 != 0) {
            return resources.getDrawable(i3);
        }
        return this.imageOnLoading;
    }

    public ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public BitmapProcessor getPostProcessor() {
        return this.postProcessor;
    }

    public BitmapProcessor getPreProcessor() {
        return this.preProcessor;
    }

    public boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    public boolean isCacheOnDisk() {
        return this.cacheOnDisk;
    }

    public boolean isConsiderExifParams() {
        return this.considerExifParams;
    }

    public boolean isResetViewBeforeLoading() {
        return this.resetViewBeforeLoading;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSyncLoading() {
        return this.isSyncLoading;
    }

    public boolean shouldDelayBeforeLoading() {
        if (this.delayBeforeLoading > 0) {
            return true;
        }
        return false;
    }

    public boolean shouldPostProcess() {
        if (this.postProcessor != null) {
            return true;
        }
        return false;
    }

    public boolean shouldPreProcess() {
        if (this.preProcessor != null) {
            return true;
        }
        return false;
    }

    public boolean shouldShowImageForEmptyUri() {
        if (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) {
            return false;
        }
        return true;
    }

    public boolean shouldShowImageOnFail() {
        if (this.imageOnFail == null && this.imageResOnFail == 0) {
            return false;
        }
        return true;
    }

    public boolean shouldShowImageOnLoading() {
        if (this.imageOnLoading == null && this.imageResOnLoading == 0) {
            return false;
        }
        return true;
    }

    DisplayImageOptions(Builder builder) {
        this.imageResOnLoading = builder.imageResOnLoading;
        this.imageResForEmptyUri = builder.imageResForEmptyUri;
        this.imageResOnFail = builder.imageResOnFail;
        this.imageOnLoading = builder.imageOnLoading;
        this.imageForEmptyUri = builder.imageForEmptyUri;
        this.imageOnFail = builder.imageOnFail;
        this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
        this.cacheInMemory = builder.cacheInMemory;
        this.cacheOnDisk = builder.cacheOnDisk;
        this.imageScaleType = builder.imageScaleType;
        this.decodingOptions = builder.decodingOptions;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.considerExifParams = builder.considerExifParams;
        this.extraForDownloader = builder.extraForDownloader;
        this.preProcessor = builder.preProcessor;
        this.postProcessor = builder.postProcessor;
        this.displayer = builder.displayer;
        this.handler = builder.handler;
        this.isSyncLoading = builder.isSyncLoading;
    }
}
