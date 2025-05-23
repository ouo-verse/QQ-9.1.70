package com.tencent.mobileqq.emoticonview.searchemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.searchemo.BigErrorContainer;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoFooterView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u001e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eJ\b\u0010#\u001a\u00020\u001dH\u0014J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\fJ\u0010\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u0010J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\tH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoFooterView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBigErrorContainer", "Lcom/tencent/mobileqq/emoticonview/searchemo/BigErrorContainer;", "mFinishInit", "", "mFooterViewCb", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoFooterView$FooterViewCb;", "mIsComposite", "mItemTextView", "Landroid/widget/TextView;", "mLoadingItemView", "Landroid/view/View;", "mLoadingStatus", "mLoadingTextView", "rightArrowDrawable", "Landroid/graphics/drawable/Drawable;", "getRightArrowDrawable", "()Landroid/graphics/drawable/Drawable;", "hideBigErrorContainer", "", "init", "notifyStatusChanged", "status", "emotionListIsEmpty", "isComposite", NodeProps.ON_ATTACHED_TO_WINDOW, "setBigErrorContainer", "bigErrorContainer", "setFooterViewCb", "footerViewCb", "showItemTextView", "stringResId", "clickable", "showLoadingView", "Companion", "FooterViewCb", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class SearchEmoFooterView extends RelativeLayout {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "SearchEmoFooterView";

    @Nullable
    private BigErrorContainer mBigErrorContainer;
    private boolean mFinishInit;

    @Nullable
    private FooterViewCb mFooterViewCb;
    private boolean mIsComposite;

    @Nullable
    private TextView mItemTextView;

    @Nullable
    private View mLoadingItemView;
    private int mLoadingStatus;

    @Nullable
    private TextView mLoadingTextView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoFooterView$Companion;", "", "()V", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoFooterView$FooterViewCb;", "", NodeProps.ON_CLICK, "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public interface FooterViewCb {
        void onClick();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22079);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SearchEmoFooterView(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private final Drawable getRightArrowDrawable() {
        Drawable drawable = getResources().getDrawable(R.drawable.jlt);
        int dip2px = ViewUtils.dip2px(15.0f);
        drawable.setBounds(0, 0, dip2px, dip2px);
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        return drawable;
    }

    private final void init() {
        if (this.mFinishInit) {
            QLog.i(TAG, 1, "already finish init, return");
            return;
        }
        TextView textView = (TextView) findViewById(R.id.d98);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchEmoFooterView.init$lambda$1$lambda$0(SearchEmoFooterView.this, view);
                }
            });
        } else {
            textView = null;
        }
        this.mItemTextView = textView;
        this.mLoadingTextView = (TextView) findViewById(R.id.efo);
        this.mLoadingItemView = findViewById(R.id.ysv);
        this.mFinishInit = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1$lambda$0(SearchEmoFooterView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FooterViewCb footerViewCb = this$0.mFooterViewCb;
        if (footerViewCb != null) {
            footerViewCb.onClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void showItemTextView(int stringResId, boolean clickable) {
        TextView textView = this.mItemTextView;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(stringResId);
            textView.setClickable(clickable);
        }
    }

    private final void showLoadingView(int stringResId) {
        View view = this.mLoadingItemView;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.mLoadingTextView;
        if (textView != null) {
            textView.setText(stringResId);
        }
    }

    public final void hideBigErrorContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "hideBigErrorContainer");
        BigErrorContainer bigErrorContainer = this.mBigErrorContainer;
        if (bigErrorContainer != null) {
            bigErrorContainer.showIcon(-1);
        }
    }

    public final void notifyStatusChanged(int status, boolean emotionListIsEmpty, boolean isComposite) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(status), Boolean.valueOf(emotionListIsEmpty), Boolean.valueOf(isComposite));
            return;
        }
        QLog.d(TAG, 2, "update status:" + status + ", FooterView FinishInit? " + this.mFinishInit + ", emotionListIsEmpty:" + emotionListIsEmpty + ", isComposite:" + isComposite);
        this.mLoadingStatus = status;
        this.mIsComposite = isComposite;
        if (!this.mFinishInit) {
            return;
        }
        switch (status) {
            case 0:
                TextView textView = this.mItemTextView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                View view = this.mLoadingItemView;
                if (view != null) {
                    view.setVisibility(8);
                }
                BigErrorContainer bigErrorContainer = this.mBigErrorContainer;
                if (bigErrorContainer != null) {
                    bigErrorContainer.showIcon(-1);
                    return;
                }
                return;
            case 1:
            case 5:
                if (isComposite) {
                    i3 = R.string.f224586jb;
                } else {
                    i3 = R.string.f224606jd;
                }
                showLoadingView(i3);
                TextView textView2 = this.mItemTextView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                BigErrorContainer bigErrorContainer2 = this.mBigErrorContainer;
                if (bigErrorContainer2 != null) {
                    bigErrorContainer2.showIcon(-1);
                    return;
                }
                return;
            case 2:
            case 4:
                if (emotionListIsEmpty) {
                    TextView textView3 = this.mItemTextView;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                    BigErrorContainer bigErrorContainer3 = this.mBigErrorContainer;
                    if (bigErrorContainer3 != null) {
                        bigErrorContainer3.showIcon(1);
                    }
                } else {
                    showItemTextView(R.string.yq7, true);
                    BigErrorContainer bigErrorContainer4 = this.mBigErrorContainer;
                    if (bigErrorContainer4 != null) {
                        bigErrorContainer4.showIcon(-1);
                    }
                }
                View view2 = this.mLoadingItemView;
                if (view2 != null) {
                    view2.setVisibility(8);
                    return;
                }
                return;
            case 3:
                showItemTextView(R.string.f220786_2, false);
                View view3 = this.mLoadingItemView;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
                BigErrorContainer bigErrorContainer5 = this.mBigErrorContainer;
                if (bigErrorContainer5 != null) {
                    bigErrorContainer5.showIcon(-1);
                    return;
                }
                return;
            case 6:
            default:
                TextView textView4 = this.mItemTextView;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
                View view4 = this.mLoadingItemView;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
                BigErrorContainer bigErrorContainer6 = this.mBigErrorContainer;
                if (bigErrorContainer6 != null) {
                    bigErrorContainer6.showIcon(-1);
                    return;
                }
                return;
            case 7:
                if (emotionListIsEmpty) {
                    TextView textView5 = this.mItemTextView;
                    if (textView5 != null) {
                        textView5.setVisibility(8);
                    }
                    BigErrorContainer bigErrorContainer7 = this.mBigErrorContainer;
                    if (bigErrorContainer7 != null) {
                        bigErrorContainer7.showIcon(2);
                    }
                } else {
                    BigErrorContainer bigErrorContainer8 = this.mBigErrorContainer;
                    if (bigErrorContainer8 != null) {
                        bigErrorContainer8.showIcon(-1);
                    }
                    showItemTextView(R.string.yq6, true);
                }
                View view5 = this.mLoadingItemView;
                if (view5 != null) {
                    view5.setVisibility(8);
                    return;
                }
                return;
            case 8:
                if (emotionListIsEmpty) {
                    TextView textView6 = this.mItemTextView;
                    if (textView6 != null) {
                        textView6.setVisibility(8);
                    }
                    BigErrorContainer bigErrorContainer9 = this.mBigErrorContainer;
                    if (bigErrorContainer9 != null) {
                        bigErrorContainer9.showIcon(0);
                    }
                } else {
                    BigErrorContainer bigErrorContainer10 = this.mBigErrorContainer;
                    if (bigErrorContainer10 != null) {
                        bigErrorContainer10.showIcon(-1);
                    }
                    showItemTextView(R.string.f220776_1, false);
                }
                View view6 = this.mLoadingItemView;
                if (view6 != null) {
                    view6.setVisibility(8);
                    return;
                }
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "attach to window, FooterView:" + hashCode());
        }
        super.onAttachedToWindow();
        init();
        notifyStatusChanged(this.mLoadingStatus, true, this.mIsComposite);
    }

    public final void setBigErrorContainer(@NotNull BigErrorContainer bigErrorContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bigErrorContainer);
            return;
        }
        Intrinsics.checkNotNullParameter(bigErrorContainer, "bigErrorContainer");
        this.mBigErrorContainer = bigErrorContainer;
        if (bigErrorContainer != null) {
            bigErrorContainer.setBigErrorContainerCb(new BigErrorContainer.BigErrorContainerCb() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoFooterView$setBigErrorContainer$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoFooterView.this);
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.BigErrorContainer.BigErrorContainerCb
                public void clickReloadButton() {
                    SearchEmoFooterView.FooterViewCb footerViewCb;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        footerViewCb = SearchEmoFooterView.this.mFooterViewCb;
                        if (footerViewCb != null) {
                            footerViewCb.onClick();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    public final void setFooterViewCb(@Nullable FooterViewCb footerViewCb) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) footerViewCb);
        } else {
            this.mFooterViewCb = footerViewCb;
        }
    }

    public SearchEmoFooterView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SearchEmoFooterView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
