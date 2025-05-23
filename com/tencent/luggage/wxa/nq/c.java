package com.tencent.luggage.wxa.nq;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mobileqq.R;
import com.tencent.weui.base.preference.CheckBoxPreference;
import com.tencent.weui.base.preference.IPreferenceScreen;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends BaseAdapter implements IPreferenceScreen {

    /* renamed from: a, reason: collision with root package name */
    public final d f135918a;

    /* renamed from: h, reason: collision with root package name */
    public final SharedPreferences f135925h;

    /* renamed from: i, reason: collision with root package name */
    public final Context f135926i;

    /* renamed from: m, reason: collision with root package name */
    public Preference.OnPreferenceChangeListener f135930m;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList f135919b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f135920c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f135921d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public final LinkedList f135922e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f135923f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f135924g = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public int[] f135927j = new int[0];

    /* renamed from: k, reason: collision with root package name */
    public boolean f135928k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f135929l = false;

    public c(Context context, SharedPreferences sharedPreferences) {
        this.f135918a = new d(context);
        this.f135926i = context;
        this.f135925h = sharedPreferences;
    }

    public static boolean a(int i3) {
        return i3 == R.layout.fkb || i3 == R.layout.fkp || i3 == R.layout.fkq;
    }

    public static String b(Preference preference) {
        return preference.getClass().getName() + "L" + preference.getLayoutResource() + "W" + preference.getWidgetLayoutResource();
    }

    @Override // com.tencent.weui.base.preference.IPreferenceScreen
    public void addPreference(Preference preference) {
        addPreference(preference, -1);
    }

    @Override // com.tencent.weui.base.preference.IPreferenceScreen
    public void addPreferencesFromResource(int i3) {
        this.f135928k = true;
        this.f135918a.a(i3, this);
        this.f135928k = false;
        notifyDataSetChanged();
    }

    @Override // com.tencent.weui.base.preference.IPreferenceScreen
    public Preference findPreference(String str) {
        return (Preference) this.f135920c.get(str);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f135922e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f135920c.get(this.f135922e.get(i3));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (i3 > this.f135922e.size()) {
            return -1;
        }
        Integer num = (Integer) this.f135923f.get(b((Preference) this.f135920c.get(this.f135922e.get(i3))));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        int i16;
        if (i3 > this.f135922e.size()) {
            return view;
        }
        Preference preference = (Preference) this.f135920c.get(this.f135922e.get(i3));
        if (preference instanceof CheckBoxPreference) {
            preference.setOnPreferenceChangeListener(this.f135930m);
        }
        if (!this.f135923f.containsKey(b(preference))) {
            view2 = null;
        } else {
            view2 = view;
        }
        View view3 = preference.getView(view2, viewGroup);
        int i17 = this.f135927j[i3];
        View findViewById = view3.findViewById(R.id.content);
        int i18 = 0;
        if (findViewById == null) {
            n.a("MicroMsg.WeUIPreferenceAdapter", "find content view error", new Object[0]);
            return view3;
        }
        View findViewById2 = view3.findViewById(android.R.id.widget_frame);
        if ((i17 & 4) == 0) {
            int paddingLeft = findViewById.getPaddingLeft();
            int paddingRight = findViewById.getPaddingRight();
            int paddingTop = findViewById.getPaddingTop();
            int paddingBottom = findViewById.getPaddingBottom();
            int paddingLeft2 = view3.getPaddingLeft();
            int paddingRight2 = view3.getPaddingRight();
            int paddingTop2 = view3.getPaddingTop();
            int paddingBottom2 = view3.getPaddingBottom();
            if ((i17 & 8) != 0) {
                if (i3 != this.f135922e.size() - 1 && ((i3 != this.f135922e.size() - 2 || !(getItem(this.f135922e.size() - 1) instanceof a)) && (i17 & 2) == 0)) {
                    i18 = R.drawable.ojg;
                } else {
                    i18 = R.drawable.ojz;
                }
                i16 = R.color.f158017al3;
            } else if ((i17 & 16) != 0 || (i17 & 2) == 0) {
                i16 = R.drawable.lkw;
                i18 = R.drawable.ojg;
            } else {
                i16 = R.drawable.lkw;
            }
            findViewById.setBackgroundResource(i18);
            findViewById.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            if (findViewById2 != null) {
                findViewById2.setBackgroundResource(i18);
            }
            view3.setBackgroundResource(i16);
            view3.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
        }
        return view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (!this.f135929l) {
            this.f135929l = true;
        }
        return Math.max(1, this.f135923f.size());
    }

    @Override // com.tencent.weui.base.preference.IPreferenceScreen
    public void hidePreference(String str, boolean z16) {
        if (z16) {
            if (!this.f135921d.contains(str)) {
                this.f135921d.add(str);
            } else {
                return;
            }
        } else if (!this.f135921d.remove(str)) {
            return;
        }
        notifyDataSetChanged();
    }

    @Override // com.tencent.weui.base.preference.IPreferenceScreen
    public int indexOf(String str) {
        return this.f135919b.indexOf(str);
    }

    @Override // com.tencent.weui.base.preference.IPreferenceScreen
    public int indexOfShow(String str) {
        LinkedList linkedList = this.f135922e;
        if (linkedList == null) {
            return -1;
        }
        return linkedList.indexOf(str);
    }

    @Override // android.widget.BaseAdapter, com.tencent.weui.base.preference.IPreferenceScreen
    public void notifyDataSetChanged() {
        b();
        a();
        int size = this.f135922e.size();
        this.f135927j = new int[size];
        if (size <= 0) {
            return;
        }
        if (size == 1) {
            int layoutResource = ((Preference) this.f135920c.get(this.f135922e.get(0))).getLayoutResource();
            Preference preference = (Preference) this.f135920c.get(this.f135922e.get(0));
            if (a(layoutResource)) {
                if (preference instanceof CheckBoxPreference) {
                    int[] iArr = this.f135927j;
                    iArr[0] = iArr[0] | 8;
                } else {
                    this.f135927j[0] = 3;
                }
            } else {
                this.f135927j[0] = 4;
            }
            a((Preference) this.f135920c.get(this.f135922e.get(0)), this.f135925h);
            super.notifyDataSetChanged();
            return;
        }
        for (int i3 = 0; i3 < this.f135922e.size(); i3++) {
            a((Preference) this.f135920c.get(this.f135922e.get(i3)), this.f135925h);
            Preference preference2 = (Preference) this.f135920c.get(this.f135922e.get(i3));
            int layoutResource2 = preference2.getLayoutResource();
            if (a(layoutResource2)) {
                if (preference2 instanceof CheckBoxPreference) {
                    int[] iArr2 = this.f135927j;
                    iArr2[i3] = iArr2[i3] | 8;
                } else if (i3 == 0) {
                    int[] iArr3 = this.f135927j;
                    iArr3[i3] = iArr3[i3] | 1;
                } else {
                    if (i3 == this.f135922e.size() - 1) {
                        int[] iArr4 = this.f135927j;
                        iArr4[i3] = iArr4[i3] | 2;
                    }
                    int layoutResource3 = ((Preference) this.f135920c.get(this.f135922e.get(i3 - 1))).getLayoutResource();
                    if (layoutResource3 != R.layout.fkb || layoutResource3 == R.layout.fkp || layoutResource3 == R.layout.fkq) {
                        int[] iArr5 = this.f135927j;
                        iArr5[i3] = iArr5[i3] | 1;
                    }
                }
            } else if (layoutResource2 == R.layout.fkg) {
                if (i3 == 0) {
                    int[] iArr6 = this.f135927j;
                    iArr6[i3] = iArr6[i3] | 4;
                } else {
                    int[] iArr7 = this.f135927j;
                    iArr7[i3] = iArr7[i3] | 16;
                    int i16 = i3 - 1;
                    int layoutResource4 = ((Preference) this.f135920c.get(this.f135922e.get(i16))).getLayoutResource();
                    if (layoutResource4 == R.layout.fkb || layoutResource4 == R.layout.fkp || layoutResource4 == R.layout.fkq) {
                        int[] iArr8 = this.f135927j;
                        iArr8[i16] = iArr8[i16] | 2;
                    }
                }
            } else {
                int[] iArr9 = this.f135927j;
                iArr9[i3] = iArr9[i3] | 4;
                if (i3 != 0) {
                    int i17 = i3 - 1;
                    int layoutResource5 = ((Preference) this.f135920c.get(this.f135922e.get(i17))).getLayoutResource();
                    if (a(layoutResource5) || layoutResource5 == R.layout.fkg) {
                        int[] iArr10 = this.f135927j;
                        iArr10[i17] = iArr10[i17] | 2;
                    }
                }
            }
        }
        super.notifyDataSetChanged();
    }

    @Override // com.tencent.weui.base.preference.IPreferenceScreen
    public void removeAll() {
        this.f135922e.clear();
        this.f135920c.clear();
        this.f135919b.clear();
        this.f135921d.clear();
        notifyDataSetChanged();
    }

    @Override // com.tencent.weui.base.preference.IPreferenceScreen
    public boolean removePreference(Preference preference) {
        if (preference == null) {
            return false;
        }
        String a16 = a(preference);
        this.f135919b.remove(a16);
        this.f135920c.remove(a16);
        this.f135921d.remove(preference.getKey());
        notifyDataSetChanged();
        return true;
    }

    public static String a(Preference preference) {
        if (preference.getKey() != null && preference.getKey().length() > 0) {
            return preference.getKey();
        }
        return "_anonymous_pref@" + preference.hashCode();
    }

    @Override // com.tencent.weui.base.preference.IPreferenceScreen
    public void addPreference(Preference preference, boolean z16) {
        a(preference, -1);
        if (!z16 || this.f135928k) {
            return;
        }
        notifyDataSetChanged();
    }

    public final void b() {
        this.f135922e.clear();
        Iterator it = this.f135919b.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!this.f135921d.contains(str)) {
                if (this.f135920c.get(str) == null) {
                    n.b("MicroMsg.WeUIPreferenceAdapter", "not found pref by key " + str, new Object[0]);
                } else {
                    this.f135922e.add(str);
                }
            }
        }
        if (this.f135922e.isEmpty() || !a(((Preference) this.f135920c.get(this.f135922e.get(0))).getLayoutResource())) {
            return;
        }
        a(new b(this.f135926i), 0);
    }

    public static void a(Preference preference, SharedPreferences sharedPreferences) {
        if (preference instanceof CheckBoxPreference) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if (checkBoxPreference.isPersistent()) {
                checkBoxPreference.setChecked(sharedPreferences.getBoolean(preference.getKey(), ((CheckBoxPreference) preference).isChecked()));
            }
        }
    }

    @Override // com.tencent.weui.base.preference.IPreferenceScreen
    public void addPreference(Preference preference, int i3) {
        a(preference, i3);
        if (this.f135928k) {
            return;
        }
        notifyDataSetChanged();
    }

    @Override // com.tencent.weui.base.preference.IPreferenceScreen
    public boolean removePreference(String str) {
        return removePreference(findPreference(str));
    }

    public final void a(Preference preference, int i3) {
        String a16 = a(preference);
        this.f135920c.put(a16, preference);
        LinkedList linkedList = this.f135919b;
        if (i3 == -1) {
            i3 = linkedList.size();
        }
        linkedList.add(i3, a16);
        if (!this.f135923f.containsKey(b(preference)) && !this.f135929l) {
            this.f135923f.put(b(preference), Integer.valueOf(this.f135923f.size()));
        }
        if (preference.getDependency() != null) {
            this.f135924g.put(preference.getDependency() + "|" + preference.getKey(), preference.getKey());
        }
    }

    public void a(Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
        this.f135930m = onPreferenceChangeListener;
        notifyDataSetChanged();
    }

    public final void a() {
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < this.f135922e.size(); i3++) {
            if (i3 != 0) {
            }
        }
        this.f135922e.removeAll(hashSet);
    }
}
