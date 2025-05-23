package com.tencent.mobileqq.troop.deletemember;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.deletemember.parts.TroopDeleteMemberPart;
import com.tencent.mobileqq.troop.deletemember.parts.TroopDeleteMemberSelectPart;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/TroopDeleteMemberFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onFinish", "Lcom/tencent/mobileqq/troop/deletemember/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/deletemember/a;", "viewModel", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopDeleteMemberFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private a viewModel;

    public TroopDeleteMemberFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TroopDeleteMemberPart(), new TroopDeleteMemberSelectPart());
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.hz4;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        ViewModel viewModel = getViewModel(a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopDeleteMemberVM::class.java)");
        a aVar = (a) viewModel;
        this.viewModel = aVar;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        if (!aVar.O1(getArguments())) {
            getQBaseActivity().doOnBackPressed();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onFinish();
        a aVar = this.viewModel;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        if (aVar.M1() != 3) {
            a aVar3 = this.viewModel;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                aVar2 = aVar3;
            }
            if (aVar2.M1() != 1) {
                return;
            }
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            qBaseActivity.overridePendingTransition(0, R.anim.f154458a7);
        }
    }
}
