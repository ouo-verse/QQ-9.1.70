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
import com.qzone.album.business.photolist.adapter.u;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.widget.FeedDate;
import com.qzone.util.l;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import java.util.Calendar;
import s4.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NormalHeaderCell extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    public FeedDate f43627d;

    /* renamed from: e, reason: collision with root package name */
    public Button f43628e;

    /* renamed from: f, reason: collision with root package name */
    public RelativeLayout f43629f;

    /* renamed from: h, reason: collision with root package name */
    CellTextView f43630h;

    /* renamed from: i, reason: collision with root package name */
    protected NoShootTimeTitleLayout f43631i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends QZoneAlbumUtil.f {
        a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            NormalHeaderCell.this.f43627d.setBackgroundDrawable(drawable);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) NormalHeaderCell.this.f43627d.getLayoutParams();
            layoutParams.width = u4.a.z().o(drawable.getIntrinsicWidth() / 2);
            layoutParams.height = u4.a.z().o(drawable.getIntrinsicHeight() / 2);
            layoutParams.gravity = 17;
            NormalHeaderCell.this.f43627d.setLayoutParams(layoutParams);
        }
    }

    public NormalHeaderCell(Context context) {
        super(context);
    }

    public void a(x4.a aVar) {
        View.inflate(aVar.k(), R.layout.f169000bj3, this);
        setOrientation(1);
        try {
            FeedDate feedDate = (FeedDate) findViewById(R.id.jlb);
            this.f43627d = feedDate;
            feedDate.a(false);
            this.f43629f = (RelativeLayout) findViewById(R.id.fre);
            this.f43628e = (Button) findViewById(R.id.frc);
            this.f43630h = (CellTextView) findViewById(R.id.fob);
            this.f43631i = (NoShootTimeTitleLayout) findViewById(R.id.hcd);
        } catch (Exception e16) {
            b.c("NormalHeaderCell", "e:" + e16.toString());
        }
    }

    public NormalHeaderCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void b(com.qzone.album.business.photolist.adapter.a aVar, x4.a aVar2, PhotoCacheData[] photoCacheDataArr, d dVar, boolean z16, int i3, int i16, boolean z17) {
        PhotoCacheData photoCacheData;
        PhotoCacheData photoCacheData2;
        PhotoCacheData photoCacheData3;
        long j3;
        MaterialFile materialFile;
        this.f43627d.setVisibility(8);
        this.f43629f.setVisibility(8);
        this.f43631i.setVisibility(8);
        if (photoCacheDataArr != null && photoCacheDataArr.length > 0 && (photoCacheData3 = photoCacheDataArr[0]) != null && photoCacheData3.timevisible) {
            setVisibility(0);
            if (QZoneAlbumUtil.B(i16)) {
                j3 = photoCacheDataArr[0].shoottime;
            } else {
                j3 = photoCacheDataArr[0].uploadtime;
            }
            long j16 = j3 * 1000;
            if (j16 <= 0 && i3 != -1) {
                this.f43631i.setVisibility(0);
                this.f43631i.b(i3, aVar, aVar2, photoCacheDataArr, dVar, z17);
            } else {
                this.f43629f.setVisibility(0);
                this.f43627d.setVisibility(0);
                CustomAlbumItem e16 = aVar2 != null ? com.qzone.album.util.b.e(aVar2.g()) : null;
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar.setTimeInMillis(j16);
                calendar2.setTimeInMillis(System.currentTimeMillis());
                if (!z16 && aVar2 != null && !aVar2.D() && e16 != null && (materialFile = e16.stBgImage) != null && !TextUtils.isEmpty(materialFile.strUrl)) {
                    this.f43627d.setTextSize(14.0f);
                    this.f43627d.setTextColor((int) e16.iTextColor);
                    this.f43627d.setGravity(17);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f43627d.getLayoutParams();
                    layoutParams.gravity = 17;
                    this.f43627d.setLayoutParams(layoutParams);
                    QZoneAlbumUtil.F(e16.stBgImage.strUrl, new a());
                } else {
                    this.f43627d.setBackgroundDrawable(null);
                    this.f43627d.setGravity(3);
                    if (aVar2 != null && aVar2.getResources() != null) {
                        this.f43627d.setTextColor(aVar2.getResources().getColor(R.color.a_j));
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f43627d.getLayoutParams();
                    layoutParams2.width = -1;
                    layoutParams2.height = -2;
                    layoutParams2.gravity = 3;
                    this.f43627d.setLayoutParams(layoutParams2);
                }
                if (!z16 && calendar.get(1) == calendar2.get(1)) {
                    this.f43627d.setText(QZoneAlbumUtil.K(0, calendar.get(2) + 1, calendar.get(5)));
                } else {
                    this.f43627d.setText(QZoneAlbumUtil.K(calendar.get(1), calendar.get(2) + 1, calendar.get(5)));
                }
            }
            if (z16) {
                this.f43628e.setVisibility(0);
            } else {
                this.f43628e.setVisibility(8);
            }
            this.f43628e.setTag(photoCacheDataArr[0]);
        } else {
            setVisibility(8);
        }
        if (aVar2 != null && aVar2.f()) {
            if (photoCacheDataArr != null && photoCacheDataArr.length > 0 && (photoCacheData2 = photoCacheDataArr[0]) != null && photoCacheData2.descvisible && !TextUtils.isEmpty(photoCacheData2.desc)) {
                setVisibility(0);
                this.f43630h.setRichText(photoCacheDataArr[0].desc);
                this.f43630h.setVisibility(0);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f43630h.getLayoutParams();
                if (!photoCacheDataArr[0].timevisible) {
                    layoutParams3.topMargin = u4.a.z().o(12.0f);
                } else {
                    layoutParams3.topMargin = 0;
                }
                this.f43630h.setLayoutParams(layoutParams3);
            } else {
                this.f43630h.setVisibility(8);
            }
            if (!z16 && z17 && photoCacheDataArr != null && photoCacheDataArr.length > 0 && photoCacheDataArr[0] != null) {
                this.f43630h.setClickable(true);
                this.f43630h.setOnClickListener(aVar2.r(photoCacheDataArr[0]));
            }
            if (photoCacheDataArr != null && photoCacheDataArr.length > 0 && (photoCacheData = photoCacheDataArr[0]) != null && photoCacheData.timevisible) {
                if (photoCacheData.descvisible && !TextUtils.isEmpty(photoCacheData.desc)) {
                    if (photoCacheDataArr[0].timevisible) {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f43630h.getLayoutParams();
                        layoutParams4.topMargin = 0;
                        layoutParams4.bottomMargin = u4.a.z().o(11.0f);
                        this.f43630h.setLayoutParams(layoutParams4);
                    } else {
                        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f43630h.getLayoutParams();
                        layoutParams5.topMargin = u4.a.z().o(11.0f);
                        layoutParams5.bottomMargin = u4.a.z().o(11.0f);
                        this.f43630h.setLayoutParams(layoutParams5);
                    }
                } else {
                    this.f43630h.setVisibility(8);
                }
            }
        } else {
            this.f43630h.setVisibility(8);
        }
        if (photoCacheDataArr == null || photoCacheDataArr.length <= 0 || photoCacheDataArr[0] == null || aVar2 == null || !z16) {
            return;
        }
        ((u) aVar).v(dVar);
        if (photoCacheDataArr[0].allSelectedStatus) {
            this.f43628e.setSelected(true);
            this.f43628e.setText(l.a(R.string.orw));
        } else {
            this.f43628e.setSelected(false);
            this.f43628e.setText(l.a(R.string.orx));
        }
        this.f43631i.setBtnSelected(photoCacheDataArr[0].allSelectedStatus, aVar2.n(dVar));
        if (!aVar2.w() && !aVar2.A()) {
            this.f43628e.setOnClickListener(aVar2.n(dVar));
        } else {
            this.f43628e.setVisibility(4);
        }
    }
}
