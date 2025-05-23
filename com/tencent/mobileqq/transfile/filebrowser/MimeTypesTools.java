package com.tencent.mobileqq.transfile.filebrowser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class MimeTypesTools {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "MimeTypesTools";
    private static boolean hasLoadMimeType;
    private static MimeTypes mMimeTypes;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41393);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            hasLoadMimeType = false;
        }
    }

    public MimeTypesTools() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap.Config config;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap getBitmapForFileName(Context context, String str) {
        Drawable drawableForFileName = getDrawableForFileName(context, str);
        if (drawableForFileName == null) {
            return null;
        }
        return drawableToBitmap(drawableForFileName);
    }

    public static Drawable getDrawableForFileName(Context context, String str) {
        return getDrawableForMimetype(context, getMimeType(context, str));
    }

    public static Drawable getDrawableForMimetype(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(str);
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(packageManager, intent, 65536);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            return queryIntentActivities.get(0).loadIcon(packageManager);
        }
        return context.getResources().getDrawable(R.drawable.byo);
    }

    public static String getMimeType(Context context, String str) {
        if (str != null) {
            str = str.toLowerCase();
        }
        return getMimeTypes(context).getMimeType(str);
    }

    private static MimeTypes getMimeTypes(Context context) {
        loadMimeTypes(context);
        return mMimeTypes;
    }

    public static boolean isImageType(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(".")) < 0) {
            return false;
        }
        String substring = str.substring(lastIndexOf, str.length());
        if (!".jpg".equalsIgnoreCase(substring) && !".png".equalsIgnoreCase(substring) && !QzoneEmotionUtils.SIGN_ICON_URL_END.equalsIgnoreCase(substring) && !".jpeg".equalsIgnoreCase(substring) && !".bmp".equalsIgnoreCase(substring)) {
            return false;
        }
        return true;
    }

    private static void loadMimeTypes(Context context) {
        if (!hasLoadMimeType) {
            try {
                mMimeTypes = new MimeTypeParser().fromXmlResource(context.getResources().getXml(R.xml.f174400e));
                hasLoadMimeType = true;
            } catch (IOException unused) {
                throw new RuntimeException("PreselectedChannelsActivity: IOException");
            } catch (XmlPullParserException unused2) {
                throw new RuntimeException("PreselectedChannelsActivity: XmlPullParserException");
            }
        }
    }
}
