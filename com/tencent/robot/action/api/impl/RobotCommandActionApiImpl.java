package com.tencent.robot.action.api.impl;

import android.net.Uri;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import n14.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0002\u0018\u0000 &2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016JZ\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u001328\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0015H\u0016R=\u0010#\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00050\u001d0\u001e0\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/action/api/impl/RobotCommandActionApiImpl;", "", "com/tencent/robot/action/api/impl/RobotCommandActionApiImpl$b", "d", "()Lcom/tencent/robot/action/api/impl/RobotCommandActionApiImpl$b;", "Ln14/b;", "e", "f", "Ln14/c;", "context", "", ZPlanPublishSource.FROM_SCHEME, "", "c", "Ln14/d;", h.F, "source", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "anchorId", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "errorMsg", "", "callback", "i", "", "Lkotlin/Pair;", "a", "Lkotlin/Lazy;", "g", "()[Lkotlin/Pair;", "mSchemeHandlers", "<init>", "()V", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotCommandActionApiImpl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mSchemeHandlers;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/action/api/impl/RobotCommandActionApiImpl$b", "Ln14/b;", "Ln14/c;", "ctx", "Landroid/net/Uri;", ZPlanPublishSource.FROM_SCHEME, "", "a", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends n14.b<n14.c> {
        b() {
        }

        @Override // n14.b
        protected boolean a(@NotNull n14.c ctx, @NotNull Uri scheme) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            QLog.e("RobotCommandActionApiImpl", 1, "[DefaultSchemeAction.doAction], unsupported scheme: " + scheme);
            return false;
        }

        @Override // n14.b
        public boolean c(@NotNull n14.c ctx) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            return true;
        }
    }

    public RobotCommandActionApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Pair<? extends d, ? extends n14.b<? extends n14.c>[]>[]>() { // from class: com.tencent.robot.action.api.impl.RobotCommandActionApiImpl$mSchemeHandlers$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Pair<? extends d, ? extends n14.b<? extends n14.c>[]>[] invoke() {
                n14.b f16;
                n14.b e16;
                b bVar = new b();
                f16 = RobotCommandActionApiImpl.this.f();
                n14.b[] bVarArr = {new RobotParameterCmdSchemeAction(), f16};
                a aVar = new a();
                e16 = RobotCommandActionApiImpl.this.e();
                return new Pair[]{TuplesKt.to(bVar, bVarArr), TuplesKt.to(aVar, new n14.b[]{new c(), e16})};
            }
        });
        this.mSchemeHandlers = lazy;
    }

    private final b d() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n14.b<?> e() {
        Object createEnterCmdSchemeAction = ((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).createEnterCmdSchemeAction();
        if (createEnterCmdSchemeAction instanceof n14.b) {
            return (n14.b) createEnterCmdSchemeAction;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n14.b<?> f() {
        Object createParameterCmdSchemeAction = ((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).createParameterCmdSchemeAction();
        if (createParameterCmdSchemeAction instanceof n14.b) {
            return (n14.b) createParameterCmdSchemeAction;
        }
        return null;
    }

    private final Pair<d, n14.b<? extends n14.c>[]>[] g() {
        return (Pair[]) this.mSchemeHandlers.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        if (r6.c(r10) == true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r5 != null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(@NotNull n14.c context, @NotNull String scheme) {
        n14.b<? extends n14.c> bVar;
        Pair<d, n14.b<? extends n14.c>[]> pair;
        n14.b<? extends n14.c>[] second;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Uri schemeUri = Uri.parse(scheme);
        Pair<d, n14.b<? extends n14.c>[]>[] g16 = g();
        int length = g16.length;
        int i3 = 0;
        while (true) {
            bVar = null;
            if (i3 < length) {
                pair = g16[i3];
                d first = pair.getFirst();
                Intrinsics.checkNotNullExpressionValue(schemeUri, "schemeUri");
                if (first.a(schemeUri)) {
                    break;
                }
                i3++;
            } else {
                pair = null;
                break;
            }
        }
        if (pair != null && (second = pair.getSecond()) != null) {
            int length2 = second.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length2) {
                    break;
                }
                n14.b<? extends n14.c> bVar2 = second[i16];
                if (bVar2 != null) {
                    z16 = true;
                }
                z16 = false;
                if (z16) {
                    bVar = bVar2;
                    break;
                }
                i16++;
            }
        }
        bVar = d();
        Intrinsics.checkNotNullExpressionValue(schemeUri, "schemeUri");
        return bVar.b(context, schemeUri);
    }

    @Nullable
    public d h(@NotNull String scheme) {
        Pair<d, n14.b<? extends n14.c>[]> pair;
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Uri schemeUri = Uri.parse(scheme);
        Pair<d, n14.b<? extends n14.c>[]>[] g16 = g();
        int length = g16.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                pair = g16[i3];
                d first = pair.getFirst();
                Intrinsics.checkNotNullExpressionValue(schemeUri, "schemeUri");
                if (first.a(schemeUri)) {
                    break;
                }
                i3++;
            } else {
                pair = null;
                break;
            }
        }
        if (pair == null) {
            return null;
        }
        return pair.getFirst();
    }

    public void i(@NotNull String source, @NotNull com.tencent.aio.api.runtime.a aioContext, int anchorId, @Nullable Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (anchorId == 1) {
            RobotCommandActionUtils.f365910a.a(source, aioContext, callback);
        }
    }
}
