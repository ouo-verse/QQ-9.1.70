package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.util.NetworkState;

/* compiled from: P */
/* loaded from: classes37.dex */
public class w extends QZoneBaseShareAction {
    public w(Activity activity) {
        super(activity);
    }

    private void E(Context context, f fVar) {
        String str;
        PhotoInfo photoInfo = fVar.f58179c;
        long a16 = com.qzone.preview.d.a(fVar.f58180d);
        if (a16 == 0) {
            a16 = fVar.f58179c.uploaduin;
        }
        com.tencent.mobileqq.dt.api.b c16 = com.qzone.feed.utils.f.c();
        c16.i("10072");
        c16.n(String.valueOf(a16));
        String replace = "pid:{pid}|cid:{cid}|qzone_appid:{qzone_appid}|own_uin:{own_uin}".replace("{own_uin}", String.valueOf(a16)).replace("{qzone_appid}", String.valueOf(4));
        try {
            if (com.qzone.preview.d.f(fVar.f58180d)) {
                if (!TextUtils.isEmpty(fVar.f58180d.albumid)) {
                    replace = replace.replace("{pid}", fVar.f58180d.albumid);
                } else if (!TextUtils.isEmpty(photoInfo.albumId)) {
                    replace = replace.replace("{pid}", photoInfo.albumId);
                }
                if (!TextUtils.isEmpty(photoInfo.sloc)) {
                    str = replace.replace("{cid}", photoInfo.sloc);
                } else {
                    str = replace.replace("{cid}", photoInfo.lloc);
                }
            } else {
                str = replace.replace("{pid}", "0").replace("{cid}", fVar.f58180d.ugcKey);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            str = replace;
        }
        c16.v(str);
        com.qzone.feed.utils.f.a(context, c16);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (!NetworkState.isNetSupport()) {
            ToastUtil.n(R.string.ghi);
        } else {
            E(n(), fVar);
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "28", true);
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{11};
    }
}
