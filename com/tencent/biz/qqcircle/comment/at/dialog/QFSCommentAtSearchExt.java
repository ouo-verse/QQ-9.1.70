package com.tencent.biz.qqcircle.comment.at.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.search.DefaultSearchLayoutExt;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentAtSearchExt<T> extends DefaultSearchLayoutExt implements TextWatcher, View.OnKeyListener {

    /* renamed from: d, reason: collision with root package name */
    protected RecyclerView f83506d;

    /* renamed from: e, reason: collision with root package name */
    private a<T> f83507e;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {
        public QCircleAvatarView E;

        public b(View view) {
            super(view);
        }
    }

    public QFSCommentAtSearchExt(@NonNull QUISearchBar qUISearchBar) {
        super(qUISearchBar);
        qUISearchBar.getInputWidget().addTextChangedListener(this);
        qUISearchBar.getInputWidget().setOnKeyListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkShowView() {
        if (this.f83506d != null && this.mIconIv != null) {
            a<T> aVar = this.f83507e;
            if (aVar != null && !aVar.isEmpty()) {
                this.f83506d.setVisibility(0);
                this.mIconIv.setVisibility(8);
            } else {
                this.f83506d.setVisibility(8);
                this.mIconIv.setVisibility(0);
            }
            if (this.f83507e != null) {
                int layoutWidthInPx = getLayoutWidthInPx(this.mBar.getCurStyle());
                ViewGroup.LayoutParams layoutParams = this.f83506d.getLayoutParams();
                if (layoutParams.width != layoutWidthInPx) {
                    layoutParams.width = layoutWidthInPx;
                    this.f83506d.setLayoutParams(layoutParams);
                }
                tryToScrollToLastPosition();
            }
        }
    }

    public void d(a<T> aVar) {
        this.f83507e = aVar;
        if (this.f83506d != null) {
            aVar.n0(this);
            this.f83506d.setAdapter(aVar);
        }
    }

    @Override // com.tencent.mobileqq.widget.search.DefaultSearchLayoutExt, com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public int getLayoutWidthInPx(int i3) {
        a<T> aVar = this.f83507e;
        if (aVar != null && !aVar.isEmpty()) {
            return Math.min(this.f83507e.getCalculateWidth() + this.f83506d.getPaddingLeft(), (int) (DisplayUtil.getScreenWidth() * 0.7f));
        }
        return super.getLayoutWidthInPx(i3);
    }

    @Override // com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public void onDetachView() {
        a<T> aVar = this.f83507e;
        if (aVar != null) {
            aVar.release();
            this.f83507e = null;
        }
    }

    @Override // com.tencent.mobileqq.widget.search.DefaultSearchLayoutExt, com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public void onInitLeftView(@NonNull FrameLayout frameLayout, int i3, int i16, int i17) {
        super.onInitLeftView(frameLayout, i3, i16, i17);
        RecyclerView recyclerView = new RecyclerView(frameLayout.getContext());
        this.f83506d = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(frameLayout.getContext(), 0, false));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1, 16);
        this.f83506d.setLayoutParams(layoutParams);
        this.f83506d.setClipToPadding(false);
        this.f83506d.setPadding(getLeftMargin(i3), 0, 0, 0);
        this.f83506d.setItemAnimator(null);
        d(this.f83507e);
        frameLayout.addView(this.f83506d, layoutParams);
        checkShowView();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (this.f83507e != null && i3 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(this.mBar.getInputWidget().getText().toString()) && this.f83507e.tryGrayItemOrDelete()) {
            tryToScrollToLastPosition();
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.widget.search.DefaultSearchLayoutExt, com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public void onUpdateLayout(int i3) {
        super.onUpdateLayout(i3);
        RecyclerView recyclerView = this.f83506d;
        if (recyclerView != null) {
            recyclerView.setPadding(getLeftMargin(i3), 0, 0, 0);
        }
    }

    protected void tryToScrollToLastPosition() {
        if (this.f83507e == null) {
            return;
        }
        this.f83506d.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.at.dialog.QFSCommentAtSearchExt.1
            @Override // java.lang.Runnable
            public void run() {
                if (QFSCommentAtSearchExt.this.f83507e != null) {
                    QFSCommentAtSearchExt.this.f83506d.scrollToPosition(r0.f83507e.getItemCount() - 1);
                }
            }
        }, 150L);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static abstract class a<T> extends RecyclerView.Adapter<b> {
        protected boolean D;
        protected QFSCommentAtSearchExt<T> E;
        final ArrayList<T> F = new ArrayList<>();

        /* renamed from: m, reason: collision with root package name */
        protected int f83508m = ViewUtils.dip2px(32.0f);
        protected int C = ViewUtils.dip2px(4.0f);

        @SuppressLint({"NotifyDataSetChanged"})
        @CallSuper
        public void addLast(T t16) {
            if (t16 != null && !this.F.contains(t16)) {
                this.D = false;
                if (!this.F.isEmpty()) {
                    notifyItemChanged(this.F.size() - 1);
                }
                this.F.add(t16);
                if (this.F.size() == 1) {
                    notifyDataSetChanged();
                } else {
                    notifyItemInserted(this.F.size());
                }
                QFSCommentAtSearchExt<T> qFSCommentAtSearchExt = this.E;
                if (qFSCommentAtSearchExt != null) {
                    qFSCommentAtSearchExt.checkShowView();
                }
            }
        }

        public int getCalculateWidth() {
            return (this.F.size() * this.f83508m) + ((this.F.size() - 1) * this.C);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.F.size();
        }

        protected abstract void i0(b bVar, int i3, T t16);

        public boolean isEmpty() {
            return this.F.isEmpty();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull b bVar, int i3) {
            float f16;
            int i16;
            T t16 = this.F.get(i3);
            if (t16 == null) {
                return;
            }
            View view = bVar.itemView;
            if (this.D && i3 == this.F.size() - 1) {
                f16 = 0.5f;
            } else {
                f16 = 1.0f;
            }
            view.setAlpha(f16);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) bVar.itemView.getLayoutParams();
            if (i3 == this.F.size() - 1) {
                i16 = 0;
            } else {
                i16 = this.C;
            }
            marginLayoutParams.rightMargin = i16;
            bVar.itemView.setLayoutParams(marginLayoutParams);
            i0(bVar, i3, t16);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
            Context context = viewGroup.getContext();
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            int i16 = this.f83508m;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i16, i16, 17);
            QCircleAvatarView qCircleAvatarView = new QCircleAvatarView(context);
            frameLayout.addView(qCircleAvatarView, layoutParams);
            b bVar = new b(frameLayout);
            bVar.E = qCircleAvatarView;
            return bVar;
        }

        @CallSuper
        public T m0() {
            this.D = false;
            if (this.F.isEmpty()) {
                return null;
            }
            int size = this.F.size() - 1;
            T remove = this.F.remove(size);
            notifyItemRemoved(size);
            if (!this.F.isEmpty()) {
                notifyItemChanged(size - 1);
            }
            QFSCommentAtSearchExt<T> qFSCommentAtSearchExt = this.E;
            if (qFSCommentAtSearchExt != null) {
                qFSCommentAtSearchExt.checkShowView();
            }
            return remove;
        }

        protected void n0(QFSCommentAtSearchExt<T> qFSCommentAtSearchExt) {
            this.E = qFSCommentAtSearchExt;
        }

        public void release() {
            this.E = null;
        }

        @CallSuper
        public void removeItem(T t16) {
            if (t16 != null && !this.F.isEmpty()) {
                int indexOf = this.F.indexOf(t16);
                if (indexOf == this.F.size() - 1) {
                    m0();
                    return;
                }
                if (indexOf >= 0) {
                    this.F.remove(indexOf);
                    notifyItemRemoved(indexOf);
                    QFSCommentAtSearchExt<T> qFSCommentAtSearchExt = this.E;
                    if (qFSCommentAtSearchExt != null) {
                        qFSCommentAtSearchExt.checkShowView();
                    }
                }
            }
        }

        public boolean tryGrayItemOrDelete() {
            if (this.F.isEmpty()) {
                return false;
            }
            if (this.D) {
                l0(m0());
            } else {
                this.D = true;
                notifyItemChanged(this.F.size() - 1);
            }
            return true;
        }

        @SuppressLint({"NotifyDataSetChanged"})
        @CallSuper
        public void updateData(List<T> list) {
            this.F.clear();
            this.D = false;
            if (list != null) {
                this.F.addAll(list);
            }
            notifyDataSetChanged();
            QFSCommentAtSearchExt<T> qFSCommentAtSearchExt = this.E;
            if (qFSCommentAtSearchExt != null) {
                qFSCommentAtSearchExt.checkShowView();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void l0(T t16) {
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
