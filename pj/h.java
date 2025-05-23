package pj;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.util.Consumer;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateWriteMoodInitBean;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import ij.QZIntimatePicSharePreviewBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002%-B\u0011\u0012\b\u0010+\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\bE\u0010*J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J*\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J\u0006\u0010#\u001a\u00020\u0005R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010:R\u0018\u0010A\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010:R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010C\u00a8\u0006F"}, d2 = {"Lpj/h;", "", "", "", "pageParamMap", "", "v", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "o", DomainData.DOMAIN_NAME, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "l", "k", "", "action", "j", "p", "w", "filePath", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "y", "shareAction", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "icon", "msg", "E", "Lij/d;", "shareBean", "Lpj/h$b;", "listener", "B", "r", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/share/ShareActionSheetWithPreview;", "b", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetWithPreview;", "shareActionSheetWithPreview", "c", "Lij/d;", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "d", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "wxShareListener", "e", "Lpj/h$b;", "previewListener", "f", "Ljava/lang/String;", "spaceId", "g", "I", "spaceType", tl.h.F, "i", "resignLink", "", "Z", "isPreviewAlreadyDismiss", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ShareActionSheetWithPreview shareActionSheetWithPreview;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private QZIntimatePicSharePreviewBean shareBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WXShareHelper.a wxShareListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private b previewListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String spaceId = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int spaceType = -1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String filePath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String resignLink;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isPreviewAlreadyDismiss;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lpj/h$b;", "", "", "b", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public interface b {
        void a();

        void b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"pj/h$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c extends QQPermission.BasePermissionsListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            h hVar = h.this;
            String str = hVar.filePath;
            Intrinsics.checkNotNull(str);
            hVar.s(str);
        }
    }

    public h(Activity activity) {
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(h this$0, BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (baseResp.errCode != 0) {
            this$0.E(1, R.string.f171047bz3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(h this$0, b listener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (this$0.isPreviewAlreadyDismiss) {
            return;
        }
        this$0.isPreviewAlreadyDismiss = true;
        listener.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View D(View it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        return it;
    }

    private final void E(final int icon, final int msg2) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: pj.e
            @Override // java.lang.Runnable
            public final void run() {
                h.F(icon, msg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(int i3, int i16) {
        try {
            com.tencent.biz.qrcode.util.h.T(i3, i16);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("IntimateInfoShareHelper", 1, "showQQToast error: " + e16.getMessage());
        }
    }

    private final void j(int action) {
        int i3;
        if (this.shareActionSheetWithPreview == null) {
            QLog.e("QZIntimateSharePreviewHelper", 1, "shareActionSheetWithPreview is null");
            return;
        }
        boolean z16 = false;
        if (action != 2) {
            i3 = 3;
            if (action == 3) {
                i3 = 2;
            } else if (action != 9) {
                i3 = action != 10 ? action != 39 ? (action == 219 || action != 238) ? 0 : 6 : 5 : 4;
            }
        } else {
            i3 = 1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("share_source", Integer.valueOf(i3));
        QZIntimatePicSharePreviewBean qZIntimatePicSharePreviewBean = this.shareBean;
        if (qZIntimatePicSharePreviewBean != null && qZIntimatePicSharePreviewBean.getAutoSyncQZone()) {
            z16 = true;
        }
        hashMap.put("op_result", Integer.valueOf(z16 ? 1 : 2));
        ShareActionSheetWithPreview shareActionSheetWithPreview = this.shareActionSheetWithPreview;
        Intrinsics.checkNotNull(shareActionSheetWithPreview);
        fo.c.e("em_qz_sharing_panel", "pg_qz_intimate_space_home", shareActionSheetWithPreview.getActionSheet().getActionContentView(), hashMap);
    }

    private final void k() {
        if (this.shareActionSheetWithPreview == null) {
            QLog.e("QZIntimateSharePreviewHelper", 1, "shareActionSheetWithPreview is null");
            return;
        }
        HashMap hashMap = new HashMap();
        QZIntimatePicSharePreviewBean qZIntimatePicSharePreviewBean = this.shareBean;
        boolean z16 = false;
        if (qZIntimatePicSharePreviewBean != null && qZIntimatePicSharePreviewBean.getAutoSyncQZone()) {
            z16 = true;
        }
        hashMap.put("op_result", Integer.valueOf(z16 ? 1 : 2));
        ShareActionSheetWithPreview shareActionSheetWithPreview = this.shareActionSheetWithPreview;
        Intrinsics.checkNotNull(shareActionSheetWithPreview);
        fo.c.g("em_qz_sharing_panel", "pg_qz_intimate_space_home", shareActionSheetWithPreview.getActionSheet().getActionContentView(), hashMap);
    }

    private final void l(final Bitmap bitmap) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = this.activity;
        ShareActionSheetWithPreview shareActionSheetWithPreview = new ShareActionSheetWithPreview(param);
        this.shareActionSheetWithPreview = shareActionSheetWithPreview;
        shareActionSheetWithPreview.setRowVisibility(8, 0, 0);
        ShareActionSheetWithPreview shareActionSheetWithPreview2 = this.shareActionSheetWithPreview;
        if (shareActionSheetWithPreview2 != null) {
            shareActionSheetWithPreview2.setActionSheetItems(o(), n());
        }
        ShareActionSheetWithPreview shareActionSheetWithPreview3 = this.shareActionSheetWithPreview;
        if (shareActionSheetWithPreview3 != null) {
            shareActionSheetWithPreview3.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: pj.c
                @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
                public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                    h.m(h.this, bitmap, actionSheetItem, shareActionSheet);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(h this$0, Bitmap bitmap, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        int i3 = item.action;
        if (i3 == 9 || i3 == 10) {
            if (!WXShareHelper.b0().e0()) {
                QQToastUtil.showQQToastInUiThread(4, "\u672a\u5b89\u88c5\u5fae\u4fe1\uff0c\u5206\u4eab\u5931\u8d25");
                return;
            } else if (!WXShareHelper.b0().f0()) {
                QQToastUtil.showQQToastInUiThread(4, "\u5fae\u4fe1\u7248\u672c\u8fc7\u4f4e\uff0c\u5206\u4eab\u5931\u8d25");
                return;
            }
        }
        this$0.j(item.action);
        int i16 = item.action;
        if (i16 == 2) {
            this$0.x();
        } else if (i16 == 3) {
            this$0.y();
        } else if (i16 == 9) {
            this$0.z(bitmap, 9);
        } else if (i16 == 10) {
            this$0.z(bitmap, 10);
        } else if (i16 == 39) {
            this$0.w();
        } else if (i16 == 219) {
            this$0.p();
        } else if (i16 == 238) {
            this$0.q();
        }
        ShareActionSheetWithPreview shareActionSheetWithPreview = this$0.shareActionSheetWithPreview;
        if (shareActionSheetWithPreview != null) {
            shareActionSheetWithPreview.dismiss();
        }
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        if (!TextUtils.isEmpty(this.resignLink)) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(238));
        }
        return arrayList;
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> o() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(219));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        return arrayList;
    }

    private final void p() {
        if (this.spaceType != -1 && this.activity != null) {
            if (TextUtils.isEmpty(this.filePath)) {
                QLog.e("QZIntimateSharePreviewHelper", 1, "filePath is null");
                return;
            }
            QZoneIntimateWriteMoodInitBean qZoneIntimateWriteMoodInitBean = new QZoneIntimateWriteMoodInitBean();
            qZoneIntimateWriteMoodInitBean.setSpaceType(this.spaceType);
            qZoneIntimateWriteMoodInitBean.setSpaceId(this.spaceId);
            ArrayList<String> arrayList = new ArrayList<>();
            String str = this.filePath;
            Intrinsics.checkNotNull(str);
            arrayList.add(str);
            qZoneIntimateWriteMoodInitBean.setFilePathList(arrayList);
            ck.c o16 = ho.i.o();
            Activity activity = this.activity;
            Intrinsics.checkNotNull(activity);
            o16.t(activity, qZoneIntimateWriteMoodInitBean, QZoneContant.REQUEST_CODE_INTIMATE_SPACE_PUNCH_SHARE);
            return;
        }
        QLog.e("QZIntimateSharePreviewHelper", 1, "space bean is null");
    }

    private final void q() {
        ho.i.q(this.activity, this.resignLink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(String filePath) {
        RFWSaveUtil.insertMedia(BaseApplication.getContext(), filePath, new Consumer() { // from class: pj.d
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                h.t(h.this, (RFWSaveMediaResultBean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final h this$0, final RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: pj.g
            @Override // java.lang.Runnable
            public final void run() {
                h.u(RFWSaveMediaResultBean.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (r3.isSuccess == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void u(RFWSaveMediaResultBean rFWSaveMediaResultBean, h this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        if (rFWSaveMediaResultBean != null) {
            z16 = true;
        }
        z16 = false;
        String string = context.getString(z16 ? R.string.h4_ : R.string.g2q);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(if (re\u2026.string.qrcode_save_fail)");
        QQToast.makeText(this$0.activity, 0, string, 0).show();
    }

    private final void v(Map<String, Object> pageParamMap) {
        ShareActionSheetWithPreview shareActionSheetWithPreview = this.shareActionSheetWithPreview;
        if (shareActionSheetWithPreview == null) {
            return;
        }
        Intrinsics.checkNotNull(shareActionSheetWithPreview);
        RelativeLayout actionContentView = shareActionSheetWithPreview.getActionSheet().getActionContentView();
        VideoReport.setPageId(actionContentView, "pg_qz_intimate_space_home");
        VideoReport.setPageReportPolicy(actionContentView, PageReportPolicy.REPORT_NONE);
        VideoReport.setPageParams(actionContentView, new fo.a().d("QZIntimateSharePreviewHelper", pageParamMap));
    }

    private final void w() {
        if (TextUtils.isEmpty(this.filePath)) {
            QLog.e("QZIntimateSharePreviewHelper", 1, "filePath is null");
            return;
        }
        if (!com.tencent.mobileqq.startup.permission.a.f(this.activity)) {
            QQPermissionFactory.getQQPermission(this.activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_PIC)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c());
        } else {
            String str = this.filePath;
            Intrinsics.checkNotNull(str);
            s(str);
        }
    }

    private final void y() {
        if (TextUtils.isEmpty(this.filePath)) {
            E(1, R.string.byy);
            return;
        }
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        userInfo.qzone_uin = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
        QZoneHelper.forwardToPublishMood(this.activity, userInfo, this.filePath, "\u5206\u4eab\u5230\u7a7a\u95f4", "", "qimizone_riqian_active", null, QZoneContant.REQUEST_CODE_INTIMATE_SPACE_PUNCH_SHARE);
    }

    private final void z(Bitmap bitmap, int shareAction) {
        if (this.wxShareListener == null) {
            this.wxShareListener = new WXShareHelper.a() { // from class: pj.f
                @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                public final void onWXShareResp(BaseResp baseResp) {
                    h.A(h.this, baseResp);
                }
            };
            WXShareHelper.b0().A(this.wxShareListener);
        }
        if (TextUtils.isEmpty(this.filePath)) {
            E(1, R.string.byy);
        } else if (shareAction == 9) {
            WXShareHelper.b0().u0(this.filePath, bitmap, 0);
        } else {
            if (shareAction != 10) {
                return;
            }
            WXShareHelper.b0().u0(this.filePath, bitmap, 1);
        }
    }

    public final void B(QZIntimatePicSharePreviewBean shareBean, final b listener, Map<String, Object> pageParamMap) {
        ShareActionSheetWithPreview shareActionSheetWithPreview;
        Intrinsics.checkNotNullParameter(shareBean, "shareBean");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(pageParamMap, "pageParamMap");
        this.shareBean = shareBean;
        this.spaceId = shareBean.getSpaceId();
        this.spaceType = shareBean.getSpaceType();
        this.filePath = shareBean.getFilePath();
        this.resignLink = shareBean.getResignLink();
        if (this.shareActionSheetWithPreview == null) {
            l(shareBean.getPreviewBitmap());
        }
        ShareActionSheetWithPreview shareActionSheetWithPreview2 = this.shareActionSheetWithPreview;
        if (shareActionSheetWithPreview2 != null) {
            shareActionSheetWithPreview2.D0(shareBean.getPreviewBitmap());
        }
        this.previewListener = listener;
        listener.b();
        ShareActionSheetWithPreview shareActionSheetWithPreview3 = this.shareActionSheetWithPreview;
        if (shareActionSheetWithPreview3 != null) {
            shareActionSheetWithPreview3.setWatchDismissListener(new ActionSheet.WatchDismissActions() { // from class: pj.a
                @Override // com.tencent.widget.ActionSheet.WatchDismissActions
                public final void onDismissOperations() {
                    h.C(h.this, listener);
                }
            });
        }
        final View bottomView = shareBean.getBottomView();
        if (bottomView != null && (shareActionSheetWithPreview = this.shareActionSheetWithPreview) != null) {
            shareActionSheetWithPreview.setBottomBarInterface(new ShareActionSheet.b() { // from class: pj.b
                @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.b
                public final View a() {
                    View D;
                    D = h.D(bottomView);
                    return D;
                }
            });
        }
        ShareActionSheetWithPreview shareActionSheetWithPreview4 = this.shareActionSheetWithPreview;
        if (shareActionSheetWithPreview4 != null) {
            shareActionSheetWithPreview4.show();
        }
        v(pageParamMap);
        k();
    }

    public final void r() {
        if (this.wxShareListener != null) {
            WXShareHelper.b0().q0(this.wxShareListener);
            this.wxShareListener = null;
        }
        ShareActionSheetWithPreview shareActionSheetWithPreview = this.shareActionSheetWithPreview;
        if (shareActionSheetWithPreview != null) {
            shareActionSheetWithPreview.dismiss();
        }
        this.activity = null;
    }

    private final void x() {
        try {
            if (TextUtils.isEmpty(this.filePath)) {
                E(1, R.string.byy);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 1);
            bundle.putString(AppConstants.Key.FORWARD_FILEPATH, this.filePath);
            bundle.putString(AppConstants.Key.FORWARD_THUMB, this.filePath);
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, this.filePath);
            bundle.putBoolean("key_flag_from_plugin", true);
            bundle.putString(AppConstants.Key.FORWARD_EXTRA, this.filePath);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(this.activity, intent, (Class<?>) ForwardRecentActivity.class, 21, -1, "");
        } catch (OutOfMemoryError unused) {
            E(1, R.string.f171047bz3);
        }
    }
}
