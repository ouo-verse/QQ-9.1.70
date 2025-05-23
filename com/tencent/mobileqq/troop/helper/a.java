package com.tencent.mobileqq.troop.helper;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.trpc.qqgroup.GroupFace$ClipInfo;
import tencent.trpc.qqgroup.GroupFace$NewGroupFaceInfo;
import tencent.trpc.qqgroup.GroupFace$UploadReq;
import tencent.trpc.qqgroup.GroupFace$UploadRsp;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.helper.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8702a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static a f296259a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28575);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f296259a = new a();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NonNull
    private GroupFace$ClipInfo b(TroopClipPic troopClipPic) {
        GroupFace$ClipInfo groupFace$ClipInfo = new GroupFace$ClipInfo();
        if (troopClipPic != null && !TextUtils.isEmpty(troopClipPic.clipInfo)) {
            String[] split = troopClipPic.clipInfo.split("_");
            if (split.length == 4) {
                groupFace$ClipInfo.left_x.set(Integer.parseInt(split[0]));
                groupFace$ClipInfo.left_y.set(Integer.parseInt(split[1]));
                groupFace$ClipInfo.right_x.set(Integer.parseInt(split[2]));
                groupFace$ClipInfo.right_y.set(Integer.parseInt(split[3]));
            }
        }
        return groupFace$ClipInfo;
    }

    public static a c() {
        return C8702a.f296259a;
    }

    @NonNull
    private GroupFace$NewGroupFaceInfo d(TroopClipPic troopClipPic) {
        GroupFace$NewGroupFaceInfo groupFace$NewGroupFaceInfo = new GroupFace$NewGroupFaceInfo();
        GroupFace$ClipInfo b16 = b(troopClipPic);
        groupFace$NewGroupFaceInfo.sub_cmd.set(((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getSubcmdByType(troopClipPic.type));
        groupFace$NewGroupFaceInfo.clip_info.set(b16);
        return groupFace$NewGroupFaceInfo;
    }

    @Nullable
    private ITransFileController e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("TroopPhotoController.TroopPhotoHelper", 1, "getTransFileController, app == null");
            return null;
        }
        return (ITransFileController) peekAppRuntime.getRuntimeService(ITransFileController.class, "");
    }

    private GroupFace$UploadReq g(TroopClipPic troopClipPic, Bundle bundle) {
        GroupFace$UploadReq groupFace$UploadReq = new GroupFace$UploadReq();
        GroupFace$NewGroupFaceInfo d16 = d(troopClipPic);
        String string = bundle.getString(IProfileProtocolConst.PARAM_TROOP_CODE);
        groupFace$UploadReq.proto_ver.set(101);
        if (!TextUtils.isEmpty(string)) {
            groupFace$UploadReq.group_uin.set(Long.parseLong(string));
        }
        groupFace$UploadReq.img_type.set(3);
        groupFace$UploadReq.is_from_pc.set(0);
        groupFace$UploadReq.info.set(d16);
        return groupFace$UploadReq;
    }

    public void a(AppInterface appInterface, TransProcessorHandler transProcessorHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) transProcessorHandler);
            return;
        }
        ITransFileController e16 = e();
        if (transProcessorHandler == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopPhotoController.TroopPhotoHelper", 2, "addTroopAvatarUploadHandle.transProcessorHandler is null");
                return;
            }
            return;
        }
        transProcessorHandler.addFilter(BDHCommonUploadProcessor.class);
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopPhotoController.TroopPhotoHelper", 2, "addTroopAvatarUploadHandle.mTransFileController is null");
                return;
            }
            return;
        }
        e16.addHandle(transProcessorHandler);
    }

    public TransferRequest f(TroopClipPic troopClipPic, Bundle bundle, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TransferRequest) iPatchRedirector.redirect((short) 5, this, troopClipPic, bundle, str);
        }
        GroupFace$UploadReq g16 = g(troopClipPic, bundle);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mFileType = 24;
        transferRequest.mCommandId = 3000;
        transferRequest.mRichTag = str;
        transferRequest.mExtentionInfo = g16.toByteArray();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = troopClipPic.f203184id;
        transferRequest.mUniseq = System.currentTimeMillis();
        transferRequest.mPeerUin = bundle.getString(IProfileProtocolConst.PARAM_TROOP_CODE);
        return transferRequest;
    }

    public void h(FileMsg fileMsg, GroupFace$UploadRsp groupFace$UploadRsp, TroopUploadingThread.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, fileMsg, groupFace$UploadRsp, bVar);
            return;
        }
        try {
            groupFace$UploadRsp.mergeFrom(fileMsg.bdhExtendInfo);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopPhotoController.TroopPhotoHelper", 2, String.format("mTroopAvatarUploadHandler error=%s", e16.toString()));
            }
        }
        bVar.f294526g = groupFace$UploadRsp.err_msg.get();
        bVar.f294525f = groupFace$UploadRsp.err_code.get();
        bVar.f294522c = groupFace$UploadRsp.seq.get();
    }

    public void i(TroopUploadingThread.b bVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar, (Object) str);
            return;
        }
        if (str.contains("_")) {
            String[] split = str.split("_");
            if (split.length == 2) {
                try {
                    bVar.f294521b = Integer.parseInt(split[1]);
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public void j(TransProcessorHandler transProcessorHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) transProcessorHandler);
            return;
        }
        ITransFileController e16 = e();
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopPhotoController.TroopPhotoHelper", 2, "removeTroopPhotoUploadHandle.mTransFileController is null");
                return;
            }
            return;
        }
        e16.removeHandle(transProcessorHandler);
    }

    public void k(ArrayList<TroopClipPic> arrayList, Bundle bundle, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, arrayList, bundle, str);
            return;
        }
        ITransFileController e16 = e();
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopPhotoController.TroopPhotoHelper", 2, "startUploadPhoto.mTransFileController is null");
                return;
            }
            return;
        }
        int size = arrayList.size();
        if (size == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopPhotoController.TroopPhotoHelper", 2, "startUploadPhoto uploadPaths.size() == 0");
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            TroopClipPic troopClipPic = arrayList.get(i3);
            if (troopClipPic == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopPhotoController.TroopPhotoHelper", 2, "startUploadPhoto troopClipPic is null");
                }
            } else {
                e16.transferAsync(f(troopClipPic, bundle, str));
            }
        }
    }
}
