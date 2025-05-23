package com.tencent.mobileqq.settings.message;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class x extends com.tencent.mobileqq.adapter.j {
    static IPatchRedirector $redirector_;
    private final Context F;
    private final BaseQQAppInterface G;
    private final List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> H;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a extends com.tencent.mobileqq.adapter.k {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        public View f287076i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f287077m;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public x(Context context, QQAppInterface qQAppInterface, XListView xListView, List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list) {
        super(context, qQAppInterface, xListView, 1, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, xListView, list);
            return;
        }
        this.G = qQAppInterface;
        this.F = context;
        this.H = list;
        xListView.setAdapter((ListAdapter) this);
    }

    private void k(a aVar, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        long hashCode = dVar.hashCode();
        VideoReport.setElementId(aVar.f287076i, "em_only_chat_touin_list");
        HashMap hashMap = new HashMap();
        hashMap.put("touin", dVar.x());
        VideoReport.setElementParams(aVar.f287076i, hashMap);
        VideoReport.setElementReuseIdentifier(aVar.f287076i, "" + hashCode);
        VideoReport.setElementExposePolicy(aVar.f287076i, ExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.adapter.j
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.destroy();
        }
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.H.size();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        String r16;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view2 = (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                aVar = new a();
                view2 = LayoutInflater.from(this.F).inflate(R.layout.f167981ea4, (ViewGroup) null);
                aVar.f187212f = (ImageView) view2.findViewById(R.id.f163821d);
                aVar.f287077m = (TextView) view2.findViewById(R.id.f97);
                ImageView imageView = aVar.f187212f;
                if (imageView instanceof ThemeImageView) {
                    ((ThemeImageView) imageView).setSupportMaskView(false);
                }
                aVar.f287076i = view2;
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d item = getItem(i3);
            if (item == null) {
                view2.setVisibility(8);
            } else {
                aVar.f187210d = item.x();
                if (TextUtils.isEmpty(item.r())) {
                    r16 = item.p();
                } else {
                    r16 = item.r();
                }
                aVar.f287077m.setText(r16);
                aVar.f187212f.setImageBitmap(c(1, aVar.f187210d));
                k(aVar, item);
            }
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.H;
    }

    public ArrayList<String> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it = this.H.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().x());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.d getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.H.size()) {
            return this.H.get(i3);
        }
        return null;
    }
}
