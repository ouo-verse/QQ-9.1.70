package com.tencent.av.zplan.avatar.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/av/zplan/avatar/manager/c;", "Lcom/airbnb/lottie/ImageAssetDelegate;", "Lcom/airbnb/lottie/LottieImageAsset;", "asset", "Landroid/graphics/Bitmap;", "fetchBitmap", "", "a", "Ljava/lang/String;", "getImageDir", "()Ljava/lang/String;", "imageDir", "<init>", "(Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
final class c implements ImageAssetDelegate {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String imageDir;

    public c(@Nullable String str) {
        this.imageDir = str;
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    @Nullable
    public Bitmap fetchBitmap(@Nullable LottieImageAsset asset) {
        boolean z16;
        if (asset == null) {
            QLog.e("AVChatAvatarEasterEggManager", 1, "null asset");
            return null;
        }
        String str = this.imageDir;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AVChatAvatarEasterEggManager", 1, "Image dir is not set");
            return null;
        }
        try {
            String str2 = this.imageDir + File.separator + asset.getFileName();
            QLog.d("AVChatAvatarEasterEggManager", 1, "load bitmap: " + str2 + " file exists: " + new File(str2).exists());
            return BitmapFactory.decodeFile(str2);
        } catch (Exception unused) {
            QLog.e("AVChatAvatarEasterEggManager", 1, "load bitmap failed!!");
            return null;
        }
    }
}
