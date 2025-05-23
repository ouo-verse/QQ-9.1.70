package com.tencent.mobileqq.selectfriend.part;

import android.content.ComponentCallbacks2;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/SelectedAndSearchBarPart;", "Lcom/tencent/mobileqq/selectfriend/part/a;", "", "ha", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "ba", "initViewModel", "onInitView", "Landroid/view/inputmethod/InputMethodManager;", "H", "Landroid/view/inputmethod/InputMethodManager;", "mImm", "Lcom/tencent/mobileqq/selectmember/SelectedAndSearchBar;", "I", "Lcom/tencent/mobileqq/selectmember/SelectedAndSearchBar;", "mSelectedAndSearchBar", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "J", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "mFaceDecoder", "Lcom/tencent/mobileqq/search/view/f;", "K", "Lcom/tencent/mobileqq/search/view/f;", "mSearchFragment", "Lcom/tencent/mobileqq/selectmember/SelectedAndSearchBar$i;", "L", "Lcom/tencent/mobileqq/selectmember/SelectedAndSearchBar$i;", "mSelectedAndSearchBarCallback", "Lcom/tencent/mobileqq/search/view/d;", "M", "Lcom/tencent/mobileqq/search/view/d;", "mOnActionListener", "<init>", "()V", "N", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SelectedAndSearchBarPart extends a {

    /* renamed from: H, reason: from kotlin metadata */
    private InputMethodManager mImm;

    /* renamed from: I, reason: from kotlin metadata */
    private SelectedAndSearchBar mSelectedAndSearchBar;

    /* renamed from: J, reason: from kotlin metadata */
    private IFaceDecoder mFaceDecoder;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.search.view.f mSearchFragment;

    /* renamed from: L, reason: from kotlin metadata */
    private SelectedAndSearchBar.i mSelectedAndSearchBarCallback = new b();

    /* renamed from: M, reason: from kotlin metadata */
    private final com.tencent.mobileqq.search.view.d mOnActionListener = new com.tencent.mobileqq.search.view.d() { // from class: com.tencent.mobileqq.selectfriend.part.ac
        @Override // com.tencent.mobileqq.search.view.d
        public final void onAction(View view) {
            SelectedAndSearchBarPart.ga(SelectedAndSearchBarPart.this, view);
        }

        @Override // com.tencent.mobileqq.search.view.d
        public /* synthetic */ void selectedItemClick(String str, int i3, boolean z16) {
            com.tencent.mobileqq.search.view.c.a(this, str, i3, z16);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(SelectedAndSearchBarPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dq2.b E9 = this$0.E9();
        boolean z16 = false;
        if (E9 != null && E9.c2()) {
            z16 = true;
        }
        if (z16) {
            this$0.L9("0X800C01B");
        } else {
            this$0.L9("0X800C012");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void ga(SelectedAndSearchBarPart this$0, View view) {
        String str;
        MutableLiveData<Boolean> c26;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = view.getTag(R.id.kxb);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.search.model.IContactSearchModel");
        com.tencent.mobileqq.search.model.k kVar = (com.tencent.mobileqq.search.model.k) tag;
        String uin = kVar.getUin();
        String obj = kVar.getTitle().toString();
        int i3 = 3000;
        boolean z16 = false;
        if (kVar instanceof com.tencent.mobileqq.search.model.m) {
            str = ((com.tencent.mobileqq.search.model.m) kVar).d();
            Intrinsics.checkNotNullExpressionValue(str, "model.discussionUin");
        } else if (kVar instanceof com.tencent.mobileqq.search.model.l) {
            str = kVar.getUin();
            Intrinsics.checkNotNullExpressionValue(str, "model.uin");
        } else {
            if (kVar instanceof com.tencent.mobileqq.search.model.o) {
                str = kVar.getUin();
                Intrinsics.checkNotNullExpressionValue(str, "model.uin");
            } else if (kVar instanceof com.tencent.mobileqq.search.model.r) {
                str = ((com.tencent.mobileqq.search.model.r) kVar).a().troopuin;
                Intrinsics.checkNotNullExpressionValue(str, "model.troopInfo.troopuin");
            } else if (kVar instanceof com.tencent.mobileqq.search.model.n) {
                str = "-1";
                i3 = 0;
            } else {
                i3 = -1;
                str = "-1";
            }
            i3 = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SelectedAndSearchBarPart", 2, "onAction, uin = " + uin + ", displayName = " + obj + ", troopUin = " + str + ", type = " + i3);
        }
        dq2.b E9 = this$0.E9();
        if (E9 != null && E9.c2()) {
            z16 = true;
        }
        if (!z16) {
            if (TextUtils.isEmpty(uin)) {
                return;
            }
            new ForwardRecentItemView(this$0.getContext()).G = obj;
            ResultRecord resultRecord = new ResultRecord();
            resultRecord.uinType = i3;
            resultRecord.uin = uin;
            resultRecord.groupUin = str;
            resultRecord.guildId = "";
            resultRecord.name = obj;
            dq2.a B9 = this$0.B9();
            if (B9 != null) {
                B9.u2(resultRecord);
            }
            dq2.a B92 = this$0.B9();
            if (B92 != null && (c26 = B92.c2()) != null) {
                c26.postValue(Boolean.TRUE);
            }
        }
        this$0.ha();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha() {
        MutableLiveData<Boolean> L1;
        InputMethodManager inputMethodManager = this.mImm;
        SelectedAndSearchBar selectedAndSearchBar = null;
        if (inputMethodManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImm");
            inputMethodManager = null;
        }
        inputMethodManager.hideSoftInputFromWindow(getActivity().getWindow().peekDecorView().getWindowToken(), 0);
        SelectedAndSearchBar selectedAndSearchBar2 = this.mSelectedAndSearchBar;
        if (selectedAndSearchBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectedAndSearchBar");
            selectedAndSearchBar2 = null;
        }
        selectedAndSearchBar2.u();
        SelectedAndSearchBar selectedAndSearchBar3 = this.mSelectedAndSearchBar;
        if (selectedAndSearchBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectedAndSearchBar");
        } else {
            selectedAndSearchBar = selectedAndSearchBar3;
        }
        selectedAndSearchBar.v();
        dq2.f G9 = G9();
        if (G9 == null || (L1 = G9.L1()) == null) {
            return;
        }
        L1.postValue(Boolean.FALSE);
    }

    private final void initViewModel() {
        MutableLiveData<Boolean> U1;
        MutableLiveData<Boolean> L1;
        dq2.g H9 = H9();
        if (H9 != null && (L1 = H9.L1()) != null) {
            ComponentCallbacks2 activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.SelectedAndSearchBarPart$initViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean add) {
                    SelectedAndSearchBar selectedAndSearchBar;
                    SelectedAndSearchBar selectedAndSearchBar2;
                    LinkedHashMap<String, ResultRecord> U12;
                    selectedAndSearchBar = SelectedAndSearchBarPart.this.mSelectedAndSearchBar;
                    if (selectedAndSearchBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelectedAndSearchBar");
                    }
                    selectedAndSearchBar2 = SelectedAndSearchBarPart.this.mSelectedAndSearchBar;
                    Collection<ResultRecord> collection = null;
                    if (selectedAndSearchBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelectedAndSearchBar");
                        selectedAndSearchBar2 = null;
                    }
                    dq2.a B9 = SelectedAndSearchBarPart.this.B9();
                    if (B9 != null && (U12 = B9.U1()) != null) {
                        collection = U12.values();
                    }
                    ArrayList arrayList = new ArrayList(collection);
                    Intrinsics.checkNotNullExpressionValue(add, "add");
                    selectedAndSearchBar2.H(arrayList, add.booleanValue());
                }
            };
            L1.observe((LifecycleOwner) activity, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.ae
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SelectedAndSearchBarPart.da(Function1.this, obj);
                }
            });
        }
        dq2.b E9 = E9();
        if (E9 == null || (U1 = E9.U1()) == null) {
            return;
        }
        ComponentCallbacks2 activity2 = getActivity();
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.SelectedAndSearchBarPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                SelectedAndSearchBarPart.this.ha();
            }
        };
        U1.observe((LifecycleOwner) activity2, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SelectedAndSearchBarPart.ea(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ba(rootView);
        initViewModel();
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/selectfriend/part/SelectedAndSearchBarPart$b", "Lcom/tencent/mobileqq/selectmember/SelectedAndSearchBar$i;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "resultRecord", "", "a", "", "hasFocus", "b", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "afterTextChanged", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements SelectedAndSearchBar.i {
        b() {
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void a(ResultRecord resultRecord) {
            MutableLiveData<Boolean> e26;
            Intrinsics.checkNotNullParameter(resultRecord, "resultRecord");
            dq2.a B9 = SelectedAndSearchBarPart.this.B9();
            if (B9 != null) {
                String str = resultRecord.uin;
                Intrinsics.checkNotNullExpressionValue(str, "resultRecord.uin");
                B9.v2(str, resultRecord.getUinType());
            }
            dq2.a B92 = SelectedAndSearchBarPart.this.B9();
            if (B92 == null || (e26 = B92.e2()) == null) {
                return;
            }
            e26.postValue(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void afterTextChanged(Editable s16) {
            MutableLiveData<Integer> N1;
            MutableLiveData<String> O1;
            MutableLiveData<Boolean> S1;
            MutableLiveData<Boolean> L1;
            MutableLiveData<String> O12;
            MutableLiveData<Boolean> S12;
            MutableLiveData<Boolean> L12;
            Intrinsics.checkNotNullParameter(s16, "s");
            String obj = s16.toString();
            if (SelectedAndSearchBarPart.this.G9() == null || SelectedAndSearchBarPart.this.E9() == null) {
                return;
            }
            boolean z16 = false;
            if (TextUtils.isEmpty(obj)) {
                dq2.f G9 = SelectedAndSearchBarPart.this.G9();
                if (G9 != null && (L12 = G9.L1()) != null) {
                    L12.postValue(Boolean.FALSE);
                }
                dq2.b E9 = SelectedAndSearchBarPart.this.E9();
                if (E9 != null && E9.c2()) {
                    dq2.b E92 = SelectedAndSearchBarPart.this.E9();
                    if (E92 != null && (S12 = E92.S1()) != null) {
                        S12.postValue(Boolean.TRUE);
                    }
                    dq2.g H9 = SelectedAndSearchBarPart.this.H9();
                    if (H9 != null) {
                        H9.N1(false);
                    }
                    dq2.b E93 = SelectedAndSearchBarPart.this.E9();
                    if (E93 != null && (O12 = E93.O1()) != null) {
                        O12.postValue(HardCodeUtil.qqStr(R.string.mpt));
                    }
                }
            } else {
                dq2.f G92 = SelectedAndSearchBarPart.this.G9();
                if (G92 != null && (L1 = G92.L1()) != null) {
                    L1.postValue(Boolean.TRUE);
                }
                dq2.b E94 = SelectedAndSearchBarPart.this.E9();
                if (E94 != null && !E94.c2()) {
                    z16 = true;
                }
                if (z16) {
                    dq2.b E95 = SelectedAndSearchBarPart.this.E9();
                    if (E95 != null && (S1 = E95.S1()) != null) {
                        S1.postValue(Boolean.FALSE);
                    }
                    dq2.g H92 = SelectedAndSearchBarPart.this.H9();
                    if (H92 != null) {
                        H92.N1(true);
                    }
                    dq2.b E96 = SelectedAndSearchBarPart.this.E9();
                    if (E96 != null && (O1 = E96.O1()) != null) {
                        O1.postValue("");
                    }
                    dq2.b E97 = SelectedAndSearchBarPart.this.E9();
                    if (E97 != null && (N1 = E97.N1()) != null) {
                        N1.postValue(Integer.valueOf(R.drawable.top_back_left_selector));
                    }
                }
            }
            if (SelectedAndSearchBarPart.this.mSearchFragment != null) {
                com.tencent.mobileqq.search.view.f fVar = SelectedAndSearchBarPart.this.mSearchFragment;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSearchFragment");
                    fVar = null;
                }
                fVar.startSearch(obj);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void b(boolean hasFocus) {
            if (hasFocus && SelectedAndSearchBarPart.this.mSearchFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSearchFragment");
            }
        }
    }

    private final void ba(View rootView) {
        if (rootView == null) {
            return;
        }
        Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        this.mImm = (InputMethodManager) systemService;
        View findViewById = rootView.findViewById(R.id.ot8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.selected_and_search_bar)");
        SelectedAndSearchBar selectedAndSearchBar = (SelectedAndSearchBar) findViewById;
        this.mSelectedAndSearchBar = selectedAndSearchBar;
        if (selectedAndSearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectedAndSearchBar");
        }
        SelectedAndSearchBar selectedAndSearchBar2 = this.mSelectedAndSearchBar;
        SelectedAndSearchBar selectedAndSearchBar3 = null;
        if (selectedAndSearchBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectedAndSearchBar");
            selectedAndSearchBar2 = null;
        }
        selectedAndSearchBar2.r(0L);
        SelectedAndSearchBar selectedAndSearchBar4 = this.mSelectedAndSearchBar;
        if (selectedAndSearchBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectedAndSearchBar");
        } else {
            selectedAndSearchBar3 = selectedAndSearchBar4;
        }
        selectedAndSearchBar3.o(new View.OnClickListener() { // from class: com.tencent.mobileqq.selectfriend.part.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectedAndSearchBarPart.ca(SelectedAndSearchBarPart.this, view);
            }
        });
        if (this.mFaceDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFaceDecoder");
        }
    }
}
