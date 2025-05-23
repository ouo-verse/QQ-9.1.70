package com.qzone.widget;

import NS_MOBILE_FEEDS.FaceRecommendInfo;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.tool.ReportUtils;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes37.dex */
public class QzoneFaceFriendSelectPopWindow extends QzoneBubblePopWindow {

    /* renamed from: b, reason: collision with root package name */
    Context f60541b;

    /* renamed from: c, reason: collision with root package name */
    View f60542c;

    /* renamed from: d, reason: collision with root package name */
    QZonePullToRefreshListView f60543d;

    /* renamed from: e, reason: collision with root package name */
    RelativeLayout f60544e;

    /* renamed from: f, reason: collision with root package name */
    c f60545f;

    /* renamed from: g, reason: collision with root package name */
    ImageView f60546g;

    /* renamed from: h, reason: collision with root package name */
    private int f60547h;

    /* renamed from: i, reason: collision with root package name */
    protected d f60548i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZLog.d("[PhotoAlbum]FaceFuntion", 2, "touchFaceListIndex:", Integer.valueOf(QzoneFaceFriendSelectPopWindow.this.f60547h));
            QzoneFaceFriendSelectPopWindow qzoneFaceFriendSelectPopWindow = QzoneFaceFriendSelectPopWindow.this;
            d dVar = qzoneFaceFriendSelectPopWindow.f60548i;
            if (dVar != null) {
                dVar.b(qzoneFaceFriendSelectPopWindow.f60545f.b(), QzoneFaceFriendSelectPopWindow.this.f60547h);
            }
            QzoneFaceFriendSelectPopWindow.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            QZLog.d("[PhotoAlbum]FaceFuntion", 2, "position:", Integer.valueOf(i3));
            QzoneFaceFriendSelectPopWindow qzoneFaceFriendSelectPopWindow = QzoneFaceFriendSelectPopWindow.this;
            d dVar = qzoneFaceFriendSelectPopWindow.f60548i;
            if (dVar != null) {
                dVar.a(qzoneFaceFriendSelectPopWindow.f60545f.b(), i3, QzoneFaceFriendSelectPopWindow.this.f60547h);
            }
            QzoneFaceFriendSelectPopWindow.this.dismiss();
        }
    }

    /* loaded from: classes37.dex */
    public interface d {
        void a(FaceData faceData, int i3, int i16);

        void b(FaceData faceData, int i3);
    }

    /* loaded from: classes37.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        AsyncImageView f60556a;

        /* renamed from: b, reason: collision with root package name */
        TextView f60557b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f60558c;
    }

    public QzoneFaceFriendSelectPopWindow(Context context, int i3) {
        super(context);
        c(context, i3);
    }

    public void c(Context context, int i3) {
        this.f60541b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bhz, (ViewGroup) null);
        this.f60542c = inflate;
        setContentView(inflate);
        setWidth(-2);
        setHeight(-2);
        ((LinearLayout) this.f60542c.findViewById(R.id.f165123c10)).setLayoutParams(new LinearLayout.LayoutParams(i3 / 2, -2));
        this.f60543d = (QZonePullToRefreshListView) this.f60542c.findViewById(R.id.hb_);
        this.f60544e = (RelativeLayout) this.f60542c.findViewById(R.id.hba);
        this.f60546g = (ImageView) this.f60542c.findViewById(R.id.hb6);
        this.f60544e.setOnClickListener(new a());
        c cVar = new c();
        this.f60545f = cVar;
        this.f60543d.setAdapter((ListAdapter) cVar);
        this.f60543d.setSupportPullDown(false);
        this.f60543d.setOnItemClickListener(new b());
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // com.qzone.widget.QzoneBubblePopWindow, android.widget.PopupWindow
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
            QZLog.d("QzoneFaceFriendSelectPopWindow", 2, "dismiss error");
        }
    }

    public void e(d dVar) {
        this.f60548i = dVar;
    }

    public void f(int i3) {
        this.f60547h = i3;
    }

    /* loaded from: classes37.dex */
    public class c extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        FaceData f60551d;

        /* renamed from: e, reason: collision with root package name */
        protected final OvalProcessor f60552e = new OvalProcessor();

        public c() {
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FaceRecommendInfo getItem(int i3) {
            ArrayList<FaceRecommendInfo> arrayList;
            FaceData faceData = this.f60551d;
            if (faceData == null || (arrayList = faceData.recommend_infos) == null || i3 >= arrayList.size()) {
                return null;
            }
            return this.f60551d.recommend_infos.get(i3);
        }

        public FaceData b() {
            return this.f60551d;
        }

        public void c(FaceData faceData) {
            this.f60551d = faceData;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<FaceRecommendInfo> arrayList;
            FaceData faceData = this.f60551d;
            if (faceData == null || (arrayList = faceData.recommend_infos) == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            e eVar;
            if (view == null) {
                view = LayoutInflater.from(QzoneFaceFriendSelectPopWindow.this.f60541b).inflate(R.layout.f168994bi1, (ViewGroup) null);
                eVar = new e();
                eVar.f60556a = (AsyncImageView) view.findViewById(R.id.hbe);
                eVar.f60557b = (TextView) view.findViewById(R.id.hbd);
                eVar.f60558c = (ImageView) view.findViewById(R.id.haw);
                view.setTag(eVar);
            } else {
                eVar = (e) view.getTag();
            }
            if (getItem(i3) != null) {
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new AbsListView.LayoutParams(-1, ViewUtils.dip2px(46.0f));
                } else {
                    ((ViewGroup.LayoutParams) layoutParams).width = -1;
                    ((ViewGroup.LayoutParams) layoutParams).height = ViewUtils.dip2px(46.0f);
                }
                view.setLayoutParams(layoutParams);
                ImageLoader.Options obtain = ImageLoader.Options.obtain();
                obtain.useMainThread = true;
                obtain.extraProcessor = this.f60552e;
                int dip2px = ViewUtils.dip2px(30.0f);
                obtain.clipHeight = dip2px;
                obtain.clipWidth = dip2px;
                QZLog.d("QzoneFaceFriendSelectPopWindow", 2, "position:", Integer.valueOf(i3), " uin:", "avatar://" + getItem(i3).uin);
                Drawable loadImage = ImageLoader.getInstance().loadImage("avatar://" + getItem(i3).uin, new a(eVar), obtain);
                if (loadImage != null) {
                    eVar.f60556a.setImageDrawable(loadImage);
                } else {
                    eVar.f60556a.setImageDrawable(null);
                }
                eVar.f60557b.setText(getItem(i3).nick);
                eVar.f60557b.setTextColor(Color.rgb(255, 255, 255));
                eVar.f60557b.setSingleLine();
                if (i3 != getCount() - 1) {
                    eVar.f60558c.setVisibility(0);
                } else {
                    eVar.f60558c.setVisibility(8);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        /* loaded from: classes37.dex */
        class a implements ImageLoader.ImageLoadListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f60554d;

            a(e eVar) {
                this.f60554d = eVar;
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                this.f60554d.f60556a.setImageDrawable(drawable);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        }
    }

    public QzoneFaceFriendSelectPopWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QzoneFaceFriendSelectPopWindow(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void d(FaceData faceData, HashMap<String, FaceRecommendInfo> hashMap) {
        ArrayList<FaceRecommendInfo> arrayList;
        boolean z16;
        if (hashMap != null && faceData != null && !TextUtils.isEmpty(faceData.groupid) && hashMap.containsKey(faceData.groupid)) {
            if (faceData.recommend_infos == null) {
                faceData.recommend_infos = new ArrayList<>();
            }
            FaceRecommendInfo faceRecommendInfo = hashMap.get(faceData.groupid);
            int i3 = 0;
            while (true) {
                if (i3 >= faceData.recommend_infos.size()) {
                    z16 = false;
                    break;
                } else {
                    if (faceData.recommend_infos.get(i3).uin == faceRecommendInfo.uin) {
                        z16 = true;
                        break;
                    }
                    i3++;
                }
            }
            if (!z16) {
                ReportUtils.a("faceReport", ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "faceCacheHit", 1);
                faceData.recommend_infos.add(faceRecommendInfo);
            }
        }
        if (faceData != null && (arrayList = faceData.recommend_infos) != null && arrayList.size() > 0) {
            this.f60546g.setVisibility(0);
        } else {
            this.f60546g.setVisibility(8);
        }
        this.f60545f.c(faceData);
    }
}
