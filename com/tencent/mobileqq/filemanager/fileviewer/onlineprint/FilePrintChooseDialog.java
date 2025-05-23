package com.tencent.mobileqq.filemanager.fileviewer.onlineprint;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItem;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cloud_print.cloud_print$C2COfflineFileReqParams;
import tencent.im.oidb.cloud_print.cloud_print$GetFileDownloadKeyReq;
import tencent.im.oidb.cloud_print.cloud_print$GetFileDownloadKeyRsp;
import tencent.im.oidb.cloud_print.cloud_print$GroupFileReqParams;
import tencent.im.oidb.cloud_print.cloud_print$QQFileDownloadReqParams;
import tencent.im.oidb.cloud_print.cloud_print$QQMiniProgramInfo;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\b>\u0010?B1\b\u0016\u0012\u0006\u0010@\u001a\u00020&\u0012\u0006\u0010A\u001a\u00020*\u0012\u0006\u0010B\u001a\u00020.\u0012\u0006\u0010C\u001a\u000202\u0012\u0006\u0010D\u001a\u000206\u00a2\u0006\u0004\b>\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J&\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u0010%\u001a\u00020$2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/onlineprint/FilePrintChooseDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View;", OcrConfig.CHINESE, "Lcom/tencent/mobileqq/widget/listitem/Group;", "Ih", "Lcom/tencent/mobileqq/widget/listitem/c;", "Lcom/tencent/mobileqq/widget/listitem/c$a$d;", "Lcom/tencent/mobileqq/widget/listitem/c$b$c;", "Dh", "Lcom/tencent/mobileqq/filemanager/fileviewer/onlineprint/f;", "Ah", "", "Jh", "Oh", "Nh", "Ltencent/im/oidb/cloud_print/cloud_print$GetFileDownloadKeyReq;", "req", "Gh", "Mh", "", "fcpdKeyName", "fcpdKeyValue", "Lh", WadlProxyConsts.PARAM_FILENAME, "Hh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/app/Activity;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "D", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "Lcom/tencent/mobileqq/filemanager/fileviewer/onlineprint/g;", "E", "Lcom/tencent/mobileqq/filemanager/fileviewer/onlineprint/g;", "bean", "Landroid/view/View$OnClickListener;", UserInfo.SEX_FEMALE, "Landroid/view/View$OnClickListener;", "sysPrintListener", "", "G", "Z", "isDisabledOnlinePrint", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "H", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "<init>", "()V", "activityTmp", "entityTmp", "beanTmp", "sysPrintListenerTmp", "isDisabledOnlinePrintTmp", "(Landroid/app/Activity;Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;Lcom/tencent/mobileqq/filemanager/fileviewer/onlineprint/g;Landroid/view/View$OnClickListener;Z)V", "I", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FilePrintChooseDialog extends ReportAndroidXDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private Activity activity;

    /* renamed from: D, reason: from kotlin metadata */
    private FileManagerEntity entity;

    /* renamed from: E, reason: from kotlin metadata */
    private g bean;

    /* renamed from: F, reason: from kotlin metadata */
    private View.OnClickListener sysPrintListener;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isDisabledOnlinePrint;

    /* renamed from: H, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView floatingView;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/filemanager/fileviewer/onlineprint/FilePrintChooseDialog$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {
        b() {
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            cloud_print$GetFileDownloadKeyRsp cloud_print_getfiledownloadkeyrsp = new cloud_print$GetFileDownloadKeyRsp();
            if (errorCode == 0 && data != null) {
                try {
                    cloud_print_getfiledownloadkeyrsp.mergeFrom(data);
                    FilePrintChooseDialog filePrintChooseDialog = FilePrintChooseDialog.this;
                    String str = cloud_print_getfiledownloadkeyrsp.key_info.key_name.get();
                    Intrinsics.checkNotNullExpressionValue(str, "rspBody.key_info.key_name.get()");
                    String str2 = cloud_print_getfiledownloadkeyrsp.key_info.key_content.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "rspBody.key_info.key_content.get()");
                    filePrintChooseDialog.Lh(str, str2);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("FilePrintChooseDialog", 1, QLog.getStackTraceString(e16));
                }
            }
            QLog.d("FilePrintChooseDialog", 1, "doRequest errorCode: " + errorCode + ", key_name:" + cloud_print_getfiledownloadkeyrsp.key_info.key_name.get() + ", key_content:" + cloud_print_getfiledownloadkeyrsp.key_info.key_content.get());
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/filemanager/fileviewer/onlineprint/FilePrintChooseDialog$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF52508d() {
            return FilePrintChooseDialog.this.zh();
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int maxHeight() {
            boolean z16;
            float f16;
            Activity activity;
            IPrintApi iPrintApi = (IPrintApi) QRoute.api(IPrintApi.class);
            FileManagerEntity fileManagerEntity = FilePrintChooseDialog.this.entity;
            Activity activity2 = null;
            if (fileManagerEntity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
                fileManagerEntity = null;
            }
            String str = fileManagerEntity.fileName;
            FileManagerEntity fileManagerEntity2 = FilePrintChooseDialog.this.entity;
            if (fileManagerEntity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
                fileManagerEntity2 = null;
            }
            if (fileManagerEntity2.TroopUin != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (iPrintApi.isSupportSysPrint(str, z16)) {
                IPrintApi iPrintApi2 = (IPrintApi) QRoute.api(IPrintApi.class);
                FileManagerEntity fileManagerEntity3 = FilePrintChooseDialog.this.entity;
                if (fileManagerEntity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                    fileManagerEntity3 = null;
                }
                if (iPrintApi2.isSupportOnlinePrint(fileManagerEntity3.fileName, FilePrintChooseDialog.this.isDisabledOnlinePrint)) {
                    f16 = 255.0f;
                    activity = FilePrintChooseDialog.this.activity;
                    if (activity != null) {
                        Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    } else {
                        activity2 = activity;
                    }
                    return Utils.n(f16, activity2.getResources());
                }
            }
            f16 = 183.0f;
            activity = FilePrintChooseDialog.this.activity;
            if (activity != null) {
            }
            return Utils.n(f16, activity2.getResources());
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    public FilePrintChooseDialog() {
    }

    private final f Ah() {
        f fVar = new f();
        fVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.fileviewer.onlineprint.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilePrintChooseDialog.Bh(FilePrintChooseDialog.this, view);
            }
        });
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(final FilePrintChooseDialog this$0, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        Activity activity2 = null;
        if (StudyModeManager.t()) {
            Activity activity3 = this$0.activity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            } else {
                activity2 = activity3;
            }
            QQToast.makeText(activity2, R.string.f167672dk, 0).show();
        } else {
            h hVar = h.f208453a;
            g gVar = this$0.bean;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bean");
                gVar = null;
            }
            if (!hVar.d(gVar.getServiceProvider())) {
                this$0.Jh();
            } else {
                g gVar2 = this$0.bean;
                if (gVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bean");
                    gVar2 = null;
                }
                hVar.a(gVar2.getServiceProvider());
                Activity activity4 = this$0.activity;
                if (activity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    activity = null;
                } else {
                    activity = activity4;
                }
                Activity activity5 = this$0.activity;
                if (activity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    activity5 = null;
                }
                String string = activity5.getString(R.string.f174982xb);
                Activity activity6 = this$0.activity;
                if (activity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    activity6 = null;
                }
                Object[] objArr = new Object[1];
                g gVar3 = this$0.bean;
                if (gVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bean");
                    gVar3 = null;
                }
                objArr[0] = gVar3.getServiceProvider();
                String string2 = activity6.getString(R.string.f174972xa, objArr);
                Activity activity7 = this$0.activity;
                if (activity7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                } else {
                    activity2 = activity7;
                }
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, string, string2, (String) null, activity2.getString(R.string.f185803pk), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.fileviewer.onlineprint.e
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        FilePrintChooseDialog.Ch(FilePrintChooseDialog.this, dialogInterface, i3);
                    }
                }, (DialogInterface.OnClickListener) null);
                Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026   null\n                )");
                createCustomDialog.show();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(FilePrintChooseDialog this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Jh();
        dialogInterface.dismiss();
    }

    private final com.tencent.mobileqq.widget.listitem.c<c.a.d, c.b.C8995c> Dh() {
        Activity activity = this.activity;
        Activity activity2 = null;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        }
        String string = activity.getString(R.string.f175012xe);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.print_way_sys)");
        Activity activity3 = this.activity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        } else {
            activity2 = activity3;
        }
        String string2 = activity2.getString(R.string.f175022xf);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.string.print_way_sys_desc)");
        com.tencent.mobileqq.widget.listitem.c<c.a.d, c.b.C8995c> cVar = new com.tencent.mobileqq.widget.listitem.c<>(new c.a.d(string, string2, ""), new c.b.C8995c("", false, false, 4, null));
        cVar.R(new Function2<ImageView, String, Unit>() { // from class: com.tencent.mobileqq.filemanager.fileviewer.onlineprint.FilePrintChooseDialog$createSysPrintConfig$1$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView view, @NotNull String str) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                view.setScaleType(ImageView.ScaleType.CENTER);
                view.setImageResource(R.drawable.qui_printer);
                view.setBackgroundResource(R.drawable.kqd);
            }
        });
        cVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.fileviewer.onlineprint.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilePrintChooseDialog.Eh(FilePrintChooseDialog.this, view);
            }
        });
        cVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.filemanager.fileviewer.onlineprint.d
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                FilePrintChooseDialog.Fh(view);
            }
        });
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(FilePrintChooseDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        View.OnClickListener onClickListener = this$0.sysPrintListener;
        if (onClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sysPrintListener");
            onClickListener = null;
        }
        onClickListener.onClick(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof QUIListItem) {
            ((QUIListItem) view).setBackgroundType(QUIListItemBackgroundType.NoneRound);
        }
    }

    private final void Gh(cloud_print$GetFileDownloadKeyReq req) {
        cloud_print$QQMiniProgramInfo cloud_print_qqminiprograminfo = new cloud_print$QQMiniProgramInfo();
        PBStringField pBStringField = cloud_print_qqminiprograminfo.qqmini_appid;
        g gVar = this.bean;
        g gVar2 = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bean");
            gVar = null;
        }
        pBStringField.set(gVar.getMiniAppID());
        PBStringField pBStringField2 = cloud_print_qqminiprograminfo.qqmini_name;
        g gVar3 = this.bean;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bean");
        } else {
            gVar2 = gVar3;
        }
        pBStringField2.set(gVar2.getCom.tencent.mobileqq.activity.miniaio.MiniChatConstants.MINI_APP_NAME java.lang.String());
        req.mini_program_info.set(cloud_print_qqminiprograminfo);
        ProtoUtils.a(MobileQQ.sMobileQQ.peekAppRuntime(), new b(), req.toByteArray(), "OidbSvcTrpcTcp.0x90f0_1", 37104, 1);
    }

    private final String Hh(String fileName) {
        String replace$default;
        String j3 = q.j(fileName);
        Intrinsics.checkNotNullExpressionValue(j3, "getExtension(fileName)");
        replace$default = StringsKt__StringsJVMKt.replace$default(j3, ".", "", false, 4, (Object) null);
        return replace$default;
    }

    private final Group Ih() {
        boolean z16;
        IPrintApi iPrintApi = (IPrintApi) QRoute.api(IPrintApi.class);
        FileManagerEntity fileManagerEntity = this.entity;
        FileManagerEntity fileManagerEntity2 = null;
        if (fileManagerEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity = null;
        }
        String str = fileManagerEntity.fileName;
        FileManagerEntity fileManagerEntity3 = this.entity;
        if (fileManagerEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity3 = null;
        }
        if (fileManagerEntity3.TroopUin != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isSupportSysPrint = iPrintApi.isSupportSysPrint(str, z16);
        IPrintApi iPrintApi2 = (IPrintApi) QRoute.api(IPrintApi.class);
        FileManagerEntity fileManagerEntity4 = this.entity;
        if (fileManagerEntity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        } else {
            fileManagerEntity2 = fileManagerEntity4;
        }
        boolean isSupportOnlinePrint = iPrintApi2.isSupportOnlinePrint(fileManagerEntity2.fileName, this.isDisabledOnlinePrint);
        if (isSupportSysPrint && isSupportOnlinePrint) {
            return new Group(Dh(), Ah());
        }
        if (isSupportSysPrint) {
            return new Group(Dh());
        }
        return new Group(Ah());
    }

    private final void Jh() {
        FileManagerEntity fileManagerEntity = this.entity;
        FileManagerEntity fileManagerEntity2 = null;
        if (fileManagerEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity = null;
        }
        int i3 = fileManagerEntity.cloudType;
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 15 && i3 != 16) {
                        FileManagerEntity fileManagerEntity3 = this.entity;
                        if (fileManagerEntity3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("entity");
                        } else {
                            fileManagerEntity2 = fileManagerEntity3;
                        }
                        QLog.d("FilePrintChooseDialog", 1, "handlePrint unSupport file type " + fileManagerEntity2.cloudType);
                        return;
                    }
                } else {
                    Oh();
                    return;
                }
            }
            Mh();
            return;
        }
        Nh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(FilePrintChooseDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(String fcpdKeyName, String fcpdKeyValue) {
        Activity activity;
        g gVar = this.bean;
        g gVar2 = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bean");
            gVar = null;
        }
        StringBuilder sb5 = new StringBuilder(gVar.getMiniAppPath());
        sb5.append("?from=cloud");
        FileManagerEntity fileManagerEntity = this.entity;
        if (fileManagerEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity = null;
        }
        sb5.append("&fileName=" + fileManagerEntity.fileName);
        FileManagerEntity fileManagerEntity2 = this.entity;
        if (fileManagerEntity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity2 = null;
        }
        String str = fileManagerEntity2.fileName;
        Intrinsics.checkNotNullExpressionValue(str, "entity.fileName");
        sb5.append("&fileFormat=" + Hh(str));
        FileManagerEntity fileManagerEntity3 = this.entity;
        if (fileManagerEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity3 = null;
        }
        sb5.append("&fileSize=" + fileManagerEntity3.fileSize);
        sb5.append("&fcpdKeyName=" + fcpdKeyName);
        sb5.append("&fcpdKeyValue=" + fcpdKeyValue);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(bean.miniA\u2026)\n            .toString()");
        QLog.d("FilePrintChooseDialog", 1, "printCloudFile entryPath: " + sb6);
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        Activity activity2 = this.activity;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        } else {
            activity = activity2;
        }
        g gVar3 = this.bean;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bean");
            gVar3 = null;
        }
        String miniAppID = gVar3.getMiniAppID();
        g gVar4 = this.bean;
        if (gVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bean");
        } else {
            gVar2 = gVar4;
        }
        iMiniAppService.launchMiniAppById(activity, miniAppID, sb6, "", gVar2.getEnVersion(), "", 2300, null);
    }

    private final void Mh() {
        Activity activity;
        g gVar = this.bean;
        FileManagerEntity fileManagerEntity = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bean");
            gVar = null;
        }
        StringBuilder sb5 = new StringBuilder(gVar.getMiniAppPath());
        sb5.append("?from=local");
        FileManagerEntity fileManagerEntity2 = this.entity;
        if (fileManagerEntity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity2 = null;
        }
        sb5.append("&fileName=" + fileManagerEntity2.fileName);
        FileManagerEntity fileManagerEntity3 = this.entity;
        if (fileManagerEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity3 = null;
        }
        String str = fileManagerEntity3.fileName;
        Intrinsics.checkNotNullExpressionValue(str, "entity.fileName");
        sb5.append("&fileFormat=" + Hh(str));
        FileManagerEntity fileManagerEntity4 = this.entity;
        if (fileManagerEntity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity4 = null;
        }
        sb5.append("&fileSize=" + fileManagerEntity4.fileSize);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(bean.miniA\u2026)\n            .toString()");
        QLog.d("FilePrintChooseDialog", 1, "printLocalFile entryPath: " + sb6);
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        Activity activity2 = this.activity;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        } else {
            activity = activity2;
        }
        g gVar2 = this.bean;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bean");
            gVar2 = null;
        }
        String miniAppID = gVar2.getMiniAppID();
        g gVar3 = this.bean;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bean");
            gVar3 = null;
        }
        String enVersion = gVar3.getEnVersion();
        FileManagerEntity fileManagerEntity5 = this.entity;
        if (fileManagerEntity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        } else {
            fileManagerEntity = fileManagerEntity5;
        }
        iMiniAppService.launchMiniAppByIdWithFile(activity, miniAppID, sb6, enVersion, 1173, new File(fileManagerEntity.getFilePath()));
    }

    private final void Nh() {
        FileManagerEntity fileManagerEntity = this.entity;
        FileManagerEntity fileManagerEntity2 = null;
        if (fileManagerEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity = null;
        }
        if (TextUtils.isEmpty(fileManagerEntity.Uuid)) {
            QLog.d("FilePrintChooseDialog", 1, "requestC2CFileDownloadKey empty uuid");
            return;
        }
        FileManagerEntity fileManagerEntity3 = this.entity;
        if (fileManagerEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity3 = null;
        }
        String str = fileManagerEntity3.Uuid;
        FileManagerEntity fileManagerEntity4 = this.entity;
        if (fileManagerEntity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity4 = null;
        }
        String str2 = fileManagerEntity4.fileIdCrc;
        FileManagerEntity fileManagerEntity5 = this.entity;
        if (fileManagerEntity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity5 = null;
        }
        String str3 = fileManagerEntity5.fileName;
        FileManagerEntity fileManagerEntity6 = this.entity;
        if (fileManagerEntity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity6 = null;
        }
        QLog.d("FilePrintChooseDialog", 1, "requestC2CFileDownloadKey downloadReqParamInfo uuid: " + str + ", str_fileidcrc: " + str2 + ", str_file_name: " + str3 + ", msg id: " + fileManagerEntity6.ntMsgId);
        cloud_print$QQFileDownloadReqParams cloud_print_qqfiledownloadreqparams = new cloud_print$QQFileDownloadReqParams();
        cloud_print$C2COfflineFileReqParams cloud_print_c2cofflinefilereqparams = cloud_print_qqfiledownloadreqparams.c2coffline_req_params;
        cloud_print$C2COfflineFileReqParams cloud_print_c2cofflinefilereqparams2 = new cloud_print$C2COfflineFileReqParams();
        PBBytesField pBBytesField = cloud_print_c2cofflinefilereqparams2.bytes_uuid;
        FileManagerEntity fileManagerEntity7 = this.entity;
        if (fileManagerEntity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity7 = null;
        }
        String str4 = fileManagerEntity7.Uuid;
        Intrinsics.checkNotNullExpressionValue(str4, "entity.Uuid");
        byte[] bytes = str4.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        pBBytesField.set(ByteStringMicro.copyFrom(bytes));
        PBStringField pBStringField = cloud_print_c2cofflinefilereqparams2.str_fileidcrc;
        FileManagerEntity fileManagerEntity8 = this.entity;
        if (fileManagerEntity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity8 = null;
        }
        String str5 = fileManagerEntity8.fileIdCrc;
        if (str5 == null) {
            str5 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str5, "entity.fileIdCrc ?: \"\"");
        }
        pBStringField.set(str5);
        PBStringField pBStringField2 = cloud_print_c2cofflinefilereqparams2.str_file_name;
        FileManagerEntity fileManagerEntity9 = this.entity;
        if (fileManagerEntity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        } else {
            fileManagerEntity2 = fileManagerEntity9;
        }
        pBStringField2.set(fileManagerEntity2.fileName);
        cloud_print_c2cofflinefilereqparams.set(cloud_print_c2cofflinefilereqparams2);
        cloud_print$GetFileDownloadKeyReq cloud_print_getfiledownloadkeyreq = new cloud_print$GetFileDownloadKeyReq();
        cloud_print_getfiledownloadkeyreq.file_scene_type.set(1);
        cloud_print_getfiledownloadkeyreq.file_download_req_params.set(cloud_print_qqfiledownloadreqparams);
        try {
            Gh(cloud_print_getfiledownloadkeyreq);
        } catch (Throwable th5) {
            QLog.e("FilePrintChooseDialog", 1, th5, new Object[0]);
        }
    }

    private final void Oh() {
        FileManagerEntity fileManagerEntity = this.entity;
        FileManagerEntity fileManagerEntity2 = null;
        if (fileManagerEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity = null;
        }
        String str = fileManagerEntity.Uuid;
        FileManagerEntity fileManagerEntity3 = this.entity;
        if (fileManagerEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity3 = null;
        }
        String str2 = fileManagerEntity3.peerUin;
        FileManagerEntity fileManagerEntity4 = this.entity;
        if (fileManagerEntity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity4 = null;
        }
        int i3 = fileManagerEntity4.busId;
        FileManagerEntity fileManagerEntity5 = this.entity;
        if (fileManagerEntity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity5 = null;
        }
        String str3 = fileManagerEntity5.fileName;
        FileManagerEntity fileManagerEntity6 = this.entity;
        if (fileManagerEntity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity6 = null;
        }
        QLog.d("FilePrintChooseDialog", 1, "requestGroupFileDownloadKey downloadReqParamInfo str_file_id: " + str + ", uint64_group_code: " + str2 + ", uint32_bus_id: " + i3 + ", str_file_name: " + str3 + ", msg id: " + fileManagerEntity6.ntMsgId);
        cloud_print$QQFileDownloadReqParams cloud_print_qqfiledownloadreqparams = new cloud_print$QQFileDownloadReqParams();
        cloud_print$GroupFileReqParams cloud_print_groupfilereqparams = cloud_print_qqfiledownloadreqparams.group_file_req_params;
        cloud_print$GroupFileReqParams cloud_print_groupfilereqparams2 = new cloud_print$GroupFileReqParams();
        PBUInt64Field pBUInt64Field = cloud_print_groupfilereqparams2.uint64_group_code;
        FileManagerEntity fileManagerEntity7 = this.entity;
        if (fileManagerEntity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity7 = null;
        }
        String str4 = fileManagerEntity7.peerUin;
        Intrinsics.checkNotNullExpressionValue(str4, "entity.peerUin");
        pBUInt64Field.set(Long.parseLong(str4));
        cloud_print_groupfilereqparams2.uint32_app_id.set(3);
        PBUInt32Field pBUInt32Field = cloud_print_groupfilereqparams2.uint32_bus_id;
        FileManagerEntity fileManagerEntity8 = this.entity;
        if (fileManagerEntity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity8 = null;
        }
        pBUInt32Field.set(fileManagerEntity8.busId);
        PBStringField pBStringField = cloud_print_groupfilereqparams2.str_file_id;
        FileManagerEntity fileManagerEntity9 = this.entity;
        if (fileManagerEntity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
            fileManagerEntity9 = null;
        }
        pBStringField.set(fileManagerEntity9.Uuid);
        PBStringField pBStringField2 = cloud_print_groupfilereqparams2.str_file_name;
        FileManagerEntity fileManagerEntity10 = this.entity;
        if (fileManagerEntity10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        } else {
            fileManagerEntity2 = fileManagerEntity10;
        }
        pBStringField2.set(fileManagerEntity2.fileName);
        cloud_print_groupfilereqparams.set(cloud_print_groupfilereqparams2);
        cloud_print$GetFileDownloadKeyReq cloud_print_getfiledownloadkeyreq = new cloud_print$GetFileDownloadKeyReq();
        cloud_print_getfiledownloadkeyreq.file_scene_type.set(2);
        cloud_print_getfiledownloadkeyreq.file_download_req_params.set(cloud_print_qqfiledownloadreqparams);
        try {
            Gh(cloud_print_getfiledownloadkeyreq);
        } catch (Throwable th5) {
            QLog.e("FilePrintChooseDialog", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View zh() {
        View content = getLayoutInflater().inflate(R.layout.fqi, (ViewGroup) null);
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) content.findViewById(R.id.f66393ai);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.FullWidth, false, false, 6, null);
        qUIListItemAdapter.t0(Ih());
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        qUISettingsRecyclerView.setHasTopSpace(false);
        Intrinsics.checkNotNullExpressionValue(content, "content");
        return content;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.floatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.L();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        }
        ReportDialog reportDialog = new ReportDialog(activity, R.style.f173448dl);
        Window window = reportDialog.getWindow();
        if (window == null) {
            return reportDialog;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("FilePrintChooseDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
        window.setGravity(80);
        return reportDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = new QUSHalfScreenFloatingView(activity);
        this.floatingView = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setQUSDragFloatController(new c());
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.filemanager.fileviewer.onlineprint.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                FilePrintChooseDialog.Kh(FilePrintChooseDialog.this);
            }
        });
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, qUSHalfScreenFloatingView);
        return qUSHalfScreenFloatingView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilePrintChooseDialog(@NotNull Activity activityTmp, @NotNull FileManagerEntity entityTmp, @NotNull g beanTmp, @NotNull View.OnClickListener sysPrintListenerTmp, boolean z16) {
        this();
        Intrinsics.checkNotNullParameter(activityTmp, "activityTmp");
        Intrinsics.checkNotNullParameter(entityTmp, "entityTmp");
        Intrinsics.checkNotNullParameter(beanTmp, "beanTmp");
        Intrinsics.checkNotNullParameter(sysPrintListenerTmp, "sysPrintListenerTmp");
        this.activity = activityTmp;
        this.entity = entityTmp;
        this.bean = beanTmp;
        this.sysPrintListener = sysPrintListenerTmp;
        this.isDisabledOnlinePrint = z16;
    }
}
