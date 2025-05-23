package com.tencent.mobileqq.troop.selectmember.inject;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.report.TroopFeatureReport;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 !2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J8\u0010\u000f\u001a2\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u00020\u000e0\f0\u0002j\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u00020\u000e0\f`\u0004H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R+\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010#\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b!\u0010\"RK\u0010%\u001a2\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u00020\u000e0\f0\u0002j\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u00020\u000e0\f`\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b$\u0010\u0019R\u001d\u0010(\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/inject/TroopSelectMemberInjectProvider;", "Lcom/tencent/mobileqq/troop/selectmember/inject/b;", "Ljava/util/ArrayList;", "Lcom/tencent/biz/richframework/part/Part;", "Lkotlin/collections/ArrayList;", "d", "Lcom/tencent/mobileqq/troop/selectmember/inject/d;", "c", "Lcom/tencent/mobileqq/troop/selectmember/inject/e;", "f", "Lcom/tencent/mobileqq/troop/selectmember/inject/a;", "a", "Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate;", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "e", "Lcom/tencent/mobileqq/troop/selectmember/inject/c;", "b", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "launchConfig", "Lkotlin/Lazy;", "g", "()Ljava/util/ArrayList;", "innerBusinessParts", "k", "()Lcom/tencent/mobileqq/troop/selectmember/inject/d;", "innerTitleHandler", "l", "()Lcom/tencent/mobileqq/troop/selectmember/inject/e;", "innerTitleRightClickHandler", h.F, "()Lcom/tencent/mobileqq/troop/selectmember/inject/a;", "innerGroupAndSortHandler", "j", "innerItemExtDelegates", "i", "()Lcom/tencent/mobileqq/troop/selectmember/inject/c;", "innerItemClickHandler", "<init>", "(Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSelectMemberInjectProvider implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopSelectMemberConfig launchConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy innerBusinessParts;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy innerTitleHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy innerTitleRightClickHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy innerGroupAndSortHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy innerItemExtDelegates;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy innerItemClickHandler;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/inject/TroopSelectMemberInjectProvider$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.inject.TroopSelectMemberInjectProvider$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSelectMemberInjectProvider(@NotNull TroopSelectMemberConfig launchConfig) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(launchConfig, "launchConfig");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) launchConfig);
            return;
        }
        this.launchConfig = launchConfig;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<Part>>() { // from class: com.tencent.mobileqq.troop.selectmember.inject.TroopSelectMemberInjectProvider$innerBusinessParts$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberInjectProvider.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<Part> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<Part> arrayList = new ArrayList<>();
                String[] f16 = com.tencent.mobileqq.troop.selectmember.config.a.f(TroopSelectMemberInjectProvider.this.m());
                for (String str : f16) {
                    if (str != null) {
                        try {
                            Object newInstance = Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
                            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.biz.richframework.part.Part");
                            arrayList.add((Part) newInstance);
                        } catch (Exception e16) {
                            TroopFeatureReport.f361921a.f("innerBusinessParts error");
                            QLog.e("TroopSelectMemberInjectProvider", 1, "[innerBusinessParts] exception", e16);
                        }
                    }
                }
                if (QLog.isDebugVersion()) {
                    QLog.d("TroopSelectMemberInjectProvider", 4, "[innerBusinessParts] timeCost:" + (System.currentTimeMillis() - currentTimeMillis) + ", size:" + f16.length);
                }
                return arrayList;
            }
        });
        this.innerBusinessParts = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.mobileqq.troop.selectmember.inject.TroopSelectMemberInjectProvider$innerTitleHandler$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberInjectProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final d invoke() {
                long currentTimeMillis;
                StringBuilder sb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (d) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                String g16 = com.tencent.mobileqq.troop.selectmember.config.a.g(TroopSelectMemberInjectProvider.this.m());
                if (g16 != null) {
                    try {
                        try {
                            Object newInstance = Class.forName(g16).getConstructor(new Class[0]).newInstance(new Object[0]);
                            r5 = newInstance instanceof d ? (d) newInstance : null;
                        } catch (Exception e16) {
                            QLog.e("TroopSelectMemberInjectProvider", 1, "[innerTitleHandlers] exception", e16);
                            TroopFeatureReport.f361921a.f("innerTitleHandlers error");
                            if (QLog.isDebugVersion()) {
                                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                                sb5 = new StringBuilder();
                            }
                        }
                        if (QLog.isDebugVersion()) {
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                            sb5 = new StringBuilder();
                            sb5.append("[innerTitleHandlers] timeCost:");
                            sb5.append(currentTimeMillis);
                            QLog.d("TroopSelectMemberInjectProvider", 4, sb5.toString());
                        }
                    } catch (Throwable th5) {
                        if (QLog.isDebugVersion()) {
                            QLog.d("TroopSelectMemberInjectProvider", 4, "[innerTitleHandlers] timeCost:" + (System.currentTimeMillis() - currentTimeMillis2));
                        }
                        throw th5;
                    }
                }
                return r5;
            }
        });
        this.innerTitleHandler = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.troop.selectmember.inject.TroopSelectMemberInjectProvider$innerTitleRightClickHandler$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberInjectProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final e invoke() {
                long currentTimeMillis;
                StringBuilder sb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                String h16 = com.tencent.mobileqq.troop.selectmember.config.a.h(TroopSelectMemberInjectProvider.this.m());
                if (h16 != null) {
                    try {
                        try {
                            Object newInstance = Class.forName(h16).getConstructor(new Class[0]).newInstance(new Object[0]);
                            r5 = newInstance instanceof e ? (e) newInstance : null;
                        } catch (Exception e16) {
                            QLog.e("TroopSelectMemberInjectProvider", 1, "[innerTitleRightClickHandler] exception", e16);
                            TroopFeatureReport.f361921a.f("innerTitleRightClickHandler error");
                            if (QLog.isDebugVersion()) {
                                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                                sb5 = new StringBuilder();
                            }
                        }
                        if (QLog.isDebugVersion()) {
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                            sb5 = new StringBuilder();
                            sb5.append("[innerTitleRightClickHandler] timeCost:");
                            sb5.append(currentTimeMillis);
                            QLog.d("TroopSelectMemberInjectProvider", 4, sb5.toString());
                        }
                    } catch (Throwable th5) {
                        if (QLog.isDebugVersion()) {
                            QLog.d("TroopSelectMemberInjectProvider", 4, "[innerTitleRightClickHandler] timeCost:" + (System.currentTimeMillis() - currentTimeMillis2));
                        }
                        throw th5;
                    }
                }
                return r5;
            }
        });
        this.innerTitleRightClickHandler = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.troop.selectmember.inject.TroopSelectMemberInjectProvider$innerGroupAndSortHandler$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberInjectProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final a invoke() {
                long currentTimeMillis;
                StringBuilder sb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                String c16 = com.tencent.mobileqq.troop.selectmember.config.a.c(TroopSelectMemberInjectProvider.this.m());
                if (c16 != null) {
                    try {
                        try {
                            Object newInstance = Class.forName(c16).getConstructor(new Class[0]).newInstance(new Object[0]);
                            r5 = newInstance instanceof a ? (a) newInstance : null;
                        } catch (Exception e16) {
                            QLog.e("TroopSelectMemberInjectProvider", 1, "[innerGroupAndSortHandler] exception", e16);
                            TroopFeatureReport.f361921a.f("innerGroupAndSortHandler error");
                            if (QLog.isDebugVersion()) {
                                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                                sb5 = new StringBuilder();
                            }
                        }
                        if (QLog.isDebugVersion()) {
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                            sb5 = new StringBuilder();
                            sb5.append("[innerGroupAndSortHandler] timeCost:");
                            sb5.append(currentTimeMillis);
                            QLog.d("TroopSelectMemberInjectProvider", 4, sb5.toString());
                        }
                    } catch (Throwable th5) {
                        if (QLog.isDebugVersion()) {
                            QLog.d("TroopSelectMemberInjectProvider", 4, "[innerGroupAndSortHandler] timeCost:" + (System.currentTimeMillis() - currentTimeMillis2));
                        }
                        throw th5;
                    }
                }
                return r5;
            }
        });
        this.innerGroupAndSortHandler = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<AbsTroopSelectMemberDelegate<? extends com.tencent.mobileqq.troop.selectmember.bean.a, ? extends RecyclerView.ViewHolder>>>() { // from class: com.tencent.mobileqq.troop.selectmember.inject.TroopSelectMemberInjectProvider$innerItemExtDelegates$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberInjectProvider.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<AbsTroopSelectMemberDelegate<? extends com.tencent.mobileqq.troop.selectmember.bean.a, ? extends RecyclerView.ViewHolder>> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<AbsTroopSelectMemberDelegate<? extends com.tencent.mobileqq.troop.selectmember.bean.a, ? extends RecyclerView.ViewHolder>> arrayList = new ArrayList<>();
                String[] e16 = com.tencent.mobileqq.troop.selectmember.config.a.e(TroopSelectMemberInjectProvider.this.m());
                for (String str : e16) {
                    if (str != null) {
                        try {
                            Object newInstance = Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
                            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate<out com.tencent.mobileqq.troop.selectmember.bean.ITroopSelectMemberBean, out androidx.recyclerview.widget.RecyclerView.ViewHolder>");
                            arrayList.add((AbsTroopSelectMemberDelegate) newInstance);
                        } catch (Exception e17) {
                            QLog.e("TroopSelectMemberInjectProvider", 1, "[innerItemExtDelegates] exception", e17);
                            TroopFeatureReport.f361921a.f("innerItemExtDelegates error");
                        }
                    }
                }
                if (QLog.isDebugVersion()) {
                    QLog.d("TroopSelectMemberInjectProvider", 4, "[innerItemExtDelegates] timeCost:" + (System.currentTimeMillis() - currentTimeMillis) + ", size:" + e16.length);
                }
                return arrayList;
            }
        });
        this.innerItemExtDelegates = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.troop.selectmember.inject.TroopSelectMemberInjectProvider$innerItemClickHandler$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberInjectProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final c invoke() {
                long currentTimeMillis;
                StringBuilder sb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                String d16 = com.tencent.mobileqq.troop.selectmember.config.a.d(TroopSelectMemberInjectProvider.this.m());
                if (d16 != null) {
                    try {
                        try {
                            Object newInstance = Class.forName(d16).getConstructor(new Class[0]).newInstance(new Object[0]);
                            r5 = newInstance instanceof c ? (c) newInstance : null;
                        } catch (Exception e16) {
                            QLog.e("TroopSelectMemberInjectProvider", 1, "[innerItemExtDelegates] exception", e16);
                            TroopFeatureReport.f361921a.f("innerItemExtDelegates error");
                            if (QLog.isDebugVersion()) {
                                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                                sb5 = new StringBuilder();
                            }
                        }
                        if (QLog.isDebugVersion()) {
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                            sb5 = new StringBuilder();
                            sb5.append("[innerItemExtDelegates] timeCost:");
                            sb5.append(currentTimeMillis);
                            QLog.d("TroopSelectMemberInjectProvider", 4, sb5.toString());
                        }
                    } catch (Throwable th5) {
                        if (QLog.isDebugVersion()) {
                            QLog.d("TroopSelectMemberInjectProvider", 4, "[innerItemExtDelegates] timeCost:" + (System.currentTimeMillis() - currentTimeMillis2));
                        }
                        throw th5;
                    }
                }
                return r5;
            }
        });
        this.innerItemClickHandler = lazy6;
    }

    private final ArrayList<Part> g() {
        return (ArrayList) this.innerBusinessParts.getValue();
    }

    private final a h() {
        return (a) this.innerGroupAndSortHandler.getValue();
    }

    private final c i() {
        return (c) this.innerItemClickHandler.getValue();
    }

    private final ArrayList<AbsTroopSelectMemberDelegate<? extends com.tencent.mobileqq.troop.selectmember.bean.a, ? extends RecyclerView.ViewHolder>> j() {
        return (ArrayList) this.innerItemExtDelegates.getValue();
    }

    private final d k() {
        return (d) this.innerTitleHandler.getValue();
    }

    private final e l() {
        return (e) this.innerTitleRightClickHandler.getValue();
    }

    @Override // com.tencent.mobileqq.troop.selectmember.inject.b
    @Nullable
    public a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return h();
    }

    @Override // com.tencent.mobileqq.troop.selectmember.inject.b
    @Nullable
    public c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return i();
    }

    @Override // com.tencent.mobileqq.troop.selectmember.inject.b
    @Nullable
    public d c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return k();
    }

    @Override // com.tencent.mobileqq.troop.selectmember.inject.b
    @NotNull
    public ArrayList<Part> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return g();
    }

    @Override // com.tencent.mobileqq.troop.selectmember.inject.b
    @NotNull
    public ArrayList<AbsTroopSelectMemberDelegate<? extends com.tencent.mobileqq.troop.selectmember.bean.a, ? extends RecyclerView.ViewHolder>> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return j();
    }

    @Override // com.tencent.mobileqq.troop.selectmember.inject.b
    @Nullable
    public e f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (e) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return l();
    }

    @NotNull
    public final TroopSelectMemberConfig m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopSelectMemberConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.launchConfig;
    }
}
