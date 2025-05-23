package com.tencent.mobileqq.guild.share.views;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View$OnLayoutChangeListener;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ShareActionSheetWithScrollPreview$onLayoutChangeListener$2 extends Lambda implements Function0<View.OnLayoutChangeListener> {
    final /* synthetic */ ShareActionSheetWithScrollPreview this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareActionSheetWithScrollPreview$onLayoutChangeListener$2(ShareActionSheetWithScrollPreview shareActionSheetWithScrollPreview) {
        super(0);
        this.this$0 = shareActionSheetWithScrollPreview;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final ShareActionSheetWithScrollPreview this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        boolean z16;
        View view2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z16 = this$0.isDismissing;
        if (z16) {
            return;
        }
        if (i3 != i19 || i17 != i27 || i16 != i26 || i18 != i28) {
            view2 = this$0.mPreviewContainer;
            view2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.share.views.f
                @Override // java.lang.Runnable
                public final void run() {
                    ShareActionSheetWithScrollPreview$onLayoutChangeListener$2.d(ShareActionSheetWithScrollPreview.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ShareActionSheetWithScrollPreview this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A0();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final View.OnLayoutChangeListener invoke() {
        final ShareActionSheetWithScrollPreview shareActionSheetWithScrollPreview = this.this$0;
        return new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.share.views.e
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                ShareActionSheetWithScrollPreview$onLayoutChangeListener$2.c(ShareActionSheetWithScrollPreview.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
    }
}
