package com.tencent.mobileqq.pic.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.pic.api.IPicValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class PicValueImpl implements IPicValue {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PicValueImpl";

    public PicValueImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicValue
    public void fillStickInfo(MessageForPic messageForPic) {
        StickerInfo transformFromJson;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageForPic);
            return;
        }
        if ((messageForPic.extLong & 4) > 0 && EmojiStickerManager.f204583t) {
            System.currentTimeMillis();
            String extInfoFromExtStr = messageForPic.getExtInfoFromExtStr("sticker_info");
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                if (messageForPic.msgtype == -2000) {
                    messageForPic.msgtype = MessageRecord.MSG_TYPE_STICKER_MSG;
                }
                StickerInfo transformFromJson2 = StickerInfo.transformFromJson(extInfoFromExtStr);
                if (transformFromJson2 != null) {
                    transformFromJson2.isDisplayed = messageForPic.isread;
                    messageForPic.stickerInfo = transformFromJson2;
                    System.currentTimeMillis();
                    return;
                }
                return;
            }
            return;
        }
        if (messageForPic.msgtype == -2058) {
            String extInfoFromExtStr2 = messageForPic.getExtInfoFromExtStr("sticker_info");
            if (!TextUtils.isEmpty(extInfoFromExtStr2) && (transformFromJson = StickerInfo.transformFromJson(extInfoFromExtStr2)) != null) {
                transformFromJson.isDisplayed = messageForPic.isread;
                messageForPic.stickerInfo = transformFromJson;
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicValue
    public int getAioOtherSpaceValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        float d16 = BaseChatItemLayout.d();
        float c16 = BaseChatItemLayout.c();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        boolean z16 = false;
        if (runtime != null && (z16 = ((IFeatureRuntimeService) runtime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("aio_image_other_space_value_reduce", false))) {
            d16 /= ViewUtils.getDensity();
            c16 /= ViewUtils.getDensity();
        }
        int i3 = (int) (d16 + 108.0f + c16);
        QLog.i(TAG, 1, "needReduce:" + z16 + ", otherSpaceValue:" + i3);
        return i3;
    }
}
