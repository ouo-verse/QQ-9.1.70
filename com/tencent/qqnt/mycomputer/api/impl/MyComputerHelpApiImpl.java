package com.tencent.qqnt.mycomputer.api.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import com.tencent.qqnt.aio.mycomputer.sectionbar.processor.a;
import com.tencent.qqnt.camera.api.ICameraAPI;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import com.tencent.qqnt.mycomputer.utils.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0016J-\u0010\u0017\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0019\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0018J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000eH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000eH\u0016R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/mycomputer/api/impl/MyComputerHelpApiImpl;", "Lcom/tencent/qqnt/mycomputer/api/IMyComputerHelpApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "devicePeerUid", "deviceNick", "", "myComputerOpenCamera", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "myComputerOpenFileSelector", "filePath", "myComputerSendFileFromPhoto", "", "filePathList", "myComputerSendMultiFileFromPhoto", "T", IProfileProtocolConst.PARAM_TARGET_UIN, "Landroid/os/Bundle;", "bundle", "callback", "", "singleForwardToMyComputer", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Object;)I", "multipleForwardToMyComputer", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "getExtSectionBarAdapters", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "getExtSectionBarProcessors", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MyComputerHelpApiImpl implements IMyComputerHelpApi {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String TAG;

    public MyComputerHelpApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "MyComputerHelpApiImpl";
        }
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    @NotNull
    public List<b> getExtSectionBarAdapters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.qqnt.mycomputer.sectionbar.adapter.b());
        return arrayList;
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    @NotNull
    public List<BottomSectionBarBaseProcessor> getExtSectionBarProcessors() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a());
        return arrayList;
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public <T> int multipleForwardToMyComputer(@NotNull String targetUin, @NotNull Bundle bundle, T callback) {
        Integer num;
        Integer num2;
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, targetUin, bundle, callback)).intValue();
        }
        Intrinsics.checkNotNullParameter(targetUin, "targetUin");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        com.tencent.xaction.log.b.a(AppConstants.NEW_MY_COMPUTER, 1, "multipleForwardToMyComputer: " + bundle);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            com.tencent.xaction.log.b.a(AppConstants.NEW_MY_COMPUTER, 1, "multipleForwardToMyComputer FORWARD_ERR_NO_NET");
            return 9;
        }
        int i3 = bundle.getInt("dataline_forward_type", -1);
        ArrayList<String> stringArrayList = bundle.getStringArrayList("dataline_forward_pathlist");
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("fileinfo_array");
        boolean z17 = bundle.getBoolean("isMigSdkShare", false);
        if (stringArrayList != null) {
            num = Integer.valueOf(stringArrayList.size());
        } else {
            num = null;
        }
        if (parcelableArrayList != null) {
            num2 = Integer.valueOf(parcelableArrayList.size());
        } else {
            num2 = null;
        }
        com.tencent.xaction.log.b.a(AppConstants.NEW_MY_COMPUTER, 1, "multipleForwardToMyComputer forwardType: " + i3 + ", filePaths.size: " + num + ", forwardFileInfoObj.size: " + num2 + ", migSdkShareFlag: " + z17);
        String str2 = c.f359781a.c(targetUin).f178172i0;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 8;
        }
        if (stringArrayList == null) {
            if (parcelableArrayList == null) {
                parcelableArrayList = null;
            }
            if (parcelableArrayList == null) {
                return 4;
            }
            Iterator it = parcelableArrayList.iterator();
            boolean z18 = false;
            while (it.hasNext()) {
                ForwardFileInfo forwardFileInfo = (ForwardFileInfo) it.next();
                c cVar = c.f359781a;
                if (cVar.e(bundle, forwardFileInfo, i3, targetUin)) {
                    com.tencent.xaction.log.b.a(AppConstants.NEW_MY_COMPUTER, 1, "multipleForwardToMyComputer forwardOfflineFile");
                } else {
                    if (forwardFileInfo != null) {
                        str = forwardFileInfo.l();
                    } else {
                        str = null;
                    }
                    cVar.d(str, targetUin, z17, callback, 100);
                    com.tencent.xaction.log.b.a(AppConstants.NEW_MY_COMPUTER, 1, "multipleForwardToMyComputer ForwardToMyComputerUtil.forwardFile");
                }
                z18 = true;
            }
            if (z18) {
                return 0;
            }
            return 4;
        }
        Iterator<String> it5 = stringArrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it5, "filePaths.iterator()");
        while (it5.hasNext()) {
            String next = it5.next();
            Intrinsics.checkNotNullExpressionValue(next, "iter.next()");
            if (Intrinsics.areEqual(next, "/")) {
                it5.remove();
            }
        }
        if (!(!stringArrayList.isEmpty())) {
            return 4;
        }
        c cVar2 = c.f359781a;
        if (cVar2.j(stringArrayList, callback, cVar2.c(targetUin), i3) == 0) {
            return 0;
        }
        return 8;
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public void myComputerOpenCamera(@NotNull com.tencent.aio.api.runtime.a context, @NotNull String devicePeerUid, @NotNull String deviceNick) {
        String DATALINE_PHONE_UIN;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, devicePeerUid, deviceNick);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(devicePeerUid, "devicePeerUid");
        Intrinsics.checkNotNullParameter(deviceNick, "deviceNick");
        if (Intrinsics.areEqual(PeerUid.DATALINE_PC_UID, devicePeerUid)) {
            DATALINE_PHONE_UIN = AppConstants.DATALINE_PC_UIN;
            Intrinsics.checkNotNullExpressionValue(DATALINE_PHONE_UIN, "DATALINE_PC_UIN");
            i3 = 6000;
        } else if (Intrinsics.areEqual(PeerUid.DATALINE_PAD_UID, devicePeerUid)) {
            DATALINE_PHONE_UIN = AppConstants.DATALINE_IPAD_UIN;
            Intrinsics.checkNotNullExpressionValue(DATALINE_PHONE_UIN, "DATALINE_IPAD_UIN");
            i3 = 6003;
        } else {
            DATALINE_PHONE_UIN = AppConstants.DATALINE_PHONE_UIN;
            Intrinsics.checkNotNullExpressionValue(DATALINE_PHONE_UIN, "DATALINE_PHONE_UIN");
            i3 = 6005;
        }
        AIOContact aIOContact = new AIOContact(i3, DATALINE_PHONE_UIN, "", deviceNick);
        com.tencent.xaction.log.b.a(this.TAG, 1, "myComputerOpenCamera contact: " + aIOContact);
        ICameraAPI iCameraAPI = (ICameraAPI) QRoute.api(ICameraAPI.class);
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        iCameraAPI.startCameraForOldSessionType(aIOContact, context, requireActivity);
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public void myComputerOpenFileSelector(@NotNull Activity activity, @NotNull String devicePeerUid) {
        String str;
        int i3;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) devicePeerUid);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(devicePeerUid, "devicePeerUid");
        String str3 = AppConstants.INTENT_ACCOUNT_INFO_UPDATE;
        if (Intrinsics.areEqual(PeerUid.DATALINE_PC_UID, devicePeerUid)) {
            str = AppConstants.DATALINE_PC_UIN;
            i3 = 6000;
        } else if (Intrinsics.areEqual(PeerUid.DATALINE_PAD_UID, devicePeerUid)) {
            str = AppConstants.DATALINE_IPAD_UIN;
            i3 = 6003;
        } else {
            str = AppConstants.DATALINE_PHONE_UIN;
            i3 = 6005;
        }
        String str4 = str;
        int i16 = i3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getCurrentUin();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        String str5 = str2;
        com.tencent.xaction.log.b.a(this.TAG, 1, "myComputerOpenFileSelector activity: " + activity + " ,curFriendUin: " + str4 + " ,curType: " + i16 + " ,devicePeerUid: " + devicePeerUid + " ,uin: " + str5);
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileSelectorByMyComputer(activity, i16, str4, devicePeerUid, str5);
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public void myComputerSendFileFromPhoto(@NotNull String devicePeerUid, @NotNull String filePath) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) devicePeerUid, (Object) filePath);
            return;
        }
        Intrinsics.checkNotNullParameter(devicePeerUid, "devicePeerUid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String str2 = AppConstants.INTENT_ACCOUNT_INFO_UPDATE;
        if (Intrinsics.areEqual(PeerUid.DATALINE_PC_UID, devicePeerUid)) {
            str = AppConstants.DATALINE_PC_UIN;
            i3 = 6000;
        } else if (Intrinsics.areEqual(PeerUid.DATALINE_PAD_UID, devicePeerUid)) {
            str = AppConstants.DATALINE_IPAD_UIN;
            i3 = 6003;
        } else {
            str = AppConstants.DATALINE_PHONE_UIN;
            i3 = 6005;
        }
        String str3 = str;
        int i16 = i3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        com.tencent.xaction.log.b.a(this.TAG, 1, "myComputerOpenFileSelector filePath: " + filePath + " ,curFriendUin: " + str3 + " ,curType: " + i16 + " ,devicePeerUid: " + devicePeerUid + " ,uin: " + qQAppInterface.getCurrentAccountUin());
        qQAppInterface.getFileManagerEngine().H0(filePath, qQAppInterface.getCurrentAccountUin(), str3, devicePeerUid, i16, true, 0L, 0, null);
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public void myComputerSendMultiFileFromPhoto(@NotNull String devicePeerUid, @NotNull List<String> filePathList) {
        String str;
        int i3;
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) devicePeerUid, (Object) filePathList);
            return;
        }
        Intrinsics.checkNotNullParameter(devicePeerUid, "devicePeerUid");
        Intrinsics.checkNotNullParameter(filePathList, "filePathList");
        String str2 = AppConstants.INTENT_ACCOUNT_INFO_UPDATE;
        if (Intrinsics.areEqual(PeerUid.DATALINE_PC_UID, devicePeerUid)) {
            str = AppConstants.DATALINE_PC_UIN;
            i3 = 6000;
        } else if (Intrinsics.areEqual(PeerUid.DATALINE_PAD_UID, devicePeerUid)) {
            str = AppConstants.DATALINE_IPAD_UIN;
            i3 = 6003;
        } else {
            str = AppConstants.DATALINE_PHONE_UIN;
            i3 = 6005;
        }
        String str3 = str;
        int i16 = i3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            com.tencent.xaction.log.b.a(this.TAG, 1, "app = null");
            return;
        }
        com.tencent.xaction.log.b.a(this.TAG, 1, "myComputerOpenFileSelector filePathList: " + filePathList + " ,curFriendUin: " + str3 + " ,curType: " + i16 + " ,devicePeerUid: " + devicePeerUid + " ,uin: " + qQAppInterface.getCurrentAccountUin());
        qQAppInterface.getFileManagerEngine().a(filePathList, qQAppInterface.getCurrentAccountUin(), str3, devicePeerUid, i16, true, 0L, 0, null);
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public <T> int singleForwardToMyComputer(@NotNull String targetUin, @NotNull Bundle bundle, T callback) {
        ForwardFileInfo forwardFileInfo;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, targetUin, bundle, callback)).intValue();
        }
        Intrinsics.checkNotNullParameter(targetUin, "targetUin");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        com.tencent.xaction.log.b.a(AppConstants.NEW_MY_COMPUTER, 1, "singleForwardToMyComputer: " + bundle);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            com.tencent.xaction.log.b.a(AppConstants.NEW_MY_COMPUTER, 1, "singleForwardToMyComputer FORWARD_ERR_NO_NET");
            return 9;
        }
        int i3 = bundle.getInt("dataline_forward_type", -1);
        String string = bundle.getString("dataline_forward_path", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(DataLin\u2026nstants.FORWARD_PATH, \"\")");
        String string2 = bundle.getString("dataline_forward_text", "");
        Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(DataLin\u2026nstants.FORWARD_TEXT, \"\")");
        boolean z16 = bundle.getBoolean("isMigSdkShare", false);
        int i16 = bundle.getInt("KEY_MSG_FORWARD_ID", 0);
        Parcelable parcelable = bundle.getParcelable("fileinfo");
        if (parcelable instanceof ForwardFileInfo) {
            forwardFileInfo = (ForwardFileInfo) parcelable;
        } else {
            forwardFileInfo = null;
        }
        String string3 = bundle.getString(AppConstants.Key.FORWARD_FILEPATH, "");
        Intrinsics.checkNotNullExpressionValue(string3, "bundle.getString(AppCons\u2026Key.FORWARD_FILEPATH, \"\")");
        com.tencent.xaction.log.b.a(AppConstants.NEW_MY_COMPUTER, 1, "singleForwardToMyComputer forwardType: " + i3 + ", path: " + string + ", textMsg: " + string2 + ", migSdkShareFlag: " + z16 + ", forwardID: " + i16 + ", forwardFilePath: " + string3 + ", forwardFileInfo: " + forwardFileInfo);
        if (i3 == -1) {
            return 2;
        }
        if (forwardFileInfo != null) {
            forwardFileInfo.L = i16;
        }
        c cVar = c.f359781a;
        if (cVar.e(bundle, forwardFileInfo, i3, targetUin)) {
            com.tencent.xaction.log.b.a(AppConstants.NEW_MY_COMPUTER, 1, "singleForwardToMyComputer forwardOfflineFile");
            return 0;
        }
        com.tencent.xaction.log.b.a(AppConstants.NEW_MY_COMPUTER, 1, "singleForwardToMyComputer old realFilePath is " + string);
        if (bundle.getBoolean("filepath_copy", false)) {
            str = QFileUtils.j(string);
            Intrinsics.checkNotNullExpressionValue(str, "copyFileToQFileFolder(path)");
        } else {
            str = string;
        }
        com.tencent.xaction.log.b.a(AppConstants.NEW_MY_COMPUTER, 1, "singleForwardToMyComputer new realFilePath is " + str);
        switch (i3) {
            case 100:
                return cVar.d(str, targetUin, z16, callback, 100);
            case 101:
                return cVar.d(str, targetUin, z16, callback, 101);
            case 102:
                return cVar.f(string2, targetUin, z16, callback);
            default:
                return 4;
        }
    }
}
