package com.tencent.mobileqq.vasgift.mvvm.business.banner;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.x;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u00018B'\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00104\u001a\u00020\u0004\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0002R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\"R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0019R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010\u0019R$\u0010\n\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/NoBoomHitNumberView;", "Landroid/widget/FrameLayout;", "", "l", "", "currentNum", "targetNum", "p", "stepSize", "k", WidgetCacheConstellationData.NUM, "", "i", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/e;", "listener", "setListener", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/BannerResManager;", "resManager", "setResManager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", DomainData.DOMAIN_NAME, "d", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/BannerResManager;", "e", "I", "f", "", tl.h.F, "Z", "isPlaying", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/g;", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/g;", "scaleAnimation", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/e;", "hitListener", BdhLogUtil.LogTag.Tag_Conn, "playedNum", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "numViewContainer", "E", "defaultLevel", "j", "()I", "setNum", "(I)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class NoBoomHitNumberView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int playedNum;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private LinearLayout numViewContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private final int defaultLevel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BannerResManager resManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int currentNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int targetNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isPlaying;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g scaleAnimation;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e hitListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vasgift/mvvm/business/banner/NoBoomHitNumberView$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (QLog.isColorLevel()) {
                QLog.i("Gift_Banner_HitNumberView", 1, "scale onAnimationCancel curNum:" + NoBoomHitNumberView.this.currentNum + " target:" + NoBoomHitNumberView.this.targetNum);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation, boolean isReverse) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            onAnimationEnd(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (NoBoomHitNumberView.this.isPlaying) {
                NoBoomHitNumberView noBoomHitNumberView = NoBoomHitNumberView.this;
                noBoomHitNumberView.playedNum = noBoomHitNumberView.currentNum;
                if (NoBoomHitNumberView.this.currentNum >= NoBoomHitNumberView.this.targetNum) {
                    NoBoomHitNumberView.this.isPlaying = false;
                    e eVar = NoBoomHitNumberView.this.hitListener;
                    if (eVar != null) {
                        eVar.h();
                        return;
                    }
                    return;
                }
                NoBoomHitNumberView noBoomHitNumberView2 = NoBoomHitNumberView.this;
                noBoomHitNumberView2.p(noBoomHitNumberView2.currentNum, NoBoomHitNumberView.this.targetNum);
                g gVar = NoBoomHitNumberView.this.scaleAnimation;
                if (gVar != null) {
                    gVar.d();
                }
                g gVar2 = NoBoomHitNumberView.this.scaleAnimation;
                if (gVar2 != null) {
                    gVar2.c();
                }
                e eVar2 = NoBoomHitNumberView.this.hitListener;
                if (eVar2 != null) {
                    eVar2.a();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation, boolean isReverse) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            onAnimationStart(animation);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NoBoomHitNumberView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final List<Integer> i(int num) {
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(0, Integer.valueOf(num % 10));
            num /= 10;
        } while (num > 0);
        return arrayList;
    }

    private final int k(int currentNum, int targetNum, int stepSize) {
        if (targetNum - currentNum > stepSize) {
            return currentNum + stepSize;
        }
        return targetNum;
    }

    private final void l() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.zvn);
        this.numViewContainer = linearLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(x.a(18.5f), x.a(17.0f)));
        LinearLayout linearLayout2 = this.numViewContainer;
        if (linearLayout2 != null) {
            linearLayout2.addView(imageView, 0);
        }
        g gVar = new g(this, 1.0f, 0.77f, 300L);
        this.scaleAnimation = gVar;
        gVar.a(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(int currentNum, int targetNum) {
        boolean z16;
        boolean z17;
        int k3;
        if (targetNum < currentNum) {
            return;
        }
        int i3 = targetNum - currentNum;
        boolean z18 = true;
        if (i3 >= 0 && i3 < 51) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            k3 = currentNum + 1;
        } else {
            if (51 <= i3 && i3 < 201) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                k3 = k(currentNum, targetNum, 10);
            } else {
                if (201 > i3 || i3 >= 1001) {
                    z18 = false;
                }
                if (z18) {
                    k3 = k(currentNum, targetNum, 50);
                } else {
                    k3 = k(currentNum, targetNum, 100);
                }
            }
        }
        setNum(k3);
    }

    /* renamed from: j, reason: from getter */
    public final int getCurrentNum() {
        return this.currentNum;
    }

    public final void m() {
        this.playedNum = 0;
    }

    public final void n() {
        QLog.i("Gift_Banner_HitNumberView", 1, "stop curNum " + this.currentNum + " isPlaying is " + this.isPlaying);
        this.isPlaying = false;
        g gVar = this.scaleAnimation;
        if (gVar != null) {
            gVar.d();
        }
        m();
    }

    public final void o(int num) {
        QLog.i("Gift_Banner_HitNumberView", 1, "toNum " + num + " isPlaying is " + this.isPlaying);
        int i3 = this.currentNum;
        if (i3 > num) {
            return;
        }
        this.targetNum = num;
        if (!this.isPlaying) {
            this.isPlaying = true;
            if (i3 == this.playedNum) {
                setNum(i3 + 1);
            }
            g gVar = this.scaleAnimation;
            if (gVar != null) {
                gVar.c();
            }
            e eVar = this.hitListener;
            if (eVar != null) {
                eVar.f();
            }
        }
    }

    public final void setListener(@Nullable e listener) {
        this.hitListener = listener;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setNum(int i3) {
        ImageView imageView;
        int size;
        int i16;
        Bitmap bitmap;
        Bitmap bitmap2;
        if (QLog.isColorLevel()) {
            QLog.i("Gift_Banner_HitNumberView", 1, "setNum " + i3);
        }
        this.currentNum = i3;
        List<Integer> i17 = i(i3);
        LinearLayout linearLayout = this.numViewContainer;
        if (linearLayout != null) {
            if (linearLayout.getChildCount() >= i17.size() + 1) {
                if (linearLayout.getChildCount() > i17.size() + 1) {
                    int childCount = linearLayout.getChildCount();
                    for (int size2 = i17.size() + 1; size2 < childCount; size2++) {
                        View childAt = linearLayout.getChildAt(size2);
                        if (childAt != null) {
                            childAt.setVisibility(8);
                        }
                    }
                }
                imageView = (ImageView) linearLayout.getChildAt(0);
                if (imageView != null) {
                    BannerResManager bannerResManager = this.resManager;
                    if (bannerResManager != null) {
                        bitmap2 = bannerResManager.B(this.defaultLevel);
                    } else {
                        bitmap2 = null;
                    }
                    imageView.setImageBitmap(bitmap2);
                }
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                size = i17.size();
                i16 = 0;
                while (i16 < size) {
                    int i18 = i16 + 1;
                    ImageView imageView2 = (ImageView) linearLayout.getChildAt(i18);
                    if (imageView2 != null) {
                        BannerResManager bannerResManager2 = this.resManager;
                        if (bannerResManager2 != null) {
                            bitmap = bannerResManager2.z(this.defaultLevel, i17.get(i16).intValue());
                        } else {
                            bitmap = null;
                        }
                        imageView2.setImageBitmap(bitmap);
                    }
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                    i16 = i18;
                }
            }
            do {
                linearLayout.addView(new ImageView(getContext()), new LinearLayout.LayoutParams(x.a(22.0f), x.a(30.0f)));
            } while (linearLayout.getChildCount() < i17.size() + 1);
            imageView = (ImageView) linearLayout.getChildAt(0);
            if (imageView != null) {
            }
            if (imageView != null) {
            }
            size = i17.size();
            i16 = 0;
            while (i16 < size) {
            }
        }
    }

    public final void setResManager(@Nullable BannerResManager resManager) {
        this.resManager = resManager;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NoBoomHitNumberView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ NoBoomHitNumberView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NoBoomHitNumberView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultLevel = 11;
        LayoutInflater.from(context).inflate(R.layout.h8x, (ViewGroup) this, true);
        l();
    }
}
