package com.tencent.libra.listener;

import android.graphics.ImageDecoder;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.fd.HardwareConfigState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.libra.request.SizeFormat;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.libra.util.RFWThumbnailUtils;

/* compiled from: P */
@RequiresApi(api = 29)
/* loaded from: classes7.dex */
public final class LibraDefaultOnHeaderDecodedListener implements ImageDecoder.OnHeaderDecodedListener {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraDefaultOnHeaderDecodedListener");
    private final DecodeFormat decodeFormat;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final boolean isExifOrientationRequired;
    private final boolean isHardwareConfigAllowed;
    private final boolean mIsExplicitSize;
    private final Option mOption;
    private final int requestedHeight;
    private final int requestedWidth;
    private final SizeFormat sizeFormat;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements ImageDecoder.OnPartialImageListener {
        a() {
        }

        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
            LibraLogUtil.INSTANCE.i(LibraDefaultOnHeaderDecodedListener.TAG, RFWLog.USR, LibraDefaultOnHeaderDecodedListener.this.mOption, "[onHeaderDecoded] allow partial image", decodeException);
            return true;
        }
    }

    public LibraDefaultOnHeaderDecodedListener(@NonNull Option option) {
        boolean z16;
        this.mOption = option;
        this.mIsExplicitSize = option.isExplicitSize();
        this.requestedWidth = option.getRequestWidth();
        this.requestedHeight = option.getRequestHeight();
        this.decodeFormat = option.getDecodeFormat();
        this.isHardwareConfigAllowed = option.isAllowHardwareDecode();
        if (option.getRotationDegree() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isExifOrientationRequired = z16;
        this.sizeFormat = option.getSizeFormat();
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(@NonNull ImageDecoder imageDecoder, @NonNull ImageDecoder.ImageInfo imageInfo, @NonNull ImageDecoder.Source source) {
        Size size;
        String mimeType;
        int i3;
        boolean z16;
        size = imageInfo.getSize();
        int width = size.getWidth();
        int height = size.getHeight();
        Option option = this.mOption;
        mimeType = imageInfo.getMimeType();
        option.setFileType(RFWFileUtils.getFileTypeFromMime(mimeType));
        com.tencent.libra.util.a.f118813a.u(this.mOption, width, height);
        int i16 = this.requestedWidth;
        if (i16 > 0 && (i3 = this.requestedHeight) > 0 && (i16 < width || i3 < height)) {
            if (this.mIsExplicitSize) {
                width = i16;
                height = i3;
            } else {
                float width2 = size.getWidth();
                float height2 = size.getHeight();
                float f16 = this.requestedWidth;
                float f17 = this.requestedHeight;
                if (this.sizeFormat == SizeFormat.GE) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                float adjustScale = RFWThumbnailUtils.getAdjustScale(width2, height2, f16, f17, z16);
                width = (int) Math.ceil(size.getWidth() * adjustScale);
                height = (int) Math.ceil(adjustScale * size.getHeight());
            }
        }
        if (this.hardwareConfigState.isHardwareConfigAllowed(width, height, this.isHardwareConfigAllowed, this.isExifOrientationRequired)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.decodeFormat == DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        imageDecoder.setTargetSize(width, height);
    }
}
