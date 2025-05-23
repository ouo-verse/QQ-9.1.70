package com.tencent.mobileqq.aio.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f194245d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f194246e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f194247a;

        /* renamed from: b, reason: collision with root package name */
        String f194248b;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    protected static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f194249a;

        /* renamed from: b, reason: collision with root package name */
        TextView f194250b;

        protected b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public i(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f194246e = new ArrayList();
            this.f194245d = context;
        }
    }

    private Drawable c(int i3, int i16) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, f(i3));
        stateListDrawable.addState(new int[]{R.attr.state_focused}, f(i3));
        stateListDrawable.addState(new int[]{R.attr.state_selected}, f(i3));
        stateListDrawable.addState(new int[0], f(i16));
        return stateListDrawable;
    }

    private a e(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "seed";
        }
        a aVar = new a();
        String[] stringArray = context.getResources().getStringArray(com.tencent.mobileqq.R.array.f1907);
        String[] stringArray2 = context.getResources().getStringArray(com.tencent.mobileqq.R.array.f1896);
        char c16 = 0;
        if (!TextUtils.isEmpty(str)) {
            c16 = str.charAt(0);
        }
        aVar.f194247a = stringArray[c16 % stringArray.length];
        aVar.f194248b = stringArray2[c16 % stringArray2.length];
        return aVar;
    }

    private Drawable f(int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }

    private ColorStateList g(int i3, int i16, int i17, int i18) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_enabled}, new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[]{R.attr.state_enabled}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_window_focused}, new int[0]}, new int[]{i16, i17, i3, i17, i18, i3});
    }

    public void a(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            this.f194246e.addAll(list);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f194246e.clear();
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return this.f194246e.get(i3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f194246e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(com.tencent.mobileqq.R.layout.duc, (ViewGroup) null, false);
                bVar = new b();
                bVar.f194250b = (TextView) view.findViewById(com.tencent.mobileqq.R.id.f107846bi);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            String item = getItem(i3);
            if (!TextUtils.isEmpty(item)) {
                bVar.f194249a = i3;
                bVar.f194250b.setText(item);
                a e16 = e(item, this.f194245d);
                int parseColor = Color.parseColor(e16.f194247a);
                int parseColor2 = Color.parseColor(e16.f194248b);
                bVar.f194250b.setClickable(false);
                bVar.f194250b.setFocusable(false);
                bVar.f194250b.setBackgroundDrawable(c(parseColor2, parseColor2));
                bVar.f194250b.setTextColor(g(parseColor, parseColor, parseColor, parseColor));
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }
}
