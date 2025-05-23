package com.tenpay.sdk.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.grap.IQWalletGrabApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.QwLog;
import com.tenpay.proxy.DataProxy;
import com.tenpay.sdk.activity.FullVideoActivity;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HBUtil {
    public static final int HB_STATE_ABNORMAL = -1;
    public static final int HB_STATE_ALREAY_GRAPPED = 1;
    public static final int HB_STATE_CANNOT_GRAP_OWN = 6;
    public static final int HB_STATE_GRAPPED = 0;
    public static final int HB_STATE_GRAPPED_BY_OTHERS = 2;
    public static final int HB_STATE_GRAPPED_KEPP_CUR = 10;
    public static final int HB_STATE_GRAP_CONTINUE_HB_FINISHED = 14;
    public static final int HB_STATE_GRAP_IDIOM_HB_FAILED = 12;
    public static final int HB_STATE_GRAP_WORD_HB_REPEAT = 13;
    public static final int HB_STATE_JH_EXCEED_LIMIT = 5;
    public static final int HB_STATE_NEED_AGREE_CONTRACT = 7;
    public static final int HB_STATE_NON_RECIPTOR = 8;
    public static final int HB_STATE_NO_ACCESS = 4;
    public static final int HB_STATE_OUTOFDATE = 3;
    public static final int HB_STATE_OVERTIME_24_HOUR = 9;
    public static final int HB_STATE_PRE_GRAB_IS_SECCESS = 16;
    public static final int HB_VOICE_LING = 65536;
    private static final String TAG = "HBUtil";
    public static final int TYPE_URL_JUMP_H5 = 1;
    private static final int TYPE_URL_JUMP_MINI = 3;
    private static final int TYPE_URL_JUMP_VIDEO = 2;
    private static ValueAnimator sAdAnimator;
    public static Set<Integer> sEnableUrlJumpSet = new HashSet<Integer>() { // from class: com.tenpay.sdk.util.HBUtil.1
        {
            add(1);
            add(2);
            add(3);
        }
    };

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class OrderState {
        public static final int STATE_EMPTY = 2;
        public static final int STATE_EXPIRED = 3;
        public static final int STATE_REFUND = 4;
        public static final int STATE_SUCCESS = 1;
    }

    public static void cleanAdAnimator() {
        try {
            ValueAnimator valueAnimator = sAdAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                sAdAnimator.cancel();
            }
        } catch (Throwable th5) {
            QwLog.e(th5.getMessage());
        }
    }

    public static Drawable getAvatarDrawable(String str) {
        return ((IQQGuildAvatarApi) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGuildAvatarApi.class, "tool")).getAvatarDrawable(str, 0, true, "");
    }

    public static void getGuildMemberName(final String str, final String str2, final OnGetResult onGetResult) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "getGuildMemberName guildId is empty or tinyId is empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.util.f
                @Override // java.lang.Runnable
                public final void run() {
                    HBUtil.lambda$getGuildMemberName$0(str2, str, onGetResult);
                }
            }, 16, null, true);
        }
    }

    public static void getGuildMemberNames(final int i3, @NonNull final ArrayList<String> arrayList, final String str, final OnGetResult onGetResult) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "getGuildMemberNames guildId is empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.util.e
                @Override // java.lang.Runnable
                public final void run() {
                    HBUtil.lambda$getGuildMemberNames$1(i3, str, arrayList, onGetResult);
                }
            }, 16, null, true);
        }
    }

    public static void getGuildUsersAvatarUrl(final String str, final String str2, final OnGetResult onGetResult) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "getGuildUsersAvatarUrl guildId is empty or tinyId is empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.util.a
                @Override // java.lang.Runnable
                public final void run() {
                    HBUtil.lambda$getGuildUsersAvatarUrl$2(str2, str, onGetResult);
                }
            }, 16, null, true);
        }
    }

    public static void getGuildUsersAvatarUrls(final int i3, @NonNull final ArrayList<String> arrayList, final String str, final OnGetResult onGetResult) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "getGuildUsersAvatarUrls guildId is empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.util.b
                @Override // java.lang.Runnable
                public final void run() {
                    HBUtil.lambda$getGuildUsersAvatarUrls$3(i3, str, arrayList, onGetResult);
                }
            }, 16, null, true);
        }
    }

    public static String getHbTypeText(int i3, int i16) {
        if (isHbForCommand(i3)) {
            if (i3 == 65536) {
                return "\u8bed\u97f3";
            }
            return "\u53e3\u4ee4";
        }
        if (isEmojihb(i3)) {
            return "\u8868\u60c5";
        }
        if (isIdiomHb(i3)) {
            return "\u63a5\u9f99";
        }
        if (isKuaKuaHb(i3)) {
            return "\u5938\u5938";
        }
        if (isShengpiziHb(i3)) {
            return "\u751f\u50fb\u5b57";
        }
        if (isHbForSpecify(i3)) {
            return "\u4e13\u5c5e";
        }
        if (2 == i16) {
            return "\u62fc\u624b\u6c14";
        }
        return "";
    }

    public static int getRecvTypeByGroupType(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 3;
        }
        int i16 = 2;
        if (i3 != 2) {
            i16 = 4;
            if (i3 != 3) {
                if (i3 != 4) {
                    return 1;
                }
                return 5;
            }
        }
        return i16;
    }

    public static void initGuildObserver(final String str, final int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "initGuildObserver guildId is empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.util.c
                @Override // java.lang.Runnable
                public final void run() {
                    HBUtil.lambda$initGuildObserver$4(str, i3);
                }
            }, 16, null, true);
        }
    }

    public static boolean isBirthdayHb(int i3) {
        if (1000004 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isDrawHb(int i3) {
        if (1000001 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isEmojihb(int i3) {
        if (i3 == 262144) {
            return true;
        }
        return false;
    }

    public static boolean isFaceHb(int i3) {
        if (16384 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isFestivalHb(int i3) {
        if (1000005 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isH5CommonHb(String str) {
        try {
            if (Integer.parseInt(str) < 100) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isHbForAR(int i3) {
        if (i3 == 4096) {
            return true;
        }
        return false;
    }

    public static boolean isHbForAnonymity(int i3) {
        if (i3 != 5 && i3 != 16) {
            return false;
        }
        return true;
    }

    public static boolean isHbForChunMing(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    public static boolean isHbForCommand(int i3) {
        if (i3 != 6 && i3 != 32 && i3 != 65536) {
            return false;
        }
        return true;
    }

    public static boolean isHbForEnterprise(int i3) {
        if (i3 != 4 && (i3 != 4 || i3 != 8)) {
            return false;
        }
        return true;
    }

    public static boolean isHbForFaceToFace(int i3) {
        if (i3 == 2048) {
            return true;
        }
        return false;
    }

    public static boolean isHbForQQSpace(int i3) {
        if (i3 != 128 && i3 != 256 && i3 != 32768) {
            return false;
        }
        return true;
    }

    public static boolean isHbForSpecify(int i3) {
        if (i3 == 1024) {
            return true;
        }
        return false;
    }

    public static boolean isIdiomHb(int i3) {
        if (524288 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isKsonghb(int i3) {
        if (i3 == 131072) {
            return true;
        }
        return false;
    }

    public static boolean isKuaKuaHb(int i3) {
        if (1000002 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isShengpiziHb(int i3) {
        if (1000003 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isSoundhb(int i3) {
        if (i3 != 65536 && i3 != 131072) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getGuildMemberName$0(String str, String str2, OnGetResult onGetResult) {
        String guildNick = ((IQWalletGrabApi) QRoute.apiIPCSync(IQWalletGrabApi.class)).getGuildNick(str, str2);
        QLog.i(TAG, 1, "get guild nick from ipc callback guildNick = " + guildNick);
        onGetResult.getResult(guildNick);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getGuildMemberNames$1(int i3, String str, ArrayList arrayList, OnGetResult onGetResult) {
        HashMap<String, String> guildNicks = ((IQWalletGrabApi) QRoute.apiIPCSync(IQWalletGrabApi.class)).getGuildNicks(i3, str, arrayList);
        QLog.i(TAG, 1, "get nick name from ipc callback guildNicks = " + guildNicks);
        onGetResult.getResult(guildNicks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getGuildUsersAvatarUrl$2(String str, String str2, OnGetResult onGetResult) {
        String guildAvatarUrl = ((IQWalletGrabApi) QRoute.apiIPCSync(IQWalletGrabApi.class)).getGuildAvatarUrl(str, str2);
        QLog.i(TAG, 1, "get avatar url from ipc callback guildAvatarUrl = " + guildAvatarUrl);
        onGetResult.getResult(guildAvatarUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getGuildUsersAvatarUrls$3(int i3, String str, ArrayList arrayList, OnGetResult onGetResult) {
        HashMap<String, String> guildAvatarUrls = ((IQWalletGrabApi) QRoute.apiIPCSync(IQWalletGrabApi.class)).getGuildAvatarUrls(i3, str, arrayList);
        QLog.i(TAG, 1, "get avatar url from ipc callback avatarUrls = " + guildAvatarUrls);
        onGetResult.getResult(guildAvatarUrls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initGuildObserver$4(String str, int i3) {
        ((IQWalletGrabApi) QRoute.apiIPCSync(IQWalletGrabApi.class)).initGuildObserver(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$removeAllGuildCallBack$5(int i3) {
        try {
            ((IQWalletGrabApi) QRoute.apiIPCSync(IQWalletGrabApi.class)).removeAllGuildCallback(i3);
        } catch (IllegalStateException e16) {
            QLog.e(TAG, 1, "removeAllGuildCallBack: ", e16);
        }
    }

    public static void loadEntryIcon(ViewGroup viewGroup, ImageView imageView, View view, TextView textView, int i3, String str, String str2) {
        int i16;
        if (viewGroup == null) {
            return;
        }
        try {
            viewGroup.setVisibility(0);
            imageView.setVisibility(0);
            Resources resources = imageView.getResources();
            if (i3 == 2) {
                i16 = R.drawable.dvf;
            } else {
                i16 = R.drawable.dwp;
            }
            Drawable drawable = resources.getDrawable(i16);
            if (TextUtils.isEmpty(str)) {
                imageView.setImageDrawable(drawable);
                playHBAdAnim(view);
            } else {
                view.setVisibility(4);
                Bundle bundle = new Bundle();
                bundle.putBoolean(ApngImage.KEY_USE_FILE_LOOP, true);
                imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str, com.tencent.mobileqq.urldrawable.b.f306350a, drawable, bundle));
            }
            if (TextUtils.isEmpty(str2)) {
                textView.setVisibility(8);
            } else {
                textView.setText(str2);
                textView.setVisibility(0);
            }
        } catch (Throwable th5) {
            QwLog.i("loadEntryIcon error:" + th5.toString());
        }
    }

    public static void notifyGrapedHbClose(Context context, int i3, JSONObject jSONObject, JSONObject jSONObject2, Intent intent) {
        if (i3 == 0 && jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(jSONObject.optString("amount"))) {
                    float parseFloat = Float.parseFloat(jSONObject.optString("amount"));
                    int redPacketGuideMoney = DataProxy.getRedPacketGuideMoney();
                    QwLog.i("notifyGrapedHbClose...,amount:" + parseFloat + ",thresholdMoney:" + redPacketGuideMoney + ",mGrapHBState:" + i3);
                    if (parseFloat >= redPacketGuideMoney) {
                        String stringExtra = intent.getStringExtra("curFriendUin");
                        String stringExtra2 = intent.getStringExtra("senderuin");
                        if (TextUtils.isEmpty(stringExtra2) && jSONObject2 != null) {
                            stringExtra2 = jSONObject2.optString("send_uin");
                        }
                        DataProxy.sendRedPacketFinishNotify(context, stringExtra, stringExtra2);
                        return;
                    }
                    return;
                }
            } catch (Throwable th5) {
                try {
                    QwLog.e("parse amount failed..." + th5.toString());
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
        }
        QwLog.i("notifyGrapedHbClose failed...mRecvObj:" + jSONObject + ",mGrapHBState:" + i3);
    }

    private static void playHBAdAnim(final View view) {
        if (sAdAnimator == null) {
            sAdAnimator = ValueAnimator.ofFloat(0.2f, 0.7f, 0.2f);
        }
        cleanAdAnimator();
        sAdAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tenpay.sdk.util.HBUtil.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                View view2 = view;
                if (view2 != null) {
                    view2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        sAdAnimator.setDuration(1000L);
        sAdAnimator.setRepeatCount(-1);
        sAdAnimator.start();
    }

    public static void processAdJumpByType(Context context, String str, int i3) {
        try {
            QwLog.i("processAdJumpByType url:" + str + ",urlType:" + i3);
            if (i3 == 2) {
                Intent intent = new Intent();
                intent.putExtra(LayoutAttrDefine.CLICK_URI, str);
                com.tencent.mobileqq.base.c.d(context, intent, FullVideoActivity.class);
            } else if (i3 == 1 || i3 == 3) {
                QWalletUtils.k((Activity) context, str);
            }
        } catch (Throwable th5) {
            QwLog.e(th5.getMessage());
        }
    }

    public static void processCashGame(final Context context, ViewGroup viewGroup, View view, ImageView imageView, TextView textView, JSONObject jSONObject) {
        if (viewGroup == null) {
            return;
        }
        try {
            int visibility = viewGroup.getVisibility();
            if (jSONObject != null && visibility != 0) {
                QwLog.i("handleCashGame...treeObj:" + jSONObject);
                final int optInt = jSONObject.optInt("urlType");
                if (!sEnableUrlJumpSet.contains(Integer.valueOf(optInt))) {
                    return;
                }
                String optString = jSONObject.optString("icon");
                final String optString2 = jSONObject.optString("url");
                loadEntryIcon(viewGroup, imageView, view, textView, optInt, optString, jSONObject.optString("tips"));
                viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.util.HBUtil.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        EventCollector.getInstance().onViewClickedBefore(view2);
                        HBUtil.processAdJumpByType(context, optString2, optInt);
                        com.tencent.mobileqq.qwallet.c.e("yqs_hongbao_click", "", "", "", "");
                        EventCollector.getInstance().onViewClicked(view2);
                    }
                });
                com.tencent.mobileqq.qwallet.c.e("yqs_hongbao_show", "", "", "", "");
            } else {
                QwLog.i("handleCashGame...params is invalid,treeObj:" + jSONObject + ",button visibility:" + visibility);
            }
        } catch (Throwable th5) {
            QwLog.e(th5.getMessage());
        }
    }

    public static void removeAllGuildCallBack(final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.util.d
            @Override // java.lang.Runnable
            public final void run() {
                HBUtil.lambda$removeAllGuildCallBack$5(i3);
            }
        }, 16, null, true);
    }
}
