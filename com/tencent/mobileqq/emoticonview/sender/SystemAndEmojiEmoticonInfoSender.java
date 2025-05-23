package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceResImpl;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.fd;
import com.tencent.nt.adapter.session.c;
import com.tencent.pb.emosm.EmosmPb$SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SystemAndEmojiEmoticonInfoSender {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SystemAndEmojiEmoticonInfoSender";

    public SystemAndEmojiEmoticonInfoSender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addToCommonUsed(BaseQQAppInterface baseQQAppInterface, p pVar, int i3, int i16) {
        ICommonUsedSystemEmojiManagerService iCommonUsedSystemEmojiManagerService;
        EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = new EmosmPb$SmallYellowItem();
        emosmPb$SmallYellowItem.f342125id.set(i3);
        int i17 = i16 == 1 ? 1 : 2;
        emosmPb$SmallYellowItem.type.set(i17);
        long currentTimeMillis = System.currentTimeMillis();
        emosmPb$SmallYellowItem.f342126ts.set(currentTimeMillis);
        QLog.d(TAG, 1, "send saveemoji type = " + i17 + ";id = " + i3 + ";ts = " + currentTimeMillis + ";troopUin = " + ((pVar == null || TextUtils.isEmpty(pVar.f179559f)) ? "" : pVar.f179559f));
        if (baseQQAppInterface == null || (iCommonUsedSystemEmojiManagerService = (ICommonUsedSystemEmojiManagerService) baseQQAppInterface.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)) == null) {
            return;
        }
        iCommonUsedSystemEmojiManagerService.saveSystemEmojiInfoToCahce(emosmPb$SmallYellowItem);
    }

    private static void reportYellowExpressionClick(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        boolean z16;
        if (systemAndEmojiEmoticonInfo == null) {
            return;
        }
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(systemAndEmojiEmoticonInfo.emotionType);
        int i3 = 0;
        if (resImpl instanceof QQSysFaceResImpl) {
            z16 = QQSysFaceUtil.isBigStickerByType(((QQSysFaceResImpl) resImpl).getAniStickerType(systemAndEmojiEmoticonInfo.code));
        } else {
            z16 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(EmotionReportDtImpl.PARAM_EXPRESSION_PACK_ID, String.valueOf(systemAndEmojiEmoticonInfo.code));
        if (!z16) {
            i3 = systemAndEmojiEmoticonInfo.emotionType;
        }
        hashMap.put(EmotionReportDtImpl.PARAM_EXPRESSION_YELLOW_FACE_TYPE, Integer.valueOf(i3));
        hashMap.put(EmotionReportDtImpl.PARAM_EXPRESSION_IS_RECENT_USE, Integer.valueOf(systemAndEmojiEmoticonInfo.isCommonUsed ? 1 : 0));
        com.tencent.mobileqq.aio.utils.b.l(EmotionReportDtImpl.EM_LITTLE_YELLOW_FACE_EMOJI, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void send(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        String emojiString;
        boolean z16;
        p pVar;
        int i3;
        if (systemAndEmojiEmoticonInfo == null) {
            return;
        }
        int i16 = systemAndEmojiEmoticonInfo.emotionType;
        int i17 = systemAndEmojiEmoticonInfo.code;
        boolean z17 = systemAndEmojiEmoticonInfo.isCommonUsed;
        if (i17 == -1) {
            return;
        }
        p pVar2 = (p) parcelable;
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        Editable editableText = editText.getEditableText();
        if (i16 == 1) {
            emojiString = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i17);
        } else {
            emojiString = com.tencent.mobileqq.text.TextUtils.getEmojiString(i17);
        }
        editableText.replace(selectionStart, selectionEnd, emojiString);
        editText.requestFocus();
        boolean z18 = appRuntime instanceof BaseQQAppInterface;
        if (z18) {
            addToCommonUsed((BaseQQAppInterface) appRuntime, pVar2, i17, i16);
        }
        if (z17) {
            z16 = z18;
            pVar = pVar2;
            ReportController.o(appRuntime, "CliOper", "", "", "ep_mall", "0X800717F", 0, 0, i16 + "", i17 + "", "", "");
        } else {
            z16 = z18;
            pVar = pVar2;
        }
        if (z16 && com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(i17) && pVar != null) {
            i3 = 1;
            fd.a((BaseQQAppInterface) appRuntime, "cmshow", "Apollo", "0X800812C", ((IApolloUtil) QRoute.api(IApolloUtil.class)).getReportSessionType(pVar.f179555d), 0, String.valueOf(i17), "0");
            QQSysAndEmojiResMgr.getInstance().getResImpl(i16).getServerId(i17);
        } else {
            i3 = 1;
        }
        if (pVar != null) {
            QQSysAndEmojiResMgr.getInstance().getResImpl(i16).reportEmoClick(i17, i3, c.l(pVar.f179555d));
            reportYellowExpressionClick(systemAndEmojiEmoticonInfo);
        }
    }

    public static void addToCommonUsed(IEmoticonMainPanelApp iEmoticonMainPanelApp, p pVar, int i3, int i16) {
        CommonUsedSystemEmojiManagerServiceProxy commonUsedSystemEmojiManagerServiceProxy;
        EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = new EmosmPb$SmallYellowItem();
        emosmPb$SmallYellowItem.f342125id.set(i3);
        int i17 = i16 == 1 ? 1 : 2;
        emosmPb$SmallYellowItem.type.set(i17);
        long currentTimeMillis = System.currentTimeMillis();
        emosmPb$SmallYellowItem.f342126ts.set(currentTimeMillis);
        QLog.d(TAG, 1, "send saveemoji type = " + i17 + ";id = " + i3 + ";ts = " + currentTimeMillis + ";troopUin = " + ((pVar == null || TextUtils.isEmpty(pVar.f179559f)) ? "" : pVar.f179559f));
        if (iEmoticonMainPanelApp == null || (commonUsedSystemEmojiManagerServiceProxy = (CommonUsedSystemEmojiManagerServiceProxy) ((QQEmoticonMainPanelApp) iEmoticonMainPanelApp).getRuntimeService(ICommonUsedSystemEmojiManagerService.class)) == null) {
            return;
        }
        commonUsedSystemEmojiManagerServiceProxy.saveSystemEmojiInfoToCache(emosmPb$SmallYellowItem);
    }
}
