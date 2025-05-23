package com.tencent.mobileqq.filemanager.flashtransfer.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.flashtransfer.forward.ForwardFlashTransferOption;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.q;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferMsgTarget;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferSendMsgReq;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferSendMsgRsp;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferSendMsgCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/filemanager/flashtransfer/forward/ForwardFlashTransferOption;", "Lcom/tencent/mobileqq/forward/ForwardBaseOption;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferMsgTarget;", "Lkotlin/collections/ArrayList;", "targets", "", "fileSetId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "realForwardTo", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUser", "allowRecentUser", "", "getEditTextType", "getDialogContent", "Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Intent;)V", "d", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ForwardFlashTransferOption extends ForwardBaseOption {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardFlashTransferOption(Intent intent) {
        super(intent);
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    private final void m(ArrayList<FlashTransferMsgTarget> targets, String fileSetId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IKernelService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026ava, ProcessConstant.ALL)");
        FlashTransferSendMsgReq flashTransferSendMsgReq = new FlashTransferSendMsgReq();
        flashTransferSendMsgReq.targets = targets;
        flashTransferSendMsgReq.fileSetId = fileSetId;
        q flashTransferService = ((IKernelService) runtimeService).getFlashTransferService();
        if (flashTransferService != null) {
            flashTransferService.sendFlashTransferMsg(flashTransferSendMsgReq, new IFlashTransferSendMsgCallback() { // from class: gc1.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferSendMsgCallback
                public final void onResult(int i3, String str, FlashTransferSendMsgRsp flashTransferSendMsgRsp) {
                    ForwardFlashTransferOption.n(i3, str, flashTransferSendMsgRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(int i3, String str, FlashTransferSendMsgRsp flashTransferSendMsgRsp) {
        QLog.d("ForwardFlashTransferOption", 1, "sendFlashTransferMsg code: " + i3 + " msg: " + str);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean allowRecentUser(RecentUser recentUser) {
        Intrinsics.checkNotNullParameter(recentUser, "recentUser");
        int type = recentUser.getType();
        return type == 0 || type == 1;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getDialogContent() {
        String string;
        Bundle bundle = this.mExtraData;
        return (bundle == null || (string = bundle.getString("flash_transfer_file_set_title")) == null) ? "[\u95ea\u4f20\u6d88\u606f]" : string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public int getEditTextType() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        String str;
        String string;
        Bundle bundle = this.mExtraData;
        String str2 = "";
        if (bundle == null || (str = bundle.getString("flash_transfer_file_set_id")) == null) {
            str = "";
        }
        ArrayList<FlashTransferMsgTarget> arrayList = new ArrayList<>();
        if (isMultiTarget2Send()) {
            for (ResultRecord resultRecord : getMultiTargetWithoutDataLine()) {
                if (resultRecord != null) {
                    FlashTransferMsgTarget flashTransferMsgTarget = new FlashTransferMsgTarget();
                    int i3 = resultRecord.uinType;
                    if (i3 == 0) {
                        flashTransferMsgTarget.destType = 1;
                        String str3 = resultRecord.uid;
                        if (str3 == null) {
                            str3 = "";
                        }
                        flashTransferMsgTarget.destUid = str3;
                    } else if (i3 == 1) {
                        flashTransferMsgTarget.destType = 2;
                        String str4 = resultRecord.groupUin;
                        if (str4 == null) {
                            str4 = "";
                        }
                        flashTransferMsgTarget.destUid = str4;
                    }
                    String str5 = flashTransferMsgTarget.destUid;
                    Intrinsics.checkNotNullExpressionValue(str5, "target.destUid");
                    if ((str5.length() > 0) && flashTransferMsgTarget.destType != 0) {
                        arrayList.add(flashTransferMsgTarget);
                    }
                }
            }
        } else {
            Bundle bundle2 = this.mExtraData;
            int i16 = bundle2 != null ? bundle2.getInt("uintype") : 0;
            Bundle bundle3 = this.mExtraData;
            if (bundle3 != null && (string = bundle3.getString(AppConstants.Key.UID)) != null) {
                str2 = string;
            }
            FlashTransferMsgTarget flashTransferMsgTarget2 = new FlashTransferMsgTarget();
            if (i16 == 0) {
                flashTransferMsgTarget2.destType = 1;
                flashTransferMsgTarget2.destUid = str2;
            } else if (i16 == 1) {
                flashTransferMsgTarget2.destType = 2;
                flashTransferMsgTarget2.destUid = str2;
            }
            String str6 = flashTransferMsgTarget2.destUid;
            Intrinsics.checkNotNullExpressionValue(str6, "target.destUid");
            if ((str6.length() > 0) && flashTransferMsgTarget2.destType != 0) {
                arrayList.add(flashTransferMsgTarget2);
            }
        }
        m(arrayList, str);
        return super.realForwardTo();
    }
}
