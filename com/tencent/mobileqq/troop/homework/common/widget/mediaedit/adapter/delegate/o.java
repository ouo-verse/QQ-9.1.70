package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.medialist.MediaListAdapter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.MediaListItem;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/o;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/MediaListItem;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "p", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/medialist/MediaListAdapter;", "e", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/medialist/MediaListAdapter;", "adapter", "<init>", "()V", "f", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class o extends Section<MediaListItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    private static final int f296713h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView rv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MediaListAdapter adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/o$a;", "", "", "rvHorPadding", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.o$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46649);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
            f296713h = ViewUtils.dip2px(16.0f);
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f11918766};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.xw4);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.item_media_list_rv)");
            RecyclerView recyclerView = (RecyclerView) findViewById;
            this.rv = recyclerView;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rv");
                recyclerView = null;
            }
            recyclerView.setItemAnimator(null);
            this.adapter = new MediaListAdapter();
            RecyclerView recyclerView3 = this.rv;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rv");
                recyclerView3 = null;
            }
            MediaListAdapter mediaListAdapter = this.adapter;
            if (mediaListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                mediaListAdapter = null;
            }
            recyclerView3.setAdapter(mediaListAdapter);
            RecyclerView recyclerView4 = this.rv;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rv");
            } else {
                recyclerView2 = recyclerView4;
            }
            int i3 = f296713h;
            recyclerView2.setPadding(i3, 0, i3, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable MediaListItem data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        List<Object> list = payload;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        }
        RecyclerView recyclerView = null;
        MediaListAdapter mediaListAdapter = null;
        if (!z16) {
            Object obj = payload.get(0);
            if (obj instanceof Integer) {
                Number number = (Number) obj;
                if (number.intValue() > -1) {
                    MediaListAdapter mediaListAdapter2 = this.adapter;
                    if (mediaListAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        mediaListAdapter = mediaListAdapter2;
                    }
                    mediaListAdapter.notifyItemChanged(number.intValue());
                    return;
                }
            }
        }
        if (data == null) {
            return;
        }
        RecyclerView recyclerView2 = this.rv;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rv");
            recyclerView2 = null;
        }
        if (recyclerView2.getItemDecorationCount() == 0) {
            RecyclerView recyclerView3 = this.rv;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rv");
                recyclerView3 = null;
            }
            recyclerView3.addItemDecoration(new com.tencent.mobileqq.troop.widget.d(data.getSpanCount(), data.getSpacing(), false));
        }
        RecyclerView recyclerView4 = this.rv;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rv");
            recyclerView4 = null;
        }
        if (recyclerView4.getLayoutManager() == null) {
            RecyclerView recyclerView5 = this.rv;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rv");
                recyclerView5 = null;
            }
            RecyclerView recyclerView6 = this.rv;
            if (recyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rv");
                recyclerView6 = null;
            }
            recyclerView5.setLayoutManager(new GridLayoutManager(recyclerView6.getContext(), data.getSpanCount()));
        }
        MediaListAdapter mediaListAdapter3 = this.adapter;
        if (mediaListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            mediaListAdapter3 = null;
        }
        mediaListAdapter3.submitList(data.getData());
        if (data.getData().isEmpty()) {
            i3 = 8;
        }
        RecyclerView recyclerView7 = this.rv;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rv");
            recyclerView7 = null;
        }
        if (recyclerView7.getVisibility() != i3) {
            RecyclerView recyclerView8 = this.rv;
            if (recyclerView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rv");
            } else {
                recyclerView = recyclerView8;
            }
            recyclerView.setVisibility(i3);
        }
    }
}
