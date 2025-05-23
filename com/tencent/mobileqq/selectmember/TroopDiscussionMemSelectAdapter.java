package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.TroopListBaseAdapter;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TroopDiscussionMemSelectAdapter extends TroopListBaseAdapter implements ExpandableListView.OnGroupClickListener {
    static IPatchRedirector $redirector_;
    private View.OnClickListener N;
    private LayoutInflater P;
    private View.OnClickListener Q;
    private View.OnClickListener R;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDiscussionMemSelectAdapter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopDiscussionMemSelectAdapter.this.E((com.tencent.mobileqq.troop.adapter.contact.a) view.getTag());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDiscussionMemSelectAdapter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopDiscussionMemSelectAdapter.this.N.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends k {
        static IPatchRedirector $redirector_;
        public TroopInfo C;
        public DiscussionInfo D;
        public int E;
        public ImageView F;
        public ImageView G;

        /* renamed from: i, reason: collision with root package name */
        public TextView f285859i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f285860m;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDiscussionMemSelectAdapter.this);
            }
        }
    }

    public TroopDiscussionMemSelectAdapter(Context context, AppInterface appInterface, Bundle bundle, ExpandableListView expandableListView, View.OnClickListener onClickListener) {
        super(context, appInterface, expandableListView, bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, bundle, expandableListView, onClickListener);
            return;
        }
        this.Q = new a();
        this.R = new b();
        this.N = onClickListener;
        this.P = LayoutInflater.from(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void C(com.tencent.mobileqq.troop.adapter.contact.a aVar, int i3, boolean z16) {
        String str;
        int i16;
        String str2;
        if (aVar != null) {
            if (i3 >= 0 && i3 < this.E.size()) {
                int intValue = this.E.get(i3).intValue();
                if (intValue != 2) {
                    if (intValue != 4) {
                        if (intValue != 6) {
                            if (intValue == 13) {
                                str = HardCodeUtil.qqStr(R.string.uds);
                                i16 = this.I.size();
                            }
                        } else {
                            str = HardCodeUtil.qqStr(R.string.udo);
                            i16 = this.G.size();
                        }
                    } else {
                        str = HardCodeUtil.qqStr(R.string.udr);
                        i16 = this.F.size();
                    }
                } else {
                    str = HardCodeUtil.qqStr(R.string.udp);
                    i16 = this.H.size();
                }
                StringBuilder sb5 = aVar.f293803g;
                if (AppSetting.f99565y) {
                    if (sb5 == null) {
                        sb5 = new StringBuilder(24);
                    } else {
                        sb5.delete(0, sb5.length());
                    }
                    sb5.append(str + " \u5206\u7ec4");
                }
                aVar.f293797a = i3;
                aVar.f293800d.setText(str);
                aVar.f293801e.setVisibility(8);
                aVar.f293799c.setVisibility(8);
                aVar.f293802f.setText(String.valueOf(i16));
                aVar.f293798b.setVisibility(0);
                aVar.f293798b.setChecked(z16);
                ViewCompat.setImportantForAccessibility(aVar.f293798b, 2);
                ViewCompat.setImportantForAccessibility(aVar.f293800d, 1);
                if (!z16) {
                    str2 = "\u5df2\u5c55\u5f00 ";
                } else {
                    str2 = "\u5df2\u6536\u8d77 ";
                }
                aVar.f293800d.setContentDescription(str2 + str + String.valueOf(i16));
            }
            str = "";
            i16 = 0;
            StringBuilder sb52 = aVar.f293803g;
            if (AppSetting.f99565y) {
            }
            aVar.f293797a = i3;
            aVar.f293800d.setText(str);
            aVar.f293801e.setVisibility(8);
            aVar.f293799c.setVisibility(8);
            aVar.f293802f.setText(String.valueOf(i16));
            aVar.f293798b.setVisibility(0);
            aVar.f293798b.setChecked(z16);
            ViewCompat.setImportantForAccessibility(aVar.f293798b, 2);
            ViewCompat.setImportantForAccessibility(aVar.f293800d, 1);
            if (!z16) {
            }
            aVar.f293800d.setContentDescription(str2 + str + String.valueOf(i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(com.tencent.mobileqq.troop.adapter.contact.a aVar) {
        int i3;
        if (this.E.size() == 1) {
            i3 = 0;
        } else {
            i3 = aVar.f293797a;
        }
        if (this.f285924f.isGroupExpanded(i3)) {
            this.f285924f.collapseGroup(i3);
            this.J.remove(this.E.get(i3));
        } else {
            this.f285924f.expandGroup(i3);
            this.J.add(this.E.get(i3));
        }
    }

    public void D(List<String> list) {
        List<String> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
            return;
        }
        LifecycleOwner lifecycleOwner = null;
        if (list.size() > 50) {
            List<String> subList = list.subList(0, 50);
            list2 = list.subList(50, list.size());
            list = subList;
        } else {
            list2 = null;
        }
        Object obj = this.C;
        if (obj instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) obj;
        }
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopCreateTroopPrivilegeFlag(list, "TroopDiscussionMemSelectAdapter", lifecycleOwner, new Function4<Boolean, Integer, String, List<? extends TroopInfo>, Unit>(list2) { // from class: com.tencent.mobileqq.selectmember.TroopDiscussionMemSelectAdapter.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f285854d;

            {
                this.f285854d = list2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDiscussionMemSelectAdapter.this, (Object) list2);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(Boolean bool, Integer num, String str, List<? extends TroopInfo> list3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, this, bool, num, str, list3);
                }
                List<String> list4 = this.f285854d;
                if (list4 != null) {
                    TroopDiscussionMemSelectAdapter.this.D(list4);
                    return null;
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.selectmember.TroopDiscussionMemSelectAdapter.3.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            TroopDiscussionMemSelectAdapter.this.z();
                        }
                    }
                });
                return null;
            }
        });
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, i3);
            return;
        }
        if (view == null || this.E.size() == 1) {
            return;
        }
        if (!(view.getTag() instanceof com.tencent.mobileqq.troop.adapter.contact.a)) {
            aVar = new com.tencent.mobileqq.troop.adapter.contact.a();
            aVar.f293798b = (CheckBox) view.findViewById(R.id.dv_);
            SingleLineTextView singleLineTextView = (SingleLineTextView) view.findViewById(R.id.group_name);
            aVar.f293800d = singleLineTextView;
            singleLineTextView.setDefaultTextColor(-8355712);
            aVar.f293801e = (SingleLineTextView) view.findViewById(R.id.f167055ka1);
            SimpleTextView simpleTextView = (SimpleTextView) view.findViewById(R.id.contact_count);
            aVar.f293802f = simpleTextView;
            simpleTextView.setDefaultTextColor(1711276032);
            aVar.f293799c = (ProgressBar) view.findViewById(R.id.f165958dx0);
            view.setTag(aVar);
        } else {
            aVar = (com.tencent.mobileqq.troop.adapter.contact.a) view.getTag();
        }
        C(aVar, i3, this.f285924f.isGroupExpanded(i3));
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        c cVar;
        Object obj;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view != null && view.getTag() != null) {
            cVar = (c) view.getTag();
        } else {
            view = this.P.inflate(R.layout.byk, (ViewGroup) this.f285924f, false);
            cVar = new c();
            cVar.f187212f = (ImageView) view.findViewById(R.id.c0o);
            cVar.F = (ImageView) view.findViewById(R.id.c1c);
            cVar.f285859i = (TextView) view.findViewById(R.id.k0i);
            cVar.f285860m = (TextView) view.findViewById(R.id.k08);
            cVar.G = (ImageView) view.findViewById(R.id.f164472yw);
            view.setTag(cVar);
        }
        TroopListBaseAdapter.b t16 = t(i3, i16);
        if (t16 != null && (obj = t16.f285887a) != null) {
            if (obj instanceof TroopInfo) {
                TroopInfo troopInfo = (TroopInfo) obj;
                cVar.f187210d = troopInfo.troopuin;
                cVar.f187211e = 4;
                if (!TextUtils.isEmpty(troopInfo.getTroopDisplayName())) {
                    str = troopInfo.getTroopDisplayName();
                } else {
                    str = troopInfo.troopuin;
                }
                SpannableString spannableStringFromColorNickText = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(str, 16);
                cVar.f187210d = troopInfo.troopuin;
                cVar.f285859i.setText(spannableStringFromColorNickText);
                cVar.C = troopInfo;
                cVar.D = null;
                cVar.E = t16.f285888b;
                if (!troopInfo.hasSetTroopName() && troopInfo.getMemberNumClient() > 0) {
                    cVar.f285860m.setVisibility(0);
                    cVar.f285860m.setText(String.format("(%d)", Integer.valueOf(troopInfo.getMemberNumClient())));
                } else {
                    cVar.f285860m.setVisibility(8);
                }
                c(cVar, null);
                view.setOnClickListener(this.N);
                if (!troopInfo.isAllowCreateDiscuss() && !troopInfo.isTroopOwner(this.f285881m.getCurrentAccountUin()) && !troopInfo.isTroopAdmin(this.f285881m.getCurrentAccountUin())) {
                    cVar.F.setVisibility(0);
                    cVar.f285859i.setTextColor(ContextCompat.getColor(this.C, R.color.qui_common_text_secondary));
                } else {
                    cVar.F.setVisibility(8);
                    cVar.f285859i.setTextColor(ContextCompat.getColor(this.C, R.color.qui_common_text_primary));
                }
            } else if (obj instanceof DiscussionInfo) {
                DiscussionInfo discussionInfo = (DiscussionInfo) obj;
                cVar.f187210d = discussionInfo.uin;
                cVar.f187211e = 101;
                cVar.f285859i.setText(com.tencent.mobileqq.selectmember.util.a.e(this.C, discussionInfo));
                if (!discussionInfo.hasRenamed()) {
                    cVar.f285860m.setVisibility(0);
                    cVar.f285860m.setText(String.format("(%d)", Integer.valueOf(((IDiscussionService) this.f285881m.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(discussionInfo.uin))));
                }
                view.setOnClickListener(this.N);
                c(cVar, null);
                cVar.D = discussionInfo;
                cVar.C = null;
                cVar.E = t16.f285888b;
            } else if (QLog.isColorLevel()) {
                QLog.d("TroopDiscussionMemSelectAdapter", 2, "getChildView data:" + t16.f285887a + " groupPosition:" + i3 + " childPosition:" + i16);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("TroopDiscussionMemSelectAdapter", 2, "getChildView itemInfo data null" + i3 + " childPosition:" + i16);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view == null) {
            view = LayoutInflater.from(this.C).inflate(R.layout.e3z, viewGroup, false);
            aVar = new com.tencent.mobileqq.troop.adapter.contact.a();
            aVar.f293800d = (SingleLineTextView) view.findViewById(R.id.group_name);
            aVar.f293798b = (CheckBox) view.findViewById(R.id.dv_);
            aVar.f293802f = (SimpleTextView) view.findViewById(R.id.contact_count);
            aVar.f293799c = (ProgressBar) view.findViewById(R.id.f165958dx0);
            aVar.f293801e = (SingleLineTextView) view.findViewById(R.id.f167055ka1);
            view.setTag(aVar);
        } else {
            aVar = (com.tencent.mobileqq.troop.adapter.contact.a) view.getTag();
        }
        if (this.E.size() == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
            return view;
        }
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.K));
        C(aVar, i3, z16);
        view.setOnClickListener(this.Q);
        return view;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.e3z;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public boolean needHideBackgroundGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, expandableListView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        Object tag = view.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.adapter.contact.a) {
            E((com.tencent.mobileqq.troop.adapter.contact.a) tag);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.selectmember.TroopListBaseAdapter
    protected void s(List<TroopInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        Context context = this.C;
        if (context instanceof SelectMemberActivity) {
            int type = ((SelectMemberActivity) context).getType();
            boolean isInviteTroopMember = ((SelectMemberActivity) this.C).isInviteTroopMember();
            if (QLog.isColorLevel()) {
                QLog.i("TroopDiscussionMemSelectAdapter", 2, "[getAllTroopPrivilegeFlag] mType:" + type + ", isInviteTroopMember:" + isInviteTroopMember);
            }
            if (type == 0 || isInviteTroopMember) {
                ArrayList arrayList = new ArrayList();
                Iterator<TroopInfo> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().troopuin);
                }
                D(arrayList);
            }
        }
    }
}
