package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.core.util.Supplier;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.viewmodel.activity.PopupType;
import com.tencent.biz.qqcircle.immersive.viewmodel.activity.QFSSpringFestivalActivityViewModel;
import com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QFSSpringFestivalPartStateEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSSpringPrizePopupInfoEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSpringPrizePopup$SpringMaterial;
import qqcircle.QQCircleSpringPrizePopup$StPrizeInfo;

@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 U2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001VB\u0015\u0012\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00160:\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002Ji\u0010 \u001a\u00020\u0006*\u00020\u00122\b\b\u0001\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001eH\u0002\u00a2\u0006\u0004\b \u0010!J*\u0010\"\u001a\u00020\u0006*\u00020\u00122\b\b\u0001\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020#H\u0002J\u001a\u0010(\u001a\u00020\u00062\b\b\u0001\u0010'\u001a\u00020\u00132\u0006\u0010%\u001a\u00020#H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J)\u0010*\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002\u00a2\u0006\u0004\b*\u0010+J\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u00100\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u00103\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u000101H\u0016J\u0012\u00105\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u00010\u0003H\u0016J$\u00109\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030706j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000307`8H\u0016R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00160:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR#\u0010K\u001a\n F*\u0004\u0018\u00010E0E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR \u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSSpringFestivalActivityDialogPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/a;", "activityInfo", "", "X9", "Landroid/view/View;", "I9", "J9", "Lfeedcloud/FeedCloudMeta$StShare;", "stShare", "T9", "dialogView", "N9", "O9", "M9", "Landroid/widget/ImageView;", "", "widthId", "heightId", "", "imageUrl", WadlProxyConsts.KEY_JUMP_URL, "Lqqcircle/QQCircleSpringPrizePopup$StPrizeInfo;", "prizeInfo", "eid", "", "isLimited", "Lkotlin/Function0;", "onJumpUrl", "E9", "(Landroid/widget/ImageView;IILjava/lang/String;Ljava/lang/String;Lqqcircle/QQCircleSpringPrizePopup$StPrizeInfo;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "Q9", "", "H9", "scale", "P9", "id", "U9", "W9", "V9", "(Lqqcircle/QQCircleSpringPrizePopup$StPrizeInfo;Ljava/lang/String;Ljava/lang/Boolean;)V", "", "", "L9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroidx/core/util/Supplier;", "d", "Landroidx/core/util/Supplier;", "curDTPageIdSupplier", "e", "Z", "isImageResPreloaded", "Lcom/tencent/biz/qqcircle/widgets/a;", "f", "Lcom/tencent/biz/qqcircle/widgets/a;", "publishCallback", "Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/QFSSpringFestivalActivityViewModel;", "kotlin.jvm.PlatformType", tl.h.F, "Lkotlin/Lazy;", "K9", "()Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/QFSSpringFestivalActivityViewModel;", "activityViewModel", "Lcom/tencent/biz/qqcircle/widgets/comment/e;", "i", "Lcom/tencent/biz/qqcircle/widgets/comment/e;", "dialog", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "idToDimenRes", "<init>", "(Landroidx/core/util/Supplier;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSpringFestivalActivityDialogPart extends u implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<String> curDTPageIdSupplier;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isImageResPreloaded;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.widgets.a publishCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy activityViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.widgets.comment.e dialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Integer> idToDimenRes;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSSpringFestivalActivityDialogPart$a;", "", "", "a", "", "CONFIG_ID", "Ljava/lang/String;", "", "DEFAULT_SIZE", "I", "", "DESIGNED_DIALOG_WIDTH", UserInfo.SEX_FEMALE, "DESIGNED_SCREEN_WIDTH", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSSpringFestivalActivityDialogPart$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101962", true);
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f87567a;

        static {
            int[] iArr = new int[PopupType.values().length];
            try {
                iArr[PopupType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PopupType.THANKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PopupType.LIMIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f87567a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/QFSSpringFestivalActivityDialogPart$c", "Lcom/tencent/biz/qqcircle/widgets/a;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "", "onTaskStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends com.tencent.biz.qqcircle.widgets.a {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onTaskStateChanged(@NotNull TaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            QFSSpringFestivalActivityDialogPart.this.K9().X1(taskInfo);
        }
    }

    public QFSSpringFestivalActivityDialogPart(@NotNull Supplier<String> curDTPageIdSupplier) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(curDTPageIdSupplier, "curDTPageIdSupplier");
        this.curDTPageIdSupplier = curDTPageIdSupplier;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSSpringFestivalActivityViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSSpringFestivalActivityDialogPart$activityViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSSpringFestivalActivityViewModel invoke() {
                return (QFSSpringFestivalActivityViewModel) QFSSpringFestivalActivityDialogPart.this.getViewModel(QFSSpringFestivalActivityViewModel.class);
            }
        });
        this.activityViewModel = lazy;
        this.idToDimenRes = new LinkedHashMap();
    }

    private final void E9(final ImageView imageView, @DimenRes int i3, @DimenRes int i16, String str, final String str2, final QQCircleSpringPrizePopup$StPrizeInfo qQCircleSpringPrizePopup$StPrizeInfo, final String str3, final Boolean bool, final Function0<Unit> function0) {
        imageView.setVisibility(0);
        Q9(imageView, i3, i16, str);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.fn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSSpringFestivalActivityDialogPart.G9(Function0.this, this, str2, qQCircleSpringPrizePopup$StPrizeInfo, str3, bool, imageView, view);
            }
        });
    }

    static /* synthetic */ void F9(QFSSpringFestivalActivityDialogPart qFSSpringFestivalActivityDialogPart, ImageView imageView, int i3, int i16, String str, String str2, QQCircleSpringPrizePopup$StPrizeInfo qQCircleSpringPrizePopup$StPrizeInfo, String str3, Boolean bool, Function0 function0, int i17, Object obj) {
        Boolean bool2;
        Function0 function02;
        if ((i17 & 64) != 0) {
            bool2 = null;
        } else {
            bool2 = bool;
        }
        if ((i17 & 128) != 0) {
            function02 = null;
        } else {
            function02 = function0;
        }
        qFSSpringFestivalActivityDialogPart.E9(imageView, i3, i16, str, str2, qQCircleSpringPrizePopup$StPrizeInfo, str3, bool2, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function0 function0, QFSSpringFestivalActivityDialogPart this$0, String str, QQCircleSpringPrizePopup$StPrizeInfo prizeInfo, String eid, Boolean bool, ImageView this_bindData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(prizeInfo, "$prizeInfo");
        Intrinsics.checkNotNullParameter(eid, "$eid");
        Intrinsics.checkNotNullParameter(this_bindData, "$this_bindData");
        if (function0 == null) {
            this$0.J9();
            if (str != null) {
                com.tencent.biz.qqcircle.launcher.c.g(this_bindData.getContext(), str);
            }
        } else {
            function0.invoke();
        }
        this$0.V9(prizeInfo, eid, bool);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final float H9() {
        float coerceAtMost;
        int screenWidth = ImmersiveUtils.getScreenWidth();
        float f16 = screenWidth * 0.93866664f;
        float fontScale = FontSettingManager.getFontScale();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((f16 / jy2.f.f411169a.f(Float.valueOf(352.0f))) / fontScale, 1.0f);
        QLog.i("QFSSpringFestivalActivityDialogPart", 1, "[calculateScale] finalScale=" + coerceAtMost + ", screenWidth=" + screenWidth + ", realDialogWidth=" + f16 + ", fontScale=" + fontScale);
        return coerceAtMost;
    }

    private final View I9(final com.tencent.biz.qqcircle.immersive.viewmodel.activity.a activityInfo) {
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        PBStringField pBStringField5;
        PBStringField pBStringField6;
        String str9;
        String str10;
        PBStringField pBStringField7;
        PBStringField pBStringField8;
        PBStringField pBStringField9;
        PBStringField pBStringField10;
        float H9 = H9();
        P9(H9);
        boolean z16 = false;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g77, (ViewGroup) null, false);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        inflate.setScaleX(H9);
        inflate.setScaleY(H9);
        ((TextView) inflate.findViewById(R.id.f27750h3)).setText(activityInfo.getReason());
        View findViewById = inflate.findViewById(R.id.uhb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(R.id.dialogBg)");
        ImageView imageView = (ImageView) findViewById;
        QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial = activityInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
        if (qQCircleSpringPrizePopup$SpringMaterial != null && (pBStringField10 = qQCircleSpringPrizePopup$SpringMaterial.bg_dialog) != null) {
            str = pBStringField10.get();
        } else {
            str = null;
        }
        Q9(imageView, R.dimen.d5_, R.dimen.d59, str);
        View findViewById2 = inflate.findViewById(R.id.f164822az1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(R.id.closeBtn)");
        ImageView imageView2 = (ImageView) findViewById2;
        QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial2 = activityInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
        if (qQCircleSpringPrizePopup$SpringMaterial2 != null && (pBStringField9 = qQCircleSpringPrizePopup$SpringMaterial2.popup_close) != null) {
            str2 = pBStringField9.get();
        } else {
            str2 = null;
        }
        F9(this, imageView2, R.dimen.d58, R.dimen.d58, str2, null, activityInfo.getPrizeInfo(), "em_xsj_close_button", null, null, 192, null);
        if (activityInfo.getPopupType() == PopupType.THANKS) {
            View findViewById3 = inflate.findViewById(R.id.f164759tq4);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<ImageView>(R.id.centerBtn)");
            ImageView imageView3 = (ImageView) findViewById3;
            QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial3 = activityInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
            if (qQCircleSpringPrizePopup$SpringMaterial3 != null && (pBStringField8 = qQCircleSpringPrizePopup$SpringMaterial3.small_btn_back) != null) {
                str9 = pBStringField8.get();
            } else {
                str9 = null;
            }
            QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial4 = activityInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
            if (qQCircleSpringPrizePopup$SpringMaterial4 != null && (pBStringField7 = qQCircleSpringPrizePopup$SpringMaterial4.small_btn_back_jump_url) != null) {
                str10 = pBStringField7.get();
            } else {
                str10 = null;
            }
            i3 = 1;
            F9(this, imageView3, R.dimen.d57, R.dimen.d56, str9, str10, activityInfo.getPrizeInfo(), QCircleDaTongConstant.ElementId.EM_XSJ_GOTO_MAIN_VENUE_BUTTON, Boolean.FALSE, null, 128, null);
        } else {
            i3 = 1;
            View findViewById4 = inflate.findViewById(R.id.yap);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<ImageView>(R.id.jumpActivityBtn)");
            ImageView imageView4 = (ImageView) findViewById4;
            QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial5 = activityInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
            if (qQCircleSpringPrizePopup$SpringMaterial5 != null && (pBStringField6 = qQCircleSpringPrizePopup$SpringMaterial5.small_btn_back) != null) {
                str3 = pBStringField6.get();
            } else {
                str3 = null;
            }
            QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial6 = activityInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
            if (qQCircleSpringPrizePopup$SpringMaterial6 != null && (pBStringField5 = qQCircleSpringPrizePopup$SpringMaterial6.small_btn_back_jump_url) != null) {
                str4 = pBStringField5.get();
            } else {
                str4 = null;
            }
            F9(this, imageView4, R.dimen.d5_, R.dimen.f159421d55, str3, str4, activityInfo.getPrizeInfo(), QCircleDaTongConstant.ElementId.EM_XSJ_GOTO_MAIN_VENUE_BUTTON, null, null, 192, null);
            if (activityInfo.getPopupType() == PopupType.LIMIT) {
                z16 = true;
            }
            View findViewById5 = inflate.findViewById(R.id.ygm);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById<ImageView>(R.id.leftBtn)");
            ImageView imageView5 = (ImageView) findViewById5;
            QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial7 = activityInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
            if (qQCircleSpringPrizePopup$SpringMaterial7 != null && (pBStringField4 = qQCircleSpringPrizePopup$SpringMaterial7.btn_left) != null) {
                str5 = pBStringField4.get();
            } else {
                str5 = null;
            }
            QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial8 = activityInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
            if (qQCircleSpringPrizePopup$SpringMaterial8 != null && (pBStringField3 = qQCircleSpringPrizePopup$SpringMaterial8.btn_left_jump_url) != null) {
                str6 = pBStringField3.get();
            } else {
                str6 = null;
            }
            F9(this, imageView5, R.dimen.d57, R.dimen.d56, str5, str6, activityInfo.getPrizeInfo(), QCircleDaTongConstant.ElementId.EM_XSJ_POPUP_LEFT_BUTTON, Boolean.valueOf(z16), null, 128, null);
            final ImageView createDialogContentView$lambda$4$lambda$3 = (ImageView) inflate.findViewById(R.id.f74363w2);
            QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial9 = activityInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
            if (qQCircleSpringPrizePopup$SpringMaterial9 != null && (pBStringField2 = qQCircleSpringPrizePopup$SpringMaterial9.btn_right_jump_url) != null) {
                str7 = pBStringField2.get();
            } else {
                str7 = null;
            }
            Intrinsics.checkNotNullExpressionValue(createDialogContentView$lambda$4$lambda$3, "createDialogContentView$lambda$4$lambda$3");
            QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial10 = activityInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
            if (qQCircleSpringPrizePopup$SpringMaterial10 != null && (pBStringField = qQCircleSpringPrizePopup$SpringMaterial10.btn_right) != null) {
                str8 = pBStringField.get();
            } else {
                str8 = null;
            }
            final boolean z17 = z16;
            final String str11 = str7;
            E9(createDialogContentView$lambda$4$lambda$3, R.dimen.d57, R.dimen.d56, str8, str7, activityInfo.getPrizeInfo(), QCircleDaTongConstant.ElementId.EM_XSJ_POPUP_RIGHT_BUTTON, Boolean.valueOf(z16), new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSSpringFestivalActivityDialogPart$createDialogContentView$1$1$1
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
                    if (!z17) {
                        this.T9(activityInfo.getShareInfo());
                    } else {
                        com.tencent.biz.qqcircle.launcher.c.g(createDialogContentView$lambda$4$lambda$3.getContext(), str11);
                    }
                }
            });
        }
        int i16 = b.f87567a[activityInfo.getPopupType().ordinal()];
        if (i16 != i3) {
            if (i16 != 2) {
                if (i16 == 3) {
                    Intrinsics.checkNotNullExpressionValue(inflate, "this");
                    M9(inflate, activityInfo);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(inflate, "this");
                O9(inflate, activityInfo);
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(inflate, "this");
            N9(inflate, activityInfo);
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026          }\n            }");
        return inflate;
    }

    private final void J9() {
        com.tencent.biz.qqcircle.widgets.comment.e eVar = this.dialog;
        if (eVar != null) {
            if (eVar != null) {
                eVar.N();
            }
            this.dialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QFSSpringFestivalActivityViewModel K9() {
        return (QFSSpringFestivalActivityViewModel) this.activityViewModel.getValue();
    }

    private final Map<String, Object> L9(QQCircleSpringPrizePopup$StPrizeInfo prizeInfo) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_custom_pgid", this.curDTPageIdSupplier.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRIZE_ID, Long.valueOf(prizeInfo.prize_id.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRIZE_NAME, prizeInfo.prize_text.get());
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "QCircleDTParamBuilder().\u2026ize_text.get())\n        }");
        return buildElementParams;
    }

    private final void M9(View dialogView, com.tencent.biz.qqcircle.immersive.viewmodel.activity.a activityInfo) {
        String str;
        String str2;
        PBStringField pBStringField;
        View inflate = ((ViewStub) dialogView.findViewById(R.id.yi9)).inflate();
        QQCircleSpringPrizePopup$StPrizeInfo prizeInfo = activityInfo.getPrizeInfo();
        TextView textView = (TextView) inflate.findViewById(R.id.f27740h2);
        PBStringField pBStringField2 = prizeInfo.prize_text;
        String str3 = null;
        if (pBStringField2 != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        textView.setText(str);
        View findViewById = inflate.findViewById(R.id.f27730h1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(R.id.prizeIcon)");
        ImageView imageView = (ImageView) findViewById;
        PBStringField pBStringField3 = prizeInfo.prize_icon;
        if (pBStringField3 != null) {
            str2 = pBStringField3.get();
        } else {
            str2 = null;
        }
        Q9(imageView, R.dimen.d5f, R.dimen.d5e, str2);
        View findViewById2 = inflate.findViewById(R.id.f99445pt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(R.id.tooltipImg)");
        ImageView imageView2 = (ImageView) findViewById2;
        QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial = activityInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
        if (qQCircleSpringPrizePopup$SpringMaterial != null && (pBStringField = qQCircleSpringPrizePopup$SpringMaterial.bubble) != null) {
            str3 = pBStringField.get();
        }
        Q9(imageView2, R.dimen.d5b, R.dimen.d5a, str3);
    }

    private final void N9(View dialogView, com.tencent.biz.qqcircle.immersive.viewmodel.activity.a activityInfo) {
        String str;
        View inflate = ((ViewStub) dialogView.findViewById(R.id.f166421zs4)).inflate();
        QQCircleSpringPrizePopup$StPrizeInfo prizeInfo = activityInfo.getPrizeInfo();
        TextView textView = (TextView) inflate.findViewById(R.id.f27740h2);
        PBStringField pBStringField = prizeInfo.prize_text;
        String str2 = null;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        textView.setText(str);
        View findViewById = inflate.findViewById(R.id.f27730h1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(R.id.prizeIcon)");
        ImageView imageView = (ImageView) findViewById;
        PBStringField pBStringField2 = prizeInfo.prize_icon;
        if (pBStringField2 != null) {
            str2 = pBStringField2.get();
        }
        Q9(imageView, R.dimen.d5c, R.dimen.d5c, str2);
    }

    private final void O9(View dialogView, com.tencent.biz.qqcircle.immersive.viewmodel.activity.a activityInfo) {
        String str;
        View inflate = ((ViewStub) dialogView.findViewById(R.id.f96355hg)).inflate();
        QQCircleSpringPrizePopup$StPrizeInfo prizeInfo = activityInfo.getPrizeInfo();
        TextView textView = (TextView) inflate.findViewById(R.id.f27740h2);
        PBStringField pBStringField = prizeInfo.prize_text;
        String str2 = null;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        textView.setText(str);
        View findViewById = inflate.findViewById(R.id.f27730h1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(R.id.prizeIcon)");
        ImageView imageView = (ImageView) findViewById;
        PBStringField pBStringField2 = prizeInfo.prize_icon;
        if (pBStringField2 != null) {
            str2 = pBStringField2.get();
        }
        Q9(imageView, R.dimen.d5f, R.dimen.d5e, str2);
    }

    private final void P9(float scale) {
        U9(R.dimen.d5_, scale);
        U9(R.dimen.d59, scale);
        U9(R.dimen.d5c, scale);
        U9(R.dimen.d5f, scale);
        U9(R.dimen.d5e, scale);
        U9(R.dimen.d5b, scale);
        U9(R.dimen.d5a, scale);
        U9(R.dimen.d57, scale);
        U9(R.dimen.d56, scale);
        U9(R.dimen.f159421d55, scale);
        U9(R.dimen.d58, scale);
    }

    private final void Q9(ImageView imageView, @DimenRes int i3, @DimenRes int i16, String str) {
        int i17;
        if (str != null) {
            QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
            Option url = Option.obtain().setTargetView(imageView).setUrl(str);
            Integer num = this.idToDimenRes.get(Integer.valueOf(i3));
            int i18 = 100;
            if (num != null) {
                i17 = num.intValue();
            } else {
                i17 = 100;
            }
            Option requestWidth = url.setRequestWidth(i17);
            Integer num2 = this.idToDimenRes.get(Integer.valueOf(i16));
            if (num2 != null) {
                i18 = num2.intValue();
            }
            g16.loadImage(requestWidth.setRequestHeight(i18).setLoadingDrawableColor(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QFSSpringFestivalActivityDialogPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9().b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(FeedCloudMeta$StShare stShare) {
        if (stShare == null) {
            QLog.e("QFSSpringFestivalActivityDialogPart", 1, "openSharePanel, stShare is null.");
            return;
        }
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed.share.set(stShare);
        qCircleShareInfo.feed = feedCloudMeta$StFeed;
        qCircleShareInfo.feedBlockData = new e30.b(feedCloudMeta$StFeed);
        qCircleShareInfo.source = 0;
        qCircleShareInfo.type = 11;
        broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
    }

    private final void U9(@DimenRes int id5, float scale) {
        int i3;
        Map<Integer, Integer> map = this.idToDimenRes;
        Integer valueOf = Integer.valueOf(id5);
        try {
            i3 = (int) (getContext().getResources().getDimensionPixelSize(id5) * scale);
        } catch (Exception unused) {
            i3 = 100;
        }
        map.put(valueOf, Integer.valueOf(i3));
    }

    private final void V9(QQCircleSpringPrizePopup$StPrizeInfo prizeInfo, String eid, Boolean isLimited) {
        String str;
        Map<String, Object> L9 = L9(prizeInfo);
        L9.put("xsj_eid", eid);
        L9.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EID, QCircleDaTongConstant.ElementId.EM_XSJ_SPRING_FESTIVAL_ACTIVITY_PUBLISH_POPUP);
        if (isLimited != null) {
            if (isLimited.booleanValue()) {
                str = "1";
            } else {
                str = "0";
            }
            L9.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_PRIZE_OBTAIN_REACH_LIMIT, str);
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", L9);
    }

    private final void W9(QQCircleSpringPrizePopup$StPrizeInfo prizeInfo) {
        Map<String, Object> L9 = L9(prizeInfo);
        L9.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SPRING_FESTIVAL_ACTIVITY_PUBLISH_POPUP);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", L9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(com.tencent.biz.qqcircle.immersive.viewmodel.activity.a activityInfo) {
        if (this.dialog != null) {
            QLog.i("QFSSpringFestivalActivityDialogPart", 1, "dialog exist, discard this info");
            return;
        }
        com.tencent.biz.qqcircle.widgets.comment.e eVar = new com.tencent.biz.qqcircle.widgets.comment.e(getContext());
        Window window = eVar.getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setFlags(1024, 1024);
            window.setLayout(-1, -1);
            window.setGravity(17);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        eVar.setCanceledOnTouchOutside(false);
        eVar.setContentView(I9(activityInfo));
        eVar.O();
        this.dialog = eVar;
        W9(activityInfo.getPrizeInfo());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSLazyExecuteEvent.class, QFSSpringFestivalPartStateEvent.class, QFSSpringPrizePopupInfoEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (!INSTANCE.a()) {
            QLog.i("QFSSpringFestivalActivityDialogPart", 1, "[onInitView] isDisable");
            return;
        }
        c cVar = new c();
        this.publishCallback = cVar;
        QCirclePublishCallbackHelper.f93064a.i(cVar, true);
        SimpleEventBus.getInstance().registerReceiver(this);
        LiveData<com.tencent.biz.qqcircle.immersive.viewmodel.activity.a> Q1 = K9().Q1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.biz.qqcircle.immersive.viewmodel.activity.a, Unit> function1 = new Function1<com.tencent.biz.qqcircle.immersive.viewmodel.activity.a, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSSpringFestivalActivityDialogPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.biz.qqcircle.immersive.viewmodel.activity.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.biz.qqcircle.immersive.viewmodel.activity.a aVar) {
                if (aVar == null) {
                    return;
                }
                QFSSpringFestivalActivityDialogPart.this.K9().U1(aVar.getPopupId());
                QFSSpringFestivalActivityDialogPart.this.X9(aVar);
            }
        };
        Q1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.fm
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSSpringFestivalActivityDialogPart.R9(Function1.this, obj);
            }
        });
        SimpleEventBus.getInstance().dispatchEvent(new QFSSpringFestivalPartStateEvent(true, hashCode()));
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().dispatchEvent(new QFSSpringFestivalPartStateEvent(false, hashCode()));
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.biz.qqcircle.widgets.a aVar = this.publishCallback;
        if (aVar != null) {
            QCirclePublishCallbackHelper.f93064a.v(aVar);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QFSLazyExecuteEvent) {
            QFSLazyExecuteEvent qFSLazyExecuteEvent = (QFSLazyExecuteEvent) event;
            if (qFSLazyExecuteEvent.getNotifyId() == 6 && !this.isImageResPreloaded) {
                this.isImageResPreloaded = true;
                qFSLazyExecuteEvent.injectExecution(new QFSLazyExecuteEvent.a() { // from class: com.tencent.biz.qqcircle.immersive.part.fl
                    @Override // com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent.a
                    public final void execute() {
                        QFSSpringFestivalActivityDialogPart.S9(QFSSpringFestivalActivityDialogPart.this);
                    }
                });
                return;
            }
            return;
        }
        if (event instanceof QFSSpringPrizePopupInfoEvent) {
            K9().Z1(((QFSSpringPrizePopupInfoEvent) event).getInfo());
            return;
        }
        if (event instanceof QFSSpringFestivalPartStateEvent) {
            QFSSpringFestivalPartStateEvent qFSSpringFestivalPartStateEvent = (QFSSpringFestivalPartStateEvent) event;
            if (qFSSpringFestivalPartStateEvent.getInstanceHashCode() != hashCode()) {
                QLog.i("QFSSpringFestivalActivityDialogPart", 1, "[onReceiveEvent] event=" + event);
                com.tencent.biz.qqcircle.widgets.a aVar = this.publishCallback;
                if (aVar != null) {
                    if (qFSSpringFestivalPartStateEvent.getIsInit()) {
                        QCirclePublishCallbackHelper.f93064a.v(aVar);
                    } else {
                        QCirclePublishCallbackHelper.f93064a.i(aVar, true);
                    }
                }
            }
        }
    }
}
