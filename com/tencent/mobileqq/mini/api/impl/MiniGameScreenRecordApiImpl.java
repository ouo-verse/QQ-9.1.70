package com.tencent.mobileqq.mini.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.mini.api.IConfirmDeleteCallback;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniGameScreenRecordApi;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.startup.permission.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IGamePermissionManagerService;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_MINIAPP_SAVE, scene = QQPermissionConstants.Business.SCENE.QQ_MINIAPP_SAVA_VIDEO)
/* loaded from: classes33.dex */
public class MiniGameScreenRecordApiImpl implements IMiniGameScreenRecordApi {
    private static final int CAN_SHOW_DIALOG_VALUE = 0;
    private static final int NOT_SHOW_DIALOG_VALUE = 1;
    private static final String[] PERMISSIONS = {QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE};
    private static final String PREFERENCE_NAME = "mini_game_screen_record";
    private static final String PREF_KEY_IS_EVER_SHOW_SCREEN_RECORD = "is_ever_show_screen_record";
    private static final String PREF_KEY_IS_SHOW_CONFIRM_DIALOG = "is_show_confirm_dialog";
    private static final int QCIRCLE_PUBLIC_PAGE = 4;
    private static final int QCIRCLE_VIDEO_EDITION_PAGE = 3;
    public static final String TAG = "IMiniGameScreenRecordImpl";
    private QQPermission mQQPermission = null;
    private BusinessConfig mPermissionConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_MINIAPP_SAVE, QQPermissionConstants.Business.SCENE.QQ_MINIAPP_SAVA_VIDEO);

    private int canShowDialog(String str) {
        return BaseApplication.getContext().getSharedPreferences(PREFERENCE_NAME, 0).getInt(str + PREF_KEY_IS_SHOW_CONFIRM_DIALOG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkStoragePermission(String str, String str2, Activity activity, final a.b bVar) {
        if (this.mQQPermission == null) {
            this.mQQPermission = QQPermissionFactory.getQQPermission(activity, this.mPermissionConfig);
        }
        QQPermission qQPermission = this.mQQPermission;
        if (qQPermission == null) {
            return false;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (appInterface == null) {
            return false;
        }
        ((IGamePermissionManagerService) appInterface.getRuntimeService(IGamePermissionManagerService.class, "all")).showPermissionConfirmDialog(activity, str, str2, activity.getString(R.string.xyr), activity.getString(R.string.xyq), new bs3.a() { // from class: com.tencent.mobileqq.mini.api.impl.MiniGameScreenRecordApiImpl.2
            @Override // bs3.a
            public void onConfirmResult(boolean z16) {
                if (z16) {
                    MiniGameScreenRecordApiImpl.this.mQQPermission.requestPermissions(MiniGameScreenRecordApiImpl.PERMISSIONS, 2, new QQPermission.BasePermissionsListener() { // from class: com.tencent.mobileqq.mini.api.impl.MiniGameScreenRecordApiImpl.2.1
                        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                        public void onAllGranted() {
                            super.onAllGranted();
                            bVar.allow();
                        }

                        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                        public void onDenied(List<String> list, List<Integer> list2) {
                            super.onDenied(list, list2);
                            bVar.reject();
                        }
                    });
                }
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmDialogReport(String str, boolean z16, boolean z17) {
        String str2;
        String str3;
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        if (z17) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        if (z16) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        iMiniAppService.reportByQQ(str, "lp_result", UinConfigManager.KEY_ADS, "", str, str2, str3, "");
    }

    private String getQCircleSchemaParam(int i3, String str, String str2) {
        return "mqqapi://qcircle/openqqpublish?mediaPath=" + str2 + "&target=" + i3 + "&taskname=\u6e38\u620f&mini_game_id=" + str + "&exit_dialog=1&taskid=minigame-0001";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCanShowDialog(int i3, String str) {
        BaseApplication.getContext().getSharedPreferences(PREFERENCE_NAME, 0).edit().putInt(str + PREF_KEY_IS_SHOW_CONFIRM_DIALOG, i3).commit();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniGameScreenRecordApi
    public boolean isEverShowScreenRecord() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        boolean decodeBool = from.decodeBool(PREF_KEY_IS_EVER_SHOW_SCREEN_RECORD, false);
        if (!decodeBool) {
            from.encodeBool(PREF_KEY_IS_EVER_SHOW_SCREEN_RECORD, true).commitAsync();
        }
        return decodeBool;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniGameScreenRecordApi
    public void jump2QCircleVideoEditionPage(String str, String str2, Activity activity) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Intent intent = new Intent(activity, (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse(getQCircleSchemaParam(3, str, str2)));
            activity.startActivity(intent);
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportByQQ(str, "lp_result", "edit", "", str, "", "", "");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[openQCirclePublishPage], error:" + th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniGameScreenRecordApi
    public void openQCirclePublishPage(String str, String str2, Activity activity) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Intent intent = new Intent(activity, (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse(getQCircleSchemaParam(4, str, str2)));
            activity.startActivity(intent);
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportByQQ(str, "lp_result", "share", "share_xsj", str, "", "", "");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[openQCirclePublishPage], error:" + th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniGameScreenRecordApi
    public void saveRecordVideo(final String str, final String str2, final String str3, final String str4, final Activity activity) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.MiniGameScreenRecordApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                final File file = new File(str4);
                final AIOGalleryUtils.d dVar = new AIOGalleryUtils.d() { // from class: com.tencent.mobileqq.mini.api.impl.MiniGameScreenRecordApiImpl.1.1
                    @Override // com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.d
                    public void onSavePhotoResult(boolean z16) {
                        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
                        String str5 = str3;
                        iMiniAppService.reportByQQ(str5, "lp_result", "save", "", str5, "", "", "");
                    }
                };
                if (MiniGameScreenRecordApiImpl.this.checkStoragePermission(str2, str, activity, new a.b() { // from class: com.tencent.mobileqq.mini.api.impl.MiniGameScreenRecordApiImpl.1.2
                    @Override // com.tencent.util.PermissionUtil.SDCardPermissionCallback
                    public void allow() {
                        Activity activity2 = activity;
                        File file2 = file;
                        AIOGalleryUtils.p(activity2, file2, file2.getName(), dVar);
                    }

                    @Override // com.tencent.util.PermissionUtil.SDCardPermissionCallback
                    public void reject() {
                    }
                })) {
                    AIOGalleryUtils.p(activity, file, file.getName(), dVar);
                }
            }
        }, 64, null, true);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniGameScreenRecordApi
    public void shareRecordVideo2Friend(String str, String str2, Activity activity) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            FileInfo fileInfo = new FileInfo(str2);
            FileManagerEntity newEntityByLocalFileInfo = FileManagerUtil.newEntityByLocalFileInfo(fileInfo);
            ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
            forwardFileInfo.E(newEntityByLocalFileInfo.nSessionId);
            forwardFileInfo.w(3);
            forwardFileInfo.N(10000);
            forwardFileInfo.C(fileInfo.k());
            forwardFileInfo.y(fileInfo.j());
            forwardFileInfo.z(fileInfo.l());
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 0);
            bundle.putParcelable("fileinfo", forwardFileInfo);
            bundle.putBoolean("not_forward", true);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, forwardFileInfo.f());
            intent.putExtra("forward_type", 0);
            intent.putExtra("forward _key_nojump", false);
            ForwardBaseOption.startForwardActivityForResult(activity, intent, 103);
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportByQQ(str, "lp_result", "share", "share_QQ", str, "", "", "");
        } catch (FileNotFoundException e16) {
            QLog.e(TAG, 1, "file error:" + e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniGameScreenRecordApi
    public void shareRecordVideo2TargetFriend(String str, String str2, Activity activity, String str3, int i3) {
        try {
            FileInfo fileInfo = new FileInfo(str2);
            FileManagerEntity newEntityByLocalFileInfo = FileManagerUtil.newEntityByLocalFileInfo(fileInfo);
            ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
            forwardFileInfo.E(newEntityByLocalFileInfo.nSessionId);
            forwardFileInfo.w(3);
            forwardFileInfo.N(10000);
            forwardFileInfo.C(fileInfo.k());
            forwardFileInfo.y(fileInfo.j());
            forwardFileInfo.z(fileInfo.l());
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 0);
            bundle.putParcelable("fileinfo", forwardFileInfo);
            bundle.putBoolean("not_forward", true);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, forwardFileInfo.f());
            intent.putExtra("forward_type", 0);
            intent.putExtra("forward _key_nojump", false);
            ((IFileDepend) QRoute.api(IFileDepend.class)).forwardToTargetFriend(activity, intent, false, str3, i3);
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportByQQ(str, "lp_result", "share", "share_QQ", str, "", "", "");
        } catch (FileNotFoundException e16) {
            QLog.e(TAG, 1, "file error:" + e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniGameScreenRecordApi
    public void showDeleteVideoConfirmDialog(final String str, final String str2, final IConfirmDeleteCallback iConfirmDeleteCallback, Activity activity) {
        if (canShowDialog(str2) == 1) {
            if (iConfirmDeleteCallback != null) {
                iConfirmDeleteCallback.onConfirmDeleteVideo();
                return;
            }
            return;
        }
        final Dialog dialog = new Dialog(activity, R.style.qZoneInputDialog);
        dialog.setContentView(R.layout.f167936ng);
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(R.id.dialogTitle)).setText("");
        TextView textView = (TextView) dialog.findViewById(R.id.dialogText);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText("\u89c6\u9891\u8fd8\u672a\u4fdd\u5b58\uff0c\u5173\u95ed\u540e\u89c6\u9891\u5c06\u5220\u9664\uff0c\u786e\u8ba4\u5173\u95ed\uff1f");
        }
        final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.checkBoxConfirm);
        checkBox.setText("\u4e0d\u518d\u63d0\u793a");
        checkBox.setChecked(false);
        if (checkBox.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) checkBox.getLayoutParams()).addRule(9);
        }
        TextView textView2 = (TextView) dialog.findViewById(R.id.dialogLeftBtn);
        if (textView2 != null) {
            textView2.setText(R.string.cancel);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.api.impl.MiniGameScreenRecordApiImpl.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (dialog.isShowing()) {
                        MiniGameScreenRecordApiImpl miniGameScreenRecordApiImpl = MiniGameScreenRecordApiImpl.this;
                        boolean isChecked = checkBox.isChecked();
                        miniGameScreenRecordApiImpl.updateCanShowDialog(isChecked ? 1 : 0, str2);
                        dialog.dismiss();
                        MiniGameScreenRecordApiImpl.this.confirmDialogReport(str, false, checkBox.isChecked());
                    }
                }
            });
        }
        TextView textView3 = (TextView) dialog.findViewById(R.id.dialogRightBtn);
        if (textView3 != null) {
            textView3.setText(R.string.f171151ok);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.api.impl.MiniGameScreenRecordApiImpl.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MiniGameScreenRecordApiImpl miniGameScreenRecordApiImpl = MiniGameScreenRecordApiImpl.this;
                    boolean isChecked = checkBox.isChecked();
                    miniGameScreenRecordApiImpl.updateCanShowDialog(isChecked ? 1 : 0, str2);
                    if (dialog.isShowing()) {
                        IConfirmDeleteCallback iConfirmDeleteCallback2 = iConfirmDeleteCallback;
                        if (iConfirmDeleteCallback2 != null) {
                            iConfirmDeleteCallback2.onConfirmDeleteVideo();
                        }
                        dialog.dismiss();
                        MiniGameScreenRecordApiImpl.this.confirmDialogReport(str, true, checkBox.isChecked());
                    }
                }
            });
        }
        try {
            dialog.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "showDeleteVideoConfirmDialog:", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniGameScreenRecordApi
    public void share2QZone(String str, boolean z16, final Activity activity, final String str2, final int i3) {
        if (z16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.MiniGameScreenRecordApiImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(PeakConstants.IS_VIDEO_SELECTED, true);
                    bundle.putInt(PeakConstants.VIDEO_TYPE, 1);
                    bundle.putString("file_send_path", str2);
                    bundle.putBoolean(PeakConstants.VIDEO_NEED_PROCESS, false);
                    bundle.putString(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "");
                    QZoneShareManager.publishToQzone((AppInterface) BaseApplicationImpl.getApplication().getRuntime(), activity, bundle, null, i3);
                }
            }, 32, null, true);
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportByQQ(str, "lp_result", "share", "share_Qzone", str, "", "", "");
        }
    }
}
