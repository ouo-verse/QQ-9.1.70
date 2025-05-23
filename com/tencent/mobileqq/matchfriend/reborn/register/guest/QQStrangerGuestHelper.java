package com.tencent.mobileqq.matchfriend.reborn.register.guest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.reborn.activity.QQStrangerPublicFragmentActivity;
import com.tencent.mobileqq.matchfriend.reborn.register.fragment.QQStrangerRegisterProfileFragment;
import com.tencent.mobileqq.matchfriend.reborn.utils.h;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/guest/QQStrangerGuestHelper;", "", "Lkotlin/Function0;", "", "block", "e", "", "d", "c", "Landroid/content/Context;", "context", "b", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerGuestHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerGuestHelper f245363a = new QQStrangerGuestHelper();

    QQStrangerGuestHelper() {
    }

    private final void e(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.guest.c
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerGuestHelper.f(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final boolean b(final Context context) {
        if (c()) {
            return false;
        }
        if (context == null) {
            QLog.e("QQStrangerGuestHelper", 1, "checkGuestAndRegister context is null");
            return true;
        }
        final p72.a f16 = com.tencent.mobileqq.matchfriend.utils.b.d().f();
        if (f16 == null) {
            QLog.e("QQStrangerGuestHelper", 1, "checkGuestAndRegister loginInfo is null");
            return true;
        }
        QLog.d("QQStrangerGuestHelper", 1, "checkGuestAndRegister jump register");
        e(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestHelper$checkGuestAndRegister$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QQToast.makeText(context, "\u6362\u4e2a\u8eab\u4efd\uff0c\u5373\u523b\u7ed3\u4f34", 0).show();
                Intent intent = new Intent();
                p72.a aVar = f16;
                Context context2 = context;
                intent.putExtra("key_open_id", aVar.f425671a);
                intent.putExtra("key_is_new_user", aVar.f425672b);
                intent.putExtra("key_with_anim", true);
                if (!(context2 instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                QQStrangerPublicFragmentActivity.INSTANCE.a(context, intent, QQStrangerRegisterProfileFragment.class);
            }
        });
        return true;
    }

    public final boolean c() {
        return h.h();
    }

    public final boolean d() {
        return true;
    }
}
