package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.ui.PhotoHorizontalScrollView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes32.dex */
public class PhotoWallViewForAccountDetail extends LinearLayout {
    public int C;
    public int D;
    public GridView E;
    private ImageView F;
    private View G;
    public PhotoHorizontalScrollView H;
    private AdapterView.OnItemClickListener I;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f78811d;

    /* renamed from: e, reason: collision with root package name */
    View f78812e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f78813f;

    /* renamed from: h, reason: collision with root package name */
    public List<IPublicAccountConfigAttr.a> f78814h;

    /* renamed from: i, reason: collision with root package name */
    public c f78815i;

    /* renamed from: m, reason: collision with root package name */
    public int f78816m;

    /* loaded from: classes32.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPublicAccountConfigAttr.a aVar = PhotoWallViewForAccountDetail.this.f78814h.get(i3);
            c cVar = PhotoWallViewForAccountDetail.this.f78815i;
            if (cVar == null) {
                return;
            }
            cVar.a(aVar);
        }
    }

    /* loaded from: classes32.dex */
    public class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private Context f78818d;

        /* renamed from: e, reason: collision with root package name */
        private LayoutInflater f78819e;

        /* renamed from: f, reason: collision with root package name */
        List<IPublicAccountConfigAttr.a> f78820f;

        /* loaded from: classes32.dex */
        class a {

            /* renamed from: a, reason: collision with root package name */
            URLImageView f78822a;

            a() {
            }
        }

        public b(Context context) {
            this.f78819e = null;
            this.f78818d = context;
            this.f78819e = LayoutInflater.from(context);
        }

        public void a(List<IPublicAccountConfigAttr.a> list) {
            this.f78820f = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<IPublicAccountConfigAttr.a> list = this.f78820f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            List<IPublicAccountConfigAttr.a> list = this.f78820f;
            if (list != null) {
                return list.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i3, View view, ViewGroup viewGroup) {
            String str;
            View view2;
            a aVar;
            JSONArray jSONArray;
            try {
                jSONArray = new JSONArray(this.f78820f.get(i3).f79339k);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AccountDetail.PhotoWallViewForAccountDetail", 2, "RICH_PIC_TEXT:pic json error!");
                }
                e16.printStackTrace();
            }
            if (jSONArray.length() > 0) {
                str = jSONArray.optString(0);
                if (view != null) {
                    aVar = new a();
                    view2 = this.f78819e.inflate(R.layout.c4v, (ViewGroup) null);
                    PhotoWallViewForAccountDetail photoWallViewForAccountDetail = PhotoWallViewForAccountDetail.this;
                    view2.setLayoutParams(new AbsListView.LayoutParams(photoWallViewForAccountDetail.f78816m, photoWallViewForAccountDetail.C));
                    aVar.f78822a = (URLImageView) view2.findViewById(R.id.fqt);
                    view2.setTag(aVar);
                } else {
                    view2 = view;
                    aVar = (a) view.getTag();
                }
                aVar.f78822a.setTag(new com.tencent.mobileqq.profile.b(25, Integer.valueOf(i3)));
                if (!TextUtils.isEmpty(str)) {
                    aVar.f78822a.setImageResource(R.drawable.b9s);
                } else {
                    aVar.f78822a.setImageDrawable(URLDrawable.getDrawable(str));
                }
                return view2;
            }
            str = null;
            if (view != null) {
            }
            aVar.f78822a.setTag(new com.tencent.mobileqq.profile.b(25, Integer.valueOf(i3)));
            if (!TextUtils.isEmpty(str)) {
            }
            return view2;
        }
    }

    /* loaded from: classes32.dex */
    public interface c {
        void a(IPublicAccountConfigAttr.a aVar);
    }

    public PhotoWallViewForAccountDetail(Context context) {
        super(context);
        this.f78816m = -1;
        this.C = -1;
        this.D = -1;
        this.I = new a();
    }

    public void a(BaseActivity baseActivity, List<IPublicAccountConfigAttr.a> list) {
        if (QLog.isColorLevel()) {
            QLog.i("AccountDetail.PhotoWallViewForAccountDetail", 2, "initView");
        }
        this.f78813f = baseActivity;
        this.f78811d = baseActivity.app;
        if (list != null && list.size() > 20) {
            this.f78814h = list.subList(0, 20);
        } else {
            this.f78814h = list;
        }
        View inflate = LayoutInflater.from(this.f78811d.getApplication()).inflate(R.layout.c4t, (ViewGroup) this, true);
        this.f78812e = inflate;
        GridView gridView = (GridView) inflate.findViewById(R.id.fqh);
        this.E = gridView;
        gridView.setClickable(true);
        this.H = (PhotoHorizontalScrollView) this.f78812e.findViewById(R.id.fqi);
        this.F = (ImageView) this.f78812e.findViewById(R.id.g1c);
        this.G = this.f78812e.findViewById(R.id.h77);
        this.D = getResources().getDimensionPixelSize(R.dimen.f158154a);
        this.f78816m = getResources().getDimensionPixelSize(R.dimen.f158156c);
        this.C = getResources().getDimensionPixelSize(R.dimen.f158155b);
        if (VersionUtils.isGingerBread()) {
            this.H.setOverScrollMode(2);
        }
        b();
    }

    public void b() {
        if (QLog.isColorLevel() && this.f78814h != null) {
            QLog.i("AccountDetail.PhotoWallViewForAccountDetail", 2, "updatePhotoView urlList size=" + this.f78814h.size());
        }
        List<IPublicAccountConfigAttr.a> list = this.f78814h;
        if ((list != null ? list.size() : 0) > 0) {
            this.E.setColumnWidth(this.f78816m);
            this.E.setStretchMode(0);
            this.E.setHorizontalSpacing(this.D);
            b bVar = new b(this.f78813f);
            bVar.a(this.f78814h);
            int size = this.f78814h.size();
            this.E.setLayoutParams(new LinearLayout.LayoutParams((this.f78816m + this.D) * size, this.C));
            this.E.setNumColumns(size);
            this.E.setAdapter((ListAdapter) bVar);
            this.E.setOnItemClickListener(this.I);
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            this.E.setVisibility(0);
            setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setPhotoWallCallback(c cVar) {
        this.f78815i = cVar;
    }

    public PhotoWallViewForAccountDetail(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f78816m = -1;
        this.C = -1;
        this.D = -1;
        this.I = new a();
    }

    public PhotoWallViewForAccountDetail(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f78816m = -1;
        this.C = -1;
        this.D = -1;
        this.I = new a();
    }
}
