package com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor;

import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.matchfriend.reborn.mark.config.b;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\t\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\f\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/preprocessor/QQStrangerInteractiveMarkPreprocessor;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/preprocessor/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "", "", "coupleMap", "Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/a;", DownloadInfo.spKey_Config, "", "c", "Lkotlin/Function0;", "finish", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerInteractiveMarkPreprocessor implements a<QQStrangerInteractiveMarkModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public final void c(Map<String, ? extends QQStrangerInteractiveMarkModel> coupleMap, com.tencent.mobileqq.matchfriend.reborn.mark.config.a config) {
        Iterator<Map.Entry<String, ? extends QQStrangerInteractiveMarkModel>> it = coupleMap.entrySet().iterator();
        while (it.hasNext()) {
            QQStrangerInteractiveMarkModel value = it.next().getValue();
            value.setResBaseUrl(config.getResBaseUrl());
            List<com.tencent.mobileqq.matchfriend.reborn.couple.model.a> list = config.a().get(Integer.valueOf(Integer.parseInt(value.subtype)));
            if (list == null) {
                return;
            } else {
                value.setMarkConfigList(list);
            }
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.a
    public void a(final Map<String, ? extends QQStrangerInteractiveMarkModel> coupleMap, final Function0<Unit> finish) {
        Intrinsics.checkNotNullParameter(coupleMap, "coupleMap");
        Intrinsics.checkNotNullParameter(finish, "finish");
        b bVar = b.f245190a;
        if (bVar.c().c()) {
            c(coupleMap, bVar.c());
            finish.invoke();
        } else {
            bVar.f(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.QQStrangerInteractiveMarkPreprocessor$onPreProcessor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                        QQStrangerInteractiveMarkPreprocessor.this.c(coupleMap, b.f245190a.c());
                    } else {
                        QLog.e("NotifyPreprocessor[onPreProcessor]", 1, "initConfigFirst failed.");
                    }
                    finish.invoke();
                }
            });
        }
    }
}
