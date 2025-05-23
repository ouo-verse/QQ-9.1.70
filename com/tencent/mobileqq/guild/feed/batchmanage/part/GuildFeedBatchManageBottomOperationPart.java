package com.tencent.mobileqq.guild.feed.batchmanage.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.data.IGuildParcelizeSimpleContact;
import com.tencent.mobileqq.guild.event.partevent.GuildPartSelectEvent;
import com.tencent.mobileqq.guild.feed.fragment.GuildPartTransFragment;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.as;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;
import xi1.BatchManageOperate;

@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 w2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0002xyB\u000f\u0012\u0006\u0010C\u001a\u00020@\u00a2\u0006\u0004\bu\u0010vJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J4\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J \u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020&H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020\u0005H\u0002J\u001c\u0010/\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u001bH\u0016J\u001c\u00105\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u00192\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u0012\u00108\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u000106H\u0016J$\u0010<\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030:09j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030:`;H\u0016J\u0012\u0010=\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010?\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u001bH\u0016R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010FR\u0016\u0010N\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010IR\u0016\u0010P\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010FR\u0016\u0010R\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010FR\u0016\u0010U\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R#\u0010\r\u001a\n _*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u001b\u0010g\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010a\u001a\u0004\be\u0010fR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u0010a\u001a\u0004\bj\u0010kR\u0014\u0010p\u001a\u00020m8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bn\u0010oR\u0014\u0010s\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bq\u0010rR\u0014\u0010\b\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bt\u0010r\u00a8\u0006z"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageBottomOperationPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/event/partevent/GuildPartSelectEvent;", "Landroid/view/View$OnClickListener;", "", "initListener", "", "channelId", "xa", "sa", "ta", "Lvi1/f;", "batchSelectManager", "Ljava/lang/Runnable;", "S9", "", "isEnable", "za", "", "backEndExpectCount", "localCount", "unSelectCount", "isEndPage", "Lkotlin/Pair;", "", "V9", "Landroid/view/View;", "view", "da", "deletePoster", "U9", "R9", "isCancel", "qa", "wa", "ma", "ra", "", "ba", "la", "ca", "pa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onPartDestroy", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageBottomOperationPart$a;", "d", "Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageBottomOperationPart$a;", "dependency", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "counterTv", "f", "Landroid/view/View;", "moveButton", tl.h.F, "moveTv", "i", "deleteButton", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "deleteTv", BdhLogUtil.LogTag.Tag_Conn, "selectAll", "D", "Z", "isDestroyed", "E", "I", "backEndExpectFeedCount", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "feedCountDescription", "G", "Ljava/lang/Runnable;", "updateCounterTask", "kotlin.jvm.PlatformType", "H", "Lkotlin/Lazy;", "Y9", "()Lvi1/f;", "Lyi1/c;", "W9", "()Lyi1/c;", "batchDeleteOperator", "Lyi1/f;", "J", "X9", "()Lyi1/f;", "batchMoveOperator", "Lcom/tencent/mobileqq/guild/data/s;", "Z9", "()Lcom/tencent/mobileqq/guild/data/s;", "contact", "aa", "()Ljava/lang/String;", "keyWord", "getChannelId", "<init>", "(Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageBottomOperationPart$a;)V", "K", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedBatchManageBottomOperationPart extends Part implements SimpleEventReceiver<GuildPartSelectEvent>, View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView selectAll;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isDestroyed;

    /* renamed from: E, reason: from kotlin metadata */
    private int backEndExpectFeedCount;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String feedCountDescription;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Runnable updateCounterTask;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy batchSelectManager;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy batchDeleteOperator;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy batchMoveOperator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a dependency;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView counterTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View moveButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView moveTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View deleteButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView deleteTv;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H&R?\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0019\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00150\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageBottomOperationPart$a;", "", "", "channelId", "", "a", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "operationType", "", "d", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "total", "Lkotlin/jvm/functions/Function1;", "c", "()Lkotlin/jvm/functions/Function1;", "e", "(Lkotlin/jvm/functions/Function1;)V", "onUpdateBackendEstimateFeedTotalCount", "Landroidx/lifecycle/LiveData;", "Ldo1/a;", "", "b", "()Landroidx/lifecycle/LiveData;", "feedCollectionViewState", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function1<? super Integer, Unit> onUpdateBackendEstimateFeedTotalCount;

        @Nullable
        public abstract Object a(long j3, @NotNull Continuation<? super Integer> continuation);

        @NotNull
        public abstract LiveData<do1.a<? extends Collection<?>, Integer>> b();

        @Nullable
        public final Function1<Integer, Unit> c() {
            return this.onUpdateBackendEstimateFeedTotalCount;
        }

        public abstract void d(int operationType);

        public final void e(@Nullable Function1<? super Integer, Unit> function1) {
            this.onUpdateBackendEstimateFeedTotalCount = function1;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageBottomOperationPart$c", "Lyi1/g;", "", "isSuccess", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements yi1.g {
        c() {
        }

        @Override // yi1.g
        public void a(boolean isSuccess) {
            GuildFeedBatchManageBottomOperationPart.this.R9();
            GuildFeedBatchManageBottomOperationPart.this.dependency.d(2);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageBottomOperationPart$d", "Lyi1/g;", "", "isSuccess", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements yi1.g {
        d() {
        }

        @Override // yi1.g
        public void a(boolean isSuccess) {
            GuildFeedBatchManageBottomOperationPart.this.R9();
            GuildFeedBatchManageBottomOperationPart.this.dependency.d(1);
        }
    }

    public GuildFeedBatchManageBottomOperationPart(@NotNull a dependency) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        this.dependency = dependency;
        this.backEndExpectFeedCount = -1;
        this.feedCountDescription = "";
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<vi1.f>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart$batchSelectManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final vi1.f invoke() {
                return (vi1.f) RFWIocAbilityProvider.g().getIocInterface(vi1.f.class, GuildFeedBatchManageBottomOperationPart.this.getPartRootView(), null);
            }
        });
        this.batchSelectManager = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<yi1.c>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart$batchDeleteOperator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final yi1.c invoke() {
                com.tencent.mobileqq.guild.data.s Z9;
                String aa5;
                Z9 = GuildFeedBatchManageBottomOperationPart.this.Z9();
                String guildId = Z9.getGuildId();
                aa5 = GuildFeedBatchManageBottomOperationPart.this.aa();
                return new yi1.c(guildId, aa5);
            }
        });
        this.batchDeleteOperator = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<yi1.f>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart$batchMoveOperator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final yi1.f invoke() {
                com.tencent.mobileqq.guild.data.s Z9;
                String aa5;
                Z9 = GuildFeedBatchManageBottomOperationPart.this.Z9();
                String guildId = Z9.getGuildId();
                aa5 = GuildFeedBatchManageBottomOperationPart.this.aa();
                return new yi1.f(guildId, aa5);
            }
        });
        this.batchMoveOperator = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        QLog.d("GuildFeedBatchManageBottomOperationPart", 1, " clearSelected ");
        vi1.f Y9 = Y9();
        if (Y9 != null) {
            Y9.f();
        }
        TextView textView = this.selectAll;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectAll");
            textView = null;
        }
        textView.setText("\u5168\u9009");
    }

    private final Runnable S9(final vi1.f batchSelectManager) {
        return new Runnable() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.k
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedBatchManageBottomOperationPart.T9(vi1.f.this, this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(vi1.f batchSelectManager, GuildFeedBatchManageBottomOperationPart this$0) {
        int i3;
        int i16;
        boolean z16;
        Boolean bool;
        boolean z17;
        Collection<?> a16;
        Collection<?> a17;
        Intrinsics.checkNotNullParameter(batchSelectManager, "$batchSelectManager");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BatchManageOperate value = batchSelectManager.i().getValue();
        if (value == null) {
            return;
        }
        do1.a<? extends Collection<?>, Integer> value2 = this$0.dependency.b().getValue();
        if (value2 != null && (a17 = value2.a()) != null) {
            i3 = a17.size();
        } else {
            i3 = 0;
        }
        do1.a<? extends Collection<?>, Integer> value3 = this$0.dependency.b().getValue();
        if (value3 != null && (a16 = value3.a()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : a16) {
                if (obj instanceof ij1.g) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (com.tencent.mobileqq.guild.feed.batchmanage.b.INSTANCE.a((ij1.g) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            i16 = arrayList2.size();
        } else {
            i16 = 0;
        }
        if (i16 != 0) {
            i3 = i16;
        }
        TextView textView = null;
        if (value.getSelectMode() == 1) {
            int i17 = this$0.backEndExpectFeedCount;
            do1.a<? extends Collection<?>, Integer> value4 = this$0.dependency.b().getValue();
            if (value4 != null) {
                z16 = value4.getIsFinished();
            } else {
                z16 = false;
            }
            Pair<Integer, String> V9 = this$0.V9(i17, i3, value.e().size(), z16);
            int intValue = V9.component1().intValue();
            String component2 = V9.component2();
            int i18 = this$0.backEndExpectFeedCount;
            do1.a<? extends Collection<?>, Integer> value5 = this$0.dependency.b().getValue();
            if (value5 != null) {
                bool = Boolean.valueOf(value5.getIsFinished());
            } else {
                bool = null;
            }
            QLog.d("GuildFeedBatchManageBottomOperationPart", 1, " backEndExpectFeedCount" + i18 + ", size " + i16 + ",  localTotalFeedCount" + i3 + ", endPage" + bool);
            if (intValue > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this$0.za(z17);
            this$0.feedCountDescription = component2;
            value.g(component2);
            value.f(Integer.valueOf(intValue));
            TextView textView2 = this$0.counterTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("counterTv");
            } else {
                textView = textView2;
            }
            textView.setText(this$0.getContext().getString(R.string.f143730mv, this$0.feedCountDescription));
            return;
        }
        this$0.za(!value.d().isEmpty());
        String valueOf = String.valueOf(value.d().size());
        this$0.feedCountDescription = valueOf;
        value.g(valueOf);
        value.f(Integer.valueOf(value.d().size()));
        TextView textView3 = this$0.counterTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("counterTv");
        } else {
            textView = textView3;
        }
        textView.setText(this$0.getContext().getString(R.string.f143730mv, this$0.feedCountDescription));
    }

    private final void U9(boolean deletePoster, View view) {
        vi1.f fVar;
        LiveData<BatchManageOperate> i3;
        BatchManageOperate value;
        qa(deletePoster, view, false);
        if (!yl1.n.d(true, 0, 2, null) && (fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class)) != null && (i3 = fVar.i()) != null && (value = i3.getValue()) != null) {
            W9().d(deletePoster, value, getChannelId());
        }
    }

    private final Pair<Integer, String> V9(int backEndExpectCount, int localCount, int unSelectCount, boolean isEndPage) {
        int coerceAtLeast;
        if (!isEndPage) {
            localCount = Math.max(localCount, backEndExpectCount);
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(localCount - unSelectCount, 0);
        if (!isEndPage && coerceAtLeast >= 10) {
            return TuplesKt.to(Integer.valueOf(coerceAtLeast), (coerceAtLeast - (coerceAtLeast % 10)) + Marker.ANY_NON_NULL_MARKER);
        }
        return TuplesKt.to(Integer.valueOf(coerceAtLeast), String.valueOf(coerceAtLeast));
    }

    private final yi1.c W9() {
        return (yi1.c) this.batchDeleteOperator.getValue();
    }

    private final yi1.f X9() {
        return (yi1.f) this.batchMoveOperator.getValue();
    }

    private final vi1.f Y9() {
        return (vi1.f) this.batchSelectManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.data.s Z9() {
        IGuildParcelizeSimpleContact contact;
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        if (bVar == null || (contact = bVar.getContact()) == null) {
            return GuildSimpleContact.INSTANCE.a();
        }
        return contact;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String aa() {
        String b16;
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        if (bVar == null || (b16 = vi1.c.b(bVar)) == null) {
            return "";
        }
        return b16;
    }

    private final short ba() {
        LiveData<BatchManageOperate> i3;
        BatchManageOperate value;
        vi1.f Y9 = Y9();
        boolean z16 = false;
        if (Y9 != null && (i3 = Y9.i()) != null && (value = i3.getValue()) != null && 1 == value.getSelectMode()) {
            z16 = true;
        }
        if (!z16) {
            return (short) 1;
        }
        return (short) 2;
    }

    private final short ca() {
        LiveData<BatchManageOperate> i3;
        BatchManageOperate value;
        vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        boolean z16 = false;
        if (fVar != null && (i3 = fVar.i()) != null && (value = i3.getValue()) != null && 1 == value.getSelectMode()) {
            z16 = true;
        }
        if (z16) {
            return (short) 1;
        }
        return (short) 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da(View view) {
        QQCustomDialog createCustomDialog;
        Map mapOf;
        if (as.h(Z9().getGuildId(), 100001)) {
            createCustomDialog = DialogUtil.createDialogWithCheckBox(getContext(), 230, null, getContext().getResources().getString(R.string.f143930ne, this.feedCountDescription), getContext().getResources().getString(R.string.f144350oj), false, getContext().getResources().getString(R.string.f140850f3), getContext().getResources().getString(R.string.f143520ma), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildFeedBatchManageBottomOperationPart.ga(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildFeedBatchManageBottomOperationPart.ha(GuildFeedBatchManageBottomOperationPart.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildFeedBatchManageBottomOperationPart.ia(GuildFeedBatchManageBottomOperationPart.this, dialogInterface, i3);
                }
            });
        } else {
            createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, getContext().getResources().getString(R.string.f143930ne, this.feedCountDescription), getContext().getResources().getString(R.string.f140850f3), getContext().getResources().getString(R.string.f143520ma), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildFeedBatchManageBottomOperationPart.ja(GuildFeedBatchManageBottomOperationPart.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildFeedBatchManageBottomOperationPart.ea(GuildFeedBatchManageBottomOperationPart.this, dialogInterface, i3);
                }
            });
        }
        ViewGroup rootView = createCustomDialog.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "dialog.rootView");
        wa(rootView);
        createCustomDialog.show();
        VideoReport.setElementId(view, "em_sgrp_delete");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_option_type", Short.valueOf(ca())));
        VideoReport.reportEvent("clck", view, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(GuildFeedBatchManageBottomOperationPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
        QQCustomDialog qQCustomDialog = (QQCustomDialog) dialogInterface;
        TextView btnLeft = qQCustomDialog.getBtnLeft();
        Intrinsics.checkNotNullExpressionValue(btnLeft, "dialog as QQCustomDialog).btnLeft");
        this$0.qa(false, btnLeft, true);
        VideoReport.reportPgOut(qQCustomDialog.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
        VideoReport.reportPgOut(((QQCustomDialog) dialogInterface).getRootView());
    }

    private final String getChannelId() {
        Long l3;
        vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar != null) {
            l3 = Long.valueOf(fVar.getSelectedChannelId());
        } else {
            l3 = null;
        }
        return String.valueOf(l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(GuildFeedBatchManageBottomOperationPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
        QQCustomDialog qQCustomDialog = (QQCustomDialog) dialogInterface;
        boolean checkBoxState = qQCustomDialog.getCheckBoxState();
        TextView btnight = qQCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight, "dialog.btnight");
        this$0.U9(checkBoxState, btnight);
        VideoReport.reportPgOut(qQCustomDialog.getRootView());
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(GuildFeedBatchManageBottomOperationPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
        QQCustomDialog qQCustomDialog = (QQCustomDialog) dialogInterface;
        boolean checkBoxState = qQCustomDialog.getCheckBoxState();
        TextView btnLeft = qQCustomDialog.getBtnLeft();
        Intrinsics.checkNotNullExpressionValue(btnLeft, "dialog.btnLeft");
        this$0.qa(checkBoxState, btnLeft, true);
        VideoReport.reportPgOut(qQCustomDialog.getRootView());
    }

    private final void initListener() {
        W9().g(new c());
        X9().g(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(GuildFeedBatchManageBottomOperationPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
        QQCustomDialog qQCustomDialog = (QQCustomDialog) dialogInterface;
        TextView btnight = qQCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight, "dialog as QQCustomDialog).btnight");
        this$0.U9(false, btnight);
        VideoReport.reportPgOut(qQCustomDialog.getRootView());
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la(View view) {
        Map mapOf;
        pa();
        VideoReport.setElementId(view, "em_sgrp_forum_move");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_option_type", Short.valueOf(ca())));
        VideoReport.reportEvent("clck", view, mapOf);
    }

    private final void ma(View view) {
        Integer num;
        LiveData<BatchManageOperate> i3;
        BatchManageOperate value;
        ra(view);
        vi1.f Y9 = Y9();
        TextView textView = null;
        if (Y9 != null && (i3 = Y9.i()) != null && (value = i3.getValue()) != null) {
            num = Integer.valueOf(value.getSelectMode());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            TextView textView2 = this.selectAll;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAll");
            } else {
                textView = textView2;
            }
            textView.setText("\u5168\u9009");
            vi1.f Y92 = Y9();
            if (Y92 != null) {
                Y92.d(0);
                return;
            }
            return;
        }
        if (num != null && num.intValue() == 0) {
            TextView textView3 = this.selectAll;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAll");
            } else {
                textView = textView3;
            }
            textView.setText("\u53d6\u6d88\u9009\u62e9");
            vi1.f Y93 = Y9();
            if (Y93 != null) {
                Y93.d(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(GuildFeedBatchManageBottomOperationPart this$0, SimpleBaseEvent simpleBaseEvent, DialogInterface dialogInterface, int i3) {
        vi1.f fVar;
        LiveData<BatchManageOperate> i16;
        BatchManageOperate value;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!yl1.n.d(false, 0, 3, null) && (fVar = (vi1.f) PartIOCKt.getIocInterface(this$0, vi1.f.class)) != null && (i16 = fVar.i()) != null && (value = i16.getValue()) != null) {
            yi1.f X9 = this$0.X9();
            String str = ((GuildPartSelectEvent) simpleBaseEvent).channelUin;
            Intrinsics.checkNotNullExpressionValue(str, "event.channelUin");
            X9.d(str, value, this$0.getChannelId());
        }
    }

    private final void pa() {
        long j3;
        String channelId = getChannelId();
        vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar != null) {
            j3 = fVar.e();
        } else {
            j3 = 0;
        }
        if (j3 != 0) {
            channelId = String.valueOf(j3);
        }
        QLog.d("GuildFeedBatchManageBottomOperationPart", 1, "openPartSelectChannelId= " + ((Object) channelId) + " , channelId=" + getChannelId() + " ,selectedFeedChannelId=" + j3);
        Bundle bundle = new Bundle();
        bundle.putString("key_guild_id", Z9().getGuildId());
        bundle.putString("key_channel_id", channelId);
        bundle.putInt("key_channel_type", 7);
        bundle.putInt("KEY_NEED_CHECK_PERMISSION_TYPE", 30002);
        bundle.putInt("part_panel_biz_type", 1);
        bundle.putInt("key_request_id", Objects.hashCode(getContext()));
        bundle.putBoolean("key_toast_if_only_one_section_exist", true);
        Context context = getContext();
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("guild_key_part_selection", bundle);
        QPublicTransFragmentActivity.start(context, intent, GuildPartTransFragment.class);
    }

    private final void qa(boolean deletePoster, View view, boolean isCancel) {
        Map mapOf;
        VideoReport.setElementId(view, "em_sgrp_btn");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        int i3 = 2;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("sgrp_option_type", Integer.valueOf(deletePoster ? 1 : 0));
        if (!isCancel) {
            i3 = 1;
        }
        pairArr[1] = TuplesKt.to("sgrp_btn_type", Integer.valueOf(i3));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent("clck", view, mapOf);
    }

    private final void ra(View view) {
        Map mapOf;
        VideoReport.setElementId(view, "em_sgrp_select_or_cancel_all");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", Short.valueOf(ba())));
        VideoReport.reportEvent("clck", view, mapOf);
    }

    private final void sa() {
        TextView textView = this.moveTv;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moveTv");
            textView = null;
        }
        textView.setOnClickListener(this);
        View view2 = this.moveButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moveButton");
            view2 = null;
        }
        view2.setOnClickListener(this);
        TextView textView2 = this.deleteTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteTv");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        View view3 = this.deleteButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
            view3 = null;
        }
        view3.setOnClickListener(this);
        TextView textView3 = this.selectAll;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectAll");
            textView3 = null;
        }
        textView3.setOnClickListener(this);
        TextView textView4 = this.moveTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moveTv");
            textView4 = null;
        }
        yl1.n.f(textView4, 12.0f);
        View view4 = this.moveButton;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moveButton");
            view4 = null;
        }
        yl1.n.f(view4, 12.0f);
        TextView textView5 = this.deleteTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteTv");
            textView5 = null;
        }
        yl1.n.f(textView5, 12.0f);
        View view5 = this.deleteButton;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
        } else {
            view = view5;
        }
        yl1.n.f(view, 12.0f);
    }

    private final void ta() {
        vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar == null) {
            QLog.e("GuildFeedBatchManageBottomOperationPart", 1, "feedListUIState or batchSelectManager is null");
            return;
        }
        this.updateCounterTask = S9(fVar);
        LiveData<do1.a<? extends Collection<?>, Integer>> b16 = this.dependency.b();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<do1.a<? extends Collection<?>, Integer>, Unit> function1 = new Function1<do1.a<? extends Collection<?>, Integer>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart$setUpCounterUpdateTaskAndObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(do1.a<? extends Collection<?>, Integer> aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable do1.a<? extends Collection<?>, Integer> aVar) {
                Runnable runnable;
                runnable = GuildFeedBatchManageBottomOperationPart.this.updateCounterTask;
                if (runnable != null) {
                    runnable.run();
                }
            }
        };
        b16.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedBatchManageBottomOperationPart.ua(Function1.this, obj);
            }
        });
        LiveData<BatchManageOperate> i3 = fVar.i();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<BatchManageOperate, Unit> function12 = new Function1<BatchManageOperate, Unit>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart$setUpCounterUpdateTaskAndObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BatchManageOperate batchManageOperate) {
                invoke2(batchManageOperate);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BatchManageOperate batchManageOperate) {
                Runnable runnable;
                if (batchManageOperate == null) {
                    return;
                }
                QLog.d("GuildFeedBatchManageBottomOperationPart", 4, "selectMode=" + batchManageOperate.getSelectMode() + " selectionCount= " + batchManageOperate.d().size() + ", unSelectionCount=" + batchManageOperate.e().size());
                runnable = GuildFeedBatchManageBottomOperationPart.this.updateCounterTask;
                if (runnable != null) {
                    runnable.run();
                }
            }
        };
        i3.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedBatchManageBottomOperationPart.va(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void wa(View view) {
        LinkedHashMap linkedMapOf;
        VideoReport.setPageId(view, "pg_sgrp_forum_batch_confirm_pop");
        VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_NONE);
        linkedMapOf = MapsKt__MapsKt.linkedMapOf(TuplesKt.to("sgrp_user_type", com.tencent.mobileqq.guild.feed.report.f.o(Z9().getGuildId())), TuplesKt.to("sgrp_channel_id", Z9().getGuildId()), TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, aa()));
        VideoReport.setPageParams(view, new PageParams(linkedMapOf));
        VideoReport.reportPgIn(view);
    }

    private final void xa(long channelId) {
        Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart$setUpTotalFeedCountCallbackAndFetchTotalCount$onUpdateBackendTotalFeedCount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                int i16;
                Runnable runnable;
                i16 = GuildFeedBatchManageBottomOperationPart.this.backEndExpectFeedCount;
                if (i3 != i16) {
                    GuildFeedBatchManageBottomOperationPart.this.backEndExpectFeedCount = i3;
                    runnable = GuildFeedBatchManageBottomOperationPart.this.updateCounterTask;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            }
        };
        this.dependency.e(function1);
        BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.guild.feed.part.a.d(this), null, null, new GuildFeedBatchManageBottomOperationPart$setUpTotalFeedCountCallbackAndFetchTotalCount$1(this, channelId, function1, null), 3, null);
    }

    private final void za(boolean isEnable) {
        TextView textView = this.moveTv;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moveTv");
            textView = null;
        }
        textView.setEnabled(isEnable);
        TextView textView2 = this.deleteTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteTv");
            textView2 = null;
        }
        textView2.setEnabled(isEnable);
        View view2 = this.moveButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moveButton");
            view2 = null;
        }
        view2.setEnabled(isEnable);
        View view3 = this.deleteButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
        } else {
            view = view3;
        }
        view.setEnabled(isEnable);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildPartSelectEvent>> getEventClass() {
        ArrayList<Class<GuildPartSelectEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildPartSelectEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "broadcast_clear")) {
            R9();
        } else if (Intrinsics.areEqual(action, "broadcast_refresh_feed_count")) {
            xa(MiscKt.l(getChannelId()));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable final View v3) {
        Integer num;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        boolean z17 = false;
        if ((num != null && num.intValue() == R.id.f108436d4) || (num != null && num.intValue() == R.id.f165932y42)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            yl1.n.i("GuildFeedBatchManageBottomOperationPart", 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart$onClick$1
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
                    GuildFeedBatchManageBottomOperationPart.this.la(v3);
                }
            }, 2, null);
        } else if (num != null && num.intValue() == R.id.f111056k7) {
            ma(v3);
        } else {
            if ((num != null && num.intValue() == R.id.f108426d3) || (num != null && num.intValue() == R.id.f165931y41)) {
                z17 = true;
            }
            if (z17) {
                yl1.n.i("GuildFeedBatchManageBottomOperationPart", 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart$onClick$2
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
                        GuildFeedBatchManageBottomOperationPart.this.da(v3);
                    }
                }, 2, null);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.isDestroyed = false;
        View findViewById = rootView.findViewById(R.id.f111056k7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_select_all)");
        this.selectAll = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f111076k9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_select_count)");
        this.counterTv = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f108436d4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_guild_feed_move)");
        this.moveTv = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f165932y42);
        ImageView imageView = (ImageView) findViewById4;
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        Drawable drawable = imageView.getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        imageView.setImageDrawable(guildUIUtils.F(drawable, ContextCompat.getColor(imageView.getContext(), R.color.qui_common_icon_primary)));
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById<Im\u2026)\n            )\n        }");
        this.moveButton = findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f108426d3);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.tv_guild_feed_delete)");
        this.deleteTv = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f165931y41);
        ImageView imageView2 = (ImageView) findViewById6;
        Drawable drawable2 = imageView2.getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable2, "drawable");
        imageView2.setImageDrawable(guildUIUtils.F(drawable2, ContextCompat.getColor(imageView2.getContext(), R.color.qui_common_feedback_error)));
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById<Im\u2026)\n            )\n        }");
        this.deleteButton = findViewById6;
        TextView textView = this.counterTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("counterTv");
            textView = null;
        }
        textView.setText(getContext().getString(R.string.f143730mv, "0"));
        ta();
        sa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        SimpleEventBus.getInstance().registerReceiver(this);
        xa(MiscKt.l(Z9().getChannelId()));
        initListener();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.isDestroyed = true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable final SimpleBaseEvent event) {
        String string;
        if (event instanceof GuildPartSelectEvent) {
            GuildPartSelectEvent guildPartSelectEvent = (GuildPartSelectEvent) event;
            if (guildPartSelectEvent.mHashCode == getContext().hashCode()) {
                if (guildPartSelectEvent.isSquare) {
                    string = getContext().getString(R.string.f143880n_);
                } else {
                    string = getContext().getString(R.string.f143900nb, guildPartSelectEvent.channelName);
                }
                String str = string;
                Intrinsics.checkNotNullExpressionValue(str, "if (event.isSquare) {\n  \u2026e\n            )\n        }");
                DialogUtil.createCustomDialog(getContext(), 230, (String) null, str, getContext().getString(R.string.cancel), getContext().getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        GuildFeedBatchManageBottomOperationPart.na(GuildFeedBatchManageBottomOperationPart.this, event, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        GuildFeedBatchManageBottomOperationPart.oa(dialogInterface, i3);
                    }
                }).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(DialogInterface dialogInterface, int i3) {
    }
}
