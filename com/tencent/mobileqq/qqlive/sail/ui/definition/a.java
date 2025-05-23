package com.tencent.mobileqq.qqlive.sail.ui.definition;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0004R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001aR\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u001e\u001a\u0004\b*\u0010 \u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "definition", "", "Q1", "", "U1", "", "roomId", "M1", "N1", "", "show", "X1", "S1", "P1", "i", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "O1", "()Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "W1", "(Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;)V", "currentDefinition", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_showPopupLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "showPopupLiveData", "D", "_endSwitchLiveData", "E", "R1", "endSwitchLiveData", UserInfo.SEX_FEMALE, "_beginSwitchLiveData", "G", "getBeginSwitchLiveData", "beginSwitchLiveData", "<init>", "()V", "H", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final StreamDefinition I;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showPopupLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<StreamDefinition> _endSwitchLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<StreamDefinition> endSwitchLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<StreamDefinition> _beginSwitchLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<StreamDefinition> beginSwitchLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private StreamDefinition currentDefinition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showPopupLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a$a;", "", "", "a", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "DEFAULT_DEFINITION", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "", "MMKV_DEFINITION_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.definition.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return ct3.a.g("USER_SELECT_DEFINITON_LEVEL", a.I.getValue());
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272631a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51740);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[StreamDefinition.values().length];
            try {
                iArr[StreamDefinition.SD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StreamDefinition.HD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StreamDefinition.SHD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f272631a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51741);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
            I = StreamDefinition.SHD;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.currentDefinition = S1();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._showPopupLiveData = mutableLiveData;
        this.showPopupLiveData = mutableLiveData;
        MutableLiveData<StreamDefinition> mutableLiveData2 = new MutableLiveData<>();
        this._endSwitchLiveData = mutableLiveData2;
        this.endSwitchLiveData = mutableLiveData2;
        MutableLiveData<StreamDefinition> mutableLiveData3 = new MutableLiveData<>();
        this._beginSwitchLiveData = mutableLiveData3;
        this.beginSwitchLiveData = mutableLiveData3;
    }

    private final int Q1(StreamDefinition definition) {
        int i3 = b.f272631a[definition.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return R.drawable.nse;
                }
                return R.drawable.nsb;
            }
            return R.drawable.nsc;
        }
        return R.drawable.nsd;
    }

    private final void U1(StreamDefinition definition) {
        ct3.a.p("USER_SELECT_DEFINITON_LEVEL", definition.getValue());
    }

    public final void M1(long roomId, @NotNull StreamDefinition definition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(roomId), definition);
            return;
        }
        Intrinsics.checkNotNullParameter(definition, "definition");
        U1(definition);
        this._beginSwitchLiveData.postValue(definition);
        SimpleEventBus.getInstance().dispatchEvent(new DefinitionBeginSwitchEvent(roomId, definition));
    }

    public final void N1(long roomId, @NotNull StreamDefinition definition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(roomId), definition);
            return;
        }
        Intrinsics.checkNotNullParameter(definition, "definition");
        this.currentDefinition = definition;
        this._endSwitchLiveData.postValue(definition);
    }

    @NotNull
    public final StreamDefinition O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (StreamDefinition) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.currentDefinition;
    }

    public final int P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return Q1(this.currentDefinition);
    }

    @NotNull
    public final LiveData<StreamDefinition> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.endSwitchLiveData;
    }

    @NotNull
    public final StreamDefinition S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (StreamDefinition) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        int a16 = INSTANCE.a();
        AegisLogger.INSTANCE.d("Audience|DefinitionViewModel", "getCurrentDefinition", "value=" + a16);
        return StreamDefinition.INSTANCE.a(a16);
    }

    @NotNull
    public final LiveData<Boolean> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.showPopupLiveData;
    }

    public final void W1(@NotNull StreamDefinition streamDefinition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) streamDefinition);
        } else {
            Intrinsics.checkNotNullParameter(streamDefinition, "<set-?>");
            this.currentDefinition = streamDefinition;
        }
    }

    public final void X1(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, show);
        } else {
            this._showPopupLiveData.postValue(Boolean.valueOf(show));
        }
    }
}
