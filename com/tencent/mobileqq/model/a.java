package com.tencent.mobileqq.model;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static short f247231a;

    /* renamed from: b, reason: collision with root package name */
    public static int f247232b;

    /* renamed from: c, reason: collision with root package name */
    public static int f247233c;

    /* renamed from: d, reason: collision with root package name */
    public static int f247234d;

    /* renamed from: e, reason: collision with root package name */
    public static int f247235e;

    /* renamed from: f, reason: collision with root package name */
    public static int f247236f;

    /* renamed from: g, reason: collision with root package name */
    public static int f247237g;

    /* renamed from: h, reason: collision with root package name */
    public static int f247238h;

    /* renamed from: i, reason: collision with root package name */
    public static String f247239i;

    /* renamed from: j, reason: collision with root package name */
    public static String f247240j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47398);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f247231a = (short) 0;
        f247232b = 0;
        f247233c = 1;
        f247234d = 2;
        f247235e = 3;
        f247236f = 4;
        f247237g = 100;
        f247238h = 101;
        f247239i = HardCodeUtil.qqStr(R.string.f209335f5);
        f247240j = HardCodeUtil.qqStr(R.string.f209325f4);
    }

    public static void a(AppInterface appInterface, MessageForMarketFace messageForMarketFace) {
        MarkFaceMessage markFaceMessage = messageForMarketFace.mMarkFaceMessage;
        if (markFaceMessage != null && markFaceMessage.copywritingType != f247232b) {
            int showCount = ((ICommercialDrainageManagerService) appInterface.getRuntimeService(ICommercialDrainageManagerService.class, "")).getShowCount(messageForMarketFace.time, String.valueOf(markFaceMessage.dwTabID), markFaceMessage.copywritingContent, markFaceMessage.copywritingType);
            if (showCount == 0) {
                markFaceMessage.shouldDisplay = true;
            } else if (showCount == 1 && markFaceMessage.hasIpProduct) {
                markFaceMessage.shouldDisplay = true;
                markFaceMessage.showIpProduct = true;
                markFaceMessage.from = f247239i;
                markFaceMessage.copywritingContent = f247240j;
            } else {
                markFaceMessage.shouldDisplay = false;
            }
            try {
                messageForMarketFace.msgData = MessagePkgUtils.getBytesFromObject(markFaceMessage);
            } catch (Exception e16) {
                QLog.e(MessageForMarketFace.TAG, 1, "decodeC2CUinPairPackage: ", e16);
            }
        }
    }
}
