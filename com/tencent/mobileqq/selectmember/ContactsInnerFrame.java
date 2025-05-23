package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ContactsInnerFrame extends SelectMemberInnerFrame implements View.OnClickListener, IndexView.b, PinnedDividerListView.b {
    static IPatchRedirector $redirector_;
    private IPhoneContactService D;
    private com.tencent.mobileqq.phonecontact.observer.b E;
    private c F;
    PinnedDividerListView G;
    private IndexView H;
    List<PhoneContact> I;
    private MqqHandler J;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends MqqHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsInnerFrame.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 3) {
                ContactsInnerFrame.this.y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsInnerFrame.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onQueryBindState(boolean z16, boolean z17, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
                return;
            }
            ContactsInnerFrame.this.f285784m.unRegistObserver(this);
            int selfBindState = ContactsInnerFrame.this.D.getSelfBindState();
            if (selfBindState != 0) {
                if (selfBindState == 1 || selfBindState == 5) {
                    ContactsInnerFrame.this.v();
                    return;
                }
                if (selfBindState != 6) {
                    if (selfBindState != 7 && selfBindState != 9) {
                        ContactsInnerFrame.this.x();
                        return;
                    }
                } else if (ContactsInnerFrame.this.D.getSelfBindInfo().lastUsedFlag == 2) {
                    ContactsInnerFrame.this.y();
                    return;
                } else {
                    ContactsInnerFrame.this.v();
                    return;
                }
            }
            ContactsInnerFrame.this.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends com.tencent.mobileqq.adapter.e {
        static IPatchRedirector $redirector_;
        private LinkedHashMap<String, List<PhoneContact>> D;
        private int[] E;
        private String[] F;

        public c(Context context, AppInterface appInterface, XListView xListView, boolean z16) {
            super(context, appInterface, xListView, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ContactsInnerFrame.this, context, appInterface, xListView, Boolean.valueOf(z16));
                return;
            }
            this.D = new LinkedHashMap<>();
            this.E = new int[0];
            this.F = new String[0];
        }

        @SuppressLint({"DefaultLocale"})
        private void g() {
            char c16;
            int i3;
            String str;
            this.D.clear();
            List<PhoneContact> list = ContactsInnerFrame.this.I;
            if (list == null) {
                return;
            }
            Iterator<PhoneContact> it = list.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                i3 = 0;
                String str2 = "#";
                if (!hasNext) {
                    break;
                }
                PhoneContact next = it.next();
                String str3 = next.pinyinFirst;
                if (str3 == null || str3.length() == 0) {
                    str = "#";
                } else {
                    str = next.pinyinFirst.substring(0, 1);
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
            LinkedHashMap<String, List<PhoneContact>> linkedHashMap = this.D;
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
            PhoneContact phoneContact;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                int binarySearch = Arrays.binarySearch(this.E, i3);
                if (view == null) {
                    view = com.tencent.mobileqq.selectmember.c.a(viewGroup, ContactsInnerFrame.this.C, R.layout.byd);
                }
                com.tencent.mobileqq.selectmember.c cVar = (com.tencent.mobileqq.selectmember.c) view.getTag();
                if (binarySearch < 0) {
                    int i16 = (-(binarySearch + 1)) - 1;
                    List<PhoneContact> list = this.D.get(this.F[i16]);
                    int i17 = (i3 - this.E[i16]) - 1;
                    PhoneContact phoneContact2 = list.get(i17);
                    com.tencent.mobileqq.selectmember.c.b(this, cVar, phoneContact2);
                    int i18 = i17 - 1;
                    PhoneContact phoneContact3 = null;
                    if (i18 < 0) {
                        phoneContact = null;
                    } else {
                        phoneContact = list.get(i18);
                    }
                    int i19 = i17 + 1;
                    if (i19 <= list.size() - 1) {
                        phoneContact3 = list.get(i19);
                    }
                    if ((phoneContact != null && phoneContact.contactID == phoneContact2.contactID) || (phoneContact3 != null && phoneContact3.contactID == phoneContact2.contactID)) {
                        cVar.I.setVisibility(0);
                        cVar.I.setText(phoneContact2.mobileNo);
                    } else {
                        cVar.I.setVisibility(8);
                    }
                    cVar.C.setText(phoneContact2.name);
                    if (ContactsInnerFrame.this.f285782h.isResultListContainFriend(cVar.f187210d)) {
                        cVar.E.setChecked(true);
                    } else {
                        cVar.E.setChecked(false);
                    }
                    ArrayList<String> arrayList = ContactsInnerFrame.this.f285782h.mUinsSelectedDefault;
                    if (arrayList != null && arrayList.contains(phoneContact2.uin)) {
                        cVar.E.setEnabled(false);
                    } else {
                        cVar.E.setEnabled(true);
                    }
                    if (AppSetting.f99565y && cVar.E.isEnabled()) {
                        if (cVar.E.isChecked()) {
                            view.setContentDescription(phoneContact2.name + HardCodeUtil.qqStr(R.string.l3i));
                        } else {
                            view.setContentDescription(phoneContact2.name + HardCodeUtil.qqStr(R.string.l2r));
                        }
                    }
                    cVar.F = phoneContact2;
                    view.setOnClickListener(ContactsInnerFrame.this);
                } else {
                    cVar.f297804i.setVisibility(8);
                    cVar.f297805m.setVisibility(0);
                    String valueOf = String.valueOf(this.F[binarySearch]);
                    cVar.f297805m.setText(valueOf);
                    cVar.f297805m.setContentDescription(String.format(ContactsInnerFrame.this.f285782h.getString(R.string.aud), valueOf.toLowerCase()));
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

    public ContactsInnerFrame(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.J = new a();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void w() {
        this.G = (PinnedDividerListView) findViewById(R.id.atu);
        IndexView indexView = (IndexView) findViewById(R.id.djh);
        this.H = indexView;
        indexView.setIndex(new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
        this.H.setOnIndexChangedListener(this);
        this.G.setSelector(R.color.ajr);
        this.G.setOnLayoutListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.D == null) {
            this.D = (IPhoneContactService) this.f285784m.getRuntimeService(IPhoneContactService.class, "");
        }
        if (this.E == null) {
            this.E = new b();
        }
        this.f285784m.registObserver(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        List<PhoneContact> contactListForSelector = this.D.getContactListForSelector();
        this.I = contactListForSelector;
        if (contactListForSelector == null) {
            this.J.removeMessages(3);
            this.J.sendEmptyMessageDelayed(3, 1000L);
            return;
        }
        if (this.F == null) {
            c cVar = new c(this.f285782h, this.f285784m, this.G, false);
            this.F = cVar;
            this.G.setAdapter((ListAdapter) cVar);
        }
        this.F.i();
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
        this.D = (IPhoneContactService) this.f285784m.getRuntimeService(IPhoneContactService.class, "");
        this.f285784m.setHandler(ContactsInnerFrame.class, this.J);
        w();
        c cVar = new c(this.f285782h, this.f285784m, this.G, false);
        this.F = cVar;
        this.G.setAdapter((ListAdapter) cVar);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.l();
        }
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.m(bundle);
        SelectMemberActivity selectMemberActivity = this.f285782h;
        selectMemberActivity.setupTitleBar(true, selectMemberActivity.getString(R.string.hdd), this.f285782h.getString(R.string.csf));
        int selfBindState = this.D.getSelfBindState();
        if (selfBindState != 0) {
            if (selfBindState != 1 && selfBindState != 5) {
                if (selfBindState != 6) {
                    if (selfBindState != 7 && selfBindState != 9) {
                        x();
                        return;
                    }
                } else if (this.D.getSelfBindInfo().lastUsedFlag == 2) {
                    y();
                    return;
                } else {
                    v();
                    return;
                }
            } else {
                v();
                return;
            }
        }
        y();
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public com.tencent.mobileqq.search.view.f n(boolean z16, com.tencent.mobileqq.search.k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.search.view.f) iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), kVar);
        }
        ISearchViewCreator iSearchViewCreator = (ISearchViewCreator) QRoute.api(ISearchViewCreator.class);
        SelectMemberActivity selectMemberActivity = this.f285782h;
        return iSearchViewCreator.createContactSearchFragment(-1, 768, null, selectMemberActivity.mUinsToHide, selectMemberActivity, z16, kVar);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "-1";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CheckBox checkBox;
        PhoneContact phoneContact;
        boolean onListViewItemClick;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else {
            com.tencent.mobileqq.selectmember.c cVar = (com.tencent.mobileqq.selectmember.c) view.getTag();
            if (cVar != null && (checkBox = cVar.E) != null && (phoneContact = cVar.F) != null && checkBox.isEnabled()) {
                int i3 = 0;
                if (cVar.H) {
                    onListViewItemClick = this.f285782h.onListViewItemClick(cVar.f187210d, phoneContact.name, 5, "-1");
                } else if (cVar.f187210d.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                    onListViewItemClick = this.f285782h.onListViewItemClick(cVar.f187210d, phoneContact.name, 4, "-1");
                } else {
                    onListViewItemClick = this.f285782h.onListViewItemClick(cVar.f187210d, phoneContact.name, 0, "-1");
                }
                cVar.E.setChecked(onListViewItemClick);
                if (AppSetting.f99565y) {
                    if (cVar.E.isChecked()) {
                        if (cVar.H) {
                            view.setContentDescription(((Object) cVar.C.getText()) + this.f285782h.getString(R.string.hdh));
                        } else {
                            view.setContentDescription(cVar.C.getText().toString() + HardCodeUtil.qqStr(R.string.l37));
                        }
                    } else {
                        if (cVar.H) {
                            i3 = this.f285782h.getCheckPhoneNumberResId(cVar.f187210d);
                        }
                        if (cVar.H && i3 != 0) {
                            view.setContentDescription(((Object) cVar.C.getText()) + this.f285782h.getString(i3));
                        } else {
                            view.setContentDescription(cVar.C.getText().toString() + HardCodeUtil.qqStr(R.string.f171803l31));
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        this.J.removeMessages(3);
        this.f285784m.removeHandler(ContactsInnerFrame.class);
        c cVar = this.F;
        if (cVar != null) {
            cVar.destroy();
        }
        this.f285784m.unRegistObserver(this.E);
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if ("$".equals(str)) {
            this.G.setSelection(0);
            return;
        }
        int h16 = this.F.h(str);
        if (h16 != -1) {
            PinnedDividerListView pinnedDividerListView = this.G;
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
        if ((this.G.getFirstVisiblePosition() > 0 || (this.G.getFirstVisiblePosition() == 0 && this.G.getChildCount() < this.F.getCount() + this.G.getHeaderViewsCount())) && !this.f285782h.isSoftInputShowing()) {
            this.H.setVisibility(0);
            this.J.sendEmptyMessage(1);
        } else {
            this.H.setVisibility(4);
            this.J.sendEmptyMessage(2);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.F.notifyDataSetChanged();
        }
    }

    public ContactsInnerFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.J = new a();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public ContactsInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.J = new a();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
    }
}
