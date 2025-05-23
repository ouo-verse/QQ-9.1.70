package com.qzone.reborn.albumx.qzonex.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.util.ar;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import wa.QZAlbumxParentFamilyBean;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u0002:\u000289B\u0019\u0012\u0006\u00104\u001a\u000203\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006:"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxParentingSelectIdentityDialog;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "", "U", "Y", "Landroid/view/View;", "containerView", "X", "a0", "W", "", "selectedText", "c0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxParentingSelectIdentityDialog$b;", "listener", "b0", "v", NodeProps.ON_CLICK, "Lwa/b;", BdhLogUtil.LogTag.Tag_Conn, "Lwa/b;", "selectedFamilyBean", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "D", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "halfScreenFloatingView", "E", "Landroid/view/View;", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "tvIdentityCancel", "H", "tvIdentityTitle", "I", "tvIdentityConfirm", "Lsa/i;", "J", "Lsa/i;", "identityAdapter", "K", "Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxParentingSelectIdentityDialog$b;", "dialogListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lwa/b;)V", "L", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxParentingSelectIdentityDialog extends ReportDialog implements View.OnClickListener {
    private static final int M = ar.e(364.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private final QZAlbumxParentFamilyBean selectedFamilyBean;

    /* renamed from: D, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView halfScreenFloatingView;

    /* renamed from: E, reason: from kotlin metadata */
    private View containerView;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView tvIdentityCancel;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView tvIdentityTitle;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView tvIdentityConfirm;

    /* renamed from: J, reason: from kotlin metadata */
    private sa.i identityAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    private b dialogListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxParentingSelectIdentityDialog$b;", "", "", "onCancel", "Lwa/b;", "selectedFamilyBean", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void a(QZAlbumxParentFamilyBean selectedFamilyBean);

        void onCancel();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/QZAlbumxParentingSelectIdentityDialog$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF58528d() {
            QZAlbumxParentingSelectIdentityDialog qZAlbumxParentingSelectIdentityDialog = QZAlbumxParentingSelectIdentityDialog.this;
            View inflate = LayoutInflater.from(qZAlbumxParentingSelectIdentityDialog.getContext()).inflate(R.layout.f129255k, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026y_container_layout, null)");
            qZAlbumxParentingSelectIdentityDialog.containerView = inflate;
            QZAlbumxParentingSelectIdentityDialog qZAlbumxParentingSelectIdentityDialog2 = QZAlbumxParentingSelectIdentityDialog.this;
            View view = qZAlbumxParentingSelectIdentityDialog2.containerView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                view = null;
            }
            qZAlbumxParentingSelectIdentityDialog2.X(view);
            View view2 = QZAlbumxParentingSelectIdentityDialog.this.containerView;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            return null;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return QZAlbumxParentingSelectIdentityDialog.M;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/QZAlbumxParentingSelectIdentityDialog$d", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.top = 0;
            outRect.bottom = ImmersiveUtils.dpToPx(12.0f);
            outRect.left = parent.getChildAdapterPosition(view) % 3 == 0 ? 0 : ImmersiveUtils.dpToPx(12.0f);
            outRect.right = 0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxParentingSelectIdentityDialog(Context context, QZAlbumxParentFamilyBean qZAlbumxParentFamilyBean) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selectedFamilyBean = qZAlbumxParentFamilyBean;
    }

    private final void U() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        window.setSoftInputMode(19);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("QZAlbumxParentingSelectIdentityDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    private final void W() {
        this.identityAdapter = new sa.i(com.qzone.reborn.albumx.qzonex.utils.b.f53400a.a(), new Function2<Integer, QZAlbumxParentFamilyBean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog$initAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, QZAlbumxParentFamilyBean qZAlbumxParentFamilyBean) {
                invoke(num.intValue(), qZAlbumxParentFamilyBean);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, QZAlbumxParentFamilyBean selectedFamilyBean) {
                Intrinsics.checkNotNullParameter(selectedFamilyBean, "selectedFamilyBean");
                QZAlbumxParentingSelectIdentityDialog.this.c0(selectedFamilyBean.getName());
            }
        });
        RecyclerView recyclerView = this.recyclerView;
        sa.i iVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        sa.i iVar2 = this.identityAdapter;
        if (iVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("identityAdapter");
            iVar2 = null;
        }
        recyclerView.setAdapter(iVar2);
        sa.i iVar3 = this.identityAdapter;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("identityAdapter");
            iVar3 = null;
        }
        iVar3.n0(this.selectedFamilyBean);
        sa.i iVar4 = this.identityAdapter;
        if (iVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("identityAdapter");
        } else {
            iVar = iVar4;
        }
        iVar.notifyDataSetChanged();
    }

    private final void Y() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.setDraggable(false);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setOutSideTouchEnable(false);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.setQUSDragFloatController(new c());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView5 = null;
        }
        qUSHalfScreenFloatingView5.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.qzone.reborn.albumx.qzonex.view.ab
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                QZAlbumxParentingSelectIdentityDialog.Z(QZAlbumxParentingSelectIdentityDialog.this);
            }
        });
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView6 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView6;
        }
        qUSHalfScreenFloatingView2.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(QZAlbumxParentingSelectIdentityDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void a0(View containerView) {
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new SafeGridLayoutManager(containerView.getContext(), 3));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.addItemDecoration(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(String selectedText) {
        TextView textView = null;
        if (TextUtils.isEmpty(selectedText)) {
            TextView textView2 = this.tvIdentityConfirm;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvIdentityConfirm");
                textView2 = null;
            }
            textView2.setEnabled(false);
            TextView textView3 = this.tvIdentityConfirm;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvIdentityConfirm");
            } else {
                textView = textView3;
            }
            textView.setTextColor(getContext().getColor(R.color.qui_common_text_tertiary));
            return;
        }
        TextView textView4 = this.tvIdentityConfirm;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvIdentityConfirm");
            textView4 = null;
        }
        textView4.setEnabled(true);
        TextView textView5 = this.tvIdentityConfirm;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvIdentityConfirm");
        } else {
            textView = textView5;
        }
        textView.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
    }

    public final void b0(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dialogListener = listener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f162960nk0) {
            b bVar = this.dialogListener;
            if (bVar != null) {
                bVar.onCancel();
            }
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.halfScreenFloatingView;
            if (qUSHalfScreenFloatingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            } else {
                qUSHalfScreenFloatingView = qUSHalfScreenFloatingView2;
            }
            qUSHalfScreenFloatingView.t();
        } else if (valueOf != null && valueOf.intValue() == R.id.f162961nk1) {
            b bVar2 = this.dialogListener;
            if (bVar2 != null) {
                sa.i iVar = this.identityAdapter;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("identityAdapter");
                    iVar = null;
                }
                bVar2.a(iVar.getSelectedFamilyBean());
            }
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.halfScreenFloatingView;
            if (qUSHalfScreenFloatingView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            } else {
                qUSHalfScreenFloatingView = qUSHalfScreenFloatingView3;
            }
            qUSHalfScreenFloatingView.t();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        U();
        setContentView(R.layout.f129265l);
        View findViewById = findViewById(R.id.miy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qus_floating_half_screen)");
        this.halfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        setCancelable(false);
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(View containerView) {
        View findViewById = containerView.findViewById(R.id.nf8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.rv_identity_list)");
        this.recyclerView = (RecyclerView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f162960nk0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026v_select_identity_cancel)");
        this.tvIdentityCancel = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f162962nk2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026tv_select_identity_title)");
        this.tvIdentityTitle = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f162961nk1);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026_select_identity_confirm)");
        this.tvIdentityConfirm = (TextView) findViewById4;
        TextView textView = this.tvIdentityCancel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvIdentityCancel");
            textView = null;
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.tvIdentityConfirm;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvIdentityConfirm");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        a0(containerView);
        W();
        QZAlbumxParentFamilyBean qZAlbumxParentFamilyBean = this.selectedFamilyBean;
        c0(qZAlbumxParentFamilyBean != null ? qZAlbumxParentFamilyBean.getName() : null);
    }
}
