package com.tencent.mobileqq.newfriend.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.guild.api.IGuildAddQQFriendApi;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.controller.FriendSystemMsgController;
import com.tencent.mobileqq.newfriend.msg.p;
import com.tencent.mobileqq.newfriend.msg.r;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.ay;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipTextViewMenuBuilder;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import tencent.mobileim.structmsg.structmsg$AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsgAction;
import tencent.mobileim.structmsg.structmsg$SystemMsgActionInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NewFriendMoreSysMsgAdapter extends XBaseAdapter implements View.OnClickListener, SwipListView.SwipListListener, DecodeTaskCompletionListener, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;
    private static final int[] Y;
    private static final int[] Z;

    /* renamed from: a0, reason: collision with root package name */
    private static final int[] f254063a0;
    protected AppInterface C;
    private SwipRightMenuBuilder D;
    protected IFaceDecoder E;
    private int F;
    private int G;
    protected boolean H;
    private FlingHandler I;
    protected ArrayList<com.tencent.mobileqq.newfriend.msg.i> J;
    private HashMap<String, Bitmap> K;
    protected int L;
    private IPhoneContactService M;
    protected IMessageFacade N;
    protected boolean P;
    final ConcurrentHashMap<Long, String> Q;
    protected Comparator<com.tencent.mobileqq.newfriend.msg.i> R;
    protected com.tencent.mobileqq.avatar.observer.a S;
    private com.tencent.mobileqq.friend.observer.a T;
    private com.tencent.mobileqq.newfriend.observer.a U;
    protected com.tencent.mobileqq.newfriend.observer.b V;
    com.tencent.mobileqq.discussion.observer.a W;
    com.tencent.mobileqq.newfriend.observer.c X;

    /* renamed from: d, reason: collision with root package name */
    protected View f254064d;

    /* renamed from: e, reason: collision with root package name */
    public SwipListView f254065e;

    /* renamed from: f, reason: collision with root package name */
    private View f254066f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f254067h;

    /* renamed from: i, reason: collision with root package name */
    private QQProgressDialog f254068i;

    /* renamed from: m, reason: collision with root package name */
    protected Activity f254069m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends com.tencent.mobileqq.discussion.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void f(boolean z16, int i3, long j3, ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), arrayList);
            } else if (z16) {
                y(j3);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void g(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                try {
                    y(Long.parseLong(str));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void w(boolean z16, Object obj) {
            ArrayList arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (z16) {
                if (obj instanceof ArrayList) {
                    arrayList = (ArrayList) obj;
                } else {
                    arrayList = null;
                }
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next instanceof Long) {
                            y(((Long) next).longValue());
                        }
                    }
                }
            }
        }

        public void y(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
                return;
            }
            if (j3 != 0 && NewFriendMoreSysMsgAdapter.this.Q.containsKey(Long.valueOf(j3))) {
                String str = NewFriendMoreSysMsgAdapter.this.Q.get(Long.valueOf(j3));
                String discussionNameCanNull = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getDiscussionNameCanNull(NewFriendMoreSysMsgAdapter.this.C, String.valueOf(j3));
                if (!TextUtils.isEmpty(discussionNameCanNull) && !discussionNameCanNull.equals(str)) {
                    NewFriendMoreSysMsgAdapter.this.x(false);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "checkIfNeedUpdate [uin: %d, pre: %s, cur: %s]", Long.valueOf(j3), str, discussionNameCanNull));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends com.tencent.mobileqq.newfriend.observer.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.c
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else if (z16) {
                NewFriendMoreSysMsgAdapter.this.w();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements IAddAcceptBlockStrategy.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f254079a;

        c(Object obj) {
            this.f254079a = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this, obj);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
        public void onSuccess() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.newfriend.ui.holder.a aVar = (com.tencent.mobileqq.newfriend.ui.holder.a) this.f254079a;
            String str = null;
            if (aVar.H != 2) {
                NewFriendMoreSysMsgAdapter.this.z(aVar.E.get(), aVar.F);
                structmsg$StructMsg g16 = FriendSystemMsgController.e().g(Long.valueOf(FriendSystemMsgController.e().c()));
                boolean z16 = true;
                boolean z17 = false;
                if (g16 != null) {
                    int i16 = g16.msg_type.get();
                    long j3 = g16.msg_seq.get();
                    long j16 = g16.req_uin.get();
                    int i17 = g16.f436065msg.sub_type.get();
                    int i18 = g16.f436065msg.src_id.get();
                    int i19 = g16.f436065msg.sub_src_id.get();
                    int i26 = g16.f436065msg.group_msg_type.get();
                    str = String.valueOf(j16);
                    List<structmsg$SystemMsgAction> list = g16.f436065msg.actions.get();
                    if (list != null && list.size() > 0) {
                        structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo = list.get(0).action_info.get();
                        structmsg_systemmsgactioninfo.remark.set("");
                        structmsg_systemmsgactioninfo.group_id.set(0);
                        structmsg$AddFrdSNInfo structmsg_addfrdsninfo = new structmsg$AddFrdSNInfo();
                        structmsg_addfrdsninfo.uint32_not_see_dynamic.set(0);
                        structmsg_addfrdsninfo.uint32_set_sn.set(0);
                        structmsg_systemmsgactioninfo.addFrdSNInfo.set(structmsg_addfrdsninfo);
                        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).sendFriendSystemMsgAction(i16, j3, j16, i17, i18, i19, i26, structmsg_systemmsgactioninfo, 0, g16, false, NewFriendMoreSysMsgAdapter.this.C);
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("agree, ");
                        if (list != null) {
                            i3 = list.size();
                        } else {
                            i3 = -1;
                        }
                        sb5.append(i3);
                        QLog.d("NewFriendMoreSysMsgAdapter", 1, sb5.toString());
                        z16 = false;
                    }
                    if (Utils.G(String.valueOf(j16))) {
                        ReportController.o(NewFriendMoreSysMsgAdapter.this.C, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
                    }
                    z17 = z16;
                } else {
                    QLog.d("NewFriendMoreSysMsgAdapter", 1, "agree");
                }
                String str2 = str;
                if (z17) {
                    NewFriendMoreSysMsgAdapter.this.B();
                }
                ReportController.o(NewFriendMoreSysMsgAdapter.this.C, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
                ReportController.o(NewFriendMoreSysMsgAdapter.this.C, "dc00898", "", "", "0X800C07F", "0X800C07F", 2, 0, str2, "", "", "");
                return;
            }
            IAddFriendTempApi iAddFriendTempApi = (IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class);
            NewFriendMoreSysMsgAdapter newFriendMoreSysMsgAdapter = NewFriendMoreSysMsgAdapter.this;
            iAddFriendTempApi.clickQIMSource(newFriendMoreSysMsgAdapter.f254069m, null, newFriendMoreSysMsgAdapter.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d extends SwipTextViewMenuBuilder {
        static IPatchRedirector $redirector_;

        d(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4) {
            super(i3, i16, iArr, i17, iArr2, iArr3, iArr4);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NewFriendMoreSysMsgAdapter.this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Integer.valueOf(i17), iArr2, iArr3, iArr4);
            }
        }

        @Override // com.tencent.widget.SwipRightMenuBuilder
        public void getRightMenuItemInfo(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), obj, swipRightMenuItemArr);
                return;
            }
            if (swipRightMenuItemArr != null && swipRightMenuItemArr.length > 0) {
                if (swipRightMenuItemArr.length > 0) {
                    SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[0];
                    swipRightMenuItem.menuId = 0;
                    swipRightMenuItem.menuType = 0;
                } else {
                    i16 = 0;
                }
                while (i16 < swipRightMenuItemArr.length) {
                    SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem2 = swipRightMenuItemArr[i16];
                    swipRightMenuItem2.menuId = -1;
                    swipRightMenuItem2.menuType = -1;
                    i16++;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e implements Comparator<com.tencent.mobileqq.newfriend.msg.i> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.newfriend.msg.i iVar, com.tencent.mobileqq.newfriend.msg.i iVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar, (Object) iVar2)).intValue();
            }
            return (int) (iVar2.f254036b - iVar.f254036b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f254083d;

        f(AppInterface appInterface) {
            this.f254083d = appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this, (Object) appInterface);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(this.f254083d, "dc00898", "", "", "0X800A327", "0X800A327", 0, 0, "", "", "", "");
                NewFriendMoreSysMsgAdapter.this.i();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "clear click");
            }
            if (NetworkUtil.isNetSupport(NewFriendMoreSysMsgAdapter.this.f254069m)) {
                ReportController.o(NewFriendMoreSysMsgAdapter.this.C, "dc00898", "", "", "0X800A328", "0X800A328", 2, 0, "", "", "", "");
                NewFriendMoreSysMsgAdapter.this.B();
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).clearAllSystemMsg(NewFriendMoreSysMsgAdapter.this.C);
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).deleteAllSuspiciousMsg(NewFriendMoreSysMsgAdapter.this.C);
                return;
            }
            QQToast.makeText(NewFriendMoreSysMsgAdapter.this.f254069m, R.string.cib, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "cancel click");
            }
            ReportController.o(NewFriendMoreSysMsgAdapter.this.C, "dc00898", "", "", "0X800A328", "0X800A328", 1, 0, "", "", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class i extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                NewFriendMoreSysMsgAdapter.this.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class j extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        public void onAddBatchPhoneFriend(boolean z16, ArrayList<AddBatchPhoneFriendResult> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), arrayList);
            } else if (z16) {
                NewFriendMoreSysMsgAdapter.this.w();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
            } else if (z16 && friendlist.a.a(bundle.getInt("source_id"))) {
                NewFriendMoreSysMsgAdapter.this.w();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class k extends com.tencent.mobileqq.newfriend.observer.a {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        protected void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ArrayList<com.tencent.mobileqq.newfriend.msg.i> arrayList = (ArrayList) NewFriendMoreSysMsgAdapter.this.J.clone();
            if (!arrayList.isEmpty()) {
                Iterator<com.tencent.mobileqq.newfriend.msg.i> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.mobileqq.newfriend.msg.i next = it.next();
                    if (next instanceof com.tencent.mobileqq.newfriend.msg.c) {
                        com.tencent.mobileqq.newfriend.msg.c cVar = (com.tencent.mobileqq.newfriend.msg.c) next;
                        int i3 = cVar.f254022d.structMsg.f436065msg.sub_type.get();
                        String str2 = cVar.f254022d.senderuin;
                        if (i3 == 13 && str.equals(str2)) {
                            it.remove();
                            break;
                        }
                    }
                }
                NewFriendMoreSysMsgAdapter newFriendMoreSysMsgAdapter = NewFriendMoreSysMsgAdapter.this;
                newFriendMoreSysMsgAdapter.J = arrayList;
                newFriendMoreSysMsgAdapter.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                NewFriendMoreSysMsgAdapter.this.w();
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        protected void i(boolean z16, String str, String str2, byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
            } else if (z16) {
                NewFriendMoreSysMsgAdapter.this.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        public void j(boolean z16, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSuspiciousGetUnreadNum " + z16 + " " + i3 + " " + i16);
            }
            if (NewFriendMoreSysMsgAdapter.this.f254067h != null && NewFriendMoreSysMsgAdapter.this.f254067h.getVisibility() == 0) {
                if (z16 && i16 > 0) {
                    NewFriendMoreSysMsgAdapter.this.f254067h.setText(i16 + "");
                    return;
                }
                NewFriendMoreSysMsgAdapter.this.f254067h.setText("");
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        protected void l(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
            } else if (z16) {
                NewFriendMoreSysMsgAdapter.this.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class l extends com.tencent.mobileqq.newfriend.observer.b {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onDeleteAllSysMsg(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "onDeleteAllSysMsg " + z16 + " " + i3);
            }
            NewFriendMoreSysMsgAdapter.this.m();
            if (z16) {
                Activity activity = NewFriendMoreSysMsgAdapter.this.f254069m;
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            QQToast.makeText(NewFriendMoreSysMsgAdapter.this.f254069m, R.string.iz8, 0).show();
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onGetDelSystemMsgError() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "onGetDelSystemMsgError");
            }
            NewFriendMoreSysMsgAdapter.this.m();
            QQToast.makeText(NewFriendMoreSysMsgAdapter.this.f254069m, 1, NewFriendMoreSysMsgAdapter.this.f254069m.getResources().getString(R.string.huj), 0).show(NewFriendMoreSysMsgAdapter.this.q());
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onGetDelSystemMsgFin(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "onGetDelSystemMsgFin|isSuccess : " + z16 + ", bTimeOut : " + z17);
            }
            NewFriendMoreSysMsgAdapter.this.m();
            if (z16) {
                NewFriendMoreSysMsgAdapter.this.w();
            } else if (z17) {
                NewFriendMoreSysMsgAdapter newFriendMoreSysMsgAdapter = NewFriendMoreSysMsgAdapter.this;
                if (newFriendMoreSysMsgAdapter.H) {
                    QQToast.makeText(NewFriendMoreSysMsgAdapter.this.f254069m, 1, newFriendMoreSysMsgAdapter.f254069m.getResources().getString(R.string.huj), 0).show(NewFriendMoreSysMsgAdapter.this.q());
                }
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onGetSystemMsgFin(boolean z16, boolean z17, List<MessageRecord> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "onGetSystemMsgFin|isSuccess : " + z16 + ", bTimeOut : " + z17);
            }
            if (NewFriendMoreSysMsgAdapter.this.f254069m.isFinishing()) {
                return;
            }
            if (z16) {
                NewFriendMoreSysMsgAdapter.this.w();
            } else if (z17) {
                NewFriendMoreSysMsgAdapter newFriendMoreSysMsgAdapter = NewFriendMoreSysMsgAdapter.this;
                if (newFriendMoreSysMsgAdapter.H) {
                    QQToast.makeText(NewFriendMoreSysMsgAdapter.this.f254069m, 1, newFriendMoreSysMsgAdapter.f254069m.getResources().getString(R.string.huq), 0).show(NewFriendMoreSysMsgAdapter.this.q());
                }
            }
            NewFriendMoreSysMsgAdapter.this.C();
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onSendSystemMsgActionError(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSendSystemMsgActionError execute");
            }
            NewFriendMoreSysMsgAdapter.this.m();
            QQToast.makeText(NewFriendMoreSysMsgAdapter.this.f254069m, 1, NewFriendMoreSysMsgAdapter.this.f254069m.getResources().getString(R.string.huv), 0).show(NewFriendMoreSysMsgAdapter.this.q());
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onSendSystemMsgActionFin(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18) {
            String str5 = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17), str5, str4, Integer.valueOf(i18));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSendSystemMsgActionFin|isSuccess : " + z16 + ",logStr : " + str + ",actionType : " + i3 + ", msgDetail : " + str2 + ",resultCode : " + i16 + ", respType : " + i17 + "msgFail : " + str5 + "msgInvalidDecided : " + str4 + ",remarkRet : " + i18);
            }
            NewFriendMoreSysMsgAdapter.this.m();
            NewFriendMoreSysMsgAdapter.this.notifyDataSetChanged();
            long c16 = FriendSystemMsgController.e().c();
            if (!TextUtils.isEmpty(str)) {
                try {
                    c16 = Long.parseLong(str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            structmsg$StructMsg g16 = FriendSystemMsgController.e().g(Long.valueOf(c16));
            if (!z16) {
                if (TextUtils.isEmpty(str3)) {
                    str5 = NewFriendMoreSysMsgAdapter.this.f254069m.getResources().getString(R.string.he7);
                }
                QQToast.makeText(NewFriendMoreSysMsgAdapter.this.f254069m, 1, str5, 0).show(NewFriendMoreSysMsgAdapter.this.q());
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).changeStructMsgActionsWhenFail(g16, i17, str2, str4);
                return;
            }
            NewFriendMoreSysMsgAdapter newFriendMoreSysMsgAdapter = NewFriendMoreSysMsgAdapter.this;
            if (!newFriendMoreSysMsgAdapter.P) {
                QQToast.makeText(NewFriendMoreSysMsgAdapter.this.f254069m, 2, newFriendMoreSysMsgAdapter.f254069m.getResources().getString(R.string.bcs), 0).show(NewFriendMoreSysMsgAdapter.this.q());
            }
            long d16 = FriendSystemMsgController.e().d();
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).changeStructMsgActions(g16, i3, str2, i16);
            if (d16 != 0 && g16 != null) {
                try {
                    NewFriendMoreSysMsgAdapter.this.N.updateMsgContentByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, d16, g16.toByteArray());
                } catch (Exception e17) {
                    e17.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSendSystemMsgActionFin Exception!");
                    }
                }
            }
            if (i3 == 0 && g16 != null) {
                NewFriendMoreSysMsgAdapter newFriendMoreSysMsgAdapter2 = NewFriendMoreSysMsgAdapter.this;
                if (!newFriendMoreSysMsgAdapter2.P) {
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startRemarkAfterAgree(NewFriendMoreSysMsgAdapter.this.f254069m, 0, String.valueOf(g16.req_uin.get()), c16, NewFriendMoreSysMsgAdapter.this.p(g16));
                } else {
                    newFriendMoreSysMsgAdapter2.P = false;
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31327);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
            return;
        }
        Y = new int[]{R.string.f170822ak3};
        Z = new int[]{R.drawable.cja};
        f254063a0 = new int[]{R.id.epz};
    }

    public NewFriendMoreSysMsgAdapter(Activity activity, AppInterface appInterface, SwipListView swipListView, View view, View view2, FlingHandler flingHandler, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, appInterface, swipListView, view, view2, flingHandler, Integer.valueOf(i3));
            return;
        }
        this.F = -1;
        this.J = new ArrayList<>();
        this.K = new HashMap<>();
        this.P = false;
        this.Q = new ConcurrentHashMap<>();
        this.R = new e();
        this.S = new i();
        this.T = new j();
        this.U = new k();
        this.V = new l();
        this.W = new a();
        this.X = new b();
        this.f254069m = activity;
        this.C = appInterface;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        this.E = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.f254064d = view;
        this.f254065e = swipListView;
        d();
        this.f254065e.setAdapter((ListAdapter) this);
        this.f254065e.setOnScrollListener(this);
        this.f254065e.setDragEnable(true);
        e();
        this.D = k(activity);
        this.I = flingHandler;
        this.L = i3;
        this.M = (IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "");
        this.N = (IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "");
        x(true);
        if (view2 != null) {
            view2.setOnClickListener(new f(appInterface));
        }
        this.f254065e.addHeaderView(j(activity));
        ReportController.o(appInterface, "dc00898", "", "", "0X800C07D", "0X800C07D", 0, 0, appInterface.getCurrentAccountUin(), "", "", "");
    }

    private void A(com.tencent.mobileqq.newfriend.ui.holder.a aVar) {
        int i3;
        int i16;
        structmsg$StructMsg structmsg_structmsg = aVar.E;
        if (structmsg_structmsg.f436065msg.req_uin_gender.has()) {
            i3 = structmsg_structmsg.f436065msg.req_uin_gender.get();
        } else {
            i3 = -1;
        }
        if (structmsg_structmsg.f436065msg.req_uin_age.has()) {
            i16 = structmsg_structmsg.f436065msg.req_uin_age.get();
        } else {
            i16 = 0;
        }
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).showGenderAgeNewStyle(aVar.f254168f, i3, i16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.f254068i == null) {
            this.f254068i = new QQProgressDialog(this.f254069m, q());
        }
        this.f254068i.setMessage(this.f254069m.getString(R.string.hex));
        this.f254068i.show();
    }

    private void D(Context context, View view, int i3, Object obj, SwipRightMenuBuilder.SwipItemBaseHolder swipItemBaseHolder, View.OnClickListener onClickListener) {
        int i16;
        SwipRightMenuBuilder swipRightMenuBuilder = this.D;
        if (swipRightMenuBuilder != null) {
            i16 = swipRightMenuBuilder.updateRightMenuView(context, view, i3, obj, swipItemBaseHolder, onClickListener);
        } else {
            i16 = 0;
        }
        int i17 = this.F;
        if (i17 != -1) {
            if (i3 != i17) {
                view.scrollTo(0, 0);
            } else {
                view.scrollTo(i16, 0);
            }
        }
    }

    private void c(com.tencent.mobileqq.newfriend.ui.holder.a aVar) {
        if (QQTheme.isNowThemeIsNight()) {
            com.tencent.mobileqq.newfriend.utils.a.e(aVar.C, aVar.f254169h, aVar.f254170i);
        }
    }

    private void d() {
        if (this.f254066f == null) {
            this.f254066f = LayoutInflater.from(this.f254069m).inflate(R.layout.b3a, (ViewGroup) null);
        }
        if (this.f254066f.getParent() == null) {
            this.f254065e.addFooterView(this.f254066f);
        }
        this.f254066f.setVisibility(8);
    }

    private void f(com.tencent.mobileqq.newfriend.ui.holder.a aVar, int i3, structmsg$StructMsg structmsg_structmsg, long j3) {
        String str;
        aVar.D = i3;
        aVar.G = String.valueOf(structmsg_structmsg.req_uin.get());
        aVar.E = structmsg_structmsg;
        aVar.F = j3;
        aVar.H = 0;
        structmsg$SystemMsg structmsg_systemmsg = structmsg_structmsg.f436065msg;
        String str2 = null;
        if (structmsg_systemmsg != null) {
            str = structmsg_systemmsg.req_uin_nick.get();
        } else {
            str = null;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(aVar.E.req_uin.get())), "NewFriendMoreSysMsgAdapter");
        if (friendsSimpleInfoWithUid != null && !TextUtils.isEmpty(friendsSimpleInfoWithUid.r())) {
            str = friendsSimpleInfoWithUid.r();
        }
        String valueOf = String.valueOf(structmsg_structmsg.req_uin.get());
        if (TextUtils.isEmpty(str)) {
            str = valueOf;
        }
        if (!TextUtils.isEmpty(str)) {
            aVar.f254167e.setVisibility(0);
            String b16 = ay.b(aVar.G);
            if (!TextUtils.isEmpty(b16)) {
                aVar.f254167e.setText(b16);
            } else {
                aVar.f254167e.setText(str);
            }
        } else {
            aVar.f254167e.setVisibility(8);
        }
        if (!TextUtils.isEmpty(valueOf) && Utils.G(valueOf)) {
            Drawable drawable = this.f254069m.getResources().getDrawable(R.drawable.br7);
            drawable.setBounds(0, 0, ViewUtils.dip2px(15.0f), ViewUtils.dip2px(15.0f));
            ThemeUtil.setThemeFilter(drawable, ThemeUtil.curThemeId);
            aVar.f254167e.setCompoundDrawablePadding(ViewUtils.dip2px(5.0f));
            aVar.f254167e.setCompoundDrawables(null, null, drawable, null);
        } else {
            aVar.f254167e.setCompoundDrawables(null, null, null, null);
        }
        n(aVar);
        aVar.f254166d.setTag(aVar);
        aVar.f254168f.setVisibility(8);
        structmsg$SystemMsg structmsg_systemmsg2 = structmsg_structmsg.f436065msg;
        if (structmsg_systemmsg2 != null) {
            String str3 = structmsg_systemmsg2.msg_source.get();
            if (!TextUtils.isEmpty(str3) && u(structmsg_structmsg)) {
                String[] split = structmsg_structmsg.f436065msg.bytes_source_desc.get().toStringUtf8().split(ContainerUtils.FIELD_DELIMITER);
                if (split.length > 6) {
                    str3 = String.format(Locale.getDefault(), "%s-%s", str3, split[6]);
                }
            }
            str2 = str3;
            int i16 = structmsg_structmsg.f436065msg.uint32_source_flag.get();
            if (!TextUtils.isEmpty(str2) && (i16 & 8) == 8) {
                long j16 = structmsg_structmsg.f436065msg.uint64_discuss_uin.get();
                if (j16 != 0) {
                    String str4 = this.Q.get(Long.valueOf(j16));
                    if (!TextUtils.isEmpty(str4)) {
                        str2 = String.format(Locale.getDefault(), "%s-%s", str2, str4);
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.f254170i.setText(String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.op6), str2));
            aVar.f254170i.setVisibility(0);
        } else {
            aVar.f254170i.setVisibility(8);
        }
        if (structmsg_structmsg.f436065msg != null) {
            y(aVar, structmsg_structmsg);
            switch (structmsg_structmsg.f436065msg.sub_type.get()) {
                case 1:
                    if (structmsg_structmsg.f436065msg.actions.get() != null && structmsg_structmsg.f436065msg.actions.get().size() > 0 && !TextUtils.isEmpty(structmsg_structmsg.f436065msg.actions.get().get(0).name.get())) {
                        aVar.C.setVisibility(8);
                        aVar.f254171m.setVisibility(0);
                        aVar.f254171m.setText(structmsg_structmsg.f436065msg.actions.get().get(0).name.get());
                    } else if (structmsg_structmsg.f436065msg.actions.get() != null && structmsg_structmsg.f436065msg.actions.get().size() == 0) {
                        aVar.C.setVisibility(0);
                        aVar.C.setText(structmsg_structmsg.f436065msg.msg_decided.get());
                        aVar.f254171m.setVisibility(8);
                    }
                    A(aVar);
                    break;
                case 2:
                case 3:
                    aVar.C.setVisibility(0);
                    aVar.C.setText(structmsg_structmsg.f436065msg.msg_decided.get());
                    aVar.f254171m.setVisibility(8);
                    A(aVar);
                    break;
                case 4:
                case 5:
                    aVar.C.setVisibility(8);
                    aVar.f254171m.setVisibility(8);
                    break;
                case 6:
                    if (!TextUtils.isEmpty(structmsg_structmsg.f436065msg.msg_additional.get())) {
                        aVar.f254170i.setText(structmsg_structmsg.f436065msg.msg_additional.get());
                        aVar.f254169h.setText(structmsg_structmsg.f436065msg.msg_describe.get());
                    } else {
                        aVar.f254170i.setVisibility(8);
                    }
                    aVar.f254171m.setVisibility(8);
                    aVar.C.setVisibility(8);
                    break;
                case 7:
                    aVar.C.setVisibility(0);
                    aVar.C.setText(structmsg_structmsg.f436065msg.msg_decided.get());
                    aVar.f254171m.setVisibility(8);
                    A(aVar);
                    break;
                case 8:
                    aVar.C.setVisibility(0);
                    aVar.C.setText(structmsg_structmsg.f436065msg.msg_decided.get());
                    aVar.f254171m.setVisibility(8);
                    break;
                case 9:
                    if (structmsg_structmsg.f436065msg.actions.get() != null && structmsg_structmsg.f436065msg.actions.get().size() > 0 && !TextUtils.isEmpty(structmsg_structmsg.f436065msg.actions.get().get(0).name.get())) {
                        aVar.C.setVisibility(8);
                        aVar.f254171m.setVisibility(0);
                        aVar.f254171m.setText(structmsg_structmsg.f436065msg.actions.get().get(0).name.get());
                    } else {
                        aVar.C.setVisibility(0);
                        aVar.C.setText(structmsg_structmsg.f436065msg.msg_decided.get());
                        aVar.f254171m.setVisibility(8);
                    }
                    A(aVar);
                    break;
                case 10:
                    if (structmsg_structmsg.f436065msg.actions.get() != null && structmsg_structmsg.f436065msg.actions.get().size() > 0 && !TextUtils.isEmpty(structmsg_structmsg.f436065msg.actions.get().get(0).name.get())) {
                        aVar.C.setVisibility(8);
                        aVar.f254171m.setVisibility(0);
                        aVar.f254171m.setText(structmsg_structmsg.f436065msg.actions.get().get(0).name.get());
                    } else {
                        aVar.C.setVisibility(0);
                        aVar.C.setText(structmsg_structmsg.f436065msg.msg_decided.get());
                        aVar.f254171m.setVisibility(8);
                    }
                    A(aVar);
                    break;
                case 12:
                    if (structmsg_structmsg.f436065msg.reqsubtype.has()) {
                        if (structmsg_structmsg.f436065msg.reqsubtype.get() == 1) {
                            aVar.C.setVisibility(0);
                            aVar.C.setText(structmsg_structmsg.f436065msg.msg_decided.get());
                            aVar.f254171m.setVisibility(8);
                            break;
                        } else if (structmsg_structmsg.f436065msg.reqsubtype.get() == 2) {
                            aVar.C.setVisibility(8);
                            aVar.f254171m.setVisibility(8);
                            break;
                        }
                    }
                    break;
                case 13:
                    aVar.C.setVisibility(0);
                    aVar.C.setText(structmsg_structmsg.f436065msg.msg_decided.get());
                    aVar.f254171m.setVisibility(8);
                    aVar.f254170i.setVisibility(8);
                    break;
            }
            aVar.f254171m.setTag(aVar);
            aVar.f254171m.setOnClickListener(this);
            aVar.K.setTag(aVar);
            aVar.K.setOnClickListener(this);
        }
    }

    private void g(com.tencent.mobileqq.newfriend.ui.holder.a aVar, PhoneContactAdd phoneContactAdd) {
        aVar.H = 1;
        aVar.I = phoneContactAdd;
        if (!TextUtils.isEmpty(phoneContactAdd.name)) {
            aVar.f254167e.setVisibility(0);
            aVar.f254167e.setText(phoneContactAdd.name);
        } else {
            aVar.f254167e.setVisibility(8);
        }
        aVar.f254168f.setVisibility(8);
        aVar.f254170i.setVisibility(8);
        if (!TextUtils.isEmpty(phoneContactAdd.remindInfo)) {
            aVar.f254169h.setVisibility(0);
            aVar.f254169h.setText(phoneContactAdd.remindInfo);
        } else {
            aVar.f254169h.setVisibility(8);
        }
        aVar.C.setVisibility(0);
        aVar.f254171m.setVisibility(8);
        aVar.C.setText(this.f254069m.getString(R.string.f173067h24));
        String str = phoneContactAdd.unifiedCode;
        aVar.G = str;
        aVar.f254166d.setImageBitmap(o(11, str));
    }

    private void h(com.tencent.mobileqq.newfriend.ui.holder.a aVar, QIMNotifyAddFriend qIMNotifyAddFriend) {
        aVar.H = 2;
        aVar.J = qIMNotifyAddFriend;
        String b16 = ay.b(String.valueOf(qIMNotifyAddFriend.uin));
        if (!TextUtils.isEmpty(b16)) {
            aVar.f254167e.setText(b16);
        } else {
            aVar.f254167e.setText(qIMNotifyAddFriend.nickName);
        }
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).showGenderAge(aVar.f254168f, qIMNotifyAddFriend.gender, qIMNotifyAddFriend.age, null);
        String qQInfoFromQQUin = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getQQInfoFromQQUin(qIMNotifyAddFriend.uin, qIMNotifyAddFriend.qqUin, this.C);
        if (TextUtils.isEmpty(qQInfoFromQQUin)) {
            aVar.f254169h.setVisibility(8);
        } else {
            aVar.f254169h.setVisibility(0);
            aVar.f254169h.setText(qQInfoFromQQUin);
        }
        String qIMNewFriendSource = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getQIMNewFriendSource(this.C);
        if (TextUtils.isEmpty(qIMNewFriendSource)) {
            qIMNewFriendSource = "\u6765\u81eaQIM\u7684\u597d\u53cb\u7533\u8bf7";
        }
        aVar.f254170i.setText(String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.op6), qIMNewFriendSource));
        aVar.f254170i.setVisibility(0);
        aVar.C.setVisibility(8);
        aVar.f254171m.setText(HardCodeUtil.qqStr(R.string.f172236op0));
        aVar.f254171m.setVisibility(0);
        aVar.f254171m.setTag(aVar);
        aVar.f254171m.setOnClickListener(this);
        aVar.K.setTag(aVar);
        aVar.K.setOnClickListener(this);
        aVar.G = String.valueOf(qIMNotifyAddFriend.uin);
        aVar.f254166d.setImageBitmap(o(1, String.valueOf(qIMNotifyAddFriend.uin)));
    }

    private View j(Context context) {
        View view = new View(context);
        view.setMinimumHeight(ViewUtils.dip2px(12.0f));
        return view;
    }

    private SwipRightMenuBuilder k(Context context) {
        return new d(1, 2, new int[]{context.getResources().getDimensionPixelSize(R.dimen.atw), context.getResources().getDimensionPixelSize(R.dimen.atx)}, -1, f254063a0, Y, Z);
    }

    private View l(Context context, int i3, com.tencent.mobileqq.newfriend.ui.holder.a aVar) {
        return this.D.createView(context, LayoutInflater.from(context).inflate(i3, (ViewGroup) null), aVar, -1);
    }

    private void n(com.tencent.mobileqq.newfriend.ui.holder.a aVar) {
        Bitmap bitmapFromCache;
        if (aVar != null && aVar.f254166d != null) {
            int i3 = aVar.E.f436065msg.src_id.get();
            boolean z16 = false;
            if (i3 == 3007 || i3 == 3019 || i3 == 2007 || i3 == 4007 || i3 == 2019) {
                if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(aVar.E.req_uin.get())), "NewFriendMoreSysMsgAdapter")) {
                    z16 = true;
                }
            }
            if (z16) {
                bitmapFromCache = this.E.getBitmapFromCache(32, String.valueOf(aVar.E.req_uin.get()), 200);
                if (bitmapFromCache == null && !this.E.isPausing()) {
                    this.E.requestDecodeStrangeFace(String.valueOf(aVar.E.req_uin.get()), 200, true, true);
                }
            } else {
                bitmapFromCache = this.E.getBitmapFromCache(1, String.valueOf(aVar.E.req_uin.get()));
                if (bitmapFromCache == null && !this.E.isPausing()) {
                    this.E.requestDecodeFace(String.valueOf(aVar.E.req_uin.get()), 1, true);
                }
            }
            if (bitmapFromCache == null) {
                bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
            }
            aVar.f254166d.setImageBitmap(bitmapFromCache);
        }
    }

    private void s(View view) {
        if (!NetworkUtil.isNetworkAvailable(this.f254069m)) {
            Activity activity = this.f254069m;
            QQToast.makeText(activity, activity.getResources().getString(R.string.b3j), 0).show(q());
            return;
        }
        if (!Utils.p(SwipTextViewMenuBuilder.TAG_SWIP_ICON_MENU_ITEM, view.getTag())) {
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick tag is not int");
                return;
            }
            return;
        }
        Object tag = view.getTag(-1);
        Object tag2 = view.getTag(-2);
        if ((tag instanceof Integer) && (tag2 instanceof Integer)) {
            int intValue = ((Integer) tag).intValue();
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick position = " + intValue);
            }
            Object item = getItem(intValue);
            if (!(item instanceof com.tencent.mobileqq.newfriend.msg.i)) {
                return;
            }
            com.tencent.mobileqq.newfriend.msg.i iVar = (com.tencent.mobileqq.newfriend.msg.i) item;
            if (iVar instanceof com.tencent.mobileqq.newfriend.msg.c) {
                B();
                IAddFriendTempApi iAddFriendTempApi = (IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class);
                MessageForSystemMsg messageForSystemMsg = ((com.tencent.mobileqq.newfriend.msg.c) iVar).f254022d;
                iAddFriendTempApi.sendDelSingleSystemMsg(messageForSystemMsg.structMsg, messageForSystemMsg.frienduin, messageForSystemMsg.istroop, messageForSystemMsg.uniseq, this.C);
                ReportController.o(this.C, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
                return;
            }
            if (iVar instanceof p) {
                ThreadManagerV2.postImmediately(new Runnable(iVar) { // from class: com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.13
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.mobileqq.newfriend.msg.i f254070d;

                    {
                        this.f254070d = iVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this, (Object) iVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            ((IPhoneContactService) NewFriendMoreSysMsgAdapter.this.C.getRuntimeService(IPhoneContactService.class, "")).deletePhoneContactAddInfo(((p) this.f254070d).f254042d);
                            NewFriendMoreSysMsgAdapter.this.C.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.13.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass13.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    } else {
                                        NewFriendMoreSysMsgAdapter.this.w();
                                    }
                                }
                            });
                        }
                    }
                }, null, true);
                return;
            } else {
                if (iVar instanceof r) {
                    ThreadManagerV2.postImmediately(new Runnable(iVar) { // from class: com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.14
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mobileqq.newfriend.msg.i f254072d;

                        {
                            this.f254072d = iVar;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgAdapter.this, (Object) iVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).deleteQIMNotifyAddFriendData(((r) this.f254072d).f254044d, NewFriendMoreSysMsgAdapter.this.C);
                                NewFriendMoreSysMsgAdapter.this.C.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.14.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass14.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else {
                                            NewFriendMoreSysMsgAdapter.this.w();
                                        }
                                    }
                                });
                            }
                        }
                    }, null, true);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick posTag or subTag is not int");
        }
    }

    private void t(com.tencent.mobileqq.newfriend.ui.holder.a aVar) {
        aVar.f254166d.setVisibility(0);
        aVar.f254167e.setVisibility(0);
        aVar.f254169h.setVisibility(0);
        aVar.f254168f.setVisibility(0);
        aVar.f254170i.setVisibility(0);
        aVar.C.setVisibility(8);
        aVar.f254171m.setVisibility(0);
        aVar.K.setVisibility(8);
    }

    private boolean u(structmsg$StructMsg structmsg_structmsg) {
        if (structmsg_structmsg.f436065msg.src_id.has() && structmsg_structmsg.f436065msg.sub_src_id.has() && ((IGuildAddQQFriendApi) QRoute.api(IGuildAddQQFriendApi.class)).isFromGuild(structmsg_structmsg.f436065msg.src_id.get(), structmsg_structmsg.f436065msg.sub_src_id.get())) {
            return true;
        }
        return false;
    }

    private void v() {
        if (this.H) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            Activity activity = this.f254069m;
            QQToast.makeText(activity, activity.getResources().getString(R.string.b3j), 0).show(q());
            return;
        }
        List<MessageRecord> msgList = this.N.getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        if (msgList != null && msgList.size() >= 20 && !FriendSystemMsgController.e().j(this.C)) {
            this.H = true;
            this.f254066f.setVisibility(0);
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).sendGetNextFriendSystemMsg(this.C);
            if (QLog.isColorLevel()) {
                QLog.i("NewFriendMoreSysMsgAdapter", 2, "loadNextPage.get next page.");
            }
        }
    }

    private void y(com.tencent.mobileqq.newfriend.ui.holder.a aVar, structmsg$StructMsg structmsg_structmsg) {
        String g16 = com.tencent.mobileqq.newfriend.msg.c.g(this.f254069m, structmsg_structmsg);
        if (!TextUtils.isEmpty(g16)) {
            if (g16.startsWith(this.f254069m.getString(R.string.f160751vv))) {
                aVar.f254169h.setText(structmsg_structmsg.f436065msg.msg_additional.get());
            } else {
                aVar.f254169h.setText(g16);
            }
        }
    }

    protected void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        View view = this.f254066f;
        if (view != null) {
            view.setVisibility(8);
        }
        this.H = false;
        if (QLog.isColorLevel()) {
            QLog.i("NewFriendMoreSysMsgAdapter", 2, "stopLoadMore().");
        }
    }

    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        AppInterface appInterface = this.C;
        if (appInterface != null) {
            appInterface.addObserver(this.U);
            this.C.addObserver(this.T);
            this.C.addObserver(this.S);
            this.C.addObserver(this.V);
            this.C.addObserver(this.W, true);
            this.C.addObserver(this.X);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.J.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.J.size()) {
            return this.J.get(i3);
        }
        return new Object();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        com.tencent.mobileqq.newfriend.ui.holder.a aVar;
        structmsg$StructMsg structmsg_structmsg;
        View view3;
        structmsg$SystemMsg structmsg_systemmsg;
        PBStringField pBStringField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            view2 = (View) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                aVar = new com.tencent.mobileqq.newfriend.ui.holder.a();
                view2 = l(this.f254069m, R.layout.b3_, aVar);
                aVar.f254166d = (ImageView) view2.findViewById(R.id.f163821d);
                aVar.f254167e = (TextView) view2.findViewById(R.id.nickname);
                aVar.f254168f = (TextView) view2.findViewById(R.id.f164064iz);
                aVar.f254169h = (TextView) view2.findViewById(R.id.i95);
                aVar.f254170i = (TextView) view2.findViewById(R.id.iz7);
                aVar.f254171m = (Button) view2.findViewById(R.id.i8s);
                aVar.C = (TextView) view2.findViewById(R.id.f166787i92);
                aVar.K = (ImageView) view2.findViewById(R.id.f73703u_);
                ImageView imageView = aVar.f254166d;
                if (imageView instanceof ThemeImageView) {
                    ((ThemeImageView) imageView).setSupportMaskView(false);
                }
                view2.setTag(aVar);
            } else {
                com.tencent.mobileqq.newfriend.ui.holder.a aVar2 = (com.tencent.mobileqq.newfriend.ui.holder.a) view.getTag();
                t(aVar2);
                view2 = view;
                aVar = aVar2;
            }
            aVar.leftView.setTag(aVar);
            aVar.leftView.setOnClickListener(this);
            com.tencent.mobileqq.newfriend.msg.i iVar = (com.tencent.mobileqq.newfriend.msg.i) getItem(i3);
            D(this.f254069m, view2, i3, iVar, aVar, this);
            com.tencent.mobileqq.newfriend.utils.a.h(aVar.leftView, true ^ iVar.b());
            if (iVar instanceof com.tencent.mobileqq.newfriend.msg.c) {
                MessageForSystemMsg messageForSystemMsg = ((com.tencent.mobileqq.newfriend.msg.c) getItem(i3)).f254022d;
                structmsg_structmsg = messageForSystemMsg.structMsg;
                f(aVar, i3, structmsg_structmsg, messageForSystemMsg.uniseq);
            } else {
                if (iVar instanceof p) {
                    g(aVar, ((p) getItem(i3)).f254042d);
                } else if (iVar instanceof r) {
                    QIMNotifyAddFriend qIMNotifyAddFriend = ((r) getItem(i3)).f254044d;
                    aVar.leftView.setClickable(false);
                    h(aVar, qIMNotifyAddFriend);
                }
                structmsg_structmsg = null;
            }
            com.tencent.mobileqq.newfriend.utils.a.c(aVar.f254171m);
            com.tencent.mobileqq.newfriend.utils.a.e(aVar.C, aVar.f254169h, aVar.f254170i);
            String charSequence = aVar.f254169h.getText().toString();
            if (structmsg_structmsg != null && (structmsg_systemmsg = structmsg_structmsg.f436065msg) != null && (pBStringField = structmsg_systemmsg.msg_additional) != null) {
                aVar.f254169h.setText(com.tencent.mobileqq.newfriend.utils.a.a(this.f254069m, charSequence, pBStringField.get()));
            }
            c(aVar);
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void hideMenuPop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            Activity activity = this.f254069m;
            DialogUtil.createCustomDialog(activity, (String) null, activity.getString(R.string.iz7), (String) null, R.string.cancel, R.string.iz6, new g(), new h()).show();
        }
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void interceptTouchEvent(boolean z16) {
        TopGestureLayout topGestureLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
            return;
        }
        FlingHandler flingHandler = this.I;
        if (flingHandler != null && (flingHandler instanceof FlingGestureHandler) && (topGestureLayout = ((FlingGestureHandler) flingHandler).mTopLayout) != null) {
            topGestureLayout.setInterceptTouchFlag(!z16);
        }
    }

    protected void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f254068i;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f254068i.dismiss();
        }
        this.f254068i = null;
    }

    public Bitmap o(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Bitmap) iPatchRedirector.redirect((short) 20, (Object) this, i3, (Object) str);
        }
        Bitmap bitmapFromCache = this.E.getBitmapFromCache(i3, str);
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        if (!this.E.isPausing()) {
            this.E.requestDecodeFace(str, i3, true, (byte) 0);
        }
        return BaseImageUtil.getDefaultFaceBitmap();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        PhoneContactAdd phoneContactAdd;
        AllInOne allInOne;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ibi) {
                this.P = true;
                Object tag = view.getTag();
                if (tag instanceof com.tencent.mobileqq.newfriend.ui.holder.a) {
                    com.tencent.mobileqq.newfriend.ui.holder.a aVar = (com.tencent.mobileqq.newfriend.ui.holder.a) tag;
                    int i3 = aVar.H;
                    if (i3 == 0) {
                        str = String.valueOf(aVar.E.req_uin.get());
                        if (aVar.E.msg_type.get() == 1) {
                            r(aVar);
                            int i16 = aVar.E.f436065msg.sub_type.get();
                            if (i16 != 1) {
                                if (i16 != 2 && i16 != 3) {
                                    if (i16 != 6) {
                                        if (i16 == 13) {
                                            ReportController.o(this.C, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
                                        }
                                    } else {
                                        ReportController.o(this.C, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
                                    }
                                } else {
                                    ReportController.o(this.C, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
                                }
                            } else {
                                ReportController.o(this.C, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
                            }
                        }
                        str2 = str;
                        ReportController.o(this.C, "dc00898", "", "", "0X800C07E", "0X800C07E", 2, 0, str2, "", "", "");
                    } else if (i3 == 1 && (phoneContactAdd = aVar.I) != null) {
                        String str3 = phoneContactAdd.unifiedCode;
                        if (((IPhoneContactService) this.C.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
                            allInOne = new AllInOne(phoneContactAdd.unifiedCode, 34);
                        } else {
                            allInOne = new AllInOne(phoneContactAdd.unifiedCode, 29);
                        }
                        allInOne.nickname = phoneContactAdd.name;
                        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 5);
                        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 57);
                        ProfileUtils.openProfileCard(this.f254069m, allInOne);
                        str2 = str3;
                        ReportController.o(this.C, "dc00898", "", "", "0X800C07E", "0X800C07E", 2, 0, str2, "", "", "");
                    }
                }
                str = null;
                str2 = str;
                ReportController.o(this.C, "dc00898", "", "", "0X800C07E", "0X800C07E", 2, 0, str2, "", "", "");
            } else if (id5 == R.id.i8s) {
                Object tag2 = view.getTag();
                if (tag2 != null && (tag2 instanceof com.tencent.mobileqq.newfriend.ui.holder.a)) {
                    if (!NetworkUtil.isNetworkAvailable(this.f254069m)) {
                        Activity activity = this.f254069m;
                        QQToast.makeText(activity, activity.getResources().getString(R.string.b3j), 0).show(q());
                    } else {
                        ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(this.C, 10005, this.f254069m, new c(tag2));
                    }
                }
            } else if (id5 == R.id.m_6) {
                TextView textView = this.f254067h;
                if (textView != null) {
                    textView.setText("");
                }
                ReportController.o(this.C, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
                ((INewFriendService) this.C.getRuntimeService(INewFriendService.class, "")).setSysSuspiciousUnreadNum(0);
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).jumpToNewFriendMoreSysMsgSuspiciousFragment(this.f254069m);
            } else if (id5 == R.id.f73703u_) {
                if (view.getTag() != null && (view.getTag() instanceof com.tencent.mobileqq.newfriend.ui.holder.a)) {
                    com.tencent.mobileqq.newfriend.ui.holder.a aVar2 = (com.tencent.mobileqq.newfriend.ui.holder.a) view.getTag();
                    if (!NetworkUtil.isNetworkAvailable(this.f254069m)) {
                        Activity activity2 = this.f254069m;
                        QQToast.makeText(activity2, activity2.getResources().getString(R.string.b3j), 0).show(q());
                    } else {
                        z(aVar2.E.get(), aVar2.F);
                    }
                }
            } else {
                s(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        com.tencent.mobileqq.newfriend.ui.holder.a aVar;
        String str2;
        Bitmap bitmap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (bitmap != null) {
            this.K.put(str, bitmap);
        }
        if (i3 <= 0) {
            int childCount = this.f254065e.getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                Object tag = this.f254065e.getChildAt(i17).getTag();
                if (tag != null && (tag instanceof com.tencent.mobileqq.newfriend.ui.holder.a) && (str2 = (aVar = (com.tencent.mobileqq.newfriend.ui.holder.a) tag).G) != null && str2.length() > 0 && (bitmap2 = this.K.get(aVar.G)) != null) {
                    aVar.f254166d.setImageBitmap(bitmap2);
                }
            }
            this.K.clear();
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        this.C.removeObserver(this.U);
        this.C.removeObserver(this.T);
        this.C.removeObserver(this.S);
        this.C.removeObserver(this.V);
        this.C.removeObserver(this.W);
        this.C.removeObserver(this.X);
        this.E.setDecodeTaskCompletionListener(null);
        this.E.destory();
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.G = (i3 + i16) - 1;
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) absListView, i3);
            return;
        }
        if (i3 == 0 && this.G == getCount()) {
            v();
        }
        if (i3 != 0 && i3 != 1) {
            this.E.cancelPendingRequests();
            this.E.pause();
            return;
        }
        if (this.E.isPausing()) {
            this.E.resume();
        }
        int childCount = this.f254065e.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            Object tag = this.f254065e.getChildAt(i16).getTag();
            if (tag instanceof com.tencent.mobileqq.newfriend.ui.holder.a) {
                com.tencent.mobileqq.newfriend.ui.holder.a aVar = (com.tencent.mobileqq.newfriend.ui.holder.a) tag;
                int i17 = aVar.H;
                if (i17 == 0) {
                    n(aVar);
                } else if (i17 == 1) {
                    aVar.f254166d.setImageBitmap(o(11, aVar.G));
                }
            }
        }
    }

    protected Bundle p(structmsg$StructMsg structmsg_structmsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bundle) iPatchRedirector.redirect((short) 6, (Object) this, (Object) structmsg_structmsg);
        }
        Bundle bundle = new Bundle();
        if (structmsg_structmsg == null) {
            return bundle;
        }
        bundle.putString("base_uin", String.valueOf(structmsg_structmsg.req_uin.get()));
        String str = structmsg_structmsg.f436065msg.req_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(structmsg_structmsg.req_uin.get());
        }
        bundle.putString("base_nick", str);
        bundle.putInt("verfy_type", structmsg_structmsg.f436065msg.sub_type.get());
        bundle.putString("verfy_msg", structmsg_structmsg.f436065msg.msg_additional.get());
        if (com.tencent.mobileqq.newfriend.msg.c.h(this.C, String.valueOf(structmsg_structmsg.req_uin.get()), structmsg_structmsg, false)) {
            String str2 = new String(structmsg_structmsg.f436065msg.bytes_game_nick.get().toByteArray());
            if (!TextUtils.isEmpty(str2)) {
                str = KplRoleInfo.WZRYUIinfo.buildNickName(str, str2);
            }
            bundle.putString("base_nick", str);
            bundle.putBoolean("isFromWzry", true);
        }
        return bundle;
    }

    protected int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.f254069m.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    protected void r(com.tencent.mobileqq.newfriend.ui.holder.a aVar) {
        KplRoleInfo.WZRYUIinfo wZRYUIinfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
            return;
        }
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("NewFriendMoreSysMsgAdapter", 2, "handleBuddySystemMsg! start " + aVar.D);
        }
        int i16 = 1;
        if (com.tencent.mobileqq.newfriend.msg.c.h(this.C, String.valueOf(aVar.E.req_uin.get()), aVar.E, true)) {
            wZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(aVar.E.req_uin.get()), aVar.f254167e.getText().toString(), "", aVar.E.f436065msg.src_id.get(), aVar.E.f436065msg.sub_src_id.get());
        } else {
            wZRYUIinfo = null;
        }
        int i17 = aVar.E.f436065msg.sub_type.get();
        if (i17 != 1) {
            if (i17 != 2 && i17 != 3) {
                if (i17 != 9 && i17 != 10) {
                    if (i17 != 13) {
                        i3 = 0;
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra(IProfileCardConst.KEY_WZRY_DATA, wZRYUIinfo);
                        com.tencent.mobileqq.newfriend.utils.b.c(this.C, this.f254069m, String.valueOf(aVar.E.req_uin.get()), aVar.E.f436065msg.group_code.get(), i17, aVar.E.f436065msg.src_id.get(), intent);
                        return;
                    }
                }
            } else {
                boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(aVar.E.req_uin.get())), "NewFriendMoreSysMsgAdapter");
                String valueOf = String.valueOf(aVar.E.req_uin.get());
                if (!isFriend) {
                    i16 = 25;
                }
                AllInOne allInOne = new AllInOne(valueOf, i16);
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 5);
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 57);
                allInOne.uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(aVar.E.req_uin.get()));
                ProfileUtils.openProfileCard(this.f254069m, allInOne);
                return;
            }
        } else {
            i3 = 1;
        }
        String str = aVar.E.f436065msg.req_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(aVar.E.req_uin.get());
        }
        Intent intent2 = new Intent();
        intent2.putExtra("infoid", aVar.D);
        intent2.putExtra("infouin", String.valueOf(aVar.E.req_uin.get()));
        intent2.putExtra("infonick", str);
        intent2.putExtra("infotime", aVar.E.msg_time.get());
        intent2.putExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, aVar.E.f436065msg.sub_type.get());
        intent2.putExtra("strNickName", str);
        intent2.putExtra("verify_msg", aVar.E.f436065msg.msg_additional.get());
        intent2.putExtra("msg_source", aVar.E.f436065msg.msg_source.get());
        intent2.putExtra("msg_troopuin", aVar.E.f436065msg.group_code.get());
        intent2.putExtra(AppConstants.Key.SYSTEM_MESSAGE_SUMMARY, aVar.E.f436065msg.msg_decided.get());
        intent2.putExtra("info_dealwith_msg", aVar.E.f436065msg.msg_detail.get());
        intent2.putExtra("msg_title", aVar.E.f436065msg.msg_title.get());
        intent2.putExtra("msg_source_id", aVar.E.f436065msg.src_id.get());
        if (i3 > 0) {
            intent2.putExtra("verify_type", i3);
        }
        if (wZRYUIinfo != null) {
            intent2.putExtra(IProfileCardConst.KEY_WZRY_DATA, wZRYUIinfo);
            intent2.putExtra("strNickName", wZRYUIinfo.nick);
            intent2.putExtra("infonick", wZRYUIinfo.nick);
        }
        z(aVar.E.get(), aVar.F);
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddRequestPage(this.f254069m, intent2);
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void updateCurShowRightView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) view);
            return;
        }
        int i3 = -1;
        if (view != null) {
            Object tag = view.getTag(-1);
            if (tag instanceof Integer) {
                i3 = ((Integer) tag).intValue();
            }
        }
        this.F = i3;
    }

    protected void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            x(false);
        }
    }

    protected void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            ThreadManagerV2.postImmediately(new Runnable(z16) { // from class: com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f254074d;

                {
                    this.f254074d = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NewFriendMoreSysMsgAdapter.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList;
                    int i3;
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    int i16 = 2;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    synchronized (NewFriendMoreSysMsgAdapter.this.Q) {
                        NewFriendMoreSysMsgAdapter.this.Q.clear();
                    }
                    List<ChatMessage> aIOList = NewFriendMoreSysMsgAdapter.this.N.getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, FriendSystemMsgController.e().f(NewFriendMoreSysMsgAdapter.this.C));
                    if (aIOList != null && aIOList.size() > 0) {
                        arrayList = new ArrayList(aIOList.size());
                        int size = aIOList.size() - 1;
                        while (size >= 0) {
                            ChatMessage chatMessage = aIOList.get(size);
                            if (chatMessage instanceof MessageForSystemMsg) {
                                MessageForSystemMsg messageForSystemMsg = (MessageForSystemMsg) chatMessage;
                                if (messageForSystemMsg.structMsg == null) {
                                    messageForSystemMsg.parse();
                                }
                                structmsg$StructMsg structmsg_structmsg = messageForSystemMsg.structMsg;
                                if (structmsg_structmsg != null && structmsg_structmsg.f436065msg != null) {
                                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(messageForSystemMsg.structMsg.req_uin.get()));
                                    if (messageForSystemMsg.structMsg.f436065msg.sub_type.get() == 13 && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "NewFriendMoreSysMsgAdapter")) {
                                        if (QLog.isColorLevel()) {
                                            QLog.i("NewFriendMoreSysMsgAdapter", i16, "is friend uin = " + messageForSystemMsg.structMsg.req_uin.get() + " uid = " + uidFromUin);
                                        }
                                    } else {
                                        if ((messageForSystemMsg.structMsg.f436065msg.uint32_source_flag.get() & 8) == 8) {
                                            String str2 = "";
                                            String str3 = messageForSystemMsg.structMsg.f436065msg.msg_source.get();
                                            long j3 = messageForSystemMsg.structMsg.f436065msg.uint64_discuss_uin.get();
                                            if (j3 != 0) {
                                                String discussionNameCanNull = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getDiscussionNameCanNull(NewFriendMoreSysMsgAdapter.this.C, String.valueOf(j3));
                                                if (TextUtils.isEmpty(discussionNameCanNull)) {
                                                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getDiscussInfo(j3, NewFriendMoreSysMsgAdapter.this.C);
                                                }
                                                try {
                                                    ConcurrentHashMap<Long, String> concurrentHashMap = NewFriendMoreSysMsgAdapter.this.Q;
                                                    Long valueOf = Long.valueOf(j3);
                                                    if (discussionNameCanNull == null) {
                                                        str = "";
                                                    } else {
                                                        str = discussionNameCanNull;
                                                    }
                                                    concurrentHashMap.put(valueOf, str);
                                                } catch (Exception e16) {
                                                    e16.printStackTrace();
                                                }
                                                str2 = discussionNameCanNull;
                                            }
                                            if (QLog.isColorLevel()) {
                                                QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "NewFriendMoreSysMsgAdapter source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", Integer.valueOf(messageForSystemMsg.structMsg.f436065msg.uint32_source_flag.get()), Long.valueOf(j3), str2, str3));
                                            }
                                        }
                                        if (QLog.isColorLevel()) {
                                            i3 = 2;
                                            QLog.i("NewFriendMoreSysMsgAdapter", 2, "not is friend uin = " + messageForSystemMsg.structMsg.req_uin.get() + " uid = " + uidFromUin);
                                        } else {
                                            i3 = 2;
                                        }
                                        arrayList.add(new com.tencent.mobileqq.newfriend.msg.c(messageForSystemMsg));
                                        size--;
                                        i16 = i3;
                                    }
                                }
                            }
                            i3 = i16;
                            size--;
                            i16 = i3;
                        }
                    } else {
                        arrayList = new ArrayList();
                    }
                    ArrayList<r> qIMNotifyAddFriendsMsg = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getQIMNotifyAddFriendsMsg(true, NewFriendMoreSysMsgAdapter.this.C);
                    if (qIMNotifyAddFriendsMsg.size() > 0) {
                        arrayList.addAll(qIMNotifyAddFriendsMsg);
                    }
                    Collections.sort(arrayList, NewFriendMoreSysMsgAdapter.this.R);
                    NewFriendMoreSysMsgAdapter.this.C.runOnUiThread(new Runnable(arrayList) { // from class: com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.5.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ ArrayList f254075d;

                        {
                            this.f254075d = arrayList;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) arrayList);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            NewFriendMoreSysMsgAdapter newFriendMoreSysMsgAdapter = NewFriendMoreSysMsgAdapter.this;
                            newFriendMoreSysMsgAdapter.J = this.f254075d;
                            newFriendMoreSysMsgAdapter.notifyDataSetChanged();
                            if (NewFriendMoreSysMsgAdapter.this.getCount() > 0) {
                                NewFriendMoreSysMsgAdapter.this.f254065e.setVisibility(0);
                                NewFriendMoreSysMsgAdapter.this.f254064d.setVisibility(8);
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                if (anonymousClass5.f254074d) {
                                    NewFriendMoreSysMsgAdapter newFriendMoreSysMsgAdapter2 = NewFriendMoreSysMsgAdapter.this;
                                    if (newFriendMoreSysMsgAdapter2.L < newFriendMoreSysMsgAdapter2.getCount()) {
                                        NewFriendMoreSysMsgAdapter newFriendMoreSysMsgAdapter3 = NewFriendMoreSysMsgAdapter.this;
                                        newFriendMoreSysMsgAdapter3.f254065e.setSelection(newFriendMoreSysMsgAdapter3.L);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            NewFriendMoreSysMsgAdapter.this.f254064d.setVisibility(0);
                            NewFriendMoreSysMsgAdapter.this.f254065e.setVisibility(8);
                        }
                    });
                }
            }, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(structmsg$StructMsg structmsg_structmsg, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, structmsg_structmsg, Long.valueOf(j3));
        } else if (structmsg_structmsg != null) {
            long j16 = structmsg_structmsg.get().msg_seq.get() + structmsg_structmsg.get().msg_type.get();
            FriendSystemMsgController.e().k(Long.valueOf(j16), structmsg_structmsg.get());
            FriendSystemMsgController.e().l(j16);
            FriendSystemMsgController.e().m(j3);
        }
    }
}
