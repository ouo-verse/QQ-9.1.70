package com.tencent.ecommerce.biz.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.repo.register.ECMsgBoxBtn;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001&B!\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014R\"\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/ecommerce/biz/common/ECMsgBoxDialog;", "Lcom/tencent/ecommerce/base/ui/g;", "", "m0", "o0", "p0", "", "url", "", "isRightBtn", "j0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "n0", "()Z", "q0", "(Z)V", "isDisabled", "Lcom/tencent/ecommerce/repo/register/ECMsgBox;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "msgBoxInfo", "Landroid/app/Activity;", ExifInterface.LATITUDE_SOUTH, "Landroid/app/Activity;", "l0", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/repo/register/ECMsgBox;Landroid/app/Activity;)V", "T", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMsgBoxDialog extends g {

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isDisabled;

    /* renamed from: R, reason: from kotlin metadata */
    private final com.tencent.ecommerce.repo.register.ECMsgBox msgBoxInfo;

    /* renamed from: S, reason: from kotlin metadata */
    private Activity activity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/common/ECMsgBoxDialog$resetClickListener$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECMsgBoxDialog.this.Q();
            Activity activity = ECMsgBoxDialog.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/common/ECMsgBoxDialog$resetClickListener$1$2"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECMsgBoxDialog.this.Q();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/common/ECMsgBoxDialog$resetClickListener$2$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECMsgBoxDialog.this.U();
            Activity activity = ECMsgBoxDialog.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/common/ECMsgBoxDialog$resetClickListener$2$2"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECMsgBoxDialog.this.U();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECMsgBoxDialog(Context context, com.tencent.ecommerce.repo.register.ECMsgBox eCMsgBox, Activity activity) {
        super(context);
        this.msgBoxInfo = eCMsgBox;
        this.activity = activity;
        m0();
        p0();
        cg0.a.b("ECMsgBoxDialog", "[onCreate] msgBoxJsonData = " + eCMsgBox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(String url, boolean isRightBtn) {
        cg0.a.b("ECMsgBoxDialog", "[defaultCallback] url = " + url + ", isRightBtn = " + isRightBtn);
        if (url != null && (url.hashCode() != 0 || !url.equals(""))) {
            ECScheme.g(url, null, 2, null);
            this.isDisabled = true;
        } else if (isRightBtn) {
            this.isDisabled = true;
        }
    }

    private final void m0() {
        String str;
        String str2;
        setTitle(this.msgBoxInfo.title);
        Y(this.msgBoxInfo.text);
        ECMsgBoxBtn eCMsgBoxBtn = this.msgBoxInfo.leftBtn;
        String str3 = "";
        if (eCMsgBoxBtn == null || (str = eCMsgBoxBtn.text) == null) {
            str = "";
        }
        b0(str);
        ECMsgBoxBtn rightBtn = this.msgBoxInfo.getRightBtn();
        if (rightBtn != null && (str2 = rightBtn.text) != null) {
            str3 = str2;
        }
        f0(str3);
    }

    private final void o0() {
        ECMsgBoxBtn eCMsgBoxBtn = this.msgBoxInfo.leftBtn;
        if (eCMsgBoxBtn != null) {
            if (eCMsgBoxBtn.shouldPopPage) {
                S().setOnClickListener(new b());
            }
            if (eCMsgBoxBtn.getShouldKeepMsgBox()) {
                S().setOnClickListener(new c());
            }
        }
        ECMsgBoxBtn rightBtn = this.msgBoxInfo.getRightBtn();
        if (rightBtn != null) {
            if (rightBtn.shouldPopPage) {
                X().setOnClickListener(new d());
            }
            if (rightBtn.getShouldKeepMsgBox()) {
                X().setOnClickListener(new e());
            }
        }
    }

    private final void p0() {
        a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.common.ECMsgBoxDialog$setDefaultClickCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                com.tencent.ecommerce.repo.register.ECMsgBox eCMsgBox;
                ECMsgBoxDialog eCMsgBoxDialog = ECMsgBoxDialog.this;
                eCMsgBox = eCMsgBoxDialog.msgBoxInfo;
                ECMsgBoxBtn eCMsgBoxBtn = eCMsgBox.leftBtn;
                ECMsgBoxDialog.k0(eCMsgBoxDialog, eCMsgBoxBtn != null ? eCMsgBoxBtn.url : null, false, 2, null);
            }
        });
        e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.common.ECMsgBoxDialog$setDefaultClickCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                com.tencent.ecommerce.repo.register.ECMsgBox eCMsgBox;
                ECMsgBoxDialog eCMsgBoxDialog = ECMsgBoxDialog.this;
                eCMsgBox = eCMsgBoxDialog.msgBoxInfo;
                ECMsgBoxBtn rightBtn = eCMsgBox.getRightBtn();
                eCMsgBoxDialog.j0(rightBtn != null ? rightBtn.url : null, true);
            }
        });
    }

    /* renamed from: l0, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    /* renamed from: n0, reason: from getter */
    public final boolean getIsDisabled() {
        return this.isDisabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ecommerce.base.ui.g, android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        o0();
    }

    public final void q0(boolean z16) {
        this.isDisabled = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k0(ECMsgBoxDialog eCMsgBoxDialog, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        eCMsgBoxDialog.j0(str, z16);
    }
}
