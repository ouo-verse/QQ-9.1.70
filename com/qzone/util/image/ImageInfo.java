package com.qzone.util.image;

import android.graphics.BitmapFactory;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.DecodeImageTask;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.util.XMPCoreUtil;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ImageInfo implements SmartParcelable {

    @NeedParcel
    public String mDescription;

    @NeedParcel
    public HashMap<String, Object> mExtraData;

    @NeedParcel
    public GpsInfo4LocalImage mGpsInfo;

    @NeedParcel
    public long mModifiedDate;

    @NeedParcel
    public String mName;

    @NeedParcel
    public String mPath;

    @NeedParcel
    public HashMap<String, String> mPhotoTagInfo;

    @NeedParcel
    public long mSize;

    @NeedParcel
    public String mimeType;

    @NeedParcel
    public int panoramaType;

    @NeedParcel
    public int photoHeight;

    @NeedParcel
    public int photoId;

    @NeedParcel
    public int photoOriginHeight;

    @NeedParcel
    public long photoOriginSize;

    @NeedParcel
    public int photoOriginWidth;

    @NeedParcel
    public int photoWidth;

    @NeedParcel
    public HashMap<String, byte[]> mExternalData = new HashMap<>();

    @NeedParcel
    public double uploadProbability = -1.0d;

    @NeedParcel
    public long duration = 0;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class InvalidImageException extends Exception {
        public InvalidImageException(String str) {
            super(str);
        }
    }

    public ImageInfo() {
    }

    private boolean compare(ImageInfo imageInfo) {
        return this.mName.equals(imageInfo.mName) && this.mSize == imageInfo.mSize && this.mModifiedDate == imageInfo.mModifiedDate && this.mPath.equals(imageInfo.mPath);
    }

    private void loadPanoramaInfo(String str) {
        if (str.startsWith("http") || str.startsWith("https")) {
            return;
        }
        if ((str.endsWith("jpg") || str.endsWith(MimeHelper.IMAGE_SUBTYPE_JPEG) || str.endsWith("png")) && this.panoramaType == 0) {
            XMPCoreUtil.getInstance().loadXMPCoreJarModule(new a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPanoramaType(int i3, int i16) {
        if (this.panoramaType != 0 || !((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).isNeedShowPanorama() || i3 == 0 || i16 == 0) {
            return;
        }
        if (i16 >= 1000 && i3 / i16 == 2.0f) {
            if (XMPCoreUtil.getInstance().isPanorama(this.mPath)) {
                this.panoramaType = 2;
                return;
            } else {
                this.panoramaType = 3;
                return;
            }
        }
        if (i16 >= 512 && i3 / i16 >= 4.0f) {
            this.panoramaType = 1;
        } else {
            this.panoramaType = 3;
        }
    }

    public int hashCode() {
        return (this.mName + this.mSize + this.mModifiedDate).hashCode();
    }

    public void setExternalData(String str, byte[] bArr) {
        if (this.mExternalData == null) {
            this.mExternalData = new HashMap<>();
        }
        this.mExternalData.put(str, bArr);
    }

    public String toString() {
        return "ImageInfo{mPath='" + this.mPath + "', mName='" + this.mName + "', mSize=" + this.mSize + ", mModifiedDate=" + this.mModifiedDate + ", mDescription='" + this.mDescription + "', photoId=" + this.photoId + ", uploadProbability=" + this.uploadProbability + ", panoramaType=" + this.panoramaType + ", duration=" + this.duration + ", photoWidth=" + this.photoWidth + ", photoHeight=" + this.photoHeight + ", mimeType='" + this.mimeType + "'}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements XMPCoreUtil.XMPCoreJarLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f59804a;

        a(String str) {
            this.f59804a = str;
        }

        @Override // cooperation.qzone.util.XMPCoreUtil.XMPCoreJarLoadListener
        public void loadState(boolean z16) {
            int intValue;
            ImageInfo imageInfo;
            int i3;
            int i16;
            if (z16) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                SafeBitmapFactory.decodeFile(this.f59804a, options);
                ImageInfo imageInfo2 = ImageInfo.this;
                imageInfo2.photoWidth = options.outWidth;
                imageInfo2.photoHeight = options.outHeight;
                j.e("ImageInfo", 4, "getPanoramaInfo photoWidth = " + ImageInfo.this.photoWidth + " photoHeight = " + ImageInfo.this.photoHeight);
                Integer imagePath2Rotation = DecodeImageTask.getImagePath2Rotation(this.f59804a);
                if (imagePath2Rotation == null) {
                    intValue = JpegExifReader.getRotationDegree(this.f59804a);
                    DecodeImageTask.putImagePath2Rotation(this.f59804a, intValue);
                } else {
                    intValue = imagePath2Rotation.intValue();
                }
                if ((intValue == 90 || intValue == 270) && (i3 = (imageInfo = ImageInfo.this).photoWidth) < (i16 = imageInfo.photoHeight)) {
                    imageInfo.setPanoramaType(i16, i3);
                    ImageInfo imageInfo3 = ImageInfo.this;
                    imageInfo3.photoWidth = options.outHeight;
                    imageInfo3.photoHeight = options.outWidth;
                    return;
                }
                ImageInfo imageInfo4 = ImageInfo.this;
                imageInfo4.setPanoramaType(imageInfo4.photoWidth, imageInfo4.photoHeight);
            }
        }
    }

    public static ImageInfo create(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return new ImageInfo(str, true);
        } catch (InvalidImageException e16) {
            j.d("ImageInfo", "create ImageInfo from path error.", e16);
            return null;
        }
    }

    public ImageInfo(String str) {
        File file = new File(str);
        this.mPath = file.getAbsolutePath();
        this.mName = file.getName();
        this.mSize = file.length();
        this.mModifiedDate = file.lastModified();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImageInfo)) {
            return false;
        }
        return compare((ImageInfo) obj);
    }

    public ImageInfo(String str, boolean z16) throws InvalidImageException {
        File file = new File(str);
        if (z16 && (!file.exists() || file.isDirectory())) {
            throw new InvalidImageException("image file not exist!");
        }
        this.mPath = file.getAbsolutePath();
        this.mName = file.getName();
        this.mSize = file.length();
        this.mModifiedDate = file.lastModified();
        loadPanoramaInfo(str);
    }
}
