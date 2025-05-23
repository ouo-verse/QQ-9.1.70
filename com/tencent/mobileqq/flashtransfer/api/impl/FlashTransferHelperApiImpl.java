package com.tencent.mobileqq.flashtransfer.api.impl;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.flashtransfer.forward.ForwardFlashTransferOption;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferHelperApi;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.FileSetStatus;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetShareLinkCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceUpdateFlashTransferCallback;
import com.tencent.qqnt.kernel.nativeinterface.UpdateFlashTransferParam;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\f\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0016J(\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/flashtransfer/api/impl/FlashTransferHelperApiImpl;", "Lcom/tencent/mobileqq/flashtransfer/api/IFlashTransferHelperApi;", "", "fileSetId", "Landroid/content/Context;", "context", "", "deleteFileSet", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "getPathsLinesV2", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "getPathsLinesV3", "shareLink", "title", "uploaderName", "getShareLinkText", "Ljava/lang/Class;", "getForwardOptionClass", "shareFlashTransferMsg", "fileSetName", "", "requestCode", "sendFlashTransferMsgToFriend", "shareFileSetLinkTextToWeChat", "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class FlashTransferHelperApiImpl implements IFlashTransferHelperApi {
    public static final String TAG = "FlashTransferHelperApiImpl";
    public static final String kFileSetIdKey = "kFileSetIdKey";
    public static final String kQQFTFileSetDidDeletedNotification = "kQQFTFileSetDidDeletedNotification";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteFileSet$lambda$8(final String fileSetId, final Context context, DialogInterface dialogInterface, int i3) {
        com.tencent.qqnt.kernel.api.q flashTransferService;
        Intrinsics.checkNotNullParameter(fileSetId, "$fileSetId");
        Intrinsics.checkNotNullParameter(context, "$context");
        dialogInterface.dismiss();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IKernelService iKernelService = peekAppRuntime != null ? (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all") : null;
        UpdateFlashTransferParam updateFlashTransferParam = new UpdateFlashTransferParam();
        updateFlashTransferParam.fileSetId = fileSetId;
        updateFlashTransferParam.status = FileSetStatus.KCANCELLED;
        if (iKernelService == null || (flashTransferService = iKernelService.getFlashTransferService()) == null) {
            return;
        }
        flashTransferService.updateFlashTransfer(0, updateFlashTransferParam, new IFlashTransferServiceUpdateFlashTransferCallback() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.n
            @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceUpdateFlashTransferCallback
            public final void onUpdateFlashTransfer(int i16, int i17, String str) {
                FlashTransferHelperApiImpl.deleteFileSet$lambda$8$lambda$7(context, fileSetId, i16, i17, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteFileSet$lambda$8$lambda$7(final Context context, final String fileSetId, int i3, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(fileSetId, "$fileSetId");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.o
            @Override // java.lang.Runnable
            public final void run() {
                FlashTransferHelperApiImpl.deleteFileSet$lambda$8$lambda$7$lambda$6(context, i16, str, fileSetId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteFileSet$lambda$8$lambda$7$lambda$6(Context context, int i3, String str, String fileSetId) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(fileSetId, "$fileSetId");
        int i16 = i3 == 0 ? 2 : 1;
        if (i3 == 0) {
            str = HardCodeUtil.qqStr(R.string.f1312508);
        }
        QQToast.makeText(context, i16, str, 0).show();
        if (i3 == 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(kFileSetIdKey, fileSetId);
            Unit unit = Unit.INSTANCE;
            com.tencent.kuikly.core.render.android.expand.module.l.e(context, kQQFTFileSetDidDeletedNotification, jSONObject);
        }
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> getPathsLinesV2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
        if (WXShareHelper.b0().e0() && WXShareHelper.b0().f0()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        }
        return arrayList;
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> getPathsLinesV3(Activity activity) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
        return arrayList;
    }

    private final String getShareLinkText(String shareLink, String title, String uploaderName) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(R.string.f131300c);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.flash_transfer_share_link)");
        String format = String.format(qqStr, Arrays.copyOf(new Object[]{uploaderName, title, shareLink}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shareFlashTransferMsg$lambda$4(String fileSetId, final String title, final Activity activity, final FlashTransferHelperApiImpl this$0, final String uploaderName, final ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        com.tencent.qqnt.kernel.api.q flashTransferService;
        Intrinsics.checkNotNullParameter(fileSetId, "$fileSetId");
        Intrinsics.checkNotNullParameter(title, "$title");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uploaderName, "$uploaderName");
        final String str = TAG;
        boolean z16 = true;
        QLog.d(TAG, 1, "do share action: " + actionSheetItem.action);
        int i3 = actionSheetItem.action;
        if (i3 == 72) {
            Intent intent = new Intent();
            intent.putExtra("forward_type", 58);
            intent.putExtra("flash_transfer_file_set_id", fileSetId);
            intent.putExtra("flash_transfer_file_set_title", title);
            intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
            intent.putExtra("key_direct_show_uin_type", actionSheetItem.uinType);
            String str2 = actionSheetItem.uin;
            if (str2 == null) {
                str2 = "";
            }
            intent.putExtra("key_direct_show_uin", str2);
            ForwardBaseOption.startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentTranslucentActivity.class, 103);
        } else if (i3 == 2 || i3 == 73) {
            this$0.sendFlashTransferMsgToFriend(activity, fileSetId, title, 103);
        } else {
            if (i3 == 1 || i3 == 26 || i3 == 9) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                IKernelService iKernelService = peekAppRuntime != null ? (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all") : null;
                if (iKernelService != null && (flashTransferService = iKernelService.getFlashTransferService()) != null) {
                    flashTransferService.getShareLinkReq(fileSetId, new IFlashTransferServiceGetShareLinkCallback() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.p
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetShareLinkCallback
                        public final void onGetShareLink(String str3, long j3, int i16, String str4) {
                            FlashTransferHelperApiImpl.shareFlashTransferMsg$lambda$4$lambda$3(str, this$0, title, uploaderName, actionSheetItem, activity, str3, j3, i16, str4);
                        }
                    });
                }
            } else if (i3 == 40) {
                if (shareActionSheet != null) {
                    shareActionSheet.dismiss();
                }
                this$0.deleteFileSet(fileSetId, activity);
                return;
            }
            z16 = false;
        }
        if (!z16 || shareActionSheet == null) {
            return;
        }
        shareActionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shareFlashTransferMsg$lambda$4$lambda$3(String logTag, FlashTransferHelperApiImpl this$0, String title, String uploaderName, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, final Activity activity, String shareLink, long j3, int i3, String str) {
        Intrinsics.checkNotNullParameter(logTag, "$logTag");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(title, "$title");
        Intrinsics.checkNotNullParameter(uploaderName, "$uploaderName");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QLog.d(logTag, 1, "getShareLinkReq shareLink: " + shareLink + ", expireTimestamp: " + j3 + ", result: " + i3 + ", errMsg: " + str);
        if (i3 == 0) {
            Intrinsics.checkNotNullExpressionValue(shareLink, "shareLink");
            String shareLinkText = this$0.getShareLinkText(shareLink, title, uploaderName);
            int i16 = actionSheetItem.action;
            if (i16 == 1) {
                ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
                ClipData newPlainText = ClipData.newPlainText("label", shareLinkText);
                if (clipboardManager != null) {
                    ClipboardMonitor.setPrimaryClip(clipboardManager, newPlainText);
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlashTransferHelperApiImpl.shareFlashTransferMsg$lambda$4$lambda$3$lambda$0(activity);
                    }
                });
                return;
            }
            if (i16 != 26) {
                if (i16 == 9) {
                    WXShareHelper.b0().H0(shareLinkText, 0, String.valueOf(System.currentTimeMillis()));
                    return;
                }
                return;
            } else {
                com.tencent.qqnt.mycomputer.utils.c cVar = com.tencent.qqnt.mycomputer.utils.c.f359781a;
                String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
                Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
                cVar.f(shareLinkText, DATALINE_PC_UIN, false, null);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlashTransferHelperApiImpl.shareFlashTransferMsg$lambda$4$lambda$3$lambda$1(activity);
                    }
                });
                return;
            }
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        int i17 = actionSheetItem.action;
        if (i17 == 1) {
            intRef.element = R.string.f1312205;
        } else if (i17 == 26) {
            intRef.element = R.string.f131270_;
        } else if (i17 == 9) {
            intRef.element = R.string.f131290b;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.s
            @Override // java.lang.Runnable
            public final void run() {
                FlashTransferHelperApiImpl.shareFlashTransferMsg$lambda$4$lambda$3$lambda$2(activity, intRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shareFlashTransferMsg$lambda$4$lambda$3$lambda$0(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QQToast.makeText(activity, 2, R.string.f1312306, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shareFlashTransferMsg$lambda$4$lambda$3$lambda$1(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QQToast.makeText(activity, 2, R.string.f131280a, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shareFlashTransferMsg$lambda$4$lambda$3$lambda$2(Activity activity, Ref.IntRef msgId) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(msgId, "$msgId");
        QQToast.makeText(activity, 1, msgId.element, 0).show();
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferHelperApi
    public Class<?> getForwardOptionClass() {
        return ForwardFlashTransferOption.class;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferHelperApi
    public void sendFlashTransferMsgToFriend(Activity activity, String fileSetId, String fileSetName, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
        Intrinsics.checkNotNullParameter(fileSetName, "fileSetName");
        Intent intent = new Intent();
        intent.putExtra("forward_type", 58);
        intent.putExtra("flash_transfer_file_set_id", fileSetId);
        intent.putExtra("flash_transfer_file_set_title", fileSetName);
        ForwardBaseOption.startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentActivity.class, requestCode);
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferHelperApi
    public void shareFileSetLinkTextToWeChat(String shareLink, String title, String uploaderName) {
        Intrinsics.checkNotNullParameter(shareLink, "shareLink");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(uploaderName, "uploaderName");
        if (!WXShareHelper.b0().e0()) {
            QQToastUtil.showQQToast(1, R.string.f173257ih1);
        } else if (!WXShareHelper.b0().f0()) {
            QQToastUtil.showQQToast(1, R.string.f173258ih2);
        } else {
            WXShareHelper.b0().H0(getShareLinkText(shareLink, title, uploaderName), 0, String.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferHelperApi
    public void shareFlashTransferMsg(final Activity activity, final String fileSetId, final String title, final String uploaderName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(uploaderName, "uploaderName");
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_flash_transfer");
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        create.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.m
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                FlashTransferHelperApiImpl.shareFlashTransferMsg$lambda$4(fileSetId, title, activity, this, uploaderName, actionSheetItem, shareActionSheet);
            }
        });
        create.setRowVisibility(0, 0, 0);
        Intent intent = new Intent();
        intent.putExtra("forward_type", 58);
        intent.putExtra("flash_transfer_file_set_id", fileSetId);
        intent.putExtra("flash_transfer_file_set_title", title);
        create.setIntentForStartForwardRecentActivity(intent);
        create.setActionSheetItems(getPathsLinesV2(), getPathsLinesV3(activity));
        create.show();
    }

    private final void deleteFileSet(final String fileSetId, final Context context) {
        if (context == null) {
            return;
        }
        DialogUtil.createCustomDialog((Activity) context, 230, HardCodeUtil.qqStr(R.string.f1312609), HardCodeUtil.qqStr(R.string.f1312407), HardCodeUtil.qqStr(R.string.f1311902), HardCodeUtil.qqStr(R.string.f131440q), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FlashTransferHelperApiImpl.deleteFileSet$lambda$8(fileSetId, context, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }).show();
    }
}
