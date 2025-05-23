package com.tencent.mobileqq.zootopia.permission;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.view.z;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "status", "", "errCode", "errMsg", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class SmallHomeOprFriendFragment$onActivityResult$2 extends Lambda implements Function3<Integer, Integer, String, Unit> {
    final /* synthetic */ ArrayList<hw4.j> $friendList;
    final /* synthetic */ SmallHomeOprFriendFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmallHomeOprFriendFragment$onActivityResult$2(SmallHomeOprFriendFragment smallHomeOprFriendFragment, ArrayList<hw4.j> arrayList) {
        super(3);
        this.this$0 = smallHomeOprFriendFragment;
        this.$friendList = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SmallHomeOprFriendFragment this$0) {
        z zVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        zVar = this$0.loadingDialog;
        if (zVar != null) {
            zVar.dismiss();
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, String str) {
        invoke(num.intValue(), num2.intValue(), str);
        return Unit.INSTANCE;
    }

    public final void invoke(int i3, int i16, String str) {
        ArrayList arrayList;
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final SmallHomeOprFriendFragment smallHomeOprFriendFragment = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.permission.h
            @Override // java.lang.Runnable
            public final void run() {
                SmallHomeOprFriendFragment$onActivityResult$2.b(SmallHomeOprFriendFragment.this);
            }
        });
        if (i3 != 1) {
            if (i16 == -22551) {
                QQToast.makeText(this.this$0.getContext(), 1, "\u6dfb\u52a0\u540d\u5355\u8fbe\u5230\u4e0a\u9650", 0).show();
                return;
            } else {
                QQToast.makeText(this.this$0.getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
                return;
            }
        }
        arrayList = this.this$0.list;
        arrayList.addAll(this.$friendList);
        SmallHomeOprFriendFragment.Hh(this.this$0, false, 1, null);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.setResult(-1);
        }
    }
}
