package pj4;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.o;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass$GetAnchorGameRoleListRsp;
import trpc.yes.common.GameDataServerOuterClass$SetAnchorGameEquipRoleRsp;
import trpc.yes.common.GameDataServerOuterClass$SmobaGameRoleAbsInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002ek\u0018\u0000 s2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001tB\u001f\u0012\u0006\u0010p\u001a\u00020o\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00105\u001a\u00020\u0011\u00a2\u0006\u0004\bq\u0010rJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\u0010\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!J\b\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0018H\u0016J\u001a\u0010*\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\bH\u0016J\u0006\u0010+\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\u0004R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0017\u00105\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00108\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010BR\u0018\u0010K\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010BR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010ER\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001a0R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u00102R$\u0010_\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010ER\u0018\u0010d\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010ER\u0014\u0010n\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010m\u00a8\u0006u"}, d2 = {"Lpj4/h;", "Lcom/tencent/timi/game/ui/widget/BaseSlideUpDialog;", "Landroid/view/View$OnClickListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "", "M0", "initView", "E0", "", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "F0", "y0", "", "", "x0", "D0", "J0", "", "index", "C0", "Q0", "N0", "checked", "L0", "Landroid/view/View;", "view", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleAbsInfo;", "info", "B0", "z0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lpj4/a;", "presenter", "H0", "dismiss", "v", NodeProps.ON_CLICK, "Landroid/widget/CompoundButton;", "buttonView", "isChecked", "onCheckedChanged", "hideLoadingView", "showLoadingView", "", "T", "J", "roomId", "U", "I", "getGameId", "()I", VirtualAppProxy.KEY_GAME_ID, "V", "Ljava/lang/String;", "TAG", "Landroid/view/ViewGroup;", "W", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/widget/Switch;", "X", "Lcom/tencent/widget/Switch;", "switchButton", "Y", "Landroid/view/View;", "roleInfoScrollView", "Landroid/widget/LinearLayout;", "Z", "Landroid/widget/LinearLayout;", "roleInfoListLinear", "a0", "accountTitleText", "b0", "closeEmptyView", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "c0", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "loadingView", "d0", "isFinished", "", "e0", "Ljava/util/List;", "roleList", "f0", "selectedRolePosition", "Lpj4/j;", "g0", "Lpj4/j;", "A0", "()Lpj4/j;", "I0", "(Lpj4/j;)V", "livingInscriptionSettingListener", "h0", "isOpenEquip", "i0", "Lpj4/a;", "livingInscriptionPresenter", "pj4/h$c", "j0", "Lpj4/h$c;", "roleListListener", "k0", "isReport", "pj4/h$b", "l0", "Lpj4/h$b;", "commitRoleListener", "Landroid/content/Context;", "dialogContext", "<init>", "(Landroid/content/Context;JI)V", "m0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class h extends BaseSlideUpDialog implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: T, reason: from kotlin metadata */
    private final long roomId;

    /* renamed from: U, reason: from kotlin metadata */
    private final int gameId;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private ViewGroup rootView;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private Switch switchButton;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private View roleInfoScrollView;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private LinearLayout roleInfoListLinear;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View accountTitleText;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View closeEmptyView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TimiGamePageLoadingView loadingView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isFinished;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<GameDataServerOuterClass$SmobaGameRoleAbsInfo> roleList;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int selectedRolePosition;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j livingInscriptionSettingListener;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean isOpenEquip;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a livingInscriptionPresenter;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c roleListListener;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean isReport;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b commitRoleListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"pj4/h$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$SetAnchorGameEquipRoleRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> {
        b() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable GameDataServerOuterClass$SetAnchorGameEquipRoleRsp result) {
            com.tencent.timi.game.ui.widget.f.a("\u51fa\u88c5\u94ed\u6587\u8bbe\u7f6e\u6210\u529f");
            if (!h.this.isFinished) {
                h.this.hideLoadingView();
                j livingInscriptionSettingListener = h.this.getLivingInscriptionSettingListener();
                if (livingInscriptionSettingListener != null) {
                    livingInscriptionSettingListener.a();
                }
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.ui.widget.f.c("\u5207\u6362\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002");
            if (!h.this.isFinished) {
                h.this.hideLoadingView();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"pj4/h$c", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetAnchorGameRoleListRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> {
        c() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable GameDataServerOuterClass$GetAnchorGameRoleListRsp result) {
            int i3;
            boolean z16;
            PBRepeatMessageField<GameDataServerOuterClass$SmobaGameRoleAbsInfo> pBRepeatMessageField;
            List<GameDataServerOuterClass$SmobaGameRoleAbsInfo> list;
            PBInt32Field pBInt32Field;
            if (!h.this.isFinished) {
                Switch r06 = h.this.switchButton;
                boolean z17 = true;
                if (r06 != null) {
                    fh4.g.o(r06, true);
                }
                if (result != null && (pBInt32Field = result.equip_status) != null) {
                    i3 = pBInt32Field.get();
                } else {
                    i3 = -1;
                }
                h.this.roleList.clear();
                if (result != null && (pBRepeatMessageField = result.role_list) != null && (list = pBRepeatMessageField.get()) != null) {
                    h.this.roleList.addAll(list);
                }
                h hVar = h.this;
                if (i3 != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                hVar.L0(z16);
                h.this.J0();
                h hVar2 = h.this;
                if (i3 == 0) {
                    z17 = false;
                }
                hVar2.isOpenEquip = z17;
                h.this.E0();
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            Switch r16;
            if (!h.this.isFinished && (r16 = h.this.switchButton) != null) {
                fh4.g.o(r16, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Context dialogContext, long j3, int i3) {
        super(dialogContext);
        Intrinsics.checkNotNullParameter(dialogContext, "dialogContext");
        this.roomId = j3;
        this.gameId = i3;
        this.TAG = "LivingInscriptionSettingDialog";
        this.roleList = new ArrayList();
        this.selectedRolePosition = -1;
        this.roleListListener = new c();
        this.commitRoleListener = new b();
    }

    private final void B0(View view, GameDataServerOuterClass$SmobaGameRoleAbsInfo info) {
        TextView textView = (TextView) view.findViewById(R.id.f7770453);
        if (textView != null) {
            textView.setText(info.role_name.get());
        }
        TextView textView2 = (TextView) view.findViewById(R.id.f776244v);
        if (textView2 != null) {
            textView2.setText(info.role_desc.get());
        }
    }

    private final void C0(int index) {
        boolean z16;
        int i3;
        this.selectedRolePosition = index;
        LinearLayout linearLayout = this.roleInfoListLinear;
        if (linearLayout != null) {
            int childCount = linearLayout.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                if (i16 == index) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i3 = R.drawable.o8u;
                } else {
                    i3 = R.drawable.o8t;
                }
                ImageView imageView = (ImageView) linearLayout.getChildAt(i16).findViewById(R.id.f81944fj);
                if (imageView != null) {
                    imageView.setImageResource(i3);
                }
            }
        }
    }

    private final void D0() {
        Switch r06 = this.switchButton;
        if (r06 != null) {
            fh4.g.o(r06, false);
        }
        a aVar = this.livingInscriptionPresenter;
        if (aVar != null) {
            aVar.c(this.roleListListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0() {
        String str;
        Map<String, String> mutableMapOf;
        if (this.isReport) {
            return;
        }
        View findViewById = findViewById(R.id.uhf);
        if (findViewById != null) {
            ((ug4.a) mm4.b.b(ug4.a.class)).b(findViewById, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, tk4.d.f436481a.d());
        }
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            ((ug4.a) mm4.b.b(ug4.a.class)).a(viewGroup, true, null, "em_qqlive_equipshow_board", x0());
        }
        Switch r132 = this.switchButton;
        if (r132 != null) {
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("zengzhi_moduleid", "em_qqlive_equipshow_entrance");
            if (y0()) {
                str = "1";
            } else {
                str = "0";
            }
            pairArr[1] = TuplesKt.to("qqlive_equip_status", str);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            ((ug4.a) mm4.b.b(ug4.a.class)).g(r132, true, null, "em_qqlive_equipshow_switch", mutableMapOf);
        }
        this.isReport = true;
    }

    private final void F0(boolean isOpen) {
        String str;
        Map<String, String> mutableMapOf;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("zengzhi_moduleid", "em_qqlive_equipshow_entrance");
        if (isOpen) {
            str = "1";
        } else {
            str = "0";
        }
        pairArr[1] = TuplesKt.to("qqlive_equip_status", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        Switch r06 = this.switchButton;
        if (r06 != null) {
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("clck", r06, mutableMapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0() {
        LinearLayout linearLayout = this.roleInfoListLinear;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        int b16 = fh4.b.b(80);
        final int i3 = 0;
        for (Object obj : this.roleList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GameDataServerOuterClass$SmobaGameRoleAbsInfo gameDataServerOuterClass$SmobaGameRoleAbsInfo = (GameDataServerOuterClass$SmobaGameRoleAbsInfo) obj;
            View view = LayoutInflater.from(this.G).inflate(R.layout.huv, (ViewGroup) null);
            view.setOnClickListener(new View.OnClickListener() { // from class: pj4.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    h.K0(h.this, i3, view2);
                }
            });
            if (gameDataServerOuterClass$SmobaGameRoleAbsInfo.is_default.get()) {
                this.selectedRolePosition = i3;
            }
            Intrinsics.checkNotNullExpressionValue(view, "view");
            B0(view, gameDataServerOuterClass$SmobaGameRoleAbsInfo);
            LinearLayout linearLayout2 = this.roleInfoListLinear;
            if (linearLayout2 != null) {
                linearLayout2.addView(view, new LinearLayout.LayoutParams(-1, b16));
            }
            i3 = i16;
        }
        if (this.selectedRolePosition == -1) {
            this.selectedRolePosition = 0;
        }
        C0(this.selectedRolePosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(h this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q0(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0(boolean checked) {
        Switch r06 = this.switchButton;
        if (r06 != null) {
            r06.setOnCheckedChangeListener(null);
        }
        Switch r07 = this.switchButton;
        if (r07 != null) {
            r07.setChecked(checked);
        }
        M0();
        Switch r36 = this.switchButton;
        if (r36 != null) {
            r36.setOnCheckedChangeListener(this);
        }
    }

    private final void M0() {
        boolean z16;
        Switch r06 = this.switchButton;
        if (r06 != null) {
            z16 = r06.isChecked();
        } else {
            z16 = false;
        }
        View view = this.accountTitleText;
        if (view != null) {
            fh4.g.o(view, z16);
        }
        View view2 = this.roleInfoScrollView;
        if (view2 != null) {
            fh4.g.o(view2, z16);
        }
        View view3 = this.closeEmptyView;
        if (view3 != null) {
            fh4.g.o(view3, !z16);
        }
    }

    private final void N0() {
        Context context = this.G;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        new e.a(context).j("\u662f\u5426\u5173\u95ed\u51fa\u88c5\u94ed\u6587\u5c55\u793a").n("\u53d6\u6d88").m(new DialogInterface.OnClickListener() { // from class: pj4.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h.O0(dialogInterface, i3);
            }
        }).p("\u786e\u8ba4").o(new DialogInterface.OnClickListener() { // from class: pj4.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h.P0(h.this, dialogInterface, i3);
            }
        }).c().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(h this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L0(false);
        this$0.z0();
    }

    private final void Q0(final int index) {
        if (index >= 0 && index <= this.roleList.size()) {
            String str = this.roleList.get(index).role_name.get();
            Context context = this.G;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            new e.a(context).j("\u786e\u8ba4\u5c06\u5c55\u793a\u7684\u6e38\u620f\u89d2\u8272\u4fee\u6539\u4e3a " + str + " \u5417\uff1f").n("\u53d6\u6d88").m(new DialogInterface.OnClickListener() { // from class: pj4.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    h.R0(dialogInterface, i3);
                }
            }).p("\u786e\u8ba4").o(new DialogInterface.OnClickListener() { // from class: pj4.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    h.S0(h.this, index, dialogInterface, i3);
                }
            }).c().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(h this$0, int i3, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.a()) {
            this$0.C0(i3);
            this$0.z0();
        }
    }

    private final void initView() {
        View findViewById = findViewById(R.id.enf);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = findViewById(R.id.f164823az2);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        this.roleInfoScrollView = findViewById(R.id.f776644z);
        this.switchButton = (Switch) findViewById(R.id.f911354c);
        this.roleInfoListLinear = (LinearLayout) findViewById(R.id.f776544y);
        this.accountTitleText = findViewById(R.id.s7x);
        this.closeEmptyView = findViewById(R.id.tz_);
        this.rootView = (ViewGroup) findViewById(R.id.iet);
        this.loadingView = (TimiGamePageLoadingView) findViewById(R.id.ef6);
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            e0(viewGroup);
        }
        D0();
    }

    private final Map<String, String> x0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zengzhi_moduleid", "em_qqlive_equipshow_entrance");
        return linkedHashMap;
    }

    private final boolean y0() {
        Switch r06 = this.switchButton;
        if (r06 != null) {
            return r06.isChecked();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [pj4.a] */
    private final void z0() {
        ?? r16;
        int i3 = this.selectedRolePosition;
        if (i3 >= 0 && i3 < this.roleList.size()) {
            GameDataServerOuterClass$SmobaGameRoleAbsInfo gameDataServerOuterClass$SmobaGameRoleAbsInfo = this.roleList.get(this.selectedRolePosition);
            Switch r17 = this.switchButton;
            if (r17 != null) {
                r16 = r17.isChecked();
            } else {
                r16 = 1;
            }
            showLoadingView();
            ?? r26 = this.livingInscriptionPresenter;
            if (r26 != 0) {
                r26.d(gameDataServerOuterClass$SmobaGameRoleAbsInfo.area.get(), gameDataServerOuterClass$SmobaGameRoleAbsInfo.partition.get(), r16, this.commitRoleListener);
            }
        }
    }

    @Nullable
    /* renamed from: A0, reason: from getter */
    public final j getLivingInscriptionSettingListener() {
        return this.livingInscriptionSettingListener;
    }

    public final void H0(@Nullable a presenter) {
        this.livingInscriptionPresenter = presenter;
    }

    public final void I0(@Nullable j jVar) {
        this.livingInscriptionSettingListener = jVar;
    }

    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.isFinished = true;
        super.dismiss();
    }

    public final void hideLoadingView() {
        TimiGamePageLoadingView timiGamePageLoadingView = this.loadingView;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.c();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@Nullable CompoundButton buttonView, boolean isChecked) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, isChecked);
        F0(!isChecked);
        if (!isChecked) {
            L0(true);
            N0();
        } else {
            M0();
            z0();
        }
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, isChecked);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.a()) {
            int id5 = v3.getId();
            boolean z16 = true;
            if (id5 != R.id.enf && id5 != R.id.f164823az2) {
                z16 = false;
            }
            if (z16) {
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huw);
        initView();
    }

    public final void showLoadingView() {
        TimiGamePageLoadingView timiGamePageLoadingView = this.loadingView;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.setHintText(R.string.f23156727);
        }
        TimiGamePageLoadingView timiGamePageLoadingView2 = this.loadingView;
        if (timiGamePageLoadingView2 != null) {
            timiGamePageLoadingView2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(DialogInterface dialogInterface, int i3) {
    }
}
