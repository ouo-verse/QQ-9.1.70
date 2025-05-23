package com.tencent.robot.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOActivityResultEvent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.MsgForwardEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.event.e;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOFavApi;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.aio.robot.api.IRobotAIOFavApi;
import com.tencent.robot.aio.share.RobotSessionShareActionExecutor;
import com.tencent.robot.aio.share.RobotSessionShareInfo;
import com.tencent.robot.aio.share.RobotSessionShareParams;
import com.tencent.robot.aio.share.ShareStatus;
import com.tencent.robot.aio.share.event.RobotMultiShareMsgFromBar;
import com.tencent.robot.aio.share.util.MsgCheckResult;
import com.tencent.robot.aio.share.util.RobotMsgCheckResult;
import com.tencent.robot.aio.share.util.RobotMsgExtKt;
import com.tencent.robot.aio.share.util.RobotMsgPreCheckResult;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0002^_B\u0007\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u001e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u001e\u0010#\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J\u001e\u0010&\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010%\u001a\u00020$H\u0002J:\u0010+\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010(\u001a\u00020'2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040)H\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0004H\u0002J.\u00101\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00100\u001a\u00020$H\u0002J\"\u00106\u001a\u00020\u00042\u0006\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020'2\b\u00105\u001a\u0004\u0018\u000104H\u0002J\b\u00107\u001a\u00020\u0004H\u0002J\b\u00108\u001a\u00020\u0004H\u0002J\u0010\u0010;\u001a\u00020\n2\u0006\u0010:\u001a\u000209H\u0002J\b\u0010<\u001a\u00020\nH\u0002J\u0010\u0010=\u001a\u00020\n2\u0006\u0010:\u001a\u000209H\u0002J\b\u0010>\u001a\u00020'H\u0016J\b\u0010?\u001a\u00020\fH\u0016J\b\u0010A\u001a\u00020@H\u0016J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020'H\u0016J\u0010\u0010E\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020DH\u0016J\b\u0010F\u001a\u00020\u0004H\u0016R\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001c\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010Z\u00a8\u0006`"}, d2 = {"Lcom/tencent/robot/aio/helper/RobotShareSessionHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "v", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msg", "L", "J", "", "isSelectMode", "", "source", "E", "N", "I", "", "u", "Lcom/tencent/robot/aio/share/RobotSessionShareParams;", "param", "B", TabPreloadItem.TAB_NAME_MESSAGE, "G", BdhLogUtil.LogTag.Tag_Req, "M", "", "robotUin", "H", "Lcom/tencent/mobileqq/aio/event/LongShotMsgIntent$OnShotFinish;", "intent", "K", "Lcom/tencent/mobileqq/aio/event/RobotMsgIntent$RobotMultiFavClickEvent;", BdhLogUtil.LogTag.Tag_Conn, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/robot/aio/share/RobotSessionShareInfo;", "robotSessionShareInfo", HippyTKDListViewAdapter.X, "", "type", "Lkotlin/Function1;", "onSuccess", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "info", "P", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", UserInfo.SEX_FEMALE, "r", ExifInterface.LATITUDE_SOUTH, "Landroid/content/Context;", "context", "t", "O", ReportConstant.COSTREPORT_PREFIX, "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mContext", "e", "Ljava/lang/String;", "Lcom/tencent/robot/aio/share/c;", "f", "Lcom/tencent/robot/aio/share/c;", "shareDialog", "Lcom/tencent/mvi/base/route/a;", tl.h.F, "Lcom/tencent/mvi/base/route/a;", "mAction", "i", "Ljava/util/List;", "messengerList", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "loadingDialog", "<init>", "()V", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotShareSessionHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.robot.aio.share.c shareDialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> messengerList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProgressDialog loadingDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String source = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a mAction = new c();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/aio/helper/RobotShareSessionHelper$b;", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface;", "dialog", "", "onDismiss", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/robot/aio/helper/RobotShareSessionHelper;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "weakHelper", "helper", "<init>", "(Lcom/tencent/robot/aio/helper/RobotShareSessionHelper;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<RobotShareSessionHelper> weakHelper;

        public b(@NotNull RobotShareSessionHelper helper) {
            Intrinsics.checkNotNullParameter(helper, "helper");
            this.weakHelper = new WeakReference<>(helper);
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(@Nullable DialogInterface dialog) {
            RobotShareSessionHelper robotShareSessionHelper = this.weakHelper.get();
            if (robotShareSessionHelper != null) {
                robotShareSessionHelper.shareDialog = null;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/RobotShareSessionHelper$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent msgIntent) {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            RobotShareSessionHelper.this.v(msgIntent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public RobotShareSessionHelper() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(RobotMsgIntent.ShareSession.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(RobotMsgIntent.MultiMsgShare.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(RobotMultiShareMsgFromBar.OnShareClick.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(RobotMultiShareMsgFromBar.OnShareCancel.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(RobotMsgIntent.SingleMsgShare.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(RobotMsgIntent.RobotMultiFavClickEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(RobotMsgIntent.SingleMsgFav.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(MsgForwardEvent.MultiForwardSelectResult.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(AIOActivityResultEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(LongShotMsgIntent.OnShotFinish.class).getQualifiedName()});
        this.messengerList = listOf;
    }

    private final void A() {
        if (u().isEmpty()) {
            QQToastUtil.showQQToastInUiThread(0, "\u8bf7\u9009\u62e9\u8981\u5206\u4eab\u7684\u5185\u5bb9");
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        i81.a.a(aVar, new Function0<Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleMultiMsgShare$1
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
                RobotShareSessionHelper.this.D();
            }
        }, new Function0<Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleMultiMsgShare$2
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
                RobotShareSessionHelper.this.S();
            }
        });
    }

    private final void B(final RobotSessionShareParams param) {
        final List<AIOMsgItem> u16 = u();
        if (u16.isEmpty()) {
            QQToastUtil.showQQToastInUiThread(0, "\u8bf7\u9009\u62e9\u8981\u5206\u4eab\u7684\u5185\u5bb9");
        } else {
            RobotMsgExtKt.f(2, u16, new Function2<RobotMsgPreCheckResult, String, Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleMultiMsgShareFromBar$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(RobotMsgPreCheckResult robotMsgPreCheckResult, String str) {
                    invoke2(robotMsgPreCheckResult, str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull RobotMsgPreCheckResult result, @NotNull String str) {
                    List list;
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    if (RobotMsgPreCheckResult.CHECK_SUCCESS == result) {
                        if (RobotSessionShareParams.this.getAction() != 241) {
                            this.G(RobotSessionShareParams.this, u16);
                            return;
                        }
                        RobotShareSessionHelper robotShareSessionHelper = this;
                        String robotUin = RobotSessionShareParams.this.getRobotUin();
                        long parseLong = robotUin != null ? Long.parseLong(robotUin) : 0L;
                        list = CollectionsKt___CollectionsKt.toList(u16);
                        robotShareSessionHelper.H(parseLong, list);
                    }
                }
            });
        }
    }

    private final void C(final RobotMsgIntent.RobotMultiFavClickEvent intent) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        i81.a.a(aVar, new Function0<Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleMultiSelectBarFav$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                RobotShareSessionHelper.this.z(intent.b(), intent.a());
            }
        }, new Function0<Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleMultiSelectBarFav$2
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
                RobotShareSessionHelper.this.y();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        if (QLog.isColorLevel()) {
            QLog.i("RobotShareSessionHelper", 1, "handleMultiSelectBarShareForNewInteraction");
        }
        final List<AIOMsgItem> u16 = u();
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        w(su3.c.a(g16), u16, 2, new Function1<RobotSessionShareInfo, Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleMultiSelectBarShareForNewInteraction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RobotSessionShareInfo robotSessionShareInfo) {
                invoke2(robotSessionShareInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RobotSessionShareInfo robotSessionShareInfo) {
                com.tencent.aio.api.runtime.a aVar2;
                com.tencent.aio.api.runtime.a aVar3;
                Intrinsics.checkNotNullParameter(robotSessionShareInfo, "robotSessionShareInfo");
                if (!RobotMsgExtKt.g(u16)) {
                    this.S();
                    return;
                }
                RobotShareSessionHelper robotShareSessionHelper = this;
                aVar2 = robotShareSessionHelper.mContext;
                com.tencent.aio.api.runtime.a aVar4 = null;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar2 = null;
                }
                FragmentActivity requireActivity = aVar2.c().requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "mContext.fragment.requireActivity()");
                List<AIOMsgItem> list = u16;
                aVar3 = this.mContext;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    aVar4 = aVar3;
                }
                AIOParam g17 = aVar4.g();
                Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
                robotShareSessionHelper.P(requireActivity, list, su3.c.a(g17), robotSessionShareInfo);
            }
        });
    }

    private final void E(boolean isSelectMode, String source) {
        Object first;
        e.d dVar;
        List<AIOMsgItem> list;
        this.source = source;
        if (isSelectMode && N(source)) {
            List<AIOMsgItem> u16 = u();
            boolean z16 = true;
            if (u16.size() == 1) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) u16);
                AIOMsgItem aIOMsgItem = (AIOMsgItem) first;
                com.tencent.aio.api.runtime.a aVar = this.mContext;
                com.tencent.aio.api.runtime.a aVar2 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar = null;
                }
                com.tencent.mvi.base.route.k k3 = aVar.e().k(new RobotMsgIntent.GetRobotQAMsgList(aIOMsgItem.getMsgId()));
                if (k3 instanceof e.d) {
                    dVar = (e.d) k3;
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    list = dVar.a();
                } else {
                    list = null;
                }
                List<AIOMsgItem> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    z16 = false;
                }
                if (!z16) {
                    com.tencent.aio.api.runtime.a aVar3 = this.mContext;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    } else {
                        aVar2 = aVar3;
                    }
                    aVar2.e().h(new MultiSelectEvent.SetSelectMsgList(list));
                }
            }
        }
    }

    private final void F(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 17003:
            case 17004:
            case 17005:
                QLog.i("RobotShareSessionHelper", 1, "onActivityResult, requestCode: " + requestCode + ", resultCode: " + resultCode);
                if (resultCode == -1) {
                    r();
                    return;
                } else {
                    if (requestCode == 17005 && data != null && data.getBooleanExtra("NOCANCEL4DATALIN", false)) {
                        r();
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(RobotSessionShareParams param, List<? extends AIOMsgItem> msgList) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        FragmentActivity activity = aVar.c().getActivity();
        if (activity != null) {
            RobotMsgExtKt.i(activity, param, msgList, new RobotShareSessionHelper$handleShareDefault$1$1(this), new Function1<ShareStatus, Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleShareDefault$1$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ShareStatus shareStatus) {
                    invoke2(shareStatus);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ShareStatus status) {
                    Intrinsics.checkNotNullParameter(status, "status");
                    QLog.i("RobotShareSessionHelper", 1, "RobotSessionShareActionExecutor onItemClick callback: " + status.getIsSuccess());
                    if (status.getIsSuccess()) {
                        return;
                    }
                    QQToastUtil.showQQToastInUiThread(1, RobotMsgExtKt.m(status, 2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(final long robotUin, final List<? extends AIOMsgItem> msgList) {
        R();
        RobotSessionShareActionExecutor.m(RobotSessionShareActionExecutor.f367323a, robotUin, msgList, 0, new Function2<ShareStatus, RobotSessionShareInfo, Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleShareGenerateImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ShareStatus shareStatus, RobotSessionShareInfo robotSessionShareInfo) {
                invoke2(shareStatus, robotSessionShareInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ShareStatus status, @Nullable RobotSessionShareInfo robotSessionShareInfo) {
                com.tencent.aio.api.runtime.a aVar;
                Intrinsics.checkNotNullParameter(status, "status");
                if (status.getIsSuccess()) {
                    aVar = RobotShareSessionHelper.this.mContext;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        aVar = null;
                    }
                    aVar.e().h(new RobotMsgIntent.SetShotMsgList(msgList, robotUin, false));
                    return;
                }
                QQToastUtil.showQQToastInUiThread(1, RobotMsgExtKt.m(status, 3));
                RobotShareSessionHelper.this.M();
            }
        }, 4, null);
    }

    private final void I(AIOMsgItem msg2) {
        List<AIOMsgItem> a16;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        e.d dVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        e16.h(new MultiSelectEvent.SetSelectMode(true));
        com.tencent.mvi.base.route.k k3 = e16.k(new RobotMsgIntent.GetRobotQAMsgList(msg2.getMsgId()));
        if (k3 instanceof e.d) {
            dVar = (e.d) k3;
        }
        if (dVar != null && (a16 = dVar.a()) != null) {
            e16.h(new MultiSelectEvent.SetSelectMsgList(a16));
            e16.h(new AIOMsgListEvent.MultiSelectModeChangeEvent("RobotActionBarShare", true));
            e16.h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("RobotActionBarShare", false));
        }
    }

    private final void J(final AIOMsgItem msg2) {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(msg2);
        RobotMsgExtKt.f(4, listOf, new Function2<RobotMsgPreCheckResult, String, Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleShareSingleMessage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(RobotMsgPreCheckResult robotMsgPreCheckResult, String str) {
                invoke2(robotMsgPreCheckResult, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RobotMsgPreCheckResult result, @NotNull String str) {
                com.tencent.aio.api.runtime.a aVar;
                com.tencent.aio.api.runtime.a aVar2;
                com.tencent.aio.api.runtime.a aVar3;
                List listOf2;
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                if (RobotMsgPreCheckResult.CHECK_SUCCESS == result) {
                    aVar = RobotShareSessionHelper.this.mContext;
                    com.tencent.aio.api.runtime.a aVar4 = null;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        aVar = null;
                    }
                    FragmentActivity activity = aVar.c().getActivity();
                    if (activity != null) {
                        RobotShareSessionHelper robotShareSessionHelper = RobotShareSessionHelper.this;
                        AIOMsgItem aIOMsgItem = msg2;
                        aVar2 = robotShareSessionHelper.mContext;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                            aVar2 = null;
                        }
                        int e16 = aVar2.g().r().c().e();
                        aVar3 = robotShareSessionHelper.mContext;
                        if (aVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        } else {
                            aVar4 = aVar3;
                        }
                        AIOParam g16 = aVar4.g();
                        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                        RobotSessionShareParams robotSessionShareParams = new RobotSessionShareParams(2, "", e16, String.valueOf(su3.c.a(g16)), 4);
                        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(aIOMsgItem);
                        RobotMsgExtKt.i(activity, robotSessionShareParams, listOf2, new RobotShareSessionHelper$handleShareSingleMessage$1$1$1(robotShareSessionHelper), new Function1<ShareStatus, Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleShareSingleMessage$1$1$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ShareStatus shareStatus) {
                                invoke2(shareStatus);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull ShareStatus status) {
                                Intrinsics.checkNotNullParameter(status, "status");
                                QLog.i("RobotShareSessionHelper", 1, "RobotSessionShareActionExecutor onItemClick callback: " + status.getIsSuccess());
                                if (status.getIsSuccess()) {
                                    return;
                                }
                                QQToastUtil.showQQToastInUiThread(1, RobotMsgExtKt.m(status, 4));
                            }
                        });
                    }
                }
            }
        });
    }

    private final void K(LongShotMsgIntent.OnShotFinish intent) {
        QLog.i("RobotShareSessionHelper", 1, "handleShotFinish");
        M();
    }

    private final void L(final AIOMsgItem msg2) {
        List<? extends AIOMsgItem> listOf;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        long a16 = su3.c.a(g16);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(msg2);
        w(a16, listOf, 1, new Function1<RobotSessionShareInfo, Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleSingleMessageFav$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RobotSessionShareInfo robotSessionShareInfo) {
                invoke2(robotSessionShareInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RobotSessionShareInfo robotSessionShareInfo) {
                List listOf2;
                Intrinsics.checkNotNullParameter(robotSessionShareInfo, "robotSessionShareInfo");
                RobotShareSessionHelper robotShareSessionHelper = RobotShareSessionHelper.this;
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(msg2);
                robotShareSessionHelper.x(listOf2, robotSessionShareInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        try {
            QQProgressDialog qQProgressDialog = this.loadingDialog;
            if (qQProgressDialog == null) {
                return;
            }
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
            this.loadingDialog = null;
        } catch (Exception e16) {
            QLog.e("RobotShareSessionHelper", 1, "hideLoading error: " + e16.getMessage());
        }
    }

    private final boolean N(String source) {
        return Intrinsics.areEqual(source, "RobotActionBarShare");
    }

    private final boolean O() {
        com.tencent.aio.api.runtime.a aVar = null;
        MultiSelectEvent.GetSelectNormalMsgSum getSelectNormalMsgSum = new MultiSelectEvent.GetSelectNormalMsgSum(0, 1, null);
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().h(getSelectNormalMsgSum);
        if (getSelectNormalMsgSum.a() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(final Activity activity, final List<? extends AIOMsgItem> msgList, final long robotUin, final RobotSessionShareInfo info) {
        if (QLog.isColorLevel()) {
            QLog.i("RobotShareSessionHelper", 1, "realShowShareDialog");
        }
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        com.tencent.robot.aio.share.c cVar = new com.tencent.robot.aio.share.c(param);
        this.shareDialog = cVar;
        cVar.setOnDismissListener(new b(this));
        com.tencent.robot.aio.share.c cVar2 = this.shareDialog;
        if (cVar2 != null) {
            cVar2.setItemClickListenerV3(new ShareActionSheet.c() { // from class: com.tencent.robot.aio.helper.p
                @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
                public final void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                    RobotShareSessionHelper.Q(RobotShareSessionHelper.this, msgList, robotUin, activity, info, view, actionSheetItem, shareActionSheet);
                }
            });
        }
        com.tencent.robot.aio.share.c cVar3 = this.shareDialog;
        if (cVar3 != null) {
            cVar3.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(final RobotShareSessionHelper this$0, List msgList, long j3, Activity activity, RobotSessionShareInfo info, View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        List list;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgList, "$msgList");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(info, "$info");
        if (actionSheetItem.action == 241) {
            com.tencent.aio.api.runtime.a aVar = this$0.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            list = CollectionsKt___CollectionsKt.toList(msgList);
            e16.h(new RobotMsgIntent.SetShotMsgList(list, j3, true));
            com.tencent.robot.aio.share.c cVar = this$0.shareDialog;
            if (cVar != null) {
                cVar.dismiss();
                return;
            }
            return;
        }
        int i3 = actionSheetItem.action;
        String str = actionSheetItem.uin;
        if (str == null) {
            str = "";
        }
        RobotSessionShareParams robotSessionShareParams = new RobotSessionShareParams(i3, str, actionSheetItem.uinType, String.valueOf(j3), 0, 16, null);
        com.tencent.robot.aio.share.c cVar2 = this$0.shareDialog;
        if (cVar2 != null) {
            cVar2.dismiss();
        }
        RobotSessionShareActionExecutor.f367323a.h(activity, robotSessionShareParams, info, new Function0<Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$realShowShareDialog$2$1
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
                RobotShareSessionHelper.this.r();
            }
        });
    }

    private final void R() {
        try {
            M();
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            com.tencent.aio.api.runtime.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            Context requireContext = aVar.c().requireContext();
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar3;
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(requireContext, aVar2.c().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.loadingDialog = qQProgressDialog;
            qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.yry));
            QQProgressDialog qQProgressDialog2 = this.loadingDialog;
            if (qQProgressDialog2 != null) {
                qQProgressDialog2.show();
            }
        } catch (Exception e16) {
            QLog.e("RobotShareSessionHelper", 1, "showLoading error: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        Context context;
        if (QLog.isColorLevel()) {
            QLog.i("RobotShareSessionHelper", 1, "handleShareClickForNormalRobot");
        }
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        Fragment c16 = aVar.c();
        if (c16 == null || (context = c16.getContext()) == null || t(context)) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().h(MultiSelectEvent.MultiForwardShowEvent.f188669d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new MultiSelectEvent.SetSelectMode(false));
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar3 = null;
        }
        aVar3.e().h(new AIOMsgListEvent.MultiSelectModeChangeEvent(this.source, false));
        com.tencent.aio.api.runtime.a aVar4 = this.mContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar4;
        }
        aVar2.e().h(new AIOMsgListEvent.SetCommunicationShareButton(false));
    }

    private final boolean s(Context context) {
        String str = null;
        if (O()) {
            Resources resources = context.getResources();
            if (resources != null) {
                str = resources.getString(R.string.f168862gs);
            }
            QQToastUtil.showQQToastInUiThread(1, str);
            return true;
        }
        if (RobotMsgExtKt.g(u())) {
            Resources resources2 = context.getResources();
            if (resources2 != null) {
                str = resources2.getString(R.string.f222466dl);
            }
            QQToastUtil.showQQToastInUiThread(1, str);
            return true;
        }
        return false;
    }

    private final boolean t(Context context) {
        String str = null;
        if (!AppNetConnInfo.isNetSupport()) {
            Resources resources = context.getResources();
            if (resources != null) {
                str = resources.getString(R.string.f169552in);
            }
            QQToast.makeText(context, str, 0).show();
            return true;
        }
        if (!O()) {
            return false;
        }
        Resources resources2 = context.getResources();
        if (resources2 != null) {
            str = resources2.getString(R.string.f169542im);
        }
        QQToast.makeText(context, str, 0).show();
        return true;
    }

    private final List<AIOMsgItem> u() {
        com.tencent.aio.api.runtime.a aVar = null;
        MultiSelectEvent.GetSelectMsgList getSelectMsgList = new MultiSelectEvent.GetSelectMsgList(null, 1, null);
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().h(getSelectMsgList);
        return getSelectMsgList.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(MsgIntent msgIntent) {
        if (msgIntent instanceof RobotMsgIntent.ShareSession) {
            I(((RobotMsgIntent.ShareSession) msgIntent).a());
            return;
        }
        if (msgIntent instanceof RobotMsgIntent.MultiMsgShare) {
            A();
            return;
        }
        if (msgIntent instanceof RobotMsgIntent.SingleMsgShare) {
            J(((RobotMsgIntent.SingleMsgShare) msgIntent).a());
            return;
        }
        if (msgIntent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            AIOMsgListEvent.MultiSelectModeChangeEvent multiSelectModeChangeEvent = (AIOMsgListEvent.MultiSelectModeChangeEvent) msgIntent;
            E(multiSelectModeChangeEvent.b(), multiSelectModeChangeEvent.a());
            return;
        }
        if (msgIntent instanceof RobotMultiShareMsgFromBar.OnShareClick) {
            B(((RobotMultiShareMsgFromBar.OnShareClick) msgIntent).getParams());
            return;
        }
        if (msgIntent instanceof RobotMultiShareMsgFromBar.OnShareCancel) {
            r();
            return;
        }
        if (msgIntent instanceof RobotMsgIntent.RobotMultiFavClickEvent) {
            C((RobotMsgIntent.RobotMultiFavClickEvent) msgIntent);
            return;
        }
        if (msgIntent instanceof RobotMsgIntent.SingleMsgFav) {
            L(((RobotMsgIntent.SingleMsgFav) msgIntent).a());
            return;
        }
        if (msgIntent instanceof AIOActivityResultEvent) {
            AIOActivityResultEvent aIOActivityResultEvent = (AIOActivityResultEvent) msgIntent;
            F(aIOActivityResultEvent.b(), aIOActivityResultEvent.c(), aIOActivityResultEvent.a());
        } else if (msgIntent instanceof LongShotMsgIntent.OnShotFinish) {
            K((LongShotMsgIntent.OnShotFinish) msgIntent);
        }
    }

    private final void w(long robotUin, List<? extends AIOMsgItem> msgList, int type, final Function1<? super RobotSessionShareInfo, Unit> onSuccess) {
        if (QLog.isColorLevel()) {
            QLog.i("RobotShareSessionHelper", 1, "handleMultiFavCommon");
        }
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        FragmentActivity requireActivity = aVar.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "mContext.fragment.requireActivity()");
        RobotMsgExtKt.e(requireActivity, robotUin, msgList, type, new Function1<MsgCheckResult, Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleCommonCheck$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes25.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f367026a;

                static {
                    int[] iArr = new int[RobotMsgCheckResult.values().length];
                    try {
                        iArr[RobotMsgCheckResult.RESULT_SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f367026a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MsgCheckResult msgCheckResult) {
                invoke2(msgCheckResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MsgCheckResult checkResult) {
                Intrinsics.checkNotNullParameter(checkResult, "checkResult");
                if (QLog.isColorLevel()) {
                    QLog.i("RobotShareSessionHelper", 1, "checkMsgAndFetchShareInfo result: " + checkResult);
                }
                if (a.f367026a[checkResult.getRobotMsgCheckResult().ordinal()] == 1) {
                    Function1<RobotSessionShareInfo, Unit> function1 = onSuccess;
                    RobotSessionShareInfo robotSessionShareInfo = checkResult.getRobotSessionShareInfo();
                    Intrinsics.checkNotNull(robotSessionShareInfo);
                    function1.invoke(robotSessionShareInfo);
                    return;
                }
                QQToastUtil.showQQToastInUiThread(1, checkResult.getCheckMsg());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(List<? extends AIOMsgItem> msgList, RobotSessionShareInfo robotSessionShareInfo) {
        IRobotAIOFavApi iRobotAIOFavApi = (IRobotAIOFavApi) QRoute.api(IRobotAIOFavApi.class);
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        FragmentActivity requireActivity = aVar.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "mContext.fragment.requireActivity()");
        Intrinsics.checkNotNull(robotSessionShareInfo);
        iRobotAIOFavApi.multiFav(requireActivity, msgList, robotSessionShareInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        Context context;
        if (QLog.isColorLevel()) {
            QLog.i("RobotShareSessionHelper", 1, "handleMultiFavClickForDefault");
        }
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        Fragment c16 = aVar.c();
        if (c16 == null || (context = c16.getContext()) == null || s(context)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(u());
        ((IAIOFavApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFavApi.class)).multiFav(context, arrayList);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        com.tencent.mvi.base.route.j e16 = aVar2.e();
        e16.h(new MultiSelectEvent.SetSelectMode(false));
        e16.h(new AIOMsgListEvent.MultiSelectModeChangeEvent("RobotShareSessionHelper", false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(long robotUin, final List<? extends AIOMsgItem> msgList) {
        if (QLog.isColorLevel()) {
            QLog.i("RobotShareSessionHelper", 1, "handleMultiFavForNewInteraction");
        }
        w(robotUin, msgList, 1, new Function1<RobotSessionShareInfo, Unit>() { // from class: com.tencent.robot.aio.helper.RobotShareSessionHelper$handleMultiFavForNewInteraction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RobotSessionShareInfo robotSessionShareInfo) {
                invoke2(robotSessionShareInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RobotSessionShareInfo robotSessionShareInfo) {
                com.tencent.aio.api.runtime.a aVar;
                Intrinsics.checkNotNullParameter(robotSessionShareInfo, "robotSessionShareInfo");
                if (QLog.isColorLevel()) {
                    QLog.i("RobotShareSessionHelper", 1, "checkMsgAndFetchShareInfo success");
                }
                if (!RobotMsgExtKt.g(msgList)) {
                    this.y();
                } else {
                    this.x(msgList, robotSessionShareInfo);
                }
                aVar = this.mContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar = null;
                }
                com.tencent.mvi.base.route.j e16 = aVar.e();
                e16.h(new MultiSelectEvent.SetSelectMode(false));
                e16.h(new AIOMsgListEvent.MultiSelectModeChangeEvent("RobotShareSessionHelper", false));
            }
        });
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.L1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "RobotShareSessionHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mContext = param.a();
        for (String str : this.messengerList) {
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            aVar.e().d(str, this.mAction);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        Iterator<T> it = this.messengerList.iterator();
        while (true) {
            com.tencent.aio.api.runtime.a aVar = null;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar = aVar2;
            }
            aVar.e().b(str, this.mAction);
        }
        com.tencent.robot.aio.share.c cVar = this.shareDialog;
        if (cVar != null) {
            cVar.dismiss();
        }
        this.shareDialog = null;
        M();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
