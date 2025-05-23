package com.tencent.biz.qqcircle.immersive.search.prompt.history;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSSearchHistoryItemInfo;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.search.prompt.history.QFSSearchPromptHistoryFlexAdapter;
import com.tencent.biz.qqcircle.immersive.search.prompt.history.a;
import com.tencent.biz.qqcircle.manager.k;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0016J\u0016\u0010\u001f\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001dH\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0018\u00100\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010>\u00a8\u0006E"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/qqcircle/manager/k$a;", "", "I9", "G9", "H9", "", "Lcom/tencent/biz/qqcircle/beans/QFSSearchHistoryItemInfo;", "infos", "C9", "B9", "", "text", "J9", "F9", "D9", "A9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "onPartDestroy", "v", NodeProps.ON_CLICK, "", "historyList", "a", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "historyRootView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvEdit", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "tvEditIcon", tl.h.F, "tvTitle", "i", "Landroid/view/View;", "divider", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryFlexAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryFlexAdapter;", "historyAdapter", "", "D", "Z", "isExpanded", "E", "Ljava/util/List;", "collapseHistoryInfos", UserInfo.SEX_FEMALE, "expandHistoryInfos", "<init>", "()V", "G", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptHistoryPart extends u implements View.OnClickListener, k.a {
    private static final int H = com.tencent.qqnt.base.utils.c.f353052a.b(20);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QFSSearchPromptHistoryFlexAdapter historyAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isExpanded;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<QFSSearchHistoryItemInfo> collapseHistoryInfos = new ArrayList();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<QFSSearchHistoryItemInfo> expandHistoryInfos = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup historyRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvEdit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView tvEditIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View divider;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f89933a;

        static {
            int[] iArr = new int[QFSSearchPromptHistoryFlexAdapter.EditState.values().length];
            try {
                iArr[QFSSearchPromptHistoryFlexAdapter.EditState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QFSSearchPromptHistoryFlexAdapter.EditState.EDIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f89933a = iArr;
        }
    }

    private final void A9() {
        VideoReport.setElementId(this.historyRootView, QCircleDaTongConstant.ElementId.EM_XSJ_HISTORY_SEARCH);
        VideoReport.setElementExposePolicy(this.historyRootView, ExposurePolicy.REPORT_ALL);
        ViewGroup viewGroup = this.historyRootView;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(viewGroup, clickPolicy);
        VideoReport.setElementId(this.tvEditIcon, QCircleDaTongConstant.ElementId.EM_XSJ_HISTORY_SEARCH_DELETE_BUTTON);
        VideoReport.setElementExposePolicy(this.tvEditIcon, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.tvEditIcon, clickPolicy);
    }

    private final void B9(List<? extends QFSSearchHistoryItemInfo> infos) {
        int collectionSizeOrDefault;
        int i3;
        int i16;
        int i17;
        this.collapseHistoryInfos.clear();
        int a16 = cx.a(16.0f) * 2;
        int a17 = cx.a(2.0f) * 2;
        int a18 = cx.a(10.0f) * 2;
        int a19 = cx.a(32.0f);
        int g16 = (cx.g() - a16) - a17;
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(cx.a(15.0f));
        List<? extends QFSSearchHistoryItemInfo> list = infos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList<QFSSearchHistoryItemInfo> arrayList = new ArrayList(collectionSizeOrDefault);
        for (QFSSearchHistoryItemInfo qFSSearchHistoryItemInfo : list) {
            QFSSearchHistoryItemInfo qFSSearchHistoryItemInfo2 = new QFSSearchHistoryItemInfo();
            qFSSearchHistoryItemInfo2.searchHistoryWord = qFSSearchHistoryItemInfo.searchHistoryWord;
            String str = qFSSearchHistoryItemInfo.searchHistoryWord;
            Intrinsics.checkNotNullExpressionValue(str, "it.searchHistoryWord");
            qFSSearchHistoryItemInfo2.showText = J9(str);
            arrayList.add(qFSSearchHistoryItemInfo2);
        }
        float f16 = 0.0f;
        int i18 = 1;
        for (QFSSearchHistoryItemInfo qFSSearchHistoryItemInfo3 : arrayList) {
            float measureText = textPaint.measureText(qFSSearchHistoryItemInfo3.showText);
            a.Companion companion = a.INSTANCE;
            float a26 = companion.a() + measureText + a18;
            if (QLog.isColorLevel()) {
                String str2 = qFSSearchHistoryItemInfo3.showText;
                i3 = a18;
                StringBuilder sb5 = new StringBuilder();
                i16 = g16;
                sb5.append("[computeCollapsedInfos] ");
                sb5.append(str2);
                sb5.append(", textWidth=");
                sb5.append(measureText);
                sb5.append(", thisWidth=");
                sb5.append(a26);
                sb5.append(", totalWidth=");
                sb5.append(f16 + a26);
                String sb6 = sb5.toString();
                i17 = 1;
                QLog.d("QFSSearchPromptHistoryPart", 1, sb6);
            } else {
                i3 = a18;
                i16 = g16;
                i17 = 1;
            }
            if (i18 > i17) {
                g16 = (((cx.g() - a16) - a17) - a19) - companion.a();
            } else {
                g16 = i16;
            }
            if (f16 + a26 > g16) {
                i18++;
                if (i18 > 2) {
                    QLog.d("QFSSearchPromptHistoryPart", 1, "[computeCollapsedInfos]1 collapse size=" + this.collapseHistoryInfos.size());
                    return;
                }
                f16 = 0.0f;
            }
            this.collapseHistoryInfos.add(qFSSearchHistoryItemInfo3);
            f16 += a26;
            a18 = i3;
        }
        QLog.d("QFSSearchPromptHistoryPart", 1, "[computeCollapsedInfos]2 collapse size=" + this.collapseHistoryInfos.size());
    }

    private final void C9(List<? extends QFSSearchHistoryItemInfo> infos) {
        int collectionSizeOrDefault;
        this.expandHistoryInfos.clear();
        List<? extends QFSSearchHistoryItemInfo> list = infos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (QFSSearchHistoryItemInfo qFSSearchHistoryItemInfo : list) {
            QFSSearchHistoryItemInfo qFSSearchHistoryItemInfo2 = new QFSSearchHistoryItemInfo();
            qFSSearchHistoryItemInfo2.searchHistoryWord = qFSSearchHistoryItemInfo.searchHistoryWord;
            String str = qFSSearchHistoryItemInfo.searchHistoryWord;
            Intrinsics.checkNotNullExpressionValue(str, "it.searchHistoryWord");
            qFSSearchHistoryItemInfo2.showText = J9(str);
            arrayList.add(qFSSearchHistoryItemInfo2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.expandHistoryInfos.add((QFSSearchHistoryItemInfo) it.next());
        }
    }

    private final void D9() {
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.history.o
            @Override // java.lang.Runnable
            public final void run() {
                QFSSearchPromptHistoryPart.E9(QFSSearchPromptHistoryPart.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(QFSSearchPromptHistoryPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.traversePage(this$0.recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        this.isExpanded = !this.isExpanded;
        G9();
        D9();
    }

    private final void G9() {
        List<QFSSearchHistoryItemInfo> fullInfos = com.tencent.biz.qqcircle.manager.k.d().j();
        if (fullInfos.isEmpty()) {
            ViewGroup viewGroup = this.historyRootView;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        Intrinsics.checkNotNullExpressionValue(fullInfos, "fullInfos");
        C9(fullInfos);
        B9(fullInfos);
        ViewGroup viewGroup2 = this.historyRootView;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        H9();
        if (this.collapseHistoryInfos.size() == this.expandHistoryInfos.size()) {
            QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter = this.historyAdapter;
            if (qFSSearchPromptHistoryFlexAdapter != null) {
                QFSSearchPromptHistoryFlexAdapter.l0(qFSSearchPromptHistoryFlexAdapter, QFSSearchPromptHistoryFlexAdapter.ArrowState.NONE, false, 2, null);
            }
            QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter2 = this.historyAdapter;
            if (qFSSearchPromptHistoryFlexAdapter2 != null) {
                qFSSearchPromptHistoryFlexAdapter2.setData(this.expandHistoryInfos);
                return;
            }
            return;
        }
        if (this.isExpanded) {
            QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter3 = this.historyAdapter;
            if (qFSSearchPromptHistoryFlexAdapter3 != null) {
                QFSSearchPromptHistoryFlexAdapter.l0(qFSSearchPromptHistoryFlexAdapter3, QFSSearchPromptHistoryFlexAdapter.ArrowState.UP, false, 2, null);
            }
            QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter4 = this.historyAdapter;
            if (qFSSearchPromptHistoryFlexAdapter4 != null) {
                qFSSearchPromptHistoryFlexAdapter4.setData(this.expandHistoryInfos);
                return;
            }
            return;
        }
        QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter5 = this.historyAdapter;
        if (qFSSearchPromptHistoryFlexAdapter5 != null) {
            QFSSearchPromptHistoryFlexAdapter.l0(qFSSearchPromptHistoryFlexAdapter5, QFSSearchPromptHistoryFlexAdapter.ArrowState.DOWN, false, 2, null);
        }
        QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter6 = this.historyAdapter;
        if (qFSSearchPromptHistoryFlexAdapter6 != null) {
            qFSSearchPromptHistoryFlexAdapter6.setData(this.collapseHistoryInfos);
        }
    }

    private final void H9() {
        QFSSearchPromptHistoryFlexAdapter.EditState editState;
        int i3;
        QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter = this.historyAdapter;
        if (qFSSearchPromptHistoryFlexAdapter != null) {
            editState = qFSSearchPromptHistoryFlexAdapter.getEditState();
        } else {
            editState = null;
        }
        if (editState == null) {
            i3 = -1;
        } else {
            i3 = b.f89933a[editState.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2) {
                QLog.d(getLogTag(), 1, "[setupEditState] no adapter");
                return;
            }
            TextView textView = this.tvEdit;
            if (textView != null) {
                textView.setVisibility(0);
            }
            ImageView imageView = this.tvEditIcon;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.tvEdit;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        ImageView imageView2 = this.tvEditIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }

    private final void I9() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new FlexboxLayoutManager(recyclerView.getContext(), 0, 1));
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.addItemDecoration(new a());
            QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter = new QFSSearchPromptHistoryFlexAdapter(getReportBean());
            this.historyAdapter = qFSSearchPromptHistoryFlexAdapter;
            qFSSearchPromptHistoryFlexAdapter.r0(new QFSSearchPromptHistoryPart$setupRecyclerView$1$1(this));
            recyclerView.setAdapter(this.historyAdapter);
        }
    }

    private final String J9(String text) {
        if (text.length() > 8) {
            String substring = text.substring(0, 8);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return text;
    }

    @Override // com.tencent.biz.qqcircle.manager.k.a
    public void a(@NotNull List<QFSSearchHistoryItemInfo> historyList) {
        Intrinsics.checkNotNullParameter(historyList, "historyList");
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        return "QFSSearchPromptHistoryPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f53842dl) {
            QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter = this.historyAdapter;
            if (qFSSearchPromptHistoryFlexAdapter != null) {
                QFSSearchPromptHistoryFlexAdapter.n0(qFSSearchPromptHistoryFlexAdapter, QFSSearchPromptHistoryFlexAdapter.EditState.EDIT, false, 2, null);
            }
            H9();
            VideoReport.reportEvent("dt_clck", v3, new QCircleDTParamBuilder().buildElementParams());
            D9();
        } else if (num != null && num.intValue() == R.id.f53852dm) {
            QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter2 = this.historyAdapter;
            if (qFSSearchPromptHistoryFlexAdapter2 != null) {
                qFSSearchPromptHistoryFlexAdapter2.m0(QFSSearchPromptHistoryFlexAdapter.EditState.NORMAL, false);
            }
            this.isExpanded = false;
            G9();
            H9();
            D9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        View view;
        TextView textView;
        ImageView imageView;
        TextView textView2;
        RecyclerView recyclerView;
        super.onInitView(rootView);
        ViewGroup.LayoutParams layoutParams = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f53962dx);
        } else {
            viewGroup = null;
        }
        this.historyRootView = viewGroup;
        if (viewGroup != null) {
            view = viewGroup.findViewById(R.id.f53832dk);
        } else {
            view = null;
        }
        this.divider = view;
        ViewGroup viewGroup2 = this.historyRootView;
        if (viewGroup2 != null) {
            textView = (TextView) viewGroup2.findViewById(R.id.f53852dm);
        } else {
            textView = null;
        }
        this.tvEdit = textView;
        ViewGroup viewGroup3 = this.historyRootView;
        if (viewGroup3 != null) {
            imageView = (ImageView) viewGroup3.findViewById(R.id.f53842dl);
        } else {
            imageView = null;
        }
        this.tvEditIcon = imageView;
        ViewGroup viewGroup4 = this.historyRootView;
        if (viewGroup4 != null) {
            textView2 = (TextView) viewGroup4.findViewById(R.id.f53882dp);
        } else {
            textView2 = null;
        }
        this.tvTitle = textView2;
        ViewGroup viewGroup5 = this.historyRootView;
        if (viewGroup5 != null) {
            recyclerView = (RecyclerView) viewGroup5.findViewById(R.id.f53862dn);
        } else {
            recyclerView = null;
        }
        this.recyclerView = recyclerView;
        TextView textView3 = this.tvTitle;
        if (textView3 != null) {
            textView3.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f195004df));
        }
        View view2 = this.divider;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        int g16 = ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000);
        TextView textView4 = this.tvEdit;
        if (textView4 != null) {
            textView4.setTextColor(g16);
        }
        TextView textView5 = this.tvEdit;
        if (textView5 != null) {
            textView5.setText("\u5b8c\u6210");
        }
        TextView textView6 = this.tvEdit;
        if (textView6 != null) {
            textView6.setOnClickListener(this);
        }
        Drawable o16 = ie0.a.f().o(getContext(), R.drawable.qui_delete_icon_secondary_01, R.color.qui_common_icon_secondary, 1000);
        ImageView imageView2 = this.tvEditIcon;
        if (imageView2 != null) {
            imageView2.setImageDrawable(o16);
        }
        ImageView imageView3 = this.tvEditIcon;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        ImageView imageView4 = this.tvEditIcon;
        if (imageView4 != null) {
            layoutParams = imageView4.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.width = H;
        }
        if (layoutParams != null) {
            layoutParams.height = H;
        }
        ImageView imageView5 = this.tvEditIcon;
        if (imageView5 != null) {
            imageView5.setLayoutParams(layoutParams);
        }
        A9();
        com.tencent.biz.qqcircle.manager.k.d().l(this);
        I9();
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.manager.k.d().n(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter = this.historyAdapter;
        if (qFSSearchPromptHistoryFlexAdapter != null) {
            QFSSearchPromptHistoryFlexAdapter.n0(qFSSearchPromptHistoryFlexAdapter, QFSSearchPromptHistoryFlexAdapter.EditState.NORMAL, false, 2, null);
        }
        TextView textView = this.tvEdit;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.tvEditIcon;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }
}
