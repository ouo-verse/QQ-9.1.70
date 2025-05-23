package com.tencent.icgame.game.liveroom.impl.room.util;

import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f115689a = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);

    public static void a() {
        if (t42.d.a() == null) {
            return;
        }
        String str = "key_cache_qqlive_pv_" + t42.d.a().getAccount();
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_ICGAME);
        String str2 = f115689a.format(new Date()) + "_report";
        if (!TextUtils.equals(str2, from.decodeString(str, ""))) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).reportEvent("enter_room_uv", ah.t(), ah.Q(BaseApplication.getContext()));
            from.encodeString(str, str2);
        }
    }
}
