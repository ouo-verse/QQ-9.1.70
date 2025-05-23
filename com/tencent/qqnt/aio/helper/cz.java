package com.tencent.qqnt.aio.helper;

import android.content.DialogInterface;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqnt.aio.helper.cz;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/helper/cz;", "Lcom/tencent/aio/main/businesshelper/h;", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mobileqq/paiyipai/a;", "e", "Lcom/tencent/mobileqq/paiyipai/a;", "mPaiYiPaiObserver", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class cz implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.paiyipai.a mPaiYiPaiObserver = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/cz$a", "Lcom/tencent/mobileqq/paiyipai/a;", "", "isSuccess", "", "data", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends com.tencent.mobileqq.paiyipai.a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }

        @Override // com.tencent.mobileqq.paiyipai.a
        public void a(boolean isSuccess, int data) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (data != 1008 || qBaseActivity == null) {
                return;
            }
            QQCustomDialog positiveButton = DialogUtil.createCustomDialog(qBaseActivity, 230).setMessage(qBaseActivity.getString(R.string.f173192sh)).setPositiveButton(R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.cy
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    cz.a.d(dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(positiveButton, "createCustomDialog(conte\u2026, _ -> dialog.dismiss() }");
            positiveButton.show();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350662p0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "PaiYiPaiNTHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mAIOContext = param.a();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (state == 4) {
            qQAppInterface.addObserver(this.mPaiYiPaiObserver);
        } else {
            if (state != 12) {
                return;
            }
            qQAppInterface.removeObserver(this.mPaiYiPaiObserver);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{4, 12};
    }
}
