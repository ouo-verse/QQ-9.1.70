package com.tencent.mobileqq.qqguildsdk.api.impl;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.Cdo;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildSpeakRuleData;
import com.tencent.mobileqq.qqguildsdk.data.GProLocationInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.GuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.dt;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.eo;
import com.tencent.mobileqq.qqguildsdk.data.ez;
import com.tencent.mobileqq.qqguildsdk.data.fc;
import com.tencent.mobileqq.qqguildsdk.data.fi;
import com.tencent.mobileqq.qqguildsdk.data.fj;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qqguildsdk.data.fm;
import com.tencent.mobileqq.qqguildsdk.data.fn;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProCmd0x1258ExtendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceSpeakModeRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVMemberGroupListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEssenceSvrRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.ey;
import com.tencent.mobileqq.qqguildsdk.data.genc.fh;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryChannelIdList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0x1258ExtendRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFaceAuthInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildAndChannelReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInit;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSpeakModeRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelListForJumpCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuestGuildInfoWithChannelListCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import wh2.dv;
import wh2.el;
import wh2.em;

/* loaded from: classes17.dex */
public class GPSServiceImpl extends cb implements IGPSService {

    /* loaded from: classes17.dex */
    class a implements IGProFetchChannelListForJumpCallback {
        a(vh2.az azVar) {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelListForJumpCallback
        public void onFetchChannelListForJump(int i3, String str, GProGuildInit gProGuildInit) {
            com.tencent.mobileqq.qqguildsdk.util.g.d(com.tencent.mobileqq.qqguildsdk.util.g.i(com.tencent.mobileqq.qqguildsdk.util.g.d0(gProGuildInit)));
            throw null;
        }
    }

    /* loaded from: classes17.dex */
    class b implements wh2.bc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ vh2.at f265071a;

        b(vh2.at atVar) {
            this.f265071a = atVar;
        }

        @Override // wh2.bc
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult, String str2, String str3, long j3, IGProQRCodeShareInfo iGProQRCodeShareInfo, IGProShareExtendInfo iGProShareExtendInfo, String str4) {
            this.f265071a.a(i3, str, str2, str3, iGProSecurityResult, j3, iGProQRCodeShareInfo, iGProShareExtendInfo, str4);
        }
    }

    /* loaded from: classes17.dex */
    class c implements Cdo {
        c() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.Cdo
        public int a() {
            return 0;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.Cdo
        public String getVerifyUrl() {
            return "";
        }
    }

    /* loaded from: classes17.dex */
    class d implements Cdo {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProFaceAuthInfo f265074a;

        d(GProFaceAuthInfo gProFaceAuthInfo) {
            this.f265074a = gProFaceAuthInfo;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.Cdo
        public int a() {
            GProFaceAuthInfo gProFaceAuthInfo = this.f265074a;
            if (gProFaceAuthInfo == null) {
                return 0;
            }
            return gProFaceAuthInfo.getFaceAuthStatus();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.Cdo
        public String getVerifyUrl() {
            GProFaceAuthInfo gProFaceAuthInfo = this.f265074a;
            if (gProFaceAuthInfo == null) {
                return "";
            }
            return gProFaceAuthInfo.getVerifyUrl();
        }
    }

    /* loaded from: classes17.dex */
    class e implements vh2.v {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ vh2.s f265076a;

        e(vh2.s sVar) {
            this.f265076a = sVar;
        }

        @Override // vh2.v
        public void a(int i3, String str, @Nullable IGProGuildInfo iGProGuildInfo) {
            List<com.tencent.mobileqq.qqguildsdk.data.cy> arrayList;
            if (iGProGuildInfo != null) {
                arrayList = GPSServiceImpl.this.mEngine.bl(iGProGuildInfo.getGuildID());
            } else {
                arrayList = new ArrayList<>();
            }
            this.f265076a.a(i3, str, iGProGuildInfo, arrayList);
        }
    }

    /* loaded from: classes17.dex */
    class f implements eo {
        f() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.eo
        public boolean a() {
            return true;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.eo
        public ArrayList<String> b() {
            return new ArrayList<>();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.eo
        public boolean c() {
            return true;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.eo
        public boolean d() {
            return true;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.eo
        public boolean e() {
            return true;
        }
    }

    private List<com.tencent.mobileqq.qqguildsdk.data.cy> convertCategoryListModel(String str, ArrayList<GProCategoryChannelIdList> arrayList, GProCategoryChannelIdList gProCategoryChannelIdList, HashMap<Long, GProChannel> hashMap) {
        if (str.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList2 = new ArrayList();
        com.tencent.mobileqq.qqguildsdk.data.c cVar = new com.tencent.mobileqq.qqguildsdk.data.c(gProCategoryChannelIdList.getName(), gProCategoryChannelIdList.getCategoryId());
        cVar.c(gProCategoryChannelIdList.getCategoryType());
        Iterator<Long> it = gProCategoryChannelIdList.getChannelList().iterator();
        while (it.hasNext()) {
            GProChannel gProChannel = hashMap.get(it.next());
            if (gProChannel != null) {
                cVar.a(new GProChannelInfo(gProChannel));
            }
        }
        arrayList2.add(cVar);
        Iterator<GProCategoryChannelIdList> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            GProCategoryChannelIdList next = it5.next();
            com.tencent.mobileqq.qqguildsdk.data.c cVar2 = new com.tencent.mobileqq.qqguildsdk.data.c(next.getName(), next.getCategoryId());
            cVar2.c(next.getCategoryType());
            Iterator<Long> it6 = next.getChannelList().iterator();
            while (it6.hasNext()) {
                GProChannel gProChannel2 = hashMap.get(it6.next());
                if (gProChannel2 != null) {
                    cVar2.a(new GProChannelInfo(gProChannel2));
                }
            }
            arrayList2.add(cVar2);
        }
        return arrayList2;
    }

    private IGProSecurityResult getEmptyIGProSecurityResult() {
        return new IGProSecurityResult() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GPSServiceImpl.6
            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
            /* renamed from: getActionCode */
            public long get$actionCode() {
                return Long.MIN_VALUE;
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
            public String getStrDetail() {
                return "";
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
            public String getStrPrompt() {
                return "";
            }
        };
    }

    private boolean isMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$enterAudioLiveChannelAndCallbackDirect$2(wh2.x xVar, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProEnterAudioLiveChannelRsp iGProEnterAudioLiveChannelRsp) {
        if (xVar != null) {
            xVar.a(i3, str, iGProSecurityResult, iGProEnterAudioLiveChannelRsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchAudioLiveChannelGroupListAndCallbackDirect$3(wh2.ac acVar, int i3, String str, IGProAVMemberGroupListRsp iGProAVMemberGroupListRsp) {
        if (acVar != null) {
            acVar.a(i3, str, iGProAVMemberGroupListRsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchGuestGuildWithChannelListAndJoinSig$0(vh2.t tVar, int i3, int i16, String str, String str2, GProGuild gProGuild, GProGuildInit gProGuildInit, int i17, GProCmd0x1258ExtendRsp gProCmd0x1258ExtendRsp) {
        if (gProGuild == null) {
            tVar.a(-92, "\u51fa\u9519\u4e86\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002", "", null, null, 0, null);
            return;
        }
        String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(gProGuild.getGuildId());
        tVar.a(i16, str, str2, new GProGuildInfo(gProGuild), convertCategoryListModel(X0, gProGuildInit.getCategoryList(), gProGuildInit.getUncategorizedChannels(), gProGuildInit.getChannelMap()), i17, new GGProCmd0x1258ExtendRsp(gProCmd0x1258ExtendRsp));
        if (i3 == 1000) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchGuestGuildWithChannelListAndJoinSig", "guildId\uff1a" + X0 + " sourceType == VISITOR_PEAK_FETCH return");
            return;
        }
        this.mEngine.pf(X0, 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getChannelHeartbeat$1(vh2.aw awVar, int i3, com.tencent.mobileqq.qqguildsdk.data.genc.cv cvVar) {
        if (awVar != null) {
            awVar.a(i3, cvVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void addChannelSubscribeBubbleShow(String str, String str2) {
        if (isRun()) {
            this.mEngine.Xk(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void addGuild(String str, GuildSourceId guildSourceId, String str2, vh2.bv bvVar) {
        if (bvVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                bvVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null, null);
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "addGuild", "guildId : " + str);
                return;
            }
            this.mEngine.hd(str, guildSourceId, str2, bvVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void addGuildStateListener(@NonNull vh2.bt btVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Qk(btVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void addGuildWithOption(com.tencent.mobileqq.qqguildsdk.data.az azVar, vh2.bv bvVar) {
        if (bvVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(azVar.c())) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "addGuildWithOption", "guildId : " + azVar.c());
                bvVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null, null);
                return;
            }
            this.mEngine.id(azVar, bvVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void addObserver(GPServiceObserver gPServiceObserver) {
        if (isRun() && gPServiceObserver != null) {
            this.mGProGlobalService.addObserver(gPServiceObserver);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void addUserToGuildBlackList(String str, List<String> list, @Nullable fm fmVar, vh2.cd cdVar) {
        if (cdVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.j(list)) {
                cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "kickGuildUsers", "guildId : " + str);
                return;
            }
            if (fmVar == null) {
                fmVar = new fm.a().c(0).b();
            }
            this.mEngine.fg(str, list, true, fmVar, cdVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void appAuthorization(String str, vh2.a aVar) {
        if (aVar != null && isRun()) {
            this.mEngine.jd(str, aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void authScreenShared(String str, String str2, vh2.co coVar) {
        if (coVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.kd(str, str2, coVar);
            } else {
                coVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void batchSetBoolField(String str, HashMap<Integer, Boolean> hashMap, @NonNull vh2.cc ccVar) {
        if (!isRun()) {
            return;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "batchSetBoolField", "guildId:" + str);
            ccVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
            return;
        }
        this.mEngine.ld(str, hashMap, ccVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void batchSetIntField(String str, HashMap<Integer, Integer> hashMap, @NonNull vh2.cc ccVar) {
        if (!isRun()) {
            return;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "batchSetIntField", "guildId:" + str);
            ccVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
            return;
        }
        this.mEngine.md(str, hashMap, ccVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void batchUpdateChannelsMsgNotifyType(String str, List<com.tencent.mobileqq.qqguildsdk.data.f> list, vh2.c cVar) {
        if (cVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                cVar.a(-90, null, str, null);
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "batchUpdateChannelsMsgNotifyType", " guildId \uff1a " + str + " channelMsgNotifyList \uff1a " + list);
                return;
            }
            this.mEngine.nd(str, list, cVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void bindAppRole(String str, String str2, int i3, vh2.d dVar) {
        if (dVar != null && isRun()) {
            this.mEngine.od(str, str2, i3, dVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void cancelChannelTopMsg(String str, String str2, ArrayList<Long> arrayList, @NonNull vh2.cc ccVar) {
        if (!isRun()) {
            return;
        }
        IGProChannelInfo channelInfo = getChannelInfo(str2);
        if (channelInfo == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "cancelChannelTopMsg", "guildId: " + str + ", channelId: " + str2);
            ccVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
            return;
        }
        this.mEngine.vl().e(channelInfo, arrayList, ccVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void changeChannelCategoryName(String str, long j3, String str2, vh2.bg bgVar) {
        if (bgVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.d(str, j3, str2)) {
                bgVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            } else {
                this.mEngine.dm(str, j3, str2, bgVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void checkUserBannedSpeakInChannel(String str, String str2, String str3, vh2.f fVar) {
        if (fVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2) && !com.tencent.mobileqq.qqguildsdk.util.j.k(str3)) {
                this.mEngine.rd(str, str2, str3, fVar);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "checkUserBannedSpeakInChannel", "guildId\uff1a" + str + " channelId:" + str2 + " tinyId:" + str3);
            fVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", 0);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void closeChannelTopMsg(String str, String str2, @NonNull vh2.cc ccVar) {
        if (!isRun()) {
            return;
        }
        IGProChannelInfo channelInfo = getChannelInfo(str2);
        if (channelInfo == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "closeChannelTopMsg", "guildId: " + str + ", channelId: " + str2);
            ccVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
            return;
        }
        this.mEngine.vl().f(channelInfo, ccVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public GProNotice convert2GProNotice(@NonNull com.tencent.mobileqq.qqguildsdk.data.co coVar) {
        return com.tencent.mobileqq.qqguildsdk.util.g.E(coVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public com.tencent.mobileqq.qqguildsdk.data.genc.dj convert2GWGProNotice(@NonNull com.tencent.mobileqq.qqguildsdk.data.co coVar) {
        return com.tencent.mobileqq.qqguildsdk.util.g.a0(coVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public GuildScheduleInfo convert2GuildScheduleInfo(GProScheduleInfo gProScheduleInfo) {
        return com.tencent.mobileqq.qqguildsdk.util.g.m0(gProScheduleInfo);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public IGProGuildInfo convertToGuildInfo(IGProCmd0xf5aGuildInfo iGProCmd0xf5aGuildInfo, int i3, IGProCmd0xf5aUserInfo iGProCmd0xf5aUserInfo) {
        if (!isRun()) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("[gpro_sdk]", 1, "kernelGuildService is no run");
            return null;
        }
        return this.mEngine.Rk(iGProCmd0xf5aGuildInfo, i3, iGProCmd0xf5aUserInfo);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public ez convertToGuildInviteInfo(IGProCmd0xf5aGuildInfo iGProCmd0xf5aGuildInfo) {
        if (!isRun()) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("[gpro_sdk]", 1, "kernelGuildService is no run");
            return null;
        }
        return this.mEngine.Sk(iGProCmd0xf5aGuildInfo);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void createChannel(String str, com.tencent.mobileqq.qqguildsdk.data.d dVar, long j3, int i3, com.tencent.mobileqq.qqguildsdk.data.b bVar, vh2.g gVar) {
        if (gVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && dVar != null && !TextUtils.isEmpty(dVar.m())) {
                this.mEngine.em(str, dVar, j3, i3, bVar, gVar);
                return;
            }
            gVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null, null);
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "createChannelWithId", "guildId : " + str);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void createChannelCategory(String str, String str2, vh2.bg bgVar) {
        if (bgVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.e(str, str2)) {
                bgVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            } else {
                this.mEngine.fm(str, str2, bgVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void createDirectMsgSession(@NonNull com.tencent.mobileqq.qqguildsdk.data.i iVar, @NonNull vh2.h hVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.vd(iVar, hVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void createLinkChannel(String str, com.tencent.mobileqq.qqguildsdk.data.d dVar, long j3, vh2.bd bdVar) {
        if (bdVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && dVar != null && !TextUtils.isEmpty(dVar.m())) {
                this.mEngine.gm(str, dVar, j3, bdVar);
                return;
            }
            bdVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "createChannelWithId", "guildId : " + str);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void createRole(String str, @NonNull fn fnVar, @NonNull List<String> list, @NonNull vh2.i iVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !TextUtils.isEmpty(fnVar.c())) {
            this.mEngine.hm(str, fnVar, list, iVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "createRole", "guildId: " + str + ", createInfo: " + fnVar.toString());
        iVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null, null);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void createSchedule(String str, String str2, GuildScheduleInfo guildScheduleInfo, vh2.ce ceVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.al().b(str, str2, guildScheduleInfo, ceVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "createSchedule", "guildId: " + str + ", channelId:" + str2);
        ceVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new GuildScheduleInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void createScheduleLimitQuery(String str, vh2.cf cfVar) {
        if (!isRun()) {
            return;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "createScheduleLimitQuery", "guildId: " + str);
            cfVar.onCreateScheduleLimitQuery(-90, "\u4f20\u53c2\u6570\u9519\u8bef", 0);
            return;
        }
        this.mEngine.al().c(str, cfVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void dealNotice(String str, String str2, vh2.j jVar) {
        if (isRun()) {
            this.mEngine.Bd(str, str2, jVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public GuildScheduleInfo decodeGuildScheduleInfo(byte[] bArr) {
        if (!isRun()) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("[gpro_sdk]", 1, "kernelGuildService is no run");
            return null;
        }
        GProScheduleInfo Wk = this.mEngine.Wk(bArr);
        if (Wk == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("[gpro_sdk]", 1, "decodeScheduleInfo is null");
            return null;
        }
        return com.tencent.mobileqq.qqguildsdk.util.g.m0(Wk);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void deleteObserver(GPServiceObserver gPServiceObserver) {
        if (isRun() && gPServiceObserver != null) {
            this.mGProGlobalService.deleteObserver(gPServiceObserver);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void deleteRole(String str, String str2, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.Cd(str, str2, cdVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "deleteRole", "guildId: " + str + ", roleId: " + str2);
        cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void editSchedule(String str, String str2, GuildScheduleInfo guildScheduleInfo, int i3, vh2.cg cgVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.al().d(str, str2, guildScheduleInfo, i3, cgVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "editSchedule", "guildId: " + str + ", channelId:" + str2);
        cgVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new GuildScheduleInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void enterAudioLiveChannelAndCallbackDirect(com.tencent.mobileqq.qqguildsdk.data.genc.ai aiVar, final wh2.x xVar) {
        if (isRun()) {
            this.mEngine.Ed(aiVar, new wh2.x() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ca
                @Override // wh2.x
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProEnterAudioLiveChannelRsp iGProEnterAudioLiveChannelRsp) {
                    GPSServiceImpl.lambda$enterAudioLiveChannelAndCallbackDirect$2(wh2.x.this, i3, str, iGProSecurityResult, iGProEnterAudioLiveChannelRsp);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchArchiveArkData(String str, String str2, byte[] bArr, int i3, vh2.l lVar) {
        if (!isRun() || TextUtils.isEmpty(str)) {
            return;
        }
        this.mEngine.Fd(str, str2, bArr, i3, lVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchAudioLiveChannelGroupListAndCallbackDirect(com.tencent.mobileqq.qqguildsdk.data.genc.m mVar, final wh2.ac acVar) {
        if (isRun()) {
            this.mEngine.Gd(mVar, new wh2.ac() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bx
                @Override // wh2.ac
                public final void a(int i3, String str, IGProAVMemberGroupListRsp iGProAVMemberGroupListRsp) {
                    GPSServiceImpl.lambda$fetchAudioLiveChannelGroupListAndCallbackDirect$3(wh2.ac.this, i3, str, iGProAVMemberGroupListRsp);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchCategoryAdminMemberList(String str, String str2, String str3, int i3, boolean z16, @NonNull vh2.ar arVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str3)) {
            this.mEngine.pm(str, "0", str2, str3, i3, z16, arVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchChannelAdminMemberList", "guildId: " + str + ", categoryId: " + str2 + ", roleId: " + str3 + ", count: " + i3 + ", isForce: " + z16);
        arVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", 0, false, Collections.emptyList());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchChannelAdminInfoList(String str, @NonNull vh2.e eVar) {
        fetchChannelAdminInfoList(str, "0", eVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchChannelAdminMemberList(String str, String str2, String str3, int i3, boolean z16, @NonNull vh2.ar arVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str3)) {
            this.mEngine.pm(str, str2, "0", str3, i3, z16, arVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchChannelAdminMemberList", "guildId: " + str + ", channelId: " + str2 + ", roleId: " + str3 + ", count: " + i3 + ", isForce: " + z16);
        arVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", 0, false, Collections.emptyList());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchChannelInfoWithCategory(String str, String str2, int i3, vh2.n nVar) {
        if (isRun()) {
            this.mEngine.Id(str, str2, i3, nVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchChannelList(String str, vh2.o oVar) {
        if (isRun()) {
            this.mEngine.Ld(str, oVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchChannelListForJump(long j3, vh2.az azVar) {
        if (isRun()) {
            this.mEngine.Md(j3, new a(azVar));
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchChannelLiveableMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.f fVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Od(str, str2, i3, bArr, fVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.d
    public void fetchChannelLiveableRoleList(String str, String str2, @NonNull xh2.g gVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Pd(str, str2, gVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchChannelUnlivableMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.j jVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Sd(str, str2, i3, bArr, jVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchChannelUnlivableRoleList(String str, String str2, @NonNull xh2.k kVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Td(str, str2, kVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchChannelUserPermission(String str, String str2, int i3, @NonNull xh2.n nVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Wd(str, str2, i3, nVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchComments(String str, String str2, long j3, long j16, long j17, long j18, vh2.p pVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.ae(str, str2, j3, j16, j17, j18, pVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchDirectMsgBlack(String str, @NonNull vh2.q qVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.be(str, qVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchDirectMsgStatus(@NonNull vh2.r rVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.ce(rVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchFeedsNotifySwitch(vh2.k kVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.de(kVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchGuestGuild(String str, boolean z16, vh2.s sVar) {
        int i3;
        if (sVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchGuestGuild", "guildId\uff1a" + str);
                sVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null, null);
                return;
            }
            if (z16) {
                i3 = 19;
            } else {
                i3 = 2;
            }
            this.mEngine.Zk(str, true, i3, new e(sVar));
            this.mEngine.pf(str, 7);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchGuestGuildWithChannelListAndJoinSig(final int i3, GProGetGuildAndChannelReq gProGetGuildAndChannelReq, final vh2.t tVar) {
        this.mEngine.im(i3, gProGetGuildAndChannelReq, new IGProFetchGuestGuildInfoWithChannelListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bw
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuestGuildInfoWithChannelListCallback
            public final void onFetchGuestGuildInfoWithChannelList(int i16, String str, String str2, GProGuild gProGuild, GProGuildInit gProGuildInit, int i17, GProCmd0x1258ExtendRsp gProCmd0x1258ExtendRsp) {
                GPSServiceImpl.this.lambda$fetchGuestGuildWithChannelListAndJoinSig$0(tVar, i3, i16, str, str2, gProGuild, gProGuildInit, i17, gProCmd0x1258ExtendRsp);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchGuildInfoByAppIdentity(com.tencent.mobileqq.qqguildsdk.data.cj cjVar, String str, String str2, vh2.u uVar) {
        if (uVar != null && isRun()) {
            if (!cjVar.d()) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchGuildInfoByAppIdentity", "identity need both appid and orgID");
                uVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null, null);
            } else {
                this.mEngine.ee(cjVar, str, str2, uVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchGuildInfoByInviteCode(String str, vh2.aa aaVar) {
        if (aaVar != null && isRun()) {
            if (TextUtils.isEmpty(str)) {
                aaVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null, null, 0L);
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchGuildInfoByInviteCode", "inviteCode: " + str);
                return;
            }
            this.mEngine.fe(str, aaVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchGuildInfoByInviteCodeAndContentID(String str, String str2, String str3, int i3, vh2.z zVar) {
        if (zVar != null && isRun()) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3)) {
                zVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null, null, null, null);
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchGuildInfoByInviteCodeAndContentID", "inviteCode: " + str + ", contentID: " + str2 + " shortUrl:" + str3 + " markType:" + i3);
                return;
            }
            this.mEngine.ge(str, str2, str3, i3, zVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchGuildInfoOnly(String str, int i3, vh2.v vVar) {
        if (isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchGuildInfoWithSource", "guildId : " + str);
                return;
            }
            this.mEngine.Yk(str, true, i3, vVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchGuildInfoWithSource(String str, int i3, vh2.v vVar) {
        if (isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchGuildInfoWithSource", "guildId : " + str);
                return;
            }
            this.mEngine.Zk(str, true, i3, vVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchGuildSearchSwitch(String str, @NonNull vh2.w wVar) {
        if (!isRun()) {
            return;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchGuildSearchSwitch", "guildId:" + str);
            wVar.onFetchGuildSearchSwitch(-90, "\u4f20\u53c2\u6570\u9519\u8bef", 0, "");
            return;
        }
        this.mEngine.he(str, wVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchGuildSpeakableMemberList(String str, boolean z16, byte[] bArr, @NonNull xh2.p pVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.ie(str, z16, bArr, pVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void fetchGuildSpeakableRoleList(String str, boolean z16, @NonNull xh2.q qVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.je(str, z16, qVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchGuildSpeakableRule(String str, vh2.au auVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.ke(str, auVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchGuildSpeakableThreshold(String str, vh2.x xVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.le(str, xVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchIsLiveChannelOpen(String str, vh2.ab abVar) {
        if (abVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchIsLiveChannelOpen", "guildId\uff1a" + str);
                abVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", 0);
                return;
            }
            this.mEngine.me(str, abVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchIsVoiceChannelOpen(String str, vh2.ac acVar) {
        if (acVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchIsVoiceChannelOpen", "guildId\uff1a" + str);
                acVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", 0);
                return;
            }
            this.mEngine.ne(str, acVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchLatestComments(String str, String str2, long j3, long j16, vh2.p pVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.oe(str, str2, j3, j16, pVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchLiveChannelAnchorList(String str, String str2, vh2.ad adVar) {
        if (adVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.pe(str, str2, adVar);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchLiveChannelAnchorList", "guildId\uff1a" + str + ", channelId: " + str2);
            adVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new ArrayList());
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchLiveChannelBannedUserList(String str, String str2, String str3, vh2.ae aeVar) {
        if (aeVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str3)) {
                this.mEngine.qe(str, str2, str3, aeVar);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchLiveChannelBannedUserList", "guildId\uff1a" + str + " channelId:" + str2 + " roomId:" + str3);
            aeVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new ArrayList());
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchLiveRoomInfo(com.tencent.mobileqq.qqguildsdk.data.ag agVar, vh2.af afVar) {
        if (!agVar.e()) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchLiveRoomInfo", "invalid params: " + agVar.toString());
            afVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new ArrayList(), new ArrayList(), 0);
            return;
        }
        this.mEngine.re(agVar, afVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchLiveSecurityTips(vh2.ag agVar) {
        if (agVar != null && isRun()) {
            this.mEngine.se(agVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchMVPFeedsFromServerWithNonUiThreadCallback(com.tencent.mobileqq.qqguildsdk.data.genc.bj bjVar, wh2.au auVar) {
        if (isRun()) {
            this.mEngine.te(bjVar, auVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void fetchMemberListWithRole(String str, String str2, int i3, boolean z16, @NonNull vh2.ai aiVar) {
        if (!isRun()) {
            return;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchMemberListWithRole", "guildId: " + str + ", channelId: " + str2 + ", count: " + i3 + ", isForce: " + z16);
            aiVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", false, 0, Collections.emptyList());
            return;
        }
        this.mEngine.jm(str, str2, i3, z16, aiVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void fetchMemberRoleList(String str, String str2, String str3, int i3, @NonNull vh2.ak akVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.k(str3)) {
            this.mEngine.km(str, str2, str3, i3, akVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchMemberRoleList", "guildId: " + str + ", tinyId: " + str3);
        akVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchNewestNotice(int i3, String str, @NonNull vh2.al alVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.we(i3, str, alVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchNonRoleMemberList(String str, String str2, String str3, String str4, int i3, boolean z16, @NonNull vh2.am amVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str4)) {
            this.mEngine.lm(str, str2, str3, str4, i3, z16, amVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchNonRoleMemberList", "guildId: " + str + ", channelId: " + str2 + ", roleId: " + str4 + ", count: " + i3 + ", isForce: " + z16);
        amVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", false, Collections.emptyList());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchRecommendChannel(int i3, int i16, vh2.ao aoVar) {
        if (aoVar != null && isRun()) {
            this.mEngine.ye(i3, i16, aoVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchRemainAtSetInfo(String str, vh2.m mVar) {
        if (mVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                mVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchRemainAtSetInfo", "guildId : " + str);
                return;
            }
            this.mEngine.ze(str, mVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchRole(String str, String str2, boolean z16, int i3, @NonNull vh2.ap apVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.mm(str, str2, z16, i3, apVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchRole", "guildId: " + str + ", roleId: " + str2);
        apVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchRoleList(String str, int i3, @NonNull vh2.aq aqVar) {
        fetchRoleList(str, 0, i3, aqVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.d
    public void fetchRoleListWithPermission(String str, int i3, @NonNull xh2.a aVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.om(str, i3, aVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchRoleMemberList(String str, String str2, int i3, boolean z16, @NonNull vh2.ar arVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.pm(str, "0", "0", str2, i3, z16, arVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchRoleMemberList", "guildId: " + str + ", roleId: " + str2 + ", count: " + i3 + ", isForce: " + z16);
        arVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", 0, false, Collections.emptyList());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.d
    public void fetchRoleWithPermission(String str, String str2, int i3, @NonNull xh2.b bVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.qm(str, str2, i3, bVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchShareInfo(String str, String str2, int i3, byte[] bArr, boolean z16, ArrayList<ey> arrayList, com.tencent.mobileqq.qqguildsdk.data.genc.v vVar, vh2.at atVar) {
        ArrayList<ey> arrayList2;
        com.tencent.mobileqq.qqguildsdk.data.genc.v vVar2;
        if (atVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                atVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null, null, null, 0L, null, null, "");
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchShareInfo0x10c3", "guildId : " + str);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.data.genc.av avVar = new com.tencent.mobileqq.qqguildsdk.data.genc.av();
            avVar.h(i3);
            avVar.g(bArr);
            avVar.k(z16);
            if (arrayList == null) {
                arrayList2 = new ArrayList<>();
            } else {
                arrayList2 = arrayList;
            }
            avVar.l(arrayList2);
            if (vVar == null) {
                vVar2 = new com.tencent.mobileqq.qqguildsdk.data.genc.v();
            } else {
                vVar2 = vVar;
            }
            avVar.i(vVar2);
            this.mEngine.n2(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), avVar, new b(atVar));
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchUserInfo(String str, List<String> list, boolean z16, vh2.bq bqVar) {
        fetchUserInfo(str, "0", list, z16, true, bqVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchVisibleMemberListByTinyId(String str, String str2, @NonNull List<String> list, @NonNull vh2.av avVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            if (list.isEmpty()) {
                avVar.a(0, "", Collections.emptyList(), Collections.emptyList());
                return;
            } else {
                this.mEngine.Ge(str, str2, list, 102, avVar);
                return;
            }
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getChannelMemberList", "guildId: " + str + ", channelId: " + str2);
        avVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getActiveLiveAudioChannelNumV2(com.tencent.mobileqq.qqguildsdk.data.ai aiVar, vh2.ba baVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(aiVar.b()) && !aiVar.a().isEmpty()) {
            this.mEngine.Ie(aiVar, baVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "refreshPollingData", "guildId: " + aiVar.b() + ", categoryTypeSize: " + aiVar.a().size());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getAppAuthorizationInfo(String str, int i3, vh2.be beVar) {
        if (beVar != null && isRun()) {
            this.mEngine.Je(str, i3, beVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public IGProAppChnnPreInfo getAppChnnPreInfo(String str, String str2) {
        if (!isRun()) {
            return null;
        }
        return this.mEngine.Ke(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getAppRoleList(String str, String str2, byte[] bArr, vh2.bf bfVar) {
        if (bfVar != null && isRun()) {
            this.mEngine.Le(str, str2, bArr, bfVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getAssociativeWords(String str, vh2.b bVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Me(str, bVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public String getAvatarUrl(String str, long j3, int i3) {
        if (!isRun()) {
            return "";
        }
        return this.mEngine.Ne(str, j3, i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getBindClientService(int i3, String str, byte[] bArr, vh2.bi biVar) {
        if (biVar != null && isRun()) {
            this.mEngine.Oe(i3, str, bArr, biVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public HashMap<Long, ArrayList<Long>> getBoardPermission(String str) {
        if (!isRun()) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(7);
        ArrayList<Long> arrayList2 = new ArrayList<>();
        arrayList2.add(Long.valueOf(str));
        return this.mEngine.Ve(arrayList2, arrayList);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.d
    @NonNull
    public dx getCategoryPermission(String str, String str2) {
        if (!isRun()) {
            return dx.a.f266010a;
        }
        return this.mEngine.ql().a(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public List<com.tencent.mobileqq.qqguildsdk.data.cy> getChannelCategoryList(String str) {
        if (isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getChannelCategoryList", "guildId\uff1a" + str);
                return null;
            }
            return this.mEngine.bl(str);
        }
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getChannelHeartbeat(String str, String str2, final vh2.aw awVar) {
        if (isRun()) {
            this.mEngine.Te(str, str2, new vh2.aw() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bz
                @Override // vh2.aw
                public final void a(int i3, com.tencent.mobileqq.qqguildsdk.data.genc.cv cvVar) {
                    GPSServiceImpl.lambda$getChannelHeartbeat$1(vh2.aw.this, i3, cvVar);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public IGProChannelInfo getChannelInfo(String str) {
        if (isRun() && !com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            return this.mEngine.cl(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getChannelInvisibleMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.d dVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Jd(str, str2, i3, bArr, dVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getChannelInvisibleRoleList(String str, String str2, @NonNull xh2.e eVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Kd(str, str2, eVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @NonNull
    public List<IGProChannelInfo> getChannelList(String str) {
        if (isRun()) {
            return this.mEngine.dl(str);
        }
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public List<com.tencent.mobileqq.qqguildsdk.data.cy> getChannelListForSelector(String str, boolean z16) {
        List<com.tencent.mobileqq.qqguildsdk.data.cy> channelCategoryList = getChannelCategoryList(str);
        for (com.tencent.mobileqq.qqguildsdk.data.cy cyVar : channelCategoryList) {
            com.tencent.mobileqq.qqguildsdk.util.h.t("[gpro_sdk]", true, "getChannelListForSelector categoryInfo=" + cyVar);
            Iterator<IGProChannelInfo> it = cyVar.getChannelList().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.qqguildsdk.util.h.t("[gpro_sdk]", true, "getChannelListForSelector channelInfo=" + it.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        if (!z16) {
            for (com.tencent.mobileqq.qqguildsdk.data.cy cyVar2 : channelCategoryList) {
                ArrayList arrayList2 = new ArrayList();
                for (IGProChannelInfo iGProChannelInfo : cyVar2.getChannelList()) {
                    if (iGProChannelInfo.getVisibleType() == 1) {
                        arrayList2.add(iGProChannelInfo);
                    }
                }
                com.tencent.mobileqq.qqguildsdk.data.c cVar = new com.tencent.mobileqq.qqguildsdk.data.c(cyVar2.getCategoryName(), cyVar2.getCategoryId());
                cVar.c(cyVar2.getCategoryType());
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    cVar.a((GProChannelInfo) ((IGProChannelInfo) it5.next()));
                }
                arrayList.add(cVar);
            }
        } else {
            for (com.tencent.mobileqq.qqguildsdk.data.cy cyVar3 : channelCategoryList) {
                ArrayList arrayList3 = new ArrayList();
                for (IGProChannelInfo iGProChannelInfo2 : cyVar3.getChannelList()) {
                    if (iGProChannelInfo2.getVisibleType() == 1 && (iGProChannelInfo2.getType() == 1 || iGProChannelInfo2.getType() == 5 || iGProChannelInfo2.getType() == 7 || iGProChannelInfo2.getType() == 8 || iGProChannelInfo2.getType() == 2)) {
                        arrayList3.add(iGProChannelInfo2);
                    }
                }
                com.tencent.mobileqq.qqguildsdk.data.c cVar2 = new com.tencent.mobileqq.qqguildsdk.data.c(cyVar3.getCategoryName(), cyVar3.getCategoryId());
                cVar2.c(cyVar3.getCategoryType());
                Iterator it6 = arrayList3.iterator();
                while (it6.hasNext()) {
                    cVar2.a((GProChannelInfo) ((IGProChannelInfo) it6.next()));
                }
                arrayList.add(cVar2);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.d
    @NonNull
    public dx getChannelPermission(String str, String str2) {
        if (!isRun()) {
            return dx.a.f266010a;
        }
        return this.mEngine.ql().b(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getChannelSpeakableMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.h hVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Qd(str, str2, i3, bArr, hVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.d
    public void getChannelSpeakableRoleList(String str, String str2, @NonNull xh2.i iVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Rd(str, str2, iVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getChannelTopMsgState(String str, String str2, @NonNull vh2.bh bhVar) {
        if (!isRun()) {
            return;
        }
        IGProChannelInfo channelInfo = getChannelInfo(str2);
        if (channelInfo == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getChannelTopMsgState", "guildId: " + str + ", channelId: " + str2);
            bhVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef", true);
            return;
        }
        this.mEngine.vl().h(channelInfo, bhVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getChannelUnspeakableMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.l lVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Ud(str, str2, i3, bArr, lVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getChannelUnspeakableRoleList(String str, String str2, @NonNull xh2.m mVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Vd(str, str2, mVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public int getChannelUserPermission(@NonNull String str, @NonNull String str2) {
        if (!isRun()) {
            return 0;
        }
        return this.mEngine.Ze(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getChannelVisibleAllMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.o oVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Xd(str, str2, i3, bArr, oVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getChannelVisibleMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.o oVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Yd(str, str2, i3, bArr, oVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.d
    public void getChannelVisibleRoleList(String str, String str2, @NonNull wh2.aj ajVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Zd(str, str2, ajVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getClientInfoList(int i3, byte[] bArr, vh2.bk bkVar) {
        if (bkVar != null && isRun()) {
            this.mEngine.af(i3, bArr, bkVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public Cdo getFaceAuthInfo() {
        if (!isRun()) {
            return new c();
        }
        return new d(this.mEngine.cf());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public String getFullAvatarUrl(com.tencent.mobileqq.qqguildsdk.data.cw cwVar, int i3) {
        if (isRun()) {
            if (cwVar != null && !TextUtils.isEmpty(cwVar.a())) {
                return GProSdkWrapperImpl.ef(cwVar.a(), i3);
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getFullAvatarUrl", "avatar is null");
            return null;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public String getFullGuildUserUserAvatarUrl(String str, String str2, int i3) {
        if (!isRun()) {
            return null;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.k(str2)) {
            return this.mEngine.i3(str, str2, i3);
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getFullGuildUserUserAvatarUrl", "guildId=" + str + ", tinyId=" + str2);
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.g
    public String getFullUserAvatarPendantUrl(String str) {
        if (!isRun() || TextUtils.isEmpty(str)) {
            return null;
        }
        return GProSdkWrapperImpl.df(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public List<IGProGuildInfo> getGroupGuildList() {
        if (isRun()) {
            return this.mEngine.gl();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public String getGuildAvatarUrl(String str, int i3) {
        if (isRun()) {
            return this.mEngine.hl(str, i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public String getGuildIdOf(String str) {
        if (isRun()) {
            return this.mEngine.il(str);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public IGProGuildInfo getGuildInfo(String str) {
        if (isRun()) {
            return this.mEngine.jl(str);
        }
        com.tencent.mobileqq.qqguildsdk.util.h.s("[gpro_sdk]", 1, "sdk interface", "GPSServiceImpl isRun() false, GuildInfo null, gid:" + str);
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public List<IGProGuildInfo> getGuildList() {
        if (isRun()) {
            return this.mEngine.kl();
        }
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getGuildMainFrameHeaderInfo(long j3, vh2.ax axVar) {
        if (isRun()) {
            this.mEngine.kf(j3, axVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public IGProClientIdentityInfo getGuildMemberClientIdentity(String str, String str2, String str3) {
        if (!isRun()) {
            return null;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.k(str3)) {
            return this.mEngine.lf(str, str3);
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getGuildMemberClientIdentity", "guildId:" + str + ", clientId:" + str2 + ", tinyId:" + str3);
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @NonNull
    public String getGuildMemberName(String str, String str2) {
        if (!isRun()) {
            return "";
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.k(str2)) {
            String o36 = this.mEngine.o3(str, str2);
            if (o36 == null) {
                return "";
            }
            return o36;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getGuildMemberName", "guildId:" + str + ", tinyId:" + str2);
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @NonNull
    public Map<String, String> getGuildMemberNames(String str, List<String> list) {
        if (!isRun()) {
            return new HashMap();
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.j(list)) {
            return this.mEngine.rf(str, list);
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getGuildMemberNames", "guildId:" + str + ", tinyIds:" + list);
        return new HashMap();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public String getGuildName(String str) {
        if (isRun()) {
            return this.mEngine.ml(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.d
    @NonNull
    public dx getGuildPermission(String str) {
        if (!isRun()) {
            return dx.a.f266010a;
        }
        return this.mEngine.ql().c(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getGuildRecommend(byte[] bArr, vh2.bp bpVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.of(bArr, bpVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public long getGuildRoleLimit(String str) {
        if (!isRun()) {
            return 0L;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getGuildRoleLimit", "guildId: " + str);
            return 0L;
        }
        return this.mEngine.g3(com.tencent.mobileqq.qqguildsdk.util.g.O0(str));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public eo getGuildSpeakPermission(String str, int i3) {
        if (isRun() && this.mEngine.jl(str) != null) {
            return this.mEngine.pf(str, i3);
        }
        return new f();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public IGuildSpeakableThresholdPermission getGuildSpeakableThresholdPermission(String str) {
        if (!isRun()) {
            return new GuildSpeakableThresholdPermission.a().j(0).i(0).g();
        }
        return this.mEngine.ol(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public dt getGuildState(String str) {
        if (!isRun()) {
            return null;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getGuildState", "guildId: " + str);
            return null;
        }
        return this.mEngine.pl(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public Map<String, String> getGuildUserAvatarUrls(String str, List<String> list, int i3) {
        if (!isRun()) {
            return null;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.j(list)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getGuildUserAvatarUrls", String.format("tinyIds=%s", list));
            return null;
        }
        return this.mEngine.qf(str, list, i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.impl.cb, com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @NonNull
    public String getGuildUserDisplayName(String str, String str2) {
        String guildUserDisplayNameInternal = getGuildUserDisplayNameInternal(str, str2);
        return TextUtils.isEmpty(guildUserDisplayNameInternal) ? HardCodeUtil.qqStr(R.string.f140620eg) : guildUserDisplayNameInternal;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @NonNull
    public String getGuildUserDisplayNameInternal(String str, String str2) {
        String l3 = this.mEngine.l3(str, str2);
        if (l3 == null) {
            return "";
        }
        return l3;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @NonNull
    public String getGuildUserNick(String str, String str2) {
        if (!isRun()) {
            return "";
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.k(str2)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getGuildUserNick", "tinyId:" + str2);
            return "";
        }
        String p36 = this.mEngine.p3(str2);
        if (p36 == null) {
            return "";
        }
        return p36;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @NonNull
    public Map<String, String> getGuildUsersNicks(String str, List<String> list) {
        if (!isRun()) {
            return new HashMap();
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.j(list)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getGuildUsersNicks", "tinyIdList:" + list);
            return new HashMap();
        }
        return this.mEngine.sf(list);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public boolean getIsGuildListFirstLoadingCallbacked() {
        if (isRun()) {
            return this.mEngine.uf();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public List<IGProChannelInfo> getJumpChannelList(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList arrayList = new ArrayList();
            List<com.tencent.mobileqq.qqguildsdk.data.cy> channelCategoryList = getChannelCategoryList(str);
            if (channelCategoryList != null && channelCategoryList.size() != 0) {
                Iterator<com.tencent.mobileqq.qqguildsdk.data.cy> it = channelCategoryList.iterator();
                while (it.hasNext()) {
                    for (IGProChannelInfo iGProChannelInfo : it.next().getChannelList()) {
                        if (iGProChannelInfo != null && iGProChannelInfo.getGotoChannelId() > 0 && String.valueOf(iGProChannelInfo.getGotoChannelId()).equals(str2) && iGProChannelInfo.getJumpSwitch() == 1 && iGProChannelInfo.getTalkPermission() == 2) {
                            arrayList.add(iGProChannelInfo);
                        }
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getLiveAudioPollingCtx(String str, String str2, vh2.bb bbVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.vf(str, str2, bbVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "refreshPollingData", "guildId: " + str + ", categoryId: " + str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getLiveAudioPollingCtxV2(com.tencent.mobileqq.qqguildsdk.data.ai aiVar, vh2.bc bcVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(aiVar.b()) && !aiVar.a().isEmpty()) {
            this.mEngine.wf(aiVar, bcVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "refreshPollingData", "guildId: " + aiVar.b() + ", categoryTypeSize: " + aiVar.a().size());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getMemberInfoByOpenId(String str, long j3, boolean z16, boolean z17, vh2.bn bnVar) {
        if (!isRun() || TextUtils.isEmpty(str)) {
            return;
        }
        this.mEngine.xf(str, j3, z16, z17, bnVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public IGProGuildRoleInfo getMemberLevelRole(String str, String str2, String str3) {
        if (!isRun()) {
            return null;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            return this.mEngine.zf(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.O0(str3));
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getMemberLevelRole", "guildId: " + str + ", tinyId: " + str2);
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public IGProGuildRoleInfo getMemberTopRole(String str, String str2, String str3, String str4, int i3) {
        if (!isRun()) {
            return null;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2) && !com.tencent.mobileqq.qqguildsdk.util.j.k(str3)) {
            return this.mEngine.Af(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.O0(str3), com.tencent.mobileqq.qqguildsdk.util.g.O0(str4), i3);
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getMemberTopRole", "guildId: " + str + ", channelId: " + str2 + ", tinyId: " + str3);
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getMoreNoticeList(int i3, String str, int i16, vh2.bo boVar) {
        if (isRun()) {
            this.mEngine.yf(i3, str, i16, boVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public IGProOnlineMember getOnlineMemberInfo(String str) {
        if (!isRun()) {
            return null;
        }
        return this.mEngine.Cf(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public int getPermissionChangeFilter(@NonNull String str, @NonNull String str2) {
        if (!isRun()) {
            return 0;
        }
        return this.mEngine.Df(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public IGProAppChnnPreInfo getPollingChannelOfApp(String str, String str2) {
        if (!isRun()) {
            return null;
        }
        return this.mEngine.Ef(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public ILiveRoomInfo getPollingChannelOfLive(String str, String str2) {
        if (!isRun()) {
            return null;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getPollingChannelOfLive", "guildId: " + str);
            return null;
        }
        return this.mEngine.Ff(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public IAudioChannelMemberInfos getPollingChannelOfVoice(String str, String str2) {
        if (!isRun()) {
            return null;
        }
        return this.mEngine.Gf(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @NonNull
    public fk getQQMsgListChannel(@NonNull String str, @NonNull String str2) {
        if (!isRun()) {
            return new fk(str, str2, 0L);
        }
        return this.mEngine.Hf(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.e
    @NonNull
    public List<fk> getQQMsgListChannels() {
        if (!isRun()) {
            return new ArrayList();
        }
        return this.mEngine.If();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public IGProRecommendEssenceSvrRsp getRecommendEssenceSvrRsp(String str, String str2) {
        if (!isRun()) {
            return null;
        }
        return this.mEngine.Jf(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @Nullable
    public void getRecommendGuildInfoFromCache(vh2.ay ayVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Kf(ayVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    @Nullable
    public IGProGuildRoleInfo getRoleInfo(String str, String str2) {
        if (!isRun()) {
            return null;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            return this.mEngine.Bf(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2));
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getRoleInfo", "guildId=" + str + ", roleId=" + str2);
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getScheduleDetail(String str, String str2, String str3, vh2.ch chVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str3)) {
            this.mEngine.al().e(str, str2, str3, chVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getScheduleDetail", "guildId: " + str + ", channelId:" + str2);
        chVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new GuildScheduleInfo(), 0, false);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getScheduleList(String str, String str2, long j3, vh2.ci ciVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.al().f(str, str2, j3, ciVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getScheduleList", "guildId: " + str + ", channelId:" + str2);
        ciVar.onGetScheduleList(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new ArrayList<>());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getScheduleListNew(String str, String str2, int i3, long j3, String str3, vh2.cj cjVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.al().g(str, str2, i3, j3, str3, cjVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getScheduleListNew", "guildId: " + str + ", channelId:" + str2);
        cjVar.onGetScheduleListNew(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new ArrayList<>(), null);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getScheduleUsers(String str, String str2, String str3, int i3, byte[] bArr, vh2.cl clVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str3)) {
            this.mEngine.al().h(str, str2, str3, i3, bArr, clVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getScheduleUsers", "guildId: " + str + ", channelId:" + str2);
        clVar.onGetScheduleUsers(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new ArrayList<>(), true, null, 0, 0);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getSchedulesStatus(String str, String str2, long j3, long j16, vh2.ck ckVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.al().i(str, str2, j3, j16, ckVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getScheduleList", "guildId: " + str + ", channelId:" + str2);
        ckVar.onGetSchedulesStatus(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new ArrayList<>());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @NonNull
    public String getSelfGuildMemberName(String str) {
        if (!isRun()) {
            return "";
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getSelfGuildMemberName", "guildId:" + str);
            return "";
        }
        return getGuildMemberName(str, getSelfTinyId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public String getSelfTinyId() {
        if (isRun()) {
            return this.mEngine.Rf();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public List<IGProGuildInfo> getSortedGuildList() {
        if (isRun()) {
            return this.mEngine.rl();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public int getSpeakLimit(String str, String str2) {
        if (!isRun()) {
            return 0;
        }
        return this.mEngine.sl().j(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public List<IGProChannelInfo> getSpecificTypeChannelList(String str, int i3) {
        if (!isRun()) {
            return new ArrayList();
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getSpecificTypeChannelList", "guildId: " + str);
            return new ArrayList();
        }
        return this.mEngine.um(str, i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public List<String> getTopGuildList() {
        if (isRun()) {
            return this.mEngine.ul();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getUnBindClientServiceV2(byte[] bArr, vh2.bj bjVar) {
        if (bjVar != null && isRun()) {
            this.mEngine.Tf(bArr, bjVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getUserList(String str, long j3, boolean z16, int i3, vh2.br brVar) {
        if (brVar == null || !isRun()) {
            return;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            brVar.a(str, -90, "\u4f20\u53c2\u6570\u9519\u8bef", null, null, null, null);
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "getUserList", "guildId : " + str);
            return;
        }
        this.mEngine.Uf(str, j3, z16, i3, brVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getUserLiveInfo(int i3, vh2.bs bsVar) {
        if (bsVar != null && isRun()) {
            this.mEngine.Wf(i3, bsVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public boolean hasSetSpeakableThreshold(String str) {
        IGProGuildInfo jl5;
        if (!isRun() || (jl5 = this.mEngine.jl(str)) == null) {
            return true;
        }
        fc speakThreshold = jl5.getSpeakThreshold();
        if (speakThreshold.c() || speakThreshold.f() || speakThreshold.b() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void initGetNoticeList(int i3, String str, boolean z16, vh2.bu buVar) {
        if (isRun()) {
            this.mEngine.Zf(i3, str, z16, buVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public boolean isAllGuildAndChannelFetchCompleted() {
        return this.mEngine.bg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public boolean isChannelAdmin(String str, String str2) {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public boolean isGProSDKInitCompleted() {
        return this.mEngine.cg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public boolean isGuest(String str) {
        if (isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "isGuest", "guildId\uff1a" + str);
                return true;
            }
            return isGuest(getGuildInfo(str));
        }
        com.tencent.mobileqq.qqguildsdk.util.h.s("[gpro_sdk]", 1, "sdk interface", "GPSServiceImpl isRun() false, gid:" + str);
        return true;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.e
    public boolean isQQMsgListChannel(@NonNull String str, @NonNull String str2) {
        if (!isRun()) {
            return false;
        }
        return this.mEngine.dg(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.impl.cb, com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public boolean isQQMsgListReady() {
        if (!isRun()) {
            return false;
        }
        return this.mEngine.Z3();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void kickAudioChannelUsers(String str, String str2, ArrayList<String> arrayList, vh2.bw bwVar) {
        if (bwVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str) && com.tencent.mobileqq.qqguildsdk.util.j.j(arrayList)) {
                bwVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null, null);
            } else {
                this.mEngine.eg(str, str2, arrayList, bwVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void kickGuildUsers(String str, List<String> list, boolean z16, @Nullable fm fmVar, vh2.cd cdVar) {
        if (cdVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.j(list)) {
                cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "kickGuildUsers", "guildId : " + str);
                return;
            }
            if (fmVar == null) {
                fmVar = new fm.a().c(0).b();
            }
            this.mEngine.fg(str, list, z16, fmVar, cdVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void loadGProUserProfileInfo(String str, String str2, vh2.bz bzVar) {
        if (bzVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.k(str2)) {
                this.mEngine.Vi(str, str2, bzVar);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "loadGProUserProfileInfo", "guildId : " + str + ", tinyId:" + str2);
            bzVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void loadMemberRoleList(String str, String str2, @NonNull vh2.bx bxVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.k(str2)) {
            this.mEngine.Vm(str, str2, bxVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "loadMemberRoleList", "guildId: " + str + ", tinyId: " + str2);
        bxVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void loadUserInfo(String str, List<String> list, vh2.bq bqVar, List<IGProUserInfo> list2, boolean z16) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Wm(str, list, bqVar, list2, z16);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void loadUserList(String str, long j3, vh2.br brVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Yi(str, j3, brVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public byte[] lz4DecompressBuf(byte[] bArr) {
        if (bArr != null) {
            return GProSdkWrapperImpl.Zi(bArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void modifyGuildSpeakableMemberList(String str, List<String> list, List<String> list2, dv dvVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.aj(str, list, list2, dvVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void modifyGuildSpeakableRoleList(String str, List<String> list, List<String> list2, dv dvVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.bj(str, list, list2, dvVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void modifyGuildSpeakableRule(String str, GProGuildSpeakRuleData gProGuildSpeakRuleData, dv dvVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.cj(str, gProGuildSpeakRuleData, dvVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void modifyScheduleInviteStatus(String str, String str2, String str3, int i3, vh2.cm cmVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str3)) {
            this.mEngine.al().j(str, str2, str3, i3, cmVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "modifyScheduleInviteStatus", "guildId: " + str + ", channelId:" + str2);
        cmVar.onModifyInviteStatus(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.impl.cb, com.tencent.mobileqq.qqguildsdk.api.impl.bv, mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        com.tencent.mobileqq.qqguildsdk.util.h.s("[gpro_sdk]", 1, "sdk interface", "GPSServiceImpl init start!");
        super.onCreate(appRuntime);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.impl.bv, mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mApp = null;
        if (!this.mRun.compareAndSet(true, false)) {
            return;
        }
        this.mEngine.Fk();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void onSrvPushMsg(int i3, int i16, fi fiVar, byte[] bArr) {
        if (isRun() && fiVar != null) {
            this.mEngine.fj(i3, i16, fiVar, bArr);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void queryTinyIdByLiveUID(List<String> list, vh2.ca caVar) {
        if (caVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.j(list)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "queryTinyIdByLiveUID", "uidList is empty");
                caVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new HashMap<>());
            } else {
                this.mEngine.ij(list, caVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void refreshChannelInfo(String str, String str2, boolean z16, int i3) {
        if (isRun()) {
            this.mEngine.jj(str, str2, z16, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void refreshGuildList(boolean z16) {
        if (isRun()) {
            this.mEngine.mj(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void refreshGuildState() {
        if (!isRun()) {
            return;
        }
        this.mEngine.H0();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void refreshGuildUserProfileInfo(String str, String str2) {
        if (isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.k(str2)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "refreshGuildUserProfileInfo", "guildId : " + str + ", tinyId:" + str2);
                return;
            }
            this.mEngine.nj(str, str2, 1);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void refreshPollingData() {
        if (isRun()) {
            this.mEngine.oj();
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void removeBanBeforeBroadcast(String str, String str2, vh2.cb cbVar) {
        if (cbVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.rj(str, str2, cbVar);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "removeBanBeforeBroadcast", "uid: " + str + ", roomId: " + str2);
            cbVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", 1, "");
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void removeChannel(String str, String str2, int i3, vh2.cd cdVar) {
        if (cdVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.sj(str, str2, i3, cdVar);
                return;
            }
            cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "removeChannel", " guildId \uff1a " + str + ", channelUin: " + str2);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void removeChannelCategory(String str, long j3, boolean z16, vh2.bg bgVar) {
        if (bgVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.c(str, j3)) {
                bgVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            } else {
                this.mEngine.Xm(str, j3, z16, bgVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void removeGuildStateListener(@NonNull vh2.bt btVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Cl(btVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void removeMemberFromGuildBlackList(String str, @NonNull List<String> list, vh2.cc ccVar) {
        if (ccVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "removeMemberFromGuildBlackList", "guildId:" + str);
                ccVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
                return;
            }
            this.mEngine.uj(str, list, ccVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void reportShareInfo(String str, String str2, int i3, String str3, int i16, vh2.cc ccVar) {
        if (ccVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.vj(str, str2, i3, str3, i16, ccVar);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "reportShareInfo", "guildId\uff1a" + str + " channelId:" + str2);
            ccVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void requestBeginBroadcast(String str, String str2, String str3, int i3, com.tencent.mobileqq.qqguildsdk.data.bl blVar, vh2.cd cdVar) {
        if (cdVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str3)) {
                this.mEngine.wj(str, str2, str3, i3, blVar, cdVar);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "requestBeginBroadcast", "guildId\uff1a" + str + ", channelId: " + str2 + ", roomId:" + str3);
            cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", getEmptyIGProSecurityResult());
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void searchMsgSeqsFromServer(@NonNull com.tencent.mobileqq.qqguildsdk.data.bd bdVar, @NonNull vh2.cp cpVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.xj(bdVar, cpVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void searchUnion(String str, byte[] bArr, int i3, int i16, int i17, int i18, int i19, vh2.cq cqVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.yj(str, bArr, i3, i16, i17, i18, i19, cqVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void sendDirectMsgReadReport(@NonNull List<com.tencent.mobileqq.qqguildsdk.data.j> list) {
        if (!isRun() || list.isEmpty()) {
            return;
        }
        this.mEngine.zj(list);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void sendScheduleArkMessage(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<com.tencent.mobileqq.qqguildsdk.data.cu> arrayList3, com.tencent.mobileqq.qqguildsdk.data.cu cuVar, long j3, int i3, String str, String str2, String str3, byte[] bArr, vh2.cn cnVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.al().k(arrayList, arrayList2, arrayList3, cuVar, j3, i3, str, str2, str3, bArr, cnVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.impl.cb, com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setAVChannelInviteSpeakSwitch(long j3, long j16, com.tencent.mobileqq.qqguildsdk.data.genc.cw cwVar, em emVar) {
        if (isRun()) {
            this.mEngine.K4(j3, j16, cwVar, emVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.impl.cb, com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setAVChannelSpeakMode(long j3, long j16, String str, com.tencent.mobileqq.qqguildsdk.data.genc.fn fnVar, el elVar) {
        if (isRun()) {
            if (fnVar != null && fnVar.a() != 0 && fnVar.b() > 0) {
                this.mEngine.L4(j3, j16, str, fnVar, elVar);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setAVChannelSpeakMode", "\u4f20\u53c2\u6570\u9519\u8bef");
            if (elVar != null) {
                elVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new GGProVoiceSpeakModeRsp(new GProVoiceSpeakModeRsp()));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.impl.cb, com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.b
    public void setAVChannelSpeakOrder(long j3, long j16, fh fhVar, em emVar) {
        if (isRun()) {
            this.mEngine.M4(j3, j16, fhVar, emVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setAdminMsgNotifyType(String str, String str2, int i3, vh2.cr crVar) {
        if (crVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.Ij(str, str2, i3, crVar);
                return;
            }
            crVar.a(-90, null, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setChannelMsgNotifyType", " guildId \uff1a " + str + ", channelUin: " + str2);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelBannedSpeak(String str, int i3, vh2.cd cdVar) {
        if (cdVar != null && isRun()) {
            String guildIdOf = getGuildIdOf(str);
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(guildIdOf) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                this.mEngine.Bj(guildIdOf, str, i3, cdVar);
                return;
            }
            cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setChannelBannedSpeak", " guildId \uff1a " + guildIdOf + ", channelUin: " + str);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelCategory(String str, String str2, long j3, vh2.bg bgVar) {
        if (bgVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.Ym(str, str2, j3, bgVar);
            } else {
                bgVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelCategoryInfo(String str, com.tencent.mobileqq.qqguildsdk.data.b bVar, ArrayList<com.tencent.mobileqq.qqguildsdk.data.b> arrayList, vh2.bg bgVar) {
        if (bgVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.f(str, bVar, arrayList)) {
                bgVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            } else {
                this.mEngine.Zm(str, bVar, arrayList, bgVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelCategoryOrder(String str, ArrayList<Long> arrayList, vh2.bg bgVar) {
        if (bgVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.g(str, arrayList)) {
                bgVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            } else {
                this.mEngine.an(str, arrayList, bgVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelLiveable(String str, String str2, int i3, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Fj(str, str2, i3, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelLiveableMemberList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Gj(str, str2, list, list2, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.d
    public void setChannelLiveableRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Hj(str, str2, list, list2, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelName(String str, String str2, String str3, vh2.ct ctVar) {
        if (ctVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.Jj(str, str2, str3, ctVar);
                return;
            }
            ctVar.a(-90, null, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setChannelName", " guildId \uff1a " + str + ", channelUin: " + str2);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelSlowMode(String str, int i3, vh2.cd cdVar) {
        if (cdVar != null && isRun()) {
            String guildIdOf = getGuildIdOf(str);
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(guildIdOf) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                this.mEngine.Kj(guildIdOf, str, i3, cdVar);
                return;
            }
            cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setChannelSlowMode", " guildId \uff1a " + guildIdOf + ", channelUin: " + str);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelSpeakable(String str, String str2, int i3, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Lj(str, str2, i3, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelSpeakableMemberList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Mj(str, str2, list, list2, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.d
    public void setChannelSpeakableRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Nj(str, str2, list, list2, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelTopMsg(String str, String str2, long j3, int i3, int i16, @NonNull vh2.cc ccVar) {
        if (!isRun()) {
            return;
        }
        IGProChannelInfo channelInfo = getChannelInfo(str2);
        if (channelInfo == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setChannelTopMsg", "guildId: " + str + ", channelId: " + str2);
            ccVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
            return;
        }
        this.mEngine.vl().n(channelInfo, j3, i3, i16, ccVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelVisible(String str, String str2, int i3, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Pj(str, str2, i3, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setChannelVisibleMemberList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Qj(str, str2, list, list2, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.d
    public void setChannelVisibleRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Rj(str, str2, list, list2, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setClientShowConfig(String str, int i3, int i16, vh2.cu cuVar) {
        if (cuVar != null && isRun()) {
            this.mEngine.Sj(str, i3, i16, cuVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setDirectMsgBlack(String str, boolean z16, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Tj(str, z16, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setDirectMsgNotifyForGuild(int i3, boolean z16, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Uj(i3, z16, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setDirectMsgNotifyType(String str, int i3, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Vj(str, i3, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setDirectMsgStatus(int i3, int i16, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Wj(i3, i16, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setFeedCommentsNotifySwitch(int i3, vh2.k kVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Xj(i3, kVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGender(int i3, vh2.cc ccVar) {
        if (isRun()) {
            this.mEngine.Yj(i3, ccVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildClientId(String str, String str2, vh2.cv cvVar) {
        if (cvVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setGuildClientId", "guildId:" + str + ", clientId:" + str2);
                return;
            }
            this.mEngine.Zj(str, str2, cvVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildCoverFontColorId(String str, int i3, vh2.cw cwVar) {
        if (isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setGuildCoverFontColorId", "guildId:" + str + " param err");
                cwVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null, 0);
                return;
            }
            this.mEngine.ak(str, i3, cwVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildListSort(ArrayList<String> arrayList, vh2.cy cyVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.bk(arrayList, cyVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildName(String str, String str2, vh2.cx cxVar) {
        if (cxVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !TextUtils.isEmpty(str2)) {
                this.mEngine.ck(str, str2, cxVar);
                return;
            }
            cxVar.a(-90, null, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setGuildName", "guildId \uff1a " + str + ", name: " + str2);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildProfile(String str, String str2, vh2.cd cdVar) {
        if (cdVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setGuildProfile", "guildId : " + str + "\uff0c profile \uff1a " + str2);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.engine.z zVar = this.mEngine;
            if (str2 == null) {
                str2 = "";
            }
            zVar.dk(str, str2, cdVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildQRCodePeriod(String str, int i3, vh2.cd cdVar) {
        if (cdVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setGuildProfile", "guildId : " + str + "\uff0c QRCodePeriod \uff1a " + i3);
                return;
            }
            this.mEngine.ek(str, i3, cdVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildShutUp(String str, long j3, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        if (getGuildInfo(str) == null) {
            cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
        } else {
            this.mEngine.fk(str, j3, cdVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildSpeakableThreshold(String str, fc fcVar, dv dvVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.gk(str, fcVar, dvVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildTop(String str, boolean z16, vh2.da daVar) {
        if (daVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                daVar.a(-90, null, "\u4f20\u53c2\u6570\u9519\u8bef");
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setGuildTop", "guildId : " + str);
                return;
            }
            this.mEngine.hk(str, z16, daVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildUnNotifyFlag(String str, int i3, vh2.cz czVar) {
        if (czVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setGuildUnNotifyFlag", "guildId:" + str + ", guildMessageNotifyType:" + i3);
                return;
            }
            this.mEngine.ik(str, i3, czVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildVisibilityForVisitor(String str, boolean z16, @NonNull vh2.cc ccVar) {
        if (!isRun()) {
            return;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setGuildVisibilityForVisitor", "guildId:" + str);
            ccVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
            return;
        }
        this.mEngine.jk(str, z16, ccVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setGuildWeakNotifyDisplay(String str, int i3, vh2.db dbVar) {
        if (dbVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setGuildWeakNotifyDisplay", "guildId:" + str + ", weakNotifyDisplay:" + i3);
                return;
            }
            this.mEngine.kk(str, i3, dbVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setLiveChannelAnchorList(String str, String str2, List<String> list, List<String> list2, vh2.cd cdVar) {
        if (cdVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.lk(str, str2, list, list2, cdVar);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setLiveChannelAnchorList", "guildId\uff1a" + str + ", channelId: " + str2);
            cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", getEmptyIGProSecurityResult());
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setLiveChannelBannedUser(String str, String str2, String str3, String str4, int i3, vh2.cc ccVar) {
        if (ccVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str3) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str4)) {
                this.mEngine.mk(str, str2, str3, str4, i3, ccVar);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setLiveChannelBannedUser", "guildId\uff1a" + str + " channelId:" + str2 + " roomId:" + str3 + " bannedUser:" + str4);
            ccVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setLocation(GProLocationInfo gProLocationInfo, vh2.cc ccVar) {
        if (isRun()) {
            this.mEngine.nk(gProLocationInfo, ccVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void setMemberRoles(String str, String str2, String str3, String str4, @NonNull List<String> list, @NonNull List<String> list2, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.k(str2)) {
            this.mEngine.ok(str, str2, str3, str4, list, list2, cdVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setMemberRoles", "guildId: " + str + ", tinyId: " + str2 + ", addRoles: " + list.toString() + ", removeRoles: " + list2.toString());
        cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setMemberShutUp(String str, String str2, long j3, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        if (getGuildInfo(str) == null) {
            cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
        } else {
            this.mEngine.pk(str, str2, j3, cdVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setMyMsgNotifyType(String str, String str2, int i3, vh2.cs csVar) {
        if (csVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.Ad(str, str2, i3, csVar);
                return;
            }
            csVar.a(-90, null, "\u4f20\u53c2\u6570\u9519\u8bef");
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setMyMsgNotifyType", " guildId \uff1a " + str + ", channelUin: " + str2);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setNickName(String str, vh2.cc ccVar) {
        if (isRun()) {
            this.mEngine.qk(str, ccVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setOnLogin(boolean z16) {
        com.tencent.mobileqq.qqguildsdk.util.h.t("[gpro_sdk]", true, "setOnLogin isForceRefresh=" + z16);
        if (isRun()) {
            this.mEngine.mj(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.e
    public void setQQMsgListChannel(@NonNull String str, @NonNull String str2, int i3, @NonNull vh2.cc ccVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.rk(str, str2, i3, ccVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void setRoleInfo(String str, String str2, @NonNull fn fnVar, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.tk(str, str2, fnVar, cdVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setRoleInfo", "guildId: " + str + ", roleId: " + str2 + ", roleInfo: " + fnVar.toString());
        cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setRoleMembers(String str, String str2, String str3, String str4, @NonNull List<String> list, @NonNull List<String> list2, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.uk(str, str2, str3, str4, list, list2, cdVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setRoleMembers", "guildId: " + str + ", roleId: " + str2 + ", addMembers: " + list.toString() + ", removeMembers: " + list2.toString());
        cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void setRoleOrder(String str, @NonNull List<String> list, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setRoleOrder", "guildId: " + str + ", roleIdList: " + list.toString());
            cdVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            return;
        }
        this.mEngine.vk(str, list, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void setRoleSpeakableChannels(String str, String str2, @NonNull List<String> list, @NonNull List<String> list2, @NonNull vh2.cc ccVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.sk(str, str2, 1, list, list2, ccVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService, uh2.f
    public void setRoleVisibleChannels(String str, String str2, @NonNull List<String> list, @NonNull List<String> list2, @NonNull vh2.cc ccVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.sk(str, str2, 2, list, list2, ccVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setScreenSharedInGuild(String str, String str2, boolean z16, vh2.co coVar) {
        if (coVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.wk(str, str2, z16, coVar);
            } else {
                coVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setSelfTinyId(String str) {
        if (isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.k(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setSelfTinyId", "tinyId:" + str);
                return;
            }
            this.mEngine.xk(str);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setShowArchive(String str, boolean z16, vh2.dd ddVar) {
        if (ddVar != null && isRun()) {
            this.mEngine.yk(str, z16, ddVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setShowPresence(String str, boolean z16, vh2.dd ddVar) {
        if (ddVar != null && isRun()) {
            this.mEngine.zk(str, z16, ddVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setUserLiveInfo(int i3, String str, String str2, int i16, vh2.dc dcVar) {
        if (dcVar != null && isRun()) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "setUserLiveInfo", "title coverUrl both empty");
                dcVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", null);
            } else {
                this.mEngine.Ak(i3, str, str2, i16, dcVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setUserMuteSeatInGuild(String str, String str2, String str3, boolean z16, vh2.cc ccVar) {
        if (ccVar != null && isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2) && !com.tencent.mobileqq.qqguildsdk.util.j.k(str3)) {
                this.mEngine.Bk(str, str2, str3, z16, ccVar);
            } else {
                ccVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setUserType(String str, vh2.dg dgVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Ck(str, dgVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void setUserVoicelessToMe(String str, boolean z16, vh2.cc ccVar) {
        if (ccVar != null && isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.k(str)) {
                ccVar.onResult(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
            } else {
                this.mEngine.Dk(str, z16, ccVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void subscribePolling(@NonNull String str) {
        int i3;
        if (!isRun()) {
            return;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "subscribePolling", "guildId: " + str);
            return;
        }
        IGProGuildInfo guildInfo = getGuildInfo(str);
        if (guildInfo != null) {
            i3 = guildInfo.getUserType();
        } else {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "subscribePolling", "guildInfo=null, userType=0");
            i3 = 0;
        }
        this.mEngine.Gk(str, i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void subscribePollingChannels(@NonNull List<fj> list) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Hk(list);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void terminateLiveStream(String str, String str2, int i3, int i16, vh2.de deVar) {
        if (deVar == null || !isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
            this.mEngine.Ik(str, str2, i3, i16, deVar);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "terminateLiveStream", "guildId\uff1a" + str + ", channelId: " + str2);
        deVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef");
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void tryUnmuteMicrophone(String str, String str2, boolean z16, @NonNull vh2.cc ccVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Jk(str, str2, z16, ccVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void ubsubscribePollingChannels(@NonNull List<fj> list) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Kk(list);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void unsubscribePolling(@NonNull String str) {
        if (!isRun()) {
            return;
        }
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "unsubscribePolling", "guildId: " + str);
            return;
        }
        this.mEngine.Lk(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void updateArchiveShowSeq(ArrayList<Integer> arrayList, vh2.df dfVar) {
        if (isRun() && arrayList != null && arrayList.size() != 0) {
            this.mEngine.Mk(arrayList, dfVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void updateForumChannelSortMode(String str, String str2, int i3, @NonNull vh2.cd cdVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Nk(str, str2, i3, cdVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void voiceChannelAuth0x10b6(String str, String str2, int i3, boolean z16, int i16, vh2.dh dhVar) {
        if (!isRun()) {
            return;
        }
        this.mEngine.Ok(str, str2, i3, z16, i16, dhVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchChannelAdminInfoList(String str, String str2, @NonNull vh2.e eVar) {
        if (isRun()) {
            this.mEngine.Hd(str, str2, eVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchRoleList(String str, int i3, int i16, @NonNull vh2.aq aqVar) {
        if (isRun()) {
            this.mEngine.nm(str, i3, i16, aqVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchUserInfo(String str, String str2, List<String> list, boolean z16, vh2.bq bqVar) {
        fetchUserInfo(str, str2, list, z16, true, bqVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void fetchUserInfo(String str, List<String> list, boolean z16, boolean z17, vh2.bq bqVar) {
        fetchUserInfo(str, "0", list, z16, z17, bqVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    @NonNull
    public String getGuildUserDisplayName(String str, String str2, String str3) {
        String guildUserDisplayNameInternal = getGuildUserDisplayNameInternal(str, str2);
        return TextUtils.isEmpty(guildUserDisplayNameInternal) ? TextUtils.isEmpty(str3) ? HardCodeUtil.qqStr(R.string.f140620eg) : str3 : guildUserDisplayNameInternal;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void refreshPollingData(@NonNull String str, int i3) {
        if (isRun()) {
            if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "refreshPollingData", "guildId: " + str);
                return;
            }
            this.mEngine.pj(str, i3);
        }
    }

    public void fetchUserInfo(String str, String str2, List<String> list, boolean z16, boolean z17, vh2.bq bqVar) {
        if (bqVar == null || !isRun()) {
            return;
        }
        if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.j(list)) {
            this.mEngine.sm(str, str2, list, z16, z17, bqVar);
            return;
        }
        bqVar.a(-90, "\u4f20\u53c2\u6570\u9519\u8bef", new ArrayList(), new ArrayList());
        com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchUserInfo", "guildId : " + str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public HashMap<Long, ArrayList<Long>> getChannelPermission(String str, int i3) {
        if (!isRun()) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(i3));
        ArrayList<Long> arrayList2 = new ArrayList<>();
        arrayList2.add(Long.valueOf(str));
        return this.mEngine.Ve(arrayList2, arrayList);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void getUserList(String str, Object obj, boolean z16, int i3, @NonNull vh2.bl blVar) {
        if (isRun()) {
            this.mEngine.Vf(str, obj, z16, i3, blVar);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void terminateLiveStream(String str, String str2, int i3, vh2.de deVar) {
        terminateLiveStream(str, str2, i3, 0, deVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public boolean isGuest(IGProGuildInfo iGProGuildInfo) {
        if (!isRun()) {
            com.tencent.mobileqq.qqguildsdk.util.h.s("[gpro_sdk]", 1, "sdk interface", "GPSServiceImpl isRun() false!");
            return true;
        }
        if (iGProGuildInfo == null) {
            return true;
        }
        return !iGProGuildInfo.isMember();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSService
    public void refreshPollingData(@NonNull String str, @NonNull String str2) {
        if (isRun()) {
            if (!com.tencent.mobileqq.qqguildsdk.util.j.i(str) && !com.tencent.mobileqq.qqguildsdk.util.j.i(str2)) {
                this.mEngine.qj(str, str2);
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "refreshPollingData", "guildId: " + str + ", channelId: " + str2);
        }
    }
}
