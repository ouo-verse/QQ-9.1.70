package com.tencent.mobileqq.mini.common.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0003J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0019J\u0010\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\fJ\u0010\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010\fJ\u0010\u0010$\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010\fJ\u0010\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\fJ\u000e\u0010'\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013J\u000e\u0010(\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0019J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/mini/common/ui/LoadLayout;", "Landroid/widget/FrameLayout;", "mContext", "Landroid/content/Context;", "mOnLoadMoreClickAction", "Ljava/lang/Runnable;", "(Landroid/content/Context;Ljava/lang/Runnable;)V", "mDivider", "Landroid/view/View;", "mLoadLayout", "Landroid/widget/LinearLayout;", "mLoadMoreText", "", "mLoadingMoreText", "mLoadingText", "mNoMoreDataText", "mProgressBar", "Landroid/widget/ProgressBar;", "mState", "", "mTextView", "Landroid/widget/TextView;", "bindEvents", "", "checkState", "", "state", "getState", "initResources", "initView", "setDividerVisible", NodeProps.VISIBLE, "setLoadMoreText", "loadManualText", "setLoadingMoreText", "loadingText", "setLoadingText", "setNoMoreDataText", "noMoreDataText", "setState", "setVisible", "updateState", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class LoadLayout extends FrameLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int HIDE = 0;
    public static final int LOADING = 1;
    public static final int LOADING_MORE = 2;
    public static final int LOAD_MORE_PENDING = 3;
    public static final int NO_MORE_DATA = 4;
    private final Context mContext;
    private View mDivider;
    private LinearLayout mLoadLayout;
    private String mLoadMoreText;
    private String mLoadingMoreText;
    private String mLoadingText;
    private String mNoMoreDataText;
    private final Runnable mOnLoadMoreClickAction;
    private ProgressBar mProgressBar;
    private int mState;
    private TextView mTextView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/mini/common/ui/LoadLayout$Companion;", "", "()V", "HIDE", "", "LOADING", "LOADING_MORE", "LOAD_MORE_PENDING", "NO_MORE_DATA", "checkStateSwitch", "", "oldState", "newState", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean checkStateSwitch(int oldState, int newState) {
            if (oldState >= 0 && oldState != 0) {
                if (oldState != 1 && oldState != 2) {
                    if (oldState != 3) {
                        if (oldState == 4) {
                            if (newState == 0 || newState == 1 || newState == 3) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    if (newState == 0 || newState == 1 || newState == 2 || newState == 4) {
                        return true;
                    }
                    return false;
                }
                if (newState != 0 && newState != 3 && newState != 4) {
                    return false;
                }
            }
            return true;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadLayout(Context mContext, Runnable runnable) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mOnLoadMoreClickAction = runnable;
        this.mState = -1;
        initResources();
        initView();
        bindEvents();
    }

    private final void bindEvents() {
        LinearLayout linearLayout = this.mLoadLayout;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.common.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoadLayout.bindEvents$lambda$0(LoadLayout.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindEvents$lambda$0(LoadLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Runnable runnable = this$0.mOnLoadMoreClickAction;
        if (runnable != null) {
            runnable.run();
        }
    }

    private final void initResources() {
        this.mLoadMoreText = getResources().getString(R.string.xxo);
        this.mLoadingMoreText = getResources().getString(R.string.xxr);
        this.mNoMoreDataText = getResources().getString(R.string.xxp);
        this.mLoadingText = getResources().getString(R.string.xxq);
    }

    private final void initView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.djp, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.mLoadLayout = linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        this.mProgressBar = (ProgressBar) linearLayout.findViewById(R.id.rkj);
        LinearLayout linearLayout2 = this.mLoadLayout;
        Intrinsics.checkNotNull(linearLayout2);
        this.mTextView = (TextView) linearLayout2.findViewById(R.id.rlc);
        LinearLayout linearLayout3 = this.mLoadLayout;
        Intrinsics.checkNotNull(linearLayout3);
        this.mDivider = linearLayout3.findViewById(R.id.rdc);
        addView(this.mLoadLayout, new FrameLayout.LayoutParams(-1, -2));
        updateState(0);
    }

    private final boolean updateState(int state) {
        if (!INSTANCE.checkStateSwitch(this.mState, state)) {
            return false;
        }
        this.mState = state;
        if (state == 0) {
            LinearLayout linearLayout = this.mLoadLayout;
            Intrinsics.checkNotNull(linearLayout);
            linearLayout.setVisibility(8);
        } else if (state == 1) {
            ProgressBar progressBar = this.mProgressBar;
            Intrinsics.checkNotNull(progressBar);
            progressBar.setVisibility(0);
            TextView textView = this.mTextView;
            Intrinsics.checkNotNull(textView);
            textView.setText(this.mLoadingText);
            LinearLayout linearLayout2 = this.mLoadLayout;
            Intrinsics.checkNotNull(linearLayout2);
            linearLayout2.setVisibility(0);
        } else if (state == 2) {
            ProgressBar progressBar2 = this.mProgressBar;
            Intrinsics.checkNotNull(progressBar2);
            progressBar2.setVisibility(0);
            TextView textView2 = this.mTextView;
            Intrinsics.checkNotNull(textView2);
            textView2.setText(this.mLoadingMoreText);
            LinearLayout linearLayout3 = this.mLoadLayout;
            Intrinsics.checkNotNull(linearLayout3);
            linearLayout3.setVisibility(0);
        } else if (state == 3) {
            ProgressBar progressBar3 = this.mProgressBar;
            Intrinsics.checkNotNull(progressBar3);
            progressBar3.setVisibility(8);
            TextView textView3 = this.mTextView;
            Intrinsics.checkNotNull(textView3);
            textView3.setText(this.mLoadMoreText);
            LinearLayout linearLayout4 = this.mLoadLayout;
            Intrinsics.checkNotNull(linearLayout4);
            linearLayout4.setVisibility(0);
        } else if (state == 4) {
            ProgressBar progressBar4 = this.mProgressBar;
            Intrinsics.checkNotNull(progressBar4);
            progressBar4.setVisibility(8);
            TextView textView4 = this.mTextView;
            Intrinsics.checkNotNull(textView4);
            textView4.setText(this.mNoMoreDataText);
            LinearLayout linearLayout5 = this.mLoadLayout;
            Intrinsics.checkNotNull(linearLayout5);
            linearLayout5.setVisibility(0);
        }
        return true;
    }

    public final boolean checkState(int state) {
        return INSTANCE.checkStateSwitch(this.mState, state);
    }

    /* renamed from: getState, reason: from getter */
    public final int getMState() {
        return this.mState;
    }

    public final void setDividerVisible(boolean visible) {
        View view = this.mDivider;
        Intrinsics.checkNotNull(view);
        view.setVisibility(visible ? 0 : 8);
    }

    public final void setLoadMoreText(String loadManualText) {
        this.mLoadMoreText = loadManualText;
    }

    public final void setLoadingMoreText(String loadingText) {
        this.mLoadingMoreText = loadingText;
    }

    public final void setLoadingText(String loadingText) {
        this.mLoadingText = loadingText;
    }

    public final void setNoMoreDataText(String noMoreDataText) {
        this.mNoMoreDataText = noMoreDataText;
    }

    public final boolean setState(int state) {
        return updateState(state);
    }

    public final void setVisible(boolean visible) {
        LinearLayout linearLayout = this.mLoadLayout;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(visible ? 0 : 8);
    }
}
