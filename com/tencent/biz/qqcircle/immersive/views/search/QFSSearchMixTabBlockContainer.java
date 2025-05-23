package com.tencent.biz.qqcircle.immersive.views.search;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.search.b;
import com.tencent.biz.qqcircle.immersive.search.k;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudRead$StSearchSubTag;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchMixTabBlockContainer extends QFSSearchBlockContainer {

    /* renamed from: d, reason: collision with root package name */
    private final int f91056d;

    /* renamed from: e, reason: collision with root package name */
    private int f91057e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f91058f;

    /* renamed from: h, reason: collision with root package name */
    private k f91059h;

    public QFSSearchMixTabBlockContainer(Context context) {
        super(context);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.c_a);
        this.f91056d = dimensionPixelSize;
        this.f91057e = dimensionPixelSize;
    }

    private void a(FrameLayout frameLayout) {
        this.f91058f = (RecyclerView) frameLayout.findViewById(R.id.f7920495);
        k kVar = new k();
        this.f91059h = kVar;
        this.f91058f.setAdapter(kVar);
        RecyclerView recyclerView = this.f91058f;
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext(), 0, false));
    }

    private void c(boolean z16) {
        ViewGroup.LayoutParams layoutParams = this.f91058f.getLayoutParams();
        if (z16) {
            this.f91057e = this.f91056d;
            this.f91058f.setVisibility(0);
        } else {
            this.f91057e = 0;
            this.f91058f.setVisibility(8);
        }
        this.f91058f.setTranslationY(0.0f);
        int i3 = this.f91057e;
        layoutParams.height = i3;
        this.mRecyclerView.setPadding(0, i3, 0, 0);
    }

    public void b() {
        c(false);
    }

    public void d() {
        setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        this.f91058f.setVisibility(0);
    }

    public void e(String str, List<FeedCloudRead$StSearchSubTag> list, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return;
        }
        if (list != null && !list.isEmpty()) {
            c(true);
            this.f91059h.m0(str);
            this.f91059h.setDatas(list);
            this.f91058f.scrollToPosition(0);
            return;
        }
        if (this.f91059h.getNUM_BACKGOURND_ICON() == 0) {
            c(false);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    public int getLayoutId() {
        return R.layout.gs8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    public void initView() {
        super.initView();
        a(this);
        NestScrollRecyclerView recyclerView = getRecyclerView();
        recyclerView.setPadding(0, this.f91057e, 0, 0);
        recyclerView.setClipToPadding(false);
    }

    public void setFragment(Fragment fragment) {
        this.f91059h.l0(fragment);
    }

    public void setSubTagClickListener(b bVar) {
        this.f91059h.n0(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        this.mRecyclerView.setVisibility(i3);
        this.f91058f.setVisibility(i3);
    }

    public QFSSearchMixTabBlockContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.c_a);
        this.f91056d = dimensionPixelSize;
        this.f91057e = dimensionPixelSize;
    }

    public QFSSearchMixTabBlockContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.c_a);
        this.f91056d = dimensionPixelSize;
        this.f91057e = dimensionPixelSize;
    }
}
