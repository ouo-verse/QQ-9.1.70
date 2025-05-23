package com.tencent.mobileqq.troop.membersetting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.membersetting.handler.MemberSettingHandler;
import com.tencent.mobileqq.troop.membersetting.widget.TroopGagDurationSettingPanel;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import tl.h;
import xs2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0005?@ABCB\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J&\u0010\r\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0018\u00010\u001aR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\b\u0018\u00010\u001eR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0018\u00010\"R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0016\u00101\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00103\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u0016\u00105\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010*R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010*R\u0016\u00109\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010*R\u0016\u0010;\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010*\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View$OnClickListener;", "", "Dh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/ListView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ListView;", "listView", "Landroid/widget/Button;", "D", "Landroid/widget/Button;", "btnOK", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$d;", "E", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$d;", "popupDialog", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e;", "adapter", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$c;", "G", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$c;", "itemListener", "", "H", "Ljava/lang/String;", "troopUin", "I", "memberUin", "J", "curSelSeconds", "K", "defDay", "L", "defHour", "M", "defMinute", "N", "maxDay", "P", "curDay", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "curHour", BdhLogUtil.LogTag.Tag_Req, "curMinute", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "b", "c", "d", "e", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MemberGagFragment extends QIphoneTitleBarFragment implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ListView listView;

    /* renamed from: D, reason: from kotlin metadata */
    private Button btnOK;

    /* renamed from: E, reason: from kotlin metadata */
    private d popupDialog;

    /* renamed from: F, reason: from kotlin metadata */
    private e adapter;

    /* renamed from: G, reason: from kotlin metadata */
    private c itemListener;

    /* renamed from: H, reason: from kotlin metadata */
    private String troopUin;

    /* renamed from: I, reason: from kotlin metadata */
    private String memberUin;

    /* renamed from: J, reason: from kotlin metadata */
    private int curSelSeconds;

    /* renamed from: K, reason: from kotlin metadata */
    private int defDay;

    /* renamed from: L, reason: from kotlin metadata */
    private int defHour;

    /* renamed from: M, reason: from kotlin metadata */
    private int defMinute;

    /* renamed from: N, reason: from kotlin metadata */
    private int maxDay;

    /* renamed from: P, reason: from kotlin metadata */
    private int curDay;

    /* renamed from: Q, reason: from kotlin metadata */
    private int curHour;

    /* renamed from: R, reason: from kotlin metadata */
    private int curMinute;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$b;", "", "Lxs2/a$b;", "info", "", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a(a.b info);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$d;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "", "d", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/troop/membersetting/widget/TroopGagDurationSettingPanel;", "Lcom/tencent/mobileqq/troop/membersetting/widget/TroopGagDurationSettingPanel;", "contentPanel", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment;Landroid/content/Context;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class d extends Dialog implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private TroopGagDurationSettingPanel contentPanel;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MemberGagFragment f297808e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MemberGagFragment memberGagFragment, Context context) {
            super(context, R.style.f243051);
            Intrinsics.checkNotNullParameter(context, "context");
            this.f297808e = memberGagFragment;
            requestWindowFeature(1);
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 81;
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.f243062);
                window.setFlags(16777216, 16777216);
            }
            setCancelable(true);
            setCanceledOnTouchOutside(true);
            d();
        }

        private final void d() {
            TroopGagDurationSettingPanel troopGagDurationSettingPanel = null;
            View inflate = getLayoutInflater().inflate(R.layout.f167256s6, (ViewGroup) null);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.View");
            setContentView(inflate);
            View findViewById = inflate.findViewById(R.id.f17921l);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.troop.membersetting.widget.TroopGagDurationSettingPanel");
            TroopGagDurationSettingPanel troopGagDurationSettingPanel2 = (TroopGagDurationSettingPanel) findViewById;
            this.contentPanel = troopGagDurationSettingPanel2;
            if (troopGagDurationSettingPanel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentPanel");
            } else {
                troopGagDurationSettingPanel = troopGagDurationSettingPanel2;
            }
            troopGagDurationSettingPanel.c(this.f297808e.curDay, this.f297808e.curHour, this.f297808e.curMinute, this.f297808e.maxDay);
            View findViewById2 = inflate.findViewById(R.id.f174007);
            View findViewById3 = findViewById2.findViewById(R.id.f174108);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById3).setTextColor(this.f297808e.getResources().getColor(R.color.skin_color_button_white));
            View findViewById4 = inflate.findViewById(R.id.f17470d);
            View findViewById5 = findViewById4.findViewById(R.id.f17480e);
            Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById5).setTextColor(this.f297808e.getResources().getColor(R.color.skin_color_button_white));
            findViewById2.setClickable(true);
            findViewById4.setClickable(true);
            findViewById2.setOnClickListener(this);
            findViewById4.setOnClickListener(this);
            findViewById2.setFocusable(true);
            findViewById4.setFocusable(true);
            String str = getContext().getString(R.string.f131460s) + getContext().getString(R.string.f131450r);
            String str2 = getContext().getString(R.string.f131470t) + getContext().getString(R.string.f131450r);
            findViewById2.setContentDescription(str);
            findViewById4.setContentDescription(str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            e.b a16;
            e.b a17;
            a.b gagItem;
            Intrinsics.checkNotNullParameter(v3, "v");
            int id5 = v3.getId();
            if (id5 != R.id.f174007) {
                if (id5 == R.id.f17470d && this.f297808e.adapter != null) {
                    MemberGagFragment memberGagFragment = this.f297808e;
                    TroopGagDurationSettingPanel troopGagDurationSettingPanel = this.contentPanel;
                    TroopGagDurationSettingPanel troopGagDurationSettingPanel2 = null;
                    if (troopGagDurationSettingPanel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentPanel");
                        troopGagDurationSettingPanel = null;
                    }
                    memberGagFragment.curDay = troopGagDurationSettingPanel.f297972e;
                    MemberGagFragment memberGagFragment2 = this.f297808e;
                    TroopGagDurationSettingPanel troopGagDurationSettingPanel3 = this.contentPanel;
                    if (troopGagDurationSettingPanel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentPanel");
                        troopGagDurationSettingPanel3 = null;
                    }
                    memberGagFragment2.curHour = troopGagDurationSettingPanel3.f297973f;
                    MemberGagFragment memberGagFragment3 = this.f297808e;
                    TroopGagDurationSettingPanel troopGagDurationSettingPanel4 = this.contentPanel;
                    if (troopGagDurationSettingPanel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentPanel");
                        troopGagDurationSettingPanel4 = null;
                    }
                    memberGagFragment3.curMinute = troopGagDurationSettingPanel4.f297974h;
                    MemberGagFragment memberGagFragment4 = this.f297808e;
                    TroopGagDurationSettingPanel troopGagDurationSettingPanel5 = this.contentPanel;
                    if (troopGagDurationSettingPanel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentPanel");
                    } else {
                        troopGagDurationSettingPanel2 = troopGagDurationSettingPanel5;
                    }
                    memberGagFragment4.curSelSeconds = troopGagDurationSettingPanel2.b();
                    e eVar = this.f297808e.adapter;
                    if (eVar != null && (a17 = eVar.a()) != null && (gagItem = a17.getGagItem()) != null) {
                        gagItem.c(this.f297808e.curSelSeconds);
                    }
                    e eVar2 = this.f297808e.adapter;
                    if (eVar2 != null && (a16 = eVar2.a()) != null) {
                        a16.d(true);
                    }
                    e eVar3 = this.f297808e.adapter;
                    if (eVar3 != null) {
                        eVar3.notifyDataSetChanged();
                    }
                    dismiss();
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    String str = this.f297808e.troopUin;
                    String d16 = a.f448450a.d(this.f297808e.troopUin);
                    int i3 = this.f297808e.curSelSeconds;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(i3);
                    ReportController.o(peekAppRuntime, "P_CliOper", "Grp_manage", "", NotificationCompat.GROUP_KEY_SILENT, "suc_custom_time", 0, 0, str, d16, sb5.toString(), "");
                    return;
                }
                return;
            }
            dismiss();
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "P_CliOper", "Grp_manage", "", NotificationCompat.GROUP_KEY_SILENT, "un_custom_time", 0, 0, this.f297808e.troopUin, a.f448450a.d(this.f297808e.troopUin), "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Dh() {
        this.curDay = this.defDay;
        this.curHour = this.defHour;
        this.curMinute = this.defMinute;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle(getString(R.string.f131821r));
        a aVar = a.f448450a;
        a.C11565a c16 = aVar.c();
        if (c16 != null) {
            this.defDay = c16.getMDefDay();
            this.defHour = c16.getMDefHour();
            this.defMinute = c16.getMDefMinute();
            this.maxDay = c16.getMMaxDay();
        }
        ArrayList<a.b> b16 = aVar.b();
        this.curSelSeconds = b16.get(0).getNSeconds();
        c cVar = new c();
        this.itemListener = cVar;
        this.adapter = new e(this, b16, cVar);
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f177515);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ListView");
        ListView listView = (ListView) findViewById;
        this.listView = listView;
        ListView listView2 = null;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView = null;
        }
        listView.setCacheColorHint(0);
        ListView listView3 = this.listView;
        if (listView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
        } else {
            listView2 = listView3;
        }
        listView2.setAdapter((ListAdapter) this.adapter);
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f173805);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) findViewById2;
        this.btnOK = button;
        if (button != null) {
            button.setOnClickListener(this);
            button.setBackgroundResource(R.drawable.f159655qo);
            button.setTextColor(getResources().getColor(R.color.skin_color_button_blue));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.troopUin = arguments.getString("param_key_troopUin");
            this.memberUin = arguments.getString("param_key_memberUin");
        }
        Dh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167257st;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = this.troopUin;
        int i3 = this.curSelSeconds;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        ReportController.o(peekAppRuntime, "P_CliOper", "Grp_manage", "", "silent_card", "Clk_complete", 0, 0, str, sb5.toString(), a.f448450a.d(this.troopUin), "");
        if (NetworkUtil.getSystemNetwork(getContext()) == 0) {
            QQToast.makeText(getContext(), R.string.f1319120, 1).show();
            return;
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime2, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        new MemberSettingHandler((AppInterface) peekAppRuntime2).G2(this.troopUin, this.memberUin, this.curSelSeconds);
        Intent intent = new Intent();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            xs2.c.f448459a.h(activity, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d dVar;
        d dVar2 = this.popupDialog;
        boolean z16 = false;
        if (dVar2 != null && dVar2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dVar = this.popupDialog) != null) {
            dVar.dismiss();
        }
        super.onDestroy();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$c;", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$b;", "Lxs2/a$b;", "info", "", "a", "<init>", "(Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class c implements b {
        public c() {
        }

        @Override // com.tencent.mobileqq.troop.membersetting.fragment.MemberGagFragment.b
        public void a(a.b info) {
            if (info != null) {
                MemberGagFragment memberGagFragment = MemberGagFragment.this;
                if (info.getNSeconds() > 0) {
                    memberGagFragment.curSelSeconds = info.getNSeconds();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001e B'\u0012\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020+0&j\b\u0012\u0004\u0012\u00020+`'\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b-\u0010.J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R*\u0010\"\u001a\n0\u001aR\u00060\u0000R\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u0010$R4\u0010*\u001a\"\u0012\f\u0012\n0\u001aR\u00060\u0000R\u00020\u001b0&j\u0010\u0012\f\u0012\n0\u001aR\u00060\u0000R\u00020\u001b`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e;", "Landroid/widget/BaseAdapter;", "Landroid/widget/ListAdapter;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", NodeProps.MARGIN_LEFT, "", "c", "getCount", "position", "", "getItem", "", "getItemId", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$b;", "d", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$b;", "itemListener", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e$b;", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment;", "e", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e$b;", "a", "()Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e$b;", "b", "(Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e$b;)V", "mUserCustomizeItem", "f", "I", "BORDER_MARGIN_LEFT_DP", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", h.F, "Ljava/util/ArrayList;", "arItemInfo", "Lxs2/a$b;", "arConfigList", "<init>", "(Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment;Ljava/util/ArrayList;Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$b;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class e extends BaseAdapter implements ListAdapter, View.OnClickListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final b itemListener;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public b mUserCustomizeItem;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int BORDER_MARGIN_LEFT_DP;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final ArrayList<b> arItemInfo;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ MemberGagFragment f297813i;

        /* compiled from: P */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001d\u0010\u0010R*\u0010&\u001a\n0\u001fR\u00060 R\u00020!8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\"\u001a\u0004\b\u001c\u0010#\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010/\u001a\u00020'8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b)\u0010(\u001a\u0004\b\u000b\u0010*\"\u0004\b.\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e$a;", "", "Landroid/widget/FrameLayout;", "a", "Landroid/widget/FrameLayout;", "f", "()Landroid/widget/FrameLayout;", DomainData.DOMAIN_NAME, "(Landroid/widget/FrameLayout;)V", TtmlNode.TAG_LAYOUT, "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "g", "()Landroid/widget/TextView;", "o", "(Landroid/widget/TextView;)V", "timeView", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "k", "(Landroid/widget/ImageView;)V", "checkView", "d", "i", "arrowView", "e", "l", "customizeView", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e$b;", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e;", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment;", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e$b;", "()Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e$b;)V", "itemInfo", "Landroid/view/View;", "Landroid/view/View;", h.F, "()Landroid/view/View;", "p", "(Landroid/view/View;)V", "topBorder", "j", "bottomBorder", "<init>", "(Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public final class a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private FrameLayout layout;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public TextView timeView;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            public ImageView checkView;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            public ImageView arrowView;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            public TextView customizeView;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata */
            public b itemInfo;

            /* renamed from: g, reason: collision with root package name and from kotlin metadata */
            public View topBorder;

            /* renamed from: h, reason: collision with root package name and from kotlin metadata */
            public View bottomBorder;

            public a() {
            }

            public final ImageView a() {
                ImageView imageView = this.arrowView;
                if (imageView != null) {
                    return imageView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("arrowView");
                return null;
            }

            public final View b() {
                View view = this.bottomBorder;
                if (view != null) {
                    return view;
                }
                Intrinsics.throwUninitializedPropertyAccessException("bottomBorder");
                return null;
            }

            public final ImageView c() {
                ImageView imageView = this.checkView;
                if (imageView != null) {
                    return imageView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("checkView");
                return null;
            }

            public final TextView d() {
                TextView textView = this.customizeView;
                if (textView != null) {
                    return textView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("customizeView");
                return null;
            }

            public final b e() {
                b bVar = this.itemInfo;
                if (bVar != null) {
                    return bVar;
                }
                Intrinsics.throwUninitializedPropertyAccessException("itemInfo");
                return null;
            }

            /* renamed from: f, reason: from getter */
            public final FrameLayout getLayout() {
                return this.layout;
            }

            public final TextView g() {
                TextView textView = this.timeView;
                if (textView != null) {
                    return textView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("timeView");
                return null;
            }

            public final View h() {
                View view = this.topBorder;
                if (view != null) {
                    return view;
                }
                Intrinsics.throwUninitializedPropertyAccessException("topBorder");
                return null;
            }

            public final void i(ImageView imageView) {
                Intrinsics.checkNotNullParameter(imageView, "<set-?>");
                this.arrowView = imageView;
            }

            public final void j(View view) {
                Intrinsics.checkNotNullParameter(view, "<set-?>");
                this.bottomBorder = view;
            }

            public final void k(ImageView imageView) {
                Intrinsics.checkNotNullParameter(imageView, "<set-?>");
                this.checkView = imageView;
            }

            public final void l(TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.customizeView = textView;
            }

            public final void m(b bVar) {
                Intrinsics.checkNotNullParameter(bVar, "<set-?>");
                this.itemInfo = bVar;
            }

            public final void n(FrameLayout frameLayout) {
                this.layout = frameLayout;
            }

            public final void o(TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.timeView = textView;
            }

            public final void p(View view) {
                Intrinsics.checkNotNullParameter(view, "<set-?>");
                this.topBorder = view;
            }
        }

        public e(MemberGagFragment memberGagFragment, ArrayList<a.b> arConfigList, b itemListener) {
            Intrinsics.checkNotNullParameter(arConfigList, "arConfigList");
            Intrinsics.checkNotNullParameter(itemListener, "itemListener");
            this.f297813i = memberGagFragment;
            this.itemListener = itemListener;
            this.BORDER_MARGIN_LEFT_DP = 45;
            this.arItemInfo = new ArrayList<>();
            Iterator<a.b> it = arConfigList.iterator();
            int i3 = 0;
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                int i16 = i3 + 1;
                a.b next = it.next();
                ArrayList<b> arrayList = this.arItemInfo;
                if (i3 != 0) {
                    z16 = false;
                }
                arrayList.add(new b(next, z16));
                i3 = i16;
            }
            a.b a16 = xs2.a.f448450a.a(this.f297813i.getResources().getString(R.string.f131841t), 0);
            if (a16 != null) {
                b(new b(a16, false, true));
                this.arItemInfo.add(a());
            }
        }

        private final void c(View view, int marginLeft) {
            if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(marginLeft, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                view.setLayoutParams(layoutParams2);
            }
        }

        public final b a() {
            b bVar = this.mUserCustomizeItem;
            if (bVar != null) {
                return bVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mUserCustomizeItem");
            return null;
        }

        public final void b(b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mUserCustomizeItem = bVar;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.arItemInfo.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            b bVar = this.arItemInfo.get(position);
            Intrinsics.checkNotNullExpressionValue(bVar, "arItemInfo[position]");
            return bVar;
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            String str;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.f12718if, (ViewGroup) null);
                a aVar = new a();
                if (convertView != null) {
                    View findViewById = convertView.findViewById(R.id.f177212);
                    Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
                    aVar.n((FrameLayout) findViewById);
                    View findViewById2 = convertView.findViewById(R.id.f18182a);
                    Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
                    aVar.o((TextView) findViewById2);
                    View findViewById3 = convertView.findViewById(R.id.f17650v);
                    Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
                    aVar.k((ImageView) findViewById3);
                    aVar.c().setImageResource(R.drawable.f159652or);
                    View findViewById4 = convertView.findViewById(R.id.f18272j);
                    Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
                    aVar.i((ImageView) findViewById4);
                    aVar.a().setBackgroundResource(R.drawable.f159653os);
                    View findViewById5 = convertView.findViewById(R.id.f18282k);
                    Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
                    aVar.l((TextView) findViewById5);
                    View findViewById6 = convertView.findViewById(R.id.f18212d);
                    Intrinsics.checkNotNullExpressionValue(findViewById6, "it.findViewById(R.id.topBorder)");
                    aVar.p(findViewById6);
                    View findViewById7 = convertView.findViewById(R.id.f173502);
                    Intrinsics.checkNotNullExpressionValue(findViewById7, "it.findViewById(R.id.bottomBorder)");
                    aVar.j(findViewById7);
                }
                FrameLayout layout = aVar.getLayout();
                if (layout != null) {
                    layout.setOnClickListener(this);
                    layout.setTag(aVar);
                }
                aVar.g().setOnClickListener(this);
                aVar.c().setOnClickListener(this);
                aVar.g().setTag(aVar);
                aVar.c().setTag(aVar);
                aVar.a().setTag(aVar);
                aVar.d().setTag(aVar);
                convertView.setTag(aVar);
            }
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.troop.membersetting.fragment.MemberGagFragment.TroopGagListAdapter.Holder");
            a aVar2 = (a) tag;
            b bVar = this.arItemInfo.get(position);
            Intrinsics.checkNotNullExpressionValue(bVar, "arItemInfo[position]");
            b bVar2 = bVar;
            TextView g16 = aVar2.g();
            a.b gagItem = bVar2.getGagItem();
            if (gagItem == null || (str = gagItem.getSText()) == null) {
                str = "";
            }
            g16.setText(str);
            aVar2.c().setVisibility(bVar2.getBCheck() ? 0 : 8);
            b bVar3 = this.arItemInfo.get(position);
            Intrinsics.checkNotNullExpressionValue(bVar3, "arItemInfo[position]");
            aVar2.m(bVar3);
            int applyDimension = (int) TypedValue.applyDimension(1, this.BORDER_MARGIN_LEFT_DP, this.f297813i.getResources().getDisplayMetrics());
            aVar2.h().setVisibility(0);
            if (position < getCount() - 1) {
                aVar2.b().setVisibility(4);
                if (position == 0) {
                    c(aVar2.h(), 0);
                } else {
                    c(aVar2.h(), applyDimension);
                }
            } else {
                aVar2.b().setVisibility(0);
                c(aVar2.b(), 0);
            }
            if (bVar2.getIsUserCustomizeItem()) {
                aVar2.a().setOnClickListener(this);
                aVar2.a().setVisibility(0);
                a.b gagItem2 = bVar2.getGagItem();
                if (gagItem2 != null) {
                    MemberGagFragment memberGagFragment = this.f297813i;
                    if (gagItem2.getNSeconds() > 0) {
                        aVar2.d().setVisibility(0);
                        aVar2.d().setText(xs2.a.f448450a.g(memberGagFragment.getContext(), memberGagFragment.curSelSeconds));
                    } else {
                        aVar2.d().setVisibility(8);
                    }
                }
                Context context = this.f297813i.getContext();
                if (context != null) {
                    convertView.setContentDescription(context.getString(R.string.f131851u));
                }
            } else {
                aVar2.a().setVisibility(8);
                aVar2.d().setVisibility(8);
                a.b gagItem3 = bVar2.getGagItem();
                if (gagItem3 != null) {
                    convertView.setContentDescription(gagItem3.getSText());
                }
            }
            convertView.setSelected(true);
            return convertView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            d dVar;
            Intrinsics.checkNotNullParameter(v3, "v");
            Object tag = v3.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.troop.membersetting.fragment.MemberGagFragment.TroopGagListAdapter.Holder");
            a aVar = (a) tag;
            if (aVar.e().getIsUserCustomizeItem()) {
                Iterator<b> it = this.arItemInfo.iterator();
                while (it.hasNext()) {
                    it.next().d(false);
                }
                d dVar2 = this.f297813i.popupDialog;
                if ((dVar2 != null && dVar2.isShowing()) && (dVar = this.f297813i.popupDialog) != null) {
                    dVar.dismiss();
                }
                MemberGagFragment memberGagFragment = this.f297813i;
                Context context = memberGagFragment.getContext();
                memberGagFragment.popupDialog = context != null ? new d(this.f297813i, context) : null;
                d dVar3 = this.f297813i.popupDialog;
                if (dVar3 != null) {
                    dVar3.show();
                }
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "P_CliOper", "Grp_manage", "", NotificationCompat.GROUP_KEY_SILENT, "Clk_custom_time", 0, 0, this.f297813i.troopUin, xs2.a.f448450a.d(this.f297813i.troopUin), "", "");
                return;
            }
            a.b gagItem = a().getGagItem();
            if (gagItem != null) {
                gagItem.c(0);
            }
            Iterator<b> it5 = this.arItemInfo.iterator();
            while (it5.hasNext()) {
                b next = it5.next();
                next.d(aVar.e() == next);
            }
            this.f297813i.Dh();
            this.itemListener.a(aVar.e().getGagItem());
            notifyDataSetChanged();
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0010\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014B#\b\u0010\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0015R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e$b;", "", "Lxs2/a$b;", "a", "Lxs2/a$b;", "b", "()Lxs2/a$b;", "setGagItem", "(Lxs2/a$b;)V", "gagItem", "", "Z", "()Z", "d", "(Z)V", "bCheck", "c", "setUserCustomizeItem", "isUserCustomizeItem", "<init>", "(Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e;Lxs2/a$b;Z)V", "(Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberGagFragment$e;Lxs2/a$b;ZZ)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public final class b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private a.b gagItem;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private boolean bCheck;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private boolean isUserCustomizeItem;

            public b(a.b bVar, boolean z16) {
                this.gagItem = bVar;
                this.bCheck = z16;
                this.isUserCustomizeItem = false;
            }

            /* renamed from: a, reason: from getter */
            public final boolean getBCheck() {
                return this.bCheck;
            }

            /* renamed from: b, reason: from getter */
            public final a.b getGagItem() {
                return this.gagItem;
            }

            /* renamed from: c, reason: from getter */
            public final boolean getIsUserCustomizeItem() {
                return this.isUserCustomizeItem;
            }

            public final void d(boolean z16) {
                this.bCheck = z16;
            }

            public b(a.b bVar, boolean z16, boolean z17) {
                this.gagItem = bVar;
                this.bCheck = z16;
                this.isUserCustomizeItem = z17;
            }
        }
    }
}
