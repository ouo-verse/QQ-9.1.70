package com.tencent.mobileqq.wink.templatelibrary.meme;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import com.tencent.mobileqq.wink.templatelibrary.meme.part.WinkMemeDetailPart;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/meme/WinkMemeDetailFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "<init>", "()V", "D", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMemeDetailFragment extends ImmersivePartFragment {

    @NotNull
    public Map<Integer, View> C = new LinkedHashMap();

    public void _$_clearFindViewByIdCache() {
        this.C.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WinkMemeDetailPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f169193i64;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        WinkHomeReportHelper.d(WinkHomeReportHelper.f326257a, getActivity(), getView(), WinkDaTongReportConstant.PageId.PG_XSJ_CAT_MEME_GENERATE_PAGE, null, 8, null);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
