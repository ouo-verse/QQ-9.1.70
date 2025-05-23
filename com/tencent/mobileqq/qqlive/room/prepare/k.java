package com.tencent.mobileqq.qqlive.room.prepare;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.live.api.QQECLiveEntryGoodsData;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRealNameAuthCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRoomSettingCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveSetRoomSettingCallback;
import com.tencent.mobileqq.qqlive.data.CoverInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRichTitleElement;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomRichTitle;
import com.tencent.mobileqq.qqlive.data.auth.QQLiveRealNameAuthData;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.room.livelabel.LabelModel;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetRedPointRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class k extends com.tencent.mobileqq.mvvm.c<g> {
    static IPatchRedirector $redirector_;
    public static boolean T;
    public static ViewModelProvider.Factory U;
    public QQLiveRealNameAuthData C;
    public MutableLiveData<List<com.tencent.mobileqq.qqlive.room.prepare.a>> D;
    public final MutableLiveData<CoverInfo> E;
    public final MutableLiveData<String> F;
    public final MutableLiveData<Integer> G;
    public final MutableLiveData<Boolean> H;
    public final MutableLiveData<com.tencent.mobileqq.qqlive.room.prepare.a> I;
    public final MutableLiveData<e> J;
    public final MutableLiveData<x> K;
    public final MutableLiveData<Boolean> L;
    public long M;
    private String N;
    private int P;
    public final MutableLiveData<LabelModel> Q;
    public boolean R;
    public QQECLiveEntryGoodsData S;

    /* renamed from: i, reason: collision with root package name */
    public QQLiveAnchorDataPrepare f271954i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f271955m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a extends com.tencent.mobileqq.qqlive.room.prepare.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f271956a;

        a(boolean z16) {
            this.f271956a = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, k.this, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.prepare.c
        public void a(List<com.tencent.mobileqq.qqlive.room.prepare.a> list) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            super.a(list);
            if (list != null && list.size() > 0) {
                k.this.D.setValue(list);
                if (this.f271956a) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < list.size()) {
                            if (QQLivePrepareFragment.Xi(list.get(i3))) {
                                k.this.I.setValue(list.get(i3));
                                z16 = true;
                                break;
                            }
                            i3++;
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (!z16) {
                        k kVar = k.this;
                        kVar.I.setValue(kVar.D.getValue().get(0));
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.prepare.c, com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            } else {
                super.onFailed(i3, str);
                k.this.D.setValue(new ArrayList());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b extends IQQLiveGetRealNameAuthCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveGetRealNameAuthCallback f271958a;

        b(IQQLiveGetRealNameAuthCallback iQQLiveGetRealNameAuthCallback) {
            this.f271958a = iQQLiveGetRealNameAuthCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this, (Object) iQQLiveGetRealNameAuthCallback);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRealNameAuthCallback, com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, @Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            super.onFailed(i3, str);
            IQQLiveGetRealNameAuthCallback iQQLiveGetRealNameAuthCallback = this.f271958a;
            if (iQQLiveGetRealNameAuthCallback != null) {
                iQQLiveGetRealNameAuthCallback.onFailed(i3, str);
            }
            QLog.e("Open_Live|PrepareFragmentViewModel", 1, "getAuthStatus fail:" + i3 + " info:" + str);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRealNameAuthCallback
        public void onSuccess(@NonNull QQLiveRealNameAuthData qQLiveRealNameAuthData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveRealNameAuthData);
                return;
            }
            super.onSuccess(qQLiveRealNameAuthData);
            k.this.C = qQLiveRealNameAuthData;
            IQQLiveGetRealNameAuthCallback iQQLiveGetRealNameAuthCallback = this.f271958a;
            if (iQQLiveGetRealNameAuthCallback != null) {
                iQQLiveGetRealNameAuthCallback.onSuccess(qQLiveRealNameAuthData);
            }
            QLog.i("Open_Live|PrepareFragmentViewModel", 1, "getAuthStatus success");
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class c implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
            }
            return new k(new g());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56409);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            T = true;
            U = new c();
        }
    }

    public k(g gVar) {
        super(gVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) gVar);
            return;
        }
        this.f271954i = new QQLiveAnchorDataPrepare();
        this.f271955m = false;
        this.C = null;
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        this.G = new MutableLiveData<>();
        this.H = new MutableLiveData<>();
        this.I = new MutableLiveData<>();
        this.J = new MutableLiveData<>();
        this.K = new MutableLiveData<>();
        this.L = new MutableLiveData<>(Boolean.FALSE);
        this.M = 0L;
        this.N = "";
        this.P = 0;
        this.Q = new MutableLiveData<>();
        this.R = false;
        this.S = null;
        q2();
        this.f271954i.roomInfo = new QQLiveAnchorDataRoomInfo();
        this.f271954i.roomAttr = new QQLiveAnchorDataRoomAttr();
    }

    private void M1(int i3) {
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare = this.f271954i;
        if (qQLiveAnchorDataPrepare != null && (qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare.roomAttr) != null) {
            if (qQLiveAnchorDataRoomAttr.tags == null) {
                qQLiveAnchorDataRoomAttr.tags = new QQLiveAnchorDataRoomRichTitle();
            }
            QQLiveAnchorDataRoomRichTitle qQLiveAnchorDataRoomRichTitle = this.f271954i.roomAttr.tags;
            if (qQLiveAnchorDataRoomRichTitle.elements == null) {
                qQLiveAnchorDataRoomRichTitle.elements = new ArrayList<>();
            }
            QQLiveAnchorDataRichTitleElement qQLiveAnchorDataRichTitleElement = new QQLiveAnchorDataRichTitleElement();
            qQLiveAnchorDataRichTitleElement.type = 2;
            qQLiveAnchorDataRichTitleElement.url = "";
            if (i3 == 0) {
                qQLiveAnchorDataRichTitleElement.text = "\u79c0\u573a";
            } else if (i3 == 1) {
                qQLiveAnchorDataRichTitleElement.text = "\u6e38\u620f";
            } else {
                qQLiveAnchorDataRichTitleElement.text = "";
            }
            int size = this.f271954i.roomAttr.tags.elements.size();
            if (size == 0) {
                this.f271954i.roomAttr.tags.elements.add(qQLiveAnchorDataRichTitleElement);
                return;
            }
            int i16 = 0;
            while (i16 < size && this.f271954i.roomAttr.tags.elements.get(i16).type != qQLiveAnchorDataRichTitleElement.type) {
                i16++;
            }
            this.f271954i.roomAttr.tags.elements.set(i16, qQLiveAnchorDataRichTitleElement);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(QQLiveResponse qQLiveResponse) {
        AegisLogger.i("Open_Live|PrepareFragmentViewModel", "[getRedPoint]errCode=" + qQLiveResponse.getRetCode() + ", msg=" + qQLiveResponse.getErrMsg());
        if (!qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null && ((vr4.d) qQLiveResponse.getRsp()).f443280a != null) {
            this.M = ((vr4.d) qQLiveResponse.getRsp()).f443280a.f443282b;
            this.L.postValue(Boolean.TRUE);
        } else {
            AegisLogger.w("Open_Live|PrepareFragmentViewModel", "[getRedPoint] no red point");
            this.M = 0L;
            this.L.postValue(Boolean.FALSE);
        }
    }

    private void n2(CoverInfo coverInfo) {
        if (TextUtils.isEmpty(coverInfo.roomLogo)) {
            QLog.e("Open_Live|PrepareFragmentViewModel", 1, "Prepare\u534f\u8bae\u56de\u5305roomLogo\u4e3a\u7a7a\uff0c 16:9 url:" + coverInfo.roomLogo16v9);
        }
    }

    private void q2() {
        this.J.setValue(new e());
        this.I.setValue(new com.tencent.mobileqq.qqlive.room.prepare.a());
        this.E.setValue(new CoverInfo());
        this.F.setValue("");
        this.H.setValue(Boolean.FALSE);
        this.K.setValue(null);
    }

    public boolean N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.f271955m && this.H.getValue().booleanValue()) {
            return true;
        }
        return false;
    }

    public void O1(int i3, IQQLiveGetRealNameAuthCallback iQQLiveGetRealNameAuthCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) iQQLiveGetRealNameAuthCallback);
        } else {
            ((g) this.mRepository).j(i3, new b(iQQLiveGetRealNameAuthCallback));
        }
    }

    public void P1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            ((g) this.mRepository).k(new a(z16));
        }
    }

    public QQLiveAnchorRoomGameInfo Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (QQLiveAnchorRoomGameInfo) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        LabelModel a16 = com.tencent.mobileqq.qqlive.room.livelabel.e.a();
        if (a16 == null) {
            return null;
        }
        QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo = new QQLiveAnchorRoomGameInfo();
        qQLiveAnchorRoomGameInfo.f271211id = a16.gameId;
        qQLiveAnchorRoomGameInfo.icon = a16.iconUrl;
        qQLiveAnchorRoomGameInfo.name = a16.title;
        qQLiveAnchorRoomGameInfo.secondTagId = a16.secondId;
        return qQLiveAnchorRoomGameInfo;
    }

    public int R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.S;
        if (qQECLiveEntryGoodsData == null) {
            return 0;
        }
        return qQECLiveEntryGoodsData.getLiveShopGoodsNumber();
    }

    public int S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        if (this.S != null && f2().booleanValue()) {
            return this.S.getLiveGokGoodsNumber();
        }
        return 0;
    }

    public int T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.S;
        if (qQECLiveEntryGoodsData == null) {
            return 0;
        }
        return qQECLiveEntryGoodsData.getLiveGoodsNumber();
    }

    public int U1() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        int i17 = 0;
        if (R1() > 0) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        if (T1() > 0) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        int i18 = i3 | i16;
        if (h2().booleanValue() && g2()) {
            i17 = 1;
        }
        return i18 | i17;
    }

    public QQLiveAnchorDataPrepare W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QQLiveAnchorDataPrepare) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare = this.f271954i;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare.roomAttr;
        if (qQLiveAnchorDataRoomAttr == null) {
            return qQLiveAnchorDataPrepare;
        }
        if (this.E.getValue() != null) {
            qQLiveAnchorDataRoomAttr.poster = this.E.getValue().roomLogo;
            qQLiveAnchorDataRoomAttr.poster3v4 = this.E.getValue().roomLogo3v4;
            qQLiveAnchorDataRoomAttr.poster16v9 = this.E.getValue().roomLogo16v9;
            qQLiveAnchorDataRoomAttr.posterTime = this.E.getValue().roomLogoTime;
            qQLiveAnchorDataRoomAttr.posterTime3v4 = this.E.getValue().roomLogoTime3v4;
            qQLiveAnchorDataRoomAttr.posterTime16v9 = this.E.getValue().roomLogoTime16v9;
        }
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare2 = this.f271954i;
        qQLiveAnchorDataPrepare2.roomAttr = qQLiveAnchorDataRoomAttr;
        return qQLiveAnchorDataPrepare2;
    }

    public QQLiveAnchorDataPrepare X1(int i3, LabelModel labelModel) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QQLiveAnchorDataPrepare) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) labelModel);
        }
        QQLiveAnchorDataPrepare W1 = W1();
        this.f271954i = W1;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = W1.roomAttr;
        if (qQLiveAnchorDataRoomAttr == null) {
            M1(i3);
            return this.f271954i;
        }
        if (labelModel == null) {
            if (i3 == 2) {
                i16 = 1;
            } else {
                i16 = i3;
            }
            qQLiveAnchorDataRoomAttr.liveRoomType = i16;
            qQLiveAnchorDataRoomAttr.pushType = QQLiveAnchorDataRoomAttr.PushType.QLS_SCREEN_CAPTURE_TRTC;
            qQLiveAnchorDataRoomAttr.gameInfo = null;
            if (i3 == 2) {
                i3 = 1;
            }
            M1(i3);
            if (ht3.a.e("qqlive_set_start_live_in_normal_room_type", true)) {
                this.f271954i.roomAttr.liveRoomType = 0;
            }
            return this.f271954i;
        }
        if (i3 != 1 && !labelModel.isGame) {
            qQLiveAnchorDataRoomAttr.liveRoomType = 0;
            M1(0);
        } else {
            qQLiveAnchorDataRoomAttr.liveRoomType = 1;
            M1(1);
        }
        QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo = new QQLiveAnchorRoomGameInfo();
        qQLiveAnchorRoomGameInfo.f271211id = labelModel.gameId;
        qQLiveAnchorRoomGameInfo.icon = labelModel.iconUrl;
        qQLiveAnchorRoomGameInfo.name = labelModel.title;
        qQLiveAnchorRoomGameInfo.secondTagId = labelModel.secondId;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr2 = this.f271954i.roomAttr;
        qQLiveAnchorDataRoomAttr2.gameInfo = qQLiveAnchorRoomGameInfo;
        qQLiveAnchorDataRoomAttr2.pushType = QQLiveAnchorDataRoomAttr.PushType.getPushType(i3);
        if (ht3.a.e("qqlive_set_start_live_in_normal_room_type", true)) {
            this.f271954i.roomAttr.liveRoomType = 0;
        }
        return this.f271954i;
    }

    public void Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetRedPointRequest(0), new ILiveNetRequest.Callback() { // from class: com.tencent.mobileqq.qqlive.room.prepare.j
                @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
                public final void onResponse(QQLiveResponse qQLiveResponse) {
                    k.this.m2(qQLiveResponse);
                }
            });
        }
    }

    public void a2(long j3, IQQLiveGetRoomSettingCallback iQQLiveGetRoomSettingCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), iQQLiveGetRoomSettingCallback);
        } else {
            ((g) this.mRepository).m(j3, iQQLiveGetRoomSettingCallback);
        }
    }

    public int b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.P;
    }

    public String c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.N;
    }

    public void d2(Activity activity, QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) activity, (Object) qQLiveErrorMsg);
        } else if (qQLiveErrorMsg.bizErrCode == 6255) {
            com.tencent.mobileqq.qqlive.room.violation.a.a(qQLiveErrorMsg);
        } else {
            com.tencent.mobileqq.qqlive.room.violation.a.b(activity, this, qQLiveErrorMsg);
        }
    }

    public void e2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else if (this.C == null) {
            this.C = new QQLiveRealNameAuthData(i3);
        }
    }

    public Boolean f2() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Boolean) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        if (this.Q.getValue() != null && !this.Q.getValue().isGame) {
            z16 = false;
        } else {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }

    public boolean g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.S;
        if (qQECLiveEntryGoodsData == null) {
            return false;
        }
        return qQECLiveEntryGoodsData.getIsGokSelect();
    }

    public Boolean h2() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Boolean) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        if (this.S == null) {
            return Boolean.FALSE;
        }
        if (f2().booleanValue() && this.S.getIsGokWhiteListUser() && S1() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    public Boolean i2() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Boolean) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        if ((!g2() || S1() <= 0) && T1() <= 0 && R1() <= 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }

    public Boolean j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Boolean) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.S;
        if (qQECLiveEntryGoodsData == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(qQECLiveEntryGoodsData.getIsQShopWhiteListUser());
    }

    public boolean k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        QQLiveRealNameAuthData qQLiveRealNameAuthData = this.C;
        if (qQLiveRealNameAuthData != null && (qQLiveRealNameAuthData.getAuthState() == 2 || this.C.getAuthState() == 0)) {
            return true;
        }
        return false;
    }

    public boolean l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        QQLiveRealNameAuthData qQLiveRealNameAuthData = this.C;
        if (qQLiveRealNameAuthData != null && qQLiveRealNameAuthData.getAuthState() == 3) {
            return true;
        }
        return false;
    }

    public void o2(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qQLiveAnchorDataPrepare);
            return;
        }
        if (qQLiveAnchorDataPrepare != null) {
            if (qQLiveAnchorDataPrepare.roomAttr == null) {
                qQLiveAnchorDataPrepare.roomAttr = new QQLiveAnchorDataRoomAttr();
            }
            if (qQLiveAnchorDataPrepare.roomInfo == null) {
                qQLiveAnchorDataPrepare.roomInfo = new QQLiveAnchorDataRoomInfo();
            }
            this.f271954i = qQLiveAnchorDataPrepare;
            CoverInfo coverInfo = new CoverInfo();
            QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare.roomAttr;
            if (qQLiveAnchorDataRoomAttr != null) {
                coverInfo.roomLogo = qQLiveAnchorDataRoomAttr.poster;
                coverInfo.roomLogo3v4 = qQLiveAnchorDataRoomAttr.poster3v4;
                coverInfo.roomLogo16v9 = qQLiveAnchorDataRoomAttr.poster16v9;
                coverInfo.roomLogoTime = qQLiveAnchorDataRoomAttr.posterTime;
                coverInfo.roomLogoTime3v4 = qQLiveAnchorDataRoomAttr.posterTime3v4;
                coverInfo.roomLogoTime16v9 = qQLiveAnchorDataRoomAttr.posterTime16v9;
                com.tencent.mobileqq.qqlive.room.prepare.a aVar = new com.tencent.mobileqq.qqlive.room.prepare.a();
                QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo = qQLiveAnchorDataPrepare.roomAttr.gameInfo;
                if (qQLiveAnchorRoomGameInfo != null) {
                    aVar.c(qQLiveAnchorRoomGameInfo.f271211id);
                    aVar.e(qQLiveAnchorDataPrepare.roomAttr.gameInfo.name);
                    aVar.d(qQLiveAnchorDataPrepare.roomAttr.gameInfo.icon);
                    aVar.f(qQLiveAnchorDataPrepare.roomAttr.gameInfo.secondTagId);
                }
                this.I.setValue(aVar);
            } else {
                q2();
            }
            n2(coverInfo);
            this.E.setValue(coverInfo);
            MutableLiveData<String> mutableLiveData = this.F;
            QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo = qQLiveAnchorDataPrepare.roomInfo;
            if (qQLiveAnchorDataRoomInfo != null) {
                str = qQLiveAnchorDataRoomInfo.name;
            } else {
                str = "";
            }
            mutableLiveData.setValue(str);
            this.H.setValue(Boolean.valueOf(getRepository().l()));
            this.K.setValue(null);
            return;
        }
        q2();
    }

    public void p2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = this.f271954i.roomAttr;
        if (qQLiveAnchorDataRoomAttr != null) {
            qQLiveAnchorDataRoomAttr.roomName = str;
        } else {
            QLog.e("QQLivePrepareFragment_PrepareFragmentViewModel", 1, "setCurrentTitle but prepareLiveData.roomAttr = null");
        }
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo = this.f271954i.roomInfo;
        if (qQLiveAnchorDataRoomInfo != null) {
            qQLiveAnchorDataRoomInfo.name = str;
        }
    }

    public void r2(long j3, boolean z16, IQQLiveSetRoomSettingCallback iQQLiveSetRoomSettingCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), Boolean.valueOf(z16), iQQLiveSetRoomSettingCallback);
        } else {
            ((g) this.mRepository).p(j3, z16, iQQLiveSetRoomSettingCallback);
        }
    }

    public void s2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.P = i3;
        }
    }

    public void t2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.N = str;
        }
    }
}
