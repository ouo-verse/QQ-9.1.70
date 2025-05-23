package com.tencent.smtt.sdk.ui.dialog;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.ui.dialog.widget.RoundImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a extends ArrayAdapter<b> implements View.OnClickListener, ListAdapter {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<b> f369517a;

    /* renamed from: b, reason: collision with root package name */
    private b f369518b;

    /* renamed from: c, reason: collision with root package name */
    private Intent f369519c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<ListView> f369520d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<d> f369521e;

    /* renamed from: f, reason: collision with root package name */
    private b f369522f;

    /* renamed from: g, reason: collision with root package name */
    private b f369523g;

    /* renamed from: h, reason: collision with root package name */
    private List<b> f369524h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f369525i;

    /* renamed from: j, reason: collision with root package name */
    private String[] f369526j;

    /* renamed from: k, reason: collision with root package name */
    private List<ResolveInfo> f369527k;

    public a(Context context, Intent intent, b bVar, List<b> list, b bVar2, d dVar, ListView listView, List<ResolveInfo> list2) {
        super(context, 0);
        this.f369518b = null;
        a(dVar);
        a(listView);
        this.f369527k = list2;
        this.f369523g = bVar;
        this.f369519c = intent;
        if (MttLoader.isBrowserInstalled(context)) {
            this.f369522f = null;
        } else {
            this.f369522f = this.f369523g;
        }
        this.f369524h = list;
        this.f369525i = new Handler() { // from class: com.tencent.smtt.sdk.ui.dialog.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    a.this.b();
                }
            }
        };
        String[] strArr = new String[2];
        this.f369526j = strArr;
        strArr[0] = e.b("x5_tbs_activity_picker_recommend_to_trim");
        this.f369526j[1] = e.b("x5_tbs_activity_picker_recommend_with_chinese_brace_to_trim");
        a(context, bVar2);
    }

    public void b() {
        View findViewWithTag;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f369525i.obtainMessage(1).sendToTarget();
            return;
        }
        ListView listView = this.f369520d.get();
        if (listView == null || (findViewWithTag = listView.findViewWithTag(this.f369522f)) == null) {
            return;
        }
        a(this.f369522f, findViewWithTag);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f369517a.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        b item = getItem(i3);
        if (item != null) {
            if (view != null) {
                view2 = view;
            } else {
                view2 = a(getContext());
            }
            a(item, view2);
        } else {
            view2 = null;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        View view2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag();
        if (tag != null && (tag instanceof b) && (bVar = (b) tag) != this.f369518b) {
            Object parent = view.getParent();
            if (parent instanceof View) {
                view2 = (View) parent;
            } else {
                view2 = null;
            }
            b bVar2 = this.f369518b;
            b(view.getContext(), bVar);
            a(bVar2, view2.findViewWithTag(bVar2));
            a(this.f369518b, view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public b a() {
        return this.f369518b;
    }

    void a(ListView listView) {
        this.f369520d = new WeakReference<>(listView);
    }

    void a(d dVar) {
        this.f369521e = new WeakReference<>(dVar);
    }

    void a(Context context, b bVar) {
        boolean z16;
        boolean z17;
        b bVar2;
        this.f369517a = new ArrayList<>();
        List<b> list = this.f369524h;
        if (list != null && list.size() != 0) {
            this.f369517a.addAll(this.f369524h);
        }
        List<ResolveInfo> list2 = this.f369527k;
        if (list2 != null) {
            z16 = false;
            z17 = false;
            for (ResolveInfo resolveInfo : list2) {
                if (b.a(context, resolveInfo.activityInfo.packageName) != null || resolveInfo.loadIcon(context.getPackageManager()) != null) {
                    b bVar3 = new b(context, resolveInfo);
                    b bVar4 = this.f369522f;
                    if (bVar4 != null && bVar4.d().equals(resolveInfo.activityInfo.packageName)) {
                        bVar3.a(this.f369522f.f());
                        bVar3.a(this.f369522f.h());
                        bVar3.a(this.f369522f.a());
                        this.f369517a.add(0, bVar3);
                        z16 = true;
                    } else if (TbsConfig.APP_QB.equals(resolveInfo.activityInfo.packageName)) {
                        b bVar5 = this.f369523g;
                        if (bVar5 != null) {
                            bVar3.a(bVar5.f());
                            bVar3.a(this.f369523g.h());
                            bVar3.a(this.f369523g.a());
                        }
                        this.f369517a.add(0, bVar3);
                    } else {
                        this.f369517a.add(bVar3);
                    }
                    if (!z17 && bVar != null && bVar3.d().equals(bVar.d())) {
                        b(context, bVar3);
                        z17 = true;
                    }
                }
            }
        } else {
            z16 = false;
            z17 = false;
        }
        if (!z16 && (bVar2 = this.f369522f) != null) {
            this.f369517a.add(0, bVar2);
        }
        if (z17 || this.f369517a.size() <= 0) {
            return;
        }
        b(context, this.f369517a.get(0));
    }

    private void b(Context context, b bVar) {
        this.f369518b = bVar;
        if (bVar == null) {
            return;
        }
        if (!bVar.e() && !this.f369518b.f()) {
            a(a(context, this.f369518b.d()));
        } else {
            a(true);
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b getItem(int i3) {
        if (i3 < 0 || i3 >= this.f369517a.size()) {
            return null;
        }
        return this.f369517a.get(i3);
    }

    private View a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(Color.argb(41, 0, 0, 0)));
        stateListDrawable.addState(new int[]{-16842919}, new ColorDrawable(0));
        linearLayout.setBackgroundDrawable(stateListDrawable);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, c.a(getContext(), 144.0f)));
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a(getContext(), 96.0f), c.a(getContext(), 96.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.setMargins(c.a(getContext(), 32.0f), c.a(getContext(), 24.0f), c.a(getContext(), 24.0f), c.a(getContext(), 24.0f));
        roundImageView.setLayoutParams(layoutParams);
        roundImageView.setId(101);
        relativeLayout.addView(roundImageView);
        LinearLayout linearLayout2 = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, 101);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setMaxLines(1);
        textView.setTextColor(Color.rgb(29, 29, 29));
        textView.setTextSize(1, 17.0f);
        textView.setId(102);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView2.setText(e.b("x5_tbs_wechat_activity_picker_label_recommend"));
        textView2.setTextColor(Color.parseColor("#00CAFC"));
        textView2.setTextSize(1, 14.0f);
        textView2.setId(103);
        linearLayout2.addView(textView2);
        relativeLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(c.a(getContext(), 48.0f), c.a(getContext(), 48.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.setMargins(0, 0, c.a(getContext(), 32.0f), 0);
        imageView.setLayoutParams(layoutParams3);
        imageView.setImageDrawable(e.a("x5_tbs_activity_picker_check"));
        imageView.setId(104);
        relativeLayout.addView(imageView);
        relativeLayout.setId(105);
        linearLayout.addView(relativeLayout);
        return linearLayout;
    }

    public ResolveInfo a(b bVar) {
        List<ResolveInfo> list;
        if (bVar != null && !TextUtils.isEmpty(bVar.d()) && (list = this.f369527k) != null) {
            for (ResolveInfo resolveInfo : list) {
                if (bVar.d().equals(resolveInfo.activityInfo.packageName)) {
                    return resolveInfo;
                }
            }
        }
        return null;
    }

    private void a(b bVar, View view) {
        if (view == null || bVar == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(101);
        TextView textView = (TextView) view.findViewById(102);
        TextView textView2 = (TextView) view.findViewById(103);
        ImageView imageView2 = (ImageView) view.findViewById(104);
        View findViewById = view.findViewById(105);
        View findViewById2 = view.findViewById(106);
        imageView.setImageDrawable(bVar.a());
        String replaceAll = bVar.b().trim().replaceAll(Typography.nbsp + "", "");
        String[] strArr = this.f369526j;
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            if (str != null && str.length() > 0) {
                replaceAll = replaceAll.replaceAll(str, "");
            }
        }
        textView.setText(replaceAll);
        if (bVar.c() == null) {
            bVar.a(a(bVar));
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                Object parent = view2.getParent();
                if (parent instanceof View) {
                    View view3 = (View) parent;
                    if (view3.getTag() == a.this.f369522f) {
                        a.this.onClick(view3);
                    }
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        if (TbsConfig.APP_QB.equals(bVar.d())) {
            textView2.setVisibility(0);
            textView2.setText(bVar.h());
        } else {
            textView2.setVisibility(8);
        }
        findViewById.setClickable(false);
        findViewById.setEnabled(false);
        if (bVar == this.f369518b) {
            imageView2.setVisibility(0);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        } else {
            imageView2.setVisibility(8);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        }
        view.setTag(bVar);
        view.setOnClickListener(this);
    }

    private void a(boolean z16) {
        d dVar;
        WeakReference<d> weakReference = this.f369521e;
        if (weakReference == null || (dVar = weakReference.get()) == null) {
            return;
        }
        dVar.a(z16);
    }

    public static boolean a(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }
}
