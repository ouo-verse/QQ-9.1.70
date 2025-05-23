package com.tencent.biz.qqcircle.comment.emoji;

import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\f\u001a\u00020\u0007R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/emoji/e;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qqcircle/comment/emoji/a;", "callBack", "", "forceUpdate", "", "d", "", "emojiPath", "g", "c", "", "b", "I", "emojiCount", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f83623a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int emojiCount = -1;

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(boolean z16, final WeakReference weakReference) {
        List<CustomEmotionData> emoticonDataList;
        boolean z17;
        final Ref.IntRef intRef = new Ref.IntRef();
        int i3 = 0;
        if (!z16 && (emoticonDataList = ((IFavroamingDBManagerService) QCircleServiceImpl.getAppInterface().getRuntimeService(IFavroamingDBManagerService.class, "")).getEmoticonDataList()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : emoticonDataList) {
                CustomEmotionData customEmotionData = (CustomEmotionData) obj;
                if (!customEmotionData.isMarkFace && !TextUtils.isEmpty(customEmotionData.url) && f83623a.g(customEmotionData.emoPath)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(obj);
                }
            }
            i3 = arrayList.size();
        }
        intRef.element = i3;
        if (i3 == 0) {
            ((IEmoticonDataService) QCircleServiceImpl.getAppInterface().getRuntimeService(IEmoticonDataService.class, "all")).updateEmoticonInfo(5, new x(weakReference, intRef.element));
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.f(weakReference, intRef);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(WeakReference weakReference, Ref.IntRef emotiConCount) {
        a aVar;
        Intrinsics.checkNotNullParameter(emotiConCount, "$emotiConCount");
        if (weakReference != null && (aVar = (a) weakReference.get()) != null) {
            aVar.a(emotiConCount.element);
        }
    }

    public final void c() {
        emojiCount = -1;
    }

    public final void d(@Nullable final WeakReference<a> callBack, final boolean forceUpdate) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.c
            @Override // java.lang.Runnable
            public final void run() {
                e.e(forceUpdate, callBack);
            }
        });
    }

    public final boolean g(@Nullable String emojiPath) {
        if (!ud2.a.f438849a.e()) {
            if (emojiPath == null) {
                emojiPath = "";
            }
            if (GifDrawable.isGifFile(new File(emojiPath))) {
                return false;
            }
            return true;
        }
        return true;
    }
}
