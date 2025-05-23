package pn0;

import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\b\u0007*\u0002\u0014\u0018\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0017J\b\u0010\n\u001a\u00020\bH\u0017J\u0012\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lpn0/a;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", "Lcom/tencent/mvi/base/route/k;", "l", "pn0/a$a", "d", "Lpn0/a$a;", "mAction", "pn0/a$b", "e", "Lpn0/a$b;", "mActionR", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class a<I extends ol3.b, S extends MviUIState> extends com.tencent.aio.base.mvvm.b<I, S> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C11030a mAction = new C11030a(this);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mActionR = new b(this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"pn0/a$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pn0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C11030a implements com.tencent.mvi.base.route.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a<I, S> f426488d;

        C11030a(a<I, S> aVar) {
            this.f426488d = aVar;
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            this.f426488d.j(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"pn0/a$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a<I, S> f426489d;

        b(a<I, S> aVar) {
            this.f426489d = aVar;
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return this.f426489d.l(i3);
        }
    }

    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @NotNull
    public k l(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        pn0.b bVar = pn0.b.f426490a;
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.mvi.base.route.MsgResult");
        return bVar;
    }

    @Nullable
    public List<String> m() {
        return null;
    }

    @Nullable
    public List<String> n() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        List<String> m3 = m();
        if (m3 != null) {
            Iterator<T> it = m3.iterator();
            while (it.hasNext()) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) it.next(), this.mAction);
            }
        }
        List<String> n3 = n();
        if (n3 != null) {
            Iterator<T> it5 = n3.iterator();
            while (it5.hasNext()) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().a((String) it5.next());
            }
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    @CallSuper
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        List<String> m3 = m();
        if (m3 != null) {
            Iterator<T> it = m3.iterator();
            while (it.hasNext()) {
                context.e().d((String) it.next(), this.mAction);
            }
        }
        List<String> n3 = n();
        if (n3 != null) {
            Iterator<T> it5 = n3.iterator();
            while (it5.hasNext()) {
                context.e().j((String) it5.next(), this.mActionR);
            }
        }
    }
}
