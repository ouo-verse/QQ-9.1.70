package com.qzone.album.business.photolist.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.util.l;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f43302a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f43303b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f43304c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f43305d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f43306e;

    /* renamed from: f, reason: collision with root package name */
    private View f43307f;

    public a(View view) {
        if (view == null) {
            return;
        }
        this.f43307f = view;
        this.f43302a = (LinearLayout) view.findViewById(R.id.f166167ek4);
        this.f43303b = (TextView) this.f43307f.findViewById(R.id.f166166ek3);
        this.f43304c = (LinearLayout) this.f43307f.findViewById(R.id.ekp);
        this.f43305d = (TextView) this.f43307f.findViewById(R.id.eko);
        this.f43306e = (TextView) this.f43307f.findViewById(R.id.ej5);
    }

    public void b() {
        LinearLayout linearLayout = this.f43302a;
        if (linearLayout == null || this.f43304c == null || this.f43306e == null) {
            return;
        }
        linearLayout.setVisibility(8);
        this.f43304c.setVisibility(8);
        this.f43306e.setVisibility(8);
    }

    public void a(AlbumCacheData albumCacheData) {
        LinearLayout linearLayout;
        if (albumCacheData == null || (linearLayout = this.f43302a) == null || this.f43303b == null || this.f43304c == null || this.f43305d == null || this.f43306e == null) {
            return;
        }
        int i3 = albumCacheData.videoNum;
        int i16 = albumCacheData.photoNum;
        if (i3 == 0 && i16 == 0) {
            linearLayout.setVisibility(8);
            this.f43304c.setVisibility(8);
            this.f43306e.setVisibility(0);
            this.f43306e.setText(albumCacheData.albumnum + l.a(R.string.jb8));
            return;
        }
        linearLayout.setVisibility(0);
        this.f43304c.setVisibility(0);
        this.f43306e.setVisibility(8);
        this.f43305d.setText(String.valueOf(i3));
        this.f43303b.setText(String.valueOf(i16));
    }
}
