package com.tencent.richframework.gallery;

import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.richframework.gallery.part.RFWLayerAnimPart;
import com.tencent.richframework.gallery.part.RFWLayerNavigationBarImmersivePart;
import com.tencent.richframework.gallery.part.RFWLayerPagePart;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/gallery/RFWLayerFragment;", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getContentLayoutId", "", "isOpenNavigationBarImmersive", "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class RFWLayerFragment extends BasePartFragment {
    private HashMap _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @NotNull
    public List<Part> assembleParts() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new RFWLayerAnimPart());
        linkedList.add(new RFWLayerPagePart());
        if (isOpenNavigationBarImmersive()) {
            linkedList.add(new RFWLayerNavigationBarImmersivePart());
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hn5;
    }

    public boolean isOpenNavigationBarImmersive() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
