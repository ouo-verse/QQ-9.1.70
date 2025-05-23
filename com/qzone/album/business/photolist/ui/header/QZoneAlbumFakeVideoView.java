package com.qzone.album.business.photolist.ui.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.adapter.p;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.R;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAlbumFakeVideoView extends RelativeLayout {
    private List<PhotoCacheData> C;
    private View.OnClickListener D;
    private x4.a E;

    /* renamed from: d, reason: collision with root package name */
    private Context f43368d;

    /* renamed from: e, reason: collision with root package name */
    private View f43369e;

    /* renamed from: f, reason: collision with root package name */
    private p f43370f;

    /* renamed from: h, reason: collision with root package name */
    private ListView f43371h;

    /* renamed from: i, reason: collision with root package name */
    private AlbumCacheData f43372i;

    /* renamed from: m, reason: collision with root package name */
    private HashMap<Integer, String> f43373m;

    public QZoneAlbumFakeVideoView(Context context) {
        super(context);
        this.C = new ArrayList();
        this.f43368d = context;
        c();
    }

    private void c() {
        Context context = this.f43368d;
        if (context == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168990bh0, this);
        this.f43369e = inflate;
        this.f43371h = (ListView) inflate.findViewById(R.id.f__);
        p pVar = new p(this.E, this.D);
        this.f43370f = pVar;
        pVar.B(com.qzone.album.env.common.a.m().s() == this.E.C());
        this.f43371h.setOnItemClickListener(new a());
    }

    public void a() {
        List<PhotoCacheData> list = this.C;
        if (list != null) {
            list.clear();
            p pVar = this.f43370f;
            if (pVar != null) {
                pVar.a(this.C);
            }
        }
    }

    public void b() {
        this.f43371h.setAdapter((ListAdapter) this.f43370f);
    }

    public void d() {
        p pVar = this.f43370f;
        if (pVar != null) {
            pVar.R(this.f43372i);
            this.f43370f.notifyDataSetChanged();
            setListViewHeightBasedOnChildren();
        }
    }

    public void setAlbumData(AlbumCacheData albumCacheData) {
        this.f43372i = albumCacheData;
    }

    public void setBusiParam(HashMap<Integer, String> hashMap) {
        this.f43373m = hashMap;
    }

    public void setListViewHeightBasedOnChildren() {
        p pVar;
        int i3;
        if (this.f43371h == null || (pVar = this.f43370f) == null) {
            return;
        }
        int count = pVar.getCount();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= count) {
                i3 = 0;
                break;
            }
            View view = this.f43370f.getView(i16, null, this.f43371h);
            view.measure(0, 0);
            if (i16 == 0) {
                i17 = view.getMeasuredHeight();
            }
            if (i16 == 1) {
                i3 = view.getMeasuredHeight();
                break;
            }
            i16++;
        }
        int count2 = this.f43370f.getCount() > 0 ? i17 + (i3 * (this.f43370f.getCount() - 1)) : 0;
        ViewGroup.LayoutParams layoutParams = this.f43371h.getLayoutParams();
        layoutParams.height = count2 + (this.f43371h.getDividerHeight() * (this.f43370f.getCount() - 1));
        this.f43371h.setLayoutParams(layoutParams);
    }

    public void setPhotoData(List<PhotoCacheData> list) {
        this.C = list;
        p pVar = this.f43370f;
        if (pVar != null) {
            pVar.a(list);
        }
    }

    public void setStatus(int i3) {
        p pVar = this.f43370f;
        if (pVar != null) {
            pVar.T(i3);
            this.f43370f.a(this.C);
            d();
        }
    }

    public QZoneAlbumFakeVideoView(Context context, x4.a aVar, View.OnClickListener onClickListener) {
        super(context);
        this.C = new ArrayList();
        this.f43368d = context;
        this.E = aVar;
        this.D = onClickListener;
        c();
    }

    public QZoneAlbumFakeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = new ArrayList();
        this.f43368d = context;
        c();
    }

    public QZoneAlbumFakeVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new ArrayList();
        this.f43368d = context;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        }
    }
}
