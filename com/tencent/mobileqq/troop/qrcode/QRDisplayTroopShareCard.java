package com.tencent.mobileqq.troop.qrcode;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.qrcode.util.QRCodeLoadingComponent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopShareApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.qrcode.QRDisplayTroopShareCard;
import com.tencent.mobileqq.troop.qrcode.api.ITroopQRCodeShareApi;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.protofile.source.QunSourceSvrPB$SourceItem;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 [2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0016H\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J \u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J4\u0010!\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010#\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010$\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010%\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J \u0010+\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010)J \u0010-\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\nJ\u0010\u0010.\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)J\u0010\u00100\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u0011J\u000e\u00101\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u00103\u001a\u00020\u0006J(\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u000106J\u0006\u00109\u001a\u00020\u0006J\u0010\u0010<\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010:R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010@R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010@R\u0018\u0010J\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010ER\u0018\u0010M\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010(\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR \u0010X\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\u00060\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopShareCard;", "", "Landroid/view/View;", "shareLayout", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfoData", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/graphics/Bitmap;", "preview", "O", "M", DomainData.DOMAIN_NAME, "", "uinType", "", "uin", "snapshot", "K", "I", "Landroid/app/Activity;", HippyTKDListViewAdapter.X, "Landroid/os/Bundle;", "tailExtBundle", "J", "", "toWeChatCircle", "L", WadlProxyConsts.PARAM_FILENAME, "Lkotlin/Function1;", "callback", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "r", "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent;", CommonConstant.KEY_QR_CODE, "shareLink", "Lcom/tencent/biz/qrcode/mgr/d;", "qrCodeData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, MimeHelper.IMAGE_SUBTYPE_BITMAP, BdhLogUtil.LogTag.Tag_Req, "P", "newTroopName", "U", BdhLogUtil.LogTag.Tag_Conn, "H", "u", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "t", "w", "Lcom/tencent/protofile/source/QunSourceSvrPB$SourceItem;", "source", "T", "a", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "b", "Landroid/view/View;", "c", "qrCodeLayout", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "qrCodeIv", "e", "aigcQRCodeLayout", "f", "aigcCodeImage", "g", "Landroid/graphics/Bitmap;", "snapshotBitmap", tl.h.F, "Ljava/lang/String;", "i", "Lcom/tencent/biz/qrcode/mgr/d;", "j", "Z", "qrCodeGenerated", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "k", "Lkotlin/jvm/functions/Function1;", "wxShareListener", "<init>", "()V", "l", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QRDisplayTroopShareCard {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopInfoData troopInfoData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View shareLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View qrCodeLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView qrCodeIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View aigcQRCodeLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView aigcCodeImage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap snapshotBitmap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String shareLink;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qrcode.mgr.d qrCodeData;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean qrCodeGenerated;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<BaseResp, Unit> wxShareListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopShareCard$a;", "", "", "CODE_SHARE_TO_QZONE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopShareCard$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/qrcode/QRDisplayTroopShareCard$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f298152b;

        b(QBaseActivity qBaseActivity) {
            this.f298152b = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRDisplayTroopShareCard.this, (Object) qBaseActivity);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QRDisplayTroopShareCard this$0, QBaseActivity activity) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            this$0.z(activity);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            final QRDisplayTroopShareCard qRDisplayTroopShareCard = QRDisplayTroopShareCard.this;
            final QBaseActivity qBaseActivity = this.f298152b;
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.ab
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayTroopShareCard.b.b(QRDisplayTroopShareCard.this, qBaseActivity);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
            } else {
                super.onDenied(permissions, results);
                QLog.i("QRDisplayTroopShareCard", 1, "saveSnapshot, request permission denied");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62196);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QRDisplayTroopShareCard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.wxShareListener = QRDisplayTroopShareCard$wxShareListener$1.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A() {
        com.tencent.biz.qrcode.util.h.T(1, R.string.f224046hv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void B(Ref.BooleanRef isSuccess, QBaseActivity activity, Ref.ObjectRef insertUri) {
        Intrinsics.checkNotNullParameter(isSuccess, "$isSuccess");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(insertUri, "$insertUri");
        if (isSuccess.element) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData((Uri) insertUri.element);
            activity.sendBroadcast(intent);
            com.tencent.biz.qrcode.util.h.T(2, R.string.cwj);
            return;
        }
        com.tencent.biz.qrcode.util.h.T(1, R.string.f216945zo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(QRDisplayTroopShareCard this$0, QBaseActivity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.z(activity);
    }

    private final void E(final Activity activity, final String fileName, final Bitmap snapshot, final Function1<? super String, Unit> callback) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.z
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayTroopShareCard.F(activity, fileName, snapshot, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Activity activity, String fileName, Bitmap snapshot, final Function1 callback) {
        final String str = "";
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(fileName, "$fileName");
        Intrinsics.checkNotNullParameter(snapshot, "$snapshot");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        try {
            String P = com.tencent.biz.qrcode.util.h.P(activity, fileName, snapshot);
            if (P != null) {
                str = P;
            }
        } catch (Throwable th5) {
            QLog.e("QRDisplayTroopShareCard", 1, "saveTmpFile failed, e=" + th5.getMessage());
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.aa
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayTroopShareCard.G(Function1.this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Function1 callback, String filePath) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        callback.invoke(filePath);
    }

    private final void I(final QBaseActivity activity, Bitmap snapshot) {
        String str;
        TroopInfoData troopInfoData = this.troopInfoData;
        if (troopInfoData != null) {
            str = troopInfoData.troopUin;
        } else {
            str = null;
        }
        E(activity, "temp_qrcode_share_" + str + ".png", snapshot, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopShareCard$shareToFriends$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QBaseActivity.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String filePath) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) filePath);
                    return;
                }
                Intrinsics.checkNotNullParameter(filePath, "filePath");
                if (filePath.length() == 0) {
                    QLog.e("QRDisplayTroopShareCard", 1, "shareToFriends failed, path empty");
                    com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("forward_type", 1);
                bundle.putString(AppConstants.Key.FORWARD_FILEPATH, filePath);
                bundle.putString(AppConstants.Key.FORWARD_THUMB, filePath);
                bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, filePath);
                bundle.putString(AppConstants.Key.FORWARD_EXTRA, filePath);
                bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                ForwardBaseOption.startForwardActivity(QBaseActivity.this, intent, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gxl_ctcshare");
            }
        });
    }

    private final void J(final Activity activity, Bitmap snapshot, final Bundle tailExtBundle) {
        String str;
        TroopInfoData troopInfoData = this.troopInfoData;
        if (troopInfoData != null) {
            str = troopInfoData.troopUin;
        } else {
            str = null;
        }
        E(activity, "temp_qrcode_share_" + str + ".png", snapshot, new Function1<String, Unit>(activity, tailExtBundle) { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopShareCard$shareToQZoneWithTail$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Activity $activity;
            final /* synthetic */ Bundle $tailExtBundle;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$activity = activity;
                this.$tailExtBundle = tailExtBundle;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QRDisplayTroopShareCard.this, activity, tailExtBundle);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String filePath) {
                TroopInfoData troopInfoData2;
                String str2;
                TroopInfoData troopInfoData3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) filePath);
                    return;
                }
                Intrinsics.checkNotNullParameter(filePath, "filePath");
                if (filePath.length() == 0) {
                    QLog.e("QRDisplayTroopShareCard", 1, "shareToQZone failed, path empty");
                    com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
                if (qQAppInterface == null) {
                    QLog.e("QRDisplayTroopShareCard", 1, "shareToQZone failed, app null");
                    com.tencent.biz.qrcode.util.h.T(1, R.string.f1791038g);
                    return;
                }
                Activity activity2 = this.$activity;
                Object[] objArr = new Object[2];
                troopInfoData2 = QRDisplayTroopShareCard.this.troopInfoData;
                if (troopInfoData2 == null || (str2 = com.tencent.mobileqq.troop.troopsetting.modules.base.a.d(troopInfoData2)) == null) {
                    str2 = "";
                }
                objArr[0] = str2;
                troopInfoData3 = QRDisplayTroopShareCard.this.troopInfoData;
                String str3 = troopInfoData3 != null ? troopInfoData3.troopUin : null;
                objArr[1] = str3 != null ? str3 : "";
                String string = activity2.getString(R.string.b1m, objArr);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(\n    \u2026n ?: \"\"\n                )");
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                userInfo.qzone_uin = qQAppInterface.getAccount();
                userInfo.nickname = com.tencent.mobileqq.utils.ac.f(qQAppInterface, qQAppInterface.getAccount());
                Activity activity3 = this.$activity;
                QZoneHelper.forwardToPublishMoodWithExtBundle(activity3, userInfo, filePath, activity3.getString(R.string.b1o), string, this.$tailExtBundle, 1);
            }
        });
    }

    private final void K(final QBaseActivity activity, final int uinType, final String uin, Bitmap snapshot) {
        E(activity, "temp_qrcode_share_" + uin + ".png", snapshot, new Function1<String, Unit>(uinType, uin) { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopShareCard$shareToRecentFriends$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $uin;
            final /* synthetic */ int $uinType;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$uinType = uinType;
                this.$uin = uin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QBaseActivity.this, Integer.valueOf(uinType), uin);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String filePath) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) filePath);
                    return;
                }
                Intrinsics.checkNotNullParameter(filePath, "filePath");
                if (filePath.length() == 0) {
                    QLog.e("QRDisplayTroopShareCard", 1, "shareToRecentFriends failed, path empty");
                    com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
                    return;
                }
                Bundle bundle = new Bundle();
                int i3 = this.$uinType;
                String str = this.$uin;
                bundle.putInt("forward_type", 1);
                bundle.putString(AppConstants.Key.FORWARD_FILEPATH, filePath);
                bundle.putString(AppConstants.Key.FORWARD_THUMB, filePath);
                bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, filePath);
                bundle.putString(AppConstants.Key.FORWARD_EXTRA, filePath);
                bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                bundle.putInt("key_direct_show_uin_type", i3);
                bundle.putString("key_direct_show_uin", str);
                if (6000 == i3 && AppConstants.DATALINE_PC_UIN == str) {
                    bundle.putBoolean("filepath_copy", true);
                }
                Intent intent = new Intent();
                intent.putExtras(bundle);
                ForwardBaseOption.startForwardActivityForResult(QBaseActivity.this, intent, (Class<?>) ForwardRecentTranslucentActivity.class, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gxl_ctcshare");
            }
        });
    }

    private final void L(QBaseActivity activity, Bitmap snapshot, boolean toWeChatCircle) {
        String str;
        if (!WXShareHelper.b0().e0()) {
            QLog.e("QRDisplayTroopShareCard", 1, "shareToWeChat failed, wx not installed");
            com.tencent.biz.qrcode.util.h.T(1, R.string.f173257ih1);
            return;
        }
        if (!WXShareHelper.b0().f0()) {
            QLog.e("QRDisplayTroopShareCard", 1, "shareToWeChat failed, wx version too low");
            com.tencent.biz.qrcode.util.h.T(1, R.string.f173258ih2);
            return;
        }
        TroopInfoData troopInfoData = this.troopInfoData;
        if (troopInfoData != null) {
            str = troopInfoData.troopUin;
        } else {
            str = null;
        }
        E(activity, "temp_qrcode_share_" + str + ".png", snapshot, new QRDisplayTroopShareCard$shareToWeChat$1(this, snapshot, toWeChatCircle));
    }

    private final void M(final QBaseActivity activity, final Bitmap preview) {
        ShareActionSheetWithPreview b16 = com.tencent.biz.qrcode.util.i.f95067a.b(activity, preview);
        b16.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.mobileqq.troop.qrcode.u
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                QRDisplayTroopShareCard.N(QRDisplayTroopShareCard.this, activity, preview, actionSheetItem, shareActionSheet);
            }
        });
        b16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(QRDisplayTroopShareCard this$0, QBaseActivity activity, Bitmap preview, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        String str;
        String num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(preview, "$preview");
        shareActionSheet.dismiss();
        QLog.i("QRDisplayTroopShareCard", 1, "click action=" + actionSheetItem.action);
        int i3 = actionSheetItem.action;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 26) {
                                if (i3 != 39) {
                                    if (i3 == 72) {
                                        int i16 = actionSheetItem.uinType;
                                        String str2 = actionSheetItem.uin;
                                        Intrinsics.checkNotNullExpressionValue(str2, "item.uin");
                                        this$0.K(activity, i16, str2, preview);
                                        return;
                                    }
                                    return;
                                }
                                this$0.C(activity);
                                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                if (peekAppRuntime != null) {
                                    com.tencent.mobileqq.statistics.q d16 = new com.tencent.mobileqq.statistics.q(peekAppRuntime).i("P_CliOper").a("Grp_set").f("Grp_data").d("qr_save");
                                    String[] strArr = new String[2];
                                    TroopInfoData troopInfoData = this$0.troopInfoData;
                                    if (troopInfoData != null) {
                                        str = troopInfoData.troopUin;
                                    } else {
                                        str = null;
                                    }
                                    String str3 = "";
                                    if (str == null) {
                                        str = "";
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(str, "troopInfoData?.troopUin ?: \"\"");
                                    }
                                    strArr[0] = str;
                                    TroopInfoData troopInfoData2 = this$0.troopInfoData;
                                    if (troopInfoData2 != null && (num = Integer.valueOf(ae.f298175a.c(troopInfoData2)).toString()) != null) {
                                        str3 = num;
                                    }
                                    strArr[1] = str3;
                                    d16.b(strArr).g();
                                    return;
                                }
                                return;
                            }
                            String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
                            Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
                            this$0.K(activity, 6000, DATALINE_PC_UIN, preview);
                            return;
                        }
                        this$0.L(activity, preview, true);
                        return;
                    }
                    this$0.L(activity, preview, false);
                    return;
                }
                this$0.x(activity);
                return;
            }
            this$0.I(activity, preview);
            return;
        }
        this$0.n(activity);
    }

    private final void O(QBaseActivity activity, Bitmap preview) {
        if (this.troopInfoData == null) {
            return;
        }
        ((ITroopShareUtility) QRoute.api(ITroopShareUtility.class)).showQRCodeSharePanel(activity, this.troopInfoData, preview, this.shareLink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(QRDisplayTroopShareCard this$0, Bitmap bitmap, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        ImageView imageView = this$0.qrCodeIv;
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        ImageView imageView2 = this$0.qrCodeIv;
        if (imageView2 != null) {
            imageView2.setImageBitmap(bitmap);
        }
        this$0.snapshotBitmap = this$0.o();
        this$0.x(activity);
    }

    private final void n(QBaseActivity activity) {
        boolean z16;
        ClipboardManager clipboardManager;
        String str = this.shareLink;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("QRDisplayTroopShareCard", 1, "copy link failed, link is empty");
            com.tencent.biz.qrcode.util.h.T(1, R.string.zot);
            return;
        }
        String str2 = "\u70b9\u51fb\u94fe\u63a5\u52a0\u5165\u7fa4\u804a\uff1a" + this.shareLink;
        Object systemService = activity.getSystemService("clipboard");
        Unit unit = null;
        if (systemService instanceof ClipboardManager) {
            clipboardManager = (ClipboardManager) systemService;
        } else {
            clipboardManager = null;
        }
        ClipData newPlainText = ClipData.newPlainText("my_qr_url", str2);
        if (clipboardManager != null) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, newPlainText);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e("QRDisplayTroopShareCard", 1, "copyLink failed " + this.shareLink);
            return;
        }
        QLog.i("QRDisplayTroopShareCard", 1, "copyLink succeed =" + this.shareLink);
        com.tencent.biz.qrcode.util.h.T(2, R.string.f170327mg);
    }

    private final Bitmap o() {
        Integer num;
        Bitmap bitmap;
        String str;
        com.tencent.biz.qrcode.mgr.d dVar = this.qrCodeData;
        if (dVar != null) {
            num = Integer.valueOf(dVar.getStyle());
        } else {
            num = null;
        }
        com.tencent.biz.qrcode.mgr.d dVar2 = this.qrCodeData;
        if (dVar2 != null) {
            bitmap = dVar2.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String();
        } else {
            bitmap = null;
        }
        com.tencent.biz.qrcode.mgr.d dVar3 = this.qrCodeData;
        if (dVar3 != null) {
            str = dVar3.getShortChain();
        } else {
            str = null;
        }
        QLog.i("QRDisplayTroopShareCard", 1, "[createShareLayoutSnapshot] qrCodeData = " + dVar + ", " + num + ", " + bitmap + ", " + str);
        View view = this.shareLayout;
        if (view == null) {
            QLog.e("QRDisplayTroopShareCard", 1, "createShareLayoutSnapshot failed, shareLayout null");
            return null;
        }
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.s
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayTroopShareCard.p(QRDisplayTroopShareCard.this);
                }
            });
            try {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                if (createBitmap == null) {
                    return null;
                }
                view.draw(new Canvas(createBitmap));
                return createBitmap;
            } catch (Throwable th5) {
                QLog.e("QRDisplayTroopShareCard", 1, "createShareLayoutSnapshot failed, e=" + th5.getMessage());
                return null;
            }
        }
        QLog.e("QRDisplayTroopShareCard", 1, "createShareLayoutSnapshot failed, shareLayout size 0");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(QRDisplayTroopShareCard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qrcode.mgr.d dVar = this$0.qrCodeData;
        if (dVar != null) {
            if (dVar.getStyle() == 2 && dVar.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String() != null) {
                View view = this$0.qrCodeLayout;
                if (view != null) {
                    view.setVisibility(4);
                }
                View view2 = this$0.aigcQRCodeLayout;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ImageView imageView = this$0.aigcCodeImage;
                if (imageView != null) {
                    imageView.setImageBitmap(dVar.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String());
                    return;
                }
                return;
            }
            View view3 = this$0.qrCodeLayout;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            View view4 = this$0.aigcQRCodeLayout;
            if (view4 != null) {
                view4.setVisibility(4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        if (r1 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bitmap q() {
        boolean z16;
        boolean z17;
        String str = this.shareLink;
        boolean z18 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            com.tencent.biz.qrcode.mgr.d dVar = this.qrCodeData;
            if (dVar != null && dVar.a()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                QLog.e("QRDisplayTroopShareCard", 1, "getShareLayoutSnapshot failed shareLink is empty\uff0c qrCodeData = " + this.qrCodeData);
                return null;
            }
        }
        Bitmap bitmap = this.snapshotBitmap;
        if (bitmap != null) {
            if (bitmap != null && bitmap.isRecycled()) {
                z18 = true;
            }
        }
        this.snapshotBitmap = o();
        return this.snapshotBitmap;
    }

    private final void s(View shareLayout, TroopInfoData troopInfoData) {
        String str = troopInfoData.troopUin;
        if (str == null) {
            str = "";
        }
        String d16 = com.tencent.mobileqq.troop.troopsetting.modules.base.a.d(troopInfoData);
        com.tencent.mobileqq.proavatar.e a16 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(str)).g(200).a();
        TextView textView = (TextView) shareLayout.findViewById(R.id.f1059367c);
        TextView textView2 = (TextView) shareLayout.findViewById(R.id.f1059467d);
        textView.setText(d16);
        textView2.setText("\u7fa4\u53f7: " + str);
        ((QQProAvatarView) shareLayout.findViewById(R.id.xzs)).x(4, str, a16);
        this.aigcCodeImage = (ImageView) shareLayout.findViewById(R.id.xzt);
        if (troopInfoData.isNewTroop) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
        }
        this.aigcQRCodeLayout = shareLayout.findViewById(R.id.f645636k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(baseResp);
    }

    private final void x(final Activity activity) {
        final Bitmap q16 = q();
        if (q16 == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.y
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayTroopShareCard.y(QRDisplayTroopShareCard.this, activity, q16);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(QRDisplayTroopShareCard this$0, Activity activity, Bitmap preview) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(preview, "$preview");
        ITroopQRCodeShareApi iTroopQRCodeShareApi = (ITroopQRCodeShareApi) QRoute.api(ITroopQRCodeShareApi.class);
        TroopInfoData troopInfoData = this$0.troopInfoData;
        if (troopInfoData != null) {
            str = troopInfoData.troopUin;
        } else {
            str = null;
        }
        this$0.J(activity, preview, iTroopQRCodeShareApi.getQZonePublishBizBundle(str, com.tencent.mobileqq.troop.troopsetting.modules.base.a.d(troopInfoData), this$0.shareLink));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, android.net.Uri] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void z(final QBaseActivity activity) {
        Throwable th5;
        OutputStream outputStream;
        String message;
        StringBuilder sb5;
        TroopInfoData troopInfoData;
        String str;
        String str2;
        T t16;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Bitmap q16 = q();
        if (q16 != null && !q16.isRecycled()) {
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentResolver contentResolver = activity.getContentResolver();
            if (contentResolver == 0) {
                return;
            }
            String str3 = "qrcode_" + System.currentTimeMillis();
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str3);
            contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str3);
            contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
            ?? insert = contentResolver.insert(uri, contentValues);
            objectRef.element = insert;
            OutputStream outputStream2 = null;
            Integer num = null;
            try {
                if (insert != 0) {
                    try {
                        outputStream = contentResolver.openOutputStream(insert);
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        outputStream = null;
                        QLog.e("QRDisplayTroopShareCard", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr = new String[3];
                        troopInfoData = this.troopInfoData;
                        if (troopInfoData != null) {
                        }
                        strArr[0] = str;
                        if (troopInfoData != null) {
                        }
                        strArr[1] = String.valueOf(num);
                        if (booleanRef.element) {
                        }
                        strArr[2] = str2;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayTroopShareCard.B(Ref.BooleanRef.this, activity, objectRef);
                            }
                        });
                    } catch (IllegalStateException e17) {
                        e = e17;
                        outputStream = null;
                        QLog.e("QRDisplayTroopShareCard", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr2 = new String[3];
                        troopInfoData = this.troopInfoData;
                        if (troopInfoData != null) {
                        }
                        strArr2[0] = str;
                        if (troopInfoData != null) {
                        }
                        strArr2[1] = String.valueOf(num);
                        if (booleanRef.element) {
                        }
                        strArr2[2] = str2;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr2);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayTroopShareCard.B(Ref.BooleanRef.this, activity, objectRef);
                            }
                        });
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        outputStream = null;
                        QLog.e("QRDisplayTroopShareCard", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr22 = new String[3];
                        troopInfoData = this.troopInfoData;
                        if (troopInfoData != null) {
                        }
                        strArr22[0] = str;
                        if (troopInfoData != null) {
                        }
                        strArr22[1] = String.valueOf(num);
                        if (booleanRef.element) {
                        }
                        strArr22[2] = str2;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr22);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayTroopShareCard.B(Ref.BooleanRef.this, activity, objectRef);
                            }
                        });
                    } catch (Throwable th6) {
                        th5 = th6;
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                                throw th5;
                            } catch (IOException e19) {
                                QLog.e("QRDisplayTroopShareCard", 1, "saveQRCodeInternal finally, error = " + e19.getMessage());
                                throw th5;
                            }
                        }
                        throw th5;
                    }
                } else {
                    outputStream = null;
                }
                if (outputStream != null) {
                    try {
                        booleanRef.element = q16.compress(Bitmap.CompressFormat.JPEG, 75, outputStream);
                    } catch (FileNotFoundException e26) {
                        e = e26;
                        QLog.e("QRDisplayTroopShareCard", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e27) {
                                message = e27.getMessage();
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeInternal finally, error = ");
                                sb5.append(message);
                                QLog.e("QRDisplayTroopShareCard", 1, sb5.toString());
                                if (!booleanRef.element) {
                                }
                                String[] strArr222 = new String[3];
                                troopInfoData = this.troopInfoData;
                                if (troopInfoData != null) {
                                }
                                strArr222[0] = str;
                                if (troopInfoData != null) {
                                }
                                strArr222[1] = String.valueOf(num);
                                if (booleanRef.element) {
                                }
                                strArr222[2] = str2;
                                eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr222);
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.w
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        QRDisplayTroopShareCard.B(Ref.BooleanRef.this, activity, objectRef);
                                    }
                                });
                            }
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr2222 = new String[3];
                        troopInfoData = this.troopInfoData;
                        if (troopInfoData != null) {
                        }
                        strArr2222[0] = str;
                        if (troopInfoData != null) {
                        }
                        strArr2222[1] = String.valueOf(num);
                        if (booleanRef.element) {
                        }
                        strArr2222[2] = str2;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr2222);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayTroopShareCard.B(Ref.BooleanRef.this, activity, objectRef);
                            }
                        });
                    } catch (IllegalStateException e28) {
                        e = e28;
                        QLog.e("QRDisplayTroopShareCard", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e29) {
                                message = e29.getMessage();
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeInternal finally, error = ");
                                sb5.append(message);
                                QLog.e("QRDisplayTroopShareCard", 1, sb5.toString());
                                if (!booleanRef.element) {
                                }
                                String[] strArr22222 = new String[3];
                                troopInfoData = this.troopInfoData;
                                if (troopInfoData != null) {
                                }
                                strArr22222[0] = str;
                                if (troopInfoData != null) {
                                }
                                strArr22222[1] = String.valueOf(num);
                                if (booleanRef.element) {
                                }
                                strArr22222[2] = str2;
                                eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr22222);
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.w
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        QRDisplayTroopShareCard.B(Ref.BooleanRef.this, activity, objectRef);
                                    }
                                });
                            }
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr222222 = new String[3];
                        troopInfoData = this.troopInfoData;
                        if (troopInfoData != null) {
                        }
                        strArr222222[0] = str;
                        if (troopInfoData != null) {
                        }
                        strArr222222[1] = String.valueOf(num);
                        if (booleanRef.element) {
                        }
                        strArr222222[2] = str2;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr222222);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayTroopShareCard.B(Ref.BooleanRef.this, activity, objectRef);
                            }
                        });
                    } catch (OutOfMemoryError e36) {
                        e = e36;
                        QLog.e("QRDisplayTroopShareCard", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e37) {
                                message = e37.getMessage();
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeInternal finally, error = ");
                                sb5.append(message);
                                QLog.e("QRDisplayTroopShareCard", 1, sb5.toString());
                                if (!booleanRef.element) {
                                }
                                String[] strArr2222222 = new String[3];
                                troopInfoData = this.troopInfoData;
                                if (troopInfoData != null) {
                                }
                                strArr2222222[0] = str;
                                if (troopInfoData != null) {
                                }
                                strArr2222222[1] = String.valueOf(num);
                                if (booleanRef.element) {
                                }
                                strArr2222222[2] = str2;
                                eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr2222222);
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.w
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        QRDisplayTroopShareCard.B(Ref.BooleanRef.this, activity, objectRef);
                                    }
                                });
                            }
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr22222222 = new String[3];
                        troopInfoData = this.troopInfoData;
                        if (troopInfoData != null) {
                        }
                        strArr22222222[0] = str;
                        if (troopInfoData != null) {
                        }
                        strArr22222222[1] = String.valueOf(num);
                        if (booleanRef.element) {
                        }
                        strArr22222222[2] = str2;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr22222222);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayTroopShareCard.B(Ref.BooleanRef.this, activity, objectRef);
                            }
                        });
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e38) {
                        message = e38.getMessage();
                        sb5 = new StringBuilder();
                        sb5.append("saveQRCodeInternal finally, error = ");
                        sb5.append(message);
                        QLog.e("QRDisplayTroopShareCard", 1, sb5.toString());
                        if (!booleanRef.element) {
                            py3.b.e(contentResolver, (Uri) t16, null, null);
                        }
                        String[] strArr222222222 = new String[3];
                        troopInfoData = this.troopInfoData;
                        if (troopInfoData != null) {
                        }
                        strArr222222222[0] = str;
                        if (troopInfoData != null) {
                        }
                        strArr222222222[1] = String.valueOf(num);
                        if (booleanRef.element) {
                        }
                        strArr222222222[2] = str2;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr222222222);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayTroopShareCard.B(Ref.BooleanRef.this, activity, objectRef);
                            }
                        });
                    }
                }
                if (!booleanRef.element && (t16 = objectRef.element) != 0) {
                    py3.b.e(contentResolver, (Uri) t16, null, null);
                }
                String[] strArr2222222222 = new String[3];
                troopInfoData = this.troopInfoData;
                if (troopInfoData != null) {
                    str = troopInfoData.troopUin;
                } else {
                    str = null;
                }
                strArr2222222222[0] = str;
                if (troopInfoData != null) {
                    num = Integer.valueOf(ae.f298175a.c(troopInfoData));
                }
                strArr2222222222[1] = String.valueOf(num);
                if (booleanRef.element) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                strArr2222222222[2] = str2;
                eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr2222222222);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        QRDisplayTroopShareCard.B(Ref.BooleanRef.this, activity, objectRef);
                    }
                });
            } catch (Throwable th7) {
                th5 = th7;
                outputStream2 = insert;
            }
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.v
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayTroopShareCard.A();
                }
            });
            QLog.e("QRDisplayTroopShareCard", 1, "saveQRCodeInternal failed, bitmap is null");
        }
    }

    public final void C(@NotNull final QBaseActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QR_DISPLAY, QQPermissionConstants.Business.SCENE.QR_DISPLAY));
        if (qQPermission == null) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.f224046hv);
            QLog.e("QRDisplayTroopShareCard", 1, "saveSnapshot, qqPermission is null");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.t
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayTroopShareCard.D(QRDisplayTroopShareCard.this, activity);
                }
            });
        } else {
            QLog.i("QRDisplayTroopShareCard", 1, "saveSnapshot, request permission");
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(activity));
        }
    }

    public final void H(@NotNull QBaseActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Bitmap q16 = q();
        if (q16 == null) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.f224046hv);
            QLog.e("QRDisplayTroopShareCard", 1, "shareQRCode failed, bitmap is null");
        } else if (!this.qrCodeGenerated) {
            com.tencent.biz.qrcode.util.h.T(0, R.string.f2034750a);
        } else if (((ITroopShareApi) QRoute.api(ITroopShareApi.class)).useNewSharePanel("group_qrcode")) {
            O(activity, q16);
        } else {
            M(activity, q16);
        }
    }

    public final void P(@Nullable com.tencent.biz.qrcode.mgr.d qrCodeData) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qrCodeData);
            return;
        }
        this.qrCodeData = qrCodeData;
        if (qrCodeData != null) {
            bitmap = qrCodeData.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String();
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            ImageView imageView = this.aigcCodeImage;
            if (imageView != null) {
                imageView.setImageBitmap(qrCodeData.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String());
            }
            this.qrCodeGenerated = true;
            View view = this.qrCodeLayout;
            if (view != null) {
                view.setVisibility(4);
            }
            View view2 = this.aigcQRCodeLayout;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            this.snapshotBitmap = o();
        }
    }

    public final void Q(@NotNull QRCodeLoadingComponent qrCode, @NotNull String shareLink, @Nullable com.tencent.biz.qrcode.mgr.d qrCodeData) {
        boolean booleanValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qrCode, shareLink, qrCodeData);
            return;
        }
        Intrinsics.checkNotNullParameter(qrCode, "qrCode");
        Intrinsics.checkNotNullParameter(shareLink, "shareLink");
        QLog.i("QRDisplayTroopShareCard", 1, "[updateQrCode] qrCode = " + qrCode + ", qrCodeData = " + qrCodeData + " shareLink = " + shareLink);
        P(qrCodeData);
        if (qrCode.getWidth() > 0 && qrCode.getHeight() > 0) {
            try {
                qrCode.z();
                Bitmap createBitmap = Bitmap.createBitmap(qrCode.getWidth(), qrCode.getHeight(), Bitmap.Config.ARGB_8888);
                qrCode.draw(new Canvas(createBitmap));
                qrCode.A();
                ImageView imageView = this.qrCodeIv;
                if (imageView != null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                }
                ImageView imageView2 = this.qrCodeIv;
                if (imageView2 != null) {
                    imageView2.setImageBitmap(createBitmap);
                }
                Boolean value = qrCode.v().getValue();
                if (value == null) {
                    booleanValue = false;
                } else {
                    booleanValue = value.booleanValue();
                }
                this.qrCodeGenerated = booleanValue;
                this.snapshotBitmap = o();
                this.shareLink = shareLink;
                return;
            } catch (Throwable th5) {
                QLog.e("QRDisplayTroopShareCard", 1, "updateQrCode failed, e=" + th5.getMessage());
                return;
            }
        }
        QLog.e("QRDisplayTroopShareCard", 1, "updateQrCode failed");
    }

    public final void R(@NotNull final Activity activity, @NotNull String shareLink, @Nullable final Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, shareLink, bitmap);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareLink, "shareLink");
        this.shareLink = shareLink;
        this.qrCodeData = new com.tencent.biz.qrcode.mgr.d(1, shareLink, null, null, 12, null);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.x
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayTroopShareCard.S(QRDisplayTroopShareCard.this, bitmap, activity);
            }
        });
    }

    public final void T(@Nullable QunSourceSvrPB$SourceItem source) {
        TextView textView;
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) source);
            return;
        }
        View view = this.shareLayout;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.tax);
        } else {
            textView = null;
        }
        if (textView == null) {
            return;
        }
        if (source == null) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
        if (source != null) {
            PBStringField pBStringField = source.desc;
            if (pBStringField == null || (str = pBStringField.get()) == null) {
                str = "";
            }
            textView.setText(str);
        }
    }

    public final void U(@Nullable String newTroopName) {
        boolean z16;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) newTroopName);
            return;
        }
        if (this.shareLayout != null) {
            if (newTroopName != null && newTroopName.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                View view = this.shareLayout;
                if (view != null) {
                    textView = (TextView) view.findViewById(R.id.f5q);
                } else {
                    textView = null;
                }
                if (textView != null) {
                    textView.setText(newTroopName);
                }
                this.snapshotBitmap = o();
            }
        }
    }

    public final void r(@NotNull View shareLayout, @NotNull TroopInfoData troopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) shareLayout, (Object) troopInfoData);
            return;
        }
        Intrinsics.checkNotNullParameter(shareLayout, "shareLayout");
        Intrinsics.checkNotNullParameter(troopInfoData, "troopInfoData");
        String str = troopInfoData.troopUin;
        if (str == null) {
            str = "";
        }
        String d16 = com.tencent.mobileqq.troop.troopsetting.modules.base.a.d(troopInfoData);
        com.tencent.mobileqq.proavatar.e a16 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(str)).g(200).a();
        TextView textView = (TextView) shareLayout.findViewById(R.id.f5q);
        TextView textView2 = (TextView) shareLayout.findViewById(R.id.kh6);
        textView.setText(d16);
        textView2.setText("\u7fa4\u53f7: " + str);
        ((QQProAvatarView) shareLayout.findViewById(R.id.a38)).x(4, str, a16);
        this.qrCodeIv = (ImageView) shareLayout.findViewById(R.id.h0d);
        if (troopInfoData.isNewTroop) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
        }
        this.shareLayout = shareLayout;
        this.qrCodeLayout = shareLayout.findViewById(R.id.m38);
        this.troopInfoData = troopInfoData;
        s(shareLayout, troopInfoData);
    }

    public final void t(@NotNull QBaseActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, activity, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.i("QRDisplayTroopShareCard", 1, "onActivityResult requestCode=" + requestCode + " resultCode=" + resultCode);
        if (resultCode == -1 && requestCode == 1) {
            com.tencent.biz.qrcode.util.h.T(2, R.string.f172952g24);
        }
    }

    public final void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        WXShareHelper b06 = WXShareHelper.b0();
        final Function1<BaseResp, Unit> function1 = this.wxShareListener;
        b06.q0(new WXShareHelper.a() { // from class: com.tencent.mobileqq.troop.qrcode.r
            @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
            public final void onWXShareResp(BaseResp baseResp) {
                QRDisplayTroopShareCard.v(Function1.this, baseResp);
            }
        });
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        View view = this.qrCodeLayout;
        if (view != null) {
            QRVasThemeBgCompat.f298153a.c(view);
        }
    }
}
