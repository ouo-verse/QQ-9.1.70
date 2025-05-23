package com.tencent.mobileqq.qqshop.publicaccount;

import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqshop.publicaccount.adapter.HeadCardAdapter;
import com.tencent.mobileqq.qqshop.publicaccount.adapter.p;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "msgId", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
final class AIOShopComponentDelegateQQ$bindComponentMsg$headCardAdapter$1 extends Lambda implements Function1<Long, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ArrayList<p> $modelList;
    final /* synthetic */ MsgRecord $msgRecord;
    final /* synthetic */ AIOShopComponentDelegateQQ this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOShopComponentDelegateQQ$bindComponentMsg$headCardAdapter$1(ArrayList<p> arrayList, AIOShopComponentDelegateQQ aIOShopComponentDelegateQQ, MsgRecord msgRecord) {
        super(1);
        this.$modelList = arrayList;
        this.this$0 = aIOShopComponentDelegateQQ;
        this.$msgRecord = msgRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, arrayList, aIOShopComponentDelegateQQ, msgRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, String str) {
        QLog.d("AIOShopComponentDelegate", 1, "setAdSource afterDeleteMsg result=" + i3 + " errMsg=" + str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
        invoke(l3.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j3) {
        ViewPager2 viewPager2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
            return;
        }
        if (this.$modelList.size() <= 1) {
            if (!this.this$0.b(this.$msgRecord)) {
                com.tencent.mobileqq.qqshop.message.d.f274478a.c(j3, new IOperateCallback() { // from class: com.tencent.mobileqq.qqshop.publicaccount.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        AIOShopComponentDelegateQQ$bindComponentMsg$headCardAdapter$1.c(i3, str);
                    }
                });
                return;
            }
            c.f274574a.a(this.$msgRecord.msgId);
            viewPager2 = this.this$0.viewPager;
            if (viewPager2 == null) {
                return;
            }
            viewPager2.setVisibility(8);
            return;
        }
        c.f274574a.a(this.$msgRecord.msgId);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : this.$modelList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            p pVar = (p) obj;
            if (i3 != 0) {
                arrayList.add(pVar);
            }
            i3 = i16;
        }
        HeadCardAdapter headCardAdapter = this.this$0.headCardAdapter;
        if (headCardAdapter != null) {
            headCardAdapter.submitList(arrayList);
        }
    }
}
