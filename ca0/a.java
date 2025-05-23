package ca0;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public static void a(View view, int i3) {
        if (i3 != 1) {
            view.setBackground(null);
        } else {
            b(view);
        }
    }

    private static void b(View view) {
        if (QCircleSkinHelper.getInstance().isDarkMode()) {
            view.setBackgroundResource(R.drawable.kfc);
        } else {
            view.setBackgroundResource(R.drawable.kfb);
        }
    }

    public static void c(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        Option url = Option.obtain().setTargetView(imageView).setUrl(str);
        url.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(url);
    }
}
