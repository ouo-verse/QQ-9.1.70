package com.qzone.album.business.photolist.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.qzone.album.business.photolist.adapter.u;
import com.qzone.album.business.photolist.ui.listitem.NormalHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class s extends o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends u.b {

        /* renamed from: d, reason: collision with root package name */
        NormalHeaderCell f42753d;

        a() {
            super();
        }
    }

    public s(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
    }

    @Override // com.qzone.album.business.photolist.adapter.u
    protected s4.d J(PhotoCacheData photoCacheData) {
        long j3;
        s4.d dVar = new s4.d();
        if (photoCacheData == null || !photoCacheData.timevisible) {
            return dVar;
        }
        if (QZoneAlbumUtil.B(this.I)) {
            j3 = photoCacheData.shoottime;
        } else {
            j3 = photoCacheData.uploadtime;
        }
        return this.R.get(Long.valueOf(j3));
    }

    @Override // com.qzone.album.business.photolist.adapter.u
    protected int K() {
        return u4.a.z().o(12.0f);
    }

    protected void U(a aVar, View view) {
        super.N(aVar, view);
        NormalHeaderCell normalHeaderCell = (NormalHeaderCell) view.findViewById(R.id.faf);
        aVar.f42753d = normalHeaderCell;
        normalHeaderCell.a(this.f42651d);
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public List<PhotoCacheData[]> a(List<PhotoCacheData> list) {
        List<PhotoCacheData> list2;
        if (QZoneAlbumUtil.B(this.I) && !this.f42651d.D()) {
            List<PhotoCacheData> list3 = this.P;
            if ((list3 == null || list3.size() == 0) && (list2 = this.X) != null) {
                this.P = list2;
            }
            o(list);
            list = H(this.I);
        }
        return super.a(list);
    }

    @Override // com.qzone.album.business.photolist.adapter.o
    public View R(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f42651d.getLayoutInflater().inflate(R.layout.bmi, (ViewGroup) null);
            aVar = new a();
            U(aVar, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        try {
            this.f42759e0.add(new WeakReference<>(aVar));
            V(aVar, view, i3);
        } catch (OutOfMemoryError e16) {
            com.qzone.proxy.feedcomponent.b.c("NormalPhotoListAdapter", e16.toString() + " position= " + i3);
        }
        return view;
    }

    private void V(a aVar, View view, int i3) {
        PhotoCacheData[] photoCacheDataArr;
        long j3;
        if (getItem(i3) == null || (photoCacheDataArr = (PhotoCacheData[]) getItem(i3)) == null || photoCacheDataArr.length == 0) {
            return;
        }
        int i16 = 0;
        s4.d J = J(photoCacheDataArr[0]);
        aVar.f42753d.b(this, this.f42651d, photoCacheDataArr, J, this.C, this.H, this.I, this.E);
        int L = L(i3);
        while (true) {
            int i17 = this.f42652e;
            if (i16 >= i17) {
                return;
            }
            int i18 = (i17 * i3) + i16;
            aVar.f42763b[i16].g();
            aVar.f42763b[i16].setTag(Integer.valueOf((this.f42652e * i3) + i16));
            aVar.f42763b[i16].setNumberCheckBoxTag(Integer.valueOf(i18));
            aVar.f42763b[i16].setCheckBoxTag(Integer.valueOf(i18));
            PhotoCacheData photoCacheData = photoCacheDataArr.length > i16 ? photoCacheDataArr[i16] : null;
            aVar.f42763b[i16].f(this.f42651d, false, photoCacheData, null, this.C, this.D);
            if (photoCacheData != null) {
                if (AccessibilityUtil.j(this.f42651d.k())) {
                    if (QZoneAlbumUtil.B(this.I)) {
                        j3 = photoCacheData.shoottime;
                    } else {
                        j3 = photoCacheData.uploadtime;
                    }
                    aVar.f42763b[i16].setContentDescription(com.qzone.util.l.a(R.string.f172242os1) + ((i18 - L) + 1) + ", " + com.qzone.album.util.g.d(j3 * 1000));
                    ViewCompat.replaceAccessibilityAction(aVar.f42763b[i16], AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK, "\u8fdb\u5165\u591a\u9009\u72b6\u6001", null);
                }
                aVar.f42763b[i16].setOnClickListener(null);
                aVar.f42763b[i16].setOnLongClickListener(null);
                if (this.C && !this.f42651d.w()) {
                    PhotoCacheData photoCacheData2 = photoCacheData;
                    aVar.f42763b[i16].setOnClickListener(this.f42651d.s((this.f42652e * i3) + i16, photoCacheData.fakeType, photoCacheData.lloc, photoCacheData2, J));
                    aVar.f42763b[i16].setCBClickListener(this.f42651d.z((this.f42652e * i3) + i16, photoCacheData.fakeType, photoCacheData.lloc, photoCacheData2, J));
                } else {
                    if (TextUtils.isEmpty(photoCacheData.clientKey)) {
                        aVar.f42763b[i16].setOnClickListener(this.V);
                        aVar.f42763b[i16].setOnLongClickListener(this.W);
                    }
                    aVar.f42763b[i16].setClickBoxImgVisibility(8);
                }
            }
            i16++;
        }
    }
}
