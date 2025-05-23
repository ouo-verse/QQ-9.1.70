package com.tencent.icgame.game.liveroom.impl.room.profile;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.profile.b;
import com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qw0.k;
import tw0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 82\u00020\u00012\u00020\u0002:\u0001_J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0017H\u0004J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019J \u0010 \u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0004J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\rH\u0016J\u0006\u0010$\u001a\u00020\rJ\u0010\u0010&\u001a\u00020\r2\u0006\u0010\"\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\rH\u0016R\u001a\u0010-\u001a\u00020(8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00103\u001a\u00020.8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00106\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001a\u0010\u0004\u001a\u00020\u00038\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010@\u001a\u00020;8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010AR\"\u0010D\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR$\u0010U\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020\n0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u00108R\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]\u00a8\u0006`"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/profile/b;", "Landroid/widget/PopupWindow;", "Landroid/view/View$OnClickListener;", "", "roomId", "j", "", ReportConstant.COSTREPORT_PREFIX, "", "strResId", "", "r", "itemStr", "", "u", "y", "menuId", "isAllowChat", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isSetAdmin", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "Ltw0/b$a;", "listener", "D", "type", "", "Lcom/tencent/mobileqq/qqlive/data/room/AdminReason;", "list", HippyTKDListViewAdapter.X, "t", "v", "w", "l", "Landroid/view/View;", NodeProps.ON_CLICK, "dismiss", "Lhx0/a;", "d", "Lhx0/a;", "o", "()Lhx0/a;", "liveUserInfo", "Landroid/content/Context;", "e", "Landroid/content/Context;", DomainData.DOMAIN_NAME, "()Landroid/content/Context;", "dialogContext", "f", "Landroid/view/View;", "blurBackgroundView", tl.h.F, "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()J", "Lpw0/b;", "i", "Lpw0/b;", "getAnchorJudgeStrategy", "()Lpw0/b;", "anchorJudgeStrategy", "Ljava/lang/String;", "TAG", "Z", "isDismiss", "()Z", "setDismiss", "(Z)V", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "E", "Ltw0/b$a;", "itemClickListener", "Ltw0/b;", UserInfo.SEX_FEMALE, "Ltw0/b;", "p", "()Ltw0/b;", "setOperateDialog", "(Ltw0/b;)V", "operateDialog", "G", "Ljava/util/List;", "reportReasonList", "H", "myUserId", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/i;", "I", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/i;", "manageDialog", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class b extends PopupWindow implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isDismiss;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private b.a itemClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private tw0.b operateDialog;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<String> reportReasonList;

    /* renamed from: H, reason: from kotlin metadata */
    private long myUserId;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i manageDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final hx0.a liveUserInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context dialogContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View blurBackgroundView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final pw0.b anchorJudgeStrategy;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/profile/b$b", "Lqw0/k$e;", "", "isForbidden", "", "onResult", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.profile.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5840b implements k.e {
        C5840b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(C5840b this$0, b this$1, int i3, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$1.u(str);
            com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar = this$1.manageDialog;
            Intrinsics.checkNotNull(iVar);
            iVar.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(C5840b this$0, b this$1, int i3, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$1.u(str);
            com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar = this$1.manageDialog;
            Intrinsics.checkNotNull(iVar);
            iVar.dismiss();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0117  */
        /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        @Override // qw0.k.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(boolean isForbidden) {
            b bVar;
            int i3;
            String str;
            String[] strArr;
            if (isForbidden) {
                bVar = b.this;
                i3 = R.string.zib;
            } else {
                bVar = b.this;
                i3 = R.string.f1355701t;
            }
            String r16 = bVar.r(i3);
            if (b.this.s()) {
                b.this.manageDialog = new com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i();
                if (b.this.getLiveUserInfo().f406545f) {
                    strArr = new String[]{r16, b.this.r(R.string.f168152ev), b.this.r(R.string.zig)};
                } else {
                    strArr = new String[]{r16, b.this.r(R.string.f168152ev), b.this.r(R.string.f225526lv)};
                }
                com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar = b.this.manageDialog;
                Intrinsics.checkNotNull(iVar);
                iVar.k(strArr);
                com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar2 = b.this.manageDialog;
                Intrinsics.checkNotNull(iVar2);
                final b bVar2 = b.this;
                iVar2.l(new i.e() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.c
                    @Override // com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i.e
                    public final void a(int i16, String str2) {
                        b.C5840b.c(b.C5840b.this, bVar2, i16, str2);
                    }
                });
                com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar3 = b.this.manageDialog;
                Intrinsics.checkNotNull(iVar3);
                Context dialogContext = b.this.getDialogContext();
                Intrinsics.checkNotNull(dialogContext, "null cannot be cast to non-null type android.app.Activity");
                iVar3.show(((Activity) dialogContext).getFragmentManager(), "onThirdButtonClick");
                b.this.dismiss();
            } else if (b.this.getLiveUserInfo().f406545f) {
                b.this.manageDialog = new com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i();
                String[] strArr2 = {r16, b.this.r(R.string.f168152ev)};
                com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar4 = b.this.manageDialog;
                Intrinsics.checkNotNull(iVar4);
                iVar4.k(strArr2);
                com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar5 = b.this.manageDialog;
                Intrinsics.checkNotNull(iVar5);
                final b bVar3 = b.this;
                iVar5.l(new i.e() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.d
                    @Override // com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i.e
                    public final void a(int i16, String str2) {
                        b.C5840b.d(b.C5840b.this, bVar3, i16, str2);
                    }
                });
                com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar6 = b.this.manageDialog;
                Intrinsics.checkNotNull(iVar6);
                Context dialogContext2 = b.this.getDialogContext();
                Intrinsics.checkNotNull(dialogContext2, "null cannot be cast to non-null type android.app.Activity");
                iVar6.show(((Activity) dialogContext2).getFragmentManager(), "onThirdButtonClick");
                b.this.dismiss();
                str = "pg_icgame_audience";
                if (b.this.manageDialog == null) {
                    com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar7 = b.this.manageDialog;
                    Intrinsics.checkNotNull(iVar7);
                    if (iVar7.getView() != null) {
                        ru0.a aVar = (ru0.a) qx0.a.b(ru0.a.class);
                        com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar8 = b.this.manageDialog;
                        Intrinsics.checkNotNull(iVar8);
                        View view = iVar8.getView();
                        Intrinsics.checkNotNull(view);
                        aVar.b(view, str, b.this.k());
                        ru0.a aVar2 = (ru0.a) qx0.a.b(ru0.a.class);
                        com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar9 = b.this.manageDialog;
                        Intrinsics.checkNotNull(iVar9);
                        View view2 = iVar9.getView();
                        Intrinsics.checkNotNull(view2);
                        aVar2.a(view2, true, null, "em_icgame_manage_users_page", b.this.k());
                        return;
                    }
                    return;
                }
                return;
            }
            str = "pg_icgame_anchorlive_show";
            if (b.this.manageDialog == null) {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/profile/b$c", "Lqw0/k$d;", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "map", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements k.d {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(c this$0, b this$1, LinkedHashMap map, com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i slidingDialog, int i3, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(map, "$map");
            Intrinsics.checkNotNullParameter(slidingDialog, "$slidingDialog");
            Object obj = map.get(str);
            Intrinsics.checkNotNull(obj);
            this$1.A(((Number) obj).intValue(), false);
            slidingDialog.dismiss();
        }

        @Override // qw0.k.d
        public void a(@NotNull final LinkedHashMap<String, Integer> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            final com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar = new com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i();
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getKey());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            iVar.k((String[]) array);
            final b bVar = b.this;
            iVar.l(new i.e() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.e
                @Override // com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i.e
                public final void a(int i3, String str) {
                    b.c.c(b.c.this, bVar, map, iVar, i3, str);
                }
            });
            Context dialogContext = b.this.getDialogContext();
            Intrinsics.checkNotNull(dialogContext, "null cannot be cast to non-null type android.app.Activity");
            iVar.show(((Activity) dialogContext).getFragmentManager(), "performBanned");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/profile/b$d", "Lqw0/k$d;", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "map", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d implements k.d {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(d this$0, com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i slidingDialog, b this$1, LinkedHashMap map, int i3, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(slidingDialog, "$slidingDialog");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(map, "$map");
            Context dialogContext = this$1.getDialogContext();
            Intrinsics.checkNotNull(dialogContext, "null cannot be cast to non-null type android.app.Activity");
            long j3 = this$1.j(this$1.getRoomId());
            long j16 = this$1.myUserId;
            long j17 = this$1.getLiveUserInfo().uid;
            String str2 = this$1.getLiveUserInfo().nick;
            long roomId = this$1.getRoomId();
            Object obj = map.get(str);
            Intrinsics.checkNotNull(obj);
            k.E((Activity) dialogContext, j3, j16, j17, str2, roomId, ((Number) obj).intValue(), str);
            slidingDialog.dismiss();
        }

        @Override // qw0.k.d
        public void a(@NotNull final LinkedHashMap<String, Integer> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            final com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar = new com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i();
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getKey());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            iVar.k((String[]) array);
            final b bVar = b.this;
            iVar.l(new i.e() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.f
                @Override // com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i.e
                public final void a(int i3, String str) {
                    b.d.c(b.d.this, iVar, bVar, map, i3, str);
                }
            });
            Context dialogContext = b.this.getDialogContext();
            Intrinsics.checkNotNull(dialogContext, "null cannot be cast to non-null type android.app.Activity");
            iVar.show(((Activity) dialogContext).getFragmentManager(), "performKickOut");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(int menuId, boolean isAllowChat) {
        k.B(this.liveUserInfo.uid, this.roomId, menuId, isAllowChat, new k.h() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.a
            @Override // qw0.k.h
            public final void onResult(boolean z16) {
                b.B(z16);
            }
        });
    }

    private final void C(boolean isSetAdmin) {
        Context context = this.dialogContext;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        k.C((Activity) context, isSetAdmin, j(this.roomId), this.liveUserInfo.uid, this.roomId, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long j(long roomId) {
        return this.anchorJudgeStrategy.acquireAnchorUid(roomId);
    }

    private final void m() {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : this.reportReasonList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new AdminReason(i3, (String) obj));
            i3 = i16;
        }
        x(3, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String r(int strResId) {
        String string = this.dialogContext.getString(strResId);
        Intrinsics.checkNotNullExpressionValue(string, "dialogContext.getString(strResId)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s() {
        if (this.myUserId == j(this.roomId)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String itemStr) {
        if (Intrinsics.areEqual(itemStr, r(R.string.f1355701t))) {
            y();
            return;
        }
        if (Intrinsics.areEqual(itemStr, r(R.string.zib))) {
            A(0, true);
            return;
        }
        if (Intrinsics.areEqual(itemStr, r(R.string.f168152ev))) {
            z();
        } else if (Intrinsics.areEqual(itemStr, r(R.string.f225526lv))) {
            C(true);
        } else if (Intrinsics.areEqual(itemStr, r(R.string.zig))) {
            C(false);
        }
    }

    private final void y() {
        k.l(1, new c());
    }

    private final void z() {
        k.l(2, new d());
    }

    public final void D(@NotNull b.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemClickListener = listener;
        tw0.b bVar = this.operateDialog;
        if (bVar != null) {
            bVar.k0(listener);
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        this.isDismiss = true;
        super.dismiss();
        com.tencent.icgame.game.liveroom.impl.room.followguide.a.c(hashCode(), false);
    }

    @NotNull
    protected final Map<String, String> k() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zengzhi_moduleid", "em_icgame_inf_module");
        return linkedHashMap;
    }

    public final void l() {
        com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.i iVar = this.manageDialog;
        if (iVar != null) {
            iVar.dismissAllowingStateLoss();
        }
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    protected final Context getDialogContext() {
        return this.dialogContext;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    protected final hx0.a getLiveUserInfo() {
        return this.liveUserInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.a()) {
            int id5 = v3.getId();
            if (id5 == R.id.f73353tb) {
                m();
                dismiss();
            } else if (id5 == R.id.f164823az2) {
                dismiss();
            } else if (id5 == R.id.v6m) {
                t();
            } else if (id5 == R.id.f81624eo) {
                v();
            } else if (id5 == R.id.f96465hr) {
                w();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final tw0.b getOperateDialog() {
        return this.operateDialog;
    }

    /* renamed from: q, reason: from getter */
    protected final long getRoomId() {
        return this.roomId;
    }

    public void w() {
        k.n(this.liveUserInfo.uid, this.roomId, new C5840b());
    }

    protected final void x(int type, @Nullable List<? extends AdminReason> list) {
        if (list != null && !list.isEmpty()) {
            tw0.b bVar = new tw0.b(type, list, this.dialogContext, this.blurBackgroundView);
            this.operateDialog = bVar;
            bVar.k0(this.itemClickListener);
            tw0.b bVar2 = this.operateDialog;
            if (bVar2 != null) {
                bVar2.show();
                return;
            }
            return;
        }
        this.mAegisLog.e(this.TAG, "forbiddenSpeech error " + list);
    }

    public void t() {
    }

    public void v() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(boolean z16) {
    }
}
