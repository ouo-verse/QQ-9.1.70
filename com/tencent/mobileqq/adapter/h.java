package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h extends e implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private List<PhoneContact> D;
    private Context E;
    private QQAppInterface F;
    private FriendsManager G;
    private LinkedHashMap<String, List<PhoneContact>> H;
    private int[] I;
    private String[] J;
    private List<PhoneContact> K;
    public List<PhoneContact> L;
    boolean M;
    int N;
    int P;
    public IndexView Q;
    public b R;
    PhoneContact S;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends k {
        static IPatchRedirector $redirector_;
        public TextView C;
        public Button D;
        public TextView E;
        public PhoneContact F;
        public CheckBox G;
        public View H;
        public TextView I;

        /* renamed from: i, reason: collision with root package name */
        public TextView f187186i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f187187m;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f187211e = 11;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void e0(PhoneContact phoneContact, boolean z16);
    }

    public h(Context context, QQAppInterface qQAppInterface, XListView xListView, List<PhoneContact> list) {
        super(context, qQAppInterface, xListView, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, xListView, list);
            return;
        }
        this.D = new ArrayList();
        this.H = new LinkedHashMap<>();
        this.I = new int[0];
        this.J = new String[0];
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.M = false;
        this.N = 0;
        this.P = 0;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.E = context;
        this.F = qQAppInterface;
        this.G = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.N = context.getResources().getDimensionPixelOffset(R.dimen.adm);
        this.P = context.getResources().getDimensionPixelOffset(R.dimen.adn);
        k(list);
    }

    private boolean h(PhoneContact phoneContact) {
        for (int i3 = 0; i3 < this.L.size(); i3++) {
            if (TextUtils.equals(phoneContact.unifiedCode, this.L.get(i3).unifiedCode)) {
                return true;
            }
        }
        return false;
    }

    private static void m(View view, boolean z16) {
        if (view == null) {
            return;
        }
        if (z16) {
            view.setBackgroundResource(R.drawable.f160542jo);
        } else {
            view.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
    }

    private static void n(View view, boolean z16) {
        if (view == null) {
            return;
        }
        int paddingBottom = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (z16) {
            view.setBackgroundResource(R.drawable.f160542jo);
        } else {
            view.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public void configDividerView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, i3);
            return;
        }
        int binarySearch = Arrays.binarySearch(this.I, i3);
        if (binarySearch < 0) {
            binarySearch = (-(binarySearch + 1)) - 1;
        }
        String[] strArr = this.J;
        if (binarySearch < strArr.length && binarySearch >= 0) {
            ((TextView) view).setText(strArr[binarySearch]);
        }
    }

    @Override // com.tencent.mobileqq.adapter.e
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        IFaceDecoder iFaceDecoder = this.f187157f;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.M = z16;
            notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int[] iArr = this.I;
        if (iArr.length == 0) {
            return 0;
        }
        return iArr[iArr.length - 1] + this.H.get(this.J[r2.length - 1]).size() + 1;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public int getDividerLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        if (this.J.length > 0) {
            return R.layout.fg8;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        int binarySearch = Arrays.binarySearch(this.I, i3);
        if (binarySearch >= 0) {
            return null;
        }
        return this.H.get(this.J[(-(binarySearch + 1)) - 1]).get((i3 - this.I[r0]) - 1);
    }

    @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        View view3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            int binarySearch = Arrays.binarySearch(this.I, i3);
            if (view == null) {
                a aVar2 = new a();
                View inflate = LayoutInflater.from(this.E).inflate(R.layout.at7, (ViewGroup) null);
                aVar2.f187186i = (TextView) inflate.findViewById(R.id.nickname);
                aVar2.f187212f = (ImageView) inflate.findViewById(R.id.f163821d);
                aVar2.f187187m = (TextView) inflate.findViewById(R.id.i95);
                aVar2.C = (TextView) inflate.findViewById(R.id.iz7);
                aVar2.D = (Button) inflate.findViewById(R.id.i8s);
                aVar2.E = (TextView) inflate.findViewById(R.id.f166787i92);
                aVar2.G = (CheckBox) inflate.findViewById(R.id.ax9);
                aVar2.I = (TextView) inflate.findViewById(R.id.k8u);
                aVar2.H = inflate.findViewById(R.id.gqb);
                inflate.setBackgroundDrawable(null);
                inflate.setTag(aVar2);
                ImageView imageView = aVar2.f187212f;
                if (imageView instanceof ThemeImageView) {
                    ((ThemeImageView) imageView).setSupportMaskView(false);
                }
                if (SimpleUIUtil.isNowElderMode()) {
                    float dpToPx = ViewUtils.dpToPx(18.0f);
                    aVar2.f187187m.setTextSize(0, dpToPx);
                    aVar2.C.setTextSize(0, dpToPx);
                    int dimensionPixelOffset = this.E.getResources().getDimensionPixelOffset(R.dimen.cai);
                    aVar2.D.setMinWidth(dimensionPixelOffset);
                    aVar2.D.setMinHeight(dimensionPixelOffset);
                    aVar2.D.setTextSize(0, dpToPx);
                    aVar2.E.setMinWidth(dimensionPixelOffset);
                    aVar2.E.setMinHeight(dimensionPixelOffset);
                    aVar2.E.setTextSize(0, dpToPx);
                }
                aVar = aVar2;
                view = inflate;
            } else {
                aVar = (a) view.getTag();
            }
            IndexView indexView = this.Q;
            if (indexView != null && indexView.getVisibility() == 0) {
                view.findViewById(R.id.result_layout).setPadding(0, 0, this.N, 0);
            } else {
                view.findViewById(R.id.result_layout).setPadding(0, 0, this.P, 0);
            }
            if (binarySearch < 0) {
                int i17 = (-(binarySearch + 1)) - 1;
                PhoneContact phoneContact = this.H.get(this.J[i17]).get((i3 - this.I[i17]) - 1);
                aVar.F = phoneContact;
                if (!this.K.isEmpty() && !"\u2605".equals(this.J[i17]) && phoneContact.isNewRecommend) {
                    m(view, true);
                    n(aVar.H, true);
                } else {
                    m(view, false);
                    n(aVar.H, false);
                }
                StringBuilder sb5 = new StringBuilder(256);
                if (!TextUtils.isEmpty(phoneContact.name)) {
                    aVar.f187186i.setVisibility(0);
                    aVar.f187186i.setText(phoneContact.name);
                    if (AppSetting.f99565y) {
                        AccessibilityUtil.n(aVar.f187186i, false);
                        sb5.append(phoneContact.name);
                    }
                } else {
                    aVar.f187186i.setVisibility(8);
                }
                aVar.f187187m.setVisibility(8);
                if (phoneContact.samFriend > 0) {
                    aVar.C.setVisibility(0);
                    String format = String.format(this.E.getResources().getString(R.string.a9n), Integer.valueOf(phoneContact.samFriend));
                    aVar.C.setText(format);
                    aVar.C.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    if (AppSetting.f99565y) {
                        sb5.append(",");
                        sb5.append(format);
                    }
                } else {
                    aVar.C.setVisibility(8);
                }
                if (!TextUtils.isEmpty(phoneContact.uin) && !phoneContact.uin.equals("0")) {
                    aVar.D.setVisibility(8);
                    aVar.E.setVisibility(0);
                    aVar.E.setText(HardCodeUtil.qqStr(R.string.f171792l11));
                    if (this.M) {
                        aVar.H.setEnabled(false);
                        aVar.G.setEnabled(false);
                        aVar.G.setChecked(false);
                    }
                    if (AppSetting.f99565y) {
                        aVar.E.setContentDescription(HardCodeUtil.qqStr(R.string.l0w));
                    }
                } else if (this.G.Q(phoneContact.unifiedCode, true)) {
                    aVar.D.setVisibility(8);
                    aVar.E.setVisibility(0);
                    aVar.E.setText(HardCodeUtil.qqStr(R.string.l0z));
                    if (this.M) {
                        aVar.H.setEnabled(false);
                        aVar.G.setEnabled(false);
                        aVar.G.setChecked(false);
                    }
                    if (AppSetting.f99565y) {
                        aVar.E.setContentDescription(HardCodeUtil.qqStr(R.string.f171795l15));
                    }
                } else {
                    if (this.M) {
                        aVar.D.setVisibility(8);
                        aVar.G.setEnabled(true);
                        aVar.G.setChecked(h(phoneContact));
                        aVar.G.setTag(aVar);
                    } else {
                        aVar.D.setVisibility(0);
                        aVar.D.setText(HardCodeUtil.qqStr(R.string.f170028dd));
                        aVar.D.setTag(phoneContact);
                        aVar.D.setOnClickListener(this);
                        if (AppSetting.f99565y) {
                            aVar.D.setContentDescription(HardCodeUtil.qqStr(R.string.f170028dd));
                        }
                    }
                    aVar.H.setEnabled(true);
                    aVar.E.setVisibility(8);
                }
                if (SimpleUIUtil.isNowElderMode()) {
                    float dpToPx2 = ViewUtils.dpToPx(18.0f);
                    aVar.E.setTextSize(0, dpToPx2);
                    aVar.D.setTextSize(0, dpToPx2);
                }
                CheckBox checkBox = aVar.G;
                if (this.M) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                checkBox.setVisibility(i16);
                if (AppSetting.f99565y) {
                    view.setContentDescription(sb5.toString());
                }
                aVar.I.setVisibility(8);
                aVar.H.setVisibility(0);
                String str = phoneContact.unifiedCode;
                aVar.f187210d = str;
                aVar.f187212f.setImageBitmap(d(str, 11, (byte) 0));
                aVar.H.setOnClickListener(this);
                aVar.H.setTag(aVar);
            } else {
                aVar.H.setTag(null);
                aVar.H.setOnClickListener(null);
                aVar.H.setVisibility(8);
                aVar.I.setVisibility(0);
                aVar.I.setText(String.valueOf(this.J[binarySearch]));
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public int i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).intValue();
        }
        if (this.J != null) {
            int i3 = 0;
            while (true) {
                String[] strArr = this.J;
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
                return this.I[i3];
            }
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public boolean isDividerView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, i3)).booleanValue();
        }
        if (Arrays.binarySearch(this.I, i3) >= 0) {
            return true;
        }
        return false;
    }

    public void j(com.tencent.mobileqq.phonecontact.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        this.D = aVar.f258459d;
        this.I = aVar.f258457b;
        this.H = aVar.f258456a;
        this.J = aVar.f258458c;
        this.K = aVar.f258460e;
    }

    public void k(List<PhoneContact> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            j(com.tencent.mobileqq.phonecontact.util.a.a(list, null, true));
        }
    }

    public void l(PhoneContact phoneContact, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, phoneContact, Boolean.valueOf(z16));
            return;
        }
        while (true) {
            if (i3 < this.L.size()) {
                if (TextUtils.equals(phoneContact.unifiedCode, this.L.get(i3).unifiedCode)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (z16) {
            if (i3 == -1) {
                this.L.add(phoneContact);
                notifyDataSetChanged();
                return;
            }
            return;
        }
        if (i3 != -1) {
            this.L.remove(i3);
            notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AllInOne allInOne;
        int i3;
        int i16;
        int i17;
        String upperCase;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag != null) {
                Context context = this.E;
                if (context instanceof ContactBindedActivity) {
                    ((ContactBindedActivity) context).N2();
                }
                int id5 = view.getId();
                int i18 = 1;
                if (id5 == R.id.i8s) {
                    PhoneContact phoneContact = (PhoneContact) tag;
                    IPhoneContactService iPhoneContactService = (IPhoneContactService) this.F.getRuntimeService(IPhoneContactService.class, "");
                    if (((Activity) this.E).getIntent().getBooleanExtra(AppConstants.Key.KEY_FROM_BABYQ, false)) {
                        i3 = 3084;
                    } else {
                        i18 = 13;
                        i3 = 3006;
                    }
                    if (!iPhoneContactService.isBindedIgnoreUpload()) {
                        if (this.K.contains(phoneContact)) {
                            ReportController.o(this.F, "dc00898", "", "", "0X80077CD", "0X80077CD", 1, 0, "", "", "", "");
                        } else {
                            ReportController.o(this.F, "dc00898", "", "", "0X80077CD", "0X80077CD", 2, 0, "", "", "", "");
                        }
                        ReportController.o(this.F, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
                        i17 = 16;
                        i16 = 3006;
                    } else {
                        if (this.K.isEmpty()) {
                            ReportController.o(this.F, "dc00898", "", "", "0X80077D0", "0X80077D0", 0, 0, "", "", "", "");
                        } else {
                            if (this.K.contains(phoneContact)) {
                                ReportController.o(this.F, "dc00898", "", "", "0X80077D3", "0X80077D3", 1, 0, "", "", "", "");
                            } else {
                                ReportController.o(this.F, "dc00898", "", "", "0X80077D3", "0X80077D3", 2, 0, "", "", "", "");
                            }
                            ReportController.o(this.F, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
                        }
                        i16 = i3;
                        i17 = i18;
                    }
                    phoneContact.isNewRecommend = false;
                    Context context2 = this.E;
                    if (context2 instanceof ContactBindedActivity) {
                        ContactBindedActivity contactBindedActivity = (ContactBindedActivity) context2;
                        if (TextUtils.isEmpty(phoneContact.pinyinFirst)) {
                            upperCase = "#";
                        } else {
                            upperCase = String.valueOf(phoneContact.pinyinFirst.charAt(0)).toUpperCase();
                        }
                        List<PhoneContact> list = this.H.get(upperCase);
                        if (list != null && !list.isEmpty()) {
                            int indexOf = list.indexOf(phoneContact);
                            contactBindedActivity.A0 = indexOf;
                            if (indexOf != -1) {
                                contactBindedActivity.f175459z0 = phoneContact;
                            }
                        }
                    }
                    ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend((Activity) this.E, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this.E, 2, phoneContact.unifiedCode, null, i16, i17, phoneContact.name, null, null, HardCodeUtil.qqStr(R.string.j6l), null));
                    ReportController.o(this.F, "CliOper", "", "", "0X8006A75", "0X8006A75", 0, 0, "", "", "", "");
                    notifyDataSetChanged();
                } else if (id5 == R.id.gqb) {
                    if (this.M) {
                        a aVar = (a) tag;
                        boolean h16 = h(aVar.F);
                        l(aVar.F, !h16);
                        b bVar = this.R;
                        if (bVar != null) {
                            bVar.e0(aVar.F, !h16);
                        }
                    } else {
                        PhoneContact phoneContact2 = ((a) tag).F;
                        this.S = phoneContact2;
                        if (phoneContact2 != null) {
                            phoneContact2.isNewRecommend = false;
                            IPhoneContactService iPhoneContactService2 = (IPhoneContactService) this.F.getRuntimeService(IPhoneContactService.class, "");
                            if (!TextUtils.isEmpty(this.S.uin) && !"0".equals(this.S.uin)) {
                                allInOne = new AllInOne(this.S.uin, 30);
                                allInOne.contactName = this.S.name;
                            } else if (iPhoneContactService2.isBindedIgnoreUpload()) {
                                allInOne = new AllInOne(this.S.unifiedCode, 34);
                            } else {
                                allInOne = new AllInOne(this.S.unifiedCode, 29);
                                allInOne.subSourceId = 16;
                            }
                            allInOne.nickname = this.S.name;
                            if (iPhoneContactService2.isBindedIgnoreUpload() && this.K.isEmpty()) {
                                allInOne.profileEntryType = 104;
                            } else if (this.K.contains(this.S)) {
                                allInOne.profileEntryType = 101;
                            } else {
                                allInOne.profileEntryType = 102;
                            }
                            ProfileUtils.openProfileCard(this.E, allInOne);
                        }
                        notifyDataSetChanged();
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
