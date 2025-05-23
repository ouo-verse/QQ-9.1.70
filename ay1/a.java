package ay1;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lay1/a;", "", "Landroid/content/Context;", "context", "", "guildId", "channelId", "", "b", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelList", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f27301a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialogInner", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: ay1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    static final class DialogInterfaceOnClickListenerC0078a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f27302d;

        /* JADX WARN: Multi-variable type inference failed */
        DialogInterfaceOnClickListenerC0078a(Continuation<? super Boolean> continuation) {
            this.f27302d = continuation;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            Continuation<Boolean> continuation = this.f27302d;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialogInner", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f27303d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super Boolean> continuation) {
            this.f27303d = continuation;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            Continuation<Boolean> continuation = this.f27303d;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }
    }

    a() {
    }

    private final String a(List<? extends IGProChannelInfo> channelList) {
        String str;
        String channelName = channelList.get(0).getChannelName();
        String str2 = "\u7b49";
        if (channelName.length() > 6) {
            CharSequence subSequence = channelName.subSequence(0, 5);
            if (channelList.size() <= 1) {
                str2 = "";
            }
            str = "\u201c" + ((Object) subSequence) + "...\u201d" + str2;
        } else {
            if (channelList.size() <= 1) {
                str2 = "";
            }
            str = "\u201c" + channelName + "\u201d" + str2;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(R.string.f1518818w);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_pri\u2026nel_invalid_jump_channel)");
        String format = String.format(qqStr, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @JvmStatic
    @Nullable
    public static final Object b(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        boolean z16;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        List<IGProChannelInfo> sourceChannelList = ((IGPSService) ch.R0(IGPSService.class)).getJumpChannelList(str, str2);
        List<IGProChannelInfo> list = sourceChannelList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(true)));
        } else {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0);
            a aVar = f27301a;
            Intrinsics.checkNotNullExpressionValue(sourceChannelList, "sourceChannelList");
            QQCustomDialog message = createCustomDialog.setMessage(aVar.a(sourceChannelList));
            message.setPositiveButton(HardCodeUtil.qqStr(R.string.f143520ma), new DialogInterfaceOnClickListenerC0078a(safeContinuation));
            message.setNegativeButton(HardCodeUtil.qqStr(R.string.f140850f3), new b(safeContinuation));
            message.show();
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
