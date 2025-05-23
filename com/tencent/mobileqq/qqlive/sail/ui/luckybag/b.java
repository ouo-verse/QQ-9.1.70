package com.tencent.mobileqq.qqlive.sail.ui.luckybag;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.base.c;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.luckybag.view.ECommerceLuckyBagView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0014J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/luckybag/b;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "la", "Lqq4/a;", "msg", "", "ia", "Lqq4/b;", "toastMsg", LocaleUtils.L_JAPANESE, "", "type", "", "ha", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "getInitRelyViewStubId", "U9", "V9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartStop", "Lfp4/c;", "msgInfo", "onPush", "onPartDestroy", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "containerView", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/luckybag/view/ECommerceLuckyBagView;", "f", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/luckybag/view/ECommerceLuckyBagView;", "view", "Lck4/a;", h.F, "Lck4/a;", "showDialogHelper", "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends c implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f272834m;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup containerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ECommerceLuckyBagView view;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ck4.a showDialogHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u0012\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/luckybag/b$a;", "", "", "ACTIVITY_KEY_PREFIX", "Ljava/lang/String;", "LUCKY_BAG_OFFLINE_BID", "", "PRELOAD_LUCKY_BAG_DELAY_SECOND", "I", "TAG", "", "hasPreloadLuckBag", "Z", "getHasPreloadLuckBag$annotations", "()V", "<init>", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.luckybag.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52438);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String ha(int type) {
        return "join_activity_" + H9() + "_" + type + "_";
    }

    private final boolean ia(qq4.a msg2) {
        return Intrinsics.areEqual(ct3.a.k(ha(msg2.f429282a), M9()), msg2.f429285d);
    }

    private final void ja(qq4.b toastMsg) {
        int i3 = toastMsg.f429287b;
        if (i3 == 1 && toastMsg.f429289d == 0) {
            ct3.a.s(ha(i3), M9(), toastMsg.f429288c);
        }
    }

    private final void la() {
        AppInterface a16;
        if (f272834m || (a16 = com.tencent.mobileqq.qqlive.utils.g.a()) == null) {
            return;
        }
        f272834m = true;
        AegisLogger.INSTANCE.i("room_info|QQLiveECommerceLuckyBagPart", "tryPreload", "roomId=" + H9());
        HtmlOffline.k("5177", a16, new a(), true, 5, true);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        f F9 = F9();
        if (F9 != null) {
            if (!Q9()) {
                startInit();
            }
            ECommerceLuckyBagView eCommerceLuckyBagView = this.view;
            if (eCommerceLuckyBagView != null) {
                eCommerceLuckyBagView.e();
            }
            F9.p(285, this);
            F9.p(167, this);
            F9.p(235, this);
            la();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("room_info|QQLiveECommerceLuckyBagPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ECommerceLuckyBagView eCommerceLuckyBagView = this.view;
        if (eCommerceLuckyBagView != null) {
            eCommerceLuckyBagView.f();
        }
        f F9 = F9();
        if (F9 != null) {
            F9.e(this);
        }
        ck4.a aVar = this.showDialogHelper;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.id.f61082x6;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f61072x5);
        } else {
            viewGroup = null;
        }
        this.containerView = viewGroup;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ECommerceLuckyBagView eCommerceLuckyBagView = new ECommerceLuckyBagView(context, null, 0, 6, null);
        this.view = eCommerceLuckyBagView;
        ViewGroup viewGroup2 = this.containerView;
        if (viewGroup2 != null) {
            viewGroup2.addView(eCommerceLuckyBagView);
        }
        Bundle bundleExtra = getActivity().getIntent().getBundleExtra("biz_ext_data");
        int i3 = 0;
        if (bundleExtra != null) {
            i3 = bundleExtra.getInt("auto_open_luckybag", 0);
        }
        int i16 = i3;
        ECommerceLuckyBagView eCommerceLuckyBagView2 = this.view;
        if (eCommerceLuckyBagView2 != null) {
            eCommerceLuckyBagView2.b(H9(), Q9(), E9(), J9(), i16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        ECommerceLuckyBagView eCommerceLuckyBagView = this.view;
        if (eCommerceLuckyBagView != null) {
            eCommerceLuckyBagView.c();
        }
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        ECommerceLuckyBagView eCommerceLuckyBagView = this.view;
        if (eCommerceLuckyBagView != null) {
            eCommerceLuckyBagView.e();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        ECommerceLuckyBagView eCommerceLuckyBagView = this.view;
        if (eCommerceLuckyBagView != null) {
            eCommerceLuckyBagView.f();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPush(@NotNull fp4.c msgInfo) {
        boolean isBlank;
        boolean z16;
        boolean isBlank2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        if (com.tencent.mobileqq.qqlive.sail.push.a.q(msgInfo) != null) {
            AegisLogger.INSTANCE.i("room_info|QQLiveECommerceLuckyBagPart", "onPush", "on LuckyBagMsg");
            startInit();
            ECommerceLuckyBagView eCommerceLuckyBagView = this.view;
            if (eCommerceLuckyBagView != null) {
                eCommerceLuckyBagView.a();
            }
        }
        yo4.b f16 = com.tencent.mobileqq.qqlive.sail.push.a.f(msgInfo);
        if (f16 != null) {
            AegisLogger.INSTANCE.i("room_info|QQLiveECommerceLuckyBagPart", "onPush", "on ECommercePushMsg");
            startInit();
            ECommerceLuckyBagView eCommerceLuckyBagView2 = this.view;
            if (eCommerceLuckyBagView2 != null) {
                int i3 = f16.f450750a;
                String str = f16.f450753d;
                Intrinsics.checkNotNullExpressionValue(str, "pushData.msgData");
                eCommerceLuckyBagView2.d(i3, str);
            }
        }
        qq4.a r16 = com.tencent.mobileqq.qqlive.sail.push.a.r(msgInfo);
        boolean z17 = true;
        if (r16 != null) {
            if (!ia(r16)) {
                AegisLogger.INSTANCE.i("room_info|QQLiveECommerceLuckyBagPart", "onPush", "roomId=" + H9() + ", no joined activity, " + r16.f429282a);
            } else {
                String str2 = r16.f429284c;
                if (str2 != null) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                    if (!isBlank2) {
                        z16 = false;
                        if (!z16) {
                            AegisLogger.INSTANCE.i("room_info|QQLiveECommerceLuckyBagPart", "onPush", "roomId=" + H9() + ", invalid activity url");
                        } else {
                            if (this.showDialogHelper == null) {
                                this.showDialogHelper = new ck4.a();
                            }
                            ck4.a aVar = this.showDialogHelper;
                            if (aVar != null) {
                                aVar.b();
                            }
                            ck4.a aVar2 = this.showDialogHelper;
                            if (aVar2 != null) {
                                aVar2.e(getActivity(), r16.f429284c);
                            }
                        }
                    }
                }
                z16 = true;
                if (!z16) {
                }
            }
        }
        qq4.b B = com.tencent.mobileqq.qqlive.sail.push.a.B(msgInfo);
        if (B != null) {
            AegisLogger.INSTANCE.i("room_info|QQLiveECommerceLuckyBagPart", "onPush", "roomId=" + H9() + ", buzId=" + B.f429287b + ", val=" + B.f429288c + ", toast=" + B.f429286a);
            String str3 = B.f429286a;
            if (str3 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                if (!isBlank) {
                    z17 = false;
                }
            }
            if (!z17) {
                QQToast.makeText(getContext(), 5, B.f429286a, 0).show();
            }
            ja(B);
        }
    }
}
