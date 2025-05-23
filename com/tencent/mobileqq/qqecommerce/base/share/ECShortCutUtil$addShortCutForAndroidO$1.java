package com.tencent.mobileqq.qqecommerce.base.share;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import com.tencent.ecommerce.base.share.api.IECAddShortCutCallback;
import com.tencent.ecommerce.base.share.api.ShortCutInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.base.share.ECShortCutUtil$addShortCutForAndroidO$1", f = "ECShortCutUtil.kt", i = {0, 0}, l = {111}, m = "invokeSuspend", n = {"hasAddedShortCut", "broadcastReceiver"}, s = {"L$0", "L$1"})
/* loaded from: classes35.dex */
public final class ECShortCutUtil$addShortCutForAndroidO$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ IECAddShortCutCallback $callback;
    final /* synthetic */ ShortCutInfo $shortCutInfo;
    final /* synthetic */ ShortcutManager $shortcutManager;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShortCutUtil$addShortCutForAndroidO$1(Activity activity, ShortcutManager shortcutManager, ShortCutInfo shortCutInfo, IECAddShortCutCallback iECAddShortCutCallback, Continuation<? super ECShortCutUtil$addShortCutForAndroidO$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$shortcutManager = shortcutManager;
        this.$shortCutInfo = shortCutInfo;
        this.$callback = iECAddShortCutCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShortCutUtil$addShortCutForAndroidO$1(this.$activity, this.$shortcutManager, this.$shortCutInfo, this.$callback, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(1:(1:4)(2:17|18))(3:19|(4:21|(1:23)(1:27)|(1:25)|26)|(6:29|(1:31)|9|10|11|12)(2:32|(1:34)(1:35)))|5|(1:7)|8|9|10|11|12) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0107, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0108, code lost:
    
        com.tencent.qphone.base.util.QLog.e("ECShortCutUtil", 1, "unregisterReceiver error", r11);
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        final Ref.BooleanRef booleanRef;
        BroadcastReceiver broadcastReceiver;
        boolean isRequestPinShortcutSupported;
        BroadcastReceiver broadcastReceiver2;
        ShortcutInfo.Builder icon;
        ShortcutInfo.Builder shortLabel;
        ShortcutInfo.Builder longLabel;
        ShortcutInfo.Builder intent;
        ShortcutInfo build;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            booleanRef = new Ref.BooleanRef();
            final ShortCutInfo shortCutInfo = this.$shortCutInfo;
            final IECAddShortCutCallback iECAddShortCutCallback = this.$callback;
            broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qqecommerce.base.share.ECShortCutUtil$addShortCutForAndroidO$1$broadcastReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent2) {
                    Intrinsics.checkNotNullParameter(intent2, "intent");
                    if (Intrinsics.areEqual(intent2.getStringExtra("short_cut_id"), ShortCutInfo.this.getId())) {
                        booleanRef.element = true;
                        ToastUtil.a().e("\u5df2\u521b\u5efa" + ShortCutInfo.this.getShotLabel() + "\u5feb\u6377\u65b9\u5f0f\u5230\u684c\u9762");
                        IECAddShortCutCallback iECAddShortCutCallback2 = iECAddShortCutCallback;
                        if (iECAddShortCutCallback2 != null) {
                            iECAddShortCutCallback2.onCallback(0, "add short cut successfully");
                        }
                    }
                }
            };
            this.$activity.registerReceiver(broadcastReceiver, new IntentFilter("com.tencent.mobileqq.qqecommerce.CreateShortcutSucceedReceiver"));
            isRequestPinShortcutSupported = this.$shortcutManager.isRequestPinShortcutSupported();
            boolean z16 = false;
            if (isRequestPinShortcutSupported) {
                icon = new ShortcutInfo.Builder(this.$activity, this.$shortCutInfo.getId()).setIcon(Icon.createWithBitmap(this.$shortCutInfo.getIcon()));
                shortLabel = icon.setShortLabel(this.$shortCutInfo.getShotLabel());
                String longLabel2 = this.$shortCutInfo.getLongLabel();
                ShortCutInfo shortCutInfo2 = this.$shortCutInfo;
                if (longLabel2.length() == 0) {
                    longLabel2 = shortCutInfo2.getShotLabel();
                }
                longLabel = shortLabel.setLongLabel(longLabel2);
                intent = longLabel.setIntent(this.$shortCutInfo.getIntent());
                build = intent.build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder(activity, shortC\u2026                 .build()");
                Intent intent2 = new Intent("com.tencent.mobileqq.qqecommerce.CreateShortcutSucceedReceiver");
                intent2.putExtra("short_cut_id", this.$shortCutInfo.getId());
                z16 = this.$shortcutManager.requestPinShortcut(build, PendingIntent.getBroadcast(this.$activity, 0, intent2, 201326592).getIntentSender());
            }
            if (!z16) {
                QLog.e("ECShortCutUtil", 1, "can not add short cut");
                ECShortCutUtil eCShortCutUtil = ECShortCutUtil.f262463a;
                Activity activity = this.$activity;
                String qqStr = HardCodeUtil.qqStr(R.string.tg7);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_shortcut_a5ef09f9)");
                eCShortCutUtil.n(activity, qqStr);
                IECAddShortCutCallback iECAddShortCutCallback2 = this.$callback;
                if (iECAddShortCutCallback2 != null) {
                    iECAddShortCutCallback2.onCallback(1, "can not add short cut");
                }
                this.$activity.unregisterReceiver(broadcastReceiver);
                return Unit.INSTANCE;
            }
            this.L$0 = booleanRef;
            this.L$1 = broadcastReceiver;
            this.label = 1;
            if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            broadcastReceiver2 = broadcastReceiver;
        } else if (i3 == 1) {
            broadcastReceiver2 = (ECShortCutUtil$addShortCutForAndroidO$1$broadcastReceiver$1) this.L$1;
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!booleanRef.element) {
            QLog.e("ECShortCutUtil", 1, "user does not add for long time");
        }
        broadcastReceiver = broadcastReceiver2;
        this.$activity.unregisterReceiver(broadcastReceiver);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShortCutUtil$addShortCutForAndroidO$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
