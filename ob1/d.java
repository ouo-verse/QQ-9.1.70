package ob1;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.util.bq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.SingleLineTextView;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class d extends PinnedHeaderExpandableListView.ExpandableListAdapter {

    /* renamed from: d, reason: collision with root package name */
    protected Context f422337d;

    /* renamed from: e, reason: collision with root package name */
    private ExpandableListView f422338e;

    /* renamed from: f, reason: collision with root package name */
    protected InterfaceC10897d f422339f;

    /* renamed from: h, reason: collision with root package name */
    Object f422340h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f422341i = false;

    /* renamed from: m, reason: collision with root package name */
    LinkedHashMap<String, List<Object>> f422342m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f422343d;

        a(int i3) {
            this.f422343d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (d.this.f422338e.isGroupExpanded(this.f422343d)) {
                d.this.f422338e.collapseGroup(this.f422343d);
            } else {
                d.this.f422338e.expandGroup(this.f422343d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements CustomAccessibilityDelegate.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f422345d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f422346e;

        b(int i3, View view) {
            this.f422345d = i3;
            this.f422346e = view;
        }

        @Override // com.tencent.biz.qrcode.CustomAccessibilityDelegate.a
        public void e2() {
            QLog.e("ACCESS_SILAS", 1, "onViewFocusClear");
        }

        @Override // com.tencent.biz.qrcode.CustomAccessibilityDelegate.a
        public void z1() {
            String str = (String) d.this.getGroup(this.f422345d);
            if (d.this.f422338e.isGroupExpanded(this.f422345d)) {
                this.f422346e.setContentDescription(str + "," + HardCodeUtil.qqStr(R.string.f187073t0));
                return;
            }
            this.f422346e.setContentDescription(str + "," + HardCodeUtil.qqStr(R.string.f187063sz));
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f422348d;

        c(int i3) {
            this.f422348d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (d.this.f422338e.isGroupExpanded(this.f422348d)) {
                d.this.f422338e.collapseGroup(this.f422348d);
            } else {
                d.this.f422338e.expandGroup(this.f422348d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: ob1.d$d, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC10897d {
        void a(FileInfo fileInfo, boolean z16);

        String g(FileInfo fileInfo);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f422350a;

        /* renamed from: b, reason: collision with root package name */
        public SingleLineTextView f422351b;

        /* renamed from: c, reason: collision with root package name */
        public CheckBox f422352c;
    }

    public d(Context context, Object obj) {
        this.f422342m = new LinkedHashMap<>();
        if (obj != null) {
            this.f422342m = (LinkedHashMap) obj;
        }
        this.f422337d = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Object> c(int i3) {
        int i16 = 0;
        for (String str : this.f422342m.keySet()) {
            if (i16 != i3) {
                i16++;
            } else {
                return this.f422342m.get(str);
            }
        }
        return null;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        e eVar = (e) view.getTag();
        if (eVar == null) {
            eVar = new e();
            eVar.f422351b = (SingleLineTextView) view.findViewById(R.id.group_name);
            view.findViewById(R.id.contact_count).setVisibility(8);
            view.findViewById(R.id.f165958dx0).setVisibility(8);
            eVar.f422352c = (CheckBox) view.findViewById(R.id.dv_);
            view.setTag(eVar);
        }
        view.setOnClickListener(new c(i3));
        eVar.f422352c.setChecked(this.f422338e.isGroupExpanded(i3));
        CharSequence charSequence = (String) getGroup(i3);
        eVar.f422351b.setText(charSequence);
        view.setContentDescription(charSequence);
        eVar.f422352c.setVisibility(0);
    }

    String d(int i3) {
        int i16 = 0;
        for (String str : this.f422342m.keySet()) {
            if (i16 != i3) {
                i16++;
            } else {
                return str;
            }
        }
        return null;
    }

    public void e(Object obj) {
        this.f422340h = obj;
    }

    public void f(ExpandableListView expandableListView) {
        this.f422338e = expandableListView;
    }

    public void g(boolean z16) {
        this.f422341i = z16;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        List<Object> c16 = c(i3);
        if (c16 != null && c16.size() > 0 && i16 < c16.size()) {
            return c16.get(i16);
        }
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        return i16;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        List<Object> c16 = c(i3);
        if (c16 != null) {
            return c16.size();
        }
        return 0;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        return d(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f422342m.keySet().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return i3;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        e eVar;
        if (view != null) {
            eVar = (e) view.getTag();
        } else {
            view = LayoutInflater.from(this.f422337d).inflate(R.layout.amb, viewGroup, false);
            eVar = new e();
            eVar.f422351b = (SingleLineTextView) view.findViewById(R.id.group_name);
            eVar.f422352c = (CheckBox) view.findViewById(R.id.dv_);
            view.findViewById(R.id.contact_count).setVisibility(8);
            view.findViewById(R.id.f165958dx0).setVisibility(8);
            view.setTag(eVar);
        }
        view.setOnClickListener(new a(i3));
        if (AppSetting.f99565y) {
            view.setAccessibilityDelegate(new CustomAccessibilityDelegate(view, new b(i3, view)));
        }
        eVar.f422352c.setVisibility(0);
        eVar.f422352c.setChecked(z16);
        eVar.f422352c.setClickable(false);
        String str = (String) getGroup(i3);
        eVar.f422350a = i3;
        eVar.f422351b.setText(str);
        return view;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        return R.layout.amb;
    }

    public void h(InterfaceC10897d interfaceC10897d) {
        this.f422339f = interfaceC10897d;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(e eVar, boolean z16) {
        int i3;
        int i16;
        CheckBox checkBox = eVar.f422352c;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        checkBox.setVisibility(i3);
        eVar.f422352c.setImportantForAccessibility(2);
        ViewGroup.LayoutParams layoutParams = eVar.f422351b.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            Resources resources = this.f422337d.getResources();
            if (z16) {
                i16 = R.dimen.czq;
            } else {
                i16 = R.dimen.czp;
            }
            marginLayoutParams.leftMargin = resources.getDimensionPixelSize(i16);
            eVar.f422351b.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        return true;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i3) {
        super.onGroupCollapsed(i3);
        if (AppSetting.f99565y) {
            bq.c(((String) getGroup(i3)) + HardCodeUtil.qqStr(R.string.f187063sz));
        }
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupExpanded(int i3) {
        super.onGroupExpanded(i3);
        if (AppSetting.f99565y) {
            bq.c(((String) getGroup(i3)) + HardCodeUtil.qqStr(R.string.f187073t0));
        }
    }
}
