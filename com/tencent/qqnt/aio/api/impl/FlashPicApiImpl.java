package com.tencent.qqnt.aio.api.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqnt.aio.api.IFlashPicApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaFilePathInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J8\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000eH\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/FlashPicApiImpl;", "Lcom/tencent/qqnt/aio/api/IFlashPicApi;", "", "pxs", "", "startX", "startY", "blockSize", "maxX", "maxY", "", "dimBlock", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "", "getOriginPath", "Landroid/graphics/Bitmap;", "bmp", "getMosaicBitmap", "Landroid/widget/ImageView;", "flashPic", "", "msgId", "peerUid", "", "isSelf", "thumbPath", "enterFlashPicPreview", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class FlashPicApiImpl implements IFlashPicApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "NTFlashPic FlashPicActivity";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/FlashPicApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.FlashPicApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63317);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlashPicApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void dimBlock(int[] pxs, int startX, int startY, int blockSize, int maxX, int maxY) {
        int i3 = (startX + blockSize) - 1;
        int i16 = (blockSize + startY) - 1;
        if (i3 > maxX) {
            i3 = maxX;
        }
        if (i16 <= maxY) {
            maxY = i16;
        }
        int i17 = pxs[(((((((maxY - startY) + 1) / 2) + startY) - 1) * maxX) + ((((i3 - startX) + 1) / 2) + startX)) - 1];
        if (startY > maxY) {
            return;
        }
        while (true) {
            int i18 = (startY - 1) * maxX;
            if (startX <= i3) {
                int i19 = startX;
                while (true) {
                    pxs[(i18 + i19) - 1] = i17;
                    if (i19 == i3) {
                        break;
                    } else {
                        i19++;
                    }
                }
            }
            if (startY != maxY) {
                startY++;
            } else {
                return;
            }
        }
    }

    private final String getOriginPath(MsgElement element) {
        boolean z16;
        PicElement picElement = element.picElement;
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        Intrinsics.checkNotNull(e16);
        String assembleMobileQQRichMediaFilePath = e16.assembleMobileQQRichMediaFilePath(new RichMediaFilePathInfo(2, picElement.picSubType, picElement.md5HexStr, picElement.fileName, 1, 0, null, picElement.fileUuid, false));
        if (assembleMobileQQRichMediaFilePath != null && assembleMobileQQRichMediaFilePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || !new File(assembleMobileQQRichMediaFilePath).exists()) {
            return "";
        }
        return assembleMobileQQRichMediaFilePath;
    }

    @Override // com.tencent.qqnt.aio.api.IFlashPicApi
    public void enterFlashPicPreview(@NotNull ImageView flashPic, long msgId, @NotNull String peerUid, @NotNull MsgElement element, boolean isSelf, @NotNull String thumbPath) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, flashPic, Long.valueOf(msgId), peerUid, element, Boolean.valueOf(isSelf), thumbPath);
            return;
        }
        Intrinsics.checkNotNullParameter(flashPic, "flashPic");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(thumbPath, "thumbPath");
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(BaseApplication.context, "/base/activity/FlashPic");
        Rect d16 = com.tencent.common.galleryactivity.j.d(flashPic);
        if (isSelf) {
            str = getOriginPath(element);
            QLog.i(TAG, 1, "send from self origin path\uff1a" + ((Object) str));
        } else {
            str = "";
        }
        Bundle extra = activityURIRequest.extra();
        extra.putLong("msgId", msgId);
        extra.putString("peerUid", peerUid);
        extra.putLong("elementId", element.elementId);
        extra.putString("originPath", str);
        extra.putString("thumbPath", thumbPath);
        extra.putParcelable(CanvasView.ACTION_RECT, d16);
        QRoute.startUri(activityURIRequest);
    }

    @Override // com.tencent.qqnt.aio.api.IFlashPicApi
    @NotNull
    public Bitmap getMosaicBitmap(@NotNull Bitmap bmp, int blockSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bmp, blockSize);
        }
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        int[] iArr = new int[width * height];
        bmp.getPixels(iArr, 0, width, 0, 0, width, height);
        float f16 = blockSize;
        int ceil = (int) Math.ceil(height / f16);
        int ceil2 = (int) Math.ceil(width / f16);
        for (int i3 = 0; i3 < ceil; i3++) {
            for (int i16 = 0; i16 < ceil2; i16++) {
                dimBlock(iArr, (i16 * blockSize) + 1, (i3 * blockSize) + 1, blockSize, width, height);
            }
        }
        Bitmap mosaicBmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mosaicBmp.setPixels(iArr, 0, width, 0, 0, width, height);
        Canvas canvas = new Canvas();
        canvas.setBitmap(mosaicBmp);
        canvas.drawARGB(89, 0, 0, 0);
        Intrinsics.checkNotNullExpressionValue(mosaicBmp, "mosaicBmp");
        return mosaicBmp;
    }
}
