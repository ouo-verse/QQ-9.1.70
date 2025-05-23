package cq2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0016"}, d2 = {"Lcq2/a;", "", "Landroid/content/Context;", "context", "", WadlProxyConsts.PARAM_FILENAME, "", c.E, "b", "filepath", "Landroid/graphics/drawable/Drawable;", "d", "", "isURLDrawablFoward", "", "a", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "Ljava/io/File;", "c", "<init>", "()V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f391635a = new a();

    a() {
    }

    public final void a(Context context, Drawable d16, boolean isURLDrawablFoward) {
        Intrinsics.checkNotNullParameter(context, "context");
        float f16 = context.getResources().getDisplayMetrics().density;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface)) {
            return;
        }
        if (isURLDrawablFoward) {
            URLDrawableHelper.decodeLocalImage((URLDrawable) d16, ((QQAppInterface) peekAppRuntime).getCurrentAccountUin(), true);
        }
        if (d16 == null || isURLDrawablFoward) {
            return;
        }
        d16.setBounds(BaseImageUtil.calculateThumbBounds(d16, 36, 100, f16));
    }

    public final String b(Context context, String fileName, long len) {
        String str;
        String trimIndent;
        String trimIndent2;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (len < 1024) {
            str = len + " bytes";
        } else if (len < 1048576) {
            str = (len / 1024) + " KB";
        } else {
            str = new DecimalFormat("##0.00").format(len / 1048576) + " MB";
        }
        if (context == null) {
            trimIndent2 = StringsKt__IndentKt.trimIndent("\n             " + fileName + "\n             " + str + "\n             ");
            return trimIndent2;
        }
        trimIndent = StringsKt__IndentKt.trimIndent("\n             " + context.getString(R.string.b8g) + fileName + "\n             " + context.getString(R.string.b8s) + str + "\n             ");
        return trimIndent;
    }

    public final File c(Bundle extraData) {
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        String string = extraData.getString(AppConstants.Key.FORWARD_FILEPATH);
        if (string == null) {
            string = extraData.getString(AppConstants.Key.FORWARD_THUMB);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FSFileUtil", 2, "initPreviewImagePath p: " + string);
        }
        boolean z16 = extraData.getBoolean(SearchEmoticonFragment.U, false);
        if (string != null && string.length() > 4 && (Intrinsics.areEqual(QzoneEmotionUtils.SIGN_ICON_URL_END, string.subSequence(string.length() - 4, string.length())) || z16)) {
            File file = new File(string);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public final Drawable d(String filepath) {
        URL generateURLForNew;
        Exception e16;
        URLDrawable uRLDrawable;
        if (filepath == null || (generateURLForNew = RegionalThumbDownloader.generateURLForNew(filepath, ScreenUtil.dip2px(100.0f), ScreenUtil.dip2px(300.0f))) == null || !AbsDownloader.hasFile(generateURLForNew.toString())) {
            return null;
        }
        String url = generateURLForNew.toString();
        if (!TextUtils.isEmpty(url)) {
            filepath = url;
        }
        try {
            uRLDrawable = URLDrawable.getDrawable(filepath);
            try {
                URLDrawableHelper.decodeLocalImage(uRLDrawable, null, false);
            } catch (Exception e17) {
                e16 = e17;
                if (QLog.isColorLevel()) {
                    QLog.d("FSFileUtil", 2, "getNormalDrawable urlString url is illegal = " + e16);
                }
                return uRLDrawable;
            }
        } catch (Exception e18) {
            e16 = e18;
            uRLDrawable = null;
        }
        return uRLDrawable;
    }
}
