package com.tencent.mobileqq.location.ui.headset;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.location.ui.HeadSetView;
import com.tencent.mobileqq.location.ui.MapUtils;
import com.tencent.mobileqq.location.ui.k;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final HorizontalListView f241639d;

    /* renamed from: e, reason: collision with root package name */
    private final HeadSetView f241640e;

    /* renamed from: f, reason: collision with root package name */
    private k f241641f;

    /* renamed from: h, reason: collision with root package name */
    private final Context f241642h;

    /* renamed from: i, reason: collision with root package name */
    private List<String> f241643i;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.location.ui.headset.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class ViewOnClickListenerC7981a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f241644d;

        ViewOnClickListenerC7981a(String str) {
            this.f241644d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a.this.f241641f.m(this.f241644d);
                ReportController.o(null, "CliOper", "", "", "0X800A770", "0X800A770", 0, 0, "", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        QQProAvatarView f241646a;

        /* renamed from: b, reason: collision with root package name */
        String f241647b;

        public b(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.f241646a = (QQProAvatarView) a.b(view, R.id.lrb);
            }
        }
    }

    public a(Context context, HorizontalListView horizontalListView, HeadSetView headSetView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, horizontalListView, headSetView);
            return;
        }
        this.f241642h = context;
        this.f241639d = horizontalListView;
        this.f241640e = headSetView;
        this.f241643i = new ArrayList();
    }

    protected static <T extends View> T b(View view, int i3) {
        return (T) view.findViewById(i3);
    }

    private void d(@NonNull List<String> list) {
        this.f241643i = list;
    }

    public void c(@NonNull List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (this.f241643i.equals(list) && QLog.isColorLevel()) {
            QLog.d("HeadAdapter", 2, "notifyDataSetChangedAdvance: invoked. same list, ", " newHeadSetList: ", list, " headSetList: ", this.f241643i);
        }
        d(list);
        if (this.f241643i.size() <= this.f241640e.h()) {
            this.f241639d.setOverScrollMode(1);
        } else {
            this.f241639d.setOverScrollMode(0);
        }
        super.notifyDataSetChanged();
    }

    public void e(k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) kVar);
        } else {
            this.f241641f = kVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.f241641f == null) {
            return 0;
        }
        return this.f241643i.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return this.f241643i.get(i3);
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
        b bVar;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            String str = (String) getItem(i3);
            if (view == null) {
                view = LayoutInflater.from(this.f241642h).inflate(R.layout.c8q, (ViewGroup) null);
                bVar = new b(view);
                if (QLog.isColorLevel()) {
                    QLog.d("HeadAdapter", 2, "getView: invoked. ", " position: ", Integer.valueOf(i3));
                }
                bVar.f241647b = str;
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
                bVar.f241647b = str;
            }
            view.setOnClickListener(new ViewOnClickListenerC7981a(str));
            bVar.f241646a.x(1, bVar.f241647b, null);
            MapUtils.i(view, ((IFriendNameService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFriendNameService.class, "")).getFriendNick(str) + "\u6b63\u5728\u5171\u4eab\u4f4d\u7f6e");
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }
}
