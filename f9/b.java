package f9;

import android.text.TextUtils;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.biz.richframework.part.utils.ArrayUtils;
import com.tencent.richframework.gallery.adapter.RFWBaseLayerAdapter;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends RFWBaseLayerAdapter<RFWLayerItemMediaInfo> {
    public b(AdapterDelegatesManager adapterDelegatesManager) {
        super(adapterDelegatesManager);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (ArrayUtils.isOutOfArrayIndex(i3, getItems())) {
            return i3;
        }
        return TextUtils.isEmpty(getItems().get(i3).getMediaId()) ? i3 : r0.hashCode();
    }
}
