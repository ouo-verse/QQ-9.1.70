package com.tencent.sqshow.zootopia.nativeui.view.dialog.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import b94.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.common.ResetFrom;
import com.tencent.sqshow.zootopia.nativeui.dialog.views.actionsheet.AvatarActionSheetDialogView;
import com.tencent.sqshow.zootopia.nativeui.ue.t;
import g94.FaceResetInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l94.AvatarActionSheetDialogCustomData;
import l94.AvatarActionSheetDialogMenuItem;
import l94.e;
import s94.FaceInfoSyncData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/FaceResetDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/actionsheet/AvatarActionSheetDialogView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "H", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FaceResetDialogView extends AvatarActionSheetDialogView {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/FaceResetDialogView$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Ll94/b;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.FaceResetDialogView$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/FaceResetDialogView$a$a", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.FaceResetDialogView$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9826a implements l94.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371804a;

            C9826a(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
                this.f371804a = jVar;
            }

            @Override // l94.e
            public void a(int menuType, int menuId, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                t avatarFaceController = this.f371804a.getAvatarFaceController();
                if (avatarFaceController != null) {
                    t avatarFaceController2 = this.f371804a.getAvatarFaceController();
                    avatarFaceController.k(-1, avatarFaceController2 != null ? avatarFaceController2.e() : null);
                }
                b94.a engineApi = this.f371804a.getEngineApi();
                FaceInfoSyncData.Companion companion = FaceInfoSyncData.INSTANCE;
                t avatarFaceController3 = this.f371804a.getAvatarFaceController();
                a.C0113a.j(engineApi, companion.b(avatarFaceController3 != null ? avatarFaceController3.e() : null), null, 2, null);
                g94.e.f401573a.d(new FaceResetInfo(false, ResetFrom.FROM_SAVED));
                ZplanViewReportHelper.f(this.f371804a.getReporter().getMReporter(), view, "em_zplan_reset_sculpt_operate", null, 4, null);
            }

            @Override // l94.e
            public void b(View view) {
                e.a.a(this, view);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/FaceResetDialogView$a$b", "Ll94/d;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.FaceResetDialogView$a$b */
        /* loaded from: classes34.dex */
        public static final class b implements l94.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371805a;

            b(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
                this.f371805a = jVar;
            }

            @Override // l94.d
            public void a(int menuType, int menuId, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.f371805a.getReporter().getMReporter().g(view, "em_zplan_reset_sculpt_operate", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/FaceResetDialogView$a$c", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.FaceResetDialogView$a$c */
        /* loaded from: classes34.dex */
        public static final class c implements l94.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371806a;

            c(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
                this.f371806a = jVar;
            }

            @Override // l94.e
            public void a(int menuType, int menuId, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                t avatarFaceController = this.f371806a.getAvatarFaceController();
                if (avatarFaceController != null) {
                    t avatarFaceController2 = this.f371806a.getAvatarFaceController();
                    avatarFaceController.k(-1, avatarFaceController2 != null ? avatarFaceController2.g() : null);
                }
                b94.a engineApi = this.f371806a.getEngineApi();
                FaceInfoSyncData.Companion companion = FaceInfoSyncData.INSTANCE;
                t avatarFaceController3 = this.f371806a.getAvatarFaceController();
                a.C0113a.j(engineApi, companion.b(avatarFaceController3 != null ? avatarFaceController3.g() : null), null, 2, null);
                g94.e.f401573a.d(new FaceResetInfo(false, "default"));
                ZplanViewReportHelper.f(this.f371806a.getReporter().getMReporter(), view, "em_zplan_reset_default_face", null, 4, null);
            }

            @Override // l94.e
            public void b(View view) {
                e.a.a(this, view);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/views/FaceResetDialogView$a$d", "Ll94/d;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.FaceResetDialogView$a$d */
        /* loaded from: classes34.dex */
        public static final class d implements l94.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371807a;

            d(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
                this.f371807a = jVar;
            }

            @Override // l94.d
            public void a(int menuType, int menuId, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.f371807a.getReporter().getMReporter().g(view, "em_zplan_reset_default_face", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final AvatarActionSheetDialogCustomData a(Context context, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channel, "channel");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AvatarActionSheetDialogMenuItem(2, 1, "\u91cd\u7f6e\u634f\u8138\u6548\u679c", new C9826a(channel), new b(channel)));
            arrayList.add(new AvatarActionSheetDialogMenuItem(2, 2, "\u6062\u590d\u9ed8\u8ba4\u8138\u578b", new c(channel), new d(channel)));
            return new AvatarActionSheetDialogCustomData("", arrayList, null, "pg_zplan_avatar_sculpt", 4, null);
        }
    }

    public /* synthetic */ FaceResetDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceResetDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(context, attributeSet, i3, channel, INSTANCE.a(context, channel));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
    }
}
