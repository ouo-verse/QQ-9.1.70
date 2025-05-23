package com.tencent.mobileqq.emoticonview.searchemo;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mCallback", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoRecyclerView$SearchEmoRecyclerViewCb;", IECSearchBar.METHOD_SET_CALLBACK, "", "callback", "Companion", "SearchEmoRecyclerViewCb", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class SearchEmoRecyclerView extends RecyclerView {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "SearchEmoRecyclerView";

    @Nullable
    private SearchEmoRecyclerViewCb mCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoRecyclerView$Companion;", "", "()V", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoRecyclerView$SearchEmoRecyclerViewCb;", "", "recyclerViewScrollToBottom", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public interface SearchEmoRecyclerViewCb {
        void recyclerViewScrollToBottom();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22242);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchEmoRecyclerView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
    }

    public final void setCallback(@NotNull SearchEmoRecyclerViewCb callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mCallback = callback;
        }
    }

    public /* synthetic */ SearchEmoRecyclerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchEmoRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        setLayoutManager(new LinearLayoutManager(context, 1, false));
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoRecyclerView.1
            static IPatchRedirector $redirector_;
            private int lastCompletelyVisibleItemPosition;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoRecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                SearchEmoRecyclerViewCb searchEmoRecyclerViewCb;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                    return;
                }
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    return;
                }
                int childCount = layoutManager.getChildCount();
                int itemCount = layoutManager.getItemCount();
                if (newState == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(SearchEmoRecyclerView.TAG, 2, "lastCompletelyVisibleItemPosition:" + this.lastCompletelyVisibleItemPosition + ", totalItemCount:" + itemCount);
                    }
                    if (childCount > 0 && this.lastCompletelyVisibleItemPosition >= itemCount - 1 && (searchEmoRecyclerViewCb = SearchEmoRecyclerView.this.mCallback) != null) {
                        searchEmoRecyclerViewCb.recyclerViewScrollToBottom();
                    }
                }
                if (newState == 0) {
                    AbstractGifImage.resumeAll();
                } else {
                    AbstractGifImage.pauseAll();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                    return;
                }
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    this.lastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
                    return;
                }
                throw new RuntimeException("Unsupported LayoutManager.");
            }
        });
    }
}
