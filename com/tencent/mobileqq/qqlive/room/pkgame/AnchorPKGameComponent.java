package com.tencent.mobileqq.qqlive.room.pkgame;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent;
import com.tencent.mobileqq.qqlive.framework.interfaceService.InjectService;
import fo3.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/pkgame/AnchorPKGameComponent;", "Lcom/tencent/mobileqq/qqlive/framework/component/SingleUIComponent;", "Landroid/widget/FrameLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "k", "i", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "Landroid/view/ViewGroup$MarginLayoutParams;", HippyTKDListViewAdapter.X, "Lfo3/e;", h.F, "Lkotlin/Lazy;", "y", "()Lfo3/e;", "pkGameLogic", "Lcom/tencent/mobileqq/qqlive/base/room/service/a;", "qqLiveRoomService", "Lcom/tencent/mobileqq/qqlive/base/room/service/a;", "Lei2/a;", "crossRoomLiveService", "Lei2/a;", "Lfo3/b;", "Lfo3/b;", "pkDependenceOnPageIn", "Lfi2/a;", "cc", "<init>", "(Lfi2/a;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AnchorPKGameComponent extends SingleUIComponent<FrameLayout> {
    static IPatchRedirector $redirector_;

    @InjectService(key = ei2.a.class)
    private ei2.a crossRoomLiveService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pkGameLogic;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private fo3.b pkDependenceOnPageIn;

    @InjectService(key = com.tencent.mobileqq.qqlive.base.room.service.a.class)
    private com.tencent.mobileqq.qqlive.base.room.service.a qqLiveRoomService;

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/qqlive/room/pkgame/AnchorPKGameComponent$a", "Lfo3/b;", "", "d", "", "getRoomId", "", "getAnchorId", "Landroid/widget/FrameLayout;", "b", "Landroid/os/Bundle;", "a", "", "c", "e", "f", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements fo3.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnchorPKGameComponent.this);
            }
        }

        @Override // fo3.b
        @NotNull
        public Bundle a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Bundle) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return new Bundle();
        }

        @Override // fo3.b
        @NotNull
        public FrameLayout b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (FrameLayout) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return AnchorPKGameComponent.v(AnchorPKGameComponent.this);
        }

        @Override // fo3.b
        @NotNull
        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "";
        }

        @Override // fo3.b
        public boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // fo3.b
        @NotNull
        public FrameLayout e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (FrameLayout) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return AnchorPKGameComponent.v(AnchorPKGameComponent.this);
        }

        @Override // fo3.b
        public boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // fo3.b
        public long getAnchorId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                com.tencent.mobileqq.qqlive.base.room.service.a aVar = AnchorPKGameComponent.this.qqLiveRoomService;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                    aVar = null;
                }
                QQLiveAnchorRoomInfo anchorRoomInfo = aVar.getAnchorRoomInfo();
                if (anchorRoomInfo != null) {
                    return anchorRoomInfo.uid;
                }
                return 0L;
            }
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }

        @Override // fo3.b
        public int getRoomId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                com.tencent.mobileqq.qqlive.base.room.service.a aVar = AnchorPKGameComponent.this.qqLiveRoomService;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                    aVar = null;
                }
                return (int) aVar.getRoomId();
            }
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorPKGameComponent(@NotNull fi2.a cc5) {
        super(cc5);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(cc5, "cc");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.qqlive.room.pkgame.AnchorPKGameComponent$pkGameLogic$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/room/pkgame/AnchorPKGameComponent$pkGameLogic$2$a", "Lcom/tencent/now/pkgame/a;", "", "bottomYPosition", "", "b", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes17.dex */
                public static final class a implements com.tencent.now.pkgame.a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ AnchorPKGameComponent f271866a;

                    a(AnchorPKGameComponent anchorPKGameComponent) {
                        this.f271866a = anchorPKGameComponent;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) anchorPKGameComponent);
                        }
                    }

                    @Override // com.tencent.now.pkgame.a
                    public void a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this);
                        } else {
                            this.f271866a.e().C0(new c());
                        }
                    }

                    @Override // com.tencent.now.pkgame.a
                    public void b(int bottomYPosition) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, bottomYPosition);
                        } else {
                            this.f271866a.e().C0(new d(bottomYPosition));
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnchorPKGameComponent.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final e invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new e(new a(AnchorPKGameComponent.this)) : (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.pkGameLogic = lazy;
            this.pkDependenceOnPageIn = new a();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) cc5);
    }

    public static final /* synthetic */ FrameLayout v(AnchorPKGameComponent anchorPKGameComponent) {
        return anchorPKGameComponent.r();
    }

    private final e y() {
        return (e) this.pkGameLogic.getValue();
    }

    public final void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            y().S();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return R.id.f25390ap;
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public FrameLayout p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new FrameLayout(e().getContext());
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent, com.tencent.mobileqq.qqlive.framework.component.i
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ViewGroup.MarginLayoutParams) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            y().R(e().getContext(), this.pkDependenceOnPageIn);
            y().N();
        }
    }
}
