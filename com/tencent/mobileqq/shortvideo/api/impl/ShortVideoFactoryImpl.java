package com.tencent.mobileqq.shortvideo.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.shortvideo.a;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import xq2.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShortVideoFactoryImpl implements IShortVideoFactory {
    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoFactory
    public b getAioShortVideoSendOperator(BaseQQAppInterface baseQQAppInterface) {
        if (baseQQAppInterface == null) {
            return new a();
        }
        return new a(baseQQAppInterface);
    }

    public BaseTransProcessor getC2CProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        if (transferRequest.mIsUp) {
            int i3 = transferRequest.mFileType;
            if (i3 != 6 && i3 != 17 && i3 != 9) {
                if (i3 == 20) {
                    return new ShortVideoForwardProcessor(baseTransFileController, transferRequest);
                }
                return null;
            }
            return new ShortVideoUploadProcessor(baseTransFileController, transferRequest);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoFactory
    public BaseTransProcessor getProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        int i3 = transferRequest.mUinType;
        if (i3 != 1 && i3 != 3000 && i3 != 10014) {
            return getC2CProcessor(baseTransFileController, transferRequest);
        }
        return getTroopProcessor(baseTransFileController, transferRequest);
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoFactory
    public Class getShortVideoForwardProcessorClass() {
        return ShortVideoForwardProcessor.class;
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoFactory
    public Class getShortVideoUploadProcessorClass() {
        return ShortVideoUploadProcessor.class;
    }

    public BaseTransProcessor getTroopProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        if (transferRequest.mIsUp) {
            int i3 = transferRequest.mFileType;
            if (i3 != 6 && i3 != 17 && i3 != 9 && i3 != 67) {
                if (i3 == 20) {
                    if (transferRequest.mUinType == 10014) {
                        return new ShortVideoUploadProcessor(baseTransFileController, transferRequest);
                    }
                    return new ShortVideoForwardProcessor(baseTransFileController, transferRequest);
                }
                return null;
            }
            return new ShortVideoUploadProcessor(baseTransFileController, transferRequest);
        }
        return null;
    }
}
