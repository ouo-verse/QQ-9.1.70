package com.tencent.qqnt.chats.core.ui.third;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chats.core.adapter.ChatsListAdapter;
import com.tencent.qqnt.chats.core.ui.third.p013const.RelativeEnum;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarCreator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0002,0B+\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00106\u001a\u000203\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0002J.\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0002J \u0010\u0012\u001a\u00020\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J.\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0006\u0010\u001d\u001a\u00020\u0002J\u0014\u0010 \u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\rJ\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001eJ\u000e\u0010$\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001eJ\u000e\u0010&\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010'\u001a\u00020\u0002J\u000e\u0010(\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0019R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0004\u0018\u0001078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R$\u0010A\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R0\u0010F\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020C0Bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020C`D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010ER\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010HR\"\u0010O\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR0\u0010P\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e0Bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e`D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010ER0\u0010Q\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0Bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010ER\u0016\u0010S\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010RR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010U\u00a8\u0006Y"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/third/e;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "viewType", "", "", "extra", "Landroid/view/View;", "j", "view", h.F, "", "Lcom/tencent/qqnt/chats/core/ui/third/const/RelativeEnum;", "enums", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "layoutParams", DomainData.DOMAIN_NAME, "", com.tencent.luggage.wxa.c8.c.G, "p", "y", "type", "i", "", NodeProps.VISIBLE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "k", "Lcom/tencent/qqnt/chats/core/ui/third/f;", "paramsList", "o", "params", "f", "t", "u", "e", ReportConstant.COSTREPORT_PREFIX, "w", HippyTKDListViewAdapter.X, ViewStickEventHelper.IS_SHOW, "g", "Landroidx/constraintlayout/widget/ConstraintLayout;", "a", "Landroidx/constraintlayout/widget/ConstraintLayout;", ParseCommon.CONTAINER, "Landroidx/recyclerview/widget/RecyclerView;", "b", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "c", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "adapter", "Lcom/tencent/qqnt/chats/core/ui/third/a;", "d", "Lcom/tencent/qqnt/chats/core/ui/third/a;", "clickListener", "Lcom/tencent/qqnt/chats/api/b;", "Lcom/tencent/qqnt/chats/api/b;", "getDtReport", "()Lcom/tencent/qqnt/chats/api/b;", "v", "(Lcom/tencent/qqnt/chats/api/b;)V", "dtReport", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/chats/core/ui/third/b;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "creator", "Lcom/tencent/qqnt/chats/core/ui/third/creator/a;", "Lcom/tencent/qqnt/chats/core/ui/third/creator/a;", "defaultCreator", "I", "getGuideLinePos", "()I", "setGuideLinePos", "(I)V", "guideLinePos", "curShowItem", "curShowView", "Z", "needRefreshGuideLine", "Lcom/tencent/qqnt/chats/core/ui/third/e$b;", "Lcom/tencent/qqnt/chats/core/ui/third/e$b;", "drawListener", "<init>", "(Landroidx/constraintlayout/widget/ConstraintLayout;Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;Lcom/tencent/qqnt/chats/core/ui/third/a;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: n, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ThirdContainer.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.core.ui.third.b>> f354979n;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConstraintLayout container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChatsListAdapter adapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a clickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.api.b dtReport;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<ThirdViewEnum, com.tencent.qqnt.chats.core.ui.third.b> creator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.ui.third.creator.a defaultCreator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int guideLinePos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<ThirdViewEnum, f> curShowItem;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<ThirdViewEnum, View> curShowView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean needRefreshGuideLine;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b drawListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/third/e$a;", "", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.ui.third.e$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/third/e$b;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "", "onDraw", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/chats/core/ui/third/e;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "containerRef", ParseCommon.CONTAINER, "<init>", "(Lcom/tencent/qqnt/chats/core/ui/third/e;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements ViewTreeObserver.OnDrawListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<e> containerRef;

        public b(@NotNull e container) {
            Intrinsics.checkNotNullParameter(container, "container");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) container);
            } else {
                this.containerRef = new WeakReference<>(container);
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            e eVar = this.containerRef.get();
            if (eVar != null && eVar.needRefreshGuideLine) {
                eVar.q();
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f354993a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48044);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ThirdViewEnum.values().length];
            try {
                iArr[ThirdViewEnum.SP_CARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f354993a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48046);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<com.tencent.qqnt.chats.core.ui.third.b>> arrayList = new ArrayList<>();
        f354979n = arrayList;
        arrayList.add(MainChatOldEarCreator.class);
        arrayList.add(com.tencent.mobileqq.activity.home.chats.biz.tianshu.a.class);
    }

    public e(@NotNull ConstraintLayout container, @NotNull RecyclerView recyclerView, @NotNull ChatsListAdapter adapter, @Nullable a aVar) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, container, recyclerView, adapter, aVar);
            return;
        }
        this.container = container;
        this.recyclerView = recyclerView;
        this.adapter = adapter;
        this.clickListener = aVar;
        HashMap<ThirdViewEnum, com.tencent.qqnt.chats.core.ui.third.b> hashMap = new HashMap<>();
        ArrayList<Class<com.tencent.qqnt.chats.core.ui.third.b>> arrayList = f354979n;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList<com.tencent.qqnt.chats.core.ui.third.b> arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((com.tencent.qqnt.chats.core.ui.third.b) ((Class) it.next()).newInstance());
        }
        for (com.tencent.qqnt.chats.core.ui.third.b bVar : arrayList2) {
            hashMap.put(bVar.d(), bVar);
        }
        this.creator = hashMap;
        this.defaultCreator = new com.tencent.qqnt.chats.core.ui.third.creator.a();
        this.guideLinePos = -1;
        this.curShowItem = new HashMap<>();
        this.curShowView = new HashMap<>();
        this.needRefreshGuideLine = true;
        b bVar2 = new b(this);
        this.drawListener = bVar2;
        this.recyclerView.getViewTreeObserver().addOnDrawListener(bVar2);
    }

    private final void h(View view, ThirdViewEnum viewType, Map<String, ? extends Object> extra) {
        com.tencent.qqnt.chats.core.ui.third.b bVar = this.creator.get(viewType);
        if (bVar == null) {
            bVar = this.defaultCreator;
        }
        Intrinsics.checkNotNullExpressionValue(bVar, "creator[viewType] ?: defaultCreator");
        bVar.e(view);
    }

    private final int i(ThirdViewEnum type) {
        if (c.f354993a[type.ordinal()] != 1) {
            return 1;
        }
        return 0;
    }

    private final View j(ThirdViewEnum viewType, Map<String, ? extends Object> extra) {
        com.tencent.qqnt.chats.core.ui.third.b bVar = this.creator.get(viewType);
        if (bVar == null) {
            bVar = this.defaultCreator;
        }
        Intrinsics.checkNotNullExpressionValue(bVar, "creator[viewType] ?: defaultCreator");
        Context context = this.container.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        return bVar.a(context, extra);
    }

    private final void l(ThirdViewEnum type) {
        com.tencent.qqnt.chats.api.b bVar = this.dtReport;
        if (bVar != null) {
            bVar.d(i(type));
        }
    }

    private final void m(ThirdViewEnum type, boolean visible) {
        com.tencent.qqnt.chats.api.b bVar = this.dtReport;
        if (bVar != null) {
            int i3 = i(type);
            if (visible) {
                bVar.p(i3);
            } else {
                bVar.h(i3);
            }
        }
    }

    private final void n(List<? extends RelativeEnum> enums, ConstraintLayout.LayoutParams layoutParams) {
        if (enums == null) {
            return;
        }
        if (enums.contains(RelativeEnum.TopToBannerBottom)) {
            layoutParams.topToBottom = R.id.f70853mk;
        }
        if (enums.contains(RelativeEnum.EndToParentEnd)) {
            layoutParams.endToEnd = 0;
        }
    }

    private final void p(int pos) {
        Guideline guideline = (Guideline) this.container.findViewById(R.id.f70853mk);
        if (guideline == null) {
            return;
        }
        guideline.setGuidelineBegin(pos);
        this.needRefreshGuideLine = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        final int s06 = this.adapter.s0();
        if (s06 == this.guideLinePos) {
            return;
        }
        this.guideLinePos = s06;
        this.container.post(new Runnable() { // from class: com.tencent.qqnt.chats.core.ui.third.c
            @Override // java.lang.Runnable
            public final void run() {
                e.r(e.this, s06);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(e this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p(i3);
    }

    private final void y(final View view, final ThirdViewEnum viewType, final Map<String, ? extends Object> extra) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chats.core.ui.third.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.z(e.this, view, viewType, extra, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(e this$0, View view, ThirdViewEnum viewType, Map map, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(viewType, "$viewType");
        a aVar = this$0.clickListener;
        if (aVar != null) {
            aVar.a(view, viewType, map);
        }
        this$0.l(viewType);
        EventCollector.getInstance().onViewClicked(view2);
    }

    public final void e(@NotNull f params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (!this.curShowItem.containsKey(params.d())) {
            f(params);
        }
        s(params);
        q();
    }

    public final void f(@NotNull f params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        View j3 = j(params.d(), params.a());
        ConstraintLayout constraintLayout = this.container;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(params.b());
        n(params.c(), layoutParams);
        Unit unit = Unit.INSTANCE;
        constraintLayout.addView(j3, layoutParams);
        this.curShowItem.put(params.d(), params);
        this.curShowView.put(params.d(), j3);
        y(j3, params.d(), params.a());
        q();
        m(params.d(), true);
    }

    public final void g(boolean isShow) {
        com.tencent.qqnt.chats.core.ui.third.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, isShow);
            return;
        }
        HashMap<ThirdViewEnum, View> hashMap = this.curShowView;
        ThirdViewEnum thirdViewEnum = ThirdViewEnum.LITTLE_EAR;
        View view = hashMap.get(thirdViewEnum);
        if (view != null && (bVar = this.creator.get(thirdViewEnum)) != null) {
            bVar.f(view, isShow);
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            QLog.d("ThirdContainer", 1, "destroy");
            this.recyclerView.getViewTreeObserver().removeOnDrawListener(this.drawListener);
        }
    }

    public final void o(@NotNull List<f> paramsList) {
        Set set;
        List minus;
        Set set2;
        List<f> minus2;
        Set set3;
        Set intersect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) paramsList);
            return;
        }
        Intrinsics.checkNotNullParameter(paramsList, "paramsList");
        List<f> list = paramsList;
        Collection<f> values = this.curShowItem.values();
        Intrinsics.checkNotNullExpressionValue(values, "curShowItem.values");
        set = CollectionsKt___CollectionsKt.toSet(values);
        minus = CollectionsKt___CollectionsKt.minus((Iterable) list, (Iterable) set);
        Iterator it = minus.iterator();
        while (it.hasNext()) {
            f((f) it.next());
        }
        Collection<f> values2 = this.curShowItem.values();
        Intrinsics.checkNotNullExpressionValue(values2, "curShowItem.values");
        set2 = CollectionsKt___CollectionsKt.toSet(list);
        minus2 = CollectionsKt___CollectionsKt.minus((Iterable) values2, (Iterable) set2);
        for (f it5 : minus2) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            t(it5);
        }
        Collection<f> values3 = this.curShowItem.values();
        Intrinsics.checkNotNullExpressionValue(values3, "curShowItem.values");
        set3 = CollectionsKt___CollectionsKt.toSet(values3);
        intersect = CollectionsKt___CollectionsKt.intersect(list, set3);
        Iterator it6 = intersect.iterator();
        while (it6.hasNext()) {
            s((f) it6.next());
        }
        q();
    }

    public final void s(@NotNull f params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        View view = this.curShowView.get(params.d());
        if (view == null) {
            return;
        }
        this.curShowItem.put(params.d(), params);
        com.tencent.qqnt.chats.core.ui.third.b bVar = this.creator.get(params.d());
        if (bVar == null) {
            bVar = this.defaultCreator;
        }
        Intrinsics.checkNotNullExpressionValue(bVar, "creator[params.viewType] ?: defaultCreator");
        bVar.b(view, params.a());
        y(view, params.d(), params.a());
    }

    public final void t(@NotNull f params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (!this.curShowView.containsKey(params.d())) {
            return;
        }
        View view = this.curShowView.get(params.d());
        QLog.d("removeView", 1, "params.viewType: " + params.d() + " view is :" + view);
        if (view != null) {
            h(view, params.d(), params.a());
            this.container.removeView(view);
        }
        this.curShowItem.remove(params.d());
        View remove = this.curShowView.remove(params.d());
        if (remove != null) {
            remove.setOnClickListener(null);
        }
        q();
        m(params.d(), false);
    }

    public final void u(@NotNull ThirdViewEnum type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        f fVar = this.curShowItem.get(type);
        if (fVar != null) {
            t(fVar);
        }
    }

    public final void v(@Nullable com.tencent.qqnt.chats.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.dtReport = bVar;
        }
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.needRefreshGuideLine = true;
        }
    }

    public final void x(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, visible);
            return;
        }
        Set<Map.Entry<ThirdViewEnum, com.tencent.qqnt.chats.core.ui.third.b>> entrySet = this.creator.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "creator.entries");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            ((com.tencent.qqnt.chats.core.ui.third.b) ((Map.Entry) it.next()).getValue()).c(visible);
        }
        Set<Map.Entry<ThirdViewEnum, View>> entrySet2 = this.curShowView.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet2, "curShowView.entries");
        Iterator<T> it5 = entrySet2.iterator();
        while (it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it5.next();
            com.tencent.qqnt.chats.core.ui.third.b bVar = this.creator.get(entry.getKey());
            if (bVar != null) {
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "entry.value");
                bVar.f((View) value, visible);
            }
        }
    }
}
