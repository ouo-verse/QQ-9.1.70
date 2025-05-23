package com.tencent.mobileqq.flock.feedlist.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.flock.event.FlockDeleteFeedEvent;
import com.tencent.mobileqq.flock.feedlist.viewmodel.ToastState;
import com.tencent.mobileqq.flock.publish.event.FlockPublishFinishEvent;
import com.tencent.mobileqq.flock.widget.FlockBlankView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.addcontact.api.IAddContactSessionRepo;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 z2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0001{B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\bx\u0010yJ\b\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\r\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u001c\u0010\u000f\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001c\u0010\u0018\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\tH\u0002J\u001c\u0010\u0019\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\tH\u0002J\u001c\u0010\u001b\u001a\u00020\u00072\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\tH\u0002J\u001c\u0010\u001c\u001a\u00020\u00072\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\tH\u0002J\u001c\u0010\u001d\u001a\u00020\u00072\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\tH\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\u001c\u0010\u001f\u001a\u00020\u00072\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\tH\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\t\u0010*\u001a\u00020)H\u0096\u0001J\u001d\u0010/\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.0-2\u0006\u0010,\u001a\u00020+H\u0096\u0001J\u0013\u00102\u001a\u0004\u0018\u00010)2\u0006\u00101\u001a\u000200H\u0096\u0001J\u0019\u00103\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0006\u00101\u001a\u000200H\u0096\u0001J\u0019\u00104\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0006\u00101\u001a\u000200H\u0096\u0001J\u0019\u00105\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0006\u00101\u001a\u000200H\u0096\u0001J\u0019\u00107\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0006\u00106\u001a\u00020.H\u0096\u0001J\u001c\u0010<\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u0001082\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010=\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010@\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\b\u0010A\u001a\u00020\u0007H\u0016J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020BH\u0016J\u0010\u0010E\u001a\u00020\u00072\u0006\u00101\u001a\u000200H\u0016J\u0012\u0010F\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060H0GH\u0016J\u001c\u0010M\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010)2\b\u0010L\u001a\u0004\u0018\u00010KH\u0016R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010dR#\u0010l\u001a\n g*\u0004\u0018\u00010f0f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0014\u0010o\u001a\u00020B8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010q\u001a\u00020B8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bp\u0010nR\u0014\u0010s\u001a\u00020B8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\br\u0010nR\u0014\u0010u\u001a\u00020B8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bt\u0010nR\u0014\u0010w\u001a\u00020B8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bv\u0010n\u00a8\u0006|"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/part/FlockFeedListBodyPart;", "Lcom/tencent/mobileqq/flock/base/b;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", "Lmc1/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lb55/g;", "it", "R9", "S9", "T9", "I9", "J9", "G9", "H9", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "type", "F9", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "Q9", "K9", "uiStateData", "W9", "O9", "P9", "E9", "Z9", "Y9", "Lcom/tencent/mobileqq/flock/publish/event/FlockPublishFinishEvent;", "event", "V9", "Lcom/tencent/mobileqq/flock/event/FlockDeleteFeedEvent;", "N9", "U9", "da", "ea", "", "y8", "Landroid/content/Context;", "context", "Lkotlin/Pair;", "", "Z5", "Ly45/b;", "feed", "C8", "Z8", ICustomDataEditor.NUMBER_PARAM_2, "S4", "tagId", "j3", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "t4", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "action", "", "args", "handleBroadcastMessage", "d", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "M9", "()Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "rvFeedList", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/mobileqq/flock/feedlist/adapter/a;", "i", "Lcom/tencent/mobileqq/flock/feedlist/adapter/a;", "feedListAdapter", "Lcom/tencent/mobileqq/flock/widget/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/flock/widget/d;", "flockListLoadMoreAdapter", "Lcom/tencent/mobileqq/flock/widget/FlockBlankView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/flock/widget/FlockBlankView;", "flockBlankView", "Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "kotlin.jvm.PlatformType", "D", "Lkotlin/Lazy;", "L9", "()Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "feedListVm", ICustomDataEditor.STRING_ARRAY_PARAM_8, "()Z", "isParticipantClickable", "c6", "isPoiClickable", "t3", "isPublisherClickable", "T1", "isTopicClickable", ICustomDataEditor.STRING_PARAM_1, "isTopicVisible", "<init>", "(Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;)V", "E", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedListBodyPart extends com.tencent.mobileqq.flock.base.b implements ILoadMoreProvider$LoadMoreListener, com.tencent.mobileqq.flock.feedcommon.ioc.b, mc1.a, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private FlockBlankView flockBlankView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedListVm;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FlockConstants$FlockListScene type;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.flock.feedcommon.ioc.b f210148e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView rvFeedList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.flock.feedlist.adapter.a feedListAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.flock.widget.d flockListLoadMoreAdapter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/part/FlockFeedListBodyPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feedlist.part.FlockFeedListBodyPart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f210153a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37165);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FlockConstants$FlockListScene.values().length];
            try {
                iArr[FlockConstants$FlockListScene.TROOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlockConstants$FlockListScene.PUBLISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlockConstants$FlockListScene.JOIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FlockConstants$FlockListScene.RECOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FlockConstants$FlockListScene.ACTIVITY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FlockConstants$FlockListScene.TOPIC_AGGREGATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f210153a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37187);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockFeedListBodyPart(@NotNull FlockConstants$FlockListScene type) {
        com.tencent.mobileqq.flock.feedcommon.ioc.b aVar;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) type);
            return;
        }
        this.type = type;
        if (type == FlockConstants$FlockListScene.TOPIC_AGGREGATION) {
            aVar = new com.tencent.mobileqq.topicaggregation.ioc.a();
        } else {
            aVar = new com.tencent.mobileqq.flock.feedcommon.ioc.a();
        }
        this.f210148e = aVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feedlist.viewmodel.a>() { // from class: com.tencent.mobileqq.flock.feedlist.part.FlockFeedListBodyPart$feedListVm$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedListBodyPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.flock.feedlist.viewmodel.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.flock.feedlist.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                FlockFeedListBodyPart flockFeedListBodyPart = FlockFeedListBodyPart.this;
                return (com.tencent.mobileqq.flock.feedlist.viewmodel.a) flockFeedListBodyPart.getViewModel(com.tencent.mobileqq.flock.feedlist.viewmodel.a.INSTANCE.a(flockFeedListBodyPart.M9()));
            }
        });
        this.feedListVm = lazy;
    }

    private final void E9() {
        com.tencent.mobileqq.flock.feedlist.adapter.a aVar = new com.tencent.mobileqq.flock.feedlist.adapter.a(this.type);
        aVar.setHasStableIds(true);
        this.feedListAdapter = aVar;
        com.tencent.mobileqq.flock.widget.d dVar = new com.tencent.mobileqq.flock.widget.d();
        dVar.setHasStableIds(true);
        dVar.registerLoadMoreListener(this);
        this.flockListLoadMoreAdapter = dVar;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        com.tencent.mobileqq.flock.feedlist.adapter.a aVar2 = this.feedListAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedListAdapter");
            aVar2 = null;
        }
        adapterArr[0] = aVar2;
        adapterArr[1] = this.flockListLoadMoreAdapter;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.rvFeedList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvFeedList");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    private final void F9(FlockConstants$FlockListScene type) {
        Integer num;
        Serializable serializable;
        ArrayList arrayList;
        Serializable serializable2;
        HashMap<String, String> hashMap;
        int collectionSizeOrDefault;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        com.tencent.mobileqq.flock.feedlist.viewmodel.a L9 = L9();
        Intrinsics.checkNotNull(L9, "null cannot be cast to non-null type com.tencent.mobileqq.flock.feedlist.viewmodel.FlockGetHomePageFeedListViewModel");
        com.tencent.mobileqq.flock.feedlist.viewmodel.e eVar = (com.tencent.mobileqq.flock.feedlist.viewmodel.e) L9;
        if (type == FlockConstants$FlockListScene.PUBLISH) {
            eVar.i2(1);
        } else {
            eVar.i2(2);
        }
        Activity activity = getActivity();
        Boolean bool = null;
        if (activity != null && (intent4 = activity.getIntent()) != null) {
            num = Integer.valueOf(intent4.getIntExtra("key_flock_homepage_recom", 1));
        } else {
            num = null;
        }
        int d26 = eVar.d2();
        if (num != null && num.intValue() == d26) {
            Activity activity2 = getActivity();
            if (activity2 != null && (intent3 = activity2.getIntent()) != null) {
                serializable = intent3.getSerializableExtra("key_flock_feeds");
            } else {
                serializable = null;
            }
            if (serializable instanceof ArrayList) {
                arrayList = (ArrayList) serializable;
            } else {
                arrayList = null;
            }
            Activity activity3 = getActivity();
            if (activity3 != null && (intent2 = activity3.getIntent()) != null) {
                serializable2 = intent2.getSerializableExtra("key_flock_homepage_session");
            } else {
                serializable2 = null;
            }
            if (serializable2 instanceof HashMap) {
                hashMap = (HashMap) serializable2;
            } else {
                hashMap = null;
            }
            Activity activity4 = getActivity();
            if (activity4 != null && (intent = activity4.getIntent()) != null) {
                bool = Boolean.valueOf(intent.getBooleanExtra("key_flock_homepage_fetch_finish", false));
            }
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            eVar.h2(bool.booleanValue());
            if (arrayList != null) {
                try {
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList<com.tencent.mobileqq.flock.feeddetail.bean.a> arrayList2 = new ArrayList<>(collectionSizeOrDefault);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        y45.b d16 = y45.b.d((byte[]) it.next());
                        Intrinsics.checkNotNullExpressionValue(d16, "parseFrom(it)");
                        arrayList2.add(new com.tencent.mobileqq.flock.feeddetail.bean.a(d16));
                    }
                    eVar.L1(arrayList2, hashMap, bool.booleanValue());
                    return;
                } catch (Exception e16) {
                    QLog.e("FlockFeedListBodyPart", 1, e16, new Object[0]);
                }
            }
        }
        da();
    }

    private final void G9() {
        Serializable serializable;
        int collectionSizeOrDefault;
        Intent intent;
        com.tencent.mobileqq.flock.feedlist.viewmodel.a L9 = L9();
        Intrinsics.checkNotNull(L9, "null cannot be cast to non-null type com.tencent.mobileqq.flock.feedlist.viewmodel.FlockGetRecomFeedListViewModel");
        com.tencent.mobileqq.flock.feedlist.viewmodel.g gVar = (com.tencent.mobileqq.flock.feedlist.viewmodel.g) L9;
        Activity activity = getActivity();
        ArrayList arrayList = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_flock_feeds");
        } else {
            serializable = null;
        }
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        }
        if (arrayList != null) {
            try {
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList<com.tencent.mobileqq.flock.feeddetail.bean.a> arrayList2 = new ArrayList<>(collectionSizeOrDefault);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    y45.b d16 = y45.b.d((byte[]) it.next());
                    Intrinsics.checkNotNullExpressionValue(d16, "parseFrom(it)");
                    arrayList2.add(new com.tencent.mobileqq.flock.feeddetail.bean.a(d16));
                }
                gVar.M1(arrayList2, ((IAddContactSessionRepo) QRoute.api(IAddContactSessionRepo.class)).getSession(AddContactDataType.FLOCK));
                com.tencent.mobileqq.flock.feedlist.viewmodel.a L92 = L9();
                if (L92 != null) {
                    L92.W1(true);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("FlockFeedListBodyPart", 1, e16, new Object[0]);
            }
        }
        da();
    }

    private final void H9() {
        com.tencent.mobileqq.flock.feedlist.viewmodel.a L9 = L9();
        Intrinsics.checkNotNull(L9, "null cannot be cast to non-null type com.tencent.mobileqq.flock.feedlist.viewmodel.FlockGetRecomFeedListViewModel");
        com.tencent.mobileqq.flock.feedlist.viewmodel.g gVar = (com.tencent.mobileqq.flock.feedlist.viewmodel.g) L9;
        gVar.Z1(((IAddContactSessionRepo) QRoute.api(IAddContactSessionRepo.class)).getSession(AddContactDataType.FLOCK));
        gVar.Q1().clear();
        da();
    }

    private final void I9() {
        U9();
    }

    private final void J9() {
        Long l3;
        Intent intent;
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            l3 = Long.valueOf(intent.getLongExtra("from_group_id", 0L));
        } else {
            l3 = null;
        }
        if (l3 != null) {
            if (l3.longValue() > 0) {
                com.tencent.mobileqq.flock.feedlist.viewmodel.a L9 = L9();
                Intrinsics.checkNotNull(L9, "null cannot be cast to non-null type com.tencent.mobileqq.flock.feedlist.viewmodel.FlockGetGroupFeedListViewModel");
                ((com.tencent.mobileqq.flock.feedlist.viewmodel.c) L9).f2(l3.longValue());
                da();
                return;
            }
            QLog.e("FlockFeedListBodyPart", 1, "initData error, groupId is:" + l3);
            return;
        }
        QLog.e("FlockFeedListBodyPart", 1, "initData error, groupId is null");
    }

    private final void K9(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> it) {
        QLog.d("FlockFeedListBodyPart", 1, "finishRefresh...");
        ea();
        com.tencent.mobileqq.flock.widget.d dVar = this.flockListLoadMoreAdapter;
        if (dVar != null) {
            dVar.setLoadState(false, !it.getIsFinish());
        }
    }

    private final com.tencent.mobileqq.flock.feedlist.viewmodel.a L9() {
        return (com.tencent.mobileqq.flock.feedlist.viewmodel.a) this.feedListVm.getValue();
    }

    private final void N9(FlockDeleteFeedEvent event) {
        L9().N1(event.getFeed());
    }

    private final void O9(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> uiStateData) {
        switch (b.f210153a[this.type.ordinal()]) {
            case 1:
                uiStateData.setMsg("\u672c\u7fa4\u6682\u65e0\u642d\u5b50\u6d3b\u52a8\uff0c\u5feb\u6765\u53d1\u5e03\u5427");
                break;
            case 2:
                uiStateData.setMsg("\u6682\u65e0\u53d1\u5e03\u7684\u6d3b\u52a8\u54e6\uff5e");
                break;
            case 3:
                uiStateData.setMsg("\u6682\u65e0\u53c2\u4e0e\u7684\u6d3b\u52a8\u54e6\uff5e");
                break;
            case 4:
                uiStateData.setMsg("\u6682\u65e0\u6570\u636e");
                break;
            case 5:
                uiStateData.setMsg("\u6682\u65e0\u6570\u636e");
                break;
            case 6:
                uiStateData.setMsg("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
                break;
        }
        com.tencent.mobileqq.flock.feedlist.adapter.a aVar = this.feedListAdapter;
        FlockBlankView flockBlankView = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedListAdapter");
            aVar = null;
        }
        aVar.setItems(new ArrayList(uiStateData.getData()));
        Z9(uiStateData);
        FlockBlankView flockBlankView2 = this.flockBlankView;
        if (flockBlankView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flockBlankView");
        } else {
            flockBlankView = flockBlankView2;
        }
        flockBlankView.c();
        K9(uiStateData);
    }

    private final void P9(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> uiStateData) {
        Z9(uiStateData);
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flockBlankView");
            flockBlankView = null;
        }
        flockBlankView.c();
        K9(uiStateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> it) {
        int state = it.getState();
        if (state != 0) {
            if (state != 2 && state != 3) {
                if (state == 4) {
                    P9(it);
                    return;
                }
                return;
            }
            W9(it);
            return;
        }
        O9(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(UIStateData<List<b55.g>> it) {
        int state = it.getState();
        if (state != 0) {
            if (state != 2) {
                if (state != 3) {
                    if (state == 4) {
                        S9();
                        return;
                    }
                    return;
                }
                T9(it);
                return;
            }
            T9(it);
            return;
        }
        S9();
    }

    private final void S9() {
        FlockConstants$FlockListScene flockConstants$FlockListScene = this.type;
        if (flockConstants$FlockListScene == FlockConstants$FlockListScene.ACTIVITY || flockConstants$FlockListScene == FlockConstants$FlockListScene.RECOM) {
            RecyclerView recyclerView = this.rvFeedList;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvFeedList");
                recyclerView = null;
            }
            recyclerView.setBackground(null);
        }
    }

    private final void T9(UIStateData<List<b55.g>> it) {
        FlockConstants$FlockListScene flockConstants$FlockListScene = this.type;
        if (flockConstants$FlockListScene == FlockConstants$FlockListScene.ACTIVITY || flockConstants$FlockListScene == FlockConstants$FlockListScene.RECOM) {
            Intrinsics.checkNotNullExpressionValue(it.getData(), "it.data");
            RecyclerView recyclerView = null;
            if (!r3.isEmpty()) {
                if (QQTheme.isNowThemeIsNight()) {
                    RecyclerView recyclerView2 = this.rvFeedList;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rvFeedList");
                    } else {
                        recyclerView = recyclerView2;
                    }
                    recyclerView.setBackground(getContext().getDrawable(R.drawable.f160740jn2));
                    return;
                }
                RecyclerView recyclerView3 = this.rvFeedList;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rvFeedList");
                } else {
                    recyclerView = recyclerView3;
                }
                recyclerView.setBackground(getContext().getDrawable(R.drawable.f160739jn1));
                return;
            }
            RecyclerView recyclerView4 = this.rvFeedList;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvFeedList");
                recyclerView4 = null;
            }
            recyclerView4.setBackground(null);
        }
    }

    private final void U9() {
        com.tencent.mobileqq.flock.feedlist.viewmodel.a L9 = L9();
        if (L9 != null) {
            L9.W1(false);
        }
        Y9();
    }

    private final void V9(FlockPublishFinishEvent event) {
        if (event.isModify()) {
            if (event.getFeed() != null) {
                L9().a2(event.getFeed());
            }
        } else if (this.type == FlockConstants$FlockListScene.TROOP) {
            da();
        }
    }

    private final void W9(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> uiStateData) {
        com.tencent.mobileqq.flock.feedlist.adapter.a aVar = this.feedListAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedListAdapter");
            aVar = null;
        }
        aVar.setItems(new ArrayList(uiStateData.getData()));
        if (!uiStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.flock.feedlist.part.e
                @Override // java.lang.Runnable
                public final void run() {
                    FlockFeedListBodyPart.X9(FlockFeedListBodyPart.this);
                }
            }, 100L);
        }
        Y9();
        K9(uiStateData);
        com.tencent.mobileqq.flock.widget.d dVar = this.flockListLoadMoreAdapter;
        if (dVar != null) {
            dVar.resetAutoLoadMoreTimes();
        }
        com.tencent.mobileqq.flock.widget.d dVar2 = this.flockListLoadMoreAdapter;
        if (dVar2 != null) {
            dVar2.setMaxAutoLoadMoreTimes(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(FlockFeedListBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.rvFeedList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvFeedList");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void Y9() {
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flockBlankView");
            flockBlankView = null;
        }
        flockBlankView.b();
    }

    private final void Z9(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> uiStateData) {
        int state = uiStateData.getState();
        int i3 = 16;
        if (state != 0 && state == 4) {
            i3 = 5;
        }
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flockBlankView");
            flockBlankView = null;
        }
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setBackgroundColorType(0).setImageType(i3);
        String msg2 = uiStateData.getMsg();
        Intrinsics.checkNotNullExpressionValue(msg2, "uiStateData.msg");
        flockBlankView.setErrorViewBuilder(imageType.setTitle(msg2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void da() {
        broadcastMessage("ACTION_MSG_AUTO_REFRESH", null);
    }

    private final void ea() {
        broadcastMessage("ACTION_MSG_FINISH_REFRESH", null);
    }

    private final void initData() {
        com.tencent.mobileqq.flock.feedlist.viewmodel.g gVar;
        LiveData<UIStateData<List<b55.g>>> c26;
        com.tencent.mobileqq.flock.feedlist.viewmodel.a L9 = L9();
        if (L9 instanceof com.tencent.mobileqq.flock.feedlist.viewmodel.g) {
            gVar = (com.tencent.mobileqq.flock.feedlist.viewmodel.g) L9;
        } else {
            gVar = null;
        }
        if (gVar != null && (c26 = gVar.c2()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<UIStateData<List<? extends b55.g>>, Unit> function1 = new Function1<UIStateData<List<? extends b55.g>>, Unit>() { // from class: com.tencent.mobileqq.flock.feedlist.part.FlockFeedListBodyPart$initData$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedListBodyPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends b55.g>> uIStateData) {
                    invoke2((UIStateData<List<b55.g>>) uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<List<b55.g>> it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    FlockFeedListBodyPart flockFeedListBodyPart = FlockFeedListBodyPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    flockFeedListBodyPart.R9(it);
                }
            };
            c26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.feedlist.part.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FlockFeedListBodyPart.aa(Function1.this, obj);
                }
            });
        }
        LiveData<UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>>> R1 = L9().R1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends com.tencent.mobileqq.flock.feeddetail.bean.a>>, Unit> function12 = new Function1<UIStateData<List<? extends com.tencent.mobileqq.flock.feeddetail.bean.a>>, Unit>() { // from class: com.tencent.mobileqq.flock.feedlist.part.FlockFeedListBodyPart$initData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedListBodyPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends com.tencent.mobileqq.flock.feeddetail.bean.a>> uIStateData) {
                invoke2((UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                FlockFeedListBodyPart flockFeedListBodyPart = FlockFeedListBodyPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                flockFeedListBodyPart.Q9(it);
            }
        };
        R1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.flock.feedlist.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockFeedListBodyPart.ba(Function1.this, obj);
            }
        });
        LiveData<ToastState> S1 = L9().S1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<ToastState, Unit> function13 = new Function1<ToastState, Unit>() { // from class: com.tencent.mobileqq.flock.feedlist.part.FlockFeedListBodyPart$initData$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedListBodyPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ToastState toastState) {
                invoke2(toastState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ToastState toastState) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QQToast.makeText(FlockFeedListBodyPart.this.getContext(), 1, toastState.getMsg(), 0).show();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) toastState);
                }
            }
        };
        S1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.flock.feedlist.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockFeedListBodyPart.ca(Function1.this, obj);
            }
        });
        switch (b.f210153a[this.type.ordinal()]) {
            case 1:
                J9();
                return;
            case 2:
                F9(FlockConstants$FlockListScene.PUBLISH);
                return;
            case 3:
                F9(FlockConstants$FlockListScene.JOIN);
                return;
            case 4:
                G9();
                return;
            case 5:
                H9();
                return;
            case 6:
                I9();
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    @Nullable
    public String C8(@NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) feed);
        }
        Intrinsics.checkNotNullParameter(feed, "feed");
        return this.f210148e.C8(feed);
    }

    @NotNull
    public final FlockConstants$FlockListScene M9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FlockConstants$FlockListScene) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.type;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void S4(@NotNull Context context, @NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.f210148e.S4(context, feed);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f210148e.T1();
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    @NotNull
    public Pair<Integer, Integer> Z5(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Pair) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f210148e.Z5(context);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void Z8(@NotNull Context context, @NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.f210148e.Z8(context, feed);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean a8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f210148e.a8();
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean c6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f210148e.c6();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FlockPublishFinishEvent.class, FlockDeleteFeedEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 22, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) action, args);
        } else if (Intrinsics.areEqual(action, "ACTION_MSG_ON_REFRESH")) {
            U9();
        }
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void j3(@NotNull Context context, int tagId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, tagId);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f210148e.j3(context, tagId);
        }
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void n2(@NotNull Context context, @NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.f210148e.n2(context, feed);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        PartIOCKt.registerIoc(this, this, com.tencent.mobileqq.flock.feedcommon.ioc.b.class);
        PartIOCKt.registerIoc(this, this, mc1.a.class);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.f789648h);
            RecyclerView recyclerView = (RecyclerView) findViewById;
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext()));
            recyclerView.setItemAnimator(null);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<RecyclerVie\u2026ator = null\n            }");
            this.rvFeedList = recyclerView;
            View findViewById2 = rootView.findViewById(R.id.vb_);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.flock_blank_view)");
            this.flockBlankView = (FlockBlankView) findViewById2;
            E9();
            initData();
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, hasMore);
            return;
        }
        QLog.d("FlockFeedListBodyPart", 1, "onLoadsMoreEnd:" + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QLog.d("FlockFeedListBodyPart", 1, "onLoadMoreStart ");
        com.tencent.mobileqq.flock.feedlist.viewmodel.a L9 = L9();
        if (L9 != null) {
            L9.W1(true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) event);
        } else if (event instanceof FlockPublishFinishEvent) {
            V9((FlockPublishFinishEvent) event);
        } else if (event instanceof FlockDeleteFeedEvent) {
            N9((FlockDeleteFeedEvent) event);
        }
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean s1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f210148e.s1();
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean t3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f210148e.t3();
    }

    @Override // mc1.a
    public void t4(@NotNull y45.b feed) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (b.f210153a[this.type.ordinal()] == 1) {
            i3 = 1007;
        } else {
            i3 = 1005;
        }
        QLog.i("FlockFeedListBodyPart", 1, "broadcastMessage:ACTION_MSG_JOIN_GROUP");
        broadcastMessage("ACTION_MSG_JOIN_GROUP", new com.tencent.mobileqq.flock.feedcommon.part.a(feed, i3));
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    @NotNull
    public String y8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f210148e.y8();
    }
}
