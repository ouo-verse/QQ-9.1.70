package com.tencent.mobileqq.guild.profile.me;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.profile.me.GuildModifyNickNameDialog;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import vh2.cc;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildModifyNameViewModel extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static final int ERROR_CODE_HAS_NO_TIMES = 108201;
    private static final String TAG = "Guild.profile.GuildModifyNameViewModel";

    public GuildModifyNameViewModel(wy1.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$modifyNickName$0(String str, GuildModifyNickNameDialog.e eVar, int i3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setNickName" + str + "result:" + i3 + "errMsg: " + str2);
        }
        if (i3 == 0) {
            if (eVar != null) {
                eVar.a(str);
                return;
            }
            return;
        }
        QLog.w(TAG, 1, "setNickName failed: " + i3 + "errMsg: " + str2);
        if (TextUtils.isEmpty(str2)) {
            str2 = "\u4fee\u6539\u5931\u8d25";
        }
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), 1, str2, 1).show();
    }

    public void init(AppInterface appInterface) {
        getRepository().m(appInterface);
    }

    public void modifyNickName(final String str, final GuildModifyNickNameDialog.e eVar) {
        ((IGPSService) ch.R0(IGPSService.class)).setNickName(str, new cc(str, eVar) { // from class: com.tencent.mobileqq.guild.profile.me.n

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f231247a;

            @Override // vh2.cc
            public final void onResult(int i3, String str2) {
                GuildModifyNameViewModel.lambda$modifyNickName$0(this.f231247a, null, i3, str2);
            }
        });
    }
}
