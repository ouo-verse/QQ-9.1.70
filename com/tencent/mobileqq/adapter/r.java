package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class r<T> extends com.tencent.mobileqq.emosm.view.b<T> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private DragSortListView f187239m;

    public r(Context context, List<T> list, DragSortListView dragSortListView) {
        super(context, list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, list, dragSortListView);
        } else {
            this.f187239m = dragSortListView;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view2 = (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (view == null) {
                view2 = View.inflate(this.f204445e, R.layout.h89, null);
            } else {
                view2 = view;
            }
            view2.setVisibility(0);
            view2.findViewById(R.id.iqk).setVisibility(8);
            TextView textView = (TextView) view2.findViewById(R.id.cxz);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) this.f204444d.get(i3);
            textView.setText(bVar.f());
            View findViewById = view2.findViewById(R.id.f165403cy3);
            if (AppSetting.f99565y) {
                AccessibilityUtil.d(findViewById, Button.class.getName());
            }
            ViewCompat.setImportantForAccessibility(findViewById, 1);
            view2.setContentDescription(bVar.f() + HardCodeUtil.qqStr(R.string.n4r));
            View findViewById2 = view2.findViewById(R.id.f165020bq3);
            if (AppSetting.f99565y) {
                AccessibilityUtil.d(findViewById2, Button.class.getName());
            }
            if (VersionUtils.isOreo() && AppSetting.f99565y) {
                view2.setOnClickListener(this);
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (AppSetting.f99565y) {
            this.f187239m.clickDelForAndroid8();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
