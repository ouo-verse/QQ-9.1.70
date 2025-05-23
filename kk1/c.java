package kk1;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.component.multitouchimg.MultiTouchImageView;
import com.tencent.mobileqq.guild.component.multitouchimg.PhotoViewAttacher;
import com.tencent.mobileqq.guild.component.multitouchimg.k;
import com.tencent.mobileqq.guild.component.multitouchimg.m;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryCommonEleVisibleEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lkk1/c;", "", "", "scale", "", "f", "Lcom/tencent/mobileqq/guild/component/multitouchimg/MultiTouchImageView;", "imageView", "", "d", "a", "Z", "isFingerGesture", "b", "curZoom", "<init>", "()V", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isFingerGesture;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean curZoom;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"kk1/c$b", "Lcom/tencent/mobileqq/guild/component/multitouchimg/m;", "", "b", "", "scale", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements m {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.component.multitouchimg.m
        public void a(float scale) {
            QLog.i("GalleryPicScaleDetector", 1, "OnFingerUp scale=" + scale);
            c.this.isFingerGesture = false;
            if (!c.this.f(scale)) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryCommonEleVisibleEvent(true));
            }
        }

        @Override // com.tencent.mobileqq.guild.component.multitouchimg.m
        public void b() {
            QLog.i("GalleryPicScaleDetector", 1, "onFingerDown");
            c.this.isFingerGesture = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c this$0, float f16, float f17, float f18, float f19) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean f26 = this$0.f(f19);
        if (this$0.curZoom == f26) {
            return;
        }
        this$0.curZoom = f26;
        if (f26) {
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryCommonEleVisibleEvent(false));
        } else if (!this$0.isFingerGesture) {
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryCommonEleVisibleEvent(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(float scale) {
        if (Math.abs(1.0f - scale) > 0.1f) {
            return true;
        }
        return false;
    }

    public final void d(@NotNull MultiTouchImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        PhotoViewAttacher l3 = imageView.l();
        if (l3 != null) {
            l3.i0(new k() { // from class: kk1.b
                @Override // com.tencent.mobileqq.guild.component.multitouchimg.k
                public final void a(float f16, float f17, float f18, float f19) {
                    c.e(c.this, f16, f17, f18, f19);
                }
            });
        }
        PhotoViewAttacher l16 = imageView.l();
        if (l16 != null) {
            l16.c0(new b());
        }
    }
}
