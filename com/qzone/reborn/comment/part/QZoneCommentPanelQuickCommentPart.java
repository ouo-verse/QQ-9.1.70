package com.qzone.reborn.comment.part;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.tianshu.QZoneCommentQuickInputHelper;
import com.qzone.business.tianshu.model.QZoneQuickCommentInfo;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001DB\u000f\u0012\u0006\u0010%\u001a\u00020 \u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=\u00a8\u0006E"}, d2 = {"Lcom/qzone/reborn/comment/part/QZoneCommentPanelQuickCommentPart;", "Lcom/qzone/reborn/base/k;", "Lxc/g;", "", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "M9", "initViewModel", "K9", "L9", "N9", "", "Lq5/a;", "quickInputList", "Q9", "I9", "Landroid/graphics/Rect;", "outRect", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "H9", "onInitView", "", "getPageType", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "position", "u7", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "e", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "f", "Landroidx/recyclerview/widget/RecyclerView;", "mQuickInputRv", "Landroid/view/ViewGroup;", tl.h.F, "Landroid/view/ViewGroup;", "mPanelMenuArea", "i", "mPanelInputArea", "Ldd/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ldd/b;", "mInputViewModel", "Lvc/b;", BdhLogUtil.LogTag.Tag_Conn, "Lvc/b;", "mQuickInputAdapter", "", "D", "Z", "mIsSetQuickItemDecoration", "E", "showAIGCComment", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommentPanelQuickCommentPart extends com.qzone.reborn.base.k implements xc.g {
    private static final int G = com.qzone.util.ar.e(12.0f);
    private static final int H = com.qzone.util.ar.e(8.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private vc.b mQuickInputAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsSetQuickItemDecoration;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean showAIGCComment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mQuickInputRv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mPanelMenuArea;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mPanelInputArea;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private dd.b mInputViewModel;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/comment/part/QZoneCommentPanelQuickCommentPart$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            QZoneCommentPanelQuickCommentPart.this.H9(outRect, view, parent);
        }
    }

    public QZoneCommentPanelQuickCommentPart(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(Rect outRect, View view, RecyclerView parent) {
        if (this.mQuickInputAdapter == null) {
            return;
        }
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            outRect.left = G;
            outRect.right = 0;
            return;
        }
        Intrinsics.checkNotNull(this.mQuickInputAdapter);
        if (childAdapterPosition == r0.getItemCount() - 1) {
            outRect.left = H;
            outRect.right = G;
        } else {
            outRect.left = H;
            outRect.right = 0;
        }
    }

    private final void I9(List<? extends q5.a> quickInputList) {
        String str;
        if (this.initParams.getShowQuickComment() != 2 || bl.b(quickInputList)) {
            return;
        }
        QZoneCommentEditText qZoneCommentEditText = this.mEtInput;
        QZoneCommentEditText qZoneCommentEditText2 = null;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        if (TextUtils.isEmpty(qZoneCommentEditText.getText())) {
            Iterator<? extends q5.a> it = quickInputList.iterator();
            while (true) {
                if (it.hasNext()) {
                    q5.a next = it.next();
                    if (next.f428352a == QZoneCommentQuickInputHelper.f44831f) {
                        String a16 = next.a();
                        Intrinsics.checkNotNullExpressionValue(a16, "item.getText()");
                        str = cd.b.c(a16);
                        break;
                    }
                } else {
                    str = "";
                    break;
                }
            }
            QZoneCommentEditText qZoneCommentEditText3 = this.mEtInput;
            if (qZoneCommentEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                qZoneCommentEditText3 = null;
            }
            int selectionStart = qZoneCommentEditText3.getSelectionStart();
            QZoneCommentEditText qZoneCommentEditText4 = this.mEtInput;
            if (qZoneCommentEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            } else {
                qZoneCommentEditText2 = qZoneCommentEditText4;
            }
            com.qzone.util.am.g(str, selectionStart, qZoneCommentEditText2);
        }
    }

    private final void J9() {
        String z06 = com.qzone.reborn.configx.g.f53821a.b().z0();
        if (z06.length() == 0) {
            QLog.i("QZoneCommentPanelQuickCommentPart", 1, "QZone AI Comment Config is empty");
            return;
        }
        try {
            boolean z16 = new JSONObject(z06).getBoolean("enable");
            QLog.i("QZoneCommentPanelQuickCommentPart", 1, "AI Comment Enable: " + z16);
            if (z16) {
                this.showAIGCComment = true;
            }
        } catch (Exception e16) {
            QLog.e("QZoneCommentPanelQuickCommentPart", 1, "Failed to parse AI Comment config: " + e16.getMessage(), e16);
        }
    }

    private final void K9(View rootView) {
        RFWIocAbilityProvider.g().registerIoc(rootView, this, xc.g.class);
    }

    private final void L9() {
        String aiCommentKey = this.initParams.getAiCommentKey();
        QLog.i("QZoneCommentPanelQuickCommentPart", 2, "start to init quick comment, aiFeedKey = " + aiCommentKey);
        if (this.showAIGCComment) {
            if (!(aiCommentKey == null || aiCommentKey.length() == 0)) {
                new zc.a().c(aiCommentKey, new QZoneCommentPanelQuickCommentPart$initQuickComment$1(this));
                return;
            }
        }
        N9();
        QLog.i("QZoneCommentPanelQuickCommentPart", 2, "didn't open AI comment or aiCommentKey is null, load default quick comment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        QZoneCommentQuickInputHelper.n().p(new QZoneCommentQuickInputHelper.a() { // from class: com.qzone.reborn.comment.part.ad
            @Override // com.qzone.business.tianshu.QZoneCommentQuickInputHelper.a
            public final void a(QZoneQuickCommentInfo qZoneQuickCommentInfo) {
                QZoneCommentPanelQuickCommentPart.O9(QZoneCommentPanelQuickCommentPart.this, qZoneQuickCommentInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(final QZoneCommentPanelQuickCommentPart this$0, final QZoneQuickCommentInfo qZoneQuickCommentInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.qzone.reborn.comment.part.ae
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneCommentPanelQuickCommentPart.P9(QZoneCommentPanelQuickCommentPart.this, qZoneQuickCommentInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QZoneCommentPanelQuickCommentPart this$0, QZoneQuickCommentInfo qZoneQuickCommentInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<q5.a> cardList = qZoneQuickCommentInfo.getCardList();
        Intrinsics.checkNotNullExpressionValue(cardList, "commentInfo.getCardList()");
        this$0.Q9(cardList);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
    }

    @Override // xc.g
    public int getPageType() {
        return 2;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        J9();
        M9(rootView);
        K9(rootView);
        initViewModel();
        L9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZoneCommentQuickInputHelper.n().r();
    }

    @Override // xc.g
    public void u7(q5.a item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.b() == QZoneCommentQuickInputHelper.f44832g && !TextUtils.isEmpty(item.c())) {
            yo.d.b(getContext(), new yo.g(item.c()));
            return;
        }
        if ((item.b() == QZoneCommentQuickInputHelper.f44831f || item.b() == QZoneCommentQuickInputHelper.f44833h) && !TextUtils.isEmpty(item.a())) {
            String a16 = item.a();
            Intrinsics.checkNotNullExpressionValue(a16, "item.getText()");
            String c16 = cd.b.c(a16);
            QZoneCommentEditText qZoneCommentEditText = this.mEtInput;
            QZoneCommentEditText qZoneCommentEditText2 = null;
            if (qZoneCommentEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                qZoneCommentEditText = null;
            }
            int selectionStart = qZoneCommentEditText.getSelectionStart();
            QZoneCommentEditText qZoneCommentEditText3 = this.mEtInput;
            if (qZoneCommentEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            } else {
                qZoneCommentEditText2 = qZoneCommentEditText3;
            }
            com.qzone.util.am.g(c16, selectionStart, qZoneCommentEditText2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(List<? extends q5.a> quickInputList) {
        List<? extends q5.a> list = quickInputList;
        if (bl.b(list)) {
            QLog.i("QZoneCommentPanelQuickCommentPart", 1, "[showQuickInputView] no quick input list");
            return;
        }
        RecyclerView recyclerView = this.mQuickInputRv;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQuickInputRv");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        if (!this.mIsSetQuickItemDecoration) {
            this.mIsSetQuickItemDecoration = true;
            RecyclerView recyclerView3 = this.mQuickInputRv;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mQuickInputRv");
                recyclerView3 = null;
            }
            recyclerView3.addItemDecoration(new b());
        }
        this.mQuickInputAdapter = new vc.b();
        RecyclerView recyclerView4 = this.mQuickInputRv;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQuickInputRv");
            recyclerView4 = null;
        }
        recyclerView4.setAdapter(this.mQuickInputAdapter);
        RecyclerView recyclerView5 = this.mQuickInputRv;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQuickInputRv");
        } else {
            recyclerView2 = recyclerView5;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        vc.b bVar = this.mQuickInputAdapter;
        Intrinsics.checkNotNull(bVar);
        bVar.setItems(new ArrayList(list));
        I9(quickInputList);
    }

    private final void M9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        this.mEtInput = (QZoneCommentEditText) findViewById;
        View findViewById2 = rootView.findViewById(R.id.msp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ment_panel_quick_comment)");
        this.mQuickInputRv = (RecyclerView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.msd);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026_comment_panel_menu_area)");
        this.mPanelMenuArea = (ViewGroup) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.msa);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026comment_panel_input_area)");
        this.mPanelInputArea = (ViewGroup) findViewById4;
    }
}
