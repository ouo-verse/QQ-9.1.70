package com.tencent.mobileqq.activity.contacts.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.mobileqq.activity.contacts.troop.a;
import com.tencent.mobileqq.adapter.ai;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.blocktroop.k;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ContactsTroopAdapter extends ai implements View.OnClickListener, View.OnLongClickListener, ExpandableListView.OnGroupClickListener, SwipPinnedHeaderExpandableListView.SwipListListener, AdapterView.OnItemLongClickListener {
    static IPatchRedirector $redirector_;
    protected List<Integer> C;
    protected List<Object> D;
    protected List<com.tencent.mobileqq.troop.adapter.contact.d> E;
    protected List<com.tencent.mobileqq.troop.adapter.contact.d> F;
    protected List<com.tencent.mobileqq.troop.adapter.contact.d> G;
    protected List<com.tencent.mobileqq.troop.adapter.contact.d> H;
    protected HashSet<Integer> I;
    protected SwipTextViewMenuBuilder J;
    public int K;
    private int L;
    private int M;
    private boolean N;
    protected n P;
    private QQCustomDialog Q;
    protected int[] R;
    protected int[] S;
    protected int[] T;
    private i U;
    private long V;
    com.tencent.mobileqq.troop.api.observer.a W;

    /* renamed from: i, reason: collision with root package name */
    protected QQAppInterface f181782i;

    /* renamed from: m, reason: collision with root package name */
    protected Context f181783m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class LoadTroopDiscussInfoSubRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        LoadTroopDiscussInfoSubRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsTroopAdapter.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            RecentUserProxy m3 = ContactsTroopAdapter.this.f181782i.getProxyManager().m();
            List<TroopInfo> sortedJoinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedTroopInfoFromCache();
            List<TroopInfo> sortedJoinedTopTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedTopTroopInfoFromCache();
            n nVar = (n) ContactsTroopAdapter.this.f181782i.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            ArrayList<DiscussionInfo> k3 = nVar.k();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            HashSet hashSet = new HashSet();
            boolean s16 = TroopUtils.s();
            if (!sortedJoinedTroopInfoFromCache.isEmpty()) {
                for (TroopInfo troopInfo : sortedJoinedTroopInfoFromCache) {
                    if (troopInfo != null && s16 && !TextUtils.isEmpty(troopInfo.discussUin) && troopInfo.discussUin.length() > 2) {
                        hashSet.add(troopInfo.discussUin);
                    }
                }
            }
            ContactsTroopAdapter.this.K(sortedJoinedTroopInfoFromCache);
            int i3 = 0;
            for (DiscussionInfo discussionInfo : k3) {
                if (discussionInfo != null && !TextUtils.isEmpty(discussionInfo.uin)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ContactsTroopAdapter", 2, "load data asyncLoadTroopListAndNotifyUi discussion : " + discussionInfo);
                    }
                    if (!hashSet.contains(discussionInfo.uin)) {
                        if (!TextUtils.isEmpty(discussionInfo.discussionName)) {
                            arrayList.add(discussionInfo);
                        } else if (i3 >= 40) {
                            arrayList.add(discussionInfo);
                        } else if (ContactsTroopAdapter.this.P.q(discussionInfo.uin) > 0) {
                            arrayList.add(discussionInfo);
                            i3++;
                        } else {
                            i3++;
                            QLog.d("ContactsTroopAdapter", 1, "load data asyncLoadTroopListAndNotifyUi discussion skiped : " + discussionInfo);
                        }
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                DiscussionInfo discussionInfo2 = (DiscussionInfo) it.next();
                RecentUser findRecentUserByUin = m3.findRecentUserByUin(discussionInfo2.uin, 3000);
                RecentUserProxy recentUserProxy = m3;
                Iterator it5 = it;
                discussionInfo2.lastMsgTime = findRecentUserByUin.lastmsgtime;
                if (findRecentUserByUin.showUpTime != 0) {
                    arrayList2.add(discussionInfo2);
                }
                m3 = recentUserProxy;
                it = it5;
            }
            RecentUserProxy recentUserProxy2 = m3;
            QLog.d("ContactsTroopAdapter", 1, "load data asyncLoadTroopListAndNotifyUi count: " + i3 + "  org_discussions.size:" + k3.size() + "  discussions.size:" + arrayList.size());
            UpdateAfterLoadDataUIRunnable updateAfterLoadDataUIRunnable = new UpdateAfterLoadDataUIRunnable();
            updateAfterLoadDataUIRunnable.f181784d = sortedJoinedTroopInfoFromCache;
            updateAfterLoadDataUIRunnable.f181785e = sortedJoinedTopTroopInfoFromCache;
            updateAfterLoadDataUIRunnable.f181786f = arrayList;
            updateAfterLoadDataUIRunnable.f181787h = arrayList2;
            ThreadManager.getUIHandler().post(updateAfterLoadDataUIRunnable);
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105915", false)) {
                Iterator it6 = hashSet.iterator();
                while (it6.hasNext()) {
                    nVar.c(recentUserProxy2, (String) it6.next());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class UpdateAfterLoadDataUIRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        List<TroopInfo> f181784d;

        /* renamed from: e, reason: collision with root package name */
        List<TroopInfo> f181785e;

        /* renamed from: f, reason: collision with root package name */
        List<DiscussionInfo> f181786f;

        /* renamed from: h, reason: collision with root package name */
        List<DiscussionInfo> f181787h;

        protected UpdateAfterLoadDataUIRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsTroopAdapter.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                j3 = System.currentTimeMillis();
            } else {
                j3 = 0;
            }
            ContactsTroopAdapter.this.C.clear();
            ContactsTroopAdapter.this.E.clear();
            ContactsTroopAdapter.this.G.clear();
            ContactsTroopAdapter.this.F.clear();
            ContactsTroopAdapter.this.D.clear();
            ContactsTroopAdapter.this.H.clear();
            ContactsTroopAdapter.this.D.addAll(this.f181785e);
            ContactsTroopAdapter.this.D.addAll(this.f181787h);
            for (TroopInfo troopInfo : this.f181784d) {
                int troopMaskPriority = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMaskPriority(troopInfo.troopuin);
                if (troopInfo.isQidianPrivateTroop()) {
                    ContactsTroopAdapter.this.H.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
                } else if (troopInfo.isOwner()) {
                    ContactsTroopAdapter.this.E.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
                } else if (troopInfo.isAdmin()) {
                    ContactsTroopAdapter.this.F.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
                } else {
                    ContactsTroopAdapter.this.G.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
                }
            }
            for (DiscussionInfo discussionInfo : this.f181786f) {
                if (ContactsTroopAdapter.this.f181782i.getCurrentUin().equals(discussionInfo.ownerUin)) {
                    ContactsTroopAdapter.this.E.add(new com.tencent.mobileqq.troop.adapter.contact.d(1, discussionInfo));
                } else {
                    ContactsTroopAdapter.this.G.add(new com.tencent.mobileqq.troop.adapter.contact.d(1, discussionInfo));
                }
            }
            ContactsTroopAdapter.this.Q();
            if (QLog.isDebugVersion()) {
                QLog.d("ContactsTroopAdapter", 2, "loadDataUIRunnable allSize:" + this.f181784d.size() + ", discussSize:" + this.f181786f.size() + ", topSize:" + ContactsTroopAdapter.this.D.size() + ", timeCost:" + (System.currentTimeMillis() - j3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends SwipTextViewMenuBuilder {
        static IPatchRedirector $redirector_;

        a(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4) {
            super(i3, i16, iArr, i17, iArr2, iArr3, iArr4);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ContactsTroopAdapter.this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Integer.valueOf(i17), iArr2, iArr3, iArr4);
            }
        }

        @Override // com.tencent.widget.SwipRightMenuBuilder
        public void getRightMenuItemInfo(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), obj, swipRightMenuItemArr);
            } else {
                ContactsTroopAdapter.this.r(i3, swipRightMenuItemArr, obj);
            }
        }

        @Override // com.tencent.widget.SwipTextViewMenuBuilder, com.tencent.widget.SwipRightMenuBuilder
        public View updateRightMenuItem(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem, View.OnClickListener onClickListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), obj, swipRightMenuItem, onClickListener);
            }
            View updateRightMenuItem = super.updateRightMenuItem(i3, obj, swipRightMenuItem, onClickListener);
            if (updateRightMenuItem instanceof SimpleTextView) {
                updateRightMenuItem.setTag(obj);
            }
            return updateRightMenuItem;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f181789d;

        b(int i3) {
            this.f181789d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsTroopAdapter.this, i3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ContactsTroopAdapter contactsTroopAdapter = ContactsTroopAdapter.this;
                contactsTroopAdapter.R[this.f181789d] = 2;
                contactsTroopAdapter.I();
                new q(ContactsTroopAdapter.this.f181782i).i("dc00899").a("Grp_listNew").f("Grp_contactlist").d("clk_inactive").b("", String.valueOf(ContactsTroopAdapter.this.s(this.f181789d))).g();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f181791d;

        c(TextView textView) {
            this.f181791d = textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsTroopAdapter.this, (Object) textView);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 3) {
                        this.f181791d.setAlpha(1.0f);
                        return false;
                    }
                    return false;
                }
                this.f181791d.setAlpha(1.0f);
                return false;
            }
            this.f181791d.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements IGetContactsCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f181793a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f181794b;

        d(Map map, long j3) {
            this.f181793a = map;
            this.f181794b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ContactsTroopAdapter.this, map, Long.valueOf(j3));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(ArrayList arrayList, Map map, long j3) {
            Iterator it = arrayList.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                RecentContactInfo recentContactInfo = (RecentContactInfo) it.next();
                TroopInfo troopInfo = (TroopInfo) map.get(recentContactInfo.getPeerUid());
                long msgTime = recentContactInfo.getMsgTime();
                if (troopInfo != null && troopInfo.lastMsgTime != msgTime) {
                    troopInfo.lastMsgTime = msgTime;
                    z16 = true;
                }
            }
            if (ContactsTroopAdapter.this.V != j3 && z16) {
                ContactsTroopAdapter.this.P();
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
        public void onResult(int i3, String str, final ArrayList<RecentContactInfo> arrayList, ArrayList<Contact> arrayList2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, arrayList, arrayList2);
                return;
            }
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final Map map = this.f181793a;
            final long j3 = this.f181794b;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.troop.d
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsTroopAdapter.d.this.b(arrayList, map, j3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopInfo f181796d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f181797e;

        e(TroopInfo troopInfo, ActionSheet actionSheet) {
            this.f181796d = troopInfo;
            this.f181797e = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ContactsTroopAdapter.this, troopInfo, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(ContactsTroopAdapter.this.f181783m)) {
                QQToast.makeText(ContactsTroopAdapter.this.f181783m, 1, R.string.b3j, 0).show();
            } else if (ContactsTroopAdapter.this.U != null) {
                ContactsTroopAdapter.this.U.b(this.f181796d);
                if (this.f181796d.isTop) {
                    ReportController.o(ContactsTroopAdapter.this.f181782i, "dc00898", "", "", "0X800808D", "0X800808D", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(ContactsTroopAdapter.this.f181782i, "dc00898", "", "", "0X800808C", "0X800808C", 0, 0, "", "", "", "");
                }
            }
            this.f181797e.superDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DiscussionInfo f181799d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f181800e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f181801f;

        f(DiscussionInfo discussionInfo, boolean z16, ActionSheet actionSheet) {
            this.f181799d = discussionInfo;
            this.f181800e = z16;
            this.f181801f = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ContactsTroopAdapter.this, discussionInfo, Boolean.valueOf(z16), actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (ContactsTroopAdapter.this.U != null) {
                ContactsTroopAdapter.this.U.a(this.f181799d, this.f181800e);
            }
            this.f181801f.superDismiss();
            q f16 = new q(ContactsTroopAdapter.this.f181782i).i("dc00899").a("Grp_Dis_set").f("Grp_contactlist");
            if (this.f181800e) {
                str = "Clk_unstick";
            } else {
                str = "Clk_stick";
            }
            f16.d(str).g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class g extends com.tencent.mobileqq.troop.api.observer.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsTroopAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.a
        protected void onUpdateNewTroopFaceIcon(boolean z16, boolean z17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
                return;
            }
            Bitmap faceBitmap = ContactsTroopAdapter.this.f181782i.getFaceBitmap(113, str, false, 0);
            if (faceBitmap != null) {
                ContactsTroopAdapter.this.b(str, faceBitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f181804a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68176);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GroupMsgMask.values().length];
            f181804a = iArr;
            try {
                iArr[GroupMsgMask.NOTIFY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f181804a[GroupMsgMask.ASSISTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f181804a[GroupMsgMask.SHIELD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f181804a[GroupMsgMask.RECEIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface i {
        void a(DiscussionInfo discussionInfo, boolean z16);

        void b(TroopInfo troopInfo);
    }

    public ContactsTroopAdapter(Context context, QQAppInterface qQAppInterface, ExpandableListView expandableListView, i iVar) {
        super(context, qQAppInterface, expandableListView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, expandableListView, iVar);
            return;
        }
        this.C = new ArrayList(4);
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = new HashSet<>(5);
        this.K = -2;
        this.L = 0;
        this.M = 0;
        this.N = true;
        this.Q = null;
        this.R = new int[6];
        this.S = new int[6];
        this.T = new int[6];
        this.V = 0L;
        this.W = new g();
        this.f181782i = qQAppInterface;
        this.f181783m = context;
        this.U = iVar;
        this.L = BaseAIOUtils.f(56.0f, context.getResources());
        this.M = BaseAIOUtils.f(44.0f, context.getResources());
        this.J = new a(1, 1, new int[]{context.getResources().getDimensionPixelSize(R.dimen.f158598k1)}, -1, new int[]{R.id.eqg, R.id.eqg}, new int[]{R.string.bnr, R.string.bnq}, new int[]{R.drawable.cjb, R.drawable.cjb});
        this.f181782i.addObserver(this.W);
        this.P = (n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        this.f187112f.setOnItemLongClickListener(this);
    }

    private void A(TroopInfo troopInfo) {
        String str;
        String str2;
        String str3;
        boolean z16 = troopInfo.isTop;
        i iVar = this.U;
        if (iVar != null) {
            iVar.b(troopInfo);
        }
        if (z16) {
            str = "Clk_uncommgrp";
        } else {
            str = "Clk_setcommgrp";
        }
        ReportController.o(this.f181782i, "P_CliOper", "Grp_set", "", "Grp_contactlist", str, 0, 0, troopInfo.troopuin, "", "", "");
        q f16 = new q(this.f181782i).i("dc00899").a("Grp_set").f("Grp_contactlist");
        if (z16) {
            str2 = "Clk_unstick";
        } else {
            str2 = "Clk_stick";
        }
        q d16 = f16.d(str2);
        String[] strArr = new String[2];
        strArr[0] = troopInfo.troopuin;
        if (troopInfo.hasSetTroopHead()) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        strArr[1] = str3;
        d16.b(strArr).g();
    }

    private void B(a.C7160a c7160a) {
        Object obj = c7160a.f181513m;
        if (obj instanceof DiscussionInfo) {
            D(c7160a, (DiscussionInfo) obj);
            return;
        }
        TroopInfo troopInfo = (TroopInfo) obj;
        C(c7160a, troopInfo);
        com.tencent.qqperf.opt.threadpriority.b.k(true);
        if (troopInfo.isUnreadableBlock() && (this.f181783m instanceof QBaseActivity)) {
            QLog.i("ContactsTroopAdapter", 1, "[onClickForTroopDisChildTag] troopUin: " + troopInfo.troopuin);
            this.Q = k.F((Activity) this.f181783m, this.f181782i, troopInfo.troopuin, null);
            return;
        }
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
        Bundle bundle = new Bundle();
        bundle.putString("uin", troopInfo.troopuin);
        bundle.putString("key_from", "7");
        bundle.putInt("uintype", 1);
        bundle.putString("uinname", troopInfo.getTroopDisplayName());
        bundle.putBoolean("open_chatfragment_withanim", true);
        bundle.putBoolean("isFromContactTab", true);
        iAIOStarterApi.navigateToAIOActivity(this.f181783m, 2, troopInfo.troopuin, troopInfo.getTroopDisplayName(), 0L, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void C(a.C7160a c7160a, TroopInfo troopInfo) {
        int i3;
        int intValue = this.C.get(c7160a.C).intValue();
        int i16 = 3;
        if (intValue != 2) {
            if (intValue != 4) {
                if (intValue != 6) {
                    if (intValue != 10) {
                        i3 = 0;
                    } else {
                        i3 = 4;
                    }
                } else {
                    i3 = 2;
                }
            } else {
                i3 = 1;
            }
        } else {
            i3 = 3;
        }
        int i17 = h.f181804a[this.f181782i.getTroopMask(troopInfo.troopuin).ordinal()];
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 == 4) {
                        i16 = 1;
                    }
                }
            } else {
                i16 = 2;
            }
            if (c7160a.J) {
                new q(this.f181782i).i("dc00899").a("Grp_listNew").f("Grp_contactlist").d("clk_inactiveGrp").b(troopInfo.troopuin, String.valueOf(i3)).g();
            }
            ReportController.o(this.f181782i, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, troopInfo.troopuin + "", String.valueOf(i3), i16 + "", "");
            new q(this.f181782i).i("dc00899").a("Grp_listNew").f("Grp_contactlist").d("clk_grp").b(troopInfo.troopuin, String.valueOf(i3)).g();
            if (i3 != 5) {
                new q(this.f181782i).i("dc00899").a("Grp_listNew").f("Grp_contactlist").d("clk_unnamedGrp").b(troopInfo.troopuin).g();
                return;
            }
            return;
        }
        i16 = 0;
        if (c7160a.J) {
        }
        ReportController.o(this.f181782i, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, troopInfo.troopuin + "", String.valueOf(i3), i16 + "", "");
        new q(this.f181782i).i("dc00899").a("Grp_listNew").f("Grp_contactlist").d("clk_grp").b(troopInfo.troopuin, String.valueOf(i3)).g();
        if (i3 != 5) {
        }
    }

    private void D(a.C7160a c7160a, DiscussionInfo discussionInfo) {
        int i3;
        com.tencent.qqperf.opt.threadpriority.b.k(true);
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.f181783m), null);
        m3.putExtra("uin", discussionInfo.uin);
        m3.putExtra("uintype", 3000);
        m3.putExtra("uinname", discussionInfo.discussionName);
        m3.putExtra("open_chatfragment_withanim", true);
        this.f181783m.startActivity(m3);
        int intValue = this.C.get(c7160a.C).intValue();
        if (intValue != 2) {
            i3 = 4;
            if (intValue != 4) {
                if (intValue != 6) {
                    if (intValue != 10) {
                        i3 = 0;
                    }
                } else {
                    i3 = 2;
                }
            } else {
                i3 = 1;
            }
        } else {
            i3 = 3;
        }
        new q(this.f181782i).i("dc00899").a("Grp_listNew").f("Grp_contactlist").d("clk_grp").b(discussionInfo.uin, String.valueOf(i3)).g();
    }

    private void E(DiscussionInfo discussionInfo) {
        int i3;
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f181783m, null);
        boolean b46 = ((DiscussionHandler) this.f181782i.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b4(discussionInfo);
        if (b46) {
            i3 = R.string.bnq;
        } else {
            i3 = R.string.bnr;
        }
        actionSheet.addButton(i3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new f(discussionInfo, b46, actionSheet));
        try {
            actionSheet.show();
        } catch (Exception unused) {
        }
    }

    private void F(TroopInfo troopInfo) {
        int i3;
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f181783m, null);
        if (troopInfo.isTop) {
            i3 = R.string.bnq;
        } else {
            i3 = R.string.bnr;
        }
        actionSheet.addButton(i3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new e(troopInfo, actionSheet));
        try {
            actionSheet.show();
        } catch (Exception unused) {
        }
    }

    private void J() {
        if (this.C.size() > 1) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<Integer> it = this.I.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append("_");
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ContactsTroopAdapter", 2, "saveExpanded=" + stringBuffer.toString());
            }
            this.f181782i.getApp().getSharedPreferences(this.f181782i.getAccount(), 0).edit().putString("700_sp_key_last_troop_expanded", stringBuffer.toString()).commit();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactsTroopAdapter", 2, "less than 1 group : don't saveExpanded");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void L(int i3, boolean z16, zu1.d<String, Integer, Integer, Unit> dVar) {
        String str;
        int i16;
        int i17;
        int max;
        if (i3 >= 0 && i3 < this.C.size()) {
            int intValue = this.C.get(i3).intValue();
            if (intValue != 2) {
                if (intValue != 4) {
                    if (intValue != 6) {
                        if (intValue == 10) {
                            str = HardCodeUtil.qqStr(R.string.l3x);
                            i16 = this.H.size();
                            i17 = o(this.H);
                        }
                    } else {
                        str = HardCodeUtil.qqStr(R.string.f172863us3);
                        i16 = this.F.size();
                        i17 = o(this.F);
                    }
                } else {
                    str = HardCodeUtil.qqStr(R.string.f172862us0);
                    i16 = this.E.size();
                    i17 = o(this.E);
                }
            } else {
                str = HardCodeUtil.qqStr(R.string.urw);
                i16 = this.G.size();
                i17 = o(this.G);
            }
            if (i16 > 10) {
                this.R[i3] = 3;
                max = i16;
            } else {
                max = Math.max(i17, 10);
                int[] iArr = this.R;
                if (iArr[i3] == 0) {
                    if (i17 == i16) {
                        iArr[i3] = 3;
                    } else {
                        iArr[i3] = 1;
                    }
                    if (z16) {
                        I();
                    }
                }
            }
            this.S[i3] = max;
            this.T[i3] = i16 - max;
            if (dVar == null) {
                dVar.invoke(str, Integer.valueOf(max), Integer.valueOf(i16));
                return;
            }
            return;
        }
        str = "";
        i16 = 0;
        i17 = 0;
        if (i16 > 10) {
        }
        this.S[i3] = max;
        this.T[i3] = i16 - max;
        if (dVar == null) {
        }
    }

    private void M(DiscussionInfo discussionInfo, a.C7160a c7160a, int i3, int i16, View view) {
        c7160a.f187114d = discussionInfo.uin;
        c7160a.f181513m = discussionInfo;
        c7160a.f187115e = 101;
        c7160a.F.setVisibility(4);
        c7160a.I.setVisibility(8);
        c7160a.G.setVisibility(8);
        c7160a.D.setText(discussionInfo.discussionName);
        int q16 = this.P.q(discussionInfo.uin);
        if (!discussionInfo.hasRenamed() && q16 > 0) {
            c7160a.E.setVisibility(0);
            c7160a.E.setText(String.format("(%d)", Integer.valueOf(q16)));
        } else {
            c7160a.E.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactsTroopAdapter", 2, "DiscussionInfo hasRenamed:" + discussionInfo.hasRenamed() + " | memberNum:" + q16 + " | uin:" + discussionInfo.uin + "  discussionName:" + discussionInfo.discussionName);
        }
        if (AppSetting.f99565y) {
            c7160a.leftView.setContentDescription(c7160a.D.getText());
        }
        c(c7160a, null);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        N(view, (i3 << 16) | i16, c7160a, this, discussionInfo);
    }

    private void O(TroopInfo troopInfo, a.C7160a c7160a, int i3, int i16, View view) {
        String str;
        c7160a.f187114d = troopInfo.troopuin;
        c7160a.f181513m = troopInfo;
        c7160a.f187115e = 4;
        c7160a.J = w(i3, i16);
        GroupMsgMask troopMask = this.f181782i.getTroopMask(troopInfo.troopuin);
        if (troopMask == GroupMsgMask.SHIELD) {
            c7160a.F.setVisibility(0);
            c7160a.F.setImageResource(R.drawable.kz8);
            str = "\u5c4f\u853d\u7fa4\u6d88\u606f\u7fa4\uff1a";
        } else if (troopMask == GroupMsgMask.NOTIFY) {
            c7160a.F.setVisibility(4);
            str = "";
        } else {
            c7160a.F.setVisibility(0);
            c7160a.F.setImageResource(R.drawable.kz7);
            str = "\u514d\u6253\u6270\u7fa4\uff1a";
        }
        c7160a.D.setText(((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(t(troopInfo), 16));
        if (!troopInfo.hasSetTroopName() && troopInfo.getMemberNumClient() > 0) {
            c7160a.E.setVisibility(0);
            c7160a.E.setText(String.format("(%d)", Integer.valueOf(troopInfo.getMemberNumClient())));
        } else {
            c7160a.E.setVisibility(8);
        }
        if (QLog.isDebugVersion()) {
            QLog.d("ContactsTroopAdapter", 4, "TroopInfo hasSetTroopName:" + troopInfo.hasSetTroopName() + " | memberNum:" + troopInfo.getMemberNumClient());
        }
        if ((troopInfo.dwGroupFlagExt & 2048) != 0) {
            long j3 = troopInfo.dwAuthGroupType;
            if (j3 == 2) {
                c7160a.I.setVisibility(0);
                c7160a.I.setBackgroundResource(R.drawable.e5d);
            } else if (j3 == 1) {
                c7160a.I.setVisibility(0);
                c7160a.I.setBackgroundResource(R.drawable.e5d);
            } else {
                c7160a.I.setVisibility(8);
            }
        } else {
            c7160a.I.setVisibility(8);
        }
        if (troopInfo.isTroopBlocked) {
            c7160a.G.setVisibility(0);
            if (SimpleUIUtil.getSimpleUISwitch()) {
                c7160a.G.setBackgroundResource(R.drawable.k_o);
            } else {
                c7160a.G.setBackgroundResource(R.drawable.f161422x6);
            }
            c7160a.F.setVisibility(0);
            c7160a.F.setImageResource(R.drawable.kz6);
            str = "\u5c01\u7981\u7fa4\uff1a";
        } else {
            long j16 = troopInfo.troopCreditLevel;
            if (j16 == 2) {
                c7160a.G.setVisibility(0);
                if (SimpleUIUtil.getSimpleUISwitch()) {
                    c7160a.G.setBackgroundResource(R.drawable.k_o);
                } else {
                    c7160a.G.setBackgroundResource(R.drawable.f161422x6);
                }
                c7160a.F.setVisibility(0);
                c7160a.F.setImageResource(R.drawable.h2h);
                str = "\u4e34\u65f6\u5c01\u7981\u7fa4\uff1a";
            } else if (j16 == 1) {
                c7160a.G.setVisibility(0);
                if (SimpleUIUtil.getSimpleUISwitch()) {
                    c7160a.G.setBackgroundResource(R.drawable.k_o);
                } else {
                    c7160a.G.setBackgroundResource(R.drawable.f161422x6);
                }
                c7160a.F.setVisibility(0);
                c7160a.F.setImageResource(R.drawable.h2f);
                str = "\u6c38\u5c01\u7fa4\uff1a";
            } else {
                c7160a.G.setVisibility(4);
            }
        }
        if (AppSetting.f99565y) {
            c7160a.leftView.setContentDescription(str + ((Object) c7160a.D.getText()));
        }
        c(c7160a, null);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        N(view, (i3 << 16) | i16, c7160a, this, troopInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        try {
            com.tencent.mobileqq.troop.adapter.contact.b bVar = new com.tencent.mobileqq.troop.adapter.contact.b();
            Collections.sort(this.E, bVar);
            Collections.sort(this.F, bVar);
            Collections.sort(this.G, bVar);
            Collections.sort(this.H, bVar);
            for (Integer num : this.C) {
                if (num.intValue() > 0 && num.intValue() < this.R.length) {
                    L(num.intValue(), false, null);
                }
            }
            notifyDataSetChanged();
        } catch (IllegalArgumentException e16) {
            QLog.e("ContactsTroopAdapter", 1, "updateUIAfterActiveTimeReady: ", e16);
        }
    }

    private void l() {
        ThreadManagerV2.post(new LoadTroopDiscussInfoSubRunnable(), 8, null, true);
    }

    private View p(int i3) {
        View inflate = LayoutInflater.from(this.f181783m).inflate(QUITokenResUtil.getResId(R.layout.c1m, R.layout.hzt), (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.f165265cj4);
        String str = HardCodeUtil.qqStr(R.string.l36) + this.T[i3] + ")";
        textView.setText(str);
        inflate.setOnClickListener(new b(i3));
        inflate.setOnTouchListener(new c(textView));
        inflate.setContentDescription(str + HardCodeUtil.qqStr(R.string.l2f));
        return inflate;
    }

    private Object q(int i3, int i16) {
        int intValue = this.C.get(i3).intValue();
        if (intValue != 2) {
            if (intValue != 4) {
                if (intValue != 6) {
                    if (intValue != 10) {
                        return null;
                    }
                    return this.H.get(i16).f293809b;
                }
                return this.F.get(i16).f293809b;
            }
            return this.E.get(i16).f293809b;
        }
        return this.G.get(i16).f293809b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s(int i3) {
        if (i3 < 0 || i3 >= this.C.size()) {
            return 0;
        }
        int intValue = this.C.get(i3).intValue();
        if (intValue != 2) {
            if (intValue != 4) {
                if (intValue == 6) {
                    return 2;
                }
                if (intValue != 10) {
                    return 0;
                }
                return 4;
            }
            return 1;
        }
        return 3;
    }

    private String t(TroopInfo troopInfo) {
        String str = troopInfo.troopRemark;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String troopDisplayName = troopInfo.getTroopDisplayName();
        if (!TextUtils.isEmpty(troopDisplayName)) {
            return troopDisplayName;
        }
        return troopInfo.troopuin;
    }

    private void v(View view, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        VideoReport.setElementId(view, "em_kl_contact_people_unit");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "user_type", 3);
        VideoReport.setElementParam(view, "user_id", str);
    }

    private boolean w(int i3, int i16) {
        if (i3 > 0) {
            int[] iArr = this.S;
            if (i3 < iArr.length && i16 > iArr[i3]) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit x(int i3, StringBuilder sb5, com.tencent.mobileqq.troop.adapter.contact.a aVar, String str, Integer num, Integer num2) {
        String str2;
        if (this.R[i3] == 1) {
            str2 = num + "/" + num2;
        } else {
            str2 = "" + num2;
        }
        if (AppSetting.f99565y) {
            sb5.append(str);
            sb5.append(" ");
            sb5.append(str2);
        }
        aVar.f293800d.setText(str);
        aVar.f293802f.setText(str2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(int i3) {
        View childAt = this.f187112f.getChildAt(i3);
        childAt.requestFocus();
        childAt.setBackgroundResource(QUITokenResUtil.getDrawableId(R.drawable.jiq, R.drawable.jir));
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            J();
        }
    }

    protected void H() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (this.C.size() == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactsTroopAdapter", 2, "only one group");
            }
            this.f187112f.expandGroup(0);
            this.I.add(this.C.get(0));
            return;
        }
        String string = this.f181782i.getApp().getSharedPreferences(this.f181782i.getAccount(), 0).getString("700_sp_key_last_troop_expanded", "700_sp_key_last_troop_expanded");
        if (QLog.isColorLevel()) {
            QLog.d("ContactsTroopAdapter", 2, "readExpand=" + string);
        }
        HashSet hashSet = new HashSet();
        if (string.equalsIgnoreCase("700_sp_key_last_troop_expanded")) {
            if (this.C.size() > 0) {
                hashSet.add(this.C.get(0));
            } else {
                this.N = true;
            }
        } else if (!TextUtils.isEmpty(string)) {
            for (String str : string.split("_")) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException unused) {
                }
            }
        }
        for (int i16 = 0; i16 < this.C.size(); i16++) {
            if (hashSet.contains(this.C.get(i16))) {
                this.I.add(this.C.get(i16));
                if (this.C.size() == 1) {
                    i3 = 0;
                } else {
                    i3 = i16;
                }
                if (i16 > 0 && i16 < this.R.length) {
                    L(i16, false, null);
                }
                this.f187112f.expandGroup(i16);
                int[] iArr = this.R;
                if (i16 < iArr.length && iArr[i16] == 1 && this.f187112f.isGroupExpanded(i3)) {
                    new q(this.f181782i).i("dc00899").a("Grp_listNew").f("Grp_contactlist").d("exp_inactive").b("", String.valueOf(s(i16))).g();
                }
            }
        }
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            l();
        }
    }

    public void K(List<TroopInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) list);
            return;
        }
        aa recentContactService = ((IKernelService) this.f181782i.getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e("ContactsTroopAdapter", 1, "setActiveTimeWithMaskSync: error");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        for (TroopInfo troopInfo : list) {
            arrayMap.put(troopInfo.troopuin, troopInfo);
            arrayList.add(new Contact(2, troopInfo.troopuin, ""));
        }
        if (!arrayList.isEmpty()) {
            recentContactService.d(arrayList, new d(arrayMap, this.V));
        }
    }

    public void N(View view, int i3, c.C7154c c7154c, View.OnClickListener onClickListener, Object obj) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, view, Integer.valueOf(i3), c7154c, onClickListener, obj);
            return;
        }
        SwipTextViewMenuBuilder swipTextViewMenuBuilder = this.J;
        if (swipTextViewMenuBuilder != null) {
            i16 = swipTextViewMenuBuilder.updateRightMenuView(this.f181783m, view, i3, obj, c7154c, onClickListener);
        } else {
            i16 = 0;
        }
        int i17 = this.K;
        if (i17 != -1) {
            if (i3 != i17) {
                view.scrollTo(0, 0);
            } else {
                view.scrollTo(i16, 0);
            }
        }
    }

    protected void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.adapter.contact.b bVar = new com.tencent.mobileqq.troop.adapter.contact.b();
        Collections.sort(this.E, bVar);
        Collections.sort(this.F, bVar);
        Collections.sort(this.G, bVar);
        Collections.sort(this.H, bVar);
        int size = this.E.size();
        if (size > 0) {
            this.C.add(4);
        }
        int size2 = this.F.size();
        if (size2 > 0) {
            this.C.add(6);
        }
        int size3 = this.G.size();
        if (size3 > 0) {
            this.C.add(2);
        }
        int size4 = this.H.size();
        if (size4 > 0) {
            this.C.add(10);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ContactsTroopAdapter", 2, "[updateUIAfterInfoListReady] createTroopNum:" + size + ", manageTroopNum:" + size2 + ", joinTroopNum:" + size3 + ", privateTroopNum:" + size4);
        }
        HashSet<Integer> hashSet = new HashSet<>(5);
        Iterator<Integer> it = this.I.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (this.C.contains(next)) {
                hashSet.add(next);
            }
        }
        this.I = hashSet;
        notifyDataSetChanged();
        boolean z16 = true;
        if (this.N) {
            this.N = false;
            H();
        } else if (this.C.size() == 1) {
            this.f187112f.expandGroup(0);
            this.I.add(this.C.get(0));
        } else {
            for (int i3 = 0; i3 < this.C.size(); i3++) {
                if (this.I.contains(this.C.get(i3))) {
                    this.f187112f.expandGroup(i3);
                } else {
                    this.f187112f.collapseGroup(i3);
                }
            }
        }
        ExpandableListView expandableListView = this.f187112f;
        if (expandableListView instanceof PinnedHeaderExpandableListView) {
            PinnedHeaderExpandableListView pinnedHeaderExpandableListView = (PinnedHeaderExpandableListView) expandableListView;
            if (this.C.size() <= 1) {
                z16 = false;
            }
            pinnedHeaderExpandableListView.setHeaderViewShouldShow(z16);
        }
        this.V = System.currentTimeMillis();
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, i3);
            return;
        }
        if (view == null) {
            return;
        }
        if (this.C.size() == 1) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (!(view.getTag() instanceof com.tencent.mobileqq.troop.adapter.contact.a)) {
            aVar = new com.tencent.mobileqq.troop.adapter.contact.a();
            aVar.f293798b = (CheckBox) view.findViewById(R.id.dv_);
            SingleLineTextView singleLineTextView = (SingleLineTextView) view.findViewById(R.id.group_name);
            aVar.f293800d = singleLineTextView;
            singleLineTextView.setDefaultTextColor(-8355712);
            aVar.f293801e = (SingleLineTextView) view.findViewById(R.id.f167055ka1);
            com.tencent.mobileqq.activity.contacts.friend.SimpleTextView simpleTextView = (com.tencent.mobileqq.activity.contacts.friend.SimpleTextView) view.findViewById(R.id.contact_count);
            aVar.f293802f = simpleTextView;
            simpleTextView.setDefaultTextColor(1711276032);
            aVar.f293799c = (ProgressBar) view.findViewById(R.id.f165958dx0);
            view.setTag(aVar);
        } else {
            aVar = (com.tencent.mobileqq.troop.adapter.contact.a) view.getTag();
        }
        int drawableId = QUITokenResUtil.getDrawableId(R.drawable.jiq, R.drawable.jir);
        Resources resources = view.getResources();
        if (QUITokenResUtil.useQUIToken() && resources != null) {
            view.setBackground(resources.getDrawable(drawableId, null));
        }
        if (ThemeUtil.isNowThemeIsDefaultCache(this.f181782i, false) && !QUITokenResUtil.useQUIToken()) {
            aVar.f293802f.setTextColor(-5196865);
        } else {
            aVar.f293802f.setTextColor(this.f181783m.getResources().getColorStateList(QUITokenResUtil.getResId(R.color.skin_gray2_theme_version2, R.color.qui_common_text_secondary)));
        }
        n(aVar, i3, this.f187112f.isGroupExpanded(i3));
    }

    @Override // com.tencent.mobileqq.adapter.ai
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        super.destroy();
        this.f181782i.removeObserver(this.W);
        ExpandableListView expandableListView = this.f187112f;
        if (expandableListView != null) {
            expandableListView.setOnItemLongClickListener(null);
            int childCount = this.f187112f.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f187112f.getChildAt(i3);
                if (childAt != null) {
                    childAt.setOnClickListener(null);
                    childAt.setOnLongClickListener(null);
                }
            }
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return Integer.valueOf(i16);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        return i16;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        a.C7160a c7160a;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), view, viewGroup);
        }
        if (i16 == getChildrenCount(i3) - 1 && this.R[i3] == 1) {
            return p(i3);
        }
        if (view != null && (view.getTag() instanceof a.C7160a)) {
            c7160a = (a.C7160a) view.getTag();
        } else {
            View inflate = LayoutInflater.from(this.f181783m).inflate(QUITokenResUtil.getResId(R.layout.c1n, R.layout.hzu), (ViewGroup) null);
            inflate.setMinimumHeight(this.L);
            a.C7160a c7160a2 = new a.C7160a();
            View createView = this.J.createView(this.f181783m, inflate, c7160a2, -1);
            c7160a2.leftView = inflate;
            c7160a2.D = (TextView) createView.findViewById(R.id.text1);
            c7160a2.E = (TextView) createView.findViewById(R.id.text2);
            QQProAvatarView qQProAvatarView = (QQProAvatarView) createView.findViewById(R.id.icon);
            c7160a2.f187116f = qQProAvatarView;
            qQProAvatarView.setEnableMask(false);
            c7160a2.G = (ImageView) createView.findViewById(R.id.enc);
            c7160a2.F = (ImageView) createView.findViewById(R.id.j1v);
            c7160a2.H = (TextView) createView.findViewById(R.id.f166334f21);
            c7160a2.I = (ImageView) createView.findViewById(R.id.jxg);
            c7160a2.D.setTextColor(createView.getResources().getColorStateList(QUITokenResUtil.getResId(R.color.skin_black_theme_version2, R.color.qui_common_text_primary)));
            createView.setTag(c7160a2);
            c7160a = c7160a2;
            view = createView;
        }
        c7160a.C = i3;
        Object q16 = q(i3, i16);
        if (q16 != null && (q16 instanceof TroopInfo)) {
            TroopInfo troopInfo = (TroopInfo) q16;
            str = troopInfo.troopuin;
            O(troopInfo, c7160a, i3, i16, view);
        } else if (q16 != null && (q16 instanceof DiscussionInfo)) {
            DiscussionInfo discussionInfo = (DiscussionInfo) q16;
            str = String.valueOf(discussionInfo.groupUin);
            M(discussionInfo, c7160a, i3, i16, view);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ContactsTroopAdapter", 2, "getChildView data:" + q16 + " groupPosition:" + i3 + " childPosition:" + i16);
            }
            str = "";
        }
        v(view, str);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        int i17 = 0;
        if (i3 < 0 || i3 >= this.C.size()) {
            return 0;
        }
        int intValue = this.C.get(i3).intValue();
        if (intValue != 2) {
            if (intValue != 4) {
                if (intValue != 6) {
                    if (intValue == 10) {
                        i17 = this.H.size();
                    }
                } else {
                    i17 = this.F.size();
                }
            } else {
                i17 = this.E.size();
            }
        } else {
            i17 = this.G.size();
        }
        if (this.R[i3] == 1 && (i16 = this.S[i3]) < i17) {
            return i16 + 1;
        }
        return i17;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return Integer.valueOf(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.C.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view == null) {
            view = LayoutInflater.from(this.f181783m).inflate(QUITokenResUtil.getResId(R.layout.f167798hv, R.layout.e3z), viewGroup, false);
            aVar = new com.tencent.mobileqq.troop.adapter.contact.a();
            SingleLineTextView singleLineTextView = (SingleLineTextView) view.findViewById(R.id.group_name);
            aVar.f293800d = singleLineTextView;
            singleLineTextView.setDefaultTextColor(-8355712);
            aVar.f293798b = (CheckBox) view.findViewById(R.id.dv_);
            com.tencent.mobileqq.activity.contacts.friend.SimpleTextView simpleTextView = (com.tencent.mobileqq.activity.contacts.friend.SimpleTextView) view.findViewById(R.id.contact_count);
            aVar.f293802f = simpleTextView;
            simpleTextView.setDefaultTextColor(1711276032);
            aVar.f293799c = (ProgressBar) view.findViewById(R.id.f165958dx0);
            aVar.f293801e = (SingleLineTextView) view.findViewById(R.id.f167055ka1);
            view.setTag(aVar);
        } else {
            aVar = (com.tencent.mobileqq.troop.adapter.contact.a) view.getTag();
        }
        view.setBackgroundResource(QUITokenResUtil.getDrawableId(R.drawable.jiq, R.drawable.jir));
        if (this.C.size() == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
            return view;
        }
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.M));
        if (ThemeUtil.isNowThemeIsDefaultCache(this.f181782i, false) && !QUITokenResUtil.useQUIToken()) {
            aVar.f293802f.setTextColor(-5196865);
        } else {
            aVar.f293802f.setTextColor(this.f181783m.getResources().getColorStateList(QUITokenResUtil.getResId(R.color.skin_gray2_theme_version2, R.color.qui_common_text_secondary)));
        }
        Resources resources = view.getResources();
        if (QUITokenResUtil.useQUIToken() && resources != null) {
            view.setBackground(resources.getDrawable(R.drawable.jis, null));
        }
        n(aVar, i3, z16);
        view.setOnClickListener(this);
        return view;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return QUITokenResUtil.getResId(R.layout.f167798hv, R.layout.e3z);
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public void hideMenuPop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        }
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public void interceptTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
        } else {
            FrameHelperActivity.gj(!z16, "ContactsTroopAdapter");
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (this.C.size() <= 1) {
            return;
        }
        int size = this.C.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f187112f.collapseGroup(i3);
        }
        this.I.clear();
    }

    protected void n(final com.tencent.mobileqq.troop.adapter.contact.a aVar, final int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, aVar, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (aVar != null) {
            final StringBuilder sb5 = new StringBuilder(24);
            L(i3, true, new zu1.d() { // from class: com.tencent.mobileqq.activity.contacts.troop.b
                @Override // zu1.d
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit x16;
                    x16 = ContactsTroopAdapter.this.x(i3, sb5, aVar, (String) obj, (Integer) obj2, (Integer) obj3);
                    return x16;
                }
            });
            aVar.f293797a = i3;
            aVar.f293801e.setVisibility(8);
            aVar.f293799c.setVisibility(8);
            aVar.f293798b.setVisibility(0);
            aVar.f293798b.setChecked(z16);
            if (AppSetting.f99565y) {
                aVar.f293802f.setContentDescription(sb5.toString());
                AccessibilityUtil.v(aVar.f293802f, !aVar.f293798b.isChecked());
                AccessibilityUtil.n(aVar.f293798b, false);
            }
        }
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public boolean needHideBackgroundGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    protected int o(List<com.tencent.mobileqq.troop.adapter.contact.d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list)).intValue();
        }
        Iterator<com.tencent.mobileqq.troop.adapter.contact.d> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object obj = it.next().f293809b;
            if (obj != null && (obj instanceof TroopInfo) && ((TroopInfo) obj).lastMsgTime > 0) {
                i3++;
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.d("ContactsTroopAdapter", 4, "getActiveTroopCount activeTroopCount:" + i3);
        }
        return i3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag instanceof com.tencent.mobileqq.troop.adapter.contact.a) {
                z((com.tencent.mobileqq.troop.adapter.contact.a) tag, view);
            } else if (tag instanceof a.C7160a) {
                B((a.C7160a) tag);
            } else if (tag instanceof TroopInfo) {
                A((TroopInfo) tag);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, this, expandableListView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        Object tag = view.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.adapter.contact.a) {
            u((com.tencent.mobileqq.troop.adapter.contact.a) tag, view);
        }
        return true;
    }

    @Override // com.tencent.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 36, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z16;
        Object tag;
        Object obj;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) view)).booleanValue();
        } else {
            Object parent = view.getParent();
            HeaderScrollView headerScrollView = null;
            while (parent != null && headerScrollView == null) {
                if (parent instanceof HeaderScrollView) {
                    headerScrollView = (HeaderScrollView) parent;
                } else if (parent instanceof View) {
                    parent = ((View) parent).getParent();
                } else {
                    parent = null;
                }
            }
            z16 = false;
            if ((headerScrollView == null || !headerScrollView.T) && (tag = view.getTag()) != null && (tag instanceof c.C7154c) && (obj = ((c.C7154c) tag).f181513m) != null) {
                if (obj instanceof TroopInfo) {
                    F((TroopInfo) obj);
                } else if (obj instanceof DiscussionInfo) {
                    E((DiscussionInfo) obj);
                }
                z16 = true;
            }
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    protected void r(int i3, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr, Object obj) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), swipRightMenuItemArr, obj);
            return;
        }
        if (swipRightMenuItemArr != null && swipRightMenuItemArr.length > 0) {
            if (swipRightMenuItemArr.length > 0) {
                if ((obj instanceof TroopInfo) && this.D.contains((TroopInfo) obj)) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[0];
                swipRightMenuItem.menuId = i16;
                swipRightMenuItem.menuType = 0;
            } else {
                i17 = 0;
            }
            while (i17 < swipRightMenuItemArr.length) {
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem2 = swipRightMenuItemArr[i17];
                swipRightMenuItem2.menuId = -1;
                swipRightMenuItem2.menuType = -1;
                i17++;
            }
        }
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public boolean supportSwip(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) view)).booleanValue();
        }
        return true;
    }

    protected void u(com.tencent.mobileqq.troop.adapter.contact.a aVar, View view) {
        final int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) aVar, (Object) view);
            return;
        }
        int i16 = 0;
        if (this.C.size() == 1) {
            i3 = 0;
        } else {
            i3 = aVar.f293797a;
        }
        if (this.f187112f.isGroupExpanded(i3)) {
            this.f187112f.collapseGroup(i3);
            this.I.remove(this.C.get(i3));
        } else {
            for (int i17 = 0; i17 < this.C.size(); i17++) {
                if (this.f187112f.isGroupExpanded(i17)) {
                    this.f187112f.collapseGroup(i17);
                    this.I.remove(this.C.get(i17));
                }
            }
            this.f187112f.expandGroup(i3);
            this.I.add(this.C.get(i3));
        }
        while (true) {
            int[] iArr = this.R;
            if (i16 >= iArr.length) {
                break;
            }
            if (iArr[i16] == 2) {
                iArr[i16] = 1;
            }
            i16++;
        }
        if (AppSetting.f99565y) {
            this.f187112f.requestFocusFromTouch();
            int positionForView = this.f187112f.getPositionForView(view);
            if (positionForView >= 0 && i3 != positionForView) {
                this.f187112f.post(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.troop.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactsTroopAdapter.this.y(i3);
                    }
                });
            } else {
                view.requestFocus();
            }
        }
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public void updateCurShowRightView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) view);
            return;
        }
        int i3 = -1;
        if (view != null) {
            Object tag = view.getTag(-1);
            if (tag instanceof Integer) {
                i3 = ((Integer) tag).intValue();
            }
        }
        this.K = i3;
    }

    protected void z(com.tencent.mobileqq.troop.adapter.contact.a aVar, View view) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) aVar, (Object) view);
            return;
        }
        u(aVar, view);
        L(aVar.f293797a, false, null);
        int i16 = aVar.f293797a;
        if (i16 >= 0 && i16 < this.R.length) {
            if (this.C.size() == 1) {
                i3 = 0;
            } else {
                i3 = aVar.f293797a;
            }
            if (this.R[aVar.f293797a] == 1 && this.f187112f.isGroupExpanded(i3)) {
                new q(this.f181782i).i("dc00899").a("Grp_listNew").f("Grp_contactlist").d("exp_inactive").b("", String.valueOf(s(aVar.f293797a))).g();
            }
        }
    }
}
