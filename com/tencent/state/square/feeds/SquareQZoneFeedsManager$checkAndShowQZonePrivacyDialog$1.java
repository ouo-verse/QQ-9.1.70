package com.tencent.state.square.feeds;

import android.app.Application;
import android.content.Context;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.utils.TimeFormatUtils;
import com.tencent.state.view.SquareQZonePrivacyDialog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareQZoneFeedsManager$checkAndShowQZonePrivacyDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareQZoneFeedsManager$checkAndShowQZonePrivacyDialog$1(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final long currentTimeMillis = System.currentTimeMillis();
        long decodeLong$default = IMMKV.DefaultImpls.decodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Privacy.QZONE_PRIVACY_DIALOG_SHOW_TIME, 0L, null, false, 12, null);
        if (decodeLong$default == 0 || TimeFormatUtils.INSTANCE.getTimeDistance(new Date(decodeLong$default), new Date(currentTimeMillis)) >= Square.INSTANCE.getConfig().getCommonUtils().getQZonePrivacyDialogShowLimitDay()) {
            SquareQZoneFeedsManager.INSTANCE.queryQZonePrivacy(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.feeds.SquareQZoneFeedsManager$checkAndShowQZonePrivacyDialog$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (z16) {
                        return;
                    }
                    IMMKV.DefaultImpls.encodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Privacy.QZONE_PRIVACY_DIALOG_SHOW_TIME, currentTimeMillis, null, false, 12, null);
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.feeds.SquareQZoneFeedsManager.checkAndShowQZonePrivacyDialog.1.1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            SquareQZonePrivacyDialog squareQZonePrivacyDialog = new SquareQZonePrivacyDialog(SquareQZoneFeedsManager$checkAndShowQZonePrivacyDialog$1.this.$context);
                            squareQZonePrivacyDialog.setPositiveCallback(new Function0<Unit>() { // from class: com.tencent.state.square.feeds.SquareQZoneFeedsManager.checkAndShowQZonePrivacyDialog.1.1.1.1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    SquareQZoneFeedsManager.INSTANCE.updateQZonePrivacy(true, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.feeds.SquareQZoneFeedsManager.checkAndShowQZonePrivacyDialog.1.1.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean z17) {
                                            Square square;
                                            Application application;
                                            if (!z17 || (application = (square = Square.INSTANCE).getApplication()) == null) {
                                                return;
                                            }
                                            square.getConfig().getCommonUtils().showToast(application, "\u6388\u6743\u6210\u529f", 2);
                                        }
                                    });
                                }
                            });
                            squareQZonePrivacyDialog.show();
                        }
                    });
                }
            });
        }
    }
}
