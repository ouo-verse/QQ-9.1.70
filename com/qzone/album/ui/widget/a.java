package com.qzone.album.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.RecomAlbumExData;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f44257a;

    /* renamed from: b, reason: collision with root package name */
    private Context f44258b;

    /* renamed from: c, reason: collision with root package name */
    private int f44259c;

    /* renamed from: d, reason: collision with root package name */
    private List<d> f44260d;

    /* renamed from: e, reason: collision with root package name */
    private int f44261e;

    /* renamed from: h, reason: collision with root package name */
    private int f44264h;

    /* renamed from: i, reason: collision with root package name */
    private int f44265i;

    /* renamed from: k, reason: collision with root package name */
    private String f44267k;

    /* renamed from: m, reason: collision with root package name */
    private c f44269m;

    /* renamed from: f, reason: collision with root package name */
    private int f44262f = 1;

    /* renamed from: g, reason: collision with root package name */
    private int f44263g = 1;

    /* renamed from: j, reason: collision with root package name */
    private boolean f44266j = true;

    /* renamed from: l, reason: collision with root package name */
    private int f44268l = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_GALLERY_RECOM_COUNT_LIMIT, 999);

    /* renamed from: n, reason: collision with root package name */
    private View.OnClickListener f44270n = new ViewOnClickListenerC0352a();

    /* compiled from: P */
    /* renamed from: com.qzone.album.ui.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class ViewOnClickListenerC0352a implements View.OnClickListener {
        ViewOnClickListenerC0352a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (a.this.f44269m != null) {
                a.this.f44269m.onClicked(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f44272a = -16777216;

        /* renamed from: b, reason: collision with root package name */
        public int f44273b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f44274c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f44275d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f44276e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f44277f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f44278g = R.drawable.fwe;

        /* renamed from: h, reason: collision with root package name */
        public int f44279h = R.drawable.fwi;

        public b a(int i3) {
            this.f44273b = i3;
            this.f44276e = i3;
            this.f44274c = i3;
            this.f44275d = i3;
            this.f44277f = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface c {
        void onClicked(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        View f44280a;

        /* renamed from: b, reason: collision with root package name */
        e<TextView> f44281b;

        /* renamed from: c, reason: collision with root package name */
        e<TextView> f44282c;

        /* renamed from: d, reason: collision with root package name */
        e<TextView> f44283d;

        /* renamed from: e, reason: collision with root package name */
        e<TextView> f44284e;

        /* renamed from: f, reason: collision with root package name */
        e<AsyncImageView> f44285f;

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e<T extends View> {

        /* renamed from: a, reason: collision with root package name */
        public T f44287a;

        public e(View view, int i3) {
            if (view != null) {
                this.f44287a = (T) view.findViewById(i3);
            }
        }
    }

    public a(int i3, Context context, int i16, int i17, int i18, int i19, c cVar) {
        this.f44257a = 1;
        this.f44259c = -1;
        this.f44261e = 1;
        this.f44264h = 1;
        this.f44265i = 1;
        this.f44257a = i3;
        this.f44258b = context;
        this.f44259c = i16;
        this.f44261e = i17;
        this.f44264h = i18;
        this.f44265i = i19;
        this.f44269m = cVar;
    }

    private void b() {
        int i3 = (this.f44261e - (this.f44264h * 2)) / 3;
        this.f44262f = i3;
        this.f44263g = i3;
    }

    private d d() {
        d dVar = new d();
        View inflate = LayoutInflater.from(this.f44258b).inflate(this.f44259c, (ViewGroup) null);
        if (inflate == null) {
            return null;
        }
        dVar.f44280a = inflate;
        dVar.f44283d = new e<>(inflate, R.id.hcu);
        dVar.f44285f = new e<>(inflate, R.id.hcs);
        dVar.f44284e = new e<>(inflate, R.id.hcq);
        dVar.f44281b = new e<>(inflate, R.id.hcv);
        dVar.f44282c = new e<>(inflate, R.id.hcx);
        return dVar;
    }

    private String g(int i3) {
        int i16;
        String str = this.f44267k;
        if (str != null && i3 > (i16 = this.f44268l)) {
            return String.format(str, Integer.valueOf(i16));
        }
        return String.valueOf(i3);
    }

    private void k(int i3, AlbumCacheData albumCacheData, RecomAlbumExData recomAlbumExData) {
        if (i3 >= this.f44260d.size() || albumCacheData == null) {
            return;
        }
        d dVar = this.f44260d.get(i3);
        AsyncImageView asyncImageView = dVar.f44285f.f44287a;
        asyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        asyncImageView.setAdjustViewBounds(false);
        asyncImageView.setAsyncClipSize(this.f44262f, this.f44263g);
        asyncImageView.setAsyncImage(albumCacheData.getLloc());
        asyncImageView.setAsyncImageProcessor(new RoundCornerProcessor(3.0f));
        dVar.f44283d.f44287a.setText(albumCacheData.albumname);
        dVar.f44284e.f44287a.setText(g(albumCacheData.albumnum));
        dVar.f44282c.f44287a.setText(g(recomAlbumExData.viewCount));
        dVar.f44281b.f44287a.setText(g(recomAlbumExData.likeCnt));
        dVar.f44280a.setTag(albumCacheData);
        if (this.f44266j) {
            dVar.f44280a.setOnClickListener(this.f44270n);
            dVar.f44280a.setClickable(true);
        } else {
            dVar.f44280a.setClickable(false);
        }
        dVar.f44280a.setVisibility(0);
    }

    public void e(AlbumCacheData[] albumCacheDataArr, RecomAlbumExData recomAlbumExData) {
        List<d> list = this.f44260d;
        if (list == null || albumCacheDataArr == null || list.size() < albumCacheDataArr.length) {
            return;
        }
        for (int i3 = 0; i3 < albumCacheDataArr.length; i3++) {
            this.f44260d.get(i3).f44280a.setVisibility(8);
            k(i3, albumCacheDataArr[i3], recomAlbumExData);
        }
        if (albumCacheDataArr.length != this.f44260d.size()) {
            int size = this.f44260d.size() - albumCacheDataArr.length;
            int length = albumCacheDataArr.length;
            if (size > 0) {
                for (int i16 = 0; i16 < size; i16++) {
                    this.f44260d.get(i16 + length).f44280a.setVisibility(8);
                }
            }
        }
    }

    public ArrayList<View> f() {
        ArrayList<View> arrayList = new ArrayList<>();
        Iterator<d> it = this.f44260d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f44280a);
        }
        return arrayList;
    }

    public View h() {
        Context context;
        if (this.f44259c == -1 || this.f44257a == -1 || (context = this.f44258b) == null) {
            return null;
        }
        Resources resources = context.getResources();
        if (resources != null) {
            this.f44267k = resources.getString(R.string.gn8);
        }
        if (this.f44260d == null) {
            this.f44260d = new ArrayList();
        }
        this.f44260d.clear();
        b();
        LinearLayout linearLayout = new LinearLayout(this.f44258b);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ar.l(), -2);
        linearLayout.setLayoutParams(layoutParams);
        for (int i3 = 0; i3 < this.f44257a; i3++) {
            d d16 = d();
            d c16 = c(d16);
            if (c16 != null) {
                d16 = c16;
            }
            this.f44260d.add(d16);
            d16.f44280a.setLayoutParams(layoutParams);
            linearLayout.addView(d16.f44280a);
        }
        return linearLayout;
    }

    public void i(View view) {
        c cVar = this.f44269m;
        if (cVar == null || view == null) {
            return;
        }
        cVar.onClicked(view);
    }

    public void j() {
        List<d> list = this.f44260d;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<d> it = this.f44260d.iterator();
        while (it.hasNext()) {
            it.next().f44285f.f44287a.cancelAsyncLoadImageWithoutListener();
        }
    }

    private d c(d dVar) {
        if (dVar == null) {
            return null;
        }
        int i3 = this.f44264h;
        dVar.f44280a.setLayoutParams(new LinearLayout.LayoutParams((this.f44261e - i3) - i3, -2));
        View view = dVar.f44280a;
        int i16 = this.f44265i;
        view.setPadding(i3, i16, i3, i16);
        return dVar;
    }
}
