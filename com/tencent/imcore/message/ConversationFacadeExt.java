package com.tencent.imcore.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\b\u0005H\u0002J\f\u0010\b\u001a\u00020\u0002*\u00020\u0002H\u0002Jd\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t*\u00020\u00022\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0003\u00a2\u0006\u0002\b\u00052\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0002\b\u00052\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0002\b\u0005H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012J\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017J.\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\t2\u0006\u0010\u001a\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/imcore/message/ConversationFacadeExt;", "", "Lcom/tencent/imcore/message/k;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "extPublicNot", "c", "e", "T", "", "toggle", "opt", "orNot", "f", "(Lcom/tencent/imcore/message/k;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "sql", "Lkotlin/Function0;", "", "default", tl.h.F, "boxUin", "", "boxType", "b", ReportPlugin.KEY_TABLE_NAME, "g", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class ConversationFacadeExt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ConversationFacadeExt f116416a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f116416a = new ConversationFacadeExt();
        }
    }

    ConversationFacadeExt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ k d(ConversationFacadeExt conversationFacadeExt, k kVar, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = null;
        }
        return conversationFacadeExt.c(kVar, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k e(k kVar) {
        kVar.a().add("mr_friend_9F5506939986201D55A4353FF8B4028E_New");
        kVar.a().add("mr_friend_6E6368199AFF7B29A8615BF5B4979690_New");
        kVar.a().add("mr_friend_B14E26D58C66A9DB9F56ED1762407D12_New");
        kVar.a().add("mr_friend_C1609C4554914CCA6D334FD447F96681_New");
        kVar.a().add("mr_friend_370EFDBCCCFB374F6600754BB1AE926B_New");
        kVar.a().add("mr_friend_71886DF96D327BA3FD8C016BFA563AFC_New");
        kVar.a().add("mr_friend_BBBCA2C74347FFE57DBAFDBABFCB5DF0_New");
        kVar.a().add("mr_friend_0A4DC6DAE338C9CB08947C07581F77A2_New");
        kVar.a().add("mr_friend_CB982CFDA7C808078F3EEE9C107E3C90_New");
        kVar.a().add("mr_friend_12231090FEF0AF8242E6B7782D382F99_New");
        kVar.a().add("mr_friend_ADE1D98C5AB2997E867B1151A5C5028D_New");
        kVar.a().add("mr_friend_115C343463041F8763D7552FDCE43C9F_New");
        kVar.a().add("mr_friend_356DC40642ABEB3A437E7E06F178701C_New");
        kVar.a().add("mr_friend_CF4E0E4809A5767626136C8275F0E1AF_New");
        kVar.a().add("mr_friend_956AFC9CE4E24B57780C1604C8F616F9_New");
        kVar.a().add("mr_friend_CDF6581CB7ACA4B7E19EF136C6E601A5_New");
        kVar.a().add("mr_friend_47F9CB68B0D296B7E25134900E7FC003_New");
        kVar.a().add("mr_friend_0FBE62E4F1BB514B6C2E38EEE272E460_New");
        kVar.a().add("mr_friend_B9B04951F52507D67BA4D4737124E338_New");
        kVar.a().add("mr_friend_FAA22C3A135BBBCB33F5DC76F2733AD2_New");
        kVar.a().add("mr_friend_0E999D31B23F3F89049B91CC014296C8_New");
        return kVar;
    }

    private final <T> T f(k kVar, Function1<? super k, Boolean> function1, Function1<? super k, ? extends T> function12, Function1<? super k, ? extends T> function13) {
        if (function1.invoke(kVar).booleanValue()) {
            return function12.invoke(kVar);
        }
        return function13.invoke(kVar);
    }

    public final boolean b(@NotNull final String boxUin, final int boxType) {
        k d16;
        k f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) boxUin, boxType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(boxUin, "boxUin");
        d16 = ConversationFacadeExtKt.d();
        f16 = ConversationFacadeExtKt.f(d(this, d16, null, 1, null), new Function1<k, String>(boxUin, boxType) { // from class: com.tencent.imcore.message.ConversationFacadeExt$canCalculateMsgBoxUnreadCount$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $boxType;
            final /* synthetic */ String $boxUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$boxUin = boxUin;
                this.$boxType = boxType;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) boxUin, boxType);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull k wrapLog) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) wrapLog);
                }
                Intrinsics.checkNotNullParameter(wrapLog, "$this$wrapLog");
                return "canCalculateMsgBoxUnreadCount boxUin:" + this.$boxUin + " boxType:" + this.$boxType;
            }
        });
        return f16.e();
    }

    @NotNull
    public final <T> List<T> g(@NotNull final String tableName, @NotNull final Function0<? extends List<? extends T>> r56) {
        k e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) tableName, (Object) r56);
        }
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(r56, "default");
        e16 = ConversationFacadeExtKt.e();
        return (List) f(c(e16, ConversationFacadeExt$wrapRawQuery$1.INSTANCE), new Function1<k, Boolean>(tableName) { // from class: com.tencent.imcore.message.ConversationFacadeExt$wrapRawQuery$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $tableName;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$tableName = tableName;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) tableName);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull k wrapCondition) {
                boolean startsWith$default;
                boolean startsWith$default2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) wrapCondition);
                }
                Intrinsics.checkNotNullParameter(wrapCondition, "$this$wrapCondition");
                if (wrapCondition.c()) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(this.$tableName, "mr_troop", false, 2, null);
                    if (startsWith$default2) {
                        return Boolean.TRUE;
                    }
                }
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.$tableName, "mr_friend", false, 2, null);
                return !startsWith$default ? Boolean.FALSE : wrapCondition.a().contains(this.$tableName) ? Boolean.TRUE : Boolean.FALSE;
            }
        }, new Function1<k, List<? extends T>>(tableName) { // from class: com.tencent.imcore.message.ConversationFacadeExt$wrapRawQuery$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $tableName;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$tableName = tableName;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) tableName);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<T> invoke(@NotNull k wrapCondition) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (List) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) wrapCondition);
                }
                Intrinsics.checkNotNullParameter(wrapCondition, "$this$wrapCondition");
                ArrayList arrayList = new ArrayList();
                QLog.d("ConversationFacadeExt", 1, "\u62e6\u622a " + this.$tableName);
                return arrayList;
            }
        }, new Function1<k, List<? extends T>>(r56) { // from class: com.tencent.imcore.message.ConversationFacadeExt$wrapRawQuery$4
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0<List<T>> $default;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$default = r56;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) r56);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<T> invoke(@NotNull k wrapCondition) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (List) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) wrapCondition);
                }
                Intrinsics.checkNotNullParameter(wrapCondition, "$this$wrapCondition");
                return this.$default.invoke();
            }
        });
    }

    @NotNull
    public final <T> List<T> h(@NotNull final String sql, @NotNull final Function0<? extends List<? extends T>> r56) {
        k e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sql, (Object) r56);
        }
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(r56, "default");
        e16 = ConversationFacadeExtKt.e();
        return (List) f(c(e16, ConversationFacadeExt$wrapRawQuerybySql$1.INSTANCE), new Function1<k, Boolean>(sql) { // from class: com.tencent.imcore.message.ConversationFacadeExt$wrapRawQuerybySql$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $sql;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$sql = sql;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) sql);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull k wrapCondition) {
                boolean contains$default;
                boolean contains$default2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) wrapCondition);
                }
                Intrinsics.checkNotNullParameter(wrapCondition, "$this$wrapCondition");
                Object obj = null;
                boolean z16 = false;
                if (wrapCondition.c()) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) this.$sql, (CharSequence) "mr_troop", false, 2, (Object) null);
                    if (contains$default2) {
                        return Boolean.TRUE;
                    }
                }
                Set<String> a16 = wrapCondition.a();
                String str = this.$sql;
                Iterator<T> it = a16.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) next, false, 2, (Object) null);
                    if (contains$default) {
                        obj = next;
                        break;
                    }
                }
                String str2 = (String) obj;
                if (str2 != null) {
                    if (str2.length() > 0) {
                        z16 = true;
                    }
                }
                if (z16) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        }, new Function1<k, List<? extends T>>(sql) { // from class: com.tencent.imcore.message.ConversationFacadeExt$wrapRawQuerybySql$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $sql;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$sql = sql;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) sql);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<T> invoke(@NotNull k wrapCondition) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (List) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) wrapCondition);
                }
                Intrinsics.checkNotNullParameter(wrapCondition, "$this$wrapCondition");
                ArrayList arrayList = new ArrayList();
                QLog.d("ConversationFacadeExt", 1, "\u62e6\u622a " + this.$sql);
                return arrayList;
            }
        }, new Function1<k, List<? extends T>>(r56) { // from class: com.tencent.imcore.message.ConversationFacadeExt$wrapRawQuerybySql$4
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0<List<T>> $default;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$default = r56;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) r56);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<T> invoke(@NotNull k wrapCondition) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (List) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) wrapCondition);
                }
                Intrinsics.checkNotNullParameter(wrapCondition, "$this$wrapCondition");
                return this.$default.invoke();
            }
        });
    }

    private final k c(k kVar, Function1<? super k, Unit> function1) {
        return kVar;
    }
}
