package com.tencent.mobileqq.aio.input.blockstate;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.aio.event.MsgForwardEvent;
import com.tencent.mobileqq.aio.input.blockstate.GroupBlockStateIntent;
import com.tencent.mobileqq.aio.input.blockstate.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.aio.InputChangeEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\u000f\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b$\u0010 J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eH\u0016J\u0016\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eH\u0016J\u0010\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0017H\u0016R\"\u0010!\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010#\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/input/blockstate/c;", "Lcom/tencent/mobileqq/aio/mvi/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/AbsInputBarVMDelegate;", "", "isBlock", "", "blockType", "", "j", "Lcom/tencent/mvi/base/route/k;", "k", "", "", "kotlin.jvm.PlatformType", "d", "e", "Ljava/lang/Class;", "d0", "intent", "l", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "f", "g", h.F, "Lcom/tencent/mobileqq/aio/input/adorn/c;", "i", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Z", "Ljava/lang/Integer;", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c extends com.tencent.mobileqq.aio.mvi.a<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.c> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isBlock;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer blockType;

    public c(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
        } else {
            this.mHost = mHost;
        }
    }

    private final void j(boolean isBlock, int blockType) {
        String str;
        j e16;
        j e17;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        this.isBlock = isBlock;
        this.blockType = Integer.valueOf(blockType);
        com.tencent.aio.api.runtime.a c17 = c();
        if (c17 == null || (g16 = c17.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            str = "";
        }
        if (isBlock) {
            com.tencent.aio.api.runtime.a c18 = c();
            if (c18 != null && (e17 = c18.e()) != null) {
                e17.h(MsgForwardEvent.ExitMultiForward.f188621d);
            }
            SimpleEventBus.getInstance().dispatchEvent(new InputChangeEvent("", str));
        }
        com.tencent.aio.api.runtime.a c19 = c();
        if (c19 != null && (e16 = c19.e()) != null) {
            e16.h(new TroopBlockStateChange(isBlock, blockType));
        }
    }

    private final k k() {
        return new f.a(this.isBlock, this.blockType);
    }

    @Override // com.tencent.mobileqq.aio.mvi.a
    @NotNull
    public List<String> d() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(GroupBlockStateIntent.GroupBlockStateChange.class.getCanonicalName());
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return e.class;
    }

    @Override // com.tencent.mobileqq.aio.mvi.a
    @NotNull
    public List<String> e() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(GroupBlockStateIntent.GetTroopBlockState.class.getCanonicalName());
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.mobileqq.aio.mvi.a
    public void f(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
        if (msgIntent instanceof GroupBlockStateIntent.GroupBlockStateChange) {
            GroupBlockStateIntent.GroupBlockStateChange groupBlockStateChange = (GroupBlockStateIntent.GroupBlockStateChange) msgIntent;
            j(groupBlockStateChange.b(), groupBlockStateChange.a());
        }
    }

    @Override // com.tencent.mobileqq.aio.mvi.a
    @NotNull
    public k g(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (k) iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GroupBlockStateIntent.GetTroopBlockState) {
            return k();
        }
        return new com.tencent.input.base.utils.a();
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.mHost = cVar;
        }
    }
}
