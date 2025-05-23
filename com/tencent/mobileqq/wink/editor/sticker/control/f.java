package com.tencent.mobileqq.wink.editor.sticker.control;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.control.f;
import com.tencent.mobileqq.wink.view.DashedFrameView;
import com.tencent.videocut.model.StickerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/control/f;", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final long f321706b = 2500;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/control/f$a;", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "Landroid/widget/FrameLayout;", "dashedFrameContainer", "", "g", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "editorFragment", "c", "e", "", "DASHED_FRAME_DISPLAY_DURATION", "J", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.control.f$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(WinkStickerModel stickerModel, FrameLayout dashedFrameContainer) {
            Intrinsics.checkNotNullParameter(stickerModel, "$stickerModel");
            Intrinsics.checkNotNullParameter(dashedFrameContainer, "$dashedFrameContainer");
            f.INSTANCE.g(stickerModel, dashedFrameContainer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(FrameLayout dashedFrameContainer) {
            Intrinsics.checkNotNullParameter(dashedFrameContainer, "$dashedFrameContainer");
            dashedFrameContainer.setVisibility(4);
        }

        private final void g(WinkStickerModel stickerModel, FrameLayout dashedFrameContainer) {
            DashedFrameView dashedFrameView = new DashedFrameView(dashedFrameContainer.getContext());
            dashedFrameContainer.setVisibility(0);
            dashedFrameContainer.addView(dashedFrameView, new FrameLayout.LayoutParams(-1, -1));
            dashedFrameView.a(stickerModel);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(dashedFrameView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f, 0.4f, 1.0f, 0.4f, 1.0f, 0.0f);
            ofFloat.setDuration(f.f321706b);
            ofFloat.start();
        }

        public final void c(@NotNull BasePartFragment editorFragment, @NotNull final WinkStickerModel stickerModel) {
            final FrameLayout frameLayout;
            boolean z16;
            Intrinsics.checkNotNullParameter(editorFragment, "editorFragment");
            Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
            View view = editorFragment.getView();
            if (view != null) {
                frameLayout = (FrameLayout) view.findViewById(R.id.udl);
            } else {
                frameLayout = null;
            }
            if (frameLayout == null) {
                return;
            }
            StickerModel.Type type = stickerModel.type;
            if (type != StickerModel.Type.DEFAULT && type != StickerModel.Type.MASK && type != StickerModel.Type.CUSTOM) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return;
            }
            com.tencent.videocut.utils.thread.c.f384289c.e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.Companion.d(WinkStickerModel.this, frameLayout);
                }
            });
        }

        public final void e(@Nullable BasePartFragment editorFragment) {
            final FrameLayout frameLayout;
            View view;
            if (editorFragment != null && (view = editorFragment.getView()) != null) {
                frameLayout = (FrameLayout) view.findViewById(R.id.udl);
            } else {
                frameLayout = null;
            }
            if (frameLayout == null) {
                return;
            }
            com.tencent.videocut.utils.thread.c.f384289c.e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.Companion.f(frameLayout);
                }
            });
        }

        Companion() {
        }
    }
}
