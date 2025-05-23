package com.tencent.mobileqq.profilecard.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarAigcMagicAvatarApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.ProfileEditDateUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment;
import com.tencent.mobileqq.profilecard.utils.ProfileEditSelectorHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.mobileqq.vas.api.IAIAvatarConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class ProfileEditApiImpl implements IProfileEditApi {
    static IPatchRedirector $redirector_ = null;
    private static final String DTREPORT_PROFILE_HEAD_SET = "pg_user_profile_head_set";
    private static final String ELEMENT_KEY = "is_default";
    private static final String[] ELEMENT_NAME;
    private static final int MENU_ITEM_AIGC_MAGIC_AVATAR = 8;
    private static final int MENU_ITEM_AI_AVATAR = 9;
    private static final int MENU_ITEM_BIG_PIC = 5;
    private static final int MENU_ITEM_CANCEL = 4;
    private static final int MENU_ITEM_MORE_AVATAR = 3;
    private static final int MENU_ITEM_SELECT_PIC_FROM_LOCAL = 1;
    private static final int MENU_ITEM_TAKE_PHOTO = 2;
    private static final int MENU_ITEM_VIEW_HISTORY_HEAD = 0;
    private static final int MENU_ITEM_ZPLAN_AVATAR = 6;
    private static final String MTYPE = "friendlist";
    private static final String PAGE_KEY = "user_profile_fpgid";
    private static final String[] PERMISSIONS_PICK_PHOTO;
    private static final String[] PERMISSIONS_TAKE_PHOTO;
    private static final int RED_DOT_HEIGHT = 18;
    private static final String TAG = "ProfileEditApiImpl";
    private static final int ZPLAN_AVATAR_EDIT_REPORT_ACTION_ID_CLICK = 102;
    private static final int ZPLAN_AVATAR_EDIT_REPORT_ACTION_ID_IMPL = 101;
    private static final int ZPLAN_AVATAR_EDIT_REPORT_AVATAR_ENTRANCE_PROFILE_CARD = 3;
    private static final int ZPLAN_AVATAR_EDIT_REPORT_AVATAR_ENTRANCE_PROFILE_EDIT = 4;
    private BroadcastReceiver avatarUpdateReceiver;
    private String reportZPlanAvatarEditEntrance;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20680);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        ELEMENT_NAME = new String[]{"em_head_set_view", "em_head_set_album", "em_head_set_shoot", "em_head_set_more", "em_head_set_cancel", "em_head_set_view", "em_head_set_zplan", "em_head_set_xsj", "em_bas_profile_test_mode_aigc_photo_btn", "em_head_set_more"};
        PERMISSIONS_TAKE_PHOTO = new String[]{QQPermissionConstants.Permission.CAMERA};
        PERMISSIONS_PICK_PHOTO = new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE};
    }

    public ProfileEditApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.avatarUpdateReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtReportClick(View view) {
        VideoReport.reportEvent("clck", view, null);
    }

    private View getActionSheetZPlanItem(ActionSheet actionSheet, ArrayList<Integer> arrayList, int i3) {
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            if (arrayList.get(i16).intValue() == i3) {
                return actionSheet.findViewById(i16);
            }
        }
        return null;
    }

    private int getFunctionIdByConfigId(int i3) {
        if (i3 == 1) {
            return 5;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                return 2;
            }
            if (i3 == 4) {
                return 1;
            }
            if (i3 == 5) {
                return 3;
            }
            if (i3 != 7) {
                if (i3 != 9) {
                    return -1;
                }
                return 8;
            }
            return 6;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v9 */
    private boolean initActionSheetButtonsByConfig(boolean z16, ActionSheet actionSheet, ArrayList<Integer> arrayList, int i3, String[] strArr) {
        String str;
        int i16;
        JSONArray jSONArray;
        int length;
        boolean enableAvatarNewPage;
        int i17;
        int i18 = 2;
        int i19 = 1;
        if (i3 != 1) {
            if (i3 != 2) {
                str = "";
            } else {
                str = IProfileCardConst.AVATAR_ACTION_SHEET_PROFILE_EDIT;
            }
        } else {
            str = IProfileCardConst.AVATAR_ACTION_SHEET_PROFILE;
        }
        boolean z17 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String d16 = com.tencent.relation.common.config.toggle.c.f364699l.d(str, "");
        if (TextUtils.isEmpty(d16)) {
            return false;
        }
        try {
            jSONArray = new JSONArray(d16);
            length = jSONArray.length();
            enableAvatarNewPage = ((IAIAvatarConfig) QRoute.api(IAIAvatarConfig.class)).enableAvatarNewPage();
            i17 = 0;
        } catch (JSONException e16) {
            e = e16;
            i16 = z17;
        }
        while (i17 < length) {
            JSONObject jSONObject = jSONArray.getJSONObject(i17);
            if (jSONObject.has("id") && jSONObject.has("title")) {
                try {
                    int i26 = jSONObject.getInt("id");
                    if ((!z16 || i26 != i19) && ((z16 || i26 != i18) && ((i26 != 7 || ((IZPlanApi) QRoute.api(IZPlanApi.class)).isZPlanAvatarSettingEnable()) && (i26 != 9 || ((IQQAvatarAigcMagicAvatarApi) QRoute.api(IQQAvatarAigcMagicAvatarApi.class)).enableAigcMagicAvatar())))) {
                        if (enableAvatarNewPage) {
                            if (i26 != 6 && i26 != 7 && i26 != 8 && i26 != 9) {
                                if (i26 == 5) {
                                    actionSheet.addButton(strArr[9]);
                                    arrayList.add(9);
                                }
                            }
                        }
                        int functionIdByConfigId = getFunctionIdByConfigId(i26);
                        if (functionIdByConfigId >= 0) {
                            String optString = jSONObject.optString("title", "");
                            if (!TextUtils.isEmpty(optString)) {
                                if (optString.contains("\u8d85\u7ea7QQ\u79c0")) {
                                    reportZPlanAvatarButtonImp(i3);
                                }
                                actionSheet.addButton(optString);
                                arrayList.add(Integer.valueOf(functionIdByConfigId));
                            }
                        }
                    }
                    i17++;
                    i18 = 2;
                    i19 = 1;
                    z17 = false;
                } catch (JSONException e17) {
                    e = e17;
                    i16 = 0;
                }
            } else {
                QLog.e(TAG, 1, "initActionSheetButtonsByConfig fail. invalid config");
                return false;
            }
            e = e17;
            i16 = 0;
            QLog.e(TAG, 1, e, new Object[i16]);
            return i16;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initActionSheetButtonsByConfig:" + arrayList.toString());
            return true;
        }
        return true;
    }

    private void initActionSheetButtonsInner(AppRuntime appRuntime, QBaseActivity qBaseActivity, View view, ActionSheet actionSheet, String[] strArr, ArrayList<Integer> arrayList, int i3) {
        actionSheet.addButton(strArr[2]);
        arrayList.add(2);
        actionSheet.addButton(strArr[1]);
        arrayList.add(1);
        if (((IZPlanApi) QRoute.api(IZPlanApi.class)).isZPlanAvatarSettingEnable()) {
            actionSheet.addButton(strArr[6]);
            arrayList.add(6);
            reportZPlanAvatarButtonImp(i3);
        }
        if (((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).shouldShowHistoryAvatar(qBaseActivity, appRuntime)) {
            actionSheet.addButton(strArr[0]);
            arrayList.add(0);
        } else if (view != null) {
            actionSheet.addButton(strArr[5]);
            arrayList.add(5);
        }
        actionSheet.addButton(strArr[3]);
        arrayList.add(3);
    }

    private void initActionSheetButtonsReorderInner(AppRuntime appRuntime, QBaseActivity qBaseActivity, View view, ActionSheet actionSheet, String[] strArr, ArrayList<Integer> arrayList, int i3) {
        ArrayList<Integer> arrayList2;
        boolean shouldShowHistoryAvatar = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).shouldShowHistoryAvatar(qBaseActivity, appRuntime);
        if (initActionSheetButtonsByConfig(shouldShowHistoryAvatar, actionSheet, arrayList, i3, strArr) || actionSheet == null) {
            return;
        }
        actionSheet.clear();
        if (arrayList == null) {
            arrayList2 = new ArrayList<>();
        } else {
            arrayList.clear();
            arrayList2 = arrayList;
        }
        if (((IAIAvatarConfig) QRoute.api(IAIAvatarConfig.class)).enableAvatarNewPage()) {
            initActionSheetButtonsWithAIAvtar(appRuntime, qBaseActivity, view, actionSheet, strArr, arrayList2, i3);
            return;
        }
        if (shouldShowHistoryAvatar) {
            actionSheet.addButton(strArr[0]);
            arrayList2.add(0);
        } else if (view != null) {
            actionSheet.addButton(strArr[5]);
            arrayList2.add(5);
        }
        actionSheet.addButton(strArr[1]);
        arrayList2.add(1);
        if (((IZPlanApi) QRoute.api(IZPlanApi.class)).isZPlanAvatarSettingEnable()) {
            actionSheet.addButton(strArr[6]);
            arrayList2.add(6);
            reportZPlanAvatarButtonImp(i3);
        }
        actionSheet.addButton(strArr[3]);
        arrayList2.add(3);
        actionSheet.addButton(strArr[2]);
        arrayList2.add(2);
    }

    private void initActionSheetButtonsWithAIAvtar(AppRuntime appRuntime, QBaseActivity qBaseActivity, View view, ActionSheet actionSheet, String[] strArr, ArrayList<Integer> arrayList, int i3) {
        actionSheet.addButton(strArr[2]);
        arrayList.add(2);
        actionSheet.addButton(strArr[1]);
        arrayList.add(1);
        if (((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).shouldShowHistoryAvatar(qBaseActivity, appRuntime)) {
            actionSheet.addButton(strArr[0]);
            arrayList.add(0);
        } else if (view != null) {
            actionSheet.addButton(strArr[5]);
            arrayList.add(5);
        }
        actionSheet.addButton(strArr[9]);
        arrayList.add(9);
    }

    private void initDtReportCoverSetElement(ActionSheet actionSheet, int i3, int i16, View view, int i17) {
        Object findViewById;
        int i18 = 1;
        int i19 = i16 - 1;
        if (i3 < i19) {
            findViewById = actionSheet.getItemViewById(i3).titleTv;
        } else {
            findViewById = actionSheet.mContentContainer.getChildAt(i19).findViewById(R.id.action_sheet_btnCancel);
        }
        VideoReport.setElementId(findViewById, ELEMENT_NAME[i17]);
        if (i3 == 0) {
            HashMap hashMap = new HashMap();
            if (view != null) {
                i18 = 2;
            }
            hashMap.put(ELEMENT_KEY, Integer.valueOf(i18));
            VideoReport.setElementParams(findViewById, hashMap);
        }
        VideoReport.setElementClickPolicy(findViewById, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(findViewById, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("imp", findViewById, null);
    }

    private void initDtReportHeadSet(ActionSheet actionSheet, View view, int i3, ArrayList<Integer> arrayList) {
        VideoReport.addToDetectionWhitelist(actionSheet.getOwnerActivity());
        HashMap hashMap = new HashMap();
        hashMap.put(PAGE_KEY, Integer.valueOf(i3));
        VideoReport.setPageId(actionSheet.mContentContainer, DTREPORT_PROFILE_HEAD_SET);
        VideoReport.setPageParams(actionSheet.mContentContainer, new PageParams(hashMap));
        int childCount = actionSheet.mContentContainer.getChildCount();
        for (int i16 = 0; i16 < actionSheet.mContentContainer.getChildCount(); i16++) {
            initDtReportCoverSetElement(actionSheet, i16, childCount, view, arrayList.get(i16).intValue());
        }
    }

    private void initZPlanItemRedDotView(AppRuntime appRuntime, QBaseActivity qBaseActivity, ActionSheet actionSheet, ArrayList<Integer> arrayList, int i3) {
        View actionSheetZPlanItem = getActionSheetZPlanItem(actionSheet, arrayList, 6);
        if (actionSheetZPlanItem == null) {
            return;
        }
        ImageView imageView = (ImageView) actionSheetZPlanItem.findViewById(R.id.f166773i54);
        TextView textView = (TextView) actionSheetZPlanItem.findViewById(R.id.action_sheet_button);
        this.reportZPlanAvatarEditEntrance = null;
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).requestAvatarEditEntranceRedDotData(new Function1<String, Unit>(imageView, appRuntime, i3, textView, qBaseActivity) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditApiImpl.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ QBaseActivity val$activity;
            final /* synthetic */ AppRuntime val$app;
            final /* synthetic */ TextView val$buttonText;
            final /* synthetic */ ImageView val$redDot;
            final /* synthetic */ int val$sourceFrom;

            {
                this.val$redDot = imageView;
                this.val$app = appRuntime;
                this.val$sourceFrom = i3;
                this.val$buttonText = textView;
                this.val$activity = qBaseActivity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ProfileEditApiImpl.this, imageView, appRuntime, Integer.valueOf(i3), textView, qBaseActivity);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                }
                if (this.val$redDot != null && (this.val$app instanceof AppInterface)) {
                    ((IZPlanApi) QRoute.api(IZPlanApi.class)).reportAvatarEditEntranceRedDotData(this.val$app, str, 101, this.val$sourceFrom == 1 ? 3 : 4);
                    ProfileEditApiImpl.this.reportZPlanAvatarEditEntrance = str;
                    this.val$redDot.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditApiImpl.3.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            ImageView imageView2 = anonymousClass3.val$redDot;
                            if (imageView2 != null && anonymousClass3.val$buttonText != null && anonymousClass3.val$activity != null) {
                                ((View) imageView2.getParent()).getLayoutParams().height = -1;
                                ((LinearLayout.LayoutParams) AnonymousClass3.this.val$redDot.getLayoutParams()).topMargin = ((AnonymousClass3.this.val$buttonText.getMeasuredHeight() - 18) * (-1)) / 2;
                                AnonymousClass3.this.val$redDot.setVisibility(0);
                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                anonymousClass32.val$redDot.setImageDrawable(ResourcesCompat.getDrawable(anonymousClass32.val$activity.getResources(), R.drawable.skin_tips_dot, null));
                            }
                        }
                    });
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerAvatarUpdateListener$0(QBaseActivity qBaseActivity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            try {
                BroadcastReceiver broadcastReceiver = this.avatarUpdateReceiver;
                this.avatarUpdateReceiver = null;
                qBaseActivity.unregisterReceiver(broadcastReceiver);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "registerAvatarUpdateListener unregister2", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerAvatarUpdateListener(final QBaseActivity qBaseActivity) {
        BroadcastReceiver broadcastReceiver = this.avatarUpdateReceiver;
        if (broadcastReceiver != null) {
            try {
                this.avatarUpdateReceiver = null;
                qBaseActivity.unregisterReceiver(broadcastReceiver);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "registerAvatarUpdateListener unregister1", e16);
            }
        }
        this.avatarUpdateReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditApiImpl.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditApiImpl.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                } else {
                    QQToast.makeText(context, 2, R.string.f238947l5, 1).show();
                    context.unregisterReceiver(this);
                }
            }
        };
        qBaseActivity.registerReceiver(this.avatarUpdateReceiver, new IntentFilter(FaceConstant.HeadBroadcast.BROADCAST_QQHEAD_SELF_UPDATE));
        qBaseActivity.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.profilecard.api.impl.e
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                ProfileEditApiImpl.this.lambda$registerAvatarUpdateListener$0(qBaseActivity, lifecycleOwner, event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportZPlanAvatarButtonClick(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_avatar_edit_entrance", str);
        hashMap.put("zplan_action_type", "click");
        VideoReport.reportEvent("ev_zplan_avatar_edit_entrance", hashMap);
    }

    private void reportZPlanAvatarButtonImp(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_avatar_edit_entrance", String.valueOf(i3 + 2));
        hashMap.put("zplan_action_type", "imp");
        VideoReport.reportEvent("ev_zplan_avatar_edit_entrance", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPhotoPicker(QBaseActivity qBaseActivity, int i3, String str) {
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).startPhotoPicker(qBaseActivity, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPhotoPickerWithPermission(QBaseActivity qBaseActivity, int i3, String str) {
        boolean z16;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (qBaseActivity.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QQPermissionFactory.getQQPermission(qBaseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.PROFILE_CARD_EDIT_PICK_AVATAR_PHOTO)).requestPermissions(PERMISSIONS_PICK_PHOTO, 2, new QQPermission.BasePermissionsListener(qBaseActivity, i3, str) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditApiImpl.6
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ QBaseActivity val$activity;
                    final /* synthetic */ String val$broadcastActionName;
                    final /* synthetic */ int val$sourceFrom;

                    {
                        this.val$activity = qBaseActivity;
                        this.val$sourceFrom = i3;
                        this.val$broadcastActionName = str;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, ProfileEditApiImpl.this, qBaseActivity, Integer.valueOf(i3), str);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                    public void onAllGranted() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            super.onAllGranted();
                            ProfileEditApiImpl.this.startPhotoPicker(this.val$activity, this.val$sourceFrom, this.val$broadcastActionName);
                        }
                    }
                });
            } else {
                startPhotoPicker(qBaseActivity, i3, str);
            }
            registerAvatarUpdateListener(qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTakePhotoWithPermission(QBaseActivity qBaseActivity, IProfileEditApi.OnTakePhotoListener onTakePhotoListener, int i3) {
        boolean z16;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (qBaseActivity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QQPermissionFactory.getQQPermission(qBaseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.PROFILE_CARD_EDIT_TAKE_AVATAR_PHOTO)).requestPermissions(PERMISSIONS_TAKE_PHOTO, 2, new QQPermission.BasePermissionsListener(qBaseActivity, onTakePhotoListener, i3) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditApiImpl.5
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ QBaseActivity val$activity;
                    final /* synthetic */ IProfileEditApi.OnTakePhotoListener val$listener;
                    final /* synthetic */ int val$sourceFrom;

                    {
                        this.val$activity = qBaseActivity;
                        this.val$listener = onTakePhotoListener;
                        this.val$sourceFrom = i3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, ProfileEditApiImpl.this, qBaseActivity, onTakePhotoListener, Integer.valueOf(i3));
                        }
                    }

                    @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                    public void onAllGranted() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        super.onAllGranted();
                        Uri startTakePhoto = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).startTakePhoto(this.val$activity);
                        IProfileEditApi.OnTakePhotoListener onTakePhotoListener2 = this.val$listener;
                        if (onTakePhotoListener2 != null) {
                            onTakePhotoListener2.onStartTakePhoto(startTakePhoto);
                            this.val$listener.onSetSourceFrom(this.val$sourceFrom);
                        }
                    }
                });
            } else {
                Uri startTakePhoto = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).startTakePhoto(qBaseActivity);
                if (onTakePhotoListener != null) {
                    onTakePhotoListener.onStartTakePhoto(startTakePhoto);
                    onTakePhotoListener.onSetSourceFrom(i3);
                }
            }
            registerAvatarUpdateListener(qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActionSheetRedTouch(QBaseActivity qBaseActivity, ActionSheet actionSheet, ArrayList<Integer> arrayList, int i3, boolean z16) {
        int indexOf;
        ActionSheet.ItemViewHolder itemViewById;
        TextView textView;
        if (qBaseActivity == null || (indexOf = arrayList.indexOf(Integer.valueOf(i3))) < 0 || indexOf >= arrayList.size() || (itemViewById = actionSheet.getItemViewById(indexOf)) == null || (textView = itemViewById.titleTv) == null) {
            return;
        }
        ((IQQAvatarAigcMagicAvatarApi) QRoute.api(IQQAvatarAigcMagicAvatarApi.class)).updateEntryRedTouch(qBaseActivity, textView, z16);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi
    public boolean checkoutBirthDayValid(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        return ProfileEditDateUtils.checkBirthDayValid(i3, i16, i17);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi
    public void downloadHDAvatar(String str, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) appRuntime);
        } else {
            ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditApiImpl.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$uin;

                {
                    this.val$uin = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditApiImpl.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(ProfileEditApiImpl.TAG, 2, "downloadHDAvatar: uin=" + this.val$uin);
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null) {
                        return;
                    }
                    String avatarCacheNewPath = FaceUtil.getAvatarCacheNewPath(this.val$uin);
                    if (!TextUtils.isEmpty(avatarCacheNewPath)) {
                        FileUtils.deleteFile(avatarCacheNewPath);
                    }
                    IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "");
                    Setting qQHeadSettingFromDB = iQQAvatarDataService.getQQHeadSettingFromDB(this.val$uin);
                    if (qQHeadSettingFromDB != null && !TextUtils.isEmpty(qQHeadSettingFromDB.url)) {
                        HttpDownloadUtil.downloadData(peekAppRuntime, new DownloadInfo(MsfSdkUtils.insertMtype(ProfileEditApiImpl.MTYPE, AvatarDownloadUtil.get1080QQHeadDownLoadUrl(qQHeadSettingFromDB.url, qQHeadSettingFromDB.bFaceFlags)), new File(FaceUtil.getAvatarCacheNewPath(this.val$uin)), 0), (HttpDownloadUtil.b) null);
                        iQQAvatarDataService.setHistoryAvatarPath(FaceUtil.getAvatarCacheOldPath(this.val$uin));
                    }
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi
    public int getSourceTypeFromeProfileType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, i3)).intValue();
        }
        switch (i3) {
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                return 1;
            default:
                return 3;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi
    public void openProfileAgeSelector(Context context, int i3, int i16, IProfileEditApi.BirthdayEditListener birthdayEditListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, Integer.valueOf(i3), Integer.valueOf(i16), birthdayEditListener);
        } else {
            ProfileEditSelectorHelper.getInstance().openProfileAgeSelector(context, i3, i16, birthdayEditListener);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi
    public void openProfileBirthdaySelector(Context context, int i3, int i16, IProfileEditApi.BirthdayEditListener birthdayEditListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, Integer.valueOf(i3), Integer.valueOf(i16), birthdayEditListener);
        } else {
            ProfileEditSelectorHelper.getInstance().openProfileBirthdaySelector(context, i3, i16, birthdayEditListener);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi
    public void openProfileEdit(Context context, AllInOne allInOne, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            openProfileEdit(context, allInOne, z16, null);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, allInOne, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi
    public void openProfileGenderSelector(Context context, int i3, int i16, IProfileEditApi.GenderEditListener genderEditListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, Integer.valueOf(i3), Integer.valueOf(i16), genderEditListener);
        } else {
            ProfileEditSelectorHelper.getInstance().openProfileGenderSelector(context, i3, i16, genderEditListener);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi
    public void openProfileLocationSelector(Context context, Card card, int i3, IProfileEditApi.LocationEditListener locationEditListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, card, Integer.valueOf(i3), locationEditListener);
        } else {
            ProfileEditSelectorHelper.getInstance().openProfileLocationSelector(context, card, i3, locationEditListener);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi
    public boolean shouldOpenNewProfileEdit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean isNowElderMode = SimpleUIUtil.isNowElderMode();
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        QLog.i(TAG, 1, "shouldOpenNewProfileEdit isElderMode " + isNowElderMode + " isSimpleUI " + isNowSimpleUI);
        if (isNowElderMode || isNowSimpleUI) {
            return true;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_PERSONAL_PROFILE_DEFAULT_MODE);
        expEntity.reportExpExposure();
        return expEntity.isExperiment();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi
    public void showAvatarActionSheet(AppRuntime appRuntime, QBaseActivity qBaseActivity, View view, AllInOne allInOne, IProfileEditApi.OnTakePhotoListener onTakePhotoListener, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appRuntime, qBaseActivity, view, allInOne, onTakePhotoListener, Integer.valueOf(i3), str);
            return;
        }
        if (qBaseActivity == null) {
            return;
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(qBaseActivity, null);
        String[] stringArray = qBaseActivity.getResources().getStringArray(R.array.f155207bm);
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (com.tencent.relation.common.config.toggle.c.f364699l.g(false)) {
            initActionSheetButtonsReorderInner(appRuntime, qBaseActivity, view, actionSheet, stringArray, arrayList, i3);
        } else if (((IAIAvatarConfig) QRoute.api(IAIAvatarConfig.class)).enableAvatarNewPage()) {
            initActionSheetButtonsWithAIAvtar(appRuntime, qBaseActivity, view, actionSheet, stringArray, arrayList, i3);
        } else {
            initActionSheetButtonsInner(appRuntime, qBaseActivity, view, actionSheet, stringArray, arrayList, i3);
        }
        actionSheet.addCancelButton(stringArray[4]);
        arrayList.add(4);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener(arrayList, actionSheet, qBaseActivity, i3, str, onTakePhotoListener, allInOne, appRuntime, view) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditApiImpl.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ActionSheet val$actionSheet;
            final /* synthetic */ QBaseActivity val$activity;
            final /* synthetic */ AllInOne val$allInOne;
            final /* synthetic */ AppRuntime val$app;
            final /* synthetic */ View val$avatar;
            final /* synthetic */ String val$broadcastActionName;
            final /* synthetic */ ArrayList val$buttonIdList;
            final /* synthetic */ IProfileEditApi.OnTakePhotoListener val$listener;
            final /* synthetic */ int val$sourceFrom;

            {
                this.val$buttonIdList = arrayList;
                this.val$actionSheet = actionSheet;
                this.val$activity = qBaseActivity;
                this.val$sourceFrom = i3;
                this.val$broadcastActionName = str;
                this.val$listener = onTakePhotoListener;
                this.val$allInOne = allInOne;
                this.val$app = appRuntime;
                this.val$avatar = view;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ProfileEditApiImpl.this, arrayList, actionSheet, qBaseActivity, Integer.valueOf(i3), str, onTakePhotoListener, allInOne, appRuntime, view);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
            
                if (r9 != 9) goto L49;
             */
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view2, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2, i16);
                    return;
                }
                if (i16 >= 0 && i16 < this.val$buttonIdList.size()) {
                    ProfileEditApiImpl.this.dtReportClick(this.val$actionSheet.getItemViewById(i16).titleTv);
                    int intValue = ((Integer) this.val$buttonIdList.get(i16)).intValue();
                    if (intValue != 0) {
                        if (intValue == 1) {
                            ProfileEditApiImpl.this.startPhotoPickerWithPermission(this.val$activity, this.val$sourceFrom, this.val$broadcastActionName);
                        } else if (intValue == 2) {
                            ProfileEditApiImpl.this.startTakePhotoWithPermission(this.val$activity, this.val$listener, this.val$sourceFrom);
                        } else {
                            int i17 = 3;
                            if (intValue != 3) {
                                if (intValue != 5) {
                                    if (intValue != 6) {
                                        if (intValue == 8) {
                                            ProfileEditApiImpl.this.updateActionSheetRedTouch(this.val$activity, this.val$actionSheet, this.val$buttonIdList, 8, false);
                                            ((IQQAvatarAigcMagicAvatarApi) QRoute.api(IQQAvatarAigcMagicAvatarApi.class)).handleActionSheetItemClick(this.val$activity);
                                            ProfileEditApiImpl.this.registerAvatarUpdateListener(this.val$activity);
                                        }
                                    } else {
                                        String valueOf = String.valueOf(this.val$sourceFrom + 2);
                                        ((IZPlanApi) QRoute.api(IZPlanApi.class)).openZPlanAvatarPicEditPage(this.val$activity, valueOf, null);
                                        ProfileEditApiImpl.this.reportZPlanAvatarButtonClick(valueOf);
                                        if (ProfileEditApiImpl.this.reportZPlanAvatarEditEntrance != null && (this.val$app instanceof AppInterface)) {
                                            if (this.val$sourceFrom != 1) {
                                                i17 = 4;
                                            }
                                            ((IZPlanApi) QRoute.api(IZPlanApi.class)).reportAvatarEditEntranceRedDotData(this.val$app, ProfileEditApiImpl.this.reportZPlanAvatarEditEntrance, 102, i17);
                                            ProfileEditApiImpl.this.reportZPlanAvatarEditEntrance = null;
                                        }
                                    }
                                } else {
                                    ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).startProfileImageActivity(this.val$app, this.val$activity, this.val$avatar, this.val$allInOne.uin);
                                }
                            }
                            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).startAvatarPendantActivity(this.val$activity, this.val$allInOne);
                        }
                    } else {
                        Intent intent = new Intent(this.val$activity, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", ProfileContants.HISTORY_HEAD_VIEW_URL);
                        intent.putExtra("AVATAR_TO_CIRCLE_PUBLISH_HISTORY", true);
                        intent.putExtra("AVATAR_TO_EXPERIENCE_FROM_TYPE", this.val$sourceFrom);
                        this.val$activity.startActivity(intent);
                    }
                    try {
                        this.val$actionSheet.dismiss();
                        return;
                    } catch (Exception e16) {
                        QLog.e(ProfileEditApiImpl.TAG, 1, "action sheet dismiss error", e16);
                        return;
                    }
                }
                this.val$actionSheet.dismiss();
            }
        });
        actionSheet.setOnBottomCancelListener(new View.OnClickListener(actionSheet) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditApiImpl.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ ActionSheet val$actionSheet;

            {
                this.val$actionSheet = actionSheet;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditApiImpl.this, (Object) actionSheet);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ProfileEditApiImpl.this.dtReportClick(view2);
                    this.val$actionSheet.dismiss();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2);
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        try {
            if (!qBaseActivity.isFinishing()) {
                actionSheet.show();
                initZPlanItemRedDotView(appRuntime, qBaseActivity, actionSheet, arrayList, i3);
                updateActionSheetRedTouch(qBaseActivity, actionSheet, arrayList, 8, true);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "action sheet show error", e16);
        }
        initDtReportHeadSet(actionSheet, view, i3, arrayList);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi
    public void openProfileEdit(Context context, AllInOne allInOne, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, allInOne, Boolean.valueOf(z16), bundle);
            return;
        }
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
        intent.putExtra(IProfileCardConst.KEY_SHOW_ACTION_SHEET, z16);
        QPublicFragmentActivity.start(context, intent, ProfileEditFragment.class);
    }
}
