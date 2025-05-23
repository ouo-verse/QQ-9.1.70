package com.tencent.mobileqq.filemanager.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.filebrowser.richmedia.FilePreviewLayerFragment;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.TimeoutParam;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileManagerUtil {
    private static final char[] ELLIPSIS_NORMAL;
    private static final String ELLIPSIS_STRING;
    public static final String EXTERNALFILE_OF_FM_INFO = "ExternalFileOfFM";
    public static final String EXTERNAL_SD_CARD = "externalSdCard";
    public static final int FILETYPE_7Z = 15;
    public static final int FILETYPE_RAR = 14;
    public static final int FILE_TYPE_ZIP = 13;
    private static final int MAX_KEEP_TILL_LENGTH = 15;
    private static final int MAX_KEEP_TILL_SHORT_LENGTH = 6;
    private static final int MAX_LEN = 16;
    public static final String SD_CARD = "sdCard";
    private static final String TAG = "FileManagerUtil<FileAssistant>";

    static {
        char[] cArr = {Typography.ellipsis};
        ELLIPSIS_NORMAL = cArr;
        ELLIPSIS_STRING = new String(cArr);
    }

    public static synchronized void addCloseButtonSessionId(long j3) {
        synchronized (FileManagerUtil.class) {
            ah.a(j3);
        }
    }

    @TargetApi(9)
    public static int addExternalFileToFMRecv(String str) {
        return ah.b(str);
    }

    public static void addShortcut(@NonNull QQAppInterface qQAppInterface, Context context, String str, String str2, int i3) {
        ah.c(qQAppInterface, context, str, str2, i3);
    }

    public static void associateLocalWithCloud(FileManagerEntity fileManagerEntity) {
        ah.e(fileManagerEntity);
    }

    public static boolean bShowFlowDlg(boolean z16, ArrayList<FileManagerEntity> arrayList) {
        return ah.f(z16, arrayList);
    }

    public static boolean bZip(int i3) {
        return ah.g(i3);
    }

    public static String binToHEX(ByteStringMicro byteStringMicro) {
        return ah.h(byteStringMicro);
    }

    public static int binanrySearch(List<FileInfo> list, long j3) {
        return ah.i(list, j3);
    }

    public static void calcFileDescription(TextView textView, FileManagerEntity fileManagerEntity) {
        ah.j(textView, fileManagerEntity);
    }

    public static boolean canCreateThumb(FileManagerEntity fileManagerEntity) {
        return ah.k(fileManagerEntity);
    }

    public static boolean canPreview(Context context, String str, long j3) {
        return ah.l(context, str, j3);
    }

    public static boolean canPreviewZip(QQAppInterface qQAppInterface, com.tencent.mobileqq.filemanager.fileviewer.j jVar, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        FileManagerEntity entity = jVar.getEntity();
        if (entity == null) {
            return false;
        }
        if (isZipFile(qQAppInterface, jVar, z16) && !entity.isZipInnerFile) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (jVar.b() != 6000 && jVar.v() != 7) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (jVar.v() == 3 && entity.strTroopFilePath == null && entity.Uuid == null && entity.WeiYunFileId == null && (entity.nOpType != 58 || jVar.v() != 3)) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (jVar.v() != 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (jVar.v() != 5) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "canPreviewZip entity.isZipInnerFile: " + entity.isZipInnerFile + ", con1: " + z17 + ", adapter.getPeerType(): " + jVar.b() + ", adapter.getCloudType(): " + jVar.v() + ", entity.strTroopFilePath: " + entity.strTroopFilePath + ", entity.Uuid: " + entity.Uuid + ", entity.WeiYunFileId: " + entity.WeiYunFileId);
        }
        if (!z17 || !z18 || !z19 || !z26 || !z27) {
            return false;
        }
        return true;
    }

    public static List<MessageRecord> changeFileMessageRecordList(List<MessageRecord> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (MessageRecord messageRecord : list) {
                if (isMessageRecordOfFile(messageRecord)) {
                    arrayList.add(changeRealChatMessage((ChatMessage) messageRecord));
                } else {
                    arrayList.add(messageRecord);
                }
            }
            return arrayList;
        }
        return list;
    }

    public static ChatMessage changeRealChatMessage(ChatMessage chatMessage) {
        int i3;
        ChatMessage chatMessage2;
        String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
        QQAppInterface qQAppInterface = getQQAppInterface();
        if (isCheckComplexMessage(chatMessage) && !TextUtils.isEmpty(extInfoFromExtStr)) {
            int parseInt = Integer.parseInt(extInfoFromExtStr);
            if (parseInt == 3) {
                chatMessage2 = (ChatMessage) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_TROOP_OBJ_MSG);
                chatMessage2.isMultiMsg = chatMessage.isMultiMsg;
                chatMessage2.isReplySource = chatMessage.isReplySource;
                chatMessage2.selfuin = chatMessage.selfuin;
                chatMessage2.shmsgseq = chatMessage.shmsgseq;
                chatMessage2.frienduin = chatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
                chatMessage2.senderuin = chatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
                MessageForTroopFile messageForTroopFile = (MessageForTroopFile) chatMessage2;
                fillTroopFileMessageRecord(chatMessage, messageForTroopFile);
                messageForTroopFile.istroop = 1;
            } else if (parseInt != 1 && parseInt != 2) {
                chatMessage2 = chatMessage;
            } else {
                if (parseInt == 1) {
                    i3 = -2005;
                } else {
                    i3 = MessageRecord.MSG_TYPE_GROUPDISC_FILE;
                }
                ChatMessage chatMessage3 = (ChatMessage) com.tencent.mobileqq.service.message.q.d(i3);
                chatMessage3.isMultiMsg = chatMessage.isMultiMsg;
                chatMessage3.isReplySource = chatMessage.isReplySource;
                chatMessage3.selfuin = chatMessage.selfuin;
                chatMessage3.shmsgseq = chatMessage.shmsgseq;
                chatMessage3.frienduin = chatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
                chatMessage3.senderuin = chatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
                fillFileMessageRecord(chatMessage, (MessageForFile) chatMessage3);
                if (qQAppInterface != null) {
                    correctMessageInfoByQFileUtils(qQAppInterface, chatMessage3, chatMessage);
                } else if (parseInt == 1) {
                    chatMessage3.istroop = 0;
                    chatMessage3.frienduin = chatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
                } else if (parseInt == 2) {
                    chatMessage3.istroop = 3000;
                }
                chatMessage2 = chatMessage3;
            }
            String extInfoFromExtStr2 = chatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
            if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                chatMessage2.saveExtInfoToExtStr("_m_ForwardFileStatus", extInfoFromExtStr2);
            }
            return chatMessage2;
        }
        return chatMessage;
    }

    public static int chechFileType(FileManagerEntity fileManagerEntity) {
        return ah.m(fileManagerEntity);
    }

    public static int chechZipFileType(FileManagerEntity fileManagerEntity) {
        return ah.n(fileManagerEntity);
    }

    public static String checkAndGetUid(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (str3 == null) {
            str3 = "checkAndGetUid";
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
        if (TextUtils.isEmpty(uidFromUin)) {
            QLog.e(TAG, 1, "[" + str3 + "] can not find uid for uin:" + str2 + " may happen err");
        }
        return uidFromUin;
    }

    public static void checkFileExisted(FileManagerEntity fileManagerEntity, QQAppInterface qQAppInterface, ah.a aVar) {
        ah.o(fileManagerEntity, qQAppInterface, aVar);
    }

    public static boolean checkMultiFileBubbleClickable(ChatMessage chatMessage, QQAppInterface qQAppInterface, Context context) {
        return ah.p(chatMessage, qQAppInterface, context);
    }

    public static void clearAllRecentFileForTest() {
        ah.q();
    }

    public static void clearRememberPicSelectForQlink(Context context) {
        ah.r(context);
    }

    public static void clearTempMultiFileMsgRecord(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return;
        }
        if (chatMessage instanceof MessageForFile) {
            MessageForFile messageForFile = (MessageForFile) chatMessage;
            messageForFile.uniseq = 0L;
            messageForFile.msgseq = 0L;
            messageForFile.fileName = "";
            messageForFile.fileSize = 0L;
        } else if (chatMessage instanceof MessageForTroopFile) {
            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) chatMessage;
            messageForTroopFile.uniseq = 0L;
            messageForTroopFile.msgseq = 0L;
            messageForTroopFile.url = "";
            messageForTroopFile.uuid = "";
            messageForTroopFile.bisID = 0;
            messageForTroopFile.fileName = "";
            messageForTroopFile.fileSize = 0L;
            messageForTroopFile.width = 0;
            messageForTroopFile.height = 0;
            messageForTroopFile.duration = 0;
        }
        chatMessage.extStr = null;
    }

    public static void correctFileInfo(FileManagerEntity fileManagerEntity) {
        ah.s(fileManagerEntity);
    }

    public static void correctMessageInfoByQFileUtils(QQAppInterface qQAppInterface, ChatMessage chatMessage, ChatMessage chatMessage2) {
        QFileUtils.k(qQAppInterface, chatMessage, chatMessage2);
    }

    private static void correctProgressForDatalineEntity(DataLineMsgRecord dataLineMsgRecord, FileManagerEntity fileManagerEntity) {
        int i3;
        float f16 = dataLineMsgRecord.progress;
        fileManagerEntity.fProgress = f16;
        if (f16 == 1.0d && ((i3 = fileManagerEntity.status) == 3 || i3 == -1)) {
            fileManagerEntity.fProgress = 0.0f;
        }
        if (dataLineMsgRecord.nOpType == 1 && Float.compare(f16, 1.0f) == 0 && !l.b(dataLineMsgRecord.path)) {
            fileManagerEntity.fProgress = 0.0f;
        }
    }

    public static FileManagerEntity createFileRecordForMultiMsg(QQAppInterface qQAppInterface, ChatMessage chatMessage) {
        return ah.t(qQAppInterface, chatMessage);
    }

    public static void createMediThumbnail(FileManagerEntity fileManagerEntity) {
        ah.u(fileManagerEntity);
    }

    public static String createMediaThumbnail(String str, int i3, int i16, ah.d dVar) {
        return ah.v(str, i3, i16, dVar);
    }

    public static String createVideoThumbPath(String str) {
        return ah.w(str);
    }

    public static String cutLongLongFileName(String str, int i3) {
        return ah.x(str, i3);
    }

    public static String cutLongName(String str) {
        return ah.y(str);
    }

    public static boolean dealWithErrCode(int i3, String str) {
        return ah.A(i3, str);
    }

    public static void dealWithErrCodeById(int i3) {
        ah.B(i3);
    }

    public static void dealWithTransFileFaild(long j3, int i3, String str) {
        ah.C(j3, i3, str);
    }

    public static void dealWithTransFileSuc(long j3) {
        ah.D(j3);
    }

    public static synchronized void delCloseButtonSessionId(long j3) {
        synchronized (FileManagerUtil.class) {
            ah.E(j3);
        }
    }

    public static int delExternalFileFromFMRecv(String str) {
        return ah.F(str);
    }

    public static void downloadUniformQQBrowser(Context context, String str, Bundle bundle) {
        ah.G(context, str, bundle);
    }

    public static synchronized String enCodecString(String str) {
        String H;
        synchronized (FileManagerUtil.class) {
            H = ah.H(str);
        }
        return H;
    }

    public static void enterQlinkFromAio(Activity activity, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("string_uin", str2);
        bundle.putString("string_nick", str3);
        QQProxyForQlink.P(activity, 1, bundle);
    }

    public static void enterQlinkFromQfav(Activity activity, String str, int i3, boolean z16, int i16) {
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).enterQlinkFromQfav(activity, str, i3, z16, i16);
    }

    public static void enterQlinkFromStrangerGrayTips(Activity activity, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("string_uin", str2);
        bundle.putString("string_nick", str3);
        QQProxyForQlink.P(activity, 3, bundle);
    }

    public static void enterQlinkLocalFileBrowser(Activity activity, String str, int i3, boolean z16, int i16) {
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).enterQlinkLocalFileBrowser(activity, str, i3, z16, i16);
    }

    public static void enterQlinkRecentFileBrowser(Activity activity, boolean z16) {
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).enterQlinkRecentFileBrowser(activity, z16);
    }

    public static boolean fileExist(String str) {
        return ah.I(str);
    }

    public static boolean fileWhetherExpire(FileManagerEntity fileManagerEntity) {
        return ah.J(fileManagerEntity);
    }

    public static String filesizeToString(long j3) {
        return ah.K(j3);
    }

    public static void fillFileMessageRecord(ChatMessage chatMessage, MessageForFile messageForFile) {
        ah.L(chatMessage, messageForFile);
    }

    public static void fillTroopFileMessageRecord(ChatMessage chatMessage, MessageForTroopFile messageForTroopFile) {
        messageForTroopFile.uniseq = chatMessage.uniseq;
        messageForTroopFile.msgseq = chatMessage.msgseq;
        String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
        messageForTroopFile.url = extInfoFromExtStr;
        messageForTroopFile.uuid = UUID.nameUUIDFromBytes(extInfoFromExtStr.getBytes()).toString();
        String extInfoFromExtStr2 = chatMessage.getExtInfoFromExtStr("_m_ForwardBusType");
        if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
            messageForTroopFile.bisID = Integer.parseInt(extInfoFromExtStr2);
        }
        messageForTroopFile.fileName = chatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
        String extInfoFromExtStr3 = chatMessage.getExtInfoFromExtStr("_m_ForwardSize");
        if (!TextUtils.isEmpty(extInfoFromExtStr3)) {
            messageForTroopFile.fileSize = Long.parseLong(extInfoFromExtStr3);
        }
        String extInfoFromExtStr4 = chatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
        String extInfoFromExtStr5 = chatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
        if (!TextUtils.isEmpty(extInfoFromExtStr4) && !TextUtils.isEmpty(extInfoFromExtStr5)) {
            messageForTroopFile.width = Integer.parseInt(extInfoFromExtStr4);
            messageForTroopFile.height = Integer.parseInt(extInfoFromExtStr5);
        }
        String extInfoFromExtStr6 = chatMessage.getExtInfoFromExtStr("_m_ForwardDuration");
        if (!TextUtils.isEmpty(extInfoFromExtStr6)) {
            messageForTroopFile.duration = Integer.parseInt(extInfoFromExtStr6);
        }
        String extInfoFromExtStr7 = chatMessage.getExtInfoFromExtStr("outest_uin");
        String extInfoFromExtStr8 = chatMessage.getExtInfoFromExtStr("outest_uintype");
        String extInfoFromExtStr9 = chatMessage.getExtInfoFromExtStr("outest_uniseq");
        if (!TextUtils.isEmpty(extInfoFromExtStr7)) {
            messageForTroopFile.saveExtInfoToExtStr("outest_uin", extInfoFromExtStr7);
        }
        if (!TextUtils.isEmpty(extInfoFromExtStr8)) {
            messageForTroopFile.saveExtInfoToExtStr("outest_uintype", extInfoFromExtStr8);
        }
        if (!TextUtils.isEmpty(extInfoFromExtStr9)) {
            messageForTroopFile.saveExtInfoToExtStr("outest_uniseq", extInfoFromExtStr9);
        }
    }

    public static boolean filterFiles(String str, String str2) {
        return ah.M(str, str2);
    }

    public static synchronized void fixEntityThumbSize(FileManagerEntity fileManagerEntity) {
        synchronized (FileManagerUtil.class) {
            ah.N(fileManagerEntity);
        }
    }

    public static void forwardRencentFiles(List<FileManagerEntity> list, Activity activity) {
        ah.O(list, activity);
    }

    public static long genMsgSeq() {
        return ah.P();
    }

    public static long genMsgUid() {
        return ah.Q();
    }

    public static Long genSessionId() {
        return ah.R();
    }

    public static byte[] get3SHA(String str) {
        return ah.S(str);
    }

    public static ArrayList<FileInfo> getAllFMRecvFiles(boolean z16, int i3) {
        return ah.T(z16, i3);
    }

    @TargetApi(9)
    public static Map<String, File> getAllStorageLocations(Context context) {
        return ah.U(context);
    }

    public static w getC2CProcessCallBack(QQAppInterface qQAppInterface) {
        return new b(qQAppInterface);
    }

    public static Bitmap getCircleFaceBitmap(Context context, Bitmap bitmap, int i3) {
        return ah.X(context, bitmap, i3);
    }

    public static SpannableString getClickableTips(String str, String str2, ah.f fVar) {
        return ah.Y(str, str2, fVar);
    }

    private static Context getContextByApp(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApplication().getBaseContext();
    }

    public static w getDatalineProcessCallBack(QQAppInterface qQAppInterface, int i3) {
        return ah.Z(qQAppInterface, i3);
    }

    public static HashMap<String, String> getDocsImportConfigGroupFromStr(String str) {
        return ah.a0(str);
    }

    public static long getDocsImportFileMaxSize(String str) {
        return ah.b0(str);
    }

    public static String getFMDownloadPath() {
        return ah.c0();
    }

    public static Intent getFileForwardIntent(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        if (messageRecord == null) {
            return null;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 0);
        bundle.putBoolean("not_forward", true);
        if (messageRecord instanceof MessageForFile) {
            MessageForFile messageForFile = (MessageForFile) messageRecord;
            bundle.putParcelable("fileinfo", getForwardFileInfoWithMessage(getFileManagerEntityByMsgFile(qQAppInterface, messageForFile), messageForFile));
            intent.putExtras(bundle);
        } else if (messageRecord instanceof MessageForTroopFile) {
            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) messageRecord;
            com.tencent.mobileqq.troop.data.t m3 = TroopFileUtils.m(qQAppInterface, messageForTroopFile);
            FileManagerEntity newEntityByTroopFileInfo = newEntityByTroopFileInfo(m3);
            newEntityByTroopFileInfo.status = 2;
            newEntityByTroopFileInfo.nOpType = 24;
            ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
            forwardFileInfo.E(newEntityByTroopFileInfo.nSessionId);
            forwardFileInfo.N(10006);
            if (!TextUtils.isEmpty(newEntityByTroopFileInfo.getFilePath())) {
                forwardFileInfo.C(m3.f294978l);
            }
            forwardFileInfo.y(m3.f294987u);
            forwardFileInfo.z(m3.f294976j);
            forwardFileInfo.B(Long.parseLong(messageForTroopFile.frienduin));
            UUID uuid = m3.f294967a;
            if (uuid != null) {
                forwardFileInfo.M(uuid.toString());
            }
            forwardFileInfo.w(1);
            forwardFileInfo.A(1);
            bundle.putParcelable("fileinfo", forwardFileInfo);
            intent.putExtras(bundle);
            intent.putExtra(AppConstants.Key.FORWARD_FROM_TROOP_FILE, true);
        } else if (messageRecord instanceof MessageForDLFile) {
            MessageForDLFile messageForDLFile = (MessageForDLFile) messageRecord;
            int i3 = messageForDLFile.deviceType;
            DataLineMsgRecord d16 = qQAppInterface.getMessageFacade().t1(i3).d(messageForDLFile.associatedId);
            if (d16 != null && FileUtils.fileExistsAndNotEmpty(d16.path)) {
                try {
                    FileManagerEntity newEntityByLocalFileInfo = newEntityByLocalFileInfo(new FileInfo(d16.path));
                    newEntityByLocalFileInfo.uniseq = messageForDLFile.uniseq;
                    String str = d16.thumbPath;
                    newEntityByLocalFileInfo.strMiddleThumPath = str;
                    newEntityByLocalFileInfo.strLargeThumPath = str;
                    ForwardFileInfo forwardFileInfo2 = new ForwardFileInfo();
                    forwardFileInfo2.N(10000);
                    forwardFileInfo2.w(newEntityByLocalFileInfo.getCloudType());
                    forwardFileInfo2.E(newEntityByLocalFileInfo.nSessionId);
                    forwardFileInfo2.y(newEntityByLocalFileInfo.fileName);
                    forwardFileInfo2.V(newEntityByLocalFileInfo.uniseq);
                    forwardFileInfo2.z(newEntityByLocalFileInfo.fileSize);
                    forwardFileInfo2.C(newEntityByLocalFileInfo.getFilePath());
                    forwardFileInfo2.G(newEntityByLocalFileInfo.strLargeThumPath);
                    bundle.putParcelable("fileinfo", forwardFileInfo2);
                    intent.putExtras(bundle);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        return intent;
    }

    public static int getFileIconResId(String str) {
        return ah.f0(str);
    }

    public static FileManagerEntity getFileManagerEntityByMsgFile(BaseQQAppInterface baseQQAppInterface, MessageForFile messageForFile) {
        return ah.g0(baseQQAppInterface, messageForFile);
    }

    public static String getFileName(String str) {
        return ah.h0(str);
    }

    public static String getFileOperationTypeToPeer(FileManagerEntity fileManagerEntity) {
        return ah.i0(fileManagerEntity);
    }

    public static FileManagerEntity getFileRecordForMultiMsg(QQAppInterface qQAppInterface, long j3, String str, int i3, ChatMessage chatMessage) {
        return ah.j0(qQAppInterface, j3, str, i3, chatMessage);
    }

    public static String getFileSizeInvalidTime(FileManagerEntity fileManagerEntity) {
        return ah.k0(fileManagerEntity);
    }

    public static long getFileSizes(String str) {
        return ah.l0(str);
    }

    public static int getFileSrcCloudType(FileManagerEntity fileManagerEntity) {
        return ah.m0(fileManagerEntity);
    }

    public static String getFileSuffix(String str) {
        return ah.n0(str);
    }

    public static String getFileType(int i3) {
        return ah.p0(i3);
    }

    public static int getFileTypeFromMultiMsgRecord(ChatMessage chatMessage) {
        return ah.r0(chatMessage);
    }

    private static ForwardFileInfo getForwardFileInfoWithMessage(FileManagerEntity fileManagerEntity, MessageForFile messageForFile) {
        return ForwardFileOption.V(fileManagerEntity, messageForFile);
    }

    public static byte[] getFullMd5(String str) {
        return ah.s0(str);
    }

    public static String getHardCodeConfig(String str) {
        return ah.t0(str);
    }

    public static String getImageUrl(FileManagerEntity fileManagerEntity) {
        return ah.u0(fileManagerEntity);
    }

    public static byte[] getMd5(String str, long j3) {
        return ah.w0(str, j3);
    }

    public static int[] getMediaFileWidthHeight(String str) {
        return ah.x0(str);
    }

    public static String getMultiFileThumbPath(ChatMessage chatMessage) {
        return ah.y0(chatMessage);
    }

    public static String getPeerNick(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        return ah.z0(qQAppInterface, str, str2, i3);
    }

    public static QQAppInterface getQQAppInterface() {
        return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
    }

    public static int getQlinkIntroShowTime(String str) {
        return ah.A0(str);
    }

    public static String getReportFileTypeStr(int i3) {
        return ah.B0(i3);
    }

    public static byte[] getSHA(String str) {
        return ah.C0(str);
    }

    public static byte[] getSha3(String str) {
        return ah.D0(str);
    }

    public static int getStatus(int i3) {
        return ah.F0(i3);
    }

    public static byte[] getTempSessionSig(QQAppInterface qQAppInterface, String str, int i3) {
        if (i3 != 100) {
            if (i3 != 109) {
                if (i3 != 124) {
                    if (i3 != 127) {
                        return null;
                    }
                    return qQAppInterface.getMsgCache().c1(str);
                }
                return qQAppInterface.getMsgCache().k0(str);
            }
            return qQAppInterface.getMsgCache().q0(str);
        }
        return qQAppInterface.getMsgCache().b0(str);
    }

    public static long getTempSessionType(int i3) {
        return ah.H0(i3);
    }

    public static TimeoutParam getTimeOutParamer() {
        return ah.I0();
    }

    public static w getTroopProcessCallback(QQAppInterface qQAppInterface) {
        return new a(qQAppInterface);
    }

    public static long getWeiyunZipTargetId(long j3) {
        return ah.J0(j3);
    }

    public static String getZipThumbSavePath(FileManagerEntity fileManagerEntity) {
        return ah.K0(fileManagerEntity);
    }

    public static String getZipThumbUrlWithFileUrl(String str) {
        return ah.L0(str);
    }

    public static String handleLongFileName(String str, boolean z16, int i3, TextPaint textPaint, int i16) {
        return ah.M0(str, z16, i3, textPaint, i16);
    }

    public static boolean hasNoThumb(FileManagerEntity fileManagerEntity) {
        return ah.N0(fileManagerEntity);
    }

    public static boolean hasShortCut(Context context, String str) {
        return ah.O0(context, str);
    }

    public static boolean hasThumb(FileManagerEntity fileManagerEntity) {
        return ah.P0(fileManagerEntity);
    }

    public static void initNoMedia() {
        ah.S0();
    }

    public static void initSaveToPc(QQAppInterface qQAppInterface, ChatMessage chatMessage, Context context) {
        ah.T0(qQAppInterface, chatMessage, context);
    }

    public static boolean initSaveToWeiYun(QQAppInterface qQAppInterface, ChatMessage chatMessage, Context context) {
        return ah.U0(qQAppInterface, chatMessage, context);
    }

    public static void installApkFile(Context context, String str) {
        ah.W0(context, str);
    }

    public static boolean is2GOr3G() {
        return ah.X0();
    }

    public static boolean isBuddyIntroShow(String str, String str2) {
        return ah.Y0(str, str2);
    }

    public static boolean isCheckComplexMessage(ChatMessage chatMessage) {
        return QFileUtils.d(chatMessage);
    }

    public static boolean isContainChinese(String str) {
        return ah.Z0(str);
    }

    public static boolean isLocalFile(String str) {
        return ah.b1(str);
    }

    public static boolean isLocalPreviewOffline(com.tencent.mobileqq.filemanager.fileviewer.j jVar) {
        int v3 = jVar.v();
        int c16 = jVar.c();
        String uuid = jVar.getUuid();
        String fileId = jVar.getFileId();
        if (v3 == 3 && c16 == 1 && (!TextUtils.isEmpty(uuid) || !TextUtils.isEmpty(fileId))) {
            return true;
        }
        return false;
    }

    public static boolean isMessageRecordOfFile(MessageRecord messageRecord) {
        if ((messageRecord instanceof MessageForFile) || (messageRecord instanceof MessageForTroopFile) || (messageRecord instanceof MessageForDLFile)) {
            return true;
        }
        return false;
    }

    public static boolean isMultiMessageSender(QQAppInterface qQAppInterface, ChatMessage chatMessage) {
        return ah.c1(qQAppInterface, chatMessage);
    }

    public static boolean isPreDownloadThumb() {
        return ah.d1();
    }

    public static boolean isSameDay(long j3, long j16, TimeZone timeZone) {
        return ah.e1(j3, j16, timeZone);
    }

    public static boolean isSupportFavorite(FileManagerEntity fileManagerEntity) {
        return ah.f1(fileManagerEntity);
    }

    public static boolean isTBSPreviewLocal(com.tencent.mobileqq.filemanager.fileviewer.j jVar) {
        int v3 = jVar.v();
        int c16 = jVar.c();
        if (v3 == 3 && c16 == 1) {
            return true;
        }
        return false;
    }

    public static boolean isTroopFile(FileManagerEntity fileManagerEntity) {
        return ah.g1(fileManagerEntity);
    }

    public static boolean isZipFile(QQAppInterface qQAppInterface, com.tencent.mobileqq.filemanager.fileviewer.j jVar, boolean z16) {
        return isZipFile(qQAppInterface, jVar.getFileName(), jVar.c(), z16);
    }

    public static LinkedHashMap jsonToMap(String str) {
        return ah.h1(str);
    }

    public static String mapToJson(Map map) {
        return ah.i1(map);
    }

    public static String millsTimeToString(long j3, int i3) {
        return ah.j1(j3, i3);
    }

    public static FileManagerEntity newEntityByDataLineFileInfo(DataLineMsgRecord dataLineMsgRecord) {
        FileManagerEntity fileManagerEntity;
        int i3;
        QQAppInterface qQAppInterface = getQQAppInterface();
        if (dataLineMsgRecord.entityID != 0) {
            fileManagerEntity = qQAppInterface.getFileManagerDataCenter().D(dataLineMsgRecord.entityID);
        } else {
            fileManagerEntity = null;
        }
        if (fileManagerEntity == null) {
            fileManagerEntity = new FileManagerEntity();
            long longValue = genSessionId().longValue();
            fileManagerEntity.nSessionId = longValue;
            dataLineMsgRecord.entityID = longValue;
            fileManagerEntity.datalineEntitySessionId = dataLineMsgRecord.sessionid;
            if (dataLineMsgRecord.nOpType == 31) {
                fileManagerEntity.strTroopFilePath = dataLineMsgRecord.fileUuid;
            }
        }
        if (fileManagerEntity.datalineEntitySessionId == 0) {
            fileManagerEntity.datalineEntitySessionId = dataLineMsgRecord.sessionid;
        }
        fileManagerEntity.setCloudType(6);
        fileManagerEntity.bSend = dataLineMsgRecord.isSendFromLocal();
        fileManagerEntity.status = -1;
        long j3 = dataLineMsgRecord.fileMsgStatus;
        if (j3 == 0) {
            fileManagerEntity.status = 1;
            if (!dataLineMsgRecord.issuc) {
                fileManagerEntity.status = 0;
            } else if (dataLineMsgRecord.progress != 1.0f) {
                fileManagerEntity.status = 2;
            }
        } else if (j3 == 2) {
            fileManagerEntity.status = 3;
            if (dataLineMsgRecord.progress == 0.0f) {
                fileManagerEntity.status = 0;
            }
        }
        if (dataLineMsgRecord.nOpType == 1) {
            fileManagerEntity.bSend = false;
        }
        fileManagerEntity.fileName = dataLineMsgRecord.filename;
        if (!TextUtils.isEmpty(dataLineMsgRecord.path)) {
            fileManagerEntity.setFilePath(dataLineMsgRecord.path);
        }
        String str = dataLineMsgRecord.serverPath;
        fileManagerEntity.Uuid = str;
        if (str == null && ((i3 = dataLineMsgRecord.nOpType) == 31 || i3 == 29)) {
            fileManagerEntity.Uuid = dataLineMsgRecord.fileUuid;
        }
        fileManagerEntity.peerType = 6000;
        fileManagerEntity.peerUin = AppConstants.DATALINE_PC_UIN;
        if (1 == DataLineMsgRecord.getDevTypeBySeId(dataLineMsgRecord.sessionid)) {
            fileManagerEntity.peerType = 6003;
            fileManagerEntity.peerUin = AppConstants.DATALINE_IPAD_UIN;
        }
        fileManagerEntity.fileSize = dataLineMsgRecord.filesize;
        fileManagerEntity.strFileMd5 = HexUtil.bytes2HexStr(dataLineMsgRecord.md5);
        int fileType = getFileType(dataLineMsgRecord.filename);
        fileManagerEntity.nFileType = fileType;
        if (fileType == 0) {
            String str2 = dataLineMsgRecord.thumbPath;
            fileManagerEntity.strThumbPath = str2;
            fileManagerEntity.strLargeThumPath = str2;
        } else if (fileType == -1 && dataLineMsgRecord.msgtype == -2000) {
            fileManagerEntity.nFileType = 0;
        }
        if (dataLineMsgRecord.strMoloKey != null) {
            fileManagerEntity.nFileType = getFileType(dataLineMsgRecord.path);
            fileManagerEntity.isFromrMolo = true;
        }
        correctProgressForDatalineEntity(dataLineMsgRecord, fileManagerEntity);
        fileManagerEntity.uniseq = dataLineMsgRecord.sessionid;
        fileManagerEntity.nOpType = dataLineMsgRecord.nOpType;
        fileManagerEntity.srvTime = dataLineMsgRecord.time * 1000;
        QLog.i(TAG, 1, "=_= create new Entity[" + fileManagerEntity.nSessionId + "] fileName[" + dataLineMsgRecord.filename + "] by dataline size(" + fileManagerEntity.imgHeight + ":" + fileManagerEntity.imgWidth + ")");
        qQAppInterface.getFileManagerDataCenter().v(fileManagerEntity);
        return fileManagerEntity;
    }

    public static FileManagerEntity newEntityByFav(String str, String str2, String str3, String str4, long j3, String str5, String str6, int i3, String str7) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = genSessionId().longValue();
        fileManagerEntity.strFavFileId = str2;
        fileManagerEntity.strFavId = str;
        fileManagerEntity.fileName = str4;
        fileManagerEntity.fileSize = j3;
        fileManagerEntity.nFileType = getFileType(str4);
        fileManagerEntity.setCloudType(10);
        fileManagerEntity.setFilePath(str3);
        fileManagerEntity.bSend = false;
        fileManagerEntity.status = -1;
        fileManagerEntity.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        fileManagerEntity.strFileMd5 = str5;
        fileManagerEntity.peerType = i3;
        fileManagerEntity.peerUin = str6;
        fileManagerEntity.strThumbPath = str7;
        if (i3 == 1) {
            fileManagerEntity.nOpType = 36;
        } else if (i3 == 0) {
            fileManagerEntity.nOpType = 37;
        } else if (i3 == 7) {
            fileManagerEntity.nOpType = 38;
        }
        getQQAppInterface().getFileManagerDataCenter().v(fileManagerEntity);
        return fileManagerEntity;
    }

    public static FileManagerEntity newEntityByLocalFileInfo(FileInfo fileInfo) {
        return ah.k1(fileInfo);
    }

    public static FileManagerEntity newEntityByOfflineFileInfo(OfflineFileInfo offlineFileInfo, int i3) {
        return ah.l1(offlineFileInfo, i3);
    }

    public static FileManagerEntity newEntityByPrinterFileInfo(PrinterItemMsgRecord printerItemMsgRecord) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = genSessionId().longValue();
        fileManagerEntity.setCloudType(6);
        fileManagerEntity.bSend = printerItemMsgRecord.isSendFromLocal();
        fileManagerEntity.status = 1;
        String str = printerItemMsgRecord.filename;
        fileManagerEntity.fileName = str;
        fileManagerEntity.setFilePath(str);
        fileManagerEntity.nOpType = 0;
        if (fileManagerEntity.bSend) {
            fileManagerEntity.nOpType = 0;
        }
        int lastIndexOf = printerItemMsgRecord.filename.lastIndexOf("/");
        if (lastIndexOf >= 0) {
            fileManagerEntity.fileName = printerItemMsgRecord.filename.substring(lastIndexOf + 1);
        } else {
            fileManagerEntity.fileName = printerItemMsgRecord.filename;
        }
        VFSFile vFSFile = new VFSFile(fileManagerEntity.getFilePath());
        if (vFSFile.exists()) {
            fileManagerEntity.fileSize = vFSFile.length();
        }
        fileManagerEntity.nFileType = getFileType(printerItemMsgRecord.filename);
        fileManagerEntity.fProgress = 1.0f;
        fileManagerEntity.uniseq = printerItemMsgRecord.uSessionID;
        QLog.i(TAG, 1, "=_= create new Entity[" + fileManagerEntity.nSessionId + "] fileName[" + printerItemMsgRecord.filename + "] by print size(" + fileManagerEntity.imgHeight + ":" + fileManagerEntity.imgWidth + ")");
        getQQAppInterface().getFileManagerDataCenter().v(fileManagerEntity);
        return fileManagerEntity;
    }

    public static FileManagerEntity newEntityByTroopFileInfo(com.tencent.mobileqq.troop.data.t tVar) {
        return newEntityByTroopFileInfo(tVar, genSessionId().longValue(), 4, -1);
    }

    public static FileManagerEntity newEntityByWeiYunFileInfo(WeiYunFileInfo weiYunFileInfo) {
        return ah.m1(weiYunFileInfo);
    }

    public static FileManagerEntity newEntityByWeiYunMiniAppParams(Bundle bundle) {
        return ah.n1(bundle);
    }

    public static void onDatalineForward(FileManagerEntity fileManagerEntity, QQAppInterface qQAppInterface, Activity activity, int i3) {
        ah.o1(fileManagerEntity, qQAppInterface, activity, i3);
    }

    public static void onQlinkFileErrIconClicked(QQAppInterface qQAppInterface, Context context, FileManagerEntity fileManagerEntity) {
        ah.p1(qQAppInterface, context, fileManagerEntity);
    }

    public static void openFileWithOtherAppWithSystem(Context context, String str) {
        ah.q1(context, str);
    }

    public static void openUrl(Context context, String str) {
        String trim = str.trim();
        Intent intent = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
        intent.putExtra("param_force_internal_browser", true);
        String tencentDocSourceAdtagStrUrl = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_BANNER);
        intent.putExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_BANNER);
        intent.putExtra("url", tencentDocSourceAdtagStrUrl);
        intent.putExtra("webStyle", "noBottomBar");
        intent.putExtra("fromAio", true);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (!((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(context, tencentDocSourceAdtagStrUrl, intent.getStringExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG))) {
            WebAccelerator.s(context, intent, trim);
        }
    }

    public static void openWithOtherApp(Activity activity, String str) {
        ah.r1(activity, str);
    }

    public static void preLoadThumb(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        ah.s1(qQAppInterface, fileManagerEntity);
    }

    public static void previewFavImageFile(Activity activity) {
        ArrayList arrayList = new ArrayList();
        ArrayList<FavFileInfo> favFiles = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getFavFiles();
        if (favFiles != null && favFiles.size() > 0) {
            Iterator<FavFileInfo> it = favFiles.iterator();
            while (it.hasNext()) {
                FavFileInfo next = it.next();
                if (getFileType(next.f207675h) == 0) {
                    arrayList.add(Long.valueOf(next.f207672d));
                }
            }
        }
        if (arrayList.size() > 0) {
            long longValue = ((Long) arrayList.get(0)).longValue();
            int size = arrayList.size();
            long[] jArr = new long[size];
            for (int i3 = 0; i3 < size; i3++) {
                jArr[i3] = ((Long) arrayList.get(i3)).longValue();
            }
            QfavHelper.x(activity, getQQAppInterface().getCurrentAccountUin(), longValue, jArr);
        }
    }

    public static void previewImage(Activity activity, FileManagerEntity fileManagerEntity, boolean z16) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "none select!why you can preview!");
                return;
            }
            return;
        }
        com.tencent.mobileqq.filemanager.openbrowser.h hVar = new com.tencent.mobileqq.filemanager.openbrowser.h(getQQAppInterface());
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        eVar.g(com.tencent.mobileqq.richmedia.depend.f.class.getName(), hVar);
        eVar.g(com.tencent.mobileqq.richmedia.depend.d.class.getName(), hVar);
        eVar.g(com.tencent.mobileqq.richmedia.depend.a.class.getName(), hVar);
        List<RFWLayerItemMediaInfo> s16 = hVar.s();
        ArrayList arrayList = new ArrayList();
        if (s16.size() > 0) {
            arrayList.add(s16.get(0));
            eVar.j(s16);
            eVar.i(0);
            RFWLayerLaunchUtil.jumpToGallery(new ImageView(activity), arrayList, 0, QQGalleryActivity.class, FilePreviewLayerFragment.class, new Bundle());
            return;
        }
        QLog.i(TAG, 1, "browserRichMedia exception: index=0, dataList size=" + arrayList.size());
    }

    public static void previewSearchFile(QQAppInterface qQAppInterface, Context context, FileManagerEntity fileManagerEntity) {
        if (qQAppInterface != null && fileManagerEntity != null) {
            com.tencent.mobileqq.filemanager.openbrowser.g gVar = new com.tencent.mobileqq.filemanager.openbrowser.g(qQAppInterface, fileManagerEntity.peerUin, fileManagerEntity);
            com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
            eVar.g(com.tencent.mobileqq.richmedia.depend.f.class.getName(), gVar);
            eVar.g(com.tencent.mobileqq.richmedia.depend.d.class.getName(), gVar);
            List<RFWLayerItemMediaInfo> s16 = gVar.s();
            ArrayList arrayList = new ArrayList();
            int p16 = gVar.p();
            if (p16 < s16.size()) {
                arrayList.add(s16.get(p16));
                eVar.j(s16);
            } else {
                arrayList.add(mb1.a.f416517a.d(fileManagerEntity));
                eVar.j(arrayList);
                p16 = 0;
            }
            eVar.i(p16);
            RFWLayerLaunchUtil.jumpToGallery(new ImageView(context), arrayList, 0, QQGalleryActivity.class, FilePreviewLayerFragment.class, new Bundle());
            return;
        }
        QLog.i(TAG, 1, "previewSearchFile error: appInterface=" + qQAppInterface + ", entity=" + fileManagerEntity);
    }

    public static synchronized String printFileManagerEntityInfo(FileManagerEntity fileManagerEntity) {
        String t16;
        synchronized (FileManagerUtil.class) {
            t16 = ah.t1(fileManagerEntity);
        }
        return t16;
    }

    public static synchronized String printStack() {
        String u16;
        synchronized (FileManagerUtil.class) {
            u16 = ah.u1();
        }
        return u16;
    }

    public static void processAIOTimGraytips(QQAppInterface qQAppInterface, long j3) {
        ah.v1(qQAppInterface, j3);
    }

    public static String recreateFilePath(String str) {
        return ah.w1(str);
    }

    public static boolean renameFile(VFSFile vFSFile, VFSFile vFSFile2) {
        return ah.x1(vFSFile, vFSFile2);
    }

    public static void reportFileAssistans(QQAppInterface qQAppInterface, Context context) {
        ah.z1(qQAppInterface, context);
    }

    public static void reportFilemanagerFaildInfo(QQAppInterface qQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, String str6, long j18, long j19, long j26, String str7, String str8, int i3, String str9, String str10) {
        ah.A1(qQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, str6, j18, j19, j26, str7, str8, i3, str9, str10);
    }

    public static void reportFilemanagerFaildInfoEx(QQAppInterface qQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, String str6, long j18, long j19, long j26, String str7, String str8, int i3, String str9, String str10, Bundle bundle) {
        ah.B1(qQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, str6, j18, j19, j26, str7, str8, i3, str9, str10, bundle);
    }

    public static void reportFilemanagerSuccessInfo(QQAppInterface qQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, long j18, long j19, int i3, String str6) {
        ah.C1(qQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, j18, j19, i3, str6);
    }

    public static void reportFilemanagerSuccessInfoEx(QQAppInterface qQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, long j18, long j19, int i3, String str6, Bundle bundle) {
        ah.D1(qQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, j18, j19, i3, str6, bundle);
    }

    public static String reportSrcType(int i3, int i16) {
        return ah.E1(i3, i16);
    }

    public static void resume(Context context, FileManagerEntity fileManagerEntity, QQAppInterface qQAppInterface, boolean z16) {
        ah.F1(context, fileManagerEntity, qQAppInterface, z16);
    }

    public static void saveQlinkIntroShowTime(String str, int i3) {
        ah.G1(str, i3);
    }

    public static void saveToAlbum(Context context, String str) {
        ah.H1(context, str);
    }

    public static void setBuddyIntroShow(String str, String str2, boolean z16) {
        ah.I1(str, str2, z16);
    }

    public static void setFileIcon(ImageView imageView, String str) {
        ah.K1(imageView, str);
    }

    public static void setTempParam(QQAppInterface qQAppInterface, String str, String str2, FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, printStack());
                return;
            }
            return;
        }
        int tempSessionType = (int) getTempSessionType(fileManagerEntity.peerType);
        QLog.i(TAG, 2, "=_= Id[" + fileManagerEntity.nSessionId + "],setTempParam[" + tempSessionType + "]");
        fileManagerEntity.tmpSessionType = (long) tempSessionType;
        fileManagerEntity.tmpSessionSig = getTempSessionSig(qQAppInterface, fileManagerEntity.peerUin, tempSessionType);
        if (tempSessionType != 102) {
            if (tempSessionType == 104 || tempSessionType == 105) {
                fileManagerEntity.tmpSessionRelatedUin = str;
                return;
            }
            return;
        }
        fileManagerEntity.tmpSessionFromPhone = str;
        fileManagerEntity.tmpSessionToPhone = str2;
    }

    public static void setZipImageFileIcon(AsyncImageView asyncImageView, FileManagerEntity fileManagerEntity) {
        ah.P1(asyncImageView, fileManagerEntity);
    }

    public static void showFlowDialog(boolean z16, Context context, FMDialogUtil.c cVar) {
        ah.Q1(z16, context, cVar);
    }

    public static ah.g syncCreateVideoThumb(String str) {
        return ah.U1(str);
    }

    public static void updateBatProcessTips(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        ah.V1(qQAppInterface, str, str2, i3);
    }

    public static String updateRecentListTxt(QQAppInterface qQAppInterface, Message message) {
        return ah.W1(qQAppInterface, message);
    }

    public static String updateRecentListTxtByMessageRecord(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        return ah.X1(qQAppInterface, messageRecord);
    }

    public static void addShortcut(@NonNull QQAppInterface qQAppInterface, Context context, String str, String str2, int i3, Bundle bundle) {
        ah.d(qQAppInterface, context, str, str2, i3, bundle);
    }

    public static void dealWithErrCode(String str) {
        ah.z(str);
    }

    public static int getFileIconResId(int i3) {
        return ah.d0(i3);
    }

    public static synchronized int getFileType(String str) {
        int o06;
        synchronized (FileManagerUtil.class) {
            o06 = ah.o0(str);
        }
        return o06;
    }

    public static byte[] getMd5(String str) {
        return ah.v0(str);
    }

    public static boolean initSaveToWeiYun(QQAppInterface qQAppInterface, ChatMessage chatMessage, Context context, boolean z16) {
        return ah.V0(qQAppInterface, chatMessage, context, z16);
    }

    public static boolean isZipFile(QQAppInterface qQAppInterface, String str, int i3, boolean z16) {
        int i16;
        String previewConfig = ((IFMConfig) QRoute.api(IFMConfig.class)).getPreviewConfig(getContextByApp(qQAppInterface), str, "PreviewMode");
        if (previewConfig == null || previewConfig.length() <= 0) {
            i16 = -1;
        } else {
            try {
                i16 = Integer.parseInt(previewConfig);
                if (i3 == 16) {
                    QLog.d(TAG, 1, "isZipFile invalid file status: " + i3);
                    return false;
                }
            } catch (NumberFormatException e16) {
                QLog.d(TAG, 1, "isZipFile", e16);
                return false;
            }
        }
        boolean bZip = bZip(i16);
        return z16 ? bZip && NetworkUtil.isNetSupport(BaseApplication.getContext()) : bZip;
    }

    public static FileManagerEntity newEntityByTroopFileInfo(com.tencent.mobileqq.troop.data.t tVar, long j3) {
        return newEntityByTroopFileInfo(tVar, j3, 4, -1);
    }

    public static boolean renameFile(File file, File file2) {
        return ah.y1(file, file2);
    }

    public static void setFileIcon(ImageView imageView, FileManagerEntity fileManagerEntity) {
        ah.J1(imageView, fileManagerEntity);
    }

    public static void showFlowDialog(boolean z16, Context context, FMDialogUtil.c cVar, int i3) {
        ah.R1(z16, context, cVar, i3);
    }

    public static String updateRecentListTxt(QQAppInterface qQAppInterface, DataLineMsgRecord dataLineMsgRecord) {
        if (dataLineMsgRecord == null) {
            return null;
        }
        return "[" + getFileType(getFileType(dataLineMsgRecord.path)) + "]" + dataLineMsgRecord.filename;
    }

    public static int getFileIconResId(int i3, int i16) {
        return ah.e0(i3, i16);
    }

    public static FileManagerEntity newEntityByTroopFileInfo(com.tencent.mobileqq.troop.data.t tVar, long j3, int i3, int i16) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = j3;
        fileManagerEntity.setCloudType(i3);
        fileManagerEntity.nOpType = i16;
        fileManagerEntity.fileName = tVar.f294987u;
        if (q.p(tVar.f294978l)) {
            fileManagerEntity.setFilePath(tVar.f294978l);
        }
        if (q.p(tVar.f294980n)) {
            fileManagerEntity.strLargeThumPath = tVar.f294980n;
        }
        if (q.p(tVar.f294979m)) {
            fileManagerEntity.strThumbPath = tVar.f294979m;
        } else if (q.p(tVar.f294981o)) {
            fileManagerEntity.strMiddleThumPath = tVar.f294981o;
        }
        long j16 = tVar.f294976j;
        fileManagerEntity.fileSize = j16;
        fileManagerEntity.fProgress = ((float) tVar.f294977k) / ((float) j16);
        fileManagerEntity.nFileType = getFileType(tVar.f294987u);
        int i17 = tVar.f294972f;
        if (6 > i17 || 13 == i17) {
            fileManagerEntity.status = 2;
        } else if (12 == i17) {
            fileManagerEntity.status = 0;
        } else {
            fileManagerEntity.status = 1;
        }
        UUID uuid = tVar.f294967a;
        if (uuid != null) {
            fileManagerEntity.strTroopFileID = uuid.toString();
        }
        fileManagerEntity.strTroopFilePath = tVar.f294985s;
        fileManagerEntity.strTroopFileSha1 = tVar.f294986t;
        fileManagerEntity.busId = tVar.f294988v;
        long j17 = tVar.f294971e;
        fileManagerEntity.TroopUin = j17;
        fileManagerEntity.peerType = 1;
        fileManagerEntity.peerUin = String.valueOf(j17);
        fileManagerEntity.peerUid = String.valueOf(tVar.f294971e);
        fileManagerEntity.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        fileManagerEntity.uniseq = tVar.f294970d;
        fileManagerEntity.yybApkPackageName = tVar.B;
        fileManagerEntity.yybApkName = tVar.C;
        fileManagerEntity.yybApkIconUrl = tVar.D;
        fileManagerEntity.apkSafeLevel = tVar.E;
        fileManagerEntity.apkSafeMsg = tVar.F;
        fileManagerEntity.apkSafeDetailUrl = tVar.G;
        fileManagerEntity.Uuid = tVar.f294968b;
        QLog.i(TAG, 1, "=_= create new Entity[" + fileManagerEntity.nSessionId + "] fileName[" + tVar.f294987u + "] localFile[" + fileManagerEntity.getFilePath() + "] by troop size(" + fileManagerEntity.imgHeight + ":" + fileManagerEntity.imgWidth + ")");
        getQQAppInterface().getFileManagerDataCenter().v(fileManagerEntity);
        return fileManagerEntity;
    }

    public static void setFileIcon(com.dataline.util.widget.AsyncImageView asyncImageView, DataLineMsgRecord dataLineMsgRecord) {
        String j3 = q.j(dataLineMsgRecord.filename);
        if (j3 == null) {
            asyncImageView.setImageResource(R.drawable.f161608ea0);
            return;
        }
        String str = dataLineMsgRecord.filename;
        if (getFileType(j3) == 0) {
            if (FileUtils.fileExistsAndNotEmpty(dataLineMsgRecord.thumbPath)) {
                str = dataLineMsgRecord.thumbPath;
            } else {
                String d16 = l.d(dataLineMsgRecord.path);
                if (FileUtils.fileExistsAndNotEmpty(d16)) {
                    str = d16;
                }
            }
        }
        asyncImageView.setDefaultImage(getFileIconResId(j3));
        if (getFileType(j3) != 0) {
            int fileIconResId = getFileIconResId(j3);
            if (fileIconResId != 0) {
                asyncImageView.setImageResource(fileIconResId);
                return;
            }
            return;
        }
        asyncImageView.setAsyncClipSize(128, 128);
        asyncImageView.setAsyncImage(str);
    }

    public static void setFileIcon(AsyncImageView asyncImageView, FileManagerEntity fileManagerEntity) {
        ah.L1(asyncImageView, fileManagerEntity);
    }

    public static void setFileIcon(AsyncImageView asyncImageView, String str) {
        ah.K1(asyncImageView, str);
    }

    public static void setFileIcon(AsyncImageView asyncImageView, String str, boolean z16) {
        ah.N1(asyncImageView, str, z16);
    }

    public static void setFileIcon(AsyncImageView asyncImageView, String str, int i3) {
        ah.M1(asyncImageView, str, i3);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f209166a;

        a(QQAppInterface qQAppInterface) {
            this.f209166a = qQAppInterface;
        }

        @Override // com.tencent.mobileqq.filemanager.util.w
        public String a(String str, int i3, String str2, int i16, String str3, String str4, long j3, long j16, long j17, int i17) {
            int i18;
            int i19;
            FileManagerEntity fileManagerEntity;
            long t16;
            if (i3 == 3000) {
                i18 = 106;
            } else if (i3 == 6000) {
                i18 = 38;
            } else {
                i18 = 3;
            }
            int i26 = i18;
            TroopFileTransferManager O = TroopFileTransferManager.O(this.f209166a, Long.valueOf(str2).longValue());
            if (O == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(FileManagerUtil.TAG, 2, "send2Troop: troopuin error");
                    return null;
                }
                return null;
            }
            int abs = Math.abs(new Random().nextInt());
            FileManagerEntity D = this.f209166a.getFileManagerDataCenter().D(j16);
            com.tencent.mobileqq.troop.data.t r06 = O.r0(str3, str4, null, j3, i26, abs, Long.valueOf(str).longValue(), j16, D, null);
            if (r06 == null) {
                QLog.e(FileManagerUtil.TAG, 1, "startCopy2TroopFromOfflineOrDisc return null!");
                return "";
            }
            int fileType = FileManagerUtil.getFileType(r06.f294978l);
            if (q.p(r06.f294978l) && (fileType == 0 || fileType == 2)) {
                if (fileType == 0) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(r06.f294978l, options);
                    i19 = 2;
                    t16 = TroopFileUtils.s(this.f209166a, str2, r06.f294987u, r06.f294976j, r06.f294967a.toString(), abs, String.valueOf(r06.f294971e), j16, options.outWidth, options.outHeight, j17, i17);
                } else {
                    i19 = 2;
                    if (fileType == 2) {
                        int[] videoFileRtAndTime = ShortVideoUtils.getVideoFileRtAndTime(r06.f294978l);
                        t16 = TroopFileUtils.r(this.f209166a, str2, r06.f294987u, r06.f294976j, r06.f294967a.toString(), abs, String.valueOf(r06.f294971e), j16, videoFileRtAndTime[0], videoFileRtAndTime[1], videoFileRtAndTime[2], j17, i17, null);
                    } else {
                        t16 = 0;
                    }
                }
                fileManagerEntity = D;
            } else {
                i19 = 2;
                fileManagerEntity = D;
                if (fileManagerEntity != null) {
                    t16 = TroopFileUtils.r(this.f209166a, str2, str4, j3, r06.f294967a.toString(), abs, String.valueOf(8888L), j16, fileManagerEntity.imgWidth, fileManagerEntity.imgHeight, 0, j17, i17, null);
                } else {
                    t16 = TroopFileUtils.t(this.f209166a, str2, str4, j3, r06.f294967a.toString(), abs, String.valueOf(8888L), j16, j17, i17);
                }
            }
            if (fileManagerEntity != null) {
                fileManagerEntity.structMsgSeq = t16;
                if (QLog.isColorLevel()) {
                    QLog.d(FileManagerUtil.TAG, i19, "prepareForward2Troop==>InsertAIOMsg, msgSeq:" + t16);
                }
            }
            return r06.f294967a.toString();
        }

        @Override // com.tencent.mobileqq.filemanager.util.w
        public long b(String str, int i3, String str2, int i16, String str3, String str4, String str5, long j3, int i17, long j16, int i18) {
            return 0L;
        }

        @Override // com.tencent.mobileqq.filemanager.util.w
        public long c(String str, int i3, String str2, int i16, String str3, String str4, String str5, long j3, int i17) {
            return b(str, i3, str2, i16, str3, str4, str5, j3, i17, 0L, 0);
        }

        @Override // com.tencent.mobileqq.filemanager.util.w
        public void d(boolean z16, String str, long j3, int i3, String str2, String str3, String str4) {
            if (QLog.isColorLevel()) {
                QLog.i(FileManagerUtil.TAG, 2, "getTroopProcessCallback->onResult2Troop{bSuccess[" + z16 + "],troopFileUuid[" + str + "],nSessionId[" + j3 + "],retCode[" + i3 + "],retMsg[" + str2 + "],troopUin[" + str3 + "],newFilePath[" + str4 + "]}");
            }
            TroopFileTransferManager O = TroopFileTransferManager.O(this.f209166a, Long.valueOf(str3).longValue());
            if (O != null) {
                O.E(j3, UUID.fromString(str), null, i3, str4, str2);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.w
        public void e(boolean z16, long j3, int i3, String str, String str2, String str3, String str4) {
        }
    }
}
