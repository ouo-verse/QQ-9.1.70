package com.tencent.aio.base.chat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.factory.g;
import com.tencent.aio.base.log.f;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.dispatcher.HandlerPoster;
import com.tencent.aio.main.fragment.ChatFragment;
import com.tencent.aio.part.root.mvx.vb.RootAIOVB;
import com.tencent.aio.pref.annotation.HookMethodTrace;
import com.tencent.aio.runtime.AIOContextImpl;
import com.tencent.aio.runtime.strategy.c;
import com.tencent.aio.widget.ChatFragmentWidgetKt;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.runtime.strategy.IStrategyFetcher;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 t2\u00020\u0001:\u0001uB\u0017\u0012\u0006\u0010n\u001a\u00020j\u0012\u0006\u0010q\u001a\u00020\u000e\u00a2\u0006\u0004\br\u0010sJ6\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0003J(\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000eH\u0007J\b\u0010\u001a\u001a\u00020\u0012H\u0007J5\u0010!\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u001b\b\u0002\u0010 \u001a\u0015\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001d\u00a2\u0006\u0002\b\u001fH\u0007J\u0006\u0010\"\u001a\u00020\u0012J\u000e\u0010$\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u000eJ\u000e\u0010)\u001a\u00020\u00122\u0006\u0010(\u001a\u00020'J\u0006\u0010*\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020\u00122\u0006\u0010,\u001a\u00020+J\b\u0010/\u001a\u00020.H\u0016J\u000e\u00102\u001a\u00020\u00122\u0006\u00101\u001a\u000200J\u0016\u00107\u001a\u00020\u00122\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205J\u0016\u00108\u001a\u00020\u00122\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205J \u0010>\u001a\u00020\u00122\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u0002092\b\u0010=\u001a\u0004\u0018\u00010<J\u000e\u0010@\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u000eJ\u000e\u0010C\u001a\u00020\u00122\u0006\u0010B\u001a\u00020AR\u0016\u0010F\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010W\u001a\u0004\u0018\u00010Q8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010^\u001a\u0004\u0018\u00010X8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0014\u0010a\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010`R\u0016\u0010c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010bR!\u0010i\u001a\b\u0012\u0004\u0012\u00020e0d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010f\u001a\u0004\bg\u0010hR\u001a\u0010n\u001a\u00020j8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\bU\u0010k\u001a\u0004\bl\u0010mR\u001a\u0010q\u001a\u00020\u000e8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b8\u0010b\u001a\u0004\bo\u0010p\u00a8\u0006v"}, d2 = {"Lcom/tencent/aio/base/chat/ChatPie;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/aio/main/fragment/ChatFragment;", "fragment", "Landroid/content/Context;", "requireContext", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/aio/runtime/strategy/c;", "serviceFetcher", "Lkotlin/Function0;", "Landroid/view/View;", "failedCreator", "j", "", h.F, "Lcom/tencent/aio/runtime/AIOContextImpl;", "aioContext", "", ReportConstant.COSTREPORT_PREFIX, "r", "i", "Landroid/view/LayoutInflater;", "inflater", "isPreload", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/os/Bundle;", "bundle", "Lkotlin/Function1;", "Lcom/tencent/aio/api/runtime/a;", "Lkotlin/ExtensionFunctionType;", "wrapContext", "w", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "isInMultiWindowMode", HippyTKDListViewAdapter.X, "isInPictureInPictureMode", "y", "Landroid/content/res/Configuration;", "configuration", "v", "u", "Landroidx/lifecycle/Lifecycle$Event;", "event", "k", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", BdhLogUtil.LogTag.Tag_Conn, "", "actionCode", "Lcom/tencent/aio/runtime/message/b;", "action", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UserInfo.SEX_FEMALE, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "t", "fitSystemWindows", "D", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "B", "d", "Landroid/view/View;", "mViewRoot", "Landroidx/lifecycle/LifecycleRegistry;", "e", "Landroidx/lifecycle/LifecycleRegistry;", "mLifecycle", "f", "Lcom/tencent/aio/runtime/AIOContextImpl;", "l", "()Lcom/tencent/aio/runtime/AIOContextImpl;", "setAioContext$sdk_debug", "(Lcom/tencent/aio/runtime/AIOContextImpl;)V", "Lcom/tencent/aio/data/AIOParam;", "Lcom/tencent/aio/data/AIOParam;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/aio/data/AIOParam;", "E", "(Lcom/tencent/aio/data/AIOParam;)V", "mAioParam", "Lcom/tencent/aio/dispatcher/HandlerPoster;", "Lcom/tencent/aio/dispatcher/HandlerPoster;", "p", "()Lcom/tencent/aio/dispatcher/HandlerPoster;", "setPreLoadIAIOPoster$sdk_debug", "(Lcom/tencent/aio/dispatcher/HandlerPoster;)V", "preLoadIAIOPoster", "Lcom/tencent/aio/part/root/mvx/vb/RootAIOVB;", "Lcom/tencent/aio/part/root/mvx/vb/RootAIOVB;", "mRootVB", "Z", "haveCompleteView", "", "Lcom/tencent/mvi/dispatcher/b;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/List;", "totalVBs", "Lcom/tencent/aio/api/factory/g;", "Lcom/tencent/aio/api/factory/g;", "o", "()Lcom/tencent/aio/api/factory/g;", "mFactory", "getUseDispatcher$sdk_debug", "()Z", "useDispatcher", "<init>", "(Lcom/tencent/aio/api/factory/g;Z)V", "G", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ChatPie implements LifecycleOwner {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean haveCompleteView;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy totalVBs;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final g mFactory;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean useDispatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mViewRoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LifecycleRegistry mLifecycle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOContextImpl aioContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOParam mAioParam;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HandlerPoster preLoadIAIOPoster;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final RootAIOVB mRootVB;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/base/chat/ChatPie$a", "Lcom/tencent/aio/dispatcher/a;", "", "complete", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a implements com.tencent.aio.dispatcher.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) ChatPie.this);
            }
        }

        @Override // com.tencent.aio.dispatcher.a
        public void complete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            com.tencent.aio.base.log.a.f69187b.d("ChatPie", "pre Complete " + ChatPie.this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/base/chat/ChatPie$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.base.chat.ChatPie$b, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"com/tencent/aio/base/chat/ChatPie$addViewBeforeCreate$1$1", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/b;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class c extends IStrategyFetcher<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ChatFragment f69159c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f69160d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewGroup f69161e;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"com/tencent/aio/base/chat/ChatPie$addViewBeforeCreate$1$1$buildService$1", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/b;", "Lcom/tencent/aio/main/fragment/ChatFragment;", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes3.dex */
        public static final class a implements com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ChatFragment a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (ChatFragment) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return c.this.f69159c;
            }
        }

        c(ChatFragment chatFragment, boolean z16, ViewGroup viewGroup) {
            this.f69159c = chatFragment;
            this.f69160d = z16;
            this.f69161e = viewGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatPie.this, chatFragment, Boolean.valueOf(z16), viewGroup);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new a();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"com/tencent/aio/base/chat/ChatPie$addViewBeforeCreate$1$1", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/b;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class d extends IStrategyFetcher<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ChatFragment f69168c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f69169d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewGroup f69170e;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"com/tencent/aio/base/chat/ChatPie$addViewBeforeCreate$1$1$buildService$1", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/b;", "Lcom/tencent/aio/main/fragment/ChatFragment;", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes3.dex */
        public static final class a implements com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }

            @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ChatFragment a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (ChatFragment) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return d.this.f69168c;
            }
        }

        d(ChatFragment chatFragment, boolean z16, ViewGroup viewGroup) {
            this.f69168c = chatFragment;
            this.f69169d = z16;
            this.f69170e = viewGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatPie.this, chatFragment, Boolean.valueOf(z16), viewGroup);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new a();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"com/tencent/aio/base/chat/ChatPie$addViewBeforeCreate$1$1", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/b;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class e extends IStrategyFetcher<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ChatFragment f69173c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f69174d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewGroup f69175e;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"com/tencent/aio/base/chat/ChatPie$addViewBeforeCreate$1$1$buildService$1", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/b;", "Lcom/tencent/aio/main/fragment/ChatFragment;", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes3.dex */
        public static final class a implements com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                }
            }

            @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ChatFragment a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (ChatFragment) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return e.this.f69173c;
            }
        }

        e(ChatFragment chatFragment, boolean z16, ViewGroup viewGroup) {
            this.f69173c = chatFragment;
            this.f69174d = z16;
            this.f69175e = viewGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatPie.this, chatFragment, Boolean.valueOf(z16), viewGroup);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new a();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23849);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatPie(@NotNull g mFactory, boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mFactory, "mFactory");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, mFactory, Boolean.valueOf(z16));
            return;
        }
        this.mFactory = mFactory;
        this.useDispatcher = z16;
        this.mRootVB = new RootAIOVB(z16);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) ChatPie$totalVBs$2.INSTANCE);
        this.totalVBs = lazy;
        com.tencent.aio.base.a.f69150c.c(mFactory.isDebugModel());
        com.tencent.mvi.a.f337742b.b(mFactory.isDebugModel());
        f buildAIOLogger = mFactory.buildAIOLogger();
        if (buildAIOLogger != null) {
            com.tencent.aio.base.log.a.f69187b.b(buildAIOLogger);
            com.tencent.mvi.log.c.f337783b.d(buildAIOLogger);
        }
        if (z16) {
            this.preLoadIAIOPoster = new HandlerPoster(Looper.getMainLooper(), 50, new a());
        }
    }

    public static final /* synthetic */ View c(ChatPie chatPie) {
        View view = chatPie.mViewRoot;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewRoot");
        }
        return view;
    }

    private final boolean h() {
        HandlerPoster handlerPoster = this.preLoadIAIOPoster;
        if (handlerPoster != null && this.haveCompleteView) {
            Intrinsics.checkNotNull(handlerPoster);
            if (handlerPoster.e()) {
                return true;
            }
        }
        return this.haveCompleteView;
    }

    @Deprecated(message = "\u6682\u672a\u9a8c\u8bc1\uff0c\u7981\u6b62\u4f7f\u7528")
    private final void i(ChatFragment fragment, final AIOContextImpl aioContext) {
        if (q().isEmpty()) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(q().size());
        final int size = q().size();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService b16 = ChatFragmentWidgetKt.b(fragment).b();
        com.tencent.aio.base.log.a.f69187b.d("ChatPie", "concurrentBuildVM");
        for (int i3 = 0; i3 < size; i3++) {
            b16.execute(new Runnable(atomicInteger, size, aioContext, countDownLatch) { // from class: com.tencent.aio.base.chat.ChatPie$concurrentBuildVM$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AtomicInteger f69163d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f69164e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ AIOContextImpl f69165f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ CountDownLatch f69166h;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f69163d = atomicInteger;
                    this.f69164e = size;
                    this.f69165f = aioContext;
                    this.f69166h = countDownLatch;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, ChatPie.this, atomicInteger, Integer.valueOf(size), aioContext, countDownLatch);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    List q16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    int andIncrement = this.f69163d.getAndIncrement();
                    if (andIncrement < this.f69164e) {
                        q16 = ChatPie.this.q();
                        com.tencent.mvi.mvvm.framework.a<?, ?, ?> k3 = ((com.tencent.mvi.dispatcher.b) q16.get(andIncrement)).k();
                        if (k3 != null) {
                            k3.handleCreateVM(this.f69165f);
                            k3.handleAfterCreateVM();
                            k3.handleCompleteBuildVM();
                            this.f69166h.countDown();
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mvi.mvvm.framework.DispatchVB<*, *, com.tencent.aio.api.runtime.AIOContext>");
                    }
                    com.tencent.aio.base.log.a.f69187b.d("ChatPie", "\u4efb\u52a1\u6267\u884c\u5b8c\u4e86");
                }
            });
        }
        while (atomicInteger.get() < size) {
            int andIncrement = atomicInteger.getAndIncrement();
            com.tencent.mvi.mvvm.framework.a<?, ?, ?> k3 = q().get(andIncrement).k();
            if (k3 != null) {
                com.tencent.aio.base.log.a.f69187b.d("ChatPie", "\u4e3b\u7ebf\u7a0b\u6267\u884c   " + andIncrement + "  " + k3);
                k3.handleCreateVM(aioContext);
                k3.handleCompleteBuildVM();
                countDownLatch.countDown();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.mvi.mvvm.framework.DispatchVB<*, *, com.tencent.aio.api.runtime.AIOContext>");
            }
        }
        com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
        aVar.d("ChatPie", "\u4e3b\u7ebf\u7a0b\u7b49\u5f85");
        countDownLatch.await();
        aVar.d("ChatPie", "complete concurrentBuildVM \u4e3b\u7ebf\u7a0b\u6062\u590d");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View j(ChatFragment fragment, Context requireContext, ViewGroup container, com.tencent.aio.runtime.strategy.c serviceFetcher, Function0<? extends View> failedCreator) {
        try {
            q().clear();
            this.mRootVB.parseVBTreeNodes(requireContext, container, serviceFetcher, q(), ChatFragmentWidgetKt.c(fragment));
            com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
            aVar.d("ChatPie", "configVB nodes length " + q().size() + "  " + q());
            ChatFragmentWidgetKt.b(fragment).a(q());
            aVar.d("ChatPie", "complete Create  add build view Tree");
            return q().get(0).i();
        } catch (OutOfMemoryError e16) {
            com.tencent.aio.base.log.a.f69187b.a("ChatPie", "config error: ", e16);
            return failedCreator.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mvi.dispatcher.b> q() {
        return (List) this.totalVBs.getValue();
    }

    private final void r() {
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        stack.push(this.mRootVB);
        while (!stack.isEmpty()) {
            com.tencent.mvi.mvvm.framework.a aVar = (com.tencent.mvi.mvvm.framework.a) stack.pop();
            stack2.push(aVar);
            Iterator it = aVar.getMChildren().iterator();
            while (it.hasNext()) {
                stack.push((BaseVB) it.next());
            }
        }
        while (!stack2.isEmpty()) {
            ((com.tencent.mvi.mvvm.framework.a) stack2.pop()).handleCompleteBuildVM();
        }
    }

    private final void s(ChatFragment fragment, AIOContextImpl aioContext) {
        com.tencent.aio.base.log.a.f69187b.d("ChatPie", "iterativeBuildVM");
        Stack stack = new Stack();
        stack.push(this.mRootVB);
        while (!stack.isEmpty()) {
            com.tencent.mvi.mvvm.framework.a aVar = (com.tencent.mvi.mvvm.framework.a) stack.pop();
            aVar.handleCreateVM(aioContext);
            aVar.handleAfterCreateVM();
            for (int size = aVar.getMChildren().size() - 1; size >= 0; size--) {
                stack.push(aVar.getMChildren().get(size));
            }
        }
        r();
    }

    public final void A(@NotNull final String actionCode, @NotNull final com.tencent.aio.runtime.message.b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) actionCode, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        com.tencent.aio.runtime.a.b(this.aioContext, new Function1<j, Unit>(actionCode, action) { // from class: com.tencent.aio.base.chat.ChatPie$registerMessage$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.aio.runtime.message.b $action;
            final /* synthetic */ String $actionCode;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$actionCode = actionCode;
                this.$action = action;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) actionCode, (Object) action);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(j jVar) {
                invoke2(jVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull j it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.aio.runtime.message.a.f69828b.a(it, this.$actionCode, this.$action);
                }
            }
        });
    }

    public final void B(@NotNull Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) rect);
        } else {
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.mRootVB.h1(rect);
        }
    }

    public final void C(@NotNull final MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) msgIntent);
        } else {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            com.tencent.aio.runtime.a.b(this.aioContext, new Function1<j, Unit>() { // from class: com.tencent.aio.base.chat.ChatPie$sendMsgIntent$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) MsgIntent.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(j jVar) {
                    invoke2(jVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull j it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.h(MsgIntent.this);
                    }
                }
            });
        }
    }

    public final void D(boolean fitSystemWindows) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, fitSystemWindows);
        } else {
            this.mRootVB.i1(fitSystemWindows);
        }
    }

    public final void E(@Nullable AIOParam aIOParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aIOParam);
        } else {
            this.mAioParam = aIOParam;
        }
    }

    public final void F(@NotNull final String actionCode, @NotNull final com.tencent.aio.runtime.message.b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) actionCode, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        com.tencent.aio.runtime.a.b(this.aioContext, new Function1<j, Unit>(actionCode, action) { // from class: com.tencent.aio.base.chat.ChatPie$unRegisterMessage$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.aio.runtime.message.b $action;
            final /* synthetic */ String $actionCode;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$actionCode = actionCode;
                this.$action = action;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) actionCode, (Object) action);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(j jVar) {
                invoke2(jVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull j it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.aio.runtime.message.a.f69828b.b(it, this.$actionCode, this.$action);
                }
            }
        });
    }

    @HookMethodTrace(tag = "ChatPie#addViewBeforeCreate")
    @NotNull
    public final View g(@NotNull final ChatFragment fragment, @NotNull LayoutInflater inflater, @NotNull final ViewGroup container, final boolean isPreload) {
        View view;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, this, fragment, inflater, container, Boolean.valueOf(isPreload));
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            g gVar = this.mFactory;
            AIOParam aIOParam = this.mAioParam;
            Intrinsics.checkNotNull(aIOParam);
            final com.tencent.aio.runtime.strategy.c cVar = new com.tencent.aio.runtime.strategy.c(gVar, aIOParam);
            cVar.c(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b.class, new c(fragment, isPreload, container));
            AIOParam aIOParam2 = this.mAioParam;
            Intrinsics.checkNotNull(aIOParam2);
            if (!ft.a.d(aIOParam2) && this.preLoadIAIOPoster != null && isPreload) {
                return (View) b.c(this, new Function1<ChatPie, View>(this, fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ViewGroup $container$inlined;
                    final /* synthetic */ ChatFragment $fragment$inlined;
                    final /* synthetic */ boolean $isPreload$inlined;
                    final /* synthetic */ ChatPie this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                        this.$fragment$inlined = fragment;
                        this.$isPreload$inlined = isPreload;
                        this.$container$inlined = container;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, c.this, this, fragment, Boolean.valueOf(isPreload), container);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final View invoke(@NotNull ChatPie receiver) {
                        RootAIOVB rootAIOVB;
                        RootAIOVB rootAIOVB2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                        }
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        this.$container$inlined.removeAllViews();
                        rootAIOVB = receiver.mRootVB;
                        rootAIOVB.setPreload(this.$isPreload$inlined);
                        com.tencent.aio.base.log.a.f69187b.d("ChatPie", "startPreBuildViewTree " + receiver);
                        rootAIOVB2 = receiver.mRootVB;
                        Context requireContext = this.$fragment$inlined.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                        receiver.mViewRoot = rootAIOVB2.preBuildViewTree(requireContext, this.$container$inlined, c.this, receiver.p());
                        receiver.haveCompleteView = true;
                        return ChatPie.c(receiver);
                    }
                });
            }
            if (h()) {
                b.d(this, new Function1<ChatPie, Unit>(fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ViewGroup $container$inlined;
                    final /* synthetic */ ChatFragment $fragment$inlined;
                    final /* synthetic */ boolean $isPreload$inlined;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$fragment$inlined = fragment;
                        this.$isPreload$inlined = isPreload;
                        this.$container$inlined = container;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, ChatPie.this, fragment, Boolean.valueOf(isPreload), container);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ChatPie chatPie) {
                        invoke2(chatPie);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
                    
                        if (kotlin.jvm.internal.Intrinsics.areEqual(r6.$container$inlined.getChildAt(0), com.tencent.aio.base.chat.ChatPie.c(r7)) != false) goto L14;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2(@NotNull ChatPie receiver) {
                        boolean z16;
                        RootAIOVB rootAIOVB;
                        RootAIOVB rootAIOVB2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        if (this.$container$inlined.getChildCount() == 1) {
                            z16 = false;
                        }
                        z16 = true;
                        if (z16) {
                            this.$container$inlined.removeAllViews();
                        }
                        rootAIOVB = receiver.mRootVB;
                        rootAIOVB.setPreload(this.$isPreload$inlined);
                        rootAIOVB2 = receiver.mRootVB;
                        Context requireContext = this.$fragment$inlined.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                        rootAIOVB2.resumeVB(new com.tencent.mvi.api.help.b(requireContext, this.$container$inlined));
                        if (z16) {
                            this.$container$inlined.addView(ChatPie.c(receiver));
                        }
                        com.tencent.aio.pref.a.f69788j.m(true);
                    }
                });
            } else {
                container.removeAllViews();
                this.mRootVB.setPreload(isPreload);
                if (isPreload) {
                    view3 = (View) b.c(this, new Function1<ChatPie, View>(this, fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$4
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ ViewGroup $container$inlined;
                        final /* synthetic */ ChatFragment $fragment$inlined;
                        final /* synthetic */ boolean $isPreload$inlined;
                        final /* synthetic */ ChatPie this$0;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.this$0 = this;
                            this.$fragment$inlined = fragment;
                            this.$isPreload$inlined = isPreload;
                            this.$container$inlined = container;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, c.this, this, fragment, Boolean.valueOf(isPreload), container);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final View invoke(@NotNull ChatPie receiver) {
                            RootAIOVB rootAIOVB;
                            View j3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                            }
                            Intrinsics.checkNotNullParameter(receiver, "$receiver");
                            AIOParam m3 = receiver.m();
                            Intrinsics.checkNotNull(m3);
                            if (!ft.a.d(m3)) {
                                rootAIOVB = receiver.mRootVB;
                                Context requireContext = this.$fragment$inlined.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                                return rootAIOVB.buildViewTree(requireContext, this.$container$inlined, c.this);
                            }
                            ChatFragment chatFragment = this.$fragment$inlined;
                            Context requireContext2 = chatFragment.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext2, "fragment.requireContext()");
                            j3 = receiver.j(chatFragment, requireContext2, this.$container$inlined, c.this, new Function0<View>(receiver) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$4.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ ChatPie $this_preLoad;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.$this_preLoad = receiver;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) ChatPie$addViewBeforeCreate$$inlined$trace$lambda$4.this, (Object) receiver);
                                    }
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                @NotNull
                                public final View invoke() {
                                    RootAIOVB rootAIOVB2;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        return (View) iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                    com.tencent.aio.base.log.a.f69187b.e("ChatPie", "\u9884\u521b\u5efa\u5e76\u53d1\u5f02\u5e38\uff0c\u8d70\u540c\u6b65\u521b\u5efa\u903b\u8f91");
                                    rootAIOVB2 = this.$this_preLoad.mRootVB;
                                    Context requireContext3 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$4.this.$fragment$inlined.requireContext();
                                    Intrinsics.checkNotNullExpressionValue(requireContext3, "fragment.requireContext()");
                                    ChatPie$addViewBeforeCreate$$inlined$trace$lambda$4 chatPie$addViewBeforeCreate$$inlined$trace$lambda$4 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$4.this;
                                    return rootAIOVB2.buildViewTree(requireContext3, chatPie$addViewBeforeCreate$$inlined$trace$lambda$4.$container$inlined, c.this);
                                }
                            });
                            return j3;
                        }
                    });
                } else {
                    view3 = (View) b.a(this, new Function1<ChatPie, View>(this, fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$5
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ ViewGroup $container$inlined;
                        final /* synthetic */ ChatFragment $fragment$inlined;
                        final /* synthetic */ boolean $isPreload$inlined;
                        final /* synthetic */ ChatPie this$0;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.this$0 = this;
                            this.$fragment$inlined = fragment;
                            this.$isPreload$inlined = isPreload;
                            this.$container$inlined = container;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, c.this, this, fragment, Boolean.valueOf(isPreload), container);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final View invoke(@NotNull ChatPie receiver) {
                            RootAIOVB rootAIOVB;
                            View j3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                            }
                            Intrinsics.checkNotNullParameter(receiver, "$receiver");
                            AIOParam m3 = receiver.m();
                            Intrinsics.checkNotNull(m3);
                            if (!ft.a.d(m3)) {
                                rootAIOVB = receiver.mRootVB;
                                Context requireContext = this.$fragment$inlined.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                                return rootAIOVB.buildViewTree(requireContext, this.$container$inlined, c.this);
                            }
                            ChatFragment chatFragment = this.$fragment$inlined;
                            Context requireContext2 = chatFragment.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext2, "fragment.requireContext()");
                            j3 = receiver.j(chatFragment, requireContext2, this.$container$inlined, c.this, new Function0<View>(receiver) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$5.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ ChatPie $this_coldLoad;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.$this_coldLoad = receiver;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) ChatPie$addViewBeforeCreate$$inlined$trace$lambda$5.this, (Object) receiver);
                                    }
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                @NotNull
                                public final View invoke() {
                                    RootAIOVB rootAIOVB2;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        return (View) iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                    com.tencent.aio.base.log.a.f69187b.e("ChatPie", "\u51b7\u542f\u52a8\u5e76\u53d1\u5f02\u5e38\uff0c\u8d70\u540c\u6b65\u521b\u5efa\u903b\u8f91");
                                    rootAIOVB2 = this.$this_coldLoad.mRootVB;
                                    Context requireContext3 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$5.this.$fragment$inlined.requireContext();
                                    Intrinsics.checkNotNullExpressionValue(requireContext3, "fragment.requireContext()");
                                    ChatPie$addViewBeforeCreate$$inlined$trace$lambda$5 chatPie$addViewBeforeCreate$$inlined$trace$lambda$5 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$5.this;
                                    return rootAIOVB2.buildViewTree(requireContext3, chatPie$addViewBeforeCreate$$inlined$trace$lambda$5.$container$inlined, c.this);
                                }
                            });
                            return j3;
                        }
                    });
                }
                this.mViewRoot = view3;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewRoot");
                }
                if (!Intrinsics.areEqual(view3.getParent(), container)) {
                    View view4 = this.mViewRoot;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewRoot");
                    }
                    container.addView(view4);
                }
                this.haveCompleteView = true;
            }
        } else {
            aVar.b("chatPieCreateVB");
            String str = "AIO#chatPieCreateVB";
            if (!aVar.h()) {
                g gVar2 = this.mFactory;
                AIOParam aIOParam3 = this.mAioParam;
                Intrinsics.checkNotNull(aIOParam3);
                final com.tencent.aio.runtime.strategy.c cVar2 = new com.tencent.aio.runtime.strategy.c(gVar2, aIOParam3);
                cVar2.c(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b.class, new e(fragment, isPreload, container));
                AIOParam aIOParam4 = this.mAioParam;
                Intrinsics.checkNotNull(aIOParam4);
                if (!ft.a.d(aIOParam4) && this.preLoadIAIOPoster != null && isPreload) {
                    return (View) b.c(this, new Function1<ChatPie, View>(this, fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$7
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ ViewGroup $container$inlined;
                        final /* synthetic */ ChatFragment $fragment$inlined;
                        final /* synthetic */ boolean $isPreload$inlined;
                        final /* synthetic */ ChatPie this$0;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.this$0 = this;
                            this.$fragment$inlined = fragment;
                            this.$isPreload$inlined = isPreload;
                            this.$container$inlined = container;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, c.this, this, fragment, Boolean.valueOf(isPreload), container);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final View invoke(@NotNull ChatPie receiver) {
                            RootAIOVB rootAIOVB;
                            RootAIOVB rootAIOVB2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                            }
                            Intrinsics.checkNotNullParameter(receiver, "$receiver");
                            this.$container$inlined.removeAllViews();
                            rootAIOVB = receiver.mRootVB;
                            rootAIOVB.setPreload(this.$isPreload$inlined);
                            com.tencent.aio.base.log.a.f69187b.d("ChatPie", "startPreBuildViewTree " + receiver);
                            rootAIOVB2 = receiver.mRootVB;
                            Context requireContext = this.$fragment$inlined.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                            receiver.mViewRoot = rootAIOVB2.preBuildViewTree(requireContext, this.$container$inlined, c.this, receiver.p());
                            receiver.haveCompleteView = true;
                            return ChatPie.c(receiver);
                        }
                    });
                }
                if (h()) {
                    b.d(this, new Function1<ChatPie, Unit>(fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$8
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ ViewGroup $container$inlined;
                        final /* synthetic */ ChatFragment $fragment$inlined;
                        final /* synthetic */ boolean $isPreload$inlined;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.$fragment$inlined = fragment;
                            this.$isPreload$inlined = isPreload;
                            this.$container$inlined = container;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, ChatPie.this, fragment, Boolean.valueOf(isPreload), container);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ChatPie chatPie) {
                            invoke2(chatPie);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
                        
                            if (kotlin.jvm.internal.Intrinsics.areEqual(r6.$container$inlined.getChildAt(0), com.tencent.aio.base.chat.ChatPie.c(r7)) != false) goto L14;
                         */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke2(@NotNull ChatPie receiver) {
                            boolean z16;
                            RootAIOVB rootAIOVB;
                            RootAIOVB rootAIOVB2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(receiver, "$receiver");
                            if (this.$container$inlined.getChildCount() == 1) {
                                z16 = false;
                            }
                            z16 = true;
                            if (z16) {
                                this.$container$inlined.removeAllViews();
                            }
                            rootAIOVB = receiver.mRootVB;
                            rootAIOVB.setPreload(this.$isPreload$inlined);
                            rootAIOVB2 = receiver.mRootVB;
                            Context requireContext = this.$fragment$inlined.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                            rootAIOVB2.resumeVB(new com.tencent.mvi.api.help.b(requireContext, this.$container$inlined));
                            if (z16) {
                                this.$container$inlined.addView(ChatPie.c(receiver));
                            }
                            com.tencent.aio.pref.a.f69788j.m(true);
                        }
                    });
                } else {
                    container.removeAllViews();
                    this.mRootVB.setPreload(isPreload);
                    if (isPreload) {
                        view2 = (View) b.c(this, new Function1<ChatPie, View>(this, fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$9
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ ViewGroup $container$inlined;
                            final /* synthetic */ ChatFragment $fragment$inlined;
                            final /* synthetic */ boolean $isPreload$inlined;
                            final /* synthetic */ ChatPie this$0;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                this.this$0 = this;
                                this.$fragment$inlined = fragment;
                                this.$isPreload$inlined = isPreload;
                                this.$container$inlined = container;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, c.this, this, fragment, Boolean.valueOf(isPreload), container);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final View invoke(@NotNull ChatPie receiver) {
                                RootAIOVB rootAIOVB;
                                View j3;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                                }
                                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                                AIOParam m3 = receiver.m();
                                Intrinsics.checkNotNull(m3);
                                if (!ft.a.d(m3)) {
                                    rootAIOVB = receiver.mRootVB;
                                    Context requireContext = this.$fragment$inlined.requireContext();
                                    Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                                    return rootAIOVB.buildViewTree(requireContext, this.$container$inlined, c.this);
                                }
                                ChatFragment chatFragment = this.$fragment$inlined;
                                Context requireContext2 = chatFragment.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext2, "fragment.requireContext()");
                                j3 = receiver.j(chatFragment, requireContext2, this.$container$inlined, c.this, new Function0<View>(receiver) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$9.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ ChatPie $this_preLoad;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                        this.$this_preLoad = receiver;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) ChatPie$addViewBeforeCreate$$inlined$trace$lambda$9.this, (Object) receiver);
                                        }
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    @NotNull
                                    public final View invoke() {
                                        RootAIOVB rootAIOVB2;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            return (View) iPatchRedirector3.redirect((short) 2, (Object) this);
                                        }
                                        com.tencent.aio.base.log.a.f69187b.e("ChatPie", "\u9884\u521b\u5efa\u5e76\u53d1\u5f02\u5e38\uff0c\u8d70\u540c\u6b65\u521b\u5efa\u903b\u8f91");
                                        rootAIOVB2 = this.$this_preLoad.mRootVB;
                                        Context requireContext3 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$9.this.$fragment$inlined.requireContext();
                                        Intrinsics.checkNotNullExpressionValue(requireContext3, "fragment.requireContext()");
                                        ChatPie$addViewBeforeCreate$$inlined$trace$lambda$9 chatPie$addViewBeforeCreate$$inlined$trace$lambda$9 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$9.this;
                                        return rootAIOVB2.buildViewTree(requireContext3, chatPie$addViewBeforeCreate$$inlined$trace$lambda$9.$container$inlined, c.this);
                                    }
                                });
                                return j3;
                            }
                        });
                    } else {
                        view2 = (View) b.a(this, new Function1<ChatPie, View>(this, fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$10
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ ViewGroup $container$inlined;
                            final /* synthetic */ ChatFragment $fragment$inlined;
                            final /* synthetic */ boolean $isPreload$inlined;
                            final /* synthetic */ ChatPie this$0;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                this.this$0 = this;
                                this.$fragment$inlined = fragment;
                                this.$isPreload$inlined = isPreload;
                                this.$container$inlined = container;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, c.this, this, fragment, Boolean.valueOf(isPreload), container);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final View invoke(@NotNull ChatPie receiver) {
                                RootAIOVB rootAIOVB;
                                View j3;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                                }
                                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                                AIOParam m3 = receiver.m();
                                Intrinsics.checkNotNull(m3);
                                if (!ft.a.d(m3)) {
                                    rootAIOVB = receiver.mRootVB;
                                    Context requireContext = this.$fragment$inlined.requireContext();
                                    Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                                    return rootAIOVB.buildViewTree(requireContext, this.$container$inlined, c.this);
                                }
                                ChatFragment chatFragment = this.$fragment$inlined;
                                Context requireContext2 = chatFragment.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext2, "fragment.requireContext()");
                                j3 = receiver.j(chatFragment, requireContext2, this.$container$inlined, c.this, new Function0<View>(receiver) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$10.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ ChatPie $this_coldLoad;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                        this.$this_coldLoad = receiver;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) ChatPie$addViewBeforeCreate$$inlined$trace$lambda$10.this, (Object) receiver);
                                        }
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    @NotNull
                                    public final View invoke() {
                                        RootAIOVB rootAIOVB2;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            return (View) iPatchRedirector3.redirect((short) 2, (Object) this);
                                        }
                                        com.tencent.aio.base.log.a.f69187b.e("ChatPie", "\u51b7\u542f\u52a8\u5e76\u53d1\u5f02\u5e38\uff0c\u8d70\u540c\u6b65\u521b\u5efa\u903b\u8f91");
                                        rootAIOVB2 = this.$this_coldLoad.mRootVB;
                                        Context requireContext3 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$10.this.$fragment$inlined.requireContext();
                                        Intrinsics.checkNotNullExpressionValue(requireContext3, "fragment.requireContext()");
                                        ChatPie$addViewBeforeCreate$$inlined$trace$lambda$10 chatPie$addViewBeforeCreate$$inlined$trace$lambda$10 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$10.this;
                                        return rootAIOVB2.buildViewTree(requireContext3, chatPie$addViewBeforeCreate$$inlined$trace$lambda$10.$container$inlined, c.this);
                                    }
                                });
                                return j3;
                            }
                        });
                    }
                    this.mViewRoot = view2;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewRoot");
                    }
                    if (!Intrinsics.areEqual(view2.getParent(), container)) {
                        View view5 = this.mViewRoot;
                        if (view5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewRoot");
                        }
                        container.addView(view5);
                    }
                    this.haveCompleteView = true;
                }
                Unit unit = Unit.INSTANCE;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                g gVar3 = this.mFactory;
                AIOParam aIOParam5 = this.mAioParam;
                Intrinsics.checkNotNull(aIOParam5);
                final com.tencent.aio.runtime.strategy.c cVar3 = new com.tencent.aio.runtime.strategy.c(gVar3, aIOParam5);
                cVar3.c(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b.class, new d(fragment, isPreload, container));
                AIOParam aIOParam6 = this.mAioParam;
                Intrinsics.checkNotNull(aIOParam6);
                if (!ft.a.d(aIOParam6) && this.preLoadIAIOPoster != null && isPreload) {
                    return (View) b.c(this, new Function1<ChatPie, View>(this, fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$12
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ ViewGroup $container$inlined;
                        final /* synthetic */ ChatFragment $fragment$inlined;
                        final /* synthetic */ boolean $isPreload$inlined;
                        final /* synthetic */ ChatPie this$0;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.this$0 = this;
                            this.$fragment$inlined = fragment;
                            this.$isPreload$inlined = isPreload;
                            this.$container$inlined = container;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, c.this, this, fragment, Boolean.valueOf(isPreload), container);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final View invoke(@NotNull ChatPie receiver) {
                            RootAIOVB rootAIOVB;
                            RootAIOVB rootAIOVB2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                            }
                            Intrinsics.checkNotNullParameter(receiver, "$receiver");
                            this.$container$inlined.removeAllViews();
                            rootAIOVB = receiver.mRootVB;
                            rootAIOVB.setPreload(this.$isPreload$inlined);
                            com.tencent.aio.base.log.a.f69187b.d("ChatPie", "startPreBuildViewTree " + receiver);
                            rootAIOVB2 = receiver.mRootVB;
                            Context requireContext = this.$fragment$inlined.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                            receiver.mViewRoot = rootAIOVB2.preBuildViewTree(requireContext, this.$container$inlined, c.this, receiver.p());
                            receiver.haveCompleteView = true;
                            return ChatPie.c(receiver);
                        }
                    });
                }
                if (h()) {
                    b.d(this, new Function1<ChatPie, Unit>(fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$13
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ ViewGroup $container$inlined;
                        final /* synthetic */ ChatFragment $fragment$inlined;
                        final /* synthetic */ boolean $isPreload$inlined;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.$fragment$inlined = fragment;
                            this.$isPreload$inlined = isPreload;
                            this.$container$inlined = container;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, ChatPie.this, fragment, Boolean.valueOf(isPreload), container);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ChatPie chatPie) {
                            invoke2(chatPie);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
                        
                            if (kotlin.jvm.internal.Intrinsics.areEqual(r6.$container$inlined.getChildAt(0), com.tencent.aio.base.chat.ChatPie.c(r7)) != false) goto L14;
                         */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke2(@NotNull ChatPie receiver) {
                            boolean z16;
                            RootAIOVB rootAIOVB;
                            RootAIOVB rootAIOVB2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(receiver, "$receiver");
                            if (this.$container$inlined.getChildCount() == 1) {
                                z16 = false;
                            }
                            z16 = true;
                            if (z16) {
                                this.$container$inlined.removeAllViews();
                            }
                            rootAIOVB = receiver.mRootVB;
                            rootAIOVB.setPreload(this.$isPreload$inlined);
                            rootAIOVB2 = receiver.mRootVB;
                            Context requireContext = this.$fragment$inlined.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                            rootAIOVB2.resumeVB(new com.tencent.mvi.api.help.b(requireContext, this.$container$inlined));
                            if (z16) {
                                this.$container$inlined.addView(ChatPie.c(receiver));
                            }
                            com.tencent.aio.pref.a.f69788j.m(true);
                        }
                    });
                } else {
                    container.removeAllViews();
                    this.mRootVB.setPreload(isPreload);
                    if (isPreload) {
                        view = (View) b.c(this, new Function1<ChatPie, View>(this, fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$14
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ ViewGroup $container$inlined;
                            final /* synthetic */ ChatFragment $fragment$inlined;
                            final /* synthetic */ boolean $isPreload$inlined;
                            final /* synthetic */ ChatPie this$0;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                this.this$0 = this;
                                this.$fragment$inlined = fragment;
                                this.$isPreload$inlined = isPreload;
                                this.$container$inlined = container;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, c.this, this, fragment, Boolean.valueOf(isPreload), container);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final View invoke(@NotNull ChatPie receiver) {
                                RootAIOVB rootAIOVB;
                                View j3;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                                }
                                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                                AIOParam m3 = receiver.m();
                                Intrinsics.checkNotNull(m3);
                                if (!ft.a.d(m3)) {
                                    rootAIOVB = receiver.mRootVB;
                                    Context requireContext = this.$fragment$inlined.requireContext();
                                    Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                                    return rootAIOVB.buildViewTree(requireContext, this.$container$inlined, c.this);
                                }
                                ChatFragment chatFragment = this.$fragment$inlined;
                                Context requireContext2 = chatFragment.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext2, "fragment.requireContext()");
                                j3 = receiver.j(chatFragment, requireContext2, this.$container$inlined, c.this, new Function0<View>(receiver) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$14.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ ChatPie $this_preLoad;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                        this.$this_preLoad = receiver;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) ChatPie$addViewBeforeCreate$$inlined$trace$lambda$14.this, (Object) receiver);
                                        }
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    @NotNull
                                    public final View invoke() {
                                        RootAIOVB rootAIOVB2;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            return (View) iPatchRedirector3.redirect((short) 2, (Object) this);
                                        }
                                        com.tencent.aio.base.log.a.f69187b.e("ChatPie", "\u9884\u521b\u5efa\u5e76\u53d1\u5f02\u5e38\uff0c\u8d70\u540c\u6b65\u521b\u5efa\u903b\u8f91");
                                        rootAIOVB2 = this.$this_preLoad.mRootVB;
                                        Context requireContext3 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$14.this.$fragment$inlined.requireContext();
                                        Intrinsics.checkNotNullExpressionValue(requireContext3, "fragment.requireContext()");
                                        ChatPie$addViewBeforeCreate$$inlined$trace$lambda$14 chatPie$addViewBeforeCreate$$inlined$trace$lambda$14 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$14.this;
                                        return rootAIOVB2.buildViewTree(requireContext3, chatPie$addViewBeforeCreate$$inlined$trace$lambda$14.$container$inlined, c.this);
                                    }
                                });
                                return j3;
                            }
                        });
                    } else {
                        view = (View) b.a(this, new Function1<ChatPie, View>(this, fragment, isPreload, container) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$15
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ ViewGroup $container$inlined;
                            final /* synthetic */ ChatFragment $fragment$inlined;
                            final /* synthetic */ boolean $isPreload$inlined;
                            final /* synthetic */ ChatPie this$0;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                this.this$0 = this;
                                this.$fragment$inlined = fragment;
                                this.$isPreload$inlined = isPreload;
                                this.$container$inlined = container;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, c.this, this, fragment, Boolean.valueOf(isPreload), container);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final View invoke(@NotNull ChatPie receiver) {
                                RootAIOVB rootAIOVB;
                                View j3;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                                }
                                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                                AIOParam m3 = receiver.m();
                                Intrinsics.checkNotNull(m3);
                                if (!ft.a.d(m3)) {
                                    rootAIOVB = receiver.mRootVB;
                                    Context requireContext = this.$fragment$inlined.requireContext();
                                    Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                                    return rootAIOVB.buildViewTree(requireContext, this.$container$inlined, c.this);
                                }
                                ChatFragment chatFragment = this.$fragment$inlined;
                                Context requireContext2 = chatFragment.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext2, "fragment.requireContext()");
                                j3 = receiver.j(chatFragment, requireContext2, this.$container$inlined, c.this, new Function0<View>(receiver) { // from class: com.tencent.aio.base.chat.ChatPie$addViewBeforeCreate$$inlined$trace$lambda$15.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ ChatPie $this_coldLoad;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                        this.$this_coldLoad = receiver;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) ChatPie$addViewBeforeCreate$$inlined$trace$lambda$15.this, (Object) receiver);
                                        }
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    @NotNull
                                    public final View invoke() {
                                        RootAIOVB rootAIOVB2;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            return (View) iPatchRedirector3.redirect((short) 2, (Object) this);
                                        }
                                        com.tencent.aio.base.log.a.f69187b.e("ChatPie", "\u51b7\u542f\u52a8\u5e76\u53d1\u5f02\u5e38\uff0c\u8d70\u540c\u6b65\u521b\u5efa\u903b\u8f91");
                                        rootAIOVB2 = this.$this_coldLoad.mRootVB;
                                        Context requireContext3 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$15.this.$fragment$inlined.requireContext();
                                        Intrinsics.checkNotNullExpressionValue(requireContext3, "fragment.requireContext()");
                                        ChatPie$addViewBeforeCreate$$inlined$trace$lambda$15 chatPie$addViewBeforeCreate$$inlined$trace$lambda$15 = ChatPie$addViewBeforeCreate$$inlined$trace$lambda$15.this;
                                        return rootAIOVB2.buildViewTree(requireContext3, chatPie$addViewBeforeCreate$$inlined$trace$lambda$15.$container$inlined, c.this);
                                    }
                                });
                                return j3;
                            }
                        });
                    }
                    this.mViewRoot = view;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewRoot");
                    }
                    if (!Intrinsics.areEqual(view.getParent(), container)) {
                        View view6 = this.mViewRoot;
                        if (view6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewRoot");
                        }
                        container.addView(view6);
                    }
                    this.haveCompleteView = true;
                }
                Unit unit2 = Unit.INSTANCE;
                Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
            }
            aVar.e();
        }
        View view7 = this.mViewRoot;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewRoot");
        }
        return view7;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Lifecycle) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        LifecycleRegistry lifecycleRegistry = this.mLifecycle;
        if (lifecycleRegistry == null) {
            LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
            this.mLifecycle = lifecycleRegistry2;
            return lifecycleRegistry2;
        }
        return lifecycleRegistry;
    }

    public final void k(@NotNull Lifecycle.Event event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            LifecycleRegistry lifecycleRegistry = this.mLifecycle;
            if (lifecycleRegistry != null) {
                lifecycleRegistry.handleLifecycleEvent(event);
                com.tencent.aio.base.log.a.f69187b.i("ChatPie", "dispatchLifeCycleEvent " + hashCode() + " + event=" + event);
            }
        } catch (IllegalStateException e16) {
            com.tencent.aio.base.log.a.f69187b.e("ChatPie", "dispatchLifeCycleEvent " + event + TokenParser.SP + e16.getMessage());
        }
    }

    @Nullable
    public final AIOContextImpl l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AIOContextImpl) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.aioContext;
    }

    @Nullable
    public final AIOParam m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOParam) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mAioParam;
    }

    @NotNull
    public final g o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (g) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.mFactory;
    }

    public final void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.i("ChatPie", "onDestroy " + hashCode());
        k(Lifecycle.Event.ON_DESTROY);
        this.mRootVB.destroy();
        com.tencent.aio.runtime.a.b(this.aioContext, ChatPie$onDestroy$1.INSTANCE);
        this.aioContext = null;
        this.mLifecycle = null;
        this.mAioParam = null;
    }

    @Nullable
    public final HandlerPoster p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HandlerPoster) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.preLoadIAIOPoster;
    }

    public final void t(int requestCode, int resultCode, @Nullable Intent data) {
        ts.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        AIOContextImpl aIOContextImpl = this.aioContext;
        ts.a aVar2 = null;
        if (aIOContextImpl != null) {
            aVar = aIOContextImpl.f();
        } else {
            aVar = null;
        }
        if (aVar instanceof com.tencent.aio.runtime.launcher.b) {
            aVar2 = aVar;
        }
        com.tencent.aio.runtime.launcher.b bVar = (com.tencent.aio.runtime.launcher.b) aVar2;
        if (bVar != null) {
            bVar.e(requestCode, resultCode, data);
        }
    }

    public final boolean u() {
        ml3.b b16;
        com.tencent.aio.api.runtime.emitter.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        AIOContextImpl aIOContextImpl = this.aioContext;
        if (aIOContextImpl != null && (b16 = aIOContextImpl.b()) != null && (aVar = (com.tencent.aio.api.runtime.emitter.a) b16.b(com.tencent.aio.api.runtime.emitter.a.class)) != null) {
            return aVar.onBackEvent();
        }
        return false;
    }

    public final void v(@NotNull Configuration configuration) {
        ml3.b b16;
        com.tencent.aio.api.runtime.emitter.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) configuration);
            return;
        }
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        AIOContextImpl aIOContextImpl = this.aioContext;
        if (aIOContextImpl != null && (b16 = aIOContextImpl.b()) != null && (bVar = (com.tencent.aio.api.runtime.emitter.b) b16.b(com.tencent.aio.api.runtime.emitter.b.class)) != null) {
            bVar.onConfigurationChanged(configuration);
        }
    }

    @HookMethodTrace(tag = "ChatPie#onCreate")
    public final void w(@NotNull Bundle bundle, @NotNull final ChatFragment fragment, @Nullable Function1<? super com.tencent.aio.api.runtime.a, Unit> wrapContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, bundle, fragment, wrapContext);
            return;
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
        aVar.i("ChatPie", "onCreate " + hashCode());
        this.mLifecycle = new LifecycleRegistry(this);
        this.mAioParam = (AIOParam) bundle.getParcelable("aio_param");
        AIOParam aIOParam = this.mAioParam;
        Intrinsics.checkNotNull(aIOParam);
        AIOContextImpl aIOContextImpl = new AIOContextImpl(fragment, aIOParam, this, new Function0<ts.a>(fragment) { // from class: com.tencent.aio.base.chat.ChatPie$onCreate$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ChatFragment $fragment;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$fragment = fragment;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) ChatPie.this, (Object) fragment);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ts.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? b.b(ChatPie.this, this.$fragment) : (ts.a) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
        this.aioContext = aIOContextImpl;
        if (wrapContext != null) {
            Intrinsics.checkNotNull(aIOContextImpl);
            wrapContext.invoke(aIOContextImpl);
        }
        com.tencent.aio.pref.a aVar2 = com.tencent.aio.pref.a.f69788j;
        if (!aVar2.g()) {
            AIOParam aIOParam2 = this.mAioParam;
            if (aIOParam2 != null && ft.a.a(aIOParam2)) {
                AIOContextImpl aIOContextImpl2 = this.aioContext;
                Intrinsics.checkNotNull(aIOContextImpl2);
                i(fragment, aIOContextImpl2);
            } else {
                AIOParam aIOParam3 = this.mAioParam;
                if (aIOParam3 != null && ft.a.b(aIOParam3)) {
                    AIOContextImpl aIOContextImpl3 = this.aioContext;
                    Intrinsics.checkNotNull(aIOContextImpl3);
                    s(fragment, aIOContextImpl3);
                } else {
                    RootAIOVB rootAIOVB = this.mRootVB;
                    AIOContextImpl aIOContextImpl4 = this.aioContext;
                    Intrinsics.checkNotNull(aIOContextImpl4);
                    rootAIOVB.buildVM(aIOContextImpl4);
                    aVar.d("ChatPie", "recursiveBuildVM");
                }
            }
            AIOContextImpl aIOContextImpl5 = this.aioContext;
            Intrinsics.checkNotNull(aIOContextImpl5);
            com.tencent.aio.runtime.dispatcher.b.a(aIOContextImpl5, 1);
        } else {
            aVar2.b("rootVMBuild");
            String str = "AIO#rootVMBuild";
            if (!aVar2.h()) {
                AIOParam aIOParam4 = this.mAioParam;
                if (aIOParam4 != null && ft.a.a(aIOParam4)) {
                    AIOContextImpl aIOContextImpl6 = this.aioContext;
                    Intrinsics.checkNotNull(aIOContextImpl6);
                    i(fragment, aIOContextImpl6);
                } else {
                    AIOParam aIOParam5 = this.mAioParam;
                    if (aIOParam5 != null && ft.a.b(aIOParam5)) {
                        AIOContextImpl aIOContextImpl7 = this.aioContext;
                        Intrinsics.checkNotNull(aIOContextImpl7);
                        s(fragment, aIOContextImpl7);
                    } else {
                        RootAIOVB rootAIOVB2 = this.mRootVB;
                        AIOContextImpl aIOContextImpl8 = this.aioContext;
                        Intrinsics.checkNotNull(aIOContextImpl8);
                        rootAIOVB2.buildVM(aIOContextImpl8);
                        aVar.d("ChatPie", "recursiveBuildVM");
                    }
                }
                AIOContextImpl aIOContextImpl9 = this.aioContext;
                Intrinsics.checkNotNull(aIOContextImpl9);
                com.tencent.aio.runtime.dispatcher.b.a(aIOContextImpl9, 1);
                Unit unit = Unit.INSTANCE;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                AIOParam aIOParam6 = this.mAioParam;
                if (aIOParam6 != null && ft.a.a(aIOParam6)) {
                    AIOContextImpl aIOContextImpl10 = this.aioContext;
                    Intrinsics.checkNotNull(aIOContextImpl10);
                    i(fragment, aIOContextImpl10);
                } else {
                    AIOParam aIOParam7 = this.mAioParam;
                    if (aIOParam7 != null && ft.a.b(aIOParam7)) {
                        AIOContextImpl aIOContextImpl11 = this.aioContext;
                        Intrinsics.checkNotNull(aIOContextImpl11);
                        s(fragment, aIOContextImpl11);
                    } else {
                        RootAIOVB rootAIOVB3 = this.mRootVB;
                        AIOContextImpl aIOContextImpl12 = this.aioContext;
                        Intrinsics.checkNotNull(aIOContextImpl12);
                        rootAIOVB3.buildVM(aIOContextImpl12);
                        aVar.d("ChatPie", "recursiveBuildVM");
                    }
                }
                AIOContextImpl aIOContextImpl13 = this.aioContext;
                Intrinsics.checkNotNull(aIOContextImpl13);
                com.tencent.aio.runtime.dispatcher.b.a(aIOContextImpl13, 1);
                Unit unit2 = Unit.INSTANCE;
                Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
            }
            aVar2.e();
        }
        if (!aVar2.g()) {
            k(Lifecycle.Event.ON_CREATE);
            return;
        }
        aVar2.b("chatPieOnCreate");
        String str2 = "AIO#chatPieOnCreate";
        if (!aVar2.h()) {
            k(Lifecycle.Event.ON_CREATE);
            Unit unit3 = Unit.INSTANCE;
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            k(Lifecycle.Event.ON_CREATE);
            Unit unit4 = Unit.INSTANCE;
            Log.w("AIO#", str2 + " spend " + (System.currentTimeMillis() - currentTimeMillis2));
        }
        aVar2.e();
    }

    public final void x(boolean isInMultiWindowMode) {
        ml3.b b16;
        com.tencent.aio.api.runtime.emitter.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, isInMultiWindowMode);
            return;
        }
        AIOContextImpl aIOContextImpl = this.aioContext;
        if (aIOContextImpl != null && (b16 = aIOContextImpl.b()) != null && (cVar = (com.tencent.aio.api.runtime.emitter.c) b16.b(com.tencent.aio.api.runtime.emitter.c.class)) != null) {
            cVar.onMultiWindowModeChanged(isInMultiWindowMode);
        }
    }

    public final void y(boolean isInPictureInPictureMode) {
        ml3.b b16;
        com.tencent.aio.api.runtime.emitter.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, isInPictureInPictureMode);
            return;
        }
        AIOContextImpl aIOContextImpl = this.aioContext;
        if (aIOContextImpl != null && (b16 = aIOContextImpl.b()) != null && (dVar = (com.tencent.aio.api.runtime.emitter.d) b16.b(com.tencent.aio.api.runtime.emitter.d.class)) != null) {
            dVar.onPictureInPictureModeChanged(isInPictureInPictureMode);
        }
    }

    @HookMethodTrace(tag = "ChatPie#preCreateVM")
    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mRootVB.preCreateVM();
        }
    }
}
