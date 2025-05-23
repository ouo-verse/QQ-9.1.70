package com.tencent.biz.qqcircle.widgets.sheet;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00031\u000e2B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,B\u001b\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b+\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J0\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0014J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0018\u0010(\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010'\u00a8\u00063"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "state", "", "t", "r", "", "changed", "l", "b", "onLayout", "Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView$c;", DownloadInfo.spKey_Config, "setConfig", "Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView$b;", "listener", "setStateListener", ReportConstant.COSTREPORT_PREFIX, "u", "v", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "d", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, "e", "Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView$c;", "f", "Z", "mFirstInit", h.F, "mWaitShowDefault", "i", "mWaitShowMax", "Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView$b;", "mStateListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSCommonBottomSheetView extends CoordinatorLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BottomSheetBehavior<View> behavior;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private c config;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mFirstInit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mWaitShowDefault;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mWaitShowMax;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mStateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0017J\b\u0010\u0004\u001a\u00020\u0002H\u0017J\b\u0010\u0005\u001a\u00020\u0002H\u0017J\b\u0010\u0006\u001a\u00020\u0002H\u0017J\b\u0010\u0007\u001a\u00020\u0002H\u0017J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0017\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView$b;", "", "", "d", "c", "e", "b", "a", "", "height", "f", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public interface b {
        @JvmDefault
        void a();

        @JvmDefault
        void b();

        @JvmDefault
        void c();

        @JvmDefault
        void d();

        @JvmDefault
        void e();

        @JvmDefault
        void f(float height);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0017J\b\u0010\u0004\u001a\u00020\u0002H\u0017J\b\u0010\u0006\u001a\u00020\u0005H\u0017J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J\b\u0010\t\u001a\u00020\u0005H\u0017\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView$c;", "", "", "c", "getMaxHeight", "", "b", "Landroid/view/View;", "getContentView", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public interface c {
        @JvmDefault
        boolean a();

        @JvmDefault
        boolean b();

        @JvmDefault
        int c();

        @JvmDefault
        @Nullable
        View getContentView();

        @JvmDefault
        int getMaxHeight();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView$d", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "p0", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class d extends BottomSheetBehavior.e {
        d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View p06, float slideOffset) {
            int measuredHeight;
            Intrinsics.checkNotNullParameter(p06, "p0");
            b bVar = QFSCommonBottomSheetView.this.mStateListener;
            if (bVar != null) {
                QFSCommonBottomSheetView qFSCommonBottomSheetView = QFSCommonBottomSheetView.this;
                c cVar = null;
                if (slideOffset <= 0.0f) {
                    c cVar2 = qFSCommonBottomSheetView.config;
                    if (cVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        cVar2 = null;
                    }
                    float c16 = cVar2.c() * (1 + slideOffset);
                    Log.d("QFSCommonBottomSheetView", "onSlide: height: " + c16);
                    bVar.f(c16);
                }
                c cVar3 = qFSCommonBottomSheetView.config;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    cVar3 = null;
                }
                if (cVar3.b() && slideOffset >= 0.0f) {
                    c cVar4 = qFSCommonBottomSheetView.config;
                    if (cVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        cVar4 = null;
                    }
                    if (cVar4.getMaxHeight() != -1) {
                        c cVar5 = qFSCommonBottomSheetView.config;
                        if (cVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                            cVar5 = null;
                        }
                        measuredHeight = cVar5.getMaxHeight();
                    } else {
                        measuredHeight = qFSCommonBottomSheetView.getMeasuredHeight();
                    }
                    c cVar6 = qFSCommonBottomSheetView.config;
                    if (cVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    } else {
                        cVar = cVar6;
                    }
                    float c17 = cVar.c() + (slideOffset * measuredHeight);
                    Log.d("QFSCommonBottomSheetView", "onSlide: height: " + c17);
                    bVar.f(c17);
                }
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View p06, int newState) {
            b bVar;
            b bVar2;
            Intrinsics.checkNotNullParameter(p06, "p0");
            Log.d("QFSCommonBottomSheetView", "onStateChanged: newState: " + QFSCommonBottomSheetView.this.t(newState));
            if (newState == 5) {
                QFSCommonBottomSheetView.this.setVisibility(8);
                b bVar3 = QFSCommonBottomSheetView.this.mStateListener;
                if (bVar3 != null) {
                    bVar3.a();
                }
            }
            if (newState == 4 && (bVar2 = QFSCommonBottomSheetView.this.mStateListener) != null) {
                bVar2.c();
            }
            if (newState == 3 && (bVar = QFSCommonBottomSheetView.this.mStateListener) != null) {
                bVar.b();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView$e", "Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView$c;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class e implements c {
        e() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.c
        public /* synthetic */ boolean a() {
            return sc0.d.c(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.c
        public /* synthetic */ boolean b() {
            return sc0.d.d(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.c
        public /* synthetic */ int c() {
            return sc0.d.b(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.c
        public /* synthetic */ View getContentView() {
            return sc0.d.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.c
        public /* synthetic */ int getMaxHeight() {
            return sc0.d.e(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSCommonBottomSheetView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void m() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.behavior;
        c cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        bottomSheetBehavior.setPeekHeight(cVar.c());
        this.behavior.setState(5);
        this.behavior.setHideable(true);
        this.behavior.addBottomSheetCallback(new d());
    }

    private final void n() {
        int c16;
        Log.d("QFSCommonBottomSheetView", "initContentView: ");
        View frameLayout = new FrameLayout(getContext());
        addView(frameLayout, -1, -1);
        c cVar = this.config;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        if (cVar.a()) {
            frameLayout.setBackgroundColor(Color.parseColor("#80000000"));
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: sc0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSCommonBottomSheetView.o(QFSCommonBottomSheetView.this, view);
            }
        });
        c cVar3 = this.config;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar3 = null;
        }
        View contentView = cVar3.getContentView();
        if (contentView != null) {
            c cVar4 = this.config;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                cVar4 = null;
            }
            if (cVar4.b()) {
                c cVar5 = this.config;
                if (cVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                } else {
                    cVar2 = cVar5;
                }
                c16 = cVar2.getMaxHeight();
            } else {
                c cVar6 = this.config;
                if (cVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                } else {
                    cVar2 = cVar6;
                }
                c16 = cVar2.c();
            }
            CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, c16);
            m();
            layoutParams.setBehavior(this.behavior);
            addView(contentView, layoutParams);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: sc0.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSCommonBottomSheetView.p(view);
                }
            });
        }
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QFSCommonBottomSheetView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q() {
        this.config = new e();
    }

    private final void r() {
        int c16;
        c cVar = this.config;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        if (cVar.c() != -2 && this.behavior.getPeekHeight() != 0) {
            int peekHeight = this.behavior.getPeekHeight();
            c cVar3 = this.config;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                cVar3 = null;
            }
            if (peekHeight != cVar3.c()) {
                BottomSheetBehavior<View> bottomSheetBehavior = this.behavior;
                c cVar4 = this.config;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    cVar4 = null;
                }
                bottomSheetBehavior.setPeekHeight(cVar4.c());
                c cVar5 = this.config;
                if (cVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    cVar5 = null;
                }
                View contentView = cVar5.getContentView();
                if (contentView != null && contentView.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
                    c cVar6 = this.config;
                    if (cVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        cVar6 = null;
                    }
                    if (cVar6.b()) {
                        c cVar7 = this.config;
                        if (cVar7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        } else {
                            cVar2 = cVar7;
                        }
                        c16 = cVar2.getMaxHeight();
                    } else {
                        c cVar8 = this.config;
                        if (cVar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        } else {
                            cVar2 = cVar8;
                        }
                        c16 = cVar2.c();
                    }
                    layoutParams.height = c16;
                    return;
                }
                return;
            }
            return;
        }
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.behavior;
        c cVar9 = this.config;
        if (cVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        } else {
            cVar2 = cVar9;
        }
        View contentView2 = cVar2.getContentView();
        if (contentView2 != null) {
            bottomSheetBehavior2.setPeekHeight(contentView2.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String t(int state) {
        if (state != 1) {
            if (state != 2) {
                if (state != 3) {
                    if (state != 4) {
                        if (state != 5) {
                            return "state_unknown";
                        }
                        return "state_hidden";
                    }
                    return "state_collapsed";
                }
                return "state_expanded";
            }
            return "state_settling";
        }
        return "state_dragging";
    }

    public final void l() {
        this.behavior.setState(5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        super.onLayout(changed, l3, t16, r16, b16);
        r();
        if (this.mWaitShowDefault) {
            com.tencent.xaction.log.b.a("QFSCommonBottomSheetView", 1, "onLayout: waitShowDefault");
            this.mWaitShowDefault = false;
            this.mFirstInit = false;
            u();
        }
        if (this.mWaitShowMax) {
            com.tencent.xaction.log.b.a("QFSCommonBottomSheetView", 1, "onLayout: waitShowMax");
            this.mWaitShowMax = false;
            this.mFirstInit = false;
            v();
        }
    }

    public final boolean s() {
        if (this.behavior.getState() != 3 && this.behavior.getState() != 4) {
            return false;
        }
        return true;
    }

    public final void setConfig(@NotNull c config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        n();
    }

    public final void setStateListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mStateListener = listener;
    }

    public final void u() {
        r();
        if (this.mFirstInit) {
            Log.d("QFSCommonBottomSheetView", "showDefault: first Init");
            this.mWaitShowDefault = true;
            setVisibility(0);
            this.behavior.setState(5);
            return;
        }
        setVisibility(0);
        Log.d("QFSCommonBottomSheetView", "showDefault");
        this.behavior.setState(4);
        b bVar = this.mStateListener;
        if (bVar != null) {
            bVar.d();
        }
    }

    public final void v() {
        c cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        if (!cVar.b()) {
            return;
        }
        r();
        if (this.mFirstInit) {
            Log.d("QFSCommonBottomSheetView", "showDefault: first Init");
            this.mWaitShowMax = true;
            setVisibility(0);
            this.behavior.setState(5);
            return;
        }
        setVisibility(0);
        this.behavior.setState(3);
        b bVar = this.mStateListener;
        if (bVar != null) {
            bVar.e();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSCommonBottomSheetView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.behavior = new BottomSheetBehavior<>();
        this.mFirstInit = true;
        q();
    }
}
