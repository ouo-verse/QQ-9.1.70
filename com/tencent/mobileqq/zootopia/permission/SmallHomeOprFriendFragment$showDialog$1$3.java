package com.tencent.mobileqq.zootopia.permission;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.view.z;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "status", "", "errCode", "errMsg", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SmallHomeOprFriendFragment$showDialog$1$3 extends Lambda implements Function3<Integer, Integer, String, Unit> {
    final /* synthetic */ hw4.j $delete;
    final /* synthetic */ long $uin;
    final /* synthetic */ SmallHomeOprFriendFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmallHomeOprFriendFragment$showDialog$1$3(SmallHomeOprFriendFragment smallHomeOprFriendFragment, hw4.j jVar, long j3) {
        super(3);
        this.this$0 = smallHomeOprFriendFragment;
        this.$delete = jVar;
        this.$uin = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
    
        r0 = r3.loadingDialog;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(SmallHomeOprFriendFragment this$0, int i3, long j3, int i16, String str) {
        c cVar;
        z zVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (((activity == null || activity.isFinishing()) ? false : true) && zVar != null) {
            zVar.dismiss();
        }
        if (i3 == 1) {
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 != null) {
                activity2.setResult(-1);
            }
            cVar = this$0.adapter;
            if (cVar != null) {
                cVar.p0(j3);
            }
            this$0.Gh(false);
            return;
        }
        QQToast.makeText(this$0.getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
        QLog.e("SmallHomeOprFriendFragment", 1, "deleteFriend errCode:" + i16 + ", errMsg:" + str);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, String str) {
        invoke(num.intValue(), num2.intValue(), str);
        return Unit.INSTANCE;
    }

    public final void invoke(final int i3, final int i16, final String str) {
        ArrayList arrayList;
        arrayList = this.this$0.list;
        arrayList.remove(this.$delete);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final SmallHomeOprFriendFragment smallHomeOprFriendFragment = this.this$0;
        final long j3 = this.$uin;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.permission.i
            @Override // java.lang.Runnable
            public final void run() {
                SmallHomeOprFriendFragment$showDialog$1$3.b(SmallHomeOprFriendFragment.this, i3, j3, i16, str);
            }
        });
    }
}
