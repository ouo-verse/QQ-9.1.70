package com.tencent.biz.qqcircle.comment.emoji;

import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.data.EmoticonTabInfo;
import com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/emoji/x;", "Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService$UpdateEmoticonInfoCallback;", "", "success", "", "Lcom/tencent/mobileqq/emoticon/data/EmoticonTabInfo;", "tabInfoList", "", "onComplete", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qqcircle/comment/emoji/a;", "a", "Ljava/lang/ref/WeakReference;", "getCallBack", "()Ljava/lang/ref/WeakReference;", "callBack", "", "b", "I", "getEmotiConCount", "()I", "setEmotiConCount", "(I)V", "emotiConCount", "<init>", "(Ljava/lang/ref/WeakReference;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class x implements IEmoticonDataService.UpdateEmoticonInfoCallback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final WeakReference<a> callBack;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int emotiConCount;

    public x(@Nullable WeakReference<a> weakReference, int i3) {
        this.callBack = weakReference;
        this.emotiConCount = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(x this$0) {
        a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<a> weakReference = this$0.callBack;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.a(this$0.emotiConCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(x this$0) {
        a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<a> weakReference = this$0.callBack;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.a(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0023 A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService.UpdateEmoticonInfoCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onComplete(boolean success, @NotNull List<? extends EmoticonTabInfo> tabInfoList) {
        Object firstOrNull;
        List<EmoticonInfo> emoticons;
        boolean z16;
        Intrinsics.checkNotNullParameter(tabInfoList, "tabInfoList");
        if (success) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) tabInfoList);
            EmoticonTabInfo emoticonTabInfo = (EmoticonTabInfo) firstOrNull;
            int i3 = 0;
            if (emoticonTabInfo != null && (emoticons = emoticonTabInfo.getEmoticons()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : emoticons) {
                    Parcelable parcelable = (EmoticonInfo) obj;
                    if (parcelable instanceof IFavoriteEmoticonInfo) {
                        IFavoriteEmoticonInfo iFavoriteEmoticonInfo = (IFavoriteEmoticonInfo) parcelable;
                        if (!TextUtils.isEmpty(iFavoriteEmoticonInfo.getUrl()) && e.f83623a.g(iFavoriteEmoticonInfo.getPath())) {
                            z16 = true;
                            if (!z16) {
                                arrayList.add(obj);
                            }
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                }
                i3 = arrayList.size();
            }
            this.emotiConCount = i3;
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.v
                @Override // java.lang.Runnable
                public final void run() {
                    x.c(x.this);
                }
            });
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.w
                @Override // java.lang.Runnable
                public final void run() {
                    x.d(x.this);
                }
            });
        }
        QLog.d("QFSCommentEmojiDataConfig", 1, "success " + tabInfoList.size());
    }
}
