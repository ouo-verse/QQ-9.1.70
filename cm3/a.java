package cm3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.component.core.log.LogUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;

/* compiled from: P */
@Deprecated
/* loaded from: classes22.dex */
public class a extends ReportDialogFragment {

    /* renamed from: d, reason: collision with root package name */
    protected InterfaceC0204a f31101d;

    /* compiled from: P */
    /* renamed from: cm3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0204a {
        void onDismiss(DialogInterface dialogInterface);
    }

    public void a(InterfaceC0204a interfaceC0204a) {
        this.f31101d = interfaceC0204a;
    }

    @Override // android.app.DialogFragment
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e16) {
            LogUtil.printStackTrace(e16);
        }
    }

    @Override // android.app.DialogFragment
    public void dismissAllowingStateLoss() {
        try {
            super.dismissAllowingStateLoss();
        } catch (Exception e16) {
            LogUtil.printStackTrace(e16);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        LogUtil.d("BaseDialogFragment", getTag() + " onActivityCreated...", new Object[0]);
        try {
            if (getDialog() == null) {
                Context context = getContext();
                while ((context instanceof ContextWrapper) && !(context instanceof FragmentActivity)) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
                if (context instanceof FragmentActivity) {
                    ((FragmentActivity) context).finish();
                    return;
                }
                setShowsDialog(false);
            }
            super.onActivityCreated(bundle);
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        LogUtil.d("BaseDialogFragment", getTag() + " onAttach...", new Object[0]);
        super.onAttach(activity);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        LogUtil.d("BaseDialogFragment", getTag() + " onCreate...", new Object[0]);
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        LogUtil.d("BaseDialogFragment", getTag() + " onDestroy...", new Object[0]);
        super.onDestroy();
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        try {
            super.onDismiss(dialogInterface);
        } catch (Exception e16) {
            LogUtil.printStackTrace(e16);
        }
        InterfaceC0204a interfaceC0204a = this.f31101d;
        if (interfaceC0204a != null) {
            interfaceC0204a.onDismiss(dialogInterface);
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        LogUtil.d("BaseDialogFragment", getTag() + " onPause...", new Object[0]);
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (iArr.length == 0) {
            LogUtil.i("BaseDialogFragment", "grant result is nil", new Object[0]);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        LogUtil.d("BaseDialogFragment", getTag() + " onResume...", new Object[0]);
        super.onResume();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        LogUtil.d("BaseDialogFragment", getTag() + " onStart...", new Object[0]);
        super.onStart();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStop() {
        LogUtil.d("BaseDialogFragment", getTag() + " onStop...", new Object[0]);
        super.onStop();
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (IllegalStateException e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        try {
            return super.show(fragmentTransaction, str);
        } catch (IllegalStateException e16) {
            e16.printStackTrace();
            return 0;
        }
    }
}
