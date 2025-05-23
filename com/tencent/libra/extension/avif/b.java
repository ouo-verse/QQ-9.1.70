package com.tencent.libra.extension.avif;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.delegate.ISoLoadDelegate;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWSoLoad;
import com.tencent.biz.richframework.util.RFWDeviceUtil;
import com.tencent.biz.richframework.util.RFWIOUtil;
import com.tencent.biz.richframework.util.RFWImageUtil;
import com.tencent.libavif.AvifDecoder;
import com.tencent.libavif.AvifFormat;
import com.tencent.libavif.AvifImage;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.h;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import com.tencent.libra.request.SizeFormat;
import com.tencent.libra.util.LibraConfigUtil;
import com.tencent.libra.util.RFWThumbnailUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b implements r01.a<Drawable> {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements ISoLoadDelegate.OnLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Consumer f118718a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExtraDecoderRequestInfo f118719b;

        a(Consumer consumer, ExtraDecoderRequestInfo extraDecoderRequestInfo) {
            this.f118718a = consumer;
            this.f118719b = extraDecoderRequestInfo;
        }

        @Override // com.tencent.biz.richframework.delegate.ISoLoadDelegate.OnLoadListener
        public void onLoadResult(boolean z16) {
            if (z16) {
                this.f118718a.accept(b.this.f(this.f118719b));
            } else {
                this.f118718a.accept(null);
                RFWLog.e("LibraAvifDecoder", RFWLog.USR, "handleDecode fail, because load so fail");
            }
        }
    }

    private static boolean e(InputStream inputStream) {
        if (RFWDeviceUtil.INSTANCE.isX86Emulator() && LibraConfigUtil.INSTANCE.disablePicLoaderAvifUseX86()) {
            RFWLog.d("LibraAvifDecoder", RFWLog.USR, "[canDecode] false: isX86Emulator");
            return false;
        }
        AvifFormat a16 = com.tencent.libra.extension.avif.a.a(inputStream);
        if (a16 == AvifFormat.FORMAT_AVIF) {
            RFWLog.d("LibraAvifDecoder", RFWLog.USR, "[canDecode] avif:true");
            return true;
        }
        if (a16 != AvifFormat.FORMAT_AVIS) {
            return false;
        }
        RFWLog.d("LibraAvifDecoder", RFWLog.USR, "[canDecode] avis:true");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable f(@NonNull ExtraDecoderRequestInfo extraDecoderRequestInfo) {
        int i3;
        int i16;
        Bitmap.Config config;
        boolean z16;
        try {
            byte[] convertInputStream2ByteArray = RFWIOUtil.convertInputStream2ByteArray(h.f118788a.a(extraDecoderRequestInfo.e(), extraDecoderRequestInfo.getSrcFile()));
            AvifDecoder c16 = AvifDecoder.c(convertInputStream2ByteArray);
            if (AvifDecoder.m(convertInputStream2ByteArray)) {
                return new LibraAvifSequenceDrawable(c16);
            }
            int n3 = c16.n();
            if (n3 != 0) {
                RFWLog.e("LibraAvifDecoder", RFWLog.USR, "[decodeAvif] return, decode image fail, code=", Integer.valueOf(n3), ", requestInfo=", extraDecoderRequestInfo);
                return null;
            }
            int l3 = c16.l();
            int f16 = c16.f();
            extraDecoderRequestInfo.c().put("origin_width", Integer.valueOf(l3));
            extraDecoderRequestInfo.c().put("origin_height", Integer.valueOf(f16));
            int width = extraDecoderRequestInfo.getWidth();
            int height = extraDecoderRequestInfo.getHeight();
            if (LibraConfigUtil.INSTANCE.enablePicLoaderAvifAdjustScale()) {
                float f17 = l3;
                float f18 = f16;
                float f19 = width;
                float f26 = height;
                if (extraDecoderRequestInfo.getSizeFormat() == SizeFormat.GE) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                float adjustScale = RFWThumbnailUtils.getAdjustScale(f17, f18, f19, f26, z16);
                if (adjustScale > 1.0f) {
                    adjustScale = 1.0f;
                }
                i3 = (int) Math.ceil(f17 * adjustScale);
                i16 = (int) Math.ceil(f18 * adjustScale);
            } else {
                int calculateInSampleSize = RFWImageUtil.calculateInSampleSize(l3, f16, width, height);
                i3 = l3 / calculateInSampleSize;
                i16 = f16 / calculateInSampleSize;
            }
            if (i3 > 0 && i16 > 0) {
                AvifImage k3 = c16.k(i3, i16);
                if (extraDecoderRequestInfo.getDecodeFormat() == DecodeFormat.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                return new BitmapDrawable(k3.c(com.tencent.libra.b.f118583a.a(extraDecoderRequestInfo.getBitmapPool(), i3, i16, config), false));
            }
            RFWLog.e("LibraAvifDecoder", RFWLog.USR, "[decodeAvif] return, scale invalid, srcWidth=", Integer.valueOf(l3), ", srcHeight=", Integer.valueOf(f16), ", width=", Integer.valueOf(width), ", height=", Integer.valueOf(height), ", requestInfo=", extraDecoderRequestInfo);
            return null;
        } catch (Exception e16) {
            RFWLog.e("LibraAvifDecoder", RFWLog.USR, "[decodeAvif] fail:", e16);
            return null;
        }
    }

    @Override // r01.a
    public boolean a(@NonNull File file) {
        try {
            return e(new FileInputStream(file));
        } catch (FileNotFoundException e16) {
            RFWLog.e("LibraAvifDecoder", RFWLog.USR, "[canDecode] error", e16);
            return false;
        }
    }

    @Override // r01.a
    public boolean b(@NonNull Model<?> model) {
        return e(model.c());
    }

    @Override // r01.a
    public void c(@NonNull ExtraDecoderRequestInfo extraDecoderRequestInfo, @NonNull Consumer<Drawable> consumer) {
        RFWSoLoad.load("avif", new a(consumer, extraDecoderRequestInfo));
    }

    @Override // r01.a
    public String getLogTag() {
        return "LibraAvifDecoder";
    }
}
