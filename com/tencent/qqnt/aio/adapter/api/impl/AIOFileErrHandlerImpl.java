package com.tencent.qqnt.aio.adapter.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOFileErrHandler;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.smtt.sdk.TbsCommonCode;
import com.tencent.tav.core.ExportErrorStatus;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOFileErrHandlerImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOFileErrHandler;", "", "startListen", "stopListen", "", "path", "getFileNameFromPath", "isDownload", "", "convertState", "svrCode", "convertSvrCodeTipsCode", "convertSvrCodeToUploadCode", "convertSvrCodeToDownloadCode", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "registerFileIdListen", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "info", "onFileErr", "unRegisterFileIdListen", "Ljava/util/concurrent/ConcurrentHashMap;", "listenIds", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOFileErrHandlerImpl implements IAIOFileErrHandler {
    public static final String TAG = "AIOFileErrHandlerImpl";
    private final ConcurrentHashMap<Long, Contact> listenIds = new ConcurrentHashMap<>();

    private final int convertState(boolean isDownload) {
        if (isDownload) {
            return 8;
        }
        return 1;
    }

    private final int convertSvrCodeToDownloadCode(int svrCode) {
        if (svrCode != -302 && svrCode != -301) {
            if (svrCode != -107) {
                if (svrCode != -103) {
                    if (svrCode != -102) {
                        switch (svrCode) {
                            case TbsCommonCode.DOWNLOAD_FLOW_CANCEL /* -134 */:
                                return 302;
                            case ExportErrorStatus.STOP_AUDIO_ENCODE /* -133 */:
                            case ExportErrorStatus.STOP_VIDEO_ENCODE /* -132 */:
                                return 309;
                            default:
                                return svrCode;
                        }
                    }
                }
            }
            return 101;
        }
        return 301;
    }

    private final int convertSvrCodeToUploadCode(int svrCode) {
        if (svrCode < 0) {
            if (svrCode != -25126) {
                if (svrCode == -312 || svrCode == -136) {
                    return -136;
                }
                if (svrCode != -134) {
                    if (svrCode != -107 && svrCode != -102) {
                        if (svrCode != -36) {
                            if (svrCode != -20001 && svrCode != -20000 && svrCode != -403) {
                                if (svrCode != -402) {
                                    if (svrCode == -139 || svrCode == -138) {
                                        return -138;
                                    }
                                    if (svrCode != -2) {
                                        if (svrCode != -1) {
                                            return 207;
                                        }
                                    }
                                } else {
                                    return 704;
                                }
                            } else {
                                return 204;
                            }
                        } else {
                            return 210;
                        }
                    }
                    return 208;
                }
                return 202;
            }
            return 209;
        }
        return svrCode;
    }

    private final String getFileNameFromPath(String path) {
        String name = new File(path).getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        return name;
    }

    private final boolean startListen() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "startListen but app is null");
            return false;
        }
        if (((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService() != null) {
            return true;
        }
        QLog.d(TAG, 1, "startListen but msgService is null");
        return false;
    }

    private final boolean stopListen() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "stopListen but app is null");
            return false;
        }
        if (((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService() != null) {
            return true;
        }
        QLog.d(TAG, 1, "stopListen but msgService is null");
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileErrHandler
    public boolean onFileErr(FileTransNotifyInfo info, boolean isDownload) {
        Intrinsics.checkNotNullParameter(info, "info");
        Contact contact = this.listenIds.get(Long.valueOf(info.msgId));
        Intrinsics.checkNotNull(contact);
        if (contact.chatType != 2) {
            return false;
        }
        String str = info.filePath;
        Intrinsics.checkNotNullExpressionValue(str, "info.filePath");
        TroopFileError.b bVar = new TroopFileError.b(getFileNameFromPath(str), 0L, convertState(isDownload), convertSvrCodeTipsCode((int) info.fileSrvErrCode, isDownload));
        String str2 = info.clientMsg;
        if (!TextUtils.isEmpty(str2)) {
            bVar.f301880e = str2;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        if (TroopFileError.e(bVar, 0L, (QQAppInterface) peekAppRuntime, BaseApplication.context)) {
            return true;
        }
        TroopFileError.l(BaseApplication.context, info.fileErrMsg, 0);
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileErrHandler
    public boolean registerFileIdListen(long msgId, Contact contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        if (this.listenIds.isEmpty()) {
            startListen();
        }
        if (this.listenIds.contains(Long.valueOf(msgId))) {
            return false;
        }
        this.listenIds.put(Long.valueOf(msgId), contact);
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileErrHandler
    public boolean unRegisterFileIdListen(long msgId) {
        Contact remove = this.listenIds.remove(Long.valueOf(msgId));
        if (this.listenIds.isEmpty()) {
            stopListen();
        }
        return remove != null;
    }

    private final int convertSvrCodeTipsCode(int svrCode, boolean isDownload) {
        if (!isDownload) {
            return convertSvrCodeToUploadCode(svrCode);
        }
        return convertSvrCodeToDownloadCode(svrCode);
    }
}
