package com.tencent.ecommerce.biz.live.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.ui.recyclerviewhelper.ECOnDragSortListener;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSearchViewModel;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.ecommerce.repo.live.TabInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00104\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010>R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowSearchFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View$OnClickListener;", "", "Xh", "Zh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "", "isNeedShow", "ai", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "inputText", "Wh", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "Yh", "isVisible", "Vh", "", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "getBusinessDescription", NodeProps.ON_CLICK, "Lcom/tencent/ecommerce/biz/live/ui/viewmodel/ECLiveWindowSearchViewModel;", "P", "Lcom/tencent/ecommerce/biz/live/ui/viewmodel/ECLiveWindowSearchViewModel;", "viewModel", "Lfi0/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lfi0/a;", "listAdapter", "Lcom/tencent/ecommerce/repo/live/TabInfo;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/repo/live/TabInfo;", "tabInfo", ExifInterface.LATITUDE_SOUTH, "Z", "isMaster", "T", "Ljava/lang/String;", "userId", "U", "roomId", "V", "I", WadlProxyConsts.CHANNEL, "Landroid/widget/EditText;", "W", "Landroid/widget/EditText;", "searchEditText", "Landroid/widget/TextView;", "X", "Landroid/widget/TextView;", "searchHintTextView", "Y", "Landroid/view/View;", "searchClearBtn", "searchCancelBtn", "Landroidx/recyclerview/widget/RecyclerView;", "a0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "b0", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "<init>", "()V", "c0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowSearchFragment extends ECBaseFragment implements View.OnClickListener {

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: Q, reason: from kotlin metadata */
    private fi0.a listAdapter;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isMaster;

    /* renamed from: V, reason: from kotlin metadata */
    private int channel;

    /* renamed from: W, reason: from kotlin metadata */
    private EditText searchEditText;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView searchHintTextView;

    /* renamed from: Y, reason: from kotlin metadata */
    private View searchClearBtn;

    /* renamed from: Z, reason: from kotlin metadata */
    private View searchCancelBtn;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: P, reason: from kotlin metadata */
    private ECLiveWindowSearchViewModel viewModel = new ECLiveWindowSearchViewModel();

    /* renamed from: R, reason: from kotlin metadata */
    private TabInfo tabInfo = new TabInfo();

    /* renamed from: T, reason: from kotlin metadata */
    private String userId = "";

    /* renamed from: U, reason: from kotlin metadata */
    private String roomId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowSearchFragment$a;", "", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowSearchFragment;", "a", "", "ARG_TAB_INFO", "Ljava/lang/String;", "", "RECYCLER_VIEW_REMAIN_MIN_ITEM_CNT", "I", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSearchFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECLiveWindowSearchFragment a() {
            return new ECLiveWindowSearchFragment();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowSearchFragment$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e extends RecyclerView.OnScrollListener {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            if (ECLiveWindowSearchFragment.this.viewModel.getIsListEnd().get()) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager) || dy5 <= 0) {
                return;
            }
            if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= r1.getItemCount() - 5) {
                ECLiveWindowSearchFragment eCLiveWindowSearchFragment = ECLiveWindowSearchFragment.this;
                eCLiveWindowSearchFragment.Wh(true, ECLiveWindowSearchFragment.Qh(eCLiveWindowSearchFragment).getText().toString());
            }
        }
    }

    public static final /* synthetic */ fi0.a Nh(ECLiveWindowSearchFragment eCLiveWindowSearchFragment) {
        fi0.a aVar = eCLiveWindowSearchFragment.listAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        return aVar;
    }

    public static final /* synthetic */ RecyclerView Oh(ECLiveWindowSearchFragment eCLiveWindowSearchFragment) {
        RecyclerView recyclerView = eCLiveWindowSearchFragment.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ View Ph(ECLiveWindowSearchFragment eCLiveWindowSearchFragment) {
        View view = eCLiveWindowSearchFragment.searchClearBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchClearBtn");
        }
        return view;
    }

    public static final /* synthetic */ EditText Qh(ECLiveWindowSearchFragment eCLiveWindowSearchFragment) {
        EditText editText = eCLiveWindowSearchFragment.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        return editText;
    }

    public static final /* synthetic */ ECStateCenterView Rh(ECLiveWindowSearchFragment eCLiveWindowSearchFragment) {
        ECStateCenterView eCStateCenterView = eCLiveWindowSearchFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(boolean isVisible) {
        View currentFocus;
        FragmentActivity activity = getActivity();
        Object systemService = activity != null ? activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) : null;
        InputMethodManager inputMethodManager = (InputMethodManager) (systemService instanceof InputMethodManager ? systemService : null);
        if (isVisible) {
            if (inputMethodManager != null) {
                EditText editText = this.searchEditText;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                }
                inputMethodManager.showSoftInput(editText, 0);
                return;
            }
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (currentFocus = activity2.getCurrentFocus()) != null && inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        EditText editText2 = this.searchEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        editText2.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(boolean isLoadMore, String inputText) {
        this.viewModel.h2(isLoadMore, inputText);
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        eCStateCenterView.setSucceededState();
    }

    private final void Xh() {
        TabInfo tabInfo;
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent != null) {
            this.isMaster = Intrinsics.areEqual(intent.getStringExtra("is_master"), "1");
            String stringExtra = intent.getStringExtra("live_user_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.userId = stringExtra;
            String stringExtra2 = intent.getStringExtra("live_room_id");
            if (stringExtra2 == null) {
                stringExtra2 = "0";
            }
            this.roomId = stringExtra2;
            String stringExtra3 = intent.getStringExtra(WadlProxyConsts.CHANNEL);
            this.channel = Integer.parseInt(stringExtra3 != null ? stringExtra3 : "0");
        }
        Bundle arguments = getArguments();
        if (arguments == null || (tabInfo = (TabInfo) arguments.getParcelable("ARG_TAB_INFO")) == null) {
            tabInfo = new TabInfo();
        }
        this.tabInfo = tabInfo;
        this.viewModel.Z1(intent, tabInfo);
    }

    private final void Zh() {
        this.viewModel.W1().observe(getViewLifecycleOwner(), new g());
        this.viewModel.X1().observe(getViewLifecycleOwner(), new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(boolean isNeedShow) {
        if (isNeedShow) {
            TextView textView = this.searchHintTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchHintTextView");
            }
            textView.setText(requireContext().getString(this.tabInfo.id == LiveTabId.LIVE_TAB_GOK ? R.string.wnp : R.string.wnr));
            return;
        }
        TextView textView2 = this.searchHintTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchHintTextView");
        }
        textView2.setText("");
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECLiveWindowSearchFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqw;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        editText.requestFocus();
        Vh(true);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Xh();
        Zh();
        initUI(view);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
            String str;
            if (s16 == null || (str = s16.toString()) == null) {
                str = "";
            }
            int length = s16 != null ? s16.length() : 0;
            cg0.a.b("ECLiveWindowSearchFragment", "addTextChangedListener onChange, text:" + str + " length:" + length);
            if (length == 0) {
                ECLiveWindowSearchFragment.Ph(ECLiveWindowSearchFragment.this).setVisibility(8);
                ECLiveWindowSearchFragment.this.ai(true);
            } else {
                ECLiveWindowSearchFragment.Ph(ECLiveWindowSearchFragment.this).setVisibility(0);
                ECLiveWindowSearchFragment.this.ai(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence text, int start, int before, int count) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/repo/live/q;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g<T> implements Observer<List<? extends LiveProduct>> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<LiveProduct> list) {
            if (list != null) {
                cg0.a.b("ECLiveWindowSearchFragment", "LiveDataChange liveProductListLiveData onChange, size:" + list.size());
                ECLiveWindowSearchFragment.Nh(ECLiveWindowSearchFragment.this).setData(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements TextView.OnEditorActionListener {
        c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            if (i3 == 3) {
                ECLiveWindowSearchFragment eCLiveWindowSearchFragment = ECLiveWindowSearchFragment.this;
                eCLiveWindowSearchFragment.Wh(false, ECLiveWindowSearchFragment.Qh(eCLiveWindowSearchFragment).getText().toString());
                ECLiveWindowSearchFragment.this.Vh(false);
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(LiveProduct liveProduct) {
        LiveProduct a16;
        ECLiveWindowSearchViewModel eCLiveWindowSearchViewModel = this.viewModel;
        fi0.a aVar = this.listAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        eCLiveWindowSearchViewModel.g2(liveProduct, aVar);
        int i3 = liveProduct.getIsExplaining() ? 1 : 2;
        long parseLong = this.roomId.length() > 0 ? Long.parseLong(this.roomId) : 0L;
        com.tencent.ecommerce.biz.live.a aVar2 = com.tencent.ecommerce.biz.live.a.f102661d;
        LiveTabId liveTabId = this.tabInfo.id;
        boolean z16 = this.isMaster;
        int i16 = this.channel;
        String str = this.userId;
        a16 = liveProduct.a((r50 & 1) != 0 ? liveProduct.mediaProductId : null, (r50 & 2) != 0 ? liveProduct.goodsType : 0, (r50 & 4) != 0 ? liveProduct.saasProductId : null, (r50 & 8) != 0 ? liveProduct.saasTypeStr : null, (r50 & 16) != 0 ? liveProduct.title : null, (r50 & 32) != 0 ? liveProduct.adTxt : null, (r50 & 64) != 0 ? liveProduct.cover : null, (r50 & 128) != 0 ? liveProduct.buttonTxt : null, (r50 & 256) != 0 ? liveProduct.isExplaining : false, (r50 & 512) != 0 ? liveProduct.status : 0, (r50 & 1024) != 0 ? liveProduct.statusTxt : null, (r50 & 2048) != 0 ? liveProduct.indexTxt : null, (r50 & 4096) != 0 ? liveProduct.price : null, (r50 & 8192) != 0 ? liveProduct.salesTxt : null, (r50 & 16384) != 0 ? liveProduct.detailUrl : null, (r50 & 32768) != 0 ? liveProduct.inventory : 0L, (r50 & 65536) != 0 ? liveProduct.uiStyle : null, (131072 & r50) != 0 ? liveProduct.oriPrice : null, (r50 & 262144) != 0 ? liveProduct.index : 0, (r50 & 524288) != 0 ? liveProduct.isSelected : false, (r50 & 1048576) != 0 ? liveProduct.positionInList : 0, (r50 & 2097152) != 0 ? liveProduct.isTop : false, (r50 & 4194304) != 0 ? liveProduct.tempUIStyle : null, (r50 & 8388608) != 0 ? liveProduct.shopId : null, (r50 & 16777216) != 0 ? liveProduct.skuId : null, (r50 & 33554432) != 0 ? liveProduct.liveTabId : null, (r50 & 67108864) != 0 ? liveProduct.liveActivity : null, (r50 & 134217728) != 0 ? liveProduct.reportInfo : null, (r50 & 268435456) != 0 ? liveProduct.normalShowItem : null, (r50 & 536870912) != 0 ? liveProduct.couponShowItem : null, (r50 & 1073741824) != 0 ? liveProduct.activityShowItem : null);
        aVar2.q(i3, liveTabId, z16, i16, str, parseLong, a16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "status", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<Integer> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            String str;
            if (num != null && num.intValue() == 3) {
                ECLiveWindowSearchFragment.Nh(ECLiveWindowSearchFragment.this).m0(2);
                return;
            }
            if (num != null && num.intValue() == 1) {
                ECLiveWindowSearchFragment.Nh(ECLiveWindowSearchFragment.this).m0(0);
                return;
            }
            if (num != null && num.intValue() == 2) {
                ECLiveWindowSearchFragment.Nh(ECLiveWindowSearchFragment.this).m0(ECLiveWindowSearchFragment.this.viewModel.getIsListEnd().get() ? 1 : 0);
                if (ECLiveWindowSearchFragment.this.viewModel.getIsListEnd().get() && ECLiveWindowSearchFragment.this.viewModel.a2()) {
                    ECStateCenterView Rh = ECLiveWindowSearchFragment.Rh(ECLiveWindowSearchFragment.this);
                    FragmentActivity activity = ECLiveWindowSearchFragment.this.getActivity();
                    if (activity == null || (str = activity.getString(R.string.wnk)) == null) {
                        str = "";
                    }
                    IStateCenterView.a.a(Rh, str, null, 0, 6, null);
                }
                ECLiveWindowSearchFragment.this.viewModel.T1();
            }
        }
    }

    private final void initUI(View rootView) {
        this.searchEditText = (EditText) rootView.findViewById(R.id.o_4);
        this.searchHintTextView = (TextView) rootView.findViewById(R.id.o_1);
        this.searchClearBtn = rootView.findViewById(R.id.o9z);
        this.searchCancelBtn = rootView.findViewById(R.id.o9y);
        this.stateView = (ECStateCenterView) rootView.findViewById(R.id.f163103ob2);
        View view = this.searchClearBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchClearBtn");
        }
        view.setOnClickListener(this);
        View view2 = this.searchCancelBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchCancelBtn");
        }
        view2.setOnClickListener(this);
        View view3 = this.searchClearBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchClearBtn");
        }
        ViewExtKt.a(view3, com.tencent.ecommerce.biz.util.e.c(20.0f));
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        editText.setOnEditorActionListener(new c());
        EditText editText2 = this.searchEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        editText2.addTextChangedListener(new b());
        ECLiveWindowSearchFragment$initUI$emptyCustomClick$1 eCLiveWindowSearchFragment$initUI$emptyCustomClick$1 = new Function1<LiveProduct, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSearchFragment$initUI$emptyCustomClick$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LiveProduct liveProduct) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LiveProduct liveProduct) {
                invoke2(liveProduct);
                return Unit.INSTANCE;
            }
        };
        f fVar = new f();
        ECLiveWindowSearchFragment$initUI$emptyItemExposure$1 eCLiveWindowSearchFragment$initUI$emptyItemExposure$1 = new Function2<LiveProduct, Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSearchFragment$initUI$emptyItemExposure$1
            public final void invoke(LiveProduct liveProduct, boolean z16) {
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LiveProduct liveProduct, Boolean bool) {
                invoke(liveProduct, bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
        this.listAdapter = new fi0.a(requireContext(), this.isMaster, eCLiveWindowSearchFragment$initUI$emptyCustomClick$1, fVar, new Function1<LiveProduct, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSearchFragment$initUI$onActionClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LiveProduct liveProduct) {
                invoke2(liveProduct);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LiveProduct liveProduct) {
                ECLiveWindowSearchFragment.this.Yh(liveProduct);
            }
        }, eCLiveWindowSearchFragment$initUI$emptyCustomClick$1, eCLiveWindowSearchFragment$initUI$emptyCustomClick$1, eCLiveWindowSearchFragment$initUI$emptyItemExposure$1, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveWindowSearchFragment$initUI$onFooterRetryClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ECLiveWindowSearchFragment eCLiveWindowSearchFragment = ECLiveWindowSearchFragment.this;
                eCLiveWindowSearchFragment.Wh(false, ECLiveWindowSearchFragment.Qh(eCLiveWindowSearchFragment).getText().toString());
            }
        });
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.o8n);
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setHasFixedSize(true);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        fi0.a aVar = this.listAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        recyclerView2.setAdapter(aVar);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView4.addOnAttachStateChangeListener(new d());
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView5.addOnScrollListener(new e());
        ai(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentManager supportFragmentManager;
        FragmentTransaction fragmentTransaction = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.o9z) {
            EditText editText = this.searchEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            }
            editText.setText((CharSequence) null);
            this.viewModel.U1();
            EditText editText2 = this.searchEditText;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            }
            editText2.requestFocus();
            Vh(true);
            ECStateCenterView eCStateCenterView = this.stateView;
            if (eCStateCenterView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateView");
            }
            eCStateCenterView.setSucceededState();
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.o9y) {
            Vh(false);
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                fragmentTransaction = supportFragmentManager.beginTransaction();
            }
            if (fragmentTransaction != null) {
                fragmentTransaction.remove(this);
            }
            if (fragmentTransaction != null) {
                fragmentTransaction.commit();
            }
            LifecycleEventBus.f100688b.f(new ci0.h(true));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowSearchFragment$d", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            RecyclerView.LayoutManager layoutManager = ECLiveWindowSearchFragment.Oh(ECLiveWindowSearchFragment.this).getLayoutManager();
            if (layoutManager == null || layoutManager.getItemCount() <= 0) {
                return;
            }
            ECLiveWindowSearchFragment.Nh(ECLiveWindowSearchFragment.this).notifyItemChanged(layoutManager.getItemCount() - 1);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveWindowSearchFragment$f", "Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECOnDragSortListener;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "onStartDrag", "onDragEnd", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements ECOnDragSortListener {
        f() {
        }

        @Override // com.tencent.ecommerce.base.ui.recyclerviewhelper.ECOnDragSortListener
        public void onDragEnd(RecyclerView.ViewHolder viewHolder) {
        }

        @Override // com.tencent.ecommerce.base.ui.recyclerviewhelper.ECOnDragSortListener
        public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        }
    }
}
