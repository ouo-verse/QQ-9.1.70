package com.tencent.mobileqq.qwallet.hb.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.impl.c;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketPanel;
import com.tencent.mobileqq.qwallet.hb.panel.m;
import com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewEntryFragment;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinRepository;
import com.tencent.mobileqq.util.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QWalletHbApiImpl implements IQWalletHbApi {
    private static final int MIN_HEIGHT_TO_SHOW_NEW_CLOSE_BTN_DP = 650;
    private static final String TAG = "QWalletHbApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$goToSendHbActivity$0(Activity activity, c.d dVar) {
        m.f277567a.e(activity, dVar, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$goToSendHbActivity$1(final Activity activity, Boolean bool, com.tencent.nt.adapter.session.f fVar) {
        if (bool.booleanValue()) {
            final c.d i3 = com.tencent.mobileqq.qwallet.hb.aio.impl.c.i(fVar.b(), fVar.a(), fVar.a());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.impl.l
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletHbApiImpl.lambda$goToSendHbActivity$0(activity, i3);
                }
            });
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public void changeGuildWalletApngState(boolean z16) {
        if (z16) {
            ApngImage.playByTag(26);
        } else {
            ApngImage.pauseByTag(26);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public boolean doJumpAction(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public boolean doStartBrowser(Context context, String str) {
        return doStartBrowser(context, str, null);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public com.tencent.mobileqq.qwallet.hb.aio.elem.a getCustomizeStrategyFactory() {
        return wk2.b.c();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public int getPanelFrom() {
        return com.tencent.mobileqq.qwallet.hb.aio.impl.c.f().g();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public View getRedPacketPanelForGuild(Activity activity, com.tencent.aio.api.runtime.a aVar, String str, String str2) {
        p pVar = new p();
        pVar.f179555d = 10014;
        pVar.f179559f = str;
        pVar.f179557e = str2;
        com.tencent.mobileqq.qwallet.a c16 = m.f277567a.c(true, null);
        RedPacketPanel redPacketPanel = new RedPacketPanel(activity, c16.a());
        redPacketPanel.O0(pVar, c16, aVar);
        return redPacketPanel;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public Class<? extends Fragment> getSkinPreviewEntryFragment() {
        return SkinPreviewEntryFragment.class;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public void goToSendHbActivity(Activity activity, String str, String str2) {
        m.f277567a.e(activity, com.tencent.mobileqq.qwallet.hb.aio.impl.c.i(10014, str2, str), 1, null);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public boolean isC2CAIO(String str) {
        return com.tencent.mobileqq.qwallet.hb.aio.impl.d.e(str);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public boolean isCanShowNewCloseBtn(Context context) {
        if (context == null) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        if (x.c(context, 650.0f) >= displayMetrics.heightPixels) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public boolean isGuildAIO(String str) {
        return com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(str);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public boolean isRedPacketMsg(MessageRecord messageRecord) {
        return (messageRecord instanceof MessageForQQWalletMsg) && isRedPacketMsg((MessageForQQWalletMsg) messageRecord);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public boolean isValideToDoAction(long j3, long j16) {
        if (Math.abs(j16 - j3) > 1000) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public void setPanelFrom(int i3) {
        com.tencent.mobileqq.qwallet.hb.aio.impl.c.f().o(i3);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public Dialog showQWalletProgressDialog(Activity activity) {
        return m.f277567a.i(activity);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public void updateOpenIcon(@NonNull ImageView imageView, @Nullable String str) {
        HbSkinRepository.f277840a.h(imageView, str);
    }

    private boolean isRedPacketMsg(MessageForQQWalletMsg messageForQQWalletMsg) {
        QQWalletRedPacketMsg qQWalletRedPacketMsg;
        return (messageForQQWalletMsg == null || (qQWalletRedPacketMsg = messageForQQWalletMsg.mQQWalletRedPacketMsg) == null || qQWalletRedPacketMsg.elem == null) ? false : true;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public boolean doStartBrowser(Context context, String str, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("url", str);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
        return true;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
    public void goToSendHbActivity(final Activity activity, int i3, String str) {
        com.tencent.nt.adapter.session.c.h(str, i3, new Function2() { // from class: com.tencent.mobileqq.qwallet.hb.impl.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$goToSendHbActivity$1;
                lambda$goToSendHbActivity$1 = QWalletHbApiImpl.lambda$goToSendHbActivity$1(activity, (Boolean) obj, (com.tencent.nt.adapter.session.f) obj2);
                return lambda$goToSendHbActivity$1;
            }
        });
    }
}
