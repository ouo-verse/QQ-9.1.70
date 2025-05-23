package com.tencent.mobileqq.guild.feed.nativepublish.utils;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\"\u001f\u0010\u0001\u001a\u00020\u0000*\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"!\u0010\u000b\u001a\u0004\u0018\u00010\u0002*\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n*F\b\u0000\u0010\u000f\u001a\u0004\b\u0000\u0010\f\u001a\u0004\b\u0001\u0010\r\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002`\u00060\u000e2\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u000e*F\b\u0000\u0010\u0011\u001a\u0004\b\u0000\u0010\f\u001a\u0004\b\u0001\u0010\r\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002`\u00060\u00102\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0010*\n\u0010\u0013\"\u00020\u00122\u00020\u0012*\n\u0010\u0015\"\u00020\u00142\u00020\u0014*\u0016\u0010\u0016\"\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0012\u0004\u0012\u00020\u00050\u0004*0\b\u0000\u0010\u001a\"\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000e2\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000e*0\b\u0000\u0010\u001b\"\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00102\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0010*8\b\u0000\u0010\u001c\"\u0018\u0012\u0006\b\u0001\u0012\u00020\u0017\u0012\u0006\b\u0001\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000e2\u0018\u0012\u0006\b\u0001\u0012\u00020\u0017\u0012\u0006\b\u0001\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000e\u00a8\u0006\u001d"}, d2 = {"", "mainTaskId", "Lin1/d;", "c", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "a", "(Lcom/tencent/base/api/runtime/a;)Ljava/lang/String;", "b", "(Lcom/tencent/base/api/runtime/a;)Lin1/d;", "supportPostFeedMainTaskFacade", "I", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/mvvm/BaseVB;", "EditorBaseVB", "Lcom/tencent/mvi/mvvm/BaseVM;", "EditorBaseVM", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "EditorDraftModel", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "EditorLocalMediaModel", "FeedEditorContext", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mvi/api/runtime/b;", "GenericBaseVB", "GenericBaseVM", "GenericChildBaseVB", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull com.tencent.base.api.runtime.a<zl1.a> aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.h().m();
    }

    @Nullable
    public static final in1.d b(@NotNull com.tencent.base.api.runtime.a<zl1.a> aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return c(a(aVar));
    }

    @Nullable
    public static final in1.d c(@NotNull String mainTaskId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IFeedPublishServiceV2.class, "");
        } else {
            iRuntimeService = null;
        }
        IFeedPublishServiceV2 iFeedPublishServiceV2 = (IFeedPublishServiceV2) iRuntimeService;
        if (iFeedPublishServiceV2 == null) {
            return null;
        }
        return iFeedPublishServiceV2.getPostFeedMainTaskFacade(mainTaskId);
    }
}
