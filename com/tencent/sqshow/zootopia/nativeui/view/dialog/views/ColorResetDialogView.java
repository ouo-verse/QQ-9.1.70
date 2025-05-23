package com.tencent.sqshow.zootopia.nativeui.view.dialog.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.dialog.views.actionsheet.AvatarActionSheetDialogView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l94.AvatarActionSheetDialogCustomData;
import l94.AvatarActionSheetDialogMenuItem;
import l94.e;
import m94.DressErrorMsg;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/ColorResetDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/actionsheet/AvatarActionSheetDialogView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "targetSlot", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;I)V", "H", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ColorResetDialogView extends AvatarActionSheetDialogView {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/ColorResetDialogView$a;", "", "", "targetSlot", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Ll94/b;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ColorResetDialogView$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/ColorResetDialogView$a$a", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ColorResetDialogView$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9820a implements l94.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371796a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f371797b;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/ColorResetDialogView$a$a$a", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ColorResetDialogView$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes34.dex */
            public static final class C9821a implements m94.h {
                C9821a() {
                }

                @Override // m94.h
                public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                }

                @Override // m94.h
                public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                }
            }

            C9820a(com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i3) {
                this.f371796a = jVar;
                this.f371797b = i3;
            }

            @Override // l94.e
            public void a(int menuType, int menuId, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                ZplanViewReportHelper.f(this.f371796a.getReporter().getMReporter(), view, "em_zplan_backtoprevious", null, 4, null);
                b94.d avatarDressController = this.f371796a.getAvatarDressController();
                if (avatarDressController != null) {
                    avatarDressController.q9(this.f371797b, new C9821a());
                }
            }

            @Override // l94.e
            public void b(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.f371796a.getReporter().getMReporter().g(view, "em_zplan_backtoprevious", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/ColorResetDialogView$a$b", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ColorResetDialogView$a$b */
        /* loaded from: classes34.dex */
        public static final class b implements l94.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371798a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f371799b;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/ColorResetDialogView$a$b$a", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ColorResetDialogView$a$b$a, reason: collision with other inner class name */
            /* loaded from: classes34.dex */
            public static final class C9822a implements m94.h {
                C9822a() {
                }

                @Override // m94.h
                public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                }

                @Override // m94.h
                public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                }
            }

            b(com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i3) {
                this.f371798a = jVar;
                this.f371799b = i3;
            }

            @Override // l94.e
            public void a(int menuType, int menuId, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                ZplanViewReportHelper.f(this.f371798a.getReporter().getMReporter(), view, "em_zplan_avatar_reset", null, 4, null);
                b94.d avatarDressController = this.f371798a.getAvatarDressController();
                if (avatarDressController != null) {
                    avatarDressController.ke(this.f371799b, new C9822a());
                }
            }

            @Override // l94.e
            public void b(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                e.a.a(this, view);
                this.f371798a.getReporter().getMReporter().g(view, "em_zplan_avatar_reset", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final AvatarActionSheetDialogCustomData a(int targetSlot, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            QLog.i("ColorResetDialogView_", 1, "getData :: targetSlot == " + targetSlot);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AvatarActionSheetDialogMenuItem(2, 1, "\u6062\u590d\u4e0a\u4e00\u6b21\u914d\u8272", new C9820a(channel, targetSlot), null, 16, null));
            arrayList.add(new AvatarActionSheetDialogMenuItem(2, 2, "\u91cd\u7f6e\u914d\u8272", new b(channel, targetSlot), null, 16, null));
            return new AvatarActionSheetDialogCustomData("", arrayList, null, "pg_zplan_avatar_dye", 4, null);
        }
    }

    public /* synthetic */ ColorResetDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, jVar, i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorResetDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel, int i16) {
        super(context, attributeSet, i3, channel, INSTANCE.a(i16, channel));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
    }
}
