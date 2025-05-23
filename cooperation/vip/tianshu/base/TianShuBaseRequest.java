package cooperation.vip.tianshu.base;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class TianShuBaseRequest extends VSBaseRequest {
    private static final String TAG = "TianShuBaseRequest";

    protected abstract String getLogTag();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public byte[] getRequestWrapper(ByteStringMicro byteStringMicro) {
        if (byteStringMicro == null) {
            return new byte[0];
        }
        return byteStringMicro.toByteArray();
    }

    public long[] getRetryRetCodes() {
        return null;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public boolean isNeedRetry(long j3) {
        boolean z16;
        String logTag;
        boolean z17 = false;
        if (j3 == -2) {
            z16 = false;
        } else {
            z16 = true;
        }
        long[] retryRetCodes = getRetryRetCodes();
        if (retryRetCodes != null && retryRetCodes.length > 0) {
            int length = retryRetCodes.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (retryRetCodes[i3] == j3) {
                    z17 = true;
                    break;
                }
                i3++;
            }
        } else {
            z17 = z16;
        }
        if (TextUtils.isEmpty(getLogTag())) {
            logTag = TAG;
        } else {
            logTag = getLogTag();
        }
        QLog.d(logTag, 1, "isNeedRetry  | CmdName: " + getCmdName() + " | retCode: " + j3 + " | isNeedRetry: " + z17);
        return z17;
    }
}
