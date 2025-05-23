package com.tencent.mobileqq.matchfriend.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.armap.map.RoundCorneredFrameLayout;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VoiceChatAvatarView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f245669d;

    /* renamed from: e, reason: collision with root package name */
    private URLDrawable f245670e;

    /* renamed from: f, reason: collision with root package name */
    private int f245671f;

    public VoiceChatAvatarView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cwf, this);
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById(R.id.oi_);
        this.f245669d = (ImageView) findViewById(R.id.oi5);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f10321r);
        this.f245671f = dimensionPixelSize;
        roundCorneredFrameLayout.f199761d = dimensionPixelSize / 2;
    }

    public void setAvatarUrl(String str) {
        QLog.i("VoiceChatAvatarView", 1, "setAvatarUrl url=" + str);
        if (TextUtils.isEmpty(str)) {
            QLog.e("VoiceChatAvatarView", 1, "setAvatarUrl url is empty");
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int i3 = this.f245671f;
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i3;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{getResources().getDrawable(R.drawable.f159741g00), getResources().getDrawable(R.drawable.f3m)});
        obtain.mLoadingDrawable = layerDrawable;
        obtain.mFailedDrawable = layerDrawable;
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        this.f245670e = drawable;
        this.f245669d.setImageDrawable(drawable);
    }

    public VoiceChatAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
