package com.tencent.mobileqq.vas.api;

import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/api/AbsProtocol;", "", "()V", "interceptJce", "Lcom/qq/taf/jce/JceStruct;", "servantName", "", "cmd", "funcName", "req", "onJceCallBack", "", "resp", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "Companion", "JceIntercept", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public abstract class AbsProtocol {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ArrayList<JceIntercept> jceWatcher = new ArrayList<>();
    private static boolean needIntercept;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ2\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/api/AbsProtocol$Companion;", "", "()V", "jceWatcher", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/vas/api/AbsProtocol$JceIntercept;", "Lkotlin/collections/ArrayList;", IGuildSpeechApi.KEY_NEED_INTERCEPT, "", "clearRegister", "", "register", "servantName", "", "cmd", "funcName", "block", "Lkotlin/Function1;", "Lcom/qq/taf/jce/JceStruct;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void clearRegister() {
            AbsProtocol.jceWatcher.clear();
            AbsProtocol.needIntercept = true;
        }

        public final void register(@NotNull String servantName, @NotNull String cmd, @NotNull String funcName, @NotNull Function1<? super JceStruct, ? extends JceStruct> block) {
            Intrinsics.checkNotNullParameter(servantName, "servantName");
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(funcName, "funcName");
            Intrinsics.checkNotNullParameter(block, "block");
            AbsProtocol.jceWatcher.add(new JceIntercept(servantName, cmd, funcName, block));
            AbsProtocol.needIntercept = true;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/AbsProtocol$JceIntercept;", "", "servantName", "", "cmd", "funcName", "block", "Lkotlin/Function1;", "Lcom/qq/taf/jce/JceStruct;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "getCmd", "()Ljava/lang/String;", "getFuncName", "getServantName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final /* data */ class JceIntercept {

        @NotNull
        private final Function1<JceStruct, JceStruct> block;

        @NotNull
        private final String cmd;

        @NotNull
        private final String funcName;

        @NotNull
        private final String servantName;

        /* JADX WARN: Multi-variable type inference failed */
        public JceIntercept(@NotNull String servantName, @NotNull String cmd, @NotNull String funcName, @NotNull Function1<? super JceStruct, ? extends JceStruct> block) {
            Intrinsics.checkNotNullParameter(servantName, "servantName");
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(funcName, "funcName");
            Intrinsics.checkNotNullParameter(block, "block");
            this.servantName = servantName;
            this.cmd = cmd;
            this.funcName = funcName;
            this.block = block;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JceIntercept copy$default(JceIntercept jceIntercept, String str, String str2, String str3, Function1 function1, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = jceIntercept.servantName;
            }
            if ((i3 & 2) != 0) {
                str2 = jceIntercept.cmd;
            }
            if ((i3 & 4) != 0) {
                str3 = jceIntercept.funcName;
            }
            if ((i3 & 8) != 0) {
                function1 = jceIntercept.block;
            }
            return jceIntercept.copy(str, str2, str3, function1);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getServantName() {
            return this.servantName;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getCmd() {
            return this.cmd;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getFuncName() {
            return this.funcName;
        }

        @NotNull
        public final Function1<JceStruct, JceStruct> component4() {
            return this.block;
        }

        @NotNull
        public final JceIntercept copy(@NotNull String servantName, @NotNull String cmd, @NotNull String funcName, @NotNull Function1<? super JceStruct, ? extends JceStruct> block) {
            Intrinsics.checkNotNullParameter(servantName, "servantName");
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(funcName, "funcName");
            Intrinsics.checkNotNullParameter(block, "block");
            return new JceIntercept(servantName, cmd, funcName, block);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JceIntercept)) {
                return false;
            }
            JceIntercept jceIntercept = (JceIntercept) other;
            if (Intrinsics.areEqual(this.servantName, jceIntercept.servantName) && Intrinsics.areEqual(this.cmd, jceIntercept.cmd) && Intrinsics.areEqual(this.funcName, jceIntercept.funcName) && Intrinsics.areEqual(this.block, jceIntercept.block)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final Function1<JceStruct, JceStruct> getBlock() {
            return this.block;
        }

        @NotNull
        public final String getCmd() {
            return this.cmd;
        }

        @NotNull
        public final String getFuncName() {
            return this.funcName;
        }

        @NotNull
        public final String getServantName() {
            return this.servantName;
        }

        public int hashCode() {
            return (((((this.servantName.hashCode() * 31) + this.cmd.hashCode()) * 31) + this.funcName.hashCode()) * 31) + this.block.hashCode();
        }

        @NotNull
        public String toString() {
            return "JceIntercept(servantName=" + this.servantName + ", cmd=" + this.cmd + ", funcName=" + this.funcName + ", block=" + this.block + ")";
        }
    }

    @Nullable
    public final JceStruct interceptJce(@NotNull String servantName, @NotNull String cmd, @NotNull String funcName, @NotNull JceStruct req) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(servantName, "servantName");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(req, "req");
        if (!needIntercept) {
            return null;
        }
        Iterator<T> it = jceWatcher.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                JceIntercept jceIntercept = (JceIntercept) obj;
                if (Intrinsics.areEqual(jceIntercept.getServantName(), servantName) && Intrinsics.areEqual(jceIntercept.getCmd(), cmd) && Intrinsics.areEqual(jceIntercept.getFuncName(), funcName)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        JceIntercept jceIntercept2 = (JceIntercept) obj;
        if (jceIntercept2 == null) {
            return null;
        }
        return jceIntercept2.getBlock().invoke(req);
    }

    public final void onJceCallBack(@NotNull JceStruct resp, @NotNull BusinessObserver observer) {
        Intrinsics.checkNotNullParameter(resp, "resp");
        Intrinsics.checkNotNullParameter(observer, "observer");
        observer.onUpdate(0, true, resp);
    }
}
