package com.tencent.mobileqq.guild.temp.api;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    public static boolean a(MessageForUniteGrayTip messageForUniteGrayTip) {
        com.tencent.mobileqq.graytip.d dVar;
        if (messageForUniteGrayTip == null || (dVar = messageForUniteGrayTip.uniteCombineGrayTipParam) == null || dVar.f213672a != 2) {
            return false;
        }
        return true;
    }

    public static boolean b(MessageForUniteGrayTip messageForUniteGrayTip) {
        com.tencent.mobileqq.graytip.d dVar;
        if (messageForUniteGrayTip == null || (dVar = messageForUniteGrayTip.uniteCombineGrayTipParam) == null || dVar.f213672a != 3) {
            return false;
        }
        return true;
    }

    public static boolean c(MessageForUniteGrayTip messageForUniteGrayTip) {
        if (!a(messageForUniteGrayTip) && !b(messageForUniteGrayTip)) {
            return true;
        }
        return false;
    }
}
