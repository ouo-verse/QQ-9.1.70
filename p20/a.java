package p20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends AbsListItemAdapterDelegate<o20.c, o20.c, RecyclerView.ViewHolder> {

    /* compiled from: P */
    /* renamed from: p20.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C10974a extends RecyclerView.ViewHolder {
        C10974a(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NonNull o20.c cVar, @NonNull List<o20.c> list, int i3) {
        if (cVar.f() == o20.c.f421789j) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        return new C10974a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g95, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NonNull o20.c cVar, @NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull List<Object> list) {
    }
}
