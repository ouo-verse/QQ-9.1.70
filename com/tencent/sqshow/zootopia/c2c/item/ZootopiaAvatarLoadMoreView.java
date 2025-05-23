package com.tencent.sqshow.zootopia.c2c.item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.sqshow.zootopia.c2c.item.ZootopiaAvatarLoadMoreView;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.f;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R*\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaAvatarLoadMoreView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/widget/pull2refresh/ILoadMoreLayout;", "", "c", "e", "", "state", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "f", "oldState", "newState", "b", "setState", "getState", "checkState", "d", "I", "Lcom/airbnb/lottie/LottieDrawable;", "Lcom/airbnb/lottie/LottieDrawable;", ToastView.ICON_LOADING, "Ln74/f;", "Ln74/f;", "binding", "value", h.F, "Z", "isHorizontal", "()Z", "setHorizontal", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaAvatarLoadMoreView extends FrameLayout implements ILoadMoreLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LottieDrawable loading;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final f binding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isHorizontal;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaAvatarLoadMoreView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean b(int oldState, int newState) {
        if (oldState >= 0 && oldState != 0) {
            if (oldState != 1) {
                if (oldState != 2) {
                    if (oldState != 3) {
                        if (oldState != 4) {
                            if (oldState == 5) {
                                if (newState == 0 || newState == 1 || newState == 2 || newState == 3) {
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        if (newState == 0 || newState == 1 || newState == 3) {
                            return true;
                        }
                        return false;
                    }
                    if (newState == 0 || newState == 1 || newState == 2 || newState == 4 || newState == 5) {
                        return true;
                    }
                    return false;
                }
                if (newState == 0 || newState == 3 || newState == 4 || newState == 5) {
                    return true;
                }
                return false;
            }
            if (newState != 0 && newState != 3 && newState != 4 && newState != 5) {
                return false;
            }
        }
        return true;
    }

    private final void c() {
        LottieHelper.b(getContext(), "zootopia_load_more.json", null, i.b(16), i.b(16), -1, new LottieHelper.d() { // from class: j84.a
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                ZootopiaAvatarLoadMoreView.d(ZootopiaAvatarLoadMoreView.this, lottieDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ZootopiaAvatarLoadMoreView this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loading = lottieDrawable;
        this$0.binding.f419335c.setImageDrawable(lottieDrawable);
    }

    private final void e() {
        if (this.isHorizontal) {
            this.binding.f419336d.setVisibility(8);
            this.binding.f419334b.setVisibility(8);
            setLayoutParams(new RecyclerView.LayoutParams(i.a(15.6f), -1));
        } else {
            setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
        f(this.state, true);
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public boolean checkState(int state) {
        return b(this.state, state);
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public int getState() {
        return this.state;
    }

    public final void setHorizontal(boolean z16) {
        this.isHorizontal = z16;
        e();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaAvatarLoadMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaAvatarLoadMoreView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaAvatarLoadMoreView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        f f16 = f.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context),this)");
        this.binding = f16;
        this.isHorizontal = true;
        g(this, 0, false, 2, null);
        c();
        e();
    }

    private final boolean f(int state, boolean force) {
        if (!force && !b(this.state, state)) {
            return false;
        }
        this.state = state;
        if (state == 0) {
            if (this.isHorizontal) {
                this.binding.getRoot().setVisibility(8);
            } else {
                this.binding.getRoot().setVisibility(0);
                this.binding.f419335c.setVisibility(8);
                this.binding.f419336d.setVisibility(0);
                this.binding.f419334b.setVisibility(0);
            }
            LottieDrawable lottieDrawable = this.loading;
            if (lottieDrawable != null) {
                lottieDrawable.stop();
            }
        } else if (state == 1 || state == 2 || state == 3) {
            this.binding.getRoot().setVisibility(0);
            this.binding.f419335c.setVisibility(0);
            this.binding.f419336d.setVisibility(8);
            this.binding.f419334b.setVisibility(8);
            LottieDrawable lottieDrawable2 = this.loading;
            if (lottieDrawable2 != null && !lottieDrawable2.isAnimating()) {
                lottieDrawable2.start();
            }
        } else if (state == 4 || state == 5) {
            if (this.isHorizontal) {
                this.binding.getRoot().setVisibility(8);
            } else {
                this.binding.getRoot().setVisibility(0);
                this.binding.f419335c.setVisibility(8);
                this.binding.f419336d.setVisibility(0);
                this.binding.f419334b.setVisibility(8);
            }
            LottieDrawable lottieDrawable3 = this.loading;
            if (lottieDrawable3 != null) {
                lottieDrawable3.stop();
            }
        }
        return true;
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public boolean setState(int state) {
        return g(this, state, false, 2, null);
    }

    static /* synthetic */ boolean g(ZootopiaAvatarLoadMoreView zootopiaAvatarLoadMoreView, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        return zootopiaAvatarLoadMoreView.f(i3, z16);
    }
}
