package com.tencent.ecommerce.biz.live.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import ci0.ECSetSellingPointFinishEvent;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010!\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u001b\u00a8\u0006:"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveSellingPointFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View$OnClickListener;", "", "Xh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "Yh", "Uh", "Th", "Sh", "Vh", "Zh", "Wh", "Rh", "", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", "getBusinessDescription", NodeProps.ON_CLICK, "P", "Ljava/lang/String;", "initInput", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "productId", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/Integer;", "positionInList", "Landroid/widget/FrameLayout;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/FrameLayout;", "windowContent", "Landroid/widget/TextView;", "T", "Landroid/widget/TextView;", "backTextView", "U", "okTextView", "Landroid/widget/EditText;", "V", "Landroid/widget/EditText;", "inputEditText", "Landroid/widget/ImageView;", "W", "Landroid/widget/ImageView;", "clearBtn", "X", "curInputText", "<init>", "()V", "Y", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveSellingPointFragment extends ECBaseFragment implements View.OnClickListener {

    /* renamed from: Y, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private String initInput;

    /* renamed from: Q, reason: from kotlin metadata */
    private String productId;

    /* renamed from: R, reason: from kotlin metadata */
    private Integer positionInList;

    /* renamed from: S, reason: from kotlin metadata */
    private FrameLayout windowContent;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView backTextView;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView okTextView;

    /* renamed from: V, reason: from kotlin metadata */
    private EditText inputEditText;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView clearBtn;

    /* renamed from: X, reason: from kotlin metadata */
    private String curInputText;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveSellingPointFragment$a;", "", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveSellingPointFragment;", "a", "", "ARG_POSITION_IN_LIST", "Ljava/lang/String;", "ARG_PRODUCT_ID", "ARG_SELLING_POINT", "", "INPUT_MAX_LENGTH", "I", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.live.ui.ECLiveSellingPointFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECLiveSellingPointFragment a() {
            return new ECLiveSellingPointFragment();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ ImageView Lh(ECLiveSellingPointFragment eCLiveSellingPointFragment) {
        ImageView imageView = eCLiveSellingPointFragment.clearBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearBtn");
        }
        return imageView;
    }

    public static final /* synthetic */ EditText Nh(ECLiveSellingPointFragment eCLiveSellingPointFragment) {
        EditText editText = eCLiveSellingPointFragment.inputEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
        }
        return editText;
    }

    public static final /* synthetic */ TextView Oh(ECLiveSellingPointFragment eCLiveSellingPointFragment) {
        TextView textView = eCLiveSellingPointFragment.okTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("okTextView");
        }
        return textView;
    }

    private final void Rh() {
        FragmentManager supportFragmentManager;
        Wh();
        FragmentActivity activity = getActivity();
        FragmentTransaction beginTransaction = (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.beginTransaction();
        if (beginTransaction != null) {
            beginTransaction.setCustomAnimations(0, R.anim.f1687);
        }
        if (beginTransaction != null) {
            beginTransaction.remove(this);
        }
        if (beginTransaction != null) {
            beginTransaction.commit();
        }
    }

    private final void Sh() {
        Rh();
    }

    private final void Th() {
        EditText editText = this.inputEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
        }
        editText.setText("");
    }

    private final void Uh() {
        EditText editText = this.inputEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
        }
        editText.requestFocus();
        Zh();
    }

    private final void Vh() {
        LifecycleEventBus lifecycleEventBus = LifecycleEventBus.f100688b;
        String str = this.productId;
        if (str == null) {
            str = "";
        }
        String str2 = this.curInputText;
        String str3 = str2 != null ? str2 : "";
        Integer num = this.positionInList;
        lifecycleEventBus.f(new ECSetSellingPointFinishEvent(str, str3, num != null ? num.intValue() : -1));
        Rh();
    }

    private final void Wh() {
        View currentFocus;
        FragmentActivity activity = getActivity();
        if (activity == null || (currentFocus = activity.getCurrentFocus()) == null) {
            return;
        }
        cg0.a.b("ECLiveSellingPointFragment", "hideSoftInputFromWindow");
        FragmentActivity activity2 = getActivity();
        Object systemService = activity2 != null ? activity2.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) : null;
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    private final void Xh() {
        Bundle arguments = getArguments();
        this.initInput = arguments != null ? arguments.getString("args_selling_point", "") : null;
        Bundle arguments2 = getArguments();
        this.productId = arguments2 != null ? arguments2.getString("args_product_id", "") : null;
        Bundle arguments3 = getArguments();
        this.positionInList = arguments3 != null ? Integer.valueOf(arguments3.getInt("args_position_in_list", -1)) : null;
        cg0.a.b("ECLiveSellingPointFragment", "initArguments, arguments:" + String.valueOf(getArguments()));
    }

    private final void Yh() {
        ei0.b bVar = ei0.b.f396301a;
        bVar.c(this);
        TextView textView = this.okTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("okTextView");
        }
        bVar.b(textView);
        TextView textView2 = this.backTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backTextView");
        }
        bVar.a(textView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh() {
        FragmentActivity activity = getActivity();
        Object systemService = activity != null ? activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) : null;
        InputMethodManager inputMethodManager = (InputMethodManager) (systemService instanceof InputMethodManager ? systemService : null);
        if (inputMethodManager != null) {
            EditText editText = this.inputEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
            }
            inputMethodManager.showSoftInput(editText, 0);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECLiveSellingPointFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.ofe) {
            Sh();
        } else if (valueOf != null && valueOf.intValue() == R.id.oft) {
            Vh();
        } else if (valueOf != null && valueOf.intValue() == R.id.ofi) {
            Th();
        } else if ((valueOf != null && valueOf.intValue() == R.id.ofk) || (valueOf != null && valueOf.intValue() == R.id.ofs)) {
            Uh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        EditText editText = this.inputEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
        }
        editText.postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveSellingPointFragment$onResume$1
            @Override // java.lang.Runnable
            public final void run() {
                ECLiveSellingPointFragment.Nh(ECLiveSellingPointFragment.this).requestFocus();
                ECLiveSellingPointFragment.this.Zh();
            }
        }, 100L);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Xh();
        initUI(view);
        Yh();
    }

    private final void initUI(View rootView) {
        boolean isBlank;
        this.windowContent = (FrameLayout) rootView.findViewById(R.id.ofk);
        this.backTextView = (TextView) rootView.findViewById(R.id.ofe);
        this.okTextView = (TextView) rootView.findViewById(R.id.oft);
        this.inputEditText = (EditText) rootView.findViewById(R.id.ofs);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.ofi);
        this.clearBtn = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearBtn");
        }
        ViewExtKt.a(imageView, e.c(50.0f));
        TextView textView = this.backTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backTextView");
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.okTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("okTextView");
        }
        textView2.setOnClickListener(this);
        ImageView imageView2 = this.clearBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearBtn");
        }
        imageView2.setOnClickListener(this);
        EditText editText = this.inputEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
        }
        editText.setOnClickListener(this);
        FrameLayout frameLayout = this.windowContent;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowContent");
        }
        frameLayout.setOnClickListener(this);
        EditText editText2 = this.inputEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
        }
        editText2.addTextChangedListener(new b());
        String str = this.initInput;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                EditText editText3 = this.inputEditText;
                if (editText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
                }
                editText3.setText(this.initInput);
                String str2 = this.initInput;
                if (str2 != null) {
                    int length = str2.length();
                    EditText editText4 = this.inputEditText;
                    if (editText4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("inputEditText");
                    }
                    editText4.setSelection(length);
                }
                TextView textView3 = this.okTextView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("okTextView");
                }
                textView3.setEnabled(true);
                return;
            }
        }
        TextView textView4 = this.okTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("okTextView");
        }
        textView4.setEnabled(false);
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
            String str;
            ECLiveSellingPointFragment eCLiveSellingPointFragment = ECLiveSellingPointFragment.this;
            if (s16 == null || (str = s16.toString()) == null) {
                str = "";
            }
            eCLiveSellingPointFragment.curInputText = str;
            int length = s16 != null ? s16.length() : 0;
            cg0.a.b("ECLiveSellingPointFragment", "addTextChangedListener onChange, text:" + ECLiveSellingPointFragment.this.curInputText + " length:" + length);
            if (length == 0) {
                ECLiveSellingPointFragment.Lh(ECLiveSellingPointFragment.this).setVisibility(8);
                ECLiveSellingPointFragment.Oh(ECLiveSellingPointFragment.this).setEnabled(true);
            } else if (length < 15) {
                ECLiveSellingPointFragment.Lh(ECLiveSellingPointFragment.this).setVisibility(0);
                ECLiveSellingPointFragment.Oh(ECLiveSellingPointFragment.this).setEnabled(true);
            } else {
                if (length == 15) {
                    ECLiveSellingPointFragment.Lh(ECLiveSellingPointFragment.this).setVisibility(0);
                    i.e(i.f101155b, R.string.wmh, ECToastIcon.ICON_ERROR, 0, 4, null);
                    ECLiveSellingPointFragment.Oh(ECLiveSellingPointFragment.this).setEnabled(true);
                    return;
                }
                ECLiveSellingPointFragment.Oh(ECLiveSellingPointFragment.this).setEnabled(true);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence text, int start, int before, int count) {
        }
    }
}
