package com.tencent.mobileqq.guild.feed.gallery.presenter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.core.util.Supplier;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.extension.FlowKt;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.event.GuildDetailViewDestroyEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShareChannelEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.gallery.constants.GuildFeedGalleryMessage;
import com.tencent.mobileqq.guild.feed.gallery.data.GuildGalleryCommentPanelParams;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryPagerEvent;
import com.tencent.mobileqq.guild.feed.gallery.part.s;
import com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter;
import com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$dataReportManage$2;
import com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$inputMessageDelegate$2;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kn1.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.InputStyleConfig;
import wk1.g;

@Metadata(d1 = {"\u0000\u00d1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0003\u0007lq\u0018\u0000 \u008c\u00012\u00020\u0001:\u0004\u008d\u0001\u008e\u0001B\u0013\u0012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000f\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J+\u0010\u001b\u001a\u00020\u00022!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010 \u001a\u00020\u0012H\u0002J\u0012\u0010!\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\nH\u0002J\u0012\u0010&\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0012\u0010(\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010)\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010+\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010,\u001a\u00020\u0002H\u0002J\u001e\u00102\u001a\u00020\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u00101\u001a\u000200H\u0002J\u0010\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0004H\u0016J\b\u00105\u001a\u00020\u0002H\u0016J\b\u00106\u001a\u00020\u0002H\u0016J\u0010\u00107\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u00109\u001a\u00020\u00022\b\u00108\u001a\u0004\u0018\u00010\n2\b\u0010*\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010<\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u000200H\u0016J*\u0010>\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u0002002\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010-H\u0016J\u0012\u0010A\u001a\u00020\u00022\b\u0010@\u001a\u0004\u0018\u00010?H\u0016J$\u0010E\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0C0Bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0C`DH\u0016J\u0012\u0010H\u001a\u00020\u00022\b\u0010G\u001a\u0004\u0018\u00010FH\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001b\u0010b\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001c\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010d0c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u001b\u0010p\u001a\u00020l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010_\u001a\u0004\bn\u0010oR\u001b\u0010u\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\br\u0010_\u001a\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR$\u0010\u007f\u001a\u0002002\u0006\u0010z\u001a\u0002008B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R'\u0010\u0082\u0001\u001a\u0002002\u0006\u0010z\u001a\u0002008B@BX\u0082\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010|\"\u0005\b\u0081\u0001\u0010~R'\u0010\u0085\u0001\u001a\u0002002\u0006\u0010z\u001a\u0002008B@BX\u0082\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0083\u0001\u0010|\"\u0005\b\u0084\u0001\u0010~R&\u0010\u0087\u0001\u001a\u0002002\u0006\u0010z\u001a\u0002008B@BX\u0082\u000e\u00a2\u0006\r\u001a\u0004\bX\u0010|\"\u0005\b\u0086\u0001\u0010~\u00a8\u0006\u008f\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter;", "Lcom/tencent/mobileqq/guild/feed/gallery/presenter/b;", "", "A0", "Landroid/view/View;", "requestView", "w0", "com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$generateInputContextProvider$1", "Y", "()Lcom/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$generateInputContextProvider$1;", "", "e0", "Lco1/k;", "X", "D0", "V", "W", "E0", "", "x0", "K0", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "Lkotlin/ParameterName;", "name", "type", "block", "i0", "", "msg", "k0", "m0", "y0", "p0", "args", "q0", "sourceTag", "B0", "s0", "v0", "o0", "j0", "data", "r0", "z0", "", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "richMediaData", "", "curPos", "J0", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "r", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onPreloadResult", "action", "g", "Ljk1/a;", "position", "k", "payloads", "l", "Lcom/tencent/mobileqq/guild/feed/manager/f;", "selectInfo", "p", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "D", "Landroid/view/View;", "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", "inputRootView", "Lal1/a;", UserInfo.SEX_FEMALE, "Lal1/a;", "inputLayout", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "G", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", "H", "Z", "curDivideLineShow", "I", "Ljava/lang/String;", "curGuildIdBound", "Lwk1/m;", "J", "Lkotlin/Lazy;", "g0", "()Lwk1/m;", "inputStyleConfig", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$PresenterLifecycleOwner;", "K", "Landroidx/lifecycle/MutableLiveData;", "simpleLifecycleOwner", "Lkotlinx/coroutines/Job;", "L", "Lkotlinx/coroutines/Job;", "feedPublishJob", "com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$inputMessageDelegate$2$a", "M", "f0", "()Lcom/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$inputMessageDelegate$2$a;", "inputMessageDelegate", "com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$dataReportManage$2$a", "N", "d0", "()Lcom/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$dataReportManage$2$a;", "dataReportManage", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/BottomGuideBarDelegateDefaultImpl;", "P", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/BottomGuideBarDelegateDefaultImpl;", "guideBarDependencyRef", "value", "b0", "()I", "H0", "(I)V", "curPreferStatus", "a0", "G0", "curPreferCount", "c0", "I0", "curShareCount", "F0", "curCommentCount", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "defaultBean", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "PresenterLifecycleOwner", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryBottomPresenter extends com.tencent.mobileqq.guild.feed.gallery.presenter.b {
    private static final ie0.a R = ie0.a.f();

    /* renamed from: D, reason: from kotlin metadata */
    private View requestView;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup inputRootView;

    /* renamed from: F, reason: from kotlin metadata */
    private al1.a inputLayout;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private GuildFeedGalleryInitBean initBean;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean curDivideLineShow;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String curGuildIdBound;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputStyleConfig;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<PresenterLifecycleOwner> simpleLifecycleOwner;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Job feedPublishJob;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputMessageDelegate;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy dataReportManage;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private BottomGuideBarDelegateDefaultImpl guideBarDependencyRef;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u001b\u0010\f\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$PresenterLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "b", "d", "Lkotlin/Lazy;", "a", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class PresenterLifecycleOwner implements LifecycleOwner {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy lifecycleRegistry;

        public PresenterLifecycleOwner() {
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<LifecycleRegistry>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$PresenterLifecycleOwner$lifecycleRegistry$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LifecycleRegistry invoke() {
                    return new LifecycleRegistry(GuildFeedGalleryBottomPresenter.PresenterLifecycleOwner.this);
                }
            });
            this.lifecycleRegistry = lazy;
        }

        private final LifecycleRegistry a() {
            return (LifecycleRegistry) this.lifecycleRegistry.getValue();
        }

        public final void b(@NotNull Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
            a().handleLifecycleEvent(event);
        }

        @Override // androidx.lifecycle.LifecycleOwner
        @NotNull
        public LifecycleRegistry getLifecycle() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$b", "Lco1/k;", "Landroid/view/View;", "servedRootView", "", "b", "who", NodeProps.ON_CLICK, "a", "", "d", "Ljava/lang/Integer;", "rootId", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends co1.k {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer rootId;

        b() {
        }

        @Override // co1.k
        public void a(@NotNull View who) {
            Intrinsics.checkNotNullParameter(who, "who");
            int id5 = who.getId();
            Integer num = this.rootId;
            if (num != null && id5 == num.intValue()) {
                VideoReport.reportEvent("imp", who, null);
            }
        }

        @Override // co1.k
        public void b(@NotNull View servedRootView) {
            Intrinsics.checkNotNullParameter(servedRootView, "servedRootView");
            this.rootId = Integer.valueOf(servedRootView.getId());
            ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
            bt.d(servedRootView, "em_sgrp_guide_join_channel", null, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
            View findViewById = servedRootView.findViewById(R.id.f165444w13);
            Intrinsics.checkNotNullExpressionValue(findViewById, "servedRootView.findViewById(R.id.guild_btn)");
            bt.d(findViewById, "em_sgrp_join_channel_btn", null, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
        }

        @Override // co1.k, android.view.View.OnClickListener
        public void onClick(@NotNull View who) {
            EventCollector.getInstance().onViewClickedBefore(who);
            Intrinsics.checkNotNullParameter(who, "who");
            if (who.getId() == R.id.f165444w13) {
                VideoReport.reportEvent("clck", who, null);
            }
            EventCollector.getInstance().onViewClicked(who);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$c", "Lqj1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IBottomInteractDisplayable;", "", "e", "getCommentCount", "d", "getPreferStatus", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements qj1.b {
        c() {
        }

        @Override // qj1.b
        public boolean A() {
            return GuildFeedGalleryBottomPresenter.this.curDivideLineShow;
        }

        @Override // qj1.b
        public int d() {
            return GuildFeedGalleryBottomPresenter.this.c0();
        }

        @Override // qj1.b
        public int e() {
            return GuildFeedGalleryBottomPresenter.this.a0();
        }

        @Override // qj1.b
        public int getCommentCount() {
            return GuildFeedGalleryBottomPresenter.this.Z();
        }

        @Override // qj1.b
        public int getPreferStatus() {
            return GuildFeedGalleryBottomPresenter.this.b0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryBottomPresenter(@NotNull GuildFeedDefaultInitBean defaultBean) {
        super(defaultBean);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(defaultBean, "defaultBean");
        this.curDivideLineShow = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<InputStyleConfig>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$inputStyleConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final InputStyleConfig invoke() {
                ViewGroup viewGroup;
                Context context;
                ie0.a aVar;
                ie0.a aVar2;
                ie0.a aVar3;
                ViewGroup viewGroup2;
                viewGroup = GuildFeedGalleryBottomPresenter.this.inputRootView;
                if (viewGroup != null) {
                    viewGroup2 = GuildFeedGalleryBottomPresenter.this.inputRootView;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("inputRootView");
                        viewGroup2 = null;
                    }
                    context = viewGroup2.getContext();
                } else {
                    context = MobileQQ.sMobileQQ;
                }
                ColorDrawable colorDrawable = new ColorDrawable(-16777216);
                aVar = GuildFeedGalleryBottomPresenter.R;
                Integer valueOf = Integer.valueOf(aVar.g(context, R.color.qui_common_icon_primary, 1002));
                aVar2 = GuildFeedGalleryBottomPresenter.R;
                Integer valueOf2 = Integer.valueOf(aVar2.g(context, R.color.qui_common_text_secondary, 1002));
                aVar3 = GuildFeedGalleryBottomPresenter.R;
                return new InputStyleConfig(colorDrawable, valueOf, valueOf2, aVar3.k(context, R.color.qui_common_fill_standard_primary, cw.c(8.0f), 1002), 20L, 0.5f, R.drawable.guild_feed_gallery_divide_line_bg);
            }
        });
        this.inputStyleConfig = lazy;
        this.simpleLifecycleOwner = new MutableLiveData<>();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedGalleryBottomPresenter$inputMessageDelegate$2.a>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$inputMessageDelegate$2

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$inputMessageDelegate$2$a", "Lwk1/i;", "", "action", "", "msg", "", "lh", "I2", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements wk1.i {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GuildFeedGalleryBottomPresenter f219720d;

                a(GuildFeedGalleryBottomPresenter guildFeedGalleryBottomPresenter) {
                    this.f219720d = guildFeedGalleryBottomPresenter;
                }

                @Override // wk1.i
                @Nullable
                public Object I2(@NotNull String action, @Nullable Object msg2) {
                    Intrinsics.checkNotNullParameter(action, "action");
                    return null;
                }

                @Override // wk1.i
                public void lh(@NotNull String action, @Nullable Object msg2) {
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean;
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean2;
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean3;
                    Intrinsics.checkNotNullParameter(action, "action");
                    switch (action.hashCode()) {
                        case -1571406538:
                            if (action.equals("message_share_feed")) {
                                bn bnVar = bn.f223895a;
                                guildFeedGalleryInitBean = this.f219720d.initBean;
                                Intrinsics.checkNotNull(guildFeedGalleryInitBean);
                                if (!bnVar.d(guildFeedGalleryInitBean.getGuildFeedPublishInfo())) {
                                    this.f219720d.s0(msg2);
                                    return;
                                }
                                return;
                            }
                            return;
                        case -729901398:
                            if (action.equals("message_comment_box_feed")) {
                                bn bnVar2 = bn.f223895a;
                                guildFeedGalleryInitBean2 = this.f219720d.initBean;
                                Intrinsics.checkNotNull(guildFeedGalleryInitBean2);
                                if (!bnVar2.d(guildFeedGalleryInitBean2.getGuildFeedPublishInfo())) {
                                    this.f219720d.k0(msg2);
                                    return;
                                }
                                return;
                            }
                            return;
                        case -527176932:
                            if (action.equals("message_on_do_prefer")) {
                                this.f219720d.q0(msg2);
                                return;
                            }
                            return;
                        case 667130252:
                            if (action.equals("message_comment_icon_feed")) {
                                bn bnVar3 = bn.f223895a;
                                guildFeedGalleryInitBean3 = this.f219720d.initBean;
                                Intrinsics.checkNotNull(guildFeedGalleryInitBean3);
                                if (!bnVar3.d(guildFeedGalleryInitBean3.getGuildFeedPublishInfo())) {
                                    this.f219720d.m0(msg2);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 1994817324:
                            if (action.equals("message_modify_bottom_interact_data")) {
                                this.f219720d.p0(msg2);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedGalleryBottomPresenter.this);
            }
        });
        this.inputMessageDelegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedGalleryBottomPresenter$dataReportManage$2.a>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$dataReportManage$2

            @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\u000e\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$dataReportManage$2$a", "Lwk1/e;", "Landroid/view/View;", "view", "", "viewType", "Landroid/os/Bundle;", "extData", "", "c", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "b", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements wk1.e {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GuildFeedGalleryBottomPresenter f219716a;

                a(GuildFeedGalleryBottomPresenter guildFeedGalleryBottomPresenter) {
                    this.f219716a = guildFeedGalleryBottomPresenter;
                }

                @Override // wk1.e
                public boolean a() {
                    return false;
                }

                @Override // wk1.e
                @Nullable
                public HashMap<String, Object> b() {
                    return this.f219716a.d();
                }

                @Override // wk1.e
                public void c(@NotNull View view, int viewType, @Nullable Bundle extData) {
                    Map<String, Object> mutableMapOf;
                    Map<String, Object> mutableMapOf2;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (viewType != 1) {
                        if (viewType != 2) {
                            if (viewType != 3) {
                                if (viewType == 4) {
                                    ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_forum_share", "imp", this.f219716a.d());
                                    return;
                                }
                                return;
                            }
                            IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
                            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_click_region", 2));
                            HashMap<String, Object> elementDtParams = this.f219716a.d();
                            Intrinsics.checkNotNullExpressionValue(elementDtParams, "elementDtParams");
                            mutableMapOf2.putAll(elementDtParams);
                            Unit unit = Unit.INSTANCE;
                            iGuildDTReportApi.reportDtEventManual(view, "em_sgrp_forum_comment", "imp", mutableMapOf2);
                            return;
                        }
                        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_forum_up", "imp", this.f219716a.d());
                        return;
                    }
                    IGuildDTReportApi iGuildDTReportApi2 = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_click_region", 1));
                    HashMap<String, Object> elementDtParams2 = this.f219716a.d();
                    Intrinsics.checkNotNullExpressionValue(elementDtParams2, "elementDtParams");
                    mutableMapOf.putAll(elementDtParams2);
                    Unit unit2 = Unit.INSTANCE;
                    iGuildDTReportApi2.reportDtEventManual(view, "em_sgrp_forum_comment", "imp", mutableMapOf);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedGalleryBottomPresenter.this);
            }
        });
        this.dataReportManage = lazy3;
    }

    private final void A0() {
        final String str;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        if (guildFeedGalleryInitBean != null) {
            str = guildFeedGalleryInitBean.getPublishTaskId();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        Job job = this.feedPublishJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        final Flow<a.FeedPublishFinish> publishEndFlow = ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).publishEndFlow();
        this.feedPublishJob = FlowKt.a(new Flow<a.FeedPublishFinish>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$onFeedPublishObserve$$inlined$filter$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$onFeedPublishObserve$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<a.FeedPublishFinish> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f219711d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f219712e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$onFeedPublishObserve$$inlined$filter$1$2", f = "GuildFeedGalleryBottomPresenter.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$onFeedPublishObserve$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, String str) {
                    this.f219711d = flowCollector;
                    this.f219712e = str;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(a.FeedPublishFinish feedPublishFinish, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f219711d;
                                if (Intrinsics.areEqual(feedPublishFinish.getState().getTaskId(), this.f219712e)) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(feedPublishFinish, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super a.FeedPublishFinish> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, str), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new Function1<a.FeedPublishFinish, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$onFeedPublishObserve$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a.FeedPublishFinish feedPublishFinish) {
                invoke2(feedPublishFinish);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.FeedPublishFinish publishState) {
                al1.a aVar;
                Intrinsics.checkNotNullParameter(publishState, "publishState");
                aVar = GuildFeedGalleryBottomPresenter.this.inputLayout;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
                    aVar = null;
                }
                aVar.u1(kn1.c.c(publishState.getState().getTaskState()));
            }
        });
    }

    private final void B0(final String sourceTag) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryBottomPresenter.C0(GuildFeedGalleryBottomPresenter.this, sourceTag);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(GuildFeedGalleryBottomPresenter this$0, String sourceTag) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sourceTag, "$sourceTag");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this$0.initBean;
        if (guildFeedGalleryInitBean != null) {
            str = guildFeedGalleryInitBean.getGuildId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        com.tencent.mobileqq.guild.main.d.d(peekAppRuntime, str, sourceTag);
    }

    private final void D0() {
        al1.a aVar = this.inputLayout;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
            aVar = null;
        }
        aVar.lh("message_on_bottom_interact_exposure", null);
    }

    private final void E0() {
        if (x0()) {
            return;
        }
        PresenterLifecycleOwner value = this.simpleLifecycleOwner.getValue();
        if (value != null) {
            value.b(Lifecycle.Event.ON_DESTROY);
        }
        MutableLiveData<PresenterLifecycleOwner> mutableLiveData = this.simpleLifecycleOwner;
        PresenterLifecycleOwner presenterLifecycleOwner = new PresenterLifecycleOwner();
        presenterLifecycleOwner.b(Lifecycle.Event.ON_START);
        mutableLiveData.setValue(presenterLifecycleOwner);
    }

    private final void F0(int i3) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        guildFeedGalleryInitBean.getFeed().commentCount = i3;
    }

    private final void G0(int i3) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        guildFeedGalleryInitBean.getFeed().totalPrefer.preferCountWithoutLike = i3;
    }

    private final void H0(int i3) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        guildFeedGalleryInitBean.getFeed().totalPrefer.preferStatus = i3;
    }

    private final void I0(int i3) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        guildFeedGalleryInitBean.getFeed().share.sharedCount = i3;
    }

    private final void J0(List<GuildFeedRichMediaData> richMediaData, int curPos) {
        boolean z16;
        if (curPos >= richMediaData.size()) {
            return;
        }
        if (richMediaData.get(curPos).getType() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.curDivideLineShow = z16;
    }

    private final void K0() {
        if (x0()) {
            v0(SpeakPermissionType.PERMISSION_TYPE_SIMPLE_INIT);
            al1.a aVar = this.inputLayout;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
                aVar = null;
            }
            aVar.lh("message_on_do_visibility_change", new a.BottomInteractiveVisibilityChangeMessage(4, 8));
            return;
        }
        i0(new Function1<SpeakPermissionType, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$updateSpeakPermission$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpeakPermissionType speakPermissionType) {
                invoke2(speakPermissionType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SpeakPermissionType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                GuildFeedGalleryBottomPresenter.this.v0(type);
            }
        });
    }

    private final void V() {
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "bindData");
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        if (guildFeedGalleryInitBean == null) {
            return;
        }
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        List<GuildFeedRichMediaData> richMediaDataList = guildFeedGalleryInitBean.getRichMediaDataList();
        Intrinsics.checkNotNullExpressionValue(richMediaDataList, "initBean!!.richMediaDataList");
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean2);
        J0(richMediaDataList, guildFeedGalleryInitBean2.getEnterPos());
        z0();
        K0();
        W();
    }

    private final void W() {
        String str;
        boolean z16;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        al1.a aVar = null;
        if (guildFeedGalleryInitBean != null) {
            str = guildFeedGalleryInitBean.getGuildId();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(this.curGuildIdBound, str)) {
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                E0();
                this.curGuildIdBound = str;
                al1.a aVar2 = this.inputLayout;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
                } else {
                    aVar = aVar2;
                }
                aVar.V4();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final co1.k X() {
        return new b();
    }

    private final GuildFeedGalleryBottomPresenter$generateInputContextProvider$1 Y() {
        return new GuildFeedGalleryBottomPresenter$generateInputContextProvider$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Z() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        return guildFeedGalleryInitBean.getFeed().commentCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int a0() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        return guildFeedGalleryInitBean.getFeed().totalPrefer.preferCountWithoutLike;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b0() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        return guildFeedGalleryInitBean.getFeed().totalPrefer.preferStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int c0() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        return guildFeedGalleryInitBean.getFeed().share.sharedCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildFeedGalleryBottomPresenter$dataReportManage$2.a d0() {
        return (GuildFeedGalleryBottomPresenter$dataReportManage$2.a) this.dataReportManage.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e0() {
        String str;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        if (guildFeedGalleryInitBean == null) {
            return "";
        }
        if (!guildFeedGalleryInitBean.getAttrs().containsKey("sgrp_channel_extension_info") || !(guildFeedGalleryInitBean.getAttrs().get("sgrp_channel_extension_info") instanceof String)) {
            str = "";
        } else {
            Serializable serializable = guildFeedGalleryInitBean.getAttrs().get("sgrp_channel_extension_info");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type kotlin.String");
            str = (String) serializable;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildFeedGalleryBottomPresenter$inputMessageDelegate$2.a f0() {
        return (GuildFeedGalleryBottomPresenter$inputMessageDelegate$2.a) this.inputMessageDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputStyleConfig g0() {
        return (InputStyleConfig) this.inputStyleConfig.getValue();
    }

    private final void i0(Function1<? super SpeakPermissionType, Unit> block) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        String guildId = guildFeedGalleryInitBean.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        GuildMainFrameUtils.l(guildId, false, new GuildFeedGalleryBottomPresenter$getSpeakPermissionAsync$1(guildId, this, block));
    }

    private final void j0(Object msg2) {
        String str;
        if (!(msg2 instanceof GuildFeedGalleryMessage.CommentDataChangeArgs)) {
            return;
        }
        GuildFeedGalleryMessage.CommentDataChangeArgs commentDataChangeArgs = (GuildFeedGalleryMessage.CommentDataChangeArgs) msg2;
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleCommentDataChange feedId: " + commentDataChangeArgs.getFeedId() + " type: " + commentDataChangeArgs.getType() + " count: " + commentDataChangeArgs.getCount());
        String feedId = commentDataChangeArgs.getFeedId();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        String str2 = null;
        if (guildFeedGalleryInitBean != null) {
            str = guildFeedGalleryInitBean.getFeedId();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(feedId, str)) {
            if (commentDataChangeArgs.getType() == 1) {
                F0(commentDataChangeArgs.getCount());
            } else if (commentDataChangeArgs.getType() == 2) {
                F0(Z() + commentDataChangeArgs.getCount());
            }
            z0();
            return;
        }
        String feedId2 = commentDataChangeArgs.getFeedId();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.initBean;
        if (guildFeedGalleryInitBean2 != null) {
            str2 = guildFeedGalleryInitBean2.getFeedId();
        }
        QLog.e("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleCommentDataChange error feedId: " + feedId2 + " initBean feedId: " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(final Object msg2) {
        if (x0()) {
            h(this.f219734i.getContext(), this.initBean, 5, 5);
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleCommentFeedBoxMessage isFromTroop");
        } else {
            if (!(msg2 instanceof a.CommentFeedMessage)) {
                QLog.i("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleCommentFeedBoxMessage args error!");
                return;
            }
            mk1.e.f416895a.b(this.initBean);
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleCommentFeedBoxMessage, source = " + ((a.CommentFeedMessage) msg2).getSource());
            f(s.class).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.f
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    GuildFeedGalleryBottomPresenter.l0(GuildFeedGalleryBottomPresenter.this, msg2, (s) obj);
                }
            }).run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(final GuildFeedGalleryBottomPresenter this$0, final Object obj, final s sVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i0(new Function1<SpeakPermissionType, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$handleCommentFeedBoxMessage$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpeakPermissionType speakPermissionType) {
                invoke2(speakPermissionType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SpeakPermissionType type) {
                GuildFeedGalleryInitBean guildFeedGalleryInitBean;
                boolean y06;
                GuildFeedGalleryInitBean guildFeedGalleryInitBean2;
                Intrinsics.checkNotNullParameter(type, "type");
                s sVar2 = s.this;
                ShowInputComponentArgs inputArgs = ((a.CommentFeedMessage) obj).getInputArgs();
                guildFeedGalleryInitBean = this$0.initBean;
                Intrinsics.checkNotNull(guildFeedGalleryInitBean);
                GuildGalleryCommentPanelParams b16 = mk1.g.b(guildFeedGalleryInitBean);
                y06 = this$0.y0();
                guildFeedGalleryInitBean2 = this$0.initBean;
                Intrinsics.checkNotNull(guildFeedGalleryInitBean2);
                sVar2.F6(new GuildFeedGalleryMessage.CommentPanelShowProxyArgs(type, inputArgs, new GuildFeedGalleryMessage.CommentPanelShowArgs(b16, y06, true, null, null, guildFeedGalleryInitBean2.getFeed().commentCount == 0, 24, null)));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(final Object msg2) {
        if (x0()) {
            h(this.f219734i.getContext(), this.initBean, 2, 5);
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleCommentFeedIconMessage isFromTroop");
        } else {
            if (!(msg2 instanceof a.CommentFeedMessage)) {
                QLog.i("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleCommentFeedIconMessage args error!");
                return;
            }
            mk1.e.f416895a.b(this.initBean);
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleCommentFeedIconMessage, source = " + ((a.CommentFeedMessage) msg2).getSource());
            f(s.class).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.d
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    GuildFeedGalleryBottomPresenter.n0(GuildFeedGalleryBottomPresenter.this, msg2, (s) obj);
                }
            }).run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(final GuildFeedGalleryBottomPresenter this$0, final Object obj, final s sVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i0(new Function1<SpeakPermissionType, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$handleCommentFeedIconMessage$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpeakPermissionType speakPermissionType) {
                invoke2(speakPermissionType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SpeakPermissionType type) {
                GuildFeedGalleryInitBean guildFeedGalleryInitBean;
                GuildFeedGalleryInitBean guildFeedGalleryInitBean2;
                boolean y06;
                GuildFeedGalleryInitBean guildFeedGalleryInitBean3;
                Intrinsics.checkNotNullParameter(type, "type");
                s sVar2 = s.this;
                ShowInputComponentArgs inputArgs = ((a.CommentFeedMessage) obj).getInputArgs();
                guildFeedGalleryInitBean = this$0.initBean;
                Intrinsics.checkNotNull(guildFeedGalleryInitBean);
                GuildGalleryCommentPanelParams b16 = mk1.g.b(guildFeedGalleryInitBean);
                guildFeedGalleryInitBean2 = this$0.initBean;
                Intrinsics.checkNotNull(guildFeedGalleryInitBean2);
                boolean z16 = guildFeedGalleryInitBean2.getFeed().commentCount == 0;
                y06 = this$0.y0();
                guildFeedGalleryInitBean3 = this$0.initBean;
                Intrinsics.checkNotNull(guildFeedGalleryInitBean3);
                sVar2.F6(new GuildFeedGalleryMessage.CommentPanelShowProxyArgs(type, inputArgs, new GuildFeedGalleryMessage.CommentPanelShowArgs(b16, y06, z16, null, null, guildFeedGalleryInitBean3.getFeed().commentCount == 0, 24, null)));
            }
        });
    }

    private final void o0(Object msg2) {
        String str;
        if (!(msg2 instanceof String)) {
            return;
        }
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        String str2 = null;
        if (guildFeedGalleryInitBean != null) {
            str = guildFeedGalleryInitBean.getFeedId();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(msg2, str)) {
            GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.initBean;
            if (guildFeedGalleryInitBean2 != null) {
                str2 = guildFeedGalleryInitBean2.getFeedId();
            }
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleDoExecuteLike, feedId: " + msg2 + " initBean feedid: " + str2 + " curPreferStatus:" + b0());
            return;
        }
        al1.a aVar = this.inputLayout;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
            aVar = null;
        }
        aVar.lh("message_on_do_execute_like", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(Object msg2) {
        String str;
        if (!(msg2 instanceof a.ModifyBottomInteractiveDataMessage)) {
            return;
        }
        a.ModifyBottomInteractiveDataMessage modifyBottomInteractiveDataMessage = (a.ModifyBottomInteractiveDataMessage) msg2;
        String feedId = modifyBottomInteractiveDataMessage.getFeedId();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        String str2 = null;
        if (guildFeedGalleryInitBean != null) {
            str = guildFeedGalleryInitBean.getFeedId();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(feedId, str)) {
            String feedId2 = modifyBottomInteractiveDataMessage.getFeedId();
            GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.initBean;
            if (guildFeedGalleryInitBean2 != null) {
                str2 = guildFeedGalleryInitBean2.getFeedId();
            }
            QLog.e("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleModifyBottomInteractData error msg.feedId:" + feedId2 + " initBean.feedId:" + str2);
            return;
        }
        Integer commentCount = modifyBottomInteractiveDataMessage.getCommentCount();
        if (commentCount != null) {
            F0(commentCount.intValue());
        }
        Integer shareCount = modifyBottomInteractiveDataMessage.getShareCount();
        if (shareCount != null) {
            I0(shareCount.intValue());
        }
        Integer preferStatus = modifyBottomInteractiveDataMessage.getPreferStatus();
        if (preferStatus != null) {
            H0(preferStatus.intValue());
        }
        Integer preferCount = modifyBottomInteractiveDataMessage.getPreferCount();
        if (preferCount != null) {
            G0(preferCount.intValue());
        }
        z0();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean3);
        bl.c().b(new GuildDetailViewDestroyEvent(guildFeedGalleryInitBean3.getFeedId(), Z(), a0(), b0(), c0()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(Object args) {
        if ((args instanceof a.OnDoPreferMessage) && ((a.OnDoPreferMessage) args).getNewPreferStatus() == 1) {
            B0("do prefer");
        }
    }

    private final void r0(Object data) {
        String str;
        Boolean bool;
        g.a guildOperationDelegateCallback;
        short s16 = 1;
        if (!(data instanceof Pair)) {
            QLog.e("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleOnGuildMemberStateChanged|can not unmarshall args");
            return;
        }
        Pair pair = (Pair) data;
        Object first = pair.getFirst();
        String str2 = null;
        if (first instanceof String) {
            str = (String) first;
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        Object second = pair.getSecond();
        if (second instanceof Boolean) {
            bool = (Boolean) second;
        } else {
            bool = null;
        }
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
            if (guildFeedGalleryInitBean != null) {
                str2 = guildFeedGalleryInitBean.getGuildId();
            }
            if (Intrinsics.areEqual(str2, str)) {
                BottomGuideBarDelegateDefaultImpl bottomGuideBarDelegateDefaultImpl = this.guideBarDependencyRef;
                if (bottomGuideBarDelegateDefaultImpl != null && (guildOperationDelegateCallback = bottomGuideBarDelegateDefaultImpl.getGuildOperationDelegateCallback()) != null) {
                    if (!booleanValue) {
                        s16 = 2;
                    }
                    guildOperationDelegateCallback.f(s16);
                }
                K0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(Object msg2) {
        boolean z16;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        if (guildFeedGalleryInitBean == null) {
            return;
        }
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        GProStFeed feed = guildFeedGalleryInitBean.getFeed();
        if (feed == null) {
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleShareClicked: stFeed is null!");
            return;
        }
        String str = feed.channelInfo.name;
        Intrinsics.checkNotNullExpressionValue(str, "stFeed.channelInfo.name");
        final int i3 = 0;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QQToast.makeText(this.f219734i.getContext(), 0, R.string.f144710pi, 0).show();
            return;
        }
        r rVar = (r) e(r.class);
        if (rVar != null) {
            i3 = rVar.a();
        }
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "handleShareFeedMessage mediaPos=" + i3);
        f(zp1.a.class).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.c
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                GuildFeedGalleryBottomPresenter.t0(GuildFeedGalleryBottomPresenter.this, i3, (zp1.a) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(GuildFeedGalleryBottomPresenter this$0, int i3, zp1.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (aVar == null) {
            aVar = null;
        }
        if (aVar != null) {
            int i16 = this$0.f219731e;
            jk1.a mData = this$0.f219730d;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            aVar.f(i16, mData, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.g
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    Map u06;
                    u06 = GuildFeedGalleryBottomPresenter.u0();
                    return u06;
                }
            }, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map u0() {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(SpeakPermissionType type) {
        GuildFeedPublishInfo guildFeedPublishInfo;
        boolean z16 = true;
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "OnSpeakPermissionChanged " + type);
        al1.a aVar = this.inputLayout;
        ViewGroup viewGroup = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
            aVar = null;
        }
        ViewGroup viewGroup2 = this.inputRootView;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputRootView");
        } else {
            viewGroup = viewGroup2;
        }
        aVar.D5(viewGroup, type);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        if (guildFeedGalleryInitBean != null && (guildFeedPublishInfo = guildFeedGalleryInitBean.getGuildFeedPublishInfo()) != null) {
            z16 = com.tencent.mobileqq.guild.feed.feedsquare.data.g.d(guildFeedPublishInfo);
        }
        aVar.u1(z16);
    }

    private final void w0(View requestView) {
        this.requestView = requestView;
        View findViewById = requestView.findViewById(R.id.v2d);
        Intrinsics.checkNotNullExpressionValue(findViewById, "requestView.findViewById\u2026feed_gallery_bottom_root)");
        this.inputRootView = (ViewGroup) findViewById;
        this.inputLayout = new bl1.c(Y());
        v0(SpeakPermissionType.PERMISSION_TYPE_SIMPLE_INIT);
    }

    private final boolean x0() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        if (guildFeedGalleryInitBean == null || !guildFeedGalleryInitBean.isFromTroop()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y0() {
        Object obj;
        boolean z16;
        HashMap<String, Serializable> attrs;
        HashMap<String, Serializable> attrs2;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Boolean bool = null;
        if (guildFeedGalleryInitBean != null && (attrs2 = guildFeedGalleryInitBean.getAttrs()) != null) {
            obj = (Serializable) attrs2.get("force_reopen_comment_panel");
        } else {
            obj = null;
        }
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        }
        if (bool != null) {
            z16 = bool.booleanValue();
        } else {
            z16 = false;
        }
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.initBean;
        if (guildFeedGalleryInitBean2 != null && (attrs = guildFeedGalleryInitBean2.getAttrs()) != null) {
            attrs.remove("force_reopen_comment_panel");
        }
        return z16;
    }

    private final void z0() {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "notifyBottomInteractiveDataChanged");
        al1.a aVar = this.inputLayout;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
            aVar = null;
        }
        aVar.E7(new c());
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void g(@Nullable String action, @Nullable Object data) {
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1065123780) {
                if (hashCode != 226038317) {
                    if (hashCode == 963477725 && action.equals("message_on_comment_data_change")) {
                        j0(data);
                        return;
                    }
                    return;
                }
                if (action.equals("message_on_do_execute_like")) {
                    o0(data);
                    return;
                }
                return;
            }
            if (action.equals("message_action_on_guild_member_state_changed")) {
                r0(data);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(GuildDetailViewDestroyEvent.class);
        eventClass.add(GuildFeedShareChannelEvent.class);
        eventClass.add(GuildFeedGalleryPagerEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void j() {
        super.j();
        PresenterLifecycleOwner value = this.simpleLifecycleOwner.getValue();
        if (value != null) {
            value.b(Lifecycle.Event.ON_START);
        }
        A0();
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void k(@Nullable jk1.a data, int position) {
        super.k(data, position);
        if (data == null) {
            QLog.e("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "data null");
        } else {
            this.initBean = data.getInitBean();
            V();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void l(@Nullable jk1.a data, int position, @Nullable List<Object> payloads) {
        super.l(data, position, payloads);
        if (data == null) {
            return;
        }
        this.initBean = data.getInitBean();
        V();
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void m() {
        super.m();
        PresenterLifecycleOwner value = this.simpleLifecycleOwner.getValue();
        if (value != null) {
            value.b(Lifecycle.Event.ON_STOP);
        }
        Job job = this.feedPublishJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.feedPublishJob = null;
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(@NotNull View requestView) {
        Intrinsics.checkNotNullParameter(requestView, "requestView");
        super.onPreloadResult(requestView);
        w0(requestView);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean;
        HashMap<String, Serializable> attrs;
        String str = null;
        if (event instanceof GuildDetailViewDestroyEvent) {
            GuildDetailViewDestroyEvent guildDetailViewDestroyEvent = (GuildDetailViewDestroyEvent) event;
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "onReceiveEvent[GuildDetailViewDestroyEvent], feedId: " + guildDetailViewDestroyEvent.getFeedId() + ", mPreferStatus: " + guildDetailViewDestroyEvent.getPreferStatus() + ", mCurrentPreferCount: " + guildDetailViewDestroyEvent.getPreferCount() + ", mCurrentShareCount: " + guildDetailViewDestroyEvent.getShareCount() + ", mCurrentCommentCount: " + guildDetailViewDestroyEvent.getCommentCount());
            String feedId = guildDetailViewDestroyEvent.getFeedId();
            GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.initBean;
            if (guildFeedGalleryInitBean2 != null) {
                str = guildFeedGalleryInitBean2.getFeedId();
            }
            if (Intrinsics.areEqual(feedId, str)) {
                if (Z() != guildDetailViewDestroyEvent.getCommentCount() && (guildFeedGalleryInitBean = this.initBean) != null && (attrs = guildFeedGalleryInitBean.getAttrs()) != null) {
                    attrs.put("force_reopen_comment_panel", Boolean.TRUE);
                }
                H0(guildDetailViewDestroyEvent.getPreferStatus());
                G0(guildDetailViewDestroyEvent.getPreferCount());
                I0(guildDetailViewDestroyEvent.getShareCount());
                F0(guildDetailViewDestroyEvent.getCommentCount());
                z0();
                return;
            }
            return;
        }
        if (event instanceof GuildFeedShareChannelEvent) {
            GuildFeedShareChannelEvent guildFeedShareChannelEvent = (GuildFeedShareChannelEvent) event;
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "onReceiveEvent[GuildFeedShareChannelEvent], feedId: " + guildFeedShareChannelEvent.feedId);
            String str2 = guildFeedShareChannelEvent.feedId;
            GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.initBean;
            if (guildFeedGalleryInitBean3 != null) {
                str = guildFeedGalleryInitBean3.getFeedId();
            }
            if (Intrinsics.areEqual(str2, str)) {
                I0(c0() + guildFeedShareChannelEvent.getShareCount());
                z0();
                return;
            }
            return;
        }
        if (event instanceof GuildFeedGalleryPagerEvent) {
            GuildFeedGalleryPagerEvent guildFeedGalleryPagerEvent = (GuildFeedGalleryPagerEvent) event;
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryBottomPresenterNew", 1, "onReceiveEvent[GuildFeedGalleryPagerEvent], curPos: " + guildFeedGalleryPagerEvent.getCurPos() + ", totalSize: " + guildFeedGalleryPagerEvent.getTotalSize() + ", feedId: " + guildFeedGalleryPagerEvent.getFeedId());
            GuildFeedGalleryInitBean guildFeedGalleryInitBean4 = this.initBean;
            Intrinsics.checkNotNull(guildFeedGalleryInitBean4);
            List<GuildFeedRichMediaData> richMediaDataList = guildFeedGalleryInitBean4.getRichMediaDataList();
            Intrinsics.checkNotNullExpressionValue(richMediaDataList, "initBean!!.richMediaDataList");
            J0(richMediaDataList, guildFeedGalleryPagerEvent.getCurPos());
            z0();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void p(@Nullable com.tencent.mobileqq.guild.feed.manager.f selectInfo) {
        super.p(selectInfo);
        D0();
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void r(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.r(rootView);
        RFWLayoutPreLoader e16 = gj1.a.a().e();
        View findViewById = rootView.findViewById(R.id.w9g);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
        e16.requestPreloadViewForViewStub((ViewStub) findViewById, this);
    }
}
