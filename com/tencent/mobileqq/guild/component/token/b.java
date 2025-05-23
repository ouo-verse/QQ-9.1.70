package com.tencent.mobileqq.guild.component.token;

import android.view.View;
import android.widget.PopupWindow;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(message = "\u4f7f\u7528[com.tencent.mobileqq.widget.tip.QUIBubbleTip]")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\b\u0017\u0018\u0000 \u00032\u00020\u0001:\u0001\u0017B/\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J*\u0010\u0011\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J*\u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/component/token/b;", "Landroid/widget/PopupWindow;", "", "b", "Lcom/tencent/mobileqq/guild/component/token/AppearDirection;", "direction", "Lcom/tencent/mobileqq/guild/component/token/AppearDistance;", Element.ELEMENT_NAME_DISTANCE, "Lcom/tencent/mobileqq/guild/component/token/AppearDuration;", "duration", "", "d", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, LayoutAttrDefine.Gravity.Gravity, HippyTKDListViewAdapter.X, "y", "showAtLocation", "anchor", "xoff", "yoff", "showAsDropDown", "", "a", "J", "showTimeMs", "appearDirection", "appearDistance", "appearDuration", "<init>", "(Lcom/tencent/mobileqq/guild/component/token/AppearDirection;Lcom/tencent/mobileqq/guild/component/token/AppearDistance;Lcom/tencent/mobileqq/guild/component/token/AppearDuration;J)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class b extends PopupWindow {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long showTimeMs;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.component.token.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public /* synthetic */ class C7708b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f216017a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f216018b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f216019c;

        static {
            int[] iArr = new int[AppearDuration.values().length];
            try {
                iArr[AppearDuration.MS_150.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppearDuration.MS_300.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f216017a = iArr;
            int[] iArr2 = new int[AppearDistance.values().length];
            try {
                iArr2[AppearDistance.PX_60.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[AppearDistance.PX_120.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f216018b = iArr2;
            int[] iArr3 = new int[AppearDirection.values().length];
            try {
                iArr3[AppearDirection.NO_TRANS_ONLY_ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[AppearDirection.BOTTOM_TO_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[AppearDirection.LEFT_TO_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[AppearDirection.RIGHT_TO_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[AppearDirection.TOP_TO_BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            f216019c = iArr3;
        }
    }

    public b(@NotNull AppearDirection appearDirection, @NotNull AppearDistance appearDistance, @NotNull AppearDuration appearDuration, long j3) {
        Intrinsics.checkNotNullParameter(appearDirection, "appearDirection");
        Intrinsics.checkNotNullParameter(appearDistance, "appearDistance");
        Intrinsics.checkNotNullParameter(appearDuration, "appearDuration");
        this.showTimeMs = j3;
        setAnimationStyle(d(appearDirection, appearDistance, appearDuration));
    }

    private final void b() {
        if (this.showTimeMs > 0) {
            getContentView().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.component.token.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(b.this);
                }
            }, this.showTimeMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isShowing()) {
            this$0.dismiss();
        }
    }

    private final int d(AppearDirection direction, AppearDistance distance, AppearDuration duration) {
        int i3 = C7708b.f216019c[direction.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            int i16 = C7708b.f216018b[distance.ordinal()];
                            if (i16 != 1) {
                                if (i16 == 2) {
                                    int i17 = C7708b.f216017a[duration.ordinal()];
                                    if (i17 != 1) {
                                        if (i17 == 2) {
                                            return R.style.axu;
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    return R.style.axs;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            int i18 = C7708b.f216017a[duration.ordinal()];
                            if (i18 != 1) {
                                if (i18 == 2) {
                                    return R.style.axv;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            return R.style.axt;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    int i19 = C7708b.f216018b[distance.ordinal()];
                    if (i19 != 1) {
                        if (i19 == 2) {
                            int i26 = C7708b.f216017a[duration.ordinal()];
                            if (i26 != 1) {
                                if (i26 == 2) {
                                    return R.style.axp;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            return R.style.axn;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    int i27 = C7708b.f216017a[duration.ordinal()];
                    if (i27 != 1) {
                        if (i27 == 2) {
                            return R.style.axq;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return R.style.axo;
                }
                int i28 = C7708b.f216018b[distance.ordinal()];
                if (i28 != 1) {
                    if (i28 == 2) {
                        int i29 = C7708b.f216017a[duration.ordinal()];
                        if (i29 != 1) {
                            if (i29 == 2) {
                                return R.style.f174038ax1;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        return R.style.awz;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                int i36 = C7708b.f216017a[duration.ordinal()];
                if (i36 != 1) {
                    if (i36 == 2) {
                        return R.style.f174039ax2;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return R.style.f174037ax0;
            }
            int i37 = C7708b.f216018b[distance.ordinal()];
            if (i37 != 1) {
                if (i37 == 2) {
                    int i38 = C7708b.f216017a[duration.ordinal()];
                    if (i38 != 1) {
                        if (i38 == 2) {
                            return R.style.awb;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return R.style.aw_;
                }
                throw new NoWhenBranchMatchedException();
            }
            int i39 = C7708b.f216017a[duration.ordinal()];
            if (i39 != 1) {
                if (i39 == 2) {
                    return R.style.awc;
                }
                throw new NoWhenBranchMatchedException();
            }
            return R.style.awa;
        }
        int i46 = C7708b.f216017a[duration.ordinal()];
        if (i46 != 1) {
            if (i46 == 2) {
                return R.style.aw8;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.style.aw7;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(@Nullable View anchor, int xoff, int yoff, int gravity) {
        super.showAsDropDown(anchor, xoff, yoff, gravity);
        b();
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(@Nullable View parent, int gravity, int x16, int y16) {
        super.showAtLocation(parent, gravity, x16, y16);
        b();
    }
}
