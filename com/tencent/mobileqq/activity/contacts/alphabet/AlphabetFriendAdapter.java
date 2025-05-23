package com.tencent.mobileqq.activity.contacts.alphabet;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.util.bp;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlphabetFriendAdapter extends com.tencent.mobileqq.activity.contacts.alphabet.a implements c.b, View.OnLongClickListener {
    static IPatchRedirector $redirector_;
    private Context C;
    private final StatusManager D;
    private final FriendsManager E;
    private int F;
    private final View.OnClickListener G;
    public LinkedHashMap<String, List<c>> H;
    public int[] I;
    public String[] J;
    private final int K;
    private IndexBar L;
    private View M;
    private e N;
    private boolean P;
    private int Q;
    private Comparator<c> R;

    /* renamed from: m, reason: collision with root package name */
    private QQAppInterface f181401m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Comparator<c> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlphabetFriendAdapter.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) cVar2)).intValue();
            }
            if (cVar == null && cVar2 == null) {
                return 0;
            }
            if (cVar == null && cVar2 != null) {
                return -1;
            }
            if (cVar != null && cVar2 == null) {
                return 1;
            }
            String str = cVar.f181410b;
            String str2 = cVar2.f181410b;
            if (str == null && str2 == null) {
                return 0;
            }
            if (str == null && str2 != null) {
                return -1;
            }
            if (str != null && str2 == null) {
                return 1;
            }
            int length = str.length();
            int length2 = str2.length();
            int min = Math.min(length, length2);
            for (int i3 = 0; i3 < min; i3++) {
                char charAt = str.charAt(i3);
                char charAt2 = str2.charAt(i3);
                if (charAt != charAt2) {
                    ChnToSpell.a g16 = ChnToSpell.g(charAt);
                    ChnToSpell.a g17 = ChnToSpell.g(charAt2);
                    int i16 = g16.f306904a;
                    int i17 = g17.f306904a;
                    if (i16 == i17) {
                        return g16.f306905b.compareTo(g17.f306905b);
                    }
                    return i16 - i17;
                }
            }
            if (length < length2) {
                return -1;
            }
            if (length <= length2) {
                return 0;
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f181405d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Friends f181406e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f181407f;

        b(boolean z16, Friends friends, ActionSheet actionSheet) {
            this.f181405d = z16;
            this.f181406e = friends;
            this.f181407f = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AlphabetFriendAdapter.this, Boolean.valueOf(z16), friends, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(AlphabetFriendAdapter.this.C)) {
                QQToast.makeText(AlphabetFriendAdapter.this.C, 1, R.string.b3j, 0).show();
            } else {
                FriendListHandler friendListHandler = (FriendListHandler) AlphabetFriendAdapter.this.f181401m.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                if (this.f181405d) {
                    friendListHandler.setSpecialCareSwitch(1, new String[]{this.f181406e.uin}, new boolean[]{false});
                } else {
                    friendListHandler.setSpecialCareSwitch(1, new String[]{this.f181406e.uin}, new boolean[]{true});
                }
            }
            this.f181407f.superDismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f181409a;

        /* renamed from: b, reason: collision with root package name */
        public String f181410b;

        /* renamed from: c, reason: collision with root package name */
        public String f181411c;

        /* renamed from: d, reason: collision with root package name */
        public String f181412d;

        /* renamed from: e, reason: collision with root package name */
        public String f181413e;

        /* renamed from: f, reason: collision with root package name */
        public String f181414f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f181415g;

        /* renamed from: h, reason: collision with root package name */
        public BuddyListFriends f181416h;

        public c(BuddyListFriends buddyListFriends) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) buddyListFriends);
                return;
            }
            this.f181411c = "";
            this.f181412d = "";
            this.f181413e = "";
            this.f181414f = "";
            this.f181416h = buddyListFriends;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f181410b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static class d extends k {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        public int f181417i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f181418m;

        public d(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.f181417i = 1;
                this.f181418m = (TextView) view.findViewById(R.id.k8u);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static class e implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<AlphabetFriendAdapter> f181419d;

        public e(AlphabetFriendAdapter alphabetFriendAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) alphabetFriendAdapter);
            } else {
                this.f181419d = new WeakReference<>(alphabetFriendAdapter);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                AlphabetFriendAdapter alphabetFriendAdapter = this.f181419d.get();
                if (alphabetFriendAdapter != null) {
                    z16 = alphabetFriendAdapter.onLongClick(view);
                } else {
                    z16 = false;
                }
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    public AlphabetFriendAdapter(Context context, QQAppInterface qQAppInterface, XListView xListView, IndexBar indexBar, View.OnClickListener onClickListener) {
        super(context, qQAppInterface, xListView, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, xListView, indexBar, onClickListener);
            return;
        }
        this.F = 0;
        this.H = new LinkedHashMap<>();
        this.I = new int[0];
        this.J = new String[0];
        this.P = true;
        this.Q = 0;
        this.R = new a();
        this.f181401m = qQAppInterface;
        this.C = context;
        this.G = onClickListener;
        this.L = indexBar;
        this.D = (StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
        this.E = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.K = (int) al.a(this.C, 12.0f);
        this.N = new e(this);
    }

    private void j(c cVar, LinkedHashMap<String, List<c>> linkedHashMap) {
        String str;
        String str2 = cVar.f181411c;
        String str3 = "#";
        if (str2 == null || str2.length() == 0) {
            str = "#";
        } else {
            str = cVar.f181411c.substring(0, 1);
        }
        char charAt = str.charAt(0);
        if (('A' <= charAt && charAt <= 'Z') || ('a' <= charAt && charAt <= 'z')) {
            str3 = str.toUpperCase();
        }
        if (linkedHashMap.get(str3) == null) {
            linkedHashMap.put(str3, new ArrayList());
        }
        linkedHashMap.get(str3).add(cVar);
        if (cVar.f181415g) {
            if (linkedHashMap.get("\u2605") == null) {
                linkedHashMap.put("\u2605", new ArrayList());
            }
            linkedHashMap.get("\u2605").add(cVar);
        }
    }

    private Object[] l(List<c> list, Comparator<c> comparator) {
        LinkedHashMap<String, List<c>> linkedHashMap = new LinkedHashMap<>();
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            j(it.next(), linkedHashMap);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (linkedHashMap.get("\u2605") != null) {
            List<c> list2 = linkedHashMap.get("\u2605");
            try {
                Collections.sort(list2, comparator);
            } catch (IllegalArgumentException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AlphabetFriendAdapter", 2, "INDEX_STAR sort error " + e16.toString());
                }
            }
            linkedHashMap2.put("\u2605", list2);
        }
        for (char c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c16 <= 'Z'; c16 = (char) (c16 + 1)) {
            if (linkedHashMap.get(String.valueOf(c16)) != null) {
                List<c> list3 = linkedHashMap.get(String.valueOf(c16));
                try {
                    Collections.sort(list3, comparator);
                } catch (IllegalArgumentException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AlphabetFriendAdapter", 2, "A Z sort error " + e17.toString());
                    }
                }
                linkedHashMap2.put(String.valueOf(c16), list3);
            }
        }
        if (linkedHashMap.get("#") != null) {
            List<c> list4 = linkedHashMap.get("#");
            try {
                Collections.sort(list4, comparator);
            } catch (IllegalArgumentException e18) {
                if (QLog.isColorLevel()) {
                    QLog.e("AlphabetFriendAdapter", 2, "# sort error " + e18.toString() + ",list = " + list4);
                }
            }
            linkedHashMap2.put("#", list4);
        }
        linkedHashMap.clear();
        int size = linkedHashMap2.keySet().size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        Iterator it5 = linkedHashMap2.keySet().iterator();
        if (size == 0) {
            return null;
        }
        iArr[0] = 0;
        for (int i3 = 1; i3 < size; i3++) {
            iArr[i3] = iArr[i3] + iArr[i3 - 1] + ((List) linkedHashMap2.get(it5.next())).size() + 1;
        }
        Iterator it6 = linkedHashMap2.keySet().iterator();
        int i16 = 0;
        while (it6.hasNext()) {
            strArr[i16] = (String) it6.next();
            i16++;
        }
        return new Object[]{linkedHashMap2, iArr, strArr};
    }

    private String n(Friends friends, BuddyListFriends.a aVar) {
        FriendsManager friendsManager;
        boolean z16;
        RichStatus richStatus;
        boolean z17;
        boolean z18;
        String str;
        int i3;
        boolean z19;
        String str2 = null;
        if (this.D == null || (friendsManager = this.E) == null || this.C == null) {
            return null;
        }
        ExtensionInfo H = friendsManager.H(friends.uin);
        int i16 = 0;
        if (H != null && !TextUtils.isEmpty(H.feedContent)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (H != null) {
            if (this.F != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            richStatus = com.tencent.mobileqq.richstatus.c.f(H, z19);
        } else {
            richStatus = null;
        }
        if (richStatus != null && richStatus != RichStatus.getEmptyStatus() && !richStatus.isEmpty()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && !TextUtils.isEmpty(richStatus.actionText)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16 && (H.feedTime > H.richTime || !z17)) {
            str = new String(H.feedContent);
            aVar.f181512i.setCompoundDrawables(null, null);
            if (H.feedType == 2) {
                aVar.D.setVisibility(0);
                if (!TextUtils.isEmpty(H.feedPhotoUrl)) {
                    bp.a(aVar.D, H.feedPhotoUrl, this.C.getResources().getDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                } else {
                    aVar.D.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                }
                aVar.E.setVisibility(8);
                aVar.F.setVisibility(8);
            } else {
                aVar.E.setVisibility(0);
                ImageView imageView = aVar.E;
                if (H.feedType == 1) {
                    i3 = R.drawable.f162391gm3;
                } else {
                    i3 = R.drawable.f162389gm1;
                }
                imageView.setBackgroundResource(i3);
                URLImageView uRLImageView = aVar.F;
                if (!H.feedHasPhoto) {
                    i16 = 8;
                }
                uRLImageView.setVisibility(i16);
                aVar.D.setVisibility(8);
                aVar.D.setImageDrawable(null);
            }
        } else {
            if (z18) {
                richStatus.enableSummaryCached = friends.isFriend();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.C.getResources(), this.D.K(richStatus.actionId, 200));
                int i17 = this.K;
                bitmapDrawable.setBounds(0, 0, Math.round(((bitmapDrawable.getIntrinsicWidth() * 1.0f) / bitmapDrawable.getIntrinsicHeight()) * i17), i17);
                aVar.f181512i.setCompoundDrawables(bitmapDrawable, null);
            } else if (!z17) {
                richStatus = RichStatus.getEmptyStatus();
                aVar.f181512i.setCompoundDrawables(null, null);
            }
            String actionAndData = richStatus.getActionAndData();
            String plainText = richStatus.getPlainText();
            aVar.F.setVisibility(8);
            aVar.E.setVisibility(8);
            aVar.D.setVisibility(8);
            aVar.D.setImageDrawable(null);
            str2 = actionAndData;
            str = plainText;
        }
        if (H == null) {
            aVar.F.setVisibility(8);
            aVar.E.setVisibility(8);
        }
        aVar.f181512i.setExtendText(str2, 1);
        aVar.f181512i.setText(str);
        return str;
    }

    private List<c> o() {
        Context context;
        c cVar;
        ArrayList arrayList = new ArrayList();
        if (this.f181401m != null && (context = this.C) != null) {
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                if (QLog.isColorLevel()) {
                    QLog.e("AlphabetFriendAdapter", 2, "getAlphabetFriend Activity is finishing ");
                }
                return arrayList;
            }
            FriendsManager friendsManager = (FriendsManager) this.f181401m.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (friendsManager == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("AlphabetFriendAdapter", 2, "FriendManager is null");
                }
                return arrayList;
            }
            List<Friends> z16 = friendsManager.z();
            if (z16 == null) {
                return arrayList;
            }
            if (com.tencent.relation.common.utils.e.f364767a.a()) {
                QLog.d("AlphabetFriendAdapter", 1, "loadData filter robot");
                Iterator<Friends> it = z16.iterator();
                while (it.hasNext()) {
                    Friends next = it.next();
                    if (next.robotVersion != 0 || next.robotType != 0) {
                        it.remove();
                    }
                }
            }
            Iterator<Friends> it5 = z16.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Friends next2 = it5.next();
                if (this.f181401m == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AlphabetFriendAdapter", 2, "getAlphabetFriend mApp is null ");
                    }
                } else {
                    Context context2 = this.C;
                    if ((context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
                        if (QLog.isColorLevel()) {
                            QLog.e("AlphabetFriendAdapter", 2, "getAlphabetFriend Activity is finishing ");
                        }
                    } else {
                        com.tencent.mobileqq.activity.contacts.base.c b16 = com.tencent.mobileqq.activity.contacts.base.b.b(0, next2, this.f181401m, this.C);
                        if (b16 != null) {
                            b16.m(this);
                            cVar = m((BuddyListFriends) b16);
                            if (cVar != null && (b16.k() & 1) == 1) {
                                cVar.f181415g = true;
                            }
                        } else {
                            cVar = null;
                        }
                        if (cVar != null) {
                            arrayList.add(cVar);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private void t() {
        XListView xListView = this.f181449e;
        if (xListView == null) {
            return;
        }
        int childCount = xListView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Object tag = this.f181449e.getChildAt(i3).getTag();
            if (tag != null && (tag instanceof BuddyListFriends.a)) {
                BuddyListFriends.a aVar = (BuddyListFriends.a) tag;
                if (TextUtils.isEmpty(aVar.f181512i.getText().toString())) {
                    Object obj = aVar.f181513m;
                    if (obj instanceof Friends) {
                        n((Friends) obj, aVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.L != null) {
            if (q() >= 5) {
                this.L.setLetters(this.J);
            } else {
                this.L.setLetters(null);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c.b
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.F;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public void configDividerView(View view, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) view, i3);
            return;
        }
        int binarySearch = Arrays.binarySearch(this.I, i3);
        if (binarySearch < 0) {
            binarySearch = (-(binarySearch + 1)) - 1;
        }
        if (binarySearch < this.J.length && binarySearch >= 0 && (view instanceof TextView)) {
            TextView textView = (TextView) view;
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), 0, 0);
            String str = this.J[binarySearch];
            if (str.equals("\u2605")) {
                textView.setText(HardCodeUtil.qqStr(R.string.jd8));
            } else {
                textView.setText(str);
            }
            textView.setTextColor(this.C.getResources().getColorStateList(R.color.qui_common_brand_standard));
            if (ThemeUtil.isNowThemeIsSimple(this.f181401m, false, null)) {
                if (ThemeUtil.isNowThemeIsNight(this.f181401m, false, null)) {
                    i16 = -1;
                } else {
                    i16 = -16777216;
                }
                textView.setTextColor(i16);
            }
            Resources resources = view.getResources();
            if (QUITokenResUtil.useQUIToken() && resources != null) {
                view.setBackground(resources.getDrawable(R.drawable.qui_common_fill_light_primary_bg, null));
            }
            IndexBar indexBar = this.L;
            if (indexBar != null) {
                indexBar.setChooseIndex(binarySearch);
            }
            textView.setTypeface(Typeface.SANS_SERIF);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        super.destroy();
        this.C = null;
        this.f181401m = null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<c> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        if (this.I.length == 0 || this.H.size() == 0) {
            return 0;
        }
        String[] strArr = this.J;
        if (strArr.length == 0 || (list = this.H.get(strArr[strArr.length - 1])) == null) {
            return 0;
        }
        return this.I[r1.length - 1] + list.size() + 1;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public int getDividerLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return QUITokenResUtil.getResId(R.layout.f168254qf, R.layout.fg8);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        int binarySearch = Arrays.binarySearch(this.I, i3);
        if (binarySearch >= 0) {
            return null;
        }
        return this.H.get(this.J[(-(binarySearch + 1)) - 1]).get((i3 - this.I[r0]) - 1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3)).intValue();
        }
        if (Arrays.binarySearch(this.I, i3) < 0) {
            return 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            view2 = view;
            view = (View) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            int binarySearch = Arrays.binarySearch(this.I, i3);
            if (getItemViewType(i3) == 1) {
                int i16 = (-(binarySearch + 1)) - 1;
                List<c> list = this.H.get(this.J[i16]);
                int i17 = (i3 - this.I[i16]) - 1;
                if (list != null && i17 < list.size()) {
                    BuddyListFriends buddyListFriends = list.get(i17).f181416h;
                    boolean z16 = buddyListFriends instanceof BuddyListFriends;
                    if (z16) {
                        buddyListFriends.u(1);
                    }
                    if (buddyListFriends == null) {
                        a16 = null;
                    } else {
                        a16 = buddyListFriends.a(0, i3, view, viewGroup, this.G);
                    }
                    if (a16 != null && z16) {
                        c((BuddyListFriends.a) a16.getTag(), null);
                        View.OnClickListener onClickListener = this.G;
                        if (onClickListener != null) {
                            a16.setOnClickListener(onClickListener);
                        }
                        a16.setOnLongClickListener(this.N);
                        view = a16;
                    }
                }
            } else {
                if (view == null) {
                    view = LayoutInflater.from(this.C).inflate(QUITokenResUtil.getResId(R.layout.f167802i1, R.layout.f167803e40), viewGroup, false);
                    view.setTag(new d(view));
                }
                if (!(view.getTag() instanceof d)) {
                    view = LayoutInflater.from(this.C).inflate(QUITokenResUtil.getResId(R.layout.f167802i1, R.layout.f167803e40), viewGroup, false);
                    view.setTag(new d(view));
                }
                d dVar = (d) view.getTag();
                String valueOf = String.valueOf(this.J[binarySearch]);
                if (!TextUtils.isEmpty(valueOf)) {
                    if (valueOf.equals("\u2605")) {
                        dVar.f181418m.setText(HardCodeUtil.qqStr(R.string.jd8));
                    } else {
                        dVar.f181418m.setText(valueOf);
                    }
                }
                if (AppSetting.f99565y) {
                    dVar.f181418m.setContentDescription(String.format(this.C.getString(R.string.aud), valueOf.toLowerCase()));
                }
            }
            view2 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public boolean isDividerView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, i3)).booleanValue();
        }
        if (Arrays.binarySearch(this.I, i3) >= 0) {
            return true;
        }
        return false;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        w(0);
        this.H.clear();
        this.I = new int[0];
        this.J = new String[0];
    }

    public c m(BuddyListFriends buddyListFriends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (c) iPatchRedirector.redirect((short) 23, (Object) this, (Object) buddyListFriends);
        }
        if (buddyListFriends != null && buddyListFriends.f181505e != null) {
            c cVar = new c(buddyListFriends);
            Friends friends = (Friends) buddyListFriends.f181505e;
            String friendNickWithAlias = friends.getFriendNickWithAlias();
            cVar.f181409a = friends.uin;
            cVar.f181410b = friendNickWithAlias;
            cVar.f181411c = ChnToSpell.d(friendNickWithAlias, 2);
            return cVar;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public boolean needHideDivider(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) view, i3)).booleanValue();
        }
        if (this.J.length <= 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Object tag;
        boolean z16;
        Object obj;
        int i3;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) view)).booleanValue();
        } else {
            boolean z17 = false;
            if (!u.a().b() && this.P && (tag = view.getTag()) != null) {
                if ((tag instanceof c.C7154c) && (obj = ((c.C7154c) tag).f181513m) != null && (obj instanceof Friends)) {
                    ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.C, null);
                    Friends friends = (Friends) obj;
                    SpecialCareInfo O = ((FriendsManager) this.f181401m.getManager(QQManagerFactory.FRIENDS_MANAGER)).O(friends.uin);
                    if (!this.f181401m.getCurrentUin().equals(friends.uin)) {
                        if (O != null && O.globalSwitch != 0) {
                            z17 = true;
                        }
                        if (z17) {
                            i3 = R.string.a9d;
                        } else {
                            i3 = R.string.a9e;
                        }
                        actionSheet.addButton(i3);
                        actionSheet.addCancelButton(R.string.cancel);
                        actionSheet.setOnButtonClickListener(new b(z17, friends, actionSheet));
                        try {
                            actionSheet.show();
                        } catch (Exception unused) {
                        }
                    }
                }
                z16 = true;
            }
            z16 = false;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.a, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) absListView, i3);
            return;
        }
        this.F = i3;
        super.onScrollStateChanged(absListView, i3);
        if (i3 == 0) {
            t();
        }
        if (i3 != 0) {
            ApngImage.pauseByTag(3);
        }
        if (i3 == 0) {
            ApngImage.playByTag(3);
        }
    }

    public int p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str)).intValue();
        }
        if (str == null) {
            return -1;
        }
        char charAt = str.charAt(0);
        if (this.J != null) {
            int i3 = 0;
            while (true) {
                String[] strArr = this.J;
                if (i3 < strArr.length) {
                    char charAt2 = strArr[i3].charAt(0);
                    if (charAt2 != "\u2605".charAt(0)) {
                        if (charAt == '#') {
                            i3 = this.J.length - 1;
                            break;
                        }
                        if (charAt <= charAt2) {
                            break;
                        }
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

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.Q;
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphabetFriendAdapter.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AlphabetFriendAdapter.this.s();
                    }
                }
            }, 16, null, true);
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(o());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("AlphabetFriendAdapter", 2, "loadData Exception = " + e16.toString());
            }
        }
        Object[] l3 = l(arrayList, this.R);
        ThreadManager.getUIHandler().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f181402d;

            {
                this.f181402d = arrayList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphabetFriendAdapter.this, (Object) arrayList);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    AlphabetFriendAdapter.this.w(this.f181402d.size());
                }
            }
        });
        if (l3 != null && l3.length >= 3) {
            if (l3.length >= 3) {
                ThreadManager.getUIHandler().post(new Runnable(l3) { // from class: com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Object[] f181403d;

                    {
                        this.f181403d = l3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphabetFriendAdapter.this, (Object) l3);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("AlphabetFriendAdapter", 2, "notifyDataSetChanged out ThreadManager");
                        }
                        AlphabetFriendAdapter alphabetFriendAdapter = AlphabetFriendAdapter.this;
                        Object[] objArr = this.f181403d;
                        alphabetFriendAdapter.H = (LinkedHashMap) objArr[0];
                        alphabetFriendAdapter.I = (int[]) objArr[1];
                        alphabetFriendAdapter.J = (String[]) objArr[2];
                        alphabetFriendAdapter.y();
                        AlphabetFriendAdapter.this.x();
                        AlphabetFriendAdapter.super.notifyDataSetChanged();
                    }
                });
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AlphabetFriendAdapter", 2, "constructHashStruct result == null!");
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphabetFriendAdapter.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AlphabetFriendAdapter", 2, "notifyDataSetChanged out ThreadManager");
                    }
                    AlphabetFriendAdapter.this.x();
                    AlphabetFriendAdapter.this.k();
                    AlphabetFriendAdapter.super.notifyDataSetChanged();
                }
            });
        }
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.P = z16;
        }
    }

    public void v(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            this.M = view;
        }
    }

    public void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.Q = i3;
        }
    }

    public void x() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        XListView xListView = this.f181449e;
        if (xListView == null || this.C == null || xListView.getFooterViewsCount() <= 0 || (view = this.M) == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.f164303rl);
        if (q() > 0) {
            textView.setText(this.C.getResources().getString(R.string.a__, Integer.valueOf(q())));
        } else {
            textView.setText("");
        }
    }
}
