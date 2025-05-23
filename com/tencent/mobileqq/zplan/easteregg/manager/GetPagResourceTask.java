package com.tencent.mobileqq.zplan.easteregg.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.zplan.easteregg.EasterEggPagConfigRepo;
import com.tencent.mobileqq.zplan.easteregg.a;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0002J\u001e\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016R\"\u0010\u0014\u001a\u00020\r8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/manager/GetPagResourceTask;", "Lcom/tencent/mobileqq/zplan/easteregg/manager/f;", "Lcom/tencent/mobileqq/zplan/easteregg/model/c;", "Lcom/tencent/mobileqq/zplan/easteregg/manager/h;", "params", "Lcom/tencent/mobileqq/zplan/easteregg/manager/g;", "listener", "", "needRetry", "", "e", "c", "d", "", "a", "I", "getType", "()I", "setType", "(I)V", "type", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GetPagResourceTask implements f<com.tencent.mobileqq.zplan.easteregg.model.c, IEasterEggResourceTaskResult> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int type = 2;

    private final void c(final com.tencent.mobileqq.zplan.easteregg.model.c params, final g<IEasterEggResourceTaskResult> listener) {
        com.tencent.mobileqq.zplan.easteregg.a aVar = params.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        if (aVar == null) {
            QLog.i("GetPagResourceTask", 1, "GetPagResourceTask config is empty");
            listener.a(4, null);
        } else {
            EasterEggPagConfigRepo.f332820a.k(aVar, aVar.getIsMale(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.easteregg.manager.GetPagResourceTask$downloadAndRetry$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                        GetPagResourceTask.this.e(params, listener, false);
                    } else {
                        listener.a(4, null);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.manager.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(com.tencent.mobileqq.zplan.easteregg.model.c params, g<IEasterEggResourceTaskResult> listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(listener, "listener");
        e(params, listener, true);
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.manager.f
    public int getType() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(com.tencent.mobileqq.zplan.easteregg.model.c params, g<IEasterEggResourceTaskResult> listener, boolean needRetry) {
        a.C9169a femalePagResourcePath;
        String avatarPath;
        String atmospherePath;
        String reverseFullScreenPath;
        com.tencent.mobileqq.zplan.easteregg.a aVar = params.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        if (aVar == null) {
            QLog.i("GetPagResourceTask", 1, "GetPagResourceTask config is empty");
            listener.a(4, null);
            return;
        }
        IEasterEggResourceTaskResult iEasterEggResourceTaskResult = new IEasterEggResourceTaskResult(null, null, null, null, null, null, 63, null);
        if (aVar.getIsMale()) {
            femalePagResourcePath = aVar.getMalePagResourcePath();
        } else {
            femalePagResourcePath = aVar.getFemalePagResourcePath();
        }
        if ((params.getAvatarScale() == -1.0f) && !TextUtils.isEmpty(femalePagResourcePath.getReverseAvatarPath())) {
            params.w(1.0f);
            avatarPath = femalePagResourcePath.getReverseAvatarPath();
        } else {
            avatarPath = femalePagResourcePath.getAvatarPath();
        }
        iEasterEggResourceTaskResult.h(avatarPath);
        if ((params.getAtmosphereScale() == -1.0f) && !TextUtils.isEmpty(femalePagResourcePath.getReverseAtmospherePath())) {
            params.u(1.0f);
            atmospherePath = femalePagResourcePath.getReverseAtmospherePath();
        } else {
            atmospherePath = femalePagResourcePath.getAtmospherePath();
        }
        iEasterEggResourceTaskResult.g(atmospherePath);
        if (TextUtils.isEmpty(femalePagResourcePath.getReverseFullScreenPath())) {
            reverseFullScreenPath = femalePagResourcePath.getFullScreenPath();
        } else {
            reverseFullScreenPath = femalePagResourcePath.getReverseFullScreenPath();
        }
        iEasterEggResourceTaskResult.j(reverseFullScreenPath);
        if (TextUtils.isEmpty(iEasterEggResourceTaskResult.getAvatarPagAnimationPath())) {
            QLog.i("GetPagResourceTask", 1, "GetPagResourceTask avatarPagAnimationPath is empty");
            if (needRetry) {
                c(params, listener);
                return;
            } else {
                listener.a(4, null);
                return;
            }
        }
        QLog.i("GetPagResourceTask", 1, "checkPagResource ready");
        listener.a(0, iEasterEggResourceTaskResult);
    }
}
