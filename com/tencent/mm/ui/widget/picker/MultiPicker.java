package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.luggage.wxa.mo.h;
import com.tencent.luggage.wxa.mo.i;
import com.tencent.luggage.wxa.mo.p;
import com.tencent.luggage.wxa.mo.u;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class MultiPicker {

    /* renamed from: a, reason: collision with root package name */
    public a f153592a;

    /* renamed from: b, reason: collision with root package name */
    public View f153593b;

    /* renamed from: c, reason: collision with root package name */
    public Context f153594c;

    /* renamed from: d, reason: collision with root package name */
    public ListView f153595d;

    /* renamed from: e, reason: collision with root package name */
    public View f153596e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f153597f;

    /* renamed from: g, reason: collision with root package name */
    public Button f153598g;

    /* renamed from: h, reason: collision with root package name */
    public Button f153599h;

    /* renamed from: i, reason: collision with root package name */
    public int f153600i;

    /* renamed from: j, reason: collision with root package name */
    public BottomSheetBehavior f153601j;

    /* renamed from: k, reason: collision with root package name */
    public p f153602k;

    /* renamed from: l, reason: collision with root package name */
    public u f153603l;

    /* renamed from: m, reason: collision with root package name */
    public h f153604m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f153605n;

    /* renamed from: o, reason: collision with root package name */
    public ListViewAdapter f153606o;

    /* renamed from: p, reason: collision with root package name */
    public OnResultListener f153607p;

    /* loaded from: classes9.dex */
    public class ListViewAdapter extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public Context f153611a;

        /* renamed from: b, reason: collision with root package name */
        public HashMap f153612b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f153613c;

        /* loaded from: classes9.dex */
        public class ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public TextView f153618a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f153619b;

            /* renamed from: c, reason: collision with root package name */
            public CheckBox f153620c;

            /* renamed from: d, reason: collision with root package name */
            public LinearLayout f153621d;

            public ViewHolder() {
            }
        }

        public ListViewAdapter(Context context) {
            this.f153611a = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return MultiPicker.this.f153604m.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return MultiPicker.this.f153604m.getItemList().get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        public ArrayList<Integer> getSelectedItem() {
            if (this.f153612b == null) {
                return null;
            }
            this.f153613c = new ArrayList();
            for (int i3 = 0; i3 < getCount(); i3++) {
                if (((Boolean) this.f153612b.get(Integer.valueOf(i3))).booleanValue()) {
                    this.f153613c.add(Integer.valueOf(i3));
                }
            }
            return this.f153613c;
        }

        @Override // android.widget.Adapter
        public View getView(final int i3, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            final i iVar = (i) MultiPicker.this.f153604m.getItemList().get(i3);
            LayoutInflater from = LayoutInflater.from(this.f153611a);
            if (view == null) {
                view = from.inflate(R.layout.fk7, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.f153621d = (LinearLayout) view.findViewById(R.id.xvy);
                viewHolder.f153620c = (CheckBox) view.findViewById(R.id.xsu);
                viewHolder.f153618a = (TextView) view.findViewById(R.id.dr7);
                viewHolder.f153619b = (TextView) view.findViewById(R.id.dpt);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.f153618a.setText(iVar.getTitle());
            viewHolder.f153621d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.picker.MultiPicker.ListViewAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (MultiPicker.this.f153603l != null) {
                        MultiPicker.this.f153603l.a(MultiPicker.this.f153604m.getItem(i3), i3);
                    }
                    if (iVar.c()) {
                        return;
                    }
                    if (((Boolean) ListViewAdapter.this.f153612b.get(Integer.valueOf(i3))).booleanValue()) {
                        ListViewAdapter.this.f153612b.put(Integer.valueOf(i3), Boolean.FALSE);
                    } else {
                        ListViewAdapter.this.f153612b.put(Integer.valueOf(i3), Boolean.TRUE);
                    }
                    ListViewAdapter listViewAdapter = ListViewAdapter.this;
                    listViewAdapter.setIsSelected(listViewAdapter.f153612b);
                    ListViewAdapter.this.notifyDataSetChanged();
                }
            });
            if (viewHolder.f153619b != null) {
                if (iVar.a() != null && iVar.a().length() > 0) {
                    viewHolder.f153619b.setVisibility(0);
                    viewHolder.f153619b.setText(iVar.a());
                } else {
                    viewHolder.f153619b.setVisibility(8);
                }
            }
            if (iVar.c()) {
                viewHolder.f153618a.setTextColor(MultiPicker.this.f153594c.getResources().getColor(R.color.b9w));
                viewHolder.f153619b.setTextColor(MultiPicker.this.f153594c.getResources().getColor(R.color.b9w));
                viewHolder.f153620c.setChecked(((Boolean) this.f153612b.get(Integer.valueOf(i3))).booleanValue());
                viewHolder.f153620c.setEnabled(false);
            } else {
                viewHolder.f153618a.setTextColor(MultiPicker.this.f153594c.getResources().getColor(R.color.b9v));
                viewHolder.f153619b.setTextColor(MultiPicker.this.f153594c.getResources().getColor(R.color.b9x));
                viewHolder.f153620c.setChecked(((Boolean) this.f153612b.get(Integer.valueOf(i3))).booleanValue());
                viewHolder.f153620c.setEnabled(true);
            }
            return view;
        }

        public void setIsSelected(HashMap<Integer, Boolean> hashMap) {
            this.f153612b = hashMap;
        }

        public void setSelectedItem(ArrayList<Integer> arrayList) {
            if (MultiPicker.this.f153605n == null) {
                return;
            }
            for (int i3 = 0; i3 < getCount(); i3++) {
                if (MultiPicker.this.f153605n.contains(Integer.valueOf(i3))) {
                    this.f153612b.put(Integer.valueOf(i3), Boolean.TRUE);
                } else {
                    this.f153612b.put(Integer.valueOf(i3), Boolean.FALSE);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface OnResultListener {
        void onResult(boolean z16, ArrayList<Integer> arrayList);
    }

    public MultiPicker(Context context) {
        this.f153594c = context;
        a();
    }

    public ArrayList<Integer> getSelected() {
        ListViewAdapter listViewAdapter = this.f153606o;
        if (listViewAdapter != null) {
            return listViewAdapter.getSelectedItem();
        }
        return new ArrayList<>();
    }

    public void hide() {
        a aVar = this.f153592a;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void initSelectedItem(ArrayList<Integer> arrayList) {
        this.f153605n = arrayList;
    }

    public void setIsSelected(HashMap<Integer, Boolean> hashMap) {
        ListViewAdapter listViewAdapter = this.f153606o;
        if (listViewAdapter != null) {
            listViewAdapter.setIsSelected(hashMap);
            this.f153606o.notifyDataSetChanged();
        }
    }

    public void setOnCreateMenuListener(p pVar) {
        this.f153602k = pVar;
    }

    public void setOnMenuSelectedListener(u uVar) {
        this.f153603l = uVar;
    }

    public void setOnResultListener(OnResultListener onResultListener) {
        this.f153607p = onResultListener;
    }

    public void setTextTitle(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            this.f153596e.setVisibility(0);
            this.f153597f.setText(charSequence);
        }
    }

    public void show() {
        p pVar = this.f153602k;
        if (pVar != null) {
            pVar.a(this.f153604m);
        }
        ListViewAdapter listViewAdapter = new ListViewAdapter(this.f153594c);
        this.f153606o = listViewAdapter;
        listViewAdapter.setSelectedItem(this.f153605n);
        this.f153595d.setAdapter((ListAdapter) this.f153606o);
        this.f153598g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.picker.MultiPicker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MultiPicker multiPicker = MultiPicker.this;
                multiPicker.a(true, (ArrayList) multiPicker.f153606o.getSelectedItem());
                MultiPicker.this.hide();
            }
        });
        this.f153599h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.picker.MultiPicker.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MultiPicker.this.a(false, (ArrayList) null);
                MultiPicker.this.hide();
            }
        });
        if (this.f153592a != null) {
            b();
            this.f153592a.show();
        }
    }

    public final void b() {
        h hVar = this.f153604m;
        if (hVar == null || hVar.size() <= 3) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f153593b.getLayoutParams();
        layoutParams.height = this.f153600i;
        this.f153593b.setLayoutParams(layoutParams);
    }

    public final void a(boolean z16, ArrayList arrayList) {
        OnResultListener onResultListener = this.f153607p;
        if (onResultListener != null) {
            onResultListener.onResult(z16, arrayList);
        }
    }

    public final void a() {
        this.f153604m = new h(this.f153594c);
        this.f153592a = new a(this.f153594c);
        View inflate = View.inflate(this.f153594c, R.layout.fk8, null);
        this.f153593b = inflate;
        this.f153595d = (ListView) inflate.findViewById(R.id.zii);
        this.f153598g = (Button) this.f153593b.findViewById(R.id.fcw);
        this.f153599h = (Button) this.f153593b.findViewById(R.id.aou);
        this.f153596e = this.f153593b.findViewById(R.id.x8n);
        this.f153597f = (TextView) this.f153593b.findViewById(R.id.d4r);
        this.f153592a.setContentView(this.f153593b);
        this.f153600i = o.c(this.f153594c, R.dimen.bds) + o.c(this.f153594c, R.dimen.bdt);
        BottomSheetBehavior from = BottomSheetBehavior.from((View) this.f153593b.getParent());
        this.f153601j = from;
        if (from != null) {
            from.setPeekHeight(this.f153600i);
            this.f153601j.setHideable(false);
        }
        this.f153592a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mm.ui.widget.picker.MultiPicker.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MultiPicker.this.f153592a = null;
            }
        });
    }
}
