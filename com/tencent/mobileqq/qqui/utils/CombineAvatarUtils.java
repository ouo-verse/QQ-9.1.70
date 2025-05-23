package com.tencent.mobileqq.qqui.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi;
import com.tencent.qqnt.avatar.combine.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J'\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqui/utils/CombineAvatarUtils;", "", "Landroid/content/Context;", "context", "", "", "uins", "Lcom/tencent/qqnt/avatar/combine/b;", "l", "", "g", "(Landroid/content/Context;[Ljava/lang/String;Lcom/tencent/qqnt/avatar/combine/b;)V", "listener", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, h.F, "f", "([Ljava/lang/String;)[Landroid/graphics/Bitmap;", "d", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class CombineAvatarUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CombineAvatarUtils f274736a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f274736a = new CombineAvatarUtils();
        }
    }

    CombineAvatarUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Context context, String[] uins, com.tencent.qqnt.avatar.combine.b listener) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(uins, "$uins");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        f274736a.g(context, uins, listener);
    }

    private final Bitmap[] f(String[] uins) {
        return ((IAIOAvatarApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOAvatarApi.class)).getAvatars(uins);
    }

    /* JADX WARN: Type inference failed for: r6v10, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.util.List, T] */
    private final void g(Context context, String[] uins, final com.tencent.qqnt.avatar.combine.b l3) {
        List filterNotNull;
        Sequence asSequence;
        Sequence filterNotNull2;
        Sequence filter;
        ?? list;
        filterNotNull = ArraysKt___ArraysKt.filterNotNull(uins);
        if (filterNotNull.size() > 4) {
            filterNotNull = filterNotNull.subList(0, 4);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Object[] array = filterNotNull.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        asSequence = ArraysKt___ArraysKt.asSequence(f((String[]) array));
        filterNotNull2 = SequencesKt___SequencesKt.filterNotNull(asSequence);
        filter = SequencesKt___SequencesKt.filter(filterNotNull2, CombineAvatarUtils$loadCombineAvatar$avatars$1.INSTANCE);
        list = SequencesKt___SequencesKt.toList(filter);
        objectRef.element = list;
        if (((List) list).isEmpty()) {
            h(l3, null);
            return;
        }
        if (((List) objectRef.element).size() == 1) {
            h(l3, (Bitmap) ((List) objectRef.element).get(0));
            return;
        }
        if (((List) objectRef.element).size() > 4) {
            objectRef.element = ((List) objectRef.element).subList(0, 4);
        }
        a.C9506a c9506a = new a.C9506a(context);
        c9506a.h(new Function1<a.C9506a, Unit>(objectRef, l3) { // from class: com.tencent.mobileqq.qqui.utils.CombineAvatarUtils$loadCombineAvatar$option$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.ObjectRef<List<Bitmap>> $avatars;
            final /* synthetic */ com.tencent.qqnt.avatar.combine.b $l;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqui/utils/CombineAvatarUtils$loadCombineAvatar$option$1$1$a", "Lcom/tencent/qqnt/avatar/combine/b;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes17.dex */
            public static final class a implements com.tencent.qqnt.avatar.combine.b {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ com.tencent.qqnt.avatar.combine.b f274737a;

                a(com.tencent.qqnt.avatar.combine.b bVar) {
                    this.f274737a = bVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
                    }
                }

                @Override // com.tencent.qqnt.avatar.combine.b
                public void a(@Nullable Bitmap bitmap) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        CombineAvatarUtils.f274736a.h(this.f274737a, bitmap);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$avatars = objectRef;
                this.$l = l3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef, (Object) l3);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a.C9506a c9506a2) {
                invoke2(c9506a2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.C9506a init) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) init);
                    return;
                }
                Intrinsics.checkNotNullParameter(init, "$this$init");
                init.j(1);
                init.k(-1);
                init.m(28);
                Object[] array2 = this.$avatars.element.toArray(new Bitmap[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                init.i((Bitmap[]) array2);
                init.l(new a(this.$l));
            }
        });
        c9506a.a().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final com.tencent.qqnt.avatar.combine.b listener, final Bitmap bitmap) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            listener.a(bitmap);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqui.utils.b
                @Override // java.lang.Runnable
                public final void run() {
                    CombineAvatarUtils.i(com.tencent.qqnt.avatar.combine.b.this, bitmap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(com.tencent.qqnt.avatar.combine.b listener, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.a(bitmap);
    }

    public final void d(@NotNull final Context context, @NotNull final String[] uins, @NotNull final com.tencent.qqnt.avatar.combine.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, uins, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqui.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                CombineAvatarUtils.e(context, uins, listener);
            }
        }, 16, null, true);
    }
}
