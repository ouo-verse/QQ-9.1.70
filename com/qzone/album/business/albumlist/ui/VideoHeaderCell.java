package com.qzone.album.business.albumlist.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.album.base.AlbumPersonalizeManager;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.g;
import com.tencent.mobileqq.R;
import s5.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VideoHeaderCell extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    public TextView f42375d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f42376e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f42377f;

    public VideoHeaderCell(Context context) {
        super(context);
    }

    public void c() {
        if (AlbumPersonalizeManager.L().Q()) {
            a.m(this.f42377f);
            a.m(this.f42375d);
            a.m(this.f42376e);
        }
    }

    public VideoHeaderCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoHeaderCell(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void a(Context context) {
        View inflate = View.inflate(context, R.layout.bj6, this);
        this.f42375d = (TextView) inflate.findViewById(R.id.he5);
        this.f42376e = (TextView) inflate.findViewById(R.id.he8);
        this.f42377f = (TextView) inflate.findViewById(R.id.f68153f_);
        c();
    }

    public void b(PhotoCacheData photoCacheData) {
        if (photoCacheData == null) {
            return;
        }
        String[] c16 = g.c(photoCacheData.uploadtime * 1000);
        if (c16.length == 2) {
            this.f42376e.setText("/ " + c16[0]);
            this.f42375d.setText(c16[1]);
            this.f42375d.setVisibility(0);
            this.f42376e.setVisibility(0);
        }
    }
}
