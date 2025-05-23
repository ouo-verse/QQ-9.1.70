package com.tencent.biz.pubaccount.imagecollection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl;
import com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionUtilsImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static Context f79842c = null;

    /* renamed from: d, reason: collision with root package name */
    private static int f79843d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static int f79844e = 0;

    /* renamed from: f, reason: collision with root package name */
    static boolean f79845f = false;

    /* renamed from: g, reason: collision with root package name */
    static ArrayList<IPublicAccountImageCollectionUtils.d> f79846g = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    private Activity f79847a;

    /* renamed from: b, reason: collision with root package name */
    protected AdapterView.OnItemClickListener f79848b = new a();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends BaseAdapter {

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a {

            /* renamed from: a, reason: collision with root package name */
            URLImageView f79851a;

            /* renamed from: b, reason: collision with root package name */
            TextView f79852b;

            a() {
            }
        }

        public b() {
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPublicAccountImageCollectionUtils.d getItem(int i3) {
            ArrayList<IPublicAccountImageCollectionUtils.d> arrayList = c.f79846g;
            if (arrayList != null) {
                return arrayList.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<IPublicAccountImageCollectionUtils.d> arrayList = c.f79846g;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(c.f79842c).inflate(R.layout.f168399uw, viewGroup, false);
                aVar = new a();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = (c.f79843d - BaseAIOUtils.f(110.0f, c.f79842c.getResources())) / 3;
                view.setLayoutParams(layoutParams);
                if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "height of item is" + layoutParams.height);
                }
                URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.i2r);
                aVar.f79851a = uRLImageView;
                ViewGroup.LayoutParams layoutParams2 = uRLImageView.getLayoutParams();
                int f16 = (c.f79844e - BaseAIOUtils.f(2.0f, c.f79842c.getResources())) / 2;
                layoutParams2.width = f16;
                layoutParams2.height = (f16 * 9) / 16;
                aVar.f79851a.setLayoutParams(layoutParams2);
                if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "height of image is" + layoutParams2.height);
                }
                aVar.f79852b = (TextView) view.findViewById(R.id.i37);
                int i16 = (layoutParams.height - layoutParams2.height) - BaseAIOUtils.f(40.0f, c.f79842c.getResources()) > BaseAIOUtils.f(16.0f, c.f79842c.getResources()) ? 2 : 1;
                if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, " number is" + i16);
                }
                Build.MANUFACTURER.toLowerCase().contains("meizu");
                aVar.f79852b.setMaxLines(i16);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            IPublicAccountImageCollectionUtils.d item = getItem(i3);
            if (item != null) {
                String str = item.f79752a;
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
                obtain.mLoadingDrawable = colorDrawable;
                obtain.mFailedDrawable = colorDrawable;
                URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
                if (drawable != null && drawable.getStatus() == 2) {
                    drawable.restartDownload();
                }
                aVar.f79851a.setImageDrawable(drawable);
                aVar.f79852b.setText(item.f79753b);
                if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "recommendInfo position = " + i3 + "; url =" + drawable + "; title = " + item.f79753b);
                }
            }
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.imagecollection.c$c, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0813c {

        /* renamed from: a, reason: collision with root package name */
        GridView f79854a;

        /* renamed from: b, reason: collision with root package name */
        VideoFeedsAlphaMaskView f79855b;

        /* renamed from: c, reason: collision with root package name */
        TextView f79856c;

        C0813c() {
        }
    }

    public c(Activity activity, ArrayList<IPublicAccountImageCollectionUtils.d> arrayList, int i3, int i16, boolean z16) {
        this.f79847a = activity;
        f79842c = activity.getApplicationContext();
        f79843d = i3;
        f79844e = i16;
        f79845f = z16;
        f79846g = g(arrayList);
    }

    private void e(RelativeLayout relativeLayout) {
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "buildView!");
        }
        int f16 = BaseAIOUtils.f(2.0f, f79842c.getResources());
        int i3 = (f79844e - f16) / 2;
        GridView gridView = (GridView) relativeLayout.findViewById(R.id.i2p);
        gridView.setColumnWidth(i3);
        gridView.setStretchMode(0);
        gridView.setHorizontalSpacing(f16);
        gridView.setLayoutParams(new RelativeLayout.LayoutParams(-1, h()));
        gridView.setNumColumns(2);
        gridView.setOnItemClickListener(this.f79848b);
        gridView.setOverScrollMode(2);
        gridView.setAdapter((ListAdapter) new b());
    }

    private ArrayList<IPublicAccountImageCollectionUtils.d> g(ArrayList<IPublicAccountImageCollectionUtils.d> arrayList) {
        ArrayList<IPublicAccountImageCollectionUtils.d> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            return null;
        }
        if (arrayList.size() <= 6) {
            arrayList2.addAll(arrayList);
        } else {
            for (int i3 = 0; i3 < 6; i3++) {
                arrayList2.add(arrayList.get(i3));
            }
        }
        return arrayList2;
    }

    static int h() {
        int i3;
        ArrayList<IPublicAccountImageCollectionUtils.d> arrayList = f79846g;
        if (arrayList == null) {
            return 0;
        }
        int size = arrayList.size();
        int f16 = (f79843d - BaseAIOUtils.f(110.0f, f79842c.getResources())) / 3;
        if (size % 2 == 0) {
            i3 = size / 2;
        } else {
            i3 = (size + 1) / 2;
        }
        return i3 * f16;
    }

    public void i(ArrayList<IPublicAccountImageCollectionUtils.d> arrayList) {
        f79846g = g(arrayList);
    }

    public View f(Activity activity, View view, ViewGroup viewGroup) {
        RelativeLayout relativeLayout;
        Object tag;
        if (view != null && (view instanceof RelativeLayout) && (tag = (relativeLayout = (RelativeLayout) view).getTag()) != null && (tag instanceof C0813c)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView reuse!");
            }
            return relativeLayout;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView new create!");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) LayoutInflater.from(activity).inflate(R.layout.f168400ux, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = relativeLayout2.getLayoutParams();
        layoutParams.height = f79843d;
        relativeLayout2.setLayoutParams(layoutParams);
        C0813c c0813c = new C0813c();
        c0813c.f79854a = (GridView) relativeLayout2.findViewById(R.id.i2p);
        c0813c.f79855b = (VideoFeedsAlphaMaskView) relativeLayout2.findViewById(R.id.enp);
        c0813c.f79856c = (TextView) relativeLayout2.findViewById(R.id.i2c);
        relativeLayout2.setTag(c0813c);
        if (f79846g == null && f79845f) {
            if (QLog.isDevelopLevel()) {
                QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView getRecommendInfo error");
            }
            c0813c.f79854a.setVisibility(8);
            c0813c.f79856c.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = c0813c.f79855b.getLayoutParams();
            layoutParams2.height = f79843d - BaseAIOUtils.f(66.0f, f79842c.getResources());
            c0813c.f79855b.setLayoutParams(layoutParams2);
        } else {
            ViewGroup.LayoutParams layoutParams3 = c0813c.f79855b.getLayoutParams();
            layoutParams3.height = h();
            c0813c.f79855b.setLayoutParams(layoutParams3);
            c0813c.f79854a.setVisibility(0);
            c0813c.f79856c.setVisibility(8);
            e(relativeLayout2);
        }
        return relativeLayout2;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "onItemClick!");
            }
            IPublicAccountImageCollectionUtils.d dVar = c.f79846g.get(i3);
            Intent intent = new Intent(view.getContext(), (Class<?>) PublicAccountImageCollectionMainActivityImpl.class);
            intent.putExtra(IPublicAccountImageCollectionMainActivity.RECOMMEND_SOURCE, dVar.f79754c);
            int i16 = i3 + 1;
            intent.putExtra(IPublicAccountImageCollectionMainActivity.RECOMMEND_POSITION, i16);
            intent.putExtra(IPublicAccountImageCollectionMainActivity.CLICK_SOURCE, 2);
            intent.putExtra(IPublicAccountImageCollectionMainActivity.SOURCE_FOR_REPORT, 15);
            PublicAccountImageCollectionUtilsImpl.openPublicAccountImageCollectionMainActivityInner(c.this.f79847a, intent, String.valueOf(dVar.f79755d));
            if (c.this.f79847a instanceof PublicAccountImageCollectionMainActivityImpl) {
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl = (PublicAccountImageCollectionMainActivityImpl) c.this.f79847a;
                publicAccountImageCollectionMainActivityImpl.reportOntime(2, i16, dVar.f79754c);
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, publicAccountImageCollectionMainActivityImpl.puin, "0X8007B94", "0X8007B94", 0, 0, publicAccountImageCollectionMainActivityImpl.articleID, publicAccountImageCollectionMainActivityImpl.webUrl, dVar.f79755d, "" + i16, false);
            }
            ((IImageManager) QRoute.api(IImageManager.class)).clean();
        }
    }
}
