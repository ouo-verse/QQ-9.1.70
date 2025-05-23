package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes.dex */
public class GuildStaggeredGridLayoutManager extends SafeStaggeredGridLayoutManager {
    private static final String TAG = "GuildStaggeredGridLayoutManager";
    private Parcelable state;

    public GuildStaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
        onRestoreInstanceState(this.state);
        super.onAttachedToWindow(recyclerView);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
        this.state = onSaveInstanceState();
        super.onDetachedFromWindow(recyclerView, recycler);
    }

    public GuildStaggeredGridLayoutManager(int i3, int i16) {
        super(i3, i16);
    }
}
