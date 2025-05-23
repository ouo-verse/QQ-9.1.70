package com.tencent.robot.slash.dialog.content.base;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.e;
import x64.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002!%\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\f\b\u0002\u0010\u0006*\u0006\u0012\u0002\b\u00030\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007B\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b-\u0010.J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0014J\u0012\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0014J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0002\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0011H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R%\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR%\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR&\u0010$\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R&\u0010(\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010,\u001a\u00020)8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVM;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lw64/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/BaseVM;", "context", "", "p", "(Lw64/e;)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "Lcom/tencent/mvi/base/route/k;", "", "d", "Z", "mNeedRegisterLayoutHeightProviderCallback", "e", "Lkotlin/Lazy;", "l", "()Ljava/util/List;", "mMessageList", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mMessageRList", "com/tencent/robot/slash/dialog/content/base/SlashDialogVM$a", h.F, "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVM$a;", "mAction", "com/tencent/robot/slash/dialog/content/base/SlashDialogVM$b", "i", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVM$b;", "mActionR", "Lcom/tencent/robot/slash/dialog/content/base/a;", "j", "()Lcom/tencent/robot/slash/dialog/content/base/a;", "mLayoutHeightProvider", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class SlashDialogVM<I extends ol3.b, S extends MviUIState, C extends e<?>> extends BaseVM<I, S, C> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean mNeedRegisterLayoutHeightProviderCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMessageList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMessageRList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mActionR;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mLayoutHeightProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/slash/dialog/content/base/SlashDialogVM$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements com.tencent.mvi.base.route.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SlashDialogVM<I, S, C> f368457d;

        a(SlashDialogVM<I, S, C> slashDialogVM) {
            this.f368457d = slashDialogVM;
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            this.f368457d.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/slash/dialog/content/base/SlashDialogVM$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SlashDialogVM<I, S, C> f368458d;

        b(SlashDialogVM<I, S, C> slashDialogVM) {
            this.f368458d = slashDialogVM;
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return this.f368458d.I(i3);
        }
    }

    public /* synthetic */ SlashDialogVM(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    private final List<String> l() {
        return (List) this.mMessageList.getValue();
    }

    private final List<String> m() {
        return (List) this.mMessageRList.getValue();
    }

    protected void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @NotNull
    protected k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return new j54.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.robot.slash.dialog.content.base.a j() {
        return (com.tencent.robot.slash.dialog.content.base.a) this.mLayoutHeightProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public List<String> n() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public List<String> o() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        List<String> l3 = l();
        if (l3 != null) {
            Iterator<T> it = l3.iterator();
            while (it.hasNext()) {
                ((e) getMContext()).e().b((String) it.next(), this.mAction);
            }
        }
        List<String> m3 = m();
        if (m3 != null) {
            Iterator<T> it5 = m3.iterator();
            while (it5.hasNext()) {
                ((e) getMContext()).e().a((String) it5.next());
            }
        }
        if (this.mNeedRegisterLayoutHeightProviderCallback) {
            ((e) getMContext()).b().a(m.class).c(j());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull C context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate((SlashDialogVM<I, S, C>) context);
        List<String> l3 = l();
        if (l3 != null) {
            Iterator<T> it = l3.iterator();
            while (it.hasNext()) {
                context.e().d((String) it.next(), this.mAction);
            }
        }
        List<String> m3 = m();
        if (m3 != null) {
            Iterator<T> it5 = m3.iterator();
            while (it5.hasNext()) {
                context.e().j((String) it5.next(), this.mActionR);
            }
        }
        if (this.mNeedRegisterLayoutHeightProviderCallback) {
            context.b().a(m.class).a(j());
        }
    }

    public SlashDialogVM(boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        this.mNeedRegisterLayoutHeightProviderCallback = z16;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<List<? extends String>>(this) { // from class: com.tencent.robot.slash.dialog.content.base.SlashDialogVM$mMessageList$2
            final /* synthetic */ SlashDialogVM<I, S, C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final List<? extends String> invoke() {
                return this.this$0.n();
            }
        });
        this.mMessageList = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<List<? extends String>>(this) { // from class: com.tencent.robot.slash.dialog.content.base.SlashDialogVM$mMessageRList$2
            final /* synthetic */ SlashDialogVM<I, S, C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final List<? extends String> invoke() {
                return this.this$0.o();
            }
        });
        this.mMessageRList = lazy2;
        this.mAction = new a(this);
        this.mActionR = new b(this);
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.robot.slash.dialog.content.base.a>(this) { // from class: com.tencent.robot.slash.dialog.content.base.SlashDialogVM$mLayoutHeightProvider$2
            final /* synthetic */ SlashDialogVM<I, S, C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(this.this$0);
            }
        });
        this.mLayoutHeightProvider = lazy3;
    }
}
