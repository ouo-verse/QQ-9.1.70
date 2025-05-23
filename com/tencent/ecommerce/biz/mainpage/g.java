package com.tencent.ecommerce.biz.mainpage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0002J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/g;", "Landroid/app/Dialog;", "", "initViews", "", "X", "shopId", "Z", "", "W", "select", "Y", "needSelect", ExifInterface.LATITUDE_SOUTH, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "pennyShopHomeTv", "Landroid/widget/EditText;", "D", "Landroid/widget/EditText;", "shopIdEt", "Landroid/widget/CheckBox;", "E", "Landroid/widget/CheckBox;", "needSelectCb", UserInfo.SEX_FEMALE, "jumpTv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "G", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView pennyShopHomeTv;

    /* renamed from: D, reason: from kotlin metadata */
    private EditText shopIdEt;

    /* renamed from: E, reason: from kotlin metadata */
    private CheckBox needSelectCb;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView jumpTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/mainpage/ECQShopHomeEntranceDialog$initViews$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g(g.U(g.this, e.a(), false, 2, null), null, 2, null);
            g.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/mainpage/ECQShopHomeEntranceDialog$initViews$4$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            g gVar = g.this;
            ECScheme.g(gVar.S(g.P(gVar).getText().toString(), g.O(g.this).isChecked()), null, 2, null);
            g gVar2 = g.this;
            gVar2.Z(g.P(gVar2).getText().toString());
            g gVar3 = g.this;
            gVar3.Y(g.O(gVar3).isChecked());
            g.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ CheckBox O(g gVar) {
        CheckBox checkBox = gVar.needSelectCb;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("needSelectCb");
        }
        return checkBox;
    }

    public static final /* synthetic */ EditText P(g gVar) {
        EditText editText = gVar.shopIdEt;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopIdEt");
        }
        return editText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String S(String shopId, boolean needSelect) {
        Uri.Builder appendQueryParameter = Uri.parse("mqqapi://ecommerce/open").buildUpon().appendQueryParameter("target", String.valueOf(21)).appendQueryParameter(WadlProxyConsts.CHANNEL, "2").appendQueryParameter("source", "2").appendQueryParameter("shop_id", shopId);
        if (needSelect) {
            appendQueryParameter.appendQueryParameter("is_select", "1");
        }
        return appendQueryParameter.toString();
    }

    private final boolean W() {
        return IECLocalConfig.a.c(ECLocalConfig.f100650f, "sp_key_shop_home_need_select", false, null, 4, null);
    }

    private final String X() {
        return IECLocalConfig.a.f(ECLocalConfig.f100650f, "sp_key_shop_home_test_id", "40121412123361283", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(boolean select) {
        IECLocalConfig.a.h(ECLocalConfig.f100650f, "sp_key_shop_home_need_select", select, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(String shopId) {
        IECLocalConfig.a.j(ECLocalConfig.f100650f, "sp_key_shop_home_test_id", shopId, null, 4, null);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ctj);
        setCanceledOnTouchOutside(true);
        initViews();
    }

    public g(Context context) {
        super(context, R.style.f243139);
    }

    private final void initViews() {
        TextView textView = (TextView) findViewById(R.id.f163117oe1);
        textView.setOnClickListener(new b());
        Unit unit = Unit.INSTANCE;
        this.pennyShopHomeTv = textView;
        EditText editText = (EditText) findViewById(R.id.nyv);
        editText.setText(X());
        this.shopIdEt = editText;
        CheckBox checkBox = (CheckBox) findViewById(R.id.f163006nt1);
        checkBox.setChecked(W());
        this.needSelectCb = checkBox;
        TextView textView2 = (TextView) findViewById(R.id.odq);
        textView2.setOnClickListener(new c());
        this.jumpTv = textView2;
    }

    static /* synthetic */ String U(g gVar, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return gVar.S(str, z16);
    }
}
