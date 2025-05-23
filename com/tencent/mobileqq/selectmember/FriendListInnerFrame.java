package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FriendListInnerFrame extends SelectMemberInnerFrame implements View.OnClickListener, IndexView.b, PinnedDividerListView.b {
    static IPatchRedirector $redirector_;
    List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> D;
    PinnedDividerListView E;
    private d F;
    private IndexView G;
    private int H;
    private int I;
    private String J;
    private EditText K;
    RelativeLayout L;
    private hx3.b M;
    private Handler N;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements hx3.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendListInnerFrame.this);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            String currentAccountUin = FriendListInnerFrame.this.f285784m.getCurrentAccountUin();
            if (!FriendListInnerFrame.this.y(eVar.b(), currentAccountUin)) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d();
                dVar.w0(currentAccountUin);
                dVar.k0(FriendListInnerFrame.this.f285784m.getCurrentNickname());
                dVar.f0(ChnToSpell.d(FriendListInnerFrame.z(dVar), 1));
                FriendListInnerFrame.this.D.add(dVar);
                FriendListInnerFrame.this.C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendListInnerFrame.this);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                FriendListInnerFrame.this.x(eVar.b().get(0).b());
            } else {
                QLog.i("FriendListInnerFrame", 1, "IFriendsInfoService.getCategoryInfoWithCategoryId erro");
                FriendListInnerFrame.this.C();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c extends Handler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendListInnerFrame.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    FriendListInnerFrame.this.L.setPadding(0, 0, 0, 0);
                    return;
                }
                return;
            }
            FriendListInnerFrame.this.L.setPadding(0, 0, 40, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d extends com.tencent.mobileqq.adapter.e {
        static IPatchRedirector $redirector_;
        private LinkedHashMap<String, List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>> D;
        private String[] E;
        private int[] F;

        public d() {
            super(FriendListInnerFrame.this.f285782h, FriendListInnerFrame.this.f285784m, FriendListInnerFrame.this.E, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendListInnerFrame.this);
                return;
            }
            this.D = new LinkedHashMap<>();
            this.E = new String[0];
            this.F = new int[0];
            g();
        }

        @SuppressLint({"DefaultLocale"})
        private void g() {
            char c16;
            int i3;
            String str;
            this.D.clear();
            Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it = FriendListInnerFrame.this.D.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                i3 = 0;
                String str2 = "#";
                if (!hasNext) {
                    break;
                }
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d next = it.next();
                if (next.k() == null || next.k().length() == 0) {
                    str = "#";
                } else {
                    str = next.k().substring(0, 1);
                }
                char charAt = str.charAt(0);
                if (('A' <= charAt && charAt <= 'Z') || ('a' <= charAt && charAt <= 'z')) {
                    str2 = str.toUpperCase();
                }
                if (this.D.get(str2) == null) {
                    this.D.put(str2, new ArrayList());
                }
                this.D.get(str2).add(next);
            }
            LinkedHashMap<String, List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>> linkedHashMap = this.D;
            this.D = new LinkedHashMap<>();
            for (c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c16 <= 'Z'; c16 = (char) (c16 + 1)) {
                if (linkedHashMap.get(String.valueOf(c16)) != null) {
                    this.D.put(String.valueOf(c16), linkedHashMap.get(String.valueOf(c16)));
                }
            }
            if (linkedHashMap.get("#") != null) {
                this.D.put("#", linkedHashMap.get("#"));
            }
            linkedHashMap.clear();
            int[] iArr = new int[this.D.keySet().size()];
            this.F = iArr;
            this.E = new String[iArr.length];
            Iterator<String> it5 = this.D.keySet().iterator();
            int[] iArr2 = this.F;
            if (iArr2.length == 0) {
                return;
            }
            iArr2[0] = 0;
            int i16 = 1;
            while (true) {
                int[] iArr3 = this.F;
                if (i16 >= iArr3.length) {
                    break;
                }
                iArr3[i16] = iArr3[i16] + iArr3[i16 - 1] + this.D.get(it5.next()).size() + 1;
                i16++;
            }
            Iterator<String> it6 = this.D.keySet().iterator();
            while (it6.hasNext()) {
                this.E[i3] = it6.next();
                i3++;
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, i3);
                return;
            }
            int binarySearch = Arrays.binarySearch(this.F, i3);
            if (binarySearch < 0) {
                binarySearch = (-(binarySearch + 1)) - 1;
            }
            ((TextView) view).setText(this.E[binarySearch]);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            int[] iArr = this.F;
            if (iArr.length == 0) {
                return 0;
            }
            return iArr[iArr.length - 1] + this.D.get(this.E[r2.length - 1]).size() + 1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return R.layout.f168254qf;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            int binarySearch = Arrays.binarySearch(this.F, i3);
            if (binarySearch >= 0) {
                return null;
            }
            int i16 = (-(binarySearch + 1)) - 1;
            List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list = this.D.get(this.E[i16]);
            int i17 = (i3 - this.F[i16]) - 1;
            if (i17 < 0 || i17 >= list.size()) {
                return null;
            }
            return list.get(i17);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                int binarySearch = Arrays.binarySearch(this.F, i3);
                if (view == null) {
                    view = FriendListInnerFrame.this.C.inflate(R.layout.byd, viewGroup, false);
                    e eVar = new e(FriendListInnerFrame.this, null);
                    view.setTag(eVar);
                    eVar.f297804i = (RelativeLayout) view.findViewById(R.id.icx);
                    eVar.f297805m = (TextView) view.findViewById(R.id.k8u);
                    eVar.E = (CheckBox) view.findViewById(R.id.axa);
                    eVar.f187212f = (ImageView) view.findViewById(R.id.icon);
                    eVar.C = (TextView) view.findViewById(R.id.f5e);
                }
                e eVar2 = (e) view.getTag();
                if (binarySearch < 0) {
                    int i16 = (-(binarySearch + 1)) - 1;
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = this.D.get(this.E[i16]).get((i3 - this.F[i16]) - 1);
                    if (FriendListInnerFrame.this.f285782h.isResultListContainFriend(dVar.x())) {
                        eVar2.E.setChecked(true);
                    } else {
                        eVar2.E.setChecked(false);
                    }
                    eVar2.f297804i.setVisibility(0);
                    eVar2.f297805m.setVisibility(8);
                    eVar2.f187212f.setImageBitmap(b(dVar.x()));
                    eVar2.C.setText(dVar.m());
                    eVar2.f187210d = dVar.x();
                    ArrayList<String> arrayList = FriendListInnerFrame.this.f285782h.mUinsSelectedDefault;
                    if (arrayList != null && arrayList.contains(dVar.x())) {
                        eVar2.E.setEnabled(false);
                    } else {
                        eVar2.E.setEnabled(true);
                    }
                    if (AppSetting.f99565y && eVar2.E.isEnabled()) {
                        if (eVar2.E.isChecked()) {
                            view.setContentDescription(dVar.m() + HardCodeUtil.qqStr(R.string.f172021ms4));
                        } else {
                            view.setContentDescription(dVar.m() + HardCodeUtil.qqStr(R.string.ms7));
                        }
                    }
                    view.setOnClickListener(FriendListInnerFrame.this);
                } else {
                    eVar2.f297804i.setVisibility(8);
                    eVar2.f297805m.setVisibility(0);
                    String valueOf = String.valueOf(this.E[binarySearch]);
                    eVar2.f297805m.setText(valueOf);
                    eVar2.f297805m.setContentDescription(String.format(FriendListInnerFrame.this.f285782h.getString(R.string.aud), valueOf.toLowerCase()));
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        public int h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).intValue();
            }
            if (this.E != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = this.E;
                    if (i3 < strArr.length) {
                        if (strArr[i3].equals(str)) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 >= 0) {
                    return this.F[i3];
                }
            }
            return -1;
        }

        public void i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this);
            } else {
                g();
                super.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
            }
            if (Arrays.binarySearch(this.F, i3) >= 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class e extends com.tencent.mobileqq.troop.memberlist.b {
        static IPatchRedirector $redirector_;
        public CheckBox E;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendListInnerFrame.this);
        }

        /* synthetic */ e(FriendListInnerFrame friendListInnerFrame, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) friendListInnerFrame, (Object) aVar);
        }
    }

    public FriendListInnerFrame(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = new ArrayList();
        this.H = Integer.MIN_VALUE;
        this.M = new a();
        this.N = new c();
    }

    private void A() {
        this.D.clear();
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(this.I, "FriendListInnerFrame", new b());
    }

    private void B() {
        this.E = (PinnedDividerListView) findViewById(R.id.atu);
        IndexView indexView = (IndexView) findViewById(R.id.djh);
        this.G = indexView;
        indexView.setIndex(new String[]{"$", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
        this.G.setOnIndexChangedListener(this);
        this.E.setSelector(R.color.ajr);
        this.E.setOnLayoutListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.f285782h.getLayoutInflater().inflate(R.layout.search_box, (ViewGroup) this.E, false);
        this.L = relativeLayout;
        this.K = (EditText) relativeLayout.findViewById(R.id.et_search_keyword);
        ((Button) this.L.findViewById(R.id.btn_cancel_search)).setVisibility(8);
        this.E.addHeaderView(this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.F.i();
        this.E.setSelection(0);
        this.H = this.I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.selectmember.FriendListInnerFrame.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ArrayList f285659d;

            {
                this.f285659d = arrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendListInnerFrame.this, (Object) arrayList);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String currentAccountUin = FriendListInnerFrame.this.f285784m.getCurrentAccountUin();
                ArrayList arrayList2 = this.f285659d;
                if (arrayList2 != null) {
                    arrayList2.add(null);
                    Iterator it = this.f285659d.iterator();
                    while (it.hasNext()) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) it.next();
                        if (dVar != null && (FriendListInnerFrame.this.f285782h.mShowMyself || !dVar.x().equals(currentAccountUin))) {
                            if (!FriendListInnerFrame.this.f285782h.mUinsToHide.contains(dVar.x())) {
                                FriendListInnerFrame.this.D.add(dVar);
                            }
                        }
                    }
                }
                FriendListInnerFrame friendListInnerFrame = FriendListInnerFrame.this;
                if (!friendListInnerFrame.f285782h.mShowMyself || friendListInnerFrame.I != 0) {
                    FriendListInnerFrame.this.C();
                } else {
                    ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryInfo(false, "FriendListInnerFrame", false, FriendListInnerFrame.this.M);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y(ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList, String str) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b next = it.next();
                if (next.b().size() > 0) {
                    Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it5 = next.b().iterator();
                    while (it5.hasNext()) {
                        if (it5.next().x().equals(str)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String z(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        return dVar.m() + "-" + dVar.x();
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame, com.tencent.common.app.InnerFrame
    public void j(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.j(bundle);
        setContentView(R.layout.f169084by4);
        B();
        d dVar = new d();
        this.F = dVar;
        this.E.setAdapter((ListAdapter) dVar);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.m(bundle);
        this.I = bundle.getInt("friend_team_id");
        this.J = bundle.getString("group_name");
        SelectMemberActivity selectMemberActivity = this.f285782h;
        selectMemberActivity.setupTitleBar(true, selectMemberActivity.getString(R.string.hdd), this.J);
        if (this.I != this.H) {
            A();
            return;
        }
        d dVar = this.F;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public com.tencent.mobileqq.search.view.f n(boolean z16, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.search.view.f) iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), kVar);
        }
        return ((SelectMemberInnerFrame) this.f285783i.getChildAt(1)).n(z16, kVar);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "-1";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CheckBox checkBox;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            e eVar = (e) view.getTag();
            if (eVar != null && (checkBox = eVar.E) != null && eVar.C != null && checkBox.isEnabled()) {
                eVar.E.setChecked(this.f285782h.onListViewItemClick(eVar.f187210d, eVar.C.getText().toString(), 0, "-1"));
                if (AppSetting.f99565y) {
                    if (eVar.E.isChecked()) {
                        view.setContentDescription(eVar.C.getText().toString() + HardCodeUtil.qqStr(R.string.ms5));
                    } else {
                        view.setContentDescription(eVar.C.getText().toString() + HardCodeUtil.qqStr(R.string.ms8));
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        d dVar = this.F;
        if (dVar != null) {
            dVar.destroy();
        }
        this.M = null;
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if ("$".equals(str)) {
            this.E.setSelection(0);
            return;
        }
        int h16 = this.F.h(str);
        if (h16 != -1) {
            PinnedDividerListView pinnedDividerListView = this.E;
            pinnedDividerListView.setSelection(h16 + pinnedDividerListView.getHeaderViewsCount());
        }
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.b
    public void onLayout(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if ((this.E.getFirstVisiblePosition() > 0 || (this.E.getFirstVisiblePosition() == 0 && this.E.getChildCount() < this.F.getCount() + this.E.getHeaderViewsCount())) && !this.f285782h.isSoftInputShowing()) {
            this.G.setVisibility(0);
            this.N.sendEmptyMessage(1);
        } else {
            this.G.setVisibility(4);
            this.N.sendEmptyMessage(2);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.F.notifyDataSetChanged();
        }
    }

    public FriendListInnerFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.D = new ArrayList();
        this.H = Integer.MIN_VALUE;
        this.M = new a();
        this.N = new c();
    }

    public FriendListInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = new ArrayList();
        this.H = Integer.MIN_VALUE;
        this.M = new a();
        this.N = new c();
    }
}
