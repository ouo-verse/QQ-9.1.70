package com.tencent.mobileqq.qqlive.sail.ui.definition;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYa;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionPopupPart;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.definition.DefinitionPopupWindow;
import com.tencent.timi.game.liveroom.impl.room.definition.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mi2.f;
import mqq.app.Constants;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J(\u0010\n\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u001c\u0010\u001c\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\u0012\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\bH\u0016R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0016\u0010=\u001a\u0004\u0018\u00010:8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/definition/QQLiveDefinitionPopupPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/timi/game/liveroom/impl/room/definition/b$e;", "Lmi2/f;", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", "streamInfo", "Lkotlin/Function1;", "", "", "callback", "pa", "", "show", "va", "", "Lcom/tencent/mobileqq/qqlive/data/room/EnterRoomInfo$VideoDefinition;", "sa", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "sailDefinition", "wa", "oldDefinition", "xa", "definition", "qa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "V9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/view/View;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, NodeProps.ON_CLICK, "o", "e", "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "Lcom/tencent/timi/game/liveroom/impl/room/definition/b;", "f", "Lcom/tencent/timi/game/liveroom/impl/room/definition/b;", "definitionView", "Lcom/tencent/timi/game/liveroom/impl/room/definition/DefinitionPopupWindow;", h.F, "Lcom/tencent/timi/game/liveroom/impl/room/definition/DefinitionPopupWindow;", "popupWindow", "i", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "targetDefinition", "Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "ra", "()Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", "definitionViewModel", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "ta", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveDefinitionPopupPart extends com.tencent.mobileqq.qqlive.sail.base.c implements b.e, f {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.timi.game.liveroom.impl.room.definition.b definitionView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DefinitionPopupWindow popupWindow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private StreamDefinition targetDefinition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy definitionViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/definition/QQLiveDefinitionPopupPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionPopupPart$a, reason: from kotlin metadata */
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272618a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f272619b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51752);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[EnterRoomInfo.VideoDefinition.values().length];
            try {
                iArr[EnterRoomInfo.VideoDefinition.SD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.HD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.SHD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.FHD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.THFD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.ORIGIN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f272618a = iArr;
            int[] iArr2 = new int[StreamDefinition.values().length];
            try {
                iArr2[StreamDefinition.SD.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[StreamDefinition.HD.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[StreamDefinition.SHD.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[StreamDefinition.FHD.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[StreamDefinition.THFD.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[StreamDefinition.ORIGIN.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[StreamDefinition.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            f272619b = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/definition/QQLiveDefinitionPopupPart$c", "Lcom/tencent/mobileqq/qqlive/huya/d;", "", "urlWithToken", "", "onUrlCallback", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements com.tencent.mobileqq.qqlive.huya.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.sail.model.audience.a f272620a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f272621b;

        /* JADX WARN: Multi-variable type inference failed */
        c(com.tencent.mobileqq.qqlive.sail.model.audience.a aVar, Function1<? super String, Unit> function1) {
            this.f272620a = aVar;
            this.f272621b = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) function1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Function1 callback, String str) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            callback.invoke(str);
        }

        @Override // com.tencent.mobileqq.qqlive.huya.d
        public void onUrlCallback(@Nullable final String urlWithToken) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) urlWithToken);
                return;
            }
            com.tencent.mobileqq.qqlive.sail.model.audience.a aVar = this.f272620a;
            if (urlWithToken == null) {
                str = "";
            } else {
                str = urlWithToken;
            }
            aVar.g(str);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final Function1<String, Unit> function1 = this.f272621b;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.c
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveDefinitionPopupPart.c.b(Function1.this, urlWithToken);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51766);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveDefinitionPopupPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.popupWindow = new DefinitionPopupWindow();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionPopupPart$definitionViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveDefinitionPopupPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (a) QQLiveDefinitionPopupPart.this.getViewModel(a.class) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.definitionViewModel = lazy;
    }

    private final void pa(com.tencent.mobileqq.qqlive.sail.model.audience.a streamInfo, Function1<? super String, Unit> callback) {
        boolean isBlank;
        AudienceRoomInfo b16;
        if (streamInfo == null) {
            callback.invoke(null);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
        boolean z16 = false;
        if (ta5 != null && (b16 = ta5.b()) != null && b16.x()) {
            z16 = true;
        }
        if (z16) {
            isBlank = StringsKt__StringsJVMKt.isBlank(streamInfo.f());
            if (!isBlank) {
                callback.invoke(streamInfo.f());
                return;
            }
            QLog.d("Audience|QQLiveDefinitionPopupPart", 2, "refresh originUrl: " + streamInfo.e());
            QQLiveHuYa.f271333a.i(streamInfo.e(), new c(streamInfo, callback));
            return;
        }
        callback.invoke(streamInfo.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String qa(StreamDefinition definition) {
        switch (b.f272619b[definition.ordinal()]) {
            case 1:
                return "\u6807\u6e05";
            case 2:
                return "\u9ad8\u6e05";
            case 3:
                return "\u8d85\u6e05";
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                return "\u84dd\u5149";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a ra() {
        Object value = this.definitionViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-definitionViewModel>(...)");
        return (a) value;
    }

    private final List<EnterRoomInfo.VideoDefinition> sa() {
        AudienceRoomInfo b16;
        ArrayList<com.tencent.mobileqq.qqlive.sail.model.audience.a> t16;
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
        if (ta5 != null && (b16 = ta5.b()) != null && (t16 = b16.t()) != null) {
            Iterator<T> it = t16.iterator();
            while (it.hasNext()) {
                arrayList.add(wa(((com.tencent.mobileqq.qqlive.sail.model.audience.a) it.next()).b()));
            }
        }
        arrayList.remove(EnterRoomInfo.VideoDefinition.ORIGIN);
        arrayList.remove(EnterRoomInfo.VideoDefinition.THFD);
        arrayList.remove(EnterRoomInfo.VideoDefinition.UNKNOWN);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.room.e ta() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va(boolean show) {
        if (!show) {
            this.popupWindow.d();
            return;
        }
        try {
            b.d dVar = new b.d();
            dVar.b(getActivity());
            dVar.d(this.isLandscape);
            dVar.c(sa());
            dVar.e(this);
            com.tencent.timi.game.liveroom.impl.room.definition.b a16 = dVar.a();
            this.definitionView = a16;
            if (a16 != null) {
                a16.s(wa(ra().O1()));
                this.popupWindow.d();
                this.popupWindow.e(getActivity(), a16.k(), this.isLandscape);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Audience|QQLiveDefinitionPopupPart", "showPopupWindow", "error, ", e16);
        }
    }

    private final EnterRoomInfo.VideoDefinition wa(StreamDefinition sailDefinition) {
        EnterRoomInfo.VideoDefinition parse = EnterRoomInfo.VideoDefinition.parse(sailDefinition.getValue());
        Intrinsics.checkNotNullExpressionValue(parse, "parse(sailDefinition.value)");
        return parse;
    }

    private final StreamDefinition xa(EnterRoomInfo.VideoDefinition oldDefinition) {
        switch (b.f272618a[oldDefinition.ordinal()]) {
            case 1:
                return StreamDefinition.SD;
            case 2:
                return StreamDefinition.HD;
            case 3:
                return StreamDefinition.SHD;
            case 4:
                return StreamDefinition.FHD;
            case 5:
                return StreamDefinition.THFD;
            case 6:
                return StreamDefinition.ORIGIN;
            case 7:
                return StreamDefinition.UNKNOWN;
            default:
                return StreamDefinition.UNKNOWN;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.V9();
        this.targetDefinition = null;
        com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
        if (ta5 != null) {
            ta5.s(this);
        }
    }

    @Override // mi2.f
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionPopupPart", "onSwitched", "targetDefinition=" + this.targetDefinition);
        StreamDefinition streamDefinition = this.targetDefinition;
        if (streamDefinition != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenStarted(new QQLiveDefinitionPopupPart$onSwitchedDefinition$1$1(this, streamDefinition, null));
            ra().N1(H9(), streamDefinition);
        }
        this.targetDefinition = null;
        com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
        if (ta5 != null) {
            ta5.s(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [kotlin.Unit] */
    @Override // com.tencent.timi.game.liveroom.impl.room.definition.b.e
    public void onClick(@Nullable View item) {
        Object obj;
        EnterRoomInfo.VideoDefinition videoDefinition;
        AudienceRoomInfo b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) item);
            return;
        }
        this.popupWindow.d();
        com.tencent.mobileqq.qqlive.sail.model.audience.a aVar = null;
        if (item != null) {
            obj = item.getTag();
        } else {
            obj = null;
        }
        if (obj instanceof EnterRoomInfo.VideoDefinition) {
            videoDefinition = (EnterRoomInfo.VideoDefinition) obj;
        } else {
            videoDefinition = null;
        }
        if (videoDefinition != null) {
            final StreamDefinition xa5 = xa(videoDefinition);
            this.targetDefinition = xa5;
            if (xa5 != null) {
                com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
                if (ta5 != null && (b16 = ta5.b()) != null) {
                    aVar = b16.s(xa5);
                }
                pa(aVar, new Function1<String, Unit>(xa5) { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionPopupPart$onClick$1$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ StreamDefinition $definition;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$definition = xa5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveDefinitionPopupPart.this, (Object) xa5);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:13:0x001d  */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2(@Nullable String str) {
                        boolean z16;
                        com.tencent.mobileqq.qqlive.sail.room.e ta6;
                        com.tencent.mobileqq.qqlive.sail.room.e ta7;
                        a ra5;
                        boolean isBlank;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                            return;
                        }
                        if (str != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(str);
                            if (!isBlank) {
                                z16 = false;
                                if (!z16) {
                                    QQLiveDefinitionPopupPart.this.targetDefinition = null;
                                    com.tencent.timi.game.ui.widget.f.c("\u5207\u6362\u6e05\u6670\u5ea6\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                                    return;
                                }
                                com.tencent.timi.game.ui.widget.f.c("\u5207\u6362\u6e05\u6670\u5ea6");
                                ta6 = QQLiveDefinitionPopupPart.this.ta();
                                if (ta6 != null) {
                                    ta6.registerSwitchDefinitionListener(QQLiveDefinitionPopupPart.this);
                                }
                                ta7 = QQLiveDefinitionPopupPart.this.ta();
                                if (ta7 != null) {
                                    ta7.switchStream(str);
                                }
                                ra5 = QQLiveDefinitionPopupPart.this.ra();
                                ra5.M1(QQLiveDefinitionPopupPart.this.H9(), this.$definition);
                                return;
                            }
                        }
                        z16 = true;
                        if (!z16) {
                        }
                    }
                });
                aVar = Unit.INSTANCE;
            }
        }
        if (aVar == null) {
            AegisLogger.INSTANCE.w("Audience|QQLiveDefinitionPopupPart", NodeProps.ON_CLICK, H9() + ", no definition found");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isLandscape = z16;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        LiveData<Boolean> T1 = ra().T1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionPopupPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveDefinitionPopupPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                StreamDefinition streamDefinition;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                streamDefinition = QQLiveDefinitionPopupPart.this.targetDefinition;
                if (streamDefinition == null) {
                    QQLiveDefinitionPopupPart.this.targetDefinition = null;
                    QQLiveDefinitionPopupPart qQLiveDefinitionPopupPart = QQLiveDefinitionPopupPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qQLiveDefinitionPopupPart.va(it.booleanValue());
                    return;
                }
                AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionPopupPart", "onPartCreate", "switching definition, cannot show");
                com.tencent.timi.game.ui.widget.f.c("\u6e05\u6670\u5ea6\u5207\u6362\u4e2d");
            }
        };
        T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveDefinitionPopupPart.ua(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
        if (ta5 != null) {
            ta5.s(this);
        }
    }
}
