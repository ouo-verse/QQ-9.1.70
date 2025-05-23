package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl;

import android.annotation.SuppressLint;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.log.e;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.d;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.g;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.MsgListIntent;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00015B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R(\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d0+8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/impl/a;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/a;", "Lat/b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/c;", "it", "", "D", "G", "", "updateType", "submitOpt", "H", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/c;", "callback", UserInfo.SEX_FEMALE, "u", "v", "w", "", "isAtBottom", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$a;", "intent", "r", "t", BdhLogUtil.LogTag.Tag_Conn, "", "Lcom/tencent/aio/data/msglist/a;", "l", "", "B", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$b;", ReportConstant.COSTREPORT_PREFIX, "j", h.F, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/c;", "msgListCallback", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/h;", "i", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/h;", "repoMsgReceiver", "Ljava/util/concurrent/CopyOnWriteArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/CopyOnWriteArrayList;", "getDisplayList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setDisplayList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "displayList", "<init>", "()V", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a<at.b, MsgListState> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private c msgListCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.h<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.c> repoMsgReceiver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> displayList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/impl/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/impl/a$b", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/h;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/c;", "data", "", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class b extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.h<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.c> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.h
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.c data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) data);
            } else {
                Intrinsics.checkNotNullParameter(data, "data");
                a.this.D(data);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.displayList = new CopyOnWriteArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"WrongConstant"})
    public final void D(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.c it) {
        int i3;
        int i16 = com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl.b.f69681a[d.c(it).ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                List<com.tencent.aio.data.msglist.a> b16 = d.b(it);
                if (b16 != null) {
                    this.displayList = new CopyOnWriteArrayList<>(b16);
                    i3 = v(1);
                } else {
                    i3 = 0;
                }
                if (d.c(it) == IMsgListRepository.MsgListRepoOpType.LoadNextPage) {
                    i3 |= 8;
                } else if (d.c(it) == IMsgListRepository.MsgListRepoOpType.LoadPrePage) {
                    i3 |= 4;
                }
                if (it.a()) {
                    i3 |= 2;
                }
            } else {
                i3 = 5;
            }
        } else {
            i3 = 9;
        }
        Integer num = null;
        if (MsgListState.Companion.UpdateType.INSTANCE.b(i3)) {
            com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateType = ");
            sb5.append(i3);
            sb5.append(", opType = ");
            sb5.append(d.c(it));
            sb5.append(", listSize: ");
            List<com.tencent.aio.data.msglist.a> b17 = d.b(it);
            if (b17 != null) {
                num = Integer.valueOf(b17.size());
            }
            sb5.append(num.intValue());
            aVar.d("MsgListVM", sb5.toString());
        } else {
            e a16 = com.tencent.aio.base.log.b.a(com.tencent.aio.base.log.a.f69187b);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("updateType = ");
            sb6.append(i3);
            sb6.append(", opType = ");
            sb6.append(d.c(it));
            sb6.append(", listSize: ");
            List<com.tencent.aio.data.msglist.a> b18 = d.b(it);
            if (b18 != null) {
                num = Integer.valueOf(b18.size());
            }
            sb6.append(num.intValue());
            a16.d("MsgListVM", sb6.toString());
        }
        H(i3, it);
    }

    private final void G() {
        if (B() == -3) {
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d("MsgListVM", "UpdateFocusIndex to User");
        m().B(-3L);
    }

    private final void H(int updateType, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.c submitOpt) {
        long j3;
        c cVar = this.msgListCallback;
        if (cVar != null) {
            Long b16 = submitOpt.b().b();
            if (b16 != null) {
                j3 = b16.longValue();
            } else {
                j3 = -3;
            }
            cVar.b(new MsgListState(j3, l(), updateType, d.a(submitOpt)));
        }
    }

    public long B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return m().O();
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (B() == -1) {
            return;
        }
        com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
        aVar.d("MsgListVM", "handleScrollAtBottom");
        if (!n().b(l(), m().H(), m().G())) {
            aVar.d("MsgListVM", "UpdateFocusIndex to Bottom");
            m().B(-1L);
        }
    }

    public final void F(@Nullable c callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            this.msgListCallback = callback;
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.h<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.c> hVar = this.repoMsgReceiver;
        if (hVar != null) {
            hVar.b();
        }
        this.repoMsgReceiver = null;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    @NotNull
    public List<com.tencent.aio.data.msglist.a> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.displayList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void q(boolean isAtBottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, isAtBottom);
        } else if (isAtBottom) {
            C();
        } else {
            G();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void r(@NotNull MsgListIntent.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.g()) {
            C();
        } else {
            G();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void s(@NotNull MsgListIntent.b intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.a() == 0 && intent.b()) {
            C();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void t(@NotNull MsgListIntent.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            G();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.repoMsgReceiver = new b();
        g<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.c> P = m().P();
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.h<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.c> hVar = this.repoMsgReceiver;
        Intrinsics.checkNotNull(hVar);
        P.a(hVar);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public int v(int updateType) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, updateType)).intValue();
        }
        if (n().b(l(), m().H(), m().G())) {
            i3 = updateType | 32;
        } else {
            i3 = updateType | 128;
        }
        if (n().a(l(), m().H(), m().G())) {
            return i3 | 16;
        }
        return i3 | 64;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
