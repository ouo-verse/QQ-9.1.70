package com.tencent.qqnt.mycomputer.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.msg.migration.DataLineNTMsgMigrationUtil;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import cooperation.qqfav.QfavHelper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import k0.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J3\u0010\u0012\u001a\u00020\n\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J=\u0010\u0016\u001a\u00020\n\"\u0004\b\u0000\u0010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0017JC\u0010\u001b\u001a\u00020\n\"\u0004\b\u0000\u0010\f2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\n\u00a2\u0006\u0004\b\u001b\u0010\u001cJ(\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0003J*\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0%j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n`&2\u0006\u0010$\u001a\u00020\u0003\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/mycomputer/utils/c;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "paths", "", "g", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entry", "", h.F, "T", "msgText", IProfileProtocolConst.PARAM_TARGET_UIN, "", "migSdkShareFlag", "callback", "f", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)I", "path", "forwardFileType", "d", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;I)I", "items", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "j", "(Ljava/util/ArrayList;Ljava/lang/Object;Lcom/tencent/mobileqq/activity/aio/SessionInfo;I)I", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/filemanager/data/ForwardFileInfo;", "forwardFileInfo", "forwardType", "e", "c", "devicePeerUid", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "i", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f359781a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64130);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f359781a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long g(ArrayList<String> paths) {
        long j3 = 0;
        if (paths == null) {
            return 0L;
        }
        Iterator<String> it = paths.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                j3 += new VFSFile(next).length();
            }
        }
        return j3;
    }

    private final int h(FileManagerEntity entry) {
        if (entry == null) {
            QLog.i(AppConstants.NEW_MY_COMPUTER, 2, "\u8f6c\u53d1\u6587\u4ef6, FileManagerEntity\u4e3a\u7a7a");
            return 255;
        }
        if (!TextUtils.isEmpty(entry.getFilePath()) && new File(entry.getFilePath()).exists()) {
            return 0;
        }
        int cloudType = entry.getCloudType();
        if (cloudType != 10) {
            switch (cloudType) {
                case 1:
                    int i3 = entry.peerType;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            return 2;
                        }
                        if (i3 != 3000) {
                            if (i3 != 6000) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("DataLineHandler", 2, "\u8f6c\u53d1\u6587\u4ef6, \u672a\u77e5\u7684\u6587\u4ef6\u6765\u6e90\u9ed8\u8ba4\u4e3aC2C, peerType[" + entry.peerType + "]\uff0c name[" + entry.fileName + "], LocalPath[" + entry.getFilePath() + "], FileSize[" + entry.fileSize + "], fileFrom[1], peerUin[" + entry.peerUin + "], cloudType[" + entry.getCloudType());
                                }
                            } else {
                                return 5;
                            }
                        } else {
                            return 3;
                        }
                    }
                    return 1;
                case 2:
                    return 4;
                case 3:
                case 5:
                case 6:
                case 7:
                    break;
                case 4:
                    return 2;
                default:
                    if (QLog.isColorLevel()) {
                        QLog.e("dataline", 2, "FileManagerEntity->cloudType \u8f6c ForwardFileInfo->type\uff0c \u672a\u8bc6\u522b\u7684cloudType[" + entry.getCloudType());
                        break;
                    }
                    break;
            }
            return 255;
        }
        return 6;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r6v11, types: [T, java.util.Collection, java.util.ArrayList] */
    private static final int k(ArrayList<String> arrayList, final SessionInfo sessionInfo, int i3, QQAppInterface qQAppInterface) {
        ?? emptyList;
        int i16;
        boolean z16;
        boolean z17;
        boolean z18;
        CollectionsKt__CollectionsKt.emptyList();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        objectRef.element = emptyList;
        AbstractCollection<String> abstractCollection = arrayList;
        if ((abstractCollection instanceof Collection) && arrayList.isEmpty()) {
            i16 = 0;
        } else {
            Iterator<T> it = arrayList.iterator();
            i16 = 0;
            while (it.hasNext()) {
                if (com.tencent.qqnt.aio.element.file.util.a.e((String) it.next()) == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && (i16 = i16 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i16 >= 4) {
            AbstractCollection arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (com.tencent.qqnt.aio.element.file.util.a.e((String) obj) != 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    arrayList2.add(obj);
                }
            }
            ?? arrayList3 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (com.tencent.qqnt.aio.element.file.util.a.e((String) obj2) == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList3.add(obj2);
                }
            }
            objectRef.element = arrayList3;
            abstractCollection = arrayList2;
        }
        for (String str : abstractCollection) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "path is " + str + ", sessionInfo.troopUin is " + sessionInfo.f179559f + ", sessionInfo.curFriendUin is " + sessionInfo.f179557e + ", sessionInfo.uid is " + sessionInfo.f178172i0 + ", sessionInfo.curType is " + sessionInfo.f179555d);
            if (i3 == 101) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("forward_photo_to_myComputer", true);
                qQAppInterface.getNTFileManageBridger().W(str, sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, true, 0L, 0, bundle);
            } else {
                qQAppInterface.getNTFileManageBridger().W(str, sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, true, 0L, 0, null);
            }
        }
        if (!((Collection) objectRef.element).isEmpty()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.mycomputer.utils.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.l(SessionInfo.this, objectRef);
                }
            }, 300L);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(SessionInfo sessionInfo, Ref.ObjectRef multiPicItems) {
        Intrinsics.checkNotNullParameter(sessionInfo, "$sessionInfo");
        Intrinsics.checkNotNullParameter(multiPicItems, "$multiPicItems");
        IMyComputerHelpApi iMyComputerHelpApi = (IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class);
        String str = sessionInfo.f179557e;
        Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.curFriendUin");
        iMyComputerHelpApi.myComputerSendMultiFileFromPhoto(DataLineNTMsgMigrationUtil.e(str), (List) multiPicItems.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ArrayList items, SessionInfo sessionInfo, int i3, QQAppInterface qQAppInterface) {
        Intrinsics.checkNotNullParameter(items, "$items");
        Intrinsics.checkNotNullParameter(sessionInfo, "$sessionInfo");
        k(items, sessionInfo, i3, qQAppInterface);
    }

    @NotNull
    public final SessionInfo c(@NotNull String targetUin) {
        boolean equals;
        boolean equals2;
        boolean equals3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SessionInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) targetUin);
        }
        Intrinsics.checkNotNullParameter(targetUin, "targetUin");
        SessionInfo sessionInfo = new SessionInfo();
        String str = AppConstants.DATALINE_PC_UIN;
        equals = StringsKt__StringsJVMKt.equals(str, targetUin, true);
        if (equals) {
            sessionInfo.f178172i0 = PeerUid.DATALINE_PC_UID;
            sessionInfo.f179557e = str;
            sessionInfo.f179555d = 6000;
            return sessionInfo;
        }
        String str2 = AppConstants.DATALINE_IPAD_UIN;
        equals2 = StringsKt__StringsJVMKt.equals(str2, targetUin, true);
        if (equals2) {
            sessionInfo.f178172i0 = PeerUid.DATALINE_PAD_UID;
            sessionInfo.f179557e = str2;
            sessionInfo.f179555d = 6003;
            return sessionInfo;
        }
        String str3 = AppConstants.DATALINE_PHONE_UIN;
        equals3 = StringsKt__StringsJVMKt.equals(str3, targetUin, true);
        if (equals3) {
            sessionInfo.f178172i0 = PeerUid.DATALINE_PHONE_UID;
            sessionInfo.f179557e = str3;
            sessionInfo.f179555d = 6005;
        }
        return sessionInfo;
    }

    public final <T> int d(@Nullable String path, @NotNull String targetUin, boolean migSdkShareFlag, T callback, int forwardFileType) {
        List split$default;
        String[] strArr;
        AppRuntime peekAppRuntime;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, path, targetUin, Boolean.valueOf(migSdkShareFlag), callback, Integer.valueOf(forwardFileType))).intValue();
        }
        Intrinsics.checkNotNullParameter(targetUin, "targetUin");
        if (path != null && !Intrinsics.areEqual(path, "")) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "forwardFile path : " + path);
            ArrayList<String> arrayList = new ArrayList<>();
            if ((path.length() == 0) || !new File(path).exists()) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) path, new String[]{";"}, false, 0, 6, (Object) null);
                Object[] array = split$default.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                strArr = (String[]) array;
            } else {
                strArr = new String[]{path};
            }
            if (strArr.length > 1) {
                QQBeaconReport.report("forward_multi_path_dataline");
            }
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (q.f(strArr[i3])) {
                    str = strArr[i3];
                } else {
                    try {
                        str = URLDecoder.decode(strArr[i3], "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.e(AppConstants.NEW_MY_COMPUTER, 1, "forwardFile|decode exp. imageUrls[i]=" + strArr[i3]);
                        }
                    } catch (IllegalArgumentException unused2) {
                        str = strArr[i3];
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "{\n                try {\n\u2026          }\n            }");
                }
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "forwardFile pathTemp : " + str + ", FileManagerUtil.getFileType(fileName): " + FileManagerUtil.getFileType(str));
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                } else if (QLog.isColorLevel()) {
                    QLog.e(AppConstants.NEW_MY_COMPUTER, 1, "forwardFile|file path invalid. path=" + str);
                }
            }
            if (!(!arrayList.isEmpty())) {
                return 4;
            }
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "forwardFile items.size is " + arrayList.size());
            String str2 = c(targetUin).f178172i0;
            if ((str2 == null || str2.length() == 0) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                return 8;
            }
            if (migSdkShareFlag) {
                ReportController.o(peekAppRuntime, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.e(AppConstants.NEW_MY_COMPUTER, 1, "forwardFile shareFromMigSdk|report send file:0X8004932.");
                }
            }
            return j(arrayList, callback, c(targetUin), forwardFileType) == 0 ? 0 : 8;
        }
        QLog.e(AppConstants.NEW_MY_COMPUTER, 1, "forwardFile. path=null");
        return 4;
    }

    public final boolean e(@NotNull Bundle bundle, @Nullable ForwardFileInfo forwardFileInfo, int forwardType, @NotNull String targetUin) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, bundle, forwardFileInfo, Integer.valueOf(forwardType), targetUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(targetUin, "targetUin");
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "forwardOfflineFile forwardFileType: " + forwardType + ", devType: " + targetUin + ", forwardFileInfo: " + forwardFileInfo);
        if (forwardFileInfo == null) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return false;
        }
        FileManagerEntity D = qQAppInterface.getFileManagerDataCenter().D(forwardFileInfo.n());
        if (D == null && forwardFileInfo.c() == 10) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "forwardOfflineFile null == entry , CLOUD_TYPE_QFAV");
            long k3 = forwardFileInfo.k();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(k3);
            D = QfavHelper.m(bundle, sb5.toString(), 7);
        }
        if (D == null) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "forwardOfflineFile null == entry");
            return false;
        }
        if (D.status == 16) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "forwardOfflineFile entry != null but is FILE_STATUS_INVALID_FILE");
            return false;
        }
        int h16 = h(D);
        int i3 = D.peerType;
        String str = D.fileName;
        String filePath = D.getFilePath();
        long j3 = D.fileSize;
        int i16 = D.peerType;
        String str2 = D.peerUin;
        int cloudType = D.getCloudType();
        StringBuilder sb6 = new StringBuilder();
        FileManagerEntity fileManagerEntity = D;
        sb6.append("\u6253\u5370\u4e00\u4e0bentry, [");
        sb6.append(i3);
        sb6.append("]\uff0c name[");
        sb6.append(str);
        sb6.append("], LocalPath[");
        sb6.append(filePath);
        sb6.append("], FileSize[");
        sb6.append(j3);
        sb6.append("], fileFrom[");
        sb6.append(h16);
        sb6.append("], peerType[");
        sb6.append(i16);
        sb6.append("], peerUin[");
        sb6.append(str2);
        sb6.append("], cloudType[");
        sb6.append(cloudType);
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, sb6.toString());
        SessionInfo c16 = c(targetUin);
        if (h16 != 1) {
            if (h16 != 2) {
                if (h16 != 3) {
                    if (h16 != 6) {
                        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "ForwardOfflineFile fileFrom " + h16 + " is not handled");
                        return false;
                    }
                    qQAppInterface.getFileManagerEngine().C0(fileManagerEntity, c16.f179557e, c16.f178172i0, c16.f179555d, forwardFileInfo.L);
                    QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "FileFrom_FAV");
                    return true;
                }
                QQAppInterface qQAppInterface2 = qQAppInterface;
                FileManagerEntity h06 = qQAppInterface.getFileManagerEngine().h0(fileManagerEntity, qQAppInterface.getCurrentAccountUin(), c16.f179557e, c16.f178172i0, c16.f179555d, true, forwardFileInfo.r(), forwardFileInfo.L);
                h06.selfUin = fileManagerEntity.peerUin;
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "FileFrom_Discussion, [" + h06.peerType + "]\uff0c name[" + h06.fileName + "], LocalPath[" + h06.getFilePath() + "], FileSize[" + h06.fileSize + "], peerType[" + h06.peerType + "], peerUin[" + h06.peerUin + "], cloudType[" + h06.getCloudType() + "], selfUin[" + h06.selfUin);
                h06.nOpType = 21;
                qQAppInterface2.getFileManagerEngine().u(h06, 21);
                qQAppInterface2.getFileManagerDataCenter().f0(h06);
                return true;
            }
            FileManagerEngine fileManagerEngine = qQAppInterface.getFileManagerEngine();
            long n3 = forwardFileInfo.n();
            String q16 = forwardFileInfo.q();
            long k16 = forwardFileInfo.k();
            String str3 = c16.f179557e;
            Intrinsics.checkNotNullExpressionValue(str3, "sessionInfo.curFriendUin");
            fileManagerEngine.G(n3, q16, k16, Long.parseLong(str3), c16.f178172i0, c16.f179555d, forwardFileInfo.j());
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "FileFrom_Group");
            return true;
        }
        QQAppInterface qQAppInterface3 = qQAppInterface;
        FileManagerEntity h07 = qQAppInterface3.getFileManagerEngine().h0(fileManagerEntity, qQAppInterface3.getCurrentAccountUin(), c16.f179557e, c16.f178172i0, c16.f179555d, true, forwardFileInfo.r(), forwardFileInfo.L);
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "FileFrom_C2C, [" + h07.peerType + "]\uff0c name[" + h07.fileName + "], LocalPath[" + h07.getFilePath() + "], FileSize[" + h07.fileSize + "], peerType[" + h07.peerType + "], peerUin[" + h07.peerUin + "], cloudType[" + h07.getCloudType() + "], selfUin[" + h07.selfUin);
        qQAppInterface3.getFileManagerEngine().C(h07);
        qQAppInterface3.getFileManagerDataCenter().f0(h07);
        return true;
    }

    public final <T> int f(@NotNull String msgText, @NotNull String targetUin, boolean migSdkShareFlag, T callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, msgText, targetUin, Boolean.valueOf(migSdkShareFlag), callback)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgText, "msgText");
        Intrinsics.checkNotNullParameter(targetUin, "targetUin");
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "forwardText msgText: " + msgText + " , targetUin: " + targetUin);
        if (TextUtils.isEmpty(msgText)) {
            if (callback != 0 && (callback instanceof a.c)) {
                ((a.c) callback).e();
                return 32;
            }
            return 32;
        }
        if (msgText.length() > 3478) {
            if (callback != 0 && (callback instanceof a.c)) {
                ((a.c) callback).f();
                return 64;
            }
            return 64;
        }
        String str = c(targetUin).f178172i0;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 8;
        }
        if (migSdkShareFlag) {
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.e("qqdataline", 2, "sendTextMessage shareFromMigSdk|report send one from sdk:0X800492D.");
            }
        }
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "forwardText sessionInfo: " + c(targetUin));
        SessionInfo c16 = c(targetUin);
        if (c16 != null) {
            IMsgSendHelper iMsgSendHelper = (IMsgSendHelper) QRoute.api(IMsgSendHelper.class);
            String str2 = c16.f178172i0;
            Intrinsics.checkNotNullExpressionValue(str2, "it.uid");
            iMsgSendHelper.sendText(str2, com.tencent.nt.adapter.session.c.l(c16.f179555d), msgText);
        }
        return 0;
    }

    @NotNull
    public final HashMap<String, Integer> i(@NotNull String devicePeerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HashMap) iPatchRedirector.redirect((short) 7, (Object) this, (Object) devicePeerUid);
        }
        Intrinsics.checkNotNullParameter(devicePeerUid, "devicePeerUid");
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (Intrinsics.areEqual(PeerUid.DATALINE_PC_UID, devicePeerUid)) {
            String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
            Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
            hashMap.put(DATALINE_PC_UIN, 6000);
        } else if (Intrinsics.areEqual(PeerUid.DATALINE_PAD_UID, devicePeerUid)) {
            String DATALINE_IPAD_UIN = AppConstants.DATALINE_IPAD_UIN;
            Intrinsics.checkNotNullExpressionValue(DATALINE_IPAD_UIN, "DATALINE_IPAD_UIN");
            hashMap.put(DATALINE_IPAD_UIN, 6003);
        } else {
            String DATALINE_PHONE_UIN = AppConstants.DATALINE_PHONE_UIN;
            Intrinsics.checkNotNullExpressionValue(DATALINE_PHONE_UIN, "DATALINE_PHONE_UIN");
            hashMap.put(DATALINE_PHONE_UIN, 6005);
        }
        return hashMap;
    }

    public final <T> int j(@NotNull final ArrayList<String> items, T callback, @NotNull final SessionInfo sessionInfo, final int forwardFileType) {
        final QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, items, callback, sessionInfo, Integer.valueOf(forwardFileType))).intValue();
        }
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return 268;
        }
        long g16 = g(items);
        if (g16 == 0) {
            if (callback != 0 && (callback instanceof a.c)) {
                ((a.c) callback).d();
                return 128;
            }
            return 128;
        }
        if (NetworkUtil.isNetworkAvailable(qQAppInterface.getApp()) && !NetworkUtil.isWifiConnected(qQAppInterface.getApp()) && g16 > 3145728) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "netWork is not work or FMConstants.FIVE_MB");
            if (callback != 0 && (callback instanceof a.c)) {
                ((a.c) callback).a(0, new Runnable() { // from class: com.tencent.qqnt.mycomputer.utils.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.m(items, sessionInfo, forwardFileType, qQAppInterface);
                    }
                });
            }
            return 512;
        }
        return k(items, sessionInfo, forwardFileType, qQAppInterface);
    }
}
