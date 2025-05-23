package mj1;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.component.multitouchimg.MultiTouchImageView;
import com.tencent.mobileqq.guild.component.multitouchimg.k;
import com.tencent.mobileqq.guild.component.multitouchimg.m;
import com.tencent.mobileqq.guild.feed.detail.event.GalleryPicScaleChangeEvent;
import com.tencent.mobileqq.guild.feed.detail.event.GalleryPicScaleFingerUpEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lmj1/b;", "", "Lcom/tencent/mobileqq/guild/component/multitouchimg/MultiTouchImageView;", "imageView", "", "c", "", "a", "Z", "isFingerGesture", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isFingerGesture;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"mj1/b$a", "Lcom/tencent/mobileqq/guild/component/multitouchimg/m;", "", "b", "", "scale", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements m {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.component.multitouchimg.m
        public void a(float scale) {
            b.this.isFingerGesture = false;
            SimpleEventBus.getInstance().dispatchEvent(new GalleryPicScaleFingerUpEvent(scale));
        }

        @Override // com.tencent.mobileqq.guild.component.multitouchimg.m
        public void b() {
            b.this.isFingerGesture = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b this$0, float f16, float f17, float f18, float f19) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isFingerGesture) {
            SimpleEventBus.getInstance().dispatchEvent(new GalleryPicScaleChangeEvent(f19));
        }
    }

    public final void c(@NotNull MultiTouchImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        imageView.l().c0(new a());
        imageView.setOnScaleChangeListener(new k() { // from class: mj1.a
            @Override // com.tencent.mobileqq.guild.component.multitouchimg.k
            public final void a(float f16, float f17, float f18, float f19) {
                b.d(b.this, f16, f17, f18, f19);
            }
        });
    }
}
