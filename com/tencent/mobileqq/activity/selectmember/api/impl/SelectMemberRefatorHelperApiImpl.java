package com.tencent.mobileqq.activity.selectmember.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.av.utils.az;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relationx.batchAdd.b;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopAddFrd.d;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.dialogutils.a;
import com.tencent.mobileqq.utils.s;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SelectMemberRefatorHelperApiImpl implements ISelectMemberRefatorHelperApi {
    static IPatchRedirector $redirector_;

    public SelectMemberRefatorHelperApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public List<Groups> asyncGetGroupListForUI(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this, (Object) appInterface);
        }
        return ((FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).g();
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public boolean batchAddFriendForTroopMembers(AppInterface appInterface, String str, String str2, String str3, List<String> list, boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) ? batchAddFriendForTroopMembers(appInterface, str, str2, str3, list, z16, i3, i16, 0, 0) : ((Boolean) iPatchRedirector.redirect((short) 24, this, appInterface, str, str2, str3, list, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public void enterTroopAio(Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, context, str, Boolean.valueOf(z16));
        } else {
            TroopUtils.e(context, str, z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public String getAccountNickName(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this, (Object) appInterface, (Object) str);
        }
        return ac.f(appInterface, str);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public Bitmap getFaceBitmap(AppInterface appInterface, int i3, String str, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Bitmap) iPatchRedirector.redirect((short) 15, this, appInterface, Integer.valueOf(i3), str, Boolean.valueOf(z16), Integer.valueOf(i16));
        }
        return ((QQAppInterface) appInterface).getFaceBitmap(i3, str, z16, i16);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public int getMemberType(AppInterface appInterface, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, this, appInterface, str, str2)).intValue();
        }
        return az.a(appInterface, str, str2);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public String getNickName(AppInterface appInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, this, appInterface, str, Integer.valueOf(i3));
        }
        return ac.R((QQAppInterface) appInterface, str, i3);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public long getPublicAccountInfoCertifiedGrade(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this, obj)).longValue();
        }
        return ((PublicAccountInfo) obj).certifiedGrade;
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public String getPublicAccountInfoName(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, obj);
        }
        return ((PublicAccountInfo) obj).name;
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public String getPublicAccountInfoSummary(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, obj);
        }
        return ((PublicAccountInfo) obj).summary;
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public long getPublicAccountInfoUin(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, obj)).longValue();
        }
        return ((PublicAccountInfo) obj).uin;
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public int getSCENE_TYPE_DEFAULT_Value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public String getScene_SP_KEY_BAF_DATA_CHECK_FLAG_MEMBERS_KeyString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return "sp_baf_data_check_flag_members";
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public List<MessageRecord> getSelectedMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (List) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        List<ChatMessage> v3 = MultiMsgManager.w().v();
        MultiMsgManager.w().q();
        return new ArrayList(v3);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public int getSubSourceId_multi(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, i3)).intValue();
        }
        return d.t(i3);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public int getSubSourceId_single(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, i3)).intValue();
        }
        return d.t(i3);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public String getUnitedVerifyMsgEditFragment_VERIFY_MSG_KeyString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return "VERIFY_MSG";
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public boolean isPublicAccountInfoInstance(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, obj)).booleanValue();
        }
        return obj instanceof PublicAccountInfo;
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public boolean isPublicAccountInfoLooker(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, obj)).booleanValue();
        }
        return PublicAccountInfo.isLooker((PublicAccountInfo) obj);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public void launchContactSearchComponentActivityForResult(Activity activity, String str, String str2, int i3, int i16, int i17, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, activity, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bundle);
        } else {
            ContactSearchComponentActivity.Y2(activity, str, str2, i3, i16, i17, bundle);
        }
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public List<MessageRecord> loadHistoryMsg(String str, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (List) iPatchRedirector.redirect((short) 30, this, str, Long.valueOf(j3), Integer.valueOf(i3));
        }
        return ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getMessageFacade().q0(str, 1, j3, i3);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public void notifyResultReceiver(Intent intent, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, obj);
        } else {
            ForwardRecentActivity.notifyResultReceiver(intent, obj);
        }
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public Object showAsDropDown(View view, Object obj, View.OnClickListener onClickListener, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return iPatchRedirector.redirect((short) 14, this, view, obj, onClickListener, obj2);
        }
        return s.d(view, (a) obj, onClickListener, (BubblePopupWindow.OnDismissListener) obj2);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public void showResultForBatchAddFriendData(AppInterface appInterface, Activity activity, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, appInterface, activity, str, obj);
        } else {
            b.j((QQAppInterface) appInterface, activity, str, (List) obj);
        }
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public void startCreateCreateFaceToFaceInviteActivity(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) str);
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) Face2FaceAddFriendActivity.class);
        intent.putExtra("activity_from_type", 1);
        intent.putExtra("activity_troop_uin", str);
        activity.startActivityForResult(intent, 0);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public void startCreateFaceToFaceDiscussionActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            activity.startActivityForResult(new Intent(activity, (Class<?>) CreateFaceToFaceDiscussionActivity.class), 0);
        }
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public void startGroupManager(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            GroupManagerActivity.startGroupManager(activity);
        }
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public void startUnitedVerifyMsgEditFragment(Activity activity, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, str, Integer.valueOf(i3));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("TROOP_UIN", str);
        intent.putExtra("hide_title_left_arrow", true);
        PublicFragmentActivity.startForResult(activity, intent, UnitedVerifyMsgEditFragment.class, i3);
        activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public void updateSelectGradeIcon(ImageView imageView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageView, (Object) str);
        } else {
            QQGameTroopManager.y(imageView, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi
    public boolean batchAddFriendForTroopMembers(AppInterface appInterface, String str, String str2, String str3, List<String> list, boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) ? ((FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).batchAddFriendForTroopMembers(str, str2, str3, list, z16, i3, i16, i17, i18) : ((Boolean) iPatchRedirector.redirect((short) 25, this, appInterface, str, str2, str3, list, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).booleanValue();
    }
}
