package com.tencent.mobileqq.qqlive.sail.ui.linkscreen;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.callback.room.VideoSeiInfo;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\n*\u0001,\u0018\u0000 22\u00020\u0001:\u000234B\u0007\u00a2\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u00020\nH\u0014J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "", "N1", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqlive/sail/model/d;", "roomInfo", "Landroid/widget/FrameLayout;", "pkContainer", "", "Q1", "R1", MiniChatConstants.MINI_APP_LANDSCAPE, "S1", "Lcom/tencent/mobileqq/qqlive/callback/room/VideoSeiInfo;", "seiInfo", "T1", "onCleared", "O1", "P1", "Lfo3/e;", "i", "Lfo3/e;", "pkGameLogic", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "roomId", "Lfo3/b;", BdhLogUtil.LogTag.Tag_Conn, "Lfo3/b;", "pageInParams", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/a;", "D", "Landroidx/lifecycle/MutableLiveData;", "_showLinkLiveData", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "showLinkLiveData", "com/tencent/mobileqq/qqlive/sail/ui/linkscreen/e$c", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e$c;", "uiCallback", "<init>", "()V", "G", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private fo3.b pageInParams;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a> _showLinkLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a> showLinkLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final c uiCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fo3.e pkGameLogic;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e$a;", "Lfo3/b;", "", "d", "", "getRoomId", "", "getAnchorId", "Landroid/widget/FrameLayout;", "b", "Landroid/os/Bundle;", "a", "", "c", "e", "f", "J", "roomId", "anchorId", "Landroid/widget/FrameLayout;", "pkContainer", "<init>", "(JJLandroid/widget/FrameLayout;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    private static final class a implements fo3.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long roomId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long anchorId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private FrameLayout pkContainer;

        public a(long j3, long j16, @Nullable FrameLayout frameLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), frameLayout);
                return;
            }
            this.roomId = j3;
            this.anchorId = j16;
            this.pkContainer = frameLayout;
        }

        @Override // fo3.b
        @NotNull
        public Bundle a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Bundle) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return new Bundle();
        }

        @Override // fo3.b
        @Nullable
        public FrameLayout b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (FrameLayout) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.pkContainer;
        }

        @Override // fo3.b
        @NotNull
        public String c() {
            String j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
            if (c16 == null || (j3 = c16.j()) == null) {
                return "";
            }
            return j3;
        }

        @Override // fo3.b
        public boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.anchorId == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
                return true;
            }
            return false;
        }

        @Override // fo3.b
        @Nullable
        public FrameLayout e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (FrameLayout) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.pkContainer;
        }

        @Override // fo3.b
        public boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // fo3.b
        public long getAnchorId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.anchorId;
        }

        @Override // fo3.b
        public int getRoomId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return (int) this.roomId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e$b, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/linkscreen/e$c", "Lcom/tencent/now/pkgame/a;", "", "bottomYPosition", "", "b", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements com.tencent.now.pkgame.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.now.pkgame.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                e.this._showLinkLiveData.postValue(new com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a(false, -1));
            }
        }

        @Override // com.tencent.now.pkgame.a
        public void b(int bottomYPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, bottomYPosition);
            } else {
                e.this._showLinkLiveData.postValue(new com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a(true, bottomYPosition));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52336);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a> mutableLiveData = new MutableLiveData<>();
        this._showLinkLiveData = mutableLiveData;
        this.showLinkLiveData = mutableLiveData;
        this.uiCallback = new c();
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.showLinkLiveData;
    }

    public final boolean N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        fo3.e eVar = this.pkGameLogic;
        if (eVar == null || !eVar.J()) {
            return false;
        }
        return true;
    }

    public final boolean O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        fo3.e eVar = this.pkGameLogic;
        if (eVar != null) {
            return eVar.K();
        }
        return false;
    }

    public final boolean P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        fo3.e eVar = this.pkGameLogic;
        if (eVar != null) {
            return eVar.M();
        }
        return false;
    }

    public final void Q1(@Nullable Context context, @Nullable com.tencent.mobileqq.qqlive.sail.model.d roomInfo, @Nullable FrameLayout pkContainer) {
        Long l3;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, roomInfo, pkContainer);
            return;
        }
        if (context != null && roomInfo != null && pkContainer != null) {
            AegisLogger.INSTANCE.i("PK_Biz|PKViewModel", "onEnterRoom", "roomId=" + roomInfo.getRoomId());
            this.roomId = roomInfo.getRoomId();
            com.tencent.mobileqq.qqlive.sail.model.common.UserInfo j16 = roomInfo.j();
            if (j16 != null) {
                j3 = j16.f();
            } else {
                j3 = 0;
            }
            this.pageInParams = new a(this.roomId, j3, pkContainer);
            fo3.e eVar = new fo3.e(this.uiCallback);
            eVar.R(context, this.pageInParams);
            eVar.N();
            this.pkGameLogic = eVar;
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (roomInfo != null) {
            l3 = Long.valueOf(roomInfo.getRoomId());
        } else {
            l3 = null;
        }
        companion.w("PK_Biz|PKViewModel", "onEnterRoom", "roomId=" + l3 + ", invalid params");
    }

    public final void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d("PK_Biz|PKViewModel", 1, "onExitRoom, roomId=" + this.roomId);
        fo3.e eVar = this.pkGameLogic;
        if (eVar != null) {
            eVar.S();
        }
        this.pkGameLogic = null;
        this.pageInParams = null;
    }

    public final void S1(boolean isLandscape) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isLandscape);
            return;
        }
        fo3.e eVar = this.pkGameLogic;
        if (eVar != null) {
            eVar.Q(isLandscape);
        }
    }

    public final void T1(@Nullable VideoSeiInfo seiInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) seiInfo);
            return;
        }
        fo3.e eVar = this.pkGameLogic;
        if (eVar != null) {
            eVar.O(seiInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onCleared();
        fo3.e eVar = this.pkGameLogic;
        if (eVar != null) {
            eVar.S();
        }
        this.pkGameLogic = null;
        this.pageInParams = null;
    }
}
