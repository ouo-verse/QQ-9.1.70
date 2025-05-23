package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.LabelTag;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.ttpic.openapi.filter.LightConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AddRequestTabContainer extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private Context f315383d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f315384e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f315385f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<LinearLayout> f315386h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<a> f315387i;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f315388a;

        /* renamed from: b, reason: collision with root package name */
        public String f315389b;

        public static List<a> a(List<LabelTag> list) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                a aVar = new a();
                aVar.f315388a = list.get(i3).getIcon();
                aVar.f315389b = list.get(i3).getText();
                arrayList.add(aVar);
            }
            return arrayList;
        }
    }

    public AddRequestTabContainer(Context context) {
        this(context, null);
    }

    private View a(a aVar) {
        View inflate = View.inflate(this.f315383d, R.layout.gvl, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
        TextView textView = (TextView) inflate.findViewById(R.id.jfb);
        if (!TextUtils.isEmpty(aVar.f315388a)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.color.ajr, null);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            imageView.setImageDrawable(URLDrawable.getDrawable(aVar.f315388a, obtain));
            if (aVar.f315388a.contains(LightConstants.FEMALE)) {
                imageView.setContentDescription(getResources().getString(R.string.b5e));
            } else if (aVar.f315388a.contains(LightConstants.MALE)) {
                imageView.setContentDescription(getResources().getString(R.string.c7_));
            }
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(aVar.f315389b);
        if (this.f315384e) {
            inflate.setBackgroundResource(R.drawable.kog);
            textView.setTextColor(Color.parseColor("#8D8D93"));
        }
        return inflate;
    }

    private int b(a aVar) {
        Paint paint = new Paint();
        paint.setTextSize(ViewUtils.spToPx(10.0f));
        int measureText = ((int) (0 + paint.measureText(aVar.f315389b))) + (ViewUtils.dpToPx(6.0f) * 2);
        if (!TextUtils.isEmpty(aVar.f315388a)) {
            return measureText + ViewUtils.dpToPx(10.0f);
        }
        return measureText;
    }

    private void c() {
        for (int i3 = 0; i3 < 2; i3++) {
            LinearLayout linearLayout = new LinearLayout(this.f315383d);
            this.f315386h.add(linearLayout);
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i3 > 0) {
                layoutParams.topMargin = ViewUtils.dpToPx(5.0f);
            }
            addView(linearLayout, layoutParams);
        }
    }

    private void d() {
        int size = this.f315387i.size();
        int dpToPx = ViewUtils.dpToPx(6.0f);
        int i3 = 0;
        for (int i16 = 0; i16 < 2; i16++) {
            LinearLayout linearLayout = this.f315386h.get(i16);
            linearLayout.removeAllViewsInLayout();
            int width = getWidth();
            int i17 = 0;
            while (i3 < size) {
                a aVar = this.f315387i.get(i3);
                if (!TextUtils.isEmpty(aVar.f315389b)) {
                    int b16 = b(aVar);
                    int i18 = i17 + b16;
                    if (i18 <= width) {
                        View a16 = a(aVar);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        if (i18 + dpToPx <= width) {
                            layoutParams.rightMargin = dpToPx;
                            i17 += dpToPx;
                        }
                        linearLayout.addView(a16, layoutParams);
                        i17 += b16;
                    }
                }
                i3++;
            }
        }
        invalidate();
    }

    public void setData(List<a> list) {
        if (list == null) {
            return;
        }
        this.f315387i.clear();
        this.f315387i.addAll(list);
        d();
    }

    public void setNightTheme(boolean z16) {
        this.f315384e = z16;
    }

    public void setSimpleTheme(boolean z16) {
        this.f315385f = z16;
    }

    public AddRequestTabContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddRequestTabContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315384e = false;
        this.f315385f = false;
        this.f315386h = new ArrayList<>();
        this.f315387i = new ArrayList<>();
        this.f315383d = context;
        setOrientation(1);
        c();
    }
}
