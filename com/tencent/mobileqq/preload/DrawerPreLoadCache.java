package com.tencent.mobileqq.preload;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDressUpProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeFinancialProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeHeadVipProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeKingCardProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeNicknameProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeQRCodeProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeZPlanProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeZplanBubbleProcessor;
import com.tencent.mobileqq.activity.qqsettingme.ab;
import com.tencent.mobileqq.activity.qqsettingme.ag;
import com.tencent.mobileqq.activity.qqsettingme.ah;
import com.tencent.mobileqq.activity.qqsettingme.ai;
import com.tencent.mobileqq.activity.qqsettingme.aj;
import com.tencent.mobileqq.activity.qqsettingme.ak;
import com.tencent.mobileqq.activity.qqsettingme.al;
import com.tencent.mobileqq.activity.qqsettingme.ao;
import com.tencent.mobileqq.activity.qqsettingme.ax;
import com.tencent.mobileqq.activity.qqsettingme.az;
import com.tencent.mobileqq.activity.qqsettingme.be;
import com.tencent.mobileqq.activity.qqsettingme.bn;
import com.tencent.mobileqq.activity.qqsettingme.n;
import com.tencent.mobileqq.activity.qqsettingme.u;
import com.tencent.mobileqq.activity.qqsettingme.v;
import com.tencent.mobileqq.activity.qqsettingme.y;
import com.tencent.mobileqq.activity.qqsettingmev3.d;
import com.tencent.mobileqq.activity.qqsettingmev3.f;
import com.tencent.mobileqq.activity.qqsettingmev3.g;
import com.tencent.mobileqq.activity.qqsettingmev3.m;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J.\u0010\u0015\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00060\u0012J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0006J\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0018j\b\u0012\u0004\u0012\u00020\f`\u0019R8\u0010\u001d\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b0\u0018j\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b`\u00198\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR8\u0010\u001f\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b0\u0018j\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b`\u00198\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\f0\u0018j\b\u0012\u0004\u0012\u00020\f`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010%R\u001b\u0010+\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/preload/DrawerPreLoadCache;", "", "", VipFunCallConstants.KEY_GROUP, "", "useNewApi", "", "f", "id", "d", "o", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/processor/b;", "processorClz", "i", "p", "Landroid/view/View;", "view", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "block", "k", h.F, "r", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DomainData.DOMAIN_NAME, "b", "Ljava/util/ArrayList;", "sInjectProcessors", "c", "sInjectProcessorsV3", "drawerProcessors", "e", "Z", "lastVersionIsV3", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "drawableMap", "g", "Lkotlin/Lazy;", "j", "()Z", "asyncGetDrawableSwitch", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class DrawerPreLoadCache {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DrawerPreLoadCache f259468a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @ConfigInject(configPath = "/Foundation/QQActivity/src/main/resources/Inject_QQSettingMe_processor.yml", version = 3)
    @NotNull
    private static final ArrayList<Class<? extends com.tencent.mobileqq.processor.b>> sInjectProcessors;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @ConfigInject(configPath = "/Foundation/QQActivity/src/main/resources/Inject_QQSettingMe_processor_v3.yml", version = 3)
    @NotNull
    private static final ArrayList<Class<? extends com.tencent.mobileqq.processor.b>> sInjectProcessorsV3;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<com.tencent.mobileqq.processor.b> drawerProcessors;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean lastVersionIsV3;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Drawable> drawableMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy asyncGetDrawableSwitch;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28554);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f259468a = new DrawerPreLoadCache();
        ArrayList<Class<? extends com.tencent.mobileqq.processor.b>> arrayList = new ArrayList<>();
        sInjectProcessors = arrayList;
        arrayList.add(v.class);
        arrayList.add(u.class);
        arrayList.add(QQSettingMeQRCodeProcessor.class);
        arrayList.add(az.class);
        arrayList.add(ab.class);
        arrayList.add(QQSettingMeKingCardProcessor.class);
        arrayList.add(y.class);
        arrayList.add(ak.class);
        arrayList.add(ah.class);
        arrayList.add(ao.class);
        arrayList.add(be.class);
        arrayList.add(ag.class);
        arrayList.add(QQSettingMeDressUpProcessor.class);
        arrayList.add(QQSettingMeSignatureProcessor.class);
        arrayList.add(aj.class);
        arrayList.add(n.class);
        arrayList.add(QQSettingMeHeadVipProcessor.class);
        arrayList.add(QQSettingMeNicknameProcessor.class);
        arrayList.add(QQSettingMeSuperMemberProcessor.class);
        arrayList.add(ai.class);
        arrayList.add(ax.class);
        arrayList.add(al.class);
        arrayList.add(QQSettingMeZPlanProcessor.class);
        arrayList.add(QQSettingMeZplanBubbleProcessor.class);
        arrayList.add(QQSettingMeFinancialProcessor.class);
        arrayList.add(bn.class);
        ArrayList<Class<? extends com.tencent.mobileqq.processor.b>> arrayList2 = new ArrayList<>();
        sInjectProcessorsV3 = arrayList2;
        arrayList2.add(v.class);
        arrayList2.add(u.class);
        arrayList2.add(g.class);
        arrayList2.add(az.class);
        arrayList2.add(d.class);
        arrayList2.add(QQSettingMeKingCardProcessor.class);
        arrayList2.add(y.class);
        arrayList2.add(ak.class);
        arrayList2.add(ah.class);
        arrayList2.add(ao.class);
        arrayList2.add(be.class);
        arrayList2.add(ag.class);
        arrayList2.add(com.tencent.mobileqq.activity.qqsettingmev3.QQSettingMeDressUpProcessor.class);
        arrayList2.add(QQSettingMeSignatureProcessor.class);
        arrayList2.add(aj.class);
        arrayList2.add(n.class);
        arrayList2.add(com.tencent.mobileqq.activity.qqsettingmev3.QQSettingMeHeadVipProcessor.class);
        arrayList2.add(QQSettingMeNicknameProcessor.class);
        arrayList2.add(com.tencent.mobileqq.activity.qqsettingmev3.QQSettingMeSuperMemberProcessor.class);
        arrayList2.add(f.class);
        arrayList2.add(ax.class);
        arrayList2.add(al.class);
        arrayList2.add(QQSettingMeZPlanProcessor.class);
        arrayList2.add(QQSettingMeZplanBubbleProcessor.class);
        arrayList2.add(com.tencent.mobileqq.activity.qqsettingmev3.QQSettingMeFinancialProcessor.class);
        arrayList2.add(m.class);
        drawerProcessors = new ArrayList<>();
        drawableMap = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(DrawerPreLoadCache$asyncGetDrawableSwitch$2.INSTANCE);
        asyncGetDrawableSwitch = lazy;
    }

    DrawerPreLoadCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(int id5, boolean useNewApi) {
        Drawable c16;
        if (useNewApi) {
            c16 = SkinEngine.getInstances().loadDrawable(id5);
        } else {
            c16 = ex.c(id5);
        }
        if (c16 != null) {
            drawableMap.put(Integer.valueOf(id5), c16);
        }
    }

    static /* synthetic */ void e(DrawerPreLoadCache drawerPreLoadCache, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        drawerPreLoadCache.d(i3, z16);
    }

    private final void f(int group, boolean useNewApi) {
        if (group != 0) {
            if (group != 1) {
                if (group == 2) {
                    d(R.drawable.qui_collection_vas, useNewApi);
                    d(R.drawable.qui_floder_vas, useNewApi);
                    d(R.drawable.qui_setting, useNewApi);
                    d(R.drawable.qui_night_mode, useNewApi);
                    return;
                }
                return;
            }
            d(R.drawable.qui_skin_vas, useNewApi);
            d(R.drawable.qui_intimates_space_vas, useNewApi);
            d(R.drawable.qui_free_cellular_data_vas, useNewApi);
            d(R.drawable.qui_image_vas, useNewApi);
            return;
        }
        d(R.drawable.qui_super_qq_show_vas, useNewApi);
        d(R.drawable.qui_super_member_vas, useNewApi);
        d(R.drawable.qui_wallet_vas, useNewApi);
        d(R.drawable.qui_littlebank_vas, useNewApi);
    }

    static /* synthetic */ void g(DrawerPreLoadCache drawerPreLoadCache, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        drawerPreLoadCache.f(i3, z16);
    }

    private final com.tencent.mobileqq.processor.b i(Class<? extends com.tencent.mobileqq.processor.b> processorClz) {
        Object obj;
        com.tencent.mobileqq.processor.b bVar;
        if (processorClz == null) {
            QLog.d("DrawerPreLoadCache", 1, "handleProcessorClz: processorClz == null");
            return null;
        }
        try {
            bVar = processorClz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            obj = null;
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e16) {
            obj = e16;
            bVar = null;
        }
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("DrawerPreLoadCache", 2, "handleProcessorClzz: processor=null, exception:" + obj);
            }
            return null;
        }
        return bVar;
    }

    private final boolean j() {
        return ((Boolean) asyncGetDrawableSwitch.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(int i3, View view, final Function1 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        f259468a.d(i3, true);
        final Drawable drawable = drawableMap.get(Integer.valueOf(i3));
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.mobileqq.preload.c
                @Override // java.lang.Runnable
                public final void run() {
                    DrawerPreLoadCache.m(Function1.this, drawable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 block, Drawable drawable) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke(drawable);
    }

    private final boolean o() {
        if (((IDrawerApi) QRoute.api(IDrawerApi.class)).currentIsV3() == lastVersionIsV3 && drawerProcessors.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(int i3) {
        f259468a.f(i3, true);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i("DrawerPreLoadCache", 1, "clearAll");
        drawableMap.clear();
        drawerProcessors.clear();
    }

    public final void k(final int id5, @Nullable final View view, @NotNull final Function1<? super Drawable, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(id5), view, block);
            return;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        ConcurrentHashMap<Integer, Drawable> concurrentHashMap = drawableMap;
        Drawable drawable = concurrentHashMap.get(Integer.valueOf(id5));
        if (drawable != null) {
            block.invoke(drawable);
        } else if (j()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.preload.b
                @Override // java.lang.Runnable
                public final void run() {
                    DrawerPreLoadCache.l(id5, view, block);
                }
            }, 16, null, false);
        } else {
            e(this, id5, false, 2, null);
            block.invoke(concurrentHashMap.get(Integer.valueOf(id5)));
        }
    }

    @NotNull
    public final ArrayList<com.tencent.mobileqq.processor.b> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (o()) {
            return drawerProcessors;
        }
        QLog.i("DrawerPreLoadCache", 1, "getProcessors 0");
        r();
        return drawerProcessors;
    }

    public final void p(final int group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, group);
        } else if (j()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.preload.a
                @Override // java.lang.Runnable
                public final void run() {
                    DrawerPreLoadCache.q(group);
                }
            }, 16, null, false);
        } else {
            g(this, group, false, 2, null);
        }
    }

    public final void r() {
        ArrayList<Class<? extends com.tencent.mobileqq.processor.b>> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (o()) {
            QLog.i("DrawerPreLoadCache", 2, "preLoadProcessors size " + drawerProcessors.size());
            return;
        }
        QLog.i("DrawerPreLoadCache", 1, "preLoadProcessors start");
        drawerProcessors.clear();
        boolean currentIsV3 = ((IDrawerApi) QRoute.api(IDrawerApi.class)).currentIsV3();
        lastVersionIsV3 = currentIsV3;
        if (currentIsV3) {
            arrayList = sInjectProcessorsV3;
        } else {
            arrayList = sInjectProcessors;
        }
        Iterator<Class<? extends com.tencent.mobileqq.processor.b>> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.processor.b i3 = i(it.next());
            if (i3 != null) {
                drawerProcessors.add(i3);
            }
        }
        QLog.i("DrawerPreLoadCache", 1, "preLoadProcessors end " + drawerProcessors.size());
    }
}
