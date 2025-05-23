package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.w;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.TimeoutParam;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileManagerUtil extends QRouteApi {
    void addCloseButtonSessionId(long j3);

    int addExternalFileToFMRecv(String str);

    void addShortcut(BaseQQAppInterface baseQQAppInterface, Context context, String str, String str2, int i3);

    void addShortcut(BaseQQAppInterface baseQQAppInterface, Context context, String str, String str2, int i3, Bundle bundle);

    void associateLocalWithCloud(FileManagerEntity fileManagerEntity);

    boolean bShowFlowDlg(boolean z16, ArrayList<FileManagerEntity> arrayList);

    boolean bZip(int i3);

    String binToHEX(ByteStringMicro byteStringMicro);

    int binanrySearch(List<FileInfo> list, long j3);

    void calcFileDescription(TextView textView, FileManagerEntity fileManagerEntity);

    boolean canCreateThumb(FileManagerEntity fileManagerEntity);

    boolean canPreview(Context context, String str, long j3);

    int chechFileType(FileManagerEntity fileManagerEntity);

    int chechZipFileType(FileManagerEntity fileManagerEntity);

    void checkFileExisted(FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface, ah.a aVar);

    boolean checkMultiFileBubbleClickable(ChatMessage chatMessage, BaseQQAppInterface baseQQAppInterface, Context context);

    void clearAllRecentFileForTest();

    void clearRememberPicSelectForQlink(Context context);

    void correctFileInfo(FileManagerEntity fileManagerEntity);

    FileManagerEntity createFileRecordForMultiMsg(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage);

    void createMediThumbnail(FileManagerEntity fileManagerEntity);

    ah.e createMediaFileThumbSizeInfo(int i3, String str);

    String createMediaThumbnail(String str, int i3, int i16, ah.d dVar);

    String createVideoThumbPath(String str);

    String cutLongLongFileName(String str, int i3);

    String cutLongName(String str);

    void dealWithErrCode(String str);

    boolean dealWithErrCode(int i3, String str);

    void dealWithErrCodeById(int i3);

    void dealWithTransFileFaild(long j3, int i3, String str);

    void dealWithTransFileSuc(long j3);

    void delCloseButtonSessionId(long j3);

    int delExternalFileFromFMRecv(String str);

    void downloadUniformQQBrowser(Context context, String str, Bundle bundle);

    String enCodecString(String str);

    boolean fileExist(String str);

    boolean fileWhetherExpire(FileManagerEntity fileManagerEntity);

    String filesizeToString(long j3);

    void fillFileMessageRecord(ChatMessage chatMessage, MessageForFile messageForFile);

    boolean filterFiles(String str, String str2);

    void fixEntityThumbSize(FileManagerEntity fileManagerEntity);

    void forwardRencentFiles(List<FileManagerEntity> list, Activity activity);

    long genMsgSeq();

    long genMsgUid();

    Long genSessionId();

    byte[] get3SHA(String str);

    ArrayList<FileInfo> getAllFMRecvFiles(boolean z16, int i3);

    Map<String, File> getAllStorageLocations(Context context);

    BaseQQAppInterface getApp();

    Bitmap getCircleFaceBitmap(Context context, Bitmap bitmap, int i3);

    SpannableString getClickableTips(String str, String str2, ah.f fVar);

    w getDatalineProcessCallBack(BaseQQAppInterface baseQQAppInterface, int i3);

    HashMap<String, String> getDocsImportConfigGroupFromStr(String str);

    long getDocsImportFileMaxSize(String str);

    String getFMDownloadPath();

    int getFileIconResId(int i3);

    int getFileIconResId(int i3, int i16);

    int getFileIconResId(String str);

    FileManagerEntity getFileManagerEntityByMsgFile(BaseQQAppInterface baseQQAppInterface, MessageForFile messageForFile);

    String getFileName(String str);

    String getFileOperationTypeToPeer(FileManagerEntity fileManagerEntity);

    FileManagerEntity getFileRecordForMultiMsg(BaseQQAppInterface baseQQAppInterface, long j3, String str, int i3, ChatMessage chatMessage);

    String getFileSizeInvalidTime(FileManagerEntity fileManagerEntity);

    long getFileSizes(String str);

    int getFileSrcCloudType(FileManagerEntity fileManagerEntity);

    String getFileSuffix(String str);

    int getFileType(String str);

    String getFileType(int i3);

    int getFileTypeByExtension(String str);

    int getFileTypeFromMultiMsgRecord(ChatMessage chatMessage);

    byte[] getFullMd5(String str);

    String getHardCodeConfig(String str);

    String getImageUrl(FileManagerEntity fileManagerEntity);

    byte[] getMd5(String str);

    byte[] getMd5(String str, long j3);

    int[] getMediaFileWidthHeight(String str);

    String getMultiFileThumbPath(ChatMessage chatMessage);

    String getPeerNick(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3);

    String getQQStr(int i3);

    int getQlinkIntroShowTime(String str);

    String getReportFileTypeStr(int i3);

    AppRuntime getRuntime();

    byte[] getSHA(String str);

    FileManagerEntity getSelectedEntity();

    byte[] getSha3(String str);

    void getSortMap(TreeMap<Long, FileInfo> treeMap, int i3, LinkedHashMap<String, List<FileInfo>> linkedHashMap, LinkedHashMap<String, List<FileInfo>> linkedHashMap2, List<FileInfo> list);

    int getStatus(int i3);

    byte[] getTempSessionSig(BaseQQAppInterface baseQQAppInterface, String str, int i3);

    long getTempSessionType(int i3);

    TimeoutParam getTimeOutParamer();

    long getWeiyunZipTargetId(long j3);

    String getZipThumbSavePath(FileManagerEntity fileManagerEntity);

    String getZipThumbUrlWithFileUrl(String str);

    String handleLongFileName(String str, boolean z16, int i3, TextPaint textPaint, int i16);

    boolean hasNoThumb(FileManagerEntity fileManagerEntity);

    boolean hasShortCut(Context context, String str);

    boolean hasThumb(FileManagerEntity fileManagerEntity);

    String hexToString(byte[] bArr);

    boolean ifShowFileMask(Context context, FileManagerEntity fileManagerEntity);

    void initNoMedia();

    void initSaveToPc(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context);

    boolean initSaveToWeiYun(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context);

    boolean initSaveToWeiYun(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context, boolean z16);

    void installApkFile(Context context, String str);

    boolean is2GOr3G();

    boolean isBuddyIntroShow(String str, String str2);

    boolean isContainChinese(String str);

    boolean isDebugVersion();

    boolean isImportLocaFilesForH5(Context context);

    boolean isLocalFile(String str);

    boolean isMultiMessageSender(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage);

    boolean isPreDownloadThumb();

    boolean isSameDay(long j3, long j16, TimeZone timeZone);

    boolean isSelectedFavImageEntity();

    boolean isSupportFavorite(FileManagerEntity fileManagerEntity);

    boolean isTroopFile(FileManagerEntity fileManagerEntity);

    LinkedHashMap jsonToMap(String str);

    String mapToJson(Map map);

    String millsTimeToString(long j3, int i3);

    FileManagerEntity newEntityByFav(String str, String str2, String str3, String str4, long j3, String str5, String str6, int i3);

    FileManagerEntity newEntityByLocalFileInfo(FileInfo fileInfo);

    FileManagerEntity newEntityByOfflineFileInfo(OfflineFileInfo offlineFileInfo, int i3);

    FileManagerEntity newEntityByWeiYunFileInfo(WeiYunFileInfo weiYunFileInfo);

    FileManagerEntity newEntityByWeiYunMiniAppParams(Bundle bundle);

    void onDatalineForward(FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface, Activity activity, int i3);

    void onQlinkFileErrIconClicked(BaseQQAppInterface baseQQAppInterface, Context context, FileManagerEntity fileManagerEntity);

    void openFileWithOtherAppWithSystem(Context context, String str);

    void openWithOtherApp(Activity activity, String str);

    void preLoadThumb(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    String printFileManagerEntityInfo(FileManagerEntity fileManagerEntity);

    String printStack();

    void processAIOTimGraytips(BaseQQAppInterface baseQQAppInterface, long j3);

    String recreateFilePath(String str);

    boolean renameFile(VFSFile vFSFile, VFSFile vFSFile2);

    boolean renameFile(File file, File file2);

    void reportFileAssistans(BaseQQAppInterface baseQQAppInterface, Context context);

    void reportFilemanagerFaildInfo(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, String str6, long j18, long j19, long j26, String str7, String str8, int i3, String str9, String str10);

    void reportFilemanagerFaildInfoEx(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, String str6, long j18, long j19, long j26, String str7, String str8, int i3, String str9, String str10, Bundle bundle);

    void reportFilemanagerSuccessInfo(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, long j18, long j19, int i3, String str6);

    void reportFilemanagerSuccessInfoEx(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, long j18, long j19, int i3, String str6, Bundle bundle);

    String reportSrcType(int i3, int i16);

    void resume(Context context, FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface, boolean z16);

    void saveQlinkIntroShowTime(String str, int i3);

    void saveToAlbum(Context context, String str);

    void setBuddyIntroShow(String str, String str2, boolean z16);

    void setFileIcon(ImageView imageView, FileManagerEntity fileManagerEntity);

    void setFileIcon(ImageView imageView, String str);

    void setFileIcon(AsyncImageView asyncImageView, FileManagerEntity fileManagerEntity);

    void setFileIcon(AsyncImageView asyncImageView, String str);

    void setFileIcon(AsyncImageView asyncImageView, String str, int i3);

    void setFileIcon(AsyncImageView asyncImageView, String str, boolean z16);

    void setTempParam(BaseQQAppInterface baseQQAppInterface, String str, String str2, FileManagerEntity fileManagerEntity);

    void setZipImageFileIcon(AsyncImageView asyncImageView, FileManagerEntity fileManagerEntity);

    void showFlowDialog(boolean z16, Context context, FMDialogUtil.c cVar);

    void showFlowDialog(boolean z16, Context context, FMDialogUtil.c cVar, int i3);

    void startLoadingAnim(Activity activity, TextView textView);

    void stopLoadingAnim(TextView textView);

    ah.g syncCreateVideoThumb(String str);

    void updateBatProcessTips(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3);

    String updateRecentListTxt(BaseQQAppInterface baseQQAppInterface, Message message);

    String updateRecentListTxtByMessageRecord(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord);
}
