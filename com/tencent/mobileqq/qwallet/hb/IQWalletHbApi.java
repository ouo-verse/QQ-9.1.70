package com.tencent.mobileqq.qwallet.hb;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletHbApi extends QRouteApi {
    public static final int HONGBAO_REPORT_TYPE_AIOPANELICON = 1;
    public static final int HONGBAO_REPORT_TYPE_PANNEL = 3;
    public static final int HONGBAO_REPORT_TYPE_PLUSPANEL = 0;
    public static final int HONGBAO_REPORT_TYPE_SENDBACK = 2;
    public static final String KEY_HB_SKIN_PREVIEW_ID = "skin_id";
    public static final String KEY_HB_SKIN_PREVIEW_IS_GET = "hb_skin_preview_result_get";
    public static final String KEY_HB_SKIN_PREVIEW_IS_SHARE = "hb_skin_preview_share";
    public static final String KEY_HB_SKIN_PREVIEW_RESULT_CODE = "hb_skin_preview_result_code";
    public static final String KEY_HB_SKIN_PREVIEW_RESULT_MSG = "hb_skin_preview_result_msg";

    void changeGuildWalletApngState(boolean z16);

    boolean doJumpAction(Context context, String str);

    boolean doStartBrowser(Context context, String str);

    boolean doStartBrowser(Context context, String str, Bundle bundle);

    com.tencent.mobileqq.qwallet.hb.aio.elem.a getCustomizeStrategyFactory();

    int getPanelFrom();

    View getRedPacketPanelForGuild(Activity activity, com.tencent.aio.api.runtime.a aVar, String str, String str2);

    Class<? extends Fragment> getSkinPreviewEntryFragment();

    void goToSendHbActivity(Activity activity, int i3, String str);

    void goToSendHbActivity(Activity activity, String str, String str2);

    boolean isC2CAIO(String str);

    boolean isCanShowNewCloseBtn(Context context);

    boolean isGuildAIO(String str);

    boolean isRedPacketMsg(MessageRecord messageRecord);

    boolean isValideToDoAction(long j3, long j16);

    void setPanelFrom(int i3);

    Dialog showQWalletProgressDialog(Activity activity);

    void updateOpenIcon(@NonNull ImageView imageView, @Nullable String str);
}
