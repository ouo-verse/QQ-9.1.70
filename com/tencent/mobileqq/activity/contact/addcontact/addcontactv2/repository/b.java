package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.e;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.g;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.i;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.QZoneInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.addcontact.api.IAddContactRemoteConfig;
import com.tencent.mobileqq.troop.addcontact.api.IAddContactSessionRepo;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$RecommendGroup;
import tencent.im.oidb.oidb_0xc26$MayKnowPerson;
import tencent.im.oidb.oidb_0xc26$QzoneInfo;
import tencent.im.troop.findtroop.TabRecommendPB$GetTabRecommendReq;
import tencent.im.troop.findtroop.TabRecommendPB$GetTabRecommendRsp;
import tencent.im.troop.findtroop.TabRecommendPB$RecommendGroup;
import tencent.im.troop.findtroop.TabRecommendPB$Session;
import tencent.im.troop.findtroop.TabRecommendPB$SetRecommendFeedbackReq;
import tencent.im.troop.findtroop.TabRecommendPB$TabRecommendResult;
import tencent.im.troop.flock.QeventPB$Feed;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103Jt\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n2:\u0010\u0013\u001a6\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\fj\u0002`\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u000e\u0010\u001e\u001a\u0004\u0018\u00010\u001d*\u00020\u001cH\u0002J\f\u0010!\u001a\u00020 *\u00020\u001fH\u0002J\u000e\u0010$\u001a\u0004\u0018\u00010#*\u00020\"H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020%H\u0002J\\\u0010*\u001a\u00020\t2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n2:\u0010\u0013\u001a6\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\fj\u0002`\u0012H\u0016Jt\u0010.\u001a\u00020\t2\u0006\u0010,\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00052\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n2:\u0010\u0013\u001a6\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\fj\u0002`\u0012H\u0016J\u0018\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0002H\u0016J\u0006\u00101\u001a\u00020%\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/repository/b;", "", "", "tab", "source", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/i;", "sessionWrapper", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/h;", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/repository/AddContactRecommendSuccessCallback;", "onSuccess", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "errCode", "", "errMsg", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/repository/AddContactRecommendFailedCallback;", "onFailed", "k", "Ltencent/im/troop/findtroop/TabRecommendPB$Session;", "sessions", "l", "", "data", "Ltencent/im/troop/findtroop/TabRecommendPB$GetTabRecommendRsp;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ltencent/im/troop/findtroop/TabRecommendPB$TabRecommendResult;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/g;", "o", "Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$RecommendGroup;", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "p", "Ltencent/im/oidb/oidb_0xc26$MayKnowPerson;", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", h.F, "f", "g", "e", "i", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "sessionInfo", "j", "id", "d", DomainData.DOMAIN_NAME, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f180893a;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f180894a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49828);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AddContactDataType.values().length];
            try {
                iArr[AddContactDataType.f293812GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AddContactDataType.PERSON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AddContactDataType.GUILD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AddContactDataType.FLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f180894a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/addcontactv2/repository/b$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7145b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        C7145b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(errorCode), errorMsg, bundle)).booleanValue();
            }
            QLog.e("AddContactRepositoryV2", 1, "dislikeRecommendData errCode: " + errorCode + ", errMsg: " + errorMsg);
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            if (errorCode == 0) {
                QLog.d("AddContactRepositoryV2", 2, "dislikeRecommendData success.");
                return;
            }
            QLog.e("AddContactRepositoryV2", 1, "dislikeRecommendData errorCode: " + errorCode);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/addcontactv2/repository/b$c", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f180895d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f180896e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.h, Unit> f180897f;

        c(int i3, Function2<? super Integer, ? super String, Unit> function2, Function1<? super com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.h, Unit> function1) {
            this.f180895d = i3;
            this.f180896e = function2;
            this.f180897f = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), function2, function1);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(errorCode), errorMsg, bundle)).booleanValue();
            }
            Function2<Integer, String, Unit> function2 = this.f180896e;
            Integer valueOf = Integer.valueOf(errorCode);
            if (errorMsg == null) {
                errorMsg = "";
            }
            function2.invoke(valueOf, errorMsg);
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            if (errorCode == 0 && data != null) {
                QLog.i("AddContactRepositoryV2", 1, "fetchPageData success. tab: " + this.f180895d);
                TabRecommendPB$GetTabRecommendRsp m3 = b.f180893a.m(data);
                if (m3 == null) {
                    QLog.e("AddContactRepositoryV2", 1, "fetchPageData error, retData is null. tab: " + this.f180895d);
                    this.f180896e.invoke(Integer.valueOf(errorCode), "response data is null");
                    return;
                }
                int i3 = m3.tab.get();
                int i16 = this.f180895d;
                if (i3 != i16) {
                    QLog.e("AddContactRepositoryV2", 1, "fetchPageData error, tab type not match. tab: " + i16);
                    this.f180896e.invoke(Integer.valueOf(errorCode), "response tab error");
                    return;
                }
                List<TabRecommendPB$TabRecommendResult> list = m3.tab_recommend_result.get();
                Intrinsics.checkNotNullExpressionValue(list, "retData.tab_recommend_result.get()");
                ArrayList arrayList = new ArrayList();
                for (TabRecommendPB$TabRecommendResult it : list) {
                    b bVar = b.f180893a;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    g o16 = bVar.o(it);
                    if (o16 != null) {
                        arrayList.add(o16);
                    }
                }
                TabRecommendPB$Session sessions = m3.session_info.get();
                b bVar2 = b.f180893a;
                Intrinsics.checkNotNullExpressionValue(sessions, "sessions");
                i l3 = bVar2.l(sessions);
                Function1<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.h, Unit> function1 = this.f180897f;
                if (m3.is_end.get() == 1) {
                    z16 = true;
                }
                function1.invoke(new com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.h(l3, z16, arrayList));
                return;
            }
            QLog.e("AddContactRepositoryV2", 1, "fetchPageData error, code:" + errorCode + " or data is null. tab: " + this.f180895d);
            this.f180896e.invoke(Integer.valueOf(errorCode), "");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49849);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f180893a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean e() {
        if (((IAddContactRemoteConfig) QRoute.api(IAddContactRemoteConfig.class)).showFlockEntrance() && !StudyModeManager.t()) {
            return true;
        }
        return false;
    }

    private final boolean f() {
        return !StudyModeManager.t();
    }

    private final boolean g() {
        return !StudyModeManager.t();
    }

    private final boolean h() {
        Manager manager;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        MayknowRecommendManager mayknowRecommendManager = null;
        if (peekAppRuntime != null) {
            manager = peekAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        } else {
            manager = null;
        }
        if (manager instanceof MayknowRecommendManager) {
            mayknowRecommendManager = (MayknowRecommendManager) manager;
        }
        if (mayknowRecommendManager != null && !mayknowRecommendManager.i("sp_mayknow_entry_list_add")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !StudyModeManager.t()) {
            return true;
        }
        return false;
    }

    private final void k(int tab, int source, i sessionWrapper, Function1<? super com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.h, Unit> onSuccess, Function2<? super Integer, ? super String, Unit> onFailed) {
        QLog.i("AddContactRepositoryV2", 1, "fetchPage. tab: " + tab);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("AddContactRepositoryV2", 1, "fetchPageData error. app is null. tab: " + tab);
            return;
        }
        TabRecommendPB$Session tabRecommendPB$Session = new TabRecommendPB$Session();
        tabRecommendPB$Session.group_session_info.set(ByteStringMicro.copyFrom(sessionWrapper.a()));
        tabRecommendPB$Session.person_session_info.set(ByteStringMicro.copyFrom(sessionWrapper.d()));
        tabRecommendPB$Session.guild_session_info.set(ByteStringMicro.copyFrom(sessionWrapper.b()));
        tabRecommendPB$Session.qevent_session_info.set(ByteStringMicro.copyFrom(sessionWrapper.c()));
        TabRecommendPB$GetTabRecommendReq tabRecommendPB$GetTabRecommendReq = new TabRecommendPB$GetTabRecommendReq();
        tabRecommendPB$GetTabRecommendReq.tab.set(tab);
        tabRecommendPB$GetTabRecommendReq.session_info.set(tabRecommendPB$Session);
        tabRecommendPB$GetTabRecommendReq.source.set(source);
        ArrayList arrayList = new ArrayList();
        b bVar = f180893a;
        if (!bVar.f()) {
            arrayList.add(0);
        }
        if (!bVar.h()) {
            arrayList.add(2);
        }
        if (!bVar.g()) {
            arrayList.add(1);
        }
        if (!bVar.e()) {
            arrayList.add(3);
        }
        QLog.i("AddContactRepositoryV2", 1, "fetchPageData filterType: " + arrayList);
        tabRecommendPB$GetTabRecommendReq.filter_type.set(arrayList);
        ProtoUtils.a(peekAppRuntime, new c(tab, onFailed, onSuccess), tabRecommendPB$GetTabRecommendReq.toByteArray(), "OidbSvcTrpcTcp.0x904d", 36941, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i l(TabRecommendPB$Session sessions) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        ByteStringMicro byteStringMicro = sessions.group_session_info.get();
        byte[] bArr4 = null;
        if (byteStringMicro != null) {
            bArr = byteStringMicro.toByteArray();
        } else {
            bArr = null;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        ByteStringMicro byteStringMicro2 = sessions.person_session_info.get();
        if (byteStringMicro2 != null) {
            bArr2 = byteStringMicro2.toByteArray();
        } else {
            bArr2 = null;
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        ByteStringMicro byteStringMicro3 = sessions.guild_session_info.get();
        if (byteStringMicro3 != null) {
            bArr3 = byteStringMicro3.toByteArray();
        } else {
            bArr3 = null;
        }
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        ByteStringMicro byteStringMicro4 = sessions.qevent_session_info.get();
        if (byteStringMicro4 != null) {
            bArr4 = byteStringMicro4.toByteArray();
        }
        if (bArr4 == null) {
            bArr4 = new byte[0];
        }
        IAddContactSessionRepo iAddContactSessionRepo = (IAddContactSessionRepo) QRoute.api(IAddContactSessionRepo.class);
        iAddContactSessionRepo.setSession(AddContactDataType.f293812GROUP, bArr);
        iAddContactSessionRepo.setSession(AddContactDataType.PERSON, bArr2);
        iAddContactSessionRepo.setSession(AddContactDataType.GUILD, bArr3);
        iAddContactSessionRepo.setSession(AddContactDataType.FLOCK, bArr4);
        return new i(bArr, bArr2, bArr3, bArr4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TabRecommendPB$GetTabRecommendRsp m(byte[] data) {
        try {
            return new TabRecommendPB$GetTabRecommendRsp().mergeFrom(data);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("AddContactRepositoryV2", 1, e16, "parseTabRecommendRsp error.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g o(TabRecommendPB$TabRecommendResult tabRecommendPB$TabRecommendResult) {
        int collectionSizeOrDefault;
        g gVar;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        int i3 = tabRecommendPB$TabRecommendResult.type.get();
        QZoneInfo qZoneInfo = null;
        if (i3 == 0 && tabRecommendPB$TabRecommendResult.new_recommend_groups.has()) {
            AddContactDataType addContactDataType = AddContactDataType.f293812GROUP;
            List<TabRecommendPB$RecommendGroup> list = tabRecommendPB$TabRecommendResult.new_recommend_groups.get();
            Intrinsics.checkNotNullExpressionValue(list, "new_recommend_groups.get()");
            List<TabRecommendPB$RecommendGroup> list2 = list;
            collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault4);
            for (TabRecommendPB$RecommendGroup tabRecommendPB$RecommendGroup : list2) {
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar = new com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c(addContactDataType);
                if (tabRecommendPB$RecommendGroup.recommend_group.has()) {
                    b bVar = f180893a;
                    guildSearchRecommendSvr$RecommendGroup guildsearchrecommendsvr_recommendgroup = tabRecommendPB$RecommendGroup.recommend_group.get();
                    Intrinsics.checkNotNullExpressionValue(guildsearchrecommendsvr_recommendgroup, "it.recommend_group.get()");
                    cVar.i(bVar.p(guildsearchrecommendsvr_recommendgroup));
                }
                if (tabRecommendPB$RecommendGroup.recommend_qevent.has()) {
                    cVar.g(tabRecommendPB$RecommendGroup.recommend_qevent.get());
                }
                arrayList.add(cVar);
            }
            QLog.i("AddContactRepositoryV2", 2, "parseContactItem type is group, size = " + arrayList.size());
            if (!(!arrayList.isEmpty())) {
                return null;
            }
            String str = tabRecommendPB$TabRecommendResult.type_title.get();
            Intrinsics.checkNotNullExpressionValue(str, "type_title.get()");
            gVar = new g(new e(addContactDataType, str), arrayList, null);
        } else if (i3 == 1 && tabRecommendPB$TabRecommendResult.recommend_guilds.has()) {
            AddContactDataType addContactDataType2 = AddContactDataType.GUILD;
            List<guildSearchRecommendSvr$RecommendGroup> list3 = tabRecommendPB$TabRecommendResult.recommend_guilds.get();
            Intrinsics.checkNotNullExpressionValue(list3, "recommend_guilds.get()");
            List<guildSearchRecommendSvr$RecommendGroup> list4 = list3;
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault3);
            for (guildSearchRecommendSvr$RecommendGroup guildsearchrecommendsvr_recommendgroup2 : list4) {
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar2 = new com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c(addContactDataType2);
                b bVar2 = f180893a;
                guildSearchRecommendSvr$RecommendGroup guildsearchrecommendsvr_recommendgroup3 = guildsearchrecommendsvr_recommendgroup2.get();
                Intrinsics.checkNotNullExpressionValue(guildsearchrecommendsvr_recommendgroup3, "it.get()");
                cVar2.i(bVar2.p(guildsearchrecommendsvr_recommendgroup3));
                arrayList2.add(cVar2);
            }
            QLog.i("AddContactRepositoryV2", 2, "parseContactItem type is guild, size = " + arrayList2.size());
            if (!(!arrayList2.isEmpty())) {
                return null;
            }
            String str2 = tabRecommendPB$TabRecommendResult.type_title.get();
            Intrinsics.checkNotNullExpressionValue(str2, "type_title.get()");
            gVar = new g(new e(addContactDataType2, str2), arrayList2, null);
        } else if (i3 == 2 && tabRecommendPB$TabRecommendResult.recommend_person.has()) {
            AddContactDataType addContactDataType3 = AddContactDataType.PERSON;
            List<oidb_0xc26$MayKnowPerson> list5 = tabRecommendPB$TabRecommendResult.recommend_person.get();
            Intrinsics.checkNotNullExpressionValue(list5, "recommend_person.get()");
            List<oidb_0xc26$MayKnowPerson> list6 = list5;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
            for (oidb_0xc26$MayKnowPerson oidb_0xc26_mayknowperson : list6) {
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar3 = new com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c(addContactDataType3);
                b bVar3 = f180893a;
                oidb_0xc26$MayKnowPerson oidb_0xc26_mayknowperson2 = oidb_0xc26_mayknowperson.get();
                Intrinsics.checkNotNullExpressionValue(oidb_0xc26_mayknowperson2, "it.get()");
                cVar3.h(bVar3.q(oidb_0xc26_mayknowperson2));
                arrayList3.add(cVar3);
            }
            QLog.i("AddContactRepositoryV2", 2, "parseContactItem type is person, size = " + arrayList3.size());
            if (!(!arrayList3.isEmpty())) {
                return null;
            }
            String str3 = tabRecommendPB$TabRecommendResult.type_title.get();
            Intrinsics.checkNotNullExpressionValue(str3, "type_title.get()");
            e eVar = new e(addContactDataType3, str3);
            if (tabRecommendPB$TabRecommendResult.qzone_info.has()) {
                oidb_0xc26$QzoneInfo oidb_0xc26_qzoneinfo = tabRecommendPB$TabRecommendResult.qzone_info.get();
                Intrinsics.checkNotNullExpressionValue(oidb_0xc26_qzoneinfo, "qzone_info.get()");
                qZoneInfo = new QZoneInfo(oidb_0xc26_qzoneinfo);
            }
            gVar = new g(eVar, arrayList3, qZoneInfo);
        } else {
            if (i3 != 3 || !tabRecommendPB$TabRecommendResult.recommend_qevents.has()) {
                return null;
            }
            AddContactDataType addContactDataType4 = AddContactDataType.FLOCK;
            List<QeventPB$Feed> list7 = tabRecommendPB$TabRecommendResult.recommend_qevents.get();
            Intrinsics.checkNotNullExpressionValue(list7, "recommend_qevents.get()");
            List<QeventPB$Feed> list8 = list7;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list8, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
            for (QeventPB$Feed qeventPB$Feed : list8) {
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar4 = new com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c(addContactDataType4);
                cVar4.g(qeventPB$Feed.get());
                arrayList4.add(cVar4);
            }
            QLog.i("AddContactRepositoryV2", 2, "parseContactItem type is flock, size = " + arrayList4.size());
            if (!(!arrayList4.isEmpty())) {
                return null;
            }
            String str4 = tabRecommendPB$TabRecommendResult.type_title.get();
            Intrinsics.checkNotNullExpressionValue(str4, "type_title.get()");
            gVar = new g(new e(addContactDataType4, str4), arrayList4, null);
        }
        return gVar;
    }

    private final RecommendTroopItem p(guildSearchRecommendSvr$RecommendGroup guildsearchrecommendsvr_recommendgroup) {
        String str;
        int i3;
        String str2;
        RecommendTroopItem recommendTroopItem = new RecommendTroopItem();
        recommendTroopItem.uin = String.valueOf(guildsearchrecommendsvr_recommendgroup.code.get());
        byte[] byteArray = guildsearchrecommendsvr_recommendgroup.name.get().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "name.get().toByteArray()");
        Charset charset = Charsets.UTF_8;
        recommendTroopItem.name = new String(byteArray, charset);
        byte[] byteArray2 = guildsearchrecommendsvr_recommendgroup.memo.get().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray2, "memo.get().toByteArray()");
        recommendTroopItem.intro = new String(byteArray2, charset);
        recommendTroopItem.labelList = com.tencent.mobileqq.troop.recommend.b.b(guildsearchrecommendsvr_recommendgroup.tags.get());
        recommendTroopItem.stateList = com.tencent.mobileqq.troop.recommend.b.b(guildsearchrecommendsvr_recommendgroup.states.get());
        recommendTroopItem.icon = guildsearchrecommendsvr_recommendgroup.icon.get();
        recommendTroopItem.type = guildsearchrecommendsvr_recommendgroup.type.get();
        recommendTroopItem.memberNum = guildsearchrecommendsvr_recommendgroup.member_num.get();
        String str3 = "";
        if (!guildsearchrecommendsvr_recommendgroup.join_group_auth.has()) {
            str = "";
        } else {
            str = guildsearchrecommendsvr_recommendgroup.join_group_auth.get().toStringUtf8();
        }
        recommendTroopItem.authSig = str;
        if (guildsearchrecommendsvr_recommendgroup.activity.has()) {
            i3 = guildsearchrecommendsvr_recommendgroup.activity.get();
        } else {
            i3 = 0;
        }
        recommendTroopItem.activity = i3;
        recommendTroopItem.privilege = guildsearchrecommendsvr_recommendgroup.uin_privilege.get();
        if (!guildsearchrecommendsvr_recommendgroup.bytes_algorithm.has()) {
            str2 = "";
        } else {
            str2 = guildsearchrecommendsvr_recommendgroup.bytes_algorithm.get().toStringUtf8();
        }
        recommendTroopItem.recomAlgol = str2;
        recommendTroopItem.labels = guildsearchrecommendsvr_recommendgroup.v2_tags.get();
        recommendTroopItem.medalInfoList = guildsearchrecommendsvr_recommendgroup.medals.get();
        if (guildsearchrecommendsvr_recommendgroup.recom_trace.has()) {
            str3 = guildsearchrecommendsvr_recommendgroup.recom_trace.get();
        }
        recommendTroopItem.recommendTrace = str3;
        return recommendTroopItem;
    }

    private final MayKnowRecommend q(oidb_0xc26$MayKnowPerson oidb_0xc26_mayknowperson) {
        return MayKnowRecommend.convertServerDataToLocal((int) (System.currentTimeMillis() / 1000), 23, "", "", oidb_0xc26_mayknowperson);
    }

    public void d(@NotNull String id5, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) id5, type);
            return;
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        QLog.i("AddContactRepositoryV2", 1, "dislikeRecommendData. id: " + id5 + ", type: " + type);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("AddContactRepositoryV2", 1, "dislikeRecommendData error. app is null. id: " + id5 + ", type: " + type);
            return;
        }
        TabRecommendPB$SetRecommendFeedbackReq tabRecommendPB$SetRecommendFeedbackReq = new TabRecommendPB$SetRecommendFeedbackReq();
        tabRecommendPB$SetRecommendFeedbackReq.f436057id.set(id5);
        tabRecommendPB$SetRecommendFeedbackReq.type.set(type);
        ProtoUtils.a(peekAppRuntime, new C7145b(), tabRecommendPB$SetRecommendFeedbackReq.toByteArray(), "OidbSvcTrpcTcp.0x9071", 36977, 0);
    }

    public void i(@NotNull Function1<? super com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.h, Unit> onSuccess, @NotNull Function2<? super Integer, ? super String, Unit> onFailed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onSuccess, (Object) onFailed);
            return;
        }
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        k(1, 0, com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.c.a(), onSuccess, onFailed);
    }

    public void j(@NotNull AddContactDataType type, int source, @NotNull i sessionInfo, @NotNull Function1<? super com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.h, Unit> onSuccess, @NotNull Function2<? super Integer, ? super String, Unit> onFailed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, type, Integer.valueOf(source), sessionInfo, onSuccess, onFailed);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        int i16 = a.f180894a[type.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    QLog.e("AddContactRepositoryV2", 1, "not support " + type + " to fetch addContacts list data");
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("not support ");
                    sb5.append(type);
                    onFailed.invoke(-1, sb5.toString());
                    return;
                }
            } else {
                i3 = 3;
            }
        } else {
            i3 = 2;
        }
        k(i3, source, sessionInfo, onSuccess, onFailed);
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!f() && !h() && !g() && !e()) {
            return true;
        }
        return false;
    }
}
