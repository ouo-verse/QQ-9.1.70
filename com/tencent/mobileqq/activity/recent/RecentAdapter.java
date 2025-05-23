package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.er;
import com.tencent.mobileqq.utils.ew;
import com.tencent.mobileqq.utils.s;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.IRecentImgv;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipTextViewMenuBuilder;
import com.tencent.widget.XListView;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentAdapter extends BaseAdapter implements DecodeTaskCompletionListener, View.OnClickListener, View.OnLongClickListener, DragFrameLayout.b, QUIBadgeDragLayout.IDragViewProvider, SwipListView.SwipListListener {
    static IPatchRedirector $redirector_;
    protected i C;
    protected XListView D;
    protected DragFrameLayout E;
    private e F;
    private long G;
    private Hashtable<String, Bitmap> H;
    protected BubblePopupWindow I;
    public int J;
    private long K;
    private boolean L;
    private ArrayList<Integer> M;
    View.OnClickListener N;

    /* renamed from: d, reason: collision with root package name */
    protected k f185151d;

    /* renamed from: e, reason: collision with root package name */
    protected final List<Object> f185152e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f185153f;

    /* renamed from: h, reason: collision with root package name */
    private int f185154h;

    /* renamed from: i, reason: collision with root package name */
    private int f185155i;

    /* renamed from: m, reason: collision with root package name */
    protected QQAppInterface f185156m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.recent.RecentAdapter$3, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ RecentAdapter this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ((BlessManager) this.this$0.f185156m.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).M0(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements BubblePopupWindow.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f185159d;

        a(View view) {
            this.f185159d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecentAdapter.this, (Object) view);
            }
        }

        @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f185159d.setSelected(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecentAdapter.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ((CardHandler) RecentAdapter.this.f185156m.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).Z4(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecentAdapter.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecentAdapter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id5;
            Object item;
            String str;
            CharSequence text;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (view != null && (id5 = view.getId()) >= 0 && id5 < RecentAdapter.this.getCount() && (item = RecentAdapter.this.getItem(id5)) != null && (item instanceof RecentBaseData)) {
                RecentBaseData recentBaseData = (RecentBaseData) item;
                if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null) {
                    str = text.toString();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    RecentAdapter.this.q(recentBaseData, str, "1");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public RecentAdapter(Context context, QQAppInterface qQAppInterface, XListView xListView, e eVar, int i3) {
        this(context, qQAppInterface, xListView, eVar, i3, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, xListView, eVar, Integer.valueOf(i3));
    }

    private void a(RecentBaseData recentBaseData) {
        if (recentBaseData == null) {
            return;
        }
        recentBaseData.mVipPendant = 0;
        if (QQTheme.isNowSimpleUI()) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.recent", 2, "setVipPendant now is SimpleUI");
                return;
            }
            return;
        }
        if ((recentBaseData instanceof RecentItemChatMsgData) && !TextUtils.isEmpty(recentBaseData.getRecentUserUin())) {
            VipData vipDataForFriends = ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(recentBaseData.getRecentUserUin());
            if (vipDataForFriends.getPendantIsVip()) {
                recentBaseData.mVipPendant = vipDataForFriends.getPendantItemId();
                if (QLog.isColorLevel()) {
                    QLog.i("Q.recent", 2, "setVipPendant uin=" + recentBaseData.getRecentUserUin() + ",pendantId=" + recentBaseData.mVipPendant);
                }
            } else {
                recentBaseData.mVipPendant = 0;
            }
        }
        if (recentBaseData.mVipPendant <= 0 && QQTheme.isNowThemeIsSuperTheme()) {
            recentBaseData.mVipPendant = ThemeUtil.getSuperThemePendant();
            if (QLog.isColorLevel()) {
                QLog.i("Q.recent", 2, "setVipPendant uin=" + recentBaseData.getRecentUserUin() + ",pendantId=" + recentBaseData.mVipPendant);
            }
        }
    }

    private RecentBaseData b(View view) {
        int i3;
        RecentBaseData recentBaseData;
        if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 2, "RecentAdpater onLongClick");
        }
        k kVar = this.f185151d;
        if (kVar != null) {
            i3 = kVar.h();
        } else {
            i3 = 0;
        }
        if (i3 == 0 && FrameHelperActivity.Gi()) {
            return null;
        }
        if (view == null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "RecentAdpater onLongClick v is null");
            }
            return null;
        }
        Object tag = view.getTag(-1);
        if (!(tag instanceof Integer)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "RecentAdpater onLongClick tag is not int");
            }
            return null;
        }
        int intValue = ((Integer) tag).intValue();
        Object item = getItem(intValue);
        if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "onLongClick|obj = " + item);
        }
        if (item instanceof RecentBaseData) {
            recentBaseData = (RecentBaseData) item;
        } else {
            recentBaseData = null;
        }
        if (recentBaseData == null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "RecentAdpater onLongClick item is null, pos = " + intValue);
            }
            return null;
        }
        if (this.f185151d == null) {
            return null;
        }
        return recentBaseData;
    }

    private void d() {
        int intValue;
        Drawable bitmapDrawable;
        int childCount = this.D.getChildCount();
        boolean z16 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.D.getChildAt(i3);
            RecentBaseData l3 = l(childAt);
            if (l3 != null && (intValue = ((Integer) i.n(this.f185156m, l3.getRecentUserType(), l3.getRecentUserUin()).first).intValue()) != Integer.MIN_VALUE) {
                Bitmap bitmap = this.H.get(intValue + ":" + l3.getRecentUserUin());
                if (bitmap != null) {
                    if (intValue == 103) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.icon_cover_recent_subaccount);
                        if (drawable instanceof SkinnableBitmapDrawable) {
                            ((SkinnableBitmapDrawable) drawable).setGravity(81);
                        }
                        if (drawable instanceof BitmapDrawable) {
                            ((BitmapDrawable) drawable).setGravity(81);
                        }
                        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                        bitmapDrawable = new LayerDrawable(new Drawable[]{new BitmapDrawable(BaseApplication.getContext().getResources(), bitmap), drawable});
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Q.recent", 4, "onDecodeTaskCompleted, subaccount cost = " + (System.currentTimeMillis() - currentTimeMillis));
                        }
                    } else {
                        bitmapDrawable = new BitmapDrawable(BaseApplication.getContext().getResources(), bitmap);
                    }
                    A(childAt, l3, bitmapDrawable);
                    z16 = true;
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "decodecomplete|faceCache size = " + this.H.size() + ", isNeedUpdateAvatar=" + z16);
        }
    }

    private void e(RecentBaseData recentBaseData, String str, String str2) {
        int recentUserType = recentBaseData.getRecentUserType();
        if (recentUserType == 8112) {
            if (!NetworkUtil.isNetworkAvailable(this.f185153f)) {
                Context context = this.f185153f;
                QQToast.makeText(context, context.getResources().getString(R.string.b3j), 0).show(this.f185153f.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                return;
            } else {
                ((FriendListHandler) this.f185156m.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend(recentBaseData.getRecentUserUin());
            }
        }
        if (recentUserType == 1008 && "2747277822".equals(recentBaseData.getRecentUserUin())) {
            f();
        }
        if (recentUserType == 1044 || recentUserType == 1045) {
            HashMap hashMap = new HashMap();
            hashMap.put("to_uid", recentBaseData.getRecentUserUin());
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#delete_friend", true, -1L, -1L, hashMap, true, true);
        }
        h(recentBaseData, str2);
        u(recentBaseData, str2, recentUserType);
    }

    private void f() {
        IGameMsgManagerService iGameMsgManagerService;
        try {
            QQAppInterface qQAppInterface = this.f185156m;
            if (qQAppInterface != null && (iGameMsgManagerService = (IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")) != null) {
                iGameMsgManagerService.setUnshowedUnreadCnt(0);
                MqqHandler handler = this.f185156m.getHandler(Conversation.class);
                if (handler != null) {
                    handler.sendMessage(handler.obtainMessage(1009));
                }
            }
        } catch (Exception e16) {
            com.tencent.qqperf.monitor.crash.catchedexception.a.b(e16);
        }
    }

    private void g(RecentUser recentUser) {
        if (!ew.a()) {
            return;
        }
        ((IConversationFacade) this.f185156m.getRuntimeService(IConversationFacade.class, "")).setUnreadMark(recentUser.uin, recentUser.type, 0);
    }

    private void i(RecentBaseData recentBaseData) {
        if (recentBaseData.getRecentUserType() == 1) {
            ReportController.o(this.f185156m, "P_CliOper", "Grp_msg", "", "Msglist", "right", 0, 0, recentBaseData.getRecentUserUin(), String.valueOf(this.f185156m.getTroopMask(recentBaseData.getRecentUserUin()).ordinal() - 1), "", "");
        }
        if ("9970".equals(recentBaseData.getRecentUserUin())) {
            ReportController.o(this.f185156m, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Press_Shopfolderlong", 0, 0, "", "", "", "");
        }
    }

    private View k(QUIBadgeDragLayout qUIBadgeDragLayout) {
        if (qUIBadgeDragLayout != null) {
            return qUIBadgeDragLayout.getDragView();
        }
        return null;
    }

    private boolean m(View view) {
        String str;
        if (view == null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "RecentAdpater onClick v is null");
            }
            return true;
        }
        if (Utils.p(SwipTextViewMenuBuilder.TAG_SWIP_ICON_MENU_ITEM, view.getTag())) {
            Object tag = view.getTag(-1);
            Object tag2 = view.getTag(-2);
            if ((tag instanceof Integer) && (tag2 instanceof Integer)) {
                int intValue = ((Integer) tag).intValue();
                try {
                    str = this.f185153f.getResources().getString(((Integer) tag2).intValue());
                } catch (Exception e16) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("Q.recent", 4, e16.toString());
                    }
                    str = null;
                }
                Object item = getItem(intValue);
                if (QLog.isDevelopLevel()) {
                    QLog.i("Q.recent", 4, "onClick|obj = " + item + ", " + str);
                }
                if (str != null && (item instanceof RecentBaseData)) {
                    q((RecentBaseData) item, str, "2");
                }
                if (AppSetting.f99565y) {
                    this.J = -1;
                }
                return true;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
            }
            return true;
        }
        if (Utils.p("tag_recent_item_icon", view.getTag())) {
            Object tag3 = view.getTag(-22);
            e eVar = this.F;
            if (eVar != null && tag3 != null) {
                eVar.w4(view, tag3);
            }
            return true;
        }
        return false;
    }

    private void r(int i3, Object obj) {
        EcShopAssistantManager ecShopAssistantManager;
        if (obj instanceof RecentUserBaseData) {
            RecentUserBaseData recentUserBaseData = (RecentUserBaseData) obj;
            RecentUser d16 = recentUserBaseData.d();
            if (d16.getType() == 1008) {
                ReportController.o(this.f185156m, "dc00899", IPublicAccountHandler.MAIN_ACTION, "" + d16.uin, "0X80064CA", "0X80064CA", 0, 0, "" + recentUserBaseData.mUnreadNum, "", "", "");
            } else if (d16.getType() == 6004) {
                ReportController.o(this.f185156m, "dc00898", "", "", "0X80090EA", "0X80090EA", 0, 0, "", "", "", "");
            }
            recentUserBaseData.clearUnReadNum();
            QQAppInterface qQAppInterface = this.f185156m;
            if (qQAppInterface != null) {
                com.tencent.util.notification.d.h(qQAppInterface).d(recentUserBaseData.getRecentUserUin());
            }
            RecentUtil.c(this.f185156m, d16, true, false);
            if (this.f185155i == 0) {
                RecentUtil.D0(this.f185156m, d16);
            }
            s(d16);
            return;
        }
        if (obj instanceof RecentItemEcShop) {
            RecentItemEcShop recentItemEcShop = (RecentItemEcShop) obj;
            ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, recentItemEcShop.getRecentUserUin(), "0X80064D3", "0X80064D3", 0, 0, "" + recentItemEcShop.mUnreadNum, "", "", "");
            recentItemEcShop.clearUnReadNum();
            RecentUtil.I0(this.f185156m, recentItemEcShop.getRecentUserUin(), recentItemEcShop.getRecentUserType());
            this.f185156m.getMessageFacade().O0(recentItemEcShop.getRecentUserUin(), recentItemEcShop.getRecentUserType());
            Message lastMessage = this.f185156m.getMessageFacade().getLastMessage(recentItemEcShop.getRecentUserUin(), 1008);
            if (lastMessage != null && (ecShopAssistantManager = (EcShopAssistantManager) this.f185156m.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)) != null) {
                ecShopAssistantManager.t(lastMessage.time);
                return;
            }
            return;
        }
        if (obj instanceof RecentMsgBoxItem) {
            t((RecentMsgBoxItem) obj);
            return;
        }
        if (obj instanceof RecentItemConfessMsg) {
            ConfessMsgUtil.j(this.f185156m, (RecentItemConfessMsg) obj, false);
        } else if (obj instanceof RecentMatchChatListItem) {
            RecentMatchChatListItem recentMatchChatListItem = (RecentMatchChatListItem) obj;
            this.f185156m.getMessageFacade().O0(recentMatchChatListItem.getRecentUserUin(), recentMatchChatListItem.getRecentUserType());
        }
    }

    private void s(RecentUser recentUser) {
        if (recentUser.getType() == 0 && Utils.G(recentUser.uin)) {
            int i3 = 0;
            SharedPreferences sharedPreferences = this.f185156m.getApp().getSharedPreferences(this.f185156m.getCurrentAccountUin(), 0);
            if (!sharedPreferences.getBoolean("babyQ_toast_flag", false)) {
                int i16 = sharedPreferences.getInt("babyQ_drag_count", 0) + 1;
                if (i16 >= 3) {
                    DialogUtil.createCustomDialog(this.f185153f, 230, "babyQ\u63d0\u9192", "\u662f\u5426\u9700\u8981\u5173\u95edbabyQ\u7684\u63a8\u9001\u5f00\u5173\n", HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.ket), new b(), new c()).show();
                    sharedPreferences.edit().putBoolean("babyQ_toast_flag", true);
                } else {
                    i3 = i16;
                }
                sharedPreferences.edit().putInt("babyQ_drag_count", i3).commit();
            }
        }
    }

    private void t(RecentMsgBoxItem recentMsgBoxItem) {
        recentMsgBoxItem.clearUnReadNum();
        if (ao.F(recentMsgBoxItem.getRecentUserUin())) {
            ThreadManagerV2.post(new Runnable(recentMsgBoxItem.getRecentUserUin(), recentMsgBoxItem.getRecentUserType()) { // from class: com.tencent.mobileqq.activity.recent.RecentAdapter.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f185157d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f185158e;

                {
                    this.f185157d = r6;
                    this.f185158e = r7;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, RecentAdapter.this, r6, Integer.valueOf(r7));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ((MessageHandler) RecentAdapter.this.f185156m.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).Y4(this.f185157d, this.f185158e, false);
                    }
                }
            }, 8, null, false);
            ReportController.o(this.f185156m, "CliOper", "", "", "0X8005298", "0X8005298", 0, 0, "", "", "", "");
            ReportController.o(this.f185156m, "dc00899", "grp_lbs", "", "msg_box", "drag_hi", 0, 0, "", "", "", "");
            return;
        }
        RecentUtil.I0(this.f185156m, recentMsgBoxItem.getRecentUserUin(), recentMsgBoxItem.getRecentUserType());
        this.f185156m.getMessageFacade().O0(recentMsgBoxItem.getRecentUserUin(), recentMsgBoxItem.getRecentUserType());
        if (ad.w(recentMsgBoxItem.getRecentUserUin())) {
            ReportController.o(this.f185156m, "dc00899", "grp_lbs", "", "msg_box", "drag_update", 0, 0, "", "", String.valueOf(recentMsgBoxItem.mFromFlag), "");
        } else if (ad.t(recentMsgBoxItem.getRecentUserUin())) {
            ReportController.o(this.f185156m, "dc00899", "grp_lbs", "", "msg_box", "drag_focus", 0, 0, "", "", "", "");
        }
    }

    private void u(RecentBaseData recentBaseData, String str, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                switch (i3) {
                    case 1001:
                    case 10002:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X80050FC", "0X80050FC", 0, 0, "", "", "", "");
                        if (recentBaseData instanceof RecentMsgBoxItem) {
                            ReportController.o(this.f185156m, "dc00899", "grp_lbs", ((RecentMsgBoxItem) recentBaseData).b(), "msg_box", "delete_msg", 0, 0, "", "", "", "");
                            return;
                        } else {
                            ReportController.o(this.f185156m, "dc00899", "grp_lbs", "", "msg_box", "swipe_msg", 0, 0, "", "", "", "");
                            return;
                        }
                    case 1008:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "3", "", str, "");
                        if (recentBaseData instanceof RecentItemEcShop) {
                            ReportController.o(this.f185156m, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsghelper", "Clk_DelshopItem", 0, 0, recentBaseData.getRecentUserUin(), "", recentBaseData.mTitleName, "");
                        }
                        String recentUserUin = recentBaseData.getRecentUserUin();
                        ReportController.o(this.f185156m, "dc00899", IPublicAccountHandler.MAIN_ACTION, recentUserUin, "0X80064C9", "0X80064C9", 0, 0, "" + recentBaseData.mUnreadNum, "", "", "");
                        ReportController.o(this.f185156m, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X80067EE", "0X80067EE", 0, 0, "" + recentBaseData.getRecentUserUin(), "", "", "");
                        RecentPubAccHelper.j(this.f185156m, recentBaseData.getRecentUserUin(), recentBaseData.mUnreadFlag, recentBaseData.getUnreadNum(), 1, recentBaseData.getTitleName(), RecentPubAccHelper.f());
                        if (AppConstants.WEISHI_UIN.equals(recentUserUin)) {
                            ((IWeiShiReportUtil) QRoute.api(IWeiShiReportUtil.class)).reportWeiShiDelete();
                            return;
                        }
                        return;
                    case 1010:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X80050FE", "0X80050FE", 0, 0, "", "", "", "");
                        return;
                    case 1022:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "7", "", str, "");
                        return;
                    case 3000:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "2", "", str, "");
                        return;
                    case 4000:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "6", "", str, "");
                        return;
                    case 5000:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "4", "", str, "");
                        return;
                    case 6000:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "8", "", str, "");
                        return;
                    case 6004:
                        ReportController.o(this.f185156m, "dc00898", "", "", "0X80090EB", "0X80090EB", 0, 0, "", "", "", "");
                        return;
                    case 7000:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "5", "", str, "");
                        return;
                    case AppConstants.VALUE.UIN_TYPE_EC_SHOP_ASSIST /* 7120 */:
                        ReportController.o(this.f185156m, "dc00899", IPublicAccountHandler.MAIN_ACTION, "1", "0X80064C5", "0X80064C5", 0, 0, "" + recentBaseData.mUnreadNum, "", "", "");
                        ReportController.o(this.f185156m, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X80067EE", "0X80067EE", 0, 0, "" + recentBaseData.getRecentUserUin(), "", "", "");
                        return;
                    case 7200:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "9", "", str, "");
                        return;
                    case AppConstants.VALUE.UIN_TYPE_TROOP_BAR_ASSIST /* 7210 */:
                        ReportController.o(this.f185156m, "dc00899", IPublicAccountHandler.MAIN_ACTION, "0", "0X80064C5", "0X80064C5", 0, 0, "" + recentBaseData.mUnreadNum, "", "", "");
                        ReportController.o(this.f185156m, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X80067EE", "0X80067EE", 0, 0, "" + recentBaseData.getRecentUserUin(), "", "", "");
                        return;
                    case 9002:
                        LpReportInfo_dc00518.report(100, 3, 0);
                        if (QLog.isColorLevel()) {
                            QLog.d("RecentAdapter", 2, "do report: QQnotice.list.delete");
                        }
                        ReportController.o(this.f185156m, "P_CliOper", "QQnotice", "", "", "QQnotice.list.delete", 0, 0, "", "", "", "");
                        return;
                    case 9505:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X8006353", "0X8006353", 0, 0, "", "", "", "");
                        return;
                    default:
                        ReportController.o(this.f185156m, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "999", str, "", "");
                        return;
                }
            }
            ReportController.o(this.f185156m, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "1", "", str, "");
            return;
        }
        ReportController.o(this.f185156m, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "0", "", str, "");
    }

    public static boolean z(QQAppInterface qQAppInterface, RecentBaseData recentBaseData) {
        return RecentUtil.O(recentBaseData);
    }

    public void A(View view, RecentBaseData recentBaseData, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, view, recentBaseData, drawable);
            return;
        }
        if (view != null && recentBaseData != null) {
            if (drawable == null) {
                int recentUserType = recentBaseData.getRecentUserType();
                if ((recentBaseData instanceof RecentCallItem) && ((RecentCallItem) recentBaseData).a()) {
                    recentUserType = 3002;
                }
                drawable = this.C.l(recentBaseData, recentUserType, recentBaseData.getRecentUserUin());
            }
            j g16 = this.f185151d.g(recentBaseData);
            if (g16 != null) {
                try {
                    g16.a(view, recentBaseData, this.f185153f, drawable);
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        if (!o() && this.f185152e.size() != 0) {
            return this.f185152e.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        try {
            if (!o() && this.f185152e.size() != 0) {
                if (i3 < 0 || i3 >= this.f185152e.size()) {
                    return null;
                }
                valueOf = this.f185152e.get(i3);
                return valueOf;
            }
            valueOf = Integer.valueOf(this.f185154h);
            return valueOf;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.i("Q.recent", 2, e16.toString());
            return null;
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, i3)).intValue();
        }
        return this.f185151d.i(getItem(i3));
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        View view4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            view3 = (View) iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), view, viewGroup);
            view4 = view;
        } else {
            try {
                Object item = getItem(i3);
                j g16 = this.f185151d.g(item);
                if (item instanceof RecentBaseData) {
                    RecentBaseData recentBaseData = (RecentBaseData) item;
                    y(recentBaseData);
                    view2 = g16.f(i3, recentBaseData, this.C, view, viewGroup, this.f185153f, this, this, this);
                    try {
                        com.tencent.imcore.message.report.b.a().c(this.f185156m, recentBaseData);
                    } catch (Throwable th5) {
                        th = th5;
                        QLog.i("RecentAdapter", 1, "getView", th);
                        view3 = view2;
                        view4 = view3;
                        EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
                        return view3;
                    }
                } else if (item instanceof Integer) {
                    view2 = g16.f(i3, item, null, view, viewGroup, this.f185153f, this, this, this);
                } else if (item instanceof String) {
                    view2 = g16.f(i3, item, null, view, viewGroup, this.f185153f, null, null, null);
                } else {
                    view2 = g16.f(i3, item, null, view, viewGroup, this.f185153f, null, null, null);
                }
            } catch (Throwable th6) {
                th = th6;
                view2 = view;
            }
            view3 = view2;
            view4 = view3;
        }
        EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
        return view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.f185151d.y();
    }

    public void h(RecentBaseData recentBaseData, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) recentBaseData, (Object) str);
            return;
        }
        e eVar = this.F;
        if (eVar != null) {
            eVar.Hg(recentBaseData, str);
        }
        List<Object> list = this.f185152e;
        if (list != null) {
            list.remove(recentBaseData);
            c();
            notifyDataSetChanged();
        }
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void hideMenuPop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.I;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.dismiss();
            this.I = null;
        }
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void interceptTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, z16);
        } else {
            FrameHelperActivity.gj(!z16, "RecentAdapter");
        }
    }

    public DragFrameLayout j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (DragFrameLayout) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.E;
    }

    public RecentBaseData l(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (RecentBaseData) iPatchRedirector.redirect((short) 39, (Object) this, (Object) view);
        }
        if (view != null && (view.getTag(-1) instanceof Integer)) {
            Object item = getItem(((Integer) view.getTag(-1)).intValue());
            if (item instanceof RecentBaseData) {
                return (RecentBaseData) item;
            }
        }
        return null;
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.D instanceof SwipListView) {
            return true;
        }
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            super.notifyDataSetChanged();
        }
    }

    protected boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        int i3 = this.f185154h;
        if (i3 != 3 && i3 != 8) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
        boolean z17;
        Integer num;
        String simpleName;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Boolean.valueOf(z16), Integer.valueOf(i3), qUIBadgeDragLayout);
            return;
        }
        if (z16) {
            if (qUIBadgeDragLayout != null && qUIBadgeDragLayout.getDragView() != null) {
                Object tag = qUIBadgeDragLayout.getDragView().getTag();
                if ((tag instanceof String) && (str = (String) tag) != null && str != com.tencent.mobileqq.activity.home.impl.b.f183049l) {
                    return;
                }
            }
            if (this.f185155i == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (i3 == 2) {
                com.tencent.mobileqq.activity.home.chats.unread.c.f183015a.a(this.f185156m);
                Object[] objArr = new Object[6];
                objArr[0] = "onChange type=";
                objArr[1] = Integer.valueOf(i3);
                objArr[2] = " from=";
                if (qUIBadgeDragLayout == null) {
                    simpleName = "null";
                } else {
                    simpleName = qUIBadgeDragLayout.getClass().getSimpleName();
                }
                objArr[3] = simpleName;
                objArr[4] = " Current Thread=";
                objArr[5] = Thread.currentThread().getName();
                QLog.d("RecentAdapter", 1, objArr);
                return;
            }
            View k3 = k(qUIBadgeDragLayout);
            if (k3 != null && (num = (Integer) k3.getTag()) != null) {
                int intValue = num.intValue();
                Object item = getItem(intValue);
                if (QLog.isColorLevel()) {
                    QLog.d("Drag", 2, "onChange:" + item);
                }
                if (item instanceof RecentBaseData) {
                    RecentBaseData recentBaseData = (RecentBaseData) item;
                    if (z17 && (item instanceof RecentUserBaseData)) {
                        RecentUser d16 = ((RecentUserBaseData) item).d();
                        n.c(this.f185156m, recentBaseData, d16, false);
                        if (er.b(this.f185156m.getApp(), "KEY_CLEAR_INVALID_UNREAD_MARK", true)) {
                            com.tencent.imcore.message.m.a(this.f185156m, d16.uin, d16.type);
                        }
                        g(d16);
                    }
                    r(intValue, item);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        } else if (!m(view)) {
            if (this.F != null) {
                Object tag = view.getTag(-1);
                if (!(tag instanceof Integer)) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
                    }
                } else {
                    int intValue = ((Integer) tag).intValue();
                    Object item = getItem(intValue);
                    if (QLog.isDevelopLevel()) {
                        QLog.i("Q.recent", 4, "onClick|obj = " + item);
                    }
                    if (item instanceof RecentBaseData) {
                        if ((view instanceof IRecentImgv) && (item instanceof RecentItemEcShop)) {
                            this.F.w4(view, item);
                        } else {
                            RecentBaseData recentBaseData = (RecentBaseData) item;
                            recentBaseData.mPosition = intValue;
                            this.F.U6(view, recentBaseData, recentBaseData.mTitleName, true);
                        }
                        xx.b.INSTANCE.z(item);
                    } else {
                        this.F.w4(view, item);
                    }
                }
            } else if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "onClick|mRecentLis is null");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (this.D != null && !TextUtils.isEmpty(str)) {
            if (bitmap == null && i3 > 0) {
                return;
            }
            if (bitmap != null) {
                try {
                    this.H.put(i16 + ":" + str, bitmap);
                } catch (OutOfMemoryError e16) {
                    System.gc();
                    e16.printStackTrace();
                    QLog.i("RecentAdapter", 1, "onDecodeTaskCompleted error:" + e16.getMessage());
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.G;
            if (j3 > 0 && currentTimeMillis - j3 > 300) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("RecentAdapter.onDecodeTaskCompleted type=");
                sb5.append(i16);
                sb5.append(", uin=");
                sb5.append(str);
                sb5.append(", remainingTasks=");
                sb5.append(i3);
                sb5.append(", isdecodeFaceTimeout=");
                sb5.append(z16);
                sb5.append(", avatar == null ? | ");
                if (bitmap == null) {
                    z17 = true;
                }
                sb5.append(z17);
                sb5.append(",style | ");
                sb5.append(this.f185155i);
                QLog.d("RecentAdapter", 2, sb5.toString());
            }
            if (i3 > 0 && !z16) {
                return;
            }
            synchronized (this.H) {
                if (this.H.size() == 0) {
                    return;
                }
                if (i3 == 0) {
                    this.G = 0L;
                } else {
                    this.G = currentTimeMillis;
                }
                d();
                this.H.clear();
            }
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.IDragViewProvider
    public List<View> onGetVisibleDragView() {
        View findViewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        int childCount = this.D.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.D.getChildAt(i3);
            if (childAt != null && (findViewById = childAt.findViewById(R.id.unreadmsg)) != null && (findViewById instanceof DragTextView)) {
                DragTextView dragTextView = (DragTextView) findViewById;
                if (findViewById.getVisibility() == 0 && dragTextView.c() != -1) {
                    arrayList.add(findViewById);
                }
            }
        }
        return arrayList;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        List<String> list;
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) view)).booleanValue();
        } else {
            RecentBaseData b16 = b(view);
            if (b16 != null) {
                int intValue = ((Integer) view.getTag(-1)).intValue();
                j g16 = this.f185151d.g(b16);
                i(b16);
                if (g16 != null) {
                    list = g16.e(b16, this.f185153f);
                } else {
                    list = null;
                }
                if (list != null && list.size() > 0 && SystemClock.uptimeMillis() - this.K > 100) {
                    com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        aVar.a(intValue, list.get(i3));
                    }
                    if (this.L) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.recent", 2, "MultiAIOStarter start multiaio successfully!");
                        }
                    } else {
                        try {
                            this.I = s.d(view, aVar, this.N, new a(view));
                            z16 = true;
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.i("Q.recent", 2, "long click showAsDropDown", th5);
                            }
                        }
                        this.K = SystemClock.uptimeMillis();
                    }
                    z16 = false;
                    this.K = SystemClock.uptimeMillis();
                } else if (QLog.isDevelopLevel()) {
                    QLog.i("Q.recent", 4, "RecentAdpater onLongClick no menu, builder = " + g16);
                }
            }
            z16 = false;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            this.C.r();
            this.f185156m = null;
        }
    }

    protected void q(RecentBaseData recentBaseData, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, recentBaseData, str, str2);
            return;
        }
        Resources resources = this.f185153f.getResources();
        int[] iArr = j.f185633c;
        if (!Utils.p(str, resources.getString(iArr[0])) && !Utils.p(str, resources.getString(iArr[10]))) {
            e eVar = this.F;
            if (eVar != null) {
                eVar.Td(str, recentBaseData, str2);
                return;
            }
            return;
        }
        if (recentBaseData.getRecentUserType() != 10007) {
            e(recentBaseData, str, str2);
        } else {
            e(recentBaseData, str, str2);
        }
        ReportController.o(this.f185156m, "dc00898", "", "", "0X800A360", "0X800A360", 0, 0, "1", "", str2, "");
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void updateCurShowRightView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) view);
            return;
        }
        int i3 = -1;
        if (view != null) {
            Object tag = view.getTag(-1);
            if (tag instanceof Integer) {
                i3 = ((Integer) tag).intValue();
            }
        }
        this.J = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void v(List<RecentBaseData> list) {
        int i3;
        Object obj;
        int firstVisiblePosition;
        int lastVisiblePosition;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
            return;
        }
        if (this.f185156m == null) {
            return;
        }
        hideMenuPop();
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "setDataList size = " + i3);
        }
        if (i3 == 0) {
            QLog.i("Q.recent", 2, "setDataList size = " + i3, new Exception("setDataListEmpty"));
        }
        XListView xListView = this.D;
        SwipListView swipListView = null;
        if (xListView instanceof SwipListView) {
            SwipListView swipListView2 = (SwipListView) xListView;
            int i16 = this.J;
            if (i16 >= 0 && i16 < this.f185152e.size()) {
                swipListView = this.f185152e.get(this.J);
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "setDataList findsel, [" + this.J + "," + swipListView + "]");
            }
            this.J = -1;
            SwipListView swipListView3 = swipListView;
            swipListView = swipListView2;
            obj = swipListView3;
        } else {
            obj = null;
        }
        this.f185152e.clear();
        if (list != null) {
            try {
                int i17 = -1;
                for (RecentBaseData recentBaseData : list) {
                    if (recentBaseData != null) {
                        i17++;
                        if (recentBaseData instanceof RecentItemChatMsgData) {
                            recentBaseData.mPosition = i17;
                        }
                        if (!z(this.f185156m, recentBaseData)) {
                            a(recentBaseData);
                            this.f185152e.add(recentBaseData);
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.i("Q.recent", 2, "setDataList, [item is null]");
                    }
                }
            } catch (Exception unused) {
            }
            if (swipListView != null) {
                if (this.f185152e.size() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                swipListView.setDragEnable(z16);
            }
            if (obj instanceof RecentBaseData) {
                RecentBaseData recentBaseData2 = (RecentBaseData) obj;
                if (swipListView == null) {
                    firstVisiblePosition = 0;
                } else {
                    firstVisiblePosition = swipListView.getFirstVisiblePosition();
                }
                int max = Math.max(firstVisiblePosition, 0);
                if (swipListView == null) {
                    lastVisiblePosition = this.f185152e.size();
                } else {
                    lastVisiblePosition = 1 + swipListView.getLastVisiblePosition();
                }
                int min = Math.min(lastVisiblePosition, this.f185152e.size());
                while (true) {
                    if (max >= min) {
                        break;
                    }
                    if (recentBaseData2.equals(this.f185152e.get(max))) {
                        this.J = max;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Q.recent", 4, "setDataList getsel, [" + max + "," + this.f185152e.get(max) + "]");
                        }
                    } else {
                        max++;
                    }
                }
            }
        }
        if (swipListView != null && this.J == -1) {
            swipListView.hideCurShowingRightView();
        }
        notifyDataSetChanged();
    }

    public void w(DragFrameLayout dragFrameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dragFrameLayout);
            return;
        }
        this.E = dragFrameLayout;
        dragFrameLayout.addOnDragModeChangeListener(this, true);
        this.E.addDragViewProviderByGroup(com.tencent.mobileqq.activity.home.impl.b.f183049l, this, true);
    }

    public void x(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        this.f185154h = i3;
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "setExtraFlag:" + i3);
        }
    }

    public void y(RecentBaseData recentBaseData) {
        PhoneContact phoneContact;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) recentBaseData);
            return;
        }
        if (recentBaseData != null && recentBaseData.getRecentUserType() == 8 && recentBaseData.mExtraType == 25) {
            IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f185156m.getRuntimeService(IPhoneContactService.class, "");
            if (iPhoneContactService != null && (str = recentBaseData.mPhoneNumber) != null) {
                phoneContact = iPhoneContactService.queryContactByCodeNumber(str);
            } else {
                phoneContact = null;
            }
            if (phoneContact != null) {
                recentBaseData.mTitleName = phoneContact.name;
                return;
            }
            QCallCardInfo c16 = ((com.tencent.mobileqq.qcall.c) this.f185156m.getManager(QQManagerFactory.QCALLCARD_MANAGER)).c(recentBaseData.getRecentUserUin());
            if (c16 != null) {
                recentBaseData.mTitleName = c16.nickname;
            }
        }
    }

    public RecentAdapter(Context context, QQAppInterface qQAppInterface, XListView xListView, e eVar, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, qQAppInterface, xListView, eVar, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.D = null;
        this.F = null;
        this.G = 0L;
        this.H = new Hashtable<>();
        this.J = -1;
        this.L = false;
        this.M = new ArrayList<Integer>(20) { // from class: com.tencent.mobileqq.activity.recent.RecentAdapter.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentAdapter.this, r5);
                    return;
                }
                add(0);
                add(1000);
                add(1020);
                add(1003);
                add(1025);
                add(1005);
                add(1004);
                add(1008);
                add(1001);
                add(10002);
                add(10004);
                add(1009);
                add(1023);
                add(1024);
                add(7000);
                add(1010);
                add(Integer.valueOf(AppConstants.VALUE.UIN_TYPE_KANDIAN_MERGE));
                add(10008);
                add(10010);
            }
        };
        this.N = new d();
        this.f185153f = context;
        this.D = xListView;
        this.F = eVar;
        this.f185156m = qQAppInterface;
        this.f185152e = new ArrayList(99);
        k kVar = new k(i3);
        this.f185151d = kVar;
        kVar.z(this);
        this.C = new i(qQAppInterface, this, z16);
        if (i3 == 0) {
            this.f185154h = 0;
        } else if (i3 == 1) {
            this.f185154h = 5;
        } else if (i3 == 9) {
            this.f185154h = 11;
        } else if (i3 == 11) {
            this.f185154h = 17;
        } else if (i3 == 12) {
            this.f185154h = 19;
        } else if (i3 == 13) {
            this.f185154h = 21;
        } else if (i3 == 15) {
            this.f185154h = 23;
        } else if (i3 == 17) {
            this.f185154h = 0;
        }
        this.f185155i = i3;
    }

    private void c() {
    }
}
