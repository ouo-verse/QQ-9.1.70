package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00060\u0001j\u0002`\u0002:\u0001\u001aB\u0013\u0012\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007H\u0016J\u0006\u0010\n\u001a\u00020\u0003J\b\u0010\u000b\u001a\u00020\u0003H\u0016R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/PicButtonActor;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputActor;", "", "i", "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "e", "k", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;", "getCallback", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;", "l", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;)V", "callback", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputAttachInfo;", "attachInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PicButtonActor extends NativeDetailInputWindowDirector.a {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f220489h = new a(null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b callback;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/PicButtonActor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicButtonActor(@NotNull NativeDetailInputWindowDirector.b attachInfo) {
        super(attachInfo);
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
    }

    private final void i() {
        Runnable onOtherPageOpen = b().X().getOnOtherPageOpen();
        if (onOtherPageOpen != null) {
            onOtherPageOpen.run();
        }
        b().W();
        xk1.d.b0(b(), "PicButtonActor", 0, 0, 6, null);
        Bundle bundle = new Bundle();
        bundle.putString("key_for_album_guild_id", getAttachInfo().e());
        bundle.putString("key_for_album_channel_id", getAttachInfo().b());
        Context context = b().getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.view.ContextThemeWrapper");
        Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
        Intrinsics.checkNotNull(baseContext, "null cannot be cast to non-null type android.app.Activity");
        final Activity activity = (Activity) baseContext;
        GuildFeedLauncher.g(activity, bundle, 1, 0, 0, true, true, true, new GuildFeedLauncher.b() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.l
            @Override // com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher.b
            public final void a(Intent intent) {
                PicButtonActor.j(PicButtonActor.this, activity, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(PicButtonActor this$0, Activity activity, Intent it) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b bVar = this$0.callback;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            z16 = bVar.a(it);
        } else {
            z16 = false;
        }
        if (!z16) {
            activity.startActivityForResult(it, 10014);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void e(@NotNull final xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        super.e(inputWindow);
        jt1.b.b(inputWindow.X().v().getPicButton(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.PicButtonActor$onInputWindowInitialized$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                PicButtonActor.this.k();
                gl1.b bVar = (gl1.b) inputWindow.getRouter().b(gl1.b.class);
                if (bVar != null) {
                    bVar.c(it);
                }
            }
        });
        ho1.b.a(true, inputWindow.X().v().getPicButton());
    }

    public final void k() {
        i();
    }

    public final void l(@Nullable com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b bVar) {
        this.callback = bVar;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void onDestroy() {
    }
}
