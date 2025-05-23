package com.tencent.mobileqq.activity.contact.addcontact;

import MQQ.LhLogoResources;
import addcontacts.AccountSearchPb$ResultItem;
import addcontacts.AccountSearchPb$hotwordrecord;
import addcontacts.AccountSearchPb$record;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.ai;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SearchBaseFragment extends BaseFragment implements View.OnClickListener, DecodeTaskCompletionListener, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name */
    private static final String f180775b0;
    public final int C;
    protected String D;
    protected int E;
    protected int F;
    protected boolean G;
    protected boolean H;
    protected BaseAdapter I;
    LinearLayout J;
    XListView K;
    h L;
    IFaceDecoder M;
    int N;
    protected StatusManager P;
    protected int Q;
    public Map<String, SpannableString> R;
    protected QQAppInterface S;
    private Handler T;
    protected BaseActivity U;
    protected g V;
    protected g.b W;
    protected Handler X;
    protected com.tencent.mobileqq.richstatus.e Y;
    private AccountSearchPb$record Z;

    /* renamed from: a0, reason: collision with root package name */
    private ar f180776a0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements g.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchBaseFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.g.b
        public void a(int i3, boolean z16, Object obj, int i16, String str, int i17, List<x> list) {
            Handler handler;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i18 = 3;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj, Integer.valueOf(i16), str, Integer.valueOf(i17), list);
                return;
            }
            SearchBaseFragment.this.yh();
            if (z16) {
                if (i17 == 1) {
                    Handler handler2 = SearchBaseFragment.this.X;
                    if (handler2 != null) {
                        handler2.sendMessage(handler2.obtainMessage(4, list));
                        return;
                    }
                    return;
                }
                if (i17 == 2) {
                    Handler handler3 = SearchBaseFragment.this.X;
                    if (handler3 != null) {
                        handler3.sendEmptyMessage(5);
                        return;
                    }
                    return;
                }
                if (obj instanceof ArrayList) {
                    ArrayList<un2.a> arrayList = (ArrayList) obj;
                    if (arrayList.isEmpty()) {
                        SearchBaseFragment searchBaseFragment = SearchBaseFragment.this;
                        Handler handler4 = searchBaseFragment.X;
                        if (handler4 != null) {
                            if (!searchBaseFragment.G) {
                                i18 = 2;
                            }
                            handler4.sendEmptyMessage(i18);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(SearchBaseFragment.f180775b0, 2, "error! SearchResult is null!");
                            return;
                        }
                        return;
                    }
                    try {
                        arrayList.get(0);
                        if (SearchBaseFragment.this.th(arrayList) && (handler = SearchBaseFragment.this.X) != null) {
                            handler.sendEmptyMessage(0);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(SearchBaseFragment.f180775b0, 2, "", e16);
                        }
                        SearchBaseFragment searchBaseFragment2 = SearchBaseFragment.this;
                        Handler handler5 = searchBaseFragment2.X;
                        if (!searchBaseFragment2.G) {
                            i18 = 2;
                        }
                        handler5.sendEmptyMessage(i18);
                        return;
                    }
                }
                return;
            }
            SearchBaseFragment.this.Rh(i3, obj, i16, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchBaseFragment.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (SearchBaseFragment.this.T != null) {
                SearchBaseFragment.this.T.sendMessage(Message.obtain(message));
            }
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 5) {
                                    SearchBaseFragment.this.Wh();
                                    return;
                                }
                                return;
                            }
                            SearchBaseFragment.this.Yh((List) message.obj);
                            return;
                        }
                        SearchBaseFragment.this.Qh();
                        return;
                    }
                    SearchBaseFragment.this.Vh();
                    return;
                }
                SearchBaseFragment.this.Xh((String) message.obj);
                return;
            }
            SearchBaseFragment.this.Th();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements com.tencent.mobileqq.richstatus.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchBaseFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.e
        public void onGetIcon(int i3, int i16, Bitmap bitmap) {
            XListView xListView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
                return;
            }
            if (bitmap != null && i16 != 201) {
                SearchBaseFragment searchBaseFragment = SearchBaseFragment.this;
                if (searchBaseFragment.N != 0 || (xListView = searchBaseFragment.K) == null) {
                    return;
                }
                int childCount = xListView.getChildCount();
                for (int i17 = 0; i17 < childCount; i17++) {
                    Object tag = SearchBaseFragment.this.K.getChildAt(i17).getTag();
                    if (tag != null && (tag instanceof f)) {
                        f fVar = (f) tag;
                        if (fVar.f180799i == i3) {
                            SearchBaseFragment.this.Ch(fVar, fVar.f180802l);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d extends ar {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchBaseFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            } else if (z16 && obj != null && SearchBaseFragment.this.Z != null && SearchBaseFragment.this.Z.uin.get() == ((Long) obj).longValue()) {
                SearchBaseFragment.this.Z.relation.set(SearchBaseFragment.this.Z.relation.get() & 16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ImageView f180781a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f180782b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f180783c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f180784d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f180785e;

        /* renamed from: f, reason: collision with root package name */
        public String f180786f;

        /* renamed from: g, reason: collision with root package name */
        public int f180787g;

        /* renamed from: h, reason: collision with root package name */
        public long f180788h;

        /* renamed from: i, reason: collision with root package name */
        public String f180789i;

        /* renamed from: j, reason: collision with root package name */
        public String f180790j;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ImageView f180791a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f180792b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f180793c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f180794d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f180795e;

        /* renamed from: f, reason: collision with root package name */
        public String f180796f;

        /* renamed from: g, reason: collision with root package name */
        public String f180797g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f180798h;

        /* renamed from: i, reason: collision with root package name */
        public int f180799i;

        /* renamed from: j, reason: collision with root package name */
        public int f180800j;

        /* renamed from: k, reason: collision with root package name */
        public AccountSearchPb$record f180801k;

        /* renamed from: l, reason: collision with root package name */
        public RichStatus f180802l;

        /* renamed from: m, reason: collision with root package name */
        public int f180803m;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f180798h = true;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67836);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 44)) {
            redirector.redirect((short) 44);
        } else {
            f180775b0 = SearchBaseFragment.class.getName();
        }
    }

    public SearchBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.C = 64;
        this.E = 0;
        this.F = 0;
        this.N = 0;
        this.R = new ConcurrentHashMap();
        this.W = new a();
        this.X = new b();
        this.Y = new c();
        this.f180776a0 = new d();
    }

    public static SpannableString Dh(String str, String str2, List<String> list) {
        int Hh;
        if (str2 == null) {
            return null;
        }
        if (list == null) {
            return new SpannableString(str2);
        }
        int length = str2.length();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            int Lh = Lh(it.next(), str2);
            if (Lh >= 0 && Lh < length) {
                length = Lh;
            }
        }
        if (length > 8 && length != str2.length()) {
            str2 = "\u2026" + str2.substring(length - 8);
        }
        SpannableString spannableString = new SpannableString(str2);
        if (TextUtils.isEmpty(str)) {
            Hh = Jh();
        } else {
            Hh = Hh(str);
        }
        for (String str3 : list) {
            int i3 = 0;
            String str4 = str2;
            while (true) {
                int Lh2 = Lh(str3, str4);
                if (Lh2 >= 0) {
                    int length2 = str3.length() + Lh2;
                    int i16 = Lh2 + i3;
                    i3 += length2;
                    spannableString.setSpan(new ForegroundColorSpan(Hh), i16, i3, 33);
                    str4 = str4.substring(length2);
                }
            }
        }
        return spannableString;
    }

    public static SpannableString Eh(String str, List<String> list) {
        return Dh(null, str, list);
    }

    public static SpannableString Fh(String str, List<String> list, int i3) {
        if (str == null) {
            return null;
        }
        if (list == null) {
            return new SpannableString(str);
        }
        int length = str.length();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            int Lh = Lh(it.next(), str);
            if (Lh >= 0 && Lh < length) {
                length = Lh;
            }
        }
        int length2 = str.length();
        if (length >= 0 && length2 > i3) {
            String Ih = Ih(str, list);
            if (!TextUtils.isEmpty(Ih)) {
                int length3 = Ih.length();
                if (length3 < i3) {
                    int i16 = length + length3;
                    int i17 = i16 - i3;
                    if (i17 > 0 && i16 < str.length()) {
                        str = "\u2026" + str.substring(i17, i16) + "\u2026";
                    }
                    if (i17 > 0 && i16 >= length2) {
                        str = "\u2026" + str.substring(str.length() - i3, str.length());
                    } else if (i17 <= 0) {
                        str = str.substring(0, i3) + "\u2026";
                    }
                } else {
                    str = str.substring(0, i3) + "\u2026";
                }
            } else {
                str = str.substring(0, i3) + "\u2026";
            }
        } else if (length2 > i3) {
            str = str.substring(0, i3) + "\u2026";
        }
        SpannableString spannableString = new SpannableString(str);
        for (String str2 : list) {
            String str3 = str;
            int i18 = 0;
            while (true) {
                int Lh2 = Lh(str2, str3);
                if (Lh2 >= 0) {
                    int length4 = str2.length() + Lh2;
                    int i19 = Lh2 + i18;
                    i18 += length4;
                    spannableString.setSpan(new ForegroundColorSpan(Jh()), i19, i18, 33);
                    str3 = str3.substring(length4);
                }
            }
        }
        return spannableString;
    }

    public static int Hh(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception e16) {
            int Jh = Jh();
            if (QLog.isColorLevel()) {
                QLog.d(f180775b0, 2, "pretty_account color parse:" + e16);
            }
            return Jh;
        }
    }

    private static String Ih(String str, List<String> list) {
        for (String str2 : list) {
            if (str.indexOf(str2) >= 0) {
                return str2;
            }
            if (str2.toLowerCase().indexOf(str2.toLowerCase()) > 0) {
                return str2;
            }
        }
        return null;
    }

    public static int Jh() {
        if ("1103".equals(ThemeUtil.curThemeId)) {
            return -16760704;
        }
        return -16734752;
    }

    private static int Lh(String str, String str2) {
        int indexOf = str2.indexOf(str);
        if (indexOf >= 0) {
            return indexOf;
        }
        return str2.toLowerCase().indexOf(str.toLowerCase());
    }

    @Deprecated
    public void Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        this.L = null;
        this.X = null;
        ViewFactory.f().b();
        g gVar = this.V;
        if (gVar != null) {
            gVar.h();
            this.V = null;
        }
        IFaceDecoder iFaceDecoder = this.M;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        StatusManager statusManager = this.P;
        if (statusManager != null) {
            statusManager.b0(this.Y);
        }
    }

    public void Bh(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Boolean.valueOf(z16));
        }
    }

    protected void Ch(f fVar, RichStatus richStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) fVar, (Object) richStatus);
            return;
        }
        fVar.f180802l = richStatus;
        if (richStatus != null && !richStatus.isEmpty()) {
            if (!TextUtils.isEmpty(richStatus.actionText)) {
                fVar.f180799i = richStatus.actionId;
                return;
            } else {
                fVar.f180799i = 0;
                return;
            }
        }
        fVar.f180799i = 0;
    }

    public BaseActivity Gh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (BaseActivity) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.U;
    }

    public SpannableString Kh(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpannableString) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
        }
        SpannableString spannableString = this.R.get(i3 + ":" + str);
        if (spannableString == null) {
            return new SpannableString(str);
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Mh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        int i3 = this.E;
        if (i3 != 0 && i3 != 3 && i3 != 4) {
            if (i3 == 2) {
                return 80000002;
            }
            if (i3 == 5) {
                return 80000003;
            }
            return 80000001;
        }
        return 80000000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Nh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        g gVar = new g(this.S);
        this.V = gVar;
        gVar.p(this.W);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.S.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.S);
        this.M = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.Q = (int) al.a(BaseApplication.getContext(), 12.0f);
        StatusManager statusManager = (StatusManager) this.S.getManager(QQManagerFactory.STATUS_MANAGER);
        this.P = statusManager;
        if (statusManager != null) {
            statusManager.C(this.Y);
        }
    }

    protected void Oh(AccountSearchPb$record accountSearchPb$record) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) accountSearchPb$record);
        } else {
            this.Z = accountSearchPb$record;
            AddFriendActivity.startProfileCardActivity(Gh(), new SearchResultItem(accountSearchPb$record), this.S, true, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Ph(TextView textView, BaseActivity baseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this, (Object) textView, (Object) baseActivity)).intValue();
        }
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return (textView.getMeasuredHeight() / BaseAIOUtils.f(18.0f, baseActivity.getResources())) + ((int) ((textView.getMeasuredWidth() * (FontSettingManager.getFontLevel() / 16.0f)) / BaseAIOUtils.f(260.0f, baseActivity.getResources())));
    }

    protected void Qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Handler handler = this.X;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
    }

    protected void Rh(int i3, Object obj, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), obj, Integer.valueOf(i16), str);
            return;
        }
        Handler handler = this.X;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1, str));
        }
    }

    public SpannableString Sh(int i3, String str, SpannableString spannableString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SpannableString) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, spannableString);
        }
        return this.R.put(i3 + ":" + str, spannableString);
    }

    protected void Th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    @Deprecated
    public void Uh(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) handler);
        } else {
            this.T = handler;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (Gh() != null) {
            Zh(ViewFactory.f().a(80000006, Gh(), true, this.M, null));
        }
    }

    protected void Wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else if (Gh() != null) {
            Zh(ViewFactory.f().a(80000007, Gh(), true, this.M, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xh(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = HardCodeUtil.qqStr(R.string.f172665t64);
        }
        QQToast.makeText(BaseApplication.getContext(), str, 0).show(getTitleBarHeight());
    }

    protected void Yh(List<x> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
        } else if (Gh() != null) {
            Zh(ViewFactory.f().a(80000008, Gh(), true, this.M, list));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Zh(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
        } else if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.J.removeAllViews();
            this.J.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(int i3, AccountSearchPb$record accountSearchPb$record, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), accountSearchPb$record, Integer.valueOf(i16));
        } else {
            bi(i3, accountSearchPb$record, i16, "");
        }
    }

    protected void bi(int i3, AccountSearchPb$record accountSearchPb$record, int i16, String str) {
        String str2;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), accountSearchPb$record, Integer.valueOf(i16), str);
            return;
        }
        if (Gh() == null) {
            return;
        }
        switch (i3) {
            case 80000000:
                Oh(accountSearchPb$record);
                return;
            case 80000001:
                if (accountSearchPb$record.bytes_join_group_auth.get() != null) {
                    str2 = accountSearchPb$record.bytes_join_group_auth.get().toStringUtf8();
                } else {
                    str2 = null;
                }
                String valueOf = String.valueOf(accountSearchPb$record.code.get());
                if (i16 > 0) {
                    i17 = i16;
                } else {
                    i17 = 2;
                }
                Bundle d16 = aq.d(valueOf, str2, i17);
                d16.putInt("exposureSource", 3);
                d16.putString("keyword", this.D);
                d16.putBoolean("isFromNative", true);
                d16.putInt("t_s_f", 1000);
                d16.putString("trans_info", ai.a(this.D, str, 1));
                d16.putString(AppConstants.Key.TROOP_INFO_NAME, accountSearchPb$record.name.get());
                TroopUtils.I(Gh(), d16, 2);
                return;
            case 80000002:
                com.tencent.mobileqq.activity.contact.addcontact.publicaccount.a.a(this.S, Gh(), accountSearchPb$record.class_index.get(), String.valueOf(accountSearchPb$record.uin.get()), String.valueOf(accountSearchPb$record.uin.get()), accountSearchPb$record.account_flag.get(), accountSearchPb$record.name.get(), 4);
                IPublicAccountSearchRecommendManager iPublicAccountSearchRecommendManager = (IPublicAccountSearchRecommendManager) QRoute.api(IPublicAccountSearchRecommendManager.class);
                QQAppInterface qQAppInterface = this.S;
                String valueOf2 = String.valueOf(accountSearchPb$record.uin.get());
                String str3 = accountSearchPb$record.name.get();
                if (accountSearchPb$record.class_index.get() != 1) {
                    z16 = true;
                }
                iPublicAccountSearchRecommendManager.updatePublicAccountSearchHistoryItem(qQAppInterface, valueOf2, str3, z16);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // androidx.fragment.app.Fragment
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (View) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.J;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) activity);
        } else {
            super.onAttach(activity);
            this.U = (BaseActivity) activity;
        }
    }

    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        zh();
        Gh().addObserver(this.f180776a0);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            view = (View) iPatchRedirector.redirect((short) 35, this, layoutInflater, viewGroup, bundle);
        } else {
            LinearLayout linearLayout = new LinearLayout(Gh());
            this.J = linearLayout;
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.J.setOrientation(1);
            this.J.setClickable(true);
            XListView xListView = new XListView(Gh());
            this.K = xListView;
            xListView.setCacheColorHint(0);
            this.K.setDivider(null);
            this.K.setSelector(R.drawable.f162601b70);
            this.K.setOnScrollListener(this);
            this.K.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            view = this.J;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f180775b0, 2, "onDecodeTaskCompleted type = " + i16 + ", uin = " + str);
        }
        if (bitmap != null && this.N == 0) {
            int childCount = this.K.getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                Object tag = this.K.getChildAt(i17).getTag();
                if (tag != null && (tag instanceof f)) {
                    f fVar = (f) tag;
                    if (fVar.f180796f.equals(str) || str.equals(fVar.f180797g)) {
                        if (i16 == 4) {
                            if (80000001 == fVar.f180800j) {
                                fVar.f180791a.setImageBitmap(bitmap);
                                return;
                            }
                        } else {
                            fVar.f180791a.setImageBitmap(bitmap);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        super.onDestroy();
        Ah();
        Gh().removeObserver(this.f180776a0);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
        } else {
            super.onDetach();
            this.U = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onResume();
        if (this.M.isPausing()) {
            this.M.resume();
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) absListView, i3);
            return;
        }
        this.N = i3;
        if (i3 != 0) {
            this.M.cancelPendingRequests();
            this.M.pause();
        } else if (this.M.isPausing()) {
            this.M.resume();
            BaseAdapter baseAdapter = this.I;
            if (baseAdapter != null) {
                baseAdapter.notifyDataSetChanged();
            }
        }
        if (Gh() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) Gh().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(Gh().getWindow().getDecorView().getWindowToken(), 0);
            }
        }
    }

    public void sh(ArrayList<un2.a> arrayList) {
        String str;
        SpannableString Eh;
        String valueOf;
        SpannableString Eh2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
            return;
        }
        try {
            Iterator<un2.a> it = arrayList.iterator();
            while (it.hasNext()) {
                un2.a next = it.next();
                List<String> list = next.f439271d;
                for (AccountSearchPb$record accountSearchPb$record : next.f439272e) {
                    String str2 = accountSearchPb$record.name.get();
                    if (next.f439268a == 80000003) {
                        Eh = SpannableString.valueOf(SearchUtils.Z(str2, (ArrayList) list, 255));
                    } else {
                        Eh = Eh(str2, list);
                    }
                    Sh(next.f439268a, str2, Eh);
                    String str3 = null;
                    switch (next.f439268a) {
                        case 80000000:
                            valueOf = String.valueOf(accountSearchPb$record.uin.get());
                            break;
                        case 80000001:
                            valueOf = String.valueOf(accountSearchPb$record.code.get());
                            break;
                        case 80000002:
                        case 80000003:
                            valueOf = String.valueOf(accountSearchPb$record.brief.get());
                            break;
                        default:
                            valueOf = null;
                            break;
                    }
                    if (!TextUtils.isEmpty(valueOf)) {
                        if (accountSearchPb$record.uint32_richflag1_59.get() == 1) {
                            LhLogoResources lhLogoResources = PrettyAccountUtil.getLhLogoResources(accountSearchPb$record.uint32_richflag4_409.get());
                            if (lhLogoResources != null) {
                                str3 = lhLogoResources.lightColor;
                            }
                            Eh2 = Dh(str3, valueOf, list);
                        } else {
                            Eh2 = Eh(valueOf, list);
                        }
                        Sh(next.f439268a, valueOf, Eh2);
                    }
                    if (next.f439268a == 80000000 && !TextUtils.isEmpty(accountSearchPb$record.mobile.get())) {
                        String str4 = accountSearchPb$record.mobile.get();
                        Sh(next.f439268a, str4, Eh(str4, list));
                    }
                }
                AccountSearchPb$hotwordrecord accountSearchPb$hotwordrecord = next.f439273f;
                if (accountSearchPb$hotwordrecord != null && accountSearchPb$hotwordrecord.hotword.has()) {
                    String str5 = accountSearchPb$hotwordrecord.hotword.get();
                    Sh(next.f439268a, str5, SpannableString.valueOf(SearchUtils.Z(str5, (ArrayList) list, 255)));
                }
                List<AccountSearchPb$ResultItem> list2 = next.f439276i;
                if (list2 != null && list2.size() > 0) {
                    for (AccountSearchPb$ResultItem accountSearchPb$ResultItem : list2) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(accountSearchPb$ResultItem.uin.get())), f180775b0);
                        if (friendsSimpleInfoWithUid == null) {
                            str = "";
                        } else {
                            str = friendsSimpleInfoWithUid.p();
                        }
                        if (!TextUtils.isEmpty(str)) {
                            Sh(next.f439268a, str, Eh(str, list));
                        }
                        String stringUtf8 = accountSearchPb$ResultItem.name.get().toStringUtf8();
                        if (!TextUtils.isEmpty(stringUtf8)) {
                            Sh(next.f439268a, stringUtf8, Fh(stringUtf8, list, 18));
                        }
                        String stringUtf82 = accountSearchPb$ResultItem.nick_name.get().toStringUtf8();
                        if (!TextUtils.isEmpty(stringUtf82)) {
                            Sh(next.f439268a, stringUtf82, Eh(stringUtf82, list));
                        }
                        String stringUtf83 = accountSearchPb$ResultItem.summary.get().toStringUtf8();
                        if (!TextUtils.isEmpty(stringUtf83)) {
                            Sh(next.f439268a, stringUtf83, Eh(stringUtf83, list));
                        }
                        String stringUtf84 = accountSearchPb$ResultItem.phtot_update.get().toStringUtf8();
                        if (!TextUtils.isEmpty(stringUtf84)) {
                            Sh(next.f439268a, stringUtf84, Fh(stringUtf84, list, 18));
                        }
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f180775b0, 2, "", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoadingDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (Gh() != null) {
            if (this.L == null) {
                this.L = new h(Gh());
            }
            if (!Gh().isFinishing()) {
                this.L.show();
            }
        }
    }

    protected boolean th(ArrayList<un2.a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String uh(f fVar, AccountSearchPb$record accountSearchPb$record) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this, (Object) fVar, (Object) accountSearchPb$record);
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = accountSearchPb$record.age.get();
        int i16 = accountSearchPb$record.sex.get();
        int i17 = 1;
        if (i16 != 1) {
            if (i16 != 2) {
                i17 = -1;
            }
        } else {
            i17 = 0;
        }
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).showGenderAge(fVar.f180794d, i17, i3, sb5);
        StringBuilder sb6 = new StringBuilder();
        if (!TextUtils.isEmpty(accountSearchPb$record.province_name.get())) {
            sb6.append(accountSearchPb$record.province_name.get());
            sb6.append(" ");
        }
        if (!TextUtils.isEmpty(accountSearchPb$record.city_name.get())) {
            sb6.append(accountSearchPb$record.city_name.get());
        }
        if (sb6.length() == 0 && !TextUtils.isEmpty(accountSearchPb$record.country_name.get())) {
            sb6.append(accountSearchPb$record.country_name.get());
        }
        fVar.f180795e.setText(sb6.toString());
        sb5.append(sb6.toString());
        Ch(fVar, accountSearchPb$record.richStatus);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String vh(f fVar, AccountSearchPb$record accountSearchPb$record) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this, (Object) fVar, (Object) accountSearchPb$record);
        }
        StringBuilder sb5 = new StringBuilder();
        fVar.f180794d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        fVar.f180794d.setCompoundDrawablePadding(0);
        fVar.f180794d.setBackgroundResource(0);
        if (accountSearchPb$record.video_account.has() && accountSearchPb$record.video_account.get() == 1) {
            Drawable drawable = getResources().getDrawable(R.drawable.br8);
            ThemeUtil.setThemeFilter(drawable, ThemeUtil.curThemeId);
            fVar.f180792b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            fVar.f180792b.setCompoundDrawablePadding((int) al.a(BaseApplication.getContext(), 6.0f));
        } else if (accountSearchPb$record.flag.has() && accountSearchPb$record.flag.get() == 1) {
            Drawable drawable2 = getResources().getDrawable(R.drawable.br7);
            ThemeUtil.setThemeFilter(drawable2, ThemeUtil.curThemeId);
            fVar.f180792b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
            fVar.f180792b.setCompoundDrawablePadding((int) al.a(BaseApplication.getContext(), 6.0f));
        } else {
            fVar.f180792b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if (accountSearchPb$record.class_index.has() && accountSearchPb$record.class_index.get() == 1) {
            if (accountSearchPb$record.class_name.has()) {
                fVar.f180794d.setText(accountSearchPb$record.class_name.get());
                sb5.append(accountSearchPb$record.class_name.get());
            }
            if (accountSearchPb$record.brief.has()) {
                fVar.f180795e.setText(Kh(80000002, accountSearchPb$record.brief.get()));
                sb5.append(accountSearchPb$record.brief.get());
            }
        } else if (accountSearchPb$record.class_index.has()) {
            fVar.f180794d.setVisibility(8);
            if (accountSearchPb$record.brief.has()) {
                fVar.f180795e.setText(Kh(80000002, accountSearchPb$record.brief.get()));
                sb5.append(fVar.f180795e.getText());
            }
        }
        fVar.f180794d.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.skin_gray2));
        return sb5.toString();
    }

    public void wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        LinearLayout linearLayout = this.J;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    public void xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f180775b0, 2, "clearHighLightString");
        }
        this.R.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        h hVar = this.L;
        if (hVar != null) {
            hVar.dismiss();
        }
    }

    @Deprecated
    public void zh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        this.S = (QQAppInterface) Gh().getAppRuntime();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.E = arguments.getInt("from_key", 0);
            this.F = arguments.getInt("user_source", 0);
            this.D = arguments.getString("last_key_words");
        }
        Nh();
        if (arguments != null && !TextUtils.isEmpty(arguments.getString("start_search_key")) && !arguments.getBoolean("auto_add_and_prohibit_auto_search", false)) {
            Bh(arguments.getString("start_search_key"), false);
        }
    }
}
