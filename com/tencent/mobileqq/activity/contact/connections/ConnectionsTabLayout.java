package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.structmsg.f;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ConnectionsTabLayout extends TabLayoutCompat implements TabLayoutCompat.c {
    static IPatchRedirector $redirector_;

    /* renamed from: i0, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.activity.contact.connections.a> f181229i0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f181230d;

        a(View view) {
            this.f181230d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConnectionsTabLayout.this, (Object) view);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    this.f181230d.setAlpha(1.0f);
                    this.f181230d.performClick();
                    return false;
                }
                return false;
            }
            this.f181230d.setAlpha(0.5f);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        ImageView f181232a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f181233b;

        /* renamed from: c, reason: collision with root package name */
        TextView f181234c;

        /* renamed from: d, reason: collision with root package name */
        TextView f181235d;

        /* renamed from: e, reason: collision with root package name */
        TriangleView f181236e;

        public b(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.f181232a = (ImageView) view.findViewById(R.id.lxb);
            this.f181233b = (ImageView) view.findViewById(R.id.lx9);
            this.f181234c = (TextView) view.findViewById(R.id.lxc);
            this.f181235d = (TextView) view.findViewById(R.id.lxa);
            this.f181236e = (TriangleView) view.findViewById(R.id.f167009jw1);
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ImageView imageView = this.f181232a;
            if (imageView != null) {
                imageView.setSelected(true);
            }
            ImageView imageView2 = this.f181233b;
            if (imageView2 != null) {
                imageView2.setSelected(true);
            }
            TextView textView = this.f181234c;
            if (textView != null) {
                textView.setSelected(true);
            }
            TextView textView2 = this.f181235d;
            if (textView2 != null) {
                textView2.setSelected(true);
            }
            TriangleView triangleView = this.f181236e;
            if (triangleView != null) {
                triangleView.setVisibility(0);
            }
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            ImageView imageView = this.f181232a;
            if (imageView != null) {
                imageView.setSelected(false);
            }
            ImageView imageView2 = this.f181233b;
            if (imageView2 != null) {
                imageView2.setSelected(false);
            }
            TextView textView = this.f181234c;
            if (textView != null) {
                textView.setSelected(false);
            }
            TextView textView2 = this.f181235d;
            if (textView2 != null) {
                textView2.setSelected(false);
            }
            TriangleView triangleView = this.f181236e;
            if (triangleView != null) {
                triangleView.setVisibility(4);
            }
        }
    }

    public ConnectionsTabLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void U(View view) {
        if (view == null) {
            return;
        }
        view.setClickable(true);
        view.setOnTouchListener(new a(view));
    }

    private void V(TabLayoutCompat.f fVar, b bVar, com.tencent.mobileqq.activity.contact.connections.a aVar) {
        int i3;
        String str;
        if (fVar != null && bVar != null && aVar != null) {
            fVar.o(Integer.valueOf(aVar.f181253a));
            bVar.f181234c.setText(aVar.f181255c);
            if (SimpleUIUtil.isNowElderMode()) {
                bVar.f181234c.setTextSize(0, ViewUtils.dip2px(18.0f));
            }
            String string = getContext().getResources().getString(R.string.iyq, Integer.valueOf(aVar.f181254b));
            if (!aVar.f181258f) {
                string = getContext().getResources().getString(R.string.iyo);
            }
            bVar.f181235d.setText(string);
            Drawable a06 = a0(aVar.f181256d, aVar.f181257e);
            if (a06 != null) {
                bVar.f181232a.setImageDrawable(a06);
            }
            Resources resources = getContext().getResources();
            if (QQTheme.isNowThemeIsNight()) {
                i3 = R.color.cru;
            } else {
                i3 = R.color.skin_qq_tab_color;
            }
            int color = resources.getColor(i3);
            if (QQTheme.isNowThemeIsNight()) {
                str = "#282828";
            } else {
                str = "#F5F6FA";
            }
            int parseColor = Color.parseColor(str);
            Drawable Z = Z(color, parseColor);
            if (Z != null) {
                bVar.f181233b.setBackgroundDrawable(Z);
            } else {
                bVar.f181233b.setImageResource(R.drawable.hj7);
            }
            if (color != 0) {
                bVar.f181236e.setDrawColor(color);
            } else {
                bVar.f181236e.setDrawColor(parseColor);
            }
            if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
                ColorStateList colorStateList = getContext().getResources().getColorStateList(R.color.amt);
                ColorStateList colorStateList2 = getContext().getResources().getColorStateList(R.color.amv);
                bVar.f181234c.setTextColor(colorStateList);
                bVar.f181235d.setTextColor(colorStateList2);
            }
            U(fVar.e());
        }
    }

    private URLDrawable X(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (obtain.mLoadingDrawable == null) {
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        if (obtain.mFailedDrawable == null) {
            obtain.mFailedDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        if (QLog.isColorLevel()) {
            QLog.d("ConnectionsTabLayout", 2, "getDrawable downLoadUrl ->" + str);
        }
        return drawable;
    }

    private void b0() {
        setSelectedTabIndicatorHeight(0);
    }

    @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
    public void J8(TabLayoutCompat.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fVar);
        }
    }

    public void W(ArrayList<com.tencent.mobileqq.activity.contact.connections.a> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList, i3);
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            this.f181229i0.clear();
            this.f181229i0.addAll(arrayList);
            G();
            g(this);
            if (this.f181229i0.size() <= 3) {
                setTabMode(1);
                setTabGravity(0);
            } else {
                setTabMode(0);
                setTabGravity(1);
            }
            int Y = Y(arrayList, i3);
            for (int i16 = 0; i16 < this.f181229i0.size(); i16++) {
                TabLayoutCompat.f E = E();
                if (E == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("ConnectionsTabLayout", 2, "createTab newTab: null");
                        return;
                    }
                    return;
                } else {
                    E.l(R.layout.cba);
                    V(E, new b(E.b()), this.f181229i0.get(i16));
                    if (Y == i16) {
                        j(E, true);
                    } else {
                        j(E, false);
                    }
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ConnectionsTabLayout", 2, "createTab infos: null");
        }
    }

    public int Y(ArrayList<com.tencent.mobileqq.activity.contact.connections.a> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) arrayList, i3)).intValue();
        }
        if (arrayList == null || arrayList.size() == 0) {
            return 0;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            if (arrayList.get(i17).f181253a == i3) {
                i16 = i17;
            }
        }
        return i16;
    }

    public Drawable Z(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 != 0 && i16 != 0) {
            f fVar = new f(i3, 50, 50, ViewUtils.dip2px(6.0f));
            StateListDrawable stateListDrawable = new StateListDrawable();
            f fVar2 = new f(i16, 50, 50, ViewUtils.dip2px(6.0f));
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, fVar);
            stateListDrawable.addState(new int[]{-16842913}, fVar2);
            return stateListDrawable;
        }
        return null;
    }

    public Drawable a0(String str, String str2) {
        URLDrawable uRLDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Drawable) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        URLDrawable uRLDrawable2 = null;
        if (!TextUtils.isEmpty(str)) {
            uRLDrawable = X(str);
            if (uRLDrawable != null) {
                uRLDrawable.startDownload();
            }
        } else {
            uRLDrawable = null;
        }
        if (!TextUtils.isEmpty(str2) && (uRLDrawable2 = X(str2)) != null) {
            uRLDrawable2.startDownload();
        }
        if (uRLDrawable != null) {
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, uRLDrawable);
        }
        if (uRLDrawable2 != null) {
            stateListDrawable.addState(new int[]{-16842913}, uRLDrawable2);
        }
        return stateListDrawable;
    }

    @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
    public void c(TabLayoutCompat.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar);
        } else {
            new b(fVar.b()).a();
        }
    }

    public void c0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        int y16 = y();
        if (y16 == i3) {
            if (QLog.isColorLevel()) {
                QLog.d("ConnectionsTabLayout", 2, "selectTabWithoutCallback viewPosition ->" + y16 + ",position =" + i3);
                return;
            }
            return;
        }
        TabLayoutCompat.f z16 = z(i3);
        if (z16 != null) {
            z16.k();
        }
    }

    public void d0(ArrayList<com.tencent.mobileqq.activity.contact.connections.a> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) arrayList, i3);
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            this.f181229i0.clear();
            this.f181229i0.addAll(arrayList);
            int size = arrayList.size();
            if (A() != size) {
                if (QLog.isColorLevel()) {
                    QLog.d("ConnectionsTabLayout", 2, "updateTabs getTabCount() != infoSize " + A() + ", infoSize =" + size);
                }
                W(arrayList, i3);
                return;
            }
            int Y = Y(arrayList, i3);
            for (int i16 = 0; i16 < A(); i16++) {
                TabLayoutCompat.f z16 = z(i16);
                if (z16 != null) {
                    com.tencent.mobileqq.activity.contact.connections.a aVar = this.f181229i0.get(i16);
                    b bVar = new b(z16.b());
                    V(z16, bVar, aVar);
                    if (Y == i16) {
                        c0(i16);
                        bVar.a();
                    } else {
                        bVar.b();
                    }
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConnectionsTabLayout", 2, "updateTabs infos: " + arrayList);
        }
    }

    @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
    public void l3(TabLayoutCompat.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fVar);
        } else {
            new b(fVar.b()).b();
        }
    }

    public ConnectionsTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ConnectionsTabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f181229i0 = new ArrayList<>();
            b0();
        }
    }
}
