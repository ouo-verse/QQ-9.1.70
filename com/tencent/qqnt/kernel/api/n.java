package com.tencent.qqnt.kernel.api;

import com.tencent.qqnt.kernel.nativeinterface.GetAIGCEmojiListReq;
import com.tencent.qqnt.kernel.nativeinterface.ICheckImageCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAIGCEmojiListCallback;
import com.tencent.qqnt.kernel.nativeinterface.PicMaterial;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J*\u0010\u000f\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/kernel/api/n;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAIGCEmojiListReq;", "req", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAIGCEmojiListCallback;", "cb", "", "getAIGCEmojiList", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/PicMaterial;", "Lkotlin/collections/ArrayList;", "imageList", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckImageCallback;", "checkImage", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface n extends j {
    void checkImage(@NotNull ArrayList<PicMaterial> imageList, @Nullable ICheckImageCallback cb5);

    void getAIGCEmojiList(@NotNull GetAIGCEmojiListReq req, boolean force, @Nullable IGetAIGCEmojiListCallback cb5);
}
