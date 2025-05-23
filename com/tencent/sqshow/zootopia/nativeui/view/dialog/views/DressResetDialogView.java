package com.tencent.sqshow.zootopia.nativeui.view.dialog.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.dialog.views.actionsheet.AvatarActionSheetDialogView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l94.AvatarActionSheetDialogCustomData;
import l94.AvatarActionSheetDialogMenuItem;
import m94.DressErrorMsg;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/DressResetDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/actionsheet/AvatarActionSheetDialogView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "H", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DressResetDialogView extends AvatarActionSheetDialogView {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/DressResetDialogView$a;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", "b", "Ll94/b;", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.DressResetDialogView$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/DressResetDialogView$a$a", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.DressResetDialogView$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9823a implements l94.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371800a;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/DressResetDialogView$a$a$a", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.DressResetDialogView$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes34.dex */
            public static final class C9824a implements m94.h {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371801a;

                C9824a(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
                    this.f371801a = jVar;
                }

                @Override // m94.h
                public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                }

                @Override // m94.h
                public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    DressResetDialogView.INSTANCE.b(this.f371801a);
                }
            }

            C9823a(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
                this.f371800a = jVar;
            }

            @Override // l94.e
            public void a(int menuType, int menuId, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                ZplanViewReportHelper.f(this.f371800a.getReporter().getMReporter(), view, "em_zplan_backtoprevious", null, 4, null);
                b94.d avatarDressController = this.f371800a.getAvatarDressController();
                if (avatarDressController != null) {
                    avatarDressController.Ob(new C9824a(this.f371800a));
                }
            }

            @Override // l94.e
            public void b(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.f371800a.getReporter().getMReporter().g(view, "em_zplan_backtoprevious", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/DressResetDialogView$a$b", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.DressResetDialogView$a$b */
        /* loaded from: classes34.dex */
        public static final class b implements l94.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371802a;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/DressResetDialogView$a$b$a", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.DressResetDialogView$a$b$a, reason: collision with other inner class name */
            /* loaded from: classes34.dex */
            public static final class C9825a implements m94.h {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371803a;

                C9825a(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
                    this.f371803a = jVar;
                }

                @Override // m94.h
                public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                }

                @Override // m94.h
                public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    DressResetDialogView.INSTANCE.b(this.f371803a);
                }
            }

            b(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
                this.f371802a = jVar;
            }

            @Override // l94.e
            public void a(int menuType, int menuId, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                ZplanViewReportHelper.f(this.f371802a.getReporter().getMReporter(), view, "em_zplan_avatar_reset", null, 4, null);
                b94.d avatarDressController = this.f371802a.getAvatarDressController();
                if (avatarDressController != null) {
                    avatarDressController.v8(new C9825a(this.f371802a));
                }
            }

            @Override // l94.e
            public void b(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.f371802a.getReporter().getMReporter().g(view, "em_zplan_avatar_reset", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
            channel.k().setValue(null);
        }

        Companion() {
        }

        public final AvatarActionSheetDialogCustomData c(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AvatarActionSheetDialogMenuItem(2, 1, "\u6062\u590d\u4e0a\u4e00\u6b21\u7684\u5f62\u8c61", new C9823a(channel), null, 16, null));
            arrayList.add(new AvatarActionSheetDialogMenuItem(2, 2, "\u91cd\u7f6e\u5f62\u8c61", new b(channel), null, 16, null));
            return new AvatarActionSheetDialogCustomData("", arrayList, null, null, 12, null);
        }
    }

    public /* synthetic */ DressResetDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressResetDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(context, attributeSet, i3, channel, INSTANCE.c(channel));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
    }
}
