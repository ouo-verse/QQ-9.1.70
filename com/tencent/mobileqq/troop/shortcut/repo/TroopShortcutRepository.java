package com.tencent.mobileqq.troop.shortcut.repo;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.shortcut.actions.Message;
import com.tencent.mobileqq.troop.shortcut.actions.TroopShortcutAction;
import com.tencent.mobileqq.troop.shortcut.data.TroopShortcutInfo;
import com.tencent.mobileqq.troop.shortcut.data.TroopShortcutMenu;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.q;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.AppCommonAction;
import com.tencent.qqnt.kernel.nativeinterface.AppCommonMenu;
import com.tencent.qqnt.kernel.nativeinterface.AppCommonMenuAction;
import com.tencent.qqnt.kernel.nativeinterface.AppCommonMessage;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import com.tencent.qqnt.kernel.nativeinterface.ClientInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetCapsuleAppReq;
import com.tencent.qqnt.kernel.nativeinterface.GetCapsuleAppRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetCapsuleAppProCallback;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 @2\u00020\u0001:\u00012B\u000f\u0012\u0006\u00106\u001a\u000201\u00a2\u0006\u0004\bC\u0010DJ6\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J\"\u0010\"\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J:\u0010-\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\"\u0010\n\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0+j\b\u0012\u0004\u0012\u00020\u000e`,\u0012\u0004\u0012\u00020\t0\u0007J\u000f\u0010.\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b.\u0010/J\u0018\u00100\u001a\u0004\u0018\u00010!2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017R\u0017\u00106\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010=R\u0016\u0010B\u001a\u0004\u0018\u00010?8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/repo/TroopShortcutRepository;", "", "", NotifyMsgApiImpl.KEY_GROUP_TYPE, "", "showMiniApp", "forceFetch", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetCapsuleAppRsp;", "", "callback", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "detail", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "type", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo$AppType;", "k", "added", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/AppCommonAction;", "action", "", "appId", "", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu;", "r", "template", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu$MenuTemplate;", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/AppCommonMenuAction;", "associatedId", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "p", "Lcom/tencent/qqnt/kernel/nativeinterface/AppCommonMessage;", "msg", "Lcom/tencent/mobileqq/troop/shortcut/actions/Message;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/shortcut/actions/Message$MessageType;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction$Type;", "i", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", h.F, "e", "()Ljava/lang/Integer;", "o", "", "a", "J", "f", "()J", "troopUin", "b", "Lkotlin/Lazy;", "g", "()Ljava/lang/String;", "troopUinString", "Lcom/tencent/mobileqq/troop/shortcut/repo/TroopShortcutSettingCache;", "Lcom/tencent/mobileqq/troop/shortcut/repo/TroopShortcutSettingCache;", "settingCache", "Lcom/tencent/qqnt/kernel/api/s;", "d", "()Lcom/tencent/qqnt/kernel/api/s;", "groupService", "<init>", "(J)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopShortcutRepository {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, TroopShortcutInfo.AppType> f298533e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, TroopShortcutMenu.MenuTemplate> f298534f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, Message.MessageType> f298535g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, TroopShortcutAction.Type> f298536h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopUinString;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopShortcutSettingCache settingCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/repo/TroopShortcutRepository$a;", "", "", "MODE_DEFAULT", "I", "MODE_YOUTH", "NOT_SHOW_MINI_APP", "PLATFORM_ANDROID", "SHOW_MINI_APP", "", "TAG", "Ljava/lang/String;", "", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction$Type;", "actionTypeMap", "Ljava/util/Map;", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo$AppType;", "appTypeMap", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu$MenuTemplate;", "menuTemplateMap", "Lcom/tencent/mobileqq/troop/shortcut/actions/Message$MessageType;", "messageTypeMap", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutRepository$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/shortcut/repo/TroopShortcutRepository$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetCapsuleAppProCallback;", "", "errCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GetCapsuleAppRsp;", "rsp", "", "onResult", "onPreResult", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements IGetCapsuleAppProCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<GetCapsuleAppRsp, Unit> f298540a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super GetCapsuleAppRsp, Unit> function1) {
            this.f298540a = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetCapsuleAppProCallback
        public void onPreResult(int errCode, @Nullable String errMsg, @Nullable GetCapsuleAppRsp rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(errCode), errMsg, rsp);
                return;
            }
            QLog.i("TroopShortcut.TroopShortcutRepository", 1, "getCapsuleApp() get cache response: " + rsp);
            if (errCode != 0) {
                if (QLog.isDebugVersion()) {
                    QLog.d("TroopShortcut.TroopShortcutRepository", 4, "getCapsuleApp() cache error: " + errMsg);
                }
                this.f298540a.invoke(null);
                return;
            }
            this.f298540a.invoke(rsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetCapsuleAppProCallback
        public void onResult(int errCode, @Nullable String errMsg, @Nullable GetCapsuleAppRsp rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errCode), errMsg, rsp);
                return;
            }
            QLog.i("TroopShortcut.TroopShortcutRepository", 1, "getCapsuleApp() get response: " + rsp);
            if (errCode != 0) {
                QLog.e("TroopShortcut.TroopShortcutRepository", 1, "getCapsuleApp() error: " + errMsg);
                this.f298540a.invoke(null);
                return;
            }
            this.f298540a.invoke(rsp);
        }
    }

    static {
        Map<Integer, TroopShortcutInfo.AppType> mapOf;
        Map<Integer, TroopShortcutMenu.MenuTemplate> mapOf2;
        Map<Integer, Message.MessageType> mapOf3;
        Map<Integer, TroopShortcutAction.Type> mapOf4;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55281);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, TroopShortcutInfo.AppType.TYPE_DEFAULT), TuplesKt.to(1, TroopShortcutInfo.AppType.TYPE_PLATFORM), TuplesKt.to(2, TroopShortcutInfo.AppType.TYPE_MINI_PROGRAM), TuplesKt.to(3, TroopShortcutInfo.AppType.TYPE_ROBOT), TuplesKt.to(4, TroopShortcutInfo.AppType.TYPE_CAPSULE));
        f298533e = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(0, TroopShortcutMenu.MenuTemplate.TEMPLATE_DEFAULT), TuplesKt.to(1, TroopShortcutMenu.MenuTemplate.TEMPLATE_SINGLE_LINE_TEXT_TEXT), TuplesKt.to(2, TroopShortcutMenu.MenuTemplate.TEMPLATE_SINGLE_LINE_ICON_TEXT), TuplesKt.to(3, TroopShortcutMenu.MenuTemplate.TEMPLATE_SINGLE_LINE_TEXT_ICON), TuplesKt.to(4, TroopShortcutMenu.MenuTemplate.TEMPLATE_SINGLE_LINE_ICON_ICON), TuplesKt.to(5, TroopShortcutMenu.MenuTemplate.TEMPLATE_TWO_LINE_TEXT_BTN), TuplesKt.to(6, TroopShortcutMenu.MenuTemplate.TEMPLATE_TWO_LINE_ICON_BTN), TuplesKt.to(7, TroopShortcutMenu.MenuTemplate.TEMPLATE_TWO_LINE_TEXT_ICON), TuplesKt.to(8, TroopShortcutMenu.MenuTemplate.TEMPLATE_TWO_LINE_ICON_ICON));
        f298534f = mapOf2;
        mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to(0, Message.MessageType.MSG_TYPE_DEFAULT), TuplesKt.to(1, Message.MessageType.MSG_TYPE_SEND_MESSAGE), TuplesKt.to(2, Message.MessageType.MSG_TYPE_INPUT));
        f298535g = mapOf3;
        mapOf4 = MapsKt__MapsKt.mapOf(TuplesKt.to(0, TroopShortcutAction.Type.ACTION_DEFAULT), TuplesKt.to(1, TroopShortcutAction.Type.SCHEMA), TuplesKt.to(2, TroopShortcutAction.Type.CMD), TuplesKt.to(3, TroopShortcutAction.Type.OPEN_MENU), TuplesKt.to(4, TroopShortcutAction.Type.APP_ID));
        f298536h = mapOf4;
    }

    public TroopShortcutRepository(long j3) {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.troopUin = j3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutRepository$troopUinString$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopShortcutRepository.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? String.valueOf(TroopShortcutRepository.this.f()) : (String) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.troopUinString = lazy;
        this.settingCache = TroopShortcutSettingCache.INSTANCE.a();
    }

    private final void c(int groupType, boolean showMiniApp, boolean forceFetch, Function1<? super GetCapsuleAppRsp, Unit> callback) {
        GetCapsuleAppReq getCapsuleAppReq = new GetCapsuleAppReq();
        ClientInfo clientInfo = getCapsuleAppReq.client;
        clientInfo.platform = 2;
        clientInfo.version = AppSetting.f99551k + "." + AppSetting.f99542b;
        getCapsuleAppReq.groupId = this.troopUin;
        getCapsuleAppReq.groupType = groupType;
        getCapsuleAppReq.miniappProtect = !showMiniApp ? 1 : 0;
        getCapsuleAppReq.mode = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() ? 1 : 0;
        QLog.i("TroopShortcut.TroopShortcutRepository", 1, "getCapsuleApp() send request: " + getCapsuleAppReq);
        s d16 = d();
        if (d16 != null) {
            d16.s(getCapsuleAppReq, forceFetch, new b(callback));
        }
    }

    private final s d() {
        return bg.i(null, 1, null);
    }

    private final String g() {
        return (String) this.troopUinString.getValue();
    }

    private final TroopShortcutAction.Type i(int type) {
        TroopShortcutAction.Type type2 = f298536h.get(Integer.valueOf(type));
        if (type2 == null) {
            QLog.e("TroopShortcut.TroopShortcutRepository", 1, "unknown action type: " + type);
            return TroopShortcutAction.Type.ACTION_DEFAULT;
        }
        return type2;
    }

    private final boolean j(int added) {
        if (added == 1) {
            return true;
        }
        return false;
    }

    private final TroopShortcutInfo.AppType k(int type) {
        TroopShortcutInfo.AppType appType = f298533e.get(Integer.valueOf(type));
        if (appType == null) {
            QLog.e("TroopShortcut.TroopShortcutRepository", 1, "unknown app type: " + type);
            return TroopShortcutInfo.AppType.TYPE_DEFAULT;
        }
        return appType;
    }

    private final TroopShortcutMenu.MenuTemplate l(int template) {
        TroopShortcutMenu.MenuTemplate menuTemplate = f298534f.get(Integer.valueOf(template));
        if (menuTemplate == null) {
            QLog.e("TroopShortcut.TroopShortcutRepository", 1, "unknown template id: " + template);
            return TroopShortcutMenu.MenuTemplate.TEMPLATE_DEFAULT;
        }
        return menuTemplate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        r2 = kotlin.text.StringsKt__StringsJVMKt.decodeToString(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        r9 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r2, "\\u0014", "\u0014", false, 4, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Message m(AppCommonMessage msg2) {
        String str;
        String decodeToString;
        Message.MessageType n3 = n(msg2.type);
        byte[] bArr = msg2.f359159msg;
        if (bArr == null || decodeToString == null || str == null) {
            str = "";
        }
        return new Message(n3, str);
    }

    private final Message.MessageType n(int type) {
        Message.MessageType messageType = f298535g.get(Integer.valueOf(type));
        if (messageType == null) {
            QLog.e("TroopShortcut.TroopShortcutRepository", 1, "unknown template id: " + type);
            return Message.MessageType.MSG_TYPE_DEFAULT;
        }
        return messageType;
    }

    private final TroopShortcutAction p(AppCommonMenuAction action, String appId, String associatedId) {
        int collectionSizeOrDefault;
        TroopShortcutAction.Type i3 = i(action.type);
        ArrayList<AppCommonMessage> arrayList = action.msgList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "action.msgList");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (AppCommonMessage it : arrayList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList2.add(m(it));
        }
        String g16 = g();
        String str = action.jump.url;
        Intrinsics.checkNotNullExpressionValue(str, "action.jump.url");
        if (associatedId == null) {
            associatedId = "";
        }
        return new TroopShortcutAction(i3, appId, arrayList2, g16, str, false, associatedId, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopShortcutInfo q(AppDetail detail) {
        String str = detail.appId;
        Intrinsics.checkNotNullExpressionValue(str, "detail.appId");
        String str2 = detail.name;
        Intrinsics.checkNotNullExpressionValue(str2, "detail.name");
        String str3 = detail.icon;
        Intrinsics.checkNotNullExpressionValue(str3, "detail.icon");
        TroopShortcutInfo.AppType k3 = k(detail.type);
        boolean z16 = detail.removable;
        String str4 = detail.desc;
        Intrinsics.checkNotNullExpressionValue(str4, "detail.desc");
        boolean j3 = j(detail.added);
        AppCommonAction appCommonAction = detail.action;
        Intrinsics.checkNotNullExpressionValue(appCommonAction, "detail.action");
        String str5 = detail.appId;
        Intrinsics.checkNotNullExpressionValue(str5, "detail.appId");
        List<TroopShortcutMenu> r16 = r(appCommonAction, str5);
        AppCommonAction appCommonAction2 = detail.action;
        Intrinsics.checkNotNullExpressionValue(appCommonAction2, "detail.action");
        String str6 = detail.appId;
        Intrinsics.checkNotNullExpressionValue(str6, "detail.appId");
        TroopShortcutAction o16 = o(appCommonAction2, str6);
        String str7 = detail.adId;
        Intrinsics.checkNotNullExpressionValue(str7, "detail.adId");
        return new TroopShortcutInfo(str, str2, str3, k3, z16, str4, j3, r16, o16, str7);
    }

    private final List<TroopShortcutMenu> r(AppCommonAction action, String appId) {
        List<TroopShortcutMenu> emptyList;
        int collectionSizeOrDefault;
        ArrayList<AppCommonMenu> arrayList = action.menuList;
        if (arrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (AppCommonMenu appCommonMenu : arrayList) {
                String str = appCommonMenu.menuId;
                Intrinsics.checkNotNullExpressionValue(str, "it.menuId");
                TroopShortcutMenu.MenuTemplate l3 = l(appCommonMenu.getAppCommonMenuTemplateTemplate());
                String str2 = appCommonMenu.icon;
                Intrinsics.checkNotNullExpressionValue(str2, "it.icon");
                String str3 = appCommonMenu.title;
                Intrinsics.checkNotNullExpressionValue(str3, "it.title");
                String str4 = appCommonMenu.desc;
                Intrinsics.checkNotNullExpressionValue(str4, "it.desc");
                String str5 = appCommonMenu.btnText;
                Intrinsics.checkNotNullExpressionValue(str5, "it.btnText");
                AppCommonMenuAction appCommonMenuAction = appCommonMenu.action;
                Intrinsics.checkNotNullExpressionValue(appCommonMenuAction, "it.action");
                TroopShortcutAction p16 = p(appCommonMenuAction, appId, action.associatedId);
                String str6 = appCommonMenu.rightText;
                Intrinsics.checkNotNullExpressionValue(str6, "it.rightText");
                arrayList2.add(new TroopShortcutMenu(str, l3, str2, str3, str4, str5, p16, str6));
            }
            return arrayList2;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Nullable
    public final Integer e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Integer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(String.valueOf(this.troopUin));
        if (troopInfoFromCache != null) {
            return Integer.valueOf((int) troopInfoFromCache.dwGroupClassExt);
        }
        return null;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.troopUin;
    }

    public final void h(boolean showMiniApp, boolean forceFetch, @NotNull Function1<? super ArrayList<TroopShortcutInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(showMiniApp), Boolean.valueOf(forceFetch), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        Integer e16 = e();
        if (e16 != null) {
            final int intValue = e16.intValue();
            q.b("TroopShortcut.TroopShortcutRepository", new Function0<String>(intValue, this) { // from class: com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutRepository$loadData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $groupType;
                final /* synthetic */ TroopShortcutRepository this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$groupType = intValue;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, intValue, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "groupType: " + this.$groupType + ", troopUin: " + this.this$0.f();
                }
            });
            c(intValue, showMiniApp, forceFetch, new TroopShortcutRepository$loadData$2(this, callback));
            return;
        }
        QLog.e("TroopShortcut.TroopShortcutRepository", 1, "get group type is null");
    }

    @Nullable
    public final TroopShortcutAction o(@NotNull AppCommonAction action, @NotNull String appId) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopShortcutAction) iPatchRedirector.redirect((short) 5, (Object) this, (Object) action, (Object) appId);
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(appId, "appId");
        TroopShortcutAction.Type i3 = i(action.type);
        if (i3 == TroopShortcutAction.Type.OPEN_MENU) {
            return null;
        }
        ArrayList<AppCommonMessage> arrayList = action.msgList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "action.msgList");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (AppCommonMessage it : arrayList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList2.add(m(it));
        }
        String g16 = g();
        String str = action.jump.url;
        Intrinsics.checkNotNullExpressionValue(str, "action.jump.url");
        String str2 = action.associatedId;
        Intrinsics.checkNotNullExpressionValue(str2, "action.associatedId");
        return new TroopShortcutAction(i3, appId, arrayList2, g16, str, false, str2, 32, null);
    }
}
