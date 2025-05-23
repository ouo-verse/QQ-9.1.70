package com.tencent.mobileqq.troop.homework.coursemgr.fragment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.coursemgr.ui.TroopHwCourseFloatingView;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseContainerPart;", "Lcom/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseBasePart;", "", "P9", "T9", "Landroid/view/View;", "S9", "V9", "", "isAddCourseState", "X9", "", "O9", "U9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "getDefaultHeight", "N9", "Lcom/tencent/mobileqq/troop/homework/coursemgr/ui/TroopHwCourseFloatingView;", "f", "Lcom/tencent/mobileqq/troop/homework/coursemgr/ui/TroopHwCourseFloatingView;", "floatingContainer", tl.h.F, "Landroid/view/View;", "contentView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "headerTitleTv", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "headerCloseIcon", BdhLogUtil.LogTag.Tag_Conn, "headerBackIcon", "D", "headerAddBtn", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "courseRecyclerView", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "courseAddContainer", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "G", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "addCourseInput", "<init>", "()V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopHwCourseContainerPart extends TroopHwCourseBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView headerBackIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView headerAddBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView courseRecyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout courseAddContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private QUISingleLineInputView addCourseInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TroopHwCourseFloatingView floatingContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView headerTitleTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView headerCloseIcon;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseContainerPart$a;", "", "", "MIN_FLOATING_VIEW_TOP_MARGIN_DP", UserInfo.SEX_FEMALE, "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.coursemgr.fragment.TroopHwCourseContainerPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseContainerPart$b", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$o;", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements QUSBaseHalfScreenFloatingView.o {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHwCourseContainerPart.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(@Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                TroopHwCourseFloatingView troopHwCourseFloatingView = TroopHwCourseContainerPart.this.floatingContainer;
                if (troopHwCourseFloatingView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
                    troopHwCourseFloatingView = null;
                }
                troopHwCourseFloatingView.t();
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3)).booleanValue();
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseContainerPart$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "initState", NodeProps.MAX_HEIGHT, "defaultHeight", "", HippyTKDListViewAdapter.X, "y", "", "canScrollUp", "canScrollDown", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHwCourseContainerPart.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return TroopHwCourseContainerPart.this.contentView;
            }
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        /* renamed from: defaultHeight */
        public int getF57420e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            int defaultHeight = TroopHwCourseContainerPart.this.getDefaultHeight();
            if (TroopHwCourseContainerPart.this.E9().Z1()) {
                defaultHeight = Math.max(defaultHeight, TroopHwCourseContainerPart.this.N9());
            }
            if (defaultHeight > 0) {
                return Math.min(defaultHeight, TroopHwCourseContainerPart.this.O9());
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return TroopHwCourseContainerPart.this.O9();
            }
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50634);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopHwCourseContainerPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int O9() {
        return x.f(getActivity()).a() - B9(105.0f);
    }

    private final void P9() {
        LayoutInflater from = LayoutInflater.from(getContext());
        TroopHwCourseFloatingView troopHwCourseFloatingView = this.floatingContainer;
        ImageView imageView = null;
        if (troopHwCourseFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView = null;
        }
        View inflate = from.inflate(R.layout.g0d, (ViewGroup) troopHwCourseFloatingView, false);
        TroopHwCourseFloatingView troopHwCourseFloatingView2 = this.floatingContainer;
        if (troopHwCourseFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView2 = null;
        }
        troopHwCourseFloatingView2.setHeaderView(inflate);
        View findViewById = inflate.findViewById(R.id.f102055wv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "headerView.findViewById(\u2026p_hw_course_header_title)");
        this.headerTitleTv = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f102045wu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "headerView.findViewById(\u2026course_header_close_icon)");
        ImageView imageView2 = (ImageView) findViewById2;
        this.headerCloseIcon = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerCloseIcon");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopHwCourseContainerPart.Q9(TroopHwCourseContainerPart.this, view);
            }
        });
        View findViewById3 = inflate.findViewById(R.id.f102035wt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "headerView.findViewById(\u2026_course_header_back_icon)");
        ImageView imageView3 = (ImageView) findViewById3;
        this.headerBackIcon = imageView3;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerBackIcon");
        } else {
            imageView = imageView3;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopHwCourseContainerPart.R9(TroopHwCourseContainerPart.this, view);
            }
        });
        View findViewById4 = inflate.findViewById(R.id.f102025ws);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "headerView.findViewById(\u2026hw_course_header_add_btn)");
        this.headerAddBtn = (TextView) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(TroopHwCourseContainerPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TroopHwCourseFloatingView troopHwCourseFloatingView = this$0.floatingContainer;
        if (troopHwCourseFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView = null;
        }
        troopHwCourseFloatingView.t();
        this$0.F9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(TroopHwCourseContainerPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9();
        this$0.E9().N1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final View S9() {
        LayoutInflater from = LayoutInflater.from(getContext());
        TroopHwCourseFloatingView troopHwCourseFloatingView = this.floatingContainer;
        if (troopHwCourseFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView = null;
        }
        View inflate = from.inflate(R.layout.g0b, (ViewGroup) troopHwCourseFloatingView, false);
        this.contentView = inflate;
        if (inflate != null) {
            View findViewById = inflate.findViewById(R.id.f102085wy);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.tro\u2026ourse_list_recycler_view)");
            this.courseRecyclerView = (RecyclerView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.sd5);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.add_course_layout_container)");
            this.courseAddContainer = (LinearLayout) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.f102015wr);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.troop_hw_course_add_input)");
            this.addCourseInput = (QUISingleLineInputView) findViewById3;
        }
        return this.contentView;
    }

    private final void T9() {
        TroopHwCourseFloatingView troopHwCourseFloatingView = this.floatingContainer;
        TroopHwCourseFloatingView troopHwCourseFloatingView2 = null;
        if (troopHwCourseFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView = null;
        }
        troopHwCourseFloatingView.setOnOutsideAreaClickListener(new b());
        TroopHwCourseFloatingView troopHwCourseFloatingView3 = this.floatingContainer;
        if (troopHwCourseFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView3 = null;
        }
        troopHwCourseFloatingView3.setQUSDragFloatController(new c());
        TroopHwCourseFloatingView troopHwCourseFloatingView4 = this.floatingContainer;
        if (troopHwCourseFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
        } else {
            troopHwCourseFloatingView2 = troopHwCourseFloatingView4;
        }
        troopHwCourseFloatingView2.setOnDismissListener(D9());
    }

    private final void U9() {
        Activity activity;
        if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null) && (activity = getActivity()) != null) {
            RFWThemeUtil.setNavigationBarColor(activity, activity.getColor(R.color.qui_common_bg_bottom_standard));
        }
    }

    private final void V9() {
        LiveData<com.tencent.mobileqq.troop.homework.coursemgr.intent.c> T1 = E9().T1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.coursemgr.intent.c, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.coursemgr.intent.c, Unit>() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.TroopHwCourseContainerPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHwCourseContainerPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.coursemgr.intent.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.coursemgr.intent.c cVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                } else if (cVar instanceof com.tencent.mobileqq.troop.homework.coursemgr.intent.e) {
                    TroopHwCourseContainerPart.this.X9(((com.tencent.mobileqq.troop.homework.coursemgr.intent.e) cVar).a() == 2);
                }
            }
        };
        T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopHwCourseContainerPart.W9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(boolean isAddCourseState) {
        TroopHwCourseFloatingView troopHwCourseFloatingView = null;
        if (isAddCourseState) {
            TextView textView = this.headerTitleTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerTitleTv");
                textView = null;
            }
            textView.setText(R.string.f23415797);
            ImageView imageView = this.headerBackIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerBackIcon");
                imageView = null;
            }
            imageView.setVisibility(0);
            TextView textView2 = this.headerAddBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerAddBtn");
                textView2 = null;
            }
            textView2.setVisibility(0);
            ImageView imageView2 = this.headerCloseIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerCloseIcon");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            LinearLayout linearLayout = this.courseAddContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("courseAddContainer");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
            RecyclerView recyclerView = this.courseRecyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("courseRecyclerView");
                recyclerView = null;
            }
            recyclerView.setVisibility(4);
            QUISingleLineInputView qUISingleLineInputView = this.addCourseInput;
            if (qUISingleLineInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addCourseInput");
                qUISingleLineInputView = null;
            }
            qUISingleLineInputView.requestFocus();
            QUISingleLineInputView qUISingleLineInputView2 = this.addCourseInput;
            if (qUISingleLineInputView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addCourseInput");
                qUISingleLineInputView2 = null;
            }
            InputMethodUtil.show(qUISingleLineInputView2.h());
        } else {
            TextView textView3 = this.headerTitleTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerTitleTv");
                textView3 = null;
            }
            textView3.setText(R.string.f23416798);
            ImageView imageView3 = this.headerBackIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerBackIcon");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
            TextView textView4 = this.headerAddBtn;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerAddBtn");
                textView4 = null;
            }
            textView4.setVisibility(8);
            ImageView imageView4 = this.headerCloseIcon;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerCloseIcon");
                imageView4 = null;
            }
            imageView4.setVisibility(0);
            LinearLayout linearLayout2 = this.courseAddContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("courseAddContainer");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
            QUISingleLineInputView qUISingleLineInputView3 = this.addCourseInput;
            if (qUISingleLineInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addCourseInput");
                qUISingleLineInputView3 = null;
            }
            qUISingleLineInputView3.setContentText("");
            RecyclerView recyclerView2 = this.courseRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("courseRecyclerView");
                recyclerView2 = null;
            }
            recyclerView2.setVisibility(0);
        }
        TroopHwCourseFloatingView troopHwCourseFloatingView2 = this.floatingContainer;
        if (troopHwCourseFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
        } else {
            troopHwCourseFloatingView = troopHwCourseFloatingView2;
        }
        troopHwCourseFloatingView.T();
    }

    public final int N9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        TroopHwCourseFloatingView troopHwCourseFloatingView = this.floatingContainer;
        if (troopHwCourseFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView = null;
        }
        return troopHwCourseFloatingView.S() + C9(R.dimen.dgs) + C9(R.dimen.dgt);
    }

    public final int getDefaultHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int P1 = E9().P1();
        if (!E9().b2()) {
            P1++;
        }
        int C9 = C9(R.dimen.dgv) * P1;
        TroopHwCourseFloatingView troopHwCourseFloatingView = this.floatingContainer;
        if (troopHwCourseFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView = null;
        }
        return troopHwCourseFloatingView.S() + C9 + C9(R.dimen.dgt);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        if (rootView == null) {
            A9();
            return;
        }
        U9();
        View findViewById = rootView.findViewById(R.id.f66743bg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qus_half_screen_view)");
        this.floatingContainer = (TroopHwCourseFloatingView) findViewById;
        P9();
        S9();
        T9();
        V9();
    }
}
