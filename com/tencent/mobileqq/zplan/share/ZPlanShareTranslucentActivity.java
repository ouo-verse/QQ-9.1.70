package com.tencent.mobileqq.zplan.share;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.group.cover.SmallHomeCoverCropFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.event.WinkPublishInitializationCompletedEvent;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.z1.download.FileDownloadParams;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.mobileqq.zootopia.download.v;
import com.tencent.mobileqq.zootopia.view.z;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.share.ZPlanShareTranslucentActivity;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.state.event.SquareSharePosterEvent;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@QQPermissionConfig(id = QQPermissionConstants.Business.ID.ZPLAN_SHARE, scene = QQPermissionConstants.Business.SCENE.ZPLAN_SHARE)
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 X2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003YZ[B\u0007\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018H\u0002J\u0018\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018H\u0002J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\u0019\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b#\u0010!J\u0012\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$H\u0014J\b\u0010'\u001a\u00020\u0006H\u0014J\"\u0010+\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010)H\u0014J\b\u0010,\u001a\u00020\u0006H\u0016J\b\u0010-\u001a\u00020\u0006H\u0014J\u0012\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0003H\u0016J$\u00101\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0003000\u0016j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000300`\u0018H\u0016J\b\u00102\u001a\u00020\u0006H\u0014R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R*\u00109\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R*\u0010;\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010>\u001a\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/ZPlanShareTranslucentActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "success", "", Constants.BASE_IN_APP_NAME, "", WadlProxyConsts.CHANNEL, "t3", "", "uin", "path", "u3", "Lcom/tencent/mobileqq/zplan/share/e;", "shareParam", "x3", "i3", "h3", ICustomDataEditor.STRING_PARAM_3, "r3", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Lkotlin/collections/ArrayList;", "Z2", "b3", "fromAutoPublish", "d3", "e3", "c3", "action", "j3", "(I)Ljava/lang/Integer;", "requestCode", "l3", "Landroid/os/Bundle;", mqq.app.Constants.FILE_INSTANCE_STATE, "doOnCreate", "doOnResume", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "doOnActivityResult", "finish", "doOnStop", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "doOnDestroy", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", "a0", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "b0", "Ljava/util/ArrayList;", "actionItems", "c0", "operationItems", "Lcom/tencent/mobileqq/zootopia/view/z;", "d0", "Lkotlin/Lazy;", ICustomDataEditor.NUMBER_PARAM_3, "()Lcom/tencent/mobileqq/zootopia/view/z;", "littleWorldLoadingDialog", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "e0", "p3", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "Lcom/tencent/mobileqq/zplan/share/report/c;", "f0", "Lcom/tencent/mobileqq/zplan/share/report/c;", "bizReporter", "Lcom/tencent/mobileqq/zplan/share/action/b;", "g0", "Lcom/tencent/mobileqq/zplan/share/action/b;", "bizShareAction", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "h0", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "wxShareListener", "i0", "Z", "isShare", "<init>", "()V", "j0", "a", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanShareTranslucentActivity extends QBaseActivity implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ZPlanShareLaunchParam launchParam = new ZPlanShareLaunchParam(0, null, 0, null, null, null, null, null, null, null, false, null, 4095, null);

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> actionItems;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> operationItems;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final Lazy littleWorldLoadingDialog;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final Lazy qqPermission;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.share.report.c bizReporter;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.share.action.b bizShareAction;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private WXShareHelper.a wxShareListener;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean isShare;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J$\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/ZPlanShareTranslucentActivity$a;", "Landroid/widget/BaseAdapter;", "", "getCount", "position", "", "getItem", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "Landroid/widget/ListAdapter;", "d", "Landroid/widget/ListAdapter;", "getAdapter", "()Landroid/widget/ListAdapter;", "adapter", "<init>", "(Lcom/tencent/mobileqq/zplan/share/ZPlanShareTranslucentActivity;Landroid/widget/ListAdapter;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private final class a extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final ListAdapter adapter;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanShareTranslucentActivity f335466e;

        public a(ZPlanShareTranslucentActivity zPlanShareTranslucentActivity, ListAdapter adapter) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.f335466e = zPlanShareTranslucentActivity;
            this.adapter = adapter;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.adapter.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            Object item = this.adapter.getItem(position);
            Intrinsics.checkNotNullExpressionValue(item, "adapter.getItem(position)");
            return item;
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return this.adapter.getItemId(position);
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = this.adapter.getView(position, convertView, parent);
            ZPlanShareTranslucentActivity zPlanShareTranslucentActivity = this.f335466e;
            com.tencent.mobileqq.zplan.share.report.c cVar = zPlanShareTranslucentActivity.bizReporter;
            if (cVar != null) {
                Intrinsics.checkNotNullExpressionValue(view, "this@apply");
                cVar.c(zPlanShareTranslucentActivity, view, zPlanShareTranslucentActivity.launchParam);
            }
            Intrinsics.checkNotNullExpressionValue(view, "adapter.getView(position\u2026          )\n            }");
            return view;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/ZPlanShareTranslucentActivity$b;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", "param", "", "a", "", "KEY_LAUNCH_PARAMS", "Ljava/lang/String;", "", "LITTLE_WORLD_DIALOG_DISMISS_THRESHOLD", "J", "PEAK_PRELOAD_TIME", "", "REQUEST_CODE_PERMISSION", "I", "REQUEST_CODE_SHARE_TO_FRIEND_SELECT", "REQUEST_CODE_SHARE_TO_FRIEND_SPECIFIC", "REQUEST_CODE_SHARE_TO_GUILD", "REQUEST_CODE_SHARE_TO_LITTLE_WORLD", "REQUEST_CODE_SHARE_TO_QZONE", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.share.ZPlanShareTranslucentActivity$b, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, ZPlanShareLaunchParam param) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(param, "param");
            Intent intent = new Intent(context, (Class<?>) ZPlanShareTranslucentActivity.class);
            intent.putExtra("launch_params", param);
            context.startActivity(intent, ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle());
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J(\u0010\n\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\"\u0010\u000e\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/zplan/share/ZPlanShareTranslucentActivity$d", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "onDeniedWithoutShowDlg", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", "deniedPermissions", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZPlanShareParam f335467a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanShareTranslucentActivity f335468b;

        d(ZPlanShareParam zPlanShareParam, ZPlanShareTranslucentActivity zPlanShareTranslucentActivity) {
            this.f335467a = zPlanShareParam;
            this.f335468b = zPlanShareTranslucentActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ZPlanShareTranslucentActivity this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.finish();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "doRequestPermission onAllGranted");
            super.onAllGranted();
            ZPlanShareParam zPlanShareParam = this.f335467a;
            if (zPlanShareParam == null) {
                return;
            }
            this.f335468b.i3(zPlanShareParam);
            this.f335468b.t3(true, 3);
            this.f335468b.finish();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            super.onDenied(permissions, results);
            QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "doRequestPermission onDenied");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> permissions, List<Integer> results) {
            super.onDeniedWithoutShowDlg(permissions, results);
            QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "doRequestPermission onDeniedWithoutShowDlg");
            this.f335468b.D3(false);
            this.f335468b.finish();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog dialog, List<String> deniedPermissions) {
            super.onDialogShow(dialog, deniedPermissions);
            if (dialog != null) {
                final ZPlanShareTranslucentActivity zPlanShareTranslucentActivity = this.f335468b;
                dialog.setOnDisAllowClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.share.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ZPlanShareTranslucentActivity.d.b(ZPlanShareTranslucentActivity.this, view);
                    }
                });
            }
            QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "doRequestPermission onDialogShow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A3(ZPlanShareTranslucentActivity this$0, BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D3(baseResp.errCode == 0);
        this$0.t3(baseResp.errCode == 0, 8);
        int i3 = baseResp.errCode;
        this$0.isShare = i3 == 0;
        QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "shareImageToWX finish, errCode = " + i3 + ", errCode = " + baseResp.errStr);
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B3(ZPlanShareTranslucentActivity this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C3(ZPlanShareTranslucentActivity this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D3(final boolean success) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.share.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanShareTranslucentActivity.E3(success);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E3(boolean z16) {
        BaseApplication baseApplication = BaseApplication.context;
        QQToast.makeText(baseApplication, z16 ? 2 : 1, baseApplication.getString(z16 ? R.string.xus : R.string.xur), 0).show((int) TypedValue.applyDimension(1, 48.0f, baseApplication.getResources().getDisplayMetrics()));
    }

    private final ArrayList<ShareActionSheetBuilder.ActionSheetItem> Z2() {
        boolean contains;
        boolean contains2;
        boolean contains3;
        boolean contains4;
        boolean contains5;
        boolean contains6;
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        contains = ArraysKt___ArraysKt.contains((int[]) this.launchParam.getContentPlatform(), 0);
        if (contains) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        }
        contains2 = ArraysKt___ArraysKt.contains((int[]) this.launchParam.getContentPlatform(), 1);
        if (contains2) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        }
        contains3 = ArraysKt___ArraysKt.contains((int[]) this.launchParam.getContentPlatform(), 2);
        if (contains3) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        }
        contains4 = ArraysKt___ArraysKt.contains((int[]) this.launchParam.getContentPlatform(), 3);
        if (contains4) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        }
        contains5 = ArraysKt___ArraysKt.contains((int[]) this.launchParam.getContentPlatform(), 5);
        if (contains5) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(171));
        }
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        if (uq3.c.M6() || uq3.c.y6(studyModeSwitch) || uq3.c.x6(studyModeSwitch)) {
            contains6 = ArraysKt___ArraysKt.contains((int[]) this.launchParam.getContentPlatform(), 4);
            if (contains6) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(184));
            }
        }
        return arrayList;
    }

    private final ArrayList<ShareActionSheetBuilder.ActionSheetItem> b3() {
        boolean contains;
        boolean contains2;
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        contains = ArraysKt___ArraysKt.contains((int[]) this.launchParam.getOperationItems(), 1);
        if (contains && this.launchParam.getShareType() != 4) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        }
        contains2 = ArraysKt___ArraysKt.contains((int[]) this.launchParam.getOperationItems(), 2);
        if (contains2) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
        }
        if (this.launchParam.getShareType() == 1 && this.launchParam.getContentType() == 0) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(199));
        }
        return arrayList;
    }

    private final void c3() {
        try {
            if (n3().isShowing()) {
                n3().dismiss();
                QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "littleWorldLoadingDialog.dismiss()");
            }
            if (isFinishing()) {
                return;
            }
            finish();
        } catch (Exception e16) {
            QLog.e("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "dismissLittleWorldDialog error: " + e16);
        }
    }

    private final void e3(final ZPlanShareParam shareParam) {
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).preloadQQWink(this);
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.share.n
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanShareTranslucentActivity.f3(ZPlanShareTranslucentActivity.this, shareParam);
            }
        }, !((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(BaseApplication.context) ? 3000L : 0L);
        n3().show();
        QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "littleWorldLoadingDialog.show()");
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.share.o
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanShareTranslucentActivity.g3(ZPlanShareTranslucentActivity.this);
            }
        }, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f3(ZPlanShareTranslucentActivity this$0, ZPlanShareParam shareParam) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareParam, "$shareParam");
        com.tencent.mobileqq.zplan.share.d.f335534a.v(this$0, shareParam, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g3(ZPlanShareTranslucentActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "LITTLE_WORLD_DIALOG_DISMISS_THRESHOLD timeout, dismiss dialog!");
        this$0.c3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i3(ZPlanShareParam shareParam) {
        ZPlanFileCategory zPlanFileCategory;
        String str;
        ZPlanShareParam a16;
        if (shareParam.n()) {
            if (shareParam.getContentType() == 3) {
                zPlanFileCategory = ZPlanFileCategory.VIDEO;
            } else {
                zPlanFileCategory = ZPlanFileCategory.IMAGE;
            }
            int value = zPlanFileCategory.getValue();
            if (shareParam.getContentType() == 3) {
                str = "mp4";
            } else {
                str = "png";
            }
            String encodeHexStr = MD5Utils.encodeHexStr(shareParam.getPath());
            if (encodeHexStr == null) {
                encodeHexStr = shareParam.getPath();
            }
            String str2 = encodeHexStr + "." + str;
            QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "download File " + str2 + " " + shareParam.getContentType());
            final FileDownloadParams fileDownloadParams = new FileDownloadParams(value, shareParam.getPath(), null, null, str2, null, null, null, null, true, com.tencent.luggage.wxa.gf.i.CTRL_INDEX, null);
            File d16 = v.f328299a.d(fileDownloadParams);
            if (d16.exists() && d16.isFile()) {
                QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "file exist " + d16.getAbsolutePath() + " save to album");
                com.tencent.mobileqq.zplan.share.d dVar = com.tencent.mobileqq.zplan.share.d.f335534a;
                String absolutePath = d16.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                a16 = shareParam.a((r24 & 1) != 0 ? shareParam.contentType : 0, (r24 & 2) != 0 ? shareParam.path : absolutePath, (r24 & 4) != 0 ? shareParam.width : 0, (r24 & 8) != 0 ? shareParam.height : 0, (r24 & 16) != 0 ? shareParam.duration : 0, (r24 & 32) != 0 ? shareParam.requestCode : 0, (r24 & 64) != 0 ? shareParam.thumbPath : null, (r24 & 128) != 0 ? shareParam.title : null, (r24 & 256) != 0 ? shareParam.desc : null, (r24 & 512) != 0 ? shareParam.directMessage : null, (r24 & 1024) != 0 ? shareParam.shareExtraParams : null);
                dVar.r(a16);
                return;
            }
            FileDownloadManager.f328148a.l(fileDownloadParams, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.share.ZPlanShareTranslucentActivity$downloadAndSaveFile$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FileDownloadManager.f328148a.y(FileDownloadParams.this);
                }
            });
            return;
        }
        com.tencent.mobileqq.zplan.share.d.f335534a.r(shareParam);
    }

    private final z n3() {
        return (z) this.littleWorldLoadingDialog.getValue();
    }

    private final QQPermission p3() {
        Object value = this.qqPermission.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-qqPermission>(...)");
        return (QQPermission) value;
    }

    private final void u3(final String uin, final String path) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.share.g
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanShareTranslucentActivity.v3(ZPlanShareTranslucentActivity.this, path, uin);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v3(final ZPlanShareTranslucentActivity this$0, String path, final String str) {
        boolean endsWith$default;
        final ZPlanShareParam m3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "fileThread Handler execute ");
        if (this$0.launchParam.getContentType() == 0) {
            m3 = com.tencent.mobileqq.zplan.share.d.f335534a.g(path, this$0.launchParam.getShareExtraParams());
        } else if (this$0.launchParam.getContentType() == 1) {
            m3 = com.tencent.mobileqq.zplan.share.d.f335534a.m(path, this$0.launchParam.getShareExtraParams());
        } else if (this$0.launchParam.getContentType() == 4) {
            m3 = s.f335583a.a(path, this$0.launchParam.getShareExtraParams());
        } else if (!this$0.launchParam.isARKType()) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(path, ".png", false, 2, null);
            if (endsWith$default) {
                m3 = com.tencent.mobileqq.zplan.share.d.f335534a.g(path, this$0.launchParam.getShareExtraParams());
            } else {
                m3 = com.tencent.mobileqq.zplan.share.d.f335534a.m(path, this$0.launchParam.getShareExtraParams());
            }
        } else {
            m3 = com.tencent.mobileqq.zplan.share.d.f335534a.f(path, this$0.launchParam);
        }
        this$0.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.share.h
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanShareTranslucentActivity.w3(ZPlanShareTranslucentActivity.this, m3, str);
            }
        });
    }

    private final void x3(final ZPlanShareParam shareParam) {
        QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "showSharePanel ");
        if (com.tencent.sqshow.zootopia.samestyle.b.f372897a.i(shareParam.j())) {
            d3(shareParam, true);
            return;
        }
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = this;
        if (!this.launchParam.getNeedMask()) {
            param.dimAmount = -1.0f;
        }
        c cVar = new c(this, param);
        this.actionItems = Z2();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> b36 = b3();
        this.operationItems = b36;
        cVar.setActionSheetItems(this.actionItems, b36);
        Intent intent = getIntent();
        if (intent == null) {
            intent = new Intent();
        } else {
            Intrinsics.checkNotNullExpressionValue(intent, "intent ?: Intent()");
        }
        intent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
        cVar.setIntentForStartForwardRecentActivity(intent);
        cVar.setRowVisibility(0, 0, 0);
        cVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.zplan.share.i
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ZPlanShareTranslucentActivity.B3(ZPlanShareTranslucentActivity.this, dialogInterface);
            }
        });
        cVar.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.zplan.share.j
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ZPlanShareTranslucentActivity.C3(ZPlanShareTranslucentActivity.this, dialogInterface);
            }
        });
        cVar.t0(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.mobileqq.zplan.share.k
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                ZPlanShareTranslucentActivity.y3(ZPlanShareTranslucentActivity.this, shareParam, actionSheetItem, shareActionSheet);
            }
        });
        cVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z3(ZPlanShareTranslucentActivity this$0, BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D3(baseResp.errCode == 0);
        this$0.t3(baseResp.errCode == 0, 7);
        int i3 = baseResp.errCode;
        this$0.isShare = i3 == 0;
        QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "shareImageToWX finish, errCode = " + i3 + ", errCode = " + baseResp.errStr);
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:
    
        if (r6.intValue() != 1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        if (r6 == (-1)) goto L21;
     */
    @Override // mqq.app.AppActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doOnActivityResult(int requestCode, int resultCode, Intent data) {
        boolean z16 = true;
        QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "activity result " + requestCode + ProgressTracer.SEPARATOR + resultCode);
        super.doOnActivityResult(requestCode, resultCode, data);
        Integer l3 = l3(requestCode);
        if (l3 != null) {
            int intValue = l3.intValue();
            this.isShare = resultCode == -1;
            if (intValue == 1) {
                Integer valueOf = data != null ? Integer.valueOf(data.getIntExtra("PUBLISH_RESULT_CODE", 0)) : null;
                if (valueOf != null) {
                }
                z16 = false;
            }
            if (z16 && !this.launchParam.isARKType()) {
                D3(z16);
            }
            t3(z16, intValue);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle savedInstanceState) {
        super.doOnCreate(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        Serializable serializableExtra = getIntent().getSerializableExtra("launch_params");
        ZPlanShareLaunchParam zPlanShareLaunchParam = serializableExtra instanceof ZPlanShareLaunchParam ? (ZPlanShareLaunchParam) serializableExtra : null;
        if (zPlanShareLaunchParam == null) {
            com.tencent.sqshow.zootopia.utils.v.f373305a.c(R.string.xdv, "\u5206\u4eab\u53c2\u6570\u4e3a\u7a7a\u6216\u8005\u5206\u4eab\u5185\u5bb9\u4e3a\u7a7a");
            finish();
            return true;
        }
        zPlanShareLaunchParam.setShareExtraParams(com.tencent.sqshow.zootopia.samestyle.b.f372897a.f(zPlanShareLaunchParam.getShareExtraParams()));
        this.launchParam = zPlanShareLaunchParam;
        com.tencent.mobileqq.zplan.share.action.b b16 = com.tencent.mobileqq.zplan.share.action.b.INSTANCE.b(zPlanShareLaunchParam.getShareType(), this.launchParam.getReportExtraParams());
        this.bizShareAction = b16;
        this.bizReporter = b16 != null ? b16.a() : null;
        QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "doOnCreate, extraParams = " + this.launchParam.getShareExtraParams());
        u3(this.launchParam.getUin(), this.launchParam.getContentPath());
        com.tencent.mobileqq.zplan.share.action.b bVar = this.bizShareAction;
        if (bVar != null) {
            bVar.c(this.launchParam);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        WXShareHelper.b0().q0(this.wxShareListener);
        com.tencent.mobileqq.zplan.share.action.b bVar = this.bizShareAction;
        if (bVar != null) {
            bVar.onDestroy();
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(this);
        if (systemBarComp != null) {
            systemBarComp.setStatusBarColor(0);
        }
        com.tencent.mobileqq.zplan.share.action.b bVar = this.bizShareAction;
        if (bVar != null) {
            bVar.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        SimpleEventBus.getInstance().dispatchEvent(new SquareSharePosterEvent(this.isShare));
        com.tencent.mobileqq.zplan.share.action.b bVar = this.bizShareAction;
        if (bVar != null) {
            bVar.onFinish();
        }
        QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "share translucent activity finish ");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof WinkPublishInitializationCompletedEvent) {
            QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "WinkPublishInitializationCompletedEvent onReceiveEvent");
            c3();
        }
    }

    private final void h3(ZPlanShareParam shareParam) {
        QLog.e("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "doRequestPermission");
        p3().requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new d(shareParam, this));
    }

    private final void r3() {
        QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "share canceled by click action sheet cancel button");
        finish();
    }

    private final void s3() {
        QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "share canceled by touch outside of action sheet");
        finish();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WinkPublishInitializationCompletedEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J0\u0010\u0010\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/ZPlanShareTranslucentActivity$c;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "Landroid/widget/AdapterView$OnItemClickListener;", "Landroid/content/Context;", "context", "", "q0", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "view", "", "position", "", "id", "onItemClick", "show", "Ljava/lang/Exception;", "e", "N", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "J0", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "getMItemClickListener", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "t0", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;)V", "mItemClickListener", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;", "param", "<init>", "(Lcom/tencent/mobileqq/zplan/share/ZPlanShareTranslucentActivity;Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class c extends ShareActionSheetV2 implements AdapterView.OnItemClickListener {

        /* renamed from: J0, reason: from kotlin metadata */
        private ShareActionSheet.OnItemClickListener mItemClickListener;
        final /* synthetic */ ZPlanShareTranslucentActivity K0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ZPlanShareTranslucentActivity zPlanShareTranslucentActivity, ShareActionSheetV2.Param param) {
            super(param);
            Intrinsics.checkNotNullParameter(param, "param");
            this.K0 = zPlanShareTranslucentActivity;
        }

        private final void q0(final Context context) {
            LinearLayout linearLayout = this.N;
            if (linearLayout != null) {
                linearLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.share.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanShareTranslucentActivity.c.r0(context, this);
                    }
                }, 600L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r0(Context context, c this$0) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int b16 = context.getResources().getConfiguration().orientation == 2 ? com.tencent.sqshow.zootopia.utils.i.b(15) : 0;
            LinearLayout linearLayout = this$0.N;
            if (linearLayout != null) {
                linearLayout.setPadding(0, b16, 0, 0);
            }
            QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "adjustTopPadding: " + b16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s0(c this$0, ZPlanShareTranslucentActivity this$1, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "cancel click");
            if (this$0.F.isShowing()) {
                this$0.F.cancel();
                this$0.F.dismiss();
            }
            com.tencent.mobileqq.zplan.share.report.c cVar = this$1.bizReporter;
            if (cVar != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                cVar.f(it, this$1.launchParam);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2
        public View C() {
            ListAdapter adapter;
            ListAdapter adapter2;
            ListAdapter adapter3;
            View C = super.C();
            if (C == null) {
                return null;
            }
            final ZPlanShareTranslucentActivity zPlanShareTranslucentActivity = this.K0;
            com.tencent.mobileqq.zplan.share.report.c cVar = zPlanShareTranslucentActivity.bizReporter;
            if (cVar != null) {
                View rootView = C.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                cVar.c(zPlanShareTranslucentActivity, rootView, zPlanShareTranslucentActivity.launchParam);
            }
            com.tencent.mobileqq.zplan.share.report.c cVar2 = zPlanShareTranslucentActivity.bizReporter;
            if (cVar2 != null) {
                ImageView cancel = this.P;
                Intrinsics.checkNotNullExpressionValue(cancel, "cancel");
                cVar2.a(cancel, zPlanShareTranslucentActivity.launchParam);
            }
            com.tencent.mobileqq.zplan.share.report.c cVar3 = zPlanShareTranslucentActivity.bizReporter;
            if (cVar3 != null) {
                ImageView cancel2 = this.P;
                Intrinsics.checkNotNullExpressionValue(cancel2, "cancel");
                cVar3.b(cancel2, zPlanShareTranslucentActivity.launchParam);
            }
            QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "init cancel click");
            this.P.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.share.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanShareTranslucentActivity.c.s0(ZPlanShareTranslucentActivity.c.this, zPlanShareTranslucentActivity, view);
                }
            });
            ArrayList arrayList = zPlanShareTranslucentActivity.actionItems;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Integer j3 = zPlanShareTranslucentActivity.j3(((ShareActionSheetBuilder.ActionSheetItem) it.next()).action);
                    if (j3 != null) {
                        int intValue = j3.intValue();
                        com.tencent.mobileqq.zplan.share.report.c cVar4 = zPlanShareTranslucentActivity.bizReporter;
                        if (cVar4 != null) {
                            cVar4.e(intValue, zPlanShareTranslucentActivity.launchParam);
                        }
                    }
                }
            }
            ArrayList arrayList2 = zPlanShareTranslucentActivity.operationItems;
            if (arrayList2 != null) {
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    Integer j36 = zPlanShareTranslucentActivity.j3(((ShareActionSheetBuilder.ActionSheetItem) it5.next()).action);
                    if (j36 != null) {
                        int intValue2 = j36.intValue();
                        com.tencent.mobileqq.zplan.share.report.c cVar5 = zPlanShareTranslucentActivity.bizReporter;
                        if (cVar5 != null) {
                            cVar5.e(intValue2, zPlanShareTranslucentActivity.launchParam);
                        }
                    }
                }
            }
            GridView gridView = this.f317441l0;
            if (gridView != null && (adapter3 = gridView.getAdapter()) != null) {
                Intrinsics.checkNotNullExpressionValue(adapter3, "adapter");
                GridView gridView2 = this.f317441l0;
                if (gridView2 != null) {
                    gridView2.setAdapter((ListAdapter) new a(zPlanShareTranslucentActivity, adapter3));
                }
                GridView gridView3 = this.f317441l0;
                if (gridView3 != null) {
                    gridView3.setOnItemClickListener(this);
                }
            }
            GridView gridView4 = this.f317443m0;
            if (gridView4 != null && (adapter2 = gridView4.getAdapter()) != null) {
                Intrinsics.checkNotNullExpressionValue(adapter2, "adapter");
                GridView gridView5 = this.f317443m0;
                if (gridView5 != null) {
                    gridView5.setAdapter((ListAdapter) new a(zPlanShareTranslucentActivity, adapter2));
                }
                GridView gridView6 = this.f317443m0;
                if (gridView6 != null) {
                    gridView6.setOnItemClickListener(this);
                }
            }
            GridView gridView7 = this.f317444n0;
            if (gridView7 != null && (adapter = gridView7.getAdapter()) != null) {
                Intrinsics.checkNotNullExpressionValue(adapter, "adapter");
                GridView gridView8 = this.f317444n0;
                if (gridView8 != null) {
                    gridView8.setAdapter((ListAdapter) new a(zPlanShareTranslucentActivity, adapter));
                }
                GridView gridView9 = this.f317444n0;
                if (gridView9 != null) {
                    gridView9.setOnItemClickListener(this);
                }
            }
            Context context = C.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            q0(context);
            return C;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2
        public void N(Exception e16) {
            super.N(e16);
            QLog.e("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "show Dialog Error " + e16);
            this.K0.finish();
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2, com.tencent.mobileqq.widget.share.ShareActionSheet
        public void show() {
            super.show();
            QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "show ");
            VideoReport.traversePage(this.G);
        }

        public final void t0(ShareActionSheet.OnItemClickListener onItemClickListener) {
            this.mItemClickListener = onItemClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id5) {
            Object tag = view != null ? view.getTag() : null;
            ShareActionSheetBuilder.c cVar = tag instanceof ShareActionSheetBuilder.c ? (ShareActionSheetBuilder.c) tag : null;
            if (cVar == null) {
                return;
            }
            ShareActionSheetBuilder.ActionSheetItem actionSheetItem = cVar.f307311e;
            ShareActionSheet.OnItemClickListener onItemClickListener = this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(actionSheetItem, this);
            }
            Integer j3 = this.K0.j3(actionSheetItem.action);
            if (j3 != null) {
                int intValue = j3.intValue();
                com.tencent.mobileqq.zplan.share.report.c cVar2 = this.K0.bizReporter;
                if (cVar2 != null) {
                    cVar2.g(intValue, this.K0.launchParam);
                }
            }
        }
    }

    public ZPlanShareTranslucentActivity() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<z>() { // from class: com.tencent.mobileqq.zplan.share.ZPlanShareTranslucentActivity$littleWorldLoadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final z invoke() {
                return new z(ZPlanShareTranslucentActivity.this, false, false, 6, null);
            }
        });
        this.littleWorldLoadingDialog = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QQPermission>() { // from class: com.tencent.mobileqq.zplan.share.ZPlanShareTranslucentActivity$qqPermission$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQPermission invoke() {
                return QQPermissionFactory.getQQPermission(ZPlanShareTranslucentActivity.this);
            }
        });
        this.qqPermission = lazy2;
    }

    private final void d3(ZPlanShareParam shareParam, boolean fromAutoPublish) {
        ZPlanShareParam a16;
        QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "send video to little world, fromAutoPublish = " + fromAutoPublish);
        com.tencent.mobileqq.zplan.share.d.f335534a.d(this, shareParam, this.launchParam);
        a16 = shareParam.a((r24 & 1) != 0 ? shareParam.contentType : 0, (r24 & 2) != 0 ? shareParam.path : null, (r24 & 4) != 0 ? shareParam.width : 0, (r24 & 8) != 0 ? shareParam.height : 0, (r24 & 16) != 0 ? shareParam.duration : 0, (r24 & 32) != 0 ? shareParam.requestCode : 259, (r24 & 64) != 0 ? shareParam.thumbPath : null, (r24 & 128) != 0 ? shareParam.title : null, (r24 & 256) != 0 ? shareParam.desc : null, (r24 & 512) != 0 ? shareParam.directMessage : null, (r24 & 1024) != 0 ? shareParam.shareExtraParams : null);
        e3(a16);
        t3(true, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t3(boolean success, int channel) {
        com.tencent.mobileqq.zplan.share.report.c cVar;
        if (success && (cVar = this.bizReporter) != null) {
            cVar.d(channel, this.launchParam);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w3(ZPlanShareTranslucentActivity this$0, ZPlanShareParam zPlanShareParam, String str) {
        ZPlanShareParam a16;
        ZPlanShareParam a17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        if (this$0.isFinishing()) {
            QLog.d("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "activity is isFinishing ");
            return;
        }
        if (zPlanShareParam == null) {
            QLog.e("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "shareParams is null, share fail");
            com.tencent.sqshow.zootopia.utils.v.f373305a.c(R.string.xdv, "shareParams");
            this$0.finish();
            return;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            this$0.x3(zPlanShareParam);
            return;
        }
        if (this$0.launchParam.getShareType() == 8) {
            com.tencent.mobileqq.zplan.share.action.b bVar = this$0.bizShareAction;
            if (bVar != null) {
                a17 = zPlanShareParam.a((r24 & 1) != 0 ? zPlanShareParam.contentType : 0, (r24 & 2) != 0 ? zPlanShareParam.path : null, (r24 & 4) != 0 ? zPlanShareParam.width : 0, (r24 & 8) != 0 ? zPlanShareParam.height : 0, (r24 & 16) != 0 ? zPlanShareParam.duration : 0, (r24 & 32) != 0 ? zPlanShareParam.requestCode : 256, (r24 & 64) != 0 ? zPlanShareParam.thumbPath : null, (r24 & 128) != 0 ? zPlanShareParam.title : null, (r24 & 256) != 0 ? zPlanShareParam.desc : null, (r24 & 512) != 0 ? zPlanShareParam.directMessage : null, (r24 & 1024) != 0 ? zPlanShareParam.shareExtraParams : null);
                bVar.d(this$0, a17, 0, str);
                return;
            }
            return;
        }
        int i3 = this$0.launchParam.getShareType() == 2 ? 256 : 257;
        com.tencent.mobileqq.zplan.share.d dVar = com.tencent.mobileqq.zplan.share.d.f335534a;
        Integer uinType = this$0.launchParam.getUinType();
        int intValue = uinType != null ? uinType.intValue() : -1;
        a16 = zPlanShareParam.a((r24 & 1) != 0 ? zPlanShareParam.contentType : 0, (r24 & 2) != 0 ? zPlanShareParam.path : null, (r24 & 4) != 0 ? zPlanShareParam.width : 0, (r24 & 8) != 0 ? zPlanShareParam.height : 0, (r24 & 16) != 0 ? zPlanShareParam.duration : 0, (r24 & 32) != 0 ? zPlanShareParam.requestCode : i3, (r24 & 64) != 0 ? zPlanShareParam.thumbPath : null, (r24 & 128) != 0 ? zPlanShareParam.title : null, (r24 & 256) != 0 ? zPlanShareParam.desc : null, (r24 & 512) != 0 ? zPlanShareParam.directMessage : null, (r24 & 1024) != 0 ? zPlanShareParam.shareExtraParams : null);
        dVar.w(this$0, intValue, str, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r15v12 */
    public static final void y3(final ZPlanShareTranslucentActivity this$0, ZPlanShareParam shareParam, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        ZPlanShareParam a16;
        ZPlanShareParam a17;
        ZPlanShareParam a18;
        ZPlanShareParam a19;
        String str;
        ZPlanShareParam a26;
        String str2;
        ?? r152;
        ZPlanShareParam a27;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareParam, "$shareParam");
        int i3 = actionSheetItem.action;
        if (i3 != 1) {
            Unit unit = null;
            if (i3 != 2) {
                if (i3 == 3) {
                    com.tencent.mobileqq.zplan.share.action.b bVar = this$0.bizShareAction;
                    if (bVar != null) {
                        a17 = shareParam.a((r24 & 1) != 0 ? shareParam.contentType : 0, (r24 & 2) != 0 ? shareParam.path : null, (r24 & 4) != 0 ? shareParam.width : 0, (r24 & 8) != 0 ? shareParam.height : 0, (r24 & 16) != 0 ? shareParam.duration : 0, (r24 & 32) != 0 ? shareParam.requestCode : 258, (r24 & 64) != 0 ? shareParam.thumbPath : null, (r24 & 128) != 0 ? shareParam.title : null, (r24 & 256) != 0 ? shareParam.desc : null, (r24 & 512) != 0 ? shareParam.directMessage : null, (r24 & 1024) != 0 ? shareParam.shareExtraParams : null);
                        bVar.f(this$0, a17, this$0.launchParam);
                    }
                } else if (i3 == 6) {
                    this$0.finish();
                } else if (i3 == 39) {
                    QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "save video to local gallery");
                    if (this$0.p3().hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
                        this$0.i3(shareParam);
                        this$0.t3(true, 3);
                        this$0.finish();
                    } else {
                        this$0.h3(shareParam);
                    }
                } else if (i3 == 171) {
                    com.tencent.mobileqq.zplan.share.action.b bVar2 = this$0.bizShareAction;
                    if (bVar2 != null) {
                        a18 = shareParam.a((r24 & 1) != 0 ? shareParam.contentType : 0, (r24 & 2) != 0 ? shareParam.path : null, (r24 & 4) != 0 ? shareParam.width : 0, (r24 & 8) != 0 ? shareParam.height : 0, (r24 & 16) != 0 ? shareParam.duration : 0, (r24 & 32) != 0 ? shareParam.requestCode : 260, (r24 & 64) != 0 ? shareParam.thumbPath : null, (r24 & 128) != 0 ? shareParam.title : null, (r24 & 256) != 0 ? shareParam.desc : null, (r24 & 512) != 0 ? shareParam.directMessage : null, (r24 & 1024) != 0 ? shareParam.shareExtraParams : null);
                        bVar2.b(this$0, a18);
                    }
                } else if (i3 == 184) {
                    this$0.d3(shareParam, false);
                } else if (i3 == 72) {
                    com.tencent.mobileqq.zplan.share.action.b bVar3 = this$0.bizShareAction;
                    if (bVar3 != null) {
                        a19 = shareParam.a((r24 & 1) != 0 ? shareParam.contentType : 0, (r24 & 2) != 0 ? shareParam.path : null, (r24 & 4) != 0 ? shareParam.width : 0, (r24 & 8) != 0 ? shareParam.height : 0, (r24 & 16) != 0 ? shareParam.duration : 0, (r24 & 32) != 0 ? shareParam.requestCode : 256, (r24 & 64) != 0 ? shareParam.thumbPath : null, (r24 & 128) != 0 ? shareParam.title : null, (r24 & 256) != 0 ? shareParam.desc : null, (r24 & 512) != 0 ? shareParam.directMessage : null, (r24 & 1024) != 0 ? shareParam.shareExtraParams : null);
                        bVar3.d(this$0, a19, actionSheetItem.uinType, actionSheetItem.uin);
                    }
                } else if (i3 != 73) {
                    if (i3 == 199) {
                        String p16 = com.tencent.mobileqq.zplan.share.d.f335534a.p(this$0.launchParam);
                        if (p16 != null) {
                            ((IZPlanApi) QRoute.api(IZPlanApi.class)).setZPlanBackgroundImage(this$0, p16);
                            this$0.t3(true, 4);
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            this$0.D3(false);
                        }
                        this$0.finish();
                    } else if (i3 != 200) {
                        switch (i3) {
                            case 9:
                                this$0.wxShareListener = new WXShareHelper.a() { // from class: com.tencent.mobileqq.zplan.share.l
                                    @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                                    public final void onWXShareResp(BaseResp baseResp) {
                                        ZPlanShareTranslucentActivity.z3(ZPlanShareTranslucentActivity.this, baseResp);
                                    }
                                };
                                com.tencent.mobileqq.zplan.share.action.b bVar4 = this$0.bizShareAction;
                                if (bVar4 != null) {
                                    str = "ZPlanSameStyle_ZPlanShareTranslucentActivity";
                                    a26 = shareParam.a((r24 & 1) != 0 ? shareParam.contentType : 0, (r24 & 2) != 0 ? shareParam.path : null, (r24 & 4) != 0 ? shareParam.width : 0, (r24 & 8) != 0 ? shareParam.height : 0, (r24 & 16) != 0 ? shareParam.duration : 0, (r24 & 32) != 0 ? shareParam.requestCode : 256, (r24 & 64) != 0 ? shareParam.thumbPath : null, (r24 & 128) != 0 ? shareParam.title : null, (r24 & 256) != 0 ? shareParam.desc : null, (r24 & 512) != 0 ? shareParam.directMessage : null, (r24 & 1024) != 0 ? shareParam.shareExtraParams : null);
                                    bVar4.e(this$0, a26, this$0.wxShareListener, true);
                                } else {
                                    str = "ZPlanSameStyle_ZPlanShareTranslucentActivity";
                                }
                                this$0.isShare = true;
                                QLog.i(str, 1, "onClick: share to wx friend.");
                                break;
                            case 10:
                                this$0.wxShareListener = new WXShareHelper.a() { // from class: com.tencent.mobileqq.zplan.share.m
                                    @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                                    public final void onWXShareResp(BaseResp baseResp) {
                                        ZPlanShareTranslucentActivity.A3(ZPlanShareTranslucentActivity.this, baseResp);
                                    }
                                };
                                com.tencent.mobileqq.zplan.share.action.b bVar5 = this$0.bizShareAction;
                                if (bVar5 != null) {
                                    str2 = "ZPlanSameStyle_ZPlanShareTranslucentActivity";
                                    a27 = shareParam.a((r24 & 1) != 0 ? shareParam.contentType : 0, (r24 & 2) != 0 ? shareParam.path : null, (r24 & 4) != 0 ? shareParam.width : 0, (r24 & 8) != 0 ? shareParam.height : 0, (r24 & 16) != 0 ? shareParam.duration : 0, (r24 & 32) != 0 ? shareParam.requestCode : 256, (r24 & 64) != 0 ? shareParam.thumbPath : null, (r24 & 128) != 0 ? shareParam.title : null, (r24 & 256) != 0 ? shareParam.desc : null, (r24 & 512) != 0 ? shareParam.directMessage : null, (r24 & 1024) != 0 ? shareParam.shareExtraParams : null);
                                    bVar5.e(this$0, a27, this$0.wxShareListener, false);
                                    r152 = 1;
                                } else {
                                    str2 = "ZPlanSameStyle_ZPlanShareTranslucentActivity";
                                    r152 = 1;
                                }
                                this$0.isShare = r152;
                                QLog.i(str2, r152, "onClick: share to wx circle.");
                                break;
                            case 11:
                                this$0.finish();
                                break;
                        }
                    } else {
                        QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "save as smallHome background");
                        Intent intent = new Intent();
                        intent.putExtra("path", shareParam.getPath());
                        this$0.t3(true, 5);
                        QPublicFragmentActivity.start(this$0, intent, SmallHomeCoverCropFragment.class);
                        this$0.finish();
                    }
                }
            }
            com.tencent.mobileqq.zplan.share.action.b bVar6 = this$0.bizShareAction;
            if (bVar6 != null) {
                a16 = shareParam.a((r24 & 1) != 0 ? shareParam.contentType : 0, (r24 & 2) != 0 ? shareParam.path : null, (r24 & 4) != 0 ? shareParam.width : 0, (r24 & 8) != 0 ? shareParam.height : 0, (r24 & 16) != 0 ? shareParam.duration : 0, (r24 & 32) != 0 ? shareParam.requestCode : 257, (r24 & 64) != 0 ? shareParam.thumbPath : null, (r24 & 128) != 0 ? shareParam.title : null, (r24 & 256) != 0 ? shareParam.desc : null, (r24 & 512) != 0 ? shareParam.directMessage : null, (r24 & 1024) != 0 ? shareParam.shareExtraParams : null);
                bVar6.d(this$0, a16, -1, null);
            }
        } else {
            QLog.i("ZPlanSameStyle_ZPlanShareTranslucentActivity", 1, "copy path to clipboard");
            Object systemService = this$0.getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.text.ClipboardManager");
            ((ClipboardManager) systemService).setText(shareParam.getDirectMessage());
            this$0.t3(true, 10);
            QQToastUtil.showQQToast(2, "\u5df2\u590d\u5236\u5230\u526a\u8d34\u677f");
            this$0.finish();
        }
        shareActionSheet.dismiss();
    }

    private final Integer l3(int requestCode) {
        switch (requestCode) {
            case 256:
                return Integer.valueOf((this.launchParam.getShareType() == 3 || this.launchParam.getShareType() == 5 || this.launchParam.getShareType() == 7) ? 6 : 0);
            case 257:
                return 0;
            case 258:
                return 1;
            case 259:
            default:
                return null;
            case 260:
                return 9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer j3(int action) {
        if (action == 2) {
            return 0;
        }
        if (action == 3) {
            return 1;
        }
        if (action == 9) {
            return 7;
        }
        if (action == 10) {
            return 8;
        }
        if (action == 39) {
            return 3;
        }
        if (action == 184) {
            return 2;
        }
        if (action != 199) {
            return action != 200 ? null : 5;
        }
        return 4;
    }
}
