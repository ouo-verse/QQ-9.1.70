package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.t;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQFileSelectorImpl implements IQQFileSelector {
    private static final String TAG = "QQFileSelectorImpl";
    QfileFavFileRecordProvider mFavProvider = null;

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void enterCloudFileBrowser(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra("tab_tab_type", 3);
        intent.putExtra("from", "FileAssistant");
        activity.startActivityForResult(intent, 101);
        activity.overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void enterLocalFileBrowserByDevice(Activity activity, String str, int i3) {
        Intent intent = new Intent(activity, (Class<?>) FMLocalFileActivity.class);
        intent.putExtra("category", 15);
        intent.putExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 5);
        intent.putExtra("selectMode", true);
        intent.putExtra("peerType", i3);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str);
        intent.putExtra("STRING_Show_Music_Category", false);
        intent.putExtra("STRING_Show_Video_Category", false);
        intent.putExtra("STRING_Show_Apk_Category", false);
        intent.putExtra("STRING_Show_Pic_Category", false);
        intent.putExtra("STRING_SingleSelect", false);
        intent.putExtra(PictureConst.KEY_MAX_SELECT_COUNT, 5);
        intent.putExtra(com.tencent.mobileqq.utils.d.f307603i, 84);
        intent.putExtra("STRING_Show_Within_Suffixs", new String[]{FileReaderHelper.DOC_EXT, FileReaderHelper.DOCX_EXT, FileReaderHelper.TXT_EXT, FileReaderHelper.PDF_EXT, FileReaderHelper.PPT_EXT, FileReaderHelper.PPTX_EXT, FileReaderHelper.XLS_EXT, FileReaderHelper.XLSX_EXT, "bmp", "jpg", "gif", "png"});
        activity.startActivityForResult(intent, 84);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void enterQlinkFromQfav(Activity activity, String str, int i3, boolean z16, int i16) {
        Intent intent = new Intent(activity.getApplicationContext(), (Class<?>) FMActivity.class);
        intent.putExtra("selectMode", true);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str);
        intent.putExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 10);
        intent.putExtra("sendprepare", i3);
        intent.putExtra("enterfrom", i16);
        intent.putExtra("needRemember", true);
        intent.putExtra("qfile_entrance_type_key", 10);
        activity.startActivityForResult(intent, 110);
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void enterQlinkLocalFileBrowser(Activity activity, String str, int i3, boolean z16, int i16) {
        Intent intent = new Intent(activity.getApplicationContext(), (Class<?>) FMActivity.class);
        intent.putExtra("selectMode", true);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str);
        intent.putExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 1);
        intent.putExtra("sendprepare", i3);
        intent.putExtra("apautocreate", z16);
        intent.putExtra("enterfrom", i16);
        intent.putExtra("tab_tab_type", 5);
        intent.putExtra("qlinkselect", true);
        intent.putExtra("qfile_entrance_type_key", 20);
        activity.startActivityForResult(intent, 106);
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void enterQlinkRecentFileBrowser(Activity activity, boolean z16) {
        Intent intent = new Intent(activity.getApplicationContext(), (Class<?>) FMActivity.class);
        intent.putExtra("tab_tab_type", 6);
        intent.putExtra("from_qlink", z16);
        activity.startActivityForResult(intent, 108);
        activity.overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void fileChooseLaunchForResult(Activity activity, int i3, int i16, ArrayList<String> arrayList) {
        FMActivity.fileChooseLaunchForResult(activity, i3, i16, arrayList);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void free() {
        QfileFavFileRecordProvider qfileFavFileRecordProvider = this.mFavProvider;
        if (qfileFavFileRecordProvider != null) {
            qfileFavFileRecordProvider.A();
            this.mFavProvider = null;
        }
    }

    public QfileFavFileRecordProvider getQfileFavFileRecordProvider(AppRuntime appRuntime) {
        if (this.mFavProvider == null) {
            QfileFavFileRecordProvider qfileFavFileRecordProvider = new QfileFavFileRecordProvider(appRuntime);
            this.mFavProvider = qfileFavFileRecordProvider;
            qfileFavFileRecordProvider.w();
        }
        return this.mFavProvider;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void jumpToMyFile(Activity activity, long j3) {
        jumpToMyFile(activity, new long[]{j3});
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openExpiredFilePageBySchema(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) FileAssistantActivity.class);
        intent.putExtra("from", "FileAssistant");
        intent.putExtra("dst", "page_expired_file");
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileClear(Activity activity, int i3) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra("selectMode", true);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PC_UIN);
        intent.putExtra("tab_tab_type", 8);
        intent.putExtra("only_show_local_tab", true);
        intent.putExtra(PictureConst.KEY_MAX_SELECT_COUNT, BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD);
        intent.putExtra("message_clean_request_code", i3);
        ReportController.o(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 0, 0, "", "", "", "");
        activity.startActivityForResult(intent, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByAIO(Activity activity, int i3, String str, @Nullable String str2, String str3, int i16) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra("from_aio", true);
        intent.addFlags(536870912);
        intent.putExtra("selectMode", true);
        intent.putExtra("peerType", i3);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str);
        if (str2 != null) {
            intent.putExtra("targetPeerUid", str2);
        }
        intent.putExtra("srcDiscGroup", str3);
        intent.putExtra("qfile_entrance_type_key", i16);
        if (i3 == 0 || i3 == 3000 || i3 == 1) {
            intent.putExtra("select_file_support_send_docs_file", false);
        }
        activity.startActivityForResult(intent, 5);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByColorNoteHistory(Context context) {
        Intent intent = new Intent(context, (Class<?>) FileAssistantActivity.class);
        intent.putExtra("from", "FileAssistant");
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByDeviceMsg(Activity activity, int i3, String str, int i16, long j3) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra("category", 6);
        intent.putExtra("selectMode", true);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str);
        intent.putExtra("peerType", i3);
        intent.putExtra("tab_tab_type", 5);
        if (j3 > 0) {
            intent.putExtra("max_select_size", j3);
        }
        intent.putExtra("smart_device_support_flag", i16);
        activity.startActivityForResult(intent, 5);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByDocApiPlugin(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra(t.f292401f, true);
        intent.addFlags(536870912);
        intent.putExtra("selectMode", true);
        intent.putExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 9);
        intent.putExtra("peerType", 10006);
        intent.putExtra("tab_tab_type", 7);
        intent.putExtra("only_show_local_tab", true);
        intent.putExtra(t.f292402g, str);
        intent.putExtra("smart_device_support_flag", 8);
        activity.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByLiteActivity(Activity activity, int i3, String str) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra("selectMode", true);
        String str2 = AppConstants.DATALINE_PC_UIN;
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str2);
        if (!str2.equals(str)) {
            intent.putExtra("tab_tab_type", 5);
        }
        intent.putExtra(PictureConst.KEY_MAX_SELECT_COUNT, 50);
        intent.putExtra("qfile_entrance_type_key", 11);
        intent.putExtra("select_file_support_send_docs_file", false);
        activity.startActivityForResult(intent, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByLiteAdvance(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) LocalFileBrowserActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("category", 6);
        intent.putExtra("bundle", bundle);
        intent.putExtra("localSdCardfile", 0);
        intent.putExtra("open_with_qq_images", true);
        activity.startActivityForResult(intent, 103);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByMyComputer(Activity activity, int i3, String str, @Nullable String str2, String str3) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra("from_aio", true);
        intent.addFlags(536870912);
        intent.putExtra("selectMode", true);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str);
        if (!AppConstants.DATALINE_PC_UIN.equals(str)) {
            intent.putExtra("tab_tab_type", 5);
        }
        intent.putExtra(PictureConst.KEY_MAX_SELECT_COUNT, 50);
        intent.putExtra("qfile_entrance_type_key", 11);
        intent.putExtra("peerType", i3);
        if (str2 != null) {
            intent.putExtra("targetPeerUid", str2);
        }
        intent.putExtra("srcDiscGroup", str3);
        intent.putExtra("select_file_support_send_docs_file", false);
        activity.startActivityForResult(intent, 5);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByPrinter(Activity activity, String[] strArr, int i3) {
        Intent intent = new Intent(activity, (Class<?>) FMLocalFileActivity.class);
        intent.putExtra("category", 6);
        intent.putExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 5);
        intent.putExtra("selectMode", true);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PRINTER_UIN);
        intent.putExtra("peerType", 6001);
        intent.putExtra("STRING_Show_Music_Category", false);
        intent.putExtra("STRING_Show_Video_Category", false);
        intent.putExtra("STRING_Show_Apk_Category", false);
        intent.putExtra("STRING_Show_Pic_Category", false);
        intent.putExtra("STRING_SingleSelect", true);
        intent.putExtra("STRING_Show_Within_Suffixs", strArr);
        intent.putExtra(com.tencent.mobileqq.utils.d.f307603i, i3);
        activity.startActivityForResult(intent, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByPulsPanel(Activity activity, String str, int i3, int i16, int i17, long j3) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra("category", 6);
        intent.putExtra("selectMode", true);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str);
        intent.putExtra("peerType", i3);
        intent.putExtra("tab_tab_type", 5);
        intent.putExtra("smart_device_support_flag", i16);
        intent.putExtra("smart_device_switch_tab_flag", i17);
        if (j3 > 0) {
            intent.putExtra("max_select_size", j3);
        }
        activity.startActivityForResult(intent, 5);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByQRLogin(Activity activity, String str, long j3, int i3) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra("category", 6);
        intent.putExtra("selectMode", true);
        String str2 = AppConstants.DATALINE_PC_UIN;
        if (h.o()) {
            str2 = AppConstants.FILE_ASSISTANT_UIN;
        }
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str2);
        intent.putExtra("tab_tab_type", 5);
        intent.putExtra(PictureConst.KEY_MAX_SELECT_COUNT, 50);
        intent.putExtra(str, j3);
        activity.startActivityForResult(intent, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByQRLoginMyComputer(Activity activity, String str, long j3, int i3, int i16, String str2, String str3) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra("category", 6);
        intent.putExtra("selectMode", true);
        if (h.o()) {
            str2 = AppConstants.FILE_ASSISTANT_UIN;
        }
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str2);
        intent.putExtra("tab_tab_type", 5);
        intent.putExtra(PictureConst.KEY_MAX_SELECT_COUNT, 50);
        intent.putExtra("peerType", i16);
        if (str3 != null) {
            intent.putExtra("targetPeerUid", str3);
        }
        intent.putExtra("srcDiscGroup", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
        intent.putExtra(str, j3);
        activity.startActivityForResult(intent, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorByWeiyunBoroadcast(Context context, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) FMActivity.class);
        intent.putExtra("tab_tab_type", 7);
        intent.addFlags(268435456);
        new Bundle().putLong("category", 13L);
        intent.putExtra("bundle", bundle);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openFileSelectorForTroopFileBrowser(Activity activity, String str, boolean z16, boolean z17) {
        Intent intent = new Intent(activity, (Class<?>) FMActivity.class);
        intent.putExtra("key_check_troop_privilege", true);
        intent.putExtra("from_aio", true);
        intent.addFlags(536870912);
        intent.putExtra("selectMode", true);
        intent.putExtra("peerType", 1);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str);
        intent.putExtra("qfile_entrance_type_key", 4);
        intent.putExtra("srcDiscGroup", str);
        intent.putExtra("srcDiscGroup", str);
        intent.putExtra("isTroopFile", true);
        intent.putExtra("isOverSpace", z17);
        if (z16) {
            intent.putExtra("tab_tab_type", 1);
            intent.putExtra("is_from_file_folder", true);
        }
        activity.startActivityForResult(intent, 5);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openLocalFileBrowserActivity(Context context, String str) {
        try {
            if (new JSONObject(str).getInt("showlocalfile") == 1) {
                Intent intent = new Intent(context, (Class<?>) LocalFileBrowserActivity.class);
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("category", 23);
                    intent.putExtra("bundle", bundle);
                    intent.putExtra("localSdCardfile", 0);
                    context.startActivity(intent);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openMyFile(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) FileAssistantActivity.class);
        intent.putExtra("from", "FileAssistant");
        activity.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void openMyFileBySchema(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) FileAssistantActivity.class);
        if (TextUtils.isEmpty(str)) {
            str = "FileAssistant";
        }
        intent.putExtra("from", str);
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        activity.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void startFM(Context context) {
        Intent intent = new Intent(context, (Class<?>) FileAssistantActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("from", "FileAssistant");
        intent.putExtra("COMEFROMDESK", true);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelector
    public void jumpToMyFile(Activity activity, long[] jArr) {
        Intent intent = new Intent(activity, (Class<?>) FileAssistantActivity.class);
        intent.putExtra("from", QQPermissionConstants.Business.SCENE.TBS_TOOL);
        intent.putExtra("locate_session_id", jArr);
        activity.startActivity(intent);
    }
}
