package com.tencent.biz.qqcircle.share.part;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.util.Consumer;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.comment.at.dialog.QFSCommentAtSearchExt;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberSearchPart;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.InputMethodUtil;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yb0.p;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001AB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\n\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0017\u0010\u001c\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*03028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R#\u0010=\u001a\n 8*\u0004\u0018\u000107078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/biz/qqcircle/share/part/QFSShareSelectMemberSearchPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/qqcircle/comment/at/dialog/a;", "", "initViewModel", "K9", "I9", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchBar", "H9", "", "searchKey", "G9", "J9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lo20/b;", "itemInfo", "Z7", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "d", "Ljava/lang/String;", "getSelectType", "()Ljava/lang/String;", "selectType", "Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;", "e", "Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;", "editText", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "searchRv", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "searchEmptyTv", "Lcom/tencent/biz/qqcircle/comment/at/dialog/QFSCommentAtSearchExt$a;", "Lcom/tencent/biz/qqcircle/comment/at/bean/QFSCommentAtEntity;", "i", "Lcom/tencent/biz/qqcircle/comment/at/dialog/QFSCommentAtSearchExt$a;", "chatExtAdapter", "Lcom/tencent/biz/qqcircle/comment/at/dialog/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/comment/at/dialog/e;", "searchAdapter", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/Observer;", "selectStatusObserver", "Lzb0/a;", "kotlin.jvm.PlatformType", "D", "Lkotlin/Lazy;", "F9", "()Lzb0/a;", "viewModel", "<init>", "(Ljava/lang/String;)V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSShareSelectMemberSearchPart extends u implements com.tencent.biz.qqcircle.comment.at.dialog.a {

    /* renamed from: C, reason: from kotlin metadata */
    private Observer<UIStateData<QFSCommentAtEntity>> selectStatusObserver;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String selectType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QuickPinyinEditText editText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView searchRv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView searchEmptyTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSCommentAtSearchExt.a<QFSCommentAtEntity> chatExtAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.comment.at.dialog.e searchAdapter;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/share/part/QFSShareSelectMemberSearchPart$b", "Landroidx/core/util/Consumer;", "", "Lo20/b;", "t", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements Consumer<List<? extends o20.b>> {
        b() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(@Nullable List<? extends o20.b> t16) {
            com.tencent.biz.qqcircle.comment.at.dialog.e eVar;
            String str;
            TextView textView = null;
            if (RFSafeListUtils.isEmpty(t16)) {
                TextView textView2 = QFSShareSelectMemberSearchPart.this.searchEmptyTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEmptyTv");
                    textView2 = null;
                }
                if (textView2.getVisibility() == 8) {
                    Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
                    Intrinsics.checkNotNullExpressionValue(params, "params");
                    params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_VOID_ITEM);
                    QCircleReportBean reportBean = QFSShareSelectMemberSearchPart.this.getReportBean();
                    if (reportBean != null) {
                        str = reportBean.getDtPageId();
                    } else {
                        str = null;
                    }
                    params.put("xsj_custom_pgid", str);
                    VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
                }
                TextView textView3 = QFSShareSelectMemberSearchPart.this.searchEmptyTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEmptyTv");
                } else {
                    textView = textView3;
                }
                textView.setVisibility(0);
                com.tencent.biz.qqcircle.comment.at.dialog.e eVar2 = QFSShareSelectMemberSearchPart.this.searchAdapter;
                if (eVar2 != null) {
                    eVar2.setItems(new ArrayList());
                    return;
                }
                return;
            }
            TextView textView4 = QFSShareSelectMemberSearchPart.this.searchEmptyTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEmptyTv");
            } else {
                textView = textView4;
            }
            textView.setVisibility(8);
            if (t16 != null && (eVar = QFSShareSelectMemberSearchPart.this.searchAdapter) != null) {
                eVar.setItems(t16);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/share/part/QFSShareSelectMemberSearchPart$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            com.tencent.biz.qqcircle.comment.at.dialog.e eVar;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0 && (eVar = QFSShareSelectMemberSearchPart.this.searchAdapter) != null) {
                eVar.notifyDataSetChanged();
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/qqcircle/share/part/QFSShareSelectMemberSearchPart$e", "Lcom/tencent/biz/qqcircle/comment/at/dialog/QFSCommentAtSearchExt$a;", "Lcom/tencent/biz/qqcircle/comment/at/bean/QFSCommentAtEntity;", "Lcom/tencent/biz/qqcircle/comment/at/dialog/QFSCommentAtSearchExt$b;", "viewHolder", "", com.tencent.luggage.wxa.c8.c.G, "atEntity", "", "q0", "t0", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class e extends QFSCommentAtSearchExt.a<QFSCommentAtEntity> {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r0(QFSCommentAtSearchExt.b viewHolder, Bitmap bitmap) {
            Resources resources;
            ImageView k3;
            Context context;
            Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
            if (bitmap != null) {
                QCircleAvatarView qCircleAvatarView = viewHolder.E;
                if (qCircleAvatarView != null && (context = qCircleAvatarView.getContext()) != null) {
                    resources = context.getResources();
                } else {
                    resources = null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmap);
                QCircleAvatarView qCircleAvatarView2 = viewHolder.E;
                if (qCircleAvatarView2 != null && (k3 = qCircleAvatarView2.k()) != null) {
                    k3.setImageDrawable(bitmapDrawable);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s0(QFSShareSelectMemberSearchPart this$0, QFSCommentAtEntity atEntity, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(atEntity, "$atEntity");
            QFSCommentAtSearchExt.a aVar = this$0.chatExtAdapter;
            if (aVar != null) {
                aVar.removeItem(atEntity);
            }
            this$0.F9().O1(atEntity);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qqcircle.comment.at.dialog.QFSCommentAtSearchExt.a
        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public void i0(@NotNull final QFSCommentAtSearchExt.b viewHolder, int pos, @NotNull final QFSCommentAtEntity atEntity) {
            ImageView k3;
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(atEntity, "atEntity");
            if (atEntity.f() == 1) {
                QFSCommentAtHelper.t0(atEntity.e(), atEntity.f(), viewHolder.E);
            } else {
                Drawable s16 = QCirclePluginGlobalInfo.s(atEntity.e(), new QCircleFaceBitmapListener() { // from class: com.tencent.biz.qqcircle.share.part.j
                    @Override // com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener
                    public final void getFaceBitmap(Bitmap bitmap) {
                        QFSShareSelectMemberSearchPart.e.r0(QFSCommentAtSearchExt.b.this, bitmap);
                    }
                });
                QCircleAvatarView qCircleAvatarView = viewHolder.E;
                if (qCircleAvatarView != null && (k3 = qCircleAvatarView.k()) != null) {
                    k3.setImageDrawable(s16);
                }
            }
            View view = viewHolder.itemView;
            final QFSShareSelectMemberSearchPart qFSShareSelectMemberSearchPart = QFSShareSelectMemberSearchPart.this;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.share.part.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QFSShareSelectMemberSearchPart.e.s0(QFSShareSelectMemberSearchPart.this, atEntity, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qqcircle.comment.at.dialog.QFSCommentAtSearchExt.a
        /* renamed from: t0, reason: merged with bridge method [inline-methods] */
        public void l0(@NotNull QFSCommentAtEntity atEntity) {
            Intrinsics.checkNotNullParameter(atEntity, "atEntity");
            super.l0(atEntity);
            QFSShareSelectMemberSearchPart.this.F9().O1(atEntity);
        }
    }

    public QFSShareSelectMemberSearchPart(@NotNull String selectType) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(selectType, "selectType");
        this.selectType = selectType;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<zb0.a>() { // from class: com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberSearchPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final zb0.a invoke() {
                return (zb0.a) QFSShareSelectMemberSearchPart.this.getViewModel(zb0.a.class);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zb0.a F9() {
        return (zb0.a) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.widget.TextView] */
    public final void G9(String searchKey) {
        String str;
        RecyclerView recyclerView = null;
        if (Intrinsics.areEqual(searchKey, "")) {
            RecyclerView recyclerView2 = this.searchRv;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchRv");
                recyclerView2 = null;
            }
            recyclerView2.setVisibility(8);
            ?? r75 = this.searchEmptyTv;
            if (r75 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEmptyTv");
            } else {
                recyclerView = r75;
            }
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView3 = this.searchRv;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchRv");
            recyclerView3 = null;
        }
        recyclerView3.setVisibility(0);
        if (Intrinsics.areEqual(this.selectType, "select_type_friends")) {
            str = "select_type_all";
        } else {
            str = this.selectType;
        }
        p.f450005a.l(str, searchKey, F9().N1(), new b());
        RecyclerView recyclerView4 = this.searchRv;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchRv");
        } else {
            recyclerView = recyclerView4;
        }
        recyclerView.addOnScrollListener(new c());
    }

    private final void H9(QUISearchBar searchBar) {
        QuickPinyinEditText inputWidget = searchBar.getInputWidget();
        Intrinsics.checkNotNullExpressionValue(inputWidget, "searchBar.inputWidget");
        this.editText = inputWidget;
        QuickPinyinEditText quickPinyinEditText = null;
        if (inputWidget == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            inputWidget = null;
        }
        inputWidget.clearFocus();
        QuickPinyinEditText quickPinyinEditText2 = this.editText;
        if (quickPinyinEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            quickPinyinEditText2 = null;
        }
        quickPinyinEditText2.setTextSize(1, 16.0f);
        QuickPinyinEditText quickPinyinEditText3 = this.editText;
        if (quickPinyinEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
        } else {
            quickPinyinEditText = quickPinyinEditText3;
        }
        quickPinyinEditText.addTextChangedListener(new d());
    }

    private final void I9() {
        Window window;
        Activity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(3);
        }
        View findViewById = getPartRootView().findViewById(R.id.iir);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.search_bar)");
        QUISearchBar qUISearchBar = (QUISearchBar) findViewById;
        qUISearchBar.setBackgroundColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_middle_light));
        H9(qUISearchBar);
        J9(qUISearchBar);
    }

    private final void J9(QUISearchBar searchBar) {
        QFSCommentAtSearchExt qFSCommentAtSearchExt = new QFSCommentAtSearchExt(searchBar);
        e eVar = new e();
        this.chatExtAdapter = eVar;
        eVar.updateData(F9().N1());
        qFSCommentAtSearchExt.d(this.chatExtAdapter);
        searchBar.setSearchBarLayoutExt(qFSCommentAtSearchExt);
    }

    private final void K9() {
        View findViewById = getPartRootView().findViewById(R.id.f80864cm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.search_empty_text)");
        TextView textView = (TextView) findViewById;
        this.searchEmptyTv = textView;
        RecyclerView recyclerView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEmptyTv");
            textView = null;
        }
        textView.setVisibility(8);
        View findViewById2 = getPartRootView().findViewById(R.id.f81114da);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.search_recycle_view)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        this.searchRv = recyclerView2;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchRv");
            recyclerView2 = null;
        }
        recyclerView2.setVisibility(8);
        RecyclerView recyclerView3 = this.searchRv;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchRv");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        RecyclerView recyclerView4 = this.searchRv;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchRv");
            recyclerView4 = null;
        }
        recyclerView4.setItemAnimator(null);
        this.searchAdapter = new com.tencent.biz.qqcircle.comment.at.dialog.e(1);
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.searchAdapter});
        RecyclerView recyclerView5 = this.searchRv;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchRv");
            recyclerView5 = null;
        }
        recyclerView5.setAdapter(rFWConcatAdapter);
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView6 = this.searchRv;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchRv");
        } else {
            recyclerView = recyclerView6;
        }
        g16.registerIoc(recyclerView, this, com.tencent.biz.qqcircle.comment.at.dialog.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QFSShareSelectMemberSearchPart this$0, UIStateData uIStateData) {
        QFSCommentAtSearchExt.a<QFSCommentAtEntity> aVar;
        QFSCommentAtEntity qFSCommentAtEntity;
        QFSCommentAtSearchExt.a<QFSCommentAtEntity> aVar2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int state = uIStateData.getState();
        if (state != 6) {
            if (state == 8 && (qFSCommentAtEntity = (QFSCommentAtEntity) uIStateData.getData()) != null && (aVar2 = this$0.chatExtAdapter) != null) {
                aVar2.addLast(qFSCommentAtEntity);
                return;
            }
            return;
        }
        QFSCommentAtEntity qFSCommentAtEntity2 = (QFSCommentAtEntity) uIStateData.getData();
        if (qFSCommentAtEntity2 != null && (aVar = this$0.chatExtAdapter) != null) {
            aVar.removeItem(qFSCommentAtEntity2);
        }
    }

    private final void initViewModel() {
        this.selectStatusObserver = new Observer() { // from class: com.tencent.biz.qqcircle.share.part.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSShareSelectMemberSearchPart.L9(QFSShareSelectMemberSearchPart.this, (UIStateData) obj);
            }
        };
        MutableLiveData<UIStateData<QFSCommentAtEntity>> M1 = F9().M1();
        Observer<UIStateData<QFSCommentAtEntity>> observer = this.selectStatusObserver;
        if (observer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectStatusObserver");
            observer = null;
        }
        M1.observeForever(observer);
    }

    @Override // com.tencent.biz.qqcircle.comment.at.dialog.a
    public void Z7(@NotNull o20.b itemInfo) {
        String str;
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        if (itemInfo.b()) {
            return;
        }
        if (F9().N1().size() >= 9) {
            yb0.c.h(getActivity());
            QLog.d("QFSShareSelectMemberSearchPart", 1, "[onSearchItemClick] max choose");
            return;
        }
        QFSCommentAtEntity a16 = itemInfo.a();
        if (a16 == null) {
            return;
        }
        QFSCommentAtSearchExt.a<QFSCommentAtEntity> aVar = this.chatExtAdapter;
        if (aVar != null) {
            aVar.addLast(a16);
        }
        F9().L1(a16);
        QuickPinyinEditText quickPinyinEditText = this.editText;
        QuickPinyinEditText quickPinyinEditText2 = null;
        if (quickPinyinEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            quickPinyinEditText = null;
        }
        quickPinyinEditText.setText((CharSequence) null);
        RecyclerView recyclerView = this.searchRv;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchRv");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        QuickPinyinEditText quickPinyinEditText3 = this.editText;
        if (quickPinyinEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
        } else {
            quickPinyinEditText2 = quickPinyinEditText3;
        }
        InputMethodUtil.hide(quickPinyinEditText2);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_USER_ITEM);
        QCircleReportBean reportBean = getReportBean();
        if (reportBean == null || (str = reportBean.getDtPageId()) == null) {
            str = "";
        }
        params.put("xsj_custom_pgid", str);
        params.put("xsj_target_qq", ua0.d.f(a16.f()) + a16.e());
        VideoReport.reportEvent("ev_xsj_abnormal_clck", params);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSShareSelectMemberSearchPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        K9();
        I9();
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        MutableLiveData<UIStateData<QFSCommentAtEntity>> M1 = F9().M1();
        Observer<UIStateData<QFSCommentAtEntity>> observer = this.selectStatusObserver;
        if (observer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectStatusObserver");
            observer = null;
        }
        M1.removeObserver(observer);
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/qqcircle/share/part/QFSShareSelectMemberSearchPart$d", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            QFSShareSelectMemberSearchPart qFSShareSelectMemberSearchPart = QFSShareSelectMemberSearchPart.this;
            QuickPinyinEditText quickPinyinEditText = qFSShareSelectMemberSearchPart.editText;
            if (quickPinyinEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                quickPinyinEditText = null;
            }
            qFSShareSelectMemberSearchPart.G9(quickPinyinEditText.getText().toString());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }
    }
}
