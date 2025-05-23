package com.tencent.mobileqq.data.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.IMessageForPttInnerApi;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes10.dex */
public class MessageForPttInnerApiImpl implements IMessageForPttInnerApi {
    @Override // com.tencent.mobileqq.data.IMessageForPttInnerApi
    public String getLocalFilePath(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i3 == 1 && str.endsWith(".amr")) {
            str = str.substring(0, str.length() - 4) + ".slk";
        }
        return RmVFSUtils.getVFSPath(str, true);
    }

    @Override // com.tencent.mobileqq.data.IMessageForPttInnerApi
    public String getMsgFilePath(int i3, String str) {
        if (i3 == 1 && str.endsWith(".slk")) {
            return str.substring(0, str.length() - 4) + ".amr";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.data.IMessageForPttInnerApi
    public String getSummaryMsg(String str, int i3) {
        if (hasSttTxt(str, i3)) {
            return BaseApplication.getContext().getString(R.string.zor) + str;
        }
        return BaseApplication.getContext().getString(R.string.zor);
    }

    @Override // com.tencent.mobileqq.data.IMessageForPttInnerApi
    public boolean hasSttTxt(String str, int i3) {
        if (!StringUtil.isEmpty(str) && !BaseApplication.getContext().getString(R.string.f229516wn).equals(str) && i3 != 3) {
            return true;
        }
        return false;
    }
}
