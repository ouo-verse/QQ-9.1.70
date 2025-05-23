package com.tencent.luggage.wxa.w3;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.luggage.wxa.g6.r;
import com.tencent.luggage.wxa.g6.t;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import com.tencent.weui.base.preference.CheckBoxPreference;
import com.tencent.weui.base.preference.IPreferenceScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00032\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J \u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u000e\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0002R\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00128\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u000e\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001cR\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/luggage/wxa/w3/a;", "Lcom/tencent/luggage/wxa/g6/r;", "", "g", "", "b", "onStart", "Landroid/content/SharedPreferences;", "d", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "screen", "Landroid/preference/Preference;", "pref", "", "a", "Landroid/view/View;", "view", "sp", "Lcom/tencent/luggage/wxa/nq/c;", "Landroid/content/SharedPreferences;", "defaultSharedPreferences", "c", "Lcom/tencent/luggage/wxa/nq/c;", "j", "()Lcom/tencent/luggage/wxa/nq/c;", "(Lcom/tencent/luggage/wxa/nq/c;)V", "mScreen", "Landroid/widget/ListView;", "Landroid/widget/ListView;", "mListView", "e", "Z", "dirty", "f", "isRefreshing", "Lcom/tencent/luggage/wxa/g6/t;", "controller", "<init>", "(Lcom/tencent/luggage/wxa/g6/t;)V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public abstract class a extends r {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public SharedPreferences defaultSharedPreferences;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.nq.c mScreen;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ListView mListView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean dirty;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean isRefreshing;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Preference.OnPreferenceChangeListener {
        public b() {
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public final boolean onPreferenceChange(Preference pref, Object obj) {
            boolean z16;
            if (!a.this.isRefreshing && pref.isEnabled() && pref.isSelectable()) {
                a.this.isRefreshing = true;
                if (pref instanceof CheckBoxPreference) {
                    if (obj instanceof Boolean) {
                        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) pref;
                        Boolean bool = (Boolean) obj;
                        checkBoxPreference.setChecked(bool.booleanValue());
                        checkBoxPreference.updateCheckStatus(bool.booleanValue());
                    }
                    if (pref.isPersistent()) {
                        SharedPreferences sharedPreferences = a.this.defaultSharedPreferences;
                        if (sharedPreferences == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("defaultSharedPreferences");
                            sharedPreferences = null;
                        }
                        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) pref;
                        sharedPreferences.edit().putBoolean(checkBoxPreference2.getKey(), checkBoxPreference2.isChecked()).apply();
                    }
                    a.this.dirty = true;
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (pref.getKey() != null) {
                    a aVar = a.this;
                    com.tencent.luggage.wxa.nq.c j3 = aVar.j();
                    Intrinsics.checkNotNullExpressionValue(pref, "pref");
                    aVar.a(j3, pref);
                }
                if (z16) {
                    a.this.j().notifyDataSetChanged();
                }
                a.this.isRefreshing = false;
                if (z16) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView parent, View view, int i3, long j3) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(view, "view");
            Object item = parent.getAdapter().getItem(i3);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type android.preference.Preference");
            Preference preference = (Preference) item;
            if (preference.isEnabled() && preference.isSelectable() && !(preference instanceof CheckBoxPreference) && preference.getKey() != null) {
                a aVar = a.this;
                aVar.a(aVar.j(), preference);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements AdapterView.OnItemLongClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView parent, View view, int i3, long j3) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(view, "view");
            ListView listView = a.this.mListView;
            ListView listView2 = null;
            if (listView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListView");
                listView = null;
            }
            if (i3 >= listView.getHeaderViewsCount()) {
                ListView listView3 = a.this.mListView;
                if (listView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mListView");
                    listView3 = null;
                }
                int headerViewsCount = i3 - listView3.getHeaderViewsCount();
                if (headerViewsCount >= a.this.j().getCount()) {
                    w.b("UIPreferencePage", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(a.this.j().getCount()));
                    return false;
                }
                Object item = a.this.j().getItem(headerViewsCount);
                Intrinsics.checkNotNull(item, "null cannot be cast to non-null type android.preference.Preference");
                Preference preference = (Preference) item;
                a aVar = a.this;
                com.tencent.luggage.wxa.nq.c j16 = aVar.j();
                ListView listView4 = a.this.mListView;
                if (listView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mListView");
                } else {
                    listView2 = listView4;
                }
                return aVar.a(j16, preference, listView2);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView view, int i3, int i16, int i17) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView view, int i3) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull t controller) {
        super(controller);
        Intrinsics.checkNotNullParameter(controller, "controller");
    }

    public abstract boolean a(IPreferenceScreen screen, Preference pref);

    public final boolean a(IPreferenceScreen screen, Preference pref, View view) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(pref, "pref");
        return false;
    }

    public final SharedPreferences d() {
        SharedPreferences sharedPreferences = this.defaultSharedPreferences;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultSharedPreferences");
            return null;
        }
        return sharedPreferences;
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public int g() {
        return R.layout.fkm;
    }

    public final com.tencent.luggage.wxa.nq.c j() {
        com.tencent.luggage.wxa.nq.c cVar = this.mScreen;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mScreen");
        return null;
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onStart() {
        super.onStart();
        j().a(new b());
        ListView listView = this.mListView;
        ListView listView2 = null;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            listView = null;
        }
        listView.setAdapter((ListAdapter) j());
        ListView listView3 = this.mListView;
        if (listView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            listView3 = null;
        }
        listView3.setOnItemClickListener(new c());
        ListView listView4 = this.mListView;
        if (listView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            listView4 = null;
        }
        listView4.setOnItemLongClickListener(new d());
        ListView listView5 = this.mListView;
        if (listView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
        } else {
            listView2 = listView5;
        }
        listView2.setOnScrollListener(new e());
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void b() {
        super.b();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(getContext().getPackageName() + "_preferences", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere\u2026s\", Context.MODE_PRIVATE)");
        this.defaultSharedPreferences = sharedPreferences;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultSharedPreferences");
            sharedPreferences = null;
        }
        a(a(sharedPreferences));
        View findViewById = findViewById(android.R.id.list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.list)");
        this.mListView = (ListView) findViewById;
    }

    public final void a(com.tencent.luggage.wxa.nq.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mScreen = cVar;
    }

    public final com.tencent.luggage.wxa.nq.c a(SharedPreferences sp5) {
        return new com.tencent.luggage.wxa.nq.c(getContext(), sp5);
    }
}
