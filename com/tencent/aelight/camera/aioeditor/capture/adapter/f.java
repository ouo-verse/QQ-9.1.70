package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f extends BaseAdapter {
    public static final int E = ViewUtils.dpToPx(40.0f);
    public static final int F = ViewUtils.dpToPx(5.0f);
    public static final int G = ViewUtils.dpToPx(10.0f);
    int C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private Context f66648d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f66649e = false;

    /* renamed from: f, reason: collision with root package name */
    List<QIMFilterCategoryItem> f66650f = new ArrayList(0);

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<a> f66651h = new ArrayList<>(10);

    /* renamed from: i, reason: collision with root package name */
    float f66652i;

    /* renamed from: m, reason: collision with root package name */
    float f66653m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        URLImageView f66654a;

        /* renamed from: b, reason: collision with root package name */
        View f66655b;

        /* renamed from: c, reason: collision with root package name */
        TextView f66656c;

        /* renamed from: d, reason: collision with root package name */
        TransitionCategoryItem f66657d;

        /* renamed from: e, reason: collision with root package name */
        boolean f66658e = false;

        public void a(boolean z16) {
            View view = this.f66655b;
            if (view == null || this.f66657d == null) {
                return;
            }
            if (z16) {
                if (this.f66658e) {
                    view.setBackgroundResource(R.drawable.ebd);
                    return;
                } else {
                    view.setBackgroundResource(R.drawable.ec8);
                    return;
                }
            }
            if (this.f66658e) {
                view.setBackgroundResource(0);
            } else {
                view.setBackgroundResource(R.drawable.ec5);
            }
        }
    }

    public f(Context context, int i3) {
        this.f66648d = context;
        this.C = i3;
    }

    private View a() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f66648d);
        FrameLayout frameLayout = new FrameLayout(this.f66648d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (!this.f66649e) {
            int i3 = G;
            frameLayout.setPadding(i3, i3, i3, i3);
        } else {
            int i16 = F;
            frameLayout.setPadding(i16, 0, i16, i16);
        }
        int i17 = F;
        layoutParams.setMargins(i17, i17, i17, i17);
        relativeLayout.addView(frameLayout, layoutParams);
        URLImageView uRLImageView = new URLImageView(this.f66648d);
        uRLImageView.setId(R.id.icon);
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int i18 = E;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i18, i18);
        layoutParams2.gravity = 49;
        frameLayout.addView(uRLImageView, layoutParams2);
        TextView textView = new TextView(this.f66648d);
        textView.setId(R.id.cah);
        textView.setGravity(17);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(this.f66648d.getResources().getColor(R.color.f158017al3));
        textView.setMaxLines(1);
        textView.setLines(1);
        textView.setShadowLayer(3.0f, 0.0f, 0.0f, Color.parseColor("#7F000000"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        frameLayout.addView(textView, layoutParams3);
        a aVar = new a();
        aVar.f66654a = uRLImageView;
        aVar.f66655b = frameLayout;
        aVar.f66656c = textView;
        aVar.f66658e = this.f66649e;
        relativeLayout.setTag(aVar);
        this.f66651h.add(aVar);
        return relativeLayout;
    }

    public void b() {
        if (QLog.isColorLevel()) {
            QLog.d("TransitionProviderGridAdapter", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.D = true;
        this.f66651h.clear();
    }

    public void e() {
        TransitionCategoryItem v3 = m.n().v();
        Iterator<a> it = this.f66651h.iterator();
        while (it.hasNext()) {
            a next = it.next();
            TransitionCategoryItem transitionCategoryItem = next.f66657d;
            boolean z16 = false;
            if (transitionCategoryItem != null) {
                boolean equals = v3 != null ? TextUtils.equals(v3.f66697d, transitionCategoryItem.f66697d) : false;
                if (!equals) {
                    if ((v3 == null || v3.l()) && next.f66657d.l()) {
                        equals = true;
                    }
                }
                z16 = equals;
            }
            next.a(z16);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f66650f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f66650f.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (this.f66652i <= 0.0f && viewGroup != null) {
            float measuredWidth = viewGroup.getMeasuredWidth();
            this.f66652i = measuredWidth;
            if (this.f66649e) {
                this.f66653m = (((measuredWidth - viewGroup.getPaddingLeft()) - viewGroup.getPaddingRight()) / 3.2f) + 0.5f;
            } else {
                this.f66653m = (((measuredWidth - viewGroup.getPaddingLeft()) - viewGroup.getPaddingRight()) / 4.0f) + 0.5f;
            }
        }
        if (view == null) {
            view = a();
        }
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            TextView textView = aVar.f66656c;
            URLImageView uRLImageView = aVar.f66654a;
            TransitionCategoryItem transitionCategoryItem = (TransitionCategoryItem) this.f66650f.get(i3);
            aVar.f66657d = transitionCategoryItem;
            TransitionCategoryItem v3 = m.n().v();
            boolean z16 = false;
            boolean equals = v3 != null ? TextUtils.equals(v3.f66697d, transitionCategoryItem.f66697d) : false;
            if (!equals) {
                if ((v3 == null || v3.l()) && transitionCategoryItem.l()) {
                    z16 = true;
                }
                equals = z16;
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, -1);
                view.setLayoutParams(layoutParams);
            }
            ((ViewGroup.LayoutParams) layoutParams).height = (int) this.f66653m;
            aVar.a(equals);
            try {
                c(uRLImageView, transitionCategoryItem.P);
            } catch (Error e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TransitionProviderGridAdapter", 2, "setApngURLDrawable " + e16.toString());
                }
                d(uRLImageView, transitionCategoryItem.f66700h);
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("TransitionProviderGridAdapter", 2, "setApngURLDrawable " + e17.toString());
                }
                d(uRLImageView, transitionCategoryItem.f66700h);
            }
            textView.setText(transitionCategoryItem.f66698e);
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setContentDescription(transitionCategoryItem.f66698e + HardCodeUtil.qqStr(R.string.u8m));
        } else if (QLog.isColorLevel()) {
            QLog.d("TransitionProviderGridAdapter", 2, "ConvertViewTag null");
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    public void setData(List<QIMFilterCategoryItem> list) {
        this.f66650f = list;
    }

    private void c(ImageView imageView, String str) throws Exception {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            String str2 = this.f66648d.getFilesDir() + "/shortvideo_transition_preview/";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdir();
            }
            String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf("."));
            URLDrawable apngDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str2 + substring, str, null, new int[]{16}, "-Transition-", null);
            if (apngDrawable != null) {
                imageView.setImageDrawable(apngDrawable);
                if (apngDrawable.getStatus() == 2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TransitionProviderGridAdapter", 2, "restartDownload apng:" + str);
                    }
                    apngDrawable.restartDownload();
                    return;
                }
                return;
            }
            throw new Exception("urlDrawableApng null");
        }
        throw new Exception("apngUrl null");
    }

    private void d(ImageView imageView, String str) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            URLDrawable drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
            imageView.setImageDrawable(drawable);
        } catch (Error e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TransitionProviderGridAdapter", 2, "setStaticURLDrawable " + e16.toString());
            }
        }
    }
}
