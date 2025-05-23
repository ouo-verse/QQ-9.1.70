package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.slf4j.Marker;

/* loaded from: classes18.dex */
public class PhoneContactTabView extends TroopDiscussionBaseV implements View.OnClickListener, View.OnTouchListener, IndexView.b, PinnedDividerListView.b {
    static IPatchRedirector $redirector_;
    private com.tencent.mobileqq.phonecontact.observer.b C;
    private c D;
    PinnedDividerListView E;
    private IndexView F;
    List<PhoneContact> G;
    private String H;
    ContactFriendInnerFrame I;
    private MqqHandler J;

    /* renamed from: m, reason: collision with root package name */
    private IPhoneContactService f285688m;

    /* loaded from: classes18.dex */
    class a extends MqqHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactTabView.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 3) {
                PhoneContactTabView.this.p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactTabView.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onQueryBindState(boolean z16, boolean z17, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
                return;
            }
            PhoneContactTabView.this.f285850f.unRegistObserver(this);
            int selfBindState = PhoneContactTabView.this.f285688m.getSelfBindState();
            if (selfBindState != 0 && selfBindState != 1 && selfBindState != 5) {
                if (selfBindState != 6) {
                    if (selfBindState != 7) {
                        if (selfBindState != 9) {
                            PhoneContactTabView.this.n();
                            return;
                        } else {
                            PhoneContactTabView.this.p();
                            return;
                        }
                    }
                } else if (PhoneContactTabView.this.f285688m.getSelfBindInfo().lastUsedFlag != 2) {
                    PhoneContactTabView.this.k();
                    return;
                } else {
                    PhoneContactTabView.this.p();
                    return;
                }
            }
            PhoneContactTabView.this.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class c extends com.tencent.mobileqq.adapter.e {
        static IPatchRedirector $redirector_;
        private LinkedHashMap<String, List<PhoneContact>> D;
        private int[] E;
        private String[] F;
        View.OnClickListener G;

        /* loaded from: classes18.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.tencent.mobileqq.selectmember.c cVar;
                CheckBox checkBox;
                PhoneContact phoneContact;
                boolean onListViewItemClick;
                int i3;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (view.getId() != R.id.bll && (cVar = (com.tencent.mobileqq.selectmember.c) view.getTag()) != null && (checkBox = cVar.E) != null && (phoneContact = cVar.F) != null && checkBox.isEnabled()) {
                    if (cVar.f187210d.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                        onListViewItemClick = PhoneContactTabView.this.f285848d.onListViewItemClick(cVar.f187210d, phoneContact.name, 4, "-1", phoneContact.mobileNo);
                    } else {
                        onListViewItemClick = PhoneContactTabView.this.f285848d.onListViewItemClick(cVar.f187210d, phoneContact.name, 0, "-1", phoneContact.mobileNo);
                    }
                    cVar.E.setChecked(onListViewItemClick);
                    if (AppSetting.f99565y) {
                        if (cVar.E.isChecked()) {
                            if (cVar.H) {
                                view.setContentDescription(((Object) cVar.C.getText()) + PhoneContactTabView.this.f285848d.getString(R.string.hdh));
                            } else {
                                view.setContentDescription(cVar.C.getText().toString() + HardCodeUtil.qqStr(R.string.p2j));
                            }
                        } else {
                            if (cVar.H) {
                                i3 = PhoneContactTabView.this.f285848d.getCheckPhoneNumberResId(cVar.f187210d);
                            } else {
                                i3 = 0;
                            }
                            if (cVar.H && i3 != 0) {
                                view.setContentDescription(((Object) cVar.C.getText()) + PhoneContactTabView.this.f285848d.getString(i3));
                            } else {
                                view.setContentDescription(cVar.C.getText().toString() + HardCodeUtil.qqStr(R.string.p2g));
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public c(Context context, AppInterface appInterface, XListView xListView, boolean z16) {
            super(context, appInterface, xListView, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PhoneContactTabView.this, context, appInterface, xListView, Boolean.valueOf(z16));
                return;
            }
            this.D = new LinkedHashMap<>();
            this.E = new int[0];
            this.F = new String[0];
            this.G = new a();
        }

        @SuppressLint({"DefaultLocale"})
        private void g() {
            char c16;
            int i3;
            String substring;
            this.D.clear();
            List<PhoneContact> list = PhoneContactTabView.this.G;
            if (list == null) {
                return;
            }
            Iterator<PhoneContact> it = list.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                String str = "#";
                i3 = 0;
                if (!hasNext) {
                    break;
                }
                PhoneContact next = it.next();
                if (TextUtils.isEmpty(next.pinyinFirst)) {
                    substring = "#";
                } else {
                    substring = next.pinyinFirst.substring(0, 1);
                }
                char charAt = substring.charAt(0);
                if (('A' <= charAt && charAt <= 'Z') || ('a' <= charAt && charAt <= 'z')) {
                    str = substring.toUpperCase();
                }
                if (this.D.get(str) == null) {
                    this.D.put(str, new ArrayList());
                }
                this.D.get(str).add(next);
            }
            LinkedHashMap<String, List<PhoneContact>> linkedHashMap = this.D;
            this.D = new LinkedHashMap<>();
            List<PhoneContact> list2 = linkedHashMap.get("@");
            if (list2 != null) {
                this.D.put(PhoneContactTabView.this.H, list2);
            }
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
            this.E = iArr;
            this.F = new String[iArr.length];
            Iterator<String> it5 = this.D.keySet().iterator();
            int[] iArr2 = this.E;
            if (iArr2.length == 0) {
                return;
            }
            iArr2[0] = 0;
            int i16 = 1;
            while (true) {
                int[] iArr3 = this.E;
                if (i16 >= iArr3.length) {
                    break;
                }
                iArr3[i16] = iArr3[i16] + iArr3[i16 - 1] + this.D.get(it5.next()).size() + 1;
                i16++;
            }
            Iterator<String> it6 = this.D.keySet().iterator();
            while (it6.hasNext()) {
                this.F[i3] = it6.next();
                i3++;
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, i3);
            } else {
                Arrays.binarySearch(this.E, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.adapter.e
        public boolean f(k kVar) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) kVar)).booleanValue();
            }
            boolean f16 = super.f(kVar);
            if (kVar instanceof com.tencent.mobileqq.selectmember.c) {
                com.tencent.mobileqq.selectmember.c cVar = (com.tencent.mobileqq.selectmember.c) kVar;
                if (f16 && !cVar.H) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return z16;
            }
            return f16;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            int[] iArr = this.E;
            if (iArr.length == 0) {
                return 0;
            }
            return iArr[iArr.length - 1] + this.D.get(this.F[r2.length - 1]).size() + 1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            if (this.F.length > 0) {
                return R.layout.f168254qf;
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            int binarySearch = Arrays.binarySearch(this.E, i3);
            if (binarySearch >= 0) {
                return null;
            }
            return this.D.get(this.F[(-(binarySearch + 1)) - 1]).get((i3 - this.E[r0]) - 1);
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
                int binarySearch = Arrays.binarySearch(this.E, i3);
                if (view == null) {
                    view = com.tencent.mobileqq.selectmember.c.a(viewGroup, PhoneContactTabView.this.f285852i, R.layout.i_);
                }
                com.tencent.mobileqq.selectmember.c cVar = (com.tencent.mobileqq.selectmember.c) view.getTag();
                if (binarySearch < 0) {
                    int i16 = (-(binarySearch + 1)) - 1;
                    PhoneContact phoneContact = this.D.get(this.F[i16]).get((i3 - this.E[i16]) - 1);
                    com.tencent.mobileqq.selectmember.c.b(this, cVar, phoneContact);
                    cVar.C.setText(phoneContact.name);
                    cVar.I.setText(phoneContact.mobileNo);
                    cVar.I.setVisibility(0);
                    if (PhoneContactTabView.this.f285848d.isResultListContainFriend(cVar.f187210d)) {
                        cVar.E.setChecked(true);
                    } else {
                        cVar.E.setChecked(false);
                    }
                    cVar.E.setEnabled(true);
                    if (AppSetting.f99565y && cVar.E.isEnabled()) {
                        if (cVar.E.isChecked()) {
                            view.setContentDescription(phoneContact.name + HardCodeUtil.qqStr(R.string.p2f));
                        } else {
                            view.setContentDescription(phoneContact.name + HardCodeUtil.qqStr(R.string.p2d));
                        }
                    }
                    cVar.F = phoneContact;
                    cVar.J.setVisibility(8);
                    cVar.J.setOnClickListener(this.G);
                    view.setOnClickListener(this.G);
                } else {
                    cVar.f297804i.setVisibility(8);
                    cVar.f297805m.setVisibility(0);
                    String valueOf = String.valueOf(this.F[binarySearch]);
                    cVar.f297805m.setText(valueOf);
                    cVar.f297805m.setContentDescription(String.format(PhoneContactTabView.this.f285848d.getString(R.string.aud), valueOf.toLowerCase()));
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        public int h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).intValue();
            }
            if (this.F != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = this.F;
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
                    return this.E[i3];
                }
            }
            return -1;
        }

        public void i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            } else {
                g();
                super.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
            }
            if (Arrays.binarySearch(this.E, i3) >= 0) {
                return true;
            }
            return false;
        }
    }

    public PhoneContactTabView(SelectMemberActivity selectMemberActivity, ContactFriendInnerFrame contactFriendInnerFrame) {
        super(selectMemberActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) selectMemberActivity, (Object) contactFriendInnerFrame);
        } else {
            this.J = new a();
            this.I = contactFriendInnerFrame;
        }
    }

    private void l() {
        this.E = (PinnedDividerListView) findViewById(R.id.atu);
        IndexView indexView = (IndexView) findViewById(R.id.djh);
        this.F = indexView;
        indexView.setIndex(new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
        this.F.setOnIndexChangedListener(this);
        this.E.setSelector(R.color.ajr);
        this.E.setOnLayoutListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f285688m == null) {
            this.f285688m = (IPhoneContactService) this.f285850f.getRuntimeService(IPhoneContactService.class, "");
        }
        if (this.C == null) {
            this.C = new b();
        }
        this.f285850f.registObserver(this.C);
    }

    private void o() {
        this.E.setVisibility(8);
        this.F.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void b(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        f(R.layout.f169084by4);
        this.f285688m = (IPhoneContactService) this.f285850f.getRuntimeService(IPhoneContactService.class, "");
        this.f285850f.setHandler(PhoneContactTabView.class, this.J);
        l();
        c cVar = new c(this.f285848d, this.f285850f, this.E, false);
        this.D = cVar;
        this.E.setAdapter((ListAdapter) cVar);
        SelectMemberActivity selectMemberActivity = this.f285848d;
        selectMemberActivity.setupTitleBar(false, selectMemberActivity.getString(R.string.f173096hd0), this.f285848d.mTitleString);
        int selfBindState = this.f285688m.getSelfBindState();
        if (QLog.isColorLevel()) {
            QLog.i("ContactsInnerFrame", 2, "onStart state:" + selfBindState);
        }
        if (selfBindState != 0 && selfBindState != 1 && selfBindState != 5) {
            if (selfBindState != 6) {
                if (selfBindState != 7) {
                    if (selfBindState != 9) {
                        n();
                        return;
                    } else {
                        p();
                        return;
                    }
                }
            } else if (this.f285688m.getSelfBindInfo().lastUsedFlag == 2) {
                p();
                return;
            } else {
                o();
                return;
            }
        }
        o();
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.D.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            view.getId();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroy();
        this.J.removeMessages(3);
        this.f285850f.removeHandler(PhoneContactTabView.class);
        c cVar = this.D;
        if (cVar != null) {
            cVar.destroy();
        }
        this.f285850f.unRegistObserver(this.C);
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if ("$".equals(str)) {
            this.E.setSelection(0);
            return;
        }
        int h16 = this.D.h(str);
        if (h16 != -1) {
            PinnedDividerListView pinnedDividerListView = this.E;
            pinnedDividerListView.setSelection(h16 + pinnedDividerListView.getHeaderViewsCount());
        }
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.b
    public void onLayout(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if ((this.E.getFirstVisiblePosition() > 0 || (this.E.getFirstVisiblePosition() == 0 && this.E.getChildCount() < this.D.getCount() + this.E.getHeaderViewsCount())) && !this.f285848d.isSoftInputShowing()) {
            this.F.setVisibility(0);
            this.J.sendEmptyMessage(1);
        } else {
            this.F.setVisibility(4);
            this.J.sendEmptyMessage(2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        motionEvent.getAction();
        return true;
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        List<PhoneContact> contactListForPhoneSelector = this.f285688m.getContactListForPhoneSelector();
        this.G = contactListForPhoneSelector;
        if (contactListForPhoneSelector == null) {
            this.J.removeMessages(3);
            this.J.sendEmptyMessageDelayed(3, 1000L);
        } else {
            if (this.D == null) {
                c cVar = new c(this.f285848d, this.f285850f, this.E, false);
                this.D = cVar;
                this.E.setAdapter((ListAdapter) cVar);
            }
            this.D.i();
        }
        this.E.setVisibility(0);
        this.F.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
    }
}
