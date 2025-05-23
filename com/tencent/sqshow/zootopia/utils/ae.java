package com.tencent.sqshow.zootopia.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/ae;", "", "a", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ae {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/ae$a;", "", "Landroid/widget/ImageView;", "imageView", "", "url", "Landroid/graphics/drawable/Drawable;", "errDrawable", "", "defaultResId", "Lcom/tencent/image/URLDrawable;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.utils.ae$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        @JvmStatic
        public final URLDrawable a(ImageView imageView, String url, Drawable errDrawable, int defaultResId) {
            URLDrawable uRLDrawable = null;
            if (imageView != null) {
                if (!TextUtils.isEmpty(url)) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    if (errDrawable == null) {
                        errDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                    }
                    obtain.mLoadingDrawable = errDrawable;
                    obtain.mFailedDrawable = errDrawable;
                    try {
                        uRLDrawable = URLDrawable.getDrawable(url, obtain);
                    } catch (Exception e16) {
                        QLog.e("ZootopiaDrawableUtils", 1, "safeLoadImageUrl error - " + url + ", " + imageView, e16);
                    }
                }
                if (uRLDrawable != null) {
                    imageView.setImageDrawable(uRLDrawable);
                } else if (defaultResId != 0) {
                    imageView.setImageResource(defaultResId);
                } else {
                    imageView.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
                }
            }
            return uRLDrawable;
        }
    }
}
