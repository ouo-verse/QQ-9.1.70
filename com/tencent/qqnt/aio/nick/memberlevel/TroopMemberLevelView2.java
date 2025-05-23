package com.tencent.qqnt.aio.nick.memberlevel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.MosaicTextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.nick.e;
import com.tencent.qqnt.aio.nick.f;
import cooperation.qzone.QZoneClickReport;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B\u000f\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0014J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0017H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/aio/nick/memberlevel/TroopMemberLevelView2;", "Lcom/tencent/mobileqq/qqui/widget/MosaicTextView;", "Lcom/tencent/qqnt/aio/nick/memberlevel/b;", "", "height", "b", "", "c", "Lcom/tencent/qqnt/aio/nick/f;", "info", "Lcom/tencent/qqnt/aio/nick/e;", "drawableInfo", "setTroopMemberLevel", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "Landroid/graphics/drawable/Drawable;", "who", "", "verifyDrawable", "onDraw", "isMosaic", "setMosaic", "e", "Lcom/tencent/qqnt/aio/nick/f;", "memberLevelInfo", "f", "Landroid/graphics/drawable/Drawable;", "vipEffectDrawable", "Z", "vipEffectShowBottom", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TroopMemberLevelView2 extends MosaicTextView implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    private static final boolean f351730m;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f memberLevelInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable vipEffectDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean vipEffectShowBottom;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/nick/memberlevel/TroopMemberLevelView2$a;", "", "", "TAG", "Ljava/lang/String;", "", "VIP_EFFECT_TIME_DEL", "I", "", "displayLoop", "Z", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.nick.memberlevel.TroopMemberLevelView2$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60430);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
            f351730m = ar.INSTANCE.b("kenaiyu", "2025-03-19", "vas_troop_effect_display_once").isEnable(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberLevelView2(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private final int b(int height) {
        return (height * 51) / 14;
    }

    private final void c() {
        setText("");
    }

    @Override // android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (!this.vipEffectShowBottom && (drawable = this.vipEffectDrawable) != null) {
            drawable.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqui.widget.MosaicTextView, android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.vipEffectShowBottom && (drawable = this.vipEffectDrawable) != null) {
            drawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(w3, h16, oldw, oldh);
        if (this.vipEffectShowBottom) {
            Drawable drawable = this.vipEffectDrawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, w3, h16);
                return;
            }
            return;
        }
        Drawable drawable2 = this.vipEffectDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, b(h16), h16);
        }
    }

    @Override // com.tencent.qqnt.aio.nick.memberlevel.b
    public void setMosaic(boolean isMosaic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, isMosaic);
        } else if (isMosaic) {
            setMosaicEffect(new com.tencent.mobileqq.qqui.widget.b(10));
        } else {
            setMosaicEffect(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02a3  */
    @Override // com.tencent.qqnt.aio.nick.memberlevel.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTroopMemberLevel(@NotNull f info, @NotNull e drawableInfo) {
        Typeface create;
        boolean z16;
        boolean z17;
        boolean startsWith$default;
        boolean startsWith$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) info, (Object) drawableInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(drawableInfo, "drawableInfo");
        if (info.a(this.memberLevelInfo)) {
            return;
        }
        Drawable drawable = this.vipEffectDrawable;
        if (drawable != null) {
            drawable.setCallback(null);
            this.vipEffectDrawable = null;
        }
        this.memberLevelInfo = info;
        boolean z18 = true;
        if (info.l() && !info.m() && (info.i() < 1 || info.b().length < 2)) {
            c();
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberLevelView2", 2, "setTroopMemberNewLevel error isShowLevel : " + info.l() + ", isShowRank:" + info.m() + ",newLevel:" + info.b());
                return;
            }
            return;
        }
        if (info.m() && (TextUtils.isEmpty(info.h()) || info.e().length < 2)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberLevelView2", 2, "setTroopMemberNewLevel error isShowRank:" + info.m() + ",rankTitle:" + info.h());
                return;
            }
            return;
        }
        c();
        StringBuilder sb5 = new StringBuilder();
        setContentDescription("");
        if (info.l() || info.m()) {
            setBackground(drawableInfo.a());
            setVisibility(0);
            StringBuilder sb6 = new StringBuilder();
            if (info.l()) {
                sb6.append("LV");
                sb6.append(info.i());
                sb5.append(getContext().getResources().getString(R.string.f180893ca));
                sb5.append(info.i());
            }
            if (info.l() && info.m()) {
                sb6.append(" ");
            }
            if (info.m()) {
                sb6.append(info.h());
                sb5.append(info.h());
            }
            setGravity(16);
            setMaxLines(1);
            setLayoutParams(new FrameLayout.LayoutParams(-2, ViewUtils.dpToPx(14.0f)));
            setText(sb6);
            setTextColor(info.g());
            setTypeface(Typeface.defaultFromStyle(0));
            setTextSize(2, 9.0f);
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    create = Typeface.create(null, 600, false);
                    setTypeface(create);
                    Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
            }
            setPadding(ViewUtils.dpToPx(4.0f), getPaddingTop(), ViewUtils.dpToPx(4.0f), getPaddingBottom());
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (!f351730m) {
                String j3 = info.j();
                if (!(j3 == null || j3.length() == 0)) {
                    VipNtMMKV.Companion companion3 = VipNtMMKV.INSTANCE;
                    long decodeLong = companion3.getTroopVipEffect().decodeLong(info.d() + info.k(), 0L);
                    long currentTimeMillis = System.currentTimeMillis();
                    long abs = Math.abs(currentTimeMillis - decodeLong);
                    if (abs >= 1000) {
                        if (abs < 86400000) {
                            booleanRef.element = true;
                        } else {
                            companion3.getTroopVipEffect().encodeLong(info.d() + info.k(), currentTimeMillis);
                        }
                    }
                }
            }
            String j16 = info.j();
            if (!(j16 == null || j16.length() == 0)) {
                String j17 = info.j();
                if (j17 != null) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(j17, "https://tianquan.gtimg.cn/shoal/vaclient/groupInteract", false, 2, null);
                    if (startsWith$default2) {
                        z16 = true;
                        if (!z16) {
                            String j18 = info.j();
                            if (j18 != null) {
                                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(j18, "https://tianquan.gtimg.cn/shoal/vaclient/vas-groupInteract-new-250423-4-1-", false, 2, null);
                                if (startsWith$default) {
                                    z17 = true;
                                    if (!z17) {
                                        z18 = false;
                                    }
                                }
                            }
                            z17 = false;
                            if (!z17) {
                            }
                        }
                        this.vipEffectShowBottom = z18;
                        if (!z18) {
                            a.C1005a l3 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE);
                            String j19 = info.j();
                            Intrinsics.checkNotNull(j19);
                            final FastDynamicDrawable a16 = l3.k(j19).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).h(TroopMemberLevelView2$setTroopMemberLevel$1$3.INSTANCE).a();
                            a16.setBounds(0, 0, getWidth(), getHeight());
                            a16.setCallback(this);
                            a16.c0(new Function1<d, Unit>(a16) { // from class: com.tencent.qqnt.aio.nick.memberlevel.TroopMemberLevelView2$setTroopMemberLevel$1$4$1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ FastDynamicDrawable $this_apply;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                    this.$this_apply = a16;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Ref.BooleanRef.this, (Object) a16);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                                    invoke2(dVar);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull d it) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                        return;
                                    }
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    if (Ref.BooleanRef.this.element) {
                                        this.$this_apply.stop();
                                    }
                                }
                            });
                            this.vipEffectDrawable = a16;
                        } else {
                            a.C1005a l16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE);
                            String j26 = info.j();
                            Intrinsics.checkNotNull(j26);
                            FastDynamicDrawable a17 = l16.k(j26).h(TroopMemberLevelView2$setTroopMemberLevel$1$5.INSTANCE).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).a();
                            a17.setBounds(0, 0, b(getHeight()), getHeight());
                            a17.setCallback(this);
                            this.vipEffectDrawable = a17;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
                this.vipEffectShowBottom = z18;
                if (!z18) {
                }
            }
            setContentDescription(sb5.toString());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(@NotNull Drawable who) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) who)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(who, "who");
        if (Intrinsics.areEqual(who, this.vipEffectDrawable)) {
            return true;
        }
        return super.verifyDrawable(who);
    }
}
