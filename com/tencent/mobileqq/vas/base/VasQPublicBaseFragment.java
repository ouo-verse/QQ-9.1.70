package com.tencent.mobileqq.vas.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vas.report.a;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v23.Node;
import x23.c;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/base/VasQPublicBaseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lx23/c;", "ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "rh", "", "sh", "", "qh", BdhLogUtil.LogTag.Tag_Conn, "Lx23/c;", "reportChain", "<init>", "()V", "D", "a", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class VasQPublicBaseFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private c reportChain;

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c ph5 = ph();
        if (ph5 != null) {
            ph5.c(new Node(1));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        c c16;
        super.onDestroy();
        c ph5 = ph();
        if (ph5 != null && (c16 = ph5.c(new Node(7))) != null) {
            c16.end();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        c ph5 = ph();
        if (ph5 != null) {
            ph5.c(new Node(6));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        c ph5 = ph();
        if (ph5 != null) {
            ph5.c(new Node(4));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        c ph5 = ph();
        if (ph5 != null) {
            ph5.c(new Node(3));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        c ph5 = ph();
        if (ph5 != null) {
            ph5.c(new Node(2));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        c ph5 = ph();
        if (ph5 != null) {
            ph5.c(new Node(5));
        }
    }

    @Nullable
    protected final c ph() {
        if (TextUtils.isEmpty(rh())) {
            return null;
        }
        if (this.reportChain == null) {
            this.reportChain = a.f310626a.a(new w23.c(rh(), y23.a.INSTANCE.a(), sh(), qh(), 0L, 16, null));
        }
        return this.reportChain;
    }

    protected boolean qh() {
        return true;
    }

    @NotNull
    protected String rh() {
        return "";
    }

    protected int sh() {
        return 0;
    }
}
