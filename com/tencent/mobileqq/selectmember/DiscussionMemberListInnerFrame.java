package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DiscussionMemberListInnerFrame extends SelectMemberInnerFrame implements View.OnClickListener, IndexView.b, PinnedDividerListView.b, CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;
    private String D;
    private String E;
    private String F;
    private c G;
    PinnedDividerListView H;
    private IndexView I;
    List<DiscussionMemberInfo> J;
    RelativeLayout K;
    CheckBox L;
    boolean M;
    private Handler N;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberListInnerFrame.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                CheckBox checkBox = DiscussionMemberListInnerFrame.this.L;
                checkBox.setChecked(true ^ checkBox.isChecked());
                DiscussionMemberListInnerFrame discussionMemberListInnerFrame = DiscussionMemberListInnerFrame.this;
                CheckBox checkBox2 = discussionMemberListInnerFrame.L;
                discussionMemberListInnerFrame.onCheckedChanged(checkBox2, checkBox2.isChecked());
                if (DiscussionMemberListInnerFrame.this.f285782h.mEntrance == 32) {
                    IQWalletApi iQWalletApi = (IQWalletApi) QRoute.api(IQWalletApi.class);
                    if (DiscussionMemberListInnerFrame.this.L.isChecked()) {
                        str = "friendsfinder.all.confirm";
                    } else {
                        str = "friendsfinder.all.cancel";
                    }
                    iQWalletApi.reportTenpay(0, str);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberListInnerFrame.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else {
                int i3 = message.what;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends com.tencent.mobileqq.adapter.e {
        static IPatchRedirector $redirector_;
        private LinkedHashMap<String, List<DiscussionMemberInfo>> D;
        private int[] E;
        private String[] F;

        public c() {
            super(DiscussionMemberListInnerFrame.this.f285782h, DiscussionMemberListInnerFrame.this.f285784m, DiscussionMemberListInnerFrame.this.H, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberListInnerFrame.this);
                return;
            }
            this.D = new LinkedHashMap<>();
            this.E = new int[0];
            this.F = new String[0];
            g();
        }

        @SuppressLint({"DefaultLocale"})
        private void g() {
            char c16;
            int i3;
            String str;
            this.D.clear();
            String currentAccountUin = DiscussionMemberListInnerFrame.this.f285784m.getCurrentAccountUin();
            Iterator<DiscussionMemberInfo> it = DiscussionMemberListInnerFrame.this.J.iterator();
            DiscussionMemberInfo discussionMemberInfo = null;
            while (true) {
                boolean hasNext = it.hasNext();
                i3 = 0;
                String str2 = "#";
                if (!hasNext) {
                    break;
                }
                DiscussionMemberInfo next = it.next();
                if (next != null && !com.tencent.mobileqq.selectmember.util.a.m(DiscussionMemberListInnerFrame.this.f285784m, next.memberUin)) {
                    if (DiscussionMemberListInnerFrame.this.f285782h.mIsPutMySelfFirst && currentAccountUin != null && currentAccountUin.equals(next.memberUin)) {
                        discussionMemberInfo = next;
                    } else {
                        String str3 = next.displayedNamePinyinFirst;
                        if (str3 == null || str3.length() == 0) {
                            str = "#";
                        } else {
                            str = next.displayedNamePinyinFirst.substring(0, 1);
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
                }
            }
            LinkedHashMap<String, List<DiscussionMemberInfo>> linkedHashMap = this.D;
            this.D = new LinkedHashMap<>();
            if (DiscussionMemberListInnerFrame.this.f285782h.mIsPutMySelfFirst && discussionMemberInfo != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(discussionMemberInfo);
                this.D.put(HardCodeUtil.qqStr(R.string.lo6), arrayList);
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, i3);
            } else {
                Arrays.binarySearch(this.E, i3);
            }
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
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
                    view = DiscussionMemberListInnerFrame.this.C.inflate(R.layout.byd, viewGroup, false);
                    d dVar = new d(DiscussionMemberListInnerFrame.this, null);
                    view.setTag(dVar);
                    dVar.f297804i = (RelativeLayout) view.findViewById(R.id.icx);
                    dVar.f297805m = (TextView) view.findViewById(R.id.k8u);
                    dVar.E = (CheckBox) view.findViewById(R.id.axa);
                    dVar.f187212f = (ImageView) view.findViewById(R.id.icon);
                    dVar.C = (TextView) view.findViewById(R.id.f5e);
                }
                d dVar2 = (d) view.getTag();
                if (binarySearch < 0) {
                    int i16 = (-(binarySearch + 1)) - 1;
                    DiscussionMemberInfo discussionMemberInfo = this.D.get(this.F[i16]).get((i3 - this.E[i16]) - 1);
                    if (DiscussionMemberListInnerFrame.this.f285782h.isResultListContainFriend(discussionMemberInfo.memberUin)) {
                        dVar2.E.setChecked(true);
                    } else {
                        dVar2.E.setChecked(false);
                    }
                    dVar2.f297804i.setVisibility(0);
                    dVar2.f297805m.setVisibility(8);
                    dVar2.f187212f.setImageBitmap(b(discussionMemberInfo.memberUin));
                    dVar2.C.setText(com.tencent.mobileqq.selectmember.util.a.d(discussionMemberInfo, DiscussionMemberListInnerFrame.this.f285784m));
                    String str = discussionMemberInfo.memberUin;
                    dVar2.f187210d = str;
                    ArrayList<String> arrayList = DiscussionMemberListInnerFrame.this.f285782h.mUinsSelectedDefault;
                    if (arrayList != null && arrayList.contains(str)) {
                        dVar2.E.setEnabled(false);
                    } else {
                        dVar2.E.setEnabled(true);
                    }
                    if (AppSetting.f99565y && dVar2.E.isEnabled()) {
                        if (dVar2.E.isChecked()) {
                            view.setContentDescription(com.tencent.mobileqq.selectmember.util.a.d(discussionMemberInfo, DiscussionMemberListInnerFrame.this.f285784m) + HardCodeUtil.qqStr(R.string.lob));
                        } else {
                            view.setContentDescription(com.tencent.mobileqq.selectmember.util.a.d(discussionMemberInfo, DiscussionMemberListInnerFrame.this.f285784m) + HardCodeUtil.qqStr(R.string.lnv));
                        }
                    }
                    view.setOnClickListener(DiscussionMemberListInnerFrame.this);
                } else {
                    dVar2.f297804i.setVisibility(8);
                    dVar2.f297805m.setVisibility(0);
                    String valueOf = String.valueOf(this.F[binarySearch]);
                    dVar2.f297805m.setText(valueOf);
                    dVar2.f297805m.setContentDescription(String.format(DiscussionMemberListInnerFrame.this.f285782h.getString(R.string.aud), valueOf.toLowerCase()));
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        public int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            Iterator<String> it = this.D.keySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 += this.D.get(it.next()).size();
            }
            return i3;
        }

        public int i(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).intValue();
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

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
            }
            if (Arrays.binarySearch(this.E, i3) >= 0) {
                return true;
            }
            return false;
        }

        public void j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this);
            } else {
                g();
                super.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class d extends com.tencent.mobileqq.troop.memberlist.b {
        static IPatchRedirector $redirector_;
        public CheckBox E;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberListInnerFrame.this);
        }

        /* synthetic */ d(DiscussionMemberListInnerFrame discussionMemberListInnerFrame, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) discussionMemberListInnerFrame, (Object) aVar);
        }
    }

    public DiscussionMemberListInnerFrame(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = "";
        this.J = new ArrayList();
        this.N = new b();
    }

    private void r() {
        this.J.clear();
        ArrayList<DiscussionMemberInfo> arrayList = (ArrayList) ((IDiscussionService) this.f285784m.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberInfoListByUin(this.E);
        if (arrayList != null) {
            String currentAccountUin = this.f285784m.getCurrentAccountUin();
            for (DiscussionMemberInfo discussionMemberInfo : arrayList) {
                if (discussionMemberInfo != null && (this.f285782h.mShowMyself || !currentAccountUin.equalsIgnoreCase(discussionMemberInfo.memberUin))) {
                    if (!this.f285782h.mUinsToHide.contains(discussionMemberInfo.memberUin)) {
                        discussionMemberInfo.displayedNamePinyinFirst = ChnToSpell.d(com.tencent.mobileqq.selectmember.util.a.d(discussionMemberInfo, this.f285784m), 2);
                        this.J.add(discussionMemberInfo);
                    }
                }
            }
        }
        this.f285782h.afterMemberFilter(this.J.size());
    }

    private void s() {
        this.H = (PinnedDividerListView) findViewById(R.id.atu);
        IndexView indexView = (IndexView) findViewById(R.id.djh);
        this.I = indexView;
        indexView.setIndex(new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
        this.I.setOnIndexChangedListener(this);
        this.H.setSelector(R.color.ajr);
        this.H.setOnLayoutListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.idl);
        this.K = relativeLayout;
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.ee_);
        this.L = (CheckBox) findViewById(R.id.f164752as2);
        linearLayout.setOnClickListener(this);
    }

    private void t(String str, boolean z16) {
        RelativeLayout relativeLayout = this.K;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            boolean z17 = false;
            if (str == null || z16 || !this.L.isChecked()) {
                int count = this.G.getCount();
                int i3 = 0;
                while (true) {
                    if (i3 < count) {
                        DiscussionMemberInfo discussionMemberInfo = (DiscussionMemberInfo) this.G.getItem(i3);
                        if (discussionMemberInfo != null && !this.f285782h.isResultListContainFriend(discussionMemberInfo.memberUin)) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        z17 = true;
                        break;
                    }
                }
            }
            this.L.setChecked(z17);
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
        setContentView(R.layout.f169084by4);
        s();
        c cVar = new c();
        this.G = cVar;
        this.H.setAdapter((ListAdapter) cVar);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        int i3;
        DiscussionInfo discussionInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.m(bundle);
        this.f285782h.mSelectedAndSearchBar.v();
        this.E = bundle.getString("group_uin");
        this.F = bundle.getString("group_name");
        boolean z16 = bundle.getBoolean(ISelectMemberActivityConstants.PARAM_ENABLE_ALL_SELECT, false);
        RelativeLayout relativeLayout = this.K;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
        if (TextUtils.isEmpty(this.F) && !TextUtils.isEmpty(this.E) && (discussionInfo = (DiscussionInfo) ((IDiscussionService) this.f285784m.getRuntimeService(IDiscussionService.class, "")).findDiscussionInfoByID(this.E)) != null) {
            this.F = discussionInfo.discussionName;
        }
        SelectMemberActivity selectMemberActivity = this.f285782h;
        if (selectMemberActivity.mOnlyDiscussionMember) {
            selectMemberActivity.setupTitleBar(false, "", this.F);
        } else {
            selectMemberActivity.setupTitleBar(true, HardCodeUtil.qqStr(R.string.loc), this.F);
        }
        if (!TextUtils.isEmpty(this.E) && !this.E.equals(this.D)) {
            r();
            this.G.j();
            this.H.setSelection(0);
            this.D = this.E;
        } else {
            this.G.notifyDataSetChanged();
        }
        if (!this.M && this.f285782h.mIsSelectAllMembers) {
            this.M = true;
            this.L.setChecked(true);
            CheckBox checkBox = this.L;
            onCheckedChanged(checkBox, checkBox.isChecked());
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public com.tencent.mobileqq.search.view.f n(boolean z16, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.search.view.f) iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), kVar);
        }
        ISearchViewCreator iSearchViewCreator = (ISearchViewCreator) QRoute.api(ISearchViewCreator.class);
        String str = this.E;
        SelectMemberActivity selectMemberActivity = this.f285782h;
        return iSearchViewCreator.createContactSearchFragment(-1, 4096, str, selectMemberActivity.mUinsToHide, selectMemberActivity, z16, kVar);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.E;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, compoundButton, Boolean.valueOf(z16));
        } else if (R.id.f164752as2 == compoundButton.getId()) {
            if (z16) {
                ArrayList arrayList = new ArrayList();
                int count = this.G.getCount();
                for (int i3 = 0; i3 < count; i3++) {
                    DiscussionMemberInfo discussionMemberInfo = (DiscussionMemberInfo) this.G.getItem(i3);
                    if (discussionMemberInfo != null) {
                        arrayList.add(SelectMemberActivity.constructAResultRecord(discussionMemberInfo.memberUin, com.tencent.mobileqq.selectmember.util.a.d(discussionMemberInfo, this.f285784m), 2, this.E));
                    }
                }
                if (this.f285782h.mEntrance == 31) {
                    ReportController.o(this.f285784m, "dc00898", "", "", "0X8007CFB", "0X8007CFB", 0, 0, "", "", "", "");
                }
                this.f285782h.addFriendResults(arrayList, false, true);
            } else {
                this.f285782h.removeAllFriendResult();
            }
            this.G.notifyDataSetChanged();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        CheckBox checkBox;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (R.id.ee_ != view.getId()) {
            d dVar = (d) view.getTag();
            if (dVar != null && (checkBox = dVar.E) != null && dVar.C != null && checkBox.isEnabled()) {
                boolean onListViewItemClick = this.f285782h.onListViewItemClick(dVar.f187210d, dVar.C.getText().toString(), 2, this.E);
                dVar.E.setChecked(onListViewItemClick);
                t(dVar.f187210d, onListViewItemClick);
                if (AppSetting.f99565y) {
                    if (dVar.E.isChecked()) {
                        view.setContentDescription(dVar.C.getText().toString() + HardCodeUtil.qqStr(R.string.lnm));
                    } else {
                        view.setContentDescription(dVar.C.getText().toString() + HardCodeUtil.qqStr(R.string.f171888lo2));
                    }
                }
            }
        } else {
            int i3 = this.f285782h.mEntrance;
            if ((i3 == 32 || i3 == 43) && !this.L.isChecked() && this.f285782h.mMaxSelectNumber < this.G.h()) {
                a aVar = new a();
                String format = MessageFormat.format(this.f285782h.getString(R.string.hdc), Integer.valueOf(this.f285782h.mMaxSelectNumber));
                SelectMemberActivity selectMemberActivity = this.f285782h;
                try {
                    DialogUtil.createCustomDialog(selectMemberActivity, 232, selectMemberActivity.getResources().getString(R.string.f173206i10), format, R.string.cancel, R.string.fjw, aVar, aVar).show();
                } catch (Throwable unused) {
                }
            } else {
                CheckBox checkBox2 = this.L;
                checkBox2.setChecked(true ^ checkBox2.isChecked());
                CheckBox checkBox3 = this.L;
                onCheckedChanged(checkBox3, checkBox3.isChecked());
                if (this.f285782h.mEntrance == 32) {
                    IQWalletApi iQWalletApi = (IQWalletApi) QRoute.api(IQWalletApi.class);
                    if (this.L.isChecked()) {
                        str = "friendsfinder.all.confirm";
                    } else {
                        str = "friendsfinder.all.cancel";
                    }
                    iQWalletApi.reportTenpay(0, str);
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
        c cVar = this.G;
        if (cVar != null) {
            cVar.destroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if ("$".equals(str)) {
            this.H.setSelection(0);
            return;
        }
        int i3 = this.G.i(str);
        if (i3 != -1) {
            PinnedDividerListView pinnedDividerListView = this.H;
            pinnedDividerListView.setSelection(i3 + pinnedDividerListView.getHeaderViewsCount());
        }
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.b
    public void onLayout(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if ((this.H.getFirstVisiblePosition() > 0 || (this.H.getFirstVisiblePosition() == 0 && this.H.getChildCount() < this.G.getCount() + this.H.getHeaderViewsCount())) && !this.f285782h.isSoftInputShowing()) {
            this.I.setVisibility(0);
            this.N.sendEmptyMessage(1);
        } else {
            this.I.setVisibility(4);
            this.N.sendEmptyMessage(2);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.G.notifyDataSetChanged();
            t(null, false);
        }
    }

    public DiscussionMemberListInnerFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.D = "";
        this.J = new ArrayList();
        this.N = new b();
    }

    public DiscussionMemberListInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = "";
        this.J = new ArrayList();
        this.N = new b();
    }
}
