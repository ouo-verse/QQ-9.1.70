package com.tencent.mobileqq.widget.search.ext;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;
import com.tencent.mobileqq.widget.search.DefaultSearchLayoutExt;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.util.QQUIAppSetting;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ChatUserListExt<T> extends DefaultSearchLayoutExt implements TextWatcher, View.OnKeyListener {
    private static final String TAG = "ChatUserListExt";
    private BaseChatExtAdapter<T> mCacheAdapter;
    protected boolean mIsInDel;
    protected RecyclerView mRvIcon;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static abstract class BaseChatExtAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
        protected ChatUserListExt<T> mExt;
        protected boolean mIsInDel;
        final ArrayList<T> mData = new ArrayList<>();
        protected int mIconSize = ViewUtils.dip2px(40.0f);
        protected int mIconGap = ViewUtils.dip2px(4.0f);

        @SuppressLint({"NotifyDataSetChanged"})
        @CallSuper
        public void addLast(T t16) {
            if (t16 != null && !this.mData.contains(t16)) {
                this.mIsInDel = false;
                if (!this.mData.isEmpty()) {
                    notifyItemChanged(this.mData.size() - 1);
                }
                this.mData.add(t16);
                if (this.mData.size() == 1) {
                    notifyDataSetChanged();
                } else {
                    notifyItemInserted(this.mData.size());
                }
                ChatUserListExt<T> chatUserListExt = this.mExt;
                if (chatUserListExt != null) {
                    chatUserListExt.checkShowView();
                }
            }
        }

        protected abstract void bindViewHolder(ViewHolder viewHolder, int i3, T t16);

        protected View createIconView(Context context) {
            CircleBoarderImageView circleBoarderImageView = new CircleBoarderImageView(context);
            circleBoarderImageView.setBorderWidth(0);
            circleBoarderImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return circleBoarderImageView;
        }

        public int getCalculateWidth() {
            return (this.mData.size() * this.mIconSize) + ((this.mData.size() - 1) * this.mIconGap);
        }

        public List<T> getData() {
            return new ArrayList(this.mData);
        }

        protected abstract String getDesc(T t16);

        public T getItem(int i3) {
            return this.mData.get(i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mData.size();
        }

        protected void handleAccessibility(ViewHolder viewHolder, T t16) {
            if (QQUIAppSetting.enableTalkBack()) {
                AccessibilityUtil.s(viewHolder.ivIcon, getDesc(t16));
                AccessibilityUtil.n(viewHolder.ivMask, false);
            }
        }

        public boolean isEmpty() {
            return this.mData.isEmpty();
        }

        public void release() {
            this.mExt = null;
        }

        @CallSuper
        public void removeItem(T t16) {
            if (t16 != null && !this.mData.isEmpty()) {
                int indexOf = this.mData.indexOf(t16);
                if (indexOf == this.mData.size() - 1) {
                    removeLast();
                } else if (indexOf >= 0) {
                    notifyItemRemoved(indexOf);
                }
            }
        }

        @CallSuper
        public void removeLast() {
            this.mIsInDel = false;
            if (this.mData.isEmpty()) {
                return;
            }
            int size = this.mData.size() - 1;
            this.mData.remove(size);
            notifyItemRemoved(size);
            if (!this.mData.isEmpty()) {
                notifyItemChanged(size - 1);
            }
            ChatUserListExt<T> chatUserListExt = this.mExt;
            if (chatUserListExt != null) {
                chatUserListExt.checkShowView();
            }
        }

        protected void setExt(ChatUserListExt<T> chatUserListExt) {
            this.mExt = chatUserListExt;
        }

        public boolean tryGrayItemOrDelete() {
            if (this.mData.isEmpty()) {
                return false;
            }
            if (this.mIsInDel) {
                removeLast();
            } else {
                this.mIsInDel = true;
                notifyItemChanged(this.mData.size() - 1);
            }
            return true;
        }

        @SuppressLint({"NotifyDataSetChanged"})
        @CallSuper
        public void updateData(List<T> list) {
            this.mData.clear();
            this.mIsInDel = false;
            if (list != null) {
                this.mData.addAll(list);
            }
            notifyDataSetChanged();
            ChatUserListExt<T> chatUserListExt = this.mExt;
            if (chatUserListExt != null) {
                chatUserListExt.checkShowView();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i3) {
            T t16 = this.mData.get(i3);
            if (t16 == null) {
                return;
            }
            handleAccessibility(viewHolder, t16);
            viewHolder.itemView.setAlpha((this.mIsInDel && i3 == this.mData.size() + (-1)) ? 0.5f : 1.0f);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.itemView.getLayoutParams();
            marginLayoutParams.rightMargin = i3 == this.mData.size() + (-1) ? 0 : this.mIconGap;
            viewHolder.itemView.setLayoutParams(marginLayoutParams);
            bindViewHolder(viewHolder, i3, t16);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            Context context = viewGroup.getContext();
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
            int i16 = this.mIconSize;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i16, i16, 17);
            View createIconView = createIconView(context);
            frameLayout.addView(createIconView, layoutParams);
            TextView textView = new TextView(context);
            textView.setTextColor(ie0.a.f().g(context, R.color.qui_common_text_primary, 1001));
            textView.setTextSize(12.0f);
            textView.setMaxLines(1);
            textView.setGravity(17);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            frameLayout.addView(textView, layoutParams);
            View view = new View(context);
            view.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.kpd, null));
            frameLayout.addView(view, layoutParams);
            ViewHolder viewHolder = new ViewHolder(frameLayout);
            viewHolder.ivIcon = createIconView;
            viewHolder.tvName = textView;
            viewHolder.ivMask = view;
            return viewHolder;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View ivIcon;
        public View ivMask;
        public TextView tvName;

        public ViewHolder(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends RecyclerView {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f317295f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context);
            this.f317295f = context2;
        }

        private void C(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return;
                        }
                    }
                }
                D(true);
                return;
            }
            D(false);
        }

        private void D(boolean z16) {
            Context context = this.f317295f;
            if (context instanceof Activity) {
                View decorView = ((Activity) context).getWindow().getDecorView();
                if (decorView instanceof ViewGroup) {
                    View childAt = ((ViewGroup) decorView).getChildAt(0);
                    if (childAt instanceof TopGestureLayout) {
                        ((TopGestureLayout) childAt).setIsInterceptChildEventWhenScroll(z16);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            C(motionEvent);
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            C(motionEvent);
            return super.onTouchEvent(motionEvent);
        }
    }

    public ChatUserListExt(@NonNull QUISearchBar qUISearchBar) {
        super(qUISearchBar);
        qUISearchBar.getInputWidget().addTextChangedListener(this);
        qUISearchBar.getInputWidget().setOnKeyListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkShowView() {
        if (this.mRvIcon != null && this.mIconIv != null) {
            BaseChatExtAdapter<T> baseChatExtAdapter = this.mCacheAdapter;
            if (baseChatExtAdapter != null && !baseChatExtAdapter.isEmpty()) {
                this.mRvIcon.setVisibility(0);
                this.mIconIv.setVisibility(8);
            } else {
                this.mRvIcon.setVisibility(8);
                this.mIconIv.setVisibility(0);
            }
            if (this.mCacheAdapter != null) {
                int layoutWidthInPx = getLayoutWidthInPx(this.mBar.getCurStyle());
                ViewGroup.LayoutParams layoutParams = this.mRvIcon.getLayoutParams();
                if (layoutParams.width != layoutWidthInPx) {
                    layoutParams.width = layoutWidthInPx;
                    this.mRvIcon.setLayoutParams(layoutParams);
                }
                tryToScrollToLastPosition();
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.search.DefaultSearchLayoutExt, com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public int getLayoutWidthInPx(int i3) {
        BaseChatExtAdapter<T> baseChatExtAdapter = this.mCacheAdapter;
        if (baseChatExtAdapter != null && !baseChatExtAdapter.isEmpty()) {
            return Math.min(this.mCacheAdapter.getCalculateWidth() + this.mRvIcon.getPaddingLeft(), (int) (ScreenUtil.getRealWidth(this.mRvIcon.getContext()) * 0.7f));
        }
        return super.getLayoutWidthInPx(i3);
    }

    protected RecyclerView getRecyclerView(Context context) {
        return new a(context, context);
    }

    @Override // com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public void onDetachView() {
        BaseChatExtAdapter<T> baseChatExtAdapter = this.mCacheAdapter;
        if (baseChatExtAdapter != null) {
            baseChatExtAdapter.release();
            this.mCacheAdapter = null;
        }
    }

    @Override // com.tencent.mobileqq.widget.search.DefaultSearchLayoutExt, com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public void onInitLeftView(@NonNull FrameLayout frameLayout, int i3, int i16, int i17) {
        super.onInitLeftView(frameLayout, i3, i16, i17);
        RecyclerView recyclerView = getRecyclerView(frameLayout.getContext());
        this.mRvIcon = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(frameLayout.getContext(), 0, false));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1, 16);
        this.mRvIcon.setLayoutParams(layoutParams);
        this.mRvIcon.setClipToPadding(false);
        this.mRvIcon.setPadding(getLeftMargin(i3), 0, 0, 0);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) this.mRvIcon.getItemAnimator();
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        setAdapter(this.mCacheAdapter);
        frameLayout.addView(this.mRvIcon, layoutParams);
        checkShowView();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (this.mCacheAdapter != null && i3 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(this.mBar.getInputWidget().getText().toString()) && this.mCacheAdapter.tryGrayItemOrDelete()) {
            tryToScrollToLastPosition();
            return true;
        }
        return false;
    }

    public void onLayoutChange() {
        checkShowView();
    }

    @Override // com.tencent.mobileqq.widget.search.DefaultSearchLayoutExt, com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public void onUpdateLayout(int i3) {
        super.onUpdateLayout(i3);
        RecyclerView recyclerView = this.mRvIcon;
        if (recyclerView != null) {
            recyclerView.setPadding(getLeftMargin(i3), 0, 0, 0);
        }
    }

    public void setAdapter(BaseChatExtAdapter<T> baseChatExtAdapter) {
        this.mCacheAdapter = baseChatExtAdapter;
        if (this.mRvIcon != null) {
            baseChatExtAdapter.setExt(this);
            this.mRvIcon.setAdapter(baseChatExtAdapter);
        }
    }

    protected void tryToScrollToLastPosition() {
        if (this.mCacheAdapter == null) {
            return;
        }
        this.mRvIcon.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.search.ext.ChatUserListExt.2
            @Override // java.lang.Runnable
            public void run() {
                if (ChatUserListExt.this.mCacheAdapter != null) {
                    ChatUserListExt.this.mRvIcon.scrollToPosition(r0.mCacheAdapter.getItemCount() - 1);
                }
            }
        }, 150L);
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
