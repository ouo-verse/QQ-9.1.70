package com.tencent.mobileqq.wink.editor;

import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.hdr.HDRStatusView;
import com.tencent.videocut.model.MediaClip;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$exportProgressListener$1", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment$b;", "", "needDeLogo", "needDeBlur", "needDeFace", "Ljava/lang/Runnable;", "enhanceProcess", "", "c", "", "v", "a", HippyQQPagView.FunctionName.SET_PROGRESS, "showDialog", "success", "e", "d", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorFragment$exportProgressListener$1 implements WinkEditorFragment.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WinkEditorFragment f318566a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f318567b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List<MediaClip> f318568c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f318569d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public WinkEditorFragment$exportProgressListener$1(WinkEditorFragment winkEditorFragment, Ref.BooleanRef booleanRef, List<? extends MediaClip> list, boolean z16) {
        this.f318566a = winkEditorFragment;
        this.f318567b = booleanRef;
        this.f318568c = list;
        this.f318569d = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cx cxVar = this$0.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.k().fb(true);
        this$0.ql();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(WinkEditorFragment this$0, boolean z16) {
        HDRStatusView hDRStatusView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ql();
        hDRStatusView = this$0.hdrStatusView;
        if (hDRStatusView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hdrStatusView");
            hDRStatusView = null;
        }
        hDRStatusView.b(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(WinkEditorFragment this$0, List list, dr drVar, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, final Runnable runnable) {
        com.tencent.mobileqq.wink.editor.hdr.q Vk;
        HDRStatusView hDRStatusView;
        List list2;
        HDRStatusView hDRStatusView2;
        HDRStatusView hDRStatusView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Vk = this$0.Vk();
        Vk.f2(true);
        hDRStatusView = this$0.hdrStatusView;
        cx cxVar = null;
        if (hDRStatusView != null) {
            if (list == null) {
                if (drVar != null) {
                    list2 = drVar.g0();
                } else {
                    list2 = null;
                }
            } else {
                list2 = list;
            }
            hDRStatusView2 = this$0.hdrStatusView;
            if (hDRStatusView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hdrStatusView");
                hDRStatusView3 = null;
            } else {
                hDRStatusView3 = hDRStatusView2;
            }
            hDRStatusView3.d(z16, z17, z18, com.tencent.videocut.render.extension.e.q(list2));
            this$0.Tk().d5(true);
        }
        cx cxVar2 = this$0.partManager;
        if (cxVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
        } else {
            cxVar = cxVar2;
        }
        cxVar.k().fb(true);
        if (!z19) {
            this$0.ql();
            return;
        }
        w53.b.a("WinkEditorFragment", "\u8fdb\u5165\u975e\u6253\u65ad\u903b\u8f91 dismiss dialog");
        this$0.ql();
        if (z26) {
            this$0.bo(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$exportProgressListener$1$initWithConfig$1$2
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
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(WinkEditorFragment this$0, float f16) {
        com.tencent.mobileqq.wink.editor.hdr.k Ck;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Ck = this$0.Ck();
        Ck.k(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(WinkEditorFragment this$0, float f16) {
        HDRStatusView hDRStatusView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hDRStatusView = this$0.hdrStatusView;
        if (hDRStatusView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hdrStatusView");
            hDRStatusView = null;
        }
        hDRStatusView.l(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Vn();
    }

    @Override // com.tencent.mobileqq.wink.editor.WinkEditorFragment.b
    public void a(final float v3) {
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final WinkEditorFragment winkEditorFragment = this.f318566a;
        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cb
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment$exportProgressListener$1.o(WinkEditorFragment.this, v3);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.WinkEditorFragment.b
    public void b() {
        this.f318566a.Tk().d5(false);
        dr drVar = this.f318566a.curTavCut;
        if (drVar != null) {
            drVar.play();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.WinkEditorFragment.b
    public void c(final boolean needDeLogo, final boolean needDeBlur, final boolean needDeFace, @Nullable final Runnable enhanceProcess) {
        final boolean z16;
        long j3;
        com.tencent.mobileqq.wink.editor.hdr.q Vk;
        com.tencent.mobileqq.wink.editor.hdr.q Vk2;
        if (!needDeLogo && !needDeFace && !needDeBlur) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f318566a.deBlur = needDeBlur ? 1 : 0;
        this.f318566a.deFace = needDeFace ? 1 : 0;
        this.f318566a.deLogo = needDeLogo ? 1 : 0;
        this.f318567b.element = true;
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_AEFTER_DETECT);
        final dr drVar = this.f318566a.curTavCut;
        if (z16 && drVar != null) {
            j3 = this.f318566a.curPlayerTimeUs;
            drVar.seek(j3);
            drVar.play();
            drVar.c0(true);
            Vk = this.f318566a.Vk();
            Vk2 = this.f318566a.Vk();
            Vk.k2(Vk2.getCom.tencent.mobileqq.wink.editor.hdr.EhanceWinkEditUIData.enhanceBubbleShowed java.lang.String());
        }
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final WinkEditorFragment winkEditorFragment = this.f318566a;
        final List<MediaClip> list = this.f318568c;
        final boolean z17 = this.f318569d;
        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cc
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment$exportProgressListener$1.n(WinkEditorFragment.this, list, drVar, needDeLogo, needDeBlur, needDeFace, z16, z17, enhanceProcess);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.WinkEditorFragment.b
    public void d() {
        com.tencent.mobileqq.wink.editor.hdr.q Vk;
        com.tencent.mobileqq.wink.editor.hdr.q Vk2;
        if (this.f318567b.element) {
            this.f318566a.zn();
            this.f318567b.element = false;
        }
        this.f318566a.Tk().d5(false);
        dr drVar = this.f318566a.curTavCut;
        if (drVar != null) {
            drVar.c0(true);
        }
        Vk = this.f318566a.Vk();
        Vk2 = this.f318566a.Vk();
        Vk.k2(Vk2.getCom.tencent.mobileqq.wink.editor.hdr.EhanceWinkEditUIData.enhanceBubbleShowed java.lang.String());
        WinkEditorFragment.ol(this.f318566a, false, 1, null);
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final WinkEditorFragment winkEditorFragment = this.f318566a;
        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.bz
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment$exportProgressListener$1.l(WinkEditorFragment.this);
            }
        });
        this.f318566a.Lj();
    }

    @Override // com.tencent.mobileqq.wink.editor.WinkEditorFragment.b
    public void e(final boolean success) {
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final WinkEditorFragment winkEditorFragment = this.f318566a;
        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cd
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment$exportProgressListener$1.m(WinkEditorFragment.this, success);
            }
        });
        this.f318566a.Tk().d5(false);
    }

    @Override // com.tencent.mobileqq.wink.editor.WinkEditorFragment.b
    public void setProgress(final float v3) {
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final WinkEditorFragment winkEditorFragment = this.f318566a;
        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.ce
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment$exportProgressListener$1.p(WinkEditorFragment.this, v3);
            }
        });
        this.f318566a.isExportProcessing = true;
    }

    @Override // com.tencent.mobileqq.wink.editor.WinkEditorFragment.b
    public void showDialog() {
        long j3;
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final WinkEditorFragment winkEditorFragment = this.f318566a;
        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.ca
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment$exportProgressListener$1.q(WinkEditorFragment.this);
            }
        });
        WinkEditorFragment winkEditorFragment2 = this.f318566a;
        dr drVar = winkEditorFragment2.curTavCut;
        if (drVar != null) {
            j3 = drVar.getCurrentPlayUs();
        } else {
            j3 = 0;
        }
        winkEditorFragment2.curPlayerTimeUs = j3;
        dr drVar2 = this.f318566a.curTavCut;
        if (drVar2 != null) {
            drVar2.pause();
        }
    }
}
