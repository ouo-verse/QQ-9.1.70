package com.tencent.ecommerce.biz.orders.common.ordersearchviewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.biz.common.ECSearchBaseFragment;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ji0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/ordersearchviewmodel/ECOrderSearchFragment;", "Lcom/tencent/ecommerce/biz/common/ECSearchBaseFragment;", "", "Yh", "initViewModel", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getBusinessDescription", "Lji0/a;", "U", "Lji0/a;", "viewModel", "<init>", "()V", "V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECOrderSearchFragment extends ECSearchBaseFragment {

    /* renamed from: U, reason: from kotlin metadata */
    private a viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECOrderSearchFragment.this.Mh().setVisibility(bool.booleanValue() ? 4 : 0);
            ECOrderSearchFragment.this.Oh().setVisibility(bool.booleanValue() ? 0 : 4);
        }
    }

    public static final /* synthetic */ a Wh(ECOrderSearchFragment eCOrderSearchFragment) {
        a aVar = eCOrderSearchFragment.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return aVar;
    }

    private final void Yh() {
        String str;
        Intent intent;
        Nh().setOnEditorActionListener(new c());
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("arg_query_string")) == null) {
            str = "";
        }
        a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        aVar.M1(TextUtils.isEmpty(str));
        Nh().addTextChangedListener(new b());
    }

    private final void initViewModel() {
        a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        aVar.L1().observe(getViewLifecycleOwner(), new d());
    }

    @Override // com.tencent.ecommerce.biz.common.ECSearchBaseFragment, com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    public String getBusinessDescription() {
        return "ECOrderSearchFragment";
    }

    @Override // com.tencent.ecommerce.biz.common.ECSearchBaseFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewModel = (a) new ViewModelProvider(this).get(a.class);
    }

    @Override // com.tencent.ecommerce.biz.common.ECSearchBaseFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Yh();
        initViewModel();
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
            ECOrderSearchFragment.Wh(ECOrderSearchFragment.this).M1(TextUtils.isEmpty(str));
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements TextView.OnEditorActionListener {
        c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            if (i3 == 3) {
                ECOrderSearchFragment eCOrderSearchFragment = ECOrderSearchFragment.this;
                eCOrderSearchFragment.Sh(eCOrderSearchFragment.Nh().getText().toString(), true);
                FragmentActivity activity = ECOrderSearchFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return true;
        }
    }
}
