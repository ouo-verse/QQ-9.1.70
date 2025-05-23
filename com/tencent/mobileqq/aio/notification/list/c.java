package com.tencent.mobileqq.aio.notification.list;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter;
import com.tencent.mobileqq.aio.notification.list.n;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/c;", "Lcom/tencent/mobileqq/aio/notification/list/n;", "", "runPendingAnimations", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "animateRemoveImpl", "p", "animateAddImpl", "Lcom/tencent/mobileqq/aio/notification/list/c$b;", "o", "Lcom/tencent/mobileqq/aio/notification/list/c$b;", "animationInfoGetter", "Lcom/tencent/mobileqq/aio/notification/list/c$a;", "Lcom/tencent/mobileqq/aio/notification/list/c$a;", "animationEventCallback", "<init>", "(Lcom/tencent/mobileqq/aio/notification/list/c$b;Lcom/tencent/mobileqq/aio/notification/list/c$a;)V", "a", "b", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends n {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b animationInfoGetter;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a animationEventCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/c$a;", "", "", "P", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface a {
        void P();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull b animationInfoGetter, @NotNull a animationEventCallback) {
        super(true);
        Intrinsics.checkNotNullParameter(animationInfoGetter, "animationInfoGetter");
        Intrinsics.checkNotNullParameter(animationEventCallback, "animationEventCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animationInfoGetter, (Object) animationEventCallback);
        } else {
            this.animationInfoGetter = animationInfoGetter;
            this.animationEventCallback = animationEventCallback;
        }
    }

    @Override // com.tencent.mobileqq.aio.notification.list.n
    protected void animateAddImpl(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewPropertyAnimator animate = holder.itemView.animate();
        animate.setInterpolator(null);
        animate.translationY(0.0f);
        animate.alpha(1.0f);
        animate.scaleX(1.0f);
        animate.scaleY(1.0f);
        animate.setDuration(getAddDuration());
        animate.setListener(new n.d(this, holder));
        animate.start();
    }

    @Override // com.tencent.mobileqq.aio.notification.list.n
    protected void animateRemoveImpl(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        b.a B = this.animationInfoGetter.B((AIONotificationAdapter.b) holder);
        holder.itemView.setZ(B.e());
        ViewPropertyAnimator animate = holder.itemView.animate();
        animate.setInterpolator(null);
        animate.alpha(B.a());
        animate.scaleX(B.c());
        animate.scaleY(B.c());
        animate.translationY(B.d());
        animate.setDuration(((float) getRemoveDuration()) * B.b());
        animate.setListener(new n.e(this, holder));
        animate.start();
    }

    @Override // com.tencent.mobileqq.aio.notification.list.n
    protected void p(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        b.a C = this.animationInfoGetter.C((AIONotificationAdapter.b) holder);
        View view = holder.itemView;
        view.setTranslationY(C.d());
        view.setAlpha(C.a());
        view.setScaleX(C.c());
        view.setScaleY(C.c());
        view.setZ(C.e());
    }

    @Override // com.tencent.mobileqq.aio.notification.list.n, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.runPendingAnimations();
            this.animationEventCallback.P();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/c$b;", "", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$b;", "holder", "Lcom/tencent/mobileqq/aio/notification/list/c$b$a;", "B", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface b {
        @NotNull
        a B(@NotNull AIONotificationAdapter.b holder);

        @NotNull
        a C(@NotNull AIONotificationAdapter.b holder);

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/c$b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "d", "()F", "translationY", "b", com.tencent.luggage.wxa.c8.c.f123400v, "c", "scale", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "durationScale", "<init>", "(FFFFF)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes11.dex */
        public static final /* data */ class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final float translationY;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final float alpha;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private final float scale;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private final float z;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            private final float durationScale;

            public a(float f16, float f17, float f18, float f19, float f26) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26));
                    return;
                }
                this.translationY = f16;
                this.alpha = f17;
                this.scale = f18;
                this.z = f19;
                this.durationScale = f26;
            }

            public final float a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
                }
                return this.alpha;
            }

            public final float b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
                }
                return this.durationScale;
            }

            public final float c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
                }
                return this.scale;
            }

            public final float d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
                }
                return this.translationY;
            }

            public final float e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
                }
                return this.z;
            }

            public boolean equals(@Nullable Object other) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
                }
                if (this == other) {
                    return true;
                }
                if (!(other instanceof a)) {
                    return false;
                }
                a aVar = (a) other;
                if (Float.compare(this.translationY, aVar.translationY) == 0 && Float.compare(this.alpha, aVar.alpha) == 0 && Float.compare(this.scale, aVar.scale) == 0 && Float.compare(this.z, aVar.z) == 0 && Float.compare(this.durationScale, aVar.durationScale) == 0) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                    return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
                }
                return (((((((Float.floatToIntBits(this.translationY) * 31) + Float.floatToIntBits(this.alpha)) * 31) + Float.floatToIntBits(this.scale)) * 31) + Float.floatToIntBits(this.z)) * 31) + Float.floatToIntBits(this.durationScale);
            }

            @NotNull
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                    return (String) iPatchRedirector.redirect((short) 14, (Object) this);
                }
                return "AnimationInfo(translationY=" + this.translationY + ", alpha=" + this.alpha + ", scale=" + this.scale + ", z=" + this.z + ", durationScale=" + this.durationScale + ")";
            }

            public /* synthetic */ a(float f16, float f17, float f18, float f19, float f26, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(f16, f17, (i3 & 4) != 0 ? 1.0f : f18, (i3 & 8) != 0 ? 0.0f : f19, (i3 & 16) != 0 ? 1.0f : f26);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Integer.valueOf(i3), defaultConstructorMarker);
            }
        }
    }
}
