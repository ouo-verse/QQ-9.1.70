package com.tencent.aio.widget.textView.creator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aio.widget.textView.creator.f;
import com.tencent.aio.widget.textView.creator.g;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J(\u0010\u001d\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J2\u0010(\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\rH\u0016J\u001e\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010!\u001a\u00020)J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\rH\u0016J\u0012\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010.\u001a\u00020\u0007H\u0016J\u0014\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020/01H\u0016J\b\u00104\u001a\u000203H\u0016R\u0014\u00106\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u00105R\"\u0010=\u001a\u0002078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b,\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010?R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010?R\u0016\u0010B\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010?R&\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010DR \u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010DR,\u0010I\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0G0\n0C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010DR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00070J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006T"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/LayoutCreatorManager;", "Lcom/tencent/aio/widget/textView/creator/b;", "Lcom/tencent/aio/widget/textView/creator/g;", "Landroid/text/StaticLayout;", TtmlNode.TAG_LAYOUT, "", "v", "Lcom/tencent/aio/widget/textView/param/b;", "param", "p", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/aio/widget/textView/creator/g$b;", "r", "", "observerId", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "drawables", "loadDrawableAsyncTaskId", "o", "Lcom/tencent/aio/widget/textView/api/d;", "dispatcher", "t", "Landroid/content/Context;", "context", "Landroid/text/TextPaint;", "paint", "complete", "a", "d", DomainData.DOMAIN_NAME, "", "text", "Landroid/graphics/drawable/Drawable$Callback;", "drawableCallback", "Lcom/tencent/aio/widget/textView/creator/g$a;", "Lcom/tencent/aio/widget/textView/view/a;", TtmlNode.TAG_SPAN, MiniAppGetGameTaskTicketServlet.KEY_TASKID, "c", "Landroid/text/Spanned;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "observer", "b", "g", "aioStaticParam", "Lcom/tencent/aio/widget/textView/cache/a;", "f", "Lcom/tencent/aio/widget/textView/creator/c;", "u", "Lcom/tencent/aio/widget/textView/creator/f$a;", "e", "I", "MAX_DRAWABLE_OBSERVER_SIZE", "Lcom/tencent/aio/widget/textView/creator/a;", "Lcom/tencent/aio/widget/textView/creator/a;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/aio/widget/textView/creator/a;", "w", "(Lcom/tencent/aio/widget/textView/creator/a;)V", "suiteCreator", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/Executor;", "createTaskEngine", "getDrawableExecutor", "mainExecutor", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "observers", "observerTags", "Ljava/lang/ref/WeakReference;", h.F, "drawableObserver", "Ljava/util/concurrent/CopyOnWriteArrayList;", "i", "Ljava/util/concurrent/CopyOnWriteArrayList;", "runningTasks", "Landroid/graphics/Canvas;", "j", "Landroid/graphics/Canvas;", "dummyCanvas", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class LayoutCreatorManager implements b, g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final int MAX_DRAWABLE_OBSERVER_SIZE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static a suiteCreator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Executor createTaskEngine;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static Executor getDrawableExecutor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static Executor mainExecutor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<com.tencent.aio.widget.textView.param.b, CopyOnWriteArraySet<g.b>> observers;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<g.b, com.tencent.aio.widget.textView.param.b> observerTags;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Integer, CopyOnWriteArraySet<WeakReference<g.a>>> drawableObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<com.tencent.aio.widget.textView.param.b> runningTasks;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final Canvas dummyCanvas;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final LayoutCreatorManager f70013k;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9821);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        f70013k = new LayoutCreatorManager();
        MAX_DRAWABLE_OBSERVER_SIZE = 60;
        observers = new ConcurrentHashMap<>();
        observerTags = new ConcurrentHashMap<>();
        drawableObserver = new ConcurrentHashMap<>();
        runningTasks = new CopyOnWriteArrayList<>();
        dummyCanvas = new Canvas(Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565));
    }

    LayoutCreatorManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int observerId, final ArrayList<Drawable> drawables, final int loadDrawableAsyncTaskId) {
        CopyOnWriteArraySet<WeakReference<g.a>> copyOnWriteArraySet = drawableObserver.get(Integer.valueOf(observerId));
        if (copyOnWriteArraySet != null) {
            Iterator<T> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                final WeakReference weakReference = (WeakReference) it.next();
                Executor executor = mainExecutor;
                if (executor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainExecutor");
                }
                executor.execute(new Runnable(weakReference, drawables, loadDrawableAsyncTaskId) { // from class: com.tencent.aio.widget.textView.creator.LayoutCreatorManager$dispatchDrawableObservers$$inlined$forEach$lambda$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ WeakReference f70014d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ ArrayList f70015e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f70016f;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f70014d = weakReference;
                        this.f70015e = drawables;
                        this.f70016f = loadDrawableAsyncTaskId;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, weakReference, drawables, Integer.valueOf(loadDrawableAsyncTaskId));
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        g.a aVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        WeakReference weakReference2 = this.f70014d;
                        if (weakReference2 != null && (aVar = (g.a) weakReference2.get()) != null) {
                            aVar.b(this.f70015e, this.f70016f);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(final com.tencent.aio.widget.textView.param.b param, final StaticLayout layout) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        CopyOnWriteArraySet<g.b> copyOnWriteArraySet = observers.get(param);
        if (copyOnWriteArraySet != null) {
            for (final g.b bVar : copyOnWriteArraySet) {
                booleanRef.element = true;
                Executor executor = mainExecutor;
                if (executor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainExecutor");
                }
                executor.execute(new Runnable(booleanRef, param, layout) { // from class: com.tencent.aio.widget.textView.creator.LayoutCreatorManager$dispatchObservers$$inlined$forEach$lambda$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Ref.BooleanRef f70018e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ com.tencent.aio.widget.textView.param.b f70019f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ StaticLayout f70020h;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f70018e = booleanRef;
                        this.f70019f = param;
                        this.f70020h = layout;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, g.b.this, booleanRef, param, layout);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        g.b bVar2 = g.b.this;
                        Intrinsics.checkNotNull(bVar2);
                        bVar2.a(this.f70019f, this.f70020h);
                    }
                });
            }
        }
        com.tencent.aio.widget.textView.log.a.f70035a.a("LayoutCreatorManager", "consume " + booleanRef.element);
        if (!booleanRef.element) {
            v(layout);
        }
    }

    private final CopyOnWriteArraySet<g.b> r(com.tencent.aio.widget.textView.param.b param) {
        ConcurrentHashMap<com.tencent.aio.widget.textView.param.b, CopyOnWriteArraySet<g.b>> concurrentHashMap = observers;
        CopyOnWriteArraySet<g.b> copyOnWriteArraySet = concurrentHashMap.get(param);
        if (copyOnWriteArraySet == null) {
            CopyOnWriteArraySet<g.b> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
            concurrentHashMap.put(param, copyOnWriteArraySet2);
            return copyOnWriteArraySet2;
        }
        return copyOnWriteArraySet;
    }

    private final void v(StaticLayout layout) {
        long currentTimeMillis = System.currentTimeMillis();
        layout.draw(dummyCanvas);
        com.tencent.aio.widget.textView.log.a.f70035a.a("LayoutCreatorManager", "preDraw " + layout + " spend " + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.aio.widget.textView.creator.g
    public void a(@NotNull final com.tencent.aio.widget.textView.param.b param, @NotNull final Context context, @NotNull final TextPaint paint, @NotNull final g.b complete) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, param, context, paint, complete);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(complete, "complete");
        ConcurrentHashMap<g.b, com.tencent.aio.widget.textView.param.b> concurrentHashMap = observerTags;
        com.tencent.aio.widget.textView.param.b bVar = concurrentHashMap.get(complete);
        if (bVar != null && bVar.hashCode() != param.hashCode()) {
            CopyOnWriteArraySet<g.b> copyOnWriteArraySet = observers.get(param);
            if (copyOnWriteArraySet != null) {
                copyOnWriteArraySet.remove(complete);
            }
            concurrentHashMap.put(complete, param);
        }
        r(param).add(complete);
        CopyOnWriteArrayList<com.tencent.aio.widget.textView.param.b> copyOnWriteArrayList = runningTasks;
        if (copyOnWriteArrayList.contains(param)) {
            com.tencent.aio.widget.textView.log.a.f70035a.a("LayoutCreatorManager", param + " task is Running ");
            return;
        }
        copyOnWriteArrayList.add(param);
        Executor executor = createTaskEngine;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createTaskEngine");
        }
        executor.execute(new Runnable(context, paint, param, complete) { // from class: com.tencent.aio.widget.textView.creator.LayoutCreatorManager$createStaticLayout$2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f70021d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ TextPaint f70022e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.tencent.aio.widget.textView.param.b f70023f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ g.b f70024h;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f70021d = context;
                this.f70022e = paint;
                this.f70023f = param;
                this.f70024h = complete;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, context, paint, param, complete);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                ConcurrentHashMap concurrentHashMap2;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                ConcurrentHashMap concurrentHashMap3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                LayoutCreatorManager layoutCreatorManager = LayoutCreatorManager.f70013k;
                StaticLayout d16 = layoutCreatorManager.s().d(this.f70021d, this.f70022e, this.f70023f);
                com.tencent.aio.widget.textView.log.a aVar = com.tencent.aio.widget.textView.log.a.f70035a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("threadName ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb5.append(currentThread.getName());
                sb5.append(" layout ");
                sb5.append(d16);
                aVar.a("LayoutCreatorManager", sb5.toString());
                layoutCreatorManager.p(this.f70023f, d16);
                layoutCreatorManager.n(this.f70023f, d16);
                concurrentHashMap2 = LayoutCreatorManager.observers;
                concurrentHashMap2.remove(this.f70023f);
                copyOnWriteArrayList2 = LayoutCreatorManager.runningTasks;
                copyOnWriteArrayList2.remove(this.f70023f);
                concurrentHashMap3 = LayoutCreatorManager.observerTags;
                concurrentHashMap3.remove(this.f70024h);
            }
        });
    }

    @Override // com.tencent.aio.widget.textView.creator.g
    public void b(@NotNull g.b observer) {
        CopyOnWriteArraySet<g.b> copyOnWriteArraySet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        com.tencent.aio.widget.textView.param.b remove = observerTags.remove(observer);
        if (remove != null && (copyOnWriteArraySet = observers.get(remove)) != null) {
            copyOnWriteArraySet.remove(observer);
        }
    }

    @Override // com.tencent.aio.widget.textView.creator.g
    public void c(@NotNull CharSequence text, @NotNull final Drawable.Callback drawableCallback, @NotNull g.a complete, @Nullable final com.tencent.aio.widget.textView.view.a span, final int taskId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, text, drawableCallback, complete, span, Integer.valueOf(taskId));
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(drawableCallback, "drawableCallback");
        Intrinsics.checkNotNullParameter(complete, "complete");
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        final int hashCode = complete.hashCode();
        ConcurrentHashMap<Integer, CopyOnWriteArraySet<WeakReference<g.a>>> concurrentHashMap = drawableObserver;
        CopyOnWriteArraySet<WeakReference<g.a>> copyOnWriteArraySet = concurrentHashMap.get(Integer.valueOf(hashCode));
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
            concurrentHashMap.put(Integer.valueOf(hashCode), copyOnWriteArraySet);
        }
        copyOnWriteArraySet.add(new WeakReference<>(complete));
        Executor executor = getDrawableExecutor;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getDrawableExecutor");
        }
        executor.execute(new Runnable(spannableStringBuilder, span, drawableCallback, hashCode, taskId) { // from class: com.tencent.aio.widget.textView.creator.LayoutCreatorManager$loadImageDrawableAsync$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ SpannableStringBuilder f70025d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.aio.widget.textView.view.a f70026e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Drawable.Callback f70027f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f70028h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f70029i;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f70025d = spannableStringBuilder;
                this.f70026e = span;
                this.f70027f = drawableCallback;
                this.f70028h = hashCode;
                this.f70029i = taskId;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, spannableStringBuilder, span, drawableCallback, Integer.valueOf(hashCode), Integer.valueOf(taskId));
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                ConcurrentHashMap concurrentHashMap2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(LayoutCreatorManager.f70013k.q(this.f70025d));
                    com.tencent.aio.widget.textView.view.a aVar = this.f70026e;
                    if (aVar != null) {
                        arrayList.addAll(aVar.a(this.f70025d));
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Drawable drawable = (Drawable) it.next();
                        if (drawable != null) {
                            drawable.setCallback(this.f70027f);
                        }
                    }
                    LayoutCreatorManager.f70013k.o(this.f70028h, arrayList, this.f70029i);
                    concurrentHashMap2 = LayoutCreatorManager.drawableObserver;
                    concurrentHashMap2.remove(Integer.valueOf(this.f70028h));
                } catch (Exception e16) {
                    com.tencent.aio.widget.textView.log.a.f70035a.b("LayoutCreatorManager", "loadImageDrawableAsync exception: " + e16.getMessage());
                }
            }
        });
    }

    @Override // com.tencent.aio.widget.textView.creator.g
    @NotNull
    public StaticLayout d(@NotNull com.tencent.aio.widget.textView.param.b param, @NotNull Context context, @NotNull TextPaint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (StaticLayout) iPatchRedirector.redirect((short) 5, this, param, context, paint);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paint, "paint");
        a aVar = suiteCreator;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suiteCreator");
        }
        StaticLayout d16 = aVar.d(context, paint, param);
        n(param, d16);
        return d16;
    }

    @Override // com.tencent.aio.widget.textView.creator.f
    @NotNull
    public f.a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (f.a) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return com.tencent.aio.widget.textView.cache.c.f70002b;
    }

    @Override // com.tencent.aio.widget.textView.creator.g
    @Nullable
    public com.tencent.aio.widget.textView.cache.a f(@NotNull com.tencent.aio.widget.textView.param.b aioStaticParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.aio.widget.textView.cache.a) iPatchRedirector.redirect((short) 11, (Object) this, (Object) aioStaticParam);
        }
        Intrinsics.checkNotNullParameter(aioStaticParam, "aioStaticParam");
        return u().get(aioStaticParam);
    }

    @Override // com.tencent.aio.widget.textView.creator.g
    public void g(int taskId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, taskId);
            return;
        }
        try {
            ConcurrentHashMap<Integer, CopyOnWriteArraySet<WeakReference<g.a>>> concurrentHashMap = drawableObserver;
            concurrentHashMap.remove(Integer.valueOf(taskId));
            if (concurrentHashMap.size() > MAX_DRAWABLE_OBSERVER_SIZE) {
                concurrentHashMap.clear();
            }
        } catch (Exception e16) {
            com.tencent.aio.widget.textView.log.a.f70035a.b("LayoutCreatorManager", "removeDrawableObservers exception: " + e16.getMessage());
        }
    }

    public final void n(@NotNull com.tencent.aio.widget.textView.param.b param, @NotNull StaticLayout layout) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) param, (Object) layout);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (TextUtils.isEmpty(param.i())) {
            com.tencent.aio.widget.textView.log.a.f70035a.a("BaseStaticLayoutCreator", "key \u4e3a \u7a7a\uff0c\u4e0d\u7f13\u5b58");
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            u().put(param, new com.tencent.aio.widget.textView.cache.a(layout, param.h()));
        }
    }

    @NotNull
    public final synchronized ArrayList<Drawable> q(@NotNull Spanned text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this, (Object) text);
        }
        Intrinsics.checkNotNullParameter(text, "text");
        DynamicDrawableSpan[] dynamicSpans = (DynamicDrawableSpan[]) text.getSpans(0, text.length(), DynamicDrawableSpan.class);
        ArrayList<Drawable> arrayList = new ArrayList<>();
        Intrinsics.checkNotNullExpressionValue(dynamicSpans, "dynamicSpans");
        for (DynamicDrawableSpan img : dynamicSpans) {
            Intrinsics.checkNotNullExpressionValue(img, "img");
            if (img.getDrawable() != null) {
                arrayList.add(img.getDrawable());
            }
        }
        return arrayList;
    }

    @NotNull
    public final a s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (a) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        a aVar = suiteCreator;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suiteCreator");
        }
        return aVar;
    }

    @NotNull
    public final LayoutCreatorManager t(@NotNull com.tencent.aio.widget.textView.api.d dispatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LayoutCreatorManager) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dispatcher);
        }
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        createTaskEngine = dispatcher.c();
        getDrawableExecutor = dispatcher.a();
        mainExecutor = dispatcher.b();
        return this;
    }

    @NotNull
    public c<com.tencent.aio.widget.textView.param.b, com.tencent.aio.widget.textView.cache.a> u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (c) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return com.tencent.aio.widget.textView.cache.b.f70000b;
    }

    public final void w(@NotNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            suiteCreator = aVar;
        }
    }
}
