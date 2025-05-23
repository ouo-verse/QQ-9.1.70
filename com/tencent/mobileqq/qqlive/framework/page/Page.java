package com.tencent.mobileqq.qqlive.framework.page;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.framework.component.MultiUiComponent;
import com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent;
import com.tencent.mobileqq.qqlive.framework.component.g;
import com.tencent.mobileqq.qqlive.framework.connector.PageUIConnector;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.i;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.l;
import com.tencent.mobileqq.qqlive.framework.exception.QQLiveException;
import com.tencent.mobileqq.qqlive.framework.page.Page;
import com.tencent.mobileqq.qqlive.framework.page.manager.ComponentManager;
import com.tencent.mobileqq.qqlive.framework.page.manager.PageManager;
import com.tencent.mobileqq.qqlive.framework.pagefacotry.ComponentNode;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006%gh'+/B\u0019\b\u0016\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\bc\u0010dB#\b\u0016\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010)\u001a\u00020&\u0012\b\b\u0002\u0010-\u001a\u00020*\u00a2\u0006\u0004\bc\u0010eJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J.\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n2\u0016\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0018\u00010\nH\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0018\u00010\nH\u0002J+\u0010\u0014\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0013\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018J6\u0010\u001d\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\n2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0018\u00010\nJ\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010!\u001a\u00020 J!\u0010#\u001a\u00020\u0005\"\b\b\u0000\u0010\u0011*\u00020\f2\u0006\u0010\"\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u0005\"\b\b\u0000\u0010\u0011*\u00020\f2\u0006\u0010\"\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b%\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00104R\u001f\u00109\u001a\u000605R\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u00106\u001a\u0004\b7\u00108R!\u0010?\u001a\b\u0012\u0004\u0012\u00020;0:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u00106\u001a\u0004\b=\u0010>R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u00106\u001a\u0004\bG\u0010HR\u001f\u0010N\u001a\u00060JR\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u00106\u001a\u0004\bL\u0010MR\u001f\u0010S\u001a\u00060OR\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u00106\u001a\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010a\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/Page;", "Lcom/tencent/mobileqq/qqlive/framework/page/a;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/i;", "", "", "i", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "v", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "pageEventList", "k", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/ComponentNode;", "l", "E", "clazz", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "j", "(Ljava/lang/Class;Ljava/lang/Object;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "u", "Lcom/tencent/mobileqq/qqlive/framework/connector/b;", "externalConnectorList", ReportConstant.COSTREPORT_PREFIX, "r", "t", "Lfi2/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "event", "C0", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;)V", "a", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/b;", "d", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/b;", DownloadInfo.spKey_Config, "", "e", "Ljava/lang/String;", "pageKey", "Landroid/content/Context;", "f", "Landroid/content/Context;", "context", h.F, "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mobileqq/qqlive/framework/page/Page$b;", "Lkotlin/Lazy;", "getIPageProxy", "()Lcom/tencent/mobileqq/qqlive/framework/page/Page$b;", "iPageProxy", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/framework/pageevent/handler/b;", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/ArrayList;", "pageEventHandlerList", "D", "Landroid/view/ViewGroup;", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/e;", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/e;", "pageStatusManager", "Lfi2/a;", UserInfo.SEX_FEMALE, "o", "()Lfi2/a;", "pageComponentContext", "Lcom/tencent/mobileqq/qqlive/framework/page/Page$f;", "G", "p", "()Lcom/tencent/mobileqq/qqlive/framework/page/Page$f;", "pageConnectorContext", "Lcom/tencent/mobileqq/qqlive/framework/page/Page$c;", "H", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/qqlive/framework/page/Page$c;", "interfaceConnector", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/c;", "I", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/c;", "extInterfaceManager", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/ComponentManager;", "J", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/ComponentManager;", "componentManager", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/b;", "K", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/b;", "connectorManager", "L", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/ComponentNode;", "rootComponentNode", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/b;)V", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/b;Ljava/lang/String;)V", "M", "b", "c", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class Page implements a, com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h, i {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy pageEventHandlerList;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.framework.page.manager.e pageStatusManager;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy pageComponentContext;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy pageConnectorContext;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy interfaceConnector;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.framework.page.manager.c extInterfaceManager;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ComponentManager componentManager;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.framework.page.manager.b connectorManager;

    /* renamed from: L, reason: from kotlin metadata */
    private ComponentNode rootComponentNode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.framework.pagefacotry.b config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context context;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LifecycleOwner lifecycleOwner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewModelStoreOwner viewModelStoreOwner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy iPageProxy;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/Page$a;", "", "", "KEY_PAGE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.framework.page.Page$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/Page$b;", "Lcom/tencent/mobileqq/qqlive/framework/page/a;", "page", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/page/Page;Lcom/tencent/mobileqq/qqlive/framework/page/a;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class b implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ a f271276d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Page f271277e;

        public b(@NotNull Page page, a page2) {
            Intrinsics.checkNotNullParameter(page2, "page");
            this.f271277e = page;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) page, (Object) page2);
            } else {
                this.f271276d = page2;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ+\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/Page$c;", "", "E", "Ljava/lang/Class;", "clazz", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "", "a", "(Ljava/lang/Class;Ljava/lang/Object;)V", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/page/Page;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class c {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Page.this);
            }
        }

        public <E> void a(@NotNull Class<E> clazz, E any) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) clazz, (Object) any);
            } else {
                Intrinsics.checkNotNullParameter(clazz, "clazz");
                Page.this.j(clazz, any);
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/Page$d;", "Lcom/tencent/mobileqq/qqlive/framework/component/b;", "", "getKey", "", "k", "i", "Lcom/tencent/mobileqq/qqlive/framework/page/Page;", "page", "c", "Lcom/tencent/mobileqq/qqlive/framework/pageevent/c;", "event", "b", "e", "Lcom/tencent/mobileqq/qqlive/framework/page/Page;", "Lfi2/a;", "componentContext", "<init>", "(Lfi2/a;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d extends com.tencent.mobileqq.qqlive.framework.component.b {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Page page;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull fi2.a componentContext) {
            super(componentContext);
            Intrinsics.checkNotNullParameter(componentContext, "componentContext");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) componentContext);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x004d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0042 -> B:18:0x0043). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void b(@NotNull com.tencent.mobileqq.qqlive.framework.pageevent.c event) {
            com.tencent.mobileqq.qqlive.framework.component.e eVar;
            boolean z16;
            com.tencent.mobileqq.qqlive.framework.pagefacotry.a<com.tencent.mobileqq.qqlive.framework.component.e> g16;
            com.tencent.mobileqq.qqlive.framework.pagefacotry.a<com.tencent.mobileqq.qqlive.framework.component.e> g17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            Page page = this.page;
            if (page == null) {
                return;
            }
            l c16 = event.c();
            ComponentNode d16 = page.componentManager.d(c16.a(), c16.b());
            if (d16 != null) {
                ComponentNode h16 = d16.h();
                if (h16 != null && (g17 = h16.g()) != null) {
                    eVar = g17.d();
                    while (eVar != null && !(eVar instanceof d)) {
                        if (!(eVar instanceof com.tencent.mobileqq.qqlive.framework.component.i)) {
                            z16 = false;
                            break;
                        }
                        if (!((com.tencent.mobileqq.qqlive.framework.component.i) eVar).d()) {
                            if (eVar instanceof SingleUIComponent) {
                                ((SingleUIComponent) eVar).s();
                                return;
                            } else {
                                if (eVar instanceof MultiUiComponent) {
                                    ((MultiUiComponent) eVar).o();
                                    return;
                                }
                                return;
                            }
                        }
                        if (h16 != null) {
                            h16 = h16.h();
                        } else {
                            h16 = null;
                        }
                        if (h16 != null && (g16 = h16.g()) != null) {
                            eVar = g16.d();
                        }
                    }
                    z16 = true;
                    if (!z16) {
                        page.componentManager.b(d16);
                        return;
                    }
                    return;
                }
                eVar = null;
                while (eVar != null) {
                    if (!(eVar instanceof com.tencent.mobileqq.qqlive.framework.component.i)) {
                    }
                }
                z16 = true;
                if (!z16) {
                }
            }
        }

        public final void c(@NotNull Page page) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) page);
            } else {
                Intrinsics.checkNotNullParameter(page, "page");
                this.page = page;
            }
        }

        @Override // com.tencent.mobileqq.qqlive.framework.component.b, com.tencent.mobileqq.qqlive.framework.component.e
        @NotNull
        public String getKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return e().getKey();
        }

        @Override // com.tencent.mobileqq.qqlive.framework.component.e
        public void i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.framework.component.e
        public void k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0016J!\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J!\u0010\u0011\u001a\u00020\b\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0011\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/Page$e;", "Lfi2/a;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/i;", "", "getKey", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "E", "event", "", "a", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;)V", "Landroid/content/Context;", "getContext", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "y", "C0", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/page/Page;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class e implements fi2.a, i {
        static IPatchRedirector $redirector_;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Page.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h
        public <E extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> void C0(@NotNull E event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            com.tencent.mobileqq.qqlive.framework.pagefacotry.a<com.tencent.mobileqq.qqlive.framework.component.e> e16 = Page.this.componentManager.e(d.class, Page.this.pageKey);
            if (e16 != null) {
                e16.C0(event);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.i
        public <E extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> void a(@NotNull E event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            Iterator it = Page.this.q().iterator();
            while (it.hasNext()) {
                if (((com.tencent.mobileqq.qqlive.framework.pageevent.handler.b) it.next()).a(event)) {
                    return;
                }
            }
            C0(event);
        }

        @Override // fi2.a
        @NotNull
        public Context getContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return Page.this.context;
            }
            return (Context) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // fi2.a
        @NotNull
        public String getKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return Page.this.pageKey;
            }
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // fi2.a
        @NotNull
        public LifecycleOwner getLifecycleOwner() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                LifecycleOwner lifecycleOwner = Page.this.lifecycleOwner;
                Intrinsics.checkNotNull(lifecycleOwner);
                return lifecycleOwner;
            }
            return (LifecycleOwner) iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // fi2.a
        @NotNull
        public ViewModelStoreOwner y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                ViewModelStoreOwner viewModelStoreOwner = Page.this.viewModelStoreOwner;
                Intrinsics.checkNotNull(viewModelStoreOwner);
                return viewModelStoreOwner;
            }
            return (ViewModelStoreOwner) iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J0\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\"\b\b\u0000\u0010\u0005*\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/Page$f;", "Lfi2/b;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/g;", "c", "Lcom/tencent/mobileqq/qqlive/framework/component/h;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Class;", "clazz", "Lcom/tencent/mobileqq/qqlive/framework/component/d;", "a", "Lcom/tencent/mobileqq/qqlive/framework/component/g;", "", "key", "b", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/page/Page;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class f implements fi2.b {
        static IPatchRedirector $redirector_;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Page.this);
            }
        }

        @Override // fi2.b
        @Nullable
        public <C extends com.tencent.mobileqq.qqlive.framework.component.h> com.tencent.mobileqq.qqlive.framework.component.d<C> a(@NotNull Class<C> clazz) {
            com.tencent.mobileqq.qqlive.framework.component.d<C> dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.mobileqq.qqlive.framework.component.d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) clazz);
            }
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            ComponentManager componentManager = Page.this.componentManager;
            String simpleName = clazz.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "clazz.simpleName");
            com.tencent.mobileqq.qqlive.framework.pagefacotry.a<com.tencent.mobileqq.qqlive.framework.component.e> e16 = componentManager.e(clazz, simpleName);
            if (e16 != null) {
                dVar = e16.e();
            } else {
                dVar = null;
            }
            if (dVar == null) {
                com.tencent.mobileqq.qqlive.framework.log.b.f271266a.w("Page", clazz.getSimpleName() + "\u672a\u627e\u5230,\u8bf7\u786e\u8ba4\u662f\u5426\u5df2\u7ecf\u6ce8\u518c");
            }
            return dVar;
        }

        @Override // fi2.b
        @Nullable
        public <C extends g> com.tencent.mobileqq.qqlive.framework.component.d<C> b(@NotNull Class<C> clazz, @NotNull String key) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.mobileqq.qqlive.framework.component.d) iPatchRedirector.redirect((short) 4, (Object) this, (Object) clazz, (Object) key);
            }
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(key, "key");
            com.tencent.mobileqq.qqlive.framework.pagefacotry.a<com.tencent.mobileqq.qqlive.framework.component.e> e16 = Page.this.componentManager.e(clazz, key);
            if (e16 != null) {
                return e16.e();
            }
            return null;
        }

        @Override // fi2.b
        @NotNull
        public com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            com.tencent.mobileqq.qqlive.framework.pagefacotry.a<com.tencent.mobileqq.qqlive.framework.component.e> e16 = Page.this.componentManager.e(d.class, Page.this.pageKey);
            Intrinsics.checkNotNull(e16);
            return e16.e();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34631);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Page(@NotNull Context context, @NotNull com.tencent.mobileqq.qqlive.framework.pagefacotry.b config) {
        this(context, config, "key_page");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) config);
    }

    private final void i() {
        if (this.lifecycleOwner != null) {
        } else {
            throw new QQLiveException("lifecycleOwner is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <E> void j(Class<E> clazz, E any) {
        this.extInterfaceManager.a(clazz, any);
    }

    private final List<Class<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b>> k(List<? extends Class<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b>> pageEventList) {
        ArrayList arrayList = new ArrayList();
        if (pageEventList != null) {
            arrayList.addAll(pageEventList);
        }
        arrayList.add(com.tencent.mobileqq.qqlive.framework.pageevent.a.class);
        arrayList.add(com.tencent.mobileqq.qqlive.framework.pageevent.b.class);
        arrayList.add(com.tencent.mobileqq.qqlive.framework.pageevent.c.class);
        return arrayList;
    }

    private final ComponentNode l(List<? extends Class<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b>> pageEventList) {
        return ComponentNode.Companion.b(ComponentNode.INSTANCE, d.class, this.pageKey, null, o(), pageEventList, this.componentManager.f(), null, 64, null);
    }

    private final c n() {
        return (c) this.interfaceConnector.getValue();
    }

    private final fi2.a o() {
        return (fi2.a) this.pageComponentContext.getValue();
    }

    private final f p() {
        return (f) this.pageConnectorContext.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<com.tencent.mobileqq.qqlive.framework.pageevent.handler.b> q() {
        return (ArrayList) this.pageEventHandlerList.getValue();
    }

    private final void v(ViewGroup rootView) {
        if (rootView.getId() == -1) {
            rootView.setId(com.tencent.mobileqq.qqlive.framework.a.d());
        }
        rootView.setTag(R.id.f782646l, Integer.valueOf(com.tencent.mobileqq.qqlive.framework.a.d()));
        this.rootView = rootView;
    }

    @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h
    public <E extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> void C0(@NotNull E event) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        com.tencent.mobileqq.qqlive.framework.pagefacotry.a<com.tencent.mobileqq.qqlive.framework.component.e> e16 = this.componentManager.e(d.class, this.pageKey);
        if (e16 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.qqlive.framework.log.b.f271266a.i("Page", "trigger: RootComponent is not init");
        if (!z16) {
            e16 = null;
        }
        if (e16 != null) {
            e16.C0(event);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.i
    public <E extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> void a(@NotNull E event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        fi2.a o16 = o();
        Intrinsics.checkNotNull(o16, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.framework.eventbroadcaster.IRootEventTrigger");
        ((i) o16).a(event);
    }

    @NotNull
    public final fi2.b m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (fi2.b) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return p();
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.pageStatusManager.a(PageStatus.INIT_COMPONENT);
        PageManager.f271291a.a(this);
        ComponentManager componentManager = this.componentManager;
        ComponentNode componentNode = this.rootComponentNode;
        if (componentNode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootComponentNode");
            componentNode = null;
        }
        componentManager.g(componentNode);
    }

    public final void s(@NotNull ViewGroup rootView, @NotNull List<? extends com.tencent.mobileqq.qqlive.framework.connector.b> externalConnectorList, @Nullable List<? extends Class<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b>> pageEventList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, rootView, externalConnectorList, pageEventList);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(externalConnectorList, "externalConnectorList");
        i();
        this.pageStatusManager.a(PageStatus.INIT_CONFIG);
        v(rootView);
        this.rootComponentNode = l(k(pageEventList));
        this.connectorManager.b(new PageUIConnector(p()), false);
        Iterator<T> it = externalConnectorList.iterator();
        while (it.hasNext()) {
            this.connectorManager.b((com.tencent.mobileqq.qqlive.framework.connector.b) it.next(), true);
        }
        ComponentNode componentNode = this.rootComponentNode;
        ComponentNode componentNode2 = null;
        if (componentNode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootComponentNode");
            componentNode = null;
        }
        com.tencent.mobileqq.qqlive.framework.pagefacotry.c cVar = new com.tencent.mobileqq.qqlive.framework.pagefacotry.c(componentNode, this.config);
        cVar.a();
        this.componentManager.h(rootView, o());
        this.connectorManager.f(p());
        this.connectorManager.a(cVar.b());
        this.connectorManager.d(n());
        ComponentManager componentManager = this.componentManager;
        ComponentNode componentNode3 = this.rootComponentNode;
        if (componentNode3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootComponentNode");
            componentNode3 = null;
        }
        componentManager.a(componentNode3);
        ComponentNode componentNode4 = this.rootComponentNode;
        if (componentNode4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootComponentNode");
            componentNode4 = null;
        }
        com.tencent.mobileqq.qqlive.framework.component.e d16 = componentNode4.g().d();
        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.framework.page.Page.RootComponent");
        ((d) d16).c(this);
        this.connectorManager.c();
        ComponentManager componentManager2 = this.componentManager;
        ComponentNode componentNode5 = this.rootComponentNode;
        if (componentNode5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootComponentNode");
            componentNode5 = null;
        }
        componentManager2.b(componentNode5);
        ComponentNode componentNode6 = this.rootComponentNode;
        if (componentNode6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootComponentNode");
        } else {
            componentNode2 = componentNode6;
        }
        com.tencent.mobileqq.qqlive.framework.log.c.c("root", componentNode2);
        this.connectorManager.e();
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ComponentManager componentManager = this.componentManager;
        ComponentNode componentNode = this.rootComponentNode;
        if (componentNode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootComponentNode");
            componentNode = null;
        }
        componentManager.m(componentNode);
        this.componentManager.l();
        PageManager.f271291a.d(this);
        this.pageStatusManager.a(PageStatus.UN_INIT);
    }

    public final void u(@NotNull LifecycleOwner lifecycleOwner, @NotNull ViewModelStoreOwner viewModelStoreOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) lifecycleOwner, (Object) viewModelStoreOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        this.lifecycleOwner = lifecycleOwner;
        this.viewModelStoreOwner = viewModelStoreOwner;
    }

    public Page(@NotNull Context context, @NotNull com.tencent.mobileqq.qqlive.framework.pagefacotry.b config, @NotNull String pageKey) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, config, pageKey);
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.qqlive.framework.page.Page$iPageProxy$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Page.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Page.b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Page.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Page page = Page.this;
                return new Page.b(page, page);
            }
        });
        this.iPageProxy = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(Page$pageEventHandlerList$2.INSTANCE);
        this.pageEventHandlerList = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.qqlive.framework.page.Page$pageComponentContext$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Page.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Page.e invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new Page.e() : (Page.e) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.pageComponentContext = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<f>() { // from class: com.tencent.mobileqq.qqlive.framework.page.Page$pageConnectorContext$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Page.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Page.f invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new Page.f() : (Page.f) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.pageConnectorContext = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.qqlive.framework.page.Page$interfaceConnector$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Page.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Page.c invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new Page.c() : (Page.c) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.interfaceConnector = lazy5;
        this.context = context;
        this.config = config;
        this.pageKey = pageKey;
        this.pageStatusManager = new com.tencent.mobileqq.qqlive.framework.page.manager.e();
        com.tencent.mobileqq.qqlive.framework.page.manager.c cVar = new com.tencent.mobileqq.qqlive.framework.page.manager.c();
        this.extInterfaceManager = cVar;
        this.componentManager = new ComponentManager(cVar, this);
        this.connectorManager = new com.tencent.mobileqq.qqlive.framework.page.manager.b();
    }
}
