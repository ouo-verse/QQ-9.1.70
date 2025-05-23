package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.BubblePopupWindow;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppActivity;
import qb1.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IQQFileTempUtils extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void a(Activity activity, int i3);
    }

    void addDatalineObserver();

    void addObserver(FMObserver fMObserver);

    boolean bShowFlowDialog(FileManagerEntity fileManagerEntity, boolean z16);

    void browseFlashTransferFile(BaseQQAppInterface baseQQAppInterface, Context context, List<FileManagerEntity> list, int i3, int i16, String str);

    void cancelDatalineFile(FileManagerEntity fileManagerEntity);

    void changeKingCardWording(QQCustomDialog qQCustomDialog, Context context, CharSequence charSequence);

    boolean checkEnds(String str, String[] strArr);

    boolean checkFileWithCUKingCardHelper(Activity activity, int i3, a aVar);

    boolean checkFileWithFreeWifiHelper(Activity activity, int i3, a aVar);

    boolean checkNotifyDeviceOnline(BaseQQAppInterface baseQQAppInterface);

    @Deprecated
    void checkPermission(AppActivity appActivity, View.OnClickListener onClickListener);

    boolean checkStatusToResume(Activity activity, BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    boolean checkWifiWithCUKingCardHelper(boolean z16, Activity activity, FMDialogUtil.c cVar);

    boolean checkWifiWithFreeWifiHelper(boolean z16, Activity activity, FMDialogUtil.c cVar);

    void clearAllData(BaseQQAppInterface baseQQAppInterface);

    b createFileAssistantExt();

    URL createFilePicDrawlableURLWithSend(FileManagerEntity fileManagerEntity);

    ForwardFileInfo createForwardFileInfo(FileManagerEntity fileManagerEntity);

    void createShortcut(BaseQQAppInterface baseQQAppInterface, Intent intent, String str, Bitmap bitmap);

    void createThumbWithOrig(FileManagerEntity fileManagerEntity);

    Bitmap decodeFileWithBufferedStream(String str, BitmapFactory.Options options);

    boolean deleteFile(String str);

    void deleteObserver(FMObserver fMObserver);

    void deleteOfflineFile(BaseQQAppInterface baseQQAppInterface, String str, String str2, String str3, String str4, boolean z16);

    void doJumpAction(Context context, String str);

    void doWithWifiChecked(FileManagerEntity fileManagerEntity, boolean z16, Context context, FMDialogUtil.c cVar);

    String downLoadDiscThumb(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity, int i3);

    void downloadDatalineFile(FileManagerEntity fileManagerEntity);

    String downloadDiscVideoThumb(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    String downloadOfflineVideoThumb(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    int dp2px(float f16, Resources resources);

    int dp2px(int i3, Resources resources);

    boolean favBuilderNewFile(Activity activity, FileManagerEntity fileManagerEntity);

    boolean favBuilderNewFile(Activity activity, String str);

    boolean favBuilderNewLink(Activity activity, String str);

    ContentValues favUtilhandleFileEntry(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity, String str, boolean z16);

    ContentValues favUtilhandleWeiyunFile(WeiYunFileInfo weiYunFileInfo);

    String formatNewRefreshTime(long j3);

    void forwardFile(Activity activity, FileManagerEntity fileManagerEntity);

    void forwardFileDirect(Activity activity, FileManagerEntity fileManagerEntity, String str, int i3);

    boolean forwardFileManagerEntity(FileManagerEntity fileManagerEntity);

    Intent getChatActivityIntent(Context context);

    int getDefaultTarget(BaseQQAppInterface baseQQAppInterface);

    URLDrawable getDrawable(URL url);

    long getDuration(String str);

    int getExifRotation(String str);

    String getExtension(String str);

    ArrayList<FavFileInfo> getFavFiles();

    String getFileDirectoryOf(String str);

    FileManagerEntity getFileEntityByUniseq(BaseQQAppInterface baseQQAppInterface, long j3, String str, int i3);

    int[] getFileMediaInfo(String str);

    long getFileSize(String str);

    ArrayList<FileInfo> getFiles(String str, boolean z16, int i3);

    int getForwardId();

    int getForwardUtilsForwardTypeFILE();

    int getFromStatisticAssist(Context context, String str, String str2);

    String getHistoryGroupByTime(long j3);

    int getImageDegree(String str);

    Bitmap getImageThumbnail(String str, int i3, int i16);

    Intent getIntentForFileBrowserActivity(Activity activity);

    boolean getIsOnline(BaseQQAppInterface baseQQAppInterface);

    boolean getIsQRing();

    String getJumpActivityName();

    int getMsfConnectedNetType();

    e getMsgCache(BaseQQAppInterface baseQQAppInterface);

    List<MessageRecord> getMsgList(BaseQQAppInterface baseQQAppInterface, String str, int i3);

    String getMultiMsgConstantEXTRAKEYOUTESTUIN();

    String getMultiMsgConstantEXTRAKEYOUTESTUINTYPE();

    String getMultiMsgConstantEXTRAKEYOUTESTUNISEQ();

    int getNetWorkType(Context context);

    String getNickByDiscussionManager(BaseQQAppInterface baseQQAppInterface, String str);

    String getNickName(BaseQQAppInterface baseQQAppInterface, String str, int i3);

    MessageRecord getPrimaryStructMsg(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord);

    long getProgress(BaseQQAppInterface baseQQAppInterface, String str, long j3, long j16, int i3);

    Pair<StringBuilder, StringBuilder> getQRCodeResult(Context context, File file);

    String getSUNIFORMABSDKDOWNLOADCANCEL();

    String getSUNIFORMABSDKDOWNLOADENTER();

    String getSUNIFORMABSDKDOWNLOADFAILD();

    String getSUNIFORMABSDKDOWNLOADPAUSE();

    String getSUNIFORMABSDKDOWNLOADRUN();

    String getSUNIFORMABSDKDOWNLOADSUCC();

    String getSUNIFORMGENDOWNLOADCANCEL();

    String getSUNIFORMGENDOWNLOADENTER();

    String getSUNIFORMGENDOWNLOADFAILD();

    String getSUNIFORMGENDOWNLOADPAUSE();

    String getSUNIFORMGENDOWNLOADRUN();

    String getSUNIFORMGENDOWNLOADSUCC();

    SpannableString getSpannableString(String str, ah.f fVar, ColorStateList colorStateList, int i3, int i16);

    Intent getSplashActivityIntent(Context context, String str);

    void getTDDocFileThumbUrl(String str, String str2, qb1.e eVar);

    TroopInfo getTroopInfo(BaseQQAppInterface baseQQAppInterface, long j3);

    String getVipType();

    void gotoTIMTeamworkFileUrl(Activity activity, boolean z16);

    boolean handleVipForTroopFile(Context context, boolean z16, boolean z17, View.OnClickListener onClickListener);

    boolean hasShortCut(Activity activity, String[] strArr);

    long insertAIOGrayTips(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3, int i16, String str3);

    long insertAIOGrayTips(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3, int i16, Map<String, String> map, String str3, long j3, long j16, long j17);

    void insertToFMList(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    void insertToMemMap(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    void insertToMemMapByFileManagerProxy(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    boolean isContainChinese(String str);

    boolean isFileExists(String str);

    boolean isKingCard();

    boolean isNeedCompressCut(FileManagerEntity fileManagerEntity);

    boolean isRunIWeiyunSaveTipsHelper(BaseQQAppInterface baseQQAppInterface);

    boolean isShowByCUKingCardHelper(Context context, boolean z16, FMDialogUtil.c cVar);

    boolean isShowByFreeWifiHelper(Context context, boolean z16, FMDialogUtil.c cVar);

    boolean isUndownloadDatalineEntity(FileManagerEntity fileManagerEntity);

    void notifyFlashTransferDownloadProgress(long j3, int i3, long j16);

    void notifyFlashTransferDownloadResult(long j3, boolean z16, String str);

    void notifyItemStatus(long j3, long j16, String str, int i3, int i16, Object obj, int i17, String str2);

    void notifyItemStatus(BaseQQAppInterface baseQQAppInterface, long j3, long j16, String str, int i3, int i16, Object obj, int i17, String str2);

    void notifyUpdateRecentFileAssistant(BaseQQAppInterface baseQQAppInterface);

    void onResultByDataLineHandler(boolean z16, long j3, int i3, String str, BaseQQAppInterface baseQQAppInterface, int i16);

    void openAIO(Context context, Intent intent);

    void openFavorite(Activity activity, String str, long j3);

    void openFileBrowserByFileInfo(Context context, FileInfo fileInfo, int i3, String str, View view);

    void openLocalFileViewBrowser(Activity activity, LinkedHashMap<String, List<FileInfo>> linkedHashMap, FileInfo fileInfo, View view, FileManagerEntity fileManagerEntity);

    void openQQBrowserWithoutAD(Context context, String str);

    void openRencentFileBrowser(Activity activity, ForwardFileInfo forwardFileInfo);

    void openRencentFileBrowserOnItemClick(BaseQQAppInterface baseQQAppInterface, Context context, FileManagerEntity fileManagerEntity, boolean z16, String str, View view, boolean z17, boolean z18, int i3);

    void openTroopFilerDetailBrowse(Activity activity, ForwardFileInfo forwardFileInfo);

    void openWeiYunFileBrowser(Context context, ArrayList<WeiYunFileInfo> arrayList, WeiYunFileInfo weiYunFileInfo);

    long prepareForwardByDataLineMsgRecord(String str, int i3, String str2, int i16, String str3, String str4, String str5, long j3, int i17, BaseQQAppInterface baseQQAppInterface, int i18);

    void previewFavImageFile(Activity activity);

    void previewImage(Activity activity, FileManagerEntity fileManagerEntity, boolean z16);

    FileManagerEntity queryFileEntityBySessionId(BaseQQAppInterface baseQQAppInterface, long j3);

    FileManagerEntity queryFileEntityByUniseq(BaseQQAppInterface baseQQAppInterface, long j3, String str, int i3);

    List<FileManagerEntity> queryFileManagerEntityByNameAndSize(BaseQQAppInterface baseQQAppInterface, String str, long j3);

    FileManagerEntity queryFileManagerEntityBySessionId(BaseQQAppInterface baseQQAppInterface, long j3);

    FileManagerEntity queryFileManagerEntityByWeiYunFileIdForMemory(BaseQQAppInterface baseQQAppInterface, String str);

    List<FileManagerEntity> queryMaxRecentReocrds(BaseQQAppInterface baseQQAppInterface);

    void removeDatalineObserver();

    void reportAppStoreDownloadSuc();

    ArrayList<String> reqDnsForIpList(String str, boolean z16, int i3);

    void resetFileAssistantOnlineMark(BaseQQAppInterface baseQQAppInterface);

    void resumeByFileManagerEngine(BaseQQAppInterface baseQQAppInterface, long j3);

    FileManagerEntity saveOfflineFile2WeiYun(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity, String str);

    void sendFavFiles(ArrayList<FavFileInfo> arrayList, String str, int i3, Bundle bundle);

    void sendFileToDataline(BaseQQAppInterface baseQQAppInterface, Context context, FileManagerEntity fileManagerEntity);

    void sendFiles(ArrayList<FileInfo> arrayList);

    void sendFilesWithService(ArrayList<FileInfo> arrayList, String str, byte[] bArr, long j3);

    FileManagerEntity sendLocalFile(BaseQQAppInterface baseQQAppInterface, String str, String str2, String str3, int i3, boolean z16);

    void sendLocalFileToGuild(BaseQQAppInterface baseQQAppInterface, String str, String str2, Set<FileInfo> set);

    void sendQlinkFiles(Activity activity, String str, ArrayList<String> arrayList, int i3);

    long sendTencentDocEntity(FileManagerEntity fileManagerEntity);

    void sendWeiYunFile(FileManagerEntity fileManagerEntity);

    void sendWeiYunFile(WeiYunFileInfo weiYunFileInfo);

    void setDefaultTarget(BaseQQAppInterface baseQQAppInterface, int i3);

    String setEntityUuidByEntityManager(BaseQQAppInterface baseQQAppInterface, MessageForFile messageForFile);

    void setFileAssistantOnlineMark(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16);

    void setForwardBundle(Intent intent, Bundle bundle);

    void setImageDegree(String str, int i3);

    void setStorageRptNeedScan(boolean z16);

    BubblePopupWindow showAsDropDown(View view, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener, BubblePopupWindow.OnDismissListener onDismissListener);

    void showDeviceChoose(Context context, String str, List<FileManagerEntity> list, Set<FileInfo> set, View.OnClickListener onClickListener);

    void speak(String str);

    void startActivityByLinkByWeiyunFragment(Context context, FileManagerEntity fileManagerEntity, String str, boolean z16);

    void startAppStoreByTmast(String str, int i3);

    void startChatAndSendMsg(Activity activity, Bundle bundle);

    void startForwardActivityForResult(Activity activity, Intent intent, int i3);

    void startForwardByOriginFile(Activity activity, Intent intent, boolean z16);

    void startSeach(Activity activity);

    void startSeach(Activity activity, int i3, Bundle bundle);

    void updateFileEntity(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    boolean uploadToWyForFreeWifi(Activity activity, View.OnClickListener onClickListener);
}
