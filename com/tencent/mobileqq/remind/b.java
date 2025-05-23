package com.tencent.mobileqq.remind;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f280869d;

    /* renamed from: e, reason: collision with root package name */
    private int f280870e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f280871f;

    /* renamed from: h, reason: collision with root package name */
    private int f280872h;

    /* renamed from: i, reason: collision with root package name */
    private int f280873i;

    public b(Context context, String[] strArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, strArr, Integer.valueOf(i3));
            return;
        }
        this.f280870e = 25;
        this.f280871f = null;
        this.f280869d = context;
        this.f280870e = (int) TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
        this.f280871f = strArr;
        Resources resources = this.f280869d.getResources();
        this.f280872h = resources.getColor(R.color.skin_gray6);
        this.f280873i = resources.getColor(R.color.skin_color_white);
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public View getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return getView(i3, null, null);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        String[] strArr = this.f280871f;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        WheelTextView wheelTextView;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                wheelTextView = new WheelTextView(this.f280869d);
                wheelTextView.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.f280870e));
                view2 = wheelTextView;
            } else {
                view2 = view;
                wheelTextView = null;
            }
            String str = this.f280871f[i3];
            if (wheelTextView == null) {
                wheelTextView = (WheelTextView) view2;
            }
            wheelTextView.setTextSize(20.0f);
            wheelTextView.setTextColor(this.f280872h);
            wheelTextView.setGravity(17);
            wheelTextView.setText(str);
            wheelTextView.setBackgroundColor(this.f280873i);
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }
}
