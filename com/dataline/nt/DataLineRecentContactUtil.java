package com.dataline.nt;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ContactTopData;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAbstractElementData;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactData;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J0\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J \u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0004j\b\u0012\u0004\u0012\u00020\u0018`\u00062\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eJ\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eJ\u000e\u0010 \u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000eJ\u0016\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010#\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0012J\u0010\u0010%\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010&\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010(\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\fJ\u0016\u0010)\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\fJ\"\u0010,\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000e2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0*J\u0010\u0010.\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u000eR$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0004j\b\u0012\u0004\u0012\u00020\u000e`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/dataline/nt/DataLineRecentContactUtil;", "", "Lcom/tencent/mobileqq/data/DraftTextInfo;", "draftInfo", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactData;", "recentContactData", "", "B", "", "l", "", "peerUin", "", "time", "", "unreadCnt", "sendStatue", "abstractContent", "p", "content", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAbstractElementData;", "i", "uid", "g", "uin", tl.h.F, "peerUid", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "deviceType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "w", "u", "j", "isTop", "y", "r", "Lkotlin/Function1;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "oldPeerUin", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "b", "Ljava/util/ArrayList;", "deleteOldContactFlags", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class DataLineRecentContactUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DataLineRecentContactUtil f32313a = new DataLineRecentContactUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> deleteOldContactFlags = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/dataline/nt/DataLineRecentContactUtil$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "", "result", "", "errMsg", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes2.dex */
    public static final class a implements IOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32315a;

        a(String str) {
            this.f32315a = str;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int result, @Nullable String errMsg) {
            QLog.i("DataLineRecentContactUtil", 1, "[tryDeleteOldContact]deleteRecentContactsV2, result=" + result + ", errMsg=" + errMsg);
            if (result == 0) {
                DataLineRecentContactUtil.deleteOldContactFlags.add(this.f32315a);
            }
        }
    }

    DataLineRecentContactUtil() {
    }

    private final void B(final RecentContactData recentContactData) {
        aa recentContactService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e("DataLineRecentContactUtil", 1, "updateRecentContactToNT, service is null");
            return;
        }
        if (l(recentContactData)) {
            QLog.e("DataLineRecentContactUtil", 1, "updateRecentContactToNT filter invalid data! uid = " + recentContactData.peerUid);
            return;
        }
        recentContactService.upsertRecentContactManually(recentContactData, new IOperateCallback() { // from class: com.dataline.nt.j
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                DataLineRecentContactUtil.C(RecentContactData.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(RecentContactData recentContactData, int i3, String str) {
        Intrinsics.checkNotNullParameter(recentContactData, "$recentContactData");
        QLog.i("DataLineRecentContactUtil", 1, "upsertRecentContactManually uid = " + recentContactData.peerUid + ", onResult:" + i3 + " ,errMsg:" + str);
    }

    private final ArrayList<MsgAbstractElementData> i(String content) {
        MsgAbstractElementData msgAbstractElementData = new MsgAbstractElementData(1, content, "", 0, 0);
        ArrayList<MsgAbstractElementData> arrayList = new ArrayList<>();
        arrayList.add(msgAbstractElementData);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String str) {
        QLog.i("DataLineRecentContactUtil", 1, "[deleteDraft]callback, result = " + i3 + ", errMsg = " + str);
    }

    private final boolean l(RecentContactData recentContactData) {
        if (AppSetting.p(MobileQQ.sMobileQQ)) {
            return Intrinsics.areEqual(recentContactData.peerUid, PeerUid.DATALINE_PAD_UID);
        }
        return Intrinsics.areEqual(recentContactData.peerUid, PeerUid.DATALINE_PHONE_UID);
    }

    private final ArrayList<MsgElement> n(DraftTextInfo draftInfo) {
        boolean z16;
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        if (draftInfo != null) {
            String str = draftInfo.text;
            Intrinsics.checkNotNullExpressionValue(str, "draftInfo.text");
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) QRoute.api(IMsgUtilApi.class);
                String str2 = draftInfo.text;
                Intrinsics.checkNotNullExpressionValue(str2, "draftInfo.text");
                arrayList.add(iMsgUtilApi.createTextElement(str2));
            }
        }
        return arrayList;
    }

    private final RecentContactData p(String peerUin, long time, int unreadCnt, int sendStatue, String abstractContent) {
        String h16 = h(peerUin);
        RecentContactData recentContactData = new RecentContactData(h16, Long.parseLong(peerUin), o(h16), 8, unreadCnt, "", String.valueOf(m(h16)), sendStatue, i(abstractContent), time, null, null, new ArrayList());
        QLog.d("DataLineRecentContactUtil", 2, "getRecentContactData:" + recentContactData + "}");
        return recentContactData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(int i3, String str) {
        QLog.i("DataLineRecentContactUtil", 2, "onResult:" + i3 + " ,errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(int i3, String str) {
        QLog.i("DataLineRecentContactUtil", 1, "setDraft, result = " + i3 + ", errMsg = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.d("DataLineRecentContactUtil", 1, "setMsgRead result: " + i3 + " , errMsg: " + errMsg);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A(int deviceType, long time) {
        String DATALINE_PC_UIN;
        int i3;
        String string;
        String str;
        String str2;
        boolean z16 = false;
        if (deviceType != 0) {
            if (deviceType != 1) {
                if (deviceType != 2) {
                    str = "";
                    str2 = str;
                    if (str.length() == 0) {
                        z16 = true;
                    }
                    if (!z16) {
                        QLog.e("DataLineRecentContactUtil", 1, "updateRecentContact, but uin is empty. it shouldn't happen");
                        return;
                    } else {
                        B(p(str, time, 0, 0, str2));
                        return;
                    }
                }
                DATALINE_PC_UIN = AppConstants.DATALINE_PHONE_UIN;
                Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PHONE_UIN");
                string = MobileQQ.sMobileQQ.getString(R.string.f16270215);
                Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.st\u2026.lite_recent_phoneonline)");
            } else {
                DATALINE_PC_UIN = AppConstants.DATALINE_IPAD_UIN;
                Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_IPAD_UIN");
                string = MobileQQ.sMobileQQ.getString(R.string.f16268213);
                Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.st\u2026ng.lite_recent_padonline)");
            }
        } else {
            DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
            Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105473", false);
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (isSwitchOn) {
                i3 = R.string.f16269214;
            } else {
                i3 = R.string.f171084c50;
            }
            string = mobileQQ.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(if (\u2026ing.lite_recent_pconline)");
        }
        str = DATALINE_PC_UIN;
        str2 = string;
        if (str.length() == 0) {
        }
        if (!z16) {
        }
    }

    @NotNull
    public final String g(@NotNull String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        int hashCode = uid.hashCode();
        if (hashCode != -1834626455) {
            if (hashCode != -1656358474) {
                if (hashCode == 1930502276 && uid.equals(PeerUid.DATALINE_PC_UID)) {
                    String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
                    Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
                    return DATALINE_PC_UIN;
                }
            } else if (uid.equals(PeerUid.DATALINE_PAD_UID)) {
                String DATALINE_IPAD_UIN = AppConstants.DATALINE_IPAD_UIN;
                Intrinsics.checkNotNullExpressionValue(DATALINE_IPAD_UIN, "DATALINE_IPAD_UIN");
                return DATALINE_IPAD_UIN;
            }
        } else if (uid.equals(PeerUid.DATALINE_PHONE_UID)) {
            String DATALINE_PHONE_UIN = AppConstants.DATALINE_PHONE_UIN;
            Intrinsics.checkNotNullExpressionValue(DATALINE_PHONE_UIN, "DATALINE_PHONE_UIN");
            return DATALINE_PHONE_UIN;
        }
        return "";
    }

    @NotNull
    public final String h(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (Intrinsics.areEqual(uin, AppConstants.DATALINE_PC_UIN)) {
            return PeerUid.DATALINE_PC_UID;
        }
        if (Intrinsics.areEqual(uin, AppConstants.DATALINE_IPAD_UIN)) {
            return PeerUid.DATALINE_PAD_UID;
        }
        if (Intrinsics.areEqual(uin, AppConstants.DATALINE_PHONE_UIN)) {
            return PeerUid.DATALINE_PHONE_UID;
        }
        return "";
    }

    public final void j(@Nullable DraftTextInfo draftInfo) {
        if (draftInfo == null) {
            QLog.e("DataLineRecentContactUtil", 1, "deleteDraft draftInfo is null");
            return;
        }
        w msgService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e("DataLineRecentContactUtil", 1, "deleteDraft service is null");
            return;
        }
        String str = draftInfo.uin;
        Intrinsics.checkNotNullExpressionValue(str, "draftInfo.uin");
        msgService.deleteDraft(new Contact(8, h(str), ""), new IOperateCallback() { // from class: com.dataline.nt.i
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str2) {
                DataLineRecentContactUtil.k(i3, str2);
            }
        });
    }

    public final int m(@NotNull String peerUid) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        int hashCode = peerUid.hashCode();
        if (hashCode != -1834626455) {
            if (hashCode != -1656358474) {
                if (hashCode == 1930502276 && peerUid.equals(PeerUid.DATALINE_PC_UID)) {
                    return R.drawable.ogi;
                }
            } else if (peerUid.equals(PeerUid.DATALINE_PAD_UID)) {
                return R.drawable.ogk;
            }
        } else if (peerUid.equals(PeerUid.DATALINE_PHONE_UID)) {
            return R.drawable.ogl;
        }
        return 0;
    }

    @NotNull
    public final String o(@NotNull String peerUid) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        int hashCode = peerUid.hashCode();
        if (hashCode != -1834626455) {
            if (hashCode != -1656358474) {
                if (hashCode == 1930502276 && peerUid.equals(PeerUid.DATALINE_PC_UID)) {
                    String qqStr = HardCodeUtil.qqStr(R.string.c5f);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.lite_title)");
                    return qqStr;
                }
            } else if (peerUid.equals(PeerUid.DATALINE_PAD_UID)) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.RegisterProxySvcPackHandler");
                if (((RegisterProxySvcPackHandler) businessHandler).U2()) {
                    String qqStr2 = HardCodeUtil.qqStr(R.string.c5g);
                    Intrinsics.checkNotNullExpressionValue(qqStr2, "{\n                    Ha\u2026e_ipad)\n                }");
                    return qqStr2;
                }
                String qqStr3 = HardCodeUtil.qqStr(R.string.f16272217);
                Intrinsics.checkNotNullExpressionValue(qqStr3, "{\n                    Ha\u2026le_pad)\n                }");
                return qqStr3;
            }
        } else if (peerUid.equals(PeerUid.DATALINE_PHONE_UID)) {
            String qqStr4 = HardCodeUtil.qqStr(R.string.f16273218);
            Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.lite_title_phone)");
            return qqStr4;
        }
        return "";
    }

    public final void q(@NotNull String uin, @NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).isTop(h(uin), 8, new Function1<Boolean, Unit>() { // from class: com.dataline.nt.DataLineRecentContactUtil$isChatTop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                callback.invoke(Boolean.valueOf(z16));
            }
        });
    }

    public final void r(@NotNull String uin, boolean isTop) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        aa recentContactService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e("DataLineRecentContactUtil", 1, "setDraft service is null");
            return;
        }
        ContactTopData contactTopData = new ContactTopData();
        contactTopData.uid = h(uin);
        contactTopData.uin = Long.parseLong(uin);
        contactTopData.chatType = 8;
        ArrayList<ContactTopData> arrayList = new ArrayList<>();
        arrayList.add(contactTopData);
        recentContactService.setContactListTop(isTop, arrayList, new IOperateCallback() { // from class: com.dataline.nt.k
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                DataLineRecentContactUtil.s(i3, str);
            }
        });
    }

    public final void t(@NotNull String uin) {
        int i3;
        QQAppInterface qQAppInterface;
        ConversationFacade conversationFacade;
        Intrinsics.checkNotNullParameter(uin, "uin");
        int i16 = 0;
        if (Intrinsics.areEqual(uin, AppConstants.DATALINE_PC_UIN)) {
            i16 = 6000;
            i3 = 0;
        } else if (Intrinsics.areEqual(uin, AppConstants.DATALINE_IPAD_UIN)) {
            i16 = 6003;
            i3 = 1;
        } else if (Intrinsics.areEqual(uin, AppConstants.DATALINE_PHONE_UIN)) {
            i16 = 6005;
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (i16 == 0) {
            QLog.e("DataLineRecentContactUtil", 1, "setDataLineMsgRead, but uinType=0. this shouldn't happen.");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null && (conversationFacade = qQAppInterface.getConversationFacade()) != null && conversationFacade.R(uin, i16) > 0) {
            DataLineMsgProxy dataLineMsgProxy = qQAppInterface.getDataLineMsgProxy(i3);
            if (dataLineMsgProxy != null) {
                dataLineMsgProxy.K();
            }
            conversationFacade.r(uin, i16, true);
        }
    }

    public final void u(@Nullable DraftTextInfo draftInfo) {
        if (draftInfo == null) {
            QLog.e("DataLineRecentContactUtil", 1, "setDraft, but draftInfo is null.");
            return;
        }
        w msgService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e("DataLineRecentContactUtil", 1, "setDraft service is null");
            return;
        }
        String str = draftInfo.uin;
        Intrinsics.checkNotNullExpressionValue(str, "draftInfo.uin");
        msgService.setDraft(new Contact(8, h(str), ""), n(draftInfo), new IOperateCallback() { // from class: com.dataline.nt.g
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str2) {
                DataLineRecentContactUtil.v(i3, str2);
            }
        });
    }

    public final void w(int deviceType) {
        String str;
        boolean z16;
        AppInterface appInterface;
        IKernelService iKernelService;
        if (deviceType != 0) {
            if (deviceType != 1) {
                if (deviceType != 2) {
                    str = "";
                } else {
                    str = PeerUid.DATALINE_PHONE_UID;
                }
            } else {
                str = PeerUid.DATALINE_PAD_UID;
            }
        } else {
            str = PeerUid.DATALINE_PC_UID;
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("DataLineRecentContactUtil", 1, "setNTRecentContactMsgRead, but peerUid is empty.");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        w wVar = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null && (iKernelService = (IKernelService) appInterface.getRuntimeService(IKernelService.class, "")) != null) {
            wVar = iKernelService.getMsgService();
        }
        if (wVar == null) {
            QLog.e("DataLineRecentContactUtil", 1, "setMsgRead service is null");
        } else {
            wVar.setMsgRead(new Contact(8, str, ""), new IOperateCallback() { // from class: com.dataline.nt.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    DataLineRecentContactUtil.x(i3, str2);
                }
            });
        }
    }

    public final void y(@NotNull String uin, boolean isTop) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "DataLineRecentContactUtil", null, null, null, new DataLineRecentContactUtil$setTop$1(uin, isTop, null), 14, null);
        }
    }

    public final void z(@Nullable String oldPeerUin) {
        if (oldPeerUin == null) {
            return;
        }
        aa recentContactService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e("DataLineRecentContactUtil", 1, "tryDeleteOldContact, service is null");
            return;
        }
        if (deleteOldContactFlags.contains(oldPeerUin)) {
            return;
        }
        QLog.i("DataLineRecentContactUtil", 1, "tryDeleteOldContact start. old uid = " + oldPeerUin);
        ArrayList<Contact> arrayList = new ArrayList<>();
        arrayList.add(new Contact(8, oldPeerUin, ""));
        recentContactService.a0(arrayList, new a(oldPeerUin));
    }
}
