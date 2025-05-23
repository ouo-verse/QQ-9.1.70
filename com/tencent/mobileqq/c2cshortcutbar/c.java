package com.tencent.mobileqq.c2cshortcutbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f200952d;

    /* renamed from: e, reason: collision with root package name */
    private List<com.tencent.mobileqq.c2cshortcutbar.b> f200953e;

    /* renamed from: f, reason: collision with root package name */
    private a f200954f;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(com.tencent.mobileqq.c2cshortcutbar.b bVar, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public URLImageView f200955a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f200956b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f200957c;

        /* renamed from: d, reason: collision with root package name */
        public View f200958d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f200959e;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public c(Context context, List<com.tencent.mobileqq.c2cshortcutbar.b> list, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, list, aVar);
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f200953e = arrayList;
        this.f200952d = context;
        this.f200954f = aVar;
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    private void c(ImageView imageView, String str) {
        Drawable drawable = this.f200952d.getResources().getDrawable(R.drawable.f160326fp);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        obtain.mRequestHeight = layoutParams.height;
        obtain.mRequestWidth = layoutParams.width;
        try {
            URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
            drawable2.setTag(com.tencent.mobileqq.urldrawable.a.c(layoutParams.width, layoutParams.height, ViewUtils.dip2px(2.0f)));
            drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
            imageView.setImageDrawable(drawable2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("C2CShortcutBarAdapter", 2, "updateIconView exception ", e16);
            }
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.c2cshortcutbar.b getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.c2cshortcutbar.b) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return this.f200953e.get(i3);
    }

    public void b(List<com.tencent.mobileqq.c2cshortcutbar.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            if (list == null) {
                return;
            }
            this.f200953e.clear();
            this.f200953e.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f200953e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                bVar = new b();
                view2 = LayoutInflater.from(this.f200952d).inflate(R.layout.gvu, viewGroup, false);
                bVar.f200955a = (URLImageView) view2.findViewById(R.id.ir8);
                bVar.f200956b = (TextView) view2.findViewById(R.id.iru);
                bVar.f200957c = (TextView) view2.findViewById(R.id.irt);
                bVar.f200958d = view2.findViewById(R.id.f125017kx);
                bVar.f200959e = (TextView) view2.findViewById(R.id.f84784n7);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            com.tencent.mobileqq.c2cshortcutbar.b item = getItem(i3);
            boolean isInNightMode = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
            if (isInNightMode) {
                bVar.f200956b.setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
            } else {
                bVar.f200956b.setTextColor(Color.parseColor("#1C1D1E"));
            }
            if (isInNightMode) {
                view2.setBackgroundDrawable(view2.getResources().getDrawable(R.drawable.a9v));
            } else {
                view2.setBackgroundDrawable(view2.getResources().getDrawable(R.drawable.a9n));
            }
            if (!TextUtils.isEmpty(item.f200946l)) {
                bVar.f200958d.setVisibility(0);
                bVar.f200959e.setVisibility(0);
                bVar.f200959e.setText(item.f200946l);
            } else {
                bVar.f200958d.setVisibility(8);
                bVar.f200959e.setVisibility(8);
            }
            c(bVar.f200955a, item.f200938d);
            bVar.f200956b.setText(item.f200937c);
            a aVar = this.f200954f;
            if (aVar != null) {
                aVar.a(item, i3);
            }
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }
}
