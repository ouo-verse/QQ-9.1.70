package com.tencent.mobileqq.wink.publish.fs.activity;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.publish.base.PublishBaseFragment;
import com.tencent.mobileqq.wink.publish.part.ay;
import com.tencent.mobileqq.wink.utils.q;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes21.dex */
public class PublishPicPreviewFragment extends PublishBaseFragment {
    private List<Part> C;

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        this.C = new ArrayList();
        this.C.add(new ay());
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gue;
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PublishPicPreviewFragment";
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment
    public String getPageId() {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        q.a(getActivity(), -16777216);
        ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment
    public String ph() {
        return null;
    }
}
