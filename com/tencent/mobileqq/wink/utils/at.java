package com.tencent.mobileqq.wink.utils;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/at;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class at {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final at f326687a = new at();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/utils/at$a", "Lcom/tencent/mobileqq/wink/editor/extractor/ExtractCoverHelper$a;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "result", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements ExtractCoverHelper.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<LocalMediaInfo> f326688a;

        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends LocalMediaInfo> list) {
            this.f326688a = list;
        }

        @Override // com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper.a
        public void a(@NotNull ArrayList<byte[]> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            WinkDataServiceHandler a16 = com.tencent.mobileqq.wink.edit.manager.e.a();
            if (a16 != null) {
                a16.o3(this.f326688a, result, 2);
            }
        }
    }

    at() {
    }

    public final void a(@NotNull List<? extends LocalMediaInfo> localMediaInfos) {
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        ExtractCoverHelper.f320276a.D(localMediaInfos, new a(localMediaInfos));
    }
}
