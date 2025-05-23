package com.tencent.state.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.OnlineStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J,\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J,\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/view/ICommonBubbleMainContainer;", "", "bindSimpleView", "", "isZoom", "", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "isMe", "drawable", "Landroid/graphics/drawable/Drawable;", "customText", "", "getCommonMainContainerView", "Landroid/view/View;", "getMainText", "getSimpleSmallIconView", "Landroid/widget/ImageView;", "getSimpleTextView", "Landroid/widget/TextView;", "showSmallIcon", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ICommonBubbleMainContainer {
    void bindSimpleView(boolean isZoom, OnlineStatus status, boolean isMe, Drawable drawable, String customText);

    View getCommonMainContainerView();

    String getMainText(boolean isZoom, boolean isMe, OnlineStatus status, String customText);

    ImageView getSimpleSmallIconView();

    TextView getSimpleTextView();

    void showSmallIcon(boolean isZoom, OnlineStatus status, boolean isMe, Drawable drawable);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static void bindSimpleView(final ICommonBubbleMainContainer iCommonBubbleMainContainer, boolean z16, final OnlineStatus status, final boolean z17, final Drawable drawable, String str) {
            Intrinsics.checkNotNullParameter(status, "status");
            SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.view.ICommonBubbleMainContainer$bindSimpleView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    final Drawable drawable2 = drawable;
                    if (drawable2 == null) {
                        drawable2 = OnlineStatusBubbleViewHelper.getIconDrawable$default(OnlineStatusBubbleViewHelper.INSTANCE, status, z17, null, 4, null);
                    }
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.view.ICommonBubbleMainContainer$bindSimpleView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ImageView simpleSmallIconView = ICommonBubbleMainContainer.this.getSimpleSmallIconView();
                            if (simpleSmallIconView != null) {
                                simpleSmallIconView.setImageDrawable(drawable2);
                            }
                        }
                    });
                }
            });
            View commonMainContainerView = iCommonBubbleMainContainer.getCommonMainContainerView();
            if (commonMainContainerView != null) {
                commonMainContainerView.setVisibility(0);
            }
            ImageView simpleSmallIconView = iCommonBubbleMainContainer.getSimpleSmallIconView();
            if (simpleSmallIconView != null) {
                simpleSmallIconView.setVisibility(0);
            }
            String mainText = iCommonBubbleMainContainer.getMainText(z16, z17, status, str);
            TextView simpleTextView = iCommonBubbleMainContainer.getSimpleTextView();
            if (simpleTextView != null) {
                simpleTextView.setText(OnlineStatusBubbleViewHelper.INSTANCE.addSpaceSpan(mainText));
            }
            if (z17 && SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareBaseKt.getSquareLog().d("ICommonBubbleMainContainer", "[beatText] bindSimpleView, text:" + mainText);
            }
            TextView simpleTextView2 = iCommonBubbleMainContainer.getSimpleTextView();
            if (simpleTextView2 != null) {
                simpleTextView2.setVisibility(0);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static String getMainText(ICommonBubbleMainContainer iCommonBubbleMainContainer, boolean z16, boolean z17, OnlineStatus status, String str) {
            boolean z18;
            boolean isBlank;
            Intrinsics.checkNotNullParameter(status, "status");
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z18 = false;
                    return !z18 ? OnlineStatusBubbleViewHelper.INSTANCE.getBubbleMainText(z16, z17, status) : str;
                }
            }
            z18 = true;
            if (!z18) {
            }
        }

        public static void showSmallIcon(final ICommonBubbleMainContainer iCommonBubbleMainContainer, boolean z16, final OnlineStatus status, final boolean z17, final Drawable drawable) {
            Intrinsics.checkNotNullParameter(status, "status");
            SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.view.ICommonBubbleMainContainer$showSmallIcon$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    final Drawable drawable2 = drawable;
                    if (drawable2 == null) {
                        drawable2 = OnlineStatusBubbleViewHelper.getIconDrawable$default(OnlineStatusBubbleViewHelper.INSTANCE, status, z17, null, 4, null);
                    }
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.view.ICommonBubbleMainContainer$showSmallIcon$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ImageView simpleSmallIconView = ICommonBubbleMainContainer.this.getSimpleSmallIconView();
                            if (simpleSmallIconView != null) {
                                simpleSmallIconView.setImageDrawable(drawable2);
                            }
                        }
                    });
                }
            });
            View commonMainContainerView = iCommonBubbleMainContainer.getCommonMainContainerView();
            if (commonMainContainerView != null) {
                commonMainContainerView.setVisibility(0);
            }
            ImageView simpleSmallIconView = iCommonBubbleMainContainer.getSimpleSmallIconView();
            if (simpleSmallIconView != null) {
                simpleSmallIconView.setVisibility(0);
            }
            TextView simpleTextView = iCommonBubbleMainContainer.getSimpleTextView();
            if (simpleTextView != null) {
                simpleTextView.setVisibility(8);
            }
        }

        public static /* synthetic */ String getMainText$default(ICommonBubbleMainContainer iCommonBubbleMainContainer, boolean z16, boolean z17, OnlineStatus onlineStatus, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    str = null;
                }
                return iCommonBubbleMainContainer.getMainText(z16, z17, onlineStatus, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMainText");
        }

        public static /* synthetic */ void showSmallIcon$default(ICommonBubbleMainContainer iCommonBubbleMainContainer, boolean z16, OnlineStatus onlineStatus, boolean z17, Drawable drawable, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    drawable = null;
                }
                iCommonBubbleMainContainer.showSmallIcon(z16, onlineStatus, z17, drawable);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSmallIcon");
        }

        public static /* synthetic */ void bindSimpleView$default(ICommonBubbleMainContainer iCommonBubbleMainContainer, boolean z16, OnlineStatus onlineStatus, boolean z17, Drawable drawable, String str, int i3, Object obj) {
            if (obj == null) {
                iCommonBubbleMainContainer.bindSimpleView(z16, onlineStatus, z17, (i3 & 8) != 0 ? null : drawable, (i3 & 16) != 0 ? null : str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindSimpleView");
        }
    }
}
