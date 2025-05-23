package fg3;

import android.graphics.Rect;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.falco.utils.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.cc.ai;
import com.tencent.mobileqq.zplan.cc.util.AIFacePolicyHelper;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.state.report.SquareReportConst;
import fg3.FaceItemData;
import fg3.r;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qshadow.AIFacePtaData$ZplanFaceStyle;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0017\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0004J\u0010\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\"R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\"R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\"R\u0018\u00103\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\"R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00105R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u00107\u001a\u0004\b0\u00108\"\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010<R$\u0010C\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010?\u001a\u0004\b2\u0010@\"\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006I"}, d2 = {"Lfg3/r;", "", "Landroid/view/View;", "view", "", DomainData.DOMAIN_NAME, "", "", "map", "i", "u", "k", "l", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "p", "", "Lqshadow/AIFacePtaData$ZplanFaceStyle;", "list", "", "seqId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/zplan/cc/j;", "f", "y", "", "isAgain", "w", "r", "v", "j", "a", "Landroid/view/View;", "b", "identifyBigLayout", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "faceView", "d", "identifyLayout", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "faceGenerate", "faceInCircleTips", "g", "justThis", tl.h.F, "introductionLayout", "Landroid/widget/CheckBox;", "Landroid/widget/CheckBox;", "box", "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", ReportConstant.COSTREPORT_PREFIX, "(Landroidx/fragment/app/Fragment;)V", "Lfg3/d;", "Lfg3/d;", "aiFaceAdapter", "Lfg3/y;", "Lfg3/y;", "()Lfg3/y;", "t", "(Lfg3/y;)V", "onFilamentCaptureFace", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/cc/j;", "dataManager", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private View identifyBigLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private RecyclerView faceView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View identifyLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView faceGenerate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView faceInCircleTips;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private View justThis;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View introductionLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CheckBox box;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public Fragment fragment;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private d aiFaceAdapter = new d();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private y onFilamentCaptureFace;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.cc.j dataManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"fg3/r$a", "Lcom/tencent/mobileqq/zplan/cc/ai;", "", "c", "Lfg3/l;", "data", "", "index", "a", com.tencent.luggage.wxa.c8.c.G, "d", "b", "traverseExposure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements ai {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(r this$0, int i3) {
            RecyclerView.LayoutManager layoutManager;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            RecyclerView recyclerView = this$0.faceView;
            if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
                return;
            }
            layoutManager.scrollToPosition(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h() {
            VideoReport.traverseExposure();
        }

        @Override // com.tencent.mobileqq.zplan.cc.ai
        public void a(FaceItemData data, int index) {
            Intrinsics.checkNotNullParameter(data, "data");
            y onFilamentCaptureFace = r.this.getOnFilamentCaptureFace();
            if (onFilamentCaptureFace != null) {
                onFilamentCaptureFace.a(data, index);
            }
        }

        @Override // com.tencent.mobileqq.zplan.cc.ai
        public void b(FaceItemData data, int index) {
            Intrinsics.checkNotNullParameter(data, "data");
            y onFilamentCaptureFace = r.this.getOnFilamentCaptureFace();
            if (onFilamentCaptureFace != null) {
                onFilamentCaptureFace.b(data, index);
            }
        }

        @Override // com.tencent.mobileqq.zplan.cc.ai
        public void c() {
            r.this.y();
        }

        @Override // com.tencent.mobileqq.zplan.cc.ai
        public void d(final int pos) {
            RecyclerView recyclerView = r.this.faceView;
            if (recyclerView != null) {
                final r rVar = r.this;
                recyclerView.post(new Runnable() { // from class: fg3.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.a.g(r.this, pos);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.zplan.cc.ai
        public void traverseExposure() {
            View view = r.this.view;
            if (view != null) {
                view.post(new Runnable() { // from class: fg3.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.a.h();
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"fg3/r$b", "Lfg3/x;", "Lfg3/l;", "faceItemData", "", "index", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements x {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(r this$0, int i3) {
            RecyclerView.LayoutManager layoutManager;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            RecyclerView recyclerView = this$0.faceView;
            if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
                return;
            }
            layoutManager.scrollToPosition(i3);
        }

        @Override // fg3.x
        public void a(FaceItemData faceItemData, final int index) {
            Intrinsics.checkNotNullParameter(faceItemData, "faceItemData");
            if (r.this.dataManager.getIsLoading() || faceItemData.getIsSelected()) {
                return;
            }
            QLog.i("_FilamentAIFace", 1, "onItemClicked faceItemData = " + faceItemData + ", index = " + index);
            int type = faceItemData.getType();
            FaceItemData.Companion companion = FaceItemData.INSTANCE;
            if (type == companion.b()) {
                RecyclerView recyclerView = r.this.faceView;
                if (recyclerView != null) {
                    final r rVar = r.this;
                    recyclerView.post(new Runnable() { // from class: fg3.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            r.b.c(r.this, index);
                        }
                    });
                }
                if (!NetworkUtil.isNetworkAvailable()) {
                    QQToast.makeText(BaseApplication.getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                    return;
                }
                r.this.dataManager.c();
                r.this.v();
                y onFilamentCaptureFace = r.this.getOnFilamentCaptureFace();
                if (onFilamentCaptureFace != null) {
                    onFilamentCaptureFace.d();
                    return;
                }
                return;
            }
            if (type == companion.d()) {
                r.this.y();
                r.this.dataManager.d(index);
                y onFilamentCaptureFace2 = r.this.getOnFilamentCaptureFace();
                if (onFilamentCaptureFace2 != null) {
                    onFilamentCaptureFace2.b(faceItemData, index);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"fg3/r$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f398638d;

        c(RecyclerView recyclerView) {
            this.f398638d = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childLayoutPosition = parent.getChildLayoutPosition(view);
            int itemCount = state.getItemCount() - 1;
            outRect.left = UIUtil.dp2px(this.f398638d.getContext(), 8.0f);
            if (childLayoutPosition == 0) {
                outRect.left = UIUtil.dp2px(this.f398638d.getContext(), 16.0f);
            }
            if (childLayoutPosition == itemCount) {
                outRect.right = UIUtil.dp2px(this.f398638d.getContext(), 16.0f);
            }
        }
    }

    public r() {
        com.tencent.mobileqq.zplan.cc.j jVar = new com.tencent.mobileqq.zplan.cc.j();
        jVar.q(this.aiFaceAdapter);
        jVar.s(new a());
        jVar.t(com.tencent.mobileqq.zplan.cc.util.a.f332553a.b());
        this.dataManager = jVar;
    }

    private final void i(Map<String, Object> map) {
        AIFacePtaData$ZplanFaceStyle face2;
        PBStringField pBStringField;
        CheckBox checkBox = this.box;
        int i3 = 0;
        if (checkBox != null && checkBox.isChecked()) {
            i3 = 1;
        }
        map.put(SquareReportConst.Key.KEY_IS_TICK, Integer.valueOf(i3));
        FaceItemData l06 = this.aiFaceAdapter.l0();
        String str = (l06 == null || (face2 = l06.getFace()) == null || (pBStringField = face2.style_id) == null) ? null : pBStringField.get();
        if (str == null) {
            str = "";
        }
        map.put("zplan_style_id", str);
        map.put("zplan_template_num", Integer.valueOf(this.aiFaceAdapter.j0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(r this$0, View view) {
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (textView.getSelectionStart() == -1 && textView.getSelectionEnd() == -1 && (checkBox = this$0.box) != null) {
                checkBox.setChecked(!checkBox.isChecked());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(r this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<FaceItemData> it = this$0.aiFaceAdapter.i0().iterator();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (it.next().getIsSelected()) {
                break;
            } else {
                i3++;
            }
        }
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "gotoPortal = " + i3);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this$0.i(linkedHashMap);
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("dt_clck", view, linkedHashMap);
        CheckBox checkBox = this$0.box;
        if (checkBox != null && checkBox.isChecked()) {
            z16 = true;
        }
        if (z16) {
            y yVar = this$0.onFilamentCaptureFace;
            if (yVar != null) {
                yVar.c(this$0.aiFaceAdapter.l0());
                return;
            }
            return;
        }
        this$0.u();
    }

    private final void u() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 20.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator(3.0f));
        translateAnimation.setDuration(500L);
        View view = this.introductionLayout;
        if (view != null) {
            view.startAnimation(translateAnimation);
        }
    }

    /* renamed from: f, reason: from getter */
    public final com.tencent.mobileqq.zplan.cc.j getDataManager() {
        return this.dataManager;
    }

    public final Fragment g() {
        Fragment fragment = this.fragment;
        if (fragment != null) {
            return fragment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
        return null;
    }

    /* renamed from: h, reason: from getter */
    public final y getOnFilamentCaptureFace() {
        return this.onFilamentCaptureFace;
    }

    public final void j() {
        this.dataManager.g();
    }

    public final View p(Fragment fragment, ViewGroup container) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(container, "container");
        View view = this.view;
        if (view != null) {
            return view;
        }
        s(fragment);
        View inflate = LayoutInflater.from(fragment.getContext()).inflate(R.layout.f167443dc2, container, false);
        this.view = inflate;
        n(inflate);
        k(this.view);
        View view2 = this.view;
        Intrinsics.checkNotNull(view2);
        l(view2);
        return this.view;
    }

    public final void r() {
        View view = this.identifyBigLayout;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.identifyLayout;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        TextView textView = this.faceGenerate;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.faceInCircleTips;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        View view3 = this.justThis;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.introductionLayout;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        RecyclerView recyclerView = this.faceView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(8);
    }

    public final void s(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<set-?>");
        this.fragment = fragment;
    }

    public final void t(y yVar) {
        this.onFilamentCaptureFace = yVar;
    }

    public final void w(boolean isAgain) {
        View view = this.identifyBigLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.identifyLayout;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        TextView textView = this.faceGenerate;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.faceInCircleTips;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        View view3 = this.justThis;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        if (isAgain) {
            View view4 = this.introductionLayout;
            if (view4 != null) {
                view4.setVisibility(0);
            }
        } else {
            View view5 = this.introductionLayout;
            if (view5 != null) {
                view5.setVisibility(8);
            }
        }
        RecyclerView recyclerView = this.faceView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(0);
    }

    public final void y() {
        View view = this.identifyBigLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.identifyLayout;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        TextView textView = this.faceGenerate;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.faceInCircleTips;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        View view3 = this.justThis;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        View view4 = this.introductionLayout;
        if (view4 != null) {
            view4.setVisibility(0);
        }
        RecyclerView recyclerView = this.faceView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(0);
    }

    public final void v() {
        w(true);
        TextView textView = this.faceGenerate;
        if (textView != null) {
            textView.setText(textView.getContext().getText(R.string.xq5));
        }
        TextView textView2 = this.faceInCircleTips;
        if (textView2 != null) {
            textView2.setText(textView2.getContext().getText(R.string.f169810xq2));
        }
    }

    private final void l(View view) {
        this.introductionLayout = view.findViewById(R.id.q2g);
        this.box = (CheckBox) view.findViewById(R.id.q2f);
        TextView textView = (TextView) view.findViewById(R.id.qqi);
        if (textView != null) {
            textView.setText(AIFacePolicyHelper.f332552a.c(g()));
        }
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (textView != null) {
            textView.setHighlightColor(0);
        }
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: fg3.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    r.m(r.this, view2);
                }
            });
        }
    }

    public static /* synthetic */ void x(r rVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        rVar.w(z16);
    }

    public final void q(List<AIFacePtaData$ZplanFaceStyle> list, int seqId) {
        if (list != null) {
            this.dataManager.l(list, seqId);
        } else if (seqId > 0) {
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "onReceiveData , recoveryToAdd");
            this.dataManager.p();
        }
    }

    private final void k(View view) {
        RecyclerView recyclerView = view != null ? (RecyclerView) view.findViewById(R.id.ptj) : null;
        this.faceView = recyclerView;
        if (recyclerView != null) {
            this.aiFaceAdapter.o0(new b());
            recyclerView.setAdapter(this.aiFaceAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.setItemAnimator(null);
            recyclerView.addItemDecoration(new c(recyclerView));
        }
    }

    private final void n(View view) {
        this.identifyBigLayout = view != null ? view.findViewById(R.id.f163422q15) : null;
        this.identifyLayout = view != null ? view.findViewById(R.id.q16) : null;
        this.faceGenerate = view != null ? (TextView) view.findViewById(R.id.pte) : null;
        this.faceInCircleTips = view != null ? (TextView) view.findViewById(R.id.qer) : null;
        View findViewById = view != null ? view.findViewById(R.id.q4d) : null;
        this.justThis = findViewById;
        com.tencent.mobileqq.zplan.report.c cVar = com.tencent.mobileqq.zplan.report.c.f335070a;
        Intrinsics.checkNotNull(findViewById);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        i(linkedHashMap);
        Unit unit = Unit.INSTANCE;
        cVar.b(findViewById, "em_zplan_confirm_template", linkedHashMap);
        View view2 = this.justThis;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: fg3.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    r.o(r.this, view3);
                }
            });
        }
    }
}
