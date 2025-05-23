package com.tencent.sqshow.zootopia.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.q;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u000b\u001a\u00020\u0005J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0011\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/ZootopiaApngImageView;", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "", "radius", "", "setBackgroundRadius", "", "url", "setApngBackgroundUrl", "setPngBackgroundUrl", "setDefaultBackground", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "onLoadSuccessed", "", "arg1", "onLoadFialed", "onLoadCanceled", "progress", "onLoadProgressed", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaApngImageView extends RoundRelativeLayout implements URLDrawable.URLDrawableListener {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaApngImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable urlDrawable) {
        if (QLog.isColorLevel()) {
            QLog.i("ZootopiaApngImageView", 1, "onLoadCanceled");
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable urlDrawable, Throwable arg1) {
        if (QLog.isColorLevel()) {
            QLog.i("ZootopiaApngImageView", 1, "onLoadFialed");
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(URLDrawable urlDrawable, int progress) {
        if (QLog.isColorLevel()) {
            QLog.i("ZootopiaApngImageView", 1, "onLoadProgressed");
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable urlDrawable) {
        if (QLog.isColorLevel()) {
            QLog.i("ZootopiaApngImageView", 1, "onLoadSuccessed");
        }
    }

    public final void setApngBackgroundUrl(String url) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoadingDrawable(q.b(R.drawable.gyn));
        apngOptions.setTagId(new int[]{30000});
        apngOptions.setLoadListener(this);
        IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        Intrinsics.checkNotNull(url);
        URLDrawable apngURLDrawable = iVasApngFactory.getApngURLDrawable("ZootopiaApngImageView", url, apngOptions);
        if (apngURLDrawable != null) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageDrawable(apngURLDrawable);
            addView(imageView, -1, -1);
            return;
        }
        QLog.e("ZootopiaApngImageView", 4, "get apngURLDrawable is null");
    }

    public final void setDefaultBackground() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.ik9);
        addView(imageView, -1, -1);
    }

    public final void setPngBackgroundUrl(String url) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = q.b(R.drawable.gyn);
            obtain.mLoadingDrawable = q.b(R.drawable.gyn);
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            if (drawable != null) {
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(drawable);
                addView(imageView, -1, -1);
            }
        } catch (Exception e16) {
            QLog.e("ZootopiaApngImageView", 1, "setPngBackgroundUrl + " + e16);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaApngImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaApngImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void setBackgroundRadius(int radius) {
        this.f316197h = 15;
        this.f316195e = radius;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaApngImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
