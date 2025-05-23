package com.tencent.mobileqq.app;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.TKDSearchHistoryBean;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cw implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f195473d;

    /* renamed from: e, reason: collision with root package name */
    private static final cw f195474e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f195475f;

    /* renamed from: h, reason: collision with root package name */
    private static final CopyOnWriteArrayList<b> f195476h;

    /* renamed from: i, reason: collision with root package name */
    static final /* synthetic */ boolean f195477i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends TypeToken<ArrayList<TKDSearchHistoryBean>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cw.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void onHistoryChanged();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69952);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f195477i = true;
        f195473d = cw.class.getSimpleName();
        f195474e = new cw();
        f195475f = false;
        f195476h = new CopyOnWriteArrayList<>();
    }

    public cw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static void b(@NonNull b bVar) {
        f195476h.add(bVar);
    }

    @NonNull
    private Type d() {
        return new a().getType();
    }

    @NonNull
    private String f() {
        return (String) ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).getReadInJoySpValue("search_keyword_list", "");
    }

    @NonNull
    private List<TKDSearchHistoryBean> h(String str) {
        try {
            List<TKDSearchHistoryBean> list = (List) new Gson().fromJson(str, d());
            if (list == null) {
                return new ArrayList();
            }
            return list;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @NonNull
    private String i(List<TKDSearchHistoryBean> list) {
        try {
            return new Gson().toJson(list, d());
        } catch (Exception unused) {
            return "";
        }
    }

    private void j() {
        Iterator<b> it = f195476h.iterator();
        while (it.hasNext()) {
            it.next().onHistoryChanged();
        }
    }

    public static void k(@NonNull b bVar) {
        f195476h.remove(bVar);
    }

    private void l(@NonNull List<TKDSearchHistoryBean> list) {
        if (list.size() > 30) {
            list = list.subList(0, 30);
        }
        f195475f = true;
        ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).updateReadInJoySpValue("search_keyword_list", i(list));
        j();
    }

    public void a(@Nullable JSONArray jSONArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSONArray);
            return;
        }
        if (jSONArray == null) {
            if (QLog.isColorLevel()) {
                QLog.i(f195473d, 2, "addAllSearchHistory key word is null");
                return;
            }
            return;
        }
        List<TKDSearchHistoryBean> e16 = e();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String optString = jSONArray.optString(i3);
            if (!TextUtils.isEmpty(optString)) {
                TKDSearchHistoryBean createFromKeyword = TKDSearchHistoryBean.createFromKeyword(optString);
                arrayList.add(createFromKeyword);
                e16.remove(createFromKeyword);
            }
        }
        arrayList.addAll(e16);
        l(arrayList);
    }

    public void c(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i(f195473d, 2, "addSearchHistory key word is null");
                return;
            }
            return;
        }
        List<TKDSearchHistoryBean> e16 = e();
        if (!f195477i && str == null) {
            throw new AssertionError();
        }
        TKDSearchHistoryBean createFromKeyword = TKDSearchHistoryBean.createFromKeyword(str);
        e16.remove(createFromKeyword);
        e16.add(0, createFromKeyword);
        l(e16);
    }

    @NonNull
    public List<TKDSearchHistoryBean> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return h(f());
    }

    @NonNull
    public ArrayList<String> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        List<TKDSearchHistoryBean> e16 = e();
        ArrayList<String> arrayList = new ArrayList<>();
        for (TKDSearchHistoryBean tKDSearchHistoryBean : e16) {
            if (tKDSearchHistoryBean != null) {
                arrayList.add(tKDSearchHistoryBean.getTitle());
            }
        }
        return arrayList;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public cw(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
    }
}
