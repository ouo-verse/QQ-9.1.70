package com.tencent.mobileqq.qqguildsdk.util;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProRoleMemberChange;
import com.tencent.mobileqq.qqguildsdk.data.GProRoleMemberListInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProRolePermission;
import com.tencent.mobileqq.qqguildsdk.data.GProScreenShareUserData;
import com.tencent.mobileqq.qqguildsdk.data.GProSecurityInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleUser;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberChange;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.LiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.ac;
import com.tencent.mobileqq.qqguildsdk.data.ad;
import com.tencent.mobileqq.qqguildsdk.data.al;
import com.tencent.mobileqq.qqguildsdk.data.ao;
import com.tencent.mobileqq.qqguildsdk.data.ay;
import com.tencent.mobileqq.qqguildsdk.data.az;
import com.tencent.mobileqq.qqguildsdk.data.bc;
import com.tencent.mobileqq.qqguildsdk.data.bd;
import com.tencent.mobileqq.qqguildsdk.data.bf;
import com.tencent.mobileqq.qqguildsdk.data.bl;
import com.tencent.mobileqq.qqguildsdk.data.bu;
import com.tencent.mobileqq.qqguildsdk.data.bz;
import com.tencent.mobileqq.qqguildsdk.data.ce;
import com.tencent.mobileqq.qqguildsdk.data.cj;
import com.tencent.mobileqq.qqguildsdk.data.ck;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.qqguildsdk.data.cr;
import com.tencent.mobileqq.qqguildsdk.data.cs;
import com.tencent.mobileqq.qqguildsdk.data.ct;
import com.tencent.mobileqq.qqguildsdk.data.cu;
import com.tencent.mobileqq.qqguildsdk.data.cv;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.da;
import com.tencent.mobileqq.qqguildsdk.data.di;
import com.tencent.mobileqq.qqguildsdk.data.dn;
import com.tencent.mobileqq.qqguildsdk.data.ej;
import com.tencent.mobileqq.qqguildsdk.data.ek;
import com.tencent.mobileqq.qqguildsdk.data.em;
import com.tencent.mobileqq.qqguildsdk.data.er;
import com.tencent.mobileqq.qqguildsdk.data.et;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qqguildsdk.data.ey;
import com.tencent.mobileqq.qqguildsdk.data.fb;
import com.tencent.mobileqq.qqguildsdk.data.fc;
import com.tencent.mobileqq.qqguildsdk.data.fg;
import com.tencent.mobileqq.qqguildsdk.data.fi;
import com.tencent.mobileqq.qqguildsdk.data.fj;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qqguildsdk.data.fl;
import com.tencent.mobileqq.qqguildsdk.data.fm;
import com.tencent.mobileqq.qqguildsdk.data.fn;
import com.tencent.mobileqq.qqguildsdk.data.genc.Cdo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProNavigationInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.cv;
import com.tencent.mobileqq.qqguildsdk.data.genc.db;
import com.tencent.mobileqq.qqguildsdk.data.genc.dc;
import com.tencent.mobileqq.qqguildsdk.data.genc.dd;
import com.tencent.mobileqq.qqguildsdk.data.genc.df;
import com.tencent.mobileqq.qqguildsdk.data.genc.dj;
import com.tencent.mobileqq.qqguildsdk.data.genc.dk;
import com.tencent.mobileqq.qqguildsdk.data.genc.dl;
import com.tencent.mobileqq.qqguildsdk.data.genc.dm;
import com.tencent.mobileqq.qqguildsdk.data.genc.fd;
import com.tencent.mobileqq.qqguildsdk.data.k;
import com.tencent.mobileqq.qqguildsdk.data.v;
import com.tencent.mobileqq.qqguildsdk.data.w;
import com.tencent.mobileqq.qqguildsdk.data.x;
import com.tencent.mobileqq.qqguildsdk.data.y;
import com.tencent.mobileqq.qqguildsdk.data.z;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAddGuildWithOptionReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProArchiveArkData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAreaLevel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProArkArg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAtSetInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAuthControlSwitchInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBindMembers;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBindRoleGroups;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryChannelIdList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryChannelInfoList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelCreateInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelMsgNotify;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientAccount;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientArchive;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientIdentity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientPresence;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProConfigItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDirectMsgCreateInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDirectMsgReport;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDirectMsgSession;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDirectMsgThreshold;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetUnbindClientInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildIdentity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInit;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberCountInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildRole;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSpeakableThreshold;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildUserProfile;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProHeartbeatReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuildAnswerItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJumpButtonParamCommon;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJumpButtonParamH5;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJumpButtonType;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProKVNode;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLiveRoomInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMedal;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMedalInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMember;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMsgRouttingHead;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMsgSearchCond;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMsgSearchReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMsgTimeRange;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigationInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNoticeAction;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNoticeCover;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNoticeJump;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNoticeJumpButton;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNoticeText;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProOfficialMedalInfoExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPollingInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProProgrammeInfoReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProQQMsgListChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProQQMsgListGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRevokeOptions;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRole;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleCreateInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleMemberChangeInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleMemberList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRolePermissionCategory;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleDate;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleDayItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleGuildSurface;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleListItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleSendArkGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScreenShareUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSecurityResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSeqCond;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSignGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSourceId;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSpeakThreshold;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserAllGiftInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserDevState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserJoinedGuildSummary;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserPublishedFeedSummary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements fb {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProGuildMemberCountInfo f268549a;

        a(GProGuildMemberCountInfo gProGuildMemberCountInfo) {
            this.f268549a = gProGuildMemberCountInfo;
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements em {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProSignGuildInfo f268550a;

        b(GProSignGuildInfo gProSignGuildInfo) {
            this.f268550a = gProSignGuildInfo;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.em
        public String getDesc() {
            return this.f268550a.getDesc();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.em
        public long getEndTime() {
            return this.f268550a.getEndTime();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.em
        public String getGuildId() {
            return String.valueOf(this.f268550a.getGuildId());
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.em
        public long getStartTime() {
            return this.f268550a.getStartTime();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.em
        public String getUrl() {
            return this.f268550a.getUrl();
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class c implements er {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProUserAllGiftInfo f268551a;

        /* compiled from: P */
        /* loaded from: classes17.dex */
        class a implements et {
            a() {
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.et
            public String a() {
                return c.this.f268551a.getPayGiftInfo().getGiftTipsMsg();
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.et
            public String b() {
                return c.this.f268551a.getPayGiftInfo().getShowGiftPrice();
            }
        }

        /* compiled from: P */
        /* loaded from: classes17.dex */
        class b implements et {
            b() {
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.et
            public String a() {
                return c.this.f268551a.getFreeGiftInfo().getGiftTipsMsg();
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.et
            public String b() {
                return c.this.f268551a.getFreeGiftInfo().getShowGiftPrice();
            }
        }

        c(GProUserAllGiftInfo gProUserAllGiftInfo) {
            this.f268551a = gProUserAllGiftInfo;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.er
        public et a() {
            return new b();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.er
        public et b() {
            return new a();
        }
    }

    public static GProMsgSearchReq A(@Nullable bd bdVar) {
        if (bdVar == null) {
            return new GProMsgSearchReq(0L, 0L, "", -1, z(null), "", 0);
        }
        return new GProMsgSearchReq(O0(bdVar.f()), O0(bdVar.d()), bdVar.e(), Integer.valueOf(bdVar.g()), z(bdVar.a()), bdVar.b(), Integer.valueOf(bdVar.c()));
    }

    public static ArrayList<dn> A0(ArrayList<GProConfigItem> arrayList) {
        ArrayList<dn> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<GProConfigItem> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new ac(it.next()));
            }
        }
        return arrayList2;
    }

    public static GProMsgTimeRange B(@Nullable bf bfVar) {
        if (bfVar == null) {
            return new GProMsgTimeRange("", "");
        }
        return new GProMsgTimeRange(bfVar.b(), bfVar.a());
    }

    public static ArrayList<IGProGuildInfo> B0(List<GProGuild> list) {
        ArrayList<IGProGuildInfo> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        Iterator<GProGuild> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProGuildInfo(it.next()));
        }
        return arrayList;
    }

    public static ArrayList<GProMsgTimeRange> C(@Nullable ArrayList<bf> arrayList) {
        ArrayList<GProMsgTimeRange> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            return arrayList2;
        }
        Iterator<bf> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(B(it.next()));
        }
        return arrayList2;
    }

    public static List<IGProGuildRoleInfo> C0(List<GProGuildRole> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<GProGuildRole> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(u(it.next()));
            }
        }
        return arrayList;
    }

    public static ArrayList<GProNavigationInfo> D(Collection<GGProNavigationInfo> collection) {
        ArrayList<GProNavigationInfo> arrayList = new ArrayList<>();
        if (collection != null) {
            for (GGProNavigationInfo gGProNavigationInfo : collection) {
                arrayList.add(new GProNavigationInfo());
            }
        }
        return arrayList;
    }

    public static List<IGProGuildRoleInfo> D0(List<GProGuildRoleInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public static GProNotice E(@NonNull co coVar) {
        GProNotice gProNotice = new GProNotice();
        gProNotice.setNoticeId(coVar.f265885a);
        gProNotice.setTemplateId(coVar.f265886b);
        gProNotice.setCreateTs((int) coVar.f265887c);
        gProNotice.setExpireTs((int) coVar.f265888d);
        gProNotice.setHandleTs((int) coVar.f265889e);
        try {
            gProNotice.setGuildId(Long.parseLong(coVar.f265890f));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("GProConvert", 2, "convert2GProNotice: " + e16.getMessage());
            }
        }
        if (coVar.f265891g != null) {
            GProNoticeCover gProNoticeCover = new GProNoticeCover();
            co.b bVar = coVar.f265891g;
            gProNoticeCover.linkId = bVar.f265909b;
            gProNoticeCover.type = bVar.f265908a;
            gProNoticeCover.url = bVar.f265910c;
            gProNotice.setCover(gProNoticeCover);
        }
        if (coVar.f265892h != null) {
            ArrayList<GProNoticeText> arrayList = new ArrayList<>();
            for (co.h hVar : coVar.f265892h) {
                GProNoticeText gProNoticeText = new GProNoticeText();
                gProNoticeText.linkId = hVar.f265925b;
                gProNoticeText.content = hVar.f265926c;
                gProNoticeText.type = hVar.f265924a;
                arrayList.add(gProNoticeText);
            }
            gProNotice.setTitle(arrayList);
        }
        if (coVar.f265893i != null) {
            ArrayList<GProNoticeText> arrayList2 = new ArrayList<>();
            for (co.h hVar2 : coVar.f265893i) {
                GProNoticeText gProNoticeText2 = new GProNoticeText();
                gProNoticeText2.linkId = hVar2.f265925b;
                gProNoticeText2.content = hVar2.f265926c;
                gProNoticeText2.type = hVar2.f265924a;
                arrayList2.add(gProNoticeText2);
            }
            gProNotice.setSubTitle(arrayList2);
        }
        if (coVar.f265894j != null) {
            ArrayList<GProNoticeText> arrayList3 = new ArrayList<>();
            for (co.h hVar3 : coVar.f265894j) {
                GProNoticeText gProNoticeText3 = new GProNoticeText();
                gProNoticeText3.linkId = hVar3.f265925b;
                gProNoticeText3.content = hVar3.f265926c;
                gProNoticeText3.type = hVar3.f265924a;
                arrayList3.add(gProNoticeText3);
            }
            gProNotice.setComment(arrayList3);
        }
        if (coVar.f265895k != null) {
            ArrayList<GProNoticeAction> arrayList4 = new ArrayList<>();
            for (co.a aVar : coVar.f265895k) {
                GProNoticeAction gProNoticeAction = new GProNoticeAction();
                gProNoticeAction.actionId = aVar.f265907c;
                gProNoticeAction.title = aVar.f265906b;
                gProNoticeAction.style = aVar.f265905a;
                arrayList4.add(gProNoticeAction);
            }
            gProNotice.setActionList(arrayList4);
        }
        gProNotice.setJoinSign(coVar.f265896l);
        gProNotice.setMsgType(coVar.f265897m);
        if (coVar.f265898n != null) {
            ArrayList<GProNoticeJump> arrayList5 = new ArrayList<>();
            for (co.c cVar : coVar.f265898n) {
                GProNoticeJump gProNoticeJump = new GProNoticeJump();
                gProNoticeJump.text = cVar.f265911a;
                gProNoticeJump.url = cVar.f265912b;
                gProNoticeJump.placeHolderIndex = cVar.f265913c;
                gProNoticeJump.iconUrl = cVar.f265914d;
                gProNoticeJump.iconUrlIndex = cVar.f265915e;
                arrayList5.add(gProNoticeJump);
            }
            gProNotice.setJumpLink(arrayList5);
        }
        gProNotice.setNoticeType(coVar.f265899o);
        gProNotice.setHandlerUin(coVar.f265900p);
        gProNotice.setHandleResult(coVar.f265901q);
        gProNotice.setHandlerTinyId(coVar.f265902r);
        gProNotice.setHandlerNickName(coVar.f265903s);
        if (coVar.f265904t != null) {
            ArrayList<GProNoticeJumpButton> arrayList6 = new ArrayList<>();
            for (co.d dVar : coVar.f265904t) {
                if (dVar != null) {
                    GProNoticeJumpButton gProNoticeJumpButton = new GProNoticeJumpButton();
                    if (dVar.f265916a != null) {
                        GProJumpButtonParamCommon gProJumpButtonParamCommon = new GProJumpButtonParamCommon();
                        co.e eVar = dVar.f265916a;
                        gProJumpButtonParamCommon.color = eVar.f265919b;
                        gProJumpButtonParamCommon.text = eVar.f265918a;
                        gProNoticeJumpButton.param = gProJumpButtonParamCommon;
                    }
                    if (dVar.f265917b != null) {
                        GProJumpButtonType gProJumpButtonType = new GProJumpButtonType();
                        co.g gVar = dVar.f265917b;
                        gProJumpButtonType.type = gVar.f265921a;
                        if (gVar.f265922b != null) {
                            GProJumpButtonParamH5 gProJumpButtonParamH5 = new GProJumpButtonParamH5();
                            gProJumpButtonParamH5.url = dVar.f265917b.f265922b.f265920a;
                            gProJumpButtonType.paramH5 = gProJumpButtonParamH5;
                        }
                        gProJumpButtonType.paramCustomize = dVar.f265917b.f265923c;
                        gProNoticeJumpButton.type = gProJumpButtonType;
                    }
                    arrayList6.add(gProNoticeJumpButton);
                }
            }
            gProNotice.setJumpButtons(arrayList6);
        }
        return gProNotice;
    }

    public static List<ej> E0(ArrayList<GProRole> arrayList) {
        return new ArrayList(K(arrayList));
    }

    @NonNull
    public static GProPollingInfo F(@NonNull fj fjVar) {
        GProPollingInfo gProPollingInfo = new GProPollingInfo(O0(fjVar.getGuildId()), O0(fjVar.getChannelId()), 0, fjVar.getSource());
        gProPollingInfo.pollingTypes = fjVar.c();
        return gProPollingInfo;
    }

    public static List<IGProRoleMemberChange> F0(List<GProRoleMemberChangeInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<GProRoleMemberChangeInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new GProRoleMemberChange(it.next()));
            }
        }
        return arrayList;
    }

    @NonNull
    public static ArrayList<GProPollingInfo> G(@NonNull List<fj> list) {
        ArrayList<GProPollingInfo> arrayList = new ArrayList<>(list.size());
        Iterator<fj> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(F(it.next()));
        }
        return arrayList;
    }

    public static List<IGProRoleMemberListInfo> G0(List<GProRoleMemberList> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<GProRoleMemberList> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(L(it.next()));
        }
        return arrayList;
    }

    public static GProProgrammeInfoReq H(bl blVar) {
        if (blVar == null) {
            return new GProProgrammeInfoReq("", 0);
        }
        return new GProProgrammeInfoReq(blVar.a(), blVar.b());
    }

    public static ArrayList<ek> H0(List<GProRolePermissionCategory> list) {
        ArrayList<ek> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        Iterator<GProRolePermissionCategory> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new bu(it.next()));
        }
        return arrayList;
    }

    public static GProRevokeOptions I(@Nullable fm fmVar) {
        if (fmVar == null) {
            return new GProRevokeOptions(0);
        }
        return new GProRevokeOptions(fmVar.a());
    }

    public static em I0(GProSignGuildInfo gProSignGuildInfo) {
        return new b(gProSignGuildInfo);
    }

    public static GProRoleCreateInfo J(fn fnVar) {
        if (fnVar == null) {
            return new GProRoleCreateInfo("", 0L, false, ad.b(new GProRolePermission()));
        }
        return new GProRoleCreateInfo(fnVar.c(), fnVar.a(), fnVar.b(), ad.b(fnVar.d()));
    }

    public static er J0(GProUserAllGiftInfo gProUserAllGiftInfo) {
        return new c(gProUserAllGiftInfo);
    }

    public static List<GProRoleInfo> K(ArrayList<GProRole> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator<GProRole> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new GProRoleInfo(it.next()));
            }
        }
        return arrayList2;
    }

    public static List<IGProUserInfo> K0(List<GProUser> list) {
        return new ArrayList(X(list));
    }

    public static GProRoleMemberListInfo L(GProRoleMemberList gProRoleMemberList) {
        return new GProRoleMemberListInfo(gProRoleMemberList.getRole(), gProRoleMemberList.getMembers());
    }

    public static ey L0(GProAtSetInfo gProAtSetInfo) {
        return new ao(gProAtSetInfo);
    }

    private static GProScheduleChannelInfo M(GuildScheduleChannelInfo guildScheduleChannelInfo) {
        if (guildScheduleChannelInfo == null) {
            return new GProScheduleChannelInfo(0L, 0, 0L, "", false, false);
        }
        return new GProScheduleChannelInfo(guildScheduleChannelInfo.getChannelId(), guildScheduleChannelInfo.getType(), guildScheduleChannelInfo.getGuildId(), guildScheduleChannelInfo.getChannelName(), guildScheduleChannelInfo.isPrivate(), guildScheduleChannelInfo.isHasJoin());
    }

    public static int M0(String str) {
        if (j.i(str)) {
            return 0;
        }
        return Integer.valueOf(str).intValue();
    }

    public static GProScheduleInfo N(GuildScheduleInfo guildScheduleInfo) {
        if (guildScheduleInfo == null) {
            return new GProScheduleInfo(0L, "", 0L, 0L, "", 0, new GProScheduleChannelInfo(0L, 0, 0L, "", false, false), 0, 0L, new GProScheduleUser("", 0L, "", 0), 0, 0, new ArrayList(), false);
        }
        GProScheduleInfo gProScheduleInfo = new GProScheduleInfo(guildScheduleInfo.getScheduleId(), guildScheduleInfo.getTitle(), guildScheduleInfo.getStartTimeMs(), guildScheduleInfo.getEndTimeMs(), guildScheduleInfo.getContent(), guildScheduleInfo.getReminderTimeType(), M(guildScheduleInfo.getChannelInfo()), guildScheduleInfo.getInviteStatus(), guildScheduleInfo.getCreateTimeMs(), Q(guildScheduleInfo.getCreator()), guildScheduleInfo.getAcceptedNums(), guildScheduleInfo.getRejectedNums(), R(guildScheduleInfo.getAcceptedUser()), guildScheduleInfo.isNotified());
        gProScheduleInfo.otherJumpAddress = guildScheduleInfo.getOtherJumpAddress();
        return gProScheduleInfo;
    }

    public static List<ILiveRoomInfo> N0(List<GProLiveRoomInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<GProLiveRoomInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new LiveRoomInfo(it.next()));
            }
        }
        return arrayList;
    }

    public static GProScheduleSendArkGuildInfo O(cu cuVar) {
        if (cuVar == null) {
            return new GProScheduleSendArkGuildInfo(0L, 0L);
        }
        return new GProScheduleSendArkGuildInfo(cuVar.b(), cuVar.a());
    }

    public static long O0(String str) {
        if (j.i(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e16) {
            h.k("GProConvert", 1, "system convert", Log.getStackTraceString(e16));
            return 0L;
        }
    }

    public static ArrayList<GProScheduleSendArkGuildInfo> P(ArrayList<cu> arrayList) {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        ArrayList<GProScheduleSendArkGuildInfo> arrayList2 = new ArrayList<>();
        Iterator<cu> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(O(it.next()));
        }
        return arrayList2;
    }

    public static ArrayList<Long> P0(Collection<String> collection) {
        ArrayList<Long> arrayList = new ArrayList<>();
        if (collection != null) {
            for (String str : collection) {
                if (!j.i(str)) {
                    arrayList.add(Long.valueOf(str));
                }
            }
        }
        return arrayList;
    }

    private static GProScheduleUser Q(GuildScheduleUser guildScheduleUser) {
        if (guildScheduleUser == null) {
            return new GProScheduleUser("", 0L, "", 0);
        }
        return new GProScheduleUser(guildScheduleUser.getNick(), guildScheduleUser.getTinyId(), guildScheduleUser.getAvatar(), guildScheduleUser.getRole());
    }

    public static HashMap<String, String> Q0(HashMap<Long, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (Map.Entry<Long, String> entry : hashMap.entrySet()) {
            hashMap2.put(X0(entry.getKey().longValue()), entry.getValue());
        }
        return hashMap2;
    }

    private static ArrayList<GProScheduleUser> R(ArrayList<GuildScheduleUser> arrayList) {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        ArrayList<GProScheduleUser> arrayList2 = new ArrayList<>();
        Iterator<GuildScheduleUser> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Q(it.next()));
        }
        return arrayList2;
    }

    public static List<Object> R0(List<GProMember> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<GProMember> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new fg(it.next()));
        }
        return arrayList;
    }

    @NonNull
    public static GProScreenShareUserData S(@NonNull GProScreenShareUser gProScreenShareUser) {
        return new GProScreenShareUserData(gProScreenShareUser.getTinyId(), gProScreenShareUser.getState());
    }

    @NonNull
    public static fk S0(@NonNull GProQQMsgListChannel gProQQMsgListChannel) {
        return new fk(X0(gProQQMsgListChannel.getGuildId()), X0(gProQQMsgListChannel.getChannelId()), gProQQMsgListChannel.getTopTimestamp(), gProQQMsgListChannel.getGuildName(), gProQQMsgListChannel.getChannelName(), gProQQMsgListChannel.getAvatarSeq(), gProQQMsgListChannel.getChannelType(), gProQQMsgListChannel.getAppid());
    }

    @NonNull
    public static List<GProScreenShareUserData> T(@NonNull List<GProScreenShareUser> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<GProScreenShareUser> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(S(it.next()));
        }
        return arrayList;
    }

    @NonNull
    public static List<fk> T0(@NonNull List<GProQQMsgListChannel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<GProQQMsgListChannel> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(S0(it.next()));
        }
        return arrayList;
    }

    public static GProSecurityInfo U(GProSecurityResult gProSecurityResult) {
        if (gProSecurityResult == null) {
            return GProSecurityInfo.createDefault();
        }
        return new GProSecurityInfo(gProSecurityResult);
    }

    @NonNull
    public static fl U0(@NonNull GProQQMsgListGuild gProQQMsgListGuild) {
        return new fl(X0(gProQQMsgListGuild.getGuildId()), gProQQMsgListGuild.getTopTimestamp(), gProQQMsgListGuild.getGuildName(), gProQQMsgListGuild.getAvatarSeq());
    }

    public static GProSeqCond V(@Nullable bz bzVar) {
        if (bzVar == null) {
            return new GProSeqCond(0L, 0L, 0L, 0L);
        }
        return new GProSeqCond(O0(bzVar.c()), O0(bzVar.a()), bzVar.d(), bzVar.b());
    }

    @NonNull
    public static List<fl> V0(@NonNull List<GProQQMsgListGuild> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<GProQQMsgListGuild> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(U0(it.next()));
        }
        return arrayList;
    }

    public static GProSourceId W(GuildSourceId guildSourceId) {
        if (guildSourceId != null) {
            GProSourceId gProSourceId = new GProSourceId(guildSourceId.n(), guildSourceId.k(), guildSourceId.g(), guildSourceId.c(), guildSourceId.o(), guildSourceId.q(), guildSourceId.b(), guildSourceId.j(), guildSourceId.r(), guildSourceId.m(), guildSourceId.p());
            gProSourceId.searchExtensionInfo = guildSourceId.l();
            gProSourceId.inviteCode = guildSourceId.e();
            gProSourceId.contentId = guildSourceId.a();
            gProSourceId.inviteUuid = guildSourceId.f();
            return gProSourceId;
        }
        return new GProSourceId(0L, "", "", "", "", "", 0, "", "", "", 0);
    }

    public static String W0(int i3) {
        return Integer.toString(i3);
    }

    public static List<GProUserInfo> X(List<GProUser> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<GProUser> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new GProUserInfo(it.next()));
            }
        }
        return arrayList;
    }

    public static String X0(long j3) {
        return Long.toString(j3);
    }

    public static cv Y(GProHeartbeatReq gProHeartbeatReq) {
        String authMeta = gProHeartbeatReq.getAuthMeta();
        if (authMeta == null) {
            authMeta = "";
        }
        fd b06 = b0(gProHeartbeatReq.getUserDevState());
        ArrayList<df> Z = Z(gProHeartbeatReq.getKvInfoList());
        cv cvVar = new cv();
        cvVar.l(gProHeartbeatReq.getGuildId());
        cvVar.k(gProHeartbeatReq.getChannelId());
        cvVar.j(authMeta);
        cvVar.n(gProHeartbeatReq.getRoomIdList());
        cvVar.o(gProHeartbeatReq.getStreamType());
        cvVar.p(b06);
        cvVar.m(Z);
        return cvVar;
    }

    public static ArrayList<String> Y0(List<Long> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null) {
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(X0(it.next().longValue()));
            }
        }
        return arrayList;
    }

    public static ArrayList<df> Z(ArrayList<GProKVNode> arrayList) {
        ArrayList<df> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<GProKVNode> it = arrayList.iterator();
            while (it.hasNext()) {
                GProKVNode next = it.next();
                String key = next.getKey();
                if (key == null) {
                    key = "";
                }
                byte[] value = next.getValue();
                if (value == null) {
                    value = new byte[0];
                }
                df dfVar = new df();
                dfVar.c(key);
                dfVar.d(value);
                arrayList2.add(dfVar);
            }
        }
        return arrayList2;
    }

    public static GProArchiveArkData Z0() {
        return new GProArchiveArkData(0, "", "", new GProArkArg("", "", "", "", "", "", ""));
    }

    private static com.tencent.mobileqq.qqguildsdk.data.c a(HashMap<String, GProChannelInfo> hashMap, com.tencent.mobileqq.qqguildsdk.data.b bVar, boolean z16) {
        GProChannelInfo gProChannelInfo;
        if (bVar != null && bVar.g(z16)) {
            com.tencent.mobileqq.qqguildsdk.data.c cVar = new com.tencent.mobileqq.qqguildsdk.data.c(bVar.c(), bVar.b());
            cVar.c(bVar.d());
            if (bVar.f()) {
                for (String str : bVar.e()) {
                    if (hashMap.containsKey(str) && (gProChannelInfo = hashMap.get(str)) != null) {
                        gProChannelInfo.setCategory(cVar.getCategoryId(), cVar.getCategoryName());
                        gProChannelInfo.setCategoryType(cVar.getCategoryType());
                        cVar.a(gProChannelInfo);
                    }
                }
            }
            return cVar;
        }
        return null;
    }

    public static dj a0(@NonNull co coVar) {
        dj djVar = new dj();
        djVar.J(coVar.f265885a);
        djVar.M(coVar.f265886b);
        djVar.x((int) coVar.f265887c);
        djVar.y((int) coVar.f265888d);
        djVar.B((int) coVar.f265889e);
        try {
            djVar.z(Long.parseLong(coVar.f265890f));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("GProConvert", 2, "convert2GProNotice: " + e16.getMessage());
            }
        }
        if (coVar.f265891g != null) {
            dl dlVar = new dl();
            dlVar.d(coVar.f265891g.f265909b);
            dlVar.e(coVar.f265891g.f265908a);
            dlVar.f(coVar.f265891g.f265910c);
            djVar.w(dlVar);
        }
        if (coVar.f265892h != null) {
            ArrayList<Cdo> arrayList = new ArrayList<>();
            for (co.h hVar : coVar.f265892h) {
                Cdo cdo = new Cdo();
                cdo.e(hVar.f265925b);
                cdo.d(hVar.f265926c);
                cdo.f(hVar.f265924a);
                arrayList.add(cdo);
            }
            djVar.N(arrayList);
        }
        if (coVar.f265893i != null) {
            ArrayList<Cdo> arrayList2 = new ArrayList<>();
            for (co.h hVar2 : coVar.f265893i) {
                Cdo cdo2 = new Cdo();
                cdo2.e(hVar2.f265925b);
                cdo2.d(hVar2.f265926c);
                cdo2.f(hVar2.f265924a);
                arrayList2.add(cdo2);
            }
            djVar.L(arrayList2);
        }
        if (coVar.f265894j != null) {
            ArrayList<Cdo> arrayList3 = new ArrayList<>();
            for (co.h hVar3 : coVar.f265894j) {
                Cdo cdo3 = new Cdo();
                cdo3.e(hVar3.f265925b);
                cdo3.d(hVar3.f265926c);
                cdo3.f(hVar3.f265924a);
                arrayList3.add(cdo3);
            }
            djVar.v(arrayList3);
        }
        if (coVar.f265895k != null) {
            ArrayList<dk> arrayList4 = new ArrayList<>();
            for (co.a aVar : coVar.f265895k) {
                dk dkVar = new dk();
                dkVar.d(aVar.f265907c);
                dkVar.f(aVar.f265906b);
                dkVar.e(aVar.f265905a);
                arrayList4.add(dkVar);
            }
            djVar.u(arrayList4);
        }
        djVar.F(coVar.f265896l);
        djVar.I(coVar.f265897m);
        if (coVar.f265898n != null) {
            ArrayList<dm> arrayList5 = new ArrayList<>();
            for (co.c cVar : coVar.f265898n) {
                dm dmVar = new dm();
                dmVar.i(cVar.f265911a);
                dmVar.j(cVar.f265912b);
                dmVar.h(cVar.f265913c);
                dmVar.f(cVar.f265914d);
                dmVar.g(cVar.f265915e);
                arrayList5.add(dmVar);
            }
            djVar.H(arrayList5);
        }
        djVar.K(coVar.f265899o);
        djVar.E(coVar.f265900p);
        djVar.A(coVar.f265901q);
        djVar.D(coVar.f265902r);
        djVar.C(coVar.f265903s);
        if (coVar.f265904t != null) {
            ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.dn> arrayList6 = new ArrayList<>();
            for (co.d dVar : coVar.f265904t) {
                if (dVar != null) {
                    com.tencent.mobileqq.qqguildsdk.data.genc.dn dnVar = new com.tencent.mobileqq.qqguildsdk.data.genc.dn();
                    if (dVar.f265916a != null) {
                        db dbVar = new db();
                        dbVar.c(dVar.f265916a.f265919b);
                        dbVar.d(dVar.f265916a.f265918a);
                        dnVar.c(dbVar);
                    }
                    if (dVar.f265917b != null) {
                        dd ddVar = new dd();
                        ddVar.f(dVar.f265917b.f265921a);
                        if (dVar.f265917b.f265922b != null) {
                            dc dcVar = new dc();
                            dcVar.b(dVar.f265917b.f265922b.f265920a);
                            ddVar.e(dcVar);
                        }
                        ddVar.d(dVar.f265917b.f265923c);
                        dnVar.d(ddVar);
                    }
                    arrayList6.add(dnVar);
                }
            }
            djVar.G(arrayList6);
        }
        return djVar;
    }

    public static GProClientPresence a1() {
        return new GProClientPresence(0, "", "", "", "", 0L, 0L, "", 0L, 0L, 0L, "");
    }

    public static ArrayList<com.tencent.mobileqq.qqguildsdk.data.dc> b(ArrayList<GProAreaLevel> arrayList) {
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.dc> arrayList2 = new ArrayList<>();
        Iterator<GProAreaLevel> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new al(it.next()));
        }
        return arrayList2;
    }

    public static fd b0(GProUserDevState gProUserDevState) {
        fd fdVar = new fd();
        fdVar.i(gProUserDevState.getMicState());
        fdVar.g(gProUserDevState.getCameraState());
        fdVar.k(gProUserDevState.getScreenState());
        fdVar.j(gProUserDevState.getNetworkQuality());
        fdVar.l(gProUserDevState.getSysMicBusy());
        return fdVar;
    }

    public static GProGuildUserProfile b1() {
        return new GProGuildUserProfile(-1L, -1L, "", 0, 0, false, (byte) 0, (short) 0, (short) 0, (short) 0, "", "", "", 0, 0, 0, 0, 0, 0L, 0, "", a1(), new ArrayList(), new ArrayList(), false, Z0(), 0, 0, 0L, false, 0L, "", 0, "", null, null, null, false, 0, 0, 0, "", "", "", new ArrayList(), new GProUserJoinedGuildSummary(), new GProUserPublishedFeedSummary(), new GProClientIdentity(), new GProSignGuildInfo(), new GProUserAllGiftInfo());
    }

    public static List<cy> c(ArrayList<GProCategoryChannelInfoList> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<GProCategoryChannelInfoList> it = arrayList.iterator();
        while (it.hasNext()) {
            GProCategoryChannelInfoList next = it.next();
            com.tencent.mobileqq.qqguildsdk.data.c cVar = new com.tencent.mobileqq.qqguildsdk.data.c(next.getName(), next.getCategoryId());
            cVar.c(next.getCategoryType());
            Iterator<GProChannel> it5 = next.getChannelInfoList().iterator();
            while (it5.hasNext()) {
                GProChannelInfo gProChannelInfo = new GProChannelInfo(it5.next());
                gProChannelInfo.setCategoryType(cVar.getCategoryType());
                cVar.a(gProChannelInfo);
            }
            arrayList2.add(cVar);
        }
        return arrayList2;
    }

    public static GProGuildIdentity c0(cj cjVar) {
        return new GProGuildIdentity(cjVar.a(), cjVar.b(), cjVar.c());
    }

    public static List<cy> d(Vector<com.tencent.mobileqq.qqguildsdk.data.c> vector) {
        ArrayList arrayList;
        if (vector != null) {
            arrayList = new ArrayList(vector);
        } else {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public static ck d0(GProGuildInit gProGuildInit) {
        if (gProGuildInit != null) {
            return new ck(gProGuildInit);
        }
        return null;
    }

    public static GProCategoryChannelIdList e(com.tencent.mobileqq.qqguildsdk.data.b bVar) {
        if (bVar != null) {
            return new GProCategoryChannelIdList(bVar.c(), bVar.b(), P0(bVar.e()), true, bVar.d(), false, "", "", 0);
        }
        return null;
    }

    public static fb e0(GProGuildMemberCountInfo gProGuildMemberCountInfo) {
        if (gProGuildMemberCountInfo == null) {
            return null;
        }
        return new a(gProGuildMemberCountInfo);
    }

    @NonNull
    public static com.tencent.mobileqq.qqguildsdk.data.b f(GProCategoryChannelIdList gProCategoryChannelIdList) {
        if (gProCategoryChannelIdList == null) {
            return new com.tencent.mobileqq.qqguildsdk.data.b("", 0L, new ArrayList());
        }
        com.tencent.mobileqq.qqguildsdk.data.b bVar = new com.tencent.mobileqq.qqguildsdk.data.b(gProCategoryChannelIdList.getName(), gProCategoryChannelIdList.getCategoryId(), Y0(gProCategoryChannelIdList.getChannelList()));
        bVar.j(gProCategoryChannelIdList.getCategoryType());
        return bVar;
    }

    @NonNull
    public static co f0(@NonNull GProNotice gProNotice) {
        co coVar = new co();
        coVar.f265885a = gProNotice.getNoticeId();
        coVar.f265886b = gProNotice.getTemplateId();
        coVar.f265887c = gProNotice.getCreateTs();
        coVar.f265888d = gProNotice.getExpireTs();
        coVar.f265889e = gProNotice.getHandleTs();
        try {
            coVar.f265890f = String.valueOf(gProNotice.getGuildId());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("GProConvert", 2, "getGuildNoticeList: " + e16.getMessage());
            }
        }
        coVar.f265891g = new co.b();
        if (gProNotice.getCover() != null) {
            coVar.f265891g.f265909b = gProNotice.getCover().getLinkId();
            coVar.f265891g.f265908a = gProNotice.getCover().getType();
            coVar.f265891g.f265910c = gProNotice.getCover().getUrl();
        }
        coVar.f265892h = new ArrayList();
        if (gProNotice.getTitle() != null) {
            Iterator<GProNoticeText> it = gProNotice.getTitle().iterator();
            while (it.hasNext()) {
                GProNoticeText next = it.next();
                co.h hVar = new co.h();
                hVar.f265925b = next.getLinkId();
                hVar.f265926c = next.getContent();
                hVar.f265924a = next.getType();
                coVar.f265892h.add(hVar);
            }
        }
        coVar.f265893i = new ArrayList();
        if (gProNotice.getSubTitle() != null) {
            Iterator<GProNoticeText> it5 = gProNotice.getSubTitle().iterator();
            while (it5.hasNext()) {
                GProNoticeText next2 = it5.next();
                co.h hVar2 = new co.h();
                hVar2.f265925b = next2.getLinkId();
                hVar2.f265926c = next2.getContent();
                hVar2.f265924a = next2.getType();
                coVar.f265893i.add(hVar2);
            }
        }
        coVar.f265894j = new ArrayList();
        if (gProNotice.getComment() != null) {
            Iterator<GProNoticeText> it6 = gProNotice.getComment().iterator();
            while (it6.hasNext()) {
                GProNoticeText next3 = it6.next();
                co.h hVar3 = new co.h();
                hVar3.f265925b = next3.getLinkId();
                hVar3.f265926c = next3.getContent();
                hVar3.f265924a = next3.getType();
                coVar.f265894j.add(hVar3);
            }
        }
        coVar.f265895k = new ArrayList();
        if (gProNotice.getActionList() != null) {
            Iterator<GProNoticeAction> it7 = gProNotice.getActionList().iterator();
            while (it7.hasNext()) {
                GProNoticeAction next4 = it7.next();
                co.a aVar = new co.a();
                aVar.f265907c = next4.getActionId();
                aVar.f265906b = next4.getTitle();
                aVar.f265905a = next4.getStyle();
                coVar.f265895k.add(aVar);
            }
        }
        coVar.f265896l = gProNotice.getJoinSign();
        coVar.f265897m = gProNotice.getMsgType();
        coVar.f265898n = new ArrayList();
        Iterator<GProNoticeJump> it8 = gProNotice.getJumpLink().iterator();
        while (it8.hasNext()) {
            GProNoticeJump next5 = it8.next();
            co.c cVar = new co.c();
            cVar.f265911a = next5.getText();
            cVar.f265912b = next5.getUrl();
            cVar.f265913c = next5.getPlaceHolderIndex();
            cVar.f265914d = next5.getIconUrl();
            cVar.f265915e = next5.getIconUrlIndex();
            coVar.f265898n.add(cVar);
        }
        coVar.f265899o = gProNotice.getNoticeType();
        coVar.f265900p = gProNotice.getHandlerUin();
        coVar.f265901q = gProNotice.getHandleResult();
        coVar.f265902r = gProNotice.getHandlerTinyId();
        coVar.f265903s = gProNotice.getHandlerNickName();
        coVar.f265904t = new ArrayList();
        Iterator<GProNoticeJumpButton> it9 = gProNotice.getJumpButtons().iterator();
        while (it9.hasNext()) {
            GProNoticeJumpButton next6 = it9.next();
            if (next6 != null) {
                co.d dVar = new co.d();
                GProJumpButtonParamCommon gProJumpButtonParamCommon = next6.param;
                if (gProJumpButtonParamCommon != null) {
                    co.e eVar = new co.e();
                    eVar.f265919b = gProJumpButtonParamCommon.color;
                    eVar.f265918a = gProJumpButtonParamCommon.text;
                    dVar.f265916a = eVar;
                }
                GProJumpButtonType gProJumpButtonType = next6.type;
                if (gProJumpButtonType != null) {
                    co.g gVar = new co.g();
                    gVar.f265921a = gProJumpButtonType.type;
                    GProJumpButtonParamH5 gProJumpButtonParamH5 = gProJumpButtonType.paramH5;
                    if (gProJumpButtonParamH5 != null) {
                        co.f fVar = new co.f();
                        fVar.f265920a = gProJumpButtonParamH5.url;
                        gVar.f265922b = fVar;
                    }
                    gVar.f265923c = gProJumpButtonType.paramCustomize;
                    dVar.f265917b = gVar;
                }
                coVar.f265904t.add(dVar);
            }
        }
        return coVar;
    }

    @NonNull
    public static List<com.tencent.mobileqq.qqguildsdk.data.b> g(List<GProCategoryChannelIdList> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GProCategoryChannelIdList gProCategoryChannelIdList : list) {
                com.tencent.mobileqq.qqguildsdk.data.b bVar = new com.tencent.mobileqq.qqguildsdk.data.b(gProCategoryChannelIdList.getName(), gProCategoryChannelIdList.getCategoryId(), Y0(gProCategoryChannelIdList.getChannelList()));
                bVar.j(gProCategoryChannelIdList.getCategoryType());
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @NonNull
    public static List<co> g0(@NonNull List<GProNotice> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<GProNotice> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f0(it.next()));
        }
        return arrayList;
    }

    public static ArrayList<GProCategoryChannelIdList> h(List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
        ArrayList<GProCategoryChannelIdList> arrayList = new ArrayList<>();
        if (list != null) {
            for (com.tencent.mobileqq.qqguildsdk.data.b bVar : list) {
                arrayList.add(new GProCategoryChannelIdList(bVar.c(), bVar.b(), P0(bVar.e()), true, 0, false, "", "", 0));
            }
        }
        return arrayList;
    }

    private static GuildScheduleChannelInfo h0(GProScheduleChannelInfo gProScheduleChannelInfo) {
        if (gProScheduleChannelInfo == null) {
            return new GuildScheduleChannelInfo();
        }
        return new GuildScheduleChannelInfo.a().h(gProScheduleChannelInfo.getChannelId()).m(gProScheduleChannelInfo.getType()).j(gProScheduleChannelInfo.getGuildId()).i(gProScheduleChannelInfo.getChannelName()).l(gProScheduleChannelInfo.getIsPrivate()).k(gProScheduleChannelInfo.getHasJoin()).g();
    }

    public static Vector<com.tencent.mobileqq.qqguildsdk.data.c> i(ck ckVar) {
        if (ckVar != null && !ckVar.d()) {
            HashMap<String, GProChannelInfo> b16 = ckVar.b();
            Vector<com.tencent.mobileqq.qqguildsdk.data.c> b17 = com.tencent.mobileqq.qqguildsdk.data.c.b();
            com.tencent.mobileqq.qqguildsdk.data.c a16 = a(b16, ckVar.c(), false);
            if (a16 != null) {
                b17.add(a16);
            }
            Iterator<com.tencent.mobileqq.qqguildsdk.data.b> it = ckVar.a().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.qqguildsdk.data.c a17 = a(b16, it.next(), true);
                if (a17 != null) {
                    b17.add(a17);
                }
            }
            return b17;
        }
        h.u("GProConvert", true, "cache", "convert2CategoryMap initInfo is null");
        return null;
    }

    private static cr i0(GProScheduleDate gProScheduleDate) {
        if (gProScheduleDate == null) {
            return new cr();
        }
        return new cr.a().d(gProScheduleDate.getDateMs()).e(gProScheduleDate.getInviteStatus()).c();
    }

    public static GProChannelCreateInfo j(com.tencent.mobileqq.qqguildsdk.data.d dVar) {
        int s16 = dVar.s();
        return new GProChannelCreateInfo(dVar.m(), dVar.k(), dVar.p(), dVar.n(), 0, 0, dVar.a(), 0, new ArrayList(), P0(dVar.q()), P0(dVar.r()), dVar.o(), 0, s16, dVar.j(), P0(dVar.h()), P0(dVar.i()), m(dVar.b()), o(dVar.d()), n(dVar.c()), 0, 0, "", "", dVar.t());
    }

    public static ArrayList<cr> j0(ArrayList<GProScheduleDate> arrayList) {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        ArrayList<cr> arrayList2 = new ArrayList<>();
        Iterator<GProScheduleDate> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(i0(it.next()));
        }
        return arrayList2;
    }

    @NonNull
    @SuppressLint({"WrongConstant"})
    public static k k(@NonNull GProDirectMsgSession gProDirectMsgSession) {
        k kVar = new k();
        kVar.m(X0(gProDirectMsgSession.getGuildId()));
        kVar.k(X0(gProDirectMsgSession.getChannelId()));
        kVar.o(gProDirectMsgSession.getMsgTime());
        kVar.n(gProDirectMsgSession.getMsgNotifyType());
        kVar.p(gProDirectMsgSession.getPeerMemberType());
        kVar.l(gProDirectMsgSession.getChannelType());
        kVar.u(X0(gProDirectMsgSession.getSrcTinyId()));
        kVar.q(X0(gProDirectMsgSession.getSrcGuildId()));
        kVar.r(gProDirectMsgSession.getSrcGuildName());
        kVar.s(gProDirectMsgSession.getSrcMemberName());
        kVar.t(gProDirectMsgSession.getSrcNickName());
        return kVar;
    }

    public static cs k0(GProScheduleDayItem gProScheduleDayItem) {
        if (gProScheduleDayItem == null) {
            return new cs();
        }
        return new cs.a().d(gProScheduleDayItem.getDateMs()).e(q0(gProScheduleDayItem.getScheduleListItems())).c();
    }

    public static GProAddGuildWithOptionReq l(az azVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<ay> it = azVar.a().iterator();
        while (it.hasNext()) {
            ay next = it.next();
            arrayList.add(new GProJoinGuildAnswerItem(next.b(), next.a()));
        }
        return new GProAddGuildWithOptionReq(O0(azVar.c()), W(azVar.e()), azVar.d(), azVar.b(), arrayList);
    }

    public static ArrayList<cs> l0(ArrayList<GProScheduleDayItem> arrayList) {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        ArrayList<cs> arrayList2 = new ArrayList<>();
        Iterator<GProScheduleDayItem> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(k0(it.next()));
        }
        return arrayList2;
    }

    public static ArrayList<GProAuthControlSwitchInfo> m(Collection<v> collection) {
        ArrayList<GProAuthControlSwitchInfo> arrayList = new ArrayList<>();
        if (collection != null) {
            for (v vVar : collection) {
                arrayList.add(new GProAuthControlSwitchInfo(vVar.a(), vVar.b()));
            }
        }
        return arrayList;
    }

    public static GuildScheduleInfo m0(GProScheduleInfo gProScheduleInfo) {
        return n0(gProScheduleInfo, null);
    }

    public static ArrayList<GProBindMembers> n(Collection<w> collection) {
        ArrayList<GProBindMembers> arrayList = new ArrayList<>();
        if (collection != null) {
            for (w wVar : collection) {
                arrayList.add(new GProBindMembers(wVar.a(), wVar.b()));
            }
        }
        return arrayList;
    }

    public static GuildScheduleInfo n0(GProScheduleInfo gProScheduleInfo, GProScheduleGuildSurface gProScheduleGuildSurface) {
        if (gProScheduleInfo == null) {
            return new GuildScheduleInfo();
        }
        GuildScheduleChannelInfo h06 = h0(gProScheduleInfo.getChannelInfo());
        GuildScheduleUser r06 = r0(gProScheduleInfo.getCreator());
        GuildScheduleInfo.a G = new GuildScheduleInfo.a().K(gProScheduleInfo.getScheduleId()).R(gProScheduleInfo.getTitle()).Q(gProScheduleInfo.getStartTimeMs()).E(gProScheduleInfo.getEndTimeMs()).A(gProScheduleInfo.getContent()).J(gProScheduleInfo.getReminderTimeType()).z(h06).H(gProScheduleInfo.getOtherJumpAddress()).F(gProScheduleInfo.getInviteStatus()).B(gProScheduleInfo.getCreateTimeMs()).C(r06).w(gProScheduleInfo.getAcceptedNums()).I(gProScheduleInfo.getRejectedNums()).x(s0(gProScheduleInfo.getAcceptedUser())).G(gProScheduleInfo.getIsNotified());
        if (gProScheduleGuildSurface != null) {
            G.N(gProScheduleGuildSurface.getGuildName());
            G.M(gProScheduleGuildSurface.getCoverUrl());
            G.O(gProScheduleGuildSurface.getIconUrl());
            G.P(gProScheduleGuildSurface.getFontColor());
            G.L(gProScheduleGuildSurface.getChannelName());
        }
        return G.y();
    }

    public static ArrayList<GProBindRoleGroups> o(Collection<x> collection) {
        ArrayList<GProBindRoleGroups> arrayList = new ArrayList<>();
        if (collection != null) {
            for (x xVar : collection) {
                arrayList.add(new GProBindRoleGroups(xVar.a(), xVar.b()));
            }
        }
        return arrayList;
    }

    public static ArrayList<GuildScheduleInfo> o0(ArrayList<GProScheduleInfo> arrayList) {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        ArrayList<GuildScheduleInfo> arrayList2 = new ArrayList<>();
        Iterator<GProScheduleInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(m0(it.next()));
        }
        return arrayList2;
    }

    public static HashMap<String, GProChannelInfo> p(HashMap<Long, GProChannel> hashMap) {
        HashMap<String, GProChannelInfo> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            Iterator<T> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                hashMap2.put(X0(((Long) entry.getKey()).longValue()), new GProChannelInfo((GProChannel) entry.getValue()));
            }
        }
        return hashMap2;
    }

    public static ct p0(GProScheduleListItem gProScheduleListItem) {
        if (gProScheduleListItem == null) {
            return new ct();
        }
        return new ct.a().e(m0(gProScheduleListItem.getSchedule())).f(gProScheduleListItem.getSeq()).g(gProScheduleListItem.getTotalDays()).d();
    }

    @NonNull
    public static GProDirectMsgCreateInfo q(@NonNull com.tencent.mobileqq.qqguildsdk.data.i iVar) {
        String str;
        String str2;
        String str3;
        long O0 = O0(iVar.f266703a);
        long O02 = O0(iVar.f266704b);
        String str4 = iVar.f266705c;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        String str5 = iVar.f266706d;
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        String str6 = iVar.f266707e;
        if (str6 == null) {
            str3 = "";
        } else {
            str3 = str6;
        }
        return new GProDirectMsgCreateInfo(O0, O02, str, str2, str3, iVar.f266708f, iVar.f266709g, iVar.f266710h);
    }

    public static ArrayList<ct> q0(ArrayList<GProScheduleListItem> arrayList) {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        ArrayList<ct> arrayList2 = new ArrayList<>();
        Iterator<GProScheduleListItem> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(p0(it.next()));
        }
        return arrayList2;
    }

    @NonNull
    public static GProDirectMsgReport r(@NonNull com.tencent.mobileqq.qqguildsdk.data.j jVar) {
        return new GProDirectMsgReport(O0(jVar.f266711a), jVar.f266712b, jVar.f266713c, jVar.f266714d, jVar.f266715e, jVar.f266716f);
    }

    private static GuildScheduleUser r0(GProScheduleUser gProScheduleUser) {
        if (gProScheduleUser == null) {
            return new GuildScheduleUser();
        }
        return new GuildScheduleUser.a().g(gProScheduleUser.getNick()).i(gProScheduleUser.getTinyId()).e(gProScheduleUser.getAvatar()).h(gProScheduleUser.getRole()).f();
    }

    public static ArrayList<GProGetUnbindClientInfo> s(ArrayList<GProGetUnbindClientInfo> arrayList) {
        ArrayList<GProGetUnbindClientInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<GProGetUnbindClientInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                GProGetUnbindClientInfo next = it.next();
                if (next != null) {
                    arrayList2.add(next);
                }
            }
        }
        return arrayList2;
    }

    public static ArrayList<GuildScheduleUser> s0(ArrayList<GProScheduleUser> arrayList) {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        ArrayList<GuildScheduleUser> arrayList2 = new ArrayList<>();
        Iterator<GProScheduleUser> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(r0(it.next()));
        }
        return arrayList2;
    }

    public static ArrayList<GProGuildInfo> t(List<GProGuild> list) {
        ArrayList<GProGuildInfo> arrayList = new ArrayList<>();
        if (list != null) {
            Iterator<GProGuild> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new GProGuildInfo(it.next()));
            }
        }
        return arrayList;
    }

    public static fc t0(GProGuildSpeakableThreshold gProGuildSpeakableThreshold) {
        return new cv.a().m(gProGuildSpeakableThreshold.getGuildNeedRealName()).k(gProGuildSpeakableThreshold.getGuildNeedJoinRole()).l(gProGuildSpeakableThreshold.getGuildNeedJoinTime()).j(gProGuildSpeakableThreshold.getPrivateNeedRealName()).h(gProGuildSpeakableThreshold.getPrivateNeedJoinRole()).i(gProGuildSpeakableThreshold.getPrivateNeedJoinTime()).g();
    }

    public static GProGuildRoleInfo u(GProGuildRole gProGuildRole) {
        if (gProGuildRole == null) {
            return new GProGuildRoleInfo(new GProGuildRole(0L, 0L, "", 0L, false, 0, false, 0, 0, new ArrayList(), new ArrayList(), 0, 0, ad.b(new GProRolePermission()), false, "", "", 0, "", 0L, 0L, 0L, "", 0L, 0L, 0, 0L, "", new ArrayList()));
        }
        return new GProGuildRoleInfo(gProGuildRole);
    }

    public static fc u0(GProSpeakThreshold gProSpeakThreshold, GProDirectMsgThreshold gProDirectMsgThreshold) {
        boolean z16;
        boolean z17;
        boolean z18;
        cv.a aVar = new cv.a();
        boolean z19 = true;
        if (gProSpeakThreshold.getNeedRealName() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        cv.a m3 = aVar.m(z16);
        if (gProSpeakThreshold.getNeedHasJoinRole() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        cv.a l3 = m3.k(z17).l(gProSpeakThreshold.getNeedJoinTime());
        if (gProDirectMsgThreshold.getNeedRealName() != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        cv.a j3 = l3.j(z18);
        if (gProDirectMsgThreshold.getNeedHasJoinRole() == 0) {
            z19 = false;
        }
        return j3.h(z19).i(gProDirectMsgThreshold.getNeedJoinTime()).g();
    }

    public static List<GProGuildRoleInfo> v(List<GProGuildRole> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<GProGuildRole> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(u(it.next()));
            }
        }
        return arrayList;
    }

    public static ArrayList<fc> v0(ArrayList<GProGuildSpeakableThreshold> arrayList) {
        ArrayList<fc> arrayList2 = new ArrayList<>();
        Iterator<GProGuildSpeakableThreshold> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(t0(it.next()));
        }
        return arrayList2;
    }

    public static ArrayList<GProMedalInfo> w(Collection<GGProMedalInfo> collection) {
        ArrayList<GProMedalInfo> arrayList = new ArrayList<>();
        if (collection == null) {
            return arrayList;
        }
        for (GGProMedalInfo gGProMedalInfo : collection) {
            arrayList.add(new GProMedalInfo(gGProMedalInfo.getIconUrl(), gGProMedalInfo.getName(), gGProMedalInfo.getExpireTime(), new GProOfficialMedalInfoExt(gGProMedalInfo.getOfficialMedalInfoExt().getIsOffical(), gGProMedalInfo.getOfficialMedalInfoExt().getIconUrl())));
        }
        return arrayList;
    }

    public static List<da> w0(ArrayList<GProClientInfo> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator<GProClientInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new com.tencent.mobileqq.qqguildsdk.data.h(it.next()));
            }
        }
        return arrayList2;
    }

    public static ArrayList<eu> x(ArrayList<GProMedal> arrayList) {
        ArrayList<eu> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<GProMedal> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new ce(it.next()));
            }
        }
        return arrayList2;
    }

    public static ArrayList<GProChannelMsgNotify> x0(List<com.tencent.mobileqq.qqguildsdk.data.f> list) {
        ArrayList<GProChannelMsgNotify> arrayList = new ArrayList<>();
        if (list != null) {
            for (com.tencent.mobileqq.qqguildsdk.data.f fVar : list) {
                arrayList.add(new GProChannelMsgNotify(O0(fVar.a()), fVar.b()));
            }
        }
        return arrayList;
    }

    public static GProMsgRouttingHead y(fi fiVar) {
        return new GProMsgRouttingHead(O0(fiVar.f()), O0(fiVar.a()), O0(fiVar.d()), O0(fiVar.c()), O0(fiVar.e()), fiVar.b());
    }

    public static ArrayList<di> y0(ArrayList<GProClientAccount> arrayList) {
        ArrayList<di> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<GProClientAccount> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new y(it.next()));
            }
        }
        return arrayList2;
    }

    public static GProMsgSearchCond z(@Nullable bc bcVar) {
        if (bcVar == null) {
            return new GProMsgSearchCond(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), V(null));
        }
        return new GProMsgSearchCond(bcVar.a(), bcVar.b(), C(bcVar.d()), new ArrayList(), V(bcVar.c()));
    }

    public static ArrayList<com.tencent.mobileqq.qqguildsdk.data.dj> z0(ArrayList<GProClientArchive> arrayList) {
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.dj> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<GProClientArchive> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new z(it.next()));
            }
        }
        return arrayList2;
    }
}
