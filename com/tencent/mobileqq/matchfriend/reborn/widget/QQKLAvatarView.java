package com.tencent.mobileqq.matchfriend.reborn.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.matchfriend.reborn.widget.QQKLAvatarView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ah;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u0000  2\u00020\u0001:\u0001!B/\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0003\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0003\u0010\u001b\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001c\u0010\u001dB%\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001c\u0010\u001eB\u001d\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/widget/QQKLAvatarView;", "Landroid/widget/FrameLayout;", "", "faceUrl", "bgUrl", "", "f", "", "hasBg", "e", "url", "b", "c", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "avatarView", "bgView", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "sDecodeHandler", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class QQKLAvatarView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView avatarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView bgView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final DownloadParams.DecodeHandler sDecodeHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKLAvatarView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sDecodeHandler = new DownloadParams.DecodeHandler() { // from class: x82.a
            @Override // com.tencent.image.DownloadParams.DecodeHandler
            public final Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
                Bitmap g16;
                g16 = QQKLAvatarView.g(downloadParams, bitmap);
                return g16;
            }
        };
    }

    private final void e(String faceUrl, boolean hasBg) {
        URLDrawable drawable;
        if (this.avatarView == null) {
            this.avatarView = new ImageView(getContext());
            addView(this.avatarView, new FrameLayout.LayoutParams(-1, -1));
        }
        if (faceUrl == null || faceUrl.length() == 0) {
            ImageView imageView = this.avatarView;
            if (imageView != null) {
                imageView.setImageDrawable(null);
                return;
            }
            return;
        }
        int n3 = Utils.n(200.0f, getContext().getResources());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = n3;
        obtain.mRequestHeight = n3;
        obtain.mLoadingDrawable = BaseImageUtil.getDefaultFaceDrawable();
        obtain.mFailedDrawable = BaseImageUtil.getDefaultFaceDrawable();
        obtain.mUseMemoryCache = true;
        String replace$default = (hasBg && b(faceUrl)) ? StringsKt__StringsJVMKt.replace$default(faceUrl, ".png", "_fg.png", false, 4, (Object) null) : faceUrl;
        if (b(faceUrl)) {
            drawable = URLDrawable.getDrawable(replace$default, obtain);
        } else {
            drawable = URLDrawable.getDrawable(replace$default, obtain);
            drawable.setTag(new int[]{n3, n3});
            drawable.setDecodeHandler(this.sDecodeHandler);
        }
        ImageView imageView2 = this.avatarView;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setImageDrawable(drawable);
    }

    private final void f(String faceUrl, String bgUrl) {
        if (this.bgView == null) {
            this.bgView = new ImageView(getContext());
            addView(this.bgView, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        ImageView imageView = this.bgView;
        if (imageView != null) {
            imageView.setVisibility(b(faceUrl) ? 0 : 4);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = BaseImageUtil.getDefaultFaceDrawable();
        obtain.mFailedDrawable = BaseImageUtil.getDefaultFaceDrawable();
        obtain.mUseMemoryCache = true;
        URLDrawable drawable = URLDrawable.getDrawable(bgUrl, obtain);
        ImageView imageView2 = this.bgView;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setImageDrawable(drawable);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQKLAvatarView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean b(String url) {
        boolean contains$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "/kuolieavatar/", false, 2, (Object) null);
        return contains$default;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQKLAvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QQKLAvatarView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap g(DownloadParams downloadParams, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Object obj = downloadParams.tag;
        if (!(obj instanceof int[])) {
            return bitmap;
        }
        int[] iArr = (int[]) obj;
        if (iArr.length != 2) {
            return bitmap;
        }
        float q16 = ah.q();
        if (q16 < 0.01f) {
            q16 = 1.0f;
        }
        int i3 = (int) (iArr[0] / q16);
        iArr[0] = i3;
        int i16 = (int) (iArr[1] / q16);
        iArr[1] = i16;
        return BaseImageUtil.getCircleFaceBitmap(bitmap, i3, i16);
    }

    public final void c(String faceUrl, String bgUrl) {
        e(faceUrl, !(bgUrl == null || bgUrl.length() == 0));
        if (bgUrl == null || bgUrl.length() == 0) {
            return;
        }
        if (faceUrl == null || faceUrl.length() == 0) {
            return;
        }
        f(faceUrl, bgUrl);
    }

    public static /* synthetic */ void d(QQKLAvatarView qQKLAvatarView, String str, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str2 = null;
            }
            qQKLAvatarView.c(str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAvatar");
    }
}
