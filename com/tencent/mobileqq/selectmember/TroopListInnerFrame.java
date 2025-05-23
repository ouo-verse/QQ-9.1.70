package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.selectmember.TroopListAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.widget.AbsListView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TroopListInnerFrame extends SelectMemberInnerFrame implements View.OnClickListener, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;
    SlideDetectListView D;
    private TroopListAdapter E;
    List<TroopInfo> F;
    TextView G;
    Context H;
    int I;

    public TroopListInnerFrame(Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void r() {
        this.F = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache();
    }

    private void s(int i3) {
        String string;
        int i16;
        this.G.setVisibility(0);
        if (i3 == 0 && this.D.getChildAt(0) != null && this.D.getChildAt(0).getBottom() == this.I) {
            this.G.setVisibility(4);
            return;
        }
        Object item = this.E.getItem(i3);
        if (!(item instanceof TroopListAdapter.b)) {
            return;
        }
        switch (((TroopListAdapter.b) item).f285872a) {
            case 0:
            case 1:
                string = this.H.getString(R.string.dsw, String.valueOf(this.E.I));
                break;
            case 2:
            case 3:
                string = this.H.getString(R.string.dt7, String.valueOf(this.E.H));
                break;
            case 4:
            case 5:
                string = this.H.getString(R.string.f171286dr4, String.valueOf(this.E.F));
                break;
            case 6:
            case 7:
                string = this.H.getString(R.string.ds6, String.valueOf(this.E.G));
                break;
            case 8:
            case 9:
                string = this.H.getString(R.string.dvq, String.valueOf(this.E.J));
                break;
            default:
                string = null;
                break;
        }
        int i17 = i3 + 1;
        if (i17 < this.E.getCount()) {
            TroopListAdapter.b bVar = (TroopListAdapter.b) this.E.getItem(i17);
            if (bVar != null && ((i16 = bVar.f285872a) == 6 || i16 == 4 || i16 == 2 || i16 == 8)) {
                View childAt = this.D.getChildAt(0);
                if (childAt != null) {
                    int bottom = childAt.getBottom();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                    int i18 = this.I;
                    if (bottom < i18) {
                        layoutParams.topMargin = bottom - i18;
                    } else {
                        layoutParams.topMargin = 0;
                    }
                    this.G.setLayoutParams(layoutParams);
                    this.G.requestLayout();
                }
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    this.G.setLayoutParams(layoutParams2);
                    this.G.requestLayout();
                }
            }
        }
        if (!TextUtils.isEmpty(string)) {
            this.G.setVisibility(0);
            this.G.setText(string);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame, com.tencent.common.app.InnerFrame
    public void j(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.j(bundle);
        setContentView(R.layout.acz);
        this.D = (SlideDetectListView) findViewById(R.id.f167137l64);
        this.G = (TextView) findViewById(R.id.k1f);
        this.D.setSelector(R.color.ajr);
        TroopListAdapter troopListAdapter = new TroopListAdapter(this.f285782h, this.f285784m, this.D, 4, false, this);
        this.E = troopListAdapter;
        this.D.setAdapter((ListAdapter) troopListAdapter);
        r();
        this.E.h(this.f285784m, this.F);
        this.D.setOnScrollGroupFloatingListener(this);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
        } else {
            super.m(bundle);
            this.f285782h.setupTitleBar(true, "", "");
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public com.tencent.mobileqq.search.view.f n(boolean z16, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.search.view.f) iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), kVar);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DiscussionInfo discussionInfo;
        TroopInfo troopInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else {
            TroopListAdapter.c cVar = (TroopListAdapter.c) view.getTag();
            if (cVar != null && (troopInfo = cVar.f285879m) != null) {
                Bundle bundle = new Bundle();
                bundle.putString("group_uin", troopInfo.troopuin);
                bundle.putString("group_name", troopInfo.getTroopDisplayName());
                this.f285783i.j(6, bundle);
                int i3 = cVar.D;
                int i16 = 1;
                if (i3 != 1) {
                    if (i3 != 3) {
                        if (i3 != 5) {
                            if (i3 != 7) {
                                if (i3 == 9) {
                                    i16 = 4;
                                }
                            } else {
                                i16 = 2;
                            }
                        }
                    } else {
                        i16 = 3;
                    }
                    ReportController.o(this.f285784m, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, troopInfo.troopuin + "", String.valueOf(i16), "", "");
                }
                i16 = 0;
                ReportController.o(this.f285784m, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, troopInfo.troopuin + "", String.valueOf(i16), "", "");
            } else if (cVar != null && (discussionInfo = cVar.C) != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("group_uin", discussionInfo.uin);
                bundle2.putString("group_name", discussionInfo.discussionName);
                this.f285783i.j(7, bundle2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        TroopListAdapter troopListAdapter = this.E;
        if (troopListAdapter != null) {
            troopListAdapter.a();
        }
        super.onDestroy();
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else if (this.E != null) {
            s(i3);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) absListView, i3);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.E.notifyDataSetChanged();
        }
    }

    public TroopListInnerFrame(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TroopListInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.G = null;
        this.H = context;
        this.I = context.getResources().getDimensionPixelSize(R.dimen.f159607b14);
    }
}
