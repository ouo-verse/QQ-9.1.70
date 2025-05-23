package com.tencent.mobileqq.aio.msglist.holder.component.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.event.e;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.avatar.AIOAvatarContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.avatar.AIOAvatarUIState;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.external.ExternalGetUIInfoEvent;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.am;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.aio.adapter.api.IAIOAnonymousApi;
import com.tencent.qqnt.aio.adapter.api.IContactApi;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007*\u0001\u001c\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u001aH\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/e;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "G", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/AIOAvatarContentComponent$d;", "D", "", "chatType", "H", "", "msgId", "Landroid/graphics/drawable/Drawable;", "B", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/aio/holder/a;", "o", "com/tencent/mobileqq/aio/msglist/holder/component/avatar/e$a", "f", "Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/e$a;", "mAction", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/avatar/e$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                e.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAction = new a();
        }
    }

    private final Drawable B(long msgId) {
        AIOAvatarUIState.GetDrawable getDrawable = new AIOAvatarUIState.GetDrawable(msgId, null, 2, null);
        updateUI(getDrawable);
        return getDrawable.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(AIOMsgItem msgItem) {
        Context context;
        if (!AIOUtil.f194084a.r((com.tencent.aio.api.runtime.a) getMContext()) && (context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext()) != null) {
            if (com.tencent.mobileqq.aio.utils.d.s(msgItem)) {
                ((IAIOAnonymousApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOAnonymousApi.class)).openAnonymousMemberProfile((com.tencent.aio.api.runtime.a) getMContext(), msgItem);
            } else {
                ((IContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IContactApi.class)).openProfileCard(context, msgItem);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D(AIOAvatarContentComponent.d intent) {
        String str;
        QQText qQText;
        AIOMsgItem a16 = intent.a();
        if (!a16.isSelf() && !com.tencent.mobileqq.aio.utils.d.O(a16)) {
            if (!AIOUtil.f194084a.r((com.tencent.aio.api.runtime.a) getMContext()) && a16.getMsgRecord().chatType != 2) {
                str = "";
                if (a16.getMsgRecord().chatType != 1 && !H(a16.getMsgRecord().chatType)) {
                    if (a16.getMsgRecord().chatType == 8) {
                        str = "\u6211\u7684\u7535\u8111";
                    }
                } else {
                    AIOTitleEvent.GetNickEvent getNickEvent = new AIOTitleEvent.GetNickEvent("");
                    ((com.tencent.aio.api.runtime.a) getMContext()).e().h(getNickEvent);
                    str = getNickEvent.a().toString();
                }
            } else {
                CharSequence i3 = com.tencent.mobileqq.aio.utils.d.i(a16);
                str = null;
                if (i3 instanceof QQText) {
                    qQText = (QQText) i3;
                } else {
                    qQText = null;
                }
                if (qQText != null) {
                    str = qQText.toPlainText();
                }
                if (str == null) {
                    str = com.tencent.mobileqq.aio.utils.c.a(a16).toString();
                }
            }
            intent.c(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof LongShotMsgIntent.ShotMosaic) {
            updateUI(new AIOMsgItemUIState.SetAvatarMosaic(((LongShotMsgIntent.ShotMosaic) intent).a()));
            return;
        }
        if (intent instanceof ExternalGetUIInfoEvent.GetAvatarDrawable) {
            ExternalGetUIInfoEvent.GetAvatarDrawable getAvatarDrawable = (ExternalGetUIInfoEvent.GetAvatarDrawable) intent;
            Drawable B = B(getAvatarDrawable.a());
            if (B != null) {
                getAvatarDrawable.b(B);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(AIOMsgItem msgItem) {
        if (!msgItem.isSelf() && !com.tencent.mobileqq.aio.utils.d.s(msgItem) && !com.tencent.mobileqq.aio.utils.d.O(msgItem)) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L));
            if (msgItem.getMsgRecord().chatType != 3 && msgItem.getMsgRecord().chatType != 2) {
                if (msgItem.getMsgRecord().chatType == 1 || H(msgItem.getMsgRecord().chatType)) {
                    AIOTitleEvent.GetNickEvent getNickEvent = new AIOTitleEvent.GetNickEvent("");
                    ((com.tencent.aio.api.runtime.a) getMContext()).e().h(getNickEvent);
                    ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEditTextMsgIntent.AppendTextToEditText(getNickEvent.a(), true));
                    return;
                }
                return;
            }
            String obj = com.tencent.mobileqq.aio.utils.c.a(msgItem).toString();
            j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            String str = msgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
            e16.h(new InputAtMsgIntent.InsertAtMemberSpan(str, String.valueOf(msgItem.getMsgRecord().senderUin), obj, false, 8, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean G(AIOMsgItem msgItem) {
        e.g gVar;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(RobotMsgIntent.GetSupportWideScreen.f188691d);
        if (k3 instanceof e.g) {
            gVar = (e.g) k3;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            return gVar.a();
        }
        return false;
    }

    private final boolean H(int chatType) {
        if (chatType != 100 && chatType != 103 && chatType != 106 && chatType != 104 && chatType != 111 && chatType != 102 && chatType != 105 && chatType != 101 && chatType != 113 && chatType != 117 && chatType != 115) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.LongShotMsgIntent.ShotMosaic");
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.ExternalGetUIInfoEvent.GetAvatarDrawable");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOAvatarContentComponent.a) {
            F(((AIOAvatarContentComponent.a) intent).a());
            return;
        }
        if (intent instanceof AIOAvatarContentComponent.b) {
            C(((AIOAvatarContentComponent.b) intent).a());
            return;
        }
        if (intent instanceof d.m) {
            ((d.m) intent).b(AIOUtil.f194084a.r((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof AIOAvatarContentComponent.c) {
            ((AIOAvatarContentComponent.c) intent).b(am.f194110a.g((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof AIOAvatarContentComponent.d) {
            D((AIOAvatarContentComponent.d) intent);
            return;
        }
        if (intent instanceof AIOAvatarContentComponent.f) {
            AIOAvatarContentComponent.f fVar = (AIOAvatarContentComponent.f) intent;
            fVar.c(H(fVar.a().getMsgRecord().chatType));
        } else if (intent instanceof AIOAvatarContentComponent.e) {
            AIOAvatarContentComponent.e eVar = (AIOAvatarContentComponent.e) intent;
            eVar.c(G(eVar.a()));
        } else {
            super.handleIntent(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
    }
}
