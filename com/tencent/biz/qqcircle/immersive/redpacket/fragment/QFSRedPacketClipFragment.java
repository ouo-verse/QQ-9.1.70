package com.tencent.biz.qqcircle.immersive.redpacket.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.redpacket.part.j;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/fragment/QFSRedPacketClipFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getLogTag", "getPageId", "<init>", "()V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSRedPacketClipFragment extends QFSBaseFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(QFSRedPacketClipFragment this$0, String str, Bundle result) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.d("QFSRedPacketClipFragment", 1, "fragment receive result, result: " + result);
        Serializable serializable = result.getSerializable(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_SELECT_START_TIME_RESULT);
        if (serializable instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) serializable;
            if (arrayList.size() == 1 && (arrayList.get(0) instanceof Long) && (activity = this$0.getActivity()) != null) {
                Intent intent = new Intent();
                Object obj = arrayList.get(0);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                intent.putExtra("ACTIVITY_RESULT_CLIP", ((Long) obj).longValue());
                Unit unit = Unit.INSTANCE;
                activity.setResult(-1, intent);
            }
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new j());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gq7;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSRedPacketClipFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getChildFragmentManager().setFragmentResultListener(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_RESULT, this, new FragmentResultListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.fragment.a
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                QFSRedPacketClipFragment.sh(QFSRedPacketClipFragment.this, str, bundle);
            }
        });
    }
}
