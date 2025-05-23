package com.tencent.mobileqq.newfriend.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.controller.FriendSystemMsgController;
import com.tencent.mobileqq.newfriend.ui.activity.NewFriendActivity;
import com.tencent.mobileqq.newfriend.ui.activity.NewFriendMoreSysMsgActivity;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.newfriend.ui.view.UnverifyBlockContainer;
import com.tencent.mobileqq.newfriend.utils.a;
import com.tencent.mobileqq.newfriend.utils.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.zplan.newfriend.ui.activity.ZPlanNewFriendFragment;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NewFriendApiImpl implements INewFriendApi {
    static IPatchRedirector $redirector_;

    public NewFriendApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void clearStructMsgMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            FriendSystemMsgController.e().a();
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void clearSystemMsgData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            FriendSystemMsgController.e().b();
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public FrameLayout createUnverifyBlock(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 42, (Object) this, (Object) context);
        }
        return new UnverifyBlockContainer(context);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public long getCurrStructMsgKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return FriendSystemMsgController.e().c();
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public long getCurrentUniseq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return FriendSystemMsgController.e().d();
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public int getMsgNumber() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            return ((NewFriendServiceImpl) appInterface.getRuntimeService(INewFriendService.class, "")).getAllMessageCount();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public Intent getNewFriendJumpIntent(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Intent) iPatchRedirector.redirect((short) 37, (Object) this, (Object) context);
        }
        return new Intent(context, (Class<?>) NewFriendActivity.class);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public String getNewFriendTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return NewFriendServiceImpl.NEW_FRIEND_TAG;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public long getOldestSysMsgTime(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Long) iPatchRedirector.redirect((short) 24, (Object) this, (Object) appInterface)).longValue();
        }
        return FriendSystemMsgController.e().f(appInterface);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public Intent getStartNewFriendMoreSysMsgActivityIntent(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Intent) iPatchRedirector.redirect((short) 28, (Object) this, (Object) context, i3);
        }
        Intent intent = new Intent(context, (Class<?>) NewFriendMoreSysMsgActivity.class);
        intent.putExtra("first_visible_index", i3);
        return intent;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public structmsg$StructMsg getStructMsgFromMap(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (structmsg$StructMsg) iPatchRedirector.redirect((short) 13, (Object) this, (Object) l3);
        }
        return FriendSystemMsgController.e().g(l3);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public boolean getSysMsgOverValue(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) appInterface)).booleanValue();
        }
        return FriendSystemMsgController.e().h(appInterface);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public int getUiBuilderExposeCnt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return NewFriendVerificationServiceImpl.getUiBuilderExposeCnt();
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public int getUnReadFriendSystemMsgNum(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) appInterface)).intValue();
        }
        return FriendSystemMsgController.e().i(appInterface);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public int getZPlanUnreadNum() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this)).intValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            return ((NewFriendServiceImpl) appInterface.getRuntimeService(INewFriendService.class, "")).getAllZPlanUnreadMessageCount();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public boolean isHasNoMoreMsg(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) appInterface)).booleanValue();
        }
        return FriendSystemMsgController.e().j(appInterface);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public boolean isSuspiciousSysMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return NewFriendServiceImpl.isSuspiciousSysMsg(messageRecord);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void jumpToNewFriendVerifyListAct(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            a.b(activity);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public com.tencent.mobileqq.newfriend.config.a loadNewFriendContactGuideConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (com.tencent.mobileqq.newfriend.config.a) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return new com.tencent.mobileqq.newfriend.config.a();
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void logMsg(String str, List<? extends MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, (Object) list);
        } else {
            NewFriendServiceImpl.logMsg(str, list);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public boolean openProfileCard(AppRuntime appRuntime, Context context, String str, long j3, int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, this, appRuntime, context, str, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), intent)).booleanValue();
        }
        return b.c(appRuntime, context, str, j3, i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void openProfileCardNeedTrackBack(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) context, (Object) str);
        } else {
            b.e(context, str);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void putStructMsgToMap(Long l3, structmsg$StructMsg structmsg_structmsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) l3, (Object) structmsg_structmsg);
        } else {
            FriendSystemMsgController.e().k(l3, structmsg_structmsg);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void report(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) appRuntime, (Object) str);
        } else {
            NewFriendActivity.report(appRuntime, str);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void setBtnNewStyle(Button button) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) button);
        } else {
            a.c(button);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void setCurrStructMsgKey(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
        } else {
            FriendSystemMsgController.e().l(j3);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void setCurrentUniseq(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            FriendSystemMsgController.e().m(j3);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void setFromSysSubMsgType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3);
        } else {
            NewFriendActivity.setFromSysSubMsgType(i3);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void setHasNoMoreMsg(boolean z16, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), appInterface);
        } else {
            FriendSystemMsgController.e().n(z16, appInterface);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void setOldestSysMsgTime(AppInterface appInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, appInterface, Long.valueOf(j3));
        } else {
            FriendSystemMsgController.e().o(appInterface, j3);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void setStructMsgToMap(structmsg$StructMsg structmsg_structmsg, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, structmsg_structmsg, Long.valueOf(j3));
        } else if (structmsg_structmsg != null) {
            long j16 = structmsg_structmsg.get().msg_seq.get() + structmsg_structmsg.get().msg_type.get();
            FriendSystemMsgController.e().k(Long.valueOf(j16), structmsg_structmsg.get());
            FriendSystemMsgController.e().l(j16);
            FriendSystemMsgController.e().m(j3);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void setSysMsgOverValue(AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, appInterface, Boolean.valueOf(z16));
        } else {
            FriendSystemMsgController.e().p(appInterface, z16);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void setTextNewStyle(TextView textView, TextView textView2, TextView textView3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, textView, textView2, textView3);
        } else {
            a.e(textView, textView2, textView3);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void setUiBuilderExposeCnt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            NewFriendVerificationServiceImpl.setUiBuilderExposeCnt(i3);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void setUnReadFriendSystemMsgNum(AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) appInterface, i3);
        } else {
            FriendSystemMsgController.e().q(appInterface, i3);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public boolean shouldMergeNewFriendContact(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) appInterface, (Object) str)).booleanValue();
        }
        return NewFriendServiceImpl.shouldMergeNewFriendContact(appInterface, str);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void showGenderAge(TextView textView, int i3, int i16, StringBuilder sb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), Integer.valueOf(i16), sb5);
        } else {
            a.f(textView, i3, i16, sb5);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void showGenderAgeNewStyle(TextView textView, int i3, int i16, StringBuilder sb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, textView, Integer.valueOf(i3), Integer.valueOf(i16), sb5);
        } else {
            a.g(textView, i3, i16, sb5);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void startActivity(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, context, intent, Integer.valueOf(i3));
        } else {
            NewFriendActivity.startActivity(context, intent, i3);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void startNewFriendMoreSysMsgActivityForResult(Activity activity, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, activity, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            NewFriendMoreSysMsgActivity.startNewFriendMoreSysMsgActivityForResult(activity, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void startZPlanNewFriendFragment(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (!(context instanceof Activity)) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, intent, ZPlanNewFriendFragment.class);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void updateItemBg(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, view, Boolean.valueOf(z16));
        } else {
            a.h(view, z16);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void updateItemBgKeepPadding(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, view, Boolean.valueOf(z16));
        } else {
            d.j(view, z16);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendApi
    public void updateItemViewHeightForList(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) view, i3);
        } else {
            d.m(view, i3);
        }
    }
}
