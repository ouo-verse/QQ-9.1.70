package com.tencent.mtt.hippy.dom;

import android.os.SystemClock;
import android.text.Layout;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyEngineLifecycleEventListener;
import com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.e;
import com.tencent.mtt.hippy.dom.node.DomActionInterceptor;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.dom.node.TextExtra;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.mtt.hippy.dom.node.i;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.uimanager.DiffUtils;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.utils.ExceptionUtil;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.smtt.flexbox.FlexNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements HippyEngineLifecycleEventListener, HippyInstanceLifecycleEventListener {

    /* renamed from: a, reason: collision with root package name */
    protected final C9226b f337224a;

    /* renamed from: b, reason: collision with root package name */
    protected volatile boolean f337225b;

    /* renamed from: j, reason: collision with root package name */
    final RenderManager f337233j;

    /* renamed from: k, reason: collision with root package name */
    volatile CopyOnWriteArrayList<DomActionInterceptor> f337234k;

    /* renamed from: l, reason: collision with root package name */
    final i f337235l;

    /* renamed from: n, reason: collision with root package name */
    private final HippyEngineContext f337237n;

    /* renamed from: q, reason: collision with root package name */
    private a f337240q;

    /* renamed from: m, reason: collision with root package name */
    private final SparseBooleanArray f337236m = new SparseBooleanArray();

    /* renamed from: c, reason: collision with root package name */
    protected boolean f337226c = false;

    /* renamed from: g, reason: collision with root package name */
    final ArrayList<g> f337230g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    final Object f337231h = new Object();

    /* renamed from: i, reason: collision with root package name */
    final d f337232i = new d();

    /* renamed from: o, reason: collision with root package name */
    private volatile boolean f337238o = false;

    /* renamed from: p, reason: collision with root package name */
    private volatile boolean f337239p = false;

    /* renamed from: d, reason: collision with root package name */
    final com.tencent.mtt.hippy.dom.c f337227d = new com.tencent.mtt.hippy.dom.c();

    /* renamed from: e, reason: collision with root package name */
    final ArrayList<g> f337228e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    final ArrayList<g> f337229f = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void b(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.dom.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C9226b implements e.a {
        C9226b() {
        }

        @Override // com.tencent.mtt.hippy.dom.e.a
        public void a(long j3) {
            b.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f337294a;

        /* renamed from: b, reason: collision with root package name */
        public final int f337295b;

        public c(boolean z16, int i3) {
            this.f337294a = z16;
            this.f337295b = i3;
        }
    }

    public b(HippyEngineContext hippyEngineContext) {
        this.f337237n = hippyEngineContext;
        this.f337233j = hippyEngineContext.getRenderManager();
        hippyEngineContext.addInstanceLifecycleEventListener(this);
        this.f337224a = new C9226b();
        hippyEngineContext.addEngineLifecycleEventListener(this);
        this.f337235l = new i();
    }

    private c a(com.tencent.mtt.hippy.dom.node.b bVar, com.tencent.mtt.hippy.dom.node.b bVar2, int i3) {
        for (int i16 = 0; i16 < bVar.getChildCount(); i16++) {
            com.tencent.mtt.hippy.dom.node.b childAt = bVar.getChildAt(i16);
            if (childAt == bVar2) {
                return new c(true, i3);
            }
            if (childAt.isJustLayout()) {
                c a16 = a(childAt, bVar2, i3);
                if (a16.f337294a) {
                    return a16;
                }
                i3 = a16.f337295b;
            } else {
                i3++;
            }
        }
        return new c(false, i3);
    }

    private void i() {
        int a16 = this.f337227d.a();
        for (int i3 = 0; i3 < a16; i3++) {
            com.tencent.mtt.hippy.dom.node.b c16 = this.f337227d.c(this.f337227d.d(i3));
            if (c16 != null) {
                d(c16);
                c16.calculateLayout();
                e(c16);
                h(c16);
            }
        }
    }

    private void j() {
        if (this.f337239p) {
            this.f337225b = false;
        } else {
            e.a().a(this.f337224a);
        }
        synchronized (this.f337231h) {
            Iterator<g> it = this.f337230g.iterator();
            boolean z16 = this.f337230g.size() > 0;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g next = it.next();
                if (next != null && !this.f337238o) {
                    try {
                        next.a();
                    } catch (RuntimeException e16) {
                        e16.printStackTrace();
                    }
                }
                it.remove();
                if (this.f337225b) {
                    if (SystemClock.elapsedRealtime() - elapsedRealtime > 500) {
                        break;
                    }
                } else if (SystemClock.elapsedRealtime() - elapsedRealtime > 500) {
                    this.f337225b = true;
                    e.a().a(this.f337224a);
                    break;
                }
            }
            if (z16) {
                this.f337233j.b();
            }
        }
    }

    com.tencent.mtt.hippy.dom.node.b b(com.tencent.mtt.hippy.dom.node.b bVar) {
        do {
            bVar = bVar.getParent();
        } while (bVar.isJustLayout());
        return bVar;
    }

    public com.tencent.mtt.hippy.dom.node.b c(int i3) {
        return this.f337227d.c(i3);
    }

    public void d() {
        LogUtils.d("DomManager", "renderBatchEnd");
        this.f337226c = false;
        g();
    }

    public void e() {
        if (this.f337226c) {
            return;
        }
        c(true);
    }

    public int f() {
        for (int i3 = 0; i3 < this.f337227d.a(); i3++) {
            int d16 = this.f337227d.d(i3);
            if (d16 >= 0) {
                return d16;
            }
        }
        return 0;
    }

    public void g() {
        c(false);
    }

    public void h() {
        try {
            j();
        } catch (Throwable th5) {
            ExceptionUtil.handleNativeException(this.f337237n, th5, "flushPendingBatches error.");
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngineLifecycleEventListener
    public void onEnginePause() {
        this.f337239p = true;
    }

    @Override // com.tencent.mtt.hippy.HippyEngineLifecycleEventListener
    public void onEngineResume() {
        this.f337239p = false;
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstanceLoad(final int i3) {
        if (i3 < 0) {
            return;
        }
        this.f337237n.getThreadExecutor().postOnDomThread(new Runnable() { // from class: com.tencent.mtt.hippy.dom.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.a(i3);
            }
        });
    }

    private void f(com.tencent.mtt.hippy.dom.node.b bVar) {
        if (bVar != null) {
            int childCount = bVar.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                f(bVar.getChildAt(i3));
            }
            if (bVar instanceof TextNode) {
                bVar.markUpdated();
            }
        }
    }

    private void g(com.tencent.mtt.hippy.dom.node.b bVar) {
        for (int i3 = 0; i3 < bVar.getChildCount(); i3++) {
            final com.tencent.mtt.hippy.dom.node.b childAt = bVar.getChildAt(i3);
            if (childAt.isJustLayout()) {
                g(childAt);
            } else if (!childAt.isVirtual()) {
                a(new g() { // from class: com.tencent.mtt.hippy.dom.b.2
                    @Override // com.tencent.mtt.hippy.dom.g
                    public void a() {
                        b.this.f337233j.b(childAt.getId());
                    }
                });
            }
        }
    }

    private void h(final com.tencent.mtt.hippy.dom.node.b bVar) {
        if (bVar.hasUpdates()) {
            for (int i3 = 0; i3 < bVar.getChildCount(); i3++) {
                h(bVar.getChildAt(i3));
            }
            if (bVar.getData() != null) {
                final TextNode textNode = (TextNode) bVar;
                if (!bVar.isVirtual()) {
                    a(new g() { // from class: com.tencent.mtt.hippy.dom.b.4
                        @Override // com.tencent.mtt.hippy.dom.g
                        public void a() {
                            b.this.f337233j.a(bVar.getId(), new TextExtra(bVar.getData(), textNode.getPadding(4), textNode.getPadding(5), textNode.getPadding(3), textNode.getPadding(1)));
                        }
                    });
                }
            }
            if (!TextUtils.equals(NodeProps.ROOT_NODE, bVar.getViewClass())) {
                j(bVar);
            }
            if (bVar.shouldNotifyOnLayout()) {
                i(bVar);
            }
            bVar.markUpdateSeen();
        }
    }

    private void i(com.tencent.mtt.hippy.dom.node.b bVar) {
        if (this.f337237n.getModuleManager().getJavaScriptModule(EventDispatcher.class) == null || Float.isNaN(bVar.getLayoutX()) || Float.isNaN(bVar.getLayoutY()) || Float.isNaN(bVar.getLayoutWidth()) || Float.isNaN(bVar.getLayoutHeight())) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushObject(HippyTKDListViewAdapter.X, Integer.valueOf((int) PixelUtil.px2dp(bVar.getLayoutX())));
        hippyMap.pushObject("y", Integer.valueOf((int) PixelUtil.px2dp(bVar.getLayoutY())));
        hippyMap.pushObject("width", Integer.valueOf((int) PixelUtil.px2dp(bVar.getLayoutWidth())));
        hippyMap.pushObject("height", Integer.valueOf((int) PixelUtil.px2dp(bVar.getLayoutHeight())));
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushMap(TtmlNode.TAG_LAYOUT, hippyMap);
        hippyMap2.pushInt("target", bVar.getId());
        ((EventDispatcher) this.f337237n.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(bVar.getId(), "onLayout", hippyMap2);
    }

    private void j(com.tencent.mtt.hippy.dom.node.b bVar) {
        int id5 = bVar.getId();
        if (this.f337236m.get(id5)) {
            return;
        }
        this.f337236m.put(id5, true);
        float layoutX = bVar.getLayoutX();
        float layoutY = bVar.getLayoutY();
        for (com.tencent.mtt.hippy.dom.node.b parent = bVar.getParent(); parent != null && parent.isJustLayout(); parent = parent.getParent()) {
            layoutX += parent.getLayoutX();
            layoutY += parent.getLayoutY();
        }
        a(bVar, layoutX, layoutY);
    }

    void a() {
        this.f337238o = true;
        com.tencent.mtt.hippy.dom.c cVar = this.f337227d;
        if (cVar != null) {
            cVar.b();
        }
        this.f337235l.a();
        this.f337237n.removeInstanceLifecycleEventListener(this);
        this.f337228e.clear();
        this.f337229f.clear();
        this.f337237n.removeEngineLifecycleEventListener(this);
        this.f337225b = false;
        if (UIThreadUtils.isOnUiThread()) {
            e.a().b(this.f337224a);
        } else {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.dom.b.8
                @Override // java.lang.Runnable
                public void run() {
                    e.a().b(b.this.f337224a);
                }
            });
        }
    }

    public void b() {
        this.f337237n.getThreadExecutor().postOnDomThread(new Runnable() { // from class: com.tencent.mtt.hippy.dom.b.9
            @Override // java.lang.Runnable
            public void run() {
                b.this.a();
            }
        });
    }

    public void c() {
        LogUtils.d("DomManager", "renderBatchStart");
        this.f337226c = true;
    }

    public void d(final int i3) {
        com.tencent.mtt.hippy.dom.node.b c16 = this.f337227d.c(i3);
        LogUtils.d("DomManager", "dom  deleteNode delete  node.getId() " + i3);
        if (c16 == null) {
            LogUtils.e("DomManager", "dom  deleteNode delete   node is null node.getId() " + i3);
            return;
        }
        if (c16.isJustLayout()) {
            g(c16);
        } else if (!c16.isVirtual()) {
            a(new g() { // from class: com.tencent.mtt.hippy.dom.b.15
                @Override // com.tencent.mtt.hippy.dom.g
                public void a() {
                    b.this.f337233j.b(i3);
                }
            });
        }
        com.tencent.mtt.hippy.dom.node.b parent = c16.getParent();
        if (parent != null) {
            parent.removeChildAt(parent.indexOf((FlexNode) c16));
        }
        c(c16);
    }

    void e(com.tencent.mtt.hippy.dom.node.b bVar) {
        if (bVar == null || !bVar.hasUpdates()) {
            return;
        }
        for (int i3 = 0; i3 < bVar.getChildCount(); i3++) {
            e(bVar.getChildAt(i3));
        }
        bVar.layoutAfter(this.f337237n);
    }

    private void c(g gVar) {
        if (this.f337238o) {
            return;
        }
        this.f337230g.add(gVar);
        if (this.f337225b) {
            return;
        }
        this.f337225b = true;
        if (UIThreadUtils.isOnUiThread()) {
            e.a().a(this.f337224a);
        } else {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.dom.b.3
                @Override // java.lang.Runnable
                public void run() {
                    e.a().a(b.this.f337224a);
                }
            });
        }
    }

    public void a(int i3) {
        if (this.f337237n.getInstance(i3) == null) {
            LogUtils.e("DomManager", "createRootNode  RootView Null error");
            return;
        }
        StyleNode styleNode = new StyleNode();
        styleNode.setId(i3);
        styleNode.setViewClassName(NodeProps.ROOT_NODE);
        styleNode.setStyleWidth(r0.getWidth());
        styleNode.setStyleHeight(r0.getHeight());
        a(styleNode);
        this.f337233j.a(i3);
    }

    public void b(int i3) {
        f(this.f337227d.c(i3));
        if (this.f337226c) {
            return;
        }
        g();
    }

    void d(com.tencent.mtt.hippy.dom.node.b bVar) {
        if (bVar == null || !bVar.hasUpdates()) {
            return;
        }
        for (int i3 = 0; i3 < bVar.getChildCount(); i3++) {
            d(bVar.getChildAt(i3));
        }
        bVar.layoutBefore(this.f337237n);
    }

    public void a(int i3, int i16, int i17) {
        StyleNode styleNode = new StyleNode();
        styleNode.setId(i3);
        styleNode.setViewClassName(NodeProps.ROOT_NODE);
        styleNode.setStyleWidth(i16);
        styleNode.setStyleHeight(i17);
        a(styleNode);
        this.f337233j.a(i3);
    }

    public void b(int i3, int i16, int i17) {
        com.tencent.mtt.hippy.dom.node.b c16 = this.f337227d.c(i3);
        if (c16 != null) {
            c16.setStyleWidth(i16);
            c16.setStyleHeight(i17);
            if (this.f337226c) {
                return;
            }
            g();
        }
    }

    void c(com.tencent.mtt.hippy.dom.node.b bVar) {
        if (this.f337234k != null) {
            Iterator<DomActionInterceptor> it = this.f337234k.iterator();
            while (it.hasNext()) {
                it.next().onDeleteNode(bVar.getId());
            }
        }
        int childCount = bVar.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            c(bVar.getChildAt(i3));
        }
        if (TextUtils.equals(NodeProps.ROOT_NODE, bVar.getViewClass())) {
            this.f337227d.b(bVar.getId());
        }
        this.f337227d.a(bVar.getId());
        LogUtils.d("DomManager", "dom deleteNode  remove form mNodeRegistry node.getId() " + bVar.getId());
    }

    private void b(g gVar) {
        if (this.f337226c) {
            this.f337229f.add(gVar);
            return;
        }
        synchronized (this.f337231h) {
            c(gVar);
        }
    }

    public void a(final int i3, final HippyMap hippyMap, HippyRootView hippyRootView) {
        com.tencent.mtt.hippy.dom.node.b c16 = this.f337227d.c(i3);
        if (c16 == null) {
            LogUtils.d("DomManager", "update error node is null id " + i3);
            return;
        }
        if (this.f337234k != null) {
            Iterator<DomActionInterceptor> it = this.f337234k.iterator();
            while (it.hasNext()) {
                hippyMap = it.next().onUpdateNode(i3, hippyRootView, hippyMap);
            }
        }
        boolean z16 = false;
        HippyMap diffProps = DiffUtils.diffProps(c16.getTotalProps(), hippyMap, 0);
        c16.setProps(hippyMap);
        this.f337232i.a((d) c16, diffProps);
        if (c16.isJustLayout() && (!b((HippyMap) hippyMap.get("style")) || a(hippyMap) || c(hippyMap))) {
            z16 = true;
        }
        if (z16) {
            a(c16, hippyMap, hippyRootView);
        } else {
            if (c16.isJustLayout() || c16.isVirtual()) {
                return;
            }
            a(new g() { // from class: com.tencent.mtt.hippy.dom.b.12
                @Override // com.tencent.mtt.hippy.dom.g
                public void a() {
                    b.this.f337233j.a(i3, hippyMap);
                }
            });
        }
    }

    public void c(boolean z16) {
        i();
        this.f337236m.clear();
        LogUtils.d("DomManager", "dom batch complete");
        synchronized (this.f337231h) {
            for (int i3 = 0; i3 < this.f337228e.size(); i3++) {
                c(this.f337228e.get(i3));
            }
            for (int i16 = 0; i16 < this.f337229f.size(); i16++) {
                c(this.f337229f.get(i16));
            }
        }
        this.f337229f.clear();
        this.f337228e.clear();
        a aVar = this.f337240q;
        if (aVar != null) {
            aVar.b(z16);
        }
    }

    private boolean c(HippyMap hippyMap) {
        if (hippyMap == null) {
            return false;
        }
        Iterator<String> it = hippyMap.keySet().iterator();
        while (it.hasNext()) {
            if (NodeProps.isTouchEventProp(it.next())) {
                return true;
            }
        }
        return false;
    }

    public void a(final int i3, final com.tencent.mtt.hippy.runtime.builtins.e eVar, final Promise promise) {
        b(new g() { // from class: com.tencent.mtt.hippy.dom.b.7
            @Override // com.tencent.mtt.hippy.dom.g
            public void a() {
                b.this.f337233j.a(i3, eVar, promise);
            }
        });
    }

    public void b(DomActionInterceptor domActionInterceptor) {
        if (this.f337234k != null) {
            this.f337234k.remove(domActionInterceptor);
        }
    }

    public void a(final int i3, final String str, final HippyArray hippyArray, final Promise promise) {
        b(new g() { // from class: com.tencent.mtt.hippy.dom.b.6
            @Override // com.tencent.mtt.hippy.dom.g
            public void a() {
                b.this.f337233j.a(i3, str, hippyArray, promise);
            }
        });
    }

    public void b(boolean z16) {
        if (!z16) {
            d();
            return;
        }
        this.f337226c = false;
        i();
        this.f337236m.clear();
        synchronized (this.f337231h) {
            if (this.f337238o) {
                return;
            }
            for (int i3 = 0; i3 < this.f337228e.size(); i3++) {
                this.f337230g.add(this.f337228e.get(i3));
            }
            for (int i16 = 0; i16 < this.f337229f.size(); i16++) {
                this.f337230g.add(this.f337229f.get(i16));
            }
            this.f337229f.clear();
            this.f337228e.clear();
        }
    }

    private static boolean b(HippyMap hippyMap) {
        if (hippyMap == null) {
            return true;
        }
        if (a(hippyMap)) {
            return false;
        }
        Iterator<String> it = hippyMap.keySet().iterator();
        while (it.hasNext()) {
            if (!NodeProps.isJustLayout(hippyMap, it.next())) {
                return false;
            }
        }
        return true;
    }

    public void a(Layout layout) {
        i iVar = this.f337235l;
        if (iVar != null) {
            iVar.a(layout);
        }
    }

    public void a(final HippyRootView hippyRootView, int i3, final int i16, int i17, int i18, final String str, String str2, HippyMap hippyMap) {
        HippyMap hippyMap2;
        int i19 = i18;
        com.tencent.mtt.hippy.dom.node.b c16 = this.f337227d.c(i17);
        if (c16 == null) {
            LogUtils.d("DomManager", "Create Node DomManager Parent IS Null");
            return;
        }
        if (this.f337234k != null) {
            Iterator<DomActionInterceptor> it = this.f337234k.iterator();
            HippyMap hippyMap3 = hippyMap;
            while (it.hasNext()) {
                hippyMap3 = it.next().onCreateNode(i16, hippyRootView, hippyMap3);
            }
            hippyMap2 = hippyMap3;
        } else {
            hippyMap2 = hippyMap;
        }
        boolean equals = TextUtils.equals(c16.getViewClass(), "Text");
        com.tencent.mtt.hippy.dom.node.b a16 = this.f337237n.getRenderManager().a(str, equals, i16, hippyRootView.getId());
        a16.setLazy(c16.isLazy() || this.f337237n.getRenderManager().getControllerManager().a(str));
        a16.setProps(hippyMap2);
        a16.setDomNodeRecord(new com.tencent.mtt.hippy.dom.node.a(i3, i16, i17, i18, str, str2, hippyMap2));
        boolean z16 = "View".equals(a16.getViewClass()) && b((HippyMap) hippyMap2.get("style")) && !a(hippyMap2) && !c(hippyMap2);
        LogUtils.d("DomManager", "dom create node id: " + i16 + " mClassName " + str + " pid " + i17 + " mIndex:" + i19 + " isJustLayout :" + z16 + " isVirtual " + equals);
        a16.updateProps(hippyMap2);
        this.f337232i.a((d) a16, hippyMap2);
        if (i19 > c16.getChildCount()) {
            int childCount = c16.getChildCount();
            LogUtils.d("DomManager", "createNode  addChild  error index > parent.size");
            i19 = childCount;
        }
        c16.addChildAt((FlexNode) a16, i19);
        this.f337227d.b(a16);
        a16.setIsJustLayout(z16);
        if (z16 || a16.isVirtual()) {
            return;
        }
        final com.tencent.mtt.hippy.dom.node.b b16 = b(a16);
        final c a17 = a(b16, a16, 0);
        if (!a16.isLazy() && i16 >= 0) {
            synchronized (this.f337231h) {
                final HippyMap hippyMap4 = hippyMap2;
                c(new g() { // from class: com.tencent.mtt.hippy.dom.b.10
                    @Override // com.tencent.mtt.hippy.dom.g
                    public void a() {
                        b.this.f337233j.b(hippyRootView, i16, b16.getId(), a17.f337295b, str, hippyMap4);
                    }
                });
            }
        }
        final HippyMap hippyMap5 = hippyMap2;
        a(new g() { // from class: com.tencent.mtt.hippy.dom.b.11
            @Override // com.tencent.mtt.hippy.dom.g
            public void a() {
                b.this.f337233j.a(hippyRootView, i16, b16.getId(), a17.f337295b, str, hippyMap5);
            }
        });
    }

    public void a(a aVar) {
        this.f337240q = aVar;
    }

    private void a(g gVar) {
        this.f337228e.add(gVar);
    }

    public void a(DomActionInterceptor domActionInterceptor) {
        if (this.f337234k == null) {
            synchronized (b.class) {
                if (this.f337234k == null) {
                    this.f337234k = new CopyOnWriteArrayList<>();
                }
            }
        }
        this.f337234k.add(domActionInterceptor);
    }

    public void a(com.tencent.mtt.hippy.dom.node.b bVar) {
        this.f337227d.a(bVar);
    }

    private void a(final com.tencent.mtt.hippy.dom.node.b bVar, final float f16, final float f17) {
        if (!bVar.isJustLayout() && !bVar.isVirtual()) {
            if (bVar.shouldUpdateLayout(f16, f17)) {
                a(new g() { // from class: com.tencent.mtt.hippy.dom.b.5
                    @Override // com.tencent.mtt.hippy.dom.g
                    public void a() {
                        int round = Math.round(f16);
                        int round2 = Math.round(f17);
                        b.this.f337233j.a(bVar.getId(), round, round2, Math.round(f16 + bVar.getLayoutWidth()) - round, Math.round(f17 + bVar.getLayoutHeight()) - round2);
                    }
                });
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < bVar.getChildCount(); i3++) {
            com.tencent.mtt.hippy.dom.node.b childAt = bVar.getChildAt(i3);
            int id5 = childAt.getId();
            if (!this.f337236m.get(id5)) {
                this.f337236m.put(id5, true);
                a(childAt, childAt.getLayoutX() + f16, childAt.getLayoutY() + f17);
            }
        }
    }

    private void a(final com.tencent.mtt.hippy.dom.node.b bVar, final HippyMap hippyMap, final HippyRootView hippyRootView) {
        final com.tencent.mtt.hippy.dom.node.b b16 = b(bVar);
        final c a16 = a(b16, bVar, 0);
        if (!bVar.isVirtual()) {
            a(new g() { // from class: com.tencent.mtt.hippy.dom.b.13
                @Override // com.tencent.mtt.hippy.dom.g
                public void a() {
                    b.this.f337233j.a(hippyRootView, bVar.getId(), b16.getId(), a16.f337295b, bVar.getViewClass(), hippyMap);
                }
            });
        }
        final ArrayList<Integer> arrayList = new ArrayList<>();
        bVar.markUpdated();
        a(bVar, arrayList);
        bVar.setIsJustLayout(false);
        if (!bVar.isVirtual()) {
            a(new g() { // from class: com.tencent.mtt.hippy.dom.b.14
                @Override // com.tencent.mtt.hippy.dom.g
                public void a() {
                    b.this.f337233j.a(arrayList, b16.getId(), bVar.getId());
                }
            });
        }
        h(bVar);
        this.f337236m.clear();
    }

    private void a(com.tencent.mtt.hippy.dom.node.b bVar, ArrayList<Integer> arrayList) {
        for (int i3 = 0; i3 < bVar.getChildCount(); i3++) {
            com.tencent.mtt.hippy.dom.node.b childAt = bVar.getChildAt(i3);
            if (childAt.isJustLayout()) {
                a(childAt, arrayList);
            } else {
                childAt.markUpdated();
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
    }

    public void a(boolean z16) {
        this.f337226c = false;
        if (z16) {
            this.f337229f.clear();
            this.f337228e.clear();
        }
    }

    private static boolean a(HippyMap hippyMap) {
        return (hippyMap == null || hippyMap.get(NodeProps.COLLAPSABLE) == null || ((Boolean) hippyMap.get(NodeProps.COLLAPSABLE)).booleanValue()) ? false : true;
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstanceDestroy(int i3) {
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstancePause(int i3) {
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstanceResume(int i3) {
    }
}
