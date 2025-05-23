package com.tencent.mobileqq.poke;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f259049d;

    /* renamed from: e, reason: collision with root package name */
    View.OnClickListener f259050e;

    /* renamed from: f, reason: collision with root package name */
    private NTPokePanel f259051f;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<i> f259052h;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        ImageView f259053a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f259054b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f259055c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f259056d;

        /* renamed from: e, reason: collision with root package name */
        ProgressBar f259057e;

        /* renamed from: f, reason: collision with root package name */
        TextView f259058f;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }
    }

    public g(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.f259051f = null;
        this.f259052h = new ArrayList<>();
        this.f259049d = context;
    }

    private int b() {
        ArrayList<i> arrayList = this.f259052h;
        if (arrayList == null || arrayList.size() == 0 || this.f259052h.size() <= 3) {
            return 3;
        }
        if ((this.f259052h.size() > 3 && this.f259052h.size() <= 6) || this.f259052h.size() <= 6) {
            return 3;
        }
        return 4;
    }

    public void a(ArrayList<i> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        } else {
            this.f259052h.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public ArrayList<i> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f259052h;
    }

    public void d(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        Iterator<i> it = this.f259052h.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (str.equals(VasUpdateConstants.SCID_POKE_PANEL_PREFIX)) {
                if (next.f259068c == i3) {
                    next.f259074i = z16;
                    return;
                }
                notifyDataSetChanged();
            } else if (!str.equals(VasUpdateConstants.SCID_POKE_EFFECT_PREFIX)) {
                continue;
            } else {
                if (next.f259068c == i3) {
                    next.f259073h = z17;
                    next.f259074i = z16;
                    return;
                }
                notifyDataSetChanged();
            }
        }
    }

    public void e(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) onClickListener);
        } else {
            this.f259050e = onClickListener;
        }
    }

    public void f(NTPokePanel nTPokePanel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) nTPokePanel);
        } else {
            this.f259051f = nTPokePanel;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (this.f259052h != null) {
            return ((this.f259052h.size() + r0) - 1) / b();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        ArrayList<i> arrayList = this.f259052h;
        if (arrayList != null && arrayList.size() > i3) {
            return this.f259052h.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.widget.LinearLayout, android.view.ViewGroup] */
    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        View view2;
        boolean z16;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            view2 = view;
            view3 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            int b16 = b();
            int i17 = b16 * i3;
            View.OnLongClickListener onLongClickListener = null;
            if (view == null) {
                viewGroup2 = new LinearLayout(this.f259049d, null);
                viewGroup2.setOrientation(0);
                LayoutInflater from = LayoutInflater.from(this.f259049d);
                for (int i18 = 0; i18 < b16; i18++) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.weight = 1.0f;
                    if (from == null) {
                        from = LayoutInflater.from(this.f259049d);
                    }
                    View inflate = LayoutInflater.from(this.f259049d).inflate(R.layout.f167754g6, (ViewGroup) null);
                    viewGroup2.addView(inflate, layoutParams);
                    a aVar = new a();
                    aVar.f259053a = (ImageView) inflate.findViewById(R.id.dcf);
                    aVar.f259054b = (ImageView) inflate.findViewById(R.id.flag_new);
                    aVar.f259058f = (TextView) inflate.findViewById(R.id.textView1);
                    aVar.f259055c = (ImageView) inflate.findViewById(R.id.c3w);
                    aVar.f259057e = (ProgressBar) inflate.findViewById(R.id.eff);
                    aVar.f259056d = (ImageView) inflate.findViewById(R.id.bpb);
                    inflate.setTag(aVar);
                }
            } else {
                viewGroup2 = view;
            }
            ViewGroup viewGroup3 = viewGroup2;
            if (i3 == 0) {
                viewGroup3.setPadding(x.c(MobileQQ.sMobileQQ, 15.0f), x.c(MobileQQ.sMobileQQ, 14.0f), x.c(MobileQQ.sMobileQQ, 15.0f), x.c(MobileQQ.sMobileQQ, 8.0f));
            } else {
                viewGroup3.setPadding(x.c(MobileQQ.sMobileQQ, 15.0f), x.c(MobileQQ.sMobileQQ, 7.0f), x.c(MobileQQ.sMobileQQ, 15.0f), x.c(MobileQQ.sMobileQQ, 8.0f));
            }
            int i19 = 0;
            while (i19 < b16) {
                int i26 = i17 + i19;
                View childAt = viewGroup3.getChildAt(i19);
                a aVar2 = (a) childAt.getTag();
                if (i26 < this.f259052h.size()) {
                    i iVar = this.f259052h.get(i26);
                    aVar2.f259053a.setVisibility(0);
                    aVar2.f259053a.setImageDrawable(iVar.f259067b);
                    ((ClickedWaveView) aVar2.f259053a).setCustomDrawable(iVar.f259067b);
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", iVar.f259066a);
                    bundle.putInt("id", iVar.f259068c);
                    bundle.putString("name", iVar.f259069d);
                    bundle.putInt(VipFunCallConstants.KEY_FEET_TYPE, iVar.f259072g);
                    bundle.putBoolean("isShowDownload", iVar.f259073h);
                    bundle.putBoolean("isShowLoading", iVar.f259074i);
                    bundle.putString("minVersion", iVar.f259075j);
                    ((ClickedWaveView) aVar2.f259053a).setExtraInfo(bundle);
                    ((ClickedWaveView) aVar2.f259053a).setOnTouchReceive(this.f259051f);
                    Drawable drawable = iVar.f259067b;
                    if (drawable instanceof URLDrawable) {
                        URLDrawable uRLDrawable = (URLDrawable) drawable;
                        if (uRLDrawable.getStatus() == i16) {
                            uRLDrawable.restartDownload();
                        }
                    } else if (drawable instanceof CustomFrameAnimationDrawable) {
                        aVar2.f259057e.setVisibility(8);
                        ((CustomFrameAnimationDrawable) iVar.f259067b).o();
                    }
                    aVar2.f259058f.setText(iVar.f259069d);
                    if (iVar.f259071f) {
                        aVar2.f259054b.setVisibility(0);
                    } else {
                        aVar2.f259054b.setVisibility(8);
                    }
                    String str = iVar.f259069d;
                    int i27 = iVar.f259072g;
                    if (i27 == 4) {
                        aVar2.f259055c.setVisibility(0);
                        aVar2.f259055c.setImageDrawable(this.f259049d.getResources().getDrawable(R.drawable.fsq));
                        str = str + ",\u4f1a\u5458\u4e13\u5c5e";
                    } else if (i27 == 5) {
                        aVar2.f259055c.setVisibility(0);
                        aVar2.f259055c.setImageDrawable(this.f259049d.getResources().getDrawable(R.drawable.fsp));
                        str = str + ",\u8d85\u7ea7\u4f1a\u5458\u4e13\u5c5e";
                    } else {
                        aVar2.f259055c.setVisibility(8);
                    }
                    if (iVar.f259073h) {
                        aVar2.f259056d.setVisibility(0);
                        aVar2.f259056d.setTag(Integer.valueOf(iVar.f259068c));
                    } else {
                        aVar2.f259056d.setVisibility(8);
                    }
                    if (iVar.f259074i) {
                        aVar2.f259057e.setVisibility(0);
                    } else {
                        aVar2.f259057e.setVisibility(8);
                    }
                    childAt.setContentDescription(str);
                    z16 = true;
                    childAt.setEnabled(true);
                    AccessibilityUtil.n(childAt, true);
                    onLongClickListener = null;
                } else {
                    z16 = z17;
                    aVar2.f259053a.setVisibility(4);
                    onLongClickListener = null;
                    aVar2.f259053a.setBackgroundDrawable(null);
                    aVar2.f259058f.setText((CharSequence) null);
                    aVar2.f259054b.setVisibility(8);
                    aVar2.f259055c.setVisibility(8);
                    aVar2.f259057e.setVisibility(8);
                    aVar2.f259056d.setVisibility(8);
                    aVar2.f259056d.setTag(null);
                    childAt.setEnabled(false);
                    AccessibilityUtil.n(childAt, false);
                }
                AccessibilityUtil.n(aVar2.f259058f, false);
                i19++;
                z17 = z16;
                i16 = 2;
            }
            viewGroup2.setOnLongClickListener(onLongClickListener);
            AccessibilityUtil.n(viewGroup2, false);
            view2 = viewGroup2;
            view3 = viewGroup2;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view3;
    }
}
