package com.tencent.biz.qqcircle.immersive.views.search.simpleitem;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudRead$StSearchSmallItem;
import java.util.List;
import s90.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchSmallItemResultView extends QFSSearchBaseWidgetView<List<FeedCloudRead$StSearchSmallItem>> {

    /* renamed from: e, reason: collision with root package name */
    private final c f91204e;

    public QFSSearchSmallItemResultView(@NonNull Context context) {
        super(context);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.f54092e_);
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext(), 1, false));
        c cVar = new c();
        this.f91204e = cVar;
        recyclerView.setAdapter(cVar);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gsd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(List<FeedCloudRead$StSearchSmallItem> list, int i3) {
        this.f91204e.setDatas(list);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView
    public void setFragment(Fragment fragment) {
        super.setFragment(fragment);
        this.f91204e.i0(getQCircleBaseFragment());
    }

    public void setSource(int i3) {
        this.f91204e.j0(i3);
    }

    public void setTitle(String str) {
        TextView textView = (TextView) findViewById(R.id.f54112eb);
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
    }
}
