package com.tencent.qqnt.avatar.impl.engine;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.utils.f;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.b;
import com.tencent.qqnt.avatar.c;
import com.tencent.qqnt.avatar.i;
import com.tencent.qqnt.avatar.j;
import com.tencent.qqnt.avatar.meta.b;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalVipNumberInfo;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/avatar/impl/engine/FaceDrawableEngine;", "Lcom/tencent/qqnt/avatar/impl/engine/a;", "", "Landroid/graphics/drawable/Drawable;", "key", "Landroid/content/Context;", "context", "e", "", "release", "d", "Lcom/tencent/qqnt/avatar/b;", "a", "Lcom/tencent/qqnt/avatar/b;", "getOption", "()Lcom/tencent/qqnt/avatar/b;", "option", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarDrawable;", "b", "Lmqq/util/WeakReference;", "proAvatarDrawable", "<init>", "(Lcom/tencent/qqnt/avatar/b;)V", "c", "avatar_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class FaceDrawableEngine implements a<String, Drawable> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f352855d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b option;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<QQProAvatarDrawable> proAvatarDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/avatar/impl/engine/FaceDrawableEngine$a;", "", "", "reuseSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "reuseSwitch", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "avatar_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.impl.engine.FaceDrawableEngine$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) FaceDrawableEngine.f352855d.getValue()).booleanValue();
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
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29199);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(FaceDrawableEngine$Companion$reuseSwitch$2.INSTANCE);
        f352855d = lazy;
    }

    public FaceDrawableEngine(@NotNull b option) {
        Intrinsics.checkNotNullParameter(option, "option");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) option);
        } else {
            this.option = option;
        }
    }

    @Override // com.tencent.qqnt.avatar.impl.engine.a
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Drawable b(@NotNull String key, @NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) key, (Object) context);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(context, "context");
        QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
        qQProAvatarDrawable.v(4, key);
        this.proAvatarDrawable = new WeakReference<>(qQProAvatarDrawable);
        return qQProAvatarDrawable;
    }

    @Override // com.tencent.qqnt.avatar.impl.engine.a
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Drawable a(@NotNull String key, @NotNull Context context) {
        QQProAvatarDrawable qQProAvatarDrawable;
        String str;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList;
        b.a aVar;
        int i3;
        QQProAvatarDrawable qQProAvatarDrawable2;
        int i16;
        e.a aVar2;
        e.a aVar3;
        ArrayList arrayList2;
        b.a aVar4;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        int intValue6;
        int intValue7;
        int intValue8;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) key, (Object) context);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable a16 = this.option.a();
        if (INSTANCE.b() && (a16 instanceof QQProAvatarDrawable)) {
            qQProAvatarDrawable = (QQProAvatarDrawable) a16;
        } else {
            qQProAvatarDrawable = new QQProAvatarDrawable();
        }
        QQProAvatarDrawable qQProAvatarDrawable3 = qQProAvatarDrawable;
        e.a o16 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(140).e(true).b(false).d(true).m(8).c(true).n(1).o(9);
        b.a aVar5 = new b.a(1, key, 140, false, 8, null);
        c b16 = this.option.b();
        boolean a17 = b16 != null ? b16.a() : false;
        ArrayList arrayList3 = new ArrayList();
        if (this.option.d() == null) {
            QLog.i("FaceDrawableEngine", 1, "option.vasAvatarData is null");
        }
        i d16 = this.option.d();
        if (d16 != null) {
            VipData.VipNumberInfo vipNumberInfo = new VipData.VipNumberInfo();
            VASPersonalVipNumberInfo g16 = d16.g();
            Integer num = g16 != null ? g16.appId : null;
            if (num == null) {
                intValue5 = VipData.VipNumberInfo.APPID.Avatar.getId();
            } else {
                Intrinsics.checkNotNullExpressionValue(num, "it.vipNum?.appId ?: VipD\u2026umberInfo.APPID.Avatar.id");
                intValue5 = num.intValue();
            }
            vipNumberInfo.setAppId(intValue5);
            VASPersonalVipNumberInfo g17 = d16.g();
            Integer num2 = g17 != null ? g17.itemId : null;
            if (num2 == null) {
                intValue6 = d16.a();
            } else {
                Intrinsics.checkNotNullExpressionValue(num2, "it.vipNum?.itemId ?: it.avatarId");
                intValue6 = num2.intValue();
            }
            vipNumberInfo.setItemId(intValue6);
            VASPersonalVipNumberInfo g18 = d16.g();
            Integer num3 = g18 != null ? g18.numberItemId : null;
            if (num3 == null) {
                intValue7 = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num3, "it.vipNum?.numberItemId ?: 0");
                intValue7 = num3.intValue();
            }
            vipNumberInfo.setNumberItemId(intValue7);
            VASPersonalVipNumberInfo g19 = d16.g();
            Integer num4 = g19 != null ? g19.numberIdx : null;
            if (num4 == null) {
                intValue8 = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num4, "it.vipNum?.numberIdx ?: 0");
                intValue8 = num4.intValue();
            }
            vipNumberInfo.setNumberIdx(intValue8);
            vipNumberInfo.setLongNumber(d16.h());
            str = "it.vipNum?.appId ?: VipD\u2026umberInfo.APPID.Avatar.id";
            str2 = "it.vipNum?.numberItemId ?: 0";
            str3 = "it.vipNum?.numberIdx ?: 0";
            aVar = aVar5;
            i3 = 0;
            qQProAvatarDrawable2 = qQProAvatarDrawable3;
            com.tencent.mobileqq.avatar.utils.e eVar = new com.tencent.mobileqq.avatar.utils.e(1, key, d16.e(), d16.a(), vipNumberInfo, d16.d(), d16.f(), d16.c(), d16.b(), false, ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(key).getSpecialAvatarId(), false, ExportOutput.VALUE_LEVEL_1440P_MAX_LENGTH, null);
            arrayList = arrayList3;
            arrayList.add(eVar);
            str4 = "FaceDrawableEngine";
            i16 = 1;
            QLog.i(str4, 1, "option.vasAvatarData:" + eVar);
            aVar2 = o16;
            aVar2.n(d16.d());
            aVar2.o(d16.f());
        } else {
            str = "it.vipNum?.appId ?: VipD\u2026umberInfo.APPID.Avatar.id";
            str2 = "it.vipNum?.numberItemId ?: 0";
            str3 = "it.vipNum?.numberIdx ?: 0";
            str4 = "FaceDrawableEngine";
            arrayList = arrayList3;
            aVar = aVar5;
            i3 = 0;
            qQProAvatarDrawable2 = qQProAvatarDrawable3;
            i16 = 1;
            aVar2 = o16;
        }
        if (QLog.isDebugVersion() && this.option.e() == null) {
            QLog.i(str4, i16, "option.vasPendantData is null");
        }
        j e16 = this.option.e();
        if (e16 != null) {
            VipData.VipNumberInfo vipNumberInfo2 = new VipData.VipNumberInfo();
            VASPersonalVipNumberInfo f16 = e16.f();
            Integer num5 = f16 != null ? f16.appId : null;
            if (num5 == null) {
                intValue = VipData.VipNumberInfo.APPID.Avatar.getId();
            } else {
                Intrinsics.checkNotNullExpressionValue(num5, str);
                intValue = num5.intValue();
            }
            vipNumberInfo2.setAppId(intValue);
            VASPersonalVipNumberInfo f17 = e16.f();
            Integer num6 = f17 != null ? f17.itemId : null;
            if (num6 == null) {
                intValue2 = (int) e16.d();
            } else {
                Intrinsics.checkNotNullExpressionValue(num6, "it.vipNum?.itemId ?: it.pendantId.toInt()");
                intValue2 = num6.intValue();
            }
            vipNumberInfo2.setItemId(intValue2);
            VASPersonalVipNumberInfo f18 = e16.f();
            Integer num7 = f18 != null ? f18.numberItemId : null;
            if (num7 == null) {
                intValue3 = i3;
            } else {
                Intrinsics.checkNotNullExpressionValue(num7, str2);
                intValue3 = num7.intValue();
            }
            vipNumberInfo2.setNumberItemId(intValue3);
            VASPersonalVipNumberInfo f19 = e16.f();
            Integer num8 = f19 != null ? f19.numberIdx : null;
            if (num8 == null) {
                intValue4 = i3;
            } else {
                Intrinsics.checkNotNullExpressionValue(num8, str3);
                intValue4 = num8.intValue();
            }
            vipNumberInfo2.setNumberIdx(intValue4);
            vipNumberInfo2.setLongNumber(e16.g());
            e.a aVar6 = aVar2;
            String str5 = str4;
            arrayList2 = arrayList;
            f fVar = new f(1, key, 140, e16.d(), e16.c(), vipNumberInfo2, e16.e(), e16.b(), e16.a(), false, 0, 1536, null);
            arrayList2.add(fVar);
            if (QLog.isColorLevel()) {
                QLog.i(str5, 1, "option.vasPendantData:" + fVar);
            }
            aVar3 = aVar6;
            aVar3.l(e16.b());
            aVar3.k(e16.a());
            aVar3.m(e16.e());
        } else {
            aVar3 = aVar2;
            arrayList2 = arrayList;
        }
        if (a17) {
            aVar4 = aVar;
            aVar4.a(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.TRUE);
            aVar4.a("KEY_BEAN_KEY_SUFFIX", "sz");
        } else {
            aVar4 = aVar;
        }
        aVar4.a(FaceConstant.VAS_SPECIAL_SHAPE_MASK, Integer.valueOf(((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(key).getSpecialAvatarId()));
        ArrayList arrayList4 = arrayList2;
        QQProAvatarDrawable qQProAvatarDrawable4 = qQProAvatarDrawable2;
        qQProAvatarDrawable4.y(context, new com.tencent.qqnt.avatar.fetch.c(aVar4.b(), arrayList4, context.getDrawable(R.drawable.f160830com), null, false, null, 56, null));
        this.proAvatarDrawable = new WeakReference<>(qQProAvatarDrawable4);
        qQProAvatarDrawable4.x(aVar3.a());
        return qQProAvatarDrawable4;
    }

    @Override // com.tencent.qqnt.avatar.impl.engine.a
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.proAvatarDrawable = null;
        }
    }
}
