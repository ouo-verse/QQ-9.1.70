package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bh;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b8\u00109J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0016R$\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0002\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001c\u00104\u001a\n 2*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/e;", "", "", "i", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Lcom/tencent/mobileqq/app/QQAppInterface;", "a", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/app/Activity;", "b", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "", "c", "[Ljava/lang/String;", "defaultLocationCodes", "", "<set-?>", "d", "Z", "l", "()Z", "autoReqLocation", "e", "isConfigReady", "f", "locationCodes", "Lkotlin/Function1;", "g", "Lkotlin/jvm/functions/Function1;", "onConditionChangedListener", "Lcom/tencent/mobileqq/app/ConditionSearchManager;", tl.h.F, "Lcom/tencent/mobileqq/app/ConditionSearchManager;", "searchManager", "Lcom/tencent/mobileqq/app/ConditionSearchManager$c;", "Lcom/tencent/mobileqq/app/ConditionSearchManager$c;", "configListener", "Lcom/tencent/mobileqq/app/ConditionSearchManager$d;", "j", "Lcom/tencent/mobileqq/app/ConditionSearchManager$d;", "mLocationCanCelListener", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "conditionsPrefix", "Lcom/tencent/mobileqq/app/bh;", "Lcom/tencent/mobileqq/app/bh;", "lbsObserver", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQAppInterface app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String[] defaultLocationCodes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean autoReqLocation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isConfigReady;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String[] locationCodes;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> onConditionChangedListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConditionSearchManager searchManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConditionSearchManager.c configListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConditionSearchManager.d mLocationCanCelListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final String conditionsPrefix;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bh lbsObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/e$a;", "", "", "STRING_COMMA", "Ljava/lang/String;", "TAG", "", "VALID_CODES_SIZE", "I", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.e$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/e$b", "Lcom/tencent/mobileqq/app/bh;", "", "isSuccess", "Lcom/tencent/av/service/LBSInfo;", "info", "", "onGetUserLocation", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends bh {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bh
        public void onGetUserLocation(boolean isSuccess, @Nullable LBSInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), info);
                return;
            }
            if (isSuccess && info != null && info.a() != null) {
                e eVar = e.this;
                String[] a16 = info.a();
                Intrinsics.checkNotNullExpressionValue(a16, "info.codes");
                eVar.locationCodes = a16;
            }
            if (e.this.locationCodes.length != 4) {
                e eVar2 = e.this;
                eVar2.locationCodes = eVar2.defaultLocationCodes;
            }
            if (e.this.l()) {
                e.this.o();
            }
            if (!Intrinsics.areEqual("-1", e.this.locationCodes[0])) {
                e.this.locationCodes[3] = "0";
                e.this.searchManager.U(e.this.locationCodes);
            }
            QLog.d("AddContactLocationDelegate", 1, "onGetUserLocation|isSuccess : " + isSuccess + ", autoReqLocation : " + e.this.l() + ", locationCodes[0] : " + e.this.locationCodes[0]);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49774);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull QQAppInterface app, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app, (Object) activity);
            return;
        }
        this.app = app;
        this.activity = activity;
        String[] strArr = {"-1", "-1", "-1", "-1"};
        this.defaultLocationCodes = strArr;
        this.locationCodes = strArr;
        Manager manager = app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.ConditionSearchManager");
        this.searchManager = (ConditionSearchManager) manager;
        this.configListener = new ConditionSearchManager.c() { // from class: com.tencent.mobileqq.activity.contact.addcontact.a
            @Override // com.tencent.mobileqq.app.ConditionSearchManager.c
            public final void onGetConfig(int i3, boolean z16) {
                e.j(e.this, i3, z16);
            }
        };
        this.mLocationCanCelListener = new ConditionSearchManager.d() { // from class: com.tencent.mobileqq.activity.contact.addcontact.b
            @Override // com.tencent.mobileqq.app.ConditionSearchManager.d
            public final void a() {
                e.n(e.this);
            }
        };
        this.conditionsPrefix = HardCodeUtil.qqStr(R.string.j3f);
        this.lbsObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(e this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("AddContactLocationDelegate", 2, "onGetConfig | isSuccess = " + z16 + ", resultCode = " + i3);
        }
        if (i3 == 2 && z16) {
            this$0.isConfigReady = true;
            this$0.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.autoReqLocation = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(final e this$0, final StringBuilder sb5) {
        boolean startsWith$default;
        boolean startsWith$default2;
        List emptyList;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sb5, "$sb");
        int D = this$0.searchManager.D();
        if (QLog.isColorLevel()) {
            QLog.d("AddContactLocationDelegate", 2, "fillSearchConditions | sexIndex = " + D);
        }
        if (D != 0) {
            String[] strArr = ConditionSearchManager.f194485m0;
            if (D < strArr.length) {
                sb5.append(strArr[D]);
                sb5.append("\u3001");
            }
        }
        int[] q16 = this$0.searchManager.q();
        String r16 = this$0.searchManager.r(q16[0], q16[1]);
        if (!Intrinsics.areEqual(ConditionSearchManager.f194486n0[0], r16)) {
            sb5.append(r16);
            sb5.append("\u3001");
        }
        int A = this$0.searchManager.A();
        if (A != 0 && A != ConditionSearchManager.f194488p0.length - 1) {
            sb5.append(ConditionSearchManager.f194489q0[A]);
            sb5.append("\u3001");
        }
        if (this$0.autoReqLocation) {
            if (this$0.isConfigReady) {
                String[] strArr2 = this$0.locationCodes;
                if (strArr2.length == 4 && Intrinsics.areEqual("-1", strArr2[0])) {
                    Manager manager = this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
                    Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
                    Card r17 = ((FriendsManager) manager).r(this$0.app.getCurrentAccountUin());
                    if (r17 != null) {
                        try {
                            String str = r17.strLocationCodes;
                            Intrinsics.checkNotNullExpressionValue(str, "card.strLocationCodes");
                            List<String> split = new Regex("-").split(str, 0);
                            if (!split.isEmpty()) {
                                ListIterator<String> listIterator = split.listIterator(split.size());
                                while (listIterator.hasPrevious()) {
                                    if (listIterator.previous().length() == 0) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    if (!z16) {
                                        emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                                        break;
                                    }
                                }
                            }
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                            Object[] array = emptyList.toArray(new String[0]);
                            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            this$0.locationCodes = (String[]) array;
                            if (QLog.isColorLevel()) {
                                QLog.d("AddContactLocationDelegate", 2, "card.strLocationCodes = " + r17.strLocationCodes);
                            }
                        } catch (Exception e16) {
                            QLog.e("AddContactLocationDelegate", 1, e16, "splitLocationString");
                        }
                    }
                }
                try {
                    String[] strArr3 = this$0.locationCodes;
                    strArr3[3] = "0";
                    String Q = this$0.searchManager.Q(strArr3);
                    this$0.searchManager.X(this$0.locationCodes);
                    this$0.searchManager.Y(0, Q);
                    if (!Intrinsics.areEqual("0", this$0.locationCodes[0])) {
                        sb5.append(this$0.searchManager.l(Q));
                        sb5.append("\u3001");
                    }
                } catch (Exception e17) {
                    QLog.d("AddContactLocationDelegate", 1, e17, "parseLocationDesc");
                }
            }
        } else {
            String desc = this$0.searchManager.C(0);
            Intrinsics.checkNotNullExpressionValue(desc, "desc");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(desc, IProfileCardConst.NAME_NO_LIMIT, false, 2, null);
            if (!startsWith$default) {
                sb5.append(this$0.searchManager.l(desc));
                sb5.append("\u3001");
            }
        }
        String desc2 = this$0.searchManager.C(1);
        Intrinsics.checkNotNullExpressionValue(desc2, "desc");
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(desc2, IProfileCardConst.NAME_NO_LIMIT, false, 2, null);
        if (!startsWith$default2) {
            sb5.append(this$0.searchManager.l(desc2));
            sb5.append("\u3001");
        }
        int E = this$0.searchManager.E();
        if (E != 0) {
            sb5.append(ConditionSearchManager.f194487o0[E]);
            sb5.append("\u3001");
        }
        this$0.searchManager.K();
        this$0.app.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.addcontact.d
            @Override // java.lang.Runnable
            public final void run() {
                e.q(sb5, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(StringBuilder sb5, e this$0) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(sb5, "$sb");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(sb6, "\u3001", false, 2, null);
        if (endsWith$default) {
            sb6 = sb6.substring(0, sb6.length() - 1);
            Intrinsics.checkNotNullExpressionValue(sb6, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        Function1<? super String, Unit> function1 = this$0.onConditionChangedListener;
        if (function1 != null) {
            function1.invoke(sb6);
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.searchManager.h(this);
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.searchManager.o(this);
        this.searchManager.S(this.configListener);
        this.searchManager.d0(null);
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.autoReqLocation;
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.autoReqLocation = this.searchManager.e0();
        String[] B = this.searchManager.B();
        if (QLog.isColorLevel()) {
            QLog.d("AddContactLocationDelegate", 2, "initSearchConditions|autoReqLocation = " + this.autoReqLocation + ", locCode[0] = " + B[0]);
        }
        if (this.autoReqLocation || Intrinsics.areEqual("0", B[0])) {
            if (!com.tencent.mobileqq.dating.f.f(this.activity) && NetworkUtil.isNetSupport(this.activity)) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddContactLocationDelegate", 2, "initSearchConditions|getUserCurrentLocation execute : yes");
                }
            } else {
                this.locationCodes = this.defaultLocationCodes;
                if (QLog.isColorLevel()) {
                    QLog.d("AddContactLocationDelegate", 2, "initSearchConditions|getUserCurrentLocation execute : no");
                }
            }
            if (this.autoReqLocation) {
                this.searchManager.g(this.configListener);
                this.searchManager.d0(this.mLocationCanCelListener);
            }
        }
    }

    public final void o() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            boolean z16 = this.autoReqLocation;
            Object[] objArr = this.locationCodes;
            if (objArr.length == 4) {
                i3 = objArr[0];
            } else {
                i3 = -1000;
            }
            QLog.d("AddContactLocationDelegate", 2, "fillSearchConditions | autoReqLocation = " + z16 + " | code one = " + i3);
        }
        final StringBuilder sb5 = new StringBuilder(this.conditionsPrefix);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.addcontact.c
            @Override // java.lang.Runnable
            public final void run() {
                e.p(e.this, sb5);
            }
        }, 128, null, true);
    }
}
