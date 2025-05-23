package com.qzone.detail.ui.component;

import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.qzone.util.ar;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ShareActionSheetBuilder f47047a;

    /* renamed from: b, reason: collision with root package name */
    private Context f47048b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f47049c;

    /* renamed from: d, reason: collision with root package name */
    private int f47050d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> f47051e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> f47052f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> f47053g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> f47054h;

    /* renamed from: i, reason: collision with root package name */
    private List<ShareActionSheetBuilder.ActionSheetItem>[] f47055i;

    /* renamed from: j, reason: collision with root package name */
    private Map<s6.a, ShareActionSheetBuilder.ActionSheetItem> f47056j;

    /* compiled from: P */
    /* renamed from: com.qzone.detail.ui.component.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0383a implements AdapterView.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f47057d;

        C0383a(View.OnClickListener onClickListener) {
            this.f47057d = onClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            View.OnClickListener onClickListener = this.f47057d;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    public a(Context context, boolean z16) {
        this(context, z16, true);
    }

    private int e() {
        return f() + g();
    }

    private int f() {
        Iterator<ShareActionSheetBuilder.ActionSheetItem> it = this.f47051e.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().visibility == 0) {
                i3++;
            }
        }
        return i3;
    }

    private int g() {
        Iterator<ShareActionSheetBuilder.ActionSheetItem> it = this.f47052f.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().visibility == 0) {
                i3++;
            }
        }
        return i3;
    }

    private boolean h(Context context) {
        Display defaultDisplay = ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics.heightPixels <= displayMetrics.widthPixels;
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.util.j.d("EightGridView", "Error occurd while display.getMetrics()", e16);
            return false;
        }
    }

    private void j(s6.a aVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        actionSheetItem.f307296id = aVar.d();
        actionSheetItem.label = String.valueOf(aVar.c());
        actionSheetItem.iconNeedBg = true;
        actionSheetItem.action = aVar.a();
        actionSheetItem.argus = "";
        actionSheetItem.enable = aVar.f();
        actionSheetItem.visibility = aVar.e();
        if (com.qzone.adapter.feedcomponent.j.Q(aVar.b())) {
            actionSheetItem.iconDrawable = com.qzone.adapter.feedcomponent.j.k(aVar.b());
        } else {
            actionSheetItem.icon = aVar.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0048, code lost:
    
        if (g() <= 4) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        if (r0 <= 4) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l() {
        ViewGroup.LayoutParams layoutParams;
        int i3;
        if (!this.f47049c) {
            this.f47053g.clear();
            this.f47054h.clear();
            int e16 = e();
            int i16 = this.f47048b.getResources().getDisplayMetrics().widthPixels;
            float f16 = 4.0f;
            float f17 = 4.5f;
            if (!h(this.f47048b) && e16 >= this.f47050d) {
                this.f47053g.addAll(this.f47051e);
                this.f47054h.addAll(this.f47052f);
                if (f() <= 4) {
                }
                f16 = 4.5f;
            } else {
                this.f47053g.addAll(this.f47051e);
                this.f47053g.addAll(this.f47052f);
                if (h(this.f47048b)) {
                    f16 = 8.0f;
                }
            }
            int iconWidth = (int) (this.f47047a.getIconWidth() * f16);
            if (iconWidth > i16) {
                iconWidth = (int) (this.f47047a.getIconWidth() * 4.5f);
            } else {
                f17 = f16;
            }
            int i17 = (i16 - iconWidth) / ((((int) f17) + 1) * 2);
            this.f47047a.setIconMarginLeftRight(i17);
            this.f47047a.setRowMarginLeftRight(i17);
            return;
        }
        int e17 = ar.e(15.0f);
        int o16 = pl.a.f426446a.o(this.f47048b);
        ShareActionSheetBuilder shareActionSheetBuilder = this.f47047a;
        if (shareActionSheetBuilder != null && shareActionSheetBuilder.getActionSheet() != null && this.f47047a.getActionSheet().getActionContentView() != null && (layoutParams = this.f47047a.getActionSheet().getActionContentView().getLayoutParams()) != null && (i3 = layoutParams.width) > 0) {
            o16 = i3;
        }
        ShareActionSheetBuilder shareActionSheetBuilder2 = this.f47047a;
        if (shareActionSheetBuilder2 != null) {
            int iconWidth2 = (o16 - (4 * (shareActionSheetBuilder2.getIconWidth() + (e17 * 2)))) / 2;
            this.f47047a.setIconMarginLeftRight(e17);
            this.f47047a.setRowMarginLeftRight(iconWidth2);
        }
    }

    public void a(s6.a aVar, int i3) {
        ShareActionSheetBuilder.ActionSheetItem c16 = c(aVar);
        if (1 == i3) {
            this.f47053g.add(c16);
            this.f47051e.add(c16);
        } else {
            this.f47054h.add(c16);
            this.f47052f.add(c16);
        }
        this.f47047a.setActionSheetItems(this.f47055i);
        q();
    }

    public void b(View view) {
        m(view, new RelativeLayout.LayoutParams(-1, -2));
    }

    public void d() {
        this.f47047a.dismiss();
    }

    public boolean i() {
        return this.f47047a.isShowing();
    }

    public void k(s6.a aVar) {
        ShareActionSheetBuilder.ActionSheetItem actionSheetItem = this.f47056j.get(aVar);
        if (actionSheetItem != null) {
            j(aVar, actionSheetItem);
            q();
        }
    }

    public void m(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f47047a.setAdvView(view, layoutParams);
    }

    public void n(DialogInterface.OnDismissListener onDismissListener) {
        this.f47047a.setOnDismissListener(onDismissListener);
    }

    public void o(View.OnClickListener onClickListener) {
        this.f47047a.setItemClickListener(new C0383a(onClickListener));
    }

    public void p() {
        this.f47047a.show();
    }

    public void q() {
        l();
        try {
            if (i()) {
                this.f47047a.updateUI();
            }
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.util.j.d(QZLog.TO_DEVICE_TAG, "EightGridView update error", e16);
        }
    }

    public a(Context context, boolean z16, boolean z17) {
        this.f47049c = false;
        this.f47050d = 7;
        this.f47051e = new ArrayList<>();
        this.f47052f = new ArrayList<>();
        this.f47053g = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        this.f47054h = arrayList;
        this.f47055i = new ArrayList[]{this.f47053g, arrayList};
        this.f47056j = new HashMap();
        if (z16) {
            this.f47049c = true;
            this.f47047a = new StyleChooserShareActionSheetBuilder(context);
        } else {
            this.f47047a = new h(context);
        }
        this.f47048b = context;
        this.f47047a.hideTitle();
    }

    private ShareActionSheetBuilder.ActionSheetItem c(s6.a aVar) {
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(0);
        j(aVar, build);
        this.f47056j.put(aVar, build);
        return build;
    }
}
