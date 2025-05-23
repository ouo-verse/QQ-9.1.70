package cm4;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcm4/a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "toUin", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "toQQId", "Lcm4/a$a;", "listener", "", "a", "b", "Ljava/lang/String;", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f31102a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "AioChatTokenUtil";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\t"}, d2 = {"Lcm4/a$a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "token", "", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cm4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0205a {
        void a(@Nullable QBaseActivity activity);

        void b(@Nullable QBaseActivity activity, @NotNull byte[] token);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"cm4/a$b", "Lcom/tencent/timi/game/utils/IResultListener;", "", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<byte[]> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0205a f31104a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference<QBaseActivity> f31105b;

        b(InterfaceC0205a interfaceC0205a, WeakReference<QBaseActivity> weakReference) {
            this.f31104a = interfaceC0205a;
            this.f31105b = weakReference;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable byte[] result) {
            if (result != null) {
                this.f31104a.b(this.f31105b.get(), result);
            } else {
                this.f31104a.a(this.f31105b.get());
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            this.f31104a.a(this.f31105b.get());
        }
    }

    a() {
    }

    public final void a(@NotNull QBaseActivity activity, @NotNull String toUin, @NotNull CommonOuterClass$QQUserId toQQId, @NotNull InterfaceC0205a listener) {
        Long longOrNull;
        long j3;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(toUin, "toUin");
        Intrinsics.checkNotNullParameter(toQQId, "toQQId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        l.b(TAG, "acquireTkoen start");
        WeakReference weakReference = new WeakReference(activity);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(toUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        long h16 = ((ll4.a) mm4.b.b(ll4.a.class)).h();
        CommonOuterClass$QQUserId myQQId = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        dm4.c cVar = dm4.c.f394282a;
        Intrinsics.checkNotNullExpressionValue(myQQId, "myQQId");
        cVar.a(h16, j3, myQQId, toQQId, new b(listener, weakReference));
    }
}
