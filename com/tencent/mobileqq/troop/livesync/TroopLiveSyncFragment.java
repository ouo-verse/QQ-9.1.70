package com.tencent.mobileqq.troop.livesync;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.livesync.repository.ITroopLiveSyncRepository;
import com.tencent.mobileqq.troop.livesync.view.TroopLiveSyncBottomView;
import com.tencent.mobileqq.troop.livesync.view.trooplist.TroopLiveSyncListView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopLiveSyncSvr$GetSyncGroupsRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\rH\u0016J$\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/troop/livesync/TroopLiveSyncFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "yh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, OcrConfig.CHINESE, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Bh", "Dh", "", "bSave", "wh", "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/a;", "Hh", "Lcom/tencent/mobileqq/widget/qus/e;", "xh", "Gh", "Ltencent/trpcprotocol/TroopLiveSyncSvr$GetSyncGroupsRsp;", "rsp", "Fh", "needImmersive", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "D", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mFloatingView", "E", "Landroid/view/View;", "mContainer", "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/TroopLiveSyncListView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/TroopLiveSyncListView;", "mListView", "Lcom/tencent/mobileqq/troop/livesync/view/TroopLiveSyncBottomView;", "G", "Lcom/tencent/mobileqq/troop/livesync/view/TroopLiveSyncBottomView;", "mBottomContainer", "", "H", "I", "mRoomId", "Z", "isFromLiveStart", "<init>", "()V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopLiveSyncFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private Context mContext;

    /* renamed from: D, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView mFloatingView;

    /* renamed from: E, reason: from kotlin metadata */
    private View mContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private TroopLiveSyncListView mListView;

    /* renamed from: G, reason: from kotlin metadata */
    private TroopLiveSyncBottomView mBottomContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private int mRoomId;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isFromLiveStart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/livesync/TroopLiveSyncFragment$a;", "", "", "HEADER_TEXT_FONT_SIZE", UserInfo.SEX_FEMALE, "", "INTENT_IS_FROM_LIVE_START", "Ljava/lang/String;", "INTENT_PARAMS_ROOM_ID", "", "MAX_HEIGHT_SCREEN_RATIO", "D", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.livesync.TroopLiveSyncFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/livesync/TroopLiveSyncFragment$b", "Lcom/tencent/mobileqq/widget/qus/e;", "", HippyTKDListViewAdapter.X, "y", "", "canScrollUp", "canScrollDown", "", NodeProps.MAX_HEIGHT, "showMode", "initState", "Landroid/view/View;", "createContentView", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopLiveSyncFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF57179d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                View view = TroopLiveSyncFragment.this.mContainer;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    return null;
                }
                return view;
            }
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return (int) (ViewUtils.getScreenHeight() * 0.66d);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/livesync/TroopLiveSyncFragment$c", "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/a;", "", "bSync", "", "b", "", "troopId", "bCheck", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements com.tencent.mobileqq.troop.livesync.view.trooplist.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopLiveSyncFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.livesync.view.trooplist.a
        public void a(long troopId, boolean bCheck) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(troopId), Boolean.valueOf(bCheck));
                return;
            }
            FragmentActivity activity = TroopLiveSyncFragment.this.getActivity();
            if (activity == null || activity.isFinishing()) {
                z16 = false;
            }
            if (z16) {
                TroopLiveSyncBottomView troopLiveSyncBottomView = TroopLiveSyncFragment.this.mBottomContainer;
                if (troopLiveSyncBottomView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
                    troopLiveSyncBottomView = null;
                }
                troopLiveSyncBottomView.f(troopId, bCheck);
            }
        }

        @Override // com.tencent.mobileqq.troop.livesync.view.trooplist.a
        public void b(boolean bSync) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, bSync);
                return;
            }
            FragmentActivity activity = TroopLiveSyncFragment.this.getActivity();
            boolean z16 = false;
            if (activity != null && !activity.isFinishing()) {
                z16 = true;
            }
            if (z16) {
                TroopLiveSyncBottomView troopLiveSyncBottomView = TroopLiveSyncFragment.this.mBottomContainer;
                if (troopLiveSyncBottomView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
                    troopLiveSyncBottomView = null;
                }
                troopLiveSyncBottomView.setSyncSetting(bSync);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54427);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopLiveSyncFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Bh(View rootView) {
        View findViewById = rootView.findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co\u2026qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        this.mFloatingView = qUSHalfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.setDraggable(false);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setOutSideTouchEnable(false);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.mFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.setIsHeightWrapContent(true);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.mFloatingView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
            qUSHalfScreenFloatingView5 = null;
        }
        qUSHalfScreenFloatingView5.setQUSDragFloatController(xh());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView6 = this.mFloatingView;
        if (qUSHalfScreenFloatingView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView6;
        }
        qUSHalfScreenFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.troop.livesync.b
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                TroopLiveSyncFragment.Ch(TroopLiveSyncFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(TroopLiveSyncFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void Dh() {
        Context context = this.mContext;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        TextView textView = new TextView(context);
        textView.setTextSize(17.0f);
        textView.setGravity(17);
        textView.setText(R.string.f234777_v);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.livesync.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopLiveSyncFragment.Eh(view);
            }
        });
        textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_primary));
        textView.setBackgroundResource(R.drawable.lwm);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.mFloatingView;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView2;
        }
        qUSHalfScreenFloatingView.setHeaderView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh(TroopLiveSyncSvr$GetSyncGroupsRsp rsp) {
        TroopLiveSyncListView troopLiveSyncListView = this.mListView;
        TroopLiveSyncBottomView troopLiveSyncBottomView = null;
        if (troopLiveSyncListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            troopLiveSyncListView = null;
        }
        troopLiveSyncListView.U(rsp, com.tencent.mobileqq.troop.livesync.repository.c.f297726a.d());
        TroopLiveSyncBottomView troopLiveSyncBottomView2 = this.mBottomContainer;
        if (troopLiveSyncBottomView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
        } else {
            troopLiveSyncBottomView = troopLiveSyncBottomView2;
        }
        troopLiveSyncBottomView.e(rsp);
    }

    private final void Gh() {
        com.tencent.mobileqq.troop.livesync.repository.c cVar = com.tencent.mobileqq.troop.livesync.repository.c.f297726a;
        TroopLiveSyncSvr$GetSyncGroupsRsp c16 = cVar.c(this.mRoomId);
        if (c16 != null) {
            Fh(c16);
        }
        ITroopLiveSyncRepository.DefaultImpls.a(cVar, this.mRoomId, new Function1<TroopLiveSyncSvr$GetSyncGroupsRsp, Unit>() { // from class: com.tencent.mobileqq.troop.livesync.TroopLiveSyncFragment$refreshData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopLiveSyncFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopLiveSyncSvr$GetSyncGroupsRsp troopLiveSyncSvr$GetSyncGroupsRsp) {
                invoke2(troopLiveSyncSvr$GetSyncGroupsRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TroopLiveSyncSvr$GetSyncGroupsRsp rsp) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                } else {
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    TroopLiveSyncFragment.this.Fh(rsp);
                }
            }
        }, null, 4, null);
    }

    private final com.tencent.mobileqq.troop.livesync.view.trooplist.a Hh() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh(boolean bSave) {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        if (bSave) {
            TroopLiveSyncListView troopLiveSyncListView = this.mListView;
            if (troopLiveSyncListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListView");
                troopLiveSyncListView = null;
            }
            troopLiveSyncListView.M();
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.mFloatingView;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView2;
        }
        qUSHalfScreenFloatingView.t();
    }

    private final e xh() {
        return new b();
    }

    private final void yh() {
        int i3;
        Intent intent;
        Intent intent2;
        FragmentActivity activity = getActivity();
        boolean z16 = false;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            i3 = intent2.getIntExtra("roomId", 0);
        } else {
            i3 = 0;
        }
        this.mRoomId = i3;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            z16 = intent.getBooleanExtra("isFromLiveStart", false);
        }
        this.isFromLiveStart = z16;
    }

    private final void zh(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.hzw, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026tainer, container, false)");
        this.mContainer = inflate;
        TroopLiveSyncBottomView troopLiveSyncBottomView = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.yma);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContainer.findViewById(\u2026live_sync_list_container)");
        TroopLiveSyncListView troopLiveSyncListView = (TroopLiveSyncListView) findViewById;
        this.mListView = troopLiveSyncListView;
        if (troopLiveSyncListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            troopLiveSyncListView = null;
        }
        troopLiveSyncListView.setRoomId(this.mRoomId);
        TroopLiveSyncListView troopLiveSyncListView2 = this.mListView;
        if (troopLiveSyncListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            troopLiveSyncListView2 = null;
        }
        troopLiveSyncListView2.setIsFromLiveStart(this.isFromLiveStart);
        TroopLiveSyncListView troopLiveSyncListView3 = this.mListView;
        if (troopLiveSyncListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            troopLiveSyncListView3 = null;
        }
        troopLiveSyncListView3.setSyncListStateChangeListener(Hh());
        View view = this.mContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.ym_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContainer.findViewById(\u2026ve_sync_bottom_container)");
        TroopLiveSyncBottomView troopLiveSyncBottomView2 = (TroopLiveSyncBottomView) findViewById2;
        this.mBottomContainer = troopLiveSyncBottomView2;
        if (troopLiveSyncBottomView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            troopLiveSyncBottomView2 = null;
        }
        troopLiveSyncBottomView2.setRoomId(this.mRoomId);
        TroopLiveSyncBottomView troopLiveSyncBottomView3 = this.mBottomContainer;
        if (troopLiveSyncBottomView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            troopLiveSyncBottomView3 = null;
        }
        troopLiveSyncBottomView3.setIsFromLiveStart(this.isFromLiveStart);
        TroopLiveSyncBottomView troopLiveSyncBottomView4 = this.mBottomContainer;
        if (troopLiveSyncBottomView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            troopLiveSyncBottomView4 = null;
        }
        troopLiveSyncBottomView4.setFinishCallback(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.livesync.TroopLiveSyncFragment$doInitFloatingContainer$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopLiveSyncFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    TroopLiveSyncFragment.this.wh(z16);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                }
            }
        });
        TroopLiveSyncBottomView troopLiveSyncBottomView5 = this.mBottomContainer;
        if (troopLiveSyncBottomView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
        } else {
            troopLiveSyncBottomView = troopLiveSyncBottomView5;
        }
        troopLiveSyncBottomView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.livesync.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopLiveSyncFragment.Ah(view2);
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            this.mContext = requireActivity;
            View rootView = inflater.inflate(R.layout.e3i, container, false);
            yh();
            zh(inflater, container);
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            Bh(rootView);
            Dh();
            Gh();
            view = rootView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }
}
