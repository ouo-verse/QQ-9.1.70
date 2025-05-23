package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DrawerRandomCoverView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private URLImageView f315618d;

    /* renamed from: e, reason: collision with root package name */
    private View f315619e;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f315620f;

    /* renamed from: h, reason: collision with root package name */
    protected URLDrawable f315621h;

    public DrawerRandomCoverView(Context context) {
        super(context);
        this.f315618d = null;
        this.f315619e = null;
        this.f315620f = null;
        this.f315621h = null;
        b();
    }

    private void b() {
        this.f315618d = new URLImageView(getContext());
        this.f315619e = new View(getContext());
        setCoverMaskColor();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        super.addView(this.f315618d, layoutParams);
        super.addView(this.f315619e, layoutParams);
        this.f315618d.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public URLImageView a() {
        return this.f315618d;
    }

    public void c(String str, boolean z16, int i3, int i16) {
        d(str, z16, i3, i16, Boolean.TRUE);
    }

    public void d(String str, boolean z16, int i3, int i16, Boolean bool) {
        URLDrawable fileDrawable;
        if (!TextUtils.isEmpty(str)) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                URLDrawable uRLDrawable = this.f315621h;
                if (uRLDrawable != null) {
                    obtain.mLoadingDrawable = uRLDrawable.getCurrDrawable();
                    obtain.mFailedDrawable = this.f315621h.getCurrDrawable();
                } else {
                    Drawable defaultCoverDrawable = ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).getDefaultCoverDrawable(getResources());
                    obtain.mLoadingDrawable = defaultCoverDrawable;
                    obtain.mFailedDrawable = defaultCoverDrawable;
                }
                obtain.mRequestHeight = i16;
                obtain.mRequestWidth = i3;
                if (z16) {
                    fileDrawable = URLDrawable.getDrawable(str, obtain);
                    this.f315621h = fileDrawable;
                } else {
                    fileDrawable = URLDrawable.getFileDrawable(str, obtain);
                    this.f315621h = fileDrawable;
                }
                this.f315618d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f315618d.setImageDrawable(fileDrawable);
                if (bool.booleanValue()) {
                    this.f315619e.setVisibility(0);
                } else {
                    this.f315619e.setVisibility(8);
                }
                setCoverMaskColor();
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.PROFILE_CARD, 2, "updateCover " + str);
                }
            } catch (Exception | OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.PROFILE_CARD, 2, e16.toString());
                }
            }
        }
    }

    public void setCoverMaskColor() {
        Resources resources;
        int i3;
        View view = this.f315619e;
        if (QQTheme.isNowThemeIsNight()) {
            resources = getResources();
            i3 = R.color.f156941fv;
        } else {
            resources = getResources();
            i3 = R.color.f156937fr;
        }
        view.setBackgroundColor(resources.getColor(i3));
    }

    public void setDefaultCoverBg() {
        this.f315619e.setVisibility(8);
        this.f315618d.setImageDrawable(null);
    }

    public DrawerRandomCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315618d = null;
        this.f315619e = null;
        this.f315620f = null;
        this.f315621h = null;
        b();
    }

    public DrawerRandomCoverView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315618d = null;
        this.f315619e = null;
        this.f315620f = null;
        this.f315621h = null;
        b();
    }
}
