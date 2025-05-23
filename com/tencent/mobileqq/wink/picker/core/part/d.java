package com.tencent.mobileqq.wink.picker.core.part;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.adapter.a;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkQZoneMediaListFragment;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkAlbumListViewModel;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d extends Part {
    private a.InterfaceC9068a C;

    /* renamed from: d, reason: collision with root package name */
    private View f324593d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f324594e;

    /* renamed from: f, reason: collision with root package name */
    private WinkAlbumListViewModel f324595f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.wink.picker.core.viewmodel.v f324596h;

    /* renamed from: i, reason: collision with root package name */
    private Animation f324597i;

    /* renamed from: m, reason: collision with root package name */
    private Animation f324598m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.top = ViewUtils.dip2px(2.0f);
        }
    }

    @NotNull
    private Animation C9() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f155040hq);
        loadAnimation.setAnimationListener(new b());
        return loadAnimation;
    }

    @NotNull
    private Animation D9() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f155041hr);
        loadAnimation.setAnimationListener(new c());
        return loadAnimation;
    }

    private void E9() {
        if (getHostFragment() instanceof WinkMediaPickerMainBaseFragment) {
            this.C = new a.InterfaceC9068a() { // from class: com.tencent.mobileqq.wink.picker.core.part.b
                @Override // com.tencent.mobileqq.wink.picker.core.adapter.a.InterfaceC9068a
                public final void a() {
                    d.this.F9();
                }
            };
        }
        final com.tencent.mobileqq.wink.picker.core.adapter.a aVar = new com.tencent.mobileqq.wink.picker.core.adapter.a(getContext(), this.f324595f, this.C);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext(), 1, false);
        safeLinearLayoutManager.setOrientation(1);
        this.f324594e.setLayoutManager(safeLinearLayoutManager);
        this.f324594e.addItemDecoration(new a());
        this.f324594e.setAdapter(aVar);
        this.f324595f.Q1(this.f324596h.Q1());
        this.f324595f.S1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.this.G9(aVar, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F9() {
        ((WinkMediaPickerMainBaseFragment) getHostFragment()).ki(new WinkQZoneMediaListFragment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G9(com.tencent.mobileqq.wink.picker.core.adapter.a aVar, List list) {
        aVar.n0(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            QQAlbumInfo qQAlbumInfo = (QQAlbumInfo) it.next();
            if (QAlbumCustomAlbumConstants.RECENT_ALBUM_ID.equals(qQAlbumInfo.f203112id)) {
                this.f324595f.c2(qQAlbumInfo);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H9(boolean z16) {
        if (z16) {
            this.f324593d.startAnimation(this.f324597i);
        } else {
            this.f324593d.startAnimation(this.f324598m);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "WinkLocalAlbumListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        View findViewById = view.findViewById(R.id.f123927hz);
        this.f324593d = findViewById;
        findViewById.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        this.f324594e = (RecyclerView) this.f324593d;
        WinkAlbumListViewModel c16 = com.tencent.mobileqq.wink.picker.core.viewmodel.q.c((WinkMediaPickerMainBaseFragment) getHostFragment());
        this.f324595f = c16;
        c16.T1().observe(getPartHost().getHostLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.this.H9(((Boolean) obj).booleanValue());
            }
        });
        this.f324596h = com.tencent.mobileqq.wink.picker.core.viewmodel.q.i((WinkMediaPickerMainBaseFragment) getHostFragment());
        this.f324597i = C9();
        this.f324598m = D9();
        E9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        w53.b.a("WinkLocalAlbumListPart", "onPartDestroy");
        this.C = null;
        RecyclerView recyclerView = this.f324594e;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            d.this.f324593d.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d.this.f324593d.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
