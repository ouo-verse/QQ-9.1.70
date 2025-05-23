package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.guild.api.IGuildAddQQFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.ay;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.List;
import java.util.Locale;
import tencent.mobileim.structmsg.structmsg$AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsgAction;
import tencent.mobileim.structmsg.structmsg$SystemMsgActionInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class n extends d implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    public structmsg$StructMsg C;
    public long D;
    private INewFriendService E;
    public long F;
    private String G;
    private boolean H;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements IAddAcceptBlockStrategy.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f254141a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean[] f254142b;

        a(Object obj, boolean[] zArr) {
            this.f254141a = obj;
            this.f254142b = zArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, n.this, obj, zArr);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
        public void onSuccess() {
            char c16;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            n nVar = n.this;
            nVar.z(nVar.C.get(), n.this.D);
            structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey()));
            if (structMsgFromMap != null) {
                int i16 = structMsgFromMap.msg_type.get();
                long j3 = structMsgFromMap.msg_seq.get();
                long j16 = structMsgFromMap.req_uin.get();
                int i17 = structMsgFromMap.f436065msg.sub_type.get();
                int i18 = structMsgFromMap.f436065msg.src_id.get();
                int i19 = structMsgFromMap.f436065msg.sub_src_id.get();
                int i26 = structMsgFromMap.f436065msg.group_msg_type.get();
                List<structmsg$SystemMsgAction> list = structMsgFromMap.f436065msg.actions.get();
                if (list != null && list.size() > 0) {
                    structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo = list.get(0).action_info.get();
                    structmsg_systemmsgactioninfo.remark.set("");
                    structmsg_systemmsgactioninfo.group_id.set(0);
                    structmsg$AddFrdSNInfo structmsg_addfrdsninfo = new structmsg$AddFrdSNInfo();
                    structmsg_addfrdsninfo.uint32_not_see_dynamic.set(0);
                    structmsg_addfrdsninfo.uint32_set_sn.set(0);
                    structmsg_systemmsgactioninfo.addFrdSNInfo.set(structmsg_addfrdsninfo);
                    c16 = 0;
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).sendFriendSystemMsgAction(i16, j3, j16, i17, i18, i19, i26, structmsg_systemmsgactioninfo, 0, structMsgFromMap, false, n.this.f254108e);
                    this.f254142b[0] = true;
                } else {
                    c16 = 0;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("agree, ");
                    if (list != null) {
                        i3 = list.size();
                    } else {
                        i3 = -1;
                    }
                    sb5.append(i3);
                    QLog.d("SystemMsgItemBuilder", 1, sb5.toString());
                }
            } else {
                c16 = 0;
                QLog.d("SystemMsgItemBuilder", 1, "agree");
            }
            if (this.f254142b[c16]) {
                n.this.f254109f.f254101e.f254172d.startProgress();
            }
            ReportController.o(n.this.f254108e, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
            ReportController.o(n.this.f254108e, "dc00898", "", "", "0X8007700", "0X8007700", 0, 0, "", "", "", "");
            String valueOf = String.valueOf(n.this.C.req_uin.get());
            ReportController.o(n.this.f254108e, "dc00898", "", "", "0X800C07F", "0X800C07F", 1, 0, valueOf, "", "", "");
            if (Utils.G(valueOf)) {
                ReportController.o(n.this.f254108e, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
            }
            n nVar2 = n.this;
            if (com.tencent.mobileqq.newfriend.msg.c.h(nVar2.f254108e, String.valueOf(nVar2.C.req_uin.get()), n.this.C, true)) {
                ReportController.o(n.this.f254108e, "CliOper", "", "", "0X800843C", "0X800843C", 0, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b extends d.b {
        static IPatchRedirector $redirector_;
        public long I;
        public structmsg$StructMsg J;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public n(Context context, AppInterface appInterface, SystemMsgListAdapter systemMsgListAdapter, com.tencent.mobileqq.newfriend.msg.i iVar) {
        super(context, appInterface, systemMsgListAdapter, iVar);
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, appInterface, systemMsgListAdapter, iVar);
            return;
        }
        this.F = 0L;
        com.tencent.mobileqq.newfriend.msg.c cVar = (com.tencent.mobileqq.newfriend.msg.c) iVar;
        this.C = cVar.f254022d.getSystemMsg();
        this.D = cVar.f254022d.uniseq;
        this.f254110h = b(context);
        this.E = (INewFriendService) appInterface.getRuntimeService(INewFriendService.class, "");
        if (this.C.f436065msg.uint32_source_flag.has()) {
            i3 = this.C.f436065msg.uint32_source_flag.get();
        } else {
            i3 = 0;
        }
        if ((i3 & 8) == 8) {
            if (this.C.f436065msg.uint64_discuss_uin.has()) {
                this.F = this.C.f436065msg.uint64_discuss_uin.get();
            }
            String str = this.C.f436065msg.msg_source.has() ? this.C.f436065msg.msg_source.get() : null;
            if (this.F != 0) {
                String discussionNameCanNull = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getDiscussionNameCanNull(appInterface, String.valueOf(this.F));
                this.G = discussionNameCanNull;
                if (TextUtils.isEmpty(discussionNameCanNull)) {
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getDiscussInfo(this.F, appInterface);
                    if (QLog.isColorLevel()) {
                        QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder need get discuss info %d", Long.valueOf(this.F)));
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", Integer.valueOf(i3), Long.valueOf(this.F), this.G, str));
            }
        } else {
            this.G = null;
            this.F = 0L;
        }
        this.f254112m = context.getResources().getDimensionPixelSize(R.dimen.f159219xp);
        if (this.C.f436065msg.src_id.has() && this.C.f436065msg.sub_src_id.has()) {
            this.H = ((IGuildAddQQFriendApi) QRoute.api(IGuildAddQQFriendApi.class)).isFromGuild(this.C.f436065msg.src_id.get(), this.C.f436065msg.sub_src_id.get());
        }
    }

    private void o(b bVar, int i3, String str) {
        String str2;
        String str3 = this.C.f436065msg.req_uin_nick.get();
        String remarkWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getRemarkWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(this.C.req_uin.get())), "SystemMsgItemBuilder");
        if (!TextUtils.isEmpty(remarkWithUid)) {
            str3 = remarkWithUid;
        }
        if (com.tencent.mobileqq.newfriend.msg.c.h(this.f254108e, str, this.C, true) && this.C.f436065msg.bytes_game_nick.has()) {
            String str4 = new String(this.C.f436065msg.bytes_game_nick.get().toByteArray());
            if (!TextUtils.isEmpty(str4)) {
                str3 = KplRoleInfo.WZRYUIinfo.buildNickName(str3, str4);
            }
        }
        String b16 = ay.b(str);
        if (!TextUtils.isEmpty(b16)) {
            str3 = b16;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = str;
        }
        bVar.f254115e.setText(str3);
        if (this.C.f436065msg.bytes_name_more.has()) {
            str2 = new String(this.C.f436065msg.bytes_name_more.get().toByteArray());
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && !str2.equals("isNull")) {
            bVar.H.setVisibility(0);
            bVar.H.setText("\uff08" + str2 + "\uff09");
        } else {
            bVar.H.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str) && Utils.G(str)) {
            Drawable drawable = this.f254107d.getResources().getDrawable(R.drawable.br7);
            drawable.setBounds(0, 0, ViewUtils.dpToPx(15.0f), ViewUtils.dpToPx(15.0f));
            bVar.f254115e.setCompoundDrawables(null, null, drawable, null);
            bVar.f254115e.setCompoundDrawablePadding(ViewUtils.dpToPx(5.0f));
        } else {
            bVar.f254115e.setCompoundDrawables(null, null, null, null);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SystemMsgItemBuilder", 2, cq.w("bindBuddySystemMsgView|position is : " + i3 + ",name is : " + str3 + ",source is : " + this.C.f436065msg.msg_source.get() + "bindBuddySystemMsgView|myAllowFlag : " + this.C.f436065msg.sub_type.get(), 2));
        }
    }

    private void q(b bVar) {
        String str;
        String format;
        if (this.C.f436065msg.msg_source.has()) {
            str = this.C.f436065msg.msg_source.get();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.H) {
                str = w(str);
            }
            if (!TextUtils.isEmpty(this.G)) {
                format = String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.f172751tz0), str, this.G);
            } else {
                format = String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.op6), str);
            }
            bVar.f254117h.setText(format);
            bVar.f254117h.setVisibility(0);
            return;
        }
        bVar.f254117h.setVisibility(8);
    }

    public static void v(b bVar, com.tencent.mobileqq.newfriend.ui.adapter.a aVar, AppInterface appInterface) {
        Bitmap bitmapFromCache;
        if (bVar != null && bVar.f254114d != null) {
            int i3 = bVar.J.f436065msg.src_id.get();
            boolean z16 = false;
            if (i3 == 3007 || i3 == 3019 || i3 == 2007 || i3 == 4007 || i3 == 2019) {
                if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(bVar.J.req_uin.get())), "SystemMsgItemBuilder")) {
                    z16 = true;
                }
            }
            if (z16) {
                bitmapFromCache = aVar.d().getBitmapFromCache(32, String.valueOf(bVar.J.req_uin.get()), 200);
                if (bitmapFromCache == null && !aVar.d().isPausing()) {
                    aVar.d().requestDecodeStrangeFace(String.valueOf(bVar.J.req_uin.get()), 200, true, true);
                }
            } else {
                bitmapFromCache = aVar.d().getBitmapFromCache(1, String.valueOf(bVar.J.req_uin.get()));
                if (bitmapFromCache == null && !aVar.d().isPausing()) {
                    aVar.d().requestDecodeFace(String.valueOf(bVar.J.req_uin.get()), 1, true);
                }
            }
            if (bitmapFromCache == null) {
                bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
            }
            bVar.f254114d.setImageBitmap(bitmapFromCache);
        }
    }

    private String w(@NonNull String str) {
        String[] split = this.C.f436065msg.bytes_source_desc.get().toStringUtf8().split(ContainerUtils.FIELD_DELIMITER);
        if (split != null && split.length > 6) {
            return str + "-" + split[6];
        }
        return str;
    }

    private void y(b bVar) {
        bVar.f254114d.setVisibility(0);
        bVar.f254115e.setVisibility(0);
        bVar.H.setVisibility(8);
        bVar.f254116f.setVisibility(0);
        bVar.C.setVisibility(0);
        bVar.f254117h.setVisibility(0);
        bVar.f254119m.setVisibility(8);
        bVar.f254118i.setVisibility(0);
        bVar.E.setVisibility(8);
    }

    public void A(b bVar) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bVar);
            return;
        }
        if (this.C.f436065msg.req_uin_gender.has()) {
            i3 = this.C.f436065msg.req_uin_gender.get();
        } else {
            i3 = -1;
        }
        if (this.C.f436065msg.req_uin_age.has()) {
            i16 = this.C.f436065msg.req_uin_age.get();
        } else {
            i16 = 0;
        }
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).showGenderAgeNewStyle(bVar.C, i3, i16, new StringBuilder());
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        MessageForSystemMsg messageForSystemMsg = ((com.tencent.mobileqq.newfriend.msg.c) this.f254111i).f254022d;
        this.f254109f.f254101e.B();
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).sendDelSingleSystemMsg(this.C, messageForSystemMsg.frienduin, messageForSystemMsg.istroop, messageForSystemMsg.uniseq, this.f254108e);
        ReportController.o(this.f254108e, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        if (com.tencent.mobileqq.newfriend.msg.c.h(this.f254108e, String.valueOf(this.C.req_uin.get()), this.C, true)) {
            ReportController.o(this.f254108e, "CliOper", "", "", "0X800843D", "0X800843D", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return ((com.tencent.mobileqq.newfriend.msg.c) this.f254111i).f254022d.mSysmsgMenuFlag;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    public View h(int i3, View view) {
        b bVar;
        View view2 = view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) view2);
        }
        if (view2 != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
            y(bVar);
        } else {
            bVar = new b();
            view2 = d(this.f254107d, R.layout.b3_, bVar);
            k(view2, this.f254112m);
            bVar.f254114d = (ImageView) view2.findViewById(R.id.f163821d);
            bVar.f254115e = (TextView) view2.findViewById(R.id.nickname);
            bVar.H = (TextView) view2.findViewById(R.id.f166893m94);
            bVar.f254116f = (TextView) view2.findViewById(R.id.i95);
            bVar.C = (TextView) view2.findViewById(R.id.f164064iz);
            bVar.f254117h = (TextView) view2.findViewById(R.id.iz7);
            bVar.f254119m = (TextView) view2.findViewById(R.id.f166787i92);
            bVar.f254118i = (Button) view2.findViewById(R.id.i8s);
            bVar.E = (ImageView) view2.findViewById(R.id.f73703u_);
            a(bVar.f254114d);
            view2.setTag(bVar);
        }
        View view3 = view2;
        b bVar2 = bVar;
        bVar2.leftView.setTag(bVar2);
        bVar2.leftView.setOnClickListener(this);
        l(this.f254107d, view3, i3, this.f254111i, bVar2, this);
        if (!this.f254111i.b()) {
            com.tencent.mobileqq.newfriend.utils.a.h(bVar2.leftView, true);
            if (Utils.G(String.valueOf(this.C.req_uin.get()))) {
                ReportController.o(this.f254108e, "dc00898", "", "", "0X800826D", "0X800826D", 0, 0, "", "", "", "");
            }
        } else {
            com.tencent.mobileqq.newfriend.utils.a.h(bVar2.leftView, false);
        }
        n(bVar2, i3, this);
        return view3;
    }

    public void n(b bVar, int i3, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, bVar, Integer.valueOf(i3), onClickListener);
            return;
        }
        bVar.I = i3;
        bVar.D = String.valueOf(this.C.req_uin.get());
        structmsg$StructMsg structmsg_structmsg = this.C;
        bVar.J = structmsg_structmsg;
        o(bVar, i3, String.valueOf(structmsg_structmsg.req_uin.get()));
        v(bVar, this.f254109f, this.f254108e);
        bVar.f254114d.setTag(bVar);
        bVar.C.setVisibility(8);
        q(bVar);
        r(bVar, onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ibi) {
                Object tag = view.getTag();
                if (tag != null && (tag instanceof b)) {
                    b bVar = (b) tag;
                    if (this.C.msg_type.get() == 1) {
                        x(bVar);
                        int i3 = this.C.f436065msg.sub_type.get();
                        if (i3 != 1) {
                            if (i3 != 2 && i3 != 3) {
                                if (i3 != 6) {
                                    if (i3 == 13) {
                                        ReportController.o(this.f254108e, "dc00898", "", "", "0X8007702", "0X8007702", 0, 0, "", "", "", "");
                                    }
                                } else {
                                    ReportController.o(this.f254108e, "dc00898", "", "", "0X8007703", "0X8007703", 0, 0, "", "", "", "");
                                }
                            } else {
                                ReportController.o(this.f254108e, "dc00898", "", "", "0X8007701", "0X8007701", 0, 0, "", "", "", "");
                            }
                        } else {
                            ReportController.o(this.f254108e, "dc00898", "", "", "0X80076FF", "0X80076FF", 0, 0, "", "", "", "");
                        }
                    }
                }
                ReportController.o(this.f254108e, "dc00898", "", "", "0X800C07E", "0X800C07E", 1, 0, String.valueOf(this.C.req_uin.get()), "", "", "");
            } else if (id5 == R.id.i8s) {
                Object tag2 = view.getTag();
                if (tag2 != null && (tag2 instanceof b)) {
                    if (!NetworkUtil.isNetworkAvailable(this.f254107d)) {
                        Context context = this.f254107d;
                        QQToast.makeText(context, context.getResources().getString(R.string.b3j), 0).show(g());
                    } else {
                        ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(this.f254108e, 10005, this.f254107d, new a(tag2, new boolean[]{false}));
                    }
                }
            } else if (id5 == R.id.f73703u_) {
                if (view.getTag() != null && (view.getTag() instanceof b)) {
                    if (!NetworkUtil.isNetworkAvailable(this.f254107d)) {
                        Context context2 = this.f254107d;
                        QQToast.makeText(context2, context2.getResources().getString(R.string.b3j), 0).show(g());
                    } else {
                        z(this.C.get(), this.D);
                    }
                }
            } else {
                i(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar);
        } else {
            bVar.f254116f.setText(com.tencent.mobileqq.newfriend.utils.a.a(this.f254107d, com.tencent.mobileqq.newfriend.msg.c.g(this.f254107d, this.C), this.C.f436065msg.msg_additional.get()));
        }
    }

    public void r(b bVar, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar, (Object) onClickListener);
            return;
        }
        if (this.C.f436065msg != null) {
            p(bVar);
            switch (this.C.f436065msg.sub_type.get()) {
                case 1:
                    u(bVar);
                    break;
                case 2:
                case 3:
                case 7:
                    bVar.f254119m.setVisibility(0);
                    bVar.f254119m.setText(this.C.f436065msg.msg_decided.get());
                    bVar.f254118i.setVisibility(8);
                    A(bVar);
                    break;
                case 4:
                case 5:
                    bVar.f254119m.setVisibility(8);
                    bVar.f254118i.setVisibility(8);
                    break;
                case 6:
                    t(bVar);
                    break;
                case 8:
                    bVar.f254119m.setVisibility(0);
                    bVar.f254119m.setText(this.C.f436065msg.msg_decided.get());
                    bVar.f254118i.setVisibility(8);
                    break;
                case 9:
                case 10:
                    s(bVar);
                    break;
                case 12:
                    if (this.C.f436065msg.reqsubtype.has()) {
                        if (this.C.f436065msg.reqsubtype.get() == 1) {
                            bVar.f254119m.setVisibility(0);
                            bVar.f254119m.setText(this.C.f436065msg.msg_decided.get());
                            bVar.f254118i.setVisibility(8);
                            break;
                        } else if (this.C.f436065msg.reqsubtype.get() == 2) {
                            bVar.f254119m.setVisibility(8);
                            bVar.f254118i.setVisibility(8);
                            break;
                        }
                    }
                    break;
                case 13:
                    bVar.f254119m.setVisibility(0);
                    bVar.f254119m.setText(this.C.f436065msg.msg_decided.get());
                    bVar.f254118i.setVisibility(8);
                    bVar.f254117h.setVisibility(8);
                    break;
            }
            bVar.f254118i.setTag(bVar);
            bVar.f254118i.setOnClickListener(onClickListener);
            bVar.E.setTag(bVar);
            bVar.E.setOnClickListener(onClickListener);
        }
    }

    public void s(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
            return;
        }
        if (this.C.f436065msg.actions.get() != null && this.C.f436065msg.actions.get().size() > 0 && !TextUtils.isEmpty(this.C.f436065msg.actions.get().get(0).name.get())) {
            bVar.f254119m.setVisibility(8);
            bVar.f254118i.setVisibility(0);
            bVar.f254118i.setText(this.C.f436065msg.actions.get().get(0).name.get());
        } else {
            bVar.f254119m.setVisibility(0);
            bVar.f254119m.setText(this.C.f436065msg.msg_decided.get());
            bVar.f254118i.setVisibility(8);
        }
        A(bVar);
    }

    public void t(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bVar);
            return;
        }
        if (!TextUtils.isEmpty(this.C.f436065msg.msg_additional.get())) {
            bVar.f254117h.setText(this.C.f436065msg.msg_additional.get());
            bVar.f254116f.setText(this.C.f436065msg.msg_describe.get());
        } else {
            bVar.f254117h.setVisibility(8);
        }
        bVar.f254118i.setVisibility(8);
        bVar.f254119m.setVisibility(8);
    }

    public void u(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            return;
        }
        if (this.C.f436065msg.actions.get() != null && this.C.f436065msg.actions.get().size() > 0 && !TextUtils.isEmpty(this.C.f436065msg.actions.get().get(0).name.get())) {
            bVar.f254119m.setVisibility(8);
            bVar.f254118i.setVisibility(0);
            bVar.f254118i.setText(this.C.f436065msg.actions.get().get(0).name.get());
        } else if (this.C.f436065msg.actions.get() != null && this.C.f436065msg.actions.get().size() == 0) {
            bVar.f254119m.setVisibility(0);
            bVar.f254119m.setText(this.C.f436065msg.msg_decided.get());
            bVar.f254118i.setVisibility(8);
        }
        A(bVar);
    }

    public void x(b bVar) {
        KplRoleInfo.WZRYUIinfo wZRYUIinfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            return;
        }
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("SystemMsgItemBuilder", 2, "handleBuddySystemMsg! start " + bVar.I);
        }
        int i16 = this.C.f436065msg.sub_type.get();
        if (com.tencent.mobileqq.newfriend.msg.c.h(this.f254108e, String.valueOf(this.C.req_uin.get()), this.C, true)) {
            wZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(this.C.req_uin.get()), bVar.f254115e.getText().toString(), "", this.C.f436065msg.src_id.get(), this.C.f436065msg.sub_src_id.get());
        } else {
            wZRYUIinfo = null;
        }
        if (i16 != 1) {
            if (i16 != 2 && i16 != 3) {
                if (i16 != 9 && i16 != 10) {
                    if (i16 != 13) {
                        i3 = 0;
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra(IProfileCardConst.KEY_WZRY_DATA, wZRYUIinfo);
                        com.tencent.mobileqq.newfriend.utils.b.c(this.f254108e, this.f254107d, String.valueOf(this.C.req_uin.get()), this.C.f436065msg.group_code.get(), i16, this.C.f436065msg.src_id.get(), intent);
                        return;
                    }
                }
            } else {
                com.tencent.mobileqq.newfriend.utils.b.b(this.f254108e, this.f254107d, String.valueOf(this.C.req_uin.get()));
                return;
            }
        } else {
            i3 = 1;
        }
        String str = this.C.f436065msg.req_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(this.C.req_uin.get());
        }
        Intent intent2 = new Intent();
        intent2.putExtra("infoid", bVar.I);
        intent2.putExtra("infouin", String.valueOf(this.C.req_uin.get()));
        intent2.putExtra("infonick", str);
        intent2.putExtra("infotime", this.C.msg_time.get());
        intent2.putExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, this.C.f436065msg.sub_type.get());
        intent2.putExtra("strNickName", str);
        intent2.putExtra("verify_msg", this.C.f436065msg.msg_additional.get());
        intent2.putExtra("msg_source", this.C.f436065msg.msg_source.get());
        intent2.putExtra("msg_troopuin", this.C.f436065msg.group_code.get());
        intent2.putExtra(AppConstants.Key.SYSTEM_MESSAGE_SUMMARY, this.C.f436065msg.msg_decided.get());
        intent2.putExtra("info_dealwith_msg", this.C.f436065msg.msg_detail.get());
        intent2.putExtra("msg_title", this.C.f436065msg.msg_title.get());
        intent2.putExtra("msg_source_id", this.C.f436065msg.src_id.get());
        intent2.putExtra("msg_sub_source_id", this.C.f436065msg.sub_src_id.get());
        if (i3 > 0) {
            intent2.putExtra("verify_type", i3);
        }
        if (wZRYUIinfo != null) {
            intent2.putExtra(IProfileCardConst.KEY_WZRY_DATA, wZRYUIinfo);
            intent2.putExtra("strNickName", wZRYUIinfo.nick);
            intent2.putExtra("infonick", wZRYUIinfo.nick);
            ReportController.o(this.f254108e, "CliOper", "", "", "0X800843B", "0X800843B", 0, 0, "", "", "", "");
        }
        z(this.C.get(), this.D);
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddRequestPageForResult((Activity) this.f254107d, intent2, 227);
        this.E.markSystemMsgReaded();
    }

    public void z(structmsg$StructMsg structmsg_structmsg, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, structmsg_structmsg, Long.valueOf(j3));
        } else if (structmsg_structmsg != null) {
            long j16 = structmsg_structmsg.get().msg_seq.get() + structmsg_structmsg.get().msg_type.get();
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).putStructMsgToMap(Long.valueOf(j16), structmsg_structmsg.get());
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setCurrStructMsgKey(j16);
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setCurrentUniseq(j3);
        }
    }
}
