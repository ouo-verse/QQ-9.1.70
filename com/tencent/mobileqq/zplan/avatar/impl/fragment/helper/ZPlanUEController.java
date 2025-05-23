package com.tencent.mobileqq.zplan.avatar.impl.fragment.helper;

import android.content.res.Configuration;
import android.os.Handler;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.z1.lua.c;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.ue.ZPlanLua2H5Plugin;
import com.tencent.mobileqq.zootopia.ue.ZootopiaUeModuleManager;
import com.tencent.mobileqq.zootopia.utils.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.upload.report.UploadQualityReportBuilder;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t74.u;
import tl.h;
import ye3.a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b/\u00100J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0018R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010&R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010(R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u0010.\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b)\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/ZPlanUEController;", "", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/f;", "sceneParser", "", "f", "", "statusBarHeight", "Landroid/widget/FrameLayout;", "avatarContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "k", "j", "g", "i", "Landroid/content/res/Configuration;", "newConfig", h.F, "c", "", UploadQualityReportBuilder.STATE_CONNECT, "o", "success", "d", "Lye3/a$b;", "a", "Lye3/a$b;", "backBufferSizeBefore", "Lcom/tencent/mobileqq/zootopia/ue/ZootopiaUeModuleManager;", "b", "Lcom/tencent/mobileqq/zootopia/ue/ZootopiaUeModuleManager;", "moduleManager", "Lcom/tencent/mobileqq/zootopia/utils/n;", "Lcom/tencent/mobileqq/zootopia/utils/n;", "zplanEngineHelper", "Landroidx/fragment/app/FragmentActivity;", "e", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/f;", "Lcom/tencent/mobileqq/z1/lua/c;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/z1/lua/c;", "leaveAvatarScenePlugin", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUEController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private a.Size backBufferSizeBefore;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ZootopiaUeModuleManager moduleManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private n zplanEngineHelper = new n(1);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FragmentActivity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private f sceneParser;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy leaveAvatarScenePlugin;

    public ZPlanUEController() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.z1.lua.c>() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.ZPlanUEController$leaveAvatarScenePlugin$2

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/avatar/impl/fragment/helper/ZPlanUEController$leaveAvatarScenePlugin$2$a", "Lcom/tencent/mobileqq/z1/lua/c$b;", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements c.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ZPlanUEController f331919a;

                a(ZPlanUEController zPlanUEController) {
                    this.f331919a = zPlanUEController;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void c(ZPlanUEController this$0) {
                    FragmentActivity fragmentActivity;
                    FragmentActivity fragmentActivity2;
                    FragmentActivity fragmentActivity3;
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    fragmentActivity = this$0.activity;
                    if (fragmentActivity instanceof ZootopiaActivity) {
                        QLog.i("ZPlanUEController_", 1, "activity is ZootopiaActivity");
                        fragmentActivity3 = this$0.activity;
                        Intrinsics.checkNotNull(fragmentActivity3, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.ZootopiaActivity");
                        ((ZootopiaActivity) fragmentActivity3).I2();
                    }
                    fragmentActivity2 = this$0.activity;
                    if (fragmentActivity2 != null) {
                        fragmentActivity2.finish();
                    }
                }

                @Override // com.tencent.mobileqq.z1.lua.c.b
                public boolean a() {
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    final ZPlanUEController zPlanUEController = this.f331919a;
                    uIHandlerV2.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE 
                          (r0v0 'uIHandlerV2' android.os.Handler)
                          (wrap:java.lang.Runnable:0x0008: CONSTRUCTOR (r1v0 'zPlanUEController' com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.ZPlanUEController A[DONT_INLINE]) A[MD:(com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.ZPlanUEController):void (m), WRAPPED] (LINE:9) call: com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.e.<init>(com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.ZPlanUEController):void type: CONSTRUCTOR)
                         VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (c)] (LINE:12) in method: com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.ZPlanUEController$leaveAvatarScenePlugin$2.a.a():boolean, file: classes35.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.e, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        android.os.Handler r0 = com.tencent.mobileqq.app.ThreadManagerV2.getUIHandlerV2()
                        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.ZPlanUEController r1 = r3.f331919a
                        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.e r2 = new com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.e
                        r2.<init>(r1)
                        r0.post(r2)
                        r0 = 1
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.ZPlanUEController$leaveAvatarScenePlugin$2.a.a():boolean");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.z1.lua.c invoke() {
                return new com.tencent.mobileqq.z1.lua.c(new a(ZPlanUEController.this));
            }
        });
        this.leaveAvatarScenePlugin = lazy;
    }

    private final com.tencent.mobileqq.z1.lua.c e() {
        return (com.tencent.mobileqq.z1.lua.c) this.leaveAvatarScenePlugin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(FrameLayout frameLayout, int i3, int i16, int i17, ZPlanUEController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int width = frameLayout.getWidth();
        int height = frameLayout.getHeight();
        QLog.i("ZPlanUEController_", 1, "resizeBackBufferSizeToFull viewWidth:" + width + ", viewHeight:" + height + ", screenWidth:" + i3 + ", screenHeight:" + i16 + ", statusBarHeight:" + i17);
        a.C11609a.a((ye3.a) vb3.a.f441346a.b(ye3.a.class), this$0.activity, width, height, false, 8, null);
    }

    public final void c() {
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.engineDestroy();
        }
    }

    public final void d(boolean success) {
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.engineInitFinish(success);
        }
    }

    public final void f(ZootopiaSource sourceCurrent, FragmentActivity activity, f sceneParser) {
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        Intrinsics.checkNotNullParameter(sceneParser, "sceneParser");
        this.activity = activity;
        this.sceneParser = sceneParser;
        this.backBufferSizeBefore = ((ye3.a) vb3.a.f441346a.a(ye3.a.class)).n();
        ZootopiaUeModuleManager zootopiaUeModuleManager = new ZootopiaUeModuleManager(1, "PORTAL");
        this.moduleManager = zootopiaUeModuleManager;
        if (activity != null) {
            zootopiaUeModuleManager.u9(activity, new com.tencent.mobileqq.zootopia.ue.d(sourceCurrent));
        }
        ZPlanLua2H5Plugin.INSTANCE.a();
        if (sceneParser.getCurrentViewType() == 25) {
            ar.f328509a.b(e());
        }
    }

    public final void g() {
        this.zplanEngineHelper.c();
    }

    public final void h(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.backBufferSizeBefore = null;
    }

    public final void i() {
        this.zplanEngineHelper.c();
        f fVar = this.sceneParser;
        boolean z16 = false;
        if (fVar != null && fVar.getCurrentViewType() == 25) {
            z16 = true;
        }
        if (z16) {
            ar.f328509a.c(e());
        }
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.destroy();
        }
    }

    public final void j() {
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.pause();
        }
    }

    public final void k() {
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.resume();
        }
    }

    public final void l() {
        a.Size size = this.backBufferSizeBefore;
        if (size == null) {
            return;
        }
        this.backBufferSizeBefore = null;
        QLog.i("ZPlanUEController_", 1, "recoveryBackBufferSize size:" + size);
        a.C11609a.a((ye3.a) vb3.a.f441346a.b(ye3.a.class), this.activity, size.getWidth(), size.getHeight(), false, 8, null);
    }

    public final void m(final int statusBarHeight, final FrameLayout avatarContainer) {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity == null) {
            return;
        }
        u.Companion companion = u.INSTANCE;
        final int c16 = companion.c(fragmentActivity);
        final int b16 = companion.b(fragmentActivity) + statusBarHeight;
        a.C11609a.a((ye3.a) vb3.a.f441346a.b(ye3.a.class), this.activity, c16, b16, false, 8, null);
        if (avatarContainer != null) {
            avatarContainer.requestLayout();
        }
        if (avatarContainer != null) {
            avatarContainer.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUEController.n(avatarContainer, c16, b16, statusBarHeight, this);
                }
            });
        }
    }

    public final void o(boolean connect) {
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.serviceConnected(connect);
        }
    }
}
