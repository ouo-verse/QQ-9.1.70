package com.tencent.robot.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.mainframe.api.IGuildJumpApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.robot.data.RobotInfo;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0006\"%)-H1B7\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010'\u001a\u00020\b\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\bF\u0010GJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J.\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u00060,R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u000600R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u000604R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u000608R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010?R\u001c\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010*R\u0018\u0010C\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010B\u00a8\u0006I"}, d2 = {"Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet;", "", "Landroid/view/View;", "view", "", "source", "", "p", "", "filePath", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "actionItem", DomainData.DOMAIN_NAME, "Landroid/graphics/Bitmap;", "preView", "Lkotlin/Function2;", "", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "j", "o", "curActivity", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lv44/g;", "l", "shareActionSheet", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "i", "t", "Lcom/tencent/robot/data/RobotInfo;", "a", "Lcom/tencent/robot/data/RobotInfo;", "robotInfo", "b", "Ljava/lang/String;", "subBusiness", "Lmqq/util/WeakReference;", "c", "Lmqq/util/WeakReference;", "activityRef", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$ShareItemClickListener;", "d", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$ShareItemClickListener;", "itemClickListener", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$b;", "e", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$b;", "cancelListener", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$d;", "f", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$d;", "dismissListener", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$e;", "g", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$e;", "showListener", tl.h.F, "Lv44/g;", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$a;", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$a;", "actionSheetListener", "parentView", "Landroid/graphics/Bitmap;", "preViewBitmap", HippyNestedScrollComponent.PRIORITY_PARENT, "listener", "<init>", "(Landroid/app/Activity;Landroid/view/View;Lcom/tencent/robot/data/RobotInfo;Ljava/lang/String;Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$a;)V", "ShareItemClickListener", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotQRCodePosterShareActionSheet {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotInfo robotInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String subBusiness;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Activity> activityRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShareItemClickListener itemClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b cancelListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d dismissListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e showListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private v44.g shareActionSheet;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a actionSheetListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<View> parentView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap preViewBitmap;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$ShareItemClickListener;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "w6", "<init>", "(Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class ShareItemClickListener implements ShareActionSheet.c {
        public ShareItemClickListener() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
        public void w6(@NotNull final View view, @NotNull final ShareActionSheetBuilder.ActionSheetItem item, @NotNull ShareActionSheet shareActionSheet) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
            Bitmap bitmap = RobotQRCodePosterShareActionSheet.this.preViewBitmap;
            if (bitmap != null) {
                final RobotQRCodePosterShareActionSheet robotQRCodePosterShareActionSheet = RobotQRCodePosterShareActionSheet.this;
                if (AppNetConnInfo.isNetSupport() || item.action == 39) {
                    robotQRCodePosterShareActionSheet.q(bitmap, new Function2<Boolean, String, Unit>() { // from class: com.tencent.robot.share.RobotQRCodePosterShareActionSheet$ShareItemClickListener$onItemClick$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                            invoke(bool.booleanValue(), str);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public final void invoke(boolean z16, @NotNull String filePath) {
                            WeakReference weakReference;
                            Intrinsics.checkNotNullParameter(filePath, "filePath");
                            if (z16 && !TextUtils.isEmpty(filePath)) {
                                weakReference = RobotQRCodePosterShareActionSheet.this.activityRef;
                                Activity activity = (Activity) weakReference.get();
                                if (activity == null) {
                                    return;
                                }
                                RobotQRCodePosterShareActionSheet.this.n(filePath, activity, view, item);
                                return;
                            }
                            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f222246d0, 0).show();
                            QLog.e("robot.share.RobotQRCodePosterShareActionSheet", 1, "savePosterToLocalCache error");
                        }
                    });
                } else {
                    QQToast.makeText(BaseApplication.getContext(), 1, R.string.f170632lk, 0).show();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$a;", "", "", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$b;", "Landroid/content/DialogInterface$OnCancelListener;", "Landroid/content/DialogInterface;", "dialog", "", "onCancel", "<init>", "(Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(@NotNull DialogInterface dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            RobotQRCodePosterShareActionSheet.this.j();
            RobotQRCodePosterShareActionSheet.this.preViewBitmap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$d;", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface;", "dialog", "", "onDismiss", "<init>", "(Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(@NotNull DialogInterface dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            RobotQRCodePosterShareActionSheet.this.j();
            RobotQRCodePosterShareActionSheet.this.preViewBitmap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$e;", "Landroid/content/DialogInterface$OnShowListener;", "Landroid/content/DialogInterface;", "dialog", "", "onShow", "<init>", "(Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class e implements DialogInterface.OnShowListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(@NotNull DialogInterface dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
        }
    }

    public RobotQRCodePosterShareActionSheet(@NotNull Activity activity, @Nullable View view, @NotNull RobotInfo robotInfo, @NotNull String subBusiness, @Nullable a aVar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        this.robotInfo = robotInfo;
        this.subBusiness = subBusiness;
        this.activityRef = new WeakReference<>(activity);
        this.itemClickListener = new ShareItemClickListener();
        this.cancelListener = new b();
        this.dismissListener = new d();
        this.showListener = new e();
        this.actionSheetListener = aVar;
        this.parentView = new WeakReference<>(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        a aVar = this.actionSheetListener;
        if (aVar != null) {
            aVar.b();
        }
        this.actionSheetListener = null;
    }

    private final void k() {
        a aVar = this.actionSheetListener;
        if (aVar != null) {
            aVar.a();
        }
    }

    private final v44.g l(Activity curActivity, Bitmap bitmap) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        curActivity.getIntent().putExtra("big_brother_source_key", "biz_src_qqagent");
        param.canceledOnTouchOutside = true;
        param.context = curActivity;
        param.fullScreen = true;
        HashMap hashMap = new HashMap();
        hashMap.put("agent_uin", String.valueOf(this.robotInfo.getRobotUin()));
        hashMap.put("sub_biz_source", this.subBusiness);
        param.deReportParams = hashMap;
        param.f317475lp = new ViewGroup.LayoutParams(-1, -2);
        v44.g gVar = new v44.g(16.0f, 16.0f, 16.0f, param);
        gVar.setItemClickListenerV3(this.itemClickListener);
        gVar.setOnDismissListener(this.dismissListener);
        gVar.setCancelListener(this.cancelListener);
        gVar.setOnShowListener(this.showListener);
        gVar.s0(bitmap);
        gVar.setRowVisibility(8, 0, 0);
        m(gVar);
        return gVar;
    }

    private final void m(v44.g shareActionSheet) {
        ArrayList arrayList = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(2);
        Intrinsics.checkNotNullExpressionValue(build, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_FRIEND)");
        arrayList.add(build);
        if (((IGuildJumpApi) QRoute.api(IGuildJumpApi.class)).isGuildUser()) {
            ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(171);
            Intrinsics.checkNotNullExpressionValue(build2, "build(ShareActionSheetBu\u2026m.ACTION_SEND_TO_CHANNEL)");
            arrayList.add(build2);
        }
        ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(3);
        Intrinsics.checkNotNullExpressionValue(build3, "build(ShareActionSheetBu\u2026tem.ACTION_SEND_TO_QZONE)");
        arrayList.add(build3);
        ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(9);
        Intrinsics.checkNotNullExpressionValue(build4, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_WECHAT)");
        arrayList.add(build4);
        ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(10);
        Intrinsics.checkNotNullExpressionValue(build5, "build(ShareActionSheetBu\u2026ON_SEND_TO_WECHAT_CIRCLE)");
        arrayList.add(build5);
        ArrayList arrayList2 = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(39);
        Intrinsics.checkNotNullExpressionValue(build6, "build(ShareActionSheetBu\u2026ionSheetItem.ACTION_SAVE)");
        arrayList2.add(build6);
        shareActionSheet.setActionSheetItems(arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String filePath, Activity activity, View view, ShareActionSheetBuilder.ActionSheetItem actionItem) {
        if (o(activity)) {
            QLog.e("robot.share.RobotQRCodePosterShareActionSheet", 1, "handleShare activity null");
            QQToast.makeText(activity, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
            return;
        }
        Bitmap bitmap = this.preViewBitmap;
        if (bitmap == null) {
            return;
        }
        f fVar = new f(activity, filePath, bitmap);
        int i3 = actionItem.action;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 9) {
                    if (i3 != 10) {
                        if (i3 != 39) {
                            if (i3 != 73) {
                                if (i3 != 171) {
                                    QLog.e("robot.share.RobotQRCodePosterShareActionSheet", 1, "handleShare illegal action, action=" + i3);
                                    QQToast.makeText(activity, "\u5206\u4eab\u7c7b\u578b\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
                                } else {
                                    f.l(fVar, actionItem, false, true, 2, null);
                                    p(view, 2);
                                }
                            }
                        } else {
                            fVar.f();
                            p(view, 8);
                        }
                    } else {
                        fVar.n(true);
                        p(view, 4);
                    }
                } else {
                    fVar.n(false);
                    p(view, 3);
                }
            } else {
                fVar.m("", "");
                p(view, 5);
            }
            i();
        }
        f.l(fVar, actionItem, false, false, 6, null);
        p(view, 1);
        i();
    }

    private final boolean o(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    private final void p(View view, int source) {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("share_source", String.valueOf(source)));
        VideoReport.setElementId(view, "em_share_item");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        View view2 = this.parentView.get();
        if (view2 != null) {
            VideoReport.setLogicParent(view, view2);
        }
        VideoReport.reportEvent("dt_clck", view, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final Bitmap preView, final Function2<? super Boolean, ? super String, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.share.a
            @Override // java.lang.Runnable
            public final void run() {
                RobotQRCodePosterShareActionSheet.r(preView, callback);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Bitmap preView, final Function2 function2) {
        Intrinsics.checkNotNullParameter(preView, "$preView");
        final String f16 = v44.c.f440966a.f("robot_temp_qrcode_poster_share.png", preView);
        if (f16 == null) {
            f16 = "";
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.robot.share.b
            @Override // java.lang.Runnable
            public final void run() {
                RobotQRCodePosterShareActionSheet.s(Function2.this, f16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function2 function2, String savePath) {
        Intrinsics.checkNotNullParameter(savePath, "$savePath");
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(!TextUtils.isEmpty(savePath)), savePath);
        }
    }

    public final void i() {
        v44.g gVar = this.shareActionSheet;
        if (gVar != null) {
            gVar.dismiss();
        }
    }

    public final void t(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        v44.g gVar = this.shareActionSheet;
        if (gVar != null) {
            gVar.s0(bitmap);
        }
        this.preViewBitmap = bitmap;
    }

    public final void u(@Nullable Bitmap bitmap) {
        v44.g gVar;
        Activity activity = this.activityRef.get();
        if (o(activity)) {
            QLog.e("robot.share.RobotQRCodePosterShareActionSheet", 1, "showActionSheet(), context null");
            return;
        }
        if (activity == null) {
            return;
        }
        v44.g l3 = l(activity, bitmap);
        this.shareActionSheet = l3;
        if (l3 != null) {
            l3.show();
        }
        this.preViewBitmap = bitmap;
        if (bitmap == null && (gVar = this.shareActionSheet) != null) {
            gVar.w0();
        }
        k();
    }
}
