package com.tencent.mobileqq.qqexpand.chat.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper;
import com.tencent.mobileqq.qqexpand.chat.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import kotlin.Metadata;
import vg2.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J.\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J$\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\u0013\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016JB\u0010\u001a\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016J6\u0010\"\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010$\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010#H\u0016J\u001c\u0010&\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010+\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/impl/ExpandMsgSendHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/IExpandMsgSendHelper;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "selfUin", "matchUin", "", "uinType", "", "getUnLimitMatchUserInfo", "Lvg2/d;", "info", "handleUnLimitMatchUserInfo", "appInterface", "Lcom/tencent/mobileqq/profilecard/data/AllInOne;", "allInOne", "Lcom/tencent/mobileqq/qqexpand/chat/e;", "iSendMsgInterface", SmsPlugin.API_SEND_SMS, "friendUin", "friendNickName", "", "code", "from", "sendMsgInterface", "sendMsgDirectly", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "hasWriteSchoolName", "idx", "schoolName", "schoolID", "showCampusVerifyDialog", "Landroid/app/Activity;", "showMatchCountDialog", "text", UIJsPlugin.EVENT_SHOW_TOAST, "Landroid/content/Context;", "context", "uin", "nickName", "enterAio", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ExpandMsgSendHelperImpl implements IExpandMsgSendHelper {
    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper
    public void enterAio(Context context, String uin, String nickName) {
        ExtendFriendSendMsgHelper.d(context, uin, nickName);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper
    public void getUnLimitMatchUserInfo(BaseQQAppInterface app, String selfUin, String matchUin, int uinType) {
        ExtendFriendSendMsgHelper.f(app, selfUin, matchUin, uinType);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper
    public void handleUnLimitMatchUserInfo(BaseQQAppInterface app, int uinType, d info) {
        ExtendFriendSendMsgHelper.g(app, uinType, info);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper
    public void sendMsg(BaseQQAppInterface appInterface, AllInOne allInOne, e iSendMsgInterface) {
        ExtendFriendSendMsgHelper.e(appInterface).h(appInterface, allInOne, iSendMsgInterface);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper
    public void sendMsgDirectly(BaseQQAppInterface appInterface, String friendUin, String friendNickName, byte[] code, int from, e sendMsgInterface) {
        ExtendFriendSendMsgHelper.e(appInterface).i(appInterface, friendUin, friendNickName, code, from, sendMsgInterface);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper
    public void showCampusVerifyDialog(QBaseActivity activity, boolean hasWriteSchoolName, int idx, String schoolName, String schoolID) {
        ExtendFriendSendMsgHelper.j(activity, hasWriteSchoolName, idx, schoolName, schoolID);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper
    public void showMatchCountDialog(Activity activity) {
        ExtendFriendSendMsgHelper.k(activity);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper
    public void showToast(QBaseActivity activity, String text) {
        ExtendFriendSendMsgHelper.l(activity, text);
    }
}
