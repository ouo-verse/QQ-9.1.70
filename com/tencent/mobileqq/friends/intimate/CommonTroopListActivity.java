package com.tencent.mobileqq.friends.intimate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class CommonTroopListActivity extends IphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    private ListView C;
    private QQAppInterface D;
    private BaseActivity E;
    private b F;
    private ArrayList<IntimateInfo.CommonTroopInfo> G;
    private int H;
    private View.OnClickListener I;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CommonTroopListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (view.getTag() instanceof IntimateInfo.CommonTroopInfo) {
                    IntimateInfo.CommonTroopInfo commonTroopInfo = (IntimateInfo.CommonTroopInfo) view.getTag();
                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(CommonTroopListActivity.this.E), null);
                    m3.putExtra("uin", commonTroopInfo.troopCode);
                    m3.putExtra("uintype", 1);
                    m3.putExtra("uinname", commonTroopInfo.troopName);
                    CommonTroopListActivity.this.startActivity(m3);
                }
                ReportController.o(null, "dc00898", "", "", "0X8009F54", "0X8009F54", CommonTroopListActivity.this.H, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class b extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private List<IntimateInfo.CommonTroopInfo> f211742d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CommonTroopListActivity.this);
            }
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntimateInfo.CommonTroopInfo getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (IntimateInfo.CommonTroopInfo) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            return this.f211742d.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            List<IntimateInfo.CommonTroopInfo> list = this.f211742d;
            if (list == null) {
                return 0;
            }
            return list.size();
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
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(CommonTroopListActivity.this.E).inflate(R.layout.f168217pj, (ViewGroup) null);
                }
                IntimateInfo.CommonTroopInfo item = getItem(i3);
                ImageView imageView = (ImageView) view.findViewById(R.id.b68);
                TextView textView = (TextView) view.findViewById(R.id.b6_);
                imageView.setImageDrawable(FaceDrawable.getFaceDrawable(CommonTroopListActivity.this.D, 4, item.troopCode));
                textView.setText(item.troopName);
                view.setTag(item);
                view.setOnClickListener(CommonTroopListActivity.this.I);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        public void setData(List<IntimateInfo.CommonTroopInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else {
                this.f211742d = list;
            }
        }
    }

    public CommonTroopListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.H = -1;
            this.I = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = (ListView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.b69);
        BaseActivity baseActivity = this.E;
        if (baseActivity != null) {
            setTitle(baseActivity.getString(R.string.byh));
            this.H = this.E.getIntent().getIntExtra("report_friend_type", -1);
            this.G = this.E.getIntent().getParcelableArrayListExtra("common_troop_list");
            b bVar = new b();
            this.F = bVar;
            bVar.setData(this.G);
            this.C.setAdapter((ListAdapter) this.F);
            this.D = this.E.app;
        }
        ReportController.o(null, "dc00898", "", "", "0X8009F53", "0X8009F53", this.H, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.f168218pk;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onAttach(activity);
            this.E = getBaseActivity();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDetach();
            this.E = null;
        }
    }
}
