package cooperation.qqcircle.push;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QFSPushOpenBoxResultBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes28.dex */
public class QFSPushGetTreasureAdapter extends RecyclerView.Adapter<QFSPushGetTreasureResultItemView> {
    private static final String TAG = "QFSPushGetTreasureAdapter";
    private final List<QFSPushOpenBoxResultBean> mTreasureResultList = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mTreasureResultList.size();
    }

    public void setData(List<QFSPushOpenBoxResultBean> list) {
        this.mTreasureResultList.clear();
        this.mTreasureResultList.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(QFSPushGetTreasureResultItemView qFSPushGetTreasureResultItemView, int i3) {
        if (i3 >= this.mTreasureResultList.size()) {
            return;
        }
        qFSPushGetTreasureResultItemView.bindData(this.mTreasureResultList.get(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public QFSPushGetTreasureResultItemView onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new QFSPushGetTreasureResultItemView(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gpg, viewGroup, false));
    }
}
