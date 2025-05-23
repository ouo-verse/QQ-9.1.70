package com.tencent.mobileqq.matchfriend.report.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.biz.webviewplugin.ad;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.dt.api.d;
import com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.bean.c;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerReportFeedSubmitEvent;
import com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$GetAIOSignReq;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$GetAIOSignRsp;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendJubaoApiImpl implements IMatchFriendJubaoApi {
    private static final String REPORT_COMMENT_APP_ID = "100827";
    private static final String REPORT_FEED_APP_ID = "100826";
    private static final String TAG = "MatchFriendJubao";

    /* compiled from: P */
    /* loaded from: classes33.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f245524a;

        static {
            int[] iArr = new int[IMatchFriendJubaoApi.From.values().length];
            f245524a = iArr;
            try {
                iArr[IMatchFriendJubaoApi.From.PROFILE_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f245524a[IMatchFriendJubaoApi.From.AIO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f245524a[IMatchFriendJubaoApi.From.VOICE_MATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f245524a[IMatchFriendJubaoApi.From.PARTY_ROOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f245524a[IMatchFriendJubaoApi.From.PARTY_ROOM_MSG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f245524a[IMatchFriendJubaoApi.From.PARTY_ROOM_AUDIO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        HashMap<IMatchFriendJubaoApi.From, String> hashMap = IMatchFriendJubaoApi.SECRET_KEY;
        hashMap.put(IMatchFriendJubaoApi.From.AIO, "vC9S2ckXFU5FwEoa3aq9dgp43xCCFpt5");
        hashMap.put(IMatchFriendJubaoApi.From.PROFILE_CARD, "LBCriUXkjUt3eHwpMwVu5bqiNGzAgoLS");
        hashMap.put(IMatchFriendJubaoApi.From.VOICE_MATCH, "whEkjmD9UWNKLkyCb4vJTRxbZZ9s4qYu");
    }

    private void jumpMatchFriendJuBaoForAioInternal(AppInterface appInterface, Activity activity, String str, String str2, String str3, Bundle bundle) {
        String str4;
        ad adVar = ad.f97536a;
        if (ProfileUtils.isFriend(appInterface, str2)) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        adVar.c(activity, str, str2, str4, "0", str2, "0", String.valueOf(1046), str3, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$jumpMatchFriendJuBao$0(Bundle bundle, AppInterface appInterface, Activity activity, String str, String str2, String str3, Boolean bool, byte[] bArr) {
        QLog.i(TAG, 1, "[jumpMatchFriendJuBaoForAio] getAioSignFromNet, isSuccess=" + bool + ", sigFromSever=" + bArr);
        if (bool.booleanValue() && bArr != null) {
            bundle.putString("jubao_matchfriend_sig", Base64.encodeToString(bArr, 0));
            jumpMatchFriendJuBaoForAioInternal(appInterface, activity, str, str2, str3, bundle);
            return null;
        }
        jumpMatchFriendJuBaoForAioInternal(appInterface, activity, str, str2, str3, null);
        return null;
    }

    private void requestAioSigThenJump(final String str, final QQAppInterface qQAppInterface, final Context context, final Bundle bundle, final int i3) {
        aioMsg$GetAIOSignReq aiomsg_getaiosignreq = new aioMsg$GetAIOSignReq();
        aiomsg_getaiosignreq.to_tinyid.set(Long.parseLong(str));
        ((com.tencent.relation.common.servlet.a) qQAppInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4)).Z0("QQStranger.AIOMsg.SsoGetAIOSign", aiomsg_getaiosignreq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.report.api.impl.MatchFriendJubaoApiImpl.1
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i16, boolean z16, Object obj) {
                if (z16 && obj != null) {
                    try {
                        aioMsg$GetAIOSignRsp aiomsg_getaiosignrsp = new aioMsg$GetAIOSignRsp();
                        aiomsg_getaiosignrsp.mergeFrom((byte[]) obj);
                        if (aiomsg_getaiosignrsp.ret_code.get() == 0) {
                            byte[] byteArray = aiomsg_getaiosignrsp.sign.get().toByteArray();
                            qQAppInterface.getMsgCache().x(str, qQAppInterface.getCurrentAccountUin(), byteArray);
                            bundle.putByteArray("jubao_matchfriend_sig", byteArray);
                            com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.report.api.impl.MatchFriendJubaoApiImpl.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    IMatchFriendRequest iMatchFriendRequest = (IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class);
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    iMatchFriendRequest.reportJubao(qQAppInterface, Long.parseLong(str));
                                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                    QQAppInterface qQAppInterface2 = qQAppInterface;
                                    Context context2 = context;
                                    String str2 = str;
                                    String currentUin = qQAppInterface2.getCurrentUin();
                                    AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                    NewReportPlugin.M(qQAppInterface2, context2, str2, null, "0", null, currentUin, i3, bundle);
                                }
                            });
                            if (QLog.isColorLevel()) {
                                QLog.i(MatchFriendJubaoApiImpl.TAG, 2, "[getAioSign] success sign length:" + byteArray.length);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        QLog.e(MatchFriendJubaoApiImpl.TAG, 1, "[getAioSign] error", e16);
                        return;
                    }
                }
                QLog.e(MatchFriendJubaoApiImpl.TAG, 1, "[getAioSign] isSuccess:" + z16 + ", data:" + obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi
    public void reportFeed(Context context, String str, final String str2) {
        com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
        bVar.i(REPORT_FEED_APP_ID);
        bVar.n(str);
        bVar.o(2);
        bVar.j("0");
        bVar.s(1);
        bVar.m(str2);
        ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(context, bVar, new d() { // from class: com.tencent.mobileqq.matchfriend.report.api.impl.a
            @Override // com.tencent.mobileqq.dt.api.d
            public final void a(int i3) {
                MatchFriendJubaoApiImpl.lambda$reportFeed$1(str2, i3);
            }
        });
    }

    @Override // com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi
    public void jumpMatchFriendJuBao(final AppInterface appInterface, final Activity activity, final String str, final String str2, final String str3) {
        if (!(appInterface instanceof QQAppInterface)) {
            jumpMatchFriendJuBaoForAioInternal(appInterface, activity, str, str2, str3, null);
            return;
        }
        final Bundle bundle = new Bundle();
        byte[] I0 = ((e) appInterface.getMsgCache()).I0(str2, appInterface.getCurrentUin());
        if (I0 == null) {
            QQStrangerAIOSigUtil.i((QQAppInterface) appInterface, Long.parseLong(str2), new Function2() { // from class: com.tencent.mobileqq.matchfriend.report.api.impl.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda$jumpMatchFriendJuBao$0;
                    lambda$jumpMatchFriendJuBao$0 = MatchFriendJubaoApiImpl.this.lambda$jumpMatchFriendJuBao$0(bundle, appInterface, activity, str, str2, str3, (Boolean) obj, (byte[]) obj2);
                    return lambda$jumpMatchFriendJuBao$0;
                }
            });
        } else {
            bundle.putString("jubao_matchfriend_sig", Base64.encodeToString(I0, 0));
            jumpMatchFriendJuBaoForAioInternal(appInterface, activity, str, str2, str3, bundle);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi
    public void startMatchFriendJubaoByScene(BaseQQAppInterface baseQQAppInterface, Context context, IMatchFriendJubaoApi.From from, String str, String str2, com.tencent.mobileqq.matchfriend.report.a aVar) {
        int i3;
        int i16;
        long j3;
        Bundle bundle;
        if (!(baseQQAppInterface instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "!(qqAppInterface instanceof QQAppInterface)");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) baseQQAppInterface;
        switch (a.f245524a[from.ordinal()]) {
            case 1:
            default:
                i16 = 2220329;
                break;
            case 2:
                i3 = 2220330;
                i16 = i3;
                break;
            case 3:
                i3 = 2220331;
                i16 = i3;
                break;
            case 4:
                i3 = 2220369;
                i16 = i3;
                break;
            case 5:
                i3 = 2220370;
                i16 = i3;
                break;
            case 6:
                i3 = 2220371;
                i16 = i3;
                break;
        }
        if (aVar != null) {
            bundle = aVar.e();
        } else {
            try {
                j3 = Long.parseLong(str);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                j3 = 0;
            }
            QQStrangerUserInfo userInfo = ((IQQStrangerUserInfoMgr) qQAppInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).getUserInfo(new c(104, j3, ""));
            if (userInfo != null) {
                bundle = com.tencent.mobileqq.matchfriend.report.a.b().a(userInfo.avatar).f(userInfo.nick).e();
            } else {
                bundle = new Bundle();
            }
        }
        Bundle bundle2 = bundle;
        bundle2.putString("chatuin", str);
        bundle2.putInt("chattype", 1046);
        if (!TextUtils.isEmpty(str2)) {
            bundle2.putString(TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID, str2);
        }
        byte[] I0 = qQAppInterface.getMsgCache().I0(str, qQAppInterface.getCurrentAccountUin());
        if (I0 == null) {
            QLog.e(TAG, 1, "key == null");
            requestAioSigThenJump(str, qQAppInterface, context, bundle2, i16);
        } else {
            bundle2.putByteArray("jubao_matchfriend_sig", I0);
            ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).reportJubao(qQAppInterface, Long.parseLong(str));
            NewReportPlugin.M(qQAppInterface, context, str, null, "0", null, qQAppInterface.getCurrentUin(), i16, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportFeed$1(String str, int i3) {
        if (i3 == 1) {
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerReportFeedSubmitEvent(str));
        }
    }
}
