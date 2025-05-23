package com.tencent.mobileqq.troop.jointype.parts;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fR,\u0010\u0015\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0010j\b\u0012\u0004\u0012\u00020\r`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010\u001c\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/parts/g;", "Lcom/tencent/mobileqq/troop/jointype/parts/a;", "", "configJoinType", "", "isSelected", "", "K9", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "C9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "mainJoinTypeConfigs", "f", "mainJoinTypeGroups", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$i;", tl.h.F, "Lcom/tencent/mobileqq/widget/listitem/x;", "allowAllJoinConfig", "i", "allowNoOneJoinConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "needVerifyJoinConfig", BdhLogUtil.LogTag.Tag_Conn, "I", "selectedJoinType", "D", "selectedJoinTypeConfig", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private int selectedJoinType;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> selectedJoinTypeConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> mainJoinTypeConfigs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Group> mainJoinTypeGroups;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> allowAllJoinConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> allowNoOneJoinConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> needVerifyJoinConfig;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mainJoinTypeConfigs = new ArrayList<>();
        this.mainJoinTypeGroups = new ArrayList<>();
        this.selectedJoinType = -1;
    }

    private final void I9(final int configJoinType) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar = this.selectedJoinTypeConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedJoinTypeConfig");
            xVar = null;
        }
        xVar.O().e(null);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar3 = this.selectedJoinTypeConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedJoinTypeConfig");
            xVar3 = null;
        }
        xVar3.O().f(true);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar4 = this.selectedJoinTypeConfig;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedJoinTypeConfig");
            xVar4 = null;
        }
        xVar4.O().e(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.jointype.parts.f
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                g.J9(g.this, configJoinType, view, z16);
            }
        });
        QUIListItemAdapter x95 = x9();
        if (x95 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar5 = this.selectedJoinTypeConfig;
            if (xVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedJoinTypeConfig");
            } else {
                xVar2 = xVar5;
            }
            x95.l0(xVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(g this$0, int i3, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.K9(i3, z16);
    }

    private final void K9(int configJoinType, boolean isSelected) {
        if (isSelected) {
            final int i3 = this.selectedJoinType;
            if (i3 == configJoinType) {
                return;
            }
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar = this.selectedJoinTypeConfig;
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar2 = null;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedJoinTypeConfig");
                xVar = null;
            }
            xVar.O().e(null);
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar3 = this.selectedJoinTypeConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedJoinTypeConfig");
                xVar3 = null;
            }
            xVar3.O().f(false);
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar4 = this.selectedJoinTypeConfig;
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedJoinTypeConfig");
                xVar4 = null;
            }
            xVar4.O().e(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.jointype.parts.e
                @Override // com.tencent.mobileqq.widget.listitem.h
                public final void a(View view, boolean z16) {
                    g.L9(g.this, i3, view, z16);
                }
            });
            QUIListItemAdapter x95 = x9();
            if (x95 != null) {
                com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar5 = this.selectedJoinTypeConfig;
                if (xVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedJoinTypeConfig");
                    xVar5 = null;
                }
                x95.l0(xVar5);
            }
            this.selectedJoinType = configJoinType;
            A9().Y2(this.selectedJoinType);
            int i16 = this.selectedJoinType;
            if (i16 != 1) {
                if (i16 != 3) {
                    com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar6 = this.needVerifyJoinConfig;
                    if (xVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("needVerifyJoinConfig");
                    } else {
                        xVar2 = xVar6;
                    }
                    this.selectedJoinTypeConfig = xVar2;
                    return;
                }
                com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar7 = this.allowNoOneJoinConfig;
                if (xVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("allowNoOneJoinConfig");
                } else {
                    xVar2 = xVar7;
                }
                this.selectedJoinTypeConfig = xVar2;
                return;
            }
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar8 = this.allowAllJoinConfig;
            if (xVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("allowAllJoinConfig");
            } else {
                xVar2 = xVar8;
            }
            this.selectedJoinTypeConfig = xVar2;
            return;
        }
        I9(configJoinType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(g this$0, int i3, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.K9(i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(g this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.K9(1, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(g this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.K9(3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(g this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.K9(2, z16);
    }

    @Override // com.tencent.mobileqq.troop.jointype.parts.a
    @NotNull
    public Group[] C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Group[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Object[] array = this.mainJoinTypeGroups.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Group[]) array;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        boolean z16;
        boolean z17;
        boolean z18;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.selectedJoinType = A9().h2();
        x.b.d dVar = new x.b.d("\u5141\u8bb8\u4efb\u4f55\u4eba\u52a0\u7fa4");
        if (this.selectedJoinType == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.allowAllJoinConfig = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.i(z16, new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.jointype.parts.b
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z19) {
                g.M9(g.this, view, z19);
            }
        }));
        x.b.d dVar2 = new x.b.d("\u4e0d\u5141\u8bb8\u4efb\u4f55\u4eba\u52a0\u7fa4");
        if (this.selectedJoinType == 3) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.allowNoOneJoinConfig = new com.tencent.mobileqq.widget.listitem.x<>(dVar2, new x.c.i(z17, new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.jointype.parts.c
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z19) {
                g.N9(g.this, view, z19);
            }
        }));
        x.b.d dVar3 = new x.b.d("\u9700\u8981\u8eab\u4efd\u9a8c\u8bc1");
        int i3 = this.selectedJoinType;
        if (i3 != 2 && i3 != 4 && i3 != 5) {
            z18 = false;
        } else {
            z18 = true;
        }
        this.needVerifyJoinConfig = new com.tencent.mobileqq.widget.listitem.x<>(dVar3, new x.c.i(z18, new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.jointype.parts.d
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z19) {
                g.O9(g.this, view, z19);
            }
        }));
        ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> arrayList = this.mainJoinTypeConfigs;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar2 = this.allowAllJoinConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar3 = null;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allowAllJoinConfig");
            xVar2 = null;
        }
        arrayList.add(xVar2);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar4 = this.allowNoOneJoinConfig;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allowNoOneJoinConfig");
            xVar4 = null;
        }
        arrayList.add(xVar4);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar5 = this.needVerifyJoinConfig;
        if (xVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("needVerifyJoinConfig");
            xVar5 = null;
        }
        arrayList.add(xVar5);
        ArrayList<Group> arrayList2 = this.mainJoinTypeGroups;
        Object[] array = this.mainJoinTypeConfigs.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        arrayList2.add(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
        int i16 = this.selectedJoinType;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    xVar = this.needVerifyJoinConfig;
                    if (xVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("needVerifyJoinConfig");
                    }
                    xVar3 = xVar;
                } else {
                    xVar = this.allowNoOneJoinConfig;
                    if (xVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("allowNoOneJoinConfig");
                    }
                    xVar3 = xVar;
                }
            } else {
                xVar = this.needVerifyJoinConfig;
                if (xVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("needVerifyJoinConfig");
                }
                xVar3 = xVar;
            }
        } else {
            xVar = this.allowAllJoinConfig;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("allowAllJoinConfig");
            }
            xVar3 = xVar;
        }
        this.selectedJoinTypeConfig = xVar3;
    }
}
