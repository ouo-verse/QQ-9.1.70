package com.tencent.mobileqq.activity.shortvideo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import com.tencent.guild.api.video.IGuildVideoApi;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.aio.msglist.holder.component.video.z;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/shortvideo/d;", "", "", "origPath", "", "subBusiType", "", CustomImageProps.QUALITY, "thumbPath", "Lcom/tencent/mobileqq/activity/shortvideo/b;", "callBack", "", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f186319a = new d();

    d() {
    }

    @JvmStatic
    public static final void b(@NotNull final String origPath, final int subBusiType, final boolean quality, @Nullable String thumbPath, @NotNull final b callBack) {
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        if (thumbPath == null) {
            IGuildVideoApi iGuildVideoApi = (IGuildVideoApi) QRoute.api(IGuildVideoApi.class);
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(currentTimeMillis);
            thumbPath = iGuildVideoApi.getShortVideoThumbPicPath(sb5.toString(), "jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(thumbPath);
            try {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(origPath);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                    if (frameAtTime != null) {
                        frameAtTime.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e16) {
                    QLog.e("MsgUtil", 1, e16, new Object[0]);
                }
            } finally {
                fileOutputStream.close();
            }
        }
        final String str = thumbPath;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.c
            @Override // java.lang.Runnable
            public final void run() {
                d.c(str, callBack, origPath, quality, subBusiType);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String thumbPicPath, b callBack, String origPath, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(thumbPicPath, "$thumbPicPath");
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        Intrinsics.checkNotNullParameter(origPath, "$origPath");
        BitmapFactory.Options options = new BitmapFactory.Options();
        BitmapFactory.decodeFile(thumbPicPath, options);
        z zVar = new z();
        zVar.j(origPath);
        zVar.i(z16);
        zVar.m(thumbPicPath);
        zVar.k(options.outHeight);
        zVar.o(options.outWidth);
        String r16 = cq.r(thumbPicPath);
        Intrinsics.checkNotNullExpressionValue(r16, "genFileMd5Hex(thumbPicPath)");
        zVar.l(r16);
        zVar.n(cq.v(thumbPicPath));
        byte[] generateVideoExtBuf = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).generateVideoExtBuf(zVar);
        VideoElement videoElement = new VideoElement();
        videoElement.busiType = 0;
        videoElement.subBusiType = i3;
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 5;
        msgElement.videoElement = videoElement;
        msgElement.extBufForUI = generateVideoExtBuf;
        callBack.a(msgElement);
    }
}
