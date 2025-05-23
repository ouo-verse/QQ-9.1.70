package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IViewHolderFactory;
import com.tencent.qphone.base.util.QLog;
import d4.f;
import vk2.QWalletMsgModel;
import vk2.QWalletSessionInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ViewHolderFactoryImpl implements IViewHolderFactory {
    @Override // com.tencent.mobileqq.qwallet.hb.aio.viewholder.IViewHolderFactory
    @NonNull
    public yk2.a createViewHolderV2(@NonNull f fVar, @NonNull QWalletMsgModel qWalletMsgModel, @NonNull QWalletSessionInfo qWalletSessionInfo) {
        int redPkgType = getRedPkgType(qWalletMsgModel.getMessageType());
        if (redPkgType != 6 && redPkgType != 17) {
            return new BaseViewHolderV2(fVar, qWalletMsgModel, qWalletSessionInfo);
        }
        return new SpecifyViewHolderV2(fVar, qWalletMsgModel, qWalletSessionInfo);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.viewholder.IViewHolderFactory
    public int getRedPkgType(int i3) {
        QLog.i(IViewHolderFactory.TAG, 2, "CFT-debug messageType = " + i3);
        if (i3 == 6) {
            return 1;
        }
        int i16 = 5;
        if (i3 != 14) {
            if (i3 == 13 || i3 == 15) {
                return 2;
            }
            if (i3 != 4 && i3 != 5) {
                if (i3 == 2001) {
                    return 4;
                }
                if (i3 != 7) {
                    i16 = 8;
                    if (i3 != 8 && i3 != 11 && i3 != 12) {
                        if (i3 == 2002) {
                            return 7;
                        }
                        if (i3 != 18) {
                            if (i3 == 19) {
                                return 9;
                            }
                            if (i3 != 21 && i3 != 24 && i3 != 25 && i3 != 27) {
                                if (i3 == 22 || i3 == 26) {
                                    return 11;
                                }
                                if (i3 == 23) {
                                    return 12;
                                }
                                if (i3 == 28) {
                                    return 14;
                                }
                                if (i3 == 29) {
                                    return 15;
                                }
                                if (i3 == 31) {
                                    return 17;
                                }
                                if (i3 == 32) {
                                    return 18;
                                }
                                return 0;
                            }
                            return 10;
                        }
                    }
                }
                return 6;
            }
            return 3;
        }
        return i16;
    }
}
