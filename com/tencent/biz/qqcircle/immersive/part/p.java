package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.util.Supplier;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSJumpPublishEvent;
import com.tencent.biz.qqcircle.immersive.part.p;
import com.tencent.biz.qqcircle.immersive.request.QFSActivityCheckPrizeReq;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleYuhengActivity$CheckPrizeRsp;
import qqcircle.QQCircleYuhengActivity$YuhengInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001JB#\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0$\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130$\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!0 j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!`\"H\u0016R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130$8\u0006\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010>\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00105R\u0016\u0010@\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010B\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u00109R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/p;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/qqcircle/immersive/feed/event/QFSJumpPublishEvent;", "", "H9", "G9", "Lqqcircle/QQCircleYuhengActivity$CheckPrizeRsp;", "rsp", "F9", "I9", "O9", "", "yuhengActivityId", "yuhengTaskId", "yuhengRuleId", "J9", "L9", "E9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroidx/core/util/Supplier;", "d", "Landroidx/core/util/Supplier;", "getCurPageIdSupplier", "()Landroidx/core/util/Supplier;", "curPageIdSupplier", "e", "getCurDTPageIdSupplier", "curDTPageIdSupplier", "f", "Ljava/lang/String;", "lastFeedId", "Lcom/tencent/biz/qqcircle/widgets/a;", tl.h.F, "Lcom/tencent/biz/qqcircle/widgets/a;", "publishCallback", "i", "Landroid/view/View;", "dialogRoot", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "dialogBg", BdhLogUtil.LogTag.Tag_Conn, "dialogClose", "D", "centerBtn", "E", "giftThumb", UserInfo.SEX_FEMALE, "giftThumbBg", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "giftDesc", "<init>", "(Landroidx/core/util/Supplier;Landroidx/core/util/Supplier;)V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class p extends u implements SimpleEventReceiver<QFSJumpPublishEvent> {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int I = ViewUtils.pxToDp(100.0f);
    private static final int J = ViewUtils.pxToDp(118.0f);
    private static final int K = ViewUtils.pxToDp(118.0f);
    private static final int L = ViewUtils.pxToDp(86.0f);
    private static final int M = ViewUtils.pxToDp(65.0f);

    @NotNull
    private static final HashMap<Integer, Integer> N = new HashMap<>();

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView dialogClose;

    /* renamed from: D, reason: from kotlin metadata */
    private View centerBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView giftThumb;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView giftThumbBg;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView giftDesc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<Integer> curPageIdSupplier;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<String> curDTPageIdSupplier;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String lastFeedId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.widgets.a publishCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View dialogRoot;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView dialogBg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0017j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/p$a;", "", "Lcom/tencent/biz/qqcircle/immersive/part/p;", "part", "", "b", "Landroid/view/View;", "view", "", "expandTouchWidth", "", "c", "", "FONT_FAMILY_NAME", "Ljava/lang/String;", "PART_STATUS_ACTIVE", "I", "PART_STATUS_INACTIVE", "PRICE_NAME_TEXT_COLOR", "", "PRICE_NAME_TEXT_SIZE", UserInfo.SEX_FEMALE, "WANGZHEDAOJU_MATE_ACTIVITY_TYPE", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "partInstanceStateRecord", "Ljava/util/HashMap;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.p$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(View view, int i3, View parentView) {
            Intrinsics.checkNotNullParameter(view, "$view");
            Intrinsics.checkNotNullParameter(parentView, "$parentView");
            Rect rect = new Rect();
            view.getHitRect(rect);
            rect.top -= i3;
            rect.bottom += i3;
            rect.left -= i3;
            rect.right += i3;
            parentView.setTouchDelegate(new TouchDelegate(rect, view));
        }

        public final boolean b(@NotNull p part) {
            Intrinsics.checkNotNullParameter(part, "part");
            Integer num = (Integer) p.N.get(Integer.valueOf(part.hashCode()));
            if (num != null && num.intValue() == 1) {
                return true;
            }
            if (p.N.containsKey(Integer.valueOf(part.hashCode())) && p.N.size() == 1) {
                return true;
            }
            return false;
        }

        public final void c(@NotNull final View view, final int expandTouchWidth) {
            Intrinsics.checkNotNullParameter(view, "view");
            Object parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            final View view2 = (View) parent;
            view2.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.o
                @Override // java.lang.Runnable
                public final void run() {
                    p.Companion.d(view, expandTouchWidth, view2);
                }
            });
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/p$b", "Lcom/tencent/biz/qqcircle/widgets/a;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "", "onTaskStateChanged", "onProgressChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends com.tencent.biz.qqcircle.widgets.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onProgressChanged(@NotNull TaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onTaskStateChanged(@NotNull TaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            Bundle transParams = taskInfo.getTransParams();
            if (transParams != null) {
                QLog.i(p.this.getTAG(), 1, "mate activity type:" + transParams.get(QQWinkConstants.KEY_MATE_ACTIVITY_TYPE));
                if (taskInfo.isSuccess() && taskInfo.isFinish() && Intrinsics.areEqual(transParams.get(QQWinkConstants.KEY_MATE_ACTIVITY_TYPE), (Object) 2)) {
                    p.this.lastFeedId = taskInfo.getFeedId();
                    if (p.INSTANCE.b(p.this)) {
                        p.this.J9(transParams.getInt(QQWinkConstants.KEY_MATE_YUHENG_ACTIVITY_ID), transParams.getInt(QQWinkConstants.KEY_MATE_YUHENG_TASK_ID), transParams.getInt(QQWinkConstants.KEY_MATE_YUHENG_RULE_ID));
                    }
                }
            }
        }
    }

    public p(@NotNull Supplier<Integer> curPageIdSupplier, @NotNull Supplier<String> curDTPageIdSupplier) {
        Intrinsics.checkNotNullParameter(curPageIdSupplier, "curPageIdSupplier");
        Intrinsics.checkNotNullParameter(curDTPageIdSupplier, "curDTPageIdSupplier");
        this.curPageIdSupplier = curPageIdSupplier;
        this.curDTPageIdSupplier = curDTPageIdSupplier;
        this.lastFeedId = "";
    }

    private final void E9() {
        ViewGroup viewGroup;
        View view;
        View partRootView = getPartRootView();
        if (partRootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) partRootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null && (view = this.dialogRoot) != null) {
            viewGroup.removeView(view);
        }
    }

    private final void F9(QQCircleYuhengActivity$CheckPrizeRsp rsp) {
        HashMap hashMap;
        VideoReport.setPageId(this.dialogRoot, this.curDTPageIdSupplier.get());
        View view = this.centerBtn;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerBtn");
            view = null;
        }
        VideoReport.setPageId(view, this.curDTPageIdSupplier.get());
        ImageView imageView2 = this.dialogClose;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogClose");
            imageView2 = null;
        }
        VideoReport.setPageId(imageView2, this.curDTPageIdSupplier.get());
        VideoReport.setElementId(this.dialogRoot, QCircleDaTongConstant.ElementId.EM_XSJ_RECEIVE_WANGZHE_PORP_POPUP);
        View view2 = this.centerBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerBtn");
            view2 = null;
        }
        VideoReport.setElementId(view2, QCircleDaTongConstant.ElementId.EM_XSJ_GOTO_RECEIVE_BUTTON);
        ImageView imageView3 = this.dialogClose;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogClose");
            imageView3 = null;
        }
        VideoReport.setElementId(imageView3, "em_xsj_close_button");
        Intrinsics.checkNotNullExpressionValue(rsp.prize_details.get(), "rsp.prize_details.get()");
        if (!r0.isEmpty()) {
            hashMap = MapsKt__MapsKt.hashMapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH"), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_GIFT_TYPE, String.valueOf(rsp.prize_details.get().get(0).prize_type.get())), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_GIFT_ID, String.valueOf(rsp.prize_details.get().get(0).prize_id.get())));
        } else {
            hashMap = new HashMap();
        }
        View view3 = this.dialogRoot;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(view3, exposurePolicy);
        View view4 = this.centerBtn;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerBtn");
            view4 = null;
        }
        VideoReport.setElementExposePolicy(view4, exposurePolicy);
        ImageView imageView4 = this.dialogClose;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogClose");
            imageView4 = null;
        }
        VideoReport.setElementExposePolicy(imageView4, exposurePolicy);
        ImageView imageView5 = this.dialogClose;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogClose");
            imageView5 = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(imageView5, clickPolicy);
        View view5 = this.centerBtn;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerBtn");
            view5 = null;
        }
        VideoReport.setElementClickPolicy(view5, clickPolicy);
        ImageView imageView6 = this.dialogClose;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogClose");
            imageView6 = null;
        }
        VideoReport.setElementClickPolicy(imageView6, clickPolicy);
        VideoReport.setElementParams(this.dialogRoot, hashMap);
        View view6 = this.centerBtn;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerBtn");
            view6 = null;
        }
        VideoReport.setElementParams(view6, hashMap);
        ImageView imageView7 = this.dialogClose;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogClose");
        } else {
            imageView = imageView7;
        }
        VideoReport.setElementParams(imageView, hashMap);
    }

    private final void G9() {
        ViewGroup viewGroup;
        View partRootView = getPartRootView();
        ImageView imageView = null;
        if (partRootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) partRootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        View findViewById = LayoutInflater.from(getContext()).inflate(R.layout.gok, viewGroup).findViewById(R.id.bja);
        this.dialogRoot = findViewById;
        if (findViewById != null) {
            View findViewById2 = findViewById.findViewById(R.id.uhb);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById<ImageView>(R.id.dialogBg)");
            this.dialogBg = (ImageView) findViewById2;
            View findViewById3 = findViewById.findViewById(R.id.uhd);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById<ImageView>(R.id.dialogClose)");
            this.dialogClose = (ImageView) findViewById3;
            View findViewById4 = findViewById.findViewById(R.id.f164759tq4);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById<View>(R.id.centerBtn)");
            this.centerBtn = findViewById4;
            View findViewById5 = findViewById.findViewById(R.id.vow);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "it.findViewById<ImageView>(R.id.giftThumb)");
            this.giftThumb = (ImageView) findViewById5;
            View findViewById6 = findViewById.findViewById(R.id.vox);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "it.findViewById(R.id.giftThumbBg)");
            ImageView imageView2 = (ImageView) findViewById6;
            this.giftThumbBg = imageView2;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftThumbBg");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            View findViewById7 = findViewById.findViewById(R.id.vo6);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "it.findViewById<TextView>(R.id.giftDesc)");
            TextView textView = (TextView) findViewById7;
            this.giftDesc = textView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftDesc");
                textView = null;
            }
            textView.setTextColor(Color.parseColor("#6D4A30"));
            TextView textView2 = this.giftDesc;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftDesc");
                textView2 = null;
            }
            textView2.setTextSize(ViewUtils.pxToDp(40.0f));
            Typeface create = Typeface.create("PingFang-SC", 1);
            TextView textView3 = this.giftDesc;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftDesc");
                textView3 = null;
            }
            textView3.setTypeface(create);
            Companion companion = INSTANCE;
            View view = this.centerBtn;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerBtn");
                view = null;
            }
            companion.c(view, I);
            QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
            Option url = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_wangzhedaoju_popup"));
            ImageView imageView3 = this.dialogBg;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogBg");
                imageView3 = null;
            }
            g16.loadImage(url.setTargetView(imageView3));
            QCircleFeedPicLoader g17 = QCircleFeedPicLoader.g();
            Option regionHeight = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_wangzhedaoju_bg_rewards")).setRegionWidth(J).setRegionHeight(K);
            ImageView imageView4 = this.giftThumbBg;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftThumbBg");
            } else {
                imageView = imageView4;
            }
            g17.loadImage(regionHeight.setTargetView(imageView));
        }
    }

    private final void H9() {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_wangzhedaoju_popup")));
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_wangzhedaoju_bg_rewards")));
    }

    private final void I9() {
        if (this.publishCallback == null) {
            this.publishCallback = new b();
        }
        QCirclePublishCallbackHelper.f93064a.i(this.publishCallback, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(int yuhengActivityId, int yuhengTaskId, int yuhengRuleId) {
        VSNetworkHelper vSNetworkHelper = VSNetworkHelper.getInstance();
        QFSActivityCheckPrizeReq qFSActivityCheckPrizeReq = new QFSActivityCheckPrizeReq();
        QQCircleYuhengActivity$YuhengInfo qQCircleYuhengActivity$YuhengInfo = new QQCircleYuhengActivity$YuhengInfo();
        qQCircleYuhengActivity$YuhengInfo.activity_id.set(yuhengActivityId);
        qQCircleYuhengActivity$YuhengInfo.rule_id.set(yuhengRuleId);
        qQCircleYuhengActivity$YuhengInfo.task_id.set(yuhengTaskId);
        qFSActivityCheckPrizeReq.setYuhengInfo(qQCircleYuhengActivity$YuhengInfo);
        vSNetworkHelper.sendRequest(RFWApplication.getApplication(), qFSActivityCheckPrizeReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.part.l
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                p.K9(p.this, baseRequest, z16, j3, str, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(p this$0, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.getTAG(), 1, "[requestPrize] onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + baseRequest);
        if ((obj instanceof QQCircleYuhengActivity$CheckPrizeRsp) && j3 == 0 && z16) {
            QQCircleYuhengActivity$CheckPrizeRsp qQCircleYuhengActivity$CheckPrizeRsp = (QQCircleYuhengActivity$CheckPrizeRsp) obj;
            QLog.d(this$0.getTAG(), 1, "[requestPrize] draw result:" + qQCircleYuhengActivity$CheckPrizeRsp.draw_result.get());
            if (qQCircleYuhengActivity$CheckPrizeRsp.draw_result.get() == 1) {
                this$0.L9(qQCircleYuhengActivity$CheckPrizeRsp);
            }
        }
    }

    private final void L9(final QQCircleYuhengActivity$CheckPrizeRsp rsp) {
        boolean contains;
        boolean z16;
        boolean z17;
        boolean z18 = false;
        contains = ArraysKt___ArraysKt.contains(new Integer[]{501, 503, 504}, this.curPageIdSupplier.get());
        if (!contains) {
            QLog.i(getTAG(), 1, "in another tab ignore");
            return;
        }
        G9();
        F9(rsp);
        Intrinsics.checkNotNullExpressionValue(rsp.prize_details.get(), "rsp.prize_details.get()");
        ImageView imageView = null;
        if (!r0.isEmpty()) {
            String str = rsp.prize_details.get().get(0).prize_name.get();
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = getContext().getString(R.string.f196444hb);
            }
            TextView textView = this.giftDesc;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftDesc");
                textView = null;
            }
            textView.setText(str);
            String priceIconUrl = rsp.prize_details.get().get(0).detail.prize_icon.get();
            if (priceIconUrl.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                priceIconUrl = QCircleSkinHelper.getInstance().getUrl("qvideo_wangzhedaoju_icon");
            }
            Intrinsics.checkNotNullExpressionValue(priceIconUrl, "priceIconUrl");
            if (priceIconUrl.length() > 0) {
                z18 = true;
            }
            if (z18) {
                QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
                Option regionHeight = Option.obtain().setUrl(priceIconUrl).setRegionWidth(L).setRegionHeight(M);
                ImageView imageView2 = this.giftThumb;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("giftThumb");
                    imageView2 = null;
                }
                g16.loadImage(regionHeight.setTargetView(imageView2));
            }
            QLog.d(getTAG(), 1, "[showDialog] price name:" + str + ", icon url:" + priceIconUrl);
        }
        View view = this.centerBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerBtn");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.M9(p.this, rsp, view2);
            }
        });
        ImageView imageView3 = this.dialogClose;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogClose");
        } else {
            imageView = imageView3;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.N9(p.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(p this$0, QQCircleYuhengActivity$CheckPrizeRsp rsp, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        this$0.E9();
        String str = rsp.jump_url.get();
        QLog.d(this$0.getTAG(), 1, "[showDialog] jump to url:" + str);
        com.tencent.biz.qqcircle.launcher.c.g(this$0.getContext(), str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(p this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O9() {
        com.tencent.biz.qqcircle.widgets.a aVar = this.publishCallback;
        if (aVar != null) {
            QCirclePublishCallbackHelper.f93064a.v(aVar);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QFSJumpPublishEvent>> getEventClass() {
        ArrayList<Class<QFSJumpPublishEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSJumpPublishEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSActivityKingDialogPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        H9();
        I9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        O9();
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        N.put(Integer.valueOf(hashCode()), 2);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        N.put(Integer.valueOf(hashCode()), 1);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QFSJumpPublishEvent) {
            E9();
        }
    }
}
