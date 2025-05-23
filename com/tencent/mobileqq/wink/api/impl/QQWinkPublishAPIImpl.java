package com.tencent.mobileqq.wink.api.impl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkPublishAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JO\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0013H\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/QQWinkPublishAPIImpl;", "Lcom/tencent/mobileqq/wink/api/IQQWinkPublishAPI;", "()V", "publishFeedByEditDraft", "", "publishSource", "", "missionId", "", "content", "extras", "Landroid/os/Bundle;", "publishFeedWithRecommendMusic", "mediaPaths", "", "publishTextContent", "realPublish", "publishType", "processIntent", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ParameterName;", "name", "intent", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QQWinkPublishAPIImpl implements IQQWinkPublishAPI {
    private final void realPublish(int publishSource, String publishType, String content, Bundle extras, Function1<? super Intent, Unit> processIntent) {
        Intent intent = new Intent(MobileQQ.sMobileQQ.getApplicationContext(), (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 11);
        intent.putExtra(QQWinkConstants.WINK_PUBLISH_SOURCE, publishSource);
        intent.putExtra(QQWinkConstants.WINK_PUBLISH_TYPE, publishType);
        intent.putExtra(QQWinkConstants.WINK_PUBLISH_PARAM_CONTENT, content);
        processIntent.invoke(intent);
        MobileQQ.sMobileQQ.getApplicationContext().startService(intent);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkPublishAPI
    public void publishFeedByEditDraft(int publishSource, @NotNull final String missionId, @Nullable String content, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        realPublish(publishSource, QQWinkConstants.WINK_PUBLISH_BY_EDIT_DRAFT, content, extras, new Function1<Intent, Unit>() { // from class: com.tencent.mobileqq.wink.api.impl.QQWinkPublishAPIImpl$publishFeedByEditDraft$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Intent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.putExtra(QQWinkConstants.MISSION_ID, missionId);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkPublishAPI
    public void publishFeedWithRecommendMusic(int publishSource, @NotNull final List<String> mediaPaths, @Nullable String content, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(mediaPaths, "mediaPaths");
        realPublish(publishSource, QQWinkConstants.WINK_PUBLISH_WITH_RECOMMEND_MUSIC, content, extras, new Function1<Intent, Unit>() { // from class: com.tencent.mobileqq.wink.api.impl.QQWinkPublishAPIImpl$publishFeedWithRecommendMusic$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Intent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.putStringArrayListExtra(QQWinkConstants.WINK_PUBLISH_PARAM_MEDIA_PATH_LIST, new ArrayList<>(mediaPaths));
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkPublishAPI
    public void publishTextContent(int publishSource, @NotNull String content, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(content, "content");
        realPublish(publishSource, QQWinkConstants.WINK_PUBLISH_CONTENT_TEXT, content, extras, new Function1<Intent, Unit>() { // from class: com.tencent.mobileqq.wink.api.impl.QQWinkPublishAPIImpl$publishTextContent$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Intent it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }
        });
    }
}
