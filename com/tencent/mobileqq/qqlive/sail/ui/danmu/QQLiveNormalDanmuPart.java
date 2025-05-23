package com.tencent.mobileqq.qqlive.sail.ui.danmu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.room.displayview.horizontal.CustomDanmakuView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.message.i;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00105\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00102\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/QQLiveNormalDanmuPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/timi/game/liveroom/impl/room/message/i$a;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "show", "", "qa", "la", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartStart", "onPartStop", "onPartDestroy", "", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "U9", "V9", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "msg", "t6", "Lfp4/c;", "msgInfo", "onPush", "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/CustomDanmakuView;", "e", "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/CustomDanmakuView;", "danmuView", "f", "Z", "showDanmuByConfig", "Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/a;", tl.h.F, "Lkotlin/Lazy;", "na", "()Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/a;", "danmuViewModel", "oa", "()Z", MiniChatConstants.MINI_APP_LANDSCAPE, "ma", "canShowDanmu", "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveNormalDanmuPart extends com.tencent.mobileqq.qqlive.sail.base.c implements i.a, com.tencent.mobileqq.qqlive.sail.room.g {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CustomDanmakuView danmuView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showDanmuByConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy danmuViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/QQLiveNormalDanmuPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveNormalDanmuPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51723);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveNormalDanmuPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.showDanmuByConfig = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveNormalDanmuPart$danmuViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveNormalDanmuPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (a) QQLiveNormalDanmuPart.this.getViewModel(a.class) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.danmuViewModel = lazy;
    }

    private final void la() {
        com.tencent.timi.game.liveroom.impl.room.message.i.f378067a.c(this);
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.e(this);
        }
        CustomDanmakuView customDanmakuView = this.danmuView;
        if (customDanmakuView != null) {
            customDanmakuView.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ma() {
        if (oa() && this.showDanmuByConfig && na().M1() && R9()) {
            return true;
        }
        return false;
    }

    private final a na() {
        Object value = this.danmuViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-danmuViewModel>(...)");
        return (a) value;
    }

    private final boolean oa() {
        Resources resources;
        Configuration configuration;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa(boolean show) {
        boolean z16;
        CustomDanmakuView customDanmakuView;
        AegisLogger.INSTANCE.i("Audience|QQLiveDanmuPart", "showDanmu", "show=" + show);
        if (show) {
            com.tencent.timi.game.liveroom.impl.room.message.i.f378067a.a(this);
            com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
            if (F9 != null) {
                F9.e(this);
            }
            com.tencent.mobileqq.qqlive.sail.room.f F92 = F9();
            if (F92 != null) {
                F92.p(33, this);
            }
            if (this.danmuView == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            startInit();
            if (z16 && (customDanmakuView = this.danmuView) != null) {
                customDanmakuView.b();
            }
        } else {
            com.tencent.timi.game.liveroom.impl.room.message.i.f378067a.c(this);
            com.tencent.mobileqq.qqlive.sail.room.f F93 = F9();
            if (F93 != null) {
                F93.e(this);
            }
        }
        CustomDanmakuView customDanmakuView2 = this.danmuView;
        if (customDanmakuView2 != null) {
            wi2.d.e(customDanmakuView2, show);
        }
        CustomDanmakuView customDanmakuView3 = this.danmuView;
        if (customDanmakuView3 != null) {
            customDanmakuView3.g(show);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        this.showDanmuByConfig = !BusConfigHelper.f378723a.f(13, H9());
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("Audience|QQLiveDanmuPart", "onBusConfigUpdate", "showDanmuByConfig=" + this.showDanmuByConfig);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (F9() != null) {
            qa(ma());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Audience|QQLiveDanmuPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            la();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.id.f60492vk;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            qa(ma());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        CustomDanmakuView customDanmakuView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            customDanmakuView = (CustomDanmakuView) rootView.findViewById(R.id.f60492vk);
        } else {
            customDanmakuView = null;
        }
        this.danmuView = customDanmakuView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        LiveData<Boolean> L1 = na().L1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveNormalDanmuPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveNormalDanmuPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                boolean ma5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                QQLiveNormalDanmuPart qQLiveNormalDanmuPart = QQLiveNormalDanmuPart.this;
                ma5 = qQLiveNormalDanmuPart.ma();
                qQLiveNormalDanmuPart.qa(ma5);
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveNormalDanmuPart.pa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            la();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartStart(activity);
        CustomDanmakuView customDanmakuView = this.danmuView;
        if (customDanmakuView != null) {
            customDanmakuView.b();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartStop(activity);
        CustomDanmakuView customDanmakuView = this.danmuView;
        if (customDanmakuView != null) {
            customDanmakuView.c();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        boolean z16;
        rq3.d dVar;
        rq3.e[] msgElements;
        Object orNull;
        rq3.h hVar;
        byte[] text;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        rq3.a d16 = com.tencent.mobileqq.qqlive.sail.push.a.d(msgInfo);
        if (d16 != null) {
            rq3.i iVar = d16.f431934a;
            if (iVar != null && iVar.f431958a == M9()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && (dVar = d16.f431935b) != null && (msgElements = dVar.f431942a) != null) {
                Intrinsics.checkNotNullExpressionValue(msgElements, "msgElements");
                orNull = ArraysKt___ArraysKt.getOrNull(msgElements, 0);
                rq3.e eVar = (rq3.e) orNull;
                if (eVar != null && (hVar = eVar.f431946b) != null && (text = hVar.f431957a) != null) {
                    Intrinsics.checkNotNullExpressionValue(text, "text");
                    Charset forName = Charset.forName("utf-16LE");
                    Intrinsics.checkNotNullExpressionValue(forName, "forName(\"utf-16LE\")");
                    String str = new String(text, forName);
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    if (companion.isDevelopLevel()) {
                        companion.d("Audience|QQLiveDanmuPart", "onPush", "msg=" + str);
                    }
                    CustomDanmakuView customDanmakuView = this.danmuView;
                    if (customDanmakuView != null) {
                        customDanmakuView.e(str);
                    }
                }
            }
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.i.a
    public void t6(@NotNull LiveMessageData msg2) {
        Object orNull;
        String str;
        LiveMessageData.TextElement textElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ArrayList<LiveMessageData.MsgElement> arrayList = msg2.msgContent.mMsgElements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msg.msgContent.mMsgElements");
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
        LiveMessageData.MsgElement msgElement = (LiveMessageData.MsgElement) orNull;
        if (msgElement != null && (textElement = msgElement.mTextMsg) != null) {
            str = textElement.strText;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("Audience|QQLiveDanmuPart", "onLocalDanmuReceive", "msg=" + str);
        }
        if (msg2.mSpeakerInfo.mSpeakId == M9()) {
            CustomDanmakuView customDanmakuView = this.danmuView;
            if (customDanmakuView != null) {
                customDanmakuView.f(str);
                return;
            }
            return;
        }
        CustomDanmakuView customDanmakuView2 = this.danmuView;
        if (customDanmakuView2 != null) {
            customDanmakuView2.e(str);
        }
    }
}
