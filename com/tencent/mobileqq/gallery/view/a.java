package com.tencent.mobileqq.gallery.view;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.galleryactivity.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f211827d;

    /* renamed from: e, reason: collision with root package name */
    SparseArray<URLDrawable> f211828e;

    /* renamed from: f, reason: collision with root package name */
    int f211829f;

    public a(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            return;
        }
        this.f211828e = new SparseArray<>();
        this.f211829f = -1;
        this.f211827d = list;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        List<String> list = this.f211827d;
        if (list != null && i3 < list.size() && i3 >= 0) {
            return this.f211827d.get(i3);
        }
        return null;
    }

    public String b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("//")) {
            return "file:/" + str;
        }
        if (str.startsWith("/")) {
            return "file://" + str;
        }
        return str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        List<String> list = this.f211827d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
        } else if (view != null) {
            view2 = view;
        } else {
            String b16 = b(getItem(i3));
            URLDrawable uRLDrawable = this.f211828e.get(i3);
            if (QLog.isColorLevel()) {
                QLog.d("BigImageAdapter", 2, "getView position=" + i3 + ",cache=" + uRLDrawable + JefsClass.INDEX_URL + b16);
            }
            URLImageView2 uRLImageView2 = new URLImageView2(viewGroup.getContext());
            if (uRLDrawable != null && uRLDrawable.getStatus() == 1) {
                uRLImageView2.setImageDrawable(uRLDrawable);
            } else if (!TextUtils.isEmpty(b16)) {
                int width = viewGroup.getWidth();
                int height = viewGroup.getHeight();
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = width;
                obtain.mRequestHeight = height;
                obtain.mLoadingDrawable = b.f306350a;
                URLDrawable drawable = URLDrawable.getDrawable(b16, obtain);
                int status = drawable.getStatus();
                if (status != 1 && status != 2 && status != 3) {
                    drawable.setTag(1);
                    drawable.startDownload();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("BigImageAdapter", 2, "getView position=" + i3 + ",parentWidth=" + width + ",parentHeight=" + height);
                }
                uRLImageView2.setImageDrawable(drawable);
            }
            uRLImageView2.setContentDescription(HardCodeUtil.qqStr(R.string.p6e) + i3);
            view2 = uRLImageView2;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }
}
