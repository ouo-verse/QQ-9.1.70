package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm;

import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import at.b;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.MsgListIntent;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b&\u0018\u0000 4*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0017J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH&J\b\u0010\u0017\u001a\u00020\bH&J\b\u0010\u0018\u001a\u00020\bH&J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0019H&J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0013H&J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0013H&J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J\u0010\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020 H&J\b\u0010#\u001a\u00020\nH\u0016J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0010\u00a2\u0006\u0004\b&\u0010'J\b\u0010(\u001a\u0004\u0018\u00010\nR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\"\u00101\u001a\u00020\r8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/a;", "Lat/b;", "I", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "msgListRepo", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "y", "intent", "o", "(Lat/b;)V", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$a;", "p", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "u", "j", "w", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$b;", ReportConstant.COSTREPORT_PREFIX, "r", "t", "", "Lcom/tencent/aio/data/msglist/a;", "l", "", "updateType", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isAtBottom", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", HippyTKDListViewAdapter.X, "d", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "e", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", DomainData.DOMAIN_NAME, "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", "setRefreshOrLoadMoreStrategy", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;)V", "refreshOrLoadMoreStrategy", "<init>", "()V", "f", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class a<I extends at.b, S extends MsgListUiState> extends com.tencent.aio.base.mvvm.b<I, S> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MsgListRepo msgListRepo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected d refreshOrLoadMoreStrategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/a$a;", "", "", "DEFAULT_PAGE_SIZE", "I", "", "INTENT_SOURCE", "Ljava/lang/String;", "TAG", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52883);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public abstract void j();

    @NotNull
    public abstract List<com.tencent.aio.data.msglist.a> l();

    @NotNull
    public MsgListRepo m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MsgListRepo) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        MsgListRepo msgListRepo = this.msgListRepo;
        if (msgListRepo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgListRepo");
        }
        return msgListRepo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final d n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (d) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        d dVar = this.refreshOrLoadMoreStrategy;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshOrLoadMoreStrategy");
        }
        return dVar;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull I intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.d) {
            w();
        } else if (intent instanceof MsgListIntent.a) {
            p((MsgListIntent.a) intent);
        } else if (intent instanceof MsgListIntent.b) {
            s((MsgListIntent.b) intent);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDestroy();
            j();
        }
    }

    public void p(@NotNull MsgListIntent.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.f() == MsgListIntent.ScrollType.UP.ordinal()) {
            t(intent);
        } else if (intent.f() == MsgListIntent.ScrollType.DOWN.ordinal()) {
            r(intent);
        } else {
            q(intent.g());
        }
    }

    public void q(boolean isAtBottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, isAtBottom);
        }
    }

    public abstract void r(@NotNull MsgListIntent.a intent);

    public abstract void s(@NotNull MsgListIntent.b intent);

    public abstract void t(@NotNull MsgListIntent.a intent);

    public abstract void u();

    public abstract int v(int updateType);

    public abstract void w();

    @Nullable
    public final MsgListRepo x() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MsgListRepo) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        MsgListRepo msgListRepo = this.msgListRepo;
        if (msgListRepo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        if (msgListRepo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgListRepo");
        }
        return msgListRepo;
    }

    public final void y(@NotNull d strategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) strategy);
        } else {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.refreshOrLoadMoreStrategy = strategy;
        }
    }

    public final void z(@NotNull MsgListRepo msgListRepo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgListRepo);
        } else {
            Intrinsics.checkNotNullParameter(msgListRepo, "msgListRepo");
            this.msgListRepo = msgListRepo;
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    @CallSuper
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        setMContext(context);
        u();
    }
}
