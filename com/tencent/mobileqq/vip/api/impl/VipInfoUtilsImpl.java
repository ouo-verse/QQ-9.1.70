package com.tencent.mobileqq.vip.api.impl;

import QQService.EVIPSPEC;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.data.VipTypeParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vip.api.IVipInfoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VipInfoUtilsImpl implements IVipInfoUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_VIP_HOME_TYPE = "vip_home_type";
    private static final String TAG = "VipInfoUtilsImpl";
    private final int QQ_BIGCLUB;
    private final int QQ_SVIP;
    private final int QQ_VIP;

    public VipInfoUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.QQ_VIP = 1;
        this.QQ_SVIP = 2;
        this.QQ_BIGCLUB = 3;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipInfoUtils
    public short getHighestVipInfo(NTVasSimpleInfo nTVasSimpleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Short) iPatchRedirector.redirect((short) 4, (Object) this, (Object) nTVasSimpleInfo)).shortValue();
        }
        if (nTVasSimpleInfo == null) {
            QLog.e(TAG, 1, "getHighestVipInfo friends null");
            nTVasSimpleInfo = new NTVasSimpleInfo();
        }
        return getHighestVipInfo(new VipTypeParam(nTVasSimpleInfo.qqVipInfo, nTVasSimpleInfo.superQqInfo, nTVasSimpleInfo.superVipInfo, nTVasSimpleInfo.bigClubInfo));
    }

    @Override // com.tencent.mobileqq.vip.api.IVipInfoUtils
    public com.tencent.mobileqq.vip.api.f getHighestVipType(NTVasSimpleInfo nTVasSimpleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.vip.api.f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) nTVasSimpleInfo);
        }
        if (nTVasSimpleInfo == null) {
            QLog.e(TAG, 1, "getHighestVipType friends null");
            nTVasSimpleInfo = new NTVasSimpleInfo();
        }
        return getHighestVipType(new VipTypeParam(nTVasSimpleInfo.qqVipInfo, nTVasSimpleInfo.superQqInfo, nTVasSimpleInfo.superVipInfo, nTVasSimpleInfo.bigClubInfo));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    @Override // com.tencent.mobileqq.vip.api.IVipInfoUtils
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.mobileqq.vip.api.f getHighestVipTypeWithoutBig(@Nullable NTVasSimpleInfo nTVasSimpleInfo) {
        short s16;
        int i3;
        int b16;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.vip.api.f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) nTVasSimpleInfo);
        }
        if (nTVasSimpleInfo != null) {
            EVIPSPEC evipspec = EVIPSPEC.E_SP_SUPERVIP;
            if (com.tencent.mobileqq.vip.r.c(nTVasSimpleInfo, evipspec)) {
                b16 = com.tencent.mobileqq.vip.r.b(nTVasSimpleInfo, evipspec);
                i16 = 512;
            } else {
                EVIPSPEC evipspec2 = EVIPSPEC.E_SP_QQVIP;
                if (com.tencent.mobileqq.vip.r.c(nTVasSimpleInfo, evipspec2)) {
                    b16 = com.tencent.mobileqq.vip.r.b(nTVasSimpleInfo, evipspec2);
                    i16 = 256;
                }
            }
            s16 = (short) (b16 | i16);
            i3 = s16 >> 8;
            if (i3 != 1) {
                if ((s16 & 15) == 1) {
                    return com.tencent.mobileqq.vip.api.f.f312800d;
                }
                return com.tencent.mobileqq.vip.api.f.f312799c;
            }
            if (i3 == 2) {
                if ((s16 & 15) == 1) {
                    return com.tencent.mobileqq.vip.api.f.f312802f;
                }
                return com.tencent.mobileqq.vip.api.f.f312801e;
            }
            return com.tencent.mobileqq.vip.api.f.f312798b;
        }
        s16 = 0;
        i3 = s16 >> 8;
        if (i3 != 1) {
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVipInfoUtils
    public int getQQSettingVipHomeType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).intValue();
        }
        return VipMMKV.getCommon(str).decodeInt(KEY_VIP_HOME_TYPE, 0);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipInfoUtils
    public int[] getVipIconsArray(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (int[]) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                int[] iArr = new int[split.length];
                for (int i3 = 0; i3 < split.length; i3++) {
                    iArr[i3] = Integer.parseInt(split[i3]);
                }
                return iArr;
            }
        } catch (Exception unused) {
        }
        return new int[0];
    }

    @Override // com.tencent.mobileqq.vip.api.IVipInfoUtils
    public String getVipIconsString(List<Integer> list) throws NumberFormatException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        }
        if (list != null && list.size() != 0) {
            if (list.get(0).intValue() == -34643985) {
                QLog.w(TAG, 1, "\u62c9\u53d6\u5230\u975e\u6cd5\u503c" + list.get(0));
                return null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(String.valueOf(list.get(0)));
            for (int i3 = 1; i3 < list.size(); i3++) {
                sb5.append(",");
                sb5.append(list.get(i3));
            }
            return sb5.toString();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.vip.api.IVipInfoUtils
    public void setQQSettingVipHomeType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
        } else {
            VipMMKV.getCommon(str).encodeInt(KEY_VIP_HOME_TYPE, i3);
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVipInfoUtils
    public short getHighestVipInfo(@NonNull VipTypeParam vipTypeParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Short) iPatchRedirector.redirect((short) 5, (Object) this, (Object) vipTypeParam)).shortValue();
        }
        if (vipTypeParam == null) {
            return (short) 0;
        }
        EVIPSPEC evipspec = EVIPSPEC.E_SP_BIGCLUB;
        if (vipTypeParam.isServiceEnabled(evipspec)) {
            return (short) (vipTypeParam.getServiceType(evipspec) | 768);
        }
        EVIPSPEC evipspec2 = EVIPSPEC.E_SP_SUPERVIP;
        if (vipTypeParam.isServiceEnabled(evipspec2)) {
            return (short) (vipTypeParam.getServiceType(evipspec2) | 512);
        }
        EVIPSPEC evipspec3 = EVIPSPEC.E_SP_QQVIP;
        if (vipTypeParam.isServiceEnabled(evipspec3)) {
            return (short) (vipTypeParam.getServiceType(evipspec3) | 256);
        }
        return (short) 0;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipInfoUtils
    @NonNull
    public com.tencent.mobileqq.vip.api.f getHighestVipType(@NonNull VipTypeParam vipTypeParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.vip.api.f) iPatchRedirector.redirect((short) 6, (Object) this, (Object) vipTypeParam);
        }
        short highestVipInfo = getHighestVipInfo(vipTypeParam);
        int i3 = highestVipInfo >> 8;
        if (i3 == 3) {
            if ((highestVipInfo & 15) == 1) {
                return com.tencent.mobileqq.vip.api.f.f312804h;
            }
            return com.tencent.mobileqq.vip.api.f.f312803g;
        }
        if (i3 == 1) {
            if ((highestVipInfo & 15) == 1) {
                return com.tencent.mobileqq.vip.api.f.f312800d;
            }
            return com.tencent.mobileqq.vip.api.f.f312799c;
        }
        if (i3 != 2) {
            return com.tencent.mobileqq.vip.api.f.f312798b;
        }
        if ((highestVipInfo & 15) == 1) {
            return com.tencent.mobileqq.vip.api.f.f312802f;
        }
        return com.tencent.mobileqq.vip.api.f.f312801e;
    }
}
