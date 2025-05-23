package com.tencent.mobileqq.qqexpand.chat;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J.\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&J$\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J&\u0010\u0013\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&JB\u0010\u001a\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H&J6\u0010\"\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010$\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010#H&J\u001c\u0010&\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u0004H&J&\u0010+\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/IExpandMsgSendHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "selfUin", "matchUin", "", "uinType", "", "getUnLimitMatchUserInfo", "Lvg2/d;", "info", "handleUnLimitMatchUserInfo", "appInterface", "Lcom/tencent/mobileqq/profilecard/data/AllInOne;", "allInOne", "Lcom/tencent/mobileqq/qqexpand/chat/e;", "iSendMsgInterface", SmsPlugin.API_SEND_SMS, "friendUin", "friendNickName", "", "code", "from", "sendMsgInterface", "sendMsgDirectly", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "hasWriteSchoolName", "idx", "schoolName", "schoolID", "showCampusVerifyDialog", "Landroid/app/Activity;", "showMatchCountDialog", "text", UIJsPlugin.EVENT_SHOW_TOAST, "Landroid/content/Context;", "context", "uin", "nickName", "enterAio", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IExpandMsgSendHelper extends QRouteApi {
    void enterAio(@Nullable Context context, @Nullable String uin, @Nullable String nickName);

    void getUnLimitMatchUserInfo(@Nullable BaseQQAppInterface app, @Nullable String selfUin, @Nullable String matchUin, int uinType);

    void handleUnLimitMatchUserInfo(@Nullable BaseQQAppInterface app, int uinType, @Nullable vg2.d info);

    void sendMsg(@Nullable BaseQQAppInterface appInterface, @Nullable AllInOne allInOne, @Nullable e iSendMsgInterface);

    void sendMsgDirectly(@Nullable BaseQQAppInterface appInterface, @Nullable String friendUin, @Nullable String friendNickName, @Nullable byte[] code, int from, @Nullable e sendMsgInterface);

    void showCampusVerifyDialog(@Nullable QBaseActivity activity, boolean hasWriteSchoolName, int idx, @Nullable String schoolName, @Nullable String schoolID);

    void showMatchCountDialog(@Nullable Activity activity);

    void showToast(@Nullable QBaseActivity activity, @Nullable String text);
}
