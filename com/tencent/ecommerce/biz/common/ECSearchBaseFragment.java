package com.tencent.ecommerce.biz.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 72\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\"\u0010\u001c\u001a\u00020\r8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/ecommerce/biz/common/ECSearchBaseFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initUI", "Qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getBusinessDescription", "queryText", "", "clickSearchBtn", "Sh", ViewStickEventHelper.IS_SHOW, "Rh", "Ph", "P", "Ljava/lang/String;", "Lh", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", WadlProxyConsts.CHANNEL, "Landroid/widget/EditText;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/EditText;", "Nh", "()Landroid/widget/EditText;", "setSearchEditText", "(Landroid/widget/EditText;)V", "searchEditText", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "Oh", "()Landroid/widget/TextView;", "setSearchHintTextView", "(Landroid/widget/TextView;)V", "searchHintTextView", "Landroid/widget/ImageView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/ImageView;", "Mh", "()Landroid/widget/ImageView;", "setDeleteButton", "(Landroid/widget/ImageView;)V", "deleteButton", "<init>", "()V", "T", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECSearchBaseFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    protected String channel;

    /* renamed from: Q, reason: from kotlin metadata */
    protected EditText searchEditText;

    /* renamed from: R, reason: from kotlin metadata */
    protected TextView searchHintTextView;

    /* renamed from: S, reason: from kotlin metadata */
    protected ImageView deleteButton;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSearchBaseFragment.this.Sh("", false);
            FragmentActivity activity = ECSearchBaseFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSearchBaseFragment.this.Sh("", false);
            FragmentActivity activity = ECSearchBaseFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSearchBaseFragment.this.Nh().getText().clear();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String Lh() {
        String str = this.channel;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.CHANNEL);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ImageView Mh() {
        ImageView imageView = this.deleteButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
        }
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final EditText Nh() {
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        return editText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView Oh() {
        TextView textView = this.searchHintTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchHintTextView");
        }
        return textView;
    }

    public void Ph() {
        String str;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("arg_query_string")) == null) {
            str = "";
        }
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        editText.append(str);
        EditText editText2 = this.searchEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        editText2.postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.common.ECSearchBaseFragment$initSearchEditText$1
            @Override // java.lang.Runnable
            public final void run() {
                ECSearchBaseFragment.this.Nh().requestFocus();
                ECSearchBaseFragment.this.Rh(true);
            }
        }, 100L);
    }

    public final void Rh(boolean isShow) {
        FragmentActivity activity;
        Window window;
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) : null;
        InputMethodManager inputMethodManager = (InputMethodManager) (systemService instanceof InputMethodManager ? systemService : null);
        if (inputMethodManager == null && !isShow && (activity = getActivity()) != null && (window = activity.getWindow()) != null) {
            SoftKeyboardStateHelper.INSTANCE.c(window);
        }
        if (inputMethodManager != null) {
            if (isShow) {
                EditText editText = this.searchEditText;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                }
                inputMethodManager.showSoftInput(editText, 0);
                return;
            }
            EditText editText2 = this.searchEditText;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            }
            inputMethodManager.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Sh(String queryText, boolean clickSearchBtn) {
        Intent intent = new Intent();
        intent.putExtra("arg_query_string", queryText);
        intent.putExtra("arg_has_clicked_search_btn", clickSearchBtn);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(1, intent);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    public String getBusinessDescription() {
        return "ECSearchBaseFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        Intent intent;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
        r.f104881b.e(getActivity(), true);
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent = activity2.getIntent()) == null || (str = intent.getStringExtra("arg_channel")) == null) {
            str = "";
        }
        this.channel = str;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Rh(false);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        Qh(view);
        Ph();
    }

    private final void Qh(View rootView) {
        ((ImageView) rootView.findViewById(R.id.o18)).setOnClickListener(new b());
        TextView textView = (TextView) rootView.findViewById(R.id.od8);
        if (textView != null) {
            textView.setOnClickListener(new c());
        }
        ImageView imageView = this.deleteButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
        }
        imageView.setOnClickListener(new d());
    }

    private final void initUI(View rootView) {
        this.searchEditText = (EditText) rootView.findViewById(R.id.nyr);
        this.searchHintTextView = (TextView) rootView.findViewById(R.id.f163119oe3);
        this.deleteButton = (ImageView) rootView.findViewById(R.id.o1g);
    }
}
