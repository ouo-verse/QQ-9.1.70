package com.tencent.mobileqq.troop.livesync.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.livesync.repository.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopLiveSyncSvr$GetSyncGroupsRsp;
import tencent.trpcprotocol.TroopLiveSyncSvr$GroupInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u00a2\u0006\u0004\b8\u00109J-\u0010\n\u001a\u00020\u00072%\u0010\t\u001a!\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003R\u001c\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u0014\u0010!\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0014\u0010#\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR9\u0010&\u001a%\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010(R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00150/j\b\u0012\u0004\u0012\u00020\u0015`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/troop/livesync/view/TroopLiveSyncBottomView;", "Landroid/widget/LinearLayout;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "bSave", "", "Lcom/tencent/mobileqq/troop/livesync/view/TroopLiveSyncBottomFinishCallback;", "callback", "setFinishCallback", "bSync", "setSyncSetting", "Ltencent/trpcprotocol/TroopLiveSyncSvr$GetSyncGroupsRsp;", "rsp", "e", "", "roomId", "setRoomId", "fromLiveStart", "setIsFromLiveStart", "", "troopId", "bChoose", "f", "Landroid/view/View;", "kotlin.jvm.PlatformType", "d", "Landroid/view/View;", "layoutInflater", "checkDesc", "syncDesc", h.F, "btnCancel", "i", "btnSave", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "finishCallback", BdhLogUtil.LogTag.Tag_Conn, "Z", "mIsSync", "D", "I", "mRoomId", "E", "isFromLiveStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "mAbleTroopIds", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopLiveSyncBottomView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsSync;

    /* renamed from: D, reason: from kotlin metadata */
    private int mRoomId;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isFromLiveStart;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Long> mAbleTroopIds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View layoutInflater;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View checkDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View syncDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View btnCancel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View btnSave;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Boolean, Unit> finishCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopLiveSyncBottomView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        View inflate = View.inflate(context, R.layout.hzv, this);
        this.layoutInflater = inflate;
        View findViewById = inflate.findViewById(R.id.tvb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "layoutInflater.findViewById(R.id.check_desc)");
        this.checkDesc = findViewById;
        View findViewById2 = inflate.findViewById(R.id.f9137550);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "layoutInflater.findViewById(R.id.sync_desc)");
        this.syncDesc = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.afr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "layoutInflater.findViewById(R.id.btn_cancel)");
        this.btnCancel = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.ajq);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "layoutInflater.findViewById(R.id.btn_save)");
        this.btnSave = findViewById4;
        this.mAbleTroopIds = new ArrayList<>();
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.livesync.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopLiveSyncBottomView.c(TroopLiveSyncBottomView.this, view);
            }
        });
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.livesync.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopLiveSyncBottomView.d(TroopLiveSyncBottomView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TroopLiveSyncBottomView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super Boolean, Unit> function1 = this$0.finishCallback;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TroopLiveSyncBottomView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super Boolean, Unit> function1 = this$0.finishCallback;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void e(@NotNull TroopLiveSyncSvr$GetSyncGroupsRsp rsp) {
        boolean z16;
        boolean z17;
        int i3;
        List<TroopLiveSyncSvr$GroupInfo> list;
        boolean z18;
        PBUInt64Field pBUInt64Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rsp);
            return;
        }
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        PBBoolField pBBoolField = rsp.unable_edit;
        boolean z19 = false;
        if (pBBoolField != null) {
            z16 = pBBoolField.get();
        } else {
            z16 = false;
        }
        PBBoolField pBBoolField2 = rsp.sync_switch;
        if (pBBoolField2 != null) {
            z17 = pBBoolField2.get();
        } else {
            z17 = false;
        }
        PBRepeatMessageField<TroopLiveSyncSvr$GroupInfo> pBRepeatMessageField = rsp.able_sync_groups;
        if (pBRepeatMessageField != null) {
            i3 = pBRepeatMessageField.size();
        } else {
            i3 = 0;
        }
        PBRepeatMessageField<TroopLiveSyncSvr$GroupInfo> pBRepeatMessageField2 = rsp.able_sync_groups;
        if (pBRepeatMessageField2 != null && (list = pBRepeatMessageField2.get()) != null) {
            for (TroopLiveSyncSvr$GroupInfo troopLiveSyncSvr$GroupInfo : list) {
                PBBoolField pBBoolField3 = troopLiveSyncSvr$GroupInfo.be_choosed;
                if (pBBoolField3 != null && pBBoolField3.get()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18 && (pBUInt64Field = troopLiveSyncSvr$GroupInfo.group_code) != null) {
                    this.mAbleTroopIds.add(Long.valueOf(pBUInt64Field.get()));
                }
            }
        }
        setSyncSetting(z17);
        View view = this.btnSave;
        if (!z16 && z17 && i3 > 0) {
            z19 = true;
        }
        view.setEnabled(z19);
    }

    public final void f(long troopId, boolean bChoose) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(troopId), Boolean.valueOf(bChoose));
            return;
        }
        if (bChoose) {
            this.mAbleTroopIds.add(Long.valueOf(troopId));
        } else {
            this.mAbleTroopIds.remove(Long.valueOf(troopId));
        }
        View view = this.btnSave;
        if (this.mAbleTroopIds.size() <= 0) {
            z16 = false;
        }
        view.setEnabled(z16);
    }

    public final void setFinishCallback(@NotNull Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.finishCallback = callback;
        }
    }

    public final void setIsFromLiveStart(boolean fromLiveStart) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, fromLiveStart);
        } else {
            this.isFromLiveStart = fromLiveStart;
        }
    }

    public final void setRoomId(int roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, roomId);
        } else {
            this.mRoomId = roomId;
        }
    }

    public final void setSyncSetting(boolean bSync) {
        boolean z16;
        PBBoolField pBBoolField;
        boolean z17;
        PBBoolField pBBoolField2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, bSync);
            return;
        }
        this.mIsSync = bSync;
        TroopLiveSyncSvr$GetSyncGroupsRsp c16 = c.f297726a.c(this.mRoomId);
        boolean z18 = true;
        if (bSync) {
            this.checkDesc.setVisibility(8);
            this.syncDesc.setVisibility(0);
            if (c16 != null && (pBBoolField2 = c16.unable_edit) != null) {
                z17 = pBBoolField2.get();
            } else {
                z17 = false;
            }
            View view = this.btnSave;
            if (z17 || this.mAbleTroopIds.size() <= 0) {
                z18 = false;
            }
            view.setEnabled(z18);
            return;
        }
        this.checkDesc.setVisibility(0);
        this.syncDesc.setVisibility(8);
        if (c16 != null && (pBBoolField = c16.sync_switch) != null) {
            z16 = pBBoolField.get();
        } else {
            z16 = false;
        }
        View view2 = this.btnSave;
        if (z16 == bSync) {
            z18 = false;
        }
        view2.setEnabled(z18);
    }
}
