package com.tencent.biz.qqcircle.aioshare.fragment;

import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.d;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.f;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/aioshare/fragment/QFSAIOWatchedFeedFragment;", "Lcom/tencent/biz/qqcircle/aioshare/fragment/QFSAIOBaseFeedFragment;", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "iPartHost", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/f;", "xh", "", "Dh", "", "getLogTag", "<init>", "()V", "K", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSAIOWatchedFeedFragment extends QFSAIOBaseFeedFragment {
    public QFSAIOWatchedFeedFragment() {
        super(ErrorCode.ERROR_CHECKLEGALAPP_INVALID_APP);
    }

    @Override // com.tencent.biz.qqcircle.aioshare.fragment.QFSAIOBaseFeedFragment
    public void Dh() {
        QLog.i("QFSAIOWatchedFeedFragment", 1, "[handleEmptyState]");
        Bh().M9(h.a(R.string.f188173vz), h.a(R.string.f188163vy));
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAIOWatchedFeedFragment";
    }

    @Override // com.tencent.biz.qqcircle.aioshare.fragment.QFSAIOBaseFeedFragment
    @NotNull
    public f xh(@NotNull IPartHost iPartHost) {
        Intrinsics.checkNotNullParameter(iPartHost, "iPartHost");
        d viewModel = (d) getViewModel(d.class);
        viewModel.X1(r.q(), getMSourceType());
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
        return viewModel;
    }
}
