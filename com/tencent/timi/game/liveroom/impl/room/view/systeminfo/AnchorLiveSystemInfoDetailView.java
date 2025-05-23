package com.tencent.timi.game.liveroom.impl.room.view.systeminfo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomBaseCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.anchor.room.AnchorLiveSystemInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.livewebdialog.e;
import com.tencent.timi.game.liveroom.impl.room.util.g;
import com.tencent.timi.game.liveroom.impl.room.view.systeminfo.AnchorLiveSystemInfoDetailView;
import com.tencent.timi.game.utils.o;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nr2.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u00015B\u0011\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b-\u0010.B\u001b\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u00a2\u0006\u0004\b-\u00101B#\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u00102\u001a\u00020\u0013\u00a2\u0006\u0004\b-\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ(\u0010\u0015\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R(\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00066"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/systeminfo/AnchorLiveSystemInfoDetailView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "J0", "", "curSpeedKbS", "", "L0", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/AnchorLiveSystemInfo;", "info", "Q0", "text", "N0", "Landroid/view/View$OnClickListener;", "listener", "setOnCloseClickListener", "", "Landroid/util/Pair;", "", "", "upLossRecord", "P0", "id", "O0", "Lnr2/a;", "d", "Lnr2/a;", "K0", "()Lnr2/a;", "setBinding", "(Lnr2/a;)V", "binding", "e", "J", "roomId", "f", "I", Element.ELEMENT_NAME_TIMES, h.F, "Ljava/util/List;", "i", "Landroid/view/View$OnClickListener;", "onCloseClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorLiveSystemInfoDetailView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int times;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Pair<Long, Integer>> upLossRecord;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener onCloseClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/systeminfo/AnchorLiveSystemInfoDetailView$b", "Lcom/tencent/mobileqq/qqlive/callback/anchor/QQLiveAnchorRoomBaseCallback;", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/AnchorLiveSystemInfo;", "info", "", "onAnchorLiveNetStatus", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends QQLiveAnchorRoomBaseCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IQQLiveAnchorRoom f378922d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AnchorLiveSystemInfoDetailView f378923e;

        b(IQQLiveAnchorRoom iQQLiveAnchorRoom, AnchorLiveSystemInfoDetailView anchorLiveSystemInfoDetailView) {
            this.f378922d = iQQLiveAnchorRoom;
            this.f378923e = anchorLiveSystemInfoDetailView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(IQQLiveAnchorRoom iQQLiveAnchorRoom, AnchorLiveSystemInfoDetailView this$0, AnchorLiveSystemInfo info) {
            IQQLiveAnchorTRTCRoom iQQLiveAnchorTRTCRoom;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(info, "$info");
            if (iQQLiveAnchorRoom instanceof IQQLiveAnchorTRTCRoom) {
                iQQLiveAnchorTRTCRoom = (IQQLiveAnchorTRTCRoom) iQQLiveAnchorRoom;
            } else {
                iQQLiveAnchorTRTCRoom = null;
            }
            if (iQQLiveAnchorTRTCRoom != null) {
                List<Pair<Long, Integer>> upLossRecordList = iQQLiveAnchorTRTCRoom.getUpLossRecordList();
                Intrinsics.checkNotNullExpressionValue(upLossRecordList, "it.upLossRecordList");
                this$0.upLossRecord = upLossRecordList;
            }
            this$0.getBinding().f420750m.setText(this$0.L0(info.getUpSourceSpeed()));
            TextView textView = this$0.getBinding().f420746i;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this$0.getResources().getString(R.string.f2310270q);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026g_anchor_live_status_rtt)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf((int) info.getGateWayRtt())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            TextView textView2 = this$0.getBinding().f420752o;
            String string2 = this$0.getResources().getString(R.string.f2310370r);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026ve_status_up_source_loss)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(info.getUpSourceLoss())}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            textView2.setText(format2);
            TextView textView3 = this$0.getBinding().f420739b;
            String string3 = this$0.getResources().getString(R.string.f2310070o);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st\u2026or_live_status_cpu_usage)");
            String format3 = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(info.getCpuStatus())}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            textView3.setText(format3);
            TextView textView4 = this$0.getBinding().f420743f;
            String string4 = this$0.getResources().getString(R.string.f2310170p);
            Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st\u2026live_status_memory_usage)");
            String format4 = String.format(string4, Arrays.copyOf(new Object[]{Long.valueOf(info.getMemoryRate())}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
            textView4.setText(format4);
            this$0.Q0(info);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorLiveStatusCallBack
        public void onAnchorLiveNetStatus(@NotNull final AnchorLiveSystemInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            final IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f378922d;
            final AnchorLiveSystemInfoDetailView anchorLiveSystemInfoDetailView = this.f378923e;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: jl4.e
                @Override // java.lang.Runnable
                public final void run() {
                    AnchorLiveSystemInfoDetailView.b.b(IQQLiveAnchorRoom.this, anchorLiveSystemInfoDetailView, info);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorLiveSystemInfoDetailView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a g16 = a.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.upLossRecord = new ArrayList();
        J0();
        this.binding.f420751n.setOnClickListener(new View.OnClickListener() { // from class: jl4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorLiveSystemInfoDetailView.D0(AnchorLiveSystemInfoDetailView.this, view);
            }
        });
        TextView textView = this.binding.f420742e;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: jl4.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnchorLiveSystemInfoDetailView.E0(AnchorLiveSystemInfoDetailView.this, view);
                }
            });
        }
        this.binding.f420740c.setOnClickListener(new View.OnClickListener() { // from class: jl4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorLiveSystemInfoDetailView.F0(AnchorLiveSystemInfoDetailView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(AnchorLiveSystemInfoDetailView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.a()) {
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AnchorLiveUpLossDetailView anchorLiveUpLossDetailView = new AnchorLiveUpLossDetailView(context);
            anchorLiveUpLossDetailView.setUpLossRecord(this$0.upLossRecord);
            Context context2 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            com.tencent.timi.game.liveroom.impl.room.util.h hVar = new com.tencent.timi.game.liveroom.impl.room.util.h();
            hVar.t(false);
            hVar.v(-1);
            hVar.u((int) (ScreenUtils.getAppScreenHeight() * 0.8d));
            hVar.x(true);
            hVar.q(R.style.b0e);
            Unit unit = Unit.INSTANCE;
            final PopupWindow e16 = g.e(context2, anchorLiveUpLossDetailView, hVar);
            ImageView imageView = anchorLiveUpLossDetailView.getBinding().f420968b;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: jl4.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AnchorLiveSystemInfoDetailView.M0(e16, view2);
                    }
                });
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(AnchorLiveSystemInfoDetailView this$0, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        e.k(activity, -1, null, "https://docs.qq.com/doc/DWlpEaWFGREZpRHpw?&u=4a0d71a59ff946e98ca1003cab5ae202");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(AnchorLiveSystemInfoDetailView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.onCloseClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J0() {
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        RelativeLayout relativeLayout = this.binding.f420751n;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.upLossDetail");
        a.C11346a.a((ug4.a) b16, relativeLayout, false, null, "em_qqlive_network_packetlossrate", null, 22, null);
        mm4.a b17 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(ILiveReportService::class.java)");
        TextView textView = this.binding.f420742e;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.liveStatusQABtn");
        a.C11346a.a((ug4.a) b17, textView, false, null, "em_qqlive_network_guide", null, 22, null);
        VideoReport.reportEvent("imp", this.binding.f420751n, new HashMap());
        VideoReport.reportEvent("imp", this.binding.f420742e, new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String L0(float curSpeedKbS) {
        if (curSpeedKbS > 1024.0f) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getResources().getString(R.string.f2310570t);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026tatus_up_source_speed_mb)");
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(curSpeedKbS / 1024.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            String format2 = String.format(string, Arrays.copyOf(new Object[]{format}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = getResources().getString(R.string.f2310470s);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026tatus_up_source_speed_kb)");
        String format3 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(curSpeedKbS)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        String format4 = String.format(string2, Arrays.copyOf(new Object[]{format3}, 1));
        Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
        return format4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(PopupWindow this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N0(AnchorLiveSystemInfo info, String text) {
        String str;
        int i3 = this.times;
        if (i3 % 10 != 0) {
            this.times = i3 + 1;
            return;
        }
        this.times = 0 + 1;
        IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
        QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.n();
        } else {
            str = null;
        }
        iQQLiveReportApi.qualityReport(builder.traceId(str).eventId(QQLiveReportConstants.Event.E_ANCHOR_ROOM_PERFORMANCE).desc(text).ext6(String.valueOf(info.getUpSourceSpeed())).ext7(String.valueOf(info.getGateWayRtt())).ext8(String.valueOf(info.getUpSourceLoss())).ext9(String.valueOf(info.getCpuStatus())).ext10(String.valueOf(info.getAnchorLiveNetQuality())).ext11(String.valueOf(info.getMemoryRate())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0(AnchorLiveSystemInfo info) {
        switch (info.getAnchorLiveNetQuality()) {
            case 0:
            case 1:
            case 2:
                this.binding.f420744g.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.o5w, null));
                this.binding.f420745h.setText(getResources().getString(R.string.yvn));
                return;
            case 3:
            case 4:
                this.binding.f420744g.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.o5x, null));
                this.binding.f420745h.setText(getResources().getString(R.string.yvp));
                return;
            case 5:
            case 6:
                this.binding.f420744g.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.o5y, null));
                this.binding.f420745h.setText(getResources().getString(R.string.yvq));
                N0(info, this.binding.f420745h.getText().toString());
                return;
            default:
                return;
        }
    }

    @NotNull
    /* renamed from: K0, reason: from getter */
    public final nr2.a getBinding() {
        return this.binding;
    }

    public final void O0(long id5) {
        this.roomId = id5;
        IQQLiveAnchorRoom J3 = ((jg4.b) mm4.b.b(jg4.b.class)).J3(id5);
        if (J3 != null) {
            J3.registerAnchorCallback(new b(J3, this));
        }
    }

    public final void P0(@NotNull AnchorLiveSystemInfo info, @NotNull List<Pair<Long, Integer>> upLossRecord) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(upLossRecord, "upLossRecord");
        this.upLossRecord = upLossRecord;
        this.binding.f420750m.setText(L0(info.getUpSourceSpeed()));
        TextView textView = this.binding.f420746i;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getResources().getString(R.string.f2310270q);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026g_anchor_live_status_rtt)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf((int) info.getGateWayRtt())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        TextView textView2 = this.binding.f420752o;
        String string2 = getResources().getString(R.string.f2310370r);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026ve_status_up_source_loss)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(info.getUpSourceLoss())}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        textView2.setText(format2);
        TextView textView3 = this.binding.f420739b;
        String string3 = getResources().getString(R.string.f2310070o);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st\u2026or_live_status_cpu_usage)");
        String format3 = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(info.getCpuStatus())}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        textView3.setText(format3);
        TextView textView4 = this.binding.f420743f;
        String string4 = getResources().getString(R.string.f2310170p);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st\u2026live_status_memory_usage)");
        String format4 = String.format(string4, Arrays.copyOf(new Object[]{Long.valueOf(info.getMemoryRate())}, 1));
        Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
        textView4.setText(format4);
        Q0(info);
    }

    public final void setBinding(@NotNull nr2.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.binding = aVar;
    }

    public final void setOnCloseClickListener(@Nullable View.OnClickListener listener) {
        this.onCloseClickListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorLiveSystemInfoDetailView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        nr2.a g16 = nr2.a.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.upLossRecord = new ArrayList();
        J0();
        this.binding.f420751n.setOnClickListener(new View.OnClickListener() { // from class: jl4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorLiveSystemInfoDetailView.D0(AnchorLiveSystemInfoDetailView.this, view);
            }
        });
        TextView textView = this.binding.f420742e;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: jl4.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnchorLiveSystemInfoDetailView.E0(AnchorLiveSystemInfoDetailView.this, view);
                }
            });
        }
        this.binding.f420740c.setOnClickListener(new View.OnClickListener() { // from class: jl4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorLiveSystemInfoDetailView.F0(AnchorLiveSystemInfoDetailView.this, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorLiveSystemInfoDetailView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        nr2.a g16 = nr2.a.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.upLossRecord = new ArrayList();
        J0();
        this.binding.f420751n.setOnClickListener(new View.OnClickListener() { // from class: jl4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorLiveSystemInfoDetailView.D0(AnchorLiveSystemInfoDetailView.this, view);
            }
        });
        TextView textView = this.binding.f420742e;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: jl4.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnchorLiveSystemInfoDetailView.E0(AnchorLiveSystemInfoDetailView.this, view);
                }
            });
        }
        this.binding.f420740c.setOnClickListener(new View.OnClickListener() { // from class: jl4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorLiveSystemInfoDetailView.F0(AnchorLiveSystemInfoDetailView.this, view);
            }
        });
    }
}
