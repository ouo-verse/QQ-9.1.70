package com.qzone.homepage.ui.Facade.model;

import android.view.View;
import android.widget.ImageView;
import com.qzone.homepage.ui.Facade.h;
import com.qzone.homepage.ui.Facade.i;
import com.qzone.homepage.ui.Facade.ui.CustomPhotoView;
import com.qzone.homepage.ui.Facade.ui.FacadeView;
import com.qzone.widget.AsyncImageView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends i {

    /* renamed from: l, reason: collision with root package name */
    public String f47633l;

    /* renamed from: m, reason: collision with root package name */
    public int f47634m;

    public static a d(ConfigArea configArea) {
        a aVar = new a();
        aVar.b(configArea);
        aVar.f47634m = configArea.contentStyle;
        aVar.f47633l = configArea.imageUrl;
        return aVar;
    }

    @Override // com.qzone.homepage.ui.Facade.i
    public View c(FacadeView facadeView) {
        if (facadeView.m()) {
            return new CustomPhotoView(facadeView.getContext());
        }
        AsyncImageView asyncImageView = new AsyncImageView(facadeView.getContext());
        asyncImageView.setAsyncRootFilePath(h.l().j());
        asyncImageView.setAsyncImage(this.f47633l);
        asyncImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return asyncImageView;
    }
}
