package com.tencent.mobileqq.teamworkforgroup;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShareUtils implements AdapterView.OnItemClickListener, com.tencent.mobileqq.teamwork.k {
    protected int C;
    private View I;
    private TextView L;

    /* renamed from: d, reason: collision with root package name */
    private ActionSheet f292498d;

    /* renamed from: e, reason: collision with root package name */
    private ElasticHorScrView f292499e;

    /* renamed from: f, reason: collision with root package name */
    private ElasticHorScrView f292500f;

    /* renamed from: h, reason: collision with root package name */
    private float f292501h;

    /* renamed from: i, reason: collision with root package name */
    private Activity f292502i;

    /* renamed from: m, reason: collision with root package name */
    private AppInterface f292503m;
    protected String D = null;
    protected String E = null;
    protected String F = null;
    protected String G = null;
    private k.a H = null;
    private int J = 0;
    private boolean K = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ShareUtils.this.f292498d.isShowing()) {
                ShareUtils.this.f292498d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (ShareUtils.this.H != null) {
                ShareUtils.this.H.onClosePanel();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements DialogInterface.OnKeyListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            if (i3 == 4 && ShareUtils.this.H != null) {
                ShareUtils.this.H.onClosePanel();
            }
            if (i3 == 4) {
                return true;
            }
            return false;
        }
    }

    public ShareUtils(Activity activity, AppInterface appInterface) {
        this.f292501h = 1.0f;
        this.f292502i = activity;
        this.f292503m = appInterface;
        this.f292501h = activity.getResources().getDisplayMetrics().density;
    }

    @Override // com.tencent.mobileqq.teamwork.k
    public void a(k.a aVar) {
        this.H = aVar;
    }

    @Override // com.tencent.mobileqq.teamwork.k
    public void b() {
        View view = this.I;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.k
    public void c(boolean z16) {
        this.K = z16;
    }

    @Override // com.tencent.mobileqq.teamwork.k
    public void d(String str, String str2, String str3, String str4, int i3) {
        this.D = str;
        this.E = str2;
        this.F = str3;
        this.C = i3;
        this.G = str4;
    }

    @Override // com.tencent.mobileqq.teamwork.k
    public void destroy() {
        ActionSheet actionSheet = this.f292498d;
        if (actionSheet != null && actionSheet.isShowing()) {
            this.H = null;
            this.f292498d.dismiss();
        }
    }

    @SuppressLint({"InflateParams"})
    @TargetApi(9)
    protected View i() {
        List<com.tencent.mobileqq.teamwork.h> arrayList;
        List<com.tencent.mobileqq.teamwork.h> arrayList2;
        View view;
        View inflate = this.f292502i.getLayoutInflater().inflate(R.layout.e7d, (ViewGroup) null);
        inflate.setBackgroundResource(R.drawable.bg_texture);
        this.f292499e = (ElasticHorScrView) inflate.findViewById(R.id.iih);
        this.f292500f = (ElasticHorScrView) inflate.findViewById(R.id.iii);
        TextView textView = (TextView) inflate.findViewById(R.id.f163940d4);
        this.L = textView;
        textView.setText(R.string.hz7);
        if (k()) {
            this.L.setVisibility(0);
        } else {
            this.L.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f163943d8);
        if (linearLayout != null && (view = this.I) != null) {
            linearLayout.addView(view, this.J);
        }
        GridView gridView = (GridView) inflate.findViewById(R.id.f165392cx3);
        GridView gridView2 = (GridView) inflate.findViewById(R.id.cx4);
        TextView textView2 = (TextView) inflate.findViewById(R.id.action_sheet_title);
        textView2.setTextColor(-16777216);
        textView2.setText(R.string.cancel);
        textView2.setOnClickListener(new a());
        this.f292499e.setOverScrollMode(2);
        this.f292500f.setOverScrollMode(2);
        gridView2.setSmoothScrollbarEnabled(false);
        List<com.tencent.mobileqq.teamwork.h>[] j3 = j();
        if (j3.length > 0) {
            arrayList = j3[0];
        } else {
            arrayList = new ArrayList<>(0);
        }
        if (j3.length > 1) {
            arrayList2 = j3[1];
        } else {
            arrayList2 = new ArrayList<>(0);
        }
        gridView.setNumColumns(arrayList.size());
        ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
        layoutParams.width = (int) (((r6 * 75) + ((r6 - 1) * 10) + 3) * this.f292501h);
        gridView.setLayoutParams(layoutParams);
        gridView.setAdapter((ListAdapter) new com.tencent.mobileqq.teamwork.i(this.f292502i, 0, arrayList));
        gridView.setSelector(new ColorDrawable(0));
        gridView.setOnItemClickListener(this);
        final int i3 = layoutParams.width;
        int size = arrayList2.size();
        ViewGroup.LayoutParams layoutParams2 = gridView2.getLayoutParams();
        layoutParams2.width = (int) (((size * 75) + ((size - 1) * 10) + 3) * this.f292501h);
        gridView2.setLayoutParams(layoutParams2);
        gridView2.setNumColumns(size);
        gridView2.setAdapter((ListAdapter) new com.tencent.mobileqq.teamwork.i(this.f292502i, 0, arrayList2));
        gridView2.setSelector(new ColorDrawable(0));
        gridView2.setOnItemClickListener(this);
        final int i16 = layoutParams2.width;
        inflate.post(new Runnable() { // from class: com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
            @Override // java.lang.Runnable
            public void run() {
                if (ShareUtils.this.f292499e.getWidth() < i3) {
                    ShareUtils.this.f292499e.setMove(true);
                } else {
                    ShareUtils.this.f292499e.setMove(false);
                }
                if (ShareUtils.this.f292500f.getWidth() < i16) {
                    ShareUtils.this.f292500f.setMove(true);
                } else {
                    ShareUtils.this.f292500f.setMove(false);
                }
            }
        });
        return inflate;
    }

    protected List<com.tencent.mobileqq.teamwork.h>[] j() {
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.teamwork.h hVar = new com.tencent.mobileqq.teamwork.h();
        hVar.f292138c = this.f292502i.getString(R.string.dxy);
        hVar.f292136a = R.drawable.cck;
        hVar.f292137b = true;
        hVar.f292139d = 2;
        hVar.f292140e = "";
        arrayList.add(hVar);
        com.tencent.mobileqq.teamwork.h hVar2 = new com.tencent.mobileqq.teamwork.h();
        hVar2.f292138c = this.f292502i.getString(R.string.dyh);
        hVar2.f292136a = R.drawable.cco;
        hVar2.f292139d = 9;
        hVar2.f292140e = "";
        arrayList.add(hVar2);
        com.tencent.mobileqq.teamwork.h hVar3 = new com.tencent.mobileqq.teamwork.h();
        hVar3.f292138c = this.f292502i.getString(R.string.f171309dy1);
        hVar3.f292136a = R.drawable.cci;
        hVar3.f292139d = 10;
        hVar3.f292140e = "";
        arrayList.add(hVar3);
        com.tencent.mobileqq.teamwork.h hVar4 = new com.tencent.mobileqq.teamwork.h();
        hVar4.f292138c = this.f292502i.getString(R.string.dye);
        hVar4.f292136a = R.drawable.ccn;
        hVar4.f292137b = true;
        hVar4.f292139d = 12;
        hVar4.f292140e = "";
        arrayList.add(hVar4);
        ArrayList arrayList2 = new ArrayList();
        com.tencent.mobileqq.teamwork.h hVar5 = new com.tencent.mobileqq.teamwork.h();
        hVar5.f292138c = this.f292502i.getString(R.string.dy6);
        hVar5.f292136a = R.drawable.bzn;
        hVar5.f292137b = true;
        hVar5.f292139d = 26;
        hVar5.f292140e = "";
        arrayList2.add(hVar5);
        com.tencent.mobileqq.teamwork.h hVar6 = new com.tencent.mobileqq.teamwork.h();
        hVar6.f292138c = this.f292502i.getString(R.string.dxr);
        hVar6.f292136a = R.drawable.ccg;
        hVar6.f292137b = true;
        hVar6.f292139d = 1;
        hVar6.f292140e = "";
        arrayList2.add(hVar6);
        com.tencent.mobileqq.teamwork.h hVar7 = new com.tencent.mobileqq.teamwork.h();
        hVar7.f292138c = this.f292502i.getString(R.string.dxw);
        hVar7.f292136a = R.drawable.dln;
        hVar7.f292137b = true;
        hVar7.f292139d = 11;
        hVar7.f292140e = "";
        arrayList2.add(hVar7);
        return new ArrayList[]{arrayList, arrayList2};
    }

    public boolean k() {
        return this.K;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        Object tag = view.getTag();
        if (tag == null) {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, 2, "onItemClick, tag is null");
            }
        } else {
            com.tencent.mobileqq.teamwork.h hVar = ((com.tencent.mobileqq.teamwork.j) tag).f292145c;
            k.a aVar = this.H;
            if (aVar != null) {
                aVar.onItemClick(hVar.f292139d);
            }
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    @Override // com.tencent.mobileqq.teamwork.k
    public void showActionSheet() {
        if (this.f292502i.isFinishing()) {
            return;
        }
        if (this.f292498d == null) {
            this.f292498d = (ActionSheet) ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).actionSheetHelperCreateDialog(this.f292502i, null);
            View i3 = i();
            this.f292498d.setOnDismissListener(new b());
            this.f292498d.setOnKeyListener(new c());
            this.f292498d.setActionContentView(i3, null);
        }
        if (!this.f292498d.isShowing()) {
            this.f292498d.show();
        }
    }
}
