package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.text.Editable;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00060\u0001j\u0002`\u0002:\u0001\u001dB\u0013\u0012\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u001a\u0010\r\u001a\u00020\u00062\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH\u0016J\u0006\u0010\u000e\u001a\u00020\u0006R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/SendButtonActor;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputActor;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "", "k", "i", "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "e", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;", "getSendCallback", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;", "l", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;)V", "sendCallback", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputAttachInfo;", "attachInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SendButtonActor extends NativeDetailInputWindowDirector.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b sendCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendButtonActor(@NotNull NativeDetailInputWindowDirector.b attachInfo) {
        super(attachInfo);
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
    }

    private final boolean i() {
        List listOf;
        List emptyList;
        String e16 = getAttachInfo().e();
        String b16 = getAttachInfo().b();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.b.b(b().X().v().a().getText()));
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return ax.h(e16, b16, listOf, emptyList);
    }

    private final boolean j() {
        ArrayList<LocalMediaInfo> value = getAttachInfo().i().getValue();
        if (value != null && !value.isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        String str;
        if (i()) {
            return;
        }
        com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b bVar = this.sendCallback;
        if (bVar != null) {
            Editable f16 = b().X().v().a().f();
            if (f16 == null || (str = f16.toString()) == null) {
                str = "";
            }
            bVar.b(str, getAttachInfo().g().getValue(), getAttachInfo().i().getValue(), Boolean.valueOf(getAttachInfo().getOriginalPic()));
        }
        xk1.d.b0(b(), "onSend", 0, 0, 6, null);
        gl1.b bVar2 = (gl1.b) b().getRouter().b(gl1.b.class);
        if (bVar2 != null) {
            bVar2.c(b().X().v().getSendBtn());
        }
    }

    private final boolean m() {
        Editable text = b().X().v().a().getText();
        if (text != null && text.length() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void e(@NotNull xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        super.e(inputWindow);
        jt1.b.b(inputWindow.X().v().getSendBtn(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.SendButtonActor$onInputWindowInitialized$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                SendButtonActor.this.k();
            }
        });
        ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).preloadSpeakRule(getAttachInfo().e(), null);
    }

    public final void l(@Nullable com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b bVar) {
        this.sendCallback = bVar;
    }

    public final void n() {
        boolean z16;
        boolean m3 = m();
        boolean j3 = j();
        View sendBtn = b().X().v().getSendBtn();
        if (m3 && j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        sendBtn.setVisibility(8);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, sendBtn)) == null) {
            sendBtn.setVisibility(0);
        }
    }
}
