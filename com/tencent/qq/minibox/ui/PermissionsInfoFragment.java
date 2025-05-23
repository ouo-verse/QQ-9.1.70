package com.tencent.qq.minibox.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qq/minibox/ui/PermissionsInfoFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "()V", "getContentLayoutId", "", "onCreateCenterView", "Landroid/view/View;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "view", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "minibox-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class PermissionsInfoFragment extends QIphoneTitleBarFragment {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168279fi0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    @Nullable
    public View onCreateCenterView() {
        View onCreateCenterView = super.onCreateCenterView();
        setTitle("\u6743\u9650\u8be6\u60c5");
        return onCreateCenterView;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String str;
        boolean z16;
        String replace$default;
        boolean isBlank;
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("key_permissions");
        } else {
            str = null;
        }
        String str2 = str;
        if (str2 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    TextView textView = (TextView) view.findViewById(R.id.f2409087);
                    replace$default = StringsKt__StringsJVMKt.replace$default(str2, ";", "\n", false, 4, (Object) null);
                    textView.setText(replace$default);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }
}
