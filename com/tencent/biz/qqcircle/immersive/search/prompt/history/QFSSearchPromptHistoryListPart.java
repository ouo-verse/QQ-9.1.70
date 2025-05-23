package com.tencent.biz.qqcircle.immersive.search.prompt.history;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSSearchHistoryItemInfo;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.search.prompt.history.QFSSearchPromptHistoryListAdapter;
import com.tencent.biz.qqcircle.manager.k;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryListPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/qqcircle/manager/k$a;", "", "F9", "D9", "G9", "B9", "C9", "E9", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "onPartDestroy", "", "Lcom/tencent/biz/qqcircle/beans/QFSSearchHistoryItemInfo;", "historyList", "a", "", "getLogTag", "Lcom/google/android/material/appbar/AppBarLayout;", "d", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "historyRootView", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryListAdapter;", tl.h.F, "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryListAdapter;", "historyAdapter", "", "i", "Z", "isExpand", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptHistoryListPart extends u implements k.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AppBarLayout appBarLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup historyRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSSearchPromptHistoryListAdapter historyAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isExpand;
    private static final int C = com.tencent.qqnt.base.utils.c.f353052a.b(16);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f89926a;

        static {
            int[] iArr = new int[QFSSearchPromptHistoryListAdapter.State.values().length];
            try {
                iArr[QFSSearchPromptHistoryListAdapter.State.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QFSSearchPromptHistoryListAdapter.State.COLLAPSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f89926a = iArr;
        }
    }

    private final void B9() {
        this.isExpand = false;
        com.tencent.biz.qqcircle.manager.k.d().b();
    }

    private final void C9() {
        List<QFSSearchHistoryItemInfo> infos = com.tencent.biz.qqcircle.manager.k.d().j();
        if (!infos.isEmpty() && this.historyRootView != null) {
            StringBuilder sb5 = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(infos, "infos");
            Iterator<T> it = infos.iterator();
            while (it.hasNext()) {
                sb5.append(((QFSSearchHistoryItemInfo) it.next()).searchHistoryWord);
                sb5.append(",");
            }
            HashMap hashMap = new HashMap();
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            hashMap.put("xsj_query_text", sb6);
            ua0.i.k(this.historyRootView, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_HISTORY_CONTENT, hashMap, infos.hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9() {
        if (this.isExpand) {
            G9();
            return;
        }
        this.isExpand = true;
        F9();
        Handler mainHandler = getMainHandler();
        if (mainHandler != null) {
            mainHandler.postDelayed(new j(), 100L);
        }
    }

    private final void E9() {
        int i3;
        AppBarLayout appBarLayout;
        ViewGroup viewGroup = this.historyRootView;
        if (viewGroup != null) {
            AppBarLayout appBarLayout2 = this.appBarLayout;
            if (appBarLayout2 != null) {
                i3 = appBarLayout2.indexOfChild(viewGroup);
            } else {
                i3 = -1;
            }
            if (i3 >= 0 && (appBarLayout = this.appBarLayout) != null) {
                appBarLayout.removeView(viewGroup);
            }
        }
    }

    private final void F9() {
        int coerceAtMost;
        List<QFSSearchHistoryItemInfo> j3 = com.tencent.biz.qqcircle.manager.k.d().j();
        if (j3.isEmpty()) {
            E9();
            return;
        }
        if (j3.size() <= 2) {
            QFSSearchPromptHistoryListAdapter qFSSearchPromptHistoryListAdapter = this.historyAdapter;
            if (qFSSearchPromptHistoryListAdapter != null) {
                qFSSearchPromptHistoryListAdapter.o0(QFSSearchPromptHistoryListAdapter.State.NORMAL);
            }
        } else if (this.isExpand) {
            QFSSearchPromptHistoryListAdapter qFSSearchPromptHistoryListAdapter2 = this.historyAdapter;
            if (qFSSearchPromptHistoryListAdapter2 != null) {
                qFSSearchPromptHistoryListAdapter2.o0(QFSSearchPromptHistoryListAdapter.State.EXPAND);
            }
        } else {
            QFSSearchPromptHistoryListAdapter qFSSearchPromptHistoryListAdapter3 = this.historyAdapter;
            if (qFSSearchPromptHistoryListAdapter3 != null) {
                qFSSearchPromptHistoryListAdapter3.o0(QFSSearchPromptHistoryListAdapter.State.COLLAPSE);
            }
        }
        QFSSearchPromptHistoryListAdapter qFSSearchPromptHistoryListAdapter4 = this.historyAdapter;
        if (qFSSearchPromptHistoryListAdapter4 != null) {
            int i3 = b.f89926a[qFSSearchPromptHistoryListAdapter4.get_state().ordinal()];
            if (i3 == 1 || i3 == 2) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(2, j3.size());
                qFSSearchPromptHistoryListAdapter4.setData(j3.subList(0, coerceAtMost));
            } else {
                qFSSearchPromptHistoryListAdapter4.setData(j3);
            }
        }
        J9();
    }

    private final void G9() {
        QCircleCustomDialog.O(getContext()).i0(getContext().getResources().getString(R.string.f195064dl)).f0(R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.history.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QFSSearchPromptHistoryListPart.H9(QFSSearchPromptHistoryListPart.this, dialogInterface, i3);
            }
        }).d0(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.history.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QFSSearchPromptHistoryListPart.I9(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(QFSSearchPromptHistoryListPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B9();
    }

    private final void J9() {
        int i3;
        AppBarLayout appBarLayout;
        ViewGroup viewGroup = this.historyRootView;
        if (viewGroup != null) {
            AppBarLayout appBarLayout2 = this.appBarLayout;
            if (appBarLayout2 != null) {
                i3 = appBarLayout2.indexOfChild(viewGroup);
            } else {
                i3 = -1;
            }
            if (i3 < 0 && (appBarLayout = this.appBarLayout) != null) {
                appBarLayout.addView(viewGroup, 0);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.manager.k.a
    public void a(@NotNull List<QFSSearchHistoryItemInfo> historyList) {
        Intrinsics.checkNotNullParameter(historyList, "historyList");
        F9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        return "QFSSearchPromptHistoryListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        AppBarLayout appBarLayout;
        ViewGroup viewGroup;
        RecyclerView recyclerView;
        View view;
        Object obj;
        View findViewById;
        super.onInitView(rootView);
        ConstraintLayout.LayoutParams layoutParams = null;
        if (rootView != null) {
            appBarLayout = (AppBarLayout) rootView.findViewById(R.id.f53822dj);
        } else {
            appBarLayout = null;
        }
        this.appBarLayout = appBarLayout;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f53962dx);
        } else {
            viewGroup = null;
        }
        this.historyRootView = viewGroup;
        if (viewGroup != null) {
            viewGroup.setPadding(0, 0, 0, viewGroup.getPaddingBottom());
        }
        ViewGroup viewGroup2 = this.historyRootView;
        if (viewGroup2 != null && (findViewById = viewGroup2.findViewById(R.id.f53882dp)) != null) {
            findViewById.setVisibility(8);
        }
        ViewGroup viewGroup3 = this.historyRootView;
        if (viewGroup3 != null) {
            recyclerView = (RecyclerView) viewGroup3.findViewById(R.id.f53862dn);
        } else {
            recyclerView = null;
        }
        this.recyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setNestedScrollingEnabled(false);
            QFSSearchPromptHistoryListAdapter qFSSearchPromptHistoryListAdapter = new QFSSearchPromptHistoryListAdapter(getReportBean());
            this.historyAdapter = qFSSearchPromptHistoryListAdapter;
            qFSSearchPromptHistoryListAdapter.q0(new QFSSearchPromptHistoryListPart$onInitView$3$1(this));
            recyclerView.setAdapter(this.historyAdapter);
        }
        ViewGroup viewGroup4 = this.historyRootView;
        if (viewGroup4 != null) {
            view = viewGroup4.findViewById(R.id.f53832dk);
        } else {
            view = null;
        }
        if (view != null) {
            obj = view.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof ConstraintLayout.LayoutParams) {
            layoutParams = (ConstraintLayout.LayoutParams) obj;
        }
        if (layoutParams != null) {
            int i3 = C;
            layoutParams.setMarginStart(i3);
            layoutParams.setMarginEnd(i3);
        }
        F9();
        C9();
        com.tencent.biz.qqcircle.manager.k.d().l(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.manager.k.d().n(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        this.isExpand = false;
        F9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(DialogInterface dialogInterface, int i3) {
    }
}
