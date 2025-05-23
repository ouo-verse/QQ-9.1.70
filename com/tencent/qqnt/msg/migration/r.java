package com.tencent.qqnt.msg.migration;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.ao;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAioGift;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Sqlite;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMsgBackupProxy;
import com.tencent.mobileqq.msg.api.IMultiMsgProxy;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupController;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import com.tencent.qqnt.kernel.nativeinterface.AVRecordElement;
import com.tencent.qqnt.kernel.nativeinterface.AndroidImportParseMsgs;
import com.tencent.qqnt.kernel.nativeinterface.AndroidImportQueryParam;
import com.tencent.qqnt.kernel.nativeinterface.AndroidImportSessionInfo;
import com.tencent.qqnt.kernel.nativeinterface.AndroidImportTableInfo;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataImportGameChatSession;
import com.tencent.qqnt.kernel.nativeinterface.FaceBubbleElement;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.FoldingInfo;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import com.tencent.qqnt.kernel.nativeinterface.FromRoleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildClientIdentity;
import com.tencent.qqnt.kernel.nativeinterface.GuildClientIdentityBytes;
import com.tencent.qqnt.kernel.nativeinterface.GuildMedal;
import com.tencent.qqnt.kernel.nativeinterface.ImportMsgFilePath;
import com.tencent.qqnt.kernel.nativeinterface.ImportMsgPbRecord;
import com.tencent.qqnt.kernel.nativeinterface.ImportMsgRecordFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.ImportRecentUser;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MultiTransInfo;
import com.tencent.qqnt.kernel.nativeinterface.ShareLocationElement;
import com.tencent.qqnt.kernel.nativeinterface.SmallYellowFaceInfo;
import com.tencent.qqnt.kernel.nativeinterface.WalletAio;
import com.tencent.qqnt.kernel.nativeinterface.WalletElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.VASGiftSpendCoinItem;
import com.tencent.trpcprotocol.qqva.channel_gift.Msg$ReserveInfo;
import com.tencent.trpcprotocol.qqva.channel_gift.Msg$SpendCoinItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.qqwallet.qqwalletaio_resv$qqwalletaio_body_resv;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J&\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0010j\b\u0012\u0004\u0012\u00020\u001b`\u00122\u0006\u0010\u0003\u001a\u00020\u0002J,\u0010&\u001a\u00020%2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"J\u000e\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020 J\"\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eJ\u000e\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020,J\u0006\u00101\u001a\u000200J\u0006\u00102\u001a\u00020(J \u00105\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020,2\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020 J\u000e\u00108\u001a\u00020%2\u0006\u00107\u001a\u000206J\u000e\u00109\u001a\u00020\"2\u0006\u0010-\u001a\u00020,J\u000e\u0010:\u001a\u00020\"2\u0006\u0010-\u001a\u00020,R*\u0010=\u001a\u0016\u0012\u0004\u0012\u00020;\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020;\u0018\u0001`\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/qqnt/msg/migration/r;", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "mr", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "u", "Lcom/tencent/mobileqq/data/QQWalletAioBodyReserve;", "reserve", "", "f", "k", DomainData.DOMAIN_NAME, "j", "i", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/ImportMsgRecordFileInfo;", "Lkotlin/collections/ArrayList;", "fileInfos", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "w", ReportConstant.COSTREPORT_PREFIX, "p", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "e", "", "msgRecords", "", "readCount", "", "nextId", "readDbTimeStamp", "Lcom/tencent/qqnt/kernel/nativeinterface/AndroidImportParseMsgs;", "t", QQBrowserActivity.KEY_MSG_TYPE, "", "r", "srcMsgList", "v", "", ReportPlugin.KEY_TABLE_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/AndroidImportTableInfo;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/AndroidImportSessionInfo;", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "startIndex", "count", "o", "Lcom/tencent/qqnt/kernel/nativeinterface/AndroidImportQueryParam;", "queryParam", "b", "g", tl.h.F, "Lcom/tencent/mobileqq/msgbackup/controller/d;", "Ljava/util/ArrayList;", "mRichProcessorList", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class r {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f359707a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ArrayList<com.tencent.mobileqq.msgbackup.controller.d> mRichProcessorList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64089);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f359707a = new r();
        }
    }

    r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final byte[] f(QQWalletAioBodyReserve reserve) {
        String str;
        String str2;
        if (reserve == null) {
            return new byte[0];
        }
        qqwalletaio_resv$qqwalletaio_body_resv qqwalletaio_resv_qqwalletaio_body_resv = new qqwalletaio_resv$qqwalletaio_body_resv();
        qqwalletaio_resv_qqwalletaio_body_resv.uint32_pfa_type.set(reserve.pfaType);
        String str3 = reserve.feedId;
        if (str3 != null && !str3.equals("")) {
            qqwalletaio_resv_qqwalletaio_body_resv.bytes_feeds_id.set(ByteStringMicro.copyFromUtf8(reserve.feedId));
        }
        qqwalletaio_resv_qqwalletaio_body_resv.uint32_subchannel.set(reserve.subChannel);
        String str4 = reserve.poemRule;
        if (str4 != null && !str4.equals("")) {
            qqwalletaio_resv_qqwalletaio_body_resv.bytes_poem_rule.set(ByteStringMicro.copyFromUtf8(reserve.poemRule));
        }
        String str5 = reserve.makeHbExtend;
        if (str5 != null && !str5.equals("")) {
            qqwalletaio_resv_qqwalletaio_body_resv.bytes_client_extend.set(ByteStringMicro.copyFromUtf8(reserve.makeHbExtend));
        }
        String str6 = reserve.shengpiziMD5;
        if (str6 == null || str6.equals("") || (str2 = reserve.shengpiziMask) == null || str2.equals("")) {
            str = "";
        } else {
            str = reserve.shengpiziMask + "|" + reserve.shengpiziMD5;
        }
        if (str != null && !str.equals("")) {
            qqwalletaio_resv_qqwalletaio_body_resv.bytes_rareword_rule.set(ByteStringMicro.copyFromUtf8(str));
        }
        qqwalletaio_resv_qqwalletaio_body_resv.uint32_pay_flag.set(reserve.payFlag);
        qqwalletaio_resv_qqwalletaio_body_resv.uint32_hb_flag.set(reserve.hbFlag);
        qqwalletaio_resv_qqwalletaio_body_resv.uint32_avatar_id.set(reserve.avatarId);
        qqwalletaio_resv_qqwalletaio_body_resv.uint32_cover_id.set(reserve.coverId);
        String str7 = reserve.zplanSenderUin;
        if (str7 != null && !str7.equals("")) {
            qqwalletaio_resv_qqwalletaio_body_resv.bytes_zplan_uin.set(ByteStringMicro.copyFromUtf8(reserve.zplanSenderUin));
        }
        byte[] byteArray = qqwalletaio_resv_qqwalletaio_body_resv.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "resv.toByteArray()");
        return byteArray;
    }

    private final MsgRecord i(MessageRecord mr5) {
        int i3;
        if (mr5 instanceof ChatMessage) {
            ((ChatMessage) mr5).parse();
        }
        Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForVideo");
        MessageForVideo messageForVideo = (MessageForVideo) mr5;
        MsgElement msgElement = new MsgElement();
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        boolean z16 = messageForVideo.isVideo;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        int i16 = i3;
        int q16 = VideoMsgTools.q(messageForVideo.type, z16, messageForVideo.isSend());
        long j3 = messageForVideo.time;
        String str = messageForVideo.text;
        if (str == null) {
            str = "";
        }
        msgElement.setAvRecordElement(new AVRecordElement(q16, j3, str, i16, messageForVideo.isread, 0));
        arrayList.add(msgElement);
        return e(arrayList, mr5);
    }

    private final MsgRecord j(MessageRecord mr5) {
        ArrayList<MsgElement> arrayList;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i3;
        Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForAioGift");
        MessageForAioGift messageForAioGift = (MessageForAioGift) mr5;
        MsgElement msgElement = new MsgElement();
        ArrayList<MsgElement> arrayList2 = new ArrayList<>();
        Msg$ReserveInfo msg$ReserveInfo = messageForAioGift.mReserveInfo;
        if (msg$ReserveInfo != null) {
            int i16 = msg$ReserveInfo.send_type.get();
            boolean z16 = messageForAioGift.mReserveInfo.need_play_animation.get();
            int i17 = messageForAioGift.mReserveInfo.charm_value.get();
            List<Msg$SpendCoinItem> coinItemList = messageForAioGift.mReserveInfo.spend_coins.get();
            ArrayList arrayList3 = new ArrayList();
            Intrinsics.checkNotNullExpressionValue(coinItemList, "coinItemList");
            for (Msg$SpendCoinItem msg$SpendCoinItem : coinItemList) {
                arrayList3.add(new VASGiftSpendCoinItem(msg$SpendCoinItem.coin_type.get(), msg$SpendCoinItem.amt.get()));
            }
            long j3 = messageForAioGift.mGiftId;
            String str7 = messageForAioGift.mGiftName;
            if (str7 == null) {
                str = "";
            } else {
                str = str7;
            }
            long j16 = messageForAioGift.mRecUin;
            long j17 = messageForAioGift.mSendUin;
            String str8 = messageForAioGift.mRecNickname;
            if (str8 == null) {
                str2 = "";
            } else {
                str2 = str8;
            }
            String str9 = messageForAioGift.mSendNickName;
            if (str9 == null) {
                str3 = "";
            } else {
                str3 = str9;
            }
            long j18 = messageForAioGift.mPrice;
            String str10 = messageForAioGift.mOrderId;
            if (str10 == null) {
                str4 = "";
            } else {
                str4 = str10;
            }
            String str11 = messageForAioGift.mBgImage;
            if (str11 == null) {
                str5 = "";
            } else {
                str5 = str11;
            }
            long j19 = messageForAioGift.mTianQuanId;
            int i18 = messageForAioGift.mGiftLevel;
            String str12 = messageForAioGift.mPaddingTop;
            if (str12 == null) {
                i3 = i18;
                str6 = "";
            } else {
                str6 = str12;
                i3 = i18;
            }
            msgElement.setTextGiftElement(new TextGiftElement(j3, str, j16, j17, str2, str3, j18, str4, str5, j19, i3, str6, arrayList3, z16, i16, i17));
            arrayList = arrayList2;
            arrayList.add(msgElement);
        } else {
            arrayList = arrayList2;
        }
        return e(arrayList, mr5);
    }

    private final MsgRecord k(MessageRecord mr5) {
        Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForLocationShare");
        MsgElement msgElement = new MsgElement();
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        String str = ((MessageForLocationShare) mr5).f203106msg;
        if (str == null) {
            str = "";
        }
        msgElement.shareLocationElement = new ShareLocationElement(str, "");
        arrayList.add(msgElement);
        return e(arrayList, mr5);
    }

    private final MsgRecord l(MessageRecord mr5) {
        Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForPokeEmo");
        MessageForPokeEmo messageForPokeEmo = (MessageForPokeEmo) mr5;
        MsgElement msgElement = new MsgElement();
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        if (messageForPokeEmo.isNeedPlayed) {
            byte[] bytes = "{\"isPlayed\" : \"false\"}".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            msgElement.setExtBufForUI(bytes);
        } else {
            byte[] bytes2 = "{\"isPlayed\" : \"true\"}".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            msgElement.setExtBufForUI(bytes2);
        }
        SmallYellowFaceInfo smallYellowFaceInfo = new SmallYellowFaceInfo();
        smallYellowFaceInfo.setIndex(messageForPokeEmo.emoIndex);
        String str = messageForPokeEmo.emoString;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        smallYellowFaceInfo.setText(str);
        String str3 = messageForPokeEmo.emoCompat;
        if (str3 == null) {
            str3 = "";
        }
        smallYellowFaceInfo.setCompatibleText(str3);
        smallYellowFaceInfo.setBuf(String.valueOf(messageForPokeEmo.emoIndex));
        FaceBubbleElement faceBubbleElement = new FaceBubbleElement();
        faceBubbleElement.setFaceType(messageForPokeEmo.pokeemoId);
        faceBubbleElement.setFaceCount(Integer.valueOf(messageForPokeEmo.pokeemoPressCount));
        String str4 = messageForPokeEmo.summary;
        if (str4 == null) {
            str4 = "";
        }
        faceBubbleElement.setFaceSummary(str4);
        String str5 = messageForPokeEmo.f203106msg;
        if (str5 != null) {
            str2 = str5;
        }
        faceBubbleElement.setContent(str2);
        faceBubbleElement.setYellowFaceInfo(smallYellowFaceInfo);
        msgElement.setFaceBubbleElement(faceBubbleElement);
        arrayList.add(msgElement);
        return e(arrayList, mr5);
    }

    private final MsgRecord m(MessageRecord mr5) {
        Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForPoke");
        MessageForPoke messageForPoke = (MessageForPoke) mr5;
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        MsgElement msgElement = new MsgElement();
        FaceElement faceElement = new FaceElement();
        faceElement.pokeType = Integer.valueOf(messageForPoke.interactType);
        faceElement.doubleHit = Integer.valueOf(messageForPoke.doubleHitState);
        faceElement.vaspokeId = Integer.valueOf(messageForPoke.subId);
        String str = messageForPoke.name;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        faceElement.vaspokeName = str;
        String str3 = messageForPoke.minVersion;
        if (str3 != null) {
            str2 = str3;
        }
        faceElement.vaspokeMinver = str2;
        faceElement.pokeStrength = Integer.valueOf(messageForPoke.strength);
        faceElement.pokeFlag = Integer.valueOf(messageForPoke.flag);
        msgElement.faceElement = faceElement;
        if (messageForPoke.isPlayed) {
            byte[] bytes = "{\"isPlayed\" : \"true\"}".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            msgElement.setExtBufForUI(bytes);
        } else {
            byte[] bytes2 = "{\"isPlayed\" : \"false\"}".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            msgElement.setExtBufForUI(bytes2);
        }
        arrayList.add(msgElement);
        return e(arrayList, mr5);
    }

    private final MsgRecord n(MessageRecord mr5) {
        long j3;
        ArrayList<MsgElement> arrayList;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        int i3;
        byte[] bArr;
        String str14;
        String str15;
        String str16;
        byte[] bArr2;
        boolean isSender;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        WalletAio walletAio;
        WalletAio walletAio2;
        String str29;
        Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForQQWalletMsg");
        MessageForQQWalletMsg messageForQQWalletMsg = (MessageForQQWalletMsg) mr5;
        MsgElement msgElement = new MsgElement();
        ArrayList<MsgElement> arrayList2 = new ArrayList<>();
        String str30 = messageForQQWalletMsg.senderuin;
        if (str30 != null && !str30.equals("")) {
            String str31 = messageForQQWalletMsg.senderuin;
            Intrinsics.checkNotNullExpressionValue(str31, "walletMsg.senderuin");
            j3 = Long.parseLong(str31);
        } else {
            j3 = 0;
        }
        long j16 = j3;
        QQWalletTransferMsg qQWalletTransferMsg = messageForQQWalletMsg.mQQWalletTransferMsg;
        if (qQWalletTransferMsg != null && qQWalletTransferMsg.elem != null) {
            byte[] bArr3 = new byte[0];
            QQWalletAioBodyReserve qQWalletAioBodyReserve = qQWalletTransferMsg.body;
            if (qQWalletAioBodyReserve != null) {
                Intrinsics.checkNotNullExpressionValue(qQWalletAioBodyReserve, "mr.mQQWalletTransferMsg.body");
                bArr2 = f(qQWalletAioBodyReserve);
            } else {
                bArr2 = bArr3;
            }
            if (messageForQQWalletMsg.messageType == 16) {
                isSender = false;
            } else {
                isSender = messageForQQWalletMsg.isSender();
            }
            vk2.b bVar = messageForQQWalletMsg.mQQWalletTransferMsg.elem;
            int i16 = bVar.f441763a;
            int i17 = bVar.f441764b;
            String str32 = bVar.f441765c;
            if (str32 == null) {
                str32 = "";
            }
            String str33 = bVar.f441766d;
            if (str33 == null) {
                str17 = "";
            } else {
                str17 = str33;
            }
            String str34 = bVar.f441767e;
            if (str34 == null) {
                str18 = "";
            } else {
                str18 = str34;
            }
            String str35 = bVar.f441768f;
            if (str35 == null) {
                str19 = "";
            } else {
                str19 = str35;
            }
            String str36 = bVar.f441769g;
            if (str36 == null) {
                str20 = "";
            } else {
                str20 = str36;
            }
            String str37 = bVar.f441770h;
            if (str37 == null) {
                str21 = "";
            } else {
                str21 = str37;
            }
            int i18 = bVar.f441771i;
            int i19 = bVar.f441772j;
            String str38 = bVar.f441773k;
            if (str38 == null) {
                str22 = "";
            } else {
                str22 = str38;
            }
            String str39 = bVar.f441774l;
            if (str39 == null) {
                str23 = "";
            } else {
                str23 = str39;
            }
            String str40 = bVar.f441775m;
            if (str40 == null) {
                str24 = "";
            } else {
                str24 = str40;
            }
            String str41 = bVar.f441776n;
            if (str41 == null) {
                str25 = "";
            } else {
                str25 = str41;
            }
            int i26 = bVar.f441777o;
            int i27 = bVar.f441778p;
            String str42 = bVar.f441779q;
            if (str42 == null) {
                str26 = "";
            } else {
                str26 = str42;
            }
            String str43 = bVar.f441780r;
            if (str43 == null) {
                str27 = "";
            } else {
                str27 = str43;
            }
            String str44 = bVar.f441781s;
            if (str44 == null) {
                str28 = "";
            } else {
                str28 = str44;
            }
            WalletAio walletAio3 = new WalletAio(i16, i17, str32, str17, str18, str19, str20, str21, i18, i19, str22, str23, "", str24, str25, i26, i27, str26, str27, str28, bArr2);
            if (isSender) {
                walletAio = walletAio3;
            } else {
                walletAio = new WalletAio();
            }
            if (!isSender) {
                walletAio2 = walletAio3;
            } else {
                walletAio2 = new WalletAio();
            }
            int channelId = messageForQQWalletMsg.mQQWalletTransferMsg.getChannelId();
            QQWalletTransferMsg qQWalletTransferMsg2 = messageForQQWalletMsg.mQQWalletTransferMsg;
            int i28 = qQWalletTransferMsg2.templateId;
            int resend = qQWalletTransferMsg2.getResend();
            String str45 = messageForQQWalletMsg.mQQWalletTransferMsg.listId;
            if (str45 == null) {
                str29 = "";
            } else {
                str29 = str45;
            }
            msgElement.setWalletElement(new WalletElement(j16, walletAio, walletAio2, channelId, i28, resend, 2, 0, str29, "", messageForQQWalletMsg.istroop, messageForQQWalletMsg.messageType, 0, "", 0, 0, new byte[0], new byte[0], 0, new ArrayList(), bArr2, 0, 0L));
            arrayList = arrayList2;
            arrayList.add(msgElement);
        } else {
            arrayList = arrayList2;
            QQWalletRedPacketMsg qQWalletRedPacketMsg = messageForQQWalletMsg.mQQWalletRedPacketMsg;
            if (qQWalletRedPacketMsg != null && qQWalletRedPacketMsg.elem != null) {
                byte[] bArr4 = new byte[0];
                QQWalletAioBodyReserve qQWalletAioBodyReserve2 = qQWalletRedPacketMsg.body;
                if (qQWalletAioBodyReserve2 != null) {
                    Intrinsics.checkNotNullExpressionValue(qQWalletAioBodyReserve2, "mr.mQQWalletRedPacketMsg.body");
                    bArr4 = f(qQWalletAioBodyReserve2);
                }
                byte[] bArr5 = bArr4;
                vk2.b bVar2 = messageForQQWalletMsg.mQQWalletRedPacketMsg.elem;
                int i29 = bVar2.f441763a;
                int i36 = bVar2.f441764b;
                String str46 = bVar2.f441765c;
                if (str46 == null) {
                    str = "";
                } else {
                    str = str46;
                }
                String str47 = bVar2.f441766d;
                if (str47 == null) {
                    str2 = "";
                } else {
                    str2 = str47;
                }
                String str48 = bVar2.f441767e;
                if (str48 == null) {
                    str3 = "";
                } else {
                    str3 = str48;
                }
                String str49 = bVar2.f441768f;
                if (str49 == null) {
                    str4 = "";
                } else {
                    str4 = str49;
                }
                String str50 = bVar2.f441769g;
                if (str50 == null) {
                    str5 = "";
                } else {
                    str5 = str50;
                }
                String str51 = bVar2.f441770h;
                if (str51 == null) {
                    str6 = "";
                } else {
                    str6 = str51;
                }
                int i37 = bVar2.f441771i;
                int i38 = bVar2.f441772j;
                String str52 = bVar2.f441773k;
                if (str52 == null) {
                    str7 = "";
                } else {
                    str7 = str52;
                }
                String str53 = bVar2.f441774l;
                if (str53 == null) {
                    str8 = "";
                } else {
                    str8 = str53;
                }
                String str54 = bVar2.f441775m;
                if (str54 == null) {
                    str9 = "";
                } else {
                    str9 = str54;
                }
                String str55 = bVar2.f441776n;
                if (str55 == null) {
                    str10 = "";
                } else {
                    str10 = str55;
                }
                int i39 = bVar2.f441777o;
                int i46 = bVar2.f441778p;
                String str56 = bVar2.f441779q;
                if (str56 == null) {
                    str11 = "";
                } else {
                    str11 = str56;
                }
                String str57 = bVar2.f441780r;
                if (str57 == null) {
                    str12 = "";
                } else {
                    str12 = str57;
                }
                String str58 = bVar2.f441781s;
                if (str58 == null) {
                    i3 = i38;
                    str13 = "";
                } else {
                    str13 = str58;
                    i3 = i38;
                }
                WalletAio walletAio4 = new WalletAio(i29, i36, str, str2, str3, str4, str5, str6, i37, i3, str7, str8, "", str9, str10, i39, i46, str11, str12, str13, bArr5);
                byte[] bArr6 = new byte[0];
                String str59 = messageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketIndex;
                if (str59 != null && !str59.equals("")) {
                    String str60 = messageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketIndex;
                    Intrinsics.checkNotNullExpressionValue(str60, "walletMsg.mQQWalletRedPacketMsg.redPacketIndex");
                    byte[] bytes = str60.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    bArr = bytes;
                } else {
                    bArr = bArr6;
                }
                WalletAio walletAio5 = new WalletAio();
                int channelId2 = messageForQQWalletMsg.mQQWalletRedPacketMsg.getChannelId();
                QQWalletRedPacketMsg qQWalletRedPacketMsg2 = messageForQQWalletMsg.mQQWalletRedPacketMsg;
                int i47 = qQWalletRedPacketMsg2.templateId;
                int resend2 = qQWalletRedPacketMsg2.getResend();
                QQWalletRedPacketMsg qQWalletRedPacketMsg3 = messageForQQWalletMsg.mQQWalletRedPacketMsg;
                int i48 = qQWalletRedPacketMsg3.redtype;
                String str61 = qQWalletRedPacketMsg3.redPacketId;
                if (str61 == null) {
                    str14 = "";
                } else {
                    str14 = str61;
                }
                String str62 = qQWalletRedPacketMsg3.authkey;
                if (str62 == null) {
                    str15 = "";
                } else {
                    str15 = str62;
                }
                int i49 = messageForQQWalletMsg.istroop;
                int i56 = messageForQQWalletMsg.messageType;
                int i57 = qQWalletRedPacketMsg3.envelopeid;
                String str63 = qQWalletRedPacketMsg3.envelopeName;
                if (str63 == null) {
                    str16 = "";
                } else {
                    str16 = str63;
                }
                msgElement.setWalletElement(new WalletElement(0L, walletAio5, walletAio4, channelId2, i47, resend2, 3, i48, str14, str15, i49, i56, i57, str16, qQWalletRedPacketMsg3.conftype, qQWalletRedPacketMsg3.msgFrom, new byte[0], bArr, qQWalletRedPacketMsg3.redChannel, new ArrayList(messageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList), bArr5, 0, 0L));
                arrayList.add(msgElement);
            } else {
                return null;
            }
        }
        return e(arrayList, mr5);
    }

    private final void s(MessageRecord mr5) {
        ArrayList<com.tencent.mobileqq.msgbackup.controller.d> arrayList = mRichProcessorList;
        if (arrayList != null) {
            Iterator<com.tencent.mobileqq.msgbackup.controller.d> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.msgbackup.controller.d next = it.next();
                if (next.a(mr5)) {
                    next.d(mr5);
                    return;
                }
            }
        }
    }

    private final MsgRecord u(MessageRecord mr5) {
        int i3 = mr5.msgtype;
        if (i3 == -5012) {
            return m(mr5);
        }
        if (i3 == -5018) {
            return l(mr5);
        }
        if (i3 == -2025) {
            return n(mr5);
        }
        if (i3 != -2009 && i3 != -2016 && i3 != -2026 && i3 != -2046 && i3 != -4073) {
            if (i3 == -5009) {
                return j(mr5);
            }
            if (i3 == -2076) {
                return k(mr5);
            }
            if (ad.M(i3)) {
                return UniteGrayTipMigrationUtil.f359680a.n(mr5);
            }
            return null;
        }
        return i(mr5);
    }

    private final void w(MessageRecord mr5, ArrayList<ImportMsgRecordFileInfo> fileInfos, QQAppInterface app) {
        String str;
        String str2;
        int i3 = mr5.msgtype;
        String str3 = "";
        if (i3 == -2005) {
            FileManagerEntity fileManagerEntityByMsgFile = FileManagerUtil.getFileManagerEntityByMsgFile(app, (MessageForFile) mr5);
            ArrayList arrayList = new ArrayList();
            String str4 = fileManagerEntityByMsgFile.strFilePath;
            if (str4 != null) {
                arrayList.add(new ImportMsgFilePath(1, str4));
            }
            String str5 = fileManagerEntityByMsgFile.strThumbPath;
            if (str5 != null) {
                arrayList.add(new ImportMsgFilePath(2, str5));
            }
            int i16 = fileManagerEntityByMsgFile.nFileType;
            int i17 = fileManagerEntityByMsgFile.status;
            String str6 = fileManagerEntityByMsgFile.Uuid;
            if (str6 != null) {
                str3 = str6;
            }
            fileInfos.add(new ImportMsgRecordFileInfo(i16, i17, str3, arrayList));
            return;
        }
        if (i3 == -2022) {
            Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForShortVideo");
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) mr5;
            ArrayList arrayList2 = new ArrayList();
            String i18 = com.tencent.mobileqq.shortvideo.j.i(messageForShortVideo);
            if (i18 != null) {
                arrayList2.add(new ImportMsgFilePath(1, i18));
            }
            int i19 = messageForShortVideo.videoFileStatus;
            String str7 = messageForShortVideo.uuid;
            if (str7 != null) {
                str3 = str7;
            }
            fileInfos.add(new ImportMsgRecordFileInfo(2, i19, str3, arrayList2));
            return;
        }
        if (i3 == -2002) {
            Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForPtt");
            MessageForPtt messageForPtt = (MessageForPtt) mr5;
            ArrayList arrayList3 = new ArrayList();
            String localFilePath = messageForPtt.getLocalFilePath();
            if (localFilePath != null) {
                arrayList3.add(new ImportMsgFilePath(1, localFilePath));
            }
            String str8 = messageForPtt.urlAtServer;
            int i26 = messageForPtt.istroop;
            if (i26 == 1 || i26 == 3000) {
                str8 = messageForPtt.groupFileKeyStr;
            }
            if (str8 != null) {
                str3 = str8;
            }
            fileInfos.add(new ImportMsgRecordFileInfo(3, 0, str3, arrayList3));
            return;
        }
        if (i3 == -2017) {
            Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForTroopFile");
            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) mr5;
            t m3 = TroopFileUtils.m(app, messageForTroopFile);
            ArrayList arrayList4 = new ArrayList();
            String str9 = m3.f294978l;
            if (str9 != null) {
                arrayList4.add(new ImportMsgFilePath(1, str9));
            }
            String str10 = m3.f294980n;
            if (str10 != null) {
                arrayList4.add(new ImportMsgFilePath(6, str10));
            }
            if (str10 == null && (str2 = m3.f294981o) != null) {
                arrayList4.add(new ImportMsgFilePath(5, str2));
                str10 = str2;
            }
            if (str10 == null && (str = m3.f294979m) != null) {
                arrayList4.add(new ImportMsgFilePath(4, str));
            }
            int fileType = FileManagerUtil.getFileType(messageForTroopFile.fileName);
            int i27 = m3.f294972f;
            String str11 = messageForTroopFile.url;
            if (str11 != null) {
                str3 = str11;
            }
            fileInfos.add(new ImportMsgRecordFileInfo(fileType, i27, str3, arrayList4));
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            mRichProcessorList = null;
        }
    }

    @NotNull
    public final AndroidImportParseMsgs b(@NotNull AndroidImportQueryParam queryParam) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (AndroidImportParseMsgs) iPatchRedirector.redirect((short) 12, (Object) this, (Object) queryParam);
        }
        Intrinsics.checkNotNullParameter(queryParam, "queryParam");
        String str = queryParam.tableName;
        Intrinsics.checkNotNullExpressionValue(str, "queryParam.tableName");
        String o16 = o(str, queryParam.startIndex, queryParam.count);
        if (o16 != null && !Intrinsics.areEqual(o16, "")) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            if (qQAppInterface == null) {
                QLog.d("NTMsgMigration.Util", 2, "getAndroidImportParseMsgs app is null");
                return new AndroidImportParseMsgs();
            }
            IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IMessageFacade.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IM\u2026va, ProcessConstant.MAIN)");
            IMessageFacade iMessageFacade = (IMessageFacade) runtimeService;
            int i3 = 0;
            if (queryParam.isQuickDb) {
                long currentTimeMillis = System.currentTimeMillis();
                QLog.d("NTMsgMigration.Util", 1, "getQuickDbMessage sql:" + o16);
                List<MessageRecord> msgList = iMessageFacade.getQuickDbMessage(o16, queryParam.tableName);
                Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
                if (!msgList.isEmpty()) {
                    i3 = (int) msgList.get(msgList.size() - 1).getId();
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
                return t(msgList, msgList.size(), i3, currentTimeMillis2);
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            QLog.d("NTMsgMigration.Util", 1, "getSlowDbMessage sql:" + o16);
            List<MessageRecord> msgList2 = iMessageFacade.getSlowDbMessage(o16, queryParam.tableName);
            Intrinsics.checkNotNullExpressionValue(msgList2, "msgList");
            if (!msgList2.isEmpty()) {
                i3 = (int) msgList2.get(msgList2.size() - 1).getId();
            }
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
            Intrinsics.checkNotNullExpressionValue(msgList2, "msgList");
            return t(msgList2, msgList2.size(), i3, currentTimeMillis4);
        }
        return new AndroidImportParseMsgs();
    }

    @NotNull
    public final AndroidImportSessionInfo c() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AndroidImportSessionInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        List<Entity> list = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.d("NTMsgMigration.Util", 2, "getAndroidImportSessionInfos app is null");
            return new AndroidImportSessionInfo();
        }
        RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
        boolean z16 = true;
        if (m3 != null) {
            List<RecentUser> recentList = m3.getRecentList(true);
            Intrinsics.checkNotNullExpressionValue(recentList, "recentList");
            for (RecentUser recentUser : recentList) {
                arrayList.add(new ImportRecentUser(recentUser.uin, recentUser.type));
            }
        }
        try {
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            Intrinsics.checkNotNullExpressionValue(createEntityManager, "app.getEntityManagerFact\u2026y().createEntityManager()");
            List<Entity> rawQuery = DBMethodProxy.rawQuery(createEntityManager, Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_friend_%_New\" or tbl_name like \"mr_troop_%_New\" or tbl_name like \"mr_discusssion_%_New\" or tbl_name like \"mr_temp_game_msg_%_New\" or tbl_name like \"mr_contact_%_New\"", null);
            if (rawQuery instanceof List) {
                list = rawQuery;
            }
            if (list == null || !(!list.isEmpty())) {
                z16 = false;
            }
            if (z16) {
                Iterator<Entity> it = list.iterator();
                while (it.hasNext()) {
                    Sqlite sqlite = (Sqlite) it.next();
                    String decode = SecurityUtile.decode(sqlite.tbl_name);
                    sqlite.tbl_name = decode;
                    arrayList2.add(decode);
                }
            }
        } catch (Throwable unused) {
            QLog.d("NTMsgMigration.Util", 2, "getAndroidImportSessionInfos Throwable");
        }
        return new AndroidImportSessionInfo(arrayList, arrayList2);
    }

    @NotNull
    public final AndroidImportTableInfo d(@NotNull String tableName) {
        QQAppInterface qQAppInterface;
        String str;
        long j3;
        long j16;
        String str2;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AndroidImportTableInfo) iPatchRedirector.redirect((short) 8, (Object) this, (Object) tableName);
        }
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str3 = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.d("NTMsgMigration.Util", 2, "getAndroidImportSessionInfos app is null");
            return new AndroidImportTableInfo();
        }
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IMessageFacade.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        IMessageFacade iMessageFacade = (IMessageFacade) runtimeService;
        int m3 = ad.m(tableName);
        int quickDBMsgCount = iMessageFacade.getQuickDBMsgCount(tableName, -1L, -1L, false);
        int slowDBMsgCount = iMessageFacade.getSlowDBMsgCount(tableName, -1L, -1L, false);
        QRouteApi api = QRoute.api(IMessageFacadeService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n            IMessag\u2026ice::class.java\n        )");
        IMessageFacadeService iMessageFacadeService = (IMessageFacadeService) api;
        int i3 = quickDBMsgCount + slowDBMsgCount;
        if (i3 <= 0) {
            QLog.d("NTMsgMigration.Util", 2, "getAndroidImportTableInfos totalCount is " + i3);
            return new AndroidImportTableInfo();
        }
        com.tencent.imcore.message.f messageProxy = iMessageFacadeService.getMessageProxy(qQAppInterface, m3);
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        Intrinsics.checkNotNullExpressionValue(createEntityManager, "app.entityManagerFactory.createEntityManager()");
        Message S = messageProxy.S(tableName, createEntityManager);
        if (S != null) {
            str = S.frienduin;
        } else {
            str = null;
        }
        if (str == null) {
            QLog.d("NTMsgMigration.Util", 2, "getAndroidImportTableInfos frienduin is null");
            return new AndroidImportTableInfo();
        }
        if (ao.t(S.istroop, S.frienduin)) {
            if (quickDBMsgCount > 0) {
                j3 = g(tableName);
            } else {
                j3 = 0;
            }
            if (slowDBMsgCount > 0) {
                j16 = h(tableName);
            } else {
                j16 = 0;
            }
            RecentUserProxy recentUserProxy = qQAppInterface.getRecentUserProxy();
            if (recentUserProxy == null) {
                recentUserProxy = null;
            }
            if (recentUserProxy != null) {
                try {
                    RecentUser findRecentUserByUin = recentUserProxy.findRecentUserByUin(S.frienduin, S.istroop);
                    IRuntimeService runtimeService2 = qQAppInterface.getRuntimeService(ITroopInfoService.class, "");
                    Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(\n \u2026AIN\n                    )");
                    str3 = ((ITroopInfoService) runtimeService2).getTroopCodeByTroopUin(findRecentUserByUin.troopUin);
                } catch (Throwable unused) {
                    QLog.d("NTMsgMigration.Util", 2, "findRecentUserByUin Throwable:" + S.frienduin + " " + S.istroop);
                }
            }
            byte[] tempSessionSig = FileManagerUtil.getTempSessionSig(qQAppInterface, S.frienduin, (int) FileManagerUtil.getTempSessionType(S.istroop));
            String str4 = S.frienduin;
            int i16 = S.istroop;
            if (str3 == null) {
                str2 = "";
            } else {
                str2 = str3;
            }
            if (tempSessionSig == null) {
                bArr = new byte[0];
            } else {
                bArr = tempSessionSig;
            }
            return new AndroidImportTableInfo(tableName, str4, quickDBMsgCount, slowDBMsgCount, i16, j3, j16, str2, bArr);
        }
        return new AndroidImportTableInfo();
    }

    @NotNull
    public final MsgRecord e(@NotNull ArrayList<MsgElement> msgElements, @NotNull MessageRecord mr5) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgElements, (Object) mr5);
        }
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        Intrinsics.checkNotNullParameter(mr5, "mr");
        long j3 = mr5.uniseq;
        long j16 = mr5.msgUid;
        long j17 = mr5.shmsgseq;
        int i3 = mr5.istroop;
        int i16 = mr5.msgtype;
        int i17 = mr5.issend;
        String str3 = mr5.senderuin;
        if (str3 == null) {
            str = "";
        } else {
            str = str3;
        }
        String str4 = mr5.frienduin;
        if (str4 == null) {
            str2 = "";
        } else {
            str2 = str4;
        }
        return new MsgRecord(j3, j16, j17, 0L, i3, i16, 0, i17, str, str2, "", "", 0L, 0L, 0L, mr5.time, new byte[0], mr5.extraflag, "", "", "", "", "", msgElements, new ArrayList(), new ArrayList(), 0L, 0, new ArrayList(), "", new FreqLimitInfo(0, 0, 0L), false, "", "", "", 0L, 0L, new GuildClientIdentity(0, "", new GuildClientIdentityBytes()), true, 0, 0, new FromRoleInfo(), new FromRoleInfo(), new FromRoleInfo(), 0L, false, new byte[0], mr5.shmsgseq, 0, new FoldingInfo(), new MultiTransInfo(), 0L, 0L, new HashMap(), new AnonymousExtInfo(), 0, 0, new byte[0], new GuildMedal(), 0, new byte[0]);
    }

    public final long g(@NotNull String tableName) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, (Object) tableName)).longValue();
        }
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        long j3 = 0;
        if (qQAppInterface == null) {
            QLog.d("NTMsgMigration.Util", 2, "getQuickMaxId app is null");
            return 0L;
        }
        SQLiteDatabase readableDatabase = qQAppInterface.getReadableDatabase();
        if (readableDatabase == null) {
            QLog.d("NTMsgMigration.Util", 2, "getQuickMaxId quickDb is null");
            return 0L;
        }
        String str = "SELECT max(_id) AS MAX_ID FROM " + tableName + ";";
        if (QLog.isDevelopLevel()) {
            QLog.d("NTMsgMigration.Util", 4, " getQuickMaxId sql = " + str);
        }
        try {
            Cursor rawQuery = readableDatabase.rawQuery(str, null);
            boolean z16 = false;
            if (rawQuery != null && rawQuery.getCount() == 1) {
                z16 = true;
            }
            if (z16) {
                try {
                    try {
                        rawQuery.moveToNext();
                        int columnIndex = rawQuery.getColumnIndex("MAX_ID");
                        if (columnIndex >= 0) {
                            j3 = rawQuery.getLong(columnIndex);
                        }
                    } finally {
                        rawQuery.close();
                    }
                } catch (Throwable unused) {
                    QLog.d("NTMsgMigration.Util", 2, "getQuickMaxId err :" + ("SELECT max(_id) AS MAX_ID FROM " + tableName + ";"));
                }
            }
        } catch (Throwable unused2) {
            QLog.d("NTMsgMigration.Util", 2, "getQuickMaxId rawQuery err");
        }
        return j3;
    }

    public final long h(@NotNull String tableName) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this, (Object) tableName)).longValue();
        }
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        long j3 = 0;
        if (qQAppInterface == null) {
            QLog.d("NTMsgMigration.Util", 2, "getSlowMaxId app is null");
            return 0L;
        }
        String currentUin = qQAppInterface.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
        SQLiteDatabase readableDatabase = new com.tencent.mobileqq.persistence.qslowtable.a(currentUin).build(currentUin).getReadableDatabase();
        if (readableDatabase == null) {
            QLog.d("NTMsgMigration.Util", 2, "getSlowMaxId slowDb is null");
            return 0L;
        }
        String str = "SELECT max(_id) AS MAX_ID FROM " + tableName + ";";
        if (QLog.isDevelopLevel()) {
            QLog.d("NTMsgMigration.Util", 4, " getSlowMaxId sql = " + str);
        }
        try {
            Cursor rawQuery = readableDatabase.rawQuery(str, null);
            boolean z16 = false;
            if (rawQuery != null && rawQuery.getCount() == 1) {
                z16 = true;
            }
            if (z16) {
                try {
                    try {
                        rawQuery.moveToNext();
                        int columnIndex = rawQuery.getColumnIndex("MAX_ID");
                        if (columnIndex >= 0) {
                            j3 = rawQuery.getLong(columnIndex);
                        }
                    } finally {
                        rawQuery.close();
                    }
                } catch (Throwable unused) {
                    QLog.d("NTMsgMigration.Util", 2, "getSlowMaxId err :" + ("SELECT max(_id) AS MAX_ID FROM " + tableName + ";"));
                }
            }
        } catch (Throwable unused2) {
            QLog.d("NTMsgMigration.Util", 2, "getSlowMaxId rawQuery err");
        }
        readableDatabase.close();
        return j3;
    }

    @Nullable
    public final String o(@NotNull String tableName, long startIndex, int count) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, this, tableName, Long.valueOf(startIndex), Integer.valueOf(count));
        }
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        String str2 = "select * from " + tableName;
        String str3 = null;
        if (startIndex >= 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format(" _id <= %d ", Arrays.copyOf(new Object[]{Long.valueOf(startIndex)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        } else {
            str = null;
        }
        if (str != null) {
            str3 = " where " + str;
        }
        if (str3 != null) {
            str2 = str2 + str3;
        }
        if (count > 0) {
            return str2 + (" order by _id desc limit " + count);
        }
        return str2;
    }

    public final void p() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ArrayList<com.tencent.mobileqq.msgbackup.controller.d> arrayList = new ArrayList<>();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            QLog.d("NTMsgMigration.Util", 1, "mRichProcessorList init");
            arrayList.add(new com.tencent.mobileqq.msgbackup.controller.g(qQAppInterface));
            arrayList.add(new com.tencent.mobileqq.msgbackup.controller.l(qQAppInterface));
            arrayList.add(new com.tencent.mobileqq.msgbackup.controller.f(qQAppInterface));
        }
        mRichProcessorList = arrayList;
    }

    public final boolean q() {
        QQAppInterface qQAppInterface;
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.d("NTMsgMigration.Util", 2, "isHasMsgRecordToImport app is null");
            return false;
        }
        try {
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            Intrinsics.checkNotNullExpressionValue(createEntityManager, "app.getEntityManagerFact\u2026y().createEntityManager()");
            List<Entity> rawQuery = DBMethodProxy.rawQuery(createEntityManager, Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_friend_%_New\" or tbl_name like \"mr_troop_%_New\" or tbl_name like \"mr_discusssion_%_New\" or tbl_name like \"mr_temp_game_msg_%_New\" or tbl_name like \"mr_contact_%_New\"", null);
            if (!(rawQuery instanceof List)) {
                rawQuery = null;
            }
            if (rawQuery != null && (!rawQuery.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QRouteApi api = QRoute.api(IMessageFacadeService.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(\n                   \u2026ss.java\n                )");
                IMessageFacadeService iMessageFacadeService = (IMessageFacadeService) api;
                Iterator<Entity> it = rawQuery.iterator();
                while (it.hasNext()) {
                    Sqlite sqlite = (Sqlite) it.next();
                    String decode = SecurityUtile.decode(sqlite.tbl_name);
                    sqlite.tbl_name = decode;
                    Message S = iMessageFacadeService.getMessageProxy(qQAppInterface, ad.m(decode)).S(decode, createEntityManager);
                    if (S != null) {
                        str = S.frienduin;
                    } else {
                        str = null;
                    }
                    if (str != null && ao.t(S.istroop, S.frienduin)) {
                        QLog.d("NTMsgMigration.Util", 2, "isHasMsgRecordToImport tableName:" + decode);
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
            QLog.d("NTMsgMigration.Util", 2, "isHasMsgRecordToImport throwable");
        }
        return false;
    }

    public final boolean r(int msgType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, msgType)).booleanValue();
        }
        if (msgType != -5012 && msgType != -5018 && msgType != -2025 && msgType != -2009 && msgType != -2016 && msgType != -2026 && msgType != -2046 && msgType != -4073 && msgType != -5009 && msgType != -2076 && !ad.M(msgType)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final AndroidImportParseMsgs t(@NotNull List<? extends MessageRecord> msgRecords, int readCount, long nextId, long readDbTimeStamp) {
        QQAppInterface qQAppInterface;
        Iterator it;
        IMultiMsgProxy iMultiMsgProxy;
        ArrayList arrayList;
        IMsgBackupProxy iMsgBackupProxy;
        String str;
        long j3;
        IMsgBackupTempApi iMsgBackupTempApi;
        QQAppInterface qQAppInterface2;
        ArrayList arrayList2;
        String str2;
        char c16;
        byte[] bArr;
        int i3;
        TinyInfo tinyInfo;
        int intValue;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        IMultiMsgProxy iMultiMsgProxy2;
        IMsgBackupProxy iMsgBackupProxy2;
        long j16;
        long j17;
        ArrayList arrayList3;
        ArrayList<ImportMsgRecordFileInfo> arrayList4;
        String str8;
        DataImportGameChatSession dataImportGameChatSession;
        byte[] bArr2;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AndroidImportParseMsgs) iPatchRedirector.redirect((short) 5, this, msgRecords, Integer.valueOf(readCount), Long.valueOf(nextId), Long.valueOf(readDbTimeStamp));
        }
        Intrinsics.checkNotNullParameter(msgRecords, "msgRecords");
        long currentTimeMillis = System.currentTimeMillis();
        String str9 = "NTMsgMigration.Util";
        QLog.d("NTMsgMigration.Util", 1, "parseDbMsgRecords db size=" + msgRecords.size());
        if (msgRecords.isEmpty()) {
            return new AndroidImportParseMsgs();
        }
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.d("NTMsgMigration.Util", 2, "parseDbMsgRecords app is null");
            return new AndroidImportParseMsgs();
        }
        QLog.d("NTMsgMigration.Util", 1, "parseDbMsgRecords parse mr size=" + msgRecords.size());
        List<MessageRecord> v3 = v(qQAppInterface, msgRecords);
        QRouteApi api = QRoute.api(IMsgBackupTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n            IMsgBac\u2026Api::class.java\n        )");
        IMsgBackupTempApi iMsgBackupTempApi2 = (IMsgBackupTempApi) api;
        QRouteApi api2 = QRoute.api(IMultiMsgProxy.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(\n            IMultiM\u2026oxy::class.java\n        )");
        IMultiMsgProxy iMultiMsgProxy3 = (IMultiMsgProxy) api2;
        QRouteApi api3 = QRoute.api(IMsgBackupProxy.class);
        Intrinsics.checkNotNullExpressionValue(api3, "api(IMsgBackupProxy::class.java)");
        IMsgBackupProxy iMsgBackupProxy3 = (IMsgBackupProxy) api3;
        Iterator it5 = v3.iterator();
        while (it5.hasNext()) {
            MessageRecord messageRecord = (MessageRecord) it5.next();
            try {
                r rVar = f359707a;
                if (rVar.r(messageRecord.msgtype)) {
                    MsgRecord u16 = rVar.u(messageRecord);
                    if (u16 != null) {
                        arrayList6.add(u16);
                    }
                    it = it5;
                    qQAppInterface2 = qQAppInterface;
                    j3 = currentTimeMillis;
                    str2 = str9;
                    iMsgBackupTempApi = iMsgBackupTempApi2;
                    arrayList2 = arrayList5;
                    arrayList = arrayList6;
                    iMultiMsgProxy = iMultiMsgProxy3;
                    iMsgBackupProxy = iMsgBackupProxy3;
                } else {
                    ArrayList<ImportMsgRecordFileInfo> arrayList7 = new ArrayList<>();
                    Intrinsics.checkNotNull(messageRecord, "null cannot be cast to non-null type com.tencent.mobileqq.data.ChatMessage");
                    if (iMsgBackupTempApi2.isMultiMsg((ChatMessage) messageRecord)) {
                        HashMap<String, ArrayList<MessageRecord>> queryMultiMsgWithNest = iMultiMsgProxy3.queryMultiMsgWithNest(qQAppInterface, messageRecord);
                        Iterator<ArrayList<MessageRecord>> it6 = queryMultiMsgWithNest.values().iterator();
                        while (it6.hasNext()) {
                            Iterator<MessageRecord> it7 = it6.next().iterator();
                            while (it7.hasNext()) {
                                MessageRecord multiMsg = it7.next();
                                r rVar2 = f359707a;
                                it = it5;
                                try {
                                    Intrinsics.checkNotNullExpressionValue(multiMsg, "multiMsg");
                                    rVar2.s(multiMsg);
                                    rVar2.w(multiMsg, arrayList7, qQAppInterface);
                                    it5 = it;
                                } catch (Throwable unused) {
                                    qQAppInterface2 = qQAppInterface;
                                    j3 = currentTimeMillis;
                                    str = str9;
                                    iMsgBackupTempApi = iMsgBackupTempApi2;
                                    arrayList2 = arrayList5;
                                    arrayList = arrayList6;
                                    iMultiMsgProxy = iMultiMsgProxy3;
                                    iMsgBackupProxy = iMsgBackupProxy3;
                                    str2 = str;
                                    c16 = 2;
                                    QLog.d(str2, 2, "parseSpecialMsgRecords Throwable chat_type:" + messageRecord.istroop + " msg_type:" + messageRecord.msgtype + " msg_uid:" + messageRecord.msgUid);
                                    arrayList5 = arrayList2;
                                    str9 = str2;
                                    qQAppInterface = qQAppInterface2;
                                    iMsgBackupTempApi2 = iMsgBackupTempApi;
                                    currentTimeMillis = j3;
                                    iMsgBackupProxy3 = iMsgBackupProxy;
                                    arrayList6 = arrayList;
                                    iMultiMsgProxy3 = iMultiMsgProxy;
                                    it5 = it;
                                }
                            }
                        }
                        it = it5;
                        bArr = iMultiMsgProxy3.packPbFromMultiMsgWithNest(qQAppInterface, queryMultiMsgWithNest, null, true);
                    } else {
                        it = it5;
                        rVar.s(messageRecord);
                        bArr = null;
                    }
                    if (messageRecord.msgtype == -10000 && messageRecord.f203106msg.length() > 6) {
                        String str10 = messageRecord.f203106msg;
                        Intrinsics.checkNotNullExpressionValue(str10, "mr.msg");
                        String substring = str10.substring(6);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        messageRecord.f203106msg = substring;
                    }
                    if (messageRecord.msgtype == -1049 && ((i16 = messageRecord.istroop) == 1 || i16 == 3000)) {
                        messageRecord.atInfoList = null;
                        messageRecord.saveExtInfoToExtStr("sens_reply_special_msg", "");
                    }
                    Object transToBackupEntity = iMsgBackupProxy3.transToBackupEntity(qQAppInterface, messageRecord, true);
                    if (transToBackupEntity != null) {
                        Intrinsics.checkNotNullExpressionValue(transToBackupEntity, "transToBackupEntity(app, mr, true)");
                        MsgBackupMsgEntity msgBackupMsgEntity = (MsgBackupMsgEntity) transToBackupEntity;
                        if (msgBackupMsgEntity.extensionData != null) {
                            f359707a.w(messageRecord, arrayList7, qQAppInterface);
                            if (bArr != null) {
                                i3 = 2;
                            } else {
                                i3 = 1;
                            }
                            byte[] bArr3 = bArr;
                            if (messageRecord.istroop == 10007) {
                                try {
                                    tinyInfo = new TinyInfo();
                                    tinyInfo.parseFromMessageRecord(messageRecord);
                                    String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("ext_key_game_msg_say_hi_type");
                                    if (TextUtils.isEmpty(extInfoFromExtStr)) {
                                        qQAppInterface2 = qQAppInterface;
                                        intValue = 0;
                                    } else {
                                        Integer valueOf = Integer.valueOf(extInfoFromExtStr);
                                        qQAppInterface2 = qQAppInterface;
                                        try {
                                            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(sayHiTypeStr)");
                                            intValue = valueOf.intValue();
                                        } catch (Throwable unused2) {
                                            j3 = currentTimeMillis;
                                            str = str9;
                                            iMsgBackupTempApi = iMsgBackupTempApi2;
                                            arrayList = arrayList6;
                                            iMultiMsgProxy = iMultiMsgProxy3;
                                            iMsgBackupProxy = iMsgBackupProxy3;
                                            arrayList2 = arrayList5;
                                            str2 = str;
                                            c16 = 2;
                                            QLog.d(str2, 2, "parseSpecialMsgRecords Throwable chat_type:" + messageRecord.istroop + " msg_type:" + messageRecord.msgtype + " msg_uid:" + messageRecord.msgUid);
                                            arrayList5 = arrayList2;
                                            str9 = str2;
                                            qQAppInterface = qQAppInterface2;
                                            iMsgBackupTempApi2 = iMsgBackupTempApi;
                                            currentTimeMillis = j3;
                                            iMsgBackupProxy3 = iMsgBackupProxy;
                                            arrayList6 = arrayList;
                                            iMultiMsgProxy3 = iMultiMsgProxy;
                                            it5 = it;
                                        }
                                    }
                                    String str11 = messageRecord.frienduin;
                                    if (str11 == null) {
                                        str3 = "";
                                        iMsgBackupTempApi = iMsgBackupTempApi2;
                                    } else {
                                        iMsgBackupTempApi = iMsgBackupTempApi2;
                                        Intrinsics.checkNotNullExpressionValue(str11, "mr.frienduin?:\"\"");
                                        str3 = str11;
                                    }
                                    String str12 = tinyInfo.fromRoleId;
                                    if (str12 == null) {
                                        str4 = "";
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(str12, "info.fromRoleId?:\"\"");
                                        str4 = str12;
                                    }
                                    String str13 = tinyInfo.fromOpenId;
                                    if (str13 == null) {
                                        str5 = "";
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(str13, "info.fromOpenId?:\"\"");
                                        str5 = str13;
                                    }
                                    String str14 = tinyInfo.toRoleId;
                                    if (str14 == null) {
                                        str6 = "";
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(str14, "info.toRoleId?:\"\"");
                                        str6 = str14;
                                    }
                                    String str15 = tinyInfo.toOpenId;
                                    if (str15 == null) {
                                        str7 = "";
                                    } else {
                                        try {
                                            Intrinsics.checkNotNullExpressionValue(str15, "info.toOpenId?:\"\"");
                                            str7 = str15;
                                        } catch (Throwable unused3) {
                                            j3 = currentTimeMillis;
                                            str = str9;
                                            arrayList = arrayList6;
                                            iMultiMsgProxy = iMultiMsgProxy3;
                                            iMsgBackupProxy = iMsgBackupProxy3;
                                            arrayList2 = arrayList5;
                                            str2 = str;
                                            c16 = 2;
                                            QLog.d(str2, 2, "parseSpecialMsgRecords Throwable chat_type:" + messageRecord.istroop + " msg_type:" + messageRecord.msgtype + " msg_uid:" + messageRecord.msgUid);
                                            arrayList5 = arrayList2;
                                            str9 = str2;
                                            qQAppInterface = qQAppInterface2;
                                            iMsgBackupTempApi2 = iMsgBackupTempApi;
                                            currentTimeMillis = j3;
                                            iMsgBackupProxy3 = iMsgBackupProxy;
                                            arrayList6 = arrayList;
                                            iMultiMsgProxy3 = iMultiMsgProxy;
                                            it5 = it;
                                        }
                                    }
                                    iMultiMsgProxy2 = iMultiMsgProxy3;
                                    iMsgBackupProxy2 = iMsgBackupProxy3;
                                    try {
                                        j16 = tinyInfo.gameAppId;
                                        j3 = currentTimeMillis;
                                    } catch (Throwable unused4) {
                                        iMultiMsgProxy = iMultiMsgProxy2;
                                        j3 = currentTimeMillis;
                                    }
                                } catch (Throwable unused5) {
                                    qQAppInterface2 = qQAppInterface;
                                }
                                try {
                                    j17 = tinyInfo.fromTinyId;
                                    str = str9;
                                    iMsgBackupProxy = iMsgBackupProxy2;
                                } catch (Throwable unused6) {
                                    iMultiMsgProxy = iMultiMsgProxy2;
                                    str = str9;
                                    iMsgBackupProxy = iMsgBackupProxy2;
                                    arrayList = arrayList6;
                                    arrayList2 = arrayList5;
                                    str2 = str;
                                    c16 = 2;
                                    QLog.d(str2, 2, "parseSpecialMsgRecords Throwable chat_type:" + messageRecord.istroop + " msg_type:" + messageRecord.msgtype + " msg_uid:" + messageRecord.msgUid);
                                    arrayList5 = arrayList2;
                                    str9 = str2;
                                    qQAppInterface = qQAppInterface2;
                                    iMsgBackupTempApi2 = iMsgBackupTempApi;
                                    currentTimeMillis = j3;
                                    iMsgBackupProxy3 = iMsgBackupProxy;
                                    arrayList6 = arrayList;
                                    iMultiMsgProxy3 = iMultiMsgProxy;
                                    it5 = it;
                                }
                                try {
                                    long j18 = tinyInfo.toTinyId;
                                    arrayList3 = arrayList5;
                                    arrayList = arrayList6;
                                    try {
                                        long j19 = tinyInfo.windowFlag;
                                        iMultiMsgProxy = iMultiMsgProxy2;
                                        try {
                                            String str16 = tinyInfo.nickName;
                                            if (str16 == null) {
                                                arrayList4 = arrayList7;
                                                str8 = "";
                                            } else {
                                                arrayList4 = arrayList7;
                                                Intrinsics.checkNotNullExpressionValue(str16, "info.nickName?:\"\"");
                                                str8 = str16;
                                            }
                                            dataImportGameChatSession = new DataImportGameChatSession(str3, str4, str5, str6, str7, j16, j17, j18, j19, str8, tinyInfo.redpointSwitch, intValue);
                                        } catch (Throwable unused7) {
                                            arrayList2 = arrayList3;
                                            str2 = str;
                                            c16 = 2;
                                            QLog.d(str2, 2, "parseSpecialMsgRecords Throwable chat_type:" + messageRecord.istroop + " msg_type:" + messageRecord.msgtype + " msg_uid:" + messageRecord.msgUid);
                                            arrayList5 = arrayList2;
                                            str9 = str2;
                                            qQAppInterface = qQAppInterface2;
                                            iMsgBackupTempApi2 = iMsgBackupTempApi;
                                            currentTimeMillis = j3;
                                            iMsgBackupProxy3 = iMsgBackupProxy;
                                            arrayList6 = arrayList;
                                            iMultiMsgProxy3 = iMultiMsgProxy;
                                            it5 = it;
                                        }
                                    } catch (Throwable unused8) {
                                        iMultiMsgProxy = iMultiMsgProxy2;
                                    }
                                } catch (Throwable unused9) {
                                    iMultiMsgProxy = iMultiMsgProxy2;
                                    arrayList = arrayList6;
                                    arrayList2 = arrayList5;
                                    str2 = str;
                                    c16 = 2;
                                    QLog.d(str2, 2, "parseSpecialMsgRecords Throwable chat_type:" + messageRecord.istroop + " msg_type:" + messageRecord.msgtype + " msg_uid:" + messageRecord.msgUid);
                                    arrayList5 = arrayList2;
                                    str9 = str2;
                                    qQAppInterface = qQAppInterface2;
                                    iMsgBackupTempApi2 = iMsgBackupTempApi;
                                    currentTimeMillis = j3;
                                    iMsgBackupProxy3 = iMsgBackupProxy;
                                    arrayList6 = arrayList;
                                    iMultiMsgProxy3 = iMultiMsgProxy;
                                    it5 = it;
                                }
                            } else {
                                qQAppInterface2 = qQAppInterface;
                                arrayList4 = arrayList7;
                                j3 = currentTimeMillis;
                                str = str9;
                                iMsgBackupTempApi = iMsgBackupTempApi2;
                                arrayList3 = arrayList5;
                                arrayList = arrayList6;
                                iMultiMsgProxy = iMultiMsgProxy3;
                                iMsgBackupProxy = iMsgBackupProxy3;
                                dataImportGameChatSession = null;
                            }
                            try {
                                if (messageRecord.istroop == 1008 && messageRecord.msgtype == -5008 && i3 == 1 && messageRecord.mExJsonObject != null) {
                                    String strFlags = messageRecord.getExtInfoFromExtStr(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND);
                                    if (!Intrinsics.areEqual(strFlags, "")) {
                                        Intrinsics.checkNotNullExpressionValue(strFlags, "strFlags");
                                        byte[] bytes = strFlags.getBytes(Charsets.UTF_8);
                                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                                        bArr2 = bytes;
                                        arrayList2 = arrayList3;
                                        arrayList2.add(new ImportMsgPbRecord(i3, bArr2, arrayList4, msgBackupMsgEntity.extensionData, dataImportGameChatSession, Integer.valueOf(messageRecord.extraflag)));
                                    }
                                }
                                arrayList2.add(new ImportMsgPbRecord(i3, bArr2, arrayList4, msgBackupMsgEntity.extensionData, dataImportGameChatSession, Integer.valueOf(messageRecord.extraflag)));
                            } catch (Throwable unused10) {
                                str2 = str;
                                c16 = 2;
                                QLog.d(str2, 2, "parseSpecialMsgRecords Throwable chat_type:" + messageRecord.istroop + " msg_type:" + messageRecord.msgtype + " msg_uid:" + messageRecord.msgUid);
                                arrayList5 = arrayList2;
                                str9 = str2;
                                qQAppInterface = qQAppInterface2;
                                iMsgBackupTempApi2 = iMsgBackupTempApi;
                                currentTimeMillis = j3;
                                iMsgBackupProxy3 = iMsgBackupProxy;
                                arrayList6 = arrayList;
                                iMultiMsgProxy3 = iMultiMsgProxy;
                                it5 = it;
                            }
                            bArr2 = bArr3;
                            arrayList2 = arrayList3;
                        } else {
                            qQAppInterface2 = qQAppInterface;
                            j3 = currentTimeMillis;
                            str = str9;
                            iMsgBackupTempApi = iMsgBackupTempApi2;
                            arrayList2 = arrayList5;
                            arrayList = arrayList6;
                            iMultiMsgProxy = iMultiMsgProxy3;
                            iMsgBackupProxy = iMsgBackupProxy3;
                        }
                        str2 = str;
                    } else {
                        qQAppInterface2 = qQAppInterface;
                        j3 = currentTimeMillis;
                        iMsgBackupTempApi = iMsgBackupTempApi2;
                        arrayList2 = arrayList5;
                        arrayList = arrayList6;
                        iMultiMsgProxy = iMultiMsgProxy3;
                        iMsgBackupProxy = iMsgBackupProxy3;
                        str2 = str9;
                    }
                }
                c16 = 2;
            } catch (Throwable unused11) {
                it = it5;
            }
            arrayList5 = arrayList2;
            str9 = str2;
            qQAppInterface = qQAppInterface2;
            iMsgBackupTempApi2 = iMsgBackupTempApi;
            currentTimeMillis = j3;
            iMsgBackupProxy3 = iMsgBackupProxy;
            arrayList6 = arrayList;
            iMultiMsgProxy3 = iMultiMsgProxy;
            it5 = it;
        }
        String str17 = str9;
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        QLog.d(str17, 1, "parseDbMsgRecords parse pb size=" + arrayList5.size() + " Special size=" + arrayList6.size() + " readDbTimeStamp:" + readDbTimeStamp + " parseMsgTime:" + currentTimeMillis2);
        return new AndroidImportParseMsgs(readCount, nextId, readDbTimeStamp, currentTimeMillis2, arrayList5, arrayList6);
    }

    @NotNull
    public final List<MessageRecord> v(@NotNull QQAppInterface app, @NotNull List<? extends MessageRecord> srcMsgList) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) app, (Object) srcMsgList);
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(srcMsgList, "srcMsgList");
        ArrayList arrayList = new ArrayList();
        QRouteApi api = QRoute.api(IMsgBackupTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n            IMsgBac\u2026Api::class.java\n        )");
        IMsgBackupTempApi iMsgBackupTempApi = (IMsgBackupTempApi) api;
        Iterator<? extends MessageRecord> it = srcMsgList.iterator();
        while (true) {
            boolean z16 = true;
            if (it.hasNext()) {
                MessageRecord next = it.next();
                if (next.msgtype != -2006) {
                    int i16 = next.istroop;
                    if ((i16 == 1 || i16 == 3000) && (((i3 = next.extraflag) == 32768 || i3 == 32772) && next.isSendFromLocal())) {
                        com.tencent.mobileqq.msgbackup.util.f.B(MsgBackupController.Q, "preHandleQianchu..unsupport send not sucess msg _id = %d..,msgtype = %d .", Long.valueOf(next.getId()), Integer.valueOf(next.msgtype));
                    } else if (!(next instanceof ChatMessage)) {
                        com.tencent.mobileqq.msgbackup.util.f.B(MsgBackupController.Q, "preHandleQianchu..unsupport not chatMessage _id = %d...,msgtype = %d .", Long.valueOf(next.getId()), Integer.valueOf(next.msgtype));
                    } else if (!ad.M(next.msgtype) && ad.G(next.msgtype)) {
                        com.tencent.mobileqq.msgbackup.util.f.B(MsgBackupController.Q, "preHandleQianchu..unsupport graytipMsg _id = %d..,msgtype = %d .", Long.valueOf(next.getId()), Integer.valueOf(next.msgtype));
                    } else if (iMsgBackupTempApi.isBeancurdMsg((ChatMessage) next)) {
                        com.tencent.mobileqq.msgbackup.util.f.B(MsgBackupController.Q, "preHandleQianchu..unsupport BeancurdMsg _id = %d..,msgtype = %d .", Long.valueOf(next.getId()), Integer.valueOf(next.msgtype));
                    } else if (iMsgBackupTempApi.isAnonymousMsg(next)) {
                        com.tencent.mobileqq.msgbackup.util.f.B(MsgBackupController.Q, "preHandleQianchu..unsupport AnonymousMsg _id = %d..,msgtype = %d .", Long.valueOf(next.getId()), Integer.valueOf(next.msgtype));
                    } else if (next.msgtype == -2023) {
                        com.tencent.mobileqq.msgbackup.util.f.B(MsgBackupController.Q, "preHandleQianchu..unsupport msgtype MessageForCommonHobbyForAIOShow MSG_TYPE_COMMON_HOBBY_FOR_AIO_SHOW", new Object[0]);
                    } else {
                        int i17 = next.istroop;
                        if ((i17 == 1 || i17 == 3000) && next.shmsgseq <= 0) {
                            com.tencent.mobileqq.msgbackup.util.f.B(MsgBackupController.Q, "preHandleQianchu..unsupport troop or discurss msg shmsgseq <= 0", new Object[0]);
                        } else {
                            boolean isSupportMsgType = iMsgBackupTempApi.isSupportMsgType(app, next);
                            int i18 = next.msgtype;
                            if (i18 != -2002 && i18 != -2071 && i18 != -2007 && i18 != -5008 && i18 != -5017 && i18 != -8018 && i18 != -2011 && !r(i18)) {
                                int i19 = next.msgtype;
                                if (i19 != -5008 && i19 != -5017 && i19 != -4025 && i19 != -4026 && i19 != -4027 && i19 != -4071 && i19 != -4072) {
                                    z16 = isSupportMsgType;
                                } else {
                                    next.msgtype = MessageRecord.MSG_TYPE_ARK_APP;
                                }
                            }
                            if (z16) {
                                arrayList.add(next);
                            } else {
                                MessageRecord changeRichTextToTextMsg = iMsgBackupTempApi.changeRichTextToTextMsg(app, next, iMsgBackupTempApi.getUnsupportMsgStr(app, next), false);
                                if (TextUtils.equals(changeRichTextToTextMsg.senderuin, app.getCurrentAccountUin())) {
                                    Object businessHandler = app.getBusinessHandler(((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName());
                                    Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.vas.svip.api.ISVIPHandler");
                                    ((ISVIPHandler) businessHandler).addSendingBubbleId(changeRichTextToTextMsg);
                                }
                                changeRichTextToTextMsg.setStatus(1000);
                                String str = changeRichTextToTextMsg.f203106msg;
                                Intrinsics.checkNotNullExpressionValue(str, "newCM.msg");
                                byte[] bytes = str.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                                changeRichTextToTextMsg.msgData = bytes;
                                arrayList.add(changeRichTextToTextMsg);
                            }
                        }
                    }
                }
            } else {
                com.tencent.mobileqq.msgbackup.util.f.D(MsgBackupController.Q, "preHandleQianchu..msgSize = %d...", Integer.valueOf(arrayList.size()));
                return arrayList;
            }
        }
    }
}
