package com.tencent.mobileqq.ark.debug;

import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
/* loaded from: classes11.dex */
class ArkIDESettingFragment$6$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f199367d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ TextView f199368e;

    @Override // java.lang.Runnable
    public void run() {
        String str;
        switch (this.f199367d) {
            case 0:
                str = "js\u8c03\u8bd5\u5e93\u72b6\u6001: " + HardCodeUtil.qqStr(R.string.jpv);
                break;
            case 1:
                str = "js\u8c03\u8bd5\u5e93\u72b6\u6001: " + HardCodeUtil.qqStr(R.string.f171606jq1);
                break;
            case 2:
                str = "js\u8c03\u8bd5\u5e93\u72b6\u6001: " + HardCodeUtil.qqStr(R.string.jpw);
                break;
            case 3:
                str = "js\u8c03\u8bd5\u5e93\u72b6\u6001: " + HardCodeUtil.qqStr(R.string.jpz);
                break;
            case 4:
                str = "js\u8c03\u8bd5\u5e93\u72b6\u6001: " + HardCodeUtil.qqStr(R.string.jpu);
                break;
            case 5:
                str = "js\u8c03\u8bd5\u5e93\u72b6\u6001: " + HardCodeUtil.qqStr(R.string.jpt);
                break;
            case 6:
                str = "js\u8c03\u8bd5\u5e93\u72b6\u6001: " + HardCodeUtil.qqStr(R.string.jpr);
                break;
            case 7:
                str = "js\u8c03\u8bd5\u5e93\u72b6\u6001: " + HardCodeUtil.qqStr(R.string.jpy);
                break;
            case 8:
                str = "js\u8c03\u8bd5\u5e93\u72b6\u6001: " + HardCodeUtil.qqStr(R.string.jps);
                break;
            case 9:
                str = "js\u8c03\u8bd5\u5e93\u72b6\u6001: " + HardCodeUtil.qqStr(R.string.jpq);
                break;
            default:
                str = "js\u8c03\u8bd5\u5e93\u72b6\u6001: " + HardCodeUtil.qqStr(R.string.f171605jq0);
                break;
        }
        this.f199368e.setText(str);
    }
}
