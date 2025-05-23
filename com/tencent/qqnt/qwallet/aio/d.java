package com.tencent.qqnt.qwallet.aio;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.aio.festival.FestivalView;
import com.tencent.qqnt.qwallet.aio.hb.CommandHbView;
import com.tencent.qqnt.qwallet.aio.hb.LuckyHbView;
import com.tencent.qqnt.qwallet.aio.hb.NormalHbView;
import com.tencent.qqnt.qwallet.aio.hb.OneStrokeHbView;
import com.tencent.qqnt.qwallet.aio.hb.SpecifyHbView;
import com.tencent.qqnt.qwallet.aio.hb.UnsupportedView;
import com.tencent.qqnt.qwallet.aio.hb.VoiceHbView;
import com.tencent.qqnt.qwallet.aio.pay.AAPayMsgView;
import com.tencent.qqnt.qwallet.aio.pay.FriendPayMsgView;
import com.tencent.qqnt.qwallet.aio.pay.TransferMsgView;
import f81.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J*\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/d;", "", "", QQBrowserActivity.KEY_MSG_TYPE, "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/qwallet/aio/AIOContentView;", "b", "c", "", "d", "", "listId", "Landroid/view/View;", "oldView", "a", "Ljava/lang/Boolean;", "recycleHbViewSwitch", "Ljava/lang/String;", "lastUpdateSwitchUin", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f361713a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean recycleHbViewSwitch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String lastUpdateSwitchUin;

    d() {
    }

    private final AIOContentView b(int msgType, Context context) {
        if (msgType != 2) {
            if (msgType != 3) {
                if (msgType != 6) {
                    if (msgType != 7 && msgType != 8) {
                        if (msgType != 15) {
                            if (msgType != 20) {
                                switch (msgType) {
                                    case 11:
                                    case 12:
                                        break;
                                    case 13:
                                        break;
                                    default:
                                        return new UnsupportedView(context);
                                }
                            } else {
                                return new OneStrokeHbView(context);
                            }
                        }
                        return new VoiceHbView(context);
                    }
                    return new SpecifyHbView(context);
                }
                return new CommandHbView(context);
            }
            return new LuckyHbView(context);
        }
        return new NormalHbView(context);
    }

    private final AIOContentView c(int msgType, Context context) {
        if (msgType != 1) {
            if (msgType != 16) {
                if (msgType != 9) {
                    if (msgType != 10) {
                        return new UnsupportedView(context);
                    }
                    return new FriendPayMsgView(context);
                }
                return new FriendPayMsgView(context);
            }
            return new AAPayMsgView(context);
        }
        return new TransferMsgView(context);
    }

    private final boolean d() {
        String c16 = com.tencent.mobileqq.base.a.c();
        Boolean bool = recycleHbViewSwitch;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (Intrinsics.areEqual(c16, lastUpdateSwitchUin)) {
                return booleanValue;
            }
        }
        boolean isSwitchOn = ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_RECYCLE_HB_VIEW);
        recycleHbViewSwitch = Boolean.valueOf(isSwitchOn);
        lastUpdateSwitchUin = c16;
        return isSwitchOn;
    }

    @NotNull
    public final AIOContentView a(int msgType, @Nullable String listId, @Nullable View oldView, @NotNull Context context) {
        AIOContentView unsupportedView;
        Intrinsics.checkNotNullParameter(context, "context");
        if (oldView instanceof AIOContentView) {
            AIOContentView aIOContentView = (AIOContentView) oldView;
            if (Intrinsics.areEqual(aIOContentView.getTag(R.id.x7k), Integer.valueOf(msgType)) && (d() || Intrinsics.areEqual(aIOContentView.getTag(R.id.x7j), listId))) {
                QLog.d("WalletNT-ContentViewFactory", 1, "getContentView: use cached view msgType " + msgType + ", oldView " + oldView);
                return aIOContentView;
            }
        }
        if (f.b(msgType)) {
            unsupportedView = b(msgType, context);
        } else if (f.d(msgType)) {
            unsupportedView = c(msgType, context);
        } else if (f.a(msgType)) {
            unsupportedView = new FestivalView(context);
        } else {
            unsupportedView = new UnsupportedView(context);
        }
        unsupportedView.setTag(R.id.x7k, Integer.valueOf(msgType));
        unsupportedView.setTag(R.id.x7j, listId);
        return unsupportedView;
    }
}
