package com.tencent.mobileqq.icgame.framework.page;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.framework.component.MultiUiComponent;
import com.tencent.mobileqq.icgame.framework.component.SingleUIComponent;
import com.tencent.mobileqq.icgame.framework.component.g;
import com.tencent.mobileqq.icgame.framework.connector.PageUIConnector;
import com.tencent.mobileqq.icgame.framework.exception.QQLiveException;
import com.tencent.mobileqq.icgame.framework.page.Page;
import com.tencent.mobileqq.icgame.framework.page.manager.ComponentManager;
import com.tencent.mobileqq.icgame.framework.page.manager.PageManager;
import com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentNode;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import g32.i;
import g32.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m32.ComponentInitEvent;
import m32.ComponentUnInitEvent;
import n32.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006&-k/25B\u0019\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u00101\u001a\u00020.\u00a2\u0006\u0004\bg\u0010hB#\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u00101\u001a\u00020.\u0012\b\b\u0002\u00104\u001a\u00020+\u00a2\u0006\u0004\bg\u0010iJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J.\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n2\u0016\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0018\u00010\nH\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0018\u00010\nH\u0002J+\u0010\u0014\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0013\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019J6\u0010\u001e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0018\u00010\nJ\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020!J!\u0010$\u001a\u00020\u0005\"\b\b\u0000\u0010\u0011*\u00020\f2\u0006\u0010#\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b$\u0010%J!\u0010&\u001a\u00020\u0005\"\b\b\u0000\u0010\u0011*\u00020\f2\u0006\u0010#\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b&\u0010%J2\u0010-\u001a\u0004\u0018\u00010\u000f2\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0\u000b2\u000e\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0\u000b2\u0006\u0010,\u001a\u00020+H\u0016R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001f\u0010>\u001a\u000609R\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R!\u0010C\u001a\b\u0012\u0004\u0012\u00020@0?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010;\u001a\u0004\bA\u0010BR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001b\u0010M\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010;\u001a\u0004\bK\u0010LR\u001f\u0010R\u001a\u00060NR\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010;\u001a\u0004\bP\u0010QR\u001f\u0010W\u001a\u00060SR\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010;\u001a\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010f\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010e\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/Page;", "Lcom/tencent/mobileqq/icgame/framework/page/a;", "Lg32/h;", "Lg32/i;", "", "", "j", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "y", "", "Ljava/lang/Class;", "Lg32/b;", "pageEventList", "l", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "clazz", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "k", "(Ljava/lang/Class;Ljava/lang/Object;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", HippyTKDListViewAdapter.X, "Landroid/content/Context;", "context", "w", "Lcom/tencent/mobileqq/icgame/framework/connector/b;", "externalConnectorList", "u", "t", "v", "Lf32/b;", DomainData.DOMAIN_NAME, "event", "w0", "(Lg32/b;)V", "a", "Lcom/tencent/mobileqq/icgame/framework/component/h;", "componentClazz", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "parentComponentClazz", "", "parentKey", "b", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/b;", "d", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/b;", DownloadInfo.spKey_Config, "e", "Ljava/lang/String;", "pageKey", "f", "Landroid/content/Context;", h.F, "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/mobileqq/icgame/framework/page/Page$b;", "i", "Lkotlin/Lazy;", "o", "()Lcom/tencent/mobileqq/icgame/framework/page/Page$b;", "iPageProxy", "Ljava/util/ArrayList;", "Ln32/b;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/util/ArrayList;", "pageEventHandlerList", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "Lcom/tencent/mobileqq/icgame/framework/page/manager/e;", "D", "Lcom/tencent/mobileqq/icgame/framework/page/manager/e;", "pageStatusManager", "Lf32/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lf32/a;", "pageComponentContext", "Lcom/tencent/mobileqq/icgame/framework/page/Page$f;", UserInfo.SEX_FEMALE, "r", "()Lcom/tencent/mobileqq/icgame/framework/page/Page$f;", "pageConnectorContext", "Lcom/tencent/mobileqq/icgame/framework/page/Page$c;", "G", "p", "()Lcom/tencent/mobileqq/icgame/framework/page/Page$c;", "interfaceConnector", "Lcom/tencent/mobileqq/icgame/framework/page/manager/c;", "H", "Lcom/tencent/mobileqq/icgame/framework/page/manager/c;", "extInterfaceManager", "Lcom/tencent/mobileqq/icgame/framework/page/manager/ComponentManager;", "I", "Lcom/tencent/mobileqq/icgame/framework/page/manager/ComponentManager;", "componentManager", "Lcom/tencent/mobileqq/icgame/framework/page/manager/b;", "J", "Lcom/tencent/mobileqq/icgame/framework/page/manager/b;", "connectorManager", "K", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "rootComponentNode", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/icgame/framework/pagefacotry/b;)V", "(Landroid/content/Context;Lcom/tencent/mobileqq/icgame/framework/pagefacotry/b;Ljava/lang/String;)V", "L", "c", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class Page implements a, g32.h, i {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.icgame.framework.page.manager.e pageStatusManager;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy pageComponentContext;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy pageConnectorContext;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy interfaceConnector;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.icgame.framework.page.manager.c extInterfaceManager;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ComponentManager componentManager;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.icgame.framework.page.manager.b connectorManager;

    /* renamed from: K, reason: from kotlin metadata */
    private ComponentNode rootComponentNode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.icgame.framework.pagefacotry.b config;

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
    @NotNull
    private final Lazy iPageProxy;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pageEventHandlerList;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u00a2\u0006\u0004\b\f\u0010\rJ5\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0096\u0001\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/Page$b;", "Lcom/tencent/mobileqq/icgame/framework/page/a;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/icgame/framework/component/h;", "componentClazz", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "parentComponentClazz", "", "parentKey", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "b", "page", "<init>", "(Lcom/tencent/mobileqq/icgame/framework/page/Page;Lcom/tencent/mobileqq/icgame/framework/page/a;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class b implements a {

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ a f237328d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Page f237329e;

        public b(@NotNull Page page, a page2) {
            Intrinsics.checkNotNullParameter(page2, "page");
            this.f237329e = page;
            this.f237328d = page2;
        }

        @Override // com.tencent.mobileqq.icgame.framework.page.a
        @Nullable
        public ComponentNode b(@NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.h> componentClazz, @NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.e> parentComponentClazz, @NotNull String parentKey) {
            Intrinsics.checkNotNullParameter(componentClazz, "componentClazz");
            Intrinsics.checkNotNullParameter(parentComponentClazz, "parentComponentClazz");
            Intrinsics.checkNotNullParameter(parentKey, "parentKey");
            return this.f237328d.b(componentClazz, parentComponentClazz, parentKey);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ+\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/Page$c;", "", "E", "Ljava/lang/Class;", "clazz", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "", "a", "(Ljava/lang/Class;Ljava/lang/Object;)V", "<init>", "(Lcom/tencent/mobileqq/icgame/framework/page/Page;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class c {
        public c() {
        }

        public <E> void a(@NotNull Class<E> clazz, E any) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Page.this.k(clazz, any);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J!\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J!\u0010\u000f\u001a\u00020\b\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/Page$e;", "Lf32/a;", "Lg32/i;", "", "getKey", "Lg32/b;", "E", "event", "", "a", "(Lg32/b;)V", "Landroid/content/Context;", "getContext", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "w0", "<init>", "(Lcom/tencent/mobileqq/icgame/framework/page/Page;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class e implements f32.a, i {
        public e() {
        }

        @Override // g32.i
        public <E extends g32.b> void a(@NotNull E event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Iterator it = Page.this.s().iterator();
            while (it.hasNext()) {
                if (((n32.b) it.next()).a(event)) {
                    return;
                }
            }
            w0(event);
        }

        @Override // f32.a
        @NotNull
        public Context getContext() {
            return Page.this.context;
        }

        @Override // f32.a
        @NotNull
        public String getKey() {
            return Page.this.pageKey;
        }

        @Override // f32.a
        @NotNull
        public LifecycleOwner getLifecycleOwner() {
            LifecycleOwner lifecycleOwner = Page.this.lifecycleOwner;
            Intrinsics.checkNotNull(lifecycleOwner);
            return lifecycleOwner;
        }

        @Override // g32.h
        public <E extends g32.b> void w0(@NotNull E event) {
            Intrinsics.checkNotNullParameter(event, "event");
            com.tencent.mobileqq.icgame.framework.pagefacotry.a<com.tencent.mobileqq.icgame.framework.component.e> e16 = Page.this.componentManager.e(d.class, Page.this.pageKey);
            if (e16 != null) {
                e16.w0(event);
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J0\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\"\b\b\u0000\u0010\u0005*\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/Page$f;", "Lf32/b;", "Lg32/g;", "c", "Lcom/tencent/mobileqq/icgame/framework/component/h;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Class;", "clazz", "Lcom/tencent/mobileqq/icgame/framework/component/d;", "a", "Lcom/tencent/mobileqq/icgame/framework/component/g;", "", "key", "b", "Lcom/tencent/mobileqq/icgame/framework/page/a;", "getPage", "<init>", "(Lcom/tencent/mobileqq/icgame/framework/page/Page;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class f implements f32.b {
        public f() {
        }

        @Override // f32.b
        @Nullable
        public <C extends com.tencent.mobileqq.icgame.framework.component.h> com.tencent.mobileqq.icgame.framework.component.d<C> a(@NotNull Class<C> clazz) {
            com.tencent.mobileqq.icgame.framework.component.d<C> dVar;
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            ComponentManager componentManager = Page.this.componentManager;
            String simpleName = clazz.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "clazz.simpleName");
            com.tencent.mobileqq.icgame.framework.pagefacotry.a<com.tencent.mobileqq.icgame.framework.component.e> e16 = componentManager.e(clazz, simpleName);
            if (e16 != null) {
                dVar = e16.getConnectableComponent();
            } else {
                dVar = null;
            }
            if (dVar == null) {
                j32.b.f409197a.w("ICGamePage", clazz.getSimpleName() + "\u672a\u627e\u5230,\u8bf7\u786e\u8ba4\u662f\u5426\u5df2\u7ecf\u6ce8\u518c");
            }
            return dVar;
        }

        @Override // f32.b
        @Nullable
        public <C extends g> com.tencent.mobileqq.icgame.framework.component.d<C> b(@NotNull Class<C> clazz, @NotNull String key) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(key, "key");
            com.tencent.mobileqq.icgame.framework.pagefacotry.a<com.tencent.mobileqq.icgame.framework.component.e> e16 = Page.this.componentManager.e(clazz, key);
            if (e16 != null) {
                return e16.getConnectableComponent();
            }
            return null;
        }

        @Override // f32.b
        @NotNull
        public g32.g c() {
            com.tencent.mobileqq.icgame.framework.pagefacotry.a<com.tencent.mobileqq.icgame.framework.component.e> e16 = Page.this.componentManager.e(d.class, Page.this.pageKey);
            Intrinsics.checkNotNull(e16);
            return e16.getConnectableComponent();
        }

        @Override // f32.b
        @NotNull
        public a getPage() {
            return Page.this.o();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Page(@NotNull Context context, @NotNull com.tencent.mobileqq.icgame.framework.pagefacotry.b config) {
        this(context, config, "key_page");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
    }

    private final void j() {
        if (this.lifecycleOwner != null) {
        } else {
            throw new QQLiveException("lifecycleOwner is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <E> void k(Class<E> clazz, E any) {
        this.extInterfaceManager.a(clazz, any);
    }

    private final List<Class<? extends g32.b>> l(List<? extends Class<? extends g32.b>> pageEventList) {
        ArrayList arrayList = new ArrayList();
        if (pageEventList != null) {
            arrayList.addAll(pageEventList);
        }
        arrayList.add(ComponentInitEvent.class);
        arrayList.add(ComponentUnInitEvent.class);
        arrayList.add(m32.c.class);
        return arrayList;
    }

    private final ComponentNode m(List<? extends Class<? extends g32.b>> pageEventList) {
        return ComponentNode.Companion.b(ComponentNode.INSTANCE, d.class, this.pageKey, null, q(), pageEventList, this.componentManager.f(), null, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b o() {
        return (b) this.iPageProxy.getValue();
    }

    private final c p() {
        return (c) this.interfaceConnector.getValue();
    }

    private final f32.a q() {
        return (f32.a) this.pageComponentContext.getValue();
    }

    private final f r() {
        return (f) this.pageConnectorContext.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<n32.b> s() {
        return (ArrayList) this.pageEventHandlerList.getValue();
    }

    private final void y(ViewGroup rootView) {
        if (rootView.getId() == -1) {
            rootView.setId(e32.a.d());
        }
        rootView.setTag(R.id.f782646l, Integer.valueOf(e32.a.d()));
        this.rootView = rootView;
    }

    @Override // g32.i
    public <E extends g32.b> void a(@NotNull E event) {
        Intrinsics.checkNotNullParameter(event, "event");
        f32.a q16 = q();
        Intrinsics.checkNotNull(q16, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.framework.eventbroadcaster.IRootEventTrigger");
        ((i) q16).a(event);
    }

    @Override // com.tencent.mobileqq.icgame.framework.page.a
    @Nullable
    public ComponentNode b(@NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.h> componentClazz, @NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.e> parentComponentClazz, @NotNull String parentKey) {
        Intrinsics.checkNotNullParameter(componentClazz, "componentClazz");
        Intrinsics.checkNotNullParameter(parentComponentClazz, "parentComponentClazz");
        Intrinsics.checkNotNullParameter(parentKey, "parentKey");
        if (this.pageStatusManager.b()) {
            return null;
        }
        return this.componentManager.l(componentClazz, parentComponentClazz, parentKey);
    }

    @NotNull
    public final f32.b n() {
        return r();
    }

    public final void t() {
        this.pageStatusManager.a(PageStatus.INIT_COMPONENT);
        PageManager.f237343a.a(this);
        ComponentManager componentManager = this.componentManager;
        ComponentNode componentNode = this.rootComponentNode;
        if (componentNode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootComponentNode");
            componentNode = null;
        }
        componentManager.g(componentNode);
    }

    public final void u(@NotNull ViewGroup rootView, @NotNull List<? extends com.tencent.mobileqq.icgame.framework.connector.b> externalConnectorList, @Nullable List<? extends Class<? extends g32.b>> pageEventList) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(externalConnectorList, "externalConnectorList");
        j();
        this.pageStatusManager.a(PageStatus.INIT_CONFIG);
        y(rootView);
        this.rootComponentNode = m(l(pageEventList));
        this.connectorManager.b(new PageUIConnector(r()), false);
        Iterator<T> it = externalConnectorList.iterator();
        while (it.hasNext()) {
            this.connectorManager.b((com.tencent.mobileqq.icgame.framework.connector.b) it.next(), true);
        }
        ComponentNode componentNode = this.rootComponentNode;
        ComponentNode componentNode2 = null;
        if (componentNode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootComponentNode");
            componentNode = null;
        }
        com.tencent.mobileqq.icgame.framework.pagefacotry.c cVar = new com.tencent.mobileqq.icgame.framework.pagefacotry.c(componentNode, this.config);
        cVar.a();
        this.componentManager.h(rootView, q());
        this.connectorManager.f(r());
        this.connectorManager.a(cVar.b());
        this.connectorManager.d(p());
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
        com.tencent.mobileqq.icgame.framework.component.e d16 = componentNode4.g().d();
        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.framework.page.Page.RootComponent");
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
        j32.c.c("root", componentNode2);
        this.connectorManager.e();
    }

    public final void v() {
        ComponentManager componentManager = this.componentManager;
        ComponentNode componentNode = this.rootComponentNode;
        if (componentNode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootComponentNode");
            componentNode = null;
        }
        componentManager.n(componentNode);
        this.componentManager.m();
        PageManager.f237343a.d(this);
        this.pageStatusManager.a(PageStatus.UN_INIT);
    }

    public final void w(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Activity) {
            this.context = context;
            return;
        }
        throw new QQLiveException("please set activity!!");
    }

    @Override // g32.h
    public <E extends g32.b> void w0(@NotNull E event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        com.tencent.mobileqq.icgame.framework.pagefacotry.a<com.tencent.mobileqq.icgame.framework.component.e> e16 = this.componentManager.e(d.class, this.pageKey);
        if (e16 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        j32.b.f409197a.i("ICGamePage", "trigger: RootComponent is not init");
        if (!z16) {
            e16 = null;
        }
        if (e16 != null) {
            e16.w0(event);
        }
    }

    public final void x(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
    }

    public Page(@NotNull Context context, @NotNull com.tencent.mobileqq.icgame.framework.pagefacotry.b config, @NotNull String pageKey) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.icgame.framework.page.Page$iPageProxy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Page.b invoke() {
                Page page = Page.this;
                return new Page.b(page, page);
            }
        });
        this.iPageProxy = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<n32.b>>() { // from class: com.tencent.mobileqq.icgame.framework.page.Page$pageEventHandlerList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<b> invoke() {
                ArrayList<b> arrayList = new ArrayList<>();
                arrayList.add(new n32.a());
                return arrayList;
            }
        });
        this.pageEventHandlerList = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.icgame.framework.page.Page$pageComponentContext$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Page.e invoke() {
                return new Page.e();
            }
        });
        this.pageComponentContext = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<f>() { // from class: com.tencent.mobileqq.icgame.framework.page.Page$pageConnectorContext$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Page.f invoke() {
                return new Page.f();
            }
        });
        this.pageConnectorContext = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.icgame.framework.page.Page$interfaceConnector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Page.c invoke() {
                return new Page.c();
            }
        });
        this.interfaceConnector = lazy5;
        this.context = context;
        this.config = config;
        this.pageKey = pageKey;
        this.pageStatusManager = new com.tencent.mobileqq.icgame.framework.page.manager.e();
        com.tencent.mobileqq.icgame.framework.page.manager.c cVar = new com.tencent.mobileqq.icgame.framework.page.manager.c();
        this.extInterfaceManager = cVar;
        this.componentManager = new ComponentManager(cVar, this);
        this.connectorManager = new com.tencent.mobileqq.icgame.framework.page.manager.b();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/Page$d;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", "getKey", "", "k", "i", "Lcom/tencent/mobileqq/icgame/framework/page/Page;", "page", "c", "Lm32/c;", "event", "b", "e", "Lcom/tencent/mobileqq/icgame/framework/page/Page;", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d extends com.tencent.mobileqq.icgame.framework.component.b {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Page page;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull f32.a componentContext) {
            super(componentContext);
            Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x003e A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0033 -> B:12:0x0034). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void b(@NotNull m32.c event) {
            com.tencent.mobileqq.icgame.framework.component.e eVar;
            boolean z16;
            com.tencent.mobileqq.icgame.framework.pagefacotry.a<com.tencent.mobileqq.icgame.framework.component.e> g16;
            com.tencent.mobileqq.icgame.framework.pagefacotry.a<com.tencent.mobileqq.icgame.framework.component.e> g17;
            Intrinsics.checkNotNullParameter(event, "event");
            Page page = this.page;
            if (page == null) {
                return;
            }
            l requestComponentTag = event.getRequestComponentTag();
            ComponentNode d16 = page.componentManager.d(requestComponentTag.a(), requestComponentTag.getKey());
            if (d16 != null) {
                ComponentNode parentNode = d16.getParentNode();
                if (parentNode != null && (g17 = parentNode.g()) != null) {
                    eVar = g17.d();
                    while (eVar != null && !(eVar instanceof d)) {
                        if (!(eVar instanceof com.tencent.mobileqq.icgame.framework.component.i)) {
                            z16 = false;
                            break;
                        }
                        if (!((com.tencent.mobileqq.icgame.framework.component.i) eVar).getViewLoadStatus()) {
                            if (eVar instanceof SingleUIComponent) {
                                ((SingleUIComponent) eVar).q();
                                return;
                            } else {
                                if (eVar instanceof MultiUiComponent) {
                                    ((MultiUiComponent) eVar).o();
                                    return;
                                }
                                return;
                            }
                        }
                        if (parentNode != null) {
                            parentNode = parentNode.getParentNode();
                        } else {
                            parentNode = null;
                        }
                        if (parentNode != null && (g16 = parentNode.g()) != null) {
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
                    if (!(eVar instanceof com.tencent.mobileqq.icgame.framework.component.i)) {
                    }
                }
                z16 = true;
                if (!z16) {
                }
            }
        }

        public final void c(@NotNull Page page) {
            Intrinsics.checkNotNullParameter(page, "page");
            this.page = page;
        }

        @Override // com.tencent.mobileqq.icgame.framework.component.b, com.tencent.mobileqq.icgame.framework.component.e
        @NotNull
        public String getKey() {
            return getComponentContext().getKey();
        }

        @Override // com.tencent.mobileqq.icgame.framework.component.e
        public void i() {
        }

        @Override // com.tencent.mobileqq.icgame.framework.component.e
        public void k() {
        }
    }
}
