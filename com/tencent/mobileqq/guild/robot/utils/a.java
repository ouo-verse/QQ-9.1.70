package com.tencent.mobileqq.guild.robot.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f232291a = new C7879a();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.robot.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C7879a implements DownloadParams.DecodeHandler {
        C7879a() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    return BaseImageUtil.getRoundedCornerBitmap(bitmap, 0.0f, iArr[0], iArr[1]);
                }
            }
            return BaseImageUtil.getRoundFaceBitmap(bitmap, 50, 50);
        }
    }

    public static URLDrawable a(String str, int i3, int i16, Drawable drawable, boolean z16, boolean z17) {
        Drawable drawable2;
        URLDrawable uRLDrawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (drawable != null) {
            drawable2 = drawable;
        } else {
            drawable2 = b.f306350a;
        }
        obtain.mLoadingDrawable = drawable2;
        if (drawable == null) {
            drawable = b.f306350a;
        }
        obtain.mFailedDrawable = drawable;
        obtain.mRequestHeight = i16;
        obtain.mRequestWidth = i3;
        obtain.mUseMemoryCache = z17;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
            if (z16) {
                try {
                    uRLDrawable.setTag(new int[]{i3, i16});
                    uRLDrawable.setDecodeHandler(f232291a);
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("GuildRobotTag:RobotUIUtil", 1, e, new Object[0]);
                    return uRLDrawable;
                }
            }
        } catch (Exception e17) {
            e = e17;
            uRLDrawable = null;
        }
        return uRLDrawable;
    }

    public static boolean b(String str, EditText editText) {
        if (str.substring(editText.getSelectionStart()).trim().length() > 0) {
            return true;
        }
        return false;
    }

    public static boolean c(String str) {
        if (str.startsWith("/") && str.replace("/", "").trim().length() > 0) {
            return true;
        }
        return false;
    }

    public static boolean d(String str) {
        if (str.startsWith("/") && str.contains(" ") && str.replace("/", "").trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean e(String str, EditText editText) {
        String substring = str.substring(0, editText.getSelectionStart());
        if (substring.length() - substring.replaceAll(" ", "").length() <= 1) {
            return false;
        }
        return true;
    }
}
