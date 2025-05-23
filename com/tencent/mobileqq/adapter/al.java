package com.tencent.mobileqq.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes10.dex */
public class al extends BaseExpandableListAdapter {
    static IPatchRedirector $redirector_;
    public static final String F;
    private int C;
    private int D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private Context f187118d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f187119e;

    /* renamed from: f, reason: collision with root package name */
    private List<TroopInfo> f187120f;

    /* renamed from: h, reason: collision with root package name */
    private SparseArray<List<TroopInfo>> f187121h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<Integer> f187122i;

    /* renamed from: m, reason: collision with root package name */
    private int f187123m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public QQProAvatarView f187124a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f187125b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f187126c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f187127d;

        protected a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f187129a;

        protected b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class c implements Comparator<TroopInfo> {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(TroopInfo troopInfo, TroopInfo troopInfo2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo, (Object) troopInfo2)).intValue();
            }
            long j3 = troopInfo.lastMsgTime;
            long j16 = troopInfo2.lastMsgTime;
            if (j3 > j16) {
                return -1;
            }
            if (j3 < j16) {
                return 1;
            }
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            int i3 = troopExtDBInfo.comparePartInt;
            String str = troopExtDBInfo.compareSpell;
            TroopExtDBInfo troopExtDBInfo2 = troopInfo2.extDBInfo;
            return com.tencent.mobileqq.app.j.a(i3, str, troopExtDBInfo2.comparePartInt, troopExtDBInfo2.compareSpell);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69558);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            F = UUID.randomUUID().toString();
        }
    }

    public al(Context context, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) qQAppInterface);
            return;
        }
        this.f187121h = new SparseArray<>();
        this.f187122i = new ArrayList<>();
        this.f187118d = context;
        this.f187119e = qQAppInterface;
        this.f187123m = context.getResources().getDimensionPixelSize(R.dimen.f158576jf);
        this.C = this.f187118d.getResources().getDimensionPixelSize(R.dimen.f158573jc);
        this.D = this.f187118d.getResources().getDimensionPixelSize(R.dimen.f158572jb);
        this.E = this.f187118d.getResources().getDimensionPixelSize(R.dimen.f158573jc);
        this.f187122i.add(Integer.valueOf(GroupMsgMask.NOTIFY.ordinal()));
        this.f187122i.add(Integer.valueOf(GroupMsgMask.RECEIVE.ordinal()));
        this.f187122i.add(Integer.valueOf(GroupMsgMask.ASSISTANT.ordinal()));
        this.f187122i.add(Integer.valueOf(GroupMsgMask.SHIELD.ordinal()));
        List<TroopInfo> joinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache();
        this.f187120f = joinedTroopInfoFromCache;
        a(joinedTroopInfoFromCache);
    }

    private void a(List<TroopInfo> list) {
        for (TroopInfo troopInfo : list) {
            int ordinal = troopInfo.troopmask.ordinal();
            if (ordinal == 0) {
                QLog.e("TroopMessageSettingAdapter", 1, "classifyGroupInfo: troopMask is 0");
            } else {
                if (this.f187121h.get(ordinal) == null) {
                    this.f187121h.put(ordinal, new ArrayList());
                }
                this.f187121h.get(ordinal).add(troopInfo);
            }
        }
        c cVar = new c();
        Iterator<Integer> it = this.f187122i.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (this.f187121h.get(intValue) != null) {
                List<TroopInfo> list2 = this.f187121h.get(intValue);
                Collections.sort(list2, cVar);
                this.f187121h.put(intValue, list2);
            }
        }
        Iterator<Integer> it5 = this.f187122i.iterator();
        while (it5.hasNext()) {
            int intValue2 = it5.next().intValue();
            if (this.f187121h.get(intValue2) == null) {
                TroopInfo troopInfo2 = new TroopInfo(F);
                troopInfo2.troopRemark = this.f187118d.getString(R.string.i6o);
                this.f187121h.put(intValue2, new ArrayList());
                this.f187121h.get(intValue2).add(troopInfo2);
            }
        }
    }

    private void d(View view, int i3, int i16) {
        int i17 = 2;
        if (QLog.isColorLevel()) {
            QLog.i("TroopMessageSettingAdapter", 2, "setItemBackground() childPos = " + i3 + ", listSize = " + i16);
        }
        if (i16 <= 1) {
            i17 = 0;
        } else if (i3 == 0) {
            i17 = 1;
        } else if (i3 == i16 - 1) {
            i17 = 3;
        }
        com.tencent.mobileqq.widget.o.m(view, i17, false);
    }

    @Override // android.widget.ExpandableListAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public TroopInfo getChild(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return this.f187121h.get(getGroup(i3).intValue()).get(i16);
    }

    @Override // android.widget.ExpandableListAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Integer getGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return this.f187122i.get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        return i16;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    @TargetApi(8)
    public int getChildType(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        TroopInfo child = getChild(i3, i16);
        if (child != null && F.equals(child.troopuin)) {
            return 1;
        }
        return 0;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        String troopDisplayName;
        a aVar;
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), view, viewGroup);
        }
        TroopInfo child = getChild(i3, i16);
        int childType = getChildType(i3, i16);
        if (TextUtils.isEmpty(child.getTroopDisplayName())) {
            troopDisplayName = child.troopuin;
        } else {
            troopDisplayName = child.getTroopDisplayName();
        }
        if (childType == 1) {
            if (view != null) {
                bVar = (b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f187118d).inflate(R.layout.byu, (ViewGroup) null);
                bVar = new b();
                bVar.f187129a = (TextView) view.findViewById(R.id.cyo);
                view.setTag(bVar);
            }
            bVar.f187129a.setText(troopDisplayName);
            com.tencent.mobileqq.widget.o.m(view, 0, false);
        } else {
            if (view != null) {
                aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f187118d).inflate(R.layout.byt, (ViewGroup) null);
                aVar = new a();
                aVar.f187124a = (QQProAvatarView) view.findViewById(R.id.cxk);
                aVar.f187125b = (TextView) view.findViewById(R.id.cyo);
                aVar.f187126c = (TextView) view.findViewById(R.id.cxv);
                aVar.f187127d = (ImageView) view.findViewById(R.id.i8d);
                view.setTag(aVar);
            }
            aVar.f187124a.x(4, child.troopuin, null);
            aVar.f187125b.setText(troopDisplayName);
            aVar.f187126c.setVisibility(0);
            d(view, i16, getChildrenCount(i3));
            aVar.f187127d.setVisibility(8);
        }
        view.setFocusable(true);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        List<TroopInfo> list = this.f187121h.get(getGroup(i3).intValue());
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f187122i.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3)).intValue();
        }
        return i3;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.f187122i.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view != null) {
            i16 = ((Integer) view.getTag()).intValue();
        } else {
            i16 = -1;
        }
        if (view == null || (i16 != -1 && i16 != getGroup(i3).intValue())) {
            int intValue = getGroup(i3).intValue();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        if (intValue == 4) {
                            i17 = R.layout.c19;
                        }
                    } else {
                        i17 = R.layout.c18;
                    }
                } else {
                    i17 = R.layout.c17;
                }
            } else {
                i17 = R.layout.c16;
            }
            view = LayoutInflater.from(viewGroup.getContext()).inflate(i17, (ViewGroup) null);
        }
        view.setFocusable(true);
        view.setTag(getGroup(i3));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
    }

    @Override // android.widget.BaseExpandableListAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f187121h.clear();
        List<TroopInfo> joinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache();
        this.f187120f = joinedTroopInfoFromCache;
        a(joinedTroopInfoFromCache);
        super.notifyDataSetChanged();
    }
}
