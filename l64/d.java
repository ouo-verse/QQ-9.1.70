package l64;

import android.text.Spanned;
import com.tencent.mvi.base.route.k;
import com.tencent.robot.slash.input.InputSlashMsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import l64.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J0\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016\u00a8\u0006\u0019"}, d2 = {"Ll64/d;", "Lcom/tencent/mobileqq/aio/input/dialog/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "c", "f", "", "", "g", "Landroid/text/Spanned;", "spannedChars", "", "selectionStart", "lineCount", "a", "traceId", "", "b", "d", "e", "", "getTag", "<init>", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements com.tencent.mobileqq.aio.input.dialog.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f413899a = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Ll64/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public boolean a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount) {
        boolean startsWith$default;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(spannedChars, "spannedChars");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(spannedChars.toString(), "/", false, 2, null);
        if (startsWith$default && selectionStart > 0) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) spannedChars.subSequence(0, selectionStart).toString(), (CharSequence) " ", false, 2, (Object) null);
            if (contains$default) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public void b(int traceId, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(spannedChars, "spannedChars");
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public boolean c(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        b.GetSlashDialogIsShowingResult getSlashDialogIsShowingResult;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        k k3 = aioContext.e().k(InputSlashMsgIntent.GetSlashDialogIsSowing.f368521d);
        if (k3 instanceof b.GetSlashDialogIsShowingResult) {
            getSlashDialogIsShowingResult = (b.GetSlashDialogIsShowingResult) k3;
        } else {
            getSlashDialogIsShowingResult = null;
        }
        if (getSlashDialogIsShowingResult != null) {
            return getSlashDialogIsShowingResult.getIsShowing();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public void d(int traceId, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        aioContext.e().h(InputSlashMsgIntent.DismissSlashDialog.f368520d);
    }

    @Override // com.tencent.mobileqq.aio.input.dialog.a
    public boolean e(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(spannedChars, "spannedChars");
        aioContext.e().h(new InputSlashMsgIntent.OnTextChangedForSlashDialog(spannedChars, selectionStart, lineCount));
        return true;
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
        return "SlashDialogPriorityProcessor";
    }
}
