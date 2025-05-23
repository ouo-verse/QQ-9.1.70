package fp3;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.open.agent.AuthorityControlAppDetailsFragment;
import com.tencent.open.agent.util.g;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends BaseAdapter implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private final IphoneTitleBarFragment f400247d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f400248e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f400249f;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private List<AppInfo> f400250h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private List<Integer> f400251i = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private boolean f400252m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f400253a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f400254b;

        /* renamed from: c, reason: collision with root package name */
        View f400255c;

        /* renamed from: d, reason: collision with root package name */
        CheckBox f400256d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f400257e;

        /* renamed from: f, reason: collision with root package name */
        TextView f400258f;

        /* renamed from: g, reason: collision with root package name */
        TextView f400259g;

        a() {
        }
    }

    public c(IphoneTitleBarFragment iphoneTitleBarFragment, QQAppInterface qQAppInterface) {
        this.f400247d = iphoneTitleBarFragment;
        this.f400248e = iphoneTitleBarFragment.getBaseActivity();
        this.f400249f = qQAppInterface;
    }

    private void a(a aVar) {
        aVar.f400256d.setVisibility(0);
        aVar.f400254b.setVisibility(8);
    }

    private void b(a aVar) {
        aVar.f400256d.setVisibility(8);
        aVar.f400254b.setVisibility(0);
    }

    private void c(a aVar, AppInfo appInfo) {
        String b16 = appInfo.b();
        Drawable drawable = this.f400248e.getResources().getDrawable(R.drawable.f160326fp);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        ViewGroup.LayoutParams layoutParams = aVar.f400257e.getLayoutParams();
        obtain.mRequestHeight = layoutParams.height;
        obtain.mRequestWidth = layoutParams.width;
        try {
            URLDrawable drawable2 = URLDrawable.getDrawable(b16, obtain);
            drawable2.setTag(com.tencent.mobileqq.urldrawable.a.c(layoutParams.width, layoutParams.height, UIUtils.b(this.f400248e, 6.0f)));
            drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
            aVar.f400257e.setImageDrawable(drawable2);
        } catch (Throwable unused) {
        }
        aVar.f400256d.setChecked(appInfo.a());
    }

    private void f(a aVar, View view) {
        aVar.f400255c = view.findViewById(R.id.e2n);
        aVar.f400256d = (CheckBox) view.findViewById(R.id.f2x);
        aVar.f400254b = (ImageView) view.findViewById(R.id.d5t);
        aVar.f400258f = (TextView) view.findViewById(R.id.f164390w1);
        aVar.f400259g = (TextView) view.findViewById(R.id.f164399w8);
        aVar.f400257e = (ImageView) view.findViewById(R.id.f164380vl);
    }

    private void h(View view) {
        a aVar = (a) view.getTag();
        if (this.f400252m) {
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.f2x);
            boolean z16 = !checkBox.isChecked();
            checkBox.setChecked(z16);
            if (checkBox.isChecked()) {
                this.f400251i.add(Integer.valueOf(aVar.f400253a));
            } else {
                this.f400251i.remove(Integer.valueOf(aVar.f400253a));
            }
            if (this.f400251i.size() > 0) {
                this.f400247d.rightViewText.setEnabled(true);
            } else {
                this.f400247d.rightViewText.setEnabled(false);
            }
            AppInfo appInfo = this.f400250h.get(aVar.f400253a);
            if (appInfo != null) {
                appInfo.j(z16);
            }
            if (QLog.isColorLevel()) {
                QLog.i("AuthorityControlAdapter", 2, "onLayoutAppItemClick: invoked.  mCheckedPositions: " + this.f400251i);
                return;
            }
            return;
        }
        AppInfo appInfo2 = this.f400250h.get(aVar.f400253a);
        AuthorityControlAppDetailsFragment.Vh(this.f400248e, appInfo2);
        g.R(this.f400249f, "0X800B92F", new String[]{"", "", appInfo2.e(), ""});
    }

    private void i(int i3, View view, a aVar) {
        aVar.f400253a = i3;
        aVar.f400255c.setOnClickListener(this);
        AppInfo appInfo = this.f400250h.get(i3);
        String e16 = appInfo.e();
        if (e16 == null) {
            e16 = "";
        }
        aVar.f400258f.setText(e16.trim());
        aVar.f400259g.setText(appInfo.f());
        aVar.f400256d.setChecked(false);
        c(aVar, appInfo);
    }

    @NonNull
    public List<AppInfo> d() {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.f400251i.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue < this.f400250h.size() && intValue >= 0) {
                arrayList.add(this.f400250h.get(intValue));
            }
        }
        return arrayList;
    }

    public boolean e() {
        return this.f400252m;
    }

    public void g() {
        if (this.f400252m) {
            this.f400247d.rightViewText.setEnabled(false);
        }
        this.f400251i.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f400250h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f400250h.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a();
            View inflate = LayoutInflater.from(this.f400248e).inflate(R.layout.f167666dr, (ViewGroup) null);
            f(aVar2, inflate);
            inflate.setTag(aVar2);
            aVar = aVar2;
            view = inflate;
        } else {
            aVar = (a) view.getTag();
        }
        i(i3, view, aVar);
        if (this.f400252m) {
            a(aVar);
        } else {
            b(aVar);
        }
        if (getCount() == 1) {
            view.setBackgroundResource(R.drawable.jb5);
        } else if (i3 == 0) {
            view.setBackgroundResource(R.drawable.jb8);
        } else if (i3 == getCount() - 1) {
            view.setBackgroundResource(R.drawable.jaz);
        } else {
            view.setBackgroundResource(R.drawable.f160329jb2);
        }
        view.setPadding(UIUtils.b(this.f400248e, 16.0f), UIUtils.b(this.f400248e, 12.0f), UIUtils.b(this.f400248e, 16.0f), UIUtils.b(this.f400248e, 12.0f));
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    public void j(List<AppInfo> list) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (AppInfo appInfo : this.f400250h) {
            Iterator<AppInfo> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (appInfo.c() == it.next().c()) {
                        z16 = false;
                        break;
                    }
                } else {
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                arrayList.add(appInfo);
            }
        }
        this.f400250h.clear();
        this.f400250h.addAll(arrayList);
    }

    public void k(@NonNull List<AppInfo> list) {
        this.f400250h = list;
    }

    public void l() {
        this.f400252m = true;
        this.f400251i.clear();
        Iterator<AppInfo> it = this.f400250h.iterator();
        while (it.hasNext()) {
            it.next().j(false);
        }
        notifyDataSetChanged();
    }

    public void m() {
        this.f400252m = false;
        notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.e2n) {
            h(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
