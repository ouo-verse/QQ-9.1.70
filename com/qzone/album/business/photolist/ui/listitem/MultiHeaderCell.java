package com.qzone.album.business.photolist.ui.listitem;

import NS_MOBILE_MATERIAL.CustomAlbumItem;
import NS_MOBILE_MATERIAL.MaterialFile;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.business.photolist.adapter.u;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.module.feedcomponent.view.AvatarImageView;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.widget.FeedDate;
import com.qzone.util.l;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import s4.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MultiHeaderCell extends LinearLayout {
    public AvatarImageView C;
    public View D;
    CellTextView E;
    protected NoShootTimeTitleLayout F;

    /* renamed from: d, reason: collision with root package name */
    public FeedDate f43615d;

    /* renamed from: e, reason: collision with root package name */
    public Button f43616e;

    /* renamed from: f, reason: collision with root package name */
    public Button f43617f;

    /* renamed from: h, reason: collision with root package name */
    public RelativeLayout f43618h;

    /* renamed from: i, reason: collision with root package name */
    public RelativeLayout f43619i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f43620m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends QZoneAlbumUtil.f {
        a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            MultiHeaderCell.this.f43615d.setBackgroundDrawable(drawable);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) MultiHeaderCell.this.f43615d.getLayoutParams();
            layoutParams.width = u4.a.z().o(drawable.getIntrinsicWidth() / 2);
            layoutParams.height = u4.a.z().o(drawable.getIntrinsicHeight() / 2);
            layoutParams.gravity = 17;
            MultiHeaderCell.this.f43615d.setLayoutParams(layoutParams);
        }
    }

    public MultiHeaderCell(Context context) {
        super(context);
    }

    public void a(x4.a aVar) {
        View.inflate(aVar.k(), R.layout.f168999bj2, this);
        setOrientation(1);
        try {
            FeedDate feedDate = (FeedDate) findViewById(R.id.jlb);
            this.f43615d = feedDate;
            feedDate.a(false);
            this.f43618h = (RelativeLayout) findViewById(R.id.fre);
            this.f43616e = (Button) findViewById(R.id.frc);
            this.f43617f = (Button) findViewById(R.id.frd);
            this.f43619i = (RelativeLayout) findViewById(R.id.fqd);
            this.f43620m = (TextView) findViewById(R.id.fqg);
            this.C = (AvatarImageView) findViewById(R.id.fqf);
            this.E = (CellTextView) findViewById(R.id.fob);
            this.D = findViewById(R.id.fqe);
            this.F = (NoShootTimeTitleLayout) findViewById(R.id.hcd);
        } catch (Exception e16) {
            b.c("NormalHeaderCell", "e:" + e16.toString());
        }
    }

    public MultiHeaderCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void b(com.qzone.album.business.photolist.adapter.a aVar, x4.a aVar2, PhotoCacheData[] photoCacheDataArr, d dVar, boolean z16, int i3, boolean z17) {
        PhotoCacheData photoCacheData;
        PhotoCacheData photoCacheData2;
        PhotoCacheData photoCacheData3;
        PhotoCacheData photoCacheData4;
        MaterialFile materialFile;
        this.f43615d.setVisibility(8);
        this.f43618h.setVisibility(8);
        this.f43619i.setVisibility(8);
        this.F.setVisibility(8);
        if (photoCacheDataArr != null && (photoCacheData4 = photoCacheDataArr[0]) != null && photoCacheData4.timevisible) {
            setVisibility(0);
            long j3 = photoCacheDataArr[0].uploadtime * 1000;
            if (j3 > 0) {
                this.f43618h.setVisibility(0);
                this.f43615d.setVisibility(0);
                if (photoCacheDataArr[0].batchvisible) {
                    this.D.setVisibility(8);
                    this.f43619i.setVisibility(0);
                    this.C.loadAvatar(photoCacheDataArr[0].uploadUin);
                    this.f43620m.setText(photoCacheDataArr[0].uploadNickName);
                    this.f43620m.setMaxEms(18);
                    this.f43620m.setLines(1);
                    AccessibilityUtil.p(this.C, "\u5934\u50cf");
                    if (aVar2 != null) {
                        this.C.setOnClickListener(aVar2.u(photoCacheDataArr[0]));
                        this.f43620m.setOnClickListener(aVar2.u(photoCacheDataArr[0]));
                    }
                }
                CustomAlbumItem e16 = aVar2 != null ? com.qzone.album.util.b.e(aVar2.g()) : null;
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar.setTimeInMillis(j3);
                calendar2.setTimeInMillis(System.currentTimeMillis());
                if (!z16 && e16 != null && (materialFile = e16.stBgImage) != null && !TextUtils.isEmpty(materialFile.strUrl)) {
                    this.f43615d.setTextSize(14.0f);
                    this.f43615d.setText(new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5").format(Long.valueOf(j3)));
                    this.f43615d.setTextColor((int) e16.iTextColor);
                    this.f43615d.setGravity(17);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f43615d.getLayoutParams();
                    layoutParams.gravity = 17;
                    this.f43615d.setLayoutParams(layoutParams);
                    QZoneAlbumUtil.F(e16.stBgImage.strUrl, new a());
                } else {
                    this.f43615d.setText(QZoneAlbumUtil.K(calendar.get(1), calendar.get(2) + 1, calendar.get(5)));
                    this.f43615d.setBackgroundDrawable(null);
                    this.f43615d.setGravity(3);
                    if (aVar2 != null && aVar2.getResources() != null) {
                        this.f43615d.setTextColor(aVar2.getResources().getColor(R.color.a_j));
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f43615d.getLayoutParams();
                    layoutParams2.width = -1;
                    layoutParams2.height = -2;
                    layoutParams2.gravity = 3;
                    this.f43615d.setLayoutParams(layoutParams2);
                }
            } else {
                this.F.setVisibility(0);
                this.F.b(i3, aVar, aVar2, photoCacheDataArr, dVar, z17);
            }
            if (z16 && photoCacheDataArr[0].batchvisible) {
                this.f43616e.setVisibility(8);
                this.f43617f.setVisibility(0);
            } else {
                this.f43616e.setVisibility(8);
                this.f43617f.setVisibility(8);
            }
            this.f43617f.setTag(photoCacheDataArr[0]);
        } else if (photoCacheDataArr != null && (photoCacheData = photoCacheDataArr[0]) != null && photoCacheData.batchvisible) {
            setVisibility(0);
            this.f43619i.setVisibility(0);
            this.D.setVisibility(0);
            this.C.loadAvatar(photoCacheDataArr[0].uploadUin);
            this.f43620m.setText(photoCacheDataArr[0].uploadNickName);
            this.f43620m.setMaxEms(18);
            this.f43620m.setLines(1);
            AccessibilityUtil.p(this.C, "\u5934\u50cf");
            if (aVar2 != null) {
                this.C.setOnClickListener(aVar2.u(photoCacheDataArr[0]));
                this.f43620m.setOnClickListener(aVar2.u(photoCacheDataArr[0]));
            }
            if (z16) {
                this.f43617f.setVisibility(0);
            } else {
                this.f43617f.setVisibility(8);
            }
            this.f43617f.setTag(photoCacheDataArr[0]);
        } else {
            setVisibility(8);
        }
        if (aVar2 != null && aVar2.f()) {
            if (photoCacheDataArr != null && (photoCacheData3 = photoCacheDataArr[0]) != null && photoCacheData3.descvisible && !TextUtils.isEmpty(photoCacheData3.desc)) {
                setVisibility(0);
                this.E.setRichText(photoCacheDataArr[0].desc);
                this.E.setVisibility(0);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                if (!photoCacheDataArr[0].timevisible) {
                    layoutParams3.topMargin = u4.a.z().o(12.0f);
                } else {
                    layoutParams3.topMargin = 0;
                }
                this.E.setLayoutParams(layoutParams3);
            } else {
                this.E.setVisibility(8);
            }
            if (!z16 && z17 && photoCacheDataArr != null && photoCacheDataArr[0] != null) {
                this.E.setClickable(true);
                this.E.setOnClickListener(aVar2.r(photoCacheDataArr[0]));
            }
            if (photoCacheDataArr != null && (photoCacheData2 = photoCacheDataArr[0]) != null && photoCacheData2.timevisible) {
                if (photoCacheData2 != null && photoCacheData2.descvisible && !TextUtils.isEmpty(photoCacheData2.desc)) {
                    if (photoCacheDataArr[0].timevisible) {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                        layoutParams4.topMargin = 0;
                        layoutParams4.bottomMargin = u4.a.z().o(11.0f);
                        this.E.setLayoutParams(layoutParams4);
                    } else {
                        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                        layoutParams5.topMargin = u4.a.z().o(11.0f);
                        layoutParams5.bottomMargin = u4.a.z().o(11.0f);
                        this.E.setLayoutParams(layoutParams5);
                    }
                } else {
                    this.E.setVisibility(8);
                }
            }
        } else {
            this.E.setVisibility(8);
        }
        if (photoCacheDataArr == null || photoCacheDataArr[0] == null || !z16) {
            return;
        }
        ((u) aVar).v(dVar);
        if (photoCacheDataArr[0].allSelectedStatus) {
            this.f43617f.setSelected(true);
            this.f43617f.setText(l.a(R.string.obs));
        } else {
            this.f43617f.setSelected(false);
            this.f43617f.setText(l.a(R.string.obr));
        }
        if (aVar2 != null) {
            this.F.setBtnSelected(photoCacheDataArr[0].allSelectedStatus, aVar2.n(dVar));
            if (!aVar2.w() && !aVar2.A()) {
                this.f43617f.setOnClickListener(aVar2.n(dVar));
            } else {
                this.f43617f.setVisibility(4);
            }
        }
    }
}
