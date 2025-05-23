package d11;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.core.util.Pair;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.gif.SharpPNewGifDecoder;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import com.tencent.libra.util.RFWThumbnailUtils;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPDecoder;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a implements r01.a<Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f392645a = new AtomicBoolean(false);

    /* compiled from: P */
    /* renamed from: d11.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C10152a implements OnLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExtraDecoderRequestInfo f392646a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Consumer f392647b;

        C10152a(ExtraDecoderRequestInfo extraDecoderRequestInfo, Consumer consumer) {
            this.f392646a = extraDecoderRequestInfo;
            this.f392647b = consumer;
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            if (i3 == 0) {
                a.this.f392645a.set(true);
                a.this.k(this.f392646a, this.f392647b);
            } else {
                this.f392647b.accept(null);
            }
        }
    }

    private static Pair<Integer, Integer> f(SharpPDecoder sharpPDecoder, int i3, int i16) {
        SharpPDecoder.SharpPFeature sharpPFeature;
        if (sharpPDecoder != null && (sharpPFeature = sharpPDecoder.mFeatureInfo) != null && sharpPFeature.width > 0 && sharpPFeature.height > 0) {
            if (ViewUtils.getScreenWidth() > 0 && ViewUtils.getScreenHeight() > 0) {
                SharpPDecoder.SharpPFeature sharpPFeature2 = sharpPDecoder.mFeatureInfo;
                float f16 = sharpPFeature2.width;
                float f17 = sharpPFeature2.height;
                float adjustScale = RFWThumbnailUtils.getAdjustScale(f16, f17, i3, i16, true);
                int i17 = (int) (f16 * adjustScale);
                int i18 = (int) (adjustScale * f17);
                float i19 = i(i17);
                float h16 = h(i18);
                if (i19 > 1.0f || h16 > 1.0f) {
                    if (i19 > 1.0f && h16 <= 1.0f) {
                        i17 = ViewUtils.getScreenWidth();
                    } else if (i19 <= 1.0f && h16 > 1.0f) {
                        i17 = (int) (i17 / h16);
                        i18 = ViewUtils.getScreenHeight();
                    } else {
                        i19 = Math.max(i19, h16);
                        i17 = (int) (i17 / i19);
                    }
                    i18 = (int) (i18 / i19);
                }
                return new Pair<>(Integer.valueOf(i17), Integer.valueOf(i18));
            }
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public static Drawable g(String str, int i3, int i16) {
        SharpPDecoder sharpPDecoder = new SharpPDecoder();
        int parseHeader = sharpPDecoder.parseHeader(str);
        if (parseHeader != 0) {
            QLog.e("LibraSharpPDecoder", 1, "status: " + parseHeader);
            return null;
        }
        int sharpPType = sharpPDecoder.getSharpPType();
        Pair<Integer, Integer> f16 = f(sharpPDecoder, i3, i16);
        int intValue = f16.first.intValue();
        int intValue2 = f16.second.intValue();
        if (3 != sharpPType && 4 != sharpPType) {
            if (i3 <= 0) {
                i3 = intValue;
            }
            if (i3 <= 0) {
                QLog.e("LibraSharpPDecoder", 1, "final width is less than 0");
                return null;
            }
            l(sharpPDecoder, str, i3);
            return new BitmapDrawable(sharpPDecoder.decodeSharpP2PNG2(str, 4, i3));
        }
        if (intValue > 0 && intValue2 > 0) {
            return new NewGifDrawable(new SharpPNewGifDecoder(str, intValue, intValue2));
        }
        QLog.e("LibraSharpPDecoder", 1, "expectedWidth or expectedHeight is less than 0");
        return null;
    }

    private static float h(int i3) {
        return i3 / ViewUtils.getScreenHeight();
    }

    private static float i(int i3) {
        return i3 / ViewUtils.getScreenWidth();
    }

    public static boolean j(InputStream inputStream) {
        if (inputStream == null) {
            return false;
        }
        byte[] bArr = new byte[6];
        try {
            try {
                inputStream.read(bArr);
                inputStream.close();
                String str = new String(bArr);
                Log.d(SharpPUtil.TAG, "fileTag: " + str);
                return str.equals("SHARPP");
            } finally {
            }
        } catch (IOException e16) {
            QLog.e("LibraSharpPDecoder", 1, "[isSharpPFile] Exception", e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(@NonNull ExtraDecoderRequestInfo extraDecoderRequestInfo, @NonNull Consumer<Drawable> consumer) {
        consumer.accept(g(extraDecoderRequestInfo.getSrcFile().getAbsolutePath(), extraDecoderRequestInfo.getWidth(), extraDecoderRequestInfo.getHeight()));
    }

    private static void l(@NonNull SharpPDecoder sharpPDecoder, String str, int i3) {
        if (sharpPDecoder.CreateDecoder2(str) == 0) {
            QLog.e("LibraSharpPDecoder", 1, "decoder is 0L");
            return;
        }
        SharpPDecoder.SharpPFeature sharpPFeature = sharpPDecoder.mFeatureInfo;
        if (sharpPFeature == null) {
            QLog.e("LibraSharpPDecoder", 1, "feature info is null");
        } else {
            int i16 = sharpPFeature.width;
            int i17 = sharpPFeature.height;
        }
    }

    @Override // r01.a
    public boolean a(@NonNull File file) {
        return SharpPUtil.isSharpPFile(file);
    }

    @Override // r01.a
    public boolean b(@NonNull Model<?> model) {
        return j(model.c());
    }

    @Override // r01.a
    public void c(@NonNull ExtraDecoderRequestInfo extraDecoderRequestInfo, @NonNull Consumer<Drawable> consumer) {
        if (!this.f392645a.get()) {
            SoLoadManager.getInstance().load(SoLoadConstants.SONAME_SHARPDEC, new C10152a(extraDecoderRequestInfo, consumer));
        } else {
            k(extraDecoderRequestInfo, consumer);
        }
    }

    @Override // r01.a
    public String getLogTag() {
        return "LibraSharpPDecoder";
    }
}
