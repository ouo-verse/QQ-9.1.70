package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import f50.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b&\u0018\u0000 :*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J;\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2+\u0010\u0010\u001a'\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\u000bj\b\u0012\u0004\u0012\u00028\u0000`\u000fJ#\u0010\u0014\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0012H'J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0004H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R?\u0010,\u001a+\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R$\u00103\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00107\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010.\u001a\u0004\b5\u00100\"\u0004\b6\u00102\u00a8\u0006<"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/base/QFSPublicAccountBaseDialogFragment;", "Landroid/os/Parcelable;", "RESULT", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "ph", "th", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/base/OnResult;", "onResult", "sh", "", "receiveResultMode", "qh", "(Landroid/os/Parcelable;I)V", "onStart", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "getContentLayoutId", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "outState", "onSaveInstanceState", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Parcelable;", "resultValue", "D", "I", "resultMode", "E", "Lkotlin/jvm/functions/Function1;", "resultCallback", UserInfo.SEX_FEMALE, "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "G", "getContentView", "setContentView", "contentView", "<init>", "()V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class QFSPublicAccountBaseDialogFragment<RESULT extends Parcelable> extends DialogFragment {

    /* renamed from: C */
    @Nullable
    private RESULT resultValue;

    /* renamed from: D, reason: from kotlin metadata */
    private int resultMode = 2;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function1<? super RESULT, Unit> resultCallback;

    /* renamed from: F */
    @Nullable
    private View rootView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View contentView;

    private final void ph(Bundle r56) {
        Map map;
        Function1<? super RESULT, Unit> function1;
        RESULT result = (RESULT) r56.getParcelable("KEY_RESULT");
        if (result != null) {
            this.resultValue = result;
        }
        this.resultMode = r56.getInt("KEY_RESULT_MODE", 2);
        int i3 = r56.getInt("KEY_HASH_CODE");
        map = a.f397850a;
        Object remove = map.remove(Integer.valueOf(i3));
        if (TypeIntrinsics.isFunctionOfArity(remove, 1)) {
            function1 = (Function1) remove;
        } else {
            function1 = null;
        }
        this.resultCallback = function1;
        if (this.resultMode == 1) {
            th();
        }
        QLog.i("QFSPublicAccountBaseDialogFragment", 1, "onViewStateRestored, resultValue: " + this.resultValue + " resultMode: " + this.resultMode);
    }

    public static /* synthetic */ void rh(QFSPublicAccountBaseDialogFragment qFSPublicAccountBaseDialogFragment, Parcelable parcelable, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                i3 = 2;
            }
            qFSPublicAccountBaseDialogFragment.qh(parcelable, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setResult");
    }

    private final void th() {
        Function1<? super RESULT, Unit> function1;
        RESULT result = this.resultValue;
        if (result != null && (function1 = this.resultCallback) != null) {
            function1.invoke(result);
        }
        this.resultValue = null;
    }

    @LayoutRes
    public abstract int getContentLayoutId();

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r36) {
        super.onCreate(r36);
        setStyle(1, R.style.f246388r);
        if (r36 != null) {
            ph(r36);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup r36, @Nullable Bundle r46) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f168735go0, r36, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        View inflate2 = inflater.inflate(getContentLayoutId(), viewGroup, false);
        this.contentView = inflate2;
        viewGroup.addView(inflate2);
        this.rootView = viewGroup;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        th();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Map map;
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        QLog.i("QFSPublicAccountBaseDialogFragment", 1, "onSaveInstanceState, resultValue: " + this.resultValue + " resultMode: " + this.resultMode);
        outState.putParcelable("KEY_RESULT", this.resultValue);
        outState.putInt("KEY_RESULT_MODE", this.resultMode);
        Function1<? super RESULT, Unit> function1 = this.resultCallback;
        if (function1 != null) {
            Integer valueOf = Integer.valueOf(hashCode());
            map = a.f397850a;
            map.put(valueOf, function1);
            outState.putInt("KEY_HASH_CODE", hashCode());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    protected final void qh(@Nullable RESULT result, int receiveResultMode) {
        this.resultValue = result;
        if (receiveResultMode == 1) {
            th();
        }
    }

    public final void sh(@NotNull FragmentManager fragmentManager, @NotNull Function1<? super RESULT, Unit> onResult) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        show(fragmentManager, "QFSPublicAccountBaseDialogFragment");
        this.resultCallback = onResult;
    }
}
