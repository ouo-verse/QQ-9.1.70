package com.tencent.biz.qqcircle.aioshare.fragment;

import androidx.lifecycle.ViewModel;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.f;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.j;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/aioshare/fragment/QFSAIOCollectedFeedFragment;", "Lcom/tencent/biz/qqcircle/aioshare/fragment/QFSAIOBaseFeedFragment;", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "iPartHost", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/f;", "xh", "", "Dh", "", "getLogTag", "<init>", "()V", "K", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSAIOCollectedFeedFragment extends QFSAIOBaseFeedFragment {
    public QFSAIOCollectedFeedFragment() {
        super(ErrorCode.ERROR_CHECKLEGALAPP_INVALID_SDK_CLI_TYPE);
    }

    @Override // com.tencent.biz.qqcircle.aioshare.fragment.QFSAIOBaseFeedFragment
    public void Dh() {
        QLog.i("QFSAIOCollectedFeedFragment", 1, "[handleEmptyState]");
        Bh().M9(h.a(R.string.f188113vt), h.a(R.string.f188103vs));
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAIOCollectedFeedFragment";
    }

    @Override // com.tencent.biz.qqcircle.aioshare.fragment.QFSAIOBaseFeedFragment
    @NotNull
    public f xh(@NotNull IPartHost iPartHost) {
        Intrinsics.checkNotNullParameter(iPartHost, "iPartHost");
        ViewModel viewModel = getViewModel(j.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QFSPersonal\u2026eedViewModel::class.java)");
        return (f) viewModel;
    }
}
