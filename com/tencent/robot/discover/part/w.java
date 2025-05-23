package com.tencent.robot.discover.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0007*\u0001*\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/robot/discover/part/w;", "Lcom/tencent/robot/discover/part/b;", "Lcom/tencent/robot/discover/viewmodel/n;", "", "showSearchContent", "", "M9", "showSearchBar", "N9", "initListener", "L9", "Ljava/lang/Class;", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartPause", "onBackEvent", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "mPageContent", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "mSearchBarContainer", "i", "Landroid/view/View;", "mSearchResultContainer", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "mTroopUin", "", BdhLogUtil.LogTag.Tag_Conn, "I", "mSceneId", "com/tencent/robot/discover/part/w$c", "D", "Lcom/tencent/robot/discover/part/w$c;", "textListener", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class w extends com.tencent.robot.discover.part.b<com.tencent.robot.discover.viewmodel.n> {

    /* renamed from: C, reason: from kotlin metadata */
    private int mSceneId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mPageContent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mSearchBarContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mSearchResultContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTroopUin = "";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c textListener = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/discover/part/w$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 1) {
                w.this.C9();
                w.this.L9();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        if (this.mSceneId == 1) {
            return;
        }
        N9(false);
        M9(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(boolean showSearchContent) {
        RecyclerView recyclerView = null;
        if (showSearchContent) {
            View view = this.mSearchResultContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSearchResultContainer");
                view = null;
            }
            view.setVisibility(0);
            RecyclerView recyclerView2 = this.mPageContent;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPageContent");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
            return;
        }
        View view2 = this.mSearchResultContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultContainer");
            view2 = null;
        }
        view2.setVisibility(8);
        RecyclerView recyclerView3 = this.mPageContent;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageContent");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.setVisibility(0);
    }

    private final void N9(boolean showSearchBar) {
        LinearLayout linearLayout = null;
        if (showSearchBar) {
            LinearLayout linearLayout2 = this.mSearchBarContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSearchBarContainer");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(0);
            return;
        }
        LinearLayout linearLayout3 = this.mSearchBarContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchBarContainer");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setVisibility(8);
    }

    private final void initListener() {
        QuickPinyinEditText inputWidget = z9().getInputWidget();
        if (inputWidget != null) {
            inputWidget.addTextChangedListener(this.textListener);
        }
        z9().setActionCallback(new a());
    }

    @Override // com.tencent.robot.discover.part.b
    @NotNull
    public Class<com.tencent.robot.discover.viewmodel.n> B9() {
        return com.tencent.robot.discover.viewmodel.n.class;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        Editable text;
        Editable text2;
        boolean z16;
        QuickPinyinEditText inputWidget = z9().getInputWidget();
        boolean z17 = false;
        if (inputWidget != null && (text2 = inputWidget.getText()) != null) {
            if (text2.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            QuickPinyinEditText inputWidget2 = z9().getInputWidget();
            if (inputWidget2 != null && (text = inputWidget2.getText()) != null) {
                text.clear();
            }
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.robot.discover.part.b, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f765441y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026t_discovery_recyclerview)");
        this.mPageContent = (RecyclerView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f7658422);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026_discovery_search_result)");
        this.mSearchResultContainer = findViewById2;
        z9().getInputWidget().setHint(rootView.getResources().getString(R.string.f223096fa));
        View findViewById3 = rootView.findViewById(R.id.f7657421);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026scovery_search_container)");
        this.mSearchBarContainer = (LinearLayout) findViewById3;
        initListener();
        RecyclerView recyclerView = null;
        if (this.mSceneId == 1) {
            N9(true);
            com.tencent.robot.discover.part.b.F9(this, 0L, 1, null);
            z9().updateStyle(3);
            z9().bindSearchChain(false);
        }
        RecyclerView recyclerView2 = this.mPageContent;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageContent");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.addOnScrollListener(new b());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String stringExtra = activity.getIntent().getStringExtra("troop_uin");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mTroopUin = stringExtra;
        this.mSceneId = activity.getIntent().getIntExtra("scene_id", 0);
    }

    @Override // com.tencent.robot.discover.part.b, com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        Editable editable;
        boolean z16;
        super.onPartPause(activity);
        QuickPinyinEditText inputWidget = z9().getInputWidget();
        if (inputWidget != null) {
            editable = inputWidget.getText();
        } else {
            editable = null;
        }
        if (editable != null && editable.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            L9();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/discover/part/w$a", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "", "onCancel", "", "onClear", "onBack", "", "onSearch", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements QUISearchBar.ActionCallback {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[RETURN] */
        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onBack() {
            boolean z16;
            Editable text;
            Editable text2;
            boolean z17;
            QuickPinyinEditText inputWidget = w.this.z9().getInputWidget();
            if (inputWidget != null && (text2 = inputWidget.getText()) != null) {
                if (text2.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (z16) {
                        return false;
                    }
                    QuickPinyinEditText inputWidget2 = w.this.z9().getInputWidget();
                    if (inputWidget2 != null && (text = inputWidget2.getText()) != null) {
                        text.clear();
                    }
                    w.this.C9();
                    return true;
                }
            }
            z16 = false;
            if (z16) {
            }
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            Editable text;
            QuickPinyinEditText inputWidget = w.this.z9().getInputWidget();
            if (inputWidget != null && (text = inputWidget.getText()) != null) {
                text.clear();
            }
            w.this.L9();
            if (w.this.mSceneId == 1) {
                w.this.getActivity().finish();
            }
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            w.this.M9(false);
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/robot/discover/part/w$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            MutableLiveData<Integer> R1;
            MutableLiveData<Integer> R12;
            if (TextUtils.isEmpty(s16)) {
                w.this.M9(false);
                com.tencent.robot.discover.viewmodel.n A9 = w.this.A9();
                if (A9 != null && (R12 = A9.R1()) != null) {
                    Integer value = R12.getValue();
                    Intrinsics.checkNotNull(value);
                    R12.setValue(Integer.valueOf(0 | (value.intValue() & (-2))));
                    return;
                }
                return;
            }
            w.this.M9(true);
            com.tencent.robot.discover.viewmodel.n A92 = w.this.A9();
            if (A92 != null && (R1 = A92.R1()) != null) {
                Integer value2 = R1.getValue();
                Intrinsics.checkNotNull(value2);
                R1.setValue(Integer.valueOf(1 | (value2.intValue() & (-2))));
            }
            com.tencent.robot.discover.viewmodel.n A93 = w.this.A9();
            if (A93 != null) {
                A93.X1(String.valueOf(s16), w.this.mTroopUin, w.this.mSceneId);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }
    }
}
