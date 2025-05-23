package com.tencent.ecommerce.base.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 0*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J;\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2+\u0010\u0010\u001a'\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\u000bj\b\u0012\u0004\u0012\u00028\u0000`\u000fJ#\u0010\u0014\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0012H'J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0004H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECBaseDialogFragment;", "Landroid/os/Parcelable;", "RESULT", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "rh", "vh", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/ecommerce/base/ui/OnResult;", "onResult", "uh", "", "receiveResultMode", "sh", "(Landroid/os/Parcelable;I)V", "onStart", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "getContentLayoutId", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "outState", "onSaveInstanceState", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Parcelable;", "resultValue", "D", "I", "resultMode", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "E", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "resultFlow", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public abstract class ECBaseDialogFragment<RESULT extends Parcelable> extends DialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private RESULT resultValue;

    /* renamed from: D, reason: from kotlin metadata */
    private int resultMode = 2;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableSharedFlow<RESULT> resultFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);

    private final void rh(Bundle savedInstanceState) {
        RESULT result = (RESULT) savedInstanceState.getParcelable("KEY_RESULT");
        if (result != null) {
            this.resultValue = result;
        }
        int i3 = savedInstanceState.getInt("KEY_RESULT_MODE", 2);
        this.resultMode = i3;
        if (i3 == 1) {
            vh();
        }
        cg0.a.b("ECBaseDialogFragment", "onViewStateRestored, resultValue: " + this.resultValue + " resultMode: " + this.resultMode);
    }

    private final void vh() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECBaseDialogFragment$tryFireResult$1(this, null), 3, null);
    }

    public abstract int getContentLayoutId();

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        try {
            LayoutInflater.Factory2 skinFactory2 = ECSkin.INSTANCE.getSkinFactory2();
            if (skinFactory2 != null) {
                LayoutInflaterCompat.setFactory2(LayoutInflater.from(getContext()), skinFactory2);
            }
        } catch (IllegalStateException unused) {
        }
        super.onCreate(savedInstanceState);
        setStyle(1, R.style.f243128);
        ECSkin.INSTANCE.loadResource();
        if (savedInstanceState != null) {
            rh(savedInstanceState);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        vh();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        cg0.a.b("ECBaseDialogFragment", "onSaveInstanceState, resultValue: " + this.resultValue + " resultMode: " + this.resultMode);
        outState.putParcelable("KEY_RESULT", this.resultValue);
        outState.putInt("KEY_RESULT_MODE", this.resultMode);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void sh(RESULT result, int receiveResultMode) {
        this.resultValue = result;
        if (receiveResultMode == 1) {
            vh();
        }
    }

    public final void uh(FragmentManager fragmentManager, Function1<? super RESULT, Unit> onResult) {
        show(fragmentManager, "ECBaseDialogFragment");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECBaseDialogFragment$show$1(this, onResult, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.cox, container, false);
        if (inflate != null) {
            ViewGroup viewGroup = (ViewGroup) inflate;
            viewGroup.addView(inflater.inflate(getContentLayoutId(), viewGroup, false));
            return viewGroup;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static /* synthetic */ void th(ECBaseDialogFragment eCBaseDialogFragment, Parcelable parcelable, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                i3 = 2;
            }
            eCBaseDialogFragment.sh(parcelable, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setResult");
    }
}
