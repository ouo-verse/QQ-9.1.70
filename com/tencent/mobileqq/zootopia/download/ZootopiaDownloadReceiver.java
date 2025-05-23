package com.tencent.mobileqq.zootopia.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.download.notification.ZPlanModDownloadNotification;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadRepository;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import si3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ZootopiaDownloadReceiver;", "Landroid/content/BroadcastReceiver;", "", "mapId", "Landroid/content/Context;", "context", "", "e", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "data", "f", "", "id", "g", "Landroid/content/Intent;", "intent", "onReceive", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent = ZootopiaSource.INSTANCE.a(Source.Notification);

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String mapId, Context context) {
        Integer intOrNull;
        ZootopiaSource a16 = ZootopiaSource.INSTANCE.a(Source.Notification);
        Bundle bundle = new Bundle();
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(mapId);
        bundle.putInt("mapId", intOrNull != null ? intOrNull.intValue() : 0);
        bundle.putSerializable(ZootopiaSource.KEY_FRAGMENT_SOURCE, a16);
        ((IEntryApi) QRoute.api(IEntryApi.class)).startDetailFragment(context, a16, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final Context context, final ZootopiaDownloadData data) {
        ZootopiaDownloadRepository zootopiaDownloadRepository = new ZootopiaDownloadRepository();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mobileqq.zootopia.download.ui.d(data));
        zootopiaDownloadRepository.k(arrayList, new Function1<qv4.v, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadReceiver$queryUpdateInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(qv4.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(qv4.v it) {
                pv4.y yVar;
                Intrinsics.checkNotNullParameter(it, "it");
                pv4.y[] yVarArr = it.f430204a;
                Intrinsics.checkNotNullExpressionValue(yVarArr, "it.verControlInfos");
                ZootopiaDownloadData zootopiaDownloadData = ZootopiaDownloadData.this;
                int length = yVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        yVar = null;
                        break;
                    }
                    yVar = yVarArr[i3];
                    if (yVar.f427728a == zootopiaDownloadData.getResData().getId()) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (yVar != null) {
                    ZootopiaDownloadReceiver zootopiaDownloadReceiver = this;
                    Context context2 = context;
                    ZootopiaDownloadData zootopiaDownloadData2 = ZootopiaDownloadData.this;
                    boolean a16 = ZootopiaDownloadManagerFragment.INSTANCE.a();
                    if (yVar.f427736i == 1) {
                        QLog.e("ZootopiaDownloadReceiver", 1, "status invalid " + a16);
                        zootopiaDownloadReceiver.g(context2, R.string.f169775xj2);
                        return;
                    }
                    if (yVar.f427730c == 1) {
                        QLog.e("ZootopiaDownloadReceiver", 1, "status needUpdate " + a16);
                        zootopiaDownloadReceiver.g(context2, R.string.xj8);
                        return;
                    }
                    int i16 = yVar.f427729b;
                    if (i16 == 2) {
                        QLog.e("ZootopiaDownloadReceiver", 1, "status maintain " + a16);
                        zootopiaDownloadReceiver.g(context2, R.string.xix);
                        return;
                    }
                    if (i16 == 1) {
                        QLog.e("ZootopiaDownloadReceiver", 1, "status systemLower " + a16);
                        zootopiaDownloadReceiver.g(context2, R.string.xj7);
                        return;
                    }
                    QLog.i("ZootopiaDownloadReceiver", 1, "status normal " + zootopiaDownloadData2.getResData().getId());
                    c.a.a((si3.c) vb3.a.f441346a.a(si3.c.class), zootopiaDownloadData2.getResData().getId(), ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.Notification, "0", null, 4, null), null, null, 12, null);
                }
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        boolean booleanExtra = intent.getBooleanExtra("zootopia_result", false);
        final String stringExtra = intent.getStringExtra("zootopia_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        int intExtra = intent.getIntExtra("zootopia_op_type", 0);
        QLog.i("ZootopiaDownloadReceiver", 1, "onReceive modId= " + stringExtra + " , result " + booleanExtra + ", actionType= " + intExtra);
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.e("ZootopiaDownloadReceiver", 1, "mapId is empty!");
            return;
        }
        if (intExtra == 1) {
            ZootopiaActivity.Companion.c(ZootopiaActivity.INSTANCE, context, ZootopiaDownloadManagerFragment.class, this.sourceCurrent, null, false, 24, null);
            return;
        }
        if (intExtra == 2) {
            QLog.i("ZootopiaDownloadReceiver", 1, "BEGIN enterMap_" + stringExtra);
            ZootopiaDownloadManager.f327992a.Y(stringExtra, new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadReceiver$onReceive$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                    invoke2(zootopiaDownloadData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                    ZootopiaSource zootopiaSource;
                    ZootopiaResData resData;
                    ZootopiaResData resData2;
                    boolean z16 = false;
                    if (zootopiaDownloadData != null && (resData2 = zootopiaDownloadData.getResData()) != null && resData2.getDownloadStatus() == 5) {
                        z16 = true;
                    }
                    if (!z16) {
                        QLog.e("ZootopiaDownloadReceiver", 1, stringExtra + " downloadStatus is " + ((zootopiaDownloadData == null || (resData = zootopiaDownloadData.getResData()) == null) ? null : Integer.valueOf(resData.getDownloadStatus())));
                        QQToastUtil.showQQToast(1, R.string.f169776xj3);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - zootopiaDownloadData.getResData().getCompleteTime();
                    if (currentTimeMillis > MiniBoxNoticeInfo.MIN_5) {
                        QLog.i("ZootopiaDownloadReceiver", 1, "duration is " + currentTimeMillis + " " + stringExtra + " need queryUpdateInfo");
                        this.f(context, zootopiaDownloadData);
                        return;
                    }
                    QLog.i("ZootopiaDownloadReceiver", 1, "Real enterMap_" + stringExtra);
                    si3.c cVar = (si3.c) vb3.a.f441346a.a(si3.c.class);
                    int parseInt = Integer.parseInt(stringExtra);
                    zootopiaSource = this.sourceCurrent;
                    final ZootopiaDownloadReceiver zootopiaDownloadReceiver = this;
                    final String str = stringExtra;
                    final Context context2 = context;
                    c.a.a(cVar, parseInt, zootopiaSource, null, new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadReceiver$onReceive$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                            invoke2(enterModCheckResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(EnterModCheckResult result) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            if (result.isPassed() || result.getProcessInner()) {
                                return;
                            }
                            ZootopiaDownloadReceiver.this.e(str, context2);
                        }
                    }, 4, null);
                }
            });
            return;
        }
        if (intExtra == 3) {
            QLog.i("ZootopiaDownloadReceiver", 1, "resumeDownload - " + stringExtra);
            ZootopiaDownloadManager.f327992a.I0(stringExtra);
            return;
        }
        if (intExtra != 4) {
            if (intExtra != 5) {
                QLog.e("ZootopiaDownloadReceiver", 1, "onReceive do nothing!");
                return;
            } else {
                ZPlanModDownloadNotification.f328166a.e(stringExtra);
                return;
            }
        }
        QLog.i("ZootopiaDownloadReceiver", 1, "pauseDownload - " + stringExtra);
        ZootopiaDownloadManager.y0(ZootopiaDownloadManager.f327992a, stringExtra, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Context context, int id5) {
        QQToastUtil.showQQToast(1, id5);
        ZootopiaDownloadManagerFragment.Companion companion = ZootopiaDownloadManagerFragment.INSTANCE;
        if (companion.a()) {
            return;
        }
        ZootopiaDownloadManagerFragment.Companion.c(companion, context, this.sourceCurrent, 1, null, 8, null);
    }
}
