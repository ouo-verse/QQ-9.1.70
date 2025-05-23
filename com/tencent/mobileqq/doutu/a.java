package com.tencent.mobileqq.doutu;

import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(MessageRecord messageRecord) {
        int i3;
        if (messageRecord == null) {
            return false;
        }
        if (messageRecord instanceof MessageForMarketFace) {
            return true;
        }
        if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
            int i16 = messageForPic.imageType;
            if (i16 == 2000 || i16 == 3 || i16 == 4) {
                return true;
            }
            if (picMessageExtraData == null || ((i3 = picMessageExtraData.imageBizType) != 1 && i3 != 3 && !picMessageExtraData.isHotPics())) {
                return false;
            }
            return true;
        }
        if (!(messageRecord instanceof MessageForStructing) || !((MessageForStructing) messageRecord).isHotPicsStruct()) {
            return false;
        }
        return true;
    }

    private static boolean b(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            long j3 = messageForPic.size;
            if (j3 > 0 && j3 < 512000) {
                long j16 = messageForPic.width;
                if (j16 > 0 && j16 < 500) {
                    long j17 = messageForPic.height;
                    if (j17 > 0 && j17 < 500) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean c(MessageRecord messageRecord) {
        if (!a(messageRecord) && !b(messageRecord)) {
            return false;
        }
        return true;
    }
}
