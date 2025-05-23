package com.tencent.qqnt.rich;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.rich.part.MarkdownPart;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u0001\bB5\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/rich/n;", "Lcom/tencent/qqnt/rich/a;", "", "b", "Lcom/tencent/qqnt/rich/j;", "richData", "c", "Lcom/tencent/android/androidbypass/enhance/i;", "a", "", "action", "", "objects", "r0", "message", "d", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Landroidx/constraintlayout/widget/ConstraintLayout;", "e", "Landroidx/constraintlayout/widget/ConstraintLayout;", ParseCommon.CONTAINER, "Lcom/tencent/qqnt/rich/l;", "f", "Lcom/tencent/qqnt/rich/l;", "richFactory", tl.h.F, "Lcom/tencent/qqnt/rich/a;", "externalActionHandler", "Lcom/tencent/qqnt/rich/m;", "i", "Lcom/tencent/qqnt/rich/m;", "richHelper", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/rich/part/a;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "partList", BdhLogUtil.LogTag.Tag_Conn, "streamEndPartList", "D", "Lcom/tencent/qqnt/rich/j;", "Lcom/tencent/qqnt/rich/k;", "extParam", "<init>", "(Landroid/content/Context;Landroidx/constraintlayout/widget/ConstraintLayout;Lcom/tencent/qqnt/rich/l;Lcom/tencent/qqnt/rich/a;Lcom/tencent/qqnt/rich/k;)V", "E", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class n implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.qqnt.rich.part.a> streamEndPartList;

    /* renamed from: D, reason: from kotlin metadata */
    private j richData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConstraintLayout container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l richFactory;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a externalActionHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m richHelper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.qqnt.rich.part.a> partList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/rich/n$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.rich.n$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36320);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n(@NotNull Context context, @NotNull ConstraintLayout container, @NotNull l richFactory, @Nullable a aVar, @NotNull k extParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(richFactory, "richFactory");
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, container, richFactory, aVar, extParam);
            return;
        }
        this.context = context;
        this.container = container;
        this.richFactory = richFactory;
        this.externalActionHandler = aVar;
        m mVar = new m();
        mVar.a(this);
        this.richHelper = mVar;
        ArrayList<com.tencent.qqnt.rich.part.a> arrayList = new ArrayList<>();
        arrayList.addAll(richFactory.c(context, mVar, extParam));
        this.partList = arrayList;
        this.streamEndPartList = new ArrayList<>();
    }

    private final void b() {
        Iterator<com.tencent.qqnt.rich.part.a> it = this.streamEndPartList.iterator();
        while (true) {
            j jVar = null;
            if (!it.hasNext()) {
                break;
            }
            com.tencent.qqnt.rich.part.a next = it.next();
            ConstraintLayout constraintLayout = this.container;
            j jVar2 = this.richData;
            if (jVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("richData");
            } else {
                jVar = jVar2;
            }
            next.a(constraintLayout, jVar);
        }
        a aVar = this.externalActionHandler;
        if (aVar != null) {
            aVar.r0("stream_end", null);
        }
    }

    @Nullable
    public final com.tencent.android.androidbypass.enhance.i a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.android.androidbypass.enhance.i) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Iterator<com.tencent.qqnt.rich.part.a> it = this.partList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.rich.part.a next = it.next();
            if (next instanceof MarkdownPart) {
                return ((MarkdownPart) next).k();
            }
        }
        return null;
    }

    public final void c(@NotNull j richData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) richData);
            return;
        }
        Intrinsics.checkNotNullParameter(richData, "richData");
        this.richData = richData;
        Iterator<com.tencent.qqnt.rich.part.a> it = this.partList.iterator();
        while (it.hasNext() && !it.next().a(this.container, richData)) {
        }
    }

    public final void d(@NotNull String message, @Nullable Object objects) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) message, objects);
        } else {
            Intrinsics.checkNotNullParameter(message, "message");
            this.richHelper.d(message, objects);
        }
    }

    @Override // com.tencent.qqnt.rich.a
    public void r0(@NotNull String action, @Nullable Object objects) {
        a aVar;
        a aVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) action, objects);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        int hashCode = action.hashCode();
        if (hashCode != -1194440804) {
            if (hashCode != -1088235805) {
                if (hashCode == -68115606 && action.equals("send_external_message") && (aVar2 = this.externalActionHandler) != null) {
                    aVar2.r0("send_external_message", objects);
                    return;
                }
                return;
            }
            if (action.equals("stream_start") && (aVar = this.externalActionHandler) != null) {
                aVar.r0("stream_start", null);
                return;
            }
            return;
        }
        if (action.equals("stream_end")) {
            b();
        }
    }

    public /* synthetic */ n(Context context, ConstraintLayout constraintLayout, l lVar, a aVar, k kVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, constraintLayout, lVar, (i3 & 8) != 0 ? null : aVar, (i3 & 16) != 0 ? new k(null, null, 3, null) : kVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, constraintLayout, lVar, aVar, kVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
