package com.tencent.mobileqq.richmediabrowser.utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RichMediaBrowserUtils {
    public static ShareActionSheetBuilder.ActionSheetItem a(int i3, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(i3);
        arrayList.add(build);
        return build;
    }

    public static ShareActionSheetBuilder.ActionSheetItem b(int i3, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList, String str, int i16) {
        ShareActionSheetBuilder.ActionSheetItem a16 = a(i3, arrayList);
        if (str == null) {
            str = "";
        }
        a16.argus = str;
        a16.firstLineCount = i16;
        return a16;
    }

    public static LocalMediaInfo c(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.mMediaType = i3;
        localMediaInfo.path = str;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                localMediaInfo.mMimeType = mediaMetadataRetriever.extractMetadata(12);
                localMediaInfo.mDuration = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                localMediaInfo.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                localMediaInfo.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            } catch (Exception e16) {
                QLog.e("RichMediaBrowserUtils", 1, "getMimeType error, filePath=", str, ", error=", e16);
            }
            return localMediaInfo;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static boolean d() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("rich_media_browser_enable_capture_video_frame");
    }

    @NonNull
    public static AIOVideoData e(com.tencent.mobileqq.richmediabrowser.presenter.f fVar) {
        RichMediaBaseData richMediaBaseData;
        if (fVar != null) {
            fVar.b();
            RichMediaBrowserInfo selectedItem = fVar.b().getSelectedItem();
            if (selectedItem != null && (richMediaBaseData = selectedItem.baseData) != null && richMediaBaseData.getType() == 101) {
                return (AIOVideoData) selectedItem.baseData;
            }
        }
        return new AIOVideoData();
    }

    public static boolean f(int i3) {
        if (i3 == 4601) {
            return true;
        }
        return false;
    }

    public static Runnable g(final View view, final URLDrawable uRLDrawable) {
        boolean z16;
        if (uRLDrawable.getStatus() != 0 && uRLDrawable.getStatus() != 4) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    if (URLDrawable.this.getStatus() == 0 || URLDrawable.this.getStatus() == 4) {
                        view.setVisibility(0);
                    }
                }
            };
            view.postDelayed(runnable, 200L);
            return runnable;
        }
        return null;
    }

    public static boolean h(AIOVideoData aIOVideoData) {
        File c16 = new tm2.e().c(aIOVideoData, 1);
        if (c16 != null && c16.exists()) {
            return true;
        }
        return false;
    }

    public static boolean i(Bitmap bitmap, String str) throws IOException, FileNotFoundException {
        BufferedOutputStream bufferedOutputStream;
        if (bitmap != null && str != null) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str), 1048576);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 70, bufferedOutputStream);
                try {
                    bufferedOutputStream.flush();
                } catch (IOException unused) {
                }
                bufferedOutputStream.close();
                return compress;
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.flush();
                    } catch (IOException unused2) {
                    }
                    bufferedOutputStream2.close();
                }
                throw th;
            }
        }
        return false;
    }
}
