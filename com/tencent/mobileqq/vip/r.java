package com.tencent.mobileqq.vip;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class r {
    static IPatchRedirector $redirector_;

    public static int a(NTVasSimpleInfo nTVasSimpleInfo, EVIPSPEC evipspec) {
        int i3;
        int value = evipspec.value();
        if (value != 1) {
            if (value != 2) {
                if (value != 3) {
                    if (value != 7) {
                        return 0;
                    }
                    i3 = nTVasSimpleInfo.bigClubInfo;
                } else {
                    i3 = nTVasSimpleInfo.superVipInfo;
                }
            } else {
                i3 = nTVasSimpleInfo.superQqInfo;
            }
        } else {
            i3 = nTVasSimpleInfo.qqVipInfo;
        }
        return i3 & 65535;
    }

    public static int b(NTVasSimpleInfo nTVasSimpleInfo, EVIPSPEC evipspec) {
        int i3;
        int value = evipspec.value();
        if (value != 1) {
            if (value != 2) {
                if (value != 3) {
                    if (value != 7) {
                        return 0;
                    }
                    i3 = nTVasSimpleInfo.bigClubInfo;
                } else {
                    i3 = nTVasSimpleInfo.superVipInfo;
                }
            } else {
                i3 = nTVasSimpleInfo.superQqInfo;
            }
        } else {
            i3 = nTVasSimpleInfo.qqVipInfo;
        }
        return (i3 & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        if ((r4.bigClubInfo & (-16777216)) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001d, code lost:
    
        if ((r4.superVipInfo & (-16777216)) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0023, code lost:
    
        if ((r4.superQqInfo & (-16777216)) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
    
        if ((r4.qqVipInfo & (-16777216)) != 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(NTVasSimpleInfo nTVasSimpleInfo, EVIPSPEC evipspec) {
        int value = evipspec.value();
        boolean z16 = true;
        if (value != 1) {
            if (value != 2) {
                if (value != 3) {
                    if (value != 7) {
                        return false;
                    }
                }
            }
        }
    }
}
