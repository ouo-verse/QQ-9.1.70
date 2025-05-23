package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.event.GuildAtDialogDismissEvent;
import com.tencent.mobileqq.guild.event.GuildAtEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0014\u0018\u0000 !2\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001)B\u0013\u0012\n\u0010&\u001a\u00060$j\u0002`%\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH\u0016J\u0006\u0010\f\u001a\u00020\u0005J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u000fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0010`\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/AtButtonActor;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputActor;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "k", "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "e", "l", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/AtButtonActor$b", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/AtButtonActor$b;", "atCharTextWatcher", "Landroidx/lifecycle/Observer;", "", tl.h.F, "Landroidx/lifecycle/Observer;", "supportAtStateObserver", "i", "Z", "isInsertingAtSpan", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "logTag", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputAttachInfo;", "attachInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class AtButtonActor extends NativeDetailInputWindowDirector.a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final a f220472m = new a(null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b atCharTextWatcher;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> supportAtStateObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isInsertingAtSpan;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/AtButtonActor$a;", "", "", "DELAY_SHOW_AFTER_AT_DISMISS", "J", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtButtonActor(@NotNull NativeDetailInputWindowDirector.b attachInfo) {
        super(attachInfo);
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        this.atCharTextWatcher = new b(attachInfo, this);
        this.supportAtStateObserver = new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AtButtonActor.o(AtButtonActor.this, (Boolean) obj);
            }
        };
    }

    private final void k() {
        if (b().getIsInitialized() && !b().N()) {
            if (!Intrinsics.areEqual(getAttachInfo().h().getValue(), Boolean.TRUE)) {
                b().n0(0);
                return;
            } else {
                QLog.d(m(), 1, "checkStartInput|become at king haha!");
                return;
            }
        }
        QLog.w(m(), 1, "checkStartInput|invalid state");
    }

    private final String m() {
        return "AtButtonActor";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AtButtonActor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(AtButtonActor this$0, Boolean bool) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView atButton = this$0.b().X().v().getAtButton();
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        atButton.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void e(@NotNull final xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        super.e(inputWindow);
        jt1.b.b(inputWindow.X().v().getAtButton(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.AtButtonActor$onInputWindowInitialized$1
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
                AtButtonActor.this.l();
                gl1.b bVar = (gl1.b) inputWindow.getRouter().b(gl1.b.class);
                if (bVar != null) {
                    bVar.c(it);
                }
            }
        });
        inputWindow.X().v().a().addTextChangedListener(this.atCharTextWatcher);
        getAttachInfo().m().observeForever(this.supportAtStateObserver);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildAtEvent.class, GuildAtDialogDismissEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    public final void l() {
        Runnable onOtherPageOpen = b().X().getOnOtherPageOpen();
        if (onOtherPageOpen != null) {
            onOtherPageOpen.run();
        }
        getAttachInfo().h().setValue(Boolean.TRUE);
        b().W();
        xk1.d.b0(b(), "inputAt", 0, 1, 2, null);
        Bundle bundle = new Bundle();
        bundle.putString("key_guild_id", getAttachInfo().e());
        bundle.putString("key_channel_id", getAttachInfo().b());
        bundle.putString(com.tencent.mobileqq.guild.feed.b.f218120f, getAttachInfo().d());
        bundle.putString(com.tencent.mobileqq.guild.feed.b.f218126l, "pg_sgrp_forum_detail");
        bundle.putInt("key_request_id", hashCode());
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_show_guild_at", bundle);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void onDestroy() {
        getAttachInfo().m().removeObserver(this.supportAtStateObserver);
        b().X().v().a().removeTextChangedListener(this.atCharTextWatcher);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        boolean z16;
        if (event != null && event.mHashCode == hashCode()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        if (event instanceof GuildAtEvent) {
            this.isInsertingAtSpan = true;
            com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.b.a(b().X().v().a(), (GuildAtEvent) event);
            this.isInsertingAtSpan = false;
        } else if ((event instanceof GuildAtDialogDismissEvent) && Intrinsics.areEqual(getAttachInfo().h().getValue(), Boolean.TRUE)) {
            getAttachInfo().h().setValue(Boolean.FALSE);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.b
                @Override // java.lang.Runnable
                public final void run() {
                    AtButtonActor.n(AtButtonActor.this);
                }
            }, 200L);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/AtButtonActor$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "text", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ NativeDetailInputWindowDirector.b f220476d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtButtonActor f220477e;

        b(NativeDetailInputWindowDirector.b bVar, AtButtonActor atButtonActor) {
            this.f220476d = bVar;
            this.f220477e = atButtonActor;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            Boolean value = this.f220476d.m().getValue();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(value, bool) && this.f220476d.getIsInitialized() && !this.f220477e.isInsertingAtSpan && Intrinsics.areEqual(this.f220476d.m().getValue(), bool)) {
                boolean z16 = true;
                if (count == 1 && before == 0) {
                    if (text == null || text.charAt(start) != '@') {
                        z16 = false;
                    }
                    if (z16) {
                        this.f220477e.l();
                    } else {
                        this.f220476d.h().setValue(Boolean.FALSE);
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }
    }
}
