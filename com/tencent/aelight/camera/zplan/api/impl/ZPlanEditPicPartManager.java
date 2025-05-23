package com.tencent.aelight.camera.zplan.api.impl;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart;
import com.tencent.aelight.camera.aioeditor.takevideo.ZPlanEditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.aa;
import com.tencent.aelight.camera.aioeditor.takevideo.ai;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import fs.p;
import fs.r;
import fs.s;
import fs.t;
import fs.v;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002JF\u0010\u000e\u001a\u001d\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000b\u00a2\u0006\u0002\b\f2!\u0010\r\u001a\u001d\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000b\u00a2\u0006\u0002\b\fH\u0002J#\u0010\u000f\u001a\u001d\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000b\u00a2\u0006\u0002\b\fH\u0002J#\u0010\u0010\u001a\u001d\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000b\u00a2\u0006\u0002\b\fH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J+\u0010\u0012\u001a\u00020\n2!\u0010\r\u001a\u001d\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000b\u00a2\u0006\u0002\b\fH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\nH\u0016R\u0014\u0010\u0019\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/ZPlanEditPicPartManager;", "Lcom/tencent/aelight/camera/aioeditor/takevideo/k;", "", "enableMask", "", "Lcom/tencent/aelight/camera/aioeditor/takevideo/u;", "K1", "I1", "Lkotlin/Function2;", "Lfs/b;", "", "Lcom/tencent/aelight/camera/zplan/api/impl/ZPublishHandlerClosure;", "Lkotlin/ExtensionFunctionType;", "action", "O1", "Q1", "P1", "L1", "H1", "Lcom/tencent/mobileqq/editor/params/EditVideoParams;", "params", "j0", "b1", "N1", "()I", "mEntranceType", "M1", "mBusinessId", "<init>", "()V", "w0", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ZPlanEditPicPartManager extends com.tencent.aelight.camera.aioeditor.takevideo.k {
    private final void H1(Function2<? super ZPlanEditPicPartManager, ? super fs.b, Unit> action) {
        fs.b bVar = new fs.b(this.C);
        bVar.f400399p = s.b(bVar.f400385b);
        bVar.f400395l = new fs.g(bVar.f400386c.getSourcePath());
        List<u> mParts = this.D;
        Intrinsics.checkNotNullExpressionValue(mParts, "mParts");
        Iterator<T> it = mParts.iterator();
        while (it.hasNext()) {
            ((u) it.next()).editVideoPrePublish(0, bVar);
        }
        String m3 = bVar.f400384a.m("extra_text_filter_text");
        QLog.i("ZPlanEditPicPartManager", 1, "PUBLISH start ...");
        this.f67794m.showLoadingDialog(HardCodeUtil.qqStr(R.string.lwp), false, 500L);
        Stream map = Stream.of(bVar).map(new ThreadOffFunction("ZPlanEditPicPartManager", 2)).map(new a(m3)).map(new r(this.C.E)).map(new fs.e((com.tencent.aelight.camera.aioeditor.takevideo.d) R(com.tencent.aelight.camera.aioeditor.takevideo.d.class), null)).map(new p(com.tencent.aelight.camera.aioeditor.takevideo.h.f68705a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new fs.n()).map(new t(this.C));
        u.a R = R(ai.class);
        Stream map2 = map.map(new v(R instanceof ai ? (ai) R : null));
        u.a R2 = R(l.class);
        l lVar = R2 instanceof l ? (l) R2 : null;
        u.a R3 = R(ai.class);
        map2.map(new h(lVar, R3 instanceof ai ? (ai) R3 : null)).map(new UIThreadOffFunction(this)).subscribe(new j(this, action));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1() {
        this.f67794m.finish(-1, null, R.anim.dialog_exit, 0);
    }

    private final int M1() {
        return this.C.e();
    }

    private final int N1() {
        return this.C.k();
    }

    private final Function2<ZPlanEditPicPartManager, fs.b, Unit> O1(final Function2<? super ZPlanEditPicPartManager, ? super fs.b, Unit> action) {
        return new Function2<ZPlanEditPicPartManager, fs.b, Unit>() { // from class: com.tencent.aelight.camera.zplan.api.impl.ZPlanEditPicPartManager$prePublishWrapper$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ZPlanEditPicPartManager zPlanEditPicPartManager, fs.b bVar) {
                invoke2(zPlanEditPicPartManager, bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZPlanEditPicPartManager zPlanEditPicPartManager, fs.b context) {
                Intrinsics.checkNotNullParameter(zPlanEditPicPartManager, "<this>");
                Intrinsics.checkNotNullParameter(context, "context");
                aa aaVar = zPlanEditPicPartManager.f67794m;
                aaVar.dismissLoadingDialog();
                Activity activity = aaVar.getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                action.invoke(zPlanEditPicPartManager, context);
            }
        };
    }

    private final Function2<ZPlanEditPicPartManager, fs.b, Unit> P1() {
        return new Function2<ZPlanEditPicPartManager, fs.b, Unit>() { // from class: com.tencent.aelight.camera.zplan.api.impl.ZPlanEditPicPartManager$publishToAvatarAction$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ZPlanEditPicPartManager zPlanEditPicPartManager, fs.b bVar) {
                invoke2(zPlanEditPicPartManager, bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final ZPlanEditPicPartManager zPlanEditPicPartManager, fs.b context) {
                Intrinsics.checkNotNullParameter(zPlanEditPicPartManager, "$this$null");
                Intrinsics.checkNotNullParameter(context, "context");
                String generatedPicPath = context.f400395l.f400416b;
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                Intrinsics.checkNotNullExpressionValue(generatedPicPath, "generatedPicPath");
                iZPlanApi.setAvatarFromPeak(generatedPicPath, new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.zplan.api.impl.ZPlanEditPicPartManager$publishToAvatarAction$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        QLog.i("ZPlanEditPicPartManager", 1, "set to avatar callback called with result:" + z16);
                        if (z16) {
                            ZPlanEditPicPartManager.this.L1();
                        } else {
                            ZPlanEditPicPartManager.this.U0(new Error("[ZPlanEditPicPartManager] failed to set to avatar"));
                        }
                    }
                });
            }
        };
    }

    private final Function2<ZPlanEditPicPartManager, fs.b, Unit> Q1() {
        return new Function2<ZPlanEditPicPartManager, fs.b, Unit>() { // from class: com.tencent.aelight.camera.zplan.api.impl.ZPlanEditPicPartManager$publishToCustomEmoticonAction$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ZPlanEditPicPartManager zPlanEditPicPartManager, fs.b bVar) {
                invoke2(zPlanEditPicPartManager, bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final ZPlanEditPicPartManager zPlanEditPicPartManager, fs.b context) {
                Intrinsics.checkNotNullParameter(zPlanEditPicPartManager, "$this$null");
                Intrinsics.checkNotNullParameter(context, "context");
                String generatePicPath = context.f400395l.f400416b;
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                Intrinsics.checkNotNullExpressionValue(generatePicPath, "generatePicPath");
                iZPlanApi.addPicToCustomEmoticonFromPeak(generatePicPath, new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.zplan.api.impl.ZPlanEditPicPartManager$publishToCustomEmoticonAction$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        QLog.i("ZPlanEditPicPartManager", 1, "add to custom emoticon callback called with result:" + z16);
                        if (z16) {
                            ZPlanEditPicPartManager.this.L1();
                        } else {
                            ZPlanEditPicPartManager.this.U0(new Error("[ZPlanEditPicPartManager] failed to add to custom emoticon"));
                        }
                    }
                });
            }
        };
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager, com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void b1() {
        Function2<ZPlanEditPicPartManager, fs.b, Unit> Q1;
        int N1 = N1();
        if (N1 == 144) {
            Q1 = Q1();
        } else {
            if (N1 != 145) {
                U0(new Error("[ZPlanEditPicPartManager] publish with unsupported entrance type, check startActivity intent extras."));
                return;
            }
            Q1 = P1();
        }
        H1(O1(Q1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.k, com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager, com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void j0(EditVideoParams params) {
        List<u> K1;
        Intrinsics.checkNotNullParameter(params, "params");
        int i3 = params.f204057f & (-513);
        if (M1() != 16) {
            QLog.e("ZPlanEditPicPartManager", 1, "initEditVideoParts fail, business id invalid.");
            return;
        }
        int N1 = N1();
        if (N1 == 144) {
            K1 = K1(i3);
        } else if (N1 != 145) {
            K1 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            K1 = J1(this, 0, 1, null);
        }
        this.D = K1;
    }

    private final List<u> I1(int enableMask) {
        List<u> listOf;
        k kVar = new k(this, enableMask);
        this.E = kVar;
        Unit unit = Unit.INSTANCE;
        EditProviderPart editProviderPart = new EditProviderPart(this);
        this.H = editProviderPart;
        com.tencent.aelight.camera.aioeditor.takevideo.t tVar = new com.tencent.aelight.camera.aioeditor.takevideo.t(this, enableMask);
        this.I = tVar;
        ZPlanEditPicRawImage zPlanEditPicRawImage = new ZPlanEditPicRawImage(this, enableMask, 0);
        this.L = zPlanEditPicRawImage;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new u[]{kVar, editProviderPart, tVar, zPlanEditPicRawImage, new ZPlanPicBackgroundPart(this)});
        return listOf;
    }

    static /* synthetic */ List J1(ZPlanEditPicPartManager zPlanEditPicPartManager, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        return zPlanEditPicPartManager.I1(i3);
    }

    private final List<u> K1(int enableMask) {
        List<u> listOf;
        int i3 = enableMask | 8 | 1;
        m mVar = new m(this, i3);
        this.E = mVar;
        Unit unit = Unit.INSTANCE;
        EditProviderPart editProviderPart = new EditProviderPart(this);
        this.H = editProviderPart;
        com.tencent.aelight.camera.aioeditor.takevideo.t tVar = new com.tencent.aelight.camera.aioeditor.takevideo.t(this, i3);
        this.I = tVar;
        ZPlanEditPicRawImage zPlanEditPicRawImage = new ZPlanEditPicRawImage(this, i3, 1);
        this.L = zPlanEditPicRawImage;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new u[]{mVar, editProviderPart, tVar, zPlanEditPicRawImage});
        return listOf;
    }
}
