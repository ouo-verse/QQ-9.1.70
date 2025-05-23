package com.tencent.mobileqq.zplan.friend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0002OPB\u0007\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J*\u0010\u001b\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J*\u0010\u001d\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u001eH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0016\u00109\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00100R\u0016\u0010;\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u00100R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR0\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/ZPlanFriendSearchFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Landroid/text/TextWatcher;", "", "initViewModel", "", "searchText", "Ch", "wh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "Lcom/tencent/common/app/AppInterface;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/zplan/friend/FriendViewModel;", "D", "Lcom/tencent/mobileqq/zplan/friend/FriendViewModel;", "friendViewModel", "", "Lcom/tencent/mobileqq/zplan/friend/c;", "E", "Ljava/util/List;", "allFriendList", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "G", "Landroid/view/View;", "btnCancel", "Landroid/widget/EditText;", "H", "Landroid/widget/EditText;", "searchBox", "I", "btnClear", "J", "emptyNotice", "K", "searchListContainer", "Landroidx/recyclerview/widget/RecyclerView;", "L", "Landroidx/recyclerview/widget/RecyclerView;", "searchList", "Lcom/tencent/mobileqq/zplan/friend/k;", "M", "Lcom/tencent/mobileqq/zplan/friend/k;", "searchListAdapter", "Lkotlin/Function1;", "N", "Lkotlin/jvm/functions/Function1;", "vh", "()Lkotlin/jvm/functions/Function1;", "Bh", "(Lkotlin/jvm/functions/Function1;)V", "onFriendAddCallback", "<init>", "()V", "P", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFriendSearchFragment extends QBaseFragment implements TextWatcher {

    /* renamed from: C, reason: from kotlin metadata */
    private AppInterface app;

    /* renamed from: D, reason: from kotlin metadata */
    private FriendViewModel friendViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private List<FriendInfo> allFriendList;

    /* renamed from: F, reason: from kotlin metadata */
    private String searchText;

    /* renamed from: G, reason: from kotlin metadata */
    private View btnCancel;

    /* renamed from: H, reason: from kotlin metadata */
    private EditText searchBox;

    /* renamed from: I, reason: from kotlin metadata */
    private View btnClear;

    /* renamed from: J, reason: from kotlin metadata */
    private View emptyNotice;

    /* renamed from: K, reason: from kotlin metadata */
    private View searchListContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private RecyclerView searchList;

    /* renamed from: M, reason: from kotlin metadata */
    private k searchListAdapter;

    /* renamed from: N, reason: from kotlin metadata */
    private Function1<? super String, Unit> onFriendAddCallback;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u001c\u0010\u001dJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/ZPlanFriendSearchFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDrawOver", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "e", "I", "leftInset", "Landroid/graphics/Rect;", "f", "Landroid/graphics/Rect;", "outBounds", "Landroid/graphics/drawable/ColorDrawable;", tl.h.F, "Landroid/graphics/drawable/ColorDrawable;", "drawable", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Context context;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int leftInset;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final Rect outBounds;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final ColorDrawable drawable;

        public b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.leftInset = (int) TypedValue.applyDimension(1, 19.0f, context.getResources().getDisplayMetrics());
            this.outBounds = new Rect();
            this.drawable = new ColorDrawable(Color.parseColor("#eeeeee"));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas c16, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(c16, "c");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int paddingLeft = this.leftInset + parent.getPaddingLeft();
            int width = parent.getWidth() - parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                parent.getDecoratedBoundsWithMargins(parent.getChildAt(i3), this.outBounds);
                int i16 = this.outBounds.top;
                int i17 = i16 + 1;
                QLog.i("ZPlanFriendSearchFragment", 1, "onDrawOver, left = " + paddingLeft + ", top = " + i16 + ", right = " + width + ", bottom = " + i17);
                this.drawable.setBounds(paddingLeft, i16, width, i17);
                this.drawable.draw(c16);
            }
        }
    }

    public ZPlanFriendSearchFragment() {
        List<FriendInfo> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.allFriendList = emptyList;
        this.searchText = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(ZPlanFriendSearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.searchBox;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            editText = null;
        }
        editText.setText((CharSequence) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0054 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Ch(String searchText) {
        byte b16;
        byte b17;
        boolean contains$default;
        QLog.i("ZPlanFriendSearchFragment", 1, "update search text to " + searchText);
        k kVar = null;
        View view = null;
        if ((searchText.length() == 0) != false) {
            View view2 = this.emptyNotice;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyNotice");
                view2 = null;
            }
            view2.setVisibility(8);
            View view3 = this.searchListContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchListContainer");
            } else {
                view = view3;
            }
            view.setVisibility(8);
        } else {
            List<FriendInfo> list = this.allFriendList;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                FriendInfo friendInfo = (FriendInfo) obj;
                FriendViewModel friendViewModel = this.friendViewModel;
                if (friendViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
                    friendViewModel = null;
                }
                if (!friendViewModel.S1(friendInfo.getUin())) {
                    String name = friendInfo.getName();
                    if (name != null) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) searchText, false, 2, (Object) null);
                        if (contains$default) {
                            b17 = true;
                            if (b17 != false) {
                                b16 = true;
                                if (b16 == false) {
                                    arrayList.add(obj);
                                }
                            }
                        }
                    }
                    b17 = false;
                    if (b17 != false) {
                    }
                }
                b16 = false;
                if (b16 == false) {
                }
            }
            View view4 = this.emptyNotice;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyNotice");
                view4 = null;
            }
            view4.setVisibility(arrayList.isEmpty() ? 0 : 8);
            View view5 = this.searchListContainer;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchListContainer");
                view5 = null;
            }
            view5.setVisibility(arrayList.isEmpty() ? 8 : 0);
            k kVar2 = this.searchListAdapter;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchListAdapter");
            } else {
                kVar = kVar2;
            }
            kVar.l0(arrayList);
        }
        this.searchText = searchText;
    }

    private final void initViewModel() {
        FragmentActivity requireActivity = requireActivity();
        AppInterface appInterface = this.app;
        FriendViewModel friendViewModel = null;
        if (appInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("app");
            appInterface = null;
        }
        ViewModel viewModel = new ViewModelProvider(requireActivity, new n(appInterface)).get(FriendViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026endViewModel::class.java]");
        FriendViewModel friendViewModel2 = (FriendViewModel) viewModel;
        this.friendViewModel = friendViewModel2;
        if (friendViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
        } else {
            friendViewModel = friendViewModel2;
        }
        friendViewModel.O1().observe(requireActivity(), new Observer() { // from class: com.tencent.mobileqq.zplan.friend.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanFriendSearchFragment.xh(ZPlanFriendSearchFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh() {
        Context context = getContext();
        EditText editText = null;
        Object systemService = context != null ? context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            EditText editText2 = this.searchBox;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            } else {
                editText = editText2;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(ZPlanFriendSearchFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(list, "list");
        this$0.allFriendList = list;
        this$0.Ch(this$0.searchText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(ZPlanFriendSearchFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.searchBox;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            editText = null;
        }
        editText.requestFocus();
        FragmentActivity activity = this$0.getActivity();
        Object systemService = activity != null ? activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            EditText editText3 = this$0.searchBox;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            } else {
                editText2 = editText3;
            }
            inputMethodManager.showSoftInput(editText2, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(ZPlanFriendSearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.wh();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public final void Bh(Function1<? super String, Unit> function1) {
        this.onFriendAddCallback = function1;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        if (requireActivity instanceof AppActivity) {
            AppRuntime appRuntime = ((AppActivity) requireActivity).getAppRuntime();
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            this.app = (AppInterface) appRuntime;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dcb, container, false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        EditText editText = this.searchBox;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            editText = null;
        }
        editText.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.friend.s
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanFriendSearchFragment.yh(ZPlanFriendSearchFragment.this);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.pfh);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.btn_cancel)");
        this.btnCancel = findViewById;
        View view2 = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.friend.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ZPlanFriendSearchFragment.zh(ZPlanFriendSearchFragment.this, view3);
            }
        });
        View findViewById2 = view.findViewById(R.id.psx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.et_search_box)");
        EditText editText = (EditText) findViewById2;
        this.searchBox = editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            editText = null;
        }
        editText.addTextChangedListener(this);
        View findViewById3 = view.findViewById(R.id.qje);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.search_list_container)");
        this.searchListContainer = findViewById3;
        View findViewById4 = view.findViewById(R.id.qjd);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.search_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.searchList = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchList");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView2 = this.searchList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchList");
            recyclerView2 = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        recyclerView2.addItemDecoration(new b(requireContext));
        RecyclerView recyclerView3 = this.searchList;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchList");
            recyclerView3 = null;
        }
        AppInterface appInterface = this.app;
        if (appInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("app");
            appInterface = null;
        }
        e eVar = new e(appInterface);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        k kVar = new k(eVar, requireContext2, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.zplan.friend.ZPlanFriendSearchFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String uin) {
                EditText editText2;
                Intrinsics.checkNotNullParameter(uin, "uin");
                editText2 = ZPlanFriendSearchFragment.this.searchBox;
                if (editText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchBox");
                    editText2 = null;
                }
                editText2.clearFocus();
                ZPlanFriendSearchFragment.this.wh();
                Function1<String, Unit> vh5 = ZPlanFriendSearchFragment.this.vh();
                if (vh5 != null) {
                    vh5.invoke(uin);
                }
                FragmentActivity activity = ZPlanFriendSearchFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        });
        this.searchListAdapter = kVar;
        recyclerView3.setAdapter(kVar);
        View findViewById5 = view.findViewById(R.id.f163435q40);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.iv_clear_search)");
        this.btnClear = findViewById5;
        if (findViewById5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnClear");
        } else {
            view2 = findViewById5;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.friend.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ZPlanFriendSearchFragment.Ah(ZPlanFriendSearchFragment.this, view3);
            }
        });
        View findViewById6 = view.findViewById(R.id.qth);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.tv_empty_notice)");
        this.emptyNotice = findViewById6;
        initViewModel();
    }

    public final Function1<String, Unit> vh() {
        return this.onFriendAddCallback;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s16) {
        View view = null;
        String obj = s16 != null ? s16.toString() : null;
        boolean z16 = true;
        QLog.i("ZPlanFriendSearchFragment", 1, "after text changed, search text = " + obj);
        View view2 = this.btnClear;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnClear");
        } else {
            view = view2;
        }
        if (obj != null && obj.length() != 0) {
            z16 = false;
        }
        view.setVisibility(z16 ? 8 : 0);
        if (obj == null) {
            obj = "";
        }
        Ch(obj);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s16, int start, int before, int count) {
    }
}
