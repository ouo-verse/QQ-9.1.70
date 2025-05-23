package com.tencent.libra.download;

import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraLogUtil;

/* loaded from: classes7.dex */
public abstract class RFWAbsPicDW {
    protected static final int DATA_BLOCK_LENGTH = 8192;
    protected static final String TAG = LibraLogUtil.INSTANCE.getLogTag("RFWAbsPicDW");

    /* loaded from: classes7.dex */
    public interface ICallBackListener {
        void callBack(Option option, boolean z16, int i3);
    }

    public abstract void handlerDownLoad(Option option, ICallBackListener iCallBackListener);
}
