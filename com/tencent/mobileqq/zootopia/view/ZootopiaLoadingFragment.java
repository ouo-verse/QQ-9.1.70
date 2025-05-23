package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaLoadingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "Companion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaLoadingFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ArrayList<WeakReference<z>> D = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\bR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR0\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaLoadingFragment$Companion;", "", "Landroid/content/Context;", "context", "", "cancelable", "cancelableOnTouchOutSide", "dismissWhenOnPause", "", "b", "a", "", "PARAM_CANCELABLE", "Ljava/lang/String;", "PARAM_CANCELABLE_ON_TOUCH_OUTSIDE", "PARAM_DISMISS_WHEN_PAUSE", "TAG", "Ljava/util/ArrayList;", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zootopia/view/z;", "Lkotlin/collections/ArrayList;", "showingDialogReferenceList", "Ljava/util/ArrayList;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            QLog.i("ZootopiaLoadingFragment_", 1, "dismiss");
            while (!ZootopiaLoadingFragment.D.isEmpty()) {
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.view.ZootopiaLoadingFragment$Companion$dismiss$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        z zVar = (z) ((WeakReference) ZootopiaLoadingFragment.D.remove(0)).get();
                        try {
                            QLog.i("ZootopiaLoadingFragment_", 1, "dismiss dialog " + zVar);
                            if (zVar != null) {
                                zVar.dismiss();
                            }
                        } catch (Throwable th5) {
                            QLog.e("ZootopiaLoadingFragment_", 1, "dismiss exception " + th5);
                        }
                    }
                });
            }
        }

        public final void b(Context context, boolean cancelable, boolean cancelableOnTouchOutSide, boolean dismissWhenOnPause) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putBoolean("cancelable", cancelable);
            bundle.putBoolean("cancelableOnTouchOutSide", cancelableOnTouchOutSide);
            bundle.putBoolean("dismissWhenOnPause", dismissWhenOnPause);
            intent.putExtras(bundle);
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ZootopiaLoadingFragment.class);
            QLog.i("ZootopiaLoadingFragment_", 1, "show");
        }

        Companion() {
        }

        public static /* synthetic */ void c(Companion companion, Context context, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            if ((i3 & 4) != 0) {
                z17 = true;
            }
            if ((i3 & 8) != 0) {
                z18 = true;
            }
            companion.b(context, z16, z17, z18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(ZootopiaLoadingFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        boolean z16 = arguments != null ? arguments.getBoolean("cancelable") : true;
        Bundle arguments2 = getArguments();
        boolean z17 = arguments2 != null ? arguments2.getBoolean("cancelableOnTouchOutSide") : true;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            z zVar = new z(activity, z16, z17);
            zVar.show();
            zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.zootopia.view.aa
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ZootopiaLoadingFragment.rh(ZootopiaLoadingFragment.this, dialogInterface);
                }
            });
            QLog.i("ZootopiaLoadingFragment_", 1, "show dialog " + zVar);
            D.add(new WeakReference<>(zVar));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Bundle arguments = getArguments();
        if (arguments != null ? arguments.getBoolean("dismissWhenOnPause") : true) {
            INSTANCE.a();
        }
    }
}
