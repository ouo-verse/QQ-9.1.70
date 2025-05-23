package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/d;", "Lcom/tencent/biz/richframework/part/Part;", "Lqs2/b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "z9", "", "action", "", "args", "handleBroadcastMessage", ICustomDataEditor.NUMBER_PARAM_8, "", "size", "u4", "k4", "g4", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/a;", "d", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/a;", "x9", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/a;", "A9", "(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/a;)V", "editCtrl", "<init>", "()V", "e", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class d extends Part implements qs2.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a editCtrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.d$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49577);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A9(@Nullable com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.editCtrl = aVar;
        }
    }

    @Override // qs2.b
    public void g4(int size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, size);
        } else {
            broadcastMessage("start_select_file", new j(size));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a aVar;
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a aVar2;
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a aVar3;
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a aVar4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) action, args);
            return;
        }
        QLog.i("HW.MediaEdit.HWMediaEditPart", 1, "handleBroadcastMessage: " + action);
        if (action != null) {
            switch (action.hashCode()) {
                case -2051907663:
                    if (action.equals("select_media_finish") && (args instanceof i) && (aVar = this.editCtrl) != null) {
                        aVar.r(((i) args).a());
                        return;
                    }
                    return;
                case -1470936753:
                    if (action.equals("select_capture_finish") && (args instanceof b) && (aVar2 = this.editCtrl) != null) {
                        aVar2.a((b) args);
                        return;
                    }
                    return;
                case 1115410328:
                    if (action.equals("audio_record_finish") && (args instanceof a) && (aVar3 = this.editCtrl) != null) {
                        aVar3.d((a) args);
                        return;
                    }
                    return;
                case 1747298803:
                    if (action.equals("select_file_finish") && (args instanceof g) && (aVar4 = this.editCtrl) != null) {
                        aVar4.l(((g) args).a());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // qs2.b
    public void k4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            broadcastMessage("start_capture_media", null);
        }
    }

    @Override // qs2.b
    public void n8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            broadcastMessage("start_audio_record", null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            z9(rootView);
        }
    }

    @Override // qs2.b
    public void u4(int size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, size);
        } else {
            broadcastMessage("start_select_media", new k(size, 0, 2, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a x9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.editCtrl;
    }

    public abstract void z9(@Nullable View rootView);
}
