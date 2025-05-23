package com.tencent.tavmovie.resource;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovieImageResource extends TAVMovieResource {

    @NonNull
    private final String filePath;

    @Nullable
    private CIImage image;

    public TAVMovieImageResource(@NonNull String str) {
        this(str, null);
    }

    @Override // com.tencent.tavmovie.resource.TAVMovieResource
    public TAVResource convertToResource() {
        TAVResource tAVImageTrackResource;
        CIImage cIImage = this.image;
        if (cIImage != null) {
            tAVImageTrackResource = new TAVImageResource(cIImage, this.duration);
        } else {
            tAVImageTrackResource = new TAVImageTrackResource(this.filePath, this.duration);
        }
        CMTimeRange cMTimeRange = this.timeRange;
        if (cMTimeRange != null && cMTimeRange.getDurationUs() > 0) {
            tAVImageTrackResource.setSourceTimeRange(this.timeRange);
        }
        return tAVImageTrackResource;
    }

    @Override // com.tencent.tavmovie.resource.TAVMovieResource
    public TAVMovieResource dataClone() {
        return mo280clone();
    }

    public String getFilePath() {
        return this.filePath;
    }

    public CIImage getImage() {
        return this.image;
    }

    public void release() {
        CIImage cIImage = this.image;
        if (cIImage != null) {
            cIImage.release();
        }
    }

    public void setImage(CIImage cIImage) {
        this.image = cIImage;
    }

    public TAVMovieImageResource(@NonNull String str, CGSize cGSize) {
        this(str, cGSize, true);
    }

    public TAVMovieImageResource(@NonNull String str, CGSize cGSize, boolean z16) {
        this.filePath = str;
        if (!z16) {
            this.image = new CIImage(str, cGSize);
            this.naturalSize = new CGSize(this.image.getSize().width, this.image.getSize().height);
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            this.naturalSize = new CGSize(options.outWidth, options.outHeight);
        }
        this.duration = new CMTime(1L, 30);
    }

    @Override // com.tencent.tavmovie.resource.TAVMovieResource
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVMovieImageResource mo280clone() {
        TAVMovieImageResource tAVMovieImageResource = new TAVMovieImageResource(this.filePath);
        tAVMovieImageResource.setImage(this.image);
        tAVMovieImageResource.cloneFrom(this);
        return tAVMovieImageResource;
    }
}
