package l64;

import android.text.Spanned;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mvi.base.route.k;
import com.tencent.robot.slash.input.InputRobotMsgIntent;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l64.a;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u0004\u0018\u00010\u0002*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J(\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J0\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016\u00a8\u0006\u001f"}, d2 = {"Ll64/c;", "Lcom/tencent/mobileqq/aio/input/dialog/a;", "Lcom/tencent/qqnt/aio/at/c;", "atSpan", "", h.F, "Landroid/text/Spanned;", "", "start", "end", "i", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "c", "", "", "g", "spannedChars", "selectionStart", "lineCount", "a", "e", "traceId", "", "b", "d", "f", "", "getTag", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements com.tencent.mobileqq.aio.input.dialog.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f413897a = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Ll64/c$a;", "", "", "CHAR_SPACE", BdhLogUtil.LogTag.Tag_Conn, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class b<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Spanned f413898d;

        public b(Spanned spanned) {
            this.f413898d = spanned;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(this.f413898d.getSpanStart((com.tencent.qqnt.aio.at.c) t16)), Integer.valueOf(this.f413898d.getSpanStart((com.tencent.qqnt.aio.at.c) t17)));
            return compareValues;
        }
    }

    private final boolean h(com.tencent.qqnt.aio.at.c atSpan) {
        AppRuntime peekAppRuntime;
        ITroopRobotService iTroopRobotService;
        String k3 = atSpan.k();
        if (k3 == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (iTroopRobotService = (ITroopRobotService) peekAppRuntime.getRuntimeService(ITroopRobotService.class, "")) == null) {
            return false;
        }
        return iTroopRobotService.isRobotUin(k3);
    }

    private final com.tencent.qqnt.aio.at.c i(Spanned spanned, int i3, int i16) {
        Object lastOrNull;
        com.tencent.qqnt.aio.at.c[] cVarArr = (com.tencent.qqnt.aio.at.c[]) spanned.getSpans(i3, i16, com.tencent.qqnt.aio.at.c.class);
        if (cVarArr != null) {
            if (cVarArr.length > 1) {
                ArraysKt___ArraysJvmKt.sortWith(cVarArr, new b(spanned));
            }
            lastOrNull = ArraysKt___ArraysKt.lastOrNull(cVarArr);
            return (com.tencent.qqnt.aio.at.c) lastOrNull;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
    
        r2 = kotlin.text.StringsKt___StringsKt.getOrNull(r2, r2.getSpanEnd(r3));
     */
    @Override // com.tencent.mobileqq.aio.input.dialog.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount) {
        Character orNull;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(spannedChars, "spannedChars");
        com.tencent.qqnt.aio.at.c i3 = i(spannedChars, 0, selectionStart);
        if (i3 == null || orNull == null || orNull.charValue() != ' ' || !h(i3)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public void b(int traceId, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(spannedChars, "spannedChars");
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public boolean c(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        a.DialogIsShowingResult dialogIsShowingResult;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        k k3 = aioContext.e().k(InputRobotMsgIntent.GetDialogIsShowing.f368515d);
        if (k3 instanceof a.DialogIsShowingResult) {
            dialogIsShowingResult = (a.DialogIsShowingResult) k3;
        } else {
            dialogIsShowingResult = null;
        }
        if (dialogIsShowingResult != null) {
            return dialogIsShowingResult.getIsShowing();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public void d(int traceId, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public boolean e(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount) {
        a.OnTextChangedProcessResult onTextChangedProcessResult;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(spannedChars, "spannedChars");
        k k3 = aioContext.e().k(new InputRobotMsgIntent.OnTextChangedForRobotAtDialog(spannedChars, selectionStart, lineCount));
        if (k3 instanceof a.OnTextChangedProcessResult) {
            onTextChangedProcessResult = (a.OnTextChangedProcessResult) k3;
        } else {
            onTextChangedProcessResult = null;
        }
        if (onTextChangedProcessResult != null) {
            return onTextChangedProcessResult.getHandled();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public boolean f() {
        return false;
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    @NotNull
    public List<Character> g() {
        List<Character> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    @NotNull
    public String getTag() {
        return "RobotAtDialogPriorityProcessor";
    }
}
