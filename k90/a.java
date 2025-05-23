package k90;

import android.content.Context;
import com.tencent.biz.qqcircle.immersive.views.search.mixuser.QFSSearchMixUserItemView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends i80.a<QFSSearchMixUserItemView> {
    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.min(10, super.getItemCount());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i80.a
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public QFSSearchMixUserItemView i0(Context context, int i3) {
        return new QFSSearchMixUserItemView(context, i3);
    }
}
