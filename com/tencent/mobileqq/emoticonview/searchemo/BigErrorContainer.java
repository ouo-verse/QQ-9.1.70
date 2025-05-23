package com.tencent.mobileqq.emoticonview.searchemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\tR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/BigErrorContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBigErrorContainerCb", "Lcom/tencent/mobileqq/emoticonview/searchemo/BigErrorContainer$BigErrorContainerCb;", "mBigLoadEmotionInnerError", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "mBigLoadFailedByNetwork", "mBigNoRelativeEmotion", "init", "", NodeProps.ON_ATTACHED_TO_WINDOW, "setBigErrorContainerCb", "bigErrorContainerCb", "showIcon", "type", "BigErrorContainerCb", "Companion", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class BigErrorContainer extends RelativeLayout {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int ICON_FAILED_BY_INNER_ERROR = 2;
    public static final int ICON_FAILED_BY_NETWORK = 1;
    public static final int ICON_NONE = -1;
    public static final int ICON_NO_RELATIVE_EMOTION = 0;

    @Nullable
    private BigErrorContainerCb mBigErrorContainerCb;

    @Nullable
    private QUIEmptyState mBigLoadEmotionInnerError;

    @Nullable
    private QUIEmptyState mBigLoadFailedByNetwork;

    @Nullable
    private QUIEmptyState mBigNoRelativeEmotion;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/BigErrorContainer$BigErrorContainerCb;", "", "clickReloadButton", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public interface BigErrorContainerCb {
        void clickReloadButton();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/BigErrorContainer$Companion;", "", "()V", "ICON_FAILED_BY_INNER_ERROR", "", "ICON_FAILED_BY_NETWORK", "ICON_NONE", "ICON_NO_RELATIVE_EMOTION", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21315);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigErrorContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private final void init() {
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(16);
        String string = getResources().getString(R.string.f224576ja);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026alog_load_relative_empty)");
        QUIEmptyState build = imageType.setTitle(string).setHalfScreenState(true).setBackgroundColorType(0).build();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        build.setLayoutParams(layoutParams);
        build.setVisibility(8);
        this.mBigNoRelativeEmotion = build;
        addView(build);
        QUIEmptyState.Builder imageType2 = new QUIEmptyState.Builder(getContext()).setImageType(5);
        String string2 = getResources().getString(R.string.f224556j9);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026_dialog_load_fail_by_net)");
        QUIEmptyState.Builder title = imageType2.setTitle(string2);
        String string3 = getResources().getString(R.string.f224596jc);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.search_dialog_reload)");
        QUIEmptyState build2 = title.setButton(string3, new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BigErrorContainer.init$lambda$2(BigErrorContainer.this, view);
            }
        }).setBackgroundColorType(0).setHalfScreenState(true).build();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        build2.setLayoutParams(layoutParams2);
        build2.setVisibility(8);
        this.mBigLoadFailedByNetwork = build2;
        addView(build2);
        QUIEmptyState.Builder imageType3 = new QUIEmptyState.Builder(getContext()).setImageType(5);
        String string4 = getResources().getString(R.string.f224566j_);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st\u2026ialog_load_fail_by_other)");
        QUIEmptyState.Builder title2 = imageType3.setTitle(string4);
        String string5 = getResources().getString(R.string.f224596jc);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.string.search_dialog_reload)");
        QUIEmptyState build3 = title2.setButton(string5, new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BigErrorContainer.init$lambda$5(BigErrorContainer.this, view);
            }
        }).setBackgroundColorType(0).setHalfScreenState(true).build();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13, -1);
        build3.setLayoutParams(layoutParams3);
        build3.setVisibility(8);
        this.mBigLoadEmotionInnerError = build3;
        addView(build3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(BigErrorContainer this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BigErrorContainerCb bigErrorContainerCb = this$0.mBigErrorContainerCb;
        if (bigErrorContainerCb != null) {
            bigErrorContainerCb.clickReloadButton();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$5(BigErrorContainer this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BigErrorContainerCb bigErrorContainerCb = this$0.mBigErrorContainerCb;
        if (bigErrorContainerCb != null) {
            bigErrorContainerCb.clickReloadButton();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onAttachedToWindow();
            init();
        }
    }

    public final void setBigErrorContainerCb(@NotNull BigErrorContainerCb bigErrorContainerCb) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bigErrorContainerCb);
        } else {
            Intrinsics.checkNotNullParameter(bigErrorContainerCb, "bigErrorContainerCb");
            this.mBigErrorContainerCb = bigErrorContainerCb;
        }
    }

    public final void showIcon(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, type);
            return;
        }
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    QUIEmptyState qUIEmptyState = this.mBigLoadEmotionInnerError;
                    if (qUIEmptyState != null) {
                        qUIEmptyState.setVisibility(8);
                    }
                    QUIEmptyState qUIEmptyState2 = this.mBigLoadFailedByNetwork;
                    if (qUIEmptyState2 != null) {
                        qUIEmptyState2.setVisibility(8);
                    }
                    QUIEmptyState qUIEmptyState3 = this.mBigNoRelativeEmotion;
                    if (qUIEmptyState3 != null) {
                        qUIEmptyState3.setVisibility(8);
                    }
                    setVisibility(8);
                    return;
                }
                QUIEmptyState qUIEmptyState4 = this.mBigLoadEmotionInnerError;
                if (qUIEmptyState4 != null) {
                    qUIEmptyState4.setVisibility(0);
                }
                QUIEmptyState qUIEmptyState5 = this.mBigLoadFailedByNetwork;
                if (qUIEmptyState5 != null) {
                    qUIEmptyState5.setVisibility(8);
                }
                QUIEmptyState qUIEmptyState6 = this.mBigNoRelativeEmotion;
                if (qUIEmptyState6 != null) {
                    qUIEmptyState6.setVisibility(8);
                }
                setVisibility(0);
                return;
            }
            QUIEmptyState qUIEmptyState7 = this.mBigLoadFailedByNetwork;
            if (qUIEmptyState7 != null) {
                qUIEmptyState7.setVisibility(0);
            }
            QUIEmptyState qUIEmptyState8 = this.mBigNoRelativeEmotion;
            if (qUIEmptyState8 != null) {
                qUIEmptyState8.setVisibility(8);
            }
            QUIEmptyState qUIEmptyState9 = this.mBigLoadEmotionInnerError;
            if (qUIEmptyState9 != null) {
                qUIEmptyState9.setVisibility(8);
            }
            setVisibility(0);
            return;
        }
        QUIEmptyState qUIEmptyState10 = this.mBigNoRelativeEmotion;
        if (qUIEmptyState10 != null) {
            qUIEmptyState10.setVisibility(0);
        }
        QUIEmptyState qUIEmptyState11 = this.mBigLoadEmotionInnerError;
        if (qUIEmptyState11 != null) {
            qUIEmptyState11.setVisibility(8);
        }
        QUIEmptyState qUIEmptyState12 = this.mBigLoadFailedByNetwork;
        if (qUIEmptyState12 != null) {
            qUIEmptyState12.setVisibility(8);
        }
        setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigErrorContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigErrorContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
