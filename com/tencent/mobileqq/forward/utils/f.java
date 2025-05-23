package com.tencent.mobileqq.forward.utils;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.api.IGuildTextForwardApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.kernel.nativeinterface.EmojiMall;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.data.g;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.nt.api.IRelationAIOService;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\tJB\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007H\u0007J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\tJ \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u0007J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0007J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010 J\u0018\u0010$\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010 J\"\u0010(\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\t2\b\u0010'\u001a\u0004\u0018\u00010\t\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/forward/utils/f;", "", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "", "e", "f", "", "chatType", "", "b", "", "d", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "textAndEmoji", "i", "forwardPhotoPath", "picSubType", "md5", "packageId", "picSubSubType", "o", "forwardVideoPath", "r", "businessType", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/data/MessageForMarketFace;", "messageForMarketFace", "j", "Lcom/tencent/mobileqq/data/MessageRecord;", "messageRecord", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/data/ArkAppMessage;", "resultArkMsg", "g", "", h.F, "uinType", "uin", "troopUin", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f211079a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58164);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f211079a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(p sessionInfo, int chatType) {
        String str = "";
        if (d(chatType)) {
            IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
            String str2 = sessionInfo.f179557e;
            if (str2 != null) {
                str = str2;
            }
            String uidFromUin = iRelationNTUinAndUidApi.getUidFromUin(str);
            Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026nInfo.curFriendUin ?: \"\")");
            return uidFromUin;
        }
        if (TextUtils.isEmpty(sessionInfo.f179559f)) {
            String str3 = sessionInfo.f179557e;
            if (str3 == null) {
                return "";
            }
            return str3;
        }
        String str4 = sessionInfo.f179559f;
        if (str4 == null) {
            return "";
        }
        return str4;
    }

    private final boolean d(int chatType) {
        if (chatType == 1 || chatType == 100 || chatType == 99 || chatType == 113) {
            return true;
        }
        return false;
    }

    private final void e(p sessionInfo) {
        if (sessionInfo.f179555d != 1006) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.e(ForwardBaseOption.TAG, 1, "ntContactChatPrepareTempChatInfo is error! app is invalid!");
            return;
        }
        IRelationAIOService iRelationAIOService = (IRelationAIOService) QRoute.api(IRelationAIOService.class);
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        String str = sessionInfo.T;
        if (str == null) {
            str = sessionInfo.f179557e;
        }
        Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.uinName ?: sessionInfo.curFriendUin");
        String str2 = sessionInfo.f179557e;
        Intrinsics.checkNotNullExpressionValue(str2, "sessionInfo.curFriendUin");
        iRelationAIOService.ntPrepareContactStrangerTempChat(appInterface, str, str2);
    }

    private final void f(p sessionInfo) {
        if (sessionInfo.f179555d != 1000) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.e(ForwardBaseOption.TAG, 1, "ntTroopMemberChatPrepareTempChatInfo is error! app is invalid!");
            return;
        }
        if (TextUtils.isEmpty(sessionInfo.f179559f)) {
            QLog.e(ForwardBaseOption.TAG, 1, "ntTroopMemberChatPrepareTempChatInfo is error! troopUin is invalid!");
            return;
        }
        IRelationAIOService iRelationAIOService = (IRelationAIOService) QRoute.api(IRelationAIOService.class);
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        String str = sessionInfo.T;
        if (str == null) {
            str = sessionInfo.f179557e;
        }
        Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.uinName ?: sessionInfo.curFriendUin");
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        String str2 = sessionInfo.f179557e;
        if (str2 == null) {
            str2 = "";
        }
        String uidFromUin = iRelationNTUinAndUidApi.getUidFromUin(str2);
        Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026nInfo.curFriendUin ?: \"\")");
        String str3 = sessionInfo.f179559f;
        Intrinsics.checkNotNullExpressionValue(str3, "sessionInfo.troopUin");
        iRelationAIOService.ntPrepareTroopMemberStrangerTempChat(appInterface, str, uidFromUin, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String str) {
        if (i3 != 0) {
            QLog.e("ForwardNTUtils", 1, "ForwardNTUtils.sendMsg sendMarketFaceMessage is error!");
            QQToastUtil.showQQToastInUiThread(1, str);
        }
    }

    public static /* synthetic */ void p(f fVar, p pVar, String str, int i3, String str2, int i16, int i17, int i18, Object obj) {
        int i19;
        int i26;
        if ((i18 & 4) != 0) {
            i3 = 0;
        }
        int i27 = i3;
        if ((i18 & 8) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i18 & 16) != 0) {
            i19 = -1;
        } else {
            i19 = i16;
        }
        if ((i18 & 32) != 0) {
            i26 = -1;
        } else {
            i26 = i17;
        }
        fVar.o(pVar, str, i27, str3, i19, i26);
    }

    @NotNull
    public final SessionInfo c(int uinType, @Nullable String uin, @Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SessionInfo) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(uinType), uin, troopUin);
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = uinType;
        sessionInfo.f179557e = uin;
        sessionInfo.f179559f = troopUin;
        return sessionInfo;
    }

    public final void g(@NotNull SessionInfo sessionInfo, @Nullable ArkAppMessage resultArkMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) sessionInfo, (Object) resultArkMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        if (resultArkMsg == null) {
            QLog.e("ForwardNTUtils", 1, "sendArkAppMessage is error! resultArkMsg is invalid!");
            return;
        }
        e(sessionInfo);
        f(sessionInfo);
        int l3 = com.tencent.nt.adapter.session.c.l(sessionInfo.f179555d);
        String b16 = b(sessionInfo, l3);
        com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
        String appXml = resultArkMsg.toAppXml();
        Intrinsics.checkNotNullExpressionValue(appXml, "resultArkMsg.toAppXml()");
        aVar.o(appXml);
        ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).sendArk(b16, l3, aVar);
    }

    public final long h(@NotNull SessionInfo sessionInfo, @Nullable ArkAppMessage resultArkMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, (Object) sessionInfo, (Object) resultArkMsg)).longValue();
        }
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        if (resultArkMsg == null) {
            QLog.e("ForwardNTUtils", 1, "sendArkAppMessage is error! resultArkMsg is invalid!");
            return 0L;
        }
        e(sessionInfo);
        f(sessionInfo);
        int l3 = com.tencent.nt.adapter.session.c.l(sessionInfo.f179555d);
        String b16 = b(sessionInfo, l3);
        com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
        String appXml = resultArkMsg.toAppXml();
        Intrinsics.checkNotNullExpressionValue(appXml, "resultArkMsg.toAppXml()");
        aVar.o(appXml);
        return ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).sendArkWithMsgId(b16, l3, aVar);
    }

    public final void i(@NotNull SessionInfo sessionInfo, @Nullable String textAndEmoji) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sessionInfo, (Object) textAndEmoji);
            return;
        }
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        if (textAndEmoji != null) {
            if (textAndEmoji.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                e(sessionInfo);
                f(sessionInfo);
                int l3 = com.tencent.nt.adapter.session.c.l(sessionInfo.f179555d);
                if (l3 != 4) {
                    if (l3 == 99) {
                        QLog.e("ForwardNTUtils", 1, "sendCommentMessage is error! chatType is invalid!");
                        return;
                    }
                } else {
                    ((IGuildTextForwardApi) QRoute.api(IGuildTextForwardApi.class)).sendMsg(sessionInfo.f179559f, sessionInfo.f179557e, textAndEmoji);
                }
                ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).sendText(b(sessionInfo, l3), l3, textAndEmoji);
                return;
            }
        }
        QLog.e("ForwardNTUtils", 1, "sendCommentMessage is error! textAndEmoji is invalid!");
    }

    public final void j(@NotNull p sessionInfo, @Nullable MessageForMarketFace messageForMarketFace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) sessionInfo, (Object) messageForMarketFace);
            return;
        }
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        if (messageForMarketFace == null) {
            return;
        }
        int l3 = com.tencent.nt.adapter.session.c.l(sessionInfo.f179555d);
        ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(new Contact(l3, b(sessionInfo, l3), ""), com.tencent.imcore.message.facade.send.sender.d.f116641a.b(messageForMarketFace), new IOperateCallback() { // from class: com.tencent.mobileqq.forward.utils.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                f.k(i3, str);
            }
        });
    }

    @JvmOverloads
    public final void l(@NotNull p sessionInfo, @Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) sessionInfo, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            p(this, sessionInfo, str, 0, null, 0, 0, 60, null);
        }
    }

    @JvmOverloads
    public final void m(@NotNull p sessionInfo, @Nullable String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, sessionInfo, str, Integer.valueOf(i3));
        } else {
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            p(this, sessionInfo, str, i3, null, 0, 0, 56, null);
        }
    }

    @JvmOverloads
    public final void n(@NotNull p sessionInfo, @Nullable String str, int i3, @NotNull String md5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, sessionInfo, str, Integer.valueOf(i3), md5);
            return;
        }
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(md5, "md5");
        p(this, sessionInfo, str, i3, md5, 0, 0, 48, null);
    }

    @JvmOverloads
    public final void o(@NotNull p sessionInfo, @Nullable String forwardPhotoPath, int picSubType, @NotNull String md5, int packageId, int picSubSubType) {
        boolean z16;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, sessionInfo, forwardPhotoPath, Integer.valueOf(picSubType), md5, Integer.valueOf(packageId), Integer.valueOf(picSubSubType));
            return;
        }
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(md5, "md5");
        if (forwardPhotoPath != null) {
            if (forwardPhotoPath.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                e(sessionInfo);
                f(sessionInfo);
                int l3 = com.tencent.nt.adapter.session.c.l(sessionInfo.f179555d);
                String b16 = b(sessionInfo, l3);
                EmojiMall emojiMall = null;
                if (picSubSubType != -1) {
                    num = Integer.valueOf(picSubSubType);
                } else {
                    num = null;
                }
                if (packageId != -1) {
                    emojiMall = new EmojiMall(packageId, 0);
                }
                ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).sendPic(b16, l3, forwardPhotoPath, false, picSubType, 300.0f, md5, new g(null, null, null, emojiMall, null, num, 0, 87, null));
                return;
            }
        }
        QLog.e("ForwardNTUtils", 1, "sendPhotoMessage is error! forwardPhotoPath is invalid!");
    }

    @Deprecated
    public final void q(@NotNull SessionInfo sessionInfo, @Nullable MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) sessionInfo, (Object) messageRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        QLog.e("ForwardNTUtils", 1, "ForwardNTUtils.sendMsg sendStructMessage is error!");
        QQToastUtil.showQQToastInUiThread(1, "\u6682\u65f6\u4e0d\u652f\u6301\u5206\u4eab!");
    }

    public final void r(@NotNull SessionInfo sessionInfo, @Nullable String forwardVideoPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) sessionInfo, (Object) forwardVideoPath);
        } else {
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            s(sessionInfo, forwardVideoPath, 0);
        }
    }

    public final void s(@NotNull SessionInfo sessionInfo, @Nullable String forwardVideoPath, int businessType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, sessionInfo, forwardVideoPath, Integer.valueOf(businessType));
            return;
        }
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        if (forwardVideoPath != null) {
            if (forwardVideoPath.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                e(sessionInfo);
                f(sessionInfo);
                int l3 = com.tencent.nt.adapter.session.c.l(sessionInfo.f179555d);
                ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).sendVideo(b(sessionInfo, l3), l3, forwardVideoPath, businessType, false, null);
                return;
            }
        }
        QLog.e("ForwardNTUtils", 1, "sendPhotoMessage is error! forwardPhotoPath is invalid!");
    }
}
