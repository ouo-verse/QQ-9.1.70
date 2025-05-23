package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eh;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.gdt.access;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QZoneFeedxAdvAdaptUtil {
    public static void a(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
            int dip2px = ViewUtils.dip2px(16.0f);
            layoutParams.leftMargin = dip2px;
            layoutParams.rightMargin = dip2px;
            layoutParams.bottomMargin = dip2px;
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    public static Runnable b(final ImageView imageView, final Drawable drawable) {
        return new Runnable() { // from class: com.tencent.mobileqq.vas.adv.qzone.logic.QZoneFeedxAdvAdaptUtil.1
            private void a(final Drawable drawable2) {
                ImageView imageView2 = imageView;
                if (imageView2 != null && drawable2 != null) {
                    imageView2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.qzone.logic.QZoneFeedxAdvAdaptUtil.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageDrawable(drawable2);
                        }
                    });
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap drawabletoBitmap;
                Drawable drawable2 = drawable;
                if (drawable2 == null || (drawabletoBitmap = BaseImageUtil.drawabletoBitmap(drawable2.mutate().getConstantState().newDrawable())) == null) {
                    return;
                }
                eh.a(drawabletoBitmap, 25);
                a(new ImageDrawable(BitmapReference.getBitmapReference(drawabletoBitmap)));
            }
        };
    }

    public static Map<String, String> c(List<access.ExpInfo> list) {
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < list.size(); i3++) {
            access.ExpInfo expInfo = list.get(i3);
            if (expInfo != null && !TextUtils.isEmpty(expInfo.key.get())) {
                hashMap.put(expInfo.key.get(), expInfo.value.get());
            }
        }
        return hashMap;
    }

    public static Map<String, String> d(List<vac_adv_get.ExtendInfo> list) {
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < list.size(); i3++) {
            vac_adv_get.ExtendInfo extendInfo = list.get(i3);
            if (extendInfo != null && !TextUtils.isEmpty(extendInfo.key.get())) {
                hashMap.put(extendInfo.key.get(), extendInfo.value.get());
            }
        }
        return hashMap;
    }

    public static boolean e(AlumBasicData alumBasicData) {
        if (alumBasicData != null && alumBasicData.isFeedxLayer) {
            return true;
        }
        return false;
    }
}
